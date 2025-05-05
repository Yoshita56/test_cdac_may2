package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransUTL.
 * 
 * @author Balasubramaniam M Creation Date:- 14-08-2012 Modifying Date:-
 */
public class TransferApprovalTransUTL extends TransInterface {

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
		 * if(httpSession.getAttribute("USERVALUE").toString().equals("5")) { masterName = "Purchase Approval Desk"; } else {
		 */
		 		
		masterName =  "Transfer_Approval/Order";  
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
	public String getMainQuery(String cmb[]) 
	{
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		StringBuffer brMainQuery = new StringBuffer("");
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate = "";
		String strFinancialEndDate = "";
		String strId = "0", dwhFlag = "0", dwhType = "0";
		String status = "1";

		// Main Store hardcoded value.
		// String strStoreId = "99901134";

		util = new HisUtil("", "");
		try {
			strCurrentDate = util.getASDate("dd-MM-yyyy");

			strCurrentMonth = Integer.parseInt(strCurrentDate.split("\\-")[1]);

			if (strCurrentMonth >= 4) {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]);
			} else {
				CURRENT_YEAR = Integer.parseInt(strCurrentDate.split("\\-")[2]) - 1;
			}

			strFinancialStartDate = "01-Apr" + "-" + CURRENT_YEAR;

			strFinancialEndDate = "31-Mar" + "-" + (CURRENT_YEAR + 1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cmbVal = cmb;

		if (cmbVal != null && cmbVal[1] != null) 
		{
			if (!cmbVal[0].equals("0")) 
			{
				strId = cmbVal[0].split("\\^")[0];
				dwhFlag = "0";
				dwhType = "0";
			}

			status = cmbVal[2];

			if (strId == null)
				strId = "0";
			if (status == null)
				status = "0";

			// order
			if (cmbVal[1].equals("1")) {
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
						.append(" WHERE GNUM_ISVALID = 1  AND GNUM_HOSPITAL_CODE = " + strHospCode);
				
				if(status.equals("0"))
				{
					//Transfer In-Process
					brMainQuery.append(" AND GNUM_STATUS = 0 ");
				}
				else
				{
					if(status.equals("40"))
					{
						//Ack In-Process
						brMainQuery.append(" AND GNUM_STATUS IN (40,45) ");
					}
					else
					{
						//Closed
						brMainQuery.append(" AND GNUM_STATUS = 50 ");
						brMainQuery.append("AND HSTDT_ORDER_DATE >= TRUNC(SYSDATE - 90) AND HSTDT_ORDER_DATE < TRUNC(SYSDATE) + 1");	
					}
				}				
				brMainQuery.append(" AND hstnum_order_store_id = " + strId)
						   .append(" ) C ").append(" WHERE C.gnum_isvalid = 1 ");
			}

			// shortage
			if (cmbVal[1].equals("3")) {

				brMainQuery
						.append(" SELECT HSTNUM_STORE_ID||'@'||HSTNUM_REQUEST_NO||'@'||HSTNUM_SLNO||'@'||GNUM_HOSPITAL_CODE || '@' || GNUM_STATUS ||'^'|| ")
						.append(" STR_NAME||'^'||HSTNUM_REQUEST_NO||'^'||REQ_DATE||'^'||DRUGNAME||'^'||SANC_ORDER_QTY ||'^'||TRANS_ACK_QTY")
						.append(" AS DATA ")
						.append(" FROM ")
						.append("  ( ")
						.append(" SELECT HSTNUM_STORE_ID, HSTNUM_SLNO, GNUM_HOSPITAL_CODE, ")
						.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS STR_NAME, ")
						.append(" HSTNUM_REQUEST_NO, TO_CHAR(HSTDT_REQUEST_DATE,'DD-Mon-YYYY') AS REQ_DATE, ")
						.append(" MMS_MST.GET_ITEM_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS DRUGNAME, ")
						.append(" NVL(HSTNUM_SANCTION_QTY,0) || '/' || NVL(HSTNUM_APPROVED_QTY,0) || ' ' || MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_REQ_QTY_UNITID) AS SANC_ORDER_QTY, ")
						.append(" GNUM_ISVALID , GNUM_STATUS , HSTDT_FINANCIAL_START_DATE, HSTDT_FINANCIAL_END_DATE ,")
						.append("NVL (HSTNUM_TRANSFER_QTY,0) || '/' || NVL(HSTNUM_ACK_QTY,0) ||' '|| mms_mst.getunitname (gnum_hospital_code,hstnum_req_qty_unitid) AS TRANS_ACK_QTY ")
						.append(" FROM HSTT_TRANSFER_SHORT_REQ_DTL ")
						.append(" WHERE GNUM_ISVALID = 1 ")
						.append(" AND GNUM_HOSPITAL_CODE = " + strHospCode);
					if(status.equals("0")){
					brMainQuery.append("AND GNUM_STATUS IN (40,45)");	
					}else{
						if(status.equals("50"))
							//brMainQuery.append("AND GNUM_STATUS = 50 AND HSTDT_REQUEST_DATE >= TRUNC(SYSDATE-90) AND HSTDT_REQUEST_DATE < TRUNC(SYSDATE) + 1");	
							brMainQuery.append("AND GNUM_STATUS = 50  AND HSTDT_REQUEST_DATE < TRUNC(SYSDATE) + 1");	
					}



				brMainQuery.append(" ) C ")
						.append(" WHERE C.gnum_isvalid = 1 ");
			}

			// excess
			if (cmbVal[1].equals("2")) {
				brMainQuery
						.append(" SELECT HSTNUM_STORE_ID||'@'||HSTNUM_REQUEST_NO||'@'||HSTNUM_SLNO||'@'||GNUM_HOSPITAL_CODE||'$'||APP_QTY||'$' || STR_DTL || '^'||STR_NAME||'^'|| ")
						.append(" HSTNUM_REQUEST_NO||'^'||REQ_DATE||'^'||DRUGNAME||'^'||HSTSTR_BATCH_NO||'^'||exp_date||'^'||REQ_QTY||'^'||ORDER_QTY||'^'||APP_QTY||'^'||STS AS DATA ")
						.append(" FROM ( SELECT HSTNUM_STORE_ID,  HSTNUM_SLNO, GNUM_HOSPITAL_CODE, ")
						.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS STR_NAME, ")
						.append(" HSTNUM_REQUEST_NO, TO_CHAR(HSTDT_REQUEST_DATE,'DD-Mon-YYYY') AS REQ_DATE, ")
						.append(" MMS_MST.GET_ITEM_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS DRUGNAME, ")
						.append(" NVL(HSTNUM_REQ_QTY,0) || ' ' || MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_REQ_QTY_UNITID) AS REQ_QTY, ")
						.append(" NVL(HSTNUM_APPROVED_QTY,0) || ' ' || MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_APPQTY_UNITID) AS ORDER_QTY, ")
						.append(" NVL(HSTNUM_APPROVED_QTY,0) AS APP_QTY,NVL(HSTNUM_IS_FORCE_CLOSE,0) AS STS , GNUM_ISVALID , GNUM_STATUS , ")
						.append(" HSTDT_FINANCIAL_START_DATE , HSTDT_FINANCIAL_END_DATE  ,HSTSTR_BATCH_NO, ")
						.append(" ( ")
						.append(" SELECT NVL(HSTNUM_PARENT_STORE_ID,0) || '|0|' || HSTSTR_STORE_NAME ")
						.append(" FROM HSTT_STORE_MST ")
						.append(" WHERE GNUM_HOSPITAL_CODE = " + strHospCode)
						.append(" AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ")
						.append(" ) AS STR_DTL ,TO_CHAR (hstdt_expiry_date, 'DD-Mon-YYYY') AS exp_date ")
						.append(" FROM HSTT_TRANSFER_EXCESS_REQ_DTL A ")
						.append(" WHERE GNUM_ISVALID = 1 ")
						.append(" AND GNUM_HOSPITAL_CODE =  " + strHospCode);

				if(status.equals("0")){
					brMainQuery.append(" AND GNUM_STATUS IN (40,45)");	
					}else{
						if(status.equals("50"))
							brMainQuery.append("AND GNUM_STATUS = 50 AND HSTDT_REQUEST_DATE >= TRUNC(SYSDATE-90)AND HSTDT_REQUEST_DATE < TRUNC(SYSDATE) + 1");	
					}

				brMainQuery.append(" ) C ")
						.append(" WHERE C.gnum_isvalid = 1 ");
			}
		} else {
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
			.append(" WHERE GNUM_ISVALID = 1  AND GNUM_HOSPITAL_CODE = " + strHospCode);
			brMainQuery.append(" AND hstnum_order_store_id = " + strId)
			   .append(" ) C ").append(" WHERE C.gnum_isvalid = 1 ");
		}

		 System.out.println("Transfer Order Generation:::::"+brMainQuery.toString());

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
				search_field[1] = "DrugName";
				search_field[2] = "5";
				search_field[3] = "Demand Store";
				search_field[4] = "6";
				search_field[5] = "TRANS_STORE";

			} else {

				// request type = demand
				search_field = new String[4];

				search_field[0] = "1";
				search_field[1] = "STR_NAME";
				search_field[2] = "4";
				search_field[3] = "DrugName";
			}

		} else {

			search_field = new String[6];

			search_field[0] = "3";
			search_field[1] = "DrugName";
			search_field[2] = "5";
			search_field[3] = "Demand Store";
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

		String[] strComboHeader = new String[6];

		strComboHeader[0] = "0^2";
		strComboHeader[1] = "Store Name";
		strComboHeader[2] = "1";
		strComboHeader[3] = "Request Type";
		strComboHeader[4] = "1";
		strComboHeader[5] = "Status";

		return strComboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] strColumnHeader = null;

		if (cmbVal != null && cmbVal[1] != null) {

			// Order
			if (cmbVal[1].equals("1")) {

				strColumnHeader = new String[7];

				strColumnHeader[0] = "Order No";
				strColumnHeader[1] = "Order Date";
				strColumnHeader[2] = "Item Name";
				strColumnHeader[3] = "Batch";
				strColumnHeader[4] = "Order/Transfer Qty";
				strColumnHeader[5] = "Demand Store";
				strColumnHeader[6] = "Transferring Store";

				// Transfer excess
			} 
			else if (cmbVal[1].equals("2")) 
			{

				strColumnHeader = new String[8];

				strColumnHeader[0] = "Store Name";
				strColumnHeader[1] = "Request No";
				strColumnHeader[2] = "Request Date"; 
				strColumnHeader[3] = "Item";
				strColumnHeader[4] = "Batch ";
				strColumnHeader[5] = "Expiry ";
				strColumnHeader[6] = "Sanc Qty";
				strColumnHeader[7] = "Transfer Qty";

				// Demand
			} else {

				strColumnHeader = new String[6];

				strColumnHeader[0] = "Store_Name";
				strColumnHeader[1] = "Request_no";
				strColumnHeader[2] = "Request_date"; 
				strColumnHeader[3] = "Drug_Name";
				strColumnHeader[4] = "Sanctioned_qty / Order_qty";
				strColumnHeader[5] = "Transfer/Ack_Qty";

			}

		} else {

			strColumnHeader = new String[7];

			strColumnHeader[0] = "Order_no";
			strColumnHeader[1] = "Order_date";
			strColumnHeader[2] = "Item_Name";
			strColumnHeader[3] = "Batch_No.";
			strColumnHeader[4] = "Order_qty";
			strColumnHeader[5] = "Demand_Store";
			strColumnHeader[6] = "Transferring_store";

		}

		return strColumnHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] strComboQry = new String[3];
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		strComboQry[0] = "SELECT HSTNUM_STORE_ID||'^0^0^0', hststr_store_name FROM hstt_store_mst a  WHERE gnum_isvalid = 1  "
				+ "AND gnum_hospital_code = "
				+ hosCode
				+ " AND A.HSTNUM_STORE_ID IN (  "
				  + " SELECT GNUM_COLUMN_VALUE      "
				  + " FROM GBLT_ROLE_SEAT_TABLE_DTL P     "
				  + " WHERE P.gnum_metatable_id = 117 	   "
				  + " AND P.gnum_hospital_code = A.gnum_hospital_code     "
				  + " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+ httpSession.getAttribute("SEATID").toString() + ", " + httpSession.getAttribute("HOSPITAL_CODE").toString() + ") from dual ) "
				  + " )ORDER BY hststr_store_name";

		strComboQry[1] = "1^Order"+"#2^Excess#3^Shortage";

		if (cmbVal != null) {

			if (cmbVal[1] != null && cmbVal[1].equals("1")) {

				// request type = order
				strComboQry[2] = "0^In_Process#40^Ack_In_Process#50^Closed";

			} else {

				// request type = transfer / demand
				strComboQry[2] = "0^Active#50^Closed";

			}

		} else {

			// request type = transfer / demand
			strComboQry[2] = "0^Active#50^Closed";
		}

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
		String files = "../../mms/js/TransferApproval.js";
		return files;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mms.hisglobal.transactionutil.TransInterface#getRowStatus()
	 */
	public String[] getRowStatus() {

		String[] status = null;

		if (cmbVal != null) {

			// request type = Transfer (2) and status = Processed (50)
			if ((cmbVal[1] != null && cmbVal[1].equals("2"))
					&& (cmbVal[2] != null && cmbVal[2].equals("50"))) {

				status = new String[4];

				status[0] = "1";
				status[1] = "9";
				status[2] = "lightblue";
				status[3] = "Force_Fully_Closed";

			}
		}

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

		if (cmbVal != null && cmbVal[1] != null) {

			if (cmbVal[1].equals("1")) {

				str = new String[4];

				str[0] = "Generate@buttonClick('ORDER_GENERATE')@0@Generate";
				str[1] = "Modify@buttonClick('ORDER_MODIFY')@1@Modify";
				str[2] = "Cancel@buttonClick('ORDER_CANCEL')@1@Cancel";
				str[3] = "View@buttonClickView('ORDER_VIEW')@1@View";

			} else if (cmbVal[1].equals("2")) {

				str = new String[2];

				str[0] = "Reject@buttonClick('TRANSFER_REJECT')@1@Reject";
				// str[1] =
				// "Force_Fully_Close@buttonClick('TRANSFER_FFCLOSE')@1";
				str[1] = "View@buttonClickView('TRANSFER_VIEW')@1@View";

			} else {
				str = new String[2];

				str[0] = "Reject@buttonClick('DEMAND_REJECT')@1@Reject";
				str[1] = "View@buttonClickView('DEMAND_VIEW')@1@View";
			}

		} else {

			str = new String[4];

			str[0] = "Generate@buttonClick('ORDER_GENERATE')@0@Generate";
			str[1] = "Modify@buttonClick('ORDER_MODIFY')@1@Modify";
			str[2] = "Cancel@buttonClick('ORDER_CANCEL')@1@Cancel";
			str[3] = "View@buttonClickView('ORDER_VIEW')@1@View";

		}

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

		if (cmbVal != null) 
		{

			if (cmbVal[1] != null && cmbVal[1].equals("1")) 
			{

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

			} 
			else 
			{

				// request type = demand
				orderBy = new String[6];

				orderBy[0] = "3";
				orderBy[1] = "TO_DATE(REQ_DATE)";
				orderBy[2] = "1";
				orderBy[3] = "STR_NAME";
				orderBy[4] = "4";
				orderBy[5] = "DRUGNAME";
			}

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
