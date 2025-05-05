package billing;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

public class DAOProUnProUnitList 
{
	/**
	 * retrieves unit list based on unit id and hospital code
	 * @param voObj
	 */
	public static void getTariffUnitList(BillingVO voObj)
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
       
		String strProcName = "{call pkg_bill_view.proc_GBLT_UNIT_MST(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		String strUnitCombo = "";
	 	HisUtil hisutil = new HisUtil("transaction", "DAOProcessUnProcessDtl");

		try {

			daoObj = new HisDAO("Billing","IpdBillManagementTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrValue3(),1);
			daoObj.setProcInValue(nProcIndex, "unit_id", voObj.getStrValue2(),2);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",3);
			daoObj.setProcOutValue(nProcIndex, "err", 1,4);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,5);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) 
			{
				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
				strUnitCombo = hisutil.getOptionValue(ws, "", "", true);
			 	voObj.setStrValue4(strUnitCombo+"<option value='0'>Others</option>");
			 //	System.out.println("strUnitCombo->"+strUnitCombo);
			} 
			else
			{
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("IpdBillManagementTransDAO.getOffLineTariffUnitList() --> "
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
