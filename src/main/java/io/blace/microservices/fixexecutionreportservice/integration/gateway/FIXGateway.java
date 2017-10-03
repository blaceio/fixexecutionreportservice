package io.blace.microservices.fixexecutionreportservice.integration.gateway;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import quickfix.fix44.ExecutionReport;

@Component
public interface FIXGateway {  
	 public void send(Message<ExecutionReport> message);  
} 
