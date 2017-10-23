package io.blace.microservices.fixexecutionreportservice.fix;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.blace.microservices.fixexecutionreportservice.configuration.Configuration;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileStoreFactory;
import quickfix.RuntimeError;
import quickfix.ScreenLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

@Service
public class FIXApplicationRunner {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private FIXApplication fixapplication;
	
	private final InputStream fixconfig;
	private final SessionSettings sessionsettings;
    private final FileStoreFactory filestorefactory;
    private final ScreenLogFactory screenlogfactory;
    private SocketInitiator socketinitiator;
    
    public FIXApplicationRunner(ResourceLoader resourceloader, Configuration configuration) throws IOException, ConfigError {
    		this.fixconfig = resourceloader.getResource(configuration.getFixproperties().getConfig()).getInputStream();
        this.sessionsettings = new SessionSettings(fixconfig);
        this.filestorefactory = new FileStoreFactory(sessionsettings);
        this.screenlogfactory = new ScreenLogFactory(sessionsettings);
	}
    
	@PostConstruct
	private void run() throws RuntimeError, ConfigError {
		logger.info("Starting...");
		this.socketinitiator = new SocketInitiator(fixapplication, filestorefactory, sessionsettings, screenlogfactory, new DefaultMessageFactory());
		this.socketinitiator.start();
	}
	
	@Scheduled(cron="0 0 4 * * *")
	public void shutDown() {
		this.socketinitiator.stop(true);
	    SpringApplication.exit(appContext);
	}
	
}
