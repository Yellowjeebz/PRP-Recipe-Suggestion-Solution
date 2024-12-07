import React, { useState } from "react";
import FridgeContents from "./FridgeContents";
import RecipeSuggestions from "./RecipeSuggestions";

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
    incomplete: [
      {
        name: "Beef Stew",
        steps: ["Chop vegetables", "Cook meat"],
        ingredients: ["Beef", "Carrots", "Potatoes"],
      },
    ],
  });

  return (
    <div className="app">
      <h1>Recipe Suggestion System</h1>
      <div className="content">
        <FridgeContents contents={fridgeContents} />
        <RecipeSuggestions recipes={recipes} />
      </div>
    </div>
  );
};

export default App;