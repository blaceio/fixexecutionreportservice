package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	private boolean pbsent;
	private boolean clientsent;
	private String type;
	private String client;
	private boolean buy;
	private double notional;
	private double price;
	private Date tradedate;
	private Date valuedate;
	private String trader;
	private String ccy;
	
	public boolean isPbsent() {
		return pbsent;
	}
	public void setPbsent(boolean pbsent) {
		this.pbsent = pbsent;
	}
	public boolean isClientsent() {
		return clientsent;
	}
	public void setClientsent(boolean clientsent) {
		this.clientsent = clientsent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public double getNotional() {
		return notional;
	}
	public void setNotional(double notional) {
		this.notional = notional;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getCcy() {
		return ccy;
	}
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	@Override
	public String toString() {
		return "Order [pbsent=" + pbsent + ", clientsent=" + clientsent + ", type=" + type
				+ ", client=" + client + ", buy=" + buy + ", notional=" + notional + ", price=" + price + ", tradedate="
				+ tradedate + ", valuedate=" + valuedate + ", trader=" + trader + ", ccy=" + ccy + "]";
	}
	
}
