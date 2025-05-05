package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class FTDStockLedgerRptFB extends ActionForm {
   private static final long serialVersionUID = 1L;
   private String strHospitalCode = "";
   private String strSeatId = "";
   private String strErrMsg = "";
   private String strNormalMsg = "";
   private String strWarningMsg = "";
   private String strReportId = "";
   private String strUserRemarks = "";
   private String strReportFormat = "";
   private String strIsFooter = "";
   private String strItemCatNo = "";
   private String strStoreId = "";
   private String strItemId = "";
   private String strGroupId = "";
   private String strStoreName = "";
   private String strDrugName = "";
   private String strCurrentDate = "";
   private String strFromDate = "";
   private String strToDate = "";
   private String strItemValues = "";
   private String strStoreValues = "";
   private String strWhetherBatchWise;
   private String strStockLedgerPopUp;
   private String strStockLedgerDetails;
   private String strItemTypeValues;
   private String[] strLeftItemIds = null;
   private String strLeftItemList = "";
   private String[] strRightItemIds = null;
   private String strRightItemList = "";
   private String strItemType;
   private String strItemBrandId = "0";
   private String strGroupCombo;
   private String strCatCombo;
   private String strJobInitialDate;
   private String strValueWise;
   private String strFYStartDate = "";
   private String strSectionName = "";
   private String strSectionId = "";
   private String strHtmlCode = "";

   public String getStrFYStartDate() {
      return this.strFYStartDate;
   }

   public void setStrFYStartDate(String strFYStartDate) {
      this.strFYStartDate = strFYStartDate;
   }

   public String getStrValueWise() {
      return this.strValueWise;
   }

   public void setStrValueWise(String strValueWise) {
      this.strValueWise = strValueWise;
   }

   public String getStrJobInitialDate() {
      return this.strJobInitialDate;
   }

   public void setStrJobInitialDate(String strJobInitialDate) {
      this.strJobInitialDate = strJobInitialDate;
   }

   public String getStrCatCombo() {
      return this.strCatCombo;
   }

   public void setStrCatCombo(String strCatCombo) {
      this.strCatCombo = strCatCombo;
   }

   public String getStrSectionName() {
      return this.strSectionName;
   }

   public void setStrSectionName(String strSectionName) {
      this.strSectionName = strSectionName;
   }

   public String getStrSectionId() {
      return this.strSectionId;
   }

   public void setStrSectionId(String strSectionId) {
      this.strSectionId = strSectionId;
   }

   public String getStrHtmlCode() {
      return this.strHtmlCode;
   }

   public void setStrHtmlCode(String strHtmlCode) {
      this.strHtmlCode = strHtmlCode;
   }

   public String getStrGroupCombo() {
      return this.strGroupCombo;
   }

   public void setStrGroupCombo(String strGroupCombo) {
      this.strGroupCombo = strGroupCombo;
   }

   public String getStrStockLedgerDetails() {
      return this.strStockLedgerDetails;
   }

   public void setStrStockLedgerDetails(String strStockLedgerDetails) {
      this.strStockLedgerDetails = strStockLedgerDetails;
   }

   public String getStrStockLedgerPopUp() {
      return this.strStockLedgerPopUp;
   }

   public void setStrStockLedgerPopUp(String strStockLedgerPopUp) {
      this.strStockLedgerPopUp = strStockLedgerPopUp;
   }

   public String getStrStoreValues() {
      return this.strStoreValues;
   }

   public void setStrStoreValues(String strStoreValues) {
      this.strStoreValues = strStoreValues;
   }

   public String getStrHospitalCode() {
      return this.strHospitalCode;
   }

   public void setStrHospitalCode(String strHospitalCode) {
      this.strHospitalCode = strHospitalCode;
   }

   public String getStrSeatId() {
      return this.strSeatId;
   }

   public void setStrSeatId(String strSeatId) {
      this.strSeatId = strSeatId;
   }

   public String getStrErrMsg() {
      return this.strErrMsg;
   }

   public void setStrErrMsg(String strErrMsg) {
      this.strErrMsg = strErrMsg;
   }

   public String getStrNormalMsg() {
      return this.strNormalMsg;
   }

   public void setStrNormalMsg(String strNormalMsg) {
      this.strNormalMsg = strNormalMsg;
   }

   public String getStrWarningMsg() {
      return this.strWarningMsg;
   }

   public void setStrWarningMsg(String strWarningMsg) {
      this.strWarningMsg = strWarningMsg;
   }

   public String getStrReportId() {
      return this.strReportId;
   }

   public void setStrReportId(String strReportId) {
      this.strReportId = strReportId;
   }

   public String getStrUserRemarks() {
      return this.strUserRemarks;
   }

   public void setStrUserRemarks(String strUserRemarks) {
      this.strUserRemarks = strUserRemarks;
   }

   public String getStrReportFormat() {
      return this.strReportFormat;
   }

   public void setStrReportFormat(String strReportFormat) {
      this.strReportFormat = strReportFormat;
   }

   public String getStrIsFooter() {
      return this.strIsFooter;
   }

   public void setStrIsFooter(String strIsFooter) {
      this.strIsFooter = strIsFooter;
   }

   public String getStrItemCatNo() {
      return this.strItemCatNo;
   }

   public void setStrItemCatNo(String strItemCatNo) {
      this.strItemCatNo = strItemCatNo;
   }

   public String getStrStoreId() {
      return this.strStoreId;
   }

   public void setStrStoreId(String strStoreId) {
      this.strStoreId = strStoreId;
   }

   public String getStrStoreName() {
      return this.strStoreName;
   }

   public void setStrStoreName(String strStoreName) {
      this.strStoreName = strStoreName;
   }

   public String getStrCurrentDate() {
      return this.strCurrentDate;
   }

   public void setStrCurrentDate(String strCurrentDate) {
      this.strCurrentDate = strCurrentDate;
   }

   public String getStrFromDate() {
      return this.strFromDate;
   }

   public void setStrFromDate(String strFromDate) {
      this.strFromDate = strFromDate;
   }

   public String getStrToDate() {
      return this.strToDate;
   }

   public void setStrToDate(String strToDate) {
      this.strToDate = strToDate;
   }

   public String getStrItemId() {
      return this.strItemId;
   }

   public void setStrItemId(String strItemId) {
      this.strItemId = strItemId;
   }

   public String getStrGroupId() {
      return this.strGroupId;
   }

   public void setStrGroupId(String strGroupId) {
      this.strGroupId = strGroupId;
   }

   public String getStrItemValues() {
      return this.strItemValues;
   }

   public void setStrItemValues(String strItemValues) {
      this.strItemValues = strItemValues;
   }

   public String getStrWhetherBatchWise() {
      return this.strWhetherBatchWise;
   }

   public void setStrWhetherBatchWise(String strWhetherBatchWise) {
      this.strWhetherBatchWise = strWhetherBatchWise;
   }

   public String getStrDrugName() {
      return this.strDrugName;
   }

   public void setStrDrugName(String strDrugName) {
      this.strDrugName = strDrugName;
   }

   public String getStrItemTypeValues() {
      return this.strItemTypeValues;
   }

   public void setStrItemTypeValues(String strItemTypeValues) {
      this.strItemTypeValues = strItemTypeValues;
   }

   public String[] getStrLeftItemIds() {
      return this.strLeftItemIds;
   }

   public void setStrLeftItemIds(String[] strLeftItemIds) {
      this.strLeftItemIds = strLeftItemIds;
   }

   public String getStrLeftItemList() {
      return this.strLeftItemList;
   }

   public void setStrLeftItemList(String strLeftItemList) {
      this.strLeftItemList = strLeftItemList;
   }

   public String[] getStrRightItemIds() {
      return this.strRightItemIds;
   }

   public void setStrRightItemIds(String[] strRightItemIds) {
      this.strRightItemIds = strRightItemIds;
   }

   public String getStrRightItemList() {
      return this.strRightItemList;
   }

   public void setStrRightItemList(String strRightItemList) {
      this.strRightItemList = strRightItemList;
   }

   public String getStrItemType() {
      return this.strItemType;
   }

   public void setStrItemType(String strItemType) {
      this.strItemType = strItemType;
   }

   public String getStrItemBrandId() {
      return this.strItemBrandId;
   }

   public void setStrItemBrandId(String strItemBrandId) {
      this.strItemBrandId = strItemBrandId;
   }
}