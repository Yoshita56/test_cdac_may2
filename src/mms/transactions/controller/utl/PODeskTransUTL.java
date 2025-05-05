/**
 * 
 */
package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
import hisglobal.utility.HisUtil;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskTransUTL extends TransInterface {

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
		String masterName = "PO Desk";
		return masterName;
	}

	public int getRecord_per_page() {
		return 12;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		StringBuffer brMainQuery = new StringBuffer(1500);
		//MmsConfigUtil mmsConfig = new MmsConfigUtil(strHospCode);
		
		
		HisUtil util = new HisUtil("Material Management System","PODeskGenerateTransDATA.setItemCatValues()");
		String strCurrentDate="";
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		
		try {
			strCurrentDate  = util.getASDate("dd-MM-yyyy");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
		
		
		if(strCurrentMonth>=4 )
		{
			CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
		}
		else
		{
			CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
		}
						
		strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
		
		strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
		
		brMainQuery.append("SELECT    HSTNUM_STORE_ID ");
		brMainQuery.append("|| '@'|| HSTNUM_PO_NO ");
		brMainQuery.append("|| '@'|| GNUM_HOSPITAL_CODE ");
		brMainQuery.append("|| '@'|| SSTNUM_POTYPE_ID ");
		brMainQuery.append("|| '@'|| SSTNUM_ITEM_CAT_NO ");
		brMainQuery.append("|| '@'|| TOTSCHED ");
		brMainQuery.append("|| '^'|| HSTNUM_PO_NO ");
		brMainQuery.append("|| '^'|| PODATE ");
		brMainQuery.append("|| '^'|| POTYPE ");
		brMainQuery.append("|| '^'|| SUPPLIER ");
		brMainQuery.append("|| '^'|| ITEMCAT ");
		brMainQuery.append("|| '^'|| DEL_LOC ||'^'|| IS_FORIEGN AS DATA ");
		brMainQuery.append(" FROM (SELECT distinct ");		
		brMainQuery.append(" (SELECT COUNT (*) ");
		brMainQuery.append(" FROM HSTT_PO_SCHEDULE_DTL ");
		brMainQuery.append(" WHERE GNUM_ISVALID = B.GNUM_ISVALID ");
		brMainQuery.append(" AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
		brMainQuery.append(" AND HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
		brMainQuery.append(" AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, ");
		brMainQuery.append(" SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID,");
		brMainQuery.append(" HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, ");
		//brMainQuery.append(" HSTDT_PO_DATE "); commented bcz of time
		brMainQuery.append(" to_char(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI') ");
		brMainQuery.append(" AS PODATE, MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_POTYPE_ID) AS POTYPE, ");
		brMainQuery.append(" MMS_MST.GET_SUPP_DTL (1, ");
		brMainQuery.append(" GNUM_HOSPITAL_CODE, ");
		brMainQuery.append(" HSTNUM_SUPPLIER_ID ");
		brMainQuery.append(" ) AS SUPPLIER, ");
		brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL");
		brMainQuery.append(" (1,GNUM_HOSPITAL_CODE, ");
		brMainQuery.append(" SSTNUM_ITEM_CAT_NO ");
		brMainQuery.append(" ) AS ITEMCAT, ");
		brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_DELIVERY_LOCATION) AS DEL_LOC ,HSTNUM_FORIEGN_FLAG AS IS_FORIEGN ");
		brMainQuery.append(" FROM ");
		if(cmb != null)
			//if(cmb[3].equals("2"))
			//	brMainQuery.append(" HSTT_PO_DTL B ");
			//else
				brMainQuery.append(" SSTT_PO_DTL B ");
		else
			brMainQuery.append(" SSTT_PO_DTL B ");
		brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0");
		if (cmb != null) 
		{
			brMainQuery.append(" AND HSTNUM_STORE_ID = ");
			brMainQuery.append(cmb[0]);
			//System.out.println("cmb[2].substring(1,2)"+cmb[2].substring(1,2));
			if(!cmb[2].equals("0"))
			if(cmb[2].substring(0,2).equals("22") || cmb[2].substring(0,2).equals("21") || cmb[2].substring(0,2).equals("87"))
				brMainQuery.append(" and SSTNUM_POTYPE_ID = '"+cmb[2].substring(0,2)+"'");
			if(cmb[3].equals("1"))
				brMainQuery.append(" AND HSTNUM_PO_STATUS =1 AND HSTNUM_RECIEVE_FLAG = 0");
			else if(cmb[3].equals("3"))
				brMainQuery.append(" AND HSTNUM_PO_STATUS = 1 AND HSTNUM_RECIEVE_FLAG = 1");
			else if(cmb[3].equals("2")){
				//String strFinancialStartDate = mmsConfig.getStrFinancialStartDate(cmb[0], strHospCode);
				//String strFinancialEndDate = mmsConfig.getStrFinancialEndDate(cmb[0], strHospCode);
				brMainQuery.append(" AND HSTNUM_PO_STATUS = 2 ");
				//brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = TO_DATE('");
				//brMainQuery.append(strFinancialStartDate);
				//brMainQuery.append("','dd-Mon-yyyy') AND HSTDT_FINANCIAL_END_DATE = TO_DATE('");
				//brMainQuery.append(strFinancialEndDate);
				//brMainQuery.append("','dd-Mon-yyyy')");
			}
		}//else
			//brMainQuery.append(" AND 1 = 2");
		
		brMainQuery.append(") A ");
		brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
		brMainQuery.append(strHospCode);
		if (cmb != null) 
			if(!cmb[2].equals("0") && cmb[2].substring(0,2).equals("21") && cmb[3].equals("1"))
			{
				brMainQuery.delete(0, brMainQuery.length());
				brMainQuery.append("SELECT  HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED ||'@'|| '1' || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| POTYPE || '^'|| ITEMCAT || '^'|| DEL_LOC ||'^0^'|| IS_FORIEGN AS DATA  FROM (SELECT distinct (SELECT COUNT (*)  FROM HSTT_PO_SCHEDULE_DTL  WHERE GNUM_ISVALID = B.GNUM_ISVALID  AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO  AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED,  SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_DRAFT_PO_NO as HSTNUM_PO_NO, GNUM_HOSPITAL_CODE,  to_char(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI') AS PODATE, MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_POTYPE_ID) AS POTYPE,  MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE,  SSTNUM_ITEM_CAT_NO  ) AS ITEMCAT,  MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_DELIVERY_LOCATION) AS DEL_LOC ,HSTNUM_FORIEGN_FLAG AS IS_FORIEGN  FROM  SSTT_PO_DTL B WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0  and SSTNUM_POTYPE_ID = '21' AND HSTNUM_PO_STATUS =0 and HSTNUM_DRAFT_PO_NO <> 0 AND HSTNUM_RECIEVE_FLAG = 0) A");
				brMainQuery.append(" WHERE GNUM_HOSPITAL_CODE = ");
				brMainQuery.append(strHospCode);
				brMainQuery.append(" AND HSTNUM_STORE_ID = ");
				brMainQuery.append(cmb[0]);
				brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = ");
				brMainQuery.append(cmb[1]);
			}
			else if(!cmb[2].equals("0") && cmb[2].substring(0,2).equals("21") && cmb[3].equals("3"))
				{
					brMainQuery.delete(0, brMainQuery.length());
					brMainQuery.append("SELECT HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'|| 'FC' || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| POTYPE || '^'|| ITEMCAT || '^'|| DEL_LOC ||'^0^'|| IS_FORIEGN AS DATA  FROM (SELECT distinct (SELECT COUNT (*)  FROM HSTT_PO_SCHEDULE_DTL  WHERE GNUM_ISVALID = B.GNUM_ISVALID  AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO  AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED,  SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO as HSTNUM_PO_NO, GNUM_HOSPITAL_CODE,  to_char(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI') AS PODATE, MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_POTYPE_ID) AS POTYPE,  MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE,  SSTNUM_ITEM_CAT_NO  ) AS ITEMCAT,  MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_DELIVERY_LOCATION) AS DEL_LOC ,HSTNUM_FORIEGN_FLAG AS IS_FORIEGN  FROM  SSTT_PO_DTL B WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0  and SSTNUM_POTYPE_ID = '21' AND HSTNUM_PO_STATUS =1 and HSTNUM_DRAFT_PO_NO <> 0 AND HSTNUM_RECIEVE_FLAG = 0) A");
					brMainQuery.append(" WHERE GNUM_HOSPITAL_CODE = ");
					brMainQuery.append(strHospCode);
					brMainQuery.append(" AND HSTNUM_STORE_ID = ");
					brMainQuery.append(cmb[0]);
					brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = ");
					brMainQuery.append(cmb[1]);
				}
			
		System.out.println("PODeskTransUTL  Query->>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() {
		String search_field[] = { "1", "HSTNUM_PO_NO" };
		return search_field;
	}
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() {
		String[] strComboHeader = { "0^2", "Store Name","0^0","Item Category","0^0", "PO Type", "1",
				"&nbsp; PO Status" };

		return strComboHeader;
	}

	public String[] getColumnHeader() {
		String[] strColumnHeader = new String[6];
		strColumnHeader[0] = "PO No.";
		strColumnHeader[1] = "PO Date";
		strColumnHeader[2] = "PO Type";
		strColumnHeader[3] = "Supplier";
		strColumnHeader[4] = "Item Category";
		strColumnHeader[5] = "Delivery Location";
		if (cmbVal != null) 
		{
			if(!cmbVal[2].equals("0") && cmbVal[2].substring(0,2).equals("21") && cmbVal[3].equals("1"))
			{
				strColumnHeader = new String[5];
				strColumnHeader[0] = "Draft PO No.";
				strColumnHeader[1] = "PO Date";
				strColumnHeader[2] = "PO Type";
				strColumnHeader[3] = "Item Category";
				strColumnHeader[4] = "Delivery Location";
			}
			if(!cmbVal[2].equals("0") && cmbVal[2].substring(0,2).equals("21") && cmbVal[3].equals("3"))
			{
				strColumnHeader = new String[5];
				strColumnHeader[0] = "PO No.";
				strColumnHeader[1] = "PO Date";
				strColumnHeader[2] = "PO Type";
				strColumnHeader[3] = "Item Category";
				strColumnHeader[4] = "Delivery Location";
			}
		}
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		String[] strComboQry = new String[4];
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		/*
		strComboQry[0] = "SELECT HSTNUM_STORE_ID, INITCAP(HSTSTR_STORE_NAME)"
				+ " AS STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_ISVALID = 1 "
				+ "AND GNUM_HOSPITAL_CODE = '" + strHospCode + "' AND "
				+ "GDT_EFFECTIVE_FRM <= TRUNC(SYSDATE) "+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				   // " AND P.gnum_hospital_code = q.gnum_hospital_code"+
				    " AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
				    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
				  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") ORDER BY INITCAP(HSTNUM_STORE_ID)";
				*/
		
		strComboQry[0] = "SELECT HSTNUM_STORE_ID, INITCAP(HSTSTR_STORE_NAME)  "+
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
		strComboQry[1]="SELECT SSTNUM_ITEM_CAT_NO , MMS_MST.get_itemcat_dtl(1 , GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO ) AS ITEM_CAT"
				+"	FROM HSTT_STORE_CATEGORY_MST WHERE GNUM_ISVALID = 1  and SSTNUM_ITEM_CAT_NO IN (select SSTNUM_ITEM_CAT_NO from sstt_item_category_mst where gnum_hospital_code = 100 and gnum_isvalid=1) AND GNUM_HOSPITAL_CODE ='"+ strHospCode +"'  AND HSTNUM_STORE_ID =#1#  ORDER BY ITEM_CAT"	;
				*/
		strComboQry[1] =  "select DISTINCT SSTNUM_ITEM_CAT_NO,INITCAP(MMS_MST.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO))CAT_NAME "
  		       + "from HSTT_STORE_CATEGORY_MST  where GNUM_ISVALID =1 " +
  		       "  AND HSTNUM_STORE_ID IN ( "+ 
				  "  SELECT GNUM_COLUMN_VALUE  "+    
				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
				  " WHERE P.gnum_metatable_id = 117 "+ 	      				
				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
				  " )ORDER BY CAT_NAME";
		
		strComboQry[2] = "SELECT   SSTNUM_INDENTTYPE_ID || '^' || SSTNUM_AUTHTYPE_ID,"
				+ " SSTSTR_INDENTTYPE_NAME"
				+ "  FROM SSTT_INDENTTYPE_MST A"
                   + " WHERE SSTNUM_REQ_FOR = 2"
                   + " AND GNUM_HOSPITAL_CODE = 100"
                 + "   AND GNUM_ISVALID = 1"
                 + "   AND EXISTS ("
                  + "  SELECT 'X'"
                  + "  FROM HSTT_STORE_REQTYPE_MST"
                  + "  WHERE GNUM_ISVALID = 1"
                  + "  AND GNUM_HOSPITAL_CODE ='"+ strHospCode+"'"
                  + "  AND SSTNUM_INDENTTYPE_ID = A.SSTNUM_INDENTTYPE_ID"
                  + "  AND SSTNUM_ITEM_CAT_NO = #2#"
                  + "  AND HSTNUM_STORE_ID =#1#) "
                  + "  ORDER BY SSTNUM_FILE_TYPE";
		
		strComboQry[3] = "1^Pending#3^In Process#2^Close";

		return strComboQry;
	}

	public String[] getRowStatus() 
	{
		
		//MmsConfigUtil mmscofigutil = new  MmsConfigUtil(strHospCode);
		/*
		 * "1"--->> Value Which we Want to Maaped        1         2    3   4   5    6       7
		 * "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->>
		 * "Exp Within"--->>Argument You Want to Show in Footer of Template
		 * 
		 */
		
      	String[] status = {"1", "8", "LightSlateGrey", ""};
		return status;
	}

	
	public String getViewQuery() {
		return "";
	}

	/*public String getButtons() {
		//String strButtons = "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png' style='cursor:pointer' border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return "";
	}*/

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
		String files = "../../mms/js/PODesk.js";
		return files;

	}

	/*public String[] getRowStatus() {
		String[] status = { "", "1", "brown", "PO Desk" };
		return status;
	}*/

	public String getEventState() {
		String str = "";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		String[] str = { "Generate@buttonClick('GENERATE')@1@3b5998@glyphicon-plus",//"Schedule@buttonClick('SCHEDULE')@1",  //commented by shalini as per priyesh sir feedback that schedule will not work
				"Cancel@buttonClick('CANCELPO')@1@bb0000@glyphicon-remove",
				"View@buttonClick('VIEW')@1@bb0000@glyphicon-remove",
				"Print@getReportPage(document.forms[0],'PRINT')@1@0c8d20@glyphicon-print",
				"Finalize PO@buttonClick('FINALIZEPO')@1@0c8d20@glyphicon-print"//,
				//"POModify@buttonClick('POMODIFY')@1@0c8d20@glyphicon-plus"
				};
		return str;
	}

	public String[] getDbButtons() {
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
		return "userDefinedOnLoadFunc";
	}

	public String[] getOrderBy() {
		String orderBy[] = {"2","PODATE","1","HSTNUM_PO_NO" };
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"GenerateOnDesk.png","ViewOnDesk.png","CancelOnDesk.png","ViewOnDesk.png","PrintOnDesk.png","UpdateOnDesk.png"};//,"GenerateOnDesk1.png"};
		// TODO Auto-generated method stub
		return str;
	}
}
