package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.CurrencyMstBO;
import mms.masters.controller.fb.CurrencyMstFB;
import mms.masters.vo.CurrencyMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyMstDATA.
 */
public class CurrencyMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(CurrencyMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "CurrencyMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "CurrencyMaster.CurrencyMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CurrencyMstDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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
	public static void insertRecord(CurrencyMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		CurrencyMstVO vo = null;
		CurrencyMstBO bo = null;

		try {
			bo = new CurrencyMstBO();
			vo = new CurrencyMstVO();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			//String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIsValid("1");
			vo.setStrCurrencyName(formBean.getStrCurrencyName());
			vo.setStrCurrencyShortName(formBean.getStrCurrencyShortName());
			vo.setStrCurrencyValue(formBean.getStrCurrencyValue());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrCurrencyId(formBean.getStrCurrencyId());
			vo.setStrDefault(formBean.getStrDefault());
			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			strmsgText = "CurrencyMst.CurrencyMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CurrencyMstDATA->insertRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}

	}

	/**
	 * invokes modifyQuery Method.
	 * 
	 * @param formBean -
	 * FormBean Object
	 * @param request the request
	 */
	public static void modifyRecord(CurrencyMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";

		CurrencyMstVO vo = null;
		CurrencyMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String[] temp = null;
		HisUtil hisutil = null;
		try {
			bo = new CurrencyMstBO();
			vo = new CurrencyMstVO();

			hisutil = new HisUtil("mms", "CurrencyMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID").toString();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			vo.setStrCurrencyId(strtemp[0]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrCurrencySlNo(strtemp[2]);
			vo.setStrStrSerialNo(temp[0]);
			
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			formBean.setStrCurrencyName(vo.getStrCurrencyName());
			formBean.setStrCurrencyShortName(vo.getStrCurrencyShortName());
			formBean.setStrCurrencyValue(vo.getStrCurrencyValue());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));
			formBean.setStrDefault(vo.getStrDefault());

		} catch (Exception e) {
			strmsgText = "CurrencyMst.CurrencyMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CurrencyMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
	}

	/**
	 * Update method returns true if Record Updated Successfully false if Record<br>
	 * Not Updated Successfully.
	 * 
	 * @param formBean -FormBean Object
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(CurrencyMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		boolean retValue = true;
		CurrencyMstVO vo = null;
		CurrencyMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String[] temp = null;

		try {

			bo = new CurrencyMstBO();
			vo = new CurrencyMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID").toString();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			vo.setStrCurrencyId(strtemp[0]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrCurrencySlNo(strtemp[2]);
			vo.setStrStrSerialNo(temp[0]);
			vo.setStrSeatId(seatid);

			vo.setStrCurrencyName(formBean.getStrCurrencyName());
			vo.setStrCurrencyShortName(formBean.getStrCurrencyShortName());
			vo.setStrCurrencyValue(formBean.getStrCurrencyValue());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrDefault(formBean.getStrDefault());
			bo.updateQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// TransferObjectFactory.populateData(formBean, vo);

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
			strmsgText = "CurrencyMst.CurrencyMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CurrencyMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	
	public static void CHECKDEFAULT(HttpServletRequest request,
			HttpServletResponse response, CurrencyMstFB formBean) {
		// Declaring Variables
		String strmsgText = "";
		CurrencyMstVO vo = null;
		CurrencyMstBO bo = null;
		
		
		try {
				bo=new CurrencyMstBO();
				vo=new CurrencyMstVO(); 
				String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
				vo.setStrHospitalCode(hosCode);
				bo.chkDuplicateDefault(vo);
				response.getWriter().write(vo.getStrDefault()+"^"+vo.getStrCurrencyName());

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"CurrencyMstDATA->CHECKDEFAULT()", strmsgText);
			formBean.setStrErrorMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			if (bo != null)
				bo = null;
		}

	}


}
