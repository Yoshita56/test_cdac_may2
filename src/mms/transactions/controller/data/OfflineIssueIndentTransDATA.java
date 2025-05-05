package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.OfflineIssueIndentTransBO;
import mms.transactions.controller.fb.OfflineIssueIndentTransFB;
import mms.transactions.controller.hlp.OfflineIssueIndentTransHLP;
import mms.transactions.vo.OfflineIssueIndentTransVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify: 
*/
public class OfflineIssueIndentTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(OfflineIssueIndentTransFB _OfflineIssueIndentFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		
		String strmsgText = "";
		String    hosCode = "";
		HisUtil   hisUtil = null;
	    String     seatId = "";
	    OfflineIssueIndentTransBO bo = null;
		OfflineIssueIndentTransVO vo = null;
		MmsConfigUtil   mmscofigutil = null;
			
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		
		try 
		{
			/* Creating Object */
			
					     bo = new OfflineIssueIndentTransBO();
					     vo = new OfflineIssueIndentTransVO();
					hisUtil = new HisUtil("MMS", "OfflineIssueIndentDATA");
			   mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			 //Change Request
	            strCurrentDate  = hisUtil.getASDate("dd-MM-yyyy");

				strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
				
				
				if(strCurrentMonth>=4 )
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
				}
				else
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
				}
								
				/*strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
				
				strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
				  
				vo.setStrFinancialEndDate(strFinancialEndDate);
				vo.setStrFinancialStartDate(strFinancialStartDate);   */
			   
			   
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
			
			_OfflineIssueIndentFB.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			/* If Avalaible then New Cost Column will be Added */
			_OfflineIssueIndentFB.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			_OfflineIssueIndentFB.setStrDemandActivePrd(mmscofigutil.getStrDemandActivePrd());
			
			/*if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				_OfflineIssueIndentFB.setStrIsDemandActiveFlag("1");
			}*/
			
			
			
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrIssueNo("0");	
			vo.setStrIndentNo("0");
			
			/* Calling OfflineIssueIndentBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			_OfflineIssueIndentFB.setStrBudgetFlg("1");
			 _OfflineIssueIndentFB.setStrStoreName(vo.getStrStoreName());
			 _OfflineIssueIndentFB.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());	 
			 _OfflineIssueIndentFB.setStrHospitalCode(hosCode);
			 _OfflineIssueIndentFB.setStrSeatId(seatId);
			 _OfflineIssueIndentFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrIndentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrApprovalDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrVerifiedDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 _OfflineIssueIndentFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			 _OfflineIssueIndentFB.setStrIndentPeriodValue(CURRENT_YEAR+"-"+(CURRENT_YEAR+1));
			 if(vo.getStrApprovedBy()!= null)
				{
				 _OfflineIssueIndentFB.setStrApprovedBy(vo.getStrApprovedBy());
				}
			 			 
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
	 * GetStoreBudget(request,response,formBean) -- >
	 * This Method generate the Ajax Response for Indenting Store Budget
	 * on the basis of Store Id
	 * @param request
	 * @param response
	 * @param form
	 */	
	public static void GetStoreBudget(HttpServletRequest request, HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil   hisutil = null;
		   String strCurrentDate;
			int strCurrentMonth;
			int CURRENT_YEAR;
			String strFinancialStartDate;
			String strFinancialEndDate;	
		try
		{  
			     vo = new OfflineIssueIndentTransVO();
		         bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
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
			//System.out.println("vo.getStrAvalaibleBudget()==>"+vo.getStrAvalaibleBudget()+":::vo.getStrAvalaibleBudgetDtl():::"+vo.getStrAvalaibleBudgetDtl());
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrAvalaibleBudget()+"@@@@"+vo.getStrAvalaibleBudgetDtl();
			 	response.getWriter().print(strRes);
			 		 
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->GetStoreBudget()", strmsgText);
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
	public static void IndentingStoreCombo(HttpServletRequest request, HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new OfflineIssueIndentTransVO();
		         bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
		     strChk = request.getParameter("modName");
		    String[] temp = strChk.split("\\^");
		    vo.setStrStoreId(temp[0]);
		    vo.setStrIndentingStoreID(temp[1]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO Indenting Store Combo Method */
			bo.IndentingStoreCombo(vo);
		    /* Indent Store Combo */
			if(vo.getStrIndentStoreCombo()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = vo.getStrIndentStoreCombo();
			 	response.getWriter().print(strRes);
			}
			else
			{
			    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	}
	    }
		catch (Exception e)
		{
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void ApprovedVerifyCombo(HttpServletRequest request, HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new OfflineIssueIndentTransVO();
		         bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
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
			    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void PendingDemandDetails(HttpServletRequest request, HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil   hisutil = null;
		   String strPendingDemand= null;
		try
		{  
			     vo = new OfflineIssueIndentTransVO();
		         bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
		     strChk = request.getParameter("modName");  //Main Store ID ^ Category ID ^ Indenting Store Id
		     vo.setStrStoreId(strChk.split("\\^")[0]);
		    vo.setStrItemCagID(strChk.split("\\^")[1]);
		    vo.setStrIndentingStoreID(strChk.split("\\^")[2]);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO  Method */
			bo.PendingDemand(vo);
		    
		    	strPendingDemand = OfflineIssueIndentTransHLP.getPendingDemands(vo.getPendingDemandWS());
		    	
		    
			
				
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = strPendingDemand;
			 	response.getWriter().print(strRes);
			 		
			
			
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->PendingDemandDetails()", strmsgText);
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
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new OfflineIssueIndentTransVO();
		         bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
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
			    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->ItemCatgoryCombo()", strmsgText);
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
			HttpServletResponse response, OfflineIssueIndentTransFB formBean) {
		   /* Declaring Variables */
	       String strmsgText = "";
		   String strChk = null;
		   String strRes = null;
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
		    vo = new OfflineIssueIndentTransVO();
	        bo = new OfflineIssueIndentTransBO();
		    hisutil = new HisUtil("transaction", "OfflineIssueIndentTransDATA");
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
			    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->ApprovedByCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->ApprovedByCombo()", strmsgText);
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
	 * @param _OfflineIssueIndentTransFB
	 * @param request
	 */
	public static void initViewPageDtl(OfflineIssueIndentTransFB _OfflineIssueIndentTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   HisUtil hisUtil;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "OfflineIssueIndentDATA");
			         vo = new OfflineIssueIndentTransVO();
			   	     bo = new OfflineIssueIndentTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   
			   	_OfflineIssueIndentTransFB.setStrStoreName(vo.getStrStoreName());
			   	_OfflineIssueIndentTransFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_OfflineIssueIndentTransFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_OfflineIssueIndentTransFB.setStrItemCatgCombo(vo.getStrItemCategoryCmb());
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->initViewPageDtl()", strmsgText);
				_OfflineIssueIndentTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OfflineIssueIndentTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	/**
	 * This method will get the values for view page
	 * 
	 * @param request
	 * @param response
	 */

	public static void getPendingIndentDetails(HttpServletRequest request,HttpServletResponse response,OfflineIssueIndentTransFB formBean) 
	{

		OfflineIssueIndentTransBO bo = null;
		OfflineIssueIndentTransVO vo = null;

		String strmsgText = "";
		String strItemDtls = "";
		String strIndentDtls = "";

		try 
		{
			bo = new OfflineIssueIndentTransBO();
			vo = new OfflineIssueIndentTransVO();

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
				strIndentDtls = OfflineIssueIndentTransHLP.getViewItemDetailsTwo(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrStoreId(),vo.getPendingIndentDemandWS(),vo.getStrAvalaibleBudget(),budgetFlag);
				//formBean.setStrViewItemDtls(strItemDtls);
				  strItemDtls = OfflineIssueIndentTransHLP.getExistingItemDetails(vo.getStrItemCategoryNo(), vo.getStrHospitalCode(), vo.getItemDetailsWS(), vo.getStrStoreId(),budgetFlag);
								
				if(strIndentDtls!= null && !strIndentDtls.equals("") && strItemDtls!= null && !strItemDtls.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strIndentDtls+"$$$$$$"+strItemDtls);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->getPendingIndentDetails()", vo.getStrMsgString());
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
        
			strmsgText = "Issue Desk.OfflineIssueIndentTransDATA.getPendingIndentDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",	"OfflineIssueIndentTransDATA->getPendingIndentDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _OfflineIssueIndentTransFB
	 * @param request
	 */
	public static void getViewDtl(OfflineIssueIndentTransFB _OfflineIssueIndentTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new OfflineIssueIndentTransVO();
			   	bo=new OfflineIssueIndentTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			    String strResult = OfflineIssueIndentTransHLP.getIssuedDetail(vo.getIssueNoDtlWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->getViewDtl()", strmsgText);
				_OfflineIssueIndentTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OfflineIssueIndentTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	
	
	
	
	
	public static void getViewDtlNEW(OfflineIssueIndentTransFB _OfflineIssueIndentTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OfflineIssueIndentTransVO vo = null;
		   OfflineIssueIndentTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new OfflineIssueIndentTransVO();
			   	bo=new OfflineIssueIndentTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			    String strResult = OfflineIssueIndentTransHLP.getIssuedDetailNEW(vo.getIssueNoDtlWs());

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OfflineIssueIndentTransDATA->getViewDtl()", strmsgText);
				_OfflineIssueIndentTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OfflineIssueIndentTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}

	/**
	 * This method will get the POPUP info according to the selected Issue No. to
	 * generate a PopUp in HLP
	 * @param OfflineIssueIndentTransFB
	 * @param request
	 * @param response
	 */
	public static void getPopUp(HttpServletRequest request,
			HttpServletResponse response, OfflineIssueIndentTransFB formBean) 
	{
		/* Declaring variables*/
		String strPopUpDtls = null;
		String        index = "";
		String   strmsgText = null;

		OfflineIssueIndentTransBO bo = null;
		OfflineIssueIndentTransVO vo = null;
		HisUtil   hisutil = null;
		String strIssueNo = "";
		

		try 
		{
			/* Creating Object */
			bo = new OfflineIssueIndentTransBO();
			vo = new OfflineIssueIndentTransVO();
		
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
				strPopUpDtls = OfflineIssueIndentTransHLP.getPopUpInfo(vo.getPopUpWS(),	index,strIssueNo);
				if (strPopUpDtls.equals("ERROR")) 
				{

					HisException eObj = new HisException("MMS",
							"OfflineIssueIndentTransDATA->getPopUp()", strmsgText);
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
			strmsgText = "MMS.transactions.OfflineIssueIndentTransDATA.getPopUp(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineIssueIndentTransDATA->getPopUp()", strmsgText);
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

	public static boolean  InsertOffLineforNewDemand(OfflineIssueIndentTransFB formBean,HttpServletRequest request) 
	{
		//System.out.println("InsertOffLineforNewDemand");
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
		OfflineIssueIndentTransBO bo = null;
		OfflineIssueIndentTransVO vo = null;
		String strFinancialStartYear = "";
		String strFinancialEndYear   = "";
		
		try 
		{
			 // Creating Object
								 bo = new OfflineIssueIndentTransBO();
								 vo = new OfflineIssueIndentTransVO();
								mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						    hisutil = new HisUtil("DWH Transaction","OfflineIssueIndentTransDATA");			
			  strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			  strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			        String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			        String seatid   = request.getSession().getAttribute("SEATID").toString();
			        String ipAddr   = request.getSession().getAttribute("IP_ADDR").toString();

			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			formBean.setStrBudgetFlg(mcu.getStrBudgetFlg());
			
			/*if(!mcu.getStrDemandActivePrd().equals("0"))
			{	
			 formBean.setStrIsDemandActiveFlag("1");
			}*/
			         strCurrentDate = hisutil.getASDate("dd-MM-yyyy");
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
			vo.setStrBudgetFlg(mcu.getStrBudgetFlg());
			vo.setStrIpAddress(ipAddr);
			vo.setStrCurrentDate(strCurrentDate);			
			/** Here We Set Item Related Details **/
			vo.setStrIssueQty(formBean.getStrIssueQty());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setItemParamValue(formBean.getItemParamValue());			
			vo.setStrCost(formBean.getStrCost());  // Per Item Cost		
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
			vo.setIsNormal(formBean.getStrDemandTypeFlg());
			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			vo.setStrIndentNo(formBean.getStrIndentNo());
			vo.setStrIndentDate(formBean.getStrApprovedDate());
			vo.setStrIndentIssueDate(formBean.getStrIndentIssueDate());			
			vo.setStrIssuingStoreId(formBean.getStrTmpIssuingStoreId());
			vo.setStrRaisingStoreId(formBean.getStrTmpRaisingStoreId());
			vo.setStrFinalApproxAmt(formBean.getStrFinalApproxAmtDiv());
			vo.setStrReqStoreAvlQty(formBean.getStrReqStoreAvlQty());			
			vo.setStrAvalaibleBudget(formBean.getStrAvalaibleBudget());
			vo.setStrNewDemandFinalApproxAmt(formBean.getStrNewDemandFinalApproxAmt());			
//			//System.out.println("Indent Raising Date:::"+formBean.getStrApprovedDate());
//			//System.out.println("Final Approx Amt::::"+formBean.getStrFinalApproxAmtDiv());
//			//System.out.println("New Demad Final Approx Amt:::"+formBean.getStrNewDemandFinalApproxAmt());
//			//System.out.println("Indent No::::"+formBean.getStrIndentNo());
//			//System.out.println("Indent Date::::"+formBean.getStrIndentDate());
//			//System.out.println("Issuing Store Id::::"+vo.getStrIssuingStoreId());
//			//System.out.println("Raising Store Id:::::"+vo.getStrRaisingStoreId());
//			//System.out.println("Avl Budget::::"+formBean.getStrAvalaibleBudget());
//			//System.out.println("Total Issuing Cost::::"+formBean.getStrNewDemandFinalApproxAmt());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrCost(formBean.getStrCost());	
			if(formBean.getStrReceivedBy().equals("1"))
				vo.setStrApprovedByOther(formBean.getStrApprovedByOther());
	        // Calling BO method
			bo.InsertOffLineforNewDemand(vo);
			
				if (vo.getStrMsgType().equals("1"))
				{
					
					if(vo.getStrMsgString().split("\\##")[2].equals("999"))
				    {
	    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
					    formBean.setStrErr(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						formBean.setStrErr(vo.getStrMsgString());
					    throw new Exception(vo.getStrMsgString());
					}	
					
					
				}
				else
				{	
			        formBean.setStrMsg("Data Has been Successfully Saved");
			        formBean.setStrIndentNo(vo.getStrIndentNo());					
					formBean.setStrIssueNo(vo.getStrIssueNo());
					formBean.setStrIndentDate(vo.getStrIndentDate());
					formBean.setStrTmpStoreNo(vo.getStrStoreName());
				}   
			 
			
			
		
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "OfflineIssueIndentTransDATA.InsertOffLineforNewDemand(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineIssueIndentTransDATA->InsertOffLineforNewDemand()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
    return retValue;
	}
	
	
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean  InsertOffLineforExistingDemand(OfflineIssueIndentTransFB formBean,HttpServletRequest request) 
	{
        // Declaring Variables 
//System.out.println("InsertOffLineforExistingDemand");
		OfflineIssueIndentTransBO bo = null;
		OfflineIssueIndentTransVO vo = null;
		boolean retValue = true;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil hisutil=null;
		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		String strFinancialStartDate;
		String strFinancialEndDate;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		int chkLength = 0;
		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strReservedFlagArray[] = null;
		String stockDtlsId[] = null; // from userHiddenFld= StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
		String strStochStatusCodeArray[] = null;
		String strGroupIdArray[] = null;
		String strSubGroupIdArray[] = null;
		String strAvlQtyArray[] = null;
		String strAvlQtyUnitIdArray[] = null;
		String strConsumableFlagArray[] = null;
		
		String[] values = null;
		String temp[] = null;
		
		try 
		{
			 // Creating Object
			                   bo = new OfflineIssueIndentTransBO();
			                   vo = new OfflineIssueIndentTransVO();
			                  mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			              hisutil = new HisUtil("Store Transaction","OfflineIssueIndentTransDATA");
			
			strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreName() , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			      String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			      String seatid   = request.getSession().getAttribute("SEATID").toString();
			
			vo.setStrItemDetailsChk(formBean.getStrItemDetailsChk());
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			formBean.setStrBudgetFlg(mcu.getStrBudgetFlg());
			
			
			
			vo.setStrBudgetFlg(mcu.getStrBudgetFlg());
			
			/*if(!mcu.getStrDemandActivePrd().equals("0"))
			{	
			 formBean.setStrIsDemandActiveFlag("1");
			}*/
			//vo.setStrIsDemandActiveFlag(formBean.getStrIsDemandActiveFlag());
			/*******************************************************************/
								
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
				          chkLength = formBean.getStrItemDetailsChk().length;
				    strBrandIdArray = new String[chkLength];
				     strItemIdArray = new String[chkLength];
				    strBrandIdArray = new String[chkLength];
			   strReservedFlagArray = new String[chkLength];
				        stockDtlsId = new String[chkLength]; // from userHiddenFld=
													// StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
			strStochStatusCodeArray = new String[chkLength];
			        strGroupIdArray = new String[chkLength];
			     strSubGroupIdArray = new String[chkLength];
			         strAvlQtyArray = new String[chkLength];
			   strAvlQtyUnitIdArray = new String[chkLength];
			 strConsumableFlagArray = new String[chkLength];
						
			
			 for (int i = 0; i < chkLength; i++) 
			 {

					                   values = formBean.getStrItemDetailsChk()[i].replace("^", "#").split("#");
					        strItemIdArray[i] = values[0];
					       strBrandIdArray[i] = values[1];
					  strReservedFlagArray[i] = values[2];
					       strGroupIdArray[i] = values[3];
					    strSubGroupIdArray[i] = values[4];
					strConsumableFlagArray[i] = values[5];

					// //System.out.println("In Data formBean.getStockDtlsId()[i]-"+formBean.getStockDtlsId()[i]);
					/*
					 * values = formBean.getStockDtlsId()[i].replace("^", "#")
					 * .split("#");
					 * //StoreId^Generic_ItemId^Brand_ItemId^Stock_Status_Code^Batch_No^Serial_No
					 * 
					 * strStochStatusCodeArray[i] = values[3]; strBatchSlNoArray[i] =
					 * values[4]; strItemSlNoArray[i]= values[5];
					 */
					stockDtlsId = formBean.getStockDtlsId();
					// //System.out.println("formBean.getStrAvlQty()[i]-"+formBean.getStrAvlQty()[i]);
					values = formBean.getStrAvlQty()[i].replace("^", "#").split("#"); // avl qty unit name^ avlqty@unit ^ avl
											// base val
					temp = formBean.getStrAvlQty()[i].replace("@", "#").split("#");
					// temp =values[1].replace("@", "#").split("#");
					strAvlQtyArray[i] = temp[0];
					strAvlQtyUnitIdArray[i] = temp[1];

				}
				vo.setStrConsumableFlagArray(strConsumableFlagArray);
				////System.out.println("stockDtlsId"+stockDtlsId);
				vo.setStockDtlsId(stockDtlsId);
				vo.setStrItemIdArray(strItemIdArray); // 7
				vo.setStrBrandIdArray(strBrandIdArray); // 8
				vo.setStrReservedFlagArray(strReservedFlagArray); // 4
				vo.setStrReqTypeId("31"); // for issue to store //6
				// vo.setStrBatchSlNoArray(strBatchSlNoArray); //9
				// vo.setStrItemSlNoArray(strItemSlNoArray); // 11
				vo.setStrStochStatusCodeArray(strStochStatusCodeArray); // 12
				vo.setStrGroupIdArray(strGroupIdArray); // 13
				vo.setStrSubGroupIdArray(strSubGroupIdArray); // 14
				vo.setStrAvlQtyArray(strAvlQtyArray); // 15
				vo.setStrAvlQtyUnitIdArray(strAvlQtyUnitIdArray); // 16
				vo.setStrBalQtyArray(formBean.getStrBalQty()); // 17
				vo.setStrBalQtyUnitIdArray(formBean.getStrSancUnitId()); // 18
				vo.setStrIssueQtyArray(formBean.getStrIssueQty()); // 19
				vo.setStrIssueQtyUnitIdArray(formBean.getStrIssueUnitId()); // 20
				vo.setStrItemCategoryNo("10");
				vo.setStrIssueQty(formBean.getStrIssueQty());
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
				vo.setStrRemarks("/");//Check
				vo.setStrReceivedBy("/");//Check
				vo.setStrAprovedRemarks(formBean.getStrAprovedRemarks());
				vo.setStrStoreName(formBean.getStrStoreName());
				vo.setStrItemCategoryCmb(formBean.getStrItemCatgCombo());
				vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID());
				vo.setStrIndentType(formBean.getStrIndentType());
				vo.setIsNormal(formBean.getIsNormal());
				vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
				vo.setStrIndentNo(formBean.getStrTmpIndentNo());
				vo.setStrIndentDate(formBean.getStrTmpIndentDate());
				vo.setStrIssuingStoreId(formBean.getStrTmpIssuingStoreId());
				vo.setStrRaisingStoreId(formBean.getStrTmpRaisingStoreId());
				vo.setStrFinalApproxAmt(formBean.getStrFinalApproxAmtDiv());
				vo.setStrAvalaibleBudget(formBean.getStrAvalaibleBudget());
		        // Calling BO method
				bo.InsertOffLineforExistingDemand(vo);

		if (vo.getStrMsgType().equals("1")) 
		{
				throw new Exception(vo.getStrMsgString());
		} 
		else 
		{			
			
			formBean.setStrMsg("Data Saved Successfully");
			formBean.setStrIndentNo(vo.getStrIndentNo());
			formBean.setStrIssueNo(vo.getStrIssueNo());
			formBean.setStrIndentDate(vo.getStrIndentDate());
			formBean.setStrTmpStoreNo(vo.getStrStoreName());
		}
		}
		catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "OfflineIssueIndentTransDATA.insertData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"OfflineIssueIndentTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
    return retValue;
	}
	
	
	
	

}
