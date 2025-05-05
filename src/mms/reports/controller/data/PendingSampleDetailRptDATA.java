package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.PendingSampleDetailRptBO;
import mms.reports.controller.fb.PendingSampleDetailRptFB;
import mms.reports.vo.PendingSampleDetailRptVO;

public class PendingSampleDetailRptDATA 
{
	/**
	
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(PendingSampleDetailRptFB sampleIssueDetailRptFB_p,HttpServletRequest request_p) 
	{
		/* Declaring Variable */
		PendingSampleDetailRptBO bo = null;
		PendingSampleDetailRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		
		try 
		{
			/* Creating Object */
			
			bo = new PendingSampleDetailRptBO();
			vo = new PendingSampleDetailRptVO();
			hisUtil=new HisUtil("MMSModule", "PendingSampleDetailRptDATA");
		
	        /* Getting Value from Session */ 
			
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request_p.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/* Calling PendingSampleDetailRptBO method  */
			
			bo.initSampleIssueDetail(vo);
			
			sampleIssueDetailRptFB_p.setStrCtDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 
			sampleIssueDetailRptFB_p.setStrLabNameCombo(vo.getStrLabNameCombo());
			
			
		}
		  catch (Exception e) 
		  {
	       
			strmsgText = "PendingSampleDetailRptFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","PendingSampleDetailRptDATA->initSampleSent()", strmsgText);
			sampleIssueDetailRptFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	
	
	public static void showReport(PendingSampleDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		HisUtil hisUtil=null;
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			hisUtil=new HisUtil("MMSModule", "PendingSampleDetailRptDATA");
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strCatCode = "10";
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = hisUtil.getASDate("dd-MMM-yyyy");
			String strToDate = hisUtil.getASDate("dd-MMM-yyyy");
			String strLabNo[]=formBean.getStrLabId().replace("^", "#").split("#");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			String strReportName = "Pending Sample Detail Report";
			
			String reportPath = "/mms/reports/dwh_pendingSampleDetail_mms_rpt.rptdesign";
				
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
