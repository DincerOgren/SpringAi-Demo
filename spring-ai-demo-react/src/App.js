import './App.css';
import { useState } from 'react';
import ImageGenerator from './Components/ImageGenerator';
import Chat from './Components/Chat';

function App() {
  const [activeTab, setActiveTab] = useState("image-generator");

  const handleClick = (tab) => {
    setActiveTab(tab);
  };

  return (
    <div className="App">
      <div className="tab-buttons">
        <button
          onClick={() => handleClick("image-generator")}
          className={activeTab === "image-generator" ? "active" : ""}
        >
          Image Generator
        </button>
        <button
          onClick={() => handleClick("chat")}
          className={activeTab === "chat" ? "active" : ""}
        >
          Chat
        </button>
      </div>

      <div className="tab-content">
        {activeTab === "image-generator" && <ImageGenerator />}
        {/* Need working openai api key for running chat service */}
        {/* {activeTab === "chat" && <Chat />} */}
      </div>
    </div>
  );
}

export default App;
