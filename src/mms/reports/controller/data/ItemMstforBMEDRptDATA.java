/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.ItemMstforBMEDRptBO;
import mms.reports.controller.fb.ItemMstforBMEDRptFB;
import mms.reports.controller.hlp.ItemMstforBMEDRptHLP;
import mms.reports.vo.ItemMstforBMEDRptVO;

public class ItemMstforBMEDRptDATA {
	
	
	public static void setInitDtl(ItemMstforBMEDRptFB formBean,HttpServletRequest request) {

		ItemMstforBMEDRptVO vo=null;
		ItemMstforBMEDRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="",strItemVal;
		HisUtil util = null;
		String strStoreId="0";
		try {
				bo=new ItemMstforBMEDRptBO();
				vo=new ItemMstforBMEDRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
//				bo.getInitDtl(vo);
				if(vo.getStrMsgType().equals("1")){
					
					throw new Exception(vo.getStrMsgString());
				}else{
						util = new HisUtil("Issue Detail Report","ItemMstforBMEDRptDATA");
						strCurrentDate=util.getASDate("dd-MMM-yyyy");
						
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
					    Calendar c1 = Calendar.getInstance();	    
					    c1.add(Calendar.DATE,0);   // or  Calendar.DAY_OF_MONTH which is a synonym
					    ////System.out.println("Date + 1 days is : " + sdf.format(c1.getTime()));
						
//					    formBean.setStrCurrentDate(strCurrentDate);
						formBean.setStrCurrentDate(sdf.format(c1.getTime()));
						
						/*if(vo.getStrWS()!=null && vo.getStrWS().size()>0)
						{
							if(vo.getStrWS().next())
							{
								strStoreId = vo.getStrWS().getString(1);
							}
						}*/
						//vo.getStrWS().beforeFirst();
//						strStoreVal=util.getOptionValue(vo.getStrWS(), "0",	"0^Select Value", false);
//						formBean.setStrStoreVal(strStoreVal);
//						
//						vo.setStrStoreId(strStoreId);
						bo.getItemCateg(vo);
						
						if(vo.getStrMsgType().equals("1")){
							throw new Exception(vo.getStrMsgString());
						}else{
						
							util = new HisUtil("Issue Detail Report","ItemMstforBMEDRptDATA");
							strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
							formBean.setStrItemVal(strItemVal);
						
					    	
						}
				}
			} 

		 catch (Exception e) {

				String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "ItemMstforBMEDRptDATA->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {

		}

	}
	
	public static void setItemCategComboDtl(ItemMstforBMEDRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		ItemMstforBMEDRptVO vo=null;
		ItemMstforBMEDRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new ItemMstforBMEDRptBO();
				vo=new ItemMstforBMEDRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
				vo.setStrStoreId(request.getParameter("strId"));
				bo.getItemCateg(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report","ItemMstforBMEDRptDATA");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "ItemMstforBMEDRptDATA.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "ItemMstforBMEDRptDATA->setItemCategComboDtl()", strmsgText);
			    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
			    try
			    {
			    	response.getWriter().print(response1);
			    	eObj=null;
			    }
			    catch(Exception e1)
			    {
			    	
			    }
		 }
	}
	
	/**
	 * Sets the drug name combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void setDrugNameCombo(ItemMstforBMEDRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ItemMstforBMEDRptVO vo = null;
		ItemMstforBMEDRptBO bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strDrugVal = "";

		try {
			bo = new ItemMstforBMEDRptBO();
			vo = new ItemMstforBMEDRptVO();

			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrItemCategNo(request.getParameter("catId"));
			vo.setStrStoreId(request.getParameter("strId"));
			bo.getDrugNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");

				strDrugVal = util.getOptionValue(vo.getStrItemNameComboWS(),"0", "0^All", false);
				response.getWriter().print(strDrugVal);

			}
		} catch (Exception e) {

			strmsgText = "IssueDetailRptData.setDrugNameCombo() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"IssueDetailRptData->setDrugNameCombo()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}
		}
	}
	
	public static void showReport(ItemMstforBMEDRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();		
			
		HisUtil util = null;
		ItemMstforBMEDRptVO vo=null;
		ItemMstforBMEDRptBO bo=null;
		String strReportName ,strCurrentDate;
		String strPrintItemDtl =null;
		try 
		{
			
			util = new HisUtil("Item Master Report","ItemMstforBMEDRptDATA");
			
			bo=new ItemMstforBMEDRptBO();
			vo=new ItemMstforBMEDRptVO();
		
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrItemCategNo(formBean.getStrItemCategNo());	
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
				 
			    bo.getPrintDetails(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					vo.setStrMsgString("LocalPurchaseNewTransDATA.getVerifiedItemDetails() --> "
									+ vo.getStrMsgString());
				}	

					strReportName = "Item Master Report";
					vo.setStrReportName(strReportName);
					System.out.println("------ ItemMstforBMEDRptHLP.getPatientIssueDtls ------[ Issue To Patient ]-----");
					strPrintItemDtl = ItemMstforBMEDRptHLP.getPatientIssueDtls(vo.getWsPrint(),vo);			
										
				if(strPrintItemDtl!= null)
				{	
					formBean.setStrPrintDtls(strPrintItemDtl);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "NewChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}	
            
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void showReport_old(ItemMstforBMEDRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String strReportCriteriaFlag="1";
		String reportPath="";
		Map<String, Object> params = new HashMap<String, Object>();
		HisUtil util = null;
		try {
			util = new HisUtil("Issue Detail Report","ItemMstforBMEDRptDATA");
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();
			reportFormat = formBean.getStrReportFormat();
			String strReportName = "Issue Details",strCurrentDate;
			String strByCurrentAndDate = (formBean.getStrByCurrentAndDate()==null||formBean.getStrByCurrentAndDate().equals(""))?"1":formBean.getStrByCurrentAndDate();
			String dossierflag = formBean.getIsdossier();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			util = new HisUtil("Issue Detail Report","ItemMstforBMEDRptDATA");
			strCurrentDate=util.getASDate("dd-MMM-yyyy");
			
//			//System.out.println("strByCurrentAndDate"+strByCurrentAndDate);
			
			
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			if(formBean.getStrReportType()==null )
			{
				formBean.setStrReportType("1");
			}
			
			if(formBean.getStrWhetherBatchRequiredCheckBox()==null)
			{
				formBean.setStrWhetherBatchRequiredCheckBox("0");
			}
			if(formBean.getStrOnlyIssueDetailRequiredCheckBox()==null)
			{
				formBean.setStrOnlyIssueDetailRequiredCheckBox("0");
			}
			
			
			
//			//System.out.println("strToDate"+strToDate);
			if(strByCurrentAndDate.equals("1"))
			{
				strFromDate	=	strCurrentDate;
				strToDate	=	strCurrentDate;
			}
			if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("1"))
			{
				if(!dossierflag.equals("1"))
					strReportName = "Issue To Patient ";
				else
					strReportName = "Issue To Patient(only Dossier) ";
				reportPath = "/mms/reports/issueto_patient.rptdesign";
				
			}
			else if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("2"))
				{
					if(!dossierflag.equals("1"))	
						strReportName = "Return From Patient ";
					else
						strReportName = "Return from Patient(only Dossier) ";
					reportPath = "/mms/reports/returnfrom_patient.rptdesign";
				}
			else if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("3"))
			{
				 strReportName = "Date waise Sales & Return  From Patient ";
				reportPath = "/mms/reports/netsale_patient.rptdesign";
			}
			System.out.println("reportPath****************"+formBean.getStrConsolidatedOrDetailed()+"*******************"+reportPath);
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);	
			params.put("modeval", "4");
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("catCode", strCatCode);
			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));
			params.put("dossierflag", dossierflag);
			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		
			
			
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	

}


