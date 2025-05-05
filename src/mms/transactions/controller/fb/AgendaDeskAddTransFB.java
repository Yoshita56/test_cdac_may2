/**
 * 
 */
package mms.transactions.controller.fb;

import javax.sql.rowset.WebRowSet;

import org.apache.struts.action.ActionForm;

/**
 * @author Pankaj Kumar
 *
 */
public class AgendaDeskAddTransFB  extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strMsgType="";
	private String strErr="";
	private String strWarning="";
	private String strMsg="";
	private String strToStore="";
	private String strToStoreValues="";
	private String strItemCat="";
	private String strItemCatValues="";
	private String strAgendaPeriod="";

	private String strIndentDetails="";
	private String strMsgString="";
	private String strRemarks="";
	private String strHospitalCode="";
	private String strSeatId="";
	private String strStoreId="";
	private String strAgendaStatus="";
	private String[] strCheckBox=null;
	private String strGrantTypeValues="";
	private String strGrantTypeId="";
	private String strPopupId="";
	private String strStoreName="";
	private String strItemCatName="";
	private String strItemPopupData="";
	private String strItemId="";
	private String strRateUnitValues="";
	private String strAgendaPeriodValue ="";
	
	private WebRowSet wbIndentDetail=null; 
	private WebRowSet wbIndentItemDetail=null;
	
	private String[] strDApproxRateUnit = null;
	private String[] strDApproxRate = null;
	private String[] strDitemId = null;
	private String[] strDitemBrandId = null;
	private String[] strDGroupId = null;
	private String[] strDSubGroupId = null;
	private String[] strDCompiledQty = null;
	private String[] strDCompiledQtyUnit = null;
	private String[] strDReqestNo = null;
	private String[] strDReqestDate = null;
	private String[] strDReqestPeriod = null;
	private String[] strDRaisingStore = null;
	private String[] strDLstPoNo = null;
	private String[] strDLstPoDate = null;
	private String[] strDLstSupplierId = null;
	private String[] strDLstRecQty = null;
	private String[] strDLstRecQtyUnit = null;
	private String[] strDLstRecDate = null;
	private String[] strDLstPurRate = null;
	private String[] strDLstPurRateUnit  = null;
	private String[] strCheckBoxItem = null;
	
	private String strStoreIds="";
	private String strRequestIds="";
	private String strItemIds="";
	private String strItemBrandIds="";
	private String strIndentNo;
	private String strItemName;
	private String strSDFFlgColor ;
	
	private String strAgendaType;
	
	public String getStrSDFFlgColor() {
		return strSDFFlgColor;
	}
	public void setStrSDFFlgColor(String strSDFFlgColor) {
		this.strSDFFlgColor = strSDFFlgColor;
	}

	public String getStrAgendaType() {
		return strAgendaType;
	}
	public void setStrAgendaType(String strAgendaType) {
		this.strAgendaType = strAgendaType;
	}
	public String getStrIndentNo() {
		return strIndentNo;
	}
	public void setStrIndentNo(String strIndentNo) {
		this.strIndentNo = strIndentNo;
	}
	/**
	 * @return the strStoreIds
	 */
	public String getStrStoreIds() {
		return strStoreIds;
	}
	/**
	 * @param strStoreIds the strStoreIds to set
	 */
	public void setStrStoreIds(String strStoreIds) {
		this.strStoreIds = strStoreIds;
	}
	/**
	 * @return the strRequestIds
	 */
	public String getStrRequestIds() {
		return strRequestIds;
	}
	/**
	 * @param strRequestIds the strRequestIds to set
	 */
	public void setStrRequestIds(String strRequestIds) {
		this.strRequestIds = strRequestIds;
	}
	/**
	 * @return the strItemIds
	 */
	public String getStrItemIds() {
		return strItemIds;
	}
	/**
	 * @param strItemIds the strItemIds to set
	 */
	public void setStrItemIds(String strItemIds) {
		this.strItemIds = strItemIds;
	}
	/**
	 * @return the strItemBrandIds
	 */
	public String getStrItemBrandIds() {
		return strItemBrandIds;
	}
	/**
	 * @param strItemBrandIds the strItemBrandIds to set
	 */
	public void setStrItemBrandIds(String strItemBrandIds) {
		this.strItemBrandIds = strItemBrandIds;
	}
	/**
	 * @return the strCheckBoxItem
	 */
	public String[] getStrCheckBoxItem() {
		return strCheckBoxItem;
	}
	/**
	 * @param strCheckBoxItem the strCheckBoxItem to set
	 */
	public void setStrCheckBoxItem(String[] strCheckBoxItem) {
		this.strCheckBoxItem = strCheckBoxItem;
	}
	/**
	 * @return the strDApproxRateUnit
	 */
	public String[] getStrDApproxRateUnit() {
		return strDApproxRateUnit;
	}
	/**
	 * @param strDApproxRateUnit the strDApproxRateUnit to set
	 */
	public void setStrDApproxRateUnit(String[] strDApproxRateUnit) {
		this.strDApproxRateUnit = strDApproxRateUnit;
	}
	/**
	 * @return the strDApproxRate
	 */
	public String[] getStrDApproxRate() {
		return strDApproxRate;
	}
	/**
	 * @param strDApproxRate the strDApproxRate to set
	 */
	public void setStrDApproxRate(String[] strDApproxRate) {
		this.strDApproxRate = strDApproxRate;
	}
	/**
	 * @return the strDitemId
	 */
	public String[] getStrDitemId() {
		return strDitemId;
	}
	/**
	 * @param strDitemId the strDitemId to set
	 */
	public void setStrDitemId(String[] strDitemId) {
		this.strDitemId = strDitemId;
	}
	/**
	 * @return the strDitemBrandId
	 */
	public String[] getStrDitemBrandId() {
		return strDitemBrandId;
	}
	/**
	 * @param strDitemBrandId the strDitemBrandId to set
	 */
	public void setStrDitemBrandId(String[] strDitemBrandId) {
		this.strDitemBrandId = strDitemBrandId;
	}
	/**
	 * @return the strDGroupId
	 */
	public String[] getStrDGroupId() {
		return strDGroupId;
	}
	/**
	 * @param strDGroupId the strDGroupId to set
	 */
	public void setStrDGroupId(String[] strDGroupId) {
		this.strDGroupId = strDGroupId;
	}
	/**
	 * @return the strDSubGroupId
	 */
	public String[] getStrDSubGroupId() {
		return strDSubGroupId;
	}
	/**
	 * @param strDSubGroupId the strDSubGroupId to set
	 */
	public void setStrDSubGroupId(String[] strDSubGroupId) {
		this.strDSubGroupId = strDSubGroupId;
	}
	/**
	 * @return the strDCompiledQty
	 */
	public String[] getStrDCompiledQty() {
		return strDCompiledQty;
	}
	/**
	 * @param strDCompiledQty the strDCompiledQty to set
	 */
	public void setStrDCompiledQty(String[] strDCompiledQty) {
		this.strDCompiledQty = strDCompiledQty;
	}
	/**
	 * @return the strDCompiledQtyUnit
	 */
	public String[] getStrDCompiledQtyUnit() {
		return strDCompiledQtyUnit;
	}
	/**
	 * @param strDCompiledQtyUnit the strDCompiledQtyUnit to set
	 */
	public void setStrDCompiledQtyUnit(String[] strDCompiledQtyUnit) {
		this.strDCompiledQtyUnit = strDCompiledQtyUnit;
	}
	/**
	 * @return the strDReqestNo
	 */
	public String[] getStrDReqestNo() {
		return strDReqestNo;
	}
	/**
	 * @param strDReqestNo the strDReqestNo to set
	 */
	public void setStrDReqestNo(String[] strDReqestNo) {
		this.strDReqestNo = strDReqestNo;
	}
	/**
	 * @return the strDReqestDate
	 */
	public String[] getStrDReqestDate() {
		return strDReqestDate;
	}
	/**
	 * @param strDReqestDate the strDReqestDate to set
	 */
	public void setStrDReqestDate(String[] strDReqestDate) {
		this.strDReqestDate = strDReqestDate;
	}
	/**
	 * @return the strDReqestPeriod
	 */
	public String[] getStrDReqestPeriod() {
		return strDReqestPeriod;
	}
	/**
	 * @param strDReqestPeriod the strDReqestPeriod to set
	 */
	public void setStrDReqestPeriod(String[] strDReqestPeriod) {
		this.strDReqestPeriod = strDReqestPeriod;
	}
	/**
	 * @return the strDRaisingStore
	 */
	public String[] getStrDRaisingStore() {
		return strDRaisingStore;
	}
	/**
	 * @param strDRaisingStore the strDRaisingStore to set
	 */
	public void setStrDRaisingStore(String[] strDRaisingStore) {
		this.strDRaisingStore = strDRaisingStore;
	}
	/**
	 * @return the strDLstPoNo
	 */
	public String[] getStrDLstPoNo() {
		return strDLstPoNo;
	}
	/**
	 * @param strDLstPoNo the strDLstPoNo to set
	 */
	public void setStrDLstPoNo(String[] strDLstPoNo) {
		this.strDLstPoNo = strDLstPoNo;
	}
	/**
	 * @return the strDLstPoDate
	 */
	public String[] getStrDLstPoDate() {
		return strDLstPoDate;
	}
	/**
	 * @param strDLstPoDate the strDLstPoDate to set
	 */
	public void setStrDLstPoDate(String[] strDLstPoDate) {
		this.strDLstPoDate = strDLstPoDate;
	}
	/**
	 * @return the strDLstSupplierId
	 */
	public String[] getStrDLstSupplierId() {
		return strDLstSupplierId;
	}
	/**
	 * @param strDLstSupplierId the strDLstSupplierId to set
	 */
	public void setStrDLstSupplierId(String[] strDLstSupplierId) {
		this.strDLstSupplierId = strDLstSupplierId;
	}
	/**
	 * @return the strDLstRecQty
	 */
	public String[] getStrDLstRecQty() {
		return strDLstRecQty;
	}
	/**
	 * @param strDLstRecQty the strDLstRecQty to set
	 */
	public void setStrDLstRecQty(String[] strDLstRecQty) {
		this.strDLstRecQty = strDLstRecQty;
	}
	/**
	 * @return the strDLstRecQtyUnit
	 */
	public String[] getStrDLstRecQtyUnit() {
		return strDLstRecQtyUnit;
	}
	/**
	 * @param strDLstRecQtyUnit the strDLstRecQtyUnit to set
	 */
	public void setStrDLstRecQtyUnit(String[] strDLstRecQtyUnit) {
		this.strDLstRecQtyUnit = strDLstRecQtyUnit;
	}
	/**
	 * @return the strDLstRecDate
	 */
	public String[] getStrDLstRecDate() {
		return strDLstRecDate;
	}
	/**
	 * @param strDLstRecDate the strDLstRecDate to set
	 */
	public void setStrDLstRecDate(String[] strDLstRecDate) {
		this.strDLstRecDate = strDLstRecDate;
	}
	/**
	 * @return the strDLstPurRate
	 */
	public String[] getStrDLstPurRate() {
		return strDLstPurRate;
	}
	/**
	 * @param strDLstPurRate the strDLstPurRate to set
	 */
	public void setStrDLstPurRate(String[] strDLstPurRate) {
		this.strDLstPurRate = strDLstPurRate;
	}
	/**
	 * @return the strDLstPurRateUnit
	 */
	public String[] getStrDLstPurRateUnit() {
		return strDLstPurRateUnit;
	}
	/**
	 * @param strDLstPurRateUnit the strDLstPurRateUnit to set
	 */
	public void setStrDLstPurRateUnit(String[] strDLstPurRateUnit) {
		this.strDLstPurRateUnit = strDLstPurRateUnit;
	}
	/**
	 * @return the strRateUnitValues
	 */
	public String getStrRateUnitValues() {
		return strRateUnitValues;
	}
	/**
	 * @param strRateUnitValues the strRateUnitValues to set
	 */
	public void setStrRateUnitValues(String strRateUnitValues) {
		this.strRateUnitValues = strRateUnitValues;
	}
	/**
	 * @return the strItemPopupData
	 */
	public String getStrItemPopupData() {
		return strItemPopupData;
	}
	/**
	 * @param strItemPopupData the strItemPopupData to set
	 */
	public void setStrItemPopupData(String strItemPopupData) {
		this.strItemPopupData = strItemPopupData;
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
	 * @return the strItemCatName
	 */
	public String getStrItemCatName() {
		return strItemCatName;
	}
	/**
	 * @param strItemCatName the strItemCatName to set
	 */
	public void setStrItemCatName(String strItemCatName) {
		this.strItemCatName = strItemCatName;
	}
	/**
	 * @return the wbIndentItemDetail
	 */
	public WebRowSet getWbIndentItemDetail() {
		return wbIndentItemDetail;
	}
	/**
	 * @param wbIndentItemDetail the wbIndentItemDetail to set
	 */
	public void setWbIndentItemDetail(WebRowSet wbIndentItemDetail) {
		this.wbIndentItemDetail = wbIndentItemDetail;
	}
	/**
	 * @return the strPopupId
	 */
	public String getStrPopupId() {
		return strPopupId;
	}
	/**
	 * @param strPopupId the strPopupId to set
	 */
	public void setStrPopupId(String strPopupId) {
		this.strPopupId = strPopupId;
	}
	/**
	 * @return the strGrantTypeValues
	 */
	public String getStrGrantTypeValues() {
		return strGrantTypeValues;
	}
	/**
	 * @param strGrantTypeValues the strGrantTypeValues to set
	 */
	public void setStrGrantTypeValues(String strGrantTypeValues) {
		this.strGrantTypeValues = strGrantTypeValues;
	}
	/**
	 * @return the strGrantTypeId
	 */
	public String getStrGrantTypeId() {
		return strGrantTypeId;
	}
	/**
	 * @param strGrantTypeId the strGrantTypeId to set
	 */
	public void setStrGrantTypeId(String strGrantTypeId) {
		this.strGrantTypeId = strGrantTypeId;
	}
	/**
	 * @return the strCheckBox
	 */
	public String[] getStrCheckBox() {
		return strCheckBox;
	}
	/**
	 * @param strCheckBox the strCheckBox to set
	 */
	public void setStrCheckBox(String[] strCheckBox) {
		this.strCheckBox = strCheckBox;
	}
	/**
	 * @return the strAgendaStatus
	 */
	public String getStrAgendaStatus() {
		return strAgendaStatus;
	}
	/**
	 * @param strAgendaStatus the strAgendaStatus to set
	 */
	public void setStrAgendaStatus(String strAgendaStatus) {
		this.strAgendaStatus = strAgendaStatus;
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
	 * @return the strIndentDetails
	 */
	public String getStrIndentDetails() {
		return strIndentDetails;
	}
	/**
	 * @param strIndentDetails the strIndentDetails to set
	 */
	public void setStrIndentDetails(String strIndentDetails) {
		this.strIndentDetails = strIndentDetails;
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
	 * @return the wbIndentDetail
	 */
	public WebRowSet getWbIndentDetail() {
		return wbIndentDetail;
	}
	/**
	 * @param wbIndentDetail the wbIndentDetail to set
	 */
	public void setWbIndentDetail(WebRowSet wbIndentDetail) {
		this.wbIndentDetail = wbIndentDetail;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	/**
	 * @return the strWarning
	 */
	public String getStrWarning() {
		return strWarning;
	}
	/**
	 * @param strWarning the strWarning to set
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}
	/**
	 * @return the strMsg
	 */
	public String getStrMsg() {
		return strMsg;
	}
	/**
	 * @param strMsg the strMsg to set
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}
	/**
	 * @return the strToStore
	 */
	public String getStrToStore() {
		return strToStore;
	}
	/**
	 * @param strToStore the strToStore to set
	 */
	public void setStrToStore(String strToStore) {
		this.strToStore = strToStore;
	}
	/**
	 * @return the strToStoreValues
	 */
	public String getStrToStoreValues() {
		return strToStoreValues;
	}
	/**
	 * @param strToStoreValues the strToStoreValues to set
	 */
	public void setStrToStoreValues(String strToStoreValues) {
		this.strToStoreValues = strToStoreValues;
	}
	/**
	 * @return the strItemCat
	 */
	public String getStrItemCat() {
		return strItemCat;
	}
	/**
	 * @param strItemCat the strItemCat to set
	 */
	public void setStrItemCat(String strItemCat) {
		this.strItemCat = strItemCat;
	}
	/**
	 * @return the strItemCatValues
	 */
	public String getStrItemCatValues() {
		return strItemCatValues;
	}
	/**
	 * @param strItemCatValues the strItemCatValues to set
	 */
	public void setStrItemCatValues(String strItemCatValues) {
		this.strItemCatValues = strItemCatValues;
	}
	/**
	 * @return the strAgendaPeriod
	 */
	public String getStrAgendaPeriod() {
		return strAgendaPeriod;
	}
	/**
	 * @param strAgendaPeriod the strAgendaPeriod to set
	 */
	public void setStrAgendaPeriod(String strAgendaPeriod) {
		this.strAgendaPeriod = strAgendaPeriod;
	}
	
	public String getStrAgendaPeriodValue() {
		return strAgendaPeriodValue;
	}
	public void setStrAgendaPeriodValue(String strAgendaPeriodValue) {
		this.strAgendaPeriodValue = strAgendaPeriodValue;
	}
	public String getStrItemName() {
		return strItemName;
	}
	public void setStrItemName(String strItemName) {
		this.strItemName = strItemName;
	}
	
	
}
