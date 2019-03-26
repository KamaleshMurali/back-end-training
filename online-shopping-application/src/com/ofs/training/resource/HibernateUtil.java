/**
 * 
 */
package com.ofs.training.resource;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author kamalesh.murali
 * @since Mar 12, 2019
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.ofs.training"})
public class HibernateUtil {

//    private static SessionFactory sessionFactory;
//    
//    @Autowired
//    Environment env;
//
//    @Bean
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            sessionFactory = buildSessionFactory();
//        }
//        return sessionFactory;
//    }

//    @Bean
//    public static SessionFactory buildSessionFactory() {
//
//        Configuration config = new Configuration();
//
//        Properties properties = new Properties();
//        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        properties.put("hibernate.connection.url", "jdbc:mysql://192.168.20.170/training");
//        properties.put("hibernate.connection.username", "root");
//        properties.put("hibernate.connection.password", "root");
//        properties.put("hibernate.current_session_context_class", "thread");
//        properties.put("show_sql", "true");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
////        properties.put("hibernate.enable_lazy_load_no_tran", "false");
//        config.setProperties(properties);
//
//        config.addAnnotatedClass(User.class);
//        
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
//        
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager txnManager() {
//
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFact().getObject());
//        return transactionManager;
//    }
//    
//    @Bean
//    public LocalSessionFactoryBean getSessionFact() {
//
//        
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        Properties properties = new Properties(); 
//        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        properties.put("hibernate.connection.url", "jdbc:mysql://192.168.20.170/training");
//        properties.put("hibernate.connection.username", "root");
//        properties.put("hibernate.connection.password", "root");
//        properties.put("hibernate.current_session_context_class", "thread");
//        properties.put("show_sql", "true");
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//
////        sessionFactory.setPackagesToScan(new String[] { "com.objectfrontier.training.hibernate.model" });
//        sessionFactory.setHibernateProperties(properties);
//        return sessionFactory;
//    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        
        sessionFactory.setDataSource(dataSource());
        Properties properties = new Properties();
//        properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//        properties.put("hibernate.connection.url", "jdbc:mysql://192.168.20.170/training");
//        properties.put("hibernate.connection.username", "root");
//        properties.put("hibernate.connection.password", "root");
//        properties.put("hibernate.current_session_context_class", "thread");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.c3p0.min_size", "5");
//        properties.put("hibernate.c3p0.max_size", "20");
//        properties.put("hibernate.c3p0.acquire_increment", "5");
//        properties.put("hibernate.c3p0.min_size", "5");
//        properties.put("hibernate.c3p0.min_size", "5");

//        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan(new String[] { "com.ofs.training.model" });

        return sessionFactory;
     }
     
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.20.170/training");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
     
//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("show_sql", "true");
//        properties.put("format_sql", "false");
//        System.out.println("properties has been found");
//        return properties;        
//    }
     
    @Bean
    public HibernateTransactionManager transactionManager() {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(getSessionFactory().getObject());
       return txManager;
    }
}
