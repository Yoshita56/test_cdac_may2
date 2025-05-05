package dossier.transaction.controller.util;


import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class DossierDeskTransUTL extends TransInterface {

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
		String masterName = "Dossier Requisition Desk";
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
  // added by shefali garg 1-jan-2015 & changed by shalini on 13-01-2015 for item category and hardcoded hospital code
		brMainQuery.append("select "+
			" hnum_dossier_req_id||'@'||gnum_hospital_code||'@'||hrgnum_puk||'@'||hnum_req_mode||'@'|| "+
			" hnum_ref_req_id||'@'||hnum_servicetype_id||'@'||hnum_service_id||'@'||hstr_service_name||'@'|| "+
			" hnum_dossier_id||'@'||hnum_dossier_status||'@'||hstr_entry_remark||'@'||hstr_post_remark||'@'||  "+
			" hnum_cancel_reason_id||'@'|| hstr_cancel_remark||'@'|| gnum_isvalid||'@'|| to_char(A.gdt_entry_date,'DD-MON-YYYY')||'@'|| hnum_tostore_id  ||'@'|| hstnum_patient_type  ||'@'|| "+
			" gnum_seat_id ||'^'|| dossier_mst.get_service_name(hnum_dossier_id::numeric, gnum_hospital_code::numeric, hnum_servicetype_id::numeric)||'^'|| "+
			" Ahis_Function.FUN_PAT_NAME (HRGNUM_PUK)||'^'||HRGNUM_PUK  ||'^'|| to_char(A.gdt_entry_date)|| '^'|| hnum_dossier_req_id || '^'|| decode(hnum_is_dossier_finalized,1,'Yes','No')|| '^'|| hstnum_patient_type || '^'||  hnum_servicetype_id "
			+ "from hgdt_dossier_req_dtl a "
			+ "where hnum_is_dossier_finalized = 0 "
			+ "AND A.GDT_ENTRY_DATE >= TRUNC(SYSDATE) - 90 "
			+ "and gnum_hospital_code="+httpSession.getAttribute("HOSPITAL_CODE").toString()+"  "
					+ "and gnum_isvalid=1 "
					+ "and decode(hstnum_patient_type,1,hrgnum_puk in"
					+ " (SELECT HRGNUM_PUK AS PUK "
					+ "FROM HIPT_PATADMISSION_DTL A  "
					+ "WHERE GNUM_ISVALID = 1 "
					+ "AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
							+ "AND HIPDT_DISDATETIME IS NULL AND HIPNUM_ISACCEPTED = 1 "
							+ "AND HIPNUM_IS_DEAD<>1 AND (SELECT count(*) "
							+ "FROM HBLT_PATACCOUNT_DTL B "
							+ "WHERE GNUM_ISVALID = 1 "
							+ "AND HBLNUM_pataccount_status in (1,2) "
							+ "AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
									+ "AND B.HRGNUM_PUK= A.HRGNUM_PUK AND B.HASTR_ADM_NO = A.HIPNUM_ADMNO)>0 "
									+ " ORDER BY HIPDT_ADMDATETIME  DESC),hrgnum_puk = hrgnum_puk)" );
		
		

		
		if(cmb!=null)
		{
			if(cmb[0]!=null){
				brMainQuery.append(" and A.hnum_servicetype_id ="+ cmb[0]);
			}
			if(cmb[1]!=null && cmb[1].equalsIgnoreCase("2")){
				//brMainQuery.append("and hnum_dossier_status = 2 ");
				brMainQuery.delete(0, brMainQuery.length());
				/*
				brMainQuery.append(""
						+ "select  hnum_dossier_req_id||'@'||a.gnum_hospital_code||'@'||a.hrgnum_puk||'@'||hnum_req_mode||'@'||  hnum_ref_req_id||'@'|| "
						+ "hnum_servicetype_id||'@'||hnum_service_id||'@'||hstr_service_name||'@'||  hnum_dossier_id||'@'||hnum_dossier_status||'@'|| "
							+ "hstr_entry_remark||'@'||hstr_post_remark||'@'||   hnum_cancel_reason_id||'@'|| hstr_cancel_remark||'@'|| a.gnum_isvalid||'@'|| " 
							+ "to_char(a.gdt_entry_date,'DD-MON-YYYY')||'@'|| hnum_tostore_id  ||'@'|| HSTNUM_ISSUE_NO  ||'@'|| gnum_seat_id || '@'|| hstnum_patient_type ||'^'|| "
						+ "	dossier_mst.get_service_name(hnum_dossier_id::numeric, a.gnum_hospital_code::numeric, hnum_servicetype_id::numeric)||'^'||  "
						+ "	Ahis_Function.FUN_PAT_NAME (a.HRGNUM_PUK)||'^'||a.HRGNUM_PUK  ||'^'|| to_char(a.gdt_entry_date)|| '^'|| hnum_dossier_req_id || '^'|| decode(hnum_is_dossier_finalized,1,'Yes','No')|| '^'|| hstnum_patient_type || '^'||  hnum_servicetype_id "
						+ " from hgdt_dossier_req_dtl a , sstt_issue_dtl b "
						+ "	 where a.hnum_is_dossier_finalized = 0 AND A.GDT_ENTRY_DATE >= TRUNC(SYSDATE) - 90 "
						+ "and a.gnum_hospital_code="+httpSession.getAttribute("HOSPITAL_CODE").toString()+"  "
								+ "and a.gnum_isvalid=1 and hnum_servicetype_id ="+cmb[0]+" "
										+ "and hnum_dossier_status = 2 "
						+ "	and a.hnum_dossier_req_id=b.hstnum_req_no AND SSTNUM_REQTYPE_ID=98 "
						+ "and decode(hstnum_patient_type,1,a."
						+ "hrgnum_puk in (SELECT HRGNUM_PUK AS PUK FROM HIPT_PATADMISSION_DTL A  "
						+ "WHERE GNUM_ISVALID = 1  "
						+ "AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
								+ "AND HIPDT_DISDATETIME IS NULL AND HIPNUM_ISACCEPTED = 1 "
								+ "AND HIPNUM_IS_DEAD<>1 AND (SELECT count(*) "
								+ "FROM HBLT_PATACCOUNT_DTL B WHERE GNUM_ISVALID = 1 "
								+ "AND HBLNUM_pataccount_status in (1,2) "
								+ "AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
										+ "AND B.HRGNUM_PUK= A.HRGNUM_PUK AND B.HASTR_ADM_NO = A.HIPNUM_ADMNO)>0  "
										+ "ORDER BY HIPDT_ADMDATETIME  DESC),a.hrgnum_puk = b.hrgnum_puk)");
										*/
				
				 brMainQuery.append("  SELECT hnum_dossier_req_id ");
			        brMainQuery.append(" ||'@'||a.gnum_hospital_code");
			        brMainQuery.append(" ||'@'||a.hrgnum_puk");
			        brMainQuery.append(" ||'@'||hnum_req_mode");
			        brMainQuery.append(" ||'@'|| hnum_ref_req_id");
			        brMainQuery.append(" ||'@'|| hnum_servicetype_id");
			        brMainQuery.append(" ||'@'||hnum_service_id");
			        brMainQuery.append(" ||'@'||hstr_service_name");
			        brMainQuery.append(" ||'@'|| hnum_dossier_id");
			        brMainQuery.append(" ||'@'||hnum_dossier_status");
			        brMainQuery.append(" ||'@'|| hstr_entry_remark");
			        brMainQuery.append(" ||'@'||hstr_post_remark");
			        brMainQuery.append(" ||'@'|| hnum_cancel_reason_id");
			        brMainQuery.append(" ||'@'|| hstr_cancel_remark");
			        brMainQuery.append(" ||'@'|| a.gnum_isvalid");
			        brMainQuery.append(" ||'@'|| To_char(a.gdt_entry_date,'DD-MON-YYYY')");
			        brMainQuery.append(" ||'@'|| hnum_tostore_id");
			        brMainQuery.append(" ||'@'|| hstnum_issue_no");
			        brMainQuery.append(" ||'@'|| gnum_seat_id");
			        brMainQuery.append(" ||'@'|| hstnum_patient_type");
			        brMainQuery.append(" ||'^'|| dossier_mst.Get_service_name(hnum_dossier_id::numeric, a.gnum_hospital_code::numeric, hnum_servicetype_id::numeric)");
			        brMainQuery.append(" ||'^'|| ahis_function.Fun_pat_name (a.hrgnum_puk)");
			        brMainQuery.append(" ||'^'||a.hrgnum_puk");
			        brMainQuery.append(" ||'^'|| To_char(a.gdt_entry_date)");
			        brMainQuery.append(" ||'^'|| hnum_dossier_req_id");
			        brMainQuery.append(" ||'^'|| Decode(hnum_is_dossier_finalized,1,'Yes','No')");
			        brMainQuery.append(" ||'^'|| hstnum_patient_type");
			        brMainQuery.append(" ||'^'|| hnum_servicetype_id");
			        brMainQuery.append(" FROM   hgdt_dossier_req_dtl a ,");
			        brMainQuery.append(" sstt_issue_dtl b ");
			        brMainQuery.append(" WHERE  a.hnum_is_dossier_finalized = 0 ");
			        brMainQuery.append("AND    a.gdt_entry_date >= Trunc(sysdate) - 90 ");
			        brMainQuery.append("AND    a.gnum_hospital_code="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" ");
			        brMainQuery.append("AND    a.gnum_isvalid=1 ");
			        brMainQuery.append("AND    hnum_servicetype_id ="+cmb[0]+"");
			        brMainQuery.append("AND    hnum_dossier_status = 2");
			        brMainQuery.append("AND    a.hnum_dossier_req_id=b.hstnum_req_no ");
			        brMainQuery.append("AND    b.sstnum_reqtype_id=98 ");
			        brMainQuery.append("AND    Decode(hstnum_patient_type,1,a.hrgnum_puk IN ");
			        brMainQuery.append("(");
			        brMainQuery.append("  SELECT   hrgnum_puk AS puk ");
			        brMainQuery.append(" FROM     hipt_patadmission_dtl A ");
			        brMainQuery.append("  WHERE    gnum_isvalid = 1 ");
			        brMainQuery.append("  AND      gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
			        brMainQuery.append("  AND      hipdt_disdatetime IS NULL ");
			        brMainQuery.append("  AND      hipnum_isaccepted = 1 ");
			        brMainQuery.append("  AND      hipnum_is_dead<>1 ");
			        brMainQuery.append("  AND");
			        brMainQuery.append("           (");
			        brMainQuery.append("                  SELECT Count(*)");
			        brMainQuery.append("                  FROM   hblt_pataccount_dtl B");
			        brMainQuery.append("                  WHERE  gnum_isvalid = 1");
			        brMainQuery.append("                  AND    hblnum_pataccount_status IN (1,2)");
			        brMainQuery.append("                  AND    gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
			        brMainQuery.append("                  AND    b.hrgnum_puk= a.hrgnum_puk");
			        brMainQuery.append("                 AND    b.hastr_adm_no = a.hipnum_admno)>0");
			        brMainQuery.append("  ORDER BY hipdt_admdatetime DESC),a.hrgnum_puk = b.hrgnum_puk)");
				
			}
			if(cmb[1]!=null && cmb[1].equalsIgnoreCase("1")){
				brMainQuery.append("and A.hnum_dossier_status = 1 ");
			}
		}
		System.out.println("Dossier Main Query-->>"+brMainQuery.toString());
		
		return brMainQuery.toString();

	}

	public String[] getSearchField() 
	{
		
		String search_field[] = {"3", "A.HRGNUM_PUK" ,"5", "A.hnum_dossier_req_id"};
	
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
		String[] strComboHeader = new String[4];
	

			strComboHeader[0] = "0^0";
			strComboHeader[1] = "Service Type";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";
   return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Dossier Name", "Patient Name", "CR.No" , "Request Date" , "Request No.","Settlement Status"};
		
		
		return strColumnHeader;
	}      

	public String[] getComboQuery() 
	{
			
		String[] comboQuery = new String[2];
		/*comboQuery[0] = "SELECT HSTNUM_STORE_ID, HSTSTR_STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_HOSPITAL_CODE = "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+
				" AND GDT_EFFECTIVE_FRM <= SYSDATE AND GNUM_ISVALID = 1 "+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				    " AND UPPER(P.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(P.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
				    " AND gnum_column_value = A.HSTNUM_STORE_ID"+
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") ORDER BY INITCAP(HSTSTR_STORE_NAME)";*/
		
		//comboQuery[1] = "13^Patient#12^Staff#14^Dept";
		//comboQuery[2] = "1^Active#2^To Be Return#3^Issued#4^Returned";    changed as per req. of merging of all issue desk
		
		comboQuery[0] = "select hnum_servicetype_id,hstr_service_type from sgdt_servicetype_mst";
		
		comboQuery[1] ="1^New/In-Process#2^Processed";
		return comboQuery;
		
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {

		String strButtons = ""; 
		//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='window.parent.closeTab();' onClick='window.parent.closeTab();' ></a>";

//		String strButtons ="";
		//"<br><a href='#' class='button' onKeyPress='window.parent.closeTab();' onClick='window.parent.closeTab();'><span class='cancel'>Cancel</span></a> ";
		//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='window.parent.closeTab();' onClick='window.parent.closeTab();' ></a>";

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
		String files = "../js/Dossierdesk_Trans.js";
		return files;

	}

	public String[] getRowStatus() 
	{
		//String[] status = { "Urgent", "3", "CYAN", "Urgent-----*Return applicable for IPD patients with active billing account only"};
		//return status;
		
		/*
		 * "-1"--->> Value Which we Want to Maaped        1         2    3   4   5    6       7
		 * "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^-1
		 * "blue"--->>
		 * "Exp Within"--->>Argument You Want to Show in Footer of Template
		 * 
		 */
		String[] status = { 
		           "11", "9", "#90EE90", "OT Request"
		          ,"12", "9", "#87CEFF", "RADIOLOGY Request"
		          ,"13", "9", "#FFFF4D", "SERVICE AREA Request"
		          ,"1", "2", "CYAN", "Urgent-----*Return applicable for IPD patients with active billing account only"};
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
		String[] strButtons = {"Generate@validateIssue()@1@3b5998@glyphicon-plus",
				"Modify@validateReturn()@1@32506d@glyphicon-menu-left" ,
				"Cancel@CancelDossier()@1@32506d@glyphicon-menu-left"
				,"View@callViewCnt()@1@007bb6@glyphicon-fullscreen"
				//,"Dossier Settlement@callDossierSettlement()@1@007bb6@glyphicon-ok"
			}; //,"View@callViewCnt()@1"	
		return strButtons;
	}

	public String[] getDbButtons() {
		String[] str = { "3" };
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

	public String[] getOrderBy() {
		String orderBy[] = { "1", "A.GDT_ENTRY_DATE"};
		
	/*	if(cmbVal != null){
			
			if(cmbVal[1].equals("12") && cmbVal[2].equals("1"))
			{
				orderBy=new String[8];
				orderBy[0]="1";
				orderBy[1]="HSTNUM_REQ_NO";
				orderBy[2]="4";
				orderBy[3]="HRGNUM_PUK";
				orderBy[4]="5";
				orderBy[5]="PISTR_EMP_NO";
				orderBy[6]="6";
				orderBy[7]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";
				
				
				
			}
			else if(cmbVal[1].equals("14") && cmbVal[2].equals("1")){
				orderBy=new String[2];
				orderBy[0]="2";
				orderBy[1]="HSTDT_REQ_DATE";
				//orderBy[2]="3";
				//orderBy[3]="MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_REQ_STORE_ID )";
				
				
			}
			else if(cmbVal[1].equals("13") && cmbVal[2].equals("1")){
				orderBy=new String[6];
				orderBy[0]="1";
				orderBy[1]="HSTNUM_REQ_NO";
				orderBy[2]="4";
				orderBy[3]="HRGNUM_PUK";
				orderBy[4]="5";
				orderBy[5]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";
				
			}
			
			else if(cmbVal[1].equals("12") && (cmbVal[2].equals("2")||cmbVal[2].equals("3")||cmbVal[2].equals("4")))
			{
				orderBy=new String[8];
				orderBy[0]="1";
				orderBy[1]="HSTNUM_ISSUE_NO";
				orderBy[2]="4";
				orderBy[3]="HRGNUM_PUK";
				orderBy[4]="5";
				orderBy[5]="PISTR_EMP_NO";
				orderBy[6]="6";
				orderBy[7]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";
				
				
			}
			else if(cmbVal[1].equals("14") && (cmbVal[2].equals("2")||cmbVal[2].equals("3")||cmbVal[2].equals("4"))){
				orderBy=new String[4];
				orderBy[0]="1";
				orderBy[1]="HSTNUM_ISSUE_NO";
				orderBy[2]="3";
				orderBy[3]="MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID )";
				
				
			}
			else {
					orderBy=new String[6];
					orderBy[0]="1";
					orderBy[1]="HSTNUM_ISSUE_NO";
					orderBy[2]="4";
					orderBy[3]="HRGNUM_PUK";
					orderBy[4]="5";
					orderBy[5]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";
				
			}
		}
	else{
		
			orderBy=new String[6];
			orderBy[0]="1";
			orderBy[1]="HSTNUM_REQ_NO";
			orderBy[2]="4";
			orderBy[3]="HRGNUM_PUK";
			orderBy[4]="5";
			orderBy[5]="AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK)";
		
	}*/
		
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"IssueOnDesk.png","ReturnOnDesk.png","ReturnOnDesk.png"
				,"ViewOnDesk.png"
				}; //,"ViewOnDesk.png"
		// TODO Auto-generated method stub
		return str;
	}
	

}