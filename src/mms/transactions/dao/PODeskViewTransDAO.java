/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.PODeskViewTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskViewTransDAO {
	public static void getPODetails(PODeskViewTransVO _poDeskViewTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; //6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			
			
			
			dao = new HisDAO("MMS",
					"transactions.PODeskViewTransDAO.getPODetails()");
			
			//System.out.println("_poDeskViewTransVO.getStrPONo().substring(2,2)::::::"+_poDeskViewTransVO.getStrPOTypeId().substring(0,2));
			nProcIndex = dao.setProcedure(strproc_name);
			if(_poDeskViewTransVO.getStrPOTypeId().substring(0,2).equals("21") && _poDeskViewTransVO.getStrpoStatus().equals("1"))
			{	
				System.out.println("----------- pkg_mms_view.Proc_Po_Details  -----[ Mode - 8 ]------");
				dao.setProcInValue(nProcIndex, "modeval", "8",1);
			}
			else
			{
				System.out.println("----------- pkg_mms_view.Proc_Po_Details  -----[ Mode - 1 ]------");
				dao.setProcInValue(nProcIndex, "modeval", "1",1);
			}
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskViewTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskViewTransVO
					.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _poDeskViewTransVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				_poDeskViewTransVO.setStrPODate(wsResult.getString(1));
				_poDeskViewTransVO
						.setStrSupplierName(wsResult.getString(2));
				_poDeskViewTransVO.setStrPOType(wsResult.getString(3));
				_poDeskViewTransVO.setStrSupplierId(wsResult.getString(7));
				_poDeskViewTransVO.setStrPOTypeId(wsResult.getString(8));
				_poDeskViewTransVO.setStrItemCat(wsResult.getString(11));
				_poDeskViewTransVO
						.setStrItemCatName(wsResult.getString(12));
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransDAO.getPODetails() --> "
							+ _Err.getMessage());
			_poDeskViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getForeignPODetails(
			PODeskViewTransVO _poDeskViewTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}"; //6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskViewTransDAO.getForeignPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskViewTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "storeId", _poDeskViewTransVO
					.getStrStoreId(),4);
			dao.setProcInValue(nProcIndex, "pono", _poDeskViewTransVO
					.getStrPONo(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				if (wsResult.next()) {
					_poDeskViewTransVO.setStrAgentId(wsResult.getString(1));
					_poDeskViewTransVO.setStrCAAgent(wsResult.getString(2));
					_poDeskViewTransVO.setStrCurrencyCode(wsResult.getString(3));
					_poDeskViewTransVO.setStrAgentName(wsResult.getString(4));
					_poDeskViewTransVO.setStrCAAgentName(wsResult.getString(5));
					_poDeskViewTransVO.setStrCurrency(wsResult.getString(6));
				}
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransDAO.getForeignPODetails() --> "
							+ _Err.getMessage());
			_poDeskViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void getRequestDetails(
			PODeskViewTransVO _poDeskViewTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_req_dtl(?,?,?,?,?,?)}"; //6
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskViewTransDAO.getRequestDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			if(_poDeskViewTransVO.getStrPOTypeId().substring(0,2).equals("21") && _poDeskViewTransVO.getStrpoStatus().equals("1"))
				dao.setProcInValue(nProcIndex, "modeval", "2",1);
			else
				dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskViewTransVO
					.getStrHospitalCode(),4);
			dao.setProcInValue(nProcIndex, "pono", _poDeskViewTransVO
					.getStrPONo(),2);
			dao.setProcInValue(nProcIndex, "store_id", _poDeskViewTransVO
					.getStrStoreId(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
					_poDeskViewTransVO.setWbScheduleDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransDAO.getRequestDetails() --> "
							+ _Err.getMessage());
			_poDeskViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void getItemDetails(
			PODeskViewTransVO _poDeskViewTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_po_item_dtl(?,?,?,?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskViewTransDAO.getItemDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			if(_poDeskViewTransVO.getStrPOTypeId().substring(0,2).equals("21") && _poDeskViewTransVO.getStrpoStatus().equals("1"))
				dao.setProcInValue(nProcIndex, "modeval", "7",1);
			else
				dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskViewTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskViewTransVO
					.getStrPONo(),4);
			dao.setProcInValue(nProcIndex, "storeid", _poDeskViewTransVO
					.getStrStoreId(),3);
			dao.setProcInValue(nProcIndex, "item_id","0",5);
			dao.setProcInValue(nProcIndex, "item_brand_id", "0",6);
			dao.setProcInValue(nProcIndex, "schedule_no", "0",7);
			dao.setProcOutValue(nProcIndex, "err", 1,8);
			dao.setProcOutValue(nProcIndex, "resultset", 2,9);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
					_poDeskViewTransVO.setWbScheduleDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransDAO.getItemDetails() --> "
							+ _Err.getMessage());
			_poDeskViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
}
