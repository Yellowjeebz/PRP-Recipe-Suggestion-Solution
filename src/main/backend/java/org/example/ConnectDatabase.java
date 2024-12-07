package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class ConnectDatabase {

    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/recipe_suggestion_solution";
        String user = "postgres";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            System.out.println("Connected");
            
            String sql = "SELECT * FROM fridge_contents";
            ResultSet rs = stmt.executeQuery(sql); 

            while (rs.next()) {
                System.out.println(rs.getString("fridge_ingredient_ID"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}