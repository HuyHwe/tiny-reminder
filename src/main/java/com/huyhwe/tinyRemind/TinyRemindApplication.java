package com.huyhwe.tinyRemind;

import com.huyhwe.tinyRemind.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinyRemindApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyRemindApplication.class, args);
	}

}
