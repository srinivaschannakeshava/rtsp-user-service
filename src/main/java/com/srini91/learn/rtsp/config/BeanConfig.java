package com.srini91.learn.rtsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider(RtspUserDetailService userDetailServ,
//			BCryptPasswordEncoder bCryptPasswordEncoder) {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailServ);
//		authProvider.setPasswordEncoder(bCryptPasswordEncoder);
//		return authProvider;
//	}
	
	
}
