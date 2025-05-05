			/******************************************************************************************
			 *                                Process Name : Item Transfer                            *
			 ******************************************************************************************
			 * File Name       : ItemTransferTransDATA.java                                           *
			 * Module Name     : MMS                                                                  *
			 * Developer       : Deepak Tiwari                                                        * 
			 * Version         : 1.0                                                                  * 
			 * Assigned Date   : 1-May-2009                                                           *                                               
			 * Completion Date : 3-May-2009                                                           *
			 * Assigned By     : Ajay Kr. Gupta                                                       *
			 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
			 * Hand over date  : 30-May-2009                                                          *
			 ******************************************************************************************
			 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
			 ******************************************************************************************/


package mms.transactions.controller.data;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.ItemTransferTransBO;
import mms.transactions.controller.fb.ItemTransferTransFB;
import mms.transactions.controller.hlp.ItemTransferTransHLP;
import mms.transactions.vo.ItemTransferTransVO;

public class ItemTransferTransDATA 
{
	
/**
 * <p>Method::GetData is Used to populate the initial data on the JSP Page.
 * <p>Invoked At the time of body on load of Item Transfer Transaction 
 * @param <ItemTransferTransFB>formBean
 * @param <HttpServletRequest>request
 */
	public static void GetData(ItemTransferTransFB formBean,HttpServletRequest request) 
	{
		ItemTransferTransBO bo = null;
		ItemTransferTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil=null;
		String strReceivedByOptionVal="";
		MmsConfigUtil mcf=null;
		String strCostRequired="";
		try 
		{
			bo = new ItemTransferTransBO();
			vo = new ItemTransferTransVO();
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
					   mcf = new MmsConfigUtil(hosCode);
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			hisutil = new HisUtil("transaction", "ItemTransferTransDATA");
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			strCostRequired=mcf.getStrCostReq();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			bo.GetData(vo);
			bo.ITEMCATCOMBO(vo);
			String strCmb="";
			if(vo.getStrItemCategoryComboWS() !=null && vo.getStrItemCategoryComboWS().size() > 0)
			{			
				strCmb = hisutil.getOptionValue(vo.getStrItemCategoryComboWS(),"0", "Select Value", true);
			}
			else
			{
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(strCmb);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}else{
				formBean.setStrStoreName(vo.getStrStoreName());
				formBean.setStrCostRequired("1");
				if(vo.getRecievedByWS()!=null){
					strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
					strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
				}else{
					strReceivedByOptionVal="<option value='0'>Select Value</option>";
				}
				
				formBean.setStrReceivedByOptionVal(strReceivedByOptionVal);
			}
			
		}
		catch (Exception e) 
		{
			strmsgText = "ItemTransferTransDATA.GetData(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","ItemTransferTransDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcf = null;
		}

	}
	

/**
 * <p>Method::INSERT is Used to populate the initial data on the JSP Page.
 * <p>Invoked At the time of body on load of Item Transfer Transaction 
 * @param <ItemTransferTransFB>formBean
 * @param <HttpServletRequest>request
 */
	public static void INSERT(ItemTransferTransFB formBean,HttpServletRequest request) 
	{
		ItemTransferTransBO bo = null;
		ItemTransferTransVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		String tmp[]=null;
		/*  
         String strFinancialStartYear = "";
         String strFinancialEndYear = "";
		 */
		try 
		{
			bo = new ItemTransferTransBO();
			vo = new ItemTransferTransVO();

				//Should be enabled later when MMSConfig Util error is resolved
		    

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid  = request.getSession().getAttribute("SEATID").toString();
					  mcu  = new MmsConfigUtil(hosCode);

		 

			vo = (ItemTransferTransVO)TransferObjectFactory.populateData("mms.transactions.vo.ItemTransferTransVO",formBean);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			tmp=formBean.getStrToStoreName().replace('^', '#').split("#");
			vo.setStrToStoreId(tmp[0]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		//	vo.setStrFinancialStartYear("01-Apr-2009");//mcu.getStrFinancialStartDate());
		//	vo.setStrFinancialEndYear("01-Apr-2010");//mcu.getStrFinancialEndDate());
			vo.setStrFinancialStartYear(mcu.getStrFinancialStartDate(vo.getStrToStoreId(),vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mcu.getStrFinancialEndDate(vo.getStrToStoreId(),vo.getStrHospitalCode()));
	
			vo.setItemUserValue(formBean.getItemUserValue());
            vo.setStrDwhName(formBean.getStrDwhName());
			bo.INSERT(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				if(vo.getStrMsgString().split("\\##")[2].equals("999"))
			    {
    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
				    formBean.setStrErrMsg(vo.getStrMsgString().split("\\##")[1]);
			    }
				else
				{
					formBean.setStrErrMsg(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
				}		
			}
			else 
			{
				formBean.setStrDwhName(vo.getStrDwhName());
				formBean.setStrTmpTransferNo(vo.getStrTransferNo());
				formBean.setStrTmpStoreNo(vo.getStrStoreName());
				formBean.setStrTmpTransferDate(vo.getStrCtDate());
				formBean.setStrMsg("Item Transfer Details Saved Successfully");
			}

		}
		catch (Exception e) 
		{
			strmsgText = "ItemTransferTransDATA.INSERT(vo) -->"+ e.getMessage();
			HisException eObj = new HisException("mms","ItemTransferTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	
/**
 * <p>Method::GRPNAMECOMBO is Used to populate the GROUP Name Combo on the JSP Page.
 * <p>Invoked At the time of onChange of Item Category Combo through AJAX 
 * @param <ItemTransferTransFB>formBean
 * @param <HttpServletRequest>request
 */
	public static void GRPNAMECOMBO(HttpServletRequest request, HttpServletResponse response,ItemTransferTransFB formBean) 
	{
		String strmsgText = "";
		String strRes = null;
		ItemTransferTransVO vo = null;
		ItemTransferTransBO bo = null;
		HisUtil hisutil = null;
		try
		{  
			vo = new ItemTransferTransVO();
			bo = new ItemTransferTransBO();
			hisutil = new HisUtil("transaction", "ItemTransferTransDATA");
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrItemCatCmb(request.getParameter("itemCatId"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.GRPNAMECOMBO(vo);
			formBean.setStrToStoreName(vo.getStrToStoreName());
			if(vo.getStrGroupIdForItemSearch()!= null)
			{	
				response.setHeader("Cache-Control", "no-cache");
				strRes =vo.getStrToStoreName();
				response.getWriter().print(strRes);
			}
			else
			{
				HisException eObj = new HisException("MMS", "ItemTransferTransDATA->GRPNAMECOMBO()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
			}
		}
		catch (Exception e)
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "ItemTransferTransDATA->GRPNAMECOMBO()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
			if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	
	/**
	 * <p>Method::GRPNAMECOMBO is Used to populate the GROUP Name Combo on the JSP Page.
	 * <p>Invoked At the time of onChange of Item Category Combo through AJAX 
	 * @param <ItemTransferTransFB>formBean
	 * @param <HttpServletRequest>request
	 */
		public static void RECEVBYCMB(HttpServletRequest request, HttpServletResponse response,ItemTransferTransFB formBean) 
		{
			String strmsgText = "";
			ItemTransferTransVO vo = null;
			ItemTransferTransBO bo = null;
			HisUtil hisutil = null;
			String strReceivedByOptionVal;
			try
			{  
				vo = new ItemTransferTransVO();
				bo = new ItemTransferTransBO();
				hisutil = new HisUtil("transaction", "ItemTransferTransDATA");
				vo.setStrToStoreId(request.getParameter("storeId"));
				vo.setStrItemCatCmb(request.getParameter("itemCatId"));
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.RECEVBYCMB(vo);
				
				if(vo.getRecievedByWS()!=null)
				{
					strReceivedByOptionVal = hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
					strReceivedByOptionVal = strReceivedByOptionVal+"<option value='1'>Other</option>";
				}
				else
				{
					strReceivedByOptionVal = "<option value='0'>Select Value</option>";
				}
				if(vo.getStrGroupIdForItemSearch()!= null)
				{	
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strReceivedByOptionVal);
				}
				else
				{
					HisException eObj = new HisException("MMS", "ItemTransferTransDATA->GRPNAMECOMBO()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
				}
			}
			catch (Exception e)
			{
				strmsgText = e.getMessage();
				HisException eObj = new HisException("MMS", "ItemTransferTransDATA->GRPNAMECOMBO()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
			} 
			finally 
			{
				if (vo != null)
					vo = null;
				if(hisutil != null) hisutil = null;
				if (bo != null)
					bo = null;
			}

		}
	
	
	
	
/**
 * <p>Method::ITEMCATCOMBO is Used to populate the ITEM CATEGORY COMBO on the JSP Page.
 * <p>Invoked At the time of on Change of From Store Combo through AJAX 
 * @param <ItemTransferTransFB>formBean
 * @param <HttpServletRequest>request
 * @param <HttpServletResponse>response
 */
	public static void ITEMCATCOMBO(HttpServletRequest request, HttpServletResponse response,ItemTransferTransFB formBean) 
	{
		String strmsgText = "";
		String strCmb = null;
		ItemTransferTransVO vo = null;
		ItemTransferTransBO bo = null;
		HisUtil hisutil = null;
		try
		{  
			vo = new ItemTransferTransVO();
			bo = new ItemTransferTransBO();
			hisutil = new HisUtil("transaction", "ItemTransferTransDATA");
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			bo.ITEMCATCOMBO(vo);
			if(vo.getStrItemCategoryComboWS() !=null && vo.getStrItemCategoryComboWS().size() > 0)
			{			
				strCmb = hisutil.getOptionValue(vo.getStrItemCategoryComboWS(),"0", "Select Value", true);
			}
			else
			{
				strCmb = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);

		}
		catch (Exception e)
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "ItemTransferTransDATA->ITEMCATCOMBO()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
			if (vo != null)
				vo = null;
			if(hisutil != null) hisutil = null;
			if (bo != null)
				bo = null;
		}

	}
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void initViewPageDtl(ItemTransferTransFB _ItemTransferTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   ItemTransferTransVO vo = null;
		   ItemTransferTransBO bo = null;
		   try{
			   	
			    vo=new ItemTransferTransVO();
			   	bo=new ItemTransferTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	
			   	bo.initForViewPage(vo);
			   
			   	_ItemTransferTransFB.setStrStoreName(vo.getStrStoreName());
			   	
			   //	bo.ITEMCATEGORYCOMBO(vo);
			   	
				 _ItemTransferTransFB.setStrStoreName(vo.getStrStoreName());
				 _ItemTransferTransFB.setStrHospitalCode(vo.getStrHospitalCode());
				 _ItemTransferTransFB.setStrSeatId(vo.getStrSeatId());
				 //_ItemTransferTransFB.setStrItemCatgCombo(vo.getStrItemCatgCombo());
					 
			   	
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ItemTransferTransDATA->initViewPageDtl()", strmsgText);
				_ItemTransferTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_ItemTransferTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void getTransferDtl(ItemTransferTransFB _ItemTransferTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   ItemTransferTransVO vo = null;
		   ItemTransferTransBO bo = null;
		   String strResult = "A";
		   try{
			   	
			    vo=new ItemTransferTransVO();
			   	bo=new ItemTransferTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrTransferNo(request.getParameter("transferNo"));
			   	vo.setStrTransferDate(request.getParameter("transferDate"));
			   	
			   	bo.getTransferDtl(vo);
			   
			    strResult=ItemTransferTransHLP.getTransferDetails(vo.getTransferDtlWs(),request.getParameter("dwhName"), request);
			    if(strResult!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "ItemTransferTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ItemTransferTransDATA->getViewDtl()", strmsgText);
				_ItemTransferTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_ItemTransferTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void getViewDtl(ItemTransferTransFB _ItemTransferTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   ItemTransferTransVO vo = null;
		   ItemTransferTransBO bo = null;
		   String strResult = "A";
		   try{
			   	
			    vo=new ItemTransferTransVO();
			   	bo=new ItemTransferTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	//vo.setStrItemCatgCombo(request.getParameter("itemCatNo"));
			   	//vo.setStrFromDate(request.getParameter("startDate"));
			   	//vo.setStrToDate(request.getParameter("endDate"));
			   	bo.setViewPageDtl(vo);
			   
			  //  strResult=ItemTransferTransHLP.getBreakageDetails(vo.getBreakageItemWS() , vo.getStrStoreName() , vo.getStrHospitalCode());
			    if(strResult!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "ItemTransferTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "ItemTransferTransDATA->getViewDtl()", strmsgText);
				_ItemTransferTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_ItemTransferTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
}
