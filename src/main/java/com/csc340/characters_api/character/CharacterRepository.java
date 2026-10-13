package com.csc340.characters_api.character;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<MKCharacter, Long> {

    List<MKCharacter> findByRealm(Realm realm);

    List<MKCharacter> findByNameContainingIgnoreCase(String name);

    List<MKCharacter> findByNameContainingIgnoreCaseAndRealm(String name, Realm realm);

}
