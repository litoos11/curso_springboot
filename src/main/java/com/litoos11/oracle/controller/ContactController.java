package com.litoos11.oracle.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.litoos11.oracle.constant.ViewConstant;
import com.litoos11.oracle.model.ContactModel;
import com.litoos11.oracle.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	public static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	
	@GetMapping("/cancel")
	public String cancel() {
		//return ViewConstant.CONTACTS;
		return "redirect:/contacts/showcontacts";
	}

	@PreAuthorize ("hasRole ('ROLE_ADMIN')")
	@GetMapping("/contactform")	
	private String redirectContactForm(@RequestParam(name="id", required=false) int id,
			Model model) {
		LOG.info("METHOD: redirectContactForm() ");
		ContactModel contact = new ContactModel();
		if(id != 0) {
			contact = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}
	
	//@PreAuthorize ("hasRole ('ROLE_ADMIN')")
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,
			Model model) {
		LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
		
		if(null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
				
		//return ViewConstant.CONTACTS;
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts(){
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return showContacts();
	}
}
