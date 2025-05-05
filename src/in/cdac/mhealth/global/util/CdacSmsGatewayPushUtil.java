package in.cdac.mhealth.global.util;
import hisglobal.utility.SMSServices;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class CdacSmsGatewayPushUtil {
	
	public static final String sms_username = "aiims_patna";//"eraktkosh";
	public static final String sms_password = "aiimsp@1234";//"eraktkosh#123";//"cdac@2013";
	public static final String sms_senderId = "AIIMSP";//"EBLOOD";//"RAJSMS";
	public static final String sms_message  = "Test SMS from By Quartz Job, Sorry for inconvenience!";
	public static final String sms_mobileNo = "9810489755";
	public static final String sms_url="https://msdgweb.mgov.gov.in/esms/sendsmsrequest";
	public static final String secureKey = "cc9538d1-f0f3-4cab-8ff2-117cbc3e34bc";//"c5d170b9-cde3-4933-a48b-54816a6a502b";
	static HttpURLConnection connection = null;
	
	public static void main(String arr[]){
		CdacSmsGatewayPushUtil.sendSingleSMSThroughSMSGateway("Testing Message","9810489755");
	}
	
	public static final int SMS_SENT_SUCCESSFULLY = 1;
	public static final int ERROR_NO_NUMBER = 2;	
	public static final int ERROR_SMS_SENT = 3;
	public static final int ERROR_NO_STORE = 4;
	public static final int ERROR_NO_MESSAGE = 5;

	
	

	
	public static int sendSingleSMSThroughSMSGateway(String message, String mobileNumber) {
	//public static int sendSMS (String mobileNumber, String message) {
		try {
			if (mobileNumber == null || mobileNumber.equals(""))
				return ERROR_NO_NUMBER;
			if (message == null || message.isEmpty())
				return ERROR_NO_MESSAGE;
			
			// Send SMS
			/*String username = SMSConfig.sms_username;
	        String password = SMSConfig.sms_password;
	        String senderId = SMSConfig.sms_senderId;*/
	        
	        SMSServices sms = new SMSServices();
	        String response = sms.sendSingleSMS(sms_username, sms_password, message, sms_senderId, mobileNumber, secureKey);
	        
	        
	        
	      //  System.out.println("SMS Sent to Mobile " + mobileNumber + ", Response = " + response);
		} catch (Exception e) {
			e.printStackTrace();
		}        
		return SMS_SENT_SUCCESSFULLY;
	}
	
	///marke is as sendSingleSMSThroughSMSGatewayOLD by AKash Singh on date 14-05-2018 due to new SMS gateway
	public static void sendSingleSMSThroughSMSGatewayOld(final String username,final String password, final String senderId,final String sms_URL,final String mobileNo, final String message) 
	{
		new Thread(new Runnable() {
		public void run() {		
		DataOutputStream output =null;
			try 
			{
				URL url = new URL(sms_URL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.setFollowRedirects(true);
	
				String smsservicetype = "singlemsg"; // For single message.
				String query = "username=" + URLEncoder.encode(username, "UTF-8")+ "&password=" + URLEncoder.encode(password, "UTF-8")+ "&smsservicetype=" + URLEncoder.encode(smsservicetype, "UTF-8")
				+ "&content=" + URLEncoder.encode(message, "UTF-8") + "&mobileno="+ URLEncoder.encode(mobileNo, "UTF-8") + "&senderid="+URLEncoder.encode(senderId, "UTF-8");
	
				connection.setRequestProperty("Content-length", String.valueOf(query.length()));
				connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");
	
				output = new DataOutputStream(connection.getOutputStream());
				output.writeBytes(query);
				
				//System.out.println("Resp Code:" + connection.getResponseCode());
			//	System.out.println("Resp Message:"+ connection.getResponseMessage());
			}
			catch (Exception e) 
			{
				//System.out.println("Something bad just happened.");
			//	System.out.println(e);
				e.printStackTrace();
			}
			finally
			{
				if(output!=null)
				{
					try 
					{
						output.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}}
		}).start();
	}
	
	
	
	
	// Method for sending single SMS.
	public static HttpURLConnection sendSingleIndependentSMS(String username,String password, String senderId, String mobileNo, String message) 
	{
		try
		{
			URL url = new URL("http://services.mgov.gov.in/esms/sendsmsrequest");
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			HttpURLConnection.setFollowRedirects(true);
			
			String smsservicetype = "singlemsg"; // For single message.
			String query = "username=" + URLEncoder.encode(username,"UTF-8")
					+ "&password=" + URLEncoder.encode(password,"UTF-8")
					+ "&smsservicetype=" + URLEncoder.encode(smsservicetype,"UTF-8")
					+ "&content=" + URLEncoder.encode(message,"UTF-8") + "&mobileno="
					+ URLEncoder.encode(mobileNo,"UTF-8") + "&senderid="
					+ URLEncoder.encode(senderId,"UTF-8");

			connection.setRequestProperty("Content-length",
					String.valueOf(query.length()));
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

			// open up the output stream of the connection
			DataOutputStream output = new DataOutputStream(
					connection.getOutputStream());

			// write out the data
			int queryLength = query.length();
			output.writeBytes(query);
			// output.close();

			// get ready to read the response from the cgi script
			DataInputStream input = new DataInputStream(
					connection.getInputStream());

			// read in each character until end-of-stream is detected
			for (int c = input.read(); c != -1; c = input.read())
				System.out.print((char) c);
			input.close();
		} 
		catch (Exception e)
		{
			//System.out.println("Something bad just happened.");
			//System.out.println(e);
			e.printStackTrace();
		}

		return connection;
	}
	
	// Method for sending single SMS.
	public static void sendSMSToMultiple(String username,String password, String senderId, Map mobileMp, String message) 
	{
		/*try
		{
			URL url = new URL("http://services.mgov.gov.in/esms/sendsmsrequest");
			
			
			Iterator iterator = mobileMp.entrySet().iterator();
		    int i=0;
		    while (iterator.hasNext()) 
			{
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				System.out.println("The key is: " + mapEntry.getKey()
					+ ",value is :" + mapEntry.getValue());
				
				
				String smsservicetype = "singlemsg"; // For single message.
				String query = "username=" + URLEncoder.encode(username,"UTF-8")
						+ "&password=" + URLEncoder.encode(password,"UTF-8")
						+ "&smsservicetype=" + URLEncoder.encode(smsservicetype,"UTF-8")
						+ "&content=" + URLEncoder.encode((String) mapEntry.getValue(),"UTF-8") + "&mobileno="
						+ URLEncoder.encode((String)mapEntry.getKey(),"UTF-8") + "&senderid="
						+ URLEncoder.encode(senderId,"UTF-8");

				connection = (HttpURLConnection) url.openConnection();
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				HttpURLConnection.setFollowRedirects(true);
				
				connection.setRequestProperty("Content-length",String.valueOf(query.length()));
				connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

				// open up the output stream of the connection
				DataOutputStream output = new DataOutputStream(connection.getOutputStream());

				// write out the data
				int queryLength = query.length();
				output.writeBytes(query);
				// output.close();

				// get ready to read the response from the cgi script
				DataInputStream input = new DataInputStream(connection.getInputStream());

				// read in each character until end-of-stream is detected
				for (int c = input.read(); c != -1; c = input.read())
					System.out.print((char) c);
				input.close();
				connection.disconnect();
				
			}			
		} 
		catch (Exception e)
		{
			System.out.println("Something bad just happened.");
			System.out.println(e);
			e.printStackTrace();
		}*/

		//return connection;
	}

	// Method for sending single SMS.
	public static HttpURLConnection sendSingleSMS(String username,String password, String senderId, String mobileNo, String message) 
	{
		try
		{
			String smsservicetype = "singlemsg"; // For single message.
			String query = "username=" + URLEncoder.encode(username,"UTF-8")
					+ "&password=" + URLEncoder.encode(password,"UTF-8")
					+ "&smsservicetype=" + URLEncoder.encode(smsservicetype,"UTF-8")
					+ "&content=" + URLEncoder.encode(message,"UTF-8") + "&mobileno="
					+ URLEncoder.encode(mobileNo,"UTF-8") + "&senderid="
					+ URLEncoder.encode(senderId,"UTF-8");

			connection.setRequestProperty("Content-length",
					String.valueOf(query.length()));
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

			// open up the output stream of the connection
			DataOutputStream output = new DataOutputStream(
					connection.getOutputStream());
			
			
		//	System.out.println("Resp Code:" + connection.getResponseCode());
		//	System.out.println("Resp Message:"
			//		+ connection.getResponseMessage());

			// write out the data
			int queryLength = query.length();
			output.writeBytes(query);
			output.close();
			
		//	System.out.println("Resp Code:" + connection.getResponseCode());
		//	System.out.println("Resp Message:"
		//			+ connection.getResponseMessage());

			// get ready to read the response from the cgi script
			/*DataInputStream input = new DataInputStream(
					connection.getInputStream());

			// read in each character until end-of-stream is detected
			for (int c = input.read(); c != -1; c = input.read())
				System.out.print((char) c);
			input.close();*/
		} 
		catch (Exception e)
		{
		//	System.out.println("Something bad just happened.");
		//	System.out.println(e);
			e.printStackTrace();
		}

		return connection;
	}
	
	

	// method for sending bulk SMS
	public static HttpURLConnection sendBulkSMS(String username,
			String password, String senderId, String mobileNos, String message) 
	{
		try 
		{
			String smsservicetype = "bulkmsg"; // For bulk msg
			String query = "username=" + URLEncoder.encode(username,"UTF-8")
					+ "&password=" + URLEncoder.encode(password,"UTF-8")
					+ "&smsservicetype=" + URLEncoder.encode(smsservicetype,"UTF-8")
					+ "&content=" + URLEncoder.encode(message,"UTF-8") + "&bulkmobno="
					+ URLEncoder.encode(mobileNos, "UTF-8") + "&senderid="
					+ URLEncoder.encode(senderId,"UTF-8");

			connection.setRequestProperty("Content-length",
					String.valueOf(query.length()));
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

			// open up the output stream of the connection
			DataOutputStream output = new DataOutputStream(
					connection.getOutputStream());

			// write out the data
			int queryLength = query.length();
			output.writeBytes(query);
			// output.close();

		//	System.out.println("Resp Code:" + connection.getResponseCode());
		//	System.out.println("Resp Message:"
		//			+ connection.getResponseMessage());

			// get ready to read the response from the cgi script
			DataInputStream input = new DataInputStream(
					connection.getInputStream());

			// read in each character until end-of-stream is detected
			for (int c = input.read(); c != -1; c = input.read())
				System.out.print((char) c);
			input.close();
		} 
		catch (Exception e)
		{
		//	System.out.println("Something bad just happened.");
		//	System.out.println(e);
			e.printStackTrace();
		}
		return connection;
	}

	// method for sending the scheduled SMS
	public static HttpURLConnection sendScheduledSMS(String username,
			String password, String senderId, String mobileNos, String message,
			String scheduledTime) {

		try {
			String smsservicetype = "schmsg"; // For Scheduled message.

			String query = "username=" + URLEncoder.encode(username,"UTF-8")
					+ "&password=" + URLEncoder.encode(password,"UTF-8")
					+ "&smsservicetype=" + URLEncoder.encode(smsservicetype,"UTF-8")
					+ "&content=" + URLEncoder.encode(message,"UTF-8") + "&bulkmobno="
					+ URLEncoder.encode(mobileNos, "UTF-8") + "&senderid="
					+ URLEncoder.encode(senderId,"UTF-8") + "&time="
					+ URLEncoder.encode(scheduledTime, "UTF-8");

			connection.setRequestProperty("Content-length",
					String.valueOf(query.length()));
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

			// open up the output stream of the connection
			DataOutputStream output = new DataOutputStream(
					connection.getOutputStream());

			// write out the data
			int queryLength = query.length();
			output.writeBytes(query);
			// output.close();

		//	System.out.println("Resp Code:" + connection.getResponseCode());
		//	System.out.println("Resp Message:"
			//		+ connection.getResponseMessage());

			// get ready to read the response from the cgi script
			DataInputStream input = new DataInputStream(
					connection.getInputStream());

			// read in each character until end-of-stream is detected
			for (int c = input.read(); c != -1; c = input.read())
				System.out.print((char) c);
			input.close();
		} 
		catch (Exception e) 
		{
		//	System.out.println("Something bad just happened.");
		//	System.out.println(e);
			e.printStackTrace();
		}
		return connection;
	}
}
