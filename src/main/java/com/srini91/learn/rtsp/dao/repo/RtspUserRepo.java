package com.srini91.learn.rtsp.dao.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srini91.learn.rtsp.dao.model.RtspUser;

@Repository
public interface RtspUserRepo extends JpaRepository<RtspUser, UUID> {

	public RtspUser findOneByEmailId(String emailId);

	public RtspUser findOneByEmailIdAndPwd(String emailId,String pwd);
	
	
}
