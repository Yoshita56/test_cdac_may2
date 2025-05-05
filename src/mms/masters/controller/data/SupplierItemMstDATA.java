package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.SupplierItemMstBO;
import mms.masters.controller.fb.SupplierItemMstFB;
import mms.masters.vo.SupplierItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstDATA.
 * 
 * @author Anshul Jindal
 */
public class SupplierItemMstDATA {
	
	/**
	 * to display the current date and item,brand & RATE unit combos.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(SupplierItemMstFB formBean,
			HttpServletRequest request) {

		SupplierItemMstBO bo = null;
		SupplierItemMstVO vo = null;
		HisUtil hisutil = null;
		String temp[] = null;
		String strmsgText = "";
		// String strSupplierId = "";
		String strCategoryNo = "";
		String ctDate = "";
		String hosCode = "";
		String seatid = "";
		String strSupplierCombo = "";
		String strSupplierName = "";
		String strComboNames = "";
		String cmb = "";

		try {
			bo = new SupplierItemMstBO();
			vo = new SupplierItemMstVO();

			if (formBean.getStrComboValue().equals("")) {
				strComboNames = request.getParameter("comboValue");
			} else {
				strComboNames = formBean.getStrComboValue();
			}

			formBean.setStrComboValue(strComboNames);
			temp = strComboNames.replace('^', '#').split("#");
			
			//String strItemCategoryName = temp[0];
			strSupplierName = temp[1];

			formBean.setStrSupplierName(strSupplierName);
		//	formBean.setStrItemCategoryName(strItemCategoryName);

			hisutil = new HisUtil("mms", "SupplierItemMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strCategoryNo = formBean.getCombo()[0];
			strSupplierCombo = formBean.getCombo()[1];
		//	strCategoryNo = formBean.getCombo()[1];

			////System.out.println("strSupplierCombo-"+strSupplierCombo);
			temp = strSupplierCombo.replace('^', '#').split("#");
			 String strSupplierId = temp[0];
		//	 String strSupplierStatus = temp[1];
			 strCategoryNo = temp[2];
			// strCategoryNo = strSupplierId.substring(0, 1);
			 hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean.setStrSupplierStatus(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrSupplierId(strSupplierId);
			vo.setStrCategoryNo(strCategoryNo);
			
			////System.out.println("vo.getStrCategoryNo()-"+vo.getStrCategoryNo());
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrGroupComboWs() != null) {
				cmb = hisutil.getOptionValue(vo.getStrGroupComboWs(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value=0>Select Value</option>";
			}
			formBean.setStrGroupNameCombo(cmb);

			if (vo.getRightItemListWS() != null) {
				cmb = hisutil.getOptionValue(vo.getRightItemListWS(), "", "",
						true);
			} else {
				cmb = "<option value=0></option>";
			}

			formBean.setStrItemCategoryName(vo.getStrItemCategoryName());

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SupplierItemMaster.SupplierItemMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierItemMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}

	/**
	 * To get values of Unit Name Combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	/*
	 * public static void unitName(SupplierItemMstFB formBean,
	 * HttpServletRequest request,HttpServletResponse response){
	 * 
	 * String strmsgText = ""; SupplierItemMstBO bo = null; SupplierItemMstVO vo =
	 * null; String temp[]=null;
	 * 
	 * HisUtil hisutil = null; String cmbstr = ""; String strGenItemId="";
	 * String strInventoryUnitId=""; String hosCode=""; String seatid="";
	 * 
	 * try { ////System.out.println("inside unitName");
	 * 
	 * bo = new SupplierItemMstBO(); vo = new SupplierItemMstVO();
	 * if(request.getParameter("strGenItemId")!=null &&
	 * !request.getParameter("strGenItemId").equals("0")) { strGenItemId =
	 * request.getParameter("strGenItemId"); temp = strGenItemId.replace("^",
	 * "#").split("#"); strInventoryUnitId = temp[1];
	 * 
	 * ////System.out.println("strInventoryUnitId-"+strInventoryUnitId); hosCode =
	 * request.getSession().getAttribute("HOSPITAL_CODE") .toString(); seatid =
	 * request.getSession().getAttribute("SEATID").toString();
	 * 
	 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
	 * vo.setStrInventoryUnitId(strInventoryUnitId);
	 * 
	 * bo.getUnitValues(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * hisutil = new HisUtil("mms", "StoreItemMstDATA");
	 * if(vo.getStrRateUnitComboWs() != null &&
	 * vo.getStrRateUnitComboWs().size() > 0){ cmbstr =
	 * hisutil.getOptionValue(vo.getStrRateUnitComboWs(), "", "0^Select Value",
	 * false); }else{ cmbstr = "<option value='0'>Select Value</option>"; }
	 * 
	 * }else{ cmbstr = "<option value='0'>Select Value</option>"; } try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(cmbstr);
	 *  } catch (Exception e) {
	 *  }
	 * 
	 * 
	 * 
	 * }catch (Exception e) { strmsgText =
	 * "SupplierItemMaster.SupplierItemMstDATA.getBrandName(vo) --> " +
	 * e.getMessage(); HisException eObj = new HisException("mms",
	 * "SupplierItemMstDATA->getBrandName()", strmsgText); try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print( "ERROR#### Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "],Contact System Administrator! ");
	 *  } catch (Exception e1) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * eObj = null; } finally { vo = null; bo = null; hisutil = null; } }
	 */

	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(SupplierItemMstFB formBean,
			HttpServletRequest request) {
		SupplierItemMstBO bo = null;
		SupplierItemMstVO vo = null;
		String strmsgText = "";
		String temp[] = null;
		String strCategoryNo = "";
		String strSupplierStatus = "";
		String strSupplierId = "";
		String hosCode = "";
		String seatid = "";
		String strSupplierCombo = "";
		String strItemId = "";
		try {

			bo = new SupplierItemMstBO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			 hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			seatid = request.getSession().getAttribute("SEATID").toString();

			strSupplierCombo = formBean.getCombo()[1];

			temp = strSupplierCombo.replace('^', '#').split("#");
			strSupplierId = temp[0];
			// strCategoryNo = strSupplierId.substring(0, 1);
			strCategoryNo = temp[2];
			strSupplierStatus = temp[1];
			strItemId = formBean.getStrItemId();
			temp = strItemId.replace("^", "#").split("#");

			formBean.setStrItemId(temp[0]);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrSupplierId(strSupplierId);
			formBean.setStrIsValid("1");
			formBean.setStrSupplierStatus(strSupplierStatus);
			// ////System.out.println("insert
			// formBean.getStrItemRate()"+formBean.getStrItemRate());
			// ////System.out.println("insert
			// formBean.getStrRateUnitId()"+formBean.getStrRateUnitId());

			if (formBean.getStrItemRate() == null
					|| formBean.getStrItemRate().equals(""))
				formBean.setStrItemRate("0");
			if (formBean.getStrRateUnitId() == null
					|| formBean.getStrRateUnitId().equals(""))
				formBean.setStrRateUnitId("0");

			// ////System.out.println("insert
			// formBean.getStrGroupId()"+formBean.getStrGroupId());

			vo = (SupplierItemMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.SupplierItemMstVO", formBean);

			vo.setStrCategoryNo(strCategoryNo);
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "SupplierItemMaster.SupplierItemMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierItemMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(SupplierItemMstFB formBean,
			HttpServletRequest request) {
		SupplierItemMstBO bo = null;
		SupplierItemMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String temp[] = null;

		String strCategoryNo = "";
		String hosCode = "";
		String seatid = "";
		String strSupplierCombo = "";
		String strSupplierName = "";
	//	String cmb = "";
		String strComboNames = "";

		try {
			bo = new SupplierItemMstBO();
			vo = new SupplierItemMstVO();
			hisutil = new HisUtil("mms", "SupplierItemMstDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			if (formBean.getStrComboValue().equals("")) {
				strComboNames = request.getParameter("comboValue");
			} else {
				strComboNames = formBean.getStrComboValue();
			}
			// ////System.out.println("strComboName="+strComboNames);
			formBean.setStrComboValue(strComboNames);
			temp = strComboNames.replace('^', '#').split("#");
			strSupplierName = temp[1];
			//String strItemCategoryName = temp[1];

			formBean.setStrSupplierName(strSupplierName);
			//formBean.setStrItemCategoryName(strItemCategoryName);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strSupplierCombo = formBean.getCombo()[1];

			temp = strSupplierCombo.replace('^', '#').split("#");
		//	 String strStoreTypeId = temp[0];
			// strCategoryNo = strStoreTypeId.substring(0, 1);
			strCategoryNo =temp[2];

			formBean.setStrSupplierStatus(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrSupplierId(temp[0]);
			vo.setStrCategoryNo(strCategoryNo);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			
//			100@1800011@18000001@18100003@10@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[5].replace('$', '#').split("#");
			strtemp[5] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrSupplierId(strtemp[1]);
			vo.setStrItemId(strtemp[2]);
			vo.setStrItemBrandId(strtemp[3]);
			vo.setStrSupplierItemSlNo(strtemp[4]);
			vo.setStrSlNo(strtemp[5]);
			
			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			TransferObjectFactory.populateData(formBean, vo);

			formBean.setStrChk1(chk);
			formBean.setStrSupplierName(strSupplierName);
			formBean.setStrSupplierStatus(temp[1]);
			

		} catch (Exception e) {

			strmsgText = "SupplierItemMaster.SupplierItemMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierItemMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(SupplierItemMstFB formBean,
			HttpServletRequest request) {

		SupplierItemMstBO bo = null;
		SupplierItemMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String seatid = "";

		try {
			bo = new SupplierItemMstBO();

//			100@1800011@18000001@18100003@10@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[5].replace('$', '#').split("#");			
			strtemp[5] = strtemp2[0];
			
			seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strtemp[0]);
			formBean.setStrSupplierId(strtemp[1]);
			formBean.setStrItemId(strtemp[2]);
			formBean.setStrItemBrandId(strtemp[3]);
			formBean.setStrSupplierItemSlNo(strtemp[4]);
			formBean.setStrSlNo(strtemp[5]);
			
			formBean.setStrSeatId(seatid);

			if (formBean.getStrItemRate() == null
					|| formBean.getStrItemRate().equals(""))
				formBean.setStrItemRate("0");
			if (formBean.getStrRateUnitId() == null
					|| formBean.getStrRateUnitId().equals(""))
				formBean.setStrRateUnitId("0");

			vo = (SupplierItemMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.SupplierItemMstVO", formBean);

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
				retValue = false;
			}

		} catch (Exception e) {

			strmsgText = "SupplierItemMaster.SupplierItemMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierItemMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * To get values of Brand name Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getItemList(SupplierItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		SupplierItemMstBO bo = null;
		SupplierItemMstVO vo = null;
		HisUtil hisutil = null;

		String hosCode = "";
		String seatid = "";
		String cmb = "";
		String cmb2 = "";
		String strGroupId = "";
		String strSupplierId = "";
		String[] temp = null;

		try {

			bo = new SupplierItemMstBO();
			vo = new SupplierItemMstVO();

			strGroupId = request.getParameter("GroupId");
			strSupplierId = request.getParameter("SupplierId");
			//////System.out.println("strSupplierId" + strSupplierId);
			temp = strSupplierId.replace("^", "#").split("#");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			
			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrGroupId(strGroupId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrSupplierId(temp[0]);
			vo.setStrCategoryNo(temp[2]);
			bo.getLeftItemList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "SupplierItemMstDATA");
			if(vo.getLeftItemListWS()!=null && vo.getLeftItemListWS().size()!=0)
				
			cmb = hisutil.getOptionValue(vo.getLeftItemListWS(), "", "", true);
			else
				cmb="";
			
			if(vo.getRightItemListWS()!=null && vo.getRightItemListWS().size()!=0)
			cmb2 = hisutil.getOptionValue(vo.getRightItemListWS(), "", "", true);
			else
				cmb2="";

			////System.out.println("cmb-"+cmb);
			////System.out.println("cmb2-"+cmb2);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb+"@@"+cmb2);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "SupplierItemMaster.SupplierItemMstDATA.getItemList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierItemMstDATA->getItemList()", strmsgText);
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
	 * To get values of Brand name Combo
	 * 
	 * @param form
	 * @param request
	 */
	/*
	 * public static void getBrandName(SupplierItemMstFB formBean,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * String strmsgText = ""; SupplierItemMstBO bo = null; SupplierItemMstVO vo =
	 * null; HisUtil hisutil = null; //String temp[] = null; //String
	 * strStoreTypeId = ""; String strCategoryNo = ""; String strItemId[] =
	 * null; // String strStoreCombo = ""; String hosCode = ""; String seatid =
	 * ""; String cmb = "";
	 * 
	 * try {
	 * 
	 * bo = new SupplierItemMstBO(); vo = new SupplierItemMstVO();
	 * 
	 * strCategoryNo = (String) request.getParameter("CategoryNo"); String
	 * genItemId = (String) request.getParameter("ItemId"); if(genItemId !=null &&
	 * !genItemId.equals("0")) { strItemId=genItemId.replace("^",
	 * "#").split("#");
	 * 
	 *  // strStoreCombo = (String) request.getParameter("combo"); hosCode =
	 * request.getSession().getAttribute("HOSPITAL_CODE") .toString(); seatid =
	 * request.getSession().getAttribute("SEATID").toString();
	 * 
	 * temp = strStoreCombo.replace('^', '#').split("#"); strStoreTypeId =
	 * temp[2]; strCategoryNo = strStoreTypeId.substring(0, 1);
	 * 
	 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
	 * vo.setStrItemId(strItemId[0]); vo.setStrCategoryNo(strCategoryNo);
	 * 
	 * bo.getBrandName(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * hisutil = new HisUtil("mms", "SupplierItemMstDATA"); if
	 * (vo.getStrItemBrandComboWs() != null &&
	 * vo.getStrItemBrandComboWs().size() > 0) { cmb =
	 * hisutil.getOptionValue(vo.getStrItemBrandComboWs(), vo
	 * .getStrItemBrandId(), "0^Select Value", true);
	 * 
	 * }else{ cmb = "<option value='0'>Select Value</option>"; }
	 * 
	 * }else{ cmb = "<option value='0'>Select Value</option>"; } try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(cmb);
	 *  } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 *  } catch (Exception e) { strmsgText =
	 * "SupplierItemMaster.SupplierItemMstDATA.getBrandName(vo) --> " +
	 * e.getMessage(); HisException eObj = new HisException("mms",
	 * "SupplierItemMstDATA->getBrandName()", strmsgText); try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print( "ERROR#### Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "],Contact System Administrator! ");
	 *  } catch (Exception e1) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * eObj = null; } finally { vo = null; bo = null; hisutil = null; } }
	 * 
	 * 
	 *//**
		 * To get values of Brand name Combo
		 * 
		 * @param form
		 * @param request
		 */
	/*
	 * public static void getSubGroupCombo(SupplierItemMstFB formBean,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * String strmsgText = ""; SupplierItemMstBO bo = null; SupplierItemMstVO vo =
	 * null; HisUtil hisutil = null;
	 * 
	 * String hosCode = ""; String seatid = ""; String cmb = ""; String
	 * strGroupId = "";
	 * 
	 * try {
	 * 
	 * bo = new SupplierItemMstBO(); vo = new SupplierItemMstVO();
	 * 
	 * strGroupId = request.getParameter("GroupId"); hosCode =
	 * request.getSession().getAttribute("HOSPITAL_CODE") .toString(); seatid =
	 * request.getSession().getAttribute("SEATID").toString();
	 * 
	 * vo.setStrGroupId(strGroupId); vo.setStrHospitalCode(hosCode);
	 * vo.setStrSeatId(seatid);
	 * 
	 * bo.getSubGroupCombo(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * hisutil = new HisUtil("mms", "SupplierItemMstDATA"); cmb =
	 * hisutil.getOptionValue(vo.getStrSubGroupComboWs(), vo
	 * .getStrSubGroupId(), "0^Select Value", true);
	 * 
	 * try { response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(cmb);
	 *  } catch (Exception e) {
	 *  }
	 *  } catch (Exception e) { strmsgText =
	 * "SupplierItemMaster.SupplierItemMstDATA.getSubGroupCombo(vo) --> " +
	 * e.getMessage(); HisException eObj = new HisException("mms",
	 * "SupplierItemMstDATA->getSubGroupCombo()", strmsgText); try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print( "ERROR#### Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "],Contact System Administrator! ");
	 *  } catch (Exception e1) {
	 *  }
	 * 
	 * eObj = null; } finally { vo = null; bo = null; hisutil = null; } }
	 * 
	 *//**
		 * To get values of Item name Combo according to Group Id & Sub Group Id
		 * 
		 * @param form
		 * @param request
		 */
	/*
	 * public static void getItemNameCombo(SupplierItemMstFB formBean,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * String strmsgText = ""; SupplierItemMstBO bo = null; SupplierItemMstVO vo =
	 * null; HisUtil hisutil = null;
	 * 
	 * String hosCode = ""; String seatid = ""; String cmb = ""; String
	 * strGroupId = ""; String strSubGroupId = ""; String temp[] = null;
	 * 
	 * //String strStoreTypeId = ""; String strCategoryNo = "";
	 * 
	 * String strSupplierCombo = "";
	 * 
	 * try {
	 * 
	 * 
	 * bo = new SupplierItemMstBO(); vo = new SupplierItemMstVO();
	 * 
	 * strGroupId = request.getParameter("GroupId"); strSubGroupId =
	 * request.getParameter("SubGroupId"); strSupplierCombo =
	 * request.getParameter("SupplierComboId"); strCategoryNo =
	 * request.getParameter("CategoryNo");
	 * 
	 * //////System.out.println("SupplierItemMstDATA data getItemNameCombo
	 * strCategoryNo"+strCategoryNo);
	 * 
	 * hosCode = request.getSession().getAttribute("HOSPITAL_CODE") .toString();
	 * seatid = request.getSession().getAttribute("SEATID").toString();
	 * 
	 * temp = strSupplierCombo.replace('^', '#').split("#"); //String
	 * strStoreTypeId = temp[2]; //strCategoryNo = strStoreTypeId.substring(0,
	 * 1);
	 * 
	 * 
	 * vo.setStrSupplierId(temp[0]); vo.setStrCategoryNo(strCategoryNo);
	 * vo.setStrGroupId(strGroupId); vo.setStrSubGroupId(strSubGroupId);
	 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
	 * 
	 * bo.getItemNameCombo(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * hisutil = new HisUtil("mms", "SupplierItemMstDATA"); cmb =
	 * hisutil.getOptionValue(vo.getStrItemNameComboWs(), vo .getStrItemId(),
	 * "0^Select Value", true);
	 * 
	 * try { response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(cmb);
	 *  } catch (Exception e) {
	 *  }
	 *  } catch (Exception e) { strmsgText =
	 * "SupplierItemMaster.SupplierItemMstDATA.getItemNameCombo(vo) --> " +
	 * e.getMessage(); HisException eObj = new HisException("mms",
	 * "SupplierItemMstDATA->getItemNameCombo()", strmsgText); try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print( "ERROR#### Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "],Contact System Administrator! ");
	 *  } catch (Exception e1) {
	 *  }
	 * 
	 * eObj = null; } finally { vo = null; bo = null; hisutil = null; } }
	 */

}