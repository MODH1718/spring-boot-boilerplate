package com.octo.boilerplate.springboot.service;

import com.octo.boilerplate.springboot.model.Personne;

import java.util.List;


public interface PersonneService {
    Personne createPersonne(Personne personne);
    Personne updatePersonne(Long id,Personne personne);
    List<Personne> getAllPersonne();

    String deletePersonne(Long id);
    List<Personne> getPersonnesByAge(int age);



}
