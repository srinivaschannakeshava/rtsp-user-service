package com.srini91.learn.rtsp.converter;

import java.util.UUID;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.dao.model.RtspCameraConfig;
import com.srini91.learn.rtsp.model.CameraDTO;

@Component
public class CameraDTOConverter implements Converter<CameraDTO, RtspCamera> {

	@Override
	public RtspCamera convert(CameraDTO source) {
		RtspCamera target=new RtspCamera();
		target.setCameraIp(source.getCameraIp());
		target.setCameraRtspPath(source.getCameraRtspPath());
		target.setIsEnabled(source.getIsEnabled());
		target.setIsRtspPull(source.getIsRtspPull());
		target.setCameraId(UUID.randomUUID().toString());
		RtspCameraConfig tConfig = new RtspCameraConfig();
		ObjectMapper mapper=new ObjectMapper();
		ObjectNode rootNode = mapper.createObjectNode();
		rootNode.put("name", source.getCameraName());
		tConfig.setRtspCamera(target);
		try {
			tConfig.setConfig(mapper.writeValueAsString(rootNode));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		target.setConfig(tConfig);
		return target;
	}

	
}
