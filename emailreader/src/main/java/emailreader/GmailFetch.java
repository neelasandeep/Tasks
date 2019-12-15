package emailreader;
import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.*;

public class GmailFetch {
	 static Multipart multipart;
	 static String content;
  public static void main( String[] args ) throws Exception {

    Session session = Session.getDefaultInstance(new Properties( ));
    Store store = session.getStore("imaps");
    store.connect("imap.googlemail.com", 993, "neelasandeep9@gmail.com", "SANDEEPNH2");
    Folder inbox = store.getFolder( "INBOX" );
    inbox.open( Folder.READ_ONLY );

    // Fetch unseen messages from inbox folder
    Message[] messages =inbox.getMessages();
    	


    for (int i =messages.length-1 ; i > messages.length-3; i--) {
     
       System.out.println("---------------------------------");
       System.out.println("Email Number " + (i + 1));
       System.out.println("Subject: " +   messages[i].getSubject());
       System.out.println("From: " +   messages[i].getFrom()[0]);
     //  System.out.println("Text: " + messages[i].getContent().toString());
        content= messages[i].getContent().toString();
       multipart = (Multipart) messages[i].getContent();
       converter();
    }
    

  }
  public static void converter()throws Exception  {
	  for (int j = 0; j < multipart.getCount(); j++) {

	        BodyPart bodyPart = multipart.getBodyPart(j);

	        String disposition = bodyPart.getDisposition();

	          if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) { // BodyPart.ATTACHMENT doesn't work for gmail
	              System.out.println("Mail have some attachment");

	              DataHandler handler = bodyPart.getDataHandler();
	              System.out.println("file name : " + handler.getName());                                 
	            }
	          else { 
	              System.out.println("Body: "+bodyPart.getContent());
	              content= bodyPart.getContent().toString();
	            }
	  }
  }
  
}
