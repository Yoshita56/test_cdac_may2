 package mms.reports.bo;

import hisglobal.transactionmgnt.HisDAO;
import mms.reports.dao.FTDStockLedgerRptDAO;
import mms.reports.vo.FTDStockLedgerRptVO;

public class FTDStockLedgerRptBO {
   public void getStoreList(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getStoreList(voObj);
      FTDStockLedgerRptDAO.getFYOfDate(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getStoreList()-->" + strErr);
      }

   }

   public void getItemCatList(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getItemCatList(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemCatList()-->" + strErr);
      }

   }

   public void getGroupList(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getGroupList(voObj);
      FTDStockLedgerRptDAO.getItemTypeValues(voObj);
      String strErr;
      if (voObj.getStrMsgType().equals("1")) {
         strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getGroupList()-->" + strErr);
      }

      if (voObj.getStrMsgType().equals("1")) {
         strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getGroupList()-->" + strErr);
      }

   }

   public void getItemList(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getItemList(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
      }

   }

   public void getConsolidatedStockLedgerDtl(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getData(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
      }

   }

   public void getDetailedStockLedgerDtl(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getDetailedStockLedgerDtl(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getItemList()-->" + strErr);
      }

   }

   public void getItemName(FTDStockLedgerRptVO voObj) {
      HisDAO dao = null;
      String strFuncName = "";
      boolean var4 = false;

      try {
         dao = new HisDAO("MMS Transactions", "FTDStockLedgerRptDAO");
         strFuncName = "{? = call MMS_MST.get_item_dtl(?,?,?)}";
         int nFuncIndex = dao.setFunction(strFuncName);
         dao.setFuncInValue(nFuncIndex, 2, "1");
         dao.setFuncInValue(nFuncIndex, 3, voObj.getStrHospitalCode());
         dao.setFuncInValue(nFuncIndex, 4, voObj.getStrItemBrandId());
         dao.setFuncOutValue(nFuncIndex, 1);
         dao.executeFunction(nFuncIndex);
         String strDrugName = dao.getFuncString(nFuncIndex);
         voObj.setStrDrugName(strDrugName);
      } catch (Exception var7) {
         voObj.setStrMsgType("1");
         voObj.setStrMsgString("FTDStockLedgerRptDAO.getItemName() --> " + var7.getMessage());
      }

   }

   public void getJobInitializeDate(FTDStockLedgerRptVO voObj) {
      FTDStockLedgerRptDAO.getJobInitializeDate(voObj);
      if (voObj.getStrMsgType().equals("1")) {
         String strErr = voObj.getStrMsgString();
         voObj.setStrMsgString("StockLedgerForSubStoresRptItemNewBO.getJobInitializeDate()-->" + strErr);
      }

   }
}