package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.BudgetAllocationDetailProcessTransBO;
import mms.transactions.bo.RoutinePurchaseBO;
import mms.transactions.controller.fb.BudgetAllocationDetailProcessTransFB;
import mms.transactions.controller.fb.RoutinePurchaseFB;
import mms.transactions.controller.hlp.RoutinePurchaseHLP;
import mms.transactions.vo.BudgetAllocationDetailProcessTransVO;
import mms.transactions.vo.RoutinePurchaseVO;

public class RoutinePurchaseDATA {
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(RoutinePurchaseFB formBean,HttpServletRequest request) 
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String path = "";
		String strCostRequired="";
		HisUtil hisutil=null;
		MmsConfigUtil mmsConfig=null;
		try 
		{
			bo = new RoutinePurchaseBO();
			vo = new RoutinePurchaseVO();
			hisutil = new HisUtil("MMS Transactions", "RoutinePurchaseDATA");
			mmsConfig=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("RoutinePurchaseDATA", "RoutinePurchaseDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	
			strCostRequired=mmsConfig.getStrCostReq();
			
			
			
			/*Here We get Path of Parent Controller*/
	        combo = request.getParameterValues("combo");
			path = "/mms"+request.getParameter("cnt_page")+".cnt";
			if(request.getParameter("cnt_page") == null)
			{
				
				path = request.getParameter("strPath");
			}
			
			
			formBean.setStrPath(path.trim());
	    
	        
			String[] strTemp =  combo[0].split("\\^");
								
			strStoreId = strTemp[0];       // Store Id
			strStoreTypeId = strTemp[1];   // Store Type ID
			strItemCategoryNo = combo[1];  // Item category
					
            String[] strTemp1 =combo[2].split("\\^"); 
			
            strReqType = strTemp1[1];    // Request Type ID
			
			
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			
			
			bo.GetData(vo);
			
		   if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		   
			formBean.setStrItemCatg(vo.getStrItemCatg());
			formBean.setStrTmpItemCatg(strItemCategoryNo);
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrReqDate(strCtDate);
			formBean.setStrTmpReqType(vo.getStrReqType());
			formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			//formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean.setStrCostRequired("1");
			formBean.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());
			
			String strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
		       //vo.setStrCurrentDate(strCurrentDate);
					
		    int strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
		    int CURRENT_YEAR=0;
			if(strCurrentMonth>=4 )
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				      CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
			//formBean.setStrIndentPeriod(mmsConfig.INDENT_PERIOD_ANNUALY);
			formBean.setStrIndentPeriodValue(CURRENT_YEAR+"-"+(CURRENT_YEAR+1));				
			 //strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			 //strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
		  
	     
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "RoutinePurchaseDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 */
	public static void getFinancialYearCombo(RoutinePurchaseFB RoutinePurchaseFB_p,HttpServletRequest request_p)
	{
		RoutinePurchaseBO	RoutinePurchaseBO = null; 
		RoutinePurchaseVO	RoutinePurchaseVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear; 
		
		try {
			RoutinePurchaseBO = new RoutinePurchaseBO();
			RoutinePurchaseVO = new RoutinePurchaseVO();
			
			hisutil = new HisUtil("DWH Transaction","RoutinePurchaseDATA");
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
			
			// For setting the financial year combo
			RoutinePurchaseFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			RoutinePurchaseFB_p.setStrNextFinancialYear(strNextFinancialYear);
			
			
			
		} catch (Exception e) {
			strMsgText = "mms.transactions.RoutinePurchaseDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->getStoreDtls()", strMsgText);
			RoutinePurchaseFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (RoutinePurchaseBO != null)
				RoutinePurchaseBO = null;
			if (RoutinePurchaseVO != null)
				RoutinePurchaseVO = null;
			if (hisutil != null)
				hisutil = null;
		}
		
	}
	
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetDataWithItem(RoutinePurchaseFB formBean,HttpServletRequest request) 
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String path = "";
		String strCostRequired="";
		
		MmsConfigUtil mmsConfig=null;
		try 
		{
			bo = new RoutinePurchaseBO();
			vo = new RoutinePurchaseVO();
			mmsConfig=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("RoutinePurchaseDATA", "RoutinePurchaseDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	
			strCostRequired=mmsConfig.getStrCostReq();
			
			
			
			/*Here We get Path of Parent Controller*/
	        combo = request.getParameterValues("combo");
			path = "/mms"+request.getParameter("cnt_page")+".cnt";
			if(request.getParameter("cnt_page") == null)
			{
				
				path = request.getParameter("strPath");
			}
			
			
			formBean.setStrPath(path.trim());
	    
	        
			String[] strTemp =  combo[0].split("\\^");
								
			strStoreId = strTemp[0];       // Store Id
			strStoreTypeId = strTemp[1];   // Store Type ID
			strItemCategoryNo = combo[1];  // Item category
					
            String[] strTemp1 =combo[2].split("\\^"); 
			
            strReqType = strTemp1[1];    // Request Type ID
			
			
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			
			
			bo.GetData(vo);
			
		   if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		    String strIndentItemList = RoutinePurchaseHLP.getIndentItemList(vo);
		   
		    formBean.setStrIndentItemList(strIndentItemList);
			formBean.setStrItemCatg(vo.getStrItemCatg());
			formBean.setStrTmpItemCatg(strItemCategoryNo);
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrReqDate(strCtDate);
			formBean.setStrTmpReqType(vo.getStrReqType());
			formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			//formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean.setStrCostRequired("1");
			formBean.setStrIndentPeriodCombo(vo.getStrIndentPeriodCombo());
	     
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "RoutinePurchaseDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void ModifyIndentItemList(RoutinePurchaseFB formBean,HttpServletRequest request) 
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String path = "";	
		try 
		{
			bo = new RoutinePurchaseBO();
			vo = new RoutinePurchaseVO();
			
			util = new HisUtil("RoutinePurchaseDATA", "RoutinePurchaseDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			String strChk = formBean.getStrChk();
			
			////System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
			String strIndentPeriod = temp2[0];
			
            vo.setStrChk(formBean.getStrChk());
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);	
				
			/*Here We get Path of Parent Controller*/
	        combo = request.getParameterValues("combo");
			path = "/mms"+request.getParameter("cnt_page")+".cnt";
			if(request.getParameter("cnt_page") == null)
			{
				
				path = request.getParameter("strPath");
			}
			
			
			formBean.setStrPath(path.trim());
	    
	        
			String[] strTemp =  combo[0].split("\\^");
								
			strStoreId = strTemp[0];       // Store Id
			strStoreTypeId = strTemp[1];   // Store Type ID
			strItemCategoryNo = combo[1];  // Item category
					
            String[] strTemp1 =combo[2].split("\\^"); 
			
            strReqType = strTemp1[1];    // Request Type ID
			
			
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			
			
			bo.GetModifyIndent(vo);
			
		   if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		    String strIndentItemList = RoutinePurchaseHLP.getIndentItemListForModify(vo);
		   
		    formBean.setStrIndentItemList(strIndentItemList);
			formBean.setStrItemCatg(vo.getStrItemCatg());
			formBean.setStrTmpItemCatg(strItemCategoryNo);
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrReqDate(strCtDate);
			formBean.setStrTmpReqType(vo.getStrReqType());
			formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
			formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrIndentDetails(RoutinePurchaseHLP.getIndentDetails(vo));
			formBean.setStrChk(vo.getStrChk());
			formBean.setStrChkTmp(vo.getStrChk());
			formBean.setStrIndentDate(vo.getStrIndentDate());
			////System.out.println("Indent Date;;==>"+vo.getStrIndentDate());
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "RoutinePurchaseDATA.ModifyIndentItemList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->ModifyIndentItemList()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

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
	
	public static boolean  INSERT(RoutinePurchaseFB formBean,HttpServletRequest request)
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

        String strFinancialStartYear = "";

        String strFinancialEndYear = "";
        boolean retValue = true;
      
		try 
		{
								  bo = new RoutinePurchaseBO();
								  vo = new RoutinePurchaseVO();
								 mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		   // strFinancialStartYear = mcu.getStrFinancialStartDate();
           // strFinancialEndYear = mcu.getStrFinancialEndDate();
	         
	    	String           hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String           seatid  = request.getSession().getAttribute("SEATID").toString();
			
			String strReqType        = request.getParameter("strTmpReqType");
			String strPath           = request.getParameter("strPath");
			String strStoreId        = request.getParameter("strTmpStoreName");
			String strStoreTypeId    = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
			String strPeriodValue    = request.getParameter("strFinancialYearPeriod");
			
			////System.out.println("strFinancialYearPeriod:::"+request.getParameter("strFinancialYearPeriod"));
			   //strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     //strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     
			if(strPeriodValue!=null && strPeriodValue.equals("")){
				strFinancialStartYear = "01-Apr"+"-" + (strPeriodValue.split("\\-")[0]).trim(); 							
				strFinancialEndYear = "31-Mar"+"-" + (strPeriodValue.split("\\-")[1]).trim();
			}else{
				strFinancialStartYear = "01-Apr"+"-" + (formBean.getStrIndentPeriodValue().split("\\-")[0]).trim(); 							
				strFinancialEndYear = "31-Mar"+"-" + (formBean.getStrIndentPeriodValue().split("\\-")[1]).trim();
			}
			
			
			
			vo.setStrCHMOQty(formBean.getStrCHMOQty());
			vo.setStrMCQty(formBean.getStrMCQty());
			vo.setStrTotalQty(formBean.getStrTotalQty());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			
			vo.setStrIndentPeriod(formBean.getStrIndentPeriod());
			vo.setStrIndentPeriodValue(formBean.getStrIndentPeriodValue());
			
			if(formBean.getStrIsNormal().equals("0"))
			{
				vo.setStrIsUrgent("1");
			}	
			else
			{
				vo.setStrIsUrgent("0");
	        }	
			vo.setStrCostRequired(formBean.getStrCostRequired());
			vo.setStrTotalCost(formBean.getStrApproxAmtTotal());
			//vo.setStrGrantTypeCombo(formBean.getStrGrantType());
			vo.setStrPath(strPath);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setItemUserValue(formBean.getItemUserValue());
			//vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrToStoreCombo(formBean.getStrToStore());
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrPath(vo.getStrPath());
			formBean.setStrSeatId(seatid);
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
								
			bo.INSERT(vo);
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;    			
				throw new Exception(vo.getStrMsgString());
				
			}
        	else 
			{
        		formBean.setStrMsg("Indent Successfully Raised!!");
			}
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
            retValue = false;
			strmsgText = "RoutinePurchaseDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->INSERT()", strmsgText);
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
	
	public static boolean  MODIFY(RoutinePurchaseFB formBean,HttpServletRequest request)
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
//        String strFinancialStartYear = "";
//        String strFinancialEndYear = "";
        boolean retValue = true;      
		try 
		{
								  bo = new RoutinePurchaseBO();
								  vo = new RoutinePurchaseVO();
								 mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		   // strFinancialStartYear = mcu.getStrFinancialStartDate();
           // strFinancialEndYear = mcu.getStrFinancialEndDate();
	         
	    	String           hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String           seatid  = request.getSession().getAttribute("SEATID").toString();
			
			String strReqType        = request.getParameter("strTmpReqType");
			String strPath           = request.getParameter("strPath");
			String strStoreId        = request.getParameter("strTmpStoreName");
			String strStoreTypeId    = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
//			   strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
//			     strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
//			for(int i=0;i<formBean.getStrCHMOQty().length;i++)
//			{
//				//System.out.println("CHM Qty :::"+formBean.getStrCHMOQty()[i]);
//				//System.out.println("MC Qty :::"+formBean.getStrMCQty()[i]);
//				//System.out.println("Total Qty :::"+formBean.getStrTotalQty()[i]);
//				//System.out.println("Item wise Cost:::"+formBean.getStrApproxAmt()[i]);
//				//System.out.println("Item Param Value:::"+formBean.getItemParamValue()[i]);
//	
//			}
			String strChk = formBean.getStrChk();
			////System.out.println("strChk-"+strChk);
			String[] temp  = strChk.split("\\^");
			String[] temp1 = temp[0].split("\\@");
			String[] temp2 = temp1[6].split("\\$");
			String strIndentPeriod = temp2[0];
			////System.out.println("Req No-->>"+temp1[0]);
			////System.out.println("Store Id-->>"+temp1[1]);
			////System.out.println("Req Type Id-->>"+temp1[2]);
			formBean.setStrChkTmp(vo.getStrChk());
			formBean.setStrChkTmp(strChk);

			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
            vo.setStrChk(formBean.getStrChk());
			vo.setStrCHMOQty(formBean.getStrCHMOQty());
			vo.setStrMCQty(formBean.getStrMCQty());
			vo.setStrTotalQty(formBean.getStrTotalQty());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			vo.setStrTotalCost(formBean.getStrApproxAmtTotal());
			vo.setStrPath(strPath);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrRemarks(formBean.getStrRemarks());
		    formBean.setStrHospitalCode(hosCode);
			formBean.setStrPath(vo.getStrPath());
			formBean.setStrSeatId(seatid);
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
								
			bo.MODIFY(vo);
			
			
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;    			
				throw new Exception(vo.getStrMsgString());
				
			}
    		
			        	
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
            retValue = false;
			strmsgText = "RoutinePurchaseDATA.MODFIY(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->MODFIY()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	
	
	/**
	 * Method is Used to UPDATE Indent
	 * @param formBean
	 * @param request
	 */
	
	public static boolean  UPDATE(RoutinePurchaseFB formBean,HttpServletRequest request)
	{
		RoutinePurchaseBO bo = null;
		RoutinePurchaseVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

        String strFinancialStartYear = "";

        String strFinancialEndYear = "";
        boolean retValue = true;
      
		try 
		{
								  bo = new RoutinePurchaseBO();
								  vo = new RoutinePurchaseVO();
								 mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());	         
	    	String           hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String           seatid  = request.getSession().getAttribute("SEATID").toString();			
			String       strReqType  = request.getParameter("strTmpReqType");
			String          strPath  = request.getParameter("strPath");
			String       strStoreId  = request.getParameter("strTmpStoreName");
			String   strStoreTypeId  = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
			   strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			     strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String            strChk = formBean.getStrChkTmp();
//			//System.out.println("strChk-"+strChk);
			String[]           temp  = strChk.split("\\^");
			String[]           temp1 = temp[0].split("\\@");
			String[]           temp2 = temp1[6].split("\\$");
			String   strIndentPeriod = temp2[0];

//			for(int i=0;i<formBean.getStrCHMOQty().length;i++)
//			{
//				 if(!formBean.getStrTotalQty()[i].equals("0"))
//				 {	 
//					//System.out.println("Index::::"+i+"CHM Qty :::"+formBean.getStrCHMOQty()[i]);
//					//System.out.println("Index::::"+i+"MC Qty :::"+formBean.getStrMCQty()[i]);
//					//System.out.println("Index::::"+i+"Total Qty :::"+formBean.getStrTotalQty()[i]);
//					//System.out.println("Index::::"+i+"Item wise Cost:::"+formBean.getStrApproxAmt()[i]);
//					//System.out.println("Index::::"+i+"Rate:::"+formBean.getItemParamValue()[i].split("\\#")[0]);
//					//System.out.println("Index::::"+i+"Rate Unit:::"+formBean.getItemParamValue()[i].split("\\#")[1]);
//				 }
//			}			
//			//System.out.println("Indent Status:::"+formBean.getStrIndentStatus());
			////System.out.println("Inden Date==>"+formBean.getStrTmpIndentDate());
			vo.setStrTmpIndentDate(formBean.getStrTmpIndentDate());
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);			
            vo.setStrChk(formBean.getStrChk());
            
			vo.setStrCHMOQty(formBean.getStrCHMOQty());
			vo.setStrMCQty(formBean.getStrMCQty());
			vo.setStrTotalQty(formBean.getStrTotalQty());
			vo.setStrApproxAmt(formBean.getStrApproxAmt());	   //Item Cost		
			vo.setStrTotalCost(formBean.getStrApproxAmtTotal());// Total Cost
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setItemId(formBean.getItemId());
			vo.setItemBrandId(formBean.getItemBrandId());
			vo.setStrPath(strPath);
			vo.setStrStoreId(strStoreId);
			vo.setStrReqType(strReqType);
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIndentStatus(formBean.getStrIndentStatus());
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrPath(vo.getStrPath());
			formBean.setStrSeatId(seatid);
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
								
			bo.UPDATE(vo);
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;    			
				throw new Exception(vo.getStrMsgString());
				
			}
        	else 
			{
        		formBean.setStrMsg("Indent Successfully Raised!!");
        		formBean.setStrChk(vo.getStrChk());
        		formBean.setStrChkTmp(vo.getStrChk());
        		formBean.setStrPath(vo.getStrPath());
			}
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
            retValue = false;
			strmsgText = "RoutinePurchaseDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RoutinePurchaseDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	

}
