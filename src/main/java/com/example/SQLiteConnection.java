package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
   private static final String DRIVER = "org.sqlite.JDBC";
   private static final String DB_URL = "jdbc:sqlite:person.db";

   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(DB_URL);
   }

   public static void createTable() throws SQLException {
      try (Connection conn = getConnection();
           Statement statement = conn.createStatement()) {
         String sql = "CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY, firstName TEXT, lastName TEXT, dateOfBirth TEXT)";
         statement.execute(sql);
      }
   }
}
