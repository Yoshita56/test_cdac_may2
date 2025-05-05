/**
 * 
 */
package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.PODeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskCancelTransDAO {
	public static void getPODetails(PODeskCancelTransVO _poDeskCancelTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskCancelTransDAO.getPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskCancelTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskCancelTransVO
					.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _poDeskCancelTransVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				wsResult.next();
				_poDeskCancelTransVO.setStrPODate(wsResult.getString(1));
				_poDeskCancelTransVO
						.setStrSupplierName(wsResult.getString(2));
				_poDeskCancelTransVO.setStrPOType(wsResult.getString(3));
				_poDeskCancelTransVO.setStrSupplierId(wsResult.getString(7));
				_poDeskCancelTransVO.setStrPOTypeId(wsResult.getString(8));
				_poDeskCancelTransVO.setStrItemCat(wsResult.getString(11));
				_poDeskCancelTransVO
						.setStrItemCatName(wsResult.getString(12));
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransDAO.getPODetails() --> "
							+ _Err.getMessage());
			_poDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}

	public static void getForeignPODetails(
			PODeskCancelTransVO _poDeskCancelTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Po_Details(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskCancelTransDAO.getForeignPODetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskCancelTransVO
					.getStrHospitalCode(),2);
			dao.setProcInValue(nProcIndex, "pono", _poDeskCancelTransVO
					.getStrPONo(),3);
			dao.setProcInValue(nProcIndex, "storeId", _poDeskCancelTransVO
					.getStrStoreId(),4);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
				if (wsResult.next()) {
					_poDeskCancelTransVO.setStrAgentId(wsResult.getString(1));
					_poDeskCancelTransVO.setStrCAAgent(wsResult.getString(2));
					_poDeskCancelTransVO.setStrCurrencyCode(wsResult.getString(3));
					_poDeskCancelTransVO.setStrAgentName(wsResult.getString(4));
					_poDeskCancelTransVO.setStrCAAgentName(wsResult.getString(5));
					_poDeskCancelTransVO.setStrCurrency(wsResult.getString(6));
				}
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransDAO.getForeignPODetails() --> "
							+ _Err.getMessage());
			_poDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void getScheduleDetails(
			PODeskCancelTransVO _poDeskCancelTransVO) {
		String strproc_name = "{call pkg_mms_view.proc_schedule_dtl(?,?,?,?,?,?)}";
		HisDAO dao = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			dao = new HisDAO("MMS",
					"transactions.PODeskCancelTransDAO.getScheduleDetails()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskCancelTransVO
					.getStrHospitalCode(),4);
			dao.setProcInValue(nProcIndex, "po_no", _poDeskCancelTransVO
					.getStrPONo(),2);
			dao.setProcInValue(nProcIndex, "po_storeId", _poDeskCancelTransVO
					.getStrStoreId(),3);
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals("")) {
					_poDeskCancelTransVO.setWbScheduleDetail(wsResult);
			} else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransDAO.getScheduleDetails() --> "
							+ _Err.getMessage());
			_poDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wsResult = null;
		}
	}
	
	public static void setEmployeeValues(
			PODeskCancelTransVO _poDeskCancelTransVO) {
		String strproc_name = "{call pkg_mms_view.Proc_Consultant_Name(?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0;

		String strErr = "";
		WebRowSet wsResult = null;

		try {
			util = new HisUtil("MMS",
					"transactions.PODeskCancelTransDAO.setEmployeeValues()");
			dao = new HisDAO("MMS",
					"transactions.PODeskCancelTransDAO.setEmployeeValues()");

			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code", _poDeskCancelTransVO
					.getStrHospitalCode(),3);
			dao.setProcInValue(nProcIndex, "seatId", _poDeskCancelTransVO
					.getStrSeatId(),4);
			
			dao.setProcInValue(nProcIndex, "deptunitcode", "0",2);
			
			dao.setProcOutValue(nProcIndex, "err", 1,5);
			dao.setProcOutValue(nProcIndex, "resultset", 2,6);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			wsResult = dao.getWebRowSet(nProcIndex, "resultset");

			if (strErr == null || strErr.equals(""))
				_poDeskCancelTransVO.setStrEmployeeValues(util
						.getOptionValue(wsResult, "", "0^Select Value", false));
			else
				throw new Exception(strErr);
		} catch (Exception _Err) {
			_poDeskCancelTransVO
					.setStrMsgString("PODeskCancelTransDAO.setEmployeeValues() --> "
							+ _Err.getMessage());
			_poDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			util = null;
			wsResult = null;
		}
	}
	
	public static void insert(PODeskCancelTransVO _poDeskCancelTransVO) {
		String strProcName  = "{call PKG_MMS_DML.dml_hstt_po_Schedule_dtl(?,?,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar)}";
		String strProcName1 =  "{call PKG_MMS_DML.Dml_hstt_po_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//26+ 2(Added by Adil for PO Prefix and PO Date)= 28 Variable
		//String strProcName1 =  "{call PKG_MMS_DML.Dml_hstt_po_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		String strProcName2 = "{call PKG_MMS_DML.dml_hstt_po_item_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//36+ 1(Added by Adil for PO Prefix and PO Date)=37
		String strProcName3 = "{call PKG_MMS_DML.dml_hstt_po_hist_schedule_dtl(?,?,?,?,?,?,?,?,?,?)}";
		String strProcName4 = "{call PKG_MMS_DML.dml_hstt_po_Schedule_dtl(?,?,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar)}";
		String strProcName5 = "{call PKG_MMS_DML.Dml_hstt_po_Dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";	//26+ 2(Added by Adil for PO Prefix and PO Date)= 28 Variable
		
		
		HisDAO dao = null;

		int nProcIndex = 0;
		int nProc1Index = 0;
		int nProc2Index = 0;
		int nProc3Index = 0;
		int nProc4Index = 0;
		int nProc5Index = 0;
		try {
			dao = new HisDAO("MMS","transactions.PODeskCancelTransDAO.insert()");
			
			//if(_poDeskCancelTransVO.getStrDPOCancelOrModify().equals("1")){
				/*nProcIndex = dao.setProcedure(strProcName);
				dao.setProcInValue(nProcIndex, "modeval","3",1);
				dao.setProcInValue(nProcIndex, "store_id",_poDeskCancelTransVO.getStrStoreId(),2);			
				dao.setProcInValue(nProcIndex, "pono",_poDeskCancelTransVO.getStrPONo(),3);
				dao.setProcInValue(nProcIndex, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),5);	
				dao.setProcInValue(nProcIndex, "cancel_by",_poDeskCancelTransVO.getStrDCancelBy(),11);
				dao.setProcInValue(nProcIndex, "cancel_remarks",_poDeskCancelTransVO.getStrDCancelRemarks(),12);
				
				 Setting Default Value Start
				dao.setProcInValue(nProcIndex, "schedule_no","",4);
				dao.setProcInValue(nProcIndex, "schedule_date","",6);
				dao.setProcInValue(nProcIndex, "delivery_date","",7);
				dao.setProcInValue(nProcIndex, "schedule_status","",8);
				dao.setProcInValue(nProcIndex, "penelty","",9);
				dao.setProcInValue(nProcIndex, "cancel_date","",10);
				dao.setProcInValue(nProcIndex,"delivery_loc","",13);
				 Setting Default Value End 
				
				dao.setProcOutValue(nProcIndex, "err",1,14);
				
				dao.executeProcedureByPosition(nProcIndex);*/
	
				
				nProc1Index = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProc1Index, "modeval","2",1);
				dao.setProcInValue(nProc1Index, "store_id",_poDeskCancelTransVO.getStrStoreId(),8);			
				dao.setProcInValue(nProc1Index, "pono",_poDeskCancelTransVO.getStrPONo(),2);
				dao.setProcInValue(nProc1Index, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),3);
				//System.out.println("_poDeskCancelTransVO.getStrPONo()"+_poDeskCancelTransVO.getStrPONo());
				//System.out.println("_poDeskCancelTransVO.getStrStoreId()"+_poDeskCancelTransVO.getStrStoreId());
				//System.out.println("_poDeskCancelTransVO.getStrStoreId()"+_poDeskCancelTransVO.getStrHospitalCode());
				/* Setting Default Value Start*/
				dao.setProcInValue(nProc1Index, "item_cat","",4);
				dao.setProcInValue(nProc1Index, "po_type_id","",5);
				dao.setProcInValue(nProc1Index, "currency_id","0",6);
				dao.setProcInValue(nProc1Index, "pur_source","",7);
				dao.setProcInValue(nProc1Index, "supplier","",9);
				dao.setProcInValue(nProc1Index, "delevery_location","0",10);
				dao.setProcInValue(nProc1Index, "tender_no","0",11);
				dao.setProcInValue(nProc1Index, "tender_date","",12);
				dao.setProcInValue(nProc1Index, "quotation_no","0",13);
				dao.setProcInValue(nProc1Index, "quotation_date","",14);
				dao.setProcInValue(nProc1Index, "fin_start_date","",15);
				dao.setProcInValue(nProc1Index, "fin_end_date","",16);
				dao.setProcInValue(nProc1Index, "po_remarks",_poDeskCancelTransVO.getStrDCancelRemarks(),17);
				dao.setProcInValue(nProc1Index, "currency_value","0",18);
				dao.setProcInValue(nProc1Index, "seat_id",_poDeskCancelTransVO.getStrDCancelBy(),19);
				dao.setProcInValue(nProc1Index, "tax","0",20);
				dao.setProcInValue(nProc1Index, "net_amount","0",21);
				dao.setProcInValue(nProc1Index, "schedule_no","0",22);
				dao.setProcInValue(nProc1Index, "verified_by","",23);
				
				HisUtil hisutil			= new HisUtil("MMS", "PODeskCancelTransDAO");				
				String  strCurrentDate	= hisutil.getASDate("dd-MMM-yyyy");
				
				dao.setProcInValue(nProc1Index, "verified_date",strCurrentDate,24);
				dao.setProcInValue(nProc1Index, "ipAddr","",25);
				
				dao.setProcInValue(nProc1Index, "po_ref_no","",26);
				dao.setProcInValue(nProc1Index, "po_date","",27);
				/* Setting Default Value End */
				
				dao.setProcOutValue(nProc1Index, "err",1,28);
				
				dao.executeProcedureByPosition(nProc1Index);
				
				/*nProc2Index = dao.setProcedure(strProcName2);
				dao.setProcInValue(nProc2Index, "modeval","2",1);
				dao.setProcInValue(nProc2Index, "store_id",_poDeskCancelTransVO.getStrStoreId(),3);			
				dao.setProcInValue(nProc2Index, "pono",_poDeskCancelTransVO.getStrPONo(),2);
				dao.setProcInValue(nProc2Index, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),7);
				
				 Setting Default Value Start
				dao.setProcInValue(nProc2Index, "item_id","0",4);
				dao.setProcInValue(nProc2Index, "item_brand_id","0",5);
				dao.setProcInValue(nProc2Index, "schedule_no","0",6);
				dao.setProcInValue(nProc2Index, "supplier","0",8);
				dao.setProcInValue(nProc2Index, "groupid","0",9);
				dao.setProcInValue(nProc2Index, "subgroup_id","0",10);
				dao.setProcInValue(nProc2Index, "manuf_id","0",11);
				dao.setProcInValue(nProc2Index, "rate","0",12);
				dao.setProcInValue(nProc2Index, "rate_unit","0",13);
				dao.setProcInValue(nProc2Index, "order_qty","0",14);
				dao.setProcInValue(nProc2Index, "order_qty_unit","0",15);
				dao.setProcInValue(nProc2Index, "accepted_qty","0",16);
				dao.setProcInValue(nProc2Index, "accepted_qty_unit","0",17);
				dao.setProcInValue(nProc2Index, "rejected_qty","0",18);
				dao.setProcInValue(nProc2Index, "rejected_qty_unit","0",19);
				dao.setProcInValue(nProc2Index, "breakage_qty","0",20);
				dao.setProcInValue(nProc2Index, "breakage_qty_unit","0",21);
				dao.setProcInValue(nProc2Index, "warrenty_req","0",22);
				dao.setProcInValue(nProc2Index, "installation_req","0",23);
				dao.setProcInValue(nProc2Index, "remarks","",24);
				dao.setProcInValue(nProc2Index, "item_tax","0",25);
				dao.setProcInValue(nProc2Index, "return_qty","0",26);
				dao.setProcInValue(nProc2Index, "return_qty_unit","0",27);
				dao.setProcInValue(nProc2Index, "recieved_qty","0",28);
				dao.setProcInValue(nProc2Index, "recieved_qty_unit","0",29);
				dao.setProcInValue(nProc2Index, "req_no","0",30);
				dao.setProcInValue(nProc2Index, "challanNo","0",31);
				dao.setProcInValue(nProc2Index, "raising_store","0",32);
				dao.setProcInValue(nProc2Index, "po_type","0",33);
				dao.setProcInValue(nProc2Index, "item_make","1",34);
				dao.setProcInValue(nProc2Index, "itemName","",35);
				dao.setProcInValue(nProc2Index, "po_date","",36);
				 Setting Default Value End 
				dao.setProcInValue(nProc2Index, "delivery_loc","0",37);
				dao.setProcOutValue(nProc2Index, "err",1,38);
				
				dao.executeProcedureByPosition(nProc2Index);
				
				nProc5Index = dao.setProcedure(strProcName5);
				dao.setProcInValue(nProc5Index, "modeval","3",1);
				dao.setProcInValue(nProc5Index, "store_id",_poDeskCancelTransVO.getStrStoreId(),8);			
				dao.setProcInValue(nProc5Index, "pono",_poDeskCancelTransVO.getStrPONo(),2);
				dao.setProcInValue(nProc5Index, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),3);
				dao.setProcInValue(nProc5Index, "po_type_id",_poDeskCancelTransVO.getStrPOTypeId(),5);
				
				 Setting Default Value Start
				dao.setProcInValue(nProc5Index, "item_cat","",4);
				dao.setProcInValue(nProc5Index, "currency_id","0",6);
				dao.setProcInValue(nProc5Index, "pur_source","",7);
				dao.setProcInValue(nProc5Index, "supplier","",9);
				dao.setProcInValue(nProc5Index, "delevery_location","0",10);
				dao.setProcInValue(nProc5Index, "tender_no","0",11);
				dao.setProcInValue(nProc5Index, "tender_date","",12);
				dao.setProcInValue(nProc5Index, "quotation_no","0",13);
				dao.setProcInValue(nProc5Index, "quotation_date","",14);
				dao.setProcInValue(nProc5Index, "fin_start_date","",15);
				dao.setProcInValue(nProc5Index, "fin_end_date","",16);
				dao.setProcInValue(nProc5Index, "po_remarks","",17);
				dao.setProcInValue(nProc5Index, "currency_value","0",18);
				dao.setProcInValue(nProc5Index, "seat_id",_poDeskCancelTransVO.getStrSeatId(),19);
				dao.setProcInValue(nProc5Index, "tax","0",20);
				dao.setProcInValue(nProc5Index, "net_amount","0",21);
				dao.setProcInValue(nProc5Index, "schedule_no","0",22);
				dao.setProcInValue(nProc5Index, "verified_by","",23);
				
				hisutil = new HisUtil("MMS", "PODeskCancelTransDAO");				
				strCurrentDate	= hisutil.getASDate("dd-MMM-yyyy");
				
				dao.setProcInValue(nProc5Index, "verified_date",strCurrentDate,24);
				dao.setProcInValue(nProc5Index, "ipAddr","",25);
				
				dao.setProcInValue(nProc5Index, "po_ref_no","",26);
				dao.setProcInValue(nProc5Index, "po_date","",27);

				 Setting Default Value End 
				
				dao.setProcOutValue(nProc5Index, "err",1,28);
				
				dao.executeProcedureByPosition(nProc5Index);*/
			/*} 
			else
			{*/
				
				/*nProc3Index = dao.setProcedure(strProcName3);
				dao.setProcInValue(nProc3Index, "modeval","1",1);
				dao.setProcInValue(nProc3Index, "store_id",_poDeskCancelTransVO.getStrStoreId(),2);			
				dao.setProcInValue(nProc3Index, "pono",_poDeskCancelTransVO.getStrPONo(),3);
				dao.setProcInValue(nProc3Index, "schedule_no",_poDeskCancelTransVO.getStrDScheduleNo(),4);
				dao.setProcInValue(nProc3Index, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),5);
				dao.setProcInValue(nProc3Index, "delivery_date",_poDeskCancelTransVO.getStrDOldDeliveryDate(),6);
				dao.setProcInValue(nProc3Index, "approved_by",_poDeskCancelTransVO.getStrDApprovedBy(),7);
				dao.setProcInValue(nProc3Index, "approval_date",_poDeskCancelTransVO.getStrDApprovedDate(),8);
				dao.setProcInValue(nProc3Index, "seatid",_poDeskCancelTransVO.getStrSeatId(),9);
				dao.setProcOutValue(nProc3Index, "err",1,10);
				
				dao.executeProcedureByPosition(nProc3Index);
				
				nProc4Index = dao.setProcedure(strProcName4);
				dao.setProcInValue(nProc4Index, "modeval","4",1);
				dao.setProcInValue(nProc4Index, "store_id",_poDeskCancelTransVO.getStrStoreId(),2);			
				dao.setProcInValue(nProc4Index, "pono",_poDeskCancelTransVO.getStrPONo(),3);
				dao.setProcInValue(nProc4Index, "schedule_no",_poDeskCancelTransVO.getStrDScheduleNo(),4);
				dao.setProcInValue(nProc4Index, "hosp_code",_poDeskCancelTransVO.getStrHospitalCode(),5);
				dao.setProcInValue(nProc4Index, "delivery_date",_poDeskCancelTransVO.getStrDDeliveryDate(),7);
				
				 Setting Default Value Start
				dao.setProcInValue(nProc4Index, "schedule_date","",6);
				dao.setProcInValue(nProc4Index, "schedule_status","",8);
				dao.setProcInValue(nProc4Index, "penelty","",9);
				dao.setProcInValue(nProc4Index, "cancel_date","",10);
				dao.setProcInValue(nProc4Index, "cancel_by","",11);
				dao.setProcInValue(nProc4Index, "cancel_remarks","",12);
				dao.setProcInValue(nProc4Index,"delivery_loc","",13);
				 Setting Default Value End 
				
				dao.setProcOutValue(nProc4Index, "err",1,14);
				
				dao.executeProcedureByPosition(nProc4Index);*/
			//}

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_poDeskCancelTransVO.setStrMsgString("PODeskCancelTransDAO.insert() --> "+ _Err.getMessage());
			_poDeskCancelTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
}
