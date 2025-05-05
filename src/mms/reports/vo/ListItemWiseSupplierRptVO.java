/**
 * 
 */
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;


/**
 * @author user
 *
 */
public class ListItemWiseSupplierRptVO{
	
private static final long serialVersionUID = 1L;
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	
	private String strMsgString = "";
	private String strMsgType = "";
	
	private String strItemCategoryNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strItemId = "";
	private String strSuppId = "";
	
	private String strItemCatId = "";
	private String strItemCategoryName = "";
	private String strGroupName = "";
	private String strSupplierName = "";
			
	private WebRowSet itemCategoryWS = null;
	private WebRowSet groupIdWS = null;
	private WebRowSet subGroupIdWS = null;
	private WebRowSet itemIdWS = null;
	private WebRowSet strHospitalWs=null;
	
	private WebRowSet strManufactureComboWS = null;
	
	private WebRowSet strTypeCmbWS = null;
	private WebRowSet breakageDtlRptWs =null;
	
	private String strMode;
	private String strLogoName;
	
	
	public WebRowSet getBreakageDtlRptWs() {
		return breakageDtlRptWs;
	}

	public void setBreakageDtlRptWs(WebRowSet breakageDtlRptWs) {
		this.breakageDtlRptWs = breakageDtlRptWs;
	}

	public String getStrLogoName() {
		return strLogoName;
	}

	public void setStrLogoName(String strLogoName) {
		this.strLogoName = strLogoName;
	}

	public String getStrItemCatId() {
		return strItemCatId;
	}

	public void setStrItemCatId(String strItemCatId) {
		this.strItemCatId = strItemCatId;
	}

	public String getStrItemCategoryName() {
		return strItemCategoryName;
	}

	public void setStrItemCategoryName(String strItemCategoryName) {
		this.strItemCategoryName = strItemCategoryName;
	}

	public String getStrGroupName() {
		return strGroupName;
	}

	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	public String getStrSupplierName() {
		return strSupplierName;
	}

	public void setStrSupplierName(String strSupplierName) {
		this.strSupplierName = strSupplierName;
	}

	public String getStrSuppId() {
		return strSuppId;
	}

	public void setStrSuppId(String strSuppId) {
		this.strSuppId = strSuppId;
	}
	
	public WebRowSet getStrTypeCmbWS() {
		return strTypeCmbWS;
	}

	public void setStrTypeCmbWS(WebRowSet strTypeCmbWS) {
		this.strTypeCmbWS = strTypeCmbWS;
	}
	
	public String getStrMode() {
		return strMode;
	}

	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	
	
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
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
	 * @return the groupIdWS
	 */
	public WebRowSet getGroupIdWS() {
		return groupIdWS;
	}
	/**
	 * @param groupIdWS the groupIdWS to set
	 */
	public void setGroupIdWS(WebRowSet groupIdWS) {
		this.groupIdWS = groupIdWS;
	}
	/**
	 * @return the subGroupIdWS
	 */
	public WebRowSet getSubGroupIdWS() {
		return subGroupIdWS;
	}
	/**
	 * @param subGroupIdWS the subGroupIdWS to set
	 */
	public void setSubGroupIdWS(WebRowSet subGroupIdWS) {
		this.subGroupIdWS = subGroupIdWS;
	}
	/**
	 * @return the itemIdWS
	 */
	public WebRowSet getItemIdWS() {
		return itemIdWS;
	}
	/**
	 * @param itemIdWS the itemIdWS to set
	 */
	public void setItemIdWS(WebRowSet itemIdWS) {
		this.itemIdWS = itemIdWS;
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
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}
	/**
	 * @param strIsFooter the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	/**
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	/**
	 * @param strUserRemarks the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	/**
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}
	/**
	 * @param strReportFormat the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	/**
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}
	/**
	 * @param strReportId the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
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

	public WebRowSet getStrHospitalWs() {
		return strHospitalWs;
	}

	public void setStrHospitalWs(WebRowSet strHospitalWs) {
		this.strHospitalWs = strHospitalWs;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	
}
