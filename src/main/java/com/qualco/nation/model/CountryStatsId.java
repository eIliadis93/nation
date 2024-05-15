package com.qualco.nation.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CountryStatsId implements Serializable {
    @Column(name = "country_id", insertable = false, updatable = false)
    private Long country_id;
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getCountryId() {
        return country_id;
    }

    public void setCountryId(Long countryId) {
        this.country_id = countryId;
    }
}
