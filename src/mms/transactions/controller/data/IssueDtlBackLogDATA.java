package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDtlBackLogBO;
import mms.transactions.controller.fb.IssueDtlBackLogFB;
import mms.transactions.controller.hlp.IssueDtlBackLogHLP;
import mms.transactions.vo.IssueDtlBackLogVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modify: 
*/
public class IssueDtlBackLogDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Breakage Item Details Transaction 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(IssueDtlBackLogFB _IssueDtlBackLogFB,HttpServletRequest request) 
	{
		/* Declaring Variable */
		
		String strmsgText = "";
		String    hosCode = "";
		HisUtil   hisUtil = null;
	    String     seatId = "";
	    IssueDtlBackLogBO bo = null;
		IssueDtlBackLogVO vo = null;
		MmsConfigUtil   mmscofigutil = null;
			
		
		try 
		{
			/* Creating Object */
			
					     bo = new IssueDtlBackLogBO();
					     vo = new IssueDtlBackLogVO();
					hisUtil = new HisUtil("MMS", "IssueDtlBackLogDATA");
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
			_IssueDtlBackLogFB.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			/* If Avalaible then New Cost Column will be Added */
			_IssueDtlBackLogFB.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			_IssueDtlBackLogFB.setStrDemandActivePrd(mmscofigutil.getStrDemandActivePrd());
			
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				_IssueDtlBackLogFB.setStrIsDemandActiveFlag("1");
			}
			
			
			
						
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrIssueNo("0");	
			vo.setStrIndentNo("0");
			
			/* Calling IssueDtlBackLogBO method  */
			bo.GetData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}			
			 _IssueDtlBackLogFB.setStrStoreName(vo.getStrStoreName());
			
			 _IssueDtlBackLogFB.setStrHospitalCode(hosCode);
			 _IssueDtlBackLogFB.setStrSeatId(seatId);
			 _IssueDtlBackLogFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
 
			  _IssueDtlBackLogFB.setStrModDate("01-APR-2012");
			 
			 			 
		}
		  catch (Exception e) 
		  {
           e.printStackTrace();
			strmsgText = "IssueDtlBackLogDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"IssueDtlBackLogsDATA->GetData()", strmsgText);
			_IssueDtlBackLogFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

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
	public static void GetStoreBudget(HttpServletRequest request, HttpServletResponse response,IssueDtlBackLogFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   HisUtil   hisutil = null;
		   String strCurrentDate;
			int strCurrentMonth;
			int CURRENT_YEAR;
			String strFinancialStartDate;
			String strFinancialEndDate;	
		try
		{  
			     vo = new IssueDtlBackLogVO();
		         bo = new IssueDtlBackLogBO();
		    hisutil = new HisUtil("transaction", "IssueDtlBackLogDATA");
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
			HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->GetStoreBudget()", strmsgText);
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
	public static void IndentingStoreCombo(HttpServletRequest request, HttpServletResponse response,IssueDtlBackLogFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new IssueDtlBackLogVO();
		         bo = new IssueDtlBackLogBO();
		    hisutil = new HisUtil("transaction", "IssueDtlBackLogDATA");
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
			    HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->IndentingStoreCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	}
	    }
		catch (Exception e)
		{
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->IndentingStoreCombo()", strmsgText);
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
	public static void VoucherDetails(HttpServletRequest request, HttpServletResponse response,IssueDtlBackLogFB formBean) 
	{
		   /* Declaring Variables */
	       String       strmsgText = "";
		   String     strVoucherNo = null;
		   String     strStoreId   = null;
		   String           strRes = null;
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   HisUtil hisutil = null;
		try
		{  
			     vo = new IssueDtlBackLogVO();
		         bo = new IssueDtlBackLogBO();
		    hisutil = new HisUtil("transaction", "IssueDtlBackLogDATA");
		     strVoucherNo = request.getParameter("voucherNo");
		     strStoreId   = request.getParameter("strStoreId");
		    
		    vo.setStrVoucherNo(strVoucherNo);
		    vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    /* Call BO Indenting Store Combo Method */
			/*
			 * 1.Item Brand Id
			 * 2.Item Name
			 * 3.Batch No
			 * 4.Issue Qty
			 * 5.Unit Name
			 * 6.Issue Date
			 * 7.Indent No
			 * 8.Indent Date
			 * */		
			int i = 0;
		   if(!vo.getStrVoucherNo().equals("0"))
		   {
			   bo.VoucherDetails(vo);  
			if(vo.getPopUpWS()!= null && vo.getPopUpWS().size()>0)
			{		
				
				while(vo.getPopUpWS().next())
				{
					if(i==0)
					{	
					  strRes = vo.getPopUpWS().getString(8)+"^"+vo.getPopUpWS().getString(7)+"^"+vo.getPopUpWS().getString(6);
					}
					i++;
				}	
				
				vo.getPopUpWS().beforeFirst();
				String VouvherDtl = IssueDtlBackLogHLP.getVoucherDtlHlp(vo.getPopUpWS(),vo);
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strRes +"@@@@"+VouvherDtl);
			}
			else
			{
				
			    HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->VoucherDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				//response.getWriter().print(str);
				strRes = "ERROR"+"@@@@"+str;
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strRes);
	    	}
		  }
		  else
		  {
			    String VouvherDtl = IssueDtlBackLogHLP.getVoucherDtlHlp1();
				response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(" ^ ^ "+"@@@@"+VouvherDtl);
		  }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->IndentingStoreCombo()", strmsgText);
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
	public static void ItemCatgoryCombo(HttpServletRequest request, HttpServletResponse response,IssueDtlBackLogFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   HisUtil   hisutil = null;
		try
		{  
			     vo = new IssueDtlBackLogVO();
		         bo = new IssueDtlBackLogBO();
		    hisutil = new HisUtil("transaction", "IssueDtlBackLogDATA");
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
			    HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->ItemCatgoryCombo()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
	    }
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->ItemCatgoryCombo()", strmsgText);
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
	 * @param _IssueDtlBackLogFB
	 * @param request
	 */
	public static void initViewPageDtl(IssueDtlBackLogFB _IssueDtlBackLogFB,HttpServletRequest request)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   HisUtil hisUtil;
		   String SubUnitCmb;
		   String strDrugNameCombo;
		   try
		   {
			    /* Create Object */
			    hisUtil = new HisUtil("MMS", "IssueDtlBackLogDATA");
			         vo = new IssueDtlBackLogVO();
			   	     bo = new IssueDtlBackLogBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
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
			   	_IssueDtlBackLogFB.setStrDrugNameCombo(strDrugNameCombo);
			   	_IssueDtlBackLogFB.setStrUnitCombo(SubUnitCmb);
			   	
			   	
			   	_IssueDtlBackLogFB.setStrStoreName(vo.getStrStoreName());
			   	_IssueDtlBackLogFB.setStrFromDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	_IssueDtlBackLogFB.setStrToDate(hisUtil.getASDate("dd-MMM-yyyy"));
			   	
			   	_IssueDtlBackLogFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			    
				_IssueDtlBackLogFB.setStrModDate("31-MAR-2012");
				
				
				_IssueDtlBackLogFB.setStrIndentingStoreID(vo.getStrIndentStoreCombo());
				  
			   
			   
		   }
		   catch(Exception _err)
		   {
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->initViewPageDtl()", strmsgText);
				_IssueDtlBackLogFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlBackLogFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	

	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlBackLogFB
	 * @param request
	 */
	public static void getVoucherCombo(IssueDtlBackLogFB _IssueDtlBackLogFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlBackLogVO();
			   	bo=new IssueDtlBackLogBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrItemCategoryCmb("10");
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
				vo.setStrIndentingStoreID(request.getParameter("IndentingStore"));
                
				/* Call BO Indenting Store Combo Method */
				bo.VoucherCombo(vo);
			    /* Indent Store Combo */
				if(vo.getStrVoucherCombo()!= "")
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	strRes = vo.getStrVoucherCombo();
				 	response.getWriter().print(strRes);
				}
				else
				{
				    HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->VoucherCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->VoucherCombo()", strmsgText);
				_IssueDtlBackLogFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlBackLogFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}	
	
	
	/**
	 * This function used to set initial parameters for view Page.
	 * @param _IssueDtlBackLogFB
	 * @param request
	 */
	public static void getBatchCombo(IssueDtlBackLogFB _IssueDtlBackLogFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   IssueDtlBackLogVO vo = null;
		   IssueDtlBackLogBO bo = null;
		   String strRes = "";
		   try
		   {
			    /* Creating Object */   	
			    vo=new IssueDtlBackLogVO();
			   	bo=new IssueDtlBackLogBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrItemBrandId(request.getParameter("strDrugID").split("\\^")[0]);
                String index = request.getParameter("index");
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
				    HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->getBatchCombo()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "IssueDtlBackLogDATA->getBatchCombo()", strmsgText);
				_IssueDtlBackLogFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_IssueDtlBackLogFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}	
	/**
	 * to insert the data into database
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void insertRecord(IssueDtlBackLogFB formBean,
			HttpServletRequest request) 
	{

		String strmsgText = "";
		IssueDtlBackLogBO bo = null;
		IssueDtlBackLogVO vo = null;
		//MmsConfigUtil mcu = null;
	
		String strHospitalCode = "";
		String strSeatId = "";		
		
		try 
		{
			bo = new IssueDtlBackLogBO();
			vo = new IssueDtlBackLogVO();
			//mcu = new MmsConfigUtil();
			
			
			strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo = (IssueDtlBackLogVO) TransferObjectFactory.populateData("mms.transactions.vo.IssueDtlBackLogVO", formBean);
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}		
			else
			{
			    formBean.setStrMsg("Data Saved Successfully");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "IssueDtlBackLog.IssueDtlBackLogDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IssueDtlBackLogDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
		
			
			vo = null;
			bo = null;
		}

	}

	
	
	

}
