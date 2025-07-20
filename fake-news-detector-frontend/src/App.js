import React, { useState } from "react";
import "./App.css";

function App() {
  const [text, setText] = useState("");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = async () => {
    setLoading(true);
    setError(null);
    setResult(null);
    try {
      const res = await fetch("http://localhost:8080/api/news/check", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ text }),
      });
      if (!res.ok) throw new Error("HTTP " + res.status);
      const data = await res.json();
      setResult(data.prediction);
    } catch {
      setError("Unable to check news. Please try later.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <h1>📰 Fake News Detector</h1>

      <textarea
        placeholder="Enter news article text here..."
        value={text}
        onChange={(e) => setText(e.target.value)}
      />

      <button onClick={handleSubmit} disabled={!text.trim() || loading}>
        {loading ? "Checking..." : "Check News"}
      </button>

      {error && <div className="error">{error}</div>}
      {result && (
        <div className={`result ${result === "Fake" ? "fake" : "real"}`}>
          Prediction: {result}
        </div>
      )}
    </div>
  );
}

export default App;
