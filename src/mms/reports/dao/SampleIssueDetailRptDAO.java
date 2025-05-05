package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.SampleIssueDetailRptVO;
import mms.transactions.vo.SampleSentTransVO;


public class SampleIssueDetailRptDAO 
{
	/**
	 * for getting option value of Lab Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getLabNameCmb(SampleIssueDetailRptVO vo)
	{
		String strProcName = "{call pkg_mms_view.proc_Lab_list(?,?,?,?,?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("Sample Issue Details","SampleIssueDetailRptDAO");
			
			hisutil    = new HisUtil("mms", "SampleSentTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "seatid", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			String str;
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, "0","0^Select Value", true);
					vo.setStrLabNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>Select Value</option>";  
					vo.setStrLabNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("SampleIssueDetailRptDAO.getLabNameCmb() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	

}
