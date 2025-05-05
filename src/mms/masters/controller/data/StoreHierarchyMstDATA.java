package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.StoreHierarchyMstBO;
import mms.masters.controller.fb.StoreHierarchyMstFB;
import mms.masters.vo.StoreHierarchyMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstDATA.
 * 
 * @author Anshul Jindal
 */
public class StoreHierarchyMstDATA {
	
	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreHierarchyMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		StoreHierarchyMstBO bo = null;
		StoreHierarchyMstVO vo = null;
		String strFromStoreCmb = "";
		String strReqTypeCmb = "";
		String strItemCatCmb = "";
		String strStoreList1 = "";
		String strStoreList2 = "";
		String temp[] = null;
		try {
			String strComboValue = request.getParameter("comboValue");
			temp = strComboValue.replace('^', '#').split("#");

			String strFromStoreName = temp[0];
			String strItemCat = temp[1];
			String strRequestType = temp[2];
			formBean.setStrFromStoreName(strFromStoreName);
			formBean.setStrItemCatId(strItemCat);
			formBean.setStrRequestType(strRequestType);

			formBean.setStrComboValue(strComboValue);

			hisutil = new HisUtil("mms", "StoreHierarchyMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new StoreHierarchyMstBO();
			vo = new StoreHierarchyMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			strFromStoreCmb = formBean.getCombo()[0];
			strItemCatCmb = formBean.getCombo()[1];
			strReqTypeCmb = formBean.getCombo()[2];

			temp = strFromStoreCmb.replace('^', '#').split("#");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrFromStoreId(temp[0]);
			vo.setStrFromStoreLevel(temp[1]);
			vo.setStrFromStoreTypeId(temp[2]);
			vo.setStrRequestTypeId(strReqTypeCmb);
			vo.setStrItemCatId(strItemCatCmb);

			bo.initAdd(vo);

			if (vo.getStrLeftStoreNamesListWs() != null)
				strStoreList1 = hisutil.getOptionValue(vo
						.getStrLeftStoreNamesListWs(), "", "", true);

			formBean.setStrLeftStoreNamesList(strStoreList1);

			if (vo.getStrRightStoreNamesListWs() != null)
				strStoreList2 = hisutil.getOptionValue(vo
						.getStrRightStoreNamesListWs(), "", "", true);

			formBean.setStrRightStoreNamesList(strStoreList2);
			formBean.setStrFromStoreId(vo.getStrFromStoreId());
			formBean.setStrRequestTypeId(strReqTypeCmb);
			formBean.setStrItemCatgory(strItemCatCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "StoreHierarchyMaster.StoreHierarchyMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreHierarchyMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(StoreHierarchyMstFB formBean,
			HttpServletRequest request) {
		StoreHierarchyMstBO bo = null;
		StoreHierarchyMstVO vo = null;
		String strmsgText = "";
		String temp[] = null;
		String strFromStoreCmb = "";
		String strReqTypeCmb = "";
		String strItemCatCmb = "";
		int nRightListLen = 0;
		String ToStoreArray[] = null;

		try {
			bo = new StoreHierarchyMstBO();
			vo = new StoreHierarchyMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			strFromStoreCmb = formBean.getCombo()[0];
			strItemCatCmb = formBean.getCombo()[1];
			strReqTypeCmb = formBean.getCombo()[2];

			// //System.out.println("data strFromStoreId=="+strFromStoreCmb);
			temp = strFromStoreCmb.replace('^', '#').split("#");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrFromStoreId(temp[0]);
			vo.setStrFromStoreLevel(temp[1]);
			vo.setStrFromStoreTypeId(temp[2]);
			vo.setStrIsValid("1");
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrRequestTypeId(strReqTypeCmb);
			vo.setStrItemCatId(strItemCatCmb);

			ToStoreArray = formBean.getStrRightStoreNames();
			nRightListLen = ToStoreArray.length;

			for (int i = 0; i < nRightListLen; i++) {
				if (!ToStoreArray[i].equals("0")) {
					vo.setStrToStoreId(ToStoreArray[i]);
					bo.insertRecord(vo);
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
				}

			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			// e.printStackTrace();

			strmsgText = "StoreHierarchyMaster.StoreHierarchyMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreHierarchyMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(StoreHierarchyMstFB formBean,
			HttpServletRequest request) {
		StoreHierarchyMstBO bo = null;
		StoreHierarchyMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
	//	String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String[] temp = null;
		String strRequestTypeId = "";
		String strItemCategory = "";
		try {
			temp = request.getParameter("comboValue").replace("^", "#").split(
					"#");

			String strFromStoreName = temp[0];
			String strItemCatName = temp[1];
			String strRequestType = temp[2];

			formBean.setStrFromStoreName(strFromStoreName);
			formBean.setStrItemCatId(strItemCatName);
			formBean.setStrRequestType(strRequestType);

			hisutil = new HisUtil("mms", "StoreHierarchyMstDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new StoreHierarchyMstBO();
			vo = new StoreHierarchyMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace("@", "#").split("#");
		//	strtemp2 = strtemp[5].replace("$", "#").split("#");

			String strFromStoreId = strtemp[0];
			strRequestTypeId = strtemp[2];
			strItemCategory = strtemp[1];
			String strToStoreId = strtemp[3];
			String strHospitalCode = strtemp[4];
			String strSLNo = strtemp[5].replace("$", "#").split("#")[0];
		//	String strToStoreName = strtemp2[0];

		//	formBean.setStrToStoreName(strToStoreName);

			vo.setStrFromStoreId(strFromStoreId);
			vo.setStrRequestTypeId(strRequestTypeId);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSLNo(strSLNo);
			vo.setStrItemCatId(strItemCategory);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrToStoreName(vo.getStrToStoreName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrChk1(chk);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "StoreHierarchyMaster.StoreHierarchyMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreHierarchyMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(StoreHierarchyMstFB formBean,
			HttpServletRequest request) {
		StoreHierarchyMstBO bo = null;
		StoreHierarchyMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String strRequestTypeId = "";
		try {
			bo = new StoreHierarchyMstBO();
			vo = new StoreHierarchyMstVO();

			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[4].replace('$', '#').split("#");
			strtemp[4] = strtemp2[0];

			String strFromStoreId = strtemp[0];
			strRequestTypeId = strtemp[2];
			String strItemCatId = strtemp[1];
			String strToStoreId = strtemp[3];
			String strHospitalCode = strtemp[4];
			String strSLNo = strtemp[5].split("\\$")[0];
			

			vo.setStrFromStoreId(strFromStoreId);
			vo.setStrRequestTypeId(strRequestTypeId);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSLNo(strSLNo);

			vo.setStrFromStoreId(strFromStoreId);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSLNo(strSLNo);
			vo.setStrSeatId(strSeatId);
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrRequestTypeId(strRequestTypeId);
			vo.setStrItemCatId(strItemCatId);

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "StoreHierarchyMaster.StoreHierarchyMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreHierarchyMstDATA->updateRecord()", strmsgText);
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
	 * To get values of Item name Combo according to Group Id & Sub Group Id.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getAssociatedStore(StoreHierarchyMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StoreHierarchyMstBO bo = null;
		StoreHierarchyMstVO vo = null;
	    String strStoreList1="";
		String strStoreList2="";
		HisUtil hisutil = null;

		try {

			     bo = new StoreHierarchyMstBO();
			     vo = new StoreHierarchyMstVO();
			hisutil = new HisUtil("mms", "StoreHierarchyMstDATA");
			     vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				 vo.setStrFromStoreId(request.getParameter("StoreId"));
				 vo.setStrItemCatId(request.getParameter("ItemCatId"));
				 vo.setStrRequestTypeId(request.getParameter("RequestTypeId"));
				 // Calling BO Method 
				 if(request.getParameter("Flag").equals("2"))
				 { 
				   bo.getAssociatedStore(vo);
				 }
				 else
				 {
				   bo.initAdd(vo);
				 }	 
				
				 if (vo.getStrLeftStoreNamesListWs() != null)
					
					strStoreList1 = hisutil.getOptionValue(vo.getStrLeftStoreNamesListWs(), "", "", true);
				 
				 
				 if (vo.getStrRightStoreNamesListWs() != null)
					 
					 strStoreList2 = hisutil.getOptionValue(vo.getStrRightStoreNamesListWs(), "", "", true);
                  
				 ////System.out.println("strStoreList2:::"+strStoreList2);
				 if (vo.getStrMsgType().equals("1")) 
				 {
					throw new Exception(vo.getStrMsgString());
				 }

				
 
			
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strStoreList1+"^^^^"+strStoreList2); 

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "StoreItemMaster.StoreHierarchyMstDATA.getUnitCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreHierarchyMstDATA->getUnitCombo()", strmsgText);
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
		 
		}
	}

	
	

}
