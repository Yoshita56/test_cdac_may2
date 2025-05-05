package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ApprovalDtlHlpVO;

/**
 * @author Amit Kumar
 * Date of Creation : 4/6/2009
 * Date of Modification :  /  / 2009
 * Version : 1.0
 * Module  : Store
 * Description : ApprovalDtlHLPDAO file used globally to get approval data
 * from database on the basis of Level 
 * Here we Use Two Level 
 * Level 1 :  Pass From Store Id in PKG_MMS_VIEW.proc_approval_dtl(?????????)
 * Level 2 :  Pass To Store Id   in PKG_MMS_VIEW.proc_approval_dtl(?????????)
 */

public class ApprovalDtlHlpDAO 
{
    /**
     * @param voObj
     */
	public static void getLevelOneDtl(ApprovalDtlHlpVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_approval_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex   = 0;
        String strErr    = "";
        String strReqNo  = voObj.getStrReqNo();
     	try 
     	{
     		daoObj = new HisDAO("Approval Detail HLP","DAOApprovalDtlHlp");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strReqNo != null && !strReqNo.equals("")) 
			{
				System.out.println("<<--------------PKG_MMS_VIEW.proc_approval_dtl-[ Mode - 1 ]------------>>");
				
				daoObj.setProcInValue(nProcIndex, "modeval","1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospCode(),2);
				daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrFrmStoreId(),3);
				daoObj.setProcInValue(nProcIndex, "catNo", voObj.getStrItemCatgCode(),4);
				daoObj.setProcInValue(nProcIndex, "reqTypeId", voObj.getStrReqTypeId(),5);
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrReqNo(),6);
				daoObj.setProcInValue(nProcIndex, "levelType", "1",7);
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);
             	daoObj.executeProcedureByPosition(nProcIndex);
                 
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex,"resultset");
				//System.out.println("Size Level 1->>"+ws.size());
				if (strErr.equals("")) 
				{

					voObj.setGblWs1(ws);

				} 
				else
				{
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ApprovalDtlHlpDAO.setPatientDtl() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getLevelTwoDtl(ApprovalDtlHlpVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_approval_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex   = 0;
        String strErr    = "";
        String strReqNo  = voObj.getStrReqNo();
     	try 
     	{
     		daoObj = new HisDAO("Approval Detail HLP","DAOApprovalDtlHlp");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strReqNo != null && !strReqNo.equals("")) 
			{

				System.out.println("<<---------getLevelTwoDtl()-----PKG_MMS_VIEW.proc_approval_dtl-[ Mode - 1 ]------------>>");
				
				daoObj.setProcInValue(nProcIndex, "modeval","1",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospCode(),2);
				daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrToStoreId(),3);
				daoObj.setProcInValue(nProcIndex, "catNo", voObj.getStrItemCatgCode(),4);
				daoObj.setProcInValue(nProcIndex, "reqTypeId", voObj.getStrReqTypeId(),5);
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrReqNo(),6);
				daoObj.setProcInValue(nProcIndex, "levelType", "2",7);
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex,"resultset");
				//System.out.println("Level 2->>"+ws.size());
				if (strErr.equals("")) 
				{

					voObj.setGblWs2(ws);

				} 
				else
				{
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ApprovalDtlHlpDAO.setPatientDtl() --> "
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
     * @param voObj
     */
	public static void getPreTechApprovalDtl(ApprovalDtlHlpVO voObj) 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PURCHASE_INTERFACE.proc_pretech_approval_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex   = 0;
        String strErr    = "";
        String strReqNo  = voObj.getStrReqNo();
     	try 
     	{
     		daoObj = new HisDAO("Approval Detail HLP","ApprovalDtlHlpDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strReqNo != null && !strReqNo.equals("")) 
			{
				System.out.println("<<---------getPreTechApprovalDtl()-----PURCHASE_INTERFACE.proc_pretech_approval_dtl-[ Mode - 1 ]------------>>");
				
				daoObj.setProcInValue(nProcIndex, "modeval","1",1);
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrReqNo(),2);
				daoObj.setProcInValue(nProcIndex, "strId", voObj.getStrFrmStoreId(),3);
				daoObj.setProcInValue(nProcIndex, "reqTypeId", voObj.getStrReqTypeId(),4);
				daoObj.setProcInValue(nProcIndex, "hosp_code",voObj.getStrHospCode(),5);
				daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId(),6);
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,8);
             	daoObj.executeProcedureByPosition(nProcIndex);
                 
				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex,"resultset");
				
				if (strErr.equals("")) 
				{

					voObj.setGblWs3(ws);

				} 
				else
				{
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ApprovalDtlHlpDAO.setPatientDtl() --> "
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
	 * Gets the approval dtl.
	 * 
	 * @param voObj the vo obj
	 * @return the approval dtl
	 */
	public static void getApprovalDtl(ApprovalDtlHlpVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call PKG_MMS_VIEW.proc_approval_dtl(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		String strReqNo = voObj.getStrReqNo();
		try {
			daoObj = new HisDAO("Approval Detail HLP", "DAOApprovalDtlHlp");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strReqNo != null && !strReqNo.equals("")) 
			{
                System.out.println("voObj.getStrReqStatus()--Approval HLP Approval Dtl-->"+voObj.getStrReqStatus());
                System.out.println("voObj.getStrFrmStoreId()---->"+voObj.getStrFrmStoreId());
                System.out.println("voObj.getStrReqNo()---->"+voObj.getStrReqNo());
                
				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode());
				daoObj.setProcInValue(nProcIndex, "strid", voObj.getStrFrmStoreId());
				daoObj.setProcInValue(nProcIndex, "transNo", voObj.getStrReqNo());
				daoObj.setProcInValue(nProcIndex, "reqStatus", (voObj.getStrReqStatus()==null||voObj.getStrReqStatus().equals(""))?"1":voObj.getStrReqStatus());
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null) {
					strErr = "";
				}

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				// System.out.println("Size Level 1->>"+ws.size());
				if (strErr.equals("")) {

					voObj.setGblWs1(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("ApprovalDtlHlpDAO.getApprovalDtl() --> " + e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	
}
