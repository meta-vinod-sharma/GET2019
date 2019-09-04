package com.metacube.Session7.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.metacube.Session7.service.MailSender;

@Component
public class MockMailSender implements MailSender{
	
	private static final Logger log = LoggerFactory.getLogger(MockMailSender.class);
	
	@Override
	public void sendMail(){
		log.info("SmtpMail Sent");
	}

}
