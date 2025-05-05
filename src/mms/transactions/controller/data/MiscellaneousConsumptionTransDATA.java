package mms.transactions.controller.data;

import java.util.ResourceBundle;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.MiscellaneousConsumptionBO;
import mms.transactions.controller.fb.MiscellaneousConsumptionTransFB;
import mms.transactions.vo.MiscellaneousConsumptionTransVO;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 20/April/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Modify Date : 29/May/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */


public class MiscellaneousConsumptionTransDATA {

	
	
	/**This method is used to populate the value of Store Combo. for this activity this method called getInitialValues() 
	 * methods which is define in MiscellaneousConsumptionBO java file.
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(
			MiscellaneousConsumptionTransFB formBean, HttpServletRequest request) {

		MiscellaneousConsumptionBO bo = null;
		MiscellaneousConsumptionTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";

		String ctDate = "";
		String hosCode = "";
		String seatid = "";

		String strStoreNameValues = "";
		String strStoreComboId="";
		String strCategoryValues ="";

		try {

			bo = new MiscellaneousConsumptionBO();
			vo = new MiscellaneousConsumptionTransVO();
			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
			ResourceBundle resObj = mms.qryHandler_mms.res;
			if(resObj == null) 
			{
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}
			

			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getInitialValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			/* Changed By Niharika Srivastava on 21-sep-2010*/
			
			if (vo.getStoreNameValuesWS() != null
					&& vo.getStoreNameValuesWS().size() > 0) {
				if(vo.getStoreNameValuesWS().next())
				{
				vo.setStrStoreValId(vo.getStoreNameValuesWS().getString(1));
				formBean.setStrStoreId(vo.getStoreNameValuesWS().getString(1));
				vo.getStoreNameValuesWS().beforeFirst();
				}
				strStoreNameValues = hisutil.getOptionValue(vo
						.getStoreNameValuesWS(), "", "", true);
			} else {
				strStoreNameValues = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreNameValues(strStoreNameValues);
			if(!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
					strStoreComboId = request.getParameter("storeComboId");
			vo.setStrStoreValId(strStoreComboId);
			
			if (strStoreComboId.equals("0")) 
			{
				strCategoryValues = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				vo.setStrRequestType("54");
				
				bo.getItemCategoryCmb(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if(vo.getItemCategoryWS() != null && vo.getItemCategoryWS().size() > 0){
					strCategoryValues = hisutil.getOptionValue(vo.getItemCategoryWS(),
							"10", "0^Select Value", true);
					} else {
						strCategoryValues = "<option value='0'>Select Value</option>";
					}
				formBean.setStrItemCategoryValues(strCategoryValues);
				formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			}
		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "hisglobaltransactionutil.MiscellaneousConsumptionTransDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MiscellaneousConsumptionTransDATA->getInitialValues()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	
	/**This method is used to populate the value of Item Category Combo . For this activity this method call the method
	 * getItemCategoryCmb() which is define in MiscellaneousConsumptionBO java file
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemCategoryCmb(MiscellaneousConsumptionTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousConsumptionBO bo = null;
		MiscellaneousConsumptionTransVO vo = null;
		HisUtil hisutil = null;
		
		String strmsgText = "";
		String hosCode = "";
		String strItemCatValues = "";
		String strStoreComboId = "";
		String strRequestType = "";
		
		
		try {
			bo = new MiscellaneousConsumptionBO();
			vo = new MiscellaneousConsumptionTransVO();
			
			strStoreComboId = request.getParameter("storeComboId");
			strRequestType = "54";
			
			//System.out.println("strRequestType-->"+strRequestType);
		
			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			
			hosCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString();
				
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreValId(strStoreComboId);
			vo.setStrRequestType(strRequestType);
	
			bo.getItemCategoryCmb(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getItemCategoryWS() != null && vo.getItemCategoryWS().size() > 0){
				strItemCatValues = hisutil.getOptionValue(vo.getItemCategoryWS(),
						"10", "0^Select Value", true);
				}
			else{
				strItemCatValues = "<option value='0'>Select Value</option>";
				}
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCatValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
			
			}

		} catch (Exception e) {
			strmsgText = "transactions.MiscellaneousConsumptionTransDATA.getItemCategoryCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MiscellaneousConsumptionTransDATA->getItemCategoryCmb()", strmsgText);
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
			bo=null;
			vo=null;
			hisutil = null;
		}

	}
	
	
	/**This method is used to populate the value of Group name combo box and this method calls the getGroupNameValues() method which is define in MiscellaneousConsumptionBO java file.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getGroupNameCmb(MiscellaneousConsumptionTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousConsumptionBO bo = null;
		MiscellaneousConsumptionTransVO vo = null;
		HisUtil hisutil = null;
		
		String strmsgText = "";
		String hosCode = "";
		String strGroupNameValues = "";
		String strItemCatComboId = "";
		
		try {
			bo = new MiscellaneousConsumptionBO();
			vo = new MiscellaneousConsumptionTransVO();
			
			strItemCatComboId = request.getParameter("itemCatId");
			
			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			
			hosCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrItemCategoryId(strItemCatComboId);
		
			bo.getGroupNameValues(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getGroupNameWS() != null && vo.getGroupNameWS().size() > 0){
				strGroupNameValues = hisutil.getOptionValue(vo.getGroupNameWS(),
						"", "0^Select Value", true);
				}
			else{
					strGroupNameValues = "<option value='0'>Select Value</option>";
				}
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strGroupNameValues);

			} catch (Exception e) {
			
				}

		} catch (Exception e) {
			strmsgText = "transactions.MiscellaneousConsumptionDATA.getGroupNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MiscellaneousConsumptionDATA->getGroupNameCmb()", strmsgText);
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
			bo=null;
			vo=null;
			hisutil = null;
		}

	}
	
	
	/**This method is used to insert the Miscellaneous Consumptions in database for this activity this function call
	 * the insertMissConsumpRecord()method which is define in MiscellaneousConsumptionBO java file.
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertMiscConsumpRecord(
			MiscellaneousConsumptionTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		MiscellaneousConsumptionBO bo = null;
		MiscellaneousConsumptionTransVO vo = null;
		MmsConfigUtil mcu = null;
		String strmsgText = "";
		String strTemp[] = null;
		String[] strInsertValue = null;
		String strItemIdArray[] = null;
		String[] strBrandIdArray = null;
		String[] strStockStatusArray = null;
		String strBatchSlNoArray[] = null;
		String strInhandQtyArray[] = null;
		String[] strInhandQtyUnitArray = null;
		String[] strConsumptionQTY = null;
		String[] strConsumptionQtyUnitID = null;
		String[] UnitID = null;
		String[] strMRP = null;
		String[] strPur = null;
		HisUtil hisutil = null;

		try {
			bo = new MiscellaneousConsumptionBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			formBean.setStrFinancialStartDate(mcu.getStrFinancialStartDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			formBean.setStrFinancialEndDate(mcu.getStrFinancialEndDate(formBean.getStrStoreId() , formBean.getStrHospitalCode()));
			
			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
				
			vo = (MiscellaneousConsumptionTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.MiscellaneousConsumptionTransVO", formBean);
			
						
			int nMultiRowLen = vo.getStrConsumptionQty().length;
			
			strConsumptionQTY = new String[nMultiRowLen];
			strConsumptionQtyUnitID = new String[nMultiRowLen];
			strItemIdArray = new String[nMultiRowLen];
			strInhandQtyArray = new String[nMultiRowLen];
			strBatchSlNoArray = new String[nMultiRowLen];
			strInhandQtyUnitArray = new String[nMultiRowLen];
			strBrandIdArray = new String[nMultiRowLen];
			strStockStatusArray = new String[nMultiRowLen];
			strMRP = new String[nMultiRowLen];
			strPur = new String[nMultiRowLen];
			for (int i = 0; i < nMultiRowLen; i++) 
			{
						
				strTemp = vo.getItemParamValue()[i].split("#");
				
				//System.out.println("Inserted Vlue-->"+strTemp[2]);
				//18000005^18100008^181001^181001100^0^0^0^1^6301^12000^6301^6301^123^21-DEC-10^1810003^~06/01/2011 01:01:29^^06-JAN-11^CDAC/HIS/11/0009^0^0^0^0^0^0^0^0^^0^0^0^0^10^150000^6301^1^1^0
				//strDisplayValue = strTemp[0].replace("^", "#").split("#");
				strInsertValue = strTemp[2].replace("^", "#").split("#");
				
				//System.out.println("Batch No::::"+strInsertValue[15]);
				strItemIdArray[i] = strInsertValue[0];
				strBatchSlNoArray[i] = strInsertValue[15];
				strInhandQtyArray[i] = strInsertValue[7];
				strInhandQtyUnitArray[i] = strInsertValue[8];
				strBrandIdArray[i] = strInsertValue[1];
				strStockStatusArray[i] =  strInsertValue[32];
				strMRP[i] = strInsertValue[9];
				strPur[i] = strInsertValue[9] == null ? strInsertValue[9] : strInsertValue[9];
				UnitID = vo.getStrUnitName()[i].replace('^', '#').split("#");
					strConsumptionQTY[i] = formBean.getStrConsumptionQty()[i];
					strConsumptionQtyUnitID[i] = UnitID[0];
			
			}
		
			vo.setStrStoreValId(formBean.getStrStoreId());
			
			vo.setStrItemCategoryId(formBean.getStrItemCategoryId1());
			vo.setStrRequestType("54");
			vo.setStrItemId(strItemIdArray);
			vo.setStrItemBrandId(strBrandIdArray);
			vo.setStrBatchSlNo(strBatchSlNoArray);
			vo.setStrInhandQty(strInhandQtyArray);
			vo.setStrInhandQtyUnitId(strInhandQtyUnitArray);
			vo.setStrConsumptionQty(strConsumptionQTY);
			vo.setStrUnitName(strConsumptionQtyUnitID);
			vo.setStrFinancialStartDate(formBean.getStrFinancialStartDate());
			vo.setStrFinancialEndDate(formBean.getStrFinancialEndDate());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrConsumptionDate(formBean.getStrCtDate());
			vo.setStrReservedFlag("1");
			vo.setStrStockStatusCode(strStockStatusArray);
			vo.setStrIsValid("1");
			vo.setStrMRP(strMRP);
			vo.setStrPur(strPur);
			bo.insertMiscConsumpRecord(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				if(vo.getStrMsgString().split("\\##")[2].equals("999"))
			    {
    				//System.out.println("In Insufficent Drug:::"+vo.getStrMsgString().split("\\##")[1]);
				    formBean.setStrErrMsg(vo.getStrMsgString().split("\\##")[1]);
			    }
				else
				{
					formBean.setStrErrMsg(vo.getStrMsgString());
				    throw new Exception(vo.getStrMsgString());
				}	
			}

			else {
				formBean.setStrNormalMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "hisglobaltransactionutil.MiscellaneousConsumptionTransDATA.insertMiscConsumpRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException(
					"mms",
					"MiscellaneousConsumptionTransDATA->insertMiscConsumpRecord()",
					strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu = null;
			hisutil = null;
		}

	}
	
	
	
}
