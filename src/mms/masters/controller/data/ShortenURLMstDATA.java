/**
 * 
 */
package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.ShortenURLMstBO;

import mms.masters.controller.fb.ShortenURLMstFB;

import mms.masters.controller.hlp.ShortenURLMstHLP;


import mms.masters.vo.ShortenURLMstVO;
/**
 * @author Niharika Srivastava 
 * Date : 20-08-10 
 * Process : Drug Contradiction Master 
 * Module: MMS 
 * Team Lead:Mr. Ajay Kumar Gupta
 *  Description : Data Class for Drug Contradiction Master
 */

public class ShortenURLMstDATA {

	public static void initialAdd(ShortenURLMstFB formBean,
			HttpServletRequest request) {
		System.out.println("--------ShortenURLMstDATA.initialAdd-------");
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";
		String strCtDate = "";
		String strHosCode = "";
		String seatid = "";
		String cmb = "";

		try {
			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			hisutil = new HisUtil("mms", "DrugContradictionMstDATA");
			strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(strCtDate);

			strHosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strHosCode);
			vo.setStrSeatId(seatid);

			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DrugContradictionMaster.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}

	public static void getDrugNameCombo(ShortenURLMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("--------ShortenURLMstDATA.getDrugNameCombo-------");
		String strmsgText = "";
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = request.getSession().getAttribute(
				"HOSPITAL_CODE").toString();
		String strSeatId = request.getSession().getAttribute("SEATID")
				.toString();
		String strGroupId = (String) request.getParameter("strGroupId");

		try {

			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(strGroupId);

			bo.getDrugNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "DrugContradictionDATA");
			String cmb = hisutil.getOptionValue(vo.getStrDrugNameComboWs(), vo
					.getStrDrugId(), "0^Select Value", true);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "DrugContradictionDATA.getWardCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionDATA->getWardCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}

	}

	public static void getContradictedDrugList(ShortenURLMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("--------ShortenURLMstDATA.getContradictedDrugList-------");
		String strmsgText = "";
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		HisUtil hisutil = null;

		String strHosCode = "";
		String strSeatid = "";
		String cmb = "";
		String cmb2 = "";
		String strDrugId = "";
		String strGroupId = "";

		try {

			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			strDrugId = request.getParameter("strDrugId");
			strGroupId = request.getParameter("strGroupId");

			strHosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;     //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrDrugId(strDrugId);
			vo.setStrHospitalCode(strHosCode);
			vo.setStrSeatId(strSeatid);
			vo.setStrGroupId(strGroupId);

			bo.getLeftDrugList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "DrugContradictionDATA");
			if (vo.getLeftItemListWS() != null
					&& vo.getLeftItemListWS().size() != 0) {
				cmb = hisutil.getOptionValue(vo.getLeftItemListWS(), "", "",
						true);
			} else {
				cmb = "";
			}

			if (vo.getRightItemListWS() != null
					&& vo.getRightItemListWS().size() != 0) {
				cmb2 = hisutil.getOptionValue(vo.getRightItemListWS(), "", "",
						false);
			} else {
				cmb2 = "";
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb + "@@" + cmb2);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "DrugContradictionDATA.getContradictedDrugList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionDATA->getContradictedDrugList()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	public static void insertRecord(ShortenURLMstFB formBean,
			HttpServletRequest request) {
		System.out.println("--------ShortenURLMstDATA.insertRecord-------");
		String strmsgText = "";
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		String strHospCode = "";
		String strSeatId = "";
		int nStopI = 0;
		int i;

		try {
			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			strHospCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;; //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();


			vo.setStrBaseId(formBean.getStrBaseId());
			vo.setStrOrgID(formBean.getStrOrgID());
			vo.setStrProId(formBean.getStrProId());

			
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(strHospCode);

			bo.insertRecord(vo); // Call Insert Function in BO

			formBean.setStrMsg("Data Saved Successfully");
			System.out.println("------------formBean.getStrMsg()---------"+formBean.getStrMsg());
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "ShortenURLMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ShortenURLMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}
	}

	public static void modifyRecord(ShortenURLMstFB formBean,
			HttpServletRequest request) {
		System.out.println("--------ShortenURLMstDATA.modifyRecord-------");
		String strmsgText = "";
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		HisUtil hisutil = null;
		String[] strTemp2 = null;
		String chk = "";
		String[] strTemp = null;
		String strLeftList = "";
		String strRightList = "";

		try {
			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			hisutil = new HisUtil("mms", "DrugContradictionDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			chk = request.getParameter("chk");

			strTemp = chk.replace('@', '#').split("#");
			strTemp2 = strTemp[2].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrDrugId(strTemp[0]);
			vo.setStrHospitalCode(strTemp[1]);
			vo.setStrContraDrugSlNo(strTemp2[0]);
			vo.setStrSeatId(seatid);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getLeftItemListWS() != null
					&& vo.getLeftItemListWS().size() != 0) {
				strLeftList = hisutil.getOptionValue(vo.getLeftItemListWS(),
						"", "", true);
			} else {
				strLeftList = "";
			}

			if (vo.getRightItemListWS() != null
					&& vo.getRightItemListWS().size() != 0) {
				strRightList = hisutil.getOptionValue(vo.getRightItemListWS(),
						"", "", false);
			} else {
				strRightList = "";
			}

			formBean.setStrDrugName(vo.getStrDrugName());
			formBean.setStrLeftItemList(strLeftList);
			formBean.setStrRightItemList(strRightList);
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk1(request.getParameter("chk"));

		} catch (Exception e) {
			strmsgText = "DrugContradictionDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			bo = null;
			vo = null;
		}
	}

	public static boolean updateRecord(ShortenURLMstFB formBean,
			HttpServletRequest request) {
		System.out.println("--------ShortenURLMstDATA.updateRecord-------");
		String strmsgText = "";
		boolean retValue = true;

		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;

		String[] strTemp2 = null;
		String chk = "";
		String[] strTemp = null;
		int stopI;
		String strContraDrugsId = "";

		try {
			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();
			chk = request.getParameter("chk");

			strTemp = chk.replace('@', '#').split("#");
			strTemp2 = strTemp[2].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			stopI = formBean.getStrRightItemIds().length;
			for (int i = 0; i < stopI; i++) {
				if (i == stopI - 1) {
					strContraDrugsId = strContraDrugsId
							+ formBean.getStrRightItemIds()[i];
				} else
					strContraDrugsId = strContraDrugsId
							+ formBean.getStrRightItemIds()[i] + ",";
			}

			vo.setStrDrugId(strTemp[0]);
			vo.setStrHospitalCode(strTemp[1]);
			vo.setStrContraDrugSlNo(strTemp2[0]);
			vo.setStrContraDrugsId(strContraDrugsId.trim());
			vo.setStrSeatId(seatid);

			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Record Modify Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DrugContradictionMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	public static void contradicView(ShortenURLMstFB formBean,
			HttpServletRequest request) {
		System.out.println("--------ShortenURLMstDATA.contradicView-------");
		String strmsgText = "";
		ShortenURLMstBO bo = null;
		ShortenURLMstVO vo = null;
		String strHlp = null;
		String[] strTemp = null;
		String[] strTemp2 = null;

		String chk = "";
		try {
			bo = new ShortenURLMstBO();
			vo = new ShortenURLMstVO();

			chk = request.getParameter("chk");
			strTemp = chk.replace('@', '#').split("#");
			strTemp2 = strTemp[2].replace('$', '#').split("#");

			vo.setStrDrugId(strTemp[0]);
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			vo.setStrContraDrugSlNo(strTemp2[0]);

			bo.contradicView(vo);
			bo.getContDrugName(vo);
			strHlp = ShortenURLMstHLP.getStrContDrugNameView(vo
					.getContraDrugNameWs());

			formBean.setStrDrugName(vo.getStrDrugName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrContraDrugs(strHlp);

		} catch (Exception e) {
			strmsgText = "DrugContradictionMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugContradictionMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
}
