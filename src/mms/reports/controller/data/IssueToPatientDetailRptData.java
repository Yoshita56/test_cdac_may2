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
import mms.reports.bo.IssueToPatientDetailRptBO;
import mms.reports.controller.fb.IssueToPatientDetailRptFB;
import mms.reports.controller.hlp.IssueToPatientDetailRptHLP;
import mms.reports.vo.IssueToPatientDetailRptVO;

public class IssueToPatientDetailRptData {
	
	
	public static void setInitDtl(IssueToPatientDetailRptFB formBean,HttpServletRequest request) {

		IssueToPatientDetailRptVO vo=null;
		IssueToPatientDetailRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="",strItemVal;
		HisUtil util = null;
		String strStoreId="0";
		try {
				bo=new IssueToPatientDetailRptBO();
				vo=new IssueToPatientDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.getInitDtl(vo);
				if(vo.getStrMsgType().equals("1")){
					
					throw new Exception(vo.getStrMsgString());
				}else{
						util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
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
						strStoreVal=util.getOptionValue(vo.getStrWS(), "0",	"0^Select Value", false);
						formBean.setStrStoreVal(strStoreVal);
						
						vo.setStrStoreId(strStoreId);
						bo.getItemCateg(vo);
						
						if(vo.getStrMsgType().equals("1")){
							throw new Exception(vo.getStrMsgString());
						}else{
						
							util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
							strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^ALL", false);
							formBean.setStrItemVal(strItemVal);
						
					    	
						}
						formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						
				}
			} 

		 catch (Exception e) {

				String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "IssueToPatientDetailRptData->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {

		}

	}
	
	public static void setItemCategComboDtl(IssueToPatientDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		IssueToPatientDetailRptVO vo=null;
		IssueToPatientDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new IssueToPatientDetailRptBO();
				vo=new IssueToPatientDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
				vo.setStrStoreId(request.getParameter("strId"));
				bo.getItemCateg(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "IssueToPatientDetailRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueToPatientDetailRptData->setItemCategComboDtl()", strmsgText);
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
	public static void setDrugNameCombo(IssueToPatientDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatientDetailRptVO vo = null;
		IssueToPatientDetailRptBO bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strDrugVal = "";

		try {
			bo = new IssueToPatientDetailRptBO();
			vo = new IssueToPatientDetailRptVO();

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
	
	public static void showReport(IssueToPatientDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";	
		HisUtil util = null;
		IssueToPatientDetailRptVO vo=null;
		IssueToPatientDetailRptBO bo=null;
		String strReportName ,strCurrentDate;
		String strPrintItemDtl =null;
		try 
		{
			
			util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
			
			bo=new IssueToPatientDetailRptBO();
			vo=new IssueToPatientDetailRptVO();
			
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();			
			
			strCurrentDate=util.getASDate("dd-MMM-yyyy");
			
			
			String strByCurrentAndDate = (formBean.getStrByCurrentAndDate()==null||formBean.getStrByCurrentAndDate().equals(""))?"1":formBean.getStrByCurrentAndDate();
		
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			vo.setStrStoreId(request.getParameter("strStoreId"));
			vo.setStrStoreName(request.getParameter("storeName"));
			//System.out.println("===================request.getParameter(\"storeName\")============================"+request.getParameter("storeName"));
		    vo.setStrItemCategNo(request.getParameter("strCategoryId")); 	
		    vo.setStrCategoryName(request.getParameter("strCategoryName")); 
			//System.out.println("===================request.getParameter(\"storeName\")============================"+request.getParameter("strCategoryName"));

		   	vo.setStrFromDate((String) request.getParameter("strFromDate"));
			vo.setStrToDate((String) request.getParameter("strToDate"));
			
			vo.setStrReportId(formBean.getStrReportId());
			vo.setStrItemCategNo(formBean.getStrItemCategNo());			
			vo.setStrUserRemarks(formBean.getStrUserRemarks());
			vo.setStrStoreId(formBean.getStrStoreId());			
			vo.setStrByCurrentAndDate(strByCurrentAndDate);
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrCrNo(formBean.getStrCrNo());
			
			if(formBean.getStrWhetherBatchRequiredCheckBox()==null)
			{
				formBean.setStrWhetherBatchRequiredCheckBox("0");
			}
			if(formBean.getStrOnlyIssueDetailRequiredCheckBox()==null)
			{
				formBean.setStrOnlyIssueDetailRequiredCheckBox("0");
			}
			if(strByCurrentAndDate.equals("1"))
			{
				strFromDate	=	strCurrentDate;
				strToDate	=	strCurrentDate;
				
				vo.setStrFromDate(sdf.format(sdf.parse(strFromDate)));
				vo.setStrToDate(sdf.format(sdf.parse(strFromDate)));
			}
			else
			{
				vo.setStrFromDate(formBean.getStrFromDate());
				vo.setStrToDate(formBean.getStrToDate());
			}
			vo.setStrConsolidatedOrDetailed(formBean.getStrConsolidatedOrDetailed());
			
	 
			    bo.getPrintDetails(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					vo.setStrMsgString("LocalPurchaseNewTransDATA.getVerifiedItemDetails() --> "
									+ vo.getStrMsgString());
				}	
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("1") ---  Issue To Patient
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("2") ---  Return from Patient
				//formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("3") ---  Date waise Sales & Return  From Patient 
				
				/*
				 * Mode - 1 - Issue To Sub Store
				 * Mode - 2 - Issue To Patient
				 * Mode - 3 - PATIENT WAISE RETURN REPORT  Only For Drug
				 * Mode - 4 - DATE WISE NET SALE REPORT ONLY FOR PATIENT AND DRUG
				 * 
				 * */				
								
				if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("1"))
				{	
					
				}
				if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("2"))
				{	
					strReportName = "Issue To Patient";
					vo.setStrReportName(strReportName);
					System.out.println("------ IssueToPatientDetailRptHLP.getPatientIssueDtls ------[ Issue To Patient ]-----");
					strPrintItemDtl = IssueToPatientDetailRptHLP.getPatientIssueDtls(vo.getWsPrint(),vo,formBean);	
				}
				if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("3"))
				{	
					strReportName = "Return from Patient";
					vo.setStrReportName(strReportName);			
					System.out.println("------ IssueToPatientDetailRptHLP.getPatientReturnDtls------[ Return from Patient]-----");
					strPrintItemDtl = IssueToPatientDetailRptHLP.getPatientReturnDtls(vo.getWsPrint(),vo,formBean);	
				}
				if(formBean.getStrConsolidatedOrDetailed().equalsIgnoreCase("4"))
				{	
					strReportName = "Date waise Sales & Return  From Patient ";
					vo.setStrReportName(strReportName);	
					System.out.println("------ IssueToPatientDetailRptHLP.getPatientReturnDtls ------[ Date waise Sales & Return  From Patient ]-----");
					
					strPrintItemDtl = IssueToPatientDetailRptHLP.getPatientReturnDtls(vo.getWsPrint(),vo,formBean);	
				}
				
										
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
	
	public static void showReport_old(IssueToPatientDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String strReportCriteriaFlag="1";
		String reportPath="";
		Map<String, Object> params = new HashMap<String, Object>();
		HisUtil util = null;
		try {
			util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
			
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
			
			util = new HisUtil("Issue Detail Report","IssueToPatientDetailRptData");
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


