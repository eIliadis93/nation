package com.qualco.nation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    private String name;
    private Double area;

    @Column(name = "national_day")
    private String nationalDay;

    @Column(name = "country_code2", unique = true)
    private String countryCode2;

    @Column(name = "country_code3", unique = true)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    @JsonBackReference
    private Region region;
}
