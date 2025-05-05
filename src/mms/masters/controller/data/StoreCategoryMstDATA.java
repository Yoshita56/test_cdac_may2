package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.StoreCategoryMstBO;
import mms.masters.controller.fb.StoreCategoryMstFB;
import mms.masters.vo.StoreCategoryMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstDATA.
 */
public class StoreCategoryMstDATA {
	
	/**
	 * to display the current date, Left Category List Box and Right Category
	 * List Box.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreCategoryMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		StoreCategoryMstBO bo = null;
		StoreCategoryMstVO vo = null;
		String strStoreName = "";
		String strStoreCmb = "";
		String strCategoryList1 = "";
		//String strCategoryList2 = "";

		try {
			strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);

			hisutil = new HisUtil("mms", "StoreCategoryMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new StoreCategoryMstBO();
			vo = new StoreCategoryMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			strStoreCmb = formBean.getCombo()[0];

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCmb);

			bo.initAdd(vo);
			
			
			 if (vo.getStrLeftStoreCategoryListWs() != null &&  vo.getStrLeftStoreCategoryListWs().size() > 0) 
			 {
		         strCategoryList1 = hisutil.getOptionValue(vo.getStrLeftStoreCategoryListWs(), "","0^Select Value", false);
	         }
	         else
	         {
		         strCategoryList1 = "<option value='0'>Select Value</option>";
	         }
	         formBean.setStrLeftStoreCategoryList(strCategoryList1);
	                   	  
			
           /*
			if (vo.getStrLeftStoreCategoryListWs() != null)
				strCategoryList1 = hisutil.getOptionValue(vo
						.getStrLeftStoreCategoryListWs(), "", "", true);

			formBean.setStrLeftStoreCategoryList(strCategoryList1); 

			if (vo.getStrRightStoreCategoryListWs() != null)
				strCategoryList2 = hisutil.getOptionValue(vo
						.getStrRightStoreCategoryListWs(), "", "", true);

			formBean.setStrRightStoreCategoryList(strCategoryList2);
			*/
			

		} catch (Exception e) {
			strmsgText = "Store Category Master.StoreCategoryMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreCategoryMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(StoreCategoryMstFB formBean,
			HttpServletRequest request) {
		StoreCategoryMstBO bo = null;
		StoreCategoryMstVO vo = null;
		String strmsgText = "";
		String strStoreCmb = "";

		try {
			bo = new StoreCategoryMstBO();
			vo = new StoreCategoryMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			strStoreCmb = formBean.getCombo()[0];

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCmb);
			vo.setStrIsValid("1");
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
            vo.setStrStoreItemCategory(formBean.getStrStoreItemCategory());
            vo.setStrItemBounded(formBean.getStrItemBounded());
            vo.setStrIsNewItemFlag(formBean.getStrIsNewItemFlag());

            bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			// e.printStackTrace();

			strmsgText = "Store Category Master.StoreCategoryMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreCategoryMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(StoreCategoryMstFB formBean,
			HttpServletRequest request) {
		StoreCategoryMstBO bo = null;
		StoreCategoryMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String strStoreName = "";
		try {
			strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);
			hisutil = new HisUtil("mms", "StoreCategoryMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			bo = new StoreCategoryMstBO();
			vo = new StoreCategoryMstVO();
			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[3].replace('$', '#').split("#");
			strtemp[3] = strtemp2[0];

			String strStoreId = strtemp[0];
			String strItemCatNo = strtemp[1];
			String strHospitalCode = strtemp[2];
			String strSLNo = strtemp[3];

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatNo(strItemCatNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreCatSlNo(strSLNo);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrStoreCategory(vo.getStrStoreCategory());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrItemBounded(vo.getStrItemBounded());
			formBean.setStrIsNewItemFlag(vo.getStrIsNewItemFlag());

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Store Category Master.StoreCategoryMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreCategoryMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(StoreCategoryMstFB formBean,
			HttpServletRequest request) {
		StoreCategoryMstBO bo = null;
		StoreCategoryMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new StoreCategoryMstBO();
			vo = new StoreCategoryMstVO();

			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[3].replace('$', '#').split("#");
			strtemp[3] = strtemp2[0];

			String strStoreId = strtemp[0];
			String strItemCatNo = strtemp[1];
			String strHospitalCode = strtemp[2];
			String strSLNo = strtemp[3];

			vo.setStrStoreId(strStoreId);
			vo.setStrStoreItemCategory(strItemCatNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreCatSlNo(strSLNo);

			vo.setStrSeatId(strSeatId);
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsNewItemFlag(formBean.getStrTmpNewItemFlag());
			vo.setStrItemBounded(formBean.getStrTmpItemBoundedFlag());
							
//			//System.out.println("Store Id:::"+vo.getStrStoreId());
//			//System.out.println("Store Item Catg:::"+vo.getStrStoreItemCategory());
//			//System.out.println("Catg Sl No:::"+vo.getStrStoreCatSlNo());
//			//System.out.println("Is New Item Flga:::"+vo.getStrIsNewItemFlag());
//			//System.out.println("Item Bound::"+vo.getStrItemBounded());
//			//System.out.println("Remarks::"+vo.getStrRemarks());

			
			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
            e.printStackTrace();
			strmsgText = "Store Category Master.StoreCategoryMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreCategoryMstDATA->updateRecord()", strmsgText);
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
