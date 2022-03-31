package com.srini91.learn.rtsp.model;

import lombok.Data;

/**
 * # { # "ip": "ip", # "user": "user", # "password": "password", # "path":
 * "path", # "action": "read|publish" # "query": "url's raw query" # }
 */
@Data
public class RtspUser {
	private String ip;
	private String user;
	private String password;
	private String path;
	private String action;
	private String query;

}
