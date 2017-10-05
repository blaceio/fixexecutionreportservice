package io.blace.microservices.fixexecutionreportservice.integration.transformers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import io.blace.microservices.fixexecutionreportservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.fixexecutionreportservice.mongo.curveorder.Order;
import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReport;
import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReportRepository;

@Component
public class OrderTransformer {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FIXExecutionReportRepository fixrepo;
	
	public Message<FIXExecutionReport> getallfills(Message<FIXExecutionReport> execreport) {
		
		FIXExecutionReport _execreport = (FIXExecutionReport) execreport.getPayload();
		
		List<FIXExecutionReport> _execreports = fixrepo.findAllByOrderIDAndTradeDate(_execreport.getOrderID(), _execreport.getTradeDate());
		
		double avgSettlePrice = 0.;
		for( FIXExecutionReport report : _execreports ) {
			avgSettlePrice += report.getLastQty() * report.getFlexMarketPrice();
		}
		avgSettlePrice /= _execreport.getOrderQty();
		
		FIXExecutionReport orderreport = new FIXExecutionReport(_execreport);
		orderreport.setFlexMarketPrice(avgSettlePrice);
		
		logger.info("Transformed to: " + orderreport.toString());
		
		return MessageBuilder
				.withPayload(orderreport)
				.build();
	}
	
	public Message<CurveOrder> ertomatchedorder(Message<FIXExecutionReport> execreport) throws ParseException {
		
		FIXExecutionReport _execreport = (FIXExecutionReport) execreport.getPayload();
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		curve.setCcy(_execreport.getCurrency());
		curve.setClient(_execreport.getDeliverToCompID());
		curve.setClientsent(true);
		curve.setNotional(_execreport.getOrderQty());
		curve.setPbsent(true);
		curve.setPrice(_execreport.getFlexMarketPrice());
		curve.setTradedate(_execreport.getTradeDate());
		curve.setTrader(_execreport.getDeliverToSubID());
		curve.setType(_execreport.getSecurityType());
		curve.setValuedate(_execreport.getSettlDate());
		
		Order client = new Order();
		client.setBuy(_execreport.getSide().equals("Sell") ? true : false);
		client.setCcy(_execreport.getCurrency());
		client.setClient(_execreport.getDeliverToCompID());
		client.setClientsent(true);
		client.setNotional(_execreport.getOrderQty());
		client.setPbsent(true);
		client.setPrice(_execreport.getAvgPx());
		client.setTradedate(_execreport.getTradeDate());
		client.setTrader(_execreport.getDeliverToSubID());
		client.setType(_execreport.getSecurityType());
		client.setValuedate(_execreport.getSettlDate());
		
		CurveOrder curveorder = new CurveOrder();
		curveorder.setOrderid(_execreport.getOrderID());
		curveorder.setLegs(new ArrayList<Order>(Arrays.asList(curve, client)));
		curveorder.setMatched(true);
		curveorder.setPair(_execreport.getSymbol());
		
		logger.info("Transformed to: " + curveorder.toString());
		
		return MessageBuilder
				.withPayload(curveorder)
				.setHeader("ismatched", "TRUE")
				.build();
	}
	
	public Message<CurveOrder> ertounmatchedorder(Message<List<FIXExecutionReport>> execreport) throws ParseException {
		
		FIXExecutionReport _execreport = (FIXExecutionReport) execreport.getPayload();
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		curve.setCcy(_execreport.getCurrency());
		curve.setClient(_execreport.getDeliverToCompID());
		curve.setClientsent(true);
		curve.setNotional(_execreport.getOrderQty());
		curve.setPbsent(true);
		curve.setPrice(_execreport.getAvgPx());
		curve.setTradedate(_execreport.getTradeDate());
		curve.setTrader(_execreport.getDeliverToSubID());
		curve.setType(_execreport.getSecurityType());
		curve.setValuedate(_execreport.getSettlDate());
		
		CurveOrder curveorder = new CurveOrder();
		curveorder.setOrderid(_execreport.getOrderID());
		curveorder.setLegs(new ArrayList<Order>(Arrays.asList(curve)));
		curveorder.setMatched(false);
		
		curveorder.setPair(_execreport.getSymbol());
		
		logger.info("Transformed to: " + curveorder.toString());
		
		return MessageBuilder
				.withPayload(curveorder)
				.setHeader("ismatched", "FALSE")
				.build();
	}
}
