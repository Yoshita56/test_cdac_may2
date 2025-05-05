package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;



import mms.reports.vo.Dwh_ZoneWiseBudgetRptVO;


public class Dwh_ZoneWiseBudgetRptDAO {
	
	
	public static void getZoneWiseBudgetDtl(Dwh_ZoneWiseBudgetRptVO vo) {

		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
			dao = new HisDAO("mms", "Dwh_ZoneWiseBudgetRptDAO");
			
			
			strproc_name = "{call PKG_MMS_RPT.Rptm_zoneBudgetDtl(?,?,?,?,?)}";   //11 variables
			nprocIndex = dao.setProcedure(strproc_name);
    		dao.setProcInValue(nprocIndex, "p_mode", "1");
	
			dao.setProcInValue(nprocIndex, "p_fromYear", vo.getStrFromDate());
			dao.setProcInValue(nprocIndex, "p_toYear", vo.getStrToDate());			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			dao.executeProcedure(nprocIndex);

			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";

			if (strerr.equals(""))
			{

				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
                vo.setStrScreentTwoWs(wb); 
				

			} else {
				throw new Exception(strerr);
			}

		}
		catch (Exception e) 
		
		{
			e.printStackTrace();
			vo.setStrMsgString("Dwh_ZoneWiseBudgetRptDAO.getZoneWiseBudgetDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}


}
