// import React from "react";

// const RecipeSuggestions = ({ recipes }) => {
//   return (
//     <div className="recipe-suggestions">
//       <h2>Recipes</h2>

//       {["Complete", "Semi-Complete"].map((category) => (
//         <div key={category}>
//           <h3>{category}</h3>

//           <ul>
//             {recipes[category.toLowerCase()].map((recipe) => (
//               <li key={recipe.name}>
//                 <h4>{recipe.name}</h4>

//                 <p>Steps:</p>

//                 <ul>
//                   {recipe.steps.map((step, idx) => (
//                     <li key={idx}>{step}</li>
//                   ))}
//                 </ul>

//                 <p>Ingredients:</p>

//                 <ul>
//                   {recipe.ingredients.map((ing, idx) => (
//                     <li key={idx}>{ing}</li>
//                   ))}
//                 </ul>
//               </li>
//             ))}
//           </ul>
//         </div>
//       ))}
//     </div>
//   );
// };

// export default RecipeSuggestions;
import React, { useState } from "react";
import './App.css'; // Add this to style the modal and layout

const RecipeSuggestions = ({ recipes }) => {
  const [selectedRecipe, setSelectedRecipe] = useState(null);

  const closeModal = () => {
    setSelectedRecipe(null);
  };

  return (
    <div className="recipe-suggestions">
      <h2>Recipes</h2>

      {["Complete", "Semi-Complete"].map((category) => (
        <div key={category}>
          <h3>{category}</h3>

          <ul>
            {recipes[category.toLowerCase()].map((recipe) => (
              <li
                key={recipe.name}
                onClick={() => setSelectedRecipe(recipe)} // Set the clicked recipe
                className="recipe-item"
              >
                <h4>{recipe.name}</h4>
              </li>
            ))}
          </ul>
        </div>
      ))}

      {/* Modal for Recipe Details */}
      {selectedRecipe && (
        <div className="modal-overlay">
          <div className="modal">
            <button className="close-button" onClick={closeModal}>
              X
            </button>
            <h2>{selectedRecipe.name}</h2>
            <div className="modal-content">
              <div className="steps">
                <h3>Steps</h3>
                <ul>
                  {selectedRecipe.steps.map((step, idx) => (
                    <li key={idx}>{step}</li>
                  ))}
                </ul>
              </div>
              <div className="ingredients">
                <h3>Ingredients</h3>
                <ul>
                  {selectedRecipe.ingredients.map((ing, idx) => (
                    <li key={idx}>{ing}</li>
                  ))}
                </ul>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default RecipeSuggestions;
