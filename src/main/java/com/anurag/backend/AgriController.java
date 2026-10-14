package com.anurag.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agri")
@CrossOrigin(origins = "*")
public class AgriController {

    @Autowired
    private SensorRepository sensorRepository;

    // 1. READ: Get all telemetry logs
    @GetMapping("/telemetry")
    public List<SensorData> getAllReadings() {
        return sensorRepository.findAll();
    }

    // 2. CREATE: Log new sensor reading
    @PostMapping("/telemetry")
    public SensorData createReading(@RequestBody SensorData data) {
        return sensorRepository.save(data);
    }

    // 3. UPDATE: Edit existing log by ID
    @PutMapping("/telemetry/{id}")
    public SensorData updateReading(@PathVariable Long id, @RequestBody SensorData updatedData) {
        return sensorRepository.findById(id).map(sensor -> {
            sensor.setFieldName(updatedData.getFieldName());
            sensor.setSoilMoisture(updatedData.getSoilMoisture());
            sensor.setTemperature(updatedData.getTemperature());
            sensor.setHumidity(updatedData.getHumidity());
            sensor.setPumpStatus(updatedData.getPumpStatus());
            return sensorRepository.save(sensor);
        }).orElseThrow(() -> new RuntimeException("Record not found with ID: " + id));
    }

    // 4. DELETE: Delete log entry by ID
    @DeleteMapping("/telemetry/{id}")
    public String deleteReading(@PathVariable Long id) {
        sensorRepository.deleteById(id);
        return "Record with ID " + id + " deleted successfully.";
    }
}