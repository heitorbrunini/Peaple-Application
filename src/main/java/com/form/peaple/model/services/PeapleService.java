package com.form.peaple.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.peaple.model.entities.Person;
import com.form.peaple.repositories.PeapleRepository;

@Service
public class PeapleService {

	@Autowired
	private PeapleRepository repository;
	
	public void save(Person newPerson) {
		repository.save(newPerson);
		
	}
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person findById(Long CPF) {
		return repository.findById(CPF).get();
	}
	
	public void delete(Long CPF) {
		repository.delete(findById(CPF));
	}	
	
	public Person edit(Long CPF, Person newPerson) {
		Person old = findById(CPF);
		old.setBirth(newPerson.getBirth());
		old.setCpf(newPerson.getCpf());
		old.setSex(newPerson.getSex());
		old.setName(newPerson.getName());
		old.setTitle(newPerson.getTitle());
		
		repository.save(old);
		
		return old;
	}
}
