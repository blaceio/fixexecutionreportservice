package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

public class Order {

	private boolean buy;
	private double price;
	
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
	
	@Override
	public String toString() {
		return "Order [buy=" + buy + ", price=" + price + "]";
	}
	
}
