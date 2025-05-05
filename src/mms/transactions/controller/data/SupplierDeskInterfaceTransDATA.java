/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;
import org.apache.tika.Tika;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.SupplierDeskInterfaceTransBO;
import mms.transactions.controller.fb.SupplierDeskInterfaceTransFB;
import mms.transactions.controller.fb.SupplierDeskInterfaceTransJqgridListFB;
import mms.transactions.controller.hlp.SupplierDeskInterfaceTransHLP;
import mms.transactions.vo.SupplierDeskInterfaceTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransDATA.
 */
public class SupplierDeskInterfaceTransDATA {

	/**
	 * Delivery detail init.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void deliveryDetailInit(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		SupplierDeskInterfaceTransVO vo = null;
		SupplierDeskInterfaceTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		try 
		{
			hisutil = new HisUtil("DWH Transaction", "PODeskGenerateTransDATA");
			vo = new SupplierDeskInterfaceTransVO();
			bo = new SupplierDeskInterfaceTransBO();
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			strCurrentMonth = Integer.parseInt(strCurrentDate.split("\\-")[1]);
			ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			formBean.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));

			if (strCurrentMonth >= 4) {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]);
			} else {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]) - 1;
			}

			strFinancialStartDate = "01-Apr" + "-" + CURRENT_YEAR;
			strFinancialEndDate = "31-Mar" + "-" + (CURRENT_YEAR + 1);
			
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrHospitalCode(vo.getStrHospitalCode());			
			formBean.setStrPONo(request.getParameter("chk").replace("@", "#").split("#")[1]);			
			formBean.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			String chk = request.getParameter("chk");
			if ((chk != null) && !(chk.equals(""))) 
			{
				 // C.HSTNUM_PO_NO'@'C.HSTNUM_STORE_ID'@'C.PO_DATE'@'C.HSTNUM_SUPP_ACCEPTANCE_FLAG @ SSTNUM_POTYPE_ID @	HSTNUM_SUPPLIER_ID			
				vo.setStrPONo(chk.split("@")[0]);
				vo.setStrItemCat("10");
				vo.setStrStoreId(chk.split("@")[1]);
			} 
			else 
			{
				//poStoreId = formBean.getStrPoStoreId();
				//PONo = formBean.getStrPoNo();
			}			
			vo.setStrFinancialStartDate(strFinancialStartDate);
			vo.setStrFinancialToDate(strFinancialEndDate);
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));			
			// Calling BO Method To Get PO Detail(s)
			bo.getPODetails(vo); // pkg_mms_view.Proc_Po_Details [ Mode=4 ]
			/**********************************************************************************/
		    //   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT
			// ^ (4) Supplier ID ^ (5)PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date 
			// ^ (18)Verify Date  ^ (19) Verify BY ^ (20) Financial Period(2013-2014)
			// ^ (21)Next PO Date ^ (22) Purchase Commite date ^ (23) Negotiation Meeting Date 
			// ^ (24)Remarks ^ (25) Verified By ^(26)Verify Date ^ (27) Total Amendment ^(28) Rate Contracted Flg 
			// ^ (29)PO Type Auth id ^ (30) PO Ref No^(31) Store Name {PO Created}
			// ^ (32)Purchase Source Name ^ (33) Rate Contract Id ^(34)PROGRAMME_ID^(35)FUNDING_SOURCE_ID^(36)REF_PO_NO
			// ^ (37)Prog Name ^ (38) Funding Src Name ^ (39) DRAFT_FLG
			/**********************************************************************************/
			/* Calling BO Method Here 
                        1.Get PO Item Name [ pkg_mms_view.proc_item_list_for_po -2]
                        2.Purchase Source Value[pkg_mms_view.Proc_sstt_purchase_source_mst - 1]
                        3.Approved By Combo [ PKG_MMS_VIEW.proc_store_emp_dtl - 1]
                        4.PO Prefix Combo [  pkg_mms_view.proc_POPrefix_list - 1]
                        5.Financial Year Combo [ PKG_MMS_VIEW.proc_financial_year_list - 1]
                        6.PO Type Values [  pkg_mms_view.Proc_Sstt_indenttype_Dtl - 2]
                        7.Store DWH_TYP_ID [ MMS_MST.get_store_type_flg ]
                        8.Schedule Total Qty [ pkg_mms_view.Proc_Po_Details - 4]
                        9.Unit Values [ Pkg_Mms_View.Proc_Gblt_Unit_Mst - 6]
                        10.Schedule Delivery Date [ PKG_MMS_VIEW.proc_PO_Schedule_DateList -1]
			*/
			bo.setPurchaseSourceValues(vo);
			
			
			formBean.setStrPORefrenceDate(vo.getStrPOHiddenValue().split("\\^")[0]);
			formBean.setStrFinancialYearCombo(vo.getStrFinancialYearCombo());
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrItemCatValues(vo.getStrItemCatValues());
			formBean.setStrPoRefrenceNoCmb(vo.getStrPoRefrenceNoCmb());

			if (formBean.getStrModifyFlg().equals("1")) 
			{
				vo.setStrPurchaseSourceId(formBean.getStrPurchaseSourceID());
			} 
			else 
			{
				vo.setStrPurchaseSourceId("0");
			}

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean.setStrPurchaseSourceValues(vo.getStrPurchaseSourceValues());
			formBean.setStrApprovedByVals(vo.getStrPOHiddenValue().split("\\^")[25]);
			formBean.setStrCurrentDate(hisutil.getDSDate("DD-Mon-yyyy"));
			formBean.setStrComboPOTypeValue(vo.getStrPOHiddenValue().split("\\^")[2]);
			formBean.setStrPOHiddenValue(vo.getStrPOHiddenValue());
			formBean.setStrPOFinancialYear(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrPOItemCmb(vo.getStrPOItemCmb());			
			formBean.setStrItemBrandIds(vo.getStrItemBrandIds().split("\\@")[0]+"@"+vo.getStrItemBrandIds().split("\\@")[1]);
			formBean.setStrPOItemID(vo.getStrItemBrandIds().split("\\@")[0]+"@"+vo.getStrItemBrandIds().split("\\@")[1]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[2]+"@"+vo.getStrItemBrandIds().split("\\@")[3]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[4]+"@"+vo.getStrItemBrandIds().split("\\@")[5]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[6]+"@"+vo.getStrItemBrandIds().split("\\@")[7]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[8]);
//			HSTNUM_ITEMBRAND_ID || '@' || HSTNUM_ITEM_ID || '@' || 
//		    HSTNUM_RATE || '@' || HSTNUM_RATE_UNITID || '@' ||
//		    MMS_MST.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE) || '@' || 
//		    NVL(HSTNUM_ITEM_TAX,0) || '@' ||
//		    (HSTNUM_RATE * (100 + NVL(HSTNUM_ITEM_TAX,0)))/100 ||'@'||    
//		    MMS_MST.GETUNITNAME(A.GNUM_HOSPITAL_CODE,A.HSTNUM_DEFAULT_UNITID) || '@' ||
//		    MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_RATE_UNITID) AS ITEM_ID
		    
			//formBean.setStrManufacturerValues(vo.getStrItemBrandIds().split("\\@")[11]);
			formBean.setStrSupplierName(vo.getStrPOHiddenValue().split("\\^")[1]);
			formBean.setStrSupplierId(vo.getStrPOHiddenValue().split("\\^")[4]);
			formBean.setStrIndentPeriodValue(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrComboPOTypeId(vo.getStrPOHiddenValue().split("\\^")[5]);
			formBean.setStrDRemarks(vo.getStrPOHiddenValue().split("\\^")[24]);
			formBean.setStrVerifiedDate(vo.getStrPOHiddenValue().split("\\^")[26]);
			formBean.setStrPOAuthTypeId(vo.getStrPOAuthTypeId());
			formBean.setStrPoRefrenceNoText(vo.getStrPOHiddenValue().split("\\^")[12]);
			formBean.setStrPoMultiRefrenceNo(vo.getStrPOHiddenValue().split("\\^")[30]);
			formBean.setStrStoreName(vo.getStrPOHiddenValue().split("\\^")[31]);
			formBean.setStrDDeliveryDays(vo.getStrDDeliveryDays());
			formBean.setStrDDeliveryDays2(vo.getStrDDeliveryDays2());
			formBean.setStrDDeliveryDays3(vo.getStrDDeliveryDays3());
			formBean.setStrDDeliveryDays4(vo.getStrDDeliveryDays4());
			formBean.setStrPOHiddenValue(vo.getStrPOHiddenValue());
			formBean.setStrStoreId(vo.getStrStoreId());
			
			
			bo.getScheduleDtls(vo); // PKG_MMS_VIEW.PROC_PO_PROGRAMME_LIST
			// 2- Store List (Header)
			// 3- Data

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
            vo.setStrViewMode(formBean.getStrViewMode()); 
			formBean.setStrCtDate(hisutil.getASDate("dd-MMM-yyyy"));
		
			//formBean.setStrUserName((String) request.getSession().getAttribute("userName"));			
			response.setContentType("text/html;charset=UTF-8");
			if(formBean.getStrViewMode().equals("0"))
			{	
			     formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.storeLocationList(vo));
			}
			else
			{
				 formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.viewStoreLocationList(vo));
			}
			response.setContentType("text/html;charset=UTF-8");
			
			
		

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setItemCatValues1()---->", _Err
							.getMessage());
			formBean
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}

	}
	
	public static void generatePdf(HttpServletRequest request, HttpServletResponse response,SupplierDeskInterfaceTransFB formBean) throws IOException,
	ServletException
{

		String strSearchItemInitView = "";
		// boolean printFlag = false;

try {
	String strHtmlCode = formBean.getStrHtmlCode();
	strHtmlCode = strHtmlCode.replace("width=\"800\"", "width='650'");
	strSearchItemInitView = "<html><body>" + strHtmlCode + "</body></html>";
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition", "attachment; filename= carton.pdf");
	//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strSearchItemInitView);

} catch (Exception e) {
	e.printStackTrace();

	String strmsgText = e.getMessage();
	HisException eObj = new HisException("mms", "SupplierDeskInterfaceTransDATA.HtmlToPdfConvertor()", strmsgText);
	eObj.printStackTrace();
	eObj = null;

}
}	

	/**
	 * Sets the view item cat values.
	 * 
	 * @param formBean
	 *            the _po desk generate trans fb
	 * @param _request
	 *            the _request
	 */
	public static void setSupplierInterfaceViewValues(SupplierDeskInterfaceTransFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		SupplierDeskInterfaceTransVO vo = null;
		SupplierDeskInterfaceTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		try 
		{
			formBean.setStrViewMode("1");
			hisutil = new HisUtil("DWH Transaction", "PODeskGenerateTransDATA");
			vo = new SupplierDeskInterfaceTransVO();
			bo = new SupplierDeskInterfaceTransBO();
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			strCurrentMonth = Integer.parseInt(strCurrentDate.split("\\-")[1]);
			ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			formBean.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));

			if (strCurrentMonth >= 4) {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]);
			} else {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]) - 1;
			}

			strFinancialStartDate = "01-Apr" + "-" + CURRENT_YEAR;
			strFinancialEndDate = "31-Mar" + "-" + (CURRENT_YEAR + 1);
			
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrHospitalCode(vo.getStrHospitalCode());			
				
			formBean.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
            String chk = null;
			
			/*if (request.getParameter("chk") == null) 
			{
				chk = formBean.getStrChk();
			} 
			else 
			{
				chk = request.getParameter("chk");
			}
			
			if ((chk != null) && !(chk.equals(""))) 
			{
				formBean.setStrChk(chk);
				formBean.setStrPONo(chk.replace("@", "#").split("#")[1]);		
				 // C.HSTNUM_PO_NO'@'C.HSTNUM_STORE_ID'@'C.PO_DATE'@'C.HSTNUM_SUPP_ACCEPTANCE_FLAG @ SSTNUM_POTYPE_ID @	HSTNUM_SUPPLIER_ID			
				vo.setStrPONo(chk.split("@")[0]);
				vo.setStrItemCat("10");
				vo.setStrPOStoreId(chk.split("@")[1]);
				vo.setStrStoreId(chk.split("@")[1]);
				formBean.setStrPONo(chk.split("@")[0]);		
			} 
			else 
			{
				//poStoreId = formBean.getStrPoStoreId();
				//PONo = formBean.getStrPoNo();
			}*/
           
				chk = request.getParameter("strChk");
			
			
			if ((chk != null) && !(chk.equals(""))) 
			{
				formBean.setStrChk(chk);
				formBean.setStrPONo(chk.split("\\@")[0]);		
				 // C.HSTNUM_PO_NO'^'C.HSTNUM_STORE_ID'^'HSTNUM_SUPPLIER_ID '^'	C.PO_DATE'^'C.HSTNUM_SUPP_ACCEPTANCE_FLAG '^' SSTNUM_POTYPE_ID 		
				vo.setStrPONo(chk.split("\\@")[0]);
				vo.setStrItemCat("10");
				vo.setStrPOStoreId(chk.split("\\@")[1]);
				vo.setStrStoreId(chk.split("\\@")[1]);
				//formBean.setStrPONo(chk.split("@")[0]);		
			} 
			else 
			{
				//poStoreId = formBean.getStrPoStoreId();
				//PONo = formBean.getStrPoNo();
			}
			vo.setStrFinancialStartDate(strFinancialStartDate);
			vo.setStrFinancialToDate(strFinancialEndDate);
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));			
			// Calling BO Method To Get PO Detail(s)
			bo.getPODetails(vo); // pkg_mms_view.Proc_Po_Details [ Mode=2 ]
			/**********************************************************************************/
		    //   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT
			// ^ (4) Supplier ID ^ (5)PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date 
			// ^ (18)Verify Date  ^ (19) Verify BY ^ (20) Financial Period(2013-2014)
			// ^ (21)Next PO Date ^ (22) Purchase Commite date ^ (23) Negotiation Meeting Date 
			// ^ (24)Remarks ^ (25) Verified By ^(26)Verify Date ^ (27) Total Amendment ^(28) Rate Contracted Flg 
			// ^ (29)PO Type Auth id ^ (30) PO Ref No^(31) Store Name {PO Created}
			// ^ (32)Purchase Source Name ^ (33) Rate Contract Id ^(34)PROGRAMME_ID^(35)FUNDING_SOURCE_ID^(36)REF_PO_NO
			// ^ (37)Prog Name ^ (38) Funding Src Name ^ (39) DRAFT_FLG ^ (40) RATE_CONT_QTY
			/**********************************************************************************/
			/* Calling BO Method Here 
                1.Get PO Item Name [ pkg_mms_view.proc_item_list_for_po -2]
                2.Purchase Source Value[pkg_mms_view.Proc_sstt_purchase_source_mst - 1]
                3.Approved By Combo [ PKG_MMS_VIEW.proc_store_emp_dtl - 1]
                4.PO Prefix Combo [  pkg_mms_view.proc_POPrefix_list - 1]
                5.Financial Year Combo [ PKG_MMS_VIEW.proc_financial_year_list - 1]
                6.PO Type Values [  pkg_mms_view.Proc_Sstt_indenttype_Dtl - 2]
                7.Store DWH_TYP_ID [ MMS_MST.get_store_type_flg ]
                8.Schedule Total Qty [ pkg_mms_view.Proc_Po_Details - 4]
                9.Unit Values [ Pkg_Mms_View.Proc_Gblt_Unit_Mst - 6]
                10.Schedule Delivery Date [ PKG_MMS_VIEW.proc_PO_Schedule_DateList -1]
			*/
			
			vo.setStrFinancialStartDate("01-Apr-"+vo.getStrPOHiddenValue().split("\\^")[20].split("-")[0].trim());
			vo.setStrFinancialToDate("31-Mar-"+vo.getStrPOHiddenValue().split("\\^")[20].split("-")[1].trim());
			vo.setStrSupplierId(vo.getStrPOHiddenValue().split("\\^")[4]);
			vo.setStrPORefrenceDate(vo.getStrPOHiddenValue().split("\\^")[0]);
			vo.setStrIndentPeriodValue(vo.getStrPOHiddenValue().split("\\^")[20]);
		    
			bo.setPurchaseSourceValues(vo);
			
			
			formBean.setStrPORefrenceDate(vo.getStrPOHiddenValue().split("\\^")[0]);
			formBean.setStrFinancialYearCombo(vo.getStrFinancialYearCombo());
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrItemCatValues(vo.getStrItemCatValues());
			formBean.setStrPoRefrenceNoCmb(vo.getStrPoRefrenceNoCmb());

			if (formBean.getStrModifyFlg().equals("1")) 
			{
				vo.setStrPurchaseSourceId(formBean.getStrPurchaseSourceID());
			} 
			else 
			{
				vo.setStrPurchaseSourceId("0");
			}

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			//formBean.setStrItemNameNew(vo.getStrItemNameNew());		
			
			////System.out.println("formBean.setStrItemNameNew"+formBean.getStrItemNameNew());
			formBean.setStrPrgName(vo.getStrPrgName());
			formBean.setStrFSName(vo.getStrFSName());
			formBean.setStrPurchaseSourceValues(vo.getStrPurchaseSourceValues());
			formBean.setStrApprovedByVals(vo.getStrPOHiddenValue().split("\\^")[25]);
			formBean.setStrCurrentDate(hisutil.getDSDate("DD-Mon-yyyy"));
			formBean.setStrComboPOTypeValue(vo.getStrPOHiddenValue().split("\\^")[2]);
			formBean.setStrPOHiddenValue(vo.getStrPOHiddenValue());
			formBean.setStrPOFinancialYear(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrPOItemCmb(vo.getStrPOItemCmb());			
			formBean.setStrItemBrandIds(vo.getStrItemBrandIds().split("\\@")[0]+"@"+vo.getStrItemBrandIds().split("\\@")[1]);
			formBean.setStrPOItemID(vo.getStrItemBrandIds().split("\\@")[0]+"@"+vo.getStrItemBrandIds().split("\\@")[1]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[2]+"@"+vo.getStrItemBrandIds().split("\\@")[3]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[4]+"@"+vo.getStrItemBrandIds().split("\\@")[5]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[6]+"@"+vo.getStrItemBrandIds().split("\\@")[7]
			                                      +"@"+vo.getStrItemBrandIds().split("\\@")[8]);
			
			//po item id --->10100009@10000009@4.6300@630001@1.000@10.00@5.0930000000000000@4 ml/Amp@No
			////System.out.println("po item id --->"+formBean.getStrPOItemID());
//			HSTNUM_ITEMBRAND_ID || '@' || HSTNUM_ITEM_ID || '@' || 
//		    HSTNUM_RATE || '@' || HSTNUM_RATE_UNITID || '@' ||
//		    MMS_MST.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE) || '@' || 
//		    NVL(HSTNUM_ITEM_TAX,0) || '@' ||
//		    (HSTNUM_RATE * (100 + NVL(HSTNUM_ITEM_TAX,0)))/100 ||'@'||    
//		    MMS_MST.GETUNITNAME(A.GNUM_HOSPITAL_CODE,A.HSTNUM_DEFAULT_UNITID) || '@' ||
//		    MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_RATE_UNITID) AS ITEM_ID
			
			//formBean.setStrManufacturerValues(vo.getStrPOHiddenValue().split("\\^")[1]);
			formBean.setStrSupplierName(vo.getStrPOHiddenValue().split("\\^")[1]);
			formBean.setStrSupplierId(vo.getStrPOHiddenValue().split("\\^")[4]);
			formBean.setStrIndentPeriodValue(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrComboPOTypeId(vo.getStrPOHiddenValue().split("\\^")[5]);
			formBean.setStrDRemarks(vo.getStrPOHiddenValue().split("\\^")[24]);
			formBean.setStrVerifiedDate(vo.getStrPOHiddenValue().split("\\^")[26]);
			formBean.setStrPOAuthTypeId(vo.getStrPOAuthTypeId());
			formBean.setStrPoRefrenceNoText(vo.getStrPOHiddenValue().split("\\^")[12]);
			formBean.setStrPoMultiRefrenceNo(vo.getStrPOHiddenValue().split("\\^")[30]);
			formBean.setStrStoreName(vo.getStrPOHiddenValue().split("\\^")[31]);
			formBean.setStrDDeliveryDays(vo.getStrDDeliveryDays());
			formBean.setStrDDeliveryDays2(vo.getStrDDeliveryDays2());
			formBean.setStrDDeliveryDays3(vo.getStrDDeliveryDays3());
			formBean.setStrDDeliveryDays4(vo.getStrDDeliveryDays4());
			formBean.setStrDDeliveryDays5(vo.getStrDDeliveryDays5());
			formBean.setStrDDeliveryDays6(vo.getStrDDeliveryDays6());
			formBean.setStrDDeliveryDays7(vo.getStrDDeliveryDays7());
			formBean.setStrDDeliveryDays8(vo.getStrDDeliveryDays8());
			formBean.setStrPOHiddenValue(vo.getStrPOHiddenValue());
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrPONo(vo.getStrPOHiddenValue().split("\\^")[11]);
			vo.setStrItemId(vo.getStrItemBrandIds().split("\\@")[1]);
			//vo.setStrDeliveryLocationValues("0");
			
			//bo.getScheduleDtls(vo); // PKG_MMS_VIEW.PROC_PO_PROGRAMME_LIST
			// 2- Store List (Header)
			// 3- Data

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
            vo.setStrViewMode(formBean.getStrViewMode()); 
			formBean.setStrCtDate(hisutil.getASDate("dd-MMM-yyyy"));
		
			//formBean.setStrUserName((String) request.getSession().getAttribute("userName"));			
			response.setContentType("text/html;charset=UTF-8");
			if(formBean.getStrViewMode().equals("0"))
			{	
			     formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.storeLocationList(vo));
			}
			else
			{
				 formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.viewStoreLocationList(vo));
			}
			//System.out.println("*** " +vo.getStrPOHiddenValue().split("\\^").length);
			//formBean.setStrRateContQty("na");
			
		

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setItemCatValues1()---->", _Err
							.getMessage());
			formBean
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	/**
	 * Gets the item dtl hlp.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the item dtl hlp
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void LocationWiseProgrammeDtls(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		
		String strmsgText="";
		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			/**********************************************************************************/
		    //   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT
			// ^ (4) Supplier ID ^ (5)PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date 
			// ^ (18)Verify Date  ^ (19) Verify BY ^ (20) Financial Period(2013-2014)
			// ^ (21)Next PO Date ^ (22) Purchase Commite date ^ (23) Negotiation Meeting Date 
			// ^ (24)Remarks ^ (25) Verified By ^(26)Verify Date ^ (27) Total Amendment ^(28) Rate Contracted Flg 
			// ^ (29)PO Type Auth id ^ (30) PO Ref No^(31) Store Name {PO Created}
			// ^ (32)Purchase Source Name ^ (33) Rate Contract Id ^(34)PROGRAMME_ID^(35)FUNDING_SOURCE_ID^(36)REF_PO_NO
			// ^ (37)Prog Name ^ (38) Funding Src Name ^ (39) DRAFT_FLG
			/**********************************************************************************/
			//   10100524@10000524@1013379@70@630106^1^0@0@70@1@0^0@Bottle@Abbott Healthcare Pvt. Ltd.@ Rate Unit Name
			/********************************************************************************************************/
			String strHospitalCode 	= request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId 		= request.getSession().getAttribute("SEATID").toString();
			String strPONo 			= request.getParameter("strPOHiddenValue").split("\\^")[11];
			String strStoreId 		= request.getParameter("strStoreId");
			
			vo.setStrViewMode(request.getParameter("strViewMode")); 
			////System.out.println("Po Item Id--->"+request.getParameter("strPOItemId"));
			vo.setStrItemBrandIds(request.getParameter("strPOItemId"));
			vo.setStrPOHiddenValue(request.getParameter("strPOHiddenValue"));
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrPONo(strPONo);
			vo.setStrStoreId(strStoreId);           
            
			bo.getScheduleDtls(vo); // PKG_MMS_VIEW.PROC_PO_PROGRAMME_LIST
			// 2- Store List (Header)
			// 3- Data

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
            
			response.setContentType("text/html;charset=UTF-8");
			if(vo.getStrViewMode().equals("0"))
			{	
			     formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.storeLocationList(vo));
			}
			else
			{
				 formBean.setStrIndentItemList(SupplierDeskInterfaceTransHLP.viewStoreLocationList(vo));
			}						
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(formBean.getStrIndentItemList());
				
			} 
			catch (Exception e) 
			{
				throw e;
			}
			

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText =e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->LocationWiseProgrammeDtls()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Sets the view item cat values.
	 * 
	 * @param formBean
	 *            the _po desk generate trans fb
	 * @param _request
	 *            the _request
	 */
	public static void setDeliveryDetails(SupplierDeskInterfaceTransFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		SupplierDeskInterfaceTransVO vo = null;
		SupplierDeskInterfaceTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate,strPreviousDeliveryDtls="";
		try 
		{
			hisutil = new HisUtil("DWH Transaction", "PODeskGenerateTransDATA");
			vo = new SupplierDeskInterfaceTransVO();
			bo = new SupplierDeskInterfaceTransBO();
			strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
			strCurrentMonth = Integer.parseInt(strCurrentDate.split("\\-")[1]);
			ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			formBean.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));

			if (strCurrentMonth >= 4) {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]);
			} else {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]) - 1;
			}

			strFinancialStartDate = "01-Apr" + "-" + CURRENT_YEAR;
			strFinancialEndDate = "31-Mar" + "-" + (CURRENT_YEAR + 1);
			
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrHospitalCode(vo.getStrHospitalCode());			
				
			formBean.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			String chk = null;
		/*	
			if (request.getParameter("chk") == null) 
			{
				chk = formBean.getStrChk();
			} 
			else 
			{
				chk = request.getParameter("chk");
			}
			
			if ((chk != null) && !(chk.equals(""))) 
			{
				formBean.setStrChk(chk);
				formBean.setStrPONo(chk.replace("@", "#").split("#")[1]);		
				 // C.HSTNUM_PO_NO'@'C.HSTNUM_STORE_ID'@'C.PO_DATE'@'C.HSTNUM_SUPP_ACCEPTANCE_FLAG @ SSTNUM_POTYPE_ID @	HSTNUM_SUPPLIER_ID	
				//   10281500087 @ 99901134 @ 02-Sep-2015 @ 1 @ 28 @  1010002$8
				vo.setStrPONo(chk.split("@")[0]);
				vo.setStrItemCat("10");
				vo.setStrPOStoreId(chk.split("@")[1]);
				vo.setStrStoreId(chk.split("@")[1]);
				vo.setStrSupplierId(chk.split("@")[5].split("\\$")[0]);
			} 
			else 
			{
				//poStoreId = formBean.getStrPoStoreId();
				//PONo = formBean.getStrPoNo();
			}	*/
			
                chk = request.getParameter("strChk");
			
			
			if ((chk != null) && !(chk.equals(""))) 
			{
				formBean.setStrChk(chk);
				formBean.setStrPONo(chk.split("\\@")[0]);		
				 // C.HSTNUM_PO_NO'^'C.HSTNUM_STORE_ID'^'HSTNUM_SUPPLIER_ID '^'	C.PO_DATE'^'C.HSTNUM_SUPP_ACCEPTANCE_FLAG '^' SSTNUM_POTYPE_ID 		
				vo.setStrPONo(chk.split("\\@")[0]);
				vo.setStrItemCat("10");
				vo.setStrPOStoreId(chk.split("\\@")[1]);
				vo.setStrStoreId(chk.split("\\@")[1]);
				vo.setStrSupplierId(chk.split("\\@")[2]);
				//formBean.setStrPONo(chk.split("@")[0]);		
			} 
			else 
			{
				//poStoreId = formBean.getStrPoStoreId();
				//PONo = formBean.getStrPoNo();
			}
			vo.setStrFinancialStartDate(strFinancialStartDate);
			vo.setStrFinancialToDate(strFinancialEndDate);
			vo.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			vo.setStrSeatId((String) request.getSession().getAttribute("SEATID"));			
			// Calling BO Method To Get PO Detail(s)
			bo.getPODetails(vo); // pkg_mms_view.Proc_Po_Details [ Mode=4 ]
			/*
			 * Mode-->1=Consignee Name
			 * Mode-->2=Schedule No
			 * Mode-->3=Drug Name
			 * Mode-->4=Batch Combo
			 * Mode-->6=Previous Delivery Details
			 * */		
		    vo.setStrMode("1"); 
		    bo.getCommonProcedure(vo);  // PKG_MMS_VIEW2.proc_supplier_interface_dtl
		        
		    formBean.setStrConsigneeStoreCombo(vo.getStrConsigneeStoreCombo());
			bo.deliveryModeList(vo);
			vo.setStrMode("6");
			bo.getCommonProcedure(vo);  // To Get Previous Supply Details
			
			response.setContentType("text/html;charset=UTF-8");
			strPreviousDeliveryDtls = SupplierDeskInterfaceTransHLP.getPreviousDeliveryDtls(vo,request,"0");			
			////System.out.println("strPreviousDeliveryDtls--->"+strPreviousDeliveryDtls);
			
			formBean.setStrPreviousDeliveryDtls(strPreviousDeliveryDtls);
			
			/**********************************************************************************/
		    //   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT
			// ^ (4) Supplier ID ^ (5)PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date 
			// ^ (18)Verify Date  ^ (19) Verify BY ^ (20) Financial Period(2013-2014)
			// ^ (21)Next PO Date ^ (22) Purchase Commite date ^ (23) Negotiation Meeting Date 
			// ^ (24)Remarks ^ (25) Verified By ^(26)Verify Date ^ (27) Total Amendment ^(28) Rate Contracted Flg 
			// ^ (29)PO Type Auth id ^ (30) PO Ref No^(31) Store Name {PO Created}
			// ^ (32)Purchase Source Name ^ (33) Rate Contract Id ^(34)PROGRAMME_ID^(35)FUNDING_SOURCE_ID^(36)REF_PO_NO
			// ^ (37)Prog Name ^ (38) Funding Src Name ^ (39) DRAFT_FLG
			/**********************************************************************************/
			  
			
			formBean.setStrDrugNameCombo(vo.getStrDrugNameCombo());
			formBean.setStrPONoWithPreFix(vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+vo.getStrPOHiddenValue().split("\\^")[11]+" )");
			formBean.setStrPORefrenceDate(vo.getStrPOHiddenValue().split("\\^")[0]);
			formBean.setStrPurchaseSourceValues(vo.getStrPurchaseSourceValues());
			formBean.setStrApprovedByVals(vo.getStrPOHiddenValue().split("\\^")[25]);
			formBean.setStrCurrentDate(hisutil.getDSDate("DD-Mon-yyyy"));
			formBean.setStrComboPOTypeValue(vo.getStrPOHiddenValue().split("\\^")[2]);
			formBean.setStrPOHiddenValue(vo.getStrPOHiddenValue());
			formBean.setStrPOFinancialYear(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrSupplierName(vo.getStrPOHiddenValue().split("\\^")[1]);
			formBean.setStrSupplierId(vo.getStrPOHiddenValue().split("\\^")[4]);
			formBean.setStrIndentPeriodValue(vo.getStrPOHiddenValue().split("\\^")[20]);
			formBean.setStrComboPOTypeId(vo.getStrPOHiddenValue().split("\\^")[5]);
			formBean.setStrDRemarks(vo.getStrPOHiddenValue().split("\\^")[24]);
			formBean.setStrVerifiedDate(vo.getStrPOHiddenValue().split("\\^")[26]);
			formBean.setStrPoRefrenceNoText(vo.getStrPOHiddenValue().split("\\^")[12]);
			formBean.setStrPoMultiRefrenceNo(vo.getStrPOHiddenValue().split("\\^")[30]);
			formBean.setStrStoreName(vo.getStrPOHiddenValue().split("\\^")[31]);
			formBean.setStrPOStoreId(vo.getStrPOStoreId());
			formBean.setStrPONo(vo.getStrPONo());
			formBean.setStrDeliveryModeValues(vo.getStrDeliveryMode());
			formBean.setStrPrgId(vo.getStrPrgId());
			formBean.setStrFSId(vo.getStrFSId());
			formBean.setStrFSName(vo.getStrFSName());
			formBean.setStrPrgName(vo.getStrPrgName()); 	
			formBean.setStrManufacturerValues(vo.getStrManufacturerValues());
			formBean.setStrItemNameNew(vo.getStrItemNameNew());
			formBean.setStrBatchExdateFlag(vo.getStrBatchExdateFlag());
			//System.out.println("vo.getStrBatchExdateFlag():::::::::"+vo.getStrBatchExdateFlag());
		

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setDeliveryDetails()---->", _Err
							.getMessage());
			formBean
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	

	/**
	 * Gets the schedule dtls two.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the schedule dtls two
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getPreviousDeliveryDtls(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;

	

		String strmsgText = "";

		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
		
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPoNo");
			String strPOStoreId = request.getParameter("strPoStoreId");
			String strDeliveryStoreId = request.getParameter("strDeliveryStorId");	
			String strPOTypeId = request.getParameter("strPoTypeId");
			/*
			 * Mode-->1=Consignee Name
			 * Mode-->2=Schedule No
			 * Mode-->3=Drug Name
			 * Mode-->4=Batch Combo
			 * Mode-->6=Previous Delivery Details
			 * */
			vo.setStrMode("6");
			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);
			vo.setStrPOTypeId(strPOTypeId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			
			
			// Calling BO Method
			bo.getCommonProcedure(vo); 

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			try 
			{
				response.setContentType("text/html;charset=UTF-8");
				String strPreviousDeliveryDtls = SupplierDeskInterfaceTransHLP.getPreviousDeliveryDtls(vo,request,"1");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPreviousDeliveryDtls);
			} 
			catch (Exception e) 
			{
				throw e;
			}

		} catch (Exception e) {
			strmsgText =  e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->getScheduleDtlsTwo()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	
	/**
	 * Gets the schedule dtls two.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the schedule dtls two
	 * @throws ServletException 
	 * @throws IOException 
	 */
	
	
	
	
	public static void getBatchCombo(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;

	

		String strmsgText = "";
		HisUtil hisutil = null;		
		String strBatchCombo ="";

		try {
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("pono");
			String Count=request.getParameter("objValue");			
			
			
			vo.setStrPONo(strPONo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			
			
			// Calling BO Method
			bo.getBatchCombo(vo);		
			
			
			if (vo.getStrBatchNoWs().size() == 0
					|| vo.getStrBatchNoWs() == null) 
			{
				strBatchCombo = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				strBatchCombo = hisutil.getOptionValue(vo.getStrBatchNoWs(), "0",
						"0^Select Value", false);

			}
			vo.setStrBatchNoCmb(strBatchCombo);
			//System.out.println("strBatchCombo"+strBatchCombo);	
			
		/*	response.setContentType("text/html;charset=UTF-8");			
			response.setHeader("Cache-Control", "no-cache");	
			response.getWriter().print(strBatchCombo + "$" + Count);*/

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA.getBatchCombo()",
					strmsgText);
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	public static void getScheduleCombo(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;

	

		String strmsgText = "";

		try {
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPoNo");
			String strPOStoreId = request.getParameter("strPoStoreId");
			String strDeliveryStoreId = request.getParameter("strDeliveryStorId");	
			String strPOTypeId = request.getParameter("strPoTypeId");
			String strReplacementDirectBatchFlag = request.getParameter("strReplacementDirectBatchFlag");
			/*
			 * Mode-->1=Consignee Name
			 * Mode-->2=Schedule No
			 * Mode-->3=Drug Name
			 * Mode-->4=Batch Combo
			 * */
			
			if (strReplacementDirectBatchFlag.equals("1"))
			{
			vo.setStrMode("10");
			}
			else if (strReplacementDirectBatchFlag.equals("2"))
			{
			vo.setStrMode("11");
			}
			else
			{
			vo.setStrMode("2");
			}
			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);
			vo.setStrPOTypeId(strPOTypeId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrReplacementDirectBatchFlag(strReplacementDirectBatchFlag);
			
			
			// Calling BO Method
			bo.getCommonProcedure(vo); 
			
			//System.out.println("vo.getStrPreInvoiceNo()::::"+ vo.getStrPreInvoiceNo());
			
			formBean.setStrPrevInvoiceExists(vo.getStrPreInvoiceNo());
			
			//System.out.println("formBean.getStrPrevInvoiceExists()::::"+ formBean.getStrPrevInvoiceExists());

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(vo.getStrSchedule()+"#"+vo.getStrPreInvoiceNo());
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText =  e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->getScheduleDtlsTwo()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Gets the schedule dtls two.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the schedule dtls two
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getStrDrugNameCombo(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;

		

		try {
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			hisutil = new HisUtil("mms", "SupplierDeskInterfaceTransDATA");
			

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPoNo");
			String strPOStoreId = request.getParameter("strPoStoreId");
			String strDeliveryStoreId = request.getParameter("strDeliveryStorId");	
			String strPOTypeId = request.getParameter("strPoTypeId");
			String strScheduleNo = request.getParameter("strShcheduleNo");
			String strReplacementDirectBatchFlag = request.getParameter("strReplacementDirectBatchFlag");
			
		     /*
			 * Mode-->1=Consignee Name
			 * Mode-->2=Schedule No
			 * Mode-->3=Drug Name
			 * Mode-->4=Batch Combo
			 * */
			vo.setStrMode("3");
			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);
			vo.setStrPOTypeId(strPOTypeId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrScheduleNo(strScheduleNo);
			vo.setStrReplacementDirectBatchFlag(strReplacementDirectBatchFlag);
			
			
			if (vo.getStrReplacementDirectBatchFlag().equals("0"))
				
			{
				vo.setStrMode("3");
				
			}
			
			else  if (vo.getStrReplacementDirectBatchFlag().equals("1"))
			
			{
				
				vo.setStrMode("14");
			}
			
			else  if (vo.getStrReplacementDirectBatchFlag().equals("2"))
				
			{
				vo.setStrMode("15");
				
			}
			
			// Calling BO Method
			bo.getCommonProcedure(vo); 
			if (vo.getWsBatchList() != null && vo.getWsBatchList().size() > 0) {
				formBean.setStrLeftBatchNos(hisutil.getOptionValue(vo.getWsBatchList(), "0", "", false, false));
				//System.out.println(formBean.getStrLeftBatchNos());
			} else {
				formBean.setStrLeftBatchNos("<option value='0'></option>");
			}

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			String result = vo.getStrDrugNameCombo()+"#"+formBean.getStrLeftBatchNos();
			//System.out.println(result);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(result);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText =  e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->getStrDrugNameCombo()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	/**
	 * Gets the item dtl hlp.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the item dtl hlp
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void deleteDetails(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		
		String strmsgText="",strScheduleContent="";;
		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();

			 // HSTNUM_PO_NO||''^''||HSTNUM_SCHEDULE_NO||''^''|| HSTNUM_STORE_ID||''^''|| HSTNUM_DELIVERY_NO ||''^''|| HSTNUM_PO_STORE_ID
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPKey").split("\\^")[0];
			String strPOStoreId = request.getParameter("strPKey").split("\\^")[4];
			String strDeliveryStoreId = request.getParameter("strPKey").split("\\^")[2];			
			String strScheduleNo = request.getParameter("strPKey").split("\\^")[1];
            String strDeliveryNo = request.getParameter("strPKey").split("\\^")[3];
            String strDeleteRemarks = request.getParameter("strDeleteRemarks");
			vo.setStrMode("5");
			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrScheduleNo(strScheduleNo);			
			vo.setStrDeliveryNo(strDeliveryNo);
			vo.setStrDeleteRemarks(strDeleteRemarks);
			bo.deleteRecords(vo);
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{	
					vo.setStrMode("6");
					bo.getCommonProcedure(vo);  // To Get Previous Supply Details
				
					if (vo.getStrMsgType().equals("1"))
					{
						throw new Exception(vo.getStrMsgString());
					}
						
					response.setContentType("text/html;charset=UTF-8");
					strScheduleContent = SupplierDeskInterfaceTransHLP.getPreviousDeliveryDtls(vo,request,"0");			
					try 
					{
						response.setHeader("Cache-Control", "no-cache");
						response.getWriter().print(strScheduleContent);
						
					} 
					catch (Exception e) 
					{
						throw e;
					}
			}

		}
		catch (Exception e) 
		{
			strmsgText =e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->getItemDtlHlp()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Gets the item dtl hlp.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the item dtl hlp
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void viewDetails(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		
		String strmsgText="",strScheduleContent="";;
		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();

			 // HSTNUM_PO_NO||''^''||HSTNUM_SCHEDULE_NO||''^''|| HSTNUM_STORE_ID||''^''|| HSTNUM_DELIVERY_NO ||''^''|| HSTNUM_PO_STORE_ID
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPKey").split("\\^")[0];
			String strPOStoreId = request.getParameter("strPKey").split("\\^")[4];
			String strDeliveryStoreId = request.getParameter("strPKey").split("\\^")[2];			
			String strScheduleNo = request.getParameter("strPKey").split("\\^")[1];
            String strDeliveryNo = request.getParameter("strPKey").split("\\^")[3];
            String strConsignee = request.getParameter("strConsignee");
			
			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrScheduleNo(strScheduleNo);			
			vo.setStrDrugBrandId(strDeliveryNo);
			
			vo.setStrMode("7");
			bo.getCommonProcedure(vo);  // To Get Previous Supply Details  PKG_MMS_VIEW2.proc_supplier_interface_dtl [ Mode = 7 ]
		
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
				
			response.setContentType("text/html;charset=UTF-8");
			strScheduleContent = SupplierDeskInterfaceTransHLP.getPopUpDtl(vo,request,strConsignee);			
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent);
				
			} 
			catch (Exception e) 
			{
				throw e;
			}
			

		}
		catch (Exception e) 
		{
			strmsgText =e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->viewDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Gets the item dtl hlp.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the item dtl hlp
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void getItemDtlHlp(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "", strScheduleContent = "";
		String strUnitCmb = "",strCartonSizeCmb="";
		String strBatchCombo ="";
		int prepoflag = 0;
		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			hisutil = new HisUtil("mms", "SupplierDeskInterfaceTransDATA");
			
			//System.out.println("formBean.getStrChk()----->"+formBean.getStrChk());

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strPONo = request.getParameter("strPoNo");
			String strPOStoreId = request.getParameter("strPoStoreId");
			String strDeliveryStoreId = request.getParameter("strDeliveryStorId");	
			String strPOTypeId = request.getParameter("strPoTypeId");
			String strScheduleNo = request.getParameter("strScheduleNo");
			String strPoPreFlag = request.getParameter("strPoPreFlag");
			String strReplacementDirectBatchFlag = request.getParameter("strReplacementDirectBatchFlag");
			String strBatchExdateFlag = request.getParameter("strBatchExdateFlag");
			
			vo.setStrBatchExdateFlag(strBatchExdateFlag);
			//System.out.println("vo.getStrBatchExdateFlag()::::::::::"+vo.getStrBatchExdateFlag());
			
			
			
			if(strReplacementDirectBatchFlag.equals("1"))
			{
				vo.setStrMode("12");
			}
			else if(strReplacementDirectBatchFlag.equals("2"))
			{
				vo.setStrMode("13");
			}
			else
			{
				vo.setStrMode("5");
			}
			
			

			vo.setStrPONo(strPONo);
			vo.setStrPOStoreId(strPOStoreId);
			vo.setStrDeliveryStoreId(strDeliveryStoreId);
			vo.setStrPOTypeId(strPOTypeId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrScheduleNo(strScheduleNo);			
			vo.setStrDrugBrandId(request.getParameter("strItemBrandId"));
			vo.setStrItemId(request.getParameter("strItemId"));
			vo.setStrReplacementDirectBatchFlag(strReplacementDirectBatchFlag);
			
			// Calling BO method
			bo.getItemHlp(vo); // PKG_MMS_VIEW2.proc_supplier_interface_dtl [ Mode =5 ]
			                   // Pkg_Mms_View.Proc_Gblt_Unit_Mst
 			                   // MMS_MST.get_rejected_batch_dtl 
			
			
			
			vo.setStrMode("4");
			bo.getCommonProcedure(vo);

			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getWsUnitList() != null && vo.getWsUnitList().size() > 0)
			{
				strUnitCmb = hisutil.getOptionValue(vo.getWsUnitList(), vo.getStrUnitId(), "", false, false);
			} 
			else 
			{
				strUnitCmb = "<option value='0'>Select</option>";
			}
	
			
						
			if (vo.getCartonSizeWs() != null && vo.getCartonSizeWs().size() > 0) {
				strCartonSizeCmb = hisutil.getOptionValue(vo.getCartonSizeWs(),"0", "0^Select Value",true, false);
			} else {
				strCartonSizeCmb = "<option value='0'>Select</option>";
			}
			vo.setStrCartonSizeCmb(strCartonSizeCmb);
			
			vo.setStrPoPreFlag(strPoPreFlag);
			
			prepoflag = Integer.parseInt(strPoPreFlag);
			
			if(prepoflag == 1)
				
			{
			
			bo.getBatchCombo(vo);		
			
			
			if (vo.getStrBatchNoWs().size() == 0
					|| vo.getStrBatchNoWs() == null) 
			{
				strBatchCombo = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				strBatchCombo = hisutil.getOptionValue(vo.getStrBatchNoWs(), "","0^Select Value", false);

			}
			vo.setStrBatchNoCmb(strBatchCombo);
			}
			
			response.setContentType("text/html;charset=UTF-8");
			strScheduleContent = SupplierDeskInterfaceTransHLP.getScheduleItemList(formBean, vo,request,"1");
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent + "$$$$" + strUnitCmb + "$$@@$$"+vo.getStrRejectedBatchList());
				
				
			} 
			catch (Exception e) 
			{
				throw e;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText =e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->getItemDtlHlp()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Insert freeze challan.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static boolean insertAcceptance(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		boolean fltRes = false;
		String strmsgText = "";

		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrPOHiddenValue(formBean.getStrPOHiddenValue());
			vo.setStrApprovalFlag(formBean.getStrApprovalFlag());
			
			// Calling BO Method Here
			bo.insertAcceptance(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			if(vo.getStrApprovalFlag().equals("2"))
			{	
			    formBean.setStrMsg("Rejected Details For \n PO No. :  "+vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+ vo.getStrPOHiddenValue().split("\\^")[11]+" ) for HQ ["+vo.getStrPOHiddenValue().split("\\^")[25]+"] Saved Successfully");
			}
			else
			{
				formBean.setStrMsg("Acceptance Details For \n PO No. :  "+vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+ vo.getStrPOHiddenValue().split("\\^")[11]+" ) for HQ ["+vo.getStrPOHiddenValue().split("\\^")[25]+"] Saved Successfully");	
			}
			fltRes = true;

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->insertAcceptance()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

		return fltRes;

	}
	
	/**
	 * Insert freeze challan.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static boolean insertDelivery(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		boolean fltRes = false;
		String strmsgText = "";
	
		HisUtil hisutil = null;
		
		String strFileExt = "";
		String strFileName = "";
		String temp[] = null;
		String strFileSaveMsg = "";
		String strContentType="";				
		Tika tika = null;


		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();
			hisutil = new HisUtil("","");
			vo = (SupplierDeskInterfaceTransVO) TransferObjectFactory.populateData("mms.transactions.vo.SupplierDeskInterfaceTransVO", formBean);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrScheduleNo(formBean.getStrScheduleNo().split("\\^")[0]);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrPOHiddenValue(formBean.getStrPOHiddenValue());
			vo.setStrApprovalFlag(formBean.getStrApprovalFlag());
			vo.setStrReplacementDirectBatchFlag(formBean.getStrReplacementDirectBatchFlag());
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrDeliveryStoreId(formBean.getStrDeliveryStoreId());
			vo.setStrPrgId(formBean.getStrPrgId());
			vo.setStrFSId(formBean.getStrFSId());
			vo.setStrPoPreFlag(formBean.getStrScheduleNo().split("\\^")[2]);
			//System.out.println("formBean.getStrReplacementDirectBatchFlag()---->"+formBean.getStrReplacementDirectBatchFlag());
			//System.out.println("formBean.getStrBatchNo()---->"+formBean.getStrBatchNo());
			 
			
			/* File Up-Loading Facility */

			FormFile myFile = formBean.getStrLocation();

			if (myFile.getFileData().length > 0 && myFile.getFileData() != null) 
			
			{
				
				
				strFileExt = myFile.getFileName();
                /*
                Input Stram---->application/pdf
                size is 6
                Input Stram---->text/plain                
                size is 6
                Input Stram---->image/jpeg
                size is 6
                Input Stram---->image/png
                size is 6
                Input Stram---->application/xml
                size is 6
                Input Stram---->text/html
                */
                              
				/*if(! HisUtil.validateFileName(strFileExt))
 				{
					throw new Exception("Please Upload a File with Valid File Name"); 
				}*/
				
               temp = strFileExt.replace('.', '#').split("#");
				strFileExt = temp[temp.length - 1];
				
				
				/*if( ! HisUtil.validateFileExtention(strFileExt) ) 
				{
			        
					throw new Exception("Not a Valid File Extension, Valid Extensions are JPEG, JPG, DOC, DOCX and PDF  ");
				}*/	
                ////System.out.println("strFileExt---->"+strFileExt.trim());
                
                //Instantiating tika facade class 
               
                
				// HisUtil.validateFileContentType(strFileExt, myFile);
				
				
				vo.setStrFileNo(formBean.getStrFileNo());
				vo.setStrPageNo(formBean.getStrPageNo());
				strFileExt = myFile.getFileName();
				temp = strFileExt.replace('.', '#').split("#");
				strFileExt = temp[temp.length - 1];
				strFileName = vo.getStrFileNo()	+ "_"+ (hisutil.getASDate("dd-MMM-yyyy HH-mm-SS").split("\\ ")[0]+ "" + hisutil
								.getASDate("dd-MMM-yyyy HH-mm-SS").split("\\ ")[1])
						+ "." + strFileExt;
				//String saveFileString = SaveFileInFtpGlobal.saveFileToFTPLocation(vo.getStrHospitalCode(), strFileName,myFile.getInputStream());
				/*if (saveFileString.equals("1")) 
				{
					strFileSaveMsg = " & File Successfully Up-Load";
				} 
				else 
				{
					strFileSaveMsg = " & File Not Up-Load due to FTP server Error";
				}*/
				vo.setStrFileName(strFileName);
			}
			
			// Calling BO Method Here
			bo.insertDelivery(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
			/** ******************************************************************************* */           
			//formBean.setStrMsg("Delivery Details For  Saved Successfully");
			formBean.setStrMsg("Delivery Details For \n PO No. :  "+vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+ vo.getStrPOHiddenValue().split("\\^")[11]+" ) for HQ ["+vo.getStrPOHiddenValue().split("\\^")[25]+"] Saved Successfully");
			
			if (myFile.getFileData() != null && myFile.getFileData().length > 0) 
			{	
				 formBean.setStrMsg("Delivery Details For \n PO No. :  "+vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+ vo.getStrPOHiddenValue().split("\\^")[11]+" ) for HQ ["+vo.getStrPOHiddenValue().split("\\^")[25]+"] Saved Successfully"+strFileSaveMsg);
			}
			else
			{	
				formBean.setStrMsg("Delivery Details For \n PO No. :  "+vo.getStrPOHiddenValue().split("\\^")[12]+" ( "+ vo.getStrPOHiddenValue().split("\\^")[11]+" ) for HQ ["+vo.getStrPOHiddenValue().split("\\^")[25]+"] Saved Successfully");
			}  
			formBean.setStrBarCodeString(vo.getStrBarCodeString());
			
			fltRes = true;

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("mms", "SupplierDeskInterfaceTransDATA->insertDelivery()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

		return fltRes;

	}
	public static void getBarcodeDtls(SupplierDeskInterfaceTransFB fb,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{

		String hosCode = "",strPKey="";		

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;

		try {

			/* Creating Object */
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();

			//[ PO_NO||'^'||SCHEDULE_NO||'^'|| STORE_ID||'^'|| DELIVERY_NO ||'^'||HSTNUM_PO_STORE_ID]
			  
			strPKey = request.getParameter("strPKey");
			

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);			
			vo.setStrDeliveryStoreId(strPKey.split("\\^")[2]);
			vo.setStrPOStoreId(strPKey.split("\\^")[4]);
			vo.setStrPONo(strPKey.split("\\^")[0]);
			vo.setStrScheduleNo(strPKey.split("\\^")[1]);
			vo.setStrDeliveryNo(strPKey.split("\\^")[3]);		
			vo.setStrDrugBrandId(vo.getStrDeliveryNo());
            vo.setStrMode("9");
			bo.getCommonProcedure(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(vo.getStrBarCodeString());

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			HisException eObj = new HisException("mms",	"SupplierDeskInterfaceTransDATA.getRackDetails()", e.getMessage());
			fb.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * Download file.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request_p
	 *            the request_p
	 * @param response_p
	 *            the response_p
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception
	 */
	
	public static void downloadFile(SupplierDeskInterfaceTransFB formBean,
			HttpServletRequest request_p, HttpServletResponse response_p) throws Exception {

		String strFileName = formBean.getStrUploadFileId();
		String hospitalCode = request_p.getSession().getAttribute(
				"HOSPITAL_CODE").toString();

	//	SaveFileInFtpGlobal.downloadFileFromFTP(hospitalCode, strFileName,				response_p);

	}
	
	/*public static void downloadFile(SupplierDeskInterfaceTransFB formBean,
			HttpServletRequest request_p, HttpServletResponse response_p)
			throws IOException, ServletException {

		String strmsgText = null;
		String strFileName = "";
		File f = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] fileContent = new byte[1024];
		String strFtpFolderName = "";
		try {

			strFtpFolderName = SaveFileInFtpGlobal.downLoadFileToLocation(formBean.getStrHospitalCode()).split("\\^")[1];
			strFileName = formBean.getStrUploadFileId();
			String[] strTemp = strFileName.replace(".", "#").split("#");
			String strExt = strTemp[strTemp.length - 1];
			String fileUrl = SaveFileInFtpGlobal.downLoadFileToLocation(
					formBean.getStrHospitalCode()).split("\\^")[0]
					+ "/"
					+ SaveFileInFtpGlobal.downLoadFileToLocation(
							formBean.getStrHospitalCode()).split("\\^")[1];

			if (strExt.equalsIgnoreCase("txt")
					|| strExt.equalsIgnoreCase("txt")) {

				response_p.setContentType("application/txt");
				response_p.setHeader("Content-disposition", " filename="
						+ strFtpFolderName + "" + strFileName);

			} else if (strExt.equalsIgnoreCase("pdf")) {

				response_p.setContentType("application/pdf");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("html")
					|| strExt.equalsIgnoreCase("htm")) {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("xlsx")
					|| strExt.equalsIgnoreCase("xlsx")) {

				response_p.setContentType("application/xlsx");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("xml")) {

				response_p.setContentType("application/xml");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("doc")
					|| strExt.equalsIgnoreCase("docx")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("rdf")) {
				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else if (strExt.equalsIgnoreCase("rtf")) {

				response_p.setContentType("application/msword");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			} else {

				response_p.setContentType("text/html;charset=utf-8");
				response_p.setHeader("Content-disposition",
						"attachment; filename=" + strFtpFolderName + ""
								+ strFileName);

			}
            //System.out.println("FTP URL--->"+fileUrl + "/" + strFileName);
			URL urlftp = new URL(fileUrl + "/" + strFileName);
			URLConnection urlc = urlftp.openConnection();
			InputStream io = urlc.getInputStream();

			fos = new FileOutputStream(strFileName);
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = io.read(buf)) > 0) {
				fos.write(buf, 0, read);
			}

			f = new File(strFileName);

			if (!f.isFile()) {

				throw new Exception("Invalid File Path");
			}

			fis = new FileInputStream(f);

			while (fis.read(fileContent) != -1) {

				response_p.getOutputStream().write(fileContent);
			}
		}
		catch (Exception e) 
		{
            e.printStackTrace(); 
			strmsgText = e.getMessage();
			new HisException("mms",
					"SupplierDeskInterfaceTransDATA->downloadFile()",
					strmsgText, request_p, response_p);

		} finally {

			if (f != null) {
				f = null;
			}
			if (fis != null) {
				fis = null;
			}
			if (fos != null) {
				fos = null;
			}
		}
	}
*/	
	public static ArrayList<SupplierDeskInterfaceTransJqgridListFB> SupplierInterfaceDATAList(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		ArrayList<SupplierDeskInterfaceTransJqgridListFB> messageData = new ArrayList<SupplierDeskInterfaceTransJqgridListFB>();
		try 
		{
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();								
			// Get value from Session
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			bo.getSupplierInterfacedataList(vo); 

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			WebRowSet rs = vo.getWbSupplierInterfaceListDtl();
			while (rs.next()) 
			{			
				SupplierDeskInterfaceTransJqgridListFB messageObject = new SupplierDeskInterfaceTransJqgridListFB();
				
				messageObject.setPo_no(rs.getString(1));
				messageObject.setSupplierid(rs.getString(6));
				messageObject.setSuppliername(rs.getString(14));
				messageObject.setPrefixpono(rs.getString(11));
				messageObject.setPodate(rs.getString(3));
				messageObject.setSuppaccflag(rs.getString(4));
				messageObject.setPotypeid(rs.getString(5));
				messageObject.setPredeliveryflag(rs.getString(7));
				messageObject.setOrderdqty(rs.getString(8));
				messageObject.setBalanceqty(rs.getString(9));
				messageObject.setItemname(rs.getString(10));
				messageObject.setStatus(rs.getString(12));
				messageObject.setStoreid(rs.getString(2));

				messageData.add(messageObject);
				//formBean.setStrStoreId(rs.getString(1));
			}	
			
			////System.out.println("---------"+formBean.getStrStoreId());
			
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			HisException eObj = new HisException("mms", "SupplierMstDATA.IndentingStoreCombo()", vo.getStrMsgString());
			
			response.getWriter().print(vo.getStrMsgString());

			//eObj = null;

		} finally {
			//bo = null;
			//vo = null;
		}
		return messageData;
	}
	public static void getReport(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		SupplierDeskInterfaceTransBO bo = null;
		SupplierDeskInterfaceTransVO vo = null;
		String strMsgText = null;
		String strReportHeader = "";		
		try {
			bo = new SupplierDeskInterfaceTransBO();
			vo = new SupplierDeskInterfaceTransVO();

			String strUserName = "";//request.getSession().getAttribute("userName").toString();								
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			//pc-10^^^^^^^^Accepted^Active
			//document.forms[0].strChk.value = document.forms[0].itemName.value + "^"  + document.forms[0].supplierName.value + "^" + document.forms[0].supplierLevelName.value + "^" + document.forms[0].rate.value + "^" + document.forms[0].tax.value + "^" document.forms[0].addTax.value + "^" + document.forms[0].acceptanceNo.value + "^" + document.forms[0].acceptanceDate.value + "^" + document.forms[0].acceptanceStatusValue[document.forms[0].acceptanceStatusValue.selectedIndex].text + "^" + document.forms[0].status[document.forms[0].status.selectedIndex].text;
			vo.setStrSupplierName(request.getParameter("strChk").split("\\^")[0]);
			vo.setStrPODate(request.getParameter("strChk").split("\\^")[2]);
			vo.setStrItemNameNew(request.getParameter("strChk").split("\\^")[5]);
			vo.setPrefixpono(request.getParameter("strChk").split("\\^")[1]);
			vo.setOrderdqty(request.getParameter("strChk").split("\\^")[3]);
			vo.setBalanceqty(request.getParameter("strChk").split("\\^")[4]);
			
			
			vo.setStatus(request.getParameter("strChk").split("\\^")[6]);
						
			
			bo.getSupplierInterfaceRpt(vo);
		
			response.setContentType("text/html;charset=UTF-8");
		
			String SupplierInterfaceRpt = SupplierDeskInterfaceTransHLP.getReportDtlPopUp(vo, strReportHeader,strUserName ,request);
			////System.out.println("strDrugMasterReport--->"+strDrugMasterReport);
	        formBean.setStrSupplierInterfaceReport(SupplierInterfaceRpt);  
	       // //System.out.println("SupplierInterfaceRpt=="+SupplierInterfaceRpt);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException("mms", "DrugMstDATA.getDrugReport()",strMsgText);
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (vo != null) {
				vo = null;
			}

		}

	}
	public static void generatePdf1(SupplierDeskInterfaceTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strSearchItemInitView = "";

		try {

			/*String strHtmlCode = formBean.getStrHtmlCode().replace("&", "and").replace("&nbsp;", "");

		 
			strSearchItemInitView = "<html><head><link href='http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()
					+"/hisglobal/css/dwh.css' rel='stylesheet' type='text/css' media='print'></link><style type='text/css'>@page {size: 15.5in 16.5in; margin-left:0in; margin-right:0in; "
					+ "margin-top:0.25in; margin-bottom: 0.25in;} " 
					+ "</style></head><body>" + strHtmlCode
					+ "</body></html>";*/
			
			String strHtmlCode = formBean.getStrHtmlCode().replace("&", "and").replaceAll("&nbsp;","").replace("<li> ","<li>").replaceAll("  ", "");
			//strPoDetails = "<html><head><style type='text/css'>@page {size: 9.75in 15.5in; margin-left:0in; margin-right:0in; "
			strSearchItemInitView = "<html><head><style type='text/css'>@page {size: 9.75in 13.5in; margin-left:0in; margin-right:0in; "
					+ "margin-top:0.25in; margin-bottom: 0.25in;} #break{page-break-after:always;} "
					+ "@media print {#backgroundprint{opacity:0.4;filter:alpha(opacity=40); }}#backgroundprint{position:absolute;z-index:-1;display:block;"
					+ "color:#eaeaf9;font-size:200px;margin-left:10%;margin-top:50%; transform: rotate(336deg);}"
					+ "#contentprint{position:absolute;z-index:1;}</style></head><body>" + strHtmlCode + "</body></html>";

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=SupplierInterface.pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response,strSearchItemInitView);

		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "OfflineIssueIndentTransDATA.issueDtlsInitPdf(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OfflineIssueIndentTransDATA.issueDtlsInitPdf(vo) --> ",
					strmsgText);
			eObj.printStackTrace();
			eObj = null;

		}
	}
	
}