package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.HelpDeskRptBO;
import mms.reports.bo.MaterialInwardReisterRptBO;
import mms.reports.controller.fb.HelpDeskRptFB;
import mms.reports.controller.fb.MaterialInwardReisterRptFB;
import mms.reports.controller.hlp.HelpDeskRptHLP;
import mms.reports.controller.hlp.MaterialInwardReisterRptHLP;
import mms.reports.vo.HelpDeskRptVO;
import mms.reports.vo.MaterialInwardReisterRptVO;

import mms.transactions.controller.action.Download;




public class HelpDeskRptDATA 
{
	
	public static void getInitializedValues(HelpDeskRptFB HelpDeskRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		HelpDeskRptBO bo = null;
		HelpDeskRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new HelpDeskRptBO();
			voObj = new HelpDeskRptVO();
						
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			HelpDeskRptFB_p.setStrHospitalCode(strHospitalCode);
			HelpDeskRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			hisutil = new HisUtil("DWH","HelpDeskRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			//strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			voObj.setStrSeatId(HelpDeskRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
//			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
//			MaterialInwardRptFB_p.setStrStoreValues(strStoreVal);
			
			strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			HelpDeskRptFB_p.setStrManufactureCombo(strSupplierVal);
			
			String strMenuVal=hisutil.getOptionValue(voObj.getStrMenuCmbWs(), "0", "0^All", false);
			HelpDeskRptFB_p.setStrMenuCmb(strMenuVal);
						
			String strDeptVal=hisutil.getOptionValue(voObj.getStrDeptCmbWs(), "0", "0^All", false);
			HelpDeskRptFB_p.setStrDeptcmb(strDeptVal);
			
			String strStatusVal=hisutil.getOptionValue(voObj.getStrStatusCmbWs(), "0", "0^All", false);
			HelpDeskRptFB_p.setStrStatuscmb(strStatusVal);
			
			hisutil = new HisUtil("MMS Transactions", "HelpDeskRptDATA");
			// For setting the financial year 
			HelpDeskRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			HelpDeskRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			HelpDeskRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.HelpDeskRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"HelpDeskRptDATA->getInitializedValues()", strMsgText);
			HelpDeskRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	
	
	 public static void getScreenTwo(HelpDeskRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				HelpDeskRptBO bo = null;
				HelpDeskRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new HelpDeskRptBO();
					vo = new HelpDeskRptVO();
					
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
																	
				////System.out.println("Menu Id:::"+formBean.getStrMenuId());
				////System.out.println("Store Id:::"+formBean.getStrStoreId());
				////System.out.println("Dept Id:::"+formBean.getStrDeptId());
				////System.out.println("status Id:::"+formBean.getStrStatus());
				////System.out.println("frmdate:::"+formBean.getStrFromDate());
				////System.out.println("to data:::"+formBean.getStrToDate());
				
				
					
				   vo.setStrMenuId(request.getParameter("MenuId"));
					vo.setStrStatusId(request.getParameter("StatusId"));
					vo.setStrDeptId(request.getParameter("DeptId"));
					vo.setStrStoreId(request.getParameter("StrId"));
					
					
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					//vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					//vo.setStrPoNumber(request.getParameter("dateFlg"));
					
									
					bo.getScreenTwo(vo);
					////System.out.println("returned");
					String strItemDetails = HelpDeskRptHLP.getScreenTwo(vo.getStrScreentTwoWs());
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	

    
   

    public static void DownloadFile(HelpDeskRptFB formBean,
			HttpServletRequest request,HttpServletResponse response) {
		
    	HelpDeskRptBO bo = null;
    	HelpDeskRptVO vo = null;
		Download dl=null;
		String strmsgText = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		String strChk = "";
		String path = "";
		String[] strActive = null;
		//String[] strAcknowledge = null;

		try {
			
			bo = new HelpDeskRptBO();
			vo = new HelpDeskRptVO();
			dl = new Download();
			
			
			
			//String strFileName = request.getParameter("hiddenValue").split("\\^")[0];
			String strFileName = request.getParameter("hiddenValue").replace("@$@$", "%");;
			////System.out.println("strFileName ::"+strFileName);
			if(strFileName!=null)
			{
			dl.doDownload(request,response,strFileName);
			
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "HelpDeskDATA.getViewInitialVal(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"HelpDeskDATA->getAcknowledgeVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
    
    public static void getPrintScreenTwo(HelpDeskRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	{

    	HelpDeskRptBO bo = null;
    	HelpDeskRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new HelpDeskRptBO();
					vo = new HelpDeskRptVO();
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					 vo.setStrMenuId(request.getParameter("MenuId"));
						vo.setStrStatusId(request.getParameter("StatusId"));
						vo.setStrDeptId(request.getParameter("DeptId"));
						vo.setStrStoreId(request.getParameter("StrId"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					//vo.setStrPoNumber(request.getParameter("dateFlg"));
					
					bo.getScreenTwo(vo);
					
					String strItemDetails = HelpDeskRptHLP.getPrintScreenTwo(vo);
					
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strItemDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					strmsgText = "mms.transactions.IssueTransDATA.getItemDetails --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"IssueTransDATA->getItemDetails()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : "
							+ eObj.getErrorID() + "],Contact System Administrator! ");
					
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	
}
