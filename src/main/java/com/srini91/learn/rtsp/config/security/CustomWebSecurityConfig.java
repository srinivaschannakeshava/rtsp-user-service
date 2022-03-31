//package com.srini91.learn.rtsp.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests().antMatchers("/user/register**").permitAll().anyRequest().authenticated().and()
//				.formLogin().loginPage("/user/login").loginProcessingUrl("/user/login").permitAll().and().logout()
//				.logoutSuccessUrl("/user/logout").permitAll();
//	}
//
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth, DaoAuthenticationProvider daoAuthProvider) {
//		auth.authenticationProvider(daoAuthProvider);
//	}
//
//}
