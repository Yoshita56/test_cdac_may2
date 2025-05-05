package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.EmployeeDetailRptVO;



public class EmployeeDetailRptDAO 
{
	/**
	 * for getting option value of Lab Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDistrictNameCmb(EmployeeDetailRptVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_District_Name_Combo(?,?,?,?,?,  ?,?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("mms","EmployeeDetailRptDAO");
			
			hisutil    = new HisUtil("mms", "EmployeeDetailRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_country_code", vo.getStrCountryCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code", vo.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_seatid", vo.getStrSeatId());
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
					str = hisutil.getOptionValue(ws, "0","0^All", true);
					vo.setStrDistrictNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>Select Value</option>";  
					vo.setStrDistrictNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("EmployeeDetailRptDAO.Proc_District_Name_Combo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	

	/**
	 * for getting option value of Designation Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDesignationNameCmb(EmployeeDetailRptVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_designation_Combo (?,?,?,?,?,  ?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("mms","EmployeeDetailRptDAO");
			
			hisutil    = new HisUtil("mms", "EmployeeDetailRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code", vo.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_seatid", vo.getStrSeatId());
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
					str = hisutil.getOptionValue(ws, "0","0^All", true);
					vo.setStrDesignationNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>Select Value</option>";  
					vo.setStrDesignationNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("EmployeeDetailRptDAO.Proc_District_Name_Combo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	

}
