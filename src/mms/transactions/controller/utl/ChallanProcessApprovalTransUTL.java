package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
import hisglobal.utility.HisUtil;


/**
 * 
 * Developer : Balasubramaniam M
 * Version : 1.0 
 * Date : 12-Jun-2009
 * 
 */

public class ChallanProcessApprovalTransUTL extends TransInterface {
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
		String masterName = "Challan Approval Process";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();

		return viewHdr;
	}

	public String getMainQuery(String cmb[]) 
	{
		
		//MmsConfigUtil mmsConfig = new MmsConfigUtil("");
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
		
		StringBuffer brMainQuery = new StringBuffer("");
								
		brMainQuery.append(" SELECT   C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.GNUM_HOSPITAL_CODE "
				+ "|| '^'||C.HSTNUM_CHALLAN_NO || '^'|| to_char(C.DT,'dd-Mon-yyyy') || '^' || C.SUPP ||'^'|| C.ITM ||'^'||C.PO_DATE FROM (SELECT DISTINCT HSTNUM_CHALLAN_NO,HSTNUM_PO_NO,HSTNUM_STORE_ID,GNUM_HOSPITAL_CODE,HSTDT_CHALLAN_DATE AS DT,"
				+ "MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID) AS SUPP,"
				+ "(SELECT COUNT(HSTNUM_ITEMBRAND_ID) FROM HSTT_CHALLAN_ITEM_DTL CID "
				+ "WHERE CID.GNUM_HOSPITAL_CODE = CD.GNUM_HOSPITAL_CODE AND CID.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID "
				+ "AND CID.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO) ITM , MMS_MST.GET_ITEMCAT_DTL (1, GNUM_HOSPITAL_CODE, LEFT(HSTNUM_PO_NO,2)::varchar)||' - '||HSTNUM_PO_NO||' ( '||to_char(HSTDT_PO_DATE, 'dd-Mon-yyyy')||' )' AS PO_DATE  "
				+ "FROM HSTT_CHALLAN_DTL CD WHERE GNUM_ISVALID = 1 "
				+ "AND CD.HSTNUM_CHALLAN_NO IN ( SELECT HSTNUM_CHALLAN_NO "
				+ "FROM HSTT_CHALLAN_ITEM_DTL ICD WHERE ICD.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO "
				+ "AND ICD.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID AND  ICD.HSTDT_FREEZE_DATE IS NULL "
				+ "AND HSTNUM_FREEZE_SEATID IS NULL)) C WHERE   HSTNUM_PO_NO = 0 ");
		brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
		brMainQuery.append(" AND HSTNUM_STORE_ID = 0 ");   

		if (cmb != null) 
		{
			//cmb[2] is replaced by cmb[1]
			if (cmb[1].equals("1") && !cmb[0].equals("0")) 	//	Active
			{
				//System.out.println("When Status is Active==>"+cmb[1]);

				brMainQuery = new StringBuffer("");
				
				
				brMainQuery.append(" SELECT   C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.GNUM_HOSPITAL_CODE "
						+ "|| '^'||C.HSTNUM_CHALLAN_NO || '^'|| to_char(C.DT,'dd-Mon-yyyy') || '^' || C.SUPP ||'^'|| "
						+ "C.ITM ||'^'||C.PO_DATE FROM (SELECT DISTINCT HSTNUM_CHALLAN_NO,HSTNUM_PO_NO,HSTNUM_STORE_ID,GNUM_HOSPITAL_CODE,hstnum_po_store_id,HSTDT_CHALLAN_DATE AS DT,"
						+ "MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID) AS SUPP,(SELECT COUNT(HSTNUM_ITEMBRAND_ID) "
						+ "FROM HSTT_CHALLAN_ITEM_DTL CID WHERE CID.GNUM_HOSPITAL_CODE = CD.GNUM_HOSPITAL_CODE AND CID.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID "
						+ "AND CID.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO) ITM , MMS_MST.GET_ITEMCAT_DTL (1, GNUM_HOSPITAL_CODE, LEFT(HSTNUM_PO_NO,2)::varchar)||' - '||HSTNUM_PO_NO||' ( '||to_char(HSTDT_PO_DATE, 'dd-Mon-yyyy')||' ) ' AS PO_DATE  FROM HSTT_CHALLAN_DTL CD WHERE GNUM_ISVALID = 1 "
						+ "AND CD.HSTNUM_CHALLAN_NO IN ( SELECT HSTNUM_CHALLAN_NO FROM HSTT_CHALLAN_ITEM_DTL ICD WHERE ICD.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO "
						+ "AND ICD.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID AND  ICD.HSTDT_FREEZE_DATE IS NULL AND HSTNUM_FREEZE_SEATID IS NULL)) C "
						+ "WHERE C.HSTNUM_CHALLAN_NO <> 0 ");							
				if( cmb[2] != null && !cmb[2].equals("0")){
					brMainQuery.append(" AND C.hstnum_po_no = ").append(cmb[2].replace("^", "#").split("#")[0]);
					//brMainQuery.append("  AND C.hstnum_po_store_id =  ").append(cmb[2].replace("^", "#").split("#")[1]);
					
				}else{
					
					brMainQuery.append(" AND TRUNC(C.DT)  BETWEEN TO_DATE('"+strFinancialStartDate+"','dd-Mon-yyyy') AND TO_DATE('"+strFinancialEndDate+"','dd-Mon-yyyy') ");
					
				}			 
			    brMainQuery.append("  AND C.gnum_hospital_code = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
			    brMainQuery.append("  AND C.hstnum_store_id = ").append(cmb[0]);			    		
			}
			
			else if (cmb[1].equals("2") && !cmb[0].equals("0")) 	//	Approved
			{
				//System.out.println("When Status is Approved==>"+cmb[1]);
				brMainQuery = new StringBuffer("");
				
				brMainQuery.append(" SELECT   C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| "
						+ "C.GNUM_HOSPITAL_CODE || '^'||C.HSTNUM_CHALLAN_NO || '^'|| to_char(C.DT,'dd-Mon-yyyy') "
						+ "|| '^' || C.SUPP ||'^'|| C.ITM||'^'||C.PO_DATE FROM (SELECT DISTINCT HSTNUM_CHALLAN_NO,HSTNUM_PO_NO,HSTNUM_STORE_ID,GNUM_HOSPITAL_CODE,hstnum_po_store_id,"
						+ "HSTDT_CHALLAN_DATE AS DT,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID) AS SUPP,"
						+ "(SELECT COUNT(HSTNUM_ITEMBRAND_ID) FROM HSTT_CHALLAN_ITEM_DTL CID WHERE CID.GNUM_HOSPITAL_CODE = CD.GNUM_HOSPITAL_CODE "
						+ "AND CID.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID AND CID.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO) ITM , MMS_MST.GET_ITEMCAT_DTL (1, GNUM_HOSPITAL_CODE, LEFT(HSTNUM_PO_NO,2)::varchar)||' - '||HSTNUM_PO_NO||' ( '||to_char(HSTDT_PO_DATE, 'dd-Mon-yyyy')||' ) ' AS PO_DATE "
						+ "FROM HSTT_CHALLAN_DTL CD WHERE GNUM_ISVALID = 1 AND CD.HSTNUM_CHALLAN_NO IN ( SELECT HSTNUM_CHALLAN_NO "
						+ "FROM HSTT_CHALLAN_ITEM_DTL ICD WHERE ICD.HSTNUM_CHALLAN_NO = CD.HSTNUM_CHALLAN_NO AND ICD.HSTNUM_STORE_ID = CD.HSTNUM_STORE_ID "
						+ "AND  ICD.HSTDT_FREEZE_DATE IS NOT NULL AND HSTNUM_FREEZE_SEATID IS NOT NULL)) C WHERE C.HSTNUM_CHALLAN_NO <> 0 ");							
				if( cmb[2] != null && !cmb[2].equals("0")){
					brMainQuery.append(" AND C.hstnum_po_no = ").append(cmb[2].replace("^", "#").split("#")[0]);
					//brMainQuery.append("  AND C.hstnum_po_store_id =  ").append(cmb[2].replace("^", "#").split("#")[1]);
					
				}else{
					
					brMainQuery.append(" AND TRUNC(C.DT)  BETWEEN TO_DATE('"+strFinancialStartDate+"','dd-Mon-yyyy') AND TO_DATE('"+strFinancialEndDate+"','dd-Mon-yyyy') ");
					
				}			 
			    brMainQuery.append("  AND C.gnum_hospital_code = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
			    brMainQuery.append("  AND C.hstnum_store_id = ").append(cmb[0]);	
			
			}
		}
		
		System.out.println("Challan Approval desk [ ChallanProcessApprovalTransUTL ]-- "+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() {
		String[] search_field = { "1", "C.HSTNUM_CHALLAN_NO" };

//		if (cmbVal != null && cmbVal[2].equals("2")) {
//
//			search_field = new String[2];
//
//			search_field[0] = "1";
//			search_field[1] = "C.ITEM_NAME";
//
//		}

		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() {
		String[] strComboHeader = { "0^2", "Store Name", "1","Status" ,"0^0", "P.O. No."};

		return strComboHeader;
	}

	public String[] getColumnHeader() {
		
		//String[] strColumnHeader = { "Item Name", "Received Qty.","Schedule No.", "Schedule Type" };
		String[] strColumnHeader = { "Challan No.", "Challan Date", "Supplier", "No. of Items" , "PO Dtl" };
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		String[] comboQuery = new String[3];
		/*
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="
				+ httpSession.getAttribute("HOSPITAL_CODE").toString()+
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
				") ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		*/
		
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where GNUM_ISVALID = 1 and "
				+ "    GNUM_HOSPITAL_CODE ="+httpSession.getAttribute("HOSPITAL_CODE").toString()+	
		"AND HSTNUM_STORE_ID IN "+ 
	     " (  "+
			  "  SELECT GNUM_COLUMN_VALUE "+      
			  " FROM GBLT_ROLE_SEAT_TABLE_DTL P  "+     
			  " WHERE P.gnum_metatable_id = 117  "+ 	    
			  " AND P.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+ ""+      
			  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual )  "+ 
	     " )"+ 
	      "ORDER BY INITCAP(HSTSTR_STORE_NAME)";
				
		
		comboQuery[1] = "0^Select Value#1^Active#2^Approved";
		
		/*
		comboQuery[2] = "SELECT HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID||'^'||hstdt_po_date, A.HSTNUM_PO_NO||' ( '||to_char(A.HSTDT_PO_DATE, 'dd-Mon-yyyy')||' )' FROM SSTT_PO_DTL A WHERE A.GNUM_ISVALID in (1,4) and sstnum_potype_id <> 87  AND  A.HSTNUM_PO_STATUS in (1,2) "
				+ "AND A.HSTNUM_DELIVERY_LOCATION = #1#  "
				+ "AND A.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND EXISTS "
				+ " (SELECT 'X' FROM HSTT_PO_SCHEDULE_DTL WHERE  GNUM_ISVALID in (1,4) AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE "
				+ " AND HSTNUM_SCHEDULE_STATUS IN  (2,3)  AND HSTNUM_PO_NO = A.HSTNUM_PO_NO AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ) "
				+ "	AND EXISTS" 
				+ " ( SELECT 'X'" 
				+ " FROM HSTT_CHALLAN_ITEM_DTL" 				
				+ " WHERE HSTNUM_STORE_ID = A.hstnum_delivery_location "
				+ " AND HSTNUM_PO_NO = A.HSTNUM_PO_NO " 			
				+ ")  order by hstdt_po_date,HSTNUM_PO_NO";  
				*/
		comboQuery[2] = " SELECT HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID||'^'||hstdt_po_date, A.HSTNUM_PO_NO||' ( '||to_char(A.HSTDT_PO_DATE, 'dd-Mon-yyyy')||' )' "
				+ "FROM HSTT_CHALLAN_DTL A "
				+ "WHERE A.GNUM_ISVALID = 1 "
				+ "AND A.HSTNUM_STORE_ID = #1#  "
				+ "AND A.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND EXISTS "
				+ " ( "
				+ " SELECT 'X' FROM HSTT_PO_SCHEDULE_DTL WHERE  "
				+ "GNUM_ISVALID in (1,4) "
				+ " AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE  " 
				+ " AND HSTNUM_SCHEDULE_STATUS IN  (2,3)  " 
		        + " AND HSTNUM_PO_NO = A.HSTNUM_PO_NO  "
				+ " AND HSTNUM_STORE_ID = A.hstnum_po_store_id  "
				+ " )  " 	
				+ " AND A.HSTNUM_CHALLAN_NO IN "
				+ " ( "
				+ " SELECT HSTNUM_CHALLAN_NO FROM " 
				+ "  HSTT_CHALLAN_ITEM_DTL ICD " 
				+ "  WHERE " 
				+ "  ICD.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO " 
				+ "  AND ICD.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID " 
				+ "  AND ICD.HSTDT_FREEZE_DATE IS NULL " 
				+ "  AND HSTNUM_FREEZE_SEATID IS NULL "
				+ ")  order by hstdt_po_date,HSTNUM_PO_NO"; 
         System.out.println("PO Combo Query==>"+comboQuery[2]);

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
		String files = "../../mms/js/challanApprovalDesk.js";

		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "Autrin Cap", "2", "brown", "Expired" };
		return status;
	}

	public String getEventState() {
		String str = "chkUserDefinedChallanProcessFunc";
		return str;
	}

	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	public String[] getUserDefinedButtons() {

		String[] strButtons = {
				"Approve@validateChallan(document.forms[0],'FREEZE');@1@00aced@glyphicon-check" ,
				"View@validateChallan(document.forms[0],'VIEWCHL')@0@007bb6@glyphicon-fullscreen" ,
				"Print@printChallan()@1@0c8d20@glyphicon-print" };
		
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
		return "";
	}

	// new features
	public String[] getOrderBy() {
		String orderBy[] = { "1", "C.HSTNUM_CHALLAN_NO" };

//		if (cmbVal != null && cmbVal[2].equals("2")) {
//
//			orderBy = new String[2];
//
//			orderBy[0] = "1";
//			orderBy[1] = "C.HSTNUM_PO_NO";
//
//		}

		return orderBy;
	}

	@Override
	public String[] getButtonIcons() {
		String[] str={"ApprovalOnDesk.png","ViewOnDesk.png","PrintOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
}
