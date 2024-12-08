import React, { useState } from "react";
import FridgeContents from "./FridgeContents";
import RecipeSuggestions from "./RecipeSuggestions";
import './App.css'; // Ensure this line imports the CSS file

const App = () => {
  const [fridgeContents] = useState([
    { name: "Egg", date: "2024-12-10" },
    { name: "Banana", date: "2024-12-09" },
    { name: "Milk", date: "2024-12-08" },
  ]);
  const [recipes] = useState({
    complete: [
      {
        name: "Banana Pancakes",
        steps: ["Mix ingredients", "Cook on skillet"],
        ingredients: ["Banana", "Egg", "Milk"],
      },
    ],
    "semi-complete": [
      {
        name: "Scrambled Eggs",
        steps: ["Crack eggs", "Cook on pan"],
        ingredients: ["Egg", "Butter"],
      },
    ],
  });

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

