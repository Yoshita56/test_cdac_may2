/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransFB.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransFB.
 */
public class SupplierDeskInterfaceTransFB extends ActionForm {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	
	private String strBatchNo ="";
	private String strTableWidth="";
	private String strReplacementBatchFlag = "0";
	private String strPrevInvoiceExists = "0";
	
	private String strIndentItemList = "";
	private String strApprovalFlag="";
    private String strChk="";
	/** The str multi row batch no. */
    private String[] strCheckHidValue= null;
    private String[] strHiddenValue = null;
    private String 	 strBatchExdateFlag="";
    
    private String strTotalBalanceQty = "";
    
    private String strNewTranche = "";
    private String strNewPdiFlag = "";
    
    
    private String[] strPrgDtl = null;
    private String strPOHiddenValue;   
    private String strRejectedBatchList="";
    private String strPrgId="";
	private String strFSId="";
	private String strPrgName="";	
	private String strItemNameNew="";	
	private String strFSName="";
	private String strSupplierInvoiceNo="";
	private String strUploadFileId="";
    private String strCartonGene ="";
    private String strRateContQty = "";
	private String[] strMultiRowBatchNo = null;
	private String[] strMultiRowReceiveQty = null;
	private String[] strReceivedItemHiddenDtl = null;
	private String[] strReceivedItemMultiRowDtl = null;
	private String[] strNewReceivedQty = null;
	private String[] strMultiRowManufacterDate = null;
	private String[] strMultiRowExpireDate = null;
	private String[] strMultiRowReceivedQty = null;
	private String[] strMultiRowProgrammeDtl = null;
	private String[] strMultiRowUnit = null;
	private String[] strUnitComboHiddenVal = null;
	/** The str location. */
	private FormFile strLocation = null;
	private String strBarCodeString="";
	
	private String strLefttBatchList="";
	private String strRightBatchList="";
	private String strReplacementDirectBatchFlag="";
	private String strLeftBatchNos="";
	private String strRightBatchNos="";
	

	/** The str file no. */
	private String strFileNo = "";

	/** The str page no. */
	private String strPageNo = "";

	/** The str file name. */
	private String strFileName = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str verify flag. */
	private String strVerifyFlag = "0";
	private String strBatchCombo="";
	private String strDrugNameCombo="";
	private String strUnitCmbValue="";

	private String strConsigneeStoreCombo="";
	/** The str item category id. */
	private String strItemCategoryId = "0";

	/** The str item category name. */
	private String strItemCategoryName = "";
	
	private String strScheduleNo="";
	
	private String strSupplierReceiptNo="";
	
	private String strSupplierReceiptDate="";
	
	private String strDrugShelfLife="";
	
	private String strManufacturerName = "";
	
	private String strConsigneeStore = "";
	private String strPreviousDeliveryDtls="";
	private String strDrugBrandId="0";
	
	private String strNoOfPackets= "";

	private String strPackageWeight= "";

	private String strDeliveryMode= "";

	private String strDeliveryModeValues= "";


	private String strDeliveryModeText= "";


	private String strTransporterName= "";


	private String strLorryNo= "";

	private String strExpectedDelDate= "";
	
	private String strExpectedDeliveryDays= "";
	private String strDeliveryStoreId="";
	/** The str po no. */
	private String strPoNo = "0";

	private String strPONoWithPreFix="";

	/** The str po date. */
	private String strPoDate = "";

	/** The str po type id. */
	private String strPoTypeId = "0";

	/** The str po type. */
	private String strPoType = "";

	/** The str po store id. */
	private String strPOStoreId = "0";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str err. */
	private String strErr = "";

	/** The str warning. */
	private String strWarning = "";

	/** The str msg. */
	private String strMsg = "";

	/** The str to store. */
	private String strToStore = "";

	/** The str to store values. */
	private String strToStoreValues = "";

	/** The str item cat. */
	private String strItemCat = "";

	/** The str item cat values. */
	private String strItemCatValues = "";
	
	private String strDwhTypeId = "";

	/** The str agenda period. */
	private String strAgendaPeriod = "";

	/** The str indent details. */
	private String strIndentDetails = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str agenda status. */
	private String strAgendaStatus = "";

	/** The str check box. */
	private String[] strCheckBox = null;

	/** The str grant type values. */
	private String strGrantTypeValues = "";

	/** The str grant type id. */
	private String strGrantTypeId = "";

	/** The str popup id. */
	private String strPopupId = "";

	/** The str store name. */
	private String strStoreName = "";

	/** The str item cat name. */
	private String strItemCatName = "";

	/** The str item popup data. */
	private String strItemPopupData = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str rate unit values. */
	private String strRateUnitValues = "";

	/** The str po type values. */
	private String strPOTypeValues = "";

	/** The str po type id. */
	private String strPOTypeId = "";

	/** The str supplier values. */
	private String strSupplierValues = "";

	/** The str supplier id. */
	private String strSupplierId = "";

	/** The str request id. */
	private String strRequestId = "";

	/** The str contract type. */
	private String strContractType = "";

	/** The str req idn date. */
	private String strReqIdnDate = "";

	/** The str manufacturer values. */
	private String strManufacturerValues = "";

	/** The str purchase source values. */
	private String strPurchaseSourceValues = "";

	/** The str delivery location values. */
	private String strDeliveryLocationValues = "";

	/** The str agent name values. */
	private String strAgentNameValues = "";

	/** The str currency values. */
	private String strCurrencyValues = "";

	/** The str check data. */
	private String strCheckData = "";

	/** The str d purchase source. */
	private String strDPurchaseSource = "";

	/** The str d delivery location. */
	private String strDDeliveryLocation = "";

	/** The str d tender no. */
	private String strDTenderNo = "";

	/** The str d tender date. */
	private String strDTenderDate = "";

	/** The str d quotation no. */
	private String strDQuotationNo = "";

	/** The str d quotation date. */
	private String strDQuotationDate = "";

	/** The str d remarks. */
	private String strDRemarks = "";

	/** The str d over all tax. */
	private String strDOverAllTax = "";

	/** The str current date. */
	private String strCurrentDate = "";

	/** The str verified date. */
	private String strVerifiedDate = "";

	/** The str verified by. */
	private String strVerifiedBy = "";

	/** The str inr currency id. */
	private String strINRCurrencyId = "";

	/** The str approved by vals. */
	private String strApprovedByVals = "";

	/** The wb request detail. */
	private WebRowSet wbRequestDetail = null;

	/** The wb request item detail. */
	private WebRowSet wbRequestItemDetail = null;

	/** The wbs store name combo. */
	private WebRowSet wbsStoreNameCombo = null;

	/** The wbs req list po. */
	private WebRowSet wbsReqListPO = null;

	/** The str d approx rate unit. */
	private String[] strDApproxRateUnit = null;

	/** The str d approx rate. */
	private String[] strDApproxRate = null;

	/** The str ditem id. */
	private String[] strDitemId = null;

	/** The str ditem brand id. */
	private String[] strDitemBrandId = null;

	/** The str d group id. */
	private String[] strDGroupId = null;

	/** The str d sub group id. */
	private String[] strDSubGroupId = null;

	/** The str d compiled qty. */
	private String[] strDCompiledQty = null;

	/** The str d compiled qty unit. */
	private String[] strDCompiledQtyUnit = null;

	/** The str d request no. */
	private String[] strDRequestNo = null;

	/** The str d request date. */
	private String[] strDRequestDate = null;

	/** The str d request period. */
	private String[] strDRequestPeriod = null;

	/** The str d raising store. */
	private String[] strDRaisingStore = null;

	/** The str d lst po no. */
	private String[] strDLstPoNo = null;

	/** The str d lst po date. */
	private String[] strDLstPoDate = null;

	/** The str d lst supplier id. */
	private String[] strDLstSupplierId = null;

	/** The str d lst rec qty. */
	private String[] strDLstRecQty = null;

	/** The str d lst rec qty unit. */
	private String[] strDLstRecQtyUnit = null;

	/** The str d lst rec date. */
	private String[] strDLstRecDate = null;

	/** The str d lst pur rate. */
	private String[] strDLstPurRate = null;

	/** The str d lst pur rate unit. */
	private String[] strDLstPurRateUnit = null;

	/** The str d request type. */
	private String[] strDRequestType = null;

	/** The str check box item. */
	private String[] strCheckBoxItem = null;

	/** The str component id. */
	private String[] strComponentID = null;

	/** The str component name. */
	private String[] strComponentName = null;

	/** The str component value. */
	private String[] strComponentValue = null;

	/** The str d manufacturer id. */
	private String[] strDManufacturerId = null;

	/** The str d warranty required. */
	private String[] strDWarrantyRequired = null;

	/** The str d installation required. */
	private String[] strDInstallationRequired = null;

	/** The str d rate. */
	private String[] strDRate = null;

	/** The str d rate unit id. */
	private String[] strDRateUnitId = null;

	/** The str d tax. */
	private String[] strDTax = null;

	/** The str dcr no. */
	private String[] strDCRNo = null;

	/** The str make. */
	private String[] strMake = null;

	/** The str store ids. */
	private String strStoreIds = "";

	/** The str request ids. */
	private String strRequestIds = "";

	/** The str item ids. */
	private String strItemIds = "";

	/** The str item brand ids. */
	private String strItemBrandIds = "";

	/** The str d component value. */
	private String[] strDComponentValue = null;

	/** The str d component id. */
	private String[] strDComponentId = null;

	/** The str d demurrage by. */
	private String strDDemurrageBy = "";

	/** The str d agent name. */
	private String strDAgentName = "";

	/** The str dca name. */
	private String strDCAName = "";

	/** The str diac charge. */
	private String strDIACCharge = "";

	/** The str d insurance charge. */
	private String strDInsuranceCharge = "";

	/** The str d currency name. */
	private String strDCurrencyName = "";

	/** The str d currency value. */
	private String strDCurrencyValue = "";

	/** The str d delivery date. */
	private String strDDeliveryDate = "";

	/** The str d net amount. */
	private String strDNetAmount = "";

	/** The str d order qty. */
	private String[] strDOrderQty = null;

	/** The str d order qty unit id. */
	private String[] strDOrderQtyUnitId = null;

	/** The str po grant type. */
	private String strPOGrantType = "";

	/** The str tmp req no. */
	private String[] strTmpReqNo = null;

	/** The str tmp raising store. */
	private String[] strTmpRaisingStore = null;

	/** The str tmp bal qty. */
	private String[] strTmpBalQty = null;

	/** The str qrder qty. */
	private String[] strQrderQty = null;

	/** The str orde cost. */
	private String[] strOrdeCost = null;

	/** The str schedule one. */
	private String[] strScheduleOne = null;

	/** The str schedule two. */
	private String[] strScheduleTwo = null;

	/** The str schedule three. */
	private String[] strScheduleThree = null;

	/** The str schedule four. */
	private String[] strScheduleFour = null;

	/** The str schedule. */
	private String strSchedule = "";

	/** The str po refrence no. */
	private String strPoRefrenceNo;

	/** The str cal delivery date. */
	private String strCalDeliveryDate;

	/** The str is foreign flg. */
	private String strIsForeignFlg;

	/** The str date piker flag. */
	private String strDatePikerFlag;

	/** The str po refrence date. */
	private String strPORefrenceDate;

	/** The str d delivery days. */
	private String strDDeliveryDays;

	/** The str total po cost. */
	private String strTotalPOCost;

	/** The str index. */
	private String strIndex;

	/** The str po item cmb. */
	private String strPOItemCmb;

	/** The str po item id. */
	private String strPOItemID;

	/** The str re order flg color. */
	private String strReOrderFlgColor;

	/** The str current financial year. */
	private String strCurrentFinancialYear;

	/** The str next financial year. */
	private String strNextFinancialYear;

	/** The str indent period value. */
	private String strIndentPeriodValue;

	/** The str rate tax. */
	private String strRateTax;

	/** The str combo po type id. */
	private String strComboPOTypeId;

	/** The str item make. */
	private String strItemMake;

	/** The str item rate tax. */
	private String strItemRateTax;

	/** The str item rate. */
	private String strItemRate;

	/** The str item manufacturer id. */
	private String strItemManufacturerId;

	/** The str po financial dtl. */
	private String strPOFinancialDtl;

	/** The str rate unit id. */
	private String strRateUnitId;

	/** The str item rate unit id. */
	private String strItemRateUnitId;

	/** The str po details hid value. */
	private String[] strPODetailsHidValue = null;

	/** The str programme id. */
	private String[] strProgrammeId = null;

	/** The str po no. */
	private String strPONo;

	/** The str po date. */
	private String strPODate;

	/** The str supplier name. */
	private String strSupplierName;

	/** The str po type. */
	private String strPOType;

	/** The str po item details. */
	private String strPOItemDetails;

	/** The str po hidden value. */
	

	/** The str po demand year. */
	private String strPODemandYear;

	/** The str modify flg. */
	private String strModifyFlg = "0";

	/** The str purchase source id. */
	private String strPurchaseSourceID;

	/** The str verify by id. */
	private String strVerifyById;

	/** The str financial start date. */
	private String strFinancialStartDate;

	/** The str financial to date. */
	private String strFinancialToDate;

	/** The str mode. */
	private String strMode;

	/** The str total qrder qty. */
	private String strTotalQrderQty;

	/** The str po refrence no cmb. */
	private String strPoRefrenceNoCmb;

	/** The str po approval flag. */
	private String strPOApprovalFlag = "0";

	/** The str next po date. */
	private String strNextPoDate;

	/** The str combo po type value. */
	private String strComboPOTypeValue;

	/** The str purchase committe meeting date. */
	private String strPurchaseCommitteMeetingDate;

	/** The str chk component. */
	private String strChkComponent;

	/** The combo. */
	private String[] combo = null;

	/** The str tmp po type. */
	private String strTmpPOType = "";

	/** The str financial year combo. */
	private String strFinancialYearCombo;

	/** The str po financial year. */
	private String strPOFinancialYear;

	/** The str view mode. */
	private String strViewMode = "0";

	/** The str po refrence no text. */
	private String strPoRefrenceNoText = "";

	/** The str po auth type id. */
	private String strPOAuthTypeId = "";

	/** The str po multi refrence no. */
	private String strPoMultiRefrenceNo = "";

	/** The str d delivery days2. */
	private String strDDeliveryDays2 = "";

	/** The str d delivery days3. */
	private String strDDeliveryDays3 = "";

	/** The str d delivery days4. */
	private String strDDeliveryDays4 = "";
	
	private String strDDeliveryDays5 = "";
	private String strDDeliveryDays6 = "";
	private String strDDeliveryDays7 = "";
	private String strDDeliveryDays8 = "";

	private String strDriverName="";
	private String strDriverMobileNo="";
	private String strDateOfDelivery="";
	
	private String strDateOfDispatch="";
	
	private String strSupplierInterfaceReport="";
	private String strHtmlCode="";
	
	
	
			
	public String getStrHtmlCode() {
		return strHtmlCode;
	}

	public void setStrHtmlCode(String strHtmlCode) {
		this.strHtmlCode = strHtmlCode;
	}

	/**
	 * @return the strSupplierInterfaceReport
	 */
	public String getStrSupplierInterfaceReport() {
		return strSupplierInterfaceReport;
	}

	/**
	 * @param strSupplierInterfaceReport the strSupplierInterfaceReport to set
	 */
	public void setStrSupplierInterfaceReport(String strSupplierInterfaceReport) {
		this.strSupplierInterfaceReport = strSupplierInterfaceReport;
	}

	public String getStrDateOfDispatch() {
		return strDateOfDispatch;
	}

	public void setStrDateOfDispatch(String strDateOfDispatch) {
		this.strDateOfDispatch = strDateOfDispatch;
	}

	public String getStrDriverName() {
		return strDriverName;
	}

	public void setStrDriverName(String strDriverName) {
		this.strDriverName = strDriverName;
	}

	public String getStrDriverMobileNo() {
		return strDriverMobileNo;
	}

	public void setStrDriverMobileNo(String strDriverMobileNo) {
		this.strDriverMobileNo = strDriverMobileNo;
	}

	public String getStrDateOfDelivery() {
		return strDateOfDelivery;
	}

	public void setStrDateOfDelivery(String strDateOfDelivery) {
		this.strDateOfDelivery = strDateOfDelivery;
	}

	public String getStrTableWidth() {
		return strTableWidth;
	}

	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}

	public String getStrIndentItemList() {
		return strIndentItemList;
	}

	public void setStrIndentItemList(String strIndentItemList) {
		this.strIndentItemList = strIndentItemList;
	}

	public String getStrCtDate() {
		return strCtDate;
	}

	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	public String getStrVerifyFlag() {
		return strVerifyFlag;
	}

	public void setStrVerifyFlag(String strVerifyFlag) {
		this.strVerifyFlag = strVerifyFlag;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}

	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrPoNo() {
		return strPoNo;
	}

	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	public String getStrPoDate() {
		return strPoDate;
	}

	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	public String getStrPoTypeId() {
		return strPoTypeId;
	}

	public void setStrPoTypeId(String strPoTypeId) {
		this.strPoTypeId = strPoTypeId;
	}

	public String getStrPoType() {
		return strPoType;
	}

	public void setStrPoType(String strPoType) {
		this.strPoType = strPoType;
	}

	

	public String getStrMsgType() {
		return strMsgType;
	}

	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	public String getStrErr() {
		return strErr;
	}

	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	public String getStrWarning() {
		return strWarning;
	}

	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public String getStrToStore() {
		return strToStore;
	}

	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}

	public String getStrToStoreValues() {
		return strToStoreValues;
	}

	public void setStrToStoreValues(String strToStoreValues) {
		this.strToStoreValues = strToStoreValues;
	}

	public String getStrItemCat() {
		return strItemCat;
	}

	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}

	public String getStrItemCatValues() {
		return strItemCatValues;
	}

	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}

	public String getStrDwhTypeId() {
		return strDwhTypeId;
	}

	public void setStrDwhTypeId(String strDwhTypeId) {
		this.strDwhTypeId = strDwhTypeId;
	}

	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}

	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}

	public String getStrIndentDetails() {
		return strIndentDetails;
	}

	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	public String getStrRemarks() {
		return strRemarks;
	}

	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getStrStoreId() {
		return strStoreId;
	}

	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	public String getStrAgendaStatus() {
		return strAgendaStatus;
	}

	public void setStrAgendaStatus(String strAgendaStatus) {
		this.strAgendaStatus = strAgendaStatus;
	}

	public String[] getStrCheckBox() {
		return strCheckBox;
	}

	public void setStrCheckBox(String[] strCheckBox) {
		this.strCheckBox = strCheckBox;
	}

	public String getStrGrantTypeValues() {
		return strGrantTypeValues;
	}

	public void setStrGrantTypeValues(String strGrantTypeValues) {
		this.strGrantTypeValues = strGrantTypeValues;
	}

	public String getStrGrantTypeId() {
		return strGrantTypeId;
	}

	public void setStrGrantTypeId(String strGrantTypeId) {
		this.strGrantTypeId = strGrantTypeId;
	}

	public String getStrPopupId() {
		return strPopupId;
	}

	public void setStrPopupId(String strPopupId) {
		this.strPopupId = strPopupId;
	}

	public String getStrStoreName() {
		return strStoreName;
	}

	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	public String getStrItemCatName() {
		return strItemCatName;
	}

	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}

	public String getStrItemPopupData() {
		return strItemPopupData;
	}

	public void setStrItemPopupData(String strItemPopupData) {
		this.strItemPopupData = strItemPopupData;
	}

	public String getStrItemId() {
		return strItemId;
	}

	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}

	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}

	public String getStrPOTypeValues() {
		return strPOTypeValues;
	}

	public void setStrPOTypeValues(String strPOTypeValues) {
		this.strPOTypeValues = strPOTypeValues;
	}

	public String getStrPOTypeId() {
		return strPOTypeId;
	}

	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}

	public String getStrSupplierValues() {
		return strSupplierValues;
	}

	public void setStrSupplierValues(String strSupplierValues) {
		this.strSupplierValues = strSupplierValues;
	}

	public String getStrSupplierId() {
		return strSupplierId;
	}

	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	public String getStrRequestId() {
		return strRequestId;
	}

	public void setStrRequestId(String strRequestId) {
		this.strRequestId = strRequestId;
	}

	public String getStrContractType() {
		return strContractType;
	}

	public void setStrContractType(String strContractType) {
		this.strContractType = strContractType;
	}

	public String getStrReqIdnDate() {
		return strReqIdnDate;
	}

	public void setStrReqIdnDate(String strReqIdnDate) {
		this.strReqIdnDate = strReqIdnDate;
	}

	public String getStrManufacturerValues() {
		return strManufacturerValues;
	}

	public void setStrManufacturerValues(String strManufacturerValues) {
		this.strManufacturerValues = strManufacturerValues;
	}

	public String getStrPurchaseSourceValues() {
		return strPurchaseSourceValues;
	}

	public void setStrPurchaseSourceValues(String strPurchaseSourceValues) {
		this.strPurchaseSourceValues = strPurchaseSourceValues;
	}

	public String getStrDeliveryLocationValues() {
		return strDeliveryLocationValues;
	}

	public void setStrDeliveryLocationValues(String strDeliveryLocationValues) {
		this.strDeliveryLocationValues = strDeliveryLocationValues;
	}

	public String getStrAgentNameValues() {
		return strAgentNameValues;
	}

	public void setStrAgentNameValues(String strAgentNameValues) {
		this.strAgentNameValues = strAgentNameValues;
	}

	public String getStrCurrencyValues() {
		return strCurrencyValues;
	}

	public void setStrCurrencyValues(String strCurrencyValues) {
		this.strCurrencyValues = strCurrencyValues;
	}

	public String getStrCheckData() {
		return strCheckData;
	}

	public void setStrCheckData(String strCheckData) {
		this.strCheckData = strCheckData;
	}

	public String getStrDPurchaseSource() {
		return strDPurchaseSource;
	}

	public void setStrDPurchaseSource(String strDPurchaseSource) {
		this.strDPurchaseSource = strDPurchaseSource;
	}

	public String getStrDDeliveryLocation() {
		return strDDeliveryLocation;
	}

	public void setStrDDeliveryLocation(String strDDeliveryLocation) {
		this.strDDeliveryLocation = strDDeliveryLocation;
	}

	public String getStrDTenderNo() {
		return strDTenderNo;
	}

	public void setStrDTenderNo(String strDTenderNo) {
		this.strDTenderNo = strDTenderNo;
	}

	public String getStrDTenderDate() {
		return strDTenderDate;
	}

	public void setStrDTenderDate(String strDTenderDate) {
		this.strDTenderDate = strDTenderDate;
	}

	public String getStrDQuotationNo() {
		return strDQuotationNo;
	}

	public void setStrDQuotationNo(String strDQuotationNo) {
		this.strDQuotationNo = strDQuotationNo;
	}

	public String getStrDQuotationDate() {
		return strDQuotationDate;
	}

	public void setStrDQuotationDate(String strDQuotationDate) {
		this.strDQuotationDate = strDQuotationDate;
	}

	public String getStrDRemarks() {
		return strDRemarks;
	}

	public void setStrDRemarks(String strDRemarks) {
		this.strDRemarks = strDRemarks;
	}

	public String getStrDOverAllTax() {
		return strDOverAllTax;
	}

	public void setStrDOverAllTax(String strDOverAllTax) {
		this.strDOverAllTax = strDOverAllTax;
	}

	public String getStrCurrentDate() {
		return strCurrentDate;
	}

	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}

	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}

	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}

	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}

	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}

	public String getStrINRCurrencyId() {
		return strINRCurrencyId;
	}

	public void setStrINRCurrencyId(String strINRCurrencyId) {
		this.strINRCurrencyId = strINRCurrencyId;
	}

	public String getStrApprovedByVals() {
		return strApprovedByVals;
	}

	public void setStrApprovedByVals(String strApprovedByVals) {
		this.strApprovedByVals = strApprovedByVals;
	}

	public WebRowSet getWbRequestDetail() {
		return wbRequestDetail;
	}

	public void setWbRequestDetail(WebRowSet wbRequestDetail) {
		this.wbRequestDetail = wbRequestDetail;
	}

	public WebRowSet getWbRequestItemDetail() {
		return wbRequestItemDetail;
	}

	public void setWbRequestItemDetail(WebRowSet wbRequestItemDetail) {
		this.wbRequestItemDetail = wbRequestItemDetail;
	}

	public WebRowSet getWbsStoreNameCombo() {
		return wbsStoreNameCombo;
	}

	public void setWbsStoreNameCombo(WebRowSet wbsStoreNameCombo) {
		this.wbsStoreNameCombo = wbsStoreNameCombo;
	}

	public WebRowSet getWbsReqListPO() {
		return wbsReqListPO;
	}

	public void setWbsReqListPO(WebRowSet wbsReqListPO) {
		this.wbsReqListPO = wbsReqListPO;
	}

	public String[] getStrDApproxRateUnit() {
		return strDApproxRateUnit;
	}

	public void setStrDApproxRateUnit(String[] strDApproxRateUnit) {
		this.strDApproxRateUnit = strDApproxRateUnit;
	}

	public String[] getStrDApproxRate() {
		return strDApproxRate;
	}

	public void setStrDApproxRate(String[] strDApproxRate) {
		this.strDApproxRate = strDApproxRate;
	}

	public String[] getStrDitemId() {
		return strDitemId;
	}

	public void setStrDitemId(String[] strDitemId) {
		this.strDitemId = strDitemId;
	}

	public String[] getStrDitemBrandId() {
		return strDitemBrandId;
	}

	public void setStrDitemBrandId(String[] strDitemBrandId) {
		this.strDitemBrandId = strDitemBrandId;
	}

	public String[] getStrDGroupId() {
		return strDGroupId;
	}

	public void setStrDGroupId(String[] strDGroupId) {
		this.strDGroupId = strDGroupId;
	}

	public String[] getStrDSubGroupId() {
		return strDSubGroupId;
	}

	public void setStrDSubGroupId(String[] strDSubGroupId) {
		this.strDSubGroupId = strDSubGroupId;
	}

	public String[] getStrDCompiledQty() {
		return strDCompiledQty;
	}

	public void setStrDCompiledQty(String[] strDCompiledQty) {
		this.strDCompiledQty = strDCompiledQty;
	}

	public String[] getStrDCompiledQtyUnit() {
		return strDCompiledQtyUnit;
	}

	public void setStrDCompiledQtyUnit(String[] strDCompiledQtyUnit) {
		this.strDCompiledQtyUnit = strDCompiledQtyUnit;
	}

	public String[] getStrDRequestNo() {
		return strDRequestNo;
	}

	public void setStrDRequestNo(String[] strDRequestNo) {
		this.strDRequestNo = strDRequestNo;
	}

	public String[] getStrDRequestDate() {
		return strDRequestDate;
	}

	public void setStrDRequestDate(String[] strDRequestDate) {
		this.strDRequestDate = strDRequestDate;
	}

	public String[] getStrDRequestPeriod() {
		return strDRequestPeriod;
	}

	public void setStrDRequestPeriod(String[] strDRequestPeriod) {
		this.strDRequestPeriod = strDRequestPeriod;
	}

	public String[] getStrDRaisingStore() {
		return strDRaisingStore;
	}

	public void setStrDRaisingStore(String[] strDRaisingStore) {
		this.strDRaisingStore = strDRaisingStore;
	}

	public String[] getStrDLstPoNo() {
		return strDLstPoNo;
	}

	public void setStrDLstPoNo(String[] strDLstPoNo) {
		this.strDLstPoNo = strDLstPoNo;
	}

	public String[] getStrDLstPoDate() {
		return strDLstPoDate;
	}

	public void setStrDLstPoDate(String[] strDLstPoDate) {
		this.strDLstPoDate = strDLstPoDate;
	}

	public String[] getStrDLstSupplierId() {
		return strDLstSupplierId;
	}

	public void setStrDLstSupplierId(String[] strDLstSupplierId) {
		this.strDLstSupplierId = strDLstSupplierId;
	}

	public String[] getStrDLstRecQty() {
		return strDLstRecQty;
	}

	public void setStrDLstRecQty(String[] strDLstRecQty) {
		this.strDLstRecQty = strDLstRecQty;
	}

	public String[] getStrDLstRecQtyUnit() {
		return strDLstRecQtyUnit;
	}

	public void setStrDLstRecQtyUnit(String[] strDLstRecQtyUnit) {
		this.strDLstRecQtyUnit = strDLstRecQtyUnit;
	}

	public String[] getStrDLstRecDate() {
		return strDLstRecDate;
	}

	public void setStrDLstRecDate(String[] strDLstRecDate) {
		this.strDLstRecDate = strDLstRecDate;
	}

	public String[] getStrDLstPurRate() {
		return strDLstPurRate;
	}

	public void setStrDLstPurRate(String[] strDLstPurRate) {
		this.strDLstPurRate = strDLstPurRate;
	}

	public String[] getStrDLstPurRateUnit() {
		return strDLstPurRateUnit;
	}

	public void setStrDLstPurRateUnit(String[] strDLstPurRateUnit) {
		this.strDLstPurRateUnit = strDLstPurRateUnit;
	}

	public String[] getStrDRequestType() {
		return strDRequestType;
	}

	public void setStrDRequestType(String[] strDRequestType) {
		this.strDRequestType = strDRequestType;
	}

	public String[] getStrCheckBoxItem() {
		return strCheckBoxItem;
	}

	public void setStrCheckBoxItem(String[] strCheckBoxItem) {
		this.strCheckBoxItem = strCheckBoxItem;
	}

	public String[] getStrComponentID() {
		return strComponentID;
	}

	public void setStrComponentID(String[] strComponentID) {
		this.strComponentID = strComponentID;
	}

	public String[] getStrComponentName() {
		return strComponentName;
	}

	public void setStrComponentName(String[] strComponentName) {
		this.strComponentName = strComponentName;
	}

	public String[] getStrComponentValue() {
		return strComponentValue;
	}

	public void setStrComponentValue(String[] strComponentValue) {
		this.strComponentValue = strComponentValue;
	}

	public String[] getStrDManufacturerId() {
		return strDManufacturerId;
	}

	public void setStrDManufacturerId(String[] strDManufacturerId) {
		this.strDManufacturerId = strDManufacturerId;
	}

	public String[] getStrDWarrantyRequired() {
		return strDWarrantyRequired;
	}

	public void setStrDWarrantyRequired(String[] strDWarrantyRequired) {
		this.strDWarrantyRequired = strDWarrantyRequired;
	}

	public String[] getStrDInstallationRequired() {
		return strDInstallationRequired;
	}

	public void setStrDInstallationRequired(String[] strDInstallationRequired) {
		this.strDInstallationRequired = strDInstallationRequired;
	}

	public String[] getStrDRate() {
		return strDRate;
	}

	public void setStrDRate(String[] strDRate) {
		this.strDRate = strDRate;
	}

	public String[] getStrDRateUnitId() {
		return strDRateUnitId;
	}

	public void setStrDRateUnitId(String[] strDRateUnitId) {
		this.strDRateUnitId = strDRateUnitId;
	}

	public String[] getStrDTax() {
		return strDTax;
	}

	public void setStrDTax(String[] strDTax) {
		this.strDTax = strDTax;
	}

	public String[] getStrDCRNo() {
		return strDCRNo;
	}

	public void setStrDCRNo(String[] strDCRNo) {
		this.strDCRNo = strDCRNo;
	}

	public String[] getStrMake() {
		return strMake;
	}

	public void setStrMake(String[] strMake) {
		this.strMake = strMake;
	}

	public String getStrStoreIds() {
		return strStoreIds;
	}

	public void setStrStoreIds(String strStoreIds) {
		this.strStoreIds = strStoreIds;
	}

	public String getStrRequestIds() {
		return strRequestIds;
	}

	public void setStrRequestIds(String strRequestIds) {
		this.strRequestIds = strRequestIds;
	}

	public String getStrItemIds() {
		return strItemIds;
	}

	public void setStrItemIds(String strItemIds) {
		this.strItemIds = strItemIds;
	}

	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}

	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}

	public String[] getStrDComponentValue() {
		return strDComponentValue;
	}

	public void setStrDComponentValue(String[] strDComponentValue) {
		this.strDComponentValue = strDComponentValue;
	}

	public String[] getStrDComponentId() {
		return strDComponentId;
	}

	public void setStrDComponentId(String[] strDComponentId) {
		this.strDComponentId = strDComponentId;
	}

	public String getStrDDemurrageBy() {
		return strDDemurrageBy;
	}

	public void setStrDDemurrageBy(String strDDemurrageBy) {
		this.strDDemurrageBy = strDDemurrageBy;
	}

	public String getStrDAgentName() {
		return strDAgentName;
	}

	public void setStrDAgentName(String strDAgentName) {
		this.strDAgentName = strDAgentName;
	}

	public String getStrDCAName() {
		return strDCAName;
	}

	public void setStrDCAName(String strDCAName) {
		this.strDCAName = strDCAName;
	}

	public String getStrDIACCharge() {
		return strDIACCharge;
	}

	public void setStrDIACCharge(String strDIACCharge) {
		this.strDIACCharge = strDIACCharge;
	}

	public String getStrDInsuranceCharge() {
		return strDInsuranceCharge;
	}

	public void setStrDInsuranceCharge(String strDInsuranceCharge) {
		this.strDInsuranceCharge = strDInsuranceCharge;
	}

	public String getStrDCurrencyName() {
		return strDCurrencyName;
	}

	public void setStrDCurrencyName(String strDCurrencyName) {
		this.strDCurrencyName = strDCurrencyName;
	}

	public String getStrDCurrencyValue() {
		return strDCurrencyValue;
	}

	public void setStrDCurrencyValue(String strDCurrencyValue) {
		this.strDCurrencyValue = strDCurrencyValue;
	}

	public String getStrDDeliveryDate() {
		return strDDeliveryDate;
	}

	public void setStrDDeliveryDate(String strDDeliveryDate) {
		this.strDDeliveryDate = strDDeliveryDate;
	}

	public String getStrDNetAmount() {
		return strDNetAmount;
	}

	public void setStrDNetAmount(String strDNetAmount) {
		this.strDNetAmount = strDNetAmount;
	}

	public String[] getStrDOrderQty() {
		return strDOrderQty;
	}

	public void setStrDOrderQty(String[] strDOrderQty) {
		this.strDOrderQty = strDOrderQty;
	}

	public String[] getStrDOrderQtyUnitId() {
		return strDOrderQtyUnitId;
	}

	public void setStrDOrderQtyUnitId(String[] strDOrderQtyUnitId) {
		this.strDOrderQtyUnitId = strDOrderQtyUnitId;
	}

	public String getStrPOGrantType() {
		return strPOGrantType;
	}

	public void setStrPOGrantType(String strPOGrantType) {
		this.strPOGrantType = strPOGrantType;
	}

	public String[] getStrTmpReqNo() {
		return strTmpReqNo;
	}

	public void setStrTmpReqNo(String[] strTmpReqNo) {
		this.strTmpReqNo = strTmpReqNo;
	}

	public String[] getStrTmpRaisingStore() {
		return strTmpRaisingStore;
	}

	public void setStrTmpRaisingStore(String[] strTmpRaisingStore) {
		this.strTmpRaisingStore = strTmpRaisingStore;
	}

	public String[] getStrTmpBalQty() {
		return strTmpBalQty;
	}

	public void setStrTmpBalQty(String[] strTmpBalQty) {
		this.strTmpBalQty = strTmpBalQty;
	}

	public String[] getStrQrderQty() {
		return strQrderQty;
	}

	public void setStrQrderQty(String[] strQrderQty) {
		this.strQrderQty = strQrderQty;
	}

	public String[] getStrOrdeCost() {
		return strOrdeCost;
	}

	public void setStrOrdeCost(String[] strOrdeCost) {
		this.strOrdeCost = strOrdeCost;
	}

	public String[] getStrScheduleOne() {
		return strScheduleOne;
	}

	public void setStrScheduleOne(String[] strScheduleOne) {
		this.strScheduleOne = strScheduleOne;
	}

	public String[] getStrScheduleTwo() {
		return strScheduleTwo;
	}

	public void setStrScheduleTwo(String[] strScheduleTwo) {
		this.strScheduleTwo = strScheduleTwo;
	}

	public String[] getStrScheduleThree() {
		return strScheduleThree;
	}

	public void setStrScheduleThree(String[] strScheduleThree) {
		this.strScheduleThree = strScheduleThree;
	}

	public String[] getStrScheduleFour() {
		return strScheduleFour;
	}

	public void setStrScheduleFour(String[] strScheduleFour) {
		this.strScheduleFour = strScheduleFour;
	}

	public String getStrSchedule() {
		return strSchedule;
	}

	public void setStrSchedule(String strSchedule) {
		this.strSchedule = strSchedule;
	}

	public String getStrPoRefrenceNo() {
		return strPoRefrenceNo;
	}

	public void setStrPoRefrenceNo(String strPoRefrenceNo) {
		this.strPoRefrenceNo = strPoRefrenceNo;
	}

	public String getStrCalDeliveryDate() {
		return strCalDeliveryDate;
	}

	public void setStrCalDeliveryDate(String strCalDeliveryDate) {
		this.strCalDeliveryDate = strCalDeliveryDate;
	}

	public String getStrIsForeignFlg() {
		return strIsForeignFlg;
	}

	public void setStrIsForeignFlg(String strIsForeignFlg) {
		this.strIsForeignFlg = strIsForeignFlg;
	}

	public String getStrDatePikerFlag() {
		return strDatePikerFlag;
	}

	public void setStrDatePikerFlag(String strDatePikerFlag) {
		this.strDatePikerFlag = strDatePikerFlag;
	}

	public String getStrPORefrenceDate() {
		return strPORefrenceDate;
	}

	public void setStrPORefrenceDate(String strPORefrenceDate) {
		this.strPORefrenceDate = strPORefrenceDate;
	}

	public String getStrDDeliveryDays() {
		return strDDeliveryDays;
	}

	public void setStrDDeliveryDays(String strDDeliveryDays) {
		this.strDDeliveryDays = strDDeliveryDays;
	}

	public String getStrTotalPOCost() {
		return strTotalPOCost;
	}

	public void setStrTotalPOCost(String strTotalPOCost) {
		this.strTotalPOCost = strTotalPOCost;
	}

	public String getStrIndex() {
		return strIndex;
	}

	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
	}

	public String getStrPOItemCmb() {
		return strPOItemCmb;
	}

	public void setStrPOItemCmb(String strPOItemCmb) {
		this.strPOItemCmb = strPOItemCmb;
	}

	public String getStrPOItemID() {
		return strPOItemID;
	}

	public void setStrPOItemID(String strPOItemID) {
		this.strPOItemID = strPOItemID;
	}

	public String getStrReOrderFlgColor() {
		return strReOrderFlgColor;
	}

	public void setStrReOrderFlgColor(String strReOrderFlgColor) {
		this.strReOrderFlgColor = strReOrderFlgColor;
	}

	public String getStrCurrentFinancialYear() {
		return strCurrentFinancialYear;
	}

	public void setStrCurrentFinancialYear(String strCurrentFinancialYear) {
		this.strCurrentFinancialYear = strCurrentFinancialYear;
	}

	public String getStrNextFinancialYear() {
		return strNextFinancialYear;
	}

	public void setStrNextFinancialYear(String strNextFinancialYear) {
		this.strNextFinancialYear = strNextFinancialYear;
	}

	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}

	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}

	public String getStrRateTax() {
		return strRateTax;
	}

	public void setStrRateTax(String strRateTax) {
		this.strRateTax = strRateTax;
	}

	public String getStrComboPOTypeId() {
		return strComboPOTypeId;
	}

	public void setStrComboPOTypeId(String strComboPOTypeId) {
		this.strComboPOTypeId = strComboPOTypeId;
	}

	public String getStrItemMake() {
		return strItemMake;
	}

	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	public String getStrItemRateTax() {
		return strItemRateTax;
	}

	public void setStrItemRateTax(String strItemRateTax) {
		this.strItemRateTax = strItemRateTax;
	}

	public String getStrItemRate() {
		return strItemRate;
	}

	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}

	public String getStrItemManufacturerId() {
		return strItemManufacturerId;
	}

	public void setStrItemManufacturerId(String strItemManufacturerId) {
		this.strItemManufacturerId = strItemManufacturerId;
	}

	public String getStrPOFinancialDtl() {
		return strPOFinancialDtl;
	}

	public void setStrPOFinancialDtl(String strPOFinancialDtl) {
		this.strPOFinancialDtl = strPOFinancialDtl;
	}

	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	public String getStrItemRateUnitId() {
		return strItemRateUnitId;
	}

	public void setStrItemRateUnitId(String strItemRateUnitId) {
		this.strItemRateUnitId = strItemRateUnitId;
	}

	public String[] getStrPODetailsHidValue() {
		return strPODetailsHidValue;
	}

	public void setStrPODetailsHidValue(String[] strPODetailsHidValue) {
		this.strPODetailsHidValue = strPODetailsHidValue;
	}

	public String[] getStrProgrammeId() {
		return strProgrammeId;
	}

	public void setStrProgrammeId(String[] strProgrammeId) {
		this.strProgrammeId = strProgrammeId;
	}

	public String getStrPONo() {
		return strPONo;
	}

	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}

	public String getStrPODate() {
		return strPODate;
	}

	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrPOType() {
		return strPOType;
	}

	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}

	public String getStrPOItemDetails() {
		return strPOItemDetails;
	}

	public void setStrPOItemDetails(String strPOItemDetails) {
		this.strPOItemDetails = strPOItemDetails;
	}

	public String getStrPOHiddenValue() {
		return strPOHiddenValue;
	}

	public void setStrPOHiddenValue(String strPOHiddenValue) {
		this.strPOHiddenValue = strPOHiddenValue;
	}

	public String getStrPODemandYear() {
		return strPODemandYear;
	}

	public void setStrPODemandYear(String strPODemandYear) {
		this.strPODemandYear = strPODemandYear;
	}

	public String getStrModifyFlg() {
		return strModifyFlg;
	}

	public void setStrModifyFlg(String strModifyFlg) {
		this.strModifyFlg = strModifyFlg;
	}

	public String getStrPurchaseSourceID() {
		return strPurchaseSourceID;
	}

	public void setStrPurchaseSourceID(String strPurchaseSourceID) {
		this.strPurchaseSourceID = strPurchaseSourceID;
	}

	public String getStrVerifyById() {
		return strVerifyById;
	}

	public void setStrVerifyById(String strVerifyById) {
		this.strVerifyById = strVerifyById;
	}

	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	public String getStrFinancialToDate() {
		return strFinancialToDate;
	}

	public void setStrFinancialToDate(String strFinancialToDate) {
		this.strFinancialToDate = strFinancialToDate;
	}

	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	public String getStrTotalQrderQty() {
		return strTotalQrderQty;
	}

	public void setStrTotalQrderQty(String strTotalQrderQty) {
		this.strTotalQrderQty = strTotalQrderQty;
	}

	public String getStrPoRefrenceNoCmb() {
		return strPoRefrenceNoCmb;
	}

	public void setStrPoRefrenceNoCmb(String strPoRefrenceNoCmb) {
		this.strPoRefrenceNoCmb = strPoRefrenceNoCmb;
	}

	public String getStrPOApprovalFlag() {
		return strPOApprovalFlag;
	}

	public void setStrPOApprovalFlag(String strPOApprovalFlag) {
		this.strPOApprovalFlag = strPOApprovalFlag;
	}

	public String getStrNextPoDate() {
		return strNextPoDate;
	}

	public void setStrNextPoDate(String strNextPoDate) {
		this.strNextPoDate = strNextPoDate;
	}

	public String getStrComboPOTypeValue() {
		return strComboPOTypeValue;
	}

	public void setStrComboPOTypeValue(String strComboPOTypeValue) {
		this.strComboPOTypeValue = strComboPOTypeValue;
	}

	public String getStrPurchaseCommitteMeetingDate() {
		return strPurchaseCommitteMeetingDate;
	}

	public void setStrPurchaseCommitteMeetingDate(
			String strPurchaseCommitteMeetingDate) {
		this.strPurchaseCommitteMeetingDate = strPurchaseCommitteMeetingDate;
	}

	public String getStrChkComponent() {
		return strChkComponent;
	}

	public void setStrChkComponent(String strChkComponent) {
		this.strChkComponent = strChkComponent;
	}
	

	public String getStrTmpPOType() {
		return strTmpPOType;
	}

	public void setStrTmpPOType(String strTmpPOType) {
		this.strTmpPOType = strTmpPOType;
	}

	public String getStrFinancialYearCombo() {
		return strFinancialYearCombo;
	}

	public void setStrFinancialYearCombo(String strFinancialYearCombo) {
		this.strFinancialYearCombo = strFinancialYearCombo;
	}

	public String getStrPOFinancialYear() {
		return strPOFinancialYear;
	}

	public void setStrPOFinancialYear(String strPOFinancialYear) {
		this.strPOFinancialYear = strPOFinancialYear;
	}

	public String getStrViewMode() {
		return strViewMode;
	}

	public void setStrViewMode(String strViewMode) {
		this.strViewMode = strViewMode;
	}

	public String getStrPoRefrenceNoText() {
		return strPoRefrenceNoText;
	}

	public void setStrPoRefrenceNoText(String strPoRefrenceNoText) {
		this.strPoRefrenceNoText = strPoRefrenceNoText;
	}

	public String getStrPOAuthTypeId() {
		return strPOAuthTypeId;
	}

	public void setStrPOAuthTypeId(String strPOAuthTypeId) {
		this.strPOAuthTypeId = strPOAuthTypeId;
	}

	public String getStrPoMultiRefrenceNo() {
		return strPoMultiRefrenceNo;
	}

	public void setStrPoMultiRefrenceNo(String strPoMultiRefrenceNo) {
		this.strPoMultiRefrenceNo = strPoMultiRefrenceNo;
	}

	public String getStrDDeliveryDays2() {
		return strDDeliveryDays2;
	}

	public void setStrDDeliveryDays2(String strDDeliveryDays2) {
		this.strDDeliveryDays2 = strDDeliveryDays2;
	}

	public String getStrDDeliveryDays3() {
		return strDDeliveryDays3;
	}

	public void setStrDDeliveryDays3(String strDDeliveryDays3) {
		this.strDDeliveryDays3 = strDDeliveryDays3;
	}

	public String getStrDDeliveryDays4() {
		return strDDeliveryDays4;
	}

	public void setStrDDeliveryDays4(String strDDeliveryDays4) {
		this.strDDeliveryDays4 = strDDeliveryDays4;
	}

	public String getStrPONoWithPreFix() {
		return strPONoWithPreFix;
	}

	public void setStrPONoWithPreFix(String strPONoWithPreFix) {
		this.strPONoWithPreFix = strPONoWithPreFix;
	}

	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}

	public String getStrManufacturerName() {
		return strManufacturerName;
	}

	public void setStrManufacturerName(String strManufacturerName) {
		this.strManufacturerName = strManufacturerName;
	}

	public String getStrConsigneeStore() {
		return strConsigneeStore;
	}

	public void setStrConsigneeStore(String strConsigneeStore) {
		this.strConsigneeStore = strConsigneeStore;
	}

	public String getStrScheduleNo() {
		return strScheduleNo;
	}

	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}

	public String getStrSupplierReceiptNo() {
		return strSupplierReceiptNo;
	}

	public void setStrSupplierReceiptNo(String strSupplierReceiptNo) {
		this.strSupplierReceiptNo = strSupplierReceiptNo;
	}

	public String getStrSupplierReceiptDate() {
		return strSupplierReceiptDate;
	}

	public void setStrSupplierReceiptDate(String strSupplierReceiptDate) {
		this.strSupplierReceiptDate = strSupplierReceiptDate;
	}

	public String getStrDrugShelfLife() {
		return strDrugShelfLife;
	}

	public void setStrDrugShelfLife(String strDrugShelfLife) {
		this.strDrugShelfLife = strDrugShelfLife;
	}

	public String getStrPreviousDeliveryDtls() {
		return strPreviousDeliveryDtls;
	}

	public void setStrPreviousDeliveryDtls(String strPreviousDeliveryDtls) {
		this.strPreviousDeliveryDtls = strPreviousDeliveryDtls;
	}

	public String getStrNoOfPackets() {
		return strNoOfPackets;
	}

	public void setStrNoOfPackets(String strNoOfPackets) {
		this.strNoOfPackets = strNoOfPackets;
	}

	public String getStrPackageWeight() {
		return strPackageWeight;
	}

	public void setStrPackageWeight(String strPackageWeight) {
		this.strPackageWeight = strPackageWeight;
	}

	public String getStrDeliveryMode() {
		return strDeliveryMode;
	}

	public void setStrDeliveryMode(String strDeliveryMode) {
		this.strDeliveryMode = strDeliveryMode;
	}

	public String getStrDeliveryModeValues() {
		return strDeliveryModeValues;
	}

	public void setStrDeliveryModeValues(String strDeliveryModeValues) {
		this.strDeliveryModeValues = strDeliveryModeValues;
	}

	public String getStrDeliveryModeText() {
		return strDeliveryModeText;
	}

	public void setStrDeliveryModeText(String strDeliveryModeText) {
		this.strDeliveryModeText = strDeliveryModeText;
	}

	public String getStrTransporterName() {
		return strTransporterName;
	}

	public void setStrTransporterName(String strTransporterName) {
		this.strTransporterName = strTransporterName;
	}

	public String getStrLorryNo() {
		return strLorryNo;
	}

	public void setStrLorryNo(String strLorryNo) {
		this.strLorryNo = strLorryNo;
	}

	public String getStrExpectedDelDate() {
		return strExpectedDelDate;
	}

	public void setStrExpectedDelDate(String strExpectedDelDate) {
		this.strExpectedDelDate = strExpectedDelDate;
	}

	public String getStrExpectedDeliveryDays() {
		return strExpectedDeliveryDays;
	}

	public void setStrExpectedDeliveryDays(String strExpectedDeliveryDays) {
		this.strExpectedDeliveryDays = strExpectedDeliveryDays;
	}

	public String getStrDeliveryStoreId() {
		return strDeliveryStoreId;
	}

	public void setStrDeliveryStoreId(String strDeliveryStoreId) {
		this.strDeliveryStoreId = strDeliveryStoreId;
	}

	public String getStrDrugBrandId() {
		return strDrugBrandId;
	}

	public void setStrDrugBrandId(String strDrugBrandId) {
		this.strDrugBrandId = strDrugBrandId;
	}

	public String getStrPOStoreId() {
		return strPOStoreId;
	}

	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}

	public String getStrConsigneeStoreCombo() {
		return strConsigneeStoreCombo;
	}

	public void setStrConsigneeStoreCombo(String strConsigneeStoreCombo) {
		this.strConsigneeStoreCombo = strConsigneeStoreCombo;
	}

	public String getStrUnitCmbValue() {
		return strUnitCmbValue;
	}

	public void setStrUnitCmbValue(String strUnitCmbValue) {
		this.strUnitCmbValue = strUnitCmbValue;
	}

	public String getStrBatchCombo() {
		return strBatchCombo;
	}

	public void setStrBatchCombo(String strBatchCombo) {
		this.strBatchCombo = strBatchCombo;
	}

	public String[] getStrMultiRowBatchNo() {
		return strMultiRowBatchNo;
	}

	public void setStrMultiRowBatchNo(String[] strMultiRowBatchNo) {
		this.strMultiRowBatchNo = strMultiRowBatchNo;
	}

	public String[] getStrMultiRowReceiveQty() {
		return strMultiRowReceiveQty;
	}

	public void setStrMultiRowReceiveQty(String[] strMultiRowReceiveQty) {
		this.strMultiRowReceiveQty = strMultiRowReceiveQty;
	}

	public String[] getStrReceivedItemHiddenDtl() {
		return strReceivedItemHiddenDtl;
	}

	public void setStrReceivedItemHiddenDtl(String[] strReceivedItemHiddenDtl) {
		this.strReceivedItemHiddenDtl = strReceivedItemHiddenDtl;
	}

	public String[] getStrReceivedItemMultiRowDtl() {
		return strReceivedItemMultiRowDtl;
	}

	public void setStrReceivedItemMultiRowDtl(String[] strReceivedItemMultiRowDtl) {
		this.strReceivedItemMultiRowDtl = strReceivedItemMultiRowDtl;
	}

	public String[] getStrNewReceivedQty() {
		return strNewReceivedQty;
	}

	public void setStrNewReceivedQty(String[] strNewReceivedQty) {
		this.strNewReceivedQty = strNewReceivedQty;
	}

	public String[] getStrMultiRowManufacterDate() {
		return strMultiRowManufacterDate;
	}

	public void setStrMultiRowManufacterDate(String[] strMultiRowManufacterDate) {
		this.strMultiRowManufacterDate = strMultiRowManufacterDate;
	}

	public String[] getStrMultiRowExpireDate() {
		return strMultiRowExpireDate;
	}

	public void setStrMultiRowExpireDate(String[] strMultiRowExpireDate) {
		this.strMultiRowExpireDate = strMultiRowExpireDate;
	}

	public String[] getStrMultiRowReceivedQty() {
		return strMultiRowReceivedQty;
	}

	public void setStrMultiRowReceivedQty(String[] strMultiRowReceivedQty) {
		this.strMultiRowReceivedQty = strMultiRowReceivedQty;
	}

	public String[] getStrMultiRowProgrammeDtl() {
		return strMultiRowProgrammeDtl;
	}

	public void setStrMultiRowProgrammeDtl(String[] strMultiRowProgrammeDtl) {
		this.strMultiRowProgrammeDtl = strMultiRowProgrammeDtl;
	}

	public String[] getStrMultiRowUnit() {
		return strMultiRowUnit;
	}

	public void setStrMultiRowUnit(String[] strMultiRowUnit) {
		this.strMultiRowUnit = strMultiRowUnit;
	}

	public String[] getStrUnitComboHiddenVal() {
		return strUnitComboHiddenVal;
	}

	public void setStrUnitComboHiddenVal(String[] strUnitComboHiddenVal) {
		this.strUnitComboHiddenVal = strUnitComboHiddenVal;
	}

	public String getStrChk() {
		return strChk;
	}

	public void setStrChk(String strChk) {
		this.strChk = strChk;
	}

	public String getStrApprovalFlag() {
		return strApprovalFlag;
	}

	public void setStrApprovalFlag(String strApprovalFlag) {
		this.strApprovalFlag = strApprovalFlag;
	}

	public String[] getStrHiddenValue() {
		return strHiddenValue;
	}

	public void setStrHiddenValue(String[] strHiddenValue) {
		this.strHiddenValue = strHiddenValue;
	}

	public String[] getStrPrgDtl() {
		return strPrgDtl;
	}

	public void setStrPrgDtl(String[] strPrgDtl) {
		this.strPrgDtl = strPrgDtl;
	}

	public String getStrRejectedBatchList() {
		return strRejectedBatchList;
	}

	public void setStrRejectedBatchList(String strRejectedBatchList) {
		this.strRejectedBatchList = strRejectedBatchList;
	}

	public String[] getStrCheckHidValue() {
		return strCheckHidValue;
	}

	public void setStrCheckHidValue(String[] strCheckHidValue) {
		this.strCheckHidValue = strCheckHidValue;
	}

	public String getStrPrgId() {
		return strPrgId;
	}

	public void setStrPrgId(String strPrgId) {
		this.strPrgId = strPrgId;
	}

	public String getStrFSId() {
		return strFSId;
	}

	public void setStrFSId(String strFSId) {
		this.strFSId = strFSId;
	}

	public String getStrPrgName() {
		return strPrgName;
	}

	public void setStrPrgName(String strPrgName) {
		this.strPrgName = strPrgName;
	}

	public String getStrFSName() {
		return strFSName;
	}

	public void setStrFSName(String strFSName) {
		this.strFSName = strFSName;
	}

	public String getStrSupplierInvoiceNo() {
		return strSupplierInvoiceNo;
	}

	public void setStrSupplierInvoiceNo(String strSupplierInvoiceNo) {
		this.strSupplierInvoiceNo = strSupplierInvoiceNo;
	}

	public FormFile getStrLocation() {
		return strLocation;
	}

	public void setStrLocation(FormFile strLocation) {
		this.strLocation = strLocation;
	}

	public String getStrFileNo() {
		return strFileNo;
	}

	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}

	public String getStrPageNo() {
		return strPageNo;
	}

	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public String getStrUploadFileId() {
		return strUploadFileId;
	}

	public void setStrUploadFileId(String strUploadFileId) {
		this.strUploadFileId = strUploadFileId;
	}

	public String getStrCartonGene() {
		return strCartonGene;
	}

	public void setStrCartonGene(String strCartonGene) {
		this.strCartonGene = strCartonGene;
	}

	public String getStrBarCodeString() {
		return strBarCodeString;
	}

	public void setStrBarCodeString(String strBarCodeString) {
		this.strBarCodeString = strBarCodeString;
	}

	public String getStrRateContQty() {
		return strRateContQty;
	}

	public void setStrRateContQty(String strRateContQty) {
		this.strRateContQty = strRateContQty;
	}

	public String getStrTotalBalanceQty() {
		return strTotalBalanceQty;
	}

	public void setStrTotalBalanceQty(String strTotalBalanceQty) {
		this.strTotalBalanceQty = strTotalBalanceQty;
	}

	public String getStrItemNameNew() {
		return strItemNameNew;
	}

	public void setStrItemNameNew(String strItemNameNew) {
		this.strItemNameNew = strItemNameNew;
	}

	public String getStrReplacementBatchFlag() {
		return strReplacementBatchFlag;
	}

	public void setStrReplacementBatchFlag(String strReplacementBatchFlag) {
		this.strReplacementBatchFlag = strReplacementBatchFlag;
	}

	public String getStrLefttBatchList() {
		return strLefttBatchList;
	}

	public void setStrLefttBatchList(String strLefttBatchList) {
		this.strLefttBatchList = strLefttBatchList;
	}

	public String getStrRightBatchList() {
		return strRightBatchList;
	}

	public void setStrRightBatchList(String strRightBatchList) {
		this.strRightBatchList = strRightBatchList;
	}

	public String getStrReplacementDirectBatchFlag() {
		return strReplacementDirectBatchFlag;
	}

	public void setStrReplacementDirectBatchFlag(
			String strReplacementDirectBatchFlag) {
		this.strReplacementDirectBatchFlag = strReplacementDirectBatchFlag;
	}

	public String getStrLeftBatchNos() {
		return strLeftBatchNos;
	}

	public void setStrLeftBatchNos(String strLeftBatchNos) {
		this.strLeftBatchNos = strLeftBatchNos;
	}

	public String getStrRightBatchNos() {
		return strRightBatchNos;
	}

	public void setStrRightBatchNos(String strRightBatchNos) {
		this.strRightBatchNos = strRightBatchNos;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrPrevInvoiceExists() {
		return strPrevInvoiceExists;
	}

	public void setStrPrevInvoiceExists(String strPrevInvoiceExists) {
		this.strPrevInvoiceExists = strPrevInvoiceExists;
	}

	public String getStrDDeliveryDays5() {
		return strDDeliveryDays5;
	}

	public void setStrDDeliveryDays5(String strDDeliveryDays5) {
		this.strDDeliveryDays5 = strDDeliveryDays5;
	}

	public String getStrDDeliveryDays6() {
		return strDDeliveryDays6;
	}

	public void setStrDDeliveryDays6(String strDDeliveryDays6) {
		this.strDDeliveryDays6 = strDDeliveryDays6;
	}

	public String getStrDDeliveryDays7() {
		return strDDeliveryDays7;
	}

	public void setStrDDeliveryDays7(String strDDeliveryDays7) {
		this.strDDeliveryDays7 = strDDeliveryDays7;
	}

	public String getStrDDeliveryDays8() {
		return strDDeliveryDays8;
	}

	public void setStrDDeliveryDays8(String strDDeliveryDays8) {
		this.strDDeliveryDays8 = strDDeliveryDays8;
	}

	public String getStrBatchExdateFlag() {
		return strBatchExdateFlag;
	}

	public void setStrBatchExdateFlag(String strBatchExdateFlag) {
		this.strBatchExdateFlag = strBatchExdateFlag;
	}

	public String getStrNewTranche() {
		return strNewTranche;
	}

	public void setStrNewTranche(String strNewTranche) {
		this.strNewTranche = strNewTranche;
	}

	public String getStrNewPdiFlag() {
		return strNewPdiFlag;
	}

	public void setStrNewPdiFlag(String strNewPdiFlag) {
		this.strNewPdiFlag = strNewPdiFlag;
	}
	

}
