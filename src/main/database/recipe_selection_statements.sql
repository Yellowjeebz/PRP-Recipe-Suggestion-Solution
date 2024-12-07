--this file stores the sql statements that will be used to extract the data that will be on the recipe selection page
--current_student_ID stores the ID of the student who will be 



SELECT recipe_ID AS current_recipe_ID, recipe_name AS current_recipe_name FROM recipe;
--iterate through each recipe
    SELECT ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name FROM ingredients ing JOIN recipe_ingredients recing ON ing.ingredient_ID=recing.ingredient_ID WHERE recing.recipe_ID=current_recipe_ID;
    -- 'ing' is the ingredients table, 'recing' is the recipe_ingredients table

    --iterate through ingredients
    SELECT quantity AS quantity_needed FROM recipe_ingredients WHERE recipe_ID=current_recipe_ID and ingredient_ID=current_ingredient_ID;
    SELECT ingredient_quantity AS fridge_quantity FROM fridge_contents WHERE fridge_ingredient_ID=current_ingredient_ID AND student_ID=current_student_ID;


