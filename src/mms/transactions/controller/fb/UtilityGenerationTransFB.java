/**
 * 
 */
package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 18/Jun/09
 */
public class UtilityGenerationTransFB extends ActionForm {
	
	private static final long serialVersionUID = 02L;
	
	private String strNoramalMsg = "";
	private String strErrorMsg = "";
	private String strWarningMsg = "";
	
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strGenItemId = "";
	private String[] strItemId;
	private String strItemName="";
	private String strItemDetail="";
	private String strBatchNo = "";
	private String strBatchItem = "";
	private String strItemSlNo = "";
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strIsSachet = "";
	private String strStockStatusCode = "0";
	private String strStoreId = "0";
	private String strStoreTypeId = "0";
	private String strGenHidItemId = "";
	private String strHidItemId = "";
	private String strHidBatchNo = "";
	private String strReqTypeId = "";
	private String strHidItemSlNo = "";
	private String strReservedFlag = "1";
	
	private String strStoreValues;
	private String strStoreTypeValues;
	private String strItemCategoryCmb = "";
	private String strGroupCmb = "";
	private String strSubGroupCmb = "";
	private String strGenItemCmb = "";
	private String strItemCmb = "";
	private String strItemSlNoCmb = "";
	private String strBatchNoCmb = "";
	private String strStockDetails = "";
	private String strEmplyeeStockDetails = "";
	private String strItemBrandCombo;
	private String strIpNo;
	private String strSurgeryDate;
	private String strPatDetails="";
	private String strPatDetails1="";//used for putting substring values
	private String[] strRate;
	private String strHandlingCharges;
	private String strDiag;
	private String strPatName;
	private String strPuk;
	private String strCat;
	private String strIndentNo;
	private String strDept;
	private String strWard;
	private String strDoctor;
	private String[] strItem;
	private String strStoreName;
	private String strPrintDtls;
	private String strPrintFlag="0";
	private String[] strQty;
	private String strWardCode;
	private String strTreatmentCatCode;
	private String strBillNo;
	private String strDPhoneEmail;
	private String[] strSupplierId;
	private String[] strDCNo;
	private String[] strInvoiceNo;
	private String[] strInvoiceDate;
	private String[] strPONo;
	private String strImpCharges;
	private String strSurgeonName;
	private String strSurgeonDetail;
	private String strSurgeonCharges;
	private String stragesex;
	private String strOrg;
	private String[]  strrSupplier;
	private String strUtilityDtl;
	private String strUtilityDtl1;
	private String strUtilNo;
	private String strCmbIndentNo;
	private String strIndentDtl1;
	private String strIndentDtl;
	private String strPatAccountNo;
	private String strBalanceAmount;
	private String strReportId="";
	private String[] strhidval;
	
	public String[] getStrhidval() {
		return strhidval;
	}
	public void setStrhidval(String[] strhidval) {
		this.strhidval = strhidval;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrPatAccountNo() {
		return strPatAccountNo;
	}
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
	}
	public String getStrBalanceAmount() {
		return strBalanceAmount;
	}
	public void setStrBalanceAmount(String strBalanceAmount) {
		this.strBalanceAmount = strBalanceAmount;
	}
	
	
	public String getStrIndentDtl() {
		return strIndentDtl;
	}
	public void setStrIndentDtl(String strIndentDtl) {
		this.strIndentDtl = strIndentDtl;
	}
	
	
	public String getStrIndentDtl1() {
		return strIndentDtl1;
	}
	public void setStrIndentDtl1(String strIndentDtl1) {
		this.strIndentDtl1 = strIndentDtl1;
	}
	public String getStrCmbIndentNo() {
		return strCmbIndentNo;
	}
	public void setStrCmbIndentNo(String strCmbIndentNo) {
		this.strCmbIndentNo = strCmbIndentNo;
	}
	
	
	public String getStrUtilNo() {
		return strUtilNo;
	}
	public void setStrUtilNo(String strUtilNo) {
		this.strUtilNo = strUtilNo;
	}
	public String getStrUtilityDtl1() {
		return strUtilityDtl1;
	}
	public void setStrUtilityDtl1(String strUtilityDtl1) {
		this.strUtilityDtl1 = strUtilityDtl1;
	}
	public String getStrUtilityDtl() {
		return strUtilityDtl;
	}
	public void setStrUtilityDtl(String strUtilityDtl) {
		this.strUtilityDtl = strUtilityDtl;
	}
	public String[] getStrrSupplier() {
		return strrSupplier;
	}
	public void setStrrSupplier(String[] strrSupplier) {
		this.strrSupplier = strrSupplier;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStrOrg() {
		return strOrg;
	}
	public void setStrOrg(String strOrg) {
		this.strOrg = strOrg;
	}
	
	public String getStragesex() {
		return stragesex;
	}
	public void setStragesex(String stragesex) {
		this.stragesex = stragesex;
	}
	public String getStrImpCharges() {
		return strImpCharges;
	}
	public void setStrImpCharges(String strImpCharges) {
		this.strImpCharges = strImpCharges;
	}
	public String getStrSurgeonName() {
		return strSurgeonName;
	}
	public void setStrSurgeonName(String strSurgeonName) {
		this.strSurgeonName = strSurgeonName;
	}
	public String getStrSurgeonDetail() {
		return strSurgeonDetail;
	}
	public void setStrSurgeonDetail(String strSurgeonDetail) {
		this.strSurgeonDetail = strSurgeonDetail;
	}
	public String getStrSurgeonCharges() {
		return strSurgeonCharges;
	}
	public void setStrSurgeonCharges(String strSurgeonCharges) {
		this.strSurgeonCharges = strSurgeonCharges;
	}
	public String[] getStrSupplierId() {
		return strSupplierId;
	}
	public void setStrSupplierId(String[] strSupplierId) {
		this.strSupplierId = strSupplierId;
	}
	public String[] getStrDCNo() {
		return strDCNo;
	}
	public void setStrDCNo(String[] strDCNo) {
		this.strDCNo = strDCNo;
	}
	public String[] getStrInvoiceNo() {
		return strInvoiceNo;
	}
	public void setStrInvoiceNo(String[] strInvoiceNo) {
		this.strInvoiceNo = strInvoiceNo;
	}
	public String[] getStrInvoiceDate() {
		return strInvoiceDate;
	}
	public void setStrInvoiceDate(String[] strInvoiceDate) {
		this.strInvoiceDate = strInvoiceDate;
	}
	public String[] getStrPONo() {
		return strPONo;
	}
	public void setStrPONo(String[] strPONo) {
		this.strPONo = strPONo;
	}
	public String getStrDPhoneEmail() {
		return strDPhoneEmail;
	}
	public void setStrDPhoneEmail(String strDPhoneEmail) {
		this.strDPhoneEmail = strDPhoneEmail;
	}
	public String getStrBillNo() {
		return strBillNo;
	}
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	public String getStrWardCode() {
		return strWardCode;
	}
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	public String getStrTreatmentCatCode() {
		return strTreatmentCatCode;
	}
	public void setStrTreatmentCatCode(String strTreatmentCatCode) {
		this.strTreatmentCatCode = strTreatmentCatCode;
	}
	public String[] getStrQty() {
		return strQty;
	}
	public void setStrQty(String[] strQty) {
		this.strQty = strQty;
	}
	public String getStrPrintFlag() {
		return strPrintFlag;
	}
	public void setStrPrintFlag(String strPrintFlag) {
		this.strPrintFlag = strPrintFlag;
	}
	public String getStrPrintDtls() {
		return strPrintDtls;
	}
	public void setStrPrintDtls(String strPrintDtls) {
		this.strPrintDtls = strPrintDtls;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrPatName() {
		return strPatName;
	}
	public void setStrPatName(String strPatName) {
		this.strPatName = strPatName;
	}
	public String getStrPuk() {
		return strPuk;
	}
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}
	public String getStrCat() {
		return strCat;
	}
	public void setStrCat(String strCat) {
		this.strCat = strCat;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	public String getStrDept() {
		return strDept;
	}
	public void setStrDept(String strDept) {
		this.strDept = strDept;
	}
	public String getStrWard() {
		return strWard;
	}
	public void setStrWard(String strWard) {
		this.strWard = strWard;
	}
	public String getStrDoctor() {
		return strDoctor;
	}
	public void setStrDoctor(String strDoctor) {
		this.strDoctor = strDoctor;
	}
	public String[] getStrItem() {
		return strItem;
	}
	public void setStrItem(String[] strItem) {
		this.strItem = strItem;
	}
	public String[] getStrSupplier() {
		return strSupplier;
	}
	public void setStrSupplier(String[] strSupplier) {
		this.strSupplier = strSupplier;
	}
	private String[] strSupplier; 
	public String[] getStrRate() {
		return strRate;
	}
	public void setStrRate(String[] strRate) {
		this.strRate = strRate;
	}
	public String getStrHandlingCharges() {
		return strHandlingCharges;
	}
	public void setStrHandlingCharges(String strHandlingCharges) {
		this.strHandlingCharges = strHandlingCharges;
	}
	public String getStrDiag() {
		return strDiag;
	}
	public void setStrDiag(String strDiag) {
		this.strDiag = strDiag;
	}
	public String getStrPatDetails1() {
		return strPatDetails1;
	}
	public void setStrPatDetails1(String strPatDetails1) {
		this.strPatDetails1 = strPatDetails1;
	}
	public String getStrPatDetails() {
		return strPatDetails;
	}
	public void setStrPatDetails(String strPatDetails) {
		this.strPatDetails = strPatDetails;
	}
	public String getStrSurgeryDate() {
		return strSurgeryDate;
	}
	public void setStrSurgeryDate(String strSurgeryDate) {
		this.strSurgeryDate = strSurgeryDate;
	}
	public String getStrIpNo() {
		return strIpNo;
	}
	public void setStrIpNo(String strIpNo) {
		this.strIpNo = strIpNo;
	}
	public String getStrItemBrandCombo() {
		return strItemBrandCombo;
	}
	public void setStrItemBrandCombo(String strItemBrandCombo) {
		this.strItemBrandCombo = strItemBrandCombo;
	}
	/**
	 * @return the strStockDetails
	 */
	public String getStrStockDetails() {
		return strStockDetails;
	}
	/**
	 * @param strStockDetails the strStockDetails to set
	 */
	public void setStrStockDetails(String strStockDetails) {
		this.strStockDetails = strStockDetails;
	}
	/**
	 * @return the strEmplyeeStockDetails
	 */
	public String getStrEmplyeeStockDetails() {
		return strEmplyeeStockDetails;
	}
	/**
	 * @param strEmplyeeStockDetails the strEmplyeeStockDetails to set
	 */
	public void setStrEmplyeeStockDetails(String strEmplyeeStockDetails) {
		this.strEmplyeeStockDetails = strEmplyeeStockDetails;
	}
	/**
	 * @return the strBatchNoCmb
	 */
	public String getStrBatchNoCmb() {
		return strBatchNoCmb;
	}
	/**
	 * @param strBatchNoCmb the strBatchNoCmb to set
	 */
	public void setStrBatchNoCmb(String strBatchNoCmb) {
		this.strBatchNoCmb = strBatchNoCmb;
	}
	/**
	 * @return the strNoramalMsg
	 */
	public String getStrNoramalMsg() {
		return strNoramalMsg;
	}
	/**
	 * @param strNoramalMsg the strNoramalMsg to set
	 */
	public void setStrNoramalMsg(String strNoramalMsg) {
		this.strNoramalMsg = strNoramalMsg;
	}
	/**
	 * @return the strErrorMsg
	 */
	public String getStrErrorMsg() {
		return strErrorMsg;
	}
	/**
	 * @param strErrorMsg the strErrorMsg to set
	 */
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
	}
	/**
	 * @return the strWarningMsg
	 */
	public String getStrWarningMsg() {
		return strWarningMsg;
	}
	/**
	 * @param strWarningMsg the strWarningMsg to set
	 */
	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
	
	
	/**
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}
	/**
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}
	/**
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strGenItemId
	 */
	public String getStrGenItemId() {
		return strGenItemId;
	}
	/**
	 * @param strGenItemId the strGenItemId to set
	 */
	public void setStrGenItemId(String strGenItemId) {
		this.strGenItemId = strGenItemId;
	}
	/**
	 * @return the strItemId
	 */
	public String[] getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String[] strItemId) {
		this.strItemId = strItemId;
	}
	
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	/**
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	/**
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
	}
	
	public String getStrStoreValues() {
		return strStoreValues;
	}
	public void setStrStoreValues(String strStoreValues) {
		this.strStoreValues = strStoreValues;
	}
	
	public String getStrStoreTypeValues() {
		return strStoreTypeValues;
	}
	public void setStrStoreTypeValues(String strStoreTypeValues) {
		this.strStoreTypeValues = strStoreTypeValues;
	}
	/**
	 * @return the strItemCategoryCmb
	 */
	public String getStrItemCategoryCmb() {
		return strItemCategoryCmb;
	}
	/**
	 * @param strItemCategoryCmb the strItemCategoryCmb to set
	 */
	public void setStrItemCategoryCmb(String strItemCategoryCmb) {
		this.strItemCategoryCmb = strItemCategoryCmb;
	}
	/**
	 * @return the strGroupCmb
	 */
	public String getStrGroupCmb() {
		return strGroupCmb;
	}
	/**
	 * @param strGroupCmb the strGroupCmb to set
	 */
	public void setStrGroupCmb(String strGroupCmb) {
		this.strGroupCmb = strGroupCmb;
	}
	/**
	 * @return the strSubGroupCmb
	 */
	public String getStrSubGroupCmb() {
		return strSubGroupCmb;
	}
	/**
	 * @param strSubGroupCmb the strSubGroupCmb to set
	 */
	public void setStrSubGroupCmb(String strSubGroupCmb) {
		this.strSubGroupCmb = strSubGroupCmb;
	}
	/**
	 * @return the strGenItemCmb
	 */
	public String getStrGenItemCmb() {
		return strGenItemCmb;
	}
	/**
	 * @param strGenItemCmb the strGenItemCmb to set
	 */
	public void setStrGenItemCmb(String strGenItemCmb) {
		this.strGenItemCmb = strGenItemCmb;
	}
	/**
	 * @return the strItemCmb
	 */
	public String getStrItemCmb() {
		return strItemCmb;
	}
	/**
	 * @param strItemCmb the strItemCmb to set
	 */
	public void setStrItemCmb(String strItemCmb) {
		this.strItemCmb = strItemCmb;
	}
	/**
	 * @return the strItemSlNoCmb
	 */
	public String getStrItemSlNoCmb() {
		return strItemSlNoCmb;
	}
	/**
	 * @param strItemSlNoCmb the strItemSlNoCmb to set
	 */
	public void setStrItemSlNoCmb(String strItemSlNoCmb) {
		this.strItemSlNoCmb = strItemSlNoCmb;
	}
	/**
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}
	/**
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	
	public String getStrItemDetail() {
		return strItemDetail;
	}
	public void setStrItemDetail(String strItemDetail) {
		this.strItemDetail = strItemDetail;
	}
	/**
	 * @return the strBatchNo
	 */
	public String getStrBatchNo() {
		return strBatchNo;
	}
	/**
	 * @param strBatchNo the strBatchNo to set
	 */
	public void setStrBatchNo(String strBatchNo) {
		this.strBatchNo = strBatchNo;
	}
	/**
	 * @return the strBatchItem
	 */
	public String getStrBatchItem() {
		return strBatchItem;
	}
	/**
	 * @param strBatchItem the strBatchItem to set
	 */
	public void setStrBatchItem(String strBatchItem) {
		this.strBatchItem = strBatchItem;
	}
	/**
	 * @return the strIsSachet
	 */
	public String getStrIsSachet() {
		return strIsSachet;
	}
	/**
	 * @param strIsSachet the strIsSachet to set
	 */
	public void setStrIsSachet(String strIsSachet) {
		this.strIsSachet = strIsSachet;
	}
	/**
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	/**
	 * @return the strGenHidItemId
	 */
	public String getStrGenHidItemId() {
		return strGenHidItemId;
	}
	/**
	 * @param strGenHidItemId the strGenHidItemId to set
	 */
	public void setStrGenHidItemId(String strGenHidItemId) {
		this.strGenHidItemId = strGenHidItemId;
	}
	/**
	 * @return the strHidItemId
	 */
	public String getStrHidItemId() {
		return strHidItemId;
	}
	/**
	 * @param strHidItemId the strHidItemId to set
	 */
	public void setStrHidItemId(String strHidItemId) {
		this.strHidItemId = strHidItemId;
	}
	/**
	 * @return the strHidBatchNo
	 */
	public String getStrHidBatchNo() {
		return strHidBatchNo;
	}
	/**
	 * @param strHidBatchNo the strHidBatchNo to set
	 */
	public void setStrHidBatchNo(String strHidBatchNo) {
		this.strHidBatchNo = strHidBatchNo;
	}
	/**
	 * @return the strReqTypeId
	 */
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	/**
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	/**
	 * @return the strHidItemSlNo
	 */
	public String getStrHidItemSlNo() {
		return strHidItemSlNo;
	}
	/**
	 * @param strHidItemSlNo the strHidItemSlNo to set
	 */
	public void setStrHidItemSlNo(String strHidItemSlNo) {
		this.strHidItemSlNo = strHidItemSlNo;
	}
	/**
	 * @return the strReservedFlag
	 */
	public String getStrReservedFlag() {
		return strReservedFlag;
	}
	/**
	 * @param strReservedFlag the strReservedFlag to set
	 */
	public void setStrReservedFlag(String strReservedFlag) {
		this.strReservedFlag = strReservedFlag;
	}

}
