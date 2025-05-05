package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.IndentTransADDBO;
import mms.transactions.controller.fb.IndentTransADDFB;
import mms.transactions.controller.hlp.IndentTransADDHLP;
import mms.transactions.vo.IndentTransADDVO;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentTransADDDATA 
{
	
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Issue Transaciton  Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData_NEW(IndentTransADDFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		
		String strFinancialStartDate;
		String strFinancialEndDate;	
		String strCostRequired  = "1";	
		String strCurrentDate   = "";
		int strCurrentMonth     = 0;
		int CURRENT_YEAR        = 2023;		
		IndentTransADDBO     bo = null;
		IndentTransADDVO     vo = null;
		String       strmsgText = "";
		String             path = "";
		HisUtil            util = null;
		String           strRes = null;
		String          hosCode = null;
		
        String chkValue="";
		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		try 
		{
			      		bo = new IndentTransADDBO();
		    			vo = new IndentTransADDVO();
		    	          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
		    	         
			          util = new HisUtil("MMSModule", "IndentTransADDDATA");		  
			       
			   			
			
			if(request.getParameter("chk") != null)
			{
	        	chkValue 	= request.getParameter("chk");
	        	strStoreName= request.getParameter("strStoreName");
	    		strCatgName	= request.getParameter("strCatgName");
	    		strReqName	= request.getParameter("strReqName");	    			    			    		
	    		System.out.println("chkValue  ------>>"+chkValue);
	    		System.out.println("strStoreName  ------>>"+strStoreName);
	    		System.out.println("strCatgName  ------>>"+strCatgName);
	    		System.out.println("strReqName  ------>>"+strReqName);
			}
	        else
	        {
	        	HisException eObj = new HisException("mms",	"RequestForLPPatientDATA->GetData()", strmsgText);
	        	formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "] Require Value Not Avaliable ,Contact System Administrator! ");
	        }
	        
	        // storeId+"@"+catgId+"@"+reqTypeId
								
			strStoreId 		  = chkValue.split("\\@")[0];   // Store Id			
			strItemCategoryNo = chkValue.split("\\@")[1];  	// Item category		
			strReqType 		  = chkValue.split("\\@")[2];   // Request Type ID
		
			
			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrStoreId(strStoreId);     // Store ID
			vo.setStrStoreTypeId("0"); // Store Type ID
			vo.setStrItemCategory(strItemCategoryNo);  // Item category 
			
          		
			vo.setStrIndentTypeId(strReqType);    // Request Type ID
						
		
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			
            
			// Calling BO method
			bo.GetData(vo);
			
		 	
			bo.CallFunction(vo);
						
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrStoreName(strStoreName);
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrItemCatNo(vo.getStrItemCategory());
			formBean.setStrIndentTypeId(vo.getStrIndentTypeId());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrIndentTypeFunc(vo.getStrIndentTypeFunc());
			formBean.setStrStoreNameFunc(vo.getStrStoreNameFunc());
			formBean.setStrItemCategoryFunc(vo.getStrItemCategoryFunc());
			formBean.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());
			formBean.setStrIndentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrCostRequired("1");
			
			formBean.setStrItemCategoryCmb(vo.getStrItemCategoryCmb());
			
			formBean.setStrIndentNo("0");
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentTransADDDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTransADDDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Issue Transaciton  Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(IndentTransADDFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{
		
		String strFinancialStartDate;
		String strFinancialEndDate;	
		String strCostRequired  = "1";	
		String strCurrentDate   = "";
		int strCurrentMonth     = 0;
		int CURRENT_YEAR        = 2023;		
		IndentTransADDBO     bo = null;
		IndentTransADDVO     vo = null;
		String       strmsgText = "";
		String             path = "";
		HisUtil            util = null;
		String          combo[] = null;
		String[]        strTemp = null;  
		String[]       strTemp1 = null; 
		String           strRes = null;
		String          hosCode = null;
		try 
		{
			      		bo = new IndentTransADDBO();
		    			vo = new IndentTransADDVO();
		    	          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
		    	         
			          util = new HisUtil("MMSModule", "IndentTransADDDATA");		  
			         combo = request.getParameterValues("combo");
			       strTemp =  combo[0].split("\\^");
			          path = "/mms"+request.getParameter("cnt_page")+".cnt";
				
			if(request.getParameter("cnt_page") == null)
			{
				
				path = request.getParameter("strPath");
			}
			
			formBean.setStrPath(path.trim());
			
			vo.setStrStoreId(strTemp[0]);     // Store ID
			vo.setStrStoreTypeId(strTemp[1]); // Store Type ID
			vo.setStrItemCategory(combo[1]);  // Item category 
			
            strTemp1 = combo[2].split("\\^"); 
			
			vo.setStrIndentTypeId(strTemp1[1]);    // Request Type ID
						
			// Get value from Session

           // String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
	       	
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			
            
			// Calling BO method
			bo.GetData(vo);
			
			
				 	
			bo.CallFunction(vo);
						
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrStoreName(combo[0]);
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrItemCatNo(vo.getStrItemCategory());
			formBean.setStrIndentTypeId(vo.getStrIndentTypeId());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrIndentTypeFunc(vo.getStrIndentTypeFunc());
			formBean.setStrStoreNameFunc(vo.getStrStoreNameFunc());
			formBean.setStrItemCategoryFunc(vo.getStrItemCategoryFunc());
			formBean.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());
			formBean.setStrIndentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrCostRequired("1");
			
			formBean.setStrItemCategoryCmb(vo.getStrItemCategoryCmb());   // Category Combo
			
			formBean.setStrIndentNo("0");
			
			String strItemNameValues = "";
			
			if (vo.getStrBrandItemListWs()!= null && vo.getStrBrandItemListWs().size() > 0) 
			{				   
				strItemNameValues = util.getOptionValue(vo.getStrBrandItemListWs(), "", "", true);
			}
			else 
			{
				strItemNameValues = "<option value='0'>Select Value</option>";
			}	
			
			formBean.setStrItemNameValues(strItemNameValues);	
		}
		  catch (Exception e) 
		  {
            //e.printStackTrace(); 
			strmsgText = "IndentTransADDDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTransADDDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	public static void GetItemDrugList(HttpServletRequest request, HttpServletResponse response,IndentTransADDFB formBean) 
	{
		   /* Declaring Variables */
	       String strmsgText = "";
		   String     strChk = null;
		   String     strRes = null;
		   IndentTransADDBO     bo = null;
		   IndentTransADDVO     vo = null;
		   HisUtil   util = null;
		   String          hosCode = null;
		   String          seatId = null;
		try
		{  
						bo = new IndentTransADDBO();
						vo = new IndentTransADDVO();  		    	         
			          util = new HisUtil("MMSModule", "IndentTransADDDATA");	
			       hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				    seatId = request.getSession().getAttribute("SEATID").toString();     
			
			 String  strItemCategory = request.getParameter("strItemCategory");
			 String  strRequestType  = request.getParameter("strRequestType");
			 String  strFromStoreId  = request.getParameter("strFromStoreId");
			 String  strToStoreId    = request.getParameter("strToStoreId");
			 
			vo.setStrStoreId(strFromStoreId);        //Indent Store ID
			vo.setStrToStore(strToStoreId); 		 // From Store Id
			vo.setStrItemCategory(strItemCategory);  // Item category 			
			vo.setStrIndentTypeId(strRequestType);   // Request Type ID
						
			// Get value from Session        		
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
				
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);            
			// Calling BO method
			bo.GetItemDrugList(vo);			
						
			String strItemNameValues = "";
			
			if (vo.getStrBrandItemListWs()!= null && vo.getStrBrandItemListWs().size() > 0) 
			{				   
				strItemNameValues = util.getOptionValue(vo.getStrBrandItemListWs(), "", "", true);
			}
			else 
			{
				strItemNameValues = "<option value='0'>Select Value</option>";
			}	
			
			if(vo.getStrBrandItemListWs()!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	strRes = strItemNameValues;
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
			if(util != null) util = null;
			if (bo != null)
				bo = null;
		}
    
	}	
	public static void placeRegularIndent(IndentTransADDFB formBean,HttpServletRequest request) 
	{
		IndentTransADDBO bo = null;
		IndentTransADDVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		//Change Request
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;	
		HisUtil            util = null;
		MmsConfigUtil mmsConfig = null;   
		
		try 
		{
			bo = new IndentTransADDBO();
			vo = new IndentTransADDVO();
            System.out.println("In the PlaceRegularIndent");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
				 mmsConfig = new MmsConfigUtil(hosCode);
	          util = new HisUtil("MMSModule", "IndentTransADDDATA");
			
	        
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
			//161114110003@12401108@11@16@0@10@12401107$1
		    //System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
	//		String strIndentPeriod = temp2[0];

			System.out.println("Req No-->>"+temp1[0]);
		  	System.out.println("Store Id-->>"+temp1[1]);
		  	System.out.println("Req Type Id-->>"+temp1[2]);
		
			vo.setStrIndentNo(temp1[0]);
			vo.setStrReqType(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStore(temp2[0]);
			
			//Change Request
            strCurrentDate  = util.getASDate("dd-MM-yyyy");

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
			formBean.setStrStoreId(temp1[1]);
			
         	bo.PLACEREGULARINDENT(vo);
         //	IndentTransADDDAO.GetRecommendByCombo(vo);
         	
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
				str1=IndentTransADDHLP.getItemDetails1(vo);
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDate(strCurrentDate);
			if(temp1[2].equals("86"))
			{
			formBean.setStrIndentTypeId("13");
			//formBean.setStrTmpReqType("13");
			formBean.setStrIndentType("Indent for Issue (Patient Wise)");
			}
			else
			{
				formBean.setStrIndentTypeId("17");
				//formBean.setStrTmpReqType("17");
				formBean.setStrIndentTypeFunc("Indent for Issue (Dept. Wise)");
			}
			vo.getStrItemDetailsWs().beforeFirst();
			vo.getStrItemDetailsWs().next();
			formBean.setStrItemCatNo(temp1[3]);
			formBean.setStrItemCategoryFunc(vo.getStrItemDetailsWs().getString(22));
			formBean.setStrStoreNameFunc(vo.getStrItemDetailsWs().getString(20));
			formBean.setStrStoreId(temp1[1]);
			formBean.setStrToStore(vo.getStrItemDetailsWs().getString(27));
			formBean.setStrToStoreCombo(vo.getStrItemDetailsWs().getString(21));
			//formBean.setStrPatientDtlHidVal(vo.getStrItemDetailsWs().getString(23));
			//formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean.setStrStoreName(temp1[1]);
			//formBean.setStrItemCatg(temp1[3]);
			formBean.setStrStoreTypeId("999");
			//formBean.setStrToStoreCombo(vo.getStrToStore());
			formBean.setStrIndentPeriod(vo.getStrItemDetailsWs().getString(26));
			formBean.setStrIndentPeriodCombo(vo.getStrItemDetailsWs().getString(25));
			
			String path = "/mms"+request.getParameter("cnt_page")+".cnt";
	        if(request.getParameter("cnt_page") == null)
			{
			   path = request.getParameter("strPath");
			   
			}
	        
	        formBean.setStrPath(path.trim());			
	        formBean.setStrReqQty(vo.getStrReqQty());
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentTransADDDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTransADDDATA->placeregluarindent()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Indent for Issue Transaction 
	 * @param formBean
	 * @param request
	 */
	
	public static boolean  INSERT(IndentTransADDFB formBean,HttpServletRequest request) 
	{
		IndentTransADDBO bo = null;
		IndentTransADDVO vo = null;
		HisUtil        util = null;
        boolean    retValue = true;
		MmsConfigUtil   mcu = null;
		String strmsgText;
        String strFinancialStartYear;
        String strFinancialEndYear;
        String hosCode=null;
      
		try 
		{
								  bo = new IndentTransADDBO();
								  vo = new IndentTransADDVO();
				    	          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			    	              mcu = new MmsConfigUtil(hosCode);
				     
					            util = new HisUtil("MMSModule", "IndentTransADDDATA");
			    	 
					  String  seatid = request.getSession().getAttribute("SEATID").toString();
			
		
			String        strReqType = request.getParameter("strIndentTypeId");
			String           strPath = request.getParameter("strPath");
			String        strStoreId = request.getParameter("strStoreId");
			String    strStoreTypeId = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strItemCatNo");
			
		  	   strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrPath(strPath);
	       	/* Setting Value in VO */
			if(formBean.getStrToStoreCombo() != null && !formBean.getStrToStoreCombo().equals("") )
				vo.setStrToStoreCombo(formBean.getStrToStoreCombo());
			else
				vo.setStrToStoreCombo(formBean.getStrToStore());
			vo.setStrReqType(strReqType);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCatNo(strItemCategoryNo);
			vo.setStrFinancialEndYear(strFinancialEndYear);
	        vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			if(formBean.getIsNormal().equals("0"))
			{
				vo.setStrUrgentFlg("1");
			}	
			else
			{
				vo.setStrUrgentFlg("0");
			}	
			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			vo.setStrIndentPeriod(formBean.getStrIndentPeriod());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrBkgEntryDate(util.getASDate("dd-MMM-yyyy"));
			vo.setStrReqQty(formBean.getStrReqQty());			
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrStoreName(formBean.getStrStoreName());
		
			//Change Request
			vo.setStrAvalaibleBudget( (formBean.getStrAvalaibleBudget()!=null && !formBean.getStrAvalaibleBudget().equals("") ) ? formBean.getStrAvalaibleBudget():"0");
			vo.setStrAvalaibleBudgetDtl( (formBean.getStrAvalaibleBudgetDtl()!=null && !formBean.getStrAvalaibleBudgetDtl().equals("") ) ? formBean.getStrAvalaibleBudgetDtl():"0");	
			
			vo.setStrBSReqNo(formBean.getStrBSReqNo());
			
			/* Calling BO Insert method */
			if(vo.getStrReqType().equals("23"))
			{				
				bo.INSERT_NA_NEW(vo);
			}
			else
			{	
		   	    bo.INSERT(vo);
			} 
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;
    			vo.setStrIndentNo("0");
				throw new Exception(vo.getStrMsgString());
				
			}
        	else 
			{
        		formBean.setStrIndentNo(vo.getStrIndentNo());	
				formBean.setStrGenIndentNo(vo.getStrIndentNo());			
				formBean.setStrToStoreId(vo.getStrToStoreCombo());
				
				formBean.setStrMsg("Indent No [ "+vo.getStrIndentNo()+" ] Successfully Raised !!");
				
				
			}
			
		}
		  catch (Exception e) 
		  {

			retValue = false;
            //e.printStackTrace(); 
			strmsgText = "IndentTransADDDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTransADDDATA->INSERT()", strmsgText);
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
	 * Indent for Issue Transaction 
	 * @param formBean
	 * @param request
	 */
	
	public static boolean  INSERT_NEW_FINDER_DATA(IndentTransADDFB formBean,HttpServletRequest request) 
	{
		IndentTransADDBO bo = null;
		IndentTransADDVO vo = null;
		HisUtil        util = null;
        boolean    retValue = true;
		MmsConfigUtil   mcu = null;
		String strmsgText;
        String strFinancialStartYear;
        String strFinancialEndYear;
        String hosCode=null;
      
		try 
		{
								  bo = new IndentTransADDBO();
								  vo = new IndentTransADDVO();
				    	     hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			    	             mcu = new MmsConfigUtil(hosCode);				     
					            util = new HisUtil("MMSModule", "IndentTransADDDATA");			    	 
					  String  seatid = request.getSession().getAttribute("SEATID").toString();
					  
			String        strReqType = request.getParameter("strIndentTypeId");
			String           strPath = request.getParameter("strPath");
			String        strStoreId = request.getParameter("strStoreId");
			String    strStoreTypeId = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strItemCatNo");
			
		  	   strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			 
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrPath(strPath);
	       	/* Setting Value in VO */
			if(formBean.getStrToStoreCombo() != null && !formBean.getStrToStoreCombo().equals("") )
				vo.setStrToStoreCombo(formBean.getStrToStoreCombo());
			else
				vo.setStrToStoreCombo(formBean.getStrToStore());
			vo.setStrReqType(strReqType);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCatNo(strItemCategoryNo);
			vo.setStrFinancialEndYear(strFinancialEndYear);
	        vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			if(formBean.getIsNormal().equals("0"))
			{
				vo.setStrUrgentFlg("1");
			}	
			else
			{
				vo.setStrUrgentFlg("0");
			}	
			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			vo.setStrIndentPeriod(formBean.getStrIndentPeriod());
			vo.setItemUserValue(formBean.getItemUserValue());   //  Pass Item User Value			
			vo.setStrBkgEntryDate(util.getASDate("dd-MMM-yyyy"));
			vo.setStrReqQty(formBean.getStrReqQty());			
			//vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrStoreName(formBean.getStrStoreName());
		
			//Change Request
			vo.setStrAvalaibleBudget( (formBean.getStrAvalaibleBudget()!=null && !formBean.getStrAvalaibleBudget().equals("") ) ? formBean.getStrAvalaibleBudget():"0");
			vo.setStrAvalaibleBudgetDtl( (formBean.getStrAvalaibleBudgetDtl()!=null && !formBean.getStrAvalaibleBudgetDtl().equals("") ) ? formBean.getStrAvalaibleBudgetDtl():"0");	
			
			vo.setStrBSReqNo(formBean.getStrBSReqNo());
			
			vo.setItemParamValue(formBean.getItemParamValue());
			
		    int length = 0;
			
		    /*
	        length = formBean.getItemParamValue().length;
			       // System.out.println("--Length->>"+length);
			for (int k = 0; k < length; k++) 
			{
				
				if (formBean.getItemParamValue()[k] != null && formBean.getItemParamValue()[k].length() > 0	&& !formBean.getItemParamValue()[k].equals("0"))
				{
					//System.out.println("--Item Type-"+k+"->>"+formBean.getStrItemType()[k]);					
					System.out.println("--User Value  -"+k+"->>"+formBean.getItemUserValue()[k]);
					System.out.println("--Req Qty  -->>"+formBean.getStrReqQty()[k]);
					//System.out.println("--ParamValue-->>"+formBean.getItemParamValue()[k]);					
				}
			}
			*/
		    
		    length = vo.getItemParamValue().length;
		       // System.out.println("--Length->>"+length);
			for (int k = 0; k < length; k++) 
			{
				
				if (vo.getItemParamValue()[k] != null && vo.getItemParamValue()[k].length() > 0	&& !vo.getItemParamValue()[k].equals("0"))
				{
					//System.out.println("--Item Type-"+k+"->>"+formBean.getStrItemType()[k]);					
					System.out.println("--User Value  -"+k+"->>"+vo.getItemUserValue()[k]);
					System.out.println("--Req Qty  -->>"+vo.getStrReqQty()[k]);
					//System.out.println("--ParamValue-->>"+formBean.getItemParamValue()[k]);					
				}
			}
	
			
			/* Calling BO Insert method */
			
			if(vo.getStrReqType().equals("23"))
			{				
				bo.INSERT_NA_NEW(vo);
			}
			else
			{	
		   	    bo.INSERT_NEW_FINDER_DATA(vo);
			}
			
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;
    			vo.setStrIndentNo("0");
				throw new Exception(vo.getStrMsgString());
				
			}
        	else 
			{
        		formBean.setStrIndentNo(vo.getStrIndentNo());	
				formBean.setStrGenIndentNo(vo.getStrIndentNo());			
				formBean.setStrToStoreId(vo.getStrToStoreCombo());
				
				formBean.setStrMsg("Indent No [ "+vo.getStrIndentNo()+" ] for "+length+" No of Items Successfully Raised !!");
				
				
			}
			
		}
		  catch (Exception e) 
		  {
			e.printStackTrace();
			retValue = false;
            //e.printStackTrace(); 
			strmsgText = "IndentTransADDDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTransADDDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;

	}
	
	public static void issueDtlsInit(HttpServletRequest request,
			HttpServletResponse response, IndentTransADDFB formBean) 
	{

		String strSearchItemInitView = "";

		IndentTransADDBO bo = null;
		IndentTransADDVO vo = null;

		try 
		{


			String strFromStoreId 	= (String) request.getParameter("fromStoreId");
			String toStoreId 		= (String) request.getParameter("toStoreId");
			String indentNo 		= (String) request.getParameter("indentNo")==null?"0":(String) request.getParameter("indentNo");
							    
			
			bo = new IndentTransADDBO();
			vo = new IndentTransADDVO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrStoreId(strFromStoreId);
			vo.setStrIndentNo(indentNo);			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrToStore(toStoreId);
						
			
			bo.getIssueDtlsInitDtls(vo);  // pkg_mms_view.proc_view_issue_desk_dtl [ Mode - 1 ]

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
			
			strSearchItemInitView = IndentTransADDHLP.getIssueDtlsInitView(formBean,vo);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
	
	public static void certificateNA(HttpServletRequest request,
			HttpServletResponse response, IndentTransADDFB formBean) 
	{

		String strSearchItemInitView = "";

		IndentTransADDBO bo = null;
		IndentTransADDVO vo = null;

		try 
		{


			String strFromStoreId 	= (String) request.getParameter("fromStoreId");
			String toStoreId 		= (String) request.getParameter("toStoreId");
			String indentNo 		= (String) request.getParameter("indentNo")==null?"0":(String) request.getParameter("indentNo");
							    
			
			bo = new IndentTransADDBO();
			vo = new IndentTransADDVO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); // (request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			vo.setStrStoreId(strFromStoreId);
			vo.setStrIndentNo(indentNo);			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrToStore(toStoreId);
						
			
			bo.getIssueDtlsInitDtls(vo);  // pkg_mms_view.proc_view_issue_desk_dtl [ Mode - 1 ]
			
			bo.rejectIndentBczNA(vo);     // PKG_mms_DML.dml_update_indent_for_na_certificate [ Mode - 1 ]

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}				
			
			strSearchItemInitView = IndentTransADDHLP.certificateNA(formBean,vo);
			//System.out.println("strSearchItemInitView" + strSearchItemInitView);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strSearchItemInitView);
		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}

	}
}
