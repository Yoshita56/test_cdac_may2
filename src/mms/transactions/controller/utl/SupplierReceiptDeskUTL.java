
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

public class SupplierReceiptDeskUTL extends TransInterface {

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
		String masterName = "SUPPLIER RECEIPT DESK";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(1000);
	
	/*   	 
		 brMainQuery.append("select hstnum_supp_lp_no||'@'||hstnum_store_id||'@'||gnum_hospital_code"
	        		+ "||'^'||hstnum_supp_lp_no"
	        		+ "||'^'||to_char(gdt_entry_date,'dd-Mon-yyyy')"
	        		+ "||'^'||mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id)"
	        		+ "||'^'||round(sum((hstnum_rate*(hstnum_tax+100)/100)*hstnum_lp_qty),2)"
	        		+ "||'^'||CASE WHEN hstnum_ack_by IS NULL THEN 'Ack-Pending' ELSE 'Acknowledged' END AS STATUS "
	        		+ "from hstt_supplier_receipt_dtl "
	        		+ "where gnum_isvalid = 1 "	        		
	        		+ "and gnum_hospital_code ="+ httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
	        	
	        		+ "group by hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,sstnum_item_cat_no,gdt_entry_date,hstnum_ack_by");
	        		
	        		+" AND A.HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "
		 */
		System.out.println("----- A -----");
		 brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
					+ "gnum_hospital_code AS LP_HOSP,to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
					+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
					+ ", sum(ROUND((hstnum_rate+(hstnum_rate*hstnum_tax/100)),4)*hstnum_lp_qty)  AS TOT_VAL,"
					+ "CASE WHEN MAX(hstnum_ack_by) IS NULL AND MAX(hstnum_reject_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS "
					+ " , STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO "
					+ " from hstt_supplier_receipt_dtl A"
					+ " where gnum_isvalid = 1  "				
					+ " and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "	
					+ " AND HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "
					+ " group by hstnum_invoice_no,HSTNUM_DC_NO,hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,"
					+ " gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by,HSTSTR_LP_NO"
					+ ")"
					+ " SELECT LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||PO_NO||'^'||CTG_NAME ||'^'||LP_SUPP||'^'||SUM(TOT_VAL)||'^'|| STATUS "				
					+ " from   DATA GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,PO_NO,STATUS,CTG_NAME");
		 
			  

	    
	    if(cmb != null)
	    {
			
	    	
	    	brMainQuery = new StringBuffer(1000);
	    	   	 
	    	System.out.println("----- B -----");
	    	
	    	if(cmb[1].equals("0"))
	    	{
	   	     
		   	  brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
						+ "gnum_hospital_code AS LP_HOSP,	to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
						+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
						+ ", sum(ROUND((hstnum_rate+(hstnum_rate*hstnum_tax/100)),4)*hstnum_lp_qty)  AS TOT_VAL,"
						+ "CASE WHEN MAX(hstnum_ack_by) IS NULL AND MAX(hstnum_reject_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS "
						+ " , STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO "
						+ " from hstt_supplier_receipt_dtl A"
						+ " where gnum_isvalid = 1  "				
						//+ " and sstnum_item_cat_no = "+cmb[1]+" "
						+ " and hstnum_store_id = "+cmb[0]+" "
						//+ " AND HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "
						+ " and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "	
						+ " group by hstnum_invoice_no,HSTNUM_DC_NO,hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,"
						+ " gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by,HSTSTR_LP_NO"
						+ ")"
						+ " SELECT LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||PO_NO||'^'||CTG_NAME ||'^'||LP_SUPP||'^'||SUM(TOT_VAL)||'^'|| STATUS "					
						+ " from   DATA GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,PO_NO,STATUS,CTG_NAME ");
	    	}
	    	else
	    	{
	    		  brMainQuery.append("WITH DATA AS(select hstnum_supp_lp_no AS LP_NO,	hstnum_store_id AS LP_STORE ,	"
							+ "gnum_hospital_code AS LP_HOSP,	to_char(MAX(gdt_entry_date),'dd-Mon-yyyy') AS LP_DATE,"
							+ "	mms_mst.get_supp_dtl(1,gnum_hospital_code,hstnum_supplier_id) AS LP_SUPP"
							+ ", sum(ROUND((hstnum_rate+(hstnum_rate*hstnum_tax/100)),4)*hstnum_lp_qty)  AS TOT_VAL,"
							+ "CASE WHEN MAX(hstnum_ack_by) IS NULL AND MAX(hstnum_reject_by) IS NULL THEN 'Ack-Pending' WHEN MAX(hstnum_reject_by) IS NOT NULL THEN 'Rejected' ELSE 'Acknowledged' END AS STATUS "
							+ " , STRING_AGG(DISTINCT mms_mst.Get_itemcat_dtl(1, 100, sstnum_item_cat_no), '<br>') AS CTG_NAME,hstnum_invoice_no||' / '|| HSTNUM_DC_NO AS PO_NO "
							+ " from hstt_supplier_receipt_dtl A"
							+ " where gnum_isvalid = 1  "				
							+ " and sstnum_item_cat_no = "+cmb[1]+" "
							+ " and hstnum_store_id = "+cmb[0]+" "
							//+ " AND HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "
							+ " and gnum_hospital_code ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "	
							+ " group by hstnum_invoice_no,HSTNUM_DC_NO,hstnum_supp_lp_no,hstnum_store_id,gnum_hospital_code,hstnum_supplier_id,"
							+ " gdt_entry_date,hstnum_ack_by,hstnum_supplier_id,hstnum_ack_by,HSTSTR_LP_NO"
							+ ")"
							+ " SELECT LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO||'^'||LP_DATE||'^'||PO_NO||'^'||CTG_NAME ||'^'||LP_SUPP||'^'||SUM(TOT_VAL)||'^'|| STATUS "					
							+ " from   DATA GROUP BY  LP_NO,LP_STORE,LP_HOSP,LP_DATE,LP_SUPP,PO_NO,STATUS,CTG_NAME ");
	    	}
		 
			  
	    
	    }

		
		
		System.out.println("Main Query-[ SupplierReceiptDeskUTL [ Trans SupplierReceiptCNT] ]->>>>"+brMainQuery.toString());
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
	
		//String[] strComboHeader = { "0^0", "Store Name", "1","Category " };
		String[] strComboHeader = { "0^2", "Store Name", "0^0","Category " };
		return strComboHeader;
		
	   
	 
	}

	public String[] getColumnHeader() 
	{	
		/*
		LP_NO||'@'||LP_STORE||'@'||LP_HOSP||'^'||LP_NO
		||'^'||LP_DATE||'^'||PO_NO||'^'||CTG_NAME 
		||'^'||LP_SUPP||'^'||SUM(TOT_VAL)||'^'|| STATUS
		*/ 
		
		String[] strColumnHeader = new String[7];
		strColumnHeader[0] = "LPO No";
		strColumnHeader[1] = "LP Date";
		strColumnHeader[2] = "Bill / DC NO";
		strColumnHeader[3] = "Catg";
		strColumnHeader[4] = "Supplier";
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
	    		
				
		String strHospitalCode = " "
				+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " ";

		
		if(cmbVal != null)
		{		
		

			comboQuery[1] = "SELECT DISTINCT  SSTNUM_ITEM_CAT_NO, "
					+ "MMS_MST.GET_ITEMCAT_DTL (1, "
					+ "100, "
					+ "SSTNUM_ITEM_CAT_NO "
					+ ") AS CATNAME "
					+ "FROM HSTT_STORE_CATEGORY_MST A "
					+ "WHERE GNUM_ISVALID = 1 "
					+ "AND HSTNUM_STORE_ID = #1# "
					+ "  and SSTNUM_ITEM_CAT_NO IN (select SSTNUM_ITEM_CAT_NO from sstt_item_category_mst where gnum_hospital_code = 100 and gnum_isvalid=1) " // SSTNUM_ITEM_CAT_NO is 10
					+ "AND GNUM_HOSPITAL_CODE = "
					+ strHospitalCode+ "ORDER BY CATNAME";
		}
		else
		{
			comboQuery[1] = "SELECT  DISTINCT SSTNUM_ITEM_CAT_NO, "
					+ "MMS_MST.GET_ITEMCAT_DTL (1, "
					+ "100, "
					+ "SSTNUM_ITEM_CAT_NO "
					+ ") AS CATNAME "
					+ "FROM HSTT_STORE_CATEGORY_MST A "
					+ "WHERE GNUM_ISVALID = 1 "
					//+ "AND HSTNUM_STORE_ID = #1# "
					+ "  and SSTNUM_ITEM_CAT_NO IN (select SSTNUM_ITEM_CAT_NO from sstt_item_category_mst where gnum_hospital_code = 100 and gnum_isvalid=1) " // SSTNUM_ITEM_CAT_NO is 10
					+ "AND GNUM_HOSPITAL_CODE = "
					+ strHospitalCode+ "ORDER BY CATNAME";
					
		}
         
		/*
		comboQuery[1] ="1^All";
		*/
		
		
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
		String files = "../../mms/js/SuppReceipt.js";
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
			  	 strButtons[1] = "View@buttonLogicsOnClickPrint(5,'PRINT','Print')@1@0c8d20@glyphicon-print";	
				
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
		//String orderBy[] = { "2", "gdt_entry_date", "1", "hstnum_supp_lp_no" };
		String orderBy[] = {"1", "LP_NO" , "4", "CTG_NAME" };
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
