CREATE DATABASE recipe_suggestion_solution;
\c recipe_suggestion_solution

CREATE TABLE recipe 
(
    recipe_ID integer NOT NULL,
    recipe_name character varying (255) NOT NULL,
    recipe_steps character varying (2048) NOT NULL
);

CREATE TABLE ingredients
(
    ingredient_ID integer NOT NULL,
    ingredient_name character varying (255) NOT NULL
);

CREATE TABLE recipe_ingredients
(
    recipe_ID integer NOT NULL,
    ingredient_ID integer NOT NULL,
    quantity integer NOT NULL
);

CREATE TABLE student_house 
(
    student_id integer NOT NULL,
    student_name varchar (255),
    house_id integer
);

CREATE TABLE fridge_contents(
    ingredient_ID integer NOT NULL,
    ingredient_quantity integer NOT NULL,
    ingredient_date DATE NOT NULL, 
    student_id integer NOT NULL
);
