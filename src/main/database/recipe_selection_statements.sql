--this file stores the sql statements that will be used to extract the data that will be on the recipe selection page
--current_student_ID stores the ID of the student who will be 


-- The below sql statements are no longer to be used
--SELECT recipe_ID AS current_recipe_ID, recipe_name AS current_recipe_name FROM recipe;
--iterate through each recipe
    --SELECT ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name FROM ingredients ing JOIN recipe_ingredients recing ON ing.ingredient_ID=recing.ingredient_ID WHERE recing.recipe_ID=current_recipe_ID;
    -- 'ing' is the ingredients table, 'recing' is the recipe_ingredients table

    --iterate through ingredients
    --SELECT quantity AS quantity_needed FROM recipe_ingredients WHERE recipe_ID=current_recipe_ID and ingredient_ID=current_ingredient_ID;
    --SELECT ingredient_quantity AS fridge_quantity FROM fridge_contents WHERE fridge_ingredient_ID=current_ingredient_ID AND student_ID=current_student_ID;


--this select statement combines all of the other ones for convinience when manipulating the data
SELECT rec.recipe_ID AS current_recipe_ID, rec.recipe_name AS current_recipe_name, ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name, recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID =recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID =ing.ingredient_ID LEFT JOIN fridge_contents fridgecont ON ing.ingredient_ID =fridgecont.fridge_ingredient_ID AND fridgecont.student_ID =current_student_ID;

