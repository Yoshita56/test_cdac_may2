package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.DiscrepancyReportGlobalVO;
public class DiscrepancyReportGlobalDAO {
	/**
	 * This function used to fetch Batchwise Detail from database
	 * @param _DiscrepancyReportGlobalVO
	 */
public static void getBatchWise(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO) {
		
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "DiscrepancyReportGlobalDAO");
				strproc_name = "{call pkg_mms_view.proc_phystock_itembatch_view(?,?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "hosp_code",    _DiscrepancyReportGlobalVO.getStrHospitalCode());
				dao.setProcInValue(nprocIndex, "strPhyStockNo", _DiscrepancyReportGlobalVO.getStrStockNo());
				dao.setProcInValue(nprocIndex, "strStoreId",    _DiscrepancyReportGlobalVO.getStrStoreId());
				dao.setProcInValue(nprocIndex, "strItemId",     _DiscrepancyReportGlobalVO.getStrItemIdBatchWise());
				dao.setProcInValue(nprocIndex, "strItemBrandId",_DiscrepancyReportGlobalVO.getStrItemIdBrandBatchWise());
				dao.setProcInValue(nprocIndex, "modval","1"); // Default Value.
				dao.setProcOutValue(nprocIndex, "err", 1);
				dao.setProcOutValue(nprocIndex, "resultset", 2); 
				dao.executeProcedure(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				
				if (strerr.equals("")) {
				
					_DiscrepancyReportGlobalVO.setBatchWiseWS(wb);
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			_DiscrepancyReportGlobalVO.setStrMsgString("DiscrepancyReportGlobalDAO.getBatchWise() --> "
					+ e.getMessage());
			_DiscrepancyReportGlobalVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}
	}

public static void getGroupCmbViewOrReview(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO) {

	HisDAO daoObj = null;
	WebRowSet ws = null;

	String strProcName = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	try {
		daoObj = new HisDAO("MMS Transactions","DiscrepancyReportGlobalDAO");

		nProcIndex = daoObj.setProcedure(strProcName);

		daoObj.setProcInValue(nProcIndex, "modeval", "3");
		daoObj.setProcInValue(nProcIndex, "strPhyStockNo", _DiscrepancyReportGlobalVO.getStrStockNo());
		daoObj.setProcInValue(nProcIndex, "strStoreId", _DiscrepancyReportGlobalVO.getStrStoreId());
		daoObj.setProcInValue(nProcIndex, "hosp_code", _DiscrepancyReportGlobalVO.getStrHospitalCode());
		daoObj.setProcInValue(nProcIndex, "item_category", "1"); // Default Value.
		daoObj.setProcOutValue(nProcIndex, "err", 1);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2);

		daoObj.executeProcedure(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			////System.out.println("Final Size"+ws.size());
			_DiscrepancyReportGlobalVO.setStrGroupWs(ws);
			
		} else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		_DiscrepancyReportGlobalVO
				.setStrMsgString("DiscrepancyReportGlobalDAO.getGroupCmbViewOrReview() --> "
						+ e.getMessage());
		_DiscrepancyReportGlobalVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

public static void getDscrepNonReport(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO){
	HisDAO daoObj = null;
	WebRowSet ws = null;

	String strProcName = "{call pkg_mms_view.proc_phystock_view(?,?,?,?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	try {
		
		
		
		daoObj = new HisDAO("MMS Transactions","DiscrepancyReportGlobalDAO");

		nProcIndex = daoObj.setProcedure(strProcName);

		daoObj.setProcInValue(nProcIndex, "modval", "1");
		daoObj.setProcInValue(nProcIndex, "hosp_code", _DiscrepancyReportGlobalVO.getStrHospitalCode());
		daoObj.setProcInValue(nProcIndex, "strGroupId", _DiscrepancyReportGlobalVO.getStrGroupId());
		daoObj.setProcInValue(nProcIndex, "strPhyStockNo", _DiscrepancyReportGlobalVO.getStrStockNo());
		daoObj.setProcInValue(nProcIndex, "strStoreId", _DiscrepancyReportGlobalVO.getStrStoreId());
		daoObj.setProcOutValue(nProcIndex, "err", 1);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2);

		daoObj.executeProcedure(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			_DiscrepancyReportGlobalVO.setDiscrepancyWs(ws);
			
		} else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		_DiscrepancyReportGlobalVO
				.setStrMsgString("DiscrepancyReportGlobalDAO.getGroupCmbViewOrReview() --> "
						+ e.getMessage());
		_DiscrepancyReportGlobalVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}

}

public static void getDscrepReport(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO){
	HisDAO daoObj = null;
	WebRowSet ws = null;

	String strProcName = "{call pkg_mms_view.proc_phystock_view(?,?,?,?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	try {
		
		
		
		daoObj = new HisDAO("MMS Transactions","DiscrepancyReportGlobalDAO");

		nProcIndex = daoObj.setProcedure(strProcName);

		daoObj.setProcInValue(nProcIndex, "modval", "2");
		daoObj.setProcInValue(nProcIndex, "hosp_code", _DiscrepancyReportGlobalVO.getStrHospitalCode());
		daoObj.setProcInValue(nProcIndex, "strPhyStockNo", _DiscrepancyReportGlobalVO.getStrStockNo());
		daoObj.setProcInValue(nProcIndex, "strStoreId", _DiscrepancyReportGlobalVO.getStrStoreId());
		daoObj.setProcInValue(nProcIndex, "strGroupId", ""); // default value.
		daoObj.setProcOutValue(nProcIndex, "err", 1);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2);

		daoObj.executeProcedure(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			_DiscrepancyReportGlobalVO.setDiscrepancyWs(ws);
			
		} else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		_DiscrepancyReportGlobalVO
				.setStrMsgString("DiscrepancyReportGlobalDAO.getGroupCmbViewOrReview() --> "
						+ e.getMessage());
		_DiscrepancyReportGlobalVO.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}


}




}
