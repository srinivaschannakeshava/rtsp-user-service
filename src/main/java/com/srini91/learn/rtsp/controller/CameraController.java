package com.srini91.learn.rtsp.controller;

import java.security.Principal;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.model.CameraDTO;
import com.srini91.learn.rtsp.service.CameraService;


@RestController
@RequestMapping(path = "camera")
public class CameraController {
	private static Logger LOG=LogManager.getLogger(CameraController.class);
	
	@Autowired
	private CameraService cameraServ;
	
	@PutMapping(path ="/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public RtspCamera RegisterCamera(@RequestBody CameraDTO cameraDto,Principal user) {
		RtspUserDetails userDetails = (RtspUserDetails)((Authentication) user).getPrincipal();
		LOG.info("Camera DTO {} - Pricipal user {} - {} - {} ",cameraDto,userDetails.getRtspUser().getEmailId());
		return cameraServ.registerCamera(cameraDto, userDetails);
	}
	
	@DeleteMapping(path = "/remove/{cameraId}")
	public void removeCamera(@PathVariable String cameraId) {
		cameraServ.deleteCamera(cameraId);
	}
	
	

}
