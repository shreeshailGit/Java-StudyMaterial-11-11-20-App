package com.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dto.UnlockAccount;
import com.nt.dto.User;
import com.nt.service.UserServiceImpl;

@Controller
public class UnlockAccountController {

	private static Logger logger = LoggerFactory.getLogger(UnlockAccountController.class);

	@Autowired
	private UserServiceImpl userService;

	@GetMapping(value = "/unlockAcc")
	public String displayUnlockAccForm(@RequestParam("email") String email, Model model) {
		logger.debug("*** Method Execution Started ***");
		try {
			UnlockAccount unlockAcc = new UnlockAccount();
			unlockAcc.setEmail(email);
			model.addAttribute("unlockAcc", unlockAcc);
		} catch (Exception e) {
			logger.error("Exception Occured " + e.getMessage());
		}

		logger.debug("*** Method Execution Ended ***");
		logger.info("*** UnlockAccForm Loaded Successfully ***");
		return "unlockAccForm";
	}

	@PostMapping(value = "/unlockUserAcc")
	public String unlockUserAccForm(@ModelAttribute("unlockAcc") UnlockAccount acc, Model model) {
		logger.debug("*** Method Execution Started ***");
		System.out.println(acc);

		try {
			// logic
			User userAcc = userService.getUserByPwdAnduserEmail(acc.getTempPwd(), acc.getEmail()); //*

			if (userAcc != null) {
				// update pwd and acc status
				userAcc.setStatus("UN-LOCKED");
				userAcc.setPwd(acc.getConfirmPwd());
				boolean isUpdated = userService.updateUserAccDetails(userAcc); //*
				if (isUpdated) {
					logger.info("*** User Account Unlocked Form Loaded ***");
					return "unlockAccntSuccess";
				} // if inner
				else {
					logger.warn("*** User Account Not Updated ***");
				}
			} // if outer
				// display error msg on same form
			model.addAttribute("errMsg", "Please enter correct temporary password");
		} catch (Exception e) {
			logger.error("Exception Occured " + e.getMessage());
		}
		logger.debug("*** Method Execution Ended ***");
		return "unlockAccForm";
	}
}// class
