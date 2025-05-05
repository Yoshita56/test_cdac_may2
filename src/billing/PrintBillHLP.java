package billing;

import hisglobal.utility.HisPrinter;
import hisglobal.utility.HisUtil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

/**
 * 
 * @author Amit Kumar
 * 
 */

public class PrintBillHLP {
	public static int printLine = 0;

	public static int isDuplicateBill = 0;

	// 0 - Original, 1 - Duplicate

	public static int isServiceDiscountReq = 0;
	
	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR+""+'E';
	public static final String BOLDOFF = ESCAPECHAR+""+'F';
	
	public static final char FORMFEED = 12;
	
	/**
	 * FINAL_ADJUSTMENT(vo) -- > This Method is Used to get WebRowSet for
	 * Approved By Combo
	 * 
	 * @throws Exception
	 * 
	 */

	public static boolean FINAL_ADJUSTMENT(String strRequestNo,
			String strBServiceId, String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo , HttpServletRequest request)
			throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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
		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
			

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
				+ "                          Final Adjustment Bill\n";
		printLine++;
				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				contents += "-----------------------------------------------------------------------\n";
				printLine++;

				if (strBillType.equals("1")) {
					contents += "Description              Amount(Rs.) | Description               Amount\n";
					printLine++;

					contents += "-----------------------------------------------------------------------\n";
					printLine++;

					contents += Consolidated(strPatAccountNo,
							strHospitalCode, strBillType, strReceiptNo);
				} else {
					contents += "Description                      Date         Qty.       Amount (Rs.)  \n";
					printLine++;

					contents += "-----------------------------------------------------------------------\n";
					printLine++;

					contents += Detailed(strPatAccountNo, strHospitalCode,
							strBillType, strReceiptNo);
				}

				contents += "\n-----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				for (int i = 0; i < tariff_name.length; i++)

				{
					List<String> Tname = hisutil.breakString(tariff_name[i],
							22, "~");
					for (int j = 0; j < Tname.size(); j++) {
						if (j == 0) {
							contents += "\n";
							printLine++;
							contents += ""
									+ (++k)
									+ "     "
									+ hisutil.appendSpace(Tname.get(j), 34,0)
									+ " "
									+ hisutil.appendSpace(billed_qty[i], 13,1)
									+ "    "
									+ hisutil.getAmountStr( net_bill_amt[i])
									+ "\n";
							printLine++;
						} else {
							contents += "      "
									+ hisutil.appendSpace(Tname.get(j), 65,0);
						}
					}
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}

				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerFinalBill());
		
			}

			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Final Adjustment------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.FINAL_ADJUSTMENT() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * findPrintType(vo) -- > This Method is Used to Select the Report Print
	 * Type
	 * 
	 * @throws Exception
	 */
	public static void findPrintType1(String strRequestNo,
			String strBServiceId, String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo,
			String strReceiptType , HttpServletRequest request ) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_SERVICES(strRequestNo, strBServiceId, strHospitalCode,
						strReceiptNo , request); // Print Type
			}
			if (strBServiceId.equals("11")) {
				IPD_SERVICES(strRequestNo, strPatAccountNo, strBServiceId,
						strHospitalCode, strReceiptNo, request); // Print Type
			}
			if (strBServiceId.equals("19")) {
				ADVANCE(strRequestNo, strBServiceId, strHospitalCode,
						strReceiptNo, request); // Print Type
			}
			if (strBServiceId.equals("20")) {
				PART_PAYMENT(strRequestNo, strBServiceId, strHospitalCode,
						strReceiptNo, request); // Print Type
			}

			if (strBServiceId.equals("21")) {
				FINAL_ADJUSTMENT(strRequestNo, strBServiceId, strPatAccountNo,
						strHospitalCode, strBillType, strReceiptNo , request); // Print
				// Type
			}

		}
		if (strReceiptType.equals("2")) {
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_REFUND(strRequestNo, strReceiptNo, strBServiceId,
						strHospitalCode, request); // Print Type
			}
			if (strBServiceId.equals("11")) {
				IPD_REFUND(strRequestNo, strReceiptNo, strPatAccountNo,
						strBServiceId, strHospitalCode, request); // Print Type
			}
			if (strBServiceId.equals("19")) {
				ADVANCE_REFUND(strRequestNo, strReceiptNo, strBServiceId,
						strHospitalCode, request); // Print Type
			}
		}
		if (strReceiptType.equals("3")) {
			if (strBServiceId.equals("10") || strBServiceId.equals("12")) {
				OPD_RECONCILIATION(strRequestNo, strReceiptNo, strBServiceId,
						strHospitalCode, request); // Print Type
			}
			if (strBServiceId.equals("11")) {
				IPD_RECONCILIATION(strRequestNo, strReceiptNo, strPatAccountNo,
						strBServiceId, strHospitalCode, request); // Print Type
			}
			if (strBServiceId.equals("21")) {
				IPD_FINAL_SETTLE(strRequestNo, strReceiptNo, strBServiceId,
						strHospitalCode, request); // Print Type
			}
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
			contents1 = " Client Name: " + hisutil.appendSpace(Client_Name, 22,0)
					+ "\tAuth No.          : " + Auth_No + "\n";
			printLine++;
			contents1 += " Auth Date: " + hisutil.appendSpace(Auth_Date, 27,0)
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

		if (Header1.equals("") || Header1.equals("0")) {
			H1 = "";
		} else {
			H1 = Header1;
			contents2 += "                          " + H1 + "\n ";
			printLine++;
		}
		if (Header2.equals("") || Header2.equals("0")) {
			H2 = "";
		} else {
			H2 = Header2;
			contents2 += "                          " + H2 + "\n ";
			printLine++;
		}
		if (Header3.equals("") || Header3.equals("0")) {
			H3 = "";
		} else {
			H3 = Header3;
			contents2 += "                          " + H3 + "\n ";
			printLine++;
		}
		if (Header4.equals("") || Header4.equals("0")) {
			H4 = "";
		} else {
			H4 = Header4;
			contents2 += "                          " + H4 + "  \n";
			printLine++;
		}
		contents2 += "                                  \n";
		printLine++;

		return contents2;
	}

	/**
	 * Footer(String ConCatVal) -- > This Method is Used to get Client Detail
	 * String If we pass Client Detail in Concat Format
	 * like:-Header1^Header2^Header3^Header4
	 */
	public static String Footer(String Footer , String strDisclaimer) {
		String contents3 = new String();
		String F1 = null;
		String disclaimer = null;
		
		if (Footer.equals("") || Footer.equals("0")) {
			F1 = "";
		} else {
			F1 = Footer;
		}
		
		if (strDisclaimer.equals("") || strDisclaimer.equals("0")) {
			disclaimer = "";
		} else {
			disclaimer = strDisclaimer;
		}
		
		contents3 = "\n                    " + F1 + 
		"\n			"+disclaimer;
		printLine++;

		return contents3;
	}

	/**
	 * OPD_REFUND(vo) -- > This Method is Used to get Print Type in OPD-REFUND
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_REFUND(String strRequestNo, String strReceiptNo,
			String strBServiceId, String strHospitalCode , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                          TEST RECEIPT      \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;
				
				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
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
					  

				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

	if(strReceiptNo.startsWith("5")){
					
					contents += Footer(Footer , brt.getBillDisclaimerWithoutCrNo());
					
				}else{
					contents += Footer(Footer , brt.getBillDisclaimerRefund());

				}

			}

			content = PrintContents(strBServiceId, "2", contents , request);
			System.out.println("Opd Refund------->" + contents);
		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.OPDREFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * OPD_RECONCILIATION(vo) -- > This Method is Used to get Print Type in
	 * OPD-RECONCILIATION Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_RECONCILIATION(String strRequestNo,
			String strReceiptNo, String strBServiceId, String strHospitalCode , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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
		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                         OPD  RECONCIALTION BILL\n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;
				
				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
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

				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerServices());

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

		}

		return content;
	}

	/**
	 * OPD_SERVICES(vo) -- > This Method is Used to get Print Type in
	 * OPD_SERVICES Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_SERVICES(String strRequestNo,
			String strBServiceId, String strHospitalCode, String strReceiptNo , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
			

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                            TEST RECEIPT     \n";

				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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
				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;
				

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}

				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				if(strReceiptNo.startsWith("5")){
					
					contents += Footer(Footer , brt.getBillDisclaimerWithoutCrNo());
					
				}else{
					contents += Footer(Footer , brt.getBillDisclaimerServices());

				}

			}

			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Opd Services------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * IPD_FINAL_SETTLE(vo) -- > This Method is Used to get Print Type in
	 * IPD_FINAL_SETTLE Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_FINAL_SETTLE(String strRequestNo,
			String strReceiptNo, String strBServiceId, String strHospitalCode , HttpServletRequest request) throws Exception {
		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

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

				contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
				 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
				+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
				+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1], 13,0) +"\n";
				printLine++;

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;
				

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}

				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerFinalBill());

			}

			content = PrintContents(strBServiceId , "1", contents , request);
			System.out.println("Ipd Final Settlement------->" + contents);

		} catch (Exception e) {

			throw new Exception("Billing  PrintHLP.IPD_FINAL_SETTLE() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * ADVANCE_REFUND(vo) -- > This Method is Used to get Print Type in
	 * ADVANCE_REFUND Case
	 * 
	 * @throws Exception
	 */
	public static boolean ADVANCE_REFUND(String strRequestNo,
			String strReceiptNo, String strBServiceId, String strHospitalCode , HttpServletRequest request) throws Exception {
		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
	

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				// strHidden = ws.getString(9);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                   ADVANCE REFUND BILL     \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
				printLine++;

				contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
				 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
				+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
				+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1].trim(), 13,0) +"\n";
				printLine++;

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerAdvance());

			}

			content = PrintContents(strBServiceId , "2", contents , request);
			System.out.println("Advance Refund------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.ADVANCE_REFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * ADVANCE(vo) -- > This Method is Used to get Print Type in ADVANCE Case
	 * 
	 * @throws Exception
	 */
	public static boolean ADVANCE(String strRequestNo, String strBServiceId,
			String strHospitalCode, String strReceiptNo , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                             ADVANCE BILL     \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
				printLine++;

				contents +=  hisutil.appendSpace(" CR No.", 9 ,0)     +": "+hisutil.appendSpace(Crno, 26,0)
				 +   hisutil.appendSpace(" Receipt No.", 18,0)+": "+hisutil.appendSpace(bill_no, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Name", 9,0)     +": "+hisutil.appendSpace( hisutil.breakString( patient_name[0], 25, "~").get(0), 26,0)
				+   hisutil.appendSpace(" Patient Category", 18,0)+": "+hisutil.appendSpace(patient_category, 13,0) +"\n";
				printLine++;
		
				contents +=  hisutil.appendSpace(" Date", 9,0)     +": "+hisutil.appendSpace(bill_date, 26,0)
				+   hisutil.appendSpace(" Age/Sex", 18,0)+": "+hisutil.appendSpace(patient_name[1].trim(), 13,0) +"\n";
				printLine++;

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerAdvance());

			}

			content = PrintContents(strBServiceId , "1", contents , request);
			System.out.println("Advance----->" + contents);
		}

		catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.ADVANCE() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * PART_PAYMENT_DUP(vo) -- > This Method is Used to get Print Type in
	 * PART_PAYMENT_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean PART_PAYMENT(String strRequestNo,
			String strBServiceId, String strHospitalCode, String strReceiptNo , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;
		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                            PART PAYMENT BILL     \n";

				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerPartPayment());

			}

			content = PrintContents(strBServiceId, "1", contents , request);
			System.out.println("Part Payment------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.PART_PAYMENT() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
		}

		return content;
	}

	/**
	 * IPD_REFUND(vo) -- > This Method is Used to get Print Type in IPD_REFUND
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_REFUND(String strRequestNo, String strReceiptNo,
			String strPatAccountNo, String strBServiceId, String strHospitalCode , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                          IPD REFUND BILL      \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerRefund());

			}

			content = PrintContents(strBServiceId , "2", contents , request);
			System.out.println("Ipd Refund------->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.IPDREFUND() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return content;
	}

	/**
	 * IPD_RECONCILIATION(vo) -- > This Method is Used to get Print Type in
	 * IPD_RECONCILIATION Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_RECONCILIATION(String strRequestNo,
			String strReceiptNo, String strPatAccountNo, String strBServiceId,
			String strHospitalCode , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
	

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				// strHidden = ws.getString(9);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                         IPD RECONCILIATION BILL      \n";
				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerServices());

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

		}

		return content;
	}

	/**
	 * IPD_SERVICES_DUP(vo) -- > This Method is Used to get Print Type in
	 * IPD_SERVICES_DUP Case
	 * 
	 * @throws Exception
	 */
	public static boolean IPD_SERVICES(String strRequestNo,
			String strPatAccountNo, String strBServiceId,
			String strHospitalCode, String strReceiptNo , HttpServletRequest request) throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
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
		double payable_amt_temp = 0;

		String payable_amt = "0";

		boolean content = false;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrRequestNo(strRequestNo);
			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrHospCode(strHospitalCode);

			boObj.OPD_REFUND(voObj);
			ws = voObj.getStrOpdRefund();
			ws1 = voObj.getStrOpdRefund1();
		

			int length = ws1.size();

			String[] tariff_name = new String[length];
			String[] billed_qty = new String[length];
			String[] net_bill_amt = new String[length];

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

				payable_amt = HisUtil.getAmountWithDecimal(ws.getString(5), 2);

				for (int n = 0; ws1.next(); n++) {
					tariff_name[n] = ws1.getString(1);
					billed_qty[n] = ws1.getString(2);

					net_bill_amt[n] = HisUtil.getAmountWithDecimal(ws1
							.getString(5), 2);
				}

				contents += Header(Header1, Header2, Header3, Header4)
						+ "                            IPD SERVICES BILL      \n";

				printLine++;

				if (isDuplicateBill == 1) {

					contents += "                          (Duplicate)    \n";
					printLine++;
				}

				contents += "\n";
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

				// contents += MakeClientDtlStr(strHidden);

				contents += "----------------------------------------------------------------------\n";
				printLine++;

				contents += hisutil.appendSpace(" S.No.", 6,0)+ hisutil.appendSpace(" Description", 34,0)
				 + hisutil.appendSpace(" Rate", 11,0)+ hisutil.appendSpace(" Qty.", 9,0)
				 + hisutil.appendSpace(" Amt(Rs.)", 11,0)+"\n";
				printLine++;

				contents += "----------------------------------------------------------------------";
				printLine++;

				int tariffLen = 25;
				String strRate = "0";

								
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
											 
									
								   contents += hisutil.appendSpace("  "+Tname.get(j), 33,0)
											+ hisutil.appendSpace(strRate, 11,1)
											+ hisutil.appendSpace(billed_qty[i], 9,1);
									 										
							 								
									contents += hisutil.appendSpace(HisUtil.getAmountWithDecimal(net_bill_amt[i],2) , 11, 1 ) ;
									contents += "\n";
							printLine++;
						} else {
						
							printLine++;
							contents +=  "       "+hisutil.appendSpace(Tname.get(j), 65,0);
							contents += "\n";
						}
					}
					
					payable_amt_temp = payable_amt_temp
							+ Double.parseDouble(net_bill_amt[i]);

				}
				payable_amt = HisUtil.getAmountWithDecimal(payable_amt_temp, 2);

				contents += "\n\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "                                          Payable Amount   : "
						+ payable_amt + "\n";
				printLine++;

				contents += "\n----------------------------------------------------------------------\n";
				printLine++;
				printLine++;

				contents += "    Rs.(in Word) : "
						+ hisutil.getAmountStr(payable_amt);

				contents += "\n\n                                                    Cashier           ";
				printLine++;
				printLine++;

				contents += "\n                                                                        ";
				printLine++;

				contents += Footer(Footer , brt.getBillDisclaimerServices());

			}

			content = PrintContents(strBServiceId , "1", contents , request);
			System.out.println("Ipd Services----->" + contents);

		} catch (Exception e) {
			e.printStackTrace();

			throw new Exception("Billing  PrintHLP.IPD_SERVICES() -->"
					+ e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;
		}

		return content;
	}

	public static boolean PrintContents(String bServiceId, String receiptType, String contents, HttpServletRequest request) {

		contents += FORMFEED;
		
		
		new HisPrinter().printFile(contents, "Billing", request);
		
		return true;
	}

	/**
	 * Consolidated(String ConCatVal) -- >
	 * 
	 * @throws Exception
	 */
	public static String Consolidated(String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo)
			throws Exception {

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		HisUtil hisutil = null;
		PrintBillVO voObj = null;
		PrintBillBO boObj = null;

		String contents = new String();
		WebRowSet ws = null;

		int k = 1;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.FINAL_ADJUSTMENT2(voObj);
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
				printLine++;
				k++;
			}

		} catch (Exception e) {
			throw new Exception("PrintHLP.Consolidated()-->" + e.getMessage());

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
	public static String Detailed(String strPatAccountNo,
			String strHospitalCode, String strBillType, String strReceiptNo)
			throws Exception {

		if (strPatAccountNo == null && strPatAccountNo.length() != 10) {

			throw new Exception(
					"PrintHLP.Detailed()--> Patient Account No. Cannot be Blank or Invalid");
		}

		if (strHospitalCode == null && strHospitalCode.length() != 3) {

			throw new Exception(
					"PrintHLP.Detailed()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;
		HisUtil hisutil = null;

		String contents = new String();
		String strGrpName1 = "";
		String strGrpName2 = "";
		WebRowSet ws = null;
		// int k = 1;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrAcctNo(strPatAccountNo);
			voObj.setStrHospCode(strHospitalCode);
			voObj.setStrReceiptType(strBillType);

			boObj.FINAL_ADJUSTMENT2(voObj);
			ws = voObj.getGblWs1();

			for (int i = 0; ws.next(); i++) {

				strGrpName2 = (ws.getString(1)).trim();
				//
				if (strGrpName1.equals(strGrpName2)) {
					contents += FinalBillTariffDtl(hisutil, ws.getString(3), ws
							.getString(4), ws.getString(2), ws.getString(5));
				} else {
					if (i == 0) {
						contents += "*" + strGrpName2 + "\n";
					} else {
						printLine++;
						printLine++;
						contents += "----------------------------------------------------------------------\n";
						contents += "*" + strGrpName2 + "\n";
					}

					contents += FinalBillTariffDtl(hisutil, ws.getString(3), ws
							.getString(4), ws.getString(2), ws.getString(5));
				}

				strGrpName1 = strGrpName2;
				contents += "\n";
				printLine++;
			}

		} catch (Exception e) {

			throw new Exception("PrintHLP.Detailed()-->" + e.getMessage());

		} finally {

			voObj = null;
			boObj = null;
			hisutil = null;

		}

		return contents;
	}

	private static String FinalBillTariffDtl(HisUtil hisutil, String trfName,
			String netAmt, String strDate, String qty) {

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

				trfContents += Tname.get(j);
			}
		}

		return trfContents;
	}

	/**
	 * method used to update the print status (in case of Bill not printed
	 * properly)
	 * 
	 * @param strRequestNo
	 * @param strReceiptNo
	 * @param strHospitalCode
	 * @throws Exception
	 */
	public static void updatePrintStatus(String strRequestNo,
			String strReceiptNo, String strHospitalCode, String strPrintFlag)
			throws Exception {

		if (strRequestNo == null && strRequestNo.length() != 10) {

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

		PrintBillVO voObj = null;
		PrintBillBO boObj = null;

		try {

			voObj = new PrintBillVO();
			boObj = new PrintBillBO();

			voObj.setStrRequestNo(strRequestNo);
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

}
