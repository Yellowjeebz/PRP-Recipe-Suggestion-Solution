CREATE DATABASE recipe_suggestion_solution;
\c recipe_suggestion_solution

CREATE TABLE fridge_contents 
(
    food_item character varying (50),
    item_quantity integer NOT NULL,
    item_weight integer NOT NULL,
    expiry_date DATE NOT NULL,
    item_owner character varying (50)
);

CREATE TABLE dish_recipe
(
    recipe_name character varying (50),
    preperation_steps character varying (50),
    required_ingredients character varying (50),
    quantity_required integer NOT NULL,
    weight_required integer NOT NULL
);

CREATE TABLE shopping_list
(
    incomplete_recipe character varying (50),
    food_item character varying (50),
    absolute_quantity integer NOT NULL,
    absolute_weight integer NOT NULL
);