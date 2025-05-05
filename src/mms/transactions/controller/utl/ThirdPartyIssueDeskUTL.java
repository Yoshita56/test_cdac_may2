package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class ThirdPartyIssueDeskUTL extends TransInterface {

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
		String masterName = "Third Party Issue";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		// For Institute Name, changed the Hospital Code Query - Surmeet, 10th Nov, 2014
		StringBuffer brMainQuery = new StringBuffer(500);
		MmsConfigUtil mmsConfig = null;

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		if (res.getString("THIRD_PARTY").equals("1")) {
			mmsConfig = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
			brMainQuery.append(
					" SELECT C.GNUM_HOSPITAL_CODE||'@'||C.HSTNUM_TREQ_NO||'@'|| C.HSTDT_TREQ_DATE||'@'||C.CAT_NAME ||'@'|| ");
			brMainQuery.append(
					" C.THIRD_PARTY ||'@'|| C.HSTDT_ISSUE_DATE  ||'@'|| C.GSTR_REMARKS||'^'|| C.HSTNUM_TREQ_NO||'^'||");
			brMainQuery.append(
					" TO_CHAR(C.HSTDT_TREQ_DATE,'dd-Mon-yyyy')||'^'||C.THIRD_PARTY||'^'|| C.HSTDT_ISSUE_DATE AS DATA FROM  ");
			brMainQuery.append(" (SELECT B.HSTNUM_TREQ_NO ,B.GNUM_HOSPITAL_CODE ,B.HSTDT_TREQ_DATE,  ");
			brMainQuery.append(" mms_mst.get_itemcat_dtl(1,B.GNUM_HOSPITAL_CODE,B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME, ");
			brMainQuery.append(
					" Mms_Mst.get_third_party_dtl(1,gnum_hospital_code,B.GNUM_INSTITUTE_CODE,1) AS THIRD_PARTY,");
			brMainQuery.append(
					" B.HSTNUM_STORE_ID,B.HSTNUM_TREQ_STATUS,B.HSTDT_ISSUE_DATE,B.GSTR_REMARKS,B.SSTNUM_ITEM_CAT_NO,B.HSTNUM_LST_APPROVE_SEATID ,B.HSTDT_FINANCIAL_START_DATE,B.HSTDT_FINANCIAL_END_DATE");
			brMainQuery.append(" FROM HSTT_THIRDPARTY_ISSUE_DTL B ");

			if (cmb != null) {
				brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "
						+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " AND B.GNUM_ISVALID=1) C ");
				brMainQuery.append(" WHERE C.HSTNUM_STORE_ID =" + cmb[0].trim());
				brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO =" + cmb[1].trim());

				if (cmb[2].trim().equals("1"))
					brMainQuery.append(
							" AND ( (C.HSTNUM_TREQ_STATUS =0) OR (C.HSTNUM_LST_APPROVE_SEATID IS NULL AND C.HSTNUM_TREQ_STATUS <40) )");
				else if (cmb[2].trim().equals("2"))
					brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS BETWEEN 1 AND 39");
				else if (cmb[2].trim().equals("3"))
					brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =40");
				else {
					if (cmb[2].trim().equals("4"))
						brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =99");
					if (cmb[2].trim().equals("5"))
						brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =50");

					// brMainQuery.append(" AND
					// C.HSTDT_FINANCIAL_START_DATE=TO_DATE('"+mmsConfig.getStrFinancialStartDate(cmb[0]
					// , httpSession.getAttribute("HOSPITAL_CODE").toString())+"' , 'dd-Mon-yyyy')
					// AND
					// C.HSTDT_FINANCIAL_END_DATE=TO_DATE('"+mmsConfig.getStrFinancialEndDate(cmb[0]
					// , httpSession.getAttribute("HOSPITAL_CODE").toString())+"','dd-Mon-yyyy')");
				}
			} else {
				brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "
						+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " AND B.GNUM_ISVALID=1) C ");
				brMainQuery.append(" WHERE 1=2");
			}
		} else {
			mmsConfig = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());

			brMainQuery.append(
					" SELECT C.GNUM_HOSPITAL_CODE||'@'||C.HSTNUM_TREQ_NO||'@'|| C.HSTDT_TREQ_DATE||'@'||C.CAT_NAME ||'@'|| ");
			brMainQuery.append(
					" C.THIRD_PARTY ||'@'|| C.HSTDT_ISSUE_DATE  ||'@'|| C.GSTR_REMARKS||'^'|| C.HSTNUM_TREQ_NO||'^'||");
			brMainQuery.append(
					" TO_CHAR(C.HSTDT_TREQ_DATE,'dd-Mon-yyyy')||'^'||C.THIRD_PARTY||'^'|| C.HSTDT_ISSUE_DATE AS DATA FROM  ");
			brMainQuery.append(" (SELECT B.HSTNUM_TREQ_NO ,B.GNUM_HOSPITAL_CODE ,B.HSTDT_TREQ_DATE,  ");
			brMainQuery.append(" mms_mst.get_itemcat_dtl(1,B.GNUM_HOSPITAL_CODE,B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME, ");
			brMainQuery.append(
					" Mms_Mst.get_third_party_dtl(1,gnum_hospital_code,B.GNUM_INSTITUTE_CODE,1) AS THIRD_PARTY,");
			brMainQuery.append(
					" B.HSTNUM_STORE_ID,B.HSTNUM_TREQ_STATUS,B.HSTDT_ISSUE_DATE,B.GSTR_REMARKS,B.SSTNUM_ITEM_CAT_NO,B.HSTNUM_LST_APPROVE_SEATID ,B.HSTDT_FINANCIAL_START_DATE,B.HSTDT_FINANCIAL_END_DATE");
			brMainQuery.append(" FROM HSTT_THIRDPARTY_ISSUE_DTL B ");
			brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = " + httpSession.getAttribute("HOSPITAL_CODE").toString()
					+ " AND B.GNUM_ISVALID=1) C ");

			if (cmb != null) {
				brMainQuery.append(" WHERE C.HSTNUM_STORE_ID =" + cmb[0].trim());
				if (!cmb[1].trim().equals("0")) {
					brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO =" + cmb[1].trim());
				}
				brMainQuery.append(" AND C.HSTDT_FINANCIAL_START_DATE=TO_DATE('"
						+ mmsConfig.getStrFinancialStartDate(cmb[0],
								httpSession.getAttribute("HOSPITAL_CODE").toString())
						+ "' , 'dd-Mon-yyyy')   AND C.HSTDT_FINANCIAL_END_DATE=TO_DATE('"
						+ mmsConfig.getStrFinancialEndDate(cmb[0], httpSession.getAttribute("HOSPITAL_CODE").toString())
						+ "','dd-Mon-yyyy')");
			} else {
				brMainQuery.append(" WHERE 1=2");
			}

		}

		 System.out.println("[ThirdPartyIssueDeskUTL]:::::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() {
		String search_field[] = { "3", "C.THIRD_PARTY" };
		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query, 1 Means User Defined Combo,0 After ^ Means
	 * Select Value, 1 Means All,2 Means Default Selected
	 */

	public String[] getComboHeader() {
		// String[] strComboHeader = {"0^2","Drug Warehouse Name","0^2","Item
		// Category","1","Item Status"};

		MmsConfigUtil mmscofigutil = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		int size = 0;

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		if (res.getString("THIRD_PARTY").equals("1")) {
			size = 6;
		} else {
			size = 4;
		}
		String[] strComboHeader = new String[size];
		if (res.getString("THIRD_PARTY").equals("1")) {
			if (mmscofigutil.getStrStoreConfigCatg().equals("10")) {

				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Store Name";
				strComboHeader[2] = "0^0";
				strComboHeader[3] = "Category";
				strComboHeader[4] = "1";
				strComboHeader[5] = "Drug Status";

			} else {
				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Store Name";
				strComboHeader[2] = "0^0";
				strComboHeader[3] = "Category";
				strComboHeader[4] = "1";
				strComboHeader[5] = "Item Status";

			}
		} else {
			if (mmscofigutil.getStrStoreConfigCatg().equals("10")) {
				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Store Name";
				strComboHeader[2] = "0^0";
				strComboHeader[3] = "Category";

			} else {
				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Store Name";
				strComboHeader[2] = "0^0";
				strComboHeader[3] = "Category";

			}

		}

		return strComboHeader;
	}

	public String[] getColumnHeader() {
		int size = 0;

		size = 3;

		String[] strColumnHeader = new String[size];

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		if (res.getString("THIRD_PARTY").equals("1")) {
			strColumnHeader[0] = "Req No";
			strColumnHeader[1] = "Req Date";
			strColumnHeader[2] = "Third Party Name";
		} else {
			strColumnHeader[0] = "Issue No";
			strColumnHeader[1] = "Issue Date";
			strColumnHeader[2] = "Third Party Name";
		}
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		int size = 0;

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		if (res.getString("THIRD_PARTY").equals("1")) {
			size = 3;
		} else {
			size = 2;
		}

		String[] comboQuery = new String[size];
		if (res.getString("THIRD_PARTY").equals("1")) {
			comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="
					+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " AND EXISTS" + "(" + "SELECT 'X'"
					+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"
					+ " WHERE P.gnum_metatable_id = q.gnum_metatable_id" +
					// " AND P.gnum_hospital_code = q.gnum_hospital_code"+
					" AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"
					+ " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"
					+ " AND P.gnum_hospital_code = A.gnum_hospital_code" + " AND gnum_column_value = A.HSTNUM_STORE_ID"
					+ " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid(" + httpSession.getAttribute("SEATID").toString()
					+ ",A.GNUM_HOSPITAL_CODE)" + ") " + "ORDER BY INITCAP(HSTSTR_STORE_NAME)";

			/*
			 * comboQuery[1] =
			 * " SELECT SSTNUM_ITEM_CAT_NO , Mms_Mst.get_itemcat_dtl(1 , GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO ) AS ITEM_CAT"
			 * + " FROM HSTT_STORE_CATEGORY_MST A"+ " WHERE GNUM_ISVALID = 1"+
			 * " AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE))"
			 * + " AND GNUM_HOSPITAL_CODE ="+httpSession.getAttribute("HOSPITAL_CODE").
			 * toString()+ " AND HSTNUM_STORE_ID =#1# "+ " AND EXISTS"+ " (SELECT 'X'"+
			 * " FROM HSTT_STORE_REQTYPE_MST"+ " WHERE GNUM_ISVALID = 1"+
			 * " AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE))"
			 * + " AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE"+
			 * " AND SSTNUM_INDENTTYPE_ID =65"+
			 * " AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO"+
			 * " AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID"+ " )"+ "ORDER BY ITEM_CAT";
			 */
			
			 comboQuery[1] =  "select DISTINCT SSTNUM_ITEM_CAT_NO,INITCAP(MMS_MST.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO))CAT_NAME "
      		       + "from HSTT_STORE_CATEGORY_MST  where GNUM_ISVALID =1 " +
      		       "  AND HSTNUM_STORE_ID IN ( "+ 
   				  "  SELECT GNUM_COLUMN_VALUE  "+    
   				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
   				  " WHERE P.gnum_metatable_id = 117 "+ 	      				
   				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
   				  " )ORDER BY CAT_NAME";

			//comboQuery[2] = "1^Active#2^Partial Approved#3^Approved#4^Rejected#5^Processed";
			 comboQuery[2] = "3^Active#4^Rejected#5^Processed";
		} else {
			comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="
					+ httpSession.getAttribute("HOSPITAL_CODE").toString() + " AND EXISTS" + "(" + "SELECT 'X'"
					+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"
					+ " WHERE P.gnum_metatable_id = q.gnum_metatable_id"
					+ " AND P.gnum_hospital_code = q.gnum_hospital_code"
					+ " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"
					+ " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"
					+ " AND P.gnum_hospital_code = A.gnum_hospital_code" + " AND gnum_column_value = A.HSTNUM_STORE_ID"
					+ " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid(" + httpSession.getAttribute("SEATID").toString()
					+ ",A.GNUM_HOSPITAL_CODE)" + ") ORDER BY INITCAP(HSTSTR_STORE_NAME)";
            
			/*
			comboQuery[1] = " SELECT SSTNUM_ITEM_CAT_NO , Mms_Mst.get_itemcat_dtl(1 , GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO ) AS ITEM_CAT"
					+ " FROM HSTT_STORE_CATEGORY_MST A" + " WHERE GNUM_ISVALID = 1"
					+ " AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE))"
					+ " AND GNUM_HOSPITAL_CODE =" + httpSession.getAttribute("HOSPITAL_CODE").toString()
					+ " AND HSTNUM_STORE_ID =#1#" + " AND EXISTS" + " (SELECT 'X'" + " FROM HSTT_STORE_REQTYPE_MST"
					+ " WHERE GNUM_ISVALID = 1"
					+ " AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE))"
					+ " AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE" + " AND SSTNUM_INDENTTYPE_ID =65"
					+ " AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO" + " AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID"
					+ " )ORDER BY ITEM_CAT";
			*/
			
			 comboQuery[1] =  "select DISTINCT SSTNUM_ITEM_CAT_NO,INITCAP(MMS_MST.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO))CAT_NAME "
	      		       + "from HSTT_STORE_CATEGORY_MST  where GNUM_ISVALID =1 " +
	      		       "  AND HSTNUM_STORE_ID IN ( "+ 
	   				  "  SELECT GNUM_COLUMN_VALUE  "+    
	   				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
	   				  " WHERE P.gnum_metatable_id = 117 "+ 	      				
	   				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
	   				  " )ORDER BY CAT_NAME";
		}
		// System.out.println("comboQuery[1]:::"+comboQuery[1]);
		return comboQuery;
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		return "";
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
		String files = "../../mms/js/thirdPartyIssueDesk.js";
		return files;
	}

	/*
	 * "1"--->> Value Which we Want to Maaped 1 2 3 4 5 6 7 "7"--->> Column Name
	 * Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1 "blue"--->>
	 * "Exp Within"--->>Argument You Want to Show in Footer of Template
	 * 
	 */
	public String[] getRowStatus() {
		String[] status = { "Autrin Cap", "1", "brown", "", "aLkol", "2", "blue", "" };
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

		// String[] strButtons =
		// {"Request@callPage1(document.forms[0],'REQUEST')@0","Cancel@callPage1(document.forms[0],'CANCEL_REQUEST')@1","Issue@callPage1(document.forms[0],'ISSUE')@1","View@callPage1(document.forms[0],'VIEW')@1"};
		int size = 0;

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		if (res.getString("THIRD_PARTY").equals("1")) {
			size = 4;
		} else {
			size = 2;
		}
		String strButtons[] = new String[size];
		if (res.getString("THIRD_PARTY").equals("1")) {
			strButtons[0] = "Request@callPage1(document.forms[0],'REQUEST')@0";
			strButtons[1] = "Cancel@callPage1(document.forms[0],'CANCEL_REQUEST')@1";
			strButtons[2] = "Issue@callPage1(document.forms[0],'ISSUE')@1";
			strButtons[3] = "View@callPage1(document.forms[0],'VIEW')@1";
		} else {
			strButtons[0] = "Issue@callPage1(document.forms[0],'REQUEST')@0";
			strButtons[1] = "View@callPage1(document.forms[0],'VIEW')@0";
		}
		return strButtons;
	}

	public String[] getDbButtons() {
		// String[] str = { "1" };
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
		return "comboEvent";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "2", "C.HSTDT_TREQ_DATE" };
		return orderBy;
	}

}
