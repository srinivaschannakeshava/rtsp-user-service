package com.srini91.learn.rtsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.model.UserDTO;
import com.srini91.learn.rtsp.service.UserLoginService;
import com.srini91.learn.rtsp.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {



	@Autowired
	private UserService userServ;

	@Autowired
	private UserLoginService userLoginServ;

	@PostMapping("/register")
	public RtspUser registerUser(@RequestBody RtspUser user) {
		
		return userServ.registerUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDTO user) throws AuthenticationException {
		
//		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//				.collect(Collectors.toList());
		return ResponseEntity.ok(userLoginServ.loginUser(user));
	}
	
	@GetMapping("/info/{userId}")
	public RtspUser getUser(@PathVariable String userId) {
		return userServ.fetchUserDetails(userId);
	}

}
