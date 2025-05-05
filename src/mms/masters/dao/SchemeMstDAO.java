package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.SchemeMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 1-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 * Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class SchemeMstDAO.
 */

public class SchemeMstDAO {

	
	
	/**
	 * Check duplicate while inserting records
	 * 
	 * @param schemeMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(SchemeMstVO schemeMstVO_p, String strInsertUpdate_p) {
		HisDAO dao = null;
		int nqryIndex=-1;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "SchemeMstDAO");
			
			
			if (strInsertUpdate_p.equals("insert")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"SchemeMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, schemeMstVO_p.getStrSchemeName());
				dao.setQryValue(nqryIndex, 2, schemeMstVO_p.getStrHospitalCode());
				
			}else if (strInsertUpdate_p.equals("update")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"schemeMst.update.chkduplicate.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, schemeMstVO_p.getStrSchemeId());
				dao.setQryValue(nqryIndex, 2, schemeMstVO_p.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 3, schemeMstVO_p.getStrSchemeName());
				dao.setQryValue(nqryIndex, 4, schemeMstVO_p.getStrHospitalCode());
				
			}
			wb = dao.executeQry(nqryIndex);
			// System.out.println("Web Row Set Size-->"+wb.size());
			while (wb.next()) {
				// System.out.println("wb.getString(1)-->"+wb.getString(1));
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				schemeMstVO_p.setBExistStatus(true);
			} else {
				schemeMstVO_p.setBExistStatus(false);
			}
		} catch (Exception e) {
			schemeMstVO_p.setStrMsgString("SchemeMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			schemeMstVO_p.setStrMsgType("1");
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
	 * @param schemeMstVO_p the vo
	 */
	public static void modifyRecord(SchemeMstVO schemeMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "SchemeMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "schemeMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, schemeMstVO_p.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, schemeMstVO_p.getStrSchemeId());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				schemeMstVO_p.setStrSchemeName(web.getString(1));
				schemeMstVO_p.setStrEffectiveFrom(web.getString(2));
				schemeMstVO_p.setStrRemarks(web.getString(3));
				schemeMstVO_p.setStrIsValid(web.getString(4));
			}
			web.close();
		}

		catch (Exception e) {
			schemeMstVO_p.setStrMsgString("--> SchemeMstDAO.modifyRecord()-->"
					+ e.getMessage());
			schemeMstVO_p.setStrMsgType("1");
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
	 * @param schemeMstVO_p the vo
	 */
	public static void save(SchemeMstVO schemeMstVO_p, String strInsertUpdate_p) {

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "SchemeMstDAO");

			strProcName_U = "{call PKG_MMS_DML.PROC_HSTT_SCHEME_MST(?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total
																								// 12
																								// Values
			nProcIndex_U = dao.setProcedure(strProcName_U);

			//HisUtil.replaceNullValueWithEmptyString(schemeMstVO_p);
			
			if (strInsertUpdate_p.equals("insert")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "1");
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", "1");
			}else if (strInsertUpdate_p.equals("update")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "2");
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", schemeMstVO_p.getStrIsValid());
			}
			
			dao.setProcInValue(nProcIndex_U, "p_hstnum_scheme_id",schemeMstVO_p.getStrSchemeId());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",schemeMstVO_p.getStrHospitalCode());
			dao.setProcInValue(nProcIndex_U, "p_hststr_scheme_name", schemeMstVO_p.getStrSchemeName());
			dao.setProcInValue(nProcIndex_U, "p_gstr_remarks", schemeMstVO_p.getStrRemarks());
			dao.setProcInValue(nProcIndex_U, "p_gdt_effective_frm", schemeMstVO_p.getStrEffectiveFrom());
			dao.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", schemeMstVO_p.getStrLastModifiedSeatId());
			dao.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", schemeMstVO_p.getStrLastModifiedDate());
			dao.setProcInValue(nProcIndex_U, "p_gdt_entry_date", schemeMstVO_p.getStrCtDate());
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", schemeMstVO_p.getStrSeatId());
			

			/* Default Value */

			
			dao.setProcOutValue(nProcIndex_U, "err", 1);

			dao.executeProcedure(nProcIndex_U);

			schemeMstVO_p.setStrMsgType("0");

		} catch (Exception e) {
			e.printStackTrace();
			schemeMstVO_p.setStrMsgString("--> SchemeMstDAO.insertValues()-->"
					+ e.getMessage());
			schemeMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}
