package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;

public class AcknowledgeTransUTL extends TransInterface {
	
	private static final long serialVersionUID = 1L;
	HttpSession httpSession = null;
	String[] cmbVal = null;

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName()
	{
		String masterName = "";
		String strReqType = "";
		
		if (httpSession.getAttribute("USERVALUE") != null && httpSession.getAttribute("USERVALUE").toString()!=null) 
		{
			strReqType = httpSession.getAttribute("USERVALUE").toString();
		} 
		else 
		{
			strReqType = "0";
		}
		
		if(strReqType.equals("0"))
		{
		   masterName = "Acknowledge Desk";
		}
		else
		{
			masterName = "Transfer Acknowledge Desk";
		}
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) 
	{
		
		StringBuffer brMainQuery = new StringBuffer(500);
		String strReqType = "";
		if (httpSession.getAttribute("USERVALUE")!=null && httpSession.getAttribute("USERVALUE").toString() != null) 
		{
			strReqType = httpSession.getAttribute("USERVALUE").toString();
		} 
		else 
		{
			strReqType = "0";
		}
		
		
		if(cmb == null)
		{
			/*
			brMainQuery.append(" SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'|| "); 
			brMainQuery.append(" A.GNUM_HOSPITAL_CODE||'^'||A.reqtype_name||'^'||A.To_Store_Name||'^'|| "); 
			brMainQuery.append(" A.HSTNUM_TRANS_NO||'^'||to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy hh24:mi')||'^'||A.itemcat_name ");  
			brMainQuery.append(" AS Data FROM ( "); 
			brMainQuery.append(" SELECT HSTNUM_STORE_ID,  HSTNUM_TRANS_NO, GNUM_HOSPITAL_CODE, "); 
			brMainQuery.append(" Mms_MST.get_store_dtl(1, GNUM_HOSPITAL_CODE, HSTNUM_STORE_ID) AS To_Store_Name , "); 
			brMainQuery.append(" HSTDT_TRANS_DATE, ");  
			brMainQuery.append(" Mms_MST.get_indentType_Name(1, GNUM_HOSPITAL_CODE, SSTNUM_REQTYPE_ID) AS reqtype_name, ");  
			brMainQuery.append(" HSTNUM_REQUEST_NO ||'/'|| TO_CHAR (HSTDT_REQUEST_DATE, 'dd-Mon-yyyy hh24:mi') AS itemcat_name,SSTNUM_REQTYPE_ID, GNUM_ISVALID, HSTNUM_TOSTORE_ID, HSTDT_REQUEST_DATE "); 
			brMainQuery.append(" FROM SSTT_ACKNOWLEDGE_DTL) A "); 
						
			String cond1="A.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString();
			String cond2="A.HSTNUM_TOSTORE_ID=0";
			String cond3="A.GNUM_ISVALID=1 AND 1=2";
			
				
			brMainQuery.append(" where "+cond1);
			brMainQuery.append(" and "+cond3);			
			brMainQuery.append(" AND A.HSTDT_TRANS_DATE > TRUNC(SYSDATE) - 180 ");
			brMainQuery.append(" AND A.HSTNUM_TOSTORE_ID IN ");
			brMainQuery.append("   (  ");
			brMainQuery.append("   SELECT GNUM_COLUMN_VALUE  ");  
			brMainQuery.append("   FROM GBLT_ROLE_SEAT_TABLE_DTL P  ");     
			brMainQuery.append("   WHERE P.gnum_metatable_id = 117  ");    
			brMainQuery.append("   AND P.gnum_hospital_code =  "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"  ");
			brMainQuery.append("   AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual )  "); 
			brMainQuery.append("   ) ");
			*/
			brMainQuery.append("  SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'|| "); 
		    brMainQuery.append("  A.GNUM_HOSPITAL_CODE||'^'||A.reqtype_name||'^'||A.To_Store_Name||'^'||  A.HSTNUM_TRANS_NO ");
		    brMainQuery.append(" ||'^'||to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy  hh24:mi')||'^'||A.itemcat_name  AS Data FROM ");
		    brMainQuery.append("  (  ");
		    brMainQuery.append(" 		SELECT HSTNUM_STORE_ID,  HSTNUM_TRANS_NO, GNUM_HOSPITAL_CODE,  ");
		    brMainQuery.append(" 		Mms_MST.get_store_dtl(1, GNUM_HOSPITAL_CODE, HSTNUM_STORE_ID) AS To_Store_Name ,  ");
		    brMainQuery.append(" 		HSTDT_TRANS_DATE,  Mms_MST.get_indentType_Name(1, GNUM_HOSPITAL_CODE, SSTNUM_REQTYPE_ID) ");
		    brMainQuery.append(" 		AS reqtype_name,  HSTNUM_REQUEST_NO ||'/'|| TO_CHAR (HSTDT_REQUEST_DATE, 'dd-Mon-yyyy hh24:mi') ");
		    brMainQuery.append(" 		AS itemcat_name, GNUM_ISVALID, SSTNUM_REQTYPE_ID, ");
		    brMainQuery.append(" 		HSTNUM_TOSTORE_ID,HSTDT_REQUEST_DATE  ");
		    brMainQuery.append("  		FROM SSTT_ACKNOWLEDGE_DTL  E  ");
		    brMainQuery.append(" 		WHERE  CASE WHEN  ");
		    brMainQuery.append(" 	(  ");
		    brMainQuery.append("      ( ");   
		    brMainQuery.append(" 	SELECT COUNT(*)   ");
		    brMainQuery.append(" FROM  SSTT_APPROVALREQ_DTL D   ");
		    brMainQuery.append(" 				WHERE D.GNUM_ISVALID = 1   ");
		    brMainQuery.append("  				AND D.hstnum_req_no =  E.hstnum_REQUEST_no   ");
		    brMainQuery.append(" 				AND D.hstnum_tostore_id = E.hstnum_tostore_id  "); 
		    brMainQuery.append(" 				AND D.hstnum_store_id = E.hstnum_store_id ");
		    brMainQuery.append(" 			) > 0  )  THEN  E.HSTNUM_STORE_ID IN  ");
		    brMainQuery.append(" 			(        ");
		    brMainQuery.append(" 			 SELECT  HSTNUM_STORE_ID   ");       
		    brMainQuery.append(" 			 FROM SSTT_APPROVALREQ_DTL D    ");    
		    brMainQuery.append(" 			 WHERE D.GNUM_ISVALID = 1   ");    
		    brMainQuery.append(" 			 AND D.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"  ");     
		    brMainQuery.append(" 			 AND D.HSTNUM_REQ_STATUS IN ( 40 ) ");        
		    brMainQuery.append(" 			 AND D.hstnum_req_no =  E.hstnum_REQUEST_no  "); 
		    brMainQuery.append(" 			 AND D.hstnum_tostore_id = E.hstnum_tostore_id   ");
		    brMainQuery.append(" 			 AND D.hstnum_store_id = E.hstnum_store_id ");
		    brMainQuery.append("         ) ");   
		    brMainQuery.append(" 		ELSE   E.hstnum_tostore_id  IN( SELECT GNUM_COLUMN_VALUE FROM GBLT_ROLE_SEAT_TABLE_DTL P WHERE P.gnum_metatable_id = 117   AND P.gnum_hospital_code =  "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"  AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ))   END   ");
		    brMainQuery.append("  ) A  where A.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
		    		+ " AND A.hstnum_tostore_id  IN( SELECT GNUM_COLUMN_VALUE FROM GBLT_ROLE_SEAT_TABLE_DTL P WHERE P.gnum_metatable_id = 117   AND P.gnum_hospital_code =  "+ httpSession.getAttribute("HOSPITAL_CODE").toString()+"  AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ))  and A.GNUM_ISVALID=1 ");
		    brMainQuery.append(" AND A.HSTDT_TRANS_DATE > TRUNC(SYSDATE) - 180 ");
			if(strReqType.equals("51"))
			{	
			  brMainQuery.append(" and SSTNUM_REQTYPE_ID = 51");
			}  
		
		}
		
		else{ 
			if(cmb[1].equals("0"))	 // Acknowledge Pending
			{
				    brMainQuery = new StringBuffer(1000);
				    
				    
				    brMainQuery.append("  SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'|| "); 
				    brMainQuery.append("  A.GNUM_HOSPITAL_CODE||'^'||A.reqtype_name||'^'||A.To_Store_Name||'^'||  A.HSTNUM_TRANS_NO ");
				    brMainQuery.append(" ||'^'||to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy  hh24:mi')||'^'||A.itemcat_name  AS Data FROM ");
				    brMainQuery.append("  (  ");
				    brMainQuery.append(" 		SELECT HSTNUM_STORE_ID,  HSTNUM_TRANS_NO, GNUM_HOSPITAL_CODE,  ");
				    brMainQuery.append(" 		Mms_MST.get_store_dtl(1, GNUM_HOSPITAL_CODE, HSTNUM_STORE_ID) AS To_Store_Name ,  ");
				    brMainQuery.append(" 		HSTDT_TRANS_DATE,  Mms_MST.get_indentType_Name(1, GNUM_HOSPITAL_CODE, SSTNUM_REQTYPE_ID) ");
				    brMainQuery.append(" 		AS reqtype_name,  HSTNUM_REQUEST_NO ||'/'|| TO_CHAR (HSTDT_REQUEST_DATE, 'dd-Mon-yyyy hh24:mi') ");
				    brMainQuery.append(" 		AS itemcat_name, GNUM_ISVALID, SSTNUM_REQTYPE_ID, ");
				    brMainQuery.append(" 		HSTNUM_TOSTORE_ID,HSTDT_REQUEST_DATE  ");
				    brMainQuery.append("  		FROM SSTT_ACKNOWLEDGE_DTL  E  ");
				    brMainQuery.append(" 		WHERE  CASE WHEN  ");
				    brMainQuery.append(" 	(  ");
				    brMainQuery.append("      ( ");   
				    brMainQuery.append(" 	SELECT COUNT(*)   ");
				    brMainQuery.append(" FROM  SSTT_APPROVALREQ_DTL D   ");
				    brMainQuery.append(" 				WHERE D.GNUM_ISVALID = 1   ");
				    brMainQuery.append("  				AND D.hstnum_req_no =  E.hstnum_REQUEST_no   ");
				    brMainQuery.append(" 				AND D.hstnum_tostore_id = E.hstnum_tostore_id  "); 
				    brMainQuery.append(" 				AND D.hstnum_store_id = E.hstnum_store_id ");
				    brMainQuery.append(" 			) > 0  )  THEN  E.HSTNUM_STORE_ID IN  ");
				    brMainQuery.append(" 			(        ");
				    brMainQuery.append(" 			 SELECT  HSTNUM_STORE_ID   ");       
				    brMainQuery.append(" 			 FROM SSTT_APPROVALREQ_DTL D    ");    
				    brMainQuery.append(" 			 WHERE D.GNUM_ISVALID = 1   ");    
				    brMainQuery.append(" 			 AND D.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"  ");     
				    brMainQuery.append(" 			 AND D.HSTNUM_REQ_STATUS IN ( 40 ) ");        
				    brMainQuery.append(" 			 AND D.hstnum_req_no =  E.hstnum_REQUEST_no  "); 
				    brMainQuery.append(" 			 AND D.hstnum_tostore_id = E.hstnum_tostore_id   ");
				    brMainQuery.append(" 			 AND D.hstnum_store_id = E.hstnum_store_id ");
				    brMainQuery.append("         ) ");   
				    brMainQuery.append(" 		ELSE   E.hstnum_tostore_id  = "+cmb[0]+"   END   ");
				    brMainQuery.append("  ) A  where A.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString()+" "
				    		+ " AND A.hstnum_tostore_id  = "+cmb[0]+"  and A.GNUM_ISVALID=1 ");
				    brMainQuery.append(" AND A.HSTDT_TRANS_DATE > TRUNC(SYSDATE) - 180 ");
				    
				    /*
				 				 
				    brMainQuery.append(" SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'|| "); 
					brMainQuery.append(" A.GNUM_HOSPITAL_CODE||'^'||A.reqtype_name||'^'||A.To_Store_Name||'^'|| "); 
					brMainQuery.append(" A.HSTNUM_TRANS_NO||'^'||to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy  hh24:mi')||'^'||A.itemcat_name ");  
					brMainQuery.append(" AS Data FROM ( "); 
					brMainQuery.append(" SELECT HSTNUM_STORE_ID,  HSTNUM_TRANS_NO, GNUM_HOSPITAL_CODE, "); 
					brMainQuery.append(" Mms_MST.get_store_dtl(1, GNUM_HOSPITAL_CODE, HSTNUM_STORE_ID) AS To_Store_Name , "); 
					brMainQuery.append(" HSTDT_TRANS_DATE, ");  
					brMainQuery.append(" Mms_MST.get_indentType_Name(1, GNUM_HOSPITAL_CODE, SSTNUM_REQTYPE_ID) AS reqtype_name, ");  
					brMainQuery.append(" HSTNUM_REQUEST_NO ||'/'|| TO_CHAR (HSTDT_REQUEST_DATE, 'dd-Mon-yyyy hh24:mi') AS itemcat_name, GNUM_ISVALID, SSTNUM_REQTYPE_ID, HSTNUM_TOSTORE_ID,HSTDT_REQUEST_DATE "); 
					brMainQuery.append(" FROM SSTT_ACKNOWLEDGE_DTL  E ");					
					brMainQuery.append(" WHERE ");
					brMainQuery.append(" CASE WHEN ");
					brMainQuery.append("( ");
					brMainQuery.append(" ( ");
					brMainQuery.append("  SELECT COUNT(*) ");
					brMainQuery.append("  FROM  SSTT_APPROVALREQ_DTL D  ");
					brMainQuery.append("  WHERE D.GNUM_ISVALID = 1  ");
					brMainQuery.append("  AND D.hstnum_req_no =  E.hstnum_TRANS_no ");
					brMainQuery.append("  AND D.hstnum_store_id = E.hstnum_store_id ");
					brMainQuery.append("  AND D.hstnum_tostore_id = "+cmb[0]+"");
					brMainQuery.append(" ) > 0  ) ");
					brMainQuery.append(" THEN ");
					brMainQuery.append(" HSTNUM_TOSTORE_ID IN ");
					brMainQuery.append(" (  ");
					brMainQuery.append("       SELECT  HSTNUM_TOSTORE_ID   ");
					brMainQuery.append("       FROM SSTT_APPROVALREQ_DTL D ");
					brMainQuery.append("       WHERE D.GNUM_ISVALID = 1  ");
					brMainQuery.append("       AND D.GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString());
					brMainQuery.append("       AND D.HSTNUM_REQ_STATUS (40, 50)  ");
					//brMainQuery.append("       AND D.SSTNUM_REQTYPE_ID = 18 ");
					brMainQuery.append("       AND D.hstnum_req_no =  E.hstnum_TRANS_no ");					
					brMainQuery.append("       AND D.hstnum_store_id = E.hstnum_store_id ");
					brMainQuery.append("       AND D.hstnum_tostore_id = "+cmb[0]);
					brMainQuery.append(" ) ");
					brMainQuery.append(" ELSE ");
					brMainQuery.append(" HSTNUM_TOSTORE_ID IN ");
					brMainQuery.append(" ( " ); 
					brMainQuery.append("   SELECT  HSTNUM_TOSTORE_ID ");
					brMainQuery.append("   FROM  SSTT_INDENT_DTL D ");
					brMainQuery.append("   WHERE D.GNUM_ISVALID = 1  ");
					brMainQuery.append("   AND D.HSTNUM_INDENT_STATUS IN(40, 50)  ");
					brMainQuery.append("   AND D.hstnum_req_no = E.hstnum_TRANS_no ");
					brMainQuery.append("   AND D.hstnum_store_id = E.hstnum_store_id ");
					brMainQuery.append("   AND D.hstnum_tostore_id = "+cmb[0]+") ");
					brMainQuery.append("   END ");  			
				    brMainQuery.append("  ) A "); 								
					String cond1="A.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString();
					//String cond2="A.HSTNUM_TOSTORE_ID="+cmb[0];
					String cond3="A.GNUM_ISVALID=1";
						
					brMainQuery.append(" where "+cond1);
					//brMainQuery.append(" and "+cond2);
					brMainQuery.append(" and "+cond3);
					if(strReqType.equals("51"))
					{	
					  brMainQuery.append(" and SSTNUM_REQTYPE_ID = 51");
					}  
					*/
					
					 		
			}
			
			else if(cmb[1].equals("1"))   // Acknowledge
				
			{
				 brMainQuery = new StringBuffer(500);
//				brMainQuery.append("SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'||A.HSTNUM_ACK_NO||'@'|| "); 
//				brMainQuery.append("A.GNUM_HOSPITAL_CODE||'^'||A.To_Store_Name||'^'||A.HSTNUM_TRANS_NO||'^'|| "); 
//				brMainQuery.append("to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy')||'^'||A.reqtype_name||'^'||A.itemcat_name ");  
				brMainQuery.append(" SELECT A.HSTNUM_STORE_ID||'@'||A.HSTNUM_TRANS_NO||'@'||A.SSTNUM_REQTYPE_ID||'@'|| "); 
				brMainQuery.append(" A.GNUM_HOSPITAL_CODE||'^'||A.reqtype_name||'^'||A.To_Store_Name||'^'|| "); 
				brMainQuery.append(" A.HSTNUM_TRANS_NO||'^'||to_char(A.HSTDT_TRANS_DATE,'dd-Mon-yyyy  hh24:mi')||'^'||A.itemcat_name ");  
				brMainQuery.append(" AS Data FROM "); 
				brMainQuery.append("( SELECT HSTNUM_STORE_ID, HSTNUM_TRANS_NO, HSTNUM_ACK_NO, GNUM_HOSPITAL_CODE, "); 
				brMainQuery.append("Mms_MST.get_store_dtl(1, GNUM_HOSPITAL_CODE, HSTNUM_STORE_ID) AS To_Store_Name , "); 
				brMainQuery.append("HSTDT_TRANS_DATE, ");  
				brMainQuery.append("Mms_MST.get_indentType_Name(1, GNUM_HOSPITAL_CODE, SSTNUM_REQTYPE_ID) AS reqtype_name, "); 
				brMainQuery.append("HSTNUM_REQUEST_NO ||'/'|| TO_CHAR (HSTDT_REQUEST_DATE, 'dd-Mon-yyyy hh24:mi') AS itemcat_name , GNUM_ISVALID,HSTNUM_TOSTORE_ID,SSTNUM_REQTYPE_ID,HSTDT_REQUEST_DATE "); 
				brMainQuery.append("FROM HSTT_ACKNOWLEDGE_DTL) A "); 
				
				String cond1="A.GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString();
				//String cond2="A.HSTNUM_TOSTORE_ID=#1#";
				String cond2="A.HSTNUM_TOSTORE_ID="+cmb[0];
				String cond3="A.GNUM_ISVALID=1";
					
				brMainQuery.append(" where "+cond1);
				brMainQuery.append(" and "+cond2);
				brMainQuery.append(" and "+cond3);
				brMainQuery.append(" AND A.HSTDT_TRANS_DATE > TRUNC(SYSDATE) - 180 ");
				if(strReqType.equals("51"))
				{	
				  brMainQuery.append(" and SSTNUM_REQTYPE_ID = 51");
				}  
			
			}
		}
		System.out.println("AcknowledgeTransUTL Main Qry==>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/**
	 * Combo Option Search feature.
	 * 
	 *  1^0 represents  1 >> dummy value and 0 >> index of the Combo (first combo >> 0 , second combo >> 1 , etc., ) 
	 *  next value after "1^0" should be the Name of the Combo Header (first combo in this case) 
	 *  
	 *  by doing this in the transaction template , at the search combo box  a new field with the Combo Header will be available, by selecteing 
	 *  the option and corresponding value, a search can be made in the corresponding combo box
	 *   
	 */
	public String[] getSearchField() 
	{
		
		String[] search_field = new String[4];
		
		search_field[0] = "2";
		search_field[1] = "A.To_Store_Name";
		
		search_field[2] = "1";
		search_field[3] = "A.reqtype_name";
		
		return search_field;
	}
	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		String[] strComboHeader = new String[4];
		
		strComboHeader[0] = "0^2";
		strComboHeader[1] = "Ack By";
		strComboHeader[2] = "1";
		strComboHeader[3] = "Status";
		
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = new String[5];
		strColumnHeader[0] = "Req Type";
		strColumnHeader[1] = "Store Name";
		strColumnHeader[2] = "Trans No";
		strColumnHeader[3] = "Trans Date";
		strColumnHeader[4] = "Req No/Date";
			
		return strColumnHeader;
	}      

	public String[] getComboQuery(){
	
		String[] comboQuery = new String[3];
		/*
		comboQuery[0] = "SELECT HSTNUM_STORE_ID,HSTSTR_STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_ISVALID = 1 AND  GNUM_HOSPITAL_CODE ="+
						httpSession.getAttribute("HOSPITAL_CODE").toString()+
						" AND EXISTS"+
						   "("+
						    "SELECT 'X'"+
						    "FROM GBLT_ROLE_SEAT_TABLE_DTL P"+
						    " WHERE UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
						    " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
						    " AND P.gnum_hospital_code = A.gnum_hospital_code and gnum_module_id = 63"+
						  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
						 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
						 ",A.GNUM_HOSPITAL_CODE)"+
						")" +
		"ORDER BY INITCAP(HSTSTR_STORE_NAME)";
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
				  " )ORDER BY hststr_store_name";
	
		
		comboQuery[1] = "0^Active#1^Acknowledged";
		
		//System.out.println("comboQuery[0] ::"+comboQuery[0]);
		return comboQuery;
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
		//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png'  border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();'></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
//		String a[] = null;
//		String b[] = null;
//		String key[] = new String[1];
//
		List<String> deleteData = new ArrayList<String>();
//		a = (chk.replace('|', '#')).split("#");
//		b = (a[0].replace('@', '#')).split("#");
//
//		key[0] = b[0];
//		System.out.print("key[0] = " + key[0]);
//		deleteData.add(key);
//		return deleteData;
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/acknowledgeDesk_trans.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status ={ "Autrin Cap", "2", "brown", "" };
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
		String[] strButtons = {"Acknowledge@callPage1(document.forms[0],'ACKNOWLEDGE')@1@00aced@glyphicon-check",
				"View@viewAcknowledge()@1@007bb6@glyphicon-fullscreen"};		
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
		return "changeCombo";
	}

	public String[] getOrderBy() {
		//String orderBy[] = { "1","A.reqtype_name","3","A.HSTNUM_TRANS_NO","4","A.HSTDT_TRANS_DATE","5","A.itemcat_name" };
		String orderBy[] = { "4","HSTDT_TRANS_DATE" };
		return orderBy;
	}
	
	/**
	 * 
	 * this method optional 
	 * 
	 * if this method is override and a list of column numbers passed (no. of values should be equal to no. of columns) 
	 * if any one of the value is null or empty string then the template will take the default column width (100 / no. of columns) 
	 * 
	 * 
	 */
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"AcknowledgeOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub,
		return str;
	}

	
}
