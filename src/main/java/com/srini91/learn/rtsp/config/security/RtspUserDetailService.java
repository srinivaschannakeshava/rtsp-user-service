package com.srini91.learn.rtsp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.converter.UserDTOConverter;
import com.srini91.learn.rtsp.model.UserDTO;
import com.srini91.learn.rtsp.service.UserService;

@Service
public class RtspUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private UserDTOConverter userDtoConv;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userDtoConv.convert(userServ.findByUserEmailId(username));
		  if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	      }  
		return new RtspUserDetails(user);
	}

}
