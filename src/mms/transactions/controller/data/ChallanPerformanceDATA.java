package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.ChallanPerformanceBO;
import mms.transactions.controller.fb.ChallanPerformanceFB;
import mms.transactions.controller.hlp.ChallanPerformanceHLP;
import mms.transactions.vo.ChallanPerformanceVO;

public class ChallanPerformanceDATA {
	
		
	/**
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getDrugWareHouseNameCombo(ChallanPerformanceFB formBean, HttpServletRequest request) {

		ChallanPerformanceBO bo = null;
		ChallanPerformanceVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new ChallanPerformanceBO();
			vo = new ChallanPerformanceVO();

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			bo.getDrugWareHouseNameCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ChallanPerformanceDATA");
			
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
			strMsgText = "mms.transactions.ChallanPerformanceDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanPerformanceDATA->getDrugWareHouseNameCombo()", strMsgText);
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
	 * @param ChallanPerformanceFB_p
	 * @param request
	 * @param response
	 */
	public static void getPoNoCmb(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		
		String strPoNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			ChallanPerformanceVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			ChallanPerformanceVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanPerformanceVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanPerformanceVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
					
			ChallanPerformanceBO.getPoNoCmb(ChallanPerformanceVO);
			
			
			if (ChallanPerformanceVO.getWrsData() != null && ChallanPerformanceVO.getWrsData().size() > 0) 
			{
				strPoNoCmb = hisutil.getOptionValue(ChallanPerformanceVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "ChallanPerformanceDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	
	
	}
	
	/**
	 * Item Name
	 * 
	 * @param ChallanPerformanceFB_p
	 * @param request
	 * @param response
	 */
	public static void getItemNameCmb(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			ChallanPerformanceVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			
			
			ChallanPerformanceVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanPerformanceVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanPerformanceVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanPerformanceVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
			
			ChallanPerformanceBO.getItemNameCmb(ChallanPerformanceVO);
			
			
			
			if (ChallanPerformanceVO.getWrsData() != null && ChallanPerformanceVO.getWrsData().size() > 0) 
			{
				strItemNameCmb = hisutil.getOptionValue(ChallanPerformanceVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "ChallanPerformanceDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	
	
	}
	
	
	/**
	 * Item Name
	 * 
	 * @param ChallanPerformanceFB_p
	 * @param request
	 * @param response
	 */
	public static void getChallanDtl(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			ChallanPerformanceVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
		
			ChallanPerformanceVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanPerformanceVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanPerformanceVO.setStrSupplierId((request.getParameter("SupplierId")==null)?"0": request.getParameter("SupplierId"));
			ChallanPerformanceVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
			ChallanPerformanceVO.setStrItemBrandId((request.getParameter("ItemBrandID")==null)?"0": request.getParameter("ItemBrandID"));			
			ChallanPerformanceBO.getChallanDtl(ChallanPerformanceVO);			
		
			strItemNameCmb = ChallanPerformanceHLP.getChallanDtlHlp(ChallanPerformanceVO.getWrsData());
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strItemNameCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanPerformanceDATA.getChallanDtl(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getChallanDtl()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	
	
	}
	
	/**
	 * getPoNoCmb
	 * 
	 * @param ChallanPerformanceFB_p
	 * @param request
	 * @param response
	 */
	public static void getSupplierCmb(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		
		String strPoNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			ChallanPerformanceVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			ChallanPerformanceVO.setStrStoreId((request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));			
			ChallanPerformanceVO.setStrModifyFlag((request.getParameter("ModifyFlg")==null)?"0": request.getParameter("ModifyFlg"));
					
			ChallanPerformanceBO.getSupplierCmb(ChallanPerformanceVO);
			
			
			if (ChallanPerformanceVO.getStrManufactureComboWS() != null && ChallanPerformanceVO.getStrManufactureComboWS().size() > 0) 
			{
				strPoNoCmb = hisutil.getOptionValue(ChallanPerformanceVO.getStrManufactureComboWS(), "0","0^Select Value", false);
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
			strMsgText = "ChallanPerformanceDATA.getSupplierCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getSupplierCmb()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	
	
	}
	
	/**
	 * getPoNoCmb
	 * 
	 * @param ChallanPerformanceFB_p
	 * @param request
	 * @param response
	 */
	public static void getChallanNoCmb(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		
		String strChallanNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			ChallanPerformanceVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			ChallanPerformanceVO.setStrDWHId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			ChallanPerformanceVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
			ChallanPerformanceVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			ChallanPerformanceVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo"));
			ChallanPerformanceVO.setStrFromDate("0");
			ChallanPerformanceVO.setStrToDate("0");
			
			ChallanPerformanceVO.setStrMode("2");
			
			
			ChallanPerformanceBO.getPoNoCmb(ChallanPerformanceVO);
			
			
			if (ChallanPerformanceVO.getWrsData() != null && ChallanPerformanceVO.getWrsData().size() > 0) 
			{
				strChallanNoCmb = hisutil.getOptionValue(ChallanPerformanceVO.getWrsData(), "0","0^Select Value", false);
			}
			
			else
			{
				strChallanNoCmb = "<option value='0'>Select Value</option>";
			}
			
			 response.setHeader("Cache-Control", "no-cache");
    		 response.getWriter().print(strChallanNoCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanPerformanceDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	
	
	}

	
	
	


	
	public static void saveChallanDtls(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		String strCurrentDate;		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();

			

			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			
			ChallanPerformanceFB_p.setStrHospitalCode(strHospitalCode);
			ChallanPerformanceFB_p.setStrSeatId(strSeatId);			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			ChallanPerformanceVO = (ChallanPerformanceVO) TransferObjectFactory.populateData("mms.transactions.vo.ChallanPerformanceVO", ChallanPerformanceFB_p);
			
			//CALLING BO
			ChallanPerformanceBO.insertChallanRecord(ChallanPerformanceVO);
			
			
			if (ChallanPerformanceVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanPerformanceVO.getStrMsgString());
			}

				ChallanPerformanceFB_p.setStrNormalMsg("Record Saved Successfully!");
				ChallanPerformanceFB_p.setStrStoreId("");
		}
		catch (Exception e) 
		{

			e.printStackTrace();
			
			strMsgText = "ChallanPerformanceDATA.insertRecord(ChallanPerformanceVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "ChallanPerformanceDATA->insertRecord()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}		
	}


	public static void saveSupplierPerformanceDtls(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		
		
		String strCurrentDate;
		
		
		
		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();

			

			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");
			
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			ChallanPerformanceVO.setStrHospitalCode(strHospitalCode);
			ChallanPerformanceVO.setStrDWHId(ChallanPerformanceFB_p.getStrDrugWareHouseName());//Store Id
			ChallanPerformanceVO.setStrPoNo(ChallanPerformanceFB_p.getStrPoNo().split("\\^")[0]);
			ChallanPerformanceVO.setStrChallanNo(ChallanPerformanceFB_p.getStrChallanNo());
			ChallanPerformanceVO.setStrItemBrandId(ChallanPerformanceFB_p.getStrItemId().split("#")[0]);
			
			ChallanPerformanceVO.setStrAcceptedQty(ChallanPerformanceFB_p.getStrAcceptedQty());
			
			ChallanPerformanceVO.setStrReportNumber(ChallanPerformanceFB_p.getStrWhetherTestReportSubmitted());//getStrReportNumber
			ChallanPerformanceVO.setStrReportDate("");// Removed
			ChallanPerformanceVO.setStrWhetherMedicinesInGoodCondition(ChallanPerformanceFB_p.getStrWhetherMedicinesInGoodCondition());
			ChallanPerformanceVO.setStrWhetherSupplyNotForSale(ChallanPerformanceFB_p.getStrWhetherSupplyNotForSale());
			ChallanPerformanceVO.setStrWhetherBrandNameNotWritten(ChallanPerformanceFB_p.getStrWhetherBrandNameNotWritten());
			
			ChallanPerformanceVO.setStrWhetherMRPPrint(ChallanPerformanceFB_p.getStrWhetherMRPPrint());
			ChallanPerformanceVO.setStrWhetherMedicinesInGoodCondition(ChallanPerformanceFB_p.getStrWhetherMedicinesInGoodCondition());
			ChallanPerformanceVO.setStrPageNo(ChallanPerformanceFB_p.getStrPageNo());
			
			
			ChallanPerformanceVO.setStrRemarks(ChallanPerformanceFB_p.getStrRemarks());
			
			ChallanPerformanceVO.setStrSeatId(strSeatId);	//from session
			ChallanPerformanceVO.setStrIsValid("1");
			
			ChallanPerformanceVO.setStrMode("1");
			
			
			
			
			
			//CALLING BO
			ChallanPerformanceBO.insertRecord(ChallanPerformanceVO);
			
			
			if (ChallanPerformanceVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanPerformanceVO.getStrMsgString());
			}

				ChallanPerformanceFB_p.setStrNormalMsg("Record Saved Successfully!");
				ChallanPerformanceFB_p.setStrStoreId("");
		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strMsgText = "ChallanPerformanceDATA.insertRecord(ChallanPerformanceVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "ChallanPerformanceDATA->insertRecord()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}		
	}


	

	public static void getSupplierPerformancePendingDtlView(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");


			ChallanPerformanceVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			ChallanPerformanceVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			ChallanPerformanceVO.setStrStoreId( "0");
			ChallanPerformanceVO.setStrPoNo("0");
			ChallanPerformanceVO.setStrChallanNo("0");
			ChallanPerformanceVO.setStrFromDate("0");
			ChallanPerformanceVO.setStrToDate("0");
			
			ChallanPerformanceVO.setStrMode("4");
			
			
			
			//Calling BO
			ChallanPerformanceBO.getSupplierPerformancePendingDtlView(ChallanPerformanceVO);
			
			
			
			
			if (ChallanPerformanceVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanPerformanceVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformancePendingDtlTable(ChallanPerformanceVO.getWrsData());
			
			
		//	ChallanPerformanceFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanPerformanceDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
		}
	}
	
	
	public static void getSupplierPerformanceCompletedDtlView(ChallanPerformanceFB ChallanPerformanceFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		ChallanPerformanceBO ChallanPerformanceBO = null;
		ChallanPerformanceVO ChallanPerformanceVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			ChallanPerformanceBO = new ChallanPerformanceBO();
			ChallanPerformanceVO = new ChallanPerformanceVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","ChallanPerformanceDATA");


			ChallanPerformanceVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			ChallanPerformanceVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			ChallanPerformanceVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			ChallanPerformanceVO.setStrStoreId( "0");
			ChallanPerformanceVO.setStrPoNo("0");
			ChallanPerformanceVO.setStrChallanNo("0");
			ChallanPerformanceVO.setStrFromDate((request_p.getParameter("fromDate")==null)?"0": request_p.getParameter("fromDate"));
			ChallanPerformanceVO.setStrToDate((request_p.getParameter("toDate")==null)?"0": request_p.getParameter("toDate"));
			
			ChallanPerformanceVO.setStrMode("5");
			
			
			
			//Calling BO
			ChallanPerformanceBO.getSupplierPerformancePendingDtlView(ChallanPerformanceVO);
			
			
			
			
			if (ChallanPerformanceVO.getStrMsgType().equals("1")) {
				throw new Exception(ChallanPerformanceVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformanceCompletedDtlTable(ChallanPerformanceVO.getWrsData());
			
			
		//	ChallanPerformanceFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "ChallanPerformanceDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			ChallanPerformanceFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			ChallanPerformanceBO = null;
			ChallanPerformanceVO = null;
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
