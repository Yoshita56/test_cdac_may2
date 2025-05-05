/**
 * 
 */
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptVO.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptVO_NEW {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str is footer. */
	private String strIsFooter = "";

	/** The str user remarks. */
	private String strUserRemarks = "";

	/** The str report format. */
	private String strReportFormat = "0";

	/** The str report id. */
	private String strReportId = "";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str msg type. */
	private String strMsgType = "";

	/** The str item category no. */
	private String strItemCategoryNo = "";

	/** The str group id. */
	private String strGroupId = "";

	/** The str sub group id. */
	private String strSubGroupId = "";

	/** The str item id. */
	private String strItemId = "";

	/** The drug code ws. */
	private WebRowSet drugCodeWS = null;

	/** The item category ws. */
	private WebRowSet itemCategoryWS = null;

	/** The group id ws. */
	private WebRowSet groupIdWS = null;

	/** The sub group id ws. */
	private WebRowSet subGroupIdWS = null;

	/** The item id ws. */
	private WebRowSet itemIdWS = null;

	/** The str manufacture combo ws. */
	private WebRowSet strManufactureComboWS = null;

	/** The Str contract type ws. */
	private WebRowSet StrContractTypeWS = null;

	/** The str mode. */
	private String strMode;

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
	 * Gets the str manufacture combo ws.
	 * 
	 * @return the str manufacture combo ws
	 */
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}

	/**
	 * Sets the str manufacture combo ws.
	 * 
	 * @param strManufactureComboWS
	 *            the new str manufacture combo ws
	 */
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}

	/**
	 * Gets the item category ws.
	 * 
	 * @return the itemCategoryWS
	 */
	public WebRowSet getItemCategoryWS() {
		return itemCategoryWS;
	}

	/**
	 * Sets the item category ws.
	 * 
	 * @param itemCategoryWS
	 *            the itemCategoryWS to set
	 */
	public void setItemCategoryWS(WebRowSet itemCategoryWS) {
		this.itemCategoryWS = itemCategoryWS;
	}

	/**
	 * Gets the group id ws.
	 * 
	 * @return the groupIdWS
	 */
	public WebRowSet getGroupIdWS() {
		return groupIdWS;
	}

	/**
	 * Sets the group id ws.
	 * 
	 * @param groupIdWS
	 *            the groupIdWS to set
	 */
	public void setGroupIdWS(WebRowSet groupIdWS) {
		this.groupIdWS = groupIdWS;
	}

	/**
	 * Gets the sub group id ws.
	 * 
	 * @return the subGroupIdWS
	 */
	public WebRowSet getSubGroupIdWS() {
		return subGroupIdWS;
	}

	/**
	 * Sets the sub group id ws.
	 * 
	 * @param subGroupIdWS
	 *            the subGroupIdWS to set
	 */
	public void setSubGroupIdWS(WebRowSet subGroupIdWS) {
		this.subGroupIdWS = subGroupIdWS;
	}

	/**
	 * Gets the item id ws.
	 * 
	 * @return the itemIdWS
	 */
	public WebRowSet getItemIdWS() {
		return itemIdWS;
	}

	/**
	 * Sets the item id ws.
	 * 
	 * @param itemIdWS
	 *            the itemIdWS to set
	 */
	public void setItemIdWS(WebRowSet itemIdWS) {
		this.itemIdWS = itemIdWS;
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
	 * Gets the str is footer.
	 * 
	 * @return the strIsFooter
	 */
	public String getStrIsFooter() {
		return strIsFooter;
	}

	/**
	 * Sets the str is footer.
	 * 
	 * @param strIsFooter
	 *            the strIsFooter to set
	 */
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}

	/**
	 * Gets the str user remarks.
	 * 
	 * @return the strUserRemarks
	 */
	public String getStrUserRemarks() {
		return strUserRemarks;
	}

	/**
	 * Sets the str user remarks.
	 * 
	 * @param strUserRemarks
	 *            the strUserRemarks to set
	 */
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}

	/**
	 * Gets the str report format.
	 * 
	 * @return the strReportFormat
	 */
	public String getStrReportFormat() {
		return strReportFormat;
	}

	/**
	 * Sets the str report format.
	 * 
	 * @param strReportFormat
	 *            the strReportFormat to set
	 */
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}

	/**
	 * Gets the str report id.
	 * 
	 * @return the strReportId
	 */
	public String getStrReportId() {
		return strReportId;
	}

	/**
	 * Sets the str report id.
	 * 
	 * @param strReportId
	 *            the strReportId to set
	 */
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
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
	 * Gets the str item category no.
	 * 
	 * @return the strItemCategoryNo
	 */
	public String getStrItemCategoryNo() {
		return strItemCategoryNo;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo
	 *            the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId
	 *            the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str sub group id.
	 * 
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId
	 *            the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
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
	 * Gets the drug code ws.
	 * 
	 * @return the drug code ws
	 */
	public WebRowSet getDrugCodeWS() {
		return drugCodeWS;
	}

	/**
	 * Sets the drug code ws.
	 * 
	 * @param drugCodeWS
	 *            the new drug code ws
	 */
	public void setDrugCodeWS(WebRowSet drugCodeWS) {
		this.drugCodeWS = drugCodeWS;
	}

	/**
	 * Gets the str contract type ws.
	 * 
	 * @return the str contract type ws
	 */
	public WebRowSet getStrContractTypeWS() {
		return StrContractTypeWS;
	}

	/**
	 * Sets the str contract type ws.
	 * 
	 * @param strContractTypeWS
	 *            the new str contract type ws
	 */
	public void setStrContractTypeWS(WebRowSet strContractTypeWS) {
		StrContractTypeWS = strContractTypeWS;
	}

}
