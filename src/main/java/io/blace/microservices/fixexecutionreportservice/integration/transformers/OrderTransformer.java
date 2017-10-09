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
	
	public Message<List<FIXExecutionReport>> getallfills(Message<FIXExecutionReport> execreport) {
	
		FIXExecutionReport _execreport = (FIXExecutionReport) execreport.getPayload();
	
		List<FIXExecutionReport> _execreports = fixrepo.findAllByOrderIDAndTradeDate(_execreport.getOrderID(), _execreport.getTradeDate());
	
		return MessageBuilder
			.withPayload(_execreports)
			.copyHeaders(execreport.getHeaders())
			.build();
	}
	
	public Message<CurveOrder> ertomatchedorder(Message<List<FIXExecutionReport>> execreports) throws ParseException {
		
		List<FIXExecutionReport> _execreports = (List<FIXExecutionReport>) execreports.getPayload();
		
		FIXExecutionReport _execreport = _execreports.get(0);
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		curve.setClientsent(true);
		curve.setPbsent(true);
		curve.setFixexecutions(_execreports);
		
		Order client = new Order();
		client.setBuy(_execreport.getSide().equals("Sell") ? true : false);
		client.setClientsent(true);
		client.setPbsent(true);
		client.setPrice(_execreport.getAvgPx());
		client.setFixexecutions(_execreports);
		
		CurveOrder curveorder = new CurveOrder();
		curveorder.setOrderid(_execreport.getOrderID());
		curveorder.setLegs(new ArrayList<Order>(Arrays.asList(curve, client)));
		curveorder.setMatched(true);
		curveorder.setPair(_execreport.getSymbol());
		curveorder.setClient(_execreport.getDeliverToCompID());
		curveorder.setQuantity(_execreport.getOrderQty());
		curveorder.setCcy(_execreport.getCurrency());
		curveorder.setTradedate(_execreport.getTradeDate());
		curveorder.setTrader(_execreport.getDeliverToSubID());
		curveorder.setType(_execreport.getSecurityType());
		curveorder.setValuedate(_execreport.getSettlDate());
		
		logger.info("Transformed to: " + curveorder.toString());
		
		return MessageBuilder
				.withPayload(curveorder)
				.setHeader("ismatched", "TRUE")
				.build();
	}
	
	public Message<CurveOrder> updateflexprice(Message<CurveOrder> curveorder) {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		double avgSettlePrice = 0.;
		for( FIXExecutionReport report : _curveorder.getLegs().get(0).getFixexecutions() ) {
			avgSettlePrice += report.getLastQty() * report.getFlexMarketPrice();
		}
		avgSettlePrice /= _curveorder.getQuantity();
		
		_curveorder.getLegs().get(0).setPrice(avgSettlePrice);
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
	public Message<CurveOrder> ertounmatchedorder(Message<List<FIXExecutionReport>> execreports) throws ParseException {
		
		List<FIXExecutionReport> _execreports = (List<FIXExecutionReport>) execreports.getPayload();
		
		FIXExecutionReport _execreport = _execreports.get(0);
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		curve.setClientsent(true);
		curve.setPbsent(true);
		curve.setPrice(_execreport.getAvgPx());
		
		CurveOrder curveorder = new CurveOrder();
		curveorder.setOrderid(_execreport.getOrderID());
		curveorder.setLegs(new ArrayList<Order>(Arrays.asList(curve)));
		curveorder.setMatched(false);
		curveorder.setClient(_execreport.getDeliverToCompID());
		curveorder.setPair(_execreport.getSymbol());
		curveorder.setQuantity(_execreport.getOrderQty());
		curveorder.setCcy(_execreport.getCurrency());
		curveorder.setTradedate(_execreport.getTradeDate());
		curveorder.setTrader(_execreport.getDeliverToSubID());
		curveorder.setType(_execreport.getSecurityType());
		curveorder.setValuedate(_execreport.getSettlDate());
		
		logger.info("Transformed to: " + curveorder.toString());
		
		return MessageBuilder
				.withPayload(curveorder)
				.setHeader("ismatched", "FALSE")
				.build();
	}
}
