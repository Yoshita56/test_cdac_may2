package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.reports.bo.ListOfConsigneeRptBO;
import mms.reports.controller.fb.ListOfConsigneeRptFB;
import mms.reports.controller.hlp.ListOfConsigneeRptHLP;
import mms.reports.vo.ListOfConsigneeRptVO;

public class ListOfConsigneeRptDATA 
{
	
	public static void getInitializedValues(ListOfConsigneeRptFB listOfConsigneeRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		ListOfConsigneeRptBO bo = null;
		ListOfConsigneeRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new ListOfConsigneeRptBO();
			voObj = new ListOfConsigneeRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			listOfConsigneeRptFB_p.setStrHospitalCode(strHospitalCode);
			listOfConsigneeRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","ListOfConsigneeRptDATA");
			
					
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
			
			voObj.setStrSeatId(listOfConsigneeRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			if(strUserLevel.equals("6"))
			{
				voObj.setStrMode("12");
			}
			else
				voObj.setStrMode("1");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
//			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
//			ListOfConsigneeRptFB_p.setStrStoreValues(strStoreVal);
			if(strUserLevel.equals("6"))
			{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			}
			else
			{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "-1^Select Value", false);	
			}
			
			
			listOfConsigneeRptFB_p.setStrManufactureCombo(strSupplierVal);
			
						
			hisutil = new HisUtil("MMS Transactions", "ListOfConsigneeRptDATA");
			// For setting the financial year 
			listOfConsigneeRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			listOfConsigneeRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			listOfConsigneeRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.ListOfConsigneeRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"ListOfConsigneeRptDATA->getInitializedValues()", strMsgText);
			listOfConsigneeRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	
	
	 public static void getPrintScreenTwo(ListOfConsigneeRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

				ListOfConsigneeRptBO bo = null;
				ListOfConsigneeRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new ListOfConsigneeRptBO();
					vo = new ListOfConsigneeRptVO();
																	
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrOrderFromDate(request.getParameter("fromDate"));
					vo.setStrOrderToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("supplierName"));
														
					bo.getScreenTwo(vo);
					
					//String strItemDetails = ListOfConsigneeRptHLP.getPrintScreenTwo(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					//response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.ListOfConsigneeRptDATA.getPrintScreenTwo --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"ListOfConsigneeRptDATA->getPrintScreenTwo()", strmsgText);
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
	
	
	    public static void getConsigneeDtlPrintPopUp(ListOfConsigneeRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				ListOfConsigneeRptBO bo = null;
				ListOfConsigneeRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				String strSecCheckHidValue,strPONo;
				HisUtil hisutil=null;
				
				
				try 
				{
					bo = new ListOfConsigneeRptBO();
					vo = new ListOfConsigneeRptVO();
					hisutil = new HisUtil("DWH","ListOfConsigneeRptDATA");										
					
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					/*vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrOrderFromDate(request.getParameter("fromDate"));
					vo.setStrOrderToDate(request.getParameter("toDate"));*/
					vo.setStrSupplierName(request.getParameter("strSupplierName"));
					
					strSecCheckHidValue=request.getParameter("strSecCheckHidValue");
					String[] tmp= strSecCheckHidValue.replace("^", "#").split("#");
					
					vo.setStrPoNumber(tmp[0]);
					vo.setStrStoreId(tmp[7]);
					vo.setStrSecCheckHidValue(strSecCheckHidValue);
					String strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
					vo.setStrCurrentDate(strCurrentDate);	
					
					bo.getStoreList(vo);
					String strStoreIdTmp="",strStoreNameTmp="";
					if(vo.getWrsStoreNameCombo() !=null && vo.getWrsStoreNameCombo().size()>0){
						while(vo.getWrsStoreNameCombo().next()){
							strStoreIdTmp+=vo.getWrsStoreNameCombo().getString(1)+"^";
							strStoreNameTmp+=vo.getWrsStoreNameCombo().getString(2)+"^";
						}
					}
					
					vo.setStrStoreIdTmp(strStoreIdTmp);
					vo.setStrStoreNameTmp(strStoreNameTmp);
					
										
					bo.getPOConsigneeDtl(vo);
					int i=0;
					String strPoListOfConsignee="";
					 /* Value Pass in strPoListOfConsigneeDtl[p]
					1.  PO_NO			// award No.
					2.  ITEM_BRAND_ID
					3.  ITEM_NAME      //item code
					4.  ITEM_SPECIFICATION  //pdt specification
					5.  ORDER_QTY
					6.  UNIT
					7.  DELIVERY_LOCATION
					8.  Order Qty in Base
					9.  Base Unit
					10. Accepted Qty
				 */
					
					if(vo.getWrsPoListOfConsignee() !=null && vo.getWrsPoListOfConsignee().size()>0)
					{
						while(vo.getWrsPoListOfConsignee().next())
						{
							strPoListOfConsignee+=vo.getWrsPoListOfConsignee().getString(1)+"^"+
													vo.getWrsPoListOfConsignee().getString(2)+"^"+
													vo.getWrsPoListOfConsignee().getString(3)+"^"+
													vo.getWrsPoListOfConsignee().getString(4)+"^"+
													vo.getWrsPoListOfConsignee().getString(5)+"^"+
													vo.getWrsPoListOfConsignee().getString(6)+"^"+
													vo.getWrsPoListOfConsignee().getString(7)+"^"+
													vo.getWrsPoListOfConsignee().getString(8)+"^"+
													vo.getWrsPoListOfConsignee().getString(9)+"^"+
													vo.getWrsPoListOfConsignee().getString(10);
							strPoListOfConsignee+="@";
						}
					}
					vo.setStrPoListOfConsignee(strPoListOfConsignee);
					String strPoConsigneeDtl = ListOfConsigneeRptHLP.getConsigneeDtlPopUpForPrint(vo);
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strPoConsigneeDtl);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.ListOfConsigneeRptDATA.getConsigneeDtlPrint --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"ListOfConsigneeRptDATA->getConsigneeDtlPrint()", strmsgText);
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
	 
	 
	 public static void getConsigneeDtlGenratePDF(ListOfConsigneeRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				ListOfConsigneeRptBO bo = null;
				ListOfConsigneeRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				String strSecCheckHidValue,strPONo;
				HisUtil hisutil=null;
				
				
				try 
				{
					bo = new ListOfConsigneeRptBO();
					vo = new ListOfConsigneeRptVO();
					hisutil = new HisUtil("DWH","ListOfConsigneeRptDATA");										
					
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					/*vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrOrderFromDate(request.getParameter("fromDate"));
					vo.setStrOrderToDate(request.getParameter("toDate"));*/
					vo.setStrSupplierName(request.getParameter("strSupplierName"));
					
					strSecCheckHidValue=request.getParameter("strSecCheckHidValue");
					String[] tmp= strSecCheckHidValue.replace("^", "#").split("#");
					
					vo.setStrPoNumber(tmp[0]);
					vo.setStrStoreId(tmp[7]);
					vo.setStrSecCheckHidValue(strSecCheckHidValue);
					String strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
					vo.setStrCurrentDate(strCurrentDate);	
					
					bo.getStoreList(vo);
					String strStoreIdTmp="",strStoreNameTmp="";
					if(vo.getWrsStoreNameCombo() !=null && vo.getWrsStoreNameCombo().size()>0){
						while(vo.getWrsStoreNameCombo().next()){
							strStoreIdTmp+=vo.getWrsStoreNameCombo().getString(1)+"^";
							strStoreNameTmp+=vo.getWrsStoreNameCombo().getString(2)+"^";
						}
					}
					
					vo.setStrStoreIdTmp(strStoreIdTmp);
					vo.setStrStoreNameTmp(strStoreNameTmp);
					
										
					bo.getPOConsigneeDtl(vo);
			//		int i=0;
					String strPoListOfConsignee="";
					if(vo.getWrsPoListOfConsignee() !=null && vo.getWrsPoListOfConsignee().size()>0)
					{
						while(vo.getWrsPoListOfConsignee().next())
						{
							strPoListOfConsignee+=vo.getWrsPoListOfConsignee().getString(1)+"^"+
													vo.getWrsPoListOfConsignee().getString(2)+"^"+
													vo.getWrsPoListOfConsignee().getString(3)+"^"+
													vo.getWrsPoListOfConsignee().getString(4)+"^"+
													vo.getWrsPoListOfConsignee().getString(5)+"^"+
													vo.getWrsPoListOfConsignee().getString(6)+"^"+
													vo.getWrsPoListOfConsignee().getString(7)+"^"+
													vo.getWrsPoListOfConsignee().getString(8)+"^"+
													vo.getWrsPoListOfConsignee().getString(9);
							strPoListOfConsignee+="@";
						}
					}
					vo.setStrPoListOfConsignee(strPoListOfConsignee);
					String strPoConsigneeDtl = ListOfConsigneeRptHLP.getConsigneeDtlPopUpForPrint(vo);
					
					//response.setHeader("Cache-Control", "no-cache");
					
					response.setContentType("application/pdf");
					response.setHeader("Content-Disposition",
						"attachment; filename=Test.pdf");

					////System.out.println("content : "+content);

					//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strPoConsigneeDtl);
					
										
				//	response.getWriter().print(His);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.ListOfConsigneeRptDATA.getConsigneeDtlPrint --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"ListOfConsigneeRptDATA->getConsigneeDtlPrint()", strmsgText);
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
	 public static void getSupplierPODtlPopUp(ListOfConsigneeRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				ListOfConsigneeRptBO bo = null;
				ListOfConsigneeRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new ListOfConsigneeRptBO();
					vo = new ListOfConsigneeRptVO();
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
					vo.setStrOrderFromDate(request.getParameter("fromDate"));
					vo.setStrOrderToDate(request.getParameter("toDate"));
				
					//vo.setStrHiddenValue(request.getParameter("hiddenValue"));
					
					bo.getSupplierPODtlPopUp(vo);
					
					//String strItemDetails = ListOfConsigneeRptHLP.getSupplierPODtlPopUp(vo.getStrSupplierPODtlWs(),vo.getStrHiddenValue());
					//String strItemDetails = ListOfConsigneeRptHLP.getSupplierPODtlPopUpOne(vo);
					
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


	
	
    public static void getPODtl(ListOfConsigneeRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

			ListOfConsigneeRptBO bo = null;
			ListOfConsigneeRptVO vo = null;
			MmsConfigUtil mcu = null;
			HisUtil util = null;
			String strmsgText = null;
			
			try 
			{
				bo = new ListOfConsigneeRptBO();
				vo = new ListOfConsigneeRptVO();
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																
			
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrSupplierId(request.getParameter("supplierId"));
				vo.setStrSupplierName(request.getParameter("suppName"));
				vo.setStrOrderFromDate(request.getParameter("fromDate"));
				vo.setStrOrderToDate(request.getParameter("toDate"));
								
				bo.getPODetails(vo);
				String strItemDetails = ListOfConsigneeRptHLP.getPoDtlOne(vo);
				//String strItemDetails = ListOfConsigneeRptHLP.getPODetails(vo.getStrPOWs());
				
				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemDetails);	
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
					
			} 
			catch (Exception e) 
			{
				strmsgText = "mms.report.ListOfConsigneeRptDATA.getPODtl() --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"ListOfConsigneeRptDATA->getPODtl()", strmsgText);
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

   
    
    
    
    public static void showReport(ListOfConsigneeRptFB ListOfConsigneeRptFB_p,HttpServletRequest request, HttpServletResponse response) {
    	
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
			
			
			
			ListOfConsigneeRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ListOfConsigneeRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = ListOfConsigneeRptFB_p.getStrHospitalCode();
			String strReportId = ListOfConsigneeRptFB_p.getStrReportId();
		
		
/*			String strStartYear = ListOfConsigneeRptFB_p.getStrStartFinancialYear();
			String strEndYear = ListOfConsigneeRptFB_p.getStrEndFinancialYearTemp();
*/			
			
			String strFromDate = ListOfConsigneeRptFB_p.getStrOrderFromDate();
			String strToDate = ListOfConsigneeRptFB_p.getStrOrderToDate();
			
			String strUserRemarks = ListOfConsigneeRptFB_p.getStrUserRemarks();
			
			reportFormat = ListOfConsigneeRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(ListOfConsigneeRptFB_p.getStrIsFooter()==null)
				ListOfConsigneeRptFB_p.setStrIsFooter("0");
			
			if (ListOfConsigneeRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
		
			
			String strReportName = "Supplier Performance Detail Report Report";
	
							
				String reportPath = "/mms/reports/dwh_materialInwardRegister_rpt.rptdesign";
			
//			String reportPath = "/mms/reports/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.rptdesign";
				
				
				params.put("mode", "1");
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				
				params.put("ponoWithPrefix", strPoNoWithPrefix);
				
				params.put("storeid", strStoreID);	
				
				
				params.put("supplierName", ListOfConsigneeRptFB_p.getStrSupplierName());
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
			
			//System.out.println("materialOutwardRegisterRptFB_p.getStrSupplierName():"+ListOfConsigneeRptFB_p.getStrSupplierName());
			//System.out.println("sdf.format(sdf.parse(strFromDate)):"+sdf.format(sdf.parse(strFromDate)));
			//System.out.println("sdf.format(sdf.parse(strToDate)):"+sdf.format(sdf.parse(strToDate)));
				*/
							
				
				params.put("hospCode", strHospitalCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
											
											
				ts.displayReport(request, response, reportPath, reportFormat,params,strStoreID);
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

	
    
	
}
