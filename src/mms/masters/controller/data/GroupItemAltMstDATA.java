package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.GroupItemAltMstBO;

import mms.masters.controller.fb.GroupItemAltMstFB;

import mms.masters.vo.GroupItemAltMstVO;

/**
 * The Class GroupItemAltMstDATA.
 * 
 * @author amit kumar ateria
 */

public class GroupItemAltMstDATA {

	/**
	 * to display the Item Category combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void initialAdd(GroupItemAltMstFB formBean,
			HttpServletRequest request) {
		GroupItemAltMstBO bo = null;
		GroupItemAltMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try 
		{
			hisutil = new HisUtil("mms", "GroupItemAltMstBO");
			bo = new GroupItemAltMstBO();
			vo = new GroupItemAltMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrItemCategoryCmbWs() != null&& vo.getStrItemCategoryCmbWs().size() > 0) 
			{
				cmb = hisutil.getOptionValue(vo.getStrItemCategoryCmbWs(),"0^Select Value","Select Value",true);
			} 
			else 
			{
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemCatCombo(cmb);

		} 
		catch (Exception e) 
		{
			strmsgText = "Group Item Alt Master.GroupItemAltMstDATA.initialAdd(vo)"+ e.getMessage();
			HisException eObj = new HisException("mms","GroupItemAltMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID:"+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}
	}
	/**
	 * to display the existing group combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void getExGroup(GroupItemAltMstFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		GroupItemAltMstBO bo = null;
		GroupItemAltMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try 
		{
			hisutil = new HisUtil("mms", "GroupItemAltMstBO");
			bo = new GroupItemAltMstBO();
			vo = new GroupItemAltMstVO();

			String hosCode =MmsConfigUtil.GLOBAL_HOSPITAL_CODE;  //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			formBean.setStrItemCat(request.getParameter("strItemCat"));
			vo.setStrItemCat(request.getParameter("strItemCat"));

			bo.getExGroup(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getExGroupCmbWs() != null&& vo.getExGroupCmbWs().size() > 0) 
			{
				cmb= hisutil.getOptionValue(vo.getExGroupCmbWs(),"0^Select Value","Select Value",true);
			} 
			else 
			{
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrGroupNameCombo(cmb);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(cmb);

		} 
		catch (Exception e) 
		{
			strmsgText = "Group Item Alt Master.GroupItemAltMstDATA.getExGroup(vo)"+ e.getMessage();
			HisException eObj = new HisException("mms","GroupItemAltMstDATA->getExGroup()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID:"+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}
	}
	/**
	 * to display the replaced subgroup combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void getRpSubGroup(GroupItemAltMstFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		GroupItemAltMstBO bo = null;
		GroupItemAltMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try 
		{
			hisutil = new HisUtil("mms", "GroupItemAltMstBO");
			bo = new GroupItemAltMstBO();
			vo = new GroupItemAltMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE; //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			formBean.setStrRpGroupId(request.getParameter("strRpGroupId"));
			vo.setStrRpGroupId(request.getParameter("strRpGroupId"));

			bo.getRpSubGroup(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getRpSubGroupCmbWs() != null&& vo.getRpSubGroupCmbWs().size() > 0) 
			{
				 
				cmb = hisutil.getOptionValue(vo.getRpSubGroupCmbWs(),"-1","-1^No Change#-2^No Sub Group",true,false);
			} 
			else 
			{
				cmb = "<option value='-1' selected=\"selected\">No Change</option><option value='-2'>No Subgroup</option>";
			}

			formBean.setStrRpSubGroupNameCombo(cmb);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(cmb);

		} 
		catch (Exception e) 
		{
			strmsgText = "Group Item Alt Master.GroupItemAltMstDATA.getRpSubGroup(vo)"+ e.getMessage();
			HisException eObj = new HisException("mms","GroupItemAltMstDATA->getExGroup()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID:"+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
			hisutil = null;
		}
	}
	/**
	 * to display the existing Items/new items combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void getExItems(GroupItemAltMstFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		GroupItemAltMstBO bo = null;
		GroupItemAltMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		String cmb2 = "";
		try 
		{
			hisutil = new HisUtil("mms", "GroupItemAltMstBO");
			bo = new GroupItemAltMstBO();
			vo = new GroupItemAltMstVO();

			String hosCode =MmsConfigUtil.GLOBAL_HOSPITAL_CODE;  //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			formBean.setStrExGroupId(request.getParameter("strExGroupId"));
			vo.setStrExGroupId(request.getParameter("strExGroupId"));

			bo.getExItems(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getLeftItemListWS() != null&& vo.getLeftItemListWS().size() > 0) 
			{
				cmb= hisutil.getOptionValue(vo.getLeftItemListWS(),"","",true);
			} 
			else 
			{
				cmb = "";
			}
			if (vo.getLeftNewItemListWS() != null&& vo.getLeftNewItemListWS().size() > 0) 
			{
				cmb2= hisutil.getOptionValue(vo.getLeftNewItemListWS(),"","",true);
			} 
			else 
			{
				cmb2 = "";
			}
			formBean.setStrExDrugCnt(""+vo.getLeftItemListWS().size());
			formBean.setStrNewDrugCnt(""+vo.getLeftNewItemListWS().size());
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(cmb+"^"+cmb2);

		} 
		catch (Exception e) 
		{
			strmsgText = "Group Item Alt Master.GroupItemAltMstDATA.getExItems(vo)"+ e.getMessage();
			HisException eObj = new HisException("mms","GroupItemAltMstDATA->getExGroup()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID:"+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
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

	public static void insertRecord(GroupItemAltMstFB formBean,HttpServletRequest request) 
	{
		GroupItemAltMstBO bo = null;
		GroupItemAltMstVO vo = null;
		String strmsgText = "";

		try 
		{
			bo = new GroupItemAltMstBO();
			
			String hosCode =MmsConfigUtil.GLOBAL_HOSPITAL_CODE;  //request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrIsValid("1");
			vo = (GroupItemAltMstVO) TransferObjectFactory.populateData("mms.masters.vo.GroupItemAltMstVO",formBean);			

			bo.insertRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrMsg("Data Saved Successfully");
		} 
		catch (Exception e) 
		{
			strmsgText = "GroupItemAltMstDATA.insertRecord(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","GroupItemAltMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
		}
	}
}