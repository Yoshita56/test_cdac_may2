package mms.reports.controller.action;

import hisglobal.exceptions.HisException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.reports.controller.data.FTDStockLedgerRptDATA;
import mms.reports.controller.fb.FTDStockLedgerRptFB;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class FTDStockLedgerRptCNT extends DispatchAction {
   public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
      return this.STORECMB(mapping, form, request, response);
   }

   public ActionForward STORECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      System.out.println("----------- FTDStockLedgerRptCNT.STORECMB ----[ stockledgerFTD_mmsrpt.jsp , stockledgerFTD_mmsrpt.js ]---------");
      String strTarget = "index";
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
      formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
      FTDStockLedgerRptDATA.getInitVal(formBean, request, response);
      return mapping.findForward(strTarget);
   }

   public ActionForward getStockLedgerDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      System.out.println("----------- FTDStockLedgerRptCNT.getStockLedgerDtl -----------");
      FTDStockLedgerRptFB fb = (FTDStockLedgerRptFB)form;
      FTDStockLedgerRptDATA.getStockLedgerDtl(fb, request, response);
      return null;
   }

   public ActionForward getConsolidatedStockLedgerRpt(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
      System.out.println("----------- FTDStockLedgerRptCNT.getConsolidatedStockLedgerRpt -----------");
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      FTDStockLedgerRptDATA.getConsolidatedStockLedgerReport(formBean, request, response);
      return null;
   }

   public ActionForward getDetailedStockLedgerDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
      System.out.println("----------- FTDStockLedgerRptCNT.getDetailedStockLedgerDtl -----------");
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      FTDStockLedgerRptDATA.getDetailedStockLedger(formBean, request, response);
      return null;
   }

   public ActionForward printDetailedStockLedgerReport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
      System.out.println("----------- FTDStockLedgerRptCNT.printDetailedStockLedgerReport ----[PRINT]-------");
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      FTDStockLedgerRptDATA.getDetailedStockLedgerDtlRpt(formBean, request, response);
      return null;
   }

   public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
      FTDStockLedgerRptDATA.getItemCatList(formBean, request, response);
      return null;
   }

   public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
      FTDStockLedgerRptDATA.getGroupList(formBean, request, response);
      return null;
   }

   public ActionForward ITEMCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
      FTDStockLedgerRptDATA.getItemList(formBean, request, response);
      return null;
   }

   public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
      ActionForward acFwd = new ActionForward();
      acFwd.setPath("/hisglobal/initPage.jsp");
      acFwd.setContextRelative(true);
      return acFwd;
   }

   public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      FTDStockLedgerRptFB formBean = (FTDStockLedgerRptFB)form;
      formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
      formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
      FTDStockLedgerRptDATA.getDrugList(formBean, request, response);
      return null;
   }

   public ActionForward generatePdf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
      System.out.println("----------- FTDStockLedgerRptCNT.generatePdf -----------");
      FTDStockLedgerRptFB fb = (FTDStockLedgerRptFB)form;
      FTDStockLedgerRptDATA.generatePdf(fb, request, response);
      return null;
   }
}