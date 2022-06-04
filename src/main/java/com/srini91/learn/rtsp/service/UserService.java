package com.srini91.learn.rtsp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.converter.UserDTOConverter;
import com.srini91.learn.rtsp.converter.UserDtoReverseConverter;
import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.dao.repo.RtspUserRepo;
import com.srini91.learn.rtsp.model.UserDTO;

@Service
public class UserService {

	@Autowired
	private RtspUserRepo rtspUserRepo;

	@Autowired
	private UserDtoReverseConverter userRevConv;

	@Autowired
	private UserDTOConverter userConv;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public RtspUser registerTestUser(RtspUser rtspUser) {
		rtspUser.getCameraList().forEach(t -> {
			t.setRtspUser(rtspUser);
			t.getConfig().setRtspCamera(t);
		});
		return rtspUserRepo.save(rtspUser);
	}

	@Transactional
	public UserDTO registerUser(UserDTO user) {
		user.setPwd( bCryptPasswordEncoder.encode(user.getPwd()));
		return userConv.convert(rtspUserRepo.save(userRevConv.convert(user)));
	}
	@Transactional
	public UserDTO updateUser(UserDTO user, RtspUserDetails userDetails) {
		RtspUser rtspUser = rtspUserRepo.findOneByEmailId(userDetails.getRtspUser().getEmailId());
		if (rtspUser != null) {
			rtspUser.setPwd(bCryptPasswordEncoder.encode(user.getNewPwd()));
			return userConv.convert(rtspUserRepo.save(rtspUser));
		}
		else
			throw new UsernameNotFoundException("User Not found");
	}

	@Transactional
	public RtspUser findByUserEmailId(String emailId) {
		RtspUser user = rtspUserRepo.findOneByEmailId(emailId);
		if (null != user) {
			user.getCameraList();
			user.getCameraList().forEach(RtspCamera::getConfig);
		}
		return user;
	}

	@Transactional
	public RtspUser fetchUserDetails(String emailId) {
		RtspUser rtspUser = rtspUserRepo.findOneByEmailId(emailId);
		rtspUser.getCameraList();
		rtspUser.getCameraList().forEach(RtspCamera::getConfig);
		return rtspUser;
	}

}
