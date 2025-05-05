
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

import mms.reports.bo.ReturnDetailRptBO;
import mms.reports.controller.fb.ReturnDetailRptFB;
import mms.reports.vo.ReturnDetailRptVO;

public class ReturnDetailRptDATA {
	public static void setInitDtl(ReturnDetailRptFB formBean,HttpServletRequest request) {

		ReturnDetailRptVO vo=null;
		ReturnDetailRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="";
		String strHospName;
		HisUtil util = null;
		
		
		try {
				bo=new ReturnDetailRptBO();
				vo=new ReturnDetailRptVO();
				String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrItemCatId("10");
				
				
				if(strUserLevel.equals("6")){
					vo.setStrMode("6");
				}
				else
					vo.setStrMode("5");

			

				

				//bo.getInitDtl(vo);
				bo.getHospitalName(vo);
				if(vo.getStrMsgType().equals("1")){
					
					throw new Exception(vo.getStrMsgString());
				}else{
						util = new HisUtil("Issue Detail Report",
						"IssueDetailRptData");
						strCurrentDate=util.getASDate("dd-MMM-yyyy");
						formBean.setStrCurrentDate(strCurrentDate);
						
						strHospName= util.getOptionValue(vo.getStrHospitalWs(),"0","0^Select Value", false);
						formBean.setStrHospNameValues(strHospName);
				}
				
				
				
			} 

		 catch (Exception e) {

				String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "ReturnDetailRptDATA->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {

		}

	}
	
	public static void setItemCategComboDtl(ReturnDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		ReturnDetailRptVO vo=null;
		ReturnDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try {
				bo=new ReturnDetailRptBO();
				vo=new ReturnDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(request.getParameter("strId"));
				bo.getItemCateg(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report",
					"IssueDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0",
							"0^Select Value", false);
					response.getWriter().print(strItemVal);
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "ReturnDetailRptDATA.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "ReturnDetailRptDATA->setItemCategComboDtl()", strmsgText);
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
	
	
	public static void setStoreComboDtl(ReturnDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		ReturnDetailRptVO vo=null;
		ReturnDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strStoreVal="";
		
		try {
				bo=new ReturnDetailRptBO();
				vo=new ReturnDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrItemCatId("10");//vo.setStrStoreId(request.getParameter("strId"));
				bo.setStoreCombo(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}else{
				
					util = new HisUtil("Issue Detail Report",
					"IssueDetailRptData");
					
					strStoreVal=util.getOptionValue(vo.getStrStoreWs(), "0",
							"0^Select Value", false);
					formBean.setStrStoreVal(strStoreVal);
					response.getWriter().print(strStoreVal);
			    	
				}
	
			} 

		 catch (Exception e) {

				strmsgText = "ReturnDetailRptDATA.setItemCategComboDtl() --> "
					+ e.getMessage();
				HisException eObj = new HisException("IPD", "ReturnDetailRptDATA->setItemCategComboDtl()", strmsgText);
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
	
	
	
	
	
	public static void showReport(ReturnDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreVal();
			
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Return Details";

			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("catCode", strCatCode);
			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));
			
			
			if(formBean.getIssueChkDetail().equals("1")){
				
				String reportPath = "/mms/reports/returnDetail_mmsrptNEW.rptdesign";
				//System.out.println("reportPath"+reportPath);
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
				
			}else if(formBean.getIssueChkDetail().equals("2")){
				
				String reportPath = "/mms/reports/returnDetail_mmsrpt2NEW.rptdesign";
				//System.out.println("reportPath"+reportPath);
					
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
				
			}else if(formBean.getIssueChkDetail().equals("3")){
				
				String reportPath = "/mms/reports/returnDetail_mmsrpt1NEW.rptdesign";
				
					
				//System.out.println("reportPath"+reportPath);
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
			}
		
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
