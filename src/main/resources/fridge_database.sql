DROP DATABASE IF EXISTS recipe_suggestion_solution

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
    ingredient_units character varying (255),
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
    ingredient_quantity decimal NOT NULL,
    ingredient_date DATE NOT NULL, 
    student_ID integer NOT NULL,
    PRIMARY KEY (fridge_ingredient_ID,student_ID),
    FOREIGN KEY (student_ID) references student_house(student_ID)
);

COPY recipe FROM '/main/database/recipedata.csv' DELIMITER ',' CSV HEADER;
COPY ingredients FROM '/main/database/ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY recipe_ingredients FROM '/main/database/recipe_ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY student_house FROM '/main/database/student_housedata.csv' DELIMITER ',' CSV HEADER;
COPY fridge_contents FROM '/main/database/fridge_contentsdata.csv' DELIMITER ',' CSV HEADER;
