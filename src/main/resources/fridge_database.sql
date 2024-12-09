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

COPY recipe FROM 'C:\Users\LukeR\Desktop\University\Uni Work\Year 2\PRP-Recipe-Suggestion-Solution\src\main\resources\recipedata.csv' DELIMITER ',' CSV HEADER;
COPY ingredients FROM 'C:\Users\LukeR\Desktop\University\Uni Work\Year 2\PRP-Recipe-Suggestion-Solution\src\main\resources\ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY recipe_ingredients FROM 'C:\Users\LukeR\Desktop\University\Uni Work\Year 2\PRP-Recipe-Suggestion-Solution\src\main\resources\recipe_ingredientsdata.csv' DELIMITER ',' CSV HEADER;
COPY student_house FROM 'C:\Users\LukeR\Desktop\University\Uni Work\Year 2\PRP-Recipe-Suggestion-Solution\src\main\resources\student_housedata.csv' DELIMITER ',' CSV HEADER;
COPY fridge_contents FROM 'C:\Users\LukeR\Desktop\University\Uni Work\Year 2\PRP-Recipe-Suggestion-Solution\src\main\resources\fridge_contentsdata.csv' DELIMITER ',' CSV HEADER;
