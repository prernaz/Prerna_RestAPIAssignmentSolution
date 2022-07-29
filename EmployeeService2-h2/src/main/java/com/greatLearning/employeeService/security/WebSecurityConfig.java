package com.greatLearning.employeeService.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.greatLearning.employeeService.service.UserDetailsServiceImpl;

//@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	// overriding other config method with HttpSecurity paramter to set
	// authorization as below
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers("/h2-console/**").permitAll().and().cors().and().csrf()
				.disable().headers().frameOptions().disable()
				
			
				.and().authorizeRequests().antMatchers("/api/user", "/api/role").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.POST, "/api/employees").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/api/employees").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/employees/*").hasAuthority("ADMIN")

				.antMatchers(HttpMethod.GET, "/api/employees/**", "api/employees/{employeeId}",
						"/api/employees/search/{firstName}", "/api/employees/sort")

				.hasAnyAuthority("ADMIN", "USER").anyRequest().authenticated().and()

			
		
				.exceptionHandling().accessDeniedPage("/api/403");
	}
}



	/*
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService());
	 * authProvider.setPasswordEncoder(passwordEncoder()); return authProvider; }
	 */

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 */

	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/h2-console/**");
	 * 
	 * }
	 */



