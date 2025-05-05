package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.RequestForLPDeptBO;
import mms.transactions.controller.fb.RequestForLPDeptFB;
import mms.transactions.vo.RequestForLPDeptVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/May/2009
 * Modif Date : / /2009 
*/
public class RequestForLPDeptDATA 
{
	
	
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData_NEW(RequestForLPDeptFB formBean,HttpServletRequest request) 
	{
		RequestForLPDeptBO bo = null;
		RequestForLPDeptVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String  strStoreId ="";
		String  strStoreTypeId="";
		String  strReqType = "";
		String  strItemCategoryNo ="";
		
		String strCostRequired="";	
		String path="";
		String scmInt="";
		String chkValue="";
		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		try 
		{
			bo = new RequestForLPDeptBO();
			vo = new RequestForLPDeptVO();
			util = new HisUtil("RequestForLPDeptDATA", "RequestForLPDeptDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;	

			/*Here We get Path of Parent Controller*/
	        //combo = request.getParameterValues("combo");
			
			
			formBean.setStrPath(path.trim());
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
	        
	        // storeId+"@"+catgId+"@"+reqTypeId+"@"+CrNo
								
			strStoreId 		  = chkValue.split("\\@")[0];   // Store Id			
			strItemCategoryNo = chkValue.split("\\@")[1];  	// Item category		
			strReqType 		  = chkValue.split("\\@")[2];   // Request Type ID
			
			
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
			strmsgText = "RequestForLPDeptDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPDeptDATA->GetData()", strmsgText);
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
public static void GetData(RequestForLPDeptFB formBean,HttpServletRequest request) 
{
	RequestForLPDeptBO bo = null;
	RequestForLPDeptVO vo = null;
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
		bo = new RequestForLPDeptBO();
		vo = new RequestForLPDeptVO();
		util = new HisUtil("RequestForLPDeptDATA", "RequestForLPDeptDATA");
		String strCtDate = util.getASDate("dd-MMM-yyyy");
		util = null;	

		/*Here We get Path of Parent Controller*/
        combo = request.getParameterValues("combo");
		
		
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
		strmsgText = "RequestForLPDeptDATA.GetData(vo) --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"RequestForLPDeptDATA->GetData()", strmsgText);
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

public static boolean  INSERT(RequestForLPDeptFB formBean,HttpServletRequest request) 
{
	RequestForLPDeptBO bo = null;
	RequestForLPDeptVO vo = null;
	String strmsgText = "";
	MmsConfigUtil mcu = null;

    String strFinancialStartYear = "";

    String strFinancialEndYear = "";
    boolean retValue = true;
	try 
	{
		bo = new RequestForLPDeptBO();
		vo = new RequestForLPDeptVO();
		mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	
	   // strFinancialStartYear = mcu.getStrFinancialStartDate();
       // strFinancialEndYear = mcu.getStrFinancialEndDate();
         
                
    	String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String seatid = request.getSession().getAttribute("SEATID").toString();
		
		String strReqType = request.getParameter("strTmpReqType");
		String strPath = request.getParameter("strPath");
		String strStoreId = request.getParameter("strTmpStoreName");
		String strStoreTypeId = request.getParameter("strStoreTypeId");
		String strItemCategoryNo = request.getParameter("strTmpItemCatg");
		strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
		strFinancialEndYear   = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());

		
		String status = "";
		
		if(formBean.getStrIsNormal().equals("1"))
	    {
			status = "0";
	    }	
	    else
	    {
	    	status = "1";
	    }	
		
		vo.setStrToStoreCombo(formBean.getStrToStore());
		vo.setStrUregentFlg(status);
		vo.setStrStoreId(strStoreId);
		vo.setStrStoreTypeId(strStoreTypeId);
		vo.setStrItemCategoryNo(strItemCategoryNo);
		vo.setStrReqType(strReqType);
		vo.setItemParamValue(formBean.getItemParamValue());
		vo.setStrUnitName(formBean.getStrUnitName());
		vo.setStrRemarks(formBean.getStrRemarks());
		vo.setStrReqQty(formBean.getStrReqQty());
		vo.setStrFinancialEndYear(strFinancialEndYear);
		vo.setStrFinancialStartYear(strFinancialStartYear);
		vo.setStrToStoreCombo(formBean.getStrToStore());
		formBean.setStrHospitalCode(hosCode);
		formBean.setStrSeatId(seatid);
       	vo.setStrHospitalCode(hosCode);
		vo.setStrSeatId(seatid);
							
		 bo.INSERT(vo);
		
		if (vo.getStrMsgType().equals("1")) 
		{
			formBean.setStrPath(strPath);
			retValue = false;
			throw new Exception(vo.getStrMsgString());
		}
    	else 
		{
    		formBean.setStrPath(strPath);
    		formBean.setStrMsg("Indent Successfully Raised!!");
		}
		
	}
	  catch (Exception e) 
	  {
        e.printStackTrace(); 
        retValue = false;
		strmsgText = "BreakgeItemDtlTransDATA.INSERT(vo) --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"BreakgeItemDtlTransDATA->INSERT()", strmsgText);
		formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

		eObj = null;
	} finally {
		bo = null;
		vo = null;
	}
   return retValue;
}






}
