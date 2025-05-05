
package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.SampleIssueDetailRptBO;
import mms.reports.controller.fb.SampleIssueDetailRptFB;
import mms.reports.vo.SampleIssueDetailRptVO;

public class SampleIssueDetailRptDATA 
{
	/**
	
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(SampleIssueDetailRptFB sampleIssueDetailRptFB_p,HttpServletRequest request_p) 
	{
		/* Declaring Variable */
		SampleIssueDetailRptBO bo = null;
		SampleIssueDetailRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		
		try 
		{
			/* Creating Object */
			
			bo = new SampleIssueDetailRptBO();
			vo = new SampleIssueDetailRptVO();
			hisUtil=new HisUtil("MMSModule", "SampleIssueDetailRptDATA");
		
	        /* Getting Value from Session */ 
			
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request_p.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/* Calling SampleIssueDetailRptBO method  */
			
			bo.initSampleIssueDetail(vo);
			
			sampleIssueDetailRptFB_p.setStrCtDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 
			sampleIssueDetailRptFB_p.setStrLabNameCombo(vo.getStrLabNameCombo());
			
			
		}
		  catch (Exception e) 
		  {
	       
			strmsgText = "SampleIssueDetailRptFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","SampleIssueDetailRptDATA->initSampleSent()", strmsgText);
			sampleIssueDetailRptFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	
	
	public static void showReport(SampleIssueDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strCatCode = "10";
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strLabNo[]=formBean.getStrLabId().replace("^", "#").split("#");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
		
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			String strReportName = "( A Government of Rajasthan Undertaking )";
			
			String reportPath = "/mms/reports/dwh_sampleIssueDetail_mms_rpt.rptdesign";
				
				/* //System.out.println("report_Name :::"+ strReportName);
				//System.out.println("report_Footer_Visible :::"+ footerVisible);
				//System.out.println("mode :::"+ "1");
				//System.out.println("hospCode :::"+ strHospitalCode);
				//System.out.println("catCode :::"+ strCatCode);
				//System.out.println("LabNo :::"+ strLabNo[0]);
				//System.out.println("fromDate :::"+ strFromDate);
				//System.out.println("toDate :::"+ strToDate);
				//System.out.println("user_remarks :::"+ strUserRemarks);*/
				
			
				//params.put("report_id", ");
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("mode", "1");
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", "0");
				params.put("labNo", strLabNo[0]);
				params.put("labName", formBean.getStrLabName());
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("user_remarks", strUserRemarks);
				
					
				ts.displayReport(request, response, reportPath, reportFormat,
						params,"0");
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	

}
