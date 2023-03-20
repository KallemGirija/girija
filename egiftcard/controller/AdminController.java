package com.cg.egiftcard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.entity.LoginCred;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.service.GiftCardManagementService;
import com.cg.egiftcard.util.CreateResponseEntity;

@RestController
@RequestMapping("/api/gift-card")
@CrossOrigin(origins = "*")
public class AdminController {

	@Value("${adminId}")
	private String adminusername;

	@Value("${pass}")
	private String adminpass;

	@Autowired
	private GiftCardManagementService giftCardAdminService;

	@PostMapping("/admin/addgiftCard/")
	public GiftCard addGiftCard(@RequestBody GiftCard giftCard) throws GiftCardCustomExceptions {
		return giftCardAdminService.addGiftCard(giftCard);
	}

	@PutMapping("/update-gift-card")
	public ResponseEntity<?> updateGiftCard(@RequestBody GiftCard body) throws GiftCardCustomExceptions {
		CreateResponseEntity res = new CreateResponseEntity();
		res.setStatus(true);
		res.setMessage("Gift card updated successfully..!.");
		res.setData(giftCardAdminService.updateGiftCard(body));
		res.setHttpStatus(HttpStatus.OK);
		return res.getResponseEntity();
	}

	@DeleteMapping("/admin/delete-giftcard/{gid}")
	public ResponseEntity<?> deleteGiftCardById(@PathVariable Long gid) throws GiftCardCustomExceptions {
		return ResponseEntity.ok(giftCardAdminService.deleteGiftCardById(gid));
	}

	@PostMapping("/admin/login")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody LoginCred loginCred)
			throws UserCustomExceptions, InvalidInputException {
		CreateResponseEntity res = new CreateResponseEntity();
		if (loginCred.getEmail().equalsIgnoreCase(adminusername)
				&& loginCred.getPassword().equalsIgnoreCase(adminpass)) {
			res.setStatus(true);
			res.setMessage("Login successfull.");
			res.setData("ADMIN_ROLE");
			res.setHttpStatus(HttpStatus.OK);
			return res.getResponseEntity();
		} else {
			throw new UserCustomExceptions("Invalid email or password. Try again..!", HttpStatus.UNAUTHORIZED);
		}
	}

}
