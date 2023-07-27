package sk.filiptvrdon.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
	// any request must be authenticated 
	// http.authorizeHttpRequests(auth -> auth.anyRequest().autheticated());
	
	// use basic auth
	http.httpBasic(withDefaults());
	
	// CSRF -> POST, PUT
	http.csrf().disable();
	http.cors().disable();
	
	
	return http.build();
    }
    

}
