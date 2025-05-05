package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.transactions.bo.IndentDeskCondemnationReqTransBO;
import mms.transactions.controller.fb.IndentDeskCondemnationReqTransFB;
import mms.transactions.vo.IndentDeskCondemnationReqTransVO;

/**
 * @author Amit Kumar
 * Date of Creation : 27/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentDeskCondemnationReqTransDATA
{
	/**
	 * Method is Used to Populate the Data for Save Page of
	 * Indent Transaciton ADD Page 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(IndentDeskCondemnationReqTransFB formBean,HttpServletRequest request) 
	{
		IndentDeskCondemnationReqTransBO bo = null;
		IndentDeskCondemnationReqTransVO vo = null;
		String                      combo[] = null;
		HisUtil                        util = null;
		String                   strmsgText = "";
		String                    strCtDate = "";
		String                         path = "";
		String[]                    strTemp = null;
		String[]                   strTemp1 = null;
		String                      hosCode = ""; 
		String                       seatId = "";
		
		MmsConfigUtil             mmsConfig = null;
		String              strCostRequired = "";
		try 
		{
			              bo = new IndentDeskCondemnationReqTransBO();
			              vo = new IndentDeskCondemnationReqTransVO();
				          hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				          mmsConfig = new MmsConfigUtil(hosCode);
			            util = new HisUtil("Indent Desk Condemnation ", "IndentDeskCondemnationReqTransFB");
			       strCtDate = util.getASDate("dd-MMM-yyyy");
			 strCostRequired = mmsConfig.getStrCostReq();
			            path = "/mms"+request.getParameter("cnt_page")+".cnt";
			
			if(request.getParameter("cnt_page") == null)
			{
				path = request.getParameter("strPath");
			}
			   combo = request.getParameterValues("combo");
			 strTemp = combo[0].split("\\^");
			strTemp1 = combo[2].split("\\^"); 
			 hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			  seatId = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrPath(path.trim());			
			formBean.setStrReqDate(strCtDate);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
	       	
			vo.setStrStoreId(strTemp[0]);       // Store Id
			vo.setStrStoreTypeId(strTemp[1]);   // Store Type ID
			vo.setStrItemCategory(combo[1]);    // Item category
			vo.setStrIndentTypeId(strTemp1[1]); // Request Type ID
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
            
			/*--- Calling BO Method ---*/
			
			bo.GetData(vo);
		    bo.CallFunction(vo);
		    
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
										

			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
            formBean.setStrStoreId(vo.getStrStoreId());
            formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
            formBean.setStrItemCategory(vo.getStrItemCategory());
            formBean.setStrIndentTypeId(vo.getStrIndentTypeId());
            
            formBean.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrItemCatName(vo.getStrItemCatName());
			formBean.setStrItemTypeCombo(vo.getStrItemTypeCombo());
			formBean.setStrCostRequired(strCostRequired);
			
			
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "ndentDeskCondemnationReqTransDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentDeskCondemnationReqTransDATA->GetData()", strmsgText);
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
	
	public static boolean  INSERT(IndentDeskCondemnationReqTransFB formBean,HttpServletRequest request) 
	{
		/* Declaring Variable */ 
		IndentDeskCondemnationReqTransBO bo = null;
		IndentDeskCondemnationReqTransVO vo = null;
		String                   strmsgText = "";
		MmsConfigUtil                   mcu = null;
		String                      hosCode =  "";
		String                      seatid  = "";
        String        strFinancialStartYear = "";
        String          strFinancialEndYear = "";
        boolean                    retValue = true;
      
		try 
		{
			/* Creating Object */ 
			
			                   bo = new IndentDeskCondemnationReqTransBO();
			                   vo = new IndentDeskCondemnationReqTransVO();
	    	              hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
	    		       //   hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
	    	              mcu = new MmsConfigUtil(hosCode);
			              seatid  = request.getSession().getAttribute("SEATID").toString();
			strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreId() , hosCode);
			strFinancialEndYear   = mcu.getStrFinancialEndDate(formBean.getStrStoreId() , hosCode);
	       	
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrApproxAmt(formBean.getStrApproxAmt());
			vo.setStrStoreId(formBean.getStrStoreId());
			
			vo.setStrStoreTypeId(formBean.getStrStoreTypeId());
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrReqType(formBean.getStrIndentTypeId());
			vo.setItemParamValue(formBean.getItemParamValue());
		    
			vo.setStrToStoreCombo(formBean.getStrToStoreCombo());
		    vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCondemnationQty(formBean.getStrCondemnationQty());
								
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrCostRequired(formBean.getStrCostRequired());
						
			/* Calling IndentDeskCondemnationReqTransBO method  */			
		     bo.INSERT(vo);  
			
    		if (vo.getStrMsgType().equals("1")) 
			{
    			retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
        	else 
			{
				formBean.setStrMsg("Item Saved Successfully");
			}
			
		}
		  catch (Exception e) 
		  {
			  retValue = false;
			  e.printStackTrace();
           
			strmsgText = "IndentDeskCondemnationReqTransDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentDeskCondemnationReqTransDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		}
		  finally 
		  {
			bo   = null;
			
			vo   = null;
		}
		  return retValue;

	}
	

}
