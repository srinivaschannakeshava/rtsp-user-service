package com.srini91.learn.rtsp.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.srini91.learn.rtsp.dao.model.RtspCamera;
import com.srini91.learn.rtsp.dao.model.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9176578568240443041L;

	private UUID id;
	
	private String pwd;

	private String username;

	private String emailId;

	private Status status;

	private List<RtspCamera> cameraList;
	
	private Integer cameraCount;
}
