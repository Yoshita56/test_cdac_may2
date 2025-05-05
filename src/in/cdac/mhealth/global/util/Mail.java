package in.cdac.mhealth.global.util;

import java.net.HttpURLConnection;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	static String username = "nims.sms";
	static String password = "Ty@%23n123";
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

	
	public static void main(String ar[]) {
		
		Mail.sendNIMSEmail("sumitsoman@gmail.com", "For Check", "Hello");
		
		
	}
	
	
	public static boolean sendNIMSEmail(String m_to,String m_subject,String m_text) {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", SMTP_PORT);

		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("dispatch.hyd@nims.edu.in","CD@nims123");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dispatch.hyd@nims.edu.in"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(m_to));
			message.setSubject(m_subject);
			message.setText(m_text);

			Transport.send(message);

		//	System.out.println("Done sending email to: "+m_to);

		} catch (MessagingException e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	public static boolean sendEmail(String m_to,String m_subject,String m_text) 
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
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(emailFromAddress));
            msg.addRecipient(Message.RecipientType.TO,
			     new InternetAddress(m_to));
	    // -- Send the mail --
            Transport.send(msg);
        } catch (Exception mex) 
        {
        	mex.printStackTrace();
        }
        return true;
    }

}
