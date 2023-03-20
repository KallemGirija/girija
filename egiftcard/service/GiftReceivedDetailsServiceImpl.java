package com.cg.egiftcard.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.egiftcard.dto.GiftReceivedDetailsDto;
import com.cg.egiftcard.entity.GiftReceivedDetails;
import com.cg.egiftcard.entity.User;
import com.cg.egiftcard.entity.UserGiftDetails;
import com.cg.egiftcard.exception.UserCustomExceptions;
import com.cg.egiftcard.repository.GiftRecdDetailsRepository;
import com.cg.egiftcard.repository.UserGiftDetailsAccountManagementRepository;
import com.cg.egiftcard.repository.UserRepository;

@Service
@Transactional
public class GiftReceivedDetailsServiceImpl implements GiftReceivedDetailsService {

	@Autowired
	private GiftRecdDetailsRepository giftRecdRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	UserGiftDetailsAccountManagementRepository userGiftDetailsAccountManagementRepository;

	@Override
	public List<GiftReceivedDetails> getAllGiftReceivedDetails() {
		return giftRecdRepo.findAll();
	}

	@Override
	public GiftReceivedDetails addGiftReceivedDetails(GiftReceivedDetails giftReceivedDetails) {
		GiftReceivedDetails grd = giftRecdRepo.save(giftReceivedDetails);
		if (grd != null) {
			return grd;
		}
		return null;
	}

	@Override
	public GiftReceivedDetails getGiftReceivedDetailsById(Long giftReceivedId) {
		Optional<GiftReceivedDetails> gift = giftRecdRepo.findById(giftReceivedId);
		if (gift.isPresent()) {
			return gift.get();
		}
		return null;
	}

	@Override
	public GiftReceivedDetails updateGiftReceivedDetails(GiftReceivedDetailsDto giftReceivedDetailsDto)
			throws UserCustomExceptions, ParseException {

		Optional<GiftReceivedDetails> gift = giftRecdRepo.findById(giftReceivedDetailsDto.getGiftReceivedId());
		if (gift.isPresent()) {
			GiftReceivedDetails giftReceivedDetails = gift.get();

			Date parse = new SimpleDateFormat("dd/MM/yyyy").parse(giftReceivedDetailsDto.getGiftCardReceivedDate());
			giftReceivedDetails.setGiftCardReceivedDate(parse);

			giftReceivedDetails.setReceiverAddress(giftReceivedDetailsDto.getReceiverAddress());

			Optional<User> usr = userRepo.findById(giftReceivedDetailsDto.getUserId());
			if (usr.isPresent()) {
				User user = usr.get();
				giftReceivedDetails.setUser(user);
			} else {
				throw new UserCustomExceptions("Error user not exist", HttpStatus.INTERNAL_SERVER_ERROR);

			}

			Optional<UserGiftDetails> userGiftDetails = userGiftDetailsAccountManagementRepository
					.findById(giftReceivedDetailsDto.getUserGiftId());
			if (!userGiftDetails.isPresent()) {

				throw new UserCustomExceptions("Error UserGiftDetails not exist", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			UserGiftDetails userGiftDetails2 = userGiftDetails.get();
			giftReceivedDetails.setUserGiftDetails(userGiftDetails2);

			GiftReceivedDetails grd = giftRecdRepo.save(giftReceivedDetails);
			if (grd != null) {
				return grd;
			}
		} else {

			throw new UserCustomExceptions("Error GiftReceivedDetails not exist", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return null;
	}

}
