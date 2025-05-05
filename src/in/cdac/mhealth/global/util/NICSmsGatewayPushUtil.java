package in.cdac.mhealth.global.util;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NICSmsGatewayPushUtil {
	
	private static String username="nims.sms";
	private static String password="Qa%23%2412Ta";
	private static String senderId="EBLOOD";
	private static String secureKey="4ac3bfc4-e1de-4a03-a80e-83b075f6fdb5";
	
	
	public static void main(String arr[]){
		
		String testMessage="Generated CR NO: 934344123\n"+
				"SMS: Your Provisional Registration Successful in NIMS!\n"+
				"Shakeela\n"+ 
				"PR No.: 934344123\n"+
				"Dept.: Vascular Surgery(Vascular Surgery)(Th, M, W)\n"+
				"Valid till: 09/11/2017\n"+
				"Visit NIMS between 8.00-11.30 AM (Working Days).";
		try {
			NICSmsGatewayPushUtil.sendSingleSMS(URLEncoder.encode(testMessage, "UTF-8"),"9810489755");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendSingleSMS(String message , String mobileNumber){
		try {
			//SSL Certificate Error Fix
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
				public X509Certificate[] getAcceptedIssuers(){return null;}
				public void checkClientTrusted(X509Certificate[] certs, String authType){}
				public void checkServerTrusted(X509Certificate[] certs, String authType){}
			}};

			// Install the all-trusting trust manager

			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			sendGet(message,mobileNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
		private static void sendGet(String message , String mobileNumber) throws Exception {

			String url = "https://smsgw.sms.gov.in/failsafe/HttpLink?username=nims.sms&pin=Qa%23%2412Ta&message="+
					URLEncoder.encode(message, "UTF-8")+"&mnumber="+mobileNumber+"&signature=NICSMS";

			url = url.replace(" ", "%20");
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
	//		System.out.println("Reg SMS Status: "+con.getResponseMessage());
			con.disconnect();


//			// optional default is GET
//			con.setRequestMethod("GET");
//
//			//add request header
//			con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");
//
//			int responseCode = con.getResponseCode();
//			System.out.println("\nSending 'GET' request to URL : " + url);
//			System.out.println("Response Code : " + responseCode);
//
//			BufferedReader in = new BufferedReader(
//			        new InputStreamReader(con.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//
//			//print result
//			System.out.println(response.toString());
//			
//			con.disconnect();

		}
}
