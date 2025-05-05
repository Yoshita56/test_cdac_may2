			/******************************************************************************************
			 *                                Process Name : Item Transfer                            *
			 ******************************************************************************************
			 * File Name       : ItemTransferTransDAO.java                                            *
			 * Module Name     : MMS                                                                  *
			 * Developer       : Deepak Tiwari                                                        * 
			 * Version         : 1.0                                                                  * 
			 * Assigned Date   : 1-May-2009                                                           *                                               
			 * Completion Date : 3-May-2009                                                           *
			 * Assigned By     : Ajay Kr. Gupta                                                       *
			 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
			 * Hand over date  : 30-May-2009                                                          *
			 ******************************************************************************************
			 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
			 ******************************************************************************************/


package mms.transactions.dao;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.dao.TransferDtlDAO;
import mms.dao.TransferItemDtlDAO;
import mms.transactions.vo.ItemTransferTransVO;

public class ItemTransferTransDAO
{
	
/**
 * <p>Method::GetData is Used to get values for From Store Combo.
 * <p>Invoked At the time of body on load of Item Transfer Transaction 
 * @param <ItemTransferTransVO>vo
 */
	public static void GetData(ItemTransferTransVO vo) 
	{
		HisDAO dao = null;
		
		WebRowSet wb = null;
		String str1 = null;
		HisUtil hisutil = null;
    	try 
		{
    		hisutil    = new HisUtil("master", "ItemTransferTransDAO");
			wb   = Frm_STORENAMECOMBO(vo);
			if(wb!=null)
			{	
			    if(wb.next())
			    {
			    	vo.setStrFrmStoreId(wb.getString(1));
			    	wb.beforeFirst();
			    }
				str1 = hisutil.getOptionValue(wb, "","", true);
			    vo.setStrStoreName(str1);
			}
			 else
            {
            	str1 = "<option value='0'>DATA N/A</option>";   
            	vo.setStrStoreName(str1);
            }
		} 
    	catch (Exception e) 
    	{
			vo.setStrMsgString("--> ItemTransferTransDAO.GetData()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null)
				dao.free();
			dao = null;
		}

	}
	
	
/**
 * <p>Method::Frm_STORENAMECOMBO is Used to populate the From Store Combo.
 * <p>Invoked At the time of body on load of Item Transfer Transaction 
 * @param <ItemTransferTransVO>vo
 * @return <WebRowSet>ws
 */
	public static WebRowSet Frm_STORENAMECOMBO(ItemTransferTransVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;

		try {

			dao = new HisDAO("ItemTransferTrans","transactions.ItemTransferTransDAO.STORENAMECOMBO(VO)");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "modeval", "11",1);
			dao.setProcInValue(nprocIndex, "seatId", vo.getStrSeatId(),2);
	        dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),3);
	        
	        /* Setting Default Value Start*/
	        dao.setProcInValue(nprocIndex, "storeid", "0",4);
	        dao.setProcInValue(nprocIndex, "storetype_id", "0",5);
	        /* Setting Default Value End */
	        
			dao.setProcOutValue(nprocIndex, "err", 1,6); 													
			dao.setProcOutValue(nprocIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}
		}
		catch (Exception e) {
			vo.setStrMsgString("--> ItemTransferTransDAO.Frm_STORENAMECOMBO()"+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null)
			{
				dao.free();
				dao = null;
			}
		}
		return ws;
	}
	
	
/**
 * <p>Method::To_STORENAMECOMBO is Used to populate To Store Combo.
 * <p>Invoked though AJAX At the time of body on on Change of Item Category Combo 
 * @param <ItemTransferTransVO>vo
 * @return <WebRowSet>ws
 */
	public static WebRowSet To_STORENAMECOMBO(ItemTransferTransVO vo)
	{
		String proc_name = "";
		proc_name = "{call PKG_MMS_VIEW.proc_hstt_toStore_mst(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		int nprocIndex = 0;
		String strerr = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("ItemTransferTrans","transactions.ItemTransferTransDAO.STORENAMECOMBO(VO)");
			nprocIndex = dao.setProcedure(proc_name);
			dao.setProcInValue(nprocIndex, "modeval", "1",1);
			dao.setProcInValue(nprocIndex, "hosp_code", vo.getStrHospitalCode(),2);
	        dao.setProcInValue(nprocIndex, "storeid", vo.getStrFrmStoreId(),3);
	        dao.setProcInValue(nprocIndex, "catCode", vo.getStrItemCatCmb(),5);
	        dao.setProcInValue(nprocIndex, "reqtype", "51",4);
			dao.setProcOutValue(nprocIndex, "err", 1,6); // 1 for string return 														
			dao.setProcOutValue(nprocIndex, "resultset", 2,7); // 2 for object
			dao.executeProcedureByPosition(nprocIndex);
			strerr = dao.getString(nprocIndex, "err");
			if (strerr == null)
				strerr = "";
			if (strerr.equals(""))
			{
				ws = dao.getWebRowSet(nprocIndex, "resultset");
				
				vo.setStrMsgType("0");
			} else {
				throw new Exception(strerr);
			}
		}
		catch (Exception e) 
		{
			vo.setStrMsgString("-->ItemTransferTransDAO.To_STORENAMECOMBO()"+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
		return ws;
	}
	
	
/**
 * <p>Method::itemCategory is Used to populate the ITEM CATEGORY COMBO on the JSP Page.
 * <p>Invoked through AJAX At the time of on Change of From Store Combo 
 * @param <ItemTransferTransVO>vo
 */
	public static void itemCategory(ItemTransferTransVO vo)
	{
		String strProcName = "{call PKG_MMS_VIEW.proc_item_category_list(?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj=new HisDAO("Item Transfer Details","ItemTransferTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "store_id", vo.getStrFrmStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			daoObj.setProcInValue(nProcIndex, "reqType", "51",4);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrItemCategoryComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("ItemTransferTransDAO.itemCategory() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
/**
 * <p>Method::INSERT is Used to invoke Data Access Object.
 * <p>Invoked At the time of body on load of Item Transfer Transaction 
 * @param <ItemTransferTransVO>vo
 */
	public synchronized static void INSERT(ItemTransferTransVO vo) 
	{
		HisDAO dao = null;
		String storeId = null;
		String strItemId = null;
		String strItemBrandId  = null;
		String strBatchNo = null;
		String strExpDate = null;
		String strMaufDate = null;
		String strRate = null;
		String strRateUnitId = null;
		String strConsumableFalg = null;
		String strGrpId = null;
		String strSubGrpId = null;
		String strInhandQty=null;
		String strInhandQtyUnitId=null;
		String strCost     = null;
		String strTransferNo = null;
		String strItemSlNo = null;
		String temp[]=null;
		String strStock_status_code = null;
		float strNetCost     = 0;
		int funcIndex = 0 ;
		// Creating Object for Table Specific DAO
		TransferDtlDAO       TrnsDtl     =  new TransferDtlDAO();
		TransferItemDtlDAO   TrnsItemDtl =  new TransferItemDtlDAO();
		
    	try 
		{
    		  		
    		dao = new HisDAO("MMS","transactions.ItemTransferTransDAO.INSERT()");
    		storeId = vo.getStrStoreName();
    		
    		/* START::Retrieving Transfer No through Function */
    		funcIndex = dao.setFunction("{? = call MMS_MST.generate_transferNo(?::numeric,?::numeric,?::numeric,?::numeric)}");
     	    dao.setFuncInValue(funcIndex,2,vo.getStrHospitalCode());
     	    dao.setFuncInValue(funcIndex,3,storeId);
     	    dao.setFuncInValue(funcIndex,4,"51");
     	    dao.setFuncInValue(funcIndex,5,vo.getStrItemCatCmb());
     		dao.setFuncOutValue(funcIndex,3);
     		dao.executeFuncForNumeric(funcIndex);
     		strTransferNo = dao.getFuncNumeric(funcIndex).toString();
     		vo.setStrTransferNo(strTransferNo);
     		/* END::Retrieving Transfer No through Function */	
     		
 			/* START:PROCEDURE::This procedure is used to insert values into Transfer Detail Table */
 			for(int i = 0 , stopI = vo.getStrTransferQty().length;i<stopI;i++)
			{
				 strCost=vo.getStrTransferCost()[i];
				 strNetCost=strNetCost+Float.parseFloat(strCost);//Calculates the Net Transfer Cost
			}
 			     TrnsDtl.setStrHstNumTransferNo(strTransferNo);
 			     TrnsDtl.setStrHospCode(vo.getStrHospitalCode());
				 TrnsDtl.setStrHstNumFEndYear(vo.getStrFinancialEndYear());
				 TrnsDtl.setStrHstNumFStartYear(vo.getStrFinancialStartYear());
				 TrnsDtl.setStrHstNumStoreId(storeId);
				 TrnsDtl.setStrRemarks(vo.getStrRemarks());
				 TrnsDtl.setStrSeatId(vo.getStrSeatId());
				 TrnsDtl.setStrSstNumItemCatNo(vo.getStrItemCatCmb());
				 TrnsDtl.setStrToStoreId(vo.getStrToStoreId());
				 TrnsDtl.setStrTransferDate(vo.getStrCtDate());
				 TrnsDtl.setStrReceiveBy(vo.getStrReceiveBy());
				 TrnsDtl.setStrNetCost(String.valueOf(strNetCost));
			//	 TrnsDtl.setStrEntryDate(vo.getStrCtDate());
				 TrnsDtl.insert(dao);  // Pkg_Mms_Dml.DML_HSTT_TRANSFER_DTL [ Mode - 1]
		    /* END:PROCEDURE::This procedure is used to insert values into Transfer Detail Table */
				 
		    /* START:PROCEDURE::This procedure is used to insert values into Transfer Item Detail Table */
			for(int i = 0 , stopI = vo.getStrTransferQty().length;i<stopI;i++)
			{
				
				 temp  = vo.getItemUserValue()[i].replace('^', '#').split("#");
				 strItemSlNo=temp[18];	
				 strStock_status_code=temp[32];
				 strItemId =temp[0];
				 
				 
				 if(temp[1]== null||temp[1].equals(""))
        	     {               
					 strItemBrandId  = "0";
        	     }
        	     else
        	     {
        	    	 strItemBrandId = temp[1];
        	     }
				 
				 strBatchNo = temp[15];
				 if(temp[16].trim().equals("/"))
					 strExpDate = ""; 
				 else	 
					 strExpDate = temp[16];
				 
				 strMaufDate        = temp[17];
				 strInhandQty       = temp[7];
				 strInhandQtyUnitId = temp[8];
				 strRate            = temp[9];
				 strRateUnitId      = temp[10];
				 strConsumableFalg  = temp[4];
				 strGrpId           = temp[2];
				 strSubGrpId        = temp[3];
				 
				 TrnsItemDtl.setStrHstNumTransferNo(strTransferNo);
				 TrnsItemDtl.setStrHstNumStoreId(storeId);
				 TrnsItemDtl.setStrSstNumItemCatNo(vo.getStrItemCatCmb());
				 TrnsItemDtl.setStrToStoreId(vo.getStrToStoreId());
				 TrnsItemDtl.setStrHstNumItemId(strItemId);
				 TrnsItemDtl.setStrHstNumItemBrandId(strItemBrandId);  
				 TrnsItemDtl.setStrHstTstrBatchSlNo(strBatchNo);
				 TrnsItemDtl.setStrHstNumItemSlNo(strItemSlNo);
				 TrnsItemDtl.setStrHstNumStockStatusCode(strStock_status_code);
				 TrnsItemDtl.setStrHospCode(vo.getStrHospitalCode());
				 TrnsItemDtl.setStrSeatId(vo.getStrSeatId());
				 TrnsItemDtl.setStrHstNumGrpId(strGrpId);
				 TrnsItemDtl.setStrHstNumSubGrpId(strSubGrpId);
				 TrnsItemDtl.setStrHstNumInHandQty(strInhandQty);
				 TrnsItemDtl.setStrHstNumInHandQtyUnitId(strInhandQtyUnitId);
				 TrnsItemDtl.setStrHstNumRate(strRate);
				 TrnsItemDtl.setStrHstNumRateUnitId(strRateUnitId);
				 TrnsItemDtl.setStrHstNumTrnsQty(vo.getStrTransferQty()[i]);
				 TrnsItemDtl.setStrHstNumTrnsQtyUnitId(vo.getStrUnitName()[i].replace('^', '#').split("#")[0]);
				 TrnsItemDtl.setStrHsTdtExpiryDate(strExpDate);
				 TrnsItemDtl.setStrHstDtTransferDate(vo.getStrCtDate());
				 TrnsItemDtl.setStrHstDtManufDate(strMaufDate);
				 TrnsItemDtl.setStrHstNumConsumeFlg(strConsumableFalg);
				 TrnsItemDtl.setStrGstrRemarks(vo.getStrRemarks());
				 //TrnsItemDtl.setStrHstNumNetCost(String.valueOf(strNetCost));
				 TrnsItemDtl.insert(dao);  // Pkg_Mms_Dml.DML_HSTT_TRANSFER_ITEM_DTL [ Mode - 1]
			}
			/* END:PROCEDURE::This procedure is used to insert values into Transfer Item Detail Table */
		  
			
        	dao.fire();     // Here we Execute in Batch
		  
			
			
		} 
    	catch (Exception e) 
    	{
    		e.printStackTrace();
			vo.setStrMsgString("--> ItemTransferTransDAO.INSERT()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
    	finally 
    	{
			if (dao != null)
			  dao.free();
			dao = null;
		}

	}
	
	
/**
 * <p>Method::getStoreGroupList is Used to populate the GROUP Name Combo on the JSP Page.
 * <p>Invoked through AJAX At the time of onChange of Item Category Combo 
 * @param <ItemTransferTransVO>vo
 */
	public static void getStoreGroupList(ItemTransferTransVO vo) 
	{

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?,?,?,?)}";
        String str1=null;
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;
		WebRowSet wb1 = null;
		HisUtil hisutil = null;
		String str = null;

		try 
		{
			hisutil    = new HisUtil("master", "ItemTransferTransDAO");
			dao = new HisDAO("mms", "ItemTransferTransDAO.getItemParameters(ItemTransferTransVO vo)");
			
			/*  For getting to store names :start */
			wb1  = To_STORENAMECOMBO(vo);
		    if(wb1!=null)
			{	
				str1 = hisutil.getOptionValue(wb1, "0","0^Select Value", true);
				vo.setStrToStoreName(str1);
			}
		    else
	        {
	            str1 = "<option value='0'>DATA N/A</option>";   
	            vo.setStrToStoreName(str1);
	         }
		    /*  For getting to store names :end */
		    
			/*** PROCEDURE::For Getting Group Names ***/
//		    procIndex1 = dao.setProcedure(proc_name1);
//		    
//		    dao.setProcInValue(procIndex1, "modeval", "2");
//			dao.setProcInValue(procIndex1, "item_category", vo.getStrItemCatCmb());
//			dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
//			
//			/* Setting Default Value Start*/
//			dao.setProcInValue(procIndex1, "strPhyStockNo", "");
//			dao.setProcInValue(procIndex1, "strStoreId", "");
//			/* Setting Default Value End */
//			
//			dao.setProcOutValue(procIndex1, "err", 1); // 1 for string return
//			dao.setProcOutValue(procIndex1, "resultset", 2); // 2 for object
//			dao.executeProcedure(procIndex1);
//
//			err = dao.getString(procIndex1, "err");
//
//			if (err == null)
//				err = "";
//
//			ws = dao.getWebRowSet(procIndex1, "resultset");
//			
//			if(ws!=null && ws.size()!=0)
//			{
//				str = hisutil.getOptionValue(ws, "-1","0^Select Value", true);
//				vo.setStrGroupIdForItemSearch(str);					
//			}	
//			else
//			{
//				str = "<option value='0'>DATA N/A</option>";  
//				vo.setStrGroupIdForItemSearch(str);
//			}	
		
		} catch (Exception e)
		{
			vo.setStrMsgString("ItemTransferTransDAO.getStoreGroupList() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	/**
	 * This function is used to set initial values in Received by combo.
	 * @param _ItemTransferTransVO
	 */
	public static void setRecievedByCombo(ItemTransferTransVO _ItemTransferTransVO)
	{
		
		String strProcName = "{call PKG_MMS_VIEW.proc_store_emp_dtl(?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			daoObj  = new HisDAO("MMSModule","IssueDeskTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
						
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			//System.out.println("Stroe Id::::"+_ItemTransferTransVO.getStrToStoreId());
			//System.out.println("Hosp :::"+_ItemTransferTransVO.getStrToStoreId());
			daoObj.setProcInValue(nProcIndex, "storeId", _ItemTransferTransVO.getStrToStoreId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code",_ItemTransferTransVO.getStrHospitalCode(),3);
			daoObj.setProcOutValue(nProcIndex, "err",1,4); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,5);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			
			if(strErr.equals(""))
			{
				_ItemTransferTransVO.setRecievedByWS(ws);
			}
		}
		catch(Exception _err)
		{
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransDAO.setRecievedByCombo() --> "
					+ _err.getMessage());
			_ItemTransferTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to set details in view page(Brakage Item Dtl). 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getViewDtl(ItemTransferTransVO _ItemTransferTransVO)
	{
		
		String strProcName = "{call pkg_mms_view.proc_breakkage_Item_dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			////System.out.println("Welcome to View Dtl");
			daoObj  = new HisDAO("MMSModule","ItemTransferTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			////System.out.println( "modeval"+ "1");
//			//System.out.println( "hosp_code"+ _ItemTransferTransVO.getStrHospitalCode());
//			//System.out.println( "strId"+ _ItemTransferTransVO.getStrStoreName());
//			//System.out.println( "itemCategNo"+ _ItemTransferTransVO.getStrItemCatgCombo());
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", _ItemTransferTransVO.getStrHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "strId", _ItemTransferTransVO.getStrStoreName(),3);
			daoObj.setProcInValue(nProcIndex, "itemCategNo", "",4);
			daoObj.setProcInValue(nProcIndex, "start_date", "",5);
			daoObj.setProcInValue(nProcIndex, "end_date", "",6);
			
			daoObj.setProcOutValue(nProcIndex, "err",1,7); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,8);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				//_ItemTransferTransVO.setBreakageItemWS(ws);
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransDAO.getViewDtl() --> "
					+ _err.getMessage());
			_ItemTransferTransVO.setStrMsgType("1");
		}
	}
	
	/**
	 * This function is used to set details in view page(Brakage Item Dtl). 
	 * @param _BreakageItemDtlTransVO
	 */
	public static void getTransferDtl(ItemTransferTransVO _ItemTransferTransVO)
	{
		
		String strProcName = "{call pkg_mms_view.Proc_Transfer_Detail(?,?,?,?,?,?)}";  // Total 6 Variables
		int nProcIndex = 0;
		String strErr = "";
		
		WebRowSet ws = null;
		HisDAO daoObj=null;
		try
		{
			////System.out.println("Welcome to View Dtl");
			daoObj  = new HisDAO("MMSModule","ItemTransferTransDAO");
			
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code",  _ItemTransferTransVO.getStrHospitalCode(),4);
			daoObj.setProcInValue(nProcIndex, "strId",      _ItemTransferTransVO.getStrStoreName(),3);
			daoObj.setProcInValue(nProcIndex, "transferNo", _ItemTransferTransVO.getStrTransferNo(),2);
			daoObj.setProcOutValue(nProcIndex, "err",1,5); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,6);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if(strErr.equals(""))
			{
				
				_ItemTransferTransVO.setTransferDtlWs(ws);
				
			}
		}
		catch(Exception _err)
		{
			_err.printStackTrace();
			_ItemTransferTransVO.setStrMsgString("ItemTransferTransDAO.getTransferDtl() --> "
					+ _err.getMessage());
			_ItemTransferTransVO.setStrMsgType("1");
		}
	}
	

}
