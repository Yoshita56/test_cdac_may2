package mms.reports.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import javax.sql.rowset.WebRowSet;
import mms.qryHandler_mms;
import mms.reports.vo.FTDStockLedgerRptVO;

public class FTDStockLedgerRptDAO {
   public static void getFYOfDate(FTDStockLedgerRptVO voObj) {
      HisDAO dao = null;
      String strFuncName = "";
      boolean var3 = false;

      try {
         dao = new HisDAO("MMS Transactions", "FTDStockLedgerRptDAO");
         strFuncName = "{? = call MMS_MST.get_financial_year(?,?)}";
         int nFuncIndex = dao.setFunction(strFuncName);
         dao.setFuncInValue(nFuncIndex, 2, "1");
         dao.setFuncInValue(nFuncIndex, 3, voObj.getStrCurrentDate());
         dao.setFuncOutValue(nFuncIndex, 1);
         dao.executeFunction(nFuncIndex);
         String strFYStartDate = dao.getFuncString(nFuncIndex);
         voObj.setStrFYStartDate(strFYStartDate);
      } catch (Exception var6) {
         voObj.setStrMsgType("1");
         voObj.setStrMsgString("FTDStockLedgerRptDAO.getItemName() --> " + var6.getMessage());
      }

   }

   public static void getStoreList(FTDStockLedgerRptVO voObj) {
      HisDAO daoObj = null;
      WebRowSet ws = null;
      String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
     
      String strErr = "";

      try {
         daoObj = new HisDAO("MMS Transactions", "FTDStockLedgerRptDAO");
         int nProcIndex = daoObj.setProcedure(strProcName);
         daoObj.setProcInValue(nProcIndex, "modeval", voObj.getStrMode());
         daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
         daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
         daoObj.setProcInValue(nProcIndex, "storeid", "0");
         daoObj.setProcInValue(nProcIndex, "storetype_id", "0");
         daoObj.setProcOutValue(nProcIndex, "err", 1);
         daoObj.setProcOutValue(nProcIndex, "resultset", 2);
         daoObj.executeProcedure(nProcIndex);
         strErr = daoObj.getString(nProcIndex, "err");
         if (strErr == null) {
            strErr = "";
         }

         if (!strErr.equals("")) {
            throw new Exception(strErr);
         }

         ws = daoObj.getWebRowSet(nProcIndex, "resultset");
         voObj.setStrStoreWs(ws);
      } catch (Exception var10) {
         voObj.setStrMsgString("FTDStockLedgerRptDAO.getStoreList() --> " + var10.getMessage());
         voObj.setStrMsgType("1");
      } finally {
         if (daoObj != null) {
            daoObj.free();
            daoObj = null;
         }

      }

   }

   public static void getItemCatList(FTDStockLedgerRptVO voObj) {
      HisDAO daoObj = null;
      WebRowSet ws = null;
      String strProcName = "{call Pkg_Mms_Rpt.Rptm_item_category_list(?,?,?,?,?)}";
     
      String strErr = "";

      try {
         daoObj = new HisDAO("MMS Transactions", "FTDStockLedgerRptDAO");
         int nProcIndex = daoObj.setProcedure(strProcName);
         daoObj.setProcInValue(nProcIndex, "modeval", "2");
         daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
         daoObj.setProcInValue(nProcIndex, "storeId", voObj.getStrStoreId());
         daoObj.setProcOutValue(nProcIndex, "err", 1);
         daoObj.setProcOutValue(nProcIndex, "resultset", 2);
         daoObj.executeProcedure(nProcIndex);
         strErr = daoObj.getString(nProcIndex, "err");
         if (strErr == null) {
            strErr = "";
         }

         if (!strErr.equals("")) {
            throw new Exception(strErr);
         }

         ws = daoObj.getWebRowSet(nProcIndex, "resultset");
         voObj.setStrItemCatWs(ws);
      } catch (Exception var10) {
         voObj.setStrMsgString("FTDStockLedgerRptDAO.getItemCatList() --> " + var10.getMessage());
         voObj.setStrMsgType("1");
      } finally {
         if (daoObj != null) {
            daoObj.free();
            daoObj = null;
         }

      }

   }

   public static void getSectionList(FTDStockLedgerRptVO vo) {
      String strproc_name = "{call pkg_mms_view.proc_section_list(?,?,?,?)}";
      HisDAO dao = null;
     
      String strErr = "";
      WebRowSet wsResult = null;

      try {
         dao = new HisDAO("MMS", "FTDStockLedgerRptDAO");
         int nProcIndex = dao.setProcedure(strproc_name);
         dao.setProcInValue(nProcIndex, "modeval", "1");
         dao.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode());
         dao.setProcOutValue(nProcIndex, "err", 1);
         dao.setProcOutValue(nProcIndex, "resultset", 2);
         dao.executeProcedure(nProcIndex);
         strErr = dao.getString(nProcIndex, "err");
         if (strErr == null) {
            strErr = "";
         }

         if (!strErr.equals("")) {
            throw new Exception(strErr);
         }

         wsResult = dao.getWebRowSet(nProcIndex, "resultset");
         vo.setStrSectionbWS(wsResult);
         vo.setStrMsgType("0");
      } catch (Exception var10) {
         var10.printStackTrace();
         vo.setStrMsgString("-->FTDStockLedgerRptDAO.getSectionList" + var10.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
            dao = null;
         }

      }

   }

   public static void getGroupList(FTDStockLedgerRptVO voObj) {
      HisDAO daoObj = null;
      WebRowSet ws = null;
      String strProcName = "{call Pkg_Mms_Rpt.rptm_store_group_list(?,?,?,?,?)}";
     
      String strErr = "";

      try {
         daoObj = new HisDAO("MMS Transactions", "FTDStockLedgerRptDAO");
         int nProcIndex = daoObj.setProcedure(strProcName);
         daoObj.setProcInValue(nProcIndex, "modeval", "1");
         daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
         daoObj.setProcInValue(nProcIndex, "item_category", voObj.getStrItemCatId() == null ? "10" : voObj.getStrItemCatId());
         daoObj.setProcOutValue(nProcIndex, "err", 1);
         daoObj.setProcOutValue(nProcIndex, "resultset", 2);
         daoObj.executeProcedure(nProcIndex);
         strErr = daoObj.getString(nProcIndex, "err");
         if (strErr == null) {
            strErr = "";
         }

         if (!strErr.equals("")) {
            throw new Exception(strErr);
         }

         ws = daoObj.getWebRowSet(nProcIndex, "resultset");
         voObj.setStrGroupCmbWS(ws);
      } catch (Exception var10) {
         voObj.setStrMsgString("FTDStockLedgerRptDAO.getGroupList() --> " + var10.getMessage());
         voObj.setStrMsgType("1");
      } finally {
         if (daoObj != null) {
            daoObj.free();
            daoObj = null;
         }

      }

   }

   public static void getItemList(FTDStockLedgerRptVO voObj) {
      HisDAO daoObj = null;
      WebRowSet ws = null;
      String strProcName = "{call Pkg_Mms_Rpt.rptm_itembrand_list(?,?,?,?,? ,?,?)}";
     
      String strErr = "";

      try {
         daoObj = new HisDAO("MMS Transactions", "StockLedgerRptDAO");
         int nProcIndex = daoObj.setProcedure(strProcName);
         String var10000;
         if (voObj.getStrSectionId() != null && voObj.getStrSectionId() != "") {
            voObj.getStrSectionId();
         } else {
            var10000 = "0";
         }

         if (voObj.getStrStoreId() != null && voObj.getStrStoreId() != "") {
            voObj.getStrStoreId();
         } else {
            var10000 = "0";
         }

         daoObj.setProcInValue(nProcIndex, "modeval", "6");
         daoObj.setProcInValue(nProcIndex, "catCode", voObj.getStrItemCatId());
         daoObj.setProcInValue(nProcIndex, "groupid", voObj.getStrGroupId());
         daoObj.setProcInValue(nProcIndex, "subgrpid", "0");
         daoObj.setProcInValue(nProcIndex, "hosp_code", "100");
         daoObj.setProcOutValue(nProcIndex, "err", 1);
         daoObj.setProcOutValue(nProcIndex, "resultset", 2);
         daoObj.executeProcedure(nProcIndex);
         strErr = daoObj.getString(nProcIndex, "err");
         if (strErr == null) {
            strErr = "";
         }

         if (!strErr.equals("")) {
            throw new Exception(strErr);
         }

         ws = daoObj.getWebRowSet(nProcIndex, "resultset");
         voObj.setStrItemWs(ws);
      } catch (Exception var11) {
         voObj.setStrMsgString("StockLedgerRptDAO.getItemList() --> " + var11.getMessage());
         voObj.setStrMsgType("1");
      } finally {
         if (daoObj != null) {
            daoObj.free();
            daoObj = null;
         }

      }

   }

   public static void getData_ORG(FTDStockLedgerRptVO vo) {
      String err = "";
      String strProcName = "{call Pkg_Mms_rpt.Rptm_cons_ledger_dtl(?,?,?,?,?, ?,?,?,?,?)}";
     
      HisDAO dao = null;
      WebRowSet ws = null;
      String var6 = "0";

      try {
         dao = new HisDAO("MMS Reports", "FTDStockLedgerRptDAO");
         HisUtil.replaceNullValueWithEmptyString(vo);
         int procIndex1 = dao.setProcedure(strProcName);
         if (vo.getStrItemCatId().equals("10")) {
            System.out.println("<<------Pkg_Mms_rpt.Rptm_cons_ledger_dtl--[ Mode - 1 ]----->>");
            dao.setProcInValue(procIndex1, "modeval", "1");
         } else {
            System.out.println("<<------Pkg_Mms_rpt.Rptm_cons_ledger_dtl--[ Mode - 2 ] ----->>");
            dao.setProcInValue(procIndex1, "modeval", "2");
         }

         dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
         dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
         dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
         dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
         dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());
         dao.setProcInValue(procIndex1, "catId", vo.getStrItemCatId());
         dao.setProcInValue(procIndex1, "grpId", vo.getStrgroupId() != null && !vo.getStrgroupId().equals("") ? vo.getStrgroupId() : "0");
         dao.setProcOutValue(procIndex1, "err", 1);
         dao.setProcOutValue(procIndex1, "resultset", 2);
         dao.executeProcedure(procIndex1);
         err = dao.getString(procIndex1, "err");
         if (err == null) {
            err = "";
         }

         ws = dao.getWebRowSet(procIndex1, "resultset");
         vo.setWrsData(ws);
      } catch (Exception var11) {
         var11.printStackTrace();
         vo.setStrMsgString("FTDStockLedgerRptDAO.getData_ORG() --> " + var11.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
            dao = null;
         }

      }

   }

   public static void getData(FTDStockLedgerRptVO vo) {
      String err = "";
      String strProcName = "{call pkg_mms_view2.rptm__new_cons_ledger_dtl(?,?,?,?,?, ?,?,?,?,?,  ?)}";
     
      HisDAO dao = null;
      WebRowSet ws = null;
      String var6 = "0";

      try {
         dao = new HisDAO("MMS Reports", "FTDStockLedgerRptDAO");
         HisUtil.replaceNullValueWithEmptyString(vo);
         int procIndex1 = dao.setProcedure(strProcName);
         System.out.println("*********************** FTDStockLedgerRptDAO.getData() ***********************");
         System.out.println("<<------vo.getStrgroupId()---------->>" + vo.getStrgroupId());
         System.out.println("<<------vo.setStrJobInitialDate()--->>" + vo.getStrJobInitialDate());
         System.out.println("<<------vo.getStrFromDate()--------->>" + vo.getStrFromDate());
         System.out.println("<<------vo.getStrToDate()----------->>" + vo.getStrToDate());
         if (vo.getStrItemCatId().equals("10")) {
            System.out.println("<<------pkg_mms_view2.rptm__new_cons_ledger_dtl--[ Mode - 3 ]----->>");
            dao.setProcInValue(procIndex1, "modeval", "3");
         } else {
            System.out.println("<<------pkg_mms_view2.rptm__new_cons_ledger_dtl--[ Mode - 2 ] ----->>");
            dao.setProcInValue(procIndex1, "modeval", "2");
         }

         System.out.println("*****************************************************************************");
         dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
         dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
         dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
         dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
         dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());
         dao.setProcInValue(procIndex1, "jobInitDate", vo.getStrJobInitialDate());
         dao.setProcInValue(procIndex1, "catId", vo.getStrItemCatId());
         dao.setProcInValue(procIndex1, "grpId", vo.getStrgroupId() != null && !vo.getStrgroupId().equals("") ? vo.getStrgroupId() : "0");
         dao.setProcOutValue(procIndex1, "err", 1);
         dao.setProcOutValue(procIndex1, "resultset", 2);
         dao.executeProcedure(procIndex1);
         err = dao.getString(procIndex1, "err");
         if (err == null) {
            err = "";
         }

         ws = dao.getWebRowSet(procIndex1, "resultset");
         vo.setWrsData(ws);
      } catch (Exception var11) {
         var11.printStackTrace();
         vo.setStrMsgString("FTDStockLedgerRptDAO.getData() --> " + var11.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
            dao = null;
         }

      }

   }

   public static void getDetailedStockLedgerDtl(FTDStockLedgerRptVO vo) {
      String err = "";
      String strProcName = "{call Pkg_Mms_view2.rptm_new_dtl_ledger_dtl(?,?,?,?,?, ?,?,?,?)}";
     
      HisDAO dao = null;
      WebRowSet ws = null;

      try {
         System.out.println("*********************** FTDStockLedgerRptDAO.getDetailedStockLedgerDtl() ***********************");
         System.out.println("<<------vo.getStrgroupId()---------->>" + vo.getStrgroupId());
         System.out.println("<<------vo.setStrJobInitialDate()--->>" + vo.getStrJobInitialDate());
         System.out.println("<<------vo.getStrFromDate()--------->>" + vo.getStrFromDate());
         System.out.println("<<------vo.getStrToDate()----------->>" + vo.getStrToDate());
         dao = new HisDAO("MMS Reports", "StockLedgerForSubStoresRptItemNewDAO");
         HisUtil.replaceNullValueWithEmptyString(vo);
         int procIndex1 = dao.setProcedure(strProcName);
         if (vo.getStrItemBrandId().substring(0, 2).equals("10")) {
            dao.setProcInValue(procIndex1, "modeval", "1");
         } else {
            dao.setProcInValue(procIndex1, "modeval", "2");
         }

         dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
         dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
         dao.setProcInValue(procIndex1, "batchNo", vo.getStrBatchNo());
         dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
         dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
         dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());
         dao.setProcOutValue(procIndex1, "err", 1);
         dao.setProcOutValue(procIndex1, "resultset", 2);
         dao.executeProcedure(procIndex1);
         err = dao.getString(procIndex1, "err");
         if (err == null) {
            err = "";
         }

         ws = dao.getWebRowSet(procIndex1, "resultset");
         vo.setWrsData(ws);
      } catch (Exception var10) {
         var10.printStackTrace();
         vo.setStrMsgString("StockLedgerForSubStoresRptItemNewDAO.getData() --> " + var10.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
            dao = null;
         }

      }

   }

   public static void getDetailedStockLedgerDtl_ORG(FTDStockLedgerRptVO vo) {
      String err = "";
      String strProcName = "{call Pkg_Mms_rpt.Rptm_dtl_ledger_dtl(?,?,?,?,?, ?,?,?,?)}";
     
      HisDAO dao = null;
      WebRowSet ws = null;

      try {
         dao = new HisDAO("MMS Reports", "FTDStockLedgerRptDAO");
         HisUtil.replaceNullValueWithEmptyString(vo);
         int procIndex1 = dao.setProcedure(strProcName);
         if (vo.getStrItemBrandId().substring(0, 2).equals("10")) {
            dao.setProcInValue(procIndex1, "modeval", "1");
         } else {
            dao.setProcInValue(procIndex1, "modeval", "2");
         }

         dao.setProcInValue(procIndex1, "storeId", vo.getStrDWHId());
         dao.setProcInValue(procIndex1, "itemId", vo.getStrItemBrandId());
         dao.setProcInValue(procIndex1, "batchNo", vo.getStrBatchNo());
         dao.setProcInValue(procIndex1, "hosp_code", vo.getStrHospitalCode());
         dao.setProcInValue(procIndex1, "frmDate", vo.getStrFromDate());
         dao.setProcInValue(procIndex1, "toDate", vo.getStrToDate());
         dao.setProcOutValue(procIndex1, "err", 1);
         dao.setProcOutValue(procIndex1, "resultset", 2);
         dao.executeProcedure(procIndex1);
         err = dao.getString(procIndex1, "err");
         if (err == null) {
            err = "";
         }

         ws = dao.getWebRowSet(procIndex1, "resultset");
         vo.setWrsData(ws);
      } catch (Exception var10) {
         var10.printStackTrace();
         vo.setStrMsgString("FTDStockLedgerRptDAO.getData() --> " + var10.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
            dao = null;
         }

      }

   }

   public static void getItemTypeValues(FTDStockLedgerRptVO vo) {
      HisDAO dao = null;
      String strQuery = "";
     
      WebRowSet web = null;

      try {
         dao = new HisDAO("MMS", "FTDStockLedgerRptDAO");
         strQuery = qryHandler_mms.getQuery(1, "select.itembrand.itemtype.0");
         int nQueryIndex = dao.setQuery(strQuery);
         dao.setQryValue(nQueryIndex, 1, "100");
         dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatId());
         web = dao.executeQry(nQueryIndex);
         vo.setItemTypeWs(web);
      } catch (Exception var9) {
         vo.setStrMsgString("FTDStockLedgerRptDAO.getItemValues() --> " + var9.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
         }

         dao = null;
         web = null;
      }

   }

   public static void getJobInitializeDate(FTDStockLedgerRptVO vo) {
      HisDAO dao = null;
      String strQuery = "";
    
      WebRowSet web = null;

      try {
         dao = new HisDAO("MMS", "FTDStockLedgerRptDAO");
         strQuery = qryHandler_mms.getQuery(1, "select.job.initialize.date");
         int nQueryIndex = dao.setQuery(strQuery);
         dao.setQryValue(nQueryIndex, 1, "100");
         web = dao.executeQry(nQueryIndex);
         if (web.next()) {
            vo.setStrJobInitialDate(web.getString(1));
         }
      } catch (Exception var9) {
         vo.setStrMsgString("FTDStockLedgerRptDAO.jobinitilize() --> " + var9.getMessage());
         vo.setStrMsgType("1");
      } finally {
         if (dao != null) {
            dao.free();
         }

         dao = null;
         web = null;
      }

   }
}
    