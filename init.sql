-- -- Create tables
-- CREATE TABLE recipe (
--     recipe_ID SERIAL PRIMARY KEY,
--     recipe_name VARCHAR(255) NOT NULL,
--     recipe_steps VARCHAR(2048) NOT NULL
-- );

-- CREATE TABLE ingredients (
--     ingredient_ID SERIAL PRIMARY KEY,
--     ingredient_name VARCHAR(255) NOT NULL,
--     ingredient_units VARCHAR(255)
-- );

-- CREATE TABLE recipe_ingredients (
--     recipe_ID INTEGER NOT NULL,
--     ingredient_ID INTEGER NOT NULL,
--     quantity INTEGER NOT NULL,
--     PRIMARY KEY (recipe_ID, ingredient_ID),
--     FOREIGN KEY (recipe_ID) REFERENCES recipe(recipe_ID),
--     FOREIGN KEY (ingredient_ID) REFERENCES ingredients(ingredient_ID)
-- );

-- CREATE TABLE student_house (
--     student_ID SERIAL PRIMARY KEY,
--     student_name VARCHAR(255),
--     house_ID INTEGER
-- );

-- CREATE TABLE fridge_contents (
--     fridge_ingredient_ID SERIAL PRIMARY KEY,
--     ingredient_quantity DECIMAL NOT NULL,
--     ingredient_date DATE NOT NULL,
--     student_ID INTEGER NOT NULL,
--     FOREIGN KEY (student_ID) REFERENCES student_house(student_ID)
-- );

-- -- Load data from CSV files
-- -- Adjusted to include recipe_ID since it exists in the CSV
-- COPY recipe(recipe_ID, recipe_name, recipe_steps) FROM '/data/recipedata.csv' DELIMITER ',' CSV HEADER;

-- COPY ingredients(ingredient_ID, ingredient_name, ingredient_units) FROM '/data/ingredientsdata.csv' DELIMITER ',' CSV HEADER;

-- COPY recipe_ingredients(recipe_ID, ingredient_ID, quantity) FROM '/data/recipe_ingredientsdata.csv' DELIMITER ',' CSV HEADER;

-- COPY student_house(student_ID, student_name, house_ID) FROM '/data/student_housedata.csv' DELIMITER ',' CSV HEADER;

-- COPY fridge_contents(fridge_ingredient_ID, ingredient_quantity, ingredient_date, student_ID) FROM '/data/fridge_contentsdata.csv' DELIMITER ',' CSV HEADER;

-- -- Adjust the sequence to align with the data
-- SELECT setval(
--     pg_get_serial_sequence('fridge_contents', 'fridge_ingredient_ID'),
--     COALESCE((SELECT MAX(fridge_ingredient_ID) FROM fridge_contents) + 1, 1),
--     false
-- );
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
    FOREIGN KEY (ingredient_ID) references ingredients(ingredient_ID)
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

COPY recipe FROM '/docker-entrypoint-initdb.d/recipedata.csv' DELIMITER ',' CSV HEADER;
COPY ingredients FROM '/docker-entrypoint-initdb.d/ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY recipe_ingredients FROM '/docker-entrypoint-initdb.d/recipe_ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY student_house FROM '/docker-entrypoint-initdb.d/student_housedata.csv' DELIMITER ',' CSV HEADER;
COPY fridge_contents FROM '/docker-entrypoint-initdb.d/fridge_contentsdata.csv' DELIMITER ',' CSV HEADER;
