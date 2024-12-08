--this file stores the sql statements that will be used to extract the data that will be on the recipe selection page

--this select statement combines all of the other ones for convinience when manipulating the data
--current_student_ID stores the ID of the student who will be using the system
--current_recipe_ID stores the ID of the current number in the loop
SELECT rec.recipe_name AS current_recipe_name, ing.ingredient_ID AS current_ingredient_ID, ing.ingredient_name AS current_ingredient_name, recing.quantity AS quantity_needed, fridgecont.ingredient_quantity AS fridge_quantity FROM recipe rec JOIN recipe_ingredients recing ON rec.recipe_ID =recing.recipe_ID JOIN ingredients ing ON recing.ingredient_ID =ing.ingredient_ID LEFT JOIN fridge_contents fridgecont ON ing.ingredient_ID =fridgecont.fridge_ingredient_ID AND fridgecont.student_ID =current_student_ID WHERE rec.recipe_ID=current_recipe_ID;


--this statement will return the number of recipes (used to loop through recipe_IDs)
SELECT COUNT(recipe_ID) AS num_recipes FROM recipe;


-- this statement will select the recipe information to be displayed on the recipe selection page
SELECT recipe_name FROM recipe WHERE recipe_ID=current_complete_recipe;


-- this statement will select the recipe information to be displayed on the recipe selection page
--current_complete_recipe needs to be set
SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=current_complete_recipe;


-- this statement will select the recipe information to be displayed on the recipe selection page
--current_semi_recipe needs to be set
SELECT recipe_name, recipe_ID FROM recipe WHERE recipe_ID=current_semi_recipe;