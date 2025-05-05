/**
 * 
 */
package mms.transactions.controller.data;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDeskTransBO;
import mms.transactions.controller.fb.IssueDeskTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.IssueDeskTransHLP;
import mms.transactions.dao.IssueDeskTransDAO;
import mms.transactions.vo.IssueDeskTransVO;


/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */


public class IssueDeskTransDATA 
{
	public static void indentAppPrint(HttpServletRequest request,HttpServletResponse response,IssueDeskTransFB formBean) 
	{
		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";		
		StringBuffer sb = new StringBuffer("");
		String finalPrint = "";
		String temp[]=null;
		try 
		{
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();				 
			String seatId  = request.getSession().getAttribute("SEATID").toString();
		
	       
			String strChk       		= (String) request.getParameter("strChk");			
			String strStoreId   		= (String) request.getParameter("strStoreId");
			String strReqTypeId 		= (String) request.getParameter("strReqTypeId");
			String strItemCategoryNo    = (String) request.getParameter("strItemCategoryNo");
			
			
			
		    System.out.println("strChk-----------"+strChk); 
		    /* 
		     * hstnum_req_no
		     * ||'@'||hstnum_store_id [ Raising Store Id]
		     * ||'@'||A.gnum_hospital_code
		     * ||'@'||a.hstnum_urgent_flag
		     * ||'@'||a.hstnum_urgent_flag
		     * 
		     */
		
			temp=strChk.replace('@', '#').split("#");		
			
					
			vo.setStrIndentNo(temp[0]);
			vo.setStrStoreId(strStoreId);		
			vo.setStrRaisingStoreId(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);	
			vo.setStrItemCategoryNo(strItemCategoryNo);
			if(strReqTypeId.equals("31"))
			{
			    vo.setStrReqTypeId("17");
			}
			else
			{
				vo.setStrReqTypeId(strReqTypeId);
			}
						
					
			System.out.println("----- IssueDeskTransDATA . indentAppPrint ----Req_type---"+vo.getStrRequestTypeId());
			
			String strTableWidth = "825";
			
			vo.setStrTableWidth(strTableWidth);

			
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			  
				
			 
		    str1 = IssueDeskTransHLP.getItemDetailsViewPrint(vo);
					
			                                           // strFrmStoreId          , strHospCode            , strToStoreId      , strItemCatgCode  , strReqTypeId        , strReqNo
			str2  =  ApprovalDtlHLP.getApprovalDtlPrint(vo.getStrRaisingStoreId(), vo.getStrHospitalCode(), vo.getStrStoreId(), strItemCategoryNo, vo.getStrReqTypeId(), vo.getStrIndentNo());
			
				
			str3 = IssueDeskTransHLP.getIndentDetailsViewPrint(vo);
				   
			
			
			
			HisUtil 		 hisUtil = new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(hosCode);
			
            //sb.append("<style>@media screen and (orientation: potrait) { #toolbar {position: fixed; width: 2.65em; height: 100%; } p { margin-left: 2em;} li + li {margin-top: .5em;}}</style>");
			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			//sb.append("<tr><td width='8%'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' width='100' style='margin-left: 100%;float: left;'></div></td> ");
			sb.append("<tr><td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td> </tr>");
//            sb.append("<tr><td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//
//			sb.append(hospitalVO.getHospitalName());
//			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			sb.append("</tr> ");
//			sb.append("<tr> ");
//			sb.append("<td width='8%'>&nbsp;</td> ");
//			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
//
//			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			sb.append("</tr> ");
			sb.append("</table> ");
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData1();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(str3+""+str1+""+str2);
			
			finalPrint = sb.toString();
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(finalPrint);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IssueDeskTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskTransDATA->viewData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			sb = null;
		}

	}

	public static void getIndentDetails(IssueDeskTransFB formBean,HttpServletRequest request) 
	{

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		String strmsgText = "";
		String strItemDtls = "";
		String strChk = "";
		String strReceivedByOptionVal="";
		HisUtil hisutil=null;
		MmsConfigUtil mmscofigutil = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		ResourceBundle resObj = null;
		
		try {
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();
			hisutil = new HisUtil("MMS","getIndentDetails");
			mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			formBean.setStrReOrderFlgColor("#DCDCDC");
			/*****Here We found either Budget Funcanality is Allow or Not******/
			
			formBean.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			/*if(!mmscofigutil.getStrDemandActivePrd().equalsIgnoreCase("")||!mmscofigutil.getStrDemandActivePrd().equalsIgnoreCase(null))
			{
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
			 formBean.setStrIsDemandActiveFlag("1");
			}
			}*/
			/**********************Financial Start Year Combo*******************/								
			strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");						
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
			/*******************************************************************/
			if (request.getParameter("chk") == null) 
			{
				strChk = formBean.getStrChk();
			} 
			else 
			{
				strChk = request.getParameter("chk");
			}
			formBean.setStrChk(strChk);
			String[] temp = strChk.replace("@", "#").split("#");
			formBean.setStrIndentNo(temp[0]);
			formBean.setStrStoreId(temp[1]);
			
			String strStoreName = "";
			if (request.getParameter("comboValue") != null	&& request.getParameter("comboValue").length() > 0) 
			{
				strStoreName = request.getParameter("comboValue");
			} 
			else
			{
				strStoreName = formBean.getStrStoreName();
			}
			formBean.setStrStoreName(strStoreName);
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrIndentNo(formBean.getStrIndentNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			// //System.out.println("data indent details
			// vo.getStrStoreId()-"+vo.getStrStoreId());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String path = "/mms"+request.getParameter("cnt_page")+".cnt";
			
			if(request.getParameter("cnt_page") == null)
			{
				
				path = request.getParameter("strPath");
			}
			if(path!=null && !path.equals(""))
				formBean.setStrPath(path.trim());
			
			System.out.println("IssueDeskTransDATA.getIndentDetails -- Indent Dtls ---- pkg_mms_view.proc_indent_dtl [ Mode - 1 ]-----------");
			
            // Calling BO method
			bo.getIndentDetail(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				formBean.setStrIndentNo(vo.getStrIndentNo());
				formBean.setStrIndentDate(vo.getStrIndentDate());
				formBean.setStrIndentType(vo.getStrIndentType());
				formBean.setStrItemCategory(vo.getStrItemCategory());
				formBean.setStrItemCategoryNo(vo.getStrItemCategoryNo());
				formBean.setStrRaisingStoreId(vo.getStrRaisingStoreId());
				formBean.setStrRaisingStoreName(vo.getStrRaisingStoreName());
				formBean.setStrReqStatusName(vo.getStrReqStatusName());
				formBean.setStrRemarks(vo.getStrRemarks());
				vo.setStrStoreId(formBean.getCombo()[0]);
                // Calling BO Method
				System.out.println(" ---Item Details -- Pkg_Mms_View.proc_indentissue_item_dtls [ Mode - 1 ]-----------");
				bo.getItemDetail(vo);
			}
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else
			{
				formBean.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
				vo.setStrBudgetFlg(formBean.getStrBudgetFlg());
				formBean.setStrItemCategoryNo(vo.getStrItemCategoryNo());
				vo.setStrBudgetFlg("0"); 
				////System.out.println("Item Details are "+vo.getItemDetailsWS().getString());
				/*while(vo.getItemDetailsWS().next())
				{
					//System.out.println("Item Details are "+vo.getItemDetailsWS().getString(3));
				}*/
				//if(vo.getStrItemCategoryNo().equals("10"))
				   System.out.println("----------- IssueDeskTransHLP.getItemDetails_Drug -----------");
					strItemDtls = IssueDeskTransHLP.getItemDetails_Drug(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrRaisingStoreId(),vo.getStrBudgetFlg(),vo.getStrStoreId());
				//else
				//	strItemDtls = IssueDeskTransHLP.getItemDetails(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrRaisingStoreId(),vo.getStrBudgetFlg());
				formBean.setStrItemDtls(strItemDtls);
				
				if(vo.getRecievedByWS()!=null)
				{
					strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
					strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
				}
				else
				{
					strReceivedByOptionVal="<option value='0'>Select Value</option>";
				}
			}
			if (strItemDtls.equals("ERROR")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrChk(strChk);
			formBean.setStrStoreName(strStoreName);
			formBean.setStrReceivedByOptionVal(strReceivedByOptionVal);
			formBean.setStrAvalaibleBudget(vo.getStrAvalaibleBudget());
			//System.out.println("Available budget "+vo.getStrAvalaibleBudget());
			//System.out.println("Available budget dtl  "+vo.getStrAvalaibleBudgetDtl());
			formBean.setStrAvalaibleBudgetDtl(vo.getStrAvalaibleBudgetDtl());
			formBean.setStrRemarksIndent(formBean.getStrRemarks().split("@")[0]);
			formBean.setStrRemarksAppone((formBean.getStrRemarks().split("@")[1]).split("#")[0]);
			formBean.setStrRemarksApptwo((formBean.getStrRemarks().split("@")[1]).split("#")[0]);
			

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskTransDATA.getIndentDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskTransDATA->getIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			resObj = null;
			hisutil = null;

		}

	}

	/**
	 * This method will get the POPUP info according to the selected Bill No. to
	 * generate a PopUp in HLP
	 * 
	 * @param request
	 * @param response
	 */
	public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, IssueDeskTransFB formBean) {
		String strPopUpDtls = null;
		String index = "";
		String strmsgText = null;

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;		
		String strReqParam = "";
		String[] temp = null;
		String strItemCategoryNo = "";
		String strItemBrand = "";
		String strReservedFlag = "";
		String strItemId = "";		
		String strStoreId = "";
		// String strChk = "";
		try {
			// //System.out.println("in side data popup");
			               bo = new IssueDeskTransBO();
			               vo = new IssueDeskTransVO();		
			      strReqParam = (String) request.getParameter("hiddenVal");
			       strStoreId = (String) request.getParameter("storeId");
			             temp = strReqParam.replace("^", "#").split("#");
			        strItemId = temp[0];
			     strItemBrand = temp[1];
			  strReservedFlag = temp[2];
			strItemCategoryNo = temp[6];
			// strStoreId = temp[7];

			// //System.out.println("data strItemId"+strItemId);
			// //System.out.println("data strItemBrand"+strItemBrand);
			// //System.out.println("data strItemCategoryNo"+strItemCategoryNo);
			// //System.out.println("data strHospitalCode"+strHospitalCode);
			// //System.out.println("data strStoreId"+strStoreId);

			vo.setStrItemId(strItemId);
			vo.setStrItemBrand(strItemBrand);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(strStoreId);
			vo.setStrReservedFlag(strReservedFlag);

			           index = (String) request.getParameter("index");
			// Calling BO Method
			bo.getPopUpInfo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			else 
			{
				strPopUpDtls = IssueDeskTransHLP.getPopUpInfo(vo.getPopupWS(),index);

				if (strPopUpDtls.equals("ERROR"))
				{

					HisException eObj = new HisException("MMS",
							"IssueDeskTransDATA->getPopUp()", strmsgText);
					strmsgText = "ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ";
					eObj = null;
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strmsgText);
					throw new Exception(vo.getStrMsgString());
				}
				else 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strPopUpDtls);

				}
			}

		} catch (Exception e) {
			// //e.printStackTrace();
			strmsgText = "MMS.transactions.IssueDeskTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDeskTransDATA->getPopUp()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} 
		finally
		{
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			
		}

	}

	/**
	 * This method calls when we again click on a hyperlink In this method first
	 * we set the parameter value on VO and then use in HLP to show again same
	 * pop up. This parameter(popupData) is already set by the value of flag i
	 * in JS file(AJAX Function) and flag i is already set by the link info when
	 * a link is clicked first time
	 * 
	 * @param request
	 * @param response
	 */
	public static void getPopUpData(HttpServletRequest request,
			HttpServletResponse response, IssueDeskTransFB formBean) {

		String strPopUpDtls = null;
		String strmsgText = null;
		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		HisUtil hisutil = null;

		try {
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrPopUpData((String) request.getParameter("popupData"));

			strPopUpDtls = IssueDeskTransHLP.getPopUpData(vo.getStrPopUpData());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(strPopUpDtls);

			}

		} catch (Exception e) {
			strmsgText = "MMS.transactions.IssueDeskTransDATA.getPopUpData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDeskTransDATA->getPopUpData()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
		}

	}

	/**
	 * This method will get the values for view page
	 * 
	 * @param request
	 * @param response
	 */

	public static void getViewDetails1(IssueDeskTransFB formBean,
			HttpServletRequest request) {

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		String strmsgText = "";
		String strItemDtls = "";
		String strChk = "";
		String strStoreName = "";
		String[] temp = null;

		try {
			           bo = new IssueDeskTransBO();
			           vo = new IssueDeskTransVO();		
			       strChk = request.getParameter("chk");
			         temp = strChk.replace("@", "#").split("#");
			 strStoreName = request.getParameter("comboValue");

			formBean.setStrIndentNo(temp[0]);
			formBean.setStrStoreName(strStoreName);
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrIndentNo(formBean.getStrIndentNo());
			vo.setStrStoreId(temp[1]);
			// //System.out.println("data indent details
			// vo.getStrStoreId()-"+vo.getStrStoreId());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
            // Calling BO Method
			bo.getIndentDetail(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrIndentNo(vo.getStrIndentNo());
				formBean.setStrIndentDate(vo.getStrIndentDate());
				formBean.setStrIndentType(vo.getStrIndentType());
				formBean.setStrItemCategory(vo.getStrItemCategory());
				formBean.setStrRaisingStoreId(vo.getStrRaisingStoreId());
				formBean.setStrRaisingStoreName(vo.getStrRaisingStoreName());
				formBean.setStrReqStatusName(vo.getStrReqStatusName());
				 // Calling BO Method
				bo.getItemDetail(vo);
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				strItemDtls = IssueDeskTransHLP.getViewItemDetails(vo
						.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo
						.getItemDetailsWS(), vo.getStrStoreId());

				formBean.setStrViewItemDtls(strItemDtls);
			}
			if (strItemDtls.equals("ERROR")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
         e.printStackTrace();
			strmsgText = "Issue Desk.IssueDeskTransDATA.getViewDetails1(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskTransDATA->getViewDetails1()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * This method will get the values for view page for issued items
	 * 
	 * @param request
	 * @param response
	 */

	public static void getViewDetails2(IssueDeskTransFB formBean,
			HttpServletRequest request) {

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		String strmsgText = "";
		String strItemDtls = "";
		String temp2[] = null;
		String strChk = "";
		String[] temp = null;
		String strStoreName = "";

		try {
			            bo = new IssueDeskTransBO();
			            vo = new IssueDeskTransVO();
			        strChk = request.getParameter("chk");
			          temp = strChk.replace("@", "#").split("#");
			  strStoreName = request.getParameter("comboValue");
			formBean.setStrIssueNo(temp[0]);
			formBean.setStrStoreName(strStoreName);
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrStoreId(formBean.getCombo()[0]);

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
            // Caaling BO Method
			bo.getIssueDetail(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{

				strItemDtls = IssueDeskTransHLP.getIssuedItemDetail(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo
						.getItemDetailsWS(), vo.getStrStoreId(),vo.getStrIssueNo());

				
				temp2 = strItemDtls.split("#");
				formBean.setStrIssuedItemDtls(temp2[0]);
				formBean.setStrReceivedBy(temp2[1]);
				formBean.setStrRemarks(temp2[2]);
				formBean.setStrItemCategory("Drug");
				formBean.setStrIndentNo(vo.getStrIndentNo());
				formBean.setStrIndentDate(vo.getStrIndentDate());
				formBean.setStrRaisingStoreName(vo.getStrRaisingStoreName());
				
			}

		} catch (Exception e) {

			e.printStackTrace();
//			strmsgText = "Issue Desk.IssueDeskTransDATA.getViewDetails2(vo) --> "
//					+ e.getMessage();
//			HisException eObj = new HisException("mms",
//					"IssueDeskTransDATA->getViewDetails2()", strmsgText);
//			formBean.setStrErr("Application Error [ERROR ID : "
//					+ eObj.getErrorID() + "],Contact System Administrator! ");
//
//			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * This method will get the values for view page for issued items
	 * 
	 * @param request
	 * @param response
	 */

	public static void insertData(IssueDeskTransFB formBean,
			HttpServletRequest request) 
	{

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		String strmsgText = "";

		String strFinancialStartYear = "";
		String strFinancialEndYear = "";

		// String strStoreId = "";
		String strStoreName = "";

		int chkLength = 0;
		String[] values = null;
		String temp[] = null;

		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strReservedFlagArray[] = null;
		String stockDtlsId[] = null; // from userHiddenFld=
										// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
		String strStochStatusCodeArray[] = null;
		String strGroupIdArray[] = null;
		String strSubGroupIdArray[] = null;
		String strAvlQtyArray[] = null;
		String strAvlQtyUnitIdArray[] = null;
		String strConsumableFlagArray[] = null;
		String strChk = "";
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		HisUtil hisutil = null;
					
		MmsConfigUtil mcu = null;

		try
		{
						bo = new IssueDeskTransBO();
						vo = new IssueDeskTransVO();

					   mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				 chkLength = formBean.getStrItemDetailsChk().length;
			       hisutil = new HisUtil("MMS","IssueDeskTransDATA");
			
			  strStoreName = formBean.getStrStoreName();

			strBrandIdArray = new String[chkLength];
			strItemIdArray  = new String[chkLength];
			strBrandIdArray = new String[chkLength];
			strReservedFlagArray = new String[chkLength];
			stockDtlsId = new String[chkLength]; // from userHiddenFld=
													// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
			strStochStatusCodeArray = new String[chkLength];
			strGroupIdArray = new String[chkLength];
			strSubGroupIdArray = new String[chkLength];
			strAvlQtyArray = new String[chkLength];
			strAvlQtyUnitIdArray = new String[chkLength];
			strConsumableFlagArray = new String[chkLength];
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			if (request.getParameter("chk") == null) {
				strChk = formBean.getStrChk();
			} else {
				strChk = request.getParameter("chk");
			}
			temp = strChk.replace("@", "#").split("#");

			formBean.setStrIndentNo(temp[0]);

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); // 10
			vo.setStrStoreId(formBean.getStrStoreId()); // 3
			// //System.out.println("data indent details
			// vo.getStrStoreId()-"+vo.getStrStoreId());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrIndentNo(formBean.getStrIndentNo());// 1
			vo.setStrIndentDate(formBean.getStrIndentDate()); // used in 2nd
																// proc
			vo.setStrRaisingStoreId(formBean.getStrRaisingStoreId()); // 2
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo()); // 5
            vo.setStrFinalApproxAmt(formBean.getStrFinalApproxAmt()); // Approx Amount
            vo.setStrBudgetFlg(formBean.getStrBudgetFlg());
           
            vo.setStrIsDemandActiveFlag(formBean.getStrIsDemandActiveFlag());
            
            strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			
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
            		
			strFinancialStartYear = mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode());
			  strFinancialEndYear = mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode());

			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinalCost(formBean.getStrFinalCost());   // Per Item Cost
			
			vo.setStrTotalBatch(formBean.getStrTotalBatch());
			
			for (int i = 0; i < chkLength; i++) 
			{

				                   values = formBean.getStrItemDetailsChk()[i].replace("^", "#").split("#");
				        strItemIdArray[i] = values[0];
				       strBrandIdArray[i] = values[1];
				  strReservedFlagArray[i] = values[2];
				       strGroupIdArray[i] = values[3];
				    strSubGroupIdArray[i] = values[4];
				strConsumableFlagArray[i] = values[5];

				// //System.out.println("formBean.getStockDtlsId()[i]-"+formBean.getStockDtlsId()[i]);
				
				stockDtlsId = formBean.getStockDtlsId();
				// //System.out.println("formBean.getStrAvlQty()[i]-"+formBean.getStrAvlQty()[i]);
				values = formBean.getStrAvlQty()[i].replace("^", "#").split("#"); // avl qty unit name^ avlqty@unit ^ avl
										// base val

				temp = formBean.getStrAvlQty()[i].replace("@", "#").split("#");
				// temp =values[1].replace("@", "#").split("#");
				strAvlQtyArray[i] = temp[0];
				strAvlQtyUnitIdArray[i] = temp[1];
				
				////System.out.println("Final Cost(Per Item Cost)==>"+formBean.getStrFinalCost()[i]);

			}
			////System.out.println("Total Item Amt(Rs)==>"+formBean.getStrFinalApproxAmt());
			vo.setStrConsumableFlagArray(strConsumableFlagArray);
		
			vo.setStrSingleBatch(formBean.getStrSingleBatch());
			vo.setStrSingleExpiry(formBean.getStrSingleExpiry());
			////System.out.println("stockDtlsId"+stockDtlsId);
			vo.setStockDtlsId(stockDtlsId);
			vo.setStrItemIdArray(strItemIdArray); // 7
			vo.setStrBrandIdArray(strBrandIdArray); // 8
			vo.setStrReservedFlagArray(strReservedFlagArray); // 4
			vo.setStrReqTypeId("31"); // for issue to store //6
			// vo.setStrBatchSlNoArray(strBatchSlNoArray); //9
			// vo.setStrItemSlNoArray(strItemSlNoArray); // 11
			vo.setStrStochStatusCodeArray(strStochStatusCodeArray); // 12
			vo.setStrGroupIdArray(strGroupIdArray); // 13
			vo.setStrSubGroupIdArray(strSubGroupIdArray); // 14
			vo.setStrAvlQtyArray(strAvlQtyArray); // 15
			vo.setStrAvlQtyUnitIdArray(strAvlQtyUnitIdArray); // 16
			vo.setStrBalQtyArray(formBean.getStrBalQty()); // 17
			vo.setStrBalQtyUnitIdArray(formBean.getStrSancUnitId()); // 18
			vo.setStrIssueQtyArray(formBean.getStrIssueQty()); // 19
			vo.setStrIssueQtyUnitIdArray(formBean.getStrIssueUnitId()); // 20

			// vo.setStrRateArray(strRateArray); //23
			// vo.setStrRateUnitIdArray(strRateUnitIdArray); //24
			vo.setStrItemRemarksArray(formBean.getStrItemRemarks()); // 25

			// used in 2nd proc
			vo.setStrReceivedBy(formBean.getStrReceivedBy());
			vo.setStrRemarks(formBean.getStrRemarks());
			// vo.setStrRateBaseValArray(strRateBaseValArray);
			vo.setStrFinalApproxAmt(formBean.getStrFinalApproxAmt());     // Total Sum of Every Item Cost
			vo.setStrAvalaibleBudget(formBean.getStrAvalaibleBudget());
//			vo.setStrNewDemandFinalApproxAmt(formBean.getStrNewDemandFinalApproxAmt());
			vo.setStrBSIndent(formBean.getStrBSIndent());					
			vo.setStrBSQuantity(formBean.getStrBSQuantity());
            // Calling BO Method 
			bo.insertData(vo);

			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				formBean.setStrIssueNo(vo.getStrIssueNo());
				formBean.setStrStoreId(vo.getStrStoreId());
				formBean.setStrStoreName(strStoreName);
				formBean.setStrRaisingStoreId(vo.getStrRaisingStoreId());
				formBean.setStrNormalMsg("Item Issued Successfully");
				if(vo.getStrBSReqNo() != null && !vo.getStrBSReqNo().equals("") && vo.getStrBSIndent().equals("1"))
				{
					formBean.setStrErr("LP indent raised with "+vo.getStrBSReqNo()+" No.");
					formBean.setStrNormalMsg("");
				}
			}

		} catch (Exception e) {
			 e.printStackTrace();

			strmsgText = "Issue Desk.IssueDeskTransDATA.insertData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDeskTransDATA->insertData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Stock item dtls init.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void stockItemDtlsInit(HttpServletRequest request,HttpServletResponse response, IssueDeskTransFB formBean) 
	{

		String strSearchItemInitView = "";
		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		String                 strMode = "";
		String          strStockStatus = "";
		String         strGenricItemId = "";
		String               strItemId = "";
		String             strIssueQty = "";
		String       strIssueQtyInBase = "";
		String          strFromStoreId = "";
		String         strItemCategory = "";
		String   	   strReservedFlag = "";
		String            strHiddenVal = "";
		String             strUnitName = "";
		try 
		{
			                 strMode = (String) request.getParameter("strMode").split("\\^")[0];  // This is Combination of [ Mode ^ Budget Flag ^ Index ] 
			          strStockStatus = (String) request.getParameter("strStockStatus");
			         strGenricItemId = (String) request.getParameter("strGenItemId");
			               strItemId = (String) request.getParameter("strItemId");
			             strIssueQty = (String) request.getParameter("strIssueQty");
			       strIssueQtyInBase = (String) request.getParameter("strIssueQtyInBase");
			          strFromStoreId = (String) request.getParameter("strStoreId");
			         strItemCategory = (String) request.getParameter("strCatCode");
			   	     strReservedFlag = (String) request.getParameter("strReservedFlag");
			            strHiddenVal = (String) request.getParameter("strHiddenFieldVal");			
			             strUnitName = (String) request.getParameter("strUnitName"); 		
			                      bo = new IssueDeskTransBO();
			                      vo = new IssueDeskTransVO();
			                      
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrItemCategoryId(strItemCategory);
			formBean.setStrStockStatus(strStockStatus);
			formBean.setStrGenricItemId(strGenricItemId);
			formBean.setStrItemId(strItemId);
			formBean.setStrIndentIssueQty(strIssueQty);
			formBean.setStrIssueQtyInBase(strIssueQtyInBase);
			formBean.setStrReservedFlag(strReservedFlag);
			formBean.setStrHiddenVal(strHiddenVal);
			formBean.setStrUnitName(strUnitName);
			
			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryId());
			vo.setStrStockStatus(formBean.getStrStockStatus());
			vo.setStrGenricItemId(formBean.getStrGenricItemId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrIndentIssueQty(formBean.getStrIndentIssueQty());
			vo.setStrIssueQtyInBase(formBean.getStrIssueQtyInBase());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrReservedFlag(formBean.getStrReservedFlag());
			
			 System.out.println("-----IssueDeskTransDATA.stockItemDtlsInit ------");
		
			// Calling BO Method
			bo.getStockItemDtlsInitDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
//			while(vo.getWsStockDetails().next())
//			{
//				//System.out.println("Rack No::::::"+vo.getWsStockDetails().getString(44));
//				formBean.setStrRackNo(vo.getWsStockDetails().getString(44));
//				
//				
//			}
//			vo.getWsStockDetails().beforeFirst();
			
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setWsStockDetails(vo.getWsStockDetails());
			formBean.setStrRateUnit(vo.getStrRateUnit());
			formBean.setStrRateInBaseValue(vo.getStrRateInBaseValue());
			//formBean.setStrParentIndex(strParentIndex);
			
			// This Variable is used to set Budget Avalaible or Not Flag
			formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]);
			// This Variable is Used To Set Index
			formBean.setStrIndex((String) request.getParameter("strMode").split("\\^")[2]);
			
			strSearchItemInitView = IssueDeskTransHLP.getStockItemDtlsInitView(formBean);
			
			//System.out.println("-strSearchItemInitView-----"+strSearchItemInitView);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		}
		catch (Exception e) 
		{
		     e.printStackTrace();	 
			 String strmsgText = "IssueDeskTransDATA.stockItemDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"IssueDeskTransDATA.stockItemDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;
			  
		} finally {

			bo = null;
			vo = null;
		}

	}

	/**
	 * Gets the stock item dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the stock item dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getStockItemDtlsInitView(IssueDeskTransFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsStockDetails();
		HisUtil util = new HisUtil("IssueDeskTrans Stock Detail Util",
				"IssueDeskTransHLP");
		IssueDeskTransVO vo = new IssueDeskTransVO();
		int count = 0;

		boolean flag = false;

		String strHiddenVal = "0";
		String[] strHiddenValList = null;
		String[] strTemp = null;
		String[] strChkList = null;
		String[] strQtyList = null;
		String[] strUnitList = null;

		String[] strHiddenCost = null;
		String[] strHiddenTotalCost = null;

		String strTempQtyVal = "";
		String strTempUnitVal = "";
		String strTempCost = "0.00";
		String strTempTotalCost = "0.00";

		String strTableWidth = "900";
		// formBean.setUsrArg((String)
		// request.getParameter("strMode").split("\\^")[1]);
		// This Variable is Used As Budget Avalaible Flag
		// Change By Amit Kumar 10-Aug-2011

		try {

			/*
			 * if(formBean.getStrHiddenVal().trim().length() > 1) strHiddenVal =
			 * formBean.getStrHiddenVal();
			 */

			StringBuffer strChkVal = new StringBuffer("");
			if (formBean.getStrModeVal().equals("1")) {

				sb.append("<table width='"
						+ strTableWidth
						+ "' align='center' cellpadding='1px' cellspacing='0px'> ");
				sb.append("<tr class='HEADER'> ");
				sb.append("<input type='hidden' name='strIndex' id='strIndex' value='"
						+ formBean.getStrIndex() + "'>");
				sb.append("<input type='hidden' name='strParentIndex' id='strParentIndex"
						+ count
						+ "' value='"
						+ formBean.getStrParentIndex()
						+ "'>");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td colspan='4'>Drug Stock Detail(s) </td> ");

				} else {
					sb.append("<td colspan='4'>Item Stock Detail(s) </td> ");
				}

				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td width='50%' class='LABEL'>Drug/Item Name</td> ");

				} else {
					sb.append("<td width='50%' class='LABEL'>Item Name</td> ");
				}

				sb.append("<td width='50%' class='CONTROL'>"
						+ formBean.getStrItemName() + "</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='50%' class='LABEL'>Issue Qty.</td> ");
				sb.append("<td width='50%' class='CONTROL'>"
						+ formBean.getStrIndentIssueQty() + " "
						+ formBean.getStrUnitName()
						+ "<input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQty' value='"
						+ formBean.getStrIndentIssueQty()
						+ "'><input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQtyBaseVal' value='"
						+ formBean.getStrIssueQtyInBase() + "'></td> ");

				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table width='"
						+ strTableWidth
						+ "' align='center' cellpadding='1px' cellspacing='0px'> ");
				sb.append("<tr class='TITLE'> ");
				if (!formBean.getStrItemCategoryId().equals("10")) {
					sb.append("<td colspan='10'>Item Detail(s)</td> ");
				} else {
					sb.append("<td colspan='10'>Drug Detail(s)</td> ");
				}
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='multiRPTLabel' width='5%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='9%'>Programme Name/Rack No");
				sb.append("</td> ");
				if (!formBean.getStrItemCategoryId().equals("10")) {
					sb.append("<td class='multiRPTLabel' width='14%'>Serial No. ");
					sb.append("</td> ");
				}
				sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");
//				sb.append("<td class='multiRPTLabel' width='14%'>Manufacturer ");
//				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. (No.)");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. (No.)");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
				sb.append("</td> ");
				if (formBean.getUsrArg().equals("1")) // Means Budget Required
				{
					sb.append("<td class='multiRPTLabel' width='14%'>Cost");
					sb.append("</td> ");
				}
				sb.append("</tr> ");

				if (ws != null && ws.size() > 0) {

					while (ws.next()) {
						/*
						 * This part is added by Aritra on May 26, 2010. It will
						 * cause to produce distinct value for strStockDtlsChk
						 * checkbox, not appending with the value of previous
						 * check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						String strExpDate = "";
						if (ws.getString(17) != null && ws.getString(17).length() > 10) 
						{
							strExpDate = ws.getString(17);
						}
						if (formBean.getStrItemCategoryId().equals("10")) 
						{
							/*
							 * 1.GENERIC_ITEM_NAME
							 * 2.BRAND_ITEM_NAME
							 * 3.GROUP_NAME
							 * 4. SUBGROUP_NAME 
							 * 5. MANUFACTURER 
							 * 6.SUPPLIED_BY 
							 * 7.STORE_NAME 
							 * 8.In Hand qty 
							 * 9. UNIT_BASE_VALUE 
							 * 10.Store id,
							 * 11. Generic Item Id 
							 * 12. Item Id 
							 * 13.Stock Status Code 
							 * 14. Batch No. 
							 * 15. GROUP_ID 
							 * 16. SUBGROUP_ID 
							 * 17.EXPIRY_DATE
							 * 18.Manufacture Date 
							 * 19.Inhand Qty 
							 * 20.Inhand Qty UnitId
							 * 21.SUPPLIER_ID 
							 * 22.HSTNUM_RATE 
							 * 23.RATE_UNITID 
							 * 24.PO_NO
							 * 25.PO_DATE 
							 * 26.SUPPLIED_BY 
							 * 27.RECIEVED_DATE 
							 * 32.Sale Price
							 * 33.Sale Price Unit Id 
							 * 34. Stock dtl 
							 * 35.INVOICE_NO 
							 * 36.INVOICE_DATE 
							 * 37.specification 
							 * 38.rack no 
							 * 39.Purchase Rate
							 * 40. Expiry Remaining Day(s) 
							 * 41 Expiry Date in Jun/2013 Format
							 * 42. Programme id	
							 * 43. Po no						 
							 */
							
							

							strChkVal
									.append(ws.getString(10))
									.append("^")
									.append(ws.getString(11))
									.append("^")
									.append(ws.getString(12))
									.append("^")
									.append(ws.getString(14))
									.append("^")
									.append(ws.getString(13))
									.append("^")
									.append(ws.getString(26))
									.append("^")
									.append(strExpDate)
									.append("^")
									.append(ws.getString(18))
									.append("^")
									.append(ws.getString(19))
									.append("^")
									.append(ws.getString(20))
									.append("^")
									.append(ws.getString(22))
									.append("^")
									.append(ws.getString(23))
									.append("^")
									.append(ws.getString(32))
									.append("^")
									.append(ws.getString(33))
									.append("^")
									.append(ws.getString(39))
									.append("^")
									.append(ws.getString(40))
									.append("^")
									.append(ws.getString(5))
									.append("^")
									.append(ws.getString(39) + "/"
											+ ws.getString(8).split("\\ ")[1])
									.append("^").append(ws.getString(41))
									.append("^")
									.append(ws.getString(42))
									.append("^")
									.append(ws.getString(43))
									.append("^")
									.append(ws.getString(44));
							        

						} 
						else 
						{
							strChkVal.append(ws.getString(11)).append("^")
									.append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^")
									.append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^")
									.append(ws.getString(37)).append("^")
									.append(strExpDate).append("^")
									.append(ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^")
									.append(ws.getString(39));

						}
						
						count = count + 1;

						sb.append("<tr>");
						strHiddenVal = formBean.getStrHiddenVal();
						
						if (strHiddenVal.length() > 1) 
						{
							strHiddenValList = strHiddenVal.split("@");
							strChkList = new String[strHiddenValList.length];
							strQtyList = new String[strHiddenValList.length];
							strUnitList = new String[strHiddenValList.length];
							strHiddenTotalCost = new String[strHiddenValList.length];
							strHiddenCost = new String[strHiddenValList.length];							
							for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) 
							{								
								strTemp = strHiddenValList[i].replace("^", "#").split("#");
								strChkList[i] = new StringBuffer(strTemp[0])
										.append("^").append(strTemp[1])
										.append("^").append(strTemp[2])
										.append("^").append(strTemp[3])
										.append("^").append(strTemp[4])
										.append("^").append(strTemp[5])
										.append("^").append(strTemp[6])
										.append("^").append(strTemp[7])
										.append("^").append(strTemp[8])
										.append("^").append(strTemp[9])
										.append("^").append(strTemp[10])
										.append("^").append(strTemp[11])
										.append("^").append(strTemp[12])
										.append("^").append(strTemp[13])
										.toString();

								strQtyList[i] = strTemp[14];
								strUnitList[i] = strTemp[15];
								strHiddenCost[i] = strTemp[18];
								strHiddenTotalCost[i] = strTemp[19];
							}
						}

						if (strChkList != null) {

							for (int i = 0, stopI = strChkList.length; i < stopI; i++) {
								String content = strChkList[i];

								if (content.equalsIgnoreCase(strChkVal
										.toString())) {
									flag = true;
									strTempQtyVal = strQtyList[i];
									strTempUnitVal = strUnitList[i];

									strTempCost = strHiddenCost[i];
									strTempTotalCost = strHiddenTotalCost[i];

								}

							}

						}
						if (flag) {
							sb.append("<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
									+ count
									+ "' checked='checked'  value='"
									+ strChkVal.toString()
									+ "' onclick='checkStockDetails(this,\""
									+ count + "\");'> ");

						} else {

							sb.append("<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
									+ count
									+ "' value='"
									+ strChkVal.toString()
									+ "' onclick='checkStockDetails(this,\""
									+ count + "\");'> ");

						}

						sb.append("</td> ");

						String strRackNo = "-----";

						if (ws.getString(38) != null || ws.getString(38) != "") {
							strRackNo = ws.getString(38);
						}

						sb.append("<td class='multiPOControl' width='9%' style=\"text-align:left;\">"); // Rack No
						sb.append(ws.getString(44)+"/"+strRackNo);
						sb.append("</td> ");

						if (!formBean.getStrItemCategoryId().equals("10")) {
							sb.append("<td class='multiPOControl' width='14%'>"); // Serial
																					// No
							sb.append(ws.getString(37));
							sb.append("</td> ");
						}

						sb.append("<td class='multiPOControl' width='14%' style=\"text-align:left;\">"); // Batch No
						sb.append(ws.getString(14));
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>"); // Expiry  Date
						sb.append(ws.getString(41));
						sb.append("</td> ");
//						sb.append("<td class='multiPOControl' width='14%' style=\"text-align:left;\">"); // Mfg
//
//						if (ws.getString(5) != null
//								&& !ws.getString(5).equals("null"))
//
//							sb.append(ws.getString(5));
//
//						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%' style='text-align:right'>"); // Avl Qty
						sb.append(ws.getString(8).split("\\ ")[0]);
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='7%' style='text-align:right'>"); // Rate  with Unit
						sb.append(ws.getString(39) + "/"
								+ ws.getString(8).split("\\ ")[1]);
						sb.append("<input type='hidden' name='strParentIndex'      id='strParentIndex"
								+ count + "'       value='"
								+ formBean.getStrIndex() + "'>");
						sb.append("<input type='hidden' name='strDrugDtls'         id='strDrugDtls"
								+ (count - 1) + "'  value='"
								+ ws.getString(14) + "'>");
						sb.append("<input type='hidden' name='strExpDtls'          id='strExpDtls"
								+ (count - 1) + "'  value='"
								+ ws.getString(41) + "'>");
						sb.append("<input type='hidden' name='strAvlDrugBatch'     id='strAvlDrugBatch"
								+ count + "' value='"
								+ ws.getString(14)
								+ "'>");
						sb.append("<input type='hidden' name='strDrugBatchAvlQty'  id='strDrugBatchAvlQty"
								+ count + "' value='"
								+ ws.getString(8).split("\\ ")[0] + "'>");
						sb.append("<input type='hidden' name='strRate'             id='strRate"
								+ count + "' value='"
								+ ws.getString(23) + "'>");
						sb.append("<input type='hidden' name='strPurchaseRate'     id='strPurchaseRate"
								+ count + "'   value='"
								+ ws.getString(39)
								+ "'>");
						sb.append("<input type='hidden' name='strExpiryRemainDays' id='strExpiryRemainDays"
								+ count + "'  value='" + ws.getString(40)
								+ "'>");
						sb.append("</td> ");

						sb.append("<td class='multiPOControl' width='12%'>");

						if (flag) {
							// Method in issueDesk_trans.js File
							sb.append("<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' value='"
									+ strTempQtyVal
									+ "' onkeypress='return validateData(event,7);' onBlur='checkAvailQtyTwo(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
									+ count + "'>");

						} else {

							sb.append("<input type='text' autocomplete='off'  class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onBlur='checkAvailQtyTwo(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
									+ count + "'>");

						}

						sb.append("</td> ");

						sb.append("<td class='multiPOControl' width='8%'>");

						if (flag) {

							sb.append("<select name='strAvailableQtyUnit' class='comboNormal' id='strAvailableQtyUnit"
									+ count
									+ "' onchange='checkAvailQty(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");

							vo.setStrUnitId(ws.getString(20));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null
									&& vo.getStrUnitListWs().size() > 0) {

								sb.append(util.getOptionValue(
										vo.getStrUnitListWs(), strTempUnitVal,
										"", true, true));

							} else {

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						} else {

							sb.append("<select name='strAvailableQtyUnit' disabled='disabled' class='comboNormal' id='strAvailableQtyUnit"
									+ count
									+ "' onchange='checkAvailQty(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' readonly>");

							vo.setStrUnitId(ws.getString(20));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null
									&& vo.getStrUnitListWs().size() > 0) {

								sb.append(util.getOptionValue(
										vo.getStrUnitListWs(),
										vo.getStrUnitId(), "", true, true));

							} else {

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						}

						sb.append("</td> ");
						if (formBean.getUsrArg().equals("1")) // Means Budget
																// Required
						{

							if (formBean.getStrItemCategoryId().equals("10")) {
								sb.append("<td class='multiPOControl' width='14%'>");
								if (flag) {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"
											+ strTempCost
											+ "' name='strStockCost' id='strStockCost"
											+ count + "' >");
									sb.append("<input type='hidden' value='"
											+ strTempCost
											+ "' name='strCost' id='strCost"
											+ count + "' >");
								} else {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"
											+ count + "' >");
									sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"
											+ count + "' >");
								}

							} else {

								sb.append("<td class='multiPOControl' width='14%'>");
								if (flag) {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"
											+ strTempCost
											+ "' name='strStockCost' id='strStockCost"
											+ count + "' >");
									sb.append("<input type='hidden' value='"
											+ strTempCost
											+ "' name='strCost' id='strCost"
											+ count + "' >");
								} else {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"
											+ count + "' >");
									sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost"
											+ count + "' >");
								}

							}
							sb.append("</td> ");
						}

						sb.append("</tr> ");

						flag = false;

						strTempQtyVal = "";
						strTempUnitVal = "0";
					}

				} else {

					sb.append("<tr> ");
					sb.append("<td colspan='8' class='multiPOControl'><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");
				if (formBean.getUsrArg().equals("1")) {
					sb.append("<table width='"
							+ strTableWidth
							+ "' align='center' cellpadding='1px' cellspacing='0px'> ");
					sb.append("<tr> ");
					sb.append("<td width='68%' class='LABEL'>Total:</td> ");
					sb.append("<td width='16%' class='CONTROL' style='color: red; font-weight: bold'> ");
					sb.append("<div id='strTotalQtyDivId' align='left'>0</div></td> ");
					sb.append("<td width='12%' class='CONTROL' style='color: red; font-weight: bold;text-align:right;'> ");
					sb.append("<input type='text' name='strTotalCostDivId' class='txtFldNormal'  value='"
							+ strTempTotalCost
							+ "'  disabled='disabled' id='strTotalCostDivId' >");
					sb.append("<input type='hidden' name='strApproxAmt' value='"
							+ strTempTotalCost + "'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
				}

				sb.append("<table width='"
						+ strTableWidth
						+ "' align='center' cellpadding='1px' cellspacing='0px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'></td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<div><div class='legends'><font size='2' color='red'>*</font> Mandatory Fields</div>");
				sb.append("<div class='control_button'><table border='0' width='"
						+ strTableWidth + "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'><div><a class='button'  title='Save Record' onClick='return validatePopUp();'><span class='ok'>Ok</span></a>");
				sb.append("<a href='#' class='button' title='Cancel Process' onClick='cancelStockDetails(this,\""
						+ (count - 1)
						+ "\");'><span class='cancel'>Close</span></a>");
				sb.append("<div></td> ");
				sb.append(" </tr> ");
				sb.append(" </table></div></div> ");

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	
	/**
	 * Issue dtls init.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void issueDtlsInit(HttpServletRequest request,
			HttpServletResponse response, IssueDeskTransFB formBean) {

		String strSearchItemInitView = "";

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		try {

			String strMode = (String) request.getParameter("strMode");
			String strFromStoreId = (String) request.getParameter("strStoreId");
			String strIssueNo = (String) request.getParameter("strIssueNo");
			String strIndentNo = (String) request.getParameter("strIndentNo");
			String crNo = (String) request.getParameter("crNo")==null?"0":(String) request.getParameter("crNo");
			
			
			String strIndentDate = (String) request
					.getParameter("strIndentDate");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			formBean.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());

			formBean.setStrFromStoreId(strFromStoreId);
			formBean.setStrModeVal(strMode);
			formBean.setStrIssueNo(strIssueNo);

			vo.setStrModeVal(formBean.getStrModeVal());
			vo.setStrFromStoreId(formBean.getStrFromStoreId());
			vo.setStrIssueNo(formBean.getStrIssueNo());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			//vo.setStrValue8(crNo);
			formBean.setStrCrno(crNo);
			
			System.out.println("-----------IssueDeskTransCNT . ISSUEDTLSINIT [ After Save Issue Voucher ]--------------");
			
			bo.getImgHeader(vo);
			bo.getIssueVoucherDtl(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrModeVal().equals("5")) {
				formBean.setStrReturnReqNo(vo.getStrReturnReqNo());
				formBean.setStrSlNoflg("0");
				formBean.setStrBudget("0");
			}
			formBean.setStrIssueNo(strIssueNo);
			formBean.setStrIssueDate(vo.getStrIssueDate());
			formBean.setStrIssueTo(vo.getStrIssueTo());
			formBean.setStrItemCategoryId(vo.getStrItemCategoryNo());
			formBean.setWsIssueDetails(vo.getWsIssueDetails());

			while (formBean.getWsIssueDetails().next()) {
				if (vo.getStrModeVal().equals("2")) {
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(4));
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(27));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrIndentNo(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrIndentDate(formBean.getWsIssueDetails()
							.getString(32));
					formBean.setStrApprovalRemarks(formBean.getWsIssueDetails()
							.getString(36));

				}
				 if(vo.getStrModeVal().equals("1")) {
						formBean.setStrStoreName(formBean.getWsIssueDetails()
								.getString(4)); 
						formBean.setStrUserName(formBean.getWsIssueDetails()
								.getString(34));
					 }
				if (vo.getStrModeVal().equals("4")) {
					formBean.setStrFinalRemarks(formBean.getWsIssueDetails()
							.getString(29));
					formBean.setStrItemWiseCost(formBean.getWsIssueDetails()
							.getString(30));
					formBean.setStrBudget(formBean.getWsIssueDetails()
							.getString(31));
					formBean.setStrStoreName(formBean.getWsIssueDetails()
							.getString(3).split("@")[0]);
					formBean.setStrOrgName(formBean.getWsIssueDetails().getString(4));
					formBean.setStrUserName(formBean.getWsIssueDetails().getString(39));
				}
			}

			formBean.getWsIssueDetails().beforeFirst();

			if (!vo.getStrModeVal().equals("2")) {
				formBean.setStrIndentDate(strIndentDate);
				formBean.setStrIndentNo(strIndentNo);
			}
			formBean.setStrSlNoflg(vo.getStrSlNoflg());
			
			System.out.println("-----------IssueDeskTransHLP.getIssueDtlsInitView-----[ Mode - "+formBean.getStrModeVal()+" ]---------");
			
			strSearchItemInitView = IssueDeskTransHLP.getIssueDtlsInitView(formBean, vo);
			
			
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
			
			System.out.println("----------- Issue Voucher END --------------");
			
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "IssueDeskTransDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("IssueDeskTrans",
					"IssueDeskTransDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}

	

}
