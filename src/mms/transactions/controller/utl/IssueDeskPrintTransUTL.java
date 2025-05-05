package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
import mms.MmsConfigUtil;

public class IssueDeskPrintTransUTL extends TransInterface {

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
		String strReqId="";
		
		   brMainQuery.append("SELECT hstnum_store_id");
	       brMainQuery.append("||'@'||hstnum_issue_no");
	       brMainQuery.append("||'@'||hrgnum_puk");
	       brMainQuery.append("||'@'||pistr_emp_no");
	       brMainQuery.append("||'@'||sstnum_item_cat_no");
	       brMainQuery.append("||'@'|| To_char(hstdt_issue_date, 'DD-Mon-yyyy')");
	       brMainQuery.append("||'@'||hstnum_req_no");
	       brMainQuery.append("||'@'||To_char(hstdt_req_date, 'dd-Mon-yyyy')");
	       brMainQuery.append("||'@'||gnum_hospital_code");
	       brMainQuery.append("||'^'||hstnum_issue_no");
	       brMainQuery.append("||'^'||hstnum_req_no");
	       brMainQuery.append("||'^'||To_char(hstdt_issue_date, 'DD-Mon-yyyy hh24:mi')");
	       brMainQuery.append("||'^'|| mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_req_storeid)");
	       brMainQuery.append("||'^'||hrgnum_puk");
	       brMainQuery.append("||'^'|| ahis_function.Fun_pat_name(hrgnum_puk)");
	       brMainQuery.append("||'^'||Mms_mst.Get_itemcat_dtl(1 :: NUMERIC, gnum_hospital_code, sstnum_item_cat_no)");
	       brMainQuery.append("||'^0'AS DATA");
	       brMainQuery.append(" FROM   sstt_issue_dtl A");
	       brMainQuery.append(" WHERE   sstnum_reqtype_id = 35");
	       brMainQuery.append(" AND gnum_hospital_code = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
		
		
		if(cmb!=null)
		{
			System.out.println("<<--------------------------------------------------->>");
			System.out.println("<<------Req Type 31 - Issue To Store           ------>>");
			System.out.println("<<------Req Type 32 - Issue To Patient         ------>>");
			System.out.println("<<------Req Type 35 - Issue To Patient [ IPD ] ------>>");
			System.out.println("<<------Req Type 36 - Issue To Staff [LP]      ------>>");
			System.out.println("<<------Req Type 37 - Issue To Dept [LP]       ------>>");
			
			System.out.println("<<------Status    1 - New Request   ------>>");
			System.out.println("<<------Status    2 - In-Process    ------>>");
			System.out.println("<<------Status    3 - Item Received ------>>");
			System.out.println("<<------Status    4 - Processed     ------>>");
			System.out.println("<<--------------------------------------------------->>");
								
			 
				if(cmb[1].equals("35"))
			    { 
				
				if(cmb[2].equals("1"))
				{
										
					   System.out.println("<<------Req Type 35 - Issue To Patient [ IPD ]  1 - New Request       ------>>");
					
					   brMainQuery = new StringBuffer(500);					
					 
					   brMainQuery.append("SELECT sstnum_item_cat_no");
				       brMainQuery.append("||'@'||hstnum_req_no");
				       brMainQuery.append("||'@'|| To_char (hstdt_req_date, 'DD-Mon-yyyy ')");
				       brMainQuery.append("||'@'||hstnum_store_id");
				       brMainQuery.append("||'@'||hrgnum_puk");
				       brMainQuery.append("||'@'||gnum_hospital_code");
				       brMainQuery.append("||'@'|| hstnum_bs_refno");
				       brMainQuery.append("||'@'|| hstnum_urgent_flag");
				       brMainQuery.append("||'^'||hstnum_req_no");
				       brMainQuery.append("||'^'|| To_char (hstdt_req_date, 'DD-Mon-yyyy hh24:mi')");
				       brMainQuery.append("||'^'||mms_mst.Get_store_dtl (1, gnum_hospital_code, hstnum_store_id)");
				       brMainQuery.append("||'^'||hrgnum_puk");
				       brMainQuery.append("||'^'||ahis_function.Fun_pat_name(hrgnum_puk)");
				       brMainQuery.append("||'^'||mms_mst.Get_itemcat_dtl(1 :: NUMERIC, gnum_hospital_code, sstnum_item_cat_no)");
				       brMainQuery.append("||'^'|| Decode(hstnum_urgent_flag, 1, 'Urgent','Normal') AS DATA");
				       brMainQuery.append(" FROM   sstt_indent_dtl A");
				       brMainQuery.append(" WHERE   sstnum_reqtype_id = 13");
					/*
					 * brMainQuery.append(" AND a.hrgnum_puk IN (SELECT hrgnum_puk AS PUK");
					 * brMainQuery.append(" FROM   hipt_patadmission_dtl A");
					 * brMainQuery.append(" WHERE  gnum_isvalid = 1");
					 * brMainQuery.append(" AND gnum_hospital_code = "+
					 * httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					 * brMainQuery.append(" AND hipdt_disdatetime IS NULL");
					 * brMainQuery.append(" AND hipnum_isaccepted = 1");
					 * brMainQuery.append(" AND hipnum_is_dead <> 1");
					 * brMainQuery.append(" AND hipdt_admstatus_code NOT IN( 13, 14, 18 )");
					 * brMainQuery.append(" ORDER  BY hipdt_admdatetime DESC) ");
					 */
				       brMainQuery.append(" AND hipnum_adm_no IS NOT NULL ");
				     //  brMainQuery.append(" AND hstnum_indent_status = 40 ");
				       brMainQuery.append(" AND gnum_hospital_code = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
				       brMainQuery.append(" AND hstnum_tostore_id = "+cmb[0]+"");
							
				}			
				
				if(cmb[2].equals("4"))
				{
					
					   System.out.println("<<------Req Type 35 - Issue To Patient [ IPD ]  4 - Processed     ------>>");
					
					   brMainQuery = new StringBuffer(500);
					
					   brMainQuery.append("SELECT hstnum_store_id");
				       brMainQuery.append("||'@'||hstnum_issue_no");
				       brMainQuery.append("||'@'||hrgnum_puk");
				       brMainQuery.append("||'@'||pistr_emp_no");
				       brMainQuery.append("||'@'||sstnum_item_cat_no");
				       brMainQuery.append("||'@'|| To_char(hstdt_issue_date, 'DD-Mon-yyyy')");
				       brMainQuery.append("||'@'||hstnum_req_no");
				       brMainQuery.append("||'@'||To_char(hstdt_req_date, 'dd-Mon-yyyy')");
				       brMainQuery.append("||'@'||gnum_hospital_code");
				       brMainQuery.append("||'^'||hstnum_issue_no");
				       brMainQuery.append("||'^'||hstnum_req_no");
				       brMainQuery.append("||'^'||To_char(hstdt_issue_date, 'DD-Mon-yyyy hh24:mi')");
				       brMainQuery.append("||'^'|| mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_req_storeid)");
				       brMainQuery.append("||'^'||hrgnum_puk");
				       brMainQuery.append("||'^'|| ahis_function.Fun_pat_name(hrgnum_puk)");
				       brMainQuery.append("||'^'||Mms_mst.Get_itemcat_dtl(1 :: NUMERIC, gnum_hospital_code, sstnum_item_cat_no)");
				       brMainQuery.append("||'^0'AS DATA");
				       brMainQuery.append(" FROM   sstt_issue_dtl A");
				       brMainQuery.append(" WHERE  hstnum_store_id = "+cmb[0]+"");
				       brMainQuery.append(" AND sstnum_reqtype_id = 35");
				       brMainQuery.append(" AND gnum_hospital_code = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					/*
					 * brMainQuery.append(" AND a.hrgnum_puk IN (SELECT hrgnum_puk AS PUK");
					 * brMainQuery.append(" FROM   hipt_patadmission_dtl A");
					 * brMainQuery.append(" WHERE  gnum_isvalid = 1");
					 * brMainQuery.append(" AND gnum_hospital_code = "+
					 * httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					 * brMainQuery.append(" AND hipdt_disdatetime IS NULL");
					 * brMainQuery.append(" AND hipnum_isaccepted = 1");
					 * brMainQuery.append(" AND hipnum_is_dead <> 1");
					 * brMainQuery.append(" AND hipdt_admstatus_code NOT IN( 13, 14, 18 )");
					 * brMainQuery.append(" ORDER  BY hipdt_admdatetime DESC)");
					 * brMainQuery.append(" AND a.hipnum_adm_no IN (SELECT hipnum_admno AS admno");
					 * brMainQuery.append(" FROM   hipt_patadmission_dtl A");
					 * brMainQuery.append(" WHERE  gnum_isvalid = 1");
					 * brMainQuery.append(" AND gnum_hospital_code = "+
					 * httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					 * brMainQuery.append(" AND hipdt_disdatetime IS NULL");
					 * brMainQuery.append(" AND hipnum_isaccepted = 1");
					 * brMainQuery.append(" AND hipnum_is_dead <> 1");
					 * brMainQuery.append(" AND hipdt_admstatus_code NOT IN( 13, 14, 18 )");
					 * brMainQuery.append(" AND hrgnum_puk = a.hrgnum_puk");
					 * brMainQuery.append(" ORDER  BY hipdt_admdatetime DESC) ");
					 */
				}
				
			}			
			else 
			{
				    
				 	strReqId="37";
				 	
				 	 System.out.println("<<------Req Type 37 - Issue To Dept [LP] WHEN ONLY STORE SELECTED LAST      ------>>");
				 	 
					brMainQuery = new StringBuffer(500);
					brMainQuery.append("SELECT hstnum_store_id");
				       brMainQuery.append("||'@'||hstnum_issue_no");
				       brMainQuery.append("||'@'||hrgnum_puk");
				       brMainQuery.append("||'@'||pistr_emp_no");
				       brMainQuery.append("||'@'||sstnum_item_cat_no");
				       brMainQuery.append("||'@'|| To_char(hstdt_issue_date, 'DD-Mon-yyyy')");
				       brMainQuery.append("||'@'||hstnum_req_no");
				       brMainQuery.append("||'@'||To_char(hstdt_req_date, 'dd-Mon-yyyy')");
				       brMainQuery.append("||'@'||gnum_hospital_code");
				       brMainQuery.append("||'^'||hstnum_issue_no");
				       brMainQuery.append("||'^'||hstnum_req_no");
				       brMainQuery.append("||'^'||To_char(hstdt_issue_date, 'DD-Mon-yyyy hh24:mi')");
				       brMainQuery.append("||'^'|| mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_req_storeid)");
				       brMainQuery.append("||'^'||hrgnum_puk");
				       brMainQuery.append("||'^'|| ahis_function.Fun_pat_name(hrgnum_puk)");
				       brMainQuery.append("||'^'||Mms_mst.Get_itemcat_dtl(1 :: NUMERIC, gnum_hospital_code, sstnum_item_cat_no)");
				       brMainQuery.append("||'^0'AS DATA");
				       brMainQuery.append(" FROM   sstt_issue_dtl A");
				       brMainQuery.append(" WHERE   hstnum_store_id = "+cmb[0]+"");
				       brMainQuery.append(" AND sstnum_reqtype_id = 35");
				       brMainQuery.append(" AND gnum_hospital_code = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"");

			}

			
			
			
			
		}
		System.out.println("In MMS_LP Issue Desk Main Query-->>"+brMainQuery.toString());
		
		return brMainQuery.toString();

	}


	public String[] getSearchField() 
	{
		
		String search_field[] = {"1", "HSTNUM_REQ_NO"};
		if(cmbVal != null){
			if(cmbVal[1].equals("32") && cmbVal[2].equals("1"))
			{
				search_field=new String[4];
				search_field[0]="1";
				search_field[1]="HSTNUM_REQ_NO";
				search_field[2]="4";
				search_field[3]="HRGNUM_PUK";
				
			}

			else if(cmbVal[1].equals("31") && cmbVal[2].equals("1"))
			{
				search_field=new String[4];
				search_field[0]="1";
				search_field[1]="HSTNUM_REQ_NO";
				search_field[2]="4";
				search_field[3]="HRGNUM_PUK";

			}
			
			if(cmbVal[1].equals("32") && (cmbVal[2].equals("4")))
			{
				search_field=new String[4];
				search_field[0]="1";
				search_field[1]="HSTNUM_ISSUE_NO";
				search_field[2]="4";
				search_field[3]="HRGNUM_PUK";
				
			}
			else if(cmbVal[1].equals("31") && (cmbVal[2].equals("4"))){
				search_field=new String[2];
				search_field[0]="1";
				search_field[1]="HSTNUM_ISSUE_NO";

				
			}
			else {
				search_field=new String[4];
				search_field[0]="1";
				search_field[1]="HSTNUM_REQ_NO";
				search_field[2]="4";
				search_field[3]="HRGNUM_PUK";
			}
		}
		else{
			
			search_field=new String[4];
			search_field[0]="1";
			search_field[1]="HSTNUM_REQ_NO";
			search_field[2]="4";
			search_field[3]="HRGNUM_PUK";
//			search_field[4]="5";
//			search_field[5]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";

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
		//String[] strComboHeader = {"0^2","Drug Warehouse Name","1","Request From","1","Status"};
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Request Type";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Request Type";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}

		
		
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Indent No.", "Indent Date", "Raising Store","CR.No", "Patient Name","Catg"};
		
		
		
		if(cmbVal != null){
			
			
			if(cmbVal[1].equals("32"))			//issue to pat(OPD)
			{
				strColumnHeader = new String[5];
				if(cmbVal[2].equals("4"))			//processed
				{
					strColumnHeader[0]="Issue No.";
					strColumnHeader[1]="Req No";
					strColumnHeader[2]="Req Date";
					strColumnHeader[3]="CR.No.";
					strColumnHeader[4]="Patient Name";
				}
				else
				{
					strColumnHeader[0]="Indent No.";
					strColumnHeader[1]="Indent Date";
					strColumnHeader[2]="Raising Store";
					strColumnHeader[3]="CR.No.";
					strColumnHeader[4]="Patient Name";
				}
				
				
			}
			if(cmbVal[1].equals("35"))			//issue to pat(IPD)
			{
				strColumnHeader = new String[6];			//processed
				if(cmbVal[2].equals("4"))
				{
					strColumnHeader = new String[6];
					strColumnHeader[0]="Issue No.";
					strColumnHeader[1]="Req No";
					strColumnHeader[2]="Issue Date";
					strColumnHeader[3]="Raising Store";
					strColumnHeader[4]="CR.No";
					strColumnHeader[5]="Patient Name";
				}
				else
					if(cmbVal[2].equals("1"))
					{
						strColumnHeader = new String[6];
						strColumnHeader[0]="Indent No.";
						strColumnHeader[1]="Indent Date";
						strColumnHeader[2]="Raising Store";
						strColumnHeader[3]="CR.No";
						strColumnHeader[4]="Patient Name";
						strColumnHeader[5]="Catg";
					}
				else
				{
						strColumnHeader = new String[7];
						strColumnHeader[0]="Indent No";
						strColumnHeader[1]="Indent Date";
						strColumnHeader[2]="Issue Date";
						strColumnHeader[3]="Raising Store";
						strColumnHeader[4]="CR.No";
						strColumnHeader[5]="Patient Name";
						strColumnHeader[6]="Catg";
						
					
				}
				
				
			}
			
		}
		
		return strColumnHeader;
	}      

	public String[] getComboQuery() 
	{
			
		String[] comboQuery = new String[3];
				
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
		
		
		comboQuery[1] = "SELECT   SSTNUM_INDENTTYPE_ID,"
				+ " SSTSTR_INDENTTYPE_NAME"
				+ "  FROM SSTT_INDENTTYPE_MST A"
                   + " WHERE  GNUM_ISVALID = 1"
                 + "   AND SSTNUM_INDENTTYPE_ID IN(35)"
                  + "  ORDER BY SSTNUM_FILE_TYPE";						
		comboQuery[2] ="1^New Request#4^Processed";	
		
		return comboQuery;
		
		
		
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {

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
		String files = "../js/IssueDeskPrint_Trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "Urgent", "8", "CYAN", "Urgent-----*Return applicable for IPD patients with active billing account only"};
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
		String[] strButtons = {
				"View@callViewCnt()@1@007bb6@glyphicon-fullscreen"				
				};	
		return strButtons;
	}

	public String[] getDbButtons() {
		String[] str = { "1" };
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
		return "changeCombo";
	}

	public String[] getOrderBy() 
	{
		String orderBy[] = { "1", "GDT_ENTRY_DATE","2","HSTDT_REQ_DATE","3","hstnum_store_id","6","sstnum_item_cat_no"};
		
			
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"IssueOnDesk.png","ReturnOnDesk.png","ViewOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	

}
