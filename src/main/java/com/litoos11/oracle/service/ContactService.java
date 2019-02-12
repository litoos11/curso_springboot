package com.litoos11.oracle.service;

import java.util.List;

import com.litoos11.oracle.entity.Contact;
import com.litoos11.oracle.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract ContactModel findContactByIdModel(int id);
	
	public abstract void removeContact(int id);

}
