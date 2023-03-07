package com.octo.boilerplate.springboot.service;

import com.octo.boilerplate.springboot.model.Personne;

import java.util.List;
import java.util.Optional;


public interface PersonneService {
    Personne createPersonne(Personne personne);
    Personne updatePersonne(Long id,Personne personne);
    List<Personne> getAllPersonne();

    String deletePersonne(Long id);
    List<Personne> getPersonnesByAge(int age);

    public Optional<Personne> getPersonneById(Long id);
    List<Personne> getPersonneByName(String nom);


}
