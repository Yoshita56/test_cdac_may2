package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.IndentReturnTransBO;
import mms.transactions.controller.fb.IndentReturnTransFB;
import mms.transactions.controller.hlp.IndentReturnTransHLP;
import mms.transactions.vo.IndentReturnTransVO;

public class IndentReturnTransDATA 
{
	/**
	 * Method is Used to get the Data for view Page of
	 * Indent Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(IndentReturnTransFB formBean,HttpServletRequest request) 
	{
		IndentReturnTransBO bo = null;
		IndentReturnTransVO vo = null;
		String      strmsgText = "";
		String            str1 = "";
		String            str3 = "";
		String          strChk = "";
		String         hosCode = ""; 
		String          seatId = "";
//		String strIndentPeriod = "";
		String[]          temp = null;
		String[]         temp1 = null;
		String[]         temp2 = null;
		String         combo[] = null;
		//String goFlg = "0";
		try 
		{
			      bo = new IndentReturnTransBO();
			      vo = new IndentReturnTransVO();
			 hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			 seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			if(formBean.getStrChk() == null)
			{
				
				strChk = request.getParameter("strChk");
			}
			else
			{	
			    strChk = formBean.getStrChk();
			}    
			           temp = strChk.split("\\^");
			          temp1 = temp[0].split("\\@");
			          temp2 = temp1[6].split("\\$");
	//		strIndentPeriod = temp2[0];
			       
			combo = request.getParameterValues("combo");
			
			vo.setStrItemCategory(combo[1]);  // Item category 
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			formBean.setStrItemCategory(combo[1]);
			formBean.setStrReqNo(temp1[0]);
			formBean.setStrReqTypeId(temp1[2]);
			formBean.setStrStoreId(temp1[1]);
			formBean.setStrToStoreId(temp2[0]);
			
         	bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			str1=IndentReturnTransHLP.getItemDetails(vo);
			
			str3=IndentReturnTransHLP.getIndentDetails(vo);
			
		
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			
			
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentReturnTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentReturnTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/**
	 * Method is Used to get the Data for view Page of
	 * Indent Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData1(IndentReturnTransFB formBean,HttpServletRequest request) 
	{
		IndentReturnTransBO bo = null;
		IndentReturnTransVO vo = null;
		String      strmsgText = "";
		String            str3 = "";
		String          strChk = "";
		String         hosCode = "";
		String          seatId = "";
	//	String strIndentPeriod = "";
		String[]          temp = null;
		String[]         temp1 = null;
		String[]         temp2 = null;
		String         combo[] = null;

		try 
		{
			bo = new IndentReturnTransBO();
			vo = new IndentReturnTransVO();

			 hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			  seatId = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			if(formBean.getStrChk() == null)
			{
				
				strChk = request.getParameter("strChk");
			}
			else
			{	
			    strChk = formBean.getStrChk();
			}    
			     combo = request.getParameterValues("combo");
			
			
			
			

			           temp  = strChk.split("\\^");
			           temp1 = temp[0].split("\\@");
			           temp2 = temp1[6].split("\\$");
		//	 strIndentPeriod = temp2[0];

			vo.setStrItemCategory(combo[1]);  // Item category 
			vo.setStrReqNo(temp1[0]);
			vo.setStrReqTypeId(temp1[2]);
			vo.setStrStoreId(temp1[1]);
			vo.setStrToStoreId(temp2[0]);
			
			formBean.setStrItemCategory(combo[1]);
			formBean.setStrReqNo(temp1[0]);
			formBean.setStrReqTypeId(temp1[2]);
			formBean.setStrStoreId(temp1[1]);
			formBean.setStrToStoreId(temp2[0]);
			
         	bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			str3=IndentReturnTransHLP.getIndentDetails(vo);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			
			
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentReturnTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentReturnTransDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

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
	
	public static boolean INSERT(IndentReturnTransFB formBean,HttpServletRequest request)
	{
		IndentReturnTransBO       bo = null;
		IndentReturnTransVO       vo = null;
		String            strmsgText = "";
		MmsConfigUtil            mcu = null;
        String strFinancialStartYear = "";
        String   strFinancialEndYear = "";
        boolean             retValue = true;
        String               hosCode = "";
        String                seatid = "";
        String              strReqNo = "";
        String               strPath = "";
        String          strReqTypeId = "";
        String            strStoreId = "";
        String          strToStoreId = "";
        String       strItemCategory = "";
        String[]          temp = null;
		String[]         temp1 = null;
		String[]         temp2 = null;
      
		try 
		{
			               
						   bo = new IndentReturnTransBO();
			               vo = new IndentReturnTransVO();
	    	          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
	    	              mcu = new MmsConfigUtil(hosCode);
			           seatid = request.getSession().getAttribute("SEATID").toString();
			     strReqNo     = request.getParameter("strReqNo");
			     strPath      = request.getParameter("strPath");
			     strReqTypeId = request.getParameter("strReqTypeId");
			     strStoreId   = request.getParameter("strStoreId");
			     strToStoreId = request.getParameter("strToStoreId");
			  strItemCategory = request.getParameter("strItemCategory");
			  
// 16		strHiddenValue    = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strItemId+"^"+strItemBrandId+"^"+strStockStatusCode+"^"+strAvlQtyUnit+"^"+strSancQtyUnit;
// 18 		strHiddenValue    = strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strItemId+"^"+strItemBrandId+"^"+strStockStatusCode+"^"+strAvlQtyUnit+"^"+strSancQtyUnit;
			            temp  = formBean.getStrHiddenValue().split("\\^");
			            temp1 = temp[9].split("\\ ");
			            temp2 = temp[10].split("\\ ");
			
			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());
			strFinancialEndYear   = mcu.getStrFinancialEndDate(strStoreId , request.getSession().getAttribute("HOSPITAL_CODE").toString());

			
			vo.setStrItemCategory(strItemCategory);
			vo.setStrAvlQty(temp1[0]);
			vo.setStrSancQty(temp2[0]);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrItemId(temp[3]);
			vo.setStrItemBrandId(temp[4]);
			vo.setStrBatchNo(formBean.getStrBatchNo());
			
			vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
			vo.setStrItemSlNo(formBean.getStrItemSlNo());
			vo.setStrAvlQtyUnit(temp[6]);
			vo.setStrSancQtyUnit(temp[7]);
			
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrToStoreId(strToStoreId);
	       	
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrRemarsks(formBean.getStrRemarks());	
			vo.setStrRecevBy(formBean.getStrReceviedBy());
			
			formBean.setStrPath(strPath);
			formBean.setStrGoFlag("1");
			
			bo.INSERT(vo);
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;
				throw new Exception(vo.getStrMsgString());
				
			}
        	else 
			{
        		
				formBean.setStrNormalMsg("Saved Successfully");
			}
			
		}
		  catch (Exception e) 
		  {
			  retValue = false;
            e.printStackTrace(); 
			strmsgText = "IndentReturnTransDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentReturnTransDATA->INSERT()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
