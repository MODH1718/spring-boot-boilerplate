package com.octo.boilerplate.springboot.controller;

import com.octo.boilerplate.springboot.model.Personne;
import com.octo.boilerplate.springboot.service.PersonneService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneController {
    public final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping("/create")
    public Personne create(@RequestBody Personne personne) {
        return personneService.createPersonne(personne);

    }

    @GetMapping("/read")
    public List<Personne> read() {
        return personneService.getAllPersonne();

    }

    @PutMapping("/update/{id}")
    public Personne update(@PathVariable Long id, @RequestBody Personne personne) {
        return personneService.updatePersonne(id, personne);

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return personneService.deletePersonne(id);

    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Personne>> getPersonnesByAge(@PathVariable int age) {
        List<Personne> personnes = personneService.getPersonnesByAge(age);
        if (personnes.isEmpty()) {
            throw new EntityNotFoundException("Aucune personne trouvée avec l'âge : " + age);
        }
        return ResponseEntity.ok(personnes);
    }

}

