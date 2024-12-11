package org.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecipeSelectionService {

    private final JdbcTemplate jdbcTemplate;

    public RecipeSelectionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getCompleteRecipes(int studentId) {
        String num_rec_sql = "SELECT COUNT(recipe_ID) AS num_recipes FROM recipe;";
        int inum_recipes = jdbcTemplate.queryForObject(num_rec_sql, Integer.class);
        
        ArrayList<Integer> complete_recipe_IDs = new ArrayList<>();

        for (int current_recipe_ID = 1; current_recipe_ID <= inum_recipes; current_recipe_ID++) {
            int num_ingredients =0;
            double total_percentage=0;

            String recipeIngredientsSql = "SELECT recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID LEFT JOIN fridge_contents fridgecont ON recing.ingredient_ID = fridgecont.fridge_ingredient_ID AND fridgecont.student_ID = ? WHERE rec.recipe_ID = ?;";

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(recipeIngredientsSql, studentId, current_recipe_ID);

            for (Map<String, Object> row : rows) {
                num_ingredients++;
                int fq = row.get("fridge_quantity") == null ? 0 : ((Number) row.get("fridge_quantity")).intValue();
                int qn = ((Number) row.get("quantity_needed")).intValue();
                double current_percentage = (double) fq/qn;
                if (current_percentage>1){
                    current_percentage=1;
                } 
    
                total_percentage = total_percentage + current_percentage;
            }

            DecimalFormat df = new DecimalFormat("#.##");
            total_percentage = Double.parseDouble(df.format(total_percentage));

            if (total_percentage == num_ingredients) {
                complete_recipe_IDs.add(current_recipe_ID);
 
            }
        }

        
        List<String> complete_recipe_names = new ArrayList<>();
        for (int recipeId : complete_recipe_IDs) {
            String recipe_name_sql = "SELECT recipe_name FROM recipe WHERE recipe_ID = ?;";
            String recipe_name = jdbcTemplate.queryForObject(recipe_name_sql, new Object[] {recipeId}, String.class);
            complete_recipe_names.add(recipe_name);
        }

        return complete_recipe_names;

    }
    public List<String> getSemiCompleteRecipes(int studentId) {
        String num_rec_sql = "SELECT COUNT(recipe_ID) AS num_recipes FROM recipe;";
        int inumRecipes = jdbcTemplate.queryForObject(num_rec_sql, Integer.class);
        
        ArrayList<Integer> semi_recipe_IDs = new ArrayList<>();

        for (int current_recipe_ID = 1; current_recipe_ID <= inumRecipes; current_recipe_ID++) {
            int num_ingredients =0;
            double total_percentage=0;

            String recipeIngredientsSql = "SELECT recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID LEFT JOIN fridge_contents fridgecont ON recing.ingredient_ID = fridgecont.fridge_ingredient_ID AND fridgecont.student_ID = ? WHERE rec.recipe_ID = ?;";

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(recipeIngredientsSql, studentId, current_recipe_ID);

            for (Map<String, Object> row : rows) {
                num_ingredients++;
                int fq = row.get("fridge_quantity") == null ? 0 : ((Number) row.get("fridge_quantity")).intValue();
                int qn = ((Number) row.get("quantity_needed")).intValue();
                double current_percentage = (double) fq/qn;
                if (current_percentage>1){
                    current_percentage=1;
                } 
    
                total_percentage = total_percentage + current_percentage;
            }

            DecimalFormat df = new DecimalFormat("#.##");
            total_percentage = Double.parseDouble(df.format(total_percentage));


            
            if (total_percentage >= 0.7 * num_ingredients && total_percentage < num_ingredients) {
                semi_recipe_IDs .add(current_recipe_ID);
            }
        }

        List<String> semiCompleteRecipeNames = new ArrayList<>();
        for (int recipeId : semi_recipe_IDs ) {
            String recipe_name_sql = "SELECT recipe_name FROM recipe WHERE recipe_ID = ?;";
            String recipeName = jdbcTemplate.queryForObject(recipe_name_sql, new Object[]{recipeId}, String.class);
            semiCompleteRecipeNames.add(recipeName);
        }

        return semiCompleteRecipeNames;
    }
}

