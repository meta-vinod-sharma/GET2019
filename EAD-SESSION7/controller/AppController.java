package com.metacube.Session7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.Session7.service.MailSender;

@RestController
public class AppController {

	private MailSender mail;

//	Constructor injection with @Primary Annotation
	@Autowired
	public AppController(MailSender mail) {
		this.mail = mail;
	}

	

	
//	  setter injection
//	  @Autowired 
//	  public void sendMail(MailSender mail) {
//		  this.mail = mail; 
//		  }
	 
	
	
//	 Dependency injection by name
	 
//	 @Autowired 
//	 public AppController(MailSender smtpMailSender) { 
//		 this.mail =smtpMailSender;
//	  }
	
	
//	 Dependency injection by name
	  
//	 @Autowired 
//	 public AppController(MailSender mockMailSender) {
//		 this.mail = mockMailSender;
//	  }
	 
	
//	 Bean qualifiers
	 
//	 @Autowired 
//	 public AppController(@Qualifier("smtpMailSender")MailSender mail) {
//		 this.mail = mail; 
//	  }
//	
	
//	 Bean qualifiers
	 
//	 @Autowired
//	 public AppController(@Qualifier("mockMailSender")MailSender mail) {  
//		 this.mail = mail;
//	  }
	
	
		
	@RequestMapping("/hello")
	public String helloWorld() {
		mail.sendMail();
		return "Hello";
	}
}