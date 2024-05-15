package com.qualco.nation.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "country_stats")
public class CountryStats {

    @EmbeddedId
    private CountryStatsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    @Column(name = "population")
    private int population;

    @Column(name = "gdp")
    private long gdp;
}
