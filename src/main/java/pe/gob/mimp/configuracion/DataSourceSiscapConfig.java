package pe.gob.mimp.configuracion;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.BatchWriting;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "siscapEntityManagerFactory", transactionManagerRef = "siscapTransactionManager", basePackages = {
		"pe.gob.mimp.siscap.repository" })
public class DataSourceSiscapConfig{

	@Autowired
	private Environment environment;

//	protected DataSourceSiscapConfig(@Qualifier("siscapDatasource") DataSource dataSource,
//			@Qualifier("siscapProperties") JpaProperties properties,
//			ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
//		super(dataSource, properties, jtaTransactionManager);
//	}
//
//	@Override
//	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
//		EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
//		return adapter;
//	}
//
//	@Override
//	protected Map<String, Object> getVendorProperties() {
//		HashMap<String, Object> map = new HashMap<String, Object>();
//
//		map.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
//		map.put(PersistenceUnitProperties.WEAVING, detectWeavingMode());
//
//		return map;
//	}
//
//	private String detectWeavingMode() {
//		return InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static";
//	}

//	@Primary
	@Bean(name = "siscapDatasource")
	@ConfigurationProperties(prefix = "spring.datasource.siscap")
	public DataSource productDataSource() {

//		return DataSourceBuilder.create().build();

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.siscap.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.siscap.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.siscap.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.siscap.password"));

		return dataSource;
	}

	@Bean(name = "siscapEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean productEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("siscapDatasource") DataSource dataSource) {

//		properties.put("hibernate.hbm2ddl.auto", "update");
//		properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL5Dialect");

		return builder.dataSource(dataSource).packages("pe.gob.mimp.siscap.model").persistenceUnit("siscap")
				.properties(initJpaProperties()).build();

	}

	@Bean(name = "siscapTransactionManager")
        @ConditionalOnMissingBean(PlatformTransactionManager.class)
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("siscapEntityManagerFactory") EntityManagerFactory siscapEntityManagerFactory) {

		return new JpaTransactionManager(siscapEntityManagerFactory);
	}

	@Bean(name = "siscapProperties")
	@Primary
	public static JpaProperties properties() {
		final JpaProperties jpaProperties = new JpaProperties();
		jpaProperties.setShowSql(true);
		jpaProperties.setDatabasePlatform("org.eclipse.persistence.platform.database.OraclePlatform");
		return jpaProperties;
	}

	private static Map<String, ?> initJpaProperties() {
		final Map<String, Object> ret = new HashMap<>();
		// Add any JpaProperty you are interested in and is supported by your Database
		// and JPA implementation
		ret.put(PersistenceUnitProperties.BATCH_WRITING, BatchWriting.JDBC);
//		ret.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINEST_LABEL);
		ret.put(PersistenceUnitProperties.WEAVING, "false");
//		ret.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
//		ret.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
		return ret;
	}

}
