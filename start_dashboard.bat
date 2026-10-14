@echo off
cd /d "C:\Users\Hello\Desktop\tt\backend"

:: Kill any existing Java background process
taskkill /F /IM java.exe >nul 2>&1

:: Start Spring Boot Server silently in background
start /B java -jar target/backend-0.0.1-SNAPSHOT.jar

:: Wait 8 seconds for Spring Boot server initialization
timeout /t 8 /nobreak >nul

:: Start Python Hardware Emulator in background
start /B python hardware_node.py

:: Open Dashboard directly in your default Web Browser
start http://localhost:8080/index.html