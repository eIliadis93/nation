package com.qualco.nation.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "continents")
public class Continent {
    @Id
    private Long continentId;

    private String name;
}
