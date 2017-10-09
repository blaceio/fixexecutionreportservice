package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

import java.util.ArrayList;
import java.util.List;

import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReport;

public class Order {

	private boolean pbsent;
	private boolean clientsent;
	private boolean buy;
	private double price;
	private List<FIXExecutionReport> fixexecutions;
	
	public Order() {
		this.fixexecutions = new ArrayList<FIXExecutionReport>();
	}
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
	public boolean isBuy() {
		return buy;
	}
	public void setBuy(boolean buy) {
		this.buy = buy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<FIXExecutionReport> getFixexecutions() {
		return fixexecutions;
	}
	public void setFixexecutions(List<FIXExecutionReport> fixexecutions) {
		this.fixexecutions = fixexecutions;
	}
	@Override
	public String toString() {
		return "Order [pbsent=" + pbsent + ", clientsent=" + clientsent + ", buy=" + buy + ", price=" + price
				+ ", fixexecutions=" + fixexecutions + "]";
	}
	
	
}
