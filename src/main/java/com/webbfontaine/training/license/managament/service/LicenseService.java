package com.webbfontaine.training.license.managament.service;

import com.webbfontaine.training.license.managament.entity.License;
import com.webbfontaine.training.license.managament.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public List<License> getAll() {
        return licenseRepository.findAll();
    }
}
