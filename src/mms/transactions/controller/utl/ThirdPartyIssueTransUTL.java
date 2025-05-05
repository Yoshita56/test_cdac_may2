package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import mms.MmsConfigUtil;

public class ThirdPartyIssueTransUTL extends TransInterface {

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
			
			    StringBuffer brMainQuery = new StringBuffer(500);
			    MmsConfigUtil mmsConfig = null;
			   
			    if (cmb != null) 
			    {
			    	    mmsConfig = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
			    	    brMainQuery.append(" SELECT C.GNUM_HOSPITAL_CODE||'@'||C.HSTNUM_TREQ_NO||'@'|| C.HSTDT_TREQ_DATE||'@'||C.CAT_NAME ||'@'|| "); 
						brMainQuery.append(" C.THIRD_PARTY ||'@'|| C.HSTDT_ISSUE_DATE  ||'@'|| C.GSTR_REMARKS||'^'|| C.HSTNUM_TREQ_NO||'^'||");
						brMainQuery.append(" C.HSTDT_TREQ_DATE||'^'||C.THIRD_PARTY||'^'|| C.HSTDT_ISSUE_DATE  DATA FROM  ");
						brMainQuery.append(" (SELECT B.HSTNUM_TREQ_NO ,B.GNUM_HOSPITAL_CODE ,B.HSTDT_TREQ_DATE,  ");
						brMainQuery.append(" mms_mst.get_itemcat_dtl(1,B.GNUM_HOSPITAL_CODE,B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME, ");
						brMainQuery.append(" (SELECT GSTR_INSTITUTE_NAME FROM GBLT_EXT_INSTITUTE_MST A  ");
						brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = " +httpSession.getAttribute("HOSPITAL_CODE").toString());
						brMainQuery.append(" AND A.GNUM_INSTITUTE_CODE = B.GNUM_INSTITUTE_CODE )AS THIRD_PARTY, ");
						brMainQuery.append(" B.HSTNUM_STORE_ID,B.HSTNUM_TREQ_STATUS,B.HSTDT_ISSUE_DATE,B.GSTR_REMARKS,B.SSTNUM_ITEM_CAT_NO,B.HSTNUM_LST_APPROVE_SEATID ,B.HSTDT_FINANCIAL_START_DATE,B.HSTDT_FINANCIAL_END_DATE");
						brMainQuery.append(" FROM HSTT_THIRDPARTY_ISSUE_DTL B ");
						brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND B.GNUM_ISVALID=1) C ");
						brMainQuery.append(" WHERE C.HSTNUM_STORE_ID = #1#");
						brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO = #2#");
						if(cmb[2]=="1")
							 brMainQuery.append(" AND ( (C.HSTNUM_TREQ_STATUS =0) OR (C.HSTNUM_LST_APPROVE_SEATID IS NULL) )");
						if(cmb[2]=="2")
							 brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS BETWEEN 1 AND 39");
						if(cmb[2]=="3")
							 brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =40");
						if(cmb[2]=="4")
							 brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =99 AND C.HSTDT_FINANCIAL_START_DATE="+mmsConfig.getStrFinancialStartDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString())+"  AND C.HSTDT_FINANCIAL_END_DATE="+mmsConfig.getStrFinancialEndDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString()));
						if(cmb[2]=="5")
							 brMainQuery.append(" AND C.HSTNUM_TREQ_STATUS =50 AND C.HSTDT_FINANCIAL_START_DATE="+mmsConfig.getStrFinancialStartDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString())+"  AND C.HSTDT_FINANCIAL_END_DATE="+mmsConfig.getStrFinancialEndDate(cmb[0] , httpSession.getAttribute("HOSPITAL_CODE").toString()));
			    }
			    else
			    {
			    	    brMainQuery.append(" SELECT C.GNUM_HOSPITAL_CODE||'@'||C.HSTNUM_TREQ_NO||'@'|| C.HSTDT_TREQ_DATE||'@'||C.CAT_NAME ||'@'|| "); 
						brMainQuery.append(" C.THIRD_PARTY ||'@'|| C.HSTDT_ISSUE_DATE  ||'@'|| C.GSTR_REMARKS||'^'|| C.HSTNUM_TREQ_NO||'^'||");
						brMainQuery.append(" C.HSTDT_TREQ_DATE||'^'||C.THIRD_PARTY||'^'|| C.HSTDT_ISSUE_DATE  DATA FROM  ");
						brMainQuery.append(" (SELECT B.HSTNUM_TREQ_NO ,B.GNUM_HOSPITAL_CODE ,B.HSTDT_TREQ_DATE,  ");
						brMainQuery.append(" mms_mst.get_itemcat_dtl(1,B.GNUM_HOSPITAL_CODE,B.SSTNUM_ITEM_CAT_NO) AS CAT_NAME, ");
						brMainQuery.append(" (SELECT GSTR_INSTITUTE_NAME FROM GBLT_EXT_INSTITUTE_MST A  ");
						brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = " +httpSession.getAttribute("HOSPITAL_CODE").toString());
						brMainQuery.append(" AND A.GNUM_INSTITUTE_CODE = B.GNUM_INSTITUTE_CODE )AS THIRD_PARTY, ");
						brMainQuery.append(" B.HSTNUM_STORE_ID,B.HSTNUM_TREQ_STATUS,B.HSTDT_ISSUE_DATE,B.GSTR_REMARKS ");
						brMainQuery.append(" FROM HSTT_THIRDPARTY_ISSUE_DTL B ");
						brMainQuery.append(" WHERE B.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND B.GNUM_ISVALID=1) C ");
					    brMainQuery.append(" WHERE C.HSTNUM_STORE_ID = 0 ");
			    }
			    
			return brMainQuery.toString();
		}

		public String[] getSearchField() 
		{
			String search_field[] = {"3", "C.THIRD_PARTY"};
			return search_field;
		}

		public String[] getComboHeader() 
		{
			//String[] strComboHeader = {"0","Drug Warehouse Name","0","Item Category","1","Item Status"};
			
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
			String[] strComboHeader = new String[6];
			if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
			{	

				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Drug WareHouse Name";
				strComboHeader[2] = "0^2";
				strComboHeader[3] = "Category";
				strComboHeader[4] = "1";
				strComboHeader[5] = "Drug Status";

			}
			else
			{
				strComboHeader[0] = "0^2";
				strComboHeader[1] = "Store Name";
				strComboHeader[2] = "0^2";
				strComboHeader[3] = "Category";
				strComboHeader[4] = "1";
				strComboHeader[5] = "Item Status";

			}
			
			
		    return strComboHeader;
		}

		public String[] getColumnHeader() 
		{
			String[] strColumnHeader = { "Req No", "Req Date", "Third Party Name"};
			return strColumnHeader;
		}      

		public String[] getComboQuery(){
		
			String[] comboQuery = new String[3];
			comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="+
					         httpSession.getAttribute("HOSPITAL_CODE").toString();
			if(cmbVal==null)
			{
				comboQuery[1] = " SELECT SSTNUM_ITEM_CAT_NO,(MMS_MST.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,"+
                " SSTNUM_ITEM_CAT_NO))CAT_NAME FROM HSTT_STORE_CATEGORY_MST WHERE GNUM_ISVALID =1 " +
                " AND GNUM_HOSPITAL_CODE =0 AND HSTNUM_STORE_ID =0 AND GDT_EFFECTIVE_FRM<=TRUNC(SYSDATE)";
			}
			else
			{
				comboQuery[1] = " SELECT SSTNUM_ITEM_CAT_NO,(MMS_MST.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,"+
                " SSTNUM_ITEM_CAT_NO))CAT_NAME FROM HSTT_STORE_CATEGORY_MST WHERE GNUM_ISVALID =1 " +
                " AND GNUM_HOSPITAL_CODE ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND HSTNUM_STORE_ID =#1# AND GDT_EFFECTIVE_FRM<=TRUNC(SYSDATE)";
			}
			
		
			comboQuery[2] = "1^Active#2^Partial Approved#3^Approved#4^Rejected#5^Processed";
	
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
//			String a[] = null;
//			String b[] = null;
//			String key[] = new String[1];
//
			List<String> deleteData = new ArrayList<String>();
//			a = (chk.replace('|', '#')).split("#");
//			b = (a[0].replace('@', '#')).split("#");
//
//			key[0] = b[0];
//			System.out.print("key[0] = " + key[0]);
//			deleteData.add(key);
//			return deleteData;
			return deleteData;
		}

		public String getJsFiles() {
			String files = "../../mms/js/thirdPartyIssue_trans.js";
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
			String[] strButtons = {"Request@callPage1(document.forms[0],'REQUEST')@0@F7F1BE@glyphicon-export",
					"Cancel@callPage1(document.forms[0],'CANCEL_REQUEST')@1@bb0000@glyphicon-remove",
					"Issue@callPage1(document.forms[0],'ISSUE')@1@3b5998@glyphicon-plus",
					"View@callPage1(document.forms[0],'VIEW')@1@007bb6@glyphicon-fullscreen"};		
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
			return "comboEvent";
		}

		public String[] getOrderBy() {
			String orderBy[] = { "2", "C.HSTDT_TREQ_DATE" };
			return orderBy;
		}
		
	}
