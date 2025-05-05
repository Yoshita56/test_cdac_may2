package mms.masters.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.masters.vo.LabMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 7-Jan-2012 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 * Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class LabMstDAO.
 */

public class LabMstDAO {

	
	
	/**
	 * Check duplicate while inserting records
	 * 
	 * @param labMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(LabMstVO labMstVO_p, String strInsertUpdate_p) {
		HisDAO dao = null;
		int nqryIndex=-1;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {

			dao = new HisDAO("mms", "LabMstDAO");
			
			
			if (strInsertUpdate_p.equals("insert")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"labMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, labMstVO_p.getStrLabName());
				dao.setQryValue(nqryIndex, 2, labMstVO_p.getStrHospitalCode());
				
			}else if (strInsertUpdate_p.equals("update")) {
				
				strquery = mms.qryHandler_mms.getQuery(1,"labMst.update.chkduplicate.0");
				nqryIndex = dao.setQuery(strquery);
				dao.setQryValue(nqryIndex, 1, labMstVO_p.getStrLabNo());
				dao.setQryValue(nqryIndex, 2, labMstVO_p.getStrHospitalCode());
				dao.setQryValue(nqryIndex, 3, labMstVO_p.getStrLabName());
				dao.setQryValue(nqryIndex, 4, labMstVO_p.getStrHospitalCode());
				
			}
			wb = dao.executeQry(nqryIndex);
			// System.out.println("Web Row Set Size-->"+wb.size());
			while (wb.next()) {
				// System.out.println("wb.getString(1)-->"+wb.getString(1));
				ncount = Integer.parseInt(wb.getString(1));
			}
			if (ncount == 0) {
				labMstVO_p.setBExistStatus(true);
			} else {
				labMstVO_p.setBExistStatus(false);
			}
		} catch (Exception e) {
			labMstVO_p.setStrMsgString("LabMstDAO.chkDuplicate() --> "
					+ e.getMessage());
			labMstVO_p.setStrMsgType("1");
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
	 * @param labMstVO_p the vo
	 */
	public static void modifyRecord(LabMstVO labMstVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0;

		String strQuery;

		WebRowSet web = null;

		try {

			dao = new HisDAO("mms", "LabMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "labMst.modify");
			nqryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nqryIndex, 1, labMstVO_p.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, labMstVO_p.getStrLabNo());
			dao.setQryValue(nqryIndex, 3, labMstVO_p.getStrSlNo());
			
			web = dao.executeQry(nqryIndex);
			if (web.next()) {
				labMstVO_p.setStrLabName(web.getString(1));
				labMstVO_p.setStrLabUserNo(web.getString(2));
				labMstVO_p.setStrLabType(web.getString(3));
				labMstVO_p.setStrAddress(web.getString(4));
				labMstVO_p.setStrPhoneNo(web.getString(5));
				labMstVO_p.setStrFaxNo(web.getString(6));
				labMstVO_p.setStrIsValid(web.getString(7));
			}
			web.close();
		}

		catch (Exception e) {
			labMstVO_p.setStrMsgString("--> LabMstDAO.modifyRecord()-->"
					+ e.getMessage());
			labMstVO_p.setStrMsgType("1");
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
	 * @param labMstVO_p the vo
	 */
	public static void save(LabMstVO labMstVO_p, String strInsertUpdate_p) {

		HisDAO dao = null;

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			dao = new HisDAO("mms", "LabMstDAO");

			strProcName_U = "{call PKG_MMS_DML.proc_hstt_qc_lab_mst(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total
																										// 17
																										// Values
			nProcIndex_U = dao.setProcedure(strProcName_U);

			//HisUtil.replaceNullValueWithEmptyString(labMstVO_p);
			//p_mode character varying DEFAULT 1, p_hstnum_lab_no character varying, p_gnum_hospital_code character varying,
			//p_hststr_lab_name character varying, p_hststr_user_labno character varying, p_hstnum_lab_type character varying, 
			//p_hststr_lab_address character varying, p_hststr_phone_no character varying, p_hststr_fax_no character varying,
			// p_gstr_lst_remarks character varying, p_gdt_lstmodified_date character varying, p_gnum_lstmodified_seatid character varying,
			// p_gnum_seatid character varying, p_gdt_entry_date character varying DEFAULT sysdate, 
			//p_gnum_isvalid character varying DEFAULT 1, p_hstnum_sl_no character varying, OUT err character varying
			if (strInsertUpdate_p.equals("insert")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "1",1);
			}else if (strInsertUpdate_p.equals("update")) {
				dao.setProcInValue(nProcIndex_U, "p_mode", "2",1);
			}
			
			dao.setProcInValue(nProcIndex_U, "p_hstnum_lab_no",labMstVO_p.getStrLabNo(),2);
			dao.setProcInValue(nProcIndex_U, "p_gnum_hospital_code",labMstVO_p.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex_U, "p_hststr_lab_name", labMstVO_p.getStrLabName(),4);
			dao.setProcInValue(nProcIndex_U, "p_hststr_user_labno", labMstVO_p.getStrLabUserNo(),5);
			dao.setProcInValue(nProcIndex_U, "p_hstnum_lab_type", labMstVO_p.getStrLabType(),6);
			
			dao.setProcInValue(nProcIndex_U, "p_hststr_lab_address", labMstVO_p.getStrAddress(),7);
			dao.setProcInValue(nProcIndex_U, "p_hststr_phone_no", labMstVO_p.getStrPhoneNo(),8);
			dao.setProcInValue(nProcIndex_U, "p_hststr_fax_no", labMstVO_p.getStrFaxNo(),9);
			dao.setProcInValue(nProcIndex_U, "p_gstr_lst_remarks", labMstVO_p.getStrRemarks(),10);
			
			dao.setProcInValue(nProcIndex_U, "p_gdt_lstmodified_date", labMstVO_p.getStrLastModifiedDate(),11);
			dao.setProcInValue(nProcIndex_U, "p_gnum_lstmodified_seatid", labMstVO_p.getStrLastModifiedSeatId(),12);
			dao.setProcInValue(nProcIndex_U, "p_gnum_seatid", labMstVO_p.getStrSeatId(),13);
			dao.setProcInValue(nProcIndex_U, "p_gdt_entry_date", labMstVO_p.getStrCtDate(),14);
			
			dao.setProcInValue(nProcIndex_U, "p_gnum_isvalid", labMstVO_p.getStrIsValid(),15);
			
			dao.setProcInValue(nProcIndex_U, "p_hstnum_sl_no", labMstVO_p.getStrSlNo(),16);		
			
			/* Default Value */
			dao.setProcOutValue(nProcIndex_U, "err", 1,17);

			dao.executeProcedureByPosition(nProcIndex_U);

			labMstVO_p.setStrMsgType("0");

		} catch (Exception e) {
			e.printStackTrace();
			labMstVO_p.setStrMsgString("--> LabMstDAO.insertValues()-->"
					+ e.getMessage());
			labMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

}
