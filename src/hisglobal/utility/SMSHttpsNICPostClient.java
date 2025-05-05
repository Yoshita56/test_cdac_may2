 /*************************************************Program Header***************************************************\
 ## Copyright Information                       :     C-DAC, Noida  
 ## Project Name                                :     NIMS
 ## Name of Developer                           :     Author : Amit Kumar Ateria
 ## Module Name                                 :     
 ## Process/Database Object Name                :
 ## Purpose                                     :    This  is used to send SMS/Email.
 ## Date of Creation                            :    12-Jul-2016
 
/*********************************************************************************************************************/

package hisglobal.utility;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;  

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SMSHttpsNICPostClient 
{
//	rajmsdg-rmsc$cdac@2013$RAJSMS
	
	static String username = "nims.sms";
	static String password = "Qa%23%2412Ta";//"Ty@%23n123";
	static String senderid = "NICSMS";
	static String message = "Test SMS from NIMS, Sorry for inconvenience!";
	static String mobileNo = "9891102810";
	static String mobileNos = "9891102810, 9891102810,9891102810";
	// StartTime Format: YYYYMMDD hh:mm:ss
	static String scheduledTime = "20120801 15:40:00";
	static HttpURLConnection connection = null;
	static final  String nic_sms_url="https://smsgw.sms.gov.in/failsafe/HttpLink?";
	static final String mailServer="mail.gov.in";//"smtp.cdac.in";
	static final String SMTP_HOST_NAME   = "mail.gov.in";//"smtp.cdac.in";
	static final String SMTP_AUTH_USER   = "dispatch.hyd@nims.edu.in";//"itcell@nims.edu.in";//"amitkumarateria@cdac.in";
	static final String SMTP_AUTH_PWD  	 = "CD@nims123";//"CD@nims123";//"Cd_nims123";
	static final String SMTP_PORT = "465";//"25";
	static final String emailMsgTxt      = "This message is from HMIS";
	static final String emailSubjectTxt  = "test mail";
	static final String emailFromAddress = "dispatch.hyd@nims.edu.in";//"itcell@nims.edu.in";//"amitkumarateria@cdac.in";

	
	
	

	
	
	 
	/*public static void main(String[] args) {
		try {

		String baseURL ="https://smsgw.sms.gov.in/failsafe/HttpLink?username=nims.sms&pin=Ty@%23n123&";
		String replyTo = "NICSMS";
		String recipient = "9891102810";
		String messageBody = "Test message sent via SMS platform using Java";
		//URL encode message body
		messageBody = URLEncoder.encode(messageBody, "UTF-8");
		//Construct URL
		StringBuffer URI = new StringBuffer();
		URI.append(baseURL);
		URI.append("signature=" + replyTo);
		URI.append("&mnumber=" + recipient);
		URI.append("&message=" + messageBody);
		String result = "";
		//Open connection and send request
		System.out.println(URI.toString());
		URL url = new URL(URI.toString());
		URLConnection conn = url.openConnection();
		//Get the response
		BufferedReader rd = new BufferedReader(new InputStreamReader(
		conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
		sb.append(line);
		}
		rd.close();
		//Print results
		result = sb.toString();
		System.out.println("Result:" + result);
		} catch (Exception e) {
		e.printStackTrace();
		}
		}*/
	
	public static void sendTextSMSThroughNICSMSGateway(String username,String password, String senderId,String sms_URL,String mobileNo, String message) 
	{
		try 
		{
			String recipient = "91"+mobileNo;
			String messageBody = "Test message sent via SMS platform using Java";
			//URL encode message body
			messageBody = URLEncoder.encode(message, "UTF-8");
			//Construct URL
			StringBuffer URI = new StringBuffer();
			URI.append(nic_sms_url);
			URI.append("username=" + SMSHttpsNICPostClient.username);
			URI.append("&pin=" + SMSHttpsNICPostClient.password);
			URI.append("&signature=" + SMSHttpsNICPostClient.senderid);
			URI.append("&mnumber=" + recipient);
			URI.append("&message=" + messageBody);
			String result = "";
			
			//Open connection and send request
			//System.out.println(URI.toString());
			URL url = new URL(URI.toString());
			URLConnection conn = url.openConnection();
			//Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
			{
				sb.append(line);
			}
			rd.close();
			//Print results
			result = sb.toString();
			//System.out.println("Result:" + result);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public static void sendUnicodeSMSThroughNICSMSGateway(String username,String password, String senderId,String sms_URL,String mobileNo, String message) 
	{
		try 
		{
			String recipient = "91"+mobileNo;
			String messageBody = "0915094D092F093E00200917093E0902091709410932094000200915094B";
			//Construct URL
			StringBuffer URI = new StringBuffer();
			URI.append(nic_sms_url);
			URI.append("username=" + SMSHttpsNICPostClient.username);
			URI.append("&pin=" + SMSHttpsNICPostClient.password);
			URI.append("&signature=" + SMSHttpsNICPostClient.senderid);
			URI.append("&mnumber=" + recipient);
			URI.append("&message=" + messageBody);
			URI.append("&msgType=UC");
			String result = "";
			//Open connection and send request
			//System.out.println(URI.toString());
			URL url = new URL(URI.toString());
			URLConnection conn = url.openConnection();
			//Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
			{
				sb.append(line);
			}
			rd.close();
			//Print results
			result = sb.toString();
			//System.out.println("Result:" + result);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
	
	
	
	/***************Send Email******************************************/
	

	public String sendMultipleMail( Map recipients, String subject) throws MessagingException
	{
		String result="200";//Successful
		try
		{
			boolean debug = false;
			Properties props = new Properties();
		     props.put("mail.smtp.host", mailServer);
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.smtp.port", SMTP_PORT);


		    Authenticator auth = new SMTPAuthenticator();
		  //Session session = Session.getDefaultInstance(props, auth);
		    Session session = Session.getInstance(props, auth);

		    session.setDebug(debug);
		    Message msg = new MimeMessage(session);

		    // set the from and to address
		    InternetAddress addressFrom = new InternetAddress(SMTP_AUTH_USER);
		    msg.setFrom(addressFrom);
		    Iterator iterator = recipients.entrySet().iterator();
		    int i=0;
		    InternetAddress[] addressTo = new InternetAddress[recipients.size()];
			while (iterator.hasNext()) 
			{
				Map.Entry mapEntry = (Map.Entry) iterator.next();		
				addressTo[i] = new InternetAddress((String)mapEntry.getKey());			 
				msg.setRecipient(Message.RecipientType.TO, addressTo[i]);
			    // Setting the Subject and Content Type
			 	String messageContent=(String)mapEntry.getValue()+"\n\nThanks & Regards\n HIS Cell \n NIMS\n\n\n\n This is an auto-generated mail.Please do not reply!" ;
			    msg.setSubject(subject);
			    msg.setContent(messageContent, "text/plain");
			    Transport.send(msg);
			}
		    
		   /* for (int i = 0; i < recipients.size(); i++)
		    {
		        addressTo[i] = new InternetAddress((String)recipients.get(i));
		    }*/
		    
		    
			
			
		   /* msg.setRecipients(Message.RecipientType.TO, addressTo);


		    // Setting the Subject and Content Type
		    msg.setSubject(subject);
		    msg.setContent(message, "text/plain");
		    Transport.send(msg);*/
		}
		catch (Exception e) 
		{
			 result="500";//Error
			 e.printStackTrace();
		}
		 
		return result;
	 }
	
	public String sendSingleMail(String toEmailId, String subject,String message) throws MessagingException
	{
		 String result="200";//Successful
		 try
		 {
			 boolean debug = false;
			 
		     Properties props = new Properties();
		     props.put("mail.smtp.host", mailServer);
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.smtp.port", SMTP_PORT);
	
		    Authenticator auth = new SMTPAuthenticator();
		  //Session session = Session.getDefaultInstance(props, auth);
		    Session session = Session.getInstance(props, auth);
	
		    session.setDebug(debug);
		    Message msg = new MimeMessage(session);
	
		    // set the from and to address
		    InternetAddress addressFrom = new InternetAddress(SMTP_AUTH_USER);
		    msg.setFrom(addressFrom);
		    
		    InternetAddress addressTo = new InternetAddress((String)toEmailId);	
			msg.setRecipient(Message.RecipientType.TO, addressTo);
			// Setting the Subject and Content Type
			String messageContent=message+"\n\nThanks & Regards\n HIS Cell \n NIMS\n\n\n\n This is an auto-generated mail.Please do not reply!" ;
			msg.setSubject(subject);
			msg.setContent(messageContent, "text/plain");
			Transport.send(msg);
		 }
		 catch (Exception e) 
		 {
			 result="500";//Error
			 e.printStackTrace();
		 }
		 
		return result;
	 }


	/**
	* SimpleAuthenticator is used to do simple authentication
	* when the SMTP server requires it.
	*/
	private class SMTPAuthenticator extends javax.mail.Authenticator
	{
	    public PasswordAuthentication getPasswordAuthentication()
	    {
	        String username = SMTP_AUTH_USER;
	        String password = SMTP_AUTH_PWD;
	        return new PasswordAuthentication(username, password);
	    }
	}
	
    public String sendMailWithAttachement(String filePath,String mailTo,String subject,String message,String fileName)
    {    
    	String result="200";//Successful
    	String to=mailTo;   
        final String user=SMTP_AUTH_USER ;  
        final String password=SMTP_AUTH_PWD  ;   
        //String fileAttachment = "C:\\filename.pdf";

        //1) get the session object      
        Properties properties = System.getProperties();  
        properties.put("mail.smtp.host", mailServer);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(user,password);    
            }   
         });       

        //2) compose message      
        try
        {    
            MimeMessage msg = new MimeMessage(session);    
            msg.setFrom(new InternetAddress(user));     
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
            msg.setSubject(subject);
            
            String messageContent=message+"\n\nThanks & Regards\n HIS Cell \n NIMS\n\n\n\n This is an auto-generated mail.Please do not reply!" ;
			

            //3) create MimeBodyPart object and set your message text        
            BodyPart messageBodyPart1 = new MimeBodyPart();     
            messageBodyPart1.setText(messageContent);          

            //4) create new MimeBodyPart object and set DataHandler object to this object        
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
            //String filename = "SendAttachment.java";//change accordingly     
            DataSource source = new FileDataSource(filePath);    
            messageBodyPart2.setDataHandler(new DataHandler(source));    
            messageBodyPart2.setFileName(fileName);             

            //5) create Multipart object and add MimeBodyPart objects to this object        
            Multipart multipart = new MimeMultipart();    
            multipart.addBodyPart(messageBodyPart1);     
            multipart.addBodyPart(messageBodyPart2);      

            //6) set the multiplart object to the message object    
            msg.setContent(multipart );        

            //7) send message    
            Transport.send(msg);      
            System.out.println("message sent....");   

        }
        catch (MessagingException ex) 
        {
        	result="500";//Error
        	ex.printStackTrace();
        }
        finally
        {
        	
        }
        return result;
    }

    public boolean sendEmail2(String m_to,String m_subject,String m_text) {
        Properties props = new Properties();
        //props.put("mail.smtp.host", d_host);
        //props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.host", "mail.gov.in");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable","true");
        System.setProperty("javax.net.ssl.trustStore","src/emailproject/jssecacerts");
        //System.setProperty("javax.net.ssl.trustStore","chain.p7b");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
		       	"javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        SecurityManager security = System.getSecurityManager();
        try {
            Session session = Session.getInstance(props,
			       new javax.mail.Authenticator() {
                                 protected PasswordAuthentication
		                   getPasswordAuthentication() {
//                                      return new PasswordAuthentication(d_email
//					         ,d_password);
                                        return new PasswordAuthentication("test@nic.in"
                                                 ,"test123delhi");
                                 }
                               });
            //if (verbose)
                session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
	    // -- Set the BODY,SBJECT,FROM and TO fields --
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress("owais@nic.in"));
            msg.addRecipient(Message.RecipientType.TO,
			     new InternetAddress(m_to));
	    // -- Send the mail --
            Transport.send(msg);
        } catch (Exception mex) {
            
                mex.printStackTrace();
            return false;
        }
        return true;
    }

	
	//public static void main(String[] args) 
	//{
		//try 
		//{
			
			 //SMSHttpsNICPostClient sms=new SMSHttpsNICPostClient();
			 //sms.sendTextSMSThroughNICSMSGateway("","","","",mobileNo, message);
			 /*String toEmailId="amitkumarateria@cdac.in";
			String subject="Test Email";
			String message="Test Email Message";
			
			SMSHttpsNICPostClient client=new SMSHttpsNICPostClient();
			String result=client.sendSingleMail(toEmailId,subject,message);
			//String result=client.sendMailWithAttachement("C:\\filename.pdf",toEmailId,"PO Alert","New PO Generated","Purchase Order");
			System.out.println("Result"+result);*/
		//} 
		//catch (Exception e) 
		//{
			//e.printStackTrace();
		//}
		
		
		
		
		
		//Email e = new Email();
		/*SMSHttpsNICPostClient client=new SMSHttpsNICPostClient();
        System.out.println(System.getProperty("user.dir"));
        client.sendEmail("amitkumarateria@cdac.in","from","i am sending u this mail from java application. this is for test, pls ignore.");
*/
	//}
	
	public static String d_email,d_password,d_host,d_port,m_to;
    public static boolean verbose =false ;
    public SMSHttpsNICPostClient() {}
    public boolean sendEmail(String m_to,String m_subject,String m_text) 
    {
        Properties props = new Properties();
        //props.put("mail.smtp.host", d_host);
        //props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable","true");
       // System.setProperty("javax.net.ssl.trustStore","hisglobal/utility/EmailSender/cacerts");
       // System.setProperty("javax.net.ssl.trustStore","src/emailproject/jssecacerts");
        //System.setProperty("javax.net.ssl.trustStore","chain.p7b");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
		       	"javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "true");
        SecurityManager security = System.getSecurityManager();
        try 
        {
            Session session = Session.getInstance(props,
			       new javax.mail.Authenticator() {
                                 protected PasswordAuthentication
		                   getPasswordAuthentication() {
//                                      return new PasswordAuthentication(d_email
//					         ,d_password);
                                        return new PasswordAuthentication(SMTP_AUTH_USER,SMTP_AUTH_PWD);
                                 }
                               });
            //if (verbose)
                session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
	    // -- Set the BODY,SBJECT,FROM and TO fields --
            m_text=m_text + "\n\n\n\n\nDISCLAIMER: PLEASE DO NOT REPLY TO THIS MAIL. THIS IS AN AUTO GENERATED MAIL AND REPLIES TO THIS EMAIL ID ARE NOT ATTENDED TO. FOR ANY QUERIES OR CLARIFICATIONS PLEASE CALL US AT THE CONTACT NUMBERS PROVIDED AT OUR WEBSITE nims.edu.in OR VISIT NIMS.";
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(emailFromAddress));
            msg.addRecipient(Message.RecipientType.TO,
			     new InternetAddress(m_to));
	    // -- Send the mail --
            Transport.send(msg);
        } catch (Exception mex) 
        {
            if (verbose)
                mex.printStackTrace();
            return false;
        }
        return true;
    }

   /* public static void main(String[] args) 
    {
    	SMSHttpsNICPostClient e = new SMSHttpsNICPostClient();
        System.out.println(System.getProperty("user.dir"));
        //e.sendEmail("test22@nic.in","from","i am sending u this mail from java application. this is for test, pls ignore.");
        e.sendEmail("ateriaamit@gmail.com","from","i am sending u this mail from java application. this is for test, pls ignore.");

    }*/
    
    public static void main(String[] args) {

  	  try {

  		URL url = new URL("http://10.226.2.186:8780/INVMGM/services/restful/hisImageRetrievalUtil/331010008122/2/33101");
  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  		conn.setRequestMethod("GET");
  		conn.setRequestProperty("Accept", "application/json");

  		if (conn.getResponseCode() != 200) {
  			throw new RuntimeException("Failed : HTTP error code : "
  					+ conn.getResponseCode());
  		}

  		BufferedReader br = new BufferedReader(new InputStreamReader(
  			(conn.getInputStream())));

  		String output;
  		System.out.println("Output from Server .... \n");
  		while ((output = br.readLine()) != null) {
  			System.out.println(output);
  		}

  		conn.disconnect();

  	  } catch (MalformedURLException e) {

  		e.printStackTrace();

  	  } catch (IOException e) {

  		e.printStackTrace();

  	  }

  	}
}