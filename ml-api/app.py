from flask import Flask, request, jsonify
import joblib
from utils.preprocess import clean_text

app = Flask(__name__)

# Load the trained fake news model
model = joblib.load("model/fake_news_model.pkl")
vectorizer = joblib.load("model/vectorizer.pkl")

@app.route('/')
def home():
    return "Fake News Detection API is Running!"

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    text = data.get("text", "")
    
    if not text:
        return jsonify({"error": "No text provided"}), 400

    # Preprocess and vectorize
    cleaned = clean_text(text)
    vect_text = vectorizer.transform([cleaned])
    
    prediction = model.predict(vect_text)[0]
    label = "Fake" if prediction == 1 else "Real"
    
    return jsonify({
        "prediction": label,
        "status": "success"
    })

if __name__ == '__main__':
    app.run(debug=True)
