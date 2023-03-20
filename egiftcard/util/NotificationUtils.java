package com.cg.egiftcard.util;

import org.springframework.stereotype.Service;

@Service
public class NotificationUtils {
	public String simpleMailTemplate(String email, String firstName, String lastName) {
		return "<div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, <strong>" + firstName + "</strong></p><br>\r\n"
				+ "                <p>Thanks for registering to E-Gift Card Application. You can buy and send a gift card to anyone with\r\n"
				+ "                    just a click.</p>\r\n"
				+ "                <p>Click on the button below to verify your email: " + email + ".</p>\r\n"
				+ "                <hr style=\"opacity: 25%;\"><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box;cursor: pointer;text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #0aab13;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Activate\r\n"
				+ "                    account</button>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>Buy a gift card now..!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Place\r\n"
				+ "                    a gift order</button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}

	public String sendMailOnUserUpdate(String firstName, String lastName) {
		return "    <div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, " + firstName + "</p><br>\r\n"
				+ "                <p>Your details have been updated Successfully..!.</p>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>Buy a gift card now..!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Place\r\n"
				+ "                    a gift order</button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}
	
	public String sendMailOnUserRegister(String firstName, String lastName) {
		return "    <div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, " + firstName + "</p><br>\r\n"
				+ "                <p>Thanks for Registering to E-Gift Card Application.</p>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>Buy a gift card now..!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Place\r\n"
				+ "                    a gift order</button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}
	
	public String sendMailOnGiftCardPurchase(String firstName, String lastName) {
		return "    <div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, " + firstName + "</p><br>\r\n"
				+ "                <p>Thanks for Purchsing Gift Card. Your gift card will be shipped on/before delivery date.</p>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>Buy a gift card now..!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Place\r\n"
				+ "                    a gift order</button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}
	
	public String sendMailOnGiftCardRedeemed(String firstName, String lastName) {
		return "    <div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, " + firstName + "</p><br>\r\n"
				+ "                <p>Thanks for Using your gift card.</p>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>Buy a gift card now..!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">Place\r\n"
				+ "                    a gift order</button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}
	
	public String sendMailOnGiftCardRecieved(String firstName, String lastName) {
		return "    <div\r\n"
				+ "        style=\"font-family: 'Roboto', sans-serif;width: auto; padding: 10%; display: flex; align-items: center; justify-content: center; background-color: #f2f2f2;\">\r\n"
				+ "        <div style=\"display: flex; gap: 4px; align-items: center; justify-content: center; flex-direction: column;\">\r\n"
				+ "            <div\r\n"
				+ "                style=\"width: -webkit-fill-available; padding: 5%; background-color: #fff; border-top: 5px solid #000000;\">\r\n"
				+ "                <p>Hey, " + firstName + "</p><br>\r\n"
				+ "                <p>You have recieved a gift card. You can check it on your profile.</p>\r\n"
				+ "                <hr style=\"opacity: 25%; margin: 20px 0;\">\r\n"
				+ "                <h2>A Gift Card for you..!!!!</h2>\r\n"
				+ "                <p>With an account, you can...</p><br>\r\n" + "                <ol>\r\n"
				+ "                    <li>View gift card orders history.</li>\r\n"
				+ "                    <li>Redeem a Gift card</li>\r\n"
				+ "                    <li>See the delivery status of your gift card.</li>\r\n"
				+ "                    <li>Purchase a new gift card.</li>\r\n"
				+ "                    <li>Reload an existing gift card.</li>\r\n"
				+ "                </ol><br><button type=\"button\"\r\n"
				+ "                    style=\"box-sizing: border-box; cursor: pointer; text-align: center;color: #ffffff;outline: none;font-size: 1.8rem;border: none;background-color: #236fa1;border-radius: 30px;width: auto;padding: 15px 25px;line-height: 120%;max-width: 100%;word-break: break-word;word-wrap: break-word;\">You can \r\n"
				+ "                  use your Gift Card now. </button>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "    </div> ";
	}
}
