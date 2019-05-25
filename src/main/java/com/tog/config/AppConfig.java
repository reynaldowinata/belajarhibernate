package com.tog.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages={
		"com.tog.entity",
		"com.tog.dao",
		"com.tog.service"})
@EnableTransactionManagement
@ComponentScans(value={
		@ComponentScan(value="com.tog.entity"),
		@ComponentScan(value="com.tog.dao"),
		@ComponentScan(value="com.tog.service")
})
public class AppConfig {
	
	@Bean(name="dataSource")
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=belajarhibernatedb");
		dataSource.setUsername("sa");
		dataSource.setPassword("Diginovasi");
		return dataSource;
	}
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DataSource dataSource){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPersistenceUnitName("belajarhibernatePU");
		emf.setPackagesToScan("com.tog.entity","com.tog.dao","com.tog.service");
		Properties props = System.getProperties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.id.new_generator_mappings", "true");
		emf.setJpaProperties(props);
		emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	
	@Bean(name="transactionManager")
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf){
		return new JpaTransactionManager(emf);
	}
	

}
