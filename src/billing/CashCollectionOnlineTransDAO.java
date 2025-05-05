package billing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import hisglobal.utility.GetNetworkAddress;

import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.dao.BillDAO;
import billing.dao.BillReceiptDAO;
import billing.dao.BillReqPackageDAO;
import billing.dao.BillRequisitionTariffDAO;
import billing.dao.ClientPatientDAO;
import billing.dao.OutBoundDAO;
import billing.dao.PatientAccountDAO;
import billing.dao.PatientAccountServiceDAO;
import billing.dao.PaymentDAO;
import billing.dao.PrimaryKeyDAO;
import billing.dao.PrimaryKeyLogDAO;


public class CashCollectionOnlineTransDAO {

	/**
	 * retrieves Online Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOnlineDetails(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try {

			if (strCrNumber != null) {
				daoObj = new HisDAO("Billing","CashCollectionOnlineTransDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "Mode_Type", "1",1);
				daoObj.setProcInValue(nProcIndex, "CRNO", strCrNumber,2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,9);
				daoObj.setProcInValue(nProcIndex, "seatId", "0",11);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", "",3);
				daoObj.setProcInValue(nProcIndex, "patListType", "",4);
				daoObj.setProcInValue(nProcIndex, "searchStr", "",5);
				daoObj.setProcInValue(nProcIndex, "searchType", "",6);
				daoObj.setProcInValue(nProcIndex, "frmRows", "",7);
				daoObj.setProcInValue(nProcIndex, "toRows", "",8);
				daoObj.setProcInValue(nProcIndex, "deptCode", "",10);
				
				daoObj.setProcOutValue(nProcIndex, "ERR", 1,12);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,13);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "ERR");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {
					ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

					voObj.setOnlineDetails(ws);
				} else {
					throw new Exception(strErr);
				}
			} else {

				voObj.setOnlineDetails(null);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOnlineDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Tariff Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOnlineTariffDetails(CashCollectionOnlineTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_billreq_tariff_dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strReqNo = voObj.getStrRequestNo();
		String strHospCode = voObj.getStrHospitalCode();
		String strChargeTypeId = voObj.getStrChargeTypeId();
		

		String strErr = "";

		try 
		{
			if (strReqNo != null) 
			{
				daoObj = new HisDAO("Billing","CashCollectionTransDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "reqNo", strReqNo,1);
				daoObj.setProcInValue(nProcIndex, "modeVal", "6",2);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,3);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId",strChargeTypeId,4);
				daoObj.setProcInValue(nProcIndex, "deptCode", voObj.getStrSeatId(),5);
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) 
				{
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setOnlineTariffDetails(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{
				voObj.setOnlineTariffDetails(null);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getOnlineTariffDetails() --> "+ e.getMessage());
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

	/**
	 * retrieves Patient Account Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientNumber(CashCollectionOnlineTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strAccNo = voObj.getStrAccountNo();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try 
		{
			if (strAccNo != null) 
			{
				daoObj = new HisDAO("Billing","CashCollectionTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "accno", strAccNo,1);
				daoObj.setProcInValue(nProcIndex, "puk", "",2);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", "",3);
				daoObj.setProcInValue(nProcIndex, "activeAccount", "",4);				
				daoObj.setProcInValue(nProcIndex, "modeval", "1",5);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,6);				
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,8);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) 
				{
					ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					if (ws != null) 
					{
						if (ws.next()) 
						{
							voObj.setStrClientPatientNo(ws.getString(4));
							voObj.setStrSancAmount(ws.getString(7));
							voObj.setStrClientBalance(ws.getString(17));
							voObj.setStrClientAmount(ws.getString(9));
						}
					} 
					else 
					{
						voObj.setStrClientPatientNo(null);
					}
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{

				voObj.setOnlineTariffDetails(null);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getClientPatientNumber() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	//client patient no for credit billing ipd..
	public static void getClientPatientNumberCreditBillIpd(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

				daoObj = new HisDAO("Cash Collection Transaction","CashCollectionTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "accno", "0",1);
				daoObj.setProcInValue(nProcIndex, "modeval", "7",5);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,6);
				daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(),2);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", "",3);
				daoObj.setProcInValue(nProcIndex, "activeAccount", "",4);
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,8);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

					if (ws != null) {

						if (ws.next()) {

							voObj.setStrClientPatientNo(ws.getString(1));

						}
					} else {
						voObj.setStrClientPatientNo(null);
					}

				} else {
					throw new Exception(strErr);
				}
			

		} catch (Exception e) {

			e.printStackTrace();
			voObj
					.setStrMsgString("CashCollectionTransDAO.getClientPatientNumber() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Client Patient Details using Client Patient Number.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientDetailsWithClientPatNo(CashCollectionOnlineTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strClientPatNo = voObj.getStrClientPatientNo();
		String strChargeTypeId = voObj.getStrChargeTypeId();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrBillNo();
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Billing","CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "clientpatno", strClientPatNo,2);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId,4);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo,6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",5);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "",3);
			daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(),1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,7);
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,9);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null) 
				{
					voObj.setOnlineClientDetails(ws);
				} 
				else 
				{
					voObj.setOnlineClientDetails(null);
				}
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getClientPatientDetailsWithClientPatNo() --> "+ e.getMessage());
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

	/**
	 * retrieves Client Patient Details using Cr Number
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientDetailsWithCrNo(
			CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrChargeTypeId();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrBillNo();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber,1);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId,4);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "",3);
			daoObj.setProcInValue(nProcIndex, "clientpatno", "",2);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo,6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,7);
			daoObj.setProcOutValue(nProcIndex, "err", 1,8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,9);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null) {

					voObj.setOnlineClientDetails(ws);

				} else {
					voObj.setOnlineClientDetails(null);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getClientPatientDetailsWithCrNo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Payment Mode List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getPaymentModeList(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_paymentmode_mst(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,4);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrPaymentModeList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getPaymentModeList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/**
	 * retrieves QR Code Mode List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getQRCodeModeList(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_qrcodemode_mst(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,4);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrQRCodeModeList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getPaymentModeList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	/**
	 * retrieves Client Name List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientNameList(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_mst(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,2);
			daoObj.setProcInValue(nProcIndex, "client_no", "",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,5);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setStrClientNameList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getClientNameList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void getRequestNoList(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_type", "5",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),9);
			daoObj.setProcInValue(nProcIndex, "seatId", "0",11);
			daoObj.setProcInValue(nProcIndex, "crno", "",2);
			daoObj.setProcInValue(nProcIndex, "chargeTypeId", "",3);
			daoObj.setProcInValue(nProcIndex, "patListType", "",4);
			daoObj.setProcInValue(nProcIndex, "searchStr", "",5);
			daoObj.setProcInValue(nProcIndex, "searchType", "",6);
			daoObj.setProcInValue(nProcIndex, "frmRows", "",7);
			daoObj.setProcInValue(nProcIndex, "toRows", "",8);
			daoObj.setProcInValue(nProcIndex, "deptCode", "",10);
			daoObj.setProcOutValue(nProcIndex, "err", 1,12);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,13);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrRequestNoList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getRequestNoList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	/**
	 * retrieves unit list based on unit id and hospital code
	 * 
	 * @param voObj
	 */
	public static void getOffLineTariffUnitList(CashCollectionOnlineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_GBLT_UNIT_MST(?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrOffLineTariffUnitTempId(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,5);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setOfflineTariffUnit(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineTariffUnitList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	
	
	public static void insertOnlineReceiptServices(CashCollectionOnlineTransVO voObj) 
	{
		String strBillNo = "";
		int nBillFlag = 0;
		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;
		int nInsertedIndex3 = 0;
		int nUpdatedIndex = 0; 

		HisDAO dao = null;
		PrimaryKeyDAO pKey = null;
		PaymentDAO paymentDao = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PatientAccountDAO pActDao=null;
		Double totalTrfAmt=0.00;
		String clientName="";

		try 
		{
			dao = new HisDAO("Billing", "CashCollectionTransDAO");
			paymentDao = new PaymentDAO();
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			

			pKey.setStrBlockkey("1");

			if (voObj.getStrChargeTypeId().equals("2"))//IPD 
			{
				pKey.setStrKeyname("BILL_IPD");
				//get client patient no only in case of IPD receipt
				
				/* Code To Be checked Amit Kumar Ateria*/
				//getClientPatientNumberCreditBillIpd(voObj);
			} 
			else 
			{
				pKey.setStrKeyname("BILL");
			}
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.setStrAppendHospcodeFlag("1");
			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();
			voObj.setStrBillNo(strBillNo);
			nBillFlag = 1;

			CashCollectionOnlineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			nInsertedIndex1 = dao.setProcedure("{call pkg_bill_dml.Dml_Online_Bill(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj.getStrRequestNo(),3);
			dao.setProcInValue(nInsertedIndex1, "reqDate", voObj.getStrRequestDate(),4);
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", voObj.getStrGlobalRequestNo(),5);
			dao.setProcInValue(nInsertedIndex1, "serviceId", voObj.getStrService(),6);			
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo,7);	
			if (voObj.getStrOnlinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrWalletNo(),8);//Wallet No Contains Account No Currently
			else
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrAccountNo(),8);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(),9);
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj.getStrAdmissionNo(),10);
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj.getStrEpisode(),11);
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj.getStrTreatmentCategory(),12);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj.getStrOnlineTotalRecAmount(),13);
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj.getStrOnlineMaxClientBenefitAmount(),14);
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj.getStrOnlinePatNetPayAmount(),15);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrTotalTariffActualAmount(),16);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrTotalTariffDiscountAmount(),17);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrTotalTariffServiceTaxAmount(),18);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj.getStrRaisingDepartment(),19);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrChargeTypeId(),20);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrWard(),21);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrBillingService(),22);
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj.getStrClientPatientNo(),23);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId,24);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj.getStrGroupId(),25);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(),26);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),27);
			/*dao.setProcInValue(nInsertedIndex1, "clientNo", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName() ,28);
			dao.setProcInValue(nInsertedIndex1, "creditBillFlag", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? "1" : "0",29);
			dao.setProcInValue(nInsertedIndex1, "creditBillStatus", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? "2" : "",30);
			dao.setProcInValue(nInsertedIndex1, "staffCardNo", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : ""  ,31);
			dao.setProcInValue(nInsertedIndex1, "staffName", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : ""  ,32);
			dao.setProcInValue(nInsertedIndex1, "staffRelation", (voObj.getStrRalationId() != null && voObj.getStrRalationId() != "") ? voObj.getStrRalationId() : ""  ,33);
			dao.setProcInValue(nInsertedIndex1, "staffCardValidity", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : ""  ,34);*/
			
			if(voObj.getStrCreditLetterNo()!=null)
			{
				//ADV LETTER^21-Jul-2016^1007^Cghs^0.00^879^19-AUG-2016^^Select Value^Staff Adv Check^19-AUG-2016^GNUM_DEPENDENT_RELATION_CODE
				String clientNo="";
				String creditBillFlag="0";
				String creditBillStatus="";
				String staffCardNo="";
				String staffName="";
				String staffRelation="";
				String staffCardValidity="";
				for(int x=0;x<voObj.getStrCreditLetterNo().length;x++)
				{
					if(voObj.getStrCreditLetterNo()[x]!=null && !voObj.getStrCreditLetterNo()[x].equals("0"))
					{
						clientNo=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[2];
						creditBillFlag="1";
						creditBillStatus="2";
						staffCardNo=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[5];
						staffName=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[7];
						staffRelation=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[11];
						staffCardValidity=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[6];
						clientName=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[3];
						break;						
					}
					
				}
				dao.setProcInValue(nInsertedIndex1, "clientNo", clientNo,28);//TO BE CHECK FOR FIRST ROW PAID
				dao.setProcInValue(nInsertedIndex1, "creditBillFlag", creditBillFlag,29);
				dao.setProcInValue(nInsertedIndex1, "creditBillStatus", creditBillStatus,30);
				dao.setProcInValue(nInsertedIndex1, "staffCardNo", staffCardNo,31);
				dao.setProcInValue(nInsertedIndex1, "staffName", staffName,32);
				dao.setProcInValue(nInsertedIndex1, "staffRelation", staffRelation ,33);//Relation ID
				dao.setProcInValue(nInsertedIndex1, "staffCardValidity", staffCardValidity,34);
				/*
				dao.setProcInValue(nInsertedIndex1, "clientNo", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2] ,28);//TO BE CHECK FOR FIRST ROW PAID
				dao.setProcInValue(nInsertedIndex1, "creditBillFlag", (voObj.getStrCreditLetterNo()[0] != null && voObj.getStrCreditLetterNo()[0] != "0") ? "1" : "0",29);
				dao.setProcInValue(nInsertedIndex1, "creditBillStatus", (voObj.getStrCreditLetterNo()[0] != null && voObj.getStrCreditLetterNo()[0] != "0") ? "2" : "",30);
				dao.setProcInValue(nInsertedIndex1, "staffCardNo", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[5],31);
				dao.setProcInValue(nInsertedIndex1, "staffName", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[7]  ,32);
				dao.setProcInValue(nInsertedIndex1, "staffRelation", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11] ,33);//Relation ID
				dao.setProcInValue(nInsertedIndex1, "staffCardValidity", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[6],34);*/	
			}
			else
			{
				dao.setProcInValue(nInsertedIndex1, "clientNo", "" ,28);//TO BE CHECK FOR FIRST ROW PAID
				dao.setProcInValue(nInsertedIndex1, "creditBillFlag", "0",29);
				dao.setProcInValue(nInsertedIndex1, "creditBillStatus", "",30);
				dao.setProcInValue(nInsertedIndex1, "staffCardNo", "",31);
				dao.setProcInValue(nInsertedIndex1, "staffName", "",32);
				dao.setProcInValue(nInsertedIndex1, "staffRelation", "",33);//Relation ID
				dao.setProcInValue(nInsertedIndex1, "staffCardValidity", "",34);
			}
			
			dao.setProcInValue(nInsertedIndex1, "ip", GetNetworkAddress.GetAddress("ip"), 35);
			dao.setProcInValue(nInsertedIndex1, "mac", GetNetworkAddress.GetAddress("mac"), 36);		
			dao.setProcOutValue(nInsertedIndex1, "err", 1,37);
			
			dao.execute(nInsertedIndex1, 1);

			
			/*PROCEDURE dml_hrgt_credit_pat_dtl(p_modeval character varying, p_hrgnum_puk character varying, p_hrgnum_company_code character varying, 
					p_hrgstr_company_name character varying, p_hrgnum_patient_cat_code character varying, p_hrgstr_card_no character varying, 
					p_hrgstr_card_holder_name character varying, p_hrgnum_seat_id character varying, p_hrgnum_is_dependent character varying,
					p_hrgnum_dependent_relation_code character varying, p_hrgstr_dependent_relation character varying,
					p_hrgstr_dependent_name character varying, p_hrgnum_card_district_code character varying, 
					p_hrgnum_card_validupto timestamp without time zone, p_hrgnum_counter_no character varying, 
					p_hrgnum_hospital_code character varying, p_hrgnum_isvalid character varying, p_hrgnum_credit_letter_type numeric, 
					p_hblstr_credit_letter_ref_no character varying, p_hbldt_credit_letter_date timestamp without time zone, 
					p_hbldt_credit_letter_validupto timestamp without time zone, p_hrgnum_credit_limit numeric, OUT err character varying);*/
			Map<String,String> mapCreditLetter = new LinkedHashMap<String,String>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c = Calendar.getInstance();
			String dt;
			if(voObj.getStrCreditLetterNo()!=null)
			{
				for(int k=0;k<voObj.getStrCreditLetterNo().length;k++)
				{
					if(voObj.getStrCreditLetterNo()[k]!=null && !voObj.getStrCreditLetterNo()[k].equals("0"))//SELECT VALUE
					{
						 String strCreditLetterSelected=voObj.getStrCreditLetterNo()[k];						 
						 String clKey=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[0]+"^"+voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1]+"^"+voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[2];
						 //UNIQUE KEY TO STOP MULTIPLE INSERTION OS SAME CREDIT LETTER
						 //CL101^21-JUN-2016^1003^Credit^5000.00^STAFF101^HRGNUM_CARD_VALIDUPTO^HRGSTR_CARD_HOLDER_NAME^Daughter^HRGSTR_DEPENDENT_NAME^HBLDT_CREDIT_LETTER_VALIDUPTO^GNUM_DEPENDENT_RELATION_CODE^NEWLETTERFLAG(0,1)^MERGELETTERFLAG(0,1)
						 //NEWLETTERFLAG(INDEX-12) SET AFTER WE ADD NEW LETTER FROM FRONT END BY CLICKING + BUTTON/ DEFAULT 0 FOR PREVIOUS LETTERS
						 //MERGELETTERFLAG(INDEX-13) SET WHEN WE ALLOW TO ADD PREVIOUS CREDIT LETTER LIMITS TO CURRENT/NEW LETTER. 
						 if(!voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[10].equals("") && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[10]!=null)
						 {
							 dt=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[10];
						 }
						 else
						 {
							 if(!voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1].equals("") && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1]!=null)
						     {
								 c.setTime(sdf.parse(voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1]));
						 		 c.add(Calendar.DATE, 29);  // number of days to add
								 dt = sdf.format(c.getTime());  // dt is now the valid upto date
						     }
							 else
								 dt="";
						 }
						 
						 System.out.println("the value of unique LETTER key is "+clKey);
						 String newLetterFlag=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[12];
						 String mergeLetterFlag=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[13];
						 if(mapCreditLetter.isEmpty())
						 {
							 if(newLetterFlag.equals("1"))
							 {
								if(mergeLetterFlag.equals("1"))
								{
									nUpdatedIndex = dao.setProcedure("{call pkg_bill_dml.dml_hrgt_credit_pat_dtl(?,?,?,?)}");
									//Input Value
									dao.setProcInValue(nUpdatedIndex,"modval","1",1);
									dao.setProcInValue(nUpdatedIndex, "puk", voObj.getStrCrNo(),2);
									dao.setProcInValue(nUpdatedIndex, "hrgnum_hospital_code", voObj.getStrHospitalCode(),3);
									dao.setProcOutValue(nUpdatedIndex,"err",1,4);
									//keep in batch
									dao.execute(nUpdatedIndex,1);
								}
								mapCreditLetter.put(clKey,strCreditLetterSelected);//ADD LETTER KEY TO MAP
								//String[] strCredcitLetterNo=voObj.getStrCreditLetterNo()[0].replace("^","#").split("#");
								nInsertedIndex3 = dao.setProcedure("{call pkg_reg_dml.dml_hrgt_credit_pat_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?::timestamp without time zone,?,?,?,?::numeric,?,?::timestamp without time zone,?::timestamp without time zone,?::numeric,?::numeric,?)}");
					
								dao.setProcInValue(nInsertedIndex3, "p_modeval", "1",1);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_puk", voObj.getStrCrNo(),2);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName(),3);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[2],3);
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[3],4);//Name
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrTreatmentCategory(),5);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : "",6);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[5],6);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : "",7);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#").length>=7 ? voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[7]:"" ,7);//To Be check
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_seat_id", voObj.getStrSeatId(),8);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != "0") ? "1" : "0",9);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", (voObj.getStrRalationId() != null && voObj.getStrRalationId() != "") ? voObj.getStrRalationId() : "",10);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11],10);
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_relation", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[8],11);//Name of Relation
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_name",(voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]!=null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]!="") ? voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]:"" ,12);//To Be Check
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_district_code", "0",13);//Arogyashri
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : "",14);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[6],14);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri To Be Check
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[14] ,18);//To Be check
								dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[0],19);
								dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],20);
								dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", dt,21);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_limit", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[4],22);
								dao.setProcInValue(nInsertedIndex3, "p_actual_amount", "0",23);
								//CL101^21-JUN-2016^1003^Credit^5000.00^STAFF101^21-JUL-2016^^Daughter^CREDIT LI MIT TWO^21-JUL-2016
								dao.setProcOutValue(nInsertedIndex3, "err", 1,24);
								
								dao.execute(nInsertedIndex3, 1);			
							 }
						 }
						 else//MAP CONTAIS SOME VALUE
						 {
							 if(!mapCreditLetter.containsKey(clKey))//MAP DOESNT CONTAIS THE LETTER KEY
							 {
								 if(newLetterFlag.equals("1"))
								 {
									if(mergeLetterFlag.equals("1"))
									{
										nUpdatedIndex = dao.setProcedure("{call pkg_bill_dml.dml_hrgt_credit_pat_dtl(?,?,?,?)}");
										//Input Value
										dao.setProcInValue(nUpdatedIndex,"modval","1",1);
										dao.setProcInValue(nUpdatedIndex, "puk", voObj.getStrCrNo(),2);
										dao.setProcInValue(nUpdatedIndex, "hrgnum_hospital_code", voObj.getStrHospitalCode(),3);
										dao.setProcOutValue(nUpdatedIndex,"err",1,4);
										//keep in batch
										dao.execute(nUpdatedIndex,1);
									}
									mapCreditLetter.put(clKey,strCreditLetterSelected);
									nInsertedIndex3 = dao.setProcedure("{call pkg_reg_dml.dml_hrgt_credit_pat_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?::timestamp without time zone,?,?,?,?::numeric,?,?::timestamp without time zone,?::timestamp without time zone,?::numeric,?::numeric,?)}");
									
									dao.setProcInValue(nInsertedIndex3, "p_modeval", "1",1);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_puk", voObj.getStrCrNo(),2);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName(),3);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[2],3);
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[3],4);//Name
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrTreatmentCategory(),5);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : "",6);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[5],6);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : "",7);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#").length>=7 ? voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[7]:"" ,7);//To Be check
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_seat_id", voObj.getStrSeatId(),8);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != "0") ? "1" : "0",9);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", (voObj.getStrRalationId() != null && voObj.getStrRalationId() != "") ? voObj.getStrRalationId() : "",10);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11],10);
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_relation", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[8],11);//Name of Relation
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_name",(voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]!=null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]!="") ? voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9]:"" ,12);//To Be Check
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_district_code", "0",13);//Arogyashri
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : "",14);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[6],14);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri To Be Check
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[14] ,18);//To Be check
									dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[0],19);
									dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],20);
									dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", dt,21);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_limit", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[4],22);
									dao.setProcInValue(nInsertedIndex3, "p_actual_amount", "0",23);
									//CL101^21-JUN-2016^1003^Credit^5000.00^STAFF101^21-JUL-2016^^Daughter^CREDIT LI MIT TWO^21-JUL-2016
									dao.setProcOutValue(nInsertedIndex3, "err", 1,24);
									
									dao.execute(nInsertedIndex3, 1);	
								 }
							 }							
						 }						
					}
				}//END FOR
			}
			

			if (voObj.getStrTariffDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffDetailsId().length; i < len; i++) 
				{
					nInsertedIndex2 = dao.setProcedure("{call pkg_bill_dml.Dml_Online_Bill_Service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					if(!voObj.getStrTariffDetailsId()[i].equals("0"))
					{
						String[] strTariffDtlsVal = voObj.getStrTariffDetailsId()[i].replace('^', '#').split("#");
	
						String strTempTariffId = strTariffDtlsVal[0];
						String strTempTariffRate = strTariffDtlsVal[3];
						String strTempRateUnitId = strTariffDtlsVal[4];
						String strTempGroupId = strTariffDtlsVal[5];
						String strTempTariffActualRate = strTariffDtlsVal[6];
						String strTempServiceTax = strTariffDtlsVal[7];
						String strTempDiscountUnit = strTariffDtlsVal[8];
						String strTempDiscountType = strTariffDtlsVal[9];
						String strTempGblTrariffId = strTariffDtlsVal[10];
						String strTempApprovalId = strTariffDtlsVal[11];
						String strTempIsPackage = strTariffDtlsVal[14];//1300005^1*1^1701^45000.00^1701^130^45000.00^0^0.00^1^1067^0^No^1^0^45000.00^0^0^0^^0^/^0^/^6^0
						String strTempApprovalDate = strTariffDtlsVal[19];
						String strTempApprovalBy = strTariffDtlsVal[20];
						String strTempReason = strTariffDtlsVal[23];
						String strTempService = strTariffDtlsVal[24];
						
						totalTrfAmt=totalTrfAmt+Double.parseDouble(strTempTariffRate);
	
						dao.setProcInValue(nInsertedIndex2, "modval", "1",1);
						dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(),2);
						dao.setProcInValue(nInsertedIndex2, "reqNo", voObj.getStrRequestNo(),3);
						dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj.getStrGlobalRequestNo(),4);
						dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo,5);
						//System.out.println("voObj.getStrWalletNo()"+voObj.getStrWalletNo());
						//System.out.println("patAccNo"+voObj.getStrAccountNo());
						//System.out.println("voObj.getStrOnlinePaymentMode()[0]"+voObj.getStrOnlinePaymentMode()[0]);
						if (voObj.getStrOnlinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
							dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrWalletNo(),6);//Wallet No Contains Account No Currently
						else
							dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrAccountNo(),6);
						dao.setProcInValue(nInsertedIndex2, "puk", voObj.getStrCrNo(),7);
						dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrTreatmentCategory(),8);
						dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrRaisingDepartment(),9);
						dao.setProcInValue(nInsertedIndex2, "grpId",strTempGroupId,10);
						dao.setProcInValue(nInsertedIndex2, "trfId",strTempTariffId,11);
						dao.setProcInValue(nInsertedIndex2, "billQty", voObj.getStrTariffBilledQty()[i],12);
						dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj.getStrBillTariffUnit()[i].replace("^", "#").split("#")[0],13);
						dao.setProcInValue(nInsertedIndex2, "rate",strTempTariffRate,14);
						dao.setProcInValue(nInsertedIndex2, "actRate",strTempTariffActualRate,15);
						dao.setProcInValue(nInsertedIndex2, "rateUnitId",strTempRateUnitId,16);
						dao.setProcInValue(nInsertedIndex2, "serTax",strTempServiceTax,17);
						dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj.getStrTariffServiceTaxAmt()[i],18);
						dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj.getStrTariffNetAmt()[i],19);
						dao.setProcInValue(nInsertedIndex2, "appId",strTempApprovalId,20);
						dao.setProcInValue(nInsertedIndex2, "disUnit",strTempDiscountUnit,21);
						dao.setProcInValue(nInsertedIndex2, "disAmt", voObj.getStrTariffDiscountAmt()[i],22);
						dao.setProcInValue(nInsertedIndex2, "disType",strTempDiscountType,23);
						dao.setProcInValue(nInsertedIndex2, "disBy",strTempApprovalBy,24);
						dao.setProcInValue(nInsertedIndex2, "disReason",strTempReason,25);
						dao.setProcInValue(nInsertedIndex2, "disDate",strTempApprovalDate,26);
						dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrChargeTypeId(),27);
						dao.setProcInValue(nInsertedIndex2, "wardId", voObj.getStrWard(),28);
						dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrBillingService(),29);
						dao.setProcInValue(nInsertedIndex2, "serviceId",strTempService,30);
						dao.setProcInValue(nInsertedIndex2, "gblTrfId",strTempGblTrariffId,31);
						dao.setProcInValue(nInsertedIndex2, "isRefund", "",32);
						dao.setProcInValue(nInsertedIndex2, "isPackage",strTempIsPackage,33);
						dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(),34);
						dao.setProcOutValue(nInsertedIndex2, "err", 1,35);
						
						//ADV LETTER^21-Jul-2016^1007^Cghs^0.00^879^19-AUG-2016^^Select Value^Staff Adv Check^19-AUG-2016
						//if()
						//if(voObj.getStrCreditLetterNo()!=null && !voObj.getStrCreditLetterNo()[i].equals("0"))
						if((voObj.getStrCreditPaymentType()[i].equals("11")  || voObj.getStrCreditPaymentType()[i].equals("13")) && voObj.getStrCreditLetterNo()!=null)
						{
							dao.setProcInValue(nInsertedIndex2, "creditBillFlag","1",36);
							dao.setProcInValue(nInsertedIndex2, "clNo",voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[0],37);
							//dao.setProcInValue(nInsertedIndex2, "clNo",voObj.getStrCreditLetterNo()[i],37);
							//dao.setProcInValue(nInsertedIndex2, "clDate",voObj.getStrCreditLetterDate()[i],38);
							dao.setProcInValue(nInsertedIndex2, "clDate",voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[1],38);
							dao.setProcInValue(nInsertedIndex2, "clPath",voObj.getStrCreditFilePath()[i],39);
							//System.out.println("voObj.getStrClientNo()"+voObj.getStrClientNo()+"voObj.getStrPayClientName()"+voObj.getStrPayClientName());
							//dao.setProcInValue(nInsertedIndex2, "creditClientNo",(voObj.getStrClientNo() != null && !voObj.getStrClientNo().equals("") && !voObj.getStrClientNo() .equals("0")) ? voObj.getStrClientNo() : voObj.getStrPayClientName(),40);
							dao.setProcInValue(nInsertedIndex2, "creditClientNo",voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[2],40);
							//dao.setProcInValue(nInsertedIndex2, "creditBillstatus",voObj.getStrCreditBillStatus()[i],41);
							dao.setProcInValue(nInsertedIndex2, "creditBillstatus","2",41);//No Approval
							if(voObj.getStrPaidByPat()!=null && voObj.getStrPaidByPat()[i]!=null)
								dao.setProcInValue(nInsertedIndex2, "creditAmtPat",voObj.getStrPaidByPat()[i],42);
							else
								dao.setProcInValue(nInsertedIndex2, "creditAmtPat","0",42);
							
							if(voObj.getStrPaidByClient()!=null && voObj.getStrPaidByClient()[i]!=null)
								dao.setProcInValue(nInsertedIndex2, "creditAmtClient",voObj.getStrPaidByClient()[i],43);
							else
								dao.setProcInValue(nInsertedIndex2, "creditAmtClient","0",43);
						}
						else
						{
							dao.setProcInValue(nInsertedIndex2, "creditBillFlag","0",36);
							dao.setProcInValue(nInsertedIndex2, "clNo","",37);
							//dao.setProcInValue(nInsertedIndex2, "clNo",voObj.getStrCreditLetterNo()[i],37);
							//dao.setProcInValue(nInsertedIndex2, "clDate",voObj.getStrCreditLetterDate()[i],38);
							dao.setProcInValue(nInsertedIndex2, "clDate","",38);
							dao.setProcInValue(nInsertedIndex2, "clPath","",39);
							//System.out.println("voObj.getStrClientNo()"+voObj.getStrClientNo()+"voObj.getStrPayClientName()"+voObj.getStrPayClientName());
							dao.setProcInValue(nInsertedIndex2, "creditClientNo","",40);
							dao.setProcInValue(nInsertedIndex2, "creditBillstatus","",41);
							if(voObj.getStrPaidByPat()!=null && voObj.getStrPaidByPat()[i]!=null)
								dao.setProcInValue(nInsertedIndex2, "creditAmtPat",voObj.getStrPaidByPat()[i],42);
							else
								dao.setProcInValue(nInsertedIndex2, "creditAmtPat","0",42);
							
							if(voObj.getStrPaidByClient()!=null && voObj.getStrPaidByClient()[i]!=null)
								dao.setProcInValue(nInsertedIndex2, "creditAmtClient",voObj.getStrPaidByClient()[i],43);
							else
								dao.setProcInValue(nInsertedIndex2, "creditAmtClient","0",43);
						}					
						dao.setProcInValue(nInsertedIndex2, "counterid",strCounterId,44);
						if(voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13"))
						    dao.setProcInValue(nInsertedIndex2, "urgentFlag","2",45);
						else
							dao.setProcInValue(nInsertedIndex2, "urgentFlag","1",45);	
						dao.setProcInValue(nInsertedIndex2, "ip", GetNetworkAddress.GetAddress("ip"), 46);
						dao.setProcInValue(nInsertedIndex2, "mac", GetNetworkAddress.GetAddress("mac"), 47);
						dao.execute(nInsertedIndex2, 1);
					}
				}
				if (voObj.getStrOnlinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
				{
					pActDao = new PatientAccountDAO();
					pActDao.setStrPatAccNo(voObj.getStrWalletNo());				
					pActDao.setStrNetActualAmt(voObj.getStrOnlineTotalRecAmount());
					pActDao.setStrSerTaxNetAmt(voObj.getStrTotalTariffServiceTaxAmount());
					pActDao.setStrTariffNetAmt(voObj.getStrOnlineTotalRecAmount());
					pActDao.setStrHospitalCode(voObj.getStrHospitalCode());
					pActDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
					pActDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
					//pActDao.setIsBillFinal("0");
					pActDao.update3(dao);
				}				
				
				int nSlNo = 0;
				int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;
			
				for (int j = 0; j < nPaymentLenght; j++) 
				{
					//Check Whether Total Tariff Cost is equal to Amount Paid By CLient.Do Not Insert Data If Total Tariff Cost is Paid By Client.
					//System.out.println(totalTrfAmt+":"+Float.parseFloat(voObj.getStrOnlineMaxClientBenefitAmount()));
					//if(Float.parseFloat(voObj.getStrTotalTariffActualAmount())!=(Float.parseFloat(voObj.getStrOnlineMaxClientBenefitAmount())))
					if(totalTrfAmt!=(Double.parseDouble(voObj.getStrOnlineMaxClientBenefitAmount())))
					{
						nSlNo = nSlNo + 1;
						paymentDao.setStrBillNo(strBillNo);
						paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j].split("#")[0]);
						paymentDao.setStrRecieptNo("1");
						paymentDao.setStrSerialNo(String.valueOf(nSlNo));
						paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
						paymentDao.setStrBServiceId(voObj.getStrBillingService());
		
						//String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(",", "#").split("#");
						String payDtl[] = { "", "" };
						
						if (voObj.getStrOnlinePaymentDtls() != null)
						{
							
							payDtl = voObj.getStrOnlinePaymentDtls()[j].replace(",", "#").split("#");
							paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[j]);
						} 
						else
						{
							paymentDao.setStrPaymentDetails("");
						}
		
						if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("2")
								|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("3")) {
							paymentDao.setStrPaymentModeNo(payDtl[1]);
		
						} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("4")
								|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("5")) {
							paymentDao.setStrPaymentModeNo(payDtl[1]);
		
						} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("10")) {
		
							paymentDao.setStrPaymentModeNo(payDtl[0]);
						}
		
						else {
							paymentDao.setStrPaymentModeNo("");
							paymentDao.setStrPaymentStatus("1");
						}
		
						paymentDao.setStrRecieptType("1");
						paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[j]);
						//paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[j]);
						paymentDao.setStrPuk(voObj.getStrCrNo());
						paymentDao.setStrProcessedBy("0");
						paymentDao.setStrCounterId(strCounterId);
						paymentDao.setStrSeatId(voObj.getStrSeatId());
						paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
						paymentDao.setStrIsValid("1");
						paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
						paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
						paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
		
						paymentDao.insert(dao);
					}
					//If any of the amount is paid by client then insert it
					if (!voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) 
					{			 
						 nSlNo = nSlNo + 1;
						 
						 paymentDao.setStrBillNo(strBillNo);
						 
						 paymentDao.setStrPaymentMode("10"); 
						 paymentDao.setStrRecieptNo("1");
						 paymentDao.setStrSerialNo(String.valueOf(nSlNo));
						 paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
						 paymentDao.setStrBServiceId(voObj.getStrBillingService());
						 //paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
						 paymentDao.setStrPaymentDetails(clientName);//Client Name					 
						 paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
						 paymentDao.setStrPaymentStatus("0");
						 paymentDao.setStrRecieptType("1");
						 paymentDao.setStrRecieptAmount(voObj.getStrOnlineMaxClientBenefitAmount());
						 paymentDao.setStrPuk(voObj.getStrCrNo());
						 paymentDao.setStrProcessedBy("0");
						 paymentDao.setStrCounterId(strCounterId);
						 paymentDao.setStrSeatId(voObj.getStrSeatId());
						 paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
						 paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
						 paymentDao.setStrIsValid("1");
						 paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
						 paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
						 
						 paymentDao.insert(dao); 
					}
				}

			synchronized (dao) 
			{
				dao.fire();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			String err = "err:" + e.getMessage();
			voObj.setStrMsgString("CashCollectionOnlineTransDAO.insertOnlineReceiptServices()--> "+ err);
			voObj.setStrMsgType("1");

			if (nBillFlag == 1) 
			{
				try 
				{
					if (voObj.getStrChargeTypeId().equals("2")) 
					{
						pKeyLogDao.setStrKeyname("BILL_IPD");
					} 
					else 
					{
						pKeyLogDao.setStrKeyname("BILL");
					}

					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} 
				catch (Exception e1) 
				{
					voObj.setStrMsgString("CashCollectionTransDAO.insertOnlineReceiptServices()--> "+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");
				}
			}

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			pKey = null;
			pKeyLogDao = null;
			paymentDao = null;
		}

	}

	public static void insertOnlineRefundServices(CashCollectionOnlineTransVO voObj) 
	{
		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;
		HisDAO dao = null;
		PaymentDAO paymentDao = null;
		PatientAccountDAO pActDao=null;

		try 
		{
			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			paymentDao = new PaymentDAO();

			CashCollectionOnlineTransDAO.getCounterId(voObj);
			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];
			CashCollectionOnlineTransDAO.getRefundReceiptNo(voObj);
			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();
			
			//to get client patient no..
			//needed to update rfund details in hblt_client_patient_dtl
			if (voObj.getStrChargeTypeId().equals("2")) 
			{
				//get client patient no only in case of IPD 
				getClientPatientNumberCreditBillIpd(voObj);
			}
			//System.out.println("client patient no is::"+voObj.getStrClientPatientNo());
			
			nInsertedIndex1 = dao.setProcedure("{call pkg_bill_dml.dml_online_refund(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj.getStrRequestNo(),3);
			dao.setProcInValue(nInsertedIndex1, "refRecNo", strRefundReceiptNo,4);
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj.getStrOnlineTotalRecAmount(),5);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrTotalTariffActualAmount(),6);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrTotalTariffDiscountAmount(),7);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrTotalTariffServiceTaxAmount(),8);
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj.getStrTotalTariffPenaltyAmount(),9);
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj.getStrClientPatientNo(),10);
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj.getStrClientBalance(),11);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),12);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId,13);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj.getStrGroupId(),14);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(),15);
			dao.setProcInValue(nInsertedIndex1, "ip", GetNetworkAddress.GetAddress("ip"), 16);
			dao.setProcInValue(nInsertedIndex1, "mac", GetNetworkAddress.GetAddress("mac"), 17);	
			
			dao.setProcOutValue(nInsertedIndex1, "err", 1,18);

			dao.execute(nInsertedIndex1, 1);

			

			if (voObj.getStrTariffRefundDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffRefundDetailsId().length; i < len; i++) 
				{
					nInsertedIndex2 = dao.setProcedure("{call pkg_bill_dml.dml_online_refund_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					String[] strTariffDtlsVal = voObj.getStrTariffRefundDetailsId()[i].replace('^', '#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					// String strTempReqQty =
					// strTariffDtlsVal[1].replace('*','#').split("#")[0];
					// String strTempQtyBaseVal =
					// strTariffDtlsVal[1].replace('*','#').split("#")[1];
					// String strTempQtyUnitId = strTariffDtlsVal[2];
					String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRateUnitId = strTariffDtlsVal[4];
					String strTempGroupId = strTariffDtlsVal[5];
					String strTempTariffActualRate = strTariffDtlsVal[6];
					String strTempServiceTax = strTariffDtlsVal[7];
					String strTempDiscountUnit = strTariffDtlsVal[8];
					String strTempDiscountType = strTariffDtlsVal[9];
					String strTempGblTrariffId = strTariffDtlsVal[10];
					String strTempApprovalId = strTariffDtlsVal[11];
					// String strTempUnitName = strTariffDtlsVal[12];
					// String strTempRateBaseVal = strTariffDtlsVal[13];
					String strTempIsPackage = strTariffDtlsVal[14];
					// String strTempNetCost = strTariffDtlsVal[15];
					String strTempPenelty = strTariffDtlsVal[16];
					String strTempReceiptNo = strTariffDtlsVal[18];
					// String strTempApprovalDate = strTariffDtlsVal[19];
					// String strTempApprovalBy = strTariffDtlsVal[20];
					// String strTempReason = strTariffDtlsVal[23];

					
					dao.setProcInValue(nInsertedIndex2, "modval", "1",1);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(),2);
					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj.getStrRequestNo(),3);
					dao.setProcInValue(nInsertedIndex2, "billNo", voObj.getStrBillNo(),4);
					dao.setProcInValue(nInsertedIndex2, "trfRecNo",strTempReceiptNo,5);
					dao.setProcInValue(nInsertedIndex2, "refRecNo",strRefundReceiptNo,6);
					if (voObj.getStrOnlinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
						dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrWalletNo(),7);//Wallet No Contains Account No Currently						
					else
						dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrAccountNo(),7);
					
					dao.setProcInValue(nInsertedIndex2, "puk", voObj.getStrCrNo(),8);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrTreatmentCategory(),9);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrRaisingDepartment(),10);
					dao.setProcInValue(nInsertedIndex2, "grpId",strTempGroupId,11);
					dao.setProcInValue(nInsertedIndex2, "trfId",strTempTariffId,12);
					dao.setProcInValue(nInsertedIndex2, "refQty", voObj.getStrTariffRefundQty()[i],13);
					dao.setProcInValue(nInsertedIndex2, "refQtyUnitId", voObj.getStrTariffRefundUnit()[i].replace("^", "#").split("#")[0],14);					
					dao.setProcInValue(nInsertedIndex2, "rate",strTempTariffRate,15);
					dao.setProcInValue(nInsertedIndex2, "actRate",strTempTariffActualRate,16);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",strTempRateUnitId,17);
					dao.setProcInValue(nInsertedIndex2, "serTax",strTempServiceTax,18);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj.getStrTariffServiceTaxAmt()[i],19);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj.getStrTariffRefundCost()[i],20);
					dao.setProcInValue(nInsertedIndex2, "penelty",strTempPenelty,21);
					dao.setProcInValue(nInsertedIndex2, "penAmt", voObj.getStrTariffPenaltyAmt()[i],22);
					dao.setProcInValue(nInsertedIndex2, "disAppId",strTempApprovalId,23);
					dao.setProcInValue(nInsertedIndex2, "disUnit",strTempDiscountUnit,24);
					dao.setProcInValue(nInsertedIndex2, "disType",strTempDiscountType,25);
					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj.getStrTariffDiscountAmt()[i],26);
					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrChargeTypeId(),27);
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj.getStrWard(),28);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrBillingService(),29);
					dao.setProcInValue(nInsertedIndex2, "serviceId", voObj.getStrService(),30);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",strTempGblTrariffId,31);
					dao.setProcInValue(nInsertedIndex2, "isPackage",strTempIsPackage,32);
					dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj.getStrGlobalRequestNo(),33);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(),34);
					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1,35);
					dao.setProcInValue(nInsertedIndex2, "clNo", voObj.getStrCreditLetterNo()[i],36);
					dao.setProcInValue(nInsertedIndex2, "clientPatNo", voObj.getStrClientPatientNo(),37);
					dao.setProcInValue(nInsertedIndex2, "ip", GetNetworkAddress.GetAddress("ip"), 38);
					dao.setProcInValue(nInsertedIndex2, "mac", GetNetworkAddress.GetAddress("mac"), 39);	

					dao.execute(nInsertedIndex2, 1);
				}
			
			if (voObj.getStrOnlinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
			{
				pActDao = new PatientAccountDAO();
				pActDao.setStrPatAccNo(voObj.getStrWalletNo());
				pActDao.setStrNetActualAmt(voObj.getStrOnlineTotalRecAmount());
				pActDao.setStrSerTaxNetAmt(voObj.getStrTotalTariffServiceTaxAmount());
				pActDao.setStrTariffNetAmt(voObj.getStrOnlineTotalRecAmount());
				pActDao.setStrHospitalCode(voObj.getStrHospitalCode());
				pActDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				pActDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				//pActDao.setIsBillFinal("0");
				pActDao.update3(dao);
			}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());
				paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("10")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("2");
				paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[j]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[j]);

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrClientPatientNo().length() > 1 &&
			 * !voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(voObj.getStrBillNo());
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo(strRefundReceiptNo);
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			 * paymentDao.setStrBServiceId(voObj.getStrBillingService());
			 * paymentDao.setStrPaymentDetails(voObj.getStrClientName());
			 * paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("2");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOnlineMaxClientBenefitAmount());
			 * 
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */
			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			e.printStackTrace();
			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlineRefundServices()--> "
							+ err);
			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	public static void insertOnlineRefundAdvance(CashCollectionOnlineTransVO voObj) {

		int nInsertedIndex1 = 0;

		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();

			CashCollectionOnlineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionOnlineTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_online_pataccount_close(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj.getStrRequestNo(),3);
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo,4);
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId(),5);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(),6);
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj.getStrOnlineTotalRecAmount(),7);
			dao.setProcInValue(nInsertedIndex1, "penelty", voObj.getStrRefundAdvancePaneltyAmt(),8);
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj.getStrTotalTariffPenaltyAmount(),9);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId,10);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),11);
			dao.setProcInValue(nInsertedIndex1, "ip", GetNetworkAddress.GetAddress("ip"), 12);
			dao.setProcInValue(nInsertedIndex1, "mac", GetNetworkAddress.GetAddress("mac"), 13);	
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1,14);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			// Payment Details.
			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());
				paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("2")
						|| voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("4")
						|| voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("10")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("2");
				paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[i]);
				paymentDao
						.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[i]);
				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrClientPatientNo().length() > 1 &&
			 * !voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(voObj.getStrBillNo());
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo(strRefundReceiptNo);
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			 * paymentDao.setStrBServiceId(voObj.getStrBillingService());
			 * paymentDao.setStrPaymentDetails(voObj.getStrClientName());
			 * paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("2");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOnlineMaxClientBenefitAmount());
			 * 
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */
			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlineRefundAdvance()--> "
							+ err);
			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	public static void insertOnlineFinalAdjustment(CashCollectionOnlineTransVO voObj) {
		String strBillNo = "";

		int nBillFlag = 0;

		int nInsertedIndex1 = 0;

		HisDAO dao = null;
		PrimaryKeyDAO pKey = null;
		PaymentDAO paymentDao = null;
		PrimaryKeyLogDAO pKeyLogDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();

			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;
			CashCollectionOnlineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Finalsettlement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj.getStrRequestNo(),3);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo,4);
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId(),5);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(),6);
			dao.setProcInValue(nInsertedIndex1, "expenseAmt", voObj.getStrExpenseAmount(),7);
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj.getStrOnlineTotalRecAmount(),8);
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj.getStrNetClientAmount(),9);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrNetDiscountAmount(),10);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrNetServiceTaxAmount(),11);
			if (voObj.getStrClientPatientNo() != null || !voObj.getStrClientPatientNo().equals("")) 
			{
			   if (!voObj.getStrClientPatientNo().equals("null")) 
			        dao.setProcInValue(nInsertedIndex1, "clientNo", voObj.getStrClientPatientNo(),12);
			   else
					dao.setProcInValue(nInsertedIndex1, "clientNo", "0",12);
			}
			else
				dao.setProcInValue(nInsertedIndex1, "clientNo", "0",12);
			dao.setProcInValue(nInsertedIndex1, "clientSancAmt", voObj.getStrSancAmount(),13);
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj.getStrClientBalance(),14);
			dao.setProcInValue(nInsertedIndex1, "disAppId", voObj.getStrApprovalId(),15);
			dao.setProcInValue(nInsertedIndex1, "disType", voObj.getStrDiscountType(),16);
			dao.setProcInValue(nInsertedIndex1, "disUnit", voObj.getStrDiscountUnit(),17);
			dao.setProcInValue(nInsertedIndex1, "serTax", voObj.getStrServiceTax(),18);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId,19);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),20);
			//dao.setProcInValue(nInsertedIndex1, "ip", GetNetworkAddress.GetAddress("ip"), 21);
			//dao.setProcInValue(nInsertedIndex1, "mac", GetNetworkAddress.GetAddress("mac"), 22);		
			dao.setProcInValue(nInsertedIndex1, "ip", "", 21);
			dao.setProcInValue(nInsertedIndex1, "mac", "", 22);		
			
			
			/*
			 * System.out.println("strExpenseAmount"+voObj.getStrExpenseAmount());
			 * System.out.println("strNetClientAmount"+voObj.getStrNetClientAmount());
			 * System.out.println("strSancAmount"+voObj.getStrSancAmount());
			 * System.out.println("strClientBalance"+voObj.getStrClientBalance());
			 * System.out.println("strClientAmount"+voObj.getStrClientAmount());
			 * System.out.println("strNetPaybleAmount"+voObj.getStrNetPaybleAmount());
			 * System.out.println("patPaidAmt"+ voObj.getStrOnlineTotalRecAmount());
			 */
	 	
			
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1,23);
			dao.setProcInValue(nInsertedIndex1, "walacc", voObj.getWalacc(), 24);
			/*if(voObj.getStrOnlinePaymentMode()[0].equals("4") || voObj.getStrOnlinePaymentMode()[0].equals("5") ||voObj.getStrOnlinePaymentMode()[0].equals("8") || voObj.getStrOnlinePaymentMode()[0].equals("9"))
				dao.setProcInValue(nInsertedIndex1, "suramt", String.valueOf(Math.round(Double.parseDouble(voObj.getStrOnlineAmount()[0]))-Double.parseDouble(voObj.getStrOnlineTotalRecAmount())), 25);
			else
				dao.setProcInValue(nInsertedIndex1, "suramt", "0", 25);*/
			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {
				
				if(Double.parseDouble(voObj.getStrExpenseAmount())!=(Double.parseDouble(voObj.getStrNetClientAmount())) || Double.parseDouble(voObj.getStrOnlineTotalRecAmount())<0)
				{
					nSlNo = nSlNo + 1;
					paymentDao.setStrBillNo(strBillNo);
					paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j].split("#")[0]);
					paymentDao.setStrRecieptNo("1");
					paymentDao.setStrSerialNo(String.valueOf(nSlNo));
					paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
					paymentDao.setStrBServiceId(voObj.getStrBillingService());

					String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(",", "#").split("#");

					if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("2") || voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("3")) 
					{
						paymentDao.setStrPaymentModeNo(payDtl[1]);
					} 
					else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("4") || voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("5")) 
					{
						paymentDao.setStrPaymentModeNo(payDtl[1]);
					} 
					else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("10")) 
					{
						paymentDao.setStrPaymentModeNo(payDtl[0]);
					} 
					else 
					{
						paymentDao.setStrPaymentModeNo("");
						paymentDao.setStrPaymentStatus("1");
					}

					paymentDao.setStrRecieptType("1");
					paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[j]);
					paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[j]);
					paymentDao.setStrPuk(voObj.getStrCrNo());
					paymentDao.setStrProcessedBy("0");
					paymentDao.setStrCounterId(strCounterId);
					paymentDao.setStrSeatId(voObj.getStrSeatId());
					paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
					paymentDao.setStrIsValid("1");
					paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
					//paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
					//paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
					paymentDao.setStripadd("");
					paymentDao.setStrmacadd("");
					paymentDao.insert(dao);
				}
				
				if (!(voObj.getStrNetClientAmount().equals("0") || voObj.getStrNetClientAmount().equals("0.0"))) 
				{			 
					nSlNo = nSlNo + 1;
					paymentDao.setStrBillNo(strBillNo);
					paymentDao.setStrPaymentMode("10");
					paymentDao.setStrRecieptNo("1");
					paymentDao.setStrSerialNo(String.valueOf(nSlNo));
					paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
					paymentDao.setStrBServiceId(voObj.getStrBillingService());

					paymentDao.setStrRecieptType("1");
					paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[j]);
					paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
					paymentDao.setStrPaymentStatus("0");
					paymentDao.setStrRecieptType("1");
					paymentDao.setStrPuk(voObj.getStrCrNo());
					paymentDao.setStrProcessedBy("0");
					paymentDao.setStrCounterId(strCounterId);
					paymentDao.setStrSeatId(voObj.getStrSeatId());
					paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
					paymentDao.setStrIsValid("1");
					paymentDao.setStrNetAmount(voObj.getStrNetClientAmount());
					paymentDao.setStrRecieptAmount(voObj.getStrNetClientAmount());
					//paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
					//paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
					paymentDao.setStripadd("");
					paymentDao.setStrmacadd("");
					paymentDao.insert(dao);
					
				}
			}

			/*
			 * if (voObj.getStrClientPatientNo().length() > 1 &&
			 * !voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			 * paymentDao.setStrBServiceId(voObj.getStrBillingService());
			 * paymentDao.setStrPaymentDetails(voObj.getStrClientName());
			 * paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("2");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOnlineMaxClientBenefitAmount());
			 * 
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			e.printStackTrace();

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlineFinalAdjustment()--> "
							+ err);
			voObj.setStrMsgType("1");

			if (nBillFlag == 1) {

				try {

					if (voObj.getStrChargeTypeId().equals("2")) {
						pKeyLogDao.setStrKeyname("BILL_IPD");
					} else {
						pKeyLogDao.setStrKeyname("BILL");
					}

					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlineFinalAdjustment()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	public static void insertOnlineReconcillation(CashCollectionOnlineTransVO voObj) {

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();

			CashCollectionOnlineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionOnlineTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Reconciliation(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),2);
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj.getStrRequestNo(),3);
			dao.setProcInValue(nInsertedIndex1, "reqDate", voObj.getStrRequestDate(),4);
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", voObj.getStrGlobalRequestNo(),5);
			dao.setProcInValue(nInsertedIndex1, "serviceId", voObj.getStrService(),6);
			dao.setProcInValue(nInsertedIndex1, "billNo", voObj.getStrBillNo(),7);
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo,8);
			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrAccountNo(),9);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(),10);
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj.getStrAdmissionNo(),11);
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj.getStrEpisode(),12);
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj.getStrTreatmentCategory(),13);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj.getStrOnlineTotalRecAmount(),14);
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj.getStrOnlineMaxClientBenefitAmount(),15);
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj.getStrOnlinePatNetPayAmount(),16);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrTotalTariffActualAmount(),17);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrTotalTariffDiscountAmount(),18);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrTotalTariffServiceTaxAmount(),19);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj.getStrRaisingDepartment(),20);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrChargeTypeId(),21);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrWard(),22);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrBillingService(),23);
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj.getStrClientPatientNo(),24);
			dao.setProcInValue(nInsertedIndex1, "clientSancAmt", voObj.getStrSancAmount(),25);
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj.getStrClientBalance(),26);
			dao.setProcInValue(nInsertedIndex1, "appNo", voObj.getStrApprovalId(),27);
			dao.setProcInValue(nInsertedIndex1, "appBy", voObj.getStrApprovedBy(),28);
			dao.setProcInValue(nInsertedIndex1, "appDate", voObj.getStrApprovedDate(),29);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId,30);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),31);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj.getStrGroupId(),32);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(),33);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1,34);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Reconcile_Service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrTariffDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffDetailsId().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj.getStrTariffDetailsId()[i]
							.replace('^', '#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					String strTempReqQty = strTariffDtlsVal[1]
							.replace('*', '#').split("#")[0];
					// String strTempQtyBaseVal =
					// strTariffDtlsVal[1].replace('*','#').split("#")[1];
					String strTempQtyUnitId = strTariffDtlsVal[2];
					String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRateUnitId = strTariffDtlsVal[4];
					String strTempGroupId = strTariffDtlsVal[5];
					String strTempTariffActualRate = strTariffDtlsVal[6];
					String strTempServiceTax = strTariffDtlsVal[7];
					String strTempDiscountUnit = strTariffDtlsVal[8];
					String strTempDiscountType = strTariffDtlsVal[9];
					String strTempGblTrariffId = strTariffDtlsVal[10];
					String strTempApprovalId = strTariffDtlsVal[11];
					// String strTempUnitName = strTariffDtlsVal[12];
					// String strTempRateBaseVal = strTariffDtlsVal[13];
					String strTempIsPackage = strTariffDtlsVal[14];
					// String strTempNetCost = strTariffDtlsVal[15];
					// String strTempPenelty = strTariffDtlsVal[16];
					// String strTempReceiptNo = strTariffDtlsVal[17];
					String strRefReceiptNo = strTariffDtlsVal[18];
					String strTempApprovalDate = strTariffDtlsVal[19];
					String strTempApprovalBy = strTariffDtlsVal[20];
					String strTempReason = strTariffDtlsVal[23];
					String strTempQtyType = strTariffDtlsVal[24];

					if (strTempQtyType.trim().equals("0")) {

						strTempReqQty = "-" + strTempReqQty;

					}

					if (strTempApprovalDate.length() < 11) {

						strTempApprovalDate = "";
					}

					dao.setProcInValue(nInsertedIndex2, "modval", "1",1);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(),2);
					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj.getStrRequestNo(),3);
					dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj.getStrGlobalRequestNo(),4);
					dao.setProcInValue(nInsertedIndex2, "billNo", voObj.getStrBillNo(),5);
					dao.setProcInValue(nInsertedIndex2, "recNo",strRefundReceiptNo,6);
					dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrAccountNo(),7);
					dao.setProcInValue(nInsertedIndex2, "puk", voObj.getStrCrNo(),8);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrTreatmentCategory(),9);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrRaisingDepartment(),10);
					dao.setProcInValue(nInsertedIndex2, "grpId",strTempGroupId,11);
					dao.setProcInValue(nInsertedIndex2, "trfId",strTempTariffId,12);
					dao.setProcInValue(nInsertedIndex2, "reconcileQty",strTempReqQty,13);
					dao.setProcInValue(nInsertedIndex2, "reconcileQtyUnitId",strTempQtyUnitId,14);
					dao.setProcInValue(nInsertedIndex2, "rate",strTempTariffRate,15);
					dao.setProcInValue(nInsertedIndex2, "actRate",strTempTariffActualRate,16);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",strTempRateUnitId,17);
					dao.setProcInValue(nInsertedIndex2, "serTax",strTempServiceTax,18);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj.getStrTariffServiceTaxAmt()[i],19);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj.getStrTariffNetAmt()[i],20);
					dao.setProcInValue(nInsertedIndex2, "appId",strTempApprovalId,21);
					dao.setProcInValue(nInsertedIndex2, "disUnit",strTempDiscountUnit,22);
					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj.getStrTariffDiscountAmt()[i],23);
					dao.setProcInValue(nInsertedIndex2, "disType",strTempDiscountType,24);
					dao.setProcInValue(nInsertedIndex2, "disBy",strTempApprovalBy,25);
					dao.setProcInValue(nInsertedIndex2, "disReason",strTempReason,26);
					dao.setProcInValue(nInsertedIndex2, "disDate",strTempApprovalDate,27);
					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrChargeTypeId(),28);
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj.getStrWard(),29);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrBillingService(),30);
					dao.setProcInValue(nInsertedIndex2, "serviceId", voObj.getStrService(),31);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",strTempGblTrariffId,32);
					dao.setProcInValue(nInsertedIndex2, "isRefund", "0",33); // must
					// be
					// change
					dao.setProcInValue(nInsertedIndex2, "isPackage",strTempIsPackage,34);
					dao.setProcInValue(nInsertedIndex2, "refRecNo",	strRefReceiptNo,35);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(),36);
					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1,37);
					dao.execute(nInsertedIndex2, 1);
				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());

				paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].split("#")[0].equals("10")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("3");
				paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[j]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrClientPatientNo().length() > 1 &&
			 * !voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(voObj.getStrBillNo());
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo(strRefundReceiptNo);
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			 * paymentDao.setStrBServiceId(voObj.getStrBillingService());
			 * paymentDao.setStrPaymentDetails(voObj.getStrClientName());
			 * paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("3");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOnlineMaxClientBenefitAmount());
			 * 
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {
			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlineReconcillation()--> "
							+ err);
			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	/**
	 * Inserts On-line Advance Details
	 * 
	 * @param voObj
	 */
	public static void insertOnlineAdvance(CashCollectionOnlineTransVO voObj) 
	{
		int nAccFlag = 0;
		int nBillFlag = 0;
		boolean fClientFlag = false;
		String strAccountNo = "0";
		String strBillNo = "0";
		int nInsertedIndex3 = 0;
		int nUpdatedIndex = 0;

		HisDAO dao = null;
		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PatientAccountDAO patAccDao = null;
		ClientPatientDAO clientPatDao = null;
		BillDAO billDao = null;
		BillReceiptDAO billReceiptDao = null;
		PatientAccountServiceDAO patAccSerDao = null;
		OutBoundDAO outBoundDao = null;
		PaymentDAO paymentDao = null;
		BillRequisitionTariffDAO billReqTrfDao = null;
		BillRequisitionTariffDAO billReqTrfDao2 = null;
		BillReqPackageDAO billReqPkgDao = null;

		try 
		{

			dao = new HisDAO("Billing", "CashCollectionOnlineTransDAO");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			patAccDao = new PatientAccountDAO();
			clientPatDao = new ClientPatientDAO();
			billDao = new BillDAO();
			billReceiptDao = new BillReceiptDAO();
			patAccSerDao = new PatientAccountServiceDAO();
			outBoundDao = new OutBoundDAO();
			paymentDao = new PaymentDAO();
			billReqTrfDao = new BillRequisitionTariffDAO();
			billReqTrfDao2 = new BillRequisitionTariffDAO();
			billReqPkgDao=new BillReqPackageDAO();

			// Get Counter Id
			getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// If Account Opened Already 
			strAccountNo = voObj.getStrAccountNo();

			if (voObj.getStrAccountNo() != null && voObj.getStrAccountNo().length() <= 1) // If Account Not Opened 
			{
				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());
				pKey.setStrAppendHospcodeFlag("1");

				pKey.select(dao);
				strAccountNo = pKey.getStrPrimrayKeyValue();
				nAccFlag = 1;
			}
			//System.out.println("client patient no in dao is::"+voObj.getStrClientPatientNo());
			/*if (voObj.getStrClientPatientNo().length() > 1) 
			{
				fClientFlag = true;
			}*/

			
			/* LOGIC BY AMIT ATERIA. IF CREDIT DETAILS PRESENT THEN ACCOUNT WILL BE OPENED IN NAME OF CLIENT*/
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
				fClientFlag = true;
			
			patAccDao.setStrPatAccNo(strAccountNo);
			patAccDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			patAccDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());

			/*if (fClientFlag) 
			{
				patAccDao.setStrClientPatientNo(voObj.getStrClientPatientNo());
				patAccDao.setStrSancAmt(voObj.getStrSancAmount());
				patAccDao.setStrClientBalance(voObj.getStrClientBalance());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}*/
			
			if (fClientFlag) 
			{
				patAccDao.setStrClientPatientNo(strAccountNo);
				patAccDao.setStrSancAmt(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrClientBalance(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());//TO BE CHECK
				patAccDao.setStrClientAmt(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrPatRecdAmt("0.00");
				patAccDao.setStrRoomLimit(voObj.getStrRoomLimit());
			}
			else
				patAccDao.setStrPatRecdAmt(voObj.getStrOnlineTotalRecAmount());

			patAccDao.setStrAdmNo(voObj.getStrAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrEpisode());
			patAccDao.setStrCatCode(voObj.getStrTreatmentCategory());

			
			patAccDao.setStrPatAccountStatus("1");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrIsValid("1");
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccDao.insert(dao);

			/*if (fClientFlag) 
			{

				clientPatDao.setStrClientPatNo(voObj.getStrClientPatientNo());
				//clientPatDao.insert(dao);
			}*/

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.setStrAppendHospcodeFlag("1");

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			billDao.setStrBillNo(strBillNo);
			billDao.setStrPatAccNo(strAccountNo);
			/*if (fClientFlag) 
			{
				billDao.setStrClientPatNo(voObj.getStrClientPatientNo());
				billDao.setStrSancAmt(voObj.getStrSancAmount());
				billDao.setStrClientBalance(voObj.getStrClientBalance());
			}*/
			
			if (fClientFlag) 
			{
				billDao.setStrClientPatNo(strAccountNo);
				billDao.setStrSancAmt(voObj.getStrOnlineTotalRecAmount());
				billDao.setStrClientBalance(voObj.getStrOnlineTotalRecAmount());
				billDao.setStrClientNetAmt(voObj.getStrOnlineTotalRecAmount());
				billDao.setStrPatientNetAmt("0.00");//If Credit category Then 0
			}
			else
				billDao.setStrPatientNetAmt(voObj.getStrOnlineTotalRecAmount());
			
			billDao.setStrAdmNo(voObj.getStrAdmissionNo());
			billDao.setStrBServiceId(voObj.getStrBillingService());
			billDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			billDao.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			billDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billDao.setStrEpisodeCode(voObj.getStrEpisode());
			billDao.setStrPuk(voObj.getStrCrNo());
			billDao.setStrRemarks(voObj.getStrRemarks());			
			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrWard());
			billDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());
			billDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			billDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrRequestType());
			billReceiptDao.setStrRequestNo(voObj.getStrRequestNo());
			billReceiptDao.setStrRequestDate(voObj.getStrRequestDate());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);
			
			/*if (fClientFlag) 
			{
				billReceiptDao.setStrClientPatNo(voObj.getStrClientPatientNo());
				billReceiptDao.setStrClientBalance(voObj.getStrClientBalance());
				//If Credit category Then amt paid by patient is zero..whole amt is paid by client..
				billDao.setStrPatientNetAmt("0.00");
			}*/
			if (fClientFlag) 
			{
				billReceiptDao.setStrClientPatNo(strAccountNo);
				billReceiptDao.setStrClientBalance(voObj.getStrOnlineTotalRecAmount());
				billReceiptDao.setStrClientTotAmt(voObj.getStrOnlineTotalRecAmount());
				//If Credit category Then amt paid by patient is zero..whole amt is paid by client..
				billReceiptDao.setStrPatientTAmt("0.00");
			}
			else
				billReceiptDao.setStrPatientTAmt(voObj.getStrOnlineTotalRecAmount());

			billReceiptDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billReceiptDao.setStrBServiceId(voObj.getStrBillingService());
			billReceiptDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			billReceiptDao.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			
			billReceiptDao.setStrCounterId(strCounterId);
			
			if (voObj.getStrChk_value().equals("1")) 
			{
				billReceiptDao.setStrApprovalId(voObj.getStrApprovalId());
				billReceiptDao.setStrApprovedBy(voObj.getStrApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrApprovedDate());
				billReceiptDao.setStrRemarks(voObj.getStrRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrWard());
			billReceiptDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			billReceiptDao.setStrIsOnline("1");
			billReceiptDao.setStrIsBill("1");
			billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());
			
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
			{
				//ADV LETTER^21-Jul-2016^1007^Cghs^0.00^879^19-AUG-2016^^Select Value^Staff Adv Check^19-AUG-2016
				billReceiptDao.setStrCreditBillFlag("1");
				//billReceiptDao.setStrClNo(voObj.getStrCreditLetterNo()[0]);//cz jz 1 row of credit will be received in ipd case..
				billReceiptDao.setStrClNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0]);//cz jz 1 row of credit will be received in ipd case..
				//billReceiptDao.setStrClDate(voObj.getStrCreditLetterDate()[0]);
				billReceiptDao.setStrClDate(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1]);
				billReceiptDao.setStrClPath(voObj.getStrCreditFilePath()[0]);
				//billReceiptDao.setStrClientNo((voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName());
				billReceiptDao.setStrClientNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2]);
				billReceiptDao.setStrCreditBillStatus(voObj.getStrCreditBillApprovalDone());//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
				//billReceiptDao.setStrClCardNoId(voObj.getStrEmployeeId());
				billReceiptDao.setStrClCardNoId(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[5]);
				//billReceiptDao.setStrClCardHolderName(voObj.getStrEmployeeName());
				billReceiptDao.setStrClCardHolderName(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[7]);
				//billReceiptDao.setStrCreditRelationWithStaff(voObj.getStrRalationId());
				billReceiptDao.setStrCreditRelationWithStaff(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11]);
				//billReceiptDao.setStrClValidity(voObj.getStrCardValidity());
				billReceiptDao.setStrClValidity(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[6]);
			}
			//COMMENTED BY AMIT KUMAR ATERIA . NO LOGIC OF CLIENT PATIENT. LOGIC REMOVED
			//new credit values..
			/*if (fClientFlag) 
			{
				billReceiptDao.setStrCreditBillFlag("1");
				billReceiptDao.setStrClNo(voObj.getStrCreditLetterNo()[0]);//cz jz 1 row of credit will be received in ipd case..
				billReceiptDao.setStrClDate(voObj.getStrCreditLetterDate()[0]);
				billReceiptDao.setStrClPath(voObj.getStrCreditFilePath()[0]);
				billReceiptDao.setStrClientNo(voObj.getStrCreditClientNo()[0]);
				billReceiptDao.setStrCreditBillStatus("1");//approved
				billReceiptDao.setStrClCardNoId(voObj.getStrEmployeeId());
				billReceiptDao.setStrClCardHolderName(voObj.getStrEmployeeName());
				billReceiptDao.setStrCreditRelationWithStaff(voObj.getStrRalationId());
				billReceiptDao.setStrClValidity(voObj.getStrCardValidity());
			}*/
			billReceiptDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			billReceiptDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			billReceiptDao.insert(dao);
			
			if(voObj.getStrCreditLetterNo()!=null)
			{
				for(int k=0;k<voObj.getStrCreditLetterNo().length;k++)
				{
					if(voObj.getStrCreditLetterNo()[k]!=null && !voObj.getStrCreditLetterNo()[k].equals("0"))//SELECT VALUE
					{
						String newLetterFlag=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[12];
						 String mergeLetterFlag=voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[13];
						 if(newLetterFlag.equals("1"))
						  {
								if(mergeLetterFlag.equals("1"))
								{
									nUpdatedIndex = dao.setProcedure("{call pkg_bill_dml.dml_hrgt_credit_pat_dtl(?,?,?,?)}");
									//Input Value
									dao.setProcInValue(nUpdatedIndex,"modval","1",1);
									dao.setProcInValue(nUpdatedIndex, "puk", voObj.getStrCrNo(),2);
									dao.setProcInValue(nUpdatedIndex, "hrgnum_hospital_code", voObj.getStrHospitalCode(),3);
									dao.setProcOutValue(nUpdatedIndex,"err",1,4);
									//keep in batch
									dao.execute(nUpdatedIndex,1);
								}
							}
					}
				}
			}
			if(voObj.getStrNewCreditLetterAddedFlag().equals("1"))
			{
				//String[] strCredcitLetterNo=voObj.getStrCreditLetterNo()[0].replace("^","#").split("#");
				nInsertedIndex3 = dao.setProcedure("{call pkg_reg_dml.dml_hrgt_credit_pat_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?::timestamp without time zone,?,?,?,?::numeric,?,?::timestamp without time zone,?::timestamp without time zone,?::numeric,?::numeric,?)}");
	
				dao.setProcInValue(nInsertedIndex3, "p_modeval", "3",1);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_puk", voObj.getStrCrNo(),2);
				//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName(),3);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2],3);
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3],4);//Name
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrTreatmentCategory(),5);
				//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : "",6);			
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[5],6);
				//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : "",7);			
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#").length>=7 ? voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[7]:"" ,7);//To Be check
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_seat_id", voObj.getStrSeatId(),8);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11] != null && voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11] != "0") ? "1" : "0",9);
				//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", (voObj.getStrRalationId() != null && voObj.getStrRalationId() != "") ? voObj.getStrRalationId() : "",10);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11],10);
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_relation", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[8],11);//Name Relation
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_name",(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[9]!=null && voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[9]!="") ? voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[9]:"" ,12);//To Be Check
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_district_code", "0",13);//Arogyashri
				//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : "",14);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[6],14);			
				if(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2].equals(BillConfigUtil.AROGYASHREE_CLIENT_CODE) || voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2].equals(BillConfigUtil.NTR_CLIENT_CODE))
						dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0],15);//Arogyashri To Be Check
				else
					dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri To Be Check
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[14] ,18);//To Be check
				dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0],19);
				dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1],20);
				if(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2].equals(BillConfigUtil.AROGYASHREE_CLIENT_CODE) || voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2].equals(BillConfigUtil.NTR_CLIENT_CODE))
					dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", "",21);
				else
					dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1],21);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_limit", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[4],22);
				dao.setProcInValue(nInsertedIndex3, "p_actual_amount", "0",23);
				//CL101^21-JUN-2016^1003^Credit^5000.00^STAFF101^21-JUL-2016^^Daughter^CREDIT LI MIT TWO^21-JUL-2016
				dao.setProcOutValue(nInsertedIndex3, "err", 1,24);
				
				dao.execute(nInsertedIndex3, 1);
			}

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrBServiceId(voObj.getStrBillingService());
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			// patAccSerDao.setStrTariffRate(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrAdvanceAmount())));
			patAccSerDao.setStrTariffRate(voObj.getStrOnlineTotalRecAmount());
			patAccSerDao.setStrCatCode(voObj.getStrTreatmentCategory());
			patAccSerDao.setStrBillQty("1");
			patAccSerDao.setStrProcessedQty("0");
			patAccSerDao.setStrRemainedQty("1");
			patAccSerDao.setStrPuk(voObj.getStrCrNo());
			patAccSerDao.setStrRemarks(voObj.getStrRemarks());
			patAccSerDao.setStrSeatId(voObj.getStrSeatId());
			patAccSerDao.setStrIsValid("1");
			patAccSerDao.setStrIsRefundable("0");
			patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBillFlag("1");
			patAccSerDao.setStrReceiptNo("1");
			patAccSerDao.setStrWardCode(voObj.getStrWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrAdvanceAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOnlineTotalRecAmount());
			patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
			
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
			{
				//ADV LETTER^21-Jul-2016^1007^Cghs^0.00^879^19-AUG-2016^^Select Value^Staff Adv Check^19-AUG-2016
				patAccSerDao.setStrCreditBillFlag("1");
				//patAccSerDao.setStrClNo(voObj.getStrCreditLetterNo()[0]);//cz jz 1 row of credit will be received in ipd case..
				patAccSerDao.setStrClNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0]);//cz jz 1 row of credit will be received in ipd case..
				//patAccSerDao.setStrClDate(voObj.getStrCreditLetterDate()[0]);
				patAccSerDao.setStrClDate(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1]);
				patAccSerDao.setStrClPath(voObj.getStrCreditFilePath()[0]);
				//patAccSerDao.setStrClientNo((voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName());
				patAccSerDao.setStrClientNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2]);
				patAccSerDao.setStrCreditBillStatus(voObj.getStrCreditBillApprovalDone());//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
				//patAccSerDao.setStrClCardNoId(voObj.getStrEmployeeId());
				patAccSerDao.setStrClCardNoId(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[5]);
				//patAccSerDao.setStrClCardHolderName(voObj.getStrEmployeeName());
				patAccSerDao.setStrClCardHolderName(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[7]);
				//patAccSerDao.setStrCreditRelationWithStaff(voObj.getStrRalationId());
				patAccSerDao.setStrCreditRelationWithStaff(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[11]);
				//patAccSerDao.setStrClValidity(voObj.getStrCardValidity());
				patAccSerDao.setStrClValidity(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[6]);				
			}
			//COMMENTED BY AMIT KUMAR ATERIA . NO LOGIC OF CLIENT PATIENT. LOGIC REMOVED
			//new credit values..
			/*if (fClientFlag) 
			{
				patAccSerDao.setStrCreditBillFlag("1");
				patAccSerDao.setStrClNo(voObj.getStrCreditLetterNo()[0]);//cz jz 1 row of credit will be received in ipd case..
				patAccSerDao.setStrClDate(voObj.getStrCreditLetterDate()[0]);
				patAccSerDao.setStrClPath(voObj.getStrCreditFilePath()[0]);
				patAccSerDao.setStrClientNo(voObj.getStrCreditClientNo()[0]);
				patAccSerDao.setStrCreditBillStatus("1");//approved
				patAccSerDao.setStrClCardNoId(voObj.getStrEmployeeId());
				patAccSerDao.setStrClCardHolderName(voObj.getStrEmployeeName());
				patAccSerDao.setStrCreditRelationWithStaff(voObj.getStrRalationId());
				patAccSerDao.setStrClValidity(voObj.getStrCardValidity());
			}*/
			//System.out.println("voObj.getStrPackageId()"+voObj.getStrPackageId());
			/* Logic To Insert package Details in HBLT_ACC_PACKAGE_DTL When Package is raised from Adm Advice*/ 
			if(voObj.getStrPackageId()!=null && !voObj.getStrPackageId().equals("") && !voObj.getStrPackageId().equals("0"))
			{
				patAccSerDao.setStrIsPackage(voObj.getStrPackageId());
			}
			patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccSerDao.insert(dao);
			if(!voObj.getStrOnlineAmount()[0].equals(voObj.getStrOnlineTotalRecAmount()))
			{
				patAccSerDao.setStrPatAccountNo(strAccountNo);
				patAccSerDao.setStrReqNo(strBillNo);
				patAccSerDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				patAccSerDao.setStrTariffId("1090001"); //Surcharge Tariff for Card based payments
				patAccSerDao.setStrDeptCode(voObj.getStrRaisingDepartment());
				patAccSerDao.setStrReqType("1");
				patAccSerDao.setStrGroupId("109");
				patAccSerDao.setStrBServiceId("11");
				patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
				patAccSerDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
				// patAccSerDao.setStrTariffRate(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrAdvanceAmount())));
				patAccSerDao.setStrTariffRate(String.valueOf(Math.round(Double.parseDouble(voObj.getStrOnlineAmount()[0]))-Double.parseDouble(voObj.getStrOnlineTotalRecAmount())));
				patAccSerDao.setStrCatCode(voObj.getStrTreatmentCategory());
				patAccSerDao.setStrBillQty("1");
				patAccSerDao.setStrProcessedQty("1");
				patAccSerDao.setStrRemainedQty("0");
				patAccSerDao.setStrPuk(voObj.getStrCrNo());
				patAccSerDao.setStrRemarks("Surcharge Tariff");
				patAccSerDao.setStrSeatId(voObj.getStrSeatId());
				patAccSerDao.setStrIsValid("1");
				patAccSerDao.setStrIsRefundable("0");
				patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
				patAccSerDao.setStrBillFlag("1");
				patAccSerDao.setStrReceiptNo("1");
				patAccSerDao.setStrWardCode(voObj.getStrWard());
				patAccSerDao.setStrStatus("1");
				// patAccSerDao.setStrNetAmt(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrAdvanceAmount())));
				patAccSerDao.setStrNetAmt(String.valueOf(Math.round(Double.parseDouble(voObj.getStrOnlineAmount()[0]))-Double.parseDouble(voObj.getStrOnlineTotalRecAmount())));
				patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
				patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				patAccSerDao.insert(dao);
			}

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(strAccountNo);
			outBoundDao.setStrRequestNo(voObj.getStrRequestNo());
			outBoundDao.setStrReqDate(voObj.getStrCurrentDate());
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrEpisode());
			outBoundDao.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOnlineTotalRecAmount());
			outBoundDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			outBoundDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			outBoundDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			outBoundDao.setStrCounterId(strCounterId);
			outBoundDao.setStrBServiceId(voObj.getStrBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("1");
			outBoundDao.setStrHospitalCode(voObj.getStrHospitalCode());
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
			{
				outBoundDao.setStrCreditBillFlag("1");
			}
			else
				outBoundDao.setStrCreditBillFlag("0");
			outBoundDao.setStrCreditBillStatus(voObj.getStrCreditBillApprovalDone());//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
			outBoundDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			outBoundDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			outBoundDao.insert(dao);

			// Payment Details.
			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) 
			{
				nSlNo = nSlNo + 1;
				paymentDao.setStrBillNo(strBillNo);
				if (fClientFlag)
				{
					paymentDao.setStrPaymentMode("10");//CREDIT/CLIENT
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					paymentDao.setStrPaymentDetails((voObj.getStrCreditLetterNo() != null && voObj.getStrCreditLetterNo()[0] != "0") ? voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3] : "");//Client Name
				}
				else
				{
					paymentDao.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i].split("#")[0]);
					paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[i]);
				}
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());
				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(",", "#").split("#");
				
				if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("3")) 
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
				} 
				else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("5")) 
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
				} 
				else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("10")) 
				{
					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} 
				else 
				{
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[i]);
				paymentDao.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[i]);
				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				paymentDao.insert(dao);
			}

			//Insert Credit Details In HBLT_BILLREQ_TARIFF_DTL
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals("")&&voObj.getStrCreditBillApprovalDone().equals("2"))//Credit Details Found and Direct Approval
			{
				billReqTrfDao.setStrAppId("0");
				billReqTrfDao.setStrDiscountType("0");
				billReqTrfDao.setStrDiscountUnit("0");
				/*billReqTrfDao.setStrCreditLetterRefNo(voObj.getStrCreditLetterNo()[0]);
				billReqTrfDao.setStrCreditLetterDate(voObj.getStrCreditLetterDate()[0]);
				billReqTrfDao.setStrCreditLetterUploadFilePath(voObj.getStrCreditFilePath()[0]);
				billReqTrfDao.setStrClientNo((voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName());*/
				
				//ADV LETTER^21-Jul-2016^1007^Cghs^0.00^879^19-AUG-2016^^Select Value^Staff Adv Check^19-AUG-2016				
				
				billReqTrfDao.setStrCreditLetterRefNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0]);
				billReqTrfDao.setStrCreditLetterDate(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1]);
				billReqTrfDao.setStrCreditLetterUploadFilePath(voObj.getStrCreditFilePath()[0]);
				billReqTrfDao.setStrClientNo(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2]);
				billReqTrfDao.setStrCreditApprovedBy("0");
				billReqTrfDao.setStrAmtPaidByPatient(String.valueOf("0"));
				billReqTrfDao.setStrAmtPaidByClient(String.valueOf(voObj.getStrOnlineTotalRecAmount()));
				//billReqTrfDao.setStrStaffCardNoId(voObj.getStrEmployeeId());			
				billReqTrfDao.setStrStaffCardNoId(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[5]);
				billReqTrfDao.setStrCreditBillStatus(voObj.getStrCreditBillApprovalDone());//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
				//billReqTrfDao.setStrStaffCardHolderName(voObj.getStrEmployeeName());
				billReqTrfDao.setStrStaffCardHolderName(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[9]);
				//billReqTrfDao.setStrRelationWithStaffCardholder(voObj.getStrRalationId());
				billReqTrfDao.setStrRelationWithStaffCardholder(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[7]);
				//billReqTrfDao.setStrCardValidity(voObj.getStrCardValidity());
				billReqTrfDao.setStrCardValidity(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[6]);
				billReqTrfDao.setStrTariffId("");
				billReqTrfDao.setStrReqNo(voObj.getStrRequestNo());
				billReqTrfDao.setStrHospitalCode(voObj.getStrHospitalCode());
				billReqTrfDao.setStrPuk(voObj.getStrCrNo());			
				billReqTrfDao.updateCreditBillApproval(dao);
				
				
				
				billReqTrfDao.setStrReqNo(voObj.getStrRequestNo());
				billReqTrfDao.setStrHospitalCode(voObj.getStrHospitalCode());
				billReqTrfDao.setStrPuk(voObj.getStrCrNo());
				
				billReqTrfDao.updateCreditBillApproval2(dao);				
			}
			billReqTrfDao.setStrReqNo(voObj.getStrRequestNo());
			billReqTrfDao.setStrHospitalCode(voObj.getStrHospitalCode());
			billReqTrfDao.setStrPuk(voObj.getStrCrNo());
			billReqTrfDao.setStrCreditBillStatus(voObj.getStrCreditBillApprovalDone());//0-Not Required,1-Done,2-Not Required Direct (Without Approval)
			billReqTrfDao.updateCreditBillApproval3(dao);
			
			// In-Bound Details
			billReqTrfDao2.setStrReqNo(voObj.getStrRequestNo());
			billReqTrfDao2.setStrTariffId("0");
			billReqTrfDao2.setStrBillQty("1");
			billReqTrfDao2.setStrHospitalCode(voObj.getStrHospitalCode());

			billReqTrfDao2.update2(dao);
			
			System.out.println("voObj.getStrPackageId()"+voObj.getStrPackageId());
			
			if(voObj.getStrPackageId()!=null && !voObj.getStrPackageId().equals("") && !voObj.getStrPackageId().equals("0"))
			{
				billReqPkgDao.setStrRequestNo(voObj.getStrRequestNo());
				billReqPkgDao.setStrPackageId(voObj.getStrPackageId());
				billReqPkgDao.setStrBillQty("1");
				billReqPkgDao.setStrHospitalCode(voObj.getStrHospitalCode());
	
				billReqPkgDao.update(dao);
			}
			

			synchronized (dao) 
			{
				dao.fire();
			}

		} 
		catch (Exception e) 
		{
			String err = "err:" + e.getMessage();
			voObj.setStrMsgString("CashCollectionOnlineTransDAO.insertOnlineAdvance()--> "+ err);
			voObj.setStrMsgType("1");

			if (nAccFlag == 1) 
			{
				try 
				{
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());

					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);
				} 
				catch (Exception e1) 
				{
					voObj.setStrMsgString("CashCollectionOnlineTransDAO.insertOnlineAdvance()--> "+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");
				}
			}
			if (nBillFlag == 1) 
			{
				try 
				{
					pKeyLogDao.setStrKeyname("BILL_IPD");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode()); 
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} 
				catch (Exception e1) 
				{
					voObj.setStrMsgString("CashCollectionOnlineTransDAO.insertOnlineAdvance()--> "+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");
				}
			}
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}

			if (pKey != null) 			pKey 			= null;
			if (pKeyLogDao != null)		pKeyLogDao 		= null;
			if (patAccDao != null)		patAccDao 		= null;
			if (clientPatDao != null)	clientPatDao 	= null;
			if (billDao != null)		billDao 		= null;
			if (billReceiptDao != null)	billReceiptDao 	= null;
			if (patAccSerDao != null)	patAccSerDao 	= null;
			if (outBoundDao != null)	outBoundDao 	= null;
			if (paymentDao != null)		paymentDao 		= null;
			if (billReqTrfDao != null)	billReqTrfDao 	= null;

		}
	}

	/**
	 * Inserts Online Part Payment Details
	 * 
	 * @param voObj
	 */
	public static void insertOnlinePartPayment(CashCollectionOnlineTransVO voObj) {

		int nAccFlag = 0;
		int nBillFlag = 0;

		String strAccountNo = "0";
		String strBillNo = "0";
		String counterId = "0";
		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PatientAccountDAO patAccDao = null;
		BillDAO billDao = null;
		BillReceiptDAO billReceiptDao = null;
		PatientAccountServiceDAO patAccSerDao = null;
		OutBoundDAO outBoundDao = null;
		PaymentDAO paymentDao = null;
		BillRequisitionTariffDAO billReqTrfDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			patAccDao = new PatientAccountDAO();
			billDao = new BillDAO();
			billReceiptDao = new BillReceiptDAO();
			patAccSerDao = new PatientAccountServiceDAO();
			outBoundDao = new OutBoundDAO();
			paymentDao = new PaymentDAO();
			billReqTrfDao = new BillRequisitionTariffDAO();

			HisUtil hisUtil = new HisUtil("Bill Transaction",
					"CashCollectionTransDAO");

			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			// Get Counter Detail.
			getCounterId(voObj);

			counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open Account.
			strAccountNo = voObj.getStrAccountNo();

			if (voObj.getStrAccountNo() != null
					&& voObj.getStrAccountNo().equals("")) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());
				pKey.select(dao);

				strAccountNo = pKey.getStrPrimrayKeyValue();

				nAccFlag = 1;

			}

			if (nAccFlag == 1) {

				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				patAccDao.setStrDeptCode(voObj.getStrRaisingDepartment());
				patAccDao.setStrPuk(voObj.getStrCrNo());

				patAccDao.setStrAdmNo(voObj.getStrAdmissionNo());
				patAccDao.setStrEpisodeCode(voObj.getStrEpisode());
				patAccDao.setStrCatCode(voObj.getStrTreatmentCategory());

				patAccDao.setStrPatRecdAmt(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrPatAccountStatus("2");
				patAccDao.setStrSeatId(voObj.getStrSeatId());
				patAccDao.setStrIsValid("1");
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
				patAccDao.setStrRoomLimit(voObj.getStrRoomLimit());

				patAccDao.insert(dao);

			} else {
				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrPatRecdAmt(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
				patAccDao.setStrRoomLimit(voObj.getStrRoomLimit());

				patAccDao.update4(dao);

			}

			// Bill Generation.
			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			voObj.setStrBillNo(strBillNo);

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			billDao.setStrBillNo(strBillNo);
			billDao.setStrPatAccNo(strAccountNo);
			billDao.setStrAdmNo(voObj.getStrAdmissionNo());
			billDao.setStrBServiceId(voObj.getStrBillingService());
			billDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			billDao.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			billDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billDao.setStrEpisodeCode(voObj.getStrEpisode());
			billDao.setStrPuk(voObj.getStrCrNo());
			billDao.setStrRemarks(voObj.getStrRemarks());
			billDao.setStrPatientNetAmt(voObj.getStrOnlineTotalRecAmount());
			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrWard());
			billDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrRequestType());
			billReceiptDao.setStrRequestNo(voObj.getStrRequestNo());
			billReceiptDao.setStrRequestDate(voObj.getStrRequestDate());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);
			billReceiptDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billReceiptDao.setStrBServiceId(voObj.getStrBillingService());
			billReceiptDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			billReceiptDao
					.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			billReceiptDao
					.setStrPatientTAmt(voObj.getStrOnlineTotalRecAmount());
			billReceiptDao.setStrCounterId(counterId);

			if (voObj.getStrChk_value().equals("1")) {

				billReceiptDao.setStrApprovalId(voObj.getStrApprovalId());
				billReceiptDao.setStrApprovedBy(voObj.getStrApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrApprovedDate());
				billReceiptDao.setStrRemarks(voObj.getStrRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrWard());
			billReceiptDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billReceiptDao.setStrIsOnline("1");
			billReceiptDao.setStrIsBill("1");
			billReceiptDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billReceiptDao.insert(dao);

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrBServiceId(voObj.getStrBillingService());
			patAccSerDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			// patAccSerDao.setStrTariffRate(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrPartPaymentAmount())));
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrTariffRate(voObj.getStrOnlineTotalRecAmount());
			patAccSerDao.setStrCatCode(voObj.getStrTreatmentCategory());
			patAccSerDao.setStrBillQty("1");
			patAccSerDao.setStrProcessedQty("0");
			patAccSerDao.setStrRemainedQty("1");
			patAccSerDao.setStrPuk(voObj.getStrCrNo());
			patAccSerDao.setStrRemarks(voObj.getStrRemarks());
			patAccSerDao.setStrSeatId(voObj.getStrSeatId());
			patAccSerDao.setStrIsValid("1");
			patAccSerDao.setStrIsRefundable("0");
			patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBillFlag("1");
			patAccSerDao.setStrReceiptNo("1");
			patAccSerDao.setStrWardCode(voObj.getStrWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrPartPaymentAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOnlineTotalRecAmount());
			patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());

			patAccSerDao.insert(dao);

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(voObj.getStrAccountNo());
			outBoundDao.setStrRequestNo(voObj.getStrRequestNo());
			outBoundDao.setStrReqDate(voObj.getStrCurrentDate());
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrEpisode());
			outBoundDao.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOnlineTotalRecAmount());
			outBoundDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			outBoundDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			outBoundDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			outBoundDao.setStrCounterId(counterId);
			outBoundDao.setStrBServiceId(voObj.getStrBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("1");
			outBoundDao.setStrHospitalCode(voObj.getStrHospitalCode());
			outBoundDao.insert(dao);

			// Payment Details.
			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);
				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("2")
						|| voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("4")
						|| voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].split("#")[0].equals("10")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOnlineAmount()[i]);
				paymentDao
						.setStrPaymentDetails(voObj.getStrOnlinePaymentDtls()[i]);
				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(counterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrClientPatientNo().length() > 1 &&
			 * !voObj.getStrOnlineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			 * paymentDao.setStrBServiceId(voObj.getStrBillingService());
			 * paymentDao.setStrPaymentDetails(voObj.getStrClientName());
			 * paymentDao.setStrPaymentModeNo(voObj.getStrClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("1");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOnlineMaxClientBenefitAmount());
			 * 
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(counterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			// In-Bound Details Updating.
			billReqTrfDao.setStrReqNo(voObj.getStrRequestNo());
			billReqTrfDao.setStrTariffId("0");
			billReqTrfDao.setStrBillQty("1");
			billReqTrfDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billReqTrfDao.update2(dao);

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlinePartPayment()--> "
							+ err);
			voObj.setStrMsgType("1");

			if (nAccFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());

					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlinePartPayment()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1) {

				try {

					pKeyLogDao.setStrKeyname("BILL_IPD");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());

					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlinePartPayment()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			if (pKey != null)
				pKey = null;
			if (pKeyLogDao != null)
				pKeyLogDao = null;
			if (patAccDao != null)
				patAccDao = null;
			if (billDao != null)
				billDao = null;
			if (billReceiptDao != null)
				billReceiptDao = null;
			if (patAccSerDao != null)
				patAccSerDao = null;
			if (outBoundDao != null)
				outBoundDao = null;
			if (paymentDao != null)
				paymentDao = null;
			if (billReqTrfDao != null)
				billReqTrfDao = null;

		}

	}

	/**
	 * executes the BILL_MST.getCounterDtl() by passing Module Id, IP Address,
	 * Hospital Code and Mode 1. which generates the Counter and set to Value
	 * Object's counterId.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getCounterId(CashCollectionOnlineTransVO voObj) {

		String strCounterId = "";
		String strMode = "1";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.getCounterDtl(?,?,?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("billing","transactions.CashCollectionTransDAO .getCounterId()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrModuleId());
			dao.setFuncInValue(nfuncIndex, 3, voObj.getStrIpAddress());
			dao.setFuncInValue(nfuncIndex, 4, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 5, strMode);
			dao.setFuncOutValue(nfuncIndex, 1);
			
			dao.executeFunction(nfuncIndex);

			strCounterId = dao.getFuncString(nfuncIndex);

			voObj.setStrCounterId(strCounterId);

		} catch (Exception e) {
			e.printStackTrace();
			voObj.setStrMsgString("CashCollectionTransDAO.getCounterId() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getRefundReceiptNo(CashCollectionOnlineTransVO voObj) {

		String strRefundReceiptNo = "";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.get_refund_receiptno(?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("billing","transactions.CashCollectionTransDAO .getRefundReceiptNo()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 3, voObj.getStrBillNo());
			dao.setFuncOutValue(nfuncIndex, 3);

			dao.executeFuncForNumeric(nfuncIndex);

			strRefundReceiptNo = dao.getFuncNumeric(nfuncIndex);

			voObj.setStrRefundReceiptNo(strRefundReceiptNo);

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getRefundReceiptNo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	/*public static void getRelations(CashCollectionOnlineTransVO vo) 
	{
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.proc_get_relations(?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		
		try 
		{
			dao = new HisDAO("billing","transactions.CashCollectionOnlineTransDAO .getRelations()");
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcOutValue(nprocIndex, "err", 1,2);
			dao.setProcOutValue(nprocIndex, "resultset", 2,3);
			
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");
			
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
			vo.setStrRelationWS(ws);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CashCollectionOnlineTransDAO.getRelations() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
		//return ws;
	}*/
	
	/**
	 * retrieves Tariff Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOnlineTrfPackageAvailedList(CashCollectionOnlineTransVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_trf_package_dtl(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();
		String strChargeTypeId = "0";
		

		String strErr = "";

		try 
		{
			if (voObj.getStrCrNo() != null) 
			{
				daoObj = new HisDAO("Billing","CashCollectionTransDAO");				
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
				daoObj.setProcInValue(nProcIndex, "crno", voObj.getStrCrNo(),2);
				daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrTreatmentCategory(),3);
				daoObj.setProcInValue(nProcIndex, "chargetypeid",strChargeTypeId,4);
				daoObj.setProcInValue(nProcIndex, "trfid",voObj.getStrTempTrfId(),5);
				daoObj.setProcInValue(nProcIndex, "trfqty",voObj.getStrTempTrfQty(),6);
				daoObj.setProcInValue(nProcIndex, "pkgid","",7);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,8);								
				daoObj.setProcOutValue(nProcIndex, "err", 1,9);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) 
				{
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");
					voObj.setStrTempPkgWb(ws);
				} 
				else 
				{
					throw new Exception(strErr);
				}
			} 
			else 
			{
				voObj.setStrTempPkgWb(null);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getOnlineTrfPackageAvailedList() --> "+ e.getMessage());
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
	
	/**
	 * retrieves CREDIT LETTERS list based on CR NO,CAT CODE and hospital code
	 * 
	 * @param voObj
	 */
	public static void getCreditLettersList(CashCollectionOnlineTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_credit_letters_list(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Billing","CashCollectionOnlineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(),2);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrOffLineTreatmentCategory(),3);//SENT FROM JS FUNCTION AND SET IN VO	
			daoObj.setProcInValue(nProcIndex, "clientcode", "",4);
			daoObj.setProcInValue(nProcIndex, "serviceType", "",5);
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
				voObj.setCreditLettersWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}

		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("CashCollectionOnlineTransDAO.getCreditLettersList() --> "+ e.getMessage());
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
	
	/**
	 * retrieves Online Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getWalletDetails(CashCollectionOnlineTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";
		String strCrNumber = voObj.getStrCrNo();
		String strHospCode = voObj.getStrHospitalCode();
		
		try 
		{
				if (strCrNumber != null && strHospCode!=null) 
				{
					daoObj = new HisDAO("Billing","CashCollectionOnlineTransDAO");

					nProcIndex = daoObj.setProcedure(strProcName);

					daoObj.setProcInValue(nProcIndex, "accno", "",1);
					daoObj.setProcInValue(nProcIndex, "puk", strCrNumber,2);
					daoObj.setProcInValue(nProcIndex, "chargeTypeId", "",3);
					daoObj.setProcInValue(nProcIndex, "activeAccount", "",4);				
					daoObj.setProcInValue(nProcIndex, "modeval", "8",5);
					daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,6);				
					daoObj.setProcOutValue(nProcIndex, "err", 1,7);
					daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,8);
					daoObj.executeProcedureByPosition(nProcIndex);
					strErr = daoObj.getString(nProcIndex, "err");

					if (strErr == null)
						strErr = "";

					if (strErr.equals("")) 
					{
						ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
						if (ws != null) 
						{
							if (ws.next()) 
							{
								voObj.setStrWalletNo(ws.getString(1));
								voObj.setStrAvlWalletMoney(ws.getString(2));
								voObj.setStrMobileNo(ws.getString(3));
							}
							/*else 
							{
								voObj.setStrWalletNo("----");
								voObj.setStrAvlWalletMoney("0");
							}*/
						} 
						/*else 
						{
							voObj.setStrWalletNo("----");
							voObj.setStrAvlWalletMoney("0");
						}*/
					} 
					else 
					{
						throw new Exception(strErr);
					}
				}
		} 
		catch (Exception e) 
		{
				voObj.setStrMsgString("CashCollectionTransDAO.getWalletDetails() --> "+ e.getMessage());
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
