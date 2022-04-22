package com.srini91.learn.rtsp.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srini91.learn.rtsp.dao.model.RtspRunnerSchedule;

@Repository
public interface RtspRunnerScheduleRepo extends JpaRepository<RtspRunnerSchedule, Long> {

	List<RtspRunnerSchedule> findAllByServerId(String serverId);
	
	RtspRunnerSchedule findOneByCameraId(String cameraId);

	void deleteAllByCameraId(String cameraId);
	
}
