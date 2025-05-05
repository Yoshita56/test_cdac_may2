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
public class ItemLocationTransFB extends ActionForm {
	
	private static final long serialVersionUID = 02L;
	
	private String strNoramalMsg = "";
	private String strErrorMsg = "";
	private String strWarningMsg = "";
	
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strGenItemId = "";
	private String strItemId = "";
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
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
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
