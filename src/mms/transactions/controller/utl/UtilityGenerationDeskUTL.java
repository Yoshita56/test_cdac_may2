
package mms.transactions.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;
/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */

public class UtilityGenerationDeskUTL extends TransInterface {

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
		String masterName = "Utility Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(1000);
		String strFinancialStartYear = "";
        String strFinancialEndYear = "";
	    MmsConfigUtil mcu = null;
	    String hosCode=httpSession.getAttribute("HOSPITAL_CODE").toString();
	    mcu = new MmsConfigUtil(hosCode);
	    String[] strTemp1 = null;
	    String[] strTemp = null;
	    
	    if(cmb != null)
	    {
				
	    	if(cmb[2].equals("1"))
		    {
	        brMainQuery.append("select hstnum_utility_no||'@'||hstnum_indent_no||'@'||hstnum_store_id||'@'||hrgnum_puk||'@'||hipnum_adm_no||'^'||hstnum_utility_no||'^'||to_char(gdt_entry_date,'dd-Mon-yyyy')||'^'||hrgnum_puk||'^'||hststr_pat_name||'^'||hststr_item_name||'^'||hststr_supplier from hstt_utility_generation_dtl where  hstnum_uc_status = 10 and gnum_hospital_code = ");
			brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
			brMainQuery.append("and substr(hstnum_indent_no,0,2) = "+cmb[1]+" and hstnum_store_id = "+cmb[0].replace("^", "#").split("#")[0]);
		    }
	    	else if(cmb[2].equals("2"))
	    	{
	    		brMainQuery.append("select hstnum_utility_no||'@'||hstnum_indent_no||'@'||hstnum_store_id||'@'||hrgnum_puk||'@'||hipnum_adm_no||'^'||hstnum_utility_no||'^'||to_char(gdt_entry_date,'dd-Mon-yyyy')||'^'||hrgnum_puk||'^'||hststr_pat_name||'^'||hststr_item_name||'^'||hststr_supplier from hstt_utility_generation_dtl where  gnum_hospital_code = ");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				brMainQuery.append(" and substr(hstnum_indent_no,0,2) = "+cmb[1]+" and hstnum_store_id = "+cmb[0].replace("^", "#").split("#")[0]);
	 				
	 				
	    	}
	    
	    }
	    else
	    {
	    	brMainQuery.append("select hstnum_utility_no||'@'||hstnum_indent_no||'@'||hstnum_store_id||'@'||hrgnum_puk||'@'||hipnum_adm_no||'^'||hstnum_utility_no||'^'||to_char(gdt_entry_date,'dd-Mon-yyyy')||'^'||hrgnum_puk||'^'||hststr_pat_name||'^'||hststr_item_name||'^'||hststr_supplier from hstt_utility_generation_dtl where hstnum_uc_status = 10 and gnum_hospital_code = ");
			brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
	    }

		mcu = null;
		
		////System.out.println("Utility desk Main Query-->>>>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "hstnum_utility_no"};	   
		return search_field;
	}
	
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */

	public String[] getComboHeader() 
	{
		String[] strComboHeader = new String[6];
		strComboHeader[0] = "0^1";
		strComboHeader[1] = "Store Name";
		strComboHeader[2] = "0^2";
		strComboHeader[3] = "Category";
		strComboHeader[4] = "1";
		strComboHeader[5] = "Status";
	    return strComboHeader;
	 
	}

	public String[] getColumnHeader() 
	{	
		String[] strColumnHeader = new String[6];
		strColumnHeader[0] = "Utility No";
		strColumnHeader[1] = "Utility Date";
		strColumnHeader[2] = "CR No.";
		strColumnHeader[3] = "Patient Name";
		strColumnHeader[4] = "Item";
		strColumnHeader[5] = "Supplier";
		return strColumnHeader;
		
		
	}      

	public String[] getComboQuery()
	{
		
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		
		String[] comboQuery = new String[3];
	    
	   
		comboQuery[0] = "select HSTNUM_STORE_ID|| '^' ||HSTNUM_STORETYPE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="+hosCode+
			" AND EXISTS"+
						   "("+
						    "SELECT 'X'"+
						    "FROM GBLT_ROLE_SEAT_TABLE_DTL P"+
						    " WHERE UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"+
						    " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID') and gnum_module_id = 63 "+
						    " AND P.gnum_hospital_code = A.gnum_hospital_code AND gbl_isvalid = 1 "+
						  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
						 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
						 ",A.GNUM_HOSPITAL_CODE)"+")"+
						" ORDER BY INITCAP(HSTSTR_STORE_NAME)";


		////System.out.println("comboQuery[0]:::   "+comboQuery[0]);
		
		comboQuery[1] = mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.0");
        comboQuery[1] = comboQuery[1].concat(mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.cond.0")).replace("?",hosCode);
        
        ////System.out.println("comboQuery[1]:::   "+comboQuery[1]);
        
		comboQuery[2] = "1^New#2^Processed";
				

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
		String files = "../../mms/js/UtilityGeneration.js";
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
		         strButtons = new String[3];
				 strButtons[0] = "Generate@buttonLogicsOnClick1(1,'ADD','Add')@0@3b5998@glyphicon-plus";
				 strButtons[1] = "Modify@buttonLogicsOnClickCancel(2,'MODIFY','Remove')@1@bb0000@glyphicon-remove";
			  	 strButtons[2] = "Print@buttonLogicsOnClickPrint(5,'PRINT','Print')@1@0c8d20@glyphicon-print";	
				
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
		String orderBy[] = { "2", "gdt_entry_date", "1", "hstnum_utility_no" };
		return orderBy;
	}
	@Override
	public String[] getButtonIcons() {
	//	String[] str={"GenerateOnDesk.png","CancelOnDesk.png","ReturnOnDesk.png","ViewOnDesk.png","PrintOnDesk.png","icon-default.png"};
		String[] str={"GenerateOnDesk.png","UpdateOnDesk.jpeg","PrintOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	

}
