package com.octo.boilerplate.springboot.controller;

import com.octo.boilerplate.springboot.exception.PersonneNotFound;
import com.octo.boilerplate.springboot.model.Personne;
import com.octo.boilerplate.springboot.service.PersonneService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
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
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        return personneService.getPersonneById(id)
                .map(p -> ResponseEntity.ok().body(p))
                .orElseThrow(() -> new PersonneNotFound("Personne non trouvée avec l'ID: " + id));
    }






    /*public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        Optional<Personne> personne = personneService.getPersonneById(id);
        return personne.map(p -> ResponseEntity.ok().body(p))
                .orElseGet(() -> ResponseEntity.notFound().build());*//*
    }*/


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
            throw new EntityNotFoundException("Aucune personne trouvée avec l'âge de :  " + age + " ans ");
        }
        return ResponseEntity.ok(personnes);
    }

    @GetMapping("/find/{nom}")
    public ResponseEntity<List<Personne>>getPersonneByName(@PathVariable String nom) {
        List<Personne> personnes = personneService.getPersonneByName(nom);
        if (personnes.isEmpty()) {
            throw new EntityNotFoundException("Aucune personne trouvée");
        }
        return ResponseEntity.ok(personnes);

    }


}

