package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class RecipeSelectionPage {

    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/recipe_suggestion_solution";
        String user = "postgres";
        String password = "password";

        
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            System.out.println("Connected");
            
             //this section makes 2 arrays storing the record ids for complete and semi complete recipes
             int current_student_ID=3;
             
             String num_rec_sql = "SELECT COUNT(recipe_ID) AS num_recipes FROM recipe;";
             ResultSet rs = stmt.executeQuery(num_rec_sql); 


             //num_recipes stores the number of recipes
             int inum_recipes = 0;
            if (rs.next()) { // Fetch the first (and only) result
                inum_recipes = rs.getInt("num_recipes");
            }
             ArrayList<Integer> complete_recipe_IDs = new ArrayList<>(); //added import for arraylist
             ArrayList<Integer> semi_recipe_IDs = new ArrayList<>(); 
         //    String[] complete_recipe_names = new String [num_recipes];
             for (int current_recipe_ID=1; current_recipe_ID<=inum_recipes; current_recipe_ID++){
                //iterates through recipes
                int num_ingredients=0;
                double total_percentage=0;
                 String recipe_category_sql = "SELECT rec.recipe_name AS current_recipe_name, ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name, recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID =recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID =ing.ingredient_ID LEFT JOIN fridge_contents fridgecont ON ing.ingredient_ID =fridgecont.fridge_ingredient_ID AND fridgecont.student_ID =? WHERE rec.recipe_ID=?;" ;

                 try (PreparedStatement pstmt = conn.prepareStatement(recipe_category_sql)) {
                    pstmt.setInt(1, current_student_ID);
                    pstmt.setInt(2, current_recipe_ID);

                     rs = pstmt.executeQuery();

                    
                 
                    while (rs.next()) {
                        num_ingredients++;
                        //iterates through ingr in the recipe
                        int fq=rs.getInt("fridge_quantity");
                        int qn=rs.getInt("quantity_needed");
                        double current_percentage=(double) fq/qn;
                        if (current_percentage>1){
                            current_percentage=1;
                        }
                        total_percentage=total_percentage+current_percentage;
                        //System.out.println(rs.getInt("fridge_quantity")); //test
                    }
                    DecimalFormat df = new DecimalFormat("#.##");
                    total_percentage = Double.parseDouble(df.format(total_percentage));

                  //  System.out.println(current_recipe_ID+ "h "+ total_percentage);
                  //  System.out.println(0.7*num_ingredients);
                    if (total_percentage==num_ingredients){
                        //add to complete array
                        complete_recipe_IDs.add(current_recipe_ID);
    
    
                    }else if (total_percentage>=0.7*num_ingredients){
                        //add to semi array
                        semi_recipe_IDs.add(current_recipe_ID);

                    }

                    

                }
            }
            
    
    
            System.out.println("Complete Recipes- These are the recipes that you have all of the ingredients for!");
            //this section will select the information that will be shown on the recipe selection page under 'Complete'
            for (int i=0; i<(complete_recipe_IDs.size());i++){
                int current_complete_recipe=complete_recipe_IDs.get(i);
                ArrayList<String> complete_recipe_names = new ArrayList<>();
                String complete_recipe_info_sql= "SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=?;";

                try (PreparedStatement pstmt = conn.prepareStatement(complete_recipe_info_sql)) {
                    pstmt.setInt(1, current_complete_recipe);
                        rs = pstmt.executeQuery();


                    
                    while (rs.next()) {
                        //looping through each complete recipe
                        //array storing names of all complete recipes
                        complete_recipe_names.add(rs.getString("recipe_name"));
                        System.out.println(rs.getString("recipe_name"));
                    }
                }
            }
        

            System.out.println("Semi-complete Recipes- These are the recipes that you have most of the ingredients for!");
            //this section will select the information that will be shown on the recipe selection page under 'Semi'
            for (int i=0; i<semi_recipe_IDs.size();i++){
                int current_semi_recipe=semi_recipe_IDs.get(i);
                ArrayList<String> semi_recipe_names = new ArrayList<>();
                String semi_recipe_info_sql= "SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=?;";
                
                try (PreparedStatement pstmt = conn.prepareStatement(semi_recipe_info_sql)) {
                    pstmt.setInt(1, current_semi_recipe);
                        rs = pstmt.executeQuery();

                
    
                    while (rs.next()) {
                        //looping through each complete recipe
                        //store all the rec names and rec ids somewhere
                        semi_recipe_names.add(rs.getString("recipe_name"));
                        System.out.println(rs.getString("recipe_name"));
                    }
                }
            }
        
            /*
            //this section will select the information that will be shown in the fridge contents section
            ArrayList<String> fridge_ingredient_names = new ArrayList<>();
            ArrayList<Integer> fridge_ingredient_quantities = new ArrayList<>();
            ArrayList<String> fridge_ingredient_dates = new ArrayList<>();
            String fridge_page_sql= "SELECT fridgecont.fridge_ingredient_ID, ing.ingredient_name, fridgecont.ingredient_quantity, fridgecont.ingredient_date FROM fridge_contents fridgecont JOIN ingredients ing ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE fridgecont.student_ID=?;";
            try (PreparedStatement pstmt = conn.prepareStatement(fridge_page_sql)) {
                pstmt.setInt(1, current_student_ID);
                    rs = pstmt.executeQuery();
            
            
                while (rs.next()){
                    fridge_ingredient_names.add(rs.getString("ingredient_name")); //ingredient_name may need to be ing.ingredient_name
                    fridge_ingredient_dates.add(rs.getString("ingredient_date"));
                    fridge_ingredient_quantities.add(rs.getInt("ingredient_quantity"));
                }
                System.out.println("ingredient      quantity        dates");
                for (int i=0; i<fridge_ingredient_names.size();i++){
                    System.out.println(fridge_ingredient_names.get(i)+ "    ");
                    System.out.println(fridge_ingredient_quantities.get(i)+"     ");
                    System.out.println(fridge_ingredient_dates.get(i)+"\n");
                }
            } */
                

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}