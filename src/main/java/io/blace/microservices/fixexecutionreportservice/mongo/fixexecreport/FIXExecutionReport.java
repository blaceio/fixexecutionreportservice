package io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport;

import java.util.Date;

import org.springframework.data.annotation.Id;

import quickfix.DoubleField;
import quickfix.FieldNotFound;
import quickfix.field.ContraBroker;
import quickfix.field.DeliverToCompID;
import quickfix.field.DeliverToSubID;
import quickfix.field.PartyID;
import quickfix.field.SenderCompID;
import quickfix.field.SenderLocationID;
import quickfix.field.SendingTime;
import quickfix.field.TargetCompID;
import quickfix.fix44.ExecutionReport;

public class FIXExecutionReport {

	@Id
	public String id;

	private String account;
	private String symbol;
	private double avgPx;
	private String clOrdID;
	private double cumQty;
	private String currency;
	private String execID;
	private double lastPx;
	private double lastQty;
	private String orderID;
	private double orderQty;
	private String ordStatus;
	private String ordType;
	private double price;
	private String side;
	private String timeInForce;
	private Date transactTime;
	private String settlDate;
	private String listID;
	private String tradeDate;
	private String execType;
	private double leavesQty;
	private Date effectiveTime;
	private int noContraBrokers;
	private String secondaryExecID;
	private String partyID;
	private String contraBroker;
	private String sourceSystem;
	private String senderCompID;
	private String targetCompID;
	private String deliverToCompID;
	private String deliverToSubID;
	private String senderLocationID;
	private String sendingTime;
	private String lastCapacity;
	private String securityType;
	private double flexMarketPrice;
	
	public FIXExecutionReport() {
		
	}
	
	public FIXExecutionReport(ExecutionReport er) throws FieldNotFound {
		setAccount(er);
		setSymbol(er);
		setAvgPx(er);
		setClOrdID(er);
		setCumQty(er);
		setCurrency(er);
		setExecID(er);
		setLastPx(er);
		setLastQty(er);
		setOrderID(er);
		setOrderQty(er);
		setOrdStatus(er);
		setOrdType(er);
		setPrice(er);
		setSide(er);
		setTimeInForce(er);
		setTransactTime(er);
		setSettlDate(er);
		setListID(er);
		setTradeDate(er);
		setExecType(er);
		setLeavesQty(er);
		setEffectiveTime(er);
		setNoContraBrokers(er);
		setSecondaryExecID(er);
		setPartyID(er);
		setContraBroker(er);
		setSourceSystem(er);
		setSenderCompID(er);
		setTargetCompID(er);
		setDeliverToCompID(er);
		setDeliverToSubID(er);
		setSenderLocationID(er);
		setSendingTime(er);
		setLastCapacity(er);
		setSecurityType(er);
		setFlexMarketPrice(er);		
	}
	
	public String getId() {
		return id;
	}
	public String getAccount() {
		return account;
	}
	public String getSymbol() {
		return symbol;
	}
	public double getAvgPx() {
		return avgPx;
	}
	public String getClOrdID() {
		return clOrdID;
	}
	public double getCumQty() {
		return cumQty;
	}
	public String getCurrency() {
		return currency;
	}
	public String getExecID() {
		return execID;
	}
	public double getLastPx() {
		return lastPx;
	}
	public double getLastQty() {
		return lastQty;
	}
	public String getOrderID() {
		return orderID;
	}
	public double getOrderQty() {
		return orderQty;
	}
	public String getOrdStatus() {
		return ordStatus;
	}
	public String getOrdType() {
		return ordType;
	}
	public double getPrice() {
		return price;
	}
	public String getSide() {
		return side;
	}
	public String getTimeInForce() {
		return timeInForce;
	}
	public Date getTransactTime() {
		return transactTime;
	}
	public String getSettlDate() {
		return settlDate;
	}
	public String getListID() {
		return listID;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public String getExecType() {
		return execType;
	}
	public double getLeavesQty() {
		return leavesQty;
	}
	public Date getEffectiveTime() {
		return effectiveTime;
	}
	public int getNoContraBrokers() {
		return noContraBrokers;
	}
	public String getSecondaryExecID() {
		return secondaryExecID;
	}
	public String getPartyID() {
		return partyID;
	}
	public String getContraBroker() {
		return contraBroker;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public String getSenderCompID() {
		return senderCompID;
	}
	public String getTargetCompID() {
		return targetCompID;
	}
	public String getDeliverToCompID() {
		return deliverToCompID;
	}
	public String getDeliverToSubID() {
		return deliverToSubID;
	}
	public String getSenderLocationID() {
		return senderLocationID;
	}
	public String getSendingTime() {
		return sendingTime;
	}
	public String getLastCapacity() {
		return lastCapacity;
	}
	public String getSecurityType() {
		return securityType;
	}
	public double getFlexMarketPrice() {
		return flexMarketPrice;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public void setAvgPx(double avgPx) {
		this.avgPx = avgPx;
	}
	public void setClOrdID(String clOrdID) {
		this.clOrdID = clOrdID;
	}
	public void setCumQty(double cumQty) {
		this.cumQty = cumQty;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setExecID(String execID) {
		this.execID = execID;
	}
	public void setLastPx(double lastPx) {
		this.lastPx = lastPx;
	}
	public void setLastQty(double lastQty) {
		this.lastQty = lastQty;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public void setOrderQty(double orderQty) {
		this.orderQty = orderQty;
	}
	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}
	public void setTransactTime(Date transactTime) {
		this.transactTime = transactTime;
	}
	public void setSettlDate(String settlDate) {
		this.settlDate = settlDate;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	public void setExecType(String execType) {
		this.execType = execType;
	}
	public void setLeavesQty(double leavesQty) {
		this.leavesQty = leavesQty;
	}
	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	public void setNoContraBrokers(int noContraBrokers) {
		this.noContraBrokers = noContraBrokers;
	}
	public void setSecondaryExecID(String secondaryExecID) {
		this.secondaryExecID = secondaryExecID;
	}
	public void setPartyID(String partyID) {
		this.partyID = partyID;
	}
	public void setContraBroker(String contraBroker) {
		this.contraBroker = contraBroker;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public void setSenderCompID(String senderCompID) {
		this.senderCompID = senderCompID;
	}
	public void setTargetCompID(String targetCompID) {
		this.targetCompID = targetCompID;
	}
	public void setDeliverToCompID(String deliverToCompID) {
		this.deliverToCompID = deliverToCompID;
	}
	public void setDeliverToSubID(String deliverToSubID) {
		this.deliverToSubID = deliverToSubID;
	}
	public void setSenderLocationID(String senderLocationID) {
		this.senderLocationID = senderLocationID;
	}
	public void setSendingTime(String sendingTime) {
		this.sendingTime = sendingTime;
	}
	public void setLastCapacity(String lastCapacity) {
		this.lastCapacity = lastCapacity;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public void setFlexMarketPrice(double flexMarketPrice) {
		this.flexMarketPrice = flexMarketPrice;
	}

	public void setAccount(ExecutionReport er) throws FieldNotFound {
		this.account = er.isSetAccount() ? er.getAccount().getValue() : "";
	}
	public void setSymbol(ExecutionReport er) throws FieldNotFound {
		this.symbol = er.isSetSymbol() ? er.getSymbol().getValue() : ""; 
	}
	public void setAvgPx(ExecutionReport er) throws FieldNotFound {
		this.avgPx = er.isSetAvgPx() ? er.getAvgPx().getValue() : 0.;
	}
	public void setClOrdID(ExecutionReport er) throws FieldNotFound {
		this.clOrdID = er.isSetClOrdID() ? er.getClOrdID().getValue() : "";
	}
	public void setCumQty(ExecutionReport er) throws FieldNotFound {
		this.cumQty = er.isSetCumQty() ? er.getCumQty().getValue() : 0.;
	}
	public void setCurrency(ExecutionReport er) throws FieldNotFound {
		this.currency = er.isSetCurrency() ? er.getCurrency().getValue() : "";
	}
	public void setExecID(ExecutionReport er) throws FieldNotFound {
		this.execID = er.isSetExecID() ? er.getExecID().getValue() : "";
	}
	public void setLastPx(ExecutionReport er) throws FieldNotFound {
		this.lastPx = er.isSetLastPx() ? er.getLastPx().getValue() : 0.;
	}
	public void setLastQty(ExecutionReport er) throws FieldNotFound {
		this.lastQty = er.isSetLastQty() ? er.getLastQty().getValue() : 0.;
	}
	public void setOrderID(ExecutionReport er) throws FieldNotFound {
		this.orderID = er.isSetOrderID() ? er.getOrderID().getValue() : "";
	}
	public void setOrderQty(ExecutionReport er) throws FieldNotFound {
		this.orderQty = er.isSetOrderQty() ? er.getOrderQty().getValue() : 0.;
	}
	public void setOrdStatus(ExecutionReport er) throws FieldNotFound {

		String ret = "";

		if(!er.isSetOrdStatus()) {
			this.ordStatus = "";
			return;
		}

		switch (er.getOrdStatus().getValue()) {
		case '0': ret = "New"; break;
		case '1': ret = "Partially filled"; break;
		case '2': ret = "Filled"; break;
		case '3': ret = "Done for day"; break;
		case '4': ret = "Canceled"; break;
		case '5': ret = "Replaced"; break;
		case '6': ret = "Pending Cancel"; break;
		case '7': ret = "Stopped"; break;
		case '8': ret = "Rejected"; break;
		case '9': ret = "Suspended"; break;
		case 'A': ret = "Pending New"; break;
		case 'B': ret = "Calculated"; break;
		case 'C': ret = "Expired"; break;
		case 'D': ret = "Accepted for bidding"; break;
		case 'E': ret = "Pending Replace"; break;
		default: ret = "NoOrdStatus";
		}

		this.ordStatus = ret;
	}
	public void setOrdType(ExecutionReport er) throws FieldNotFound {
		String ret = "";

		if(!er.isSetOrdType()) {
			this.ordType = "";
			return;
		}

		switch (er.getOrdType().getValue()) {
	       case '1': ret = "Market"; break;
	        case '2': ret = "Limit"; break;
	        case '3': ret = "Stop"; break;
	        case '4': ret = "Stop limit"; break;
	        case '5': ret = "Market on close"; break;
	        case '6': ret = "With or without"; break;
	        case '7': ret = "Limit or better"; break;
	        case '8': ret = "Limit with or without"; break;
	        case '9': ret = "On basis"; break;
	        case 'A': ret = "On close"; break;
	        case 'B': ret = "Limit on close"; break;
	        case 'C': ret = "Forex - Market"; break;
	        case 'D': ret = "Previously quoted"; break;
	        case 'E': ret = "Previously indicated"; break;
	        case 'F': ret = "Forex - Limit"; break;
	        case 'G': ret = "Forex - Swap"; break;
	        case 'H': ret = "Forex - Previously Quoted"; break;
	        case 'I': ret = "Funari"; break;
	        case 'J': ret = "Market If Touched"; break;
	        case 'K': ret = "Market with Leftover as Limit"; break;
	        case 'L': ret = "Previous Fund Valuation Point"; break;
	        case 'M': ret = "Next Fund Valuation Point"; break;
	        case 'P': ret = "Pegged"; break;
	        default: ret = "NoOrdType";
		}

		this.ordType = ret;
	}
	public void setPrice(ExecutionReport er) throws FieldNotFound {
		this.price = er.isSetPrice() ? er.getPrice().getValue() : 0.;
	}
	public void setSide(ExecutionReport er) throws FieldNotFound {
		String ret = "";

		if(!er.isSetSide()) {
			this.side = "";
			return;
		}

		switch (er.getSide().getValue()) {
	       case '1': ret = "Buy"; break;
	        case '2': ret = "Sell"; break;
	        case '3': ret = "Buy minus"; break;
	        case '4': ret = "Sell plus"; break;
	        case '5': ret = "Sell short"; break;
	        case '6': ret = "Sell short exempt"; break;
	        case '7': ret = "Undisclosed"; break;
	        case '8': ret = "Cross"; break;
	        case '9': ret = "Cross short"; break;
	        case 'A': ret = "Cross short exempt"; break;
	        case 'B': ret = "As Defined"; break;
	        case 'C': ret = "Opposite"; break;
	        case 'D': ret = "Subscribe"; break;
	        case 'E': ret = "Redeem"; break;
	        case 'F': ret = "Lend"; break;
	        case 'G': ret = "Borrow"; break;
	        default: ret = "NoSide";
		}

		this.side = ret;
	}
	public void setTimeInForce(ExecutionReport er) throws FieldNotFound {
		String ret = "";

		if(!er.isSetTimeInForce()) {
			this.timeInForce = "";
			return;
		}

		switch (er.getTimeInForce().getValue()) {
	     case '0': ret = "Day"; break;
	        case '1': ret = "Good Till Cancel"; break;
	        case '2': ret = "At the Opening"; break;
	        case '3': ret = "Immediate or Cancel"; break;
	        case '4': ret = "Fill or Kill"; break;
	        case '5': ret = "Good Till Crossing"; break;
	        case '6': ret = "Good Till Date"; break;
	        case '7': ret = "At the Close"; break;
	        default: ret = "NoTimeInForce";
		}

		this.timeInForce = ret;
	}
	public void setTransactTime(ExecutionReport er) throws FieldNotFound {
		this.transactTime = er.isSetTransactTime() ? er.getTransactTime().getValue() : new Date();
	}
	public void setSettlDate(ExecutionReport er) throws FieldNotFound {
		this.settlDate = er.isSetSettlDate() ? er.getSettlDate().getValue() : "";
	}
	public void setListID(ExecutionReport er) throws FieldNotFound {
		this.listID = er.isSetListID() ? er.getListID().getValue() : "";
	}
	public void setTradeDate(ExecutionReport er) throws FieldNotFound {
		this.tradeDate = er.isSetTradeDate() ? er.getTradeDate().getValue() : "";
	}
	public void setExecType(ExecutionReport er) throws FieldNotFound {
		String ret = "";

		if(!er.isSetExecType()) {
			this.execType = "";
			return;
		}

		switch (er.getExecType().getValue()) {
	    case '0': ret = "New"; break;
        case '1': ret = "Partial fill"; break;
        case '2': ret = "Fill"; break;
        case '3': ret = "Done for day"; break;
        case '4': ret = "Canceled"; break;
        case '5': ret = "Replace"; break;
        case '6': ret = "Pending Cancel"; break;
        case '7': ret = "Stopped"; break;
        case '8': ret = "Rejected"; break;
        case '9': ret = "Suspended"; break;
        case 'A': ret = "Pending New"; break;
        case 'B': ret = "Calculated"; break;
        case 'C': ret = "Expired"; break;
        case 'D': ret = "Restated"; break;
        case 'E': ret = "Pending Replace"; break;
        case 'F': ret = "Trade"; break;
        case 'G': ret = "Trade Correct"; break;
        case 'H': ret = "Trade Cancel"; break;
        case 'I': ret = "Order Status"; break;
        default: ret = "NoExecType";
		}

		this.execType = ret;
	}
	public void setLeavesQty(ExecutionReport er) throws FieldNotFound {
		this.leavesQty = er.isSetLeavesQty() ? er.getLeavesQty().getValue() : 0.;
	}
	public void setEffectiveTime(ExecutionReport er) throws FieldNotFound {
		this.effectiveTime = er.isSetEffectiveTime() ? er.getEffectiveTime().getValue() : new Date();
	}
	public void setNoContraBrokers(ExecutionReport er) throws FieldNotFound {
		this.noContraBrokers = er.isSetNoContraBrokers() ? er.getNoContraBrokers().getValue() : 0;
	}
	public void setSecondaryExecID(ExecutionReport er) throws FieldNotFound {
		this.secondaryExecID = er.isSetSecondaryExecID() ? er.getSecondaryExecID().getValue() : "";
	}
	public void setPartyID(ExecutionReport er) throws FieldNotFound {
		if(!er.isSetNoPartyIDs()) {
			this.partyID = "";
			return;
		}
		
		ExecutionReport.NoPartyIDs group = new ExecutionReport.NoPartyIDs();
		er.getGroup(1, group);
		this.partyID = group.getString(PartyID.FIELD);
	}
	public void setContraBroker(ExecutionReport er) throws FieldNotFound {
		if(!er.isSetNoContraBrokers()) {
			this.contraBroker = "";
			return;
		}
		
		ExecutionReport.NoContraBrokers group = new ExecutionReport.NoContraBrokers();
		er.getGroup(1, group);
		this.contraBroker = group.getString(ContraBroker.FIELD);
	}
	public void setSourceSystem(ExecutionReport er) throws FieldNotFound {
		this.sourceSystem = "FlexTrade";
	}
	public void setSenderCompID(ExecutionReport er) throws FieldNotFound {
		this.senderCompID = er.getHeader().isSetField(SenderCompID.FIELD) ? er.getHeader().getString(SenderCompID.FIELD) : "";
	}
	public void setTargetCompID(ExecutionReport er) throws FieldNotFound {
		this.targetCompID = er.getHeader().isSetField(TargetCompID.FIELD) ? er.getHeader().getString(TargetCompID.FIELD) : "";
	}
	public void setDeliverToCompID(ExecutionReport er) throws FieldNotFound {
		this.deliverToCompID = er.getHeader().isSetField(DeliverToCompID.FIELD) ? er.getHeader().getString(DeliverToCompID.FIELD) : "";
	}
	public void setDeliverToSubID(ExecutionReport er) throws FieldNotFound {
		this.deliverToSubID = er.getHeader().isSetField(DeliverToSubID.FIELD) ? er.getHeader().getString(DeliverToSubID.FIELD) : "";
	}
	public void setSenderLocationID(ExecutionReport er) throws FieldNotFound {
		this.senderLocationID = er.getHeader().isSetField(SenderLocationID.FIELD) ? er.getHeader().getString(SenderLocationID.FIELD) : "";
	}
	public void setSendingTime(ExecutionReport er) throws FieldNotFound {
		this.sendingTime = er.getHeader().isSetField(SendingTime.FIELD) ? er.getHeader().getString(SendingTime.FIELD) : "";
	}
	public void setLastCapacity(ExecutionReport er) throws FieldNotFound {
		String ret = "";

		if(!er.isSetLastCapacity()) {
			this.lastCapacity = "";
			return;
		}

		   switch (er.getLastCapacity().getValue()) {
	        case '1': ret = "Agent"; break;
	        case '2': ret = "Cross as agent"; break;
	        case '3': ret = "Cross as principal"; break;
	        case '4': ret = "Principal"; break;
	        default: ret = "NoLastCapicity";
	    }


		this.lastCapacity = ret;
	}
	public void setSecurityType(ExecutionReport er) throws FieldNotFound {
		this.securityType = er.isSetSecurityType() ? er.getSecurityType().getValue() : "";
	}
	public void setFlexMarketPrice(ExecutionReport er) throws FieldNotFound {
		this.flexMarketPrice = er.isSetField(10992) ? er.getField(new DoubleField(10992)).getValue() : 0.;
	}

	@Override
	public String toString() {
		return "FIXExecutionReport [id=" + id + ", account=" + account + ", symbol=" + symbol + ", avgPx=" + avgPx
				+ ", clOrdID=" + clOrdID + ", cumQty=" + cumQty + ", currency=" + currency + ", execID=" + execID
				+ ", lastPx=" + lastPx + ", lastQty=" + lastQty + ", orderID=" + orderID + ", orderQty=" + orderQty
				+ ", ordStatus=" + ordStatus + ", ordType=" + ordType + ", price=" + price + ", side=" + side
				+ ", timeInForce=" + timeInForce + ", transactTime=" + transactTime + ", settlDate=" + settlDate
				+ ", listID=" + listID + ", tradeDate=" + tradeDate + ", execType=" + execType + ", leavesQty="
				+ leavesQty + ", effectiveTime=" + effectiveTime + ", noContraBrokers=" + noContraBrokers
				+ ", secondaryExecID=" + secondaryExecID + ", partyID=" + partyID + ", contraBroker=" + contraBroker
				+ ", sourceSystem=" + sourceSystem + ", senderCompID=" + senderCompID + ", targetCompID=" + targetCompID
				+ ", deliverToCompID=" + deliverToCompID + ", deliverToSubID=" + deliverToSubID + ", senderLocationID="
				+ senderLocationID + ", sendingTime=" + sendingTime + ", lastCapacity=" + lastCapacity
				+ ", securityType=" + securityType + ", flexMarketPrice=" + flexMarketPrice + "]";
	}
	
	
}
