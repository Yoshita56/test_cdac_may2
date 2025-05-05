/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransVO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.vo;

import java.util.List;

import hisglobal.utility.TransferObject;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.upload.FormFile;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransVO.
 */
public class SupplierDeskInterfaceTransVO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The str msg type. */
	private String strMsgType = "";

	/** The str err. */
	private String strBatchNo ="";
	private WebRowSet strBatchNoWs=null;
	private WebRowSet wsBatchList = null;
	private String strReplacementBatchFlag = "0";
	private String strErr = "";
	private String strPreInvoiceNo="";
	
	private String strBatchExdateFlag="";
	private String strNewTranche = "";
	private String strNewPdiFlag = "";
	
	private String strPrgId="";
	private String strPoPreFlag = "";
	private String strFSId="";
	private String strPrgName="";	
	private String strItemNameNew="";
	private String strFSName="";
	private WebRowSet cartonSizeWs = null;
	private String strCartonSizeCmb ="";
	private String strBatchNoCmb ="";
	/** The str warning. */
	private String strWarning = "";
	private String strDeliveryNo="";
	private String strDeleteRemarks="";
    private String[] strHiddenValue = null;
    private String[] strPrgDtl = null;
    private String[] strCheckHidValue= null;
	private String strRejectedBatchList=null;
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
	private String strSupplierInvoiceNo="";
	  private String strCartonGene ="";
	  private String strBarCodeString="";
	/** The str location. */
	private FormFile strLocation = null;

	/** The str file no. */
	private String strFileNo = "";

	/** The str page no. */
	private String strPageNo = "";

	/** The str file name. */
	private String strFileName = "";
	private String strLefttBatchList="";
	private String strRightBatchList="";
	private String strReplacementDirectBatchFlag="";


	/** The str msg string. */
	private String strApprovalFlag="";
	private String strMsgString = "";
	private String strBatchCombo="";
	private String strDrugNameCombo="";
	private String strUnitId="0";
	private String strUnitCmbValue="";

	private String strConsigneeStoreCombo="";
	private String strManufacturerName = "";
	private String strConsigneeStore = "";
	private String strScheduleNo="0";
	private String strSupplierReceiptNo="";
	private String strSupplierReceiptDate="";
	private String strDrugShelfLife="";
	private String strPreviousDeliveryDtls="";
	private String strNoOfPackets= "";

	private String strPackageWeight= "";

	private String strDeliveryMode= "";

	private String strDeliveryModeValues= "";


	private String strDeliveryModeText= "";


	private String strTransporterName= "";


	private String strLorryNo= "";

	private String strExpectedDelDate= "";
	private String strExpectedDeliveryDays= "";
	private String strDeliveryStoreId="0";
	private String strDrugBrandId="0";
	
	private WebRowSet wsUnitList =null;
	private WebRowSet wsItemList=null;
	
	/** The str msg. */
	private String strMsg = "";
	
	private String strDistrictStoreId="";

	/** The str to store. */
	private String strToStore = "";

	/** The str to store values. */
	private String strToStoreValues = "";

	private String strTableWidth = "";
	/** The str item cat. */
	private String strItemCat = "";

	/** The str item cat values. */
	private String strItemCatValues = "";

	/** The str agenda period. */
	private String strAgendaPeriod = "";

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str store id. */
	private String strStoreId = "";
	
	private String strQrStoreId = "";
	private String strQrItemId = "";
	private String strQrSupplierId = "";
	private String strQrPono = "";
	private String strSchno = "";
	private String strDelno = "";

	/** The str item cat no. */
	private String strItemCatNo = "";
	
	private String strDwhTypeId = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	private String strPOStoreId = "";

	/** The str agenda no. */
	private String strAgendaNo = "";

	/** The str to store id. */
	private String strToStoreId = "";

	/** The str agenda date. */
	private String strAgendaDate = "";

	/** The str agenda status. */
	private String strAgendaStatus = "";

	/** The str financial start date. */
	private String strFinancialStartDate = "";

	/** The str financial to date. */
	private String strFinancialToDate = "";

	/** The str check box. */
	private String[] strCheckBox = null;

	/** The str indent no. */
	private String strIndentNo = "";

	/** The str grant type values. */
	private String strGrantTypeValues = "";

	/** The str grant type id. */
	private String strGrantTypeId = "";

	/** The str item id. */
	private String strItemId = "";

	/** The str item popup data. */
	private String strItemPopupData = "";

	/** The str rate unit values. */
	private String strRateUnitValues = "";

	/** The str inventory unit id. */
	private String strInventoryUnitId = "";

	/** The str po type values. */
	private String strPOTypeValues = "";

	/** The str po type id. */
	private String strPOTypeId = "";

	/** The str supplier values. */
	private String strSupplierValues = "";

	/** The str supplier id. */
	private String strSupplierId = "";

	/** The str new supplier id. */
	private String strNewSupplierId = "";

	/** The str contract type. */
	private String strContractType = "";

	/** The str request id. */
	private String strRequestId = "";

	/** The str rate unit id. */
	private String strRateUnitId = "";

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

	/** The str verified date. */
	private String strVerifiedDate = "";

	/** The str verified by. */
	private String strVerifiedBy = "";

	/** The str demand year. */
	private String strDemandYear;

	/** The wb po delivery location mob no. */
	private WebRowSet wbPODeliveryLocationMobNo = null;
	
	
	private WebRowSet WbApprovedBy = null;

	/** The wb ddw combo. */
	private WebRowSet wbDdwCombo = null;

	/** The wb request detail. */
	private WebRowSet wbRequestDetail = null;

	/** The wb request item detail. */
	private WebRowSet wbRequestItemDetail = null;

	/** The wb component detail. */
	private WebRowSet wbComponentDetail = null;

	/** The wb approved by. */
	private WebRowSet wbDeliveryMode = null;
	
	private WebRowSet wsStoreList = null;

	/** The wbs store name combo. */
	private WebRowSet wbsStoreNameCombo = null;

	/** The wbs req list po. */
	private WebRowSet wbsReqListPO = null;

	/** The wbs programme dtl. */
	private WebRowSet wbsProgrammeDtl = null;

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

	/** The str d order qty. */
	private String[] strDOrderQty = null;

	/** The str d order qty unit id. */
	private String[] strDOrderQtyUnitId = null;

	/** The str dcr no. */
	private String[] strDCRNo = null;

	/** The str tmp req no. */
	private String[] strTmpReqNo = null;

	/** The str tmp raising store. */
	private String[] strTmpRaisingStore = null;

	/** The str make. */
	private String[] strMake = null;

	/** The str store ids. */
	private String strStoreIds = "";

	/** The str request ids. */
	private String strRequestIds = "";

	/** The str item ids. */
	private String strItemIds = "";

	/** The str item brand ids. */
	private String strItemBrandIds = "0";

	/** The str d component value. */
	private String[] strDComponentValue = null;

	/** The str d component id. */
	private String[] strDComponentId = null;

	/** The str tmp bal qty. */
	private String[] strTmpBalQty = null;

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

	/** The str po grant type. */
	private String strPOGrantType = "";

	/** The str match unit cmb. */
	private String strMatchUnitCmb;

	/** The str po refrence no. */
	private String strPoRefrenceNo;

	/** The str is foreign flg. */
	private String strIsForeignFlg;

	/** The str cal delivery date. */
	private String strCalDeliveryDate;

	/** The str date piker flag. */
	private String strDatePikerFlag;

	/** The str po refrence date. */
	private String strPORefrenceDate;

	/** The str d delivery days. */
	private String strDDeliveryDays;

	/** The str total po cost. */
	private String strTotalPOCost;

	/** The str hlp size. */
	private int strHlpSize;

	/** The str po item cmb. */
	private String strPOItemCmb;

	/** The str po item id. */
	private String strPOItemID;

	/** The str indent period value. */
	private String strIndentPeriodValue;

	/** The str rate tax. */
	private String strRateTax;

	/** The str combo po type id. */
	private String strComboPOTypeId;

	/** The str item rate. */
	private String strItemRate;

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

	/** The str item make. */
	private String strItemMake;

	/** The str item rate tax. */
	private String strItemRateTax;

	/** The str item manufacturer id. */
	private String strItemManufacturerId;

	/** The str po financial dtl. */
	private String strPOFinancialDtl;

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

	/** The str item cat name. */
	private String strItemCatName;

	/** The str po item details. */
	private String strPOItemDetails;

	/** The str po hidden value. */
	private String strPOHiddenValue;

	/** The str modify flg. */
	private String strModifyFlg;

	/** The str purchase source id. */
	private String strPurchaseSourceId;

	/** The str verify by id. */
	private String strVerifyById;

	/** The str mode. */
	private String strMode;

	/** The str po refrence no cmb. */
	private String strPoRefrenceNoCmb;

	/** The str mobile no list. */
	private String strMobileNoList = "0";

	/** The str mobile msg. */
	private String strMobileMsg;

	/** The str mobile msg mode. */
	private String strMobileMsgMode;

	/** The str mobile user name. */
	private String strMobileUserName = "0";

	/** The str mobile pwd. */
	private String strMobilePwd;

	/** The str mobile sender id. */
	private String strMobileSenderId;

	/** The str manufacturer id. */
	private String strManufacturerId = "";

	/** The str purchase committe meeting date. */
	private String strPurchaseCommitteMeetingDate;

	/** The str next po date. */
	private String strNextPoDate;

	/** The str financial year combo. */
	private String strFinancialYearCombo;

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

	/** The str pass value. */
	private String strPassValue = "";
	
	private String strViewMode="0";
	
	private WebRowSet strHeaderWS = null;
	
	private WebRowSet strDrugListWS = null;
	
	private String strDriverName="";
	private String strDriverMobileNo="";
	private String strDateOfDelivery="";
	
	private WebRowSet wbSupplierInterfaceListDtl = null;
	private String orderdqty = "";
	private String balanceqty = "";
	private String prefixpono = "";
	private String status = "";
	private WebRowSet wsSupplierInterfaceRptList = null;
	
	
	
	
	
	
	


	/**
	 * @return the wsSupplierInterfaceRptList
	 */
	public WebRowSet getWsSupplierInterfaceRptList() {
		return wsSupplierInterfaceRptList;
	}

	/**
	 * @param wsSupplierInterfaceRptList the wsSupplierInterfaceRptList to set
	 */
	public void setWsSupplierInterfaceRptList(WebRowSet wsSupplierInterfaceRptList) {
		this.wsSupplierInterfaceRptList = wsSupplierInterfaceRptList;
	}

	/**
	 * @return the orderdqty
	 */
	public String getOrderdqty() {
		return orderdqty;
	}

	/**
	 * @param orderdqty the orderdqty to set
	 */
	public void setOrderdqty(String orderdqty) {
		this.orderdqty = orderdqty;
	}

	/**
	 * @return the balanceqty
	 */
	public String getBalanceqty() {
		return balanceqty;
	}

	/**
	 * @param balanceqty the balanceqty to set
	 */
	public void setBalanceqty(String balanceqty) {
		this.balanceqty = balanceqty;
	}

	/**
	 * @return the prefixpono
	 */
	public String getPrefixpono() {
		return prefixpono;
	}

	/**
	 * @param prefixpono the prefixpono to set
	 */
	public void setPrefixpono(String prefixpono) {
		this.prefixpono = prefixpono;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the wbSupplierInterfaceListDtl
	 */
	public WebRowSet getWbSupplierInterfaceListDtl() {
		return wbSupplierInterfaceListDtl;
	}

	/**
	 * @param wbSupplierInterfaceListDtl the wbSupplierInterfaceListDtl to set
	 */
	public void setWbSupplierInterfaceListDtl(WebRowSet wbSupplierInterfaceListDtl) {
		this.wbSupplierInterfaceListDtl = wbSupplierInterfaceListDtl;
	}

	private String strDateOfDispatch="";
			
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

	public String getStrViewMode() {
		return strViewMode;
	}

	public void setStrViewMode(String strViewMode) {
		this.strViewMode = strViewMode;
	}

	/**
	 * Gets the str pass value.
	 * 
	 * @return the str pass value
	 */
	public String getStrPassValue() {
		return strPassValue;
	}

	/**
	 * Sets the str pass value.
	 * 
	 * @param strPassValue
	 *            the new str pass value
	 */
	public void setStrPassValue(String strPassValue) {
		this.strPassValue = strPassValue;
	}

	/**
	 * Gets the str d delivery days2.
	 * 
	 * @return the str d delivery days2
	 */
	public String getStrDDeliveryDays2() {
		return strDDeliveryDays2;
	}

	/**
	 * Sets the str d delivery days2.
	 * 
	 * @param strDDeliveryDays2
	 *            the new str d delivery days2
	 */
	public void setStrDDeliveryDays2(String strDDeliveryDays2) {
		this.strDDeliveryDays2 = strDDeliveryDays2;
	}

	/**
	 * Gets the str d delivery days3.
	 * 
	 * @return the str d delivery days3
	 */
	public String getStrDDeliveryDays3() {
		return strDDeliveryDays3;
	}

	/**
	 * Sets the str d delivery days3.
	 * 
	 * @param strDDeliveryDays3
	 *            the new str d delivery days3
	 */
	public void setStrDDeliveryDays3(String strDDeliveryDays3) {
		this.strDDeliveryDays3 = strDDeliveryDays3;
	}

	/**
	 * Gets the str d delivery days4.
	 * 
	 * @return the str d delivery days4
	 */
	public String getStrDDeliveryDays4() {
		return strDDeliveryDays4;
	}

	/**
	 * Sets the str d delivery days4.
	 * 
	 * @param strDDeliveryDays4
	 *            the new str d delivery days4
	 */
	public void setStrDDeliveryDays4(String strDDeliveryDays4) {
		this.strDDeliveryDays4 = strDDeliveryDays4;
	}

	/**
	 * Gets the str po multi refrence no.
	 * 
	 * @return the str po multi refrence no
	 */
	public String getStrPoMultiRefrenceNo() {
		return strPoMultiRefrenceNo;
	}

	/**
	 * Sets the str po multi refrence no.
	 * 
	 * @param strPoMultiRefrenceNo
	 *            the new str po multi refrence no
	 */
	public void setStrPoMultiRefrenceNo(String strPoMultiRefrenceNo) {
		this.strPoMultiRefrenceNo = strPoMultiRefrenceNo;
	}

	/**
	 * Gets the str po auth type id.
	 * 
	 * @return the str po auth type id
	 */
	public String getStrPOAuthTypeId() {
		return strPOAuthTypeId;
	}

	/**
	 * Sets the str po auth type id.
	 * 
	 * @param strPOAuthTypeId
	 *            the new str po auth type id
	 */
	public void setStrPOAuthTypeId(String strPOAuthTypeId) {
		this.strPOAuthTypeId = strPOAuthTypeId;
	}

	/**
	 * Gets the str po refrence no text.
	 * 
	 * @return the str po refrence no text
	 */
	public String getStrPoRefrenceNoText() {
		return strPoRefrenceNoText;
	}

	/**
	 * Sets the str po refrence no text.
	 * 
	 * @param strPoRefrenceNoText
	 *            the new str po refrence no text
	 */
	public void setStrPoRefrenceNoText(String strPoRefrenceNoText) {
		this.strPoRefrenceNoText = strPoRefrenceNoText;
	}

	/**
	 * Gets the str financial year combo.
	 * 
	 * @return the str financial year combo
	 */
	public String getStrFinancialYearCombo() {
		return strFinancialYearCombo;
	}

	/**
	 * Sets the str financial year combo.
	 * 
	 * @param strFinancialYearCombo
	 *            the new str financial year combo
	 */
	public void setStrFinancialYearCombo(String strFinancialYearCombo) {
		this.strFinancialYearCombo = strFinancialYearCombo;
	}

	/**
	 * Gets the str next po date.
	 * 
	 * @return the str next po date
	 */
	public String getStrNextPoDate() {
		return strNextPoDate;
	}

	/**
	 * Sets the str next po date.
	 * 
	 * @param strNextPoDate
	 *            the new str next po date
	 */
	public void setStrNextPoDate(String strNextPoDate) {
		this.strNextPoDate = strNextPoDate;
	}

	/**
	 * Gets the str mobile no list.
	 * 
	 * @return the str mobile no list
	 */
	public String getStrMobileNoList() {
		return strMobileNoList;
	}

	/**
	 * Sets the str mobile no list.
	 * 
	 * @param strMobileNoList
	 *            the new str mobile no list
	 */
	public void setStrMobileNoList(String strMobileNoList) {
		this.strMobileNoList = strMobileNoList;
	}

	/**
	 * Gets the str mobile msg.
	 * 
	 * @return the str mobile msg
	 */
	public String getStrMobileMsg() {
		return strMobileMsg;
	}

	/**
	 * Sets the str mobile msg.
	 * 
	 * @param strMobileMsg
	 *            the new str mobile msg
	 */
	public void setStrMobileMsg(String strMobileMsg) {
		this.strMobileMsg = strMobileMsg;
	}

	/**
	 * Gets the str po refrence no cmb.
	 * 
	 * @return the str po refrence no cmb
	 */
	public String getStrPoRefrenceNoCmb() {
		return strPoRefrenceNoCmb;
	}

	/**
	 * Sets the str po refrence no cmb.
	 * 
	 * @param strPoRefrenceNoCmb
	 *            the new str po refrence no cmb
	 */
	public void setStrPoRefrenceNoCmb(String strPoRefrenceNoCmb) {
		this.strPoRefrenceNoCmb = strPoRefrenceNoCmb;
	}

	/**
	 * Gets the str mode.
	 * 
	 * @return the str mode
	 */
	public String getStrMode() {
		return strMode;
	}

	/**
	 * Sets the str mode.
	 * 
	 * @param strMode
	 *            the new str mode
	 */
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	/**
	 * Gets the str verify by id.
	 * 
	 * @return the str verify by id
	 */
	public String getStrVerifyById() {
		return strVerifyById;
	}

	/**
	 * Sets the str verify by id.
	 * 
	 * @param strVerifyById
	 *            the new str verify by id
	 */
	public void setStrVerifyById(String strVerifyById) {
		this.strVerifyById = strVerifyById;
	}

	/**
	 * Gets the str purchase source id.
	 * 
	 * @return the str purchase source id
	 */
	public String getStrPurchaseSourceId() {
		return strPurchaseSourceId;
	}

	/**
	 * Sets the str purchase source id.
	 * 
	 * @param strPurchaseSourceId
	 *            the new str purchase source id
	 */
	public void setStrPurchaseSourceId(String strPurchaseSourceId) {
		this.strPurchaseSourceId = strPurchaseSourceId;
	}

	/**
	 * Gets the str modify flg.
	 * 
	 * @return the str modify flg
	 */
	public String getStrModifyFlg() {
		return strModifyFlg;
	}

	/**
	 * Sets the str modify flg.
	 * 
	 * @param strModifyFlg
	 *            the new str modify flg
	 */
	public void setStrModifyFlg(String strModifyFlg) {
		this.strModifyFlg = strModifyFlg;
	}

	/** The str store name. */
	private String strStoreName;

	/**
	 * Gets the str store name.
	 * 
	 * @return the str store name
	 */
	public String getStrStoreName() {
		return strStoreName;
	}

	/**
	 * Sets the str store name.
	 * 
	 * @param strStoreName
	 *            the new str store name
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}

	/**
	 * Gets the str po item details.
	 * 
	 * @return the str po item details
	 */
	public String getStrPOItemDetails() {
		return strPOItemDetails;
	}

	/**
	 * Sets the str po item details.
	 * 
	 * @param strPOItemDetails
	 *            the new str po item details
	 */
	public void setStrPOItemDetails(String strPOItemDetails) {
		this.strPOItemDetails = strPOItemDetails;
	}

	/**
	 * Gets the str po no.
	 * 
	 * @return the str po no
	 */
	public String getStrPONo() {
		return strPONo;
	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPONo
	 *            the new str po no
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}

	/**
	 * Gets the str po details hid value.
	 * 
	 * @return the str po details hid value
	 */
	public String[] getStrPODetailsHidValue() {
		return strPODetailsHidValue;
	}

	/**
	 * Sets the str po details hid value.
	 * 
	 * @param strPODetailsHidValue
	 *            the new str po details hid value
	 */
	public void setStrPODetailsHidValue(String[] strPODetailsHidValue) {
		this.strPODetailsHidValue = strPODetailsHidValue;
	}

	/**
	 * Gets the str item rate unit id.
	 * 
	 * @return the str item rate unit id
	 */
	public String getStrItemRateUnitId() {
		return strItemRateUnitId;
	}

	/**
	 * Sets the str item rate unit id.
	 * 
	 * @param strItemRateUnitId
	 *            the new str item rate unit id
	 */
	public void setStrItemRateUnitId(String strItemRateUnitId) {
		this.strItemRateUnitId = strItemRateUnitId;
	}

	/**
	 * Gets the str po financial dtl.
	 * 
	 * @return the str po financial dtl
	 */
	public String getStrPOFinancialDtl() {
		return strPOFinancialDtl;
	}

	/**
	 * Sets the str po financial dtl.
	 * 
	 * @param strPOFinancialDtl
	 *            the new str po financial dtl
	 */
	public void setStrPOFinancialDtl(String strPOFinancialDtl) {
		this.strPOFinancialDtl = strPOFinancialDtl;
	}

	/**
	 * Gets the str item manufacturer id.
	 * 
	 * @return the str item manufacturer id
	 */
	public String getStrItemManufacturerId() {
		return strItemManufacturerId;
	}

	/**
	 * Sets the str item manufacturer id.
	 * 
	 * @param strItemManufacturerId
	 *            the new str item manufacturer id
	 */
	public void setStrItemManufacturerId(String strItemManufacturerId) {
		this.strItemManufacturerId = strItemManufacturerId;
	}

	/**
	 * Gets the str item rate tax.
	 * 
	 * @return the str item rate tax
	 */
	public String getStrItemRateTax() {
		return strItemRateTax;
	}

	/**
	 * Sets the str item rate tax.
	 * 
	 * @param strItemRateTax
	 *            the new str item rate tax
	 */
	public void setStrItemRateTax(String strItemRateTax) {
		this.strItemRateTax = strItemRateTax;
	}

	/**
	 * Gets the str item make.
	 * 
	 * @return the str item make
	 */
	public String getStrItemMake() {
		return strItemMake;
	}

	/**
	 * Sets the str item make.
	 * 
	 * @param strItemMake
	 *            the new str item make
	 */
	public void setStrItemMake(String strItemMake) {
		this.strItemMake = strItemMake;
	}

	/**
	 * Gets the str qrder qty.
	 * 
	 * @return the str qrder qty
	 */
	public String[] getStrQrderQty() {
		return strQrderQty;
	}

	/**
	 * Sets the str qrder qty.
	 * 
	 * @param strQrderQty
	 *            the new str qrder qty
	 */
	public void setStrQrderQty(String[] strQrderQty) {
		this.strQrderQty = strQrderQty;
	}

	/**
	 * Gets the str orde cost.
	 * 
	 * @return the str orde cost
	 */
	public String[] getStrOrdeCost() {
		return strOrdeCost;
	}

	/**
	 * Sets the str orde cost.
	 * 
	 * @param strOrdeCost
	 *            the new str orde cost
	 */
	public void setStrOrdeCost(String[] strOrdeCost) {
		this.strOrdeCost = strOrdeCost;
	}

	/**
	 * Gets the str item rate.
	 * 
	 * @return the str item rate
	 */
	public String getStrItemRate() {
		return strItemRate;
	}

	/**
	 * Sets the str item rate.
	 * 
	 * @param strItemRate
	 *            the new str item rate
	 */
	public void setStrItemRate(String strItemRate) {
		this.strItemRate = strItemRate;
	}

	/**
	 * Gets the str combo po type id.
	 * 
	 * @return the str combo po type id
	 */
	public String getStrComboPOTypeId() {
		return strComboPOTypeId;
	}

	/**
	 * Sets the str combo po type id.
	 * 
	 * @param strComboPOTypeId
	 *            the new str combo po type id
	 */
	public void setStrComboPOTypeId(String strComboPOTypeId) {
		this.strComboPOTypeId = strComboPOTypeId;
	}

	/**
	 * Gets the str rate tax.
	 * 
	 * @return the str rate tax
	 */
	public String getStrRateTax() {
		return strRateTax;
	}

	/**
	 * Sets the str rate tax.
	 * 
	 * @param strRateTax
	 *            the new str rate tax
	 */
	public void setStrRateTax(String strRateTax) {
		this.strRateTax = strRateTax;
	}

	/**
	 * Gets the str indent period value.
	 * 
	 * @return the str indent period value
	 */
	public String getStrIndentPeriodValue() {
		return strIndentPeriodValue;
	}

	/**
	 * Sets the str indent period value.
	 * 
	 * @param strIndentPeriodValue
	 *            the new str indent period value
	 */
	public void setStrIndentPeriodValue(String strIndentPeriodValue) {
		this.strIndentPeriodValue = strIndentPeriodValue;
	}

	/**
	 * Gets the str po item cmb.
	 * 
	 * @return the str po item cmb
	 */
	public String getStrPOItemCmb() {
		return strPOItemCmb;
	}

	/**
	 * Sets the str po item cmb.
	 * 
	 * @param strPOItemCmb
	 *            the new str po item cmb
	 */
	public void setStrPOItemCmb(String strPOItemCmb) {
		this.strPOItemCmb = strPOItemCmb;
	}

	/**
	 * Gets the str po item id.
	 * 
	 * @return the str po item id
	 */
	public String getStrPOItemID() {
		return strPOItemID;
	}

	/**
	 * Sets the str po item id.
	 * 
	 * @param strPOItemID
	 *            the new str po item id
	 */
	public void setStrPOItemID(String strPOItemID) {
		this.strPOItemID = strPOItemID;
	}

	/**
	 * Gets the str total po cost.
	 * 
	 * @return the str total po cost
	 */
	public String getStrTotalPOCost() {
		return strTotalPOCost;
	}

	/**
	 * Sets the str total po cost.
	 * 
	 * @param strTotalPOCost
	 *            the new str total po cost
	 */
	public void setStrTotalPOCost(String strTotalPOCost) {
		this.strTotalPOCost = strTotalPOCost;
	}

	/**
	 * Gets the str po refrence date.
	 * 
	 * @return the str po refrence date
	 */
	public String getStrPORefrenceDate() {
		return strPORefrenceDate;
	}

	/**
	 * Sets the str po refrence date.
	 * 
	 * @param strPORefrenceDate
	 *            the new str po refrence date
	 */
	public void setStrPORefrenceDate(String strPORefrenceDate) {
		this.strPORefrenceDate = strPORefrenceDate;
	}

	/**
	 * Gets the str date piker flag.
	 * 
	 * @return the str date piker flag
	 */
	public String getStrDatePikerFlag() {
		return strDatePikerFlag;
	}

	/**
	 * Sets the str date piker flag.
	 * 
	 * @param strDatePikerFlag
	 *            the new str date piker flag
	 */
	public void setStrDatePikerFlag(String strDatePikerFlag) {
		this.strDatePikerFlag = strDatePikerFlag;
	}

	/**
	 * Gets the str cal delivery date.
	 * 
	 * @return the str cal delivery date
	 */
	public String getStrCalDeliveryDate() {
		return strCalDeliveryDate;
	}

	/**
	 * Sets the str cal delivery date.
	 * 
	 * @param strCalDeliveryDate
	 *            the new str cal delivery date
	 */
	public void setStrCalDeliveryDate(String strCalDeliveryDate) {
		this.strCalDeliveryDate = strCalDeliveryDate;
	}

	/**
	 * Gets the str is foreign flg.
	 * 
	 * @return the str is foreign flg
	 */
	public String getStrIsForeignFlg() {
		return strIsForeignFlg;
	}

	/**
	 * Sets the str is foreign flg.
	 * 
	 * @param strIsForeignFlg
	 *            the new str is foreign flg
	 */
	public void setStrIsForeignFlg(String strIsForeignFlg) {
		this.strIsForeignFlg = strIsForeignFlg;
	}

	/**
	 * Gets the str po refrence no.
	 * 
	 * @return the str po refrence no
	 */
	public String getStrPoRefrenceNo() {
		return strPoRefrenceNo;
	}

	/**
	 * Sets the str po refrence no.
	 * 
	 * @param strPoRefrenceNo
	 *            the new str po refrence no
	 */
	public void setStrPoRefrenceNo(String strPoRefrenceNo) {
		this.strPoRefrenceNo = strPoRefrenceNo;
	}

	/**
	 * Gets the str match unit cmb.
	 * 
	 * @return the str match unit cmb
	 */
	public String getStrMatchUnitCmb() {
		return strMatchUnitCmb;
	}

	/**
	 * Sets the str match unit cmb.
	 * 
	 * @param strMatchUnitCmb
	 *            the new str match unit cmb
	 */
	public void setStrMatchUnitCmb(String strMatchUnitCmb) {
		this.strMatchUnitCmb = strMatchUnitCmb;
	}

	/**
	 * Gets the str tmp req no.
	 * 
	 * @return the strTmpReqNo
	 */
	public String[] getStrTmpReqNo() {
		return strTmpReqNo;
	}

	/**
	 * Sets the str tmp req no.
	 * 
	 * @param strTmpReqNo
	 *            the strTmpReqNo to set
	 */
	public void setStrTmpReqNo(String[] strTmpReqNo) {
		this.strTmpReqNo = strTmpReqNo;
	}

	/**
	 * Gets the str tmp raising store.
	 * 
	 * @return the strTmpRaisingStore
	 */
	public String[] getStrTmpRaisingStore() {
		return strTmpRaisingStore;
	}

	/**
	 * Sets the str tmp raising store.
	 * 
	 * @param strTmpRaisingStore
	 *            the strTmpRaisingStore to set
	 */
	public void setStrTmpRaisingStore(String[] strTmpRaisingStore) {
		this.strTmpRaisingStore = strTmpRaisingStore;
	}

	/**
	 * Gets the str po grant type.
	 * 
	 * @return the strPOGrantType
	 */
	public String getStrPOGrantType() {
		return strPOGrantType;
	}

	/**
	 * Sets the str po grant type.
	 * 
	 * @param strPOGrantType
	 *            the strPOGrantType to set
	 */
	public void setStrPOGrantType(String strPOGrantType) {
		this.strPOGrantType = strPOGrantType;
	}

	/**
	 * Gets the str d net amount.
	 * 
	 * @return the strDNetAmount
	 */
	public String getStrDNetAmount() {
		return strDNetAmount;
	}

	/**
	 * Sets the str d net amount.
	 * 
	 * @param strDNetAmount
	 *            the strDNetAmount to set
	 */
	public void setStrDNetAmount(String strDNetAmount) {
		this.strDNetAmount = strDNetAmount;
	}

	/**
	 * Gets the str dcr no.
	 * 
	 * @return the strDCRNo
	 */
	public String[] getStrDCRNo() {
		return strDCRNo;
	}

	/**
	 * Sets the str dcr no.
	 * 
	 * @param strDCRNo
	 *            the strDCRNo to set
	 */
	public void setStrDCRNo(String[] strDCRNo) {
		this.strDCRNo = strDCRNo;
	}

	/**
	 * Gets the str d order qty.
	 * 
	 * @return the strDOrderQty
	 */
	public String[] getStrDOrderQty() {
		return strDOrderQty;
	}

	/**
	 * Sets the str d order qty.
	 * 
	 * @param strDOrderQty
	 *            the strDOrderQty to set
	 */
	public void setStrDOrderQty(String[] strDOrderQty) {
		this.strDOrderQty = strDOrderQty;
	}

	/**
	 * Gets the str d order qty unit id.
	 * 
	 * @return the strDOrderQtyUnitId
	 */
	public String[] getStrDOrderQtyUnitId() {
		return strDOrderQtyUnitId;
	}

	/**
	 * Sets the str d order qty unit id.
	 * 
	 * @param strDOrderQtyUnitId
	 *            the strDOrderQtyUnitId to set
	 */
	public void setStrDOrderQtyUnitId(String[] strDOrderQtyUnitId) {
		this.strDOrderQtyUnitId = strDOrderQtyUnitId;
	}

	/**
	 * Gets the str d delivery date.
	 * 
	 * @return the strDDeliveryDate
	 */
	public String getStrDDeliveryDate() {
		return strDDeliveryDate;
	}

	/**
	 * Sets the str d delivery date.
	 * 
	 * @param strDDeliveryDate
	 *            the strDDeliveryDate to set
	 */
	public void setStrDDeliveryDate(String strDDeliveryDate) {
		this.strDDeliveryDate = strDDeliveryDate;
	}

	/**
	 * Gets the str d demurrage by.
	 * 
	 * @return the strDDemurrageBy
	 */
	public String getStrDDemurrageBy() {
		return strDDemurrageBy;
	}

	/**
	 * Sets the str d demurrage by.
	 * 
	 * @param strDDemurrageBy
	 *            the strDDemurrageBy to set
	 */
	public void setStrDDemurrageBy(String strDDemurrageBy) {
		this.strDDemurrageBy = strDDemurrageBy;
	}

	/**
	 * Gets the str d agent name.
	 * 
	 * @return the strDAgentName
	 */
	public String getStrDAgentName() {
		return strDAgentName;
	}

	/**
	 * Sets the str d agent name.
	 * 
	 * @param strDAgentName
	 *            the strDAgentName to set
	 */
	public void setStrDAgentName(String strDAgentName) {
		this.strDAgentName = strDAgentName;
	}

	/**
	 * Gets the str dca name.
	 * 
	 * @return the strDCAName
	 */
	public String getStrDCAName() {
		return strDCAName;
	}

	/**
	 * Sets the str dca name.
	 * 
	 * @param strDCAName
	 *            the strDCAName to set
	 */
	public void setStrDCAName(String strDCAName) {
		this.strDCAName = strDCAName;
	}

	/**
	 * Gets the str diac charge.
	 * 
	 * @return the strDIACCharge
	 */
	public String getStrDIACCharge() {
		return strDIACCharge;
	}

	/**
	 * Sets the str diac charge.
	 * 
	 * @param strDIACCharge
	 *            the strDIACCharge to set
	 */
	public void setStrDIACCharge(String strDIACCharge) {
		this.strDIACCharge = strDIACCharge;
	}

	/**
	 * Gets the str d insurance charge.
	 * 
	 * @return the strDInsuranceCharge
	 */
	public String getStrDInsuranceCharge() {
		return strDInsuranceCharge;
	}

	/**
	 * Sets the str d insurance charge.
	 * 
	 * @param strDInsuranceCharge
	 *            the strDInsuranceCharge to set
	 */
	public void setStrDInsuranceCharge(String strDInsuranceCharge) {
		this.strDInsuranceCharge = strDInsuranceCharge;
	}

	/**
	 * Gets the str d currency name.
	 * 
	 * @return the strDCurrencyName
	 */
	public String getStrDCurrencyName() {
		return strDCurrencyName;
	}

	/**
	 * Sets the str d currency name.
	 * 
	 * @param strDCurrencyName
	 *            the strDCurrencyName to set
	 */
	public void setStrDCurrencyName(String strDCurrencyName) {
		this.strDCurrencyName = strDCurrencyName;
	}

	/**
	 * Gets the str d currency value.
	 * 
	 * @return the strDCurrencyValue
	 */
	public String getStrDCurrencyValue() {
		return strDCurrencyValue;
	}

	/**
	 * Sets the str d currency value.
	 * 
	 * @param strDCurrencyValue
	 *            the strDCurrencyValue to set
	 */
	public void setStrDCurrencyValue(String strDCurrencyValue) {
		this.strDCurrencyValue = strDCurrencyValue;
	}

	/**
	 * Gets the str d component value.
	 * 
	 * @return the strDComponentValue
	 */
	public String[] getStrDComponentValue() {
		return strDComponentValue;
	}

	/**
	 * Sets the str d component value.
	 * 
	 * @param strDComponentValue
	 *            the strDComponentValue to set
	 */
	public void setStrDComponentValue(String[] strDComponentValue) {
		this.strDComponentValue = strDComponentValue;
	}

	/**
	 * Gets the str d component id.
	 * 
	 * @return the strDComponentId
	 */
	public String[] getStrDComponentId() {
		return strDComponentId;
	}

	/**
	 * Sets the str d component id.
	 * 
	 * @param strDComponentId
	 *            the strDComponentId to set
	 */
	public void setStrDComponentId(String[] strDComponentId) {
		this.strDComponentId = strDComponentId;
	}

	/**
	 * Gets the str d tax.
	 * 
	 * @return the strDTax
	 */
	public String[] getStrDTax() {
		return strDTax;
	}

	/**
	 * Sets the str d tax.
	 * 
	 * @param strDTax
	 *            the strDTax to set
	 */
	public void setStrDTax(String[] strDTax) {
		this.strDTax = strDTax;
	}

	/**
	 * Gets the str d rate.
	 * 
	 * @return the strDRate
	 */
	public String[] getStrDRate() {
		return strDRate;
	}

	/**
	 * Sets the str d rate.
	 * 
	 * @param strDRate
	 *            the strDRate to set
	 */
	public void setStrDRate(String[] strDRate) {
		this.strDRate = strDRate;
	}

	/**
	 * Gets the str d rate unit id.
	 * 
	 * @return the strDRateUnitId
	 */
	public String[] getStrDRateUnitId() {
		return strDRateUnitId;
	}

	/**
	 * Sets the str d rate unit id.
	 * 
	 * @param strDRateUnitId
	 *            the strDRateUnitId to set
	 */
	public void setStrDRateUnitId(String[] strDRateUnitId) {
		this.strDRateUnitId = strDRateUnitId;
	}

	/**
	 * Gets the str d manufacturer id.
	 * 
	 * @return the strDManufacturerId
	 */
	public String[] getStrDManufacturerId() {
		return strDManufacturerId;
	}

	/**
	 * Sets the str d manufacturer id.
	 * 
	 * @param strDManufacturerId
	 *            the strDManufacturerId to set
	 */
	public void setStrDManufacturerId(String[] strDManufacturerId) {
		this.strDManufacturerId = strDManufacturerId;
	}

	/**
	 * Gets the str d warranty required.
	 * 
	 * @return the strDWarrantyRequired
	 */
	public String[] getStrDWarrantyRequired() {
		return strDWarrantyRequired;
	}

	/**
	 * Sets the str d warranty required.
	 * 
	 * @param strDWarrantyRequired
	 *            the strDWarrantyRequired to set
	 */
	public void setStrDWarrantyRequired(String[] strDWarrantyRequired) {
		this.strDWarrantyRequired = strDWarrantyRequired;
	}

	/**
	 * Gets the str d installation required.
	 * 
	 * @return the strDInstallationRequired
	 */
	public String[] getStrDInstallationRequired() {
		return strDInstallationRequired;
	}

	/**
	 * Sets the str d installation required.
	 * 
	 * @param strDInstallationRequired
	 *            the strDInstallationRequired to set
	 */
	public void setStrDInstallationRequired(String[] strDInstallationRequired) {
		this.strDInstallationRequired = strDInstallationRequired;
	}

	/**
	 * Gets the str d request type.
	 * 
	 * @return the strDRequestType
	 */
	public String[] getStrDRequestType() {
		return strDRequestType;
	}

	/**
	 * Sets the str d request type.
	 * 
	 * @param strDRequestType
	 *            the strDRequestType to set
	 */
	public void setStrDRequestType(String[] strDRequestType) {
		this.strDRequestType = strDRequestType;
	}

	/**
	 * Gets the str d purchase source.
	 * 
	 * @return the strDPurchaseSource
	 */
	public String getStrDPurchaseSource() {
		return strDPurchaseSource;
	}

	/**
	 * Sets the str d purchase source.
	 * 
	 * @param strDPurchaseSource
	 *            the strDPurchaseSource to set
	 */
	public void setStrDPurchaseSource(String strDPurchaseSource) {
		this.strDPurchaseSource = strDPurchaseSource;
	}

	/**
	 * Gets the str d delivery location.
	 * 
	 * @return the strPoNo
	 */

	/**
	 * @return the strDDeliveryLocation
	 */
	public String getStrDDeliveryLocation() {
		return strDDeliveryLocation;
	}

	/**
	 * Sets the str d delivery location.
	 * 
	 * @param strDDeliveryLocation
	 *            the strDDeliveryLocation to set
	 */
	public void setStrDDeliveryLocation(String strDDeliveryLocation) {
		this.strDDeliveryLocation = strDDeliveryLocation;
	}

	/**
	 * Gets the str d tender no.
	 * 
	 * @return the strDTenderNo
	 */
	public String getStrDTenderNo() {
		return strDTenderNo;
	}

	/**
	 * Sets the str d tender no.
	 * 
	 * @param strDTenderNo
	 *            the strDTenderNo to set
	 */
	public void setStrDTenderNo(String strDTenderNo) {
		this.strDTenderNo = strDTenderNo;
	}

	/**
	 * Gets the str d tender date.
	 * 
	 * @return the strDTenderDate
	 */
	public String getStrDTenderDate() {
		return strDTenderDate;
	}

	/**
	 * Sets the str d tender date.
	 * 
	 * @param strDTenderDate
	 *            the strDTenderDate to set
	 */
	public void setStrDTenderDate(String strDTenderDate) {
		this.strDTenderDate = strDTenderDate;
	}

	/**
	 * Gets the str d quotation no.
	 * 
	 * @return the strDQuotationNo
	 */
	public String getStrDQuotationNo() {
		return strDQuotationNo;
	}

	/**
	 * Sets the str d quotation no.
	 * 
	 * @param strDQuotationNo
	 *            the strDQuotationNo to set
	 */
	public void setStrDQuotationNo(String strDQuotationNo) {
		this.strDQuotationNo = strDQuotationNo;
	}

	/**
	 * Gets the str d quotation date.
	 * 
	 * @return the strDQuotationDate
	 */
	public String getStrDQuotationDate() {
		return strDQuotationDate;
	}

	/**
	 * Sets the str d quotation date.
	 * 
	 * @param strDQuotationDate
	 *            the strDQuotationDate to set
	 */
	public void setStrDQuotationDate(String strDQuotationDate) {
		this.strDQuotationDate = strDQuotationDate;
	}

	/**
	 * Gets the str d remarks.
	 * 
	 * @return the strDRemarks
	 */
	public String getStrDRemarks() {
		return strDRemarks;
	}

	/**
	 * Sets the str d remarks.
	 * 
	 * @param strDRemarks
	 *            the strDRemarks to set
	 */
	public void setStrDRemarks(String strDRemarks) {
		this.strDRemarks = strDRemarks;
	}

	/**
	 * Gets the str d over all tax.
	 * 
	 * @return the strDOverAllTax
	 */
	public String getStrDOverAllTax() {
		return strDOverAllTax;
	}

	/**
	 * Sets the str d over all tax.
	 * 
	 * @param strDOverAllTax
	 *            the strDOverAllTax to set
	 */
	public void setStrDOverAllTax(String strDOverAllTax) {
		this.strDOverAllTax = strDOverAllTax;
	}

	/**
	 * Gets the str component value.
	 * 
	 * @return the strComponentValue
	 */
	public String[] getStrComponentValue() {
		return strComponentValue;
	}

	/**
	 * Sets the str component value.
	 * 
	 * @param strComponentValue
	 *            the strComponentValue to set
	 */
	public void setStrComponentValue(String[] strComponentValue) {
		this.strComponentValue = strComponentValue;
	}

	/**
	 * Gets the str purchase source values.
	 * 
	 * @return the strPurchaseSourceValues
	 */
	public String getStrPurchaseSourceValues() {
		return strPurchaseSourceValues;
	}

	/**
	 * Sets the str purchase source values.
	 * 
	 * @param strPurchaseSourceValues
	 *            the strPurchaseSourceValues to set
	 */
	public void setStrPurchaseSourceValues(String strPurchaseSourceValues) {
		this.strPurchaseSourceValues = strPurchaseSourceValues;
	}

	/**
	 * Gets the str delivery location values.
	 * 
	 * @return the strDeliveryLocationValues
	 */
	public String getStrDeliveryLocationValues() {
		return strDeliveryLocationValues;
	}

	/**
	 * Sets the str delivery location values.
	 * 
	 * @param strDeliveryLocationValues
	 *            the strDeliveryLocationValues to set
	 */
	public void setStrDeliveryLocationValues(String strDeliveryLocationValues) {
		this.strDeliveryLocationValues = strDeliveryLocationValues;
	}

	/**
	 * Gets the str agent name values.
	 * 
	 * @return the strAgentNameValues
	 */
	public String getStrAgentNameValues() {
		return strAgentNameValues;
	}

	/**
	 * Sets the str agent name values.
	 * 
	 * @param strAgentNameValues
	 *            the strAgentNameValues to set
	 */
	public void setStrAgentNameValues(String strAgentNameValues) {
		this.strAgentNameValues = strAgentNameValues;
	}

	/**
	 * Gets the str currency values.
	 * 
	 * @return the strCurrencyValues
	 */
	public String getStrCurrencyValues() {
		return strCurrencyValues;
	}

	/**
	 * Sets the str currency values.
	 * 
	 * @param strCurrencyValues
	 *            the strCurrencyValues to set
	 */
	public void setStrCurrencyValues(String strCurrencyValues) {
		this.strCurrencyValues = strCurrencyValues;
	}

	/**
	 * Gets the str component id.
	 * 
	 * @return the strComponentID
	 */
	public String[] getStrComponentID() {
		return strComponentID;
	}

	/**
	 * Sets the str component id.
	 * 
	 * @param strComponentID
	 *            the strComponentID to set
	 */
	public void setStrComponentID(String[] strComponentID) {
		this.strComponentID = strComponentID;
	}

	/**
	 * Gets the str component name.
	 * 
	 * @return the strComponentName
	 */
	public String[] getStrComponentName() {
		return strComponentName;
	}

	/**
	 * Sets the str component name.
	 * 
	 * @param strComponentName
	 *            the strComponentName to set
	 */
	public void setStrComponentName(String[] strComponentName) {
		this.strComponentName = strComponentName;
	}

	/**
	 * Gets the wb component detail.
	 * 
	 * @return the wbComponentDetail
	 */
	public WebRowSet getWbComponentDetail() {
		return wbComponentDetail;
	}

	/**
	 * Sets the wb component detail.
	 * 
	 * @param wbComponentDetail
	 *            the wbComponentDetail to set
	 */
	public void setWbComponentDetail(WebRowSet wbComponentDetail) {
		this.wbComponentDetail = wbComponentDetail;
	}

	/**
	 * Gets the str manufacturer values.
	 * 
	 * @return the strManufacturerValues
	 */
	public String getStrManufacturerValues() {
		return strManufacturerValues;
	}

	/**
	 * Sets the str manufacturer values.
	 * 
	 * @param strManufacturerValues
	 *            the strManufacturerValues to set
	 */
	public void setStrManufacturerValues(String strManufacturerValues) {
		this.strManufacturerValues = strManufacturerValues;
	}

	/**
	 * Gets the str rate unit id.
	 * 
	 * @return the strRateUnitId
	 */
	public String getStrRateUnitId() {
		return strRateUnitId;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitId
	 *            the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * Gets the str request id.
	 * 
	 * @return the strRequestId
	 */
	public String getStrRequestId() {
		return strRequestId;
	}

	/**
	 * Sets the str request id.
	 * 
	 * @param strRequestId
	 *            the strRequestId to set
	 */
	public void setStrRequestId(String strRequestId) {
		this.strRequestId = strRequestId;
	}

	/**
	 * Gets the str contract type.
	 * 
	 * @return the strContractType
	 */
	public String getStrContractType() {
		return strContractType;
	}

	/**
	 * Sets the str contract type.
	 * 
	 * @param strContractType
	 *            the strContractType to set
	 */
	public void setStrContractType(String strContractType) {
		this.strContractType = strContractType;
	}

	/**
	 * Gets the str supplier values.
	 * 
	 * @return the strSupplierValues
	 */
	public String getStrSupplierValues() {
		return strSupplierValues;
	}

	/**
	 * Sets the str supplier values.
	 * 
	 * @param strSupplierValues
	 *            the strSupplierValues to set
	 */
	public void setStrSupplierValues(String strSupplierValues) {
		this.strSupplierValues = strSupplierValues;
	}

	/**
	 * Gets the str supplier id.
	 * 
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId
	 *            the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Gets the str po type values.
	 * 
	 * @return the strPOTypeValues
	 */
	public String getStrPOTypeValues() {
		return strPOTypeValues;
	}

	/**
	 * Sets the str po type values.
	 * 
	 * @param strPOTypeValues
	 *            the strPOTypeValues to set
	 */
	public void setStrPOTypeValues(String strPOTypeValues) {
		this.strPOTypeValues = strPOTypeValues;
	}

	/**
	 * Gets the str po type id.
	 * 
	 * @return the strPOTypeId
	 */
	public String getStrPOTypeId() {
		return strPOTypeId;
	}

	/**
	 * Sets the str po type id.
	 * 
	 * @param strPOTypeId
	 *            the strPOTypeId to set
	 */
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType
	 *            the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr
	 *            the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning
	 *            the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString
	 *            the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg
	 *            the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str to store.
	 * 
	 * @return the strToStore
	 */
	public String getStrToStore() {
		return strToStore;
	}

	/**
	 * Sets the str to store.
	 * 
	 * @param strToStore
	 *            the strToStore to set
	 */
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}

	/**
	 * Gets the str to store values.
	 * 
	 * @return the strToStoreValues
	 */
	public String getStrToStoreValues() {
		return strToStoreValues;
	}

	/**
	 * Sets the str to store values.
	 * 
	 * @param strToStoreValues
	 *            the strToStoreValues to set
	 */
	public void setStrToStoreValues(String strToStoreValues) {
		this.strToStoreValues = strToStoreValues;
	}

	/**
	 * Gets the str item cat.
	 * 
	 * @return the strItemCat
	 */
	public String getStrItemCat() {
		return strItemCat;
	}

	/**
	 * Sets the str item cat.
	 * 
	 * @param strItemCat
	 *            the strItemCat to set
	 */
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}

	/**
	 * Gets the str item cat values.
	 * 
	 * @return the strItemCatValues
	 */
	public String getStrItemCatValues() {
		return strItemCatValues;
	}

	/**
	 * Sets the str item cat values.
	 * 
	 * @param strItemCatValues
	 *            the strItemCatValues to set
	 */
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}

	/**
	 * Gets the str agenda period.
	 * 
	 * @return the strAgendaPeriod
	 */
	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}

	/**
	 * Sets the str agenda period.
	 * 
	 * @param strAgendaPeriod
	 *            the strAgendaPeriod to set
	 */
	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode
	 *            the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str item cat no.
	 * 
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo
	 *            the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks
	 *            the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str agenda no.
	 * 
	 * @return the strAgendaNo
	 */
	public String getStrAgendaNo() {
		return strAgendaNo;
	}

	/**
	 * Sets the str agenda no.
	 * 
	 * @param strAgendaNo
	 *            the strAgendaNo to set
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	/**
	 * Gets the str to store id.
	 * 
	 * @return the strToStoreId
	 */
	public String getStrToStoreId() {
		return strToStoreId;
	}

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId
	 *            the strToStoreId to set
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * Gets the str agenda date.
	 * 
	 * @return the strAgendaDate
	 */
	public String getStrAgendaDate() {
		return strAgendaDate;
	}

	/**
	 * Sets the str agenda date.
	 * 
	 * @param strAgendaDate
	 *            the strAgendaDate to set
	 */
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}

	/**
	 * Gets the str agenda status.
	 * 
	 * @return the strAgendaStatus
	 */
	public String getStrAgendaStatus() {
		return strAgendaStatus;
	}

	/**
	 * Sets the str agenda status.
	 * 
	 * @param strAgendaStatus
	 *            the strAgendaStatus to set
	 */
	public void setStrAgendaStatus(String strAgendaStatus) {
		this.strAgendaStatus = strAgendaStatus;
	}

	/**
	 * Gets the str financial start date.
	 * 
	 * @return the strFinancialStartDate
	 */
	public String getStrFinancialStartDate() {
		return strFinancialStartDate;
	}

	/**
	 * Sets the str financial start date.
	 * 
	 * @param strFinancialStartDate
	 *            the strFinancialStartDate to set
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * Gets the str financial to date.
	 * 
	 * @return the strFinancialToDate
	 */
	public String getStrFinancialToDate() {
		return strFinancialToDate;
	}

	/**
	 * Sets the str financial to date.
	 * 
	 * @param strFinancialToDate
	 *            the strFinancialToDate to set
	 */
	public void setStrFinancialToDate(String strFinancialToDate) {
		this.strFinancialToDate = strFinancialToDate;
	}

	/**
	 * Gets the str check box.
	 * 
	 * @return the strCheckBox
	 */
	public String[] getStrCheckBox() {
		return strCheckBox;
	}

	/**
	 * Sets the str check box.
	 * 
	 * @param strCheckBox
	 *            the strCheckBox to set
	 */
	public void setStrCheckBox(String[] strCheckBox) {
		this.strCheckBox = strCheckBox;
	}

	/**
	 * Gets the str indent no.
	 * 
	 * @return the strIndentNo
	 */
	public String getStrIndentNo() {
		return strIndentNo;
	}

	/**
	 * Sets the str indent no.
	 * 
	 * @param strIndentNo
	 *            the strIndentNo to set
	 */
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}

	/**
	 * Gets the str grant type values.
	 * 
	 * @return the strGrantTypeValues
	 */
	public String getStrGrantTypeValues() {
		return strGrantTypeValues;
	}

	/**
	 * Sets the str grant type values.
	 * 
	 * @param strGrantTypeValues
	 *            the strGrantTypeValues to set
	 */
	public void setStrGrantTypeValues(String strGrantTypeValues) {
		this.strGrantTypeValues = strGrantTypeValues;
	}

	/**
	 * Gets the str grant type id.
	 * 
	 * @return the strGrantTypeId
	 */
	public String getStrGrantTypeId() {
		return strGrantTypeId;
	}

	/**
	 * Sets the str grant type id.
	 * 
	 * @param strGrantTypeId
	 *            the strGrantTypeId to set
	 */
	public void setStrGrantTypeId(String strGrantTypeId) {
		this.strGrantTypeId = strGrantTypeId;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str item popup data.
	 * 
	 * @return the strItemPopupData
	 */
	public String getStrItemPopupData() {
		return strItemPopupData;
	}

	/**
	 * Sets the str item popup data.
	 * 
	 * @param strItemPopupData
	 *            the strItemPopupData to set
	 */
	public void setStrItemPopupData(String strItemPopupData) {
		this.strItemPopupData = strItemPopupData;
	}

	/**
	 * Gets the str rate unit values.
	 * 
	 * @return the strRateUnitValues
	 */
	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}

	/**
	 * Sets the str rate unit values.
	 * 
	 * @param strRateUnitValues
	 *            the strRateUnitValues to set
	 */
	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}

	/**
	 * Gets the str inventory unit id.
	 * 
	 * @return the strInventoryUnitId
	 */
	public String getStrInventoryUnitId() {
		return strInventoryUnitId;
	}

	/**
	 * Sets the str inventory unit id.
	 * 
	 * @param strInventoryUnitId
	 *            the strInventoryUnitId to set
	 */
	public void setStrInventoryUnitId(String strInventoryUnitId) {
		this.strInventoryUnitId = strInventoryUnitId;
	}

	/**
	 * Gets the wb request detail.
	 * 
	 * @return the wbRequestDetail
	 */
	public WebRowSet getWbRequestDetail() {
		return wbRequestDetail;
	}

	/**
	 * Sets the wb request detail.
	 * 
	 * @param wbRequestDetail
	 *            the wbRequestDetail to set
	 */
	public void setWbRequestDetail(WebRowSet wbRequestDetail) {
		this.wbRequestDetail = wbRequestDetail;
	}

	/**
	 * Gets the wb request item detail.
	 * 
	 * @return the wbRequestItemDetail
	 */
	public WebRowSet getWbRequestItemDetail() {
		return wbRequestItemDetail;
	}

	/**
	 * Sets the wb request item detail.
	 * 
	 * @param wbRequestItemDetail
	 *            the wbRequestItemDetail to set
	 */
	public void setWbRequestItemDetail(WebRowSet wbRequestItemDetail) {
		this.wbRequestItemDetail = wbRequestItemDetail;
	}

	/**
	 * Gets the str d approx rate unit.
	 * 
	 * @return the strDApproxRateUnit
	 */
	public String[] getStrDApproxRateUnit() {
		return strDApproxRateUnit;
	}

	/**
	 * Sets the str d approx rate unit.
	 * 
	 * @param strDApproxRateUnit
	 *            the strDApproxRateUnit to set
	 */
	public void setStrDApproxRateUnit(String[] strDApproxRateUnit) {
		this.strDApproxRateUnit = strDApproxRateUnit;
	}

	/**
	 * Gets the str d approx rate.
	 * 
	 * @return the strDApproxRate
	 */
	public String[] getStrDApproxRate() {
		return strDApproxRate;
	}

	/**
	 * Sets the str d approx rate.
	 * 
	 * @param strDApproxRate
	 *            the strDApproxRate to set
	 */
	public void setStrDApproxRate(String[] strDApproxRate) {
		this.strDApproxRate = strDApproxRate;
	}

	/**
	 * Gets the str ditem id.
	 * 
	 * @return the strDitemId
	 */
	public String[] getStrDitemId() {
		return strDitemId;
	}

	/**
	 * Sets the str ditem id.
	 * 
	 * @param strDitemId
	 *            the strDitemId to set
	 */
	public void setStrDitemId(String[] strDitemId) {
		this.strDitemId = strDitemId;
	}

	/**
	 * Gets the str ditem brand id.
	 * 
	 * @return the strDitemBrandId
	 */
	public String[] getStrDitemBrandId() {
		return strDitemBrandId;
	}

	/**
	 * Sets the str ditem brand id.
	 * 
	 * @param strDitemBrandId
	 *            the strDitemBrandId to set
	 */
	public void setStrDitemBrandId(String[] strDitemBrandId) {
		this.strDitemBrandId = strDitemBrandId;
	}

	/**
	 * Gets the str d group id.
	 * 
	 * @return the strDGroupId
	 */
	public String[] getStrDGroupId() {
		return strDGroupId;
	}

	/**
	 * Sets the str d group id.
	 * 
	 * @param strDGroupId
	 *            the strDGroupId to set
	 */
	public void setStrDGroupId(String[] strDGroupId) {
		this.strDGroupId = strDGroupId;
	}

	/**
	 * Gets the str d sub group id.
	 * 
	 * @return the strDSubGroupId
	 */
	public String[] getStrDSubGroupId() {
		return strDSubGroupId;
	}

	/**
	 * Sets the str d sub group id.
	 * 
	 * @param strDSubGroupId
	 *            the strDSubGroupId to set
	 */
	public void setStrDSubGroupId(String[] strDSubGroupId) {
		this.strDSubGroupId = strDSubGroupId;
	}

	/**
	 * Gets the str d compiled qty.
	 * 
	 * @return the strDCompiledQty
	 */
	public String[] getStrDCompiledQty() {
		return strDCompiledQty;
	}

	/**
	 * Sets the str d compiled qty.
	 * 
	 * @param strDCompiledQty
	 *            the strDCompiledQty to set
	 */
	public void setStrDCompiledQty(String[] strDCompiledQty) {
		this.strDCompiledQty = strDCompiledQty;
	}

	/**
	 * Gets the str d compiled qty unit.
	 * 
	 * @return the strDCompiledQtyUnit
	 */
	public String[] getStrDCompiledQtyUnit() {
		return strDCompiledQtyUnit;
	}

	/**
	 * Sets the str d compiled qty unit.
	 * 
	 * @param strDCompiledQtyUnit
	 *            the strDCompiledQtyUnit to set
	 */
	public void setStrDCompiledQtyUnit(String[] strDCompiledQtyUnit) {
		this.strDCompiledQtyUnit = strDCompiledQtyUnit;
	}

	/**
	 * Gets the str d request no.
	 * 
	 * @return the strDRequestNo
	 */
	public String[] getStrDRequestNo() {
		return strDRequestNo;
	}

	/**
	 * Sets the str d request no.
	 * 
	 * @param strDRequestNo
	 *            the strDRequestNo to set
	 */
	public void setStrDRequestNo(String[] strDRequestNo) {
		this.strDRequestNo = strDRequestNo;
	}

	/**
	 * Gets the str d request date.
	 * 
	 * @return the strDRequestDate
	 */
	public String[] getStrDRequestDate() {
		return strDRequestDate;
	}

	/**
	 * Sets the str d request date.
	 * 
	 * @param strDRequestDate
	 *            the strDRequestDate to set
	 */
	public void setStrDRequestDate(String[] strDRequestDate) {
		this.strDRequestDate = strDRequestDate;
	}

	/**
	 * Gets the str d request period.
	 * 
	 * @return the strDRequestPeriod
	 */
	public String[] getStrDRequestPeriod() {
		return strDRequestPeriod;
	}

	/**
	 * Sets the str d request period.
	 * 
	 * @param strDRequestPeriod
	 *            the strDRequestPeriod to set
	 */
	public void setStrDRequestPeriod(String[] strDRequestPeriod) {
		this.strDRequestPeriod = strDRequestPeriod;
	}

	/**
	 * Gets the str d raising store.
	 * 
	 * @return the strDRaisingStore
	 */
	public String[] getStrDRaisingStore() {
		return strDRaisingStore;
	}

	/**
	 * Sets the str d raising store.
	 * 
	 * @param strDRaisingStore
	 *            the strDRaisingStore to set
	 */
	public void setStrDRaisingStore(String[] strDRaisingStore) {
		this.strDRaisingStore = strDRaisingStore;
	}

	/**
	 * Gets the str d lst po no.
	 * 
	 * @return the strDLstPoNo
	 */
	public String[] getStrDLstPoNo() {
		return strDLstPoNo;
	}

	/**
	 * Sets the str d lst po no.
	 * 
	 * @param strDLstPoNo
	 *            the strDLstPoNo to set
	 */
	public void setStrDLstPoNo(String[] strDLstPoNo) {
		this.strDLstPoNo = strDLstPoNo;
	}

	/**
	 * Gets the str d lst po date.
	 * 
	 * @return the strDLstPoDate
	 */
	public String[] getStrDLstPoDate() {
		return strDLstPoDate;
	}

	/**
	 * Sets the str d lst po date.
	 * 
	 * @param strDLstPoDate
	 *            the strDLstPoDate to set
	 */
	public void setStrDLstPoDate(String[] strDLstPoDate) {
		this.strDLstPoDate = strDLstPoDate;
	}

	/**
	 * Gets the str d lst supplier id.
	 * 
	 * @return the strDLstSupplierId
	 */
	public String[] getStrDLstSupplierId() {
		return strDLstSupplierId;
	}

	/**
	 * Sets the str d lst supplier id.
	 * 
	 * @param strDLstSupplierId
	 *            the strDLstSupplierId to set
	 */
	public void setStrDLstSupplierId(String[] strDLstSupplierId) {
		this.strDLstSupplierId = strDLstSupplierId;
	}

	/**
	 * Gets the str d lst rec qty.
	 * 
	 * @return the strDLstRecQty
	 */
	public String[] getStrDLstRecQty() {
		return strDLstRecQty;
	}

	/**
	 * Sets the str d lst rec qty.
	 * 
	 * @param strDLstRecQty
	 *            the strDLstRecQty to set
	 */
	public void setStrDLstRecQty(String[] strDLstRecQty) {
		this.strDLstRecQty = strDLstRecQty;
	}

	/**
	 * Gets the str d lst rec qty unit.
	 * 
	 * @return the strDLstRecQtyUnit
	 */
	public String[] getStrDLstRecQtyUnit() {
		return strDLstRecQtyUnit;
	}

	/**
	 * Sets the str d lst rec qty unit.
	 * 
	 * @param strDLstRecQtyUnit
	 *            the strDLstRecQtyUnit to set
	 */
	public void setStrDLstRecQtyUnit(String[] strDLstRecQtyUnit) {
		this.strDLstRecQtyUnit = strDLstRecQtyUnit;
	}

	/**
	 * Gets the str d lst rec date.
	 * 
	 * @return the strDLstRecDate
	 */
	public String[] getStrDLstRecDate() {
		return strDLstRecDate;
	}

	/**
	 * Sets the str d lst rec date.
	 * 
	 * @param strDLstRecDate
	 *            the strDLstRecDate to set
	 */
	public void setStrDLstRecDate(String[] strDLstRecDate) {
		this.strDLstRecDate = strDLstRecDate;
	}

	/**
	 * Gets the str d lst pur rate.
	 * 
	 * @return the strDLstPurRate
	 */
	public String[] getStrDLstPurRate() {
		return strDLstPurRate;
	}

	/**
	 * Sets the str d lst pur rate.
	 * 
	 * @param strDLstPurRate
	 *            the strDLstPurRate to set
	 */
	public void setStrDLstPurRate(String[] strDLstPurRate) {
		this.strDLstPurRate = strDLstPurRate;
	}

	/**
	 * Gets the str d lst pur rate unit.
	 * 
	 * @return the strDLstPurRateUnit
	 */
	public String[] getStrDLstPurRateUnit() {
		return strDLstPurRateUnit;
	}

	/**
	 * Sets the str d lst pur rate unit.
	 * 
	 * @param strDLstPurRateUnit
	 *            the strDLstPurRateUnit to set
	 */
	public void setStrDLstPurRateUnit(String[] strDLstPurRateUnit) {
		this.strDLstPurRateUnit = strDLstPurRateUnit;
	}

	/**
	 * Gets the str check box item.
	 * 
	 * @return the strCheckBoxItem
	 */
	public String[] getStrCheckBoxItem() {
		return strCheckBoxItem;
	}

	/**
	 * Sets the str check box item.
	 * 
	 * @param strCheckBoxItem
	 *            the strCheckBoxItem to set
	 */
	public void setStrCheckBoxItem(String[] strCheckBoxItem) {
		this.strCheckBoxItem = strCheckBoxItem;
	}

	/**
	 * Gets the str store ids.
	 * 
	 * @return the strStoreIds
	 */
	public String getStrStoreIds() {
		return strStoreIds;
	}

	/**
	 * Sets the str store ids.
	 * 
	 * @param strStoreIds
	 *            the strStoreIds to set
	 */
	public void setStrStoreIds(String strStoreIds) {
		this.strStoreIds = strStoreIds;
	}

	/**
	 * Gets the str request ids.
	 * 
	 * @return the strRequestIds
	 */
	public String getStrRequestIds() {
		return strRequestIds;
	}

	/**
	 * Sets the str request ids.
	 * 
	 * @param strRequestIds
	 *            the strRequestIds to set
	 */
	public void setStrRequestIds(String strRequestIds) {
		this.strRequestIds = strRequestIds;
	}

	/**
	 * Gets the str item ids.
	 * 
	 * @return the strItemIds
	 */
	public String getStrItemIds() {
		return strItemIds;
	}

	/**
	 * Sets the str item ids.
	 * 
	 * @param strItemIds
	 *            the strItemIds to set
	 */
	public void setStrItemIds(String strItemIds) {
		this.strItemIds = strItemIds;
	}

	/**
	 * Gets the str item brand ids.
	 * 
	 * @return the strItemBrandIds
	 */
	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}

	/**
	 * Sets the str item brand ids.
	 * 
	 * @param strItemBrandIds
	 *            the strItemBrandIds to set
	 */
	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}


	/**
	 * Gets the str verified date.
	 * 
	 * @return the strVerifiedDate
	 */
	public String getStrVerifiedDate() {
		return strVerifiedDate;
	}

	/**
	 * Sets the str verified date.
	 * 
	 * @param strVerifiedDate
	 *            the strVerifiedDate to set
	 */
	public void setStrVerifiedDate(String strVerifiedDate) {
		this.strVerifiedDate = strVerifiedDate;
	}

	/**
	 * Gets the str verified by.
	 * 
	 * @return the strVerifiedBy
	 */
	public String getStrVerifiedBy() {
		return strVerifiedBy;
	}

	/**
	 * Sets the str verified by.
	 * 
	 * @param strVerifiedBy
	 *            the strVerifiedBy to set
	 */
	public void setStrVerifiedBy(String strVerifiedBy) {
		this.strVerifiedBy = strVerifiedBy;
	}

	/**
	 * Gets the str make.
	 * 
	 * @return the strMake
	 */
	public String[] getStrMake() {
		return strMake;
	}

	/**
	 * Sets the str make.
	 * 
	 * @param strMake
	 *            the strMake to set
	 */
	public void setStrMake(String[] strMake) {
		this.strMake = strMake;
	}

	/**
	 * Gets the str tmp bal qty.
	 * 
	 * @return the str tmp bal qty
	 */
	public String[] getStrTmpBalQty() {
		return strTmpBalQty;
	}

	/**
	 * Sets the str tmp bal qty.
	 * 
	 * @param strTmpBalQty
	 *            the new str tmp bal qty
	 */
	public void setStrTmpBalQty(String[] strTmpBalQty) {
		this.strTmpBalQty = strTmpBalQty;
	}

	/**
	 * Gets the str d delivery days.
	 * 
	 * @return the str d delivery days
	 */
	public String getStrDDeliveryDays() {
		return strDDeliveryDays;
	}

	/**
	 * Sets the str d delivery days.
	 * 
	 * @param strDDeliveryDays
	 *            the new str d delivery days
	 */
	public void setStrDDeliveryDays(String strDDeliveryDays) {
		this.strDDeliveryDays = strDDeliveryDays;
	}

	/**
	 * Gets the str hlp size.
	 * 
	 * @return the str hlp size
	 */
	public int getStrHlpSize() {
		return strHlpSize;
	}

	/**
	 * Sets the str hlp size.
	 * 
	 * @param strHlpSize
	 *            the new str hlp size
	 */
	public void setStrHlpSize(int strHlpSize) {
		this.strHlpSize = strHlpSize;
	}

	/**
	 * Gets the wbs store name combo.
	 * 
	 * @return the wbs store name combo
	 */
	public WebRowSet getWbsStoreNameCombo() {
		return wbsStoreNameCombo;
	}

	/**
	 * Sets the wbs store name combo.
	 * 
	 * @param wbsStoreNameCombo
	 *            the new wbs store name combo
	 */
	public void setWbsStoreNameCombo(WebRowSet wbsStoreNameCombo) {
		this.wbsStoreNameCombo = wbsStoreNameCombo;
	}

	/**
	 * Gets the wbs req list po.
	 * 
	 * @return the wbs req list po
	 */
	public WebRowSet getWbsReqListPO() {
		return wbsReqListPO;
	}

	/**
	 * Sets the wbs req list po.
	 * 
	 * @param wbsReqListPO
	 *            the new wbs req list po
	 */
	public void setWbsReqListPO(WebRowSet wbsReqListPO) {
		this.wbsReqListPO = wbsReqListPO;
	}

	/**
	 * Gets the str po date.
	 * 
	 * @return the str po date
	 */
	public String getStrPODate() {
		return strPODate;
	}

	/**
	 * Sets the str po date.
	 * 
	 * @param strPODate
	 *            the new str po date
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}

	/**
	 * Gets the str supplier name.
	 * 
	 * @return the str supplier name
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}

	/**
	 * Sets the str supplier name.
	 * 
	 * @param strSupplierName
	 *            the new str supplier name
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	/**
	 * Gets the str po type.
	 * 
	 * @return the str po type
	 */
	public String getStrPOType() {
		return strPOType;
	}

	/**
	 * Sets the str po type.
	 * 
	 * @param strPOType
	 *            the new str po type
	 */
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}

	/**
	 * Gets the str item cat name.
	 * 
	 * @return the str item cat name
	 */
	public String getStrItemCatName() {
		return strItemCatName;
	}

	/**
	 * Sets the str item cat name.
	 * 
	 * @param strItemCatName
	 *            the new str item cat name
	 */
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}

	/**
	 * Gets the str po hidden value.
	 * 
	 * @return the str po hidden value
	 */
	public String getStrPOHiddenValue() {
		return strPOHiddenValue;
	}

	/**
	 * Sets the str po hidden value.
	 * 
	 * @param strPOHiddenValue
	 *            the new str po hidden value
	 */
	public void setStrPOHiddenValue(String strPOHiddenValue) {
		this.strPOHiddenValue = strPOHiddenValue;
	}

	/**
	 * Gets the str demand year.
	 * 
	 * @return the str demand year
	 */
	public String getStrDemandYear() {
		return strDemandYear;
	}

	/**
	 * Sets the str demand year.
	 * 
	 * @param strDemandYear
	 *            the new str demand year
	 */
	public void setStrDemandYear(String strDemandYear) {
		this.strDemandYear = strDemandYear;
	}

	/**
	 * Gets the str schedule one.
	 * 
	 * @return the str schedule one
	 */
	public String[] getStrScheduleOne() {
		return strScheduleOne;
	}

	/**
	 * Sets the str schedule one.
	 * 
	 * @param strScheduleOne
	 *            the new str schedule one
	 */
	public void setStrScheduleOne(String[] strScheduleOne) {
		this.strScheduleOne = strScheduleOne;
	}

	/**
	 * Gets the str schedule two.
	 * 
	 * @return the str schedule two
	 */
	public String[] getStrScheduleTwo() {
		return strScheduleTwo;
	}

	/**
	 * Sets the str schedule two.
	 * 
	 * @param strScheduleTwo
	 *            the new str schedule two
	 */
	public void setStrScheduleTwo(String[] strScheduleTwo) {
		this.strScheduleTwo = strScheduleTwo;
	}

	/**
	 * Gets the str schedule three.
	 * 
	 * @return the str schedule three
	 */
	public String[] getStrScheduleThree() {
		return strScheduleThree;
	}

	/**
	 * Sets the str schedule three.
	 * 
	 * @param strScheduleThree
	 *            the new str schedule three
	 */
	public void setStrScheduleThree(String[] strScheduleThree) {
		this.strScheduleThree = strScheduleThree;
	}

	/**
	 * Gets the str schedule four.
	 * 
	 * @return the str schedule four
	 */
	public String[] getStrScheduleFour() {
		return strScheduleFour;
	}

	/**
	 * Sets the str schedule four.
	 * 
	 * @param strScheduleFour
	 *            the new str schedule four
	 */
	public void setStrScheduleFour(String[] strScheduleFour) {
		this.strScheduleFour = strScheduleFour;
	}

	/**
	 * Gets the wb po delivery location mob no.
	 * 
	 * @return the wb po delivery location mob no
	 */
	public WebRowSet getWbPODeliveryLocationMobNo() {
		return wbPODeliveryLocationMobNo;
	}

	/**
	 * Sets the wb po delivery location mob no.
	 * 
	 * @param wbPODeliveryLocationMobNo
	 *            the new wb po delivery location mob no
	 */
	public void setWbPODeliveryLocationMobNo(WebRowSet wbPODeliveryLocationMobNo) {
		this.wbPODeliveryLocationMobNo = wbPODeliveryLocationMobNo;
	}

	/**
	 * Gets the str mobile msg mode.
	 * 
	 * @return the str mobile msg mode
	 */
	public String getStrMobileMsgMode() {
		return strMobileMsgMode;
	}

	/**
	 * Sets the str mobile msg mode.
	 * 
	 * @param strMobileMsgMode
	 *            the new str mobile msg mode
	 */
	public void setStrMobileMsgMode(String strMobileMsgMode) {
		this.strMobileMsgMode = strMobileMsgMode;
	}

	/**
	 * Gets the str mobile user name.
	 * 
	 * @return the str mobile user name
	 */
	public String getStrMobileUserName() {
		return strMobileUserName;
	}

	/**
	 * Sets the str mobile user name.
	 * 
	 * @param strMobileUserName
	 *            the new str mobile user name
	 */
	public void setStrMobileUserName(String strMobileUserName) {
		this.strMobileUserName = strMobileUserName;
	}

	/**
	 * Gets the str mobile pwd.
	 * 
	 * @return the str mobile pwd
	 */
	public String getStrMobilePwd() {
		return strMobilePwd;
	}

	/**
	 * Sets the str mobile pwd.
	 * 
	 * @param strMobilePwd
	 *            the new str mobile pwd
	 */
	public void setStrMobilePwd(String strMobilePwd) {
		this.strMobilePwd = strMobilePwd;
	}

	/**
	 * Gets the str mobile sender id.
	 * 
	 * @return the str mobile sender id
	 */
	public String getStrMobileSenderId() {
		return strMobileSenderId;
	}

	/**
	 * Sets the str mobile sender id.
	 * 
	 * @param strMobileSenderId
	 *            the new str mobile sender id
	 */
	public void setStrMobileSenderId(String strMobileSenderId) {
		this.strMobileSenderId = strMobileSenderId;
	}

	/**
	 * Gets the str manufacturer id.
	 * 
	 * @return the str manufacturer id
	 */
	public String getStrManufacturerId() {
		return strManufacturerId;
	}

	/**
	 * Sets the str manufacturer id.
	 * 
	 * @param strManufacturerId
	 *            the new str manufacturer id
	 */
	public void setStrManufacturerId(String strManufacturerId) {
		this.strManufacturerId = strManufacturerId;
	}

	/**
	 * Gets the wbs programme dtl.
	 * 
	 * @return the wbs programme dtl
	 */
	public WebRowSet getWbsProgrammeDtl() {
		return wbsProgrammeDtl;
	}

	/**
	 * Sets the wbs programme dtl.
	 * 
	 * @param wbsProgrammeDtl
	 *            the new wbs programme dtl
	 */
	public void setWbsProgrammeDtl(WebRowSet wbsProgrammeDtl) {
		this.wbsProgrammeDtl = wbsProgrammeDtl;
	}

	/**
	 * Gets the str programme id.
	 * 
	 * @return the str programme id
	 */
	public String[] getStrProgrammeId() {
		return strProgrammeId;
	}

	/**
	 * Sets the str programme id.
	 * 
	 * @param strProgrammeId
	 *            the new str programme id
	 */
	public void setStrProgrammeId(String[] strProgrammeId) {
		this.strProgrammeId = strProgrammeId;
	}

	/**
	 * Gets the str purchase committe meeting date.
	 * 
	 * @return the str purchase committe meeting date
	 */
	public String getStrPurchaseCommitteMeetingDate() {
		return strPurchaseCommitteMeetingDate;
	}

	/**
	 * Sets the str purchase committe meeting date.
	 * 
	 * @param strPurchaseCommitteMeetingDate
	 *            the new str purchase committe meeting date
	 */
	public void setStrPurchaseCommitteMeetingDate(
			String strPurchaseCommitteMeetingDate) {
		this.strPurchaseCommitteMeetingDate = strPurchaseCommitteMeetingDate;
	}

	/**
	 * Gets the str new supplier id.
	 * 
	 * @return the str new supplier id
	 */
	public String getStrNewSupplierId() {
		return strNewSupplierId;
	}

	/**
	 * Sets the str new supplier id.
	 * 
	 * @param strNewSupplierId
	 *            the new str new supplier id
	 */
	public void setStrNewSupplierId(String strNewSupplierId) {
		this.strNewSupplierId = strNewSupplierId;
	}

	/**
	 * Gets the str schedule.
	 * 
	 * @return the str schedule
	 */
	public String getStrSchedule() {
		return strSchedule;
	}

	/**
	 * Sets the str schedule.
	 * 
	 * @param strSchedule
	 *            the new str schedule
	 */
	public void setStrSchedule(String strSchedule) {
		this.strSchedule = strSchedule;
	}

	/**
	 * Gets the wb ddw combo.
	 * 
	 * @return the wb ddw combo
	 */
	public WebRowSet getWbDdwCombo() {
		return wbDdwCombo;
	}

	/**
	 * Sets the wb ddw combo.
	 * 
	 * @param wbDdwCombo
	 *            the new wb ddw combo
	 */
	public void setWbDdwCombo(WebRowSet wbDdwCombo) {
		this.wbDdwCombo = wbDdwCombo;
	}

	public String getStrDwhTypeId() {
		return strDwhTypeId;
	}

	public void setStrDwhTypeId(String strDwhTypeId) {
		this.strDwhTypeId = strDwhTypeId;
	}

	public WebRowSet getStrHeaderWS() {
		return strHeaderWS;
	}

	public void setStrHeaderWS(WebRowSet strHeaderWS) {
		this.strHeaderWS = strHeaderWS;
	}

	public WebRowSet getStrDrugListWS() {
		return strDrugListWS;
	}

	public void setStrDrugListWS(WebRowSet strDrugListWS) {
		this.strDrugListWS = strDrugListWS;
	}

	public String getStrPOStoreId() {
		return strPOStoreId;
	}

	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}

	public String getStrTableWidth() {
		return strTableWidth;
	}

	public void setStrTableWidth(String strTableWidth) {
		this.strTableWidth = strTableWidth;
	}

	public String getStrDistrictStoreId() {
		return strDistrictStoreId;
	}

	public void setStrDistrictStoreId(String strDistrictStoreId) {
		this.strDistrictStoreId = strDistrictStoreId;
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

	public WebRowSet getWsStoreList() {
		return wsStoreList;
	}

	public void setWsStoreList(WebRowSet wsStoreList) {
		this.wsStoreList = wsStoreList;
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

	public WebRowSet getWbDeliveryMode() {
		return wbDeliveryMode;
	}

	public void setWbDeliveryMode(WebRowSet wbDeliveryMode) {
		this.wbDeliveryMode = wbDeliveryMode;
	}

	public WebRowSet getWbApprovedBy() {
		return WbApprovedBy;
	}

	public void setWbApprovedBy(WebRowSet wbApprovedBy) {
		WbApprovedBy = wbApprovedBy;
	}

	public String getStrConsigneeStoreCombo() {
		return strConsigneeStoreCombo;
	}

	public void setStrConsigneeStoreCombo(String strConsigneeStoreCombo) {
		this.strConsigneeStoreCombo = strConsigneeStoreCombo;
	}

	public String getStrUnitId() {
		return strUnitId;
	}

	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}

	public WebRowSet getWsUnitList() {
		return wsUnitList;
	}

	public void setWsUnitList(WebRowSet wsUnitList) {
		this.wsUnitList = wsUnitList;
	}

	public WebRowSet getWsItemList() {
		return wsItemList;
	}

	public void setWsItemList(WebRowSet wsItemList) {
		this.wsItemList = wsItemList;
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

	public String getStrDeliveryNo() {
		return strDeliveryNo;
	}

	public void setStrDeliveryNo(String strDeliveryNo) {
		this.strDeliveryNo = strDeliveryNo;
	}

	
	public String getStrRejectedBatchList() {
		return strRejectedBatchList;
	}

	public void setStrRejectedBatchList(String strRejectedBatchList) {
		this.strRejectedBatchList = strRejectedBatchList;
	}

	public String getStrDeleteRemarks() {
		return strDeleteRemarks;
	}

	public void setStrDeleteRemarks(String strDeleteRemarks) {
		this.strDeleteRemarks = strDeleteRemarks;
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

	public WebRowSet getCartonSizeWs() {
		return cartonSizeWs;
	}

	public void setCartonSizeWs(WebRowSet cartonSizeWs) {
		this.cartonSizeWs = cartonSizeWs;
	}

	public String getStrCartonSizeCmb() {
		return strCartonSizeCmb;
	}

	public void setStrCartonSizeCmb(String strCartonSizeCmb) {
		this.strCartonSizeCmb = strCartonSizeCmb;
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

	public String getStrItemNameNew() {
		return strItemNameNew;
	}

	public void setStrItemNameNew(String strItemNameNew) {
		this.strItemNameNew = strItemNameNew;
	}

	public WebRowSet getStrBatchNoWs() {
		return strBatchNoWs;
	}

	public void setStrBatchNoWs(WebRowSet strBatchNoWs) {
		this.strBatchNoWs = strBatchNoWs;
	}

	public String getStrBatchNoCmb() {
		return strBatchNoCmb;
	}

	public void setStrBatchNoCmb(String strBatchNoCmb) {
		this.strBatchNoCmb = strBatchNoCmb;
	}

	public String getStrPoPreFlag() {
		return strPoPreFlag;
	}

	public void setStrPoPreFlag(String strPoPreFlag) {
		this.strPoPreFlag = strPoPreFlag;
	}

	public String getStrQrStoreId() {
		return strQrStoreId;
	}

	public void setStrQrStoreId(String strQrStoreId) {
		this.strQrStoreId = strQrStoreId;
	}

	public String getStrQrItemId() {
		return strQrItemId;
	}

	public void setStrQrItemId(String strQrItemId) {
		this.strQrItemId = strQrItemId;
	}

	public String getStrQrSupplierId() {
		return strQrSupplierId;
	}

	public void setStrQrSupplierId(String strQrSupplierId) {
		this.strQrSupplierId = strQrSupplierId;
	}

	public String getStrQrPono() {
		return strQrPono;
	}

	public void setStrQrPono(String strQrPono) {
		this.strQrPono = strQrPono;
	}

	public String getStrSchno() {
		return strSchno;
	}

	public void setStrSchno(String strSchno) {
		this.strSchno = strSchno;
	}

	public String getStrDelno() {
		return strDelno;
	}

	public void setStrDelno(String strDelno) {
		this.strDelno = strDelno;
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

	public WebRowSet getWsBatchList() {
		return wsBatchList;
	}

	public void setWsBatchList(WebRowSet wsBatchList) {
		this.wsBatchList = wsBatchList;
	}

	public String getStrBatchNo() {
		return strBatchNo;
	}

	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}

	public String getStrPreInvoiceNo() {
		return strPreInvoiceNo;
	}

	public void setStrPreInvoiceNo(String strPreInvoiceNo) {
		this.strPreInvoiceNo = strPreInvoiceNo;
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
