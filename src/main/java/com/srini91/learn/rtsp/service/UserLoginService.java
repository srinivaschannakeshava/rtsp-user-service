package com.srini91.learn.rtsp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.config.security.JwtTokenUtil;
import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.model.JwtResponse;
import com.srini91.learn.rtsp.model.UserDTO;

@Service
public class UserLoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtUtils;

	@Transactional
	public JwtResponse loginUser(UserDTO user) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				user.getEmailId(),user.getPwd()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		RtspUserDetails userDetails = (RtspUserDetails) authentication.getPrincipal();
		return JwtResponse.builder().token(jwt).user(userDetails.getRtspUser()).build();
	}
}
