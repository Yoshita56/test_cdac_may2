/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.BillApprovalOtherTransBO;
import mms.transactions.controller.fb.BillApprovalOtherTransFB;
import mms.transactions.vo.BillApprovalOtherTransVO;


/**
 * Developer : Anshul Jindal Version : 1.0 Date : 23/June/2009
 * 
 */
public class BillApprovalOtherTransDATA {

	public static String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	public static String DATE_FORMAT_NOW = "dd-MMM-yyyy";

	public static String now(String frmt) {
		HisUtil util = null;
		String a = "";
		util = new HisUtil("mms", "BillApprovalOtherTransDATA");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {

		}
		/*
		 * Calendar cal = Calendar.getInstance(); SimpleDateFormat sdf = new
		 * SimpleDateFormat(DATE_FORMAT_NOW); return sdf.format(cal.getTime());
		 */
		return a;
	}

	/**
	 * This method will get the PO No Combo
	 * 
	 * @param request
	 * @param formBean
	 */

	public static void getPOCombo(BillApprovalOtherTransFB formBean,
			HttpServletRequest request) {

		BillApprovalOtherTransBO bo = null;
		BillApprovalOtherTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";

		String strComboVal = "";
		String strStoreId = "";
		String strBillTypeId = "";
		String strPONoCmb = "";
		String[] temp=null;
		String strCurrentDate = "";

		try {
			bo = new BillApprovalOtherTransBO();
			vo = new BillApprovalOtherTransVO();
			hisutil = new HisUtil("MMS", "BillApprovalOtherTransDATA");

			
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);
			

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			// String hosCode = "108";
			// String seatid = "10049";

			if (request.getParameter("comboValue") == null) {
				strComboVal = formBean.getStrComboValue();
			} else {
				strComboVal = request.getParameter("comboValue");
			}
			formBean.setStrComboValue(strComboVal);

			temp = strComboVal.replace("^", "#").split("#");

			formBean.setStrStoreName(temp[0]);
			formBean.setStrBillTypeName(temp[1]);

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			String strComboValues[] = request.getParameterValues("combo");

			//////System.out.println("my data strStoreId ->" + strComboValues[0]);
			//////System.out.println("strBillType->" + strComboValues[1]);

			strStoreId = strComboValues[0];
			strBillTypeId = strComboValues[1];

			formBean.setStrStoreId(strStoreId);
			formBean.setStrBillType(strBillTypeId);

			vo.setStrStoreId(strStoreId);
			vo.setStrBillType(strBillTypeId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			
			bo.getPOCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				if (vo.getPONoCmbWS() != null && vo.getPONoCmbWS().size() > 0) {
					strPONoCmb = hisutil.getOptionValue(vo.getPONoCmbWS(), "0",
							"0^Select Value", true);
				} else {
					strPONoCmb = "<option value='0'>Select Value</option>";
				}

				formBean.setStrPONoCmb(strPONoCmb);

			}

		} catch (Exception e) {

			// //e.printStackTrace();
			strmsgText = "Issue Desk.BillApprovalOtherTransDATA.getPOCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalOtherTransDATA->getPOCombo()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method will get the PO Details
	 * 
	 * @param request
	 * @param response
	 */

	public static void getPODetails(BillApprovalOtherTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = null;
		BillApprovalOtherTransBO bo = null;
		BillApprovalOtherTransVO vo = null;
		String strHospitalCode = "";
		String[] temp=null;
		WebRowSet ws = null;

		try {
			bo = new BillApprovalOtherTransBO();
			vo = new BillApprovalOtherTransVO();

			strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			//////System.out.println("formBean.getStrPONo()-"+formBean.getStrPONo());
			temp = formBean.getStrPONo().replace("^", "#").split("#");
			formBean.setStrPONo(temp[0]);
			formBean.setStrPOStoreId(temp[1]);
			formBean.setStrPOPrefix(temp[2]);
			
			vo.setStrPOStoreId(temp[1]);
			vo.setStrPONo(temp[0]);

			bo.getPODetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				//////System.out.println("data vo.getPODetailsWs().size()"+ vo.getPODetailsWs().size());
				ws = vo.getPODetailsWs();
				if(ws.size()==0 || ws==null)
				{
					vo.setStrPODate("--");
					vo.setStrPOTypeId("0");
					vo.setStrPOType("--");
					vo.setStrSupplierId("0");
					vo.setStrSupplierName("--");
					vo.setStrPOStoreId("0");
					vo.setStrPOStoreName("--");
					vo.setStrItemCategoryNoH("0");
					vo.setStrItemCategoryNameH("--");
					vo.setStrCurrencyId("0");
					vo.setStrCurrencyName("--");
					vo.setStrCurrencyValue("0");
				}else{
				while (ws.next()) {
					vo.setStrPODate(ws.getString(1));
					vo.setStrPOTypeId(ws.getString(2));
					vo.setStrPOType(ws.getString(3));
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));
					vo.setStrPOStoreId(ws.getString(6));
					vo.setStrPOStoreName(ws.getString(7));
					vo.setStrItemCategoryNoH(ws.getString(8));
					vo.setStrItemCategoryNameH(ws.getString(9));
					vo.setStrCurrencyId(ws.getString(10));
					vo.setStrCurrencyName(ws.getString(11));
					vo.setStrCurrencyValue(ws.getString(12));
					vo.setStrPONetAmount(ws.getString(18));
			//		////System.out.println("Agebt name->"+ws.getString(19));
			    	vo.setStrAgentName(ws.getString(19).replace('^', '#').split("#")[0]);
			    	vo.setStrCAName(ws.getString(19).replace('^', '#').split("#")[1]);
					// vo.setStrOverallPOTax(ws.getString(13));
					// vo.setStrAdvanceTaken(ws.getString(14));
					// vo.setStrAdvanceAdjusted(ws.getString(15));
					// vo.setStrNetPenalty(ws.getString(16));
					vo.setStrCurrentDate(now(DATE_FORMAT_NOWwt));
					// setting fromBean
					formBean.setStrPODate(vo.getStrPODate());
					formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrPONetAmount(vo.getStrPONetAmount());
					formBean.setStrAgentName(vo.getStrAgentName());
					formBean.setStrCAName(vo.getStrCAName());
					if(formBean.getStrAgentName().trim().equals("0"))
					  formBean.setStrAgentNameShow("0");
					else
					  formBean.setStrAgentNameShow("1");
				//	////System.out.println("Agebt name Show->"+ formBean.getStrAgentNameShow());
					// formBean.setStrOverallPOTax(ws.getString(13));
					// formBean.setStrAdvanceTaken(ws.getString(14));
					// formBean.setStrAdvanceAdjusted(ws.getString(15));
					// formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				}
				formBean.setStrPONo(temp[0]);
				formBean.setStrPOStoreId(temp[1]);
				formBean.setStrPOPrefix(temp[2]);
			}
			}

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Issue Desk.BillApprovalOtherTransDATA.getPODetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalOtherTransDATA->getPODetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}
	
	public static void insertData(BillApprovalOtherTransFB formBean,
			HttpServletRequest request) {

		String strmsgText = null;
		BillApprovalOtherTransBO bo = null;
		BillApprovalOtherTransVO vo = null;
		String strHospitalCode = "";

		MmsConfigUtil mcu = null;
		

		try {
			bo = new BillApprovalOtherTransBO();
			//vo = new BillApprovalOtherTransVO();
			//////System.out.println("data insertData");
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mcu = new MmsConfigUtil(strHospitalCode);

			vo = (BillApprovalOtherTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.BillApprovalOtherTransVO", formBean);
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrFinEndYr(mcu.getStrFinancialEndDate(vo.getStrStoreId() , strHospitalCode));
			vo.setStrFinStartYr(mcu.getStrFinancialStartDate(vo.getStrStoreId() , strHospitalCode));
			vo.setStrSeatId(strSeatId);
			vo.setStrPONo(formBean.getStrPONoH());

			bo.insertData(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Saved Successfully");
			}

			

		} catch (Exception e) {

			// //e.printStackTrace();
			strmsgText = "Issue Desk.BillApprovalOtherTransDATA.insertData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalOtherTransDATA->insertData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

}
