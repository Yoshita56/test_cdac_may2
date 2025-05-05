package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.EmployeeDetailRptBO;
import mms.reports.controller.fb.EmployeeDetailRptFB;
import mms.reports.vo.EmployeeDetailRptVO;

public class EmployeeDetailRptDATA 
{
	/**
	
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(EmployeeDetailRptFB employeeDetailRptFB_p,HttpServletRequest request_p) 
	{
		/* Declaring Variable */
		EmployeeDetailRptBO bo = null;
		EmployeeDetailRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		MmsConfigUtil mcu = null;
		try 
		{
			/* Creating Object */
			
			bo = new EmployeeDetailRptBO();
			vo = new EmployeeDetailRptVO();
			hisUtil=new HisUtil("MMSModule", "EmployeeDetailRptDATA");
		
	        /* Getting Value from Session */ 
			
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			mcu 	= new MmsConfigUtil(vo.getStrHospitalCode());
			seatId  = request_p.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/*//System.out.println("mcu.getStrCountryCode()"+mcu.getStrCountryCode());
			//System.out.println("mcu.getStrStateCode()"+mcu.getStrStateCode());*/
			
			vo.setStrCountryCode(mcu.getStrCountryCode());
			vo.setStrStateCode(mcu.getStrStateCode());
			
			/* Calling EmployeeDetailRptBO method  */
			
			bo.initDetail(vo);
			
			employeeDetailRptFB_p.setStrCtDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 
			employeeDetailRptFB_p.setStrDistrictNameCombo(vo.getStrDistrictNameCombo());
			employeeDetailRptFB_p.setStrDesignationNameCombo(vo.getStrDesignationNameCombo());
			
		}
		  catch (Exception e) 
		  {
	       
			strmsgText = "EmployeeDetailRptFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailRptDATA->initSampleSent()", strmsgText);
			employeeDetailRptFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	
	
	public static void showReport(EmployeeDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		HisUtil hisUtil=null;
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			hisUtil=new HisUtil("MMSModule", "EmployeeDetailRptDATA");
			
			String strSeatId  = request.getSession().getAttribute("SEATID").toString();
			String strHospitalCode = formBean.getStrHospitalCode();
			String strCatCode = "10";
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = hisUtil.getASDate("dd-MMM-yyyy");
			String strToDate = hisUtil.getASDate("dd-MMM-yyyy");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			String strReportName = "Employee Details";
			
			String reportPath = "/mms/reports/dwh_employeeDtl_rpt.rptdesign";
				
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
				params.put("districtId", formBean.getStrDistrictId());
				params.put("designationId", formBean.getStrDesignationId());
				
				params.put("seatId", strSeatId);
				
				params.put("from_Date", sdf.format(sdf.parse(strFromDate)));
				params.put("to_Date", sdf.format(sdf.parse(strToDate)));
				params.put("tempVar", "0");
				params.put("user_remarks", strUserRemarks);
				
					
				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	

}
