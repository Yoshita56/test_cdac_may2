package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.List;
import javax.servlet.http.HttpSession;
import mms.qryHandler_mms;

public class ItemMstUTL implements MasterInterface {
   private static final long serialVersionUID = 2L;
   HttpSession httpSession = null;

   public String getButtons() {
      StringBuilder br = new StringBuilder();
      br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemBrandMstComboAdd(document.forms[0]);'\t\tonClick='itemBrandMstComboAdd(document.forms[0]);'><span class='add'>Add</span></a>");
      br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemBrandMstComboModify(document.forms[0]);'\tonClick='itemBrandMstComboModify(document.forms[0]);'><span class='modify'>Modify</span></a>");
      br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'\t\t\t\t\tonClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
      br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemView();'\t\t\t\t\t\t\t\t\tonClick='itemView();'><span class='view'>View</span></a>");
      br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  \t\t\t\t\t\tonClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
      return br.toString();
   }

   public String[] getColumnHeader() {
      String[] col_header = new String[]{"Item Name", "Item Type", "Is Quantifiable", "Is Misc"};
      return col_header;
   }

   public String[] getComboHeader() {
      String[] comboHeader = new String[]{"0", "Item Category", "0", "Group Name", "1", "Record Status"};
      return comboHeader;
   }

   public String[] getComboQuery() {
      String hosCode = "100";
      String strSeatId = this.httpSession.getAttribute("SEATID").toString();
      String[] comboQuery = new String[3];
      String strCatCodes = "";
      if (this.httpSession.getAttribute("USERVALUE").toString() != null) {
         strCatCodes = this.httpSession.getAttribute("USERVALUE").toString();
      } else {
         strCatCodes = "0";
      }

      comboQuery[0] = qryHandler_mms.getQuery(1, "select.itemBrandMstCat.0").replace("?", "100");
      System.out.println("comboQuery[0]-" + comboQuery[0]);
      comboQuery[1] = qryHandler_mms.getQuery(1, "select.itemBrandMstGrp.0").replace("?", "100");
      comboQuery[2] = "1^Active#2^In Active";
      System.out.println(" Combo [0] -->>" + comboQuery[0]);
      System.out.println(" Combo [1] -->>" + comboQuery[1]);
      return comboQuery;
   }

   public String[] getDeleteQuery() {
      String[] deleteQuery = new String[1];
      String seatId = this.httpSession.getAttribute("SEATID").toString();
      deleteQuery[0] = qryHandler_mms.getQuery(1, "delete.itemBrandMst.0").replace("?", seatId);
      System.out.println(" deleteQuery [0]--delete.itemBrandMst.0 -->>" + deleteQuery[0]);
      deleteQuery[0] = deleteQuery[0].concat("  where " + qryHandler_mms.getQuery(1, "delete.itemBrandMst.cond.0"));
      System.out.println(" deleteQuery [0]--delete.itemBrandMst.cond.0 -->>" + deleteQuery[0]);
      return deleteQuery;
   }

   public String getJsFiles() {
      String jsFile = "../../mms/js/mms.js";
      return jsFile;
   }

   public String getMainQuery(String[] cmb) {
      StringBuffer brMainQuery = new StringBuffer(500);
      String hosCode = "100";
      brMainQuery.append(qryHandler_mms.getQuery(1, "select.itemBrandMst.0").replace("?", hosCode));
      if (cmb != null) {
         if (!cmb[0].equals("0")) {
            brMainQuery.append(" and " + qryHandler_mms.getQuery(1, "select.itemBrandMst.cond.4").replace("?", cmb[0]));
         }

         if (!cmb[1].equals("0")) {
            brMainQuery.append(" and " + qryHandler_mms.getQuery(1, "select.itemBrandMst.cond.3").replace("?", cmb[1]));
         }

         if (!cmb[2].equals("0")) {
            brMainQuery.append(" and " + qryHandler_mms.getQuery(1, "select.itemBrandMst.cond.0").replace("?", cmb[2]));
         }
      }

      System.out.println(" Item Mst Org Main Query" + brMainQuery.toString());
      return brMainQuery.toString();
   }

   public String getMasterName() {
      String masterName = "Item  Master";
      return masterName;
   }

   public String[] getOrderBy() {
      String[] orderBy = new String[]{"2", "B.HSTSTR_ITEM_NAME", "3", "MMS_MST.GET_ITEMTYPE_DTL(1 , GNUM_HOSPITAL_CODE , HSTNUM_ITEMTYPE_ID )"};
      return orderBy;
   }

   public int getPage_per_block() {
      return 10;
   }

   public int getRecord_per_page() {
      return 10;
   }

   public String[] getSearchField() {
      String[] search_field = new String[]{"1", "B.HSTSTR_ITEM_NAME"};
      return search_field;
   }

   public List<String> getViewHeader() {
      return null;
   }

   public String getViewQuery() {
      return null;
   }

   public void setHttpSession(HttpSession session) {
      this.httpSession = session;
   }

   public String[] getColsWidth() {
      return null;
   }

   public boolean reportInterFaceRequired() {
      return false;
   }

   public String isGlobal() {
      return "1";
   }
}
    