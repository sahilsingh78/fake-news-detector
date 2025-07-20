# 📰 Fake News Detector

A full-stack AI-powered web application that detects whether a news article is **Fake** or **Real** using Natural Language Processing (NLP) and Machine Learning.

---

## 🚀 Features

- 🔍 Detects fake or real news instantly
- ⚙️ REST API backend using **Spring Boot**
- 🧠 Python ML model served via **Flask**
- ⚛️ Beautiful React frontend with live predictions
- 🔁 Real-time request handling and error messages
- 🎨 Clean and responsive UI

---

## 🛠️ Tech Stack

| Layer       | Technology                     |
|------------|----------------------------------|
| Frontend   | React.js, HTML/CSS              |
| Backend    | Spring Boot (Java)              |
| ML API     | Flask (Python), Scikit-learn    |
| Model      | TF-IDF Vectorizer + Logistic Regression |
| Build Tool | Maven                           |

---

## 📁 Folder Structure

```
fake-news-detection-system/
│
├── fake-news-detector-backend/      # Spring Boot Backend
│   └── src/
│       └── main/java/com/sahil/fakenews/
│           ├── controller/
│           ├── service/
│           └── FakeNewsDetectorApplication.java
│       └── resources/
│           └── application.properties
│   └── pom.xml
│
├── fake-news-detector-frontend/     # React Frontend
│   └── src/
│       ├── App.js
│       ├── App.css
│       └── index.js
│   └── public/
│       └── index.html
│
├── ml-api/                          # Python ML API
│   ├── app.py
│   ├── requirements.txt
│   └── model/
│       ├── vectorizer.pkl
│       └── fake_news_model.pkl
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/sahilsingh78/fake-news-detector.git
cd fake-news-detector
```

### 2️⃣ ML API (Python)
```bash
cd ml-api
pip install -r requirements.txt
python app.py
```

### 3️⃣ Backend (Java - Spring Boot)
```bash
cd fake-news-detector-backend
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Frontend (React)
```bash
cd fake-news-detector-frontend
npm install
npm start
```

Visit the app at: `http://localhost:3000`


---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).

---

## 🙋 Author

**Sahil Singh**  
B.Tech IT | Galgotias College of Engineering and Technology  
[GitHub](https://github.com/sahilsingh78)

---
