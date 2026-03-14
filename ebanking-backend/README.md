📚 Digital Banking System – AI-Powered Monitoring

A full-stack Digital Banking Application with Spring Boot backend, Angular frontend, MySQL database, and AI-powered monitoring & anomaly detection using Prometheus and Grafana.

🚀 Features

Full banking API (accounts, transactions, transfers)

Angular frontend for user interaction

MySQL database for persistent storage

Real-time metrics collection via Spring Boot Actuator

Monitoring and visualization with Prometheus and Grafana

Supports AI anomaly detection on key metrics (latency, errors, CPU/memory usage)

🛠️ Tech Stack
Layer	Technology
Backend	Spring Boot, Spring Data JPA
Frontend	Angular 19
Database	MySQL
Monitoring	Prometheus, Grafana
AI / ML	Python (optional for anomaly detection)
Containerization	Docker, Docker Compose
⚙️ Setup Instructions
1️⃣ Backend
cd ebanking-backend
./mvnw spring-boot:run


API available at: http://localhost:8080

2️⃣ Frontend
cd ebanking-frontend
npm install
ng serve


App available at: http://localhost:4200

3️⃣ MySQL (Docker)
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=banking -p 3306:3306 -d mysql:8

4️⃣ Monitoring Stack (Docker Compose)
cd monitoring
docker compose up -d


Prometheus: http://localhost:9090

Grafana: http://localhost:3000
Default login: admin / admin

Configure Grafana datasource to Prometheus:

URL: http://host.docker.internal:9090

📊 Monitoring Flow
Spring Boot App → Actuator Metrics → Prometheus → Grafana Dashboard → AI Anomaly Detection

📈 Next Steps

Simulate traffic to collect realistic metrics

Configure Grafana dashboards for response time, errors, CPU/memory

Train AI model to detect anomalies in metrics