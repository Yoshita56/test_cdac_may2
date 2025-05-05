package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.IssueSampleForQcCheckTransBO;
import mms.transactions.bo.SampleSentTransBO;
import mms.transactions.controller.fb.IssueSampleForQcCheckTransFB;
import mms.transactions.controller.fb.SampleSentTransFB;
import mms.transactions.controller.hlp.IssueSampleForQcCheckTransHLP;
import mms.transactions.vo.IssueSampleForQcCheckTransVO;
import mms.transactions.vo.SampleSentTransVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 11-Jan-2012
 * Modification Date: 
 *  
*/
public class IssueSampleForQcCheckTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(IssueSampleForQcCheckTransFB issueSampleForQcCheckTransFB_p,HttpServletRequest request) 
	{
		/* Declaring Variable */
		
		String strmsgText = "";
		String    hosCode = "";
		HisUtil   hisUtil = null;
	    String     seatId = "";
	    IssueSampleForQcCheckTransBO bo = null;
		IssueSampleForQcCheckTransVO vo = null;
		MmsConfigUtil   mmscofigutil = null;
			
		
		try 
		{
			/* Creating Object */
			
					     bo = new IssueSampleForQcCheckTransBO();
					     vo = new IssueSampleForQcCheckTransVO();
					hisUtil = new HisUtil("MMS", "IssueSampleForQcCheckTransDATA");
			   mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
            /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			issueSampleForQcCheckTransFB_p.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			/* If Avalaible then New Cost Column will be Added */
			issueSampleForQcCheckTransFB_p.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			issueSampleForQcCheckTransFB_p.setStrDemandActivePrd(mmscofigutil.getStrDemandActivePrd());
			
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				issueSampleForQcCheckTransFB_p.setStrIsDemandActiveFlag("1");
			}
			
			
			
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrIssueNo("0");	
			vo.setStrIndentNo("0");
			
			/* Calling IssueSampleForQcCheckTransBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			 issueSampleForQcCheckTransFB_p.setStrStoreName(vo.getStrStoreName());
			 issueSampleForQcCheckTransFB_p.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());	 
			 issueSampleForQcCheckTransFB_p.setStrHospitalCode(hosCode);
			 issueSampleForQcCheckTransFB_p.setStrSeatId(seatId);
			 issueSampleForQcCheckTransFB_p.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 issueSampleForQcCheckTransFB_p.setStrIndentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 issueSampleForQcCheckTransFB_p.setStrApprovalDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 issueSampleForQcCheckTransFB_p.setStrVerifiedDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 issueSampleForQcCheckTransFB_p.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			 issueSampleForQcCheckTransFB_p.setStrIndentingStoreID(vo.getStrIndentStoreCombo());
			
			 			 
		}
		  catch (Exception e) 
		  {
           e.printStackTrace();
			strmsgText = "IssueSampleForQcCheckTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueSampleForQcCheckTransDATA->GetData()", strmsgText);
			issueSampleForQcCheckTransFB_p.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * GetStoreBudget(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Indenting Store Budget
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void GetStoreBudget(HttpServletRequest request, HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil   hisutil = null;
		   String strCurrentDate;
			int strCurrentMonth;
			int CURRENT_YEAR;
			String strFinancialStartDate;
			String strFinancialEndDate;	
		try
		{  
			     vo = new IssueSampleForQcCheckTransVO();
		         bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
		     strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrIndentingStoreID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
            strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			  
			vo.setStrFinancialEndDate(strFinancialEndDate);
			vo.setStrFinancialStartDate(strFinancialStartDate);
		    /* Call BO Approve & Verify COMBO Method */
			bo.GetStoreBudget(vo);
		    /* ItemCategory Combo */
			
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrAvalaibleBudget()+"##"+vo.getStrAvalaibleBudgetDtl();
			 	response.getWriter().print(strRes);
			 		 
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->GetStoreBudget()", strmsgText);
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
	public static void getHQNameStoreCombo(HttpServletRequest request, HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new IssueSampleForQcCheckTransVO();
		         bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
		     strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrIndentingStoreID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO Indenting Store Combo Method */
			bo.getHQNameStoreCombo(vo);
		    /* Indent Store Combo */
			if(vo.getStrIndentStoreCombo()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrIndentStoreCombo();
			 	response.getWriter().print(strRes);
			}
			else
			{
			    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	}
	    }
		catch (Exception e)
		{
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void ApprovedVerifyCombo(HttpServletRequest request, HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new IssueSampleForQcCheckTransVO();
		         bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
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
			 	//strRes = vo.getStrApprovedBy()+"@"+vo.getStrVerifiedByValues();
			 	strRes = vo.getStrVerifiedByValues();
			 	response.getWriter().print(strRes);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->IndentingStoreCombo()", strmsgText);
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
	 * PendingDemandDetails(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Item Category Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void PendingDemandDetails(HttpServletRequest request, HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil   hisutil = null;
		   String strPendingDemand= null;
		try
		{  
			     vo = new IssueSampleForQcCheckTransVO();
		         bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
		     strChk = request.getParameter("modName");  //Main Store ID ^ Category ID ^ Indenting Store Id
		     vo.setStrStoreId(strChk.split("\\^")[0]);
		    vo.setStrItemCagID(strChk.split("\\^")[1]);
		    vo.setStrIndentingStoreID(strChk.split("\\^")[2]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO  Method */
			bo.PendingDemand(vo);
		    
		    	strPendingDemand = IssueSampleForQcCheckTransHLP.getPendingDemands(vo.getPendingDemandWS());
		    	
		    
			
				
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = strPendingDemand;
			 	response.getWriter().print(strRes);
			 		
			
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->PendingDemandDetails()", strmsgText);
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
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new IssueSampleForQcCheckTransVO();
		         bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
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
			    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->ItemCatgoryCombo()", strmsgText);
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
	 * ApprovedByCombo(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Approved By Combo 
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */
	public static void ApprovedByCombo(HttpServletRequest request,
			HttpServletResponse response, IssueSampleForQcCheckTransFB formBean) {
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk = null;
		   String strRes = null;
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
		    vo = new IssueSampleForQcCheckTransVO();
	        bo = new IssueSampleForQcCheckTransBO();
		    hisutil = new HisUtil("transaction", "IssueSampleForQcCheckTransDATA");
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
			    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->ApprovedByCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->ApprovedByCombo()", strmsgText);
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
	 * @param issueSampleForQcCheckTransFB
	 * @param request
	 */
	public static void initViewPageDtl(IssueSampleForQcCheckTransFB issueSampleForQcCheckTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   HisUtil hisUtil;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "IssueSampleForQcCheckTransDATA");
			         vo = new IssueSampleForQcCheckTransVO();
			   	     bo = new IssueSampleForQcCheckTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	issueSampleForQcCheckTransFB.setStrStoreName(vo.getStrStoreName());
			   	issueSampleForQcCheckTransFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	issueSampleForQcCheckTransFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	issueSampleForQcCheckTransFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->initViewPageDtl()", strmsgText);
				issueSampleForQcCheckTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				issueSampleForQcCheckTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	/**
	 * This method will get the values for view page
	 * 
	 * @param request
	 * @param response
	 */

	public static void getPendingIndentDetails(HttpServletRequest request,HttpServletResponse response,IssueSampleForQcCheckTransFB formBean) 
	{

		IssueSampleForQcCheckTransBO bo = null;
		IssueSampleForQcCheckTransVO vo = null;

		String strmsgText = "";
		String strItemDtls = "";
		String strIndentDtls = "";

		try 
		{
			bo = new IssueSampleForQcCheckTransBO();
			vo = new IssueSampleForQcCheckTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			
			/* Value Pass in Mode Name
	    	    1. C.HSTNUM_REQ_NO 
	    	    2. C.HSTNUM_STORE_ID , 
	            3. C.GNUM_HOSPITAL_CODE,
	            4. count_urgent 
	            5. c.URGENT_FLG 
	            6. C.HSTNUM_REQ_NO 
	            7. C.REQ_DATE 
	            8. C.RAISING_STORE 
	            9. C.CATEGORY 
	            10.C.LST_ISSUE_DATE  
	    	 */    	

			String strChk = request.getParameter("modName");
			
			String issueStoreName = request.getParameter("issueStoreName");
			String   strAvlBudget = request.getParameter("avlBudget");
			String     budgetFlag = request.getParameter("budgetFlg");
			
			formBean.setStrStoreId(issueStoreName);
			vo.setStrIssueStoreId(issueStoreName);
            vo.setStrAvalaibleBudget(strAvlBudget);
			String[] temp = strChk.replace("^", "#").split("#");

			formBean.setStrIndentNo(temp[0]);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			
             
			vo.setStrIndentNo(formBean.getStrIndentNo());
			vo.setStrStoreId(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getIndentDetail(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				formBean.setStrIndentNo(vo.getStrIndentNo());
				formBean.setStrIndentDate(vo.getStrIndentDate());
				formBean.setStrIndentType(vo.getStrIndentType());
				formBean.setStrItemCategory(vo.getStrItemCategory());
				formBean.setStrRaisingStoreId(vo.getStrRaisingStoreId());
				formBean.setStrRaisingStoreName(vo.getStrRaisingStoreName());
				formBean.setStrReqStatusName(vo.getStrReqStatusName());

				bo.getItemDetail(vo);
			}
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			else 
			{
				strIndentDtls = IssueSampleForQcCheckTransHLP.getViewItemDetailsTwo(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrStoreId(),vo.getPendingIndentDemandWS(),vo.getStrAvalaibleBudget(),budgetFlag);
				//formBean.setStrViewItemDtls(strItemDtls);
				  strItemDtls = IssueSampleForQcCheckTransHLP.getExistingItemDetails(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrStoreId(),budgetFlag);
								
				if(strIndentDtls!= null && !strIndentDtls.equals("") && strItemDtls!= null && !strItemDtls.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strIndentDtls+"$$$$$$"+strItemDtls);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->getPendingIndentDetails()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
				
			}
			if (strItemDtls.equals("ERROR")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

		}
		catch (Exception e)
		{
        
			strmsgText = "Issue Desk.IssueSampleForQcCheckTransDATA.getPendingIndentDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"IssueSampleForQcCheckTransDATA->getPendingIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param issueSampleForQcCheckTransFB
	 * @param request
	 */
	public static void getViewDtl(IssueSampleForQcCheckTransFB issueSampleForQcCheckTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueSampleForQcCheckTransVO vo = null;
		   IssueSampleForQcCheckTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueSampleForQcCheckTransVO();
			   	bo=new IssueSampleForQcCheckTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
			   	vo.setStrSearchNameType(request.getParameter("searchType"));				
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			    String strResult = IssueSampleForQcCheckTransHLP.getIssuedDetail(vo);

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueSampleForQcCheckTransDATA->getViewDtl()", strmsgText);
				issueSampleForQcCheckTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				issueSampleForQcCheckTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * This method will get the POPUP info according to the selected Issue No. to
	 * generate a PopUp in HLP
	 * @param IssueSampleForQcCheckTransFB
	 * @param request
	 * @param response
	 */
	public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, IssueSampleForQcCheckTransFB formBean) 
	{
		/* Declaring variables*/
		String strPopUpDtls = null;
		String        index = "";
		String   strmsgText = null;

		IssueSampleForQcCheckTransBO bo = null;
		IssueSampleForQcCheckTransVO vo = null;
		HisUtil   hisutil = null;
		String strIssueNo = "";
		

		try 
		{
			/* Creating Object */
			bo = new IssueSampleForQcCheckTransBO();
			vo = new IssueSampleForQcCheckTransVO();
		
			strIssueNo = (String) request.getParameter("hiddenVal");
			     index = (String) request.getParameter("index");
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		   	vo.setStrStoreName(request.getParameter("storeId"));
		   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
		   	vo.setStrFromDate(request.getParameter("fromDate"));
		   	vo.setStrToDate(request.getParameter("ToDate"));
            vo.setStrIssueNo(strIssueNo);
			// Calling BO Method
			bo.getPopUpInfo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{				
				strPopUpDtls = IssueSampleForQcCheckTransHLP.getPopUpInfo(vo.getPopUpWS(),	index,strIssueNo);
				if (strPopUpDtls.equals("ERROR")) 
				{

					HisException eObj = new HisException("MMS",
							"IssueSampleForQcCheckTransDATA->getPopUp()", strmsgText);
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
					response.getWriter().write(strPopUpDtls);

				}
			}

		}
		catch (Exception e) 
		{
			// //e.printStackTrace();
			strmsgText = "MMS.transactions.IssueSampleForQcCheckTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueSampleForQcCheckTransDATA->getPopUp()", strmsgText);
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

	public static boolean  insertIssueSampleForQcCheck(IssueSampleForQcCheckTransFB formBean,HttpServletRequest request) 
	{
        // Declaring Variables 
		boolean retValue = true;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil hisutil=null;
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		IssueSampleForQcCheckTransBO bo = null;
		IssueSampleForQcCheckTransVO vo = null;
		String strFinancialStartYear = "";
		String strFinancialEndYear   = "";
		
		try 
		{
			 // Creating Object
								 bo = new IssueSampleForQcCheckTransBO();
								 vo = new IssueSampleForQcCheckTransVO();
								mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						    hisutil = new HisUtil("Store Transaction","IssueSampleForQcCheckTransDATA");
			
			  strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			        String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			        String seatid   = request.getSession().getAttribute("SEATID").toString();
			        String ipAddr   = request.getSession().getAttribute("IP_ADDR").toString();
			        vo.setStrIpAddress(ipAddr);
			
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			/*formBean.setStrBudgetFlg(mcu.getStrBudgetFlg());
			
			if(!mcu.getStrDemandActivePrd().equals("0"))
			{	
			 formBean.setStrIsDemandActiveFlag("1");
			}
			vo.setStrBudgetFlg(mcu.getStrBudgetFlg());*/
			/*******************************************************************/
								
			       strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			       vo.setStrCurrentDate(strCurrentDate);
						
			       strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			 strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			   strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			  
			vo.setStrFinancialEndDate(strFinancialEndDate);
			vo.setStrFinancialStartDate(strFinancialStartDate);
			
			/** Here We Set Item Related Details **/
			vo.setStrIssueQty(formBean.getStrIssueQty());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setItemParamValue(formBean.getItemParamValue());
			
//			vo.setStrCost(formBean.getStrCost());  // Per Item Cost
			
			
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
//			vo.setStrApprovedBy(formBean.getStrApprovedBy());
//			vo.setStrVerifiedByValues(formBean.getStrVerifiedBy());
//			vo.setStrApprovedDate(formBean.getStrApprovalDate());
//			vo.setStrVerifiedDate(formBean.getStrVerifiedDate());
//			vo.setStrReceivedBy(formBean.getStrReceivedBy());
			vo.setStrAprovedRemarks(formBean.getStrAprovedRemarks());
	
			vo.setStrStoreName(formBean.getStrStoreName());	// Here We pass Store Id of DDW(District Drug Warehouse)
			vo.setStrItemCategoryCmb(formBean.getStrItemCatgCombo());
			vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID());// Here by Indenting Store we mean HQ Name 	

			vo.setStrIsReIssue( (formBean.getStrReIssueFlag()==null || formBean.getStrReIssueFlag().equals("") ) ? "0" : formBean.getStrReIssueFlag()); 
			vo.setStrIssueDate( formBean.getStrIssueDate()); 

			vo.setStrRemarks(formBean.getStrRemarks());
		
			vo.setStrIssuingStoreId(formBean.getStrTmpIssuingStoreId());
			vo.setStrRaisingStoreId(formBean.getStrTmpRaisingStoreId());
			vo.setStrUnitName(formBean.getStrUnitName());
			
	        // Calling BO method
			bo.insertIssueSampleForQcCheck(vo);
           		
				
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
			        formBean.setStrMsg("Data Has been Successfully Saved");
					formBean.setStrTmpStoreNo(vo.getStrStoreName());
				}   
			 
			
			
		
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "IssueSampleForQcCheckTransDATA.insertIssueSampleForQcCheck(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueSampleForQcCheckTransDATA->InsertOffLineforNewDemand()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
    return retValue;
	}

	
	
	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */
	
	public static boolean  cancelRecords(IssueSampleForQcCheckTransFB formBean)
	{
		IssueSampleForQcCheckTransBO bo = null;
		IssueSampleForQcCheckTransVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

        String strFinancialStartYear = "";

        String strFinancialEndYear = "";
        boolean retValue = true;
      
		try 
		{
								  bo = new IssueSampleForQcCheckTransBO();
								  vo = new IssueSampleForQcCheckTransVO();
	         
	    	String           hosCode = formBean.getStrHospitalCode();
			String           seatid  = formBean.getStrSeatId();
								mcu  = new MmsConfigUtil(hosCode);
//			for(int i=0;i<formBean.getChkFlg().length;i++)
//			{
//				if(formBean.getChkFlg()[i].equals("1"))
//				{
//					//System.out.println("Hidden Value==>"+formBean.getStrCheckHidValue()[i]);
//				}
//			}
			  
			vo.setChkFlg(formBean.getChkFlg());				
			vo.setStrCheckHidValue(formBean.getStrCheckHidValue());
		    vo.setStrFinancialEndYear(strFinancialEndYear);
            vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreName());
			vo.setStrItemCategory(formBean.getStrItemCatgCombo());
			vo.setStrRemarks(formBean.getStrRemarks());
            bo.CANCELRECORDS(vo);
			
			//formBean.setStrHiddenBatchDtl(vo.getStrHiddenBatchDtl());
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;    			
    			formBean.setStrErr(vo.getStrMsgString());
				throw new Exception(vo.getStrMsgString());
						
				
			}
        	else 
			{

        		formBean.setStrMsg("Record Cancel Successfully!!");
    		
			}
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
            retValue = false;
			strmsgText = "IssueSampleForQcCheckTransDATA.CANCELRECORDS(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueSampleForQcCheckTransDATA->CANCELRECORDS()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	
	
	
	

}
