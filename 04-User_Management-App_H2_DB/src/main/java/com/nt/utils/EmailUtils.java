package com.nt.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.nt.dto.User;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean sendUserAccUnlockEmail(User user) {
		boolean isSent = false;
		try {
			MimeMessage mimeMsg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(user.getUserEmail());
			helper.setSubject("Unlock your Account");
			helper.setText(getUnlockAccEmailBody(user), true);
			javaMailSender.send(mimeMsg);
			return true;
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}// method

	public String getUnlockAccEmailBody(User user) throws IOException {
		StringBuilder sb = new StringBuilder("");
		FileReader fr = new FileReader("UNLOCK-ACCOUNT-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", user.getFname());
		mailBody = mailBody.replace("{LNAME}", user.getLname());
		mailBody = mailBody.replace("{TEMP-PWD}", user.getPwd());
		mailBody = mailBody.replace("{EMAIL}", user.getUserEmail());
		return mailBody;
	}

}// class
