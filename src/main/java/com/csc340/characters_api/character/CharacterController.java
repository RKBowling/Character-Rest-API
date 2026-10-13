package com.csc340.characters_api.character;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController 
@RequestMapping ("/api/characters")
public class CharacterController {

    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping 
    public List<MKCharacter> list(@RequestParam (required = false) String name,
          @RequestParam (required = false) Realm realm) {
        return service.search(name, realm);
}

@GetMapping("/{id}")
public MKCharacter get(@PathVariable Long id) {
    return service.findById(id);
}

@PostMapping 
@ResponseStatus(HttpStatus.CREATED)
public MKCharacter create(@Valid @RequestBody MKCharacter character) {
    return service.create(character);
}
@PutMapping("/{id}")
public MKCharacter update(@PathVariable Long id, @Valid @RequestBody MKCharacter character) {
    return service.update(id, character);
} 

@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id) {
    service.delete(id);
}
}