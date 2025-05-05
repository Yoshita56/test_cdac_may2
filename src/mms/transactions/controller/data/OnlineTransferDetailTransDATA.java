package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.OnlineTransferDetailTransBO;
import mms.transactions.controller.fb.OnlineTransferDetailTransFB;
import mms.transactions.controller.hlp.OnlineTransferDetailTransHLP;
import mms.transactions.vo.OnlineTransferDetailTransVO;

public class OnlineTransferDetailTransDATA 
{
	 public static  String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	  public static  String DATE_FORMAT_NOW = "dd-MMM-yyyy";
	    
	  public static  String now(String frmt)
	    {
	      HisUtil util=null;
	      String a="";
	      util=new HisUtil("transaction","PatientLeaveHLP");
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
	  
	public static void getInitDtls(OnlineTransferDetailTransFB formBean, HttpServletRequest request) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "",strOrderNoValues;
		String strmsgText = null;
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			util = new HisUtil("MMS Transactions", "OnlineTransferDetailTransDATA");
			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreDtls(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrStoreWs()!=null && vo.getStrStoreWs().size()>0)
			{
				if(vo.getStrStoreWs().next())
				{
					vo.setStrStoreId(vo.getStrStoreWs().getString(1));
					vo.getStrStoreWs().beforeFirst();
				}
				strStoreVal = util.getOptionValue(vo.getStrStoreWs(), "","", false);
			}
			else
			{
				strStoreVal = "<option value='0'>Select Value</option>";
			}
						
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			
			
			bo.getOrderNo(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrOrderNoWs()!=null && vo.getStrOrderNoWs().size()>0)
			{
				strOrderNoValues = util.getOptionValue(vo.getStrOrderNoWs(), "0","0^Select Value", false);
			}
			else
			{
				strOrderNoValues = "<option value='0'>Select Value</option>";
			}
						
			formBean.setStrOrderNoValues(strOrderNoValues);
			
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrTransferDateTime(now(DATE_FORMAT_NOWwt));
			formBean.setStrCtDate(now(DATE_FORMAT_NOW));
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OnlineTransferDetailTransDATA->getStoreDtls()", strmsgText);
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
	
	public static void getOrderNo(OnlineTransferDetailTransFB formBean, HttpServletRequest request,HttpServletResponse response) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		HisUtil util = null;
		String strOrderNoValues = "";
		String strmsgText = null;
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			util = new HisUtil("MMS Transactions", "OnlineTransferDetailTransDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			
		
			String strTransferStoreId = request.getParameter("transferStoreId");
				
			vo.setStrMode("1");
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrStoreId(strTransferStoreId);
			
			bo.getOrderNo(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			if(vo.getStrOrderNoWs()!=null && vo.getStrOrderNoWs().size()>0)
			{
				strOrderNoValues = util.getOptionValue(vo.getStrOrderNoWs(), "","", false);
			}
			else
			{
				strOrderNoValues = "<option value='0'>Select Value</option>";
			}
						
			response.setHeader("Cache-Control", "no-cache");
		 	response.getWriter().print(strOrderNoValues);
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.getStoreDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"OnlineTransferDetailTransDATA->getStoreDtls()", strmsgText);
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
	
	
	
	
	public static void initGoPage(OnlineTransferDetailTransFB formBean, HttpServletRequest request) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		String strBatchDetailsTable;
		
		String strOrderDate,strReceivingDDWName,strOrderQty,strDrugName,strOrderQtyBase ;
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			util = new HisUtil("MMS Transactions", "OnlineTransferDetailTransDATA");
			
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrOrderNo(formBean.getStrOrderNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemBrandId("0");
			vo.setStrItemId("0");
			vo.setStrTransferNo("0");
			
			vo.setStrMode("1");
			
			bo.getData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
			/*
			 * 1 ORDER_DATE
			 * 2 ORDER_QTY
			 * 3 REC_DDW
			 * 4 DRUG_NAME
			 * 5 HSTNUM_ITEM_ID
			 * 6 HSTNUM_ITEMBRAND_ID 
			 * 7 HSTNUM_DEMAND_STORE_ID
			 */
		
			if(vo.getWrsData()!=null && vo.getWrsData().size()>0)
			{
				vo.getWrsData().beforeFirst();
				
				if(vo.getWrsData().next())
				{
					strOrderDate			= 	vo.getWrsData().getString("ORDER_DATE");
					strReceivingDDWName		= 	vo.getWrsData().getString("REC_DDW");
					strOrderQty				= 	vo.getWrsData().getString("ORDER_QTY");				
					strDrugName				= 	vo.getWrsData().getString("DRUG_NAME");
					strOrderQtyBase 		= 	vo.getWrsData().getString("ORDER_QTY_BASE"); 
					
					formBean.setStrOrderDate(strOrderDate);
					formBean.setStrDrugName(strDrugName);
					formBean.setStrOrderQty(strOrderQty);
					formBean.setStrReceivingDDWName(strReceivingDDWName);	
					formBean.setStrToStoreId(vo.getWrsData().getString("HSTNUM_DEMAND_STORE_ID"));
					formBean.setStrItemBrandId(vo.getWrsData().getString("HSTNUM_ITEMBRAND_ID"));
					formBean.setStrOrderQtyBase(strOrderQtyBase);
					
					vo.setStrItemBrandId(vo.getWrsData().getString("HSTNUM_ITEMBRAND_ID"));
					vo.setStrItemId(vo.getWrsData().getString("HSTNUM_ITEM_ID"));
					vo.setStrToStoreId(vo.getWrsData().getString("HSTNUM_DEMAND_STORE_ID"));
					
					vo.setStrTransferNo("0");
					vo.setStrMode("2");
					
					bo.getData(vo);
					
					
					if(vo.getWrsData()!=null && vo.getWrsData().size()>0)
					{
						vo.getWrsData().beforeFirst();
						strBatchDetailsTable	=	OnlineTransferDetailTransHLP.getBatchDetailsTable(vo.getWrsData());
						
						formBean.setStrBatchDetailsTable(strBatchDetailsTable);
						
					}	
				}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.getStoreDtls --> "+ e.getMessage();
			HisException eObj = new HisException("mms","OnlineTransferDetailTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	 * This function used to set initial parameters for view Page.
	 * @param _OnlineTransferDetailTransFB
	 * @param request
	 */
	public static void getViewDtl(OnlineTransferDetailTransFB _OnlineTransferDetailTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OnlineTransferDetailTransVO vo = null;
		   OnlineTransferDetailTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new OnlineTransferDetailTransVO();
			   	bo=new OnlineTransferDetailTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));
			   	
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
//			    String strResult = OnlineTransferDetailTransHLP.getIssuedDetail(vo.getStrIssueDetailWs());

			    if(true)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
//				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "OnlineTransferDetailTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OnlineTransferDetailTransDATA->getViewDtl()", strmsgText);
				_OnlineTransferDetailTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				//_OnlineTransferDetailTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	/**
	 * searchTransferDetail For View Page
	 * @param formBean
	 * @param request
	 */
	public static void searchTransferDetail(OnlineTransferDetailTransFB formBean, HttpServletRequest request,HttpServletResponse response) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		
		String strmsgText = null;
		String strTransferDetailsTable;
		
		
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrOrderNo("0");
			vo.setStrStoreId(request.getParameter("transferStoreId"));
			vo.setStrItemBrandId("0");
			vo.setStrItemId("0");
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));
			vo.setStrTransferNo("0");
			vo.setStrMode("3");
			
			bo.getData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
						strTransferDetailsTable	=	OnlineTransferDetailTransHLP.getTransferDetailsTable(vo.getWrsData());
						
						response.setHeader("Cache-Control", "no-cache");
					 	response.getWriter().print(strTransferDetailsTable);
					 		 
										
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.getStoreDtls --> "+ e.getMessage();
			HisException eObj = new HisException("mms","OnlineTransferDetailTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
		}
	}
	
	
	/**
	 * searchTransferDetail For View Page
	 * @param formBean
	 * @param request
	 */
	public static void getItemDetailsTable(OnlineTransferDetailTransFB formBean, HttpServletRequest request,HttpServletResponse response) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		
		String strmsgText = null;
		String strTransferDetailsTable;
		
		
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrOrderNo("0");
			vo.setStrTransferNo(request.getParameter("transferNo"));
			vo.setStrItemBrandId("0");
			vo.setStrItemId("0");
			vo.setStrFromDate("0");
			vo.setStrToDate("0");
			vo.setStrStoreId(request.getParameter("strId"));
			
			
			vo.setStrMode("4");
			
			bo.getData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
						strTransferDetailsTable	=	OnlineTransferDetailTransHLP.getItemDetailsTable(vo.getWrsData());
						
						response.setHeader("Cache-Control", "no-cache");
					 	response.getWriter().print(strTransferDetailsTable);
					 		 
										
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.getStoreDtls --> "+ e.getMessage();
			HisException eObj = new HisException("mms","OnlineTransferDetailTransDATA->getStoreDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
		}
	}
	
	
	
	/**
	 * INSERT
	 * @param formBean
	 * @param request
	 */
	public static void insert(OnlineTransferDetailTransFB formBean, HttpServletRequest request) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		int chkLength = 0;
		HisUtil util = null;
		String strmsgText = null;
		
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
		
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrTransferQty(formBean.getStrTransferQty());
			vo.setStrAvailableQty(formBean.getStrAvailableQty());
			vo.setStrRatePerUnit(formBean.getStrRatePerUnit());
			vo.setStrCost(formBean.getStrCost());
			
			
			vo.setBatchCheckbox(formBean.getBatchCheckbox());
			vo.setCheckboxFlag(formBean.getCheckboxFlag());
			
			vo.setStrTotalTransferredCost(formBean.getStrTotalTransferredCost());
			vo.setStrTotalTransferredQty(formBean.getStrTotalTransferredQty());
			vo.setStrRemarks(formBean.getStrRemarks());
			
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrToStoreId(formBean.getStrToStoreId());
			vo.setStrOrderNo(formBean.getStrOrderNo()); // *
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrMode("1");
			
			// Calling BO Method
			bo.insert(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				
					formBean.setStrErrMsg(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
						
			}
			else 
			{
//				formBean.setStrDwhName(vo.getStrDwhName());
				formBean.setStrTmpTransferNo(vo.getStrTransferNo());
				formBean.setStrTmpStoreNo(vo.getStrStoreId());
				formBean.setStrTmpTransferDate(vo.getStrCtDate());
			
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.insert --> "+ e.getMessage();
			HisException eObj = new HisException("mms","OnlineTransferDetailTransDATA->insert()", strmsgText);
		    	
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
		    

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
	
	

	
	public static void cancelDrugTransferDtl(OnlineTransferDetailTransFB formBean, HttpServletRequest request) {

		OnlineTransferDetailTransBO bo = null;
		OnlineTransferDetailTransVO vo = null;

		HisUtil util = null;
		String strmsgText = null;
		
		try {
			bo = new OnlineTransferDetailTransBO();
			vo = new OnlineTransferDetailTransVO();
			formBean.setStrHospitalCode((String) request.getSession().getAttribute("HOSPITAL_CODE"));
			formBean.setStrSeatId((String) request.getSession().getAttribute("SEATID"));
			
		
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrTransferNo(formBean.getStrTransferNo());
			
			vo.setStrRemarks(formBean.getStrRemarks());	
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrMode("1");
			
			// Calling BO Method
			bo.cancelDrugTransferDtl(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				
					formBean.setStrErrMsg(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
						
			}
			else
			formBean.setStrNormalMsg("Record Cancelled Successfully");
			formBean.setStrRemarks("");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.OnlineTransferDetailTransDATA.insert --> "+ e.getMessage();
			HisException eObj = new HisException("mms","OnlineTransferDetailTransDATA->insert()", strmsgText);
		    	
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");
		    

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
	 * This function used to set initial parameters for view Page.
	 * @param _BreakageItemDtlTransFB
	 * @param request
	 */
	public static void getTransferDtl(OnlineTransferDetailTransFB _OnlineTransferDetailTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   OnlineTransferDetailTransVO vo = null;
		   OnlineTransferDetailTransBO bo = null;
		   String strResult = "A";
		   try{
			   	
			    vo=new OnlineTransferDetailTransVO();
			   	bo=new OnlineTransferDetailTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrTransferNo(request.getParameter("transferNo"));
			   	
			   	
			   	bo.getTransferDtl(vo);
			   
			    strResult=OnlineTransferDetailTransHLP.getTransferDetails(vo.getTransferDtlWs(),request.getParameter("dwhName"));
			    if(strResult!= null)
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	
				 	response.getWriter().print(strResult);
				 		 
				}
				 else
				 {
				    HisException eObj = new HisException("MMS", "OnlineTransferDetailTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "OnlineTransferDetailTransDATA->getViewDtl()", strmsgText);
				_OnlineTransferDetailTransFB.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				_OnlineTransferDetailTransFB.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
}
