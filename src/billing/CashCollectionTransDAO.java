package billing;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import billing.dao.ApprovalDAO;
import billing.dao.BillDAO;
import billing.dao.BillReceiptDAO;
import billing.dao.BillRequisitionTariffDAO;
import billing.dao.ClientPatientDAO;
import billing.dao.OutBoundDAO;
import billing.dao.PatientAccountDAO;
import billing.dao.PatientAccountServiceDAO;
import billing.dao.PaymentDAO;
import billing.dao.PrimaryKeyDAO;
import billing.dao.PrimaryKeyLogDAO;

public class CashCollectionTransDAO {

	/**
	 * retrieves Online Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOnlineDetails(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try {

			if (strCrNumber != null) {
				daoObj = new HisDAO("Cash Collection Transaction",
						"CashCollectionTransDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				daoObj.setProcInValue(nProcIndex, "Mode_Type", "1");
				daoObj.setProcInValue(nProcIndex, "CRNO", strCrNumber);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
				daoObj.setProcOutValue(nProcIndex, "ERR", 1);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);
				daoObj.executeProcedure(nProcIndex);
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
	public static void getOnlineTariffDetails(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_billreq_tariff_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strReqNo = voObj.getStrRequestNo();
		String strHospCode = voObj.getStrHospitalCode();
		String strChargeTypeId = voObj.getStrChargeTypeId();

		String strErr = "";

		try {

			if (strReqNo != null) {

				daoObj = new HisDAO("Cash Collection Transaction",
						"CashCollectionTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "reqNo", strReqNo);
				daoObj.setProcInValue(nProcIndex, "modeVal", "1");
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId",
						strChargeTypeId);

				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {
					ws = daoObj.getWebRowSet(nProcIndex, "resultset");

					voObj.setOnlineTariffDetails(ws);

				} else {
					throw new Exception(strErr);
				}
			} else {

				voObj.setOnlineTariffDetails(null);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOnlineTariffDetails() --> "
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
	 * retrieves Patient Account Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientNumber(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strAccNo = voObj.getStrAccountNo();
		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			if (strAccNo != null) {

				daoObj = new HisDAO("Cash Collection Transaction",
						"CashCollectionTransDAO");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "accno", strAccNo);
				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

					if (ws != null) {

						if (ws.next()) {

							voObj.setStrClientPatientNo(ws.getString(4));

						}
					} else {
						voObj.setStrClientPatientNo(null);
					}

				} else {
					throw new Exception(strErr);
				}
			} else {

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

	/**
	 * retrieves Client Patient Details using Client Patient Number.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientDetailsWithClientPatNo(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strClientPatNo = voObj.getStrClientPatientNo();
		String strChargeTypeId = voObj.getStrChargeTypeId();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrBillNo();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "clientpatno", strClientPatNo);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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
					.setStrMsgString("CashCollectionTransDAO.getClientPatientDetailsWithClientPatNo() --> "
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
	 * retrieves Client Patient Details using Cr Number
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientPatientDetailsWithCrNo(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?)}";
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

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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
	 * retrieves Hospital Service List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getHospitalServiceList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_CHARGETYPE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strSeatId = voObj.getStrSeatId();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcInValue(nProcIndex, "seatId", strSeatId);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNo());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineHospitalService(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineHospitalServiceList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getHospitalServiceList() --> "
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
	 * retrieves Billing Service List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getBillingServiceList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_BILLSERVICE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeId = voObj.getStrOffLineHospitalService();
		String strRequestType = voObj.getStrOffLineRequestType();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,1);
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeId,2);
			daoObj.setProcInValue(nProcIndex, "req_type", strRequestType,3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineBillingService(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineBillingServiceList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getBillingServiceList() --> "
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
	 * retrieves Raising Department List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getRaisingDepartmentList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_GBLT_DEPARTMENT_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "4");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo);
			daoObj
					.setProcInValue(nProcIndex, "charge_type_id",
							strChargeTypeId);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineRaisingDepartment(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineRaisingDepartmentList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getRaisingDepartmentList() --> "
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
	 * retrieves Episode List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getEpisodeList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_HRGT_EPISODE_DTL(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrOffLineRaisingDepartment();
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineEpisode(ws.getString(1) + "@"
							+ ws.getString(3));

					ws.beforeFirst();

				}

				voObj.setOfflineEpisodeList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getEpisodeList() --> "
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
	 * retrieves Treatment Category List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getTreatmentCategoryList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.PROC_GBLT_PATIENT_CAT_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo);
			daoObj
					.setProcInValue(nProcIndex, "charge_type_id",
							strChargeTypeId);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineTreatmentCategory(ws.getString(1));

					ws.beforeFirst();

				}
				voObj.setOfflineTreatmentCategoryList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getTreatmentCategoryList() --> "
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
	 * retrieves Ward List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getWardList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.proc_HIPT_WARD_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "10");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo);
			daoObj
					.setProcInValue(nProcIndex, "charge_type_id",
							strChargeTypeId);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineWardList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("CashCollectionTransDAO.getWardList() --> "
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
	public static void getPaymentModeList(CashCollectionTransVO voObj) {

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

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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
	 * retrieves Client Name List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getClientNameList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_mst(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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

	/**
	 * retrieves Remarks List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getRemarksList(CashCollectionTransVO voObj) {

		String proc_name = "";

		proc_name = "{call PKG_SIMPLE_VIEW.PROC_HBLT_REMARKS_MST(?,?,?,?,?)}";

		HisDAO dao = null;

		int nprocIndex = 0;

		String strerr = "";
		String strHospCode = voObj.getStrHospitalCode();

		WebRowSet ws = null;

		try {

			dao = new HisDAO("Cash Collection Transaction",

			"transactions.CashCollectionTransDAO.getRemarksList()");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "rmkstype", "4");

			dao.setProcInValue(nprocIndex, "modeVal", "1");

			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode);

			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				if (ws.next()) {
					voObj.setStrOffLineRemarks(ws.getString(2));

					ws.beforeFirst();
				}

				voObj.setOfflineRemarksList(ws);

				voObj.setStrMsgType("0");

			} else {

				throw new Exception(strerr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getRemarksList() --> "

							+ e.getMessage());

			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * retrieves Approver Employee List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getApprovedBy(CashCollectionTransVO voObj) {

		String proc_name = "";
		proc_name = "{call pkg_simple_view.proc_consultant_name(?,?,?)}";

		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		String strHospCode = voObj.getStrHospitalCode();
		WebRowSet ws = null;

		try {

			dao = new HisDAO("Cash Collection Transaction",

			"transactions.CashCollectionTransDAO.getApprovedBy()");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode);
			//dao.setProcInValue(nprocIndex, "seatId", voObj.getStrSeatId());
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return

			
			
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(nprocIndex);

			// get value
			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineApprovedByList(ws);

				voObj.setStrMsgType("0");

			} else {

				throw new Exception(strerr);

			}

		} catch (Exception e) {

			voObj.setStrMsgString("CashCollectionTransDAO.getApprovedBy() --> "

			+ e.getMessage());

			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {

				dao.free();
				dao = null;

			}

		}

	}

	/**
	 * retrieves Part Payment or Advance Amount
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getPartPaymentOrAdvanceAmount(CashCollectionTransVO voObj)

	{

		String proc_name = "";

		proc_name = "{call PKG_SIMPLE_VIEW.proc_hblt_advance_mst (?,?,?,?,?,?)}";

		HisDAO dao = null;

		int nprocIndex = 0;

		String strerr = "";

		WebRowSet ws = null;

		String wardid = voObj.getStrOffLineWard();
		String patCatCode = voObj.getStrOffLineTreatmentCategory();
		String strHospCode = voObj.getStrHospitalCode();

		try {

			dao = new HisDAO("Cash Collection Transaction",
					"transactions.CashCollectionTransDAO.getPartPaymentOrAdvanceAmount()");

			nprocIndex = dao.setProcedure(proc_name);

			// set value
			dao.setProcInValue(nprocIndex, "wardid", wardid);
			dao.setProcInValue(nprocIndex, "catcode", patCatCode);
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode);
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(nprocIndex);

			// get value
			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				if (ws != null)
					if (ws.next()) {

						voObj.setStrOffLineAdvanceAmount(ws.getString(1));
						voObj.setStrOffLinePartPaymentAmount(ws.getString(2));
					}

				voObj.setStrMsgType("0");

			} else {

				throw new Exception(strerr);

			}

		}

		catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getPartPaymentOrAdvanceAmount() --> "
							+ e.getMessage());

			voObj.setStrMsgType("1");

		} finally {

			if (dao != null) {

				dao.free();
				dao = null;

			}

		}

	}

	/**
	 * retrieves Patient Account Details
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	/*
	 * public static void getOffLineClientPatientNumber(CashCollectionTransVO
	 * voObj) {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null;
	 * 
	 * String strProcName = "{call
	 * pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?)}"; int nProcIndex =
	 * 0;
	 * 
	 * String strAccNo = voObj.getStrAccountNo();
	 * 
	 * String strErr = "";
	 * 
	 * try {
	 * 
	 * if (strAccNo != null) {
	 * 
	 * daoObj = new HisDAO("Cash Collection Transaction",
	 * "CashCollectionTransDAO");
	 * 
	 * nProcIndex = daoObj.setProcedure(strProcName);
	 * 
	 * daoObj.setProcInValue(nProcIndex, "accno", strAccNo);
	 * daoObj.setProcInValue(nProcIndex, "modeval", "1");
	 * daoObj.setProcOutValue(nProcIndex, "err", 1);
	 * daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);
	 * 
	 * daoObj.executeProcedure(nProcIndex);
	 * 
	 * strErr = daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr == null) strErr = "";
	 * 
	 * if (strErr.equals("")) {
	 * 
	 * ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
	 * 
	 * if (ws != null) { System.out.println(" ws VAl : "+ws.size()); if
	 * (ws.next()) {
	 * 
	 * voObj.setStrOffLineClientPatientNo(ws.getString(4)); System.out.println("
	 * Pat No : "+voObj.getStrOffLineClientPatientNo()); } } else {
	 * voObj.setStrOffLineClientPatientNo(null); } } else { throw new
	 * Exception(strErr); } } else {
	 * 
	 * voObj.setOnlineTariffDetails(null); } } catch (Exception e) {
	 * 
	 * voObj
	 * .setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientNumber()
	 * --> " + e.getMessage()); voObj.setStrMsgType("1"); } finally { if (daoObj !=
	 * null) { daoObj.free(); daoObj = null; } } }
	 */

	/**
	 * retrieves Client Patient Details using Client Patient Number.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOffLineClientPatientDetailsWithClientPatNo(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strClientPatNo = voObj.getStrOffLineClientPatientNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrOffLineBillNumber();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "clientpatno", strClientPatNo);
			daoObj.setProcInValue(nProcIndex, "puk", "0");
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null) {

					voObj.setOfflineClientDetails(ws);

				} else {
					voObj.setOfflineClientDetails(null);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientDetailsWithClientPatNo() --> "
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
	 * retrieves Client Patient Details using Cr Number
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOffLineClientPatientDetailsWithCrNo(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrOffLineBillNumber();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null) {

					voObj.setOfflineClientDetails(ws);

				} else {
					voObj.setOfflineClientDetails(null);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientDetailsWithCrNo() --> "
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
	 * retrieves Off Line Client Patient Details using Cr Number and Hospital
	 * Service
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOffLineClientPatientNumber(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "modeval", "2");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws != null) {

					if (ws.next()) {

						voObj
								.setStrOffLineClientPatientHidden(ws
										.getString(25));

					} else {
						voObj.setStrOffLineClientPatientHidden("");
					}

					ws.beforeFirst();

					voObj.setAdmissionCancellationDetails(ws);

				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientNumber() --> "
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
	 * retrieves Off Line Refund Advance Patient Account Details using Cr Number
	 * and Hospital Service
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getOffLineRefundAdvancePatAccDtls(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId);
			daoObj.setProcInValue(nProcIndex, "modeval", "3");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws != null) {

					voObj.setAdmissionCancellationDetails(ws);

				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientNumber() --> "
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
	 * retrieves Off Line Group Combo
	 * 
	 * @param voObj -
	 *            ValueObject
	 */
	public static void getOffLineGroup(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strIsPackageWise = voObj.getStrOffLineIsPackageGroup();
		String strProcName = "{call pkg_bill_view.proc_HBLT_HSERVICE_GROUP_MST(?,?,?,?,?,?)}";

		int nProcIndex = 0;

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,1);
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeTypeId,2);
			daoObj.setProcInValue(nProcIndex, "pkg_wise_group",strIsPackageWise,3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			if (strErr.equals("")) {
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null) {
					if (strIsPackageWise.equals("0")) {
						voObj.setOfflineGroupList(ws);
					} else {
						voObj.setOfflinePackageGroup(ws);
					}
				}
		} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineGroup() --> "
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
	 * retrieves Off Line Tariff List
	 * 
	 * @param voObj -
	 *            ValueObject
	 */
	public static void getOffLineTariffList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strGroupId = voObj.getStrOffLineGroup();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strCategoryCode = voObj.getStrOffLineTreatmentCategory();
		String strWardCode = voObj.getStrOffLineWard();
		String strPackage = voObj.getStrOffLinePackageIndex();
		
		
		if (strGroupId.equals(""))
			strGroupId = null;
		if (strWardCode.equals(""))
			strWardCode = null;

		if (strPackage == null || strPackage.equals(""))
			strPackage = "0";

		String strErr = "";
		String mode = "1";
		
		strPackage = "2";

		
		if (strChargeTypeId != null && strCategoryCode != null) {
			if ((strWardCode == null || strWardCode.equals(""))
					&& (strGroupId == null || strGroupId.equals(""))) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?)}";

			} else if (strWardCode != null && strGroupId == null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?)}";

			} else if (strWardCode == null && strGroupId != null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?)}";

			} else {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?)}";
			}
		}

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			// System.out.println(" procedure Name :"+strProcName);

			if (strChargeTypeId != null && strCategoryCode != null) {

				daoObj.setProcInValue(nProcIndex, "chargeTypeId",
						strChargeTypeId);
				daoObj.setProcInValue(nProcIndex, "catCode", strCategoryCode);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", strPackage);

				if (strWardCode != null) {

					daoObj.setProcInValue(nProcIndex, "wardCode", strWardCode);

				}

				if (strGroupId != null) {

					daoObj.setProcInValue(nProcIndex, "groupId", strGroupId);

				}

			
				
			daoObj.setProcInValue(nProcIndex, "modeVal", mode);

				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				/*
				 * System.out.println("charge Type Id "+strChargeTypeId);
				 * System.out.println("categoryCode "+strCategoryCode);
				 * System.out.println("group code "+strGroupId);
				 * System.out.println("ward code "+strWardCode);
				 * System.out.println("hospitalCode "+strHospitalCode);
				 * System.out.println("pkgFlag "+strPackage);
				 */

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (ws != null) {

					// System.out.println("ws size : "+ws.size());
					voObj.setOfflineTariffList(ws);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineTariffList() --> "
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
	 * retrieves Off Line Tariff List
	 * 
	 * @param voObj -
	 *            ValueObject
	 */
	public static void getOffLineTariffListByCode(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strGroupId = voObj.getStrOffLineGroup();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strCategoryCode = voObj.getStrOffLineTreatmentCategory();
		String strWardCode = voObj.getStrOffLineWard();
		String strPackage = voObj.getStrOffLinePackageIndex();
		String strTariffCode = voObj.getStrTariffCode();
		
		if (strGroupId.equals(""))
			strGroupId = null;
		if (strWardCode.equals(""))
			strWardCode = null;

		if (strPackage == null || strPackage.equals(""))
			strPackage = "0";

		String strErr = "";
		String mode = "3";
		
		strPackage = "2";

			
		if (strChargeTypeId != null && strCategoryCode != null) {
			if ((strWardCode == null || strWardCode.equals(""))
					&& (strGroupId == null || strGroupId.equals(""))) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?)}";

			} else if (strWardCode != null && strGroupId == null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?)}";

			} else if (strWardCode == null && strGroupId != null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?)}";

			} else {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?)}";
			}
		}

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAObilling");

			nProcIndex = daoObj.setProcedure(strProcName);

			// System.out.println(" procedure Name :"+strProcName);

			if (strChargeTypeId != null && strCategoryCode != null) {

				daoObj.setProcInValue(nProcIndex, "chargeTypeId",
						strChargeTypeId);
				daoObj.setProcInValue(nProcIndex, "catCode", strCategoryCode);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", strPackage);

				if (strWardCode != null) {

					daoObj.setProcInValue(nProcIndex, "wardCode", strWardCode);

				}

				if (strGroupId != null) {

					daoObj.setProcInValue(nProcIndex, "groupId", strGroupId);

				}

			
					daoObj.setProcInValue(nProcIndex, "searchtrfname", strTariffCode);
				
				
			daoObj.setProcInValue(nProcIndex, "modeVal", mode);

				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				/*
				 * System.out.println("charge Type Id "+strChargeTypeId);
				 * System.out.println("categoryCode "+strCategoryCode);
				 * System.out.println("group code "+strGroupId);
				 * System.out.println("ward code "+strWardCode);
				 * System.out.println("hospitalCode "+strHospitalCode);
				 * System.out.println("pkgFlag "+strPackage);
				 */

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (ws != null) {

					// System.out.println("ws size : "+ws.size());
					voObj.setOfflineTariffList(ws);
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineTariffListByCode() --> "
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
	 * retrieves discount approval list
	 * 
	 * @param voObj
	 */
	public static void getOffLineDiscountApprovalList(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_consultant_name(?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineDiscountApprovedBy(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineDiscountApprovalList() --> "
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
	 * retrieves discount remarks list
	 * 
	 * @param voObj
	 */
	public static void getOffLineDiscountRemarksList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hblt_remarks_mst(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "rmkstype", "1");
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode);
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next()) {

					voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineDiscountRemarks(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getOffLineDiscountRemarksList() --> "
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
	public static void getOffLineTariffUnitList(CashCollectionTransVO voObj) {

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

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj
					.getStrOffLineTariffUnitTempId());
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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

	/**
	 * retrieves Bill Details based on Cr Number and Charge Type Id.
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public static void getBillDetails(CashCollectionTransVO voObj) {
		String proc_name = "";
		proc_name = "{call pkg_bill_view.proc_SBLT_OUTBOUND_DTL(?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO.getBillDetails()");

			/*
			 * System.out.println("cr No : "+voObj.getStrCrNo());
			 * System.out.println("charge Type ;
			 * "+voObj.getStrOffLineHospitalService());
			 */

			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "crNo", voObj.getStrCrNo());
			// System.out.println("INgetBillDetails()DAO:::CRNO::"+voObj.getStrCrNo());
			dao.setProcInValue(nprocIndex, "chargeTypeId", voObj
					.getStrOffLineHospitalService());
			// System.out.println("INgetBillDetails()DAO:::ChargeTypeId::"+
			// voObj.getStrOffLineHospitalService());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "err", 1); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "resultset", 2); // 2 for object

			// execute procedure
			dao.executeProcedure(nprocIndex);

			// get value
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				// System.out.println("ws size is-->"+ws.size());
				voObj.setOfflineBillList(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getBillDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * retrieves Tariff Details based on Bill Number.
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public static void getTariffDetails_NoAcc(CashCollectionTransVO voObj) {
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_BILL_SERVICE_DTL(?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO.getTariffDetails_NoAcc()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj
					.getStrOffLineBillNumber());
			// System.out.println("Bill No
			// is:::-->"+voObj.getStrOffLineBillNumber());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineBillTariffList(ws);
			} else {
				voObj.setOfflineBillTariffList(null);
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getTariffDetails_NoAcc() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * retrieves Tariff Details based on Bill Number and Account Number.
	 * 
	 * @param voObj
	 */
	public static void getTariffDetails_Acc(CashCollectionTransVO voObj) {
		WebRowSet ws = null;

		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO .getTariffDetails_Acc()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj
					.getStrOffLineBillNumber());
			dao.setProcInValue(nprocIndex, "accNo ", voObj
					.getStrOffLineAccountNo());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineBillTariffList(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getTariffDetails_Acc() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * retrieves Without Cr. No. Bill Tariff Details
	 * 
	 * @param voObj
	 */
	public static void getWithoutCrNoBillTariffDetails(
			CashCollectionTransVO voObj) {

		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_BILL_SERVICE_DTL(?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO .getWithoutCrNoBillTariffDetails()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj
					.getStrOffLineBillNumber());
			dao.setProcInValue(nprocIndex, "modeval", "2");
			dao.setProcInValue(nprocIndex, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineBillTariffList(ws);
			} else {
				voObj.setOfflineBillTariffList(null);
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getWithoutCrNoBillTariffDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getRequestNoList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_type", "5");
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

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
	
	
	public static void getGenderList(CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.proc_gender_dtl(?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode(),1);
		
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,3);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setWsGenderList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getGenderList() --> "
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
	 * retrieves Guarantor Details
	 * 
	 * @param voObj
	 */
	public static void getGuarantorDetails(CashCollectionTransVO voObj) {

		String strGuarantorDtls = "";
		String strFunc = "";
		strFunc = "{? = call BILL_MST.getGuarentorDtl(?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO.getGuarantorDetails()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrOffLineBillNumber());
			dao.setFuncInValue(nfuncIndex, 3, voObj.getStrHospitalCode());
			dao.setFuncOutValue(nfuncIndex, 1);

			dao.executeFunction(nfuncIndex);

			strGuarantorDtls = dao.getFuncString(nfuncIndex);

			voObj.setStrGuarantorHiddenVal(strGuarantorDtls);

		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getGuarantorDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static void getWithoutCrNoTariffDetails(CashCollectionTransVO voObj) {
		WebRowSet ws = null;

		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO .getTariffDetails_Acc()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj
					.getStrOffLineBillNumber());
			dao.setProcInValue(nprocIndex, "accNo ", voObj
					.getStrOffLineAccountNo());
			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcOutValue(nprocIndex, "ERR", 1); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineBillTariffList(ws);
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			voObj
					.setStrMsgString("CashCollectionTransDAO.getWithoutCrNoTariffDetails() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	
	/**
	 * retrieves Bill Listing Details from Out Bound Table
	 * 
	 * @param voObj
	 */
	public static void getPreviousCrNoDetails(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
	 

		String strErr = "";

		String strProcName = "{call pkg_bill_view.proc_prev_patient_dtl(?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Cash Collection Trans ",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
 
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());

			daoObj.setProcInValue(nProcIndex, "prevCR", voObj.getStrPreviousCrNo());
			
			daoObj.setProcOutValue(nProcIndex, "ERR", 1);

			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "ERR");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				WebRowSet ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				
				if(ws != null && ws.next()){
					
					voObj.setStrPreviousCrNoPatientDtls(ws.getString(1));
					
				}else{
					voObj.setStrPreviousCrNoPatientDtls("");
				}
				

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.getPreviousCrNoDetails() --> "
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
	 * retrieves Bill Listing Details from Out Bound Table
	 * 
	 * @param voObj
	 */
	public static void getBillListingDtl_from_OutBound(
			CashCollectionTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strSearchString = voObj.getStrBillSearchString();

		String strFromRows = voObj.getStrBillFromRow();
		String strToRows = voObj.getStrBillToRow();
		String strModeType = "5";

		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.Proc_Sblt_Outbound_Dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Cash Collection Trans ",
					"CashCollectionTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", strModeType);

			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString);

			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows);

			daoObj.setProcInValue(nProcIndex, "toRows", strToRows);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospitalCode());

			daoObj.setProcOutValue(nProcIndex, "ERR", 1);

			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "ERR");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setBillSearchList(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("CashCollectionTransDAO.setPatientListingDtl_from_OutBound() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// Insert Methods

	public static void insertOnlineReceiptServices(CashCollectionTransVO voObj) {

		String strBillNo = "";

		int nBillFlag = 0;

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

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

			if (voObj.getStrChargeTypeId().equals("2")) {

				pKey.setStrKeyname("BILL_IPD");

			} else {

				pKey.setStrKeyname("BILL");
			}
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Bill(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");

			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());

			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo());
			dao.setProcInValue(nInsertedIndex1, "reqDate", voObj
					.getStrRequestDate());
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", voObj
					.getStrGlobalRequestNo());
						
			dao.setProcInValue(nInsertedIndex1, "serviceId", voObj
					.getStrService());

			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj
					.getStrAccountNo());
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo());
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj
					.getStrAdmissionNo());
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj
					.getStrEpisode());
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOnlineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj
					.getStrOnlineMaxClientBenefitAmount());
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj
					.getStrOnlinePatNetPayAmount());
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrTotalTariffActualAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrTotalTariffDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrTotalTariffServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrRaisingDepartment());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrChargeTypeId());
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrWard());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrBillingService());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj
					.getStrClientPatientNo());

			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj
					.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Bill_Service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrTariffDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffDetailsId().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj.getStrTariffDetailsId()[i]
							.replace('^', '#').split("#");

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
					// String strTempPenelty = strTariffDtlsVal[16];
					// String strTempReceiptNo = strTariffDtlsVal[17];
					String strTempApprovalDate = strTariffDtlsVal[19];
					String strTempApprovalBy = strTariffDtlsVal[20];
					String strTempReason = strTariffDtlsVal[23];
					String strTempService = strTariffDtlsVal[24];

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());

					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj
							.getStrRequestNo());
					dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj
							.getStrGlobalRequestNo());

					dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj
							.getStrAccountNo());
					dao.setProcInValue(nInsertedIndex2, "puk", voObj
							.getStrCrNo());
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj
							.getStrTariffBilledQty()[i]);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj
							.getStrBillTariffUnit()[i].replace("^", "#").split(
							"#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate",
							strTempTariffRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",
							strTempRateUnitId);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrTariffServiceTaxAmt()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrTariffNetAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrTariffDiscountAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "appId",
							strTempApprovalId);

					dao.setProcInValue(nInsertedIndex2, "disUnit",
							strTempDiscountUnit);
					dao.setProcInValue(nInsertedIndex2, "disType",
							strTempDiscountType);
					dao.setProcInValue(nInsertedIndex2, "disBy",
							strTempApprovalBy);
					dao.setProcInValue(nInsertedIndex2, "disReason",
							strTempReason);
					dao.setProcInValue(nInsertedIndex2, "disDate",
							strTempApprovalDate);

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrChargeTypeId());
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj
							.getStrWard());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempService);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGblTrariffId);
					dao.setProcInValue(nInsertedIndex2, "isRefund", "");
					dao.setProcInValue(nInsertedIndex2, "isPackage",
							strTempIsPackage);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);
					dao.setProcInValue(nInsertedIndex2, "creditBillFlag",voObj.getStrCreditBillStatus()[i]);;
					dao.setProcInValue(nInsertedIndex2, "clNo",voObj.getStrCreditLetterNo()[i]);
					dao.setProcInValue(nInsertedIndex2, "clDate",voObj.getStrCreditLetterDate()[i]);
					dao.setProcInValue(nInsertedIndex2, "clPath",voObj.getStrCreditFilePath()[i]);
					dao.setProcInValue(nInsertedIndex2, "creditClientNo",voObj.getStrCreditClientNo()[i]);
					dao.setProcInValue(nInsertedIndex2, "creditBillstatus",voObj.getStrCreditBillStatus()[i]);
					dao.setProcInValue(nInsertedIndex2, "creditAmtPat",voObj.getStrPaidByPat()[i]);
					dao.setProcInValue(nInsertedIndex2, "creditAmtClient",voObj.getStrPaidByClient()[i]);
					dao.setProcInValue(nInsertedIndex2, "counterId", strCounterId);

					dao.execute(nInsertedIndex2, 1);

				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				}

				else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
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
					.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
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
							.setStrMsgString("CashCollectionTransDAO.insertOnlineReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	public static void insertOnlineRefundServices(CashCollectionTransVO voObj) {

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_online_refund(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());

			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo());
			dao.setProcInValue(nInsertedIndex1, "refRecNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj
					.getStrOnlineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrTotalTariffActualAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrTotalTariffDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrTotalTariffServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj
					.getStrTotalTariffPenaltyAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj
					.getStrClientPatientNo());
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj
					.getStrClientBalance());

			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj
					.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.dml_online_refund_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrTariffRefundDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffRefundDetailsId().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj
							.getStrTariffRefundDetailsId()[i].replace('^', '#')
							.split("#");

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

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());
					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj
							.getStrRequestNo());
					dao.setProcInValue(nInsertedIndex2, "billNo", voObj
							.getStrBillNo());

					dao.setProcInValue(nInsertedIndex2, "trfRecNo",
							strTempReceiptNo);
					dao.setProcInValue(nInsertedIndex2, "refRecNo",
							strRefundReceiptNo);
					dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj
							.getStrAccountNo());
					dao.setProcInValue(nInsertedIndex2, "puk", voObj
							.getStrCrNo());

					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "refQty", voObj
							.getStrTariffRefundQty()[i]);
					dao.setProcInValue(nInsertedIndex2, "refQtyUnitId", voObj
							.getStrTariffRefundUnit()[i].replace("^", "#")
							.split("#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate",
							strTempTariffRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",
							strTempRateUnitId);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrTariffServiceTaxAmt()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrTariffRefundCost()[i]);

					dao.setProcInValue(nInsertedIndex2, "penelty",
							strTempPenelty);
					dao.setProcInValue(nInsertedIndex2, "penAmt", voObj
							.getStrTariffPenaltyAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrTariffDiscountAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAppId",
							strTempApprovalId);

					dao.setProcInValue(nInsertedIndex2, "disUnit",
							strTempDiscountUnit);
					dao.setProcInValue(nInsertedIndex2, "disType",
							strTempDiscountType);

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrChargeTypeId());
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj
							.getStrWard());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId", voObj
							.getStrService());
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGblTrariffId);
					dao.setProcInValue(nInsertedIndex2, "isPackage",
							strTempIsPackage);

					dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj
							.getStrGlobalRequestNo());

					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);

				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());

				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("6")) {

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

	public static void insertOnlineRefundAdvance(CashCollectionTransVO voObj) {

		int nInsertedIndex1 = 0;

		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_online_pataccount_close(?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());

			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo());
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj
					.getStrOnlineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "penelty", voObj
					.getStrRefundAdvancePaneltyAmt());
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj
					.getStrTotalTariffPenaltyAmount());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			// Payment Details.
			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());
				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[i].equals("2")
						|| voObj.getStrOnlinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("4")
						|| voObj.getStrOnlinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("6")) {

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

	public static void insertOnlineFinalAdjustment(CashCollectionTransVO voObj) {
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
			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Finalsettlement(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());

			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo());

			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo);

			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());
			dao.setProcInValue(nInsertedIndex1, "expenseAmt", voObj
					.getStrExpenseAmount());
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj
					.getStrOnlineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj
					.getStrNetClientAmount());

			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrNetDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrNetServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "clientNo", voObj
					.getStrClientPatientNo());
			dao.setProcInValue(nInsertedIndex1, "clientSancAmt", voObj
					.getStrSancAmount());
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj
					.getStrClientBalance());
			dao.setProcInValue(nInsertedIndex1, "disAppId", voObj
					.getStrApprovalId());
			dao.setProcInValue(nInsertedIndex1, "disType", voObj
					.getStrDiscountType());
			dao.setProcInValue(nInsertedIndex1, "disUnit", voObj
					.getStrDiscountUnit());
			dao.setProcInValue(nInsertedIndex1, "serTax", voObj
					.getStrServiceTax());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
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

	public static void insertOnlineReconcillation(CashCollectionTransVO voObj) {

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");

			paymentDao = new PaymentDAO();

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Online_Reconciliation(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo());
			dao.setProcInValue(nInsertedIndex1, "reqDate", voObj
					.getStrRequestDate());
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", voObj
					.getStrGlobalRequestNo());
			dao.setProcInValue(nInsertedIndex1, "serviceId", voObj
					.getStrService());
			dao.setProcInValue(nInsertedIndex1, "billNo", voObj.getStrBillNo());
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj
					.getStrAccountNo());
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo());
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj
					.getStrAdmissionNo());
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj
					.getStrEpisode());
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOnlineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj
					.getStrOnlineMaxClientBenefitAmount());
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj
					.getStrOnlinePatNetPayAmount());
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrTotalTariffActualAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrTotalTariffDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrTotalTariffServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrRaisingDepartment());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrChargeTypeId());
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrWard());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrBillingService());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj
					.getStrClientPatientNo());
			dao.setProcInValue(nInsertedIndex1, "clientSancAmt", voObj
					.getStrSancAmount());
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj
					.getStrClientBalance());
			dao.setProcInValue(nInsertedIndex1, "appNo", voObj
					.getStrApprovalId());
			dao.setProcInValue(nInsertedIndex1, "appBy", voObj
					.getStrApprovedBy());
			dao.setProcInValue(nInsertedIndex1, "appDate", voObj
					.getStrApprovedDate());
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj
					.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());

			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

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

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());
					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj
							.getStrRequestNo());
					dao.setProcInValue(nInsertedIndex2, "gblReqNo", voObj
							.getStrGlobalRequestNo());

					dao.setProcInValue(nInsertedIndex2, "billNo", voObj
							.getStrBillNo());

					dao.setProcInValue(nInsertedIndex2, "recNo",
							strRefundReceiptNo);

					dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj
							.getStrAccountNo());
					dao.setProcInValue(nInsertedIndex2, "puk", voObj
							.getStrCrNo());

					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "reconcileQty",
							strTempReqQty);
					dao.setProcInValue(nInsertedIndex2, "reconcileQtyUnitId",
							strTempQtyUnitId);
					dao.setProcInValue(nInsertedIndex2, "rate",
							strTempTariffRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",
							strTempRateUnitId);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrTariffServiceTaxAmt()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrTariffNetAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrTariffDiscountAmt()[i]);

					dao.setProcInValue(nInsertedIndex2, "appId",
							strTempApprovalId);

					dao.setProcInValue(nInsertedIndex2, "disUnit",
							strTempDiscountUnit);
					dao.setProcInValue(nInsertedIndex2, "disType",
							strTempDiscountType);

					dao.setProcInValue(nInsertedIndex2, "disBy",
							strTempApprovalBy);
					dao.setProcInValue(nInsertedIndex2, "disReason",
							strTempReason);
					dao.setProcInValue(nInsertedIndex2, "disDate",
							strTempApprovalDate);

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrChargeTypeId());
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj
							.getStrWard());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId", voObj
							.getStrService());
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGblTrariffId);
					dao.setProcInValue(nInsertedIndex2, "isPackage",
							strTempIsPackage);

					dao.setProcInValue(nInsertedIndex2, "isRefund", "0"); // must
					// be
					// change

					dao.setProcInValue(nInsertedIndex2, "refRecNo",
							strRefReceiptNo);

					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);

				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());

				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[j]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[j].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[j].equals("2")
						|| voObj.getStrOnlinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("4")
						|| voObj.getStrOnlinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[j].equals("6")) {

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
	public static void insertOnlineAdvance(CashCollectionTransVO voObj) {

		int nAccFlag = 0;
		int nBillFlag = 0;

		boolean fClientFlag = false;

		String strAccountNo = "0";
		String strBillNo = "0";

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

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
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

			// Get Counter Id
			getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			// Open Account.
			strAccountNo = voObj.getStrAccountNo();

			if (voObj.getStrAccountNo() != null
					&& voObj.getStrAccountNo().length() <= 1) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAccountNo = pKey.getStrPrimrayKeyValue();

				nAccFlag = 1;

			}

			if (voObj.getStrClientPatientNo().length() > 1) {

				fClientFlag = true;
			}

			patAccDao.setStrPatAccNo(strAccountNo);
			patAccDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			patAccDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());

			if (fClientFlag) {
				patAccDao.setStrClientPatientNo(voObj.getStrClientPatientNo());
				patAccDao.setStrSancAmt(voObj.getStrSancAmount());
				patAccDao.setStrClientBalance(voObj.getStrClientBalance());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}

			patAccDao.setStrAdmNo(voObj.getStrAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrEpisode());
			patAccDao.setStrCatCode(voObj.getStrTreatmentCategory());

			patAccDao.setStrPatRecdAmt(voObj.getStrOnlineTotalRecAmount());
			patAccDao.setStrPatAccountStatus("1");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrIsValid("1");
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());

			patAccDao.insert(dao);

			if (fClientFlag) {

				clientPatDao.setStrClientPatNo(voObj.getStrClientPatientNo());
				clientPatDao.insert(dao);
			}

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			billDao.setStrBillNo(strBillNo);
			billDao.setStrPatAccNo(strAccountNo);
			if (fClientFlag) {

				billDao.setStrClientPatNo(voObj.getStrClientPatientNo());
				billDao.setStrSancAmt(voObj.getStrSancAmount());
				billDao.setStrClientBalance(voObj.getStrClientBalance());
			}
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
			if (fClientFlag) {

				billReceiptDao.setStrClientPatNo(voObj.getStrClientPatientNo());

				billReceiptDao.setStrClientBalance(voObj.getStrClientBalance());
			}

			billReceiptDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
			billReceiptDao.setStrBServiceId(voObj.getStrBillingService());
			billReceiptDao.setStrDeptCode(voObj.getStrRaisingDepartment());
			billReceiptDao
					.setStrPatientCatCode(voObj.getStrTreatmentCategory());
			billReceiptDao
					.setStrPatientTAmt(voObj.getStrOnlineTotalRecAmount());

			billReceiptDao.setStrCounterId(strCounterId);
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
			billReceiptDao.setStrIpdChargeTypeId(voObj.getStrIpdChargeTypeId());
			billReceiptDao.setStrIsOnline("1");
			billReceiptDao.setStrIsBill("1");
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

			patAccSerDao.insert(dao);

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

			outBoundDao.insert(dao);

			// Payment Details.
			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOnlinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);
				paymentDao
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[i].equals("2")
						|| voObj.getStrOnlinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("4")
						|| voObj.getStrOnlinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("6")) {

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
				paymentDao.setStrCounterId(strCounterId);
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
			 * paymentDao.setStrBillNo(voObj.getStrBillNo());
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
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOnlineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			// In-Bound Details
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
					.setStrMsgString("CashCollectionTransDAO.insertOnlineAdvance()--> "
							+ err);
			voObj.setStrMsgType("1");

			if (nAccFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());

					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlineAdvance()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("BILL_IPD");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode()); 
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlineAdvance()--> "
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
			if (clientPatDao != null)
				clientPatDao = null;
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
	 * Inserts Online Part Payment Details
	 * 
	 * @param voObj
	 */
	public static void insertOnlinePartPayment(CashCollectionTransVO voObj) {

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

				patAccDao.insert(dao);

			} else {
				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrPatRecdAmt(voObj.getStrOnlineTotalRecAmount());
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());

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
						.setStrPaymentMode(voObj.getStrOnlinePaymentMode()[i]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrChargeTypeId());
				paymentDao.setStrBServiceId(voObj.getStrBillingService());

				String payDtl[] = voObj.getStrOnlinePaymentDtls()[i].replace(
						",", "#").split("#");

				if (voObj.getStrOnlinePaymentMode()[i].equals("2")
						|| voObj.getStrOnlinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("4")
						|| voObj.getStrOnlinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);

				} else if (voObj.getStrOnlinePaymentMode()[i].equals("6")) {

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
	 * Inserts Off-line Advance Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflineAdvance(CashCollectionTransVO voObj) {

		int nAccFlag = 0;
		int nBillFlag = 0;
		int nAppFlag = 0;

		boolean fClientFlag = false;

		String strAccountNo = "0";
		String strBillNo = "0";
		String strAppId = "0";

		String counterId = "0";

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
		ApprovalDAO approvalDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
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
			approvalDao = new ApprovalDAO();

			HisUtil hisUtil = new HisUtil("Bill Transaction",
					"CashCollectionTransDAO");

			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			String strTemp = voObj.getStrOffLineEpisode().replace("^", "#")
					.split("#")[0];

			voObj.setStrOffLineEpisode(strTemp);

			// Counter Id Generation.

			CashCollectionTransDAO.getCounterId(voObj);

			counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open or Retive Existing Account.
			strAccountNo = voObj.getStrOffLineAccountNo();

			if (strAccountNo == null || strAccountNo.equals("0")) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAccountNo = pKey.getStrPrimrayKeyValue();

				nAccFlag = 1;

			}

			if (voObj.getStrClientPatientNo().equals(""))
				voObj.setStrClientPatientNo("0");

			if (!voObj.getStrClientPatientNo().equals("0")) {
				fClientFlag = true;
			}

			patAccDao.setStrPatAccNo(strAccountNo);
			patAccDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());

			if (fClientFlag) {
				patAccDao.setStrClientPatientNo(voObj
						.getStrOffLineClientPatientNo());
				patAccDao.setStrSancAmt(voObj.getStrOffLineSancAmount());
				patAccDao.setStrClientBalance(voObj
						.getStrOffLineBalanceAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}

			patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());

			patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
			patAccDao.setStrPatAccountStatus("1");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			patAccDao.setStrIsValid("1");

			patAccDao.insert(dao);

			if (fClientFlag) {

				clientPatDao.setStrClientPatNo(voObj
						.getStrOffLineClientPatientNo());

				clientPatDao.insert(dao);
			}

			// Bill Generation.

			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			billDao.setStrBillNo(strBillNo);
			billDao.setStrPatAccNo(strAccountNo);
			if (fClientFlag) {

				billDao.setStrClientPatNo(voObj.getStrOffLineClientPatientNo());
				billDao.setStrSancAmt(voObj.getStrOffLineSancAmount());
				billDao.setStrClientBalance(voObj.getStrOffLineBalanceAmount());
			}
			billDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			billDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			billDao
					.setStrPatientCatCode(voObj
							.getStrOffLineTreatmentCategory());
			billDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			billDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			billDao.setStrPuk(voObj.getStrCrNo());

			billDao.setStrRemarks(voObj.getStrOffLineRemarks());
			billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());

			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrOffLineWard());
			billDao.setStrIpdChargeTypeId(voObj.getStrOffLineIpdChargeTypeId());
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrOffLineRequestType());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);
			if (fClientFlag) {

				billReceiptDao.setStrClientPatNo(voObj
						.getStrOffLineClientPatientNo());

				billReceiptDao.setStrClientBalance(voObj
						.getStrOffLineBalanceAmount());
			}

			billReceiptDao.setStrChargeTypeId(voObj
					.getStrOffLineHospitalService());
			billReceiptDao
					.setStrBServiceId(voObj.getStrOffLineBillingService());
			billReceiptDao.setStrDeptCode(voObj
					.getStrOffLineRaisingDepartment());
			billReceiptDao.setStrPatientCatCode(voObj
					.getStrOffLineTreatmentCategory());
			billReceiptDao.setStrPatientTAmt(voObj
					.getStrOfflineTotalRecAmount());

			billReceiptDao.setStrCounterId(counterId);

			if (voObj.getStrChk_value().equals("1")) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("APPROVAL");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAppId = pKey.getStrPrimrayKeyValue();

				nAppFlag = 1;

				billReceiptDao.setStrApprovalId(strAppId);
				billReceiptDao
						.setStrApprovedBy(voObj.getStrOffLineApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrCurrentDate());
				billReceiptDao.setStrRemarks(voObj.getStrOffLineRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrOffLineWard());
			billReceiptDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			billReceiptDao.setStrIsOnline("0");
			billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billReceiptDao.insert(dao);

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj
					.getStrOffLineHospitalService());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			patAccSerDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			// patAccSerDao.setStrTariffRate(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
			patAccSerDao.setStrTariffRate(voObj.getStrOfflineTotalRecAmount());
			patAccSerDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
			patAccSerDao.setStrBillQty("1");
			patAccSerDao.setStrProcessedQty("0");
			patAccSerDao.setStrRemainedQty("1");
			patAccSerDao.setStrPuk(voObj.getStrCrNo());
			patAccSerDao.setStrRemarks(voObj.getStrOffLineRemarks());
			patAccSerDao.setStrSeatId(voObj.getStrSeatId());
			patAccSerDao.setStrIsValid("1");
			patAccSerDao.setStrIsRefundable("0");
			patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBillFlag("1");
			patAccSerDao.setStrReceiptNo("1");
			patAccSerDao.setStrWardCode(voObj.getStrOffLineWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalRecAmount());
			patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());

			patAccSerDao.insert(dao);

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(strAccountNo);
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			outBoundDao.setStrPatientCatCode(voObj
					.getStrOffLineTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOfflineTotalRecAmount());
			outBoundDao
					.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			outBoundDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			outBoundDao.setStrCounterId(counterId);
			outBoundDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrOffLineRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrOffLineWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("0");
			outBoundDao.setStrHospitalCode(voObj.getStrHospitalCode());
			outBoundDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());

			outBoundDao.insert(dao);

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].equals("2")
						|| voObj.getStrOfflinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("4")
						|| voObj.getStrOfflinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(counterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrOffLineClientPatientNo().length() > 1 &&
			 * !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService());
			 * paymentDao
			 * .setStrPaymentDetails(voObj.getStrOfflineClientName());
			 * paymentDao.setStrPaymentModeNo(voObj
			 * .getStrOffLineClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("1");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOfflineMaxClientBenefitAmount());
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(counterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			// Approval Details
			if (voObj.getStrChk_value().equals("1")) {

				approvalDao.setStrApprovalId(strAppId);
				approvalDao.setStrApprovalSlNo("1");
				approvalDao.setStrReceiptType("1");
				approvalDao.setStrBServiceId(voObj
						.getStrOffLineBillingService());
				approvalDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				approvalDao.setStrEmpNo(voObj.getStrApprovedByCombo());
				approvalDao.setStrUserLevel(voObj.getStrUserLevel());
				approvalDao.setStrRemarks(voObj.getStrRemarksCombo2());
				approvalDao.setStrApprovalType("5");
				approvalDao.setStrStatus("1");
				approvalDao.setStrSeatId(voObj.getStrSeatId());
				approvalDao.setStrIsValid("1");
				approvalDao.setStrHospitalCode(voObj.getStrHospitalCode());

				approvalDao.insert(dao);

			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");
			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance() --> BILL_IPD -->"
							+ err);

			if (nAccFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1) {

				voObj.setStrBillNo("0");

				try {

					pKeyLogDao.setStrKeyname("BILL_IPD");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> "
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
			if (clientPatDao != null)
				clientPatDao = null;
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
			if (approvalDao != null)
				approvalDao = null;

		}
	}

	/**
	 * Inserts Off-line Part Payment Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflinePartPayment(CashCollectionTransVO voObj) {

		int nAccFlag = 0;
		int nBillFlag = 0;
		int nAppFlag = 0;

		String strAccountNo = "0";
		String strBillNo = "0";
		String strAppId = "0";

		String counterId = "0";

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
		ApprovalDAO approvalDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
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
			approvalDao = new ApprovalDAO();

			HisUtil hisUtil = new HisUtil("Bill Transaction",
					"CashCollectionTransDAO");

			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			// Get Counter Id.
			getCounterId(voObj);

			counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open Account
			strAccountNo = voObj.getStrOffLineAccountNo();

			if (strAccountNo == null || strAccountNo.equals("")) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAccountNo = pKey.getStrPrimrayKeyValue();

				nAccFlag = 1;

			}

			if (nAccFlag == 1) {
				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				patAccDao
						.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
				patAccDao.setStrPuk(voObj.getStrCrNo());

				patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
				patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
				patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());

				patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrPatAccountStatus("2");
				patAccDao.setStrSeatId(voObj.getStrSeatId());
				patAccDao.setStrIsValid("1");
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());

				patAccDao.insert(dao);

			} else {
				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());

				patAccDao.update4(dao);
			}

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("BILL_IPD");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			billDao.setStrBillNo(strBillNo);
			billDao.setStrPatAccNo(strAccountNo);

			billDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			billDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			billDao
					.setStrPatientCatCode(voObj
							.getStrOffLineTreatmentCategory());
			billDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			billDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			billDao.setStrPuk(voObj.getStrCrNo());

			billDao.setStrRemarks(voObj.getStrOffLineRemarks());
			billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrOffLineWard());
			billDao.setStrIpdChargeTypeId(voObj.getStrOffLineIpdChargeTypeId());
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrOffLineRequestType());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);

			billReceiptDao.setStrChargeTypeId(voObj
					.getStrOffLineHospitalService());
			billReceiptDao
					.setStrBServiceId(voObj.getStrOffLineBillingService());
			billReceiptDao.setStrDeptCode(voObj
					.getStrOffLineRaisingDepartment());
			billReceiptDao.setStrPatientCatCode(voObj
					.getStrOffLineTreatmentCategory());
			billReceiptDao.setStrPatientTAmt(voObj
					.getStrOfflineTotalRecAmount());

			billReceiptDao.setStrCounterId(counterId);

			if (voObj.getStrChk_value().equals("1")) {

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("APPROVAL");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAppId = pKey.getStrPrimrayKeyValue();

				nAppFlag = 1;

				billReceiptDao.setStrApprovalId(strAppId);
				billReceiptDao
						.setStrApprovedBy(voObj.getStrOffLineApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrCurrentDate());
				billReceiptDao.setStrRemarks(voObj.getStrOffLineRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrOffLineWard());
			billReceiptDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			billReceiptDao.setStrIsOnline("0");
			billReceiptDao.setStrIsBill("0");
			billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());

			billReceiptDao.insert(dao);

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj
					.getStrOffLineHospitalService());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			// patAccSerDao.setStrTariffRate(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLinePartPaymentAmount())));
			patAccSerDao.setStrTariffRate(voObj.getStrOfflineTotalRecAmount());
			patAccSerDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
			patAccSerDao.setStrBillQty("1");
			patAccSerDao.setStrProcessedQty("0");
			patAccSerDao.setStrRemainedQty("1");
			patAccSerDao.setStrPuk(voObj.getStrCrNo());
			patAccSerDao.setStrRemarks(voObj.getStrOffLineRemarks());
			patAccSerDao.setStrSeatId(voObj.getStrSeatId());
			patAccSerDao.setStrIsValid("1");
			patAccSerDao.setStrIsRefundable("0");
			patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBillFlag("1");
			patAccSerDao.setStrReceiptNo("1");
			patAccSerDao.setStrWardCode(voObj.getStrOffLineWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLinePartPaymentAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalRecAmount());
			patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());

			patAccSerDao.insert(dao);

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(voObj.getStrOffLineAccountNo());
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			outBoundDao.setStrPatientCatCode(voObj
					.getStrOffLineTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOfflineTotalRecAmount());
			outBoundDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			outBoundDao
					.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			outBoundDao.setStrIpdChargeTypeId(voObj
					.getStrOffLineIpdChargeTypeId());
			outBoundDao.setStrCounterId(counterId);
			outBoundDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrOffLineRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrOffLineWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("0");
			outBoundDao.setStrHospitalCode(voObj.getStrHospitalCode());
			outBoundDao.insert(dao);

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].equals("2")
						|| voObj.getStrOfflinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("4")
						|| voObj.getStrOfflinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(counterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrOffLineClientPatientNo().length() > 1 &&
			 * !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService());
			 * paymentDao
			 * .setStrPaymentDetails(voObj.getStrOfflineClientName());
			 * paymentDao.setStrPaymentModeNo(voObj
			 * .getStrOffLineClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("1");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOfflineMaxClientBenefitAmount());
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(counterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			if (voObj.getStrChk_value().equals("1")) {

				approvalDao.setStrApprovalId(strAppId);
				approvalDao.setStrApprovalSlNo("1");
				approvalDao.setStrReceiptType("1");
				approvalDao.setStrBServiceId(voObj
						.getStrOffLineBillingService());
				approvalDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				approvalDao.setStrEmpNo(voObj.getStrApprovedByCombo());
				approvalDao.setStrUserLevel(voObj.getStrUserLevel());
				approvalDao.setStrRemarks(voObj.getStrRemarksCombo2());
				approvalDao.setStrApprovalType("4");
				approvalDao.setStrStatus("1");
				approvalDao.setStrSeatId(voObj.getStrSeatId());
				approvalDao.setStrIsValid("1");
				approvalDao.setStrHospitalCode(voObj.getStrHospitalCode());

				approvalDao.insert(dao);

			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> "
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
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1) {

				voObj.setStrBillNo("0");

				try {
					pKeyLogDao.setStrKeyname("BILL_IPD");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> "
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
			if (clientPatDao != null)
				clientPatDao = null;
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
			if (approvalDao != null)
				approvalDao = null;

		}

	}

	/**
	 * Inserts Off-line Receipt Services Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflineReceiptServices(CashCollectionTransVO voObj) {

		int nBillFlag = 0;
		int nAppFlag = 0;

		String strBillNo = "0";
		String strDiscAppId = "0";

		 		
		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			paymentDao = new PaymentDAO();

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			if (voObj.getStrOffLineHospitalService().equals("2")) {
				pKey.setStrKeyname("BILL_IPD");
			} else {
				pKey.setStrKeyname("BILL");
			}

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_bill(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");

			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj
					.getStrOffLineAccountNo());
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo());
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj
					.getStrOffLineAdmissionNo());
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj
					.getStrOffLineEpisode());
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrOffLineTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOfflineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj
					.getStrOfflineMaxClientBenefitAmount());
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj
					.getStrOfflinePatNetPayAmount());
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrOfflineTotalActualTariffAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrOfflineTotalDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrOfflineTotalServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrOffLineRaisingDepartment());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService());
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj
					.getStrOffLineWard());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj
					.getStrOffLineClientPatientNo());

			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj
					.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "moduleId", voObj
					.getStrModuleId());
			dao.setProcInValue(nInsertedIndex1, "ipAddr", voObj
					.getStrIpAddress());

			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_bill_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrOfflineTariffDetailsHidden() != null){
							
				for (int i = 0, len = voObj.getStrOfflineTariffDetailsHidden().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj
							.getStrOfflineTariffDetailsHidden()[i].replace('^',
							'#').split("#");

				 
					
					String strTempTariffId = strTariffDtlsVal[0];
					String strTempGroupId = strTariffDtlsVal[1];
					// String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRate = strTariffDtlsVal[4];
					String strUnit = strTariffDtlsVal[5];
					// String strTempBaseUnitVal = strTariffDtlsVal[6];
					String strTempIsPackage = strTariffDtlsVal[7];
					// String strTempIsAdvance = strTariffDtlsVal[8];
					String strTempIsRefundable = strTariffDtlsVal[9];
					// String strTempDefaultRate = strTariffDtlsVal[10];
					String strTempTariffActualRate = strTariffDtlsVal[11];
					// String strTempMaxDiscount = strTariffDtlsVal[12];
					String strTempServiceTax = strTariffDtlsVal[13];
					String strTempServiceId = strTariffDtlsVal[15];
					String strTempGTariffId = strTariffDtlsVal[16];

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());
					dao.setProcInValue(nInsertedIndex2, "recNo", "1");
					dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj
							.getStrOffLineAccountNo());
					dao.setProcInValue(nInsertedIndex2, "puk", voObj
							.getStrCrNo());
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrOffLineTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrOffLineRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj
							.getStrOfflineTariffQty()[i]);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj
							.getStrOfflineTariffUnit()[i].replace("^", "#")
							.split("#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strUnit);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrOfflineTariffServiceTaxAmtVal()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrOfflineTariffNetAmount()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrOfflineTariffDiscountAmtVal()[i]);

					if (voObj.getStrOfflineTariffDiscountConfigDetails() != null
							&& !voObj.getStrOfflineTariffDiscount()[i]
									.equals("0")) {

						String[] strDiscountDtlsValue = voObj
								.getStrOfflineTariffDiscountConfigDetails()[i]
								.replace(',', '#').split("#");

						String strTempDiscUnit = strDiscountDtlsValue[0];
						String strTempDiscType = strDiscountDtlsValue[1];
						String strTempDiscBy = strDiscountDtlsValue[2];
						String strTempDiscReason = strDiscountDtlsValue[4];
						String strTempDiscDate = strDiscountDtlsValue[5];

						if (!voObj.getStrOfflineTariffDiscount()[i].equals("0")) {
							pKey.setStrKeyname("APPROVAL");
							pKey.setStrBlockkey("1");
							pKey.setStrHospCode(voObj.getStrHospitalCode());
							pKey.select(dao);

							strDiscAppId = pKey.getStrPrimrayKeyValue();

							if (!strDiscAppId.equals("")
									|| strDiscAppId != null) {
								nAppFlag = 1;
							}

							dao.setProcInValue(nInsertedIndex2, "appId",
									strDiscAppId);
						} else {
							dao.setProcInValue(nInsertedIndex2, "appId", "");
						}
						dao.setProcInValue(nInsertedIndex2, "disUnit",
								strTempDiscUnit);
						dao.setProcInValue(nInsertedIndex2, "disType",
								strTempDiscType);
						dao.setProcInValue(nInsertedIndex2, "disBy",
								strTempDiscBy);
						dao.setProcInValue(nInsertedIndex2, "disReason",
								strTempDiscReason);
						dao.setProcInValue(nInsertedIndex2, "disDate",
								strTempDiscDate);

					} else {

						dao.setProcInValue(nInsertedIndex2, "appId", "0");
						dao.setProcInValue(nInsertedIndex2, "disUnit", "0");
						dao.setProcInValue(nInsertedIndex2, "disType", "");
						dao.setProcInValue(nInsertedIndex2, "disBy", "");
						dao.setProcInValue(nInsertedIndex2, "disReason", "");
						dao.setProcInValue(nInsertedIndex2, "disDate", "");
					}

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrOffLineHospitalService());
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj
							.getStrOffLineWard());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrOffLineBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempServiceId);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGTariffId);
					dao.setProcInValue(nInsertedIndex2, "isRefund",
							strTempIsRefundable);
					dao.setProcInValue(nInsertedIndex2, "isPackage",
							strTempIsPackage);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);

				}

			}
				
			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].equals("2")
						|| voObj.getStrOfflinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("4")
						|| voObj.getStrOfflinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrOffLineClientPatientNo().length() > 1 &&
			 * !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService());
			 * paymentDao
			 * .setStrPaymentDetails(voObj.getStrOfflineClientName());
			 * paymentDao.setStrPaymentModeNo(voObj
			 * .getStrOffLineClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("1");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOfflineMaxClientBenefitAmount());
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
			 * paymentDao.setStrIsValid("1");
			 * 
			 * paymentDao.insert(dao); }
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
							+ err);
			voObj.setStrMsgType("1");

			if (nBillFlag == 1) {

				voObj.setStrBillNo("0");

				try {

					if (voObj.getStrOffLineHospitalService().equals("2")) {
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
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strDiscAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	/**
	 * 
	 * @param voObj
	 */
	public static void insertOfflineRefundServices(CashCollectionTransVO voObj) {

		int nAppFlag = 0;

		String strAppId = "0";

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			paymentDao = new PaymentDAO();

			String[] strBillDtls = voObj.getStrOfflineRefundBillDetails()
					.replace("^", "#").split("#");

			String strBillNo = strBillDtls[0];
			// String strTransType = strBillDtls[2];
			String strPatAccNo = strBillDtls[4];
			// String strRequestNo = strBillDtls[5];
			// String strIsBill = strBillDtls[9];
			// String strIsOnline = strBillDtls[10];
			String strAdmissionNo = strBillDtls[11];
			// String strServiceId = strBillDtls[16];

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			voObj.setStrBillNo(strBillNo);

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			pKey.setStrKeyname("APPROVAL");
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.select(dao);

			strAppId = pKey.getStrPrimrayKeyValue();

			if (!strAppId.equals("") || strAppId != null) {
				nAppFlag = 1;
			}

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_refund(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");

			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcInValue(nInsertedIndex1, "refRecNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "refAppId", strAppId);

			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj
					.getStrOfflineRefundDate());
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj
					.getStrOffLineRefundBy());
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj
					.getStrOffLineRefundReasonText());

			dao.setProcInValue(nInsertedIndex1, "patAccNo", strPatAccNo);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo());
			dao.setProcInValue(nInsertedIndex1, "admNo", strAdmissionNo);
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj
					.getStrOffLineEpisode());
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrOffLineTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOfflineTotalRecAmount());

			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrOfflineRefundTotalActualTariffAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrOfflineRefundTotalDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrOfflineRefundTotalServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj
					.getStrOfflineRefundTotalPenaltyAmount());

			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrOffLineRaisingDepartment());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService());
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj
					.getStrOffLineWard());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj
					.getStrOffLineClientPatientNo());
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj
					.getStrOffLineBalanceAmount());

			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj
					.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "moduleId", voObj
					.getStrModuleId());
			dao.setProcInValue(nInsertedIndex1, "ipAddr", voObj
					.getStrIpAddress());

			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_refund_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrBillTariffVal() != null)
				for (int i = 0, len = voObj.getStrBillTariffVal().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj.getStrBillTariffVal()[i]
							.replace('^', '#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					// String strTempRemQty = strTariffDtlsVal[1].replace("*",
					// "#").split("#")[0];
					// String strTempQtyUnitId = strTariffDtlsVal[2];
					String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRateUnit = strTariffDtlsVal[4];
					String strTempGroupId = strTariffDtlsVal[5];
					String strTempActualRate = strTariffDtlsVal[6];
					String strTempServiceTax = strTariffDtlsVal[7];
					String strTempDiscUnit = strTariffDtlsVal[8];
					String strTempDiscType = strTariffDtlsVal[9];
					String strTempGTariffId = strTariffDtlsVal[10];
					String strTempAppId = strTariffDtlsVal[11];
					// String strTempUnitName = strTariffDtlsVal[12];
					// String strTempBaseUnitVal = strTariffDtlsVal[13];
					String strTempIsPackage = strTariffDtlsVal[14];
					// String strTempNetAmt = strTariffDtlsVal[15];
					// String strTempPenlty = strTariffDtlsVal[16];
					// String strTempPenltyAmt = strTariffDtlsVal[17];
					String strTempReceiptNo = strTariffDtlsVal[18];
					String strTempSServiceId = strTariffDtlsVal[19];

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());
					dao.setProcInValue(nInsertedIndex2, "trfRecNo",
							strTempReceiptNo);

					dao.setProcInValue(nInsertedIndex2, "refRecNo",
							strRefundReceiptNo);

					dao
							.setProcInValue(nInsertedIndex2, "patAccNo",
									strPatAccNo);
					dao.setProcInValue(nInsertedIndex2, "puk", voObj
							.getStrCrNo());
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrOffLineTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrOffLineRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "refQty", voObj
							.getStrBillTariffRefund()[i]);
					dao.setProcInValue(nInsertedIndex2, "refQtyUnitId", voObj
							.getStrBillTariffUnit()[i].replace("^", "#").split(
							"#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate",
							strTempTariffRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",
							strTempRateUnit);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrOfflineRefundTotalServiceTaxAmount());
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrOfflineTotalRecAmount());

					dao.setProcInValue(nInsertedIndex2, "penelty", voObj
							.getStrBillTariffPenalty()[i]);
					dao.setProcInValue(nInsertedIndex2, "penAmt", voObj
							.getStrOfflineRefundTotalPenaltyAmount());

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrOfflineRefundTotalDiscountAmount());

					dao.setProcInValue(nInsertedIndex2, "appId", strTempAppId);

					dao.setProcInValue(nInsertedIndex2, "disUnit",
							strTempDiscUnit);
					dao.setProcInValue(nInsertedIndex2, "disType",
							strTempDiscType);

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrOffLineHospitalService());
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj
							.getStrOffLineWard());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrOffLineBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempSServiceId);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGTariffId);

					dao.setProcInValue(nInsertedIndex2, "isPackage",
							strTempIsPackage);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);

				}

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].equals("2")
						|| voObj.getStrOfflinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("4")
						|| voObj.getStrOfflinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("2");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrOffLineClientPatientNo().length() > 1 &&
			 * !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(strBillNo);
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo(strRefundReceiptNo);
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService());
			 * paymentDao
			 * .setStrPaymentDetails(voObj.getStrOfflineClientName());
			 * paymentDao.setStrPaymentModeNo(voObj
			 * .getStrOffLineClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("2");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOfflineMaxClientBenefitAmount());
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			e.printStackTrace();
			
			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOfflineRefundServices()--> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	/**
	 * Inserts Offline Refund Advance
	 * 
	 * @param voObj
	 */
	public static void insertOfflineRefundAdmissionCancellation(
			CashCollectionTransVO voObj) {

		int nInsertedIndex1 = 0;
		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			paymentDao = new PaymentDAO();

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_pataccount_close(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");

			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId());
			dao.setProcInValue(nInsertedIndex1, "billNo", voObj.getStrBillNo());
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj
					.getStrQtyUnitId());
			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj
					.getStrOfflineRefundDate());
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj
					.getStrOffLineRefundBy());
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj
					.getStrOffLineRefundReasonText());
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj
					.getStrOfflineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj
					.getStrOffLineRefundAdvanceAccountNo());

			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo());
			dao.setProcInValue(nInsertedIndex1, "penelty", voObj
					.getStrAdmissionCancellationPenalty());
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj
					.getStrRefundAdvancePaneltyAmt());
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj
					.getStrOffLineWard());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService());
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());

			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			dao.execute(nInsertedIndex1, 1);

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].equals("2")
						|| voObj.getStrOfflinePaymentMode()[i].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("4")
						|| voObj.getStrOfflinePaymentMode()[i].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("2");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			/*
			 * if (voObj.getStrOffLineClientPatientNo().length() > 1 &&
			 * !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) {
			 * 
			 * nSlNo = nSlNo + 1;
			 * 
			 * paymentDao.setStrBillNo(voObj.getStrBillNo());
			 * 
			 * paymentDao.setStrPaymentMode("6");
			 * paymentDao.setStrRecieptNo(strRefundReceiptNo);
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService());
			 * paymentDao
			 * .setStrPaymentDetails(voObj.getStrOfflineClientName());
			 * paymentDao.setStrPaymentModeNo(voObj
			 * .getStrOffLineClientPatientNo());
			 * paymentDao.setStrPaymentStatus("0");
			 * paymentDao.setStrRecieptType("2");
			 * paymentDao.setStrRecieptAmount(voObj
			 * .getStrOfflineMaxClientBenefitAmount());
			 * paymentDao.setStrPuk(voObj.getStrCrNo());
			 * paymentDao.setStrProcessedBy("0");
			 * paymentDao.setStrCounterId(strCounterId);
			 * paymentDao.setStrSeatId(voObj.getStrSeatId());
			 * paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
			 * paymentDao.setStrIsValid("1");
			 * paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
			 * 
			 * paymentDao.insert(dao); }
			 */

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> "
							+ err);

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	/**
	 * Insert's Without Cr. No. Receipt Services.
	 * 
	 * @param voObj
	 */
	public static void insertWithoutCrNoReceiptServices(
			CashCollectionTransVO voObj) {

		String strBillNo = "";
		String strDiscAppId = "";

		int nBillFlag = 0;
		int nAppFlag = 0;
		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

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
			pKey.setStrKeyname("BILL_WITHOUT_PUK");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_bill_without_crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo);
			dao.setProcInValue(nInsertedIndex1, "prevCrNo", voObj.getStrPreviousCrNo());
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());
			dao.setProcInValue(nInsertedIndex1, "patName", voObj
					.getStrGuarantorName());
			dao.setProcInValue(nInsertedIndex1, "patAddress", voObj
					.getStrGuartorAddress());
			dao.setProcInValue(nInsertedIndex1, "patContactNo", voObj
					.getStrGuarantorContactNo());
			
			dao.setProcInValue(nInsertedIndex1, "age", voObj.getStrAge());
			dao.setProcInValue(nInsertedIndex1, "ageUnit", voObj.getStrAgeUnit());
			dao.setProcInValue(nInsertedIndex1, "refDoctor", voObj.getStrReferringPhysician());
			dao.setProcInValue(nInsertedIndex1, "genderCode", voObj.getStrGender());	
			
			dao.setProcInValue(nInsertedIndex1, "refDocContactNo", voObj.getStrReferringPhysicianContactNo());
			
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrOffLineTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOfflineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrOfflineTotalActualTariffAmount());

			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrOfflineTotalDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrOfflineTotalServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrOffLineRaisingDepartment());

			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService());
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService());
			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "prevCrDtlFlag", voObj.getStrPreviousCrNoDtlFlag());
			
			
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			dao.execute(nInsertedIndex1, 1);

			if (voObj.getStrOfflineTariffDetailsHidden() != null)
				for (int i = 0, len = voObj.getStrOfflineTariffDetailsHidden().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj
							.getStrOfflineTariffDetailsHidden()[i].replace('^',
							'#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					String strTempGroupId = strTariffDtlsVal[1];
					// String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRate = strTariffDtlsVal[4];
					String strUnit = strTariffDtlsVal[5];
					// String strTempBaseUnitVal = strTariffDtlsVal[6];
					// String strTempIsPackage = strTariffDtlsVal[7];
					// String strTempIsAdvance = strTariffDtlsVal[8];
					String strTempIsRefundable = strTariffDtlsVal[9];
					// String strTempDefaultRate = strTariffDtlsVal[10];
					String strTempTariffActualRate = strTariffDtlsVal[11];
					// String strTempMaxDiscount = strTariffDtlsVal[12];
					String strTempServiceTax = strTariffDtlsVal[13];
					String strTempServiceId = strTariffDtlsVal[15];
					String strTempGTariffId = strTariffDtlsVal[16];

					nInsertedIndex2 = dao
							.setProcedure("{call pkg_bill_dml.dml_bill_service_without_crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo);
					
					dao.setProcInValue(nInsertedIndex2, "prevCrNo", voObj.getStrPreviousCrNo());
					
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrOffLineTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrOffLineRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj
							.getStrOfflineTariffQty()[i]);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj
							.getStrOfflineTariffUnit()[i].replace("^", "#")
							.split("#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strUnit);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrOfflineTariffServiceTaxAmtVal()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrOfflineTariffNetAmount()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrOfflineTariffDiscountAmtVal()[i]);

					if (voObj.getStrOfflineTariffDiscountConfigDetails() != null
							&& !voObj.getStrOfflineTariffDiscount()[i]
									.equals("0")) {

						String[] strDiscountDtlsValue = voObj
								.getStrOfflineTariffDiscountConfigDetails()[i]
								.replace(',', '#').split("#");

						String strTempDiscUnit = strDiscountDtlsValue[0];
						String strTempDiscType = strDiscountDtlsValue[1];
						String strTempDiscBy = strDiscountDtlsValue[2];
						String strTempDiscReason = strDiscountDtlsValue[4];
						String strTempDiscDate = strDiscountDtlsValue[5];

						if (!voObj.getStrOfflineTariffDiscount()[i].equals("0")) {
							pKey.setStrKeyname("APPROVAL");
							pKey.setStrBlockkey("1");
							pKey.setStrHospCode(voObj.getStrHospitalCode());
							pKey.select(dao);

							strDiscAppId = pKey.getStrPrimrayKeyValue();

							if (!strDiscAppId.equals("")
									|| strDiscAppId != null) {
								nAppFlag = 1;
							}

							dao.setProcInValue(nInsertedIndex2, "appId",
									strDiscAppId);
						} else {
							dao.setProcInValue(nInsertedIndex2, "appId", "");
						}
						dao.setProcInValue(nInsertedIndex2, "disUnit",
								strTempDiscUnit);
						dao.setProcInValue(nInsertedIndex2, "disType",
								strTempDiscType);
						dao.setProcInValue(nInsertedIndex2, "disBy",
								strTempDiscBy);
						dao.setProcInValue(nInsertedIndex2, "disReason",
								strTempDiscReason);
						dao.setProcInValue(nInsertedIndex2, "disDate",
								strTempDiscDate);

					} else {

						dao.setProcInValue(nInsertedIndex2, "appId", "0");
						dao.setProcInValue(nInsertedIndex2, "disUnit", "0");
						dao.setProcInValue(nInsertedIndex2, "disType", "");
						dao.setProcInValue(nInsertedIndex2, "disBy", "");
						dao.setProcInValue(nInsertedIndex2, "disReason", "");
						dao.setProcInValue(nInsertedIndex2, "disDate", "");
					}

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrOffLineHospitalService());
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrOffLineBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempServiceId);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGTariffId);
					dao.setProcInValue(nInsertedIndex2, "isRefund",
							strTempIsRefundable);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);
				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao.setStrPreviousPuk(voObj.getStrPreviousCrNo());
				
				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[j]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[j]);
					payDtl = voObj.getStrOfflinePaymentDtls()[j].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[j].equals("2")
						|| voObj.getStrOfflinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("4")
						|| voObj.getStrOfflinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[j]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoReceiptServices()--> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

			if (nBillFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("BILL_WITHOUT_PUK");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strDiscAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	public static void insertWithoutCrNoRefundServices(
			CashCollectionTransVO voObj) {

		int nAppFlag = 0;

		String strAppId = "0";

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PaymentDAO paymentDao = null;

		try {

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			paymentDao = new PaymentDAO();

			String strPatName = voObj.getStrGuarantorHiddenVal().replace("^",
					"#").split("#")[0];

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			CashCollectionTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			pKey.setStrKeyname("APPROVAL");
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.select(dao);

			strAppId = pKey.getStrPrimrayKeyValue();

			if (!strAppId.equals("") || strAppId != null) {
				nAppFlag = 1;
			}

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.Dml_Refund_Without_Crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1");

			dao.setProcInValue(nInsertedIndex1, "billNo", voObj.getStrBillNo());
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode());

			dao.setProcInValue(nInsertedIndex1, "patName", strPatName);

			dao.setProcInValue(nInsertedIndex1, "refRecNo", strRefundReceiptNo);
			dao.setProcInValue(nInsertedIndex1, "refAppId", strAppId);

			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj
					.getStrOfflineRefundDate());
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj
					.getStrOffLineRefundBy());
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj.getStrOffLineRefundReasonText());

			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrOffLineTreatmentCategory());
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOfflineTotalRecAmount());

			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrOfflineRefundTotalActualTariffAmount());
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrOfflineRefundTotalDiscountAmount());
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrOfflineRefundTotalServiceTaxAmount());
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj
					.getStrOfflineRefundTotalPenaltyAmount());

			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrOffLineRaisingDepartment());
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService());

			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService());

			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId());
			dao.setProcInValue(nInsertedIndex1, "moduleId", voObj
					.getStrModuleId());
			dao.setProcInValue(nInsertedIndex1, "ipAddr", voObj
					.getStrIpAddress());

			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1);

			// keep in batch
			dao.execute(nInsertedIndex1, 1);

			nInsertedIndex2 = dao
					.setProcedure("{call pkg_bill_dml.dml_refund_ser_without_crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			if (voObj.getStrBillTariffVal() != null)
				for (int i = 0, len = voObj.getStrBillTariffVal().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj.getStrBillTariffVal()[i]
							.replace('^', '#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					// String strTempRemQty = strTariffDtlsVal[1].replace("*",
					// "#").split("#")[0];
					// String strTempQtyUnitId = strTariffDtlsVal[2];
					String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRateUnit = strTariffDtlsVal[4];
					String strTempGroupId = strTariffDtlsVal[5];
					String strTempActualRate = strTariffDtlsVal[6];
					String strTempServiceTax = strTariffDtlsVal[7];
					String strTempDiscUnit = strTariffDtlsVal[8];
					String strTempDiscType = strTariffDtlsVal[9];
					String strTempGTariffId = strTariffDtlsVal[10];
					String strTempAppId = strTariffDtlsVal[11];
					// String strTempUnitName = strTariffDtlsVal[12];
					// String strTempBaseUnitVal = strTariffDtlsVal[13];
					// String strTempIsPackage = strTariffDtlsVal[14];
					// String strTempNetAmt = strTariffDtlsVal[15];
					// String strTempPenlty = strTariffDtlsVal[16];
					// String strTempPenltyAmt = strTariffDtlsVal[17];
					String strTempReceiptNo = strTariffDtlsVal[18];
					String strTempSServiceId = strTariffDtlsVal[19];

					dao.setProcInValue(nInsertedIndex2, "modval", "1");
					dao.setProcInValue(nInsertedIndex2, "billNo", voObj
							.getStrBillNo());
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode());

					dao.setProcInValue(nInsertedIndex2, "patName", strPatName);

					dao.setProcInValue(nInsertedIndex2, "trfRecNo",
							strTempReceiptNo);

					dao.setProcInValue(nInsertedIndex2, "refRecNo",
							strRefundReceiptNo);

					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrOffLineTreatmentCategory());
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrOffLineRaisingDepartment());
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId);
					dao.setProcInValue(nInsertedIndex2, "refQty", voObj
							.getStrBillTariffRefund()[i]);
					dao.setProcInValue(nInsertedIndex2, "refQtyUnitId", voObj
							.getStrBillTariffUnit()[i].replace("^", "#").split(
							"#")[0]);
					dao.setProcInValue(nInsertedIndex2, "rate",
							strTempTariffRate);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempActualRate);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId",
							strTempRateUnit);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrOfflineRefundServiceTaxAmount()[i]);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrBillTariffRefundAmount()[i]);

					dao.setProcInValue(nInsertedIndex2, "penelty", voObj
							.getStrBillTariffPenalty()[i]);
					dao.setProcInValue(nInsertedIndex2, "penAmt", voObj
							.getStrOfflineRefundPenaltyAmount()[i]);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrOfflineRefundDiscountAmount()[i]);

					dao.setProcInValue(nInsertedIndex2, "appId", strTempAppId);

					dao.setProcInValue(nInsertedIndex2, "disUnit",
							strTempDiscUnit);
					dao.setProcInValue(nInsertedIndex2, "disType",
							strTempDiscType);

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrOffLineHospitalService());

					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrOffLineBillingService());
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempSServiceId);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGTariffId);

					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId());

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1);

					dao.execute(nInsertedIndex2, 1);

				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());
				paymentDao.setStrPreviousPuk(voObj.getStrPreviousCrNo());
				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[j]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[j]);
					payDtl = voObj.getStrOfflinePaymentDtls()[j].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[j].equals("2")
						|| voObj.getStrOfflinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("4")
						|| voObj.getStrOfflinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("2");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[j]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoRefundServices()--> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoRefundServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	public static void insertOnlineWithoutCrNoReceiptServices(
			CashCollectionTransVO voObj) {

		String strBillNo = "";
		String strDiscAppId = "";

		int nBillFlag = 0;
		int nAppFlag = 0;
		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

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
			pKey.setStrKeyname("BILL_WITHOUT_PUK");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strBillNo = pKey.getStrPrimrayKeyValue();

			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#")
					.split("#")[0];

			
			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_bill_without_crno(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo,2);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj
					.getStrHospitalCode(),3); 
			dao.setProcInValue(nInsertedIndex1, "prevcrno", "",4);
			dao.setProcInValue(nInsertedIndex1, "patName", voObj
					.getStrGuarantorName(),5);
			dao.setProcInValue(nInsertedIndex1, "patAddress", voObj
					.getStrGuartorAddress(),6);
			dao.setProcInValue(nInsertedIndex1, "patContactNo", voObj
					.getStrGuarantorContactNo(),7);
			
			dao.setProcInValue(nInsertedIndex1, "age", voObj.getStrAge(),22);
			dao.setProcInValue(nInsertedIndex1, "ageUnit", voObj.getStrAgeUnit(),23);
			dao.setProcInValue(nInsertedIndex1, "refDoctor", voObj.getStrReferringPhysician(),24);
			dao.setProcInValue(nInsertedIndex1, "genderCode", voObj.getStrGender(),25);
			dao.setProcInValue(nInsertedIndex1, "refDocContactNo", voObj.getStrReferringPhysicianContactNo(),26);
			
			
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj
					.getStrOffLineTreatmentCategory(),8);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj
					.getStrOfflineTotalRecAmount(),9);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj
					.getStrTotalTariffActualAmount(),10);

			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj
					.getStrTotalTariffDiscountAmount(),11);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj
					.getStrTotalTariffServiceTaxAmount(),12);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj
					.getStrOffLineRaisingDepartment(),13);

			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj
					.getStrOffLineHospitalService(),14);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj
					.getStrOffLineBillingService(),15);
			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId,17);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),16);

			dao.setProcInValue(nInsertedIndex1, "reqNo", voObj
					.getStrRequestNo(),18);
			dao.setProcInValue(nInsertedIndex1, "reqDate", voObj
					.getStrRequestDate(),19);
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", voObj
					.getStrGlobalRequestNo(),20);
			dao.setProcInValue(nInsertedIndex1, "serviceId", voObj
					.getStrService(),21);
			dao.setProcInValue(nInsertedIndex1, "prevcrdtlflag", "0",27);
			dao.setProcOutValue(nInsertedIndex1, "err", 1,28);

			dao.execute(nInsertedIndex1, 1);

			if (voObj.getStrTariffDetailsId() != null)
				for (int i = 0, len = voObj.getStrTariffDetailsId().length; i < len; i++) {

					String[] strTariffDtlsVal = voObj.getStrTariffDetailsId()[i]
							.replace('^', '#').split("#");

					String strTempTariffId = strTariffDtlsVal[0];
					String strTempGroupId = strTariffDtlsVal[5];
					String strTempRate = strTariffDtlsVal[3];
					String strUnit = strTariffDtlsVal[4];
					String strTempIsRefundable = "0"; // strTariffDtlsVal[9];
					String strTempTariffActualRate = strTariffDtlsVal[6];
					String strTempServiceTax = strTariffDtlsVal[7];
					String strTempGTariffId = strTariffDtlsVal[10];
					String strTempServiceId = strTariffDtlsVal[strTariffDtlsVal.length - 1];

					nInsertedIndex2 = dao
							.setProcedure("{call pkg_bill_dml.dml_bill_service_without_crno(?::varchar,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?)}");

					dao.setProcInValue(nInsertedIndex2, "modval", "1",1);
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo,3);
									
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj
							.getStrHospitalCode(),2);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj
							.getStrOffLineTreatmentCategory(),4);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj
							.getStrOffLineRaisingDepartment(),5);
					dao
							.setProcInValue(nInsertedIndex2, "grpId",
									strTempGroupId,6);
					dao.setProcInValue(nInsertedIndex2, "trfId",
							strTempTariffId,7);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj
							.getStrTariffBilledQty()[i],8);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj
							.getStrBillTariffUnit()[i].replace("^", "#").split(
							"#")[0],9);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempRate,10);
					dao.setProcInValue(nInsertedIndex2, "actRate",
							strTempTariffActualRate,11);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strUnit,12);
					dao.setProcInValue(nInsertedIndex2, "serTax",
							strTempServiceTax,13);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj
							.getStrTariffServiceTaxAmt()[i],14);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj
							.getStrTariffNetAmt()[i],15);

					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj
							.getStrTariffDiscountAmt()[i],18);

					if (voObj.getStrOfflineTariffDiscountConfigDetails() != null
							&& Double.parseDouble(voObj
									.getStrTariffDiscountAmt()[i]) != 0) {

						String[] strDiscountDtlsValue = voObj
								.getStrOfflineTariffDiscountConfigDetails()[i]
								.replace(",", "#").split("#");

						String strTempDiscUnit = strDiscountDtlsValue[0];
						String strTempDiscType = strDiscountDtlsValue[1];
						String strTempDiscBy = strDiscountDtlsValue[2];
						String strTempDiscReason = strDiscountDtlsValue[4];
						String strTempDiscDate = strDiscountDtlsValue[5];

						if (strDiscountDtlsValue.length > 1) {
							pKey.setStrKeyname("APPROVAL");
							pKey.setStrBlockkey("1");
							pKey.setStrHospCode(voObj.getStrHospitalCode());
							pKey.select(dao);

							strDiscAppId = pKey.getStrPrimrayKeyValue();

							if (!strDiscAppId.equals("")
									|| strDiscAppId != null) {
								nAppFlag = 1;
							}

							dao.setProcInValue(nInsertedIndex2, "appId",
									strDiscAppId,15);
						} else {
							dao.setProcInValue(nInsertedIndex2, "appId", "",16);
						}
						dao.setProcInValue(nInsertedIndex2, "disUnit",
								strTempDiscUnit,17);
						dao.setProcInValue(nInsertedIndex2, "disType",
								strTempDiscType,19);
						dao.setProcInValue(nInsertedIndex2, "disBy",
								strTempDiscBy,20);
						dao.setProcInValue(nInsertedIndex2, "disReason",
								strTempDiscReason,21);
						dao.setProcInValue(nInsertedIndex2, "disDate",
								strTempDiscDate,22);

					} else {

						dao.setProcInValue(nInsertedIndex2, "appId", "0",16);
						dao.setProcInValue(nInsertedIndex2, "disUnit", "0",17);
						dao.setProcInValue(nInsertedIndex2, "disType", "",19);
						dao.setProcInValue(nInsertedIndex2, "disBy", "",20);
						dao.setProcInValue(nInsertedIndex2, "disReason", "",21);
						dao.setProcInValue(nInsertedIndex2, "disDate", "",22);
					}

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj
							.getStrOffLineHospitalService(),23);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj
							.getStrOffLineBillingService(),24);
					dao.setProcInValue(nInsertedIndex2, "serviceId",
							strTempServiceId,25);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",
							strTempGTariffId,26);
					dao.setProcInValue(nInsertedIndex2, "isRefund",
							strTempIsRefundable,27);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj
							.getStrSeatId(),28);
					
					dao.setProcInValue(nInsertedIndex2, "prevcrno", "",29);

					dao.setProcInValue(nInsertedIndex2, "reqNo", voObj
							.getStrRequestNo(),30);

					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1,31);

					dao.execute(nInsertedIndex2, 1);
				}

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int j = 0; j < nPaymentLenght; j++) {

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao
						.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[j]);
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj
						.getStrOffLineHospitalService());
				paymentDao
						.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null) {
					paymentDao.setStrPaymentDetails(voObj
							.getStrOfflinePaymentDtls()[j]);
					payDtl = voObj.getStrOfflinePaymentDtls()[j].replace(",",
							"#").split("#");
				} else {
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[j].equals("2")
						|| voObj.getStrOfflinePaymentMode()[j].equals("3")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("4")
						|| voObj.getStrOfflinePaymentMode()[j].equals("5")) {
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[j].equals("6")) {

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else {
					paymentDao.setStrPaymentModeNo("");
					paymentDao.setStrPaymentStatus("1");
				}

				paymentDao.setStrRecieptType("1");
				paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[j]);

				paymentDao.setStrPuk(voObj.getStrCrNo());
				paymentDao.setStrProcessedBy("0");
				paymentDao.setStrCounterId(strCounterId);
				paymentDao.setStrSeatId(voObj.getStrSeatId());
				paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				paymentDao.setStrIsValid("1");
				paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());

				paymentDao.insert(dao);
			}

			synchronized (dao) {
				dao.fire();
			}

		} catch (Exception e) {

			String err = "err:" + e.getMessage();

			voObj
					.setStrMsgString("CashCollectionTransDAO.insertOnlineWithoutCrNoReceiptServices()--> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

			if (nBillFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("BILL_WITHOUT_PUK");
					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertWithoutCrNoReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1) {

				try {
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strDiscAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1) {

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOnlineWithoutCrNoReceiptServices()--> "
									+ e1.getMessage() + "-->" + err);
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

	/**
	 * executes the BILL_MST.getCounterDtl() by passing Module Id, IP Address,
	 * Hospital Code and Mode 1. which generates the Counter and set to Value
	 * Object's counterId.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getCounterId(CashCollectionTransVO voObj) {

		String strCounterId = "";
		String strMode = "1";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.getCounterDtl(?,?,?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO .getCounterId()");

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

	public static void getRefundReceiptNo(CashCollectionTransVO voObj) {

		String strRefundReceiptNo = "";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.get_refund_receiptno(?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try {
			dao = new HisDAO("billing",
					"transactions.CashCollectionTransDAO .getRefundReceiptNo()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 3, voObj.getStrBillNo());
			dao.setFuncOutValue(nfuncIndex, 1);

			dao.executeFunction(nfuncIndex);

			strRefundReceiptNo = dao.getFuncString(nfuncIndex);

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

}
