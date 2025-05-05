package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.dao.GatePassDAO;
import mms.transactions.vo.GatePassDetailsTransVO;
/**
 * @author baisakhi
 * 
 */
public class GatePassDetailsTransDAO {
	/**
	 * for getting option value of current date and storename,gatepasstype,issuedby combos 
	 * 
	 * @param vo
	 * 
	 */
	public static void getInitialValues(GatePassDetailsTransVO vo) {

		HisDAO dao = null;
		int nprocIndex;
		String proc_name = "";
		WebRowSet wb = null;
		String strErr="";
		
		try {
			dao = new HisDAO("mms", "GatePassDetailsTransDAO");

			proc_name = "{call pkg_mms_view.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			dao.setProcInValue(nprocIndex, "seatId", vo.getStrSeatId());
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "storeid", "0");
			dao.setProcInValue(nprocIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			dao.executeProcedure(nprocIndex);
			
			strErr=dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			wb=dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setStoreNameComboWS(wb);

			} else {
				throw new Exception(strErr);
			}
		
				
		
			proc_name = "{call pkg_mms_view.proc_hstt_gatepass_type_mst(?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "1");
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			dao.executeProcedure(nprocIndex);
			strErr=dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			wb=dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setGatePassTypeComboWS(wb);

			} else {
				throw new Exception(strErr);
			}
			
			proc_name = "{call pkg_mms_view.proc_consultant_name(?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modeval", "2");
			
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "deptunitcode", "0");
			dao.setProcInValue(nprocIndex, "seatId", "0");
			/* Setting Default Value End */
			
			
			dao.setProcOutValue(nprocIndex, "err", 1);
			dao.setProcOutValue(nprocIndex, "resultset", 2);
			
			dao.executeProcedure(nprocIndex);
			strErr=dao.getString(nprocIndex, "err");
			if (strErr == null)
				strErr = "";
			wb=dao.getWebRowSet(nprocIndex, "resultset");
			
			if (strErr.equals("")) {
				vo.setIssueByComboWS(wb);

			} else {
				throw new Exception(strErr);
			}
			

		} catch (Exception e) {
			
			vo.setStrMsgString("-->GatePassDetailsTransDAO.getInitialValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb=null;
		}
	}

	/**
	 * To insert the data
	 * @param vo
	 * 
	 */
	public static void insertProcedure(GatePassDetailsTransVO vo) {

		HisDAO dao = null;
		
		GatePassDAO gatePassDao=null;
		
		try {
			dao = new HisDAO("mms", "GatePassDetailsTransDAO");
			gatePassDao=new GatePassDAO();
			
			gatePassDao.setStrHospitalCode(vo.getStrHospitalCode());
			gatePassDao.setStrFinancialEndYear(vo.getStrFinancialEndYear());
			gatePassDao.setStrFinancialStartyear(vo.getStrFinancialStartyear());
			gatePassDao.setStrGatepassTypeCode(vo.getStrGatepassTypeCode());
			gatePassDao.setStrIssueBy(vo.getStrIssueBy());
			gatePassDao.setStrIssuedTo(vo.getStrIssuedTo());
			gatePassDao.setStrRemarks(vo.getStrRemarks());
			gatePassDao.setStrSeatId(vo.getStrSeatId());
			gatePassDao.setStrStoreId(vo.getStrStoreId());
			gatePassDao.setStrValidity(vo.getStrValidity());
			gatePassDao.setStrValidityUnit(vo.getStrValidityUnit());
			
			gatePassDao.insert(dao);
			
			synchronized(dao)
			{
				dao.fire();
			}
			
			
		} catch (Exception e) {
			vo.setStrMsgString("-->GatePassDetailsTransDAO.insertProcedure()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			gatePassDao=null;
		}
	}
}
