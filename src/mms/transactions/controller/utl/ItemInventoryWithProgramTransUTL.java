/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransUTL.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;


import hisglobal.transactionutil.TransInterface;
import mms.MmsConfigUtil1;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransUTL.
 */
public class ItemInventoryWithProgramTransUTL extends TransInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/** The cmb val. */
	String[] cmbVal = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.transactionutil.TransInterface#setHttpSession(javax.servlet
	 * .http.HttpSession)
	 */
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	/*
	 * public void setCombo(String[] arg0) { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	// new
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.transactionutil.TransInterface#setCombo(java.lang.String[])
	 */
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = "Drug Inventory With Programme Wise";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();

		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.transactionutil.TransInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String cmb[]) {

		MmsConfigUtil1 mmscofigutil = new MmsConfigUtil1();
		StringBuffer brMainQuery = new StringBuffer(500);

		/*ResourceBundle res = ResourceBundle
				.getBundle("hisglobal.hisconfig.hisProperties");
		mms.qryHandler_mms.res = res;*/

		

			String tempQry = mms.qryHandler_mms.getQuery(2, "select.main.0")
					.replace("#", mmscofigutil.getStrExpAlertDays());

			brMainQuery.append(tempQry.replace("?",
					httpSession.getAttribute("HOSPITAL_CODE").toString()));

			if (cmb != null) {

				if (!cmb[1].equals("0"))
					// brMainQuery.replace(brMainQuery.lastIndexOf("1"),
					// brMainQuery.lastIndexOf("1") + 1, cmb[1]);

					brMainQuery.append(" AND "
							+ mms.qryHandler_mms.getQuery(2,
									"select.main.cond.2").replace("?", cmb[1]));

				if (cmb[3].equals("16")) {
					brMainQuery = new StringBuffer("");
					brMainQuery
							.append(" SELECT    c.hstnum_store_id|| '@'|| c.hstnum_item_id|| '@'|| c.hstnum_itembrand_id|| '@'|| c.hststr_batch_no");
					brMainQuery
							.append(" || '@'|| c.gnum_hospital_code|| '@'|| hstnum_stock_status_code  || '^'|| c.drug_code || '^'|| c.item_brand_name|| '^'|| c.hststr_batch_no || '^' ||  C.HSTNUM_PO_NO  || '^' ||  MMS_MST.GET_PROGRAMME_NAME(1,c.gnum_hospital_code,C.hstnum_programme_id)");
					brMainQuery
							.append(" || '^'|| split_part(c.item_inhand_dtl,'.',1)||' '||split_part(c.item_inhand_dtl,' ',2)|| '^'|| c.item_reorder_level|| '^'|| c.expiry_date");
					brMainQuery.append("|| '^'|| 1 ");
					brMainQuery
							.append("|| '^'|| mms_mst.get_reorder_flag (c.gnum_hospital_code,c.hstnum_itembrand_id,c.hstnum_item_id,c.hstnum_store_id,c.hstnum_inhand_qty,c.hststr_batch_no,1)");
					brMainQuery
							.append("|| '^'|| c.hstnum_stock_status_code   AS DATA FROM (SELECT hstnum_store_id, hstnum_item_id, hstnum_itembrand_id,hststr_batch_no,hstnum_po_no, gnum_hospital_code, hstnum_group_id,hstnum_programme_id,");
					brMainQuery
							.append("mms_mst.get_item_dtl (1,gnum_hospital_code,hstnum_itembrand_id)item_brand_name,sstnum_item_cat_no, hstnum_stock_status_code,hstnum_inhand_qty|| ' '|| mms_mst.getunitname (gnum_hospital_code,"
									+ "hstnum_inhand_qty_unitid) item_inhand_dtl,");
					brMainQuery
							.append("gnum_isvalid,mms_mst.get_reorder(gnum_hospital_code,hstnum_itembrand_id,hstnum_item_id,hstnum_store_id,1)");
					brMainQuery
							.append("|| ' '|| mms_mst.getunitname (gnum_hospital_code,hstnum_inhand_qty_unitid)item_reorder_level,");
					brMainQuery
							.append("TO_CHAR (hstdt_expiry_date, 'DD-Mon-yyyy') AS expiry_date,hstnum_inhand_qty,hstdt_expiry_date,(select hststr_cpa_code from hstt_drugbrand_mst B where A.gnum_hospital_code = B.gnum_hospital_code and A.hstnum_itembrand_id = B.hstnum_itembrand_id and A.hstnum_item_id = B.hstnum_item_id ) AS drug_code FROM hstt_drug_currstock_dtl A");
					brMainQuery
							.append(" WHERE gnum_isvalid = 1 AND hstnum_inhand_qty > 0 AND hstdt_expiry_date < TRUNC(SYSDATE) ) c");
					brMainQuery.append(" WHERE c.gnum_hospital_code = "
							+ httpSession.getAttribute("HOSPITAL_CODE")
									.toString() + "");

					if (cmb[0] != null && !cmb[0].equals("0")) {

						brMainQuery.append(" AND c.hstnum_store_id = ").append(
								cmb[0].split("\\^")[0]);

					}

				} else {
					if (!cmb[3].equals("0")) {
						if (cmb[3].equals("10")) {
							brMainQuery.append(" and "
									+ mms.qryHandler_mms.getQuery(2,
											"select.main.cond.0").replace("?",
											cmb[2]));
							brMainQuery
									.append(" and  c.hstdt_expiry_date > TRUNC(SYSDATE)");
						} else {
							brMainQuery.append(" and "
									+ mms.qryHandler_mms.getQuery(2,
											"select.main.cond.0").replace("?",
											cmb[2]));
						}
					}
					/*
					 * else { brMainQuery.append( " and " +
					 * mms.qryHandler_mms.getQuery
					 * (2,"select.main.cond.0").replace("?","10,11,12,15")); }
					 */
				}

				if (!cmb[0].equals("0"))
					brMainQuery.append(" AND "
							+ mms.qryHandler_mms.getQuery(2,
									"select.main.cond.1").replace("?", cmb[0].split("\\^")[0]));
				else
					brMainQuery.append(" AND "
							+ mms.qryHandler_mms.getQuery(2,
									"select.main.cond.1").replace("?", "0"));
			} else {

				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(2, "select.main.cond.0")
								.replace("?", "9"));

			}
		

		mmscofigutil = null;

		
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getSearchField()
	 */
	public String[] getSearchField() {
		String search_field[] = {"1","c.drug_code", "2", "C.ITEM_BRAND_NAME", "3",
				"C.HSTSTR_BATCH_NO" };
		return search_field;
	}

	/**
	 * A^B A = 0 Means Combo From Query, A = 1 Means User Defined Combo B = 0
	 * After ^ Means Select Value, B = 1 Means All, B = 2 Means Default
	 * Selected.
	 * 
	 * @return the combo header
	 */
	public String[] getComboHeader() {
		String[] strComboHeader = { "0^2", "Store Name", "0^1", "Group Name",
				"0^2", "Programme Name", "0^1", "Stock Status" };
		return strComboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String[] strColumnHeader = { "Drug Code","Drug/Item Name", "Batch No", "Po.No.",
				"Programme Name", "Qty InHand", "Re-Order Level", "Exp Date" };
		return strColumnHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] comboQuery = new String[4];
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String strHospCode = httpSession.getAttribute("HOSPITAL_CODE")
				.toString();

		comboQuery[0] = "select HSTNUM_STORE_ID||'^'||HSTNUM_PHYSTOCK_FLAG,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1  AND  GNUM_HOSPITAL_CODE ="
				+ strHospCode
				+ " AND HSTNUM_STORE_ID IN"
				+ "("
				+ "SELECT gnum_column_value "
				+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"
				+ " WHERE P.gnum_metatable_id = q.gnum_metatable_id"
				+ " AND P.gnum_hospital_code = q.gnum_hospital_code"
				+ " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"
				+ " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"
				+ " AND P.gnum_hospital_code = "
				+ strHospCode
				+ " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("
				+ strSeatId
				+ ", "
				+ strHospCode
				+ ")"
				+ ") "
				+ "  AND EXISTS "
				+ "	( "
				+ "	  SELECT 'X'  FROM HSTT_STORE_REQTYPE_MST "
				+ "	  WHERE  GNUM_ISVALID = 1"
				+ "  	  AND  SSTNUM_ITEM_CAT_NO = 10"
				+ "  	  AND GNUM_HOSPITAL_CODE = "
				+ strHospCode
				+ "  	  AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID" +
				// "  AND SSTNUM_INDENTTYPE_ID = 58" +
				" 	)" + " ORDER BY HSTSTR_STORE_NAME ";

		comboQuery[1] = "SELECT HSTNUM_GROUP_ID,HSTSTR_GROUP_NAME "
				+ "FROM HSTT_GROUP_MST WHERE GNUM_HOSPITAL_CODE = "
				+ strHospCode
				+ " AND GNUM_ISVALID = 1 AND SSTNUM_ITEM_CAT_NO = 10"
				+ " ORDER BY HSTSTR_GROUP_NAME";
		if (cmbVal != null) {
			comboQuery[2] = "SELECT A.HSTNUM_PROGRAMME_ID,HSTSTR_PROGRAMME_NAME"
					+ " FROM HSTT_STORE_PROGRAMME_MST A,HSTT_PROGRAMME_MST B  WHERE A.GNUM_HOSPITAL_CODE = "
					+ strHospCode
					+ " AND A.GNUM_ISVALID = 1 AND A.HSTNUM_PROGRAMME_ID=B.HSTNUM_PROGRAMME_ID AND hstnum_store_id = "+ cmbVal[0].split("\\^")[0]
			        +"  order by case when substring(hststr_programme_name, 1, 7) = 'General' then 0  else 2 end, hststr_programme_name";
		} else {			
			comboQuery[2] = "SELECT A.HSTNUM_PROGRAMME_ID,HSTSTR_PROGRAMME_NAME"
					+ " FROM HSTT_STORE_PROGRAMME_MST A,HSTT_PROGRAMME_MST B  WHERE A.GNUM_HOSPITAL_CODE = "+ strHospCode
					+ " AND A.GNUM_ISVALID = 1 AND A.HSTNUM_PROGRAMME_ID=B.HSTNUM_PROGRAMME_ID AND hstnum_store_id =SUBSTR('#1#',0,INSTR('#1#','^')-1) "
					+"  order by case when substring(hststr_programme_name, 1, 7) = 'General' then 0  else 2 end, hststr_programme_name";
		}

		comboQuery[3] = "SELECT HSTNUM_STOCK_STATUS_CODE, HSTSTR_STOCK_STATUS_DESC FROM SSTT_STOCK_STATUS_MST"
				+ " WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = "
				+ strHospCode
				+ " AND SSTNUM_ITEM_CAT_NO = 10 "
				+ " AND NVL(SSTNUM_DWH_TYPE_NOT_DISPLAY,'0') NOT LIKE '%,'||( select sstnum_dwh_type_id from hstt_store_mst where hstnum_store_id=SUBSTR('#1#',0,INSTR('#1#','^')-1) )||',%'"
				+ " ORDER BY HSTNUM_STOCK_STATUS_CODE";

		 

		return comboQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getViewQuery()
	 */
	public String getViewQuery() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getButtons()
	 */
	public String getButtons() {

		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String deleteQuery[] = { "" };
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.transactionutil.TransInterface#getDeleteData(java.lang.String)
	 */
	public List<String[]> getDeleteData(String chk) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String files = "../../mms/js/mms_trans.js";

		return files;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getRowStatus()
	 */
	public String[] getRowStatus() {
		/*
		 * "1"--->> Value Which we Want to Maaped 1 2 3 4 5 6 7 "7"--->> Column
		 * Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->> "Exp Within"--->>Argument You Want to Show in Footer of
		 * Template
		 */
		/*ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}*/		
		
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getEventState()
	 */
	public String getEventState() {
		String str = "chkUserDefinedFunc";
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getButtonConfiguration()
	 */
	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getUserDefinedButtons()
	 */
	public String[] getUserDefinedButtons() {
		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		String retVal = null;
		res = null;

		if (retVal.equals("1")) {

			String[] strButtons = {
					"Add@validateAddInventory(document.forms[0],'ADD')@0@3b5998@glyphicon-plus",
					"Modify@validateAddInventory(document.forms[0],'MODIFY')@1@ff5057@glyphicon-edit",
					"Drug Profile@getDrugProfilePopup();@1@4F8956@glyphicon-erase" };
			return strButtons;
		} else {
			String[] strButtons = { "Add@validateAddInventory(document.forms[0],'ADD')@0@3b5998@glyphicon-plus",
					"Modify@validateAddInventory(document.forms[0],'MODIFY')@1@ff5057@glyphicon-edit" };
			return strButtons;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getDbButtons()
	 */
	public String[] getDbButtons() {
		// TODO Auto-generated method stub
		// String[] str={"1"};
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getMinPanelButton()
	 */
	public int getMinPanelButton() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * Frames option will not work (non-Javadoc).
	 * 
	 * @return the menu option
	 * @see hisglobal.transactionutil.TransInterface#getMenuOption()
	 */

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getComboEventState()
	 */
	@Override
	public String getComboEventState() {
		return "";
	}

	// new features
	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = { "2", "C.ITEM_BRAND_NAME", "3",
				"C.HSTSTR_BATCH_NO"};
		// String orderBy[] = {};
		return orderBy;
	}

	/**
	 * this method optional
	 * 
	 * if this method is override and a list of column numbers passed (no. of
	 * values should be equal to no. of columns) if any one of the value is null
	 * or empty string then the template will take the default column width (100
	 * / no. of columns)
	 * 
	 * @return the column width
	 */
	//@Override
	/*public String[] getColumnWidth() {
		// { "Drug Name", "Batch No" ,"pono"
		// "Qty InHand","Re-Order Level","Exp Date"};
		/*String[] colWidth = {"10", "25", "10", "10", "15", "10", "10", "10" };

		return colWidth;
	}*/

}
