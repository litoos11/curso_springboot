package com.litoos11.oracle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.litoos11.oracle.component.ContactConverter;
import com.litoos11.oracle.entity.Contact;
import com.litoos11.oracle.model.ContactModel;
import com.litoos11.oracle.repository.ContactRepository;
import com.litoos11.oracle.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		// TODO Auto-generated method stub
		Contact contact = contactRepository.save(contactConverter.convertContactModelToContact(contactModel));
				
		return contactConverter.convertContactToContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactModel = new ArrayList<ContactModel>();		
		for(Contact contact : contacts) {
			contactModel.add(contactConverter.convertContactToContactModel(contact));
		}
			
		return contactModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContactToContactModel(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(contact);
		}		
	}

}
