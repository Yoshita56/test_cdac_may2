package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.DeliveryModeMstBO;

import mms.masters.controller.fb.DeliveryModeMstFB;

import mms.masters.vo.DeliveryModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryModeMstDATA.
 * 
 * @author manas meher
 */

public class DeliveryModeMstDATA {

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void insertRecord(DeliveryModeMstFB formBean,	HttpServletRequest request)
	{

		String strmsgText = "";
		DeliveryModeMstVO vo = null;
		DeliveryModeMstBO bo = null;

		try {
			bo = new DeliveryModeMstBO();
			vo = new DeliveryModeMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			vo.setStrIsValid("1");
			vo.setStrDeliveryModeName(formBean.getStrDeliveryModeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrDeliveryModeId(formBean.getStrDeliveryModeId());

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
			strmsgText = "Delivery Mode Master.DeliveryModeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DeliveryModeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
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

	public static void modifyRecord(DeliveryModeMstFB formBean,
			HttpServletRequest request) {

		DeliveryModeMstVO vo = null;
		DeliveryModeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";

		try {
			bo = new DeliveryModeMstBO();
			vo = new DeliveryModeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");

			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrDeliveryModeId(strtemp[1]);
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrDeliveryModeName(vo.getStrDeliveryModeName());

			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());

		} catch (Exception e) {
			strmsgText = "Delivery Mode Master.DeliveryModeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DeliveryModeMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
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

	public static boolean updateRecord(DeliveryModeMstFB formBean,
			HttpServletRequest request) {
		DeliveryModeMstVO vo = null;
		DeliveryModeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try 
		{
			        bo = new DeliveryModeMstBO();
			        vo = new DeliveryModeMstVO();
			       chk = request.getParameter("chk");
			   strtemp = chk.replace('@', '#').split("#");
			  strtemp2 = strtemp[2].replace("$", "#").split("#");
			  String seatid = request.getSession().getAttribute("SEATID").toString();
			  
			vo.setStrSerialNo(strtemp2[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrDeliveryModeId(strtemp[0]);
			
			vo.setStrSeatId(seatid);
			vo.setStrDeliveryModeName(formBean.getStrDeliveryModeName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				retValue = false;
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					retValue = false;
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			retValue = false;
			strmsgText = "Delivery Mode Master.DeliveryModeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DeliveryModeMstDATA->updateRecord()", strmsgText);
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
	 * Initial add.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(DeliveryModeMstFB formBean,
			HttpServletRequest request) {
		DeliveryModeMstVO vo = null;
		DeliveryModeMstBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "ComponentMstBO");
			bo = new DeliveryModeMstBO();
			vo = new DeliveryModeMstVO();
         
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo.initAdd(vo);

		} catch (Exception e) {

			strmsgText = "Delivery Mode Master.DeliveryModeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DeliveryModeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
}
