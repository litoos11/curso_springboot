package com.litoos11.oracle.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.litoos11.oracle.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	@GetMapping("checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel contactModel = new ContactModel(2, "Juan", "Ortiz", "123456789", "Soledad");
		return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
	}

}
