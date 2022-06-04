package com.srini91.learn.rtsp.dao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "RTSP_NOTIFICATION_TOKEN_STORE")
@NoArgsConstructor
@AllArgsConstructor
public class RtspNotificationTokenStore  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2751851390026726838L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String userId;
	
	@Column(unique = true)
	private String token;
	
	@Builder.Default
	private String tokenType="ANDROID"; //Android/Apple
	
	@CreationTimestamp
	private Timestamp createTimestamp;

	@UpdateTimestamp
	private Timestamp updateTimestamp;
}
