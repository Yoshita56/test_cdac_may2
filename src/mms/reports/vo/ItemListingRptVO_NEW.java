/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
 */
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class IssueDetailRptVO.
 */
public class ItemListingRptVO_NEW {

	/** The str hosp code. */
	private String strHospCode = "";

	/** The str store id. */
	private String strStoreId = "";

	/** The str item id. */
	private String strItemId = "";

	/** The Issue chk detail. */
	private String IssueChkDetail = "1";

	/** The str batchh no. */
	private String strBatchhNo = "1";

	/** The str msg type. */
	private String strMsgType = "0";

	/** The str msg string. */
	private String strMsgString = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str category no. */
	private String strCategoryNo;

	/** The str ws. */
	private WebRowSet strWS = null;

	/** The item categ ws. */
	private WebRowSet itemCategWS = null;

	/** The str item name combo ws. */
	private WebRowSet strItemNameComboWS = null;

	/** The str existing batch combo ws. */
	private WebRowSet strExistingBatchComboWS = null;

	/** The str prog name combo ws. */
	private WebRowSet strProgNameComboWS = null;

	/** The str item brand id. */
	private String strItemBrandId;

	/** The str mode. */
	private String strMode;
	
	private String strProgramId = "";

	/**
	 * Gets the str item brand id.
	 * 
	 * @return the str item brand id
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId
	 *            the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	 * Gets the str ws.
	 * 
	 * @return the str ws
	 */
	public WebRowSet getStrWS() {
		return strWS;
	}

	/**
	 * Sets the str ws.
	 * 
	 * @param strWS
	 *            the new str ws
	 */
	public void setStrWS(WebRowSet strWS) {
		this.strWS = strWS;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString
	 *            the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType
	 *            the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str hosp code.
	 * 
	 * @return the str hosp code
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode
	 *            the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId
	 *            the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId
	 *            the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Gets the str batchh no.
	 * 
	 * @return the str batchh no
	 */
	public String getStrBatchhNo() {
		return strBatchhNo;
	}

	/**
	 * Sets the str batchh no.
	 * 
	 * @param strBatchhNo
	 *            the new str batchh no
	 */
	public void setStrBatchhNo(String strBatchhNo) {
		this.strBatchhNo = strBatchhNo;
	}

	/**
	 * Gets the issue chk detail.
	 * 
	 * @return the issue chk detail
	 */
	public String getIssueChkDetail() {
		return IssueChkDetail;
	}

	/**
	 * Sets the issue chk detail.
	 * 
	 * @param issueChkDetail
	 *            the new issue chk detail
	 */
	public void setIssueChkDetail(String issueChkDetail) {
		IssueChkDetail = issueChkDetail;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId
	 *            the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the item categ ws.
	 * 
	 * @return the item categ ws
	 */
	public WebRowSet getItemCategWS() {
		return itemCategWS;
	}

	/**
	 * Sets the item categ ws.
	 * 
	 * @param itemCategWS
	 *            the new item categ ws
	 */
	public void setItemCategWS(WebRowSet itemCategWS) {
		this.itemCategWS = itemCategWS;
	}

	/**
	 * Gets the str category no.
	 * 
	 * @return the str category no
	 */
	public String getStrCategoryNo() {
		return strCategoryNo;
	}

	/**
	 * Sets the str category no.
	 * 
	 * @param strCategoryNo
	 *            the new str category no
	 */
	public void setStrCategoryNo(String strCategoryNo) {
		this.strCategoryNo = strCategoryNo;
	}

	/**
	 * Gets the str item name combo ws.
	 * 
	 * @return the str item name combo ws
	 */
	public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	/**
	 * Sets the str item name combo ws.
	 * 
	 * @param strItemNameComboWS
	 *            the new str item name combo ws
	 */
	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}

	/**
	 * Gets the str existing batch combo ws.
	 * 
	 * @return the str existing batch combo ws
	 */
	public WebRowSet getStrExistingBatchComboWS() {
		return strExistingBatchComboWS;
	}

	/**
	 * Sets the str existing batch combo ws.
	 * 
	 * @param strExistingBatchComboWS
	 *            the new str existing batch combo ws
	 */
	public void setStrExistingBatchComboWS(WebRowSet strExistingBatchComboWS) {
		this.strExistingBatchComboWS = strExistingBatchComboWS;
	}

	/**
	 * Gets the str prog name combo ws.
	 * 
	 * @return the str prog name combo ws
	 */
	public WebRowSet getStrProgNameComboWS() {
		return strProgNameComboWS;
	}

	/**
	 * Sets the str prog name combo ws.
	 * 
	 * @param strProgNameComboWS
	 *            the new str prog name combo ws
	 */
	public void setStrProgNameComboWS(WebRowSet strProgNameComboWS) {
		this.strProgNameComboWS = strProgNameComboWS;
	}

	public String getStrProgramId() {
		return strProgramId;
	}

	public void setStrProgramId(String strProgramId) {
		this.strProgramId = strProgramId;
	}
	
	

}
