package mylab.user.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService service;
	
	@Test
	void userTest() {
		// UserRepository 확인
		// userService.getUserRepository -> UserRepository
		assertNotNull(service);
		assertNotNull(service.getUserRepository());
		
		assertEquals("MySQL", service.getUserRepository().getDbType());
		
		// SecurityService(어노테이션으로 주입) 확인
		assertNotNull(service.getSecurityService());
				
		
		// 기능 테스트
		assertTrue(service.registerUser("u001", "alice", "alice1"));
		assertFalse(service.registerUser("user2", "김철수", ""));
	}
}
