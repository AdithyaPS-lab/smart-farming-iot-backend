package com.anurag.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
@CrossOrigin(origins = "*")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    // 1. Get all faculty records
    @GetMapping
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // 2. Add new faculty record (with mandatory Name & Email validation)
    @PostMapping
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        if (faculty.getName() == null || faculty.getName().trim().isEmpty() ||
            faculty.getEmail() == null || faculty.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Name and Email are required");
        }
        return ResponseEntity.ok(facultyRepository.save(faculty));
    }

    // 3. Update existing faculty record
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFaculty(@PathVariable Long id, @RequestBody Faculty details) {
        if (details.getName() == null || details.getName().trim().isEmpty() ||
            details.getEmail() == null || details.getEmail().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Name and Email are required");
        }
        return facultyRepository.findById(id).map(faculty -> {
            faculty.setName(details.getName());
            faculty.setDepartment(details.getDepartment());
            faculty.setEmail(details.getEmail());
            faculty.setPhone(details.getPhone());
            return ResponseEntity.ok(facultyRepository.save(faculty));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 4. Delete faculty record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        if (facultyRepository.existsById(id)) {
            facultyRepository.deleteById(id);
            return ResponseEntity.ok().build(); // Fixed: Added () to .build()
        }
        return ResponseEntity.notFound().build();
    }
}