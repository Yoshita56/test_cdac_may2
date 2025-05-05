
package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */

public class LocalPurchaseDeskUTL extends TransInterface {

	private static final long serialVersionUID = 1L;
	HttpSession httpSession = null;
	String[] cmbVal = null;
	

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName() {
		String masterName = "Material IN-Ward";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(4000);
	
		System.out.println("----- A -----");
	
		brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
				+ "gnum_hospital_code AS LP_HOSP,	to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
				+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
				//+ ",round(sum((hstnum_rate*(hstnum_tax+100)/100)*hstnum_lp_qty),2) AS TOT_VAL,"
				+",round(sum((HSTNUM_SALEPRICE *hstnum_lp_qty)),2) AS TOT_VAL,"				
				+ "CASE WHEN MAX(hstnum_ack_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS,STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO "
				+ "from hstt_supplier_receipt_dtl A "
				+ "where gnum_isvalid = 1  "		
				+ "and hstnum_ack_by IS NOT NULL "+""				
				+ "and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "	
				+ "AND HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "
				+ "group by hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,PO_NO,"
				+ "gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by"
				+ ")"
				+ "select LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||LP_SUPP||'^'||CTG_NAME||'^'||PO_NO||'^'||"
				+ "SUM(TOT_VAL)||'^'|| STATUS from   DATA  "
				+ "GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,STATUS,PO_NO,CTG_NAME ");
		  
	    
	    if(cmb != null)
	    {
	    	brMainQuery = new StringBuffer(4000);
		    	
		    	brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
						+ "gnum_hospital_code AS LP_HOSP,	to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
						+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
						//+ ",round(sum((hstnum_rate*(hstnum_tax+100)/100)*hstnum_lp_qty),2) AS TOT_VAL,"
						+",round(sum((HSTNUM_SALEPRICE *hstnum_lp_qty)),2) AS TOT_VAL,"	
						+ "CASE WHEN MAX(hstnum_ack_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS,STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO "
						+ "from hstt_supplier_receipt_dtl "
						+ "where gnum_isvalid = 1  "
						//+ "and sstnum_item_cat_no = "+cmb[1]+"" 
						+ "and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
						+ "and hstnum_store_id = "+cmb[0]+" "
						+ "and hstnum_ack_by IS NOT NULL "+""						
						+ "group by hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,PO_NO,"
						+ "gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by"
						+ ")"
						+ "select LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||LP_SUPP||'^'||CTG_NAME||'^'||PO_NO||'^'||"
						+ "SUM(TOT_VAL)||'^'|| STATUS from   DATA  "
						+ "GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,STATUS,PO_NO,CTG_NAME ");
			  
	    
		   
	    	if(!cmb[1].equals("0"))
	    	{
	    		System.out.println("----- C -----");
	    		
	    		brMainQuery = new StringBuffer(4000);
		    			    	
		    	brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
						+ "gnum_hospital_code AS LP_HOSP,	to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
						+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
						//+ ",round(sum((hstnum_rate*(hstnum_tax+100)/100)*hstnum_lp_qty),2) AS TOT_VAL,"
						+",round(sum((HSTNUM_SALEPRICE *hstnum_lp_qty)),2) AS TOT_VAL,"	
						+ "CASE WHEN MAX(hstnum_ack_by) IS NULL AND MAX(hstnum_reject_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS,STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO  "
						+ "from hstt_supplier_receipt_dtl "
						+ "where gnum_isvalid = 1  "
						+ "and sstnum_item_cat_no = "+cmb[1]+"" 
						+ "and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
						+ "and hstnum_store_id = "+cmb[0]+" "					
						+ "and hstnum_ack_by IS NOT NULL  "+""						
						+ "group by hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,PO_NO,"
						+ "gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by"
						+ ")"
						+ "select LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||LP_SUPP||'^'||CTG_NAME||'^'||PO_NO||'^'||"
						+ "SUM(TOT_VAL)||'^'|| STATUS from   DATA  "
						+ "GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,STATUS,PO_NO,CTG_NAME ");
	    	}
	    	
	    }		
		System.out.println("LocalPurchaseDesk [ LocalPurchaseDeskUTL ]-->>>>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "LP_NO"};	     
		return search_field;
	}
	
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */

	public String[] getComboHeader() 
	{
	
		String[] strComboHeader = { "0^0", "Store Name", "0^0","Item Category " };
		return strComboHeader;
		
	   
	 
	}

	public String[] getColumnHeader() 
	{	
		String[] strColumnHeader = new String[7];
		strColumnHeader[0] = "Recp No";
		strColumnHeader[1] = "Recp Date";
		strColumnHeader[2] = "Supplier";
		strColumnHeader[3] = "Catg";
		strColumnHeader[4] = "Bill / Inv";
		strColumnHeader[5] = "Value";		
		strColumnHeader[6] = "Status";
		return strColumnHeader;
		
		
	}      

	public String[] getComboQuery()
	{
		
				
		String[] comboQuery = new String[2];
		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID,INITCAP(HSTSTR_STORE_NAME)  "+
				  " AS STORE_NAME FROM HSTT_STORE_MST A  "+
				  "  WHERE GNUM_ISVALID = 1 "+
				  "  AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+""+ 			  
				  "  AND HSTNUM_STORE_ID IN ( "+ 
				  "  SELECT GNUM_COLUMN_VALUE  "+    
				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
				  " WHERE P.gnum_metatable_id = 117 "+ 	    
				  " AND P.gnum_hospital_code = A.gnum_hospital_code "+     
				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
				  " )ORDER BY hststr_store_name";
	    
				
		comboQuery[1] = "SELECT  DISTINCT  sstnum_item_cat_no, "
				+ "MMS_MST.GET_ITEMCAT_DTL (1, "
				+ "100, "
				+ "sstnum_item_cat_no "
				+ ") AS CATNAME "
				+ "FROM sstt_item_category_mst A "
				//+ "WHERE sstnum_item_cat_no !=10 "
				+ "ORDER BY CATNAME";
	
		
		return comboQuery;
	}

	public String getViewQuery() {
		return ""; 
	}

	public String getButtons()
	{
		String strButtons = "";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();

		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/LocalPurchase.js";
		return files;

	}

	public String[] getRowStatus()
	{
		String[] status = {};
		return status;
		
	}

	public String getEventState() 
	{
	//	String strEvent = "buttonLogicsOnRecordCheck";
		String strEvent = "chkUserDefinedFunc";
		return strEvent;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() 
	{
		
		         String[] strButtons = null; 
		         strButtons = new String[2];
				 strButtons[0] = "Generate@buttonLogicsOnClick1(1,'ADD','Add')@0@3b5998@glyphicon-plus";
				// strButtons[1] = "Modify@buttonLogicsOnClickCancel(2,'MODIFY','Remove')@1@bb0000@glyphicon-remove";
			  	 strButtons[1] = "View@buttonLogicsOnClickPrint(5,'PRINT','Print')@0@0c8d20@glyphicon-print";	
				
		         return strButtons;
	}

	public String[] getDbButtons() {
	//	String[] str = { "1" };
		return null;
	}

	public int getMinPanelButton() {
		return 1;
	}

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	public String getComboEventState() {
		return "";
	}

	public String[] getOrderBy() {
		//String orderBy[] = { "2", "gdt_entry_date", "1", "hstnum_trans_no" };
		String orderBy[] = {"1", "LP_NO" };
		return orderBy;
	}
	@Override
	public String[] getButtonIcons() {
	//	String[] str={"GenerateOnDesk.png","CancelOnDesk.png","ReturnOnDesk.png","ViewOnDesk.png","PrintOnDesk.png","icon-default.png"};
		String[] str={"GenerateOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	

}
