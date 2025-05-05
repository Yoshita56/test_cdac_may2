/**
 * 
 */
package mms.transactions.controller.fb;

import org.apache.struts.action.ActionForm;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 23/June/2009
 * 
 */
public class BillApprovalOtherTransFB  extends ActionForm {
	
	private static final long serialVersionUID = 02L;

	private String strErrMsg = "";
	private String strNormalMsg = "";
	private String strWarningMsg = "";
	private String strCurrentDate = "";
	private String strHospitalCode = "";
	private String strPONetAmount = "";
	private String strAgentName = "";
	private String strAgentNameShow = "";
	private String strCAName = "";
	private String strSeatId = "";
	private String strPONoH = "";
	private String strPOPrefix="";
	private String strStoreId="";
	private String strStoreName=""; 
	private String strBillTypeName="";
	private String strPONo="0";
	private String strPODate="";
	private String strPOType="";
	private String strSupplierName="";
	private String strItemCategoryNameH="";
	private String strCurrencyName="";
	private String strCurrencyValue="";
	private String strBillNo="";
	private String strBillDate=""; 
	private String strBillAmount="";
	private String strSupplierId="";
	private String strPOStoreId="";
	private String strPOTypeId=""; 
	private String strPath="";  
	private String strBillType=""; 
	private String strRemarks="";
	private String strItemCategoryNoH=""; 
	private String strCurrencyId=""; 
	private String strComboValue=""; 

	
	private String strPONoCmb="";  
	
	private String strPOStoreName="";
	
	/*private String strOverallPOTax=""; 
	private String strAdvanceTaken=""; 
	private String strAdvanceAdjusted=""; 
	private String strNetPenalty=""; 
	*/


	/**
	 * @return the strPOStoreName
	 */
	public String getStrPOStoreName() {
		return strPOStoreName;
	}


	/**
	 * @param strPOStoreName the strPOStoreName to set
	 */
	public void setStrPOStoreName(String strPOStoreName) {
		this.strPOStoreName = strPOStoreName;
	}


	/**
	 * @return the strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}


	/**
	 * @param strErrMsg the strErrMsg to set
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}


	/**
	 * @return the strNormalMsg
	 */
	public String getStrNormalMsg() {
		return strNormalMsg;
	}


	/**
	 * @param strNormalMsg the strNormalMsg to set
	 */
	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
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
	 * @return the strCurrentDate
	 */
	public String getStrCurrentDate() {
		return strCurrentDate;
	}


	/**
	 * @param strCurrentDate the strCurrentDate to set
	 */
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	 * @return the strStoreName
	 */
	public String getStrStoreName() {
		return strStoreName;
	}


	/**
	 * @param strStoreName the strStoreName to set
	 */
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}


	/**
	 * @return the strBillTypeName
	 */
	public String getStrBillTypeName() {
		return strBillTypeName;
	}


	/**
	 * @param strBillTypeName the strBillTypeName to set
	 */
	public void setStrBillTypeName(String strBillTypeName) {
		this.strBillTypeName = strBillTypeName;
	}


	/**
	 * @return the strPONo
	 */
	public String getStrPONo() {
		return strPONo;
	}


	/**
	 * @param strPONo the strPONo to set
	 */
	public void setStrPONo(String strPONo) {
		this.strPONo = strPONo;
	}


	/**
	 * @return the strPODate
	 */
	public String getStrPODate() {
		return strPODate;
	}


	/**
	 * @param strPODate the strPODate to set
	 */
	public void setStrPODate(String strPODate) {
		this.strPODate = strPODate;
	}


	/**
	 * @return the strPOType
	 */
	public String getStrPOType() {
		return strPOType;
	}


	/**
	 * @param strPOType the strPOType to set
	 */
	public void setStrPOType(String strPOType) {
		this.strPOType = strPOType;
	}


	/**
	 * @return the strSupplierName
	 */
	public String getStrSupplierName() {
		return strSupplierName;
	}


	/**
	 * @param strSupplierName the strSupplierName to set
	 */
	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}


	/**
	 * @return the strItemCategoryNameH
	 */
	public String getStrItemCategoryNameH() {
		return strItemCategoryNameH;
	}


	/**
	 * @param strItemCategoryNameH the strItemCategoryNameH to set
	 */
	public void setStrItemCategoryNameH(String strItemCategoryNameH) {
		this.strItemCategoryNameH = strItemCategoryNameH;
	}


	/**
	 * @return the strCurrencyName
	 */
	public String getStrCurrencyName() {
		return strCurrencyName;
	}


	/**
	 * @param strCurrencyName the strCurrencyName to set
	 */
	public void setStrCurrencyName(String strCurrencyName) {
		this.strCurrencyName = strCurrencyName;
	}


	/**
	 * @return the strCurrencyValue
	 */
	public String getStrCurrencyValue() {
		return strCurrencyValue;
	}


	/**
	 * @param strCurrencyValue the strCurrencyValue to set
	 */
	public void setStrCurrencyValue(String strCurrencyValue) {
		this.strCurrencyValue = strCurrencyValue;
	}


	/**
	 * @return the strBillNo
	 */
	public String getStrBillNo() {
		return strBillNo;
	}


	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}


	/**
	 * @return the strBillDate
	 */
	public String getStrBillDate() {
		return strBillDate;
	}


	/**
	 * @param strBillDate the strBillDate to set
	 */
	public void setStrBillDate(String strBillDate) {
		this.strBillDate = strBillDate;
	}


	/**
	 * @return the strBillAmount
	 */
	public String getStrBillAmount() {
		return strBillAmount;
	}


	/**
	 * @param strBillAmount the strBillAmount to set
	 */
	public void setStrBillAmount(String strBillAmount) {
		this.strBillAmount = strBillAmount;
	}


	/**
	 * @return the strSupplierId
	 */
	public String getStrSupplierId() {
		return strSupplierId;
	}


	/**
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}


	/**
	 * @return the strPOStoreId
	 */
	public String getStrPOStoreId() {
		return strPOStoreId;
	}


	/**
	 * @param strPOStoreId the strPOStoreId to set
	 */
	public void setStrPOStoreId(String strPOStoreId) {
		this.strPOStoreId = strPOStoreId;
	}


	/**
	 * @return the strPOTypeId
	 */
	public String getStrPOTypeId() {
		return strPOTypeId;
	}


	/**
	 * @param strPOTypeId the strPOTypeId to set
	 */
	public void setStrPOTypeId(String strPOTypeId) {
		this.strPOTypeId = strPOTypeId;
	}


	/**
	 * @return the strPath
	 */
	public String getStrPath() {
		return strPath;
	}


	/**
	 * @param strPath the strPath to set
	 */
	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}


	/**
	 * @return the strBillType
	 */
	public String getStrBillType() {
		return strBillType;
	}


	/**
	 * @param strBillType the strBillType to set
	 */
	public void setStrBillType(String strBillType) {
		this.strBillType = strBillType;
	}


	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}


	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}


	/**
	 * @return the strItemCategoryNoH
	 */
	public String getStrItemCategoryNoH() {
		return strItemCategoryNoH;
	}


	/**
	 * @param strItemCategoryNoH the strItemCategoryNoH to set
	 */
	public void setStrItemCategoryNoH(String strItemCategoryNoH) {
		this.strItemCategoryNoH = strItemCategoryNoH;
	}


	/**
	 * @return the strCurrencyId
	 */
	public String getStrCurrencyId() {
		return strCurrencyId;
	}


	/**
	 * @param strCurrencyId the strCurrencyId to set
	 */
	public void setStrCurrencyId(String strCurrencyId) {
		this.strCurrencyId = strCurrencyId;
	}


	/**
	 * @return the strPONoCmb
	 */
	public String getStrPONoCmb() {
		return strPONoCmb;
	}


	/**
	 * @param strPONoCmb the strPONoCmb to set
	 */
	public void setStrPONoCmb(String strPONoCmb) {
		this.strPONoCmb = strPONoCmb;
	}


	/**
	 * @return the strComboValue
	 */
	public String getStrComboValue() {
		return strComboValue;
	}


	/**
	 * @param strComboValue the strComboValue to set
	 */
	public void setStrComboValue(String strComboValue) {
		this.strComboValue = strComboValue;
	}


	/**
	 * @return the strPOPrefix
	 */
	public String getStrPOPrefix() {
		return strPOPrefix;
	}


	/**
	 * @param strPOPrefix the strPOPrefix to set
	 */
	public void setStrPOPrefix(String strPOPrefix) {
		this.strPOPrefix = strPOPrefix;
	}


	/**
	 * @return the strPONoH
	 */
	public String getStrPONoH() {
		return strPONoH;
	}


	/**
	 * @param strPONoH the strPONoH to set
	 */
	public void setStrPONoH(String strPONoH) {
		this.strPONoH = strPONoH;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	public String getStrPONetAmount() {
		return strPONetAmount;
	}


	public String getStrAgentName() {
		return strAgentName;
	}


	public String getStrAgentNameShow() {
		return strAgentNameShow;
	}


	public String getStrCAName() {
		return strCAName;
	}


	public void setStrPONetAmount(String strPONetAmount) {
		this.strPONetAmount = strPONetAmount;
	}


	public void setStrAgentName(String strAgentName) {
		this.strAgentName = strAgentName;
	}


	public void setStrAgentNameShow(String strAgentNameShow) {
		this.strAgentNameShow = strAgentNameShow;
	}


	public void setStrCAName(String strCAName) {
		this.strCAName = strCAName;
	}


	
	

}
