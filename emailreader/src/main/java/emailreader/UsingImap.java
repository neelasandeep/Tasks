package emailreader;

import javax.activation.DataHandler;
import javax.mail.*;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class UsingImap {
	 Multipart multipart;
	 String content;
	 ConfigDataprovider config;
	Logger logger = Logger.getLogger(UsingImap.class);
	public static void main(String[] args) throws IOException, MessagingException {
		UsingImap using= new UsingImap();
		using.readMail();
	}
	public void readMail() throws IOException, MessagingException {
		config=new ConfigDataprovider();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\resources\\log4j.properties");
		Session session = Session.getDefaultInstance(new Properties());
		Store store = session.getStore("imaps");
		store.connect(config.getData("host"), 993, config.getData("mailtoread"), config.getData("readingmailpassword"));
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		
		Message[] messages = inbox.getMessages();
		logger.info("Email Count=" + messages.length);
		logger.info(inbox.getMessageCount());
		logger.info(inbox.getNewMessageCount());
		Date date = new Date();
		logger.info(date);
		
		

		for (int i = messages.length - 1; i > messages.length - 2; i--) {
			logger.info(messages[i].getSentDate());

			long diff = date.getTime() - messages[i].getSentDate().getTime();
			
			
			
			long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
			int hours=(int)diffInMinutes/60;
			
			if(diffInMinutes<=10 && (messages[i].getSubject().equals(config.getData("subject"))) &&(hours<1)) {
			
				String line;
				StringBuilder buffer = new StringBuilder();

				BufferedReader reader = new BufferedReader(new InputStreamReader(messages[i].getInputStream()));

				while ((line = reader.readLine()) != null) {

					buffer.append(line);

				}
				
				String messageContent = config.getData("messagecontetent");
				String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));

				String searchText = result.substring(messageContent.length(), messageContent.length() + 5);

				logger.info("Text found : " + searchText);

				logger.info("---------------------------------");
				logger.info("Email Number " + (i + 1));
				logger.info("Subject: " + messages[i].getSubject());
				logger.info("From: " + messages[i].getFrom()[0]);
				logger.info("type: " + messages[i].getContentType());
				content = messages[i].getContent().toString();
				logger.info(content);
				
				break;
			}else {
				logger.info(" no mail rescived for OTP");
			}
		
		}
	}

	

}
