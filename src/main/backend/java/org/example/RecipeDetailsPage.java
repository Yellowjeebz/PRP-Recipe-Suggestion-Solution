package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDetailsPage {
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/recipe_suggestion_solution";
        String user = "postgres";
        String password = "password";

        
        try (Connection conn = DriverManager.getConnection(url, user, password); ) {
            int current_student_ID=3; //This stores the student ID of min Briggs
            String current_recipe_name= "Eggy Bread";
            
            //this section will select the information that will be shown in the fridge contents section
            String recipe_steps_sql= "SELECT recipe_steps, recipe_name FROM recipe WHERE recipe_name=?;";
            try (PreparedStatement pstmt = conn.prepareStatement(recipe_steps_sql)) {
                pstmt.setString(1, current_recipe_name);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()){
                    System.out.println(rs.getString("recipe_name"));
                    System.out.println("Instructions:");
                    System.out.println(rs.getString("recipe_steps"));
                }
                //insert here
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
