import React, { useState, useEffect } from "react";
import FridgeContents from "./FridgeContents";
import RecipeSuggestions from "./RecipeSuggestions";

const App = () => {
  const [fridgeContents, setFridgeContents] = useState([]);
  const [completeRecipes, setCompleteRecipes] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetch("/data.json")
      .then((response) => response.json())
      .then((data) => {
        // Transform API data to the structure expected by RecipeSuggestions
        const transformedRecipes = {
          complete: data.map((recipe) => ({
            name: recipe.recipeName,
            steps: ["Sample step 1", "Sample step 2"], // Placeholder until full API implementation
            ingredients: ["Sample ingredient 1", "Sample ingredient 2"] // Placeholder
          })),
          "semi-complete": [] // No semi-complete recipes yet
        };
        setCompleteRecipes(transformedRecipes);
        setIsLoading(false);
      })
      .catch((error) => console.error("Error fetching completeRecipes data:", error));
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="page" >
    <div className="app">
      <h1>Recipe Suggestion System</h1>
        <div className="content">
          <div className="flex-container">
            <RecipeSuggestions recipes={completeRecipes} />
            <FridgeContents contents={fridgeContents} />
          </div>
        </div>

    </div>
    </div>
  );
};

export default App;
