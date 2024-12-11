package org.example.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RecipeDetailsService {

    private final JdbcTemplate jdbcTemplate;

    public RecipeDetailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Object> getRecipeDetails(int studentId, String recipeName) {
        
        String current_recipe_name = "Eggy Bread";
        String recipe_instructions = null;
        

        String recipe_steps_sql = "SELECT recipe_steps, recipe_name FROM recipe WHERE recipe_name = ?;";
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(recipe_steps_sql, recipeName);
            if (!rows.isEmpty()) {
                Map<String, Object> row = rows.get(0);
                current_recipe_name = (String) row.get("recipe_name");
                recipe_instructions = (String) row.get("recipe_steps");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String recipe_ingredients_sql = "SELECT recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity, ing.ingredient_name, ing.ingredient_units FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID = recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID = ing.ingredient_ID LEFT JOIN fridge_contents fridgecont ON fridgecont.fridge_ingredient_ID = ing.ingredient_ID AND fridgecont.student_ID = ? WHERE recipe_name = ?;";
        ArrayList<String> all_ingredients = new ArrayList<>();
        ArrayList<String> shopping_list_items = new ArrayList<>();
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(recipe_ingredients_sql, studentId, recipeName);
            
            for (Map<String, Object> row : rows) {
                
                int quantityNeeded = ((Number) row.get("quantity_needed")).intValue();
                int fridgeQuantity = row.get("fridge_quantity") == null ? 0 : ((Number) row.get("fridge_quantity")).intValue();
                String ingredientName = (String) row.get("ingredient_name");
                String units = (String) row.get("ingredient_units");

              
                all_ingredients.add(quantityNeeded + units + " " + ingredientName);

                
                if (fridgeQuantity < quantityNeeded) {
                    shopping_list_items.add((quantityNeeded - fridgeQuantity) + units + " " + ingredientName);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Object> recipeDetails = new ArrayList<>();
        recipeDetails.add(current_recipe_name);
        recipeDetails.add(recipe_instructions);
        recipeDetails.add(all_ingredients);
        recipeDetails.add(shopping_list_items);

        return recipeDetails;
    }
}
