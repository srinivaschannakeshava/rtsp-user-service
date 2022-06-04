package com.srini91.learn.rtsp.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionMessage {

	private String errMessage;
	private int errCode;

}
