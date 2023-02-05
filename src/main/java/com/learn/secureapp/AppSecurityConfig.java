package com.learn.secureapp;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserDetailsService userDetailsService;

	// Configuring HttpSecurity...

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authz) -> authz.anyRequest().authenticated()).httpBasic();
		
		return http.build();
	}

	// Configuring WebSecurity...
	/*
	 * @Bean public WebSecurityCustomizer webSecurityCustomizer() { return (web) ->
	 * web.ignoring().antMatchers("/ignore1", "/ignore2"); }
	 */

	// LDAP Authentication...
	/*
	 * @Bean public EmbeddedLdapServerContextSourceFactoryBean
	 * contextSourceFactoryBean() { EmbeddedLdapServerContextSourceFactoryBean
	 * contextSourceFactoryBean =
	 * EmbeddedLdapServerContextSourceFactoryBean.fromEmbeddedLdapServer();
	 * contextSourceFactoryBean.setPort(0); return contextSourceFactoryBean; }
	 * 
	 * @Bean AuthenticationManager ldapAuthenticationManager(
	 * BaseLdapPathContextSource contextSource) {
	 * LdapBindAuthenticationManagerFactory factory = new
	 * LdapBindAuthenticationManagerFactory(contextSource);
	 * factory.setUserDnPatterns("uid={0},ou=people");
	 * factory.setUserDetailsContextMapper(new PersonContextMapper()); return
	 * factory.createAuthenticationManager(); }
	 */

	// JDBC Authentication...

	/*
	 * @Bean public DataSource dataSource() { return new
	 * EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
	 * .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION).build(); }
	 * 
	 * @Bean public UserDetailsManager users(DataSource dataSource) { UserDetails
	 * user =
	 * User.withDefaultPasswordEncoder().username("user").password("password").roles
	 * ("USER") .build(); JdbcUserDetailsManager users = new
	 * JdbcUserDetailsManager(dataSource); users.createUser(user); return users; }
	 */

	// In-Memory Authentication...
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() { UserDetails
	 * user = User.withDefaultPasswordEncoder() .username("krish") .password("1234")
	 * .roles("USER") .build(); return new InMemoryUserDetailsManager(user); }
	 */

//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider; 
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
	}

}
