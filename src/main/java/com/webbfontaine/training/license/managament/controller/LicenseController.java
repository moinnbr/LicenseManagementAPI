package com.webbfontaine.training.license.managament.controller;

import com.webbfontaine.training.license.managament.entity.License;
import com.webbfontaine.training.license.managament.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/licenses")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;



    /**
     * Endpoint to demonstrate eager loading using EntityGraph.
     * Fetches licenses and related entities in a single query.
     */
    @GetMapping()
    public List<License> getLicenses() {
        return licenseService.getAll();
    }
}
