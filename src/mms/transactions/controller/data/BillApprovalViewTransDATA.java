package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.BillApprovalViewTransBO;
import mms.transactions.controller.fb.BillApprovalViewTransFB;
import mms.transactions.controller.hlp.BillApprovalViewTransHLP;
import mms.transactions.vo.BillApprovalViewTransVO;

public class BillApprovalViewTransDATA {
	/*
	 * Developer : Anurudra Goel
	 * Version : 1.0 
	 * Date : 23/June/2009
	 *  Module:MMS
	 * Unit:Bill Approval View  
	*/
	
	/**
	 * Method is Used to get the Data for view Page of
	 * Indent Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(BillApprovalViewTransFB formBean,HttpServletRequest request) 
	{
		BillApprovalViewTransBO bo = null;
		BillApprovalViewTransVO vo = null;
		String strmsgText = "";
		String strScheduleDtl="";
		String strChk="";
		String comboVal="";
		String[] temp = null;
		try 
		{
			bo = new BillApprovalViewTransBO();
			vo = new BillApprovalViewTransVO();
			comboVal=request.getParameter("comboValue");
			
			strChk=request.getParameter("chk");
		//	//System.out.println("strChk->"+strChk);
			temp=strChk.replace('@','#').split("#");
			vo.setStrPoNo(temp[1]);
			vo.setStrStoreId(temp[0]);
			vo.setStrInvoiceNo(temp[2]);
			temp=temp[6].replace('$','#').split("#");
		//	//System.out.println("poSTOREiD->"+temp[0]);
			vo.setStrPoStoreId(temp[0]);
			temp=comboVal.replace('@','#').split("#");
			formBean.setStrStoreName(temp[0]);
			formBean.setStrBillType(temp[1]);
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}else{
					
					strScheduleDtl=BillApprovalViewTransHLP.getScheduleDtl(vo.getScheduleWS());
					formBean.setStrPoDate(vo.getStrPoDate());
					formBean.setStrPoType(vo.getStrPoType());
					formBean.setStrSupplierDtl(vo.getStrSupplierDtl());
					formBean.setStrCurrancyName(vo.getStrCurrancyName());
					formBean.setStrCurrancyValue(vo.getStrCurrancyValue());
					formBean.setStrTax(vo.getStrTax());
					formBean.setStrAdvanceAmount(vo.getStrAdvanceAmount());
					formBean.setStrPeneltyAmt(vo.getStrPeneltyAmt());
					formBean.setStrWaveOffDtl(vo.getStrWaveOffDtl());
					formBean.setStrWaveOffAmt(vo.getStrWaveOffAmt());
					formBean.setStrApprovedBy(vo.getStrApprovedBy());
					formBean.setStrApprovalDate(vo.getStrApprovalDate());
					formBean.setStrAdvanceAdjustedAmt(vo.getStrAdvanceAdjustedAmt());
					formBean.setStrNetcalCost(vo.getStrNetcalCost());
					formBean.setStrRemarks(vo.getStrRemarks());
					formBean.setStrBillNo(vo.getStrBillNo());
					formBean.setStrBillDate(vo.getStrBillDate());
					formBean.setStrBillAmt(vo.getStrBillAmt());
					formBean.setStrScheduleDtl(strScheduleDtl);
					formBean.setStrPoNo(vo.getStrPoNo());
					formBean.setStrPONetAmount(vo.getStrPONetAmount());
					formBean.setStrAgentName(vo.getStrAgentName());
					formBean.setStrCAName(vo.getStrCAName());
					if(formBean.getStrAgentName().trim().equals("0"))
					  formBean.setStrAgentNameShow("0");
					else
					  formBean.setStrAgentNameShow("1");	
					formBean.setCombo(request.getParameterValues("combo"));
			}
			
			
		
						
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "BillApprovalViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalViewTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	

}
