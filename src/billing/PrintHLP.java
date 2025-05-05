package billing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisPrinter;
import hisglobal.utility.HisUtil;

/**
 * 
 * @author Amit Kumar
 * 
 */

public class PrintHLP {
	public static int printLine = 0;

	/*This static variable is commented on 26 Aug 2011 for the bug coming in bill receipts reported by PGI.
	Instead of having isDuplicateBill as static variable it is being added to all methods as parameters wherever needed*/
	
	//public static int isDuplicateBill = 0; 
	// 0 - Original, 1 - Duplicate

		
	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR+""+'E';
	public static final String BOLDOFF = ESCAPECHAR+""+'F';
	
	public static final char FORMFEED = 12;
	
	public static int isServiceDiscountReq = 1;
	

	/**
	 * findPrintType(vo) -- > This Method is Used to Select the Report Print
	 * Type
	 * 
	 * @throws Exception
	 */
	public static void findPrintType(String strBillNo, String strBServiceId,
			String strPatAccountNo, String strHospitalCode, String strBillType , HttpServletRequest request,int isDuplicateBill)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		/*
		 * if(strPatAccountNo != null && strPatAccountNo.length() != 10){
		 * 
		 * throw new Exception("PrintHLP.Consolidated()--> Patient Account No.
		 * Cannot be Blank or Invalid"); }
		 */

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

	//	isDuplicateBill = 1;
	
		System.out.println("------billing.PrintHLP.findPrintType------");
		
		System.out.println("strBServiceId------>"+strBServiceId);
		System.out.println("strBillNo------>"+strBillNo);
		System.out.println("strBServiceId------>"+strBServiceId);
		System.out.println("strHospitalCode------>"+strHospitalCode);
		System.out.println("isDuplicateBill------>"+isDuplicateBill);
		System.out.println("strBillType------>"+strBillType);
		System.out.println("------------------------------------------");
		
		
		if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
			
			System.out.println("--------OPD_SERVICES_DUP--------");
					
			OPD_SERVICES_DUP(strBillNo, strBServiceId, strHospitalCode , request,isDuplicateBill); // Print
			// Type
		}
		if (strBServiceId.equals("11")) {
			
			System.out.println("--------IPD_SERVICES_DUP--------");
			IPD_SERVICES_DUP(strBillNo, strPatAccountNo, strBServiceId,
					strHospitalCode , request,isDuplicateBill); // Print Type
		}
		if (strBServiceId.equals("19")) {
			
			System.out.println("--------ADVANCE_DUP--------");
			ADVANCE_DUP(strBillNo, strBServiceId, strHospitalCode , request,isDuplicateBill); // Print
			// Type
		}
		if (strBServiceId.equals("20")) {
			System.out.println("--------PART_PAYMENT_DUP--------");
			PART_PAYMENT_DUP(strBillNo, strBServiceId, strHospitalCode , request,isDuplicateBill); // Print
		}
		if (strBServiceId.equals("21")) 
		{
			System.out.println("--------FINAL_ADJUSTMENT--------");
			FINAL_ADJUSTMENT(strBillNo, strBServiceId, strPatAccountNo,strHospitalCode, strBillType , "1" , request,isDuplicateBill,"");
		}
		
	
		//isDuplicateBill = 0;
		
	}

	/**
	 * findPrintType(vo) -- > This Method is Used to Select the Report Print
	 * Type
	 * 
	 * @throws Exception
	 */
	public static void findPrintType1(String strBillNo, String strBServiceId,
			String strPatAccountNo, String strHospitalCode, String strBillType,
			String strReceiptNo, String strReceiptType , HttpServletRequest request , String[] strTariffList , String strIsDirectMode ,int isDuplicateBill , String strReceiptTypeLabel) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) { throw new
		 * Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be Blank or
		 * Invalid"); }
		 */

		/*
		 * if(strPatAccountNo != null && strPatAccountNo.length() != 10){
		 * 
		 * throw new Exception("PrintHLP.Consolidated()--> Patient Account No.
		 * Cannot be Blank or Invalid"); }
		 */

		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		
		if (strReceiptType.equals("1")) //Receipt
		{
			if ((strBServiceId.equals("10") || strBServiceId.equals("12")) && strBillNo.replace(strHospitalCode, "#").split("#")[1].startsWith("5")) 
			{
				OPD_SERVICES_REGSERV(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0",strReceiptTypeLabel);
			}			
			if ((strBServiceId.equals("10") || strBServiceId.equals("12")) && !strBillNo.replace(strHospitalCode, "#").split("#")[1].startsWith("1") && !strBillNo.replace(strHospitalCode, "#").split("#")[1].startsWith("5")) 
			{
				OPD_SERVICES(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0",strReceiptTypeLabel);
			}
			if (strBServiceId.equals("10") && strBillNo.replace(strHospitalCode, "#").split("#")[1].startsWith("1"))//REG BILL
			{
				OPD_SERVICES_REG(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0",strReceiptTypeLabel);
			}
			if (strBServiceId.equals("11")) 
			{
				IPD_SERVICES_REG(strBillNo, strPatAccountNo, strBServiceId,strHospitalCode, strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0",strReceiptTypeLabel);
			}
			if (strBServiceId.equals("19")) 
			{
				ADVANCE(strBillNo, strBServiceId, strHospitalCode, strReceiptNo , request,isDuplicateBill,"0",strReceiptTypeLabel );
			}
			if (strBServiceId.equals("20")) 
			{
				PART_PAYMENT(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request,isDuplicateBill,strReceiptTypeLabel);
			}
			if (strBServiceId.equals("21")) 
			{
				FINAL_ADJUSTMENT(strBillNo, strBServiceId, strPatAccountNo,strHospitalCode, strBillType, strReceiptNo , request,isDuplicateBill,strReceiptTypeLabel);
			}			
		}
		if (strReceiptType.equals("2")) //Refund
		{
			
			if (strBServiceId.equals("10") ||strBServiceId.equals("12") ) 
			{
				OPD_REFUND(strBillNo, strReceiptNo, strBServiceId,strHospitalCode , request,isDuplicateBill,strReceiptTypeLabel );
			}
			if (strBServiceId.equals("10") && strBillNo.replace(strHospitalCode, "#").split("#")[1].startsWith("1"))//REG BILL
			{
				OPD_REFUND_REG(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0",strReceiptTypeLabel);
			}
			if (strBServiceId.equals("11")) 
			{
				IPD_REFUND(strBillNo, strReceiptNo, strPatAccountNo,strBServiceId, strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("19")) 
			{
				ADVANCE_REFUND_DUP_PRINT(strBillNo, strReceiptNo, strBServiceId,strHospitalCode , request,isDuplicateBill,strReceiptTypeLabel);
			}
			if (strBServiceId.equals("100")) 
			{
				IPD_REFUND_WALLET(strBillNo, strReceiptNo, strPatAccountNo, strBServiceId, strHospitalCode, request, isDuplicateBill);
			}

		}
		if (strReceiptType.equals("3")) //Reconcile
		{
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_RECONCILIATION(strBillNo, strReceiptNo, strBServiceId,
						strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("11")) {
				IPD_RECONCILIATION(strBillNo, strReceiptNo, strPatAccountNo,
						strBServiceId, strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("21")) {
				IPD_FINAL_SETTLE(strBillNo, strReceiptNo, strBServiceId,
						strHospitalCode , request,isDuplicateBill);
			}
		}
		if (strReceiptType.equals("6")) 
		{
			findPrintType(strBillNo, strBServiceId, strPatAccountNo,strHospitalCode, strBillType , request,isDuplicateBill);
		}

	}
	
	public static void findPrintType1Backup(String strBillNo, String strBServiceId,
			String strPatAccountNo, String strHospitalCode, String strBillType,
			String strReceiptNo, String strReceiptType , HttpServletRequest request , String[] strTariffList , String strIsDirectMode ,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) { throw new
		 * Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be Blank or
		 * Invalid"); }
		 */

		/*
		 * if(strPatAccountNo != null && strPatAccountNo.length() != 10){
		 * 
		 * throw new Exception("PrintHLP.Consolidated()--> Patient Account No.
		 * Cannot be Blank or Invalid"); }
		 */

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		
		if (strReceiptType.equals("1")) {

			/*if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_SERVICES(strBillNo, strBServiceId, strHospitalCode,
						strReceiptNo , request , strTariffList , strIsDirectMode,isDuplicateBill); // Print Type
			}*/
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_SERVICES(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0","---"); // Print Type
			}
			/*if (strBServiceId.equals("11")) {
				IPD_SERVICES(strBillNo, strPatAccountNo, strBServiceId,
						strHospitalCode, strReceiptNo , request , strTariffList , strIsDirectMode,isDuplicateBill); // Print Type
			}*/
			if (strBServiceId.equals("11")) {
				IPD_SERVICES(strBillNo, strPatAccountNo, strBServiceId,
						strHospitalCode, strReceiptNo , request , null , strIsDirectMode,isDuplicateBill,"0","---"); // Print Type
			}
			if (strBServiceId.equals("19")) 
			{
				ADVANCE(strBillNo, strBServiceId, strHospitalCode, strReceiptNo , request,isDuplicateBill,"0","---" );
			}
			if (strBServiceId.equals("20")) 
			{
				PART_PAYMENT(strBillNo, strBServiceId, strHospitalCode,strReceiptNo , request,isDuplicateBill,""); // Print Type
			}
			if (strBServiceId.equals("21")) 
			{
				FINAL_ADJUSTMENT(strBillNo, strBServiceId, strPatAccountNo,strHospitalCode, strBillType, strReceiptNo , request,isDuplicateBill,"");
			}
		}
		if (strReceiptType.equals("2")) //REFUND
		{
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) 
			{
				OPD_REFUND(strBillNo, strReceiptNo, strBServiceId,strHospitalCode , request,isDuplicateBill,"" );
			}
			if (strBServiceId.equals("11")) {
				IPD_REFUND(strBillNo, strReceiptNo, strPatAccountNo,
						strBServiceId, strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("19")) {
				ADVANCE_REFUND(strBillNo, strReceiptNo, strBServiceId,
						strHospitalCode , request,isDuplicateBill);
			}
		}
		if (strReceiptType.equals("3")) {
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_RECONCILIATION(strBillNo, strReceiptNo, strBServiceId,
						strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("11")) {
				IPD_RECONCILIATION(strBillNo, strReceiptNo, strPatAccountNo,
						strBServiceId, strHospitalCode , request,isDuplicateBill);
			}
			if (strBServiceId.equals("21")) {
				IPD_FINAL_SETTLE(strBillNo, strReceiptNo, strBServiceId,
						strHospitalCode , request,isDuplicateBill);
			}
		}

		if (strReceiptType.equals("6")) {

			findPrintType(strBillNo, strBServiceId, strPatAccountNo,
					strHospitalCode, strBillType , request,isDuplicateBill);

		}

	}

	/**
	 * MakeClientStr(String ConCatVal) -- > This Method is Used to get Client
	 * Detail String If we pass Client Detail in Concat Format
	 * like:-ClientName^AuthNo^AuthDate^Policy No
	 */
	public static String MakeClientDtlStr(String ConCatVal) {
		String contents1 = new String();
		String Client_Name = null;
		String Auth_No = null;
		String Auth_Date = null;
		String Sanc_Lmt = null;

		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		if (ConCatVal.equals("0") || ConCatVal == null || ConCatVal.equals("")) {
			contents1 = "";
		} else {
			String[] temp = ConCatVal.split("\\^");
			if (temp[0].equals("") || temp[0].equals("0")) {
				Client_Name = "----";
			} else {
				Client_Name = temp[0];
			}
			if (temp[1].equals("") || temp[1].equals("0")) {
				Auth_No = "----";
			} else {
				Auth_No = temp[1];
			}
			if (temp[2].equals("") || temp[2].equals("0")) {
				Auth_Date = "----";
			} else {
				Auth_Date = temp[2];
			}
			if (temp[3].equals("") || temp[3].equals("0")) {
				Sanc_Lmt = "0";
			} else {
				Sanc_Lmt = temp[3];
			}
			contents1 = " Client Name: " + hisutil.appendSpace(Client_Name, 22 , 0)
					+ "\tAuth No.          : " + Auth_No + "\n";
			printLine++;
			contents1 += " Auth Date: " + hisutil.appendSpace(Auth_Date, 27 , 0)
					+ "\tPolicy No.        : " + Sanc_Lmt + "\n";
			printLine++;
		}

		return contents1;
	}

	/**
	 * MakeAddmissionDtl(String ConCatVal) -- > This Method is Used to get
	 * Client Detail String If we pass Client Detail in Concat Format
	 * like:-ClientName^AuthNo^AuthDate^Policy No
	 */
	public static String MakeAddmissionDtl(String ConCatVal) {
		String contents1 = new String();
		String Adm_No = null;
		String AdmnDate_Time = null;
		String Ward_Name = null;
		String DisDate_Time = null;

		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		if (ConCatVal.equals("0") || ConCatVal == null || ConCatVal.equals("")) {
			contents1 = "";
		} else {
			String[] temp = ConCatVal.split("\\^");
			if (temp[0].equals("") || temp[0].equals("0")) {
				Adm_No = "----";
			} else {
				Adm_No = temp[0];
			}
			if (temp[1].equals("") || temp[1].equals("0")) {
				AdmnDate_Time = "----";
			} else {
				AdmnDate_Time = temp[1];
			}
			if (temp[2].equals("") || temp[2].equals("0")) {
				Ward_Name = "----";
			} else {
				Ward_Name = temp[2];
			}
			if (temp[3].equals("") || temp[3].equals("0")) {
				DisDate_Time = "0";
			} else {
				DisDate_Time = temp[3];
			}
			contents1 = " Admission No: " + hisutil.appendSpace(Adm_No, 20,0)
					+ "\tAdmission Date   : " + AdmnDate_Time + "\n";
			printLine++;
			contents1 += " Ward Name: " + hisutil.appendSpace(Ward_Name, 27,0)
					+ "\tDis Date         : " + DisDate_Time + "\n";
			printLine++;
		}

		return contents1;
	}

	/**
	 * Header(String ConCatVal) -- > This Method is Used to get Client Detail
	 * String If we pass Client Detail in Concat Format
	 * like:-Header1^Header2^Header3^Header4
	 */
	public static String Header(String Header1, String Header2, String Header3,
			String Header4) {
		String contents2 = new String();
		String H1 = null;
		String H2 = null;
		String H3 = null;
		String H4 = null;
		contents2 = "\n";
		printLine++;

		if (Header1.trim().equals("") || Header1.trim().equals("-") || Header1.trim().length() == 0) {
			H1 = "";
		} else {
			H1 = Header1;
			contents2 += "                         " + H1 + "                         \n ";
			printLine++;
		}
		if (Header2.trim().equals("") || Header2.trim().equals("-") ||  Header2.trim().length() == 0) {
			H2 = "";
		} else {
			H2 = Header2;
			contents2 += "                         " + H2 + "                         \n ";
			printLine++;
		}
		if (Header3.trim().equals("") ||  Header3.trim().equals("-") || Header3.trim().length() == 0) {
			H3 = "";
		} else {
			H3 = Header3;
			contents2 += "                         " + H3 + "                         \n ";
			printLine++;
		}
		if (Header4.trim().equals("") || Header4.trim().equals("-") || Header4.trim().length() == 0) {
			H4 = "";
		} else {
			H4 = Header4;
			contents2 += "                         " + H4 + "                         \n";
			printLine++;
		}
		contents2 += "                         \n";
		printLine++;

		return contents2;
	}

	/**
	 * Footer(String ConCatVal) -- > This Method is Used to get Client Detail
	 * String If we pass Client Detail in Concat Format
	 * like:-Header1^Header2^Header3^Header4
	 */
	public static String Footer(String Footer, HttpServletRequest request,String strDisclaimer) throws Exception
	{
		String contents3 = new String();
		String F1 = null;
		String disclaimer = null;

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		String strCounterName = "";
		String strUserName = "";

		if (Footer.equals("") || Footer.equals("-") || Footer.equals("0"))
		{
			F1 = "";
		} 
		else
		{
			F1 = Footer;
		}

		if (strDisclaimer.equals("") || strDisclaimer.equals("-")|| strDisclaimer.equals("0"))
		{
			disclaimer = "";
		} 
		else
		{
			disclaimer = strDisclaimer;
		}
		try
		{

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			voObj.setStrHospCode(request.getSession().getAttribute(	"HOSPITAL_CODE").toString());
			boObj.getCounterAndUserName(voObj);

			if (voObj.getStrCounterAndUserName().next())
			{
				String strTemp[] = voObj.getStrCounterAndUserName().getString(1).replace("^", "#").split("#");
				strCounterName = strTemp[0].toUpperCase();
				strUserName = strTemp[1].toUpperCase();
			}
		} 
		catch (Exception e)
		{
			throw e;
		}

		
		contents3 = "\n \n "+ hisutil.appendSpace(strUserName + " (" + strCounterName + ")", 79, 1);
		contents3 += "\n";
		printLine++;
		contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
		contents3 += "\n";
		printLine++;

		if (F1.trim().length() > 0)
		{
			contents3 += hisutil.appendSpace(F1,94, 0);
			//"\n                    " + ;
			printLine++;
		}
		if (disclaimer.trim().length() > 0)
		{
			contents3 += "\n                    " + disclaimer;
			printLine++;
		}

		
		return contents3;
	}

	/**
	 * OPD_REFUND(vo) -- > This Method is Used to get Print Type in OPD-REFUND
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_REFUND(String strBillNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request , int isDuplicateBill,String printCopyType) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null, ws2 = null;

		StringBuffer contents = new StringBuffer("");

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String patient_name[] = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String dept = null;
		String ward = null;
		String approvalDtl = null;
		String serv_type=null;
		String paymentdtls = "";
		String PaymentModeName="";
		String paymentMode="";
		float exp_amt_ser = 0;
		float exp_net_amt = 0;
		
		
		String[] tariff_name_ser = null;
		String[] billed_qty_ser = null;
		String[] S_Tax_ser = null;
		String[] net_bill_amt_ser = null;
		String[] dis_amt_ser = null;
		
		String BillType="";
		 BillConfigUtil billConfigUtil = null;
		
		boolean content = false;

		try 
		{			
			billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) //RECEIPT
			{
				contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"OPD  REFUND" , request,isDuplicateBill));
			} 
			else //BILL CUM RECEIPT
			{
				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrHospCode(strHospitalCode);

				if(billConfigUtil.getGeneralRefundReceiptType().equals("2"))//REVISED
				{
					boObj.OPD_REFUND_WITH_OLD_DTLS(voObj);
				}
				else//REFUND
				{
					boObj.OPD_REFUND(voObj);
				}				
				
				ws = voObj.getStrOpdRefund();
				ws1 = voObj.getStrOpdRefund1();
				

				int length = ws1.size();

				String[] tariff_name = new String[length];
				String[] billed_qty = new String[length];
				String[] S_Tax = new String[length];
				String[] net_bill_amt = new String[length];
				String[] dis_amt = new String[length];
				
				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();
				
				if(billConfigUtil.getGeneralRefundReceiptType().equals("2"))//REVISED
				{
					ws2 = voObj.getGblWs2(); 
					int length_ser = ws2.size();
					tariff_name_ser = new String[length_ser];
					billed_qty_ser = new String[length_ser];
					S_Tax_ser = new String[length_ser];
					net_bill_amt_ser = new String[length_ser];
					dis_amt_ser = new String[length_ser];
				}			
				
				for (int k = 0; ws.next(); k++) 
				{
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
					clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
					strHidden = ws.getString(9);
					serv_type=ws.getString(10);
					dept = ws.getString(11);
					ward = ws.getString(12);
					approvalDtl = ws.getString(13);
					paymentdtls = ws.getString(14).equals("") ? "---" : ws.getString(14);
					/*
					 * if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
					 * 
					 * paymentMode=paymentdtls.split("/")[1];
					 * PaymentModeName=paymentdtls.split("/")[2];
					 * paymentdtls=paymentdtls.split("/")[0];
					 * 
					 * }
					 */
					PaymentModeName=ws.getString(15);
					
					BillType=ws.getString(16);

					double cltamt = Double.parseDouble(clt_net_amt);

					for (int n = 0; ws1.next(); n++) 
					{
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
					}
					
					if(brt.getGeneralRefundReceiptType().equals("2"))//REVISED
					for (int n = 0; ws2.next(); n++) 
					{
						tariff_name_ser[n] = ws2.getString(1);
						billed_qty_ser[n] = ws2.getString(2);
						dis_amt_ser[n] = HisUtil.getAmountWithDecimal(ws2.getString(3), 2);
						S_Tax_ser[n] = HisUtil.getAmountWithDecimal(ws2.getString(4), 2);
						net_bill_amt_ser[n] = HisUtil.getAmountWithDecimal(ws2.getString(5), 2);
					}
					
					
					/*Contents Adjusted for 94 Characters---Commented For NIMS
					contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n\n");
					contents.append("                                     REFUND RECEIPT                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;*/
					
					if(brt.getGeneralRefundReceiptType().equals("2"))//REVISED
					{
						contents.append(hisutil.appendSpace("REVISED RECEIPT", 50, 1)+hisutil.appendSpace("", 44, 0));
					}
					else//REFUND
					{
						contents.append(hisutil.appendSpace("REFUND RECEIPT", 50, 1)+hisutil.appendSpace("", 44, 0));
					}					
					contents.append("\n\n");
					printLine++;
					printLine++;

					if (isDuplicateBill == 1)
					{
						contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
						contents.append("\n\n");
						printLine++;
						printLine++;
					}

					contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
					contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
					printLine++;

					contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
					
					contents.append("\n");
					printLine++;
					printLine++;
					
										
					contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
					contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 20, "~").get(0).toUpperCase(), 20, 0));					contents.append("\n");
					printLine++;
					printLine++;

					//contents.append(MakeClientDtlStr(strHidden));
					//contents.append(hisutil.appendSpace("ORG./SERV.", 10, 0)+ ": "+ hisutil.appendSpace("---", 85, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					if (isServiceDiscountReq == 0)
					{
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 15,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15,	0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					} 
					else
					{
						contents.append("-----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;

						
						contents.append(hisutil.appendSpace("S.No.", 5,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 35,	0));
						contents.append(hisutil.appendSpace("LOCATION", 8,	0));
						contents.append(hisutil.appendSpace(" RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("     DISC.", 10,0));
						contents.append(hisutil.appendSpace("     S.TAX", 10,0));
						contents.append(hisutil.appendSpace("    AMT(Rs.)", 10,	0));
						contents.append("\n");
						printLine++;

						contents.append("-------------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					}
					
					int tariffLen = 35;
					String strRate = "0";
					//String strRateUnit = ""; 

					if(isServiceDiscountReq == 0)
					{						
						tariffLen = 40;
					}
						
					
					if(brt.getGeneralRefundReceiptType().equals("2"))//REVISED BILL
					{
							for (int i = 0; i < tariff_name_ser.length; i++)		
							{		
								List<String> Tname = null;								
								if(isServiceDiscountReq == 0)
								{
									String strTemp[] =  tariff_name_ser[i].replace("@", "#").split("#");									
									strRate = strTemp[1].replace("/", "#").split("#")[0];									
								//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];									
									Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "-");									
								}
								else
								{
									//Tname = hisutil.breakString(tariff_name_ser[i].toUpperCase(), tariffLen, "-");
									String strTemp[] =  tariff_name_ser[i].replace("@", "#").split("#");
									strRate = strTemp[1].replace("/", "#").split("#")[0];
								//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
									Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "-");
								}		
								for (int j = 0; j < Tname.size(); j++) 
								{
									if (j == 0) 
									{
										if (isServiceDiscountReq == 0)
										{											
											contents.append(hisutil.appendSpace(Integer.toString(i+1), 5,0));
											contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase(), 40,0));
											contents.append(hisutil.appendSpace("---", 15,0));
											contents.append(hisutil.appendSpace(strRate, 10,0));
											contents.append(hisutil.appendSpace(" "+billed_qty_ser[i].replace(" ", "#").split("#")[0], 8,	0));
											contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt_ser[i], 2),8, 1)+hisutil.appendSpace("", 7,	0));
											contents.append("\n");
											printLine++;
										} 
										else
										{
											contents.append(hisutil.appendSpace(Integer.toString(i+1), 5,	0));
											contents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 35,	0));
											contents.append(hisutil.appendSpace("---", 8,	0));
											contents.append(hisutil.appendSpace(strRate, 10,0));
											contents.append(hisutil.appendSpace(" "+billed_qty_ser[i], 6, 0));
											contents.append(hisutil.appendSpace(dis_amt_ser[i], 10, 1));
											contents.append(hisutil.appendSpace(S_Tax_ser[i], 10, 1));	
											contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt_ser[i], 2),10, 1));
											contents.append("\n");
											printLine++;
										}
									}
								}
								exp_amt_ser = exp_amt_ser + Float.parseFloat(net_bill_amt_ser[i]);								
							}							
							
					
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",75, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(String.valueOf(exp_amt_ser),2), 19, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						
						contents.append("\n");
						printLine++;
						contents .append(hisutil.appendSpace("REFUND ", 94,0));
						contents.append("\n");
						printLine++;
						contents .append(hisutil.appendSpace("-------", 94,0));
						contents.append("\n");
						printLine++;
					}					
				 
					for (int i = 0; i < tariff_name.length; i++)
					{
						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0)
						{
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");							
							strRate = strTemp[1].replace("/", "#").split("#")[0];							
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];							
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");							
						}
						else
						{
							//Tname = hisutil.breakString(tariff_name[i].toUpperCase(), tariffLen, "~");
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							strRate = strTemp[1].replace("/", "#").split("#")[0];
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");
						}						

						for (int j = 0; j < Tname.size(); j++) 
						{
							if (j == 0) 
							{
								if (isServiceDiscountReq == 0)
								{											
									contents.append(hisutil.appendSpace(Integer.toString(i+1), 5,0));
									contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase(), 40,0));
									contents.append(hisutil.appendSpace("---", 15,0));
									contents.append(hisutil.appendSpace(strRate, 10,0));
									contents.append(hisutil.appendSpace(" "+billed_qty[i].replace(" ", "#").split("#")[0], 8,	0));
									contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i], 2),8, 1)+hisutil.appendSpace("", 7,	0));
									contents.append("\n");
									printLine++;
								} 
								else
								{
									contents.append(hisutil.appendSpace(Integer.toString(i+1), 5,	0));
									contents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 35,	0));
									contents.append(hisutil.appendSpace("---", 8,	0));
									contents.append(hisutil.appendSpace(strRate, 10,0));
									contents.append(hisutil.appendSpace(" "+billed_qty[i], 6, 0));
									contents.append(hisutil.appendSpace(dis_amt[i], 10, 1));
									contents.append(hisutil.appendSpace(S_Tax[i], 10, 1));	
									contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i], 2),10, 1));
									contents.append("\n");
									printLine++;
								}								
							}
						}						
					}					
					if(brt.getGeneralRefundReceiptType().equals("2"))
					{					
						exp_net_amt =  exp_amt_ser + Float.parseFloat(exp_amt);						
					}					
					if (cltamt > 0) 
					{
						contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(exp_amt, 2), 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;						
					} 
					else 
					{
						contents.append("\n");
						printLine++;

						if(brt.getGeneralRefundReceiptType().equals("2"))
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("PENALTY AMT ",85, 1)+ hisutil.appendSpace(String.valueOf(exp_net_amt), 9, 1));
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("REFUND AMT ",85, 1)+ hisutil.appendSpace(exp_amt, 9, 1));
							contents.append("\n");
							printLine++;
							
							//contents.append(hisutil.appendSpace("NET AMOUNT PAID ",85, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(String.valueOf(exp_net_amt),2), 9, 1));
							//contents.append("\n");
							//printLine++;
							exp_amt = String.valueOf(exp_amt);
						}
						else
						{
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("TOTAL AMOUNT ",75, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(String.valueOf(exp_amt),2), 15, 1));
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;							
						}						
						
						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(exp_amt),94, 0));
						contents.append("\n\n");
						printLine++;
						printLine++;
						
						
						contents.append(hisutil.appendSpace("ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; REASON: "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase(),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("REQUESTED BY/DATE&TIME    : "+approvalDtl.replace("^", "#").split("#")[5].toUpperCase()+"/"+approvalDtl.replace("^", "#").split("#")[6],94,0));
						contents.append("\n");
						
						contents.append(hisutil.appendSpace("APPROVED BY/DATE&TIME     : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase()+"/"+approvalDtl.replace("^", "#").split("#")[0],94,0));
						contents.append("\n");
						printLine++;
						
						contents .append("\n");
						printLine++;							
								
					}

					contents.append(hisutil.appendSpace("NOTE : ALL RATES,AMOUNT ARE IN Rs.",94, 0));
					contents.append("\n\n");
					printLine++;
					printLine++;
					
					/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
					contents.append("\n");
					printLine++;*/
					/*switch (paymentMode) {
			        case "1":
			            PaymentModeName = "Cash";
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "2":
			            PaymentModeName = "Cheque";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "3":
			            PaymentModeName = "Demand Draft";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "4":
			            PaymentModeName = "Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "5":
			            PaymentModeName = "Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "6":
			            PaymentModeName = "Client";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "7":
			            PaymentModeName = "Patient Wallet";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					 case "8":
						PaymentModeName = "International Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "9":
						PaymentModeName = "International Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			           break;
					case "10":
						PaymentModeName = "Cm Relief Fund";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "11":
						PaymentModeName = "Virtual Account";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "12":
						PaymentModeName = "Prisoner";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "13":
						PaymentModeName = "Jan Arogya";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        default:
			            PaymentModeName = "Cash";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        }
					*///PaymentModeName
					
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("SIGNATURE OF THE PATIENT/ATTENDANT",94, 1));
					contents.append("\n");
					printLine++;
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("   (PATIENT/ATTENDANT NAME)",94, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("ID PROOF:.................................................  MOBILE NO........................",94, 1));
					contents.append("\n");
					printLine++;
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("ID PROOF TYPE(TICK): AADHAR CARD/VOTER ID/RATION CARD/DRIVING LICENSE/GOVT. ISSUE ID/OTHERS  ",94, 1));
					contents.append("\n");
					printLine++;
					
					String strDisclaimer = "";
					if(strBillNo.startsWith("5"))
					{
						strDisclaimer = brt.getBillDisclaimerWithoutCrNo();
						contents.append( Footer(Footer , request , strDisclaimer));
					}
					else
					{
								strDisclaimer = brt.getBillDisclaimerRefund();
								contents .append( Footer(Footer , request , strDisclaimer ));
					}
				}
			}
			content = PrintContents(strBServiceId, "2", contents.toString() , request);
			System.out.println("Opd Refund------->" + contents.toString());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPDREFUND() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * OPD_RECONCILIATION(vo) -- > This Method is Used to get Print Type in
	 * OPD-RECONCILIATION Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_RECONCILIATION(String strBillNo,
			String strReceiptNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String serv_type="";
		
		String BillType="";
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"OPD  RECONCIALTION" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.OPD_RECONCILIATION(voObj);
				ws = voObj.getStrOpdReconcil();
				ws1 = voObj.getStrOpdReconcil1();
				
				int len = ws1.size();
				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				for (int k = 0; ws.next(); k++) {
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					strHidden = ws.getString(9);
					serv_type=ws.getString(10);
					BillType=ws.getString(14);
					
					double cltamt = Double.parseDouble(clt_net_amt);

					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);

					}

					contents += Header(Header1, Header2, Header3, Header4)
							+ "                         OPD  RECONCIALTION \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate) \n";
						printLine++;
					}

					contents += "\n";
					printLine++;

					contents +=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;

					contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
					 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
					+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
					+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1], 13,0) +"\n";
					printLine++;
					
					contents +=  hisutil.appendSpace(" Service", 9,0)     +": "+hisutil.appendSpace(serv_type, 57,0) +"\n";
					printLine++;
					
					contents += MakeClientDtlStr(strHidden);

					if(isServiceDiscountReq == 0){
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
								 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
								 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
						
						
					}else{
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 26,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
					
						
					}
					
					
					int tariffLen = 22;
					String strRate = "0";

					if(isServiceDiscountReq == 0){
						
						tariffLen = 30;
					}
						
				 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							Tname = hisutil.breakString(
									strTemp[0], tariffLen, "~");
							
							strRate = strTemp[1];
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i], tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								contents += "\n";
								printLine++;
								contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
									+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
												+ hisutil.appendSpace(strRate, 11,1)
												+ hisutil.appendSpace(billed_qty[i], 9,1);
										 										
								}else{
											
									   contents += hisutil.appendSpace("  "+Tname.get(j), 25,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}
									
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
										contents += "\n";
								printLine++;
							} else {
							
								printLine++;
								contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
								contents += "\n";
							}
						}
					}


					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					if (cltamt > 0) {
						contents +=hisutil.appendSpace("Expense Amt   : ", 57,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("Paid by Third Party   : ", 58,1)+hisutil.appendSpace(clt_net_amt, 12,1)+ "\n";
						printLine++;
						
						if(Double.parseDouble(pat_net_amt) >= 0){
						
							contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
								
						}else{
							
							contents +=hisutil.appendSpace("Paid to Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						}
						printLine++;
						
						
						
					} else {
						contents +=hisutil.appendSpace("Expense Amt   : ", 57,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
					 
						if(Double.parseDouble(pat_net_amt) >= 0){
							
							contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
								
						}else{
							
							contents +=hisutil.appendSpace("Paid to Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						}
						printLine++;
						

					}

					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					contents += "    Rs. in Word : "
							+ hisutil.getAmountStr(pat_net_amt);

				//	contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;

								
					contents += Footer(Footer , request , "");

				}

			}
			content = PrintContents(strBServiceId, "3", contents , request);
			System.out.println("Opd Reconciliation------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.OPD_RECONCILIATION() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * OPD_SERVICES_DUP(vo) -- > This Method is Used to get Print Type in
	 * OPD_SERVICES_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_SERVICES_DUP(String strBillNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;
		Map tariffPrintMap=null;
		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String dept = null;
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try 
			{				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents = receiptPrint(strHospitalCode, "0", strBillNo, billConfigUtil
							.getGeneralDuplicatePrint(), "OPD SERVICES" , request,isDuplicateBill);	
				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");
	
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);

	
					boObj.OPD_SERVICES_DUP(voObj);
					ws = voObj.getGblWs1();//Bill Details
					ws1 = voObj.getGblWs2();//Tariff Details
				
					int len = ws1.size();
					String[] tariff_name = new String[len];
					String[] billed_qty = new String[len];
					String[] S_Tax = new String[len];
					String[] net_bill_amt = new String[len];
					String[] dis_amt = new String[len];
	
					BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
	
					String Header1 = brt.getBillFormatHeader1();
					String Header2 = brt.getBillFormatHeader2();
					String Header3 = brt.getBillFormatHeader3();
					String Header4 = brt.getBillFormatHeader4();
					String Footer = brt.getBillFormatFooter();
					
					
					for (int k = 0; ws.next(); k++) 
					{	
						bill_no = ws.getString(1);
						bill_date = ws.getString(2);
						patient_name = ws.getString(3).replace("^", "#").split("#");
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
						clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
						strHidden = ws.getString(9);
						dept = ws.getString(11);
						double cltamt = Double.parseDouble(clt_net_amt);
						
						
						
						if(tariffPrintMap==null)
							tariffPrintMap=new LinkedHashMap(0);
						
						String[] strArrayTariffList=new String[ws1.size()];
						
						for (int n = 0; ws1.next(); n++) 
						{
							///crating group wise tariff map for online cash collection as Map passed is null								
					
							 String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
															HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
								 
							strArrayTariffList[n]=strDirectTariffList+"#"+ws1.getString(6)+"#"+ ws1.getString(7);								 
							
						}
						tariffPrintMap=populateGroupMapForPrinting(strArrayTariffList,tariffPrintMap,brt);
							
	
						/*contents += Header(Header1, Header2, Header3, Header4)
						//+ "                            OPD SERVICES      \n";
						//+ "                                CASH RECEIPT      \n";
								+hisutil.appendSpace("CASH RECEIPT", 94,1)+"\n";
						printLine++;*/
						contents+=hisutil.appendSpace("OPD SERVICES", 54, 1)+hisutil.appendSpace("", 40, 0)+"\n";
	
					if (isDuplicateBill == 1) 
					{
						contents+=hisutil.appendSpace("(Duplicate)", 40, 1)+hisutil.appendSpace("", 54, 0)+"\n";
						//contents += hisutil.appendSpace("(Duplicate)", 94,1)+"\n";//"                              (Duplicate)    \n";
						printLine++;
					}	
					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 94,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 80,0)+"\n";
					//contents +=  hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(dept.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "-").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 38,0) +"\n";
					printLine++;
				 					 
			 
				//contents += MakeClientDtlStr(strHidden);
	
				if(isServiceDiscountReq == 0)
				{				
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;
					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
					printLine++;
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
				}
				else
				{				
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
					contents+=hisutil.appendSpace("S.No.", 7,	0)+hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0)+
							hisutil.appendSpace("LOCATION", 11,	0)+hisutil.appendSpace("RATE(Rs.)", 10,0)+hisutil.appendSpace("QTY.", 6,	0)+
							hisutil.appendSpace("DISC.(Rs.)", 10,0)+hisutil.appendSpace("AMOUNT(Rs)", 10,	0)+"\n";
					printLine++;
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;				
				}			
				
				int tariffLen = 32;
				String strRate = "0";
				//String strRateUnit = ""; 
	
				if(isServiceDiscountReq == 0)
				{				
					tariffLen = 45;
				}				
				
				///iterating printMap for printing tariff based on group
				StringBuffer contentBfr=new StringBuffer(contents);
				iterateMapForPrinting(tariffPrintMap, contentBfr,brt);
				contents=contentBfr.toString();
				
				
					contents += "\n";
					printLine++;
				  
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 82,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
					printLine++;
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
	
					/*
					 * contents +=
					 * "----------------------------------------------------------------------------------------------\n";
					 * printLine++; printLine++;
					 */
						if(brt.getBillDisclaimerDuplicatePrintRequired().equals("1"))
						{				
							contents += Footer(Footer , request , brt.getBillDisclaimerServices() );						
						}
						else
						{						
							contents += Footer(Footer , request , "");						
						}				
				}
			}
			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Opd Services Duplicate------->" + contents);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES_DUP() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * OPD_SERVICES(vo) -- > This Method is Used to get Print Type in
	 * OPD_SERVICES Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_SERVICES(String strBillNo, String strBServiceId,String strHospitalCode, 
										String strReceiptNo , HttpServletRequest request , 
										Map tariffPrintMap , String strIsDirectMode,
										int isDuplicateBill,
										String isCreditBill,
										String printCopyType 
										) throws Exception 
	{
		
        System.out.println("------billing.OPD_SERVICES.findPrintType------");		
		System.out.println("strBServiceId------>"+strBServiceId);
		System.out.println("strBillNo------>"+strBillNo);
		System.out.println("strBServiceId------>"+strBServiceId);
		System.out.println("strHospitalCode------>"+strHospitalCode);
		System.out.println("isDuplicateBill------>"+isDuplicateBill);
		System.out.println("isDuplicateBill------>"+isDuplicateBill);
		System.out.println("------------------------------------------");

		if (strBillNo == null && strBillNo.length() != 10)
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2)
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3)
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		
		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null, ws1 = null;
		StringBuffer contents = new StringBuffer("");
		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String dept = null;
		String strHospDtl = null;
		BillConfigUtil billConfigUtil = null;
		String strIsCreditCat="0"; //0 no 1 yes credit category..
		String strClientName="---"; 
		//Map clNoPrintMap=null;
		String patTotAmt="0.00";
		String clientTotAmt="0.00";
		String tempStr="";
		String serv_type="";
		String creditno="---";
		String paymentdtls="";
		String argtscat="0"; //0 no 1 yes category..
		String staffcat="0";
		String PaymentModeName="";
		String paymentMode="";
		String paymentmode = "0";

		String BillType="";
		String Mobile="";
		boolean content = false;
		double concessionAmt=0.00;

		try
		{
			billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
			{
				contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
			} else{
				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				
				//strIsDirectMode=1 Cash Collecton Offline
				//strIsDirectMode=0 Cash Collecton Online
				if (strIsDirectMode == "1")
				{
					boObj.OPD_SERVICES_DIRECT(voObj);
				}else{
					boObj.OPD_SERVICES(voObj);
				}

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				/*String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();*/
				String Footer = brt.getBillFormatFooter();
				
		
				
				if (strIsDirectMode == "1")
				{
					ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
				} 
				else
				{
					ws = voObj.getGblWs1();
					ws1 = voObj.getGblWs2();//fields related to credit category are received..
				}

				for (int k = 0; ws.next(); k++)
				{
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
					clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
					strHidden = ws.getString(9);
					serv_type=ws.getString(10);
					dept = ws.getString(11);
					strHospDtl=ws.getString(14);
					strIsCreditCat=ws.getString(15);//1 yes its credit cat..
					strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
					creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
					paymentdtls=ws.getString(18);//.equals("")?"---":ws.getString(18);
					argtscat=ws.getString(19);//1 yes its cat..
					staffcat=ws.getString(21);
					paymentmode = ws.getString(22);

					double cltamt = Double.parseDouble(clt_net_amt);
					
					//BillType=ws.getString(23);
					//Mobile=ws.getString(24);
					/*if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
						paymentMode=paymentdtls.split("/")[1];
						PaymentModeName=paymentdtls.split("/")[2];
						paymentdtls=paymentdtls.split("/")[0];

						}*/

					/*Contents Adjusted for 94 Characters---Commented For NIMS
					contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
					contents.append("                                     CASH RECEIPT                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;*/

					if (isDuplicateBill == 1)
					{
						contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
						contents.append("\n");
						printLine++;
						printLine++;
					}
						contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
						printLine++;

					contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
					contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
					contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
					
					contents.append("\n");
					printLine++;
					printLine++;
					
										
					contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
					contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
					//contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
					contents.append("\n");
					printLine++;
					printLine++;

					//contents.append(MakeClientDtlStr(strHidden));
					contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type.toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					if(strIsCreditCat.equalsIgnoreCase("1"))
					{
						if (strIsDirectMode == "1")//offline..
						{
							patTotAmt=pat_net_amt;
							clientTotAmt=clt_net_amt;
						} 
						else
						{
							if (tariffPrintMap == null)
								tariffPrintMap = new LinkedHashMap();

							int len = ws1.size();
							String[] strArrayTariffList = new String[len];
							
							for (int n = 0; ws1.next(); n++)
							{
								// /crating group wise tariff map for online cash
								// collection as Map passed is null
//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
								
								/*
								 * String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+
								 * HisUtil.getAmountWithDecimal(ws1.getString(3), 2) + "^"+
								 * HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+
								 * HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+
								 * "^"+ ws1.getString(9);
								 * 
								 * strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" +
								 * ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
								 * patTotAmt=ws1.getString(13); clientTotAmt=ws1.getString(14);
								 */
							}
							tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						}


						if (isServiceDiscountReq == 0)
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("S.No.", 5,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 29,	0));
							contents.append(hisutil.appendSpace("LOCATION", 10,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("QTY.", 8,	0));
							contents.append(hisutil.appendSpace("AMT(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("PAT. SHARE", 12,	0));
							contents.append(hisutil.appendSpace("CLT. SHARE", 10,	0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						} 
						else
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("S.No.", 5,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 29,	0));
							contents.append(hisutil.appendSpace("LOCATION", 10,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
							contents.append(hisutil.appendSpace("QTY.", 6,	0));
							contents.append(hisutil.appendSpace("DISC.", 6,0));
							//contents.append(hisutil.appendSpace("S.TAX", 6,0));
							contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
							contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
							contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
							contents.append("\n");
							printLine++;

							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						}
						

						// /iterating printMap for printing tariff based on group and Credit Letter No
						iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
						

						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
						contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(patTotAmt,8,0));
						contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
						//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append("\n");
						printLine++;
						printLine++;

						double totamt=Double.parseDouble(patTotAmt)+Double.parseDouble(clientTotAmt);
						String total = String.valueOf(totamt);
						
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(patTotAmt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt).toUpperCase(),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt).toUpperCase(),94,0));
						contents.append("\n");
						printLine++;
						printLine++;						
					}
					else
					{
						//ITS NON CREDIT BILLING
						if (strIsDirectMode == "1")//offline..
						{
						} 
						else
						{
							if (tariffPrintMap == null)
 								tariffPrintMap = new LinkedHashMap();

							int len = ws1.size();
							System.out.println("-----len-ws1.size()--"+ws1.size());
							String[] strArrayTariffList = new String[len];
							for (int n = 0; ws1.next(); n++)
							{
								// /crating group wise tariff map for online cash
								// collection as Map passed is null

								String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
										+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
								
								strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

							}
							tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						}
						
						if (isServiceDiscountReq == 0)
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("S.No.", 6,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE NAME", 40,	0));
							contents.append(hisutil.appendSpace("LOCATION", 15,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("QTY.", 8,	0));
							contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15,	0));
							contents.append("\n");
							printLine++;

							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						} 
						else
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;

							
							contents.append(hisutil.appendSpace("S.No.", 7,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
							contents.append(hisutil.appendSpace("LOCATION", 11,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
							contents.append(hisutil.appendSpace("QTY.", 6,	0));
							contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
							//contents.append(hisutil.appendSpace("S.TAX", 10,0));
							contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
							contents.append("\n");
							printLine++;

							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						}

						// /iterating printMap for printing tariff based on group

						concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

						if (cltamt > 0)
						{
							contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
							printLine++;
							contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
							printLine++;
							contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
							printLine++;
						} 
						else
						{
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;
							//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
							contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;
						}

						contents.append("\n");
						printLine++;

						//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						if(!staffcat.equals("1"))
							contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						else
							contents.append(hisutil.appendSpace("TOTAL CHARGES ",74, 1)+ hisutil.appendSpace(Double.toString(Math.abs(concessionAmt)), 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("EXEMPTION/CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
						contents.append("\n");
						printLine++;
						//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						
					}					
				}
				contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
				contents.append("\n");
				printLine++;*/
				
			/*	switch (paymentMode) {
		        case "1":
		            PaymentModeName = "Cash";
					
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "2":
		            PaymentModeName = "Cheque";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "3":
		            PaymentModeName = "Demand Draft";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "4":
		            PaymentModeName = "Credit Card";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "5":
		            PaymentModeName = "Debit Card";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "6":
		            PaymentModeName = "Client";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        case "7":
		            PaymentModeName = "Patient Wallet";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
				 case "8":
					PaymentModeName = "International Credit Card";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
				case "9":
					PaymentModeName = "International Debit Card";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		           break;
				case "10":
					PaymentModeName = "Cm Relief Fund";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
				case "11":
					PaymentModeName = "Virtual Account";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
				case "12":
					PaymentModeName = "Prisoner";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
				case "13":
					PaymentModeName = "Jan Arogya";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        default:
		            PaymentModeName = "Cash";
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
										contents.append("\n");
										printLine++;
		            break;
		        }*/
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+paymentmode,94, 0));
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
				contents.append("\n");
				printLine++;
				
				/*contents.append(hisutil.appendSpace("(U): URGENT TARIFF SURCHARGE("+billConfigUtil.getStrUrgTrfSur()+"% EXTRA CHARGES)",94, 0));
				contents.append("\n");
				printLine++;*/
				
				if(argtscat.equals("1") && Double.parseDouble(clientTotAmt)>0.00)
				{
					if(Double.parseDouble(patTotAmt)==0.00)
					{
						contents.append("<b>");
						contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED - CASHLESS SCHEME",94, 0));
						contents.append("</b>");
						contents.append("\n");
						printLine++;
					}
					if(Double.parseDouble(patTotAmt)>0.00)
					{
						contents.append("<b>");
						contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED (LIMIT- Rs."+clientTotAmt+") - CASHLESS SCHEME",94, 0));
						contents.append("</b>");
						contents.append("\n");
						printLine++;
					}
				}

				if (strBillNo.startsWith("5"))
				{
					contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
				} 
				else
				{
					contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
				}
			}

			strIsDirectMode = "0";
			
			content = PrintContents(strBServiceId, "1", contents.toString(),request);
			System.out.println("Opd Services------->" + contents.toString());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
		} 
		finally
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean OPD_SERVICES_backup(String strBillNo, String strBServiceId,String strHospitalCode, 
			String strReceiptNo , HttpServletRequest request , 
			Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill ) throws Exception 
{

if (strBillNo == null && strBillNo.length() != 10)
{
throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
}
if (strBServiceId == null && strBServiceId.length() != 2)
{
throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
}
if (strHospitalCode == null && strHospitalCode.length() != 3)
{
throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
}

PrintVO voObj = null;
PrintBO boObj = null;
HisUtil hisutil = null;
WebRowSet ws = null, ws1 = null;
StringBuffer contents = new StringBuffer("");
String bill_date = null;
String bill_no = null;
String[] patient_name = null;
String patient_category = null;
String Crno = null;
String pat_net_amt = null;
String strHidden = null;
String exp_amt = null;
String clt_net_amt = null;
String dept = null;
String strHospDtl = null;
BillConfigUtil billConfigUtil = null;
String strIsCreditCat="0"; //0 no 1 yes credit category..
Map clNoPrintMap=null;
String patTotAmt="";
String clientTotAmt="";
String tempStr="";

boolean content = false;

try
{
billConfigUtil = new BillConfigUtil(strHospitalCode);
if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
{
contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
} 
else
{
voObj = new PrintVO();
boObj = new PrintBO();
hisutil = new HisUtil("billing", "PrintHLP");

voObj.setStrReceiptNo(strReceiptNo);
voObj.setStrBillNo(strBillNo);
voObj.setStrHospCode(strHospitalCode);

//strIsDirectMode=1 Cash Collecton Offline
//strIsDirectMode=0 Cash Collecton Online
if (strIsDirectMode == "1")
{
boObj.OPD_SERVICES_DIRECT(voObj);
} 
else
{
boObj.OPD_SERVICES(voObj);
}

BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

String Header1 = brt.getBillFormatHeader1();
String Header2 = brt.getBillFormatHeader2();
String Header3 = brt.getBillFormatHeader3();
String Header4 = brt.getBillFormatHeader4();
String Footer = brt.getBillFormatFooter();



if (strIsDirectMode == "1")
{
ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
} 
else
{
ws = voObj.getGblWs1();
ws1 = voObj.getGblWs2();//fields related to credit category are received..
}

for (int k = 0; ws.next(); k++)
{
bill_no = ws.getString(1);
bill_date = ws.getString(2);
patient_name = ws.getString(3).replace("^", "#").split("#");
for(int p=0;p<patient_name.length;p++)
System.out.println("patient name is::"+patient_name[p]);

patient_category = ws.getString(4);
Crno = ws.getString(5);
exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
strHidden = ws.getString(9);
dept = ws.getString(10);
strHospDtl=ws.getString(13);
strIsCreditCat=ws.getString(14);//1 yes its credit cat..

double cltamt = Double.parseDouble(clt_net_amt);

if(strIsCreditCat.equalsIgnoreCase("1"))
{
//its credit billing,format is different..
if (strIsDirectMode == "1")//offline..
{
} 
else
{
if (tariffPrintMap == null)
	tariffPrintMap = new LinkedHashMap();

int len = ws1.size();
String[] strArrayTariffList = new String[len];
System.out.println("ws1 size is::"+ws1.size());
for (int n = 0; ws1.next(); n++)
{
	// /crating group wise tariff map for online cash
	// collection as Map passed is null
//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
	String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
			+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
	
	strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
	patTotAmt=ws1.getString(13);
	clientTotAmt=ws1.getString(14);
}
tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
}

//contents.append(Header(Header1, Header2, Header3, Header4);
//Contents Adjusted for 87 Characters
contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
contents.append("                                     CASH RECEIPT                                      \n");
printLine++;
contents.append("---------------------------------------------------------------------------------------\n");
printLine++;

if (isDuplicateBill == 1)
{
contents.append("                              (Duplicate)                                             \n");
printLine++;
}

contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 87, 1)+ "\n \n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
	+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 62, 0)+ "\n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
	+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
printLine++;

//contents.append(MakeClientDtlStr(strHidden));

if (isServiceDiscountReq == 0)
{
contents.append("---------------------------------------------------------------------------------------\n");
printLine++;

contents.append(hisutil.appendSpace(" DESCRIPTION", 28,	0)+ hisutil.appendSpace("  RATE", 12, 0)
				+ hisutil.appendSpace(" QTY.", 5, 0)+ hisutil.appendSpace("  AMOUNT", 15, 0)+hisutil.appendSpace("PATIENT SHARE", 15, 0)+hisutil.appendSpace("CLIENT SHARE", 12, 0)+ "\n");
printLine++; 

contents.append("---------------------------------------------------------------------------------------\n");
printLine++;
} 
else
{
contents.append("---------------------------------------------------------------------------------------\n");
printLine++;

contents.append(hisutil.appendSpace(" S.No.", 6, 0)
		+ hisutil.appendSpace(" Description", 36, 0)
		+ hisutil.appendSpace(" Qty.", 9, 0)
		+ hisutil.appendSpace(" Disc.", 11, 0)
		+ hisutil.appendSpace(" S.Tax", 10, 0)
		+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
		+ "\n");
printLine++;

contents.append("---------------------------------------------------------------------------------------\n");
printLine++;
}

// /iterating printMap for printing tariff based on group and Credit Letter No
iterateCreditMapForPrinting(tariffPrintMap, contents, brt);



contents.append("                                           -------         -------      ------  \n");
printLine++;
contents.append("                                    TOTAL  "          +exp_amt+"          "+patTotAmt+"          "+clientTotAmt+"\n");
//contents.append(hisutil.appendSpace("TOTAL  ",27, 1)+ hisutil.appendSpace(exp_amt, 7, 0) + "\n");
printLine++;
contents.append("                                           -------         -------      ------  \n");
printLine++;
contents.append("\n");
printLine++;


contents.append(hisutil.appendSpace(" AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),87,0));
contents.append("\n");
printLine++;

contents.append(hisutil.appendSpace(" AMOUNT PAID BY CLIENT (IN WORD) : "+ hisutil.getAmountStr(clientTotAmt),87,0));
contents.append("\n");
printLine++;

contents.append(hisutil.appendSpace(" Note : Amount,Patient Share and Client Share are in Rs.",87,0));

contents.append("\n");
printLine++;

if (strBillNo.startsWith("5"))
{
contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
} 
else
{
contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
}
}
else
{
//ITS NON CREDIT BILLING
if (strIsDirectMode == "1")//offline..
{
} 
else
{
if (tariffPrintMap == null)
	tariffPrintMap = new LinkedHashMap();

int len = ws1.size();
String[] strArrayTariffList = new String[len];
for (int n = 0; ws1.next(); n++)
{
	// /crating group wise tariff map for online cash
	// collection as Map passed is null

	String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
			+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
	
	strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

}
tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
}

//contents.append(Header(Header1, Header2, Header3, Header4);
contents.append("                    "+ hisutil.appendSpace(strHospDtl, 59,0)+"\n");
contents.append("                                  CASH RECEIPT                                  \n");
printLine++;
contents.append("--------------------------------------------------------------------------------\n");
printLine++;

if (isDuplicateBill == 1)
{
contents.append("                             (Duplicate)    \n");
printLine++;
}

contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 79, 1)+ "\n \n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
	+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 62, 0)+ "\n");
printLine++;
printLine++;

contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
	+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
printLine++;

//contents.append(MakeClientDtlStr(strHidden));

if (isServiceDiscountReq == 0)
{
contents.append("--------------------------------------------------------------------------------\n");
printLine++;

contents.append(hisutil.appendSpace(" DESCRIPTION", 50,	0)+ hisutil.appendSpace("  RATE(Rs.)", 12, 0)
				+ hisutil.appendSpace(" QTY.", 5, 0)+ hisutil.appendSpace("  AMOUNT(Rs.)", 15, 0)+ "\n");
printLine++;

contents.append("--------------------------------------------------------------------------------\n");
printLine++;
} 
else
{
contents.append("--------------------------------------------------------------------------------\n");
printLine++;

contents.append(hisutil.appendSpace(" S.No.", 6, 0)
		+ hisutil.appendSpace(" Description", 36, 0)
		+ hisutil.appendSpace(" Qty.", 9, 0)
		+ hisutil.appendSpace(" Disc.", 11, 0)
		+ hisutil.appendSpace(" S.Tax", 10, 0)
		+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
		+ "\n");
printLine++;

contents.append("--------------------------------------------------------------------------------\n");
printLine++;
}

// /iterating printMap for printing tariff based on group

iterateMapForPrinting(tariffPrintMap, contents, brt);

if (cltamt > 0)
{
contents.append(hisutil.appendSpace("Expense Amt   : ",	67, 1)
		+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
printLine++;
contents.append(hisutil.appendSpace("Paid by Third Party   : ", 68, 1)
		+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
printLine++;
contents.append(hisutil.appendSpace("Paid by Patient   : ", 67, 1)
		+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
printLine++;
} 
else
{
contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
printLine++;
contents.append(hisutil.appendSpace("TOTAL AMOUNT ",67, 1)
		+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
printLine++;
contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
printLine++;
}

contents.append("\n");
printLine++;

//to be uncommented..as of now could not get equivalent of digitword(func which gives word equivalent of number..)
contents.append("RUPEES (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt));

//contents.append("RUPEES (IN WORD) : ");

contents.append("\n");
printLine++;

contents.append("Note : Amount,Patient Share and Client Share are in Rs.");
System.out.println("note added...................");
//contents.append("RUPEES (IN WORD) : ");

contents.append("\n");
printLine++;

if (strBillNo.startsWith("5"))
{
contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
} 
else
{
contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
}
}


}
}

strIsDirectMode = "0";

content = PrintContents(strBServiceId, "1", contents.toString(),request);
System.out.println("Opd Services------->" + contents.toString());
} 
catch (Exception e)
{
e.printStackTrace();
throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
} 
finally
{
voObj = null;
boObj = null;
hisutil = null;
billConfigUtil = null;
}

return content;
}

	/**
	 * IPD_FINAL_SETTLE(vo) -- > This Method is Used to get Print Type in
	 * IPD_FINAL_SETTLE Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_FINAL_SETTLE(String strBillNo,
			String strReceiptNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String adm_no = null;
		String serv_type="";
		
		String BillType="";

		 
		 String Mobile="";
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"IPD FINAL BILL RECONCILIATION" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.IPD_FINAL_SETTLE(voObj);
				ws = voObj.getStrIpdFinalSettle();
				ws1 = voObj.getStrIpdFinalSettle1();
			
				int len = ws1.size();
				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				for (int k = 0; ws.next(); k++) {

					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(9),
							2);
					strHidden = ws.getString(10);
					serv_type=ws.getString(11);

					BillType=ws.getString(15);
					Mobile=ws.getString(16);
					double cltamt = Double.parseDouble(clt_net_amt);

					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);

					}

					contents += Header(Header1, Header2, Header3, Header4)
							+ "                  IPD FINAL BILL RECONCILIATION      \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					
					contents += "\n";
					printLine++;
					
					contents  += hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents+=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;
					contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
					 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
					+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
					+   hisutil.appendSpace(" Admission No.", 18,0)+": "+hisutil.appendSpace(adm_no, 13,0) +"\n";
					printLine++;
					
					contents +=  hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1], 13,0) +"\n";
					printLine++;
					
					contents +=  hisutil.appendSpace(" Service", 9,0)+": "+hisutil.appendSpace(serv_type, 26,0)
					+   hisutil.appendSpace(" Mobile No.", 18,0)+": "+hisutil.appendSpace(Mobile, 13,0)+"\n";
					printLine++;
					
					//contents += MakeClientDtlStr(strHidden);

					if(isServiceDiscountReq == 0){
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
								 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
								 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
					 
					}else{
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 26,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
					 
						
					}
					
					
					int tariffLen = 22;
					String strRate = "0";

					if(isServiceDiscountReq == 0){
						
						tariffLen = 30;
					}
						
				 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							Tname = hisutil.breakString(
									strTemp[0], tariffLen, "~");
							
							strRate = strTemp[1];
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i], tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								contents += "\n";
								printLine++;
								contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
									+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
												+ hisutil.appendSpace(strRate, 11,1)
												+ hisutil.appendSpace(billed_qty[i], 9,1);
										 										
								}else{
											
									   contents += hisutil.appendSpace("  "+Tname.get(j), 25,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}
									
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
										contents += "\n";
								printLine++;
							} else {
							
								printLine++;
								contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
								contents += "\n";
							}
						}
					}

					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					if (cltamt > 0) {
						contents +=hisutil.appendSpace("Expense Amt   : ", 57,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("Paid by Third Party   : ", 58,1)+hisutil.appendSpace(clt_net_amt, 12,1)+ "\n";
						printLine++;
						
						if(Double.parseDouble(pat_net_amt) >= 0){
						
							contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
								
						}else{
							
							contents +=hisutil.appendSpace("Paid to Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						}
						printLine++;
						
						
						
					} else {
						contents +=hisutil.appendSpace("Expense Amt   : ", 57,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
					 
						if(Double.parseDouble(pat_net_amt) >= 0){
							
							contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
								
						}else{
							
							contents +=hisutil.appendSpace("Paid to Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						}
						printLine++;
						

					}

					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					contents += "     Rs. in Word : "
							+ hisutil.getAmountStr(pat_net_amt);

				//	contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;

				 

					contents += Footer(Footer , request , brt.getBillDisclaimerFinalBill());

				}

			}
			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Ipd Final Settlement------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.IPD_FINAL_SETTLE() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * ADVANCE_REFUND(vo) -- > This Method is Used to get Print Type in
	 * ADVANCE_REFUND Case
	 * 
	 * @throws Exception
	 */
	public static boolean ADVANCE_REFUND(String strBillNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		boolean content = false;
		String Desc = "ADVANCE REFUND";

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		String ward = null;
		String approvalDtl = null;
		String serv_type="";
		
		String BillType="";
		 
		 String Mobile="";
		 BillConfigUtil billConfigUtil = null;
			
		
			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"ADVANCE REFUND" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);

				boObj.ADVANCE_REFUND(voObj);

				ws = voObj.getStrAdvanceRefund();

				for (int i = 0; ws.next(); i++) {
					int j = i + 1;

					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					serv_type=ws.getString(8);
					dept = ws.getString(9);
					 ward = ws.getString(10);
					 approvalDtl = ws.getString(11);
					 BillType=ws.getString(13);
					 
					 Mobile=ws.getString(14);
					contents += Header(Header1, Header2, Header3, Header4)
							+ "                   ADVANCE REFUND      \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents+=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;


					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" SERVICE", 12,0)+": "+hisutil.appendSpace(serv_type, 30,0)
					+   hisutil.appendSpace(" Mobile No", 10,0)+": "+hisutil.appendSpace(Mobile, 20,0) +"\n";
					printLine++;
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents += hisutil.appendSpace(Desc, 50,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				  
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);
				contents +="\n";
				contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
				contents +="\n";
				printLine++;
				
				contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
				contents +="\n";
				printLine++;
				
				
				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;
				
					contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

				}

			}
			content = PrintContents(strBServiceId,"2", contents , request);
			System.out.println("Advance Refund------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.ADVANCE_REFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	
	
	/**
	 * ADVANCE_REFUND(vo) -- > This Method is Used to get Print Type in
	 * ADVANCE_REFUND Case
	 * 
	 * @throws Exception
	 */
	public static boolean PARTPAY_REFUND(String strBillNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		boolean content = false;
		String Desc = "ADVANCE REFUND";

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		String ward = null;
		String approvalDtl = null;
		String serviceType="";
		String bService="";
		
		String BillType="";
		 
		 String Mobile="";
		 BillConfigUtil billConfigUtil = null;
			
		
			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"ADVANCE REFUND" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);

				boObj.PARTPAY_REFUND(voObj);

				ws = voObj.getStrAdvanceRefund();

				for (int i = 0; ws.next(); i++) {
					int j = i + 1;

					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					serviceType=ws.getString(8);
					dept = ws.getString(9);
					 ward = ws.getString(10);
					 approvalDtl = ws.getString(11);
					 bService=ws.getString(12);
						
					BillType=ws.getString(13);
					Mobile=ws.getString(14);
					contents += Header(Header1, Header2, Header3, Header4);
							 if(bService.equals("20"))
							 {
								 Desc="PART PAYMENT REFUND";
								 contents += "     PART PAYMENT REFUND      \n";
							 }
							else
								contents += "      ADVANCE REFUND      \n";
					printLine++; 

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents+=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;


					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;

					contents +=  hisutil.appendSpace(" Mobile No", 12,0)     +": "+hisutil.appendSpace(Mobile, 62,0) +"\n";
					printLine++;
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents += hisutil.appendSpace(Desc, 50,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				  
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);
				contents +="\n";
				contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
				contents +="\n";
				printLine++;
				
				contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
				contents +="\n";
				printLine++;
				
				
				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;
				
					contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

				}

			}
			content = PrintContents(strBServiceId,"2", contents , request);
			System.out.println("Part Payment Refund------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.PARTPAY_REFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * ADVANCE(vo) -- > This Method is Used to get Print Type in ADVANCE Case
	 * 
	 * @throws Exception
	 */
	public static boolean ADVANCE(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String isCreditBill,String printCopyType) throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		StringBuffer contents = new StringBuffer();
		boolean content = false;
		String Desc = "IPD ADVANCE";

		String Desc2="ADMISSION CHARGES"; // added by vipul for admission charges
		
		String pat_AdmCharge=null;		//added by vipul on 02.07.2021 as Raebareli need admission charge in slip
		pat_AdmCharge=printCopyType;
		System.out.println(printCopyType);
		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		/*String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();*/
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String dept = null;
		String strIsCreditCat="0";//0 no 1 yes credit category..
		String strAmtPaidByClient="0.00";
		String serv_type=null;
		String strClientName="---"; 
		String creditno="---";
		String paymentdtls="";
		String paymentMode="";
		String creditDtls="";
		String suramt="";
		String totamt="";
		String PaymentModeName="";
		String paymentmode = "0";
		
		String BillType="";
		 
		 String Mobile="";
		 BillConfigUtil billConfigUtil = null;
			
		try 
		{
				billConfigUtil = new BillConfigUtil(strHospitalCode);
				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(), "ADVANCE" , request,isDuplicateBill));
				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");
	
					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
	
					boObj.ADVANCE(voObj);
					ws = voObj.getGblWs1();

				for (int i = 0; ws.next(); i++) 
				{
					int j = i + 1;
					
					strIsCreditCat =  ws.getString(13);//CHECKS CATGRP IF 3,4 THEN RETURNS 1 FROM PROC
					//LOGIC REMOVE OF CLIENT PATIENT FROM IPD ADV AMIT ATERIA 21-07-2016(NO DATA IN CLIENT PATIENT TABLE) BUT CLIENT PAT NO IS AVALABLE
					/*if(ws.getString(8).equals("") || ws.getString(8).equals("0"))//CLIENT DTLS FROM CLIENT PATIENT DTL TABLE OR CLIENT PATIENT NO ONLY					
						strAmtPaidByClient="0.00";
					else
						strAmtPaidByClient = ws.getString(8).replace("^","#").split("#")[3];*/
					
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),	2);//HBLNUM_CLIENT_BALANCE IF HBLNUM_CLIENT_PATIENT_NO IS NOT NULL OR ZERO I.E. CREDIT PATIENT OTHERWISE HBLNUM_PATIENT_TOT_AMT,0,HBLNUM_PATIENT_TOT_AMT 
					strHidden = ws.getString(8);
					serv_type=ws.getString(9);
					dept = ws.getString(10);
					String ward = ws.getString(11);
					strClientName=ws.getString(14).equals("")?"---":ws.getString(14);//1 yes its credit cat..
					creditno=ws.getString(15).equals("0")?"---":ws.getString(15);
					paymentdtls=ws.getString(16);//.equals("")?"---":ws.getString(16);
					creditDtls=ws.getString(17).equals("")?"---":ws.getString(17);
					/*if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
						paymentMode=paymentdtls.split("/")[1];
						PaymentModeName=paymentdtls.split("/")[2];
						paymentdtls=paymentdtls.split("/")[0];

						}*/
					paymentmode = ws.getString(18);
					
					BillType=ws.getString(19);
					Mobile=ws.getString(20);
					//suramt=HisUtil.getAmountWithDecimal(ws.getString(17).replace("^", "#").split("#")[1],	2);
					
					/*Contents Adjusted for 94 Characters---Commented For NIMS
					contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
					contents.append("                                     IPD ADVANCE RECEIPT                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;*/

					if (isDuplicateBill == 1) 
					{
						contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0).toUpperCase());
						contents.append("\n");
						printLine++;
						printLine++;
					}
					contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
					printLine++;
					contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
					contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					//contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
					contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
					contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
					
					contents.append("\n");
					printLine++;
					printLine++;
					
										
					contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
					contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
					
					contents.append("\n");
					printLine++;
					printLine++;

					//contents.append(MakeClientDtlStr(strHidden));
					contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
					contents.append(hisutil.appendSpace("WARD", 10, 0)+ ": "+ hisutil.appendSpace(ward.toUpperCase(), 53, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("S.No.", 6,	0));
					contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 40,	0));
					contents.append(hisutil.appendSpace("LOCATION", 10,	0));
					contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
					contents.append(hisutil.appendSpace("QTY.", 8,	0));
					
					//changes for credit category begin.. 
					if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
					{
						contents.append(hisutil.appendSpace("CREDIT AMOUNT(Rs.)", 20,	0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CREDIT LETTER OR COUNTER No. OR TG No./REFERENECE DATE: "+creditDtls, 80,	0));					
						contents.append("\n");
						printLine++;
					}
					else
					{
						contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					}
					
					contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
					contents.append(hisutil.appendSpace(Desc, 40,	0));
					contents.append(hisutil.appendSpace("---", 10,	0));
					contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
					contents.append(hisutil.appendSpace("  1", 8,	0));
					contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
					contents.append("\n");
					
				/*	if (isDuplicateBill == 0)  // added for raebarli
					{
					contents.append(hisutil.appendSpace(Integer.toString(j+1),6,0));
					contents.append(hisutil.appendSpace(Desc2, 40,	0));
					contents.append(hisutil.appendSpace("---", 10,	0));
					contents.append(hisutil.appendSpace(pat_AdmCharge, 10,	0));
					contents.append(hisutil.appendSpace("  1", 8,	0));
					contents.append(hisutil.appendSpace(pat_AdmCharge, 20,	0));
					contents.append("\n");
					System.out.println(Desc2);
					} */
					printLine++;
					
					/*if(!suramt.equals("0.00"))
					{
						contents.append(hisutil.appendSpace(Integer.toString(j+1),6,0));
						contents.append(hisutil.appendSpace("(SURC)-Surcharge", 40,	0));
						contents.append(hisutil.appendSpace("---", 10,	0));
						contents.append(hisutil.appendSpace(suramt, 10,	0));
						contents.append(hisutil.appendSpace("  1", 8,	0));
						contents.append(hisutil.appendSpace(suramt, 20,	0));
						contents.append("\n");
						printLine++;
					}*/
					contents.append(hisutil.appendSpace("",70,0));
					contents.append(hisutil.appendSpace("------------", 24,0));
					contents.append("\n");
					printLine++;	
					
				/*	if (isDuplicateBill == 0)  // added for raebarli
					{
					totamt=String.valueOf(HisUtil.getAmountWithDecimal(Double.parseDouble(pat_net_amt)+Double.parseDouble(pat_AdmCharge),2));
					}
					else
					{*/
					totamt=String.valueOf(HisUtil.getAmountWithDecimal(Double.parseDouble(pat_net_amt),2));
				/*	}*/
					contents.append(hisutil.appendSpace("",55,0));
					contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
					contents.append(hisutil.appendSpace("", 7,	0));
					contents.append(hisutil.appendSpace(totamt, 20,	0));
					
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("",70,0));
					contents.append(hisutil.appendSpace("------------", 24,0));
					contents.append("\n");
					printLine++;				 

					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(totamt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
                    
					contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN Rs.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					/*if(paymentMode.equals("5"))
							{
								contents.append(hisutil.appendSpace("MODE OF PAYMENT: DEBIT CARD",94, 0));
								contents.append("\n");
								printLine++;
							}else{
								contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH",94, 0));
								contents.append("\n");
								printLine++;
							}*/
					/*switch (paymentMode) {
			        case "1":
			            PaymentModeName = "Cash";
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "2":
			            PaymentModeName = "Cheque";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "3":
			            PaymentModeName = "Demand Draft";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "4":
			            PaymentModeName = "Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "5":
			            PaymentModeName = "Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "6":
			            PaymentModeName = "Client";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "7":
			            PaymentModeName = "Patient Wallet";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					 case "8":
						PaymentModeName = "International Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "9":
						PaymentModeName = "International Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			           break;
					case "10":
						PaymentModeName = "Cm Relief Fund";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "11":
						PaymentModeName = "Virtual Account";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "12":
						PaymentModeName = "Prisoner";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "13":
						PaymentModeName = "Jan Arogya";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        default:
			            PaymentModeName = "Cash";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        }*/
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+paymentmode,94, 0));
					contents.append("\n");
					printLine++;
					//contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ paymentmode.toUpperCase()+": (AMT::"+totamt+")",94, 0));
					contents.append("\n");
					printLine++;
					
					contents.append(Footer(Footer , request , brt.getBillDisclaimerAdvance()));
				}
			}
			content = PrintContents(strBServiceId,"1", contents.toString() , request);
			System.out.println("Advance----->" + contents);
		}

		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.ADVANCE() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * ADVANCE_DUP(vo) -- > This Method is Used to get Print Type in ADVANCE_DUP
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean ADVANCE_DUP(String strBillNo, String strBServiceId,
			String strHospitalCode , HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		boolean content = false;
		String Desc = "ADVANCE";

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String dept = null;

		 BillConfigUtil billConfigUtil = null;
			
			
			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, "0", strBillNo, billConfigUtil
						.getGeneralDuplicatePrint(), "ADVANCE" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.ADVANCE_DUP(voObj);
				ws = voObj.getGblWs1();
				for (int i = 0; ws.next(); i++) {
					int j = i + 1;

					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);

					strHidden = ws.getString(8);
					dept = ws.getString(9);
					String ward=ws.getString(10);
					/*
					 * contents += Header(Header1, Header2, Header3, Header4) +
					 * "                             ADVANCE RECEIPT      \n"; printLine++;
					 */
					contents+=hisutil.appendSpace("ADVANCE RECEIPT", 54, 1)+hisutil.appendSpace("", 40, 0)+"\n";
					printLine++;

					if (isDuplicateBill == 1) {

						//contents += "                          (Duplicate)    \n";
						contents+=hisutil.appendSpace("(Duplicate)", 40, 1)+hisutil.appendSpace("", 54, 0)+"\n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 94,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 38,0) +"\n";
					printLine++;

					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace("DESCRIPTION", 65,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents +=  hisutil.appendSpace(Desc, 65,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				 

					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 82,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
					/*
					 * contents += "    RUPEES (IN WORD) : " + hisutil.getAmountStr(pat_net_amt);
					 * 
					 * //contents +=
					 * "\n                                                    Cashier           ";
					 * contents +="\n"; printLine++; printLine++;
					 */

					if(brt.getBillDisclaimerDuplicatePrintRequired().equals("1")){
					
						contents += Footer(Footer , request , brt.getBillDisclaimerAdvance());
						
					}else{
						
						contents += Footer(Footer , request , "");
						
					}
					
					

				}

			}
			content = PrintContents(strBServiceId,"1", contents , request);
			System.out.println("Advance Duplicate----->" + contents);
		}

		catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.ADVANCE_DUP() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * PART_PAYMENT_DUP(vo) -- > This Method is Used to get Print Type in
	 * PART_PAYMENT_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean PART_PAYMENT(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String printCopyType) throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		StringBuffer contents = new StringBuffer();
		String Desc = "IPD PART PAYMENT";

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		String serv_type="";
		String remarks = null;
		String strIsCreditCat="";
		String strClientName="---"; 
		String creditno="---";
		String paymentdtls="";
		String creditDtls="";
		String suramt="";
		String totamt="";
		String PaymentModeName="";
		String paymentMode="";
		String CreditBillFlg="";
		String paymentmode = "0";

		String BillType="";
		String Mobile="";
		BillConfigUtil billConfigUtil = null;
			
		boolean content = false;

		try 
		{
				billConfigUtil = new BillConfigUtil(strHospitalCode);
				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD PART PAYMENT" , request,isDuplicateBill));
				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");
	
					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
	
					boObj.PART_PAYMENT(voObj);
					ws = voObj.getGblWs1();
	
					for (int i = 0; ws.next(); i++) 
					{
						int j = i + 1;	
						bill_no = ws.getString(1);	
						bill_date = ws.getString(2);	
						patient_name = ws.getString(3).replace("^", "#").split("#");	
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						adm_no = ws.getString(6);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
						serv_type=ws.getString(8);
						dept = ws.getString(9);
						String ward = ws.getString(10);						
						remarks = ws.getString(12);
						strIsCreditCat =  ws.getString(13);//CHECKS CATGRP IF 3,4 THEN RETURNS 1 FROM PROC
						strClientName=ws.getString(14).equals("")?"---":ws.getString(14);//1 yes its credit cat..
						creditno=ws.getString(15).equals("0")?"---":ws.getString(15);
						paymentdtls=ws.getString(16);//.equals("")?"---":ws.getString(16);
						creditDtls=ws.getString(17).equals("")?"---":ws.getString(17);
						CreditBillFlg=ws.getString(18);
						paymentmode = ws.getString(19);
						BillType=ws.getString(20);
						Mobile=ws.getString(21);

						
						/*if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
							paymentMode=paymentdtls.split("/")[1];
							PaymentModeName=paymentdtls.split("/")[2];
							paymentdtls=paymentdtls.split("/")[0];

							}*/
						//suramt=HisUtil.getAmountWithDecimal(ws.getString(17).replace("^", "#").split("#")[1],	2);
						
						/*Contents Adjusted for 94 Characters---Commented For NIMS
						contents.append(Header(Header1, Header2, Header3, Header4);
						contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
						contents.append("                                     CASH RECEIPT                                      \n");
						printLine++;
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;*/

						if (isDuplicateBill == 1)
						{
							contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0).toUpperCase());
							contents.append("\n");
							printLine++;
							printLine++;
						}

						contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
						printLine++;

						contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						
						
						//contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
						contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
						contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
						
						contents.append("\n");
						printLine++;
						printLine++;
						
											
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
						
						
						contents.append("\n");
						printLine++;
						printLine++;
						

						//contents.append(MakeClientDtlStr(strHidden));
						contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
						contents.append(hisutil.appendSpace("WARD", 10, 0)+ ": "+ hisutil.appendSpace(ward.toUpperCase(), 53, 0));

						contents.append("\n");
						printLine++;
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
												
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{
							if(CreditBillFlg.equals("0"))
								{
										contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
										contents.append("\n");
										printLine++;
										contents.append("----------------------------------------------------------------------------------------------");
										contents.append("\n");
										printLine++;
								}else{
									contents.append(hisutil.appendSpace("CREDIT AMOUNT(Rs.)", 20,	0));
									contents.append("\n");
									printLine++;
									contents.append("----------------------------------------------------------------------------------------------");
									contents.append("\n");
									printLine++;
									contents.append(hisutil.appendSpace("CREDIT LETTER OR COUNTER No. OR TG No./REFERENECE DATE: "+creditDtls, 80,	0));
									contents.append("\n\n");
									printLine++;
								}
						}
						else
						{
							contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						}
												
						contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
						contents.append(hisutil.appendSpace(Desc, 40,	0));
						contents.append(hisutil.appendSpace("---", 10,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
						contents.append(hisutil.appendSpace("  1", 8,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						contents.append("\n");
						printLine++;
						
						/*if(!suramt.equals("0.00"))
						{
							contents.append(hisutil.appendSpace(Integer.toString(j+1),6,0));
							contents.append(hisutil.appendSpace("(SURC)-Surcharge", 40,	0));
							contents.append(hisutil.appendSpace("---", 10,	0));
							contents.append(hisutil.appendSpace(suramt, 10,	0));
							contents.append(hisutil.appendSpace("  1", 8,	0));
							contents.append(hisutil.appendSpace(suramt, 20,	0));
							contents.append("\n");
							printLine++;
						}*/
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;	
						
						totamt=String.valueOf(HisUtil.getAmountWithDecimal(Double.parseDouble(pat_net_amt),2));
						
						contents.append(hisutil.appendSpace("",55,0));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
						contents.append(hisutil.appendSpace("", 7,	0));
						contents.append(hisutil.appendSpace(totamt, 20,	0));
						
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;
					
					if(remarks != null && remarks.trim().length() > 0 && !remarks.trim().equals("0"))
					{														
						contents.append(hisutil.appendSpace("REMARKS : "+ hisutil.breakString(remarks, 80, "~").get(0).toUpperCase(),94,0)) ;						
						contents.append("\n");
						printLine++;
						printLine++;											
					}					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(totamt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN Rs.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
					contents.append("\n");
					printLine++;*/
				/*	switch (paymentMode) {
			        case "1":
			            PaymentModeName = "Cash";
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "2":
			            PaymentModeName = "Cheque";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "3":
			            PaymentModeName = "Demand Draft";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "4":
			            PaymentModeName = "Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "5":
			            PaymentModeName = "Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "6":
			            PaymentModeName = "Client";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "7":
			            PaymentModeName = "Patient Wallet";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					 case "8":
						PaymentModeName = "International Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "9":
						PaymentModeName = "International Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			           break;
					case "10":
						PaymentModeName = "Cm Relief Fund";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "11":
						PaymentModeName = "Virtual Account";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "12":
						PaymentModeName = "Prisoner";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "13":
						PaymentModeName = "Jan Arogya";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        default:
			            PaymentModeName = "Cash";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        }*/
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+paymentmode,94, 0));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;
					
					contents.append(Footer(Footer , request , brt.getBillDisclaimerPartPayment()));	
				}
			}
			content = PrintContents(strBServiceId,"1", contents.toString() , request);
			System.out.println("Part Payment------->" + contents);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.PART_PAYMENT() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean LF_PART_PAYMENT(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String printCopyType) throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		StringBuffer contents = new StringBuffer();
		String Desc = "IPD PART PAYMENT";

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		
		String remarks = null;
		String strIsCreditCat="";
		String paymentdtls="";
		
		BillConfigUtil billConfigUtil = null;
			
		boolean content = false;
		String PaymentModeName="";
		String paymentMode="";

		try 
		{
				billConfigUtil = new BillConfigUtil(strHospitalCode);
				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD PART PAYMENT" , request,isDuplicateBill));
				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");
	
					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
	
					boObj.LF_PART_PAYMENT(voObj);
					ws = voObj.getGblWs1();
	
					for (int i = 0; ws.next(); i++) 
					{
						int j = i + 1;	
						bill_no = ws.getString(1);	
						bill_date = ws.getString(2);	
						patient_name = ws.getString(3).replace("^", "#").split("#");	
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						adm_no = ws.getString(6);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
						dept = ws.getString(8);
						String ward = ws.getString(9);						
						remarks = ws.getString(11);
						paymentdtls=ws.getString(12).equals("")?"---":ws.getString(12);
						if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
							paymentMode=paymentdtls.split("/")[1];
							PaymentModeName=paymentdtls.split("/")[2];
							paymentdtls=paymentdtls.split("/")[0];

							}
						/*Contents Adjusted for 94 Characters---Commented For NIMS
						contents.append(Header(Header1, Header2, Header3, Header4);
						contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
						contents.append("                                     CASH RECEIPT                                      \n");
						printLine++;
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;*/

						if (isDuplicateBill == 1)
						{
							contents.append(hisutil.appendSpace("Duplicate--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0));
							contents.append("\n");
							printLine++;
							printLine++;
						}

						contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "-").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("LF No.", 10, 0)+ ": "+ hisutil.appendSpace(ward.toUpperCase(), 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "-").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace("---", 21, 0));
						/*contents.append(hisutil.appendSpace("CREDIT NO.", 10, 0)+ ": "+ hisutil.appendSpace("---", 20, 0));*/
						contents.append(hisutil.appendSpace(" ", 10, 0)+ ": "+ hisutil.appendSpace("---", 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;

						//contents.append(MakeClientDtlStr(strHidden));
						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{						
							contents.append(hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 20,	0));
						}
						else
						{
							contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
						}
						
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
						contents.append(hisutil.appendSpace(Desc, 40,	0));
						contents.append(hisutil.appendSpace("---", 10,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
						contents.append(hisutil.appendSpace("  1", 8,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;		
						
						contents.append(hisutil.appendSpace("",55,0));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
						contents.append(hisutil.appendSpace("", 7,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;
					
					if(remarks != null && remarks.trim().length() > 0 && !remarks.trim().equals("0"))
					{														
						contents.append(hisutil.appendSpace("REMARKS : "+ hisutil.breakString(remarks, 80, "~").get(0).toUpperCase(),94,0)) ;						
						contents.append("\n");
						printLine++;
						printLine++;											
					}					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;	
					contents.append(hisutil.appendSpace("Note : Amount,Patient Share and Client Share are in Rs.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					/*contents.append(hisutil.appendSpace("Mode Of Payment: Cash/Credit Card/Debit Card/Cheque",94, 0));
					contents.append("\n");
					printLine++;*/
					/*switch (paymentMode) {
			        case "1":
			            PaymentModeName = "Cash";
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "2":
			            PaymentModeName = "Cheque";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "3":
			            PaymentModeName = "Demand Draft";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "4":
			            PaymentModeName = "Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "5":
			            PaymentModeName = "Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "6":
			            PaymentModeName = "Client";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "7":
			            PaymentModeName = "Patient Wallet";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					 case "8":
						PaymentModeName = "International Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "9":
						PaymentModeName = "International Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			           break;
					case "10":
						PaymentModeName = "Cm Relief Fund";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "11":
						PaymentModeName = "Virtual Account";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "12":
						PaymentModeName = "Prisoner";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "13":
						PaymentModeName = "Jan Arogya";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        default:
			            PaymentModeName = "Cash";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        }
					*/
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;
					contents.append(Footer(Footer , request , brt.getBillDisclaimerPartPayment()));	
				}
			}
			content = PrintContents(strBServiceId,"1", contents.toString() , request);
			System.out.println("Part Payment------->" + contents);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.PART_PAYMENT() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * PART_PAYMENT_DUP(vo) -- > This Method is Used to get Print Type in
	 * PART_PAYMENT_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean PART_PAYMENT_DUP(String strBillNo,
			String strBServiceId, String strHospitalCode, HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		String Desc = "PART PAYMENT";

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		String ward =null;
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
					
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, "0", strBillNo, billConfigUtil
						.getGeneralDuplicatePrint(), "ADVANCE" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.PART_PAYMENT_DUP(voObj);
				ws = voObj.getGblWs1();

				for (int i = 0; ws.next(); i++) {
				//	int j = i + 1;

					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);

					dept = ws.getString(8);
					ward = ws.getString(9);
					/*
					 * contents += Header(Header1, Header2, Header3, Header4) +
					 * "                            ADVANCE      \n";
					 */
					contents+=hisutil.appendSpace("PART PAYMENT RECEIPT", 54, 1)+hisutil.appendSpace("", 40, 0)+"\n";
					printLine++;

					if (isDuplicateBill == 1) {

						//contents += "                          (Duplicate)    \n";
						contents+=hisutil.appendSpace("(Duplicate)", 40, 1)+hisutil.appendSpace("", 54, 0)+"\n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 94,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 38,0) +"\n";
					printLine++;

					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace("DESCRIPTION", 65,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents +=  hisutil.appendSpace(Desc, 65,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				 
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 82,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents += "----------------------------------------------------------------------------------------------\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
					/*
					 * contents += "    RUPEES (IN WORD) : " + hisutil.getAmountStr(pat_net_amt);
					 * 
					 * //contents +=
					 * "\n                                                    Cashier           ";
					 * contents +="\n"; printLine++; printLine++;
					 */

					if(brt.getBillDisclaimerDuplicatePrintRequired().equals("1")){
					
						contents += Footer(Footer , request , brt.getBillDisclaimerPartPayment());
						
					}else{
						
						contents += Footer(Footer , request , "");
					}
					
					

				}

			}
			content = PrintContents(strBServiceId,"1", contents , request);
			System.out.println("Part Payment Duplicate------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.PART_PAYMENT_DUP() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * IPD_REFUND(vo) -- > This Method is Used to get Print Type in IPD_REFUND
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_REFUND(String strBillNo, String strReceiptNo,
			String strPatAccountNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
		String dept = null;
		String serv_type=null;
		
		String approvalDtl = null;
		
		String BillType="";
		String Mobile="";
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(), "IPD REFUND" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrAcctNo(strPatAccountNo);

				boObj.IPD_REFUND(voObj);

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				ws = voObj.getStrIpdRefund();
				ws1 = voObj.getStrIpdRefund1();
			
				int len = ws1.size();

				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				for (int k = 0; ws.next(); k++) {
					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					serv_type=ws.getString(9);
					dept = ws.getString(10);
					String ward = ws.getString(11);
					
					approvalDtl = ws.getString(12);
					
					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);
					}

					BillType=ws.getString(13);
					Mobile=ws.getString(14);
					contents += Header(Header1, Header2, Header3, Header4)
							+ "                          IPD REFUND       \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;

					contents+=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;

					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					//contents +=  hisutil.appendSpace(" SERVICE", 12,0)+": "+hisutil.appendSpace(serv_type, 62,0)
					contents +=  hisutil.appendSpace(" SERVICE", 12,0)+": "+hisutil.appendSpace(serv_type, 29,0)
					+   hisutil.appendSpace(" Mobile No", 10,0)+": "+hisutil.appendSpace(Mobile.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;

					if(isServiceDiscountReq == 0){
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
								 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
								 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}else{
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 36,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}
					
					
					int tariffLen = 32;
					String strRate = "0";
					//String strRateUnit = ""; 

					if(isServiceDiscountReq == 0){
						
						tariffLen = 45;
					}
					
			 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							strRate = strTemp[1].replace("/", "#").split("#")[0];
							
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
							
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");
														 
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i].toUpperCase(), tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								//contents += "\n";
								//printLine++;
								//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
								//	+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents += hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
												+ hisutil.appendSpace(strRate, 12,1)
												+ hisutil.appendSpace(billed_qty[i].replace(" ", "#").split("#")[0], 6,1);
										 										
								}else{
											
									   contents += hisutil.appendSpace("  "+Tname.get(j), 35,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}
									
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 13, 1 ) ;
										contents += "\n";
								printLine++;
							} else {
							
								//printLine++;
								//contents +=  "       "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0);
								//contents += "\n";
							}
						}
					}


					//contents += "\n----------------------------------------------------------------------\n";
					//printLine++;
					//printLine++;
					
					contents += "\n";
					printLine++;
					  
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						
					//	contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					//	printLine++;

					
						contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
						contents +="\n";
						printLine++;
						
						contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
						contents +="\n";
						printLine++;
						
						

					contents += "\n";
					printLine++;
					printLine++;
					
					contents += "    RUPEES (IN WORD) : "
							+ hisutil.getAmountStr(pat_net_amt);

					//contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;
					
					contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

				}

			}
			content = PrintContents(strBServiceId, "2", contents , request);
			System.out.println("Ipd Refund------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.IPDREFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * IPD_RECONCILIATION(vo) -- > This Method is Used to get Print Type in
	 * IPD_RECONCILIATION Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_RECONCILIATION(String strBillNo,
			String strReceiptNo, String strPatAccountNo, String strBServiceId,
			String strHospitalCode , HttpServletRequest request,int isDuplicateBill) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
        String serv_type="";
        
        String BillType="";
        String Mobile="";
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"IPD RECONCILIATION" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrAcctNo(strPatAccountNo);

				boObj.IPD_RECONCILIATION(voObj);

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				ws = voObj.getStrIpdReconcil();
				ws1 = voObj.getStrIpdReconcil1();

				int len = ws1.size();
				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				for (int k = 0; ws.next(); k++) {
					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					// adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
                    serv_type=ws.getString(12);
                    BillType=ws.getString(13);
                    Mobile=ws.getString(14);
					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);
					}

					contents += Header(Header1, Header2, Header3, Header4)
							+ "                         IPD RECONCILIATION      \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;

					contents+=hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n";
					printLine++;

					contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
					 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
					+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
					+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1], 13,0) +"\n";
					printLine++;
                    
					//contents +=  hisutil.appendSpace(" Service", 9,0)     +": "+hisutil.appendSpace(serv_type, 57,0) +"\n";
					contents +=  hisutil.appendSpace(" Service", 9,0)     +": "+hisutil.appendSpace(serv_type, 26,0)
					+   hisutil.appendSpace(" Mobile", 18,0)+": "+hisutil.appendSpace(Mobile, 13,0)+"\n";
					printLine++;
					// contents += MakeClientStr(strHidden);

					if(isServiceDiscountReq == 0){
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
								 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
								 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
					
					}else{
						
						contents += "----------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 26,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "----------------------------------------------------------------------";
					
					}
					
					
					int tariffLen = 22;
					String strRate = "0";

					if(isServiceDiscountReq == 0){
						
						tariffLen = 30;
					}
						
				 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							Tname = hisutil.breakString(
									strTemp[0], tariffLen, "~");
							
							strRate = strTemp[1];
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i], tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								contents += "\n";
								printLine++;
								contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
									+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
												+ hisutil.appendSpace(strRate, 11,1)
												+ hisutil.appendSpace(billed_qty[i], 9,1);
										 										
								}else{
											
									   contents += hisutil.appendSpace("  "+Tname.get(j), 25,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}
									
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
										contents += "\n";
								printLine++;
							} else {
							
								printLine++;
								contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
								contents += "\n";
							}
						}
					}

					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					contents +=hisutil.appendSpace("Expense Amt   : ", 57,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
					printLine++;
				 
					if(Double.parseDouble(pat_net_amt) >= 0){
						
						contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
							
					}else{
						
						contents +=hisutil.appendSpace("Paid to Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					}
					printLine++;
					
					contents += "\n----------------------------------------------------------------------\n";
					printLine++;
					printLine++;
					
					contents += "     Rs. in Word : "
							+ hisutil.getAmountStr(pat_net_amt);
				//	contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;
					contents += Footer(Footer , request , "");

				}

			}
			content = PrintContents(strBServiceId, "3", contents , request);
			System.out.println("Ipd Reconciliation------->" + contents);

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.IPDRECONCILIATION() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * IPD_SERVICES_DUP(vo) -- > This Method is Used to get Print Type in
	 * IPD_SERVICES_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_SERVICES(String strBillNo,String strPatAccountNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType) throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = new PrintVO();
		PrintBO boObj = new PrintBO();

		WebRowSet ws = null, ws1 = null;

		StringBuffer contents = new StringBuffer("");

		HisUtil hisutil = new HisUtil("billing", "PrintHLP");

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;
		

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String ward = null;
		String strIsCreditPat="0";
		String strFinalAmt="0.00";//amount total irrespective of Gen or Credit Category Patient.
		String strAmountHeader="  Amount(Rs.)"; //vl be client amount when pat is of credit cat..
		String serv_type="";
		String patTotAmt="0.00";
		String clientTotAmt="0.00";
		String strClientName="---"; 
		String creditno="---";
		String paymentdtls="";
		String paymentMode="";
		String PaymentModeName="";
		double concessionAmt=0.00;
		
		String BillType="";
		String Mobile="";
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
			{
				contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD SERVICES" , request,isDuplicateBill));

			} 
			else 
			{
				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrAcctNo(strPatAccountNo);
				voObj.setStrReceiptNo(strReceiptNo);

				if( strIsDirectMode == "1" )//Offline
				{					
					boObj.IPD_SERVICES_DIRECT(voObj);//To Get Only Patient Details and Bill Details
				}
				else
				{
					boObj.IPD_SERVICES(voObj);//To Get Only Patient Details and Bill Details and Tariff Details
				}				
				

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				/*String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();*/
				String Footer = brt.getBillFormatFooter();

			 
				/*String[] tariff_name = null;
				String[] billed_qty = null;
				String[] S_Tax = null;
				String[] net_bill_amt = null;
				String[] dis_amt = null;*/
				
				
				if( strIsDirectMode == "1" )
				{					
					ws = voObj.getGblWs1();
					//ws1= voObj.getGblWs3(); 
					
					
					/*tariff_name = new String[strTariffList.length];
					billed_qty = new String[strTariffList.length];
					S_Tax = new String[strTariffList.length];
					net_bill_amt = new String[strTariffList.length];
					dis_amt = new String[strTariffList.length];*/
					
				}
				else
				{					
					ws = voObj.getGblWs1();
					ws1 = voObj.getGblWs2();
					
					/*int len = ws1.size();
					tariff_name = new String[len];
					billed_qty = new String[len];
					S_Tax = new String[len];
					net_bill_amt = new String[len];
					dis_amt = new String[len];*/
					
				}				

				for (int k = 0; ws.next(); k++) 
				{
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);					
					serv_type=ws.getString(9);
					ward = ws.getString(11);
					strIsCreditPat = ws.getString(13);
					strFinalAmt= HisUtil.getAmountWithDecimal(ws.getString(14), 2);
					strClientName=ws.getString(15).equals("")?"---":ws.getString(15);//1 yes its credit cat..
					creditno=ws.getString(16).equals("0")?"---":ws.getString(16);
					paymentdtls=ws.getString(17).equals("")?"---":ws.getString(17);
					PaymentModeName=ws.getString(18);
					
					BillType=ws.getString(19);
					Mobile=ws.getString(20);
					/*if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
						paymentMode=paymentdtls.split("/")[1];
						PaymentModeName=paymentdtls.split("/")[2];
						paymentdtls=paymentdtls.split("/")[0];

						}*/
					//double cltamt = Double.parseDouble(clt_net_amt);
					double cltamt = 0;

				/*	if(strIsCreditPat.equalsIgnoreCase("1"))
					{
						strAmountHeader="  Client Amount(Rs.)";
					}
					if( strIsDirectMode == "1" )
					{						
						
						/*for (int n = 0; n < strTariffList.length; n++) {
							
							
							String strTempVal[] = strTariffList[n].replace("^", "#").split("#");
							
							tariff_name[n] = strTempVal[0];
							billed_qty[n] = strTempVal[1];
							dis_amt[n] = HisUtil.getAmountWithDecimal(strTempVal[2], 2);
							S_Tax[n] = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
							net_bill_amt[n] = HisUtil.getAmountWithDecimal(strTempVal[4], 2);
						}*/
						
						
				/*	}
					else
					{
						if(tariffPrintMap==null)
							tariffPrintMap=new LinkedHashMap(0);
						int len = ws1.size();
						String[] strArrayTariffList=new String[len];
						
						for (int n = 0; ws1.next(); n++) 
						{
							
							
							///crating group wise tariff map for online cash collection as Map passed is null
							
							//strDirectTariffList1(TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage)
							
							 String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
														HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+"^0^0^0^"+ws1.getString(8);///Amit Ateria
							 
							 strArrayTariffList[n]=strDirectTariffList+"#"+ws1.getString(6)+"#"+ ws1.getString(7)+"#NA#NA" ;							
							 
						}
						 tariffPrintMap=populateGroupMapForPrinting(strArrayTariffList,tariffPrintMap,brt);//To Be checked for Credit category
					}
					*
					
					
					/*Contents Adjusted for 94 Characters---Commented For NIMS
					contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
					contents.append("                                     IPD SERVICES                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;*/
					

					
					if (isDuplicateBill == 1)
					{
						contents.append(hisutil.appendSpace("Duplicate--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0));
						contents.append("\n");
						printLine++;
						printLine++;
					}

					contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
					printLine++;

					contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
					contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					//contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
					contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
					contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
										
					contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));	
					contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append("\n");
					printLine++;
					printLine++;

				
					//contents.append(MakeClientDtlStr(strHidden));
					contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
					contents.append(hisutil.appendSpace("WARD", 10, 0)+ ": "+ hisutil.appendSpace(ward.toUpperCase(), 53, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					if(strIsCreditPat.equalsIgnoreCase("1"))
					{
						if (strIsDirectMode == "1")//offline..
						{
						} 
						else
						{
							if (tariffPrintMap == null)
								tariffPrintMap = new LinkedHashMap();

							int len = ws1.size();
							String[] strArrayTariffList = new String[len];
							
							for (int n = 0; ws1.next(); n++)
							{
								///crating group wise tariff map for online cash collection as Map passed is null
								
								//strDirectTariffList1(TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage)
								
								 String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
															HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+"^0^0^0^"+ws1.getString(8);///Amit Ateria
								 
								 strArrayTariffList[n]=strDirectTariffList+"#"+ws1.getString(6)+"#"+ ws1.getString(7)+"#"+ws1.getString(11)+"#"+ws1.getString(9);
								 patTotAmt=ws1.getString(14);
								 clientTotAmt=ws1.getString(15);
							}
							tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						}


						if (isServiceDiscountReq == 0)
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("S.No.", 5,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 29,	0));
							contents.append(hisutil.appendSpace("LOCATION", 10,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("QTY.", 8,	0));
							contents.append(hisutil.appendSpace("AMT(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("PAT. SHARE", 12,	0));
							contents.append(hisutil.appendSpace("CLT. SHARE", 10,	0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						} 
						else
						{
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("S.No.", 5,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 25,	0));
							contents.append(hisutil.appendSpace("LOCATION", 8,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
							contents.append(hisutil.appendSpace("QTY.", 6,	0));
							contents.append(hisutil.appendSpace("DISC.", 6,0));
							contents.append(hisutil.appendSpace("S.TAX", 6,0));
							contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
							contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
							contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
							contents.append("\n");
							printLine++;

							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
						}
						

						// /iterating printMap for printing tariff based on group and Credit Letter No
						iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
						

						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",51,1)+hisutil.appendSpace("TOTAL",13,0)+hisutil.appendSpace(exp_amt,10,0));
						contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(patTotAmt,8,0));
						contents.append(hisutil.appendSpace("",3,1)+hisutil.appendSpace(clientTotAmt,7,0));
						//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append("\n");
						printLine++;
						printLine++;

						
						
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" AMOUNT PAID BY CLIENT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt),94,0));
						contents.append("\n");
						printLine++;
						printLine++;						
					}
				else
				{
					//ITS NON CREDIT BILLING
					if (strIsDirectMode == "1")//offline..
					{
					} 
					else
					{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							// /crating group wise tariff map for online cash
							// collection as Map passed is null

							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+"^0^0^0^"+ws1.getString(8);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
					}
					
					
					
					
					if (isServiceDiscountReq == 0)
					{
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 15,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15,	0));
						contents.append("\n");
						printLine++;

						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					} 
					else
					{
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;

						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 11,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
						//contents.append(hisutil.appendSpace("S.TAX", 10,0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
					
						contents.append("\n");
						printLine++;

						contents.append("-------------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					}

					// /iterating printMap for printing tariff based on group

					concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);
					

					if (cltamt > 0)
					{
						contents.append(hisutil.appendSpace("Expense Amt   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("Paid by Third Party   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("Paid by Patient   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;
					} 
					else
					{
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 8, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
							
					}						
					

					contents.append("\n");
					printLine++;

					contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
				}
					
					
					printPackageDetails(tariffPrintMap, contents, brt,voObj);
					
					
					
					
					contents.append(hisutil.appendSpace("Note : Amount,Patient Share and Client Share are in Rs.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					/*contents.append(hisutil.appendSpace("Mode Of Payment: Cash/Credit Card/Debit Card/Cheque",94, 0));
					contents.append("\n");
					printLine++;*/
					/*switch (paymentMode) {
			        case "1":
			            PaymentModeName = "Cash";
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "2":
			            PaymentModeName = "Cheque";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "3":
			            PaymentModeName = "Demand Draft";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "4":
			            PaymentModeName = "Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "5":
			            PaymentModeName = "Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "6":
			            PaymentModeName = "Client";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        case "7":
			            PaymentModeName = "Patient Wallet";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					 case "8":
						PaymentModeName = "International Credit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "9":
						PaymentModeName = "International Debit Card";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			           break;
					case "10":
						PaymentModeName = "Cm Relief Fund";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "11":
						PaymentModeName = "Virtual Account";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "12":
						PaymentModeName = "Prisoner";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
					case "13":
						PaymentModeName = "Jan Arogya";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        default:
			            PaymentModeName = "Cash";
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
											contents.append("\n");
											printLine++;
			            break;
			        }*/
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;

					contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
					
				}

			}		

			
			strIsDirectMode = "0";			
			
			content = PrintContents(strBServiceId, "1", contents.toString() , request);
			System.out.println("Ipd Services----->" + contents);

		} 
		catch (Exception e) 
		{
			throw new Exception("Billing  PrintHLP.IPD_SERVICES() -->"+ e.getMessage());

		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * IPD_SERVICES_DUP(vo) -- > This Method is Used to get Print Type in
	 * IPD_SERVICES_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_SERVICES_DUP(String strBillNo,
			String strPatAccountNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = new PrintVO();
		PrintBO boObj = new PrintBO();

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		HisUtil hisutil = new HisUtil("billing", "PrintHLP");

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
		String dept = null;
		Map tariffPrintMap=null;

		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, "0", strBillNo, billConfigUtil
						.getGeneralDuplicatePrint(), "IPD SERVICES" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrAcctNo(strPatAccountNo);
				

				boObj.IPD_SERVICES_DUP(voObj);

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				ws = voObj.getGblWs1();
				ws1 = voObj.getGblWs2();
			
				int len = ws1.size();
				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				for (int k = 0; ws.next(); k++) 
				{
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
					dept = ws.getString(11);
					
					///crating group wise tariff map for online cash collection as Map passed is null
					if(tariffPrintMap==null)
						tariffPrintMap=new LinkedHashMap(0);
					
					String[] strArrayTariffList=new String[ws1.size()];
					
					for (int n = 0; ws1.next(); n++) 
					{
						/*tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
						
						String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
						HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
						*/
						
						String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
						HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
						strArrayTariffList[n]=strDirectTariffList+"#"+ws1.getString(6)+"#"+ ws1.getString(7);
					}
					
					tariffPrintMap=populateGroupMapForPrinting(strArrayTariffList,tariffPrintMap,brt);
					/*
					 * contents += Header(Header1, Header2, Header3, Header4) +
					 * "                            IPD SERVICES      \n";
					 */
					contents+=hisutil.appendSpace("IPD SERVICES", 54, 1)+hisutil.appendSpace("", 40, 0)+"\n";
					printLine++;

					if (isDuplicateBill == 1) 
					{
						/* contents += "                          (Duplicate)    \n"; */
						contents+=hisutil.appendSpace("(Duplicate)", 40, 1)+hisutil.appendSpace("", 54, 0)+"\n";
						printLine++;
					}
					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 94,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(dept.toUpperCase(), 38,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 38,0) +"\n";
					printLine++;

					if(isServiceDiscountReq == 0)
					{						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
								 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
								 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;						
					}
					else
					{	
						contents += "----------------------------------------------------------------------------------------------\n";
						printLine++;
						contents+=hisutil.appendSpace("S.No.", 7,	0)+hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0)+
								hisutil.appendSpace("LOCATION", 11,	0)+hisutil.appendSpace("RATE(Rs.)", 10,0)+hisutil.appendSpace("QTY.", 6,	0)+
								hisutil.appendSpace("DISC.(Rs.)", 10,0)+hisutil.appendSpace("AMOUNT(Rs)", 10,	0)+"\n";
						printLine++;
						contents += "----------------------------------------------------------------------------------------------\n";
						printLine++;	
						/*
						 * contents +=
						 * "--------------------------------------------------------------------------------\n";
						 * printLine++; contents += hisutil.appendSpace(" S.No.", 6,0)+
						 * hisutil.appendSpace(" Description", 36,0) + hisutil.appendSpace(" Qty.",
						 * 9,0)+ hisutil.appendSpace(" Disc.", 11,0) + hisutil.appendSpace(" S.Tax",
						 * 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n"; printLine++;
						 * 
						 * contents +=
						 * "--------------------------------------------------------------------------------\n";
						 * printLine++;
						 */						
					}
					
					
					int tariffLen = 32;
					String strRate = "0";
					//String strRateUnit = ""; 

					if(isServiceDiscountReq == 0)
					{						
						tariffLen = 45;
					}
					
					/*
					for (int i = 0; i < tariff_name.length; i++)
					{
						List<String> Tname = null;						
						if(isServiceDiscountReq == 0)
						{							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");							
							strRate = strTemp[1].replace("/", "#").split("#")[0];							
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];							
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");							
						}
						else
						{							
							Tname = hisutil.breakString(tariff_name[i].toUpperCase(), tariffLen, "~");							
						}

						for (int j = 0; j < Tname.size(); j++) 
						{
							if (j == 0) 
							{
								//contents += "\n";
								//printLine++;
								//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
								//	+ " " ;
														
								if(isServiceDiscountReq == 0)
								{										
									   contents += hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
												+ hisutil.appendSpace(strRate, 12,1)
												+ hisutil.appendSpace(billed_qty[i].replace(" ", "#").split("#")[0], 6,1);
								}
								else
								{	   contents += hisutil.appendSpace("  "+Tname.get(j), 35,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}								
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 13, 1 ) ;
										contents += "\n";
										printLine++;
							} 
							else 
							{							
								printLine++;
								contents +=  "       "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0);
								contents += "\n";
							}
						}
					}*/
					

					///iterating printMap for printing tariff based on group
					StringBuffer contentBfr=new StringBuffer(contents);
					iterateMapForPrinting(tariffPrintMap, contentBfr,brt);
					contents=contentBfr.toString();					
					
					//contents += "\n----------------------------------------------------------------------\n";
					//printLine++;
					//printLine++;
					
					contents += "\n";
					printLine++;
					  
					contents += "----------------------------------------------------------------------------------------------\n";
						printLine++;
						contents +=hisutil.appendSpace("TOTAL AMOUNT ", 82,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
						contents += "----------------------------------------------------------------------------------------------\n";
						printLine++;
						
					//	contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					//	printLine++;

					 

				//	contents += "\n----------------------------------------------------------------------\n";
				//	printLine++;
				//	printLine++;

					contents += "\n";
					printLine++;
					printLine++;
					
					/*
					 * contents += "    RUPEES (IN WORD) : " + hisutil.getAmountStr(pat_net_amt);
					 * 
					 * //contents +=
					 * "\n                                                    Cashier           ";
					 * contents +="\n"; printLine++; printLine++;
					 */
					
					if(brt.getBillDisclaimerDuplicatePrintRequired().equals("1"))
					{					
						contents += Footer(Footer , request , brt.getBillDisclaimerServices());						
					}
					else
					{						
						contents += Footer(Footer , request , "");						
					}
				}
			}
			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Ipd Services Duplicate----->" + contents);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.IPD_SERVICES_DUP() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}
		return content;
	}

	/**
	 * FINAL_ADJUSTMENT(vo) -- > This Method is Used to get WebRowSet for
	 * Approved By Combo
	 * 
	 * @throws Exception
	 * 
	 */

	public static boolean FINAL_ADJUSTMENT(String strBillNo,String strBServiceId, String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo , HttpServletRequest request, int isDuplicateBill,String printCopyType)
			throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strPatAccountNo == null && strPatAccountNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null;

		StringBuffer contents = new StringBuffer();
	
		// String[] temp = null;

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		Date dt=new Date();
		Calendar cal = Calendar.getInstance();  
		String DATE_FORMAT = "dd-MMM-yy";
		SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
	    //bill_date=sdf.format(cal.getTime());
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String strCltDtl = null;
		String strAdmnDtl = null;
		String expense_amt = null;
		String clt_amt = null;
		String dis_amt = "0";
		String ser_tax_amt = "0";
		String adm_date=null;
		String dis_date=null;
		String dept_name=null;
		String ward_name=null;
		String payable_amt=null;
		String adv_trf_amt=null;
		String auditor = "";
		String strPatCatCode = "";
		String strIsCreditCat="";
		String strCatGrp="";
		String serv_type="";
		String paymentdtls="";
		String strClientName="---";
		String creditno="---";
		String address="";
		String paymentMode="";
		String PaymentModeName="";
		String adm_dtls="";
		int reopenflag=0;
		printCopyType=printCopyType.toUpperCase();
		
		String BillType="";
		String Mobile="";
		BillConfigUtil billConfigUtil = null;			
		boolean content = false;

		try 
		{
			billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
			{
				contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"Final Adjustment Bill" , request,isDuplicateBill));
			} 
			else 
			{
				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrAcctNo(strPatAccountNo);

				boObj.FINAL_ADJUSTMENT(voObj);//Bill & Demographic Details

				ws = voObj.getGblWs1();

				// NumberFormat df = new DecimalFormat(".##");

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				for (int k = 0; ws.next(); k++) 
				{
					bill_no = ws.getString(1);
					adm_no= ws.getString(2);
					Crno = ws.getString(3);
					patient_category = ws.getString(4);
					patient_name = ws.getString(5).replace("^", "#").split("#");
					adm_date=ws.getString(6);
					dis_date=ws.getString(7);
					dept_name=ws.getString(8);
					ward_name=ws.getString(9);
					serv_type=ws.getString(13);
					float temp_expence=ws.getFloat(11);
					float temp_adv_trf=ws.getFloat(14);
					float tempnet_pay=ws.getFloat(10);
					float tempPayable = ws.getFloat(12);
					auditor = ws.getString(15);
					
					strPatCatCode = ws.getString(16);
					paymentdtls=ws.getString(17).equals("")?"---":ws.getString(17);
					String NewPaymentmode=ws.getString(24);
					String temp[]=ws.getString(18).replace("^", "#").split("#");
					
					if(!ws.getString(18).equals(" "))
					{						
						strClientName=temp[0].equals("")?"---":temp[0];
						creditno=temp[1].equals("0")?"---":temp[1];
					}
					strIsCreditCat=ws.getString(19);
					strCatGrp=ws.getString(22);
					address=ws.getString(20);
					float expn=ws.getFloat(21);
					bill_date=ws.getString(23);
					reopenflag=ws.getInt(25);
					adm_dtls=ws.getString(26);
					
					BillType=ws.getString(27);
					Mobile=ws.getString(28);
					if(ward_name==null)
						ward_name="--";
					/*if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
						paymentMode=paymentdtls.split("/")[1].toUpperCase();
						PaymentModeName=paymentdtls.split("/")[2].toUpperCase();
						paymentdtls=paymentdtls.split("/")[0].toUpperCase();

						}*/
					
					
					/*Contents Adjusted for 94 Characters---Commented For NIMS
					contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
					contents.append("                                     IPD ADVANCE RECEIPT                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;*/
                    
					if (strBillType.equals("1")) //CONSOLIDATED
						contents.append(hisutil.appendSpace("", 28, 0)+hisutil.appendSpace("PATIENT CHARGES ACCOUNT (CONSOLIDATED)", 38, 1)+hisutil.appendSpace("", 28, 0));
					else//DETAILED
						contents.append(hisutil.appendSpace("", 30, 0)+hisutil.appendSpace("PATIENT CHARGES ACCOUNT (DETAILED)", 34, 1)+hisutil.appendSpace("", 30, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					if (isDuplicateBill == 1) 
					{
						contents.append(hisutil.appendSpace("DUPLICATE--", 47, 1)+hisutil.appendSpace(printCopyType, 47, 0));
						contents.append("\n");
						printLine++;
						printLine++;
					}
					if(reopenflag>0)
					{
						contents.append(hisutil.appendSpace("<b>THIS BILL HAS BEEN REOPENED. TARIFFS MAY VARY WITH THE CURRENT BILL.</b>", 47, 0));
						contents.append("\n");
						printLine++;
						printLine++;
					}	

					contents.append(hisutil.appendSpace("["+ BillType, 40, 1).toUpperCase()+hisutil.appendSpace(" RECEIPT]", 54, 0)+"\n");
					printLine++;

					contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("BILL DATE", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2	// DATE&TIME by mani					
					contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace("ADM. NO.", 10, 0)+ ": "+ hisutil.appendSpace(adm_no.toUpperCase(), 20, 0));//10+20=30+2
					contents.append(hisutil.appendSpace("ADM. DATE", 10, 0)+ ": "+ hisutil.appendSpace(adm_date, 21, 0));//10+21=31+2	
					if(adm_dtls.split("#")[1].equals("16"))
						contents.append(hisutil.appendSpace("DISC. DATE", 10, 0)+ ": "+ hisutil.appendSpace(adm_dtls.split("#")[2], 20, 0));//10+20=30+2
					else
						contents.append(hisutil.appendSpace("A/C CLOSE DT", 12, 0)+ ": "+ hisutil.appendSpace(dis_date, 20, 0));//10+20=30+2
					contents.append("\n");
					printLine++;
					printLine++;
					
					//contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
					contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
					contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
					
					contents.append("\n");
					printLine++;
					printLine++;
					contents.append(hisutil.appendSpace("ADDRESS", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(address, 53, "~").get(0).toUpperCase(), 85, 0));
					/*contents.append(hisutil.appendSpace("DATE OF SURGERY", 16, 0)+ ": "+ hisutil.appendSpace("", 14, 0));*/  // commented by manisha gangwar date: 27.9.18
					contents.append("\n");
					printLine++;
					printLine++;
					if(strIsCreditCat.equals("1"))
					{
					contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 53, 0));
					contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 5, 0));
					}
					/*contents.append(hisutil.appendSpace("CREDIT NO.", 10, 0)+ ": "+ hisutil.appendSpace(creditno, 20, 0));*/
					contents.append("\n");
					printLine++;
					printLine++;

					//contents.append(MakeClientDtlStr(strHidden));
					contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0));
					contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type.toUpperCase(), 21, 0));
					contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept_name.toUpperCase(), 20, "~").get(0).toUpperCase(), 20, 0));  // changed by manisha gangwar date: 27.9.18

					contents.append("\n");
					printLine++;
					printLine++;
					
					
					
					
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					
					if (strBillType.equals("1")) //CONSOLIDATED
					{
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("GROUP CODE", 20,	0));
						contents.append(hisutil.appendSpace("GROUP NAME", 35,	0));
				//		contents.append(hisutil.appendSpace("AMOUNT ", 10,	0));
						//contents.append(hisutil.appendSpace("QTY.", 5,	0));
						
					//	if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
					//	{						
						//	contents.append(hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 18,	0));
				//		}
					//	else
						//{
							contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 16,	0));
					//	}
					//	
						//contents += "Description              Amount(Rs.) | Description               Amount\n";
						//printLine++;
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(Consolidated(strPatAccountNo,strHospitalCode, strBillType, strReceiptNo,strIsCreditCat,strBillNo));

						/*if(strCatGrp.equals("4"))
						{
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							contents.append(hisutil.appendSpace("S.No.", 7,	0));
							contents.append(hisutil.appendSpace("GROUP CODE", 20,	0));
							contents.append(hisutil.appendSpace("GROUP NAME", 41,	0));
							contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 16,	0));
							contents.append("\n");
							
							printLine++;
							printLine++;
							contents.append(TraspotationChrages_consolidated(strPatAccountNo,strHospitalCode, strBillType, strReceiptNo,strIsCreditCat));
							printLine++;
							contents.append("\n");
						}*/
					//	contents.append("----------------------------------------------------------------------------------------------");						
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					} 
					else //DETAILED
					{
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("GROUP CODE", 20,	0));
						contents.append(hisutil.appendSpace("GROUP NAME", 35,	0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 16,	0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(GroupAndDepositData_OnDetailedBill(strPatAccountNo,strHospitalCode, strBillType, strReceiptNo,strBillNo));
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 5,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 35,	0));
						contents.append(hisutil.appendSpace("DATE", 20,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 5,	0));
						
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{						
							contents.append(hisutil.appendSpace("CREDIT AMOUNT(Rs.)", 18,	0));
						}
						else
						{
							contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 18,	0));
						}
						
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(Detailed(strPatAccountNo, strHospitalCode,strBillType, strReceiptNo , strPatCatCode,strIsCreditCat,tempnet_pay,temp_expence,tempPayable,expn,strBillNo ));
						/*if(strCatGrp.equals("4"))
						{
							
							printLine++;
							printLine++;
							contents.append("\n");
							contents.append(hisutil.appendSpace("S.No.", 5,	0));
							contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 44,	0));
							contents.append(hisutil.appendSpace("DATE", 25,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 15,	0));
							contents.append(hisutil.appendSpace("QTY.", 5,	0));
							printLine++;
							printLine++;
							contents.append("\n");
							contents.append(TraspotationChrages(strPatAccountNo, strHospitalCode,strBillType, strReceiptNo , strPatCatCode,strIsCreditCat,tempnet_pay,temp_expence,tempPayable,expn ));
							
							//contents.append("\n");
							//contents.append(hisutil.appendSpace("TRANSPOTATION CHARGE FOR AROGYA SHREE PATIENT.",94, 1));
							contents.append("\n");
							printLine++;
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
						}*/
					}
					
					contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
					contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+NewPaymentmode,94, 0));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
					contents.append("\n");
					printLine++;
					
					contents.append(Footer(Footer , request , brt.getBillDisclaimerFinalBill()));
					contents.append("\n");
					printLine++;
					printLine++;
					
					//contents.append(hisutil.appendSpace("BILL VERIFIED BY : "+auditor.toUpperCase(), 94,	1));	// By manisha For CR 559			
				}
			}
			//isIPDFinal added as per the raebarli requirement by vipul on 20.07.2021
			request.setAttribute("isIPDFinal", "1");
			content = PrintContents(strBServiceId , "1", contents.toString() , request);
			System.out.println("Final Adjustment------->" + contents);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.FINAL_ADJUSTMENT() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * FINAL_ADJUSTMENT_DUP(vo) -- > This Method is Used to get WebRowSet for
	 * Approved By Combo
	 * 
	 * @throws Exception
	 * 
	 */

	public static boolean FINAL_ADJUSTMENT_DUP(String strBillNo,
			String strBServiceId, String strPatAccountNo,
			String strHospitalCode, String strBillType , HttpServletRequest request, int isDuplicateBill ) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null;

		String contents = new String();
		// String[] temp = null;

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String strCltDtl = null;
		String strAdmnDtl = null;
		String expense_amt = null;
		String[] arrAmt = null;
		String clt_amt = null;
	//	String dis_amt = null;
	//	String ser_tax_amt = null;

		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, "0", strBillNo, billConfigUtil
						.getGeneralDuplicatePrint(), "Final Adjustment Bill" , request,isDuplicateBill);
			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.FINAL_ADJUSTMENT_DUP(voObj);

				ws = voObj.getGblWs1();

				// NumberFormat df = new DecimalFormat(".##");

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				for (int k = 0; ws.next(); k++) {

					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					// expense_amt =
					// HisUtil.getAmountWithDecimal(ws.getString(6),
					// 2);

					arrAmt = (ws.getString(6)).split("\\^");
					expense_amt = HisUtil.getAmountWithDecimal(arrAmt[0], 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(arrAmt[1], 2);

					// pat_net_amt =
					// HisUtil.getAmountWithDecimal(ws.getString(7),
					// 2);
					clt_amt = HisUtil.getAmountWithDecimal(ws.getString(8), 2);
					strCltDtl = ws.getString(9);
					strAdmnDtl = ws.getString(10);
				//	dis_amt = ws.getString(11);
				//	ser_tax_amt = ws.getString(12);

					double cltamt = Double.parseDouble(clt_amt);

					/*
					 * if (strAdmnDtl.equals("0") || strAdmnDtl == null) { temp =
					 * strAdmnDtl.split("\\^");
					 * 
					 * adm_no = temp[0]; wardName = temp[2]; }
					 */

					// String tempAmt =
					// String.valueOf(df.format(Double.parseDouble(pat_net_amt)));
					contents += Header(Header1, Header2, Header3, Header4)
							+ "                          Final Adjustment Bill\n";
					printLine++;
					
					contents+= "                              BILL-CUM-RECEIPT\n";
					
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate)    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents  += hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;

					contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
					 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
					+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
					+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1], 13,0) +"\n";
					printLine++;
					

					// Temporary Date Plz get these Date from Admission Dtl

					contents += MakeClientDtlStr(strCltDtl);
					contents += MakeAddmissionDtl(strAdmnDtl);
					contents += "-----------------------------------------------------------------------\n";
					printLine++;

					if (strBillType.equals("1")) {
						contents += "Description              Amount(Rs.) | Description               Amount\n";
						printLine++;

						contents += "-----------------------------------------------------------------------\n";
						printLine++;
						contents += Consolidated_Dup(strPatAccountNo,
								strHospitalCode, strBillType);
					} else {
						contents += "Description                      Date         Qty.       Amount (Rs.)  \n";
						printLine++;

						contents += "-----------------------------------------------------------------------\n";
						printLine++;
						contents += Detailed_Dup(strPatAccountNo,
								strHospitalCode, strBillType);
					}

					contents += "\n-----------------------------------------------------------------------\n";
					printLine++;
					printLine++;

					if (cltamt > 0) {
						contents += "                                              Expense Amt   : "
								+ expense_amt + "\n";
						printLine++;
						/*
						 * contents += " Discount Amt : " + dis_amt + "\n";
						 * printLine++; contents += " Service Tax Amt : " +
						 * ser_tax_amt + "\n"; printLine++;
						 */
						contents += "                                      Paid by Third Party   : "
								+ clt_amt + "\n";
						printLine++;

						contents += "                                          Paid by Patient   : "
								+ pat_net_amt + "\n";
						printLine++;

					} else {
						contents += "                                              Expense Amt   : "
								+ expense_amt + "\n";
						printLine++;
						/*
						 * contents += " Discount Amt : " + dis_amt + "\n";
						 * printLine++; contents += " Service Tax Amt : " +
						 * ser_tax_amt + "\n"; printLine++;
						 */
						contents += "                                          Paid by Patient   : "
								+ pat_net_amt + "\n";
						printLine++;

						contents += "\n----------------------------------------------------------------------\n";
						printLine++;
						printLine++;
						contents += "     Rs. in Word : "
								+ hisutil.getAmountStr(pat_net_amt);
				//		contents += "\n                                                     Cashier           ";
						contents +="\n";
						printLine++;
						printLine++;
						
						if(brt.getBillDisclaimerDuplicatePrintRequired().equals("1")){
						
							contents += Footer(Footer , request , brt.getBillDisclaimerFinalBill());
							
						}else{
							
							contents += Footer(Footer , request , "");
						}
						
						

					}
				}

			}
			content = PrintContents(strBServiceId, "1", contents , request);			
			System.out.println("Final Adjustment Duplicate------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.FINAL_ADJUSTMENT_DUP() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;

		}

		return content;
	}

	
	public static boolean DAYEND_REPORT(String strSummaryNo,
			 String strHospitalCode , String strDayEndReportType , String strIsContentRequired , String strIsPayModeRequired , String strIsPayDtlsRequired , HttpServletRequest request, int isDuplicateBill )
	throws Exception {
		
		boolean content = false;
		StringBuffer strContents = new StringBuffer("");
		StringBuffer strSummaryDtls =  new StringBuffer("");
		StringBuffer strSummaryHeader =  new StringBuffer("");
		
		String strTotal = "0.00";
		String strBillNoOfRows = "37";
		String strPaymentMode = ""; 
		
		PrintBO bo = null;
		PrintVO vo = null;
		HisUtil hisutil = null;
		BillConfigUtil billConfigUtil = null;
		 
		
		try{
			
		bo = new PrintBO();
		vo = new PrintVO();
		
		hisutil = new HisUtil("billing", "PrintHLP");
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		
		vo.setStrBillNo(strSummaryNo);
		vo.setStrHospCode(strHospitalCode);
		
		bo.DAYEND_DTLS(vo);
		
		WebRowSet ws = vo.getGblWs1();
		
		if(ws != null && ws.next()){
			
			strTotal = ws.getString(6);
			
			strContents.append(hisutil.appendSpace(BOLDON +"DAY END REPORT"+ BOLDOFF , 55, 1) ).append("\n");
			printLine++;
			
			if (isDuplicateBill == 1) {

				strContents.append(hisutil.appendSpace(BOLDON +"(Duplicate)"+ BOLDOFF , 52, 1) ).append("\n");
				printLine++;
			}
			
			strContents.append("\n");
			printLine++;
			
			strSummaryDtls.append(" SUMM. NO./DATE : "+BOLDON +ws.getString(1)+ BOLDOFF);
			strSummaryDtls.append(hisutil.appendSpace(" USER NAME : "+ws.getString(14).toUpperCase(), 30, 1)+"\n");
			printLine++;
			
			if( (strDayEndReportType.equals("1") && billConfigUtil.getGeneralDayEndProcessType().equals("2")) ||
					(strDayEndReportType.equals("2") && billConfigUtil.getGeneralDayEndNonBillingProcessType().equals("2"))){
				strSummaryDtls.append(" COUNTER NAME   : "+ws.getString(10).toUpperCase()).append("\n");
				printLine++;
			}
			
			strContents.append(strSummaryDtls.toString());
			
			strContents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			
			
			if(strDayEndReportType.equals("1")){
				
				strContents.append(hisutil.appendSpace("RECEIPT CASH                        :", 45, 1) );
				System.out.println("rec cash"+ws.getString(2));
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(2), 2), 25, 1)+"\n" );
				printLine++;
				
				
				strContents.append(hisutil.appendSpace("REFUND CASH                         :", 45, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(4), 2), 25, 1)+"\n" );
				printLine++;
				
				
				
				if(Float.parseFloat(ws.getString(3)) > 0){
					
					strContents.append(hisutil.appendSpace("RECEIPT PRIVATE GRANT               :", 45, 1) );
					strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(3), 2), 25, 1)+"\n" );
					printLine++;
					
				}
				
					if(Float.parseFloat(ws.getString(12)) != 0){
					
					strContents.append(hisutil.appendSpace("REFUND PRIVATE GRANT                :", 45, 1) );
					strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(12), 2), 25, 1)+"\n" );
					printLine++;
					
				}

				if(Float.parseFloat(ws.getString(5)) > 0){
		
					strContents.append(hisutil.appendSpace("TOTAL PRIVATE GRANT RECEIPT         :", 45, 1) );
					strContents.append(hisutil.appendSpace(ws.getString(5), 25, 1)+"\n" );
					printLine++;
		
				}
				
				
				
			
				strContents.append("        ---------------------------------------------------------------"+BOLDON).append("\n");
				printLine++;
							
				strContents.append(hisutil.appendSpace("NET AMOUNT                          :", 45, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(6), 2), 25, 1) ).append("\n"+BOLDOFF);
				printLine++;
				
				strContents.append("        ---------------------------------------------------------------\n");
				printLine++;
				
				
				strContents.append(hisutil.appendSpace("HOSPITAL CHARGE                     :", 45, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(16), 2), 25, 1)+"\n" );
				printLine++;
				
				strContents.append(hisutil.appendSpace("PACKAGE CHARGE                      :", 45, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(15), 2), 25, 1)+"\n" );
				printLine++;
				
				float otherCharges = Float.parseFloat(ws.getString(6)) - ( Float.parseFloat(ws.getString(15)) + Float.parseFloat(ws.getString(16)) );
				
				strContents.append(hisutil.appendSpace("OTHER CHARGE                        :", 45, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(otherCharges, 2), 25, 1)+"\n" );
				printLine++;
				
				strContents.append("--------------------------------------------------------------------------------\n");
				printLine++;
				
				strContents.append(FORMFEED);
				
			}else{
				
				strContents.append(hisutil.appendSpace("TOTAL PAID PATIENT        :", 40, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(17), 2), 25, 1)+"\n" );
				printLine++;
				
				strContents.append(hisutil.appendSpace("TOTAL CASH COLLECTED      :", 40, 1) );
				strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(6), 2), 25, 1)+"\n" );
				printLine++;
				
				strContents.append("--------------------------------------------------------------------------------\n");
				printLine++;
				
				if(strDayEndReportType.equals("1")){
					
					strContents.append(FORMFEED);
					
				}
							
			}

		}
		
		
				
		
		if(strIsContentRequired.equals("1")){
			
			bo.DAYEND_PAYMENT_DTLS(vo);
			
			WebRowSet ws1 = vo.getGblWs2();
			int sNo = 0;
			
			float refundTotal = 0;
			float receivedTotal = 0;
			
			
			if(ws1 != null){
				
					
				
				if(strDayEndReportType.equals("1")){
					
					strSummaryHeader.append(strSummaryDtls.toString());
					
					strSummaryHeader.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					strSummaryHeader.append(hisutil.appendSpace(BOLDON+" SNO.", 5, 0) );
					strSummaryHeader.append(hisutil.appendSpace(" RECEIPT NO.", 13, 0) );
					strSummaryHeader.append(hisutil.appendSpace(" CR NO.", 14, 0) );
					strSummaryHeader.append(hisutil.appendSpace(" PAT. NAME", 24, 0) );
					//strSummaryHeader.append(hisutil.appendSpace(" PAY. MODE", 14, 0) );
					//strSummaryHeader.append(hisutil.appendSpace(" PAY. DTL.", 14, 0) );
					strSummaryHeader.append(hisutil.appendSpace(" REF. AMT.", 12, 0) );
					strSummaryHeader.append(hisutil.appendSpace(" REC. AMT."+BOLDOFF, 12, 0) ).append("\n");
					
					printLine++;
					
					
					strSummaryHeader.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					strContents.append(strSummaryHeader.toString());
					
					
				}else{
					
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					strContents.append(hisutil.appendSpace(BOLDON+" SNO.", 5, 0) );
					strContents.append(hisutil.appendSpace(" SERVICE NAME", 29, 0) );
					strContents.append(hisutil.appendSpace(" PAY. MODE", 14, 0) );
					strContents.append(hisutil.appendSpace(" PAY. DTL", 20, 0) );
					strContents.append(hisutil.appendSpace(" REC. AMT."+BOLDOFF, 12, 0) ).append("\n");
					
					printLine++;
										
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					
					
				}
				
				 				
				if(billConfigUtil.getBillLineOpdServices().length() > 0){
					strBillNoOfRows = billConfigUtil.getBillLineOpdServices();
				}
				
				while(ws1.next()){
					
						sNo++ ;
					
					if(strDayEndReportType.equals("1")){
						
						if(sNo % Integer.parseInt(strBillNoOfRows) == 0){
							
							strContents.append(FORMFEED);
							
							strContents.append(strSummaryHeader.toString());
							
						}
						
						if(!strPaymentMode.trim().equalsIgnoreCase(ws1.getString(6))){
							
							strPaymentMode = ws1.getString(6).toUpperCase();
							
							strContents.append(hisutil.appendSpace(BOLDON+"PAYMENT MODE :"+strPaymentMode+BOLDOFF, 75, 0) ).append("\n");
							printLine++;
							
						}
												
						
						strContents.append(hisutil.appendSpace(" "+String.valueOf(sNo), 5, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(1), 13, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(4).toUpperCase(), 14, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(5).toUpperCase(), 24, 0) );
						//strContents.append(hisutil.appendSpace(" PAY. MODE", 14, 0) );
						//strContents.append(hisutil.appendSpace(" PAY. DTL.", 14, 0) );
					 
						if(ws1.getString(3).trim().toUpperCase().equals("REFUND")){
							
							strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws1.getString(8), 2)+"", 11, 1) );
							strContents.append(hisutil.appendSpace("0.00 ", 11, 1) );
														
							refundTotal = refundTotal + Float.parseFloat(ws1.getString(8));
							
						}else{
							
							strContents.append(hisutil.appendSpace("0.00 ", 11, 1) );
							strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws1.getString(8), 2)+" ", 11, 1) );
							
							receivedTotal = receivedTotal + Float.parseFloat(ws1.getString(8));
							
						}
						 					
						
					}else{
						
						strContents.append(hisutil.appendSpace(" "+String.valueOf(sNo), 5, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(13), 29, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(6).toUpperCase(), 14, 0) );
						strContents.append(hisutil.appendSpace(" "+ws1.getString(7).toUpperCase(), 20, 0) );
						strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws1.getString(8), 2)+" ", 12, 1) );
												
					}
					
					strContents.append("\n");
					printLine++;
				}
			 
				
				if(strDayEndReportType.equals("1")){
					
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					strContents.append(hisutil.appendSpace(BOLDON+"TOTAL   :", 56, 1) );
					strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(refundTotal, 2)+" ", 13, 1) );
					strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(receivedTotal, 2)+" ", 11, 1) ).append("\n"+BOLDOFF);
					printLine++;
					
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					
				}else{
					
					
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					strContents.append(hisutil.appendSpace(BOLDON+"TOTAL   :", 67, 1) );
					strContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotal, 2), 14, 1) ).append("\n"+BOLDOFF);
					printLine++;
					strContents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
				}
				 
				
			}
						
		}
		
		
		content = PrintContents("0", "1", strContents.toString() , request);
		System.out.println("Day End------->" + strContents.toString());
					
					
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.DAYEND_REPORT() -->"
					+ e.getMessage());

		} finally {

			vo = null;
			bo = null;
			hisutil = null;
			billConfigUtil = null;

		}
		
		
		return content;
	}
	
	
	public static synchronized boolean PrintContents(String bServiceId , String receiptType , String contents , HttpServletRequest request) throws Exception
	{
		contents += FORMFEED;
		HisPrinter hisPrinter = null;
		
		try
		{
			 hisPrinter = new HisPrinter();
			 hisPrinter.printFile(contents, "Billing", request);
		}
		catch (Exception e) 
		{
				throw new Exception("PrintHLP.PrintContents()-->"+e.getMessage());				 
		}
		finally
		{
			hisPrinter = null;
		}
		
		return true;
	}

	
	public static synchronized boolean reprintFile(HttpServletRequest request)throws Exception{
		
		 
		
		HisPrinter hisPrinter = null;
		
		 try{
			 
			 hisPrinter = new HisPrinter();
			 
			 hisPrinter.reprintFile( "Billing", request);
			 
		 }catch (Exception e) {
			 
				throw new Exception(
				"PrintHLP.reprintFile()-->"+e.getMessage());
			 
		}finally{
			hisPrinter = null;
		}
			 
		
		 
			
		return true;
	}
	
	/**
	 * Consolidated_Dup(String ConCatVal) -- >
	 * 
	 * @throws Exception
	 */
	public static String Consolidated_Dup(String strPatAccountNo,
			String strHospitalCode, String strBillType) throws Exception {

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated_Dup()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated_Dup()--> Hospital Code Cannot be Blank or Invalid");
		}

		HisUtil hisutil = null;
		PrintVO voObj = null;
		PrintBO boObj = null;

		String contents = new String();
		WebRowSet ws = null;
		// String grp_id = null;
		// String net_amt = null;
		int k = 1;
		// ,flag=0;

		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.FINAL_ADJUSTMENT2_DUP(voObj);
			ws = voObj.getGblWs1();

			for (int i = 0; ws.next(); i++) {

				List<String> Tname = hisutil.breakString(ws.getString(1), 22,
						"~");

				if (k == 1) {
					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							contents += hisutil.appendSpace(Tname.get(j), 23,0)
									+ "  "
									+ hisutil.appendSpace(ws.getString(2), 12,0)
									+ "|";
						} else {
							contents += "\n";
							printLine++;
							contents += hisutil.appendSpace(Tname.get(j), 37,0)
									+ "|";
						}

					}
				} else {
					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							contents += hisutil.appendSpace(Tname.get(j), 23,0)
									+ "  "
									+ hisutil.appendSpace(ws.getString(2), 12,0)
									+ "\n";
							printLine++;
						} else {
							contents += "                                     | "
									+ hisutil.appendSpace(Tname.get(j), 38,0)
									+ "\n";
							printLine++;
						}

					}
					k = 0;

				}
			
				k++;
			}

			// vo.setStrPrintLine(printLine);

		} catch (Exception e) {
			throw new Exception("PrintHLP.Consolidated_Dup()-->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return contents;
	}

	/**
	 * Consolidated(String ConCatVal) -- >
	 * 
	 * @throws Exception
	 */
	public static String Consolidated(String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo, String strIsCreditCat,String strBillNo)
			throws Exception {
		StringBuffer trfContents = new StringBuffer();
		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		HisUtil hisutil = null;
		PrintVO voObj = null;
		PrintBO boObj = null;
		BillConfigUtil bcu = null;
		String strPoorCat =  null;
		String strPatCatCode= null;
		String bal= null;
		String amt=null;
		String grpcode=null;
		float paidAmt = 0;
		float payableAmt = 0;
		String esum=null;
		String packamt=null;
		String bedchg="0";
		String offchg="0";
		String onchg="0";
		String balamt="0";
		

		String contents[] =null;
		WebRowSet ws = null;
		WebRowSet ws3 = null;

		int k = 0;

		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			bcu = new BillConfigUtil(strHospitalCode);			
			strPoorCat = bcu.getIpdFreeCategory();

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);
			voObj.setStrBillNo(strBillNo);

			boObj.FINAL_ADJUSTMENT_GROUPDATAANDDEPOSITDATADETAILCONS(voObj);
			ws = voObj.getGblWs1();
			ws3 = voObj.getGblWs2();

			for (int i = 0; ws.next(); i++) 
			{
				contents = ws.getString(6).replace("^", "#").split("#");
				strPatCatCode=ws.getString(7);
				//System.out.println("ws.getString(2)"+ws.getString(2));
				//bal=String.valueOf(Double.parseDouble(ws.getString(2))-Double.parseDouble(contents[2]));
				//System.out.println("bal"+bal);
				//amt=ws.getString(2);
				amt=String.valueOf(Math.round(Float.parseFloat(contents[2])));
				grpcode=ws.getString(8);
				packamt=ws.getString(9);
				bedchg=ws.getString(10);
				offchg=ws.getString(11);
				onchg=ws.getString(12);
				balamt=ws.getString(13);
				//esum=String.valueOf(Math.round(sum));
				

				List<String> Tname = hisutil.breakString(ws.getString(1), 22,"~");
				for (int j = 0; j < Tname.size(); j++) {
				if (j == 0) 
				{
					trfContents.append(hisutil.appendSpace(Integer.toString(i+1), 7,	0));
					trfContents.append(hisutil.appendSpace(grpcode, 20,0));
					trfContents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 35,	0));
				//	trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(Double.parseDouble(netAmt)/Double.parseDouble(qty), 2), 10,	0));
				//	trfContents.append(hisutil.appendSpace(qty, 5,	0));
					trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(2), 2), 16,	0));
				} 
				else 
				{
					if (k == 0) 
					{
						trfContents.append("\n");
						printLine++;
						k++;
					}
				//	trfContents.append(hisutil.appendSpace(Tname.get(j),94,0));
				}

			/*	if (k == 1) {
					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							contents += hisutil.appendSpace(Tname.get(j), 23,0)
									+ "  "
									+ hisutil.appendSpace(ws.getString(2), 12,0)
									+ "|";
						} else {
							contents += "\n";
							printLine++;
							contents += hisutil.appendSpace(Tname.get(j), 37,0)
									+ "|";
						}

					}
				} else {
					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							contents += hisutil.appendSpace(Tname.get(j), 23,0)
									+ "  "
									+ hisutil.appendSpace(ws.getString(2), 12,0)
									+ "\n";
						//	printLine++;
						} else {
							contents += "                                     | "
									+ hisutil.appendSpace(Tname.get(j), 38,0)
									+ "\n";
							printLine++;
						}

					}
					k = 0;

				}
			
				k++;*/
			}
				trfContents.append("\n");
				printLine++;
			}
			
			
			trfContents.append("----------------------------------------------------------------------------------------------");
			trfContents.append("\n");
			printLine++;
			
			trfContents.append(hisutil.appendSpace(" EXPENSE AMOUNT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(contents[2],	2), 32,1)+"\n");
			printLine++;
			trfContents.append(hisutil.appendSpace(" CONCESSION", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(contents[4],	2), 32,1)+"\n");
			printLine++;
			if(Float.parseFloat(contents[2])>=Float.parseFloat(packamt))
				trfContents.append(hisutil.appendSpace(" EXEMPTION", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(packamt,	2), 32,1)+"\n");
			else
				trfContents.append(hisutil.appendSpace(" EXEMPTION", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(contents[2],	2), 32,1)+"\n");
			printLine++;
			trfContents.append(hisutil.appendSpace(" NET BILL AMOUNT (ROUNDED)", 44,1)     +" : "+hisutil.appendSpace(amt, 32,1)+"\n");
			printLine++;
			if(!strPoorCat.trim().equals(strPatCatCode))
			{
				trfContents.append("\n");
				trfContents.append("\n");
				printLine++;	
				trfContents.append(hisutil.appendSpace("PATIENT PAYMENTS ACCOUNT",94,0));
				trfContents.append("\n");
				printLine++;				
					
				trfContents.append("----------------------------------------------------------------------------------------------");
				
				trfContents.append("\n");
				printLine++;
					
				//trfContents.append(hisutil.appendSpace("S.No.", 5,	0));
				trfContents.append(hisutil.appendSpace("DATE", 11,	0));
				trfContents.append(hisutil.appendSpace("PAY MODE", 9,	0));
				trfContents.append(hisutil.appendSpace("RECEIPT NO.", 19,	0));
				//trfContents.append(hisutil.appendSpace("LETTER/TG/CARD NO.", 20,	0));
				trfContents.append(hisutil.appendSpace("ORG.", 20,	0));
				trfContents.append(hisutil.appendSpace("AMOUNT", 15,	0));
				trfContents.append("\n");
				printLine++;	
					
				for (int i = 0; ws3.next(); i++) 
				{
							
					//trfContents.append(hisutil.appendSpace(i+1+".", 5,	0));
					trfContents.append(FINALADVANCERECIEVEDDTL(hisutil, ws3.getString(1), ws3.getString(2), ws3.getString(3), ws3.getString(4), ws3.getString(5)));							
					paidAmt = paidAmt + Float.parseFloat(ws3.getString(3));		
					trfContents.append("\n");
					printLine++;
				}									
			    //trfContents.append(hisutil.appendSpace("----------" , 80 , 1));
				//trfContents.append(hisutil.appendSpace("To Be Realised:",94,0));
				/*trfContents.append("\n");
				printLine++;	
				trfContents.append("----------------------------------------------------------------------------------------------");
				
			    trfContents.append("\n");
				printLine++;
				printLine++;
				trfContents.append(hisutil.appendSpace(" AMOUNT PAID BY PATIENT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(amt,	2), 32,1)+"\n");
				printLine++;
				trfContents.append(hisutil.appendSpace(" BALANCE AMOUNT TO BE PAID", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(bal,	2), 32,1)+"\n");
				printLine++;
				trfContents.append(hisutil.appendSpace("----------\n" , 80 , 1));
				printLine++;
				printLine++;
				trfContents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(String.valueOf(bal)), 94,	0));*/
				
//					contents += "--------------------------------------------------------------------------------\n";
					//contents += "\n"+BOLDON+"ADVANCE RECEIVED"+BOLDOFF+"\n";
				//	contents += "--------------------------------------------------------------------------------\n";
				/*trfContents.append("\n");
				trfContents.append("\n");
				printLine++;	*/
				payableAmt = (-1)*Float.parseFloat(balamt); //paidAmt-Float.parseFloat(offchg)-Float.parseFloat(onchg);
				trfContents.append(hisutil.appendSpace("--------------------" , 74 , 1));
				trfContents.append("\n");
				printLine++;
				trfContents.append(hisutil.appendSpace("ALREADY BILLED TOTAL", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(paidAmt,	2), 12,1)+"\n"); // changed by manisha
				trfContents.append("\n");
				printLine++;
				printLine++;
				if(!strPoorCat.trim().equals(strPatCatCode) )
				{
					trfContents.append((payableAmt>=0? hisutil.appendSpace("BALANCE REFUNDED",44,1) +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt, 2),12,1)+"\n" : 
						hisutil.appendSpace("BALANCE PAID",44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt*-1, 2),12,1)+"\n"));
					
				}
				else
				{
					trfContents.append(hisutil.appendSpace("BALANCE REFUNDED",44,1) +" : "+hisutil.appendSpace("0.00",12,1)+"\n");
						payableAmt = 0;
				}
				
				//trfContents.append(hisutil.appendSpace("BALANCE TO BE REFUNDED", 76,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt,	2), 15,1)+"\n");
				trfContents.append("\n");
				printLine++;				
				
				/*trfContents.append("----------------------------------------------------------------------------------------------");
				trfContents.append("\n");
				printLine++;*/
				
			}
			trfContents.append("\n");
			printLine++;
			printLine++;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("PrintHLP.Consolidated()-->" + e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return trfContents.toString();
	}
	
	public static String TraspotationChrages_consolidated(String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo, String strIsCreditCat)
			throws Exception {
		StringBuffer trfContents = new StringBuffer();
		HisUtil hisutil = null;
		PrintVO voObj = null;
		PrintBO boObj = null;
		BillConfigUtil bcu = null;
		String strPoorCat =  null;
		String strPatCatCode= null;
		String bal= null;
		String amt=null;
		String grpcode=null;
		float paidAmt = 0;
		float payableAmt = 0;
		String esum=null;

		String contents[] =null;
		WebRowSet ws3 = null;

		int k = 0;

		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			bcu = new BillConfigUtil(strHospitalCode);			
			strPoorCat = bcu.getIpdFreeCategory();

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.TRANSPOTATION_CHARGE_CONSOLIDATED(voObj);
			ws3 = voObj.getTrasnpotationcolsolidatedws();
			
			
			while(ws3.next())
			{
				
				trfContents.append(hisutil.appendSpace("1", 7,	0));
				trfContents.append(hisutil.appendSpace(ws3.getString(8), 20,	0));
				trfContents.append(hisutil.appendSpace(ws3.getString(1), 41,	0));
				trfContents.append(hisutil.appendSpace(ws3.getString(2), 16,	0));
				trfContents.append("\n");
				printLine++;
				printLine++;
				trfContents.append(hisutil.appendSpace("TOTAL:",80, 1));
				trfContents.append(hisutil.appendSpace(ws3.getString(2),14, 1));
				
				
			}

			
			
		} catch (Exception e) {
			throw new Exception("PrintHLP.Consolidated()-->" + e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return trfContents.toString();
	}


	/**
	 * Detailed_Dup(String ConCatVal) -- >
	 * 
	 * @throws Exception
	 */
	public static String Detailed_Dup(String strPatAccountNo,
			String strHospitalCode, String strBillType) throws Exception {

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Detailed_Dup()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Detailed_Dup()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		String strGrpName1 = "";
		String strGrpName2 = "";
		String contents = new String();
		WebRowSet ws = null;
	//	int k = 1;
		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.FINAL_ADJUSTMENT2_DUP(voObj);
			ws = voObj.getGblWs1();

			for (int i = 0; ws.next(); i++) {

				strGrpName2 = (ws.getString(1)).trim();
				//
				if (strGrpName1.equals(strGrpName2)) {
					contents += FinalBillTariffDtl_dup(hisutil,
							ws.getString(3), ws.getString(4), ws.getString(2),
							ws.getString(5));
				} else {
					if (i == 0) {
						contents += "*" + strGrpName2 + "\n";
						printLine++;
					} else {
						printLine++;
						printLine++;
						contents += "----------------------------------------------------------------------\n";
						contents += "*" + strGrpName2 + "\n";
					}

					contents += FinalBillTariffDtl_dup(hisutil,
							ws.getString(3), ws.getString(4), ws.getString(2),
							ws.getString(5));
				}

				strGrpName1 = strGrpName2;
				contents += "\n";
				printLine++;
			}

		} catch (Exception e) {

			throw new Exception("PrintHLP.Detailed_Dup()-->" + e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return contents;
	}

	/**
	 * Detailed(String ConCatVal) -- >
	 * 
	 * @throws Exception
	 */
	public static String Detailed(String strPatAccountNo,String strHospitalCode, String strBillType, String strReceiptNo , String strPatCatCode , String strIsCreditCat, float tempnet_pay, float temp_expence, float tempPayable, float expn, String strBillNo) throws Exception 
	{
		if (strPatAccountNo == null && strPatAccountNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Detailed()--> Patient Account No. Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Detailed()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		String contents = new String();
		BillConfigUtil bcu = null;
		String strPoorCat =  null;
		
		String strGrpName1 = "";
		String strGrpName2 = "";
		WebRowSet ws = null;
		WebRowSet ws3 = null;
		
		float expAmt = 0;
		float expAmtAfterDisc = 0;
		float paidAmt = 0;
		float payableAmt = 0;
		float disAmt = 0;
		float amtpatient=0;
		float amtclient=0;
		String bedchg="0";
		String offchg="0";
		String onchg="0";
		String suramt="";
		String balamt="0";
		String zerotrfbalamt="0";
				
		// int k = 1;

		try 
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			bcu = new BillConfigUtil(strHospitalCode);			
			strPoorCat = bcu.getIpdFreeCategory();			
			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);
			voObj.setStrBillNo(strBillNo);
			boObj.FINAL_ADJUSTMENT_GROUPDATAANDDEPOSITDATADETAILCONS(voObj);
			ws = voObj.getGblWs1();//GROUP DATA
			ws3 = voObj.getGblWs2();//DEPOSIT DATA
			for (int i = 0; ws.next(); i++) 
			{
				if(!strPoorCat.trim().equals(strPatCatCode) || !ws.getString(10).trim().equals("104") )
				{
					if(ws.getString(1)!= null)
					{
						strGrpName2 = (ws.getString(1)).trim();
					}
					else
					{						
						strGrpName2 = "";
					}
					if (strGrpName1.equals(strGrpName2) ) 
					{
						contents +=hisutil.appendSpace(i+1+".", 5,	0);
						contents += FinalBillTariffDtl(hisutil, ws.getString(2), ws.getString(5), ws.getString(8), ws.getString(4));
						expAmt = expAmt + Float.parseFloat(ws.getString(5));
					} 
					else 
					{
						/*if (i == 0) 
						{
							contents += hisutil.appendSpace(strGrpName2, 94,	0);
							contents += "\n";
							printLine++;
						} 
						else 
						{
							contents += hisutil.appendSpace(strGrpName2, 94,	0);
							contents += "\n";
							printLine++;
						}*/

						contents +=hisutil.appendSpace(i+1+".", 5,	0);
						contents += FinalBillTariffDtl(hisutil, ws.getString(2), ws.getString(5), ws.getString(8), ws.getString(4));
						expAmt = expAmt + Float.parseFloat(ws.getString(5));
					}
					strGrpName1 = strGrpName2;
					contents += "\n";
					printLine++;
				}
				//bedchg=ws.getString(11);
				//offchg=ws.getString(12);
				//onchg=ws.getString(13);
				//balamt=ws.getString(14);
				/*if(i==(ws.size()-1))
				{
				suramt=ws.getString(11);
				//System.out.println("suramt"+suramt);
				if(!suramt.equals("0"))
				{
					contents +=hisutil.appendSpace("#", 5,	0)+hisutil.appendSpace("(SURC)-Surcharge", 35,	0)+hisutil.appendSpace(suramt.replace("^", "#").split("#")[1], 20,0)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(suramt.replace("^", "#").split("#")[0], 2), 10,	0)+hisutil.appendSpace("1", 5,	0)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(suramt.replace("^", "#").split("#")[0], 2), 18,	0)+"\n";
					contents += "\n";
					printLine++;
				}
				}*/
			}
			
			expAmtAfterDisc=expAmt+expn;//Plus because expn(disc) is in negative
			
			contents +="----------------------------------------------------------------------------------------------";
			contents +=   "\n";
			printLine++;
			printLine++;
			
			contents += hisutil.appendSpace(" TOTAL CHARGES", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(expAmt,	2), 32,1)+"\n";
			contents += hisutil.appendSpace(" CONCESSION", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(expn,	2), 32,1)+"\n";
			contents += hisutil.appendSpace(" TOTAL BILL AMOUNT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(expAmtAfterDisc,	2), 32,1)+"\n";
			contents +=   "\n";
			contents +=   "\n";
			printLine++;
			printLine++;	
			
			
			contents +="----------------------------------------------------------------------------------------------";
			contents +=   "\n";
			printLine++;
			printLine++;
			
			
			if(!strPoorCat.trim().equals(strPatCatCode))
			{
//				contents += "--------------------------------------------------------------------------------\n";
				//contents += "\n"+BOLDON+"ADVANCE RECEIVED"+BOLDOFF+"\n";
			//	contents += "--------------------------------------------------------------------------------\n";
			
				contents += hisutil.appendSpace("PATIENT PAYMENTS ACCOUNT",94,0);
				contents +=   "\n";
				printLine++;				
				
				contents +="----------------------------------------------------------------------------------------------";
				contents +=   "\n";
				printLine++;
				//contents +=hisutil.appendSpace("S.No.", 5,	0);
				contents +=hisutil.appendSpace("DATE", 11,	0);
				contents +=hisutil.appendSpace("PAY MODE", 11,	0);
				contents +=hisutil.appendSpace("RECEIPT NO.", 19,	0);
				//contents +=hisutil.appendSpace("LETTER/TG/CARD NO.", 20,	0);
				contents +=hisutil.appendSpace("ORG.", 20,	0);
				contents +=hisutil.appendSpace("AMOUNT", 15,	0);
				contents +=   "\n";
				printLine++;	
				
				for (int i = 0; ws3.next(); i++) 
				{
						
						//contents +=hisutil.appendSpace(i+1+".", 5,	0);
						contents +=FINALADVANCERECIEVEDDTL(hisutil, ws3.getString(1), ws3.getString(2), ws3.getString(3), ws3.getString(4), ws3.getString(5));							
						paidAmt = paidAmt + Float.parseFloat(ws3.getString(3));		
						zerotrfbalamt=ws3.getString(6);
						contents +=   "\n";
						printLine++;
				}								
			}	
			payableAmt = (-1)*Float.parseFloat(zerotrfbalamt); //paidAmt-Float.parseFloat(offchg)-Float.parseFloat(onchg);
			contents += hisutil.appendSpace("--------------------" , 74 , 1);
			contents +=   "\n";
			printLine++;
			contents += hisutil.appendSpace("ALREADY BILLED TOTAL", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(paidAmt,	2), 12,1)+"\n";  //changed by manisha dt:01.10.18
			contents +=   "\n";
			printLine++;
			printLine++;
			if(!strPoorCat.trim().equals(strPatCatCode) )
			{
				 contents += (payableAmt>=0? hisutil.appendSpace("BALANCE REFUNDED",44,1) +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt, 2),12,1)+"\n" : 
				 hisutil.appendSpace("BALANCE PAID",44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt*-1, 2),12,1)+"\n");
			}
			else
			{
					contents += hisutil.appendSpace("BALANCE REFUNDED",44,1) +" : "+hisutil.appendSpace("0.00",12,1)+"\n";
					payableAmt = 0;
			}
			//contents += hisutil.appendSpace("BALANCE TO BE REFUNDED", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt,	2), 32,1)+"\n";
			contents +=   "\n";
			printLine++;			
			
			contents +="----------------------------------------------------------------------------------------------";
			contents +=   "\n";
			printLine++;
			
			/*if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
			{
				contents += hisutil.appendSpace(" EXPENSE AMOUNT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(temp_expence,	2), 32,1)+"\n";
				printLine++;
				contents += hisutil.appendSpace(" AMOUNT PAID BY PATIENT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(tempnet_pay,	2), 32,1)+"\n";
				printLine++;
				contents += hisutil.appendSpace(" AMOUNT PAID BY CLIENT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(tempPayable,	2), 32,1)+"\n";
				printLine++;
				contents += hisutil.appendSpace("----------\n" , 80 , 1);
				printLine++;
				printLine++;
				contents += hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(String.valueOf(tempnet_pay)), 94,	0);
				contents +="\n";
				printLine++;
				printLine++;
			}
			else
			{
			contents += hisutil.appendSpace(" EXPENSE AMOUNT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(expAmt,	2), 32,1)+"\n";
			printLine++;
			
			if(!strPoorCat.trim().equals(strPatCatCode) )
			{
					contents += hisutil.appendSpace(" PAID AMOUNT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(paidAmt,	2), 32,1)+"\n";
					printLine++;
			}
			else
			{
					contents += hisutil.appendSpace(" POOR FREE GRANT", 44,1)     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(0 - expAmt,	2), 32,1)+"\n";
					printLine++;
			}
			if(!strPoorCat.trim().equals(strPatCatCode) )
			{
					contents += (payableAmt>=0? hisutil.appendSpace(" PAYABLE AMOUNT",44,1) : 
					hisutil.appendSpace(" REFUNDABLE AMOUNT",44,1))     +" : "+hisutil.appendSpace(HisUtil.getAmountWithDecimal(payableAmt, 2),32,1)+"\n";
			}
			else
			{
					contents += hisutil.appendSpace(" PAYABLE AMOUNT",44,1) +" : "+hisutil.appendSpace("0.00",32,1)+"\n";
					payableAmt = 0;
			}				
			printLine++;
			contents += hisutil.appendSpace("----------\n" , 80 , 1);
			printLine++;
			printLine++;
			contents += hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(String.valueOf(payableAmt)), 94,	0);
			contents +="\n";
			printLine++;
			printLine++;
			}*/
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
			throw new Exception("PrintHLP.Detailed()-->" + e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			ws = null;
			ws3 = null;
			hisutil = null;
		}

		return contents;
	}
	
	
	public static String TraspotationChrages(String strPatAccountNo,String strHospitalCode, String strBillType, String strReceiptNo , String strPatCatCode , String strIsCreditCat, float tempnet_pay, float temp_expence, float tempPayable, float expn) throws Exception 
	{
		if (strPatAccountNo == null && strPatAccountNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Detailed()--> Patient Account No. Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Detailed()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		String contents = new String();
		BillConfigUtil bcu = null;
		String strPoorCat =  null;
		
		String strGrpName1 = "";
		String strGrpName2 = "";
		WebRowSet ws3 = null;
		StringBuffer trfContents = new StringBuffer();
		float expAmt = 0;
		float paidAmt = 0;
		float payableAmt = 0;
		float disAmt = 0;
		float amtpatient=0;
		float amtclient=0;
				
		// int k = 1;

		try 
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			bcu = new BillConfigUtil(strHospitalCode);			
			strPoorCat = bcu.getIpdFreeCategory();			
			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.TRANSPOTATION_CHARGE(voObj);
			ws3 = voObj.getTranspotationchrgs();
			
			
			
			
				
				
			/*	for (int i = 0; ws3.next(); i++) 
				{
						
						//contents +=hisutil.appendSpace(i+1+".", 5,	0);
						contents +=FINALADVANCERECIEVEDDTL(hisutil, ws3.getString(1), ws3.getString(2), ws3.getString(3), ws3.getString(4), ws3.getString(5));							
						paidAmt = paidAmt + Float.parseFloat(ws3.getString(3));		
						contents +=   "\n";
						printLine++;
				}	*/
				while(ws3.next())
				{
					
					trfContents.append(hisutil.appendSpace("1", 5,	0));
					trfContents.append(hisutil.appendSpace(ws3.getString(2), 44,	0));
					//trfContents.append(hisutil.appendSpace("", 20,	0));
					trfContents.append(hisutil.appendSpace(ws3.getString(8), 25,	0));
					trfContents.append(hisutil.appendSpace(ws3.getString(3), 15,	0));
					trfContents.append(hisutil.appendSpace(ws3.getString(4), 5,	0));
					trfContents.append("\n");
					printLine++;
					printLine++;
					trfContents.append(hisutil.appendSpace("TOTAL:",80, 1));
					trfContents.append(hisutil.appendSpace(ws3.getString(5),14, 1));
					
					
				}
				
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
			throw new Exception("PrintHLP.Detailed()-->" + e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			ws3 = null;
			hisutil = null;
		}

		return trfContents.toString();
	}

	private static String FINALADVANCERECIEVEDDTL(HisUtil hisutil, String reciptNo,String date, String netamount, String cltdetails, String org) throws Exception 
	{
		StringBuffer trfContents = new StringBuffer();
		/*trfContents.append(hisutil.appendSpace("RECEIPT NO: "+reciptNo, 35,	0));
		trfContents.append(hisutil.appendSpace("DATED:"+date, 20,	0));
		trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(netamount, 2), 10,	0));
		trfContents.append(hisutil.appendSpace("1", 5,	0));
		trfContents.append(hisutil.appendSpace("", 3,	1)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(netamount, 2), 15,	0));*/
		trfContents.append(hisutil.appendSpace(date, 11,	0));
		trfContents.append(hisutil.appendSpace(reciptNo.replace("(","#").split("#")[1].toUpperCase(), 11,	0));
		trfContents.append(hisutil.appendSpace(reciptNo.replace("(","#").split("#")[0], 19,	0));
		//trfContents.append(hisutil.appendSpace(hisutil.breakString(cltdetails, 20, "~").get(0).toUpperCase(), 20,	0));
		trfContents.append(hisutil.appendSpace(hisutil.breakString(org, 20, "~").get(0).toUpperCase(), 20,	0));
		trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(netamount, 2), 15,	0));
		
		return trfContents.toString();
	}


	private static String FinalBillTariffDtl(HisUtil hisutil, String trfName,String netAmt, String strDate, String qty) throws Exception 
	{
		StringBuffer trfContents = new StringBuffer();
		int k = 0;
		List<String> Tname = hisutil.breakString(trfName, 35, "~");

		for (int j = 0; j < Tname.size(); j++) 
		{
			if (j == 0) 
			{
				//trfContents.append(hisutil.appendSpace(Integer.toString(j+1), 5,	0));
				trfContents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 35,	0));
				trfContents.append(hisutil.appendSpace(strDate, 20,0));
				trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(Double.parseDouble(netAmt)/Double.parseDouble(qty), 2), 10,	0));
				trfContents.append(hisutil.appendSpace(qty, 5,	0));
				trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(netAmt, 2), 18,	0));
			} 
			else 
			{
				if (k == 0) 
				{
					trfContents.append("\n");
					printLine++;
					k++;
				}
				//trfContents.append(hisutil.appendSpace(Tname.get(j),94,0));
			}
		}

		return trfContents.toString();
	}

	private static String FinalBillTariffDtl_dup(HisUtil hisutil,
			String trfName, String netAmt, String strDate, String qty) {

		String trfContents = "";
		int k = 0;
		List<String> Tname = hisutil.breakString(trfName, 31, "~");

		for (int j = 0; j < Tname.size(); j++) {
			if (j == 0) {
				trfContents += hisutil.appendSpace(Tname.get(j), 32,0) + " "
						+ hisutil.appendSpace(strDate, 12,0) + " "
						+ hisutil.appendSpace(qty, 11,1) + " " + netAmt;
			} else {
				if (k == 0) {
					trfContents += "\n";
					printLine++;
					k++;
				}

				//trfContents += Tname.get(j);
			}
		}

		return trfContents;
	}

	/**
	 * method used to update the print status (in case of Bill not printed
	 * properly)
	 * 
	 * @param strBillNo
	 * @param strReceiptNo
	 * @param strHospitalCode
	 * @throws Exception
	 */
	public static void updatePrintStatus(String strBillNo, String strReceiptNo,
			String strHospitalCode, String strPrintFlag) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.updatePrintStatus()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strReceiptNo == null && strReceiptNo.length() > 0) {

			throw new Exception(
					"PrintHLP.updatePrintStatus()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.updatePrintStatus()--> Hospital Code Cannot be Blank or Invalid");
		}

		if (strPrintFlag == null) {

			strPrintFlag = "0";
		}

		PrintVO voObj = null;
		PrintBO boObj = null;

		try {

			voObj = new PrintVO();
			boObj = new PrintBO();

			voObj.setStrBillNo(strBillNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrPrintFlag(strPrintFlag);

			boObj.UPDATE_PRINT_STATUS(voObj);

		} catch (Exception e) {

			throw new Exception("PrintHLP.updatePrintStatus()-->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;

		}

	}

	private static String receiptPrint(String strHospitalCode,
			String strReceiptNo, String strBillNo, String strDuplicatePrint,
			String strReceiptName , HttpServletRequest request, int isDuplicateBill ) throws Exception {

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strReceiptName == null && strReceiptName.length() < 1) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Name Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();

		int receiptNameLength = strReceiptName.trim().length();

		int spaceReq = (70 - receiptNameLength) / 2;

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		
		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptNo(strReceiptNo);

			if (strDuplicatePrint.trim().equals("1")) {

				boObj.DUP_CONSOLIDATED_PRINT(voObj);

			} else {

				boObj.DUP_REPLICA_PRINT(voObj);
			}

			ws = voObj.getGblWs1();

			for (int i = 0; ws.next(); i++) {
			
				bill_no = ws.getString(1);

				bill_date = ws.getString(2);

				patient_name = ws.getString(3).replace("^", "#").split("#");

				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				adm_no = ws.getString(6);
				
				String strAmt = ws.getString(7);
				dept = ws.getString(8);
				String ward = ws.getString(9);
				if (strDuplicatePrint.trim().equals("1")) {
					strAmt = ws.getString(8);
				}
				
				pat_net_amt = HisUtil.getAmountWithDecimal(strAmt , 2);

				contents += Header(Header1, Header2, Header3, Header4)
						+ hisutil.appendSpace("", spaceReq,0)+strReceiptName+ "\n";
				printLine++;
				
				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
				printLine++;
				
				contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
				printLine++;
				printLine++;
				
				contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
				+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
				printLine++;
				printLine++;
				
				contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
				 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
				printLine++;
				printLine++;
				
				
				contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
				 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
				printLine++;
				 					
				
				contents += "--------------------------------------------------------------------------------\n";
				printLine++;
				
				contents += " TOTAL AMOUNT    : "
					+ hisutil.appendSpace(hisutil.getAmountStr(pat_net_amt), 75,1)+ "\n";
				printLine++;
				
				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);

			//	contents += "\n\n                                                     Cashier           ";
				contents +="\n\n";
				printLine++;
				printLine++;
				printLine++;
				
				contents += Footer(Footer , request ,"");

			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.PART_PAYMENT_DUP() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return contents;

	}
	
	public static Map populateGroupMapForPrinting(String[] tariffDetails,Map tariffPrintMap,BillConfigUtil brt)
	{

		////for al charges other than consumable	
		for(int i=0;i<tariffDetails.length;i++)
		{
			String[] arrayTariffDetail=tariffDetails[i].split("#");
			if(!arrayTariffDetail[1].equals(brt.getStrConsumableChargesGroupId())){
				 List groupWiseTariffList=new ArrayList();
				 String strDirectTariffList=tariffDetails[i];
				 
				 String groupKey=arrayTariffDetail[1]+"@"+arrayTariffDetail[2];
				 if(tariffPrintMap.containsKey(groupKey))
				 {
					 groupWiseTariffList=(ArrayList)tariffPrintMap.get(groupKey);
					 
				 }
				 groupWiseTariffList.add(strDirectTariffList);
				 tariffPrintMap.put(groupKey, groupWiseTariffList);
			}
		}
		///adding consumable carges at the end
		for(int i=0;i<tariffDetails.length;i++)
		{
			String[] arrayTariffDetail=tariffDetails[i].split("#");
			if(arrayTariffDetail[1].equals(brt.getStrConsumableChargesGroupId())){
				 List groupWiseTariffList=new ArrayList();
				 String strDirectTariffList=tariffDetails[i];
				 
				 String groupKey=arrayTariffDetail[1]+"@"+arrayTariffDetail[2];
				 if(tariffPrintMap.containsKey(groupKey))
				 {
					 groupWiseTariffList=(ArrayList)tariffPrintMap.get(groupKey);
					 
				 }
				 groupWiseTariffList.add(strDirectTariffList);
				 tariffPrintMap.put(groupKey, groupWiseTariffList);
			}
		}
		return  tariffPrintMap;
	
	}
	/*
	 * 
	 * One has to pass either content string buffer
	 */
	public static double iterateMapForPrinting(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt)
	{
		HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
		int tariffLen = 35,i=0;
		double concessionAmt=0.00;
		double disamt=0.00;
		String strRate = "0";
		
		if (isServiceDiscountReq == 0)
		{
			tariffLen = 40;
		}
		try
		{
			Set groupSet = tariffPrintMap.keySet();
			Iterator groupSetItr = groupSet.iterator();
			String strTariffDetail = "";
			while (groupSetItr.hasNext())
			{
				String groupkey = (String) groupSetItr.next();
				String[] groupDetail = groupkey.split("@");
				List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
				Iterator groupTariffListItr = groupTariffList.iterator();                
				// /adding group name header for all tariff other that Consumable Charges

				/*if (!groupDetail[0].equals(brt.getStrConsumableChargesGroupId()))
				{
					if(BillConfigUtil.PRINT_MODE.equals("2"))//DMP Printing
					{
						contents.append(BOLDON+ hisutil.appendSpace(" "+ groupDetail[1].toUpperCase(), 79, 0)+ BOLDOFF);
						contents.append("\n");
					}
					else
					{
						contents.append(hisutil.appendSpace(" "+ groupDetail[1].toUpperCase(), 79, 0));
						contents.append("\n");
					}						
				}*/

				while (groupTariffListItr.hasNext())
				{
					strTariffDetail = (String) groupTariffListItr.next();
					String strTempVal[] = strTariffDetail.replace("^", "#").split("#");

					String str_tariff_name = strTempVal[0];
					String str_billed_qty = strTempVal[1];
					String x=strTempVal[2];
					if(strTempVal[2].contains("%"))
					    x=strTempVal[2].substring(0, strTempVal[2].lastIndexOf("%")-1);
					String str_dis_amt = HisUtil.getAmountWithDecimal(x, 2);
					String str_S_Tax = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
					String str_net_bill_amt = HisUtil.getAmountWithDecimal(strTempVal[4], 2);
					

					List<String> Tname = null;

					if (isServiceDiscountReq == 0)
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "-");
					} 
					else
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];
						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						//Tname = hisutil.breakString(str_tariff_name	.toUpperCase(), tariffLen, "-");
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "-");
					}

					for (int j = 0; j < Tname.size(); j++)
					{
						//i++;
						if (j == 0)
						{
							i++;
							if (isServiceDiscountReq == 0)
							{
								
								contents.append(hisutil.appendSpace(Integer.toString(i), 5,0));
								contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase(), 40,0));
								contents.append(hisutil.appendSpace("---", 15,0));
								contents.append(hisutil.appendSpace(strRate, 10,0));
								contents.append(hisutil.appendSpace(" "+str_billed_qty.replace(" ", "#").split("#")[0], 8,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(str_net_bill_amt, 2),8, 1)+hisutil.appendSpace("", 7,	0));
								contents.append("\n");
								printLine++;								
							} 
							else
							{
								contents.append(hisutil.appendSpace(Integer.toString(i), 6,	0));
								contents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 40,	0));
								contents.append(hisutil.appendSpace("---", 11,	0));
								contents.append(hisutil.appendSpace(strRate, 10,0));
								contents.append(hisutil.appendSpace(" "+str_billed_qty, 6, 0));
								if(strTempVal[2].contains("%"))
								{
									disamt=(Double.parseDouble(strRate)*Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0]))-Double.parseDouble(str_net_bill_amt);
									contents.append(hisutil.appendSpace(String.valueOf(disamt), 7, 1)+hisutil.appendSpace("", 3,	0));
									concessionAmt=concessionAmt+disamt;
								}
								else
								{
								    contents.append(hisutil.appendSpace(str_dis_amt, 7, 1)+hisutil.appendSpace("", 3,	0));
								    concessionAmt=concessionAmt+Double.parseDouble(str_dis_amt);
								}
								
								//contents.append(hisutil.appendSpace(str_S_Tax, 10, 1));	
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(str_net_bill_amt, 2),10, 1));
								contents.append("\n");
								printLine++;								
							}
						}
						/*else
						{
							printLine++;
							contents.append(" "+ hisutil.appendSpace(Tname.get(j).toUpperCase(), 78, 0));
							contents.append("\n");
						}*/
					}
				}
			}
		} 
		catch (Exception e)
		{
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing","PrintHLP->iterateMapForPrinting()", msgStr);
			eObj = null;
		}
		return concessionAmt;
	}	
	
	//not in use..
	public static void iterateMapForEstimationPrinting(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt)
	{
		HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
		int tariffLen = 32;
		String strRate = "0";
		if (isServiceDiscountReq == 0)
		{
			tariffLen = 45;
		}
		try
		{
			Set groupSet = tariffPrintMap.keySet();
			Iterator groupSetItr = groupSet.iterator();
			String strTariffDetail = "";
			while (groupSetItr.hasNext())
			{
				String groupkey = (String) groupSetItr.next();
				String[] groupDetail = groupkey.split("@");
				List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
				Iterator groupTariffListItr = groupTariffList.iterator();

				// /adding group name header for all tariff other that Consumable Charges

				if (!groupDetail[0].equals(brt.getStrConsumableChargesGroupId()))
				{
					if(BillConfigUtil.PRINT_MODE.equals("2"))//DMP Printing
					{
						contents.append(BOLDON+ hisutil.appendSpace(" "+ groupDetail[1].toUpperCase(), 79, 0)+ BOLDOFF);
						contents.append("\n");
					}
					else
					{
						contents.append(hisutil.appendSpace(" "+ groupDetail[1].toUpperCase(), 79, 0));
						contents.append("\n");
					}						
				}

				while (groupTariffListItr.hasNext())
				{
					strTariffDetail = (String) groupTariffListItr.next();
					String strTempVal[] = strTariffDetail.replace("^", "#").split("#");

					String str_tariff_name = strTempVal[0];
					String str_billed_qty = strTempVal[1];
					String str_dis_amt = HisUtil.getAmountWithDecimal(strTempVal[2], 2);
					String str_S_Tax = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
					String str_net_bill_amt = HisUtil.getAmountWithDecimal(strTempVal[4], 2);

					List<String> Tname = null;

					if (isServiceDiscountReq == 0)
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "-");
					} 
					else
					{
						Tname = hisutil.breakString(str_tariff_name	.toUpperCase(), tariffLen, "-");
					}

					for (int j = 0; j < Tname.size(); j++)
					{
						if (j == 0)
						{
							if (isServiceDiscountReq == 0)
							{
								contents.append(hisutil.appendSpace(" "	+ Tname.get(j).toUpperCase(), 48, 0)+ hisutil.appendSpace(strRate, 12, 1)
										+ hisutil.appendSpace(str_billed_qty.replace(" ", "#").split("#")[0], 6, 1));
							} 
							else
							{
								contents.append(hisutil.appendSpace("  "+ Tname.get(j), 35, 0)+ hisutil.appendSpace(str_billed_qty, 9, 1)
												+ hisutil.appendSpace(str_dis_amt, 8, 1)+ hisutil.appendSpace(str_S_Tax, 10, 1));
							}
							contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(str_net_bill_amt, 2),13, 1));
							contents.append("\n");
							printLine++;
						} 
						else
						{
							printLine++;
							contents.append(" "+ hisutil.appendSpace(Tname.get(j).toUpperCase(), 75, 0));
							contents.append("\n");
						}
					}
				}
			}
		} 
		catch (Exception e)
		{
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing","PrintHLP->iterateMapForPrinting()", msgStr);
			eObj = null;
		}
	}
	
	public static Map populateCreditLetterMapForPrinting(String[] tariffDetails,Map tariffPrintMap,BillConfigUtil brt)
	{
		try
		{
		////for al charges other than consumable	
			for(int i=0;i<tariffDetails.length;i++)
			{
				System.out.println("tariffDetails[i]"+tariffDetails[i]);
				String[] arrayTariffDetail=tariffDetails[i].split("#");
				if(!arrayTariffDetail[1].equals(brt.getStrConsumableChargesGroupId()))
				{
					 List groupWiseTariffList=new ArrayList();
					 String strDirectTariffList=tariffDetails[i];
					 
					 //String groupKey=arrayTariffDetail[1]+"@"+arrayTariffDetail[2]+"@"+arrayTariffDetail[3]+"@"+arrayTariffDetail[4];
					 String groupKey=arrayTariffDetail[3]+"@"+arrayTariffDetail[4];
					 
					 System.out.println("the valuie of group key is "+groupKey);
					 if(tariffPrintMap.containsKey(groupKey))
					 {
						 groupWiseTariffList=(ArrayList)tariffPrintMap.get(groupKey);
						 
					 }
					 groupWiseTariffList.add(strDirectTariffList);
					 tariffPrintMap.put(groupKey, groupWiseTariffList);
				}
			}
			/*///adding consumable carges at the end
			for(int i=0;i<tariffDetails.length;i++)
			{
				String[] arrayTariffDetail=tariffDetails[i].split("#");
				if(arrayTariffDetail[1].equals(brt.getStrConsumableChargesGroupId())){
					 List groupWiseTariffList=new ArrayList();
					 String strDirectTariffList=tariffDetails[i];
					 
					 String groupKey=arrayTariffDetail[1]+"@"+arrayTariffDetail[2]+"@"+arrayTariffDetail[3]+"@"+arrayTariffDetail[4];
					 if(tariffPrintMap.containsKey(groupKey))
					 {
						 groupWiseTariffList=(ArrayList)tariffPrintMap.get(groupKey);
						 
					 }
					 groupWiseTariffList.add(strDirectTariffList);
					 tariffPrintMap.put(groupKey, groupWiseTariffList);
				}
			}*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return  tariffPrintMap;
	
	}
	public static void iterateCreditMapForPrinting(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt)
	{
		HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
		int tariffLen = 28,i=0;
		String strRate = "0";
		
		if (isServiceDiscountReq == 0)
		{
			tariffLen = 28;
		}
		try
		{
			Set groupSet = tariffPrintMap.keySet();
			Iterator groupSetItr = groupSet.iterator();
			String strTariffDetail = "";
					
			while (groupSetItr.hasNext())
			{
				String groupkey = (String) groupSetItr.next();
				String[] groupDetail = groupkey.split("@");
				List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
				Iterator groupTariffListItr = groupTariffList.iterator();
                
				// /adding group name header for all tariff other that Consumable Charges
               /* if (!groupDetail[0].equals(brt.getStrConsumableChargesGroupId()))
				{*/
					if(BillConfigUtil.PRINT_MODE.equals("2"))//DMP Printing
					{
						//credit letter no..
						contents.append(BOLDON+ hisutil.appendSpace("CREDIT LETTER NO.: "+ groupDetail[1].toUpperCase(),94,0)+ BOLDOFF);
						contents.append("\n");
						//group name..
						/*contents.append(BOLDON+hisutil.appendSpace("Group:"+ groupDetail[1].toUpperCase(),87,0)+ BOLDOFF);
						contents.append("\n");*/
					}
					else
					{
						contents.append(hisutil.appendSpace("CREDIT LETTER NO.: "+ groupDetail[1].toUpperCase(),94,0));
						contents.append("\n");
						printLine++;
						/*contents.append(hisutil.appendSpace("Group:"+ groupDetail[1].toUpperCase(),87,0));
						contents.append("\n");
						printLine++;*/
					}						
			//	}
                

				while (groupTariffListItr.hasNext())
				{
					strTariffDetail = (String) groupTariffListItr.next();
					String strTempVal[] = strTariffDetail.replace("^", "#").split("#");

					String str_tariff_name = strTempVal[0];
					String str_billed_qty = strTempVal[1];
					String str_dis_amt = HisUtil.getAmountWithDecimal(strTempVal[2], 2);
					String str_S_Tax = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
					String str_net_bill_amt = HisUtil.getAmountWithDecimal(strTempVal[4], 2);
					String strPaidByPatient=String.valueOf(HisUtil.getAmountWithDecimal(strTempVal[5],2));
					String strPaidByClient=String.valueOf(HisUtil.getAmountWithDecimal(strTempVal[6],2));
					// (AmtPaidByClient+AmtPaidByPat)*Qty
					String strTotAmount="";					
					List<String> Tname = null;

					if (isServiceDiscountReq == 0)
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "~");
					} 
					else
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						//Tname = hisutil.breakString(str_tariff_name	.toUpperCase(), tariffLen, "-");
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "~");
					}

					strTotAmount=String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(strRate))* Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0]),2));
					for (int j = 0; j < Tname.size(); j++)
					{
						if (j == 0)
						{
							i++;
							if (isServiceDiscountReq == 0)
							{
								contents.append(hisutil.appendSpace(Integer.toString(i), 5,0));
								contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase().trim(), 29,0));
								contents.append(hisutil.appendSpace("---", 10,0));
								contents.append(hisutil.appendSpace(strRate, 10,0));
								contents.append(hisutil.appendSpace(" "+str_billed_qty.replace(" ", "#").split("#")[0], 8,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotAmount, 2),7, 1)+hisutil.appendSpace("", 3,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByPatient, 2),9, 1)+hisutil.appendSpace("", 3,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByClient, 2),8, 1)+hisutil.appendSpace("", 2,	0));
								contents.append("\n");
								printLine++;
							} 
							else
							{
								contents.append(hisutil.appendSpace(Integer.toString(i), 5,0));
								contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase().trim(), 29,0));
								contents.append(hisutil.appendSpace("---", 10,0));
								contents.append(hisutil.appendSpace(strRate, 10,0));
								contents.append(hisutil.appendSpace(" "+str_billed_qty.replace(" ", "#").split("#")[0], 6,	0));
								contents.append(hisutil.appendSpace(" "+str_dis_amt.replace(" ", "#").split("#")[0], 6,	0));
								//contents.append(hisutil.appendSpace(" "+str_S_Tax.replace(" ", "#").split("#")[0], 6,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotAmount, 2),7, 1)+hisutil.appendSpace("", 2,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByPatient, 2),8, 1)+hisutil.appendSpace("", 2,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByClient, 2),8, 1)+hisutil.appendSpace("", 1,	0));
								contents.append("\n");
								printLine++;								
							}							
							//contents.append("\n");
							//printLine++;
							//contents.append("\n");
							//printLine++;
						} 
						/*else
						{
							printLine++;
							contents.append(" "+ hisutil.appendSpace(Tname.get(j).toUpperCase(), 75, 0));
							contents.append("\n");
						}*/
					}
				}
			}
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing","PrintHLP->iterateMapForPrinting()", msgStr);
			eObj = null;
		}
		
		
	}	
	
	public static double iterateEstimationMapForPrinting(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt)
	{
		HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
		int tariffLen = 32,i=0;
		String strRate = "0";
		double tot=0.00;
		
		try
		{
			Set groupSet = tariffPrintMap.keySet();
			Iterator groupSetItr = groupSet.iterator();
			String strTariffDetail = "";
			
			
		
			while (groupSetItr.hasNext())
			{
				String groupkey = (String) groupSetItr.next();
				String[] groupDetail = groupkey.split("@");
				List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
				Iterator groupTariffListItr = groupTariffList.iterator();
                             

				while (groupTariffListItr.hasNext())
				{
					strTariffDetail = (String) groupTariffListItr.next();
					String strTempVal[] = strTariffDetail.replace("^", "#").split("#");

					String str_tariff_name = strTempVal[0];
					String str_billed_qty = strTempVal[1];
					String str_dis_amt = HisUtil.getAmountWithDecimal(strTempVal[2], 2);
					String str_S_Tax = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
					String str_net_bill_amt = HisUtil.getAmountWithDecimal(strTempVal[4], 2);
					String strPaidByPatient=strTempVal[5];
					String strPaidByClient=strTempVal[6];
					// (AmtPaidByClient+AmtPaidByPat)*Qty
					String strTotAmount="";	
					List<String> Tname = null;
					

					if (isServiceDiscountReq == 0)
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "-");
					} 
					else
					{
						String strTemp[] = str_tariff_name.replace("@", "#").split("#");
						strRate = strTemp[1].replace("/", "#").split("#")[0];

						if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
						{
							strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						}
						//Tname = hisutil.breakString(str_tariff_name	.toUpperCase(), tariffLen, "-");
						Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "-");
					}

					strTotAmount=String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(strRate))* Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0]),2));
					tot += Double.parseDouble(strTotAmount);
					for (int j = 0; j < Tname.size(); j++)
					{
						i++;
						if (j == 0)
						{
							
								contents.append(hisutil.appendSpace(Integer.toString(i), 7,0));
								contents.append(hisutil.appendSpace(Tname.get(j).toUpperCase().trim(), 35,0));
								contents.append(hisutil.appendSpace("---", 20,0));
								//contents.append(hisutil.appendSpace(strRate, 10,0));
								contents.append(hisutil.appendSpace(str_billed_qty.replace(" ", "#").split("#")[0], 18,	0));
								//contents.append(hisutil.appendSpace(" "+str_dis_amt.replace(" ", "#").split("#")[0], 6,	0));
								//contents.append(hisutil.appendSpace(" "+str_S_Tax.replace(" ", "#").split("#")[0], 6,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotAmount, 2),12, 0));
								//contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByPatient, 2),8, 1)+hisutil.appendSpace("", 2,	0));
								//contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strPaidByClient, 2),8, 1)+hisutil.appendSpace("", 1,	0));
								contents.append("\n");
								printLine++;															
							//contents.append("\n");
						//	printLine++;
						//	contents.append("\n");
						//	printLine++;
						} 
						/*else
						{
							printLine++;
							contents.append(" "+ hisutil.appendSpace(Tname.get(j).toUpperCase(), 75, 0));
							contents.append("\n");
						}*/
					}
				}
			}
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
			String msgStr = e.getMessage();
			HisException eObj = new HisException("Billing","PrintHLP->iterateMapForPrinting()", msgStr);
			eObj = null;
		}
		
		return tot;
	}	
	
	//return estimation certificate string buffer
	public static StringBuffer returnEstimationCertificate(String majorTarrifName,PrintVO voObj)
	{
		StringBuffer contents = new StringBuffer("");
		HisUtil hisutil = null;
		hisutil = new HisUtil("billing", "PrintHLP");
		WebRowSet ws = null;
		
		ws=voObj.getGblWs3();
		
		contents.append("                                ESTIMATION CERTIFICATE                                 \n");
		printLine++;
		contents.append(hisutil.appendSpace(majorTarrifName.replace("@", "#").split("#")[0], 36,0)+"\n");
		printLine++;
		contents.append(hisutil.appendSpace(" Tariff", 50,	0)+ 
						hisutil.appendSpace(" QTY.", 12, 1)+
						hisutil.appendSpace(" UNIT", 5, 1)	+ 
						hisutil.appendSpace("  RATE(Rs.)", 12, 1) + 
						hisutil.appendSpace("  AMOUNT(Rs.)", 15, 1)+ "\n");
		printLine++;
		
		int len=voObj.getGblWs3().size();
		
		try
		{
			//iterate over collection of tariffs..an estimation certificate will have n tariffs
			for(int i=0;ws.next();i++)
			{
				contents.append(hisutil.appendSpace("   "+ ws.getString(1), 50, 0)
						+ hisutil.appendSpace(ws.getString(2), 12, 1)
						+ hisutil.appendSpace(ws.getString(3), 5, 1)
						+ hisutil.appendSpace(ws.getString(4), 12, 1)
						+ hisutil.appendSpace(ws.getString(5), 15, 1)+"\n");
				printLine++;
				
				//query is to be changed for total amount..
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return contents;
	}
	
	
	//for credit billing
	public static boolean OPD_SERVICES_CreditBill(String strBillNo, String strBServiceId,String strHospitalCode, 
			String strReceiptNo , HttpServletRequest request , 
			Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String clientName ) throws Exception 
{
	
	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null,ws2=null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	Map clNoPrintMap=null;
	String patTotAmt="";
	String clientTotAmt="";
	String tempStr="";
	String totAmt = "0.00";//patTotAmt+clientTotAmt
	StringBuffer estimationCertStr=null;
	
	
	boolean content = false;
	
	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			
			//strIsDirectMode=1 Cash Collecton Offline
			//strIsDirectMode=0 Cash Collecton Online
			if (strIsDirectMode == "1")
			{
				boObj.OPD_SERVICES_DIRECT(voObj);
			} 
			else
			{
				boObj.OPD_SERVICES(voObj);
			}
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);		
			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();
					
			if (strIsDirectMode == "1")
			{
				ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
				strIsCreditCat="1";//Always Credit Category 1 in Case Of Offline Cash Collection Because Method OPD_SERVICES_CreditBill is being called in case of Credit Billing Only. Other Wise Method OPD_SERVICES is being called 
			} 
			else
			{
				ws = voObj.getGblWs1();
				ws1 = voObj.getGblWs2();//fields related to credit category are received..
			}
			
			if(ws1!=null)
			{
				for (int n = 0; ws1.next(); n++)
				{
					if(ws1.getString(16).equals("1"))//Credit Bill Flag--If any of the Tariff Found Done In Credit Billing Then Bill is considered as Credit Bill
					{
						strIsCreditCat="1";
						break;
					}
				}
				ws1.beforeFirst();
			}
			
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");			
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);			
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				clientTotAmt=clt_net_amt;
				strHidden = ws.getString(9);
				dept = ws.getString(10);
				strHospDtl=ws.getString(13);
				//strIsCreditCat=ws.getString(14);//1 yes its credit cat..
				
				double cltamt = Double.parseDouble(clt_net_amt);
				
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
					//its credit billing,format is different..
					if (strIsDirectMode == "1")//offline..
					{
					} 
					else
					{
					if (tariffPrintMap == null)
						tariffPrintMap = new LinkedHashMap();
					
					int len = ws1.size();
					String[] strArrayTariffList = new String[len];
					//System.out.println("ws1 size is::"+ws1.size());
					for (int n = 0; ws1.next(); n++)
					{
						// /crating group wise tariff map for online cash collection as Map passed is null
						//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
						//trfName=1,Qty=2,DiscountAmt=3,ServiceTax=4,NetAmt=5,groupId=6,groupName=7,AmtPaidByPatient=8,AmtPaidByClient=9,CreditLetterNo=10,CreditLetterDate=11,ClientNo=12,TotalAmt=13,TotalAmt2=14,isEstimation=15,CreditBillFlag=16
						String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
								+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ 
								ws1.getString(8)+ "^"+ ws1.getString(9)+"^"+ws1.getString(15);
						
						//strDirectTariffList,grpId,GrpName,client no,cl No
						strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
						patTotAmt=ws1.getString(13);
						clientTotAmt=ws1.getString(14);
						//Commented Bcoz Estimation Certificate Handled in IPD Module
						/*if(ws1.getString(15).equals("1"))//Estimation Certificte
						{
							String strTrfId="";
							boObj.OPD_SERVICES2(voObj);
							estimationCertStr=returnEstimationCertificate(ws1.getString(1),voObj);
						}*/					
					}
					
					totAmt=String.valueOf((Double.parseDouble(patTotAmt)+Double.parseDouble(clientTotAmt)));
					
					tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
					}
					
					//contents.append(Header(Header1, Header2, Header3, Header4);
					//Contents Adjusted for 87 Characters
					//contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
					contents.append("                                     CASH RECEIPT                                      \n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;
					
					if (isDuplicateBill == 1)
					{
						contents.append("                              (Duplicate)                                             \n");
						printLine++;
					}
					
					contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 87, 1)+ "\n \n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
						+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 30, 0)
							+ hisutil.appendSpace(" CLIENT", 10, 0)+ ": "+ hisutil.appendSpace(clientName.toUpperCase(), 20, 0) + "\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
						+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
					printLine++;
					
					//contents.append(MakeClientDtlStr(strHidden));
					
					if (isServiceDiscountReq == 0)
					{
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" DESCRIPTION", 28,	0)+ hisutil.appendSpace("  RATE", 12, 0)
										+ hisutil.appendSpace(" QTY.", 5, 0)+ hisutil.appendSpace("  AMOUNT", 15, 0)+hisutil.appendSpace("PATIENT SHARE", 15, 0)+hisutil.appendSpace("CLIENT SHARE", 12, 0)+ "\n");
						printLine++; 
						
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;
					} 
					else
					{
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" S.No.", 6, 0)
								+ hisutil.appendSpace(" Description", 36, 0)
								+ hisutil.appendSpace(" Qty.", 9, 0)
								+ hisutil.appendSpace(" Disc.", 11, 0)
								+ hisutil.appendSpace(" S.Tax", 10, 0)
								+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
								+ "\n");
						printLine++;
						
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;
					}
					
					// /iterating printMap for printing tariff based on group and Credit Letter No
					iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
					
					
					
					contents.append("                                           -------         -------      ------  \n");
					printLine++;
					contents.append("                                    TOTAL  "          +totAmt+"          "+patTotAmt+"          "+clientTotAmt+"\n");
					//contents.append(hisutil.appendSpace("TOTAL  ",27, 1)+ hisutil.appendSpace(exp_amt, 7, 0) + "\n");
					printLine++;
					contents.append("                                           -------         -------      ------  \n");
					printLine++;
					contents.append("\n");
					printLine++;
					
					
					contents.append(hisutil.appendSpace(" AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),87,0));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace(" AMOUNT PAID BY CLIENT (IN WORD) : "+ hisutil.getAmountStr(clientTotAmt),87,0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" Note : Amount,Patient Share and Client Share are in Rs.",87,0));
					
					contents.append("\n");
					printLine++;
					
					if (strBillNo.startsWith("5"))//Without Cr No Bill
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
					} 
					else
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
					}
						
						contents.append("\n");
						printLine++;
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;
						contents.append("\n");
						printLine++;
						
						//append estimation certificate details at the end..commented after discussion with ML..//Commented Bcoz Estimation Certificate Handled in IPD Module
						//contents.append(estimationCertStr);
					
				}//credit billing if ends..
				else
				{
					//ITS NON CREDIT BILLING
					if (strIsDirectMode == "1")//offline..
					{
					} 
					else
					{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();
						
						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							// /crating group wise tariff map for online cash
							// collection as Map passed is null
						
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);
						
							if(ws1.getString(15).equals("1"))//Estimation Certificte
							{
								String strTrfId="";
								boObj.OPD_SERVICES2(voObj);
								estimationCertStr=returnEstimationCertificate(ws1.getString(1),voObj);
							}
						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
					}
					
					//contents.append(Header(Header1, Header2, Header3, Header4);
					contents.append("                    "+ hisutil.appendSpace(strHospDtl, 59,0)+"\n");
					contents.append("                                  CASH RECEIPT                                  \n");
					printLine++;
					contents.append("--------------------------------------------------------------------------------\n");
					printLine++;
					
					if (isDuplicateBill == 1)
					{
						contents.append("                             (Duplicate)    \n");
						printLine++;
					}
					
					contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 79, 1)+ "\n \n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
						+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 62, 0)+ "\n");
					printLine++;
					printLine++;
					
					contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
						+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
					printLine++;
					
					//contents.append(MakeClientDtlStr(strHidden));
					
					if (isServiceDiscountReq == 0)
					{
						contents.append("--------------------------------------------------------------------------------\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" DESCRIPTION", 35,	0));
						contents.append(hisutil.appendSpace(" LAB/ROOM No", 15,	0));
						contents.append(hisutil.appendSpace(" RATE(Rs.)", 12, 0));
						contents.append(hisutil.appendSpace(" QTY.", 5, 0));
						contents.append(hisutil.appendSpace(" AMOUNT(Rs.)", 15, 0));
						
						contents.append("\n");
	
						printLine++;
						
						contents.append("--------------------------------------------------------------------------------\n");
						printLine++;
					} 
					else
					{
						contents.append("--------------------------------------------------------------------------------\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(" S.No.", 6, 0)
								+ hisutil.appendSpace(" Description", 36, 0)
								+ hisutil.appendSpace(" Qty.", 9, 0)
								+ hisutil.appendSpace(" Disc.", 11, 0)
								+ hisutil.appendSpace(" S.Tax", 10, 0)
								+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
								+ "\n");
						printLine++;
						
						contents.append("--------------------------------------------------------------------------------\n");
						printLine++;
					}
					
					// /iterating printMap for printing tariff based on group
					
					iterateMapForPrinting(tariffPrintMap, contents, brt);
					
					if (cltamt > 0)
					{
						contents.append(hisutil.appendSpace("Expense Amt   : ",	67, 1)
								+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("Paid by Third Party   : ", 68, 1)
								+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("Paid by Patient   : ", 67, 1)
								+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;
					} 
					else
					{
						contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",67, 1)
								+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
						printLine++;
					}
					
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt), 87, 0)+ "\n");				
					printLine++;				
					contents.append(hisutil.appendSpace("Note : Amount,Patient Share and Client Share are in Rs.", 87, 0)+ "\n");			
					printLine++;
					
					if (strBillNo.startsWith("5"))
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
					} 
					else
					{
						contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
					}
						
					contents.append("\n");
					printLine++;
					contents.append("---------------------------------------------------------------------------------------\n");
					printLine++;
					contents.append("\n");
					printLine++;
					
					//append estimation certificate details at the end..
					//contents.append(estimationCertStr);
				}		
			}
		}
		
		strIsDirectMode = "0";
		
		content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Opd Services------->" + contents.toString());
	} 
	catch (Exception e)
	{
		e.printStackTrace();
		throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
	} 
	finally
	{
		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}
	
	return content;
}
	
	//used in duplicate printing of the bill
	public static boolean OPD_SERVICES_CreditBill_DuplicatePrint(String strBillNo, String strBServiceId,String strHospitalCode, 
			String strReceiptNo , HttpServletRequest request , 
			Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String clientName, String receiptType ) throws Exception 
{
	
	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null,ws2=null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	Map clNoPrintMap=null;
	String patTotAmt="";
	String clientTotAmt="";
	String tempStr="";
	String totAmt = "0.00";//patTotAmt+clientTotAmt
	StringBuffer estimationCertStr=null;
	
	
	boolean content = false;
	
	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
		contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
		voObj = new PrintVO();
		boObj = new PrintBO();
		hisutil = new HisUtil("billing", "PrintHLP");
		
		voObj.setStrReceiptNo(strReceiptNo);
		voObj.setStrBillNo(strBillNo);
		voObj.setStrHospCode(strHospitalCode);
		
		//strIsDirectMode=1 Cash Collecton Offline
		//strIsDirectMode=0 Cash Collecton Online
		if (strIsDirectMode == "1")
		{
			boObj.OPD_SERVICES_DIRECT(voObj);
		} 
		else
		{
			boObj.OPD_SERVICES(voObj);
		}
		
		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
		
		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();
		
		
		
		if (strIsDirectMode == "1")
		{
		ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
		} 
		else
		{
		ws = voObj.getGblWs1();
		ws1 = voObj.getGblWs2();//fields related to credit category are received..
		}
		
		for (int k = 0; ws.next(); k++)
		{
		bill_no = ws.getString(1);
		bill_date = ws.getString(2);
		patient_name = ws.getString(3).replace("^", "#").split("#");
		for(int p=0;p<patient_name.length;p++)
		System.out.println("patient name is::"+patient_name[p]);
		
		patient_category = ws.getString(4);
		Crno = ws.getString(5);
		exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
		pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
		clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
		strHidden = ws.getString(9);
		dept = ws.getString(10);
		strHospDtl=ws.getString(13);
		strIsCreditCat=ws.getString(14);//1 yes its credit cat..
		
		double cltamt = Double.parseDouble(clt_net_amt);
		
		if(strIsCreditCat.equalsIgnoreCase("1"))
		{
		//its credit billing,format is different..
		if (strIsDirectMode == "1")//offline..
		{
		} 
		else
		{
		if (tariffPrintMap == null)
			tariffPrintMap = new LinkedHashMap();
		
		int len = ws1.size();
		String[] strArrayTariffList = new String[len];
		//System.out.println("ws1 size is::"+ws1.size());
		for (int n = 0; ws1.next(); n++)
		{
			// /crating group wise tariff map for online cash
			// collection as Map passed is null
		//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
			String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
					+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9)+"^"+ws1.getString(15);
			
			//strDirectTariffList,grpId,GrpName,client no,cl No
			strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
			patTotAmt=ws1.getString(13);
			clientTotAmt=ws1.getString(14);
			if(ws1.getString(15).equals("1"))//Estimation Certificte
			{
				String strTrfId="";
				boObj.OPD_SERVICES2(voObj);
				estimationCertStr=returnEstimationCertificate(ws1.getString(1),voObj);
			}
				
		}
		
		totAmt=String.valueOf((Double.parseDouble(patTotAmt)+Double.parseDouble(clientTotAmt)));
		
		tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
		}
		
		//contents.append(Header(Header1, Header2, Header3, Header4);
		//Contents Adjusted for 87 Characters
		contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
		contents.append("                                     CASH RECEIPT                                      \n");
		printLine++;
		contents.append("---------------------------------------------------------------------------------------\n");
		printLine++;
		
		if (isDuplicateBill == 1)
		{
		contents.append("                      (Duplicate):"+receiptType+"                                       \n");
		printLine++;
		}
		
		contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 87, 1)+ "\n \n");
		printLine++;
		printLine++;
		
		contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
			+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
		printLine++;
		printLine++;
		
		contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 30, 0)
				+ hisutil.appendSpace(" CLIENT", 10, 0)+ ": "+ hisutil.appendSpace(clientName.toUpperCase(), 20, 0) + "\n");
		printLine++;
		printLine++;
		
		contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
			+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
		printLine++;
		
		//contents.append(MakeClientDtlStr(strHidden));
		
		if (isServiceDiscountReq == 0)
		{
		contents.append("---------------------------------------------------------------------------------------\n");
		printLine++;
		
		contents.append(hisutil.appendSpace(" DESCRIPTION", 28,	0)+ hisutil.appendSpace("  RATE", 12, 0)
						+ hisutil.appendSpace(" QTY.", 5, 0)+ hisutil.appendSpace("  AMOUNT", 15, 0)+hisutil.appendSpace("PATIENT SHARE", 15, 0)+hisutil.appendSpace("CLIENT SHARE", 12, 0)+ "\n");
		printLine++; 
		
		contents.append("---------------------------------------------------------------------------------------\n");
		printLine++;
		} 
		else
		{
		contents.append("---------------------------------------------------------------------------------------\n");
		printLine++;
		
		contents.append(hisutil.appendSpace(" S.No.", 6, 0)
				+ hisutil.appendSpace(" Description", 36, 0)
				+ hisutil.appendSpace(" Qty.", 9, 0)
				+ hisutil.appendSpace(" Disc.", 11, 0)
				+ hisutil.appendSpace(" S.Tax", 10, 0)
				+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
				+ "\n");
		printLine++;
		
		contents.append("---------------------------------------------------------------------------------------\n");
		printLine++;
		}
		
		// /iterating printMap for printing tariff based on group and Credit Letter No
		iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
		
		
		
		contents.append("                                           -------         -------      ------  \n");
		printLine++;
		contents.append("                                    TOTAL  "          +totAmt+"          "+patTotAmt+"          "+clientTotAmt+"\n");
		//contents.append(hisutil.appendSpace("TOTAL  ",27, 1)+ hisutil.appendSpace(exp_amt, 7, 0) + "\n");
		printLine++;
		contents.append("                                           -------         -------      ------  \n");
		printLine++;
		contents.append("\n");
		printLine++;
		
		
		contents.append(hisutil.appendSpace(" AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),87,0));
		contents.append("\n");
		printLine++;
		
		contents.append(hisutil.appendSpace(" AMOUNT PAID BY CLIENT (IN WORD) : "+ hisutil.getAmountStr(clientTotAmt),87,0));
		contents.append("\n");
		printLine++;
		printLine++;
		
		contents.append(hisutil.appendSpace(" Note : Amount,Patient Share and Client Share are in Rs.",87,0));
		
		contents.append("\n");
		printLine++;
		
			if (strBillNo.startsWith("5"))
			{
			contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
			contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
			
			contents.append("\n");
			printLine++;
			contents.append("---------------------------------------------------------------------------------------\n");
			printLine++;
			contents.append("\n");
			printLine++;
			
			//append estimation certificate details at the end..commented after discussion with ML..
			//contents.append(estimationCertStr);
			
		}//credit billing if ends..
		else
		{
			//ITS NON CREDIT BILLING
			if (strIsDirectMode == "1")//offline..
			{
			} 
			else
			{
			if (tariffPrintMap == null)
				tariffPrintMap = new LinkedHashMap();
			
			int len = ws1.size();
			String[] strArrayTariffList = new String[len];
			for (int n = 0; ws1.next(); n++)
			{
				// /crating group wise tariff map for online cash
				// collection as Map passed is null
			
				String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
						+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
				
				strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);
			
				if(ws1.getString(15).equals("1"))//Estimation Certificte
				{
					String strTrfId="";
					boObj.OPD_SERVICES2(voObj);
					estimationCertStr=returnEstimationCertificate(ws1.getString(1),voObj);
				}
			}
			tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
			}
			
			//contents.append(Header(Header1, Header2, Header3, Header4);
			contents.append("                    "+ hisutil.appendSpace(strHospDtl, 59,0)+"\n");
			contents.append("                                  CASH RECEIPT                                  \n");
			printLine++;
			contents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			
			if (isDuplicateBill == 1)
			{
			contents.append("                             (Duplicate)    \n");
			printLine++;
			}
			
			contents.append(hisutil.appendSpace("DATE & TIME :"+ bill_date, 79, 1)+ "\n \n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" BILL NO.", 12, 0)+ ": "+ hisutil.appendSpace(bill_no, 30, 0)
				+ hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(patient_category.toUpperCase(), 20, 0) + "\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" CR No.", 12, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 62, 0)+ "\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" NAME", 12, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 30, "-").get(0).toUpperCase(), 29, 0)
				+ hisutil.appendSpace(" AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 20, 0)+ "\n");
			printLine++;
			
			//contents.append(MakeClientDtlStr(strHidden));
			
			if (isServiceDiscountReq == 0)
			{
			contents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			
			contents.append(hisutil.appendSpace(" DESCRIPTION", 50,	0)+ hisutil.appendSpace("  RATE(Rs.)", 12, 0)
							+ hisutil.appendSpace(" QTY.", 5, 0)+ hisutil.appendSpace("  AMOUNT(Rs.)", 15, 0)+ "\n");
			printLine++;
			
			contents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			} 
			else
			{
			contents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			
			contents.append(hisutil.appendSpace(" S.No.", 6, 0)
					+ hisutil.appendSpace(" Description", 36, 0)
					+ hisutil.appendSpace(" Qty.", 9, 0)
					+ hisutil.appendSpace(" Disc.", 11, 0)
					+ hisutil.appendSpace(" S.Tax", 10, 0)
					+ hisutil.appendSpace(" Amt(Rs.)", 11, 0)
					+ "\n");
			printLine++;
			
			contents.append("--------------------------------------------------------------------------------\n");
			printLine++;
			}
			
			// /iterating printMap for printing tariff based on group
			
			iterateMapForPrinting(tariffPrintMap, contents, brt);
			
			if (cltamt > 0)
			{
			contents.append(hisutil.appendSpace("Expense Amt   : ",	67, 1)
					+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
			printLine++;
			contents.append(hisutil.appendSpace("Paid by Third Party   : ", 68, 1)
					+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
			printLine++;
			contents.append(hisutil.appendSpace("Paid by Patient   : ", 67, 1)
					+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
			printLine++;
			} 
			else
			{
			contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
			printLine++;
			contents.append(hisutil.appendSpace("TOTAL AMOUNT ",67, 1)
					+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
			printLine++;
			contents.append(hisutil.appendSpace("------------", 80,1)+ "\n");
			printLine++;
			}
			
			contents.append("\n");
			printLine++;
			
			//to be uncommented..as of now could not get equivalent of digitword(func which gives word equivalent of number..)
			contents.append("RUPEES (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt));
			
			//contents.append("RUPEES (IN WORD) : ");
			
			contents.append("\n");
			printLine++;
			
			contents.append("Note : Amount,Patient Share and Client Share are in Rs.");
			//System.out.println("note added...................");
			//contents.append("RUPEES (IN WORD) : ");
			
			contents.append("\n");
			printLine++;
			
				if (strBillNo.startsWith("5"))
				{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
				} 
				else
				{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
				}
				
				contents.append("\n");
				printLine++;
				contents.append("---------------------------------------------------------------------------------------\n");
				printLine++;
				contents.append("\n");
				printLine++;
				
				//append estimation certificate details at the end..
				contents.append(estimationCertStr);
		}
		
		
		}
		}
		
		strIsDirectMode = "0";
		
		content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Opd Services------->" + contents.toString());
	} 
	catch (Exception e)
	{
		e.printStackTrace();
		throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
	} 
	finally
	{
		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}
	
	return content;
}
	
	public static boolean IPD_SERVICES_DUP_PRINT(String strBillNo,
			String strPatAccountNo, String strBServiceId,
			String strHospitalCode, String strReceiptNo , HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String receiptType) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
	

		PrintVO voObj = new PrintVO();
		PrintBO boObj = new PrintBO();

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		HisUtil hisutil = new HisUtil("billing", "PrintHLP");

		
		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
		String dept = null;
		String strIsCreditPat="0";
		String strFinalAmt="0.00";//amount total irrespective of Gen or Credit Category Patient.
		String strAmountHeader="  Amount(Rs.)"; //vl be client amount when pat is of credit cat..
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"IPD SERVICES" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrAcctNo(strPatAccountNo);
				voObj.setStrReceiptNo(strReceiptNo);

				if( strIsDirectMode == "1" ){
					
					boObj.IPD_SERVICES_DIRECT(voObj);
					
				}else{
					boObj.IPD_SERVICES(voObj);
				}
				
				

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

			 			
				if( strIsDirectMode == "1" ){
					
					ws = voObj.getGblWs1();
					 
									
				}else{
					
					ws = voObj.getGblWs1();
					ws1 = voObj.getGblWs2();
								
				}
				for (int k = 0; ws.next(); k++) 
				{
					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					dept = ws.getString(9);
					strIsCreditPat = ws.getString(12);
					strFinalAmt= HisUtil.getAmountWithDecimal(ws.getString(13), 2);

					if(strIsCreditPat.equalsIgnoreCase("1"))
					{
						strAmountHeader="  Client Amount(Rs.)";
					}
					if( strIsDirectMode == "1" )
					{
						
					}
					else
					{
						if(tariffPrintMap==null)
							tariffPrintMap=new LinkedHashMap(0);
						int len = ws1.size();
						String[] strArrayTariffList=new String[len];
						for (int n = 0; ws1.next(); n++) 
						{
							///crating group wise tariff map for online cash collection as Map passed is null
							 String strDirectTariffList=ws1.getString(1)+"^"+ws1.getString(2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(3), 2)+"^"+
														HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+"^"+HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							 
							 strArrayTariffList[n]=strDirectTariffList+"#"+ws1.getString(6)+"#"+ ws1.getString(7);
						}
						 tariffPrintMap=populateGroupMapForPrinting(strArrayTariffList,tariffPrintMap,brt);
					}
						contents += Header(Header1, Header2, Header3, Header4)
							+ "                            IPD SERVICES      \n";

					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(dept.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;

					if(isServiceDiscountReq == 0){
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
								 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
								 + hisutil.appendSpace(strAmountHeader, 15,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}else{
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 36,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}
					
					///content string was first converted into string buffer and after tariff printing again to string
					
					StringBuffer contentBuffer=new StringBuffer(contents);
					
					iterateMapForPrinting(tariffPrintMap, contentBuffer,brt);
					
					contents= contentBuffer.toString();
			
					
					contents += "\n";
					printLine++;
					  
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						if(strIsCreditPat.equalsIgnoreCase("1"))//credit pat
						{
							contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(strFinalAmt, 12,1)+ "\n";
						}
						else
						{
							contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						}
						
						
						printLine++;
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
				

					contents += "\n";
					printLine++;
					printLine++;
					
					if(strIsCreditPat.equalsIgnoreCase("1"))//credit pat
					{
						contents += "    RUPEES (IN WORD) : "+ hisutil.getAmountStr(strFinalAmt);
					}
					else
					{
						contents += "    RUPEES (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt);
					}
					
					

					//contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;

					contents += Footer(Footer , request , brt.getBillDisclaimerServices());

				}

			}
			

			
			strIsDirectMode = "0";
			//strTariffList = null;
			
			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Ipd Services----->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.IPD_SERVICES() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean ADVANCE_DUP_PRINT(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String receiptType) throws Exception 
	{
		if (strBillNo == null && strBillNo.length() != 10) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) 
		{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		boolean content = false;
		String Desc = "ADVANCE";

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String dept = null;
		String strIsCreditCat="0";//0 no 1 yes credit category..
		String strAmtPaidByClient="0.00";
		
		 BillConfigUtil billConfigUtil = null;
			
		try 
		{
				billConfigUtil = new BillConfigUtil(strHospitalCode);
				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(), "ADVANCE" , request,isDuplicateBill);
				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");
	
					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
	
					boObj.ADVANCE(voObj);
					ws = voObj.getGblWs1();

				for (int i = 0; ws.next(); i++) 
				{
					int j = i + 1;
					
					strIsCreditCat =  ws.getString(12);
					if(ws.getString(8).equals("") || ws.getString(8).equals("0"))
						strAmtPaidByClient="0.00";
					else
						strAmtPaidByClient = ws.getString(8).replace("^","#").split("#")[3];
					
					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),	2);
					strHidden = ws.getString(8);
					dept = ws.getString(9);
					String ward = ws.getString(10);
					contents += Header(Header1, Header2, Header3, Header4)+"\n";
					contents += "                                       ADVANCE RECEIPT                                 \n";
					printLine++;

					if (isDuplicateBill == 1) 
					{
						contents += "                          (Duplicate):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 87,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 16,0)+": "+hisutil.appendSpace(bill_no, 33,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;
					
					

					contents += "---------------------------------------------------------------------------------------\n";
					printLine++;

					//changes for credit category begin.. 
					if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
					{
						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
						 + hisutil.appendSpace(" CLIENT AMOUNT(Rs.)", 37,1)+"\n";
						printLine++;
					
					}
					else
					{
						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
						 + hisutil.appendSpace(" PATIENT AMOUNT(Rs.)", 37,1)+"\n"; //29
						printLine++;
					}
					

					contents += "---------------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents +=  hisutil.appendSpace(Desc, 50,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

					  
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
				 


				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);

				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;

					contents += Footer(Footer , request , brt.getBillDisclaimerAdvance());

				}
			}
			content = PrintContents(strBServiceId,"1", contents , request);
			System.out.println("Advance Dup Print----->" + contents);
		}

		catch (Exception e) 
		{
			throw new Exception("Billing  PrintHLP.ADVANCE() -->"+ e.getMessage());
		} 
		finally 
		{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean PART_PAYMENT_DUP_PRINT(String strBillNo, String strBServiceId,
			String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String receiptType) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		/*
		 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
		 * 
		 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
		 * Blank or Invalid"); }
		 */

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		String Desc = "ADVANCE";

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		
		String remarks = null;
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"ADVANCE" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);

				boObj.PART_PAYMENT(voObj);
				ws = voObj.getGblWs1();

				for (int i = 0; ws.next(); i++) {
					int j = i + 1;

					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					dept = ws.getString(8);
					String ward = ws.getString(9);
					
					remarks = ws.getString(11);

					contents += Header(Header1, Header2, Header3, Header4)
							+ "                            ADVANCE      \n";

					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents +=  hisutil.appendSpace(Desc, 50,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				 

					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
				if(remarks != null && remarks.trim().length() > 0 && !remarks.trim().equals("0")){
													
					contents += "             REMARKS : "+ hisutil.breakString(remarks, 55, "~").get(0).toUpperCase() ;
					
					contents += "\n";
					printLine++;
					printLine++;
										
				}
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);

				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;

					contents += Footer(Footer , request , brt.getBillDisclaimerPartPayment());

				}

			}
			content = PrintContents(strBServiceId,"1", contents , request);
			System.out.println("Part Payment Dup Print------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.PART_PAYMENT() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean FINAL_ADJUSTMENT_DUP_PRINT(String strBillNo,
			String strBServiceId, String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo , HttpServletRequest request, int isDuplicateBill,String receiptType)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}
		

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null;

		String contents = new String();
	

		String bill_date = null;
		Date dt=new Date();
		Calendar cal = Calendar.getInstance();  
		String DATE_FORMAT = "dd-MMM-yy";
		SimpleDateFormat sdf =new SimpleDateFormat(DATE_FORMAT);
	    bill_date=sdf.format(cal.getTime());
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String strCltDtl = null;
		String strAdmnDtl = null;
		String expense_amt = null;
		String clt_amt = null;
		String dis_amt = "0";
		String ser_tax_amt = "0";
		String adm_date=null;
		String dis_date=null;
		String dept_name=null;
		String ward_name=null;
		String payable_amt=null;
		String adv_trf_amt=null;
		String auditor = "";
		String strPatCatCode = "";
		String strIsCreditCat= "";
		

		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"Final Adjustment Bill" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrAcctNo(strPatAccountNo);

				boObj.FINAL_ADJUSTMENT(voObj);

				ws = voObj.getGblWs1();

				
				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				for (int k = 0; ws.next(); k++) {

					bill_no = ws.getString(1);
					adm_no= ws.getString(2);
					Crno = ws.getString(3);
					patient_category = ws.getString(4);
					patient_name = ws.getString(5).replace("^", "#").split("#");
					adm_date=ws.getString(6);
					dis_date=ws.getString(7);
					dept_name=ws.getString(8);
					ward_name=ws.getString(9);
					
					float temp_expence=ws.getFloat(11);
					float temp_adv_trf=ws.getFloat(13);
					float tempnet_pay=ws.getFloat(10);
					float tempPayable = ws.getFloat(12);
					float expn=ws.getFloat(21);
					auditor = ws.getString(14);
					
					strPatCatCode = ws.getString(15);
					strIsCreditCat= ws.getString(19);
					if(ward_name==null)
						ward_name="--";
					
					
					contents += Header(Header1, Header2, Header3, Header4)
							+ "                          FINAL ADJUSTMENT BILL\n";
					printLine++;
					
					contents  
					+= "                             BILL-CUM-RECEIPT\n";
					printLine++;
					
					

					if (isDuplicateBill == 1) {

						contents += "                                (DUPLICATE):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;

					contents  += hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" BILL NO.", 15 ,0)     +": "+hisutil.appendSpace(bill_no, 30,0)
					 +   hisutil.appendSpace(" ADMISSION NO.", 18,0)+": "+hisutil.appendSpace(adm_no, 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" CR NO.", 15,0)     +": "+hisutil.appendSpace(  Crno, 30,0)
					+   hisutil.appendSpace(" PATIENT CATEGORY", 18,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 13,0) +"\n";
					printLine++;
			
					contents +=  hisutil.appendSpace(" PATIENT'S NAME", 9,0)     +": "+hisutil.appendSpace(hisutil.breakString( patient_name[0].toUpperCase(), 18, "~").get(0), 30,0)
					+   hisutil.appendSpace(" AGE/SEX", 18,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 13,0) +"\n";
					printLine++;
					
					contents +=  hisutil.appendSpace(" ADMISSION DATE", 15,0)     +": "+hisutil.appendSpace(  adm_date, 30,0)
					+   hisutil.appendSpace(" DISCHARGE DATE", 18,0)+": "+hisutil.appendSpace(dis_date, 13,0) +"\n";
					printLine++;
					
					contents +=  hisutil.appendSpace(" DEPARTMENT", 15,0)     +": "+hisutil.appendSpace(dept_name.toUpperCase(), 30,0)
					+   hisutil.appendSpace(" WARD", 18,0)+": "+hisutil.appendSpace(ward_name.toUpperCase(), 13,0) +"\n";
					printLine++;
				
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					if (strBillType.equals("1")) {
						
					contents += "Description              Amount(Rs.) | Description               Amount\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

						contents += Consolidated(strPatAccountNo,strHospitalCode, strBillType, strReceiptNo,strIsCreditCat,strBillNo);
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;
						printLine++;
						
					} else {

						contents += hisutil.appendSpace("DESCRIPTION ", 50,0)
						 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
						 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
						printLine++;


						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

													
						contents += Detailed(strPatAccountNo, strHospitalCode,
								strBillType, strReceiptNo , strPatCatCode,strIsCreditCat,tempnet_pay,temp_expence,tempPayable,expn,strBillNo );
					}
				
						contents += Footer(Footer , request , brt.getBillDisclaimerFinalBill());
						
						contents += "\n \n \n \n" +
						//hisutil.appendSpace("Bill Verified By : "+auditor.toUpperCase() ,80 , 1);  by manisha For CR- 559
						printLine++;
						printLine++;
						printLine++;
						printLine++;
						
				
				}

			}

			content = PrintContents(strBServiceId , "1", contents , request);
			System.out.println("Final Adjustment dup print------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.FINAL_ADJUSTMENT() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	public static boolean OPD_REFUND_DUP_PRINT(String strBillNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request , int isDuplicateBill,String receiptType) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null, ws2 = null;

		StringBuffer contents = new StringBuffer("");

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String patient_name[] = null;
		String patient_category = null;
		String Crno = null;
		// String adm_no = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String dept = null;
		String ward = null;
		String approvalDtl = null;
		float exp_amt_ser = 0;
		float exp_net_amt = 0;
		
		
		String[] tariff_name_ser = null;
		String[] billed_qty_ser = null;
		String[] S_Tax_ser = null;
		String[] net_bill_amt_ser = null;
		String[] dis_amt_ser = null;
		
		 BillConfigUtil billConfigUtil = null;
		
		boolean content = false;

		try {
			
			billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"OPD  REFUND" , request,isDuplicateBill));

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrHospCode(strHospitalCode);

				if(billConfigUtil.getGeneralRefundReceiptType().equals("2")){
					
					boObj.OPD_REFUND_WITH_OLD_DTLS(voObj);
					
				}else{
					boObj.OPD_REFUND(voObj);
				}
				
				ws = voObj.getStrOpdRefund();
				ws1 = voObj.getStrOpdRefund1();
				

				int length = ws1.size();

				String[] tariff_name = new String[length];
				String[] billed_qty = new String[length];
				String[] S_Tax = new String[length];
				String[] net_bill_amt = new String[length];
				String[] dis_amt = new String[length];
				
				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();
				
				if(billConfigUtil.getGeneralRefundReceiptType().equals("2")){ 					
					ws2 = voObj.getGblWs2(); 
					int length_ser = ws2.size();
					
						tariff_name_ser = new String[length_ser];
						billed_qty_ser = new String[length_ser];
						S_Tax_ser = new String[length_ser];
						net_bill_amt_ser = new String[length_ser];
						dis_amt_ser = new String[length_ser];
				}
				
				
				for (int k = 0; ws.next(); k++) {

					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					strHidden = ws.getString(9);
					
					dept = ws.getString(10);
					ward = ws.getString(11);
					approvalDtl = ws.getString(12);
					

					double cltamt = Double.parseDouble(clt_net_amt);

					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);
					}
					
					if(brt.getGeneralRefundReceiptType().equals("2"))
					for (int n = 0; ws2.next(); n++) {
						tariff_name_ser[n] = ws2.getString(1);
						billed_qty_ser[n] = ws2.getString(2);
						dis_amt_ser[n] = HisUtil.getAmountWithDecimal(ws2
								.getString(3), 2);
						S_Tax_ser[n] = HisUtil.getAmountWithDecimal(ws2
								.getString(4), 2);
						net_bill_amt_ser[n] = HisUtil.getAmountWithDecimal(ws2
								.getString(5), 2);
					}
					
					
					if(brt.getGeneralRefundReceiptType().equals("2")){
						
						contents.append( Header(Header1, Header2, Header3, Header4)
						+ "                             REVISED RECEIPT     \n");
						
					}else{
						contents.append( Header(Header1, Header2, Header3, Header4)
						+ "                             REFUND RECEIPT     \n");
					}
					
					//		+ "                          OPD  REFUND      \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents.append( "                             (Duplicate):"+receiptType+"    \n");
						printLine++;
					}

					//contents += "\n";
				//	printLine++;
					
					contents.append( hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n");
					printLine++;
					printLine++;
					
					contents.append( hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n");
					printLine++;
					printLine++;
					
					contents.append(  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n");
					printLine++;
					printLine++;
					
					
					contents .append( hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "-").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n");
					printLine++;
					 					 
				 
					contents .append( MakeClientDtlStr(strHidden));

					if(isServiceDiscountReq == 0){
						
						contents .append( "--------------------------------------------------------------------------------\n");
						printLine++;

						contents .append( hisutil.appendSpace(" DESCRIPTION", 50,0)
								 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
								 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n");
						printLine++;

						contents .append( "--------------------------------------------------------------------------------\n");
						printLine++;	 
						
					}else{
						
						contents.append( "--------------------------------------------------------------------------------\n");
						printLine++;

						contents .append( hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 36,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n");
						printLine++;

						contents.append( "--------------------------------------------------------------------------------\n");
						printLine++;	 
						
					}
					
					
					int tariffLen = 32;
					String strRate = "0";
					//String strRateUnit = ""; 

					if(isServiceDiscountReq == 0){
						
						tariffLen = 45;
					}
						
					
					if(brt.getGeneralRefundReceiptType().equals("2")){
							for (int i = 0; i < tariff_name_ser.length; i++)
		
							{
		
								List<String> Tname = null;
								
								if(isServiceDiscountReq == 0){
									
									String strTemp[] =  tariff_name_ser[i].replace("@", "#").split("#");
									
									strRate = strTemp[1].replace("/", "#").split("#")[0];
									
								//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
									
									Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "-");
																 
									
								}else{
									
									Tname = hisutil.breakString(
											tariff_name_ser[i].toUpperCase(), tariffLen, "-");
									
								}
								
		
								for (int j = 0; j < Tname.size(); j++) {
									if (j == 0) {
										//contents += "\n";
										//printLine++;
										//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
										//	+ " " ;
																
										if(isServiceDiscountReq == 0){
												
											   contents .append( hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
														+ hisutil.appendSpace(strRate, 12,1)
														+ hisutil.appendSpace(billed_qty_ser[i].replace(" ", "#").split("#")[0], 6,1));
												 										
										}else{
													
											   contents .append(hisutil.appendSpace("  "+Tname.get(j), 35,0)
														+  hisutil.appendSpace(billed_qty_ser[i], 9,1)
														+ hisutil.appendSpace(dis_amt_ser[i], 8,1)
														+ hisutil.appendSpace(S_Tax_ser[i], 10,1));
										}
											
												contents .append( hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt_ser[i],2) , 13, 1 )) ;
												contents.append( "\n");
										printLine++;
									} else {
									
										printLine++;
										contents.append(  " "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0));
										contents .append( "\n");
									}
								}
								
								
								exp_amt_ser = exp_amt_ser + Float.parseFloat(net_bill_amt_ser[i]);
								
								
							}
		
							
							contents .append(hisutil.appendSpace("------------", 80,1)+ "\n");
							printLine++;
							contents.append(hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(String.valueOf(exp_amt_ser),2), 12,1)+ "\n");
							printLine++;
							contents .append(hisutil.appendSpace("------------", 80,1)+ "\n");
							printLine++;
							
							contents .append(hisutil.appendSpace("\nREFUND ", 80,0)+ "\n");
							contents .append(hisutil.appendSpace("-------", 80,0)+ "\n");
							printLine++;
							printLine++;
							printLine++;
					}
					
				 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							strRate = strTemp[1].replace("/", "#").split("#")[0];
							
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
							
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");
														 
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i].toUpperCase(), tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								//contents += "\n";
								//printLine++;
								//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
								//	+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents.append( hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
												+ hisutil.appendSpace(strRate, 12,1)
												+ hisutil.appendSpace(billed_qty[i].replace(" ", "#").split("#")[0], 6,1));
										 										
								}else{
											
									   contents .append( hisutil.appendSpace("  "+Tname.get(j), 35,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1));
								}
									
										contents .append( hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 13, 1 ) );
										contents .append( "\n");
								printLine++;
							} else {
							
								printLine++;
								contents .append(  "       "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0));
								contents .append( "\n");
							}
						}
						
						 
						
					}


					//contents += "\n----------------------------------------------------------------------\n";
					//printLine++;
					//printLine++;
					
					//contents += "\n";
					//printLine++;
					
					
					if(brt.getGeneralRefundReceiptType().equals("2")){
					
						exp_net_amt =  exp_amt_ser + Float.parseFloat(exp_amt);
						
					}
					
					
					if (cltamt > 0) {
						contents .append(hisutil.appendSpace("Expense Amt   : ", 67,1)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(exp_amt, 2), 12,1)+ "\n");
						printLine++;
						contents .append(hisutil.appendSpace("Paid by Third Party   : ", 68,1)+hisutil.appendSpace(clt_net_amt, 12,1)+ "\n");
						printLine++;
						contents .append(hisutil.appendSpace("Paid by Patient   : ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n");
						printLine++;
					} else {
						
						contents .append(hisutil.appendSpace("------------", 80,1)+ "\n");
						printLine++;
						
						if(brt.getGeneralRefundReceiptType().equals("2")){
							contents .append(hisutil.appendSpace("REFUND AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n");
							contents .append(hisutil.appendSpace("------------", 80,1)+ "\n");
							printLine++;
							contents .append(hisutil.appendSpace("NET AMOUNT PAID", 67,1)+hisutil.appendSpace(HisUtil.getAmountWithDecimal(String.valueOf(exp_net_amt),2), 12,1)+ "\n");
							printLine++;
							
							exp_amt = String.valueOf(exp_net_amt);
							
						}else{
							contents .append(hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n");
						}
						
						
						printLine++;
						contents .append(hisutil.appendSpace("------------", 80,1)+ "\n");
						printLine++;
						
					//	contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					//	printLine++;

					}

				//	contents += "\n----------------------------------------------------------------------\n";
				//	printLine++;
				//	printLine++;

					contents .append( "\n");
					printLine++;
					//printLine++;
					
					contents .append( "RUPEES (IN WORD) : "
							+ hisutil.getAmountStr(exp_amt));

					contents .append("\n");
					printLine++;
				//	printLine++;
					
					contents .append( "ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase());
					contents .append("\n");
					printLine++;
					
					contents .append( "AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase());
					contents .append("\n");
					printLine++;
					
					//contents += "\n                                                    Cashier           ";
					contents .append("\n");
					printLine++;
					//printLine++;
				 
					String strDisclaimer = "";
					
					if(strBillNo.startsWith("5")){
						
						strDisclaimer = brt.getBillDisclaimerWithoutCrNo();
						
						contents.append( Footer(Footer , request , strDisclaimer));
						
					}else{
						
						strDisclaimer = brt.getBillDisclaimerRefund();
						
						contents .append( Footer(Footer , request , strDisclaimer ));

					}

				}
			}
			content = PrintContents(strBServiceId, "2", contents.toString() , request);
			System.out.println("Opd Refund Dup Print------->" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.OPDREFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean IPD_REFUND_DUP_PRINT(String strBillNo, String strReceiptNo,
			String strPatAccountNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill,String receiptType)
			throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		WebRowSet ws = null, ws1 = null;

		String contents = new String();

		// String rptName = BillConfigUtil.BILLING_RPT_NAME;

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String exp_amt = null;
		String dept = null;
		
		String approvalDtl = null;
		
		 BillConfigUtil billConfigUtil = null;
			
			boolean content = false;

			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);

			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(), "IPD REFUND" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);
				voObj.setStrAcctNo(strPatAccountNo);

				boObj.IPD_REFUND(voObj);

				BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

				String Header1 = brt.getBillFormatHeader1();
				String Header2 = brt.getBillFormatHeader2();
				String Header3 = brt.getBillFormatHeader3();
				String Header4 = brt.getBillFormatHeader4();
				String Footer = brt.getBillFormatFooter();

				ws = voObj.getStrIpdRefund();
				ws1 = voObj.getStrIpdRefund1();
			
				int len = ws1.size();

				String[] tariff_name = new String[len];
				String[] billed_qty = new String[len];
				String[] S_Tax = new String[len];
				String[] net_bill_amt = new String[len];
				String[] dis_amt = new String[len];

				for (int k = 0; ws.next(); k++) {
					bill_no = ws.getString(1);

					bill_date = ws.getString(2);

					patient_name = ws.getString(3).replace("^", "#").split("#");

					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
							2);
					dept = ws.getString(9);
					String ward = ws.getString(10);
					
					approvalDtl = ws.getString(11);
					
					for (int n = 0; ws1.next(); n++) {
						tariff_name[n] = ws1.getString(1);
						billed_qty[n] = ws1.getString(2);
						dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(3), 2);
						S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(4), 2);
						net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
								.getString(5), 2);
					}

					contents += Header(Header1, Header2, Header3, Header4)
							+ "                          IPD REFUND       \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;

					if(isServiceDiscountReq == 0){
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
								 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
								 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}else{
						
						contents += "--------------------------------------------------------------------------------\n";
						printLine++;

						contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 36,0)
						 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
						 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
						printLine++;

						contents += "--------------------------------------------------------------------------------\n";
						printLine++;	 
						
					}
					
					
					int tariffLen = 32;
					String strRate = "0";
					//String strRateUnit = ""; 

					if(isServiceDiscountReq == 0){
						
						tariffLen = 45;
					}
					
			 
					for (int i = 0; i < tariff_name.length; i++)

					{

						List<String> Tname = null;
						
						if(isServiceDiscountReq == 0){
							
							String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
							
							strRate = strTemp[1].replace("/", "#").split("#")[0];
							
						//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
							
							Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");
														 
							
						}else{
							
							Tname = hisutil.breakString(
									tariff_name[i].toUpperCase(), tariffLen, "~");
							
						}
						

						for (int j = 0; j < Tname.size(); j++) {
							if (j == 0) {
								//contents += "\n";
								//printLine++;
								//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
								//	+ " " ;
														
								if(isServiceDiscountReq == 0){
										
									   contents += hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
												+ hisutil.appendSpace(strRate, 12,1)
												+ hisutil.appendSpace(billed_qty[i].replace(" ", "#").split("#")[0], 6,1);
										 										
								}else{
											
									   contents += hisutil.appendSpace("  "+Tname.get(j), 35,0)
												+  hisutil.appendSpace(billed_qty[i], 9,1)
												+ hisutil.appendSpace(dis_amt[i], 8,1)
												+ hisutil.appendSpace(S_Tax[i], 10,1);
								}
									
										contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 13, 1 ) ;
										contents += "\n";
								printLine++;
							} else {
							
								printLine++;
								contents +=  "       "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0);
								contents += "\n";
							}
						}
					}


					//contents += "\n----------------------------------------------------------------------\n";
					//printLine++;
					//printLine++;
					
					contents += "\n";
					printLine++;
					  
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						
					//	contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					//	printLine++;

					
						contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
						contents +="\n";
						printLine++;
						
						contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
						contents +="\n";
						printLine++;
						
						

					contents += "\n";
					printLine++;
					printLine++;
					
					contents += "    RUPEES (IN WORD) : "
							+ hisutil.getAmountStr(pat_net_amt);

					//contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;
					
					contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

				}

			}
			content = PrintContents(strBServiceId, "2", contents , request);
			System.out.println("Ipd Refund Dup Print------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.IPDREFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	public static boolean ADVANCE_REFUND_DUP_PRINT(String strBillNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill,String receiptType) throws Exception {

		if (strBillNo == null && strBillNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}

		if (strBServiceId == null && strBServiceId.length() != 2) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;

		String contents = new String();
		boolean content = false;
		String Desc = "ADVANCE REFUND";

		BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

		String Header1 = brt.getBillFormatHeader1();
		String Header2 = brt.getBillFormatHeader2();
		String Header3 = brt.getBillFormatHeader3();
		String Header4 = brt.getBillFormatHeader4();
		String Footer = brt.getBillFormatFooter();

		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String adm_no = null;
		String pat_net_amt = null;
		String dept = null;
		String ward = null;
		String approvalDtl = null;
		
		 BillConfigUtil billConfigUtil = null;
			
		
			try {
				
				billConfigUtil = new BillConfigUtil(strHospitalCode);
			if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

				contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
						billConfigUtil.getGeneralDuplicatePrint(),
						"ADVANCE REFUND" , request,isDuplicateBill);

			} else {

				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrBillNo(strBillNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptNo(strReceiptNo);

				boObj.ADVANCE_REFUND(voObj);

				ws = voObj.getStrAdvanceRefund();

				for (int i = 0; ws.next(); i++) {
					int j = i + 1;

					bill_no = ws.getString(1);
					bill_date = ws.getString(2);
					patient_name = ws.getString(3).replace("^", "#").split("#");
					patient_category = ws.getString(4);
					Crno = ws.getString(5);
					adm_no = ws.getString(6);
					pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),
							2);
					dept = ws.getString(8);
					 ward = ws.getString(9);
					 approvalDtl = ws.getString(10);
						
					contents += Header(Header1, Header2, Header3, Header4)
							+ "                   ADVANCE REFUND      \n";
					printLine++;

					if (isDuplicateBill == 1) {

						contents += "                          (Duplicate):"+receiptType+"    \n";
						printLine++;
					}

					contents += "\n";
					printLine++;
					
					contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
					printLine++;
					printLine++;
					
					contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
					+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
					 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
					printLine++;
					printLine++;
					
					
					contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
					 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 29,1)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
					contents += hisutil.appendSpace(Desc, 50,0)
							+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

				  
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
				 

			//	contents += "\n----------------------------------------------------------------------\n";
			//	printLine++;
			//	printLine++;

				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);
				contents +="\n";
				contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
				contents +="\n";
				printLine++;
				
				contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
				contents +="\n";
				printLine++;
				
				
				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;
				
					contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

				}

			}
			content = PrintContents(strBServiceId,"2", contents , request);
			System.out.println("Advance Refund Dup Print------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.ADVANCE_REFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}
	
	

	
	
	 public static boolean LFADVANCE(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill) throws Exception 
		{
			if (strBillNo == null && strBillNo.length() != 10) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			/*
			 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
			 * 
			 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
			 * Blank or Invalid"); }
			 */

			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null;

			StringBuffer contents = new StringBuffer("");
			boolean content = false;
			String Desc = "LF ADVANCE";

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();

			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String adm_no = null;
			String pat_net_amt = null;
			String strHidden = null;
			String dept = null;
			String strIsCreditCat="0";//0 no 1 yes credit category..
			String strAmtPaidByClient="0.00";
			String serv_type="";
			String paymentdtls="";
			String paymentMode="";
			String PaymentModeName="";
			
			 BillConfigUtil billConfigUtil = null;
				
			try 
			{
					billConfigUtil = new BillConfigUtil(strHospitalCode);
					if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
					{
						contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(), "LFADVANCE" , request,isDuplicateBill));
					} 
					else 
					{
						voObj = new PrintVO();
						boObj = new PrintBO();
						hisutil = new HisUtil("billing", "PrintHLP");
		
						voObj.setStrReceiptNo(strReceiptNo);
						voObj.setStrBillNo(strBillNo);
						voObj.setStrHospCode(strHospitalCode);
		
						boObj.LFADVANCE(voObj);
						ws = voObj.getGblWs1();

					for (int i = 0; ws.next(); i++) 
					{
						int j = i + 1;
						
						strIsCreditCat =  ws.getString(12);
						if(ws.getString(8).equals("") || ws.getString(8).equals("0"))
							strAmtPaidByClient="0.00";
						else
							strAmtPaidByClient = ws.getString(8).replace("^","#").split("#")[3];
						
						bill_no = ws.getString(1);
						bill_date = ws.getString(2);
						patient_name = ws.getString(3).replace("^", "#").split("#");
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						adm_no = ws.getString(6);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),	2);
						strHidden = ws.getString(8);
						serv_type=ws.getString(9);
						dept = ws.getString(10);
						paymentdtls=ws.getString(14).equals("")?"---":ws.getString(14);
						//String ward = ws.getString(11);
						//contents += Header(Header1, Header2, Header3, Header4)+"\n";
						if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
							paymentMode=paymentdtls.split("/")[1];
							PaymentModeName=paymentdtls.split("/")[2];
							paymentdtls=paymentdtls.split("/")[0];

							}
						if (isDuplicateBill == 1) 
						{
							contents.append(hisutil.appendSpace("Duplicate--", 94, 1));
							contents.append("\n");
							printLine++;
							printLine++;
						}
						contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("WARD", 10, 0)+ ": "+ hisutil.appendSpace("---", 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace("---", 21, 0));
						contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;

						//contents.append(MakeClientDtlStr(strHidden));
						/*contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 85, 0));*/
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						
						//changes for credit category begin.. 
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{						
							contents.append(hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 20,	0));
						}
						else
						{
							contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
						}
						
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
						contents.append(hisutil.appendSpace(Desc, 40,	0));
						contents.append(hisutil.appendSpace("---", 10,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
						contents.append(hisutil.appendSpace("  1", 8,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;		
						
						contents.append(hisutil.appendSpace("",55,0));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
						contents.append(hisutil.appendSpace("", 7,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;				 

						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
                        
						contents.append(hisutil.appendSpace("Note : Amount,Patient Share and Client Share are in Rs.",94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						/*contents.append(hisutil.appendSpace("Mode Of Payment: Cash/Credit Card/Debit Card/Cheque",94, 0));
						contents.append("\n");
						printLine++;*/
						/*switch (paymentMode) {
				        case "1":
				            PaymentModeName = "Cash";
							
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "2":
				            PaymentModeName = "Cheque";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "3":
				            PaymentModeName = "Demand Draft";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "4":
				            PaymentModeName = "Credit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "5":
				            PaymentModeName = "Debit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "6":
				            PaymentModeName = "Client";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "7":
				            PaymentModeName = "Patient Wallet";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						 case "8":
							PaymentModeName = "International Credit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "9":
							PaymentModeName = "International Debit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				           break;
						case "10":
							PaymentModeName = "Cm Relief Fund";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "11":
							PaymentModeName = "Virtual Account";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "12":
							PaymentModeName = "Prisoner";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "13":
							PaymentModeName = "Jan Arogya";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        default:
				            PaymentModeName = "Cash";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        }*/
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
						contents.append("\n");
						printLine++;
						
						contents.append(Footer(Footer , request , brt.getBillDisclaimerAdvance()));
					}
				}
				content = PrintContents(strBServiceId,"1", contents.toString() , request);
				System.out.println("Advance----->" + contents);
			}

				/*		contents += "---------------------------------------------------------------------------------------\n";
						printLine++;

						//changes for credit category begin.. 
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{
							contents += hisutil.appendSpace("DESCRIPTION", 50,0)
							 + hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 29,1)+"\n";
							printLine++;
						
						}
						else
						{
							contents += hisutil.appendSpace("DESCRIPTION", 50,0)
							 + hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 29,1)+"\n"; //29
							printLine++;
						}
						

						contents += "---------------------------------------------------------------------------------------\n";
						printLine++;	 
						
						contents +=  hisutil.appendSpace(Desc, 50,0)
								+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

						  
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
					 

				//	contents += "\n----------------------------------------------------------------------\n";
				//	printLine++;
				//	printLine++;

					contents += "\n";
					printLine++;
					printLine++;
					
					contents += "    RUPEES (IN WORD) : "
							+ hisutil.getAmountStr(pat_net_amt);

					//contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;

						contents += Footer(Footer , request , brt.getBillDisclaimerAdvance());

					}
				}
				content = PrintContents(strBServiceId,"1", contents , request);
				
				System.out.println("Advance----->" + contents);
			}
*/
			catch (Exception e) 
			{
				throw new Exception("Billing  PrintHLP.ADVANCE() -->"+ e.getMessage());
			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
	 
	 public static void printPackageDetails(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt,PrintVO voObj )
		{
			HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
			int tariffLen = 35,i=0;
			String strRate = "0";
			WebRowSet ws = null;
			
			try
			{
				Set groupSet = tariffPrintMap.keySet();
				Iterator groupSetItr = groupSet.iterator();
				String strTariffDetail = "";
				PrintBO printBO=new PrintBO();
				List<String> Tname = null;
				while (groupSetItr.hasNext())
				{
					String groupkey = (String) groupSetItr.next();
					String[] groupDetail = groupkey.split("@");
					//groupTariffList(TrfName^Qty,DiscountAmt^ServiceTaxAmt^NetAmt^AmtPaidByPatient^AmtPaidByCLient^isEstimation^isPackage)
					
					List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
					Iterator groupTariffListItr = groupTariffList.iterator();
	                
					while (groupTariffListItr.hasNext())
					{
						strTariffDetail = (String) groupTariffListItr.next();
						String strTempVal[] = strTariffDetail.replace("^", "#").split("#");		
						String str_tariff_name = strTempVal[0];
						String isPackage=strTempVal[8];
						
						if(isPackage.equals("1"))
						{
							printBO.IPD_PACKAGES(voObj);
							
							ws= voObj.getGblWs3(); 
							int slno=1;
							String strTemp[] = str_tariff_name.replace("@", "#").split("#");
							
							
							contents.append(hisutil.appendSymbol(" "+strTemp[0].toUpperCase()+" Inclusive Tariff Names", 94,0,"-"));
							contents.append("\n");
							printLine++;
							
							while(ws.next())
							{
								//S.No. PROCEDURE/INVESTIGATION/SERVICE NAME    LOCATION       RATE(Rs.) QTY.    AMOUNT(Rs.)
								
								contents.append(hisutil.appendSpace(Integer.toString(slno), 6,0));
								contents.append(hisutil.appendSpace(" "	+hisutil.breakString(ws.getString(1).toUpperCase(), tariffLen, "~").get(0).toString() , 40,0));
								contents.append(hisutil.appendSpace("---",15,0));
								contents.append(hisutil.appendSpace(ws.getString(2), 10,0));
								contents.append(hisutil.appendSpace(" "+ws.getString(3), 8,	0));
								contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(4), 2),8, 1)+hisutil.appendSpace("", 7,	0));
								contents.append("\n");
								printLine++;
								slno++;
								
							}							
						}					
						
					}
				}
			} 
			catch (Exception e)
			{
				String msgStr = e.getMessage();
				HisException eObj = new HisException("Billing","PrintHLP->IPD_PACKAGE_DETAIL()", msgStr);
				eObj = null;
			}
		}
	
public static boolean OPD_SERVICES_REG(String strBillNo, String strBServiceId,String strHospitalCode, 
									String strReceiptNo , HttpServletRequest request , 
									Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType ) throws Exception 
{

	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	String strClientName="---"; 
	//Map clNoPrintMap=null;
	String patTotAmt="0.00";
	String clientTotAmt="0.00";
	String tempStr="";
	String serv_type="";
	String creditno="---";
	String paymentdtls="";
	String paymentMode="";
	String PaymentModeName="";

	boolean content = false;
	double concessionAmt=0.00;

	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			
			boObj.OPD_SERVICES_REG(voObj);
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			/*String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();*/
			String Footer = brt.getBillFormatFooter();
			
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
			
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				strHidden = ws.getString(9);
				serv_type=ws.getString(10);
				dept = ws.getString(11);
				strHospDtl=ws.getString(14);
				strIsCreditCat=ws.getString(15);//1 yes its credit cat..
				strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
				creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
				paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
				double cltamt = Double.parseDouble(clt_net_amt);
				if( !paymentdtls.equals(" ") && !paymentdtls.equals("") && !paymentdtls.equals("---")){
					paymentMode=paymentdtls.split("/")[1];
					PaymentModeName=paymentdtls.split("/")[2];
					paymentdtls=paymentdtls.split("/")[0];

					}

				/*Contents Adjusted for 94 Characters---Commented For NIMS
				contents.append(Header(Header1, Header2, Header3, Header4);
				contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
				contents.append("                                     CASH RECEIPT                                      \n");
				printLine++;
				contents.append("---------------------------------------------------------------------------------------\n");
				printLine++;*/

				if (isDuplicateBill == 1)
				{
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0).toUpperCase());
					contents.append("\n\n");
					printLine++;
					printLine++;
				}

				contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
				contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
				
				
				contents.append("\n");
				printLine++;
				printLine++;
				
									
				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;

				//contents.append(MakeClientDtlStr(strHidden));
				contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0).toUpperCase());
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				
				
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						
						for (int n = 0; ws1.next(); n++)
						{

							//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
							patTotAmt=ws1.getString(13);
							clientTotAmt=ws1.getString(14);
						}
						tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 28,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.", 6,0));
						//contents.append(hisutil.appendSpace("S.TAX", 6,0));
						contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
						contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
						contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
						contents.append("\n");
						printLine++;
		
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
		
						// /iterating printMap for printing tariff based on group and Credit Letter No
						iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
							
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
						contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(pat_net_amt,8,0));
						contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
						//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append("\n");
						printLine++;
						printLine++;
		
						double totamt=Double.parseDouble(pat_net_amt)+Double.parseDouble(clientTotAmt);
						String total = String.valueOf(totamt);
						
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt),94,0));
						contents.append("\n");
						printLine++;
						printLine++;						
				}
				else
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						System.out.println("len"+len);
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
										
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 11,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
						//contents.append(hisutil.appendSpace("S.TAX", 10,0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
						contents.append("\n");
						printLine++;

						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					

					// /iterating printMap for printing tariff based on group

					concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

					if (cltamt > 0)
					{
						contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;
					} 
					else
					{
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
					}

					contents.append("\n");
					printLine++;

					//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
					contents.append("\n");
					printLine++;
					//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
				}					
			}
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
			contents.append("\n");
			printLine++;
			*/
			/*switch (paymentMode) {
	        case "1":
	            PaymentModeName = "Cash";
				
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "2":
	            PaymentModeName = "Cheque";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "3":
	            PaymentModeName = "Demand Draft";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "4":
	            PaymentModeName = "Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "5":
	            PaymentModeName = "Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "6":
	            PaymentModeName = "Client";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "7":
	            PaymentModeName = "Patient Wallet";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			 case "8":
				PaymentModeName = "International Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "9":
				PaymentModeName = "International Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	           break;
			case "10":
				PaymentModeName = "Cm Relief Fund";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "11":
				PaymentModeName = "Virtual Account";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "12":
				PaymentModeName = "Prisoner";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "13":
				PaymentModeName = "Jan Arogya";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        default:
	            PaymentModeName = "Cash";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        }*/
			contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
			contents.append("\n");
			printLine++;

			if (strBillNo.startsWith("5"))
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
		}

		strIsDirectMode = "0";
		
		content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Opd Services Reg------->" + contents.toString());
	} 
	catch (Exception e)
	{
		e.printStackTrace();
		throw new Exception("Billing  PrintHLP.OPD_SERVICES_REG() -->"+ e.getMessage());
	} 
	finally
	{
		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}
	return content;
}
	
public static boolean OPD_REFUND_REG(String strBillNo, String strBServiceId,String strHospitalCode, 
		String strReceiptNo , HttpServletRequest request , 
		Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType ) throws Exception 
{

	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	String strClientName="---"; 
	//Map clNoPrintMap=null;
	String patTotAmt="0.00";
	String clientTotAmt="0.00";
	String tempStr="";
	String serv_type="";
	String creditno="---";
	String paymentdtls="";
	String paymentMode="";
	String PaymentModeName="";
	
	boolean content = false;
	double concessionAmt=0.00;
	
	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			
			boObj.OPD_SERVICES_REG(voObj);
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
			
			/*String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();*/
			String Footer = brt.getBillFormatFooter();
			
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
		
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				strHidden = ws.getString(9);
				serv_type=ws.getString(10);
				dept = ws.getString(11);
				strHospDtl=ws.getString(14);
				strIsCreditCat=ws.getString(15);//1 yes its credit cat..
				strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
				creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
				paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
				double cltamt = Double.parseDouble(clt_net_amt);
				if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
					paymentMode=paymentdtls.split("/")[1];
					PaymentModeName=paymentdtls.split("/")[2];
					paymentdtls=paymentdtls.split("/")[0];

					}
				/*Contents Adjusted for 94 Characters---Commented For NIMS
				contents.append(Header(Header1, Header2, Header3, Header4);
				contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
				contents.append("                                   REFUND RECEIPT                                      \n");
				printLine++;
				contents.append("---------------------------------------------------------------------------------------\n");
				printLine++;*/
				contents.append(hisutil.appendSpace("REFUND RECEIPT", 50, 1)+hisutil.appendSpace("", 44, 0));
				contents.append("\n\n");
				printLine++;
				printLine++;

				if (isDuplicateBill == 1)
				{
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
					contents.append("\n\n");
					printLine++;
					printLine++;
				}
				
				contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
				contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
				
				
				contents.append("\n");
				printLine++;
				printLine++;
				
									
				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				//contents.append(MakeClientDtlStr(strHidden));
				contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0).toUpperCase());
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				
			
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
					if (tariffPrintMap == null)
					tariffPrintMap = new LinkedHashMap();
					
					int len = ws1.size();
					String[] strArrayTariffList = new String[len];
					
					for (int n = 0; ws1.next(); n++)
					{			
						//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
						String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
								+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
						
						strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
						patTotAmt=ws1.getString(13);
						clientTotAmt=ws1.getString(14);
					}
					tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("S.No.", 6,	0));
					contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 28,	0));
					contents.append(hisutil.appendSpace("LOCATION", 10,	0));
					contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
					contents.append(hisutil.appendSpace("QTY.", 6,	0));
					contents.append(hisutil.appendSpace("DISC.", 6,0));
					//contents.append(hisutil.appendSpace("S.TAX", 6,0));
					contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
					contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
					contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
					contents.append("\n");
					printLine++;
					
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					
					// /iterating printMap for printing tariff based on group and Credit Letter No
					iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
					
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
					contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(pat_net_amt,8,0));
					contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
					//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
					contents.append("\n");
					printLine++;
					contents.append("----------------------------------------------------------------------------------------------");
					contents.append("\n");
					printLine++;
					contents.append("\n");
					printLine++;
					printLine++;
					
					double totamt=Double.parseDouble(pat_net_amt)+Double.parseDouble(clientTotAmt);
					String total = String.valueOf(totamt);
					
					contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),94,0));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt),94,0));
					contents.append("\n");
					printLine++;
					printLine++;
				}
				else
				{
						if (tariffPrintMap == null)
						tariffPrintMap = new LinkedHashMap();
				
						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);
						
						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
									
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 11,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
						//contents.append(hisutil.appendSpace("S.TAX", 10,0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
						contents.append("\n");
						printLine++;
						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
				
						concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);
				
						if (cltamt > 0)
						{
							contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
							printLine++;
							contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
							printLine++;
							contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
							printLine++;
						} 
						else
						{
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;
							//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
							contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("---------------", 93,1));
							contents.append("\n");
							printLine++;
						}
				
						contents.append("\n");
						printLine++;
						
						//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
						contents.append("\n");
						printLine++;
						//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
						contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
						contents.append("\n");
						printLine++;
						printLine++;						
				}					
			}
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
			contents.append("\n");
			printLine++;*/
			/*switch (paymentMode) {
	        case "1":
	            PaymentModeName = "Cash";
				
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "2":
	            PaymentModeName = "Cheque";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "3":
	            PaymentModeName = "Demand Draft";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "4":
	            PaymentModeName = "Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "5":
	            PaymentModeName = "Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "6":
	            PaymentModeName = "Client";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "7":
	            PaymentModeName = "Patient Wallet";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			 case "8":
				PaymentModeName = "International Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "9":
				PaymentModeName = "International Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	           break;
			case "10":
				PaymentModeName = "Cm Relief Fund";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "11":
				PaymentModeName = "Virtual Account";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "12":
				PaymentModeName = "Prisoner";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "13":
				PaymentModeName = "Jan Arogya";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        default:
	            PaymentModeName = "Cash";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        }
			*/
			contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
			contents.append("\n");
			printLine++;
		
			contents.append(hisutil.appendSpace("SIGNATURE OF THE PATIENT/ATTENDANT",94, 1));
			contents.append("\n");
			printLine++;
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("   (PATIENT/ATTENDANT NAME)",94, 1));
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("ID PROOF:.................................................  MOBILE NO........................",94, 1));
			contents.append("\n");
			printLine++;
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("ID PROOF TYPE(TICK): AADHAR CARD/VOTER ID/RATION CARD/DRIVING LICENSE/GOVT. ISSUE ID/OTHERS  ",94, 1));
			contents.append("\n");
			printLine++;
			
			if (strBillNo.startsWith("5"))
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
	}
	
	strIsDirectMode = "0";
	
	content = PrintContents(strBServiceId, "1", contents.toString(),request);
	System.out.println("Opd Refund Reg------->" + contents.toString());
	} 
	catch (Exception e)
	{
		//e.printStackTrace();
		throw new Exception("Billing  PrintHLP.OPD_SERVICES_REG() -->"+ e.getMessage());
	} 
	finally
	{
		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}
	return content;
}
		public static boolean WALLET(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill) throws Exception 
		{
			if (strBillNo == null && strBillNo.length() != 10) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			/*
			 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
			 * 
			 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
			 * Blank or Invalid"); }
			 */

			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null;

			StringBuffer contents = new StringBuffer("");
			boolean content = false;
			String Desc = null;

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();

			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String adm_no = null;
			String pat_net_amt = null;
			//String strHidden = null;
			String dept = null;
			//String strIsCreditCat="0";//0 no 1 yes credit category..
			//String strAmtPaidByClient="0.00";
			String serv_type="";
			String bserv_id="";
			String paymentdtls="";
			String suramt="";
			String totamt="";
			String paymentMode="";
			String PaymentModeName="";
			
			 BillConfigUtil billConfigUtil = null;
				
			try 
			{
					billConfigUtil = new BillConfigUtil(strHospitalCode);
					if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
					{
						contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(), "WALLETADVANCE" , request,isDuplicateBill));
					} 
					else 
					{
						voObj = new PrintVO();
						boObj = new PrintBO();
						hisutil = new HisUtil("billing", "PrintHLP");
		
						voObj.setStrReceiptNo(strReceiptNo);
						voObj.setStrBillNo(strBillNo);
						voObj.setStrHospCode(strHospitalCode);
		
						boObj.WALLETADVANCE(voObj);
						ws = voObj.getGblWs1();

					for (int i = 0; ws.next(); i++) 
					{
						int j = i + 1;
						
						//strIsCreditCat =  ws.getString(12);
						/*if(ws.getString(8).equals("") || ws.getString(8).equals("0"))
							strAmtPaidByClient="0.00";
						else
							strAmtPaidByClient = ws.getString(8).replace("^","#").split("#")[3];*/
						
						bill_no = ws.getString(1);
						bill_date = ws.getString(2);
						patient_name = ws.getString(3).replace("^", "#").split("#");
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						adm_no = ws.getString(6);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),	2);
						//strHidden = ws.getString(8);
						serv_type=ws.getString(8);
						dept = ws.getString(9);
						paymentdtls=ws.getString(14).equals("")?"---":ws.getString(14);
						String ward = ws.getString(8).equals("Ipd")?ws.getString(10):"N/A";
						Desc=ws.getString(12);
						//contents += Header(Header1, Header2, Header3, Header4)+"\n";
						bserv_id=ws.getString(13);
						//suramt=HisUtil.getAmountWithDecimal(ws.getString(15),2);
						if( !paymentdtls.equals(" ") && !paymentdtls.equals("") ){
							paymentMode=paymentdtls.split("/")[1];
							PaymentModeName=paymentdtls.split("/")[2];
							paymentdtls=paymentdtls.split("/")[0];

							}
						if (isDuplicateBill == 1) 
						{
							contents.append(hisutil.appendSpace("Duplicate--", 94, 1));
							contents.append("\n");
							printLine++;
							printLine++;
						}
						contents.append(hisutil.appendSpace("CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
						
						
						contents.append("\n");
						printLine++;
						printLine++;
						
											
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace("---", 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						
						

						//contents.append(MakeClientDtlStr(strHidden));
						contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
						contents.append(hisutil.appendSpace("WARD", 10, 0)+ ": "+ hisutil.appendSpace(ward, 53, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						
						//changes for credit category begin.. 
						/*if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{						
							contents.append(hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 20,	0));
						}
						else
						{*/
						if(bserv_id.equalsIgnoreCase("32"))//yes credit category
						{						
							contents.append(hisutil.appendSpace("REFUND AMOUNT(Rs.)", 20,	0));
						}
						else
						{
							contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
						}
						//}
						
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
						contents.append(hisutil.appendSpace(Desc, 40,	0));
						contents.append(hisutil.appendSpace("---", 10,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
						contents.append(hisutil.appendSpace("  1", 8,	0));
						contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
						contents.append("\n");
						printLine++;
						
						/*if(!suramt.equals("0.00"))
						{
							contents.append(hisutil.appendSpace(Integer.toString(j+1),6,0));
							contents.append(hisutil.appendSpace("(SURC)-Surcharge", 40,	0));
							contents.append(hisutil.appendSpace("---", 10,	0));
							contents.append(hisutil.appendSpace(suramt, 10,	0));
							contents.append(hisutil.appendSpace("  1", 8,	0));
							contents.append(hisutil.appendSpace(suramt, 20,	0));
							contents.append("\n");
							printLine++;
						}*/
						
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;	
						
						totamt=String.valueOf(HisUtil.getAmountWithDecimal(Double.parseDouble(pat_net_amt),2));
						
						contents.append(hisutil.appendSpace("",55,0));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
						contents.append(hisutil.appendSpace("", 7,	0));
						contents.append(hisutil.appendSpace(totamt, 20,	0));
						
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",70,0));
						contents.append(hisutil.appendSpace("------------", 24,0));
						contents.append("\n");
						printLine++;				 

						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(totamt),94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
                        
						contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
						contents.append("\n");
						printLine++;*/
						/*switch (paymentMode) {
				        case "1":
				            PaymentModeName = "Cash";
							
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "2":
				            PaymentModeName = "Cheque";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "3":
				            PaymentModeName = "Demand Draft";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "4":
				            PaymentModeName = "Credit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "5":
				            PaymentModeName = "Debit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "6":
				            PaymentModeName = "Client";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        case "7":
				            PaymentModeName = "Patient Wallet";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						 case "8":
							PaymentModeName = "International Credit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "9":
							PaymentModeName = "International Debit Card";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				           break;
						case "10":
							PaymentModeName = "Cm Relief Fund";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "11":
							PaymentModeName = "Virtual Account";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "12":
							PaymentModeName = "Prisoner";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
						case "13":
							PaymentModeName = "Jan Arogya";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        default:
				            PaymentModeName = "Cash";
							contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
												contents.append("\n");
												printLine++;
				            break;
				        }*/
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
						contents.append("\n");
						printLine++;
						
						contents.append(Footer(Footer , request , brt.getBillDisclaimerAdvance()));
					}
				}
				content = PrintContents(strBServiceId,"1", contents.toString() , request);
				System.out.println("Advance----->" + contents);
			}

				/*		contents += "---------------------------------------------------------------------------------------\n";
						printLine++;

						//changes for credit category begin.. 
						if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
						{
							contents += hisutil.appendSpace("DESCRIPTION", 50,0)
							 + hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 29,1)+"\n";
							printLine++;
						
						}
						else
						{
							contents += hisutil.appendSpace("DESCRIPTION", 50,0)
							 + hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 29,1)+"\n"; //29
							printLine++;
						}
						

						contents += "---------------------------------------------------------------------------------------\n";
						printLine++;	 
						
						contents +=  hisutil.appendSpace(Desc, 50,0)
								+ hisutil.appendSpace(pat_net_amt, 29,1)+"\n";

						  
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
						printLine++;
						contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
						printLine++;
					 

				//	contents += "\n----------------------------------------------------------------------\n";
				//	printLine++;
				//	printLine++;

					contents += "\n";
					printLine++;
					printLine++;
					
					contents += "    RUPEES (IN WORD) : "
							+ hisutil.getAmountStr(pat_net_amt);

					//contents += "\n                                                    Cashier           ";
					contents +="\n";
					printLine++;
					printLine++;

						contents += Footer(Footer , request , brt.getBillDisclaimerAdvance());

					}
				}
				content = PrintContents(strBServiceId,"1", contents , request);
				
				System.out.println("Advance----->" + contents);
			}
*/
			catch (Exception e) 
			{
				throw new Exception("Billing  PrintHLP.WALLETADVANCE() -->"+ e.getMessage());
			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
		
		/**
		 * IPD_SERVICES_DUP(vo) -- > This Method is Used to get Print Type in
		 * IPD_SERVICES_DUP Case
		 * 
		 * @throws Exception
		 */
		public static boolean IPD_ESTIMATION(String strBillNo,String strPatAccountNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType) throws Exception 
		{
			if (strBillNo == null && strBillNo.length() != 10) {

				throw new Exception(
						"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}

			if (strBServiceId == null && strBServiceId.length() != 2) {

				throw new Exception(
						"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}

			if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

				throw new Exception(
						"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
			}

			if (strHospitalCode == null && strHospitalCode.length() != 3) {

				throw new Exception(
						"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			/*
			 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
			 * 
			 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
			 * Blank or Invalid"); }
			 */

			PrintVO voObj = new PrintVO();
			PrintBO boObj = new PrintBO();

			WebRowSet ws = null, ws1 = null;

			StringBuffer contents = new StringBuffer("");

			HisUtil hisutil = new HisUtil("billing", "PrintHLP");

			// String rptName = BillConfigUtil.BILLING_RPT_NAME;
			

			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String adm_no = null;
			String pat_net_amt = null;
			String exp_amt = null;
			String clt_net_amt = null;
			String ward = null;
			String strIsCreditPat="0";
			String strFinalAmt="0.00";//amount total irrespective of Gen or Credit Category Patient.
			String strAmountHeader="  Amount(Rs.)"; //vl be client amount when pat is of credit cat..
			String serv_type="";
			String patTotAmt="0.00";
			String clientTotAmt="0.00";
			String strClientName="---"; 
			String creditno="---";
			String paymentdtls="";
			String paymentMode="";
			String PaymentModeName="";
			
			String BillType="";
			String Mobile="";
			 BillConfigUtil billConfigUtil = null;
				
				boolean content = false;

				try {
					
					billConfigUtil = new BillConfigUtil(strHospitalCode);

				if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
				{
					contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD SERVICES" , request,isDuplicateBill));

				} 
				else 
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");

					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
					voObj.setStrAcctNo(strPatAccountNo);
					voObj.setStrReceiptNo(strReceiptNo);

					if( strIsDirectMode == "1" )//Offline
					{					
						boObj.IPD_ESTIMATION_DIRECT(voObj);//To Get Only Patient Details and Bill Details
					}
					else
					{
						boObj.IPD_ESTIMATION(voObj);//To Get Only Patient Details and Bill Details and Tariff Details
					}				
					

					BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

					/*String Header1 = brt.getBillFormatHeader1();
					String Header2 = brt.getBillFormatHeader2();
					String Header3 = brt.getBillFormatHeader3();
					String Header4 = brt.getBillFormatHeader4();*/
					String Footer = brt.getBillFormatFooter();

				 
					/*String[] tariff_name = null;
					String[] billed_qty = null;
					String[] S_Tax = null;
					String[] net_bill_amt = null;
					String[] dis_amt = null;*/
					
					
					if( strIsDirectMode == "1" )
					{					
						ws = voObj.getGblWs1();
						//ws1= voObj.getGblWs3(); 
						
						
						/*tariff_name = new String[strTariffList.length];
						billed_qty = new String[strTariffList.length];
						S_Tax = new String[strTariffList.length];
						net_bill_amt = new String[strTariffList.length];
						dis_amt = new String[strTariffList.length];*/
						
					}
					else
					{					
						ws = voObj.getGblWs1();
						ws1 = voObj.getGblWs2();
						
						/*int len = ws1.size();
						tariff_name = new String[len];
						billed_qty = new String[len];
						S_Tax = new String[len];
						net_bill_amt = new String[len];
						dis_amt = new String[len];*/
						
					}				

					for (int k = 0; ws.next(); k++) 
					{
						bill_no = ws.getString(1);
						bill_date = ws.getString(2);
						patient_name = ws.getString(3).replace("^", "#").split("#");
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						adm_no = ws.getString(6);
						exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);					
						serv_type=ws.getString(10);
						ward = ws.getString(11);
						strIsCreditPat = ws.getString(15);
						//strFinalAmt= HisUtil.getAmountWithDecimal(ws.getString(14), 2);
						strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
						//creditno=ws.getString(16).equals("0")?"---":ws.getString(16);
						paymentdtls=ws.getString(17).equals("")?"---":ws.getString(17);
						if( !paymentdtls.equals(" ") && !paymentdtls.equals("") && !paymentdtls.equals("---") && !paymentdtls.equals("0")){
							paymentMode=paymentdtls.split("/")[1];
							PaymentModeName=paymentdtls.split("/")[2];
							paymentdtls=paymentdtls.split("/")[0];

							}
						//double cltamt = Double.parseDouble(clt_net_amt);
						double cltamt = 0;

						double tot=0.00;
						
						BillType=ws.getString(19);
						Mobile=ws.getString(20);
						/*Contents Adjusted for 94 Characters---Commented For NIMS
						contents.append(Header(Header1, Header2, Header3, Header4);
						contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
						contents.append("                                     CASH RECEIPT                                      \n");
						printLine++;
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;*/

							contents.append(hisutil.appendSpace("ESTIMATION ONLY", 50, 1)+hisutil.appendSpace("", 44, 0));
							contents.append("\n");
							printLine++;
							printLine++;

						contents.append(hisutil.appendSpace("CR/ID No.", 14, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 16, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("EST. No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
						//contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
						contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
						contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
						
						contents.append("\n");
						printLine++;
						printLine++;
						
											
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;

						//contents.append(MakeClientDtlStr(strHidden));
						contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0));
						contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(ward.toUpperCase(), 53, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						
								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
								
								contents.append(hisutil.appendSpace("S.No.", 7,	0));
								contents.append(hisutil.appendSpace("PARTICULARS", 35,	0));
								contents.append(hisutil.appendSpace("LOCATION", 20,	0));
								//contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
								contents.append(hisutil.appendSpace("QTY.", 18,	0));
								//contents.append(hisutil.appendSpace("DISC.", 6,0));
								//contents.append(hisutil.appendSpace("S.TAX", 6,0));
								contents.append(hisutil.appendSpace("AMT(Rs.)", 12,	0));
								//contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
								//contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
								contents.append("\n");
								printLine++;

								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
							

							// /iterating printMap for printing tariff based on group and Credit Letter No
							tot=iterateEstimationMapForPrinting(tariffPrintMap, contents, brt);
							

							
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("",72,1)+hisutil.appendSpace("TOTAL",8,0)+hisutil.appendSpace(Double.toString(tot),12,0));
							//contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(patTotAmt,8,0));
							//contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
							//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append("\n");
							printLine++;
							printLine++;					
						
					}
				}	
				strIsDirectMode = "0";
				
				content = PrintContents(strBServiceId, "1", contents.toString(),request);
				System.out.println("IPD Estimation------->" + contents.toString());

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new Exception("Billing  PrintHLP.IPD_SERVICES() -->"+ e.getMessage());
				
			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
		
		/**
		 * OPD_SERVICES(vo) -- > This Method is Used to get Print Type in
		 * OPD_SERVICES Case
		 * 
		 * @throws Exception
		 */
		public static boolean OPD_ESTIMATION(String strBillNo, String strBServiceId,String strHospitalCode, 
											String strReceiptNo , HttpServletRequest request , 
											Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType ) throws Exception 
		{

			if (strBillNo == null && strBillNo.length() != 10)
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2)
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3)
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			
			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null, ws1 = null;
			StringBuffer contents = new StringBuffer("");
			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String pat_net_amt = null;
			String strHidden = null;
			String exp_amt = null;
			String clt_net_amt = null;
			String dept = null;
			String strHospDtl = null;
			BillConfigUtil billConfigUtil = null;
			String strIsCreditCat="0"; //0 no 1 yes credit category..
			String strClientName="---"; 
			//Map clNoPrintMap=null;
			String patTotAmt="0.00";
			String clientTotAmt="0.00";
			String tempStr="";
			String serv_type="";
			String creditno="---";
			String paymentdtls="";

			String BillType="";
			 String Mobile="";
			boolean content = false;
			double concessionAmt=0.00;

			try
			{
				billConfigUtil = new BillConfigUtil(strHospitalCode);
				if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
				{
					contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD Estimation", request, isDuplicateBill));
				} 
				else
				{
					voObj = new PrintVO();
					boObj = new PrintBO();
					hisutil = new HisUtil("billing", "PrintHLP");

					voObj.setStrReceiptNo(strReceiptNo);
					voObj.setStrBillNo(strBillNo);
					voObj.setStrHospCode(strHospitalCode);
					
					//strIsDirectMode=1 Cash Collecton Offline
					//strIsDirectMode=0 Cash Collecton Online
					if (strIsDirectMode == "1")
					{
						boObj.OPD_ESTIMATION_DIRECT(voObj);
					} 
					else
					{
						boObj.OPD_ESTIMATION(voObj);
					}

					BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

					/*String Header1 = brt.getBillFormatHeader1();
					String Header2 = brt.getBillFormatHeader2();
					String Header3 = brt.getBillFormatHeader3();
					String Header4 = brt.getBillFormatHeader4();*/
					String Footer = brt.getBillFormatFooter();
					
					
					
					if (strIsDirectMode == "1")
					{
						ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
					} 
					else
					{
						ws = voObj.getGblWs1();
						ws1 = voObj.getGblWs2();//fields related to credit category are received..
					}

					for (int k = 0; ws.next(); k++)
					{
						bill_no = ws.getString(1);
						bill_date = ws.getString(2);
						patient_name = ws.getString(3).replace("^", "#").split("#");
						patient_category = ws.getString(4);
						Crno = ws.getString(5);
						exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
						pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
						clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
						strHidden = ws.getString(9);
						serv_type=ws.getString(10);
						dept = ws.getString(11);
						strHospDtl=ws.getString(14);
						strIsCreditCat=ws.getString(15);//1 yes its credit cat..
						strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
						creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
						paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
						double cltamt = Double.parseDouble(clt_net_amt);
						double tot=0.00;
						BillType=ws.getString(19);
						Mobile=ws.getString(20);

						/*Contents Adjusted for 94 Characters---Commented For NIMS
						contents.append(Header(Header1, Header2, Header3, Header4);
						contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
						contents.append("                                     CASH RECEIPT                                      \n");
						printLine++;
						contents.append("---------------------------------------------------------------------------------------\n");
						printLine++;*/

							contents.append(hisutil.appendSpace("ESTIMATION ONLY", 50, 1)+hisutil.appendSpace("", 44, 0));
							contents.append("\n");
							printLine++;
							printLine++;

						contents.append(hisutil.appendSpace("CR/ID NO.", 14, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 16, 0));//10+20=30+2
						contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
						contents.append(hisutil.appendSpace("EST. NO.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
						contents.append("\n");
						printLine++;
						printLine++;
						
					//	contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
						
						contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("Mobile No", 10, 0)+ ": "+ hisutil.appendSpace(Mobile, 21, 0));
						contents.append(hisutil.appendSpace(" ", 10, 0)+ " "+ hisutil.appendSpace(" ", 20, 0));
						
						contents.append("\n");
						printLine++;
						printLine++;
						
											
						contents.append(hisutil.appendSpace("CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
						contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
						contents.append("\n");
						printLine++;
						printLine++;

						//contents.append(MakeClientDtlStr(strHidden));
						contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0).toUpperCase());
						contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						
								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
								
								contents.append(hisutil.appendSpace("S.No.", 7,	0));
								contents.append(hisutil.appendSpace("PARTICULARS", 35,	0));
								contents.append(hisutil.appendSpace("LOCATION", 20,	0));
								//contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
								contents.append(hisutil.appendSpace("QTY.", 18,	0));
								//contents.append(hisutil.appendSpace("DISC.", 6,0));
								//contents.append(hisutil.appendSpace("S.TAX", 6,0));
								contents.append(hisutil.appendSpace("AMT(Rs.)", 12,	0));
								//contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
								//contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
								contents.append("\n");
								printLine++;

								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
							

							// /iterating printMap for printing tariff based on group and Credit Letter No
							tot=iterateEstimationMapForPrinting(tariffPrintMap, contents, brt);
							

							
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("",72,1)+hisutil.appendSpace("TOTAL",8,0)+hisutil.appendSpace(Double.toString(tot),12,0));
							//contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(patTotAmt,8,0));
							//contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
							//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append("\n");
							printLine++;
							printLine++;					
						
					}
				}	
				strIsDirectMode = "0";
				
				content = PrintContents(strBServiceId, "1", contents.toString(),request);
				System.out.println("Opd Estimation------->" + contents.toString());
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				throw new Exception("Billing  PrintHLP.OPD_ESTIMATION() -->"+ e.getMessage());
			} 
			finally
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
		public static String GroupAndDepositData_OnDetailedBill(String strPatAccountNo,String strHospitalCode, String strBillType, String strReceiptNo,String strBillNo) throws Exception 
		{
			StringBuffer trfContents = new StringBuffer();
			if (strPatAccountNo == null && strPatAccountNo.length() != 10) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}

			HisUtil hisutil = null;
			PrintVO voObj = null;
			PrintBO boObj = null;
			String grpcode=null;

			String contents = new String();
			WebRowSet ws = null;

			int k = 0;

			try 
			{
				voObj = new PrintVO();
				boObj = new PrintBO();
				hisutil = new HisUtil("billing", "PrintHLP");

				voObj.setStrAcctNo(strPatAccountNo);
				voObj.setStrHospCode(strHospitalCode);
				voObj.setStrReceiptType(strBillType);
				voObj.setStrBillNo(strBillNo);

				boObj.FINAL_ADJUSTMENT_GROUPDATAANDDEPOSITDATADETAILCONS(voObj);
				System.out.println("WS1");
				ws = voObj.getGblWs3();
				System.out.println("WS2");

				for (int i = 0; ws.next(); i++) 
				{
					System.out.println("WS3");
					grpcode=ws.getString(8);
					List<String> Tname = hisutil.breakString(ws.getString(1), 22,"~");
					for (int j = 0; j < Tname.size(); j++) 
					{
						System.out.println("WS4");
						if (j == 0) 
						{
							trfContents.append(hisutil.appendSpace(Integer.toString(i+1), 7,	0));
							trfContents.append(hisutil.appendSpace(grpcode, 20,0));
							trfContents.append(hisutil.appendSpace(Tname.get(j).toUpperCase(), 35,	0));
						//	trfContents.append(hisutil.appendSpace(strDate, 20,0));
						//	trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(Double.parseDouble(netAmt)/Double.parseDouble(qty), 2), 10,	0));
						//	trfContents.append(hisutil.appendSpace(qty, 5,	0));
							trfContents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(ws.getString(2), 2), 16,	0));
						} 
						else 
						{
							if (k == 0) 
							{
								trfContents.append("\n");
								printLine++;
								k++;
							}
						}				
					}
					trfContents.append("\n");
					printLine++;
				}				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new Exception("PrintHLP.Consolidated()-->" + e.getMessage());

			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
			}

			return trfContents.toString();
		}
		
		public static boolean NO_DUES(String strBillNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request,int isDuplicateBill,String printCopyType) throws Exception 
		{
			if (strBillNo == null && strBillNo.length() != 10) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			/*
			 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
			 * 
			 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
			 * Blank or Invalid"); }
			 */

			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null;

			StringBuffer contents = new StringBuffer();
			String Desc = "NO DUES CERTIFICATE";

			// String rptName = BillConfigUtil.BILLING_RPT_NAME;

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();

			String adm_date = null;
			String dis_date = null;
			String bill_no = null;
			String nodues_no = null;
			String patient_name = null;
			String dept_name = null;
			String patient_category = null;
			String Crno = null;
			String adm_no = null;
			String paidamt = null;
			String dept = null;
			String strIsCreditCat="";
			
			
			BillConfigUtil billConfigUtil = null;
				
			boolean content = false;

			try 
			{
					billConfigUtil = new BillConfigUtil(strHospitalCode);
					/*if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
					{
						contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD PART PAYMENT" , request,isDuplicateBill));
					} 
					else 
					{*/
						voObj = new PrintVO();
						boObj = new PrintBO();
						hisutil = new HisUtil("billing", "PrintHLP");
		
						voObj.setStrReceiptNo(strReceiptNo);
						voObj.setStrBillNo(strBillNo);
						voObj.setStrHospCode(strHospitalCode);
		
						boObj.NO_DUES(voObj);
						ws = voObj.getGblWs1();
		
						for (int i = 0; ws.next(); i++) 
						{
							int j = i + 1;	
							nodues_no=ws.getString(1);	
							bill_no = ws.getString(2);	
							adm_date = ws.getString(7);	
							dis_date= ws.getString(8);
							patient_name = ws.getString(6);	
							dept_name = ws.getString(9);	
							patient_category = ws.getString(5);
							Crno = ws.getString(4);
							adm_no = ws.getString(3);
							paidamt = HisUtil.getAmountWithDecimal(ws.getString(11),2);
							String expamt= HisUtil.getAmountWithDecimal(ws.getString(12),2);
							String balamt= HisUtil.getAmountWithDecimal(ws.getString(13),2);
							dept = ws.getString(9);
							String ward = ws.getString(10);						
							strIsCreditCat =  ws.getString(17);//CHECKS CATGRP IF 3,4 THEN RETURNS 1 FROM PROC
							String finalbilldate=ws.getString(14).split(" ")[0];
							String finalbilltime=ws.getString(14).split(" ")[1];
							String finalbilluser=ws.getString(15);
							String noduesuser=ws.getString(16);
							String add=ws.getString(18);
							String Discount=ws.getString(19);
							String noduesdate=ws.getString(20).split(" ")[0];
							String noduestime=ws.getString(20).split(" ")[1];
							
							
							/*Contents Adjusted for 94 Characters---Commented For NIMS
							contents.append(Header(Header1, Header2, Header3, Header4);
							contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
							contents.append("                                     CASH RECEIPT                                      \n");
							printLine++;
							contents.append("---------------------------------------------------------------------------------------\n");
							printLine++;*/

							if (isDuplicateBill == 1)
							{
								contents.append(hisutil.appendSpace(" ", 32, 0)+ hisutil.appendSpace("DUPLICATE ", 10, 0)+hisutil.appendSpace(Desc, 20, 0)+hisutil.appendSpace(" ", 32, 0));
								contents.append("\n");
								contents.append("\n");
								printLine++;
								printLine++;
							}
							else
							{
								contents.append(hisutil.appendSpace(" ", 37, 0)+ hisutil.appendSpace(Desc, 20, 0)+hisutil.appendSpace(" ", 37, 0));
								contents.append("\n");
								contents.append("\n");
								printLine++;
								printLine++;
							}
							contents.append(hisutil.appendSpace(" ", 62, 0)+ hisutil.appendSpace("NODUES NO", 10, 0)+ ": "+ hisutil.appendSpace(nodues_no, 20, 0));
							contents.append("\n");
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							printLine++;
							contents.append(hisutil.appendSpace(" ", (94-patient_category.length())/2, 0)+ hisutil.appendSpace(patient_category.toUpperCase(), patient_category.length(), 0)+hisutil.appendSpace(" ", (94-patient_category.length())/2, 0));
							contents.append("\n");
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							contents.append(hisutil.appendSpace("BILL NO", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
							contents.append(hisutil.appendSpace(" ", 34,0));					
							contents.append(hisutil.appendSpace("TOTAL BILL ", 11, 1)+ " Rs: "+ hisutil.appendSpace(expamt, 12, 0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("IP NO", 10, 0)+ ": "+ hisutil.appendSpace(adm_no, 20, 0));//10+20=30+2
							contents.append(hisutil.appendSpace(" ", 34,0));					
							contents.append(hisutil.appendSpace("PAID ", 11, 1)+ " Rs: "+ hisutil.appendSpace(expamt, 12, 0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("NAME", 10, 0)+ ": "+ hisutil.appendSpace(patient_name.toUpperCase(), 82, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("DEPT/WARD", 10, 0)+ ": "+ hisutil.appendSpace(dept.toUpperCase()+"/"+ward.toUpperCase(), 82, 0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("ADMIT DATE", 10, 0)+ ": "+ hisutil.appendSpace(adm_date, 82, 0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("DISG DATE", 10, 0)+ ": "+ hisutil.appendSpace(dis_date, 82, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace(" ", 76, 0)+ hisutil.appendSpace("TO BE PAID ", 11, 1)+ ": "+ hisutil.appendSpace("NIL", 5, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace(" ", 94,0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							contents.append("\n");
							printLine++;
							
							//contents.append(hisutil.appendSpace("DATE", 5, 0)+ ": "+ hisutil.appendSpace(finalbilldate, 20, 0));//5+20=25+2
							contents.append(hisutil.appendSpace("ISSUED BY OPERATOR:", 31,0));					
							contents.append(hisutil.appendSpace("SUPERINTENDENT:", 36, 0));
							contents.append("\n");
							//contents.append(hisutil.appendSpace("TIME", 5, 0)+ ": "+ hisutil.appendSpace(finalbilltime, 20, 0));//5+20=25+2
							contents.append(hisutil.appendSpace(finalbilluser.toUpperCase(), 67,0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							//contents.append(hisutil.appendSpace("DATE", 5, 0)+ ": "+ hisutil.appendSpace(noduesdate, 20, 0));//5+20=25+2
							//contents.append(hisutil.appendSpace("ISSUED BY IN-PATIENT BILLING OPERATOR:", 67,0));					
						//	contents.append("\n");
							//contents.append(hisutil.appendSpace("TIME", 5, 0)+ ": "+ hisutil.appendSpace(noduestime, 20, 0));//5+20=25+2
							//contents.append(hisutil.appendSpace(noduesuser.toUpperCase(), 67,0));
							contents.append("\n");
							contents.append("\n");
							/*contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE", 40,	0));
							contents.append(hisutil.appendSpace("LOCATION", 10,	0));
							contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
							contents.append(hisutil.appendSpace("QTY.", 8,	0));
													
							if(strIsCreditCat.equalsIgnoreCase("1"))//yes credit category
							{
								contents.append(hisutil.appendSpace("CLIENT AMOUNT(Rs.)", 20,	0));
								contents.append("\n");
								printLine++;
								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
								contents.append(hisutil.appendSpace("CREDIT LETTER OR COUNTER No. OR TG No./REFERENECE DATE: "+creditDtls, 80,	0));
								contents.append("\n");
								printLine++;
							}
							else
							{
								contents.append(hisutil.appendSpace("PATIENT AMOUNT(Rs.)", 20,	0));
								contents.append("\n");
								printLine++;
								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								printLine++;
							}
													
							contents.append(hisutil.appendSpace(Integer.toString(j),6,0));
							contents.append(hisutil.appendSpace(Desc, 40,	0));
							contents.append(hisutil.appendSpace("---", 10,	0));
							contents.append(hisutil.appendSpace(pat_net_amt, 10,	0));
							contents.append(hisutil.appendSpace("  1", 8,	0));
							contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
							contents.append("\n");
							printLine++;
							
							contents.append(hisutil.appendSpace("",70,0));
							contents.append(hisutil.appendSpace("------------", 24,0));
							contents.append("\n");
							printLine++;		
							
							contents.append(hisutil.appendSpace("",55,0));
							contents.append(hisutil.appendSpace("TOTAL AMOUNT", 12,	0));
							contents.append(hisutil.appendSpace("", 7,	0));
							contents.append(hisutil.appendSpace(pat_net_amt, 20,	0));
							
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("",70,0));
							contents.append(hisutil.appendSpace("------------", 24,0));
							contents.append("\n");
							printLine++;
						
						if(remarks != null && remarks.trim().length() > 0 && !remarks.trim().equals("0"))
						{														
							contents.append(hisutil.appendSpace("REMARKS : "+ hisutil.breakString(remarks, 80, "~").get(0).toUpperCase(),94,0)) ;						
							contents.append("\n");
							printLine++;
							printLine++;											
						}					
						contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CLIENT SHARE ARE IN Rs.",94, 0));
						contents.append("\n");
						printLine++;
						printLine++;
						
						contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("CREDIT CARD/DEBIT CARD/CHEQUE DETAILS:",40, 0)+ hisutil.appendSpace(paymentdtls,54, 0));
						contents.append("\n");
						printLine++;*/
						
						//contents.append(Footer(Footer , request , brt.getBillDisclaimerPartPayment()));	
					}
				//}
				content = PrintContents(strBServiceId,"1", contents.toString() , request);
				System.out.println("No Dues------->" + contents);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new Exception("Billing  PrintHLP.NO_DUES() -->"+ e.getMessage());
			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
		
		public static boolean OP_REF_REQ(String strReqNo, String strBServiceId,String strHospitalCode, HttpServletRequest request, String billno, String billdate, String reason,String netamt) throws Exception 
		{
			if (strReqNo == null && strReqNo.length() != 10) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Request No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3) 
			{
				throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			/*
			 * if (strReceiptNo == null && strReceiptNo.length() > 1) {
			 * 
			 * throw new Exception( "PrintHLP.Consolidated()--> Receipt No Cannot be
			 * Blank or Invalid"); }
			 */

			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null;
			WebRowSet ws1 = null;

			StringBuffer contents = new StringBuffer();
			String Desc = "REFUND REQUISITION FORM";

			// String rptName = BillConfigUtil.BILLING_RPT_NAME;

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();

			String address = null;
			String tariff_name = null;
			String qty = null;
			String rate = null;
			String patient_name = null;
			String mobile = null;
			String patient_category = null;
			String Crno = null;
			String amt = null;
			String date=null;
			String trfcode=null;
		    Double totamt=0.00;
			
			
			BillConfigUtil billConfigUtil = null;
				
			boolean content = false;

			try 
			{
					billConfigUtil = new BillConfigUtil(strHospitalCode);
					/*if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) 
					{
						contents.append(receiptPrint(strHospitalCode, strReceiptNo, strBillNo,billConfigUtil.getGeneralDuplicatePrint(),"IPD PART PAYMENT" , request,isDuplicateBill));
					} 
					else 
					{*/
						voObj = new PrintVO();
						boObj = new PrintBO();
						hisutil = new HisUtil("billing", "PrintHLP");
		
						//voObj.setStrReceiptNo(strReceiptNo);
						voObj.setStrBillNo(strReqNo);
						voObj.setStrHospCode(strHospitalCode);
		
						boObj.OP_REF_REQ(voObj);
						ws = voObj.getGblWs1();
						ws1 = voObj.getGblWs2();
		
						for (int x = 0; ws.next(); x++)
						{
							patient_name=ws.getString(1).replace("^","#").split("#")[0];
							Crno=ws.getString(2);
							address=ws.getString(3).replace("^","#").split("#")[0];
							mobile=ws.getString(3).replace("^","#").split("#")[1];
							date=ws.getString(4);
						}

								contents.append(hisutil.appendSpace(" ", 33, 0)+ hisutil.appendSpace(Desc, 28, 0)+hisutil.appendSpace(" ", 33, 0));
								contents.append("\n");
								contents.append("\n");
								printLine++;
								printLine++;
							//}
							contents.append(hisutil.appendSpace(" ", 67, 0)+ hisutil.appendSpace("Date", 5, 0)+ ": "+ hisutil.appendSpace(date, 20, 0)); //hisutil.appendSpace("....................", 20, 0));
							contents.append("\n");
							contents.append(hisutil.appendSpace("Sub:- Cancellation of Bill-Refund of Amount to the Patient- Reg.", 94,0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							contents.append(hisutil.appendSpace("Name of the Patient", 20,0)+ ": "+ hisutil.appendSpace(patient_name, 72, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							contents.append(hisutil.appendSpace("CR Number", 11,0)+ ": "+ hisutil.appendSpace(Crno, 81, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Bill No.", 9,0)+": "+ hisutil.appendSpace(billno, 64, 0));
							contents.append(hisutil.appendSpace("Date", 5,0)+ ": "+ hisutil.appendSpace(billdate, 12, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Number of Tests/Service Requested", 26,0)+": "+ hisutil.appendSpace(String.valueOf(ws.size()), 66, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Number of Tests/Service Done", 21,0)+": "+ hisutil.appendSpace(String.valueOf(ws.size()), 71, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Number of Tests/Service to be Cancelled", 32,0)+": "+ hisutil.appendSpace(String.valueOf(ws.size()), 60, 0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Name of the Test/Service and Code:", 94,0));
							contents.append("\n");
							//contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							printLine++;
							contents.append(hisutil.appendSpace("Name of Test/Service", 40,	0));
							contents.append(hisutil.appendSpace("Code No.", 27,	0));
							contents.append(hisutil.appendSpace("S.No. in the Bill", 27,	0));
							//contents.append(hisutil.appendSpace("Amount Collected", 20,	0));
							contents.append("\n");
							printLine++;
							contents.append("----------------------------------------------------------------------------------------------");
							contents.append("\n");
							for (int n = 0; ws1.next(); n++)
							{
								tariff_name=ws1.getString(1).replace("@","#").split("#")[0];
								rate=ws1.getString(1).split("@")[1].split("/")[0];
								amt=ws1.getString(3);
								//qty=ws1.getString(2).split(" ")[0];
								trfcode=ws1.getString(8);
								contents.append(hisutil.appendSpace(tariff_name, 40,	0));
								contents.append(hisutil.appendSpace(trfcode, 27,	0));
								contents.append(hisutil.appendSpace(String.valueOf(n+1), 27,	0));
								//contents.append(hisutil.appendSpace(rate, 20,	0));
								contents.append("\n");
								printLine++;
								contents.append("----------------------------------------------------------------------------------------------");
								contents.append("\n");
								totamt=totamt+Double.parseDouble(amt);
							}
							contents.append("\n");
							printLine++;
							
							//iterateMapForOpRefPrinting(tariffPrintMap, contents, brt);
							netamt=netamt.split("-")[1];
							
							contents.append(hisutil.appendSpace("Amount to be Refunded", 22,0)+": "+hisutil.appendSpace(netamt, 70,0));//hisutil.appendSpace(String.valueOf(totamt), 70,0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Reason/s for Cancelling the Bill:", 34,0)+": "+hisutil.appendSpace(reason, 58,0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Name and Address of Patient/Attendant Collecting Refund:", 67,0));
							contents.append(hisutil.appendSpace("Signature/Thumb-Impression:", 27,0));
							contents.append("\n");
							contents.append(hisutil.appendSpace(patient_name, 94,0));
							contents.append("\n");
							contents.append(hisutil.appendSpace(address, 94,0));
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Mobile No.", 11,0)+": "+hisutil.appendSpace(mobile, 81,0));
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
							
							contents.append(hisutil.appendSpace("Name & Signature of Billing Clerk", 40,0));
							contents.append(hisutil.appendSpace("Approved By", 15,0));
							contents.append(hisutil.appendSpace("Doctor Concerned", 19,0));
							contents.append(hisutil.appendSpace("Billing In Charge", 20,0));
							contents.append("\n");
							contents.append(hisutil.appendSpace("Operator Code:", 40,0));
							//contents.append(hisutil.appendSpace("E.C No.", 15,0));
							//contents.append(hisutil.appendSpace("E.C No.", 19,0));
							//contents.append(hisutil.appendSpace("E.C No.", 20,0));
							contents.append("\n");
							contents.append("\n");
							contents.append("\n");
							contents.append("\n");
							contents.append("\n");
							contents.append("\n");
							printLine++;
							printLine++;
						//}
				content = PrintContents(strBServiceId,"1", contents.toString() , request);
				//System.out.println("No Dues------->" + contents);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				throw new Exception("Billing  PrintHLP.OP_REF_REQ() -->"+ e.getMessage());
			} 
			finally 
			{
				voObj = null;
				boObj = null;
				hisutil = null;
				billConfigUtil = null;
			}

			return content;
		}
		
		public static boolean CREDIT_NOTE(String strBillNo, String strBServiceId,String strHospitalCode, 
				String strReceiptNo , HttpServletRequest request , 
				Map tariffPrintMap) throws Exception 
			{
			
			if (strBillNo == null && strBillNo.length() != 10)
			{
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
			}
			if (strBServiceId == null && strBServiceId.length() != 2)
			{
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
			}
			if (strHospitalCode == null && strHospitalCode.length() != 3)
			{
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
			}
			
			PrintVO voObj = null;
			PrintBO boObj = null;
			HisUtil hisutil = null;
			WebRowSet ws = null, ws1 = null;
			StringBuffer contents = new StringBuffer("");
			String bill_date = null;
			String bill_no = null;
			String[] patient_name = null;
			String patient_category = null;
			String Crno = null;
			String pat_net_amt = null;
			String strHidden = null;
			String exp_amt = null;
			String clt_net_amt = null;
			String dept = null;
			String strHospDtl = null;
			BillConfigUtil billConfigUtil = null;
			String strIsCreditCat="0"; //0 no 1 yes credit category..
			String strClientName="---"; 
			//Map clNoPrintMap=null;
			String patTotAmt="0.00";
			String clientTotAmt="0.00";
			Double camt=0.00;
			String crrefno=null;
			
			String tempStr="";
			String serv_type="";
			String creditno="---";
			String paymentdtls="";
			String argtscat="0"; //0 no 1 yes category..
			
			boolean content = false;
			double concessionAmt=0.00;
			
			try
			{
			billConfigUtil = new BillConfigUtil(strHospitalCode);
			
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			//voObj.setStrAcctNo(trfid);
			voObj.setStrService(request.getParameter("strService"));
	
			
			
			boObj.CREDIT_NOTE(voObj);
			
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
			
			
			String Footer = brt.getBillFormatFooter();
			
			
			
			
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
			
			
			for (int k = 0; ws.next(); k++)
			{
			bill_no = ws.getString(1);
			bill_date = ws.getString(2);
			patient_name = ws.getString(3).replace("^", "#").split("#");
			patient_category = ws.getString(4);
			Crno = ws.getString(5);
			exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
			pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
			clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
			strHidden = ws.getString(9);
			serv_type=ws.getString(10);
			dept = ws.getString(11);
			strHospDtl=ws.getString(14);
			strIsCreditCat=ws.getString(15);//1 yes its credit cat..
			strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
			creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
			paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
			argtscat=ws.getString(19);//1 yes its cat..
			double cltamt = Double.parseDouble(clt_net_amt);
			
			
			/*Contents Adjusted for 94 Characters---Commented For NIMS
			contents.append(Header(Header1, Header2, Header3, Header4);
			contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
			contents.append("                                     CASH RECEIPT                                      \n");
			printLine++;
			contents.append("---------------------------------------------------------------------------------------\n");
			printLine++;*/
			contents.append(hisutil.appendSpace(" ", 41, 0)+ hisutil.appendSpace("CREDIT NOTE", 12, 0)+hisutil.appendSpace(" ", 41, 0));
			contents.append("\n");
			contents.append("\n");
			printLine++;
			printLine++;
			
			
			contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
			contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
			contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
			contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 21, 0));
			contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			//contents.append(MakeClientDtlStr(strHidden));
			/*contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type.toUpperCase(), 85, 0));*/
			contents.append("\n");
			printLine++;
			printLine++;
			
			
			/*if (strIsDirectMode == "1")//offline..
			{
				patTotAmt=pat_net_amt;
				clientTotAmt=clt_net_amt;
			} 
			else
			{*/
				if (tariffPrintMap == null)
					tariffPrintMap = new LinkedHashMap();
			
				int len = ws1.size();
				String[] strArrayTariffList = new String[len];
				
				for (int n = 0; ws1.next(); n++)
				{
					// /crating group wise tariff map for online cash
					// collection as Map passed is null
			//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
					String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
							+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9)+ "^"+ ws1.getString(13);
					
					strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
					patTotAmt=ws1.getString(8);
					camt+=Double.parseDouble(ws1.getString(9));
					clientTotAmt=String.valueOf(camt);
					crrefno=ws1.getString(10);
				}
				tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
			
			
			
			if (isServiceDiscountReq == 0)
			{
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("S.No.", 7,	0));
				contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 35,	0));
				contents.append(hisutil.appendSpace("TARIFF CANCEL DATE", 20,	0));
				contents.append(hisutil.appendSpace("RATE(Rs.)", 12,	0));
				contents.append(hisutil.appendSpace("QTY.", 8,	0));
				contents.append(hisutil.appendSpace("AMT(Rs.)", 12,	0));
				contents.append("\n");
				printLine++;
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
			} 
			else
			{
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				
				contents.append(hisutil.appendSpace("S.No.", 7,	0));
				contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 35,	0));
				contents.append(hisutil.appendSpace("TARIFF CANCEL DATE", 20,	0));
				contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
				contents.append(hisutil.appendSpace("QTY.", 6,	0));
				contents.append(hisutil.appendSpace("DISC.", 6,0));
				//contents.append(hisutil.appendSpace("S.TAX", 6,0));
				contents.append(hisutil.appendSpace("AMT(Rs.)", 10,	0));
				contents.append("\n");
				printLine++;
			
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
			}
			
			
			// /iterating printMap for printing tariff based on group and Credit Letter No
			iterateCreditCancelMapForPrinting(tariffPrintMap, contents, brt);
			
			
			
			contents.append("----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("",78,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
			contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
			//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
			contents.append("\n");
			printLine++;
			contents.append("----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace("CREDIT LETTER NO. ",18,1)+hisutil.appendSpace(crrefno.toUpperCase(),crrefno.length()+1,0)+hisutil.appendSpace("HAS BEEN ADJUSTED TO AMOUNT ",28,0)+hisutil.appendSpace(clientTotAmt,94-(crrefno.length()+47),0));
			contents.append("\n");
			printLine++;
			
			
			if (strBillNo.startsWith("5"))
			{
			contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
			contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
			
			
			//strIsDirectMode = "0";
			
			content = PrintContents(strBServiceId, "1", contents.toString(),request);
			System.out.println("Opd Services------->" + contents.toString());
			} 
			}
			catch (Exception e)
			{
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
			} 
			finally
			{
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
			}
			
			return content;
			}
		public static void iterateCreditCancelMapForPrinting(Map tariffPrintMap,StringBuffer contents, BillConfigUtil brt)
		{
			HisUtil hisutil = new HisUtil("Billing", "PrintHLP");
			int tariffLen = 28,i=0;
			String strRate = "0";
			
			if (isServiceDiscountReq == 0)
			{
				tariffLen = 28;
			}
			try
			{
				Set groupSet = tariffPrintMap.keySet();
				Iterator groupSetItr = groupSet.iterator();
				String strTariffDetail = "";
						
				while (groupSetItr.hasNext())
				{
					String groupkey = (String) groupSetItr.next();
					String[] groupDetail = groupkey.split("@");
					List groupTariffList = (ArrayList) tariffPrintMap.get(groupkey);
					Iterator groupTariffListItr = groupTariffList.iterator();
	                
					// /adding group name header for all tariff other that Consumable Charges
	               /* if (!groupDetail[0].equals(brt.getStrConsumableChargesGroupId()))
					{*/
						if(BillConfigUtil.PRINT_MODE.equals("2"))//DMP Printing
						{
							//credit letter no..
							contents.append(BOLDON+ hisutil.appendSpace("CREDIT LETTER NO.: "+ groupDetail[1].toUpperCase(),94,0)+ BOLDOFF);
							contents.append("\n");
							//group name..
							/*contents.append(BOLDON+hisutil.appendSpace("Group:"+ groupDetail[1].toUpperCase(),87,0)+ BOLDOFF);
							contents.append("\n");*/
						}
						else
						{
							contents.append(hisutil.appendSpace("CREDIT LETTER NO.: "+ groupDetail[1].toUpperCase(),94,0));
							contents.append("\n");
							printLine++;
							/*contents.append(hisutil.appendSpace("Group:"+ groupDetail[1].toUpperCase(),87,0));
							contents.append("\n");
							printLine++;*/
						}						
				//	}
	                

					while (groupTariffListItr.hasNext())
					{
						strTariffDetail = (String) groupTariffListItr.next();
						String strTempVal[] = strTariffDetail.replace("^", "#").split("#");

						String str_tariff_name = strTempVal[0];
						String str_billed_qty = strTempVal[1];
						String str_dis_amt = HisUtil.getAmountWithDecimal(strTempVal[2], 2);
						String str_S_Tax = HisUtil.getAmountWithDecimal(strTempVal[3], 2);
						String str_net_bill_amt = HisUtil.getAmountWithDecimal(strTempVal[4], 2);
						String strPaidByPatient=String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(strTempVal[5])*Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						String strPaidByClient=String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(strTempVal[6])*Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
						String strcreditcanceldate=strTempVal[7];
						// (AmtPaidByClient+AmtPaidByPat)*Qty
						String strTotAmount="";					
						List<String> Tname = null;

						if (isServiceDiscountReq == 0)
						{
							String strTemp[] = str_tariff_name.replace("@", "#").split("#");
							strRate = strTemp[1].replace("/", "#").split("#")[0];

							if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
							{
								strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
							}
							Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "~");
						} 
						else
						{
							String strTemp[] = str_tariff_name.replace("@", "#").split("#");
							strRate = strTemp[1].replace("/", "#").split("#")[0];

							if (Float.parseFloat(strRate) == 0 && Double.parseDouble(str_net_bill_amt) != 0)
							{
								strRate = String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(str_net_bill_amt) / Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0])),2));
							}
							//Tname = hisutil.breakString(str_tariff_name	.toUpperCase(), tariffLen, "-");
							Tname = hisutil.breakString(strTemp[0].toUpperCase(),tariffLen, "~");
						}

						strTotAmount=String.valueOf(HisUtil.getAmountWithDecimal((Double.parseDouble(strRate))* Double.parseDouble(str_billed_qty.replace(" ","#").split("#")[0]),2));
						for (int j = 0; j < Tname.size(); j++)
						{
							if (j == 0)
							{
								i++;
								if (isServiceDiscountReq == 0)
								{
									contents.append(hisutil.appendSpace(Integer.toString(i), 7,0));
									contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase().trim(), 35,0));
									contents.append(hisutil.appendSpace(strcreditcanceldate, 20,0));
									contents.append(hisutil.appendSpace(strRate, 12,0));
									contents.append(hisutil.appendSpace(" "+str_billed_qty.replace(" ", "#").split("#")[0], 8,	0));
									contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotAmount, 2),9, 1)+hisutil.appendSpace("", 3,	0));
									contents.append("\n");
									printLine++;
								} 
								else
								{
									contents.append(hisutil.appendSpace(Integer.toString(i), 7,0));
									contents.append(hisutil.appendSpace(" "	+Tname.get(j).toUpperCase().trim(), 35,0));
									contents.append(hisutil.appendSpace(strcreditcanceldate, 20,0));
									contents.append(hisutil.appendSpace(strRate, 10,0));
									contents.append(hisutil.appendSpace(" "+str_billed_qty.replace(" ", "#").split("#")[0], 6,	0));
									contents.append(hisutil.appendSpace(" "+str_dis_amt.replace(" ", "#").split("#")[0], 6,	0));
									//contents.append(hisutil.appendSpace(" "+str_S_Tax.replace(" ", "#").split("#")[0], 6,	0));
									contents.append(hisutil.appendSpace(HisUtil.getAmountWithDecimal(strTotAmount, 2),8, 1)+hisutil.appendSpace("", 2,	0));
									contents.append("\n");
									printLine++;								
								}							
								//contents.append("\n");
								//printLine++;
								//contents.append("\n");
								//printLine++;
							} 
							/*else
							{
								printLine++;
								contents.append(" "+ hisutil.appendSpace(Tname.get(j).toUpperCase(), 75, 0));
								contents.append("\n");
							}*/
						}
					}
				}
			} 
			
			catch (Exception e)
			{
				e.printStackTrace();
				String msgStr = e.getMessage();
				HisException eObj = new HisException("Billing","PrintHLP->iterateMapForPrinting()", msgStr);
				eObj = null;
			}
			
			
		}
		
public static String RECIEPT_MOBILE_APP(String strBillNo, String strBServiceId,String strHospitalCode, 
				String strReceiptNo , HttpServletRequest request , 
				Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType ) throws Exception 
{
	
	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	String strClientName="---"; 
	//Map clNoPrintMap=null;
	String patTotAmt="0.00";
	String clientTotAmt="0.00";
	String tempStr="";
	String serv_type="";
	String creditno="---";
	String paymentdtls="";
	String argtscat="0"; //0 no 1 yes category..
	String staffcat="0";
	String PaymentModeName="";
	String paymentMode="";
	
	boolean content = false;
	double concessionAmt=0.00;
	
	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
			{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");
			
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			
			//strIsDirectMode=1 Cash Collecton Offline
			//strIsDirectMode=0 Cash Collecton Online
			if (strIsDirectMode == "1")
			{
			boObj.OPD_SERVICES_DIRECT(voObj);
			} 
			else
			{
			boObj.OPD_SERVICES(voObj);
			}
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
			
			/*String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();*/
			String Footer = brt.getBillFormatFooter();
			
			
			
			if (strIsDirectMode == "1")
			{
			ws = voObj.getGblWs1();//a flield with name 'creditCat'=1 indicates it s a credit category..
			} 
			else
			{
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
			}
			
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				strHidden = ws.getString(9);
				serv_type=ws.getString(10);
				dept = ws.getString(11);
				strHospDtl=ws.getString(14);
				strIsCreditCat=ws.getString(15);//1 yes its credit cat..
				strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
				creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
				paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
				argtscat=ws.getString(19);//1 yes its cat..
				staffcat=ws.getString(21);
				double cltamt = Double.parseDouble(clt_net_amt);
				if( !paymentdtls.equals(" ") && !paymentdtls.equals("") )
				{
					paymentMode=paymentdtls.split("/")[1];
					PaymentModeName=paymentdtls.split("/")[2];
					paymentdtls=paymentdtls.split("/")[0];
				}
			
				if (isDuplicateBill == 1)
				{
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
					contents.append("\n");
					printLine++;
					printLine++;
				}
			
				contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
				contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(serv_type, 19, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append("\n");
				printLine++;
				printLine++;
			
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
					if (strIsDirectMode == "1")//offline..
					{
						patTotAmt=pat_net_amt;
						clientTotAmt=clt_net_amt;
					} 
					else
					{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();
					
						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						
						for (int n = 0; ws1.next(); n++)
						{
							// /crating group wise tariff map for online cash
							// collection as Map passed is null
					//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
							patTotAmt=ws1.getString(13);
							clientTotAmt=ws1.getString(14);
						}
						tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
					}
				
				
					if (isServiceDiscountReq == 0)
					{
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("S.No.", 5,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 29,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("QTY.", 8,	0));
						contents.append(hisutil.appendSpace("AMT(Rs.)", 10,	0));
						contents.append(hisutil.appendSpace("PAT. SHARE", 12,	0));
						contents.append(hisutil.appendSpace("CLT. SHARE", 10,	0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					} 
					else
					{
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 5,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 29,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.", 6,0));
						//contents.append(hisutil.appendSpace("S.TAX", 6,0));
						contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
						contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
						contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
						contents.append("\n");
						printLine++;
					
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					}
				
				
				// /iterating printMap for printing tariff based on group and Credit Letter No
				iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
				
				
				
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
				contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(patTotAmt,8,0));
				contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
				//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
				contents.append("\n");
				printLine++;
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				contents.append("\n");
				printLine++;
				printLine++;
				
				double totamt=Double.parseDouble(patTotAmt)+Double.parseDouble(clientTotAmt);
				String total = String.valueOf(totamt);
				
				contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(patTotAmt, 7, 1));
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
				contents.append("\n");
				printLine++;
				
				contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt).toUpperCase(),94,0));
				contents.append("\n");
				printLine++;
				
				contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt).toUpperCase(),94,0));
				contents.append("\n");
				printLine++;
				printLine++;						
			}
			else
			{
			//ITS NON CREDIT BILLING
			if (strIsDirectMode == "1")//offline..
			{
			} 
			else
			{
				if (tariffPrintMap == null)
					tariffPrintMap = new LinkedHashMap();
			
				int len = ws1.size();
				String[] strArrayTariffList = new String[len];
				for (int n = 0; ws1.next(); n++)
				{
					// /crating group wise tariff map for online cash
					// collection as Map passed is null
			
					String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
							+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
					
					strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);
			
				}
				tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
			}
			
			if (isServiceDiscountReq == 0)
			{
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("S.No.", 6,	0));
				contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE NAME", 40,	0));
				contents.append(hisutil.appendSpace("LOCATION", 15,	0));
				contents.append(hisutil.appendSpace("RATE(Rs.)", 10,	0));
				contents.append(hisutil.appendSpace("QTY.", 8,	0));
				contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15,	0));
				contents.append("\n");
				printLine++;
			
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
			} 
			else
			{
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
			
				
				contents.append(hisutil.appendSpace("S.No.", 7,	0));
				contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
				contents.append(hisutil.appendSpace("LOCATION", 11,	0));
				contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
				contents.append(hisutil.appendSpace("QTY.", 6,	0));
				contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
				//contents.append(hisutil.appendSpace("S.TAX", 10,0));
				contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
				contents.append("\n");
				printLine++;
			
				contents.append("----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
			}
			
			// /iterating printMap for printing tariff based on group
			
			concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);
			
			if (cltamt > 0)
			{
				contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
				printLine++;
				contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
				printLine++;
				contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
				printLine++;
			} 
			else
			{
				contents.append(hisutil.appendSpace("---------------", 93,1));
				contents.append("\n");
				printLine++;
				//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
				contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("---------------", 93,1));
				contents.append("\n");
				printLine++;
			}
			
			contents.append("\n");
			printLine++;
			
			//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
			if(!staffcat.equals("1"))
				contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
			else
				contents.append(hisutil.appendSpace("TOTAL CHARGES ",74, 1)+ hisutil.appendSpace(Double.toString(Math.abs(concessionAmt)), 7, 1));
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("EXEMPTION/CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
			contents.append("\n");
			printLine++;
			//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
			contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
			contents.append("\n");
			printLine++;
			
			contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			
			}					
			}
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
			contents.append("\n");
			printLine++;
			
			/*contents.append(hisutil.appendSpace("(U): URGENT TARIFF SURCHARGE("+billConfigUtil.getStrUrgTrfSur()+"% EXTRA CHARGES)",94, 0));
			contents.append("\n");
			printLine++;*/
			
			if(argtscat.equals("1") && Double.parseDouble(clientTotAmt)>0.00)
			{
				if(Double.parseDouble(patTotAmt)==0.00)
				{
					contents.append("<b>");
					contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED - CASHLESS SCHEME",94, 0));
					contents.append("</b>");
					contents.append("\n");
					printLine++;
				}
				if(Double.parseDouble(patTotAmt)>0.00)
				{
					contents.append("<b>");
					contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED (LIMIT- Rs."+clientTotAmt+") - CASHLESS SCHEME",94, 0));
					contents.append("</b>");
					contents.append("\n");
					printLine++;
				}
			}
			
			/*
			if (strBillNo.startsWith("5"))
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}*/
		}
		
		strIsDirectMode = "0";
		
		//content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Opd Services------->" + contents.toString());
	} 
	catch (Exception e)
	{
		e.printStackTrace();
		throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"+ e.getMessage());
	} 
	finally
	{
		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}
	
	return contents.toString();
}

public static boolean OPD_SERVICES_REGSERV(String strBillNo, String strBServiceId,String strHospitalCode, 
		String strReceiptNo , HttpServletRequest request , 
		Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType ) throws Exception 
{

	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	String strClientName="---"; 
	//Map clNoPrintMap=null;
	String patTotAmt="0.00";
	String clientTotAmt="0.00";
	String tempStr="";
	String serv_type="";
	String creditno="---";
	String paymentdtls="";
	String paymentMode="";
	String PaymentModeName="";

	boolean content = false;
	double concessionAmt=0.00;

	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			
			boObj.OPD_SERVICES_REGSERV(voObj);
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			/*String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();*/
			String Footer = brt.getBillFormatFooter();
			
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
			
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				strHidden = ws.getString(9);
				serv_type=ws.getString(10);
				dept = ws.getString(11);
				strHospDtl=ws.getString(14);
				strIsCreditCat=ws.getString(15);//1 yes its credit cat..
				strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
				creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
				paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
				double cltamt = Double.parseDouble(clt_net_amt);
				if( !paymentdtls.equals(" ") && !paymentdtls.equals("")  && !paymentdtls.equals("---") ){
					paymentMode=paymentdtls.split("/")[1];
					PaymentModeName=paymentdtls.split("/")[2];
					paymentdtls=paymentdtls.split("/")[0];

					}

				/*Contents Adjusted for 94 Characters---Commented For NIMS
				contents.append(Header(Header1, Header2, Header3, Header4);
				contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
				contents.append("                                     CASH RECEIPT                                      \n");
				printLine++;
				contents.append("---------------------------------------------------------------------------------------\n");
				printLine++;*/

				if (isDuplicateBill == 1)
				{
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0).toUpperCase());
					contents.append("\n\n");
					printLine++;
					printLine++;
				}

				contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
				contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
				
				
				contents.append("\n");
				printLine++;
				printLine++;
				
									
				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;

				//contents.append(MakeClientDtlStr(strHidden));
				contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0).toUpperCase());
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				
				
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						
						for (int n = 0; ws1.next(); n++)
						{

							//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
							patTotAmt=ws1.getString(13);
							clientTotAmt=ws1.getString(14);
						}
						tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 28,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.", 6,0));
						//contents.append(hisutil.appendSpace("S.TAX", 6,0));
						contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
						contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
						contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
						contents.append("\n");
						printLine++;
		
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
		
						// /iterating printMap for printing tariff based on group and Credit Letter No
						iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
							
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
						contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(pat_net_amt,8,0));
						contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
						//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append("\n");
						printLine++;
						printLine++;
		
						double totamt=Double.parseDouble(pat_net_amt)+Double.parseDouble(clientTotAmt);
						String total = String.valueOf(totamt);
						
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt),94,0));
						contents.append("\n");
						printLine++;
						printLine++;						
				}
				else
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						System.out.println("len"+len);
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
										
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 11,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
						//contents.append(hisutil.appendSpace("S.TAX", 10,0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
						contents.append("\n");
						printLine++;

						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					

					// /iterating printMap for printing tariff based on group

					concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

					if (cltamt > 0)
					{
						contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;
					} 
					else
					{
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
					}

					contents.append("\n");
					printLine++;

					//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
					contents.append("\n");
					printLine++;
					//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
				}					
			}
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
			contents.append("\n");
			printLine++;
			*/
			/*switch (paymentMode) {
	        case "1":
	            PaymentModeName = "Cash";
				
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "2":
	            PaymentModeName = "Cheque";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "3":
	            PaymentModeName = "Demand Draft";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "4":
	            PaymentModeName = "Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "5":
	            PaymentModeName = "Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "6":
	            PaymentModeName = "Client";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "7":
	            PaymentModeName = "Patient Wallet";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			 case "8":
				PaymentModeName = "International Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "9":
				PaymentModeName = "International Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	           break;
			case "10":
				PaymentModeName = "Cm Relief Fund";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "11":
				PaymentModeName = "Virtual Account";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "12":
				PaymentModeName = "Prisoner";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "13":
				PaymentModeName = "Jan Arogya";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        default:
	            PaymentModeName = "Cash";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        }*/
			contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
			contents.append("\n");
			printLine++;

			if (strBillNo.startsWith("5"))
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
		}

		strIsDirectMode = "0";
		
		content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Opd Services Reg------->" + contents.toString());
	} 
catch (Exception e)
{
e.printStackTrace();
throw new Exception("Billing  PrintHLP.OPD_SERVICES_REG() -->"+ e.getMessage());
} 
finally
{
voObj = null;
boObj = null;
hisutil = null;
billConfigUtil = null;
}
return content;
}
public static boolean IPD_SERVICES_REG(String strBillNo,String strPatAccountNo, String strBServiceId,String strHospitalCode, String strReceiptNo , HttpServletRequest request , Map tariffPrintMap , String strIsDirectMode,int isDuplicateBill,String isCreditBill,String printCopyType) throws Exception 
{

	if (strBillNo == null && strBillNo.length() != 10)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}
	if (strBServiceId == null && strBServiceId.length() != 2)
	{
		throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}
	if (strHospitalCode == null && strHospitalCode.length() != 3)
	{
		throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}
	
	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;
	WebRowSet ws = null, ws1 = null;
	StringBuffer contents = new StringBuffer("");
	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String pat_net_amt = null;
	String strHidden = null;
	String exp_amt = null;
	String clt_net_amt = null;
	String dept = null;
	String strHospDtl = null;
	BillConfigUtil billConfigUtil = null;
	String strIsCreditCat="0"; //0 no 1 yes credit category..
	String strClientName="---"; 
	//Map clNoPrintMap=null;
	String patTotAmt="0.00";
	String clientTotAmt="0.00";
	String tempStr="";
	String serv_type="";
	String creditno="---";
	String paymentdtls="";
	String paymentMode="";
	String PaymentModeName="";

	boolean content = false;
	double concessionAmt=0.00;

	try
	{
		billConfigUtil = new BillConfigUtil(strHospitalCode);
		if (billConfigUtil.getGeneralReceiptType().trim().equals("2"))
		{
			contents.append(receiptPrint(strHospitalCode, strReceiptNo,strBillNo, billConfigUtil.getGeneralDuplicatePrint(),"OPD SERVICES", request, isDuplicateBill));
		} 
		else
		{
			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			
			boObj.IPD_SERVICES_REGSERV(voObj);
			
			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			/*String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();*/
			String Footer = brt.getBillFormatFooter();
			
			ws = voObj.getGblWs1();
			ws1 = voObj.getGblWs2();//fields related to credit category are received..
			
			for (int k = 0; ws.next(); k++)
			{
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7),2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
				strHidden = ws.getString(9);
				serv_type=ws.getString(10);
				dept = ws.getString(11);
				strHospDtl=ws.getString(14);
				strIsCreditCat=ws.getString(15);//1 yes its credit cat..
				strClientName=ws.getString(16).equals("")?"---":ws.getString(16);//1 yes its credit cat..
				creditno=ws.getString(17).equals("0")?"---":ws.getString(17);
				paymentdtls=ws.getString(18).equals("")?"---":ws.getString(18);
				double cltamt = Double.parseDouble(clt_net_amt);
				if( !paymentdtls.equals(" ") && !paymentdtls.equals("")  && !paymentdtls.equals("---") ){
					paymentMode=paymentdtls.split("/")[1];
					PaymentModeName=paymentdtls.split("/")[2];
					paymentdtls=paymentdtls.split("/")[0];

					}

				/*Contents Adjusted for 94 Characters---Commented For NIMS
				contents.append(Header(Header1, Header2, Header3, Header4);
				contents.append("                                    "+ hisutil.appendSpace(strHospDtl, 51,0)+"\n");
				contents.append("                                     CASH RECEIPT                                      \n");
				printLine++;
				contents.append("---------------------------------------------------------------------------------------\n");
				printLine++;*/

				if (isDuplicateBill == 1)
				{
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)+hisutil.appendSpace(printCopyType, 54, 0).toUpperCase());
					contents.append("\n\n");
					printLine++;
					printLine++;
				}

				contents.append(hisutil.appendSpace(" CR No.", 10, 0)+ ": "+ hisutil.appendSpace(Crno.toUpperCase(), 20, 0));//10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0)+ ": "+ hisutil.appendSpace(bill_date, 21, 0));//10+21=31+2						
				contents.append(hisutil.appendSpace("BILL No.", 10, 0)+ ": "+ hisutil.appendSpace(bill_no, 20, 0));//10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;
				
				contents.append(hisutil.appendSpace(" NAME", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_name[0], 85, "~").get(0).toUpperCase(), 85, 0));
				
				
				contents.append("\n");
				printLine++;
				printLine++;
				
									
				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0)+ ": "+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;

				//contents.append(MakeClientDtlStr(strHidden));
				contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+ hisutil.appendSpace(serv_type, 20, 0).toUpperCase());
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
				contents.append("\n");
				printLine++;
				printLine++;
				
				
				
				if(strIsCreditCat.equalsIgnoreCase("1"))
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						String[] strArrayTariffList = new String[len];
						
						for (int n = 0; ws1.next(); n++)
						{

							//WS1 in order 1 to 11..tariffname,qty,discAmt,sTaxAmt,netAmt,grpId,GrpName,AmtPaidByPat,AmtPaidByClient,CreditLetterNo,creditLetterDate,clientNo
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2)+ "^"+ ws1.getString(8)+ "^"+ ws1.getString(9);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7)+ "#" + ws1.getString(12)+ "#" + ws1.getString(10);
							patTotAmt=ws1.getString(13);
							clientTotAmt=ws1.getString(14);
						}
						tariffPrintMap = populateCreditLetterMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 6,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE", 28,	0));
						contents.append(hisutil.appendSpace("LOCATION", 10,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.", 6,0));
						//contents.append(hisutil.appendSpace("S.TAX", 6,0));
						contents.append(hisutil.appendSpace("AMT(Rs.)", 9,	0));
						contents.append(hisutil.appendSpace("PAT SHARE", 10,	0));
						contents.append(hisutil.appendSpace("CLT SHARE", 9,	0));
						contents.append("\n");
						printLine++;
		
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
		
						// /iterating printMap for printing tariff based on group and Credit Letter No
						iterateCreditMapForPrinting(tariffPrintMap, contents, brt);
							
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("",68,1)+hisutil.appendSpace("TOTAL",7,0));//+hisutil.appendSpace("",2,1)+hisutil.appendSpace("",7,0));
						contents.append(hisutil.appendSpace("",2,1)+hisutil.appendSpace(pat_net_amt,8,0));
						contents.append(hisutil.appendSpace("",1,1)+hisutil.appendSpace(clientTotAmt,8,0));
						//contents.append(hisutil.appendSpace("TOTAL",60,1)+hisutil.appendSpace(exp_amt,64,1)+hisutil.appendSpace(patTotAmt,12,0)+hisutil.appendSpace(clientTotAmt,10,0));
						contents.append("\n");
						printLine++;
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						contents.append("\n");
						printLine++;
						printLine++;
		
						double totamt=Double.parseDouble(pat_net_amt)+Double.parseDouble(clientTotAmt);
						String total = String.valueOf(totamt);
						
						contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(HisUtil.getAmountWithDecimal(total,2), 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace("0.00", 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("PATIENT AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("CREDIT AMT ",74, 1)+ hisutil.appendSpace(clientTotAmt, 7, 1));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID BY PATIENT (IN WORD) : "+ hisutil.getAmountStr(pat_net_amt),94,0));
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("AMOUNT PAID IN CREDIT (IN WORD)  : "+ hisutil.getAmountStr(clientTotAmt),94,0));
						contents.append("\n");
						printLine++;
						printLine++;						
				}
				else
				{
						if (tariffPrintMap == null)
							tariffPrintMap = new LinkedHashMap();

						int len = ws1.size();
						System.out.println("len"+len);
						String[] strArrayTariffList = new String[len];
						for (int n = 0; ws1.next(); n++)
						{
							String strDirectTariffList = ws1.getString(1)+ "^"+ ws1.getString(2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(3), 2)
									+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(4), 2)+ "^"+ HisUtil.getAmountWithDecimal(ws1.getString(5), 2);
							
							strArrayTariffList[n] = strDirectTariffList + "#"+ ws1.getString(6) + "#" + ws1.getString(7);

						}
						tariffPrintMap = populateGroupMapForPrinting(strArrayTariffList, tariffPrintMap, brt);
										
						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
						
						contents.append(hisutil.appendSpace("S.No.", 7,	0));
						contents.append(hisutil.appendSpace("PROCEDURE/INV./SERVICE NAME", 40,	0));
						contents.append(hisutil.appendSpace("LOCATION", 11,	0));
						contents.append(hisutil.appendSpace("RATE(Rs.)", 10,0));
						contents.append(hisutil.appendSpace("QTY.", 6,	0));
						contents.append(hisutil.appendSpace("DISC.(Rs.)", 10,0));
						//contents.append(hisutil.appendSpace("S.TAX", 10,0));
						contents.append(hisutil.appendSpace("AMOUNT(Rs)", 10,	0));
						contents.append("\n");
						printLine++;

						contents.append("----------------------------------------------------------------------------------------------");
						contents.append("\n");
						printLine++;
					

					// /iterating printMap for printing tariff based on group

					concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

					if (cltamt > 0)
					{
						contents.append(hisutil.appendSpace("EXPENSE AMT   : ",	67, 1)+ hisutil.appendSpace(exp_amt, 12, 1) + "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)+ hisutil.appendSpace(clt_net_amt, 12, 1)+ "\n");
						printLine++;
						contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)+ hisutil.appendSpace(pat_net_amt, 12, 1)+ "\n");
						printLine++;
					} 
					else
					{
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
						//contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+ hisutil.appendSpace(exp_amt, 8, 1));
						contents.append(hisutil.appendSpace("TOTAL AMOUNT ",84, 1)+ hisutil.appendSpace(pat_net_amt, 10, 1));
						contents.append("\n");
						printLine++;
						contents.append(hisutil.appendSpace("---------------", 93,1));
						contents.append("\n");
						printLine++;
					}

					contents.append("\n");
					printLine++;

					//contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("CONCESSION AMT ",74, 1)+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
					contents.append("\n");
					printLine++;
					//contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(exp_amt, 7, 1));
					contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+ hisutil.appendSpace(pat_net_amt, 7, 1));
					contents.append("\n");
					printLine++;
					
					contents.append(hisutil.appendSpace("RUPEES (IN WORD) : "+hisutil.getAmountStr(pat_net_amt),94, 0));
					contents.append("\n");
					printLine++;
					printLine++;
					
					
				}					
			}
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.",94, 0));
			contents.append("\n");
			printLine++;
			printLine++;
			
			/*contents.append(hisutil.appendSpace("MODE OF PAYMENT: CASH/CREDIT CARD/DEBIT CARD/CHEQUE",94, 0));
			contents.append("\n");
			printLine++;
			*/
			/*switch (paymentMode) {
	        case "1":
	            PaymentModeName = "Cash";
				
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "2":
	            PaymentModeName = "Cheque";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "3":
	            PaymentModeName = "Demand Draft";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "4":
	            PaymentModeName = "Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "5":
	            PaymentModeName = "Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "6":
	            PaymentModeName = "Client";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        case "7":
	            PaymentModeName = "Patient Wallet";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			 case "8":
				PaymentModeName = "International Credit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "9":
				PaymentModeName = "International Debit Card";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	           break;
			case "10":
				PaymentModeName = "Cm Relief Fund";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "11":
				PaymentModeName = "Virtual Account";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "12":
				PaymentModeName = "Prisoner";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
			case "13":
				PaymentModeName = "Jan Arogya";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        default:
	            PaymentModeName = "Cash";
				contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
									contents.append("\n");
									printLine++;
	            break;
	        }*/
			contents.append(hisutil.appendSpace("MODE OF PAYMENT: "+PaymentModeName,94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("PAYMENT DETAILS:"+ hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(),94, 0));
			contents.append("\n");
			printLine++;

			if (strBillNo.startsWith("5"))
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} 
			else
			{
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}
		}

		strIsDirectMode = "0";
		
		content = PrintContents(strBServiceId, "1", contents.toString(),request);
		System.out.println("Ipd Services Reg------->" + contents.toString());
	} 
catch (Exception e)
{
e.printStackTrace();
throw new Exception("Billing  PrintHLP.IPD_SERVICES_REG() -->"+ e.getMessage());
} 
finally
{
voObj = null;
boObj = null;
hisutil = null;
billConfigUtil = null;
}
return content;
}	
public static boolean IPD_REFUND_WALLET(String strBillNo, String strReceiptNo,
		String strPatAccountNo, String strBServiceId, String strHospitalCode , HttpServletRequest request,int isDuplicateBill)
		throws Exception {
	

	if (strBillNo == null && strBillNo.length() != 10) {

		throw new Exception(
				"PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
	}

	if (strBServiceId == null && strBServiceId.length() != 2) {

		throw new Exception(
				"PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
	}

	if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

		throw new Exception(
				"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
	}

	if (strHospitalCode == null && strHospitalCode.length() != 3) {

		throw new Exception(
				"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
	}

	PrintVO voObj = null;
	PrintBO boObj = null;
	HisUtil hisutil = null;

	WebRowSet ws = null, ws1 = null;

	String contents = new String();

	// String rptName = BillConfigUtil.BILLING_RPT_NAME;

	String bill_date = null;
	String bill_no = null;
	String[] patient_name = null;
	String patient_category = null;
	String Crno = null;
	String adm_no = null;
	String pat_net_amt = null;
	String exp_amt = null;
	String dept = null;
	String serv_type=null;
	
	String approvalDtl = null;
	
	 BillConfigUtil billConfigUtil = null;
		
		boolean content = false;

		try {
			
			billConfigUtil = new BillConfigUtil(strHospitalCode);

		if (billConfigUtil.getGeneralReceiptType().trim().equals("2")) {

			contents = receiptPrint(strHospitalCode, strReceiptNo, strBillNo,
					billConfigUtil.getGeneralDuplicatePrint(), "IPD REFUND" , request,isDuplicateBill);

		} else {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrAcctNo(strPatAccountNo);

			boObj.IPD_REFUND(voObj);

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);

			String Header1 = brt.getBillFormatHeader1();
			String Header2 = brt.getBillFormatHeader2();
			String Header3 = brt.getBillFormatHeader3();
			String Header4 = brt.getBillFormatHeader4();
			String Footer = brt.getBillFormatFooter();

			ws = voObj.getStrIpdRefund();
			ws1 = voObj.getStrIpdRefund1();
		
			int len = ws1.size();

			String[] tariff_name = new String[len];
			String[] billed_qty = new String[len];
			String[] S_Tax = new String[len];
			String[] net_bill_amt = new String[len];
			String[] dis_amt = new String[len];

			for (int k = 0; ws.next(); k++) {
				bill_no = ws.getString(1);

				bill_date = ws.getString(2);

				patient_name = ws.getString(3).replace("^", "#").split("#");

				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				adm_no = ws.getString(6);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8),
						2);
				serv_type=ws.getString(9);
				dept = ws.getString(10);
				String ward = ws.getString(11);
				
				approvalDtl = ws.getString(12);
				
				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);
					dis_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(3), 2);
					S_Tax[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(4), 2);
					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                              \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
				printLine++;
				
				contents +=  hisutil.appendSpace("DATE & TIME :"+bill_date, 79,1)+"\n \n";
				printLine++;
				printLine++;
				
				contents += hisutil.appendSpace(" RECEIPT NO.", 12,0)+": "+hisutil.appendSpace(bill_no, 30,0)
				+   hisutil.appendSpace(" CATEGORY", 10,0)+": "+hisutil.appendSpace(patient_category.toUpperCase(), 20,0) +"\n";
				printLine++;
				printLine++;
				
				contents +=  hisutil.appendSpace(" CR No.", 12 ,0)     +": "+hisutil.appendSpace(Crno.toUpperCase(), 30,0)
				 +   hisutil.appendSpace(" WARD", 10,0)+": "+hisutil.appendSpace(ward.toUpperCase(), 20,0) +"\n";
				printLine++;
				printLine++;
				
				
				contents +=  hisutil.appendSpace(" NAME", 12,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 30, "~").get(0).toUpperCase(), 29,0)
				 		 +   hisutil.appendSpace(" AGE/SEX", 10,0)+": "+hisutil.appendSpace(patient_name[1].toUpperCase(), 20,0) +"\n";
				printLine++;
				printLine++;
				
				contents +=  hisutil.appendSpace(" SERVICE", 12,0)+": "+hisutil.appendSpace(serv_type, 62,0)+"\n";
				printLine++;
				printLine++;

				if(isServiceDiscountReq == 0){
					
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" DESCRIPTION", 50,0)
							 + hisutil.appendSpace("  RATE(Rs.)", 12,0)+ hisutil.appendSpace(" QTY.", 5,0)
							 + hisutil.appendSpace("  AMOUNT(Rs.)", 15,0)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
				}else{
					
					contents += "--------------------------------------------------------------------------------\n";
					printLine++;

					contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 36,0)
					 		 + hisutil.appendSpace(" Qty.", 9,0)+ hisutil.appendSpace(" Disc.", 11,0)
					 		 + hisutil.appendSpace(" S.Tax", 10,0)+ hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
					printLine++;

					contents += "--------------------------------------------------------------------------------\n";
					printLine++;	 
					
				}
				
				
				int tariffLen = 32;
				String strRate = "0";
				//String strRateUnit = ""; 

				if(isServiceDiscountReq == 0){
					
					tariffLen = 45;
				}
				
		 
				for (int i = 0; i < tariff_name.length; i++)

				{

					List<String> Tname = null;
					
					if(isServiceDiscountReq == 0){
						
						String strTemp[] =  tariff_name[i].replace("@", "#").split("#");
						
						strRate = strTemp[1].replace("/", "#").split("#")[0];
						
					//	strRateUnit = strTemp[1].replace("/", "#").split("#")[1];
						
						Tname = hisutil.breakString( strTemp[0].toUpperCase(), tariffLen, "~");
													 
						
					}else{
						
						Tname = hisutil.breakString(
								tariff_name[i].toUpperCase(), tariffLen, "~");
						
					}
					

					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							//contents += "\n";
							//printLine++;
							//contents +=  hisutil.appendSpace(" "+String.valueOf(++k) , 4,1)
							//	+ " " ;
													
							if(isServiceDiscountReq == 0){
									
								   contents += hisutil.appendSpace(" "+Tname.get(j).toUpperCase(), 48,0)
											+ hisutil.appendSpace(strRate, 12,1)
											+ hisutil.appendSpace(billed_qty[i].replace(" ", "#").split("#")[0], 6,1);
									 										
							}else{
										
								   contents += hisutil.appendSpace("  "+Tname.get(j), 35,0)
											+  hisutil.appendSpace(billed_qty[i], 9,1)
											+ hisutil.appendSpace(dis_amt[i], 8,1)
											+ hisutil.appendSpace(S_Tax[i], 10,1);
							}
								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 13, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							//printLine++;
							//contents +=  "       "+hisutil.appendSpace(Tname.get(j).toUpperCase(), 75,0);
							//contents += "\n";
						}
					}
				}


				//contents += "\n----------------------------------------------------------------------\n";
				//printLine++;
				//printLine++;
				
				contents += "\n";
				printLine++;
				  
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("TOTAL AMOUNT ", 67,1)+hisutil.appendSpace(exp_amt, 12,1)+ "\n";
					printLine++;
					contents +=hisutil.appendSpace("------------", 80,1)+ "\n";
					printLine++;
					
					String payDtl="";
					payDtl="XXXXXXXXXXX"+strPatAccountNo.subSequence(11, 15);
					contents +=  hisutil.appendSpace(" PAYMENT MODE", 12 ,0)     +": "+hisutil.appendSpace("WALLET", 25,0)
					   + hisutil.appendSpace(" PAYMENT DETAIL", 10,0)+": "+hisutil.appendSpace(payDtl, 20,0) +"\n";
					
				//	contents +=hisutil.appendSpace("Paid by Patient   : ", 57,1)+hisutil.appendSpace(pat_net_amt, 12,1)+ "\n";
				//	printLine++;

				
					contents += "    ON ACCOUNT OF    : CANCEL R.No. "+bill_no.replace("/", "#").split("#")[0]+"/1; "+approvalDtl.replace("^", "#").split("#")[4].toUpperCase();
					contents +="\n";
					printLine++;
					
					contents += "    AUTHORISED BY    : "+approvalDtl.replace("^", "#").split("#")[2].toUpperCase();
					contents +="\n";
					printLine++;
					
					

				contents += "\n";
				printLine++;
				printLine++;
				
				contents += "    RUPEES (IN WORD) : "
						+ hisutil.getAmountStr(pat_net_amt);

				//contents += "\n                                                    Cashier           ";
				contents +="\n";
				printLine++;
				printLine++;
				
				contents += Footer(Footer , request , brt.getBillDisclaimerRefund());

			}

		}
		content = PrintContents(strBServiceId, "2", contents , request);
		System.out.println("Ipd Refund------->" + contents);

	} catch (Exception e) {
		e.printStackTrace();

		throw new Exception("Billing  PrintHLP.IPDREFUND() -->"
				+ e.getMessage());

	} finally {

		voObj = null;
		boObj = null;
		hisutil = null;
		billConfigUtil = null;
	}

	return content;
}	
}