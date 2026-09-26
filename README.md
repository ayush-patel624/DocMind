# DocMind - RAG-Based Document Intelligence System

DocMind is an advanced Retrieval-Augmented Generation (RAG) platform that allows users to upload documents and converse with them using Artificial Intelligence. Built with a modern tech stack, DocMind securely ingests your files, vectorizes the content, and provides context-aware answers to your queries.

## 🚀 Features

- **Document Ingestion:** Upload and process various document formats (PDFs, Text, etc.).
- **Intelligent Q&A:** Chat with your documents using context-aware LLM responses powered by Spring AI.
- **Secure Authentication:** JWT-based user authentication and authorization.
- **Vector Search:** Highly efficient similarity search utilizing PostgreSQL with the pgvector extension.
- **Modern UI:** A clean, responsive frontend built with React, Vite, and TypeScript.
- **Persistent Chat Memory:** Chat histories are saved and contextually maintained across sessions.

## 🛠️ Technology Stack

**Backend:**
- Java 21
- Spring Boot 3.x
- Spring Security (JWT Authentication)
- Spring AI (Integration with OpenAI & Vector DB)
- PostgreSQL (with `pgvector` for vector storage)
- Maven

**Frontend:**
- React 18
- TypeScript
- Vite
- Modern UI Components

## ⚙️ Prerequisites

- **Java 21** or higher
- **Node.js 18+** & npm
- **Docker** and **Docker Compose** (for running PostgreSQL with pgvector)
- **OpenAI API Key**

## 🏃‍♂️ Getting Started

### 1. Database Setup
Start the PostgreSQL database with the `pgvector` extension using Docker Compose:
```bash
docker-compose up -d
```

### 2. Backend Setup
Navigate to the root directory and configure your environment:
- Open `src/main/resources/application.yaml` (or `application-dev.yml`).
- Add your OpenAI API key and verify the database connection settings.

Run the Spring Boot application:
```bash
./mvnw spring-boot:run
```
The backend API will start on `http://localhost:8080`.

### 3. Frontend Setup
Navigate to the frontend directory:
```bash
cd frontend/docmind-frontend
```

Install dependencies:
```bash
npm install
```

Start the development server:
```bash
npm run dev
```
The application UI will be accessible at `http://localhost:5173`.

## 🔒 Security & Privacy

DocMind employs a robust authentication mechanism. Each user's documents and chat histories are completely isolated, ensuring that you only have access to the data you upload and interact with.

## 📄 License

This project is open-source and available under the MIT License.
