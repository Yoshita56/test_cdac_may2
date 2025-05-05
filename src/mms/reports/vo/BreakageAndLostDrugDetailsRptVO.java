package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class BreakageAndLostDrugDetailsRptVO {
	
	private String strMode;
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strDrugWarehouseTypeId = "";

	private WebRowSet strDrugWarehouseTypeWs = null;
	private WebRowSet strStoreWs = null;
	
	private WebRowSet strItemCatWs = null;
	private WebRowSet strDistrictStoreWs = null;
	private WebRowSet WsBreakageDtlRpt = null;
	
	/*-->*/
	private String strStartDate = "";
	private String strEndDate = "";

	private String strStoreName = "";
	private String strCategoryName = "";
	
	private String strItemCategoryName = "";

	private String strItemCategoryId="";
	
	private WebRowSet wsItemCategoryCombo = null;

	private String strLogoName ="";

	
	public String getStrLogoName() {
		return strLogoName;
	}
	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}

	
	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}
	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}
	
	public WebRowSet getWsItemCategoryCombo() {
		return wsItemCategoryCombo;
	}
	public void setWsItemCategoryCombo(WebRowSet wsItemCategoryCombo) {
		this.wsItemCategoryCombo = wsItemCategoryCombo;
	}

	public String getStrItemCategoryId() {
		return strItemCategoryId;
	}
	public void setStrItemCategoryId(String strItemCategoryId) {
		this.strItemCategoryId = strItemCategoryId;
	}
	public String getStrStartDate() {
		return strStartDate;
	}
	
	public void setStrStartDate(String strStartDate) {
		this.strStartDate = strStartDate;
	}
	
	public String getStrEndDate() {
		return strEndDate;
	}
	
	public void setStrEndDate(String strEndDate) {
		this.strEndDate = strEndDate;
	}

	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}


	public void setStrCategoryName(String strCategoryName) {
		this.strCategoryName = strCategoryName;
	}
	public String getStrCategoryName() {
		return strCategoryName;
	}
	/*<--*/
	
	public WebRowSet getWsBreakageDtlRpt() {
		return WsBreakageDtlRpt;
	}
	public void setWsBreakageDtlRpt(WebRowSet wsBreakageDtlRpt) {
		WsBreakageDtlRpt = wsBreakageDtlRpt;
	}
	public WebRowSet getStrItemCatWs() {
		return strItemCatWs;
	}
	public void setStrItemCatWs(WebRowSet strItemCatWs) {
		this.strItemCatWs = strItemCatWs;
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
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public WebRowSet getStrStoreWs() {
		return strStoreWs;
	}
	public void setStrStoreWs(WebRowSet strStoreWs) {
		this.strStoreWs = strStoreWs;
	}
	public String getStrDrugWarehouseTypeId() {
		return strDrugWarehouseTypeId;
	}
	public void setStrDrugWarehouseTypeId(String strDrugWarehouseTypeId) {
		this.strDrugWarehouseTypeId = strDrugWarehouseTypeId;
	}
	public WebRowSet getStrDrugWarehouseTypeWs() {
		return strDrugWarehouseTypeWs;
	}
	public void setStrDrugWarehouseTypeWs(WebRowSet strDrugWarehouseTypeWs) {
		this.strDrugWarehouseTypeWs = strDrugWarehouseTypeWs;
	}
	public WebRowSet getStrDistrictStoreWs() {
		return strDistrictStoreWs;
	}
	public void setStrDistrictStoreWs(WebRowSet strDistrictStoreWs) {
		this.strDistrictStoreWs = strDistrictStoreWs;
	}
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	

}

