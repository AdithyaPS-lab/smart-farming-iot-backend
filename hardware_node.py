import requests
import time
import random

API_URL = "http://localhost:8080/api/agri/telemetry"

print("--- Hardware Node Online (Sending Sensor Data) ---")

while True:
    soil = round(random.uniform(15.0, 50.0), 1)
    temp = round(random.uniform(25.0, 34.0), 1)
    hum = round(random.uniform(50.0, 75.0), 1)
    pump_on = soil < 30.0

    payload = {
        "fieldName": "ESP32-Hardware-Node-01",
        "soilMoisture": soil,
        "temperature": temp,
        "humidity": hum,
        "pumpStatus": pump_on
    }

    try:
        res = requests.post(API_URL, json=payload)
        print(f"[IoT Node] Sent -> Soil: {soil}% | Temp: {temp}°C | HTTP Status: {res.status_code}")
    except Exception as e:
        print(f"[IoT Node] Error connecting to REST API: {e}")

    time.sleep(30)