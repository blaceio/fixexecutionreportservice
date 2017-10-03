package io.blace.microservices.fixexecutionreportservice.integration.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReport;
import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReportRepository;

@Service
public class ERService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FIXExecutionReportRepository mongorepo;
	
	public Message<FIXExecutionReport> savetomongo(Message<FIXExecutionReport> execreport) {
		FIXExecutionReport _execreport = (FIXExecutionReport) execreport.getPayload();
		mongorepo.insert(_execreport);
		logger.info("Saved to Mongo: " + execreport.getPayload().getOrderID());
		return execreport;
	}
}
