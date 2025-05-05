package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import mms.MmsConfigUtil;
import mms.transactions.bo.GatePassDetailsTransBO;
import mms.transactions.controller.fb.GatePassDetailsTransFB;
import mms.transactions.vo.GatePassDetailsTransVO;

import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author baisakhi
 * 
 */
public class GatePassDetailsTransDATA {
	/**
	 * to display the current date and store name,gate pass type,issued by combos
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(GatePassDetailsTransFB formBean,
			HttpServletRequest request) {

		GatePassDetailsTransBO bo = null;
		GatePassDetailsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";

		String ctDate = "";
		String hosCode = "";
		String seatid = "";

		String strStoreNameCombo = "";
		String strGatePassTypeCombo = "";
		String strIssueByCombo = "";

		try {
			bo = new GatePassDetailsTransBO();
			vo = new GatePassDetailsTransVO();

			hisutil = new HisUtil("mms", "GatePassDetailsTransDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getInitialValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStoreNameComboWS().size() != 0) {
				strStoreNameCombo = hisutil.getOptionValue(vo
						.getStoreNameComboWS(), "0^Select Value",
						"Select Value", true);

				formBean.setStrStoreNameCombo(strStoreNameCombo);
			}

			if (vo.getGatePassTypeComboWS().size() != 0) {
				strGatePassTypeCombo = hisutil.getOptionValue(vo
						.getGatePassTypeComboWS(), "0^Select Value",
						"Select Value", true);

				formBean.setStrGatePassTypeCombo(strGatePassTypeCombo);
			}

			if (vo.getIssueByComboWS().size() != 0) {
				strIssueByCombo = hisutil.getOptionValue(
						vo.getIssueByComboWS(), "0^Select Value",
						"Select Value", true);

				formBean.setStrIssueByCombo(strIssueByCombo);
			}

		} catch (Exception e) {
			strmsgText = "mms.transactions.controller.data.GatePassDetailsTransDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassDetailsTransDATA->getInitialValues()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(GatePassDetailsTransFB formBean,
			HttpServletRequest request) {
		GatePassDetailsTransBO bo = null;
		GatePassDetailsTransVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

		String strFinancialStartDate = "";
		String strFinancialEndDate = "";

		String strHospitalCode = "";
		String strSeatId = "";

		try {

			bo = new GatePassDetailsTransBO();
			vo = new GatePassDetailsTransVO();

			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			mcu = new MmsConfigUtil(strHospitalCode);
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			
			vo.setStrStoreId(formBean.getStrStoreId());

			
			strFinancialStartDate = mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode());
			strFinancialEndDate = mcu.getStrFinancialEndDate(vo.getStrStoreId(), vo.getStrHospitalCode());

			vo.setStrFinancialStartyear(strFinancialStartDate);
			vo.setStrFinancialEndYear(strFinancialEndDate);

			
			
			vo.setStrGatepassTypeCode(formBean.getStrGatepassTypeCode());
			vo.setStrValidity(formBean.getStrValidity());
			vo.setStrValidityUnit(formBean.getStrValidityUnit());
			vo.setStrIssueBy(formBean.getStrIssueBy());
			vo.setStrIssuedTo(formBean.getStrIssuedTo());
			vo.setStrRemarks(formBean.getStrRemarks());

			bo.insertRecords(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
				formBean.setStrFinancialStartyear("");
				formBean.setStrFinancialEndYear("");

				formBean.setStrHospitalCode("");
				formBean.setStrSeatId("");
				
				formBean.setStrStoreId("");

				formBean.setStrGatepassTypeCode("");
				formBean.setStrValidity("");
				formBean.setStrValidityUnit("");
				formBean.setStrIssueBy("");
				formBean.setStrIssuedTo("");
				formBean.setStrRemarks("");
			}

		} catch (Exception e) {

			strmsgText = "mms.transactions.controller.data.GatePassDetailsTransDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassDetailsTransDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu=null;
		}

	}

}
