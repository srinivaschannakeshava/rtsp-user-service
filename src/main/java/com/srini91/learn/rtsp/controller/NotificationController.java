package com.srini91.learn.rtsp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srini91.learn.rtsp.config.security.RtspUserDetails;
import com.srini91.learn.rtsp.dao.model.RtspNotificationTokenStore;
import com.srini91.learn.rtsp.service.NotificationService;

@RestController
@RequestMapping(path = "notification")
public class NotificationController {

	@Autowired
	private NotificationService notifiServ;

	@PostMapping(path = "/register/{fcmToken}")
	private RtspNotificationTokenStore registerNotification(@PathVariable String fcmToken, Principal pUser) {
		return notifiServ.registerFcmToken(fcmToken,
				((RtspUserDetails) ((Authentication) pUser).getPrincipal()).getRtspUser());
	}

	@GetMapping(path = "/tokens")
	private List<RtspNotificationTokenStore> getNotificationTokens(Principal pUser) {
		return notifiServ.getFcmToken(((RtspUserDetails) ((Authentication) pUser).getPrincipal()).getRtspUser());
	}
}
