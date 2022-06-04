package com.srini91.learn.rtsp.dao.repo;

import java.util.LinkedList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srini91.learn.rtsp.dao.model.RtspNotificationTokenStore;

public interface RtspNotificationTokenStoreRepo extends JpaRepository<RtspNotificationTokenStore, Long>{

	LinkedList<RtspNotificationTokenStore> findAllByUserIdOrderByCreateTimestampAsc(String userId);
	
	RtspNotificationTokenStore findOneByUserIdAndToken(String userId,String token);
}
