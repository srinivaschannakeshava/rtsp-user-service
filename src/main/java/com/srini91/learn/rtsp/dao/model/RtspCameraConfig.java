package com.srini91.learn.rtsp.dao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "RTSP_CAMERA_CONFIG")
@Data
public class RtspCameraConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2471071704567474322L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	@JoinColumn( name = "rtspCamera_id",nullable = false)
	@JsonBackReference
	private RtspCamera rtspCamera;

	@Lob
	@Column(columnDefinition = "TEXT")
	@Type(type = "org.hibernate.type.StringType")
	private String config;
	
	

}
