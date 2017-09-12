package com.libertymutual.goforcode.stayout.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter    {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()

				.antMatchers("/", "/css/**", "/js/**", "/loginalot").permitAll()
				.antMatchers("/api/**").hasRole("MACHINE")
				.antMatchers("/admin").hasAnyRole("ADMIN", "REVIEWER")
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/loginalot")
				.loginProcessingUrl("/trylogin");
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		UserDetails 
		user = User
			.withUsername("jean")
			.password("password")
			.roles("USER")
			.build();
		manager.createUser(user);
	
		user = User
			.withUsername("admin")
			.password("admin")
			.roles("ADMIN")
			.build();
		manager.createUser(user);
	
	return manager;

	}
}
