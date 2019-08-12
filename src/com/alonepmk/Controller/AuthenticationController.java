package com.alonepmk.Controller;

import com.alonepmk.ControllerModel.RespondPayload;
import com.alonepmk.Exception.SignUpFailedException;
import com.alonepmk.Manager.AccountManager;
import com.alonepmk.Model.Account;
import com.alonepmk.Utils.MailUtils;
import com.alonepmk.Utils.MathUtils;
import java.io.IOException;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	@Autowired
	MailSender mailSender;
	@Autowired
	private AccountManager accountManager;

	public AuthenticationController() {
	}

	@RequestMapping(value = "/login/{code}", method = RequestMethod.POST, headers = "Accept=application/json")
	public RespondPayload Login(@RequestBody Account account, @PathVariable("code") int code, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = account.getEmail();
		String password = account.getPassword();
		Account acc = null;
		RespondPayload payload = new RespondPayload();
		if (code == 0) {
			acc = accountManager.getAccountByNameAndPassword(email, password);
		} else {
			acc = accountManager.getAccountByNameAndPasswordAndCode(email, password, account.getEmailConfirmCode());
			if (acc != null) {
				accountManager.setConfirmCode(1, email);
			}
		}
		if (acc != null) {
			payload.setAccount(acc);
			payload.setStatus(200);
			session.setAttribute("account", acc);
			Account account1 = (Account) session.getAttribute("account");
		} else {
			payload.setStatus(400);
		}
		return payload;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST, headers = "Accept=application/json")
	public RespondPayload signup(@RequestBody Account account, HttpSession session, HttpServletRequest request) {
		RespondPayload payload = new RespondPayload();
		System.out.println("was here");
		int code = (int) MathUtils.getRandomDoubleBetweenRange(11111D, 99999D);
		account.setEmailConfirmCode(code);
		account.setConfirmation(0);
		try {
			if (accountManager.checkAccountEmailExist(account.getEmail()) == 1) {
				payload.setMessage("Email Already Exist");
				payload.setStatus(405);
			} else {
				accountManager.addNewAccount(account);
				MailUtils.sendMailConfirmCode(account, mailSender);
				payload.setAccount(account);
				payload.setStatus(200);
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new SignUpFailedException();
		}
		return payload;

	}

	@RequestMapping(value = "/checkFirstTime", method = RequestMethod.POST, headers = "Accept=application/json")
	public RespondPayload checkFirstTime(@RequestBody Account account, HttpSession session,
			HttpServletRequest request) {
		RespondPayload payload = new RespondPayload();
		Account acc = accountManager.getAccountByEmail(account.getEmail());
		int Confirm = acc.getConfirmation();
		if (Confirm == 0) {
			payload.setStatus(601);
			payload.setAccount(acc);
		} else {
			payload.setStatus(600);
			payload.setAccount(acc);
		}
		return payload;

	}

}