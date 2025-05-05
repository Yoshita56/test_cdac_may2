package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.reports.bo.LPReportsTransBO;
import mms.reports.controller.fb.LPReportsTransFB;
import mms.reports.controller.hlp.LPReportsTransHLP;
import mms.reports.vo.LPReportsTransVO;
import mms.transactions.bo.IndentViewTransBO;
import mms.transactions.controller.hlp.IndentViewTransHLP;
import mms.transactions.vo.IndentViewTransVO;


public class LPReportsTransDATA {
	
	public static void initDetails(LPReportsTransFB formBean, HttpServletRequest request)
	{

		LPReportsTransBO bo = null;
		LPReportsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strHospName="";
		
		try {

			bo = new LPReportsTransBO();
			voObj = new LPReportsTransVO();
			
			String strUserLevel ="1";// request.getSession().getAttribute("USER_LEVEL").toString();
			
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "10";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrMode("1");
			
			bo.getHospitalName(voObj);
			
			
			util = new HisUtil("MMS", "LPReportsTransDATA");
			strHospName= util.getOptionValue(voObj.getStrHospitalWs(),"","", false);
			
			formBean.setStrHospNameValues(strHospName);
			
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "LPReportsTransDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) 
			{
			
				//if(strUserLevel.equals("6"))
				//{
					temp = util.getOptionValue(voObj.getStrSupplierWs(), "0", "0^All", false);
				/*}
				else
				{
					temp = util.getOptionValue(voObj.getStrSupplierWs(), "0", "-1^Select Value", false);	
				}*/
				

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			formBean.setStrSupplierCmb(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.LPReportsTransDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->getSupplierList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	
	public static void getStoreList(LPReportsTransFB formBean, HttpServletRequest request) {

		LPReportsTransBO bo = null;
		LPReportsTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		
		try {
			bo = new LPReportsTransBO();
			vo = new LPReportsTransVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "LPReportsTransDATA");
			
			strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "0", "0^Select Value", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.LPReportsTransDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getItemCatList(LPReportsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		LPReportsTransBO bo = null;
		LPReportsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new LPReportsTransBO();
			voObj = new LPReportsTransVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "LPReportsTransDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.LPReportsTransDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void getPOTypeList(LPReportsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		LPReportsTransBO bo = null;
		LPReportsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new LPReportsTransBO();
			voObj = new LPReportsTransVO();
			
			String strStoreId = request.getParameter("storeId");
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strStoreId == null)
				strStoreId = "0";
			if (strItemCatNo == null)
				strItemCatNo = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrReqFor("2");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getPOTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "LPReportsTransDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrPOTypeWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrPOTypeWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.LPReportsTransDATA.getPOTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->getPOTypeList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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
	
	public static void getSupplierList(LPReportsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		LPReportsTransBO bo = null;
		LPReportsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new LPReportsTransBO();
			voObj = new LPReportsTransVO();
			
			
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "0";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "LPReportsTransDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrSupplierWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.LPReportsTransDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->getSupplierList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
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

	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void showReport(LPReportsTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();

		try 
		{
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strWhetherItemShown = formBean.getStrWhetherItemShown();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			String strSupplierId = formBean.getStrSupplierId();
			String strPoStatus = formBean.getStrPoStatus();
			String potype = formBean.getStrPOType();
			String reportPath = ""; 
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;				
			}
			
			String strReportName = "Purchase Order Register";
			
			if( strWhetherItemShown==null || strWhetherItemShown.equals("") )
				strWhetherItemShown="0";
			
			if(strWhetherItemShown.equals("1"))
			{
				 reportPath = "/mms/reports/dwh_poRegister_rpt.rptdesign"; // Item Shown
			}
			else
			{
				 reportPath = "/mms/reports/dwh_poRegister_rpt1.rptdesign"; // Item Not Shown
			}
			//System.out.println("----LPReportsTransDATA . showReport -reportPath---"+reportPath);
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("supp_id",strSupplierId);
				params.put("po_status",strPoStatus);
				params.put("hospCode", strHospitalCode);
				params.put("from_Date", sdf.format(sdf.parse(strFromDate)));
				params.put("to_Date", sdf.format(sdf.parse(strToDate)));
				params.put("po_type", potype.equals("1")?"21":"22");
				params.put("report_Fix_Header","Header");
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);		      	
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
		}
	}
	
	public static void showReport_NEW(LPReportsTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{
			
		String strReportName = "";					
		LPReportsTransBO bo = null;
		LPReportsTransVO vo = null;		
		HisUtil util = null;	
		try 
		{
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new LPReportsTransBO();
			vo = new LPReportsTransVO();
			
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			String strHospitalCode = formBean.getStrHospitalCode();
			
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			
			
			String strSupplierId = formBean.getStrSupplierId();
			String strPoStatus = formBean.getStrPoStatus();
			String potype = formBean.getStrPOType();
						
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			
			
			System.out.println("------------ LPReportsTransDAT . showReport_NEW -----------------");
			System.out.println("strSupplierId---------"+strSupplierId);			
			System.out.println("strPoStatus---------"+strPoStatus);	
			System.out.println("potype---------"+potype);
			System.out.println("strFromDate---------"+strFromDate);
			System.out.println("strToDate---------"+strToDate);
			System.out.println("-----------------------------");

			
			//request.getSession().getAttribute("USER_LEVEL").toString();
			strReportName = "Local Purchase Req Dtl Report ";			
		
			System.out.println("strSupplierId---------"+strSupplierId);			
			System.out.println("strPoStatus---------"+strPoStatus);	
			System.out.println("potype---------"+potype);
			System.out.println("strFromDate---------"+strFromDate);
			System.out.println("strToDate---------"+strToDate);
			
			vo.setStrSupplierId(strSupplierId);
			vo.setStrFromDate(strFromDate);
			vo.setStrToDate(strToDate);
			
			vo.setStrHospitalCode(strHospitalCode);			
			vo.setStrSeatId(seatid);
			
			

			
				    System.out.println("<-----With Batch-- PKG_MMS_VIEW2.proc_rptm_new [ Mode - 2] -->");
				    
				   	
					vo.setStrMode("1");
					bo.getReport(vo);
					
					 /*
			          1.Indent No
			          2.Indent Date - gene By
			          3.Indent Chk value D.HSTNUM_REQ_NO 
						|| ''@'' || D.HSTNUM_STORE_ID  
						|| ''@'' || D.SSTNUM_REQTYPE_ID 
						|| ''@'' || D.SSTNUM_ITEM_CAT_NO 
						|| ''@'' || D.HSTNUM_URGENT_FLAG 
						|| ''@'' || D.HSTSTR_INDENT_PERIOD
						|| ''@'' ||D.HSTNUM_TOSTORE_ID
					  4.Raising Store Name
					  5.PO Dtls ( Supp_Name $ PO No (Date ) $ Catg Name $ Po Type $ RC Dtls)
					  6.PO Net Amount
					  7.Report Generated By 
			        */
					WebRowSet ws1 = vo.getLpDtlsWs();			
					
					if(ws1.next())
					{
						formBean.setStrUserName(ws1.getString(7));
					}
					
					ws1.beforeFirst();
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}					
					formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));									
					response.setContentType("text/html;charset=UTF-8");										
					String strIndentItemList = LPReportsTransHLP.reportHLP(vo, strReportName , request,formBean);				
					
					formBean.setStrViewItemDtls(strIndentItemList);
					
					formBean.setStrTableWidth(vo.getStrTableWidth());				

			
			
		} catch (Exception e) {
			e.printStackTrace();
			String strMsgText = e.getMessage();
		

		}
	}
	
	public static void indentPrint(HttpServletRequest request,HttpServletResponse response,LPReportsTransFB formBean) 
	{
		IndentViewTransBO bo = null;
		IndentViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		
		StringBuffer sb = new StringBuffer("");
		String finalPrint ="";

		
		try 
		{
			bo = new IndentViewTransBO();
			vo = new IndentViewTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				
	          util = new HisUtil("MMSModule", "LPReportsTransDATA");
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			//String strChk = formBean.getStrChk();
			String strChk 		= (String) request.getParameter("strChk")==null?formBean.getStrChk():(String) request.getParameter("strChk");
			
//			//System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

    //		//System.out.println("Req No-->>"+temp1[0]);
    //  	//System.out.println("Store Id-->>"+temp1[1]);
    //		//System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			  
			vo.setStrFinancialEndDate(strFinancialEndDate);
			vo.setStrFinancialStartDate(strFinancialStartDate);
			
            String strTableWidth = "825";
									
			
         	bo.viewData(vo);
         	
         	//Change Request
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if(temp1[2].equals("12") || temp1[2].equals("13") || temp1[2].equals("14") || temp1[2].equals("10"))
			{
				str1=IndentViewTransHLP.getItemDetails1Print(vo);
			}
			else
			{
				
				str1=IndentViewTransHLP.getItemDetailsPrint(vo);
			}	
			
			str3  =  IndentViewTransHLP.getIndentDetailsPrint(vo);			
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
          	
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
			sb.append("<tr> ");
			
			sb.append("<td align='center' colspan='1'>");
			sb.append("</td>");
			
			sb.append("<td align='center' colspan='1'>");			
			sb.append("<img src='/HBIMS/hisglobal/images/aiims_header_22914.png' />");
			sb.append("</td>");
			
			sb.append("<td align='right' colspan='1'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			//sb.append(str3+""+str1+""+str2);
			
			sb.append(str3+""+str1);
			
			finalPrint = sb.toString();
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(finalPrint);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "LPReportsTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LPReportsTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
}