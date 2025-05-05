/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class ItemMstforBMEDRptVO {
	private String strHospCode="";
	private String strStoreId="";
	private String strItemId="";
	private String IssueChkDetail="1";
	private String strBatchhNo="1";
	private String strMsgType="0";
	private String strMsgString="";
	private String strSeatId="";

	private String strCurrentDate="";
	private String strStoreVal="";
	private String strItemCategNo = "";
	private String strReportFormat = "0";
	private String strReportId = "";
	private String strIsFooter = "";
	private String strUserRemarks = "";
	private String strFromDate = "";
	private String strToDate = "";
	private String strCase = "1";
	private String strReportType;
	private String isdossier="0";
	
	private String strByCurrentAndDate;
	
	private String strConsolidatedOrDetailed;
	private String strStoreName;

	
	private String strItemVal;
	
	private String strWhetherBatchRequiredCheckBox;
	private String strOnlyIssueDetailRequiredCheckBox;
	private String strReportName;
	private String strPrintDtls;
	
	private WebRowSet strWS=null;
	private WebRowSet itemCategWS=null;
	
	private WebRowSet wsPrint = null;
	private WebRowSet strItemNameComboWS = null;
	
	private String strItemBrandId;
	
	
public WebRowSet getStrItemNameComboWS() {
		return strItemNameComboWS;
	}

	public void setStrItemNameComboWS(WebRowSet strItemNameComboWS) {
		this.strItemNameComboWS = strItemNameComboWS;
	}

	
	

	public String getStrItemBrandId() {
		return strItemBrandId;
	}

	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	
	
	
	public WebRowSet getWsPrint() {
		return wsPrint;
	}
	public void setWsPrint(WebRowSet wsPrint) {
		this.wsPrint = wsPrint;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
	}
	public String getStrStoreVal() {
		return strStoreVal;
	}
	public void setStrStoreVal(String strStoreVal) {
		this.strStoreVal = strStoreVal;
	}
	public String getStrItemCategNo() {
		return strItemCategNo;
	}
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}
	public String getStrReportFormat() {
		return strReportFormat;
	}
	public void setStrReportFormat(String strReportFormat) {
		this.strReportFormat = strReportFormat;
	}
	public String getStrReportId() {
		return strReportId;
	}
	public void setStrReportId(String strReportId) {
		this.strReportId = strReportId;
	}
	public String getStrIsFooter() {
		return strIsFooter;
	}
	public void setStrIsFooter(String strIsFooter) {
		this.strIsFooter = strIsFooter;
	}
	public String getStrUserRemarks() {
		return strUserRemarks;
	}
	public void setStrUserRemarks(String strUserRemarks) {
		this.strUserRemarks = strUserRemarks;
	}
	public String getStrFromDate() {
		return strFromDate;
	}
	public void setStrFromDate(String strFromDate) {
		this.strFromDate = strFromDate;
	}
	public String getStrToDate() {
		return strToDate;
	}
	public void setStrToDate(String strToDate) {
		this.strToDate = strToDate;
	}
	public String getStrCase() {
		return strCase;
	}
	public void setStrCase(String strCase) {
		this.strCase = strCase;
	}
	public String getStrReportType() {
		return strReportType;
	}
	public void setStrReportType(String strReportType) {
		this.strReportType = strReportType;
	}
	public String getIsdossier() {
		return isdossier;
	}
	public void setIsdossier(String isdossier) {
		this.isdossier = isdossier;
	}
	public String getStrByCurrentAndDate() {
		return strByCurrentAndDate;
	}
	public void setStrByCurrentAndDate(String strByCurrentAndDate) {
		this.strByCurrentAndDate = strByCurrentAndDate;
	}
	public String getStrConsolidatedOrDetailed() {
		return strConsolidatedOrDetailed;
	}
	public void setStrConsolidatedOrDetailed(String strConsolidatedOrDetailed) {
		this.strConsolidatedOrDetailed = strConsolidatedOrDetailed;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public String getStrItemVal() {
		return strItemVal;
	}
	public void setStrItemVal(String strItemVal) {
		this.strItemVal = strItemVal;
	}
	public String getStrWhetherBatchRequiredCheckBox() {
		return strWhetherBatchRequiredCheckBox;
	}
	public void setStrWhetherBatchRequiredCheckBox(String strWhetherBatchRequiredCheckBox) {
		this.strWhetherBatchRequiredCheckBox = strWhetherBatchRequiredCheckBox;
	}
	public String getStrOnlyIssueDetailRequiredCheckBox() {
		return strOnlyIssueDetailRequiredCheckBox;
	}
	public void setStrOnlyIssueDetailRequiredCheckBox(String strOnlyIssueDetailRequiredCheckBox) {
		this.strOnlyIssueDetailRequiredCheckBox = strOnlyIssueDetailRequiredCheckBox;
	}
	public String getStrReportName() {
		return strReportName;
	}
	public void setStrReportName(String strReportName) {
		this.strReportName = strReportName;
	}
	public String getStrPrintDtls() {
		return strPrintDtls;
	}
	public void setStrPrintDtls(String strPrintDtls) {
		this.strPrintDtls = strPrintDtls;
	}
	public WebRowSet getStrWS() {
		return strWS;
	}
	public void setStrWS(WebRowSet strWS) {
		this.strWS = strWS;
	}
	public String getStrMsgString() {
		return strMsgString;
	}
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}
	public String getStrMsgType() {
		return strMsgType;
	}
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}
	public String getStrHospCode() {
		return strHospCode;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrItemId() {
		return strItemId;
	}
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	public String getStrBatchhNo() {
		return strBatchhNo;
	}
	public void setStrBatchhNo(String strBatchhNo) {
		this.strBatchhNo = strBatchhNo;
	}
	public String getIssueChkDetail() {
		return IssueChkDetail;
	}
	public void setIssueChkDetail(String issueChkDetail) {
		IssueChkDetail = issueChkDetail;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public WebRowSet getItemCategWS() {
		return itemCategWS;
	}
	public void setItemCategWS(WebRowSet itemCategWS) {
		this.itemCategWS = itemCategWS;
	}

}
