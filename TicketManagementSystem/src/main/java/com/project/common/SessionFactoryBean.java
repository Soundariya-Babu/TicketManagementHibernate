package com.project.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.project.model")
@EnableTransactionManagement

public class SessionFactoryBean {
	@Autowired
	BlogProperties blogProperties;

	@Autowired
	Environment environment;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.project.model");
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.default_schema", blogProperties.getHibernateDefaultSchema());
		properties.put("hibernate.show_sql", blogProperties.getHibernateShowSQL());
		properties.put("hibernate.format_sql", blogProperties.getHibernateFormatSQL());
		properties.put("hibernate.use_sql_comments", blogProperties.getHibernateUseSQLComments());
		properties.put("hibernate.generate_statistics", blogProperties.getHibernateGenerateStatistics());
		properties.put("hibernate.connection.autocommit", blogProperties.getHibernateAutoCommit());
		return properties;
	}

}
