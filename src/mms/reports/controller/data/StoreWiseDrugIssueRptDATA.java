package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.StoreWiseDrugIssueRptBO;
import mms.reports.controller.fb.StoreWiseDrugIssueRptFB;
import mms.reports.controller.hlp.StoreWiseDrugIssueRptHLP;
import mms.reports.vo.StoreWiseDrugIssueRptVO;

public class StoreWiseDrugIssueRptDATA {
	
	
	public static void setInitDtl(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request) 
	{
		StoreWiseDrugIssueRptVO vo=null;
		StoreWiseDrugIssueRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="";
		String strHospName="";
		HisUtil util = null;
		
		try 
		{
				bo=new StoreWiseDrugIssueRptBO();
				vo=new StoreWiseDrugIssueRptVO();
				//System.out.println("In issueDetailDATA");
				util = new HisUtil("MMS","StoreWiseDrugIssueRptDATA");
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
						util = new HisUtil("MMS","StoreWiseDrugIssueRptDATA");
					
						strCurrentDate=util.getASDate("dd-MMM-yyyy");
						formBean.setStrCurrentDate(strCurrentDate);
						
						if(vo.getStrWS()!=null || vo.getStrWS().size()>0)
						{
							/*if(strUserLevel.equals("6"))
							{
								strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);
							}*/
							//else
							{
								strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);	
							}
						}
						else
						{
							strStoreVal = util.getOptionValue(vo.getStrWS(), "0", "0^Select Value", false);
						}
						
						formBean.setStrStoreVal(strStoreVal);
						formBean.setStrStoreId(vo.getStrStoreId());
						setItemCategCombo(formBean,request);
				}				
		 }
		 catch (Exception e) 
		 {
               String strmsgText = e.getMessage();
			   HisException eObj = new HisException("MMS", "StoreWiseDrugIssueRptDATA->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!");
			   eObj = null;
		} 
		finally 
		{
		}
	}
	
	public static void setItemCategCombo(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request) 
	{
		StoreWiseDrugIssueRptVO vo=null;
		StoreWiseDrugIssueRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new StoreWiseDrugIssueRptBO();
				vo=new StoreWiseDrugIssueRptVO();
				
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
					util = new HisUtil("MMS","StoreWiseDrugIssueRptDATA");
					strItemVal=util.getOptionValue(vo.getItemCategWS(),"0","0^Select Value", false);
					formBean.setStrItemCategCmb(strItemVal);			    	
				}
		}
		catch (Exception e) 
		{
        		strmsgText = "StoreWiseDrugIssueRptDATA.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "StoreWiseDrugIssueRptDATA->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
		 }
	}	
	public static void setItemCategComboDtl(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		StoreWiseDrugIssueRptVO vo=null;
		StoreWiseDrugIssueRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new StoreWiseDrugIssueRptBO();
				vo=new StoreWiseDrugIssueRptVO();
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
					util = new HisUtil("MMS","StoreWiseDrugIssueRptDATA");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);			    	
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "StoreWiseDrugIssueRptDATA.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "StoreWiseDrugIssueRptDATA->setItemCategComboDtl()", strmsgText);
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
	public static void setStoreCombo(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		StoreWiseDrugIssueRptVO vo=null;
		StoreWiseDrugIssueRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strStoreVal="";
		
		try 
		{
				bo=new StoreWiseDrugIssueRptBO();
				vo=new StoreWiseDrugIssueRptVO();
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
					util = new HisUtil("MMS","StoreWiseDrugIssueRptDATA");
					strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);
					response.getWriter().print(strStoreVal);
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "StoreWiseDrugIssueRptDATA.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "StoreWiseDrugIssueRptDATA->setItemCategComboDtl()", strmsgText);
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
	public static void setDrugNameCombo(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		StoreWiseDrugIssueRptVO vo=null;
		StoreWiseDrugIssueRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strDrugVal="";
		
		try 
		{
				bo=new StoreWiseDrugIssueRptBO();
				vo=new StoreWiseDrugIssueRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrCategoryNo(request.getParameter("catCode"));
				bo.getDrugNameCombo(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					util = new HisUtil("Issue Detail Report","StoreWiseDrugIssueRptDATA");
					
					strDrugVal=util.getOptionValue(vo.getStrItemNameComboWS(), "0","0^All", false);
					response.getWriter().print(strDrugVal);
			    	
				}
		 }
		 catch (Exception e) 
		 {

				strmsgText = "StoreWiseDrugIssueRptDATA.setDrugNameCombo() --> "	+ e.getMessage();
				HisException eObj = new HisException("IPD", "StoreWiseDrugIssueRptDATA->setDrugNameCombo()", strmsgText);
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

	public static void getExistingBatchList(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		StoreWiseDrugIssueRptBO bo = null;
		StoreWiseDrugIssueRptVO vo = null;

		try 
		{
			bo = new StoreWiseDrugIssueRptBO();
			vo = new StoreWiseDrugIssueRptVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId       = request.getSession().getAttribute("SEATID").toString();
			String itemId          = "0";
			String strStoreId      = (String) request.getParameter("storeId");
			String strItemBrandId  = (String) request.getParameter("strItemBrandId");
			HisUtil hisutil = new HisUtil("mms", "StoreWiseDrugIssueRptDATA");
			
			vo.setStrStoreId(strStoreId);
			vo.setStrCategoryNo("10");
			vo.setStrItemBrandId(strItemBrandId);
						
			vo.setStrHospCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			
			vo.setStrMode("3");
			
			bo.getExistingBatchList(vo);
			

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			String cmbstr;
					if(vo.getStrExistingBatchComboWS()!=null && vo.getStrExistingBatchComboWS().size()>0 )
					{
						 cmbstr = hisutil.getOptionValue(vo.getStrExistingBatchComboWS(),"", "0^Select Value", false);	
					}
					else
					{
						cmbstr = "<option value='0'>Select Value</option>";
					}
					

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			}
			catch (Exception e) 
			{
				throw e;
			}

		} 
		catch (Exception e) 
		{
			strmsgText = "DrugInventory.StoreWiseDrugIssueRptDATA.getExistingBatchList(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms",	"StoreWiseDrugIssueRptDATA->getExistingBatchList()", strmsgText);
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(	"ERROR#### Application Error [ERROR ID : "	+ eObj.getErrorID()	+ "],Contact System Administrator! ");

			}
			catch (Exception e1) 
			{
				e.printStackTrace();
			}

			eObj = null;
		}
		finally 
		{
			vo = null;
			bo = null;
		}
	}
	
	
	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void showReport(StoreWiseDrugIssueRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";
		String strmsgText = null;
		StoreWiseDrugIssueRptBO bo = null;
		StoreWiseDrugIssueRptVO vo = null;

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{			
			bo = new StoreWiseDrugIssueRptBO();
			vo = new StoreWiseDrugIssueRptVO();
			
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strReportId = formBean.getStrReportId();
			String strCatCode = request.getParameter("strItemCategNo");
			String strFromDate = request.getParameter("strFromDate");
			String strToDate = request.getParameter("strToDate");
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = request.getParameter("storeId");
			String strItembrandId= request.getParameter("strItemBrandId");
			String storeName= request.getParameter("storeName");
			String itemName= request.getParameter("itemName");
			String itemBrandName= request.getParameter("itemBrandName");
			String searchType= request.getParameter("searchType");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String strReportName = "Issue Details";
			boolean footerVisible = true;
			
			System.out.println( "HOSPITAL_CODE = "+request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("strStoreId-"+strStoreId);
			System.out.println("storeName-"+storeName);
			System.out.println("strCatCode-"+strCatCode);
			System.out.println("itemName-"+itemName);
			System.out.println("strItembrandId-"+strItembrandId);
			System.out.println("itemBrandName-"+itemBrandName);
			System.out.println("strFromDate-"+strFromDate);
			System.out.println("strToDate-"+strToDate);
			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;				
			}	
			
			vo.setStrStoreName(storeName);
			vo.setStrItemName(itemName);
			vo.setStrItemBrandName(itemBrandName);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCategoryNo(strCatCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrFromDate(strFromDate);
			vo.setStrToDate(strToDate);
			vo.setStrItemId(strItembrandId);
			vo.setStrSearchType(searchType);
			
			
			System.out.println("Entered into the Report");
			bo.getReportData(vo);
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			else {
				if(vo.getReportDataWS()!=null )
				{
					String strResult = "";
					if(vo.getStrSearchType().equals("1")) {
						strResult=StoreWiseDrugIssueRptHLP.generateReportForStoreWise(vo); 
					}
					else {
						strResult=StoreWiseDrugIssueRptHLP.generateReportForDrugWise(vo);
					}
					
					response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.StoreWiseDrugIssueRptDATA.showReport --> " + e.getMessage();
			HisException eObj = new HisException("mms", "StoreWiseDrugIssueRptDATA->getshowReportStoreList()", strmsgText);
			formBean.setStrErrMsg(
				"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		}
	}
}