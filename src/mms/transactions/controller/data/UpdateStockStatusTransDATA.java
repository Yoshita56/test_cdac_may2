package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.UpdateStockStatusTransBO;
import mms.transactions.controller.fb.UpdateStockStatusTransFB;
import mms.transactions.vo.UpdateStockStatusTransVO;

public class UpdateStockStatusTransDATA {
	
	
	
	
	public static void getInitializedValues(UpdateStockStatusTransFB formBean, HttpServletRequest request_p, HttpServletResponse response) 
	{

		UpdateStockStatusTransBO bo = null;
		UpdateStockStatusTransVO vo = null;

		HisUtil hisutil = null;
		String strStoreVal = "";
		String strMsgText = null;
		String strCurrentDate;
		
		try 
		{
			bo = new UpdateStockStatusTransBO();
			vo = new UpdateStockStatusTransVO();

			hisutil = new HisUtil("DWH","BudgetDetailRptDATA");
			formBean.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getInitializedValues(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			hisutil = new HisUtil("MMS Transactions", "UpdateStockStatusTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{
				
				
				if(vo.getStrDrugWareHouseTypeId()!=null && !vo.getStrDrugWareHouseTypeId().equals(""))
				{
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), vo.getStrDrugWareHouseTypeId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
				}
				
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
			
			formBean.setStrGroupCombo(hisutil.getOptionValue(vo.getStrGroupNameComboWS(), "0", "0^Select Value", false));
			
			String temp = "<option value='0'>Select Value</option>";

			if (vo.getStrItemCatWs().size() != 0)
			{
				
				temp = hisutil.getOptionValue(vo.getStrItemCatWs(), "0", "0^Select Value",	true);

			}
			else
			{
				
				temp = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrItemCatgCmb(temp);
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.UpdateStockStatusTransDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"UpdateStockStatusTransDATA->getDrugWareHouseNameCombo()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	

	public static void getInitializedViewValues(UpdateStockStatusTransFB formBean, HttpServletRequest request_p, HttpServletResponse response) 
	{

		UpdateStockStatusTransBO bo = null;
		UpdateStockStatusTransVO vo = null;

		HisUtil hisutil = null;
		String strStoreVal = "";
		String strMsgText = null;
		String strCurrentDate;
		
		try {
			bo = new UpdateStockStatusTransBO();
			vo = new UpdateStockStatusTransVO();

			hisutil = new HisUtil("DWH","BudgetDetailRptDATA");
			formBean.setStrHospitalCode(request_p.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getInitializedValues1(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			hisutil = new HisUtil("MMS Transactions", "UpdateStockStatusTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{
				
				
				if(vo.getStrDrugWareHouseTypeId()!=null && !vo.getStrDrugWareHouseTypeId().equals(""))
				{
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), vo.getStrDrugWareHouseTypeId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = hisutil.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
				}
				
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
						
			
			String temp = "<option value='0'>Select Value</option>";
			if(vo.getStrItemCatWs().next())
			{
				vo.setStrItemCategoryId(vo.getStrItemCatWs().getString(1));
			}
			vo.getStrItemCatWs().beforeFirst();
			
			if (vo.getStrItemCatWs().size() != 0)
			{
				
				temp = hisutil.getOptionValue(vo.getStrItemCatWs(), vo.getStrItemCategoryId(), "0^Select Value",	true);

			}
			else
			{
				
				temp = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrItemCatgCmb(temp);
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.UpdateStockStatusTransDATA.getInitializedViewValues() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"UpdateStockStatusTransDATA->getInitializedViewValues()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	
	public static void getItemCatDtls(UpdateStockStatusTransFB formBean,HttpServletRequest request_p, HttpServletResponse response)
	{

		UpdateStockStatusTransBO bo = null;
		UpdateStockStatusTransVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new UpdateStockStatusTransBO();
			voObj = new UpdateStockStatusTransVO();
			
			String strStoreId = request_p.getParameter("storeId");
		
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrDrugWareHouseTypeId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			
			
			
			bo.getItemCatDtls(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "UpdateStockStatusTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0)
			{
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",	true);

			}
			else
			{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.UpdateStockStatusTransDATA.getItemCatDtls --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"UpdateStockStatusTransDATA->getItemCatDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	
	
	public static void getDrugNameValues(UpdateStockStatusTransFB updateStockStatusTransFB_p,	HttpServletRequest request_p, HttpServletResponse response) {

		UpdateStockStatusTransBO bo = null;
		UpdateStockStatusTransVO voObj = null;
		String strMsgText = null;
		HisUtil hisutil = null;
		String strDrugValuesWs=null,strStockStatusCmb=null;
		String strGroupId= request_p.getParameter("groupCode");
		
		String strHospitalCode;
		
		try {

			bo = new UpdateStockStatusTransBO();
			voObj = new UpdateStockStatusTransVO();
			
			
			strHospitalCode=request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			updateStockStatusTransFB_p.setStrGroupId(strGroupId);
			updateStockStatusTransFB_p.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransFB_p.setStrSeatId(request_p.getSession().getAttribute("SEATID").toString());
		
			voObj.setStrItemCategoryId(request_p.getParameter("categoryCode"));
			
			
			hisutil = new HisUtil("DWH","UpdateStockStatusTransDATA");
			
			voObj.setStrDrugWareHouseTypeId(request_p.getParameter("storeId"));
			voObj.setStrItemBrandId("0");
			
			voObj.setStrSeatId(updateStockStatusTransFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrGroupId(request_p.getParameter("groupCode"));
			
			voObj.setStrMode("1");
			
			bo.getDrugCurrentStockValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			//System.out.println("---getStrDrugNameComboWS.SIZE---"+voObj.getStrDrugNameComboWS().size());
			
			if(voObj.getStrDrugNameComboWS()!=null && voObj.getStrDrugNameComboWS().size() >0)
			{
				strDrugValuesWs =hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), "0", "0^Select Value", false);
			}		
			
			if (voObj.getStrStockStatusWs() != null && voObj.getStrStockStatusWs().size() > 0) 
			{
				strStockStatusCmb = hisutil.getOptionValue(voObj.getStrStockStatusWs(),	"0", "0^Select Value",	true);

			} else {
				strStockStatusCmb = "<option value='0'>Select Value</option>";

			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDrugValuesWs+"$"+strStockStatusCmb);
			
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.UpdateStockStatusTransDATA.getDrugNameValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"UpdateStockStatusTransDATA->getDrugNameValues()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	
	
	public static void getCurrentStockDtls(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		

		String strCurrentDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		String strFinancialYear;
		HisUtil hisutil=null;
		try 
		{
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");

			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrItemCategoryId(request_p.getParameter("categoryCode"));
			updateStockStatusTransVO.setStrDrugWareHouseTypeId(request_p.getParameter("storeId"));
			updateStockStatusTransVO.setStrItemBrandId(request_p.getParameter("itemBrandId")); // Drug Id
			updateStockStatusTransVO.setStrSeatId(updateStockStatusTransFB_p.getStrSeatId());
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrGroupId(request_p.getParameter("groupCode"));
			updateStockStatusTransVO.setStrMode("2");
			
			
			System.out.println("----UpdateStockStatusTransDATA.getCurrentStockDtls-----");
			System.out.println("----PKG_MMS_VIEW.proc_stock_status_list[ Mode - 1] ,PKG_MMS_VIEW.proc_get_Drug_list_Combo1 [ Mode - 2] -----");
			
			
			
			
			//Calling BO
			updateStockStatusTransBO.getDrugCurrentStockValues(updateStockStatusTransVO);

			if (updateStockStatusTransVO.getStrMsgType().equals("1")) 
			{
				throw new Exception(updateStockStatusTransVO.getStrMsgString());
			}
		
			// PKG_MMS_VIEW.proc_get_Drug_list_Combo1 [ Mode - 2 ]
					
			strCurrentDetailsTable	=	getCurrentStockDetailsTable(updateStockStatusTransVO.getStrDrugNameComboWS());
			
			
		
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strCurrentDetailsTable);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "UpdateStockStatusTransDATA.getCurrentStockDtls(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","UpdateStockStatusTransDATA->UpdateStockStatusTransDATA()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}
	}
	

	/**
	 * To get Entered Dependent Details HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	private static String getCurrentStockDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=10;
		int nColspan=6;
		int count =0;
		
	/*  
	  	sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Current Stock Details</td>" + "</tr>");
		sbTable.append("</table>");
	*/
		sbTable.append("<p class='subHeaders' style='text-align:left'>&nbsp; Current Stock Details</p>");
		
		/*
		 * Header Row:
		 */
		
		sbTable.append("<table class='table'>");
		sbTable.append("<thead class='thead-dark' align='center'><tr>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
		sbHeader.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;' >Batch No.</th>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Expiry Date</th>");
		sbHeader.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Supplied By</th>");
		sbHeader.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty</th>");
		sbHeader.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Sale / MRP</th>");
		sbHeader.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Stock Status</th>"); 
		sbHeader.append("</tr></thead>");

	
	/*	sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		sbHeader.append("<td width=\"10%\" class=\"LABEL\" style=\"text-align: center;\">#</td>");
		sbHeader.append("<td width=\"15%\" class=\"LABEL\" style=\"text-align: center;\">Batch No.</td>");
		sbHeader.append("<td width=\"10%\" class=\"LABEL\" style=\"text-align: center;\">Expiry Date</td>");
		sbHeader.append("<td width=\"20%\" class=\"LABEL\" style=\"text-align: center;\">Supplied By</td>");
		sbHeader.append("<td width=\"15%\" class=\"LABEL\" style=\"text-align: center;\">Available Qty</td>");
		sbHeader.append("<td width=\"15%\" class=\"LABEL\" style=\"text-align: center;\">Sale / MRP</td>");
		sbHeader.append("<td width=\"20%\" class=\"LABEL\" style=\"text-align: center;\">Stock Status</td>"); 
		sbHeader.append("</tr>");
	*/
		if (wrsData_p != null && wrsData_p.size() > 0) {		
			/* Result Index */
			
//			   ITEM_NAME	1
//			   BATCH_NO		2
//			   EXPIRY_DATE  3
//			   STOCK_STATUS	4
//			   HSTNUM_INHAND_QTY With Unit	5 
//			   SUPPLIED_BY	6
//		       HSTNUM_STOCK_STATUS_CODE 7			
//			   HSTNUM_GROUP_ID	8
//			   HSTNUM_SUBGROUP_ID	9
//			   HSTDT_EXPIRY_DATE	10
//	           HSTDT_MANUF_DATE	11
//	           HSTNUM_SUPPLIER_ID	12
//	           HSTNUM_RATE	13 
//	           HSTNUM_RATE_UNITID 14
//	           HSTNUM_SALEPRICE	15
//	           HSTNUM_SALEPRICE_UNITID	16
//	           HSTNUM_PO_NO	17
//	           HSTDT_PO_DATE	18
//			   HSTNUM_SUPPLIED_BY	19
//			   HSTDT_RECIEVED_DATE	20
//			   HSTNUM_CURRENCY_ID	21
//			   HSTNUM_FREEITEM_FLAG	22 
//      	   HSTNUM_CURRENT_VALUE	23	
//       	   HSTNUM_INVOICE_NO	24
//       	   HSTNUM_INVOICE_DATE	25
//       	   HSTSTR_SPECIFICATION	26
//			   HSTNUM_INHAND_QTY_UNITID 27
//			   HSTNUM_ITEM_ID		28
//             HSTNUM_BLOCKED_QTY with Unit   29
//             Expiry With Format   30
//             HSTNUM_BLOCKED_QTY   31
//             HSTNUM_INHAND_QTY 	32
//             HSTNUM_STOCK_STATUS_CODE 33		
//  			HSTNUM_MRP  34
//			    NVL( INVOICE, PO_NO)  35
		
			
			while (wrsData_p.next()) {
	
				
				
				String strDrugName = wrsData_p.getString("ITEM_NAME");
				String strBatchNo = wrsData_p.getString("BATCH_NO");
				String strExpiryDate = wrsData_p.getString("EXPIRY_DATE");
				String strStockStatus = wrsData_p.getString("STOCK_STATUS");
				
				String strAvlQty = wrsData_p.getString(5);
				String strSuppliedBy = wrsData_p.getString("SUPPLIED_BY");
				String strBlockedQty = wrsData_p.getString(29);
				
				String strSalePrice = wrsData_p.getString(15);
				String strMRP = wrsData_p.getString(34);
				String strInvoice = wrsData_p.getString(35);
				
				
				
				
				if (strDrugName == null) {
					strDrugName = "---";
				}
				if (strBatchNo == null) {
					strBatchNo = "---";
				}
				if (strExpiryDate == null) {
					strExpiryDate = "---";
				}
				if (strSuppliedBy == null) {
					strSuppliedBy = "---";
				}
				if (strAvlQty == null) {
					strAvlQty = "---";
				}
				
				if (strStockStatus == null) {
					strStockStatus = "---";
				}
				
				if (strBlockedQty == null) {
					strBlockedQty = "---";
				}
				
				
				
				/*
				 * Table Body
				 */
	
				sbBody.append("<tr>");
				count = count + 1;
				
				String strHiddenValue = wrsData_p.getString(1)+"^"+strBatchNo+"^"+ strExpiryDate +"^"+ strStockStatus +"^"+ strAvlQty +"^"+ strSuppliedBy +"^"+ wrsData_p.getString(7)
										+"^"+ wrsData_p.getString(8)+"^"+ wrsData_p.getString(9)+"^"+ wrsData_p.getString(10)+"^"+ wrsData_p.getString(11)+"^"+ wrsData_p.getString(12)
										+"^"+ wrsData_p.getString(13)+"^"+ wrsData_p.getString(14)+"^"+ wrsData_p.getString(15)+"^"+ wrsData_p.getString(16)+"^"+ wrsData_p.getString(17)
										+"^"+ wrsData_p.getString(18)+"^"+ wrsData_p.getString(19)+"^"+ wrsData_p.getString(20)+"^"+ wrsData_p.getString(21)+"^"+ wrsData_p.getString(22)
										+"^"+ wrsData_p.getString(23)+"^"+ wrsData_p.getString(24)+"^"+ wrsData_p.getString(25)+"^"+ wrsData_p.getString(26)+"^"+ wrsData_p.getString(27)
										+"^"+ wrsData_p.getString(28)+"^"+wrsData_p.getString(29)+"^"+ wrsData_p.getString(30)+"^"+wrsData_p.getString(31)+"^"+wrsData_p.getString(32)+"^"+wrsData_p.getString(33);
				
				sbBody.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + "<input type='radio' id='strCurrStockDtl"+count+"' name='strCurrStockDtl' onclick='setHiddenValues(this,\""+count+"\")' value='"+ strHiddenValue +"' >" + "</td>");
				sbBody.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strBatchNo + "</td>");
				sbBody.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + wrsData_p.getString(30) + "</td>");
				sbBody.append("<td  width='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;'>" + strSuppliedBy +"[ "+strInvoice + " ] </td>");
				sbBody.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strAvlQty + "</td>");
				sbBody.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strSalePrice +"/"+strMRP+ "</td>");
				sbBody.append("<td  width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strStockStatus + "</td>");
				
				sbBody.append("</tr>"); 
			}
	
			sbBody.append("</table>");
		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\"  style='font-weight:350 !important ;font-size: 16px !important; color: red'>No Data Found!</td>");
			sbBody.append("</tr></table>");
		}
	
		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}

	
	
	
	public static void getStockStatusList(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		

		
		String strMsgText = "";
		String	strHospitalCode;
		String strStockStatusCmb;
		
		HisUtil hisutil=null;
		try {
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");


			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrItemCategoryId(request_p.getParameter("categoryCode"));
			
			updateStockStatusTransVO.setStrDrugWareHouseTypeId(request_p.getParameter("storeId"));
			updateStockStatusTransVO.setStrItemBrandId(request_p.getParameter("itemBrandId")); // Drug Id
			
			updateStockStatusTransVO.setStrSeatId(updateStockStatusTransFB_p.getStrSeatId());
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrGroupId(request_p.getParameter("groupCode"));
			
			updateStockStatusTransVO.setStrMode("2");
			
			
			//Calling BO
			updateStockStatusTransBO.getStockStatusList(updateStockStatusTransVO);

			if (updateStockStatusTransVO.getStrMsgType().equals("1")) 
			{
				throw new Exception(updateStockStatusTransVO.getStrMsgString());
			}
		
			
			if (updateStockStatusTransVO.getStrStockStatusWs() != null && updateStockStatusTransVO.getStrStockStatusWs().size() > 0) 
			{
				strStockStatusCmb = hisutil.getOptionValue(updateStockStatusTransVO.getStrStockStatusWs(),	"0", "0^Select Value",	true);

			} else {
				strStockStatusCmb = "<option value='0'>Select Value</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockStatusCmb);
			
			 
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "UpdateStockStatusTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","UpdateStockStatusTransDATA->UpdateStockStatusTransDATA()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}
	}
	
	
	
	/**
	 * To get Unit Combo
	 * 
	 * 
	 * @param updateStockStatusTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getUnitNameCombo(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		

		
		String strMsgText = "";
		String	strHospitalCode;
		String strUnitCombo;
		
		HisUtil hisutil=null;
		try {
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");


			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrItemCategoryId(request_p.getParameter("categoryCode"));
			
			updateStockStatusTransVO.setStrDrugWareHouseTypeId(request_p.getParameter("storeId"));
			updateStockStatusTransVO.setStrItemBrandId(request_p.getParameter("itemBrandId")); // Drug Id
			
			updateStockStatusTransVO.setStrSeatId(updateStockStatusTransFB_p.getStrSeatId());
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrGroupId(request_p.getParameter("groupCode"));
			
			
			
			
			//Calling BO
			updateStockStatusTransBO.getUnitNameCombo(updateStockStatusTransVO);

			if (updateStockStatusTransVO.getStrMsgType().equals("1")) 
			{
				throw new Exception(updateStockStatusTransVO.getStrMsgString());
			}
		
			
			if (updateStockStatusTransVO.getWsUnitCombo() != null && updateStockStatusTransVO.getWsUnitCombo().size() > 0) 
			{
				strUnitCombo = hisutil.getOptionValue(updateStockStatusTransVO.getWsUnitCombo(),	"0", "0^Select Value",	true);

			} else {
				strUnitCombo = "<option value='0'>Select Value</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strUnitCombo);
			
			 
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "UpdateStockStatusTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","UpdateStockStatusTransDATA->UpdateStockStatusTransDATA()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}
	}
	
	
	/**
	 * To get Unit Combo
	 * 
	 * 
	 * @param updateStockStatusTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getApprovedByCombo(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		String strReceivedByOptionVal="";
		
		String strMsgText = "";
		String	strHospitalCode;
		
		HisUtil hisutil=null;
		try {
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");


			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrItemCategoryId(request_p.getParameter("categoryCode"));
			
			updateStockStatusTransVO.setStrDrugWareHouseTypeId(request_p.getParameter("storeId"));
			updateStockStatusTransVO.setStrItemBrandId(request_p.getParameter("itemBrandId")); // Drug Id
			
			updateStockStatusTransVO.setStrSeatId(updateStockStatusTransFB_p.getStrSeatId());
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			updateStockStatusTransVO.setStrGroupId(request_p.getParameter("groupCode"));
			
			
			
			
			//Calling BO
			updateStockStatusTransBO.getApprovedByCombo(updateStockStatusTransVO);

			if(updateStockStatusTransVO.getWrsRecievedByCombo()!=null){
				strReceivedByOptionVal=hisutil.getOptionValue(updateStockStatusTransVO.getWrsRecievedByCombo(),"0", "Select Value", true);
				strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
			}else{
				strReceivedByOptionVal="<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strReceivedByOptionVal);
			
			 
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "UpdateStockStatusTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","UpdateStockStatusTransDATA->UpdateStockStatusTransDATA()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}
	}
	
	
	
	public static void saveUpdateStockDtls(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		
		
		String strCurrentDate;
		
		
		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();

			/* Result Index */
//			 Hidden Values	in updateStockStatusTransFB_p.getStrHiddenValues()
//			   ITEM_NAME	1
//			   BATCH_NO		2
//			   EXPIRY_DATE  3
//			   STOCK_STATUS	4
//			   HSTNUM_INHAND_QTY With Unit	5 
//			   SUPPLIED_BY	6
//		       HSTNUM_STOCK_STATUS_CODE 7			
//			   HSTNUM_GROUP_ID	8
//			   HSTNUM_SUBGROUP_ID	9
//			   HSTDT_EXPIRY_DATE	10
//	           HSTDT_MANUF_DATE	11
//	           HSTNUM_SUPPLIER_ID	12
//	           HSTNUM_RATE	13 
//	           HSTNUM_RATE_UNITID 14
//	           HSTNUM_SALEPRICE	15
//	           HSTNUM_SALEPRICE_UNITID	16
//	           HSTNUM_PO_NO	17
//	           HSTDT_PO_DATE	18
//			   HSTNUM_SUPPLIED_BY	19
//			   HSTDT_RECIEVED_DATE	20
//			   HSTNUM_CURRENCY_ID	21
//			   HSTNUM_FREEITEM_FLAG	22 
//   	   HSTNUM_CURRENT_VALUE	23	
//    	   HSTNUM_INVOICE_NO	24
//    	   HSTNUM_INVOICE_DATE	25
//    	   HSTSTR_SPECIFICATION	26
//			   HSTNUM_INHAND_QTY_UNITID 27
//			   HSTNUM_ITEM_ID		28
//          HSTNUM_BLOCKED_QTY with Unit   29
//          Expiry With Format   30
//          HSTNUM_BLOCKED_QTY   31
//          HSTNUM_INHAND_QTY 	32
//          HSTNUM_STOCK_STATUS_CODE 33	
			 hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");
			
			 strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			 strCurrentDate=hisutil.getASDate("dd-MM-yyyy");

//			 //System.out.println("updateStockStatusTransFB_p.getStrHiddenValues()=>>"+updateStockStatusTransFB_p.getStrHiddenValues());	
//			 //System.out.println("Store ID ==>"+updateStockStatusTransFB_p.getStrStoreId());
//			 //System.out.println("Item catg ==>"+updateStockStatusTransFB_p.getStrItemCategoryId());
//			 //System.out.println("Batch No  ==>"+updateStockStatusTransFB_p.getStrHiddenValues().split("\\^")[1]);
//			 //System.out.println("Qty  ==>"+updateStockStatusTransFB_p.getStrQty());
//			 //System.out.println("New Status ==>"+updateStockStatusTransFB_p.getStrNewStockStatus());
//			 //System.out.println("Old Status ==>"+updateStockStatusTransFB_p.getStrHiddenValues().split("\\^")[32]);
//			 //System.out.println("Approved By==>"+updateStockStatusTransFB_p.getStrApprovedBy());
//			 //System.out.println("ALL DWH or NOT==>"+updateStockStatusTransFB_p.getStrChkValue());
//			 //System.out.println("Drug Name==>"+updateStockStatusTransFB_p.getStrDrugId());
			 
			 updateStockStatusTransVO.setStrMode("1");
			 updateStockStatusTransVO.setStrRequestTypeId("74");
			 updateStockStatusTransVO.setStrStoreId(updateStockStatusTransFB_p.getStrStoreId());
			 updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			 updateStockStatusTransVO.setStrItemCategoryId(updateStockStatusTransFB_p.getStrItemCategoryId());
			 updateStockStatusTransVO.setStrItemBrandId(updateStockStatusTransFB_p.getStrDrugId());
			 updateStockStatusTransVO.setStrBatchNo(updateStockStatusTransFB_p.getStrHiddenValues().split("\\^")[1]);
			 updateStockStatusTransVO.setStrItemSlNo("0");
			 if(updateStockStatusTransFB_p.getStrChkValue().equals("0"))
			 {		 
			    updateStockStatusTransVO.setStrQty(updateStockStatusTransFB_p.getStrQty());
			 }
			 else
			 {
				 updateStockStatusTransVO.setStrQty("0");  
			 }
			 updateStockStatusTransVO.setStrStockStatusCode(updateStockStatusTransFB_p.getStrHiddenValues().split("\\^")[32]);	// Old StockStatusCode
			 updateStockStatusTransVO.setStrNewStockStatusCode(updateStockStatusTransFB_p.getStrNewStockStatus());	// New	StockStatusCode	
			 updateStockStatusTransVO.setStrWhetherUpdateNewStatusInAllDWH(updateStockStatusTransFB_p.getStrChkValue());
			 if(updateStockStatusTransFB_p.getStrApprovedBy().equals("1"))
			 {
				 updateStockStatusTransVO.setStrApprovedBy(updateStockStatusTransFB_p.getStrApprovedByOther());
			 }
			 else
			 {
			     updateStockStatusTransVO.setStrApprovedBy(updateStockStatusTransFB_p.getStrApprovedBy());
			 }
			updateStockStatusTransVO.setStrRemarks(updateStockStatusTransFB_p.getStrRemarks());
			updateStockStatusTransVO.setStrSeatId(strSeatId);
			
			//updateStockStatusTransVO.setStrDesc("Update Stock Status : From "+updateStockStatusTransFB_p.getStrStockStatusCode() + "to" +updateStockStatusTransFB_p.getStrNewStockStatus() );
			
			
			//CALLING BO
			updateStockStatusTransBO.insertRecord(updateStockStatusTransVO);
			
			
			if (updateStockStatusTransVO.getStrMsgType().equals("1")) {
				throw new Exception(updateStockStatusTransVO.getStrMsgString());
			}

				updateStockStatusTransFB_p.setStrNormalMsg("Record Saved Successfully!");
				updateStockStatusTransFB_p.setStrStoreId("");
		}
		catch (Exception e) 
		{

			e.printStackTrace();
			
			strMsgText = "UpdateStockStatusTransDATA.insertRecord(updateStockStatusTransVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "UpdateStockStatusTransDATA->insertRecord()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}		
	}

	
	
	
	
	
	public static void getViewDetails(UpdateStockStatusTransFB updateStockStatusTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		UpdateStockStatusTransBO updateStockStatusTransBO = null;
		UpdateStockStatusTransVO updateStockStatusTransVO = null;
		

		String strViewUpdatedStockStatusDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		String strFinancialYear;
		HisUtil hisutil=null;
		try {
			updateStockStatusTransBO = new UpdateStockStatusTransBO();
			updateStockStatusTransVO = new UpdateStockStatusTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","UpdateStockStatusTransDATA");


			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strStoreId = (String) request_p.getParameter("storeId");
			String strItemCategoryId = (String) request_p.getParameter("strCategoryId");

			
			updateStockStatusTransVO.setStrMode("1");
			updateStockStatusTransVO.setStrDrugWareHouseTypeId(strStoreId);
			updateStockStatusTransVO.setStrItemCategoryId(strItemCategoryId);
			updateStockStatusTransVO.setStrFromDate((String) request_p.getParameter("startDate"));
			updateStockStatusTransVO.setStrToDate((String) request_p.getParameter("endDate"));
			
			
			
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			
			updateStockStatusTransVO.setStrHospitalCode(strHospitalCode);
			
		
			//Calling BO
			updateStockStatusTransBO.getViewUpdatedStockStatusDetails(updateStockStatusTransVO);
			
			
			
			
			if (updateStockStatusTransVO.getStrMsgType().equals("1")) {
				throw new Exception(updateStockStatusTransVO.getStrMsgString());
			}
			
			strViewUpdatedStockStatusDetailsTable	=	getViewUpdatedStockStatusDetailsTable(updateStockStatusTransVO.getWrsData());
			
			
		//	updateStockStatusTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strViewUpdatedStockStatusDetailsTable);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "UpdateStockStatusTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","UpdateStockStatusTransDATA->getViewDetails()", strMsgText);
			updateStockStatusTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			updateStockStatusTransBO = null;
			updateStockStatusTransVO = null;
		}
	
	}

	/**
	 * To get Entered Dependent Details HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	private static String getViewUpdatedStockStatusDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		
		int count=0;
		int nWidth=15;
		int nColspan=6;
	/*	
		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Stock Status Update Detail</td>" + "</tr>");
		sbTable.append("</table>");
	*/	
		sbTable.append("<p class='subHeaders'  align='left'><i class='fas fa-file-alt iround' style='font-size: 20px; color: #28a745;'></i> &nbsp;Stock Status Update Detail</p>");
	
		/*
		 * Header Row:
		 */
		sbTable.append("<table class='table'>");
		sbTable.append("<thead class='thead-dark' align='center'><tr>");
		sbHeader.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Stock Change Date</th>");
		sbHeader.append("<th width='40%' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Old Status</th>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>New Status</th>");
		sbHeader.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>App By</th>");
		sbHeader.append("</tr></thead>");
		/*
		sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbHeader.append("<td width=15% class=\"LABEL\" style=\"text-align: center;\">Stock Change Date</td>");
		sbHeader.append("<td width=40% class=\"LABEL\" style=\"text-align: center;\">Drug Name </td>");
		sbHeader.append("<td width=10% class=\"LABEL\" style=\"text-align: center;\">Batch No</td>");
		sbHeader.append("<td width=10% class=\"LABEL\" style=\"text-align: center;\">Old Status</td>");
		sbHeader.append("<td width=10% class=\"LABEL\" style=\"text-align: center;\">New Status</td>");
		sbHeader.append("<td width=15% class=\"LABEL\" style=\"text-align: center;\">App By.</td>");
		sbHeader.append("</tr>");
		*/
		if (wrsData_p != null && wrsData_p.size() > 0) 
		{		
			/* Result Index */
//			   HSTDT_STOCK_CHANGE_DATE 	1
//			   ITEM_NAME 	2
//	         HSTSTR_BATCH_NO	3
//	         HSTNUM_QTY 	4
//	         HSTNUM_OLD_STOCK_STATUS	5 
//	         HSTNUM_NEW_STOCK_STATUS 	6
//	         HSTSTR_APPROVED_BY 	7
//	         GSTR_REMARKS	8
//	         HSTNUM_IS_UPDATE_ALL_DWH	9
//           User_Name                 10 			
			
		
			
			while (wrsData_p.next()) {

				
				
				String StockChangeDate = wrsData_p.getString("HSTDT_STOCK_CHANGE_DATE");
				String strDrugName     = wrsData_p.getString("ITEM_NAME");
				String strBatchNo      = wrsData_p.getString("HSTSTR_BATCH_NO");
				String strQty          = wrsData_p.getString("HSTNUM_QTY");				
				String strOldStatus    = wrsData_p.getString("OLD_STATUS");
				String strNewStatus    = wrsData_p.getString("NEW_STATUS");				
				String strApprovedBy   = wrsData_p.getString(8);
				String strReason       = wrsData_p.getString("GSTR_REMARKS");
				String strWhetherUpdatedInAllDWH = wrsData_p.getString("HSTNUM_IS_UPDATE_ALL_DWH");
				String strUserName     = wrsData_p.getString(11);
				
				
				
				if (StockChangeDate == null) {
					StockChangeDate = "---";
				}
				if (strDrugName == null) {
					strDrugName = "---";
				}
				if (strBatchNo == null) {
					strBatchNo = "---";
				}
				if (strQty == null) {
					strQty = "---";
				}
				
				if (strOldStatus == null) {
					strOldStatus = "---";
				}
				if (strNewStatus == null) {
					strNewStatus = "---";
				}
				if (strApprovedBy == null) {
					strApprovedBy = "---";
				}
				if (strReason == null) {
					strReason = "---";
				}
				if (strWhetherUpdatedInAllDWH == null) {
					strWhetherUpdatedInAllDWH = "---";
				}
				
				//System.out.println("Old Stock Status==>"+strOldStatus);
				//System.out.println("New Stock Status==>"+strNewStatus);
				
				
				String strTempHiddenVal = strApprovedBy +"^"+ strReason +"^"+ strWhetherUpdatedInAllDWH;
				
				/*
				 * Table Body
				 */

				sbBody.append("<tr>");
						
				sbBody.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + StockChangeDate + "</td>");
				sbBody.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 16px !important;'>" + 

				"<a	style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"'" +
				"onclick=\"getDrugNameViewPopUp(this,'"+strTempHiddenVal+"'); \">"+strDrugName+"</a>"
				+ "</td>");
								
				sbBody.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strBatchNo + "</td>");
				sbBody.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strOldStatus + "</td>");
				sbBody.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important; color:red'>" + strNewStatus + "</td>");
				sbBody.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>" + strApprovedBy + "</td>");
				
				sbBody.append("</tr>"); 
				
				count++;
				
			}
			sbBody.append("</table>"); 
		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important; color: red' >No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}
	    	
	
	
}
