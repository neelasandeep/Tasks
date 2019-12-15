package emailreader;




import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.apache.log4j.Logger;

public class SendMail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, MessagingException {
		Logger logger = Logger.getLogger(SendMail.class);
		final String fromEmail = "primesonprime@gmail.com"; //requires valid gmail id
		final String password = "SANDEEPN2H"; // correct password for gmail id
		final String toEmail = "neelasandeep9@gmail.com"; // can be any email id 
		
		logger.info("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"Testing otp", "Your otp is 00009");
		UsingImap using= new UsingImap();
		using.readMail();
		
	}

	
}
