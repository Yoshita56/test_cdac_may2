package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.transactionutil.TransInterface;

public class AcknowledgeDeskTransUTL extends TransInterface {
	
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
		String masterName = "Acknowledge Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(500);
		 
		brMainQuery.append(" select HSTNUM_ACK_NO||'@'||GNUM_HOSPITAL_CODE||'@'||HSTNUM_STORE_ID||'@'|| "); 
		brMainQuery.append(" HSTNUM_TRANS_NO||'@'||HSTNUM_TRANS_TYPE||'^'||HSTNUM_TRANS_NO||'^'|| ");
		brMainQuery.append(" HSTDT_TRANS_DATE||'^'||HSTNUM_TRANS_TYPE AS data from  ");
		brMainQuery.append(" SSTT_ACKNOWLEDGE_DTL where  GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString());
		brMainQuery.append(" and GNUM_ISVALID = 1 ");
				
		if (cmb != null) {
			if (!cmb[0].equals("0")){
				String strTemp[]=cmb[0].split("/");
				brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
						.lastIndexOf("0") +1, strTemp[0]);
			}
		}		
		
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "HSTNUM_TRANS_NO"};
		return search_field;
	}

	public String[] getComboHeader() 
	{
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		
		String[] strComboHeader = new String[4];		
		//System.out.println("Value::::"+mmscofigutil.getStrStoreConfigCatg());
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";

		}
		else
		{
			strComboHeader[0] = "0";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";

		}

		
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Trans No", "Trans Date", "Trans Type"};
		return strColumnHeader;
	}      

	public String[] getComboQuery(){
	
		String[] comboQuery = new String[3];
		comboQuery[0] = "select HSTNUM_STORE_ID||'/'||HSTNUM_STORETYPE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="+
				httpSession.getAttribute("HOSPITAL_CODE").toString();
		comboQuery[1] = "0^Ack Pending#1^Ack Done";
		return comboQuery;
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = 
		"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();'></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
//		String a[] = null;
//		String b[] = null;
//		String key[] = new String[1];
//
		List<String> deleteData = new ArrayList<String>();
//		a = (chk.replace('|', '#')).split("#");
//		b = (a[0].replace('@', '#')).split("#");
//
//		key[0] = b[0];
//		System.out.print("key[0] = " + key[0]);
//		deleteData.add(key);
//		return deleteData;
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/acknowledgeDesk_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status ={ "Autrin Cap", "2", "brown", "Expired", "aLkol",
				"2", "blue", "Alkol" };
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
		String[] strButtons = {"Acknowledge@callPage1(document.forms[0],'ACKNOWLEDGE')@0@00aced@glyphicon-check",
				"View@callPage1(document.forms[0],'VIEW')@0@007bb6@glyphicon-fullscreen"};		
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
		return "changeCombo";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "2", "HSTDT_TRANS_DATE" };
		return orderBy;
	}

}
