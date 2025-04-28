package mylab.notification.di.annot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.*;

@Configuration()
public class NotificationConfig {
	
	@Bean
	public EmailNotificationService EmailNotificationService() {
		// smtp 서버와 포트 번호 설정
		return new EmailNotificationService("SMTP", 3307);
	}
	
	@Bean
	public SmsNotificationService SmsNotificationService() {
		return new SmsNotificationService("apple");
	}
	
	@Bean
	public NotificationManager NotificationManager() {
		return new NotificationManager(EmailNotificationService(), SmsNotificationService());	
	}	
}
