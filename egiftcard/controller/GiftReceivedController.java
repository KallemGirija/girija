package com.cg.egiftcard.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.dto.GiftReceivedDetailsDto;
import com.cg.egiftcard.entity.GiftReceivedDetails;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.service.GiftReceivedDetailsService;
import com.cg.egiftcard.util.CreateResponseEntity;

@RestController
@RequestMapping("/api/gift-card/receive")
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "*")
public class GiftReceivedController {
	@Autowired
	private GiftReceivedDetailsService giftReceivedDetailsService;

	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllGiftReceivedDetails() {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the Gift Received Details..!.");
		res.setData(giftReceivedDetailsService.getAllGiftReceivedDetails());
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	//@PostMapping("/addGiftReceivedDetails/")
	public GiftReceivedDetails addGiftReceivedDetails(@RequestBody GiftReceivedDetails giftReceivedDetails) {

		return giftReceivedDetailsService.addGiftReceivedDetails(giftReceivedDetails);
	}

	@GetMapping("/getGiftReceivedDetailsById/{giftReceivedId}")
	public ResponseEntity<?> getGiftReceivedDetailsById(@PathVariable Long giftReceivedId) {
		return ResponseEntity.ok(giftReceivedDetailsService.getGiftReceivedDetailsById(giftReceivedId));
	}

	@PutMapping("/updateReceivedDetails")
	public ResponseEntity<?> updateGiftReceivedDetails(@RequestBody GiftReceivedDetailsDto giftReceivedDetailsDto) throws UserCustomExceptions, ParseException {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Gift Received Details updated successfully..!.");
		res.setData(giftReceivedDetailsService.updateGiftReceivedDetails(giftReceivedDetailsDto));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}
}
