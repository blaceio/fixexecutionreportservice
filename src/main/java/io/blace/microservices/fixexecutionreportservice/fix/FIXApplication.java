package io.blace.microservices.fixexecutionreportservice.fix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import io.blace.microservices.fixexecutionreportservice.integration.gateway.FIXGateway;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fix44.ExecutionReport;
import quickfix.MessageCracker;

@Service
public class FIXApplication extends MessageCracker implements quickfix.Application {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FIXGateway fixgateway;
	
	@Override
	public void onCreate(SessionID sessionId) {		
	}

	@Override
	public void onLogon(SessionID sessionId) {
		logger.info("onLogon " + sessionId.toString());
	}

	@Override
	public void onLogout(SessionID sessionId) {
		logger.info("onLogout " + sessionId.toString());
	}

	@Override
	public void toAdmin(Message message, SessionID sessionId) {
	}

	@Override
	public void fromAdmin(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
	}

	@Override
	public void toApp(Message message, SessionID sessionId) throws DoNotSend {
	}

	@Override
	public void fromApp(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
		logger.info("fromApp " + sessionId.toString());
		crack(message, sessionId);	
	}
	
	public void onMessage(ExecutionReport executionReport, SessionID sessionId) 
			throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
		logger.info("Received Execution Report " + sessionId.toString() + executionReport.toString());
		org.springframework.messaging.Message<ExecutionReport> message = MessageBuilder.withPayload(executionReport).build();
		fixgateway.send(message);
	}

}
