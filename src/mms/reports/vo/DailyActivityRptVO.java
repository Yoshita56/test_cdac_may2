package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class DailyActivityRptVO {
	
	private String strHospitalCode = "";
	private String strSeatId = "";
	
	private String strMsgType = "";
	private String strMsgString = "";
	
	private String strStoreId = "";
	private String strDrugWarehouseTypeId = "";
	private String strCurrentDate;
	private String strFromDate;
	private String strToDate;
	private String strReqStoreID;
	private String strIssueNumber;
	private String strIssueVoucherHiddenVal;
	private String strReceiveVoucherHiddenVal;
	private String SampleSendHiddenVal;
	private String SampleSendItemBatchHiddenVal;
	private String strStoreName;
	private String StrReqStoreName;
	
	
	private WebRowSet StrUserlevelWs = null;
	private WebRowSet strDrugWarehouseTypeWs = null;
	private WebRowSet strManufactureComboWS=null;
	private WebRowSet strIssueVoucherDtlOneWS=null;
	private WebRowSet strIssueVoucherDtlTwoWS=null;
	private WebRowSet strIssueVoucherDtlThreeWS=null;
	
	private WebRowSet strReceiveVoucherDtlOneWS=null;
	private WebRowSet strReceiveVoucherDtlTwoWS=null;
	private WebRowSet strReceiveVoucherDtlThreeWS=null;
	
	private WebRowSet StrSampleSendDtlDtlOneWS=null;
	private WebRowSet StrSampleSendDtlDtlTwoWS=null;
	
	private WebRowSet strStoreWs = null;
	private WebRowSet strIssueDtlWs = null;
	private WebRowSet strIssueItemDtlWs= null;
	private WebRowSet strReceivedItemDtlWs= null;
	private WebRowSet strPOChallanItemDtlWs= null;
	private WebRowSet strChallanItemDtlWs= null;
	
	private String strProcRelatedValue;
	private String strMode;
	
	public String getStrMode() {
		return strMode;
	}
	public void setStrMode(String strMode) {
		this.strMode = strMode;
	}
	public String getStrProcRelatedValue() {
		return strProcRelatedValue;
	}
	public void setStrProcRelatedValue(String strProcRelatedValue) {
		this.strProcRelatedValue = strProcRelatedValue;
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
	public WebRowSet getStrManufactureComboWS() {
		return strManufactureComboWS;
	}
	public void setStrManufactureComboWS(WebRowSet strManufactureComboWS) {
		this.strManufactureComboWS = strManufactureComboWS;
	}
	public String getStrCurrentDate() {
		return strCurrentDate;
	}
	public void setStrCurrentDate(String strCurrentDate) {
		this.strCurrentDate = strCurrentDate;
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
	public WebRowSet getStrIssueDtlWs() {
		return strIssueDtlWs;
	}
	public void setStrIssueDtlWs(WebRowSet strIssueDtlWs) {
		this.strIssueDtlWs = strIssueDtlWs;
	}
	public WebRowSet getStrIssueItemDtlWs() {
		return strIssueItemDtlWs;
	}
	public void setStrIssueItemDtlWs(WebRowSet strIssueItemDtlWs) {
		this.strIssueItemDtlWs = strIssueItemDtlWs;
	}
	public String getStrIssueNumber() {
		return strIssueNumber;
	}
	public void setStrIssueNumber(String strIssueNumber) {
		this.strIssueNumber = strIssueNumber;
	}
	public WebRowSet getStrReceivedItemDtlWs() {
		return strReceivedItemDtlWs;
	}
	public void setStrReceivedItemDtlWs(WebRowSet strReceivedItemDtlWs) {
		this.strReceivedItemDtlWs = strReceivedItemDtlWs;
	}
	public String getStrIssueVoucherHiddenVal() {
		return strIssueVoucherHiddenVal;
	}
	public void setStrIssueVoucherHiddenVal(String strIssueVoucherHiddenVal) {
		this.strIssueVoucherHiddenVal = strIssueVoucherHiddenVal;
	}
	public String getStrReceiveVoucherHiddenVal() {
		return strReceiveVoucherHiddenVal;
	}
	public void setStrReceiveVoucherHiddenVal(String strReceiveVoucherHiddenVal) {
		this.strReceiveVoucherHiddenVal = strReceiveVoucherHiddenVal;
	}
	public WebRowSet getStrIssueVoucherDtlOneWS() {
		return strIssueVoucherDtlOneWS;
	}
	public void setStrIssueVoucherDtlOneWS(WebRowSet strIssueVoucherDtlOneWS) {
		this.strIssueVoucherDtlOneWS = strIssueVoucherDtlOneWS;
	}
	public WebRowSet getStrIssueVoucherDtlTwoWS() {
		return strIssueVoucherDtlTwoWS;
	}
	public void setStrIssueVoucherDtlTwoWS(WebRowSet strIssueVoucherDtlTwoWS) {
		this.strIssueVoucherDtlTwoWS = strIssueVoucherDtlTwoWS;
	}
	public WebRowSet getStrIssueVoucherDtlThreeWS() {
		return strIssueVoucherDtlThreeWS;
	}
	public void setStrIssueVoucherDtlThreeWS(WebRowSet strIssueVoucherDtlThreeWS) {
		this.strIssueVoucherDtlThreeWS = strIssueVoucherDtlThreeWS;
	}
	public WebRowSet getStrReceiveVoucherDtlOneWS() {
		return strReceiveVoucherDtlOneWS;
	}
	public void setStrReceiveVoucherDtlOneWS(WebRowSet strReceiveVoucherDtlOneWS) {
		this.strReceiveVoucherDtlOneWS = strReceiveVoucherDtlOneWS;
	}
	public WebRowSet getStrReceiveVoucherDtlTwoWS() {
		return strReceiveVoucherDtlTwoWS;
	}
	public void setStrReceiveVoucherDtlTwoWS(WebRowSet strReceiveVoucherDtlTwoWS) {
		this.strReceiveVoucherDtlTwoWS = strReceiveVoucherDtlTwoWS;
	}
	public WebRowSet getStrReceiveVoucherDtlThreeWS() {
		return strReceiveVoucherDtlThreeWS;
	}
	public void setStrReceiveVoucherDtlThreeWS(WebRowSet strReceiveVoucherDtlThreeWS) {
		this.strReceiveVoucherDtlThreeWS = strReceiveVoucherDtlThreeWS;
	}
	public String getStrReqStoreID() {
		return strReqStoreID;
	}
	public void setStrReqStoreID(String strReqStoreID) {
		this.strReqStoreID = strReqStoreID;
	}
	public String getStrStoreName() {
		return strStoreName;
	}
	public void setStrStoreName(String strStoreName) {
		this.strStoreName = strStoreName;
	}
	public WebRowSet getStrPOChallanItemDtlWs() {
		return strPOChallanItemDtlWs;
	}
	public void setStrPOChallanItemDtlWs(WebRowSet strPOChallanItemDtlWs) {
		this.strPOChallanItemDtlWs = strPOChallanItemDtlWs;
	}
	public WebRowSet getStrChallanItemDtlWs() {
		return strChallanItemDtlWs;
	}
	public void setStrChallanItemDtlWs(WebRowSet strChallanItemDtlWs) {
		this.strChallanItemDtlWs = strChallanItemDtlWs;
	}
	public String getStrReqStoreName() {
		return StrReqStoreName;
	}
	public void setStrReqStoreName(String strReqStoreName) {
		StrReqStoreName = strReqStoreName;
	}
	public String getSampleSendHiddenVal() {
		return SampleSendHiddenVal;
	}
	public void setSampleSendHiddenVal(String sampleSendHiddenVal) {
		SampleSendHiddenVal = sampleSendHiddenVal;
	}
	public WebRowSet getStrSampleSendDtlDtlOneWS() {
		return StrSampleSendDtlDtlOneWS;
	}
	public void setStrSampleSendDtlDtlOneWS(WebRowSet strSampleSendDtlDtlOneWS) {
		StrSampleSendDtlDtlOneWS = strSampleSendDtlDtlOneWS;
	}
	public String getSampleSendItemBatchHiddenVal() {
		return SampleSendItemBatchHiddenVal;
	}
	public void setSampleSendItemBatchHiddenVal(String sampleSendItemBatchHiddenVal) {
		SampleSendItemBatchHiddenVal = sampleSendItemBatchHiddenVal;
	}
	public WebRowSet getStrSampleSendDtlDtlTwoWS() {
		return StrSampleSendDtlDtlTwoWS;
	}
	public void setStrSampleSendDtlDtlTwoWS(WebRowSet strSampleSendDtlDtlTwoWS) {
		StrSampleSendDtlDtlTwoWS = strSampleSendDtlDtlTwoWS;
	}
	public WebRowSet getStrUserlevelWs() {
		return StrUserlevelWs;
	}
	public void setStrUserlevelWs(WebRowSet strUserlevelWs) {
		StrUserlevelWs = strUserlevelWs;
	}


}

