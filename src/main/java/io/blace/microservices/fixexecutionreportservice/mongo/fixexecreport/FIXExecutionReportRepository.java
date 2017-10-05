package io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FIXExecutionReportRepository extends MongoRepository<FIXExecutionReport, String> {
	List<FIXExecutionReport> findAllByOrderIDAndTradeDate(String orderID, String tradeDate);
}
