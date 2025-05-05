package mms.transactions.controller.data;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.BudgetAllocationDetailProcessTransBO;
import mms.transactions.controller.fb.BudgetAllocationDetailProcessTransFB;
import mms.transactions.vo.BudgetAllocationDetailProcessTransVO;

public class BudgetAllocationDetailProcessTransDATA {
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 */
	public static void getFinancialYearCombo(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request_p)
	{
		BudgetAllocationDetailProcessTransBO	budgetAllocationDetailProcessTransBO = null; 
		BudgetAllocationDetailProcessTransVO	budgetAllocationDetailProcessTransVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear; 
		
		try {
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();
			
			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");
			
			/*if(request.getParameter("mode") != null){
				
				String strMode = request.getParameter("mode");
				formBean.setStrMode(strMode);
				
			}*/
			
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
			budgetAllocationDetailProcessTransFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			budgetAllocationDetailProcessTransFB_p.setStrNextFinancialYear(strNextFinancialYear);
			
			
			
		} catch (Exception e) {
			strMsgText = "mms.transactions.BudgetAllocationDetailProcessTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BudgetAllocationDetailProcessTransDATA->getStoreDtls()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (budgetAllocationDetailProcessTransBO != null)
				budgetAllocationDetailProcessTransBO = null;
			if (budgetAllocationDetailProcessTransVO != null)
				budgetAllocationDetailProcessTransVO = null;
			if (hisutil != null)
				hisutil = null;
		}
		
	}
	
	
	
	public static void getDrugWareHouseNameCombo(BudgetAllocationDetailProcessTransFB formBean, HttpServletRequest request) {

		BudgetAllocationDetailProcessTransBO bo = null;
		BudgetAllocationDetailProcessTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new BudgetAllocationDetailProcessTransBO();
			vo = new BudgetAllocationDetailProcessTransVO();

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			
			
				vo.setStrMode("4");
			
			
			
			bo.getDrugWareHouseNameCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "BudgetAllocationDetailProcessTransDATA");
			
			if(vo.getWrsDrugWareHouseNameCmb()!=null && vo.getWrsDrugWareHouseNameCmb().size()>0)
			{
				if(vo.getWrsDrugWareHouseNameCmb().next())
				{
					vo.setStrDrugWareHouseNameCmb(vo.getWrsDrugWareHouseNameCmb().getString(1));
					vo.getWrsDrugWareHouseNameCmb().beforeFirst();
				}
				
				if(formBean.getStrStoreId()!=null && !formBean.getStrStoreId().equals(""))
				{
					strStoreVal = util.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), formBean.getStrStoreId(),"0^Select Value", false);
				}
				else
				{
					strStoreVal = util.getOptionValue(vo.getWrsDrugWareHouseNameCmb(), "","0^Select Value", false);
				}
				
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrDrugWareHouseNameCmb(strStoreVal);
			
			
			
		} catch (Exception e) {
			strMsgText = "mms.transactions.BudgetAllocationDetailProcessTransDATA.getDrugWareHouseNameCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BudgetAllocationDetailProcessTransDATA->getDrugWareHouseNameCombo()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	
	public static void getDWHSubTypeCombo(BudgetAllocationDetailProcessTransFB formBean, HttpServletRequest request) {

		BudgetAllocationDetailProcessTransBO bo = null;
		BudgetAllocationDetailProcessTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strMsgText = null;
		
		try {
			bo = new BudgetAllocationDetailProcessTransBO();
			vo = new BudgetAllocationDetailProcessTransVO();

			
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			//vo.setStrSupplierId(request.getParameter("supplierId"));
					
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getDWHSubTypeCombo(vo);
	
			
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "BudgetAllocationDetailProcessTransDATA");
			
				
				if(vo.getWrsDWHSubTypeCmb()!=null && vo.getWrsDWHSubTypeCmb().size()>0)
				{
					strStoreVal = util.getOptionValue(vo.getWrsDWHSubTypeCmb(),formBean.getStrDWHSubTypeId(),"0^All", false);
				}
				else
				{
					strStoreVal = "<option value='0'>Select Value</option>";
				}				
				
			formBean.setStrDWHSubTypeCmb(strStoreVal);
			
			
			
		}
		catch (Exception e) 
		{
			strMsgText = "mms.transactions.BudgetAllocationDetailProcessTransDATA.getDWHSubTypeCombo --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BudgetAllocationDetailProcessTransDATA->getDWHSubTypeCombo()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	/**
	 * Get Financial Combo View Page
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getDWHSubStoreCmb(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request, HttpServletResponse response)
	{
		BudgetAllocationDetailProcessTransBO budgetAllocationDetailProcessTransBO = null;
		BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO = null;
		
		String strSubStoreCmb;
		String strMsgText = "";
		
		HisUtil hisutil=null;
		try 
		{
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();
			
			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");
			budgetAllocationDetailProcessTransVO.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			budgetAllocationDetailProcessTransVO.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			 if((budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag())==null || budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag().equals("") || budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag().equals("0"))
			 {
					budgetAllocationDetailProcessTransVO.setStrStoreId( (request.getParameter("storeId")==null)?"0": request.getParameter("storeId"));
					budgetAllocationDetailProcessTransVO.setStrStoreSubType( (request.getParameter("dwhSubTypeId")==null)?"0":request.getParameter("dwhSubTypeId") );
			 }
			 else
			 {
				 budgetAllocationDetailProcessTransVO.setStrStoreId(budgetAllocationDetailProcessTransFB_p.getStrDrugWareHouseName());
				 budgetAllocationDetailProcessTransVO.setStrStoreSubType(budgetAllocationDetailProcessTransFB_p.getStrDWHSubTypeId());
			 }
		
			
			
			budgetAllocationDetailProcessTransBO.getDWHSubStoreCmb(budgetAllocationDetailProcessTransVO);
			
			
			if (budgetAllocationDetailProcessTransVO.getWrsDWHSubStoreCmb() != null && budgetAllocationDetailProcessTransVO.getWrsDWHSubStoreCmb().size() > 0) 
			{
				strSubStoreCmb = hisutil.getOptionValue(budgetAllocationDetailProcessTransVO.getWrsDWHSubStoreCmb(), budgetAllocationDetailProcessTransFB_p.getStrSubStoreId(),"0^All", false);
				////System.out.println("budgetAllocationDetailProcessTransFB_p.getStrSubStoreId()"+budgetAllocationDetailProcessTransFB_p.getStrSubStoreId());
			}
			
			else
			{
				strSubStoreCmb = "<option value='0'>Select Value</option>";
			}
			
			 response.setHeader("Cache-Control", "no-cache");
			 
			 ////System.out.println("budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag():::"+budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag());
			 
			 if((budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag())==null || budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag().equals("") || budgetAllocationDetailProcessTransFB_p.getStrGoDetailsFlag().equals("0"))				 
    		 response.getWriter().print(strSubStoreCmb);
			
			 else
			 {
				 budgetAllocationDetailProcessTransFB_p.setStrSubStoreCmb(strSubStoreCmb);
				 
				 String strTempSubStoreId=budgetAllocationDetailProcessTransFB_p.getStrSubStoreId();
//					String strTempStoreId = budgetAllocationDetailProcessTransFB_p.getStrStoreId();
					
//					if(strTempStoreId!=null)
//					{
//						budgetAllocationDetailProcessTransFB_p.setStrDrugWareHouseName(strTempStoreId);
//					}
					
					if(strTempSubStoreId!=null)
					{
						budgetAllocationDetailProcessTransFB_p.setStrSubStoreId(strTempSubStoreId);
					}
				 
			 }
    		 
			
			if (budgetAllocationDetailProcessTransVO.getStrMsgType().equals("1")) {
				throw new Exception(budgetAllocationDetailProcessTransVO.getStrMsgString());
			}
			
			
		} 
		catch (Exception e) 
		{
			strMsgText = "BudgetAllocationDetailProcessTransDATA.getDWHSubStoreCmb(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getDWHSubStoreCmb()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			budgetAllocationDetailProcessTransBO = null;
			budgetAllocationDetailProcessTransVO = null;
		}
	
	}
	
	public static void getPrevBudgetDtls(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response_p) 
	{
		
		BudgetAllocationDetailProcessTransBO	budgetAllocationDetailProcessTransBO = null; 
		BudgetAllocationDetailProcessTransVO	budgetAllocationDetailProcessTransVO  = null;
		String strFinancialYear;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strCurrentDate;
		
		
		String strCurrentFinancialYear;
		String strNextFinancialYear; 
		String strHospitalCode;
		
		String strTempPrevYrBudget="";
		
		try {
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();
			
			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");
			
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
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
			
			strFinancialYear =	budgetAllocationDetailProcessTransFB_p.getStrFinancialYear();
				
			if(strFinancialYear!=null)
			{
				
				
				if(strFinancialYear.equals("1"))
				{
					strTempPrevYrBudget = strCurrentFinancialYear;
				}
				else if(strFinancialYear.equals("2"))
				{
					strTempPrevYrBudget = strNextFinancialYear;
				}

				budgetAllocationDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[0].trim() ) ));
				budgetAllocationDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strTempPrevYrBudget.split("\\-")[1].trim() ) ));
				
			}
			
			budgetAllocationDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
			budgetAllocationDetailProcessTransVO.setStrSubStoreId(budgetAllocationDetailProcessTransFB_p.getStrSubStoreId());
						
			
			//CALLING BO
			budgetAllocationDetailProcessTransBO.getLastAllocatedBudgetDtls(budgetAllocationDetailProcessTransVO);//Initial Budget
			
			if(budgetAllocationDetailProcessTransVO.getStrMsgType().equals("1"))
			{
				throw new Exception();
			}
			
			if(budgetAllocationDetailProcessTransVO.getWrsData()!=null && budgetAllocationDetailProcessTransVO.getWrsData().size()>0)
			{
				
				if(budgetAllocationDetailProcessTransVO.getWrsData().next()){
					
				budgetAllocationDetailProcessTransFB_p.setStrPreviousYearRemainingBudget(budgetAllocationDetailProcessTransVO.getWrsData().getString(1).toString());
				budgetAllocationDetailProcessTransFB_p.setStrLastAllocatedBudget(budgetAllocationDetailProcessTransVO.getWrsData().getString(2).toString());
				budgetAllocationDetailProcessTransFB_p.setStrCurrentYearTotalBudget(budgetAllocationDetailProcessTransVO.getWrsData().getString(3).toString());
				budgetAllocationDetailProcessTransFB_p.setStrCurrentYearUtilizedBudget(budgetAllocationDetailProcessTransVO.getWrsData().getString(4).toString());
				}
			}
			else
			{
				budgetAllocationDetailProcessTransFB_p.setStrPreviousYearRemainingBudget("0");
				budgetAllocationDetailProcessTransFB_p.setStrLastAllocatedBudget("0");
				budgetAllocationDetailProcessTransFB_p.setStrCurrentYearTotalBudget("0");
				budgetAllocationDetailProcessTransFB_p.setStrCurrentYearUtilizedBudget("0");
				budgetAllocationDetailProcessTransFB_p.setStrNewAllocatedBudget("");
				budgetAllocationDetailProcessTransFB_p.setStrModifiedAllocatedBudget("");
			}
		
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
			strMsgText = "mms.transactions.BudgetAllocationDetailProcessTransDATA.getPrevBudgetDtls --> " + e.getMessage();
			HisException eObj = new HisException("mms",	"BudgetAllocationDetailProcessTransDATA->getPrevBudgetDtls()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} 
		finally 
		{

			if (budgetAllocationDetailProcessTransBO != null)
				budgetAllocationDetailProcessTransBO = null;
			
			if (budgetAllocationDetailProcessTransVO != null)
				budgetAllocationDetailProcessTransVO = null;
			
			if (hisutil != null)
				hisutil = null;
		}
	}


	public static void saveBudgetDtls(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		BudgetAllocationDetailProcessTransBO budgetAllocationDetailProcessTransBO = null;
		BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO = null;
		String strMsgText = "";
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strCurrentDate;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear; 
		
		String strFinancialYear;
		
		String strTempBudget="";
		
		String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
		
		try {
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();

			if(budgetAllocationDetailProcessTransFB_p.getStrRemarks()==null || budgetAllocationDetailProcessTransFB_p.getStrRemarks().equals(""))
			{
				budgetAllocationDetailProcessTransFB_p.setStrRemarks("");
			}

			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");
			
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
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
			
			strFinancialYear =	budgetAllocationDetailProcessTransFB_p.getStrFinancialYear();
				
			if(strFinancialYear!=null)
			{
				
				
				if(strFinancialYear.equals("1"))
				{
					strTempBudget = strCurrentFinancialYear;
				}
				else if(strFinancialYear.equals("2"))
				{
					strTempBudget = strNextFinancialYear;
				}

				budgetAllocationDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strTempBudget.split("\\-")[0].trim() )));
				budgetAllocationDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strTempBudget.split("\\-")[1].trim() )));
				
			}
			
			budgetAllocationDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
			budgetAllocationDetailProcessTransVO.setStrDrugWareHouseName(budgetAllocationDetailProcessTransFB_p.getStrDrugWareHouseName());//Store Id
			budgetAllocationDetailProcessTransVO.setStrDWHSubTypeId(budgetAllocationDetailProcessTransFB_p.getStrDWHSubTypeId());
			budgetAllocationDetailProcessTransVO.setStrSubStoreId(budgetAllocationDetailProcessTransFB_p.getStrSubStoreId());
		
			budgetAllocationDetailProcessTransVO.setStrNewAllocatedBudget(budgetAllocationDetailProcessTransFB_p.getStrNewAllocatedBudget());
			budgetAllocationDetailProcessTransVO.setStrRemarks(budgetAllocationDetailProcessTransFB_p.getStrRemarks());
			
			budgetAllocationDetailProcessTransVO.setStrSeatId(strSeatId);	//from session
			budgetAllocationDetailProcessTransVO.setStrIsValid("1");
			
		
			if(budgetAllocationDetailProcessTransFB_p.getStrNewAllocatedBudget()!=null && budgetAllocationDetailProcessTransFB_p.getStrNewAllocatedBudget().length()>0)
			{
				budgetAllocationDetailProcessTransVO.setStrMode("2");
			}
			else
			{
				budgetAllocationDetailProcessTransVO.setStrNewAllocatedBudget(budgetAllocationDetailProcessTransFB_p.getStrModifiedAllocatedBudget());
				budgetAllocationDetailProcessTransVO.setStrMode("1");

			}
			
			
			//CALLING BO
			budgetAllocationDetailProcessTransBO.insertRecord(budgetAllocationDetailProcessTransVO);
			
			
			if (budgetAllocationDetailProcessTransVO.getStrMsgType().equals("1")) {
				throw new Exception(budgetAllocationDetailProcessTransVO.getStrMsgString());
			}

				budgetAllocationDetailProcessTransFB_p.setStrNormalMsg("Record Saved Successfully!");
				budgetAllocationDetailProcessTransFB_p.setStrStoreId("0");
				budgetAllocationDetailProcessTransFB_p.setStrDWHSubTypeId("0");;
				budgetAllocationDetailProcessTransFB_p.setStrSubStoreId("0");
								
				budgetAllocationDetailProcessTransFB_p.setStrNewAllocatedBudget("");
				budgetAllocationDetailProcessTransFB_p.setStrModifiedAllocatedBudget("");
				
				budgetAllocationDetailProcessTransFB_p.setStrRemarks("");
		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strMsgText = "BudgetAllocationDetailProcessTransDATA.insertRecord(budgetAllocationDetailProcessTransVO) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "BudgetAllocationDetailProcessTransDATA->insertRecord()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			budgetAllocationDetailProcessTransBO = null;
			budgetAllocationDetailProcessTransVO = null;
		}		
	}


	/**
	 * Get Financial Combo View Page
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 * @param response
	 */
	public static void getFinancialComboViewPage(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response)
	{
		BudgetAllocationDetailProcessTransBO budgetAllocationDetailProcessTransBO = null;
		BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO = null;
		
		String strFinancialYearCmb;
		String strMsgText = "";
		String	strHospitalCode;
		HisUtil hisutil=null;
		try {
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");


			budgetAllocationDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
			
			budgetAllocationDetailProcessTransBO.getFinancialYearComboForViewPage(budgetAllocationDetailProcessTransVO);
			
			
			if (budgetAllocationDetailProcessTransVO.getWrsFinancialYearCmb() != null && budgetAllocationDetailProcessTransVO.getWrsFinancialYearCmb().size() > 0) 
			{
				strFinancialYearCmb = hisutil.getOptionValue(budgetAllocationDetailProcessTransVO.getWrsFinancialYearCmb(), "","0^Select Value", false);
			}
			
			else
			{
				strFinancialYearCmb = "<option value='0'>Select Value</option>";
			}
			
			budgetAllocationDetailProcessTransFB_p.setStrFinancialYearCombo(strFinancialYearCmb);
			
			
			if (budgetAllocationDetailProcessTransVO.getStrMsgType().equals("1")) {
				throw new Exception(budgetAllocationDetailProcessTransVO.getStrMsgString());
			}
			
			
		} 
		catch (Exception e) 
		{
			strMsgText = "BudgetAllocationDetailProcessTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->modifyRecord()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			budgetAllocationDetailProcessTransBO = null;
			budgetAllocationDetailProcessTransVO = null;
		}
	
	
	}
	

	public static void getViewDetails(BudgetAllocationDetailProcessTransFB budgetAllocationDetailProcessTransFB_p,HttpServletRequest request_p, HttpServletResponse response) 
	{
		BudgetAllocationDetailProcessTransBO budgetAllocationDetailProcessTransBO = null;
		BudgetAllocationDetailProcessTransVO budgetAllocationDetailProcessTransVO = null;
		

		String strBudgetDetailsTable;
		String strMsgText = "";
		String	strHospitalCode;
		String strFinancialYear;
		HisUtil hisutil=null;
		try {
			budgetAllocationDetailProcessTransBO = new BudgetAllocationDetailProcessTransBO();
			budgetAllocationDetailProcessTransVO = new BudgetAllocationDetailProcessTransVO();
			strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			hisutil = new HisUtil("DWH Transaction","BudgetAllocationDetailProcessTransDATA");


			budgetAllocationDetailProcessTransVO.setStrHospitalCode(strHospitalCode);
			
			strFinancialYear =	request_p.getParameter("financialYear");
			
			if(strFinancialYear!=null)
			{
				budgetAllocationDetailProcessTransVO.setStrFinancialStartDate("01-Apr-"+(Integer.parseInt( strFinancialYear.split("\\-")[0].trim() )));
				budgetAllocationDetailProcessTransVO.setStrFinancialEndDate("31-Mar-"+(Integer.parseInt( strFinancialYear.split("\\-")[1].trim() )));
			}
			
			
			
			budgetAllocationDetailProcessTransVO.setStrDrugWareHouseName(request_p.getParameter("storeId"));
			budgetAllocationDetailProcessTransVO.setStrDWHSubTypeId(request_p.getParameter("dwhSubTypeId"));
			budgetAllocationDetailProcessTransVO.setStrSubStoreId(request_p.getParameter("subStoreId"));
			
		
			
			//Calling BO
			budgetAllocationDetailProcessTransBO.viewBudgetDetailsRecord(budgetAllocationDetailProcessTransVO);
			
			
			
			
			if (budgetAllocationDetailProcessTransVO.getStrMsgType().equals("1")) {
				throw new Exception(budgetAllocationDetailProcessTransVO.getStrMsgString());
			}
			
			strBudgetDetailsTable	=	getBudgetDetailsTable(budgetAllocationDetailProcessTransVO.getWrsData());
			
			
		//	budgetAllocationDetailProcessTransFB_p.setStrBudgetDetailsTable(strBudgetDetailsTable);
			
			 response.setHeader("Cache-Control", "no-cache");
			 response.getWriter().print(strBudgetDetailsTable);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "BudgetAllocationDetailProcessTransDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA->getViewDetails()", strMsgText);
			budgetAllocationDetailProcessTransFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			budgetAllocationDetailProcessTransBO = null;
			budgetAllocationDetailProcessTransVO = null;
		}
	}
	

/**
 * To get Entered Dependent Details HLP
 * 
 * @param wrsData_p  the WebRowSet
 */
private static String getBudgetDetailsTable(WebRowSet wrsData_p)	throws SQLException {
	
	StringBuffer sbTable = new StringBuffer(100);
	StringBuffer sbHeader = new StringBuffer(100);
	StringBuffer sbBody = new StringBuffer(100);
	int nWidth=25;
	int nColspan=6;
	
	sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
	sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Budget Details</td>" + "</tr>");
	sbTable.append("</table>");
	
	/*
	 * Header Row:
	 */

	sbHeader.append("<table bgcolor='#6097BC'  class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
	
	
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Sub-Store</td>");
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Previous Year Un-Utilized Budget (A)</td>");
	sbHeader.append("<td width=\""	+ "15"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Current Year Budget Allocated(B)</td>");
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Total Budget Available(A+B)</td>");
	sbHeader.append("<td width=\""	+ "20"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Current Year Budget Utilized</td>");
	sbHeader.append("<td width=\""	+ "10"	+ "%\" class=\"multiRPTLabel\" style=\"text-align: center;\">Current Year Budget Un-Utilized</td>");
	sbHeader.append("</tr>");

	if (wrsData_p != null && wrsData_p.size() > 0) {		
		/* Result Index */
		// Budget_Available: 1
		// Budget_Allocated: 2
		// Budget_Consumed: 3
		// Drug_warehouse_name: 4
		
	
		
		while (wrsData_p.next()) {

			
			
			String strStoreName = wrsData_p.getString("store_name");
			String strPrevUnutilizedBudget = wrsData_p.getString("Prev_Unutilized_Budget");			
			String strBudgetAllocated = wrsData_p.getString("Budget_Allocated");
			String strCurr_Yr_Budget_Available = wrsData_p.getString("Curr_Yr_Budget_Available");			
			String strBudgetConsumed = wrsData_p.getString("Budget_Consumed");
			String strRemainingBudget = wrsData_p.getString("Budget_Available");
			
			
			
			
			if (strStoreName == null) {
				strStoreName = "---";
			}
			if (strPrevUnutilizedBudget == null) {
				strPrevUnutilizedBudget = "---";
			}
			if (strBudgetAllocated == null) {
				strBudgetAllocated = "---";
			}
			if (strCurr_Yr_Budget_Available == null) {
				strCurr_Yr_Budget_Available = "---";
			}
			if (strBudgetConsumed == null) {
				strBudgetConsumed = "---";
			}
			if (strRemainingBudget == null) {
				strRemainingBudget = "---";
			}
			
			
			
			
			
			/*
			 * Table Body
			 */

			sbBody.append("<tr>");
					
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strStoreName + "</font></td>");			
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align: right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strPrevUnutilizedBudget + "</font></td>");
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align: right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strBudgetAllocated + "</font></td>");
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align: right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strCurr_Yr_Budget_Available + "</font></td>");
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align: right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strBudgetConsumed + "</font></td>");
			sbBody.append("<td class=\"multiRPTControl\" style=\"text-align: right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strRemainingBudget + "</font></td>");
			
			sbBody.append("</tr>"); 
		}
		sbBody.append("</table>"); 

	} 
	else 
	{
		sbBody.append("<tr>");
		sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"multiRPTControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
		sbBody.append("</tr></table>");
	}

	return sbTable.toString() + sbHeader.toString() + sbBody.toString();
}




	
}
