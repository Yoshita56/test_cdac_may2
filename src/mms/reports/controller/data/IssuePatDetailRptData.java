/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.IssuePatDetailRptBO;
import mms.reports.controller.fb.IssuePatDetailRptFB;
import mms.reports.vo.IssuePatDetailRptVO;

public class IssuePatDetailRptData {
	
	
	public static void setInitDtl(IssuePatDetailRptFB formBean,HttpServletRequest request) {

		IssuePatDetailRptVO vo=null;
		IssuePatDetailRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="",strItemVal;
		HisUtil util = null;
		String strStoreId="0";
		try {
				bo=new IssuePatDetailRptBO();
				vo=new IssuePatDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.getInitDtl(vo);
				if(vo.getStrMsgType().equals("1")){
					
					throw new Exception(vo.getStrMsgString());
				}else{
						util = new HisUtil("Issue Detail Report","IssuePatDetailRptData");
						strCurrentDate=util.getASDate("dd-MMM-yyyy");
						formBean.setStrCurrentDate(strCurrentDate);
						
						if(vo.getStrWS()!=null && vo.getStrWS().size()>0)
						{
							if(vo.getStrWS().next())
							{
								strStoreId = vo.getStrWS().getString(1);
							}
						}
						vo.getStrWS().beforeFirst();
						strStoreVal=util.getOptionValue(vo.getStrWS(), strStoreId,	"0^Select Value", false);
						formBean.setStrStoreVal(strStoreVal);
						
						vo.setStrStoreId(strStoreId);
						bo.getItemCateg(vo);
						
						if(vo.getStrMsgType().equals("1")){
							throw new Exception(vo.getStrMsgString());
						}else{
						
							util = new HisUtil("Issue Detail Report","IssuePatDetailRptData");
							strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
							formBean.setStrItemVal(strItemVal);
						
					    	
						}
				}
			} 

		 catch (Exception e) {

				String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "IssuePatDetailRptData->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {

		}

	}
	
	public static void setItemCategComboDtl(IssuePatDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		IssuePatDetailRptVO vo=null;
		IssuePatDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new IssuePatDetailRptBO();
				vo=new IssuePatDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
				vo.setStrStoreId(request.getParameter("strId"));
				bo.getItemCateg(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report","IssuePatDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "IssuePatDetailRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssuePatDetailRptData->setItemCategComboDtl()", strmsgText);
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
	
	public static void showReport(IssuePatDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String strReportCriteriaFlag="1";
		String reportPath="";
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();
			String strReportName = "Issue Details";
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
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
			
			
			if(formBean.getStrReportType().equals("1") ) // For Dept/Store
			{
				params.put("mode", "1");				
			
				if(formBean.getStrConsolidatedOrDetailed().equals("1"))	// consolidated
				{
				 strReportName = "Issue Summary Detail (Department/Store)";
					 if(formBean.getStrWhetherBatchRequiredCheckBox().equals("1"))
						{
							params.put("batchNoFlag", true);
						}
					 else
					 {
						params.put("batchNoFlag", false);
					 }
					 strReportCriteriaFlag = "1";
				 
				  reportPath = "/mms/reports/issueDetail_mmsrpt.rptdesign"; // FIRST REPORT 
				 
				}
				else if(formBean.getStrConsolidatedOrDetailed().equals("2"))	// Detailed
				{
					 strReportName = "Issue Detail (Department/Store)";
					 
					 if(formBean.getStrOnlyIssueDetailRequiredCheckBox().equals("1"))
					 {
						 reportPath = "/mms/reports/issueDetail_mmsrpt1.rptdesign";// SECOND REPORT 
						 strReportCriteriaFlag = "2";
						
					 }
					 else					//•	Report Type = “Department/Store” Detail Option is checked ,
						 					//  Only Issue Detail (Without Drug) is not checked
	 
					 {
						 reportPath = "/mms/reports/issueDetail_mmsrpt2.rptdesign";// THIRD REPORT PENDING
						 strReportCriteriaFlag = "3";
					 }
				}
			}
			
			else if(formBean.getStrReportType().equals("2") )	//For Employee
			{
				params.put("mode", "3");	
				 
				if( formBean.getStrConsolidatedOrDetailed().equals("1"))	
				{
					strReportName = "Issue Summary Detail (Employee)";
					
					 if(formBean.getStrWhetherBatchRequiredCheckBox().equals("1"))
						{
							params.put("batchNoFlag", true);
						}
					 else
					 {
						params.put("batchNoFlag", false);
					 }
					 strReportCriteriaFlag = "1";
				 
				  reportPath = "/mms/reports/issueDetail_mmsrpt4.rptdesign"; // FOURTH REPORT 
					
				}
				else if(formBean.getStrConsolidatedOrDetailed().equals("2"))
				{
					 strReportName = "Issue Detail (Employee)";
					 
					 if(formBean.getStrOnlyIssueDetailRequiredCheckBox().equals("1"))
					 {
					  strReportCriteriaFlag = "2";
					 
					  reportPath = "/mms/reports/issueDetail_mmsrpt5.rptdesign"; // FIFTH REPORT 
					 }
					 else
					 {
						 strReportCriteriaFlag = "3";
						 
						  reportPath = "/mms/reports/issueDetail_mmsrpt6.rptdesign"; // SIXTH REPORT PENDING
					 }	 
				}	
				 
			}	
			
			else if(formBean.getStrReportType().equals("3") )	// For Patient
			{
				params.put("mode", "2");	
				 
				
				if(formBean.getStrConsolidatedOrDetailed().equals("1"))
				{
					 strReportName = "Issue Summary Detail (Patient)";	
					 
					 if(formBean.getStrWhetherBatchRequiredCheckBox().equals("1"))
						{
							params.put("batchNoFlag", true);
						}
					 else
					 {
						params.put("batchNoFlag", false);
					 }
					
				 
					 reportPath = "/mms/reports/issuePatDetail_mmsrpt7.rptdesign"; // SEVENTH REPORT 
					 strReportCriteriaFlag = "1";
				}
				else if(formBean.getStrConsolidatedOrDetailed().equals("2"))
				{
					 strReportName = "Issue Detail (Patient)";
					 
					 if(formBean.getStrOnlyIssueDetailRequiredCheckBox().equals("1"))
					 {
					  strReportCriteriaFlag = "2";
					 
					  reportPath = "/mms/reports/issuePatDetail_mmsrpt8.rptdesign"; // EIGHTH REPORT 
					 }
					 else
					 {
						 strReportCriteriaFlag = "3";
						 
						  reportPath = "/mms/reports/issuePatDetail_mmsrpt9.rptdesign"; // NINTH REPORT PENDING
					 }	 
				}				 
			}/*			
			else
			{
				strReportName = "Issue Details";	
			}*/
			 
					
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("catCode", strCatCode);
			params.put("storeName", formBean.getStrStoreName());

			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));
			params.put("reportCriteriaFlag", strReportCriteriaFlag);
			
			// For Store
			if(formBean.getStrReportType().equals("1")){
				
				 reportPath = "/mms/reports/issueDetail_mmsrpt.rptdesign";
								
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			// For Employee	
			}else if(formBean.getStrReportType().equals("2")){
				
				 reportPath = "/mms/reports/issueDetail_mmsrpt2.rptdesign";
												
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			// For Patient
			}else if(formBean.getStrReportType().equals("3")){
				
				 reportPath = "/mms/reports/issueDetail_mmsrpt1.rptdesign";
								
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			}
		
			
			
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}


