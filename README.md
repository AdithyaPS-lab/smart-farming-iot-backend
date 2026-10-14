# Smart Farming IoT System & Dashboard 🌾🤖

A full-stack IoT telemetry system designed for smart agricultural monitoring. Features a Spring Boot Java backend, live web dashboard, MySQL data persistence, and a simulated hardware telemetry node.

## 🚀 Features

- **Real-Time Telemetry:** Collects temperature, humidity, and soil moisture data via REST API endpoints (`/api/agri/telemetry`).
- **Web Dashboard:** Interactive HTML/JS frontend providing live sensor metrics and node management (CRUD operations).
- **Automated Startup:** Includes a single-click batch script (`start_dashboard.bat`) to launch backend services and open the dashboard automatically.
- **Hardware Node Simulation:** Python script (`hardware_node.py`) sending scheduled telemetry data to the server.

## 📁 Repository Structure

```text
├── src/                    # Spring Boot Application (Controllers, Repositories, Entities)
│   ├── main/resources/static/ # Web Dashboard (index.html)
├── hardware_node.py        # Python IoT Telemetry Simulation Node
├── start_dashboard.bat     # One-Click Launch Script
├── pom.xml                 # Maven Project Dependencies
└── README.md               # Project Documentation