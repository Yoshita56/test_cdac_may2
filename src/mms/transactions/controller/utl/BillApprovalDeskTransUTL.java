package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.transactionutil.TransInterface;

/**
 * 
 * @author Tanvi Sappal
 *
 */
public class BillApprovalDeskTransUTL extends TransInterface {

	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName() {
		String masterName = "Bill Approval/Verification Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}
	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(5000);
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		if (cmb != null) 
		{
						
			brMainQuery.append(" WITH DATA AS  ");
			brMainQuery.append(" (  ");
			brMainQuery.append(" SELECT  C.HSTNUM_STORE_ID AS STORE_ID, ");          
			brMainQuery.append(" C.hststr_po_no  AS PO_NO, ");          
			brMainQuery.append(" C.HSTNUM_INVOICETYPE_ID  AS INVOICE_TYPE_ID , ");         
			brMainQuery.append(" C.HSTNUM_SUPPLIER_ID  AS SUPPLIER_ID, ");          
			brMainQuery.append(" C.HSTNUM_INVOICE_STATUS AS INVOICE_STATUS, ");          
			brMainQuery.append(" C.HSTNUM_PO_STOREID  AS PO_STORE_ID, ");    
			brMainQuery.append(" Concatstring('SELECT A.HSTNUM_INVOICE_NO ");          
			brMainQuery.append(" FROM HSTT_INVOICE_DTL A ");           
			brMainQuery.append(" WHERE A.GNUM_ISVALID=1 ");           
			brMainQuery.append(" AND  A.hststr_po_no='''||C.hststr_po_no ||''' ");          
			brMainQuery.append(" AND  A.HSTNUM_PO_STOREID='||C.HSTNUM_PO_STOREID|| ' ");          
			brMainQuery.append(" AND  A.GNUM_HOSPITAL_CODE='|| C.GNUM_HOSPITAL_CODE,',')  AS INVOICE_NO_LIST, ");          
			brMainQuery.append(" Mms_Mst.get_supp_dtl(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID) AS SUPP_NAME  , ");          
			brMainQuery.append(" SUM(C.HSTNUM_SUPP_INVOICE_AMT) AS INVOICE_AMT, ");          
			brMainQuery.append(" SUM(C.hstnum_penelty_waive_amt) AS WAVIER_AMT, ");          
			brMainQuery.append(" SUM(C.hstnum_supp_invoice_tax_amt) AS TAX_AMT, ");          
			brMainQuery.append(" MAX(C.hstnum_payment_status) AS PAYMENT_STATUS, ");
			brMainQuery.append(" (SELECT SUM(round((ROUND ((  hstnum_rate + (  HSTNUM_RATE *  HSTNUM_TAX ) / 100),3)*hstnum_lp_qty) ,2)) ");                        															
			brMainQuery.append(" FROM hstt_supplier_receipt_dtl A ");		    
			brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
			brMainQuery.append(" AND hstnum_ack_by IS NOT NULL ");
			brMainQuery.append(" AND gnum_hospital_code = "+strHospitalCode+" "); 
			brMainQuery.append(" and hstnum_store_id = "+cmb[0]+" "); 
			if (cmb != null && !cmb[1].equals("0"))
			{
				brMainQuery.append(" and hstnum_supplier_id = "+cmb[1].split("\\^")[0]+" ");
			}
			//brMainQuery.append(" and hstnum_supplier_id = "+cmb[1].split("\\^")[0]+" ");			
			brMainQuery.append(" and hststr_lp_no = ''||C.hststr_po_no ||'' ) AS SUPPLY_AMT ");          
			brMainQuery.append(" FROM HSTT_INVOICE_DTL C ");          
			brMainQuery.append(" WHERE C.GNUM_HOSPITAL_CODE="+strHospitalCode+" ");          
			brMainQuery.append(" AND GNUM_ISVALID=1 ");          
			brMainQuery.append(" AND HSTNUM_STORE_ID="+cmb[0]+" ");          
			//brMainQuery.append(" AND HSTNUM_INVOICETYPE_ID="+cmb[2]+" ");         
			brMainQuery.append(" AND HSTNUM_INVOICE_STATUS=1 ");          
			brMainQuery.append(" GROUP BY C.GNUM_HOSPITAL_CODE,C.HSTNUM_STORE_ID , ");          
			brMainQuery.append(" C.hststr_po_no  , C.HSTNUM_INVOICETYPE_ID  , ");         
			brMainQuery.append(" C.HSTNUM_SUPPLIER_ID , C.HSTNUM_INVOICE_STATUS , ");         
			brMainQuery.append(" C.HSTNUM_PO_STOREID ");    
			brMainQuery.append(" ) ");    
			brMainQuery.append(" SELECT INVOICE_NO_LIST||'@'||PO_NO||'@'||INVOICE_TYPE_ID||'@'||SUPPLIER_ID||'@'||INVOICE_STATUS||'@'||PO_STORE_ID ");   
			brMainQuery.append(" ||'^'||PO_NO||'^'|| SUPP_NAME  ||'^'|| SUPPLY_AMT||'^'||(INVOICE_AMT+TAX_AMT)||'^'|| ");
			brMainQuery.append(" WAVIER_AMT  ||'^'|| ((INVOICE_AMT+TAX_AMT)-WAVIER_AMT)||'^'||");
			brMainQuery.append(" CASE WHEN INVOICE_AMT  = (INVOICE_AMT + TAX_AMT) "); 
			brMainQuery.append(" THEN 1 ELSE 2 "); 
			brMainQuery.append(" END AS PAYMENT_STATUS ");   
			brMainQuery.append(" FROM   DATA ");
			
			
			/*
			
			brMainQuery.append(" WITH DATA AS ");
			brMainQuery.append(" ( ");
			brMainQuery.append(" SELECT  C.HSTNUM_STORE_ID AS STORE_ID, "); 
			brMainQuery.append("         C.HSTNUM_PO_NO  AS PO_NO, ");
			brMainQuery.append("         C.HSTNUM_INVOICETYPE_ID  AS INVOICE_TYPE_ID ,");
			brMainQuery.append("         C.HSTNUM_SUPPLIER_ID  AS SUPPLIER_ID, ");
			brMainQuery.append("         C.HSTNUM_INVOICE_STATUS AS INVOICE_STATUS, ");
			brMainQuery.append("         C.HSTNUM_PO_STOREID  AS PO_STORE_ID, ");
			brMainQuery.append("         Concatstring('SELECT DISTINCT A.HSTNUM_INVOICE_NO ||'' ( ''||to_char(A.HSTNUM_INVOICE_DATE,''DD-MON-YYYY HH24:MI:SS'')||'' )'' ");
			brMainQuery.append("         FROM HSTT_INVOICE_DTL A  ");
			brMainQuery.append("         WHERE A.GNUM_ISVALID=1   ");
			brMainQuery.append("         AND  A.HSTNUM_PO_NO='||C.HSTNUM_PO_NO ||' ");                                      
			brMainQuery.append("         AND  A.HSTNUM_PO_STOREID='||C.HSTNUM_PO_STOREID|| ' ");
			brMainQuery.append("         AND  A.GNUM_HOSPITAL_CODE='|| C.GNUM_HOSPITAL_CODE,' <br>') AS INVOICE_NO, ");
			brMainQuery.append("         Concatstring('SELECT A.HSTNUM_INVOICE_NO ");
			brMainQuery.append("         FROM HSTT_INVOICE_DTL A  ");
			brMainQuery.append("         WHERE A.GNUM_ISVALID=1  ");
			brMainQuery.append("         AND  A.HSTNUM_PO_NO='||C.HSTNUM_PO_NO ||' ");                                     
			brMainQuery.append("         AND  A.HSTNUM_PO_STOREID='||C.HSTNUM_PO_STOREID|| ' "); 
			brMainQuery.append("         AND  A.GNUM_HOSPITAL_CODE='|| C.GNUM_HOSPITAL_CODE,',')  AS INVOICE_NO_LIST, ");
			brMainQuery.append("         Mms_Mst.get_supp_dtl(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID) AS SUPP_NAME  , "); 
			brMainQuery.append("         SUM(C.HSTNUM_SUPP_INVOICE_AMT) AS INVOICE_AMT, ");
			brMainQuery.append("         SUM(C.hstnum_penelty_waive_amt) AS WAVIER_AMT, "); 
			brMainQuery.append("         SUM(C.HSTNUM_CALCULATED_COST) AS CAL_COST, ");
			brMainQuery.append("         MAX(C.hstnum_payment_status) AS PAYMENT_STATUS ");  
			brMainQuery.append("         FROM HSTT_INVOICE_DTL C "); 
			brMainQuery.append("         WHERE C.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "); 
			brMainQuery.append("         AND GNUM_ISVALID=1 "); 
			brMainQuery.append("         AND HSTNUM_STORE_ID="+cmb[0]+" "); 
			brMainQuery.append("         AND HSTNUM_INVOICETYPE_ID="+cmb[1]+""); 
			brMainQuery.append("         AND HSTNUM_INVOICE_STATUS="+cmb[2]+" ");
			//brMainQuery.append("         AND C.HSTNUM_PO_NO = 10212200029 ");
			brMainQuery.append("         GROUP BY C.GNUM_HOSPITAL_CODE,C.HSTNUM_STORE_ID , "); 
			brMainQuery.append("         C.HSTNUM_PO_NO  , C.HSTNUM_INVOICETYPE_ID  ,");
			brMainQuery.append("         C.HSTNUM_SUPPLIER_ID , C.HSTNUM_INVOICE_STATUS ,"); 
			brMainQuery.append("         C.HSTNUM_PO_STOREID "); 
			brMainQuery.append("   )  ");
			brMainQuery.append("  SELECT INVOICE_NO_LIST||'@'||PO_NO||'@'||INVOICE_TYPE_ID||'@'||SUPPLIER_ID||'@'||INVOICE_STATUS||'@'||PO_STORE_ID ");
			brMainQuery.append("  ||'^'||INVOICE_NO ||'^'||PO_NO||'^'|| SUPP_NAME  ||'^'|| INVOICE_AMT  ||'^'|| WAVIER_AMT  ||'^'|| CAL_COST ||'^'||CASE WHEN INVOICE_AMT  = (CAL_COST + WAVIER_AMT) THEN 1 ELSE 2 END AS PAYMENT_STATUS ");
			brMainQuery.append("  FROM   DATA "); 
			*/
			
			
			
			
		}
		else
		{
			
			/*
			brMainQuery.append(" (SELECT  C.HSTNUM_STORE_ID || '@' || C.HSTNUM_PO_NO  || '@' || C.HSTNUM_INVOICETYPE_ID ");
			brMainQuery.append(" || '@' || C.HSTNUM_SUPPLIER_ID || '@' || C.HSTNUM_INVOICE_STATUS ||'@'|| HSTNUM_CURRENCY_ID || '@' || C.HSTNUM_PO_STOREID ||'^'|| C.HSTNUM_INVOICE_NO ||'^'|| TO_CHAR(C.HSTNUM_INVOICE_DATE,'DD-MON-YYYY HH24:MI:SS') ");
			brMainQuery.append(" || '^' || C.HSTNUM_PO_NO || '^' ||");
			brMainQuery.append(" Mms_Mst.get_supp_dtl(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID)  || '^ '|| C.HSTNUM_SUPP_INVOICE_AMT || '^' || C.hstnum_penelty_waive_amt ||'^'||C.HSTNUM_CALCULATED_COST||'^'||C.hstnum_payment_status  AS DATA");
			brMainQuery.append(" FROM HSTT_INVOICE_DTL C WHERE C.GNUM_HOSPITAL_CODE=");
			brMainQuery.append(  httpSession.getAttribute("HOSPITAL_CODE").toString());
			brMainQuery.append(" AND GNUM_ISVALID=1");
			brMainQuery.append(" AND HSTNUM_STORE_ID=0)");
			*/
			
			brMainQuery.append(" WITH DATA AS  ");
			brMainQuery.append(" (  ");
			brMainQuery.append(" SELECT  C.HSTNUM_STORE_ID AS STORE_ID, ");          
			brMainQuery.append(" C.hststr_po_no  AS PO_NO, ");          
			brMainQuery.append(" C.HSTNUM_INVOICETYPE_ID  AS INVOICE_TYPE_ID , ");         
			brMainQuery.append(" C.HSTNUM_SUPPLIER_ID  AS SUPPLIER_ID, ");          
			brMainQuery.append(" C.HSTNUM_INVOICE_STATUS AS INVOICE_STATUS, ");          
			brMainQuery.append(" C.HSTNUM_PO_STOREID  AS PO_STORE_ID, ");   
			brMainQuery.append(" Concatstring('SELECT A.HSTNUM_INVOICE_NO ");          
			brMainQuery.append(" FROM HSTT_INVOICE_DTL A ");           
			brMainQuery.append(" WHERE A.GNUM_ISVALID=1 ");           
			brMainQuery.append(" AND  A.hststr_po_no='''||C.hststr_po_no ||''' ");          
			brMainQuery.append(" AND  A.HSTNUM_PO_STOREID='||C.HSTNUM_PO_STOREID|| ' ");          
			brMainQuery.append(" AND  A.GNUM_HOSPITAL_CODE='|| C.GNUM_HOSPITAL_CODE,',')  AS INVOICE_NO_LIST, ");          
			brMainQuery.append(" Mms_Mst.get_supp_dtl(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID) AS SUPP_NAME  , ");          
			brMainQuery.append(" SUM(C.HSTNUM_SUPP_INVOICE_AMT) AS INVOICE_AMT, ");          
			brMainQuery.append(" SUM(C.hstnum_penelty_waive_amt) AS WAVIER_AMT, ");          
			brMainQuery.append(" SUM(C.hstnum_supp_invoice_tax_amt) AS TAX_AMT, ");          
			brMainQuery.append(" MAX(C.hstnum_payment_status) AS PAYMENT_STATUS, ");
			brMainQuery.append(" (SELECT SUM(round((ROUND ((  hstnum_rate + (  HSTNUM_RATE *  HSTNUM_TAX ) / 100),3)*hstnum_lp_qty) ,2)) ");                        															
			brMainQuery.append(" FROM hstt_supplier_receipt_dtl A ");		    
			brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
			brMainQuery.append(" AND hstnum_ack_by IS NOT NULL ");
			brMainQuery.append(" AND gnum_hospital_code = "+strHospitalCode+" "); 
			//brMainQuery.append(" and hstnum_store_id = "+cmb[0]+" "); 
			//brMainQuery.append(" and hstnum_supplier_id = "+cmb[1]+" ");			
			brMainQuery.append(" and hststr_lp_no = ''||C.hststr_po_no ||'' ) AS SUPPLY_AMT ");          
			brMainQuery.append(" FROM HSTT_INVOICE_DTL C ");          
			brMainQuery.append(" WHERE C.GNUM_HOSPITAL_CODE="+strHospitalCode+" ");          
			brMainQuery.append(" AND GNUM_ISVALID=1 ");          
			//brMainQuery.append(" AND HSTNUM_STORE_ID="+cmb[0]+" ");          
			//brMainQuery.append(" AND HSTNUM_INVOICETYPE_ID="+cmb[2]+" ");         
			brMainQuery.append(" AND HSTNUM_INVOICE_STATUS=1 ");          
			brMainQuery.append(" GROUP BY C.GNUM_HOSPITAL_CODE,C.HSTNUM_STORE_ID , ");          
			brMainQuery.append(" C.hststr_po_no  , C.HSTNUM_INVOICETYPE_ID  , ");         
			brMainQuery.append(" C.HSTNUM_SUPPLIER_ID , C.HSTNUM_INVOICE_STATUS , ");         
			brMainQuery.append(" C.HSTNUM_PO_STOREID ");    
			brMainQuery.append(" ) ");    
			brMainQuery.append(" SELECT INVOICE_NO_LIST||'@'||PO_NO||'@'||INVOICE_TYPE_ID||'@'||SUPPLIER_ID||'@'||INVOICE_STATUS||'@'||PO_STORE_ID ");   
			brMainQuery.append(" ||'^'||PO_NO||'^'|| SUPP_NAME  ||'^'|| SUPPLY_AMT||'^'||(INVOICE_AMT+TAX_AMT)||'^'|| ");
			brMainQuery.append(" WAVIER_AMT  ||'^'|| ((INVOICE_AMT+TAX_AMT)-WAVIER_AMT)||'^'||");
			brMainQuery.append(" CASE WHEN INVOICE_AMT  = (INVOICE_AMT + TAX_AMT) "); 
			brMainQuery.append(" THEN 1 ELSE 2 "); 
			brMainQuery.append(" END AS PAYMENT_STATUS ");   
			brMainQuery.append(" FROM   DATA ");
		}
		
	    System.out.println("BillApprovalDeskTransUTL Main Query-->>"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "PO_NO"};
		return search_field;
	}
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{		
			String[] strComboHeader = new String[8];		
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Supplier Name";
			strComboHeader[4] = "0^0";
			strComboHeader[5] = "Bill Type";			
			strComboHeader[6] = "1";
			strComboHeader[7] = "Status";
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "PO No." , "Supplier Name" ,"Supp Amt", "Bill Amt", "Waive Off Amt " , "Calculated Amt" };
		return strColumnHeader;
	}      

	public String[] getComboQuery() 
	{
		String[] comboQuery = new String[4];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
				
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where "
				+ "    GNUM_HOSPITAL_CODE ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+	
		"AND HSTNUM_STORE_ID IN "+ 
	     " (  "+
			  "  SELECT GNUM_COLUMN_VALUE "+      
			  " FROM GBLT_ROLE_SEAT_TABLE_DTL P  "+     
			  " WHERE P.gnum_metatable_id = 117  "+ 	    
			  " AND P.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+ ""+      
			  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual )  "+ 
	     " )"+ 
	      "ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		comboQuery[1] = "select HSTNUM_SUPPLIER_ID||'^'||SSTNUM_ITEM_CAT_NO" +
				"||'^'|| mms_mst.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO),INITCAP(HSTSTR_SUPPLIER_NAME) from HSTT_SUPPLIER_MST " +
				"where  GNUM_ISVALID = 1 and HSTNUM_SUPPLIER_STATUS=1 and (HSTNUM_IS_SUPPLIER = 1 " +
				"OR HSTNUM_IS_MANUFACTURER=1) ORDER BY HSTSTR_SUPPLIER_NAME";
		
		comboQuery[2] = "SELECT HSTNUM_INVOICETYPE_ID ,HSTNUM_INVOICETYPE_NAME  FROM HSTT_INVOICETYPE_MST WHERE GNUM_ISVALID = 1 AND  GNUM_HOSPITAL_CODE ="+MmsConfigUtil.GLOBAL_HOSPITAL_CODE+" ORDER BY HSTNUM_INVOICETYPE_NAME";
				
		comboQuery[3] = "1^Verified";
		return comboQuery;
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
		//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	/*public List getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];

		List deleteData = new ArrayList();
		a = (chk.replace('|', '#')).split("#");
		b = (a[0].replace('@', '#')).split("#");

		key[0] = b[0];
		System.out.print("key[0] = " + key[0]);
		deleteData.add(key);
		return deleteData;
	}*/
	
	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();

		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/bill_approval_desk_trans.js";
		return files;

	}

	public String[] getRowStatus()
	{
		//String[] status = {"Autrin Cap", "2", "brown", "Expired"};
		//return status;
		
		/*
        <option value="1">Full Payment</option>
        <option value="2">Partial Payment</option>
      */
		
		/*
		 * "1"--->> Value Which we Want to Maaped 1 2 3 4 5 6 7 "7"--->> Column
		 * Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->> "Exp Within"--->>Argument You Want to Show in Footer of
		 * Template
		 */
		
		String[] status = { "2", "6",  "PINK"    , "Partial Payment",
				            "1", "6",  "CYAN"    , "Full Payment"};
		
		return status;
		
		
	}

	public String getEventState() {
		String str = "";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		/*
		String[] strButtons = {"Verify@validateBillApproval(document.forms[0],'BILL')@0@00aced@glyphicon-check",
				"View@validateBillApproval(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen",
				"Print@validateBillApproval(document.forms[0],'PRINT')@1@0c8d20@glyphicon-print"};
				*/
		String[] strButtons = {"Verify@validateBillApproval(document.forms[0],'BILL')@0@00aced@glyphicon-check",			
				"Print@validateBillApproval(document.forms[0],'PRINT')@1@0c8d20@glyphicon-print"};
		return strButtons;
	}

	public String[] getDbButtons() {
		//String[] str = { "1" };
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
		return "comboChangeStatus";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "PO_NO"};
		return orderBy;
	}

}
