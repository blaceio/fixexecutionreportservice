package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class CurveOrder {

	@Id
	public String id;
	
	private String orderid;
	private String pair;
	private boolean matched;
	private List<Order> legs;
	
	public CurveOrder() {
		this.matched = false;
		this.legs = new ArrayList<Order>();
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
	public List<Order> getLegs() {
		return legs;
	}
	public void setLegs(List<Order> legs) {
		this.legs = legs;
	}

	@Override
	public String toString() {
		return "CurveOrder [id=" + id + ", orderid=" + orderid + ", pair=" + pair + ", matched=" + matched + ", legs="
				+ legs + "]";
	}
		
}
