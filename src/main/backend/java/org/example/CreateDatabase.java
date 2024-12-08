package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args){ 
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "password";
        String Createsql = "/fridge_database.sql"; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            BufferedReader reader = new BufferedReader(new InputStreamReader(CreateDatabase.class.getResourceAsStream(Createsql)))) {

            if (reader == null) {
                throw new RuntimeException("Error" + Createsql);
            }
            StringBuilder sql = new StringBuilder();
            String next;
            while ((next = reader.readLine()) != null) {
                sql.append(next).append("\n");
                if (next.trim().endsWith(";")) {
                    stmt.execute(sql.toString());
                    sql.setLength(0); 
                }
            }

            System.out.println("Created Database");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}