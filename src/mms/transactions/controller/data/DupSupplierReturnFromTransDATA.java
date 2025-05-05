package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.icu.text.DateFormat;

import mms.transactions.bo.AcknowledgeTransBO;
import mms.transactions.bo.DupSupplierReturnFromTransBO;
import mms.transactions.controller.fb.DupSupplierReturnFromTransFB;
import mms.transactions.controller.hlp.AcknowledgeTransHLP;
import mms.transactions.controller.hlp.DupSupplierReturnFromTransHLP;
import mms.transactions.vo.AcknowledgeTransVO;
import mms.transactions.vo.DupSupplierReturnFromTransVO;

public class DupSupplierReturnFromTransDATA {
	public static void initialPage(DupSupplierReturnFromTransFB formBean, HttpServletRequest request) {
		DupSupplierReturnFromTransVO vo = null;
		DupSupplierReturnFromTransBO bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String cmb = "", strCondemnationTypeCmbOptions = "";

		try {
			vo = new DupSupplierReturnFromTransVO();
			bo = new DupSupplierReturnFromTransBO();

			hisutil = new HisUtil("mms", "DupSupplierReturnFromTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			// Calling BO Method
			bo.initialPage(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			//System.out.println("vo.getWbsStoreNameCombo()>>" + vo.getWbsStoreNameCombo().size());
			if (vo.getWbsStoreNameCombo() != null && vo.getWbsStoreNameCombo().size() > 0) {
				/*
				 * if(vo.getWbsStoreNameCombo().next()) {
				 * vo.setStrStoreId(vo.getWbsStoreNameCombo().getString(1)); }
				 * vo.getWbsStoreNameCombo().beforeFirst();
				 */
				cmb = hisutil.getOptionValue(vo.getWbsStoreNameCombo(), "0", "0^Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			if (vo.getWsCondemnationTypeDtl() != null && vo.getWsCondemnationTypeDtl().size() > 0) {
				strCondemnationTypeCmbOptions = hisutil.getOptionValue(vo.getWsCondemnationTypeDtl(), "", "", true);
			} else {
				strCondemnationTypeCmbOptions = "<option value='0'>Select Value</option>";
			}

			//System.out.println(strCondemnationTypeCmbOptions);

			formBean.setStrCondemnationTypeCmbOptions(strCondemnationTypeCmbOptions);
			//System.out.println("cmb>>>>>>>>>" + cmb);
			formBean.setStrStoreName(cmb);
			//System.out.println("formBean.setStrStoreName" + formBean.getStrStoreName());

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "DupSupplierReturnFromTransDATA->initialPage()", strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
		}
	}

	public static void getReturnOrCondemnDrugListHlp(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcatno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));
			//System.out.println("request.getParameter" + request.getParameter("strsupplierno"));
			// BO Method
			bo.getReturnOrCondemnDrugListHlp(vo);

			String strNOSQDrugDtl = DupSupplierReturnFromTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strNOSQDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getNOSQDrugListHLP() --> " + e.getMessage();
			HisException eObj = new HisException("mms", "DupSupplierReturnFromTransDATA->getNOSQDrugListHLP()",
					strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getReturnOrCondemnDrugListHlpNEW(DupSupplierReturnFromTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcatno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));
			//System.out.println("request.getParameter" + request.getParameter("strsupplierno"));
			// BO Method
			bo.getReturnOrCondemnDrugListHlp(vo);

			String strNOSQDrugDtl = DupSupplierReturnFromTransHLP.getReturnOrCondemnDrugListHlpNEW(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strNOSQDrugDtl);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getNOSQDrugListHLP() --> " + e.getMessage();
			HisException eObj = new HisException("mms", "DupSupplierReturnFromTransDATA->getNOSQDrugListHLP()",
					strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getSupplierDebitNumberListHlp(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;
		String strResult="";

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcategoryno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));

			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));
			//System.out.println("request.getParameter" + request.getParameter("strsupplierno"));
			// BO Method
			bo.getSupplierDebitNumberListHlp(vo);
			//System.out.println(vo.getWsNOSQItemDetail());

			strResult = DupSupplierReturnFromTransHLP.getDebitNoteList(vo);
			if (strResult != null) {
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strResult);

			} else {
				HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->getSupplierDebitNumberListHlp()",
						vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
						+ "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getSupplierDebitNumberListHlp() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DupSupplierReturnFromTransDATA->getSupplierDebitNumberListHlp()", strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	
	public static void getSupplierDebitNumberDetailHlp(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null;
		String strResult="";

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrActionId(request.getParameter("strActionsId"));
			vo.setStrItemCatNo(request.getParameter("strcategoryno"));
			vo.setStrSupplierId(request.getParameter("strsupplierno"));
			vo.setStrStoreName(request.getParameter("storename"));
			
			vo.setStrSupplierName(request.getParameter("suppliername"));
			vo.setStrCategoryName(request.getParameter("catname"));
			
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));
			//System.out.println("request.getParameter" + request.getParameter("strsupplierno"));
			// BO Method
			bo.getSupplierDebitNumberDetailHlp(vo);
//			System.out.println(vo.getWsNOSQItemDetail());

			strResult = DupSupplierReturnFromTransHLP.getDebitNoteDetail(vo);
			
			if (strResult != null) {
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strResult);

			} else {
				HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->getSupplierDebitNumberListHlp()",
						vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
						+ "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getSupplierDebitNumberListHlp() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DupSupplierReturnFromTransDATA->getSupplierDebitNumberListHlp()", strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
	
	
	

	public static void GETCATCMB(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null, strItemVal;

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));

			// BO Method
			bo.getcatcmb(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				util = new HisUtil("MMS", "IssueDetailRptData");
				strItemVal = util.getOptionValue(vo.getItemCategWS(), "0", "0^Select Value", false);
				// response.getWriter().print(strItemVal);
			}

			// String strNOSQDrugDtl =
			// DupSupplierReturnFromTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemVal);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getNOSQDrugListHLP() --> " + e.getMessage();
			HisException eObj = new HisException("mms", "DupSupplierReturnFromTransDATA->getNOSQDrugListHLP()",
					strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getsuppliernamecmb(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		DupSupplierReturnFromTransBO bo = null;
		DupSupplierReturnFromTransVO vo = null;
		HisUtil util = null;
		String strmsgText = null, strItemVal;

		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrItemCatNo(request.getParameter("catcode"));

			// BO Method
			bo.getsuppliername(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				util = new HisUtil("MMS", "IssueDetailRptData");
				strItemVal = util.getOptionValue(vo.getSupplierWS(), "0", "0^Select Value", false);
				// response.getWriter().print(strItemVal);
			}

			// String strNOSQDrugDtl =
			// DupSupplierReturnFromTransHLP.getReturnOrCondemnDrugListHlp(vo);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemVal);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.DupSupplierReturnFromTransDATA.getNOSQDrugListHLP() --> " + e.getMessage();
			HisException eObj = new HisException("mms", "DupSupplierReturnFromTransDATA->getNOSQDrugListHLP()",
					strmsgText);
			formBean.setStrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static String toCSV(String[] array) {
		String result = "";

		if (array.length > 0) {
			StringBuilder sb = new StringBuilder();

			for (String s : array) {
				sb.append(s).append(",");
			}

			result = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return result;
	}

	public static void insert(DupSupplierReturnFromTransFB formBean, HttpServletRequest request) {
		DupSupplierReturnFromTransVO vo = null;
		DupSupplierReturnFromTransBO bo = null;
		String strmsgText = null;
		try {
			bo = new DupSupplierReturnFromTransBO();
			vo = new DupSupplierReturnFromTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));

			vo = (DupSupplierReturnFromTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.DupSupplierReturnFromTransVO", formBean);
			// Calling BO method
			bo.insert(vo);
			StringBuilder sb = new StringBuilder();
			String strHiddenItemDtl = null;
			for (int i = 0; i < formBean.getStrNosqDrugs().length; i++) {
				strHiddenItemDtl = formBean.getStrNosqDrugs()[i]; // set all hidden dtl in itembrand id field
				if (formBean.getStrNosqDrugs().length == 1)
					sb.append(strHiddenItemDtl);
				else
					sb.append(strHiddenItemDtl).append("@@@");
			}
			if (formBean.getStrActionId().equalsIgnoreCase("1")) {
				formBean.setStrTmpStoreId(formBean.getStrStoreId());
				formBean.setStrTmpItemcatId(formBean.getStrcatno());
				formBean.setStrTmpSupplierId(formBean.getStrsupplierno());
				formBean.setStrTmpitembrandId(sb.toString());
			}

			formBean.setStrMsgType(vo.getStrMsgType());
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				// if(formBean.getStrActionsId().equalsIgnoreCase("1"))
				// //||formBean.getStrActionsId().equalsIgnoreCase("2")
				// {
				formBean.setStrsaveflag("1");
				formBean.setStrVoucherFlag("1");// To open voucher
				// }
				strmsgText = "Record Saved Successfully!";
				formBean.setStrMsg(strmsgText);

				formBean.setStrTmpStoreId(vo.getStrStoreId());
			}
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System",
					" DupSupplierReturnFromTransDATA.insert()---->", _Err.getMessage());
			formBean.setStrErr("Error####Application Error [ERROR ID : " + hisException.getErrorID()
					+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void voucherPrint(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		/* Declaring Variables */
		String strmsgText = "";
		DupSupplierReturnFromTransVO vo = null;
		DupSupplierReturnFromTransBO bo = null;
		String strResult = "A";
		try {

			vo = new DupSupplierReturnFromTransVO();
			bo = new DupSupplierReturnFromTransBO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrcatno(request.getParameter("itemcatno"));
			vo.setStrSupplierId(request.getParameter("supplierid"));
			StringBuilder brandid = new StringBuilder();
			StringBuilder batchno = new StringBuilder();
			StringBuilder orderno = new StringBuilder();
			String temp = request.getParameter("itembrandid").toString();
			String[] temp1 = temp.split("@@@");
			int len = temp1.length;
			for (int i = 0; i < len; i++) {
				brandid.append(temp1[i].split("\\^")[1]).append(",");
				batchno.append("'" + temp1[i].split("\\^")[2]).append("',");
				orderno.append(temp1[i].split("\\^")[4]).append(",");
			}
			//System.out.println("batchno===>>" + batchno.toString());
			// //System.out.println("batch
			// no=="+batchno.deleteCharAt(batchno.length()-1).toString());
			// //System.out.println("order
			// no"+orderno.deleteCharAt(orderno.length()-1).toString());
			// //System.out.println("brand
			// id=="+brandid.deleteCharAt(brandid.length()-1).toString());

			vo.setStrHiddenValue(request.getParameter("strHidVal"));
			/*
			 * if(len==1) { vo.setStrItemBrandId(brandid.toString());
			 * vo.setStrBatchNo(batchno.toString().toUpperCase());
			 * vo.setStrOrderNo(orderno.toString());
			 * 
			 * }else {
			 */
			vo.setStrItemBrandId(brandid.deleteCharAt(brandid.length() - 1).toString());
			vo.setStrBatchNo(batchno.deleteCharAt(batchno.length() - 1).toString().toUpperCase());
			vo.setStrOrderNo(orderno.deleteCharAt(orderno.length() - 1).toString());

			// }

			bo.getVoucherDtl(vo);

			strResult = DupSupplierReturnFromTransHLP.getvoucherPrintDetails(vo);
			if (strResult != null) {
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strResult);

			} else {
				HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->getViewDtl()",
						vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
						+ "], Contact System Administrator! ";
				response.getWriter().print(str);
			}

		} catch (Exception _err) {
			strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->getViewDtl()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
					+ "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		}

	}

	public static void duplicatevoucherPrint(DupSupplierReturnFromTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {
		/* Declaring Variables */
		String strmsgText = "";
		DupSupplierReturnFromTransVO vo = null;
		DupSupplierReturnFromTransBO bo = null;
		String strResult = "A";
		try {

			vo = new DupSupplierReturnFromTransVO();
			bo = new DupSupplierReturnFromTransBO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrcatno(request.getParameter("itemcatno"));
			vo.setStrSupplierId(request.getParameter("supplierid"));
			vo.setStrdebitNoteNumber(request.getParameter("debitNumber"));
			vo.setStrvoucherDate(request.getParameter("voucherDate"));

			vo.setStrHiddenValue(request.getParameter("strHidVal"));

			//System.out.println(vo.getStrHospitalCode() + ":" + vo.getStrStoreId() + ":" + vo.getStrItemCatNo() + ":"+ vo.getStrSupplierId() + ":" + vo.getStrdebitNoteNumber() + ":" + vo.getStrHiddenValue());

			bo.getDuplicateVoucherDtl(vo);

			strResult = DupSupplierReturnFromTransHLP.getDuplicatevoucherPrintDetails(vo);
			if (strResult != null) {
				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strResult);

			} else {
				HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->duplicatevoucherPrint()",
						vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
						+ "], Contact System Administrator! ";
				response.getWriter().print(str);
			}

		} catch (Exception _err) {
			strmsgText = _err.getMessage();
			HisException eObj = new HisException("MMS", "DupSupplierReturnFromTransDATA->duplicatevoucherPrint()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
					+ "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		}

	}

}
