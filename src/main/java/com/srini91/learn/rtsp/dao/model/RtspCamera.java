package com.srini91.learn.rtsp.dao.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "RTSP_CAMERA")
@Data
public class RtspCamera implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6190724251835975954L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rtspuser_id", nullable = false)
	@JsonBackReference
	private RtspUser rtspUser;

	@Column(unique = true)
	private String cameraId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "rtspCamera")
	@JsonManagedReference
	private RtspCameraConfig config;
	
	private String cameraIp;

	private Boolean isRtspPull;
	
	private String cameraRtspPath;
	
	private String aiRtspPath;
	
	private String motionRtspPath;

	private String httpPath;
	
	private String serverRtspPath;

	private Boolean isEnabled;
	//    private List<String> thumbnailImage;

}
