import React, { useState, useEffect } from 'react';

function Window1() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('https://api.example.com/data1')
      .then(response => response.json())
      .then(data => setData(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <h2>Window 1</h2>
      <ul>
        {data.map(item => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default Window1;