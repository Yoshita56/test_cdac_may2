package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import javax.sql.rowset.WebRowSet;
import mms.transactions.vo.LotsViewDtlTransVO;

public class LotsViewTransDAO {
	
	public static void getLotsDetails(LotsViewDtlTransVO _LotsViewDtlTransVO) 
	{
		WebRowSet wb = null;
		HisDAO daoObj = null;
		int nProcIndex = 0;
		String strErr = "";

    	try 
		{
    		String strProcName = "{call pkg_mms_view.proc_lot_view_dtl(?,?,?,?,?,?,?,?)}";

			daoObj = new HisDAO("MMS Transactions","CondemnationRegisterViewTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code", _LotsViewDtlTransVO.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strId", _LotsViewDtlTransVO.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "agendaNo", _LotsViewDtlTransVO.getStrAgendaNo());
			daoObj.setProcInValue(nProcIndex, "itemId", _LotsViewDtlTransVO.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "itemBrandId", _LotsViewDtlTransVO.getStrItemBrandId());
			daoObj.setProcOutValue(nProcIndex,"err", 1);
			daoObj.setProcOutValue(nProcIndex,"resultset", 2);
			daoObj.executeProcedure(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {
				wb = daoObj.getWebRowSet(nProcIndex, "resultset");
				_LotsViewDtlTransVO.setItemDtlWS(wb);
				if(wb.next()){
					_LotsViewDtlTransVO.setStrItemName(wb.getString(1));
					_LotsViewDtlTransVO.setStrItemBrandName(wb.getString(2));
					_LotsViewDtlTransVO.setStrCancelDate(wb.getString(3));
					_LotsViewDtlTransVO.setStrCancelRemarks(wb.getString(4));
					_LotsViewDtlTransVO.setStrCondemnationType(wb.getString(5));
					_LotsViewDtlTransVO.setStrCancelBy(wb.getString(6));
				}
			} else {
				throw new Exception(strErr);
			}
    	} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
    		_LotsViewDtlTransVO.setStrMsgString("--> LotsViewTransDAO.getLotsDetails()-->"
					+ e.getMessage());
    		_LotsViewDtlTransVO.setStrMsgType("1");
		} finally {			
			if (daoObj != null)
				daoObj.free();
				daoObj = null;
			}
		}


}
