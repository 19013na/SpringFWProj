package mylab.notification.di.annot.config;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.NotificationManager;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	protected static final Logger logger = LogManager.getLogger();
	
	@Autowired
	NotificationManager manager;
	
	@Test
	void testManagerConfig() {
		// 데이터 null 확인
		assertNotNull(manager);
		assertNotNull(manager.getEmailService());
		assertNotNull(manager.getSmsService());
		
		assertNotSame(manager.getEmailService(), manager.getSmsService());
		
		// 데이터 확인
		manager.sendNotificationByEmail("hi");
		manager.sendNotificationBySms("hi");
	}
}
