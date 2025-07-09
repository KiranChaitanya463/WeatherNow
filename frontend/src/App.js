import React, { useState } from 'react';
import './App.css';

function App() {
  const [city, setCity] = useState('');
  const [weather, setWeather] = useState(null);

  const handleSearch = async () => {
    const response = await fetch(`http://localhost:8080/api/weather?city=${city}`);
    const data = await response.json();
    setWeather(data);
  };

  return (
    <div className="App">
      <h1>Weather App</h1>

      <input
        type="text"
        value={city}
        onChange={e => setCity(e.target.value)}
        placeholder="Enter city"
      />

      <button onClick={handleSearch}>Get Weather</button>

      {weather && (
        <div>
          <h2>{weather.name}</h2>
          <p>Temperature: {weather.main.temp} °C</p>
          <p>Condition: {weather.weather[0].description}</p>
        </div>
      )}
    </div>
  );
}

export default App;
