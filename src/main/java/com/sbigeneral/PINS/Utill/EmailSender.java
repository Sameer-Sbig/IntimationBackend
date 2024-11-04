package com.sbigeneral.PINS.Utill;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@Service
@PropertySource(value = { "classpath:application.properties" })
public class EmailSender {

	
	private static Logger logger = LogManager.getLogger(EmailSender.class);

	
	
	@Autowired
	private Environment environment;

	public void sendEmail(String filePath, String userId, String policyNo, String emailId, String altEmailId,String emailSubject, String emailfrom, String emailBody) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(emailBody, policyNo);
			message = new MimeMessage(session);
			if (emailId.equals("")) {
				logger.info("sending email to "+ userId + "@sbigeneral.in");
				message.addRecipients(Message.RecipientType.TO,"sinu@qworks.co");
				//message.addRecipients(Message.RecipientType.TO, userId + "@sbigeneral.in");

				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			} else {
				logger.info(" in sendmail else");
				message.addRecipients(Message.RecipientType.TO, emailId);
				//message.addRecipients(Message.RecipientType.CC, altEmailId);
			}
			message.setFrom(new InternetAddress(emailfrom));
			message.setSubject(Commons.getMsgSubject(emailSubject, policyNo));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			/*
			 * for(String attachementfile:filePath){ if(attachementfile!=null){
			 * files.add(attachementfile); } }
			 */
			files.add(filePath);
			attachmentFileName = ZipUtil.createZipFile(files, filePath);

			if (attachmentFileName != null) {
				messageBodyPart = new MimeBodyPart();
				File file = new File(attachmentFileName);
				fileDatasource = new FileDataSource(attachmentFileName);
				messageBodyPart.setDataHandler(new DataHandler(fileDatasource));
				messageBodyPart.setFileName(file.getName());
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);

			Transport.send(message);

			logger.info("Sent message successfully...." + filePath);

		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			throw new RuntimeException("Unable to send the email.");
		}
	}
	
	public void sendHealthCardEmail(String filePath, String userId, String policyNo, String emailId, String altEmailId) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(environment.getProperty("emailBodyHealthCard"), policyNo);
			message = new MimeMessage(session);
			if (emailId.equals("")) {
				logger.info("sending email to "+ userId + "@sbigeneral.in");
				message.addRecipients(Message.RecipientType.TO, userId + "@sbigeneral.in");
				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			} else {
				logger.info(" in sendmail else");
				message.addRecipients(Message.RecipientType.TO, emailId);
				//message.addRecipients(Message.RecipientType.CC, userId + "@sbigeneral.in");
				//message.addRecipients(Message.RecipientType.CC, altEmailId);
			}
			message.setFrom(new InternetAddress(environment.getProperty("emailFrom")));
			message.setSubject(Commons.getMsgSubject(environment.getProperty("emailSubjectHealthCard"), policyNo));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			/*
			 * for(String attachementfile:filePath){ if(attachementfile!=null){
			 * files.add(attachementfile); } }
			 */
			files.add(filePath);
			attachmentFileName = ZipUtil.createZipFile(files, filePath);

			if (attachmentFileName != null) {
				messageBodyPart = new MimeBodyPart();
				File file = new File(attachmentFileName);
				fileDatasource = new FileDataSource(attachmentFileName);
				messageBodyPart.setDataHandler(new DataHandler(fileDatasource));
				messageBodyPart.setFileName(file.getName());
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);

			Transport.send(message);

			logger.info("Sent message successfully...." + filePath);

		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			throw new RuntimeException("Unable to send the email.");
		}
	}
	
	public void sendEndoEmail(String filePath, String userId, String endorsementNo, String emailId, String altEmailId) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(environment.getProperty("emailBodyEndo"), endorsementNo);
			message = new MimeMessage(session);
			if (emailId.equals("")) {
				logger.info("sending email to "+ userId + "@sbigeneral.in");
				message.addRecipients(Message.RecipientType.TO, userId + "@sbigeneral.in");
				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			} else {
				logger.info(" in sendmail else");
				message.addRecipients(Message.RecipientType.TO, emailId);
				message.addRecipients(Message.RecipientType.CC, userId + "@sbigeneral.in");
				//message.addRecipients(Message.RecipientType.CC, altEmailId);
			}
			message.setFrom(new InternetAddress(environment.getProperty("emailFrom")));
			message.setSubject(Commons.getMsgSubject(environment.getProperty("emailSubjectEndo"), endorsementNo));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			/*
			 * for(String attachementfile:filePath){ if(attachementfile!=null){
			 * files.add(attachementfile); } }
			 */
			files.add(filePath);
			attachmentFileName = ZipUtil.createZipFile(files, filePath);

			if (attachmentFileName != null) {
				messageBodyPart = new MimeBodyPart();
				File file = new File(attachmentFileName);
				fileDatasource = new FileDataSource(attachmentFileName);
				messageBodyPart.setDataHandler(new DataHandler(fileDatasource));
				messageBodyPart.setFileName(file.getName());
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);

			Transport.send(message);

			logger.info("Sent message successfully...." + filePath);

		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			throw new RuntimeException("Unable to send the email.");
		}
	}
	
	public static InternetAddress[] getAddressList(String[] addressList) throws AddressException {
		InternetAddress[] address = new InternetAddress[addressList.length];
		int counter = 0;
		for (String recipient : addressList) {
			address[counter] = new InternetAddress(recipient.trim());
			counter++;
		}
		return address;
	}

	public String sendEmaildms(String filePath, String emailid, String policyNo) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(environment.getProperty("emailBody"), policyNo);
			message = new MimeMessage(session);
			
				logger.info("sending email to "+ emailid);
				message.addRecipients(Message.RecipientType.TO,emailid);
				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			
			message.setFrom(new InternetAddress(environment.getProperty("emailFrom")));
			message.setSubject(Commons.getMsgSubject(environment.getProperty("emailSubject"), policyNo));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);
			files.add(filePath);
			attachmentFileName = ZipUtil.createZipFile(files, filePath);

			if (attachmentFileName != null) {
				messageBodyPart = new MimeBodyPart();
				File file = new File(attachmentFileName);
				fileDatasource = new FileDataSource(attachmentFileName);
				messageBodyPart.setDataHandler(new DataHandler(fileDatasource));
				messageBodyPart.setFileName(file.getName());
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);

			Transport.send(message);
			logger.info("Sent message successfully...." + filePath);

			return "Email send seccessfull. ";

		
		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			return "Email Not Send .";
			
		}
	
	}
	
	public String sendEmailPassword(String emailid,String password) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(environment.getProperty("emailBody1"),password);
			message = new MimeMessage(session);
			
				logger.info("sending email to "+ emailid);
				message.addRecipients(Message.RecipientType.TO,emailid);
				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			
			message.setFrom(new InternetAddress(environment.getProperty("emailFrom1")));
			message.setSubject(Commons.getMsgSubject(environment.getProperty("emailSubject1"),password));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);
			/*
			 * files.add(filePath); attachmentFileName = ZipUtil.createZipFile(files,
			 * filePath);
			 * 
			 * if (attachmentFileName != null) { messageBodyPart = new MimeBodyPart(); File
			 * file = new File(attachmentFileName); fileDatasource = new
			 * FileDataSource(attachmentFileName); messageBodyPart.setDataHandler(new
			 * DataHandler(fileDatasource)); messageBodyPart.setFileName(file.getName());
			 * multipart.addBodyPart(messageBodyPart); }
			 */

			message.setContent(multipart);

			Transport.send(message);
			//logger.info("Sent message successfully...." + filePath);

			return "Email send seccessfull. ";

		
		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			return "Email Not Send .";
			
		}
	
	}
	
	public String sendEmail(String emailid, String userName,String password) {

		MimeMessage message = null;
		BodyPart messageBodyPart = null;
		Multipart multipart = null;
		String attachmentFileName = null;
		DataSource fileDatasource = null;

		List<String> files = new ArrayList<String>();
		Properties sessionProperties = new Properties();
		try {
			sessionProperties.setProperty("mail.smtp.host", environment.getProperty("smtp.emailHost"));
			sessionProperties.setProperty("mail.smtp.port", environment.getProperty("smtp.emailPort"));
			Session session = Session.getDefaultInstance(sessionProperties);
			String msgBody = Commons.getMsgSubject(environment.getProperty("emailBody"), userName,password);
			message = new MimeMessage(session);
			
				logger.info("sending email to "+ emailid);
				message.addRecipients(Message.RecipientType.TO,emailid);
				//message.addRecipients(Message.RecipientType.CC, environment.getProperty("emailCC"));
			
			message.setFrom(new InternetAddress(environment.getProperty("emailFrom")));
			message.setSubject(Commons.getMsgSubject(environment.getProperty("emailSubject"), userName,password));

			messageBodyPart = new MimeBodyPart();
			multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msgBody, "text/html");
			multipart.addBodyPart(messageBodyPart);
			/*
			 * files.add(filePath); attachmentFileName = ZipUtil.createZipFile(files,
			 * filePath);
			 * 
			 * if (attachmentFileName != null) { messageBodyPart = new MimeBodyPart(); File
			 * file = new File(attachmentFileName); fileDatasource = new
			 * FileDataSource(attachmentFileName); messageBodyPart.setDataHandler(new
			 * DataHandler(fileDatasource)); messageBodyPart.setFileName(file.getName());
			 * multipart.addBodyPart(messageBodyPart); }
			 */

			message.setContent(multipart);

			Transport.send(message);
			//logger.info("Sent message successfully...." + filePath);

			return "Email send seccessfull. ";

		
		} catch (Exception e) {
			logger.error("Error Occured:" + e.getMessage(), e);
			return "Email Not Send .";
			
		}
	
	}

}