package com.cg.egiftcard.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cg.egiftcard.entity.GiftCard;
import com.cg.egiftcard.exception.GiftCardCustomExceptions;
import com.cg.egiftcard.repository.GiftCardManagementRepository;

@Service
@Transactional
public class GiftCardManagementServiceImpl implements GiftCardManagementService {

	@Autowired
	private GiftCardManagementRepository giftCardRepo;

	@Override
	public List<GiftCard> getAllGiftCards() {
		return giftCardRepo.findAll();
	}

	@Override
	public GiftCard getGiftCardById(Long giftCardId) throws GiftCardCustomExceptions {
		Optional<GiftCard> gc = giftCardRepo.findById(giftCardId);
		if (gc.isPresent()) {
			return gc.get();
		}
		throw new GiftCardCustomExceptions("No Gift card Exists with id: " + giftCardId, HttpStatus.NOT_FOUND);
	}

//	
	@Override
	public GiftCard updateGiftCard(GiftCard giftCard) throws GiftCardCustomExceptions {
		GiftCard gc = giftCardRepo.save(giftCard);
		if (gc != null) {
			return gc;
		}
		throw new GiftCardCustomExceptions("Error updating gift card. Try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public String deleteGiftCardById(Long giftCard) throws GiftCardCustomExceptions {
		giftCardRepo.deleteById(giftCard);
		Optional<GiftCard> gc = giftCardRepo.findById(giftCard);
		if (gc.isPresent()) {
			throw new GiftCardCustomExceptions("Error updating gift card. Try again..!",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return "Gift card deleted successfully";
	}

	@Override
	public GiftCard addGiftCard(GiftCard giftCard) throws GiftCardCustomExceptions {

		return giftCardRepo.save(giftCard);
	}

	@Override
	public List<GiftCard>getGiftCardName(String giftCardName) throws GiftCardCustomExceptions {
		List<GiftCard> gc = giftCardRepo.findGiftCardName(giftCardName);
		if (gc.size() < 1) {
			throw new GiftCardCustomExceptions("No Gift card Exists with this name: " + giftCardName,
					HttpStatus.NOT_FOUND);
		}
		return gc;
	}

}