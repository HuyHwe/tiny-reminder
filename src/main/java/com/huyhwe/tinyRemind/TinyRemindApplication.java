package com.huyhwe.tinyRemind;

import com.huyhwe.tinyRemind.model.User;
import com.huyhwe.tinyRemind.service.MailSenderService;
import com.huyhwe.tinyRemind.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;

@SpringBootApplication
@EnableScheduling
public class TinyRemindApplication {
	@Autowired
	MailSenderService mailSenderService;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TinyRemindApplication.class, args);
	}

	@Scheduled(cron = "0 0 */8 * * *")
	public void sendRemind() {
		new Thread(new Runnable() {
			@Override public void run() {
				ArrayList<User> userSubList = userService.getAllUsers();
				userSubList.forEach(user -> {
					if(user.getVerified()) {
                        try {
                            mailSenderService.sendEmail(user);
                            System.out.println("email sent to: " + user.getName());
                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    }
				});
			}
		}).start();
	}

}
