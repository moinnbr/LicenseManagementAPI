package com.webbfontaine.training.license.managament.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "INSPECTOR", schema = "LICENSE_USER")
public class Inspector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INSPECTOR_ID", nullable = false)
    @JsonIgnore
    private Long inspectorId;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "EMAIL", length = 200)
    private String email;

}
