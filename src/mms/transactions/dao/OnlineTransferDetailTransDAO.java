package mms.transactions.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.DmlHsttPatEmpIssueDtlDAO;
import mms.dao.DmlHsttPatEmpIssueItemDtlDAO;
import mms.transactions.vo.ItemTransferTransVO;
import mms.transactions.vo.OnlineTransferDetailTransVO;

public class OnlineTransferDetailTransDAO 
{
	
	public static void getStoreList(OnlineTransferDetailTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","OnlineTransferDetailTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeval", "5");
			daoObj.setProcInValue(nProcIndex, "seatId", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0");
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
		
				voObj.setStrStoreWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("OnlineTransferDetailTransDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	
	public static void getOrderNo(OnlineTransferDetailTransVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_transfer_order_No_Cmb(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","OnlineTransferDetailTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hstnum_trans_store_id", voObj.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", voObj.getStrHospitalCode());
			
		      

			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrOrderNoWs(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("OnlineTransferDetailTransDAO.getStoreList() --> "+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void getData(OnlineTransferDetailTransVO vo) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_online_transfer_dtl(?,?,?,?,?,  ?,?,?,?,?, ?)}"; // Total variables
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("MMS Transactions","OnlineTransferDetailTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_mode", vo.getStrMode());			
			daoObj.setProcInValue(nProcIndex, "p_hstnum_trans_store_id", vo.getStrStoreId());
			daoObj.setProcInValue(nProcIndex, "p_gnum_hospital_code", vo.getStrHospitalCode());
			
			daoObj.setProcInValue(nProcIndex, "p_item_id", vo.getStrItemId());
			daoObj.setProcInValue(nProcIndex, "p_item_brand_id", vo.getStrItemBrandId());
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "p_order_no", vo.getStrOrderNo());			
			
			daoObj.setProcInValue(nProcIndex, "p_fromdate", vo.getStrFromDate());
			daoObj.setProcInValue(nProcIndex, "p_todate", vo.getStrToDate());
			
			daoObj.setProcInValue(nProcIndex, "p_transfer_No", vo.getStrTransferNo());
			
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				vo.setWrsData(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("OnlineTransferDetailTransDAO.getStoreList() --> "	+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static synchronized void insertDrugTransferDtl(OnlineTransferDetailTransVO vo,HisDAO hisDAO_p) 
	{
	
			int nProcIndex_U;

			String strProcName_U = "";

			try {
				
				strProcName_U = "{call pkg_mms_dml.dml_online_transfer_dtl(?,?,?,?,?,  ?,?,?,?,? )}"; // Total 10 Values
				
				nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
							
				HisUtil.replaceNullValueWithEmptyString(vo);
				
				
				/*
				////System.out.println( "modval"+ vo.getStrMode());//1				
				////System.out.println( "transferno"+ vo.getStrTransferNo());//2 
				////System.out.println( "store_id"+ vo.getStrStoreId());//3
				////System.out.println( "tostore_id"+	vo.getStrToStoreId());//4
				////System.out.println( "item_cat_no"+	"10");//5
				////System.out.println( "hospital_code"+	vo.getStrHospitalCode());//6
				////System.out.println( "orderNo"+ vo.getStrOrderNo());//7
				////System.out.println( "seat_id"+	vo.getStrSeatId());//8
				////System.out.println( "remarks"+ vo.getStrRemarks());//9
			*/
				
				
				
				
				
				//Total 10 variables
				
				
				hisDAO_p.setProcInValue(nProcIndex_U, "modval", vo.getStrMode());//1				
				hisDAO_p.setProcInValue(nProcIndex_U, "transferno", vo.getStrTransferNo());//2 
				hisDAO_p.setProcInValue(nProcIndex_U, "store_id", vo.getStrStoreId());//3
				hisDAO_p.setProcInValue(nProcIndex_U, "tostore_id",	vo.getStrToStoreId());//4
				hisDAO_p.setProcInValue(nProcIndex_U, "item_cat_no",	"10");//5
				hisDAO_p.setProcInValue(nProcIndex_U, "hospital_code",	vo.getStrHospitalCode());//6
				hisDAO_p.setProcInValue(nProcIndex_U, "orderNo", vo.getStrOrderNo());//7
				hisDAO_p.setProcInValue(nProcIndex_U, "seat_id",	vo.getStrSeatId());//8
				hisDAO_p.setProcInValue(nProcIndex_U, "remarks", vo.getStrRemarks());//9
			
				
				/*vo.getStrTotalTransferredCost();
				vo.getStrTotalTransferredQty();*/
				
				/* Default Value */

				hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//10

				hisDAO_p.execute(nProcIndex_U,1);
				
				vo.setStrMsgType("0");
					
		   
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("OnlineTransferDetailTransDAO.insert() --> "+ e.getMessage());
		} 
	}
	
	
	public static synchronized void insertDrugTransferItemDtl(OnlineTransferDetailTransVO vo,HisDAO hisDAO_p) 
	{
			
			int nProcIndex_U;

			String strProcName_U = "";

			try {
				
				strProcName_U = "{call pkg_mms_dml.dml_online_transfer_item_dtl(?,?,?,?,?,  ?,?,?,?,?,  ?,?)}"; // Total 12 Values
				
				nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
							
				HisUtil.replaceNullValueWithEmptyString(vo);
				
			/*	////System.out.println("CheckboxFlag"+vo.getCheckboxFlag().length);
				////System.out.println("TransferQty"+vo.getStrTransferQty().length);*/
				
				for(int i=0;i<vo.getCheckboxFlag().length;i++)
				{	
				           
					if(vo.getCheckboxFlag()[i].equals("1")  )
					{
						if(vo.getStrTransferQty()[i]!=null && !vo.getStrTransferQty()[i].equals("") && vo.getStrTransferQty()[i].length()>0 && !vo.getStrTransferQty()[i].equals("0") && (Integer.parseInt(vo.getStrTransferQty()[i])>0) )
						{
						/*////System.out.println( "modval"+ vo.getStrMode());//1
						////System.out.println( "transferno"+ vo.getStrTransferNo());//2 
						////System.out.println( "store_id"+vo.getStrStoreId());//3
						////System.out.println( "tostore_id"+ vo.getStrToStoreId());//4
						////System.out.println( "item_cat_no"+	"10");//5
						////System.out.println( "itembrand_id"+	vo.getStrItemBrandId());//6
						////System.out.println( "batch_sl_no"+ vo.getStrBatchNo()[i]);//7
						////System.out.println( "transfer_qty"+	vo.getStrTransferQty()[i]);//8
						////System.out.println( "hospital_code"+ vo.getStrHospitalCode());//9
						////System.out.println( "seat_id"+ vo.getStrSeatId());//10
						////System.out.println( "remarks"+ vo.getStrRemarks());//11
						*/
						
						hisDAO_p.setProcInValue(nProcIndex_U, "modval", vo.getStrMode());//1
						hisDAO_p.setProcInValue(nProcIndex_U, "transferno", vo.getStrTransferNo());//2 
						hisDAO_p.setProcInValue(nProcIndex_U, "store_id",vo.getStrStoreId());//3
						hisDAO_p.setProcInValue(nProcIndex_U, "tostore_id", vo.getStrToStoreId());//4
						hisDAO_p.setProcInValue(nProcIndex_U, "item_cat_no",	"10");//5
						hisDAO_p.setProcInValue(nProcIndex_U, "itembrand_id",	vo.getStrItemBrandId());//6
						hisDAO_p.setProcInValue(nProcIndex_U, "batch_sl_no", vo.getStrBatchNo()[i]);//7
						hisDAO_p.setProcInValue(nProcIndex_U, "transfer_qty",	vo.getStrTransferQty()[i]);//8
						hisDAO_p.setProcInValue(nProcIndex_U, "hospital_code", vo.getStrHospitalCode());//9
						hisDAO_p.setProcInValue(nProcIndex_U, "seat_id", vo.getStrSeatId());//10
						hisDAO_p.setProcInValue(nProcIndex_U, "remarks", vo.getStrRemarks());//11
						
						hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//12
						
						//hisDAO_p.executeProcedure(nProcIndex_U);
			
						hisDAO_p.execute(nProcIndex_U, 1);
						}
					}												
						
						/*vo.getStrBatchNo();
						vo.getStrTransferQty();
						vo.getStrAvailableQty();
						vo.getStrRatePerUnit();
						vo.getStrCost();*/
						
						/* Default Value */
				
				}
			
				vo.setStrMsgType("0");
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("OnlineTransferDetailTransDAO.insertDrugTransferItemDtl() --> "+ e.getMessage());
		} 
	}
	
	
	public static synchronized void cancelDrugTransferDtl(OnlineTransferDetailTransVO vo,HisDAO hisDAO_p) 
	{
	
			int nProcIndex_U;

			String strProcName_U = "";

			try {
				
				strProcName_U = "{call pkg_mms_dml.dml_online_transfer_cancel_dtl(?,?,?,?,?,  ?,?)}"; // Total 6 Values
				
				nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
							
				HisUtil.replaceNullValueWithEmptyString(vo);
				
			          
				
				////System.out.println( "modval"+ vo.getStrMode());//1				
				////System.out.println( "transferno"+ vo.getStrTransferNo());//2 
				////System.out.println( "store_id"+ vo.getStrStoreId());//3
				////System.out.println( "hospital_code"+	vo.getStrHospitalCode());//6
				////System.out.println( "seat_id"+	vo.getStrSeatId());//8
				////System.out.println( "remarks"+ vo.getStrRemarks());//9
			
				
				
				
				
				
				//Total 10 variables
				
				
				hisDAO_p.setProcInValue(nProcIndex_U, "modval", vo.getStrMode());//1				
				hisDAO_p.setProcInValue(nProcIndex_U, "transferno", vo.getStrTransferNo());//2 
				hisDAO_p.setProcInValue(nProcIndex_U, "store_id", vo.getStrStoreId());//3
				hisDAO_p.setProcInValue(nProcIndex_U, "hospital_code",	vo.getStrHospitalCode());//6
				hisDAO_p.setProcInValue(nProcIndex_U, "seat_id",	vo.getStrSeatId());//8
				hisDAO_p.setProcInValue(nProcIndex_U, "remarks", vo.getStrRemarks());//9
			
				
				/*vo.getStrTotalTransferredCost();
				vo.getStrTotalTransferredQty();*/
				
				/* Default Value */

				hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//10

				hisDAO_p.executeProcedure(nProcIndex_U);
				
				vo.setStrMsgType("0");
					
		   
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgType("1");
			vo.setStrMsgString("OnlineTransferDetailTransDAO.cancelDrugTransferDtl() --> "+ e.getMessage());
		} 
	}
	
	
	/**
	 * This function is used to get Voucher
	 * @param _ItemTransferTransVO
	 */
	public static void getTransferDtl(OnlineTransferDetailTransVO _OnlineTransferDetailTransVO)
	{
		
		String strProcName = "{call pkg_mms_view.Proc_Transfer_Detail(?,?,?,?,?,?)}";  // Total 6 Variables
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			//////System.out.println("Welcome to View Dtl");
			daoObj  = new HisDAO("MMSModule","OnlineTransferDetailTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "hosp_code",  _OnlineTransferDetailTransVO.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "strId",      _OnlineTransferDetailTransVO.getStrStoreName());
			daoObj.setProcInValue(nProcIndex, "transferNo", _OnlineTransferDetailTransVO.getStrTransferNo());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				
				_OnlineTransferDetailTransVO.setTransferDtlWs(ws);
				
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			_OnlineTransferDetailTransVO.setStrMsgString("OnlineTransferDetailTransDAO.getTransferDtl() --> "
					+ _err.getMessage());
			_OnlineTransferDetailTransVO.setStrMsgType("1");
		}
	}
}

