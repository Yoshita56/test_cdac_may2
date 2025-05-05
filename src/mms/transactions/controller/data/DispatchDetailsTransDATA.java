package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.DispatchDetailsTransBO;
import mms.transactions.controller.fb.DispatchDetailsTransFB;
import mms.transactions.controller.hlp.DispatchDetailsTransHLP;
import mms.transactions.vo.DispatchDetailsTransVO;


/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 09/April/2009
 *  Module:MMS
 * Process: Dispatch Details
 *
 */
/**
 * Developer :Baisakhi Roy
 * Version : 1.1 
 * Start Date : 08/May/2009
 * End Date : 12/May/2009
 *  Module:MMS
 * Process: Dispatch Details
 *
 */
public class DispatchDetailsTransDATA
{
	/** This method is used to populate the value of Store Name Combo box.
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(DispatchDetailsTransFB formBean,
			HttpServletRequest request) {

		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";
		
		String ctDate = "";
		String hosCode = "";
		String seatid = "";
		
		String strStoreNameValues = "";
		try {
			
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			 hisutil = new HisUtil("mms", "DispatchDetailsTransDATA");
			 ctDate = hisutil.getASDate("dd-MMM-yyyy");
			 formBean.setStrCtDate(ctDate);
			 
			 hosCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			 seatid=  request.getSession().getAttribute("SEATID").toString();
           	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			bo.getInitialValues(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getStrStoreNameValuesWS() != null && vo.getStrStoreNameValuesWS().size() > 0)
			{
				if(vo.getStrStoreNameValuesWS().next())
				{
					vo.setStrStoreId(vo.getStrStoreNameValuesWS().getString(1));
					vo.getStrStoreNameValuesWS().beforeFirst();
				}
				strStoreNameValues = hisutil.getOptionValue(vo.getStrStoreNameValuesWS(),"", "", true);
			}
			formBean.setStrStoreNameCmbValues(strStoreNameValues);
			vo.setStrReqTypeId("55");//55 --> Dispatch Register
			bo.getItemCategoryCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
			String cmb="";
				
			if (vo.getStrItemCategoryValuesWS()!= null && vo.getStrItemCategoryValuesWS().size() > 0) {
					cmb = hisutil.getOptionValue(vo.getStrItemCategoryValuesWS(),"0", "0^Select Value", false);
				} else {
					cmb = "<option value='0'>Select Value</option>";
				}
			formBean.setStrItemCategoryCmbValues(cmb);
		
		} catch (Exception e) {
			e.printStackTrace();
					
			strmsgText = "DispatchDetailsTransDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->getInitialValues()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo=null;
			vo=null;
			hisutil = null;
		}
	}

	/** This method is used to populate the value of Item Category name combo box.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemCatCombo(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response)
	{
		
		String strmsgText = "";
		HisUtil hisutil = null;
		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		String hosCode = "";
		String seatid = "";
		String storeId="";
		String cmb="";
		try {
			vo = new DispatchDetailsTransVO();
			bo = new DispatchDetailsTransBO();
			
			
			hisutil = new HisUtil("mms", "DispatchDetailsTransDATA");
			hosCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
			seatid=  request.getSession().getAttribute("SEATID").toString();
           	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			storeId=(String)request.getParameter("storeId");
			
			
			vo.setStrReqTypeId("55");//55 --> Dispatch Register
			
			vo.setStrStoreId(storeId);
					
			
			   bo.getItemCategoryCombo(vo);
			   if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				
				if (vo.getStrItemCategoryValuesWS()!= null
						&&vo.getStrItemCategoryValuesWS().size() > 0) {
					cmb = hisutil.getOptionValue(vo.getStrItemCategoryValuesWS(),"", "Select Value", false);
				} else {
					cmb = "<option value='0'>Select Value</option>";
				}

				try {
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(cmb);

				} catch (Exception e1) {
					
				}

			} catch (Exception e) {
				strmsgText = "DispatchDetailsTransDATA.getItemCatCombo(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"DispatchDetailsTransDATA->getItemCatCombo()", strmsgText);
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
				hisutil = null;
			}
	}
	
	/** This method is used to populate the value of PO No combo box.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getPONOCombo(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response)
	{
		
		String strmsgText = "";
		HisUtil hisutil = null;
		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		String hosCode = "";
		String seatid = "";
		String itemcatId="";
		String storeId = "";
	
		String modevalue="";
		String[] strPrefix = null;
		try {
			
			vo = new DispatchDetailsTransVO();
			bo = new DispatchDetailsTransBO();
			
			
			hisutil = new HisUtil("mms", "DispatchDetailsTransDATA");
			hosCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
			seatid=  request.getSession().getAttribute("SEATID").toString();
           	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			itemcatId=(String)request.getParameter("itemCatId");
			storeId=(String)request.getParameter("storeId");
			modevalue=(String)request.getParameter("modeValue");
			
			vo.setModeValue(modevalue);
			vo.setStrItemCatId(itemcatId);
			vo.setStrStrId(storeId);
					
			
			   bo.getPONOCombo(vo);
			   
			   while(vo.getStrPONONameValuesWS().next()){
					strPrefix = vo.getStrPONONameValuesWS().getString(1).replace('^', '#').split("#");
					formBean.setPoPrefix(strPrefix[2]);
				}
			   
			   
			   
			   vo.getStrPONONameValuesWS().beforeFirst();
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());

				}
				hisutil = new HisUtil("MMS Transactions", "DispatchDetailsTransDATA");
				String temp = "<option value='0'>Select Value</option>";

				if (vo.getStrPONONameValuesWS().size() != 0) {
					
					temp = hisutil.getOptionValue(vo.getStrPONONameValuesWS(), "0", "0^Select Value",
							true);

				}else{
					
					temp = "<option value='0'>Select Value</option>";
				}

				
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(temp+"@"+formBean.getPoPrefix());
				
			   
			} catch (Exception e) {
				e.printStackTrace();
				strmsgText = "DispatchDetailsTransDATA.getPONOCombo(vo) --> "
						+ e.getMessage();
				HisException eObj = new HisException("mms",
						"DispatchDetailsTransDATA->getPONOCombo()", strmsgText);
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
				hisutil = null;
			}
	}
	
	/** This method is used to populate the PO No Details,Request Details and the values of 
	 * Dispathch mode combo in Advance mode
	 * @param formBean
	 * @param request
	 * @param response
	 */
	
	public static void getDetailsAdvance(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
	
		String strmsgText = "";
		String hosCode = "";
		String cmb="";
		HisUtil hisutil = null;
       
	

		try {
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
	
			hisutil = new HisUtil("mms", "DispatchDetailsTransDATA");
			
		
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String[] strTemp = formBean.getHidePONO().replace('^', '#').split("#");
			
			
			
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrHospitalCode(hosCode);
			vo.setStrPOStoreId(strTemp[1]);
			vo.setStrItemCatId(formBean.getStrItemCatId());
			vo.setStrPONO(strTemp[0]);

			bo.getPONODetails(vo);

			WebRowSet ws=vo.getStrPONODetailsWS();
			
		    while(ws.next())
		    {
		    	formBean.setStrPODate(ws.getString(1));
		    	formBean.setStrSupplierName(ws.getString(2));
		    	formBean.setStrPOType(ws.getString(3));
		    	formBean.setStrCurrencyCode(ws.getString(4));
		    	formBean.setStrSupplierId(ws.getString(7));
		    	
		    	formBean.setStrCurrencyId(ws.getString(9));
		    	formBean.setStrCurrValuePO(ws.getString(10));
		    	
		    }
			 String strValue = DispatchDetailsTransHLP.getRequestDetails(vo.getStrHospitalCode(),vo.getStrStoreId(),vo.getStrItemCatId(),vo.getStrPONO());
			formBean.setStrRequestDetails(strValue);
			bo.getDispatchModeCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			
				cmb = hisutil.getOptionValue(vo.getStrDispatchModeNameValuesWS(),
						"0^Select Value", "Select Value", true);
				
				formBean.setStrDispatchModeNameValues(cmb);
			
			
				formBean.setStrDefCurrId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "transactions.DispatchDetailsTransDATA.getDetailsAdvance(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->getDetailsAdvance()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	/** This method is used to populate the PO No Details,Bill Details and the values of 
	 * Dispathch mode combo in Bill mode
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getDetailsBill(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
	
		String strmsgText = "";
		String hosCode = "";
		String cmb="";
		HisUtil hisutil = null;
       
	

		try {
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
		
			
			hisutil = new HisUtil("mms", "DispatchDetailsTransDATA");
			
			////System.out.println("form get strpono in detail bill"+formBean.getHidePONO());
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String[] strTemp = formBean.getHidePONO().replace('^', '#').split("#");

		
			vo.setStrStoreId(formBean.getStrStoreId());
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrPOStoreId(strTemp[1]);
			vo.setStrItemCatId(formBean.getStrItemCatId());
			vo.setStrPONO(strTemp[0]);

			bo.getPONODetails(vo);

			WebRowSet ws=vo.getStrPONODetailsWS();
		    while(ws.next())
		    {
		    	formBean.setStrPODate(ws.getString(1));
		    	formBean.setStrSupplierName(ws.getString(2));
		    	formBean.setStrPOType(ws.getString(3));
		    	formBean.setStrCurrencyCode(ws.getString(4));
		    	formBean.setStrSupplierId(ws.getString(7));
		    	
		    	formBean.setStrCurrencyId(ws.getString(9));
		    	formBean.setStrCurrValuePO(ws.getString(10));
		    	
		    }
		   
		  
		    
		    String strValue = DispatchDetailsTransHLP.getBillDetails(vo.getStrHospitalCode(),vo.getStrStoreId(),vo.getStrItemCatId(),vo.getStrPONO());
			
				
			formBean.setStrBillDetails(strValue);
			
			bo.getDispatchModeCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			
				cmb = hisutil.getOptionValue(vo.getStrDispatchModeNameValuesWS(),
						"0^Select Value", "Select Value", true);
				
				formBean.setStrDispatchModeNameValues(cmb);
			
				formBean.setStrDefCurrId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
				
	} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "transactions.DispatchDetailsTransDATA.getDetailsBill(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->getDetailsBill()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**This method is used to insert and Update the data in Advance Mode.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertAdvance(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		MmsConfigUtil mcu = null;

		String hosCode = "";
		String seatid = "";
		String chk[]=null;
		String reqNo[]=null;
		  

		try {
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			 
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mcu = new MmsConfigUtil(hosCode);
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			
			////System.out.println("chk selected--->"+formBean.getChkSelected());
			
			String[] strTemp = formBean.getHidePONO().replace('^', '#').split("#");
			
			chk=formBean.getChkSelected().replace(',', '#').split("#");
			
			reqNo=new String[chk.length];
			for(int i=0, stopI = chk.length ;i<stopI;i++){
				
				reqNo[i]=chk[i];
				
			}
			vo.setStrReqNo(reqNo);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(formBean.getStrItemCatId());
			vo.setStrStoreId(formBean.getStrStoreId());
			
			vo.setStrInstrType(formBean.getStrInstrType());
			vo.setStrInstrReceivedDate(formBean.getStrInstrReceivedDate());
			vo.setStrInstrAmt(formBean.getStrInstrAmt());
			vo.setStrInstrDate(formBean.getStrInstrDate());
			vo.setStrInstrNo(formBean.getStrInstrNo());
			vo.setStrInstrValidity(formBean.getStrInstrValidity());
			vo.setStrDispatchMode(formBean.getStrDispatchMode());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrDraweeBank(formBean.getStrDraweeBank());
			vo.setStrStoreId(formBean.getHideStoreId());
			vo.setStrItemCatId(formBean.getHideItemCatId());
			vo.setStrPODate(formBean.getStrPODate());
			vo.setStrPOType(formBean.getStrPOType());
			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrCurrencyCode(formBean.getStrCurrencyCode());
			vo.setStrPONO(strTemp[0]);
			vo.setStrCurrValue(formBean.getStrCurrValue());
			
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrDefCurrId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			vo.setStrCurrValuePo(formBean.getStrCurrValuePO());
			vo.setStrCurrencyId(formBean.getStrCurrencyId());
					
			vo.setStrPOStoreId(strTemp[1]);
			
			bo.insertAdvance(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else{
				formBean.setStrNormalMsg("Data Saved Successfully");
				formBean.setDisplayFlag("3");
				
			}

		} catch (Exception e) {
		 
			String strmsgText = "hisglobaltransactionutil.DispatchDetailsTransDATA.insertAdvance(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->insertAdvance()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			formBean.setDisplayFlag("3");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}
	
	/**This method is used to insert and Update the data in Bill Mode.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertBill(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		MmsConfigUtil mcu = null;


		String strmsgText = "";

		String hosCode = "";
		String seatid = "";
		String chk[]=null;
		String billNo[]=null;
		int i= 0;
		
		

		try {
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mcu = new MmsConfigUtil(hosCode);
					
			seatid = request.getSession().getAttribute("SEATID").toString();
			////System.out.println("po no----->"+formBean.getHidePONO());
			String[] strTemp = formBean.getHidePONO().replace('^', '#').split("#");
			chk=formBean.getChkSelected().replace(',', '#').split("#");
			billNo=new String[chk.length];
			for(i=0;i<chk.length;i++){
				billNo[i]=chk[i];
			}
			
			vo.setStrBillNo(billNo);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrInstrType(formBean.getStrInstrType());
			vo.setStrInstrReceivedDate(formBean.getStrInstrReceivedDate());
			vo.setStrInstrAmt(formBean.getStrInstrAmt());
			vo.setStrInstrDate(formBean.getStrInstrDate());
			vo.setStrInstrNo(formBean.getStrInstrNo());
			vo.setStrInstrValidity(formBean.getStrInstrValidity());
			vo.setStrDispatchMode(formBean.getStrDispatchMode());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrDraweeBank(formBean.getStrDraweeBank());
			vo.setStrStoreId(formBean.getHideStoreId());
			vo.setStrItemCatId(formBean.getHideItemCatId());
			vo.setStrPONO(strTemp[0]);
			vo.setStrPODate(formBean.getStrPODate());
			vo.setStrPOType(formBean.getStrPOType());
			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrCurrencyCode(formBean.getStrCurrencyCode());
			vo.setStrCurrValue(formBean.getStrCurrValue());
			
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			
			vo.setStrDefCurrId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			vo.setStrCurrValuePo(formBean.getStrCurrValuePO());
			vo.setStrCurrencyId(formBean.getStrCurrencyId());
			vo.setStrPOStoreId(strTemp[1]);
			
			 bo.insertBill(vo);
			 

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else{
				formBean.setStrNormalMsg("Data Saved Successfully");
				formBean.setDisplayFlag("4");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "hisglobaltransactionutil.DispatchDetailsTransDATA.insertBill(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->insertBill()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			formBean.setDisplayFlag("4");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}
	
	
	public static void getViewDetails(DispatchDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DispatchDetailsTransBO bo = null;
		DispatchDetailsTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
       
	

		try {
			bo = new DispatchDetailsTransBO();
			vo = new DispatchDetailsTransVO();
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(formBean.getHideStoreId());
						
			bo.getViewDetails(vo);

			WebRowSet ws=vo.getStrViewDetailsWS();
			
		    while(ws.next())
		    {
		    	formBean.setStrDispatchNo(ws.getString(1));
		    	formBean.setStrDispatchDate(ws.getString(2));
		    	formBean.setStrInstFor(ws.getString(3));
		    	formBean.setStrPONoView(ws.getString(4));
		    	formBean.setStrSuppNameView(ws.getString(5));
		    	formBean.setStrInstAmtView(ws.getString(6));
		    }
		    ws.beforeFirst();
		    String strDispatchDetailsVal = DispatchDetailsTransHLP.getDispatchDetails(ws, vo.getStrStoreId() , vo.getStrHospitalCode());
			formBean.setStrDispatchDetails(strDispatchDetailsVal);
				
	} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "transactions.DispatchDetailsTransDATA.getViewDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchDetailsTransDATA->getViewDetails()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	}
