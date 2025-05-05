package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.SampleSentTransBO;
import mms.transactions.controller.fb.SampleSentTransFB;
import mms.transactions.controller.hlp.SampleSentTransHLP;
import mms.transactions.vo.SampleSentTransVO;

public class SampleSentTransDATA 
{
			/**
		
		 * Method is Used to Populate the Data for Save Page of
		 * Breakage Item Details Transaction 
		 * @param formBean
		 * @param request
		 */
		public static void initSampleSent(SampleSentTransFB _SampleSentTransFB,HttpServletRequest request) 
		{
			/* Declaring Variable */
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			String strmsgText = "";
			String hosCode = "";
			HisUtil hisUtil=null;
			String seatId = "";
    		String strCostRequired="";
			try 
			{
				/* Creating Object */
				
				bo = new SampleSentTransBO();
				vo = new SampleSentTransVO();
				hisUtil=new HisUtil("MMSModule", "SampleSentTransDATA");
			
		        /* Getting Value from Session */ 
				
				hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatId  = request.getSession().getAttribute("SEATID").toString();
							
		       	vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatId);
				
				//strCostRequired=mmsConfig.getStrCostReq();    // Please Check It
				
				strCostRequired="1";
				////System.out.println("strCostRequired"+strCostRequired);
				/* Calling SampleSentTransBO method  */
				
				bo.initSampleSent(vo);
				
				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
					bo.ITEMCATEGORYCOMBO(vo);
				 _SampleSentTransFB.setStrStoreName(vo.getStrStoreName());
				 _SampleSentTransFB.setStrHospitalCode(hosCode);
				 _SampleSentTransFB.setStrSeatId(seatId);
				 _SampleSentTransFB.setStrItemCategoryCombo(vo.getStrItemCatgCombo());
				 
				
				 _SampleSentTransFB.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
				 _SampleSentTransFB.setStrCostRequired(strCostRequired);
				 _SampleSentTransFB.setStrLabNameCombo(vo.getStrLabNameCombo());
				 
				 ResourceBundle resObj = mms.qryHandler_mms.res;
					if(resObj == null) 
					{
						resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
						mms.qryHandler_mms.res = resObj;
					}
					
				 _SampleSentTransFB.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
				
			}
			  catch (Exception e) 
			  {
		       
				strmsgText = "BreakgeItemDtlTransDATA.initSampleSent(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms","SampleSentTransDATA->initSampleSent()", strmsgText);
				_SampleSentTransFB.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");
		
				eObj = null;
			} finally {
				bo = null;
				vo = null;
			}

     }
		
	
		
		public static void viewSampleSent(SampleSentTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
		{

					SampleSentTransBO bo = null;
					SampleSentTransVO vo = null;
					HisUtil util = null;
					String strmsgText = null;
					
					try 
					{
						bo = new SampleSentTransBO();
						vo = new SampleSentTransVO();
						
						vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
						
						vo.setStrStoreId(request.getParameter("storeId"));
						vo.setStrFromDate(request.getParameter("fromDate"));
						vo.setStrToDate(request.getParameter("toDate"));
						vo.setStrLabId((request.getParameter("labId")==null || request.getParameter("labId").equals("") ) ? "0" : request.getParameter("labId").split("\\^")[0]);
						vo.setStrSearchType(request.getParameter("searchType"));						
						// BO Method
						bo.getViewHlp(vo);
						
						String strSampleSentLabel = SampleSentTransHLP.getViewSampleSentDetails(vo);
						
						
						
						response.setHeader("Cache-Control", "no-cache");
						response.getWriter().print(strSampleSentLabel);	
						
						if (vo.getStrMsgType().equals("1")) 
						{
							throw new Exception(vo.getStrMsgString());
						}
							
					} 
					catch (Exception e) 
					{
						strmsgText = "mms.transactions.IssueTransDATA.viewSampleSent() --> "
								+ e.getMessage();
						HisException eObj = new HisException("mms",
								"IssueTransDATA->getItemDetails()", strmsgText);
						formBean.setStrErrMsg("Application Error [ERROR ID : "
								+ eObj.getErrorID() + "],Contact System Administrator! ");
						
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
		
		
		 public static void printSampleLabelView(SampleSentTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
		 {

					SampleSentTransBO bo = null;
					SampleSentTransVO vo = null;
					HisUtil util = null;
					String strmsgText = null;
					
					try 
					{
						bo = new SampleSentTransBO();
						vo = new SampleSentTransVO();
						
						vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
						
						////System.out.println("request.getParameter(strHiddenDtl)==>"+request.getParameter("strSampleSentPrintHiddenDtl"));
						String strSampleSentLabel = SampleSentTransHLP.getPrintSampleSentLabelView(request.getParameter("strSampleSentPrintHiddenDtl"));
						
						
						response.setHeader("Cache-Control", "no-cache");
						response.getWriter().print(strSampleSentLabel);	
						
						if (vo.getStrMsgType().equals("1")) 
						{
							throw new Exception(vo.getStrMsgString());
						}
							
					} 
					catch (Exception e) 
					{
						strmsgText = "mms.transactions.IssueTransDATA.printSampleLabel() --> "
								+ e.getMessage();
						HisException eObj = new HisException("mms",
								"IssueTransDATA->getItemDetails()", strmsgText);
						formBean.setStrErrMsg("Application Error [ERROR ID : "
								+ eObj.getErrorID() + "],Contact System Administrator! ");
						
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
		
		
		 public static void printSampleLabel(SampleSentTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
		 {

					SampleSentTransBO bo = null;
					SampleSentTransVO vo = null;
					HisUtil util = null;
					String strmsgText = null;
					
					try 
					{
						bo = new SampleSentTransBO();
						vo = new SampleSentTransVO();
						
						vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
						vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
						vo.setStrLabSendNo(request.getParameter("labSendNo"));
						vo.setStrCTRNumber(request.getParameter("ctrNo"));
						vo.setStrHiddenBatchDtl(request.getParameter("strHiddenBatchDtl"));
						vo.setStrDrugName(request.getParameter("drugName"));
						vo.setStrBatchNo(request.getParameter("batchNo"));
						vo.setStrLabCode(request.getParameter("labCode"));
						String strSampleSentLabel = SampleSentTransHLP.getPrintSampleSentLabel(vo);
						
						
						response.setHeader("Cache-Control", "no-cache");
						response.getWriter().print(strSampleSentLabel);	
						
						if (vo.getStrMsgType().equals("1")) 
						{
							throw new Exception(vo.getStrMsgString());
						}
							
					} 
					catch (Exception e) 
					{
						strmsgText = "mms.transactions.IssueTransDATA.printSampleLabel() --> "
								+ e.getMessage();
						HisException eObj = new HisException("mms",
								"IssueTransDATA->getItemDetails()", strmsgText);
						formBean.setStrErrMsg("Application Error [ERROR ID : "
								+ eObj.getErrorID() + "],Contact System Administrator! ");
						
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
		
		public static void getDrugBatchDtl(SampleSentTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
		{

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			
			try {

				vo = new SampleSentTransVO();
				bo = new SampleSentTransBO();

				String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

				String   strStoreId = (String) request.getParameter("storeId");
				String strDrugBrandId = (String) request.getParameter("strDrugBrandId");
				String strReSendFlg = (String) request.getParameter("resenFlg");
				String strBatchNo = (String) request.getParameter("strBatchNo");
				vo.setStrBatchNo(strBatchNo);
                vo.setStrDrugBrandId(strDrugBrandId);
				vo.setStrStoreId(strStoreId);
				vo.setStrHospitalCode(strHospitalCode);
                vo.setStrReSendFlg(strReSendFlg);
                
                
				bo.getDrugBatchDtl(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				

				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(vo.getStrBatchDetails());
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->getDrugBatchDtl()", strmsgText);
				try {

					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {
					e.printStackTrace();
				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				
			}
		}
		
		
		
		public static void getDrugNameCmb(SampleSentTransFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			HisUtil hisutil = null;
			try {

				vo = new SampleSentTransVO();
				bo = new SampleSentTransBO();

				String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

				String   strStoreId = (String) request.getParameter("storeId");
				String strReSendFlg = (String) request.getParameter("resenFlg");

				vo.setStrStoreId(strStoreId);
				vo.setStrHospitalCode(strHospitalCode);
                vo.setStrReSendFlg(strReSendFlg);
                
                
				bo.getDrugNameCmb(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}

				hisutil = new HisUtil("mms", "SampleSentTransDATA");

				String cmbstr = "";

				if (vo.getWsDrugNameCombo() != null	&& vo.getWsDrugNameCombo().size() > 0)
				{

					cmbstr = hisutil.getOptionValue(vo.getWsDrugNameCombo(),"", "0^Select Value", false);

				} else {

					cmbstr = "<option value='0'>Select Value</option>";
				}

				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(cmbstr);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->getCategoryCmb()", strmsgText);
				try {

					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {
					e.printStackTrace();
				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				hisutil = null;
			}
		}
		
		public static void getDrugNameCmbForNewProcess(SampleSentTransFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			HisUtil hisutil = null;
			try {

				vo = new SampleSentTransVO();
				bo = new SampleSentTransBO();

				String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

				String   strStoreId = (String) request.getParameter("storeId");
				String strReSendFlg = (String) request.getParameter("resenFlg");

				vo.setStrStoreId(strStoreId);
				vo.setStrHospitalCode(strHospitalCode);
                vo.setStrReSendFlg(strReSendFlg);
                
                
				bo.getDrugNameCmb(vo);

				String str = SampleSentTransHLP.getIndentItemList(vo);

				try 
				{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(str);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->getCategoryCmb()", strmsgText);
				try {

					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {
					e.printStackTrace();
				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				hisutil = null;
			}
		}
		
		public static void getCategoryCmb(SampleSentTransFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			HisUtil hisutil = null;
			try {

				vo = new SampleSentTransVO();
				bo = new SampleSentTransBO();

				String strHospitalCode = request.getSession().getAttribute(
						"HOSPITAL_CODE").toString();

				String strStoreId = (String) request.getParameter("storeId");

				vo.setStrStoreId(strStoreId);
				vo.setStrHospitalCode(strHospitalCode);

				bo.getCategoryCmb(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}

				hisutil = new HisUtil("mms", "ItemInventoryTransDATA");

				String cmbstr = "";

				if (vo.getWsItemCategoryCombo() != null	&& vo.getWsItemCategoryCombo().size() > 0)
				{

					cmbstr = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),"", "", false);

				} else {

					cmbstr = "<option value='0'>Select Value</option>";
				}

				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(cmbstr);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->getCategoryCmb()", strmsgText);
				try {

					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {
					e.printStackTrace();
				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				hisutil = null;
			}
		}
		
		public static void getDrugBatchCmb(SampleSentTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
		{

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			HisUtil hisutil = null;
			try {

				vo = new SampleSentTransVO();
				bo = new SampleSentTransBO();

				String strHospitalCode = request.getSession().getAttribute(
						"HOSPITAL_CODE").toString();

				String strDrugBrandId = (String) request.getParameter("strDrugBrandId");
				String strReSendFlg = (String) request.getParameter("resenFlg");
				String strStoreId = (String) request.getParameter("storeId");

				vo.setStrStoreId(strStoreId);
				
				vo.setStrHospitalCode(strHospitalCode);
                vo.setStrReSendFlg(strReSendFlg);
				vo.setStrDrugBrandId(strDrugBrandId);
				vo.setStrHospitalCode(strHospitalCode);

				bo.getDrugBatchCmb(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}

				hisutil = new HisUtil("mms", "ItemInventoryTransDATA");

				String cmbstr = "";

				if (vo.getWsDrugBatchCombo() != null	&& vo.getWsDrugBatchCombo().size() > 0)
				{

					cmbstr = hisutil.getOptionValue(vo.getWsDrugBatchCombo(),"", "0^Select Value", false);

				} else {

					cmbstr = "<option value='0'>Select Value</option>";
				}

				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(cmbstr);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {

				e.printStackTrace();

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->getDrugBatchCmb()", strmsgText);
				try {

					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {
					e.printStackTrace();
				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				hisutil = null;
			}
		}
		
		/**
		 * To get values of Unit on the basics of Item Name combo
		 * 
		 * @param formBean
		 * @param request
		 */

		public static void unitNameCombo(SampleSentTransFB formBean,
				HttpServletRequest request, HttpServletResponse response) {

			String strmsgText = "";
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			 MmsConfigUtil mcu = null;

			try {

				bo = new SampleSentTransBO();
				vo = new SampleSentTransVO();

				String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				mcu = new MmsConfigUtil(strHospitalCode);
				String strSeatId = request.getSession().getAttribute("SEATID")
						.toString();
				String strDrugBrandId = (String) request.getParameter("itemId");
				vo.setStrHospitalCode(strHospitalCode);
				vo.setStrSeatId(strSeatId);
				vo.setStrDrugBrandId(strDrugBrandId);
				// vo.setStrModuleId(mcu.getStrModuleId());
				vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
				
				bo.unitNameCombo(vo);				

				if (vo.getStrMsgType().equals("1")) 
				{				
					throw new Exception(vo.getStrMsgString());
				}

				HisUtil hisutil = new HisUtil("mms", "SampleSentTransDATA");
				
				String cmbstr = hisutil.getOptionValue(vo.getWsUnitCombo(),"6301^1^0", "0^Select Value", false);

				/*
				 * HisUtil hisutil1 = new HisUtil("mms", "SampleSentTransDATA");
				 * String cmbstr1 =
				 * hisutil1.getOptionValue(vo.getStrUnitSaleComboWS(),
				 * vo.getStrUnitSaleID(), "0^Select Value", false);
				 */

				try {
					// //System.out.println("cmbstr" + cmbstr);
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(cmbstr);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} catch (Exception e) {
				strmsgText = "DrugInventory.SampleSentTransDATA.unitNameCombo(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->unitNameCombo()", strmsgText);
				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(
							"ERROR#### Application Error [ERROR ID : "
									+ eObj.getErrorID()
									+ "],Contact System Administrator! ");

				} catch (Exception e1) {

				}

				eObj = null;
			} finally {
				vo = null;
				bo = null;
				mcu = null;
			}
		}
		
		
		/**
		 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
		 * Breakage Item Detail Transaction 
		 * @param formBean
		 * @param request
		 */
		
		public static boolean  insert(SampleSentTransFB formBean)
		{
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			String strmsgText = "";
			MmsConfigUtil mcu = null;

	        String strFinancialStartYear = "";

	        String strFinancialEndYear = "";
	        boolean retValue = true;
	      
			try 
			{
									  bo = new SampleSentTransBO();
									  vo = new SampleSentTransVO();
		         
		    	String           hosCode = formBean.getStrHospitalCode();
		    	String           seatid  = formBean.getStrSeatId();
							    	mcu  = new MmsConfigUtil(hosCode);
				
				strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreId() , hosCode);
				  strFinancialEndYear = mcu.getStrFinancialEndDate(formBean.getStrStoreId() , hosCode);
				 
				vo.setStrHiddenBatchDtl(formBean.getStrHiddenBatchDtl());
                vo.setStrFinancialEndYear(strFinancialEndYear);
                vo.setStrFinancialStartYear(strFinancialStartYear);
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrSampleIssueQty(formBean.getStrSampleIssueQty());
				vo.setStrSampleUnitId(formBean.getStrSampleUnitId());
				vo.setStrLabId(formBean.getStrLabId());
				vo.setStrCTRNumber(formBean.getStrCTRNumber());
				vo.setStrSampleCodeNumber(formBean.getStrSampleCodeNumber());
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrItemBrandId(formBean.getStrItemBrandId());
				vo.setStrItemCategoryCode(formBean.getStrItemCategoryCode());
				String strDescription = "Through Issue Sample to Lab >> From HQ Name: "+formBean.getStrStoreName()+" To Lab Name:"+formBean.getStrLabName();
				vo.setStrDescription(strDescription);
				vo.setStrBatchNo(formBean.getStrBatchNo());
				vo.setStrSampleIssueQty(formBean.getStrSampleIssueQty());
				vo.setStrSampleUnitId(formBean.getStrSampleUnitId());
				vo.setStrReSendFlg(formBean.getStrResendFlag());
				vo.setStrDrugName(formBean.getStrDrugName());
									
				bo.INSERT(vo);
				
				formBean.setStrHiddenBatchDtl(vo.getStrHiddenBatchDtl());
				
	    		if (vo.getStrMsgType().equals("1")) 
				{
	    			retValue = false;    			
	    			 if(vo.getStrMsgString().split("\\##")[2].equals("999"))
					    {
		    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
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
	        		formBean.setStrLabSendNo(vo.getStrLabSendNo());
	        		formBean.setStrPBatchNo(vo.getStrBatchNo());
	        		formBean.setStrPCTRNo(vo.getStrCTRNumber());
	        		formBean.setStrPExpDate(vo.getStrHiddenBatchDtl().split("\\^")[3]);
	        		formBean.setStrPManufDate(vo.getStrHiddenBatchDtl().split("\\^")[3]);
	        		formBean.setStrPManufBy(vo.getStrHiddenBatchDtl().split("\\^")[1]);
	        		formBean.setStrDrugName(vo.getStrDrugName());  
	        		formBean.setStrLabCode(vo.getStrLabId().split("\\^")[0]);
	        		formBean.setStrMsg("Sample Send Successfully to Lab!!");
        		
				}
				
			}
			  catch (Exception e) 
			  {
	            e.printStackTrace(); 
	            retValue = false;
				strmsgText = "SampleSentTransDATA.INSERT(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->INSERT()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

				eObj = null;
			} finally {
				bo = null;
				vo = null;
				mcu = null;
			}
			return retValue;
		}
		
		
		/**
		 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
		 * Breakage Item Detail Transaction 
		 * @param formBean
		 * @param request
		 */
		
		public static boolean  insert1(SampleSentTransFB formBean)
		{
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			String strmsgText = "";
			MmsConfigUtil mcu = null;

	        String strFinancialStartYear = "";

	        String strFinancialEndYear = "";
	        boolean retValue = true;
	      
			try 
			{
									  bo = new SampleSentTransBO();
									  vo = new SampleSentTransVO();
		         
		    	String           hosCode = formBean.getStrHospitalCode();
				String           seatid  = formBean.getStrSeatId();
									mcu  = new MmsConfigUtil(hosCode);
				
				strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreId() , hosCode);
				  strFinancialEndYear = mcu.getStrFinancialEndDate(formBean.getStrStoreId() , hosCode);
				 
				
				vo.setStrNewSampleCodeNumber(formBean.getStrDSampleCodeNumber());
				vo.setStrNewSampleIssueQty(formBean.getStrDSampleIssueQty());
				vo.setItemUserValue(formBean.getItemUserValue());
				vo.setItemParamValue(formBean.getItemParamValue());
				vo.setHiddenValue(formBean.getHiddenValue());
			    vo.setStrFinancialEndYear(strFinancialEndYear);
                vo.setStrFinancialStartYear(strFinancialStartYear);
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrStoreId(formBean.getStrStoreId());				
				vo.setStrLabId(formBean.getStrLabId());				
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrItemCategoryCode(formBean.getStrItemCategoryId());
				String strDescription = "Issue Sample to Lab >> From HQ Name: "+formBean.getStrStoreName()+" To Lab Name:"+formBean.getStrLabName();
				vo.setStrDescription(strDescription);			
				vo.setStrReSendFlg(formBean.getStrResendFlag());								
				bo.INSERT(vo);
				
				//formBean.setStrHiddenBatchDtl(vo.getStrHiddenBatchDtl());
				
	    		if (vo.getStrMsgType().equals("1")) 
				{
	    			retValue = false;    			
	    			 if(vo.getStrMsgString().split("\\##")[2].equals("999"))
					    {
		    				////System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
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

	        		formBean.setStrMsg("Sample Send Successfully to Lab!!");
        		
				}
				
			}
			  catch (Exception e) 
			  {
	            e.printStackTrace(); 
	            retValue = false;
				strmsgText = "SampleSentTransDATA.INSERT(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->INSERT()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

				eObj = null;
			} finally {
				bo = null;
				vo = null;
				mcu = null;
			}
			return retValue;
		}
		
		
		/**
		 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL & HSTT_BREAKAGE_ITEM_DTL
		 * Breakage Item Detail Transaction 
		 * @param formBean
		 * @param request
		 */
		
		public static boolean  cancelRecords(SampleSentTransFB formBean)
		{
			SampleSentTransBO bo = null;
			SampleSentTransVO vo = null;
			String strmsgText = "";
			MmsConfigUtil mcu = null;

	        String strFinancialStartYear = "";

	        String strFinancialEndYear = "";
	        boolean retValue = true;
	      
			try 
			{
									  bo = new SampleSentTransBO();
									  vo = new SampleSentTransVO();
		         
		    	String           hosCode = formBean.getStrHospitalCode();
				String           seatid  = formBean.getStrSeatId();
									mcu  = new MmsConfigUtil(hosCode);
				
				strFinancialStartYear = mcu.getStrFinancialStartDate(formBean.getStrStoreId() , hosCode);
				  strFinancialEndYear = mcu.getStrFinancialEndDate(formBean.getStrStoreId() , hosCode);
//				for(int i=0;i<formBean.getStrCheckHidValue().length;i++)
//				{					
//					if(formBean.getStrCheckHidValue()[i].split("\\^")[33].equals("1"))
//					{
//						//System.out.println("Hidden Value==>"+formBean.getStrCheckHidValue()[i]);
//					}
//				}
				  
				vo.setChkFlg(formBean.getChkFlg());				
				vo.setStrCheckHidValue(formBean.getStrCheckHidValue());
			    vo.setStrFinancialEndYear(strFinancialEndYear);
                vo.setStrFinancialStartYear(strFinancialStartYear);
				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrStoreId(formBean.getStrStoreId());				
				vo.setStrLabId(formBean.getStrLabId());				
				vo.setStrRemarks(formBean.getStrRemarks());
				vo.setStrItemCategoryCode(formBean.getStrItemCategoryId());
                vo.setStrRemarks(formBean.getStrRemarks());												 
				
                bo.CANCELRECORDS(vo);
				
				//formBean.setStrHiddenBatchDtl(vo.getStrHiddenBatchDtl());
				
	    		if (vo.getStrMsgType().equals("1")) 
				{
	    			retValue = false;    			
	    			formBean.setStrErr(vo.getStrMsgString());
					throw new Exception(vo.getStrMsgString());
							
					
				}
	        	else 
				{

	        		formBean.setStrMsg("Sample Cancel Successfully!!");
        		
				}
				
			}
			  catch (Exception e) 
			  {
	            e.printStackTrace(); 
	            retValue = false;
				strmsgText = "SampleSentTransDATA.CANCELRECORDS(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"SampleSentTransDATA->CANCELRECORDS()", strmsgText);
				formBean.setStrErr("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

				eObj = null;
			} finally {
				bo = null;
				vo = null;
				mcu = null;
			}
			return retValue;
		}
		
		
}
