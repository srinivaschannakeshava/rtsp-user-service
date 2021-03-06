package com.srini91.learn.rtsp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.exception.ExceptionController;
import com.srini91.learn.rtsp.model.UserDTO;
import com.srini91.learn.rtsp.service.UserLoginService;
import com.srini91.learn.rtsp.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController extends ExceptionController {



	@Autowired
	private UserService userServ;

	@Autowired
	private UserLoginService userLoginServ;


	@PostMapping("/test/register")
	public RtspUser registerUser(@RequestBody RtspUser user) {
		
		return userServ.registerTestUser(user);
	}
	
	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserDTO user){
		validateUser(user);
		return userServ.registerUser(user);
	}
	
	private void validateUser(UserDTO user) {
		Assert.notNull(user.getEmailId(),"User Email Id required");
		Assert.notNull(user.getUsername(),"User Name Required");
		Assert.notNull(user.getPwd(),"User Password Required");
		
	}

	@PutMapping("/pwd/update")
	public UserDTO updatePwd(@RequestBody UserDTO user, Principal pUser) {
		RtspUserDetails userDetails = (RtspUserDetails)((Authentication) pUser).getPrincipal();
		return userServ.updateUser(user,userDetails);
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
