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

import mms.reports.bo.ConsumptionDetailRptBO;
import mms.reports.controller.fb.ConsumptionDetailRptFB;
import mms.reports.vo.ConsumptionDetailRptVO;

public class ConsumptionDetailRptDATA {
	

	

public static void setInitDtl(ConsumptionDetailRptFB formBean,HttpServletRequest request) {

	ConsumptionDetailRptVO vo=null;
	ConsumptionDetailRptBO bo=null;
	String strStoreVal="";
	HisUtil util = null;
	String strCurrentDate="";
	String strHospName="";

	try {
			bo=new 	ConsumptionDetailRptBO();
			vo=new 	ConsumptionDetailRptVO();
			util = new HisUtil("mms",
			"ConsumptionDetailRptData");
			String ctDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.getHospitalName(vo);
			strHospName= util.getOptionValue(vo.getStrHospitalWs(),"0","0^Select Value", false);
			formBean.setStrHospNameValues(strHospName);
			bo.getInit(vo);
			if(vo.getStrMsgType().equals("1")){
				
				throw new Exception(vo.getStrMsgString());
			}else{	
					util = new HisUtil("mms",
					"ConsumptionDetailRptDATA");
					strStoreVal=util.getOptionValue(vo.getStrWS(), "0",
					"0^Select Value", true);
					strCurrentDate=util.getASDate("dd-MMM-yyyy");
					
					formBean.setStrCurrentDate(strCurrentDate);
					formBean.setStrStoreVal(strStoreVal);
					
				}
		} catch(Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
		   HisException eObj = new HisException("mms", "ConsumptionDetailRptDATA->setInitDtl()", strmsgText);
		   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {
	
		}

 }

public static void setItemCategComboDtl(ConsumptionDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

	ConsumptionDetailRptVO vo=null;
	ConsumptionDetailRptBO bo=null;
	String strmsgText="";
	HisUtil util = null;
	String strItemVal="";
	
	try {
			bo=new ConsumptionDetailRptBO();
			vo=new ConsumptionDetailRptVO();
			
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(request.getParameter("strId"));
			bo.getItemCateg(vo);
			if(vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}else{
			
				util = new HisUtil("mms",
				"ConsumptionDetailRptData");
				strItemVal=util.getOptionValue(vo.getItemCategWS(), "0",
						"0^Select Value", true);
				response.getWriter().print(strItemVal);
		    	
			}

		} 

	 catch (Exception e) {

			strmsgText = "ConsumptionDetailRptData.setItemCategComboDtl() --> "
				+ e.getMessage();
			HisException eObj = new HisException("IPD", "ConsumptionDetailRptData->setItemCategComboDtl()", strmsgText);
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

	public static void showReport(ConsumptionDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil(); 
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
			String strStoreId = formBean.getStrStoreId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strFromYear = formBean.getStrFromYear();
			String strToYear = formBean.getStrToYear();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Consumption Details";
	
			if(formBean.getDateYearWise().equals("1")){
				
				String reportPath = "/mms/reports/consumptionDetails_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("report_Header", strReportName);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("fromYear", "0");
				params.put("toYear", "0");
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
				
			}else if(formBean.getDateYearWise().equals("2")){
				
				String reportPath = "/mms/reports/consumptionDetails_mmsrpt1.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("report_Header", strReportName);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("fromDate", "null");
				params.put("toDate", "null");
				params.put("fromYear", strFromYear);
				params.put("toYear", strToYear);
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			}
		
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
