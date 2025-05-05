package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.CondemnationRegisterViewTransBO;
import mms.transactions.controller.fb.CondemnationRegisterViewTransFB;
import mms.transactions.controller.hlp.CondemnationRegisterViewTransHLP;
import mms.transactions.vo.CondemnationRegisterViewTransVO;

public class CondemnationRegisterViewTransDATA {
	
	/*
	 * Developer : Kapil Khurana
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
	public static void viewData(CondemnationRegisterViewTransFB formBean,HttpServletRequest request) 
	{
		CondemnationRegisterViewTransBO bo = null;
		CondemnationRegisterViewTransVO vo = null;
		String strmsgText = "";
		String str1 ="";
	
		try 
		{
			bo = new CondemnationRegisterViewTransBO();
			vo = new CondemnationRegisterViewTransVO();
			
			String chk=request.getParameter("chk");
			String strTemp[]=chk.replace('@', '#').split("#");
			vo.setStrAgendaNo(strTemp[0]);
			formBean.setStrStoreId(request.getParameterValues("combo")[0]);
			//formBean.setStrItemCategoryNo(request.getParameter("combo2"));
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			formBean.setCombo(request.getParameterValues("combo"));
			bo.viewData(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			WebRowSet ws = vo.getStrCondemnDetailsWs();
			
			WebRowSet ws2 = vo.getStrItemDetailsWs();
			 
			 while(ws.next())
			 {
				 formBean.setStrStoreId(ws.getString(1));
				 formBean.setStrAgendaNo(ws.getString(2));
				 formBean.setStrAgendaDate(ws.getString(3));
				 formBean.setStrCondemnationType(ws.getString(4));
				 formBean.setStrTenderNo(ws.getString(5));
				 formBean.setStrTenderDate(ws.getString(6));
				 formBean.setStrQuotationNo(ws.getString(7));
				 formBean.setStrQuotationDate(ws.getString(8));
				 formBean.setStrAmountReceived(ws.getString(9));
				 formBean.setStrInstNumber(ws.getString(10));
				 formBean.setStrInstDate(ws.getString(11));
				 formBean.setStrBankName(ws.getString(12));
				 formBean.setStrCommitteeType(ws.getString(13));
				 formBean.setStrPaymentMode(ws.getString(14));
				 formBean.setStrBuyerName(ws.getString(15));
				 formBean.setStrRemarks(ws.getString(16));
				 formBean.setStrWeight(ws.getString(17));
				 formBean.setStrCondemnationTypeName(ws.getString(18));
				 
			 }
			 
			ws.beforeFirst();
			str1=CondemnationRegisterViewTransHLP.getItemDetails(ws2);
			 
			
			formBean.setStrSetItemDetails(str1);
			}
				catch (Exception e) 
			{
            e.printStackTrace(); 
			strmsgText = "CondemnationRegisterViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CondemnationRegisterViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	public static void viewReqData(CondemnationRegisterViewTransFB formBean,HttpServletRequest request) 
	{
		CondemnationRegisterViewTransBO bo = null;
		CondemnationRegisterViewTransVO vo = null;
		String strmsgText = "";
		String strItemDtl="";
		try 
		{
			bo = new CondemnationRegisterViewTransBO();
			vo = new CondemnationRegisterViewTransVO();
			
			String chk=request.getParameter("chk");
			String strTemp[]=chk.replace('@', '#').split("#");
			vo.setStrAgendaNo(strTemp[0]);
			formBean.setStrStoreId(request.getParameterValues("combo")[0]);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strTemp=request.getParameter("comboValue").replace('^', '#').split("#");
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			formBean.setCombo(request.getParameterValues("combo"));
			bo.viewReqData(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			strItemDtl=CondemnationRegisterViewTransHLP.getItemDtl(vo.getItemDtlWS());
			////System.out.println("strItemDtl--->"+strItemDtl);
			formBean.setStrItemDtl(strItemDtl);
			formBean.setStrStoreName(strTemp[0]);
			formBean.setStrItemCategoryName(strTemp[1]);
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrCondemnationType(vo.getStrCondemnationType());
	}
		catch (Exception e){
           
				strmsgText = "CondemnationRegisterViewTransDATA.viewReqData(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"CondemnationRegisterViewTransDATA->viewData()", strmsgText);
				formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
	
				eObj = null;
		} finally {
			bo = null;
			vo = null;
	}

}


}
