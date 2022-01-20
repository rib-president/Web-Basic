package com.ja.finalproject.commons;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailSenderThread extends Thread {
	
	private JavaMailSender javaMailSender;
	private String to;
	private String message;
	
	public MailSenderThread(JavaMailSender javaMailSender,
							String to, String message) {
		this.javaMailSender = javaMailSender;
		this.to = to;
		this.message = message;
	}
	
	public void run() {
		// 인증키를 메일로 전송
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			// wrapper 클래스(MimeMessage를 wrapping)
			MimeMessageHelper mimeMessageHelper = 
					new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			mimeMessageHelper.setSubject("회원가입을 축하드립니다.");
			mimeMessageHelper.setText(message, true);
			
			// setFrom 첫 번째 파라미터는 꼭 영어로 해야 함(한글X)
			mimeMessageHelper.setFrom("qwer", "FP 관리자");	// 보내는 사람: FP 관리자
			mimeMessageHelper.setTo(to);
			
			javaMailSender.send(mimeMessage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
