package io.blace.microservices.fixexecutionreportservice.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("fix")
public class FIXProperties {
	private String config;

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	@Override
	public String toString() {
		return "FIXProperties [config=" + config + "]";
	}
	
	
}
