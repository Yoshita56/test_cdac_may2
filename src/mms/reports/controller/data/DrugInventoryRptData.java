/**
 * Developer : Anshul Jindal
 * Version : 1.0
 * Date : 17/Feb/2013
 *  
*/
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.IssueDetailRptBO;
import mms.reports.controller.fb.IssueDetailRptFB;
import mms.reports.vo.IssueDetailRptVO;

public class DrugInventoryRptData {
	
	
	public static void setInitDtl(IssueDetailRptFB formBean,HttpServletRequest request) 
	{
		IssueDetailRptVO vo=null;
		IssueDetailRptBO bo=null;
		String strCurrentDate="";
		String strStoreVal="";
		String strHospName="";
		HisUtil util = null;
		
		try 
		{
				bo=new IssueDetailRptBO();
				vo=new IssueDetailRptVO();
				//System.out.println("In issueDetailDATA");
				util = new HisUtil("MMS","IssueDetailRptData");
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
						util = new HisUtil("MMS","IssueDetailRptData");
					
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
			   HisException eObj = new HisException("MMS", "IssueDetailRptData->setInitDtl()", strmsgText);
			   formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!");
			   eObj = null;
		} 
		finally 
		{
		}
	}
	
	public static void setItemCategCombo(IssueDetailRptFB formBean,HttpServletRequest request) 
	{
		IssueDetailRptVO vo=null;
		IssueDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new IssueDetailRptBO();
				vo=new IssueDetailRptVO();
				
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
					util = new HisUtil("MMS","IssueDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(),"0","0^Select Value", false);
					formBean.setStrItemCategCmb(strItemVal);			    	
				}
		}
		catch (Exception e) 
		{
        		strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueDetailRptData->setItemCategComboDtl()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
		 }
	}	
	public static void setItemCategComboDtl(IssueDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueDetailRptVO vo=null;
		IssueDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strItemVal="";
		
		try 
		{
				bo=new IssueDetailRptBO();
				vo=new IssueDetailRptVO();
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
					util = new HisUtil("MMS","IssueDetailRptData");
					strItemVal=util.getOptionValue(vo.getItemCategWS(), "0","0^Select Value", false);
					response.getWriter().print(strItemVal);			    	
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueDetailRptData->setItemCategComboDtl()", strmsgText);
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
	public static void setStoreCombo(IssueDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		IssueDetailRptVO vo=null;
		IssueDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strStoreVal="";
		
		try 
		{
				bo=new IssueDetailRptBO();
				vo=new IssueDetailRptVO();
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
					util = new HisUtil("MMS","IssueDetailRptData");
					strStoreVal = util.getOptionValue(vo.getStrWS(), "", "0^Select Value", false);
					response.getWriter().print(strStoreVal);
				}	
		} 
		catch (Exception e) 
		{
				strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueDetailRptData->setItemCategComboDtl()", strmsgText);
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
	public static void setDrugNameCombo(IssueDetailRptFB formBean,HttpServletRequest request,HttpServletResponse response) {

		IssueDetailRptVO vo=null;
		IssueDetailRptBO bo=null;
		String strmsgText="";
		HisUtil util = null;
		String strDrugVal="";
		
		try 
		{
				bo=new IssueDetailRptBO();
				vo=new IssueDetailRptVO();
				
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrCategoryNo(request.getParameter("catCode"));
				bo.getDrugNameCombo(vo);
				
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					util = new HisUtil("Issue Detail Report","IssueDetailRptData");
					
					strDrugVal=util.getOptionValue(vo.getStrItemNameComboWS(), "0","0^All", false);
					response.getWriter().print(strDrugVal);
			    	
				}
		 }
		 catch (Exception e) 
		 {

				strmsgText = "IssueDetailRptData.setDrugNameCombo() --> "	+ e.getMessage();
				HisException eObj = new HisException("IPD", "IssueDetailRptData->setDrugNameCombo()", strmsgText);
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

	public static void getExistingBatchList(IssueDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		IssueDetailRptBO bo = null;
		IssueDetailRptVO vo = null;

		try 
		{
			bo = new IssueDetailRptBO();
			vo = new IssueDetailRptVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId       = request.getSession().getAttribute("SEATID").toString();
			String itemId          = "0";
			String strStoreId      = (String) request.getParameter("storeId");
			String strItemBrandId  = (String) request.getParameter("strItemBrandId");
			HisUtil hisutil = new HisUtil("mms", "IssueDetailRptDATA");
			
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
			strmsgText = "DrugInventory.IssueDetailRptDATA.getExistingBatchList(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms",	"IssueDetailRptDATA->getExistingBatchList()", strmsgText);
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
	public static void showReport(IssueDetailRptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategNo();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();
			reportFormat = formBean.getStrReportFormat();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String strReportName = "Offline Drug Entry Report";
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;				
			}			

			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);			
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("catCode", "55");
			params.put("fromDate", strFromDate);
			params.put("toDate", strToDate);
			//System.out.println("formBean.getStrCase()>>>>>>>>"+formBean.getStrCase());
			//if(formBean.getStrCase().equals("3"))//Issuing Store
			//{				
				//String reportPath = "/mms/reports/issueRegister_mmsrpt.rptdesign";
				String reportPath = "/mms/reports/drugInventoryRpt.rptdesign";
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
}