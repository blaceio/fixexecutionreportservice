package io.blace.microservices.fixexecutionreportservice.mongo.fixexecreport;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FIXExecutionReportRepository extends MongoRepository<FIXExecutionReport, String> {
	
}
