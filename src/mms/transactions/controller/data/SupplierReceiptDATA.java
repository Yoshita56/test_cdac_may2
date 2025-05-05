/**
 * 
 */
package mms.transactions.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.backutil.HelperMethods;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.SupplierReceiptBO;
import mms.transactions.controller.fb.SupplierReceiptFB;
import mms.transactions.controller.hlp.SupplierReceiptHLP;
import mms.transactions.vo.SupplierReceiptVO;

/**
 * @author user
 *
 */
public class SupplierReceiptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(SupplierReceiptFB formBean,HttpServletRequest request) {
		SupplierReceiptVO vo=null;
		SupplierReceiptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String strStoreName ,strItemCmb;
		String temp = "";
		String temp1 = "";
			
		try {
			vo = new SupplierReceiptVO();
			bo = new SupplierReceiptBO();
			
			hisutil = new HisUtil("mms", "LocalPurchaseNewTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
						
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			
			bo.initialAdd(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			
			
			temp=hisutil.getOptionValue(vo.getStrSupplierWs(), "0","0^Select Value",false);
			temp1=hisutil.getOptionValue(vo.getStrSupplierWs1(), "0","0^Select Value",false);
			
			formBean.setStrSupplierCombo(temp);
			formBean.setstrInstituteCombo(temp1);
			
			if (vo.getItemWS().size() == 0 || vo.getItemWS() == null) {
				strItemCmb = "<option value='0'>Select Value</option>";
			} else {
				strItemCmb = hisutil.getOptionValue(vo.getItemWS(),
						"0", "0^Select Value", true);
				//System.out.println("strItemCmb-------------->"+strItemCmb);

			}
			formBean.setStrItemBrandCombo(strItemCmb);
			
			
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "LocalPurchaseNewTransDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void save(SupplierReceiptFB formBean,HttpServletRequest request,
			HttpServletResponse response) {
		SupplierReceiptVO vo=null;
		SupplierReceiptBO bo= null;
	
		String hosCode = "";
		String seatid = "";
		try {
			vo = new SupplierReceiptVO();
			bo = new SupplierReceiptBO();
			
	
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
						
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			HelperMethods.populate(vo,formBean);
			//System.out.println(formBean.getstrInstituteId());
			//System.out.println("formBean.strInstituteCombo------------*"+formBean.getstrInstituteId());
			vo.setStrInstituteCombo(formBean.getstrInstituteId());
			//System.out.println(vo.getStrInstituteCombo());
			
			vo.setStrAdmchg(formBean.getStrAdmchg());
			
			bo.save(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				bo.getPrintDetails(vo);
				String strPrintHLP=SupplierReceiptHLP.getPrintItemDetails(vo.getWsPrint(),hosCode,vo);
				//System.out.println("strPrintHLP  "+strPrintHLP);
				formBean.setStrPrintDtls(strPrintHLP);
				//formBean.setStrPrintFlag("1");
			}
			
			
		} catch (Exception e) {
			
		e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "LocalPurchaseNewTransDATA->searchStockDtl()", strmsgText);
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
	
	public static void showReport(SupplierReceiptFB formBean,
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
	
	public static void print(SupplierReceiptFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		SupplierReceiptBO bo = null;
		SupplierReceiptVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";
	
		try {
			bo = new SupplierReceiptBO();
			vo = new SupplierReceiptVO();
			hisutil = new HisUtil("mms", "LocalPurchaseNewTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[1]);
			vo.setStrLPNo(strTemp[0]);
			System.out.println("-------------LocalPurchaseNewTransDATA.print-----------------------");
			bo.getPrintDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("LocalPurchaseNewTransDATA.getVerifiedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strPrintItemDtl = SupplierReceiptHLP.getPrintItemDetails(vo.getWsPrint(),hosCode,vo);			
			
			
			formBean.setStrPrintDtls(strPrintItemDtl);
			if(strPrintItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strPrintItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "NewChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
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
					"NewChallanProcessTransDATA->getPrintItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
}
