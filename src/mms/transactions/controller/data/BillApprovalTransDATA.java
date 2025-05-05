package mms.transactions.controller.data;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.BillApprovalTransBO;
import mms.transactions.controller.fb.BillApprovalTransFB;
import mms.transactions.controller.hlp.BillApprovalTransHLP;
import mms.transactions.vo.BillApprovalTransVO;

/**
 * 
 * @author dell
 *
 */

public class BillApprovalTransDATA {
	
	 public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	 public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","SupplierReturnReqTransDATA");
	      try{
	       a= util.getASDate(frmt);
	      }
	      catch(Exception e){
	    	
	      }
	      /*Calendar cal = Calendar.getInstance();
	      SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	      return sdf.format(cal.getTime());*/
	      return a;
	    }
	/**
	 * This method is used to populate the value of Store name combo box and
	 * this method calls the getInitialValues() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(BillApprovalTransFB formBean,
			HttpServletRequest request) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO voObj = null;
		HisUtil util = null;
		String strmsgText = "";	
		String hosCode = "";	

		try 
		{
			System.out.println(" --------------- BillApprovalTransDATA.getInitialValues -------[ For Central Supply ]---------- ");
			
			bo = new BillApprovalTransBO();
			voObj = new BillApprovalTransVO();
			util=new HisUtil("MMS","Bill Approval Transaction");			
			if(request.getParameter("comboValue")!=null)
			{
				String comboValue[] = request.getParameter("comboValue").replace('^', '#').split("#");
				String strStoreName    = comboValue[0];
				String strSupplierName   = comboValue[1];
				String strBillTypeName = comboValue[2];
				formBean.setStrStoreName(strStoreName);
				formBean.setStrSupplierName(strSupplierName);		
				formBean.setStrBillTypeName(strBillTypeName);		
								
				String strComboValues[] = request.getParameterValues("combo");
				formBean.setStrStoreName(strStoreName);
				formBean.setStrSupplierName(strSupplierName);		
				formBean.setStrBillTypeName(strBillTypeName);				
				formBean.setStrStoreId(strComboValues[0]);
				formBean.setStrSupplierId(strComboValues[1]);
				formBean.setStrBillType(strComboValues[2]);
			}	
			
			voObj.setStrStoreId(formBean.getStrStoreId());
			
			/* 
			 *  hstt_invoicetype_mst			
			 *  
			 * 10 - Bulk PO
			 * 11 - Local PO
			 * 12 - Supplier Receipt
			 * 
			 * */
			
			
			
			voObj = (BillApprovalTransVO) TransferObjectFactory.populateData("mms.transactions.vo.BillApprovalTransVO",formBean);
			if(formBean.getStrBillType().equals("10"))
			{	
			    voObj.setStrProcMode("4");
			}
			if(formBean.getStrBillType().equals("11"))
			{
				voObj.setStrProcMode("10");
			}
			if(formBean.getStrBillType().equals("12"))
			{
				voObj.setStrProcMode("12");
			}
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrHospitalCode(hosCode);
			
			bo.getPODetailsSearchList(voObj);
			String poCmb=util.getOptionValue(voObj.getStrPOSearchDetailsWs(), "0", "0^Select Value", false);
			formBean.setStrPONoCmb(poCmb);
			//System.out.println(" ---------------poCmb---------------- "+poCmb);
			formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));

		} catch (Exception e) {
			e.printStackTrace();
			
			strmsgText = "mms.transactions.BillApprovalTransDATA.getInitialValues --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalTransDATA->getInitialValues()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	
	/**
	 * This method is used to populate the value of Store name combo box and
	 * this method calls the getInitialValues() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getLocalPOValues(BillApprovalTransFB formBean,
			HttpServletRequest request) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO voObj = null;
		HisUtil util = null;
		String strmsgText = "";	
		String hosCode = "";	

		try 
		{
			System.out.println(" --------------- BillApprovalTransDATA.getLocalPOValues ------[ For LP Supply ]----------- ");
			
			bo = new BillApprovalTransBO();
			voObj = new BillApprovalTransVO();
			util=new HisUtil("MMS","Bill Approval Transaction");			
			if(request.getParameter("comboValue")!=null)
			{
				String comboValue[] = request.getParameter("comboValue").replace('^', '#').split("#");
				String strStoreName=comboValue[0];
				String strBillTypeName=comboValue[1];
				String strComboValues[] = request.getParameterValues("combo");
				formBean.setStrStoreName(strStoreName);
				formBean.setStrBillTypeName(strBillTypeName);				
				formBean.setStrStoreId(strComboValues[0]);
				formBean.setStrBillType(strComboValues[1]);
			}	
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrHospitalCode(hosCode);
			voObj.setStrStoreId(formBean.getStrStoreId());		
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * */
			voObj.setStrProcMode("10");
			bo.getPODetailsSearchList(voObj);
			String poCmb=util.getOptionValue(voObj.getStrPOSearchDetailsWs(), "0", "0^Select Value", false);
			formBean.setStrPONoCmb(poCmb);
			formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));

		} catch (Exception e) {
			e.printStackTrace();
			
			strmsgText = "mms.transactions.BillApprovalTransDATA.getInitialValues --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalTransDATA->getInitialValues()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	/**
	 * This method is used to display the value of Item Details and this method
	 * calls the getItemDetails() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getPODetails(BillApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getPODetails ----------------- ");
		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws=null;		
		String []temp=null;
		NumberFormat formatter = new DecimalFormat("############.##"); 
		String strInvAmt			 = "";
		String strPenaltyAmt		 = "";
		String strAmtAfterDedduct    = "";						
		String strPoNetAmt           = "";
		String strSuppAmtTillPayment = "";	
		
		BigDecimal  amtRemainigForPayment = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal                paidAmt = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal  	   totalCalAmount = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal          	   amount = new BigDecimal(BigInteger.ZERO,  2);
		
		BigDecimal           totalPenalty = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal                penalty = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal               poNetAmt = new BigDecimal(BigInteger.ZERO,  2);
		
		try 
		{
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			temp=formBean.getStrPONoCmb().replace('^', '#').split("#");
			vo.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
			vo.setStrPOStoreId(formBean.getStrPONoCmb().replace('^', '#').split("#")[1]);
			formBean.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
			vo.setStrBillType(formBean.getStrBillType());
			if(temp.length==3)
			{
				formBean.setStrPOPrefix(formBean.getStrPONoCmb().replace('^', '#').split("#")[2]);
			}
			
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * */
			vo.setStrProcMode("5");
			bo.getPODetails(vo);  // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 5 ]
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPODate(ws.getString(1));
			    	vo.setStrPOTypeId(ws.getString(2));
			    	vo.setStrPOType(ws.getString(3));
			    	vo.setStrSupplierId(ws.getString(4));
			    	vo.setStrSupplierName(ws.getString(5));
			    	vo.setStrPOStoreId(ws.getString(6));
			    	vo.setStrPOStoreName(ws.getString(7));
			    	vo.setStrItemCategoryNoH(ws.getString(8));
			    	vo.setStrItemCategoryNameH(ws.getString(9));
			    	vo.setStrCurrencyId(ws.getString(10));
			    	vo.setStrCurrencyName(ws.getString(11));
			    	vo.setStrCurrencyValue(ws.getString(12));
			    	vo.setStrOverallPOTax(ws.getString(13));
			    	vo.setStrAdvanceTaken(ws.getString(14));
			    	vo.setStrAdvanceAdjusted(ws.getString(15));
			    	vo.setStrNetPenalty(ws.getString(16));
			    	vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    	vo.setStrPONetAmount(ws.getString(18));
			    	//setting fromBean
			    	formBean.setStrPODate(vo.getStrPODate());
				    formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    }
				/*********************************************** Print Details  ***************************************************/
				/*
				 * Invoice Type 10 - Bulk PO
				 * Invoice Type 11 - Local PO
				 * */
				/*
				 * 6 - Mode  for Bulk PO
				 * 7 - Mode  for Local PO
				 * 
				 * */
				
				vo.setStrProcMode("6");
				
				bo.getPrintDetails(vo);
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				
				String strScheduleDtls = BillApprovalTransHLP.getPrintItemDetails(vo.getWsPrintItemDtls(),hosCode);	
			
				
				/*********************************************** Entered Invoice Details  ***************************************************/
				bo.getPaymentDetails(vo);
								
					
				String strPreviousPaymentDtls = BillApprovalTransHLP.getPaymentDetails(vo.getWsPaymentDtls(),hosCode);	
					
				formBean.setStrPreviousPaymentDtls(strPreviousPaymentDtls);
				
				////System.out.println("strOtherDtls->"+strOtherDtls);
				formBean.setStrScheduleDetails(strScheduleDtls);
				
				String strOtherDtls    = BillApprovalTransHLP.getOtherDetails_New(vo);
				
				formBean.setStrOtherDetails(strOtherDtls);
				
				formBean.setStrBillAmount(String.valueOf(amtRemainigForPayment));
			}	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * This method is used to display the value of Item Details and this method
	 * calls the getItemDetails() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getLPPODetails(BillApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getLPPODetails ----------------- ");
		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws=null;		
		String []temp=null;
		NumberFormat formatter = new DecimalFormat("############.##"); 
		String strInvAmt			 = "";
		String strPenaltyAmt		 = "";
		String strAmtAfterDedduct    = "";						
		String strPoNetAmt           = "";
		String strSuppAmtTillPayment = "";	
		
		BigDecimal  amtRemainigForPayment = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal                paidAmt = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal  	   totalCalAmount = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal          	   amount = new BigDecimal(BigInteger.ZERO,  2);
		
		BigDecimal           totalPenalty = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal                penalty = new BigDecimal(BigInteger.ZERO,  2);
		BigDecimal               poNetAmt = new BigDecimal(BigInteger.ZERO,  2);
		
		try 
		{
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			temp=formBean.getStrPONoCmb().replace('^', '#').split("#");
			vo.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
			vo.setStrPOStoreId(formBean.getStrPONoCmb().replace('^', '#').split("#")[1]);
			formBean.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
			vo.setStrBillType(formBean.getStrBillType());
			if(temp.length==3)
			{
				formBean.setStrPOPrefix(formBean.getStrPONoCmb().replace('^', '#').split("#")[2]);
			}
			
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * */
						
			vo.setStrProcMode("11");
			bo.getPODetails(vo);  // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 11 ]
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPODate(ws.getString(1));
			    	vo.setStrPOTypeId(ws.getString(2));
			    	vo.setStrPOType(ws.getString(3));
			    	vo.setStrSupplierId(ws.getString(4));
			    	vo.setStrSupplierName(ws.getString(5));
			    	vo.setStrPOStoreId(ws.getString(6));
			    	vo.setStrPOStoreName(ws.getString(7));
			    	vo.setStrItemCategoryNoH(ws.getString(8));
			    	vo.setStrItemCategoryNameH(ws.getString(9));
			    	vo.setStrCurrencyId(ws.getString(10));
			    	vo.setStrCurrencyName(ws.getString(11));
			    	vo.setStrCurrencyValue(ws.getString(12));
			    	vo.setStrOverallPOTax(ws.getString(13));
			    	vo.setStrAdvanceTaken(ws.getString(14));
			    	vo.setStrAdvanceAdjusted(ws.getString(15));
			    	vo.setStrNetPenalty(ws.getString(16));
			    	vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    	vo.setStrPONetAmount(ws.getString(18));
			    	//setting fromBean
			    	formBean.setStrPODate(vo.getStrPODate());
				    formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    }
				/*********************************************** Print Details  ***************************************************/
				
				/*
				 * Invoice Type 10 - Bulk PO
				 * Invoice Type 11 - Local PO
				 * */
							
				
				/*
				 * 6 - Mode  for Bulk PO
				 * 7 - Mode  for Local PO
				 * 
				 * */
				
				vo.setStrProcMode("7");
				
				bo.getPrintDetails(vo);
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				/*
				 * Calculate Net Amount of Supply
				 * */
				BigDecimal    totalAmount = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal      totalCost = new BigDecimal(BigInteger.ZERO,  2);
				while (vo.getWsPrintItemDtls().next()) 
				{
					totalCost   = new BigDecimal(vo.getWsPrintItemDtls().getString("RATE_WITH_TAX")).multiply(new BigDecimal(vo.getWsPrintItemDtls().getString("rcd_qty")));
					totalAmount = totalAmount.add(totalCost);					
				}
				
				vo.getWsPrintItemDtls().beforeFirst();
				
				String strSuppliedItemCost = String.valueOf(totalAmount);
				String strPOTotalCost      = formatter.format(new BigDecimal(vo.getStrPONetAmount()));
				  
				formBean.setStrBillAmount(strPOTotalCost);
				
				String strScheduleDtls = BillApprovalTransHLP.getPrintItemDetails(vo.getWsPrintItemDtls(),hosCode);	
			
				
				/*********************************************** Payment Details  ***************************************************/
				bo.getPaymentDetails(vo);
				
				
				ws = vo.getWsPaymentDtls();
				
				if(ws.size()>0)
				{	
					
					
					
					while (ws.next()) 
					{
							
							strInvAmt			  = ws.getString(5);
							strPenaltyAmt		  = ws.getString(6);
							strAmtAfterDedduct    = ws.getString(7);						
							strPoNetAmt           = ws.getString(15);
							strSuppAmtTillPayment = ws.getString(16);						
							
							        poNetAmt = new BigDecimal(strPoNetAmt);
							         penalty = new BigDecimal(strPenaltyAmt);
							
							    totalPenalty = totalPenalty.add(penalty);
							
							          amount = new BigDecimal(strAmtAfterDedduct);
								
							  totalCalAmount = totalCalAmount.add(amount);
							
							
					}
					
					paidAmt = totalCalAmount.add(totalPenalty);
									
					
					amtRemainigForPayment = poNetAmt.subtract(paidAmt);
					
					vo.getWsPaymentDtls().beforeFirst();
				}
				else
				{
					amtRemainigForPayment = new BigDecimal(formBean.getStrPONetAmount());
				}
					
					
				String strPreviousPaymentDtls = BillApprovalTransHLP.getPaymentDetails(vo.getWsPaymentDtls(),hosCode);	
					
				formBean.setStrPreviousPaymentDtls(strPreviousPaymentDtls);
				
				////System.out.println("strOtherDtls->"+strOtherDtls);
				formBean.setStrScheduleDetails(strScheduleDtls);
				
				String strOtherDtls    = BillApprovalTransHLP.getOtherDetails(vo,strSuppliedItemCost,strPOTotalCost);
				
				formBean.setStrOtherDetails(strOtherDtls);
				
				formBean.setStrBillAmount(String.valueOf(amtRemainigForPayment));
			}	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * This method is used to display the value of Item Details and this method
	 * calls the getItemDetails() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSupp_Rec_Details(BillApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getSupp_Rec_Details ----------------- ");
		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws=null;		
		String []temp=null;
	
		HisUtil  util = null;
		
		
		try 
		{
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();
			
			util=new HisUtil("MMS","Bill Approval Transaction");	

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			//System.out.println("Store _ Id---"+formBean.getStrStoreId());
			
			vo.setStrStoreId(formBean.getStrStoreId());		
			vo.setStrPONo(formBean.getStrPONoCmb());			
			formBean.setStrPONo(formBean.getStrPONoCmb());
			vo.setStrBillType(formBean.getStrBillType());			
			vo.setStrSupplierId(formBean.getStrSupplierId());				
			formBean.setStrPOPrefix("SUPP/RECP");
			
			
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * Invoice Type 12 - Supplier Receipt
			 * */
						
			vo.setStrProcMode("13");
			bo.getPODetails(vo);  // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 13 ]
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPODate(ws.getString(1));
			    	vo.setStrPOTypeId(ws.getString(2));
			    	vo.setStrPOType(ws.getString(3));
			    	vo.setStrSupplierId(ws.getString(4));
			    	vo.setStrSupplierName(ws.getString(5));
			    	vo.setStrPOStoreId(ws.getString(6));
			    	vo.setStrPOStoreName(ws.getString(7));
			    	vo.setStrItemCategoryNoH(ws.getString(8));
			    	vo.setStrItemCategoryNameH(ws.getString(9));
			    	vo.setStrCurrencyId(ws.getString(10));
			    	vo.setStrCurrencyName(ws.getString(11));
			    	vo.setStrCurrencyValue(ws.getString(12));
			    	vo.setStrOverallPOTax(ws.getString(13));
			    	vo.setStrAdvanceTaken(ws.getString(14));
			    	vo.setStrAdvanceAdjusted(ws.getString(15));
			    	vo.setStrNetPenalty(ws.getString(16));
			    	vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    	vo.setStrPONetAmount(ws.getString(18));
			    	//setting fromBean
			    	formBean.setStrPODate(vo.getStrPODate());
				    formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType("PO");
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    }
				/*********************************************** Print Details  ***************************************************/
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				
				/*
				 * Invoice Type 10 - Bulk PO
				 * Invoice Type 11 - Local PO
				 * Invoice Type 12 - Supplier Receipt
				 * */								
				/*
				 * 6 - Mode  for Bulk PO
				 * 7 - Mode  for Local PO
				 * 8 - Mode  for Supplier Receipt
				 * 
				 * */
				
				if(formBean.getStrBillType().equals("10"))
			    {	
					vo.setStrProcMode("6");
			    }
			    if(formBean.getStrBillType().equals("11"))
			    {
			    	vo.setStrProcMode("7");
			    }
			    if(formBean.getStrBillType().equals("12"))
			    {
			    	vo.setStrProcMode("8");
			    }			
				
				bo.getPrintDetails(vo);  // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL				
								
				/*********************************************** Supply Details  ***************************************************/
				String strScheduleDtls = BillApprovalTransHLP.getSuppPrintItemDetails_NEW(vo.getWsPrintItemDtls(),hosCode);				
				formBean.setStrScheduleDetails(strScheduleDtls);				
				/*********************************************** Entered Invoice Details  ******************************************/
				bo.getSUPP_PaymentDetails(vo);  // PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 2 ] ,PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 3 ] combo
				
				String strPreviousPaymentDtls = BillApprovalTransHLP.getPaymentDetails(vo.getWsPaymentDtls(),hosCode);	
					
				formBean.setStrPreviousPaymentDtls(strPreviousPaymentDtls);
				
				/*********************************************** Register Invoice Payment Details  ******************************************/
				bo.getSuppInvoice_EnteredPayment_Details(vo);  // PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 4 ]
				
				String strPreviousInvoicePaymentDtls = BillApprovalTransHLP.getRegisteredPaymentDetails(vo.getWsRegisterPaymentDtls(),hosCode);	
					
				formBean.setStrPreviousInvoicePaymentDtls(strPreviousInvoicePaymentDtls);
				/*********************************************** Other Details  *******************************************/
				//Pkg_Mms_View.Proc_Consultant_Name --[ Mode - 2 ]
				
				String strOtherDtls    = BillApprovalTransHLP.getOtherDetails_New(vo);
				
				formBean.setStrOtherDetails(strOtherDtls);
				
			
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				
				String invoiceCombo = util.getOptionValue(vo.getWsInvoiceComboDtls(), "0", "0^Select Value", false);
				formBean.setStrMultiInvoiceNoCombo(invoiceCombo);
			}	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * This method is used to display the value of Item Details and this method
	 * calls the getItemDetails() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void PO_PaymentPrint_New(BillApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.PO_PaymentPrint_New ----------------- ");
		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws=null;		
		String []temp=null;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		String strInvAmt			 = "";
		String strPenaltyAmt		 = "";
		String strAmtAfterDedduct    = "";						
		String strPoNetAmt           = "";
		String strSuppAmtTillPayment = "";	
		String strInvoiceSaveBy      = "";
		String comboVal="";
		try 
		{
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			comboVal=request.getParameter("comboValue");
			/*
			  invoice_no_list    || '@'    || po_no   || '@'  || invoice_type_id || '@' || supplier_id || '@'|| invoice_status || '@'|| po_store_id
			*/
			String strChk=request.getParameter("chk");
			System.out.println("strChk----->"+strChk);
			temp=strChk.replace('@','#').split("#");
			
			vo.setStrPONo(temp[1]);
			vo.setStrPOStoreId(temp[0]);
			vo.setStrBillType(temp[2]);
			formBean.setStrBillType(temp[2]);
			// 20702200001,20702200002,20702200003@20212100001@10@2010006@1@10201100$9
			temp=temp[5].replace('$','#').split("#");			
			vo.setStrPOStoreId(temp[0]);
			temp=comboVal.replace('@','#').split("#");
			formBean.setStrStoreName(temp[0]);
			
			String currenDateTime= now(DATE_FORMAT_NOWwt);
			
			System.out.println("Bill Type----->"+formBean.getStrBillType());
			
			
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * */
			if(formBean.getStrBillType().equals("10"))
			{	
			   vo.setStrProcMode("5");
			}
			if(formBean.getStrBillType().equals("11"))
			{	
			   vo.setStrProcMode("11");
			}
			if(formBean.getStrBillType().equals("12"))
			{	
			   vo.setStrProcMode("14");
			}
			
			bo.getPODetails(vo);  // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 5,11,14 ]
			bo.getSeatUserName(vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPODate(ws.getString(1));
			    	vo.setStrPOTypeId(ws.getString(2));
			    	vo.setStrPOType(ws.getString(3));
			    	vo.setStrSupplierId(ws.getString(4));
			    	vo.setStrSupplierName(ws.getString(5));
			    	vo.setStrPOStoreId(ws.getString(6));
			    	vo.setStrPOStoreName(ws.getString(7));
			    	vo.setStrItemCategoryNoH(ws.getString(8));
			    	vo.setStrItemCategoryNameH(ws.getString(9));
			    	vo.setStrCurrencyId(ws.getString(10));
			    	vo.setStrCurrencyName(ws.getString(11));
			    	vo.setStrCurrencyValue(ws.getString(12));
			    	vo.setStrOverallPOTax(ws.getString(13));
			    	vo.setStrAdvanceTaken(ws.getString(14));
			    	vo.setStrAdvanceAdjusted(ws.getString(15));
			    	vo.setStrNetPenalty(ws.getString(16));
			    	vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    	vo.setStrPONetAmount(ws.getString(18));
			    	//setting fromBean
			    	formBean.setStrPODate(vo.getStrPODate());
				    formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    }
				/*
				 * Invoice Type 10 - Bulk PO
				 * Invoice Type 11 - Local PO
				 * Invoice Type 12 - Supplier Receipt
				 * */								
				/*
				 * 6 - Mode  for Bulk PO
				 * 7 - Mode  for Local PO
				 * 8 - Mode  for Supplier Receipt
				 * 
				 * */
				
				if(formBean.getStrBillType().equals("10"))
			    {	
					vo.setStrProcMode("6");
			    }
			    if(formBean.getStrBillType().equals("11"))
			    {
			    	vo.setStrProcMode("7");
			    }
			    if(formBean.getStrBillType().equals("12"))
			    {
			    	vo.setStrProcMode("8");
			    }			
				
				bo.getPrintDetails(vo);  // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL				
								
				/*********************************************** Supply Details  ***************************************************/
				String strScheduleDtls = BillApprovalTransHLP.getSuppPrintItemDetails_NEW(vo.getWsPrintItemDtls(),hosCode);				
				formBean.setStrScheduleDetails(strScheduleDtls);
								
				/*********************************************** Payment Details  ***************************************************/
				bo.getSUPP_PaymentDetails(vo);
				
				String strPreviousPaymentDtls = BillApprovalTransHLP.getPaymentDetails_Print(vo.getWsPaymentDtls(),hosCode);
				
				/*********************************************** Register Invoice Payment Details  ******************************************/
				bo.getSuppInvoice_EnteredPayment_Details(vo);  // PKG_MMS_VIEW.proc_hstt_invoice_payment_dtl --[ Mode - 4 ]
				
				String strPreviousInvoicePaymentDtls = BillApprovalTransHLP.getRegisteredPaymentDetails(vo.getWsRegisterPaymentDtls(),hosCode);	
					
				/*********************************************** Final Print  ******************************************/	
				
				String strTableWidth = "800"; 
				StringBuffer sbHeader = new StringBuffer("");
				//sbHeader.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
				sbHeader.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px' >");				
				sbHeader.append("<tr> ");
				
				sbHeader.append("<td align='center' colspan='1'>");
				sbHeader.append("</td>");
				
				sbHeader.append("<td align='center' colspan='1'>");			
				sbHeader.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' />");
				sbHeader.append("</td>");
				
				sbHeader.append("<td align='right' colspan='1'>");
				sbHeader.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sbHeader.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sbHeader.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sbHeader.append(" src='../../hisglobal/images/stop.png' onClick='cancelPage();' /> </div></div>");
				sbHeader.append(" </td> ");
				sbHeader.append(" </tr> ");
				sbHeader.append(" </table> ");
				
				StringBuffer scheduleHeader = new StringBuffer("");
				scheduleHeader.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
				scheduleHeader.append("<tr> ");
				scheduleHeader.append("<td colspan='12' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Supply Details</u></b></font></td> ");
				scheduleHeader.append("</tr> ");
				scheduleHeader.append("</table>");
				
				StringBuffer invoiceHeader = new StringBuffer("");
				invoiceHeader.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
				invoiceHeader.append("<tr> ");
				invoiceHeader.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Invoice Details</u></b></font></td> ");
				invoiceHeader.append("</tr> ");
				invoiceHeader.append("</table>");
				
				StringBuffer regPaymentHeader = new StringBuffer("");
				regPaymentHeader.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
				regPaymentHeader.append("<tr> ");
				regPaymentHeader.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Payment Details</u></b></font></td> ");
				regPaymentHeader.append("</tr> ");
				regPaymentHeader.append("</table>");
				
                StringBuffer sbfooter = new StringBuffer("");
                sbfooter.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px' >");
				/*
										
				sbfooter.append("<tr> ");
				sbfooter.append("<td align='right'  colspan='7'><b>PO NET AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(strPoNetAmt))+"</b></font></td>");			
				sbfooter.append("</tr>");
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>WAVIER/PENALTY AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(totalPenalty)))+"</b></font></td>");			
				sbfooter.append("</tr>");
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>FINAL PAID AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(totalCalAmount)))+"</b></font></td>");			
				sbfooter.append("</tr>");				
				sbfooter.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");				
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>PENDING AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(amtRemainigForPayment)))+"</b></font></td>");			
				sbfooter.append("</tr>");	
				*/					
                			
				sbfooter.append("<br><tr><td colspan='9' align='right'>Generated By :: <b>"+vo.getStrSeatUserName()+" / "+currenDateTime+"</b></td></tr> ");				
				sbfooter.append("<br><br><tr><td colspan='9' align='center'>****This is a computer generated Report Signature and Stamp are not Required****</td></tr> ");
				
				sbfooter.append("</table>");
				
				
				formBean.setStrPreviousPaymentDtls(sbHeader.toString()
						+""+scheduleHeader
						+""+strScheduleDtls
						+""+invoiceHeader
						+""+strPreviousPaymentDtls
						+""+regPaymentHeader
						+""+strPreviousInvoicePaymentDtls
						+""+sbfooter.toString());
				
			}	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * This method is used to display the value of Item Details and this method
	 * calls the getItemDetails() method which is define in
	 * SupplierReturnReqTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void PO_PaymentPrint_Org(BillApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getPODetails ----------------- ");
		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws=null;		
		String []temp=null;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		String strInvAmt			 = "";
		String strPenaltyAmt		 = "";
		String strAmtAfterDedduct    = "";						
		String strPoNetAmt           = "";
		String strSuppAmtTillPayment = "";	
		String strInvoiceSaveBy      = "";
		String comboVal="";
		try 
		{
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getStrStoreId());
			comboVal=request.getParameter("comboValue");
			/*
			  invoice_no_list    || '@'    || po_no   || '@'  || invoice_type_id || '@' || supplier_id || '@'|| invoice_status || '@'|| po_store_id
			*/
			String strChk=request.getParameter("chk");
			System.out.println("strChk----->"+strChk);
			temp=strChk.replace('@','#').split("#");
			
			vo.setStrPONo(temp[1]);
			vo.setStrPOStoreId(temp[0]);
			vo.setStrBillType(temp[2]);
			formBean.setStrBillType(temp[2]);
			// 20702200001,20702200002,20702200003@20212100001@10@2010006@1@10201100$9
			temp=temp[5].replace('$','#').split("#");			
			vo.setStrPOStoreId(temp[0]);
			temp=comboVal.replace('@','#').split("#");
			formBean.setStrStoreName(temp[0]);
			
			
			System.out.println("Bill Type----->"+formBean.getStrBillType());
			
			
			/*
			 * Invoice Type 10 - Bulk PO
			 * Invoice Type 11 - Local PO
			 * */
			if(formBean.getStrBillType().equals("10"))
			{	
			   vo.setStrProcMode("5");
			}
			if(formBean.getStrBillType().equals("11"))
			{	
			   vo.setStrProcMode("11");
			}
			if(formBean.getStrBillType().equals("12"))
			{	
			   vo.setStrProcMode("14");
			}
			
			bo.getPODetails(vo);  // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode - 5,11,14 ]
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPODate(ws.getString(1));
			    	vo.setStrPOTypeId(ws.getString(2));
			    	vo.setStrPOType(ws.getString(3));
			    	vo.setStrSupplierId(ws.getString(4));
			    	vo.setStrSupplierName(ws.getString(5));
			    	vo.setStrPOStoreId(ws.getString(6));
			    	vo.setStrPOStoreName(ws.getString(7));
			    	vo.setStrItemCategoryNoH(ws.getString(8));
			    	vo.setStrItemCategoryNameH(ws.getString(9));
			    	vo.setStrCurrencyId(ws.getString(10));
			    	vo.setStrCurrencyName(ws.getString(11));
			    	vo.setStrCurrencyValue(ws.getString(12));
			    	vo.setStrOverallPOTax(ws.getString(13));
			    	vo.setStrAdvanceTaken(ws.getString(14));
			    	vo.setStrAdvanceAdjusted(ws.getString(15));
			    	vo.setStrNetPenalty(ws.getString(16));
			    	vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    	vo.setStrPONetAmount(ws.getString(18));
			    	//setting fromBean
			    	formBean.setStrPODate(vo.getStrPODate());
				    formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			    }
								
				/*********************************************** Payment Details  ***************************************************/
				bo.getSUPP_PaymentDetails(vo);
				
				ws = vo.getWsPaymentDtls();
				
				BigDecimal  amtRemainigForPayment = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal                paidAmt = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal  	   totalCalAmount = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal          	   amount = new BigDecimal(BigInteger.ZERO,  2);
				
				BigDecimal           totalPenalty = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal                penalty = new BigDecimal(BigInteger.ZERO,  2);
				BigDecimal               poNetAmt = new BigDecimal(BigInteger.ZERO,  2);
				
				
				while (ws.next()) 
				{
						
						strInvAmt			  = ws.getString(5);
						strPenaltyAmt		  = ws.getString(6);
						strAmtAfterDedduct    = ws.getString(7);						
						strPoNetAmt           = ws.getString(15);
						strSuppAmtTillPayment = ws.getString(16);	
						strInvoiceSaveBy	  = ws.getString(12);
						
						        poNetAmt = new BigDecimal(strPoNetAmt);
						         penalty = new BigDecimal(strPenaltyAmt);
						
						    totalPenalty = totalPenalty.add(penalty);
						
						          amount = new BigDecimal(strAmtAfterDedduct);
							
						  totalCalAmount = totalCalAmount.add(amount);
						
						
				}
				
				paidAmt = totalCalAmount.add(totalPenalty);								
				
				amtRemainigForPayment = poNetAmt.subtract(paidAmt);			
				
				vo.getWsPaymentDtls().beforeFirst();
				String strPreviousPaymentDtls = BillApprovalTransHLP.getPaymentDetails_Print(vo.getWsPaymentDtls(),hosCode);
				
				StringBuffer sbfooter = new StringBuffer("");
				
				sbfooter.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px' >");						
				sbfooter.append("<tr> ");
				sbfooter.append("<td align='right'  colspan='7'><b>PO NET AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(strPoNetAmt))+"</b></font></td>");			
				sbfooter.append("</tr>");
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>WAVIER/PENALTY AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(totalPenalty)))+"</b></font></td>");			
				sbfooter.append("</tr>");
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>FINAL PAID AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(totalCalAmount)))+"</b></font></td>");			
				sbfooter.append("</tr>");				
				sbfooter.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");				
				sbfooter.append("<tr>");
				sbfooter.append("<td align='right'  colspan='7'><b>PENDING AMOUNT </b></font></td>");
				sbfooter.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+myFormatter.format(Double.parseDouble(String.valueOf(amtRemainigForPayment)))+"</b></font></td>");			
				sbfooter.append("</tr>");						
				sbfooter.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
								
				sbfooter.append("<tr><td colspan='5'></td><td colspan='4' align='center'><b>"+strInvoiceSaveBy+"</b></td></tr> ");
				
				sbfooter.append("<tr><td colspan='5'></td><td colspan='4' align='center'><b>AUTHORISED SIGNATORY</b></td></tr> ");				
				
				
				sbfooter.append("<tr><td colspan='5'></td><td colspan='4' align='center'><b>Seal and Stamp</b></td></tr> ");
				
				sbfooter.append("<tr><td colspan='9' align='center'>This is a computer generated Report Signature and Stamp are not Required.</td></tr> ");
				
				sbfooter.append("</table>");
				
				formBean.setStrPreviousPaymentDtls(strPreviousPaymentDtls+""+sbfooter.toString());
				
			}	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	public static void getPeneltyDtl(BillApprovalTransFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String result="";
		String strHospitalCode = "";
		String scheduleNos="";
		String strPOStoreId="";
		String strPONo="";
		String rejectedPenelty="";
		String latePenelty="";
		
		
		String temp[]=null;
		
	//	HisUtil util = null;
		try {
			
			    System.out.println(" --------------- BillApprovalTransDATA.getPeneltyDtl ----------------- ");
			
				vo=new BillApprovalTransVO();
				bo=new BillApprovalTransBO();
			
			
				scheduleNos=request.getParameter("scheduleNos");
				latePenelty=request.getParameter("latePenelty");
				rejectedPenelty=request.getParameter("rejectedPenelty");
				strPONo=request.getParameter("poNo");
				strHospitalCode= request.getSession().getAttribute("HOSPITAL_CODE").toString();
				strPOStoreId=request.getParameter("poStoreId");
				temp=scheduleNos.replace('^', '#').split("#");
				if(temp.length==1){
					scheduleNos="("+temp[0]+")";
				
				}else{
					scheduleNos="(";
						for(int i=0, stopI = temp.length  ;i<stopI;i++){
							if(i!= stopI-1)
								scheduleNos+=temp[i]+",";
							else
								scheduleNos+=temp[i];
						}
						scheduleNos+=")";
				}
				vo.setStrPOStoreId(strPOStoreId);
				vo.setStrHospitalCode(strHospitalCode);
				vo.setStrPONo(strPONo);
				vo.setStrScheduleNo(scheduleNos);
				bo.getPeneltyDtl(vo);
				result=BillApprovalTransHLP.createPeneltyDtl(vo.getWsPeneltyDtl(), latePenelty, rejectedPenelty);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(result);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPeneltyDtl -->"
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPeneltyDtl()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
		}
	}
	public static void getScheduleItemDtls(BillApprovalTransFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

	
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String strScheduleItemDtls="";
		String hosCode = "";
	
		try {
			System.out.println(" --------------- BillApprovalTransDATA.getScheduleItemDtls ----------------- ");
			
	
			vo = new BillApprovalTransVO();
	
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrPOStoreId(request.getParameter("poStoreId"));
			vo.setStrPONo(request.getParameter("poNo"));
			vo.setStrSelScheduleNos(request.getParameter("scheduleNoList"));
			System.out.println(" --------------- BillApprovalTransHLP.getScheduleItemDetails ----------------- ");
			strScheduleItemDtls=BillApprovalTransHLP.getScheduleItemDetails(vo);
			formBean.setStrSearchListPODetails(strScheduleItemDtls);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strScheduleItemDtls);

		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.BillApprovalTransDATA.initSearchList -->"
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
		} 
		finally 
		{
	//		bo = null;
			vo = null;
		}
	}
	public static void initSearchList(BillApprovalTransFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO vo = null;
		String strmsgText = "";
		String strPOSearchListDtl="";
		String hosCode = "";	
		try {
			System.out.println(" --------------- BillApprovalTransDATA.initSearchList ----------------- ");
			bo = new BillApprovalTransBO();
			vo = new BillApprovalTransVO();
	
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrSearchListPODtlFromDate(request.getParameter("fromDate"));
			vo.setStrSearchListPODtlToDate(request.getParameter("toDate"));			
			bo.getPODetailsSearchList(vo);			
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				System.out.println(" --------------- BillApprovalTransHLP.getPONoSearchListDetails ----------------- ");
				
				strPOSearchListDtl=BillApprovalTransHLP.getPONoSearchListDetails(vo);
				formBean.setStrSearchListPODetails(strPOSearchListDtl);				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPOSearchListDtl);
			}		

		} 
		catch (Exception e) 
		{
			strmsgText = "mms.transactions.BillApprovalTransDATA.initSearchList -->"
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"BillApprovalTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
		} 
		finally 
		{
			bo = null;
			vo = null;
		}
	}

	public static void insert(BillApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO voObj = null;
		String strmsgText = null;
		
		MmsConfigUtil mmsConfig = null;
	//	String fileLocation="";
		String fileExt="";
		String []temp=null;
		AttachFileGlobal fs=null;
	//	String strFileName="";
		String currenDateTime="";
		try {
			
			System.out.println(" --------------- BillApprovalTransDATA.insert ----------------- ");
			
			bo = new BillApprovalTransBO();
			voObj = new BillApprovalTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			fs=new AttachFileGlobal();
			voObj = (BillApprovalTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.BillApprovalTransVO",
							formBean);
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
	
			currenDateTime= now(DATE_FORMAT_NOWwt);
			 temp=currenDateTime.replace('/', '#').split("#");
			 currenDateTime=temp[0]+"_"+temp[1];
			 voObj.setStrCurrentDateTime(currenDateTime);
			 System.out.println(" -------------------------------- ");
			 
		    for(int i =0 ; i< formBean.getStrMultiInvoiceNo().length;i++)
		    {
		    	System.out.println("-Inv_no-"+formBean.getStrMultiInvoiceNo()[i]+"-Date--"+formBean.getStrMultiInvoiceDate()[i]+"-Tax--"+formBean.getStrMultiInvoiceTax()[i]+"-Disc--"+formBean.getStrMultiInvoiceDisc()[i]+"--Val-"+formBean.getStrMultiInvoiceValue()[i]+"--Amt-"+formBean.getStrMultiInvoiceAmount()[i]);
		    }	
				 
			System.out.println(" -------------------------------- ");
			
			bo.insert(voObj);	
		    formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
        	if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Inserted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalTransDATA->insert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}	
	}
	
	public static void insert_new(BillApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		BillApprovalTransBO bo = null;
		BillApprovalTransVO voObj = null;
		String strmsgText = null;
		
		MmsConfigUtil mmsConfig = null;
	//	String fileLocation="";
		String fileExt="";
		String []temp=null;
		AttachFileGlobal fs=null;
	//	String strFileName="";
		String currenDateTime="";
		try {
			
			System.out.println(" --------------- BillApprovalTransDATA.insert ----------------- ");
			
			bo = new BillApprovalTransBO();
			voObj = new BillApprovalTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			fs=new AttachFileGlobal();
			voObj = (BillApprovalTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.BillApprovalTransVO",
							formBean);
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
	
			currenDateTime= now(DATE_FORMAT_NOWwt);
			 temp=currenDateTime.replace('/', '#').split("#");
			 currenDateTime=temp[0]+"_"+temp[1];
			 voObj.setStrCurrentDateTime(currenDateTime);
			/* 
			System.out.println(" -------------------------------- ");
			 
		    for(int i =0 ; i< formBean.getStrMultiInvoiceNo().length;i++)
		    {
		    	System.out.println("-Inv_no-"+formBean.getStrMultiInvoiceNo()[i]+"-Date--"+formBean.getStrMultiInvoiceDate()[i]+"-Tax--"+formBean.getStrMultiInvoiceTax()[i]+"-Disc--"+formBean.getStrMultiInvoiceDisc()[i]+"--Val-"+formBean.getStrMultiInvoiceValue()[i]+"--Amt-"+formBean.getStrMultiInvoiceAmount()[i]);
		    }	
				 
			System.out.println(" -------------------------------- ");
			*/
			
			bo.insert_new(voObj);	
		
		    formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
        	if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Invoice Data Save Successfully For PO [ "+voObj.getStrPONo()+" ] ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.insert_new --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"BillApprovalTransDATA->insert_new()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
		}	
	}
}
