import React, { useState } from 'react';
import './ImageGenerator.css';

function ImageGenerator() {
  const [prompt, setPrompt] = useState('');
  const [imageStyle, setImageStyle] = useState('cinematic');
  const [imageUrl, setImageUrl] = useState(null);
  const [loading, setLoading] = useState(false);

  const generateImage = async () => {
    setLoading(true);
    try {
      const response = await fetch(`http://localhost:8080/generate?prompt=${encodeURIComponent(prompt)}&imageStyle=${imageStyle}`, {
        method: 'POST',
      });

      if (!response.ok) throw new Error('Image generation failed');

      const blob = await response.blob();
      const url = URL.createObjectURL(blob);
      setImageUrl(url);
    } catch (error) {
      console.error(error);
      alert('Error generating image');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="image-generator-container">
      <h2>AI Image Generator</h2>
      <div className="image-generator-input-group">
        <input
          type="text"
          placeholder="Enter prompt"
          value={prompt}
          onChange={(e) => setPrompt(e.target.value)}
        />
        <button onClick={generateImage} disabled={loading}>
          {loading ? 'Generating...' : 'Generate Image'}
        </button>
      </div>

      {imageUrl && (
        <div className="generated-image-preview">
          <img src={imageUrl} alt="Generated" />
        </div>
      )}
    </div>
  );
}

export default ImageGenerator;
