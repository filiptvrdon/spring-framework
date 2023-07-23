package sk.filiptvrdon.firstspringwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
	UserDetails userDetails = createNewUser("Filip", "aaa");
	return new InMemoryUserDetailsManager(userDetails);
    }

    private UserDetails createNewUser(String username, String password) {
	UserDetails userDetails = User.builder()
                        		.passwordEncoder(input -> passworEncoder().encode(input))
                                	.username(username)
                                	.password(password)
                                	.roles("USER","AMIN")
                                	.build();
	return userDetails;
    }
    
    @Bean
    public PasswordEncoder passworEncoder() {
	return new BCryptPasswordEncoder();
    }

    
}
