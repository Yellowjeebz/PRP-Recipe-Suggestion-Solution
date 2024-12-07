import React from "react";



const RecipeSuggestions = ({ recipes }) => {

    return (

        <div className="recipe-suggestions">

            <h2>Recipes</h2>

            {["Complete", "Semi-Complete", "Incomplete"].map((category) => (

                <div key={category}>

                    <h3>{category}</h3>

                    <ul>

                        {recipes[category.toLowerCase()].map((recipe) => (

                            <li key={recipe.name}>

                                <h4>{recipe.name}</h4>

                                <p>Steps:</p>

                                <ul>

                                    {recipe.steps.map((step, idx) => (

                                        <li key={idx}>{step}</li>

                                    ))}

                                </ul>

                                <p>Ingredients:</p>

                                <ul>

                                    {recipe.ingredients.map((ing, idx) => (

                                        <li key={idx}>{ing}</li>

                                    ))}

                                </ul>

                            </li>

                        ))}

                    </ul>

                </div>

            ))}

        </div>

    );

};



export default RecipeSuggestions;

