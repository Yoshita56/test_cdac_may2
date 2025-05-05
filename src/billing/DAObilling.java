package billing;

import java.util.ArrayList;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;

public class DAObilling {

	/**
	 * called from JSP page to find the group
	 * 
	 * @return arraylist containing 'group id' and 'group name'
	 */
	public WebRowSet getRows() {
		String qry = "select GROUP_ID, GROUP_NAME from test_group";
		WebRowSet wb = null;
		HisDAO obj = null;
		try {
			obj = new HisDAO("Billing", "DAObilling");
			int index1 = obj.setQuery(qry);
			wb = obj.executeQry(index1);
		} catch (Exception e) {
			new HisException("billing", "DAObilling.getRows()", e.getMessage());
		 
		} finally {
			obj.free();
			obj = null;
		}
		return wb;
	}

	public ArrayList getComboList(String grp_ID) {
		String comboQry = "select TARIFF_ID, TARIFF_NAME from ahis.test_tariff where GROUP_ID = ?";
		ArrayList Al_List = new ArrayList();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Billing", "DAObilling");
			int index1 = obj.setQuery(comboQry);
			obj.setQryValue(index1, 1, grp_ID);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("billing", "DAObilling.getComboList()", e
					.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}

	public ArrayList groupComboData() {
		String comboQry = "select GROUP_ID, GROUP_NAME from ahis.test_group ";
		ArrayList Al_List = new ArrayList();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Billing", "DAObilling");
			int index1 = obj.setQuery(comboQry);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("billing", "DAObilling.groupComboData()", e.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}
	public static void getReceiptDetailsListing(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		BillConfigUtil bcu = null;
		bcu = new BillConfigUtil( voObj.getStrValue8());  // This Use for Hospital Code
		String strErr = "";
        String strReOpenValidity=bcu.getIpdGenReOpenValidity(); 
      
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8(); // This Use for Hospital Code
		String strModeType = "1";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.proc_get_receipt_details_list(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try 
		{
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval",strModeType,1);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,2);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,3);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,4);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,6);
			daoObj.setProcInValue(nProcIndex, "reopenvalidity", strReOpenValidity,7);
			daoObj.setProcInValue(nProcIndex, "ipdfreecat", "0",8);
			daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGblWs1(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("DAObilling.getReceiptDetailsListing() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public ArrayList tariffComboData(String grp_ID) {
		String comboQry = "select TARIFF_ID, TARIFF_NAME from ahis.test_tariff where GROUP_ID = ?";
		ArrayList Al_List = new ArrayList();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Billing", "DAObilling");
			int index1 = obj.setQuery(comboQry);
			obj.setQryValue(index1, 1, grp_ID);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("billing", "DAObilling.groupComboData()", e
					.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}

	// //////////////////////Billing Header
	// Method////////////////////////////////
	public String PaymentType(BillingVO voHdrObj) throws Exception {
		HisDAO daoObj = null;
		String payType = null;
		WebRowSet web5 = null;
		String str = voHdrObj.getStrValue1();
		String strTemp[] = str.replace('@', '#').split("#");
		int i = Integer.parseInt(strTemp[0]); // Customer ID
		// ///////////////////////////////////////////////////
		int nqryIndex5;

		String strQuery5 = new String();
		try {
			daoObj = new HisDAO("Client Verification Transaction",
					"ClientVerificationDAO");

			strQuery5 = "SELECT HBLNUM_PAYMENT_TYPE FROM HBLT_CLIENT_MST WHERE HBLNUM_CLIENT_NO = "
					+ i + "  AND GNUM_ISVALID = 1";

			nqryIndex5 = daoObj.setQuery(strQuery5);

			web5 = daoObj.executeQry(nqryIndex5);
			while (web5.next()) {
				payType = web5.getString(1);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return payType;
	}

	public static void getClientDtlProc(BillingVO voHdrObj) {
		String str = voHdrObj.getStrValue1();
		// HisUtil hisutil = new HisUtil("transaction",
		// "ClientVerificTransDAO");
		String strTemp[] = str.replace('@', '#').split("#");

		String proc_name = "";

		proc_name = "{call ClientDetail(?,?,?)}";

		HisDAO dao = null;

		int procIndex = 0;

		String err = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getClientDtlProc()");

			procIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(procIndex, "CLIENTNO", strTemp[0],1);

			dao.setProcOutValue(procIndex, "ERR", 1,2); // 1 for string return
														// value

			dao.setProcOutValue(procIndex, "RESULTSET", 2,3); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(procIndex);

			// get value

			err = dao.getString(procIndex, "ERR");

			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex, "RESULTSET");
				voHdrObj.setGblWs1(ws);

			}

		} catch (Exception e) {
			voHdrObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voHdrObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}
	}

	public static void setPatientDtl(BillingVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.proc_pat_demo_address_dtl(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		String strCrNum = voObj.getStrValue1();

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {

				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,1);
				daoObj.setProcInValue(nProcIndex, "addresstype", "",2);
				daoObj.setProcOutValue(nProcIndex, "err", 3);
				daoObj.setProcOutValue(nProcIndex, "resultset", 4);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				
				if (strErr == null)
					strErr = "";
				
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				if (strErr.equals("") && ws.size() > 0) {
					voObj.setGblWs1(ws);
				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAObilling.setPatientDtl() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/// Created by Manisha
	/// Date 19-10-2015
	
	public static void setOnlineClientDtl(BillingVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_get_online_dtl(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
        String hospCode=voObj.getStrValue2();
		String strCrNum = voObj.getStrValue1();

		try {
			daoObj = new HisDAO("OnlineClient Details Ws", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {

				daoObj.setProcInValue(nProcIndex, "crno", strCrNum,1);
				daoObj.setProcInValue(nProcIndex, "hosp_code",hospCode,2);
				daoObj.setProcOutValue(nProcIndex, "err",1,3);
				daoObj.setProcOutValue(nProcIndex, "resultset",2,4);
				
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("") && ws.size() > 0) {
					voObj.setGblWs1(ws);
				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAObilling.setOnlineClientDetails() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
	
	
	

	// //////////////////////////////////////////////////////////////////////////////
	public static void getOnLineReqDiscount(BillingVO voObj) {
		// HisDAO daoObj = null;
		String str = voObj.getStrValue1();
		String str1 = voObj.getStrValue2();

		String proc_name1 = "";
// PROC_ONLINE_REQUEST Procedure not found -- Nitin 
		proc_name1 = "{call PROC_ONLINE_REQUEST(?,?,?,?)}";

		HisDAO dao = null;

		int procIndex1 = 0;

		String err = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getOnLineReqDiscount(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "Mode_Type", str1);

			dao.setProcInValue(procIndex1, "CRNO", str);

			dao.setProcOutValue(procIndex1, "ERRMSG", 1); // 1 for string
															// return value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERRMSG");

			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");

				voObj.setGblWs2(ws);

			}

		} catch (Exception e) {
		 
			voObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	public static void setTariffChargeDtl(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";

		String chargeTypeId = voObj.getStrValue1();
		String categoryCode = voObj.getStrValue2();
		String wardCode = voObj.getStrValue3();
		String groupId = voObj.getStrValue4();
		String searchText = voObj.getStrValue5();
		String hospitalCode = voObj.getStrValue6();
		String pkgFlag = voObj.getStrValue7();
		
		String searchType = voObj.getStrValue8();
		

		if (searchText == null)
			searchText = "";

		if (groupId.equals(""))
			groupId = null;
		if (wardCode.equals(""))
			wardCode = null;

		if (pkgFlag == null || pkgFlag.equals(""))
			pkgFlag = "2";

		String mode = "2";

		if (chargeTypeId != null && categoryCode != null) 
		{
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		}

		try 
		{
			daoObj = new HisDAO("Billing", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (chargeTypeId != null && categoryCode != null) 
			{
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", chargeTypeId,1);
				daoObj.setProcInValue(nProcIndex, "catCode", categoryCode,2);
				if (wardCode != null) 
					daoObj.setProcInValue(nProcIndex, "wardCode", wardCode,3);
				else
					daoObj.setProcInValue(nProcIndex, "wardCode", "",3);
				if (groupId != null) 
					daoObj.setProcInValue(nProcIndex, "groupId", groupId,4);
				else
					daoObj.setProcInValue(nProcIndex, "groupId", "0",4);
				daoObj.setProcInValue(nProcIndex, "searchTrfName", (searchText.equals(""))?"%" : searchText,5);
				daoObj.setProcInValue(nProcIndex, "searchMode", searchType,6);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospitalCode,7);
				//System.out.println("pkgFlag"+pkgFlag);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", pkgFlag,8);
				daoObj.setProcInValue(nProcIndex, "advance_flag", "0",9);
				daoObj.setProcInValue(nProcIndex, "modeVal", mode,10);
				daoObj.setProcInValue(nProcIndex, "end_date", "",11);
				daoObj.setProcOutValue(nProcIndex, "err", 1,12);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,13);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("wssssss"+ws.size());
				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{
				voObj.setGblWs1(null);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAObilling.setTariffChargeDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void setTariffChargeDtl1(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";

		String chargeTypeId = voObj.getStrValue1();
		String categoryCode = voObj.getStrValue2();
		String wardCode = voObj.getStrValue3();
		String groupId = voObj.getStrValue4();
		String searchText = voObj.getStrValue5();
		String hospitalCode = voObj.getStrValue6();
		String pkgFlag = voObj.getStrValue7();
		
		String searchType = voObj.getStrValue8();
		

		if (searchText == null)
			searchText = "";

		if (groupId.equals(""))
			groupId = null;
		if (wardCode.equals(""))
			wardCode = null;

		if (pkgFlag == null || pkgFlag.equals(""))
			pkgFlag = "2";

		String mode = "2";

		if (chargeTypeId != null && categoryCode != null) 
		{
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		}

		try 
		{
			daoObj = new HisDAO("Billing", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (chargeTypeId != null && categoryCode != null) 
			{
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", chargeTypeId,1);
				daoObj.setProcInValue(nProcIndex, "catCode", categoryCode,2);
				if (wardCode != null) 
					daoObj.setProcInValue(nProcIndex, "wardCode", wardCode,3);
				else
					daoObj.setProcInValue(nProcIndex, "wardCode", "",3);
				if (groupId != null) 
					daoObj.setProcInValue(nProcIndex, "groupId", groupId,4);
				else
					daoObj.setProcInValue(nProcIndex, "groupId", "0",4);
				daoObj.setProcInValue(nProcIndex, "searchTrfName", (searchText.equals(""))?"%" : searchText,5);
				daoObj.setProcInValue(nProcIndex, "searchMode", searchType,6);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospitalCode,7);
				System.out.println("pkgFlag"+pkgFlag);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", pkgFlag,8);
				daoObj.setProcInValue(nProcIndex, "advance_flag", "0",9);
				daoObj.setProcInValue(nProcIndex, "modeVal", mode,10);
				daoObj.setProcInValue(nProcIndex, "end_date", "",11);
				daoObj.setProcOutValue(nProcIndex, "err", 1,12);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,13);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("wssssss"+ws.size());
				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{
				voObj.setGblWs1(null);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAObilling.setTariffChargeDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void setTariffChargeDtl2(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";

		String chargeTypeId = voObj.getStrValue1();
		String categoryCode = voObj.getStrValue2();
		String wardCode = voObj.getStrValue3();
		String groupId = voObj.getStrValue4();
		String searchText = voObj.getStrValue5();
		String hospitalCode = voObj.getStrValue6();
		String pkgFlag = voObj.getStrValue7();
		
		String searchType = voObj.getStrValue8();
		

		if (searchText == null)
			searchText = "";

		if (groupId.equals(""))
			groupId = null;
		if (wardCode.equals(""))
			wardCode = null;

		if (pkgFlag == null || pkgFlag.equals(""))
			pkgFlag = "2";

		String mode = "5";

		if (chargeTypeId != null && categoryCode != null) 
		{
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		}

		try 
		{
			daoObj = new HisDAO("Billing", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (chargeTypeId != null && categoryCode != null) 
			{
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", chargeTypeId,1);
				daoObj.setProcInValue(nProcIndex, "catCode", categoryCode,2);
				if (wardCode != null) 
					daoObj.setProcInValue(nProcIndex, "wardCode", wardCode,3);
				else
					daoObj.setProcInValue(nProcIndex, "wardCode", "",3);
				/*if (groupId != null) 
					daoObj.setProcInValue(nProcIndex, "groupId", groupId,4);
				else
					daoObj.setProcInValue(nProcIndex, "groupId", "0",4);*/
				daoObj.setProcInValue(nProcIndex, "groupId", "107",4);
				daoObj.setProcInValue(nProcIndex, "searchTrfName", (searchText.equals(""))?"%" : searchText,5);
				daoObj.setProcInValue(nProcIndex, "searchMode", searchType,6);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospitalCode,7);
				System.out.println("pkgFlag"+pkgFlag);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", pkgFlag,8);
				daoObj.setProcInValue(nProcIndex, "advance_flag", "0",9);
				daoObj.setProcInValue(nProcIndex, "modeVal", mode,10);
				daoObj.setProcInValue(nProcIndex, "end_date", "",11);
				daoObj.setProcOutValue(nProcIndex, "err", 1,12);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,13);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("wssssss"+ws.size());
				if (strErr.equals("")) 
				{
					voObj.setGblWs1(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{
				voObj.setGblWs1(null);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAObilling.setTariffChargeDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void getStrTariffNameCombo(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Bill_view.rptb_hblt_tariff_combo(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("Billing","DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval","1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode().split("##")[0],2);
			daoObj.setProcInValue(nProcIndex, "grpId", voObj.getStrHospitalCode().split("##")[1],3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				System.out.println(ws.size());
				voObj.setStrTariffWs(ws);
								
			} else {
				throw new Exception(strErr);
			}
			
		} catch (Exception e) {
	 

			voObj
					.setStrMsgString("DAObilling.getStrTariffNameCombo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void setPatientListingDtl_from_InBound(BillingVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strPatListType = voObj.getStrValue1();
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8(); // This Use for Hospital
														// Code
		String strSeatId = voObj.getStrValue10();
		
		String strDeptCode = voObj.getStrValue9();
		
		String strModeType = "4";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		 		
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			System.out.println("pat list type is::"+strPatListType);
			daoObj.setProcInValue(nProcIndex, "mode_type", strModeType,1);
			daoObj.setProcInValue(nProcIndex, "seatId", strSeatId,11);
			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType,4);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,5);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,6);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,7);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,9);
			daoObj.setProcInValue(nProcIndex, "crno", "",2);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", "1",3);
			
			if(strPatListType.trim().equals("10")){
				
				daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode,10);
				
			}else{
				daoObj.setProcInValue(nProcIndex, "deptCode", "0",10);
			}
			
			daoObj.setProcOutValue(nProcIndex, "err", 1,12);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,13);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				voObj.setGblWs1(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAObilling.setPatientListingDtl_from_InBound() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void setPatientListingDtl_from_OutBound(BillingVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strPatListType = voObj.getStrValue1();
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8(); // This Use for Hospital
														// Code
		String strModeType = "4";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.Proc_Sblt_Outbound_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Billing", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "crno", "0",1);
			daoObj.setProcInValue(nProcIndex, "to_be_refund_pkg", "0",2);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", "0",3);
			daoObj.setProcInValue(nProcIndex, "modeval", strModeType,9);
			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType,4);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,5);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,6);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,7);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,10);
			daoObj.setProcOutValue(nProcIndex, "err", 1,11);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,12);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGblWs1(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAObilling.setPatientListingDtl_from_OutBound() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// ///////////////////////////////////////////////////////////////////////////
	public static void getOnLineReqDiscount(BillingVO voHdrObj, String mode) {
		// System.out.println("Inside DaoBilling.getOnLineReqDiscount");

		String str = voHdrObj.getStrValue1();
		// String str1 = voHdrObj.getStrValue2();
		// System.out.println("crNo.DaoonLine:"+str);
		// System.out.println("mode:"+mode);
		String str2 = mode;

		String deptCode = voHdrObj.getStrValue4();
		
		if(str.length() < 2){
			str = "0";
		}
		
		String proc_name1 = "";

		proc_name1 = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		if(mode.equals("6") && deptCode != null && !deptCode.equals("0"))
		{			
			proc_name1 = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";			
		}
		
		
		HisDAO dao = null;

		int procIndex1 = 0;

		String err = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getOnLineReqDiscount(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "Mode_Type", str2,1);
			dao.setProcInValue(procIndex1, "CRNO", str,2);
			dao.setProcInValue(procIndex1, "chargetypeid", "",3);
			dao.setProcInValue(procIndex1, "patlisttype", "",4);
			dao.setProcInValue(procIndex1, "searchstr", "",5);
			dao.setProcInValue(procIndex1, "searchtype", "",6);
			dao.setProcInValue(procIndex1, "frmrows", "",7);
			dao.setProcInValue(procIndex1, "torows", "",8);
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrValue3(),9);
			if(mode.equals("6") && deptCode != null && !deptCode.equals("0"))
				dao.setProcInValue(procIndex1, "deptCode", deptCode,10);
			else
				dao.setProcInValue(procIndex1, "deptCode", deptCode,10);
			dao.setProcInValue(procIndex1, "seatid", "",11);
			dao.setProcOutValue(procIndex1, "ERR", 1,12); // 1 for string return
		// value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,13); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value

			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			// System.out.println("Insid-->"+ws);
			voHdrObj.setGblWs2(ws);

		} catch (Exception e) {
			 
			voHdrObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voHdrObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	// ////////////////////////////////////////////////////////////////

	public static void setcashCollectionDetail_from_OutBound(BillingVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strHospitalCode=voObj.getStrValue1();// This Use for Hospital code
		String strSeatId=voObj.getStrValue2(); // This is for seat id
				

		String strProcName = "{call PKG_BILL_VIEW.proc_cashcoll_outbound_dtl(?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Cash Collection Detail Ws", "DAObilling");

			System.out.println("hospital code::"+strHospitalCode+"::seat::"+strSeatId);
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,1);

			daoObj.setProcInValue(nProcIndex, "seat_id", strSeatId,2);

			daoObj.setProcOutValue(nProcIndex, "err", 1,3);

			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGblWs1(ws);
								

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAObilling.setcashCollectionDetail_from_OutBound() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		
	}

	//get online requests for credit billing approval
	public static void getOnLineReqCreditBillApproval(BillingVO voHdrObj, String mode) {
		// System.out.println("Inside DaoBilling.getOnLineReqDiscount");
		
		String str = voHdrObj.getStrValue1();
		// String str1 = voHdrObj.getStrValue2();
		// System.out.println("crNo.DaoonLine:"+str);
		// System.out.println("mode:"+mode);
		String str2 = mode;

		String deptCode = voHdrObj.getStrValue4();
		
		if(str.length() < 2){
			str = "0";
		}
		
		String proc_name1 = "";

		proc_name1 = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		if(mode.equals("6") && deptCode != null && !deptCode.equals("0"))
		{			
			proc_name1 = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";			
		}
		
		
		HisDAO dao = null;

		int procIndex1 = 0;

		String err = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("billing",
					"transactions.DAObilling.getOnLineReqDiscount(BillingVO voHdrObj)");

			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "Mode_Type", str2,1);
			dao.setProcInValue(procIndex1, "CRNO", str,2);
			dao.setProcInValue(procIndex1, "chargetypeid", "",3);
			dao.setProcInValue(procIndex1, "patlisttype", "",4);
			dao.setProcInValue(procIndex1, "searchstr", "",5);
			dao.setProcInValue(procIndex1, "searchtype", "",6);
			dao.setProcInValue(procIndex1, "frmrows", "",7);
			dao.setProcInValue(procIndex1, "torows", "",8);
			dao.setProcInValue(procIndex1, "hosp_code", voHdrObj.getStrValue3(),9);
			if(mode.equals("6") && deptCode != null && !deptCode.equals("0"))
				dao.setProcInValue(procIndex1, "deptCode", deptCode,10);
			else
				dao.setProcInValue(procIndex1, "deptCode", deptCode,10);
			dao.setProcInValue(procIndex1, "seatid", "",11);
			dao.setProcOutValue(procIndex1, "ERR", 1,12); // 1 for string return
		// value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2,13); // 2 for object
			// execute procedure
			dao.executeProcedureByPosition(procIndex1);
			// get value

			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");
			 System.out.println("Insid-->"+ws.size());
			 
			 if(ws.size() == 0)
			 {
				 ws=null;
				 System.out.println("ws set to null cz size is zero.....");
			 }
			 
			voHdrObj.setGblWs2(ws);

		} catch (Exception e) {
			 e.printStackTrace();
			voHdrObj.setStrMsgString("BillHeaderDAO.getOnLineReqCreditBillApproval() --> "
					+ e.getMessage());
			voHdrObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}
	/**
	 * retrieves unit list based on cr no,cat code id and hospital code
	 * 
	 * @param voObj
	 */
	public static void getCreditLettersList(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_credit_letters_list(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Billing","DAOBilling");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			/*System.out.println("cr no"+voObj.getStrValue1());
			System.out.println("catcode"+voObj.getStrCatCode());
			System.out.println("hosp_code"+voObj.getStrHospitalCode());*/
			daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrValue1(),2);//CR No
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrCatCode().replace("^","#").split("#")[0],3);//SENT FROM JS FUNCTION AND SET IN VO	
			daoObj.setProcInValue(nProcIndex, "clientcode", "",4);
			daoObj.setProcInValue(nProcIndex, "serviceType", voObj.getStrServiceType(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),6);
			daoObj.setProcOutValue(nProcIndex, "err", 1,7);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,8);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setCreditLetterListWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOBilling.getCreditLettersList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getCreditLettersList1(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_credit_letters_list(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Billing","DAOBilling");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
			/*System.out.println("cr no"+voObj.getStrValue1());
			System.out.println("catcode"+voObj.getStrCatCode());
			System.out.println("hosp_code"+voObj.getStrHospitalCode());*/
			daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrValue1(),2);//CR No
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrCatCode().replace("^","#").split("#")[0],3);//SENT FROM JS FUNCTION AND SET IN VO	
			daoObj.setProcInValue(nProcIndex, "clientcode", "",4);
			daoObj.setProcInValue(nProcIndex, "serviceType", voObj.getStrServiceType(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),6);
			daoObj.setProcOutValue(nProcIndex, "err", 1,7);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,8);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setCreditLetterListWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOBilling.getCreditLettersList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getPackageDetails(BillingVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";
		strProcName = "{call PKG_BILL_VIEW.proc_package_details(?,?,?,?,?,?,?)}";
		

		try 
		{
			daoObj = new HisDAO("Billing", "DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "crno", voObj.getStrCrNo(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "accno", voObj.getStrAccNo(),4);
			daoObj.setProcInValue(nProcIndex, "packageid", voObj.getStrPackageId(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				System.out.println("wssssss"+ws.size());
				if (strErr.equals("")) 
				{
					voObj.setPackagews(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			
		
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAObilling.setTariffChargeDtl() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}

}
