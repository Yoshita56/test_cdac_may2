package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.Dwh_ZoneWiseBudgetRptBO;
import mms.reports.controller.fb.Dwh_ZoneWiseBudgetRptFB;
import mms.reports.controller.hlp.Dwh_ZoneWiseBudgetRptHLP;
import mms.reports.vo.Dwh_ZoneWiseBudgetRptVO;


public class Dwh_ZoneWiseBudgetRptDATA {
	
	public static void getInitializedValues(Dwh_ZoneWiseBudgetRptFB Dwh_ZoneWiseBudgetRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		Dwh_ZoneWiseBudgetRptBO bo = null;
		Dwh_ZoneWiseBudgetRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode;
		
		try {

			bo = new Dwh_ZoneWiseBudgetRptBO();
			voObj = new Dwh_ZoneWiseBudgetRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			Dwh_ZoneWiseBudgetRptFB_p.setStrHospitalCode(strHospitalCode);
			Dwh_ZoneWiseBudgetRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","Dwh_ZoneWiseBudgetRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			 String strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
			
			// For setting the financial year 
			Dwh_ZoneWiseBudgetRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			Dwh_ZoneWiseBudgetRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			Dwh_ZoneWiseBudgetRptFB_p.setStrCurrentDate(strCurrentDate);			

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.Dwh_ZoneWiseBudgetRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"Dwh_ZoneWiseBudgetRptDATA->getInitializedValues()", strMsgText);
			Dwh_ZoneWiseBudgetRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	public static void getZoneWiseBudgetDtlPrint(Dwh_ZoneWiseBudgetRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				Dwh_ZoneWiseBudgetRptBO bo = null;
				Dwh_ZoneWiseBudgetRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new Dwh_ZoneWiseBudgetRptBO();
					vo = new Dwh_ZoneWiseBudgetRptVO();
																	
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					mcu = new MmsConfigUtil(vo.getStrHospitalCode());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));

                
					bo.getZoneWiseBudgetDtl(vo);
					
					String strItemDetails = "";
					
					
						strItemDetails = Dwh_ZoneWiseBudgetRptHLP.getZoneWiseBudgetPopUp1(vo);
					
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
					strmsgText = "mms.reports.ZoneWiseBudgetDtail.getZoneWiseBudgetDtlPrint --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"ZoneWiseBudgetDtail->getZoneWiseBudgetDtlPrint()", strmsgText);
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
