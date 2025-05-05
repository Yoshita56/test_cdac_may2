package mms.reports.controller.data;

import hisglobal.utility.HisUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.MmsConfigUtil;
import mms.reports.bo.FTDStockLedgerRptBO;
import mms.reports.controller.fb.FTDStockLedgerRptFB;
import mms.reports.controller.hlp.FTDStockLedgerRptHLP;
import mms.reports.vo.FTDStockLedgerRptVO;

public class FTDStockLedgerRptDATA {
   public static void getInitVal(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO voObj = null;
      String strMsgText = null;
      String strStoreVal = "";
      HisUtil util = null;

      try {
         util = new HisUtil("MMS Transactions", "FTDStockLedgerRptDATA");
         bo = new FTDStockLedgerRptBO();
         voObj = new FTDStockLedgerRptVO();
         voObj.setStrHospitalCode(formBean.getStrHospitalCode());
         voObj.setStrSeatId(formBean.getStrSeatId());
         util.getASDate("dd-MMM-yyyy");
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
         Calendar c1 = Calendar.getInstance();
         c1.add(5, 0);
         formBean.setStrCurrentDate(sdf.format(c1.getTime()));
         voObj.setStrCurrentDate(sdf.format(c1.getTime()));
         voObj.setStrMode("8");
         voObj.setStrItemCatId("0");
         voObj.setStrGroupId("0");
         bo.getStoreList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().next()) {
            voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
            voObj.getStrStoreWs().beforeFirst();
         }

         strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^Select Value", false);
         bo.getItemCatList(voObj);
         if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().next()) {
            voObj.setStrItemCatId("0");
            voObj.getStrItemCatWs().beforeFirst();
         }

         String temp2 = "";
         if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().size() > 0) {
            util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^All", true);
         } else {
            temp2 = "<option value='0'>All</option>";
         }

         String strGroupId = "0";
         String strItemType = "0";
         voObj.setStrGroupId(strGroupId + "^" + strItemType);
         bo.getGroupList(voObj);
         if (voObj.getStrGroupCmbWS() != null && voObj.getStrGroupCmbWS().next()) {
            voObj.setStrGroupId("0");
            voObj.getStrGroupCmbWS().beforeFirst();
         }

         String temp1 = "";
         if (voObj.getStrGroupCmbWS() != null && voObj.getStrGroupCmbWS().size() > 0) {
            util.getOptionValue(voObj.getStrGroupCmbWS(), "0", "0^All", true);
         } else {
            temp1 = "<option value='0'>All</option>";
         }

         bo.getItemList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         String strItemValues = "<option value='0'>All</option>";
         if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {
            strItemValues = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All", true);
            voObj.getStrItemWs().beforeFirst();
         } else {
            strItemValues = "<option value='0'>All</option>";
         }

         formBean.setStrItemTypeValues(util.getOptionValue(voObj.getItemTypeWs(), "0", "0^All", false));
         formBean.setStrItemValues(strItemValues);
         formBean.setStrStoreValues(strStoreVal);
         bo.getJobInitializeDate(voObj);
         formBean.setStrJobInitialDate(voObj.getStrJobInitialDate());
         formBean.setStrFYStartDate(voObj.getStrFYStartDate());
      } catch (Exception var18) {
         strMsgText = var18.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (voObj != null) {
            voObj = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getItemCatList(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO voObj = null;
      String strMsgText = null;
      HisUtil util = null;

      try {
         bo = new FTDStockLedgerRptBO();
         voObj = new FTDStockLedgerRptVO();
         String strStoreId = request.getParameter("storeId");
         if (strStoreId == null) {
            strStoreId = "0";
         }

         voObj.setStrStoreId(strStoreId);
         voObj.setStrHospitalCode(formBean.getStrHospitalCode());
         bo.getItemCatList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         util = new HisUtil("MMS Transactions", "FTDStockLedgerRptDATA");
         String temp = "<option value='0'>SelectValue</option>";
         if (voObj.getStrItemCatWs().size() != 0) {
            temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", true);
         } else {
            temp = "<option value='0'>SelectValue</option>";
         }

         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(temp);
      } catch (Exception var12) {
         strMsgText = var12.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (voObj != null) {
            voObj = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getGroupList(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO voObj = null;
      String strMsgText = null;
      HisUtil util = null;

      try {
         bo = new FTDStockLedgerRptBO();
         voObj = new FTDStockLedgerRptVO();
         String strItemCatId = request.getParameter("itemCatId");
         if (strItemCatId == null) {
            strItemCatId = "0";
         }

         voObj.setStrItemCatId(strItemCatId);
         voObj.setStrHospitalCode(formBean.getStrHospitalCode());
         bo.getGroupList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         util = new HisUtil("MMS Transactions", "FTDStockLedgerRptDATA");
         String temp = "<option value='0'>All</option>";
         if (voObj.getStrGroupCmbWS().size() != 0) {
            temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0", "0^All", true);
         } else {
            temp = "<option value='0'>All</option>";
         }

         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(temp);
      } catch (Exception var12) {
         strMsgText = var12.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (voObj != null) {
            voObj = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getItemList(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO voObj = null;
      String strMsgText = null;
      HisUtil util = null;

      try {
         bo = new FTDStockLedgerRptBO();
         voObj = new FTDStockLedgerRptVO();
         String strStoreId = request.getParameter("storeId");
         String strItemCatId = request.getParameter("itemCatId");
         String strGroupId = request.getParameter("groupId");
         if (strItemCatId == null) {
            strItemCatId = "0";
         }

         if (strStoreId == null) {
            strStoreId = "0";
         }

         if (strGroupId == null) {
            strGroupId = "0";
         }

         voObj.setStrItemCatId(strItemCatId);
         voObj.setStrStoreId(strStoreId);
         voObj.setStrGroupId(strGroupId);
         voObj.setStrHospitalCode(formBean.getStrHospitalCode());
         bo.getItemList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         util = new HisUtil("MMS Transactions", "FTDStockLedgerRptDATA");
         String temp = "<option value='0'>All</option>";
         if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {
            temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All", true);
         } else {
            temp = "<option value='0'>All</option>";
         }

         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(temp);
      } catch (Exception var14) {
         strMsgText = var14.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (voObj != null) {
            voObj = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getStockLedgerDtl(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO vo = null;
      FTDStockLedgerRptHLP hlp = null;
      HisUtil util = null;
      String var7 = null;

      try 
      {
         System.out.println("<<------FTDStockLedgerRptDATA.getStockLedgerDtl----->>");
         bo = new FTDStockLedgerRptBO();
         vo = new FTDStockLedgerRptVO();
         hlp = new FTDStockLedgerRptHLP();
         new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
         vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
         vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
         vo.setStrDWHId(request.getParameter("storeId") != null && !request.getParameter("storeId").equals("") ? request.getParameter("storeId") : "0");
         vo.setStrItemBrandId(request.getParameter("itembrandId") != null && !request.getParameter("itembrandId").equals("") && !request.getParameter("itembrandId").equals("0") ? request.getParameter("itembrandId").split("^")[0] : "0");
         vo.setStrFromDate(request.getParameter("fromDate"));
         vo.setStrToDate(request.getParameter("toDate"));
         vo.setStrWhetherBatchWise(request.getParameter("batchFlag") != null && !request.getParameter("batchFlag").equals("") ? request.getParameter("batchFlag") : "0");
         vo.setStrItemCatId(request.getParameter("strItemCatId") != null && !request.getParameter("strItemCatId").equals("") ? request.getParameter("strItemCatId") : "0");
         vo.setStrgroupId(request.getParameter("strgroupId") != null && !request.getParameter("strgroupId").equals("") ? request.getParameter("strgroupId") : "0");
         vo.setStrValueWise(request.getParameter("valueFlag") != null && !request.getParameter("valueFlag").equals("") ? request.getParameter("valueFlag") : "0");
         vo.setStrJobInitialDate(request.getParameter("strJobInitialDate"));
        
         System.out.println("**********************************************");
         System.out.println("---------Store Id -------" + vo.getStrDWHId());
         System.out.println("---------Brand Id -------" + vo.getStrItemBrandId());
         System.out.println("---------From Date-------" + vo.getStrFromDate());
         System.out.println("---------To Date  -------" + vo.getStrToDate());
         System.out.println("---------Batch Flg-------" + vo.getStrWhetherBatchWise());
         System.out.println("---------Value Wise------" + vo.getStrValueWise());
         System.out.println("---------Sub Grp   ------" + vo.getStrgroupId());
         System.out.println("---------Ledger_INT_DATE-" + vo.getStrJobInitialDate());        
         
         if (vo.getStrWhetherBatchWise().equals("1")) 
         {
            vo.setStrMode("1");
         } else {
            vo.setStrMode("2");
         }
         System.out.println("---------Mode     ------" + vo.getStrMode());
         System.out.println("**********************************************");

         bo.getConsolidatedStockLedgerDtl(vo);
         String strStockLedgerDetails = "";
         response.setContentType("text/html;charset=UTF-8");
         if (vo.getStrMode().equals("1")) 
         {
            if (vo.getStrValueWise().equals("0")) 
            {
               System.out.println("<<------hlp.getStockLedgerDtlBatch----->>");
               strStockLedgerDetails = hlp.getStockLedgerDtlBatch(vo, request);
            } 
            else 
            {
               System.out.println("<<------hlp.getStockLedgerDtlBatch_ValueWiseRpt----->>");
               strStockLedgerDetails = hlp.getStockLedgerDtlBatch_ValueWiseRpt(vo, request);
            }
         } 
         else if (vo.getStrValueWise().equals("0")) 
         {
            System.out.println("<<------hlp.getStockLedgerDtl----->>");
            strStockLedgerDetails = hlp.getStockLedgerDtl(vo, request);
         } 
         else 
         {
            System.out.println("<<------hlp.getStockLedgerDtl_ValueRpt----->>");
            strStockLedgerDetails = hlp.getStockLedgerDtl_ValueRpt(vo, request);
         }

         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(strStockLedgerDetails);
         if (vo.getStrMsgType().equals("1")) 
         {
            throw new Exception(vo.getStrMsgString());
         }
      } catch (Exception var12) {
         var7 = var12.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (vo != null) {
            vo = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getConsolidatedStockLedgerReport(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO vo = null;
      HisUtil util = null;
      String strMsgText = null;
      FTDStockLedgerRptHLP hlp = null;

      try {
         
         bo = new FTDStockLedgerRptBO();
         vo = new FTDStockLedgerRptVO();
         hlp = new FTDStockLedgerRptHLP();
         vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
         vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
         vo.setStrDWHId(request.getParameter("storeId") != null && !request.getParameter("storeId").equals("") ? request.getParameter("storeId") : "0");
         vo.setStrItemBrandId(request.getParameter("itembrandId") != null && !request.getParameter("itembrandId").equals("") && !request.getParameter("itembrandId").equals("0") ? request.getParameter("itembrandId").split("^")[0] : "0");
         vo.setStrFromDate(request.getParameter("fromDate"));
         vo.setStrToDate(request.getParameter("toDate"));
         vo.setStrWhetherBatchWise(request.getParameter("batchFlag") != null && !request.getParameter("batchFlag").equals("") ? request.getParameter("batchFlag") : "0");
         vo.setStrgroupId(request.getParameter("strgroupId") != null && !request.getParameter("strgroupId").equals("") ? request.getParameter("strgroupId") : "0");
         vo.setStrStoreName(request.getParameter("storeName"));
         vo.setStrValueWise(request.getParameter("valueFlag") != null && !request.getParameter("valueFlag").equals("") ? request.getParameter("valueFlag") : "0");
         vo.setStrJobInitialDate(request.getParameter("strJobInitialDate"));
         
         System.out.println("----------- FTDStockLedgerRptDATA.getConsolidatedStockLedgerRpt -----------");       
         System.out.println("---------Store Id -------" + vo.getStrDWHId());
         System.out.println("---------Brand Id -------" + vo.getStrItemBrandId());
         System.out.println("---------From Date-------" + vo.getStrFromDate());
         System.out.println("---------To Date  -------" + vo.getStrToDate());
         System.out.println("---------Batch Flg-------" + vo.getStrWhetherBatchWise());
         System.out.println("---------Value Wise------" + vo.getStrValueWise());
         System.out.println("---------Sub Grp   ------" + vo.getStrgroupId());
         System.out.println("---------Ledger_INT_DATE-" + vo.getStrJobInitialDate());  
         System.out.println("--------------------------------");
         if (vo.getStrWhetherBatchWise().equals("1")) {
            vo.setStrMode("1");
         } else {
            vo.setStrMode("2");
         }

         vo.setStrItemCatId(request.getParameter("strItemCatId"));
         bo.getConsolidatedStockLedgerDtl(vo);
         String strStockLedgerDetails = "";
         response.setContentType("text/html;charset=UTF-8");
         if (vo.getStrMode().equals("1")) 
         {
            strStockLedgerDetails = hlp.getConsolidatedStockLedgerRptBatch(vo, request);
         } 
         else if (vo.getStrValueWise().equals("0")) 
         {
            strStockLedgerDetails = hlp.getConsolidatedStockLedgerRpt(vo, request);
         } 
         else 
         {
            strStockLedgerDetails = hlp.getConsolidatedStockLedgerRpt(vo, request);
         }

         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(strStockLedgerDetails);
         if (vo.getStrMsgType().equals("1")) {
            throw new Exception(vo.getStrMsgString());
         }
      } catch (Exception var12) {
         strMsgText = var12.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (vo != null) {
            vo = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getDetailedStockLedger(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO vo = null;
      FTDStockLedgerRptHLP hlp = null;
      HisUtil util = null;
      String var7 = null;

      try {
         System.out.println("<<------FTDStockLedgerRptDATA.getDetailedStockLedger----->>");
         bo = new FTDStockLedgerRptBO();
         vo = new FTDStockLedgerRptVO();
         hlp = new FTDStockLedgerRptHLP();
         
         vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
         vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
         vo.setStrDWHId(request.getParameter("storeId") != null && !request.getParameter("storeId").equals("") ? request.getParameter("storeId") : "0");
         vo.setStrItemBrandId(request.getParameter("itembrandId") != null && !request.getParameter("itembrandId").equals("") && !request.getParameter("itembrandId").equals("0") ? request.getParameter("itembrandId").split("^")[0] : "0");
         vo.setStrFromDate(request.getParameter("fromDate"));
         vo.setStrToDate(request.getParameter("toDate"));
         vo.setStrBatchNo(request.getParameter("batchNo") != null && !request.getParameter("batchNo").equals("") ? request.getParameter("batchNo") : "0");
         vo.setStrOpeningBalance(request.getParameter("openingBalanceActive") + "#" + request.getParameter("openingBalanceQuarantine") + "#" + request.getParameter("openingBalanceInActive"));
         vo.setStrItemCatId("10");
         vo.setStrJobInitialDate(request.getParameter("strJobInitialDate"));
         
         bo.getDetailedStockLedgerDtl(vo);  // Pkg_Mms_view2.rptm_new_dtl_ledger_dtl Mode [ 1 - Drug , 2 - Other Than Drug ]
         
         response.setContentType("text/html;charset=UTF-8");
         
         String strStockLedgerDetails = hlp.getDetailedStockLedgerDtl(vo, request);
         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(strStockLedgerDetails);
         
         if (vo.getStrMsgType().equals("1")) 
         {
            throw new Exception(vo.getStrMsgString());
         }
      } 
      catch (Exception var12) 
      {
         var7 = var12.getMessage();
      } 
      finally 
      {
         if (bo != null) {
            bo = null;
         }

         if (vo != null) {
            vo = null;
         }

         if (util != null) {
            util = null;
         }

         hlp = null;
      }

   }

   public static void getDetailedStockLedgerDtlRpt(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO vo = null;
      HisUtil util = null;
      String strMsgText = null;
      FTDStockLedgerRptHLP hlp = null;

      try {
         System.out.println("<<------FTDStockLedgerRptDATA.getDetailedStockLedgerDtlRpt----->>");
         bo = new FTDStockLedgerRptBO();
         vo = new FTDStockLedgerRptVO();
         hlp = new FTDStockLedgerRptHLP();
         vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
         vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
         vo.setStrDWHId(request.getParameter("storeId") != null && !request.getParameter("storeId").equals("") ? request.getParameter("storeId") : "0");
         vo.setStrItemBrandId(request.getParameter("itembrandId") != null && !request.getParameter("itembrandId").equals("") && !request.getParameter("itembrandId").equals("0") ? request.getParameter("itembrandId") : "0");
         vo.setStrFromDate(request.getParameter("fromDate"));
         vo.setStrToDate(request.getParameter("toDate"));
         vo.setStrBatchNo(request.getParameter("batchNo") != null && !request.getParameter("batchNo").equals("") ? request.getParameter("batchNo") : "0");
         vo.setStrStoreName(request.getParameter("storeName"));
         vo.setStrOpeningBalance(request.getParameter("openingBalanceActive") + "#" + request.getParameter("openingBalanceInActive") + "#" + request.getParameter("openingBalanceQuarantine"));
         vo.setStrBatchFlag(request.getParameter("batchFlg") != null && !request.getParameter("batchFlg").equals("") ? request.getParameter("batchFlg") : "0");
         vo.setStrJobInitialDate(request.getParameter("strJobInitialDate"));
         if (vo.getStrBatchFlag().equals("1")) {
            vo.setStrMode("1");
         } else {
            vo.setStrMode("2");
         }

         vo.setStrItemCatId("10");
         bo.getDetailedStockLedgerDtl(vo);
         response.setContentType("text/html;charset=UTF-8");
         System.out.println("<<------hlp.getDetailedStockLedgerRpt----->>");
         String strStockLedgerDetails = hlp.getDetailedStockLedgerRpt(vo, request);
         response.setHeader("Cache-Control", "no-cache");
         response.getWriter().print(strStockLedgerDetails);
         if (vo.getStrMsgType().equals("1")) {
            throw new Exception(vo.getStrMsgString());
         }
      } catch (Exception var12) {
         strMsgText = var12.getMessage();
      } finally {
         if (bo != null) {
            bo = null;
         }

         if (vo != null) {
            vo = null;
         }

         if (util != null) {
            util = null;
         }

      }

   }

   public static void getDrugList(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      FTDStockLedgerRptBO bo = null;
      FTDStockLedgerRptVO voObj = null;
      String strMsgText = null;
      HisUtil util = null;
      String hosCode = "";
      String storeId = "";
      String itemCatNO = "";
      String groupId = "";
      String itemType = "";
      String drugname = "";

      try {
         System.out.println("<<------FTDStockLedgerRptDATA.getDrugList----->>");
         util = new HisUtil("MMS Reports", "FTDStockLedgerRptDATA");
         bo = new FTDStockLedgerRptBO();
         voObj = new FTDStockLedgerRptVO();
         hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
         storeId = request.getParameter("storeId");
         itemCatNO = request.getParameter("itemcat");
         groupId = request.getParameter("groupId");
         itemType = request.getParameter("itemType");
         drugname = request.getParameter("section");
         formBean.setStrHospitalCode(hosCode);
         formBean.setStrStoreId(storeId);
         formBean.setStrItemCatNo(itemCatNO);
         formBean.setStrGroupId(groupId);
         formBean.setStrItemType(itemType);
         voObj.setStrHospitalCode(hosCode);
         voObj.setStrStoreId(formBean.getStrStoreId());
         voObj.setStrItemCatId("10");
         voObj.setStrGroupId(groupId + "^" + itemType);
         voObj.setStrSectionId(drugname);
         bo.getItemList(voObj);
         if (voObj.getStrMsgType().equals("1")) {
            throw new Exception(voObj.getStrMsgString());
         }

         String strItemValues = "";
         if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {
            strItemValues = util.getOptionValue(voObj.getStrItemWs(), "", "", true);
            voObj.getStrItemWs().beforeFirst();
            formBean.setStrLeftItemList(util.getOptionValue(voObj.getStrItemWs(), "", "", true));
         } else {
            strItemValues = "";
         }

         try {
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().print(strItemValues);
         } catch (Exception var19) {
            var19.printStackTrace();
         }
      } catch (Exception var20) {
         strMsgText = var20.getMessage();
      } finally {
         if (voObj != null) {
            voObj = null;
         }

         if (formBean != null) {
            formBean = null;
         }

         util = null;
      }

   }

   public static void generatePdf(FTDStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      String var3 = null;

      try {
         String strHtmlCode = formBean.getStrHtmlCode();
         strHtmlCode = strHtmlCode.replace("width=\"100\\%\"", "width='50\\%'");
         String strReportData = "<html><head><style type='text/css'>@page {size: landscape;}</style></head><body>" + strHtmlCode + "</body></html>";
         response.setContentType("application/pdf");
         response.setHeader("Content-Disposition", "attachment; filename=stock_ledger.pdf");
      } catch (Exception var6) {
         var3 = var6.getMessage();
      }

   }
}