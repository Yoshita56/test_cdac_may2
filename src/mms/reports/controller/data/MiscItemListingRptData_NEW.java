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
import mms.reports.bo.MiscItemListingRptBO_NEW;
import mms.reports.controller.fb.MiscItemListingRptFB_NEW;
import mms.reports.controller.hlp.MiscItemListingRptHLP_NEW;
import mms.reports.vo.MiscItemListingRptVO_NEW;

public class MiscItemListingRptData_NEW {

	
	public static void setInitDtl(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request) {

		MiscItemListingRptVO_NEW vo = null;
		MiscItemListingRptBO_NEW bo = null;
		String strCurrentDate = "";
		String strItemVal = "";
		String strStoreVal = "";
		HisUtil util = null;

		try {
			bo = new MiscItemListingRptBO_NEW();
			vo = new MiscItemListingRptVO_NEW();

			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
//			bo.getItemCateg(vo);
			bo.getInitDtl(vo);

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

				formBean.setStrItemCategCmb(strItemVal);
				formBean.setStrStoreCmb(strStoreVal);
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

	public static void setItemCategCombo(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request) {

		MiscItemListingRptVO_NEW vo = null;
		MiscItemListingRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new MiscItemListingRptBO_NEW();
			vo = new MiscItemListingRptVO_NEW();

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
	public static void setItemCategComboDtl(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscItemListingRptVO_NEW vo = null;
		MiscItemListingRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strItemVal = "";

		try {
			bo = new MiscItemListingRptBO_NEW();
			vo = new MiscItemListingRptVO_NEW();

			vo.setStrHospCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			bo.getItemCateg(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				util = new HisUtil("Issue Detail Report", "IssueDetailRptData");
				strItemVal = util.getOptionValue(vo.getItemCategWS(), "0","0^All", false);
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

	public static void groupName(MiscItemListingRptFB_NEW formBean,HttpServletRequest request,
			HttpServletResponse response) {
		MiscItemListingRptVO_NEW vo=null;
		MiscItemListingRptBO_NEW bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String strGrpCmb = "";
		
			
		try {
			hisutil = new HisUtil("MMS","ItemWiseConsumptionRptDATA");
			vo = new MiscItemListingRptVO_NEW();
			bo = new MiscItemListingRptBO_NEW();
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			itemCatNO = (String) request.getParameter("strCategoryId");
			
					
			formBean.setStrHospCode(hosCode);
			formBean.setStrItemCatId(itemCatNO);
			
			vo.setStrHospCode(hosCode);
			vo.setStrItemCatId(itemCatNO);
				
			bo.getGroupName(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getGroupIdWS()!=null && vo.getGroupIdWS().size() > 0){			
				strGrpCmb = hisutil.getOptionValue(vo.getGroupIdWS(),"", "0^All", true);
			}else {
				strGrpCmb = "<option value='0'>All</option>";
			}
			
			try {									
				response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strGrpCmb);
					
				}catch(Exception e){
					
				}
			
									
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ItemWiseConsumptionRptDATA->groupName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
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
	public static void setDrugNameCombo(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscItemListingRptVO_NEW vo = null;
		MiscItemListingRptBO_NEW bo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strDrugVal = "";

		try {
			bo = new MiscItemListingRptBO_NEW();
			vo = new MiscItemListingRptVO_NEW();

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
	public static void getProgrammeCombo(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscItemListingRptBO_NEW bo = null;
		MiscItemListingRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String storeId = "";
		String strProgCmb = "";

		try {
			util = new HisUtil("MMS Reports", "IssueDetailRptDATA");
			bo = new MiscItemListingRptBO_NEW();
			voObj = new MiscItemListingRptVO_NEW();

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

	public static void getExistingBatchList(MiscItemListingRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		MiscItemListingRptBO_NEW bo = null;
		MiscItemListingRptVO_NEW vo = null;

		try {
			bo = new MiscItemListingRptBO_NEW();
			vo = new MiscItemListingRptVO_NEW();

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
	public static void showReport(MiscItemListingRptFB_NEW formBean,HttpServletRequest request, HttpServletResponse response) {
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
	
	public static void showReportNew(MiscItemListingRptFB_NEW formbean,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       MiscItemListingRptVO_NEW vo = null;
	       MiscItemListingRptBO_NEW bo = null;
		   ReportUtil ts = new ReportUtil();		

		   String strReportName = "";
		   String strStoreId = "";
		  
		  // Map<String, Object> params = new HashMap<String, Object>();
			try 
			{	
		
			   String strResult="";
			    vo=new MiscItemListingRptVO_NEW();
			   	bo=new MiscItemListingRptBO_NEW();
			   	
			   	String strHospitalCode = vo.getStrHospCode();
			   	
			   	vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			   	
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			    vo.setStrItemCatId(request.getParameter("strCategoryId")); 	//strCategoryId
				
			    vo.setStrGroupId(request.getParameter("strGroupId")); 	//strCategoryId

			   	vo.setStrFromDate((String) request.getParameter("strFromDate"));
				vo.setStrToDate((String) request.getParameter("strToDate"));
				
				vo.setStrStoreName(request.getParameter("storeName"));//storeName
				System.out.println("vo.setStrStoreName---------------------------- "+request.getParameter("storeName"));
				vo.setStrCategoryName(request.getParameter("strCategoryName")); //strCategoryName
				
				vo.setStrReportFormat(request.getParameter("strReportFormat")); 
				
				bo.setViewPageDtl(vo);

				strResult=MiscItemListingRptHLP_NEW.getMiscellaneousConsDetails(vo);
			 
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
	
	
	public static void showReport1(MiscItemListingRptFB_NEW formBean,HttpServletRequest request, HttpServletResponse response) {

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

}
