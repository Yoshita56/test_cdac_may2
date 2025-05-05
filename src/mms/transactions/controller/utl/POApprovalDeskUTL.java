/**
 * 
 */
package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;


public class POApprovalDeskUTL extends TransInterface {

	
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
		String masterName = "PO Approval Desk";
		return masterName;
	}

	public int getRecord_per_page() {
		return 12;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) 
	{
		String strHospCode           = (String) httpSession.getAttribute("HOSPITAL_CODE");
		StringBuffer brMainQuery     = new StringBuffer(1500);
		MmsConfigUtil mmsConfig      = new MmsConfigUtil(strHospCode);	
		
		brMainQuery.append("SELECT HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
				"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX|| '^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id) || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| TOT_ITEM  " +
				"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
				"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
				"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
				" ROUND(HSTNUM_PO_NET_AMOUNT,2) AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
				"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT ," +
				"(  SELECT COUNT(HSTNUM_ITEMBRAND_ID) FROM HSTT_PO_ITEM_DTL   WHERE GNUM_ISVALID = 1" +
				" AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO" +
				"   AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ) AS TOT_ITEM," +
				" ( SELECT NVL(SUM((HSTNUM_ACCEPTED_QTY * HSTNUM_saleprice) / MMS_MST.GETUNIT_CONV_VALUE(HSTNUM_saleprice_UNITID,HSTNUM_ACCEPTEDQTY_UNITID,GNUM_HOSPITAL_CODE)),0)" +
				"  FROM HSTT_CHALLAN_VERIFIEDITEM_DTL  WHERE GNUM_ISVALID = 1  AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE" +
				"  AND HSTNUM_PO_STORE_ID = B.HSTNUM_STORE_ID  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO   ) AS SUPP_VALUE ,SSTSTR_PO_PREFIX ");
		brMainQuery.append(" FROM SSTT_PO_DTL B ");
		brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0 AND HSTSTR_APPROVED_BY IS NULL");
		if(cmb != null)
		{	
			if(cmb[1].equals("1"))   // Pending
			{
				brMainQuery = new StringBuffer(1500);
				brMainQuery.append("SELECT    HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
						"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX|| '^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id) || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| TOT_ITEM  " +
						"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
						"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
						"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
						" ROUND(HSTNUM_PO_NET_AMOUNT,2) AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
						"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT , " +
						"(  SELECT COUNT(DISTINCT HSTNUM_ITEMBRAND_ID) FROM HSTT_PO_ITEM_DTL   WHERE GNUM_ISVALID = 1" +
						" AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO" +
						"   AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ) AS TOT_ITEM," +
						" ROUND(( SELECT NVL(SUM((HSTNUM_ACCEPTED_QTY * HSTNUM_saleprice) / MMS_MST.GETUNIT_CONV_VALUE(HSTNUM_saleprice_UNITID,HSTNUM_ACCEPTEDQTY_UNITID,GNUM_HOSPITAL_CODE)),0)" +
						"  FROM HSTT_CHALLAN_VERIFIEDITEM_DTL  WHERE GNUM_ISVALID = 1  AND GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE" +
						"  AND HSTNUM_PO_STORE_ID = B.HSTNUM_STORE_ID  AND HSTNUM_PO_NO = B.HSTNUM_PO_NO   ),2) AS SUPP_VALUE ,SSTSTR_PO_PREFIX ");		
				

				brMainQuery.append("FROM SSTT_PO_DTL B ");
				brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0 AND HSTSTR_APPROVED_BY IS NULL");
			}
			else
			{
				if(cmb[1].equals("2"))  // Closed
				{
					brMainQuery = new StringBuffer(1500);
					brMainQuery.append("SELECT    HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
							"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX||'^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id)|| '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| ITEMCAT  " +
							"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
							"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
							"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
							" HSTNUM_PO_NET_AMOUNT AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
							"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT ,SSTSTR_PO_PREFIX  ");
				    brMainQuery.append(" FROM HSTT_PO_DTL B ");
				    brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0");
				}
				else
				{
					if(cmb[1].equals("3")) // In-Process
					{
						brMainQuery = new StringBuffer(1500);
						brMainQuery.append("SELECT    HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
								"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX||'^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id) || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| ITEMCAT  " +
								"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
								"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
								"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
								" HSTNUM_PO_NET_AMOUNT AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
								"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT ,SSTSTR_PO_PREFIX  ");
					    brMainQuery.append(" FROM SSTT_PO_DTL B ");
					    brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0  AND HSTSTR_APPROVED_BY IS NOT NULL");
					}
					
					else
					{	
						if(cmb[1].equals("4"))  // Rejected
						{	
							
							String strFinancialStartDate = mmsConfig.getStrFinancialStartDate(cmb[0], strHospCode);
							String strFinancialEndDate   = mmsConfig.getStrFinancialEndDate(cmb[0], strHospCode);
							//System.out.println("strFinancialStartDate==>"+strFinancialStartDate);
							//System.out.println("strFinancialEndDate==>"+strFinancialEndDate);
							
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("SELECT    HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
									"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX||'^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id) || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| ITEMCAT  " +
									"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
									"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
									"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
									" HSTNUM_PO_NET_AMOUNT AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
									"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT ,SSTSTR_PO_PREFIX  ");
						    brMainQuery.append(" FROM SSTT_PO_DTL B ");
						    brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0  AND hstnum_reject_flag = 1 ");
												
						}
						else
						{
							if(cmb[1].equals("5"))  // Approved
							{
								brMainQuery = new StringBuffer(1500);
								brMainQuery.append("SELECT    HSTNUM_STORE_ID || '@'|| HSTNUM_PO_NO || '@'|| GNUM_HOSPITAL_CODE || '@'|| SSTNUM_POTYPE_ID || '@'|| " +
										"SSTNUM_ITEM_CAT_NO || '@'|| TOTSCHED||'@'||SSTSTR_PO_PREFIX||'^'|| mms_mst.get_indenttype_name(1,gnum_hospital_code,sstnum_potype_id) || '^'|| HSTNUM_PO_NO || '^'|| PODATE || '^'|| PO_NET_AMOUNT || '^'|| SUPPLIER || '^'|| ITEMCAT  " +
										"AS DATA FROM (SELECT (SELECT COUNT (*) FROM HSTT_PO_SCHEDULE_DTL WHERE GNUM_ISVALID = B.GNUM_ISVALID AND " +
										"GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE AND HSTNUM_PO_NO = B.HSTNUM_PO_NO AND HSTNUM_STORE_ID = B.HSTNUM_STORE_ID) AS TOTSCHED, " +
										"SSTNUM_POTYPE_ID,SSTNUM_ITEM_CAT_NO,HSTNUM_STORE_ID, HSTNUM_PO_NO, GNUM_HOSPITAL_CODE, TO_CHAR (HSTDT_PO_DATE, 'DD-Mon-yyyy') AS PODATE, " +
										" HSTNUM_PO_NET_AMOUNT AS PO_NET_AMOUNT, MMS_MST.GET_SUPP_DTL (1, GNUM_HOSPITAL_CODE, HSTNUM_SUPPLIER_ID ) AS SUPPLIER, " +
										"MMS_MST.GET_ITEMCAT_DTL (1,GNUM_HOSPITAL_CODE, SSTNUM_ITEM_CAT_NO ) AS ITEMCAT ,SSTSTR_PO_PREFIX  ");
							    brMainQuery.append(" FROM SSTT_PO_DTL B ");
							    brMainQuery.append("WHERE GNUM_ISVALID = 1 AND HSTNUM_CANCEL_FLAG = 0  AND HSTSTR_APPROVED_BY IS NOT NULL  AND hstnum_reject_flag = 0");
							}
						}
						
					}
				}	
			}
		}				
		if (cmb != null) 
		{
			String strFinancialStartDate = mmsConfig.getStrFinancialStartDate(cmb[0], strHospCode);
			String strFinancialEndDate = mmsConfig.getStrFinancialEndDate(cmb[0], strHospCode);
			brMainQuery.append(" AND HSTNUM_STORE_ID = ");
			brMainQuery.append(cmb[0]);
			if(cmb[1].equals("1"))
			{	
				brMainQuery.append(" AND HSTNUM_RECIEVE_FLAG = 0 ");
				brMainQuery.append(" AND HSTNUM_PO_STATUS = 1 ");
				brMainQuery.append(") A ");
			    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
			    brMainQuery.append(strHospCode);
			}	
			else 
			{
				if(cmb[1].equals("3"))
				{
				brMainQuery.append(" AND HSTNUM_RECIEVE_FLAG = 1 ");	
				brMainQuery.append(" AND HSTNUM_PO_STATUS = 1 ");
				brMainQuery.append(") A ");
			    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
			    brMainQuery.append(strHospCode);
				}
			    else
			    {	
			    	if(cmb[1].equals("2"))
				    {
					
					brMainQuery.append(" AND HSTNUM_PO_STATUS = 2 ");
					brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = TO_DATE('");
					brMainQuery.append(strFinancialStartDate);
					brMainQuery.append("','dd-Mon-yyyy') AND HSTDT_FINANCIAL_END_DATE = TO_DATE('");
					brMainQuery.append(strFinancialEndDate);
					brMainQuery.append("','dd-Mon-yyyy')");
					brMainQuery.append(" AND 1 = 2");
				    brMainQuery.append(") A ");
				    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
				    brMainQuery.append(strHospCode);
				    }
			    	else
			    	{
			    		if(cmb[1].equals("5"))
						{	
							brMainQuery.append(" AND HSTNUM_RECIEVE_FLAG = 0 ");							
							brMainQuery.append(") A ");
						    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
						    brMainQuery.append(strHospCode);
						}
			    		else
			    		{	
			    			if(cmb[1].equals("4"))
							{													
								brMainQuery.append(") A ");
							    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
							    brMainQuery.append(strHospCode);
							}
			    			else
			    			{	
				    		 brMainQuery.append(" AND HSTNUM_PO_STATUS = 1 ");
							 brMainQuery.append(" AND 1 = 2");
						     brMainQuery.append(") A ");
						     brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
						     brMainQuery.append(strHospCode);
			    			} 
				    		
			    		}
			    	}	
			    }
		    }
		}
		else
		{	
			
			brMainQuery.append(" AND 1 = 2");
		    brMainQuery.append(") A ");
		    brMainQuery.append("WHERE GNUM_HOSPITAL_CODE = ");
		    brMainQuery.append(strHospCode);
		}   
		  // System.out.println("PO Approval Desk Main Query:::==>"+brMainQuery.toString());
		    
		return brMainQuery.toString();
	}

	public String[] getSearchField() {
		String search_field[] = { "1", "SSTSTR_PO_PREFIX", "2", "HSTNUM_PO_NO", "5", "SUPPLIER"};
		return search_field;
	}
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		//String[] strComboHeader = { "0^2", "Drug Warehouse Name", "1","&nbsp; PO Status" };
		String strHospCode           = (String) httpSession.getAttribute("HOSPITAL_CODE");
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(strHospCode);	
		String[] strComboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "PO Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "1";
			strComboHeader[3] = "PO Status";

		}

		
		
		
		return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		
		String[] strColumnHeader = new String[6];
		//String[] strColumnHeader = { "PO No.", "PO Date", "PO Value","Supplier Name", "No. of Items" };
		strColumnHeader[0] =  "PO Type";
		strColumnHeader[1] =  "PO No";
		strColumnHeader[2] =  "PO Date";
		strColumnHeader[3] =  "PO Value";
		strColumnHeader[4] =  "Supplier Name";
		strColumnHeader[5] =  "No of Items";
		
		if(cmbVal != null)
		{
			
			if(cmbVal[1].equals("1"))
			{
				strColumnHeader[0] =  "PO Type";
				strColumnHeader[1] =  "PO No";
				strColumnHeader[2] =  "PO Date";
				strColumnHeader[3] =  "PO Value";
				strColumnHeader[4] =  "Supplier Name";
				strColumnHeader[5] =  "No of Items";
				
			}
			else
			{
				if(cmbVal[1].equals("3"))
				{
					strColumnHeader[0] =  "PO Type";
					strColumnHeader[1] =  "PO No";
					strColumnHeader[2] =  "PO Date";
					strColumnHeader[3] =  "PO Value";
					strColumnHeader[4] =  "Supplier Name";
					strColumnHeader[5] =  "Supplied Value";
					
				}
				else
				{	
					strColumnHeader[0] =  "PO Type";
					strColumnHeader[1] =  "PO No";
					strColumnHeader[2] =  "PO Date";
					strColumnHeader[3] =  "PO Value";
					strColumnHeader[4] =  "Supplier Name";
					strColumnHeader[5] =  "No of Items";
				}
			}
		}
		
		
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		String[] strComboQry = new String[2];
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		strComboQry[0] = "SELECT HSTNUM_STORE_ID, INITCAP(HSTSTR_STORE_NAME)"
				+ " AS STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_ISVALID = 1 "
				+ "AND GNUM_HOSPITAL_CODE = '" + strHospCode + "' "+
				/*" AND GDT_EFFECTIVE_FRM <= TRUNC(SYSDATE) "+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				    " AND P.gnum_hospital_code = q.gnum_hospital_code"+
				    " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
				    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
				  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") */ "ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		strComboQry[1] = "1^Pending#5^Approved#3^In Process#2^Closed#4^Rejected";
		return strComboQry;
	}

	public String getViewQuery() {
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
		String files = "../../mms/js/PODeskApproval.js";
		//String files = "../../mms/js/IndentTrans.js";
		return files;

	}

	/*public String[] getRowStatus() {
		String[] status = { "", "1", "brown", "PO Desk" };
		return status;
	}*/

	public String getEventState() {
		String strEvent = "chkUserDefinedFunc";
		return strEvent;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() 
	{
		String[] str = { "Approval@buttonLogicsOnClick1(1,'APPROVAL','Approval')@1@00aced@glyphicon-check",
				"Print@buttonLogicsOnClickPrint(5,'PRINT','Print')@1@0c8d20@glyphicon-print"};
		return str;
	}
	//buttonLogicsOnClick1(1,'ADD','Add')

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
		return "";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "3", "AHIS_FUNCTION.FUN_STR_DATE(PODATE)"};
		return orderBy;
	}		
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"ApprovalOnDesk.png","PrintOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
}
