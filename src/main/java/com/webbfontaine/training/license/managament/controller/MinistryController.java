package com.webbfontaine.training.license.managament.controller;

import com.webbfontaine.training.license.managament.entity.Ministry;
import com.webbfontaine.training.license.managament.service.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/ministry")
public class MinistryController {
    @Autowired
    private MinistryService ministryService;
    @GetMapping("/{id}")
    public ResponseEntity<Object> getMinistryById(@PathVariable Long id) {
        return ministryService.getMinistryById(id)
                .<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ministry with ID " + id + " not found."));
    }

    @GetMapping
    public ResponseEntity<List<Ministry>> getAllMinistries() {
        return ResponseEntity.ok(ministryService.getAllMinistries());
    }
    @PostMapping
    public ResponseEntity<Ministry> createMinistry(@RequestBody Ministry ministry) {
        return ResponseEntity.ok(ministryService.createMinistry(ministry));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ministry> updateMinistry(@PathVariable Long id, @RequestBody
    Ministry ministry) {
        return ResponseEntity.ok(ministryService.updateMinistry(id, ministry));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMinistry(@PathVariable Long id) {
        ministryService.deleteMinistry(id);
        return ResponseEntity.noContent().build();
    }
}
