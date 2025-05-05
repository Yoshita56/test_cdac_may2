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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.CondemnItemDetailRptBO;
import mms.reports.controller.fb.CondemnItemDetailRptFB;
import mms.reports.vo.CondemnItemDetailRptVO;


public class CondemnItemDetailRptDATA {
	
	public static void setInitDtl(CondemnItemDetailRptFB formBean,HttpServletRequest request) {

		CondemnItemDetailRptVO vo=null;
		CondemnItemDetailRptBO bo=null;
		String strItemCategVal="";
		
		HisUtil util = null;
		
		try {
				bo=new 	CondemnItemDetailRptBO();
				vo=new 	CondemnItemDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.getInit(vo);
				if(vo.getStrMsgType().equals("1")){
					
					throw new Exception(vo.getStrMsgString());
				}else{
						util = new HisUtil("mms",
						"CondemnItemDetailRptDATA");
						
						
						strItemCategVal=util.getOptionValue(vo.getItemCategWS(), "0",
								"0^Select Value", false);
						formBean.setStrItemCategVal(strItemCategVal);
						
				}
				
				
				
			} 

		 catch (Exception e) {

				String strmsgText = e.getMessage();
			   HisException eObj = new HisException("IPD", "CondemnItemDetailRptDATA->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			     eObj = null;
		} finally {

		}

	}
	
	public static void showReport(CondemnItemDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strItemCatName = formBean.getStrItemCategoryName();
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Declared Condemned Items";
			
			String reportPath = "/mms/reports/condemnItemList_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("catName", strItemCatName);
				
				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	

}
