package mms;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SampleJavaMailCCAndBcc 
{
	
	private static final String MAIL_SERVER = "smtp";
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 587;
    //private static final String USER_NAME = "amittjs@gmail.com";  // GMail user name (just the part before "@gmail.com")
    //private static final String PASSWORD = "uhgltcaeqrzfpbya"; // GMail password  // 
    private static final String USER_NAME = "aiimsbbsrpharmacyalert@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static final String PASSWORD = "upfzcwpfwrnyrrgs"; // GMail password 
   
	public static void main(String[] args) 
	{
	
        // Message info       
        String[] to = { "amit_kumar@cdac.in"}; // list of recipient email addresses
        String[] cc={ "amit_kumar@cdac.in" };
        String[] bcc={ "hemantjain@cdac.in" };
        String[] subject = {"Java Send Mail Attachement Example"};
        String[] body = {"Welcome to Java Mail!<h1>Hello</h1>"};		
		
		try
		{
			sendFromGMail(to, cc, bcc, subject, body);
			
			
			System.out.println("Email Sent....!");
		} catch (Exception ex) {
			System.out.println("Could not send email....!");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * getUserTypeList
	 * Gets the lab name combo.
	 * 
	 * @param vo the lab interface qc report dtl trans v o_p
	 */
	/*
	public static void getRpNoticeEmailDtl_old(HttpServletRequest request)
	{
		
		
		String strErr;
		String proc_name1 = "{call pkg_mms_view2.proc_rpnotice_email_dtl(?,?,?,?)}"; // 4
		//String proc_name1 = "{call pkg_mms_view2.proc_rpnotice_email_dtl_new(?,?,?,?)}"; // 4
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		
		
		String strEmailContent="";
		try 
		{			
			dao = new HisDAO("mms","SampleJavaMailCCAndBcc.getRpNoticeEmailDtl())");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "6");
			dao.setProcInValue(procIndex1, "hosp_code", "998");			
			dao.setProcOutValue(procIndex1, "err", 1); 
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);
			// get value
			strErr = dao.getString(procIndex1, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
                System.out.println("EMail --- size  ::  >"+ws.size());
                String[] to       = new String[ws.size()];
                String[] cc       = new String[ws.size()];
                String[] bcc      = new String[ws.size()];
                String[] subject  = new String[ws.size()];
                String[] body     = new String[ws.size()];
                
                           
                
                try 
                {
                	   
                	
                	  int i=0;
                	  String rptSubject = "Dear Sir ,  <br><br> Please find attached stastics from eHOSPITAL Application : <br><br><br><br><br><br>";
                	  String rptEnd    = "<br><br><br><br><br><br>************************** This is System Generated Mail For Your Information Please Donot Reply *******************************<br><br> Regards <br><br> ------ ";
                	  strEmailContent = "<html><body><style>.myTable { width: 60%; text-align: left; background-color: #fffacd;"
                	  		+ " border-collapse: collapse;  }.myTable th { background-color: #daa520; color: white; }"
                	  		+ ".myTable td, .myTable th {   padding: 10px; border: 1px solid #daa520; }</style>"
                	  		+ "<table class='myTable' style ='width:60%'>"
                	  		+ "<tr><th colspan='2' align = 'center'> OPD & Emergency Summary Report </th></tr>"
                	  		+ "<tr><th> RWH</th><th> COUNT</th></tr>";
                	  
                	  
                	  
                	
                	  
                	  

                	  while(ws.next())
                      {
                      	  
                    	  strEmailContent += ws.getString(1) +""+ws.getString(2);
                    	                      	                         	    
                      	                 	   i++;  

                     
                      
                     strEmailContent += "</table></body></html>";
                     // System.out.println("strEmailContent---------->"+strEmailContent);
                     if(ws.getString(3).equals("2"))
                     		{
                    	  sendSingleMailGMail("parasjain@cdac.in","vidyasagar@cdac.in","vidya285540@gmail.com","JOB EXECUTATION ERROR DETAIL MAIL ",rptSubject+"<br/>"+strEmailContent+"<br/>"+rptEnd);
                      		} 
                      }
                	
        			System.out.println("!.........Email Sent..............!");
        		} 
                catch (Exception ex) 
                {
        			System.out.println("!.........Could not send email....!");
        			ex.printStackTrace();
        		}
                
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			//vo.setStrMsgString("SampleJavaMailCCAndBcc.getRpNoticeEmailDtl() --> " + e.getMessage());
			//vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	*/
	/*
	public static void getRpNoticeEmailDtl(HttpServletRequest request)
	{
		
		System.out.println("---------email-test---------");
		String strErr;
		String proc_name1 = "{call pkg_mms_view2.proc_rpnotice_email_dtl(?,?,?,?)}"; // 4
		//String proc_name1 = "{call pkg_mms_view2.proc_rpnotice_email_dtl_new(?,?,?,?)}"; // 4
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		
		
		String strEmailContent="";
		try 
		{			
			dao = new HisDAO("mms","SampleJavaMailCCAndBcc.getRpNoticeEmailDtl())");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "6");
			dao.setProcInValue(procIndex1, "hosp_code", "998");			
			dao.setProcOutValue(procIndex1, "err", 1); 
			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);
			// get value
			strErr = dao.getString(procIndex1, "err");

			if (strErr == null) {
				strErr = "";
			}

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(procIndex1, "resultset");
                System.out.println("EMail --- size  ::  >"+ws.size());
                String[] to       = new String[ws.size()];
                String[] cc       = new String[ws.size()];
                String[] bcc      = new String[ws.size()];
                String[] subject  = new String[ws.size()];
                String[] body     = new String[ws.size()];
                 
                try 
                {
                	   
                	
                	  int i=0;
                	  String rptSubject = "Dear Sir ,  <br><br> Today GMSCL job execution is failed. <br><br><br><br><br><br>";
                	  String rptEnd    = "<br><br><br><br><br><br>************************** This is System Generated Mail For Your Information Please Donot Reply *******************************<br><br> Regards <br><br> ------ ";
                	  strEmailContent = "<html><body><style>.myTable { width: 60%; text-align: left; background-color: #fffacd;"
                	  		+ " border-collapse: collapse;  }.myTable th { background-color: #daa520; color: white; }"
                	  		+ ".myTable td, .myTable th {   padding: 10px; border: 1px solid #daa520; }</style>"
                	  		+ "<table class='myTable' style ='width:60%'>"
                	  		+ "<tr><th colspan='2' align = 'center'> Job Running error Dtl </th></tr>"
                	  		+ "<tr><th> Job date</th><th> Job Name</th></tr>";
                	  
                	  
                	  
                	
                	  
                	  

                      while(ws.next())
                      {
                      	  
                    	  strEmailContent += ws.getString(1) +""+ws.getString(2);
                    	                      	                         	    
                      	                 	   i++;  
                      	                 	   
              			                     strEmailContent += "</table></body></html>";
              			                     // System.out.println("strEmailContent---------->"+strEmailContent);
              			                     if(ws.getString(3).equals("2"))
              			                     		{
              			                    	  sendSingleMailGMail("parasjain@cdac.in","vidyasagar@cdac.in","vidya285540@gmail.com","GMSCL JOB EXECUTATION ERROR DETAIL MAIL ",rptSubject+"<br/>"+strEmailContent+"<br/>"+rptEnd);
              			                      		} 
                      } 
                                   	
        			System.out.println("!.........Email Sent..............!");
        		} 
                catch (Exception ex) 
                {
        			System.out.println("!.........Could not send email....!");
        			ex.printStackTrace();
        		}
                
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			//vo.setStrMsgString("SampleJavaMailCCAndBcc.getRpNoticeEmailDtl() --> " + e.getMessage());
			//vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
	*/
	
	public static void sendSingleMailGMail(String to, String cc, String bcc, String subject, String body ) 
	{
		
		
		
 
    	System.out.println("\n 1st ===> Setup SMTP Mail Server Properties..!");
    	
    	// Get system properties
        Properties properties = System.getProperties();
        
        // Setup mail server        
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.user", USER_NAME);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", SMTP_HOST_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.fallback", "true");
        properties.put("mail.debug", "true");
                
      //---------------------------------------------STEP 2---------------------------------------------
 
        
     	System.out.println("\n\n 2nd ===> Get Mail Session..");
        // Get the Session object.
     	
     	// creates a new session with an authenticator
        Authenticator auth = new Authenticator() 
        {
            public PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(USER_NAME, PASSWORD);
            }
        };
        
        Session session = Session.getInstance(properties, auth);        
 
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);
 
        try 
        {
        	
        	// Set From: header field of the header.
            message.setFrom(new InternetAddress(USER_NAME));            		 
		    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		    message.addRecipient(Message.RecipientType.CC,new InternetAddress(cc));
		    message.addRecipient(Message.RecipientType.BCC,new InternetAddress(bcc));
		    message.setSubject(subject);
		    //message.setContent("<html>"+body+"</html>","text/html");    
		    
		    message.setContent("<html>\n" +
                    "<body>\n" +
                    "\n" +
                    body +
                    "</body>\n" +
                    "</html>", "text/html");
		    
		  
                       
    		/*System.out.println("\n\n 3d===> Get Session and Send Mail For TO  Mail Id----"+to);
    		System.out.println("\n\n CC  Mail Id----"+cc);
    		System.out.println("\n\n BCC  Mail Id----"+bcc);*/
            // Send message
            Transport transport = session.getTransport(MAIL_SERVER);
            transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, USER_NAME, PASSWORD);
            // Comment this line to stop mail
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent Message Successfully....");
        }
        catch (AddressException ae) 
        {
            ae.printStackTrace();
        }
        catch (MessagingException me) 
        {
            me.printStackTrace();
        }
        
      //---------------------------------------------------------------------------------------------------
        
    }
	
	
 
	public static void sendFromGMail(String[] to, String[] cc, String[] bcc, String subject[], String body[]) 
	{
		
		
		
 
    	System.out.println("\n 1st ===> Setup SMTP Mail Server Properties..!");
    	
    	// Get system properties
        Properties properties = System.getProperties();
        
        // Setup mail server        
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST_NAME);
        properties.put("mail.smtp.user", USER_NAME);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", SMTP_HOST_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.fallback", "true");
        properties.put("mail.debug", "true");
                
      //---------------------------------------------STEP 2---------------------------------------------
 
        
     	System.out.println("\n\n 2nd ===> Get Mail Session..");
        // Get the Session object.
     	
     	// creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSWORD);
            }
        };
        
        Session session = Session.getInstance(properties, auth);        
 
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);
 
        try {
        	
        	//---------------------------------------------
        	
        	// Set From: header field of the header.
            message.setFrom(new InternetAddress(USER_NAME));
            
          //---------------------------------------------
            
            InternetAddress[] toAddress = new InternetAddress[to.length];
 
            System.out.println("To Address Length--->>"+to.length);
            
            if(to.length==1)
            {
            	toAddress[0] = new InternetAddress(to[0]);
                message.addRecipient(Message.RecipientType.TO, toAddress[0]);
            }
            else
            {	
		            // To get the array of toaddresses
		            for( int i = 0; i < to.length; i++ )
		            {
		                toAddress[i] = new InternetAddress(to[i]);
		                System.out.println("TO Address--"+i+"->>"+to[i]);
		            }
		            
		            // Set To: header field of the header.
		            for( int i = 0; i < to.length; i++) {
		                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		                
		            }
            }
            
            
            System.out.println("CC Length--->>"+cc.length);
            InternetAddress[] ccAddress = new InternetAddress[cc.length];
            if(cc.length==1)
            {
            	 ccAddress[0] = new InternetAddress(cc[0]);
                 message.addRecipient(Message.RecipientType.CC, ccAddress[0]);
            }
            else
            {            
	            // To get the array of ccaddresses
	            for( int i = 0; i < cc.length; i++ ) 
	            {
	                ccAddress[i] = new InternetAddress(cc[i]);
	                //System.out.println("CC Address--->>"+cc[i]);
	            }
	            
	            // Set cc: header field of the header.
	            for( int i = 0; i < cc.length; i++) 
	            {
	                message.addRecipient(Message.RecipientType.CC, ccAddress[i]);
	            }
	            
            }           
            System.out.println("BCC Length--->>"+bcc.length);
            InternetAddress[] bccAddress = new InternetAddress[bcc.length];
            if(bcc.length==1)
            {
            	 bccAddress[0] = new InternetAddress("amit_kumar@cdac.in");
                 message.addRecipient(Message.RecipientType.BCC, bccAddress[0]);
            }
            else
            {  
	            // To get the array of bccaddresses
	            for( int i = 0; i < bcc.length; i++ ) 
	            {
	                bccAddress[i] = new InternetAddress(bcc[i]);
	                //System.out.println("BCC Address--->>"+bcc[i]);
	            }
	            
	            // Set bcc: header field of the header.
	            for( int i = 0; i < bcc.length; i++) 
	            {
	                message.addRecipient(Message.RecipientType.BCC, bccAddress[i]);
	            }
            }
              
            
            message.setSubject(subject[0]);                       
            message.setContent(body[0],"text/html");  
            
            // Set Subject: header field
            //message.setSubject(subject);
                                  
            // Now set the date to actual message
            message.setSentDate(new Date());
            
            // Now set the actual message
            //message.setContent(body,"text/html");         
            
            
          //---------------------------------------------STEP 3---------------------------------------------
            
    		System.out.println("\n\n 3rd ===> Get Session and Send Mail");
            // Send message
            Transport transport = session.getTransport(MAIL_SERVER);
            transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, USER_NAME, PASSWORD);
            // Comment this line to stop mail
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent Message Successfully....");
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
        
      //---------------------------------------------------------------------------------------------------
        
    }
}