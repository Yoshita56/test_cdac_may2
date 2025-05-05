package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.POComponentMstBO;
import mms.masters.controller.fb.POComponentMstFB;
import mms.masters.vo.POComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class POComponentMstDATA.
 * 
 * @author Anurudra Goel
 */

/**
 * @author Anshul Jindal
 *  Modify By : Tanvi Sappal
 *  Modify Date : 12/05/2010
 * 
 */
public class POComponentMstDATA {

	/**
	 * to display the Item Category combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(POComponentMstFB formBean,
			HttpServletRequest request) {
		POComponentMstBO bo = null;
		POComponentMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		//String[] temp = null;
		try {
			hisutil = new HisUtil("mms", "POComponentMstDATA");
			bo = new POComponentMstBO();
			vo = new POComponentMstVO();
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strComboVal = request.getParameter("comboValue").toString();
			//temp = strComboVal.replace("^", "#").split("#");
			String strCombo[] = request.getParameterValues("combo");
			//vo.setStrIndentTypeId(strCombo[0]);
			vo.setStrComponentTypeId(strCombo[0]);
			//formBean.setStrIndentTypeId(strCombo[0]);
			formBean.setStrComponentTypeId(strCombo[0]);
			//formBean.setStrPOTypeName(temp[0]);
			formBean.setStrComponentType(strComboVal);
			formBean.setComboValue(strComboVal);
			formBean.setCombo(strCombo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			//bo.setCatValue(vo);
			bo.getComponentName(vo);
			
			if (vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}else{

			if (vo.getWSComponentName() != null
					&& vo.getWSComponentName().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWSComponentName(), ""
						, "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			////System.out.println("cmb--"+cmb);
			formBean.setStrComponentValues(cmb);
			}
			/*if (vo.getItemCategoryWS() != null
					&& vo.getItemCategoryWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getItemCategoryWS(), vo
						.getStrCatNo(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrCatValues(cmb);
			if (vo.getWSPOTypeName() != null && vo.getWSPOTypeName().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWSPOTypeName(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrPOTypenameNameValues(cmb);
		*/
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			strmsgText = "PO Component Master.POComponentMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"POComponentMstDATA->initialAdd()", strmsgText);
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
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(POComponentMstFB formBean,
			HttpServletRequest request) {
		POComponentMstBO bo = null;
		POComponentMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new POComponentMstBO();
			vo = new POComponentMstVO();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			// //System.out.println("formBean.getStrIndentTypeId in
			// insert====="+formBean.getStrIndentTypeId());
			formBean.setStrHospitalCode(hosCode);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrComponentName(formBean.getStrComponentName());
			vo.setStrComponentValue1(formBean.getStrComponentValue1());
			vo.setStrComponentValue2(formBean.getStrComponentValue2());
			vo.setStrRemarks(vo.getStrRemarks());
			vo.setStrIndentTypeId("0");
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid("1");
			vo.setStrCatNo("0");
			vo.setStrComponentId(formBean.getStrComponentId());
			vo.setStrComponentTypeId(formBean.getStrComponentTypeId());
			vo.setStrParameterId(formBean.getStrParameterId());
			bo.insertRecord(vo);
			String temp[] = new String[1];
			temp[0] = formBean.getStrComponentTypeId();
			formBean.setCombo(temp);
			formBean.setStrComponentNameValues(formBean.getStrComponentName());
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data Already Exist");
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "PO Component Master.POComponentMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"POComponentMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(POComponentMstFB formBean,
			HttpServletRequest request) {
		POComponentMstBO bo = null;
		POComponentMstVO vo = null;
		String strtemp[] = null;
		// HisUtil hisutil=null;
		String strmsgText = "";
		String chk = "";
		// String cmb="";
		String[] temp = null;
		try {
			bo = new POComponentMstBO();
			vo = new POComponentMstVO();
			chk = request.getParameter("chk");
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
						
			//C.SSTNUM_INDENTTYPE_ID||'@'||C.HSTNUM_COMPONENT_ID||'@'||C.HSTNUM_SL_NO||'@'||
			//c.SSTNUM_ITEM_CAT_NO||'@'||C.GNUM_HOSPITAL_CODE||'@'||C.HSTNUM_COMP_TYPE_ID 
			
			//CHK-->0@1111@10@0@108@1$1
			
			strtemp = chk.replace('@', '#').split("#");
			vo.setStrIndentTypeId(strtemp[0]);
			vo.setStrComponentId(strtemp[1]);
			vo.setStrPOComponentSlNo(strtemp[2]);
			vo.setStrCatNo(strtemp[3]);
			
			String[] Temp = strtemp[5].replace('$', '#').split("#");
			
			vo.setStrComponentTypeId(Temp[0]);
			
			vo.setStrHospitalCode(hosCode);
			
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			
			vo.setStrSeatId(seatid);
			
			bo.modifyRecord(vo);
			
			// hisutil = new HisUtil("mms", "POComponentMstDATA");
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrComponentValue1(vo.getStrComponentValue1Values());
			formBean.setStrComponentValue2(vo.getStrComponentValue2Values());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			String strComboVal = request.getParameter("comboValue").toString();
			temp = strComboVal.replace("^", "#").split("#");
			formBean.setStrPOTypeName(temp[0]);
			formBean.setStrIndentTypeId(vo.getStrIndentTypeId());
			formBean.setStrChk(chk);
			formBean.setStrComponentNameModify(vo.getStrComponentNameModify());
			formBean.setStrComponentName(vo.getStrComponentId());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrParameterId(vo.getStrParameterId());

		} catch (Exception e) {

			strmsgText = "PO Component Master.POComponentMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"POComponentMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(POComponentMstFB formBean,
			HttpServletRequest request) {
		POComponentMstBO bo = null;
		POComponentMstVO vo = null;
		boolean retValue = true;
		String strtemp[] = null;
		// String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {

			bo = new POComponentMstBO();
			vo = new POComponentMstVO();
			chk = formBean.getStrChk();
			strtemp = chk.replace('@', '#').split("#");
			vo.setStrIndentTypeId(strtemp[0]);
			vo.setStrComponentId(strtemp[1]);
			vo.setStrPOComponentSlNo(strtemp[2]);
			vo.setStrCatNo(strtemp[3]);
			
            String[] Temp = strtemp[5].replace('$', '#').split("#");
			
			vo.setStrComponentTypeId(Temp[0]);
			
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrComponentValue1(formBean.getStrComponentValue1());
			vo.setStrComponentValue2(formBean.getStrComponentValue2());
			vo.setStrComponentName(formBean.getStrComponentName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrSeatId(seatid);
			vo.setStrParameterId(formBean.getStrParameterId());
			bo.updateRecord(vo);
			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
			} else {
				if (vo.getStrMsgType().equals("1")) {
					retValue = false;
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {
			retValue = false;
			strmsgText = "PO Componente Master.POComponentMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"POComponentMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			request.setAttribute("chk", chk);

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

		return retValue;
	}

	/**
	 * to display the Item Category combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	/*public static void getComponentName(POComponentMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		POComponentMstBO bo = null;
		POComponentMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		String categoryNo = "";
		try {
			hisutil = new HisUtil("mms", "POComponentMstDATA");
			bo = new POComponentMstBO();
			vo = new POComponentMstVO();
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			//categoryNo = (String) request.getParameter("categoryNo");
			//vo.setStrCatNo(categoryNo);
			vo.setStrComponentTypeId(strComponentTypeId)IndentTypeId(request.getParameter("reqType"));
			bo.getComponentName(vo);

			if (vo.getWSComponentName() != null
					&& vo.getWSComponentName().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWSComponentName(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e1) {

			}

		} catch (Exception e) {

			strmsgText = "PO Component Master.POComponentMstDATA.getComponentName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"POComponentMstDATA->getComponentName()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}*/

}
