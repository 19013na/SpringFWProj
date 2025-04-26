package mylab.user.di.xml;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Resource(name = "userRepository" )
    private UserRepository userRepository;
    
	@Resource(name = "securityService")
    private SecurityService securityService;
        
    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }
    
    public boolean registerUser(String userId, String name, String password) {
        if (securityService.authenticate(userId, password)) {
            return userRepository.saveUser(userId, name);
        }
        return false;
    }
}
