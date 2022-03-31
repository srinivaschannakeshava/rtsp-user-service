package com.srini91.learn.rtsp.dao.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srini91.learn.rtsp.dao.model.RtspCamera;

@Repository
public interface RtspCameraRepo extends JpaRepository<RtspCamera, UUID> {

}
