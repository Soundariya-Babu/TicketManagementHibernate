package com.project.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

	
	  @Value("${hibernate.dialect}")
	  private String hibernateDialect;

	  @Value("${hibernate.default_schema}")
	  private String hibernateDefaultSchema;

	  @Value("${hibernate.show_sql}")
	  private String hibernateShowSQL;

	  @Value("${hibernate.format_sql}")
	  private String hibernateFormatSQL;

	  @Value("${hibernate.use_sql_comments}")
	  private String hibernateUseSQLComments;

	  @Value("${hibernate.generate_statistics}")
	  private String hibernateGenerateStatistics;

	  @Value("${hibernate.autocommit}")
	  private String hibernateAutoCommit;

	  @Bean
	  public BlogProperties getBlogConfig() {
	    return this;
	  }

	  public String getHibernateDialect() {
	    return hibernateDialect;
	  }

	  public void setHibernateDialect(String hibernateDialect) {
	    this.hibernateDialect = hibernateDialect;
	  }

	  public String getHibernateDefaultSchema() {
	    return hibernateDefaultSchema;
	  }

	  public void setHibernateDefaultSchema(String hibernateDefaultSchema) {
	    this.hibernateDefaultSchema = hibernateDefaultSchema;
	  }

	  public String getHibernateShowSQL() {
	    return hibernateShowSQL;
	  }

	  public void setHibernateShowSQL(String hibernateShowSQL) {
	    this.hibernateShowSQL = hibernateShowSQL;
	  }

	  public String getHibernateFormatSQL() {
	    return hibernateFormatSQL;
	  }

	  public void setHibernateFormatSQL(String hibernateFormatSQL) {
	    this.hibernateFormatSQL = hibernateFormatSQL;
	  }

	  public String getHibernateUseSQLComments() {
	    return hibernateUseSQLComments;
	  }

	  public void setHibernateUseSQLComments(String hibernateUseSQLComments) {
	    this.hibernateUseSQLComments = hibernateUseSQLComments;
	  }

	  public String getHibernateGenerateStatistics() {
	    return hibernateGenerateStatistics;
	  }

	  public void setHibernateGenerateStatistics(String hibernateGenerateStatistics) {
	    this.hibernateGenerateStatistics = hibernateGenerateStatistics;
	  }

	  public String getHibernateAutoCommit() {
	    return hibernateAutoCommit;
	  }

	  public void setHibernateAutoCommit(String hibernateAutoCommit) {
	    this.hibernateAutoCommit = hibernateAutoCommit;
	  }
	}

