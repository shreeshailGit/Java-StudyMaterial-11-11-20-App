package com.nt.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.User;
import com.nt.service.UserServiceImpl;
import com.nt.service.Utility;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgetPasswordController {
   @Autowired
	private UserServiceImpl service;
	@Autowired
   private JavaMailSender javaMailSender;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm() {
	    return "forgot_password_form";
	}
	
	@PostMapping("/forgot_password")
	public String processForgotPassword(HttpServletRequest request, Model model) {
	    String userEmail = request.getParameter("userEmail");
	    String token = RandomString.make(30);
	     
	    try {
	    	service.updateResetPasswordToken(token, userEmail);
	        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
	        sendEmail(userEmail, resetPasswordLink);
	        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
	         
	    } catch (Exception ex) {
	        model.addAttribute("error", ex.getMessage());
	    } 
	         
	    return "forgot_password_form";
	}

	private void sendEmail(String userEmail, String link) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom("contact@shopme.com", "Shopme Support");
	    helper.setTo(userEmail);
	     
	    String subject = "Here's the link to reset your password";
	     
	    String content = "<p>Hello,</p>"
	            + "<p>You have requested to reset your password.</p>"
	            + "<p>Click the link below to change your password:</p>"
	            + "<p><a href=\"" + link + "\">Change my password</a></p>"
	            + "<br>"
	            + "<p>Ignore this email if you do remember your password, "
	            + "or you have not made the request.</p>";
	     
	    helper.setSubject(subject);
	     
	    helper.setText(content, true);
	     
	    javaMailSender.send(message);
		
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
	    User user = service.getByResetPasswordToken(token);
	    model.addAttribute("token", token);
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	        return "message";
	    }
	     
	    return "reset_password_form";
	}
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	     
	    User user  = service.getByResetPasswordToken(token);
	    model.addAttribute("title", "Reset your password");
	     
	    if (user == null) {
	        model.addAttribute("message", "Invalid Token");
	        return "message";
	    } else {           
	    	service.updatePassword(user, password);
	         
	        model.addAttribute("message", "You have successfully changed your password.");
	    }
	     
	    return "message";
	}
}//class
