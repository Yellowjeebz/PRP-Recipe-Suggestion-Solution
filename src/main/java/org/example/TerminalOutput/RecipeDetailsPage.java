package org.example.TerminalOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                    String recipe_instructions= rs.getString("recipe_steps");
                    System.out.println(recipe_instructions);
                }
                String recipe_ingredients_sql= "SELECT recing.quantity AS quantity_needed,fridgecont.ingredient_quantity AS fridge_quantity, ing.ingredient_name, ing.ingredient_units FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID = ing.ingredient_ID JOIN fridge_contents fridgecont ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE recipe_name = ? AND fridgecont.student_ID=?;";
                try (PreparedStatement pstmt2 = conn.prepareStatement(recipe_ingredients_sql)) {
                    ArrayList<String> all_ingredients = new ArrayList<>(); 
                    pstmt2.setString(1, current_recipe_name);
                    pstmt2.setInt(2, current_student_ID);
                    rs = pstmt2.executeQuery();
                    //this section is for outputting the recipe ingredients
                    System.out.println("Ingredients:");
                    while (rs.next()){
                        System.out.println(rs.getString("quantity_needed")+rs.getString("ingredient_units")+" "+ rs.getString("ingredient_name"));
                        all_ingredients.add(rs.getString("quantity_needed")+rs.getString("ingredient_units")+" "+ rs.getString("ingredient_name")); //this stores the list of ingredients in format 50g cheese
                    }
                    String recipe_shopping_list_sql= "SELECT recing.quantity AS quantity_needed,fridgecont.ingredient_quantity AS fridge_quantity, ing.ingredient_name, ing.ingredient_units FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID = ing.ingredient_ID JOIN fridge_contents fridgecont ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE recipe_name = ? AND fridgecont.student_ID=?;";
                    try (PreparedStatement pstmt3 = conn.prepareStatement(recipe_shopping_list_sql)) {
                        pstmt3.setString(1, current_recipe_name);
                        pstmt3.setInt(2, current_student_ID);
                        rs = pstmt3.executeQuery();
                        //this section is for outputting the shopping list
                        ArrayList<String> shopping_list_items = new ArrayList<>(); 
                        while (rs.next()){
                            int qn=rs.getInt("quantity_needed");
                            int fq=rs.getInt("fridge_quantity");
                            if (fq-qn<0){
                                shopping_list_items.add((qn-fq)+rs.getString("ingredient_units")+" "+ rs.getString("ingredient_name")); //this is an array of all the shopping list items in format eg 50g cheese
                            }
                        }
                        if (shopping_list_items.size()>0){
                            System.out.println("\nShopping List:");
                        }


                        rs = pstmt3.executeQuery();
                        while (rs.next()){
                            int qn=rs.getInt("quantity_needed");
                            int fq=rs.getInt("fridge_quantity");
                            if (fq-qn<0){
                                System.out.println((qn-fq)+rs.getString("ingredient_units")+" "+ rs.getString("ingredient_name"));
                            }
                            
                        }
                    }
                }

            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
