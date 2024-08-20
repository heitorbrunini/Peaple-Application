package com.form.peaple.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class PersonFieldsBuilder {

	Person person = new Person();
		
	private void setName(TextField nameField) {
		person.setName(nameField.getText());
	}

	private void setCpf(TextField cpfField) {
		person.setCpf(Long.parseLong(cpfField.getText()));
		
	}

	private void setTitle(TextField titleField) {
		person.setTitle(titleField.getText());
	}

	private void setBirth(TextField birthField) {
		person.setBirth(getDate(birthField.getText()));
	}

	private void setMale(RadioButton male) {
		person.setSex(male.isSelected());
	}
	
	private LocalDate getDate(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
	}
	
	public Person getPerson(TextField nameField,TextField cpfField, TextField titleField,TextField birthField,RadioButton male) {
		this.setCpf(cpfField);
		this.setName(nameField);
		this.setTitle(titleField);
		this.setMale(male);
		this.setBirth(birthField);
		
		return this.person;
	}


}
