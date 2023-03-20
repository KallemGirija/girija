package com.cg.egiftcard.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.egiftcard.dto.PlaceGiftCardOrderDto;
import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.entity.GiftReceivedDetails;
import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.entity.UserGiftDetails;
import com.cg.egiftcard.enums.DeliveryType;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.exception.InvalidInputException;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.exception.UserGiftDetailsCustomExceptions;
import com.cg.egiftcard.repository.GiftCardManagementRepository;
import com.cg.egiftcard.repository.UserGiftDetailsAccountManagementRepository;

@Service
@Transactional
public class UserGiftDetailsAccountManagementServiceImpl implements UserGiftDetailsAccountManagementService {

	@Autowired
	private UserGiftDetailsAccountManagementRepository userGiftDetailsRepo;

	@Autowired
	private UserManagementService userRepo;

	@Autowired
	private GiftCardManagementRepository giftCardRepo;

	@Autowired
	private UserManagementService userService;

	@Autowired
	private UserGiftDetailsAccountManagementService userGiftDetailsService;

	@Autowired
	private GiftReceivedDetailsService giftReceivedDetailsService;

	@Autowired
	private NotificationService notifService;

	@Override
	public List<UserGiftDetails> getAllUserGiftDetails() {
		return userGiftDetailsRepo.findAll();
	}

	@Override
	public UserGiftDetails getUserGiftDetails(Long userGiftdetailsId) throws UserGiftDetailsCustomExceptions {
		Optional<UserGiftDetails> giftDetails = userGiftDetailsRepo.findById(userGiftdetailsId);
		if (giftDetails.isPresent()) {
			return giftDetails.get();
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not found..!", HttpStatus.NOT_FOUND);
	}

	@Override
	public UserGiftDetails addUserGiftDetails(UserGiftDetails userGiftdetails) throws UserGiftDetailsCustomExceptions {
		UserGiftDetails userGiftDet = userGiftDetailsRepo.save(userGiftdetails);
		if (userGiftDet != null) {
			return userGiftDet;
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not added..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public UserGiftDetails updateUserGiftDetails(UserGiftDetails userGiftdetails)
			throws UserGiftDetailsCustomExceptions {
		UserGiftDetails userGiftDet = userGiftDetailsRepo.save(userGiftdetails);
		if (userGiftDet != null) {
			return userGiftDet;
		}
		throw new UserGiftDetailsCustomExceptions("User gift card details not added..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public String deleteUserGiftDetailsById(Long userGiftdetailsId) throws UserGiftDetailsCustomExceptions {
		userGiftDetailsRepo.deleteById(userGiftdetailsId);
		Optional<UserGiftDetails> userGiftDet = userGiftDetailsRepo.findById(userGiftdetailsId);
		if (userGiftDet.isPresent()) {
			throw new UserGiftDetailsCustomExceptions("User gift card details not deleted..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "User gift card details deleted successfully..!";
	}
	
	@Override
	public GiftCard placeGiftCardOrder(PlaceGiftCardOrderDto placeGiftCardOrderDto)
			throws GiftCardCustomExceptions, UserCustomExceptions, UserGiftDetailsCustomExceptions, ParseException,
			UnsupportedEncodingException, MessagingException, InvalidInputException {
		if(placeGiftCardOrderDto.getDeliveryType().equalsIgnoreCase(DeliveryType.ONLINE.name())) {
			// adddres not need
			
		}else if(placeGiftCardOrderDto.getDeliveryType().equalsIgnoreCase(DeliveryType.OFFLINE.name())) {
			// ADDRESS SHOULD NEEDD
			if(placeGiftCardOrderDto.getReceiverAddress() == null) {
				throw new GiftCardCustomExceptions("Error DeliveryType is OFFLINE should be fill ADDRESS. Try again..!",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}else {
			throw new GiftCardCustomExceptions("Error DeliveryType should ONLINE OR OFFLINE. Try again..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

		GiftCard gc = giftCardRepo.save(placeGiftCardOrderDto.getGiftCard());

		if (gc != null) {

			// new Personalization
//			Personalize pz = new Personalize();
			// user who is buying the gift card
			User u = userService.getUserById(placeGiftCardOrderDto.getUserId());

		//	User u_reciever = userService.getUserByEmail(placeGiftCardOrderDto.getRecipientsEmail());

			UserGiftDetails userGiftDet = new UserGiftDetails();
			userGiftDet.setUser(u);
			userGiftDet.setGiftCard(gc);
			userGiftDet.setGiftCardAmount(gc.getAmount());
			userGiftDet.setGiftCardIssueDate(
					new SimpleDateFormat("dd/MM/yyyy").parse(placeGiftCardOrderDto.getGiftCardIssueDate()));
			userGiftDet.setReloadable(placeGiftCardOrderDto.isReloadable());
			userGiftDet.setRecipientsName(placeGiftCardOrderDto.getRecipientsName());
			userGiftDet.setRecipientsMobileNumber(placeGiftCardOrderDto.getRecipientsMobileNumber());
			userGiftDet.setRecipientsEmail(placeGiftCardOrderDto.getRecipientsEmail());
			userGiftDet.setDeliveryType(placeGiftCardOrderDto.getDeliveryType());
			userGiftDet.setScheduledelivary(LocalDate.parse(placeGiftCardOrderDto.getScheduledelivaryDate(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//			userGiftDet.setPersonalize(pz);

			UserGiftDetails savedUserGiftDet = userGiftDetailsService.addUserGiftDetails(userGiftDet);

			if (savedUserGiftDet != null) {

				// new gift card record details
				GiftReceivedDetails giftRecd = new GiftReceivedDetails();
				giftRecd.setGiftCardReceivedDate(null);
				giftRecd.setUser(u);
				giftRecd.setUserGiftDetails(savedUserGiftDet);
				giftRecd.setReceiverAddress(placeGiftCardOrderDto.getReceiverAddress() == null ? "": placeGiftCardOrderDto.getReceiverAddress());

				GiftReceivedDetails newgrd = giftReceivedDetailsService.addGiftReceivedDetails(giftRecd);
				if (newgrd != null) {
					notifService.sendDemoNotif(u.getEmail(), u.getFirstName(), u.getLastName(), "purchase");
					notifService.sendDemoNotif(placeGiftCardOrderDto.getRecipientsEmail(), placeGiftCardOrderDto.getRecipientsName(),
							"", "recieve");
					return gc;
				}
				throw new GiftCardCustomExceptions("Error Adding gift card record details. Try again..!",
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			throw new GiftCardCustomExceptions("Error saving User Gift detials. Try again..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		throw new GiftCardCustomExceptions("Error placing order for gift card. Try again..!",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@Override
	public List<UserGiftDetails> getUserGiftOrderHistory(Long userId) throws UserCustomExceptions {
		User u = userRepo.getUserById(userId);
		return userGiftDetailsRepo.getUserGiftOrderHistory(u);
	}
	
	

}