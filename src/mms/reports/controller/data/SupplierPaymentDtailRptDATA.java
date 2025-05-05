

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
import mms.reports.bo.SupplierPaymentDtailRptBO;
import mms.reports.controller.fb.SupplierPaymentDtailRptFB;
import mms.reports.controller.hlp.SupplierPaymentDtailRptHLP;
import mms.reports.vo.SupplierPaymentDtailRptVO;

public class SupplierPaymentDtailRptDATA 
{
	
	public static void getInitializedValues(SupplierPaymentDtailRptFB SupplierPaymentDtailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		SupplierPaymentDtailRptBO bo = null;
		SupplierPaymentDtailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strHospitalCode,strStoreVal,strDwhTypeVal,strSupplierVal;
		
		try {

			bo = new SupplierPaymentDtailRptBO();
			voObj = new SupplierPaymentDtailRptVO();
			
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			SupplierPaymentDtailRptFB_p.setStrHospitalCode(strHospitalCode);
			SupplierPaymentDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","SupplierPaymentDtailRptDATA");
			
					
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
			
			voObj.setStrSeatId(SupplierPaymentDtailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			if(strUserLevel.equals("6"))
			{
				voObj.setStrMode("12");
			}
			else
				voObj.setStrMode("1");
			
			
			bo.getInitializedValues(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			
//			strStoreVal = hisutil.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
//			SupplierPaymentDtailRptFB_p.setStrStoreValues(strStoreVal);
			
			if(strUserLevel.equals("6"))
			{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "0^All", false);
			}
			else
			{
				strSupplierVal = hisutil.getOptionValue(voObj.getStrManufactureComboWS(), "0", "-1^Select Value", false);	
			}
			
			
			SupplierPaymentDtailRptFB_p.setStrManufactureCombo(strSupplierVal);
			
			hisutil = new HisUtil("MMS Transactions", "SupplierPaymentDtailRptDATA");
			// For setting the financial year 
			SupplierPaymentDtailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			SupplierPaymentDtailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			SupplierPaymentDtailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.SupplierPaymentDtailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"SupplierPaymentDtailRptDATA->getInitializedValues()", strMsgText);
			SupplierPaymentDtailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getPOCombo(SupplierPaymentDtailRptFB SupplierPaymentDtailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		SupplierPaymentDtailRptBO bo = null;
		SupplierPaymentDtailRptVO voObj = null;
		String strMsgText = null;
		HisUtil hisutil = null;
		String strDrugValuesWs=null;
		String supplierId= request.getParameter("supplierId");
		String strHospitalCode;
		
		try {

			bo = new SupplierPaymentDtailRptBO();
			voObj = new SupplierPaymentDtailRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrSupplierId(supplierId);
			SupplierPaymentDtailRptFB_p.setStrHospitalCode(strHospitalCode);
			SupplierPaymentDtailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","SupplierPaymentDtailRptDATA");
			
			voObj.setStrSeatId(SupplierPaymentDtailRptFB_p.getStrSeatId());
			voObj.setStrHospitalCode(strHospitalCode);
			
			
			bo.getPOCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			//SupplierPaymentDtailRptFB_p.setStrDrugCombo(hisutil.getOptionValue(voObj.getStrDrugNameComboWS(), voObj.getStrDrugId(), "0^All", false));
			if(voObj.getStrSupplierComboWS()!=null && voObj.getStrSupplierComboWS().size() >0){
				strDrugValuesWs =hisutil.getOptionValue(voObj.getStrSupplierComboWS(), "0", "0^All", false);
			}
			else
			{
				strDrugValuesWs = "<option value='0'>All</option>";				
			}			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDrugValuesWs);
			//hisutil = new HisUtil("MMS Transactions", "SupplierPaymentDtailRptDATA");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.report.SupplierPaymentDtailRptDATA.getDrugNameValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"SupplierPaymentDtailRptDATA->getPOCombo()", strMsgText);
			SupplierPaymentDtailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	public static void getSupplierPerformanceDtlPrint(SupplierPaymentDtailRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
		{

				SupplierPaymentDtailRptBO bo = null;
				SupplierPaymentDtailRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new SupplierPaymentDtailRptBO();
					vo = new SupplierPaymentDtailRptVO();
					mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
																	
				
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrSupplierId(request.getParameter("supplierId"));
					vo.setStrGroupId(request.getParameter("groupCode"));
					vo.setStrDrugId(request.getParameter("drugCode"));
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					vo.setStrSupplierName(request.getParameter("suppName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					vo.setStrPoNumber(request.getParameter("poNumber"));
					
					String strFlag = request.getParameter("flag");
					if(strFlag == null || strFlag.equals("null")) strFlag = "0";
					
					////System.out.println("Drug ID:(request.getParameter(drugCode))::"+request.getParameter("drugCode"));
					bo.getSupplierPerformanceDtl(vo);
					
					String strItemDetails = "";
					
					vo.setStrReportId(strFlag);
					
					if(strFlag.equals("1"))
						strItemDetails = SupplierPaymentDtailRptHLP.getSupplierPerformabceDetailsPopUp1(vo);
					else
						strItemDetails = SupplierPaymentDtailRptHLP.getSupplierPerformabceDetailsPopUp1_without(vo);
					
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
					strmsgText = "mms.reports.SupplierPaymentDtail.getSupplierPerformanceDtl --> "
							+ e.getMessage();
					HisException eObj = new HisException("mms",
							"SupplierPaymentDtail->getSupplierPerformanceDtl()", strmsgText);
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
