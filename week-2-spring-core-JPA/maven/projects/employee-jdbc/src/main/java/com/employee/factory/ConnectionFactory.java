//package com.employee.factory;
//
//import com.employee.config.DatabaseConfig;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * Factory class for creating and managing database connections.
// * Implements Singleton pattern for connection management.
// */
//public final class ConnectionFactory {
//    private static volatile Connection connection;
//
//    // Private constructor
//    private ConnectionFactory() {
//        throw new UnsupportedOperationException("Factory class cannot be instantiated");
//    }
//
//    /**
//     * Gets a database connection. Creates new one if none exists or if existing is closed.
//     */
//    public static Connection getConnection() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            synchronized (ConnectionFactory.class) {
//                if (connection == null || connection.isClosed()) {
//                    connection = createConnection();
//                    System.out.println("✓ Database connection established successfully");
//                }
//            }
//        }
//        return connection;
//    }
//
//    /**
//     * Creates a new connection to the database.
//     */
//    private static Connection createConnection() throws SQLException {
//        return DriverManager.getConnection(
//                DatabaseConfig.getUrl(),
//                DatabaseConfig.getUsername(),
//                DatabaseConfig.getPassword()
//        );
//    }
//
//    /**
//     * Closes the database connection if it's open.
//     */
//    public static void closeConnection() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//                System.out.println("✓ Database connection closed successfully");
//            }
//        } catch (SQLException e) {
//            System.err.println(STR."Error closing connection: \{e.getMessage()}");
//        }
//    }
//
//    /**
//     * Tests if the database connection is valid.
//     */
//    public static boolean testConnection() {
//        try {
//            Connection conn = getConnection();
//            return conn != null && !conn.isClosed() && conn.isValid(5);
//        } catch (SQLException e) {
//            System.err.println(STR."Connection test failed: \{e.getMessage()}");
//            return false;
//        }
//    }
//}
