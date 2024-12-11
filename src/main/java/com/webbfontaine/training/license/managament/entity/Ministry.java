package com.webbfontaine.training.license.managament.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "MINISTRY", schema = "LICENSE_USER")
public class Ministry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MINISTRY_ID", nullable = false)
    private Long ministryId;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "EMAIL", length = 500)
    private String email;
}