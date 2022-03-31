package com.srini91.learn.rtsp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srini91.learn.rtsp.dao.model.RtspCameraConfig;
@Repository
public interface RtspCameraConfigRepo extends JpaRepository<RtspCameraConfig, Long> {

}
