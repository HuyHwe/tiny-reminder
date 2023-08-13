package com.huyhwe.tinyRemind;

import com.huyhwe.tinyRemind.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class TinyRemindApplication {
	@Autowired
	MailSenderService mailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(TinyRemindApplication.class, args);
	}

	@Scheduled(fixedRate = 2000L)
	public void sendRemind() {
		mailSenderService.sendEmail("huydarthvader@gmail.com", "hello", "holle");

		System.out.println("mail sent ok");
	}

}
