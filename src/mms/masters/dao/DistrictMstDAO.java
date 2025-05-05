
package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.masters.vo.DistrictMstVO;


/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 * Module:- DWH(HIS Project)
 * 
 */
public class DistrictMstDAO 
{
	
	/**
	 * To Get Country Combo Values for Add Page.
	 * 
	 * @param districtMstVO_p  the vo
	 * 
	 */
	public static void getCountryName(DistrictMstVO districtMstVO_p) {

		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb;

		try {
			dao = new HisDAO("mms", "DistrictMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "district.country.combo");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, districtMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			districtMstVO_p.setStrCountryWS(wb);
			
		} catch (Exception e) {
			districtMstVO_p.setStrMsgString("--> DistrictMstDAO.getCountryName()-->"	+ e.getMessage());
			districtMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;

		}
	}
	
	/**
	 * To Get State Combo Values for Add Page.
	 * 
	 * @param districtMstVO_p  the vo
	 * 
	 */
	public static void getStateName(DistrictMstVO districtMstVO_p) {

		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb;

		try {
			dao = new HisDAO("mms", "DistrictMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "district.state.combo.1");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, districtMstVO_p.getStrCountryId());
			dao.setQryValue(nqryIndex, 2, districtMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			
			districtMstVO_p.setStrStateWS(wb);
			
		} catch (Exception e) {
			districtMstVO_p.setStrMsgString("--> DistrictMstDAO.getStateName()-->"	+ e.getMessage());
			districtMstVO_p.setStrMsgType("1");
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
	 * @param districtMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */

	public static void chkDuplicate(DistrictMstVO districtMstVO_p, String strInsertUpdate) {

		HisDAO dao = null;
		int nqryIndex = 0;
		int nqryIndex1 = 1;
		int ncount = 0;
		int ncount1 = 0;
		WebRowSet wb = null;
		WebRowSet wb1 = null;
		String strquery = new String();

		try {
			dao = new HisDAO("bmed", "DistrictMstDAO");
			if (strInsertUpdate.equals("insert")) {
				strquery = mms.qryHandler_mms.getQuery(1,"districtMst.insert1.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, districtMstVO_p.getStrStatecode());
				dao.setQryValue(nqryIndex, 2, districtMstVO_p.getStrDistrictName());
				dao.setQryValue(nqryIndex, 3, districtMstVO_p.getStrHospitalCode());
				
				strquery = mms.qryHandler_mms.getQuery(1,"districtMst.insert2.chkduplicate");
				nqryIndex1 = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex1, 1, districtMstVO_p.getStrStatecode());
				dao.setQryValue(nqryIndex1, 2, districtMstVO_p.getStrDistrictShortName());
				dao.setQryValue(nqryIndex1, 3, districtMstVO_p.getStrHospitalCode());
			}

			else if (strInsertUpdate.equals("update"))
			{
				strquery = mms.qryHandler_mms.getQuery(1,"districtMst.update1.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, districtMstVO_p.getStrDistrictId());
				dao.setQryValue(nqryIndex, 2, districtMstVO_p.getStrHospitalCode());
				
				dao.setQryValue(nqryIndex, 3, districtMstVO_p.getStrStatecode());
				dao.setQryValue(nqryIndex, 4, districtMstVO_p.getStrCountryCode());
				dao.setQryValue(nqryIndex, 5, districtMstVO_p.getStrDistrictName());
				dao.setQryValue(nqryIndex, 6, districtMstVO_p.getStrHospitalCode());
				
				
				
				
				strquery = mms.qryHandler_mms.getQuery(1,"districtMst.update2.chkduplicate");
				nqryIndex1 = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex1, 1, districtMstVO_p.getStrDistrictId());
				dao.setQryValue(nqryIndex1, 2, districtMstVO_p.getStrHospitalCode());
				
				dao.setQryValue(nqryIndex1, 3, districtMstVO_p.getStrStatecode());
				dao.setQryValue(nqryIndex1, 4, districtMstVO_p.getStrCountryCode());
				dao.setQryValue(nqryIndex1, 5, districtMstVO_p.getStrDistrictShortName());
				dao.setQryValue(nqryIndex1, 6, districtMstVO_p.getStrHospitalCode());
				
			}

			districtMstVO_p.setStrMsgType("0");

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			
			wb1 = dao.executeQry(nqryIndex1);

			while (wb1.next()) {
				ncount1 = Integer.parseInt(wb1.getString(1));
			}
			if (ncount == 0 && ncount1==0) {

				districtMstVO_p.setBExistStatus(true); // ncount=0 => no duplicacy, hence new
											// record will be saved
			} else if(ncount !=0  && ncount1 != 0){
				districtMstVO_p.setDepartmentNameExist(true);
				districtMstVO_p.setDepartmentShortNameExist(true);
				districtMstVO_p.setBExistStatus(false); // ncount!=0 => record already
											// exists, so (new) record will not be
											// added or modified
			}else if(ncount !=0){
				districtMstVO_p.setDepartmentNameExist(true);
				districtMstVO_p.setBExistStatus(false);
			}else{
				districtMstVO_p.setDepartmentShortNameExist(true);
				districtMstVO_p.setBExistStatus(false);
			}
		} catch (Exception e) {
			districtMstVO_p.setStrMsgString("DistrictMstDAO.chkDuplicate() --> "	+ e.getMessage());
			districtMstVO_p.setStrMsgType("1");
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
	 * @param districtMstVO_p	the DistrictMstVO
	 */
	public static void save(DistrictMstVO districtMstVO_p)
	{

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "DistrictMstDAO");

			strProcName_U = "{call PKG_mms_DML.proc_gblt_district_mst(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?)}"; // Total 17 Values
			
			nProcIndex_U = dao.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(districtMstVO_p);
			           
			dao.setProcInValue(nProcIndex_U, "p_mode", districtMstVO_p.getStrMode());
			dao.setProcInValue(nProcIndex_U, "p_num_dist_id", districtMstVO_p.getStrDistrictId());		 //GENERATED BY FUNCTION in case of insertion
			dao.setProcInValue(nProcIndex_U, "p_str_dist_code", "");
			dao.setProcInValue(nProcIndex_U, "p_str_dist_name",	districtMstVO_p.getStrDistrictName());
			dao.setProcInValue(nProcIndex_U, "p_str_dist_st_name",	districtMstVO_p.getStrDistrictShortName());
			dao.setProcInValue(nProcIndex_U, "p_gnum_slno", "1");
			dao.setProcInValue(nProcIndex_U, "p_gdt_effective_frm",	districtMstVO_p.getStrEffectiveFrom());
			dao.setProcInValue(nProcIndex_U, "p_gdt_effective_to", districtMstVO_p.getStrEffectiveTo());
			dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", districtMstVO_p.getStrIsValid());
			dao.setProcInValue(nProcIndex_U, "p_gnum_seat_id", districtMstVO_p.getStrSeatId());
			dao.setProcInValue(nProcIndex_U, "p_gdt_entry_date", "");
			dao.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", districtMstVO_p.getStrLastModifyDate());
			dao.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", districtMstVO_p.getStrLastModifySeatId());
			dao.setProcInValue(nProcIndex_U, "p_gstr_remarks", districtMstVO_p.getStrRemarks());
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", districtMstVO_p.getStrHospitalCode());
			dao.setProcInValue(nProcIndex_U, "p_gnum_statecode", districtMstVO_p.getStrStatecode());
			
			/* Default Value */

			dao.setProcOutValue(nProcIndex_U, "err", 1);

			dao.executeProcedure(nProcIndex_U);

			districtMstVO_p.setStrMsgType("0");

			//dao.fire();
		} 
		catch (Exception e) 
		{
			districtMstVO_p.setStrMsgString("--> DistrictMstDAO.save()-->" + e.getMessage());
			districtMstVO_p.setStrMsgType("1");
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
	 * @param districtMstVO_p
	 *            the vo
	 */
	public static void modifyRecord(DistrictMstVO districtMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "DistrictMstDAO");


			strQuery = mms.qryHandler_mms.getQuery(1, "districtMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, districtMstVO_p.getStrStatecode());
			dao.setQryValue(nqryIndex, 2, districtMstVO_p.getStrDistrictId());
			dao.setQryValue(nqryIndex, 3, districtMstVO_p.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, districtMstVO_p.getStrCountryCode());
			

			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				districtMstVO_p.setStrCountryName(web.getString(1));
				districtMstVO_p.setStrStateName(web.getString(2));
				districtMstVO_p.setStrDistrictName(web.getString(3));
				districtMstVO_p.setStrDistrictShortName(web.getString(4));
				districtMstVO_p.setStrEffectiveFrom(web.getString(5));
				districtMstVO_p.setStrEffectiveTo(web.getString(6));
				districtMstVO_p.setStrRemarks(web.getString(7));
				districtMstVO_p.setStrIsValid(web.getString(8));
				
			}
			web.close();
		}

		catch (Exception e) 
		{
			districtMstVO_p.setStrMsgString("--> DistrictMstDAO.modifyRecord()-->"	+ e.getMessage());
			districtMstVO_p.setStrMsgType("1");
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