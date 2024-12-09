import React, { useState, useEffect } from "react";
import FridgeContents from "./FridgeContents";
import RecipeSuggestions from "./RecipeSuggestions";

const App = () => {
  const [fridgeContents, setFridgeContents] = useState([]);
  const [recipes, setRecipes] = useState({ complete: [], "semi-complete": [] });
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    fetch("/data.json") // Fetch from the public directory
      .then((response) => response.json())
      .then((data) => {
        setFridgeContents(data.fridgeContents);
        setRecipes(data.recipes);
        setIsLoading(false);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="app">
      <h1>Recipe Suggestion System</h1>
      <div className="black-rectangle">
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
