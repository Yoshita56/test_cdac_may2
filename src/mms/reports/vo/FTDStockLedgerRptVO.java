package mms.reports.vo;

import javax.sql.rowset.WebRowSet;

public class FTDStockLedgerRptVO {
   private String strHospitalCode = "";
   private String strSeatId = "";
   private String strMsgType = "";
   private String strMsgString = "";
   private String strStoreId = "";
   private String strGroupId = "";
   private String strItemCatId = "";
   private String strWhetherBatchWise;
   private String strDWHId;
   private String strItemId;
   private String strMode;
   private String strFromDate;
   private String strToDate;
   private String strBatchFlag;
   private String strItemBrandId;
   private String strDrugName;
   private String strStoreName;
   private String strOpeningBalance;
   private WebRowSet strItemCatWs;
   private WebRowSet strStoreWs;
   private WebRowSet strGroupWs;
   private WebRowSet strItemWs;
   private WebRowSet strStockLedgerDtlWs;
   private WebRowSet wrsData;
   private String strBatchNo;
   private String strExpDate;
   private WebRowSet itemTypeWs = null;
   private WebRowSet strGroupCmbWS = null;
   private String strItemType;
   private String strSectionName = "";
   private String strSectionId = "";
   private WebRowSet strSectionbWS = null;
   private String strJobInitialDate;
   private String strgroupId = "";
   private String strValueWise = "";
   private String strFYStartDate = "";
   private String strCurrentDate = "";

   public String getStrCurrentDate() {
      return this.strCurrentDate;
   }

   public void setStrCurrentDate(String strCurrentDate) {
      this.strCurrentDate = strCurrentDate;
   }

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

   public String getStrgroupId() {
      return this.strgroupId;
   }

   public void setStrgroupId(String strgroupId) {
      this.strgroupId = strgroupId;
   }

   public String getStrJobInitialDate() {
      return this.strJobInitialDate;
   }

   public void setStrJobInitialDate(String strJobInitialDate) {
      this.strJobInitialDate = strJobInitialDate;
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

   public WebRowSet getStrSectionbWS() {
      return this.strSectionbWS;
   }

   public void setStrSectionbWS(WebRowSet strSectionbWS) {
      this.strSectionbWS = strSectionbWS;
   }

   public WebRowSet getWrsData() {
      return this.wrsData;
   }

   public void setWrsData(WebRowSet wrsData) {
      this.wrsData = wrsData;
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

   public String getStrMsgType() {
      return this.strMsgType;
   }

   public void setStrMsgType(String strMsgType) {
      this.strMsgType = strMsgType;
   }

   public String getStrMsgString() {
      return this.strMsgString;
   }

   public void setStrMsgString(String strMsgString) {
      this.strMsgString = strMsgString;
   }

   public String getStrStoreId() {
      return this.strStoreId;
   }

   public void setStrStoreId(String strStoreId) {
      this.strStoreId = strStoreId;
   }

   public String getStrItemCatId() {
      return this.strItemCatId;
   }

   public void setStrItemCatId(String strItemCatId) {
      this.strItemCatId = strItemCatId;
   }

   public WebRowSet getStrItemCatWs() {
      return this.strItemCatWs;
   }

   public void setStrItemCatWs(WebRowSet strItemCatWs) {
      this.strItemCatWs = strItemCatWs;
   }

   public WebRowSet getStrStoreWs() {
      return this.strStoreWs;
   }

   public void setStrStoreWs(WebRowSet strStoreWs) {
      this.strStoreWs = strStoreWs;
   }

   public WebRowSet getStrGroupWs() {
      return this.strGroupWs;
   }

   public void setStrGroupWs(WebRowSet strGroupWs) {
      this.strGroupWs = strGroupWs;
   }

   public String getStrGroupId() {
      return this.strGroupId;
   }

   public void setStrGroupId(String strGroupId) {
      this.strGroupId = strGroupId;
   }

   public WebRowSet getStrItemWs() {
      return this.strItemWs;
   }

   public void setStrItemWs(WebRowSet strItemWs) {
      this.strItemWs = strItemWs;
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

   public String getStrWhetherBatchWise() {
      return this.strWhetherBatchWise;
   }

   public void setStrWhetherBatchWise(String strWhetherBatchWise) {
      this.strWhetherBatchWise = strWhetherBatchWise;
   }

   public String getStrItemId() {
      return this.strItemId;
   }

   public void setStrItemId(String strItemId) {
      this.strItemId = strItemId;
   }

   public WebRowSet getStrStockLedgerDtlWs() {
      return this.strStockLedgerDtlWs;
   }

   public void setStrStockLedgerDtlWs(WebRowSet strStockLedgerDtlWs) {
      this.strStockLedgerDtlWs = strStockLedgerDtlWs;
   }

   public String getStrMode() {
      return this.strMode;
   }

   public void setStrMode(String strMode) {
      this.strMode = strMode;
   }

   public String getStrDWHId() {
      return this.strDWHId;
   }

   public void setStrDWHId(String strDWHId) {
      this.strDWHId = strDWHId;
   }

   public String getStrBatchFlag() {
      return this.strBatchFlag;
   }

   public void setStrBatchFlag(String strBatchFlag) {
      this.strBatchFlag = strBatchFlag;
   }

   public String getStrItemBrandId() {
      return this.strItemBrandId;
   }

   public void setStrItemBrandId(String strItemBrandId) {
      this.strItemBrandId = strItemBrandId;
   }

   public String getStrDrugName() {
      return this.strDrugName;
   }

   public void setStrDrugName(String strDrugName) {
      this.strDrugName = strDrugName;
   }

   public String getStrStoreName() {
      return this.strStoreName;
   }

   public void setStrStoreName(String strStoreName) {
      this.strStoreName = strStoreName;
   }

   public String getStrOpeningBalance() {
      return this.strOpeningBalance;
   }

   public void setStrOpeningBalance(String strOpeningBalance) {
      this.strOpeningBalance = strOpeningBalance;
   }

   public String getStrBatchNo() {
      return this.strBatchNo;
   }

   public void setStrBatchNo(String strBatchNo) {
      this.strBatchNo = strBatchNo;
   }

   public String getStrExpDate() {
      return this.strExpDate;
   }

   public void setStrExpDate(String strExpDate) {
      this.strExpDate = strExpDate;
   }

   public WebRowSet getItemTypeWs() {
      return this.itemTypeWs;
   }

   public void setItemTypeWs(WebRowSet itemTypeWs) {
      this.itemTypeWs = itemTypeWs;
   }

   public WebRowSet getStrGroupCmbWS() {
      return this.strGroupCmbWS;
   }

   public void setStrGroupCmbWS(WebRowSet strGroupCmbWS) {
      this.strGroupCmbWS = strGroupCmbWS;
   }

   public String getStrItemType() {
      return this.strItemType;
   }

   public void setStrItemType(String strItemType) {
      this.strItemType = strItemType;
   }
}