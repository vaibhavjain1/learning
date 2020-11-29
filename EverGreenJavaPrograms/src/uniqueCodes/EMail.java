package uniqueCodes;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EMail {
	public static final String TO_EMAIL = "abvaibhav@gmail.com"; // Recipient's email ID needs to be mentioned.
	public static final String USERNAME = "_mainaccount@jobserviceprovider.com";
	public static final String PASSWORD = "e)9Nh~5D_3";
	
	public static void main(String[] args) {
		Properties prop = setupSMTPDetails();

		// Get the default Session object.
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		session.setDebug(true);
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(USERNAME));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_EMAIL));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	private static Properties setupSMTPDetails() {
		// Get system properties
		Properties prop = System.getProperties();

		// Setup mail server
		prop.put("mail.smtp.host", "mail.jobserviceprovider.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		return prop;
	}	
	
	private static Properties setupGMailServerSSL() {
		// Get system properties
		Properties prop = System.getProperties();

		// Setup mail server
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		return prop;
	}

	private static Properties setupGMailServerTLS() {
		// Get system properties
		Properties prop = System.getProperties();

		// Setup mail server
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		return prop;
	}
}