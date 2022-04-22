package com.srini91.learn.rtsp.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "RTSP_RUNNER_SCHEDULE", indexes = { 
		@Index(name = "server_id_idx", columnList = "serverId"),
		@Index(name = "camera_id_idx", columnList = "cameraId") 
		})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RtspRunnerSchedule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8277382565564536470L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String serverId;

	@Column(unique = true)
	private String cameraId;

	private String cameraRstpPath;

	private String serverRtspPath;
}
