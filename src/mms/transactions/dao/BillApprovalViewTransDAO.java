package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.BillApprovalViewTransVO;

public class BillApprovalViewTransDAO {
	/*
	 * Developer : Anurudra Goel
	 * Version : 1.0 
	 * Date : 23/June/2009
	 *  Module:MMS
	 * Unit:Bill Approval View  
	*/
	/**
	 * This function is used fetch Po details for view page
	 */
	public static void getInitDtlView(BillApprovalViewTransVO _BillApprovalViewTransVO){
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "BillApprovalViewTransDAO");
				strproc_name = "{call Pkg_Mms_View.Proc_Po_Detail_Info(?,?,?,?,?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modval","5",1);
				dao.setProcInValue(nprocIndex, "item_category","1",2);
				dao.setProcInValue(nprocIndex, "hosp_code", _BillApprovalViewTransVO.getStrHospitalCode(),3);
				dao.setProcInValue(nprocIndex, "store_Id", _BillApprovalViewTransVO.getStrPoStoreId(),4);
				dao.setProcInValue(nprocIndex, "poNo", _BillApprovalViewTransVO.getStrPoNo(),5);
				
				/* Start */
		
				dao.setProcInValue(nprocIndex, "po_frmdate","0",6);
				dao.setProcInValue(nprocIndex, "po_todate","0",7);
				dao.setProcInValue(nprocIndex, "schedule_no","0",8); 
				/* End */
				
				
				dao.setProcOutValue(nprocIndex, "err", 1,9);
				dao.setProcOutValue(nprocIndex, "resultset", 2,10); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				if (strerr.equals("")) {
				
					wb = dao.getWebRowSet(nprocIndex, "resultset");
					if(wb.next()){
						
						_BillApprovalViewTransVO.setStrPoDate(wb.getString(1));
						_BillApprovalViewTransVO.setStrPoType(wb.getString(3));
						_BillApprovalViewTransVO.setStrSupplierDtl(wb.getString(5));
						_BillApprovalViewTransVO.setStrCurrancyName(wb.getString(11));
						_BillApprovalViewTransVO.setStrCurrancyValue(wb.getString(12));
						_BillApprovalViewTransVO.setStrPOPrefix(wb.getString(17));
						_BillApprovalViewTransVO.setStrPONetAmount(wb.getString(18));
						//System.out.println("Agent Name->"+wb.getString(19));
						_BillApprovalViewTransVO.setStrAgentName(wb.getString(19).replace('^', '#').split("#")[0]);
						_BillApprovalViewTransVO.setStrCAName(wb.getString(19).replace('^', '#').split("#")[1]);
					}
             
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			_BillApprovalViewTransVO.setStrMsgString("BillApprovalViewTransDAO.getInitDtlView() --> "
					+ e.getMessage());
			_BillApprovalViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}

}
/*
 * This function is used to fetch Schedule Detail
 */	
public static void getScheduleView(BillApprovalViewTransVO _BillApprovalViewTransVO){
		
		String strproc_name = "";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet wb = null;
		try {
				dao = new HisDAO("mms", "BillApprovalViewTransDAO");
				strproc_name = "{call Pkg_Mms_View.proc_schedule_dtl_bill_view(?,?,?,?,?,?)}";
				nprocIndex = dao.setProcedure(strproc_name);
				dao.setProcInValue(nprocIndex, "modval","1",1);
				dao.setProcInValue(nprocIndex, "storeId", _BillApprovalViewTransVO.getStrStoreId(),2);
				dao.setProcInValue(nprocIndex, "invoiceNo", _BillApprovalViewTransVO.getStrInvoiceNo(),3);
				dao.setProcInValue(nprocIndex, "hosp_code", _BillApprovalViewTransVO.getStrHospitalCode(),4);
				
				
				dao.setProcOutValue(nprocIndex, "err", 1,5);
				dao.setProcOutValue(nprocIndex, "resultset", 2,6); 
				dao.executeProcedureByPosition(nprocIndex);
				strerr = dao.getString(nprocIndex, "err");
				if (strerr == null)
					strerr = "";
				
				if (strerr.equals("")) {
				
					wb = dao.getWebRowSet(nprocIndex, "resultset");
					_BillApprovalViewTransVO.setScheduleWS(wb);
				} else {
				throw new Exception(strerr);
				}
		} catch (Exception e) {
			e.printStackTrace();
			_BillApprovalViewTransVO.setStrMsgString("BillApprovalViewTransDAO.getScheduleView() --> "
					+ e.getMessage());
			_BillApprovalViewTransVO.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
				wb=null;
			}
		}

}
/*
 * This function is used to fetch Invoice Detail
 */	
public static void getInvoiceView(BillApprovalViewTransVO _BillApprovalViewTransVO){
	
	String strproc_name = "";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strerr = "";
	WebRowSet wb = null;
	try {
			dao = new HisDAO("mms", "BillApprovalViewTransDAO");
			strproc_name = "{call Pkg_Mms_View.Proc_schedule_dtl(?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nprocIndex, "modval","2",1);
			dao.setProcInValue(nprocIndex, "storeId", _BillApprovalViewTransVO.getStrStoreId(),2);
			
			
			dao.setProcInValue(nprocIndex, "invoiceNo", _BillApprovalViewTransVO.getStrInvoiceNo(),3);
			dao.setProcInValue(nprocIndex, "hosp_code", _BillApprovalViewTransVO.getStrHospitalCode(),4);
			dao.setProcInValue(nprocIndex, "poNo", _BillApprovalViewTransVO.getStrPoNo(),5);
			dao.setProcOutValue(nprocIndex, "err", 1,6);
			dao.setProcOutValue(nprocIndex, "resultset", 2,7); 
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			
			
			
			if (strerr.equals("")) {
			
				wb = dao.getWebRowSet(nprocIndex, "resultset");
				if(wb.next()){
					_BillApprovalViewTransVO.setStrTax(wb.getString(1));
					_BillApprovalViewTransVO.setStrAdvanceAmount(wb.getString(2));
					_BillApprovalViewTransVO.setStrPeneltyAmt(wb.getString(3));
					_BillApprovalViewTransVO.setStrWaveOffDtl(wb.getString(4));
					_BillApprovalViewTransVO.setStrWaveOffAmt(wb.getString(5));
					_BillApprovalViewTransVO.setStrApprovedBy(wb.getString(6));
					_BillApprovalViewTransVO.setStrApprovalDate(wb.getString(7));
					_BillApprovalViewTransVO.setStrAdvanceAdjustedAmt(wb.getString(8));
					_BillApprovalViewTransVO.setStrNetcalCost(wb.getString(9));
					_BillApprovalViewTransVO.setStrRemarks(wb.getString(10));
					_BillApprovalViewTransVO.setStrBillNo(wb.getString(11));
					_BillApprovalViewTransVO.setStrBillDate(wb.getString(12));
					_BillApprovalViewTransVO.setStrBillAmt(wb.getString(13));
					
				}
			} else {
			throw new Exception(strerr);
			}
	} catch (Exception e) {
		e.printStackTrace();
		_BillApprovalViewTransVO.setStrMsgString("BillApprovalViewTransDAO.getInvoiceView() --> "
				+ e.getMessage());
		_BillApprovalViewTransVO.setStrMsgType("1");
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			wb=null;
		}
	}

}

}
