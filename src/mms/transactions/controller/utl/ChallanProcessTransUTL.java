package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;


/**
 * 
 * Developer : Balasubramaniam M
 * Version : 1.0 
 * Date : 12-Jun-2009
 * 
 */

public class ChallanProcessTransUTL extends TransInterface {
	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	/*
	 * public void setCombo(String[] arg0) { // TODO Auto-generated method stub
	 *  }
	 */

	// new
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;

	}

	public String getMasterName() {
		String masterName = "Challan Process";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();

		return viewHdr;
	}

public String getMainQuery(String cmb[]) {
		
		MmsConfigUtil mmsConfig = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		StringBuffer brMainQuery = new StringBuffer("");
		brMainQuery.append("SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.HSTNUM_ITEM_ID ||'@'|| ");
		brMainQuery.append("C.HSTNUM_ITEMBRAND_ID ||'@'|| C.GNUM_HOSPITAL_CODE ||'^'||C.HSTNUM_PO_NO ||'^' ||C.HSTNUM_SCHEDULE_NO ||'^'||C.HSTNUM_SCHEDULE_TYPE||'^'|| ");
		brMainQuery.append("C.ITEM_NAME||'^'||C.REC_QTY ");
		brMainQuery.append(" AS DATA FROM  ");
		brMainQuery.append("(SELECT  ");
		brMainQuery.append("A.HSTNUM_STORE_ID ,A.HSTNUM_CHALLAN_NO,A.HSTNUM_ITEM_ID,A.HSTNUM_ITEMBRAND_ID,A.GNUM_HOSPITAL_CODE, ");
		brMainQuery.append("A.HSTNUM_SCHEDULE_NO , DECODE(A.HSTNUM_SCHEDULE_TYPE , 1, 'Fresh Supply' , 2, 'Against Returned') AS HSTNUM_SCHEDULE_TYPE , Mms_Mst.GET_ITEM_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_ITEMBRAND_ID) AS ITEM_NAME, ");
		brMainQuery.append("A.HSTNUM_RECIEVED_QTY ||' '||Mms_Mst.GET_USER_NAME(A.GNUM_HOSPITAL_CODE,A.HSTNUM_RECIEVED_QTY_UNITID) AS REC_QTY ,  ");
		brMainQuery.append("B.HSTNUM_CHALLAN_STATUS, A.GNUM_ISVALID , A.HSTNUM_PO_NO , hstnum_verify_flag ");
		brMainQuery.append("FROM HSTT_CHALLAN_ITEM_DTL A , HSTT_CHALLAN_DTL B ");
		brMainQuery.append("WHERE  A.GNUM_ISVALID = B.GNUM_ISVALID ");
		brMainQuery.append("AND B.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE ");
		brMainQuery.append("AND B.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO ");
		brMainQuery.append("AND B.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ");
		brMainQuery.append(") C ");
		//brMainQuery.append("WHERE C.GNUM_ISVALID = 1 ");
		
		brMainQuery.append("WHERE C.hstnum_verify_flag <> 1 ");
		brMainQuery.append(" AND C.HSTNUM_PO_NO = 0");
		brMainQuery.append(" AND C.GNUM_HOSPITAL_CODE  = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
		//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 0");
		if (cmb != null) 
		{
					if (cmb[3].equals("1")) 
					{
						brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS != 2");
						brMainQuery.append(" AND C.GNUM_ISVALID > 0");
					} 
					else 
					{
						//freezed
						if (cmb[3].equals("2"))
						{
							brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 2");
							brMainQuery.append(" AND C.GNUM_ISVALID > 0");
						}
						else
						{
							//all
							brMainQuery.append(" AND C.GNUM_ISVALID > 0");
						}
					}	
		}

		if (cmb != null) 
		{
					if (cmb[1].equals("1")) 
					{
		
						brMainQuery = new StringBuffer("");
						brMainQuery.append("SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.HSTNUM_ITEM_ID ||'@'|| ");
						brMainQuery.append("C.HSTNUM_ITEMBRAND_ID ||'@'|| C.HSTNUM_SCHEDULE_NO ||'@'|| C.TOT_QTY ||'@'|| C.GNUM_HOSPITAL_CODE ||'^'||C.HSTNUM_PO_NO ||'^' ||C.HSTNUM_SCHEDULE_NO ||'^'||C.HSTNUM_SCHEDULE_TYPE||'^'|| ");
						brMainQuery.append("C.ITEM_NAME||'^'||C.REC_QTY ");
						brMainQuery.append("AS DATA FROM  ");
						brMainQuery.append("(SELECT  ");
						brMainQuery.append("A.HSTNUM_STORE_ID ,A.HSTNUM_CHALLAN_NO,A.HSTNUM_ITEM_ID,A.HSTNUM_ITEMBRAND_ID,A.GNUM_HOSPITAL_CODE,");
						brMainQuery.append("A.HSTNUM_SCHEDULE_NO , DECODE(A.HSTNUM_SCHEDULE_TYPE , 1, 'Fresh Supply' , 2, 'Against Returned') AS HSTNUM_SCHEDULE_TYPE , Mms_Mst.GET_ITEM_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_ITEMBRAND_ID) AS ITEM_NAME, ");
						brMainQuery.append("A.HSTNUM_RECIEVED_QTY ||' '||Mms_Mst.GETUNITNAME(A.GNUM_HOSPITAL_CODE,A.HSTNUM_RECIEVED_QTY_UNITID) AS REC_QTY ,  ");
						brMainQuery.append("B.HSTNUM_CHALLAN_STATUS, A.GNUM_ISVALID , A.HSTNUM_PO_NO  , (HSTNUM_ACCEPTED_QTY + HSTNUM_BREAKAGE_QTY + HSTNUM_REJECTED_QTY + HSTNUM_EXCESS_QTY) AS TOT_QTY , hstnum_verify_flag ");
						brMainQuery.append("FROM HSTT_CHALLAN_ITEM_DTL A , HSTT_CHALLAN_DTL B ");
						brMainQuery.append("WHERE  A.GNUM_ISVALID = B.GNUM_ISVALID ");
						brMainQuery.append("AND B.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE ");
						brMainQuery.append("AND B.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO ");
						brMainQuery.append("AND B.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ");
						brMainQuery.append(" AND A.HSTNUM_RECIEVED_QTY > 0 ");
						brMainQuery.append(") C ");
						//brMainQuery.append(" WHERE C.GNUM_ISVALID = 1 ");
						
						brMainQuery.append("WHERE  C.hstnum_verify_flag <> 1 ");
						brMainQuery.append(" AND C.HSTNUM_PO_NO = ").append(cmb[2].replace("^", "#").split("#")[0]);
						brMainQuery.append(" AND C.GNUM_HOSPITAL_CODE  = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
						//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 1");
						brMainQuery.append("  AND C.hstnum_store_id = ").append(cmb[0]);
						
						if (cmb[3].equals("1")) 
						{
							brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS != 2");
							brMainQuery.append(" AND C.GNUM_ISVALID > 0");
						} 
						else 
						{
							//freezed
							if (cmb[3].equals("2"))
							{
								brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 2");
								brMainQuery.append(" AND C.GNUM_ISVALID > 0");
							}
							else
							{
								//all
								brMainQuery.append(" AND C.GNUM_ISVALID > 0");
							}
						}	

			} 
			else 
			{

				brMainQuery = new StringBuffer("");
				
				brMainQuery.append(" SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.HSTNUM_ITEM_ID ||'@'|| ");
				brMainQuery.append(" C.HSTNUM_ITEMBRAND_ID ||'@'|| C.GNUM_HOSPITAL_CODE  ||'^'|| ");
				brMainQuery.append("  C.ITEM_NAME||'^'||C.HSTNUM_PO_NO||'/'||HSTNUM_SCHEDULE_NO||'^'||ACCEPTED_QTY ||'^'||BREAK_QTY ||'^'||REJECT_QTY  ||'^'||EXCESS_QTY ");
				brMainQuery.append(" AS DATA FROM ( SELECT   hstnum_store_id, hstnum_challan_no, hstnum_item_id, HSTNUM_ITEMBRAND_ID, ");
				brMainQuery.append("  gnum_hospital_code, mms_mst.get_item_dtl (1, gnum_hospital_code, hstnum_itembrand_id ");
				brMainQuery.append("  ) item_name, hstnum_accepted_qty || ' ' || mms_mst.getunitname (gnum_hospital_code, hstnum_accqty_unitid) ");
				brMainQuery.append("  AS accepted_qty, hstnum_breakage_qty || ' ' || mms_mst.getunitname (gnum_hospital_code, ");
				brMainQuery.append("  hstnum_breakqty_unitid ) AS break_qty, hstnum_rejected_qty || ' ' ");
				brMainQuery.append("  || mms_mst.getunitname (gnum_hospital_code, hstnum_rejqty_unitid) AS reject_qty, ");
				brMainQuery.append(" hstnum_excess_qty || ' ' || mms_mst.getunitname (gnum_hospital_code, ");
				brMainQuery.append(" hstnum_excessqty_unitid ) AS excess_qty, gnum_isvalid, hstnum_po_no , hstnum_verify_flag, ");
				brMainQuery.append(" hstnum_po_store_id , hstdt_recieved_date , HSTNUM_SCHEDULE_NO  FROM hstt_challan_item_dtl  WHERE gnum_isvalid = 1 ) C ");
				brMainQuery.append(" WHERE  C. hstnum_verify_flag = 1 ");
											
				if( cmb[2] != null && !cmb[2].equals("0"))
				{
					brMainQuery.append(" AND C.hstnum_po_no = ").append(cmb[2].replace("^", "#").split("#")[0]);
					brMainQuery.append("  AND C.hstnum_po_store_id =  ").append(cmb[2].replace("^", "#").split("#")[1]);
					
				}
				else
				{
					brMainQuery.append(" AND TRUNC(C.HSTDT_RECIEVED_DATE)  >= ahis_gbl_util.fun_str_date('"+mmsConfig.getStrFinancialStartDate(cmb[0],httpSession.getAttribute("HOSPITAL_CODE").toString())+"')  AND TRUNC(C.HSTDT_RECIEVED_DATE) <= ahis_gbl_util.fun_str_date('"+mmsConfig.getStrFinancialEndDate(cmb[0],httpSession.getAttribute("HOSPITAL_CODE").toString())+"') ");
				}
			    brMainQuery.append("  AND C.gnum_hospital_code = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
			    brMainQuery.append("  AND C.hstnum_store_id = ").append(cmb[0]);
			    
			    
			    if (cmb[3].equals("1")) 
				{
					//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS != 2");
			    	brMainQuery.append(" AND C.GNUM_ISVALID > 0");
				} 
				else 
				{
					//freezed
					if (cmb[3].equals("2"))
					{
						//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 2");
						brMainQuery.append(" AND C.GNUM_ISVALID > 0");
					}
					else
					{
						//all
						brMainQuery.append(" AND C.GNUM_ISVALID > 0");
					}
				}	
				
						    
			}

		}
		
		
		System.out.println("Main Query in ChallanProcessTransUTL:::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() {
		String[] search_field = new String[2];
		
		
		if (cmbVal != null && cmbVal[1].equals("2")) {
			search_field[0] = "1";
			search_field[1] = "C.ITEM_NAME";
			
			/*// the following values represent 1 >> dummy , 1 >> search in Combo (index 1) , [0 / 1 ] >> 0 : forward search 1 : reverse search , [/] >> prefix character , [/] >> suffix character   
			search_field[2] = "1^1^1^0^0";
			search_field[3] = "P.O. No.";*/

		}
		else
		{
			search_field[0] = "3";
			search_field[1] = "C.ITEM_NAME";
			
			/*// the following values represent 1 >> dummy , 1 >> search in Combo (index 1) , [0 / 1 ] >> 0 : forward search 1 : reverse search , [/] >> prefix character , [/] >> suffix character   
			search_field[2] = "1^1^1^0^0";
			search_field[3] = "P.O. No.";*/
		}

		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		//String[] strComboHeader = { "0^2", "Drug Warehouse Name", "0^0", "P.O. No.", "1","Status" };
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[8];
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			
			strComboHeader[2] = "1";
			strComboHeader[3] = "PO Status";
			
			strComboHeader[4] = "0^0";
			strComboHeader[5] = "PO No.";
			
			
		
			strComboHeader[6] = "1";
			strComboHeader[7] = "Challan Status";
			

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			
			strComboHeader[2] = "1";
			strComboHeader[3] = "PO Status";
			
			strComboHeader[4] = "0^0";
			strComboHeader[5] = "PO No.";
		
			strComboHeader[6] = "1";
			strComboHeader[7] = "Challan Status";
		}

		return strComboHeader;
	}

	
		public String[] getColumnHeader() 
		{
			String[] strColumnHeader; 

			if (cmbVal != null && cmbVal[1].equals("2")) 
			{
				strColumnHeader = new String[6];

				strColumnHeader[0] = "Item Name.";
				strColumnHeader[1] = "PO No/Schedule No";
				strColumnHeader[2] = "Accepted Qty.";
				strColumnHeader[3] = "Breakage Qty.";
				strColumnHeader[4] = "Rejected Qty.";
				strColumnHeader[5] = "Excess Qty.";

			}	
			else
			{
				strColumnHeader = new String[5];
				strColumnHeader[0] = "PO No";
				strColumnHeader[1] = "Schedule No";
				strColumnHeader[2] = "Supply Type";
				strColumnHeader[3] = "Item Name";
				strColumnHeader[4] = "Accepted Qty.";
			}
			return strColumnHeader;
		}

	public String[] getComboQuery() {
		
		String[] comboQuery = new String[4];
		/*
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="
				+ httpSession.getAttribute("HOSPITAL_CODE").toString()+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				    " AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
				    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
				  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		*/
		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID,INITCAP(HSTSTR_STORE_NAME)  "+
				  " AS STORE_NAME FROM HSTT_STORE_MST A  "+
				  "  WHERE GNUM_ISVALID = 1 "+
				  "  AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+""+ 			  
				  "  AND HSTNUM_STORE_ID IN ( "+ 
				  "  SELECT GNUM_COLUMN_VALUE  "+    
				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
				  " WHERE P.gnum_metatable_id = 117 "+ 	    
				  " AND P.gnum_hospital_code = A.gnum_hospital_code "+     
				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
				  " )ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		System.out.println("Store Query:::"+comboQuery[0]);
	
				
		comboQuery[1] = "1^Active#2^Closed";
		if (cmbVal != null ) 
		{
			
		comboQuery[2] = "SELECT HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID,HSTNUM_PO_NO FROM SSTT_PO_DTL A WHERE A.GNUM_ISVALID in (1,4)  AND  A.HSTNUM_PO_STATUS = 1 AND A.HSTNUM_DELIVERY_LOCATION = #1# "
				+" AND A.GNUM_HOSPITAL_CODE = "	+ httpSession.getAttribute("HOSPITAL_CODE").toString()	+ " AND EXISTS "
				+ " (SELECT 'X' FROM HSTT_PO_SCHEDULE_DTL WHERE  GNUM_ISVALID in(1,4) AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE "
				+ " AND HSTNUM_SCHEDULE_STATUS IN (decode(#2#,1,1,99),2,decode(#2#,2,3,3,3,99)) AND HSTNUM_PO_NO = A.HSTNUM_PO_NO AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ) order by HSTNUM_PO_NO";
		
		if(cmbVal[1].equals("1"))
        comboQuery[3] = "1^In-Process#2^Closed#3^All" ;
        else
        comboQuery[3] = "2^Closed#3^All" ;
		
		}
		else
		{
		comboQuery[2] = "SELECT HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID,HSTNUM_PO_NO FROM SSTT_PO_DTL A WHERE A.GNUM_ISVALID in (1,4)  AND  A.HSTNUM_PO_STATUS = 1 AND A.HSTNUM_DELIVERY_LOCATION = #1# "
					+" AND A.GNUM_HOSPITAL_CODE = "	+ httpSession.getAttribute("HOSPITAL_CODE").toString()	+ " AND EXISTS "
					+ " (SELECT 'X' FROM HSTT_PO_SCHEDULE_DTL WHERE  GNUM_ISVALID in(1,4) AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE "
					+ " AND HSTNUM_SCHEDULE_STATUS IN (decode(#2#,1,1,99),2,decode(#2#,2,3,3,3,99)) AND HSTNUM_PO_NO = A.HSTNUM_PO_NO AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ) order by HSTNUM_PO_NO";
		
		comboQuery[3] = "1^In-Process#2^Closed#3^All" ;
		}
		
		System.out.println("PO Query:::"+comboQuery[2]);
		
			
		return comboQuery;

	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {

		return "";
	}

	public String[] getDeleteQuery() {

		String deleteQuery[] = { "" };
		return deleteQuery;
	}

	public List<String[]> getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];

		List<String[]> deleteData = new ArrayList<String[]>();

		// a[0] >> key, a[1] >> extra info
		a = (chk.replace('|', '#')).split("#");
		// split key
		b = (a[0].replace('@', '#')).split("#");

		key[0] = b[0];

		deleteData.add(key);
		// deleteData.add(null);
		// deleteData.add(key);

		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/mms_trans.js";

		return files;

	}

	public String[] getRowStatus() 
	{
		String[] strRowStatus = new String[0];
		return strRowStatus;
	}

	public String getEventState() 
	{
		String str = "chkUserDefinedChallanProcessFunc";
		return str;
	}

	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	public String[] getUserDefinedButtons() {

		String[] strButtons = {
				"Receive@validateChallan(document.forms[0],'RECEIVECHL')@1@ea4c89@glyphicon-share",//1 to disable n 0 to enable by default
				"Cancel@validateChallan(document.forms[0],'CANCELCHL')@1@bb0000@glyphicon-remove",
				"Verify@validateChallan(document.forms[0],'VERIFYCHL');@1@00aced@glyphicon-check" ,
		        "View&Print@validateChallan(document.forms[0],'VIEWCHL')@1@009487@glyphicon-print" };
		return strButtons;

	}

	public String[] getDbButtons() {
		// TODO Auto-generated method stub
		// String[] str={"1"};
		return null;
	}

	public int getMinPanelButton() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * Frames option will not work (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getMenuOption()
	 */

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	@Override
	public String getComboEventState() {
		return "chkUserDefinedChallanProcessFunc";
	}

	// new features
	public String[] getOrderBy() {
		String orderBy[] = { "3", "C.ITEM_NAME" };

		if (cmbVal != null && cmbVal[1].equals("2")) {

			orderBy = new String[2];

			orderBy[0] = "1";
			orderBy[1] = "C.ITEM_NAME";

		}

		return orderBy;
	}

@Override
	public String[] getButtonIcons() {
		String[] str={"ReceiveOnDesk.png","CancelOnDesk.png","ApprovalOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	
	
}
