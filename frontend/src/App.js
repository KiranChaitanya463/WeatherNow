import React, { useState } from "react";
import "./App.css";

function App() {
  const [city, setCity] = useState("");
  const [weather, setWeather] = useState(null);
  const [error, setError] = useState(null);

  const getWeather = async () => {
    if (!city) return;

    try {
      const res = await fetch(`http://localhost:8080/api/weather?city=${city}`);
      if (!res.ok) throw new Error("City not found");

      const data = await res.json();
      setWeather(data);
      setError(null);
    } catch (err) {
      setError(err.message);
      setWeather(null);
    }
  };

  return (
    <div className="app">
      <h1 className="title">🌦️ WeatherNow </h1>

      <div className="search-box">
        <input
          type="text"
          placeholder="Enter city name..."
          value={city}
          onChange={(e) => setCity(e.target.value)}
        />
        <button onClick={getWeather}>Get Weather</button>
      </div>

      {error && <p className="error">{error}</p>}

      {weather && (
        <div className="weather-card">
          <h2>
            {weather.city}, {weather.country}
          </h2>
          <p className="temp">{weather.temperature}°C</p>
          <p className="desc">{weather.description}</p>
        </div>
      )}
    </div>
  );
}

export default App;
