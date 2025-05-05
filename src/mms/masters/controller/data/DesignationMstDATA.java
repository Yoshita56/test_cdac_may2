package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.DesignationMstBO;
import mms.masters.controller.fb.DesignationMstFB;
import mms.masters.vo.DesignationMstVO;

//TODO: Auto-generated Javadoc
/**
 * Developer - Amit Kumar
 * 
 * Version - 1.0 Changes Done on 1/June/2011
 */

public class DesignationMstDATA 
{

	/**
	 * to display the current date.
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void getPageComponent(DesignationMstFB formBean,
			HttpServletRequest request) 
	{

		String strmsgText = "";
		HisUtil hisutil = null;
		try
		{
			hisutil = new HisUtil("dwh", "DesignationMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "Designation Master . DesignationMstDATA.getPageComponent(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dwh",
					"DesignationMstDATA->initialAdd()", strmsgText);
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

	public static void insertRecord(DesignationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DesignationMstVO vo = null;
		DesignationMstBO bo = null;

		try {
			bo = new DesignationMstBO();
			vo = new DesignationMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrDesignationName(formBean.getStrDesignationName());			
            vo.setStrMode("1");
			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) 
			{
				formBean.setStrWarning("Data already exist");
			}
			else 
			{
				formBean.setStrMsg("Data Saved Successfully");
			}

		} 
		catch (Exception e) 
		{
			
			strmsgText = "DesignationMst.DesignationMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dwh",
					"DesignationMstDATA->insertRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(DesignationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DesignationMstVO vo = null;
		DesignationMstBO bo = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		HisUtil hisutil = null;
		try {
			bo = new DesignationMstBO();
			vo = new DesignationMstVO();

			hisutil = new HisUtil("dwh", "DesignationMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);


			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];
            vo.setStrDesignationId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean.setStrDesignationName(vo.getStrDesignationName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));
		} catch (Exception e) {
            e.printStackTrace();
			strmsgText = "DesignationMst.DesignationMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dwh",
					"DesignationMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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
	public static boolean updateRecord(DesignationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DesignationMstVO vo = null;
		DesignationMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {
			bo = new DesignationMstBO();
			vo = new DesignationMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrMode("2");
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrDesignationId(strtemp[0]);
			vo.setStrDesignationName(formBean.getStrDesignationName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

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

			strmsgText = "DesignationMst.DesignationMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("dwh",
					"DesignationMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
