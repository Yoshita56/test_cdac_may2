/**
 * 
 */
package mms.transactions.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class ItemInventorySurgicalTransUTL extends TransInterface {

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
		String masterName = "Item Inventory";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}



	public String[] getSearchField() {
		String search_field[] = {
				"1",
				"MMS_MST.GET_ITEM_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_ITEMBRAND_ID)"};
		return search_field;
	}

	/*
	 * 0^0 0 Means Combo From Query,1 Means User Defined Combo,0 After ^ Means
	 * Select Value,1 Means All,2 Means Default Selected
	 */
	public String[] getComboHeader() {
		String[] strComboHeader = { "0^1", "Store Name", "0^2",
				"Item Category ", "0^1", "Group Name", "0^2", "Item Status" };
		return strComboHeader;
	}

	public String[] getColumnHeader() {
		String[] strColumnHeader = { "Item Name", "Stock Qty", "Re-Order Level" };
		return strColumnHeader;
	}

	public String[] getComboQuery() {

		String[] comboQuery = new String[4];
		String strHospitalCode = " "
				+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " ";

		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where hstnum_store_id in (select distinct ba.hstnum_store_id from hstt_store_category_mst ba where ba.SSTNUM_ITEM_CAT_NO =21 and ba.hstnum_store_id = a.hstnum_store_id and ba.gnum_isvalid = 1 and ba.gnum_hospital_code = a.gnum_hospital_code) and  GNUM_ISVALID = 1 "// and gnum_ward_code = 0"	//dept and ward code 0 chk added by shalini to remove ward store from combo
				+"and  GNUM_HOSPITAL_CODE ="
				+ httpSession.getAttribute("HOSPITAL_CODE").toString()
				+ " AND EXISTS"
				+ "("
				+ "SELECT 'X'"
				+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"
				+ " WHERE P.gnum_metatable_id = q.gnum_metatable_id"
				//+ " AND P.gnum_hospital_code = q.gnum_hospital_code"
				+ " AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"
				+ " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"
				+ " AND P.gnum_hospital_code = A.gnum_hospital_code"
				+ " AND gnum_column_value = A.HSTNUM_STORE_ID"
				+ " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("
				+ httpSession.getAttribute("SEATID").toString()
				+ ",A.GNUM_HOSPITAL_CODE))"
				/*+ " AND EXISTS ( "
				+ "SELECT 'X' "
				+ "FROM hstt_store_reqtype_mst where "
				+ "sstnum_item_cat_no NOT IN (10, 9) "
				+ "AND gnum_hospital_code = a.gnum_hospital_code "
				+ "AND hstnum_store_id = a.hstnum_store_id "
				+ "AND SSTNUM_INDENTTYPE_ID=57 " + // SSTNUM_INDENTTYPE_ID is 57
													// for 'Item Inventory'
													// request
				")" */+ " ORDER BY INITCAP(HSTSTR_STORE_NAME) ";

		comboQuery[1] = "SELECT   MMS_MST.GET_ITEMCATEGORY_DTLS (100, "
				+ "SSTNUM_ITEM_CAT_NO), "
				+ "MMS_MST.GET_ITEMCAT_DTL (1, "
				+ "100, "
				+ "SSTNUM_ITEM_CAT_NO "
				+ ") AS CATNAME "
				+ "FROM HSTT_STORE_CATEGORY_MST A "
				+ "WHERE GNUM_ISVALID = 1 "
				+ "AND HSTNUM_STORE_ID = #1# "
				+ "AND SSTNUM_ITEM_CAT_NO = 21  and SSTNUM_ITEM_CAT_NO IN (select SSTNUM_ITEM_CAT_NO from sstt_item_category_mst where gnum_hospital_code = 100 and gnum_isvalid=1) " // SSTNUM_ITEM_CAT_NO is 10
													// for Drug
				+ "AND GNUM_HOSPITAL_CODE = "
				+ strHospitalCode
				/*+ "AND EXISTS ( "
				+ "SELECT 'x' "
				+ "FROM HSTT_STORE_REQTYPE_MST "
				+ "WHERE HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "
				+ "AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO "
				+ "AND SSTNUM_INDENTTYPE_ID = 57 " // SSTNUM_INDENTTYPE_ID is 57
													// for 'Item Inventory'
													// request
				+ "AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE) "*/
				+ "  ORDER BY CATNAME";

		if (cmbVal != null && cmbVal[0] != null && cmbVal[1] != null && !cmbVal[1].equalsIgnoreCase("0"))
			comboQuery[2] = "SELECT HSTNUM_GROUP_ID,HSTSTR_GROUP_NAME as grpName "
					+ "FROM HSTT_GROUP_MST WHERE GNUM_HOSPITAL_CODE = "
					+ Config.SUPER_USER_HOSPITAL_CODE
					+ " AND GNUM_ISVALID = 1 AND SSTNUM_ITEM_CAT_NO = SUBSTR(DECODE('#2#' , 'null' , '0^0^0' , '#2#'),0,2) order by grpName";
		else
			comboQuery[2] = "SELECT HSTNUM_GROUP_ID,HSTSTR_GROUP_NAME "
					+ "FROM HSTT_GROUP_MST WHERE GNUM_HOSPITAL_CODE = "
					+ Config.SUPER_USER_HOSPITAL_CODE
					+ " AND GNUM_ISVALID = 1 AND SSTNUM_ITEM_CAT_NO NOT IN (10)";
					/*+ "= ( select CASE  when length(SUBSTR (DECODE ('#2#', 'null', '0', '#2#'), 0, 2))>=2 "
					+ " then substr(DECODE ('#2#', 'null', '0', '#2#'),0,2) else '0' end from  dual )";*/

		comboQuery[3] = "SELECT HSTNUM_STOCK_STATUS_CODE, HSTSTR_STOCK_STATUS_DESC FROM SSTT_STOCK_STATUS_MST"
				+ " WHERE GNUM_ISVALID = 1 AND HSTNUM_STOCK_STATUS_CODE = 10 AND GNUM_HOSPITAL_CODE = "
				+ Config.SUPER_USER_HOSPITAL_CODE
				+ " ORDER BY HSTNUM_STOCK_STATUS_CODE";
		//System.out.println("comboQuery==========>>  "+comboQuery[1]);
		return comboQuery;
}
	public String getMainQuery(String cmb[]) {
		/* Variable Declaration */
		String strHospitalCode = null;
		String strMainQuery = null;
		String strCondition1 = null;
		String strCondition2 = null;
		String strCondition3 = null;
		String strCondition4 = null;
		StringBuffer brMainQuery = null;
		MmsConfigUtil mmscofigutil=null;
		
		int nExpAlertDays;
		boolean fValidExpAlertDays;

		/* Getting Hospital Code From Session */
		strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		if (cmb == null) 
		{
			brMainQuery = new StringBuffer();
			strMainQuery = mms.qryHandler_mms
					.getQuery(2, "itemInventoryTrans.main1");
			strMainQuery = strMainQuery.replaceFirst("\\?", strHospitalCode);

			brMainQuery.append(strMainQuery);
			
		}else
		{
			
		/* Getting Query and conditions from properties */
		
		strMainQuery = mms.qryHandler_mms
				.getQuery(2, "itemInventoryTrans.main");
		strCondition1 = mms.qryHandler_mms.getQuery(2,
				"itemInventoryTrans.main.condition.1");
		strCondition2 = mms.qryHandler_mms.getQuery(2,
				"itemInventoryTrans.main.condition.2");
		strCondition3 = mms.qryHandler_mms.getQuery(2,
				"itemInventoryTrans.main.condition.3");
		strCondition4 = mms.qryHandler_mms.getQuery(2,
				"itemInventoryTrans.main.condition.4");

		brMainQuery = new StringBuffer();
		
		
		/**************** Exp Alert Period *************************/
		mmscofigutil = new MmsConfigUtil(strHospitalCode);
		nExpAlertDays = 0;
		fValidExpAlertDays = true;
		
		String strExpAlertDays = mmscofigutil.getStrExpAlertDays();
		

		if (strExpAlertDays != null && !strExpAlertDays.trim().equals("")) {
			try {
				nExpAlertDays = Integer.parseInt(strExpAlertDays);
				if (nExpAlertDays < 0) {
					fValidExpAlertDays = false;
					
				}
			} catch (NumberFormatException ex) {

				fValidExpAlertDays = false;
				

			}

		} else {
			fValidExpAlertDays = false;
			
		}
		if (!fValidExpAlertDays) {
			nExpAlertDays=-1;
		}
		
		//strMainQuery = strMainQuery.replaceFirst("\\?", Integer.toString(nExpAlertDays) );
		
		
		/*****************************************/

		strMainQuery = strMainQuery.replaceFirst("\\?", strHospitalCode);

		brMainQuery.append(strMainQuery);

		if (cmb != null) 
		{
			if( cmb[0] != null && !cmb[0].equals("0"))
			{
				strCondition1 = strCondition1.replaceFirst("\\?", cmb[0]);
				brMainQuery.append(strCondition1);
			}
			if (!"0".equals(cmb[1])) 
			{
				strCondition2 = strCondition2.replaceFirst("\\?", cmb[1].split("\\^")[0]);
				brMainQuery.append(strCondition2);
			}
			if (!"0".equals(cmb[2])) 
			{
				strCondition3 = strCondition3.replaceFirst("\\?", cmb[2]);
				brMainQuery.append(strCondition3);
			}
			if(!"0".equals(cmb[3]))
			{
				
				strCondition4 = strCondition4.replaceFirst("\\?", cmb[3]);
				
			} else {
				strCondition4 = strCondition4.replaceFirst("\\?", "10"); //default selected.
			}
			
			brMainQuery.append(strCondition4);

		} else {
			//strCondition1 = strCondition1.replaceFirst("\\?", "0");	commented to show all data on page load
			//strCondition2 = strCondition2.replaceFirst("\\?", "0");	commented to show all data on page load
			//strCondition3 = strCondition3.replaceFirst("\\?", "0");	commented to show all data on page load
			strCondition4 = strCondition4.replaceFirst("\\?", "10");

			//brMainQuery.append(strCondition1);						commented to show all data on page load
			//brMainQuery.append(strCondition2);						commented to show all data on page load
			//brMainQuery.append(strCondition3);						commented to show all data on page load
			brMainQuery.append(strCondition4);		

		}
		brMainQuery.append(" and sstnum_item_cat_no=21   GROUP BY HSTNUM_STORE_ID    ,HSTNUM_ITEM_ID,   HSTNUM_ITEMBRAND_ID,GNUM_HOSPITAL_CODE   ,HSTNUM_STOCK_STATUS_CODE,HSTNUM_INHAND_QTY_UNITID ,HSTNUM_INHAND_QTY ,HSTSTR_BATCH_NO");
		//System.out.println("brMainQuery.toString()"+brMainQuery.toString());
		}
		return brMainQuery.toString();

	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
		// "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String[]> getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];

		List<String[]> deleteData = new ArrayList<String[]>();
		a = (chk.replace('|', '#')).split("#");
		b = (a[0].replace('@', '#')).split("#");

		key[0] = b[0];

		deleteData.add(key);
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/mms_Surgical_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		MmsConfigUtil mmscofigutil = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		int nExpAlertDays = 0;
		boolean fValidExpAlertDays = true;
		String strNote = null;
		String strExpAlertDays = mmscofigutil.getStrExpAlertDays();
		StringBuffer sbNote = new StringBuffer(
				"*Reserved/Branded Item. ");

		if (strExpAlertDays != null && !strExpAlertDays.trim().equals("")) {
			try {
				nExpAlertDays = Integer.parseInt(strExpAlertDays);
				if (nExpAlertDays < 0) {
					fValidExpAlertDays = false;
					strNote = "Expiry Alert -ve! Configure through MmsConfig.";
				}
			} catch (NumberFormatException ex) {

				fValidExpAlertDays = false;
				strNote = "Expiry Alert invalid! Configure through MmsConfig.";

			}

		} else {
			fValidExpAlertDays = false;
			strNote = "No Expiry Alert! Configure through MmsConfig.";
		}
		if (fValidExpAlertDays) {
			strNote = "Blue items will expire within "
					+ nExpAlertDays + " days.";
		}
		sbNote.append(strNote);

		String[] status = { strExpAlertDays, "2", "Blue", sbNote.toString() ,"1","3","#F4C7CE", "Expired"};
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
		String[] strButtons = {
				//"Add@validateAddItemInventory(document.forms[0],'ADD')@0",
				"Add@getnewaddmode1()@0@3b5998@glyphicon-plus"
				//"Modify@validateAddItemInventory(document.forms[0],'MODIFY')@1",
				//,"Modify@getnewmodifymode1()@1"
				};
		return strButtons;
	}

	public String[] getDbButtons() {
		// String[] str = { "2" };
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
		String orderBy[] = {
				"1",
				"MMS_MST.GET_ITEM_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_ITEMBRAND_ID)" };
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={//"AddOnDesk.png","UpdateOnDesk.png",
						"AddOnDesk.png","UpdateOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}

}
