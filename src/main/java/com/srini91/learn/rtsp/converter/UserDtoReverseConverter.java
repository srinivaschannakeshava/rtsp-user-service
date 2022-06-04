package com.srini91.learn.rtsp.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.dao.model.Status;
import com.srini91.learn.rtsp.model.UserDTO;

@Component
public class UserDtoReverseConverter implements Converter<UserDTO, RtspUser> {

	
	
	@Override
	public RtspUser convert(UserDTO user) {
		RtspUser rtspUser =new RtspUser();
		rtspUser.setEmailId(user.getEmailId());
		rtspUser.setUsername(user.getUsername());
		rtspUser.setPwd(user.getPwd());
		rtspUser.setStatus(Status.ACTIVE);
//		rtspUser.setId(UUID.randomUUID());
		return rtspUser;
		
	}

}
