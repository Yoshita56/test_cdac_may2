/**
 * 
 */
package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 09/April/2009
 * 
 */
public class InspectionDeskTransUTL extends TransInterface {

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
		String masterName = "Inspection Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery
				.append("SELECT HSTNUM_STORE_ID ||'@'|| HSTNUM_REQ_NO ||'@'|| GNUM_HOSPITAL_CODE"
						+ "||'^'|| HSTNUM_REQ_NO ||'^'|| TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY')"
						+ " ||'^'||MMS_MST.get_itemcat_dtl(1,gnum_hospital_code,SSTNUM_ITEM_CAT_NO)"
						+ " ||'^'|| MMS_MST.get_committeename_dtl(GNUM_HOSPITAL_CODE ,HSTNUM_COMMITTEE_TYPE_ID)"
						+ "   AS DATA"
						+ "	FROM HSTT_INSPECTION_DTL WHERE GNUM_HOSPITAL_CODE =");
		brMainQuery
				.append(httpSession.getAttribute("HOSPITAL_CODE").toString());
		brMainQuery.append(" AND GNUM_ISVALID = 1 ");

		if (cmb != null) {

			brMainQuery.append(" AND HSTNUM_STORE_ID  = ");
			brMainQuery.append(cmb[0]);

		} else {

			brMainQuery.append(" AND HSTNUM_STORE_ID  = 0");

		}
		//System.out.println("brMainQuery.toString()-" + brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() {
		String search_field[] = { "1", "HSTNUM_REQ_NO" };
		return search_field;
	}

	public String[] getComboHeader() {
		String[] strComboHeader = { "0", "Drug Warehouse Name", "1", "Status" };
		return strComboHeader;
	}

	public String[] getColumnHeader() {
		String[] strColumnHeader = { "Request No.", "Req Date",
				"Categorty", "Committee Name", };

		return strColumnHeader;
	}

	public String[] getComboQuery() {

		String[] comboQuery = new String[2];
		comboQuery[0] = "SELECT HSTNUM_STORE_ID, HSTSTR_STORE_NAME FROM HSTT_STORE_MST WHERE GNUM_HOSPITAL_CODE = "
				+ httpSession.getAttribute("HOSPITAL_CODE").toString()
				+ " AND GDT_EFFECTIVE_FRM <= SYSDATE AND GNUM_ISVALID = 1 ORDER BY HSTSTR_STORE_NAME";

		comboQuery[1] = "1^Active#2^Issued#3^Report Entered";
		return comboQuery;

	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
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
		String files = "../js/inspectiondesk_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "Autrin Cap", "2", "brown", "Expired", "aLkol",
				"2", "blue", "Alkol" };
		return status;
	}

	public String getEventState() {
		String str = "inspectionDeskButtonStatus";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		String[] strButtons = {
				"Intimation@callIntimationCnt(document.forms[0],'INTIMATION')@1@9B25AF@glyphicon-bell",
				"Issue@callIssueCnt(document.forms[0],'ISSUE')@1@3b5998@glyphicon-plus",
				"Cancel@callCancelCnt(document.forms[0],'CANCEL')@1@bb0000@glyphicon-remove",
				"View@callViewCnt(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen" };
		return strButtons;
	}

	public String[] getDbButtons() {
		String[] str = { "4" };
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
		return "onStatusChange";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "HSTNUM_REQ_NO" };
		return orderBy;
	}

}
