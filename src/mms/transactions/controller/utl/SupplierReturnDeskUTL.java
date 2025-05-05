/**
 *
 */
package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

/**
 * @author Deepak Tiwari
 * Modifed By ::: Amit Kr.
 * Modified Date :: 7-Jan-2010 
 *
 */
public class SupplierReturnDeskUTL extends TransInterface {

	/**
	 * 
	 */
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
		String masterName = "Supplier Return Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) 
	{
		 StringBuffer brMainQuery = new StringBuffer(500);
		 MmsConfigUtil mmsConfig = null;
		   
		    if (cmb != null) 
		    {
		    	    mmsConfig = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		    	    brMainQuery.append(" SELECT    C.GNUM_HOSPITAL_CODE  ||  '@'  || C.HSTNUM_RETURN_NO ||  '@'  || TO_CHAR(C.HSTDT_REQ_DATE,'dd-Mon-yyyy')  ||  '@'  || C.CAT_NAME ||  '@'  || C.HSTNUM_STORE_ID ||  '@'  || C.HSTNUM_ONLINE_FLAG ||  '@'  || C.SSTNUM_ITEM_CAT_NO ||  '@'  || C.HSTNUM_PO_NO ||  '@'  || C.HSTNUM_PO_STORE_ID ||  '@'  || C.HSTNUM_RETURN_FLAG  ||  '@'  || C.HSTNUM_RETURN_TYPE ||  '@'  || TO_CHAR(C.HSTDT_DELIVERY_DATE,'dd-Mon-yyyy') || '@' || C.HSTNUM_SCHEDULE_NO"); 
					brMainQuery.append(" ||  '^'  || C.HSTNUM_RETURN_NO ||  '^'  || TO_CHAR(C.HSTDT_REQ_DATE,'dd-Mon-yyyy')||  '^'  || C.HSTNUM_PO_NO||  '^'   ||DECODE(C.HSTNUM_RETURN_FLAG,1,'Rejected',2,'Breakage',3,'Excess','LP Return') ||  '^'  || C.CAT_NAME ||  '^'  ||  C.HSTNUM_ONLINE_FLAG  DATA  FROM");
					brMainQuery.append(" (SELECT B.HSTNUM_RETURN_NO, B.GNUM_HOSPITAL_CODE, B.HSTDT_REQ_DATE,");
					brMainQuery.append(" Mms_Mst.GET_ITEMCAT_DTL (1, B.GNUM_HOSPITAL_CODE,  B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME,");
					brMainQuery.append(" B.HSTNUM_PO_NO, B.HSTNUM_STORE_ID, B.HSTNUM_RETURN_STATUS, B.HSTDT_RETURN_DATE,");
					brMainQuery.append(" B.GSTR_REMARKS, B.SSTNUM_ITEM_CAT_NO,B.SSTNUM_POTYPE_ID,");
					brMainQuery.append(" B.HSTSTR_LST_APPROVE_SEATID, B.HSTDT_FINANCIAL_START_DATE,");
					brMainQuery.append(" B.HSTDT_FINANCIAL_END_DATE,B.HSTNUM_ONLINE_FLAG,B.HSTNUM_RETURN_FLAG,B.HSTNUM_RETURN_TYPE,B.HSTNUM_PO_STORE_ID,B.HSTDT_DELIVERY_DATE,B.HSTNUM_SCHEDULE_NO");
					brMainQuery.append(" FROM HSTT_SUPP_RETURN_DTL B ");
					brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND B.GNUM_ISVALID = 1) C");
					brMainQuery.append(" WHERE C.HSTNUM_STORE_ID ="+cmb[0].trim());
					//System.out.println("(cmb[0].Value->"+cmb[0]);
					//System.out.println("(cmb[1].Value->"+cmb[1]);
					if(cmb[1].trim().equals("1"))
						 brMainQuery.append(" AND ( (C.HSTNUM_RETURN_STATUS =0) OR (C.HSTSTR_LST_APPROVE_SEATID IS NULL AND C.HSTNUM_RETURN_STATUS <=40) )");
					else if(cmb[1].trim().equals("2"))
						 brMainQuery.append(" AND C.HSTNUM_RETURN_STATUS BETWEEN 1 AND 39"); 
					else if(cmb[1].trim().equals("3"))
						 brMainQuery.append(" AND C.HSTNUM_RETURN_STATUS =40");
					else
					{
					     if(cmb[1].trim().equals("4"))
						     brMainQuery.append(" AND C.HSTNUM_RETURN_STATUS =99");
					     if(cmb[1].trim().equals("5"))
						     brMainQuery.append(" AND C.HSTNUM_RETURN_STATUS =50");
					     
					     brMainQuery.append(" AND C.HSTDT_FINANCIAL_START_DATE = TO_DATE('"+mmsConfig.getStrFinancialStartDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString())+"' , 'dd/mm/yyyy')   AND C.HSTDT_FINANCIAL_END_DATE=TO_DATE('"+mmsConfig.getStrFinancialEndDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString())+"','dd/mm/yyyy')");
					}     
					//System.out.println("Main Query-->"+brMainQuery.toString());
		    }
		    else
		    {
		    	brMainQuery.append(" SELECT    C.GNUM_HOSPITAL_CODE  ||  '@'  || C.HSTNUM_RETURN_NO ||  '@'  || C.HSTDT_REQ_DATE  ||  '@'  || C.CAT_NAME ||  '@'  || C.HSTNUM_STORE_ID ||  '@'  || C.HSTNUM_ONLINE_FLAG ||  '@'  || C.GSTR_REMARKS"); 
				brMainQuery.append("   ||  '^'  || C.HSTNUM_RETURN_NO ||  '^'  || C.HSTDT_REQ_DATE||  '^'  || C.HSTNUM_PO_NO||  '^'   || C.SSTNUM_POTYPE_ID||  '^'  || C.CAT_NAME ||  '^'  ||  C.HSTNUM_ONLINE_FLAG  DATA  FROM");
				brMainQuery.append(" (SELECT B.HSTNUM_RETURN_NO, B.GNUM_HOSPITAL_CODE, B.HSTDT_REQ_DATE,");
				brMainQuery.append(" Mms_Mst.GET_ITEMCAT_DTL (1, B.GNUM_HOSPITAL_CODE,  B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME,");
				brMainQuery.append(" B.HSTNUM_PO_NO, B.HSTNUM_STORE_ID, B.HSTNUM_RETURN_STATUS, B.HSTDT_RETURN_DATE,");
				brMainQuery.append(" B.GSTR_REMARKS, B.SSTNUM_ITEM_CAT_NO,B.SSTNUM_POTYPE_ID,");
				brMainQuery.append(" B.HSTSTR_LST_APPROVE_SEATID, B.HSTDT_FINANCIAL_START_DATE,");
				brMainQuery.append(" B.HSTDT_FINANCIAL_END_DATE,B.HSTNUM_ONLINE_FLAG");
				brMainQuery.append(" FROM HSTT_SUPP_RETURN_DTL B ");
				brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND B.GNUM_ISVALID = 1) C");
				brMainQuery.append(" WHERE C.HSTNUM_STORE_ID =0");
		    }
		    
		   // System.out.println("Supplier Return Desk-->>>"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField()
	{
		String search_field[] = {"1", "C.HSTNUM_RETURN_NO", "3", "C.HSTNUM_PO_NO", "4", "C.SSTNUM_POTYPE_ID"};
		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader()
	{
		//String[] strComboHeader = {"0^2","Drug Warehouse Name","1","Status"};
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Drug WareHouse Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";

		}
		
	    return strComboHeader;
	}

	public String[] getColumnHeader()
	{
		String[] strColumnHeader = { "Request No.", "Request Date", "PO No.", "Ret Type", "Category" };
		return strColumnHeader;
	}

	public String[] getComboQuery()
	{
	
		String[] comboQuery = new String[2];
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="+
                         httpSession.getAttribute("HOSPITAL_CODE").toString()+
                         " AND EXISTS"+
						   "("+
						    "SELECT 'X'"+
						    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
						    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
						    " AND P.gnum_hospital_code = q.gnum_hospital_code"+
						    " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"+
						    " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
						    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
						  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
						 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
						 ",A.GNUM_HOSPITAL_CODE)"+
						") ORDER BY INITCAP(HSTSTR_STORE_NAME)";

		comboQuery[1] = "1^Active#2^Partial Approved#3^Approved#4^Rejected#5^Returned";
		return comboQuery;

	}

	public String getViewQuery() 
	{
		return "";
	}

	public String getButtons() 
	{
		String strButtons =
		"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() 
	{
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";
		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) 
	{
		String a[] = null;
		 
		List<String> deleteData = new ArrayList<String>();
		
		a = (chk.replace('|', '#')).split("#");
	 
	 
		 
		deleteData.add(a[0].replace('@', '#').split("#")[0]);
		return deleteData;
	}

	public String getJsFiles() 
	{
		String files = "../../mms/js/mms_SupplierReturnDesk.js";
		return files;
	}

	public String[] getRowStatus() 
	{
		String[] status = { "0", "7", "", "Auto Generated Request"};
		return status;
	}

	public String getEventState() 
	{
		String str = "";
		return str;
	}

	public String getButtonConfiguration() 
	{
		return "left";
	}

	public String[] getUserDefinedButtons() 
	{
		//String[] strButtons = {"Request@callPage1(document.forms[0],'REQUEST')@0","Modify@callPage1(document.forms[0],'MODIFY')@1","Cancel@callPage1(document.forms[0],'CANCEL_REQUEST')@1","Return@callPage1(document.forms[0],'RETURN')@1","View@callPage1(document.forms[0],'VIEW')@1"};
		//String[] strButtons = {"Modify@callPage1(document.forms[0],'MODIFY')@1","Return@callPage1(document.forms[0],'RETURN')@1","View@callPage1(document.forms[0],'VIEW')@1"};
		String[] strButtons = {"Return@callPage1(document.forms[0],'RETURN')@1@32506d@glyphicon-menu-left",
				"View@callPage1(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen"};
		return strButtons;
	}

	public String[] getDbButtons() 
	{
		//String[] str = { "2" };
		return null;
	}

	public int getMinPanelButton() 
	{
		return 1;
	}

	public String getMenuOption() 
	{
		String menuType = "Tiles";
		return menuType;
	}

	public String getComboEventState()
	{
		return "comboEvent";
	}

	public String[] getOrderBy() 
	{
		String orderBy[] = { "1", "C.HSTNUM_RETURN_NO", "3", "C.HSTNUM_PO_NO",
				"4", "C.HSTNUM_RETURN_FLAG" };
		return orderBy;
	}
	
	
}
