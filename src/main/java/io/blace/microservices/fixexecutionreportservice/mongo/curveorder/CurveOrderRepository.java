package io.blace.microservices.fixexecutionreportservice.mongo.curveorder;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CurveOrderRepository extends MongoRepository<CurveOrder, String> {
	
}
