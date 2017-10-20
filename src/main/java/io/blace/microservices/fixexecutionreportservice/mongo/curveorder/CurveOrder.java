package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReport;

public class CurveOrder {

	@Id
	public String id;
	
	private String orderid;
	private String pair;
	private String ccy;
	private boolean matched;
	private Date tradedate;
	private String client;
	private double quantity;
	private Date valuedate;
	private String trader;
	private String type;
	private Order clientleg;
	private Order execleg;
	private List<FIXExecutionReport> fixexecutions;
	
	public CurveOrder() {
		this.matched = false;
		this.fixexecutions = new ArrayList<FIXExecutionReport>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public boolean isMatched() {
		return matched;
	}
	public void setMatched(boolean matched) {
		this.matched = matched;
	}
	public Date getTradedate() {
		return tradedate;
	}
	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}
	public void setTradedate(String tradedate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 this.tradedate = formatter.parse(tradedate); 
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getCcy() {
		return ccy;
	}
	public Date getValuedate() {
		return valuedate;
	}
	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}
	public void setValuedate(String valuedate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 this.valuedate = formatter.parse(valuedate); 
	}
	public String getTrader() {
		return trader;
	}
	public void setTrader(String trader) {
		this.trader = trader;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<FIXExecutionReport> getFixexecutions() {
		return fixexecutions;
	}
	public void setFixexecutions(List<FIXExecutionReport> fixexecutions) {
		this.fixexecutions = fixexecutions;
	}
	public Order getClientleg() {
		return clientleg;
	}
	public void setClientleg(Order clientleg) {
		this.clientleg = clientleg;
	}
	public Order getExecleg() {
		return execleg;
	}
	public void setExecleg(Order execleg) {
		this.execleg = execleg;
	}

	@Override
	public String toString() {
		return "CurveOrder [id=" + id + ", orderid=" + orderid + ", pair=" + pair + ", ccy=" + ccy + ", matched="
				+ matched + ", tradedate=" + tradedate + ", client=" + client + ", quantity=" + quantity
				+ ", valuedate=" + valuedate + ", trader=" + trader + ", type=" + type + ", clientleg=" + clientleg
				+ ", ourleg=" + execleg + ", fixexecutions=" + fixexecutions + "]";
	}
	
}
