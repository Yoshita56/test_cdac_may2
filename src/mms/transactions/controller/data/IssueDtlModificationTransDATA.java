package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDtlModificationTransBO;
import mms.transactions.controller.fb.IssueDtlModificationTransFB;
import mms.transactions.controller.hlp.IssueDtlModificationTransHLP;
import mms.transactions.vo.IssueDtlModificationTransVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify: 
*/
public class IssueDtlModificationTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		
		String strmsgText = "";
		String    hosCode = "";
		HisUtil   hisUtil = null;
	    String     seatId = "";
	    IssueDtlModificationTransBO bo = null;
		IssueDtlModificationTransVO vo = null;
		MmsConfigUtil   mmscofigutil = null;
			
		
		try 
		{
			/* Creating Object */
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
					     bo = new IssueDtlModificationTransBO();
					     vo = new IssueDtlModificationTransVO();
					hisUtil = new HisUtil("MMS", "IssueDtlModificationTransDATA");
			   mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
            /* Getting Value from Session */ 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatId  = request.getSession().getAttribute("SEATID").toString();
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			
			
			if(strUserLevel.equals("6")){
				vo.setStrMode("4");
			}
			else
				vo.setStrMode("5");
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrIssueNo("0");	
			vo.setStrIndentNo("0");
			
			/* Calling IssueDtlModificationTransBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			
			 _IssueDtlModificationTransFB.setStrStoreName(vo.getStrStoreName());
			
			 _IssueDtlModificationTransFB.setStrHospitalCode(hosCode);
			 _IssueDtlModificationTransFB.setStrSeatId(seatId);
			 _IssueDtlModificationTransFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
 
			  _IssueDtlModificationTransFB.setStrModDate("01-APR-2012");
			 
			 			 
		}
		  catch (Exception e) 
		  {
           e.printStackTrace();
			strmsgText = "IssueDtlModificationTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDtlModificationTranssDATA->GetData()", strmsgText);
			_IssueDtlModificationTransFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

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
	public static void GetStoreBudget(HttpServletRequest request, HttpServletResponse response,IssueDtlModificationTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   HisUtil   hisutil = null;
		   String strCurrentDate;
			int strCurrentMonth;
			int CURRENT_YEAR;
			String strFinancialStartDate;
			String strFinancialEndDate;	
		try
		{  
			     vo = new IssueDtlModificationTransVO();
		         bo = new IssueDtlModificationTransBO();
		    hisutil = new HisUtil("transaction", "IssueDtlModificationTransDATA");
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
			HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->GetStoreBudget()", strmsgText);
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
	public static void IndentingStoreCombo(HttpServletRequest request, HttpServletResponse response,IssueDtlModificationTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new IssueDtlModificationTransVO();
		         bo = new IssueDtlModificationTransBO();
		    hisutil = new HisUtil("transaction", "IssueDtlModificationTransDATA");
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
			    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	}
	    }
		catch (Exception e)
		{
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void VoucherDetails(HttpServletRequest request, HttpServletResponse response,IssueDtlModificationTransFB formBean) 
	{
		   /* Declaring Variables */
	       String       strmsgText = "";
		   String     strVoucherNo = null;
		   String     strStoreId   = null;
		   String           strRes = null;
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new IssueDtlModificationTransVO();
		         bo = new IssueDtlModificationTransBO();
		    hisutil = new HisUtil("transaction", "IssueDtlModificationTransDATA");
		     strVoucherNo = request.getParameter("voucherNo");
		     strStoreId   = request.getParameter("strStoreId");
		    
		    vo.setStrVoucherNo(strVoucherNo);
		    vo.setStrIssueNo(strVoucherNo.split("\\^")[0]);
		    vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO 
			/*
			 HSTNUM_ISSUE_NO || ''^'' || TO_CHAR(HSTDT_ISSUE_DATE,''DD-Mon-YYYY'') || ''^'' || 
                    NVL(HSTNUM_INDENT_NO,'' '') || ''^'' || TO_CHAR(NVL(HSTDT_INDENT_DATE,SYSDATE),''DD-Mon-YYYY'') || ''^'' || 
                    NVL(HSTNUM_BUDGET_AVAILABLE,0) || ''^'' || (SELECT NVL(HSTNUM_BUDGET_ALLOT,0) - NVL(HSTNUM_BUDGET_USED,0) 
			 * */		
		   if(!vo.getStrVoucherNo().equals("0"))
		   {
			   bo.VoucherDetails(vo);  
			if(vo.getPopUpWS()!= null && vo.getPopUpWS().size()>0)
			{		
				/*
				while(vo.getPopUpWS().next())
				{
					if(i==0)
					{	
					  strRes = vo.getPopUpWS().getString(8)+"^"+vo.getPopUpWS().getString(7)+"^"+vo.getPopUpWS().getString(6);
					}
					i++;
				}	*/
				
				vo.getPopUpWS().beforeFirst();
				String VoucherDtl = IssueDtlModificationTransHLP.getVoucherDtlHlp(vo.getPopUpWS(),vo);
				VoucherDtl = VoucherDtl.replace("@@@@", "%");
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strVoucherNo +"@@@@"+VoucherDtl);
			}
			else
			{
				
			    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->VoucherDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				//response.getWriter().print(str);
				strRes = "ERROR"+"@@@@"+str;
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strRes);
	    	}
		  }
		  else
		  {
			    String VouvherDtl = IssueDtlModificationTransHLP.getVoucherDtlHlp1();
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(" ^ ^ "+"@@@@"+VouvherDtl);
		  }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->IndentingStoreCombo()", strmsgText);
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
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,IssueDtlModificationTransFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new IssueDtlModificationTransVO();
		         bo = new IssueDtlModificationTransBO();
		    hisutil = new HisUtil("transaction", "IssueDtlModificationTransDATA");
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
			    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->ItemCatgoryCombo()", strmsgText);
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
	 * @param _IssueDtlModificationTransFB
	 * @param request
	 */
	public static void initViewPageDtl(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   HisUtil hisUtil;
		   String SubUnitCmb;
		   String strDrugNameCombo;
		   try
		   {
			   String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "IssueDtlModificationTransDATA");
			         vo = new IssueDtlModificationTransVO();
			   	     bo = new IssueDtlModificationTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	
			   	if(strUserLevel.equals("6")){
					vo.setStrMode("4");
				}
				else
					vo.setStrMode("5");
			   	
			   	/* Calling BO method */
			   	bo.initForViewPage(vo);
			   	
			   	if (vo.getUnitComboWS().size() == 0	|| vo.getUnitComboWS() == null) 
			   	{
					SubUnitCmb = "<option value='0'>Select Value</option>";
				} 
			   	else 
			   	{
					SubUnitCmb = hisUtil.getOptionValue(vo.getUnitComboWS(), "0", "0^Select Value", true);

				}
			   	
			   	if (vo.getDrugNameComboWS().size() == 0	|| vo.getDrugNameComboWS() == null) 
			   	{
			   		strDrugNameCombo = "<option value='0'>Select Value</option>";
				} 
			   	else 
			   	{
			   		strDrugNameCombo = hisUtil.getOptionValue(vo.getDrugNameComboWS(), "0", "0^Select Value", true);

				}
			   	_IssueDtlModificationTransFB.setStrDrugNameCombo(strDrugNameCombo);
			   	//_IssueDtlModificationTransFB.setStrUnitCombo(SubUnitCmb);
			   	
			   	
			   	_IssueDtlModificationTransFB.setStrStoreName(vo.getStrStoreName());
			   	_IssueDtlModificationTransFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_IssueDtlModificationTransFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	
			   	_IssueDtlModificationTransFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			    
				_IssueDtlModificationTransFB.setStrModDate("31-MAR-2012");
				
				
				_IssueDtlModificationTransFB.setStrIndentingStoreID(vo.getStrIndentStoreCombo());
				  
			   
			   
		   }
		   catch(Exception _err)
		   {
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->initViewPageDtl()", strmsgText);
				_IssueDtlModificationTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlModificationTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	

	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlModificationTransFB
	 * @param request
	 */
	public static void getVoucherCombo(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlModificationTransVO();
			   	bo=new IssueDtlModificationTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb("10");
			   	vo.setStrIndentingStoreID(request.getParameter("IndentingStore"));
                
				/* Call BO Indenting Store Combo Method */
				bo.VoucherCombo(vo);
			    /* Indent Store Combo */
				if(vo.getStrVoucherCombo()!= "")
				{					 	
				 	strRes = vo.getStrVoucherCombo();				 	
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->VoucherCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
				
				if(vo.getStrVerifiedByValues()!= "")
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	strRes = strRes+"@@@@"+vo.getStrVerifiedByValues();
				 	response.getWriter().print(strRes);
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->VoucherCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->VoucherCombo()", strmsgText);
				_IssueDtlModificationTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlModificationTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}	
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlModificationTransFB
	 * @param request
	 */
	public static void getBatchCombo(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlModificationTransVO();
			   	bo=new IssueDtlModificationTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrItemBrandId(request.getParameter("strDrugID").split("\\^")[0]);
                String index = request.getParameter("index");
            	vo.setStrStoreId(request.getParameter("strStoreId"));
				/* Call BO Indenting Store Combo Method */
				bo.BatchCombo(vo);
			    /* Indent Store Combo */
				if(vo.getStrBatchCombo()!= "")
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	strRes = vo.getStrBatchCombo();
				 	response.getWriter().print(strRes+"@@@"+index+"@@@"+request.getParameter("strDrugID").split("\\^")[1]);
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->getBatchCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->getBatchCombo()", strmsgText);
				_IssueDtlModificationTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlModificationTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}	
	/**
	 * to insert the data into database
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(IssueDtlModificationTransFB formBean,HttpServletRequest request) 
	{

		String strMsgText = "";
		IssueDtlModificationTransBO bo = null;
		IssueDtlModificationTransVO vo = null;
		
		String strHospitalCode = "";
		String strSeatId = "";		
		String strBatchNo,strRate,strAvlQty,strUnitName,strStockStatusCode;
		String strItemBrandId,strOldBatchNo,strOldStockStatus,strItemName,strOldIssueQty,strItemCost,strOldAvlQty;
		try 
		{
			bo = new IssueDtlModificationTransBO();
			vo = new IssueDtlModificationTransVO();
			//mcu = new MmsConfigUtil();
			
			
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();
			
			/*
			 * New
			 * 
			 * formBean.getStrBatchNo()
			 * 
			NVL(HSTSTR_BATCH_NO,'--') || '^' || 
			RATE_BASE || '^' || 
		    INHAND_QTY || '^' || 
		    UNIT_NAME || '^' || 
		    HSTNUM_STOCK_STATUS_CODE AS DISP_ID,
		    NVL(HSTSTR_BATCH_NO,'--') AS DISP_NAME
			*/
			
			strBatchNo 			=	formBean.getStrBatchNo().split("\\^")[0];
			strRate				=	formBean.getStrBatchNo().split("\\^")[1];
			strAvlQty			=	formBean.getStrBatchNo().split("\\^")[2];
			strUnitName			=	formBean.getStrBatchNo().split("\\^")[3];
			strStockStatusCode	=	formBean.getStrBatchNo().split("\\^")[4];
			                                     
			
			/*
			 * formBean.getStrVoucherNo()
			 * 			 	
				
			*/
			
			
			/*
			 * Old
			 * 
			formBean.getStrDrugDtls
			
			 * 1. HSTNUM_ITEMBRAND_ID, 
			 * 2. HSTSTR_BATCH_SL_NO,
			 * 3. HSTNUM_STOCK_STATUS_CODE,
			 * 4. ITEM_NAME,
			 * 5. ISSUE_QTY,
			 * 6. ITEM_COST,
			 * 7. CURRENT_AVL_QTY,
			 * 8. UNIT_NAME
			*/
			
			strItemBrandId			=		formBean.getStrDrugDtls().split("\\^")[0];
			strOldBatchNo			=		formBean.getStrDrugDtls().split("\\^")[1];
			strOldStockStatus		=		formBean.getStrDrugDtls().split("\\^")[2];
			strItemName				=		formBean.getStrDrugDtls().split("\\^")[3];
			strOldIssueQty			=		formBean.getStrDrugDtls().split("\\^")[4];
			strItemCost				=		formBean.getStrDrugDtls().split("\\^")[5];
			strOldAvlQty			=		formBean.getStrDrugDtls().split("\\^")[6];
//			strUnitName						=		formBean.getStrDrugDtls.split("\\^")[7];
			
			
			vo.setStrHospitalCode(strHospitalCode);		
			vo.setStrIssueNo(formBean.getStrVoucherNo().split("\\^")[0]);       
			vo.setStrStoreId(formBean.getStrStoreName()); 
			vo.setStrIndentingStoreID(formBean.getStrIndentingStoreID()); 
			vo.setStrItemBrandId(strItemBrandId);      
			vo.setStrOldBatchNo(strOldBatchNo);       
			vo.setStrBatchNo(strBatchNo); 
			vo.setStrOldIssueQty(strOldIssueQty); // Eg  (6 No.)
			vo.setStrIssueQty(formBean.getStrIssueQty());    
			vo.setStrOldStockStatus(strOldStockStatus); 
			vo.setStrStockStatusCode(strStockStatusCode);
			vo.setStrOldAvlQty(strOldAvlQty);      						
			vo.setStrIssueDate(formBean.getStrVoucherDate());      
			vo.setStrIndentNo(formBean.getStrIndentNumber());       
			vo.setStrIndentDate(formBean.getStrVoucherIndentDate());
			vo.setStrReceivedBy(formBean.getStrReceivedById()); 
			vo.setStrRemarks(formBean.getStrRemarks());						
			vo.setStrSeatId(strSeatId);
			
			
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				if(vo.getStrMsgString().split("\\##")[2].equals("999"))
			    {
    				////System.out.println("Issued Batch :  batchNo for Drug Name : ' does not exist in Drug Inventory !!);
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
			    formBean.setStrMsg("Data Saved Successfully");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = "IssueDtlModificationTrans.IssueDtlModificationTransDATA.insertRecord(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","IssueDtlModificationTransDATA->insertRecord()", strMsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}
	}

	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlModificationTransFB
	 * @param request
	 */
	public static void getAvlQty(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlModificationTransVO();
			   	bo=new IssueDtlModificationTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrItemBrandId(request.getParameter("strDrugID").split("\\^")[0]);
			   	vo.setStrTempBatchNo(request.getParameter("strBatchNo").split("\\ ")[0]);
			   	
			   	vo.setStrStoreId(request.getParameter("strStoreId"));
			   	
			   	
                String index = request.getParameter("index");
				
                
                bo.getAvlQty(vo);
				
                if (vo.getStrMsgType().equals("0")) 
    			{    				
				 	response.setHeader("Cache-Control", "no-cache");
				 	strRes = vo.getStrTempAvlQty();
				 	response.getWriter().print(strRes+"@@@"+index);
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->getBatchCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlModificationTransDATA->getBatchCombo()", strmsgText);
				_IssueDtlModificationTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlModificationTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}	
	
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlModificationTransFB
	 * @param request
	 */
	public static void getModificationDtls(IssueDtlModificationTransFB _IssueDtlModificationTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strMsgText = "";
		   IssueDtlModificationTransVO vo = null;
		   IssueDtlModificationTransBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlModificationTransVO();
			   	bo=new IssueDtlModificationTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
//			   	//System.out.println("Test::"+request.getParameter("strDrugDtls"));
			   	
			   	vo.setStrDrugDtls(request.getParameter("strDrugDtls"));
                String index = request.getParameter("index");
                vo.setStrStoreId(request.getParameter("strStoreId"));
                
                strRes =  IssueDtlModificationTransHLP.getModificationDetailsTable(vo);
				
                
                
                if (vo.getStrMsgType().equals("1"))
				{
					
					if(vo.getStrMsgString().split("\\##")[2].equals("999"))
				    {
	    				////System.out.println("Issued Batch :  batchNo for Drug Name : ' does not exist in Drug Inventory !!);
						_IssueDtlModificationTransFB.setStrErr(vo.getStrMsgString().split("\\##")[1]);
				    }
					else
					{
						_IssueDtlModificationTransFB.setStrErr(vo.getStrMsgString());
					}	
					
					response.setHeader("Cache-Control", "no-cache");				 	
				 	response.getWriter().print(strRes+"$$"+index+"$$"+_IssueDtlModificationTransFB.getStrErr());
				}
                else                 
    			{    				
                	response.setHeader("Cache-Control", "no-cache");				 	
				 	response.getWriter().print(strRes+"$$"+index+"$$101");
				}
			   
			   
		   }catch(Exception e){
		
				
				e.printStackTrace();
				strMsgText = "IssueDtlModificationTrans.IssueDtlModificationTransDATA.insertRecord(vo) --> "+ e.getMessage();
				HisException eObj = new HisException("mms","IssueDtlModificationTransDATA->insertRecord()", strMsgText);
				_IssueDtlModificationTransFB.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
				_IssueDtlModificationTransFB.setStrMsgType("1");

				eObj = null;
		   }
		   
	}	
	
	

}
