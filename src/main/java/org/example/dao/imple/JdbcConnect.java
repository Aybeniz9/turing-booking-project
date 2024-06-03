package org.example.dao.imple;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


interface JdbcConnect {
     default Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Ali200aa");

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}