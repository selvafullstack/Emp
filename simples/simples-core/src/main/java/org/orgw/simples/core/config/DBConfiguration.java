package org.orgw.simples.core.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Transactional
public class DBConfiguration {
	private final Logger LOG = Logger.getLogger(this.getClass());	
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

	
}
