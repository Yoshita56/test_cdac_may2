package mms.transactions.vo;

import javax.sql.rowset.WebRowSet;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 23/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */


public class SetSachetDetailsTransVO {
	private static final long serialVersionUID = 02L;

	
	private String strMsgType="";
	private String strMsgString="";
	
	private String strCtDate = "";
	private String strHospitalCode = "";
	private String strIsValid = "";

	
	private String strSeatId = "";
	private String strSetId="";
	private String strSetUnitId="";
	private String strSetGenericItemId="";
	private String strNetRate="";
	private String strNetRateUnitId="";
	private String strNetSalePrice="";
	private String strNetSalePriceUnitId="";
	private String strStoreId="";
	private String strStoreNameValues="";
	private WebRowSet StoreNameValuesWS=null;
	private String strPreparedDate="";
	private String strFinancialStartYear="";
	private String strFinancialEndYear="";
	private String strGroupId="";
	private String strGroupNameValues="";
	private WebRowSet strGroupNameValuesWS=null;
	private String strSubGroupId="";
	private String strSubGroupNameValues="";
	private WebRowSet strSubGroupNameValuesWS=null;
	private String strSetSachetId="";
	private String strSetSachetNameValues="";
	private WebRowSet strSetSachetNameValuesWS=null;
	private String strItemName="";
	private String strBrandName="";
	private String strReqQty="";
	private String strAvlQty="";
	private String strUsedQty="";
	private String strUnitName="";
	private String strPreparedQty="";
	private String strExpiryDate="";
	private String strSerialNo="";
	private WebRowSet strItemListWS=null;
	
	private String strStoreTypeId="";
	private String strUnitNameValues="";
	private WebRowSet UnitNameWS=null;
	
	private String strUnitId="";
	
	private int nNoOfItems=0;
	private String strChkValues="";
	private String strRemarks="";
	private String strQtyUnitId="";
	private String strItemId="";
	private String strItemIdArray[]=null;
	private String strBrandId="";
	private String strBrandIdArray[]=null;
	private String strCategoryNoArray[]=null;
	private String strRateArray[]=null;
	private String strRateUnitIdArray[]=null;
	private String strSalePriceArray[]=null;
	private String strSalePriceUnitIdArray[]=null;
	private String strReqQtyUnitId="";
	private String strUsedQtyUnitId="";
	private String strReqQtyUnitIdArray[]=null;
	private String strUsedQtyUnitIdArray[]=null;
	private String strUsedQtyArray[]=null;
	private String strReqQtyArray[]=null;
	private String strReqQtyInInvUnitArray[] = null;
	private String strAvlQtyArray[]=null;
	private String strBrandNameValues="";
	private WebRowSet strBrandNameWS=null;
	
	private WebRowSet strCategoryValuesWS=null;
	private String strSetCategoryNo = "";
	private String strCost[]=null;
	private String strInvUnitIdArray[] = null;
	private String strReqQtyWithPrepQtyArray[] = null;
	 
	
	
	
	/**
	 * @return the strReqQtyInInvUnitArray
	 */
	public String[] getStrReqQtyInInvUnitArray() {
		return strReqQtyInInvUnitArray;
	}
	/**
	 * @param strReqQtyInInvUnitArray the strReqQtyInInvUnitArray to set
	 */
	public void setStrReqQtyInInvUnitArray(String[] strReqQtyInInvUnitArray) {
		this.strReqQtyInInvUnitArray = strReqQtyInInvUnitArray;
	}
	/**
	 * @return the strInvUnitIdArray
	 */
	public String[] getStrInvUnitIdArray() {
		return strInvUnitIdArray;
	}
	/**
	 * @param strInvUnitIdArray the strInvUnitIdArray to set
	 */
	public void setStrInvUnitIdArray(String[] strInvUnitIdArray) {
		this.strInvUnitIdArray = strInvUnitIdArray;
	}
	/**
	 * @return the strCost
	 */
	public String[] getStrCost() {
		return strCost;
	}
	/**
	 * @param strCost the strCost to set
	 */
	public void setStrCost(String[] strCost) {
		this.strCost = strCost;
	}
	public String getStrBrandId() {
		return strBrandId;
	}
	public void setStrBrandId(String strBrandId) {
		this.strBrandId = strBrandId;
	}
	public String getStrReqQtyUnitId() {
		return strReqQtyUnitId;
	}
	public void setStrReqQtyUnitId(String strReqQtyUnitId) {
		this.strReqQtyUnitId = strReqQtyUnitId;
	}
	public String getStrUsedQtyUnitId() {
		return strUsedQtyUnitId;
	}
	public void setStrUsedQtyUnitId(String strUsedQtyUnitId) {
		this.strUsedQtyUnitId = strUsedQtyUnitId;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	
	public String getStrCtDate() {
		return strCtDate;
	}
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrIsValid() {
		return strIsValid;
	}
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrSetId() {
		return strSetId;
	}
	public void setStrSetId(String strSetId) {
		this.strSetId = strSetId;
	}
	
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrStoreNameValues() {
		return strStoreNameValues;
	}
	public void setStrStoreNameValues(String strStoreNameValues) {
		this.strStoreNameValues = strStoreNameValues;
	}
	public String getStrPreparedDate() {
		return strPreparedDate;
	}
	public void setStrPreparedDate(String strPreparedDate) {
		this.strPreparedDate = strPreparedDate;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrGroupId() {
		return strGroupId;
	}
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	public String getStrGroupNameValues() {
		return strGroupNameValues;
	}
	public void setStrGroupNameValues(String strGroupNameValues) {
		this.strGroupNameValues = strGroupNameValues;
	}
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	public String getStrSubGroupNameValues() {
		return strSubGroupNameValues;
	}
	public void setStrSubGroupNameValues(String strSubGroupNameValues) {
		this.strSubGroupNameValues = strSubGroupNameValues;
	}
	public String getStrSetSachetId() {
		return strSetSachetId;
	}
	public void setStrSetSachetId(String strSetSachetId) {
		this.strSetSachetId = strSetSachetId;
	}
	public String getStrSetSachetNameValues() {
		return strSetSachetNameValues;
	}
	public void setStrSetSachetNameValues(String strSetSachetNameValues) {
		this.strSetSachetNameValues = strSetSachetNameValues;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	public String getStrBrandName() {
		return strBrandName;
	}
	public void setStrBrandName(String strBrandName) {
		this.strBrandName = strBrandName;
	}
	public String getStrReqQty() {
		return strReqQty;
	}
	public void setStrReqQty(String strReqQty) {
		this.strReqQty = strReqQty;
	}
	public String getStrAvlQty() {
		return strAvlQty;
	}
	public void setStrAvlQty(String strAvlQty) {
		this.strAvlQty = strAvlQty;
	}
	public String getStrUsedQty() {
		return strUsedQty;
	}
	public void setStrUsedQty(String strUsedQty) {
		this.strUsedQty = strUsedQty;
	}
	public String getStrUnitName() {
		return strUnitName;
	}
	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}
	public String getStrPreparedQty() {
		return strPreparedQty;
	}
	public void setStrPreparedQty(String strPreparedQty) {
		this.strPreparedQty = strPreparedQty;
	}
	
	public String getStrExpiryDate() {
		return strExpiryDate;
	}
	public void setStrExpiryDate(String strExpiryDate) {
		this.strExpiryDate = strExpiryDate;
	}
	public String getStrSerialNo() {
		return strSerialNo;
	}
	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public WebRowSet getStoreNameValuesWS() {
		return StoreNameValuesWS;
	}
	public void setStoreNameValuesWS(WebRowSet storeNameValuesWS) {
		StoreNameValuesWS = storeNameValuesWS;
	}
	public WebRowSet getStrGroupNameValuesWS() {
		return strGroupNameValuesWS;
	}
	public void setStrGroupNameValuesWS(WebRowSet strGroupNameValuesWS) {
		this.strGroupNameValuesWS = strGroupNameValuesWS;
	}
	public WebRowSet getStrSubGroupNameValuesWS() {
		return strSubGroupNameValuesWS;
	}
	public void setStrSubGroupNameValuesWS(WebRowSet strSubGroupNameValuesWS) {
		this.strSubGroupNameValuesWS = strSubGroupNameValuesWS;
	}
	public WebRowSet getStrSetSachetNameValuesWS() {
		return strSetSachetNameValuesWS;
	}
	public void setStrSetSachetNameValuesWS(WebRowSet strSetSachetNameValuesWS) {
		this.strSetSachetNameValuesWS = strSetSachetNameValuesWS;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	/**
	 * @return the strStoreTypeId
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}
	/**
	 * @param strStoreTypeId the strStoreTypeId to set
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}
	public WebRowSet getStrItemListWS() {
		return strItemListWS;
	}
	public void setStrItemListWS(WebRowSet strItemListWS) {
		this.strItemListWS = strItemListWS;
	}
	public String getStrUnitNameValues() {
		return strUnitNameValues;
	}
	public void setStrUnitNameValues(String strUnitNameValues) {
		this.strUnitNameValues = strUnitNameValues;
	}
	public WebRowSet getUnitNameWS() {
		return UnitNameWS;
	}
	public void setUnitNameWS(WebRowSet unitNameWS) {
		UnitNameWS = unitNameWS;
	}
	public String getStrUnitId() {
		return strUnitId;
	}
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
	}
	public int getNNoOfItems() {
		return nNoOfItems;
	}
	public void setNNoOfItems(int noOfItems) {
		nNoOfItems = noOfItems;
	}
	public String getStrChkValues() {
		return strChkValues;
	}
	public void setStrChkValues(String strChkValues) {
		this.strChkValues = strChkValues;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrQtyUnitId() {
		return strQtyUnitId;
	}
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}
	public String getStrBrandNameValues() {
		return strBrandNameValues;
	}
	public void setStrBrandNameValues(String strBrandNameValues) {
		this.strBrandNameValues = strBrandNameValues;
	}
	public WebRowSet getStrBrandNameWS() {
		return strBrandNameWS;
	}
	public void setStrBrandNameWS(WebRowSet strBrandNameWS) {
		this.strBrandNameWS = strBrandNameWS;
	}
	public String[] getStrItemIdArray() {
		return strItemIdArray;
	}
	public void setStrItemIdArray(String[] strItemIdArray) {
		this.strItemIdArray = strItemIdArray;
	}
	public String[] getStrBrandIdArray() {
		return strBrandIdArray;
	}
	public void setStrBrandIdArray(String[] strBrandIdArray) {
		this.strBrandIdArray = strBrandIdArray;
	}
	public String[] getStrReqQtyUnitIdArray() {
		return strReqQtyUnitIdArray;
	}
	public void setStrReqQtyUnitIdArray(String[] strReqQtyUnitIdArray) {
		this.strReqQtyUnitIdArray = strReqQtyUnitIdArray;
	}
	public String[] getStrUsedQtyUnitIdArray() {
		return strUsedQtyUnitIdArray;
	}
	public void setStrUsedQtyUnitIdArray(String[] strUsedQtyUnitIdArray) {
		this.strUsedQtyUnitIdArray = strUsedQtyUnitIdArray;
	}
	public String[] getStrUsedQtyArray() {
		return strUsedQtyArray;
	}
	public void setStrUsedQtyArray(String[] strUsedQtyArray) {
		this.strUsedQtyArray = strUsedQtyArray;
	}
	public String[] getStrReqQtyArray() {
		return strReqQtyArray;
	}
	public void setStrReqQtyArray(String[] strReqQtyArray) {
		this.strReqQtyArray = strReqQtyArray;
	}
	/**
	 * @return the strCategoryValuesWS
	 */
	public WebRowSet getStrCategoryValuesWS() {
		return strCategoryValuesWS;
	}
	/**
	 * @param strCategoryValuesWS the strCategoryValuesWS to set
	 */
	public void setStrCategoryValuesWS(WebRowSet strCategoryValuesWS) {
		this.strCategoryValuesWS = strCategoryValuesWS;
	}
	
	/**
	 * @return the strAvlQtyArray
	 */
	public String[] getStrAvlQtyArray() {
		return strAvlQtyArray;
	}
	/**
	 * @param strAvlQtyArray the strAvlQtyArray to set
	 */
	public void setStrAvlQtyArray(String[] strAvlQtyArray) {
		this.strAvlQtyArray = strAvlQtyArray;
	}
	/**
	 * @return the strNetRate
	 */
	public String getStrNetRate() {
		return strNetRate;
	}
	/**
	 * @param strNetRate the strNetRate to set
	 */
	public void setStrNetRate(String strNetRate) {
		this.strNetRate = strNetRate;
	}
	/**
	 * @return the strNetRateUnitId
	 */
	public String getStrNetRateUnitId() {
		return strNetRateUnitId;
	}
	/**
	 * @param strNetRateUnitId the strNetRateUnitId to set
	 */
	public void setStrNetRateUnitId(String strNetRateUnitId) {
		this.strNetRateUnitId = strNetRateUnitId;
	}
	/**
	 * @return the strNetSalePrice
	 */
	public String getStrNetSalePrice() {
		return strNetSalePrice;
	}
	/**
	 * @param strNetSalePrice the strNetSalePrice to set
	 */
	public void setStrNetSalePrice(String strNetSalePrice) {
		this.strNetSalePrice = strNetSalePrice;
	}
	/**
	 * @return the strNetSalePriceUnitId
	 */
	public String getStrNetSalePriceUnitId() {
		return strNetSalePriceUnitId;
	}
	/**
	 * @param strNetSalePriceUnitId the strNetSalePriceUnitId to set
	 */
	public void setStrNetSalePriceUnitId(String strNetSalePriceUnitId) {
		this.strNetSalePriceUnitId = strNetSalePriceUnitId;
	}
	/**
	 * @return the strCategoryNoArray
	 */
	public String[] getStrCategoryNoArray() {
		return strCategoryNoArray;
	}
	/**
	 * @param strCategoryNoArray the strCategoryNoArray to set
	 */
	public void setStrCategoryNoArray(String[] strCategoryNoArray) {
		this.strCategoryNoArray = strCategoryNoArray;
	}
	/**
	 * @return the strRateArray
	 */
	public String[] getStrRateArray() {
		return strRateArray;
	}
	/**
	 * @param strRateArray the strRateArray to set
	 */
	public void setStrRateArray(String[] strRateArray) {
		this.strRateArray = strRateArray;
	}
	/**
	 * @return the strRateUnitIdArray
	 */
	public String[] getStrRateUnitIdArray() {
		return strRateUnitIdArray;
	}
	/**
	 * @param strRateUnitIdArray the strRateUnitIdArray to set
	 */
	public void setStrRateUnitIdArray(String[] strRateUnitIdArray) {
		this.strRateUnitIdArray = strRateUnitIdArray;
	}
	/**
	 * @return the strSalePriceArray
	 */
	public String[] getStrSalePriceArray() {
		return strSalePriceArray;
	}
	/**
	 * @param strSalePriceArray the strSalePriceArray to set
	 */
	public void setStrSalePriceArray(String[] strSalePriceArray) {
		this.strSalePriceArray = strSalePriceArray;
	}
	/**
	 * @return the strSalePriceUnitIdArray
	 */
	public String[] getStrSalePriceUnitIdArray() {
		return strSalePriceUnitIdArray;
	}
	/**
	 * @param strSalePriceUnitIdArray the strSalePriceUnitIdArray to set
	 */
	public void setStrSalePriceUnitIdArray(String[] strSalePriceUnitIdArray) {
		this.strSalePriceUnitIdArray = strSalePriceUnitIdArray;
	}
	
	/**
	 * @return the strSetCategoryNo
	 */
	public String getStrSetCategoryNo() {
		return strSetCategoryNo;
	}
	/**
	 * @param strSetCategoryNo the strSetCategoryNo to set
	 */
	public void setStrSetCategoryNo(String strSetCategoryNo) {
		this.strSetCategoryNo = strSetCategoryNo;
	}
	/**
	 * @return the strReqQtyWithPrepQtyArray
	 */
	public String[] getStrReqQtyWithPrepQtyArray() {
		return strReqQtyWithPrepQtyArray;
	}
	/**
	 * @param strReqQtyWithPrepQtyArray the strReqQtyWithPrepQtyArray to set
	 */
	public void setStrReqQtyWithPrepQtyArray(String[] strReqQtyWithPrepQtyArray) {
		this.strReqQtyWithPrepQtyArray = strReqQtyWithPrepQtyArray;
	}
	/**
	 * @return the strSetGenericItemId
	 */
	public String getStrSetGenericItemId() {
		return strSetGenericItemId;
	}
	/**
	 * @param strSetGenericItemId the strSetGenericItemId to set
	 */
	public void setStrSetGenericItemId(String strSetGenericItemId) {
		this.strSetGenericItemId = strSetGenericItemId;
	}
	/**
	 * @return the strSetUnitId
	 */
	public String getStrSetUnitId() {
		return strSetUnitId;
	}
	/**
	 * @param strSetUnitId the strSetUnitId to set
	 */
	public void setStrSetUnitId(String strSetUnitId) {
		this.strSetUnitId = strSetUnitId;
	}
	
	
	

}
