/**
 * 
 */
package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;
import mms.MmsConfigUtil;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


/** 
 * Developer : Anshul Jindal Version : 1.1 Date : 11/June/2009
 * (Changes)
 * 
 */
/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */
/**
 * @author Balasubramaniam M
 * @version 1.0
 * @since 01/Apr/2009 
 * 
 */


public class IssueDeskTransUTL extends TransInterface {

	private static final long serialVersionUID = 02L;
	
	String[] cmbVal = null;
	HttpSession httpSession = null;
	MmsConfigUtil mcu; 			//= new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName() {
		String masterName = "Issue Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[])
	{
		
		StringBuffer brMainQuery = new StringBuffer(500);
		mcu= new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		if (cmb != null && cmb[1].equals("2") && !cmb[0].equals("0")) 
		{
			String finStartDate = mcu.getStrFinancialStartDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
			String finEndDate = mcu.getStrFinancialEndDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
			
			brMainQuery.append("SELECT  HSTNUM_ISSUE_NO  ||'@'||HSTNUM_STORE_ID||'@'|| GNUM_HOSPITAL_CODE" +
					"||'^'||  HSTNUM_ISSUE_NO||'^'||TO_CHAR(HSTDT_ISSUE_DATE,'DD-Mon-YYYY')||'^'||" +
					"HSTNUM_INDENT_NO  ||'^'|| TO_CHAR(HSTDT_INDENT_DATE,'DD-Mon-YYYY')||'^'||TO_CHAR(HSTDT_ISSUE_DATE,'DD-Mon-YYYY') ||'^0^'|| hstnum_urgent_flag  " +
					"AS DATA ");
			brMainQuery.append("FROM HSTT_ISSUE_DTL WHERE GNUM_HOSPITAL_CODE = ");
			//brMainQuery.append("108");
			brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
			//brMainQuery.append(" AND GNUM_ISVALID = 1   AND HSTDT_FINANCIAL_START_DATE = TO_DATE('"+finStartDate+"','DD-Mon-YYYY') AND HSTDT_FINANCIAL_END_DATE =  TO_DATE('"+finEndDate+"','DD-Mon-YYYY')");
			brMainQuery.append(" AND GNUM_ISVALID = 1  AND HSTDT_ISSUE_DATE > TRUNC(SYSDATE) - 30 AND HSTDT_FINANCIAL_START_DATE = TO_DATE('"+finStartDate+"','DD-Mon-YYYY') AND HSTDT_FINANCIAL_END_DATE =  TO_DATE('"+finEndDate+"','DD-Mon-YYYY') ");
		
			brMainQuery.append(" AND HSTNUM_STORE_ID = ");
			brMainQuery.append(cmb[0]);
		}
		else
		{			
			brMainQuery.append("SELECT C.HSTNUM_REQ_NO ||'@'|| C.HSTNUM_STORE_ID ||'@'|| " +
					"C.GNUM_HOSPITAL_CODE||'@'||count_urgent||'@'||c.HSTNUM_URGENT_FLAG ||'^'|| C.HSTNUM_REQ_NO ||'^'|| C.REQ_DATE ||'^'|| C.RAISING_STORE " +
					"||'^'|| C.CATEGORY ||'^'||C.LST_ISSUE_DATE ||'^'||c.HSTNUM_URGENT_FLAG as  DATA FROM " +
					"(SELECT  HSTNUM_URGENT_FLAG,(SELECT COUNT(*) FROM sstt_indent_dtl WHERE HSTNUM_URGENT_FLAG=1 AND " +
					"gnum_hospital_code =A.gnum_hospital_code AND gnum_isvalid = 1  AND " +
					"hstnum_indent_status IN (40, 49) AND sstnum_reqtype_id = 17 AND " +
					"hstnum_tostore_id = A.hstnum_tostore_id )count_urgent,HSTNUM_REQ_NO , HSTNUM_STORE_ID , GNUM_HOSPITAL_CODE , " +
					"TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY') REQ_DATE, " +
					"MMS_MST.get_store_dtl(1,gnum_hospital_code,hstnum_store_id) RAISING_STORE ,HSTNUM_TOSTORE_ID, " +
					" MMS_MST.get_itemcat_dtl(1, GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO) CATEGORY, " +
					"TO_CHAR(HSTDT_LSTISSUE_DATE,'DD-Mon-YYYY') LST_ISSUE_DATE FROM SSTT_INDENT_DTL A WHERE " +
					"GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" " +
							"AND GNUM_ISVALID = 1 AND HSTDT_REQ_DATE > TRUNC(SYSDATE) - 30 AND HSTNUM_INDENT_STATUS IN(40,49) " +
					"AND SSTNUM_REQTYPE_ID=17 AND TO_CHAR (hstdt_lstissue_date, 'DD-Mon-YYYY') IS NULL) C  ");
			
			if (cmb != null && !cmb[0].equals("0"))
			{
				brMainQuery.append(" WHERE C.HSTNUM_TOSTORE_ID = ");
				brMainQuery.append(cmb[0]);
			}
		}
		//System.out.println("Issue Desk UTL==>"+brMainQuery.toString());
			
		return brMainQuery.toString();

	}

	public String[] getSearchField() 
	{
		
		String search_field[]= new String[6];
		
		if(cmbVal != null && cmbVal[1].equals("2"))
		{	
			search_field[0] = "1";
			search_field[1] = "HSTNUM_ISSUE_NO";
			search_field[2] = "3";
			search_field[3] = "HSTNUM_INDENT_NO";
			search_field[4] = "2";
			search_field[5] = "HSTDT_ISSUE_DATE";
		}
		else
		{
			search_field[0] = "1";
			search_field[1] = "C.HSTNUM_REQ_NO";
			search_field[2] = "2";
			search_field[3] = "C.REQ_DATE";
			search_field[4] = "3";
			search_field[5] = "C.RAISING_STORE";
		}
		
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
		mcu= new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		String[] strComboHeader = new String[4];
		if (mcu.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
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
		String[] strColumnHeader = new String[5];
		mcu= new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		if (mcu.getStrStoreConfigCatg().equals("10")) 
		{	

			if(cmbVal != null && cmbVal[1].equals("2"))
			{
				strColumnHeader[0] =  "Issue No.";
				strColumnHeader[1] =  "Issue Date";
				strColumnHeader[2] =  "Request No.";
				strColumnHeader[3] =  "Request Date";
				strColumnHeader[4] =  "Last Issue Date";
			}
			else
			{
				strColumnHeader[0] =  "Request No.";
				strColumnHeader[1] =  "Request Date";
				strColumnHeader[2] =  "Raising Store";
				strColumnHeader[3] =  "Drug Category";
				strColumnHeader[4] =  "Last Issue Date";
			}
			
		}
		else
		{
			 
				if(cmbVal != null && cmbVal[1].equals("2"))
				{
					strColumnHeader[0] =  "Issue No.";
					strColumnHeader[1] =  "Issue Date";
					strColumnHeader[2] =  "Request No.";
					strColumnHeader[3] =  "Request Date";
					strColumnHeader[4] =  "Ack. Status";
					
				}else{
					strColumnHeader[0] =  "Request No.";
					strColumnHeader[1] =  "Request Date";
					strColumnHeader[2] =  "Raising Store";
					strColumnHeader[3] =  "Item Category";
					strColumnHeader[4] =  "Req. Status";
					
				}
				
			 
		}
		
		return strColumnHeader;
	}      

	public String[] getComboQuery() 
	{
			
		String[] comboQuery = new String[2];
		
		
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
       /*		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID, HSTSTR_STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_HOSPITAL_CODE = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+
		" AND GDT_EFFECTIVE_FRM <= SYSDATE AND GNUM_ISVALID = 1" +
		"ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		*/
		
		

		comboQuery[1] = "1^To Be Issue#2^Issued";
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

	public List<String> getDeleteData(String chk) {
		
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../js/issuedesk_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "1", "7", "CYAN", "Urgent"};
		return status;
		
	}

	public String getEventState() {
		String str = "issueDeskButtonStatus";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		String[] strButtons = {"Issue@validateIssue(document.forms[0],'ISSUE')@1@3b5998@glyphicon-plus",
				"View@callViewCnt(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen"};		
		return strButtons;
	}

	public String[] getDbButtons() {
		String[] str = { "2" };
		return str;
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
		
		
		String orderBy[] = new String[4];
		
		if(cmbVal != null && cmbVal[1].equals("2") && !cmbVal[0].equals("0"))
		{
			orderBy[0] = "1";
			orderBy[1] = "HSTNUM_ISSUE_NO";
			orderBy[2] = "3";
			orderBy[3] = "HSTNUM_INDENT_NO";
		}
		else
		{
			orderBy[0] = "1";
			orderBy[1] = "C.HSTNUM_REQ_NO";
			orderBy[2] = "3";
			orderBy[3] = "C.RAISING_STORE";
		}
		
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"IssueOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
}
