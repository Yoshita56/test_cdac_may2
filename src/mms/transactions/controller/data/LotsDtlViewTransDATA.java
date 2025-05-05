package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.LotsDetailViewTransBO;

import mms.transactions.controller.fb.LotsDetailViewTransFB;
import mms.transactions.controller.hlp.LotsDtlHlpView;


import mms.transactions.vo.LotsViewDtlTransVO;

public class LotsDtlViewTransDATA {
	
	/*
	 * Developer :Anurudra Goel
	 * Version : 1.0 
	 * Date : 02/April/2009
	 *  Module:MMS
	 * Unit:Condemnation Register View  
	*/
	/**
	 * Method is Used to get the Data for view Page of
	 * Indent Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(LotsDetailViewTransFB _LotsDetailViewTransFB,HttpServletRequest request) 
	{
		LotsDetailViewTransBO bo = null;
		LotsViewDtlTransVO vo = null;
		String strmsgText = "";
		
		String strChk="";
		String strTemp1[]=null;
		String strTemp2[]=null;
		String strItemDtl="";
		
		try 
		{
				bo = new LotsDetailViewTransBO();
				vo = new LotsViewDtlTransVO();
				String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				strChk=request.getParameter("chk");
				strTemp1=strChk.replace('@', '#').split("#");
				strTemp2=request.getParameter("comboName").replace('^', '#').split("#");
				vo.setStrStoreId(request.getParameterValues("combo")[0]);
				vo.setStrItemCategoryNo(request.getParameterValues("combo")[1]);
				vo.setStrAgendaNo(strTemp1[1]);
				vo.setStrHospitalCode(hosCode);
				bo.viewData(vo);
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				strItemDtl=LotsDtlHlpView.getItemDtl(vo.getItemDtlWS());
				
				_LotsDetailViewTransFB.setStrStoreName(strTemp2[0]);
				_LotsDetailViewTransFB.setStrItemCategoryName(strTemp2[1]);
				_LotsDetailViewTransFB.setStrItemBrandName(vo.getStrItemBrandName());
				_LotsDetailViewTransFB.setStrItemName(vo.getStrItemName());
				_LotsDetailViewTransFB.setStrCancelDate(vo.getStrCancelDate());
				_LotsDetailViewTransFB.setStrCancelBy(vo.getStrCancelBy());
				_LotsDetailViewTransFB.setStrCancelRemarks(vo.getStrCancelRemarks());
				_LotsDetailViewTransFB.setStrCondemnationType(vo.getStrCondemnationType());
				_LotsDetailViewTransFB.setStrItemDtl(strItemDtl);
				_LotsDetailViewTransFB.setCombo(request.getParameterValues("combo"));
			}
				catch (Exception e) 
			{
            e.printStackTrace();
			strmsgText = "CondemnationRegisterViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LotsDtlViewTransDATA->viewData()", strmsgText);
			_LotsDetailViewTransFB.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	

}
