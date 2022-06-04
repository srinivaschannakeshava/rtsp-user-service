package com.srini91.learn.rtsp.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.dao.model.RtspNotificationTokenStore;
import com.srini91.learn.rtsp.dao.repo.RtspNotificationTokenStoreRepo;
import com.srini91.learn.rtsp.model.UserDTO;

@Service
public class NotificationService {
	@Autowired
	private RtspNotificationTokenStoreRepo notifiTokenRepo;

	public RtspNotificationTokenStore registerFcmToken(String fcmToken, UserDTO user) {
		
		String userId = user.getId().toString();
		RtspNotificationTokenStore exitingToken = notifiTokenRepo.findOneByUserIdAndToken(userId, fcmToken);
		if(null!=exitingToken)
			return exitingToken;
		LinkedList<RtspNotificationTokenStore> tokenList = notifiTokenRepo.findAllByUserIdOrderByCreateTimestampAsc(userId);
		int size = tokenList.size();
		if(size>=5) {
			RtspNotificationTokenStore firstToken = tokenList.getFirst();
			firstToken.setCreateTimestamp(Timestamp.from(Instant.now()));
			firstToken.setUpdateTimestamp(null);
			firstToken.setToken(fcmToken);
			return notifiTokenRepo.save(firstToken);
		}
			
		return notifiTokenRepo
				.save(RtspNotificationTokenStore.builder().token(fcmToken).userId(userId).build());

	}
	
	public List<RtspNotificationTokenStore> getFcmToken(UserDTO user) {
		return notifiTokenRepo.findAllByUserIdOrderByCreateTimestampAsc(user.getId().toString());
	}

}
