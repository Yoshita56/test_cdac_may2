package mms.masters.dao;

import hisglobal.hisconfig.Config;
import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.masters.vo.SmsMobileSetupMstVO ;

public class SmsMobileSetupMstDAO
{
	
	/**
	 * to get the data for Hem Configuration.
	 * 
	 * @param vo_p	the SmsMobileSetupMstVO
	 */
	public static void getRecord(SmsMobileSetupMstVO vo_p) 
	{
		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;
		
		
		try 
		{

			dao = new HisDAO("bmed", "SmsMobileSetupMstDAO");

			

			strQuery = mms.qryHandler_mms.getQuery(1, "smsMobileSetupMst.getRecord");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, Config.IS_VALID_ACTIVE);
			dao.setQryValue(nqryIndex, 2, vo_p.getStrHospitalCode());

			web = dao.executeQry(nqryIndex);
			
			
			vo_p.setWrsData(web);
						
			
			
		}

		catch (Exception e) 
		{
			vo_p.setStrMsgString("--> SmsMobileSetupMstDAO.getRecord()-->"	+ e.getMessage());
			vo_p.setStrMsgType("1");
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
	 * to get the data for Hem Configuration.
	 * 
	 * @param vo_p	the SmsMobileSetupMstVO
	 */
	public static void getMobileNos(SmsMobileSetupMstVO vo_p) 
	{
		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;
		
		
		try 
		{

			dao = new HisDAO("mms", "SmsMobileSetupMstDAO");

			

			strQuery = mms.qryHandler_mms.getQuery(1, "smsMobileSetupMst.getMobileNos");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, Config.IS_VALID_ACTIVE);
			dao.setQryValue(nqryIndex, 2, vo_p.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 3, vo_p.getStrReqTypeId());

			web = dao.executeQry(nqryIndex);
			
			
			vo_p.setPhoneNosWrs(web);
						
			
			
		}

		catch (Exception e) 
		{
			vo_p.setStrMsgString("--> SmsMobileSetupMstDAO.getRecord()-->"	+ e.getMessage());
			vo_p.setStrMsgType("1");
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
	 * to save the record.
	 * 
	 * @param vo_p	the SmsMobileSetupMstVO
	 * 
	 * @throws Exception
	 */
	public static void saveRecord(SmsMobileSetupMstVO vo_p) 
	{
		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("bmed", "SmsMobileSetupMstDAO");
			// Total 5 Values to be executed in batch
			strProcName_U = "{call PKG_MMS_DML.PROC_SMS_MOBILE_SETUP_MST(?,?,?,?,?)}"; 
			nProcIndex_U = dao.setProcedure(strProcName_U);

			//1. Setting the 	p_str_property_value	 for	p_num_config_property_id=10	                                
			dao.setProcInValue(nProcIndex_U, "p_mode", "1"); //p_mode
			
			dao.setProcInValue(nProcIndex_U, "p_num_hospital_code", vo_p.getStrHospitalCode());//p_num_hospital_code
			dao.setProcOutValue(nProcIndex_U, "err", 1); // default values 
			
			
			dao.setProcInValue(nProcIndex_U, "p_req_id", vo_p.getStrReqTypeId());  //p_req_id
			dao.setProcInValue(nProcIndex_U, "p_phone_no", vo_p.getStrPhoneNo()); //p_phone_no

			dao.executeProcedure(nProcIndex_U);
		

			vo_p.setStrMsgType("0");

		} catch (Exception e)
		{
			vo_p.setStrMsgString("--> SmsMobileSetupMstDAO.saveRecord()-->" + e.getMessage());
			vo_p.setStrMsgType("1");
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
}
