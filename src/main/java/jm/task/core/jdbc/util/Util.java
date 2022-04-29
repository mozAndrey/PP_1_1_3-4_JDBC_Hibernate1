package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1234";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionURL, userName, password);
    }

    public static SessionFactory getSessionFactory() throws SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        Configuration configuration = new Configuration();
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
        properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.username", "root");
        properties.setProperty("hibernate.connection.password", "1234");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(serviceRegistry.build());

        return sessionFactory;
    }


}
