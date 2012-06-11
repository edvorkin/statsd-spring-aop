package com.statsd.config;
import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.statsd.client.StatsdClient;
	
/**
	 * Spring configuration file
	 * 
	 */

@Configuration
@PropertySource("config.properties")
public class StatsdConfig {
	private @Value("${statsd.port}") String port;
	private @Value("${statsd.url}") String url;
	

	@Bean(name = "statsdClient")
	public StatsdClient  statsdClient() throws UnknownHostException, IOException {
		StatsdClient statsdclient=null;

			int statsdPort=Integer.parseInt(port);
			statsdclient= new StatsdClient(url,statsdPort);
			return statsdclient;
		
		
	}

}
