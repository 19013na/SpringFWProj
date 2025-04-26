package mylab.user.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	
	@Resource(name="userService")
	UserService service;
	
	@Test
	void userTest() {
		assertNotNull(service);
		assertNotNull(service.getUserRepository());
		assertEquals("MySQL", service.getUserRepository().getDbType());
		assertNotNull(service.getSecurityService());
		assertTrue(service.registerUser("u001", "alice", "alice1"));
	}
}
