package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.transactionutil.TransInterface;

/**
 * The Class TransferRequestTransUTL.
 */
public class TransferRequestTransUTL extends TransInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The http session. */
	HttpSession httpSession = null;

	/** The cmb val. */
	String[] cmbVal = null;

	@Override
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	@Override
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	@Override
	public String getMasterName() {
		String masterName = "";
		/*
		 * if(httpSession.getAttribute("USERVALUE").toString().equals("5")) { masterName = "Purchase Approval Desk"; } else {
		 */
		 		
		masterName =  "Transfer Request For Excess";  
		// }

		return masterName;
	}

	@Override
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	@Override
	public String getMainQuery(String cmb[]) {

		StringBuffer brMainQuery = new StringBuffer(1000);
		String hospCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String strId = "0";
		String strStatus = "0";
		if (cmb != null) 
		{
			strId = cmb[0].split("\\^")[0];
			strStatus = cmb[1];
		}
		brMainQuery.append("SELECT C.HSTNUM_REQUEST_NO||'@'|| C.MODIFY_CANCEL_FLAG ||'@'||C.HSTNUM_SLNO||'^'||C.HSTNUM_REQUEST_NO||'^'||");
		brMainQuery.append("C.REQ_DATE|| '^'|| C.ITEM_NAME || '^'|| C.HSTSTR_BATCH_NO || '^'|| C.EXP_DATE || '^'||");
		brMainQuery.append("C.REQ_SEC_QTY || ' ' || C.UNIT_NAME || '^'||");
		brMainQuery.append("C.TRANSFER_APP_QTY|| ' ' || C.UNIT_NAME ");
		if (strStatus.equals("0")) 
		{
			brMainQuery.append("|| '^'|| C.STS");
		}		
		brMainQuery.append(" || '^' || C.MODIFY_CANCEL_FLAG || '^' || FORCE_CLOSE AS DATA FROM ( "		
				+ "SELECT HSTNUM_REQUEST_NO,HSTNUM_SLNO,TO_CHAR(HSTDT_REQUEST_DATE,'DD-Mon-YYYY') AS REQ_DATE,"
				+ "MMS_MST.GET_ITEM_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) AS ITEM_NAME,HSTSTR_BATCH_NO,TO_CHAR (HSTDT_EXPIRY_DATE, 'Mon/YYYY') AS EXP_DATE,"
				+ "NVL(HSTNUM_REQ_QTY,0) || '/' || NVL(HSTNUM_SANCTION_QTY,0) AS REQ_SEC_QTY,"
				+ "NVL(HSTNUM_APPROVED_QTY,0) || '/' || NVL(HSTNUM_TRANSFER_QTY,0) AS TRANSFER_APP_QTY,"
				+ "DECODE(GNUM_STATUS,0,1,DECODE(GNUM_STATUS,40,DECODE(HSTDT_LST_APPROVAL_DATE,NULL,1,0),0)) AS MODIFY_CANCEL_FLAG,"
				+ "NVL(HSTNUM_IS_FORCE_CLOSE,0) AS FORCE_CLOSE, "
				+ "MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_REQ_QTY_UNITID) AS UNIT_NAME, "
				+ "CASE "
				+ "WHEN (GNUM_STATUS >= 0 AND GNUM_STATUS < 40) THEN 'Approval In-Process' "
				+ "WHEN (GNUM_STATUS = 45 AND HSTNUM_TOT_PENDING_ORDER > 0) THEN 'Transfer In-Process' "
				+ "WHEN (GNUM_STATUS IN (40,45)) THEN 'Order In-Process' "				
				+ "ELSE '--' "
				+ "END AS STS ,gnum_isvalid AS is_valid "
				+ "FROM HSTT_TRANSFER_EXCESS_REQ_DTL " 
				+ "WHERE GNUM_ISVALID = 1 "
				+ "AND GNUM_HOSPITAL_CODE = " + hospCode+" ");
		
		if (strStatus.equals("0")) {
			brMainQuery.append("AND GNUM_STATUS NOT IN (50,99) ");
		}else {
			// Approval In-Process
			if (strStatus.equals("1")) {
				brMainQuery.append("AND GNUM_STATUS >= 0 AND GNUM_STATUS < 40 ");
			}else{
				// ORDER IN-PROCESS
				if (strStatus.equals("2")) {
					brMainQuery.append("AND GNUM_STATUS IN (40,45) ");
				}else{
					// TRANSFER IN-PROCESS
					if (strStatus.equals("3")) {
						brMainQuery.append(" AND GNUM_STATUS = 45 AND HSTNUM_TOT_PENDING_ORDER > 0 ");
					}else {
						// REJECTED [LAST 3 MONTHS, COLOR CHANGES IF FORCEFULLY FLAG = 1]
						if (strStatus.equals("4")) {
							brMainQuery.append(" AND GNUM_STATUS = 99 AND HSTDT_LST_APPROVAL_DATE >= TRUNC(SYSDATE) - 90 AND HSTDT_LST_APPROVAL_DATE < TRUNC(SYSDATE) + 1 ");
						}else{
							//--CLOSED [LAST 3 MONTHS, COLOR CHANGES IF FORCEFULLY FLAG = 1]								
								brMainQuery.append(" AND GNUM_STATUS = 50 AND HSTDT_LST_APPROVAL_DATE >= TRUNC(SYSDATE) - 90 AND HSTDT_LST_APPROVAL_DATE < TRUNC(SYSDATE) + 1 ");
						}
					}
				}
			}
		}
		brMainQuery.append(" AND HSTNUM_STORE_ID  = " + strId + " )");
		brMainQuery.append("  C ");
		brMainQuery.append(" WHERE IS_VALID = 1 ");
		//System.out.println("Demand Request Main Query-->>>>"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/**
	 * Combo Option Search feature.
	 * 
	 * 1^0 represents 1 >> dummy value and 0 >> index of the Combo (first combo >> 0 , second combo >> 1 , etc., ) next value after "1^0" should be
	 * the Name of the Combo Header (first combo in this case)
	 * 
	 * by doing this in the transaction template , at the search combo box a new field with the Combo Header will be available, by selecteing the
	 * option and corresponding value, a search can be made in the corresponding combo box
	 * 
	 * @return the search field
	 */

	@Override
	public String[] getSearchField() {
		String searchField[] = { "3", "C.ITEM_NAME", "1", "C.HSTNUM_REQUEST_NO"};
		return searchField;
	}

	/**
	 * 0^0 0 Means Combo From Query, 1 Means User Defined Combo,0 After ^ Means Select Value, 1 Means All,2 Means Default Selected.
	 * 
	 * @return the combo header
	 */
	@Override
	public String[] getComboHeader() {

		
		String[] strComboHeader = new String[4];
		

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Drug_Store";
			strComboHeader[2] = "1";
			strComboHeader[3] = "Status";

		

		return strComboHeader;
	}

	@Override
	public String[] getColumnHeader() {

		String[] strColumnHeader = null;
		if(cmbVal != null && cmbVal[1].equals("0"))
		{
			strColumnHeader= new String[8];
			strColumnHeader[0] = "Request_no";
			strColumnHeader[1] = "Request_date";
			strColumnHeader[2] = "Drug_Name";
			strColumnHeader[3] = "Batch_No.";
			strColumnHeader[4] = "Expiry_Date";
			strColumnHeader[5] = "Req/Sanc_Quantity";
			strColumnHeader[6] = "Ord/Trf_Qty";
			strColumnHeader[7] = "Status";
		}
		else{
			strColumnHeader= new String[7];
			strColumnHeader[0] = "Request_no";
			strColumnHeader[1] = "Request_date";
			strColumnHeader[2] = "Drug_Name";
			strColumnHeader[3] = "Batch_No.";
			strColumnHeader[4] = "Expiry_Date";
			strColumnHeader[5] = "Req/Sanc_Quantity";
			strColumnHeader[6] = "Ord/Trf_Qty";
		}
		return strColumnHeader;
	}

	@Override
	public String[] getComboQuery() {

		String[] comboQuery = new String[3];

		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		comboQuery[0] =
				"SELECT HSTNUM_STORE_ID||'^'||HSTNUM_PHYSTOCK_FLAG , hststr_store_name FROM hstt_store_mst a  WHERE gnum_isvalid = 1 "
				//+ "AND SSTNUM_DWH_TYPE_ID IN (10,13,14,15,12,16,17,20,21,19,11,24) "
				+ "AND gnum_hospital_code = " + hosCode
				+ " AND A.HSTNUM_STORE_ID IN (  "
				  + " SELECT GNUM_COLUMN_VALUE      "
				  + " FROM GBLT_ROLE_SEAT_TABLE_DTL P     "
				  + " WHERE P.gnum_metatable_id = 101 	   "
				  + " AND P.gnum_hospital_code = A.gnum_hospital_code     "
				  + " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+ httpSession.getAttribute("SEATID").toString() + ", " + httpSession.getAttribute("HOSPITAL_CODE").toString() + ") from dual ) "
				  + " )ORDER BY hststr_store_name";

		comboQuery[1] = "0^All#1^Approval In Process#2^Order In Process#3^Transfer In Process#4^Rejeted#5^Closed";
		return comboQuery;
	}

	@Override
	public String getViewQuery() {
		return "";
	}

	@Override
	public String getButtons() {
		String strButtons = "";
		return strButtons;
	}

	@Override
	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	@Override
	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	@Override
	public String getJsFiles() {
		String files = "../../mms/js/transferRequestDesk_trans.js";
		return files;

	}

	@Override
	public String[] getRowStatus() {
		/*
		 * "1"--->> Value Which we Want to Maaped 1 2 3 4 5 6 7 "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->> "Exp Within"--->>Argument You Want to Show in Footer of Template
		 */
		String[] status = null;

		if (cmbVal == null || (cmbVal != null && cmbVal[1].equals("0"))) 
		{
			status = new String[4];
			status[0] = "1";
			status[1] = "10";
			status[2] = "#ffb6c1";
			status[3] = "Modify/Cancel";
		}
		if (cmbVal == null || (cmbVal != null && cmbVal[1].equals("4")) || (cmbVal != null && cmbVal[1].equals("5"))) 
		{
			status = new String[4];
			status[0] = "1";
			status[1] = "10";
			status[2] = "LightSlateGrey";
			status[3] = "Force_Fully_Closed";
		}
		return status;   
		
	}

	@Override
	public String getEventState() {
		String strEvent = "chkUserDefinedFunc";
		return strEvent;
	}

	@Override
	public String getButtonConfiguration() {
		return "left";
	}

	@Override
	public String[] getUserDefinedButtons() {

		String[] strButtons = null;
		strButtons = new String[4];
		strButtons[0] = "Generate@buttonLogicsOnClickGenerate(1,'generate','Generate')@0@Generate";
		//
		strButtons[1] = "Modify@buttonLogicsOnClickModify(2,'modifyRecord','Modify')@1@Modify";
		
		strButtons[2] = "Cancel@buttonLogicsOnClickCancel(3,'cancelRecord','Cancel')@1@Cancel";
		strButtons[3] = "View@buttonLogicsOnClickView(4,'view','View')@1@View";

		return strButtons;
	}

	@Override
	public String[] getDbButtons() {
		return null;
	}

	@Override
	public int getMinPanelButton() {
		return 1;
	}

	@Override
	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	@Override
	public String getComboEventState() {
		return "changeCombo";
	}

	@Override
	public String[] getOrderBy() {
		String orderBy[] = { "1", "C.HSTNUM_REQUEST_NO", "2", "TO_DATE(C.req_date)" };
		return orderBy;
	}

	
}
