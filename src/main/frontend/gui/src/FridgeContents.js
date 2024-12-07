import React from "react";

const FridgeContents = ({ contents }) => {
    return (
        <div className="fridge-contents">
            <h2>Fridge Contents</h2>
            <ul>
                {contents.map((item) => (
                    <li key={item.name}>
                        {item.name} - Expiry: {item.date}
                    </li>
                ))}
            </ul>
        </div>
    );
};
export default FridgeContents;