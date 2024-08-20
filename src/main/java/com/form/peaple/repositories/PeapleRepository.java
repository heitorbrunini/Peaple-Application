package com.form.peaple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.peaple.model.entities.Person;

public interface PeapleRepository extends JpaRepository<Person, Long> {	
	
}
