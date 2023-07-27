package sk.filiptvrdon.firstspringwebapp.basic;

// @Configuration	
public class BasicAuthSecurityConfig {
    
    /* Filter Chain
     * authenticate all requests
     * basic auth
     * disable csrf
     * stateless rest api (no session when csrf is disabled 
     */
    /*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll());
	http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
	http.httpBasic(Customizer.withDefaults());
	http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	http.csrf().disable();
	
	
	return http.build();
    }
*/
}
