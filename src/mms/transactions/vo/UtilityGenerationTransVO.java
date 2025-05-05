/**
 * 
 */
package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.TransferObject;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 18/Jun/09
 */
public class UtilityGenerationTransVO implements TransferObject {
	
	private static final long serialVersionUID = 02L;
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strStoreTypeId = "";
	private String strItemCategoryNo = "10";
	private String strGroupId = "0";
	private String strSubGroupId = "0";
	private String strGenItemId = "0";
	private String[] strItemId ;
	private String strItemName="";
	private String strBatchNo = "";
	private String strBatchItem = "";
	private String strItemSlNo = "";
	private String strHospitalCode = "";
	private String strSeatId = "";
	private String strIsValid = "";
	private String strIsSachet = "";
	private String strStockStatusCode = "";
	private String strStoreId = "";
	private String strReqTypeId = "";
	private String strReservedFlag = "";
	
	private String strIsBatchNo = "0";
	private String strIsSlNo = "0"; 
	private String strMode;
	private String[] strhidval;
	
	public String[] getStrhidval() {
		return strhidval;
	}
	public void setStrhidval(String[] strhidval) {
		this.strhidval = strhidval;
	}
	
	//WebRowSet
	private WebRowSet strStoreWs=null;
	private WebRowSet strStoreTypeWs=null;
	private WebRowSet itemCategoryWS = null;
	private WebRowSet groupWS = null;
	private WebRowSet subGroupWS = null;
	private WebRowSet genItemWS = null;
	private WebRowSet itemWS = null;
	private WebRowSet batchNoWS = null;
	private WebRowSet itemSlNoWS = null;
	private WebRowSet stockDetailsWS = null;
	private WebRowSet emplyeeStockDetailsWS = null;
	private String strIpNo;
	private String strCtDate = "";
	private String strSurgeryDate;
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
	private String strUTNo;
	private String[] strSupplier;
	private String strStoreName;
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
	private WebRowSet utilityNoWS = null;
	private String strUtilNo;
	private String strCmbIndentNo;
	private WebRowSet indentNoWS = null;
	private String strBillingHiddenValue;
	private String strPatAccountNo;
	private String strBalanceAmount;
	private String[] strrSupplierId;
	
	public String[] getStrrSupplierId() {
		return strrSupplierId;
	}
	public void setStrrSupplierId(String[] strrSupplierId) {
		this.strrSupplierId = strrSupplierId;
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
	public String getStrBillingHiddenValue() {
		return strBillingHiddenValue;
	}
	public void setStrBillingHiddenValue(String strBillingHiddenValue) {
		this.strBillingHiddenValue = strBillingHiddenValue;
	}
	public WebRowSet getIndentNoWS() {
		return indentNoWS;
	}
	public void setIndentNoWS(WebRowSet indentNoWS) {
		this.indentNoWS = indentNoWS;
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
	public WebRowSet getUtilityNoWS() {
		return utilityNoWS;
	}
	public void setUtilityNoWS(WebRowSet utilityNoWS) {
		this.utilityNoWS = utilityNoWS;
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
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String[] getStrSupplier() {
		return strSupplier;
	}
	public void setStrSupplier(String[] strSupplier) {
		this.strSupplier = strSupplier;
	}
	public String getStrUTNo() {
		return strUTNo;
	}
	public void setStrUTNo(String strUTNo) {
		this.strUTNo = strUTNo;
	}
	public String getStrSurgeryDate() {
		return strSurgeryDate;
	}
	public void setStrSurgeryDate(String strSurgeryDate) {
		this.strSurgeryDate = strSurgeryDate;
	}
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
	
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrIpNo() {
		return strIpNo;
	}
	public void setStrIpNo(String strIpNo) {
		this.strIpNo = strIpNo;
	}
	
	
	
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	
	public WebRowSet getStrStoreTypeWs() {
		return strStoreTypeWs;
	}
	public void setStrStoreTypeWs(WebRowSet strStoreTypeWs) {
		this.strStoreTypeWs = strStoreTypeWs;
	}
	/**
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}
	/**
	 * @param itemCategoryWS the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}
	/**
	 * @return the groupWS
	 */
	public WebRowSet getGroupWS() {
		return groupWS;
	}
	/**
	 * @param groupWS the groupWS to set
	 */
	public void setGroupWS(WebRowSet groupWS) {
		this.groupWS = groupWS;
	}
	/**
	 * @return the subGroupWS
	 */
	public WebRowSet getSubGroupWS() {
		return subGroupWS;
	}
	/**
	 * @param subGroupWS the subGroupWS to set
	 */
	public void setSubGroupWS(WebRowSet subGroupWS) {
		this.subGroupWS = subGroupWS;
	}
	/**
	 * @return the genItemWS
	 */
	public WebRowSet getGenItemWS() {
		return genItemWS;
	}
	/**
	 * @param genItemWS the genItemWS to set
	 */
	public void setGenItemWS(WebRowSet genItemWS) {
		this.genItemWS = genItemWS;
	}
	/**
	 * @return the itemWS
	 */
	public WebRowSet getItemWS() {
		return itemWS;
	}
	/**
	 * @param itemWS the itemWS to set
	 */
	public void setItemWS(WebRowSet itemWS) {
		this.itemWS = itemWS;
	}
	/**
	 * @return the itemSlNoWS
	 */
	public WebRowSet getItemSlNoWS() {
		return itemSlNoWS;
	}
	/**
	 * @param itemSlNoWS the itemSlNoWS to set
	 */
	public void setItemSlNoWS(WebRowSet itemSlNoWS) {
		this.itemSlNoWS = itemSlNoWS;
	}
	/**
	 * @return the strMsgString
	 */
	public String getStrMsgString() {
		return strMsgString;
	}
	/**
	 * @param strMsgString the strMsgString to set
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	/**
	 * @return the strMsgType
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	/**
	 * @param strMsgType the strMsgType to set
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
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
	 * @return the batchNoWS
	 */
	public WebRowSet getBatchNoWS() {
		return batchNoWS;
	}
	/**
	 * @param batchNoWS the batchNoWS to set
	 */
	public void setBatchNoWS(WebRowSet batchNoWS) {
		this.batchNoWS = batchNoWS;
	}
	/**
	 * @return the stockDetails
	 */
	public WebRowSet getStockDetailsWS() {
		return stockDetailsWS;
	}
	/**
	 * @param stockDetails the stockDetails to set
	 */
	public void setStockDetailsWS(WebRowSet stockDetailsWS) {
		this.stockDetailsWS = stockDetailsWS;
	}
	/**
	 * @return the emplyeeStockDetails
	 */
	public WebRowSet getEmplyeeStockDetailsWS() {
		return emplyeeStockDetailsWS;
	}
	/**
	 * @param emplyeeStockDetails the emplyeeStockDetails to set
	 */
	public void setEmplyeeStockDetailsWS(WebRowSet emplyeeStockDetailsWS) {
		this.emplyeeStockDetailsWS = emplyeeStockDetailsWS;
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
	 * @return the strIsBatchNo
	 */
	public String getStrIsBatchNo() {
		return strIsBatchNo;
	}
	/**
	 * @param strIsBatchNo the strIsBatchNo to set
	 */
	public void setStrIsBatchNo(String strIsBatchNo) {
		this.strIsBatchNo = strIsBatchNo;
	}
	/**
	 * @return the strIsSlNo
	 */
	public String getStrIsSlNo() {
		return strIsSlNo;
	}
	/**
	 * @param strIsSlNo the strIsSlNo to set
	 */
	public void setStrIsSlNo(String strIsSlNo) {
		this.strIsSlNo = strIsSlNo;
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
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}

	

}
