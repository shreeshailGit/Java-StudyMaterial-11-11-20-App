package com.nt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.dto.UnlockAccount;
import com.nt.dto.User;
import com.nt.service.UserServiceImpl;
import com.nt.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserValidator validator;

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/home")
	public String showHomepage() {
		return "homeDef"; // tiles def as lvn name
	}

	@GetMapping(value = { "/", "/login" })
	public String homePage(@ModelAttribute("usr") User user) {
		return "login";
	}

	@PostMapping(value = "/validatelogin")
	public String validateEmail(@ModelAttribute("usr") User user, Model model, BindingResult errors) {
		logger.debug("*** Method Execution Started  ***");
		System.out.println("vflag update:: " + user.getVflag());

		if (user.getVflag().equalsIgnoreCase("no")) { // enable server side form validations only when client form
														// validations are not done
			if (validator.supports(user.getClass()))
				validator.validate(user, errors);
		}
		if (errors.hasErrors())
			return "login";

		try {
			User userDetails = userService.getUserByUseremailAPwd(user.getUserEmail(), user.getPwd());
			if (userDetails == null) {
				logger.error("*** User Email/Password is WRONG ***");
				model.addAttribute("errMsg", "Please enter valide emailId/Password");
				return "login";
			} else if (userDetails != null && userDetails.getStatus().equals("LOCKED")) {
				logger.warn("*** User Account Is Locked  ***");
				model.addAttribute("errMsg", "Your Acccount Is Locked");
				return "login";
			} else if (userDetails != null && userDetails.getStatus().equals("UN-LOCKED")) {
				logger.info("*** User Account Is Un-Locked Successfully ***");
				return "success";
			}
		} catch (Exception e) {
             logger.error(" Exception occured while login "+e.getMessage());
		}

		logger.debug("*** Method Execution Ended  ***");
		return "login";
	}// method

	@GetMapping(value = "/addUser")
	public String registerUser(@ModelAttribute("userFrm") User user, ModelMap map) {
		logger.debug("*** Method Execution Started ***");
		try { 
			Map<Integer, String> countryMap = userService.getAllCountry();
			map.addAttribute("countriesMap", countryMap);
		}
		catch(Exception e) {
	        logger.error("Exception Occured :"+e.getMessage());		
  		}
		logger.debug("*** Method Execution Ended ***");
        logger.info("*** Registration Form Loaded Successfully *** ");
		return "register_form";
	}

	@PostMapping(value = "/register")
	public String userAdded(@ModelAttribute("userFrm") User user, Model model) {
		logger.debug("*** Method Execution Started ***");
		try { 
			// use service
			userService.saveUserAccDetails(user);
			logger.info("*** User Regisration Completed Successfully ***");
		}catch(Exception e) {
			logger.error("Exception Occured While Saving User "+e.getMessage());
		}
		logger.debug("*** Method Execution Ended ***");
		// add lvn
		return "userAccRegSuccess";
	}

	@GetMapping(value = "/getStates")
	@ResponseBody
	public Map<Integer, String> addState(@RequestParam("cid") Integer countryId) {
		logger.debug("*** Method Execution Started ***");
		 Map<Integer, String> statesMap = null;
		  try { 
			statesMap = userService.getStatesByCountry(countryId);	
		  }catch(Exception e) {
			  logger.error("Exception Occured While Getting States "+e.getMessage());
		  }
		  logger.debug("*** Method Execution Ended ***");
		  return statesMap;
	}

	@GetMapping(value = "/getCities")
	@ResponseBody
	public Map<Integer, String> addCity(@RequestParam("sid") Integer stateId) {
		logger.debug("*** Method Execution Started ***");
		Map<Integer, String> citiesMap = null;
          try { 
        	  citiesMap = userService.getCitiesByStates(stateId);
          }		
          catch(Exception e) {
        	  logger.error("Exception Occured While Getting Cities "+e.getMessage());
          }
          logger.debug("*** Method Execution Ended ***");
		return citiesMap;
	}

}// class
