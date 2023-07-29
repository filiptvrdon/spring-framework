package filip.tvrdon.springsecurity.basic;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
enum UserRoles {
    USER, ADMIN
}

@Configuration
@EnableMethodSecurity
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(auth -> {
	    auth
	    .requestMatchers("/users").hasRole("USER")
	    .requestMatchers("/admin/**").hasRole("ADMIN")
	    
	    .anyRequest().authenticated(); // all request are authenticated
	});
	http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	http.httpBasic();
	http.csrf().disable();
	http.headers().frameOptions().sameOrigin();
	return http.build();
    }

    /*
     * @Bean public UserDetailsService userDetailService() { var admin =
     * User.withUsername("admin") .password("{noop}dummy")
     * .roles(UserRoles.ADMIN.toString()) .build();
     * 
     * var user = User.withUsername("in28minutes") .password("{noop}dummy")
     * .roles(UserRoles.USER.toString()) .build();
     * 
     * return new InMemoryUserDetailsManager(user, admin); }
     */

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
	var admin = User.withUsername("admin")
		// .password("{noop}dummy")
		.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
		.roles(UserRoles.ADMIN.toString()).build();

	var user = User.withUsername("in28minutes")
		// .password("{noop}dummy")
		.password("dummy").passwordEncoder(str -> passwordEncoder().encode(str))
		.roles(UserRoles.USER.toString()).build();

	var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
	jdbcUserDetailsManager.createUser(user);
	jdbcUserDetailsManager.createUser(admin);
	return jdbcUserDetailsManager;
    }

    @Bean
    public DataSource dataSource() {
	return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
