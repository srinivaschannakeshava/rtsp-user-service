package com.srini91.learn.rtsp.config.security;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8020794416982300802L;

	private String signKey;
	
	private Long validity;
	
	private String signAlgo;

}
