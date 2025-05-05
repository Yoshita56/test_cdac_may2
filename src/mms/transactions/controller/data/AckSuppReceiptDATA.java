/**
 * 
 */
package mms.transactions.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.ReportUtil;
import hisglobal.backutil.HelperMethods;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.AckSuppReceiptBO;
import mms.transactions.controller.fb.AckSuppReceiptFB;
import mms.transactions.controller.hlp.AckSuppReceiptHLP;
import mms.transactions.vo.AckSuppReceiptVO;

/**
 * @author user
 *
 */
public class AckSuppReceiptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(AckSuppReceiptFB formBean,HttpServletRequest request) {
		AckSuppReceiptVO vo=null;
		AckSuppReceiptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strStoreName ,strItemCmb,supplierId="0",purchaseThropughId="0";
		String temp = "";
		String temp1 = "";
			
		try {
			vo = new AckSuppReceiptVO();
			bo = new AckSuppReceiptBO();
			
			hisutil = new HisUtil("mms", "AckSuppReceiptDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			
			vo.setStrLpoNo(formBean.getStrLpoNo());
//			System.out.println("vo.getStrLpoNo()---------->"+vo.getStrLpoNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			
			
			
			bo.initialAdd(vo);
			
			/*
			if(vo.getWsPrint().next())
			{
				formBean.setStrItemCategoeryName(vo.getWsPrint().getString(25));
				formBean.setStrStoreName(vo.getWsPrint().getString(1));
				formBean.setStrDCNo(vo.getWsPrint().getString(12).split("\\#")[0]);
				formBean.setStrChallanDate(vo.getWsPrint().getString(3));
				formBean.setStrInvoiceNo(vo.getWsPrint().getString(2));
				formBean.setStrInvoiceDate(vo.getWsPrint().getString(3));
				formBean.setStrLpoNo(vo.getWsPrint().getString(2));
				supplierId = vo.getWsPrint().getString(30);
				purchaseThropughId = vo.getWsPrint().getString(31);
				
			}
			
			vo.getWsPrint().beforeFirst();
			*/
			
			String strPrintItemDtl ="";
					
			/*
			 if(vo.getStrItemCategoryNo().equals("10"))
			 {
				 System.out.println("<--------AckSuppReceiptHLP.getLPDrugDetails ------->");
				 
			    strPrintItemDtl = AckSuppReceiptHLP.getLPDrugDetails(vo.getWsPrint(),hosCode,vo);
			 }
			 else
			 {
				 System.out.println("<--------AckSuppReceiptHLP.getLPItemDetails ------->");
                strPrintItemDtl = AckSuppReceiptHLP.getLPItemDetails(vo.getWsPrint(),hosCode,vo);
			 }
			 */
			
			strPrintItemDtl = AckSuppReceiptHLP.getLPDrugDetails(vo.getWsPrint(),hosCode,vo);
			
			
			formBean.setStrPrintDtls(strPrintItemDtl);
			
			System.out.println("vo.getStrBatchNo()------>"+vo.getStrBatchNo());
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			
			
			temp=hisutil.getOptionValue(vo.getStrSupplierWs(), supplierId,"0^Select Value",false);
			temp1=hisutil.getOptionValue(vo.getStrSupplierWs1(), purchaseThropughId,"0^Select Value",false);
			
			formBean.setStrSupplierCombo(temp);
			formBean.setstrInstituteCombo(temp1);
									
			
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "AckSuppReceiptDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void save(AckSuppReceiptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		AckSuppReceiptVO vo=null;
		AckSuppReceiptBO bo= null;
	
		
		System.out.println("-------AckSuppReceiptDATA.SAVE----------");
		String hosCode = "";
		String seatid = "";
		try 
		{
			vo = new AckSuppReceiptVO();
			bo = new AckSuppReceiptBO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			
			HelperMethods.populate(vo,formBean);
			//System.out.println("vo.getStrOldBatchNo-"+vo.getStrOldBatchNo());
			
			bo.save(vo);			
			
			System.out.println("-------AckSuppReceiptDATA.SAVE---END-------");
			
			if (vo.getStrMsgType().equals("1")) 
			{
				//System.out.println("Error_Msg---"+vo.getStrMsgString());
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				bo.getPrintDetails(vo);
				String strPrintHLP="";								
				 if(vo.getStrItemCategoryNo().equals("10"))
				 {
					 System.out.println("<--------AckSuppReceiptHLP.getPrintDrugDetails ------->");
					 
					 strPrintHLP = AckSuppReceiptHLP.getPrintDrugDetails(vo.getWsPrint(),hosCode,vo);
				 }
				 else
				 {
					 System.out.println("<--------AckSuppReceiptHLP.getPrintItemDetails ------->");
					 strPrintHLP = AckSuppReceiptHLP.getPrintItemDetails(vo.getWsPrint(),hosCode,vo);
				 }
				 formBean.setStrPrintDtls(strPrintHLP);
			}
			
			
		} catch (Exception e) 
		{			
			e.printStackTrace();			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999")))
				formBean.setStrErr(e.getMessage().split("\\##")[1]);
			else
				formBean.setStrErr(e.getMessage());
		}
		finally 
		{
			if(vo != null) vo = null;
	
		}
	}
	
	public static void REJECT(AckSuppReceiptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		AckSuppReceiptVO vo=null;
		AckSuppReceiptBO bo= null;
	
		
		System.out.println("-------AckSuppReceiptDATA.REJECT----------");
		String hosCode = "";
		String seatid = "";
		try 
		{
			vo = new AckSuppReceiptVO();
			bo = new AckSuppReceiptBO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			HelperMethods.populate(vo,formBean);
			
			bo.REJECT(vo);			
			
			System.out.println("-------AckSuppReceiptDATA.REJECT---END-------");
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			
			
		} catch (Exception e) {
			
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "AckSuppReceiptDATA->searchStockDtl()", strmsgText);
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
	
	
		}
	}
	
	public static void showReport(AckSuppReceiptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "pdf";
		String strUtilityNo = "";
		String combo[] = null;
		MmsConfigUtil mmsConfig = null;
 //System.out.println("IN a data");
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			 mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String strHospitalCode = formBean.getStrHospitalCode();
			//String strReportId = formBean.getStrReportId();
			String[] strChk = request.getParameterValues("chk");
			

			for (int i = 0, stopI = strChk.length; i < stopI; i++) {
				String[] strtemp = strChk[i].replace("@", "#").split("#");
				if (i == 0) {
					strUtilityNo = strUtilityNo + strtemp[0];

				} else {
					strUtilityNo = strUtilityNo + "," + strtemp[0];

				}
				
				
			}

			combo = request.getParameterValues("combo");

			String[] strTemp = combo[0].split("\\^");
			//String[] strTemp1 = combo[2].split("\\^");
			String strStoreId = strTemp[0];
			//String strReqTypeId = strTemp1[1];

	 //System.out.println("chk value----1--->"+strChk);
		 //System.out.println("strStoreId----2----->"+strStoreId);
		 ////System.out.println("strReqTypeId--3------->"+strReqTypeId);
		 //System.out.println("strUtilityNo------4--->"+strUtilityNo);


				String reportPath = "/mms/reports/LocalPurchaseNew_mmsrpt.rptdesign";
				String strReportName = "UTILITY CERTIFICATE";

				params.put("report_Name", strReportName);
				//params.put("report_id", strReportId);
				params.put("hospCode", strHospitalCode);
				params.put("utilityNo", strUtilityNo);


			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);


		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	public static void print(AckSuppReceiptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		AckSuppReceiptBO bo = null;
		AckSuppReceiptVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";
	
		try {
			bo = new AckSuppReceiptBO();
			vo = new AckSuppReceiptVO();
			hisutil = new HisUtil("mms", "AckSuppReceiptDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[1]);
			vo.setStrLPNo(strTemp[0]);
			vo.setStrLpoNo(strTemp[0]);
			System.out.println("-------------AckSuppReceiptDATA.print------[ PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl ]-----------------");
			bo.getPrintDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("AckSuppReceiptDATA.getVerifiedItemDetails() --> "
								+ vo.getStrMsgString());
			}		
			
			if(vo.getStrItemCategoryNo().equals("10"))
			 {
				 System.out.println("<--------AckSuppReceiptHLP.getPrintDrugDetails ------->");
				 
				 strPrintItemDtl = AckSuppReceiptHLP.getPrintDrugDetails(vo.getWsPrint(),hosCode,vo);
			 }
			 else
			 {
				 System.out.println("<--------AckSuppReceiptHLP.getPrintItemDetails ------->");
				 strPrintItemDtl = AckSuppReceiptHLP.getPrintItemDetails(vo.getWsPrint(),hosCode,vo);
			 }
										
			
			formBean.setStrPrintDtls(strPrintItemDtl);
			if(strPrintItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strPrintItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "AckSuppReceiptDATA->getVerifiedItemDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }			
               
			//formBean.setStrPrintItemHlpDtl(strPrintItemDtl);
			
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "LocalPurchaseDeskDATA.getPrintItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AckSuppReceiptDATA->getPrintItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void getModify_Details(AckSuppReceiptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		AckSuppReceiptBO bo = null;
		AckSuppReceiptVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";		
		
	    String strSupplierId = "";
	    String strMfgId= "";
	    String strPurchaseThrough= "";	   
	    String temp  = "";
		String strMfgCombo = "";
		String purchaseThroughCmb = "";
	
		try {
			bo = new AckSuppReceiptBO();
			vo = new AckSuppReceiptVO();
			hisutil = new HisUtil("mms", "AckSuppReceiptDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[1]);
			vo.setStrLPNo(strTemp[0]);
			vo.setStrLpoNo(strTemp[0]);
			System.out.println("-------------AckSuppReceiptDATA.getModify_Details--[ strPkValues - "+strPkValues+"] -> PKG_MMS_VIEW.proc_hstt_Supplier_Receipt_dtl[ Mode - 1 ] ,Pkg_Mms_View.proc_supplier_list [ Mode - 1] ,  PKG_MMS_VIEW.proc_institute_list [ Mode - 1 ] -----------------");
			bo.getModifyDetails(vo);  // Pkg_Mms_View.proc_supplier_list [ Mode - 1] ,  PKG_MMS_VIEW.proc_institute_list [ Mode - 1 ]
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("AckSuppReceiptDATA.getModify_Details() --> "
								+ vo.getStrMsgString());
			}		
			
			WebRowSet ws = vo.getWsPrint();
			
			if(ws != null && ws.size() > 0)
			{	
				/*
				  1. Store Name
				  2. MR_NO
				  3. Challan_Date
				  4. PO No
				  5. Bill Date
				  6. Item Name
				  7. Supplier Name
				  8. Supply Qty
				  9. Rej Qty
				 10. Rcd Qty
				 11. Rate wth Tax
				 12. DM_NO # ENtry Date
				 13. PO Qty
				 14. MRP
				 15. EXP DATE
				 16. BATCH
				 17. PUR RATE
				 18. User Name
				 19. BRAND_ID
				 20. Bal Qty
				 21. DLNO
				 22. TAX
				 23. Rate Wth Tax
				 24. Manuf Name
				 25. Catg Name
				 26. UC_REQ
				 27. ADMIN_CHG
				 28. Cost To Pat
				 29. Remarks
				 30. Supplier Id
				 31. Purchase Through
				 32. Bill No
				 33. BIll Date
				 34. Admin Chg Value
				 35. Mfg Date
				 36. Exp Date
				 37. MRN_NO ^ BRAND_ID ^ SUPP ID ^ MFG ID ^ Purchase Through Id
				 38. Expected Delivery Date
				 39. PO_DATE
				 40. PO_NO
				 41. MRP
				 42. PO_DATE
				 43. Diif In Amount 
				*/
				/*
                  New Logic Added on Date 01-Aug-2024
                  a) If Sign '+'  Than Difference Amount Enter Into  hstnum_net_advance
                  a) If Sign '-'  Than Difference Amount Enter Into  hstnum_net_penelty
                */				
				ws.next();
					
				formBean.setStrStoreName(ws.getString(1));
				formBean.setStrItemCategoeryName(ws.getString(25));
				formBean.setStrPoDate(ws.getString(39));
				formBean.setStrDCNo(ws.getString(12).split("\\#")[0]);
				formBean.setStrChallanDate(ws.getString(3));
				formBean.setStrInvoiceNo(ws.getString(32));
				formBean.setStrInvoiceDate(ws.getString(33));
				formBean.setStrLpoNo(ws.getString(40));
				formBean.setStrExpDeliveryDate(ws.getString(38));
				formBean.setStrRemarks(ws.getString(29));
				
				strSupplierId        = ws.getString(37).split("\\^")[2];
				strMfgId             = ws.getString(37).split("\\^")[3];
				strPurchaseThrough   = ws.getString(37).split("\\^")[4];	   
							
			}
			vo.getWsPrint().beforeFirst();					
			System.out.println("<--------AckSuppReceiptHLP.getModify_Details ------->");
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}		
			
						 temp  = hisutil.getOptionValue(vo.getStrSupplierWs(),  strSupplierId,"0^Select Value",false);
						 vo.getStrSupplierWs().beforeFirst();		 
			       strMfgCombo = hisutil.getOptionValue(vo.getStrSupplierWs(), strMfgId,"0^Select Value",false);
			purchaseThroughCmb = hisutil.getOptionValue(vo.getStrSupplierWs1(), strPurchaseThrough,"0^Select Value",false);
			
			formBean.setStrSupplierCombo(temp);
			formBean.setStrMfgCombo(strMfgCombo);
			formBean.setstrInstituteCombo(purchaseThroughCmb);
				 
			strPrintItemDtl = AckSuppReceiptHLP.getModify_Details(vo.getWsPrint(),hosCode,vo);
			
										
			
			formBean.setStrPrintDtls(strPrintItemDtl);
			/*
			if(strPrintItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strPrintItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "AckSuppReceiptDATA->getModify_Details()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }	
	    	 */		
               
			//formBean.setStrPrintItemHlpDtl(strPrintItemDtl);
			
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "LocalPurchaseDeskDATA.getModify_Details(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AckSuppReceiptDATA->getModify_Details()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	
	public static void modifySave(AckSuppReceiptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		AckSuppReceiptVO vo=null;
		AckSuppReceiptBO bo= null;
	
		
		System.out.println("-------AckSuppReceiptDATA.modifySave----------");
		String hosCode = "";
		String seatid = "";
		try 
		{
			vo = new AckSuppReceiptVO();
			bo = new AckSuppReceiptBO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			HelperMethods.populate(vo,formBean);
			
			bo.modifySave(vo);			
			
			System.out.println("-------AckSuppReceiptDATA.modifySave---END-------");
			
			if (vo.getStrMsgType().equals("1")) 
			{
				//System.out.println("Error_Msg---"+vo.getStrMsgString());
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				bo.getPrintDetailsAfterModify(vo);
				String strPrintHLP="";								
				 if(vo.getStrItemCategoryNo().equals("10"))
				 {
					 System.out.println("<--------AckSuppReceiptHLP.getPrintDrugDetails ------->");
					 
					 strPrintHLP = AckSuppReceiptHLP.getPrintDrugDetails(vo.getWsPrint(),hosCode,vo);
				 }
				 else
				 {
					 System.out.println("<--------AckSuppReceiptHLP.getPrintItemDetails ------->");
					 strPrintHLP = AckSuppReceiptHLP.getPrintItemDetails(vo.getWsPrint(),hosCode,vo);
				 }
				 formBean.setStrPrintDtls(strPrintHLP);
			}
			
			
		} catch (Exception e) 
		{			
			e.printStackTrace();			
			if(e.getMessage().contains("##") && (e.getMessage().split("\\##")[2].equals("999")))
				formBean.setStrErr(e.getMessage().split("\\##")[1]);
			else
				formBean.setStrErr(e.getMessage());
		}
		finally 
		{
			if(vo != null) vo = null;
	
		}
	}
	
}
