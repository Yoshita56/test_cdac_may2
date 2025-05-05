package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.CountryMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 7-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 * Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class CountryMstDAO.
 */

public class CountryMstDAO {

	
	
	/**
	 * Check duplicate while inserting records
	 * 
	 * @param countryMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(CountryMstVO countryMstVO_p, String strInsertUpdate_p) {
		HisDAO dao = null;
		int nqryIndex=-1;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "CountryMstDAO");
			
			
			if (strInsertUpdate_p.equals("insert")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"CountryMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, countryMstVO_p.getStrCountryName());
				dao.setQryValue(nqryIndex, 2, countryMstVO_p.getStrHospitalCode());
				
			}else if (strInsertUpdate_p.equals("update")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"countryMst.update.chkduplicate.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, countryMstVO_p.getStrCountryCode());
				dao.setQryValue(nqryIndex, 2, countryMstVO_p.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 3, countryMstVO_p.getStrCountryName());
				dao.setQryValue(nqryIndex, 4, countryMstVO_p.getStrHospitalCode());
				
			}
			wb = dao.executeQry(nqryIndex);
			
			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				countryMstVO_p.setBExistStatus(true);
			} else {
				countryMstVO_p.setBExistStatus(false);
			}
		} catch (Exception e) {
			countryMstVO_p.setStrMsgString("CountryMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			countryMstVO_p.setStrMsgType("1");
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
	 * @param countryMstVO_p the vo
	 */
	public static void modifyRecord(CountryMstVO countryMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "CountryMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "countryMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, countryMstVO_p.getStrCountryCode());
			dao.setQryValue(nqryIndex, 2, countryMstVO_p.getStrHospitalCode());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				countryMstVO_p.setStrCountryName(web.getString(1));
				countryMstVO_p.setStrCountryShortName(web.getString(2));
				countryMstVO_p.setStrNationality(web.getString(3));
				countryMstVO_p.setStrIsValid(web.getString(4));
			}
			web.close();
		}

		catch (Exception e) {
			countryMstVO_p.setStrMsgString("--> CountryMstDAO.modifyRecord()-->"
					+ e.getMessage());
			countryMstVO_p.setStrMsgType("1");
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
	 * @param countryMstVO_p the vo
	 */
	public static void save(CountryMstVO countryMstVO_p, String strInsertUpdate_p) {

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "CountryMstDAO");

			strProcName_U = "{call PKG_MMS_DML.PROC_GBLT_COUNTRY_MST(?,?,?,?,?,?,?,?,?,?,?)}"; // Total
																								// 11
																								// Values
			nProcIndex_U = dao.setProcedure(strProcName_U);

			
			
			if (strInsertUpdate_p.equals("insert")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "1");
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", "1");
			}else if (strInsertUpdate_p.equals("update")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "2");
				dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", countryMstVO_p.getStrIsValid());
			}
			
			dao.setProcInValue(nProcIndex_U, "p_gnum_countrycode",countryMstVO_p.getStrCountryCode());
			dao.setProcInValue(nProcIndex_U, "p_gstr_countryname",countryMstVO_p.getStrCountryName());
			dao.setProcInValue(nProcIndex_U, "p_gstr_countryshort", countryMstVO_p.getStrCountryShortName());
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", countryMstVO_p.getStrSeatId());
			dao.setProcInValue(nProcIndex_U, "p_gdt_entrydate", countryMstVO_p.getStrCtDate());
			
			dao.setProcInValue(nProcIndex_U, "p_gnum_hl7_code", countryMstVO_p.getStrhl7Code());
			dao.setProcInValue(nProcIndex_U, "p_gstr_nationality", countryMstVO_p.getStrNationality());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", countryMstVO_p.getStrHospitalCode());
			

			/* Default Value */

			
			dao.setProcOutValue(nProcIndex_U, "err", 1);

			dao.executeProcedure(nProcIndex_U);

			countryMstVO_p.setStrMsgType("0");

		} catch (Exception e) {
			e.printStackTrace();
			countryMstVO_p.setStrMsgString("--> CountryMstDAO.insertValues()-->"
					+ e.getMessage());
			countryMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}

