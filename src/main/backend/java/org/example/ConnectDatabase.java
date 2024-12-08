package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConnectDatabase {

    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "password";

        
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            System.out.println("Connected");
            
             //this section makes 2 arrays storing the record ids for complete and semi complete recipes
             int total_percentage=0;
             int current_student_ID=3;
             String num_rec_sql = "SELECT COUNT(recipe_ID) AS num_recipes FROM recipe;";
             ResultSet rs = stmt.executeQuery(num_rec_sql); 
             //num_recipes stores the number of recipes
             int inum_recipes= Integer.valueOf(rs.getString("num_recipes"));
 
             ArrayList<Integer> complete_recipe_IDs = new ArrayList<>(); //added import for arraylist
             ArrayList<Integer> semi_recipe_IDs = new ArrayList<>(); 
         //    String[] complete_recipe_names = new String [num_recipes];
             for (int current_recipe_ID=1; current_recipe_ID<=inum_recipes; current_recipe_ID++){
                 String recipe_category_sql = "SELECT rec.recipe_name AS current_recipe_name, ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name, recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID =recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID =ing.ingredient_ID LEFT JOIN fridge_contents fridgecont ON ing.ingredient_ID =fridgecont.fridge_ingredient_ID AND fridgecont.student_ID =current_student_ID WHERE rec.recipe_ID=current_recipe_ID;" ;
                 rs = stmt.executeQuery(recipe_category_sql);
                 
                 
                 while (rs.next()) {
                     int current_percentage=Integer.valueOf(rs.getString("fridge_quantity"))/Integer.valueOf(rs.getString("quantity_needed"));
                     if (current_percentage>1){
                         current_percentage=1;
                     }
                     total_percentage=total_percentage+current_percentage;
                     System.out.println(rs.getString("num_recipes")); //test
                 }
 
                 if (total_percentage==1){
                     //add to complete array
                     complete_recipe_IDs.add(current_recipe_ID);
 
                 }else if (total_percentage>=0.7 && total_percentage<1){
                     //add to semi array
                     semi_recipe_IDs.add(current_recipe_ID);
                 }
             }
 
 
             //this section will select the information that will be shown on the recipe selection page under 'Complete'
             for (int i=0; i<(complete_recipe_IDs.size());i++){
                 int current_complete_recipe=complete_recipe_IDs.get(i);
                 ArrayList<String> complete_recipe_names = new ArrayList<>();
                 String complete_recipe_info_sql= "SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=current_complete_recipe;";
                 rs = stmt.executeQuery(complete_recipe_info_sql);
                 System.out.println("Complete Recipes");
                 System.out.println("These are the recipes that you have all of the ingredients for!");
                 while (rs.next()) {
                     //looping through each complete recipe
                     //array storing names of all complete recipes
                     complete_recipe_names.add(rs.getString("recipe_name"));
                     System.out.println(rs.getString("recipe_name"));
                 }
             }
 
             //this section will select the information that will be shown on the recipe selection page under 'Semi'
             for (int i=0; i<semi_recipe_IDs.size();i++){
                 int current_semi_recipe=semi_recipe_IDs.get(i);
                 ArrayList<String> semi_recipe_names = new ArrayList<>();
                 String semi_recipe_info_sql= "SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=current_complete_recipe;";
                 rs = stmt.executeQuery(semi_recipe_info_sql);
                 System.out.println("Semi-complete Recipes");
                 System.out.println("These are the recipes that you have most of the ingredients for!");
                 while (rs.next()) {
                     //looping through each complete recipe
                     //store all the rec names and rec ids somewhere
                     semi_recipe_names.add(rs.getString("recipe_name"));
                     System.out.println(rs.getString("recipe_name"));
                 }
             }
 
             //this section will select the information that will be shown in the fridge contents section
             ArrayList<String> fridge_ingredient_names = new ArrayList<>();
             ArrayList<Integer> fridge_ingredient_quantities = new ArrayList<>();
             ArrayList<String> fridge_ingredient_dates = new ArrayList<>();
             String fridge_page_sql= "SELECT fridgecont.fridge_ingredient_ID, ing.ingredient_name, fridgecont.ingredient_quantity, fridgecont.ingredient_date FROM fridge_contents fridgecont JOIN ingredients ing ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE fridgecont.student_ID=current_student_ID;";
             while (rs.next()){
                 fridge_ingredient_names.add(rs.getString("ingredient_name")); //ingredient_name may need to be ing.ingredient_name
                 fridge_ingredient_dates.add(rs.getString("ingredient_date"));
                 fridge_ingredient_quantities.add(Integer.valueOf(rs.getString("ingredient_name")));
             }
             System.out.println("ingredient      quantity        dates");
             for (int i=0; i<fridge_ingredient_names.size();i++){
                 System.out.println(fridge_ingredient_names.get(i)+ "    ");
                 System.out.println(fridge_ingredient_quantities.get(i)+"     ");
                 System.out.println(fridge_ingredient_dates.get(i)+"\n");
             }

            /*
            String sql = "SELECT * FROM fridge_contents";
            ResultSet rs = stmt.executeQuery(sql); 

            while (rs.next()) {
                System.out.println(rs.getString("fridge_ingredient_ID"));
            } */


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}