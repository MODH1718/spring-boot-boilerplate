package com.octo.boilerplate.springboot.repository;

import com.octo.boilerplate.springboot.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository  extends JpaRepository<Personne,Long> {


}
