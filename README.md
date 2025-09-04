# Health-Ai-Checker

A full-stack **Spring Boot + Thymeleaf + Tailwind** web application that integrates with **Ollama AI** to analyze user symptoms and suggest possible medical conditions.  
I Built it using **Java 17**, it provides a modern and interactive interface for exploring health-related information.

---

## 🚀 Features
- Enter symptoms (e.g., *fever, cough, sore throat*).
- AI suggests **5–7 possible conditions**.
- Click on a condition to see a **detailed explanation** (causes, symptoms, relevance).
- Modern UI with Tailwind CSS, modal popups, and loader animations.
- Runs **locally** with Ollama AI.

---

## 📂 Project Structure
```
Health-Ai-Checker/
├── medical-symptom-checker/
│ ├── src/main/java/com/moredabuhamed/medical_symptom_checker
│ │ ├── controller/ # REST API endpoints
│ │ ├── service/ # OllamaService for AI calls
│ │ ├── model/ # ConditionResult model
│ │ └── MedicalSymptomCheckerApplication.java
│ │
│ ├── src/main/resources
│ │ ├── static/css/ # style.css
│ │ ├── static/js/ # app.js
│ │ ├── templates/ # index.html (Thymeleaf UI)
│ │ └── application.properties
│ │
│ ├── pom.xml # Maven configuration
│
├── README.md
└── .gitignore
```
---
## 🛠 Tech Stack

Backend: Java 17, Spring Boot 3.5.5 (Web, WebFlux, Thymeleaf)

Frontend: html,Tailwind CSS, Vanilla JS

AI: Ollama (DeepSeek R1 model)

Build Tool: Maven

---
