package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.SourceMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 6-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 * Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class SourceMstDAO.
 */

public class SourceMstDAO {

	
	
	/**
	 * Check duplicate while inserting records
	 * 
	 * @param sourceMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(SourceMstVO sourceMstVO_p, String strInsertUpdate_p) {
		HisDAO dao = null;
		int nqryIndex=-1;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "SourceMstDAO");
			
			
			if (strInsertUpdate_p.equals("insert")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"SourceMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, sourceMstVO_p.getStrSourceName());
				dao.setQryValue(nqryIndex, 2, sourceMstVO_p.getStrHospitalCode());
				
			}else if (strInsertUpdate_p.equals("update")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"sourceMst.update.chkduplicate.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, sourceMstVO_p.getStrSourceId());
				dao.setQryValue(nqryIndex, 2, sourceMstVO_p.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 3, sourceMstVO_p.getStrSourceName());
				dao.setQryValue(nqryIndex, 4, sourceMstVO_p.getStrHospitalCode());
				
			}
			wb = dao.executeQry(nqryIndex);
			// System.out.println("Web Row Set Size-->"+wb.size());
			while (wb.next()) {
				// System.out.println("wb.getString(1)-->"+wb.getString(1));
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				sourceMstVO_p.setBExistStatus(true);
			} else {
				sourceMstVO_p.setBExistStatus(false);
			}
		} catch (Exception e) {
			sourceMstVO_p.setStrMsgString("SourceMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			sourceMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * to get data for modify page.
	 * 
	 * @param sourceMstVO_p the vo
	 */
	public static void modifyRecord(SourceMstVO sourceMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "SourceMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "sourceMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, sourceMstVO_p.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, sourceMstVO_p.getStrSourceId());
			dao.setQryValue(nqryIndex, 3, sourceMstVO_p.getStrSlNo());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				sourceMstVO_p.setStrSourceName(web.getString(1));
				sourceMstVO_p.setStrEffectiveFrom(web.getString(2));
				sourceMstVO_p.setStrRemarks(web.getString(3));
				sourceMstVO_p.setStrIsValid(web.getString(4));
			}
			web.close();
		}

		catch (Exception e) {
			sourceMstVO_p.setStrMsgString("--> SourceMstDAO.modifyRecord()-->"
					+ e.getMessage());
			sourceMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	
	
	/**
	 * to insert and update the data into the tables
	 * 
	 * @param sourceMstVO_p the vo
	 */
	public static void save(SourceMstVO sourceMstVO_p, String strInsertUpdate_p) {

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "SourceMstDAO");

			strProcName_U = "{call PKG_MMS_DML.PROC_HSTT_SOURCE_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total
																								// 13
																								// Values
			nProcIndex_U = dao.setProcedure(strProcName_U);

			//HisUtil.replaceNullValueWithEmptyString(sourceMstVO_p);
			
			if (strInsertUpdate_p.equals("insert")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "1",1);
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", "1",11);
			}else if (strInsertUpdate_p.equals("update")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "2",1);
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", sourceMstVO_p.getStrIsValid(),11);
			}
			
			dao.setProcInValue(nProcIndex_U, "p_hstnum_source_id",sourceMstVO_p.getStrSourceId(),2);
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",sourceMstVO_p.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex_U, "p_hststr_source_name", sourceMstVO_p.getStrSourceName(),4);
			dao.setProcInValue(nProcIndex_U, "p_gstr_remarks", sourceMstVO_p.getStrRemarks(),5);
			dao.setProcInValue(nProcIndex_U, "p_gdt_effective_frm", sourceMstVO_p.getStrEffectiveFrom(),6);
			dao.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", sourceMstVO_p.getStrLastModifiedSeatId(),7);
			dao.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", sourceMstVO_p.getStrLastModifiedDate(),8);
			dao.setProcInValue(nProcIndex_U, "p_gdt_entry_date", sourceMstVO_p.getStrCtDate(),9);
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", sourceMstVO_p.getStrSeatId(),10);			
			dao.setProcInValue(nProcIndex_U, "p_hstnum_sl_no", sourceMstVO_p.getStrSlNo(),12);
			

			/* Default Value */

			
			dao.setProcOutValue(nProcIndex_U, "err", 1,13);

			dao.executeProcedureByPosition(nProcIndex_U);

			sourceMstVO_p.setStrMsgType("0");

		} catch (Exception e) {
			e.printStackTrace();
			sourceMstVO_p.setStrMsgString("--> SourceMstDAO.insertValues()-->"
					+ e.getMessage());
			sourceMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}
