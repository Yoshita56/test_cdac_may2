package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBElement;

import mms.MmsConfigUtil;
import mms.masters.bo.MmsConfigMstBO;
import mms.masters.controller.fb.MmsConfigMstFB;
import mms.masters.controller.hlp.MmsConfigMstHLP;
import mms.masters.vo.MmsConfigMstVO;
import mms.setup.MmsConfigType;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstDATA.
 */
public class MmsConfigMstDATA {

	/**
	 * Display gen dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 */
	
	public static JAXBElement<MmsConfigType> gblJaxB = null;
	
	public static void displayGenDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;
		
		MmsConfigUtil mmscofigutil =null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			mmscofigutil = new  MmsConfigUtil(hosCode);	


			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(strSeatId);
			
			bo.displayValues(vo);
			

			String strStoreList = "<option value='0'>Select Value</option>";

			if (vo.getWsStoreDetailsList() != null
					&& vo.getWsStoreDetailsList().size() > 0) {

				strStoreList = util.getOptionValue(vo.getWsStoreDetailsList(),
						"0", "0^Select Value", true);

			}
			
			
			String strCategoryList = "<option value='0'>Select Value</option>";
			
			if (vo.getWsItemCategoryList()!= null
					&& vo.getWsItemCategoryList().size() > 0) {

				strCategoryList = util.getOptionValue(vo.getWsItemCategoryList(),mmscofigutil.getStrStoreConfigCatg(), "0^Select Value", true);

			}
			
            String strCountryList = "<option value='0'>Select Value</option>";
			
			if (vo.getWsCountryList()!= null && vo.getWsCountryList().size() > 0)
			{

				strCountryList = util.getOptionValue(vo.getWsCountryList(),vo.getStrCountryCode(), "0^Select Value", true);

			}
			
			vo.setStrHospitalCode(hosCode);		
			
			bo.getStateList(vo);

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());

			}

			String strState = util.getOptionValue(vo.getWsStateList(), vo.getStrStateCode(),"0^Select Value", true);

			
			formBean.setStrContractValue(mmscofigutil.getStrContractValue());
			formBean.setStrStampPaperAmt(mmscofigutil.getStampPaperAmt());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			formBean.setStrCountryCmb(strCountryList);
            formBean.setStrItemCatgCmb(strCategoryList);
			formBean.setStrStoreDetailsValues(strStoreList);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrCommitteeFilePath(vo.getStrCommitteeFilePath());
			formBean.setStrImportedDeliveryTime(vo.getStrImportedDeliveryTime());
			formBean.setStrIndianDeliveryTime(vo.getStrIndianDeliveryTime());
			formBean.setStrResidualCost(vo.getStrResidualCost());
			formBean.setStrExpAlertDays(vo.getStrExpAlertDays());
			formBean.setStrStateCmb(strState);
			formBean.setStrIssueRateConfigFlg(vo.getStrIssueRateConfigFlg());
			formBean.setStrChkFlg("1");
			formBean.setStrConfigIssueRate(vo.getStrConfigIssueRate());
			formBean.setStrBillingIntegration(vo.getStrBilingIntegration());
			
			//System.out.println("Billing"+formBean.getStrBillingIntegration());
			
			
			
			formBean.setStrBudgetFlg(vo.getStrBudgetFlg());
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayGenDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayGenDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	/**
	 * Save gen dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 */
	public static void saveGenDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		
		gblJaxB = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String ipAddress = request.getSession().getAttribute("IP_ADDR")
					.toString();

			vo.setStrIpAddress(ipAddress);
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			vo.setStrFinancialStartDate(formBean.getStrFinancialStartDate());
			vo.setStrFinancialEndDate(formBean.getStrFinancialEndDate());
			
			vo.setStrStoreId(formBean.getStrStoreId().replace("^", "#").split(
					"#")[0]);
			vo.setStrCommitteeFilePath(formBean.getStrCommitteeFilePath());
			vo.setStrIndianDeliveryTime(formBean.getStrIndianDeliveryTime());
			vo.setStrImportedDeliveryTime(formBean.getStrImportedDeliveryTime());
			vo.setStrResidualCost(formBean.getStrResidualCost());
			vo.setStrExpAlertDays(formBean.getStrExpAlertDays());
			vo.setStrItemCatgId(formBean.getStrItemCatgId());
			vo.setStrCountryCode(formBean.getStrCountryCode());
			vo.setStrStateCode(formBean.getStrStateCode());
			vo.setStrIssueRateConfigFlg(formBean.getStrIssueRateConfigFlg());
			vo.setStrContractValue(formBean.getStrContractValue());
			vo.setStrStampPaperAmt(formBean.getStrStampPaperAmt());
			//if(vo.getStrIssueRateConfigFlg().equals("1"))
			//{	
			vo.setStrConfigIssueRate(formBean.getStrConfigIssueRate());
			vo.setStrBilingIntegration(formBean.getStrBillingIntegration());
			
			//System.out.println("Billing"+formBean.getStrBillingIntegration());
			//}
			//else
			//{
			//  vo.setStrConfigIssueRate("0");	
			//}	
			vo.setStrBudgetFlg(formBean.getStrBudgetFlg());  // Budget Flag Added on 8 - Aug - 2011
			vo.setStrTinNo(formBean.getStrTinNo());	
			bo.saveValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrNormalMsg("Data Saved Successfully");

		} catch (Exception e) {

			e.printStackTrace();

			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.saveGenDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayGenDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	/**
	 * Display issue dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 */
	public static void displayIssueDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		MmsConfigUtil mmscofigutil =null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmscofigutil = new MmsConfigUtil(hosCode);

			vo.setStrHospitalCode(hosCode);

			bo.displayIssueValues(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());
			}
			
            formBean.setStrDemandActiveFlg(mmscofigutil.getStrDemandActiveFlg());
            formBean.setStrDemandActivePrd(mmscofigutil.getStrDemandActivePrd());
			formBean.setStrIssueMode(vo.getStrIssueMode());
			formBean.setStrLastIssueEmployeeInDays(vo.getStrLastIssueEmployeeInDays());
			formBean.setStrLastIssuePatientStaffInDays(vo.getStrLastIssuePatientStaffInDays());
			formBean.setStrOnlineIssueInDays(vo.getStrOnlineIssueInDays());
			formBean.setStrAutoReturnRequest(vo.getStrAutoReturnRequest());
			formBean.setStrStaffSalePrice(vo.getStrStaffSalePrice());
			formBean.setStrStaffSalePriceType(vo.getStrStaffSalePriceType());
			formBean.setStrNormalSalePrice(vo.getStrNormalSalePrice());
			formBean.setStrNormalSalePriceType(vo.getStrNormalSalePriceType());
			
			formBean.setStrWithOutCrNoFlg(vo.getStrWithOutCrNoFlg());
			formBean.setStrDoseFrqFlg(vo.getStrDoseFrqFlg());
			formBean.setStrCrNoDefault(vo.getStrCrNoDefault());
			formBean.setStrReturnDrugValidity(vo.getStrReturnDrugValidity());
			
			
			
		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayIssueDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayIssueDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	/**
	 * Save issue dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 */
	public static void saveIssueDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		
		gblJaxB = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			vo.setStrIssueMode(formBean.getStrIssueMode());
			vo.setStrLastIssuePatientStaffInDays(formBean
					.getStrLastIssuePatientStaffInDays());
			vo.setStrLastIssueEmployeeInDays(formBean
					.getStrLastIssueEmployeeInDays());

			vo.setStrOnlineIssueInDays(formBean.getStrOnlineIssueInDays());

			vo.setStrAutoReturnRequest(formBean.getStrAutoReturnRequest());
			
			vo.setStrStaffSalePrice(formBean.getStrStaffSalePrice());
			vo.setStrStaffSalePriceType(formBean.getStrStaffSalePriceType());
			vo.setStrNormalSalePrice(formBean.getStrNormalSalePrice());
			vo.setStrNormalSalePriceType(formBean.getStrNormalSalePriceType());
			vo.setStrDemandActiveFlg(formBean.getStrDemandActiveFlg());
			vo.setStrWithOutCrNoFlg(formBean.getStrWithOutCrNoFlg());
			vo.setStrDoseFrqFlg(formBean.getStrDoseFrqFlg());
			vo.setStrCrNoDefault(formBean.getStrCrNoDefault());
			vo.setStrReturnDrugValidity(formBean.getStrReturnDrugValidity());
			
			
			
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrHospitalCode(hosCode);
			
			
			if(vo.getStrDemandActiveFlg().equals("1"))
			{	
			  vo.setStrDemandActivePrd(formBean.getStrDemandActivePrd());
			}
			else
			{
			  vo.setStrDemandActivePrd("0");	
			}	
			

			bo.saveIssueValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrNormalMsg("Data Saved Successfully");

		}
		catch (Exception e) 
		{
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.saveIssueDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->saveIssueDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	/**
	 * Display penalty dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void displayPenaltyDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util=null;
		String strPurchaseTypeComboVals="";

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();
			
			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.displayPenaltyValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getWsPurchaseType()!=null)
			{
				strPurchaseTypeComboVals=util.getOptionValue(vo.getWsPurchaseType(),"0", "0^Select Value", true);
			}
			else
			{
				strPurchaseTypeComboVals="<option value='0'>Select Value</option>";
			}
			
			formBean.setStrPurchaseTypeComboVals(strPurchaseTypeComboVals);
			formBean.setStrPenRejBreak(vo.getStrPenRejBreak());
			/*formBean.setStrPenaltyDetailsList(MmsConfigMstHLP.getPenaltyList(
					formBean, vo.getWsPenaltyDetailsList()));*/

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayPenaltyDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayPenaltyDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	public static void displayPhysicalStockVerifyDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			//System.out.println("seat id is"+vo.getStrSeatId());
			bo.displayPhysicalStockVerifyValues(vo);
			

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			String strStoreList   = "<option value='0'>Select Value</option>";
			String strItemCatList = "<option value='0'>Select Value</option>";
			String strPeriodList  = "<option value='0'>Select Value</option>";

			if (vo.getWsStoreDetailsList() != null
					&& vo.getWsStoreDetailsList().size() > 0) {

				strStoreList = util.getOptionValue(vo.getWsStoreDetailsList(),
						vo.getStrStoreId(), "0^Select Value", true);

			}
			
			if (vo.getWsItemCategoryList() != null
					&& vo.getWsItemCategoryList().size() > 0) {

				strItemCatList = util.getOptionValue(vo.getWsItemCategoryList(),
						vo.getStrItemCategoryCode(), "0^Select Value", true);

			}
			
			if (vo.getWsPeriodList() != null
					&& vo.getWsPeriodList().size() > 0) {

				strPeriodList = util.getOptionValue(vo.getWsPeriodList(),
						vo.getStrPeriodId(), "0^Select Value", true);

			}
			
			

			formBean.setStrStoreDetailsValues(strStoreList);
			//formBean.setStrItemCatgCmb(strItemCatList);
			formBean.setStrPeriodName(strPeriodList);
			formBean.setStrItemCategoryCode(strItemCatList);
			formBean.setStrPeriodId(vo.getStrPeriodId());
			formBean.setStrIsStockLedgerRequired(vo.getStrIsStockLedgerRequired());

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayPhysicalStockVerifyDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayPhysicalStockVerifyDtls()",
					strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			bo = null;
			vo = null;
			util = null;

		}

	}

	public static void displayReportParameterDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
	

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
		
		
			vo.setStrHospitalCode(hosCode);

			bo.displayReportDetailsValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrCategoryA(vo.getStrCategoryA());
			formBean.setStrCategoryB1(vo.getStrCategoryB1());
			formBean.setStrCategoryB2(vo.getStrCategoryB2());
			formBean.setStrCategoryC(vo.getStrCategoryC());
			

			formBean.setStrCategoryF(vo.getStrCategoryF());
			formBean.setStrCategoryN1(vo.getStrCategoryN1());
			formBean.setStrCategoryN2(vo.getStrCategoryN2());
			formBean.setStrCategoryS(vo.getStrCategoryS());
			
			
		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayReportParameterDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayReportParameterDtls()",
					strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			bo = null;
			vo = null;
			
		}

	}
	
	
	public static void getItemCategoryList(HttpServletRequest request,
			HttpServletResponse response, MmsConfigMstFB formBean) {
		String strmsgText = "";

		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;

		String strItemCat = "";

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String strStoreId = (String)request.getParameter("strStoreId");
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			
			bo.getItemCateogryValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

			strItemCat = util.getOptionValue(vo.getWsItemCategoryList(), "0",
					"0^Select Value", true);

			try {

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strItemCat);
			} catch (Exception e) {

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"DrugDosegeIndicationMstDATA->getItemCategoryList()",
						strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator! ");

				eObj = null;

			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->getItemCategoryList()",
					strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;

			util = null;

			bo = null;
		}

	}
	
	
	public static void getStateList(HttpServletRequest request,	HttpServletResponse response, MmsConfigMstFB formBean) 
	{
		String strmsgText = "";

		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;
		MmsConfigUtil mmscofigutil= null;
		String strState = "";

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmscofigutil = new  MmsConfigUtil(hosCode);	
			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String strCountryCode = (String)request.getParameter("strCountryCode");
			
            
			vo.setStrHospitalCode(hosCode);
			vo.setStrCountryCode(strCountryCode);
			
			bo.getStateList(vo);

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());

			}

			strState = util.getOptionValue(vo.getWsStateList(), vo.getStrStateCode(),"0^Select Value", true);

			try {

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strState);
			} catch (Exception e) {

				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"MmsConfigMstDATA->getStateList()",
						strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator! ");

				eObj = null;

			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->getItemCategoryList()",
					strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;

			util = null;

			bo = null;
		}

	}
	

	public static void getPeriodDetails(HttpServletRequest request,
			HttpServletResponse response, MmsConfigMstFB formBean) {
		String strmsgText = "";

		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;

		String strPeriods = "";

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			
			String strStoreId = (String)request.getParameter("strStoreId");
			
			String strCategoryId = (String)request.getParameter("strCategoryId");
			
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryCode(strCategoryId);
			
			bo.getPeriodDetails(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

			if (vo.getStrIsPeriodAvailable().equals("0")) {

				strPeriods = vo.getStrIsPeriodAvailable()
						+ "@"
						+ util.getOptionValue(vo.getWsPeriodList(), "0",
								"0^Select Value", true);

			} else {

				strPeriods = vo.getStrIsPeriodAvailable() + "@"
						+ vo.getStrPeriodName()+"^"+vo.getStrPeriodId()+"^"+vo.getStrIsStockLedgerRequired();
			}

					
			try {

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(strPeriods);
			} catch (Exception e) {

				e.printStackTrace();
				
				strmsgText = e.getMessage();
				HisException eObj = new HisException("mms",
						"MmsConfigMstDATA->getPeriodDetails()",
						strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "], Contact System Administrator! ");

				eObj = null;

			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->getPeriodDetails()",
					strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;

			util = null;

			bo = null;
		}

	}

	/**
	 * Save penalty dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void savePenaltyDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		gblJaxB = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			vo.setStrFromDays(formBean.getStrFromDays());
			vo.setStrToDays(formBean.getStrToDays());
			vo.setStrPenalty(formBean.getStrPenalty());
			vo.setStrPenRejBreak(formBean.getStrPenRejBreak());
			vo.setStrPurchaseType(formBean.getStrPurchaseType());
			bo.savePenaltyValues(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrNormalMsg("Data Saved Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.savePenaltyDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->savePenaltyDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	public static void savePhysicalStockDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		gblJaxB = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
			.toString();
	String seatid = request.getSession().getAttribute("SEATID")
			.toString();

	String ipAddress = request.getSession().getAttribute("IP_ADDR")
			.toString();

	vo.setStrIpAddress(ipAddress);
	vo.setStrSeatId(seatid);
	vo.setStrHospitalCode(hosCode);

			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryCode(formBean.getStrItemCategoryCode());
			vo.setStrPeriodId(formBean.getStrPeriodId());
			vo.setStrIsStockLedgerRequired(formBean
					.getStrIsStockLedgerRequired());
			vo.setStrPreviousStockLedgerRequired(formBean.getStrPreviousStockLedgerRequired());
			bo.savePhysicalStockValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrNormalMsg("Data Saved Successfully");

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.savePhysicalStockDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->savePhysicalStockDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}

	
	public static void saveReportParameterDtls(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		gblJaxB = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			  
			 
			vo.setStrHospitalCode(hosCode);

			vo.setStrCategoryA(formBean.getStrCategoryA());
			vo.setStrCategoryB1(formBean.getStrCategoryB1());
			vo.setStrCategoryB2(formBean.getStrCategoryB2());
			vo.setStrCategoryC(formBean.getStrCategoryC());
			

			vo.setStrCategoryF(formBean.getStrCategoryF());
			vo.setStrCategoryN1(formBean.getStrCategoryN1());
			vo.setStrCategoryN2(formBean.getStrCategoryN2());
			vo.setStrCategoryS(formBean.getStrCategoryS());

			bo.saveReportParameterValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrNormalMsg("Data Saved Successfully");

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.saveReportParameterDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->saveReportParameterDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}
	public static void  getPeneltyDtl(MmsConfigMstFB formBean,
			HttpServletRequest request,HttpServletResponse response){
		String strmsgText="";
		String strMsgText="";
		MmsConfigMstBO bo=null;
		MmsConfigMstVO vo=null;
		String strHospCode="";
		String strPurchaseType="";
		String strPeneltyList="";
		
		try{
				
				/*
				 * fetching value from request Parameter
				 */
			
				strHospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				strPurchaseType=request.getParameter("purchaseType");
			
				/*
				 * Object creation
				 */
				vo=new MmsConfigMstVO();
				bo=new MmsConfigMstBO();
				vo.setStrHospitalCode(strHospCode);
				vo.setStrPurchaseType(strPurchaseType);
				
				bo.getPeneltyDtl(vo);
				strPeneltyList=MmsConfigMstHLP.getPenaltyList(
						formBean, vo.getWsPenaltyDetailsList());
				
				////System.out.println("strPeneltyList::::"+strPeneltyList);
			
				try {
	
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strPeneltyList+"^"+formBean.getStrMultiRowIndex());
	
					
				} catch (Exception e) {
	
					e.printStackTrace();
					
					strmsgText = e.getMessage();
					HisException eObj = new HisException("mms",
							"MmsConfigMstDATA->getPeneltyDtl()",
							strmsgText);
					formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "], Contact System Administrator! ");
	
					eObj = null;
	
				}
			
			
		}catch(Exception e){
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.getPeneltyDtl() --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"MmsConfigMstDATA->getPeneltyDtl()", strMsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
		
	}
/*
 * Display PeneltyDetails in New BS page Added by Swapnil
 */
	
	public static void  getPeneltyDtl_BS(MmsConfigMstFB formBean,
			HttpServletRequest request,HttpServletResponse response){
		String strmsgText="";
		String strMsgText="";
		MmsConfigMstBO bo=null;
		MmsConfigMstVO vo=null;
		String strHospCode="";
		String strPurchaseType="";
		String strPeneltyList="";
		
		try{
				
				/*
				 * fetching value from request Parameter
				 */
			
				strHospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				strPurchaseType=request.getParameter("purchaseType");
			
				/*
				 * Object creation
				 */
				vo=new MmsConfigMstVO();
				bo=new MmsConfigMstBO();
				vo.setStrHospitalCode(strHospCode);
				vo.setStrPurchaseType(strPurchaseType);
				
				//bo.getPeneltyDtl_BS(vo);
				strPeneltyList=MmsConfigMstHLP.getPenaltyList_BS(
						formBean, vo.getWsPenaltyDetailsList());
				
				////System.out.println("strPeneltyList::::"+strPeneltyList);
			
				try {
	
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(strPeneltyList+"^"+formBean.getStrMultiRowIndex());
	
					
				} catch (Exception e) {
	
					e.printStackTrace();
					
					strmsgText = e.getMessage();
					HisException eObj = new HisException("mms",
							"MmsConfigMstDATA->getPeneltyDtl_BS()",
							strmsgText);
					formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "], Contact System Administrator! ");
	
					eObj = null;
	
				}
			
			
		}catch(Exception e){
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.getPeneltyDtl_BS() --> "
				+ e.getMessage();
		HisException eObj = new HisException("mms",
				"MmsConfigMstDATA->getPeneltyDtl()", strMsgText);
		formBean.setStrErrMsg("Application Error [ERROR ID : "
				+ eObj.getErrorID() + "],Contact System Administrator! ");

		eObj = null;
		}
		
	}
	

	////////////// New Code goes here (By Adil Wasi)/////////////
	public static void displayGenDtlsNew(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;
		
		MmsConfigUtil mmscofigutil =null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(strSeatId);
			
			bo.setGenPropValues(vo);
			
			//System.out.println("Billing"+vo.getStrBilingIntegration());
			mmscofigutil = new  MmsConfigUtil(hosCode);	
			

			//System.out.println("store id is "+vo.getStrStoreId()+" "+mmscofigutil.getStrStoreConfigCatg());
			String strStoreList = "<option value='0'>Select Value</option>";

			if (vo.getWsStoreDetailsList() != null
					&& vo.getWsStoreDetailsList().size() > 0) {

				strStoreList = util.getOptionValue(vo.getWsStoreDetailsList(),
						vo.getStrStoreId(), "0^Select Value", true);

			}
			
			
			String strCategoryList = "<option value='0'>Select Value</option>";
			
			if (vo.getWsItemCategoryList()!= null
					&& vo.getWsItemCategoryList().size() > 0) {

				strCategoryList = util.getOptionValue(vo.getWsItemCategoryList(),mmscofigutil.getStrStoreConfigCatg(), "0^Select Value", true);

			}
			
            String strCountryList = "<option value='0'>Select Value</option>";
			
			if (vo.getWsCountryList()!= null && vo.getWsCountryList().size() > 0)
			{

				strCountryList = util.getOptionValue(vo.getWsCountryList(),vo.getStrCountryCode(), "IND^India", true);

			}
			
			vo.setStrHospitalCode(hosCode);		
			
			bo.getStateList(vo);

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());

			}

			String strState = util.getOptionValue(vo.getWsStateList(), vo.getStrStateCode(),"0^Select Value", true);

			HelperMethods.populate(formBean, vo);
			formBean.setStrCountryCmb(strCountryList);
            formBean.setStrItemCatgCmb(strCategoryList);
			formBean.setStrStoreDetailsValues(strStoreList);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrStateCmb(strState);
			formBean.setStrChkFlg("1");
			formBean.setStrStoreId(vo.getStrStoreId());
			formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
			formBean.setStrSelfLife(vo.getStrSelfLife());
			formBean.setStrFMSIntegration(vo.getStrFMSIntegration());
			formBean.setStrIndentLimitAmt(vo.getStrIndentLimitAmt());
			/*formBean.setStrContractValue(vo.getStrContractValue());
			formBean.setStrStampPaperAmt(vo.getStrStampPaperAmt());
			formBean.setStrConfigIssueRate(vo.getStrConfigIssueRate());
			formBean.setStrCountryCmb(strCountryList);
            formBean.setStrItemCatgCmb(strCategoryList);
			formBean.setStrStoreDetailsValues(strStoreList);
			formBean.setStrCtDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrCommitteeFilePath(vo.getStrCommitteeFilePath());
			formBean.setStrImportedDeliveryTime(vo.getStrImportedDeliveryTime());
			formBean.setStrIndianDeliveryTime(vo.getStrIndianDeliveryTime());
			formBean.setStrResidualCost(vo.getStrResidualCost());
			formBean.setStrExpAlertDays(vo.getStrExpAlertDays());
			formBean.setStrStateCmb(strState);
			formBean.setStrIssueRateConfigFlg(vo.getStrIssueRateConfigFlg());
			formBean.setStrChkFlg("1");
			formBean.setStrConfigIssueRate(vo.getStrConfigIssueRate());*/
			
			
			
			formBean.setStrBudgetFlg(vo.getStrBudgetFlg());
			formBean.setStrBillingIntegration(vo.getStrBilingIntegration());
			
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayGenDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayGenDtlsNew()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}
	
	
	/**
	 * Display issue dtls.
	 * 
	 * @param formBean
	 *            the form bean
	 */
	public static void displayIssueDtlsNew(MmsConfigMstFB formBean,HttpServletRequest request) 
	{
		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		MmsConfigUtil mmscofigutil =null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmscofigutil = new MmsConfigUtil(hosCode);

			vo.setStrHospitalCode(hosCode);

			bo.displayIssueDtls(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());
			}
			
			HelperMethods.populate(formBean, vo);
			
            /*formBean.setStrDemandActiveFlg(vo.getStrDemandActiveFlg());
			formBean.setStrDoseFrqFlg(vo.getStrDoseFrqFlg());
            formBean.setStrDemandActivePrd(vo.getStrDemandActivePrd());
			formBean.setStrIssueMode(vo.getStrIssueMode());
			formBean.setStrLastIssueEmployeeInDays(vo.getStrLastIssueEmployeeInDays());
			formBean.setStrLastIssuePatientStaffInDays(vo.getStrLastIssuePatientStaffInDays());
			formBean.setStrOnlineIssueInDays(vo.getStrOnlineIssueInDays());
			formBean.setStrAutoReturnRequest(vo.getStrAutoReturnRequest());
			formBean.setStrStaffSalePrice(vo.getStrStaffSalePrice());
			formBean.setStrStaffSalePriceType(vo.getStrStaffSalePriceType());
			formBean.setStrNormalSalePrice(vo.getStrNormalSalePrice());
			formBean.setStrNormalSalePriceType(vo.getStrNormalSalePriceType());
			
			formBean.setStrWithOutCrNoFlg(vo.getStrWithOutCrNoFlg());
			formBean.setStrCrNoDefault(vo.getStrCrNoDefault());
			formBean.setStrReturnDrugValidity(vo.getStrReturnDrugValidity());*/
			
			
			
		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayIssueDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayIssueDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}
	
	public static void displayPenaltyDtlsNew(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util=null;
		String strPurchaseTypeComboVals="";

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();
			
			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.displayPenaltyDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}
			
			if(vo.getWsPurchaseType()!=null)
			{
				strPurchaseTypeComboVals=util.getOptionValue(vo.getWsPurchaseType(),"0", "0^Select Value", true);
			}
			else
			{
				strPurchaseTypeComboVals="<option value='0'>Select Value</option>";
			}
			
			formBean.setStrPurchaseTypeComboVals(strPurchaseTypeComboVals);
			formBean.setStrPenRejBreak(vo.getStrPenRejBreak());
			/*formBean.setStrPenaltyDetailsList(MmsConfigMstHLP.getPenaltyList(
					formBean, vo.getWsPenaltyDetailsList()));*/

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayPenaltyDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayPenaltyDtls()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}

	}
	public static void displayPhysicalStockVerifyDtlsNew(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
		HisUtil util = null;

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

			util = new HisUtil("Mms Config Mst ", "MmsConfigMstDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			bo.displayPhysicalStockDtls(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			String strStoreList = "<option value='0'>Select Value</option>";

			if (vo.getWsStoreDetailsList() != null
					&& vo.getWsStoreDetailsList().size() > 0) {

				strStoreList = util.getOptionValue(vo.getWsStoreDetailsList(),
						"0", "0^Select Value", true);

			}

			formBean.setStrStoreDetailsValues(strStoreList);

		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayPhysicalStockVerifyDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayPhysicalStockVerifyDtls()",
					strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			bo = null;
			vo = null;
			util = null;

		}

	}
	
	public static void displayReportParameterDtlsNew(MmsConfigMstFB formBean,
			HttpServletRequest request) {

		String strMsgText = "";
		MmsConfigMstBO bo = null;
		MmsConfigMstVO vo = null;
	

		try {
			bo = new MmsConfigMstBO();
			vo = new MmsConfigMstVO();

		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
		
		
			vo.setStrHospitalCode(hosCode);

			bo.displayReportDetailsValues(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrCategoryA(vo.getStrCategoryA());
			formBean.setStrCategoryB1(vo.getStrCategoryB1());
			formBean.setStrCategoryB2(vo.getStrCategoryB2());
			formBean.setStrCategoryC(vo.getStrCategoryC());
			

			formBean.setStrCategoryF(vo.getStrCategoryF());
			formBean.setStrCategoryN1(vo.getStrCategoryN1());
			formBean.setStrCategoryN2(vo.getStrCategoryN2());
			formBean.setStrCategoryS(vo.getStrCategoryS());
			
			
		} catch (Exception e) {
			strMsgText = "MmsConfigMaster.MmsConfigMstDATA.displayReportParameterDtls() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MmsConfigMstDATA->displayReportParameterDtls()",
					strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			bo = null;
			vo = null;
			
		}

	}
	////////////////////////////////////////////////////////////
	
}
