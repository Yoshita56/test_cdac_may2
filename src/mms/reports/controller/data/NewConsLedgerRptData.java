package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.NewConsLedgerRptBO;
import mms.reports.controller.fb.NewConsLedgerRptFB;
import mms.reports.controller.hlp.NewConsLedgerRptHLP;
import mms.reports.vo.NewConsLedgerRptVO;

public class NewConsLedgerRptData {

	public static void setInitDtl(NewConsLedgerRptFB formBean,HttpServletRequest request) 
	{
		NewConsLedgerRptVO vo=null;
		NewConsLedgerRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="";
		String strHospName="";
		String strYearVal="";
		HisUtil util = null;
		
		try 
		{
				bo=new NewConsLedgerRptBO();
				vo=new NewConsLedgerRptVO();
				//System.out.println("In issueDetailDATA");
				util = new HisUtil("MMS","NewConsLedgerRptData");
				//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
				//System.out.println("request.getSession().getAttribute(HOSPITAL_CODE).toString()>>>>>>>>"+request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.getHospitalName(vo);
				strHospName= util.getOptionValue(vo.getStrHospitalWs(),vo.getStrHospCode(),"", false);
				formBean.setStrHospNameValues(strHospName);
				
				/*if(strUserLevel.equals("6"))
				{
					vo.setStrMode("4");
				}
				else*/
					vo.setStrMode("1");
				
				bo.getInitDtl(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
						util = new HisUtil("MMS","NewConsLedgerRptData");
					
						strCurrentDate=util.getASDate("dd-MMM-yyyy");
						formBean.setStrCurrentDate(strCurrentDate);
						
						if(vo.getStrWS()!=null || vo.getStrWS().size()>0 && vo.getStrFYCmbWS()!=null || vo.getStrFYCmbWS().size()>0 )
						{
							
							{
								strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);	
								strYearVal= util.getOptionValue(vo.getStrFYCmbWS(), "", "0^Select Year", false);
							
							}
						}
						else
						{
							strStoreVal = util.getOptionValue(vo.getStrWS(), "0", "0^Select Value", false);
						}
						
						formBean.setStrStoreVal(strStoreVal);
						formBean.setStrYearVal(strYearVal);
						formBean.setStrStoreId(vo.getStrStoreId());
						setItemCategCombo(formBean,request);
						
				}				
		 }
		 catch (Exception e) 
		 {
               String strmsgText = e.getMessage();
			   HisException eObj = new HisException("MMS", "NewConsLedgerRptData->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!");
			   eObj = null;
		} 
		finally 
		{
		}
	}
	
	public static void setItemCategCombo(NewConsLedgerRptFB formBean,HttpServletRequest request) 
	{
		NewConsLedgerRptVO vo=null;
		NewConsLedgerRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new NewConsLedgerRptBO();
				vo=new NewConsLedgerRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(formBean.getStrStoreId());
				
				if(vo.getStrStoreId().equals("0"))
					vo.setStrMode("1");				
				else
					vo.setStrMode("2");
				
				bo.getItemCateg(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{				
					util = new HisUtil("MMS","NewConsLedgerRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(),"0","0^Select Value", false);
					formBean.setStrItemCategCmb(strItemVal);			    	
				}
		}
		catch (Exception e) 
		{
        		strmsgText = "NewConsLedgerRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "NewConsLedgerRptData->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
		 }
	}	
	public static void setItemCategComboDtl(NewConsLedgerRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		NewConsLedgerRptVO vo=null;
		NewConsLedgerRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new NewConsLedgerRptBO();
				vo=new NewConsLedgerRptVO();
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrStoreId(request.getParameter("strId"));
				
				if(vo.getStrStoreId().equals("0"))
					vo.setStrMode("1");
				else
						vo.setStrMode("2");
		
				bo.getItemCateg(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{				
					util = new HisUtil("MMS","NewConsLedgerRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);			    	
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "NewConsLedgerRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "NewConsLedgerRptData->setItemCategComboDtl()", strmsgText);
			    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
			    try
			    {
			    	response.getWriter().print(response1);
			    	eObj=null;
			    }
			    catch(Exception e1)
			    {
			    	
			    }
		 }
	}
	public static void setStoreCombo(NewConsLedgerRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		NewConsLedgerRptVO vo=null;
		NewConsLedgerRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strStoreVal="";
		
		try 
		{
				bo=new NewConsLedgerRptBO();
				vo=new NewConsLedgerRptVO();
				vo.setStrHospitalCode(request.getParameter("hospitalCode"));
				vo.setStrHospCode(request.getParameter("hospitalCode"));
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrMode("1");
				bo.setStoreCombo(vo);				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{				
					util = new HisUtil("MMS","NewConsLedgerRptData");
					strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);
					response.getWriter().print(strStoreVal);
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "NewConsLedgerRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "NewConsLedgerRptData->setItemCategComboDtl()", strmsgText);
			    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
			    try
			    {
			    	response.getWriter().print(response1);
			    	eObj=null;
			    }
			    catch(Exception e1)
			    {			    	
			    }
		 }
	}
	
	
	
	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void setDrugNameCombo(NewConsLedgerRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		NewConsLedgerRptVO vo=null;
		NewConsLedgerRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strDrugVal="";
		
		try 
		{
				bo=new NewConsLedgerRptBO();
				vo=new NewConsLedgerRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrCategoryNo(request.getParameter("catCode"));
				bo.getDrugNameCombo(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					util = new HisUtil("Issue Detail Report","NewConsLedgerRptData");
					
					strDrugVal=util.getOptionValue(vo.getStrItemNameComboWS(), "0","0^All", false);
					response.getWriter().print(strDrugVal);
			    	
				}
		 }
		 catch (Exception e) 
		 {

				strmsgText = "NewConsLedgerRptData.setDrugNameCombo() --> "	+ e.getMessage();
				HisException eObj = new HisException("IPD", "NewConsLedgerRptData->setDrugNameCombo()", strmsgText);
			    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
			    try
			    {
			    	response.getWriter().print(response1);
			    	eObj=null;
			    }
			    catch(Exception e1)
			    {
			    	
			    }
		 }
	}
	
	
	/**
	 * To get values of Existing Batch Number 
	 * for Selected Drug
	 * @param formBean
	 * @param request
	 */


	
	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void showReport(NewConsLedgerRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{		
			String months=formBean.getStrMonth();
		//	String year=formBean.getStrYearVal();
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
//			String strFromDate = formBean.getStrFromDate();
//			String strToDate = formBean.getStrToDate();
	//		String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();
	//		String strItembrandId= formBean.getStrItemBrandId();   // added by vikram on 20122021
			reportFormat = formBean.getStrReportFormat();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String strReportName = "Issue Details";
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;				
			}			
			//mapping the form bean data with the string, to be used in Reports
		//	params.put("fyear", year);
			params.put("month", months);
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
	//		params.put("report_user_Remarks", strUserRemarks);			
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("catCode", strCatCode);
//			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
//			params.put("toDate", sdf.format(sdf.parse(strToDate)));
//			params.put("itemid", strItembrandId);
			
			//if(formBean.getStrCase().equals("3"))//Issuing Store
			//{				
				//String reportPath = "/mms/reports/issueRegister_mmsrpt.rptdesign";
				//String reportPath = "/mms/reports/NewConsLedgerRpt_mmsrpt_new.rptdesign";
			System.out.println("Entered into the Report");
			String reportPath = "/mms/reports/NewConsLedgerRpt_mmsrpt_new_new.rptdesign";
			
			System.out.println("reportPath>>>>>>>>"+reportPath);
			
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			/*}
			else if(formBean.getStrCase().equals("2"))// For Employee
			{			
				String reportPath = "/mms/reports/issueDetail_mmsrpt2.rptdesign";												
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			}
			else if(formBean.getStrCase().equals("1"))// For Patient
			{				
				String reportPath = "/mms/reports/issueDetail_mmsrpt1.rptdesign";								
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			}	*/	      	
		} 
		catch (Exception e) 
		{
		}
	}
	
	public static void showReportNEW(NewConsLedgerRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";
		NewConsLedgerRptVO vo =null;
		NewConsLedgerRptBO bo =null;
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{	
				
			bo = new NewConsLedgerRptBO();
			vo = new NewConsLedgerRptVO();
			String strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strCatCode = request.getParameter("strItemCategNo");
			String strMonthVal=request.getParameter("months");
			String strFYear=request.getParameter("year");
//		
			String strStoreId = request.getParameter("storeId");
			String storeName= request.getParameter("storeName");
			String itemName= request.getParameter("itemName");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			System.out.println( "HOSPITAL_CODE = "+request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("strStoreId-"+strStoreId);
			System.out.println("storeName-"+storeName);
			System.out.println("item category code -"+strCatCode);
			System.out.println("itemName-"+itemName);
			System.out.println("financial year- "+strFYear);
			System.out.println("month selected- "+strMonthVal);
		//	System.out.println("strItembrandId-"+strItembrandId);
//			System.out.println("itemBrandName-"+itemBrandName);
//			System.out.println("strFromDate-"+strFromDate);
//			System.out.println("strToDate-"+strToDate);
			
			
			vo.setStrStoreName(storeName);
			vo.setStrItemName(itemName);
		//	vo.setStrItemBrandName(itemBrandName);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCategoryNo(strCatCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrMonth(strMonthVal);
			vo.setStrYear(strFYear); 		// this should be a string method or a webrowset method

			bo.getReportData(vo);
				
				
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			else {
				if(vo.getReportDataWS()!=null )
				{
					String strResult = "";
					strResult=NewConsLedgerRptHLP.generateReport(vo); 
					
					response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				}
			}
		} 
		catch (Exception e) 
		{
		}
	}

	public static void showDetailedReportNEW(NewConsLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) {
		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";
		NewConsLedgerRptVO vo =null;
		NewConsLedgerRptBO bo =null;
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{	
				
			bo = new NewConsLedgerRptBO();
			vo = new NewConsLedgerRptVO();
			String strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strCatCode = request.getParameter("strItemCategNo");
			String strMonthVal=request.getParameter("months");
			String strFYear=request.getParameter("year");
			String brandID=request.getParameter("medID");
			String strStoreId = request.getParameter("storeId");
			String storeName= request.getParameter("storeName");
			String itemName= request.getParameter("itemName");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			System.out.println( "HOSPITAL_CODE = "+request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("strStoreId-"+strStoreId);
			System.out.println("storeName-"+storeName);
			System.out.println("item category code -"+strCatCode);
			System.out.println("itemName-"+itemName);
			System.out.println("financial year- "+strFYear);
			System.out.println("month selected- "+strMonthVal);
			
			vo.setStrStoreName(storeName);
			vo.setStrItemName(itemName);
		//	vo.setStrItemBrandName(itemBrandName);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCategoryNo(strCatCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrMonth(strMonthVal);
			vo.setStrYear(strFYear); 		// this should be a string method
			vo.setStrItemBrandId(brandID);	//medicine name set...yet to include in remaining files
			bo.getDetailedReportData(vo);
				
				
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			else {
				if(vo.getReportDataWS()!=null )
				{
					String strResult = "";
					strResult=NewConsLedgerRptHLP.generateDetailedReport(vo); 
			System.out.println(strResult); // html string generated by the methods in hlp class is passed here 
					
					response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				}
			}
		} 
		catch (Exception e) 
		{
		}
			
			
		
	}
	
}
