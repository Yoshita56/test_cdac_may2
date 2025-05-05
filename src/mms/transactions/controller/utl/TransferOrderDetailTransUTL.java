package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.transactionutil.TransInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferOrderDetailTransUTL.
 * 
 * @author Balasubramaniam M Creation Date:- 14-08-2012 Modifying Date:-
 */
public class TransferOrderDetailTransUTL extends TransInterface {

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
	 * mms.hisglobal.transactionutil.TransInterface#setHttpSession(javax.servlet
	 * .http.HttpSession)
	 */
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mms.hisglobal.transactionutil.TransInterface#setCombo(java.lang.String[])
	 */
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = "";
		/*
		 * if(httpSession.getAttribute("USERVALUE").toString().equals("5")) {
		 * masterName = "Purchase Approval Desk"; } else {
		 */

		masterName = HisLanguageProperties.getValue(httpSession,
				"label.common.Transfer_Approval/Order");
		// }

		return masterName;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {
		return 12;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mms.hisglobal.transactionutil.TransInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String cmb[]) {
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		StringBuffer brMainQuery = new StringBuffer("");

		String strId = "0";
		String status = "1";

		// Main Store hardcoded value.
		// String strStoreId = "99901134";

		try {

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cmbVal = cmb;

		if (cmbVal != null) {
			if (!cmbVal[0].equals("0")) {
				strId = cmbVal[0].split("\\^")[0];
			 
			}

			status = cmbVal[1];

			if (strId == null)
				strId = "0";
			if (status == null)
				status = "0";

			// order

			brMainQuery
					.append(" SELECT HSTNUM_ORDER_NO||'@'||HSTNUM_SLNO||'@'||DRUGNAME||'@'||DEMAND_STORE||'@'||TRANS_STORE||'@'||ORDER_DATE||'@'||GNUM_HOSPITAL_CODE||'^'||HSTNUM_ORDER_NO||'^'||ORDER_DATE||'^'||DRUGNAME||'^'|| ")
					.append(" HSTSTR_BATCH_NO||'^'||ORDER_QTY||'^'||DEMAND_STORE||'^'||TRANS_STORE AS DATA ")
					.append(" FROM ( SELECT HSTNUM_ORDER_NO, HSTNUM_SLNO, GNUM_HOSPITAL_CODE, TO_CHAR(HSTDT_ORDER_DATE,'DD-Mon-YYYY') AS ORDER_DATE, ")
					.append(" MMS_MST.GET_ITEM_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS DRUGNAME,  HSTNUM_ORDER_QTY || '/' || NVL(HSTNUM_TRANSFER_QTY,0)  || ' ' || ")
					.append(" MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_ORDERQTY_UNITID) AS ORDER_QTY, ")
					.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_DEMAND_STORE_ID) AS DEMAND_STORE, ")
					.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TRANS_STORE_ID) AS TRANS_STORE , GNUM_STATUS , ")
					.append(" HSTDT_FINANCIAL_START_DATE , HSTDT_FINANCIAL_END_DATE , GNUM_ISVALID,HSTNUM_ORDER_STORE_ID ,HSTSTR_BATCH_NO ")
					.append(" FROM HSTT_TRANSFER_ORDER_DTL X ")
					.append(" WHERE GNUM_ISVALID = 1  AND GNUM_HOSPITAL_CODE = "
							+ strHospCode);

			if (status.equals("0")) {
				// Transfer In-Process
				brMainQuery.append(" AND GNUM_STATUS = 0 ");
			} else {
				if (status.equals("40")) {
					// Ack In-Process
					brMainQuery.append(" AND GNUM_STATUS IN (40,45) ");
				} else {
					// Closed
					brMainQuery.append(" AND GNUM_STATUS = 50 ");
					brMainQuery
							.append("AND HSTDT_ORDER_DATE >= TRUNC(SYSDATE - 90) AND HSTDT_ORDER_DATE < TRUNC(SYSDATE) + 1");
				}
			}
			brMainQuery.append(" AND hstnum_order_store_id = " + strId)
					.append(" ) C ").append(" WHERE C.gnum_isvalid = 1 ");

		} else {
			brMainQuery.append(" SELECT '' AS DATA FROM DUAL WHERE 1 = 2 ");
		}

		// System.out.println("Transfer Order Generation:::::"+brMainQuery.toString());

		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getSearchField()
	 */
	public String[] getSearchField() {
		String search_field[] = null;

		if (cmbVal != null) {

			if (cmbVal[1] != null && cmbVal[1].equals("1")) {

				// request type = order
				search_field = new String[6];

				search_field[0] = "3";
				search_field[1] = HisLanguageProperties.getValue(httpSession,
						"label.common.DrugName");
				search_field[2] = "5";
				search_field[3] = HisLanguageProperties.getValue(httpSession,
						"label.common.Demand_Store");
				search_field[4] = "6";
				search_field[5] = "TRANS_STORE";

			} else {

				// request type = demand
				search_field = new String[4];

				search_field[0] = "1";
				search_field[1] = "STR_NAME";
				search_field[2] = "4";
				search_field[3] = HisLanguageProperties.getValue(httpSession,
						"label.common.DrugName");
			}

		} else {

			search_field = new String[6];

			search_field[0] = "3";
			search_field[1] = HisLanguageProperties.getValue(httpSession,
					"label.common.DrugName");
			search_field[2] = "5";
			search_field[3] = HisLanguageProperties.getValue(httpSession,
					"label.common.Demand_Store");
			search_field[4] = "6";
			search_field[5] = "TRANS_STORE";

		}

		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query, 1 Means User Defined Combo,0 After ^ Means
	 * Select Value, 1 Means All,2 Means Default Selected.
	 * 
	 * @return the combo header
	 */
	public String[] getComboHeader() {

		String[] strComboHeader = new String[4];

		strComboHeader[0] = "0^2";
		strComboHeader[1] = HisLanguageProperties.getValue(httpSession,
				"label.common.Store_Name");
		strComboHeader[2] = "1";
		strComboHeader[3] = HisLanguageProperties.getValue(httpSession,
				"label.common.Status");

		return strComboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] strColumnHeader = null;

		strColumnHeader = new String[7];

		strColumnHeader[0] = HisLanguageProperties.getValue(httpSession,
				"label.common.Order_no");
		strColumnHeader[1] = HisLanguageProperties.getValue(httpSession,
				"label.common.Order_date");
		strColumnHeader[2] = HisLanguageProperties.getValue(httpSession,
				"label.common.Item_Name");
		strColumnHeader[3] = HisLanguageProperties.getValue(httpSession,
				"label.common.Batch_No.");
		strColumnHeader[4] = HisLanguageProperties.getValue(httpSession,
				"label.common.Order/Transfer_qty");
		strColumnHeader[5] = HisLanguageProperties.getValue(httpSession,
				"label.common.Demand_Store");
		strColumnHeader[6] = HisLanguageProperties.getValue(httpSession,
				"label.common.Transferring_store");

		return strColumnHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] strComboQry = new String[2];
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		strComboQry[0] = "SELECT HSTNUM_STORE_ID||'^'||HSTNUM_IS_DWH||'^'||SSTNUM_DWH_TYPE_ID||'^'||HSTNUM_PHYSTOCK_FLAG, hststr_store_name FROM hstt_store_mst a  WHERE gnum_isvalid = 1 AND SSTNUM_DWH_TYPE_ID IN (10,13,14,15,12,16,17,20,21,19,11,24 ) "
				+ "AND gnum_hospital_code = "
				+ hosCode
				+ " AND A.HSTNUM_STORE_ID IN (  "
				  + " SELECT GNUM_COLUMN_VALUE      "
				  + " FROM GBLT_ROLE_SEAT_TABLE_DTL P     "
				  + " WHERE P.gnum_metatable_id = 101 	   "
				  + " AND P.gnum_hospital_code = A.gnum_hospital_code     "
				  + " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+ httpSession.getAttribute("SEATID").toString() + ", " + httpSession.getAttribute("HOSPITAL_CODE").toString() + ") from dual ) "
				  + " )ORDER BY hststr_store_name";
		// request type = order
		strComboQry[1] = "0^"
				+ HisLanguageProperties.getValue(httpSession,
						"label.common.Transfer_In_Process")
				+ "#40^"
				+ HisLanguageProperties.getValue(httpSession,
						"label.common.Ack_In_Process")
				+ "#50^"
				+ HisLanguageProperties.getValue(httpSession,
						"label.common.Closed");

		return strComboQry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getViewQuery()
	 */
	public String getViewQuery() {
		return "";
	}

	/*
	 * public String getButtons() { //String strButtons =
	 * "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png' style='cursor:pointer' border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>"
	 * ; return ""; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mms.hisglobal.transactionutil.TransInterface#getDeleteData(java.lang.String)
	 */
	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String files = "../../mms/js/TransferOrderDetail.js";
		return files;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getRowStatus()
	 */
	public String[] getRowStatus() {

		String[] status = null;

		return status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getEventState()
	 */
	public String getEventState() {
		String str = "";
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getButtonConfiguration()
	 */
	public String getButtonConfiguration() {
		return "left";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getUserDefinedButtons()
	 */
	public String[] getUserDefinedButtons() {
		String[] str = null;

		str = new String[4];

		str[0] = HisLanguageProperties.getValue(httpSession,
				"label.common.Generate")
				+ "@buttonClick('ORDER_GENERATE')@0@Generate";
		str[1] = HisLanguageProperties.getValue(httpSession,
				"label.common.Modify")
				+ "@buttonClick('ORDER_MODIFY')@1@Modify";
		str[2] = HisLanguageProperties.getValue(httpSession,
				"label.common.Cancel")
				+ "@buttonClick('ORDER_CANCEL')@1@Cancel";
		str[3] = HisLanguageProperties.getValue(httpSession,
				"label.common.View") + "@buttonClickView('ORDER_VIEW')@1@View";

		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getDbButtons()
	 */
	public String[] getDbButtons() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getMinPanelButton()
	 */
	public int getMinPanelButton() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getMenuOption()
	 */
	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getComboEventState()
	 */
	public String getComboEventState() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = null;

		if (cmbVal != null) {

		 

				// request type = order
				orderBy = new String[10];

				orderBy[0] = "1";
				orderBy[1] = "HSTNUM_ORDER_NO";
				orderBy[2] = "2";
				orderBy[3] = "TO_DATE(ORDER_DATE)";
				orderBy[4] = "3";
				orderBy[5] = "DRUGNAME";
				orderBy[6] = "5";
				orderBy[7] = "DEMAND_STORE";
				orderBy[8] = "6";
				orderBy[9] = "TRANS_STORE";

			

		} else {

			// request type = order
			orderBy = new String[8];

			orderBy[0] = "2";
			orderBy[1] = "TO_DATE(ORDER_DATE)";
			orderBy[2] = "3";
			orderBy[3] = "DRUGNAME";
			orderBy[4] = "5";
			orderBy[5] = "DEMAND_STORE";
			orderBy[6] = "6";
			orderBy[7] = "TRANS_STORE";

		}

		return orderBy;
	}

}
