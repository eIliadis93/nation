package com.qualco.nation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long regionId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "continent_id")
    private Continent continent;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Country> countries;
}
