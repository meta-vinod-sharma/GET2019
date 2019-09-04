package com.metacube.Session7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.Session7.service.MailSender;
import com.metacube.Session7.service.Impl.MockMailSender;
import com.metacube.Session7.service.Impl.SmtpMailSender;




@Configuration
public class MailConfig {
	
	
	@Bean
	@Primary
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

}
