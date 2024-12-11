package com.webbfontaine.training.license.managament.repository;

import com.webbfontaine.training.license.managament.entity.License;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

    @EntityGraph(attributePaths = {"inspectors", "ministry", "company"})
    List<License> findAll();

}
