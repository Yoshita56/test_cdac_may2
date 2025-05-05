package mms.reports.controller.data;

/*
Developed By: BrahmamVeluguri
Dated :13-Apr-2012

 */


import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.QcStatusforDDWBO;
import mms.reports.controller.fb.QcStatusforDDWFB;
import mms.reports.vo.QcStatusforDDWVO;

public class QcStatusforDDWDATA {

/**
	
	 * Method is Used to Populate the Data of DDW Name for 
	 * QC Status for DDW Report  
	 * @param formBean
	 * @param request
	 */
	public static void getInitializedValues(QcStatusforDDWFB QcStatusforDDWFB_p,HttpServletRequest request_p) 
	{
		/* Declaring Variable */
		QcStatusforDDWBO bo = null;
		QcStatusforDDWVO vo = null;
		String strmsgText = "",storeNameCombo="";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		
		try 
		{
			/* Creating Object */
			
			bo = new QcStatusforDDWBO();
			vo = new QcStatusforDDWVO();
			hisUtil=new HisUtil("MMSModule", "QcStatusforDDWDATA");
		
	        /* Getting Value from Session */ 
			String strUserLevel = request_p.getSession().getAttribute("USER_LEVEL").toString();
			hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request_p.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrItemCategoryNo("10");
			
			/* Calling QcStatusforDDWBO method  */
			if(strUserLevel.equals("6")){
				vo.setStrMode("4");
			}
			else
				vo.setStrMode("5");
			
			bo.getDDWList(vo);
			
			QcStatusforDDWFB_p.setStrCtDate(hisUtil.getASDate("dd-MMM-yyyy"));
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
				 
			}
			else
			{
				storeNameCombo = "<option value='-1'>DATA N/A</option>";  
			}
			
			QcStatusforDDWFB_p.setStrStoreNameCombo(storeNameCombo);
			
			
		}
		  catch (Exception e) 
		  {
	       e.printStackTrace();
			strmsgText = "QcStatusforDDWFBDATA.initSampleSent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","QcStatusforDDWDATA->getInitializedValues()", strmsgText);
			QcStatusforDDWFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

  }
	
	
	public static void showReport(QcStatusforDDWFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			//String strStatusId =formBean.getstrStatusId();
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
			String strReportName = "Sample Issued / Received to Quality Dept Detail Report";
			
			String reportPath = "/mms/reports/QcStatusforDDWrpt.rptdesign";
				/*
				//System.out.println("report_Name :::"+ strReportName);
				//System.out.println("report_Footer_Visible :::"+ footerVisible);
				//System.out.println("mode :::"+ "1");
				//System.out.println("hospCode :::"+ strHospitalCode);
				//System.out.println("storeId :::"+ formBean.getStrStoreId());
				//System.out.println("storeName :::"+ formBean.getStrStoreName());
				//System.out.println("fromDate :::"+ strFromDate);
				//System.out.println("toDate :::"+ strToDate);
				//System.out.println("user_remarks :::"+ strUserRemarks);
				////System.out.println("Status ::"+ strStatusId );
				*/
			
				//params.put("report_id", ");
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("mode", formBean.getStrStatusId());
				params.put("hospCode", strHospitalCode);
				params.put("storeId",formBean.getStrStoreId());
				params.put("storeName", formBean.getStrStoreName());
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				params.put("user_remarks", strUserRemarks);
				////System.out.println("StatusBr ::"+ formBean.getStrStatusId());
				
					
				ts.displayReport(request, response, reportPath, reportFormat,
						params,formBean.getStrStoreId());
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
}
