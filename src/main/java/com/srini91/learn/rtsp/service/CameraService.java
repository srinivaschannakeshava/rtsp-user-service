package com.srini91.learn.rtsp.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srini91.learn.rtsp.config.AppConfig;
import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.converter.CameraDTOConverter;
import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.dao.model.RtspRunnerSchedule;
import com.srini91.learn.rtsp.dao.repo.RtspCameraConfigRepo;
import com.srini91.learn.rtsp.dao.repo.RtspCameraRepo;
import com.srini91.learn.rtsp.dao.repo.RtspRunnerScheduleRepo;
import com.srini91.learn.rtsp.dao.repo.RtspUserRepo;
import com.srini91.learn.rtsp.model.CameraDTO;

@Service
public class CameraService {

	@Autowired
	private RtspCameraRepo rtspCameraRepo;

	@Autowired
	private RtspUserRepo userRepo;

	@Autowired
	private RtspRunnerScheduleRepo rtspRunSchRepo;

	@Autowired
	private RtspCameraConfigRepo rtspCameraConfigRepo;

	@Autowired
	private AppConfig appProp;

	@Autowired
	private CameraDTOConverter cameraDtoConv;

	public RtspCamera registerCamera(CameraDTO cameraDetails, RtspUserDetails userDetails) {
		RtspCamera rtspCamera = cameraDtoConv.convert(cameraDetails);
		UUID userId = userDetails.getRtspUser().getId();
		rtspCamera.setRtspUser(userRepo.getById(userId));
//		http://103.87.128.78:8124/stream/live/admin/TapoC200
		rtspCamera.setHttpPath(createHttpPath(userId.toString(), rtspCamera.getCameraId()));
		rtspCamera.setServerRtspPath(createRtspPath(userId.toString(), rtspCamera.getCameraId()));
		RtspCamera rtspCameraDetails = rtspCameraRepo.save(rtspCamera);
		if (cameraDetails.getIsRtspPull()) {
			RtspRunnerSchedule rtspSchedule = RtspRunnerSchedule.builder().cameraId(rtspCamera.getCameraId())
					.cameraRstpPath(rtspCamera.getCameraRtspPath()).serverId(appProp.getRtspRunnerId())
					.serverRtspPath(rtspCamera.getServerRtspPath()).build();
			rtspRunSchRepo.save(rtspSchedule);
		}
		return rtspCameraDetails;

	}

	@Transactional
	public void deleteCamera(String cameraId) {
		RtspCamera rtspCamera = rtspCameraRepo.findOneByCameraId(cameraId);
		if (null != rtspCamera) {
			rtspCameraRepo.delete(rtspCamera);
			if (rtspCamera.getIsRtspPull()) {
				rtspRunSchRepo.deleteAllByCameraId(cameraId);
			}

		}

	}

	private String createHttpPath(String userId, String cameraId) {
		return "http://" + appProp.getStreamServerAdd().replaceAll("\"", "") + "/stream/live/" + userId + "/"
				+ cameraId;
	}

	private String createRtspPath(String userId, String cameraId) {
		return "rtsp://" + appProp.getRtspServerAdd().replaceAll("\"", "") + "/" + userId + "/" + cameraId;
	}
}
