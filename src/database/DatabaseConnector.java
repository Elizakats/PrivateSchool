/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ELIZA
 */
public class DatabaseConnector {

    private final String MYSQL_JDC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/private_school?serverTimezone=UTC";
    private final String USERNAME = "***********";
    private final String PASSWORD = "********";

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(MYSQL_JDC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return connection;
    }
}
