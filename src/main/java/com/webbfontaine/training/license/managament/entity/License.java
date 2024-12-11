package com.webbfontaine.training.license.managament.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LICENSE", schema = "LICENSE_USER")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LICENSE_ID", nullable = false, unique = true)
    private Long licenseId;

    @Column(name = "LICENSE_CODE", nullable = false, unique = true, length = 100)
    private String licenseCode;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "LICENSE_INSPECTOR",
        joinColumns = @JoinColumn(name = "LICENSE_ID"),
        inverseJoinColumns = @JoinColumn(name = "INSPECTOR_ID")
    )
    private Set<Inspector> inspectors = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MINISTRY_ID", referencedColumnName = "MINISTRY_ID", nullable = false)
    private Ministry ministry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_BIN_ID", referencedColumnName = "BIN_ID", nullable = false)
    private CompanyBin company;

    @Override
    public int hashCode() {
        return Objects.hash(licenseId, licenseCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(licenseId, license.licenseId) &&
            Objects.equals(licenseCode, license.licenseCode);
    }
}
