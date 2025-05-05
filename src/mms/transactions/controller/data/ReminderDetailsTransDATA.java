package mms.transactions.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.ReminderDetailsTransBO;
import mms.transactions.controller.fb.ReminderDetailsTransFB;
import mms.transactions.controller.hlp.ReminderDetailsTransHLP;
import mms.transactions.vo.ReminderDetailsTransVO;

public class ReminderDetailsTransDATA {
	
	public static void getStoreDtls(ReminderDetailsTransFB formBean) {

		ReminderDetailsTransBO bo = null;
		ReminderDetailsTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		String strStoreComboId ="";
		String strPOValues ="";
		
		try {
			bo = new ReminderDetailsTransBO();
			vo = new ReminderDetailsTransVO();
			util = new HisUtil("MMS Transactions", "ReminderDetailsTransDATA");
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreDtls(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			/* Changed By Niharika Srivastava on 21-sep-2010*/
			
			if(vo.getStrStoreWs()!= null
					&& vo.getStrStoreWs().size() > 0){
				if(vo.getStrStoreWs().next())
				{
				vo.setStrStoreId(vo.getStrStoreWs().getString(1));
				formBean.setStrStoreId(vo.getStrStoreWs().getString(1));
				vo.getStrStoreWs().beforeFirst();
				}
			
			
			strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "0",
					"", false);
			}
			else{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreValues(strStoreVal);
			
			if(!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
					strStoreComboId = "0";
			vo.setStrStoreId(strStoreComboId);
			
			if (strStoreComboId.equals("0")) 
			{
				strPOValues = "<option value='0'>Select Value</option>";
				formBean.setStrPoValues(strPOValues);
			} 
			else 
			{
				bo.getPONo(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());

				}
				util = new HisUtil("MMS Transactions", "ReminderDetailsTransDATA");
				String temp = "<option value='0'>Select Value</option>";

				if (vo.getStrPONoWs().size() != 0) {
					
					temp = util.getOptionValue(vo.getStrPONoWs(), "0", "0^Select Value",
							true);

				}else{
					
					temp = "<option value='0'>Select Value</option>";
			}
				formBean.setStrPoValues(temp);
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.ReminderDetailsTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReminderDetailsTransDATA->getStoreDtls()", strmsgText);
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
	
	public static void getPONo(ReminderDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReminderDetailsTransBO bo = null;
		ReminderDetailsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReminderDetailsTransBO();
			voObj = new ReminderDetailsTransVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
						
			bo.getPONo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ReminderDetailsTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrPONoWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrPONoWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ReminderDetailsTransDATA.getPONo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReminderDetailsTransDATA->getPONo()", strmsgText);
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
	
	public static void getScheduleNo(ReminderDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReminderDetailsTransBO bo = null;
		ReminderDetailsTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReminderDetailsTransBO();
			voObj = new ReminderDetailsTransVO();
			
			String strPONo = request.getParameter("poNo");
			
			if (strPONo == null)
				strPONo = "0";
			
			String[] strTemp = strPONo.split("\\^");
			
			voObj.setStrStoreId(strTemp[1]);
			voObj.setStrPONo(strTemp[0]);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.getScheduleNo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ReminderDetailsTransDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrScheduleNoWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrScheduleNoWs(), "", "",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ReminderDetailsTransDATA.getScheduleNo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReminderDetailsTransDATA->getScheduleNo()", strmsgText);
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
	
	public static void getPODetails(ReminderDetailsTransFB formBean,HttpServletRequest request, HttpServletResponse response) {
		
		ReminderDetailsTransVO vo = null;
		ReminderDetailsTransBO bo = null;
		String strmsgText = "";
		String strPODetails = "";
				
		try {
			vo = new ReminderDetailsTransVO();
			bo = new ReminderDetailsTransBO();
			
			String strPONO = request.getParameter("poNo");
			if (strPONO == null)
				strPONO = "0";
			
			String[] strTemp = strPONO.split("\\^");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONo(strTemp[0]);
			vo.setStrPOStoreId(strTemp[1]);
			
			bo.getPODetails(vo);
			
			strPODetails = ReminderDetailsTransHLP.getPODetails(vo.getStrPODtlsWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPODetails);
			
		}catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ReminderDetailsTransDATA.getPODetails --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"ReminderDetailsTransDATA->getPODetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}
	
public static void getPrevReminderDtl(ReminderDetailsTransFB formBean,HttpServletRequest request, HttpServletResponse response) {
		
		ReminderDetailsTransVO vo = null;
		ReminderDetailsTransBO bo = null;
		String strmsgText = "";
		String strPrevReminderDtl = "";
				
		try {
			vo = new ReminderDetailsTransVO();
			bo = new ReminderDetailsTransBO();
			
			String strStoreId = request.getParameter("storeId");
			String strScheduleNo = request.getParameter("scheduleNo");
			String strPONO = request.getParameter("strPONo");
			
			if (strStoreId == null)
				strStoreId = "0";
			if (strScheduleNo == null)
				strScheduleNo = "0";
			if (strPONO == null)
				strPONO = "0";
			
			String[] strTemp = strPONO.split("\\^");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPONo(strTemp[0]);
			vo.setStrStoreId(strStoreId);
			vo.setStrScheduleNo(strScheduleNo);
			vo.setStrPOStoreId(strTemp[1]);
			 
			
			bo.getPrevReminderDtl(vo);
			
			strPrevReminderDtl = ReminderDetailsTransHLP.getPrevReminderDtl(vo.getStrPrevReminderDtlWs());
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPrevReminderDtl);
			
		}catch (Exception e) {
			strmsgText = "mms.transactions.ReminderDetailsTransDATA.getPrevReminderDtl --> "
				+ e.getMessage();
			HisException eObj = new HisException("mms",
				"ReminderDetailsTransDATA->getPrevReminderDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}finally{
			
		}

	}

	public static  void insert(ReminderDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response)
	{
			ReminderDetailsTransVO vo = null;
			ReminderDetailsTransBO bo = null;
			String  strmsgText = "";
		try
		{
			 vo=new ReminderDetailsTransVO();
			 bo=new ReminderDetailsTransBO();
			 
			String[] strtemp = formBean.getStrPONo().split("\\^");
		
			vo.setStrStoreId(formBean.getStrStoreId());	
			vo.setStrPONo(strtemp[0]);
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemCatId(formBean.getStrItemCatId());
			vo.setStrPOPrefix(strtemp[2]);
			vo.setStrReminderType(formBean.getStrReminderType());
			vo.setStrSuppId(formBean.getStrSuppId());
			vo.setStrScheduleNo(formBean.getStrScheduleNo());
			vo.setStrPODate(formBean.getStrPODate());
			vo.setStrPOStoreId(strtemp[1]);
			
			bo.insert(vo);
			
			formBean.setStrReminderNo(vo.getStrReminderNo());
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
				
			}else{
				if(formBean.getStrReminderType().equals("1")){
					showReport1(formBean, request, response);
				}else{
					showReport2(formBean, request, response);
				}
				
			}
		}
		catch(Exception e)
		{		
			e.printStackTrace();
		  	strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "ReminderDetailsTransDATA->insert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		}			
	}
	
	public static void showReport1(ReminderDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "pdf";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String reportPath = "/mms/reports/reminderDetails_supplier.rptdesign";
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strReminderNo = formBean.getStrReminderNo();
			String strScheduleNo = formBean.getStrScheduleNo();
			String strStoreId = formBean.getStrStoreId();
			
			String strPONo = formBean.getStrPONo();
			String[] temp = strPONo.split("\\^");
		
			String strReportName = "Reminder Details";
			boolean headerVisible = false;
			
				params.put("report_id", strReportId);
				
				params.put("header_Visible", headerVisible);
				params.put("report_Name", strReportName);
				
				params.put("hosp_Code", strHospitalCode);
				params.put("reminder_No", strReminderNo);
				params.put("schedule_No", strScheduleNo);
				params.put("store_Id", strStoreId);
				params.put("po_StoreId", temp[1]);
				params.put("po_No", temp[0]);
				
//			ts.displayReport(request, response, reportPath, reportFormat,
//						params);
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void showReport2(ReminderDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "pdf";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String reportPath = "/mms/reports/reminderDetails_purchase.rptdesign";
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strReminderNo = formBean.getStrReminderNo();
			String strScheduleNo = formBean.getStrScheduleNo();
			String strStoreId = formBean.getStrStoreId();
			
			String strPONo = formBean.getStrPONo();
			String[] temp = strPONo.split("\\^");
			
			String strReportName = "Reminder Details";
			boolean headerVisible = false;
			
				params.put("report_id", strReportId);
				
				params.put("header_Visible", headerVisible);
				params.put("report_Name", strReportName);
				
				params.put("hosp_Code", strHospitalCode);
				params.put("reminder_No", strReminderNo);
				params.put("schedule_No", strScheduleNo);
				params.put("store_Id", strStoreId);
				params.put("po_StoreId", temp[1]);
				params.put("po_No", temp[0]);
				
//			ts.displayReport(request, response, reportPath, reportFormat,
//						params);
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
