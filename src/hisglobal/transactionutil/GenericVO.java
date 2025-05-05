/**
 * 
 */
package hisglobal.transactionutil;

import hisglobal.utility.TransferObject;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

/**
 * @author dell
 *
 */
public class GenericVO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String combo[] = null;
	private String hmode = "";
	
	private String divisionId = "";

	private String comboValue = "";
	
	private String cnt_page = "";	
	
	private String chk = "";
	
	private String searchColumn = "";
	
	private String prevNext = "";

	private String search = "";
	
	private String orderby = "";
	
	private String rowNum = "0";
	
	private String blockNo = "0";
	
	private String minRow = "0";
	
	private String max_rownum = "0";
	
	private String mode = "";
	
	private String strMsgType = "";
	
	private String strMsgString = "";
	
	private WebRowSet[] cmbWs = null;

	private WebRowSet lstWs = null;

	private String strUserName = "";
	
	private HttpSession session = null;

	private String[] strDBButton = null;
	
	private String[] comboReset=null;
	private String strVisibilityMode="";
	WebRowSet extraInfoWS=null;
	private String[] extraInfoData=null;
	private String strHelpData=null;
	
	//-------------- Setter Methods ----------------//
	
	/**
	 * @return Returns the combo.
	 */
	public String[] getCombo() {
		return combo;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the strUserName
	 */
	public String getStrUserName() {
		return strUserName;
	}

	/**
	 * @param strUserName the strUserName to set
	 */
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	/**
	 * @return Returns the comboValue.
	 */
	public String getComboValue() {
		return comboValue;
	}

	/**
	 * @return Returns the divisionId.
	 */
	public String getDivisionId() {
		return divisionId;
	}

	/**
	 * @return Returns the hmode.
	 */
	public String getHmode() {
		return hmode;
	}

	/**
	 * @return Returns the max_rownum.
	 */
	public String getMax_rownum() {
		return max_rownum;
	}

	/**
	 * @return Returns the minRow.
	 */
	public String getMinRow() {
		return minRow;
	}

	/**
	 * @return Returns the mode.
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @return Returns the orderby.
	 */
	public String getOrderby() {
		return orderby;
	}

	/**
	 * @return Returns the prevNext.
	 */
	public String getPrevNext() {
		return prevNext;
	}

	/**
	 * @return Returns the rowNum.
	 */
	public String getRowNum() {
		return rowNum;
	}

	/**
	 * @return Returns the search.
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @return Returns the searchColumn.
	 */
	public String getSearchColumn() {
		return searchColumn;
	}

	/**
	 * @return Returns the strMsgString.
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @return Returns the strMsgType.
	 */
	public String getStrMsgType() {
		return strMsgType;
	}
	
	/**
	 * @return Returns the blockNo.
	 */
	public String getBlockNo() {
		return blockNo;
	}

	/**
	 * @return Returns the chk.
	 */
	public String getChk() {
		return chk;
	}

	/**
	 * @return Returns the cnt_page.
	 */
	public String getCnt_page() {
		return cnt_page;
	}
	
	/**
	 * @return Returns the cmbWs.
	 */
	public WebRowSet[] getCmbWs() {
		return cmbWs;
	}

	/**
	 * @return Returns the lstWs.
	 */
	public WebRowSet getLstWs() {
		return lstWs;
	}

	//-------------- Setter Methods ----------------//
	
	/**
	 * @param combo The combo to set.
	 */
	public void setCombo(String[] combo) {
		this.combo = combo;
	}

	/**
	 * @param comboValue The comboValue to set.
	 */
	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
	}

	/**
	 * @param divisionId The divisionId to set.
	 */
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * @param hmode The hmode to set.
	 */
	public void setHmode(String hmode) {
		this.hmode = hmode;
	}

	/**
	 * @param max_rownum The max_rownum to set.
	 */
	public void setMax_rownum(String max_rownum) {
		this.max_rownum = max_rownum;
	}

	/**
	 * @param minRow The minRow to set.
	 */
	public void setMinRow(String minRow) {
		this.minRow = minRow;
	}

	/**
	 * @param mode The mode to set.
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @param orderby The orderby to set.
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	/**
	 * @param prevNext The prevNext to set.
	 */
	public void setPrevNext(String prevNext) {
		this.prevNext = prevNext;
	}

	/**
	 * @param rowNum The rowNum to set.
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	/**
	 * @param search The search to set.
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @param searchColumn The searchColumn to set.
	 */
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	/**
	 * @param strMsgString The strMsgString to set.
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * @param strMsgType The strMsgType to set.
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}	

	/**
	 * @param blockNo The blockNo to set.
	 */
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	/**
	 * @param chk The chk to set.
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}

	/**
	 * @param cnt_page The cnt_page to set.
	 */
	public void setCnt_page(String cnt_page) {
		this.cnt_page = cnt_page;
	}	

	/**
	 * @param cmbWs The cmbWs to set.
	 */
	public void setCmbWs(WebRowSet[] cmbWs) {
		this.cmbWs = cmbWs;
	}

	/**
	 * @param lstWs The lstWs to set.
	 */
	public void setLstWs(WebRowSet lstWs) {
		this.lstWs = lstWs;
	}

	/**
	 * @return the strDBButton
	 */
	public String[] getStrDBButton() {
		return strDBButton;
	}

	/**
	 * @param strDBButton the strDBButton to set
	 */
	public void setStrDBButton(String[] strDBButton) {
		this.strDBButton = strDBButton;
	}

	public String[] getComboReset() {
		return comboReset;
	}

	public void setComboReset(String[] comboReset) {
		this.comboReset = comboReset;
	}

	public String getStrVisibilityMode() {
		return strVisibilityMode;
	}

	public void setStrVisibilityMode(String strVisibilityMode) {
		this.strVisibilityMode = strVisibilityMode;
	}

	public WebRowSet getExtraInfoWS() {
		return extraInfoWS;
	}

	public void setExtraInfoWS(WebRowSet extraInfoWS) {
		this.extraInfoWS = extraInfoWS;
	}

	public String[] getExtraInfoData() {
		return extraInfoData;
	}

	public void setExtraInfoData(String[] extraInfoData) {
		this.extraInfoData = extraInfoData;
	}

	public String getStrHelpData() {
		return strHelpData;
	}

	public void setStrHelpData(String strHelpData) {
		this.strHelpData = strHelpData;
	}

	
}
