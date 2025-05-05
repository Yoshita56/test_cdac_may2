package mms.transactions.controller.data;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.SupplierPerformanceDtlTransBO;
import mms.transactions.controller.fb.SupplierPerformanceDtlTransFB;
import mms.transactions.vo.SupplierPerformanceDtlTransVO;

public class SupplierPerformanceDtlTransDATA {
	
		
	/**
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getDrugWareHouseNameCombo(SupplierPerformanceDtlTransFB formBean, HttpServletRequest request) {

		SupplierPerformanceDtlTransBO bo = null;
		SupplierPerformanceDtlTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new SupplierPerformanceDtlTransBO();
			vo = new SupplierPerformanceDtlTransVO();

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDrugWareHouseNameCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "SupplierPerformanceDtlTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{
				if(vo.getWrsDrugWareHouseNameCmb().next())
				{
					vo.setStrDrugWareHouseNameCmb(vo.getWrsDrugWareHouseNameCmb().getString(1));
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
						
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
			
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			
			
			
		} catch (Exception e) {
			strMsgText = "mms.transactions.SupplierPerformanceDtlTransDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierPerformanceDtlTransDATA->getDrugWareHouseNameCombo()", strMsgText);
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
	 * @param supplierPerformanceDtlTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getPoNoCmb(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		
		String strPoNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");
			supplierPerformanceDtlTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
			supplierPerformanceDtlTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			supplierPerformanceDtlTransVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo"));
			supplierPerformanceDtlTransVO.setStrFromDate("0");
			supplierPerformanceDtlTransVO.setStrToDate("0");
			supplierPerformanceDtlTransVO.setStrMode("1");
			
			
			supplierPerformanceDtlTransBO.getPoNoCmb(supplierPerformanceDtlTransVO);
			
			
			if (supplierPerformanceDtlTransVO.getWrsData() != null && supplierPerformanceDtlTransVO.getWrsData().size() > 0) 
			{
				strPoNoCmb = hisutil.getOptionValue(supplierPerformanceDtlTransVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "SupplierPerformanceDtlTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}
	
	
	}
	
	/**
	 * getPoNoCmb
	 * 
	 * @param supplierPerformanceDtlTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getChallanNoCmb(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		
		String strChallanNoCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");
			supplierPerformanceDtlTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
			supplierPerformanceDtlTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			supplierPerformanceDtlTransVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo"));
			supplierPerformanceDtlTransVO.setStrFromDate("0");
			supplierPerformanceDtlTransVO.setStrToDate("0");
			
			supplierPerformanceDtlTransVO.setStrMode("2");
			
			
			supplierPerformanceDtlTransBO.getPoNoCmb(supplierPerformanceDtlTransVO);
			
			
			if (supplierPerformanceDtlTransVO.getWrsData() != null && supplierPerformanceDtlTransVO.getWrsData().size() > 0) 
			{
				strChallanNoCmb = hisutil.getOptionValue(supplierPerformanceDtlTransVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "SupplierPerformanceDtlTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}
	
	
	}

	
	/**
	 * Item Name
	 * 
	 * @param supplierPerformanceDtlTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getItemNameCmb(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");
			supplierPerformanceDtlTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
			supplierPerformanceDtlTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			supplierPerformanceDtlTransVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo"));
			
			supplierPerformanceDtlTransVO.setStrFromDate("0");
			supplierPerformanceDtlTransVO.setStrToDate("0");
			
			supplierPerformanceDtlTransVO.setStrMode("3");
			
			
			supplierPerformanceDtlTransBO.getItemNameCmb(supplierPerformanceDtlTransVO);
			
			
			if (supplierPerformanceDtlTransVO.getWrsData() != null && supplierPerformanceDtlTransVO.getWrsData().size() > 0) 
			{
				strItemNameCmb = hisutil.getOptionValue(supplierPerformanceDtlTransVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "SupplierPerformanceDtlTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}
	
	
	}

	
	/**
	 * Batch Name Combo
	 * 
	 * @param supplierPerformanceDtlTransFB_p
	 * @param request
	 * @param response
	 */
	public static void getBatchNameCmb(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		
		String strItemNameCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");
			supplierPerformanceDtlTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request.getParameter("dwhId")==null)?"0": request.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
			supplierPerformanceDtlTransVO.setStrPoNo((request.getParameter("pono")==null)?"0": request.getParameter("pono"));
			supplierPerformanceDtlTransVO.setStrChallanNo((request.getParameter("challanNo")==null)?"0": request.getParameter("challanNo"));
			supplierPerformanceDtlTransVO.setStrItemBrandId((request.getParameter("itemBrandID")==null)?"0": request.getParameter("itemBrandID"));
			
			supplierPerformanceDtlTransVO.setStrFromDate("0");
			supplierPerformanceDtlTransVO.setStrToDate("0");
			
			
			
			
			supplierPerformanceDtlTransBO.getBatchCmb(supplierPerformanceDtlTransVO);
			
			
			if (supplierPerformanceDtlTransVO.getWrsData() != null && supplierPerformanceDtlTransVO.getWrsData().size() > 0) 
			{
				strItemNameCmb = hisutil.getOptionValue(supplierPerformanceDtlTransVO.getWrsData(), "0","0^Select Value", false);
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
			strMsgText = "SupplierPerformanceDtlTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getBatchCmb()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}
	
	
	}
	public static void saveSupplierPerformanceDtls(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		
		
		String strCurrentDate;
		
		
		
		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();

			

			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");
			
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			supplierPerformanceDtlTransVO.setStrHospitalCode(strHospitalCode);
			supplierPerformanceDtlTransVO.setStrDWHId(supplierPerformanceDtlTransFB_p.getStrDrugWareHouseName());//Store Id
			supplierPerformanceDtlTransVO.setStrPoNo(supplierPerformanceDtlTransFB_p.getStrPoNo().split("\\^")[0]);
			supplierPerformanceDtlTransVO.setStrChallanNo(supplierPerformanceDtlTransFB_p.getStrChallanNo());
			supplierPerformanceDtlTransVO.setStrItemBrandId(supplierPerformanceDtlTransFB_p.getStrItemId().split("#")[0]);
			
			supplierPerformanceDtlTransVO.setStrAcceptedQty(supplierPerformanceDtlTransFB_p.getStrAcceptedQty());
			
			supplierPerformanceDtlTransVO.setStrReportNumber(supplierPerformanceDtlTransFB_p.getStrWhetherTestReportSubmitted());//getStrReportNumber
			supplierPerformanceDtlTransVO.setStrReportDate("");// Removed
			supplierPerformanceDtlTransVO.setStrWhetherMedicinesInGoodCondition(supplierPerformanceDtlTransFB_p.getStrWhetherMedicinesInGoodCondition());
			supplierPerformanceDtlTransVO.setStrWhetherSupplyNotForSale(supplierPerformanceDtlTransFB_p.getStrWhetherSupplyNotForSale());
			supplierPerformanceDtlTransVO.setStrWhetherBrandNameNotWritten(supplierPerformanceDtlTransFB_p.getStrWhetherBrandNameNotWritten());
			
			supplierPerformanceDtlTransVO.setStrWhetherMRPPrint(supplierPerformanceDtlTransFB_p.getStrWhetherMRPPrint());
			supplierPerformanceDtlTransVO.setStrWhetherMedicinesInGoodCondition(supplierPerformanceDtlTransFB_p.getStrWhetherMedicinesInGoodCondition());
			supplierPerformanceDtlTransVO.setStrPageNo(supplierPerformanceDtlTransFB_p.getStrPageNo());
			
			
			supplierPerformanceDtlTransVO.setStrRemarks(supplierPerformanceDtlTransFB_p.getStrRemarks());
			
			supplierPerformanceDtlTransVO.setStrSeatId(strSeatId);	//from session
			supplierPerformanceDtlTransVO.setStrIsValid("1");
			
			supplierPerformanceDtlTransVO.setStrMode("1");
			supplierPerformanceDtlTransVO.setStrBatchNo(supplierPerformanceDtlTransFB_p.getStrBatchNo());		
			
			//CALLING BO
			supplierPerformanceDtlTransBO.insertRecord(supplierPerformanceDtlTransVO);
			
			
			if (supplierPerformanceDtlTransVO.getStrMsgType().equals("1")) {
				throw new Exception(supplierPerformanceDtlTransVO.getStrMsgString());
			}

				supplierPerformanceDtlTransFB_p.setStrNormalMsg("Record Saved Successfully!");
				supplierPerformanceDtlTransFB_p.setStrStoreId("");
		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strMsgText = "SupplierPerformanceDtlTransDATA.insertRecord(supplierPerformanceDtlTransVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "SupplierPerformanceDtlTransDATA->insertRecord()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}		
	}


	

	public static void getSupplierPerformancePendingDtlView(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");


			supplierPerformanceDtlTransVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( "0");
			supplierPerformanceDtlTransVO.setStrPoNo("0");
			supplierPerformanceDtlTransVO.setStrChallanNo("0");
			supplierPerformanceDtlTransVO.setStrFromDate("0");
			supplierPerformanceDtlTransVO.setStrToDate("0");
			
			supplierPerformanceDtlTransVO.setStrMode("4");
			
			
			
			//Calling BO
			supplierPerformanceDtlTransBO.getSupplierPerformancePendingDtlView(supplierPerformanceDtlTransVO);
			
			
			
			
			if (supplierPerformanceDtlTransVO.getStrMsgType().equals("1")) {
				throw new Exception(supplierPerformanceDtlTransVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformancePendingDtlTable(supplierPerformanceDtlTransVO.getWrsData());
			
			
		//	supplierPerformanceDtlTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "SupplierPerformanceDtlTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
		}
	}
	
	
	public static void getSupplierPerformanceCompletedDtlView(SupplierPerformanceDtlTransFB supplierPerformanceDtlTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		SupplierPerformanceDtlTransBO supplierPerformanceDtlTransBO = null;
		SupplierPerformanceDtlTransVO supplierPerformanceDtlTransVO = null;
		

		String strSupplierPerformancePendingDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			supplierPerformanceDtlTransBO = new SupplierPerformanceDtlTransBO();
			supplierPerformanceDtlTransVO = new SupplierPerformanceDtlTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","SupplierPerformanceDtlTransDATA");


			supplierPerformanceDtlTransVO.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtlTransVO.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			supplierPerformanceDtlTransVO.setStrDWHId( (request_p.getParameter("dwhId")==null)?"0": request_p.getParameter("dwhId"));
			supplierPerformanceDtlTransVO.setStrStoreId( "0");
			supplierPerformanceDtlTransVO.setStrPoNo("0");
			supplierPerformanceDtlTransVO.setStrChallanNo("0");
			supplierPerformanceDtlTransVO.setStrFromDate((request_p.getParameter("fromDate")==null)?"0": request_p.getParameter("fromDate"));
			supplierPerformanceDtlTransVO.setStrToDate((request_p.getParameter("toDate")==null)?"0": request_p.getParameter("toDate"));
			
			supplierPerformanceDtlTransVO.setStrMode("5");
			
			
			
			//Calling BO
			supplierPerformanceDtlTransBO.getSupplierPerformancePendingDtlView(supplierPerformanceDtlTransVO);
			
			
			
			
			if (supplierPerformanceDtlTransVO.getStrMsgType().equals("1")) {
				throw new Exception(supplierPerformanceDtlTransVO.getStrMsgString());
			}
			
			strSupplierPerformancePendingDetailsTable	=	getSupplierPerformanceCompletedDtlTable(supplierPerformanceDtlTransVO.getWrsData());
			
			
		//	supplierPerformanceDtlTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strSupplierPerformancePendingDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "SupplierPerformanceDtlTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			supplierPerformanceDtlTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			supplierPerformanceDtlTransBO = null;
			supplierPerformanceDtlTransVO = null;
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
