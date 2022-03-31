package com.srini91.learn.rtsp.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "RTSP_USER")
@Data
public class RtspUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2685547433710965502L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String username;

	private String pwd;

	@Column(unique = true)
	private String emailId;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "rtspuser_id")
    @JsonManagedReference
	private List<RtspCamera> cameraList;

	@CreationTimestamp
	private Timestamp createTimestamp;

	@UpdateTimestamp
	private Timestamp updateTimestamp;

}
