package mms.transactions.controller.data;

import hisglobal.ReportUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.controller.fb.IndentPrintTransFB;

public class IndentPrintTransDATA 
{
	public static void showReport(IndentPrintTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "pdf";
		String strReqNo = "";
		String combo[] = null;
		MmsConfigUtil mmsConfig = null;
 //System.out.println("IN a data");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			 mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String[] strChk = request.getParameterValues("chk");
			

			for (int i = 0, stopI = strChk.length; i < stopI; i++) {
				String[] strtemp = strChk[i].replace("@", "#").split("#");
				if (i == 0) {
					strReqNo = strReqNo + strtemp[0];

				} else {
					strReqNo = strReqNo + "," + strtemp[0];

				}
				
				
			}

			combo = request.getParameterValues("combo");

			String[] strTemp = combo[0].split("\\^");
			String[] strTemp1 = combo[2].split("\\^");
			String strStoreId = strTemp[0];
			String strReqTypeId = strTemp1[1];

	 //System.out.println("chk value----1--->"+strChk);
		 //System.out.println("strStoreId----2----->"+strStoreId);
		 //System.out.println("strReqTypeId--3------->"+strReqTypeId);
		 //System.out.println("strReqNo------4--->"+strReqNo);

			// in case of indent for purchase(imported item)
			if (strReqTypeId.equals("15")) {

				String reportPath = "/mms/reports/indent_importedpurchase_mmsrpt.rptdesign";
				String strReportName = "Indent For Purchase(Imported Items)";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

//				ts.displayReport(request, response, reportPath, reportFormat,
//						params);

				// in case of indent for Condemnation
			} else if (strReqTypeId.equals("16")) {

				String reportPath = "/mms/reports/indent_importedpurchase_mmsrpt1.rptdesign";
				String strReportName = "Indent For Condemnation";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

//				ts.displayReport(request, response, reportPath, reportFormat,
//						params);

				// in case of indent for Issue// report modified for postgress 16th July 2013..
			} else if (strReqTypeId.equals("17")) {

				String reportPath = "/mms/reports/indent_issue_mmsrpt.rptdesign";
				String strReportName = "Indent Type : Indent For Issue(Dept)";

		         
				//System.out.println("report_Name"+ strReportName);
				//System.out.println("report_id"+ strReportId);
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("storeId"+ strStoreId);
				//System.out.println("reqTypeId"+ strReqTypeId);
				//System.out.println("reqNo"+ strReqNo);
				////System.out.println("budget_flag"+ mmsConfig.getStrBudgetFlg().equals("1")?true:false);

				
				
				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);
				params.put("budget_flag", mmsConfig.getStrBudgetFlg().equals("1")?true:false);

			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);

				// in case of indent for Annual Purchase// report modified(11) for postgress 16th July 2013..
			} else if (strReqTypeId.equals("11") || strReqTypeId.equals("80")
					|| strReqTypeId.equals("81") || strReqTypeId.equals("83")
					|| strReqTypeId.equals("84") || strReqTypeId.equals("85")|| strReqTypeId.equals("86")|| strReqTypeId.equals("90")) {

				String reportPath = "/mms/reports/indent_annualpurcahse_mmsrpt.rptdesign";

				if (strReqTypeId.equals("11")) {
					String strReportName = "Indent For Local Purchase";
					params.put("report_Name", strReportName);
				} else if (strReqTypeId.equals("80")) {
					String strReportName = "Reserved Item Purchase";
					params.put("report_Name", strReportName);
				} else if (strReqTypeId.equals("81")) {
					String strReportName = "Contigency Purchase";
					params.put("report_Name", strReportName);
				} else if (strReqTypeId.equals("83")) {
					String strReportName = "Purchase Request";
					params.put("report_Name", strReportName);
				} else if (strReqTypeId.equals("84")) {
					String strReportName = "Rate Contract Purchase";
					params.put("report_Name", strReportName);
				} else if (strReqTypeId.equals("85")) {
					String strReportName = "Propriatry Purchase";
					params.put("report_Name", strReportName);
				}
				else if (strReqTypeId.equals("86")) {
					String strReportName = "Routine Purchase";
					params.put("report_Name", strReportName);
				}
				else if (strReqTypeId.equals("90")) {
					String strReportName = "R";
					params.put("report_Name", strReportName);
				}
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);

				// in case of indent for LP(Staff)
			} else if (strReqTypeId.equals("12")) {

				String reportPath = "/mms/reports/indent_lpstaff_mmsrpt.rptdesign";
				String strReportName = "Indent For LP(Staff)";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

//				ts.displayReport(request, response, reportPath, reportFormat,
//						params);

				// in case of indent for LP(Patient)
			} else if (strReqTypeId.equals("13")) {

				
				//System.out.println("report_id"+ strReportId);
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("storeId"+ strStoreId);
				//System.out.println("reqTypeId"+ strReqTypeId);
				//System.out.println("reqNo"+ strReqNo);
				String reportPath = "/mms/reports/indent_lppatient_mmsrpt.rptdesign";
				String strReportName = "Indent For Patient";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);

				// in case of indent for LP(Department)
			} else if (strReqTypeId.equals("14")) {

				String reportPath = "/mms/reports/indent_lpdepartment_mmsrpt.rptdesign";
				String strReportName = "Indent For LP(Department)";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

//				ts.displayReport(request, response, reportPath, reportFormat,
//						params);

				// in case of indent for Contigency
			} else if (strReqTypeId.equals("10")) {

				String reportPath = "/mms/reports/indent_contigency_mmsrpt.rptdesign";
				String strReportName = "Indent For Contigency";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

//				ts.displayReport(request, response, reportPath, reportFormat,
//						params);

				// in case of indent for Return Request
			} else if (strReqTypeId.equals("18")) {

				String reportPath = "/mms/reports/indent_returnrequest_mmsrpt.rptdesign";
				String strReportName = "Indent For Return Request";

				params.put("report_Name", strReportName);
				params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("reqTypeId", strReqTypeId);
				params.put("reqNo", strReqNo);

			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
