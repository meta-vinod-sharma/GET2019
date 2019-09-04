package com.metacube.Session7.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.metacube.Session7.service.MailSender;

@Component
public class SmtpMailSender implements MailSender {

	private static final Logger log = LoggerFactory
			.getLogger(SmtpMailSender.class);
	
	@Override
	public void sendMail(){
		log.info("SmtpMail Sent");
	}

}


//   BY Using Configuration
//public class SmtpMailSender implements Mail {
//
//	private static final Logger log = LoggerFactory
//			.getLogger(SmtpMailSender.class);
//	
//	@Override
//	public void sendMail(){
//		log.info("SmtpMail Sent");
//	}
//
//}
