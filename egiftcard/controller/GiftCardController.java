package com.cg.egiftcard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.service.GiftCardManagementService;
import com.cg.egiftcard.util.CreateResponseEntity;

@RestController
@RequestMapping("/api/gift-card")
@CrossOrigin(origins = "*")
public class GiftCardController {

	@Autowired
	private GiftCardManagementService giftCardService;

	@GetMapping()
	public ResponseEntity<Map<String, Object>> getAllGifts() {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("these are the search results..!.");
		res.setData(giftCardService.getAllGiftCards());
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}
	
	//@DeleteMapping("user/delete-giftcard/{gid}")
	public ResponseEntity<?> deleteGiftCardById(@PathVariable Long gid) throws GiftCardCustomExceptions {
		return ResponseEntity.ok(giftCardService.deleteGiftCardById(gid));
	}

	@GetMapping("/get-giftcard-by-id/{gid}")
	public ResponseEntity<?> getGiftCardById(@PathVariable Long gid) throws GiftCardCustomExceptions {
		return ResponseEntity.ok(giftCardService.getGiftCardById(gid));
	}
	
	@GetMapping({"/admin/get-giftCard-Name/{giftCardName}","/user/get-giftCard-Name/{giftCardName}"})
	public ResponseEntity<?> getGiftCardName(@PathVariable String giftCardName) throws GiftCardCustomExceptions{
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Gift card fetched successfully..!.");
		res.setData(giftCardService.getGiftCardName(giftCardName));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}
	

}
