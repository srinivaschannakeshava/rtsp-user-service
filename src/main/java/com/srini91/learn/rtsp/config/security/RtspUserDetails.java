package com.srini91.learn.rtsp.config.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.srini91.learn.rtsp.dao.model.Status;
import com.srini91.learn.rtsp.model.UserDTO;

import lombok.Data;

@Data
public class RtspUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3001887368336188041L;
	
	private UserDTO rtspUser;
	
	public RtspUserDetails(UserDTO user) {
		this.rtspUser=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return rtspUser.getPwd();
	}

	@Override
	public String getUsername() {
		return rtspUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return rtspUser.getStatus()==Status.ACTIVE;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return rtspUser.getStatus()==Status.ACTIVE;
	}

}
