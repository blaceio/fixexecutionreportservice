package io.blace.microservices.fixexecutionreportservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.blace.microservices.fixexecutionreportservice.properties.FIXProperties;

@Component
public class Configuration {

	@Autowired
	private FIXProperties fixproperties;

	public FIXProperties getFixproperties() {
		return fixproperties;
	}

}
