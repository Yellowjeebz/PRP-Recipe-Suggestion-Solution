import React, { useState, useEffect } from "react";
import FridgeContents from "./FridgeContents";
import RecipeSuggestions from "./RecipeSuggestions";

const App = () => {
  const [fridgeContents, setFridgeContents] = useState([]);
  const [recipes, setRecipes] = useState({ complete: [], "semi-complete": [] });
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchFridgeContents = async () => {
      const response = await fetch("http://localhost:8080/api/v1/fridgeContents?studentId=3");
      const data = await response.json();
      const parsedData = data.map((item) => {
        const [name, expiry] = item.split(" exp:");
        return { name, date: expiry };
      });
      setFridgeContents(parsedData);
    };

    const fetchCompleteRecipes = async () => {
      const response = await fetch("http://localhost:8080/api/v1/recipes/complete?studentId=3");
      return await response.json();
    };

    const fetchSemiCompleteRecipes = async () => {
      const response = await fetch("http://localhost:8080/api/v1/recipes/semicomplete?studentId=3");
      return await response.json();
    };

    const fetchRecipeDetails = async (recipeName) => {
      const encodedName = encodeURIComponent(recipeName);
      const response = await fetch(`http://localhost:8080/api/v1/recipeDetails?studentId=3&recipeName=${encodedName}`);
      return await response.json();
    };

    const fetchData = async () => {
      try {
        setIsLoading(true);
        await fetchFridgeContents();

        const completeRecipeNames = await fetchCompleteRecipes();
        const semiCompleteRecipeNames = await fetchSemiCompleteRecipes();

        const completeRecipes = await Promise.all(
          completeRecipeNames.map(async (name) => {
            const details = await fetchRecipeDetails(name);
            return {
              name: details.recipe_name,
              steps: details.instructions.split("\n"),
              ingredients: details.ingredients,
            };
          })
        );

        const semiCompleteRecipes = await Promise.all(
          semiCompleteRecipeNames.map(async (name) => {
            const details = await fetchRecipeDetails(name);
            return {
              name: details.recipe_name,
              steps: details.instructions.split("\n"),
              ingredientsInFridge: details.ingredients,
              ingredientsNeeded: details.shopping_list,
            };
          })
        );

        setRecipes({
          complete: completeRecipes,
          "semi-complete": semiCompleteRecipes,
        });
      } catch (error) {
        console.error("Error fetching data:", error);
      } finally {
        setIsLoading(false);
      }
    };

    fetchData();
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="page">
      <div className="app">
        <h1>Recipe Suggestion System</h1>
        <div className="content">
          <div className="flex-container">
            <RecipeSuggestions recipes={recipes} />
            <FridgeContents contents={fridgeContents} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
