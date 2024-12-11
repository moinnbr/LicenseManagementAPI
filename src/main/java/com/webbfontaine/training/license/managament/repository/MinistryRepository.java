package com.webbfontaine.training.license.managament.repository;

import com.webbfontaine.training.license.managament.entity.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MinistryRepository extends JpaRepository<Ministry, Long> {
}