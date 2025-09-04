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
## 🖼️ Screenshot

### 🏠 Main Interface
Main interface of the Health-AI-Checker application
<img width="1916" height="640" alt="image" src="https://github.com/user-attachments/assets/cfb64fd0-959d-4076-bd79-277c39743ed9" />
### ⏳ Loading State
Loading screen while the system analyzes symptoms
<img width="1131" height="607" alt="image" src="https://github.com/user-attachments/assets/17dee52d-fd6f-432a-bb32-28e7e23e3db5" />
### ✅ Results Page
AI-generated possible conditions based on entered symptoms  
<img width="1406" height="685" alt="image" src="https://github.com/user-attachments/assets/209063e1-3878-4554-986a-ab8b578e489b" />
### 🔍 Condition Details
Detailed explanation for a selected condition
<img width="1292" height="713" alt="image" src="https://github.com/user-attachments/assets/35340914-9c91-48b8-9336-1fa14ef3d623" />


