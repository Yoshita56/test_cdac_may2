package mms.masters.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.masters.bo.ModelTypeMstBO;
import mms.masters.controller.fb.ModelTypeMstFB;
import mms.masters.vo.ModelTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ModelTypeMstDATA.
 * 
 * @author Anshul Jindal
 */
public class ModelTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(ModelTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		String strGroupId = "";

		HisUtil hisutil = null;
		ModelTypeMstBO bo = null;
		ModelTypeMstVO vo = null;
		try {
			bo = new ModelTypeMstBO();
			vo = new ModelTypeMstVO();
			String strItemCategoryName = request.getParameter("comboValue");
			formBean.setStrItemCategoryName(strItemCategoryName);
			hisutil = new HisUtil("mms", "ModelTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			strGroupId = request.getParameter("GroupId");		

			
			String strItemCatNo = formBean.getCombo()[0];
			
			vo.setStrItemCatNo(strItemCatNo);
			vo.setStrGroupNameId(strGroupId);

             bo.getStoreGroupCmb(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String temp = "";
			
			if (vo.getWsGroupNameCombo() != null && vo.getWsGroupNameCombo().size() > 0) {
				if(vo.getWsGroupNameCombo().next())
				{
					vo.setStrGroupNameCombo((vo.getWsGroupNameCombo().getString(1)));
					vo.getWsGroupNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsGroupNameCombo(), "0","0^All", false, false);

			} else {
				temp = "<option value='0'>All</option>";
			}
			formBean.setStrGroupNameCombo(temp); 

		} catch (Exception e) {
			strmsgText = "ModelTypeMaster.ModelTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ModelTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}
	
	public static void getItemNameCombo(ModelTypeMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ModelTypeMstBO bo = null;
		ModelTypeMstVO vo = null;
		HisUtil hisutil = null;

		String hosCode = "";
		String seatid = "";
		String cmb = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String temp[] = null;

		// String strStoreTypeId = "";
		String strCategoryNo = "";

		String strStoreCombo = "";

		try {

			bo = new ModelTypeMstBO();
			vo = new ModelTypeMstVO();

			strGroupId = request.getParameter("GroupId");		
			strCategoryNo = request.getParameter("catgId");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrItemCatNo(strCategoryNo);
			vo.setStrGroupNameId(strGroupId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getItemNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ModelTypeMstDATA");
			cmb = hisutil.getOptionValue(vo.getWsItemNameCombo(), "0", "0^Select  Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

			}

		} catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "StoreItemMaster.ModelTypeMstDATA.getItemNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ModelTypeMstDATA->getItemNameCombo()", strmsgText);
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


	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(ModelTypeMstFB formBean,
			HttpServletRequest request) {
		
		ModelTypeMstBO bo = null;
		ModelTypeMstVO vo = null;
		
		String strmsgText = "";
		String strCategoryNo = "";
		String strGroupId = "";
		
		try {
			bo = new ModelTypeMstBO();
			vo = new ModelTypeMstVO();
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			

			
			
			String strItemCatNo = formBean.getCombo()[0];
			
			vo.setStrItemCatNo(strItemCatNo);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrIsValid("1");
			vo.setStrItemTypeName(formBean.getStrItemNameId());
			vo.setStrModelName(formBean.getStrModelName());
			vo.setStrGroupNameId(formBean.getStrGroupNameId());

			//vo.setStrShortName(formBean.getStrShortName());
			bo.insertRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			
			formBean.setStrMsg("Data Saved Successfully");
			

		} catch (Exception e) {
			
			e.printStackTrace();
			strmsgText = "ModelTypeMaster.ModelTypeMstDATA.insertRecord(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","ModelTypeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
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
	public static void modifyRecord(ModelTypeMstFB formBean,
			HttpServletRequest request) {
		ModelTypeMstBO bo = null;
		ModelTypeMstVO vo = null;
		String strmsgText = "";
		String strItemCatNo = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		try {
			String strItemCategoryName = request.getParameter("comboValue");
			formBean.setStrItemCategoryName(strItemCategoryName);

			hisutil = new HisUtil("mms", "ModelTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new ModelTypeMstBO();
			vo = new ModelTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strItemCatNo = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(strItemCatNo);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrItemCatNo(vo.getStrItemCatNo());
			formBean.setStrItemTypeName(vo.getStrItemTypeName());
			formBean.setStrShortName(vo.getStrShortName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "ModelTypeMaster.ModelTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ModelTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(ModelTypeMstFB formBean,
			HttpServletRequest request) {
		ModelTypeMstBO bo = null;
		ModelTypeMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strItemCatNo = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new ModelTypeMstBO();
			vo = new ModelTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strItemCatNo = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(strItemCatNo);

			vo.setStrItemTypeName(formBean.getStrItemTypeName());
			vo.setStrShortName(formBean.getStrShortName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {

			strmsgText = "ModelTypeMaster.ModelTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ModelTypeMstDATA->updateRecord()", strmsgText);
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
