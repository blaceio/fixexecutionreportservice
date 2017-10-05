package io.blace.microservices.fixexecutionreportservice.integration.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import io.blace.microservices.fixexecutionreportservice.mongo.curveorder.CurveOrder;
import io.blace.microservices.fixexecutionreportservice.mongo.curveorder.CurveOrderRepository;

@Service
public class OrderService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurveOrderRepository mongorepo;
	
	public Message<CurveOrder> savetomongo(Message<CurveOrder> curveorder) {
		mongorepo.insert(curveorder.getPayload());
		logger.info("Saved to Mongo: " + curveorder.getPayload().getOrderid());
		return curveorder;
	}
}
