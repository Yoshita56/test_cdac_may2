package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.controller.HisComboOptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.fb.AssetRegisterRptFB;

public class AssetRegisterRptDATA {
	
	public static void setInitDtl(AssetRegisterRptFB formBean,HttpServletRequest request) {
		
		String strItemCatVal="";
		
		try {
				
				HashMap<String, String> _mapProcedureParam1 = new HashMap<String, String>();
				
					_mapProcedureParam1.put("modeval", "3");
					_mapProcedureParam1.put("hosp_code", request.getSession().getAttribute("HOSPITAL_CODE").toString());
					_mapProcedureParam1.put("err", "#1");
					_mapProcedureParam1.put("resultset", "#2");

				//strItemCatVal = HisComboOptions.getOptionsFromProc("pkg_mms_rpt.Rptm_item_category_list", _mapProcedureParam1, "0", "0^All", true);
				formBean.setStrItemCatVal(strItemCatVal);
				
			} 
		 catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("Transport", "AssetRegisterRptData->setInitDtl()", 
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], " +
					"Contact System Administrator! ");
			eObj = null;
		} finally {

		}

	}
	
	public static void showReport(AssetRegisterRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strItemCatId = formBean.getStrItemCatId();
			String strItemCatName = formBean.getStrItemCatName();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStockStatus = formBean.getStrStockStatus();
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String reportPath = "/mms/reports/assetRegister_mmsrpt.rptdesign";
			
			
	
			if(formBean.getStrStockStatus().equals("0")){
				String strReportName = "Asset Register";
				params.put("report_Name", strReportName);
				
			}else if(formBean.getStrStockStatus().equals("10")){
				String strReportName = "Active Asset Register";
				params.put("report_Name", strReportName);
			}else{
				String strReportName = "Dead Asset Register";
				params.put("report_Name", strReportName);
			}
				
				
				params.put("report_id", strReportId);
				
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strItemCatId);
				if(strItemCatName.equals("0")){
					params.put("catName", "0");
				}else{
					params.put("catName", strItemCatName);
				}
					
				if(strStockStatus.equals("0")){
					params.put("stockStatus", "0");
				}else{
					params.put("stockStatus", strStockStatus);
				}
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
