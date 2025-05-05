
package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.validator.Form;

import mms.reports.bo.SampleIssueReceiveToQualityDeptRptBO;
import mms.reports.vo.SampleIssueReceiveToQualityDeptRptVO;
import mms.reports.controller.fb.SampleIssueReceiveToQualityDeptRptFB;

public class SampleIssueReceiveToQualityDeptRptDATA 
{
	/**
	
	 * Method is Used to Populate the Data of DDW Name for 
	 * Sample Issue/Receive To Quality Dept Report 
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(SampleIssueReceiveToQualityDeptRptFB sampleIssueReceiveToQualityDeptRptFB_p,HttpServletRequest request_p) 
	{
		/* Declaring Variable */
		SampleIssueReceiveToQualityDeptRptBO bo = null;
		SampleIssueReceiveToQualityDeptRptVO vo = null;
		String strmsgText = "",storeNameCombo="";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		
		try 
		{
			/* Creating Object */
			
			bo = new SampleIssueReceiveToQualityDeptRptBO();
			vo = new SampleIssueReceiveToQualityDeptRptVO();
			hisUtil=new HisUtil("MMSModule", "SampleIssueReceiveToQualityDeptRptDATA");
		
	        /* Getting Value from Session */ 
			String strUserLevel = request_p.getSession().getAttribute("USER_LEVEL").toString();
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request_p.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/* Calling SampleIssueReceiveToQualityDeptRptBO method  */
			if(strUserLevel.equals("6")){
				vo.setStrMode("4");
			}
			else
				vo.setStrMode("5");
			bo.getDDWList(vo);
			
			sampleIssueReceiveToQualityDeptRptFB_p.setStrCtDate(hisUtil.getASDate("dd-MMM-yyyy"));
			if(vo.getWrsStoreNameCombo()!=null && vo.getWrsStoreNameCombo().size()>0)
			{
				if(strUserLevel.equals("6"))
				{
					storeNameCombo = hisUtil.getOptionValue(vo.getWrsStoreNameCombo(), "0", "0^All", false);
				}
				else
				{
					storeNameCombo = hisUtil.getOptionValue(vo.getWrsStoreNameCombo(), "0", "-1^Select Value", false);	
				}
				
				 
			}else{
				storeNameCombo = "<option value='-1'>DATA N/A</option>";  
			}
			
			sampleIssueReceiveToQualityDeptRptFB_p.setStrStoreNameCombo(storeNameCombo);
			
			
		}
		  catch (Exception e) 
		  {
	       e.printStackTrace();
			strmsgText = "SampleIssueReceiveToQualityDeptRptFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","SampleIssueReceiveToQualityDeptRptDATA->getInitializedValues()", strmsgText);
			sampleIssueReceiveToQualityDeptRptFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	
	
	public static void showReport(SampleIssueReceiveToQualityDeptRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			////System.out.println("formBean.getStrStoreId() ::::::::"+formBean.getStrStoreId());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
		
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			String strReportName = "Sample Issue / Receive to Quality Dept Detail Report";
			
			String reportPath = "/mms/reports/dwh_sampleIssueReceiveToQualityDept_mms_rpt.rptdesign";
				
				/*//System.out.println("report_Name :::"+ strReportName);
				//System.out.println("report_Footer_Visible :::"+ footerVisible);
				//System.out.println("mode :::"+ "1");
				//System.out.println("hospCode :::"+ strHospitalCode);
				//System.out.println("storeId :::"+ formBean.getStrStoreId());
				//System.out.println("storeName :::"+ formBean.getStrStoreName());
				//System.out.println("fromDate :::"+ strFromDate);
				//System.out.println("toDate :::"+ strToDate);
				//System.out.println("user_remarks :::"+ strUserRemarks);*/
				
			
				//params.put("report_id", ");
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("mode", "1");
				params.put("hospCode", strHospitalCode);
				params.put("storeId",formBean.getStrStoreId());
				params.put("storeName", formBean.getStrStoreName());
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("user_remarks", strUserRemarks);
				
					
				ts.displayReport(request, response, reportPath, reportFormat,
						params,formBean.getStrStoreId());
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	

}
