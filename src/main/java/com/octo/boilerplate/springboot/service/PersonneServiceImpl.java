package com.octo.boilerplate.springboot.service;

import com.octo.boilerplate.springboot.model.Personne;
import com.octo.boilerplate.springboot.repository.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService{
    private final PersonneRepository personneRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Personne createPersonne(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne updatePersonne(Long id, Personne personne) {
        return personneRepository.findById(id)
        .map(p-> {
            p.setNom(personne.getNom());
            p.setPrenom(personne.getPrenom());
        return personneRepository.save(p);
        }).orElseThrow(()->new RuntimeException("Personne introuvable"));
    }

    @Override
    public List<Personne> getAllPersonne() {
        return personneRepository.findAll();
    }

    @Override
    public String deletePersonne(Long id) {
        personneRepository.deleteById(id);
        return "Personne supprimé";
    }

    @Override
    public List<Personne> getPersonnesByAge(int age) {
        return personneRepository.findAll().stream()
                .filter(personne -> personne.getAge() == age)
                .collect(Collectors.toList());
    }

}
