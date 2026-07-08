package com.employee.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "JDBC:mysql://localhost:3306/employee_management_system";
    private static final String USER = "root";
    private static final String PASSWORD = "12qw";

    private DBConnection() {}

    private static Connection connection = null;

    // this is a lazy initialization - not thread safe
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        }
        return connection;
    }


}
