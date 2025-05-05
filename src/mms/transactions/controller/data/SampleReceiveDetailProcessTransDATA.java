package mms.transactions.controller.data;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.SampleReceiveDetailProcessTransBO;
import mms.transactions.controller.fb.SampleReceiveDetailProcessTransFB;
import mms.transactions.controller.hlp.SampleReceiveDetailProcessTransHLP;
import mms.transactions.vo.SampleReceiveDetailProcessTransVO;
import mms.transactions.vo.SampleSentTransVO;

public class SampleReceiveDetailProcessTransDATA {
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param SampleReceiveDetailProcessTransFB_p
	 * @param request_p
	 */
//	public static void getFinancialYearCombo(SampleReceiveDetailProcessTransFB SampleReceiveDetailProcessTransFB_p,HttpServletRequest request_p)
//	{
//		SampleReceiveDetailProcessTransBO	SampleReceiveDetailProcessTransBO = null; 
//		SampleReceiveDetailProcessTransVO	SampleReceiveDetailProcessTransVO  = null;
//		String strCurrentDate;
//		String strMsgText;
//		HisUtil hisutil = null;
//		
//		int strCurrentMonth;
//		int CURRENT_YEAR;
//		
//		String strCurrentFinancialYear;
//		String strNextFinancialYear; 
//		
//		try {
//			SampleReceiveDetailProcessTransBO = new SampleReceiveDetailProcessTransBO();
//			SampleReceiveDetailProcessTransVO = new SampleReceiveDetailProcessTransVO();
//			
//			hisutil = new HisUtil("DWH Transaction","SampleReceiveDetailProcessTransDATA");
//			
//			/*if(request.getParameter("mode") != null){
//				
//				String strMode = request.getParameter("mode");
//				formBean.setStrMode(strMode);
//				
//			}*/
//			
//			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
//			
//			
//			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
//			
//			
//			if(strCurrentMonth>=4 ){
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
//			}
//			else
//			{
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
//			}
//				
//			
//			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
//			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
//			
//			// For setting the financial year combo
//			SampleReceiveDetailProcessTransFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
//			SampleReceiveDetailProcessTransFB_p.setStrNextFinancialYear(strNextFinancialYear);
//			
//			
//			
//		} catch (Exception e) {
//			strMsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.getStoreDtls --> "
//					+ e.getMessage();
//			HisException eObj = new HisException("mms",
//					"SampleReceiveDetailProcessTransDATA->getStoreDtls()", strMsgText);
//			SampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
//					+ eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		} finally {
//
//			if (SampleReceiveDetailProcessTransBO != null)
//				SampleReceiveDetailProcessTransBO = null;
//			if (SampleReceiveDetailProcessTransVO != null)
//				SampleReceiveDetailProcessTransVO = null;
//			if (hisutil != null)
//				hisutil = null;
//		}
//		
//	}
	
	
	
	public static void getDrugWareHouseNameCombo(SampleReceiveDetailProcessTransFB formBean, HttpServletRequest request) {

		SampleReceiveDetailProcessTransBO bo = null;
		SampleReceiveDetailProcessTransVO vo = null;
		HisUtil hisUtil=null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new SampleReceiveDetailProcessTransBO();
			vo = new SampleReceiveDetailProcessTransVO();
			hisUtil=new HisUtil("MMSModule", "SampleReceiveDetailProcessTransDATA");

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDrugWareHouseNameCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "SampleReceiveDetailProcessTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{
				if(vo.getWrsDrugWareHouseNameCmb().next())
				{
					formBean.setStrStoreId(vo.getWrsDrugWareHouseNameCmb().getString(1));
					vo.getWrsDrugWareHouseNameCmb().beforeFirst();
				}
				
				if(formBean.getStrStoreId()!=null && !formBean.getStrStoreId().equals(""))
				{
					strStoreVal = util.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), formBean.getStrStoreId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = util.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
				}
				
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
			String 	strCmb = "";		
			if(vo.getItemCategoryComboWS()!=null && vo.getItemCategoryComboWS().size() > 0)
			{		
				strCmb = util.getOptionValue(vo.getItemCategoryComboWS(),"", "", false);
			}
			else 
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCatNoCmb(strCmb);
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
			formBean.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			
			strCmb ="";
			if(vo.getWrsSampleSentDWHCmb()!=null && vo.getWrsSampleSentDWHCmb().size() > 0)
			{		
			
				strCmb = util.getOptionValue(vo.getWrsSampleSentDWHCmb(),"0","All" , false);
				
			}
			else 
			{
				strCmb = "<option value='0'>All</option>";
			}
			
			formBean.setStrSampleSentDWHCombo(strCmb);
			
			
			strCmb ="";
			
			if(vo.getWrsDWHItemCmb()!=null && vo.getWrsDWHItemCmb().size() > 0)
			{		
			
				strCmb = util.getOptionValue(vo.getWrsDWHItemCmb(),"0","All" , false);
				
			}
			else 
			{
				strCmb = "<option value='0'>All</option>";
			}
			
			formBean.setStrItemBrandIDCombo(strCmb);
			
			
		} catch (Exception e) {
			strMsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleReceiveDetailProcessTransDATA->getDrugWareHouseNameCombo()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	/**
	 * This function is used to display Item Category Name on the basis of Drug Warehouse Name: 
	 * @param formBean
	 */
	public static void itemCatNo(SampleReceiveDetailProcessTransFB formBean_p,HttpServletRequest request_p,
			HttpServletResponse response_p) {
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String strCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","SampleReceiveDetailProcessTransDATA");
			vo = new SampleReceiveDetailProcessTransVO();
			bo = new SampleReceiveDetailProcessTransBO();
							
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request_p.getSession().getAttribute("SEATID").toString();
			storeID = (String) request_p.getParameter("drugWarehouseId");
			
			formBean_p.setStrSeatId(seatid);
			formBean_p.setStrHospitalCode(hosCode);
			formBean_p.setStrDrugWareHouseId(storeID);
			formBean_p.setStrNormalMsg("");
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrDrugWareHouseId(formBean_p.getStrDrugWareHouseId());
			//vo.setStrStoreId(formBean_p.getStrStoreId());
				
			bo.getItemCatNo(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getItemCategoryComboWS()!=null
					&& vo.getItemCategoryComboWS().size() > 0){		
			/*	while(vo.getItemCategoryComboWS().next())
				{
				////System.out.println("vo.getItemCategoryComboWS().getString(1)"+vo.getItemCategoryComboWS().getString(1));
				////System.out.println("vo.getItemCategoryComboWS().getString(2)"+vo.getItemCategoryComboWS().getString(2));
			
				}*/
				strCmb = hisutil.getOptionValue(vo.getItemCategoryComboWS(),"", "", false);
			}else {
				strCmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "SampleReceiveDetailProcessTransDATA->itemCatNo()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean_p != null) formBean_p = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display Item Category Name on the basis of Drug Warehouse Name: 
	 * @param formBean
	 */
	public static void getSampleSentDWH(SampleReceiveDetailProcessTransFB formBean_p,HttpServletRequest request_p,
			HttpServletResponse response_p) {
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String strCmb = "";
		String strItemCategoryNo = "";
		
			
		try {
			hisutil = new HisUtil("MMS","SampleReceiveDetailProcessTransDATA");
			     vo = new SampleReceiveDetailProcessTransVO();
			     bo = new SampleReceiveDetailProcessTransBO();
							
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			 seatid = request_p.getSession().getAttribute("SEATID").toString();
			storeID = (String) request_p.getParameter("drugWarehouseId");
			strItemCategoryNo = (String) request_p.getParameter("ItemCatgNo");
			
			
			formBean_p.setStrSeatId(seatid);
			formBean_p.setStrHospitalCode(hosCode);
			formBean_p.setStrDrugWareHouseId(storeID);
			formBean_p.setStrNormalMsg("");
			formBean_p.setStrItemCategoryNo(strItemCategoryNo);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrDrugWareHouseId(formBean_p.getStrDrugWareHouseId());
			vo.setStrItemCategoryNo(strItemCategoryNo);
			//vo.setStrStoreId(formBean_p.getStrStoreId());
				
			bo.getSampleSentDWH(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getWrsSampleSentDWHCmb()!=null && vo.getWrsSampleSentDWHCmb().size() > 0)
			{		
			
				strCmb = hisutil.getOptionValue(vo.getWrsSampleSentDWHCmb(),"0","All" , false);
				
			}
			else 
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "SampleReceiveDetailProcessTransDATA->getSampleSentDWH()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean_p != null) formBean_p = null;
			hisutil = null;
		}
	}
	
	/**
	 * This function is used to display Item Category Name on the basis of Drug Warehouse Name: 
	 * @param formBean
	 */
	public static void getSampleSentDWHItemName(SampleReceiveDetailProcessTransFB formBean_p,HttpServletRequest request_p,
			HttpServletResponse response_p) {
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String strCmb = "";
		String strItemCategoryNo = "";
		
			
		try {
			hisutil = new HisUtil("MMS","SampleReceiveDetailProcessTransDATA");
			     vo = new SampleReceiveDetailProcessTransVO();
			     bo = new SampleReceiveDetailProcessTransBO();
							
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			 seatid = request_p.getSession().getAttribute("SEATID").toString();
			storeID = (String) request_p.getParameter("drugWarehouseId");
			strItemCategoryNo = (String) request_p.getParameter("ItemCatgNo");
			
			
			formBean_p.setStrSeatId(seatid);
			formBean_p.setStrHospitalCode(hosCode);
			formBean_p.setStrDrugWareHouseId(storeID);
			formBean_p.setStrNormalMsg("");
			formBean_p.setStrItemCategoryNo(strItemCategoryNo);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrDrugWareHouseId(formBean_p.getStrDrugWareHouseId());
			vo.setStrItemCategoryNo(strItemCategoryNo);
			
				
			bo.getSampleSentDWHItemName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getWrsDWHItemCmb()!=null && vo.getWrsDWHItemCmb().size() > 0)
			{		
			
				strCmb = hisutil.getOptionValue(vo.getWrsDWHItemCmb(),"0","All" , false);
				
			}
			else 
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
		
			try {									
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
				////System.out.println("Item Cmb:::"+strCmb);
				
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "SampleReceiveDetailProcessTransDATA->getSampleSentDWHItemName()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean_p != null) formBean_p = null;
			hisutil = null;
		}
	}
	
	public static void getIssueDrugDtls(
			SampleReceiveDetailProcessTransFB sampleReceiveDetailProcessTransFB_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {
		// TODO Auto-generated method stub
		
		
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		HisUtil util = null;
		String strmsgText = null;
		
		try 
		{
			bo = new SampleReceiveDetailProcessTransBO();
			vo = new SampleReceiveDetailProcessTransVO();
			
			sampleReceiveDetailProcessTransFB_p.setStrNormalMsg("");
			vo.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			//vo.setStrSupplierId(request_p.getParameter("supplierId"));
			vo.setStrDrugWareHouseId(request_p.getParameter("drugWarehouseId"));
			vo.setStrItemCategoryNo(request_p.getParameter("itemCategoryNo"));
			vo.setStrDrugWareHouseName(request_p.getParameter("itemCategoryName"));
			vo.setStrSampleSentDWHId(request_p.getParameter("sampleSentDwhId"));
			vo.setStrItemBrandID( request_p.getParameter("ItemBrandId"));
			////System.out.println("Item Batch:" +request_p.getParameter("ItemBatch"));
			vo.setStrBatchNo(request_p.getParameter("ItemBatch"));
			
			
			bo.getIssueDrugDtls(vo);
			String strItemDetails = SampleReceiveDetailProcessTransHLP.getIssueDrugDtlsHlp(vo);
			
			
			response_p.setHeader("Cache-Control", "no-cache");
			response_p.getWriter().print(strItemDetails);	
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
				
		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.getIssueDrugDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleReceiveDetailProcessTransDATA->getIssueDrugDtls()", strmsgText);
			sampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			eObj = null;
		}
		finally 
		{
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
			}
		
	}
	
	/**
	 * This function is used to display Item Category Name on the basis of Drug Warehouse Name: 
	 * @param formBean
	 */
	public static void getItemBatchName(SampleReceiveDetailProcessTransFB formBean_p,HttpServletRequest request_p,
			HttpServletResponse response_p) {
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String storeID = "";
		String strCmb = "";
		String strItemCategoryNo = "";
		String strItemBrandID="";
		
			
		try {
			hisutil = new HisUtil("MMS","SampleReceiveDetailProcessTransDATA");
			     vo = new SampleReceiveDetailProcessTransVO();
			     bo = new SampleReceiveDetailProcessTransBO();
							
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			 seatid = request_p.getSession().getAttribute("SEATID").toString();
			storeID = (String) request_p.getParameter("drugWarehouseId");
			strItemCategoryNo = (String) request_p.getParameter("ItemCatgNo");
			strItemBrandID = (String) request_p.getParameter("ItemBrandId");
			
			
			formBean_p.setStrSeatId(seatid);
			formBean_p.setStrHospitalCode(hosCode);
			formBean_p.setStrDrugWareHouseId(storeID);
			formBean_p.setStrNormalMsg("");
			formBean_p.setStrItemCategoryNo(strItemCategoryNo);
			formBean_p.setStrItemBrandID(strItemBrandID);
			
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrDrugWareHouseId(formBean_p.getStrDrugWareHouseId());
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrItemBrandID(strItemBrandID);
				
			bo.getItemBatchList(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getWrsDWHItemBatchCmb()!=null && vo.getWrsDWHItemBatchCmb().size() > 0)
			{		
			
				strCmb = hisutil.getOptionValue(vo.getWrsDWHItemBatchCmb(),"0","All" , false);
				
			}
			else 
			{
				strCmb = "<option value='-1'>Select Value</option>";
			}
		
			try {									
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "SampleReceiveDetailProcessTransDATA->getItemBatchName()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean_p != null) formBean_p = null;
			hisutil = null;
		}
	}
	
	
	public static void insert(SampleReceiveDetailProcessTransFB sampleReceiveDetailProcessTransFB_p, HttpServletRequest request_p, HttpServletResponse response_p) {
		
		SampleReceiveDetailProcessTransVO vo=null;
		SampleReceiveDetailProcessTransBO bo= null;
		String strmsgText = null;
		
		try 
		{
			bo = new SampleReceiveDetailProcessTransBO();
			vo = new SampleReceiveDetailProcessTransVO();
			//mcu = new MmsConfigUtil();
															
		
			vo.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			vo.setStrDrugWareHouseId(sampleReceiveDetailProcessTransFB_p.getStrDrugWareHouseId());
			vo.setStrItemCategoryNo(sampleReceiveDetailProcessTransFB_p.getStrItemCategoryNo());
			vo.setStrCheckHidValue(sampleReceiveDetailProcessTransFB_p.getStrCheckHidValue());
			vo.setStrIssueChkIndex(sampleReceiveDetailProcessTransFB_p.getStrIssueChkIndex());
			vo.setStrDrugWareHouseName(sampleReceiveDetailProcessTransFB_p.getStrDrugWareHouseName());
			vo.setStrBkgQty(sampleReceiveDetailProcessTransFB_p.getStrBkgQty());
			
			bo.saveSampleReceiveDtl(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}else{
				sampleReceiveDetailProcessTransFB_p.setStrNormalMsg("Record Successfully saved");
			}
							
		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.insert() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleReceiveDetailProcessTransDATA->insert()", strmsgText);
			sampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			eObj = null;
		}
		finally 
		{
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
		}
	}

	public static void viewSampleReceive(
			SampleReceiveDetailProcessTransFB sampleReceiveDetailProcessTransFB_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {
		
		SampleReceiveDetailProcessTransBO bo = null;
		SampleReceiveDetailProcessTransVO vo = null;
		//MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		
		try 
		{
			bo = new SampleReceiveDetailProcessTransBO();
			vo = new SampleReceiveDetailProcessTransVO();
			//mcu = new MmsConfigUtil();
															
		
			vo.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			vo.setStrDrugWareHouseId(request_p.getParameter("drugWarehouseId"));
			vo.setStrItemCategoryNo(request_p.getParameter("itemCategoryNo"));
			vo.setStrFromDate(request_p.getParameter("fromDate"));
			vo.setStrToDate(request_p.getParameter("toDate"));
			
			bo.getViewSampleReceiveHlp(vo);
			
			String strSampleSentLabel = SampleReceiveDetailProcessTransHLP.getViewSampleReceiveDetailsHlp(vo);
			
			
			
			response_p.setHeader("Cache-Control", "no-cache");
			response_p.getWriter().print(strSampleSentLabel);	
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
				
		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.viewSampleReceive() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleReceiveDetailProcessTransDATA->viewSampleReceive()", strmsgText);
			sampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			eObj = null;
		}
		finally 
		{
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
		
		
	}

	public static void viewSampleReceivePrint(
			SampleReceiveDetailProcessTransFB sampleReceiveDetailProcessTransFB_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {
		
		SampleReceiveDetailProcessTransBO bo = null;
		SampleReceiveDetailProcessTransVO vo = null;
		//MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strmsgText = null;
		
		try 
		{
			bo = new SampleReceiveDetailProcessTransBO();
			vo = new SampleReceiveDetailProcessTransVO();
			//mcu = new MmsConfigUtil();
															
		
			vo.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			vo.setStrDrugWareHouseId(request_p.getParameter("drugWarehouseId"));
			vo.setStrItemCategoryNo(request_p.getParameter("itemCategoryNo"));
			vo.setStrDrugWareHouseName(request_p.getParameter("drugWarehouseName"));
			vo.setStrFromDate(request_p.getParameter("fromDate"));
			vo.setStrToDate(request_p.getParameter("toDate"));
			
			bo.getViewSampleReceiveHlp(vo);
			
			String strSampleSentLabel = SampleReceiveDetailProcessTransHLP.getViewSampleReceiveDetailsHlpPrint(vo);
			
			
			
			response_p.setHeader("Cache-Control", "no-cache");
			response_p.getWriter().print(strSampleSentLabel);	
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
				
		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.viewSampleReceivePrint() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleReceiveDetailProcessTransDATA->viewSampleReceivePrint()", strmsgText);
			sampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			
			eObj = null;
		}
		finally 
		{
		
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
		
	}
	
		
	
//	public static void getPrevBudgetDtls(SampleReceiveDetailProcessTransFB SampleReceiveDetailProcessTransFB_p,HttpServletrequest_p request_p_p, HttpServletResponse response_p) 
//	{
//		
//		SampleReceiveDetailProcessTransBO	SampleReceiveDetailProcessTransBO = null; 
//		SampleReceiveDetailProcessTransVO	SampleReceiveDetailProcessTransVO  = null;
//		String strFinancialYear;
//		String strMsgText;
//		HisUtil hisutil = null;
//		
//		int strCurrentMonth;
//		int CURRENT_YEAR;
//		String strCurrentDate;
//		
//		
//		String strCurrentFinancialYear;
//		String strNextFinancialYear; 
//		String strHospitalCode;
//		
//		String strTempPrevYrBudget="";
//		
//		try {
//			SampleReceiveDetailProcessTransBO = new SampleReceiveDetailProcessTransBO();
//			SampleReceiveDetailProcessTransVO = new SampleReceiveDetailProcessTransVO();
//			
//			hisutil = new HisUtil("DWH Transaction","SampleReceiveDetailProcessTransDATA");
//			
//			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
//			
//			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
//			
//			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
//			
//			
//			if(strCurrentMonth>=4 ){
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
//			}
//			else
//			{
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
//			}
//				
//			
//			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
//			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
//			
//			strFinancialYear =	SampleReceiveDetailProcessTransFB_p.getStrFinancialYear();
//				
//			if(strFinancialYear!=null)
//			{
//				
//				
//				if(strFinancialYear.equals("1"))
//				{
//					strTempPrevYrBudget = strCurrentFinancialYear;
//				}
//				else if(strFinancialYear.equals("2"))
//				{
//					strTempPrevYrBudget = strNextFinancialYear;
//				}
//
//				SampleReceiveDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[0].trim() ) - 1));
//				SampleReceiveDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[1].trim() ) - 1));
//				
//			}
//			
//			SampleReceiveDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
//			SampleReceiveDetailProcessTransVO.setStrDrugWareHouseName(SampleReceiveDetailProcessTransFB_p.getStrDrugWareHouseName());
//			
//			
//			//CALLING BO
//			SampleReceiveDetailProcessTransBO.getPrevRemainingBudgetDtls(SampleReceiveDetailProcessTransVO);//Previous Budget
//			
//			if(SampleReceiveDetailProcessTransVO.getStrMsgType().equals("1"))
//			{
//				throw new Exception();
//			}
//			
//			
//			if(SampleReceiveDetailProcessTransVO.getWrsData()!=null && SampleReceiveDetailProcessTransVO.getWrsData().size()>0)
//			{
//				
//				if(SampleReceiveDetailProcessTransVO.getWrsData().next()){
//					// For setting the form bean values
//					SampleReceiveDetailProcessTransFB_p.setStrPreviousYearRemainingBudget(SampleReceiveDetailProcessTransVO.getWrsData().getString(1).toString());
//				}
//				
//			}
//			else
//			{
//				SampleReceiveDetailProcessTransFB_p.setStrPreviousYearRemainingBudget("0");
//			}
//			
//			
//			SampleReceiveDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[0].trim() )));
//			SampleReceiveDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[1].trim() )));
//			
//			
//			//CALLING BO
//			SampleReceiveDetailProcessTransBO.getLastAllocatedBudgetDtls(SampleReceiveDetailProcessTransVO);//Initial Budget
//			
//			if(SampleReceiveDetailProcessTransVO.getStrMsgType().equals("1"))
//			{
//				throw new Exception();
//			}
//			
//			if(SampleReceiveDetailProcessTransVO.getWrsData()!=null && SampleReceiveDetailProcessTransVO.getWrsData().size()>0)
//			{
//				
//				if(SampleReceiveDetailProcessTransVO.getWrsData().next()){
//					
//				
//				SampleReceiveDetailProcessTransFB_p.setStrLastAllocatedBudget(SampleReceiveDetailProcessTransVO.getWrsData().getString(1).toString());
//				SampleReceiveDetailProcessTransFB_p.setStrRemarks(SampleReceiveDetailProcessTransVO.getWrsData().getString(2).toString());
//				}
//			}
//			else
//			{
//				SampleReceiveDetailProcessTransFB_p.setStrLastAllocatedBudget("0");
//				SampleReceiveDetailProcessTransFB_p.setStrRemarks("");
//			}
//			
//			String strTempStoreId=SampleReceiveDetailProcessTransFB_p.getStrStoreId();
//			
//			if(strTempStoreId!=null)
//			{
//				SampleReceiveDetailProcessTransFB_p.setStrDrugWareHouseName(strTempStoreId);
//			}
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//			strMsgText = "mms.transactions.SampleReceiveDetailProcessTransDATA.getPrevBudgetDtls --> " + e.getMessage();
//			HisException eObj = new HisException("mms",	"SampleReceiveDetailProcessTransDATA->getPrevBudgetDtls()", strMsgText);
//			SampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
//			eObj = null;
//		} 
//		finally 
//		{
//
//			if (SampleReceiveDetailProcessTransBO != null)
//				SampleReceiveDetailProcessTransBO = null;
//			
//			if (SampleReceiveDetailProcessTransVO != null)
//				SampleReceiveDetailProcessTransVO = null;
//			
//			if (hisutil != null)
//				hisutil = null;
//		}
//	}
//
//
//	public static void saveBudgetDtls(SampleReceiveDetailProcessTransFB SampleReceiveDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
//	{
//		SampleReceiveDetailProcessTransBO SampleReceiveDetailProcessTransBO = null;
//		SampleReceiveDetailProcessTransVO SampleReceiveDetailProcessTransVO = null;
//		String strMsgText = "";
//		HisUtil hisutil = null;
//		
//		int strCurrentMonth;
//		int CURRENT_YEAR;
//		String strCurrentDate;
//		
//		String strCurrentFinancialYear;
//		String strNextFinancialYear; 
//		
//		String strFinancialYear;
//		
//		String strTempBudget="";
//		
//		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
//		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
//		
//		try {
//			SampleReceiveDetailProcessTransBO = new SampleReceiveDetailProcessTransBO();
//			SampleReceiveDetailProcessTransVO = new SampleReceiveDetailProcessTransVO();
//
//			
//
//			hisutil = new HisUtil("DWH Transaction","SampleReceiveDetailProcessTransDATA");
//			
//			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
//			
//			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
//			
//			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
//			
//			
//			if(strCurrentMonth>=4 ){
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
//			}
//			else
//			{
//				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
//			}
//				
//			
//			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
//			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
//			
//			strFinancialYear =	SampleReceiveDetailProcessTransFB_p.getStrFinancialYear();
//				
//			if(strFinancialYear!=null)
//			{
//				
//				
//				if(strFinancialYear.equals("1"))
//				{
//					strTempBudget = strCurrentFinancialYear;
//				}
//				else if(strFinancialYear.equals("2"))
//				{
//					strTempBudget = strNextFinancialYear;
//				}
//
//				SampleReceiveDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strTempBudget.split("\\-")[0].trim() )));
//				SampleReceiveDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strTempBudget.split("\\-")[1].trim() )));
//				
//			}
//			
//			SampleReceiveDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
//			SampleReceiveDetailProcessTransVO.setStrDrugWareHouseName(SampleReceiveDetailProcessTransFB_p.getStrDrugWareHouseName());//Store Id
//			
//			
////			double nAllot,nPrevRemainBudget,nUsed;
//			String nUsed="0.00";
//			
//			if(SampleReceiveDetailProcessTransFB_p.getStrLastAllocatedBudget()!=null && Double.parseDouble(SampleReceiveDetailProcessTransFB_p.getStrLastAllocatedBudget())>0)
//			{
//				SampleReceiveDetailProcessTransVO.setStrSlNo("0");
//				
//				SampleReceiveDetailProcessTransBO.getBudgetUsed(SampleReceiveDetailProcessTransVO);
//				
////				nPrevRemainBudget = Double.parseDouble(SampleReceiveDetailProcessTransFB_p.getStrPreviousYearRemainingBudget());
//
////				nAllot=Double.parseDouble(SampleReceiveDetailProcessTransFB_p.getStrLastAllocatedBudget());
//				
////				nUsed = -(nPrevRemainBudget - nAllot);
//				
//				if(SampleReceiveDetailProcessTransVO.getWrsData().next()){
//					// For setting the form bean values
//					nUsed =SampleReceiveDetailProcessTransVO.getWrsData().getString("Budget_Consumed").toString();
//				}
//
//				SampleReceiveDetailProcessTransFB_p.setStrBudgetUsed(nUsed);
//			}
//			else{
//				SampleReceiveDetailProcessTransFB_p.setStrBudgetUsed("0.00");
//			}
//			
//			SampleReceiveDetailProcessTransVO.setStrPreviousYearRemainingBudget(SampleReceiveDetailProcessTransFB_p.getStrPreviousYearRemainingBudget());
//			SampleReceiveDetailProcessTransVO.setStrBudgetUsed(SampleReceiveDetailProcessTransFB_p.getStrBudgetUsed());
//			
//			SampleReceiveDetailProcessTransVO.setStrNewAllocatedBudget(SampleReceiveDetailProcessTransFB_p.getStrNewAllocatedBudget());
//			SampleReceiveDetailProcessTransVO.setStrRemarks(SampleReceiveDetailProcessTransFB_p.getStrRemarks());
//			
//			SampleReceiveDetailProcessTransVO.setStrSeatId(strSeatId);	//from session
//			SampleReceiveDetailProcessTransVO.setStrIsValid("1");
//			
//			if(SampleReceiveDetailProcessTransFB_p.getStrLastAllocatedBudget()!=null)	//Initial Budget
//			{
//				if(Double.parseDouble(SampleReceiveDetailProcessTransFB_p.getStrLastAllocatedBudget())>0)
//				{
//					SampleReceiveDetailProcessTransVO.setStrMode("2");
//					SampleReceiveDetailProcessTransBO.updateRecord(SampleReceiveDetailProcessTransVO);
//				}											
//			}
//			
//			SampleReceiveDetailProcessTransVO.setStrMode("1");
//			
//			
//			//CALLING BO
//			SampleReceiveDetailProcessTransBO.insertRecord(SampleReceiveDetailProcessTransVO);
//			
//			
//			if (SampleReceiveDetailProcessTransVO.getStrMsgType().equals("1")) {
//				throw new Exception(SampleReceiveDetailProcessTransVO.getStrMsgString());
//			}
//
//				SampleReceiveDetailProcessTransFB_p.setStrNormalMsg("Record Saved Successfully!");
//				SampleReceiveDetailProcessTransFB_p.setStrStoreId("");
//		}
//		catch (Exception e) 
//		{
//
//			//e.printStackTrace();
//			
//			strMsgText = "SampleReceiveDetailProcessTransDATA.insertRecord(SampleReceiveDetailProcessTransVO) --> "	+ e.getMessage();
//			HisException eObj = new HisException("mms", "SampleReceiveDetailProcessTransDATA->insertRecord()", strMsgText);
//			SampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
//					+ eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//		finally 
//		{
//			SampleReceiveDetailProcessTransBO = null;
//			SampleReceiveDetailProcessTransVO = null;
//		}		
//	}
//
//
//	/**
//	 * Get Financial Combo View Page
//	 * 
//	 * @param SampleReceiveDetailProcessTransFB_p
//	 * @param request_p
//	 * @param response
//	 */
//	public static void getFinancialComboViewPage(SampleReceiveDetailProcessTransFB SampleReceiveDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response)
//	{
//		SampleReceiveDetailProcessTransBO SampleReceiveDetailProcessTransBO = null;
//		SampleReceiveDetailProcessTransVO SampleReceiveDetailProcessTransVO = null;
//		
//		String strFinancialYearCmb;
//		String strMsgText = "";
//		String	strHospitalCode;
//		HisUtil hisutil=null;
//		try {
//			SampleReceiveDetailProcessTransBO = new SampleReceiveDetailProcessTransBO();
//			SampleReceiveDetailProcessTransVO = new SampleReceiveDetailProcessTransVO();
//			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
//			hisutil = new HisUtil("DWH Transaction","SampleReceiveDetailProcessTransDATA");
//
//
//			SampleReceiveDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
//			
//			SampleReceiveDetailProcessTransBO.getFinancialYearComboForViewPage(SampleReceiveDetailProcessTransVO);
//			
//			
//			if (SampleReceiveDetailProcessTransVO.getWrsFinancialYearCmb() != null && SampleReceiveDetailProcessTransVO.getWrsFinancialYearCmb().size() > 0) 
//			{
//				strFinancialYearCmb = hisutil.getOptionValue(SampleReceiveDetailProcessTransVO.getWrsFinancialYearCmb(), "","0^Select Value", false);
//			}
//			
//			else
//			{
//				strFinancialYearCmb = "<option value='0'>Select Value</option>";
//			}
//			
//			SampleReceiveDetailProcessTransFB_p.setStrFinancialYearCombo(strFinancialYearCmb);
//			
//			
//			if (SampleReceiveDetailProcessTransVO.getStrMsgType().equals("1")) {
//				throw new Exception(SampleReceiveDetailProcessTransVO.getStrMsgString());
//			}
//			
//			
//		} 
//		catch (Exception e) 
//		{
//			strMsgText = "SampleReceiveDetailProcessTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
//			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->modifyRecord()", strMsgText);
//			SampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//		finally 
//		{
//			SampleReceiveDetailProcessTransBO = null;
//			SampleReceiveDetailProcessTransVO = null;
//		}
//	
//	
//	}
//	
//	
//	public static void getViewDetails(SampleReceiveDetailProcessTransFB SampleReceiveDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
//	{
//		SampleReceiveDetailProcessTransBO SampleReceiveDetailProcessTransBO = null;
//		SampleReceiveDetailProcessTransVO SampleReceiveDetailProcessTransVO = null;
//		
//
//		String strBudgetDetailsTable;
//		String strMsgText = "";
//		String	strHospitalCode;
//		String strFinancialYear;
//		HisUtil hisutil=null;
//		try {
//			SampleReceiveDetailProcessTransBO = new SampleReceiveDetailProcessTransBO();
//			SampleReceiveDetailProcessTransVO = new SampleReceiveDetailProcessTransVO();
//			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
//			hisutil = new HisUtil("DWH Transaction","SampleReceiveDetailProcessTransDATA");
//
//
//			SampleReceiveDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
//			
//			strFinancialYear =	request_p.getParameter("financialYear");
//			
//			if(strFinancialYear!=null)
//			{
//				SampleReceiveDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strFinancialYear.split("\\-")[0].trim() )));
//				SampleReceiveDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strFinancialYear.split("\\-")[1].trim() )));
//			}
//			
//			SampleReceiveDetailProcessTransVO.setStrDrugWareHouseName(request_p.getParameter("storeId"));
//			
//			//Calling BO
//			SampleReceiveDetailProcessTransBO.viewBudgetDetailsRecord(SampleReceiveDetailProcessTransVO);
//			
//			
//			
//			
//			if (SampleReceiveDetailProcessTransVO.getStrMsgType().equals("1")) {
//				throw new Exception(SampleReceiveDetailProcessTransVO.getStrMsgString());
//			}
//			
//			strBudgetDetailsTable	=	getBudgetDetailsTable(SampleReceiveDetailProcessTransVO.getWrsData());
//			
//			
//		//	SampleReceiveDetailProcessTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
//			
//			 response.setHeader("Cache-Control", "no-cache");
//			 response.getWriter().print(strBudgetDetailsTable);
//			
//		} 
//		catch (Exception e) 
//		{
//			strMsgText = "SampleReceiveDetailProcessTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
//			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
//			SampleReceiveDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
//		}
//		finally 
//		{
//			SampleReceiveDetailProcessTransBO = null;
//			SampleReceiveDetailProcessTransVO = null;
//		}
//	}
//	
//
///**
// * To get Entered Dependent Details HLP
// * 
// * @param wrsData_p  the WebRowSet
// */
//private static String getBudgetDetailsTable(WebRowSet wrsData_p)	throws SQLException {
//	
//	StringBuffer sbTable = new StringBuffer(100);
//	StringBuffer sbHeader = new StringBuffer(100);
//	StringBuffer sbBody = new StringBuffer(100);
//	int nWidth=25;
//	int nColspan=4;
//	
//	sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
//	sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Budget Details</td>" + "</tr>");
//	sbTable.append("</table>");
//	
//	/*
//	 * Header Row:
//	 */
//
//	sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
//	
//	
//	sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Drug Warehouse Name </td>");
//	sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Budget Allocated</td>");
//	sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Budget Consumed</td>");
//	sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Budget Available</td>");
//	sbHeader.append("</tr>");
//
//	if (wrsData_p != null && wrsData_p.size() > 0) {		
//		/* Result Index */
//		// Budget_Available: 1
//		// Budget_Allocated: 2
//		// Budget_Consumed: 3
//		// Drug_warehouse_name: 4
//		
//	
//		
//		while (wrsData_p.next()) {
//
//			
//			
//			String strDrugWareHouseName = wrsData_p.getString("Drug_warehouse_name");
//			String strBudgetAllocated = wrsData_p.getString("Budget_Allocated");
//			String strBudgetConsumed = wrsData_p.getString("Budget_Consumed");
//			String strRemainingBudget = wrsData_p.getString("Budget_Available");
//			
//			
//			
//			
//			if (strDrugWareHouseName == null) {
//				strDrugWareHouseName = "---";
//			}
//			if (strBudgetAllocated == null) {
//				strBudgetAllocated = "---";
//			}
//			if (strBudgetConsumed == null) {
//				strBudgetConsumed = "---";
//			}
//			if (strRemainingBudget == null) {
//				strRemainingBudget = "---";
//			}
//			
//			
//			/*
//			 * Table Body
//			 */
//
//			sbBody.append("<tr>");
//					
//			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strDrugWareHouseName + "</td>");
//			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strBudgetAllocated + "</td>");
//			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strBudgetConsumed + "</td>");
//			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strRemainingBudget + "</td>");
//			
//			sbBody.append("</tr></table>"); 
//		}
//
//	} 
//	else 
//	{
//		sbBody.append("<tr>");
//		sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
//		sbBody.append("</tr></table>");
//	}
//
//	return sbTable.toString() + sbHeader.toString() + sbBody.toString();
//}




	
}
