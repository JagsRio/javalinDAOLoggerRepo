package com.jags;
import java.util.Properties;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {

    private static final MySqlConnectionFactory mysqlConnFactory = new MySqlConnectionFactory();
    private Properties props = new Properties();

    private MySqlConnectionFactory(){
        try {
            InputStream inStream = MySqlConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");

            props.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MySqlConnectionFactory getConnectionFactory(){
        return mysqlConnFactory;
    }

    public Connection getMySqlConnection(){
        try {
            String envURL = props.getProperty("propurl");
            String envUser = props.getProperty("propusername");
            String envPass = props.getProperty("proppassword");

            String url = System.getenv(envURL);
            String user = System.getenv(envUser);
            String password = System.getenv(envPass);

            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
