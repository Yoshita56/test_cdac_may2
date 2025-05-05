package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.RequestForContigencyBO;
import mms.transactions.controller.fb.RequestForContigencyFB;
import mms.transactions.vo.RequestForContigencyVO;

public class RequestForContigencyDATA {
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Issue To Patient Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(RequestForContigencyFB formBean,HttpServletRequest request) 
	{
		RequestForContigencyBO bo = null;
		RequestForContigencyVO vo = null;
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
			bo = new RequestForContigencyBO();
			vo = new RequestForContigencyVO();
			mmsConfig=new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("RequestForContigencyDATA", "RequestForContigencyDATA");
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
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean.setStrCostRequired(strCostRequired);
	     
			
			
		}
		  catch (Exception e) 
		  {
	        e.printStackTrace(); 
			strmsgText = "RequestForContigencyDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForContigencyDATA->GetData()", strmsgText);
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
	
	public static boolean  INSERT(RequestForContigencyFB formBean,HttpServletRequest request)
	{
		RequestForContigencyBO bo = null;
		RequestForContigencyVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;

        String strFinancialStartYear = "";

        String strFinancialEndYear = "";
        boolean retValue = true;
      
		try 
		{
			bo = new RequestForContigencyBO();
			vo = new RequestForContigencyVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		   // strFinancialStartYear = mcu.getStrFinancialStartDate();
           // strFinancialEndYear = mcu.getStrFinancialEndDate();
	         
	    	String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid  = request.getSession().getAttribute("SEATID").toString();
			
			String strReqType     = request.getParameter("strTmpReqType");
			String strPath        = request.getParameter("strPath");
			String strStoreId     = request.getParameter("strTmpStoreName");
			String strStoreTypeId = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			strFinancialEndYear   = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			/*
			//System.out.println("Grant Type-->>>"+formBean.getStrGrantType());
			//System.out.println("Normal -->>>"+formBean.getStrIsNormal());
			//System.out.println("Urgent -->>>"+formBean.getStrIsUrgent());
			//System.out.println("Total Cost-->>>"+formBean.getStrApproxAmt());
			*/
			if(formBean.getStrIsNormal().equals("0"))
			{
				vo.setStrIsUrgent("1");
			}	
			else
			{
				vo.setStrIsUrgent("0");
	        }	
			
			vo.setStrTotalCost(formBean.getStrApproxAmt());
			vo.setStrGrantTypeCombo(formBean.getStrGrantType());
			vo.setStrPath(strPath);
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
			strmsgText = "RequestForContigencyDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForContigencyDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	
	

	}
