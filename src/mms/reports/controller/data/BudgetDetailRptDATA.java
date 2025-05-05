package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.BudgetDetailRptBO;
import mms.reports.controller.fb.BudgetDetailRptFB;
import mms.reports.vo.BudgetDetailRptVO;

public class BudgetDetailRptDATA {
	
	public static void getInitializedValues(BudgetDetailRptFB budgetDetailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		BudgetDetailRptBO bo = null;
		BudgetDetailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		String strHospitalCode,strStoreVal,strDwhTypeVal;
		
		try {

			bo = new BudgetDetailRptBO();
			voObj = new BudgetDetailRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","BudgetDetailRptDATA");
			
					
			
			voObj.setStrSeatId(budgetDetailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("4");
			}
			else
				voObj.setStrMode("5");
			
			bo.getInitializedValues(voObj);
			BudgetDetailRptDATA.getFinancialYearCombo(budgetDetailRptFB_p, request);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			strDwhTypeVal =  hisutil.getOptionValue(voObj.getStrDrugWarehouseTypeWs(), "0", "0^All", false);
			budgetDetailRptFB_p.setStrDrugWarehouseTypeCmb(strDwhTypeVal);
						
			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
			budgetDetailRptFB_p.setStrStoreValues(strStoreVal);			
						
			hisutil = new HisUtil("MMS Transactions", "BudgetDetailRptDATA");
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			budgetDetailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.BudgetDetailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"BudgetDetailRptDATA->getInitializedValues()", strMsgText);
			budgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 */
	public static void getFinancialYearCombo(BudgetDetailRptFB BudgetDetailRptFB_p,HttpServletRequest request_p)
	{
		BudgetDetailRptBO	BudgetDetailRptBO = null; 
		BudgetDetailRptVO	BudgetDetailRptVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear="";
		String strNextFinancialYear=""; 
		
		try {
			BudgetDetailRptBO = new BudgetDetailRptBO();
			BudgetDetailRptVO = new BudgetDetailRptVO();
			
			hisutil = new HisUtil("DWH Transaction","BudgetDetailRptDATA");
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			 
			    if(strCurrentMonth>=4 )
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
				}
				else
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
				}
			 
			 
			    String DATE_FORMAT = "dd-MM-yyyy";
			    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
			    
			    
			    Calendar calendar1 = Calendar.getInstance();
			     
			    Calendar calendar2 = Calendar.getInstance();
			    
			    calendar1.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), Integer.parseInt( strCurrentDate.split("\\-")[1] )-1 , Integer.parseInt( strCurrentDate.split("\\-")[0]));
			    calendar2.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), 3 , 365);
			     
			    //System.out.print(sdf.format(calender1.getTime()));
			     
			    if (calendar1.before(calendar2)) 
			    {
					strCurrentFinancialYear = (CURRENT_YEAR-1) + " - " + CURRENT_YEAR; 			
					strNextFinancialYear =     CURRENT_YEAR + " - " + (CURRENT_YEAR + 1);
			       
			    }
			    if (calendar1.after(calendar2)) 
			    {
					strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
					strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2); 
			    } 
			    if (calendar1.equals(calendar2)) 
			    {
					strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
					strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);  
			    } 
			// For setting the financial year combo
			BudgetDetailRptFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			BudgetDetailRptFB_p.setStrNextFinancialYear(strNextFinancialYear);
				
		} 
		catch (Exception e) 
		{
			strMsgText = "mms.transactions.BudgetDetailRptDATA.getStoreDtls --> "+ e.getMessage();
			HisException eObj = new HisException("mms","BudgetDetailRptDATA->getStoreDtls()", strMsgText);
			BudgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{

			if (BudgetDetailRptBO != null)
				BudgetDetailRptBO = null;
			if (BudgetDetailRptVO != null)
				BudgetDetailRptVO = null;
			if (hisutil != null)
				hisutil = null;
		}
		
	}

/*	
	public static void getStoreList(BudgetDetailRptFB budgetDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		BudgetDetailRptBO bo = null;
		BudgetDetailRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new BudgetDetailRptBO();
			voObj = new BudgetDetailRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			budgetDetailRptFB_p.setStrHospitalCode(strHospitalCode);
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(budgetDetailRptFB_p.getStrSeatId());
			budgetDetailRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(budgetDetailRptFB_p.getStrDrugWarehouseTypeId());
			
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "BudgetDetailRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BudgetDetailRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BudgetDetailRptDATA->getStoreList()", strmsgText);
			budgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
	*/
	
	public static void showReport(BudgetDetailRptFB budgetDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		
		BudgetDetailRptBO bo = null;
		BudgetDetailRptVO voObj = null;
		HisUtil hisutil= null;
		String strCurrentDate;
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			bo = new BudgetDetailRptBO();
			voObj = new BudgetDetailRptVO();
			hisutil = new HisUtil("DWH","BudgetDetailRptDATA");
			
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			budgetDetailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			budgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = budgetDetailRptFB_p.getStrHospitalCode();
			String strReportId = budgetDetailRptFB_p.getStrReportId();
		
			voObj.setStrHospitalCode(budgetDetailRptFB_p.getStrHospitalCode());
			voObj.setStrDrugWarehouseTypeId(budgetDetailRptFB_p.getStrDrugWarehouseTypeId());
			
			
			voObj.setStrStoreId(budgetDetailRptFB_p.getStrStoreId());
//		    System.out.println("Start F Y :::"+budgetDetailRptFB_p.getStrStartFinancialYear());
//		    System.out.println("Start E Y :::"+budgetDetailRptFB_p.getStrEndFinancialYear());
			
			String strStartYear = budgetDetailRptFB_p.getStrStartFinancialYear();
			String strEndYear = budgetDetailRptFB_p.getStrEndFinancialYear();
			
			
			String strFromDate = budgetDetailRptFB_p.getStrFromDate();
			String strToDate = budgetDetailRptFB_p.getStrToDate();
			
			String strUserRemarks = budgetDetailRptFB_p.getStrUserRemarks();
			
			
			/*if(!voObj.getStrDrugWarehouseTypeId().equals("0"))
			{
				bo.getStoreDistrictFlag(voObj);
			}
			else
			{
				voObj.setStrDistrictFlg("0");
			}*/
			
			
			reportFormat = budgetDetailRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(budgetDetailRptFB_p.getStrIsFooter()==null)
				budgetDetailRptFB_p.setStrIsFooter("0");
			
			if (budgetDetailRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			if(budgetDetailRptFB_p.getStrWhetherToShowDataForNoBudgetAllocatedCheckBox()==null)
			{
				budgetDetailRptFB_p.setStrWhetherToShowDataForNoBudgetAllocatedCheckBox("0");
			}
			
			if(budgetDetailRptFB_p.getStrWhetherToShowNoOfBedsCheckBox()==null)
			{
				budgetDetailRptFB_p.setStrWhetherToShowNoOfBedsCheckBox("0");
			}
			
			String strReportName = "Budget Detail Report";
	
							

//				String reportPath = "/mms/reports/dwh_budgetDetail_rpt.rptdesign"; // Older one				
				String reportPath = "/mms/reports/rpt_new_budget_detail.rptdesign";	// New one by Brahmam
				
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				
			
				params.put("storeId", budgetDetailRptFB_p.getStrStoreId());
				params.put("storeName", budgetDetailRptFB_p.getStrStoreName());
		            
		          
		        params.put("ddwtype", budgetDetailRptFB_p.getStrDrugWarehouseTypeId());  // districtFlg is used for the dwhTypeId, eg. for dwhTypeId = 11 for PHC
		          
				params.put("from_year", strStartYear);
				params.put("to_year", strEndYear);				
				params.put("startDate", strCurrentDate);
				params.put("toDate", strCurrentDate);
				params.put("sl_no", "0");
//				params.put("districtFlg", budgetDetailRptFB_p.getStrDrugWarehouseTypeId());
				
				params.put("dwhName", budgetDetailRptFB_p.getStrDwhStoreName());
				
				 if(budgetDetailRptFB_p.getStrWhetherToShowNoOfBedsCheckBox().equals("1"))
					{
						params.put("noOfBedsFlag", true);
					}
				 else
				 {
					params.put("noOfBedsFlag", false);
				 }
				
				 if(budgetDetailRptFB_p.getStrWhetherToShowDataForNoBudgetAllocatedCheckBox().equals("0"))
					{
						params.put("nobudgetallocflag", "0");
					}
					else
					{
						params.put("nobudgetallocflag", "1");
					}
					
				 
				 //params.put("dwhTypeName", budgetDetailRptFB_p.getStrDwhStoreName());
				 
				 
				ts.displayReport(request, response, reportPath, reportFormat,params,budgetDetailRptFB_p.getStrStoreId());
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
