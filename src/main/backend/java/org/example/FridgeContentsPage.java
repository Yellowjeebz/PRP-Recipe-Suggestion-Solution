package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FridgeContentsPage {
        public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/recipe_suggestion_solution";
        String user = "postgres";
        String password = "password";

        
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            int current_student_ID=3; //This stores the student ID of min Briggs
            
            //this section will select the information that will be shown in the fridge contents section
            ArrayList<String> fridge_ingredient_names = new ArrayList<>();
            ArrayList<String> fridge_ingredient_quantities = new ArrayList<>();
            ArrayList<String> fridge_ingredient_dates = new ArrayList<>();
            String fridge_page_sql= "SELECT fridgecont.fridge_ingredient_ID,ing.ingredient_units,ing.ingredient_name, fridgecont.ingredient_quantity, fridgecont.ingredient_date FROM fridge_contents fridgecont JOIN ingredients ing ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID WHERE fridgecont.student_ID=?;";
            try (PreparedStatement pstmt = conn.prepareStatement(fridge_page_sql)) {
                pstmt.setInt(1, current_student_ID);
                    ResultSet rs = pstmt.executeQuery();
            
            
                while (rs.next()){
                    fridge_ingredient_names.add(rs.getString("ingredient_name")); //ingredient_name may need to be ing.ingredient_name
                    fridge_ingredient_dates.add(rs.getString("ingredient_date"));
                    fridge_ingredient_quantities.add(rs.getInt("ingredient_quantity")+rs.getString("ingredient_units"));
                }
              //  System.out.println("ingredient      quantity        dates");
                for (int i=0; i<fridge_ingredient_names.size();i++){
                    System.out.println(fridge_ingredient_quantities.get(i)+" "+fridge_ingredient_names.get(i)+"     exp:"+fridge_ingredient_dates.get(i));
                }
            } 
                

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
