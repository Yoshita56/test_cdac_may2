/**
 * 
 */
package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.SamplesSummaryListRptVO;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptDAO {
	

public static void getCategoryValues(SamplesSummaryListRptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			dao = new HisDAO("MMS Report", "SamplesSummaryListRptDAO");

			nProcIndex = dao.setProcedure(strProcName);

			
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao
			.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode()); 
			
			
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				
				strErr = "";
			if (strErr.equals("")) {
			ws = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setCategoryComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("SamplesSummaryListRptDAO.getCategoryValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}


public static void getSupplierNameValues(SamplesSummaryListRptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_Supplier_List(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			dao = new HisDAO("MMS Report", "SamplesSummaryListRptDAO");

			nProcIndex = dao.setProcedure(strProcName);

			
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao
			.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode()); 
			
			dao
			.setProcInValue(nProcIndex, "item_cat", vo
					.getStrCategoryNo()); 
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				
				strErr = "";
			if (strErr.equals("")) {
			ws = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setSupplierComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("SamplesSummaryListRptDAO.getSupplierNameValues() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}


public static void getTenderNoValues(SamplesSummaryListRptVO vo) {

		HisDAO dao = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_Rpt.Rptm_Tender_List(?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {

			dao = new HisDAO("MMS Report", "SamplesSummaryListRptDAO");

			nProcIndex = dao.setProcedure(strProcName);

			
			dao.setProcInValue(nProcIndex, "modeval", "1");
			dao
			.setProcInValue(nProcIndex, "hosp_code", vo
					.getStrHospitalCode()); 
			
			dao
			.setProcInValue(nProcIndex, "item_cat", vo
					.getStrCategoryNo()); 
			dao.setProcOutValue(nProcIndex, "err", 1);
			dao.setProcOutValue(nProcIndex, "resultset", 2);
			dao.executeProcedure(nProcIndex);
			strErr = dao.getString(nProcIndex, "err");
			if (strErr == null)
				
				strErr = "";
			if (strErr.equals("")) {
			ws = dao.getWebRowSet(nProcIndex, "resultset");
				vo.setTenderNoComboWS(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("SamplesSummaryListRptDAO.getTenderNoValues() --> "
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
