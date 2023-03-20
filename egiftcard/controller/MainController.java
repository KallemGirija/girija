package com.cg.egiftcard.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.service.NotificationService;

@RestController
@CrossOrigin(origins = "*")
public class MainController {

	@Autowired
	private NotificationService notifService;

	@GetMapping()
	public String welcome() {
		return "Hello from E-GiftCard Application";
	}

	@PostMapping("/send-email/{email}/{firstName}/{lastName}")
	public String sendEmail(@PathVariable String email, @PathVariable String firstName, String lastName)
			throws MessagingException, UnsupportedEncodingException {
		return notifService.sendOnRegisterMail(email, firstName, lastName);
	}

	@PostMapping("/send-email/{email}/{firstName}/{lastName}/{type}")
	public String sendDemoNotif(@PathVariable String email, @PathVariable String firstName, String lastName,
			String type) throws MessagingException, UnsupportedEncodingException {
		return notifService.sendDemoNotif(email, firstName, lastName, type);
	}

}
