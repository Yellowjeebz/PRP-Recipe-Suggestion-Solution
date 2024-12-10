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
                String recipe_ingredients_sql= "SELECT recing.quantity AS quantity_needed,fridgecont.ingredient_quantity AS fridge_quantity, ing.ingredient_name, ing.ingredient_units FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID = ing.ingredient_ID JOIN fridge_contents fridgecont ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE recipe_name = ? AND fridgecont.student_ID=?;";
                try (PreparedStatement pstmt2 = conn.prepareStatement(recipe_ingredients_sql)) {
                    pstmt2.setString(1, current_recipe_name);
                    pstmt2.setInt(2, current_student_ID);
                    rs = pstmt2.executeQuery();
                    //this section is for outputting the recipe ingredients
                    System.out.println("Ingredients:");
                    while (rs.next()){
                        System.out.println(rs.getString("quantity_needed")+rs.getString("ingredient_units")+" "+ rs.getString("ingredient_name"));
                    }
                }

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
