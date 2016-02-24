package com.point;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {

	public static String UNAME  = "tutorial4att@gmail.com";
	public static String password = "At&ttool";

	public static void sendMail(String to,String sub,String data){

		try {

			Message msg =getMessageForMail();
			msg.setSubject(sub);
			msg.setFrom(new InternetAddress(UNAME,"ATT TRAINING TOOL"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		//	msg.setRecipient(Message.RecipientType.BCC, new InternetAddress("abhishek_singh89@hotmail.com"));
			msg.setSentDate(new Date());
			msg.setContent(data,"text/html");
			Transport.send(msg);
		} catch (Exception e) {
			System.out.println(e);
		}



	}

	private static Message getMessageForMail() {
		Authenticator auth = new MyPasswordAuthincator();
		Properties p = System.getProperties();
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "465");
		Session sess = Session.getInstance(p,auth);
		Message msg = new MimeMessage(sess);
		return msg;
	}

	static class MyPasswordAuthincator extends Authenticator{


		protected PasswordAuthentication getPasswordAuthentication(){
			System.out.println("getPasswordAuthentication Called");
			return new PasswordAuthentication(UNAME,password);
		}

	}
	
	
	
	
}
