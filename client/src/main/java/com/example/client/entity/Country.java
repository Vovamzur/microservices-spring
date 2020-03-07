package com.example.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "name is mandatory")
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank(message = "currency is mandatory")
    @Column(name = "currency")
    private String currency;

    @Size(min=1, message = "should pass at least one language")
    @ElementCollection
    @Column(name = "language")
    private Set<@NotBlank String> languages = new HashSet<>();

    @NotBlank(message = "capital is mandatory")
    @Column(name = "capital", unique = true)
    private String capital;

    @Min(value = 1, message = "Population should be unsigned number")
    @Digits(integer=10, fraction = 0, message = "Population should be unsigned long")
    @NotNull(message = "population can't be null")
    @Column(name = "population")
    private long population;

    @NotBlank(message = "phonePrefix is mandatory")
    @Column(name = "phonePrefix")
    private String phonePrefix;

    @Min(value=1, message = "Budget should be bigger than 1")
    @Digits(integer=12, fraction = 0, message = "Budget should be unsigned long")
    @NotNull(message = "budget can't be null")
    @Column(name = "budget")
    private long budget;

    @Min(value=1, message = "GDP should be bigger than 1")
    @Digits(integer=15, fraction = 0, message = "GDP should be unsigned long")
    @NotNull(message = "gdp can't be null")
    @Column(name = "gdp")
    private long gdp;
}
