
CREATE DATABASE recipe_suggestion_solution;
\c recipe_suggestion_solution

CREATE TABLE recipe 
(
    recipe_ID integer NOT NULL,
    recipe_name character varying (255) NOT NULL,
    recipe_steps character varying (2048) NOT NULL,
    PRIMARY KEY (recipe_ID)
);

CREATE TABLE ingredients
(
    ingredient_ID integer NOT NULL,
    ingredient_name character varying (255) NOT NULL,
    PRIMARY KEY (ingredient_ID)
);

CREATE TABLE recipe_ingredients
(
    recipe_ID integer NOT NULL,
    ingredient_ID integer NOT NULL,
    quantity integer NOT NULL,
    PRIMARY KEY (recipe_ID, ingredient_ID),
    FOREIGN KEY (recipe_ID) references recipe(recipe_ID),
    FOREIGN KEY (recipe_ID) references ingredients(ingredient_ID)
);

CREATE TABLE student_house 
(
    student_ID integer NOT NULL,
    student_name varchar (255),
    house_ID integer,
    PRIMARY KEY (student_ID)
);

CREATE TABLE fridge_contents(
    fridge_ingredient_ID integer NOT NULL,
    ingredient_quantity integer NOT NULL,
    ingredient_date DATE NOT NULL, 
    student_ID integer NOT NULL,
    PRIMARY KEY (fridge_ingredient_ID),
    FOREIGN KEY (student_ID) references student_house(student_ID)
);