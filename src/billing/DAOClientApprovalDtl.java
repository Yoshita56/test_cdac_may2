package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOClientApprovalDtl
{
	////////////////////////Client Approval Details With Puk No //////////////
	public static void setApprovalDtl_Puk(BillingVO voObj)
    {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

	    String strPukNum     = voObj.getStrValue1();
	    String strChrgTypeId = voObj.getStrValue2();
	    String strHospCode   = voObj.getStrValue3();
		try {
			daoObj = new HisDAO("ApprovalDtl_Puk Ws",
					"DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strPukNum != null && !strPukNum.equals("")) {

				daoObj.setProcInValue(nProcIndex, "puk", strPukNum);
				daoObj.setProcInValue(nProcIndex, "chargetypeid", strChrgTypeId);
				daoObj.setProcInValue(nProcIndex, "modeval", "1");
				daoObj.setProcInValue(nProcIndex, "hosp_code",strHospCode);
				daoObj.setProcOutValue(nProcIndex,"err", 1);
				daoObj.setProcOutValue(nProcIndex,"resultset", 2);

				daoObj.executeProcedure(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) {

					voObj.setGblWs1(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAObilling.setApprovalDtl_Puk() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
    ////////////////////////Client Approval Details With APPLICATION NO //////////////
	public static void setApprovalDtl_AppNo(BillingVO voObj)
    {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_bill_view.proc_hblt_client_patient_dtl(?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCltPatNum  = voObj.getStrValue1();
     	String strChrgTypeId = voObj.getStrValue2();
     	String strHospCode   = voObj.getStrValue3();

		try {
			daoObj = new HisDAO("ApprovalDtl_Puk Ws",
					"DAObilling");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCltPatNum != null && !strCltPatNum.equals(""))
			{
				daoObj.setProcInValue( nProcIndex, "puk",voObj.getStrValue2(),1);
				daoObj.setProcInValue( nProcIndex, "clientpatno", strCltPatNum,2);
				daoObj.setProcInValue( nProcIndex, "clientpatslno", "",3);
                daoObj.setProcInValue( nProcIndex, "chargetypeid", strChrgTypeId,4);
				daoObj.setProcInValue( nProcIndex, "modeval", "1",5);
				daoObj.setProcInValue( nProcIndex, "billno", "",6);
                daoObj.setProcInValue( nProcIndex, "hosp_code", strHospCode,7);
				daoObj.setProcOutValue(nProcIndex, "err", 1,8);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,9);

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
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOClientApprovalDtl.setApprovalDtl_AppNo() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
		
}
