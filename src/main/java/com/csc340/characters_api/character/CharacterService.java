package com.csc340.characters_api.character;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repository;
    
    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }
    public List<MKCharacter> findAll() {
        return repository.findAll();
    }
    public List<MKCharacter> findByRealm(Realm realm) {
        return repository.findByRealm(realm);
    }
    public List<MKCharacter> search(String name, Realm realm) {
        boolean hasName = name != null && !name.isBlank();
    
        if (hasName && realm != null) {
            return repository.findByNameContainingIgnoreCaseAndRealm(name.trim(), realm);
        }
        if (hasName) {
            return repository.findByNameContainingIgnoreCase(name.trim());
        }
        if (realm !=null) {
            return repository.findByRealm(realm);
        }
        return repository.findAll(); 
    }
    public MKCharacter findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }
    public MKCharacter create(MKCharacter character) {
        return repository.save(character);
    }
    public MKCharacter update(Long id, MKCharacter updated) {
        MKCharacter existing = findById(id);
        existing.setName(updated.getName());
        existing.setRealm(updated.getRealm());
        existing.setDescription(updated.getDescription());
        existing.setNewEra(updated.inNewEra());
        return repository.save(existing);
    }
    public void delete (Long id) {
        findById(id);
        repository.deleteById(id);
    }
    }
    

 
