package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListBlackListedSupplierRptBO;
import mms.reports.controller.fb.ListBlackListedSupplierRptFB;
import mms.reports.vo.ListBlackListedSupplierRptVO;

public class ListBlackListedSupplierRptDATA {
	
	public static void getItemCatList(ListBlackListedSupplierRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListBlackListedSupplierRptBO bo = null;
		ListBlackListedSupplierRptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		String strHospName="";
		HisUtil util = null;
		try {

			bo = new ListBlackListedSupplierRptBO();
			voObj = new ListBlackListedSupplierRptVO();
			
						
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
	bo.getHospitalName(voObj);
			
			
			if(voObj.getStrMsgType().equals("1")){
				
				throw new Exception(voObj.getStrMsgString());
			}else{
					util = new HisUtil("Issue Detail Report",
					"ListBlackListedSupplierRptDATA");
					
					strHospName= util.getOptionValue(voObj.getStrHospitalWs(),"","", false);
					formBean.setStrHospNameValues(strHospName);
			}

			
			
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListBlackListedSupplierRptDATA");
			
			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value", false);
						
			formBean.setStrItemCatValues(strItemCatVal);
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ListBlackListedSupplierRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListBlackListedSupplierRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void showReport(ListBlackListedSupplierRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			String strItemCategoryName = formBean.getStrItemCategoryName();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Black Listed Supplier";

			
				
				String reportPath = "/mms/reports/listblacklistedsupplier_mmsrptNEW.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("itemCategoryName", strItemCategoryName);
				params.put("hospCode", strHospitalCode);
								
				if(strCatCode.equals("0")){
					params.put("catCode", "null");
				}else{
					params.put("catCode", strCatCode);
				}
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strHospitalCode);
		 	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
