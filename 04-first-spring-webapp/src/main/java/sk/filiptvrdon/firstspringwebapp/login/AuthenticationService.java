package sk.filiptvrdon.firstspringwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public boolean authenticate(String username, String password) {
	boolean isValidUsername = username.equalsIgnoreCase("Filip");
	boolean isValidPassword = password.equalsIgnoreCase("aaa");
	
	return isValidUsername && isValidPassword;
	
    }

}
