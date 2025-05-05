/**
 * 
 */
package hisglobal.masterutil;

import javax.sql.rowset.WebRowSet;
import hisglobal.utility.*;;

/**
 * @author dell
 * 
 */
public class GenericVO implements TransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WebRowSet[] cmbWs = null;

	private WebRowSet lstWs = null;

	private String[] combo = null;

	private String hmode = "";

	private String searchColumn = "";

	private String prevNext = "";

	private String search = "";

	private String orderby = "";

	private String rowNum = "0";

	private String blockNo = "0";

	private String minrow = "0";

	private String divisionId = "";

	private String max_rownum = "0";

	private String comboValue = "";

	private String chk = "";
	
	private String strMsgString = "";
	
	private String strMsgType = "";
	
	private String rptOrderBy = "";
	
	private String[] strReportGroupBy = null;
	
	private String[] strColNotRequired = null;
	
	private String strNoOfRecordPerPages = "9999";
	
	private String strRepeat= "";
	
	private String strSessionSaveParam = "";
	
	private String[] strSessionColWidth = null;
	
	private String[] strOrderByCols = null;
	
	private String[] strAlignWith = null;
	
	private String strBorderRequired = null;
	
	private String strConcatString = "0";
	
	private String strSlNo = "";
	
	private String strGroupByPatern = "true";
	
	private String strMasterName="";
	
	private String strHospCode="";
	
	private String strSeatId = "";
	
	private String strShowAllData = "";
	
	private String strReportConfigDtl="";
	
	private String strLastRowNo = "";
	
	private String strPrevFirstRow = "";
	
	private String[] strTmpData = null;
	private String strIsGlobal="";
	// --------------- getter methods ---------------//

	

	/**
	 * @return the strSessionSaveParam
	 */
	public String getStrSessionSaveParam() {
		return strSessionSaveParam;
	}

	/**
	 * @param strSessionSaveParam the strSessionSaveParam to set
	 */
	public void setStrSessionSaveParam(String strSessionSaveParam) {
		this.strSessionSaveParam = strSessionSaveParam;
	}

	/**
	 * @return the strRepeat
	 */
	public String getStrRepeat() {
		return strRepeat;
	}

	/**
	 * @param strRepeat the strRepeat to set
	 */
	public void setStrRepeat(String strRepeat) {
		this.strRepeat = strRepeat;
	}

	/**
	 * @return the strNoOfRecordPerPages
	 */
	public String getStrNoOfRecordPerPages() {
		return strNoOfRecordPerPages;
	}

	/**
	 * @param strNoOfRecordPerPages the strNoOfRecordPerPages to set
	 */
	public void setStrNoOfRecordPerPages(String strNoOfRecordPerPages) {
		this.strNoOfRecordPerPages = strNoOfRecordPerPages;
	}

	/**
	 * @return the strColNotRequired
	 */
	public String[] getStrColNotRequired() {
		return strColNotRequired;
	}

	/**
	 * @param strColNotRequired the strColNotRequired to set
	 */
	public void setStrColNotRequired(String[] strColNotRequired) {
		this.strColNotRequired = strColNotRequired;
	}

	/**
	 * @return the strReportGroupBy
	 */
	public String[] getStrReportGroupBy() {
		return strReportGroupBy;
	}

	/**
	 * @param strReportGroupBy the strReportGroupBy to set
	 */
	public void setStrReportGroupBy(String[] strReportGroupBy) {
		this.strReportGroupBy = strReportGroupBy;
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
	 * @return Returns the combo.
	 */
	public String[] getCombo() {
		return combo;
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
	 * @return Returns the lstWs.
	 */
	public WebRowSet getLstWs() {
		return lstWs;
	}

	/**
	 * @return Returns the max_rownum.
	 */
	public String getMax_rownum() {
		return max_rownum;
	}

	/**
	 * @return Returns the minrow.
	 */
	public String getMinrow() {
		return minrow;
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
	 * @return Returns the qryWs.
	 */
	public WebRowSet[] getCmbWs() {
		return cmbWs;
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

	// -------------- setter methods ----------------//

	/**
	 * @param blockNo
	 *            The blockNo to set.
	 */
	public void setBlockNo(String blockNo) {
		this.blockNo = blockNo;
	}

	/**
	 * @param chk
	 *            The chk to set.
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}

	/**
	 * @param combo
	 *            The combo to set.
	 */
	public void setCombo(String[] combo) {
		this.combo = combo;
	}

	/**
	 * @param comboValue
	 *            The comboValue to set.
	 */
	public void setComboValue(String comboValue) {
		this.comboValue = comboValue;
	}

	/**
	 * @param divisionId
	 *            The divisionId to set.
	 */
	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * @param hmode
	 *            The hmode to set.
	 */
	public void setHmode(String hmode) {
		this.hmode = hmode;
	}

	/**
	 * @param lstWs
	 *            The lstWs to set.
	 */
	public void setLstWs(WebRowSet lstWs) {
		this.lstWs = lstWs;
	}

	/**
	 * @param max_rownum
	 *            The max_rownum to set.
	 */
	public void setMax_rownum(String max_rownum) {
		this.max_rownum = max_rownum;
	}

	/**
	 * @param minrow
	 *            The minrow to set.
	 */
	public void setMinrow(String minrow) {
		this.minrow = minrow;
	}

	/**
	 * @param orderby
	 *            The orderby to set.
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	/**
	 * @param prevNext
	 *            The prevNext to set.
	 */
	public void setPrevNext(String prevNext) {
		this.prevNext = prevNext;
	}

	/**
	 * @param qryWs
	 *            The qryWs to set.
	 */
	public void setCmbWs(WebRowSet[] qryWs) {
		this.cmbWs = qryWs;
	}

	/**
	 * @param rowNum
	 *            The rowNum to set.
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	/**
	 * @param search
	 *            The search to set.
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @param searchColumn
	 *            The searchColumn to set.
	 */
	public void setSearchColumn(String searchColumn) {
		this.searchColumn = searchColumn;
	}

	// -------------- interface implemented methods ---------------//

	public void setStrMsgString(String MSGSTR) {
		this.strMsgString = MSGSTR;
	}

	public void setStrMsgType(String MSGTYPE) {
		this.strMsgType = MSGTYPE;
	}

	public String getStrMsgType() {		
		return strMsgType;
	}

	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * @return the rptOrderBy
	 */
	public String getRptOrderBy() {
		return rptOrderBy;
	}

	/**
	 * @param rptOrderBy the rptOrderBy to set
	 */
	public void setRptOrderBy(String rptOrderBy) {
		this.rptOrderBy = rptOrderBy;
	}

	/**
	 * @return the strSessionColWidth
	 */
	public String[] getStrSessionColWidth() {
		return strSessionColWidth;
	}

	/**
	 * @param strSessionColWidth the strSessionColWidth to set
	 */
	public void setStrSessionColWidth(String[] strSessionColWidth) {
		this.strSessionColWidth = strSessionColWidth;
	}

	/**
	 * @return the strOrderByCols
	 */
	public String[] getStrOrderByCols() {
		return strOrderByCols;
	}

	/**
	 * @param strOrderByCols the strOrderByCols to set
	 */
	public void setStrOrderByCols(String[] strOrderByCols) {
		this.strOrderByCols = strOrderByCols;
	}

	/**
	 * @return the strAlignWith
	 */
	public String[] getStrAlignWith() {
		return strAlignWith;
	}

	/**
	 * @param strAlignWith the strAlignWith to set
	 */
	public void setStrAlignWith(String[] strAlignWith) {
		this.strAlignWith = strAlignWith;
	}

	/**
	 * @return the strBorderRequired
	 */
	public String getStrBorderRequired() {
		return strBorderRequired;
	}

	/**
	 * @param strBorderRequired the strBorderRequired to set
	 */
	public void setStrBorderRequired(String strBorderRequired) {
		this.strBorderRequired = strBorderRequired;
	}

	/**
	 * @return the strConcatString
	 */
	public String getStrConcatString() {
		return strConcatString;
	}

	/**
	 * @param strConcatString the strConcatString to set
	 */
	public void setStrConcatString(String strConcatString) {
		this.strConcatString = strConcatString;
	}

	/**
	 * @return the strSlNo
	 */
	public String getStrSlNo() {
		return strSlNo;
	}

	/**
	 * @param strSlNo the strSlNo to set
	 */
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * @return the strGroupByPatern
	 */
	public String getStrGroupByPatern() {
		return strGroupByPatern;
	}

	/**
	 * @param strGroupByPatern the strGroupByPatern to set
	 */
	public void setStrGroupByPatern(String strGroupByPatern) {
		this.strGroupByPatern = strGroupByPatern;
	}

	/**
	 * @return the strMasterName
	 */
	public String getStrMasterName() {
		return strMasterName;
	}

	/**
	 * @param strMasterName the strMasterName to set
	 */
	public void setStrMasterName(String strMasterName) {
		this.strMasterName = strMasterName;
	}

	/**
	 * @return the strHospCode
	 */
	public String getStrHospCode() {
		return strHospCode;
	}

	/**
	 * @param strHospCode the strHospCode to set
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	 * @return the strShowAllData
	 */
	public String getStrShowAllData() {
		return strShowAllData;
	}

	/**
	 * @param strShowAllData the strShowAllData to set
	 */
	public void setStrShowAllData(String strShowAllData) {
		this.strShowAllData = strShowAllData;
	}

	/**
	 * @return the strReportConfigDtl
	 */
	public String getStrReportConfigDtl() {
		return strReportConfigDtl;
	}

	/**
	 * @param strReportConfigDtl the strReportConfigDtl to set
	 */
	public void setStrReportConfigDtl(String strReportConfigDtl) {
		this.strReportConfigDtl = strReportConfigDtl;
	}

	/**
	 * @return the strLastRowNo
	 */
	public String getStrLastRowNo() {
		return strLastRowNo;
	}

	/**
	 * @param strLastRowNo the strLastRowNo to set
	 */
	public void setStrLastRowNo(String strLastRowNo) {
		this.strLastRowNo = strLastRowNo;
	}

	/**
	 * @return the strPrevFirstRow
	 */
	public String getStrPrevFirstRow() {
		return strPrevFirstRow;
	}

	/**
	 * @param strPrevFirstRow the strPrevFirstRow to set
	 */
	public void setStrPrevFirstRow(String strPrevFirstRow) {
		this.strPrevFirstRow = strPrevFirstRow;
	}

	/**
	 * @return the strTmpData
	 */
	public String[] getStrTmpData() {
		return strTmpData;
	}

	/**
	 * @param strTmpData the strTmpData to set
	 */
	public void setStrTmpData(String[] strTmpData) {
		this.strTmpData = strTmpData;
	}

	public String getStrIsGlobal() {
		return strIsGlobal;
	}

	public void setStrIsGlobal(String strIsGlobal) {
		this.strIsGlobal = strIsGlobal;
	}

		
}
