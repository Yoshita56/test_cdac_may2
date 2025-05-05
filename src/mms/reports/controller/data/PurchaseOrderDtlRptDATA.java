package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.PurchaseOrderDtlRptBO;
import mms.reports.controller.fb.PurchaseOrderDtlRptFB;
import mms.reports.vo.PurchaseOrderDtlRptVO;


public class PurchaseOrderDtlRptDATA {
	
	public static void initDetails(PurchaseOrderDtlRptFB formBean, HttpServletRequest request)
	{

		PurchaseOrderDtlRptBO bo = null;
		PurchaseOrderDtlRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strHospName="";
		
		try {

			bo = new PurchaseOrderDtlRptBO();
			voObj = new PurchaseOrderDtlRptVO();
			
			String strUserLevel ="1";// request.getSession().getAttribute("USER_LEVEL").toString();
			
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "10";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrMode("1");
			
			bo.getHospitalName(voObj);
			
			
			util = new HisUtil("MMS", "PurchaseOrderDtlRptDATA");
			strHospName= util.getOptionValue(voObj.getStrHospitalWs(),"","", false);
			
			formBean.setStrHospNameValues(strHospName);
			
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
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
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getSupplierList()", strmsgText);
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
	
	
	public static void getStoreList(PurchaseOrderDtlRptFB formBean, HttpServletRequest request) {

		PurchaseOrderDtlRptBO bo = null;
		PurchaseOrderDtlRptVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		
		try {
			bo = new PurchaseOrderDtlRptBO();
			vo = new PurchaseOrderDtlRptVO();
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			
			strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "0", "0^Select Value", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(PurchaseOrderDtlRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO bo = null;
		PurchaseOrderDtlRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO();
			voObj = new PurchaseOrderDtlRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
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
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getPOTypeList(PurchaseOrderDtlRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO bo = null;
		PurchaseOrderDtlRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO();
			voObj = new PurchaseOrderDtlRptVO();
			
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
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
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
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getPOTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getPOTypeList()", strmsgText);
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
	
	public static void getSupplierList(PurchaseOrderDtlRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO bo = null;
		PurchaseOrderDtlRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO();
			voObj = new PurchaseOrderDtlRptVO();
			
			
			String strItemCatNo = request.getParameter("itemcat");
			
			if (strItemCatNo == null)
				strItemCatNo = "0";
			
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
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
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getSupplierList()", strmsgText);
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
	public static void showReport(PurchaseOrderDtlRptFB formBean,HttpServletRequest request, HttpServletResponse response)
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
}