package net.sqlitedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/moviesdatas.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS moviesdata (\n"
                + "	moviename text NOT NULL,\n"
                + "	Actor text NOT NULL,\n"
                + "	Actress text NOT NULL,\n"
                + "	yearofrelease int NOT NULL,\n"
                + "	director text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {
        createNewTable();
    }

}
