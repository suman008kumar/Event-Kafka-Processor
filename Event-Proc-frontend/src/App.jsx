import React, { useState, useEffect } from "react";

function App() {
  const [topic, setTopic] = useState("my_new_topic");
  const [message, setMessage] = useState("");
  const [events, setEvents] = useState([]);

  
  const loadEvents = async () => {
    try {
      const res = await fetch("http://localhost:8080/api/events");
      const data = await res.json();
      setEvents(data);
    } catch (err) {
      console.error("Error loading events:", err);
    }
  };

  
  const sendMessage = async () => {
    try {
      await fetch(`http://localhost:8080/api/test/send/${topic}`, {
        method: "POST",
        headers: { "Content-Type": "text/plain" },
        body: message
      });

      alert("Message Sent!");

      
      loadEvents();
    } catch (err) {
      console.error("Send Message Error:", err);
    }
  };

  useEffect(() => {
    loadEvents();
  }, []);

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>Kafka - Simple Frontend</h2>

      <div style={{ marginBottom: "20px" }}>
        <label>Topic Name: </label>
        <input
          value={topic}
          onChange={(e) => setTopic(e.target.value)}
        />
      </div>

      <div style={{ marginBottom: "20px" }}>
        <label>Message: </label>
        <input
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          style={{ width: "300px" }}
        />
      </div>

      <button onClick={sendMessage} style={{ padding: "10px 20px" }}>
        Send Message
      </button>

      <hr />

      <h3>Stored Events from PostgreSQL</h3>
      <button onClick={loadEvents} style={{ marginBottom: "10px" }}>
        Reload
      </button>

      
      <ul>
        {events.length === 0 ? (
          <p>No events found.</p>
        ) : (
          events.map((e) => (
            <li key={e.id} style={{ marginBottom: "5px" }}>
              <strong><span style={{color:"red"}}>{e.topicName}</span></strong> — <span style={{color:"brown"}}>{e.content}</span> —{" "}
             <span style={{color:"green"}}>{e.receivedAt}</span>
            </li>
          ))
        )}
      </ul>
    </div>
  );
}

export default App;
