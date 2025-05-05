/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptCNT.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.masters.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.masters.controller.data.StoreItemMappingMstDATA;
import mms.masters.controller.fb.StoreItemMappingMstFB;


public class StoreItemMappingMstCNT extends DispatchAction {

	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITIALDATA(mapping, form, request, response);

	}

	public ActionForward INITIALDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "index";
		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		try
		{			
			formBean.setStrCircleId("0");
		    StoreItemMappingMstDATA.getStoreCombo(formBean, request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward(strTarget);
	}

	
	public ActionForward DISTRICTCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getDistrictList(formBean, request, response);
		return null;
	}

	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getStoreCombo(formBean, request, response);
		return null;
	}


	public ActionForward STORETYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getStoreTypeList(formBean, request, response);
		return null;
	}


	public ActionForward SUBSTORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getSubStoreCombo(formBean, request, response);
		return null;
	}


	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getItemCatList(formBean, request, response);
		return null;
	}

	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getGroupList(formBean, request, response);
		return null;
	}


	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAME1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getDrugList(formBean, request, response);
		return null;
	}

	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.getProgrammeCombo(formBean, request, response);
		return null;
	}

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException 
	{
		String strTarget="index";
		StoreItemMappingMstFB formBean = (StoreItemMappingMstFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StoreItemMappingMstDATA.showReport_NEW(formBean, request, response);
//		return mapping.findForward(strTarget);
		return this.INITIALDATA( mapping, form,request,  response);

	}


}
