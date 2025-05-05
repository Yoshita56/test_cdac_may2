package mms.transactions.controller.data;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.ChallanModificationTransBO;
import mms.transactions.controller.fb.ChallanModificationTransFB;

import mms.transactions.vo.ChallanModificationTransVO;

public class ChallanModificationTransDATA {
	
		
	/**
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getDrugWareHouseNameCombo(ChallanModificationTransFB formBean, HttpServletRequest request) {

		ChallanModificationTransBO bo = null;
		ChallanModificationTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new ChallanModificationTransBO();
			vo = new ChallanModificationTransVO();

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			bo.getDrugWareHouseNameCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ChallanModificationTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{											
				strStoreVal = util.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
							
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
			
			vo.setStrModifyFlag(formBean.getStrModifyFlag());			
			
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.ChallanModificationTransDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanModificationTransDATA->getDrugWareHouseNameCombo()", strMsgText);
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
	 * getPoNoCmb
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getPoNoCmb(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		
		String strPoNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			ChallanModificationTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			ChallanModificationTransVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanModificationTransVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanModificationTransVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
					
			ChallanModificationTransBO.getPoNoCmb(ChallanModificationTransVO);
			
			
			if (ChallanModificationTransVO.getWrsData() != null && ChallanModificationTransVO.getWrsData().size() > 0) 
			{
				strPoNoCmb = hisutil.getOptionValue(ChallanModificationTransVO.getWrsData(), "0","0^Select Value", false);
			}
			
			else
			{
				strPoNoCmb = "<option value='0'>Select Value</option>";
			}
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strPoNoCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	
	
	}
	
	/**
	 * Item Name
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getItemNameCmb(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			ChallanModificationTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			
			
			ChallanModificationTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanModificationTransVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanModificationTransVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanModificationTransVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
			
			ChallanModificationTransBO.getItemNameCmb(ChallanModificationTransVO);
			
			
			
			if (ChallanModificationTransVO.getWrsData() != null && ChallanModificationTransVO.getWrsData().size() > 0) 
			{
				strItemNameCmb = hisutil.getOptionValue(ChallanModificationTransVO.getWrsData(), "0","0^Select Value", false);
			}
			
			else
			{
				strItemNameCmb = "<option value='0'>Select Value</option>";
			}
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strItemNameCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	
	
	}
	
	
	/**
	 * Item Name
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getChallanDtl(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";

		try 
		{
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			
		
			ChallanModificationTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			ChallanModificationTransVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo").split("\\^")[0]);
			ChallanModificationTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanModificationTransVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanModificationTransVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanModificationTransVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
			ChallanModificationTransVO.setStrItemBrandId((request.getParameter("ItemBrandID")==null)?"0": request.getParameter("ItemBrandID"));			
			// Calling Bo Method Here
			ChallanModificationTransBO.getChallanDtl(ChallanModificationTransVO);			
		
			//strItemNameCmb = ChallanModificationTransHLP.getChallanDtlHlp(ChallanModificationTransVO.getWrsData(), request.getParameter("challanNo"));
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print("");
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.getChallanDtl(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getChallanDtl()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	
	
	}
	
	/**
	 * Item Name
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getSupplierPerformancePopUp(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		try 
		{
		
			// String strItemNameCmb = ChallanModificationTransHLP.getSupplierPerformancePopUp(request.getParameter("index"),request.getParameter("strMultiRowPerformanceDtlEntry"));
			 
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print("");
			
			 
			
		} 
		catch (Exception e) 
		{
			
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getSupplierPerformancePopUp()", e.getMessage());
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
	
	}
	
	/**
	 * getPoNoCmb
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getSupplierCmb(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		
		String strPoNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			ChallanModificationTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			ChallanModificationTransVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));			
			ChallanModificationTransVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
					
			ChallanModificationTransBO.getSupplierCmb(ChallanModificationTransVO);
			
			
			if (ChallanModificationTransVO.getStrManufactureComboWS() != null && ChallanModificationTransVO.getStrManufactureComboWS().size() > 0) 
			{
				strPoNoCmb = hisutil.getOptionValue(ChallanModificationTransVO.getStrManufactureComboWS(), "0","0^Select Value", false);
			}
			
			else
			{
				strPoNoCmb = "<option value='0'>Select Value</option>";
			}
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strPoNoCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "ChallanModificationTransDATA.getSupplierCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getSupplierCmb()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	
	
	}
	
	/**
	 * getPoNoCmb
	 * 
	 * @param ChallanModificationTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getChallanNoCmb(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		
		String strChallanNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			ChallanModificationTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			ChallanModificationTransVO.setStrStoreId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanModificationTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanModificationTransVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
					
			ChallanModificationTransBO.getChallanNoCmb(ChallanModificationTransVO);
			
			
			if (ChallanModificationTransVO.getWrsChallanNoCmb() != null && ChallanModificationTransVO.getWrsChallanNoCmb().size() > 0) 
			{
				strChallanNoCmb = hisutil.getOptionValue(ChallanModificationTransVO.getWrsChallanNoCmb(), "0","0^Select Value", false);
			}
			
			else
			{
				strChallanNoCmb = "<option value='0'>Select Value</option>";
			}
			//System.out.println("Challan No==>"+strChallanNoCmb);
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strChallanNoCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	
	
	}

	
	
	


	
	public static void saveChallanDtls(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		String strCurrentDate;		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();

			

			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			
			ChallanModificationTransFB_p.setStrHospitalCode(strHospitalCode);
			ChallanModificationTransFB_p.setStrSeatId(strSeatId);			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			ChallanModificationTransVO = (ChallanModificationTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ChallanModificationTransVO", ChallanModificationTransFB_p);
			
			//CALLING BO
			ChallanModificationTransBO.insertChallanRecord(ChallanModificationTransVO);
			
			
			if (ChallanModificationTransVO.getStrMsgType().equals("1"))
			{
				throw new Exception(ChallanModificationTransVO.getStrMsgString());
			}
			
			if (ChallanModificationTransVO.getStrMsgType().equals("5"))
			{
				ChallanModificationTransFB_p.setStrErrMsg(ChallanModificationTransVO.getStrMsgString());
				
			}
			else
			{	
				if (ChallanModificationTransVO.getStrMsgType().equals("1"))
				{
					ChallanModificationTransFB_p.setStrErrMsg(ChallanModificationTransVO.getStrMsgString());
					
					throw new Exception(ChallanModificationTransVO.getStrMsgString());
				}
				else
				{	
					ChallanModificationTransFB_p.setStrNormalMsg("Data Has been Successfully Saved");
				}   
			}  
			
			
		}
		catch (Exception e) 
		{

			e.printStackTrace();
			
			strMsgText = "ChallanModificationTransDATA.insertRecord(ChallanModificationTransVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "ChallanModificationTransDATA->insertRecord()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}		
	}


	public static void saveSupplierPerformanceDtls(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		
		
		String strCurrentDate;
		
		
		
		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();

			

			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");
			
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			ChallanModificationTransVO.setStrHospitalCode(strHospitalCode);
			ChallanModificationTransVO.setStrDWHId(ChallanModificationTransFB_p.getStrDrugWareHouseName());//Store Id
			ChallanModificationTransVO.setStrPoNo(ChallanModificationTransFB_p.getStrPoNo().split("\\^")[0]);
			ChallanModificationTransVO.setStrChallanNo(ChallanModificationTransFB_p.getStrChallanNo());
			ChallanModificationTransVO.setStrItemBrandId(ChallanModificationTransFB_p.getStrItemId().split("#")[0]);
			
			ChallanModificationTransVO.setStrAcceptedQty(ChallanModificationTransFB_p.getStrAcceptedQty());
			
			ChallanModificationTransVO.setStrReportNumber(ChallanModificationTransFB_p.getStrWhetherTestReportSubmitted());//getStrReportNumber
			ChallanModificationTransVO.setStrReportDate("");// Removed
			ChallanModificationTransVO.setStrWhetherMedicinesInGoodCondition(ChallanModificationTransFB_p.getStrWhetherMedicinesInGoodCondition());
			ChallanModificationTransVO.setStrWhetherSupplyNotForSale(ChallanModificationTransFB_p.getStrWhetherSupplyNotForSale());
			ChallanModificationTransVO.setStrWhetherBrandNameNotWritten(ChallanModificationTransFB_p.getStrWhetherBrandNameNotWritten());
			
			ChallanModificationTransVO.setStrWhetherMRPPrint(ChallanModificationTransFB_p.getStrWhetherMRPPrint());
			ChallanModificationTransVO.setStrWhetherMedicinesInGoodCondition(ChallanModificationTransFB_p.getStrWhetherMedicinesInGoodCondition());
			ChallanModificationTransVO.setStrPageNo(ChallanModificationTransFB_p.getStrPageNo());
			
			
			ChallanModificationTransVO.setStrRemarks(ChallanModificationTransFB_p.getStrRemarks());
			
			ChallanModificationTransVO.setStrSeatId(strSeatId);	//from session
			ChallanModificationTransVO.setStrIsValid("1");
			
			ChallanModificationTransVO.setStrMode("1");
			
			
			
			
			
			//CALLING BO
			ChallanModificationTransBO.insertRecord(ChallanModificationTransVO);
			
			
			if (ChallanModificationTransVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanModificationTransVO.getStrMsgString());
			}

				ChallanModificationTransFB_p.setStrNormalMsg("Record Saved Successfully!");
				ChallanModificationTransFB_p.setStrStoreId("");
		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strMsgText = "ChallanModificationTransDATA.insertRecord(ChallanModificationTransVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "ChallanModificationTransDATA->insertRecord()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}		
	}


	

	public static void getSupplierPerformancePendingDtlView(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");


			ChallanModificationTransVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			ChallanModificationTransVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			ChallanModificationTransVO.setStrStoreId( "0");
			ChallanModificationTransVO.setStrPoNo("0");
			ChallanModificationTransVO.setStrChallanNo("0");
			ChallanModificationTransVO.setStrFromDate("0");
			ChallanModificationTransVO.setStrToDate("0");
			
			ChallanModificationTransVO.setStrMode("4");
			
			
			
			//Calling BO
			ChallanModificationTransBO.getSupplierPerformancePendingDtlView(ChallanModificationTransVO);
			
			
			
			
			if (ChallanModificationTransVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanModificationTransVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformancePendingDtlTable(ChallanModificationTransVO.getWrsData());
			
			
		//	ChallanModificationTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	}
	
	
	public static void getSupplierPerformanceCompletedDtlView(ChallanModificationTransFB ChallanModificationTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanModificationTransBO ChallanModificationTransBO = null;
		ChallanModificationTransVO ChallanModificationTransVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			ChallanModificationTransBO = new ChallanModificationTransBO();
			ChallanModificationTransVO = new ChallanModificationTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","ChallanModificationTransDATA");


			ChallanModificationTransVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanModificationTransVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			ChallanModificationTransVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			ChallanModificationTransVO.setStrStoreId( "0");
			ChallanModificationTransVO.setStrPoNo("0");
			ChallanModificationTransVO.setStrChallanNo("0");
			ChallanModificationTransVO.setStrFromDate((request_p.getParameter("fromDate")==null)?"0": request_p.getParameter("fromDate"));
			ChallanModificationTransVO.setStrToDate((request_p.getParameter("toDate")==null)?"0": request_p.getParameter("toDate"));
			
			ChallanModificationTransVO.setStrMode("5");
			
			
			
			//Calling BO
			ChallanModificationTransBO.getSupplierPerformancePendingDtlView(ChallanModificationTransVO);
			
			
			
			
			if (ChallanModificationTransVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanModificationTransVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformanceCompletedDtlTable(ChallanModificationTransVO.getWrsData());
			
			
		//	ChallanModificationTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanModificationTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			ChallanModificationTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanModificationTransBO = null;
			ChallanModificationTransVO = null;
		}
	}

/**
 * To get Entered Dependent Details HLP
 * 
 * @param wrsData_p  the WebRowSet
 */
private static String getSupplierPerformancePendingDtlTable(WebRowSet wrsData_p)	throws SQLException {
	
	StringBuffer sbTable = new StringBuffer(100);
	StringBuffer sbHeader = new StringBuffer(100);
	StringBuffer sbBody = new StringBuffer(100);
	int nWidth=25;
	int nColspan=6;
	
	sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >");
	sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Supplier Performance Pending Details</td>" + "</tr>");
	sbTable.append("</table>");
	
	/*
	 * Header Row:
	 */

	sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
	
	
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">PO NO </td>");
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">PO Date</td>");
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Challan No</td>");
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Challan Date</td>");
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Supplier Name</td>");
	sbHeader.append("<td width=\""	+ "30"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Item Name</td>");

	sbHeader.append("</tr>");

	if (wrsData_p != null && wrsData_p.size() > 0) {		
		/* Result Index */
		// PO_NO: 1
		// PO_DATE: 2
		// CHALLAN_NO: 3
		// CHALLAN_DATE: 4
		// SUPP_NAME:	5
		// ITEM_NAME:	6
		
	
		
		while (wrsData_p.next()) {

			
			
			String strPoNo = wrsData_p.getString("PO_NO");
			String strPoDate = wrsData_p.getString("PO_DATE");
			String strChallanNo = wrsData_p.getString("CHALLAN_NO");
			String strChallanDate = wrsData_p.getString("CHALLAN_DATE");
			String strSupplierName = wrsData_p.getString("SUPP_NAME");
			String strItemName = wrsData_p.getString("ITEM_NAME");
			
			
			
			if (strPoNo == null) {
				strPoNo = "---";
			}
			if (strPoDate == null) {
				strPoDate = "---";
			}
			if (strChallanNo == null) {
				strChallanNo = "---";
			}
			if (strChallanDate == null) {
				strChallanDate = "---";
			}
			if (strSupplierName == null) {
				strSupplierName = "---";
			}
			if (strItemName == null) {
				strItemName = "---";
			}
			
			
			/*
			 * Table Body
			 */

			sbBody.append("<tr>");
					
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strPoNo + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strPoDate + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strChallanNo + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strChallanDate + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strSupplierName + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strItemName + "</td>");
			
			sbBody.append("</tr>");
		}
		sbBody.append("</table>");
	} 
	else 
	{
		sbBody.append("<tr>");
		sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
		sbBody.append("</tr></table>");
	}

	return sbTable.toString() + sbHeader.toString() + sbBody.toString();
}



/**
 * To get Entered Dependent Details HLP
 * 
 * @param wrsData_p  the WebRowSet
 */
private static String getSupplierPerformanceCompletedDtlTable(WebRowSet wrsData_p)	throws SQLException {
	
	StringBuffer sbTable = new StringBuffer(100);
	StringBuffer sbHeader = new StringBuffer(100);
	StringBuffer sbBody = new StringBuffer(100);
	int nWidth=15;
	int nColspan=7;
	
	sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >");
	sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Supplier Performance Completed Details</td>" + "</tr>");
	sbTable.append("</table>");
	
	/*
	 * Header Row:
	 */

	sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
	
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Entry Date </td>");
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">PO NO </td>");
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">PO Date</td>");
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Challan No</td>");
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Challan Date</td>");
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Supplier Name</td>");
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Item Name</td>");

	sbHeader.append("</tr>");

	if (wrsData_p != null && wrsData_p.size() > 0) {		
		/* Result Index */
		// ENTRY_DATE: 1
		// PO_NO: 2
		// PO_DATE: 3
		// CHALLAN_NO: 4
		// CHALLAN_DATE: 5
		// SUPP_NAME:	6
		// ITEM_NAME:	7
		
	
		
		while (wrsData_p.next()) {

			String strEntryDate = wrsData_p.getString("ENTRY_DATE");
			String strPoNo = wrsData_p.getString("PO_NO");
			String strPoDate = wrsData_p.getString("PO_DATE");
			String strChallanNo = wrsData_p.getString("CHALLAN_NO");
			String strChallanDate = wrsData_p.getString("CHALLAN_DATE");
			String strSupplierName = wrsData_p.getString("SUPP_NAME");
			String strItemName = wrsData_p.getString("ITEM_NAME");
			
			
			if (strEntryDate == null) {
				strEntryDate = "---";
			}
			if (strPoNo == null) {
				strPoNo = "---";
			}
			if (strPoDate == null) {
				strPoDate = "---";
			}
			if (strChallanNo == null) {
				strChallanNo = "---";
			}
			if (strChallanDate == null) {
				strChallanDate = "---";
			}
			if (strSupplierName == null) {
				strSupplierName = "---";
			}
			if (strItemName == null) {
				strItemName = "---";
			}
			
			
			/*
			 * Table Body
			 */

			sbBody.append("<tr>");
			
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strEntryDate + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strPoNo + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strPoDate + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strChallanNo + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strChallanDate + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strSupplierName + "</td>");
			sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strItemName + "</td>");
			
			sbBody.append("</tr>");
		}
		sbBody.append("</table>");
	} 
	else 
	{
		sbBody.append("<tr>");
		sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
		sbBody.append("</tr></table>");
	}

	return sbTable.toString() + sbHeader.toString() + sbBody.toString();
}

	
}
