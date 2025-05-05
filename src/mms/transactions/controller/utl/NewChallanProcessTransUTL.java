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

public class NewChallanProcessTransUTL extends TransInterface {
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
		brMainQuery.append("SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.HSTNUM_PO_NO || '@'|| C.HSTNUM_PO_STORE_ID ||'@'||  C.GNUM_HOSPITAL_CODE ||'^'||C.HSTNUM_PO_NO|| '^' || C.PO_DATE || '^' || DECODE( SUBSTR(C.HSTNUM_PO_NO,3,2),22,'Local PO',87,");
		brMainQuery.append(" 'Local PO(Patient)',21,'Bulk PO','-') || '^' ||  MMS_MST.GET_SUPP_DTL(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID)  ||'^' ||C.HSTNUM_CHALLAN_NO || '^' || CNT AS DATA FROM  ");
		brMainQuery.append("(SELECT  A.HSTNUM_STORE_ID ,A.HSTNUM_CHALLAN_NO,A.GNUM_HOSPITAL_CODE, A.HSTNUM_SCHEDULE_NO , DECODE(A.HSTNUM_SCHEDULE_TYPE , 1, 'FRESH SUPPLY' , 2, 'AGAINST RETURNED') AS HSTNUM_SCHEDULE_TYPE ,  ");
		brMainQuery.append("A.HSTNUM_CHALLAN_STATUS, A.GNUM_ISVALID , A.HSTNUM_PO_NO,hstnum_po_store_id , TO_CHAR(A.HSTDT_PO_DATE,'DD-MON-YYYY') AS PO_DATE,HSTNUM_SUPPLIER_ID , SSTNUM_ITEM_CAT_NO"); 
		brMainQuery.append(",( SELECT COUNT(CID.HSTNUM_ITEMBRAND_ID) FROM HSTT_CHALLAN_ITEM_DTL CID WHERE CID.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND CID.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID AND ");
		brMainQuery.append(" CID.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO) AS CNT FROM HSTT_CHALLAN_DTL A ) C  ");
		//brMainQuery.append("WHERE C.GNUM_ISVALID = 1 ");
		
		//brMainQuery.append("WHERE C.hstnum_verify_flag <> 1 ");
		//brMainQuery.append(" AND C.HSTNUM_PO_NO = 0");
		brMainQuery.append("where SUBSTR(C.HSTNUM_PO_NO,3,2)!=92 and C.GNUM_HOSPITAL_CODE  = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
		//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 0");
		if (cmb != null) 
		{
					if(cmb[1] != null && !cmb[1].equals("0"))
					{
						brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO  = "+cmb[1] +" ");
					}
					if (cmb[3].equals("1")) 
					{
						brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS != 2");
						brMainQuery.append(" AND C.GNUM_ISVALID > 0");
					} 
					else if( cmb[3].equals("4"))
					{
						brMainQuery.append(" AND EXISTS ( select 'X' from hstt_challan_item_dtl ci where ci.hstdt_freeze_date is null and ci.gnum_hospital_code = C.gnum_hospital_code and ci.hstnum_store_id = C.hstnum_store_id and ci.hstnum_challan_no = C.hstnum_challan_no ) " );
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
					/*if (cmb[1].equals("1")) 
					{*/
		
						brMainQuery = new StringBuffer("");
						brMainQuery.append("SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'|| C.HSTNUM_PO_NO || '@'|| C.HSTNUM_PO_STORE_ID  ||'@'||  C.GNUM_HOSPITAL_CODE ||'^'||C.HSTNUM_PO_NO|| '^' || C.PO_DATE || '^' || DECODE( SUBSTR(C.HSTNUM_PO_NO,3,2),22,'Local PO',87,");
						brMainQuery.append(" 'Local PO(Patient)',21,'Bulk PO','-') || '^' ||  MMS_MST.GET_SUPP_DTL(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID)  ||'^' ||C.HSTNUM_CHALLAN_NO || '^' || CNT AS DATA FROM  ");
						brMainQuery.append(" (SELECT  A.HSTNUM_STORE_ID ,A.HSTNUM_CHALLAN_NO,A.GNUM_HOSPITAL_CODE, A.HSTNUM_SCHEDULE_NO , DECODE(A.HSTNUM_SCHEDULE_TYPE , 1, 'FRESH SUPPLY' , 2, 'AGAINST RETURNED') AS HSTNUM_SCHEDULE_TYPE ,  ");
						brMainQuery.append(" A.HSTNUM_CHALLAN_STATUS, A.GNUM_ISVALID , A.HSTNUM_PO_NO,hstnum_po_store_id , TO_CHAR(A.HSTDT_PO_DATE,'DD-MON-YYYY') AS PO_DATE,HSTNUM_SUPPLIER_ID , SSTNUM_ITEM_CAT_NO "); 
						brMainQuery.append(" ,( SELECT COUNT(CID.HSTNUM_ITEMBRAND_ID) FROM HSTT_CHALLAN_ITEM_DTL CID WHERE CID.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND CID.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID AND ");
						brMainQuery.append(" CID.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO) AS CNT FROM HSTT_CHALLAN_DTL A ) C  ");
						//brMainQuery.append(" WHERE C.GNUM_ISVALID = 1 ");
						
					//	brMainQuery.append("WHERE  C.hstnum_verify_flag <> 1 ");
						brMainQuery.append(" where  SUBSTR(C.HSTNUM_PO_NO,3,2)!=92 and C.GNUM_HOSPITAL_CODE  = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());
						if( cmb[2] != null && !cmb[2].equals("0"))
						{
							brMainQuery.append(" AND C.hstnum_po_no = ").append(cmb[2].replace("^", "#").split("#")[0]);
							brMainQuery.append("  AND C.hstnum_po_store_id =  ").append(cmb[2].replace("^", "#").split("#")[1]);
							
						}
						
						if(cmb[1] != null && !cmb[1].equals("0"))
						{
							brMainQuery.append(" AND C.SSTNUM_ITEM_CAT_NO  = "+cmb[1]+" ");
						}
						//brMainQuery.append(" where C.HSTNUM_PO_NO = ").append(cmb[2].replace("^", "#").split("#")[0]);
						
						//brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 1");
						brMainQuery.append("  AND C.hstnum_store_id = ").append(cmb[0]);
						
						if (cmb[3].equals("1")) 
						{
							brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS != 2");
							brMainQuery.append(" AND C.GNUM_ISVALID > 0");
						} 
						else if( cmb[3].equals("4"))
						{
							brMainQuery.append(" AND EXISTS ( select 'X' from hstt_challan_item_dtl ci where ci.hstdt_freeze_date is null and ci.gnum_hospital_code = C.gnum_hospital_code and ci.hstnum_store_id = C.hstnum_store_id and ci.hstnum_challan_no = C.hstnum_challan_no ) " );
						}
						else 
						{
							//freezed
							if (cmb[3].equals("2"))
							{
								brMainQuery.append(" AND C.HSTNUM_CHALLAN_STATUS = 3");
								brMainQuery.append(" AND C.GNUM_ISVALID > 0");
							}
							else
							{
								//all
								brMainQuery.append(" AND C.GNUM_ISVALID > 0");
							}
						}	

			/*} 
			else 
			{

				brMainQuery = new StringBuffer("");
				
				brMainQuery.append("SELECT C.HSTNUM_STORE_ID ||'@'|| C.HSTNUM_CHALLAN_NO ||'@'||  C.GNUM_HOSPITAL_CODE ||'^'||C.HSTNUM_PO_NO|| '^' || C.PO_DATE || '^' || DECODE( SUBSTR(C.HSTNUM_PO_NO,3,2),22,'Local PO',87,");
				brMainQuery.append(" 'Local PO(Patient)','-') || '^' ||  MMS_MST.GET_SUPP_DTL(1,C.GNUM_HOSPITAL_CODE,C.HSTNUM_SUPPLIER_ID)  ||'^' ||C.HSTNUM_CHALLAN_NO || '^' || CNT AS DATA FROM  ");
				brMainQuery.append("(SELECT  A.HSTNUM_STORE_ID ,A.HSTNUM_CHALLAN_NO,A.GNUM_HOSPITAL_CODE, A.HSTNUM_SCHEDULE_NO , DECODE(A.HSTNUM_SCHEDULE_TYPE , 1, 'FRESH SUPPLY' , 2, 'AGAINST RETURNED') AS HSTNUM_SCHEDULE_TYPE ,  ");
				brMainQuery.append("A.HSTNUM_CHALLAN_STATUS, A.GNUM_ISVALID , A.HSTNUM_PO_NO,hstnum_po_store_id , TO_CHAR(A.HSTDT_PO_DATE,'DD-MON-YYYY') AS PO_DATE,HSTNUM_SUPPLIER_ID "); 
				brMainQuery.append(",( SELECT COUNT(CID.HSTNUM_ITEMBRAND_ID) FROM HSTT_CHALLAN_ITEM_DTL CID WHERE CID.GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND CID.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID AND ");
				brMainQuery.append(" CID.HSTNUM_CHALLAN_NO = A.HSTNUM_CHALLAN_NO) AS CNT FROM HSTT_CHALLAN_DTL A ) C  ");
				//brMainQuery.append(" WHERE  C. hstnum_verify_flag = 1 ");
				brMainQuery.append("  where C.gnum_hospital_code = ").append(httpSession.getAttribute("HOSPITAL_CODE").toString());							
				if( cmb[2] != null && !cmb[2].equals("0"))
				{
					brMainQuery.append(" AND C.hstnum_po_no = ").append(cmb[2].replace("^", "#").split("#")[0]);
					brMainQuery.append("  AND C.hstnum_po_store_id =  ").append(cmb[2].replace("^", "#").split("#")[1]);
					
				}
				else
				{
					brMainQuery.append(" AND TRUNC(C.HSTDT_RECIEVED_DATE)  >= ahis_gbl_util.fun_str_date('"+mmsConfig.getStrFinancialStartDate(cmb[0],httpSession.getAttribute("HOSPITAL_CODE").toString())+"')  AND TRUNC(C.HSTDT_RECIEVED_DATE) <= ahis_gbl_util.fun_str_date('"+mmsConfig.getStrFinancialEndDate(cmb[0],httpSession.getAttribute("HOSPITAL_CODE").toString())+"') ");
				}
			    
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
				
						    
			}*/

		}
		
		
		System.out.println("--Challan Process--NewChallanProcessTransUTL----"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getSearchField() {
		String[] search_field = new String[2];
			search_field[0] = "1";
			search_field[1] = "C.HSTNUM_PO_NO";
		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		String[] strComboHeader = new String[8];
		
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Item Category";
			
			strComboHeader[4] = "0^1";
			strComboHeader[5] = "PO No.";
		
			strComboHeader[6] = "1";
			strComboHeader[7] = "Status";

		return strComboHeader;
	}

	
		public String[] getColumnHeader() 
		{
			String[] strColumnHeader = new String[6];
				strColumnHeader[0] = "PO No";
				strColumnHeader[1] = "PO Date";
				strColumnHeader[2] = "PO Type";
				strColumnHeader[3] = "Supplier";
				strColumnHeader[4] = "Challan No.";
				strColumnHeader[5] = "No. of Items";
			
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
		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID,HSTSTR_STORE_NAME  "+
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
		
		
		comboQuery[1] =  "select DISTINCT SSTNUM_ITEM_CAT_NO,INITCAP(MMS_MST.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO))CAT_NAME "
 		       + "from HSTT_STORE_CATEGORY_MST  where GNUM_ISVALID =1 " +
 		       "  AND HSTNUM_STORE_ID IN ( "+ 
				  "  SELECT GNUM_COLUMN_VALUE  "+    
				  " FROM GBLT_ROLE_SEAT_TABLE_DTL P "+     
				  " WHERE P.gnum_metatable_id = 117 "+ 	      				
				  " AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "+ 
				  " )ORDER BY CAT_NAME";
				
		//comboQuery[1] = mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.0");
        //comboQuery[1] = comboQuery[1].concat(mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.cond.0")).replace("?",httpSession.getAttribute("HOSPITAL_CODE").toString());

		if (cmbVal != null ) 
		{
			
		comboQuery[2] = "SELECT HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID  || '^' || to_char(hstdt_po_date,'dd-Mon-yyyy'),HSTNUM_PO_NO|| ' ' || to_char(hstdt_po_date,'dd-Mon-yyyy') FROM SSTT_PO_DTL A WHERE A.GNUM_ISVALID in (1,4)  AND  A.HSTNUM_PO_STATUS = 1 AND A.HSTNUM_DELIVERY_LOCATION = #1# "
				+" AND A.GNUM_HOSPITAL_CODE = "	+ httpSession.getAttribute("HOSPITAL_CODE").toString()	+ " AND sstnum_item_cat_no = #2#  order by hstdt_po_date, HSTNUM_PO_NO";
		
	//	if(cmbVal[1].equals("1"))
        comboQuery[3] = "1^Pending#2^Closed#4^Challan Approval Pending#3^All" ;
     //   else
     //   comboQuery[3] = "2^Closed#3^All" ;
		
		}
		else
		{
		comboQuery[2] = "SELECT  HSTNUM_PO_NO||'^'||HSTNUM_STORE_ID || '^' || to_char(hstdt_po_date,'dd-Mon-yyyy') ,HSTNUM_PO_NO FROM SSTT_PO_DTL A WHERE A.GNUM_ISVALID in (1,4)  AND  A.HSTNUM_PO_STATUS = 1 AND A.HSTNUM_DELIVERY_LOCATION = #1# "
					+" AND A.GNUM_HOSPITAL_CODE = "	+ httpSession.getAttribute("HOSPITAL_CODE").toString()	+ " AND sstnum_item_cat_no = #2#  order by HSTNUM_PO_NO";
			
		comboQuery[3] = "1^Pending#2^Closed#4^Challan Approval Pending#3^All" ;
		}
		
		//System.out.println("comboQuery[2]::::"+comboQuery[2]);
		//System.out.println("comboQuery[1]::::"+comboQuery[1]);
		
			//System.out.println("comboQuery[2]::::"+comboQuery[2]);
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
		String str = "chkUserDefinedRevisedChallanProcessFunc";
		return str;
	}

	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	public String[] getUserDefinedButtons() {

		String[] strButtons = {
				"Receive@validateNewChallan(document.forms[0],'RECEIVECHL')@1@ea4c89@glyphicon-share",//1 to disable n 0 to enable by default
				//"Cancel@validateChallan(document.forms[0],'CANCELCHL')@1",
				//"Verify@validateChallan(document.forms[0],'VERIFYCHL');@1" ,
		        "View@validateNewChallan(document.forms[0],'VIEWCHL')@1@007bb6@glyphicon-fullscreen" 
				,"LP Patient@validateNewChallan(document.forms[0],'NEWRECCHL')@1@ff5057@glyphicon-user" }; 
			//	"Print@validateChallan(document.forms[0],'PRINT')@1" };
		
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
		String orderBy[] =   new String[2];
			orderBy[0] = "1";
			orderBy[1] = "C.HSTNUM_PO_NO";
		return orderBy;
	}

@Override
	public String[] getButtonIcons() {
		String[] str={"ReceiveOnDesk.png","ViewOnDesk.png"
				,"PrintOnDesk.png" 
				//,"ReceiveOnDesk.png"
				};
		// TODO Auto-generated method stub
		return str;
	}
	
	
}
