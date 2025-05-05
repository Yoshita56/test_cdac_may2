package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.MiscellaneousIgimsRptBO;
import mms.reports.controller.fb.MiscellaneousIgimsRptFB;
import mms.reports.controller.hlp.MiscellaneousIgimsRptHLP;
import mms.reports.vo.MiscellaneousIgimsRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptData.
 */
public class MiscellaneousIgimsRptDATA {

	/**
	 * Sets the init dtl.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void setInitDtl(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request) {

		MiscellaneousIgimsRptVO vo = null;
		MiscellaneousIgimsRptBO bo = null;
		String strCurrentDate = "";
		String strItemVal = "";
		String strStoreVal = "";
		HisUtil util = null;

		try 
		{
			System.out.println("---------MiscellaneousIgimsRptDATA.setInitDtl---------"); 
			
			bo = new MiscellaneousIgimsRptBO();
			vo = new MiscellaneousIgimsRptVO();

			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.getItemCateg(vo);
			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				util = new HisUtil("Issue Listing Report", "ItemListingRptData");
				strCurrentDate = util.getASDate("dd-MMM-yyyy");
				formBean.setStrCurrentDate(strCurrentDate);

				if (vo.getItemCategWS() != null && vo.getItemCategWS().size() > 0) 
				{
					strItemVal = util.getOptionValue(vo.getItemCategWS(), "0","0^All", false);
				} 
				else 
				{
					strItemVal = util.getOptionValue(vo.getItemCategWS(), "0","-1^Select Value", false);
				}
				
				
				if (vo.getStrWS() != null && vo.getStrWS().size() > 0) 
				{
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","0^All", false);
				} 
				else 
				{
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","-1^Select Value", false);
				}

				// strStoreVal=util.getOptionValue(vo.getStrWS(), "","", false);
				formBean.setStrItemCategCmb(strItemVal);
				formBean.setStrStoreCmb(strStoreVal);
			//	formBean.setStrStoreVal(strStoreVal);
			//	formBean.setStrStoreId(vo.getStrStoreId());
				//setItemCategCombo(formBean, request);
				
				//System.out.println("---------strItemVal---------"+strItemVal); 
				//System.out.println("---------strStoreVall---------"+strStoreVal); 
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDetailRptData->setInitDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {

		}

	}

	/**
	 * Sets the item categ combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void setItemCategCombo(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request) {

		MiscellaneousIgimsRptVO vo = null;
		MiscellaneousIgimsRptBO bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new MiscellaneousIgimsRptBO();
			vo = new MiscellaneousIgimsRptVO();

			vo.setStrHospCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(formBean.getStrStoreId());

			
			if (vo.getStrStoreId().equals("0"))
				vo.setStrMode("1");

			else
				vo.setStrMode("2");

			bo.getItemCateg(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");
				strItemVal = util.getOptionValue(vo.getItemCategWS(), "0",
						"0^All", false);
				formBean.setStrItemCategCmb(strItemVal);

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"IssueDetailRptData->setItemCategComboDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

		}
	}

	/**
	 * Sets the item categ combo dtl.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void setItemCategComboDtl(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousIgimsRptVO vo = null;
		MiscellaneousIgimsRptBO bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new MiscellaneousIgimsRptBO();
			vo = new MiscellaneousIgimsRptVO();

			vo.setStrHospCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			bo.getItemCateg(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");
				strItemVal = util.getOptionValue(vo.getItemCategWS(), "0",
						"0^All", false);
				response.getWriter().print(strItemVal);

			}

		}

		catch (Exception e) {

			strmsgText = "IssueDetailRptData.setItemCategComboDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"IssueDetailRptData->setItemCategComboDtl()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}
		}
	}

	/**
	 * Sets the drug name combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void setDrugNameCombo(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousIgimsRptVO vo = null;
		MiscellaneousIgimsRptBO bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strDrugVal = "";

		try {
			bo = new MiscellaneousIgimsRptBO();
			vo = new MiscellaneousIgimsRptVO();

			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrCategoryNo(request.getParameter("catId"));
			vo.setStrStoreId(request.getParameter("storeId"));
			bo.getDrugNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");

				strDrugVal = util.getOptionValue(vo.getStrItemNameComboWS(),"0", "0^All", false);
				response.getWriter().print(strDrugVal);

			}
		} catch (Exception e) {

			strmsgText = "IssueDetailRptData.setDrugNameCombo() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"IssueDetailRptData->setDrugNameCombo()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}
		}
	}

	/**
	 * Gets the programme combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousIgimsRptBO bo = null;
		MiscellaneousIgimsRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String storeId = "";
		String strProgCmb = "";

		try {
			util = new HisUtil("MMS Reports", "IssueDetailRptDATA");
			bo = new MiscellaneousIgimsRptBO();
			voObj = new MiscellaneousIgimsRptVO();

			storeId = (String) request.getParameter("storeId");
			voObj.setStrHospCode(formBean.getStrHospCode());
			voObj.setStrStoreId(storeId);
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			bo.getProgrammeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrProgNameComboWS() != null
					&& voObj.getStrProgNameComboWS().size() > 0) {
				strProgCmb = util.getOptionValue(voObj.getStrProgNameComboWS(),
						"0", "0^All", true);
			} else {
				strProgCmb = "0^All";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strProgCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.IssueDetailRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDetailRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR####Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

			}
			eObj = null;
		} finally {
			if (voObj != null)
				voObj = null;
			if (formBean != null)
				formBean = null;
			util = null;
		}
	}

	/**
	 * To get values of Existing Batch Number for Selected Drug.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the existing batch list
	 */

	public static void getExistingBatchList(MiscellaneousIgimsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		MiscellaneousIgimsRptBO bo = null;
		MiscellaneousIgimsRptVO vo = null;

		try {
			bo = new MiscellaneousIgimsRptBO();
			vo = new MiscellaneousIgimsRptVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String itemId = "0";
			String strStoreId = (String) request.getParameter("storeId");
			String strItemBrandId = (String) request.getParameter("strItemBrandId");
			String strCatNo = (String) request.getParameter("catId");
			HisUtil hisutil = new HisUtil("mms", "IssueDetailRptDATA");

			vo.setStrStoreId(strStoreId);
			vo.setStrCategoryNo("10");
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrCategoryNo(strCatNo);

			vo.setStrHospCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			vo.setStrMode("3");
			bo.getExistingBatchList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String cmbstr;
			if (vo.getStrExistingBatchComboWS() != null
					&& vo.getStrExistingBatchComboWS().size() > 0) {
				cmbstr = hisutil.getOptionValue(
						vo.getStrExistingBatchComboWS(), "", "0^All", false);
			} else {
				cmbstr = "<option value='0'>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.IssueDetailRptDATA.getExistingBatchList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDetailRptDATA->getExistingBatchList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * Show report.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void showReport(MiscellaneousIgimsRptFB formBean,HttpServletRequest request, HttpServletResponse response) {
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";
		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			/*String strCatCode = formBean.getStrItemCategNo();*/
			String strCatCode =  formBean.getStrItemCatId();
			String strStoreCode =  formBean.getStrStoreId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
              //System.out.println("strFromDate::::"+strFromDate);
              //System.out.println("strFromDate::::"+strToDate);
            ;
			reportFormat = formBean.getStrReportFormat();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;
			}
			String strReportName = "Miscellaneous Consumption  Report";
			params.put("report_id", strReportId);         
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("hospCode", strHospitalCode);
			params.put("catCode", strCatCode);
			params.put("storeId", strStoreCode);
			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));
			//params.put("isMisc", strIsMisc);
			//params.put("isQuant", strIsQuant);
			// For Store
				String reportPath = "/mms/reports/misc_Consum_rpt.rptdesign";
				// String reportPath =
				// "/mms/reports/issueDetail_mmsrpt.rptdesign";
				ts.displayReport(request, response, reportPath, reportFormat,params, strHospitalCode);
				// For Employee
		} catch (Exception e) {

			e.printStackTrace();
			String strmsgText = "mms.transactions.ThirdPartyIssueReqTransDATA.insertNew() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ThirdPartyIssueReqTransDATA->insertNew()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}
	}
	
	public static void showReportNew(MiscellaneousIgimsRptFB formbean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       MiscellaneousIgimsRptVO vo = null;
	       MiscellaneousIgimsRptBO bo = null;
		   ReportUtil ts = new ReportUtil();		

		   String strReportName = "";
		   String strStoreId = "";
		  
		  // Map<String, Object> params = new HashMap<String, Object>();
			try 
			{	
		
			   String strResult="";
			    vo=new MiscellaneousIgimsRptVO();
			   	bo=new MiscellaneousIgimsRptBO();
			   	
			   	String strHospitalCode = vo.getStrHospCode();
			   	
			   	vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			    vo.setStrItemCatId(request.getParameter("strCategoryId")); 	//strCategoryId
				
			   	vo.setStrFromDate((String) request.getParameter("strFromDate"));
				vo.setStrToDate((String) request.getParameter("strToDate"));
				
				vo.setStrStoreName(request.getParameter("storeName"));//storeName
				System.out.println("vo.setStrStoreName---------------------------- "+request.getParameter("storeName"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); //strCategoryName
				
				vo.setStrCrNo(formbean.getStrCrNo());
				System.out.println("vo.setStrCrNo---------------------------- "+formbean.getStrCrNo());
				bo.setViewPageDtl(vo);

				strResult=MiscellaneousIgimsRptHLP.getMiscellaneousConsDetails(vo);
			 
				if(vo.getStrItemCatId()!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}
				 else{
				    HisException eObj = new HisException("MMS", "MiscItemListingRptDATA_NEW->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "MiscItemListingRptDATA_NEW->getViewDtl()", strmsgText);
				formbean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}


}
