package com.asal.projectmanager.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SendMail {
	
	public  SendMail(){
		
	}
	
//	public static void main(String[] args) {
//		
//		//Japheth Odonya also commented on Wasike's Post
//		//Japheth Odonya commnted on your post
//		
//		// Commenent message to poster
//		String name = "Japheth Odonya ";
//		String messageText = " commented on your post";
//		
//		//comment message to another commenter
//		 name = "Japheth Odonya ";
//		 messageText = " also commented on your post";
//		
//		//send("");
//	}
	public synchronized void send(String toMail, String mailSubject, String mailMessage){
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");

	Session session = Session.getDefaultInstance(props,
		new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("julishawatu","julisha1!");
			}
		});

//	try {

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("julishawatu@gmail.com"));
		
		//message.setRecipients(Message.RecipientType.TO,
		//		InternetAddress.parse("chrisichuli@gmail.com"));

		message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(toMail.trim()));
		
		//message.setSubject("Commented on your post");
		message.setSubject(mailSubject);
		
//		message.setText("Japheth also commented on your post," +
//				"\n\n Thanks!");
		message.setText(mailMessage);


		Transport.send(message);
		
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//System.out.println("Done");
//
//	} catch (MessagingException e) {
//		throw new RuntimeException(e);
//	}
	}

}