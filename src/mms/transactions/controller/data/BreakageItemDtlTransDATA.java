/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
 *  
*/

package mms.transactions.controller.data;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.BreakageItemDtlTransBO;
import mms.transactions.controller.fb.BreakageItemDtlTransFB;
import mms.transactions.controller.hlp.BreakageItemDtlTransHLP;
import mms.transactions.vo.BreakageItemDtlTransVO;

public class BreakageItemDtlTransDATA 
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(BreakageItemDtlTransFB _BreakageItemDtlTransFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		BreakageItemDtlTransBO bo = null;
		BreakageItemDtlTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;
		String seatId = "";
		MmsConfigUtil mmsConfig=null;
		String strCostRequired="";
		try 
		{
			/* Creating Object */
			
			bo = new BreakageItemDtlTransBO();
			vo = new BreakageItemDtlTransVO();
			hisUtil=new HisUtil("MMSModule", "BreakageItemDtlTransDATA");
            /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
			mmsConfig=new MmsConfigUtil(hosCode);
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			//strCostRequired=mmsConfig.getStrCostReq();    // Please Check It
			
			strCostRequired="1";
			////System.out.println("strCostRequired"+strCostRequired);
			/* Calling BreakageItemDtlTransBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
				bo.ITEMCATEGORYCOMBO(vo);
			 _BreakageItemDtlTransFB.setStrStoreName(vo.getStrStoreName());
			 _BreakageItemDtlTransFB.setStrHospitalCode(hosCode);
			 _BreakageItemDtlTransFB.setStrSeatId(seatId);
			
			 _BreakageItemDtlTransFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _BreakageItemDtlTransFB.setStrCostRequired(strCostRequired);
			 if(_BreakageItemDtlTransFB.getStrSaveFlg().equalsIgnoreCase("1"))
				{
					//_BreakageItemDtlTransFB.setStrMsg("Breakage Item Saved Successfully");	
					_BreakageItemDtlTransFB.setStrWarning("Record Saved Successfully");
				}
			
		}
		
		  catch (Exception e) 
		  {
           
			strmsgText = "BreakgeItemDtlTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BreakgeItemDtlTransDATA->GetData()", strmsgText);
			_BreakageItemDtlTransFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */
	
	public static void INSERT(BreakageItemDtlTransFB _BreakageItemDtlTransFB,HttpServletRequest request) 
	{
		/* Declaring Variable */ 
		BreakageItemDtlTransBO bo = null;
		BreakageItemDtlTransVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil util = null;
		String strCtDate = null;
		String hosCode =  "";
		String seatid  = "";
        String strFinancialStartYear = "";
        String strFinancialEndYear = "";
      
		try 
		{
			/* Creating Object */ 
			bo = new BreakageItemDtlTransBO();
			vo = new BreakageItemDtlTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			util = new HisUtil("BreakageItemDtlTransDATA", "BreakageItemDtlTransDATA");
		    strCtDate = util.getASDate("dd-MMM-yyyy");
		    /* Getting Value from MMSConfig file */
		  
	         
	    	hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid  = request.getSession().getAttribute("SEATID").toString();
			
			
			 
	       	
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			vo.setStrItemCatgCombo(_BreakageItemDtlTransFB.getStrItemCatgCombo());
			
			vo.setItemParamValue(_BreakageItemDtlTransFB.getItemParamValue());
			vo.setStrBkgEntryDate(strCtDate);
			vo.setStrBkgQty(_BreakageItemDtlTransFB.getStrBkgQty());
			vo.setStrUnitName(_BreakageItemDtlTransFB.getStrUnitName());
			vo.setStrRemarks(_BreakageItemDtlTransFB.getStrRemarks());
			vo.setStrStoreName(_BreakageItemDtlTransFB.getStrStoreName());
			
			//System.out.println("in1");
			 strFinancialStartYear = mcu.getStrFinancialStartDate(vo.getStrStoreName() , vo.getStrHospitalCode());
	            strFinancialEndYear   = mcu.getStrFinancialEndDate(vo.getStrStoreName() , vo.getStrHospitalCode());
			
			vo.setStrFinancialEndYear(strFinancialEndYear);
			
			vo.setStrFinancialStartYear(strFinancialStartYear);
			
			vo.setStrApprovedBy(_BreakageItemDtlTransFB.getStrApprovedBy());
			vo.setStrApprovedDate(_BreakageItemDtlTransFB.getStrApprovedDate());
			vo.setStrAprovedRemarks(_BreakageItemDtlTransFB.getStrAprovedRemarks());
			vo.setStrCostFinal(_BreakageItemDtlTransFB.getStrCostFinal());
			vo.setStrApproxAmt(_BreakageItemDtlTransFB.getStrApproxAmt());
			vo.setStrTypeMode(_BreakageItemDtlTransFB.getStrTypeMode());
			//System.out.println("in222222222"+_BreakageItemDtlTransFB.getStrBreakageMode());
			//strBreakageMode
			vo.setStrBreakageMode(_BreakageItemDtlTransFB.getStrBreakageMode());
			/* Calling BreakageItemDtlTransBO method  */			
		    bo.INSERT(vo);  
		    //System.out.println("in3");
    		if (vo.getStrMsgType().equals("1")) 
			{
    			//System.out.println("in4");
    			if(vo.getStrMsgString().split("\\##")[2].equals("999"))
			    {
    				//System.out.println("in5");
    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
    				_BreakageItemDtlTransFB.setStrErr(vo.getStrMsgString().split("\\##")[1]);
			    }
				else
				{
					_BreakageItemDtlTransFB.setStrErr(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
				}	
			}
        	else 
			{
        		
        		_BreakageItemDtlTransFB.setStrSaveFlg("1");
        		_BreakageItemDtlTransFB.setStrMsg("Record Saved Successfully");
        		_BreakageItemDtlTransFB.setStrWarning("Record Saved Successfully");
			}
			
		}
		  catch (Exception e) 
		  {
			  
			strmsgText = "BreakgeItemDtlTransDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BreakgeItemDtlTransDATA->INSERT()", strmsgText);
			_BreakageItemDtlTransFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		}
		  finally 
		  {
			bo   = null;
			util = null;
			vo   = null;
		}

	}
   /**
	 * GRPNAMECOMBO(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Group Name Combo on the basis of
	 * Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void GRPNAMECOMBO(HttpServletRequest request, HttpServletResponse response,BreakageItemDtlTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk =null;
		   String strRes = null;
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			vo = new BreakageItemDtlTransVO();
		    bo = new BreakageItemDtlTransBO();
		    hisutil = new HisUtil("transaction", "BreakageItemDtlTransDATA");
		    strChk = request.getParameter("modName");
		    vo.setStrItemCatNo(strChk);
		    vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO TariffCombo Method  */
			bo.GRPNAMECOMBO(vo);
		    /* Group Id for Item Search Combo  */
			if(vo.getStrGroupIdForItemSearch()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrGroupIdForItemSearch();
			 	response.getWriter().print(strRes);
			 		 
			}
			else
			{
			    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->GRPNAMECOMBO()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	}
	    }
		catch (Exception e)
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->GRPNAMECOMBO()", strmsgText);
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
	 * ItemCatgoryCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Item Category Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,BreakageItemDtlTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk =null;
		   String strRes = null;
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			System.out.println("for local purchase1");
			vo = new BreakageItemDtlTransVO();
		    bo = new BreakageItemDtlTransBO();
		    hisutil = new HisUtil("transaction", "BreakageItemDtlTransDATA");
		    strChk = request.getParameter("modName");
		    vo.setStrStoreId(strChk);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO ITEMCATEGORYCOMBO Method */
			bo.ITEMCATEGORYCOMBO(vo);
		    /* ItemCategory Combo */
			if(vo.getStrItemCatgCombo()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrItemCatgCombo();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->ItemCatgoryCombo()", strmsgText);
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
	public static void initViewPageDtl(BreakageItemDtlTransFB _BreakageItemDtlTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   try{
			   	
			    vo=new BreakageItemDtlTransVO();
			   	bo=new BreakageItemDtlTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	
			   	bo.initForViewPage(vo);
			   
			   	_BreakageItemDtlTransFB.setStrStoreName(vo.getStrStoreName());
			   	
			   	bo.ITEMCATEGORYCOMBO(vo);
			   	
				 _BreakageItemDtlTransFB.setStrStoreName(vo.getStrStoreName());
				 _BreakageItemDtlTransFB.setStrHospitalCode(vo.getStrHospitalCode());
				 _BreakageItemDtlTransFB.setStrSeatId(vo.getStrSeatId());
				 _BreakageItemDtlTransFB.setStrItemCatgCombo(vo.getStrItemCatgCombo());
					 
			   	
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->initViewPageDtl()", strmsgText);
				_BreakageItemDtlTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_BreakageItemDtlTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void getViewDtl(BreakageItemDtlTransFB _BreakageItemDtlTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   try{
			   	
			    vo=new BreakageItemDtlTransVO();
			   	bo=new BreakageItemDtlTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCatgCombo(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("startDate"));
			   	vo.setStrToDate(request.getParameter("endDate"));
			   	bo.setViewPageDtl(vo);
			   
			   String strResult=BreakageItemDtlTransHLP.getBreakageDetails(vo.getBreakageItemWS() , vo.getStrStoreName() , vo.getStrHospitalCode());
			   if(vo.getStrItemCatgCombo()!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", strmsgText);
				_BreakageItemDtlTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_BreakageItemDtlTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	public static void getViewDtlNEW(BreakageItemDtlTransFB _BreakageItemDtlTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   try{
			   	
			    vo=new BreakageItemDtlTransVO();
			   	bo=new BreakageItemDtlTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCatgCombo(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("startDate"));
			   	vo.setStrToDate(request.getParameter("endDate"));
			   	bo.setViewPageDtl(vo);
			   
			   String strResult=BreakageItemDtlTransHLP.getBreakageDetailsNEW(vo.getBreakageItemWS() , vo.getStrStoreName() , vo.getStrHospitalCode());
			   if(vo.getStrItemCatgCombo()!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->getViewDtl()", strmsgText);
				_BreakageItemDtlTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_BreakageItemDtlTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * ApprovedByCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Approved By Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */
	public static void ApprovedByCombo(HttpServletRequest request,
			HttpServletResponse response, BreakageItemDtlTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk = null;
		   String strRes = null;
		   BreakageItemDtlTransVO vo = null;
		   BreakageItemDtlTransBO bo = null;
		   HisUtil   hisUtil = null;
		   String strCmbVal;
		try
		{  
		    vo = new BreakageItemDtlTransVO();
	        bo = new BreakageItemDtlTransBO();
	        hisUtil = new HisUtil("transaction", "BreakageItemDtlTransDATA");
		    strChk = request.getParameter("modName");
		   
		    vo.setStrStoreId(strChk);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO APPROVEDBYCOMBO Method */
			bo.getApprovedByCombo(vo);
		    /* ApprovedBy Combo */
			
			if(vo.getApprovedByWS().size()!=0)
			{
				strCmbVal=hisUtil.getOptionValue(vo.getApprovedByWS(), "-1","0^Select Value", true);
			}
			else
			{
				strCmbVal="<option value='0'>Select Value</option>";
			}
					
			if(vo.getStrApprovedBy()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = strCmbVal;
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->ApprovedByCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->ApprovedByCombo()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
 		if (vo != null)
				vo = null;
			if(hisUtil != null) hisUtil = null;
			if (bo != null)
				bo = null;
		}
		
	}

}
