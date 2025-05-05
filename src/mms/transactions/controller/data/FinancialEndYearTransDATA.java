package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.FinancialEndYearTransBO;
import mms.transactions.controller.fb.FinancialEndYearTransFB;
import mms.transactions.vo.FinancialEndYearTransVO;

/**
 * Developer : Tanvi Sappal Date : 22/Jan/2009 version : 1.0 Mod Date :
 * 23/Jun/2008
 */

public class FinancialEndYearTransDATA {

	/**
	 * This function is used to set initial parameters required to display on
	 * main page
	 * 
	 * @param formBean
	 */
	public static void storeName(FinancialEndYearTransFB formBean,
			HttpServletRequest request) {
		FinancialEndYearTransVO vo = null;
		FinancialEndYearTransBO bo = null;
		String strCurrentDate="";
		HisUtil hisutil = null;
		// MmsConfigUtil mcu = null;
		String cmb="";

		try {
			vo = new FinancialEndYearTransVO();
			bo = new FinancialEndYearTransBO();

			// mcu = new MmsConfigUtil();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.storeName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "FinancialEndYearTransDATA");
			if(vo.getStrStoreNameComboWS().size()>0 && vo.getStrStoreNameComboWS()!=null)
				cmb = hisutil.getOptionValue(vo.getStrStoreNameComboWS(),
					"", "", true);
			else
				cmb = hisutil.getOptionValue(vo.getStrStoreNameComboWS(),
						"0", "0^Select Value", true);
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			// formBean.getStrStoreId()
			formBean.setStrStoreNameCombo(cmb);
			formBean.setStrFinEndDate(" ");
			formBean.setStrCurrentDate(strCurrentDate);

			// vo.setStrFinEndDate(mcu.getStrFinancialEndDate(formBean.getStrStoreId()));
			// vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId()));

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"FinancialEndYearTransDATA->storeName()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
		}
	}

	public static void finEndDate(FinancialEndYearTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		FinancialEndYearTransVO vo = null;

		MmsConfigUtil mcu = null;

		try {
			vo = new FinancialEndYearTransVO();


			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			String strStoreId = (String) request.getParameter("strid");

			formBean.setStrStoreId(strStoreId);

			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(vo
					.getStrStoreId(), vo.getStrHospitalCode()));

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(formBean.getStrFinEndDate());

		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"FinancialEndYearTransDATA->finEndDate()", strmsgText);
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
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;

		}

	}

	/**
	 * This function invoke TransferObjectFactory.populateData() to transfer the
	 * values of all attributes of form bean into vo and the invoke bo insert
	 * method
	 * 
	 * @param formBean
	 */
	public static void insert(FinancialEndYearTransFB formBean,
			HttpServletRequest request) {

		FinancialEndYearTransVO vo = null;
		FinancialEndYearTransBO bo = null;
		MmsConfigUtil mcu = null;

		try {
			bo = new FinancialEndYearTransBO();

			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());

			formBean.setStrFinEndDate(mcu.getStrFinancialEndDate(formBean
					.getStrStoreId(), formBean.getStrHospitalCode()));
			formBean.setStrFinStartDate(mcu.getStrFinancialStartDate(formBean
					.getStrStoreId(), formBean.getStrHospitalCode()));

			vo = (FinancialEndYearTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.FinancialEndYearTransVO", formBean);

			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrMsgType().equals("2")) {

				formBean.setStrErrMsg(vo.getStrMsgString());

			} else {
					formBean.setStrNormalMsg("New Financial End Date : "
						+ vo.getStrNewFinEndDate());
			}
		} catch (Exception e) {
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"FinancialEndYearTransDATA->insert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;

		}
	}

}
