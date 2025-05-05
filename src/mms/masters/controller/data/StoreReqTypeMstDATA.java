package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.StoreReqTypeMstBO;
import mms.masters.controller.fb.StoreReqTypeMstFB;
import mms.masters.vo.StoreReqTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreReqTypeMstDATA.
 */
public class StoreReqTypeMstDATA {
	
	/**
	 * to display the current date, Left Request Type List Box and Right Request
	 * Type List Box.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreReqTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		StoreReqTypeMstBO bo = null;
		StoreReqTypeMstVO vo = null;
		String strStoreName = "";
		String strStoreCmb = "";
		String strReqTypeList1 = "";
		String strReqTypeList2 = "";
		String strtemp[] = null;
		String strStoreCatId = "";

		try {
			bo = new StoreReqTypeMstBO();
			vo = new StoreReqTypeMstVO();
			hisutil = new HisUtil("mms", "StoreReqTypeMstDATA");

			strStoreName = request.getParameter("comboValue");
			strtemp = strStoreName.replace('^', '#').split("#");
			formBean.setStrStoreName(strtemp[0]);
			formBean.setStrStoreCategory(strtemp[1]);
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strStoreCmb = formBean.getCombo()[0];
			strStoreCatId = formBean.getCombo()[1];
			vo.setStrStoreCatId(strStoreCatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCmb);
			bo.initAdd(vo);
			formBean.setStrStoreCategoryId(strStoreCatId);
			formBean.setStrStoreId(strStoreCmb);
			formBean.setStrDummy(strStoreCmb);
			if (vo.getStrLeftRequestTypesListWs() != null)
				strReqTypeList1 = hisutil.getOptionValue(vo
						.getStrLeftRequestTypesListWs(), "", "", true);

			formBean.setStrLeftRequestTypeList(strReqTypeList1);

			if (vo.getStrRightRequestTypeListWs() != null)
				strReqTypeList2 = hisutil.getOptionValue(vo
						.getStrRightRequestTypeListWs(), "", "", true);

			formBean.setStrRightRequestTypeList(strReqTypeList2);

		} catch (Exception e) {
			strmsgText = "Store Req Type Master.StoreReqTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreReqTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(StoreReqTypeMstFB formBean,
			HttpServletRequest request) {
		StoreReqTypeMstBO bo = null;
		StoreReqTypeMstVO vo = null;
		String strmsgText = "";
		String strStoreCmb = "";

		String ReqTypeArray[] = null;
		String strStoreCatId = "";

		try {
			bo = new StoreReqTypeMstBO();
			vo = new StoreReqTypeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			strStoreCmb = formBean.getCombo()[0];
			formBean.setStrStoreId(strStoreCmb);
			strStoreCatId = formBean.getCombo()[1];
			formBean.setStrStoreCategoryId(strStoreCatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCmb);
			vo.setStrStoreCatId(strStoreCatId);
			vo.setStrIsValid("1");
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());

			ReqTypeArray = formBean.getStrRightRequestTypes();
			vo.setStrIndentTypeArray(ReqTypeArray);
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
				formBean.setStrDummy(strStoreCmb);
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "Store Req Type Master.StoreReqTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreReqTypeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(StoreReqTypeMstFB formBean,
			HttpServletRequest request) {
		StoreReqTypeMstBO bo = null;
		StoreReqTypeMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String strtemp3[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String strStoreName = "";
		try {
			bo = new StoreReqTypeMstBO();
			vo = new StoreReqTypeMstVO();
			strStoreName = request.getParameter("comboValue");
		//	//System.out.println("strStoreName"+strStoreName);
			strtemp = strStoreName.replace('^', '#').split("#");
		//	//System.out.println("strStoreName"+strtemp[0]+" setStrStoreCategory "+strtemp[1]);
			formBean.setStrStoreName(strtemp[0]);
			formBean.setStrStoreCategory(strtemp[1]);
			hisutil = new HisUtil("mms", "StoreReqTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			chk = request.getParameter("chk");
			////System.out.println("chk"+chk);
			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[3].replace('$', '#').split("#");
			strtemp[3] = strtemp2[0];

			String strStoreId = strtemp[0];

			String strStoreCatId = strtemp[1];

			String strIndentId = strtemp[2];

			String strHospitalCode = strtemp[3];

			strtemp3 = strtemp[4].replace('$', '#').split("#");
			String strSLNo = strtemp3[0];
			
		//	//System.out.println("----------------------- >strStoreId:"+strtemp[0]+"strStoreCatId:"+strStoreCatId+"strIndentId:"+strIndentId+"strSLNo:"+strSLNo);
			
			vo.setStrStoreId(strStoreId);
			vo.setStrIndentTypeId(strIndentId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrReqTypeSlNo(strSLNo);
			vo.setStrStoreCatId(strStoreCatId);
			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrReqType(vo.getStrReqType());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Store Req Type Master.StoreReqTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreReqTypeMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(StoreReqTypeMstFB formBean,
			HttpServletRequest request) {
		StoreReqTypeMstBO bo = null;
		StoreReqTypeMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strtemp3[] = null;
		String chk = "";
		try {
			bo = new StoreReqTypeMstBO();
			vo = new StoreReqTypeMstVO();

			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[3].replace('$', '#').split("#");
			strtemp[3] = strtemp2[0];

			String strStoreId = strtemp[0];
			String strStoreCatId = strtemp[1];
			String strIndentId = strtemp[2];
			String strHospitalCode = strtemp[3];
			strtemp3 = strtemp[4].replace('$', '#').split("#");
			String strSLNo = strtemp3[0];

			vo.setStrStoreId(strStoreId);
			vo.setStrIndentTypeId(strIndentId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrReqTypeSlNo(strSLNo);
			vo.setStrStoreCatId(strStoreCatId);

			vo.setStrSeatId(strSeatId);
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			strmsgText = "Store Req Type Master.StoreReqTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreReqTypeMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
