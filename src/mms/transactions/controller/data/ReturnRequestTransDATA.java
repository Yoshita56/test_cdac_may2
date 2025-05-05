package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.ReturnRequestTransBO;
import mms.transactions.controller.fb.ReturnRequestTransFB;
import mms.transactions.vo.ReturnRequestTransVO;

public class ReturnRequestTransDATA 
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData_NEW(ReturnRequestTransFB formBean,HttpServletRequest request) 
	{
		ReturnRequestTransBO bo = null;
		ReturnRequestTransVO vo = null;
		String strmsgText = "";
		HisUtil util = null;		
        String chkValue="";		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		String path = "";
		try 
		{
			bo = new ReturnRequestTransBO();
			vo = new ReturnRequestTransVO();
			util = new HisUtil("ReturnRequestTransDATA", "ReturnRequestTransDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	

					
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
			
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			
			
			bo.GetData(vo);
			
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
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			
	        if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "ReturnRequestTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnRequestTransDATA->GetData()", strmsgText);
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
	public static void GetData(ReturnRequestTransFB formBean,HttpServletRequest request) 
	{
		ReturnRequestTransBO bo = null;
		ReturnRequestTransVO vo = null;
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
			bo = new ReturnRequestTransBO();
			vo = new ReturnRequestTransVO();
			util = new HisUtil("ReturnRequestTransDATA", "ReturnRequestTransDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	

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
			
			strReqType =strTemp1[1];    // Request Type ID
			
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
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			
	        if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "ReturnRequestTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnRequestTransDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to Insert Data in DataBase Table 
	 * Breakage Item Detail Transaction 
	 * @param formBean
	 * @param request
	 */

	public static boolean  INSERT(ReturnRequestTransFB formBean,HttpServletRequest request) 
	{
		ReturnRequestTransBO bo = null;
		ReturnRequestTransVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

	    String strFinancialStartYear = "";

	    String strFinancialEndYear = "";
	    boolean retValue = true;
	    
	    double dblIssueRate=0.0;
	    String strTempPurchaseCostPerc="0.0";
		try 
		{
			bo = new ReturnRequestTransBO();
			vo = new ReturnRequestTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
	       	String hosCode  = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid   = request.getSession().getAttribute("SEATID").toString();
			String strStoreId  = request.getParameter("strTmpStoreName");
			String strItemCatg = request.getParameter("strTmpItemCatg");
			String strReqType  = request.getParameter("strTmpReqType");
			String strPath     = request.getParameter("strPath");
			
			strFinancialStartYear = "01-Apr-2022";
			strFinancialEndYear   = "31-Mar-2023";
			
			dblIssueRate=1.0;
			/*
			if(mcu.getStrIssueRateConfigFlg()!=null && mcu.getStrIssueRateConfigFlg().equals("1"))
			{
				
				dblIssueRate = Float.parseFloat(mcu.getStrConfigIssueRate())/100.0;
				
			}
			else
			{
				dblIssueRate=1.0;
			}
			*/
			//System.out.println("val of length is "+formBean.getStrCost().length);
			for(int i=0;i<formBean.getStrCost().length;i++)
			{
				double strTempNetCost=0.0;
				//System.out.println("formBean.getStrCost()[i])"+formBean.getStrCost()[i]);
				//System.out.println("formBean.getStrCost()[i])"+formBean.getStrCost().toString());
				
				if(formBean.getStrCost()[i] != "" && formBean.getStrCost()[i] != null)
					strTempNetCost=strTempNetCost+(dblIssueRate*Float.parseFloat(formBean.getStrCost()[i].equals("")?"0":formBean.getStrCost()[i])) ;
				
				vo.setStrNetCost(Double.toString(strTempNetCost));
			}
			
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrPath(strPath);	
			 
			vo.setStrUrgetnFlg(formBean.getStrRequestStatusFlg());				
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			//vo.setStrGrantType(formBean.getStrGrantType());
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatg(strItemCatg);
			vo.setStrReqType(strReqType);
			vo.setStrGroupIdForItemSearch(formBean.getStrGroupIdForItemSearch());
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrToStore(formBean.getStrToStore());
		    // Calling BO Method
			bo.INSERT(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				formBean.setStrPath(strPath);
				retValue = false;
				//System.out.println(vo.getStrMsgString());
				//System.out.println(strPath);
				if(vo.getStrMsgString().split("\\##")[1].equals("InSufficent Stock available in Store!!"))
			    {
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
	    		formBean.setStrPath(strPath);
	    		//System.out.println(strPath);
	    		formBean.setStrMsg("Return Request Successfully Raised !!");
			}
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
	        retValue = false;
			strmsgText = "ReturnRequestTransDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReturnRequestTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
      return retValue;
	}
	
	
}



