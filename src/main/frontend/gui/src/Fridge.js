import React, { useEffect, useState } from "react";
import axios from "axios";

const Fridge = () => {
  const [ingredients, setIngredients] = useState([]);

  useEffect(() => {
    // Fetch fridge ingredients from backend
    axios.get("http://localhost:8080/api/fridge/ingredients")
      .then(response => setIngredients(response.data))
      .catch(error => console.error("Error fetching ingredients:", error));
  }, []);

  return (
    <div>
      <h1>Fridge Ingredients</h1>
      <ul>
        {ingredients.map((ingredient, index) => (
          <li key={index}>{ingredient}</li>
        ))}
      </ul>
    </div>
  );
};

export default Fridge;
