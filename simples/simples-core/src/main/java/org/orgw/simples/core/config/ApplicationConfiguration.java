package org.orgw.simples.core.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = { @PropertySource("classpath:application.properties"),@PropertySource("classpath:simples.properties")} )
@ImportResource(value = {"classpath:spring-core.xml"})
public class ApplicationConfiguration {
	private final Logger LOGGER = Logger.getLogger(this.getClass());
	public ApplicationConfiguration() {
		LOGGER.debug("ApplicationConfiguration........");
	}
	
}
