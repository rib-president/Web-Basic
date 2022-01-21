package com.ja.rubatoex.commons;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSenderThread extends Thread {
	
	private JavaMailSender javaMailSender;
	private String to;
	private String mailSubject;
	private String mailText;
	
	public MailSenderThread(JavaMailSender javaMailSender, String to, String mailSubject, String mailText) {
		this.javaMailSender = javaMailSender;
		this.to = to;
		this.mailSubject = mailSubject;
		this.mailText = mailText;
	}
	
	public void run() {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			mimeMessageHelper.setSubject(mailSubject);
			mimeMessageHelper.setText(mailText, true);
			
			mimeMessageHelper.setFrom("qwer", "RU 관리자");
			mimeMessageHelper.setTo(to);
			
			javaMailSender.send(mimeMessage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
