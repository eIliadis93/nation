package com.qualco.nation.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "languages")
public class Language {
    @Id
    private Long languageId;

    private String language;
}
