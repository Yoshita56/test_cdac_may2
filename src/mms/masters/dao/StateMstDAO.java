package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.masters.vo.EmployeeDetailMstVO;
import mms.masters.vo.StateMstVO;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstDAO 
{
	
	/**
	 * To Get Country Combo Values for Add Page.
	 * 
	 * @param stateMstVO_p  the vo
	 * 
	 */
	public static void getCountryName(StateMstVO stateMstVO_p) {

		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb;

		try {
			dao = new HisDAO("mms", "StateMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "stateMst.country.combo.0");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, stateMstVO_p.getStrCountryCode());
			dao.setQryValue(nqryIndex, 2, stateMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			if(wb!=null)
			{
				if(wb.next())
				{
					stateMstVO_p.setStrCountryName(wb.getString(1));
				}	
			}
			

		} catch (Exception e) {
			stateMstVO_p.setStrMsgString("--> StateMstDAO.getCountryName()-->"	+ e.getMessage());
			stateMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;

		}
	}
	
	/**
	 * Check duplicate while inserting records
	 * 
	 * @param stateMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(StateMstVO stateMstVO_p, String strInsertUpdate) {
		HisDAO dao = null;
		int nqryIndex = 0;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("bmed", "StateMstDAO");
			if (strInsertUpdate.equals("insert")) {
				strquery = mms.qryHandler_mms.getQuery(1,"stateMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, stateMstVO_p.getStrCountryCode());
				dao.setQryValue(nqryIndex, 2, stateMstVO_p.getStrStateName());
				dao.setQryValue(nqryIndex, 3, stateMstVO_p.getStrHospitalCode());
			}

			else if (strInsertUpdate.equals("update"))
			{
				strquery = mms.qryHandler_mms.getQuery(1,"stateMst.update.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, stateMstVO_p.getStrStateCode());
				dao.setQryValue(nqryIndex, 2, stateMstVO_p.getStrHospitalCode());

			
				dao.setQryValue(nqryIndex, 3, stateMstVO_p.getStrCountryCode());
				dao.setQryValue(nqryIndex, 4, stateMstVO_p.getStrStateName());
				dao.setQryValue(nqryIndex, 5, stateMstVO_p.getStrHospitalCode());
			}

			stateMstVO_p.setStrMsgType("0");

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {

				stateMstVO_p.setBExistStatus(true); // ncount=0 => no duplicacy, hence new
											// record will be saved
			} else {
				stateMstVO_p.setBExistStatus(false); // ncount!=0 => record already
											// exists, so new record will not be
											// added
			}
		} catch (Exception e) {
			stateMstVO_p.setStrMsgString("StateMstDAO.chkDuplicate() --> "	+ e.getMessage());
			stateMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}
	}
	
	
	/**
	 * To insert the data
	 * 
	 * @param stateMstVO_p	the StateMstVO
	 */
	public static void save(StateMstVO stateMstVO_p)
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "StateMstDAO");

			strProcName_U = "{call PKG_mms_DML.proc_gblt_state_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?)}"; // Total 14 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(stateMstVO_p);
			
			dao.setProcInValue(nProcIndex_U, "p_mode", stateMstVO_p.getStrMode());
			dao.setProcInValue(nProcIndex_U, "p_gnum_statecode", stateMstVO_p.getStrStateCode()); 
			dao.setProcInValue(nProcIndex_U, "p_gstr_statename", stateMstVO_p.getStrStateName());
			dao.setProcInValue(nProcIndex_U, "p_gnum_countrycode",	stateMstVO_p.getStrCountryCode());
			dao.setProcInValue(nProcIndex_U, "p_gstr_stateshort",	stateMstVO_p.getStrStateShortName());
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid",	stateMstVO_p.getStrSeatId());
			dao.setProcInValue(nProcIndex_U, "p_gdt_entrydate", stateMstVO_p.getStrEntrydate());
			dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid",	stateMstVO_p.getStrIsValid());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hl7_code", stateMstVO_p.getStrHl7Code());
			dao.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", stateMstVO_p.getStrLstModDate());
			dao.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", stateMstVO_p.getStrLstModSeatId());
			dao.setProcInValue(nProcIndex_U, "p_gstr_remarks", stateMstVO_p.getStrRemarks());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", stateMstVO_p.getStrHospitalCode());
			
			/* Default Value */

			dao.setProcOutValue(nProcIndex_U, "err", 1);

			dao.executeProcedure(nProcIndex_U);

			stateMstVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			stateMstVO_p.setStrMsgString("--> StateMstDAO.save()-->" + e.getMessage());
			stateMstVO_p.setStrMsgType("1");
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
	 * @param stateMstVO_p
	 *            the vo
	 */
	public static void modifyRecord(StateMstVO stateMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "StateMstDAO");


			strQuery = mms.qryHandler_mms.getQuery(1, "stateMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, stateMstVO_p.getStrStateCode());
			dao.setQryValue(nqryIndex, 2, stateMstVO_p.getStrHospitalCode());
			

			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				stateMstVO_p.setStrCountryName(web.getString(1));
				stateMstVO_p.setStrStateName(web.getString(2));
				stateMstVO_p.setStrStateShortName(web.getString(3));
				stateMstVO_p.setStrIsValid(web.getString(4));
				
			}
			web.close();
		}

		catch (Exception e) 
		{
			stateMstVO_p.setStrMsgString("--> StateMstDAO.modifyRecord()-->"	+ e.getMessage());
			stateMstVO_p.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
}