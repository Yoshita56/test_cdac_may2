package billing;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.rowset.WebRowSet;

import billing.dao.ApprovalDAO;
import billing.dao.BillDAO;
import billing.dao.BillReceiptDAO;
import billing.dao.BillRequisitionTariffDAO;
import billing.dao.ClientPatientDAO;
import billing.dao.OutBoundDAO;
import billing.dao.PatientAccountDAO;
import billing.dao.PatientAccountServiceDAO;
import billing.dao.PatientAccountStatusDAO;
import billing.dao.PaymentDAO;
import billing.dao.PrimaryKeyDAO;
import billing.dao.PrimaryKeyLogDAO;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.GetNetworkAddress;
import hisglobal.utility.HisUtil;

public class CashCollectionOfflineTransDAO
{

	/**
	 * retrieves Patient Account Details
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getClientPatientNumber(CashCollectionOfflineTransVO voObj)
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

				daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getClientPatientNumber");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "accno", strAccNo, 1);
				daoObj.setProcInValue(nProcIndex, "modeval", "1", 5);
				daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 6);
				daoObj.setProcInValue(nProcIndex, "puk", "", 2);
				daoObj.setProcInValue(nProcIndex, "chargeTypeId", voObj.getStrChargeTypeId(), 3);
				daoObj.setProcInValue(nProcIndex, "activeAccount", "1", 4);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 7);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 8);

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

						}
					} else
					{
						voObj.setStrClientPatientNo(null);
					}

				} else
				{
					throw new Exception(strErr);
				}
			} else
			{

				voObj.setOnlineTariffDetails(null);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getClientPatientNumber() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Client Patient Details using Client Patient Number.
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getClientPatientDetailsWithClientPatNo(CashCollectionOfflineTransVO voObj)
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

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionTransDAO.getClientPatientDetailsWithClientPatNo");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "clientpatno", strClientPatNo, 2);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 4);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo, 6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 7);

			daoObj.setProcInValue(nProcIndex, "puk", "", 1);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "", 3);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 9);

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

				} else
				{
					voObj.setOnlineClientDetails(null);
				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getClientPatientDetailsWithClientPatNo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
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
	 *           Value Object
	 */
	public static void getClientPatientDetailsWithCrNo(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrChargeTypeId();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrBillNo();
		String strErr = "";

		try
		{

			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getClientPatientDetailsWithCrNo");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber, 1);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 4);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo, 6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 7);

			daoObj.setProcInValue(nProcIndex, "clientpatno", "", 2);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "", 3);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 9);

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

				} else
				{
					voObj.setOnlineClientDetails(null);
				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getClientPatientDetailsWithCrNo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Hospital Service List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	
	public static void getHospitalServiceList(CashCollectionOfflineTransVO voObj)
	{
		//If Role Based Defined Then Role Based Data Otherwise All Data.Logic defined in Procedure
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_CHARGETYPE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strSeatId = voObj.getStrSeatId();
		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getHospitalServiceList");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 1);//Global Hospital Code Hard Coded in Procedure
			daoObj.setProcInValue(nProcIndex, "seatId", strSeatId, 3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNo(), 4);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 2);
			daoObj.setProcOutValue(nProcIndex,"err", 1, 5);
			daoObj.setProcOutValue(nProcIndex,"RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setOfflineHospitalServiceList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getHospitalServiceList() --> " + e.getMessage());
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
	public static void getHospitalServiceListBasedOnVisit(CashCollectionOfflineTransVO voObj)
	{
		//If Role Based Defined Then Role Based Data Otherwise All Data.Logic defined in Procedure
		//It'll SHOW only those charge types which are bound to patients epsiode in last 15 days. 
		//i.e if patient visited OPD Morning in last 15 days then Only OPD Morning will come. 
		//If patient visited in OPD Morning Clinic as well as OPD Spl clinic then both will come.Same for Emg
		//IPD will come only if patient is Admitted(i.e. Account is opened)
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_CHARGETYPE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strSeatId = voObj.getStrSeatId();
		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getHospitalServiceList");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 1);//Global Hospital Code Hard Coded in Procedure
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 2);
			daoObj.setProcInValue(nProcIndex, "seatId", strSeatId, 3);
			daoObj.setProcInValue(nProcIndex, "crNo", voObj.getStrCrNo(), 4);
			daoObj.setProcOutValue(nProcIndex,"err", 1, 5);
			daoObj.setProcOutValue(nProcIndex,"RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if(ws.next())//set first charge type to get biling services based on selected charge type
				{
					voObj.setStrOffLineHospitalService(ws.getString(1));
					ws.beforeFirst();
				}
				voObj.setOfflineHospitalServiceList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getHospitalServiceList() --> " + e.getMessage());
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
	 * retrieves QR Code Mode List
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public static void getQRCodeModeList(CashCollectionOfflineTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_qrcodemode_mst(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try {

			daoObj = new HisDAO("Cash Collection Transaction",
					"CashCollectionOfflineTransDAO.getQRCodeModeList");

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
	 * retrieves Billing Service List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getBillingServiceList(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_BILLSERVICE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeId = voObj.getStrOffLineHospitalService();
		String strRequestType = voObj.getStrOffLineRequestType();

		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getBillingServiceList");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 1);//Global Hospital Code Hard Coded in Procedure
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeId, 2);
			daoObj.setProcInValue(nProcIndex, "req_type", strRequestType, 3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setOfflineBillingServiceList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getBillingServiceList() --> " + e.getMessage());
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
	 * retrieves Billing Service List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getBillingServiceListExcludingIpdAdvance(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_SBLT_BILLSERVICE_MST(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeId = voObj.getStrOffLineHospitalService();
		String strRequestType = voObj.getStrOffLineRequestType();

		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getBillingServiceListExcludingIpdAdvance");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 1);//Global Hospital Code Hard Coded in Procedure
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeId, 2);
			daoObj.setProcInValue(nProcIndex, "req_type", strRequestType, 3);
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setOfflineBillingServiceList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionOfflineTransDAO.getBillingServiceListExcludingIpdAdvance() --> " + e.getMessage());
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
	 * retrieves Raising Department List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getRaisingDepartmentList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_GBLT_DEPARTMENT_MST(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();

		String strChargeTypeId = voObj.getStrOffLineHospitalService();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getRaisingDepartmentList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "4", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo, 4);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", strChargeTypeId, 5);
			daoObj.setProcInValue(nProcIndex, "deptcode", "", 3);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 6);
			daoObj.setProcInValue(nProcIndex, "effect_to", "", 7);
			daoObj.setProcInValue(nProcIndex, "userId", "", 8);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 9);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 10);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next())
				{

					voObj.setStrOffLineRaisingDepartment(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineRaisingDepartmentList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getRaisingDepartmentList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// Added new method by garima gotra for HIS_PGI_BILL_CR_2 on 19 Aug 2011 Get Last Episode
	public static void getRaisingDepartment(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_simple_view.proc_GBLT_DEPARTMENT_MST(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getRaisingDepartment");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "5", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo, 4);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", strChargeTypeId, 5);
			daoObj.setProcInValue(nProcIndex, "deptcode", "", 3);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 6);
			daoObj.setProcInValue(nProcIndex, "effect_to", "", 7);
			daoObj.setProcInValue(nProcIndex, "userId", "", 8);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 9);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 10);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws.next())
				{
					voObj.setStrOffLineRaisingDepartment(ws.getString(1));
					ws.beforeFirst();
				}
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getRaisingDepartment() --> " + e.getMessage());
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
	 * retrieves Episode List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getEpisodeListCombo(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_HRGT_EPISODE_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Admitted Department/Last Visited Department
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getEpisodeListCombo");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 3);			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				/* This Logic Implemented in method getAdmEpisodeTreatmentCatDtl to set last Admitted episode/visited episode..Amit Kumar Ateria
				 * USED TO JUST POPULATE COMBO.
				 */
				/*if (ws.next())
				{
					voObj.setStrOffLineEpisode(ws.getString(1) + "@" + ws.getString(3)+ "@" + ws.getString(4));//Episode Code@TreatmentCat@CatGroup
					ws.beforeFirst();
				}*/
				voObj.setOfflineEpisodeList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			voObj.setStrMsgString("CashCollectionOfflineTransDAO.getEpisodeListCombo() --> " + e.getMessage());
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
	 * retrieves Episode List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getEpisodeList(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_HRGT_EPISODE_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Admitted Department/Last Visited Department
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getEpisodeList");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 3);			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				/* This Logic Implemented in method getAdmEpisodeTreatmentCatDtl to set last Admitted episode/visited episode..Amit Kumar Ateria
				/*if (ws.next())
				{
					voObj.setStrOffLineEpisode(ws.getString(1) + "@" + ws.getString(3)+ "@" + ws.getString(4));//Episode Code@TreatmentCat@CatGroup
					ws.beforeFirst();
				}*/
				voObj.setOfflineEpisodeList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getEpisodeList() --> " + e.getMessage());
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
	 * retrieves Treatment Category List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getTreatmentCategoryList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.PROC_GBLT_PATIENT_CAT_MST_DATA(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strCrNo = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		//System.out.println("charge type id is "+strChargeTypeId+" "+voObj.getStrTreatmentCategory());
		String strErr = "";
		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getTreatmentCategoryList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk_no", strCrNo, 3);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", strChargeTypeId, 4);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 5);
			daoObj.setProcInValue(nProcIndex, "effect_TO", "", 6);
			daoObj.setProcInValue(nProcIndex, "cat_code", voObj.getStrTreatmentCategory(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				//This Logic implemented in method getAdmEpisodeTreatmentCatDtl to select Admitted Treatment Category/Last Visited Episode Category/Primary Category.Amit Kumar Ateria
				/*if (ws.next())
				{
					voObj.setStrOffLineTreatmentCategory(ws.getString(1));
					ws.beforeFirst();
				}*/
				voObj.setOfflineTreatmentCategoryList(ws);

			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getTreatmentCategoryList() --> " + e.getMessage());
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
	 * retrieves Ward List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getWardList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_ipd_chargetype_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getWardList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_val", "1", 1);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);

			daoObj.setProcOutValue(nProcIndex, "err", 1, 3);

			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next())
				{

					voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineWardList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getWardList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Special Ward List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getSplWardList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_ward_list(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strDeptCode = voObj.getStrRaisingDepartment();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getSplWardList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_val", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 3);
			daoObj.setProcInValue(nProcIndex, "dept_code", strDeptCode, 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setOfflineSplWardList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getSplWardList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Payment Mode List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getPaymentModeList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_paymentmode_mst(?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionTransDAO.getPaymentModeList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 3);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrPaymentModeList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getPaymentModeList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	
	

	
	
	
	public static void getPaymentModeListByPatCategory(CashCollectionOfflineTransVO voObj) throws Exception
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.sblt_payment_category_mapping_mst(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeId = voObj.getStrOffLineHospitalService();
		String strRequestType = voObj.getStrOffLineRequestType();
		String strPaymentMode="0";
		
		if(voObj.getStrOfflinePaymentMode()!=null)
		 strPaymentMode= voObj.getStrOfflinePaymentMode()[0];
		
		
		//voObj.setStrOffLineTreatmentCategory(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0]);
		String strPatCategory =voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0];
		
		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getPaymentModeListByPatCategory");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);//Global Hospital Code Hard Coded in Procedure
			daoObj.setProcInValue(nProcIndex, "req_type", strRequestType, 3);
			daoObj.setProcInValue(nProcIndex, "pat_category", strPatCategory, 4);
			daoObj.setProcInValue(nProcIndex, "pat_reciept_paymode", strPaymentMode, 5);
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeId, 6);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 7);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 8);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				System.out.println("ws.size pay mode"+ws.size());
				if(ws.size()==0)
				{
					voObj.setStrMsgType("3");
					voObj.setStrMsgString("Payment Mode For Selected Category Not Found");
					throw new Exception("Payment Mode For Selected Category Not Found");
				}
				else
					voObj.setStrPaymentModeList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			if(voObj.getStrMsgType().equals("3"))
			{
				voObj.setStrMsgString("Payment Mode For Selected Category Not Found");
				throw new Exception("Payment Mode For Selected Category Not Found");
			}
			else
			{
				voObj.setStrMsgString("CashCollectionTransDAO.getPaymentModeListByPatCategory() --> " + e.getMessage());
				voObj.setStrMsgType("1");
				throw new Exception("CashCollectionTransDAO.getPaymentModeListByPatCategory() --> " + e.getMessage());
			}
			
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
	 * retrieves Client Name List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getClientNameList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_mst(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getClientNameList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 2);
			daoObj.setProcInValue(nProcIndex, "client_no", "", 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setStrClientNameList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getClientNameList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Remarks List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getRemarksList(CashCollectionOfflineTransVO voObj)
	{

		String proc_name = "";

		proc_name = "{call PKG_SIMPLE_VIEW.PROC_HBLT_REMARKS_MST(?,?,?,?,?)}";

		HisDAO dao = null;

		int nprocIndex = 0;

		String strerr = "";
		String strHospCode = voObj.getStrHospitalCode();

		WebRowSet ws = null;

		try
		{

			dao = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getRemarksList()");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "rmkstype", "3", 1);
			dao.setProcInValue(nprocIndex, "modeVal", "1", 2);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode, 3);
			dao.setProcOutValue(nprocIndex, "ERR", 1, 4); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2, 5); // 2 for object

			// execute procedure

			dao.executeProcedureByPosition(nprocIndex);

			// get value

			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				if (ws.next())
				{
					voObj.setStrOffLineRemarks(ws.getString(2));

					ws.beforeFirst();
				}

				voObj.setOfflineRemarksList(ws);

				voObj.setStrMsgType("0");

			} else
			{

				throw new Exception(strerr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getRemarksList() --> "

			+ e.getMessage());

			voObj.setStrMsgType("1");

		} finally
		{

			if (dao != null)
			{

				dao.free();

				dao = null;

			}

		}

	}

	/**
	 * retrieves Approver Employee List
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getApprovedBy(CashCollectionOfflineTransVO voObj)
	{

		String proc_name = "";
		proc_name = "{call pkg_simple_view.Proc_user_list(?,?,?,?,?)}";

		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		String strHospCode = voObj.getStrHospitalCode();
		String strSeatId = voObj.getStrSeatId();
		WebRowSet ws = null;

		try
		{

			dao = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getApprovedBy()");

			nprocIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(nprocIndex, "processId", "2", 1);
			dao.setProcInValue(nprocIndex, "seatId", strSeatId, 3);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode, 2);
			dao.setProcOutValue(nprocIndex, "ERR", 1, 4); // 1 for string return

			// value
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2, 5); // 2 for object

			// execute procedure
			dao.executeProcedureByPosition(nprocIndex);

			// get value
			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineApprovedByList(ws);

				voObj.setStrMsgType("0");

			} else
			{

				throw new Exception(strerr);

			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getApprovedBy() --> "

			+ e.getMessage());

			voObj.setStrMsgType("1");

		} finally
		{

			if (dao != null)
			{

				dao.free();
				dao = null;

			}

		}

	}

	/**
	 * retrieves Part Payment or Advance Amount
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getPartPaymentOrAdvanceAmount(CashCollectionOfflineTransVO voObj)
	{
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.proc_hblt_advance_mst (?,?,?,?,?,?,?,?)}";

		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;

		String wardid = voObj.getStrOffLineWard();
		String patCatCode = voObj.getStrOffLineTreatmentCategory();
		String strHospCode = voObj.getStrHospitalCode();
		String splWardId = voObj.getStrOffLineSpecialWard();

		try
		{
			dao = new HisDAO("Billing","transactions.CashCollectionTransDAO.getPartPaymentOrAdvanceAmount()");

			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "wardid", wardid, 1);
			dao.setProcInValue(nprocIndex, "catcode", patCatCode, 2);
			dao.setProcInValue(nprocIndex, "chargeId", "2", 3);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospCode, 4);
			dao.setProcInValue(nprocIndex, "splwardid", splWardId, 5);
			dao.setProcInValue(nprocIndex, "modeval", "1", 6);			
			dao.setProcOutValue(nprocIndex, "ERR", 1, 7);
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2, 8);

			dao.executeProcedureByPosition(nprocIndex);

			strerr = dao.getString(nprocIndex, "ERR");

			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");
				if (ws != null)
					if (ws.next())
					{
						voObj.setStrOffLineAdvanceAmount(ws.getString(1));
						voObj.setStrOffLinePartPaymentAmount(ws.getString(2));
					}
				voObj.setStrMsgType("0");
			} 
			else
			{
				throw new Exception(strerr);
			}
		}
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getPartPaymentOrAdvanceAmount() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * retrieves Patient Account Details
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	/*
	 * public static void
	 * getOffLineClientPatientNumber(CashCollectionOfflineTransVO voObj) {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null;
	 * 
	 * String strProcName = "{call
	 * pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?)}"; int nProcIndex = 0;
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
	 *           Value Object
	 */
	public static void getOffLineClientPatientDetailsWithClientPatNo(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strClientPatNo = voObj.getStrOffLineClientPatientNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrOffLineBillNumber();
		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithClientPatNo");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "clientpatno", strClientPatNo, 2);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "", 3);
			daoObj.setProcInValue(nProcIndex, "puk", "0", 1);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 4);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo, 6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null)
				{

					voObj.setOfflineClientDetails(ws);

				} else
				{
					voObj.setOfflineClientDetails(null);
				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientDetailsWithClientPatNo() --> " + e
					.getMessage());
			voObj.setStrMsgType("1");

		} finally
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
	 *           Value Object
	 */
	public static void getOffLineClientPatientDetailsWithCrNo(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strBillNo = voObj.getStrOffLineBillNumber();
		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithCrNo");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber, 1);
			daoObj.setProcInValue(nProcIndex, "clientpatno", "", 2);
			daoObj.setProcInValue(nProcIndex, "clientpatslno", "", 3);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 4);
			daoObj.setProcInValue(nProcIndex, "billNo", strBillNo, 6);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null)
				{

					voObj.setOfflineClientDetails(ws);

				} else
				{
					voObj.setOfflineClientDetails(null);
				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientDetailsWithCrNo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
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
	 *           Value Object
	 */
	public static void getOffLineClientPatientNumber(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		if (strChargeTypeId.equals(""))
			strChargeTypeId = "1";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineClientPatientNumber");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber, 2);
			daoObj.setProcInValue(nProcIndex, "accno", "", 1);
			daoObj.setProcInValue(nProcIndex, "activeAccount", "1", 4);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 3);
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 6);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 7);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 8);

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

						voObj.setStrOffLineClientPatientHidden(ws.getString(25));

					} else
					{
						voObj.setStrOffLineClientPatientHidden("");
					}

					ws.beforeFirst();

					voObj.setAdmissionCancellationDetails(ws);

				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientNumber() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
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
	 *           Value Object
	 */
	public static void getOffLineRefundAdvancePatAccDtls(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_pataccount_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNumber = voObj.getStrCrNo();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strHospCode = voObj.getStrHospitalCode();
		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineRefundAdvancePatAccDtls");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "puk", strCrNumber, 2);
			daoObj.setProcInValue(nProcIndex, "chargetypeid", strChargeTypeId, 3);
			daoObj.setProcInValue(nProcIndex, "accno", "", 1);
			daoObj.setProcInValue(nProcIndex, "activeAccount", "1", 4);
			daoObj.setProcInValue(nProcIndex, "modeval", "3", 5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 6);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 7);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 8);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws != null)
				{
					voObj.setAdmissionCancellationDetails(ws);
				}
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineClientPatientNumber() --> " + e.getMessage());
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
	 * retrieves Off Line Group Combo
	 * 
	 * @param voObj -
	 *           ValueObject
	 */
	public static void getOffLineGroup(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		String strIsPackageWise = voObj.getStrOffLineIsPackageGroup();
		String strProcName = "{call pkg_bill_view.proc_HBLT_HSERVICE_GROUP_MST(?,?,?,?,?,?)}";

		int nProcIndex = 0;

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionOfflineTransDAO.getOffLineGroup");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 1);
			daoObj.setProcInValue(nProcIndex, "charge_id", strChargeTypeId, 2);
			daoObj.setProcInValue(nProcIndex, "pkg_wise_group", strIsPackageWise, 3);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				if (ws != null)
				{

					if (strIsPackageWise.equals("0"))
					{
						voObj.setOfflineGroupList(ws);
					} else
					{
						voObj.setOfflinePackageGroup(ws);
					}

				}

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineGroup() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Off Line Tariff List
	 * 
	 * @param voObj -
	 *           ValueObject
	 */
	public static void getOffLineTariffList(CashCollectionOfflineTransVO voObj)
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;

		String strHospitalCode = voObj.getStrHospitalCode();
		String strGroupId = voObj.getStrOffLineGroup();
		String strChargeTypeId = voObj.getStrOffLineHospitalService();
		//System.out.println("strChargeTypeId"+strChargeTypeId);
		String strCategoryCode = voObj.getStrOffLineTreatmentCategory();
		String strWardCode = voObj.getStrOffLineWard();
		String strPackage = voObj.getStrOffLinePackageIndex();
		String strSearchLetter = voObj.getStrSearchLetter();

		if (strChargeTypeId == null)
			strChargeTypeId = "";
		if (strCategoryCode == null)
			strCategoryCode = "";

		if (strGroupId == null)
			strGroupId = "";
		if (strWardCode == null)
			strWardCode = "";

		if (strPackage == null || strPackage.equals(""))
			strPackage = "0";

		String strErr = "";
		String mode = "1";

		strPackage = "2";

		strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		try
		{
			daoObj = new HisDAO("Billing", "AddServicesIPDTransDAO.getOffLineTariffList");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "chargeTypeId", strChargeTypeId, 1);
			daoObj.setProcInValue(nProcIndex, "catCode", strCategoryCode, 2);
			daoObj.setProcInValue(nProcIndex, "wardCode", strWardCode, 3);
			daoObj.setProcInValue(nProcIndex, "groupId", strGroupId, 4);
			daoObj.setProcInValue(nProcIndex, "searchtrfname", strSearchLetter, 5);
			daoObj.setProcInValue(nProcIndex, "searchMode", "1", 6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 7);
			daoObj.setProcInValue(nProcIndex, "pkg_flag", strPackage, 8);
			daoObj.setProcInValue(nProcIndex, "advance_flag", "1", 9);
			daoObj.setProcInValue(nProcIndex, "modeVal", mode, 10);
			daoObj.setProcInValue(nProcIndex, "end_date", "", 11);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 12);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 13);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (ws != null)
			{
				voObj.setOfflineTariffList(ws);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineTariffList() --> " + e.getMessage());
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
	
	
	public static void getOffLineTariffListByCodeD(CashCollectionOfflineTransVO voObj)
	{
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

		if (strChargeTypeId == null)
			strChargeTypeId = "";
		if (strCategoryCode == null)
			strCategoryCode = "";

		if (strGroupId == null)
			strGroupId = "";
		if (strWardCode == null)
			strWardCode = "";

		String strErr = "";
		String mode = "6";
		strPackage = "2";
		strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineTariffListByCode");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "chargeTypeId", strChargeTypeId, 1);
			daoObj.setProcInValue(nProcIndex, "catCode", strCategoryCode, 2);
			daoObj.setProcInValue(nProcIndex, "wardCode", strWardCode, 3);
			daoObj.setProcInValue(nProcIndex, "groupId", strGroupId, 4);
			daoObj.setProcInValue(nProcIndex, "searchtrfname", strTariffCode, 5);
			daoObj.setProcInValue(nProcIndex, "searchMode", "1", 6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 7);
			daoObj.setProcInValue(nProcIndex, "pkg_flag", strPackage, 8);
			daoObj.setProcInValue(nProcIndex, "advance_flag", "1", 9);
			daoObj.setProcInValue(nProcIndex, "modeVal", mode, 10);
			daoObj.setProcInValue(nProcIndex, "end_date", "", 11);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 12);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 13);

			daoObj.executeProcedureByPosition(nProcIndex);

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
			if (ws != null)
			{
				voObj.setOfflineTariffList(ws);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionOfflineTransDAO.getOffLineTariffListByCode() --> " + e.getMessage());
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
	 * retrieves Off Line Tariff List
	 * 
	 * @param voObj -
	 *           ValueObject
	 */
	public static void getOffLineTariffListByCode(CashCollectionOfflineTransVO voObj)
	{
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

		if (strChargeTypeId == null)
			strChargeTypeId = "";
		if (strCategoryCode == null)
			strCategoryCode = "";

		if (strGroupId == null)
			strGroupId = "";
		if (strWardCode == null)
			strWardCode = "";

		String strErr = "";
		String mode = "3";
		strPackage = "2";
		strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getOffLineTariffListByCode");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "chargeTypeId", strChargeTypeId, 1);
			daoObj.setProcInValue(nProcIndex, "catCode", strCategoryCode, 2);
			daoObj.setProcInValue(nProcIndex, "wardCode", strWardCode, 3);
			daoObj.setProcInValue(nProcIndex, "groupId", strGroupId, 4);
			daoObj.setProcInValue(nProcIndex, "searchtrfname", strTariffCode, 5);
			daoObj.setProcInValue(nProcIndex, "searchMode", "1", 6);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode, 7);
			daoObj.setProcInValue(nProcIndex, "pkg_flag", strPackage, 8);
			daoObj.setProcInValue(nProcIndex, "advance_flag", "1", 9);
			daoObj.setProcInValue(nProcIndex, "modeVal", mode, 10);
			daoObj.setProcInValue(nProcIndex, "end_date", "", 11);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 12);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 13);

			daoObj.executeProcedureByPosition(nProcIndex);

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
			if (ws != null)
			{
				voObj.setOfflineTariffList(ws);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionOfflineTransDAO.getOffLineTariffListByCode() --> " + e.getMessage());
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
	 * retrieves discount approval list
	 * 
	 * @param voObj
	 */
	public static void getOffLineDiscountApprovalList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_consultant_name(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Billing", "CashCollectionTransDAO.getOffLineDiscountApprovalList");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "deptunitCode", "", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", "", 3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next())
				{

					//voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineDiscountApprovedBy(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineDiscountApprovalList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
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
	public static void getOffLineDiscountRemarksList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_hblt_remarks_mst(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strHospCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getOffLineDiscountRemarksList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "rmkstype", "1", 1);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode, 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				if (ws.next())
				{

					//voObj.setStrOffLineWard(ws.getString(1));

					ws.beforeFirst();

				}

				voObj.setOfflineDiscountRemarks(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineDiscountRemarksList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
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
	public static void getOffLineTariffUnitList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_GBLT_UNIT_MST(?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try
		{

			System.out.println(voObj.getStrOffLineTariffUnitTempId());
			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getOffLineTariffUnitList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 1);
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrOffLineTariffUnitTempId(), 2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 3);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setOfflineTariffUnit(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getOffLineTariffUnitList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * retrieves Bill Details based on Cr Number and Charge Type Id.
	 * 
	 * @param voObj -
	 *           Value Object.
	 */
	public static void getBillDetails(CashCollectionOfflineTransVO voObj)
	{
		String proc_name = "";
		proc_name = "{call pkg_bill_view.proc_SBLT_OUTBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO.getBillDetails()");

			/*
			 * System.out.println("cr No : "+voObj.getStrCrNo());
			 * System.out.println("charge Type ;
			 * "+voObj.getStrOffLineHospitalService());
			 */

			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "crNo", voObj.getStrCrNo(), 1);
			dao.setProcInValue(nprocIndex, "to_be_refund_pkg", "1", 2);
			dao.setProcInValue(nprocIndex, "chargeTypeId", voObj.getStrOffLineHospitalService(), 3);
			dao.setProcInValue(nprocIndex, "patListType", "0", 4);
			dao.setProcInValue(nprocIndex, "searchStr", "", 5);
			dao.setProcInValue(nprocIndex, "searchType", "1", 6);
			dao.setProcInValue(nprocIndex, "frmRows", "0", 7);
			dao.setProcInValue(nprocIndex, "toRows", "0", 8);
			dao.setProcInValue(nprocIndex, "modeval", "1", 9);
			dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 10);
			dao.setProcOutValue(nprocIndex, "err", 1, 11);
			dao.setProcOutValue(nprocIndex, "resultset", 2, 12);
			dao.executeProcedureByPosition(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				// System.out.println("ws size is-->"+ws.size());
				voObj.setOfflineBillList(ws);
			} else
			{
				throw new Exception(strErr);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			voObj.setStrMsgString("CashCollectionTransDAO.getBillDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * retrieves Bill Details based on Cr Number and Charge Type Id.
	 * 
	 * @param voObj -
	 *           Value Object.
	 */
	public static void getPartPayBillDetails(CashCollectionOfflineTransVO voObj)
	{
		String proc_name = "";
		proc_name = "{call pkg_bill_view.proc_SBLT_OUTBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		WebRowSet ws = null;

		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO.getPartPayBillDetails()");

			/*
			 * System.out.println("cr No : "+voObj.getStrCrNo());
			 * System.out.println("charge Type ;
			 * "+voObj.getStrOffLineHospitalService());
			 */

			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "crNo", voObj.getStrCrNo(), 1);
			dao.setProcInValue(nprocIndex, "chargeTypeId", voObj.getStrOffLineHospitalService(), 3);
			dao.setProcInValue(nprocIndex, "modeval", "6", 9);
			dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 10);
			dao.setProcInValue(nprocIndex, "to_be_refund_pkg", "1", 2);
			// dao.setProcInValue(nprocIndex, "to_be_refund_pkg", "0");
			dao.setProcInValue(nprocIndex, "searchStr", "", 5);
			dao.setProcInValue(nprocIndex, "patListType", "0", 4);
			dao.setProcInValue(nprocIndex, "searchType", "1", 6);
			dao.setProcInValue(nprocIndex, "frmRows", "0", 7);
			dao.setProcInValue(nprocIndex, "toRows", "0", 8);
			dao.setProcOutValue(nprocIndex, "err", 1, 11); // 1 for string return
			// value
			dao.setProcOutValue(nprocIndex, "resultset", 2, 12); // 2 for object

			// execute procedure
			dao.executeProcedureByPosition(nprocIndex);

			// get value
			strErr = dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				// System.out.println("ws size is-->"+ws.size());
				voObj.setOfflineBillList(ws);
			} else
			{
				throw new Exception(strErr);
			}
		} catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getBillDetails() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * retrieves Tariff Details based on Bill Number.
	 * 
	 * @param voObj -
	 *           Value Object.
	 */
	public static void getTariffDetails_NoAcc(CashCollectionOfflineTransVO voObj)
	{
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_BILL_SERVICE_DTL(?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO.getTariffDetails_NoAcc()");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj.getStrOffLineBillNumber(), 1);
			dao.setProcInValue(nprocIndex, "modeval", "1", 3);
			dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 4);
			dao.setProcInValue(nprocIndex, "to_be_refund_pkg", "1", 2);
			dao.setProcInValue(nprocIndex, "recNo", "0", 5);
			dao.setProcInValue(nprocIndex, "recType", "1", 6);
			dao.setProcOutValue(nprocIndex, "ERR", 1, 7); // 1 for string return
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2, 8); // 2 for object
			dao.executeProcedureByPosition(nprocIndex);
			// get value
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");

				voObj.setOfflineBillTariffList(ws);
			} else
			{
				voObj.setOfflineBillTariffList(null);
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getTariffDetails_NoAcc() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		} finally
		{
			if (dao != null)
			{
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
	public static void getTariffDetails_Acc(CashCollectionOfflineTransVO voObj)
	{
		WebRowSet ws = null;

		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.PROC_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO .getTariffDetails_Acc()");

			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "billNo ", voObj.getStrOffLineBillNumber(), 1);
			dao.setProcInValue(nprocIndex, "accNo ", voObj.getStrOffLineAccountNo(), 2);
			dao.setProcInValue(nprocIndex, "to_be_refund_pkg", "1", 3);
			dao.setProcInValue(nprocIndex, "groupId", "", 4);
			dao.setProcInValue(nprocIndex, "modeval", "1", 5);
			dao.setProcInValue(nprocIndex, "hosp_code", voObj.getStrHospitalCode(), 6);
			dao.setProcInValue(nprocIndex, "recNo", "0", 7);
			dao.setProcInValue(nprocIndex, "recType", "1", 8);
			dao.setProcOutValue(nprocIndex, "ERR", 1, 9); 
			dao.setProcOutValue(nprocIndex, "RESULTSET", 2, 10); 
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "ERR");
			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "RESULTSET");
				voObj.setOfflineBillTariffList(ws);
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getTariffDetails_Acc() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}
	}

	public static void getRequestNoList(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_sblt_inbound_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try
		{

			daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getRequestNoList");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "mode_type", "5", 1);
			daoObj.setProcInValue(nProcIndex, "seatId", "0", 11);
			daoObj.setProcInValue(nProcIndex, "crno", "", 2);
			daoObj.setProcInValue(nProcIndex, "chargeTypeId", "", 3);
			daoObj.setProcInValue(nProcIndex, "patListType", "", 4);
			daoObj.setProcInValue(nProcIndex, "searchStr", "", 5);
			daoObj.setProcInValue(nProcIndex, "searchType", "", 6);
			daoObj.setProcInValue(nProcIndex, "frmRows", "", 7);
			daoObj.setProcInValue(nProcIndex, "toRows", "", 8);
			daoObj.setProcInValue(nProcIndex, "deptCode", "", 10);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 9);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 12);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 13);
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");

				voObj.setStrRequestNoList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getRequestNoList() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
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
	public static void getBillListingDtl_from_OutBound(CashCollectionOfflineTransVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strSearchString = voObj.getStrBillSearchString();

		String strFromRows = voObj.getStrBillFromRow();
		String strToRows = voObj.getStrBillToRow();
		String strModeType = "5";

		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call pkg_bill_view.Proc_Sblt_Outbound_Dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try
		{
			daoObj = new HisDAO("Cash Collection Trans ", "CashCollectionTransDAO.getBillListingDtl_from_OutBound");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", strModeType, 9);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString, 5);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows, 7);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows, 8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 10);
			daoObj.setProcInValue(nProcIndex, "crNo", "", 1);
			daoObj.setProcInValue(nProcIndex, "to_be_refund_pkg", "", 2);
			daoObj.setProcInValue(nProcIndex, "chargeTypeId", "", 3);
			daoObj.setProcInValue(nProcIndex, "patListType", "", 4);
			daoObj.setProcInValue(nProcIndex, "searchType", "", 6);
			daoObj.setProcOutValue(nProcIndex, "ERR", 1, 11);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 12);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "ERR");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setBillSearchList(ws);

			} else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.setPatientListingDtl_from_OutBound() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// Insert Methods

	/**
	 * Inserts Off-line Advance Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflineAdvance(CashCollectionOfflineTransVO voObj,HisDAO dao,boolean daoFireStatus)
	{
		int nAccFlag = 0;
		int nBillFlag = 0;
		int nAppFlag = 0;
		int nInsertedIndex3 = 0;
		int nUpdatedIndex = 0;

		boolean fClientFlag = false;

		String strAccountNo = "0";
		String strBillNo = "0";
		String strAppId = "0";

		String counterId = "0";

		//HisDAO dao = null;

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

		try
		{

			//dao = new HisDAO("BillING", "CashCollectionOfflineTransDAO.insertOfflineAdvance");
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

			HisUtil hisUtil = new HisUtil("Bill Transaction", "CashCollectionTransDAO");

			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			String strTemp = voObj.getStrOffLineEpisode().replace("^", "#").split("#")[0];			
			voObj.setStrOffLineTreatmentCategory(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0]);
			voObj.setStrOffLineEpisode(strTemp);

			// Counter Id Generation.

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open or Retive Existing Account.
			strAccountNo = voObj.getStrOffLineAccountNo();

			if (strAccountNo == null || strAccountNo.equals("0"))
			{
				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());
				pKey.select(dao);
				strAccountNo = pKey.getStrPrimrayKeyValue();
				nAccFlag = 1;
			}

			if (voObj.getStrClientPatientNo().equals(""))
				voObj.setStrClientPatientNo("0");

			/*if (!voObj.getStrClientPatientNo().equals("0"))
			{
				fClientFlag = true;
			}*/
			
			
			/* LOGIC BY AMIT ATERIA. IF CREDIT DETAILS PRESENT THEN ACCOUNT WILL BE OPENED IN NAME OF CLIENT*/
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
				fClientFlag = true;
			
			patAccDao.setStrPatAccNo(strAccountNo);
			String strChargeTypeId =voObj.getStrOffLineHospitalService().replace("^", "#").split("#")[0];
			patAccDao.setStrChargeTypeId(strChargeTypeId);
			/*patAccDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());*/
			//System.out.println("StrChargeTypeId---->"+voObj.getStrOffLineHospitalService());
			patAccDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());
			
			if (fClientFlag) 
			{
				patAccDao.setStrClientPatientNo(strAccountNo);
				patAccDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}
			else
				patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());

			/*if (fClientFlag)
			{
				patAccDao.setStrClientPatientNo(voObj.getStrOffLineClientPatientNo());
				patAccDao.setStrSancAmt(voObj.getStrOffLineSancAmount());
				patAccDao.setStrClientBalance(voObj.getStrOffLineBalanceAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}*/

			patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());

			//patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());LOGIC IMPELEMNTED ABOVE
			patAccDao.setStrPatAccountStatus("1");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			patAccDao.setStrIsValid("1");			
			patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccDao.setStrEntryDate(voObj.getStrAdmissionDate());//SET IN THIS FIELD BECAUSE ENTRY DATE IS SET SYSDATE IN PROCEDURE
			patAccDao.setStrMobileNo(voObj.getStrMobileNo());
			patAccDao.insert(dao);

			/*if (fClientFlag)
			{

				clientPatDao.setStrClientPatNo(voObj.getStrOffLineClientPatientNo());

				clientPatDao.insert(dao);
			}*/

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
			/*if (fClientFlag)
			{
				billDao.setStrClientPatNo(voObj.getStrOffLineClientPatientNo());
				billDao.setStrSancAmt(voObj.getStrOffLineSancAmount());
				billDao.setStrClientBalance(voObj.getStrOffLineBalanceAmount());
			}*/
			
			if (fClientFlag) 
			{
				billDao.setStrClientPatNo(strAccountNo);
				billDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrClientNetAmt(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrPatientNetAmt("0.00");//If Credit category Then 0
			}
			else
				billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
			
			billDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			billDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			billDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			billDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			billDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			//System.out.println("StrOffLineHospitalService---->"+voObj.getStrOffLineHospitalService());
			billDao.setStrPuk(voObj.getStrCrNo());

			billDao.setStrRemarks(voObj.getStrOffLineRemarks());
			//billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());LOGIC IMPELEMNTED ABOVE

			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			//set it in data
			String IpdChargeTypeId=voObj.getStrOffLineWard().replace("^", "#").split("#")[0];
			billDao.setStrIpdChargeTypeId(IpdChargeTypeId);
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());
			billDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			billDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));

			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrOffLineRequestType());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);
			/*if (fClientFlag)
			{
				billReceiptDao.setStrClientPatNo(voObj.getStrOffLineClientPatientNo());
				billReceiptDao.setStrClientBalance(voObj.getStrOffLineBalanceAmount());
			}*/
			
			if (fClientFlag) 
			{
				
				billReceiptDao.setStrClientPatNo(strAccountNo);
				billReceiptDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				billReceiptDao.setStrClientTotAmt(voObj.getStrOfflineTotalRecAmount());
				//If Credit category Then amt paid by patient is zero..whole amt is paid by client..
				billReceiptDao.setStrPatientTAmt("0.00");
			}
			else
				billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());
			
			billReceiptDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			billReceiptDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			billReceiptDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			billReceiptDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			//billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());LOGIC IMPELEMNTED ABOVE

			billReceiptDao.setStrCounterId(counterId);

			if (voObj.getStrChk_value().equals("1"))
			{

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("APPROVAL");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAppId = pKey.getStrPrimrayKeyValue();

				nAppFlag = 1;

				billReceiptDao.setStrApprovalId(strAppId);
				billReceiptDao.setStrApprovedBy(voObj.getStrOffLineApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrCurrentDate());
				billReceiptDao.setStrRemarks(voObj.getStrOffLineRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			billReceiptDao.setStrIpdChargeTypeId(IpdChargeTypeId);
			billReceiptDao.setStrIsOnline("0");
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
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrOffLineTreatmentCategory(),5);
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
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri To Be Check
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[14] ,18);//To Be check
				dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[0],19);
				dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1],20);
				dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1],21);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_limit", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[4],22);
				dao.setProcInValue(nInsertedIndex3, "p_actual_amount", "0",23);
				//CL101^21-JUN-2016^1003^Credit^5000.00^STAFF101^21-JUL-2016^^Daughter^CREDIT LI MIT TWO^21-JUL-2016
				dao.setProcOutValue(nInsertedIndex3, "err", 1,24);
				
				dao.execute(nInsertedIndex3, 1);
			}

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			patAccSerDao.setStrIpdChargeTypeId(IpdChargeTypeId);
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
			patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalRecAmount());
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
			patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccSerDao.insert(dao);
			if(!voObj.getStrOfflineTotalActualTariffAmount().equals("0"))
			{
				patAccSerDao.setStrPatAccountNo(strAccountNo);
				patAccSerDao.setStrReqNo(strBillNo);
				patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				patAccSerDao.setStrTariffId("1090001"); //Surcharge Tariff for Card based payments
				patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
				patAccSerDao.setStrReqType("1");
				patAccSerDao.setStrGroupId("109");
				patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
				patAccSerDao.setStrBServiceId("11");
				patAccSerDao.setStrIpdChargeTypeId(IpdChargeTypeId);
				// patAccSerDao.setStrTariffRate(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
				patAccSerDao.setStrTariffRate(voObj.getStrOfflineTotalActualTariffAmount());
				patAccSerDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
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
				patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
				patAccSerDao.setStrStatus("1");
				// patAccSerDao.setStrNetAmt(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
				patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalActualTariffAmount());
				patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
				
				patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				patAccSerDao.insert(dao);
			}

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(strAccountNo);
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			outBoundDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOfflineTotalRecAmount());
			outBoundDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			outBoundDao.setStrIpdChargeTypeId(IpdChargeTypeId);
			outBoundDao.setStrCounterId(counterId);
			outBoundDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrOffLineRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("0");
			outBoundDao.setStrHospitalCode(voObj.getStrHospitalCode());
			outBoundDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			
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

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{
				nSlNo = nSlNo + 1;
				paymentDao.setStrBillNo(strBillNo);
				if (fClientFlag)
				{
					paymentDao.setStrPaymentMode("10");//CREDIT/CLIENT/CM Relief Fund
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					paymentDao.setStrPaymentDetails((voObj.getStrCreditLetterNo() != null && voObj.getStrCreditLetterNo()[0] != "0") ? voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3] : "");//Client Name
				}
				else
				{
					paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
				}
				/*paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i]);*/
				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null)
				{
					//paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
				} 
				/*else
				{
					paymentDao.setStrPaymentDetails("");
				}*/

				if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} 
				else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("5"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} 
				else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} 
				else
				{
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
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
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
			 * paymentDao.setStrPaymentMode("6"); paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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
			if (voObj.getStrChk_value().equals("1"))
			{

				approvalDao.setStrApprovalId(strAppId);
				approvalDao.setStrApprovalSlNo("1");
				approvalDao.setStrReceiptType("1");
				approvalDao.setStrBServiceId(voObj.getStrOffLineBillingService());
				approvalDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
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

			String proc_name1 = "";

			proc_name1 = "{call PKG_BILL_DML.dml_update_account_dtl(?,?,?,?,?,?,?,?)}";

			int procIndex1 = 0;

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "hosp_code", voObj.getStrHospitalCode(), 2);
			dao.setProcInValue(procIndex1, "accNo", strAccountNo, 3);
			dao.setProcInValue(procIndex1, "wardId", voObj.getStrOffLineSpecialWard(), 4);
			dao.setProcInValue(procIndex1, "ipdChargeTypeId", IpdChargeTypeId, 5);
			dao.setProcInValue(procIndex1, "patCat", voObj.getStrOffLineTreatmentCategory(), 6);
			dao.setProcInValue(procIndex1, "deptId", voObj.getStrOffLineRaisingDepartment(), 7);
			dao.setProcOutValue(procIndex1, "ERR", 1, 8); // 1 for string return
			dao.execute(procIndex1, 1);
			if(daoFireStatus)//If False-Do Not Fire DAO, ELSE Fire DAO
			{
				synchronized (dao)
				{
					dao.fire();
				}
			}

		} catch (Exception e)
		{

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");
			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance() --> BILL_IPD -->" + err);

			if (nAccFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1)
			{

				voObj.setStrBillNo("0");

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

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally
		{
			if(daoFireStatus)//If False-Do Not Fire DAO, ELSE Fire DAO
			{
				if (dao != null)
				{
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
	}

	/**
	 * Inserts Off-line Part Payment Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflinePartPayment(CashCollectionOfflineTransVO voObj)
	{

		int nAccFlag = 0;
		int nBillFlag = 0;
		int nAppFlag = 0;
		int nInsertedIndex3=0;
		int nUpdatedIndex=0;
		boolean fClientFlag = false;

		String strAccountNo = "0";
		String strBillNo = "0";
		String strAppId = "0";

		String counterId = "0";
		// Advance Security Flag added by garima gotra for HIS_PGI_BILL_CR_1 on
		// 17 Aug 2011
		String advSecFlag = "0";
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
		// Added by garima gotra for HIS_PGI_BILL_CR_1 on 18 Aug 2011
		PatientAccountStatusDAO pActStatusDAO = null;
		PatientAccountDAO patAccDao2 = null;

		try
		{

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.insertOfflinePartPayment");
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
			pActStatusDAO = new PatientAccountStatusDAO();
			patAccDao2 = new PatientAccountDAO();

			HisUtil hisUtil = new HisUtil("BillING", "CashCollectionTransDAO");
			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			// Get Counter Id.
			getCounterId(voObj);

			counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open Account
			strAccountNo = voObj.getStrOffLineAccountNo();

			// Added by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug 2011
			advSecFlag = voObj.getadvSecFlag();
			if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals(""))
				fClientFlag = true;

			if (strAccountNo == null || strAccountNo.equals(""))
			{
				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());
				pKey.select(dao);
				strAccountNo = pKey.getStrPrimrayKeyValue();
				nAccFlag = 1;
			}

			if (nAccFlag == 1)
			{
				patAccDao.setStrPatAccNo(strAccountNo);
				patAccDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				patAccDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
				patAccDao.setStrPuk(voObj.getStrCrNo());

				patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
				patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
				patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());

				//patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrPatAccountStatus("2");
				patAccDao.setStrSeatId(voObj.getStrSeatId());
				patAccDao.setStrIsValid("1");
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
				
				
				
				if (fClientFlag) 
				{
					patAccDao.setStrClientPatientNo(strAccountNo);
					patAccDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
					patAccDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
					patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
					patAccDao.setStrRoomLimit(voObj.getStrRoomLimit());
				}
				else
					patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				patAccDao.insert(dao);
			} 
			else
			{
				patAccDao.setStrPatAccNo(strAccountNo);
				//patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
				if (fClientFlag) 
				{
					patAccDao.setStrClientPatientNo(strAccountNo);
					patAccDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
					patAccDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
					patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
					patAccDao.setStrRoomLimit(voObj.getStrRoomLimit());
				}
				else
					patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				patAccDao.update4(dao);

				// Code Change by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug
				// 2011
				if (advSecFlag != null && advSecFlag.equals("1"))
				{
					patAccDao2.setStrPatAccNo(strAccountNo);
					patAccDao2.setStrHospitalCode(voObj.getStrHospitalCode());
					patAccDao2.setStrPatAccountStatus("4");
					patAccDao2.setAdvSecFlag(advSecFlag);
					patAccDao2.update2(dao);
					pActStatusDAO.setStrAppBy(voObj.getStrSeatId());
					pActStatusDAO.setStrPatAccountNo(strAccountNo);
					// 1 stands for active account
					pActStatusDAO.setStrOldStatus("1");
					// 4 stands for Dormant
					pActStatusDAO.setStrNewStatus("4");
					pActStatusDAO.setStrRemarks(voObj.getStrRemarks());
					pActStatusDAO.setStrHospitalCode(voObj.getStrHospitalCode());
					pActStatusDAO.setStrSeatId(voObj.getStrSeatId());
					pActStatusDAO.insert(dao);
				}
				// End of code by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug
				// 2011

			}
			
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
				/*HBLSTR_CREDIT_LETTER_REF_NO^HBLDT_CREDIT_LETTER_DATE^GNUM_COMPANY_CODE^HRGSTR_COMPANY_NAME^HRGNUM_CREDIT_LIMIT^HRGSTR_CARD_NO^HRGNUM_CARD_VALIDUPTO
				^HRGSTR_CARD_HOLDER_NAME^HRGSTR_DEPENDENT_RELATION^HRGSTR_DEPENDENT_NAME^HBLDT_CREDIT_LETTER_VALIDUPTO^GNUM_DEPENDENT_RELATION_CODE*/
				 
				nInsertedIndex3 = dao.setProcedure("{call pkg_reg_dml.dml_hrgt_credit_pat_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?::timestamp without time zone,?,?,?,?::numeric,?,?::timestamp without time zone,?::timestamp without time zone,?::numeric,?::numeric,?)}");
	
				dao.setProcInValue(nInsertedIndex3, "p_modeval", "3",1);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_puk", voObj.getStrCrNo(),2);
				//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", (voObj.getStrClientNo() != null && voObj.getStrClientNo() != "") ? voObj.getStrClientNo() : voObj.getStrPayClientName(),3);
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[2],3);
				dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3],4);//Name
				dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrOffLineTreatmentCategory(),5);
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
				//dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[1],21);
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
			billDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			billDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			billDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			billDao.setStrPuk(voObj.getStrCrNo());

			if (voObj.getStrRemarks() != null && voObj.getStrRemarks().trim().length() > 0)
			{

				billDao.setStrRemarks(voObj.getStrRemarks());

			} else
			{

				billDao.setStrRemarks(voObj.getStrOffLineRemarks());
			}

			//billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
			billDao.setStrStatus("1");
			billDao.setStrSeatId(voObj.getStrSeatId());
			billDao.setStrIsValid("1");
			billDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			billDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
			billDao.setStrHospitalCode(voObj.getStrHospitalCode());
			
			if (fClientFlag) 
			{
				billDao.setStrClientPatNo(strAccountNo);
				billDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrClientNetAmt(voObj.getStrOfflineTotalRecAmount());
				billDao.setStrPatientNetAmt("0.00");//If Credit category Then 0
			}
			else
				billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
			
			
			billDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			billDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			billDao.insert(dao);

			billReceiptDao.setStrBillNo(strBillNo);
			billReceiptDao.setStrReceiptNo("1");
			billReceiptDao.setStrReceiptType(voObj.getStrOffLineRequestType());
			billReceiptDao.setStrPuk(voObj.getStrCrNo());
			billReceiptDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			billReceiptDao.setStrPatAccNo(strAccountNo);

			billReceiptDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			billReceiptDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			billReceiptDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			billReceiptDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			//billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());

			billReceiptDao.setStrCounterId(counterId);

			if (voObj.getStrChk_value().equals("1"))
			{

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("APPROVAL");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAppId = pKey.getStrPrimrayKeyValue();

				nAppFlag = 1;

				billReceiptDao.setStrApprovalId(strAppId);
				billReceiptDao.setStrApprovedBy(voObj.getStrOffLineApprovedBy());
				billReceiptDao.setStrApprovedDate(voObj.getStrCurrentDate());
				// billReceiptDao.setStrRemarks(voObj.getStrOffLineRemarks());
			}
			billReceiptDao.setStrStatus("1");
			billReceiptDao.setStrSeatId(voObj.getStrSeatId());
			billReceiptDao.setStrIsValid("1");
			billReceiptDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			billReceiptDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
			billReceiptDao.setStrIsOnline("0");
			//billReceiptDao.setStrIsBill("0");
			billReceiptDao.setStrIsBill("1");
			billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());

			if (voObj.getStrRemarks() != null && voObj.getStrRemarks().trim().length() > 0)
			{
				billReceiptDao.setStrRemarks(voObj.getStrRemarks());
			}
			
			if (fClientFlag) 
			{
				
				billReceiptDao.setStrClientPatNo(strAccountNo);
				billReceiptDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				billReceiptDao.setStrClientTotAmt(voObj.getStrOfflineTotalRecAmount());
				//If Credit category Then amt paid by patient is zero..whole amt is paid by client..
				billReceiptDao.setStrPatientTAmt("0.00");
			}
			else
				billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());
			
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
			billReceiptDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			billReceiptDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			billReceiptDao.insert(dao);

			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccSerDao.setStrTariffId("0");
			patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId(voObj.getStrGroupId());
			patAccSerDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
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
			// patAccSerDao.setStrIsRefundable("0");
			patAccSerDao.setStrIsRefundable("1");
			patAccSerDao.setStrQtyUnitId(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBillFlag("1");
			patAccSerDao.setStrReceiptNo("1");
			patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLinePartPaymentAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalRecAmount());
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
			patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccSerDao.insert(dao);
			if(!voObj.getStrOfflineTotalActualTariffAmount().equals("0"))
			{
				patAccSerDao.setStrPatAccountNo(strAccountNo);
				patAccSerDao.setStrReqNo(strBillNo);
				patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				patAccSerDao.setStrTariffId("1090001"); //Surcharge Tariff for Card based payments
				patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
				patAccSerDao.setStrReqType("1");
				patAccSerDao.setStrGroupId("109");
				patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
				patAccSerDao.setStrBServiceId("11");
				patAccSerDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
				// patAccSerDao.setStrTariffRate(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
				patAccSerDao.setStrTariffRate(voObj.getStrOfflineTotalActualTariffAmount());
				patAccSerDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
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
				patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
				patAccSerDao.setStrStatus("1");
				// patAccSerDao.setStrNetAmt(String.valueOf(0 -
				// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
				patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalActualTariffAmount());
				patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
				
				patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				patAccSerDao.insert(dao);
			}

			outBoundDao.setStrTransNo(strBillNo);
			outBoundDao.setStrReceiptNo("1");
			outBoundDao.setStrPatAccNo(voObj.getStrOffLineAccountNo());
			outBoundDao.setStrPuk(voObj.getStrCrNo());
			outBoundDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			outBoundDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			outBoundDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
			outBoundDao.setStrTransAmt(voObj.getStrOfflineTotalRecAmount());
			outBoundDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			outBoundDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			outBoundDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
			outBoundDao.setStrCounterId(counterId);
			outBoundDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			outBoundDao.setStrStatus("1");
			outBoundDao.setStrRemarks(voObj.getStrOffLineRemarks());
			outBoundDao.setStrDayEndFlag("0");
			outBoundDao.setStrSeatId(voObj.getStrSeatId());
			outBoundDao.setStrIsValid("1");
			outBoundDao.setStrTransType("1");
			outBoundDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			outBoundDao.setStrIsBill("1");
			outBoundDao.setStrIsOnline("0");
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

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);
				if (fClientFlag)
				{
					paymentDao.setStrPaymentMode("10");//CREDIT/CLIENT/CM Relief Fund
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					//paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
					paymentDao.setStrPaymentDetails((voObj.getStrCreditLetterNo() != null && voObj.getStrCreditLetterNo()[0] != "0") ? voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3] : "");//Client Name
				}
				else
				{
					paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
				}

				paymentDao.setStrRecieptNo("1");
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null)
				{
					//paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
				} 
				/*else
				{
					paymentDao.setStrPaymentDetails("");
				}*/

				if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");
				} 
				else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("5"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");
				} 
				else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} 
				else
				{
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
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
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
			 * paymentDao.setStrPaymentMode("6"); paymentDao.setStrRecieptNo("1");
			 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			 * paymentDao.setStrChargeTypeId(voObj
			 * .getStrOffLineHospitalService()); paymentDao
			 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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

			if (voObj.getStrChk_value().equals("1"))
			{

				approvalDao.setStrApprovalId(strAppId);
				approvalDao.setStrApprovalSlNo("1");
				approvalDao.setStrReceiptType("1");
				approvalDao.setStrBServiceId(voObj.getStrOffLineBillingService());
				approvalDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
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
			synchronized (dao)
			{
				dao.fire();
			}
		} 
		catch (Exception e)
		{
			String err = "err:" + e.getMessage();
			voObj.setStrMsgString("--offline--CashCollectionTransDAO.insertOfflinePartPayment()--> " + err);
			voObj.setStrMsgType("1");
			if (nAccFlag == 1)
			{
				try
				{
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);
				} 
				catch (Exception e1)
				{
					voObj.setStrMsgString("CashCollectionOFFLINETransDAO.insertOfflinePartPayment()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");
				}
			}
			if (nBillFlag == 1)
			{
				voObj.setStrBillNo("0");
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
					voObj.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");
				}
			}
			if (nAppFlag == 1)
			{
				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);
				} 
				catch (Exception e1)
				{
					voObj.setStrMsgString("CashCollectionTransDAO.insertOfflinePartPayment()--> " + e1.getMessage() + "-->" + err);
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
	public static void insertOfflineReceiptServices(CashCollectionOfflineTransVO voObj)
	{
		int nBillFlag = 0;
		int nAppFlag = 0;

		String strBillNo = "0";
		String strDiscAppId = "0";

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;
		int nInsertedIndex3 = 0;
		int nUpdatedIndex = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PaymentDAO paymentDao = null;
		String clientName="";
		PatientAccountDAO pActDao=null;
		try
		{

			dao = new HisDAO("BILLING", "CashCollectionOfflineTransDAO.insertOfflineReceiptServices");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			paymentDao = new PaymentDAO();

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.setStrAppendHospcodeFlag("1");

			if (voObj.getStrOffLineHospitalService().equals("2"))
			{
				pKey.setStrKeyname("BILL_IPD");
			} 
			else
			{
				pKey.setStrKeyname("BILL");
			}

			pKey.select(dao);
			strBillNo = pKey.getStrPrimrayKeyValue();
			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			nInsertedIndex1 = dao.setProcedure("{call pkg_bill_dml.dml_offline_bill(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo, 2);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(), 3);
			/*if (voObj.getStrOfflinePaymentMode()[0].equals("7"))//Payment Mode=Wallet
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrWalletNo(),4);//Wallet No Contains Account No Currently
			else
			    dao.setProcInValue(nInsertedIndex1, "patAccNo", "0", 4); // other than wallet account no 0 beacuse amount is not deducted from wallet
			*/
			
			if (voObj.getStrOfflinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrWalletNo(),4);//Wallet No Contains Account No Currently
			else 
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrOffLineAccountNo(), 4); // Other Than Wallet account no for normal ipd- if opd then pataccno is zero 
			
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(), 5);
			dao.setProcInValue(nInsertedIndex1, "admNo", voObj.getStrOffLineAdmissionNo(), 6);
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj.getStrOffLineEpisode(), 7);
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0], 8);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj.getStrOfflineTotalRecAmount(), 9);
			//System.out.println("valuessssssssssssss"+voObj.getStrOfflineTotalRecAmount());
			dao.setProcInValue(nInsertedIndex1, "clientPaidAmt", voObj.getStrOfflineMaxClientBenefitAmount(), 10);
			dao.setProcInValue(nInsertedIndex1, "patPaidAmt", voObj.getStrOfflinePatNetPayAmount(), 11);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrOfflineTotalActualTariffAmount(), 12);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrOfflineTotalDiscountAmount(), 13);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrOfflineTotalServiceTaxAmount(), 14);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj.getStrOffLineRaisingDepartment(), 15);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrOffLineHospitalService(), 16);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrOffLineSpecialWard(), 17);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrOffLineBillingService(), 18);
			// System.out.println("valuessssssssssssss"+voObj.getStrOffLineClientPatientNo());
			if (voObj.getStrOffLineClientPatientNo() == null || voObj.getStrOffLineClientPatientNo().trim().equalsIgnoreCase(""))
				voObj.setStrOffLineClientPatientNo("0");
			// System.out.println("valuessssssssssssss"+voObj.getStrOffLineClientPatientNo());
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj.getStrOffLineClientPatientNo(), 19);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj.getStrGroupId(), 24);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(), 25);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(), 20);
			dao.setProcInValue(nInsertedIndex1, "moduleId", voObj.getStrModuleId(), 21);
			dao.setProcInValue(nInsertedIndex1, "ipAddr", voObj.getStrIpAddress(), 22);
			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId, 23);
			dao.setProcInValue(nInsertedIndex1, "ipdChargeType_Id", voObj.getStrOffLineWard(), 26);
			//Billed In Credit Category
			
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
						clientName=voObj.getStrCreditLetterNo()[x].replace("^","#").split("#")[2];
						break;						
					}					
				}				
				dao.setProcInValue(nInsertedIndex1, "staff_card_no_id", staffCardNo, 27);
				dao.setProcInValue(nInsertedIndex1, "staff_card_holder_name", staffName, 28);
				dao.setProcInValue(nInsertedIndex1, "relation_with_card_holder", staffRelation, 29);
				dao.setProcInValue(nInsertedIndex1, "card_validity", staffCardValidity, 30);
				dao.setProcInValue(nInsertedIndex1, "credit_bill_status",creditBillStatus,31);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
				dao.setProcInValue(nInsertedIndex1, "credit_bill_flag", creditBillFlag,32);	
				
				/*dao.setProcInValue(nInsertedIndex1, "staff_card_no_id", voObj.getStrEmployeeId(), 27);
				dao.setProcInValue(nInsertedIndex1, "staff_card_holder_name", voObj.getStrEmployeeName(), 28);
				dao.setProcInValue(nInsertedIndex1, "relation_with_card_holder", voObj.getStrRelationId(), 29);
				dao.setProcInValue(nInsertedIndex1, "card_validity", voObj.getStrCurrentDate(), 30);
				dao.setProcInValue(nInsertedIndex1, "credit_bill_status", "2",31);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
				dao.setProcInValue(nInsertedIndex1, "credit_bill_flag", "1",32);*/
			}
			else
			{
				dao.setProcInValue(nInsertedIndex1, "staff_card_no_id", "", 27);
				dao.setProcInValue(nInsertedIndex1, "staff_card_holder_name", "", 28);
				dao.setProcInValue(nInsertedIndex1, "relation_with_card_holder", "", 29);
				dao.setProcInValue(nInsertedIndex1, "card_validity", "", 30);
				dao.setProcInValue(nInsertedIndex1, "credit_bill_status", "",31);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
				dao.setProcInValue(nInsertedIndex1, "credit_bill_flag", "0",32);
			}			
			
			/*if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
			{
				dao.setProcInValue(nInsertedIndex1, "staff_card_no_id", voObj.getStrEmployeeId(), 27);
				dao.setProcInValue(nInsertedIndex1, "staff_card_holder_name", voObj.getStrEmployeeName(), 28);
				dao.setProcInValue(nInsertedIndex1, "relation_with_card_holder", voObj.getStrRelationId(), 29);
				dao.setProcInValue(nInsertedIndex1, "card_validity", voObj.getStrCurrentDate(), 30);
				dao.setProcInValue(nInsertedIndex1, "credit_bill_status", "2",31);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
				dao.setProcInValue(nInsertedIndex1, "credit_bill_flag", "1",32);
			}
			else
			{
				dao.setProcInValue(nInsertedIndex1, "staff_card_no_id", "", 27);
				dao.setProcInValue(nInsertedIndex1, "staff_card_holder_name", "", 28);
				dao.setProcInValue(nInsertedIndex1, "relation_with_card_holder", "", 29);
				dao.setProcInValue(nInsertedIndex1, "card_validity", "", 30);
				dao.setProcInValue(nInsertedIndex1, "credit_bill_status", "",31);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
				dao.setProcInValue(nInsertedIndex1, "credit_bill_flag", "0",32);
			}*/
			//dao.setProcInValue(nInsertedIndex1, "clientId", voObj.getStrPayClientName(), 33);
			dao.setProcInValue(nInsertedIndex1, "clientId", clientName, 33);
			dao.setProcInValue(nInsertedIndex1, "ip", GetNetworkAddress.GetAddress("ip"), 34);
			dao.setProcInValue(nInsertedIndex1, "mac", GetNetworkAddress.GetAddress("mac"), 35);
			dao.setProcOutValue(nInsertedIndex1, "err", 1, 36);
			dao.execute(nInsertedIndex1, 1);
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
							
						 //System.out.println("the value of unique LETTER key is "+clKey);
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
							 	nInsertedIndex3 = dao.setProcedure("{call pkg_reg_dml.dml_hrgt_credit_pat_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?::timestamp without time zone,?,?,?,?::numeric,?,?::timestamp without time zone,?::timestamp without time zone,?::numeric,?::numeric,?)}");
								
								dao.setProcInValue(nInsertedIndex3, "p_modeval", "1",1);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_puk", voObj.getStrCrNo(),2);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrPayClientName(),3);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[2],3);
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[3],4);//Name
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0],5);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : "",6);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[5],6);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : "",7);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9],7);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_seat_id", voObj.getStrSeatId(),8);
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrRelationId() != null && voObj.getStrRelationId() != "") ? "1" : "0",9);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrCreditLetterNo()!= null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != "0") ? "1" : "0",9);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11],10);
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_relation", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[8],11);//Name
								dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_name",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9] ,12);//Patient Name TO BE CHECK
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_district_code", "0",13);//Arogyashri
								//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : "",14);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[6],14);			
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
								dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[14] ,18);//To Be check
								dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[0],19);
								dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],20);
								dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", dt,21);//voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],21);
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
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrPayClientName(),3);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_company_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[2],3);
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_company_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[3],4);//Name
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_patient_cat_code", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0],5);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", (voObj.getStrEmployeeId() != null && voObj.getStrEmployeeId() != "") ? voObj.getStrEmployeeId() : "",6);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[5],6);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", (voObj.getStrEmployeeName() != null && voObj.getStrEmployeeName() != "") ? voObj.getStrEmployeeName() : "",7);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_card_holder_name", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9],7);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_seat_id", voObj.getStrSeatId(),8);
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrRelationId() != null && voObj.getStrRelationId() != "") ? "1" : "0",9);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_is_dependent", (voObj.getStrCreditLetterNo()!= null && voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11] != "0") ? "1" : "0",9);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_dependent_relation_code", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[11],10);
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_relation", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[8],11);//Name
									dao.setProcInValue(nInsertedIndex3, "p_hrgstr_dependent_name",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[9] ,12);//Patient Name TO BE CHECK
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_district_code", "0",13);//Arogyashri
									//dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", (voObj.getStrCardValidity() != null && voObj.getStrCardValidity() != "") ? voObj.getStrCardValidity() : "",14);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_card_validupto", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[6],14);			
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_counter_no", "0",15);//Arogyashri
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_hospital_code", voObj.getStrHospitalCode(),16);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_isvalid", "1",17);
									dao.setProcInValue(nInsertedIndex3, "p_hrgnum_credit_letter_type",voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[14] ,18);//To Be check
									dao.setProcInValue(nInsertedIndex3, "p_hblstr_credit_letter_ref_no", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[0],19);
									dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_date", voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],20);
									dao.setProcInValue(nInsertedIndex3, "p_hbldt_credit_letter_validupto", dt,21);//voObj.getStrCreditLetterNo()[k].replace("^","#").split("#")[1],21);
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
			
			if (voObj.getStrOfflineTariffDetailsHidden() != null)
			{
				for (int i = 0, len = voObj.getStrOfflineTariffDetailsHidden().length; i < len; i++)
				{
					nInsertedIndex2 = dao.setProcedure("{call pkg_bill_dml.dml_offline_bill_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					String[] strTariffDtlsVal = voObj.getStrOfflineTariffDetailsHidden()[i].replace('^', '#').split("#");
					String strTempTariffId = strTariffDtlsVal[0];
					String strTempGroupId = strTariffDtlsVal[1];
					// String strTempTariffRate = strTariffDtlsVal[3];
					String strTempRate;
					/*if(strTariffDtlsVal[17].equals("1"))
						strTempRate = voObj.getStrOfflineTariffRateUnit()[i];
					else
						strTempRate = strTariffDtlsVal[4];*/
					strTempRate= voObj.getStrOfflineTariffRateUnit()[i].replace('/','#').split("#")[0];
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
					String strTrfNetAmt=voObj.getStrOfflineTariffNetAmount()[i];
					String strAmtPaidByClient=voObj.getStrOfflineAmtPaidByClient()[i];
					String strTariffName;
				    if(voObj.getStrOfflineTariffName()[i].contains("- ("))
					    strTariffName=voObj.getStrOfflineTariffName()[i].substring(0, voObj.getStrOfflineTariffName()[i].lastIndexOf("- (")-1);
					else
						strTariffName=voObj.getStrOfflineTariffName()[i];
					if(voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13"))
						strTariffName=strTariffName+"(U)";
				
					dao.setProcInValue(nInsertedIndex2, "modval", "1", 1);
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo, 3);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(), 2);
					dao.setProcInValue(nInsertedIndex2, "recNo", "1", 4);
					//System.out.println("voObj.getStrWalletNo()"+voObj.getStrWalletNo());
					//System.out.println("patAccNo"+voObj.getStrOffLineAccountNo());
					//System.out.println("voObj.getStrOnlinePaymentMode()[0]"+voObj.getStrOfflinePaymentMode()[0]);
					
					
					if (voObj.getStrOfflinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
						dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrWalletNo(),5);//Wallet No Contains Account No Currently
					else 
						dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrOffLineAccountNo(), 5); // Other Than Wallet account no for normal ipd- if opd then pataccno is zero
					     
					dao.setProcInValue(nInsertedIndex2, "puk", voObj.getStrCrNo(), 6);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0], 7);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrOffLineRaisingDepartment(), 8);
					dao.setProcInValue(nInsertedIndex2, "grpId", strTempGroupId, 9);
					dao.setProcInValue(nInsertedIndex2, "trfId", strTempTariffId, 10);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj.getStrOfflineTariffQty()[i], 11);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj.getStrOfflineTariffUnit()[i].replace("^", "#").split("#")[0], 12);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempRate, 13);
					dao.setProcInValue(nInsertedIndex2, "actRate", strTempTariffActualRate, 14);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strUnit, 15);
					dao.setProcInValue(nInsertedIndex2, "serTax", strTempServiceTax, 16);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj.getStrOfflineTariffServiceTaxAmtVal()[i], 17);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", strTrfNetAmt, 18);
					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj.getStrOfflineTariffDiscountAmtVal()[i], 21);
					if (voObj.getStrOfflineTariffDiscountConfigDetails() != null && !voObj.getStrOfflineTariffDiscount()[i].equals("0"))
					{
						String[] strDiscountDtlsValue = voObj.getStrOfflineTariffDiscountConfigDetails()[i].replace(',', '#').split("#");
						String strTempDiscUnit = strDiscountDtlsValue[0];
						String strTempDiscType = strDiscountDtlsValue[1];
						String strTempDiscBy = strDiscountDtlsValue[2];
						String strTempDiscReason = strDiscountDtlsValue[4];
						String strTempDiscDate = strDiscountDtlsValue[5];
						if (!voObj.getStrOfflineTariffDiscount()[i].equals("0"))
						{
							pKey.setStrKeyname("APPROVAL");
							pKey.setStrBlockkey("1");
							pKey.setStrHospCode(voObj.getStrHospitalCode());
							pKey.select(dao);
							strDiscAppId = pKey.getStrPrimrayKeyValue();
							if (!strDiscAppId.equals("") || strDiscAppId != null)
							{
								nAppFlag = 1;
							}
							dao.setProcInValue(nInsertedIndex2, "appId", strDiscAppId, 19);
						} else
						{
							dao.setProcInValue(nInsertedIndex2, "appId", "", 19);
						}
						dao.setProcInValue(nInsertedIndex2, "disUnit", strTempDiscUnit, 20);
						dao.setProcInValue(nInsertedIndex2, "disType", strTempDiscType, 22);
						dao.setProcInValue(nInsertedIndex2, "disBy", strTempDiscBy, 23);
						dao.setProcInValue(nInsertedIndex2, "disReason", strTempDiscReason, 24);
						dao.setProcInValue(nInsertedIndex2, "disDate", strTempDiscDate, 25);
					} 
					else
					{

						dao.setProcInValue(nInsertedIndex2, "appId", "0", 19);
						dao.setProcInValue(nInsertedIndex2, "disUnit", "0", 20);
						dao.setProcInValue(nInsertedIndex2, "disType", "0", 22);
						dao.setProcInValue(nInsertedIndex2, "disBy", "0", 23);
						dao.setProcInValue(nInsertedIndex2, "disReason", "NA", 24);
						dao.setProcInValue(nInsertedIndex2, "disDate", "sysdate", 25);
					}

					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrOffLineHospitalService(), 26);
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj.getStrOffLineSpecialWard(), 27);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrOffLineBillingService(), 28);
					dao.setProcInValue(nInsertedIndex2, "serviceId", strTempServiceId, 29);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId", strTempGTariffId, 30);
					dao.setProcInValue(nInsertedIndex2, "isRefund", strTempIsRefundable, 31);
					dao.setProcInValue(nInsertedIndex2, "isPackage", strTempIsPackage, 32);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(), 33);
					dao.setProcInValue(nInsertedIndex2, "ipdChargeType_Id", voObj.getStrOffLineWard(), 34);
					
					//Billed In Credit Category
					//if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4"))
					if((voObj.getStrCreditPaymentType()[i].equals("11") || voObj.getStrCreditPaymentType()[i].equals("13")))
					{
						//dao.setProcInValue(nInsertedIndex2, "credit_letter_no",voObj.getStrCreditLetterNo()[i],35);
						dao.setProcInValue(nInsertedIndex2, "credit_letter_no",voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[0],35);
						//dao.setProcInValue(nInsertedIndex2, "credit_ref_date", voObj.getStrCreditRefDate1()[i],36);
						dao.setProcInValue(nInsertedIndex2, "credit_ref_date", voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[1],36);
						dao.setProcInValue(nInsertedIndex2, "amt_paid_by_patient","0",37);
						dao.setProcInValue(nInsertedIndex2, "amt_paid_by_client", strAmtPaidByClient,38);
						dao.setProcInValue(nInsertedIndex2, "credit_bill_status", "2",39);//Offline No Approval--0-Not Approved,1-Approved,2-No Apporval Required---//1-Approved,0-Pending,2-Direct(No Approval)
						dao.setProcInValue(nInsertedIndex2, "uploaded_file_path", "",40);
						dao.setProcInValue(nInsertedIndex2, "credit_bill_flag", "1",41);
						//dao.setProcInValue(nInsertedIndex2, "clientId", voObj.getStrPayClientName(), 42);
						dao.setProcInValue(nInsertedIndex2, "clientId", voObj.getStrCreditLetterNo()[i].replace("^","#").split("#")[2], 42);
					}
					else
					{
						dao.setProcInValue(nInsertedIndex2, "credit_letter_no","",35);
						dao.setProcInValue(nInsertedIndex2, "credit_ref_date", "",36);
						dao.setProcInValue(nInsertedIndex2, "amt_paid_by_patient", strTrfNetAmt,37);
						dao.setProcInValue(nInsertedIndex2, "amt_paid_by_client", "0",38);
						dao.setProcInValue(nInsertedIndex2, "credit_bill_status", "0",39);//1-Approved,0-Pending,2-Direct(No Approval)
						dao.setProcInValue(nInsertedIndex2, "uploaded_file_path", "",40);
						dao.setProcInValue(nInsertedIndex2, "credit_bill_flag", "0",41);
						dao.setProcInValue(nInsertedIndex2, "clientId", "0", 42);
					}		
					if(voObj.getStrCreditPaymentType()[i].equals("12") || voObj.getStrCreditPaymentType()[i].equals("13"))
					    dao.setProcInValue(nInsertedIndex2, "urgentFlag","2",43);
					else
						dao.setProcInValue(nInsertedIndex2, "urgentFlag","1",43);
					dao.setProcInValue(nInsertedIndex2, "tariffName",strTariffName,44);
					dao.setProcInValue(nInsertedIndex2, "ip", GetNetworkAddress.GetAddress("ip"), 45);
					dao.setProcInValue(nInsertedIndex2, "mac", GetNetworkAddress.GetAddress("mac"), 46);
					dao.setProcOutValue(nInsertedIndex2, "err", 1, 47);
					dao.execute(nInsertedIndex2, 1);
				}
			}
			
			
			if (voObj.getStrOfflinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
			{
				pActDao = new PatientAccountDAO();
				pActDao.setStrPatAccNo(voObj.getStrWalletNo());				
				pActDao.setStrNetActualAmt(voObj.getStrOfflineTotalRecAmount());
				pActDao.setStrSerTaxNetAmt(voObj.getStrTotalTariffServiceTaxAmount());
				pActDao.setStrTariffNetAmt(voObj.getStrOfflineTotalRecAmount());
				pActDao.setStrHospitalCode(voObj.getStrHospitalCode());
				pActDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				pActDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				//pActDao.setIsBillFinal("0");
				pActDao.update3(dao);
			}	

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{
				//Check Whether Total Tariff Cost is equal to Amount Paid By CLient.Do Not Insert Data If Total Tariff Cost is Paid By Client.
				//System.out.println(Float.parseFloat(voObj.getStrOfflineTotalActualTariffAmount())+":"+Float.parseFloat(voObj.getStrOfflineMaxClientBenefitAmount()));
				if(Float.parseFloat(voObj.getStrOfflineTotalActualTariffAmount())!=(Float.parseFloat(voObj.getStrOfflineMaxClientBenefitAmount())))
				{
					nSlNo = nSlNo + 1;
					paymentDao.setStrBillNo(strBillNo);
	
					paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
					paymentDao.setStrRecieptNo("1");
					paymentDao.setStrSerialNo(String.valueOf(nSlNo));
					paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
					paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());
	
					String payDtl[] = { "", "" };
	
					if (voObj.getStrOfflinePaymentDtls() != null)
					{
						paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
						payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
					} 
					else
					{
						paymentDao.setStrPaymentDetails("");
					}
	
					if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
					{
						paymentDao.setStrPaymentModeNo(payDtl[1]);
						paymentDao.setStrPaymentStatus("0");
	
					} 
					else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("5"))
					{
						paymentDao.setStrPaymentModeNo(payDtl[1]);
						paymentDao.setStrPaymentStatus("0");
	
					} 
					else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
					{
	
						paymentDao.setStrPaymentModeNo(payDtl[0]);
					} 
					else
					{
						paymentDao.setStrPaymentModeNo("");
						paymentDao.setStrPaymentStatus("1");
					}
	
					paymentDao.setStrRecieptType("1");
					/*if(!voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[1].equals("1"))
					{
						paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);
						paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
					}
					else
					{
						paymentDao.setStrRecieptAmount("0");
						paymentDao.setStrNetAmount("0");
					}*/
					
					paymentDao.setStrRecieptAmount(voObj.getStrOfflineAmount()[i]);
					paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
					paymentDao.setStrPuk(voObj.getStrCrNo());
					paymentDao.setStrProcessedBy("0");
					paymentDao.setStrCounterId(strCounterId);
					paymentDao.setStrSeatId(voObj.getStrSeatId());
					paymentDao.setStrIsValid("1");
					paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
					paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
					paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
	
					paymentDao.insert(dao);
				}
			}

			//If any of the amolunt is paid by client then insert it			
			 //if (voObj.getStrOffLineClientPatientNo().length() > 1 && !voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) 
			 if (!voObj.getStrOfflineMaxClientBenefitAmount().equals("0")) 
			 {			 
				 nSlNo = nSlNo + 1;
				 
				 paymentDao.setStrBillNo(strBillNo);
				 
				 paymentDao.setStrPaymentMode("10"); 
				 paymentDao.setStrRecieptNo("1");
				 paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				 paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService()); 
				 paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService()); 
				 //paymentDao.setStrPaymentDetails(voObj.getStrPayClientName());
				 //if (voObj.getStrCreditLetterNo()[0] != null && !voObj.getStrCreditLetterNo()[0].equals("0"))
				 //paymentDao.setStrPaymentDetails(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3]);//CLIENT NAME
				//TO CATER REQ OF VENDOR NAME AND INVOICE NO FOR CMF PATIENTS IN CASE TRF CODE IS 99
				 if (voObj.getStrOfflinePaymentDtls() != null)
				 {
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[0]);
				 } 
				 else
				 {
					if (voObj.getStrCreditLetterNo()[0] != null && !voObj.getStrCreditLetterNo()[0].equals("0"))
						paymentDao.setStrPaymentDetails(voObj.getStrCreditLetterNo()[0].replace("^","#").split("#")[3]);//CLIENT NAME
					else
						paymentDao.setStrPaymentDetails("");
				 }
				 paymentDao.setStrPaymentModeNo(voObj.getStrOffLineClientPatientNo());
				 paymentDao.setStrPaymentStatus("0");
				 paymentDao.setStrRecieptType("1");
				 paymentDao.setStrRecieptAmount(voObj.getStrOfflineMaxClientBenefitAmount());
				 paymentDao.setStrPuk(voObj.getStrCrNo());
				 paymentDao.setStrProcessedBy("0");
				 paymentDao.setStrCounterId(strCounterId);
				 paymentDao.setStrSeatId(voObj.getStrSeatId());
				 paymentDao.setStrHospitalCode(voObj.getStrHospitalCode());
				 paymentDao.setStrNetAmount(voObj.getStrOfflineTotalRecAmount());
				 paymentDao.setStrIsValid("1");
				 paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				 paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
				 
				 paymentDao.insert(dao); 
			}
			

			// Commented as per Change request HIS_PGIMER_Patient Billing_
			// DCD_16Nov11.doc.
			// This is for problem The start day in the bill should be the date
			// of deposit of the advance Payment
			/*
			 * if(voObj.getStrOffLineHospitalService().equals("2")){
			 * 
			 * String proc_name1 = "";
			 * 
			 * proc_name1 = "{call
			 * PKG_BILL_DML.dml_update_account_dtl(?,?,?,?,?,?,?,?)}";
			 * 
			 * int procIndex1 = 0;
			 * 
			 * 
			 * procIndex1 = dao.setProcedure(proc_name1);
			 * 
			 * dao.setProcInValue(procIndex1, "modval", "1");
			 * 
			 * dao.setProcInValue(procIndex1, "hosp_code",
			 * voObj.getStrHospitalCode()); dao.setProcInValue(procIndex1, "accNo",
			 * voObj.getStrOffLineAccountNo()); dao.setProcInValue(procIndex1,
			 * "wardId", voObj.getStrOffLineSpecialWard());
			 * dao.setProcInValue(procIndex1, "ipdChargeTypeId",
			 * voObj.getStrOffLineWard()); dao.setProcInValue(procIndex1, "patCat",
			 * voObj.getStrOffLineTreatmentCategory());
			 * dao.setProcInValue(procIndex1, "deptId",
			 * voObj.getStrOffLineRaisingDepartment());
			 * dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			 * 
			 * dao.execute(procIndex1,1);
			 *  }
			 */

			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{
			e.printStackTrace();
			String err = "err:" + e.getMessage();

			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + err);
			voObj.setStrMsgType("1");

			if (nBillFlag == 1)
			{
				voObj.setStrBillNo("0");

				try
				{

					if (voObj.getStrOffLineHospitalService().equals("2"))
					{
						pKeyLogDao.setStrKeyname("BILL_IPD");
					} else
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

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strDiscAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally
		{

			if (dao != null)
			{
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
	public static void insertOfflineRefundServices(CashCollectionOfflineTransVO voObj)
	{

		int nAppFlag = 0;

		String strAppId = "0";

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PaymentDAO paymentDao = null;

		try
		{

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.insertOfflineRefundServices");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			paymentDao = new PaymentDAO();

			String[] strBillDtls = voObj.getStrOfflineRefundBillDetails().replace("^", "#").split("#");

			String strBillNo = strBillDtls[0];
			// String strTransType = strBillDtls[2];
			String strPatAccNo = strBillDtls[4];
			// String strRequestNo = strBillDtls[5];
			// String strIsBill = strBillDtls[9];
			// String strIsOnline = strBillDtls[10];
			String strAdmissionNo = strBillDtls[11];
			// String strServiceId = strBillDtls[16];

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			voObj.setStrBillNo(strBillNo);

			CashCollectionOfflineTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			pKey.setStrKeyname("APPROVAL");
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.select(dao);

			strAppId = pKey.getStrPrimrayKeyValue();

			if (!strAppId.equals("") || strAppId != null)
			{
				nAppFlag = 1;
			}

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_refund(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo, 3);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(), 2);
			dao.setProcInValue(nInsertedIndex1, "refRecNo", strRefundReceiptNo, 4);
			dao.setProcInValue(nInsertedIndex1, "refAppId", strAppId, 5);
			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj.getStrOfflineRefundDate(), 6);
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj.getStrOffLineRefundBy(), 7);
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj.getStrOffLineRefundReasonText(), 8);
			if (voObj.getStrOfflinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
				dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrWalletNo(),9);//Wallet No Contains Account No Currently						
			else
			    dao.setProcInValue(nInsertedIndex1, "patAccNo", strPatAccNo, 9);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(), 10);
			dao.setProcInValue(nInsertedIndex1, "admNo", strAdmissionNo, 11);
			dao.setProcInValue(nInsertedIndex1, "episodeCode", voObj.getStrOffLineEpisode(), 12);
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0], 13);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj.getStrOfflineTotalRecAmount(), 14);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrOfflineRefundTotalActualTariffAmount(), 15);
			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrOfflineRefundTotalDiscountAmount(), 16);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrOfflineRefundTotalServiceTaxAmount(), 17);
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj.getStrOfflineRefundTotalPenaltyAmount(), 18);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj.getStrOffLineRaisingDepartment(), 19);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrOffLineHospitalService(), 20);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrOffLineWard(), 21);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrOffLineBillingService(), 22);
			dao.setProcInValue(nInsertedIndex1, "clientPatNo", voObj.getStrOffLineClientPatientNo(), 23);
			dao.setProcInValue(nInsertedIndex1, "clientBalAmt", voObj.getStrOffLineBalanceAmount(), 24);
			dao.setProcInValue(nInsertedIndex1, "depGrpId", voObj.getStrGroupId(), 29);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(), 30);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(), 25);
			dao.setProcInValue(nInsertedIndex1, "moduleId", voObj.getStrModuleId(), 26);
			dao.setProcInValue(nInsertedIndex1, "ipAddr", voObj.getStrIpAddress(), 27);
			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId, 28);
			// output value
			dao.setProcOutValue(nInsertedIndex1, "err", 1, 31);
			// keep in batch
			dao.execute(nInsertedIndex1, 1);
			

			if (voObj.getStrBillTariffVal() != null)
				for (int i = 0, len = voObj.getStrBillTariffVal().length; i < len; i++)
				{
					nInsertedIndex2 = dao
							.setProcedure("{call pkg_bill_dml.dml_offline_refund_service(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					String[] strTariffDtlsVal = voObj.getStrBillTariffVal()[i].replace('^', '#').split("#");

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

					dao.setProcInValue(nInsertedIndex2, "modval", "1", 1);
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo, 3);
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(), 2);
					dao.setProcInValue(nInsertedIndex2, "trfRecNo", strTempReceiptNo, 4);
					dao.setProcInValue(nInsertedIndex2, "refRecNo", strRefundReceiptNo, 5);
					if (voObj.getStrOfflinePaymentMode()[0].split("#")[0].equals("7"))//Payment Mode=Wallet
						dao.setProcInValue(nInsertedIndex2, "patAccNo", voObj.getStrWalletNo(),7);//Wallet No Contains Account No Currently						
					else
					    dao.setProcInValue(nInsertedIndex2, "patAccNo", strPatAccNo, 6);
					dao.setProcInValue(nInsertedIndex2, "puk", voObj.getStrCrNo(), 7);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^", "#").split("#")[0], 8);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrOffLineRaisingDepartment(), 9);
					dao.setProcInValue(nInsertedIndex2, "grpId", strTempGroupId, 10);
					dao.setProcInValue(nInsertedIndex2, "trfId", strTempTariffId, 11);
					dao.setProcInValue(nInsertedIndex2, "refQty", voObj.getStrBillTariffRefund()[i], 12);
					dao.setProcInValue(nInsertedIndex2, "refQtyUnitId", voObj.getStrBillTariffUnit()[i].replace("^", "#")
							.split("#")[0], 13);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempTariffRate, 14);
					dao.setProcInValue(nInsertedIndex2, "actRate", strTempActualRate, 15);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strTempRateUnit, 16);
					dao.setProcInValue(nInsertedIndex2, "serTax", strTempServiceTax, 17);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", voObj.getStrOfflineRefundServiceTaxAmount()[i], 18);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj.getStrBillTariffRefundAmount()[i], 19);
					dao.setProcInValue(nInsertedIndex2, "penelty", voObj.getStrBillTariffPenalty()[i], 20);
					dao.setProcInValue(nInsertedIndex2, "penAmt", voObj.getStrOfflineRefundPenaltyAmount()[i], 21);
					dao.setProcInValue(nInsertedIndex2, "disAmt", voObj.getStrOfflineRefundDiscountAmount()[i], 24);
					dao.setProcInValue(nInsertedIndex2, "appId", strTempAppId, 22);
					dao.setProcInValue(nInsertedIndex2, "disUnit", strTempDiscUnit, 23);
					dao.setProcInValue(nInsertedIndex2, "disType", strTempDiscType, 25);
					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrOffLineHospitalService(), 26);
					dao.setProcInValue(nInsertedIndex2, "wardId", voObj.getStrOffLineWard(), 27);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrOffLineBillingService(), 28);
					dao.setProcInValue(nInsertedIndex2, "serviceId", strTempSServiceId, 29);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId", strTempGTariffId, 30);
					dao.setProcInValue(nInsertedIndex2, "isPackage", strTempIsPackage, 31);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(), 32);
					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1, 33);
					dao.execute(nInsertedIndex2, 1);
				}

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null)
				{
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
				} else
				{
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0]
						.equals("5"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
				{

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else
				{
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
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
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
			 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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

			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{

			String err = "err:" + e.getMessage();

			 e.printStackTrace();

			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineRefundServices()--> " + e.getMessage());
			voObj.setStrMsgType("1");

			if (nAppFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{
e1.printStackTrace();
					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally
		{

			if (dao != null)
			{
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
	public static void insertOfflineRefundAdmissionCancellation(CashCollectionOfflineTransVO voObj)
	{

		int nInsertedIndex1 = 0;
		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try
		{

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.insertOfflineRefundAdmissionCancellation");
			paymentDao = new PaymentDAO();

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			CashCollectionOfflineTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_pataccount_close(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(), 2);
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId(), 5);
			dao.setProcInValue(nInsertedIndex1, "billNo", voObj.getStrBillNo(), 3);
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo, 4);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(), 6);
			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj.getStrOfflineRefundDate(), 7);
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj.getStrOffLineRefundBy(), 8);
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj.getStrOffLineRefundReasonText(), 9);
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj.getStrOfflineTotalRecAmount(), 10);
			dao.setProcInValue(nInsertedIndex1, "patAccNo", voObj.getStrOffLineRefundAdvanceAccountNo(), 11);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(), 12);
			dao.setProcInValue(nInsertedIndex1, "penelty", voObj.getStrAdmissionCancellationPenalty(), 13);
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj.getStrRefundAdvancePaneltyAmt(), 14);
			// dao.setProcInValue(nInsertedIndex1, "wardId",
			// voObj.getStrOffLineWard(),15);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrOffLineSpecialWard(), 15);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrOffLineHospitalService(), 16);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrOffLineBillingService(), 17);
			dao.setProcInValue(nInsertedIndex1, "advance_refund", voObj.getStrAdvCancelRefund(), 18);
			dao.setProcInValue(nInsertedIndex1, "acc_cat", voObj.getAccountCategory(), 19);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId, 20);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(), 21);
			dao.setProcInValue(nInsertedIndex1, "str_adm_no", voObj.getStrAdmissionNo(), 22);
			dao.setProcOutValue(nInsertedIndex1, "err", 1, 23);
			dao.execute(nInsertedIndex1, 1);

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(voObj.getStrBillNo());

				paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null)
				{
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
				} else
				{
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0]
						.equals("5"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
				{

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else
				{
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
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
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
			 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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

			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");

			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + err);

		} finally
		{

			if (dao != null)
			{
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	/**
	 * Inserts Offline Refund Advance
	 * 
	 * @param voObj
	 */
	public static void insertOfflineRefundPartPayment(CashCollectionOfflineTransVO voObj)
	{

		int nInsertedIndex1 = 0;
		HisDAO dao = null;

		PaymentDAO paymentDao = null;

		try
		{

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.insertOfflineRefundAdmissionCancellation");
			paymentDao = new PaymentDAO();

			String[] strBillDtls = voObj.getStrOfflineRefundBillDetails().replace("^", "#").split("#");

			String strBillNo = strBillDtls[0];
			String strPatAccNo = strBillDtls[4];
			voObj.setStrBillNo(strBillNo);

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			CashCollectionOfflineTransDAO.getRefundReceiptNo(voObj);

			String strRefundReceiptNo = voObj.getStrRefundReceiptNo();

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_offline_partpayment_refund(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(), 2);
			dao.setProcInValue(nInsertedIndex1, "grpId", voObj.getStrGroupId(), 5);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo, 3);
			dao.setProcInValue(nInsertedIndex1, "recNo", strRefundReceiptNo, 4);
			dao.setProcInValue(nInsertedIndex1, "defUnitId", voObj.getStrQtyUnitId(), 6);
			dao.setProcInValue(nInsertedIndex1, "refundDate", voObj.getStrOfflineRefundDate(), 7);
			dao.setProcInValue(nInsertedIndex1, "refundBy", voObj.getStrOffLineRefundBy(), 8);
			dao.setProcInValue(nInsertedIndex1, "refundReason", voObj.getStrOffLineRefundReasonText(), 9);
			dao.setProcInValue(nInsertedIndex1, "refundAmt", voObj.getStrOfflineTotalRecAmount(), 10);
			dao.setProcInValue(nInsertedIndex1, "patAccNo", strPatAccNo, 11);
			dao.setProcInValue(nInsertedIndex1, "puk", voObj.getStrCrNo(), 12);
			dao.setProcInValue(nInsertedIndex1, "penelty", voObj.getStrAdmissionCancellationPenalty(), 13);
			dao.setProcInValue(nInsertedIndex1, "penAmt", voObj.getStrRefundAdvancePaneltyAmt(), 14);
			dao.setProcInValue(nInsertedIndex1, "wardId", voObj.getStrOffLineWard(), 15);
			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrOffLineHospitalService(), 16);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrOffLineBillingService(), 17);
			dao.setProcInValue(nInsertedIndex1, "counterId", strCounterId, 18);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(), 19);
			dao.setProcOutValue(nInsertedIndex1, "err", 1, 20);
			dao.execute(nInsertedIndex1, 1);

			// Payment Details

			int nSlNo = 0;
			int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

			for (int i = 0; i < nPaymentLenght; i++)
			{

				nSlNo = nSlNo + 1;

				paymentDao.setStrBillNo(strBillNo);

				paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrRecieptNo(strRefundReceiptNo);
				paymentDao.setStrSerialNo(String.valueOf(nSlNo));
				paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
				paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

				String payDtl[] = { "", "" };

				if (voObj.getStrOfflinePaymentDtls() != null)
				{
					paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
					payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
				} else
				{
					paymentDao.setStrPaymentDetails("");
				}

				if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0]
						.equals("5"))
				{
					paymentDao.setStrPaymentModeNo(payDtl[1]);
					paymentDao.setStrPaymentStatus("0");

				} else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
				{

					paymentDao.setStrPaymentModeNo(payDtl[0]);
				} else
				{
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
				paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
				paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
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
			 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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

			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");

			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + err);

		} finally
		{

			if (dao != null)
			{
				dao.free();
				dao = null;
			}

			paymentDao = null;
		}

	}

	/**
	 * executes the BILL_MST.getCounterDtl() by passing Module Id, IP Address,
	 * Hospital Code and Mode 1. which generates the Counter and set to Value
	 * Object's counterId.
	 * 
	 * @param voObj -
	 *           Value Object
	 */
	public static void getCounterId(CashCollectionOfflineTransVO voObj)
	{

		String strCounterId = "";
		String strMode = "1";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.getCounterDtl(?,?,?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO .getCounterId()");

			nfuncIndex = dao.setFunction(strFunc);
			
			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrModuleId());
			//dao.setFuncInValue(nfuncIndex, 3, voObj.getStrIpAddress());
			dao.setFuncInValue(nfuncIndex, 3, GetNetworkAddress.GetAddress("ip"));
			dao.setFuncInValue(nfuncIndex, 4, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 5, strMode);
			dao.setFuncOutValue(nfuncIndex, 1);

			dao.executeFunction(nfuncIndex);

			strCounterId = dao.getFuncString(nfuncIndex);
			//System.out.println("strCounterId"+strCounterId);

			voObj.setStrCounterId(strCounterId);

		} catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getCounterId() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}

	}

	public static void getRefundReceiptNo(CashCollectionOfflineTransVO voObj)
	{

		String strRefundReceiptNo = "";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.get_refund_receiptno(?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO .getRefundReceiptNo()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 3, voObj.getStrBillNo());
			dao.setFuncOutValue(nfuncIndex, 3);

			dao.executeFuncForNumeric(nfuncIndex);
			strRefundReceiptNo = dao.getFuncNumeric(nfuncIndex);

			voObj.setStrRefundReceiptNo(strRefundReceiptNo);

		} catch (Exception e)
		{

			voObj.setStrMsgString("CashCollectionTransDAO.getRefundReceiptNo() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * Inserts Off-line Advance Details
	 * 
	 * @param voObj
	 */
	public static CashCollectionOfflineTransVO openZeroBalanceAccount(CashCollectionOfflineTransVO voObj)
	{

		int nAccFlag = 0;
		int nBillFlag = 0;
		int nAppFlag = 0;

		boolean fClientFlag = false;

		String strAccountNo = "0";
		String strBillNo = "0";
		String strAppId = "0";

		//String counterId = "0";

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;
		PatientAccountDAO patAccDao = null;

		try
		{

			dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.openZeroBalanceAccount");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();
			patAccDao = new PatientAccountDAO();

			HisUtil hisUtil = new HisUtil("Bill Transaction", "CashCollectionTransDAO");

			voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));

			String strTemp = voObj.getStrOffLineEpisode().replace("^", "#").split("#")[0];

			voObj.setStrOffLineEpisode(strTemp);

			// Counter Id Generation.

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			//counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			// Open or Retive Existing Account.
			strAccountNo = voObj.getStrOffLineAccountNo();

			if (strAccountNo == null || strAccountNo.equals("0"))
			{

				pKey.setStrBlockkey("1");
				pKey.setStrKeyname("ACCOUNT");
				pKey.setStrHospCode(voObj.getStrHospitalCode());

				pKey.select(dao);

				strAccountNo = pKey.getStrPrimrayKeyValue();

				nAccFlag = 1;

			}

			voObj.setStrOffLineAccountNo(strAccountNo);

			if (voObj.getStrClientPatientNo().equals(""))
				voObj.setStrClientPatientNo("0");

			if (!voObj.getStrClientPatientNo().equals("0"))
			{
				fClientFlag = true;
			}

			patAccDao.setStrPatAccNo(strAccountNo);
			patAccDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());

			if (fClientFlag)
			{
				patAccDao.setStrClientPatientNo(voObj.getStrOffLineClientPatientNo());
				patAccDao.setStrSancAmt("0");
				patAccDao.setStrClientBalance("0");
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}

			patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
			// seting amount to 0 for opening zero balance account
			patAccDao.setStrPatRecdAmt("0");
			patAccDao.setStrPatAccountStatus("1");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			patAccDao.setStrIsValid("1");

			patAccDao.insert(dao);

			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{

			String err = "err:" + e.getMessage();

			voObj.setStrMsgType("1");
			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance() --> BILL_IPD -->" + err);

			if (nAccFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("ACCOUNT");
					pKeyLogDao.setStrStartkey(strAccountNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}
			if (nBillFlag == 1)
			{

				voObj.setStrBillNo("0");

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

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineAdvance()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally
		{

			if (dao != null)
			{
				dao.free();
				dao = null;
			}

			if (pKey != null)
				pKey = null;
			if (pKeyLogDao != null)
				pKeyLogDao = null;
			if (patAccDao != null)
				patAccDao = null;

		}
		return voObj;
	}
	
	
	
	
	
	
	public   void getWaivedBy(CashCollectionOfflineTransVO vo) 
	{
		HisUtil hisutil = null;
		WebRowSet w1;
		WebRowSet w2;
		String str2 = null;
		String str1 = null;
		
		try 
		{
			hisutil = new HisUtil("transaction", "CashCollectionOfflineTransDAO");
			
			w2 = getWaiverBy(vo);
			w1=  getRelations(vo);
			
			if (w2 != null && w2.size() > 0) 
			{
				str1 = hisutil.getOptionValue(w2, "0", "0^Select Value", true);
			} 
			else 
			{
				str1 = "";
			}
			
			if (w1 != null && w1.size() > 0) 
			{
				str2 = hisutil.getOptionValue(w1, "0", "0^Select Value", true);
			} 
			else 
			{
				str2 = "";
			}
			
			//waiver by field..
			vo.setStrRmk(str1);
			vo.setStrRelationWs(str2);
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CreditBillApprovalTransDAO.getWaivedBy() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally
		{
			w2=null;
		}
	}
	
	public WebRowSet getWaiverBy(CashCollectionOfflineTransVO vo) 
	{
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_SIMPLE_VIEW.PROC_CONSULTANT_NAME(?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		
		try 
		{
			dao = new HisDAO("billing","transactions.CreditBillApprovalTransDAO .getWaiverBy()");
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "deptunitCode", "0",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
			dao.setProcInValue(nprocIndex, "seatId", vo.getStrSeatId(),3);			
			dao.setProcOutValue(nprocIndex, "err", 1,4);
			dao.setProcOutValue(nprocIndex, "resultset", 2,5);
			
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");
			
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CashCollectionOfflineTransDAO.getWaiverBy() --> "+ e.getMessage());
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
		return ws;
	}
	
	
	
	
	
	
	public WebRowSet getRelations(CashCollectionOfflineTransVO vo) 
	{
		WebRowSet ws = null;
		String proc_name = "";
		proc_name = "{call PKG_BILL_VIEW.proc_get_relations(?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strErr = "";
		
		try 
		{
			dao = new HisDAO("Billing","transactions.CashCollectionOfflineTransDAO .getRelations()");
			nprocIndex = dao.setProcedure(proc_name);
			
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcOutValue(nprocIndex, "err", 1,2);
			dao.setProcOutValue(nprocIndex, "resultset", 2,3);
			
			dao.executeProcedureByPosition(nprocIndex);
			strErr = dao.getString(nprocIndex, "err");
			
			if (strErr == null)
				strErr = "";
			ws = dao.getWebRowSet(nprocIndex, "resultset");
		} 
		catch (Exception e) 
		{
			//e.printStackTrace();
			vo.setStrMsgString("CashCollectionOfflineTransDAO.getRelations() --> "+ e.getMessage());
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
		return ws;
	}
	
	public static void getAdmEpisodeTreatmentCatDtl(CashCollectionOfflineTransVO voObj) throws Exception
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_simple_view.proc_HRGT_EPISODE_DTL(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strDeptCode = voObj.getStrOffLineRaisingDepartment();//Last Visited Department
		String strCrNo = voObj.getStrCrNo();

		String strErr = "";

		try
		{
			daoObj = new HisDAO("Billing", "CashCollectionOfflineTransDAO.getAdmEpisodeTreatmentCatDtl");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "deptCode", strDeptCode, 2);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo, 3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals(""))
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				voObj.setAdmEpisodeTreatCatDeptDtls(ws);
								
				if(ws.size()==0)
				{
					voObj.setStrMsgString("No Open Episode Found for This Patient");
					voObj.setStrMsgType("2");
					throw new Exception("No Open Episode Found for This Patient");
				}
				else
				{
					if(ws.next())
					{
						voObj.setStrOffLineRaisingDepartment(ws.getString(1));
						voObj.setStrOffLineEpisode(ws.getString(2));
						voObj.setStrOffLineTreatmentCategory(ws.getString(4)+"^"+ws.getString(5));
						voObj.setStrTreatmentCategory(ws.getString(4));
						voObj.setStrOffLineSpecialWard(ws.getString(7));
						voObj.setStrChargeTypeId(ws.getString(9));
						ws.beforeFirst();
					}
				}
			} 
			else
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e)
		{
			if(voObj.getStrMsgType().equals("2"))
			{
				voObj.setStrMsgString("No Open Episode Found for This Patient");
				throw new Exception("No Open Episode Found for This Patient");
			}
			else
			{
				voObj.setStrMsgString("CashCollectionTransDAO.getAdmEpisodeTreatmentCatDtl() --> " + e.getMessage());
				voObj.setStrMsgType("1");
				throw new Exception("CashCollectionTransDAO.getAdmEpisodeTreatmentCatDtl() --> " + e.getMessage());
			}
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
	 * retrieves unit list based on unit id and hospital code
	 * 
	 * @param voObj
	 */
	public static void getCreditLettersList(CashCollectionOfflineTransVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_credit_letters_list(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		// String strHospitalCode = voObj.getStrHospitalCode();

		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Billing","CashCollectionOfflineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "puk", voObj.getStrCrNo(),2);
			daoObj.setProcInValue(nProcIndex, "catcode", voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0],3);//SENT FROM JS FUNCTION AND SET IN VO	
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
			voObj.setStrMsgString("CashCollectionOfflineTransDAO.getCreditLettersList() --> "+ e.getMessage());
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
	 * Inserts Off-line Receipt Services Details
	 * 
	 * @param voObj
	 */
	public static void insertOfflineEstimation(CashCollectionOfflineTransVO voObj)
	{
		int nBillFlag = 0;
		int nAppFlag = 0;

		String strBillNo = "0";
		String strDiscAppId = "0";

		int nInsertedIndex1 = 0;
		int nInsertedIndex2 = 0;

		HisDAO dao = null;

		PrimaryKeyDAO pKey = null;
		PrimaryKeyLogDAO pKeyLogDao = null;

		try
		{

			dao = new HisDAO("BILLING", "CashCollectionOfflineTransDAO.insertOfflineReceiptServices");
			pKey = new PrimaryKeyDAO();
			pKeyLogDao = new PrimaryKeyLogDAO();

			// Bill Generation
			pKey.setStrBlockkey("1");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.setStrAppendHospcodeFlag("1");
			pKey.setStrKeyname("ESTIMATION_REQ_NO");

			pKey.select(dao);
			strBillNo = pKey.getStrPrimrayKeyValue();
			voObj.setStrBillNo(strBillNo);

			nBillFlag = 1;

			CashCollectionOfflineTransDAO.getCounterId(voObj);

			String strCounterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

			nInsertedIndex1 = dao
					.setProcedure("{call pkg_bill_dml.dml_estimation_without_crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			
			dao.setProcInValue(nInsertedIndex1, "modval", "2",1);
			dao.setProcInValue(nInsertedIndex1, "billNo", strBillNo,2);
			dao.setProcInValue(nInsertedIndex1, "prevCrNo", voObj.getStrCrNo(),4);
			dao.setProcInValue(nInsertedIndex1, "hosp_code", voObj.getStrHospitalCode(),3);
			dao.setProcInValue(nInsertedIndex1, "patName", "",5);
			dao.setProcInValue(nInsertedIndex1, "patAddress", "",6);
			dao.setProcInValue(nInsertedIndex1, "patContactNo", "",7);
			
			dao.setProcInValue(nInsertedIndex1, "age", "",22);
			dao.setProcInValue(nInsertedIndex1, "ageUnit", "",23);
			dao.setProcInValue(nInsertedIndex1, "refDoctor", "",24);
			dao.setProcInValue(nInsertedIndex1, "genderCode", "",25);	
			
			dao.setProcInValue(nInsertedIndex1, "refDocContactNo", "",26);
			
			dao.setProcInValue(nInsertedIndex1, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0],8);
			dao.setProcInValue(nInsertedIndex1, "netAmt", voObj.getStrOfflineTotalRecAmount(),9);
			dao.setProcInValue(nInsertedIndex1, "actTrfCost", voObj.getStrOfflineTotalActualTariffAmount(),10);

			dao.setProcInValue(nInsertedIndex1, "disAmt", voObj.getStrOfflineTotalDiscountAmount(),11);
			dao.setProcInValue(nInsertedIndex1, "serTaxAmt", voObj.getStrOfflineTotalServiceTaxAmount(),12);
			dao.setProcInValue(nInsertedIndex1, "deptCode", voObj.getStrOffLineRaisingDepartment(),13);

			dao.setProcInValue(nInsertedIndex1, "chargeTypeId", voObj.getStrOffLineHospitalService(),14);
			dao.setProcInValue(nInsertedIndex1, "bServiceId", voObj.getStrOffLineBillingService(),15);
			dao.setProcInValue(nInsertedIndex1, "counter_id", strCounterId,17);
			dao.setProcInValue(nInsertedIndex1, "seatId", voObj.getStrSeatId(),16);
			dao.setProcInValue(nInsertedIndex1, "prevCrDtlFlag", voObj.getStrPreviousCrNoDtlFlag(),27);
			
			dao.setProcInValue(nInsertedIndex1, "reqNo", "",18);
			dao.setProcInValue(nInsertedIndex1, "reqDate", "",19);
			dao.setProcInValue(nInsertedIndex1, "gblReqNo", "",20);
			dao.setProcInValue(nInsertedIndex1, "serviceId","",21);
			
			dao.setProcOutValue(nInsertedIndex1, "err", 1,28);

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
							.setProcedure("{call pkg_bill_dml.dml_estimation_tariff_without_crno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					
					dao.setProcInValue(nInsertedIndex2, "modval", "2",1);
					dao.setProcInValue(nInsertedIndex2, "billNo", strBillNo,3);
					
					dao.setProcInValue(nInsertedIndex2, "prevCrNo", voObj.getStrPreviousCrNo(),29);
					
					dao.setProcInValue(nInsertedIndex2, "hosp_code", voObj.getStrHospitalCode(),2);
					dao.setProcInValue(nInsertedIndex2, "catCode", voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[0],4);
					dao.setProcInValue(nInsertedIndex2, "deptCode", voObj.getStrOffLineRaisingDepartment(),5);
					dao.setProcInValue(nInsertedIndex2, "grpId",strTempGroupId,6);
					dao.setProcInValue(nInsertedIndex2, "trfId",strTempTariffId,7);
					dao.setProcInValue(nInsertedIndex2, "billQty", voObj.getStrOfflineTariffQty()[i],8);
					dao.setProcInValue(nInsertedIndex2, "billQtyUnitId", voObj.getStrOfflineTariffUnit()[i].replace("^", "#")
							.split("#")[0],9);
					dao.setProcInValue(nInsertedIndex2, "rate", strTempRate,10);
					dao.setProcInValue(nInsertedIndex2, "actRate",strTempTariffActualRate,11);
					dao.setProcInValue(nInsertedIndex2, "rateUnitId", strUnit,12);
					dao.setProcInValue(nInsertedIndex2, "serTax",strTempServiceTax,13);
					dao.setProcInValue(nInsertedIndex2, "serTaxAmt", "0",14);
					dao.setProcInValue(nInsertedIndex2, "trfNetAmt", voObj.getStrOfflineTariffNetAmount()[i],15);

					dao.setProcInValue(nInsertedIndex2, "disAmt", "0",18);
					dao.setProcInValue(nInsertedIndex2, "appId", "0",16);
					dao.setProcInValue(nInsertedIndex2, "disUnit", "0",17);
					dao.setProcInValue(nInsertedIndex2, "disType", "",19);
					dao.setProcInValue(nInsertedIndex2, "disBy", "",20);
					dao.setProcInValue(nInsertedIndex2, "disReason", "",21);
					dao.setProcInValue(nInsertedIndex2, "disDate", "",22);
					dao.setProcInValue(nInsertedIndex2, "chargeTypeId", voObj.getStrOffLineHospitalService(),23);
					dao.setProcInValue(nInsertedIndex2, "bServiceId", voObj.getStrOffLineBillingService(),24);
					dao.setProcInValue(nInsertedIndex2, "serviceId",strTempServiceId,25);
					dao.setProcInValue(nInsertedIndex2, "gblTrfId",	strTempGTariffId,26);
					dao.setProcInValue(nInsertedIndex2, "isRefund",	strTempIsRefundable,27);
					dao.setProcInValue(nInsertedIndex2, "seatId", voObj.getStrSeatId(),28);

					dao.setProcInValue(nInsertedIndex2, "reqNo", "",30);
					
					// output value
					dao.setProcOutValue(nInsertedIndex2, "err", 1,31);

					dao.execute(nInsertedIndex2, 1);
				}
			synchronized (dao)
			{
				dao.fire();
			}

		} catch (Exception e)
		{
			 e.printStackTrace();
			String err = "err:" + e.getMessage();

			voObj.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + err);
			voObj.setStrMsgType("1");

			if (nBillFlag == 1)
			{

				voObj.setStrBillNo("0");

				try
				{

					pKeyLogDao.setStrKeyname("ESTIMATION_REQ_NO");

					pKeyLogDao.setStrStartkey(strBillNo);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

			if (nAppFlag == 1)
			{

				try
				{
					pKeyLogDao.setStrKeyname("APPROVAL");
					pKeyLogDao.setStrStartkey(strDiscAppId);
					pKeyLogDao.setStrBlockkey("1");
					pKeyLogDao.setStrError(err);
					pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
					pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
					// Calling Insert Method of Primary Key Log
					pKeyLogDao.insert(dao);

				} catch (Exception e1)
				{

					voObj
							.setStrMsgString("CashCollectionTransDAO.insertOfflineReceiptServices()--> " + e1.getMessage() + "-->" + err);
					voObj.setStrMsgType("1");

				}

			}

		} finally
		{

			if (dao != null)
			{
				dao.free();
				dao = null;
			}

			pKey = null;
			pKeyLogDao = null;
		}

	}
	public static void getWalletDetails(CashCollectionOfflineTransVO voObj) 
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
	public static void getBillingPackageNames(CashCollectionOfflineTransVO vo) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_bill_view.proc_hblt_package_mst(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try 
		{
			
			daoObj = new HisDAO("Billing","CashCollectionOfflineTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code",vo.getStrHospitalCode(), 1);
			daoObj.setProcInValue(nProcIndex, "ward_id", vo.getStrOffLineWard(), 2);//here ipd chargetypeid is passed to get package cost
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 3);
			daoObj.setProcInValue(nProcIndex, "catcode", vo.getStrOffLineTreatmentCategory(), 4);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 6);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				vo.setPackageComboValuesWs(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("CashCollectionTransDAO.getBillingPackageNames() --> "+ e.getMessage());
			vo.setStrMsgType("1");
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
	public static void insertOfflinePackage(CashCollectionOfflineTransVO voObj) 
	{
	int nAccFlag = 0;
	int nBillFlag = 0;
	int nAppFlag = 0;
	int nInsertedIndex3=0;
	boolean fClientFlag = false;

	String strAccountNo = "0";
	String strBillNo = "0";
	String strAppId = "0";

	String counterId = "0";
	// Advance Security Flag added by garima gotra for HIS_PGI_BILL_CR_1 on
	// 17 Aug 2011
	String advSecFlag = "0";
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
	// Added by garima gotra for HIS_PGI_BILL_CR_1 on 18 Aug 2011
	PatientAccountStatusDAO pActStatusDAO = null;
	PatientAccountDAO patAccDao2 = null;

	try
	{

		dao = new HisDAO("Bill Transaction", "CashCollectionTransDAO.insertOfflinePartPayment");
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
		pActStatusDAO = new PatientAccountStatusDAO();
		patAccDao2 = new PatientAccountDAO();

		HisUtil hisUtil = new HisUtil("BillING", "CashCollectionTransDAO");
		voObj.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
		// Get Counter Id.
		getCounterId(voObj);

		counterId = voObj.getStrCounterId().replace("^", "#").split("#")[0];

		// Open Account
		strAccountNo = voObj.getStrOffLineAccountNo();

		// Added by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug 2011
		advSecFlag = voObj.getadvSecFlag();
		//if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals("")) //commented due to no logic of credit letter no in package
		if(voObj.getStrOffLineTreatmentCategoryGroup().equals("3") || voObj.getStrOffLineTreatmentCategoryGroup().equals("4"))
			fClientFlag = true;

		if (strAccountNo == null || strAccountNo.equals(""))
		{
			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("ACCOUNT");
			pKey.setStrHospCode(voObj.getStrHospitalCode());
			pKey.select(dao);
			strAccountNo = pKey.getStrPrimrayKeyValue();
			nAccFlag = 1;
		}

		if (nAccFlag == 1)
		{
			patAccDao.setStrPatAccNo(strAccountNo);
			patAccDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccDao.setStrPuk(voObj.getStrCrNo());

			patAccDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
			patAccDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
			patAccDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());

			//patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
			patAccDao.setStrPatAccountStatus("2");
			patAccDao.setStrSeatId(voObj.getStrSeatId());
			patAccDao.setStrIsValid("1");
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			
			
			if (fClientFlag) 
			{
				patAccDao.setStrClientPatientNo(strAccountNo);
				patAccDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}
			else
				patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
			patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccDao.insert(dao);
		} 
		else
		{
			patAccDao.setStrPatAccNo(strAccountNo);
			//patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
			patAccDao.setStrHospitalCode(voObj.getStrHospitalCode());
			if (fClientFlag) 
			{
				patAccDao.setStrClientPatientNo(strAccountNo);
				patAccDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
				patAccDao.setStrClientPatBoundDt(voObj.getStrCurrentDate());
			}
			else
				patAccDao.setStrPatRecdAmt(voObj.getStrOfflineTotalRecAmount());
			patAccDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccDao.update4(dao);

			// Code Change by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug
			// 2011
			if (advSecFlag != null && advSecFlag.equals("1"))
			{
				patAccDao2.setStrPatAccNo(strAccountNo);
				patAccDao2.setStrHospitalCode(voObj.getStrHospitalCode());
				patAccDao2.setStrPatAccountStatus("4");
				patAccDao2.setAdvSecFlag(advSecFlag);
				patAccDao2.update2(dao);
				pActStatusDAO.setStrAppBy(voObj.getStrSeatId());
				pActStatusDAO.setStrPatAccountNo(strAccountNo);
				// 1 stands for active account
				pActStatusDAO.setStrOldStatus("1");
				// 4 stands for Dormant
				pActStatusDAO.setStrNewStatus("4");
				pActStatusDAO.setStrRemarks(voObj.getStrRemarks());
				pActStatusDAO.setStrHospitalCode(voObj.getStrHospitalCode());
				pActStatusDAO.setStrSeatId(voObj.getStrSeatId());
				pActStatusDAO.insert(dao);
			}
			// End of code by garima gotra for HIS_PGI_BILL_CR_1 on 17 Aug
			// 2011

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
		billDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
		billDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
		billDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
		billDao.setStrPuk(voObj.getStrCrNo());

		if (voObj.getStrRemarks() != null && voObj.getStrRemarks().trim().length() > 0)
		{

			billDao.setStrRemarks(voObj.getStrRemarks());

		} else
		{

			billDao.setStrRemarks(voObj.getStrOffLineRemarks());
		}

		//billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
		billDao.setStrStatus("1");
		billDao.setStrSeatId(voObj.getStrSeatId());
		billDao.setStrIsValid("1");
		billDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
		billDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
		billDao.setStrHospitalCode(voObj.getStrHospitalCode());
		
		if (fClientFlag) 
		{
			billDao.setStrClientPatNo(strAccountNo);
			billDao.setStrSancAmt(voObj.getStrOfflineTotalRecAmount());
			billDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
			billDao.setStrClientNetAmt(voObj.getStrOfflineTotalRecAmount());
			billDao.setStrPatientNetAmt("0.00");//If Credit category Then 0
		}
		else
			billDao.setStrPatientNetAmt(voObj.getStrOfflineTotalRecAmount());
		
		
		billDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
		billDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
		billDao.insert(dao);

		billReceiptDao.setStrBillNo(strBillNo);
		billReceiptDao.setStrReceiptNo("1");
		billReceiptDao.setStrReceiptType(voObj.getStrOffLineRequestType());
		billReceiptDao.setStrPuk(voObj.getStrCrNo());
		billReceiptDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
		billReceiptDao.setStrPatAccNo(strAccountNo);

		billReceiptDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
		billReceiptDao.setStrBServiceId(voObj.getStrOffLineBillingService());
		billReceiptDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
		billReceiptDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
		//billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());

		billReceiptDao.setStrCounterId(counterId);

		if (voObj.getStrChk_value().equals("1"))
		{

			pKey.setStrBlockkey("1");
			pKey.setStrKeyname("APPROVAL");
			pKey.setStrHospCode(voObj.getStrHospitalCode());

			pKey.select(dao);

			strAppId = pKey.getStrPrimrayKeyValue();

			nAppFlag = 1;

			billReceiptDao.setStrApprovalId(strAppId);
			billReceiptDao.setStrApprovedBy(voObj.getStrOffLineApprovedBy());
			billReceiptDao.setStrApprovedDate(voObj.getStrCurrentDate());
			// billReceiptDao.setStrRemarks(voObj.getStrOffLineRemarks());
		}
		billReceiptDao.setStrStatus("1");
		billReceiptDao.setStrSeatId(voObj.getStrSeatId());
		billReceiptDao.setStrIsValid("1");
		billReceiptDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
		billReceiptDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
		billReceiptDao.setStrIsOnline("0");
		billReceiptDao.setStrIsBill("0");
		billReceiptDao.setStrHospitalCode(voObj.getStrHospitalCode());

		if (voObj.getStrRemarks() != null && voObj.getStrRemarks().trim().length() > 0)
		{
			billReceiptDao.setStrRemarks(voObj.getStrRemarks());
		}
		
		if (fClientFlag) 
		{
			
			billReceiptDao.setStrClientPatNo(strAccountNo);
			billReceiptDao.setStrClientBalance(voObj.getStrOfflineTotalRecAmount());
			billReceiptDao.setStrClientTotAmt(voObj.getStrOfflineTotalRecAmount());
			//If Credit category Then amt paid by patient is zero..whole amt is paid by client..
			billReceiptDao.setStrPatientTAmt("0.00");
		}
		else
			billReceiptDao.setStrPatientTAmt(voObj.getStrOfflineTotalRecAmount());
		
		if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals("") &&!voObj.getStrCreditLetterNo()[0].equals("0"))
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
		billReceiptDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
		billReceiptDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
		billReceiptDao.insert(dao);

		patAccSerDao.setStrReqDate(voObj.getStrPackAppDate());
		patAccSerDao.setStrPatAccountNo(strAccountNo);
		patAccSerDao.setStrReqNo(strBillNo);
		patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
		patAccSerDao.setStrTariffId("0");
		patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
		patAccSerDao.setStrReqType("1");
		patAccSerDao.setStrGroupId(voObj.getStrGroupId());
		patAccSerDao.setStrBServiceId("20");
		patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
		patAccSerDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
		// patAccSerDao.setStrTariffRate(String.valueOf(0 -
		// Integer.parseInt(voObj.getStrAdvanceAmount())));
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
		patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
		patAccSerDao.setStrStatus("1");
		// patAccSerDao.setStrNetAmt(String.valueOf(0 -
		// Integer.parseInt(voObj.getStrAdvanceAmount())));
		patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalRecAmount());
		patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
		patAccSerDao.setStrIsPackage(voObj.getStrPackageApply().replace("^", "#").split("#")[0]);
		
		if(voObj.getStrCreditLetterNo()!=null && voObj.getStrCreditLetterNo()[0]!=null && !voObj.getStrCreditLetterNo()[0].equals("") &&!voObj.getStrCreditLetterNo()[0].equals("0"))
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
		patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
		patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
		patAccSerDao.insert(dao);
		if(!voObj.getStrOfflineTotalActualTariffAmount().equals("0"))
		{
			patAccSerDao.setStrPatAccountNo(strAccountNo);
			patAccSerDao.setStrReqNo(strBillNo);
			patAccSerDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			patAccSerDao.setStrTariffId("1090001"); //Surcharge Tariff for Card based payments
			patAccSerDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
			patAccSerDao.setStrReqType("1");
			patAccSerDao.setStrGroupId("109");
			patAccSerDao.setStrRateUnitCode(voObj.getStrQtyUnitId());
			patAccSerDao.setStrBServiceId("11");
			patAccSerDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
			// patAccSerDao.setStrTariffRate(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
			patAccSerDao.setStrTariffRate(voObj.getStrOfflineTotalActualTariffAmount());
			patAccSerDao.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
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
			patAccSerDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
			patAccSerDao.setStrStatus("1");
			// patAccSerDao.setStrNetAmt(String.valueOf(0 -
			// Integer.parseInt(voObj.getStrOffLineAdvanceAmount())));
			patAccSerDao.setStrNetAmt(voObj.getStrOfflineTotalActualTariffAmount());
			patAccSerDao.setStrHospitalCode(voObj.getStrHospitalCode());
			
			patAccSerDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			patAccSerDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));
			patAccSerDao.insert(dao);
		}

		outBoundDao.setStrTransNo(strBillNo);
		outBoundDao.setStrReceiptNo("1");
		outBoundDao.setStrPatAccNo(voObj.getStrOffLineAccountNo());
		outBoundDao.setStrPuk(voObj.getStrCrNo());
		outBoundDao.setStrAdmNo(voObj.getStrOffLineAdmissionNo());
		outBoundDao.setStrEpisodeCode(voObj.getStrOffLineEpisode());
		outBoundDao.setStrPatientCatCode(voObj.getStrOffLineTreatmentCategory());
		outBoundDao.setStrTransAmt(voObj.getStrOfflineTotalRecAmount());
		outBoundDao.setStrDeptCode(voObj.getStrOffLineRaisingDepartment());
		outBoundDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
		outBoundDao.setStrIpdChargeTypeId(voObj.getStrOffLineWard());
		outBoundDao.setStrCounterId(counterId);
		outBoundDao.setStrBServiceId(voObj.getStrOffLineBillingService());
		outBoundDao.setStrStatus("1");
		outBoundDao.setStrRemarks(voObj.getStrOffLineRemarks());
		outBoundDao.setStrDayEndFlag("0");
		outBoundDao.setStrSeatId(voObj.getStrSeatId());
		outBoundDao.setStrIsValid("1");
		outBoundDao.setStrTransType("1");
		outBoundDao.setStrWardCode(voObj.getStrOffLineSpecialWard());
		outBoundDao.setStrIsBill("1");
		outBoundDao.setStrIsOnline("0");
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

		// Payment Details

		int nSlNo = 0;
		int nPaymentLenght = voObj.getStrOfflinePaymentMode().length;

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
				paymentDao.setStrPaymentMode(voObj.getStrOfflinePaymentMode()[i].split("#")[0]);
				paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
			}

			paymentDao.setStrRecieptNo("1");
			paymentDao.setStrSerialNo(String.valueOf(nSlNo));
			paymentDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
			paymentDao.setStrBServiceId(voObj.getStrOffLineBillingService());

			String payDtl[] = { "", "" };

			if (voObj.getStrOfflinePaymentDtls() != null)
			{
				//paymentDao.setStrPaymentDetails(voObj.getStrOfflinePaymentDtls()[i]);
				payDtl = voObj.getStrOfflinePaymentDtls()[i].replace(",", "#").split("#");
			} 
			/*else
			{
				paymentDao.setStrPaymentDetails("");
			}*/

			if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("2") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("3"))
			{
				paymentDao.setStrPaymentModeNo(payDtl[1]);
				paymentDao.setStrPaymentStatus("0");
			} 
			else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("4") || voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("5"))
			{
				paymentDao.setStrPaymentModeNo(payDtl[1]);
				paymentDao.setStrPaymentStatus("0");
			} 
			else if (voObj.getStrOfflinePaymentMode()[i].split("#")[0].equals("10"))
			{
				paymentDao.setStrPaymentModeNo(payDtl[0]);
			} 
			else
			{
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
			paymentDao.setStripadd(GetNetworkAddress.GetAddress("ip"));
			paymentDao.setStrmacadd(GetNetworkAddress.GetAddress("mac"));

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
		 * paymentDao.setStrPaymentMode("6"); paymentDao.setStrRecieptNo("1");
		 * paymentDao.setStrSerialNo(String.valueOf(nSlNo));
		 * paymentDao.setStrChargeTypeId(voObj
		 * .getStrOffLineHospitalService()); paymentDao
		 * .setStrBServiceId(voObj.getStrOffLineBillingService()); paymentDao
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

		if (voObj.getStrChk_value().equals("1"))
		{

			approvalDao.setStrApprovalId(strAppId);
			approvalDao.setStrApprovalSlNo("1");
			approvalDao.setStrReceiptType("1");
			approvalDao.setStrBServiceId(voObj.getStrOffLineBillingService());
			approvalDao.setStrChargeTypeId(voObj.getStrOffLineHospitalService());
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
		synchronized (dao)
		{
			dao.fire();
		}
	} 
	catch (Exception e)
	{
		String err = "err:" + e.getMessage();
		voObj.setStrMsgString("--offline--CashCollectionTransDAO.insertOfflinePackage()--> " + err);
		voObj.setStrMsgType("1");
		if (nAccFlag == 1)
		{
			try
			{
				pKeyLogDao.setStrKeyname("ACCOUNT");
				pKeyLogDao.setStrStartkey(strAccountNo);
				pKeyLogDao.setStrBlockkey("1");
				pKeyLogDao.setStrError(err);
				pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
				pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
				// Calling Insert Method of Primary Key Log
				pKeyLogDao.insert(dao);
			} 
			catch (Exception e1)
			{
				voObj.setStrMsgString("CashCollectionOFFLINETransDAO.insertOfflinePackage()--> " + e1.getMessage() + "-->" + err);
				voObj.setStrMsgType("1");
			}
		}
		if (nBillFlag == 1)
		{
			voObj.setStrBillNo("0");
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
				voObj.setStrMsgString("CashCollectionTransDAO.insertOfflinePackage()--> " + e1.getMessage() + "-->" + err);
				voObj.setStrMsgType("1");
			}
		}
		if (nAppFlag == 1)
		{
			try
			{
				pKeyLogDao.setStrKeyname("APPROVAL");
				pKeyLogDao.setStrStartkey(strAppId);
				pKeyLogDao.setStrBlockkey("1");
				pKeyLogDao.setStrError(err);
				pKeyLogDao.setStrHospCode(voObj.getStrHospitalCode());
				pKeyLogDao.setStrSeatid(voObj.getStrSeatId());
				// Calling Insert Method of Primary Key Log
				pKeyLogDao.insert(dao);
			} 
			catch (Exception e1)
			{
				voObj.setStrMsgString("CashCollectionTransDAO.insertOfflinePackage()--> " + e1.getMessage() + "-->" + err);
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
	public static void getpataccno(CashCollectionOfflineTransVO voObj)
	{

		String accno = "";

		String strFunc = "";
		strFunc = "{? = call BILL_MST.get_pat_accountno(?,?,?)}";
		HisDAO dao = null;
		int nfuncIndex = 0;

		try
		{
			dao = new HisDAO("billing", "transactions.CashCollectionTransDAO .getpataccno()");

			nfuncIndex = dao.setFunction(strFunc);

			dao.setFuncInValue(nfuncIndex, 2, voObj.getStrHospitalCode());
			dao.setFuncInValue(nfuncIndex, 3, "2");
			dao.setFuncInValue(nfuncIndex, 4, voObj.getStrCrNo());
			dao.setFuncOutValue(nfuncIndex, 3);

			dao.executeFuncForNumeric(nfuncIndex);
			accno = dao.getFuncNumeric(nfuncIndex);

			voObj.setStrOffLineAccountNo(accno);
		

		} catch (Exception e)
		{
			voObj.setStrMsgString("CashCollectionTransDAO.getpataccno() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}

	}
	
	public static void getAdvanceDtls(CashCollectionOfflineTransVO vo) {
		// TODO Auto-generated method stub
		
		
		
			
			
			
			HisDAO daoObj = null;
			WebRowSet ws = null;

			String strProcName = "{call pkg_bill_view.proc_adv_dtls(?,?,?,?,?,?)}";
			int nProcIndex = 0;
				String strErr = "";
				try{
					daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getSplWardList");

					nProcIndex = daoObj.setProcedure(strProcName);

					daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
					daoObj.setProcInValue(nProcIndex, "hospcode", vo.getStrHospitalCode(), 2);
					daoObj.setProcInValue(nProcIndex, "crno", vo.getStrCrNo(), 3);
					daoObj.setProcInValue(nProcIndex, "accno", vo.getStrOffLineAccountNo(),4);
					daoObj.setProcOutValue(nProcIndex, "err", 1, 5);
					daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 6);

					daoObj.executeProcedureByPosition(nProcIndex);

					strErr = daoObj.getString(nProcIndex, "err");

					if (strErr == null)
						strErr = "";

					if (strErr.equals(""))
					{

						ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
						//ws.size();
						vo.setAdvanceDtls(ws);
						//vo.getAdvanceDtls().size();

					} else
					{
						throw new Exception(strErr);
					}
				
				
				
				
				
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("CashCollectionTransDAO.getAdvanceDtls() --> " + e.getMessage());
			vo.setStrMsgType("1");
			
		}finally
		{
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}

		}
		
	}

	public static void getAccountCategory(CashCollectionOfflineTransVO vo) {
		// TODO Auto-generated method stub
		
		
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_acount_cat_list(?,?,?,?)}";
		int nProcIndex = 0;
			String strErr = "";
			try{
			
			
			
			
			
			


				daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getSplWardList");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
				daoObj.setProcInValue(nProcIndex, "hospcode", vo.getStrHospitalCode(), 2);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 3);
				daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2, 4);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals(""))
				{

					ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
					
					vo.setAccCatWs(ws);

				} else
				{
					throw new Exception(strErr);
				}
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("CashCollectionTransDAO.getAccountCategory() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}finally
		{
		
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void insertOnlyCatChange(CashCollectionOfflineTransVO vo) {
		// TODO Auto-generated method stub
		
		
		
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_dml.proc_acc_cat_cahnge(?,?,?,?,?)}";
		int nProcIndex = 0;
			String strErr = "";
			try{
			
			
			
			
			
			


				daoObj = new HisDAO("Cash Collection Transaction", "CashCollectionTransDAO.getSplWardList");

				nProcIndex = daoObj.setProcedure(strProcName);

				daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
				daoObj.setProcInValue(nProcIndex, "hospcode", vo.getStrHospitalCode(), 2);
				daoObj.setProcInValue(nProcIndex, "acc_no", vo.getStrOffLineAccountNo(), 3);
				daoObj.setProcInValue(nProcIndex, "cat", vo.getAccountCategory(), 4);
				daoObj.setProcOutValue(nProcIndex, "err", 1, 5);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				if (strErr.equals(""))
				{
					vo.setStrMsgType("1");
				} else
				{
					throw new Exception(strErr);
				}
			
			
			
			
			
			
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			vo.setStrMsgString("CashCollectionTransDAO.getAccountCategory() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}finally
		{
		
			if (daoObj != null)
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
}
