package net.sqlitedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertdata {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/moviesdatas.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, String ac , String actress , int yr ,String dir) {
        String sql = "INSERT INTO moviesdata(moviename,Actor,Actress,yearofrelease,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, ac);
            pstmt.setString(3, actress);
            pstmt.setInt(4, yr);
            pstmt.setString(5, dir);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Insertdata app = new Insertdata();
        app.insert("Valimai" , "Ajith Kumar" , "Huma Qureshi" , 2022 , "H.Vinoth");
        app.insert("Sarkar" , "Vijay Kumar" , "Keerthi Suresh" , 2018 , "Murugadoss");
      
    }

}
