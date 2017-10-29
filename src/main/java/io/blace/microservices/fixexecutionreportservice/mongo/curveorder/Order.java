package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

public class Order {

	private boolean buy;
	private double price;
	private double curveprice;
	
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
	public double getCurveprice() {
		return curveprice;
	}
	public void setCurveprice(double curveprice) {
		this.curveprice = curveprice;
	}
	@Override
	public String toString() {
		return "Order [buy=" + buy + ", price=" + price + ", curveprice=" + curveprice + "]";
	}
	
}
