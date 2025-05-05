

package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.SupplierPerformanceDtailRptBO;
import mms.reports.controller.fb.SupplierPerformanceDtailRptFB;
import mms.reports.controller.hlp.SupplierPerformanceDtailRptHLP;
import mms.reports.vo.SupplierPerformanceDtailRptVO;

public class SupplierPerformanceDtailRptDATA 
{
	
	public static void getInitializedValues(SupplierPerformanceDtailRptFB supplierPerformanceDtailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		SupplierPerformanceDtailRptBO bo = null;
		SupplierPerformanceDtailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new SupplierPerformanceDtailRptBO();
			voObj = new SupplierPerformanceDtailRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			supplierPerformanceDtailRptFB_p.setStrHospitalCode(strHospitalCode);
			supplierPerformanceDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","SupplierPerformanceDtailRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			//strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(supplierPerformanceDtailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
//			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
//			supplierPerformanceDtailRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^Select Value", false);
			supplierPerformanceDtailRptFB_p.setStrManufactureCombo(strSupplierVal);
			
			supplierPerformanceDtailRptFB_p.setStrGroupCombo(hisutil.getOptionValue(voObj.getStrGroupNameComboWS(), "0", "0^All", false));
			
			supplierPerformanceDtailRptFB_p.setStrDrugCombo(hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), "0", "0^All", false));
						
			hisutil = new HisUtil("MMS Transactions", "SupplierPerformanceDtailRptDATA");
			// For setting the financial year 
			supplierPerformanceDtailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			supplierPerformanceDtailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			supplierPerformanceDtailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.SupplierPerformanceDtailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"SupplierPerformanceDtailRptDATA->getInitializedValues()", strMsgText);
			supplierPerformanceDtailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getDrugNameValues(SupplierPerformanceDtailRptFB supplierPerformanceDtailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		SupplierPerformanceDtailRptBO bo = null;
		SupplierPerformanceDtailRptVO voObj = null;
		String strMsgText = null;
		HisUtil hisutil = null;
		String strDrugValuesWs=null;
		String strGroupId= request.getParameter("groupCode");
		
//		int strCurrentMonth;
//		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new SupplierPerformanceDtailRptBO();
			voObj = new SupplierPerformanceDtailRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			supplierPerformanceDtailRptFB_p.setStrGroupId(strGroupId);
			supplierPerformanceDtailRptFB_p.setStrHospitalCode(strHospitalCode);
			supplierPerformanceDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","SupplierPerformanceDtailRptDATA");
			
			voObj.setStrSeatId(supplierPerformanceDtailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrGroupId(supplierPerformanceDtailRptFB_p.getStrGroupId());
			
			bo.getDrugNameComboValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			//supplierPerformanceDtailRptFB_p.setStrDrugCombo(hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), voObj.getStrDrugId(), "0^All", false));
			if(voObj.getStrDrugNameComboWS()!=null && voObj.getStrDrugNameComboWS().size() >0){
				strDrugValuesWs =hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), "0", "0^All", false);
			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDrugValuesWs);
			//hisutil = new HisUtil("MMS Transactions", "SupplierPerformanceDtailRptDATA");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.SupplierPerformanceDtailRptDATA.getDrugNameValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"SupplierPerformanceDtailRptDATA->getDrugNameValues()", strMsgText);
			supplierPerformanceDtailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	public static void getPOCombo(SupplierPerformanceDtailRptFB supplierPerformanceDtailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		SupplierPerformanceDtailRptBO bo = null;
		SupplierPerformanceDtailRptVO voObj = null;
		String strMsgText = null;
		HisUtil hisutil = null;
		String strDrugValuesWs=null;
		String supplierId= request.getParameter("supplierId");
		String strHospitalCode;
		
		try {

			bo = new SupplierPerformanceDtailRptBO();
			voObj = new SupplierPerformanceDtailRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrSupplierId(supplierId);
			supplierPerformanceDtailRptFB_p.setStrHospitalCode(strHospitalCode);
			supplierPerformanceDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","SupplierPerformanceDtailRptDATA");
			
			voObj.setStrSeatId(supplierPerformanceDtailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			
			bo.getPOCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			//supplierPerformanceDtailRptFB_p.setStrDrugCombo(hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), voObj.getStrDrugId(), "0^All", false));
			if(voObj.getStrSupplierComboWS()!=null && voObj.getStrSupplierComboWS().size() >0){
				strDrugValuesWs =hisutil.getOptionValue(voObj.getStrSupplierComboWS(), "0", "0^All", false);
			}
			else
			{
				strDrugValuesWs = "<option value='0'>All</option>";				
			}			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDrugValuesWs);
			//hisutil = new HisUtil("MMS Transactions", "SupplierPerformanceDtailRptDATA");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.SupplierPerformanceDtailRptDATA.getDrugNameValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"SupplierPerformanceDtailRptDATA->getPOCombo()", strMsgText);
			supplierPerformanceDtailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	 public static void getPrintScreenTwo(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

				SupplierPerformanceDtailRptBO bo = null;
				SupplierPerformanceDtailRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new SupplierPerformanceDtailRptBO();
					vo = new SupplierPerformanceDtailRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("supplierName"));
														
					bo.getScreenTwo(vo);
					
					//String strItemDetails = SupplierPerformanceDtailRptHLP.getPrintScreenTwo(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					//response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	
	 public static void getSupplierPerformanceDtl(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				SupplierPerformanceDtailRptBO bo = null;
				SupplierPerformanceDtailRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new SupplierPerformanceDtailRptBO();
					vo = new SupplierPerformanceDtailRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrGroupId(request.getParameter("groupCode"));
					vo.setStrDrugId(request.getParameter("drugCode"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("suppName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					vo.setStrPoNumber(request.getParameter("poNumber"));
					////System.out.println("drugName :"+vo.getStrDrugName());				
					bo.getSupplierPerformanceDtl(vo);
					String strItemDetails = SupplierPerformanceDtailRptHLP.getScreenOne(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getSupplierPerformanceDtl --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getSupplierPerformanceDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	 
	 
	 public static void getSupplierPerformanceDtlPrint(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				SupplierPerformanceDtailRptBO bo = null;
				SupplierPerformanceDtailRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new SupplierPerformanceDtailRptBO();
					vo = new SupplierPerformanceDtailRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrGroupId(request.getParameter("groupCode"));
					vo.setStrDrugId(request.getParameter("drugCode"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("suppName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					vo.setStrPoNumber(request.getParameter("poNumber"));
					
					String strFlag = request.getParameter("flag");
					
					////System.out.println("Drug ID:(request.getParameter(drugCode))::"+request.getParameter("drugCode"));
					bo.getSupplierPerformanceDtl(vo);
					
					String strItemDetails = "";
					
					if(strFlag.equals("1"))
						strItemDetails = SupplierPerformanceDtailRptHLP.getSupplierPerformabceDetailsPopUp1(vo);
					else
						strItemDetails = SupplierPerformanceDtailRptHLP.getSupplierPerformabceDetailsPopUp1_without(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getSupplierPerformanceDtl --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getSupplierPerformanceDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	 public static void getSupplierPODtlPopUp(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				SupplierPerformanceDtailRptBO bo = null;
				SupplierPerformanceDtailRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new SupplierPerformanceDtailRptBO();
					vo = new SupplierPerformanceDtailRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					/* Value Pass in Web Row Set
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount 
		            4. Supplier ID */  											
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					////System.out.println("Hidden Value==>"+request.getParameter("hiddenValue"));
					vo.setStrSupplierId(request.getParameter("hiddenValue").split("\\^")[3]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
				
					vo.setStrHiddenValue(request.getParameter("hiddenValue"));
					
					bo.getSupplierPODtlPopUp(vo);
					
					//String strItemDetails = SupplierPerformanceDtailRptHLP.getSupplierPODtlPopUp(vo.getStrSupplierPODtlWs(),vo.getStrHiddenValue());
					//String strItemDetails = SupplierPerformanceDtailRptHLP.getSupplierPODtlPopUpOne(vo);
					
					response.setHeader("Cache-Control", "no-cache");
					//response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
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


	
	
    public static void getPODtl(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			SupplierPerformanceDtailRptBO bo = null;
			SupplierPerformanceDtailRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new SupplierPerformanceDtailRptBO();
				vo = new SupplierPerformanceDtailRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																
			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrSupplierId(request.getParameter("supplierId"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
								
				bo.getPODetails(vo);
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getPoDtlOne(vo);
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getPODetails(vo.getStrPOWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				//response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getItemDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
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

   
    
    public static void getPOChallanDtlPopUp(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			SupplierPerformanceDtailRptBO bo = null;
			SupplierPerformanceDtailRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new SupplierPerformanceDtailRptBO();
				vo = new SupplierPerformanceDtailRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				 /* Value Pass in Web Row Set
		    	   1. PO TYPE
		    	   2. PO DATE , 
	            3. PO NET AMT,
	            4. STORE ID 
	            5. PO  NO
	            6. SUPPLIED AMT 
				
                "+++++++++"
	    	   
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount 
		            4. Supplier ID */  	
				
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
				vo.setStrHiddenValue(request.getParameter("hiddenValue"));
				
				vo.setStrStoreId(request.getParameter("hiddenValue").split("\\^")[3]);
				vo.setStrPoNumber(request.getParameter("hiddenValue").split("\\^")[4]);
				
				bo.getPOChallanDtlPopUp(vo);
				
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getPOChallanDtlPopUp(vo.getStrPOChallanDtlWs(),vo.getStrHiddenValue());
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getPOChallanDtlPopUpOne(vo);
				
				
				response.setHeader("Cache-Control", "no-cache");
				//response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.transactions.IssueTransDATA.getPOChallanDtlPopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getPOChallanDtlPopUp()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
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

    
    public static void getChallanItemDtlPopUp(SupplierPerformanceDtailRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{

			SupplierPerformanceDtailRptBO bo = null;
			SupplierPerformanceDtailRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new SupplierPerformanceDtailRptBO();
				vo = new SupplierPerformanceDtailRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				/* Value Pass in Web Row Set
		    	   1. Chaalna No
		    	   2. Challan Date , 
	               3. Store Name(Location),
	               4. Value 
	               5. Stor ID(Location)
                   ++++++++++++++++++++
		    	   1. PO TYPE
		    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
				
                "+++++++++"
	    	   
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount 
		            4. Supplier ID */  	  				
				
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
				vo.setStrHiddenValue(request.getParameter("hiddenValue"));				
				vo.setStrStoreId(request.getParameter("hiddenValue").split("\\^")[4]);
				vo.setStrChallanNo(request.getParameter("hiddenValue").split("\\^")[0]);
				vo.setStrPoNumber(request.getParameter("hiddenValue").split("\\^")[9]);
				vo.setStrHiddenValue(request.getParameter("hiddenValue"));
				
				bo.getChallanItemDtlPopUp(vo);
				
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getChallanItemDtlPopUp(vo.getStrChallanItemDtlWs(),request.getParameter("hiddenValue"));
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getChallanItemDtlPopUpOne(vo);
				
				
				response.setHeader("Cache-Control", "no-cache");
				//response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.transactions.IssueTransDATA.getChallanItemDtlPopUp --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getChallanItemDtlPopUp()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
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

    
    
    public static void getChallanDtl(SupplierPerformanceDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			SupplierPerformanceDtailRptBO bo = null;
			SupplierPerformanceDtailRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new SupplierPerformanceDtailRptBO();
				vo = new SupplierPerformanceDtailRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrStoreId(request.getParameter("StoreId"));
			    vo.setStrPoNumber(request.getParameter("PoNumber"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
				
				bo.getChallanDetails(vo);
				
				//String strItemDetails = SupplierPerformanceDtailRptHLP.getChallanDetails(vo.getStrChallanWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				//response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"IssueTransDATA->getItemDetails()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "
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

    
    public static void showReport(SupplierPerformanceDtailRptFB supplierPerformanceDtailRptFB_p,HttpServletRequest request, HttpServletResponse response) {
    	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strProcRelatedValue = request.getParameter("strProcRelatedValue");
			
			String strSupplierName = strProcRelatedValue.split("\\^")[0];
			String	strPoNoWithPrefix = strProcRelatedValue.split("\\^")[1];
			
			String	strPoDate = strProcRelatedValue.split("\\^")[9];
			String	strPoValue = strProcRelatedValue.split("\\^")[11];
			
			
			String strStoreID =	strProcRelatedValue.split("\\^")[12];
			String strPoNo =	strProcRelatedValue.split("\\^")[13];
			
			
			
			supplierPerformanceDtailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			supplierPerformanceDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = supplierPerformanceDtailRptFB_p.getStrHospitalCode();
			String strReportId = supplierPerformanceDtailRptFB_p.getStrReportId();
		
		
/*			String strStartYear = supplierPerformanceDtailRptFB_p.getStrStartFinancialYear();
			String strEndYear = supplierPerformanceDtailRptFB_p.getStrEndFinancialYearTemp();
*/			
			
			String strFromDate = supplierPerformanceDtailRptFB_p.getStrFromDate();
			String strToDate = supplierPerformanceDtailRptFB_p.getStrToDate();
			
			String strUserRemarks = supplierPerformanceDtailRptFB_p.getStrUserRemarks();
			
			reportFormat = supplierPerformanceDtailRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(supplierPerformanceDtailRptFB_p.getStrIsFooter()==null)
				supplierPerformanceDtailRptFB_p.setStrIsFooter("0");
			
			if (supplierPerformanceDtailRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Supplier Performance De tail Report Report";
	
							
				String reportPath = "/mms/reports/dwh_materialInwardRegister_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				
				params.put("ponoWithPrefix", strPoNoWithPrefix);
				
				params.put("storeid", strStoreID);	
				
				
				params.put("supplierName", supplierPerformanceDtailRptFB_p.getStrSupplierName());
				params.put("pono", strPoNo);
				params.put("poDate", strPoDate);
				params.put("poValue", strPoValue);
				params.put("supplierId", "0");
				
		/*		
			//System.out.println("strPoNoWithPrefix:"+strPoNoWithPrefix);
			//System.out.println("strPoNo:"+strPoNo);
			//System.out.println("strPoDate:"+strPoDate);
			//System.out.println("strPoValue:"+strPoValue);
	
			//System.out.println("strStoreID:"+strStoreID);
	
			//System.out.println("strHospitalCode:"+strHospitalCode);
			
			//System.out.println("materialOutwardRegisterRptFB_p.getStrSupplierName():"+supplierPerformanceDtailRptFB_p.getStrSupplierName());
			//System.out.println("sdf.format(sdf.parse(strFromDate)):"+sdf.format(sdf.parse(strFromDate)));
			//System.out.println("sdf.format(sdf.parse(strToDate)):"+sdf.format(sdf.parse(strToDate)));
				*/
							
				
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
											
				ts.displayReport(request, response, reportPath, reportFormat,params,supplierPerformanceDtailRptFB_p.getStrHospitalCode());
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

	
    
	
}
