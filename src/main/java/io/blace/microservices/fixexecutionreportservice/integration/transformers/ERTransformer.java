package io.blace.microservices.fixexecutionreportservice.integration.transformers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport.FIXExecutionReport;
import quickfix.FieldNotFound;
import quickfix.fix44.ExecutionReport;

@Component
public class ERTransformer {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Message<FIXExecutionReport> fixtoer(Message<ExecutionReport> execreport) throws FieldNotFound {
		
		FIXExecutionReport fixexecreport = new FIXExecutionReport(execreport.getPayload());
		
		logger.info("Transformed to: " + fixexecreport.toString());
		
		return MessageBuilder
				.withPayload(fixexecreport)
				.setHeader("source", fixexecreport.getSourceSystem())
				.setHeader("ordstatus", fixexecreport.getOrdStatus())
				.setHeader("client",fixexecreport.getDeliverToCompID())
				.build();
	}
}
