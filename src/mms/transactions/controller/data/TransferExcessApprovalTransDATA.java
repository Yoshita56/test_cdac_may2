/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.data;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.TransferExcessApprovalTransBO;
import mms.transactions.controller.fb.TransferExcessApprovalTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.TransferExcessApprovalTransHLP;
import mms.transactions.vo.TransferExcessApprovalTransVO;


/**
 * The Class TransferExcessApprovalTransDATA.
 */
public class TransferExcessApprovalTransDATA {

	/** The date format with time. */
	public static String dateFormatNowWt = "dd-MMM-yyyy HH:mm:ss";

	/** The date format. */
	public static String dateFormatNow = "dd-MMM-yyyy";

	/**
	 * Now.
	 * 
	 * @param frmt the format
	 * @return the string
	 */
	public static String now(String frmt) {
		HisUtil util = null;
		String a = "";
		util = new HisUtil("transaction", "TransferExcessApprovalTransHLP");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	/**
	 * Initial approval.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void initialApproval(TransferExcessApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		TransferExcessApprovalTransBO bo = null;
		TransferExcessApprovalTransVO vo = null;
		String strStoreName = "", path = "", strTranAppItemDtl = "";
		String str2 = "",str3 = "";	
		try {
			bo = new TransferExcessApprovalTransBO();
			vo = new TransferExcessApprovalTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());
			formBean.setStrStoreName(strStoreName);

			String strChk = request.getParameter("chk");
			String[] temp = strChk.split("\\@");
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(temp[1]);
			vo.setStrItemCategoryNo(temp[3]);
			vo.setStrRequestNo(temp[4]);

			// Calling BO Method
			bo.initialApproval(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			response.setContentType("text/html;charset=UTF-8");
			strTranAppItemDtl = TransferExcessApprovalTransHLP.getDrugDetails(vo,request);
			formBean.setStrTransferOrderDetails(strTranAppItemDtl);
			str3 = TransferExcessApprovalTransHLP.getIndentDetails(vo,request);			
			str2 = ApprovalDtlHLP.getApprovalDtlNew(vo.getStrStoreId(), vo.getStrHospitalCode(), temp[6].split("\\$")[0], vo.getStrRequestNo(),request);
			formBean.setStrTransferOrderDetails(strTranAppItemDtl);
			formBean.setStrIndentDetails(str3);
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrRequestNo(vo.getStrRequestNo());
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrApprovedByCombo(vo.getStrApprovedByCombo());
			formBean.setStrReqDate(now(dateFormatNowWt));
			formBean.setStrCtDate(now(dateFormatNow));
			formBean.setStrApprovalFlag(vo.getStrApprovalFlag());

		} catch (Exception e) {
			e.printStackTrace();
            HisException eObj = new HisException("eAushadhi", "TransferExcessApprovalTransDATA.initialApproval()", e.getMessage());	
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static boolean insertRecord(TransferExcessApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TransferExcessApprovalTransBO bo = null;
		TransferExcessApprovalTransVO vo = null;
		String hosCode = "";
		String seatid = "";
		String ipAddr = "";
		String strChk = "";
		boolean retValue = true;

		try {
			bo = new TransferExcessApprovalTransBO();
			vo =new TransferExcessApprovalTransVO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			ipAddr = request.getSession().getAttribute("IP_ADDR").toString();
			strChk = request.getParameter("strChk");
			/* PK->>    Level Type     --0 
		       @ Store Id       --1
		       @ To Store Id    --2
		       @ Catg           --3 
		       @ Req No         --4
		       @ Req Type       --5
		       @ Req Status     --6
		       @ User Id        --7
		       @ User Level     --8
		       @ c.app_flag     --9
		       @ c.re_app_flag  --10
		       @ c.approval_no  --11
		       @ c.Request Date --12 */
			String[] temp = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg = temp[3];
			String strReqNo = temp[4];
			String strReqTypeId = temp[5];
			String strReqStatus = temp[6];
			String strUserId = temp[7];
			String strUserLevel = temp[8];
			String[] temp1 = temp[12].split("\\$");
			vo.setStrRequestDate(temp1[0]);
			
			vo.setStrApprovalNo(temp[11]);

			vo.setStrReqStatus(strReqStatus);
			vo.setStrUserLevel(strUserLevel);
			vo.setStrUserId(strUserId);
			vo.setStrLevelType(strLevelType);
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIpAddr(ipAddr);
			
			vo.setStrApprovalType(formBean.getStrApprovalFlag());						
			vo.setStrInsertHiddenValue(formBean.getStrInsertHiddenValue());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrInsSancQty(formBean.getStrInsSancQty());			
			vo.setStrItemRemarks(formBean.getStrItemRemarks());
			vo.setStrPrimaryKey(formBean.getStrPrimaryKey());
			vo.setStrReApprovalFlag(formBean.getStrReApprovalFlag());
			// Calling BO Method
			bo.INSERT(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			} else {
				String strStatus ="";
				if( vo.getStrApprovalType().equals("1"))
				{
					if(vo.getStrReApprovalFlag().equals("1"))
					{
					  strStatus = "Re-Approved";
					}	
					else
					{	
					  strStatus = "Approved";
					}  
				}
				else
				{
					strStatus = "Rejected";
				}
				   
				formBean.setStrErrMsg("Saved Successfully");
				/*
				AlertMessageServiceCall.addMessage(
						"TR114",
						vo.getStrStoreId(),
						null,
						null,
						null,
						vo.getStrReqNo(),
						"Transfer Excess No & Date [ "
								+ vo.getStrReqNo() + " / "+vo.getStrRequestDate()+" ] for transfer of [ " +vo.getStrInsertHiddenValue().length+ " ] drug(s)   has been successfully " +
										""+strStatus+" by User [ "+request.getSession().getAttribute("UserFullName").toString()+" ]", null,
						Integer.parseInt(hosCode),
						Integer.parseInt(seatid), request.getSession().getAttribute("UserFullName").toString());
						*/
				
			}
			

		} catch (Exception e) {
			retValue = false;
			e.printStackTrace();
            HisException eObj = new HisException("eAushadhi", "TransferExcessApprovalTransDATA.insertRecord()", e.getMessage());	
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;

		} finally {

			bo = null;
			vo = null;

		}
		return retValue;
	}
	
	
	public static void viewData(TransferExcessApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		TransferExcessApprovalTransBO bo = null;
		TransferExcessApprovalTransVO vo = null;
		String str1 = "";
		String str2 = "";
		String str3 = "";
		try {
			bo = new TransferExcessApprovalTransBO();
			vo = new TransferExcessApprovalTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);

			String strChk = formBean.getStrChk();
			// PK->> Level Type @ Store Id @ To Store Id @ Catg @ Req No @ Req Type @ Req Status @ User Id @ User Level
			String[] temp = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg = temp[3];
			String strReqNo = temp[4];
			String strReqTypeId = temp[5];
			String strReqStatus = temp[6];
			String strUserId = temp[7];
			String[] temp1 = temp[8].split("\\$");
			String strUserLevel = temp1[0];

			vo.setStrReqStatus(strReqStatus);
			vo.setStrUserLevel(strUserLevel);
			vo.setStrUserId(strUserId);
			vo.setStrLevelType(strLevelType);
			vo.setStrRequestNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			//formBean.setStrLevelType(strLevelType);

			

			bo.viewData(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			response.setContentType("text/html;charset=UTF-8");
			str1 = TransferExcessApprovalTransHLP.excessItemDtlView(vo,request);
			str2 = ApprovalDtlHLP.getApprovalDtlNew(vo.getStrStoreId(), vo.getStrHospitalCode(), temp[6].split("\\$")[0], vo.getStrReqNo(),request);
			formBean.setStrSetApprovedDetails(str2);
			str3 = TransferExcessApprovalTransHLP.getIndentDetails(vo,request);

			formBean.setStrTransferOrderDetails(str1);			
			formBean.setStrIndentDetails(str3);
			formBean.setStrSetApprovedDetails(str2);

		} catch (Exception e) {
			e.printStackTrace();
            HisException eObj = new HisException("eAushadhi", "TransferExcessApprovalTransDATA.viewData()", e.getMessage());	
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	

	/**
	 * Generate pdf.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void generatePdf(TransferExcessApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strSearchItemInitView = "";
		try {

			String strHtmlCode = formBean.getStrRemarks();
			strHtmlCode = strHtmlCode.replace("width=\"800\"", "width='650'");
			strSearchItemInitView = "<html><body></body></html>";
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=" + formBean.getStrChk().split("\\$")[0] + ".pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strSearchItemInitView);

		} catch (Exception e) {
			e.printStackTrace();
            HisException eObj = new HisException("eAushadhi", "TransferExcessApprovalTransDATA.generatePdf()", e.getMessage());	
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;

		}
	}

}
