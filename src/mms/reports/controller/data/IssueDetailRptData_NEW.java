/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.IssueDetailRptBO_NEW;
import mms.reports.controller.fb.IssueDetailRptFB_NEW;
import mms.reports.controller.hlp.IssueDetailRptHLP_NEW;
import mms.reports.vo.IssueDetailRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptData.
 */
public class IssueDetailRptData_NEW {

	/**
	 * Sets the init dtl.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void setInitDtl(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request) {

		IssueDetailRptVO_NEW vo = null;
		IssueDetailRptBO_NEW bo = null;
		String strCurrentDate = "";
		String strStoreVal = "";
		HisUtil util = null;

		try {
			bo = new IssueDetailRptBO_NEW();
			vo = new IssueDetailRptVO_NEW();

			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.getInitDtl(vo);
			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");
				strCurrentDate = util.getASDate("dd-MMM-yyyy");
				formBean.setStrCurrentDate(strCurrentDate);

				if (vo.getStrWS() != null && vo.getStrWS().size() > 0) 
				{
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","0^All", false);
				} 
				else 
				{
					strStoreVal = util.getOptionValue(vo.getStrWS(), "0","-1^Select Value", false);
				}

				// strStoreVal=util.getOptionValue(vo.getStrWS(), "","", false);

				formBean.setStrStoreVal(strStoreVal);
				formBean.setStrStoreId(vo.getStrStoreId());
				//setItemCategCombo(formBean, request);
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
	public static void setItemCategCombo(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request) {

		IssueDetailRptVO_NEW vo = null;
		IssueDetailRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new IssueDetailRptBO_NEW();
			vo = new IssueDetailRptVO_NEW();

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
	public static void setItemCategComboDtl(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueDetailRptVO_NEW vo = null;
		IssueDetailRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new IssueDetailRptBO_NEW();
			vo = new IssueDetailRptVO_NEW();

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
	public static void setDrugNameCombo(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueDetailRptVO_NEW vo = null;
		IssueDetailRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strDrugVal = "";

		try {
			bo = new IssueDetailRptBO_NEW();
			vo = new IssueDetailRptVO_NEW();

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
	public static void getProgrammeCombo(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueDetailRptBO_NEW bo = null;
		IssueDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String storeId = "";
		String strProgCmb = "";

		try {
			util = new HisUtil("MMS Reports", "IssueDetailRptDATA");
			bo = new IssueDetailRptBO_NEW();
			voObj = new IssueDetailRptVO_NEW();

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

	public static void getExistingBatchList(IssueDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		IssueDetailRptBO_NEW bo = null;
		IssueDetailRptVO_NEW vo = null;

		try {
			bo = new IssueDetailRptBO_NEW();
			vo = new IssueDetailRptVO_NEW();

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
	public static void showReport(IssueDetailRptFB_NEW formBean,HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{

			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			/*String strCatCode = formBean.getStrItemCategNo();*/
			String strCatCode =  formBean.getStrItemCatId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strStoreId = formBean.getStrStoreId();

			String strItemBrandId = (formBean.getStrItemBrandId() == null || formBean.getStrItemBrandId().equals("")) ? "0" : formBean.getStrItemBrandId();
			String strBatchNo = (formBean.getStrBatchNo() == null || formBean.getStrBatchNo().equals("")) ? "0" : formBean.getStrBatchNo();

			reportFormat = formBean.getStrReportFormat();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;

			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;

			}
		
			String strReportName = "Sale/Issue Register";
			
			params.put("report_id", strReportId);         
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("hospCode", strHospitalCode);
			params.put("storeId", strStoreId);
			params.put("itemid", strItemBrandId);
			params.put("batchno",  strBatchNo);
			params.put("prog_id", "0");
			params.put("catCode", strCatCode);    
			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));
			
			
			// For Store
			

				String reportPath = "/mms/reports/IssueDetailRpt_mmsrpt_new.rptdesign";
			//System.out.println("Entered into the Report");
				//String reportPath = "/mms/reports/IssueDetailRpt_mmsrpt_new_new.rptdesign";
				// String reportPath =
				// "/mms/reports/issueDetail_mmsrpt.rptdesign";
				System.out.println("reportPath----"+reportPath);
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
	
	public static void showReport1(IssueDetailRptFB_NEW formBean,HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			
			/*NetClientGet clientGet=new NetClientGet();
			String output=clientGet.getData();
			//System.out.println("Json ===>> "+ output);
			
			JSONObject object = new JSONObject(output);
			//System.out.println("source source source"+object.getString("source"));
			
			JSONArray getArray = object.getJSONArray("data");
			//System.out.println("asasdasd"+getArray.length());
			////System.out.println("arrau image"+getArray.getString(0));
			String strReportName = "Sale/Issue Register";
			String image="";
			
			for (int i = 0; i < getArray.length(); i++) {
	            JSONObject objects = getArray.getJSONObject(i);
	            Iterator key = objects.keys();
	            while (key.hasNext()) {
	                String k = key.next().toString();
	                if(k.equalsIgnoreCase("HRGBYTE_IMAGE"))
	                {
	                	//System.out.println("Key : " + k + ", value : " + objects.getString(k));
	                	image=objects.getString(k);
	                }
	                
	            }
	            // //System.out.println(objects.toString());
	            //System.out.println("-----------");

	        }
			 String string= new String(Base64.decodeBase64(image));
			//System.out.println("Base64.decodeBase64(image)"+string);
			*/
			//System.out.println("iamge reydfsdf ");
			params.put("report_id", "dsfdsf");         
			params.put("report_Name", "sdfsdf");
			params.put("report_Footer_Visible", true);
			params.put("report_user_Remarks", "");
		
			
			
			// For Store
			

				String reportPath = "/mms/reports/IssueDetailRpt_mmsrpt_new1.rptdesign";
				// String reportPath =
				// "/mms/reports/issueDetail_mmsrpt.rptdesign";

				ts.displayReport(request, response, reportPath, reportFormat,params, "33101");
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
	
	public static void showReportNew(IssueDetailRptFB_NEW formBean,HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		IssueDetailRptVO_NEW vo = null;
		IssueDetailRptBO_NEW bo = null;
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try 
		{
			vo = new IssueDetailRptVO_NEW();
			bo = new IssueDetailRptBO_NEW();
			String strReportId = formBean.getStrReportId();
			/*String strCatCode = formBean.getStrItemCategNo();*/
			String strCatCode =  formBean.getStrItemCatId();
			String strUserRemarks = formBean.getStrUserRemarks();

			String strItemBrandId = (formBean.getStrItemBrandId() == null || formBean.getStrItemBrandId().equals("")) ? "0" : formBean.getStrItemBrandId();
			String strBatchNo = (formBean.getStrBatchNo() == null || formBean.getStrBatchNo().equals("")) ? "0" : formBean.getStrBatchNo();

			reportFormat = formBean.getStrReportFormat();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String strStoreId = (String) request.getParameter("storeId");
			String strCategoryNo = (String) request.getParameter("catId");
			String strFromDate = (String) request.getParameter("fromDate");
			String strToDate = (String) request.getParameter("toDate");
			String strStoreName = (String) request.getParameter("storeName");
			String strItemCategoryName = (String) request.getParameter("categoryName");
			
			System.out.println("strStoreId ---"+strStoreId);
			System.out.println("strCategoryNo ---"+strCategoryNo);
			System.out.println("strFromDate ---"+strFromDate);
			System.out.println("strToDate ---"+strToDate);
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(strStoreId);
			vo.setStrCategoryNo(strCategoryNo);
			vo.setStrFromDate(strFromDate);
			vo.setStrToDate(strToDate);
			vo.setStrStoreName(strStoreName);
			vo.setStrItemCategoryName(strItemCategoryName);
			bo.showReportNew(vo);
			
			String hlpString = IssueDetailRptHLP_NEW.generateReport(vo);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(hlpString);

		} catch (Exception e) {

			e.printStackTrace();
			String strmsgText = "mms.transactions.IssueDetailRptData_NEW.showReportNew() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDetailRptData_NEW->showReportNew()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}
	}

}
