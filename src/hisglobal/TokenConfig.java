/**********************************************************
 Project:	   DWH_PHD_OPEN	
 File:         TokenConfig.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package hisglobal;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;
/*
import mms.DelayedDeliveryMailBO;
import mms.DrugExpiryMailStoreWise;
import mms.DrugExpiryMailStoreWiseBO;
import mms.LetterOfAcceptanceMailBO;
import mms.SampleJavaMailCCAndBcc;
import mms.SupplierDeliveryStatusReportMailBO;*/

import org.apache.struts.Globals;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenConfig.
 */
public class TokenConfig extends DispatchAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#generateToken(javax.servlet.http.
	 * HttpServletRequest)
	 */
	public String generateToken(HttpServletRequest request) 
	{
		//System.out.println("Indie Token Config---->"+request.getSession().getAttribute("LANGUAGE"));
		if(request.getSession().getAttribute("LANGUAGE").equals("hindi"))
		{	
		    request.getSession().setAttribute(Globals.LOCALE_KEY,new Locale("hi", "IN"));
		}
		else if(request.getSession().getAttribute("LANGUAGE").equals("english"))
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY, Locale.ENGLISH);
			System.out.println(" Before Mail Data--->>");
	 		
	 	//SampleJavaMailCCAndBcc.getNearExpiryDrugEmailDtl(request); // all warehouse
			
		//DrugExpiryMailStoreWiseBO.getNearExpiryDrugEmailDtl(); // warehouse wise
			
		//	DelayedDeliveryMailBO.getDelayedDeliveryMailDtl(); // delaymail
			
			//SupplierDeliveryStatusReportMailBO.getSupplierDeliveryStatusReporMailDtl(); // SupplierDeliveryStatusReport
			
			
	 		System.out.println(" After Mail Data--->>");
		}
		else if(request.getSession().getAttribute("LANGUAGE").equals("telegu"))
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY,new Locale("te", "IN"));
		}
		else if(request.getSession().getAttribute("LANGUAGE").equals("marathi"))
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY,new Locale("mr", "IN"));
		}
		else if(request.getSession().getAttribute("LANGUAGE").equals("tamil"))
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY,new Locale("ta", "IN"));
		}		
		else if (request.getSession().getAttribute("LANGUAGE").equals("gujrati")) 
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale("gu", "IN"));
				
		}
		else if (request.getSession().getAttribute("LANGUAGE").equals("punjabi")) 
		{
			request.getSession().setAttribute(Globals.LOCALE_KEY, new Locale("pu", "IN"));
				
		}
		
		saveToken(request);
		return "1";
	}

	/**
	 * Validate token. 
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String validateToken(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String retVal = "0";
		try {
			if (isTokenValid(request))
				retVal = "1";
			else
				retVal = "0";
		} catch (Exception e) {
			e.printStackTrace();
			retVal = "0";
		}
        //System.out.println("--T/F-->"+retVal);
		freeToken(request);

		if (retVal.equals("0")) {
			response.sendRedirect("/DWH_CMSS/startup/index_exeption.jsp");
			throw new Exception("Token not validated !!");
		}
		return retVal;
	}

	/**
	 * Free token.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	public String freeToken(HttpServletRequest request) {

		resetToken(request);
		return "1";
	}

	/**
	 * Generate secure random number.
	 * 
	 * @param request
	 *            the request
	 * @return the string
	 */
	public static String GenerateSecureRandomNumber(HttpServletRequest request) {
		String tokenNo = "";
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			tokenNo = hexEncode(result);
			request.getSession().setAttribute("UNIQUE_ID", tokenNo);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return tokenNo;
	}

	public static String GenerateSecureRandomCaptche() {
		String tokenNo = "";
		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			tokenNo = hexEncode(result);
		 
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		return tokenNo;
	}
	
	/**
	 * Hex encode.
	 * 
	 * @param aInput
	 *            the a input
	 * @return the string
	 */
	private static String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

	//In TokenConfig.java
	public static StringBuffer getCircularDetails() {

		HisDAO dao = null;
		WebRowSet wb = null;

		String strQuery;
		int nqryIndex = 0;
		StringBuffer br=new StringBuffer();
		String prevDate = "";
		int i = 0;	
		int j = 1;

		try {
			dao = new HisDAO("mms", "loginDao");		

			strQuery = "SELECT HSTSTR_SUBJECT,TO_CHAR(HSTDT_CIRCULAR_DATE,'DD-MON-YYYY'),NVL(hststr_file_name,'0') as filename FROM HSTT_CIRCULAR_DTL  WHERE GNUM_ISVALID <> 0 AND (HSTDT_CIRCULAR_DATE + HSTNUM_EXPIRY_DAYS) > SYSDATE AND GNUM_ISPUBLICCIRCULAR = 1 ORDER BY  HSTDT_CIRCULAR_DATE DESC";
			nqryIndex = dao.setQuery(strQuery);
			
			wb = dao.executeQry(nqryIndex);
			if (wb.size() != 0) {

				while (wb.next()) {
						
						
						if(wb.getString(3).equals("0")){
							if(i==0){
								br.append("<li>");
								br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
								br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;'><b>&nbsp"+wb.getString(1)+"</b></span>");
								br.append("</li>");
								System.out.println("1");
								
							}else{
								if(wb.getString(2).equals(prevDate)){
									j++;
									br.append("<li >");	
									br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
									br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;'><b>&nbsp"+wb.getString(1)+"</b></span>");
									br.append("</li>");
									System.out.println("2");
								}else{
									j=1;
									br.append("<hr style='border-bottom: 2px dotted #8c8c8c;'>");
									br.append("<li >");	
									br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
									br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;'><b>&nbsp"+wb.getString(1)+"</b></span>");
									br.append("</li>");
									System.out.println("2");
								}
							}
							
						}
						else{ 
							
							if(i==0){
								br.append("<li >");
								br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
								br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;'><b>&nbsp"+wb.getString(1)+"</b></span><span style='color:#5bc0de;'><a href='#'onclick='getfiledownload(\""+wb.getString(3)+"\")'><b> Click Here For Download</b></a> </span>");
								br.append("</li>");
								System.out.println("3");
							}else{
								if(wb.getString(2).equals(prevDate)){
									j++;
									//br.append("<hr style='border-bottom: 2px dotted #8c8c8c;'><br><span style='color:#222;'>"+wb.getString(1)+"</span> <span><a href='#'onclick='getfiledownload(\""+wb.getString(3)+"\")'>&nbsp   Click Here For Download</a> </span>");
									br.append("<li >");	
									br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
									br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;'><b>&nbsp"+wb.getString(1)+"</b></span><span style='color:#5bc0de;'><a href='#'onclick='getfiledownload(\""+wb.getString(3)+"\")'> <b> Click Here For Download</b></a> </span>");
									br.append("</li>");
								}else{
									j=1;
									br.append("<hr style='border-bottom: 2px dotted #8c8c8c;'>");
									br.append("<li>");	
									br.append("<span style='color:red;'><b>"+wb.getString(2)+"&nbsp</b></span>");
									br.append("&nbsp<i class='fas fa-envelope-open-text' style='color:red;'></i><span style='color:white;' ><b>&nbsp"+wb.getString(1)+"</b></span><span style='color:#5bc0de;'><a href='#'onclick='getfiledownload(\""+wb.getString(3)+"\")'> <b> Click Here For Download</b></a> </span>");
									br.append("</li>");
									System.out.println("4");
								}
							}
						}
											
											i++;
											
											prevDate = wb.getString(2);
										
					}
				
				//br.append("</ul>");

			} else {			
				br.append("<h2 style='text-align: center;padding-top: 8%;'>No Circular Found</b>");				

			}
				
			
			wb.close();			

		} catch(Exception e){
			e.printStackTrace();
			throw new HisException(e.getMessage());
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return br;
	}
	
	public static StringBuffer getWareHouseDetails() {

		HisDAO dao = null;
		WebRowSet wb = null;

		String strQuery;
		int nqryIndex = 0;
		StringBuffer br=new StringBuffer();
		String prevDate = "";
		int i = 1;	

		try {
			dao = new HisDAO("mms", "loginDao");		

			strQuery = "SELECT hststr_store_name , hststr_header1||' '||hststr_header2||' '||hststr_header3 as address,NVL(hststr_tel_no,'--') , NVL(hststr_email,'--')  FROM hstt_store_mst  where gnum_isvalid=1  and sstnum_dwh_type_id = 14  and hstnum_store_id not in (99929216)  order by hststr_store_name;";
			nqryIndex = dao.setQuery(strQuery);
			
			wb = dao.executeQry(nqryIndex);
			if (wb.size() != 0) {
				br.append("<table border='2'>");
				br.append("<tr>");
				br.append("<th>SR No.</th>");
				br.append("<th>Warehouse Name</th>");
				br.append("<th colspan='2'>Address</th>");
				br.append("<th>Telephone No.</th>");
				br.append("<th>Email</th>");
				br.append("</tr>");
				System.out.println("1");

				while (wb.next()) {
						
								br.append("<tr>");
								br.append("<td>"+i+"</td>");
								br.append("<td>"+wb.getString(1)+"</td>");
								br.append("<td colspan='2' >"+wb.getString(2)+"</td>");
								br.append("<td>"+wb.getString(3)+"</td>");
								br.append("<td>"+wb.getString(4)+"</td>");
								br.append("</tr>");			
				
								i++;
			}
			}else {			
				br.append("<tr><td style='text-align: center;padding-top: 8%;'><b>No Data Found</b></td><tr>");				

			}
			br.append("</table>");
			wb.close();			

		} catch(Exception e){
			throw new HisException(e.getMessage());
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return br;
	}
	
	public static StringBuffer getDrugDetails() {

		HisDAO dao = null;
		WebRowSet wb = null;

		String strQuery;
		int nqryIndex = 0;
		StringBuffer br=new StringBuffer();
		String prevDate = "";
		int i = 1;	

		try {
			dao = new HisDAO("mms", "loginDao");		

			strQuery = "SELECT DISTINCT MMS_MST.GET_ITEM_DTL(1, 998, A.HSTNUM_ITEMBRAND_ID) AS DRUGNAME , MMS_MST.GET_PROGRAMME_NAME(1, 998, A.HSTNUM_PROGRAMME_ID) AS PROGRAMME_NAME FROM   HSTT_PROGRAMME_ITEM_MST A, HSTT_DRUGBRAND_MST B WHERE  A.GNUM_ISVALID = 1  AND B.GNUM_ISVALID = 1AND  B.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID order by DRUGNAME;";
			nqryIndex = dao.setQuery(strQuery);
			
			wb = dao.executeQry(nqryIndex);
			if (wb.size() != 0) {
				br.append("<table border='2'>");
				br.append("<tr>");
				br.append("<th>SR No.</th>");
				br.append("<th>Drug Name</th>");
				br.append("<th>Programme Name</th>");
				br.append("</tr>");
				System.out.println("1");

				while (wb.next()) {
						
								br.append("<tr>");
								br.append("<td>"+i+"</td>");
								br.append("<td>"+wb.getString(1)+"</td>");
								br.append("<td>"+wb.getString(2)+"</td>");
								br.append("</tr>");		
								i++;			

			}
			}else {			
				br.append("<tr><td style='text-align: center;padding-top: 8%;'><b>No Data Found</b></td><tr>");				

			}
			br.append("</table>");
			wb.close();			

		} catch(Exception e){
			throw new HisException(e.getMessage());
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return br;
	}
}
