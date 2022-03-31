package com.srini91.learn.rtsp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.dao.model.RtspUser;
import com.srini91.learn.rtsp.dao.repo.RtspUserRepo;

@Service
public class UserService {

	@Autowired
	private RtspUserRepo rtspUserRepo;

	@Transactional
	public RtspUser registerUser(RtspUser rtspUser) {
		rtspUser.getCameraList().forEach(t -> {
			t.setRtspUser(rtspUser);
			t.getConfig().setRtspCamera(t);
		});
		return rtspUserRepo.save(rtspUser);
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
