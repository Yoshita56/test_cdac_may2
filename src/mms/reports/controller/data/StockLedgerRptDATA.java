package mms.reports.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.StockLedgerRptBO;
import mms.reports.controller.fb.StockLedgerRptFB;
import mms.reports.controller.hlp.StockLedgerRptHLP;
import mms.reports.vo.StockLedgerRptVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerRptDATA {
	
	public static void getInitVal(StockLedgerRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockLedgerRptBO bo = null;
		StockLedgerRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new StockLedgerRptBO();
			voObj = new StockLedgerRptVO();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerRptDATA");
			
			if(voObj.getStrStoreWs()!=null && voObj.getStrStoreWs().size()>0)
			{
				if(voObj.getStrStoreWs().next())
				{
					voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
					voObj.getStrStoreWs().beforeFirst();
					formBean.setStrStoreId(voObj.getStrStoreId());
				}
				
				if(voObj.getStrStoreWs().size()==1)
				{
					strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "", "", false);
				}
				else
					strStoreVal = //"<option title='All' value = '0'>All</option>"+
									util.getOptionValue(voObj.getStrStoreWs(), voObj.getStrStoreId(), "0^Select Value", false);
			}
			////System.out.println("inside initval()->StrStoreId :"+voObj.getStrStoreId()+", strStoreVal :"+strStoreVal);
			
			////////////// Added by Aadil on 25-Jul-2013 /////////////
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			String strItemCatValues = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs()!=null && voObj.getStrItemCatWs().size() != 0) {
				
				if(voObj.getStrItemCatWs().next())
				{
					voObj.setStrItemCatId(voObj.getStrItemCatWs().getString(1));
					voObj.getStrItemCatWs().beforeFirst();
					formBean.setStrItemCatNo(voObj.getStrStoreId());
				}else{
					formBean.setStrItemCatNo("0");
					voObj.setStrItemCatId(formBean.getStrItemCatNo());
				}
				strItemCatValues = util.getOptionValue(voObj.getStrItemCatWs(), voObj.getStrItemCatId(), "0^SelectValue",
						true);

			}else{
				
				strItemCatValues = "<option value='0'>SelectValue</option>";
				formBean.setStrItemCatNo("0");
				voObj.setStrItemCatId(formBean.getStrItemCatNo());
			}
			formBean.setStrItemCatValues(strItemCatValues);
			//////////////////////////////////////////////////////////////
			
			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			
			String strItemValues = "<option value='0'>All</option>";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs()!= null) {
				
				strItemValues = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All",
						true);

			}else{
				
				strItemValues = "<option value='0'>All</option>";
			}
			
			formBean.setStrItemValues(strItemValues);
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockLedgerRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(StockLedgerRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockLedgerRptBO bo = null;
		StockLedgerRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerRptBO();
			voObj = new StockLedgerRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerRptDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",
						true);

			}else{
				
				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockLedgerRptDATA->getItemCatList()", strmsgText);
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
	
	public static void getGroupList(StockLedgerRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockLedgerRptBO bo = null;
		StockLedgerRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerRptBO();
			voObj = new StockLedgerRptVO();
			
			String strItemCatId = request.getParameter("itemCatId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrGroupWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrGroupWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockLedgerRptDATA->getGroupList()", strmsgText);
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
	
	public static void getItemList(StockLedgerRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockLedgerRptBO bo = null;
		StockLedgerRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerRptBO();
			voObj = new StockLedgerRptVO();
			
			String strStoreId = request.getParameter("storeId");
			String strItemCatId = request.getParameter("itemCatId");
			String strGroupId = request.getParameter("groupId");
			
			if (strItemCatId == null)
				strItemCatId = "0";
			if (strStoreId == null)
				strStoreId = "0";
			if (strGroupId == null)
				strGroupId = "0";
			
			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrStoreId(strStoreId);
			//voObj.setStrGroupId(strGroupId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerRptDATA");
			String temp = "<option value='0'>All</option>";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs()!= null) {
				
				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All",
						true);

			}else{
				
				temp = "<option value='0'>All</option>";
			}
			////System.out.println("inside getItemList() ->"+temp);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockLedgerRptDATA->getGroupList()", strmsgText);
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
	  * 
	  * @param formBean
	  * @param request
	  * @param response
	  */
	 public static void getStockLedgerDtl(StockLedgerRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				StockLedgerRptBO bo = null;
				StockLedgerRptVO vo = null;
				MmsConfigUtil mcu = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new StockLedgerRptBO();
					vo = new StockLedgerRptVO();
					//mcu = new MmsConfigUtil();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrDWHId(  (request.getParameter("storeId")==null || request.getParameter("storeId").equals("") ) ? "0": request.getParameter("storeId"));
					
					vo.setStrItemBrandId((request.getParameter("itembrandId")==null || request.getParameter("itembrandId").equals("") || request.getParameter("itembrandId").equals("0") ) ? "0": request.getParameter("itembrandId").split("^")[0]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					vo.setStrWhetherBatchWise( (request.getParameter("batchFlag")==null || request.getParameter("batchFlag").equals("") ) ? "0": request.getParameter("batchFlag"));
					
					if(vo.getStrWhetherBatchWise().equals("1"))
					{
						vo.setStrMode("1");	// Batch Wise
					}
					else
					{
						vo.setStrMode("2");	// Without Batch Wise
					}
									
					
					vo.setStrItemCatId(formBean.getStrItemCatNo());
										
					/*//System.out.println("vo.getStrDWHId()"+vo.getStrDWHId());
					//System.out.println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
					//System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
					//System.out.println("vo.getStrToDate()"+vo.getStrToDate());
					//System.out.println("vo.getStrWhetherBatchWise()"+vo.getStrWhetherBatchWise());
					//System.out.println("vo.getStrMode()"+vo.getStrMode());
					//System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId());*/
					
									
					// Calling BO
					bo.getConsolidatedStockLedgerDtl(vo);
					
					String strStockLedgerDetails ="";
					
					if(vo.getStrItemBrandId().equals("0"))
					{
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedger(vo,"DRUG_WISE");
					}
					else if(vo.getStrDWHId().equals("0"))
					{
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedger(vo,"DDW_WISE");
					}
					else
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedger(vo,"DRUG_WISE");
					
					strStockLedgerDetails = strStockLedgerDetails.replace("@@@@", "%");
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strStockLedgerDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.StockLedgerRptDATA.getStockLedgerDtl --> "	+ e.getMessage();
					HisException eObj = new HisException("mms",	"StockLedgerRptDATA->getStockLedgerDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	

	 /**
	  * 
	  * @param formBean
	  * @param request
	  * @param response
	  */
	 public static void getStockLedgerDtlPopUp(StockLedgerRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				StockLedgerRptBO bo = null;
				StockLedgerRptVO vo = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new StockLedgerRptBO();
					vo = new StockLedgerRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrDWHId(  (request.getParameter("storeId")==null || request.getParameter("storeId").equals("") ) ? "0": request.getParameter("storeId"));
					
					vo.setStrItemBrandId((request.getParameter("itembrandId")==null || request.getParameter("itembrandId").equals("") || request.getParameter("itembrandId").equals("0") ) ? "0": request.getParameter("itembrandId").split("^")[0]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					vo.setStrWhetherBatchWise( (request.getParameter("batchFlag")==null || request.getParameter("batchFlag").equals("") ) ? "0": request.getParameter("batchFlag"));
					
					vo.setStrStoreName(request.getParameter("storeName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					
					if(vo.getStrWhetherBatchWise().equals("1"))
					{
						vo.setStrMode("1");	// Batch Wise
					}
					else
					{
						vo.setStrMode("2");	// Without Batch Wise
					}
					
					
					vo.setStrItemCatId(formBean.getStrItemCatNo());
					//vo.setStrItemCatId("10");
					  
						/*//System.out.println("mode:"+vo.getStrMode());
						//System.out.println("vo.getStrDWHId()"+vo.getStrDWHId());
						//System.out.println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
						//System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
						//System.out.println("vo.getStrToDate()"+vo.getStrToDate());
						//System.out.println("vo.getStrWhetherBatchWise()"+vo.getStrWhetherBatchWise());
						//System.out.println("vo.getStrMode()"+vo.getStrMode());
						//System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId());
						//System.out.println("vo.getStrStoreName()"+vo.getStrStoreName());
						//System.out.println("vo.getStrDrugName()"+vo.getStrDrugName());*/
					
									
					// Calling BO
					bo.getConsolidatedStockLedgerDtl(vo);
					
					String strStockLedgerDetails ="";
					
					if(vo.getStrItemBrandId().equals("0"))
					{
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedgerPopUp(vo,"DRUG_WISE");
					}
					else if(vo.getStrDWHId().equals("0"))
					{
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedgerPopUp(vo,"DDW_WISE");
					}
					else
						strStockLedgerDetails = StockLedgerRptHLP.getStockLedgerPopUp(vo,"DRUG_WISE");
					
					
					//formBean.setStrStockLedgerPopUp(strStockLedgerDetails);
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strStockLedgerDetails);	
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.StockLedgerRptDATA.getStockLedgerDtlPopUp --> "	+ e.getMessage();
					HisException eObj = new HisException("mms",	"StockLedgerRptDATA->getStockLedgerDtlPopUp()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 
	 /**
	  * To get Detailed Stock Ledger Dtl
	  * 
	  * @param formBean
	  * @param request
	  * @param response
	  */
	 public static void getDetailedStockLedger(StockLedgerRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				StockLedgerRptBO bo = null;
				StockLedgerRptVO vo = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new StockLedgerRptBO();
					vo = new StockLedgerRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrDWHId(  (request.getParameter("storeId")==null || request.getParameter("storeId").equals("") ) ? "0": request.getParameter("storeId"));
					
					vo.setStrItemBrandId((request.getParameter("itembrandId")==null || request.getParameter("itembrandId").equals("") || request.getParameter("itembrandId").equals("0") ) ? "0": request.getParameter("itembrandId").split("^")[0]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					vo.setStrBatchNo( (request.getParameter("batchNo")==null || request.getParameter("batchNo").equals("") ) ? "0": request.getParameter("batchNo"));
					
					vo.setStrStoreName(request.getParameter("storeName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					vo.setRate(request.getParameter("rate"));
					vo.setStrOpeningBalance(request.getParameter("openingBalanceActive")+"#"+request.getParameter("openingBalanceInActive")+"#"+request.getParameter("openingBalanceQuarantine"));
					vo.setStrBatchFlag((request.getParameter("batchFlg")==null || request.getParameter("batchFlg").equals("") ) ? "0": request.getParameter("batchFlg"));
					vo.setStrItemCatId((request.getParameter("catcode")==null || request.getParameter("catcode").equals("") ) ? "0": request.getParameter("catcode"));
					
					vo.setStrMode("1");	
					
									
					
					//vo.setStrItemCatId("10");
										
					/*//System.out.println("vo.getStrDWHId()"+vo.getStrDWHId());
					//System.out.println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
					//System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
					//System.out.println("vo.getStrToDate()"+vo.getStrToDate());
					//System.out.println("vo.getStrBatchNo()"+vo.getStrBatchNo());
					//System.out.println("vo.getStrMode()"+vo.getStrMode());
					//System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId());
					//System.out.println("vo.getStrOpeningBalance()"+vo.getStrOpeningBalance());*/
					// Calling BO
					bo.getDetailedStockLedgerDtl(vo);
					
					String strStockLedgerDetails = StockLedgerRptHLP.getDetailedStockLedgerDtl(vo);
					
					
					////System.out.println("strStockLedgerDetails"+strStockLedgerDetails);
					
					strStockLedgerDetails = strStockLedgerDetails.replace("@@@@", "%");
					
//					 url = (url.replace('%', '@@@@'));
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strStockLedgerDetails);	
					
					//formBean.setStrStockLedgerDetails(strStockLedgerDetails);
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.StockLedgerRptDATA.getDetailedStockLedgerDtl --> "	+ e.getMessage();
					HisException eObj = new HisException("mms",	"StockLedgerRptDATA->getStockLedgerDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
	 
	 
	 /**
	  * To get Detailed Stock Ledger Dtl
	  * 
	  * @param formBean
	  * @param request
	  * @param response
	  */
	 public static void getDetailedStockLedgerDtlPopUp(StockLedgerRptFB formBean,	HttpServletRequest request, HttpServletResponse response) 
	 {

				StockLedgerRptBO bo = null;
				StockLedgerRptVO vo = null;
				HisUtil util = null;
				String strmsgText = null;
				
				try 
				{
					bo = new StockLedgerRptBO();
					vo = new StockLedgerRptVO();
													
					vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
					vo.setStrDWHId(  (request.getParameter("storeId")==null || request.getParameter("storeId").equals("") ) ? "0": request.getParameter("storeId"));
					
					vo.setStrItemBrandId((request.getParameter("itembrandId")==null || request.getParameter("itembrandId").equals("") || request.getParameter("itembrandId").equals("0") ) ? "0": request.getParameter("itembrandId").split("^")[0]);
					vo.setStrFromDate(request.getParameter("fromDate"));
					vo.setStrToDate(request.getParameter("toDate"));
					
					vo.setStrBatchNo( (request.getParameter("batchNo")==null || request.getParameter("batchNo").equals("") ) ? "0": request.getParameter("batchNo"));
					
					vo.setStrStoreName(request.getParameter("storeName"));
					vo.setStrDrugName(request.getParameter("drugName"));
					
					vo.setStrOpeningBalance(request.getParameter("openingBalanceActive")+"#"+request.getParameter("openingBalanceInActive")+"#"+request.getParameter("openingBalanceQuarantine"));
					
					vo.setStrBatchFlag((request.getParameter("batchFlg")==null || request.getParameter("batchFlg").equals("") ) ? "0": request.getParameter("batchFlg"));
					vo.setStrItemCatId((request.getParameter("catcode")==null || request.getParameter("catcode").equals("") ) ? "0": request.getParameter("catcode"));
					vo.setRate(request.getParameter("rate"));
					vo.setStrMode("1");	
					
									
					
//					/vo.setStrItemCatId("10");
										
					/*//System.out.println("vo.getStrDWHId()"+vo.getStrDWHId());
					//System.out.println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
					//System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
					//System.out.println("vo.getStrToDate()"+vo.getStrToDate());
					//System.out.println("vo.getStrBatchNo()"+vo.getStrBatchNo());
					//System.out.println("vo.getStrMode()"+vo.getStrMode());
					//System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId());
					//System.out.println("vo.getStrOpeningBalance()"+vo.getStrOpeningBalance());*/
					
					
									
					// Calling BO
					bo.getDetailedStockLedgerDtl(vo);
					
					String strStockLedgerDetails = StockLedgerRptHLP.getDetailedStockLedgerDtlPopup(vo);
					
					strStockLedgerDetails = strStockLedgerDetails.replace("@@@@", "%");
					
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strStockLedgerDetails);	
					
					//formBean.setStrStockLedgerDetails(strStockLedgerDetails);
					
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}
						
				} 
				catch (Exception e) 
				{
					strmsgText = "mms.transactions.StockLedgerRptDATA.getDetailedStockLedgerDtl --> "	+ e.getMessage();
					HisException eObj = new HisException("mms",	"StockLedgerRptDATA->getStockLedgerDtl()", strmsgText);
					formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
					eObj = null;
				}
				finally 
				{
				
					if (bo != null)
						bo = null;
					if (vo != null)
						vo = null;
					if (util != null)
						util = null;
					}
				}
}
