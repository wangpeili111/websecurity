package com.app.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MvcConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
		http.authorizeRequests()
				.antMatchers("/login", "/webjars/**", "/js/**", "/css/**", "/image/**", "/register/**", "/favicon.ico",
						"/web")
				.permitAll()

				.antMatchers("/admin/**").hasAuthority("admin").antMatchers("/admin/**").hasRole("admin")
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").anyRequest().authenticated().and()
				.formLogin().loginPage("/login").permitAll().and().logout().permitAll()
		// .and().csrf().disable()
		;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.builder();
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
		// .withUser(users.username("wangpeili1112").password(new
		// BCryptPasswordEncoder().encode("wangpeili1112")).roles("ADMIN"))
		;
	}

	/**
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 *           User.withUsername("wangpeili").password("wangpeili").roles("ADMIN")
	 *           .build();
	 * 
	 *           return new InMemoryUserDetailsManager(user); }
	 **/

}
