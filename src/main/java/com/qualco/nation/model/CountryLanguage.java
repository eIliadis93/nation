package com.qualco.nation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "country_languages")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    private boolean official;

    @JsonBackReference
    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;
}
