package com.startnext.utility;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class GEmailSender {
	public boolean sendEmail(String to, String from, String Subject, String text) {
		boolean flag = false;

		// SMTP properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.host", "smtp.gmail.com");

		final String user = "startnext19";
		final String password = "fdccqxfqxevfyfoy";

		// Session
		Session ses = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {

			// setting up mail
			Message mess = new MimeMessage(ses);
			mess.setFrom(new InternetAddress(from));
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mess.setSubject(Subject);
			mess.setText(text);

//			sending mail
			Transport.send(mess);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public static void main(String[] args) {
		GEmailSender ges = new GEmailSender();
		String to, from, subject, text;
		to = "ps47600@gmail.com";
		from = "startnext19@gmail.com";
		subject = "Test";
		text = "Test";
		boolean b = ges.sendEmail(to, from, subject, text);
		if (b) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}
}