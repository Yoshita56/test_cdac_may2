package hisglobal.transactionutil.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.bo.DeskAccessDetailsBO;
import hisglobal.transactionutil.controller.fb.DeskAccessDetailsFB;
import hisglobal.transactionutil.vo.DeskAccessDetailsVO;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author Anshul Jindal
 *
 */

public class DeskAccessDetailsDATA {
	/**
	 * to display the current date and userName,DeskName combos and menu list 
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(DeskAccessDetailsFB formBean,
			HttpServletRequest request) {

		DeskAccessDetailsBO bo = null;
		DeskAccessDetailsVO vo = null;
		HisUtil hisutil = null;
		
		String strmsgText = "";
		
		String ctDate = "";
		String hosCode = "";
		String seatid = "";
		
		String strUserNameCombo = "";
		String strDeskNameCombo = "";

		try {
			bo = new DeskAccessDetailsBO();
			vo = new DeskAccessDetailsVO();

			hisutil = new HisUtil("transutil", "DeskAccessDetailsDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			hosCode = "108";
			//request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = "1009";//request.getSession().getAttribute("SEATID").toString();

						
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			

			bo.getInitialValues(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			strUserNameCombo = hisutil.getOptionValue(vo.getUserNameComboWS(),
					"0^Select Value", "Select Value", true);
			vo.setStrUserNameCombo(strUserNameCombo);
			
			formBean.setStrUserNameCombo(strUserNameCombo);

			strDeskNameCombo = hisutil.getOptionValue(vo.getDeskNameComboWS(),
					"0^Select Value", "Select Value", true);
			vo.setStrDeskNameCombo(strDeskNameCombo);

			formBean.setStrDeskNameCombo(strDeskNameCombo);

		} catch (Exception e) {
			strmsgText = "hisglobaltransactionutil.DeskAccessDetailsDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DeskAccessDetailsDATA->getInitialValues()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo=null;
			vo=null;
			hisutil = null;
		}

	}
	
	/**
	 * To get values of LEFT MENU LIST
	 * 
	 * @param form
	 * @param request
	 */
	public static void getLeftList(DeskAccessDetailsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DeskAccessDetailsBO bo = null;
		DeskAccessDetailsVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = "";
		String strSeatId = "";
		String strUserId = "";
		String strDeskId = "";
		
		String strLeftListValues = "";
		

		try {

			bo = new DeskAccessDetailsBO();
			vo = new DeskAccessDetailsVO();
			hisutil = new HisUtil("transutil", "DeskAccessDetailsDATA");
			
			strHospitalCode = "108";
			//request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = "1009";//request.getSession().getAttribute("SEATID").toString();
			
			strUserId = (String) request.getParameter("userId");
			strDeskId = (String) request.getParameter("deskId");
			//System.out.println("strUserId"+strUserId);
			//System.out.println("strDeskId"+strDeskId);
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrUserId(strUserId);
			vo.setStrDeskId(strDeskId);

			bo.getLeftList(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			strLeftListValues = hisutil.getOptionValue(vo.getLeftMenuListWS(), "", "", true);

			// System.out.println("strLeftListValues-"+strLeftListValues);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strLeftListValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "hisglobaltransactionutil.DeskAccessDetailsDATA.getLeftList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("hisglobaltransactionutil",
					"DeskAccessDetailsDATA->getLeftList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	/**
	 * To get values of RIGHT MENU LIST
	 * 
	 * @param form
	 * @param request
	 */
	public static void getRightList(DeskAccessDetailsFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DeskAccessDetailsBO bo = null;
		DeskAccessDetailsVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = "";
		String strSeatId = "";
		String strUserId = "";
		String strDeskId = "";
		
		String strRightListValues = "";
		

		try {

			bo = new DeskAccessDetailsBO();
			vo = new DeskAccessDetailsVO();
			hisutil = new HisUtil("transutil", "DeskAccessDetailsDATA");
			
			strHospitalCode = "108";
			//request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = "1009";//request.getSession().getAttribute("SEATID").toString();
			
			strUserId = (String) request.getParameter("userId");
			strDeskId = (String) request.getParameter("deskId");
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrUserId(strUserId);
			vo.setStrDeskId(strDeskId);

			bo.getRightList(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			strRightListValues = hisutil.getOptionValue(vo.getRightMenuListWS(), "", "", true);
			
			// System.out.println("strRightListValues-"+strRightListValues);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strRightListValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "hisglobaltransactionutil.DeskAccessDetailsDATA.getRightList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("hisglobaltransactionutil",
					"DeskAccessDetailsDATA->getRightList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(DeskAccessDetailsFB formBean,
			HttpServletRequest request) {
		DeskAccessDetailsBO bo = null;
		DeskAccessDetailsVO vo = null;
		String strmsgText = "";
		
		int nRightListLen =0;
		String RightListArray[] = null;
		String strHospitalCode = "";
		String strSeatId = "";
		
		try {
			bo = new DeskAccessDetailsBO();
			vo = new DeskAccessDetailsVO();

			strHospitalCode = "108";
			//request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = "1009";//request.getSession().getAttribute("SEATID").toString();
			

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrIsValid("1");
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrUserId(formBean.getStrUserId());
			vo.setStrDeskId(formBean.getStrDeskId());
			vo.setStrMenuPosition(formBean.getStrMenuPosition());
			
			// System.out.println("data formBean.getStrRightMenuNames()"+formBean.getStrRightMenuNames().length);
			RightListArray = formBean.getStrRightMenuNames();
			nRightListLen = RightListArray.length;
			
			bo.deleteRecords(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			for(int i=0;i<nRightListLen;i++)
			{
				if(!RightListArray[i].equals("0"))
					{
					vo.setStrMenuId(RightListArray[i]);
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

		}catch (Exception e) {
			strmsgText = "hisglobaltransactionutil.DeskAccessDetailsDATA.getInitialValues(vo) --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"DeskAccessDetailsDATA->getInitialValues()", strmsgText);
		formBean.setStrErr("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
	} finally {
		bo=null;
		vo=null;
		
	}

	}
}
