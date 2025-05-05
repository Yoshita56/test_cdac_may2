package mms.transactions.controller.data;

import java.util.ResourceBundle;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.OfflineReturnTransBO;
import mms.transactions.controller.fb.OfflineReturnTransFB;
import mms.transactions.controller.hlp.OfflineReturnTransHLP;
import mms.transactions.vo.OfflineReturnTransVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify: 
*/
public class OfflineReturnTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(OfflineReturnTransFB _OfflineIssueIndentFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		OfflineReturnTransBO bo = null;
		OfflineReturnTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil hisUtil=null;

		String seatId = "";

		
		try 
		{
			/* Creating Object */
			
			bo = new OfflineReturnTransBO();
			vo = new OfflineReturnTransVO();
			hisUtil=new HisUtil("MMS", "OfflineIssueIndentDATA");
			
            /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			
			
			
			/* Calling OfflineIssueIndentBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
				
			 _OfflineIssueIndentFB.setStrStoreName(vo.getStrStoreName());
			 _OfflineIssueIndentFB.setStrHospitalCode(hosCode);
			 _OfflineIssueIndentFB.setStrSeatId(seatId);
			 _OfflineIssueIndentFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrIndentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrApprovalDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrVerifiedDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrBudgetFlg("1");
			 _OfflineIssueIndentFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			 
			 ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			
			_OfflineIssueIndentFB.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			 
			 			 
		}
		  catch (Exception e) 
		  {
           e.printStackTrace();
			strmsgText = "OfflineIssueIndentDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineIssueIndentsDATA->GetData()", strmsgText);
			_OfflineIssueIndentFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
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
			HttpServletResponse response, OfflineReturnTransFB formBean) {
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk = null;
		   String strRes = null;
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
		    vo = new OfflineReturnTransVO();
	        bo = new OfflineReturnTransBO();
		    hisutil = new HisUtil("transaction", "OfflineReturnTransDATA");
		    strChk = request.getParameter("modName");
		   
		    vo.setStrStoreId(strChk);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO APPROVEDBYCOMBO Method */
			bo.ApprovedByCombo(vo);
		    /* ApprovedBy Combo */
			
			if(vo.getStrApprovedBy()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrApprovedBy();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->ApprovedByCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->ApprovedByCombo()", strmsgText);
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
	 * getStrIndentStoreCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Item Category Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void IndentingStoreCombo(HttpServletRequest request, HttpServletResponse response,OfflineReturnTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk =null;
		   String strRes = null;
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			vo = new OfflineReturnTransVO();
		    bo = new OfflineReturnTransBO();
		    hisutil = new HisUtil("transaction", "OfflineReturnTransDATA");
		    strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrItemCagID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO ITEMCATEGORYCOMBO Method */
			bo.IndentingStoreCombo(vo);
		    /* ItemCategory Combo */
			
			if(vo.getStrIndentStoreCombo()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrIndentStoreCombo();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->IndentingStoreCombo()", strmsgText);
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
	 * ApprovedVerifyCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for ApprovedVerifyCombo Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void ApprovedVerifyCombo(HttpServletRequest request, HttpServletResponse response,OfflineReturnTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk =null;
		   String strRes = null;
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			vo = new OfflineReturnTransVO();
		    bo = new OfflineReturnTransBO();
		    hisutil = new HisUtil("transaction", "OfflineReturnTransDATA");
		    strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrIndentingStoreID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO Approve & Verify COMBO Method */
			bo.ApprovedVerifyCombo(vo);
		    /* ItemCategory Combo */
			
			if(vo.getStrApprovedBy()!= null || vo.getStrVerifiedByValues()!=null )
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrApprovedBy()+"@"+vo.getStrVerifiedByValues();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,OfflineReturnTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk =null;
		   String strRes = null;
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			vo = new OfflineReturnTransVO();
		    bo = new OfflineReturnTransBO();
		    hisutil = new HisUtil("transaction", "OfflineReturnTransDATA");
		    strChk = request.getParameter("modName");
		    vo.setStrStoreId(strChk);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO ITEMCATEGORYCOMBO Method */
			bo.ItemCatgoryCombo(vo);
		    /* ItemCategory Combo */
			
			if(vo.getStrItemCategoryCmb()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrItemCategoryCmb();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->ItemCatgoryCombo()", strmsgText);
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
	public static void initViewPageDtl(OfflineReturnTransFB _OfflineReturnTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   HisUtil hisUtil;
		   try{
			    hisUtil=new HisUtil("MMS", "OfflineIssueIndentDATA");
			    vo=new OfflineReturnTransVO();
			   	bo=new OfflineReturnTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	
			   	bo.initForViewPage(vo);
			   
			   	_OfflineReturnTransFB.setStrStoreName(vo.getStrStoreName());
			   	_OfflineReturnTransFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_OfflineReturnTransFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_OfflineReturnTransFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->initViewPageDtl()", strmsgText);
				_OfflineReturnTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OfflineReturnTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _OfflineReturnTransFB
	 * @param request
	 */
	public static void getViewDtl(OfflineReturnTransFB _OfflineReturnTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OfflineReturnTransVO vo = null;
		   OfflineReturnTransBO bo = null;
		   try{
			   	
			    vo=new OfflineReturnTransVO();
			   	bo=new OfflineReturnTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	
			    bo.setViewPageDtl(vo);
			    
			    String strResult = OfflineReturnTransHLP.getReturnDetail(vo.getReturnItemWs());
			    if (strResult.equals("ERROR")) 
				{

					HisException eObj = new HisException("MMS",
							"OfflineReturnTransDATA->getViewDtl()->getReturnDetail()[HLP Method]", strmsgText);
					strmsgText = "ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ";
					eObj = null;
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strmsgText);
					throw new Exception(vo.getStrMsgString());
				}
				else 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strResult);

				}
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineReturnTransDATA->getViewDtl()", strmsgText);
				_OfflineReturnTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OfflineReturnTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This method will get the POPUP info according to the selected Bill No. to
	 * generate a PopUp in HLP
	 * 
	 * @param request
	 * @param response
	 */
	public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, OfflineReturnTransFB formBean) {
		String strPopUpDtls = null;
		String index = "";
		String strmsgText = null;

		OfflineReturnTransBO bo = null;
		OfflineReturnTransVO vo = null;
		HisUtil hisutil = null;


		String strReturnNo = "";
		

		try 
		{
			
			          bo = new OfflineReturnTransBO();
			          vo = new OfflineReturnTransVO();
			 strReturnNo = (String) request.getParameter("hiddenVal");
		           index = (String) request.getParameter("index");
		          
			 vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		     vo.setStrStoreName(request.getParameter("storeId"));
		   	 vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
		   	 vo.setStrFromDate(request.getParameter("fromDate"));
		   	 vo.setStrToDate(request.getParameter("ToDate"));
	         vo.setStrReturnNo(strReturnNo);

			index = (String) request.getParameter("index");
			// Calling BO Method
			bo.getPopUpInfo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{		
				strPopUpDtls = OfflineReturnTransHLP.getPopUpInfo(vo.getPopUpWS(),	index,strReturnNo);
				if (strPopUpDtls.equals("ERROR")) 
				{

					HisException eObj = new HisException("MMS",
							"OfflineReturnTransDATA->getPopUp()", strmsgText);
					strmsgText = "ERROR####Application Error [ERROR ID : "	+ eObj.getErrorID()
							+ "],Contact System Administrator! ";
					eObj = null;
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strmsgText);
					throw new Exception(vo.getStrMsgString());
				}
				else 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(strPopUpDtls);

				}
			}

		}
		catch (Exception e) 
		{
			
			strmsgText = "MMS.transactions.OfflineReturnTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineReturnTransDATA->getPopUp()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;

		} finally {
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			if (hisutil != null)
				hisutil = null;
		}

	}

	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean  insertData(OfflineReturnTransFB formBean,HttpServletRequest request) 
	{
        // Declaring Variables 
		OfflineReturnTransBO bo = null;
		OfflineReturnTransVO vo = null;
		boolean retValue = true;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		try 
		{
			 // Creating Object
			bo = new OfflineReturnTransBO();
			vo = new OfflineReturnTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid   = request.getSession().getAttribute("SEATID").toString();
			
			vo.setStrReturnQty(formBean.getStrReturnQty());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrApprovedBy(formBean.getStrApprovedBy());
			vo.setStrVerifiedByValues(formBean.getStrVerifiedBy());
			vo.setStrApprovedDate(formBean.getStrApprovalDate());
			vo.setStrVerifiedDate(formBean.getStrVerifiedDate());
			vo.setStrReceivedBy(formBean.getStrReceivedBy());
			vo.setStrAprovedRemarks(formBean.getStrAprovedRemarks());
			vo.setStrStoreName(formBean.getStrStoreName());
			vo.setStrItemCategoryCmb(formBean.getStrItemCatgCombo());
			vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID());
			vo.setStrIndentType(formBean.getStrIndentType());
			vo.setIsNormal(formBean.getIsNormal());
			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			vo.setStrIndentNo(formBean.getStrIndentNo());
			vo.setStrIndentDate(formBean.getStrIndentDate());
			vo.setStrAvlQty(formBean.getStrAvlQty());
			
			vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID());
			vo.setStrNewDemandFinalApproxAmt(formBean.getStrNewDemandFinalApproxAmt());
			////System.out.println("getStrReqQty"+formBean.getStrReqQty());
			////System.out.println("getStrReturnQty"+formBean.getStrReturnQty());
			////System.out.println(""+ formBean.getStrCost());
			////System.out.println(""+formBean.getStrTotalCost());
			
	        // Calling BO method
			bo.insertData(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
			
				throw new Exception(vo.getStrMsgString());
		} 
		else 
		{			
			
			formBean.setStrMsg("Data Saved Successfully");
			formBean.setStrIndentNo(vo.getStrIndentNo());
			formBean.setStrReturnNo(vo.getStrReturnNo());
			formBean.setStrIndentDate(vo.getStrIndentDate());
			formBean.setStrTmpStoreNo(vo.getStrIndentingStoreID());
		}
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "OfflineReturnTransDATA.insertData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineReturnTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
    return retValue;
	}
	
	

}

