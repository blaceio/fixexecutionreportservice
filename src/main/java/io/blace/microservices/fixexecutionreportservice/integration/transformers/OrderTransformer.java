package io.blace.microservices.fixexecutionreportservice.integration.transformers;

import java.text.ParseException;
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
	
	public Message<CurveOrder> ertocurveorder(Message<List<FIXExecutionReport>> execreports) throws ParseException {
		
		List<FIXExecutionReport> _execreports = (List<FIXExecutionReport>) execreports.getPayload();
		
		FIXExecutionReport _execreport = _execreports.get(0);
		
		CurveOrder curveorder = new CurveOrder();
		curveorder.setOrderid(_execreport.getOrderID());
		curveorder.setPair(_execreport.getSymbol());
		curveorder.setClient(_execreport.getDeliverToCompID());
		curveorder.setQuantity(_execreport.getOrderQty());
		curveorder.setCcy(_execreport.getCurrency());
		curveorder.setTradedate(_execreport.getTradeDate());
		curveorder.setTrader(_execreport.getDeliverToSubID());
		curveorder.setType(_execreport.getSecurityType());
		curveorder.setValuedate(_execreport.getSettlDate());
		curveorder.setFixexecutions(_execreports);
		
		logger.info("Transformed to: " + curveorder.toString());
		
		return MessageBuilder
				.withPayload(curveorder)
				.setHeader("client",curveorder.getClient())
				.build();
	}
	
	public Message<CurveOrder> addclientleg(Message<CurveOrder> curveorder) throws ParseException {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		FIXExecutionReport _execreport = _curveorder.getFixexecutions().get(0);
		
		Order client = new Order();
		client.setBuy(_execreport.getSide().equals("Sell") ? true : false);
		client.setPrice(_execreport.getAvgPx());
		
		_curveorder.setClientleg(client);
		
		logger.info("Transformed to: " + _curveorder.toString());
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
	public Message<CurveOrder> addcurveleg(Message<CurveOrder> curveorder) throws ParseException {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		FIXExecutionReport _execreport = _curveorder.getFixexecutions().get(0);
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		
		_curveorder.setExecleg(curve);
		
		logger.info("Transformed to: " + _curveorder.toString());
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
	public Message<CurveOrder> addcurveexecleg(Message<CurveOrder> curveorder) throws ParseException {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		FIXExecutionReport _execreport = _curveorder.getFixexecutions().get(0);
		
		Order curve = new Order();
		curve.setBuy(_execreport.getSide().equals("Buy") ? true : false);
		curve.setPrice(_execreport.getAvgPx());
		
		_curveorder.setExecleg(curve);
		
		logger.info("Transformed to: " + _curveorder.toString());
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
	public Message<CurveOrder> updateexecprice(Message<CurveOrder> curveorder) {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		double avgSettlePrice = 0.;
		for( FIXExecutionReport report : _curveorder.getFixexecutions() ) {
			avgSettlePrice += report.getLastQty() * report.getFlexMarketPrice();
		}
		avgSettlePrice /= _curveorder.getQuantity();
		
		_curveorder.getExecleg().setPrice(avgSettlePrice);
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
	public Message<CurveOrder> setmatched(Message<CurveOrder> curveorder) {
		
		CurveOrder _curveorder = (CurveOrder) curveorder.getPayload();
		
		_curveorder.setMatched(true);
		
		return MessageBuilder
				.withPayload(_curveorder)
				.copyHeaders(curveorder.getHeaders())
				.build();
	}
	
}
