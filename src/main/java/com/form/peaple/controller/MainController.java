package com.form.peaple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.form.peaple.model.entities.Person;
import com.form.peaple.model.entities.PersonFieldsBuilder;
import com.form.peaple.model.services.PeapleService;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

@Controller
public class MainController {
	
	PersonFieldsBuilder builder = new PersonFieldsBuilder();
	
	@Autowired
	PeapleService service;
	    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField lastnameField;  
    
    @FXML
    private TextField cpfField;
    
    @FXML
    private TextField titleField;
    
    @FXML
    private TextField birthField;
    
    @FXML
    private Button button;
    
    @FXML
    private RadioButton maleField;
    
    @FXML
    private RadioButton femaleField;
    
    
    public void onBtSubscripe() {
    	
    	Person person = builder.getPerson(nameField, cpfField, titleField, birthField, maleField);
    	service.save(person);
    	
    }
    
    
}
