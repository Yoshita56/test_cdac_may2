package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.BudgetComparisonDetailRptBO;
import mms.reports.controller.fb.BudgetComparisonDetailRptFB;
import mms.reports.vo.BudgetComparisonDetailRptVO;

public class BudgetComparisonDetailRptDATA {
	
	public static void getInitializedValues(BudgetComparisonDetailRptFB budgetComparisonDetailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		BudgetComparisonDetailRptBO bo = null;
		BudgetComparisonDetailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreValues,strDwhTypeVal;
		
		try {

			bo = new BudgetComparisonDetailRptBO();
			voObj = new BudgetComparisonDetailRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetComparisonDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetComparisonDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","BudgetComparisonDetailRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
			
			voObj.setStrHospitalCode(strHospitalCode);
			
			
			
			bo.getDwhTypeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			strDwhTypeVal =  hisutil.getOptionValue(voObj.getStrDrugWarehouseTypeWs(), voObj.getStrDrugWarehouseTypeId(), "0^Select Value", false);
			budgetComparisonDetailRptFB_p.setStrDrugWarehouseTypeCmb(strDwhTypeVal);

			
			
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(budgetComparisonDetailRptFB_p.getStrSeatId());
			
			//
			
			if(strUserLevel.equals("6")){
			voObj.setStrMode("3");
			voObj.setStrDrugWarehouseTypeId("0");
			}
			else
			{
				voObj.setStrMode("5");
				voObj.setStrDrugWarehouseTypeId("1");
			}
			
			bo.getStoreList(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			hisutil = new HisUtil("DWH", "BudgetComparisonDetailRptDATA");
			
			if(voObj.getStrStoreWs()!=null && voObj.getStrStoreWs().size()>0)
			{
				if(strUserLevel.equals("6")){
					strStoreValues = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				}
				else
					strStoreValues = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);
									
			}
			else
				strStoreValues = "<option value='-1'>Select Value</option>";
			
				
			
			
			budgetComparisonDetailRptFB_p.setStrStoreValues(strStoreValues);
			
						
			hisutil = new HisUtil("MMS Transactions", "BudgetComparisonDetailRptDATA");
			// For setting the financial year 
			budgetComparisonDetailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			budgetComparisonDetailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			budgetComparisonDetailRptFB_p.setStrCurrentDate(strCurrentDate);			
			budgetComparisonDetailRptFB_p.setStrUserLevel(strUserLevel);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.BudgetComparisonDetailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"BudgetComparisonDetailRptDATA->getInitializedValues()", strMsgText);
			budgetComparisonDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	

	
	public static void getStoreList(BudgetComparisonDetailRptFB budgetComparisonDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		BudgetComparisonDetailRptBO bo = null;
		BudgetComparisonDetailRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new BudgetComparisonDetailRptBO();
			voObj = new BudgetComparisonDetailRptVO();
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetComparisonDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetComparisonDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(budgetComparisonDetailRptFB_p.getStrSeatId());
			budgetComparisonDetailRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(budgetComparisonDetailRptFB_p.getStrDrugWarehouseTypeId());
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("3");
				
				}
				else
				{
					voObj.setStrMode("5");
					
				}
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "BudgetComparisonDetailRptDATA");
			
			
			if(voObj.getStrStoreWs()!=null && voObj.getStrStoreWs().size()>0)
			{
				if(strUserLevel.equals("6")){
					strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				}
				else
					strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);	
			}
			else
				strStoreVal = "<option value='0'>Select Value</option>";
			
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BudgetComparisonDetailRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BudgetComparisonDetailRptDATA->getStoreList()", strmsgText);
			budgetComparisonDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
	
	
	public static void showReport(BudgetComparisonDetailRptFB budgetComparisonDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		BudgetComparisonDetailRptBO bo = null;
		BudgetComparisonDetailRptVO voObj = null;
		
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			bo = new BudgetComparisonDetailRptBO();
			voObj = new BudgetComparisonDetailRptVO();
			
			budgetComparisonDetailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			budgetComparisonDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			
			voObj.setStrHospitalCode(budgetComparisonDetailRptFB_p.getStrHospitalCode());
			
			if(budgetComparisonDetailRptFB_p.getStrDrugWarehouseTypeId()==null ||budgetComparisonDetailRptFB_p.getStrDrugWarehouseTypeId().equals(""))
			{
				budgetComparisonDetailRptFB_p.setStrDrugWarehouseTypeId("0");
			}
				
			voObj.setStrDrugWarehouseTypeId(budgetComparisonDetailRptFB_p.getStrDrugWarehouseTypeId());
			
			
			voObj.setStrStoreId(budgetComparisonDetailRptFB_p.getStrStoreId());
			
			
			
			String strHospitalCode = budgetComparisonDetailRptFB_p.getStrHospitalCode();
			String strReportId = budgetComparisonDetailRptFB_p.getStrReportId();
		
		
			String strStartYear = budgetComparisonDetailRptFB_p.getStrStartFinancialYear();
			String strEndYear = budgetComparisonDetailRptFB_p.getStrEndFinancialYearTemp();
			
			
			String strFromDate = budgetComparisonDetailRptFB_p.getStrFromDate();
			String strToDate = budgetComparisonDetailRptFB_p.getStrToDate();
			
			String strUserRemarks = budgetComparisonDetailRptFB_p.getStrUserRemarks();
			
			reportFormat = budgetComparisonDetailRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(budgetComparisonDetailRptFB_p.getStrIsFooter()==null)
				budgetComparisonDetailRptFB_p.setStrIsFooter("0");
			
			if (budgetComparisonDetailRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			bo.getStoreDistrictFlag(voObj);
			
			String strReportName = "Budget Comparison Detail Report";
	
							
				String reportPath = "/mms/reports/dwh_budgetComparisonDetail_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				
				params.put("storeId", budgetComparisonDetailRptFB_p.getStrStoreId());
				params.put("storeName", budgetComparisonDetailRptFB_p.getStrStoreName());
		            
		          //System.out.println("voObj.getStrDrugWarehouseTypeId()"+voObj.getStrDrugWarehouseTypeId());
		        params.put("districtFlg",  voObj.getStrDrugWarehouseTypeId());  //Institute Type/Drug Warehouse Type Id
		          
				params.put("fromYear", strStartYear);
				params.put("toYear", strEndYear);
								
				ts.displayReport(request, response, reportPath, reportFormat,params,budgetComparisonDetailRptFB_p.getStrStoreId());
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
