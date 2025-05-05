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

public class ItemInventoryTransUTL extends TransInterface {

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
    
	
	public String getMainQuery(String cmb[]) 
	{
		/* Variable Declaration */
		String strHospitalCode = null;		
		StringBuffer brMainQuery = null;		
		/* Getting Hospital Code From Session */
		strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		brMainQuery = new StringBuffer();
		
		brMainQuery.append(" SELECT hstnum_store_id ");
		brMainQuery.append(" || '@' || hstnum_item_id ");
		brMainQuery.append(" || '@' || hstnum_itembrand_id ");
		brMainQuery.append(" || '@' || gnum_hospital_code ");
		brMainQuery.append(" || '@' || hstnum_stock_status_code ");
		brMainQuery.append(" || '^' || mms_mst.Get_item_dtl (1, 100, hstnum_itembrand_id) ");
		brMainQuery.append(" || '^' || Upper(hststr_batch_no) ");
		brMainQuery.append(" || '^' || Round(hstnum_inhand_qty) ");
		brMainQuery.append(" || ' ' || mms_mst.Getunitname (100, hstnum_inhand_qty_unitid) ");
		brMainQuery.append(" || '^' || Round((SELECT Nvl(E.hstnum_min_value, 0) ");
		brMainQuery.append(" FROM   hstt_itembrand_mst E ");
		brMainQuery.append(" WHERE  E.gnum_isvalid = 1 ");
		brMainQuery.append(" AND E.hstnum_itembrand_id = A.hstnum_itembrand_id ");
		brMainQuery.append(" AND E.hstnum_item_id = A.hstnum_item_id LIMIT  1)) ");
		brMainQuery.append(" || ' ' || mms_mst.Getunitname (100, A.hstnum_inhand_qty_unitid) ");
		brMainQuery.append(" || '^' || Nvl(To_char(A.hstdt_expiry_date, 'DD-Mon-yyyy'), '-') ");
		brMainQuery.append(" || '^' || CASE WHEN (SELECT Nvl(E.hstnum_min_value, 0) ");
		brMainQuery.append("           FROM   hstt_itembrand_mst E ");
		brMainQuery.append("           WHERE  E.gnum_isvalid = 1 ");
		brMainQuery.append("           AND E.hstnum_itembrand_id = A.hstnum_itembrand_id ");
		brMainQuery.append("           AND E.hstnum_item_id = A.hstnum_item_id  ");
		brMainQuery.append("           LIMIT  1) > A.hstnum_inhand_qty    THEN '1'  ");  
		brMainQuery.append("           ELSE '0'  ");
		brMainQuery.append("           END  "); 
		brMainQuery.append(" || '^'||  CASE WHEN ( A.hstdt_expiry_date IS NOT NULL AND A.hstdt_expiry_date < sysdate ) THEN '1' ");
		brMainQuery.append("           WHEN ( A.hstdt_expiry_date IS NULL ) THEN '0' ");
		brMainQuery.append("           ELSE '0'  ");
		brMainQuery.append("           END ");
		brMainQuery.append(" AS DATA ");
		brMainQuery.append(" FROM   hstt_item_currstock_dtl A ");
		brMainQuery.append(" WHERE  A.gnum_isvalid = 1 ");
		brMainQuery.append(" AND A.hstdt_expiry_date > sysdate ");
		brMainQuery.append(" AND A.hstnum_inhand_qty > 0 ");
		brMainQuery.append(" AND A.gnum_hospital_code = "+strHospitalCode+"  ");
		if (cmb != null) 
		{ 			
			//Pass Store Id
			if (!cmb[0].equals("0")) 
			{
				brMainQuery.append(" AND A.HSTNUM_STORE_ID = ");
				brMainQuery.append(cmb[0]);
			}	
			if (!cmb[1].equals("0")) 
			{
				brMainQuery.append(" AND A.sstnum_item_cat_no = ");
				brMainQuery.append(cmb[1]);
			}
			if (!cmb[2].equals("0")) 
			{
				brMainQuery.append(" AND A.hstnum_group_id = ");
				brMainQuery.append(cmb[2]);
			}
			if (!cmb[3].equals("0")) 
			{
				brMainQuery.append(" AND A.hstnum_stock_status_code = ");
				brMainQuery.append(cmb[3]);
			}
		}
		else
		{
			brMainQuery.append(" AND A.hstnum_stock_status_code = 0 "); 
		}		
		
		 
		
		
		System.out.println("ItemInventoryTransUTL----"+brMainQuery.toString());
		return brMainQuery.toString();

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
		String[] strComboHeader = { "0^2", "Store Name", "0^0",
				"Item Category ", "0^1", "Group Name", "0^2", "Item Status" };
		return strComboHeader;
	}

	public String[] getColumnHeader() {
		String[] strColumnHeader = { "Item Name","Batch","Stock Qty" };
		return strColumnHeader;
	}

	public String[] getComboQuery() {

		//System.out.println("Under Process");
		
			
		String[] comboQuery = new String[4];
		String strHospitalCode = " "
				+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " ";

		comboQuery[0] = "SELECT HSTNUM_STORE_ID, HSTSTR_STORE_NAME  "+
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
        /*
		comboQuery[1] = "SELECT   MMS_MST.GET_ITEMCATEGORY_DTLS (100, "
				+ "SSTNUM_ITEM_CAT_NO), "
				+ "MMS_MST.GET_ITEMCAT_DTL (1, "
				+ "100, "
				+ "SSTNUM_ITEM_CAT_NO "
				+ ") AS CATNAME "
				+ "FROM HSTT_STORE_CATEGORY_MST A "
				+ "WHERE GNUM_ISVALID = 1 "
				+ "AND HSTNUM_STORE_ID = #1# "
				+ "AND SSTNUM_ITEM_CAT_NO <> 10 AND SSTNUM_ITEM_CAT_NO NOT in (21)   and SSTNUM_ITEM_CAT_NO IN (select SSTNUM_ITEM_CAT_NO from sstt_item_category_mst where gnum_hospital_code = 100 and gnum_isvalid=1) " // SSTNUM_ITEM_CAT_NO is 10
													
				+ "AND GNUM_HOSPITAL_CODE = "+ strHospitalCode				
				+ "ORDER BY CATNAME";
				*/
		
		 comboQuery[1] =  "select DISTINCT SSTNUM_ITEM_CAT_NO,INITCAP(MMS_MST.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO))CAT_NAME "
  		       + "from HSTT_STORE_CATEGORY_MST "			   
  		       + " where GNUM_ISVALID =1 AND  sstnum_item_cat_no !=10 " + 
  		       //+ " AND SSTNUM_ITEM_CAT_NO ! = 10" +
  		       "  AND HSTNUM_STORE_ID IN ( "+ 
				  "  SELECT GNUM_COLUMN_VALUE  "+    
				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
				  " WHERE P.gnum_metatable_id = 117 "+ 	      				
				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
				  " )ORDER BY CAT_NAME";
		
		System.out.println("comboQuery[2]----------->"+comboQuery[0]);
		
					
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

		comboQuery[3] = "SELECT HSTNUM_STOCK_STATUS_CODE, HSTSTR_STOCK_STATUS_DESC FROM SSTT_STOCK_STATUS_MST"
				+ " WHERE GNUM_ISVALID = 1 AND HSTNUM_STOCK_STATUS_CODE = 10 AND GNUM_HOSPITAL_CODE = "
				+ Config.SUPER_USER_HOSPITAL_CODE
				+ " ORDER BY HSTNUM_STOCK_STATUS_CODE";
		//System.out.println("comboQuery==========>>  "+comboQuery[1]);
		return comboQuery;
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
		String files = "../../mms/js/mms_trans.js";
		return files;

	}

	public String[] getRowStatus() {
	/*	MmsConfigUtil mmscofigutil = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
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
		sbNote.append(strNote);*/

		//String[] status = { strExpAlertDays, "2", "Blue", sbNote.toString() ,"1","3","#F4C7CE", "Expired"};
		String[] status = {"0","5","#7D786C","Quantity < Re-Oreder Level"};
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
