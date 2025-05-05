package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.bo.SupplierReturnReqTransBO;
import mms.transactions.controller.fb.SupplierReturnReqTransFB;
import mms.transactions.controller.hlp.SupplierReturnReqTransHLP;
import mms.transactions.vo.SupplierReturnReqTransVO;

/**
 * Developer : Deepak Tiwari 
 * Version : 1.0 
 * Date : 23/Jan/2009 
 * Module : MMS 
 * Unit :Supplier Return Request Details
 */

public class SupplierReturnReqTransDATA {

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
	public static void getInitialValues(SupplierReturnReqTransFB formBean,
			HttpServletRequest request) {

		SupplierReturnReqTransBO bo = null;
		SupplierReturnReqTransVO voObj = null;
		HisUtil util = null;
		String strmsgText = "";
	//	String ctDate = "";
		String hosCode = "";
	//	String seatid = "";
	//	String strPOValues = "";
		String strItemCatVal = "";

		try {
			bo = new SupplierReturnReqTransBO();
			voObj = new SupplierReturnReqTransVO();
			String strStoreName = request.getParameter("comboValue");
			String strComboValues[] = request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			//("strStoreName->" + strComboValues[0]);
			//("strPONo->" + formBean.getStrPONo());
			formBean.setStrStoreId(strComboValues[0]);
			formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			voObj.setStrHospitalCode(hosCode);
			voObj.setStrStoreId(formBean.getStrStoreId());
			bo.getItemCategoryCmb(voObj);

			if (voObj.getStrMsgType().equals("1")) {

				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transaction", "SupplierReturnReqTransDATA");

			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0",
					"0^Select Value", false);

			formBean.setStrItemCatValues(strItemCatVal);
			formBean.setStrCurrentDate(now(DATE_FORMAT_NOWwt));

		} catch (Exception e) {
			strmsgText = "mms.transactions.SupplierReturnReqTransDATA.getItemCategoryCmb --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnReqTransDATA->getItemCategoryCmb()",
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
	public static void getPODetails(SupplierReturnReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SupplierReturnReqTransBO bo = null;
		SupplierReturnReqTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		HisUtil util = null;
		WebRowSet ws=null;
	//	String strPODetails = "";
	//	String strPOArray[] = null;
	//	String ItemDetails = "";

		try {
			bo = new SupplierReturnReqTransBO();
			vo = new SupplierReturnReqTransVO();
			util = new HisUtil("MMS Transaction", "SupplierReturnReqTransDATA");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrPONo(formBean.getStrPONo());
			bo.getPODetails(vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
			    ws=vo.getStrPODetailsWs();
				while(ws.next())
			    {
			    	vo.setStrPONo(ws.getString(1));
			    	vo.setStrPODate(ws.getString(2));
			    	vo.setStrPOTypeId(ws.getString(3));
			    	vo.setStrPOType(ws.getString(4));
			    	vo.setStrSupplierId(ws.getString(5));
			    	vo.setStrSupplierName(ws.getString(6));
			    	vo.setStrPOStoreId(ws.getString(7));
			    	vo.setStrPOStoreName(ws.getString(8));
			    }
			    formBean.setStrPODate(vo.getStrPODate());
			    formBean.setStrPOTypeId(vo.getStrPOTypeId());
				formBean.setStrPOType(vo.getStrPOType());
				formBean.setStrSupplierId(vo.getStrSupplierId());
				formBean.setStrSupplierName(vo.getStrSupplierName());
				formBean.setStrPOStoreId(vo.getStrPOStoreId());
				formBean.setStrPOStoreName(vo.getStrPOStoreName());
				formBean.setStrDeliveryDate(now(DATE_FORMAT_NOW));
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				bo.getGroupCmb(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
					util = new HisUtil("MMS Transaction", "Supplier Return");
					String strGroupName = "<option value='0'>Select Value</option>";
	
					if (vo.getStrGroupWs().size() != 0) {
						strGroupName = util.getOptionValue(vo.getStrGroupWs(), "0","0^Select Value", true);
					    formBean.setStrGroupValues(strGroupName);	
					}
				}
			}	

		} catch (Exception e) {
			strmsgText = "mms.transactions.SupplierReturnReqTransDATA.getPODetails --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"SupplierReturnReqTransDATA->getPODetails()",
				strmsgText);
		    formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		    eObj = null;
			
		} finally {
			bo = null;
			vo = null;
		}

	}

	public static void initSearchList(SupplierReturnReqTransFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

		SupplierReturnReqTransBO bo = null;
		SupplierReturnReqTransVO vo = null;
		String strmsgText = "";
		String strPOSearchListDtl="";
		String hosCode = "";
	//	HisUtil util = null;
		try {
			bo = new SupplierReturnReqTransBO();
			vo = new SupplierReturnReqTransVO();
	//		util = new HisUtil("MMS Transaction", "SupplierReturnReqTransDATA");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrItemCatNo(request.getParameter("itemCatNo"));
			vo.setStrStoreId(request.getParameter("storeId"));
			vo.setStrSearchListPODtlFromDate(request.getParameter("fromDate"));
			vo.setStrSearchListPODtlToDate(request.getParameter("toDate"));
			//("itemCatNo->"+request.getParameter("itemCatNo"));
			//("storeId->"+request.getParameter("storeId"));
		//	("fromDate->"+request.getParameter("fromDate"));
		//	("toDate->"+request.getParameter("toDate"));
			bo.getPODetailsSearchList(vo);
			//("afterBO"+vo.getStrMsgType());
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				strPOSearchListDtl=SupplierReturnReqTransHLP.getPONoSearchListDetails(vo);
				formBean.setStrSearchListPODetails(strPOSearchListDtl);
				//("popUpStr->"+strPOSearchListDtl);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPOSearchListDtl);
			   
			}		

		} catch (Exception e) {
			strmsgText = "mms.transactions.SupplierReturnReqTransDATA.initSearchList --> "
				+ e.getMessage();
		    HisException eObj = new HisException("mms",
				"SupplierReturnReqTransDATA->getPODetails()",
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
	 * This method is used to set all the values for inserting the details.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insert(SupplierReturnReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SupplierReturnReqTransBO bo = null;
		SupplierReturnReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		MmsConfigUtil mmsConfig = null;

		try {
			bo = new SupplierReturnReqTransBO();
			voObj = new SupplierReturnReqTransVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			voObj = (SupplierReturnReqTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.SupplierReturnReqTransVO",
							formBean);
			voObj.setItemParamValue(formBean.getItemParamValue()); // Hidden Field
			voObj.setStrFinancialStartYear(mmsConfig.getStrFinancialStartDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			voObj.setStrFinancialEndYear(mmsConfig.getStrFinancialEndDate(voObj.getStrStoreId() , voObj.getStrHospitalCode()));
			/*
			 * voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			 * voObj.setStrSeatId(formBean.getStrSeatId());
			 * voObj.setStrQty(formBean.getStrQty());
			 * voObj.setStrUnitName(formBean.getStrUnitName());
			 * voObj.setStrRemarks(formBean.getStrRemarks());
			 * voObj.setStrStoreId(formBean.getStrStoreId());
			 * voObj.setStrStoreTypeId(formBean.getStrStoreTypeId());
			 * voObj.setStrInstituteCode(formBean.getStrInstituteCode());
			 */
			bo.insert(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Inserted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.SupplierReturnReqTransDATA.insert --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnReqTransDATA->insert()", strmsgText);
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
	 * This method is used to set all the values for inserting the details.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	
	public static void CANCEL_REQUEST(SupplierReturnReqTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SupplierReturnReqTransBO bo = null;
		SupplierReturnReqTransVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String temp[]=null;
		String temp1[]=null;
		try {
			bo = new SupplierReturnReqTransBO();
			voObj = new SupplierReturnReqTransVO();

			String strStoreName = request.getParameter("comboValue");
			/* <TEST STRING> 
			 strChk->108@165090001@03-JUN-09@Drug@AIIMS@@sa$1#asd
             temp[0]->108@165090001@03-JUN-09@Drug@AIIMS@@sa$1
			 */
			String strChk = request.getParameter("chk");
			//("strChk->" + strChk);
			temp=strChk.split("#");
			formBean.setStrRemarks(temp[1]);
		//	("temp[0]->" + temp[0]);
			temp1=temp[0].replace('@', '#').split("#");
			formBean.setStrReqNo(temp1[1]);
			
			String strComboValues[] = request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			//("strStoreId->" + strComboValues[0]);
			//("ReqNo->" + temp1[1]);
			//("ItemCatNo->" + temp1[6]);
			formBean.setStrStoreId(strComboValues[0]);
			formBean.setStrItemCatNo(temp1[6]);
			voObj = (SupplierReturnReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.SupplierReturnReqTransVO",formBean);
			/*
			 * voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			 * voObj.setStrSeatId(formBean.getStrSeatId());
			 * voObj.setStrQty(formBean.getStrQty());
			 * voObj.setStrUnitName(formBean.getStrUnitName());
			 * voObj.setStrRemarks(formBean.getStrRemarks());
			 * voObj.setStrStoreId(formBean.getStrStoreId());
			 * voObj.setStrStoreTypeId(formBean.getStrStoreTypeId());
			 * voObj.setStrInstituteCode(formBean.getStrInstituteCode());
			 */
			bo.CANCEL_REQUEST(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Updated Successfully");
			}
			//(formBean.getStrNormalMsg());
		} catch (Exception e) {
			e.printStackTrace();
			//("ERROR");
			strmsgText = "mms.transactions.SupplierReturnReqTransDATA.CANCEL_REQUEST --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierReturnReqTransDATA->CANCEL_REQUEST()", strmsgText);
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

}
