package com.csc340.characters_api.character;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "characters")
public class MKCharacter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String name;


    @NotBlank
    private String description;


    @NotNull
    @Enumerated(EnumType.STRING)
    private Realm realm;


   
    private boolean newEra;


    public MKCharacter() {
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Realm getRealm() {
        return realm;
    }
    public void setRealm(Realm realm) {
        this.realm = realm;
    }
    public boolean inNewEra() {
        return newEra;
    }
    public void setNewEra(boolean newEra) {
        this.newEra = newEra;
    }










}
