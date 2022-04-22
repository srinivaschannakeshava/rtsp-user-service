package com.srini91.learn.rtsp.model;

import java.util.List;

import lombok.Data;

@Data
public class CameraDTO {
	
	private String cameraIp;
	private String cameraRtspPath;
	private String cameraName;
	private String locationName;
	private List<Double> coordinates;
	private Boolean isRtspPull;
	private Boolean isEnabled;

}
