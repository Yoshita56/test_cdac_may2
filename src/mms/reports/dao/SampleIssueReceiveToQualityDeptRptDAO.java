package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.reports.vo.SampleIssueReceiveToQualityDeptRptVO;


public class SampleIssueReceiveToQualityDeptRptDAO 
{
	/**
	 * for getting option value of DDW Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDDWList(
			SampleIssueReceiveToQualityDeptRptVO voObj) {
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		HisUtil hisutil =null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj=new HisDAO("dwh","SampleIssueReceiveToQualityDeptRptVO");
			
			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id","0"); 
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				//System.out.println("getDDWList size :"+ws.size());
		
				if(ws!=null && ws.size()>0)
				{
					voObj.setWrsStoreNameCombo(ws);
				}	
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			e.printStackTrace();
			voObj
					.setStrMsgString("SampleIssueReceiveToQualityDeptRptDAO.getDDWList() --> "
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
