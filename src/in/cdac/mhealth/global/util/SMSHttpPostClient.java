package in.cdac.mhealth.global.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class SMSHttpPostClient {
//	rajmsdg-rmsc$cdac@2013$RAJSMS
	
//	static String username = "pgimsdg";
//	static String password = "ram@ram1";
//	static String senderid = "PGICHD";
	
	
	public static String username = "eraktkosh";
	public static String password = "eraktkosh#123";
	public static String senderid = "EBLOOD";
	
	static String message = "Test SMS from PGICHD, Sorry for inconvenience!";
	static String mobileNo = "9810489755";
	public static String smsURL = "http://msdgweb.mgov.gov.in/esms/sendsmsrequest";
	static String mobileNos = "9891102810, 9891102810,9891102810";
	// StartTime Format: YYYYMMDD hh:mm:ss
	static String scheduledTime = "20120801 15:40:00";
	static HttpURLConnection connection = null;

	public static void main(String[] args) 
	{
		try 
		{
			new Thread(new Runnable() {
			     public void run() {
			    	 sendSingleSMSThroughSMSGateway(username, password, senderid, smsURL,mobileNo, message);
			     }
			}).start();
		
			// connection = sendBulkSMS(username, password, senderid, mobileNos,message);
		//	connection = sendScheduledSMS(username, password, senderid,	mobileNos, message, scheduledTime);			
			//System.out.println("Done");
//			System.out.println("Resp Code:" + connection.getResponseCode());
//			System.out.println("Resp Message:"+ connection.getResponseMessage());
		} 		
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
	}
	
	public static void sendSingleSMSThroughSMSGateway(String username,String password, String senderId,String sms_URL,String mobileNo, String message) 
	{
		
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
			
		//	System.out.println("Resp Code:" + connection.getResponseCode());
		//	System.out.println("Resp Message:"+ connection.getResponseMessage());
		}
		catch (Exception e) 
		{
		//	System.out.println("Something bad just happened.");
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
		}
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
		//	System.out.println(e);
			e.printStackTrace();
		}

		return connection;
	}
	
	// Method for sending single SMS.
	public static void sendSMSToMultiple(String username,String password, String senderId, Map mobileMp, String message) 
	{
		try
		{
			URL url = new URL("http://services.mgov.gov.in/esms/sendsmsrequest");
			
			
			Iterator iterator = mobileMp.entrySet().iterator();
		    int i=0;
		    while (iterator.hasNext()) 
			{
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				/*System.out.println("The key is: " + mapEntry.getKey()
					+ ",value is :" + mapEntry.getValue());*/
				
				
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
			//System.out.println("Something bad just happened.");
			//System.out.println(e);
			e.printStackTrace();
		}

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
			
			
	//		System.out.println("Resp Code:" + connection.getResponseCode());
	//		System.out.println("Resp Message:"
	//				+ connection.getResponseMessage());

			// write out the data
			int queryLength = query.length();
			output.writeBytes(query);
			output.close();
			
	//		System.out.println("Resp Code:" + connection.getResponseCode());
	//		System.out.println("Resp Message:"
	//				+ connection.getResponseMessage());

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
	//		System.out.println("Something bad just happened.");
	//		System.out.println(e);
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
					+ URLEncoder.encode(senderid,"UTF-8");

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
	//		System.out.println("Resp Message:"
	//				+ connection.getResponseMessage());

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
	//		System.out.println("Something bad just happened.");
	//		System.out.println(e);
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
					+ URLEncoder.encode(senderid,"UTF-8") + "&time="
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
	//		System.out.println("Something bad just happened.");
	//		System.out.println(e);
			e.printStackTrace();
		}
		return connection;
	}
}
