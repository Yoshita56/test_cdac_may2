package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.BreakageAndLostDrugDetailsRptBO;
import mms.reports.controller.fb.BreakageAndLostDrugDetailsRptFB;
import mms.reports.controller.hlp.BreakageAndLostDrugDetailsRptHLP;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;

public class BreakageAndLostDrugDetailsRptDATA {
	
	public static void setInitializedValues(BreakageAndLostDrugDetailsRptFB breakageAndLostDrugDetailsRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		BreakageAndLostDrugDetailsRptBO bo = null;
		BreakageAndLostDrugDetailsRptVO voObj = null;
		
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strDistrictStoreVal;
		
		try 
		{
			System.out.println("---------BreakageAndLostDrugDetailsRptDATA.setInitializedValues---------");

			bo = new BreakageAndLostDrugDetailsRptBO();
			voObj = new BreakageAndLostDrugDetailsRptVO();
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			breakageAndLostDrugDetailsRptFB_p.setStrHospitalCode(strHospitalCode);
			breakageAndLostDrugDetailsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","BreakageAndLostDrugDetailsRptDATA");
			
					
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
			
			voObj.setStrSeatId(breakageAndLostDrugDetailsRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			voObj.setStrMode("1");
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			System.out.println("---voObj.getStrStoreWs()--------"+voObj.getStrStoreWs().size());
			
		    //strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);	
		    strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);	

			breakageAndLostDrugDetailsRptFB_p.setStrStoreValues(strStoreVal);
						
						
			hisutil = new HisUtil("MMS Transactions", "BreakageAndLostDrugDetailsRptDATA");
			
			// For setting the financial year 
			breakageAndLostDrugDetailsRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			breakageAndLostDrugDetailsRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			breakageAndLostDrugDetailsRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.BreakageAndLostDrugDetailsRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"BreakageAndLostDrugDetailsRptDATA->getInitializedValues()", strMsgText);
			breakageAndLostDrugDetailsRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getItemCatList(BreakageAndLostDrugDetailsRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		BreakageAndLostDrugDetailsRptBO bo = null;
		BreakageAndLostDrugDetailsRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new BreakageAndLostDrugDetailsRptBO();
			voObj = new BreakageAndLostDrugDetailsRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "BreakageAndLostDrugDetailsRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue",true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			//e.printStackTrace();
			strmsgText = "mms.transactions.BreakageAndLostDrugDetailsRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"BreakageAndLostDrugDetailsRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

/*	
	public static void getStoreList(BreakageAndLostDrugDetailsRptFB breakageAndLostDrugDetailsRptFB_p,HttpServletRequest request, HttpServletResponse response) 
	{

		BreakageAndLostDrugDetailsRptBO bo = null;
		BreakageAndLostDrugDetailsRptVO voObj = null;
		String strmsgText = null;
		String strHospitalCode, strStoreVal = "";
		String strDwhTypeVal;

		HisUtil util = null;
		try {

			bo = new BreakageAndLostDrugDetailsRptBO();
			voObj = new BreakageAndLostDrugDetailsRptVO();
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			breakageAndLostDrugDetailsRptFB_p.setStrHospitalCode(strHospitalCode);
			breakageAndLostDrugDetailsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			voObj.setStrHospitalCode(strHospitalCode);
			voObj.setStrSeatId(breakageAndLostDrugDetailsRptFB_p.getStrSeatId());
			breakageAndLostDrugDetailsRptFB_p.setStrDrugWarehouseTypeId(request.getParameter("dwhTypeId"));
			
			
			voObj.setStrDrugWarehouseTypeId(breakageAndLostDrugDetailsRptFB_p.getStrDrugWarehouseTypeId());
			
				
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("DWH", "BreakageAndLostDrugDetailsRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
						
		
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BreakageAndLostDrugDetailsRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BreakageAndLostDrugDetailsRptDATA->getStoreList()", strmsgText);
			breakageAndLostDrugDetailsRptFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void showReport_old(BreakageAndLostDrugDetailsRptFB breakageAndLostDrugDetailsRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String strReportName ="";
		
		String strStoreId = "";
		
		
		try 
		{
			BreakageAndLostDrugDetailsRptVO  vo = new BreakageAndLostDrugDetailsRptVO();
			
			breakageAndLostDrugDetailsRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			breakageAndLostDrugDetailsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = breakageAndLostDrugDetailsRptFB_p.getStrHospitalCode();
			String strReportId = breakageAndLostDrugDetailsRptFB_p.getStrReportId();
	
			
			
			String strFromDate = breakageAndLostDrugDetailsRptFB_p.getStrFromDate();
			String strToDate = breakageAndLostDrugDetailsRptFB_p.getStrToDate();
			
			String strUserRemarks = breakageAndLostDrugDetailsRptFB_p.getStrUserRemarks();
			
			vo = (BreakageAndLostDrugDetailsRptVO) TransferObjectFactory.populateData("mms.reports.vo.BreakageAndLostDrugDetailsRptVO", breakageAndLostDrugDetailsRptFB_p);
			
			reportFormat = breakageAndLostDrugDetailsRptFB_p.getStrReportFormat();
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}
	
	public static void showReport(BreakageAndLostDrugDetailsRptFB breakageAndLostDrugDetailsRptFB_p,HttpServletRequest request, HttpServletResponse response) {
		
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
		String strReportName ="";
		
		String strStoreId = "";
		
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			
			breakageAndLostDrugDetailsRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			breakageAndLostDrugDetailsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = breakageAndLostDrugDetailsRptFB_p.getStrHospitalCode();
			String strReportId = breakageAndLostDrugDetailsRptFB_p.getStrReportId();
	
			String strFromDate = breakageAndLostDrugDetailsRptFB_p.getStrFromDate();
			String strToDate = breakageAndLostDrugDetailsRptFB_p.getStrToDate();
			
			String strUserRemarks = breakageAndLostDrugDetailsRptFB_p.getStrUserRemarks();
			
			reportFormat = breakageAndLostDrugDetailsRptFB_p.getStrReportFormat();
			
			
			
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			
				breakageAndLostDrugDetailsRptFB_p.setStrIsFooter("0");
				strReportName = "BREAKAGE DETAILS";
											
				String reportPath = "/mms/reports/dwh_breakageAndLostDrugDetails_rpt.rptdesign";
				
				System.out.println("---strReportId-------"+strReportId);
				System.out.println("---strReportName-------"+strReportName);
				System.out.println("---footerVisible-------"+footerVisible);
				System.out.println("---strUserRemarks-------"+strUserRemarks);
				
				System.out.println("---strHospitalCode-------"+strHospitalCode);
				System.out.println("---storeId-------"+breakageAndLostDrugDetailsRptFB_p.getStrStoreId());
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				
				params.put("storeId", breakageAndLostDrugDetailsRptFB_p.getStrStoreId());
				strStoreId=breakageAndLostDrugDetailsRptFB_p.getStrStoreId();
								
				params.put("breakageOrLostFlag", "1");
								
				
				params.put("catCode", breakageAndLostDrugDetailsRptFB_p.getStrItemCatNo());
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				params.put("storeName", breakageAndLostDrugDetailsRptFB_p.getStrStoreName());
				
				System.out.println("---getStrItemCatNo-------"+breakageAndLostDrugDetailsRptFB_p.getStrItemCatNo());
				System.out.println("---strFromDate-------"+sdf.format(sdf.parse(strFromDate)));
				System.out.println("---strToDate-------"+sdf.format(sdf.parse(strToDate)));
								
				ts.displayReport(request, response, reportPath, reportFormat,params, strHospitalCode);
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

	public static void showReportNew(BreakageAndLostDrugDetailsRptFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       BreakageAndLostDrugDetailsRptVO vo = null;
	       BreakageAndLostDrugDetailsRptBO bo = null;
		   ReportUtil ts = new ReportUtil();		
		
		   try 
			{	
			   String strResult="";
			    vo=new BreakageAndLostDrugDetailsRptVO();
			   	bo=new BreakageAndLostDrugDetailsRptBO();
			 //  	String strHospitalCode = vo.getStrHospitalCode();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	//System.out.println("====HOSPITAL_CODE===="+request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   			   	
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
				vo.setStrStoreName(request.getParameter("storeName"));

			    vo.setStrItemCategoryId(request.getParameter("strCategoryId")); 	
			    vo.setStrCategoryName(request.getParameter("strCategoryName")); 
				//System.out.println("====strCategoryName===="+request.getParameter("strCategoryName"));
				
			   	vo.setStrStartDate((String) request.getParameter("strFromDate"));
				vo.setStrEndDate((String) request.getParameter("strToDate"));
				
				vo.setStrMode("1");
				bo.getImgHeader(vo);
				bo.setViewPageDtl(vo);

				 strResult=BreakageAndLostDrugDetailsRptHLP.getBreakageDetails(vo);
			    
				if(vo.getStrItemCategoryId()!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->showReportNew()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_LocalPurchaseMRN_FB.setStrMsgType("1");
				eObj = null;
		   }	   
	}
}
