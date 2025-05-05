package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.MaterialInwardReisterRptBO;
import mms.reports.controller.fb.MaterialInwardReisterRptFB;
import mms.reports.controller.hlp.MaterialInwardReisterRptHLP;
import mms.reports.vo.MaterialInwardReisterRptVO;

public class MaterialInwardReisterRptDATA 
{
	
	public static void getInitializedValues(MaterialInwardReisterRptFB MaterialInwardRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		MaterialInwardReisterRptBO bo = null;
		MaterialInwardReisterRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new MaterialInwardReisterRptBO();
			voObj = new MaterialInwardReisterRptVO();
			
		//	String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			MaterialInwardRptFB_p.setStrHospitalCode(strHospitalCode);
			MaterialInwardRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","MaterialInwardReisterRptDATA");
			
					
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
			
			voObj.setStrSeatId(MaterialInwardRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			/*if(strUserLevel.equals("6"))
			{
				voObj.setStrMode("12");
			}
			else*/
				voObj.setStrMode("1");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
//			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
//			MaterialInwardRptFB_p.setStrStoreValues(strStoreVal);
			
			//strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			
		/*	if(strUserLevel.equals("6"))
			{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			}
			else*/
		//	{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);	
			//}
			
			MaterialInwardRptFB_p.setStrManufactureCombo(strSupplierVal);
						
			hisutil = new HisUtil("MMS Transactions", "MaterialInwardReisterRptDATA");
			// For setting the financial year 
			MaterialInwardRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			MaterialInwardRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			MaterialInwardRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.MaterialInwardReisterRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"MaterialInwardReisterRptDATA->getInitializedValues()", strMsgText);
			MaterialInwardRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	 public static void getPrintScreenTwo(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

				MaterialInwardReisterRptBO bo = null;
				MaterialInwardReisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialInwardReisterRptBO();
					vo = new MaterialInwardReisterRptVO();
																	
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("supplierName"));
					vo.setStrPoNumber(request.getParameter("dateFlg"));
					
					bo.getScreenTwo(vo);
					
					String strItemDetails = MaterialInwardReisterRptHLP.getPrintScreenTwo(vo);
					
					
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
	
	
	 public static void getScreenTwo(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				MaterialInwardReisterRptBO bo = null;
				MaterialInwardReisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialInwardReisterRptBO();
					vo = new MaterialInwardReisterRptVO();
					
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
																	
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrPoNumber(request.getParameter("dateFlg"));
					
									
					bo.getScreenTwo(vo);
					
					String strItemDetails = MaterialInwardReisterRptHLP.getScreenTwo(vo.getStrScreentTwoWs());
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
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
	 
	 
	 public static void getSupplierPODtlPopUp(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				MaterialInwardReisterRptBO bo = null;
				MaterialInwardReisterRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new MaterialInwardReisterRptBO();
					vo = new MaterialInwardReisterRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					/* Value Pass in Web Row Set
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount
		            4. Tax Value
		            5. Total Value 
		            6. Supplier ID */  											
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					////System.out.println("Hidden Value==>"+request.getParameter("hiddenValue"));
					vo.setStrSupplierId(request.getParameter("hiddenValue").split("\\^")[5]);
					////System.out.println("supplier Id in DATA Class:"+request.getParameter("hiddenValue").split("\\^")[5]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
				
					vo.setStrHiddenValue(request.getParameter("hiddenValue"));
					vo.setStrPoNumber(request.getParameter("dateFlg"));
					
					bo.getSupplierPODtlPopUp(vo);
					
					//String strItemDetails = MaterialInwardReisterRptHLP.getSupplierPODtlPopUp(vo.getStrSupplierPODtlWs(),vo.getStrHiddenValue());
					String strItemDetails = MaterialInwardReisterRptHLP.getSupplierPODtlPopUpOne(vo);
					
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


	
	
    public static void getPODtl(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			MaterialInwardReisterRptBO bo = null;
			MaterialInwardReisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new MaterialInwardReisterRptBO();
				vo = new MaterialInwardReisterRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																
			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrSupplierId(request.getParameter("supplierId"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
								
				bo.getPODetails(vo);
				//String strItemDetails = MaterialInwardReisterRptHLP.getPoDtlOne(vo);
				String strItemDetails = MaterialInwardReisterRptHLP.getPODetails(vo.getStrPOWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
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

   
    
    public static void getPOChallanDtlPopUp(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			MaterialInwardReisterRptBO bo = null;
			MaterialInwardReisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new MaterialInwardReisterRptBO();
				vo = new MaterialInwardReisterRptVO();
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
				vo.setStrSupplierId(request.getParameter("dateFlg"));
				
				bo.getPOChallanDtlPopUp(vo);
				
				//String strItemDetails = MaterialInwardReisterRptHLP.getPOChallanDtlPopUp(vo.getStrPOChallanDtlWs(),vo.getStrHiddenValue());
				String strItemDetails = MaterialInwardReisterRptHLP.getPOChallanDtlPopUpOne(vo);
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
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

    
    public static void getChallanItemDtlPopUp(MaterialInwardReisterRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{

			MaterialInwardReisterRptBO bo = null;
			MaterialInwardReisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new MaterialInwardReisterRptBO();
				vo = new MaterialInwardReisterRptVO();
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
				vo.setStrStoreId(request.getParameter("hiddenValue").split("\\^")[6]);
				vo.setStrChallanNo(request.getParameter("hiddenValue").split("\\^")[0]);
				vo.setStrPoNumber(request.getParameter("hiddenValue").split("\\^")[11]);
				vo.setStrHiddenValue(request.getParameter("hiddenValue"));
				
				bo.getChallanItemDtlPopUp(vo);
				
				//String strItemDetails = MaterialInwardReisterRptHLP.getChallanItemDtlPopUp(vo.getStrChallanItemDtlWs(),request.getParameter("hiddenValue"));
				String strItemDetails = MaterialInwardReisterRptHLP.getChallanItemDtlPopUpOne(vo);
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
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

    
    
    public static void getChallanDtl(MaterialInwardReisterRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			MaterialInwardReisterRptBO bo = null;
			MaterialInwardReisterRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new MaterialInwardReisterRptBO();
				vo = new MaterialInwardReisterRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrStoreId(request.getParameter("StoreId"));
			    vo.setStrPoNumber(request.getParameter("PoNumber"));
				vo.setStrFromDate(request.getParameter("fromDate"));
				vo.setStrToDate(request.getParameter("toDate"));
				
				bo.getChallanDetails(vo);
				
				String strItemDetails = MaterialInwardReisterRptHLP.getChallanDetails(vo.getStrChallanWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
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

    
    public static void showReport(MaterialInwardReisterRptFB materialInwardReisterRptFB_p,HttpServletRequest request, HttpServletResponse response) {
    	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
		
			
			
			
			materialInwardReisterRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			materialInwardReisterRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = materialInwardReisterRptFB_p.getStrHospitalCode();
			String strReportId = materialInwardReisterRptFB_p.getStrReportId();
		
		
/*			String strStartYear = materialInwardReisterRptFB_p.getStrStartFinancialYear();
			String strEndYear = materialInwardReisterRptFB_p.getStrEndFinancialYearTemp();
*/			
			String strSupplierId = materialInwardReisterRptFB_p.getStrSupplierId() == null ? "0" :  materialInwardReisterRptFB_p.getStrSupplierId();
			String strFromDate = materialInwardReisterRptFB_p.getStrFromDate();
			String strToDate = materialInwardReisterRptFB_p.getStrToDate();
			
			String strUserRemarks = materialInwardReisterRptFB_p.getStrUserRemarks();
			
			reportFormat = materialInwardReisterRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(materialInwardReisterRptFB_p.getStrIsFooter()==null)
				materialInwardReisterRptFB_p.setStrIsFooter("0");
			
			if (materialInwardReisterRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Material Inward Register Report";
	
							
				String reportPath = "/mms/reports/dwh_materialInwardRegister_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				if(strSupplierId.equalsIgnoreCase("0"))
				{
					params.put("mode", "2");	
				}
				else
				{
					params.put("mode", "1");
				}
				
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				
				params.put("ponoWithPrefix", "0");
				
				params.put("storeid", "0");	
				params.put("potypeid", materialInwardReisterRptFB_p.getStrPoType());	
				
				params.put("supplierName", "abc");
				params.put("pono", materialInwardReisterRptFB_p.getStrDateType());
				params.put("poDate", "0");
				params.put("poValue", "0");
				params.put("supplierId", strSupplierId);
				
		/*		
			//System.out.println("strPoNoWithPrefix:"+strPoNoWithPrefix);
			//System.out.println("strPoNo:"+strPoNo);
			//System.out.println("strPoDate:"+strPoDate);
			//System.out.println("strPoValue:"+strPoValue);
	
			//System.out.println("strStoreID:"+strStoreID);
	
			//System.out.println("strHospitalCode:"+strHospitalCode);
			
			//System.out.println("materialOutwardRegisterRptFB_p.getStrSupplierName():"+materialInwardReisterRptFB_p.getStrSupplierName());
			//System.out.println("sdf.format(sdf.parse(strFromDate)):"+sdf.format(sdf.parse(strFromDate)));
			//System.out.println("sdf.format(sdf.parse(strToDate)):"+sdf.format(sdf.parse(strToDate)));
				*/
							
				
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
											
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode );
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

	
    
	
}
