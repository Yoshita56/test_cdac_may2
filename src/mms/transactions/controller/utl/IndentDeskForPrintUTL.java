package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.transactionutil.TransInterface;
import mms.MmsConfigUtil;

public class IndentDeskForPrintUTL extends TransInterface {

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
		String masterName = "Indent Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(1000);
		String strFinancialStartYear = "";
        String strFinancialEndYear = "";
	    MmsConfigUtil mcu = null;
	    String hosCode=httpSession.getAttribute("HOSPITAL_CODE").toString();
	    mcu = new MmsConfigUtil(hosCode);
	    String[] strTemp1 = null;
	    String[] strTemp = null;
	    
	    if(cmb != null)
	    {
	    	if(!cmb[2].equals("0") && (cmb[2].replace("^","#").split("#")[1].equals("86")))
		    {
	    	    System.out.println("----- A -----");	
		        brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'|| A.HRGNUM_PUK || '^' || AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric)  || '^'|| HSTNUM_REQ_NO ||  decode(is_auto_indent,1,'*')  || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi')|| '^'|| ");
			//	brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' || decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Indent Closed',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS)  || '^'||");
		        brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");
		       
		        brMainQuery.append("|| '^' || ");		        
		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
		        brMainQuery.append("	'Rejected By Approver '");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
		        brMainQuery.append(" 	'External / NA ' ");
		        brMainQuery.append(" END ");	        
		        brMainQuery.append("|| '^' || ");
			
				brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
				brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
				brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND ");
				brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
		    }
	    	else if(!cmb[2].equals("0") && (cmb[2].replace("^","#").split("#")[1].equals("13") ))
	    	{
	    		if(!cmb[3].equals("2"))
	    		{
	    			System.out.println("----- B -----");
	    			brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'|| A.HRGNUM_PUK  || '^'|| AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric)  || '^' || HSTNUM_REQ_NO ||  decode(is_auto_indent,1,'*')  || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY  hh24:mi')|| '^'|| ");
		 			//brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' ||  decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Indent Closed',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS) || '^'||");
	    			
	    			brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");
	  		       
	 		        brMainQuery.append("|| '^' || ");		        
	 		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
	 		        brMainQuery.append("	'Rejected By Approver '");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
	 		        brMainQuery.append(" 	'External / NA ' ");
	 		        brMainQuery.append(" END ");	        
	 		        brMainQuery.append("|| '^' || ");
	 		        
		 			brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
		 			brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
		 			brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND ");
		 			brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
		 			brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
		 			brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
	    		}
	    		else
	    		{
	    			System.out.println("----- C -----");
	    			brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'|| A.HRGNUM_PUK  || '^'|| AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric)  || '^' || HSTNUM_REQ_NO ||  decode(is_auto_indent,1,'*')  || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY  hh24:mi')|| '^'|| ");
		 			
	    			//brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' ||  decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Indent Closed',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS) || '^'||");
	    			
	    			brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");
		  		       
	 		        brMainQuery.append("|| '^' || ");		        
	 		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
	 		        brMainQuery.append("	'Rejected By Approver '");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
	 		        brMainQuery.append(" 	'External / NA ' ");
	 		        brMainQuery.append(" END ");	        
	 		        brMainQuery.append("|| '^' || ");
		 			
		 			brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
		 			brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
		 			brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND nvl(hstnum_bs_refno,0) <> 0 AND ");
		 			brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
		 			brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
		 			brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
	    		}
	 				
	 				
	    	}
	    	else if(!cmb[2].equals("0") && (cmb[2].replace("^","#").split("#")[1].equals("18")))
			    {
	    		    System.out.println("----- D -----");
			    	brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'||HSTNUM_REQ_NO || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY  hh24:mi')|| '^'|| ");
			 		//brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' || decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Issued',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS) || '^'|| ");
			    	
			    	brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");
		  		       
	 		        brMainQuery.append("|| '^' || ");		        
	 		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
	 		        brMainQuery.append("	'Rejected By Approver '");
	 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
	 		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
	 		        brMainQuery.append(" 	'External / NA ' ");
	 		        brMainQuery.append(" END ");	        
	 		        brMainQuery.append("|| '^' || ");
	 		        
			 		brMainQuery.append("AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric) || '^'|| ");
			 		brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
			 		brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
			 		brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND ");
			 		brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
			 		brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
			 		brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
			 		
			    }
		    else
		    {
		    	System.out.println("----- E -----");
		    	brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'||HSTNUM_REQ_NO ||  decode(is_auto_indent,1,'*')  || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY  hh24:mi')|| '^'|| ");
		 		//brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' || decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Issued',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS) || '^'|| ");
		    	
		    	brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");
	  		       
 		        brMainQuery.append("|| '^' || ");		        
 		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
 		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
 		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
 		        brMainQuery.append("	'Rejected By Approver '");
 		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
 		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
 		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
 		        brMainQuery.append(" 	'External / NA ' ");
 		        brMainQuery.append(" END ");	        
 		        brMainQuery.append("|| '^' || ");
 		        
		 		brMainQuery.append("AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric) || '^'|| ");
		 		brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
		 		brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
		 		brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND ");
		 		brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
		 		brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
		 		brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
		 		brMainQuery.append(" AND  SSTNUM_REQTYPE_ID  IN(23)");
		    }
	    
	    }
	    else
	    {
	    	System.out.println("----- F -----");
	    	brMainQuery.append("SELECT HSTNUM_REQ_NO || '@' || HSTNUM_STORE_ID  || '@' || SSTNUM_REQTYPE_ID || '@' || A.SSTNUM_ITEM_CAT_NO || '@' || A.HSTNUM_URGENT_FLAG ||'@'|| HSTSTR_INDENT_PERIOD||'@'||HSTNUM_TOSTORE_ID || '^'||HSTNUM_REQ_NO  ||  decode(is_auto_indent,1,'*')  || '^'||TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY  hh24:mi')|| '^'|| ");
	 		//brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) || '^' ||  decode(HSTNUM_INDENT_STATUS,0,'Pending',1,'App-In Proceess',10,'I Approval',11,'II Approval',45,'Issued',20,'Partial Approved',40,'Final Approved',49,'In Process',99,'External / NA',111,'Items Received',50,'Processed',53,'Processed',HSTNUM_INDENT_STATUS) || '^'|| ");
	    	    brMainQuery.append("MMS_MST.GET_STORE_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) ");		       
		        brMainQuery.append("|| '^' || ");		        
		        brMainQuery.append("CASE WHEN HSTNUM_INDENT_STATUS = 0   THEN 'Pending'          WHEN HSTNUM_INDENT_STATUS = 1   THEN 'App-In Proceess'  WHEN HSTNUM_INDENT_STATUS = 10  THEN 'I Approval'      WHEN HSTNUM_INDENT_STATUS = 11  THEN 'II Approval'"); 
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 45  THEN 'Issued'     		WHEN HSTNUM_INDENT_STATUS = 20  THEN 'Partial Approved' WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved'  WHEN HSTNUM_INDENT_STATUS = 40  THEN 'Final Approved' ");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 49  THEN 'In Process'       WHEN HSTNUM_INDENT_STATUS = 111 THEN 'Items Received'   WHEN HSTNUM_INDENT_STATUS = 50  THEN 'Processed'  	   WHEN HSTNUM_INDENT_STATUS = 53  THEN 'Processed' ");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
		        brMainQuery.append("	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
		        brMainQuery.append("	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99) > 0 THEN "); 
		        brMainQuery.append("	'Rejected By Approver '");
		        brMainQuery.append("	WHEN HSTNUM_INDENT_STATUS = 99  AND ( SELECT COUNT(*) FROM HSTT_APPROVAL_DTL E WHERE E.SSTNUM_TRANS_NO = A.hstnum_req_no "); 
		        brMainQuery.append(" 	AND E.HSTNUM_STORE_ID = A.HSTNUM_STORE_ID "); 
		        brMainQuery.append(" 	AND E.HSTNUM_TOSTORE_ID = A.HSTNUM_TOSTORE_ID AND E.HSTNUM_NEW_STATUS = 99 ) = 0 THEN "); 
		        brMainQuery.append(" 	'External / NA ' ");
		        brMainQuery.append(" END ");	        
		        brMainQuery.append("|| '^' || ");
		        
	 		brMainQuery.append("AHIS_FUNCTION.FUN_PAT_NAME(HRGNUM_PUK::numeric) || '^'|| ");
	 		brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal')");
	 		brMainQuery.append(" AS DATA FROM SSTT_INDENT_DTL A ");
	 		brMainQuery.append(" WHERE GNUM_ISVALID = 1 AND ");
	 		brMainQuery.append(" GNUM_HOSPITAL_CODE = ");
	 		brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());	 		
	 		//brMainQuery.append(" AND HSTNUM_STORE_ID in ( SELECT GNUM_COLUMN_VALUE  FROM GBLT_ROLE_SEAT_TABLE_DTL P  WHERE P.gnum_metatable_id = 117 AND P.gnum_hospital_code = A.gnum_hospital_code AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", A.GNUM_HOSPITAL_CODE) from dual )) "); 
	 		brMainQuery.append(" AND  SSTNUM_REQTYPE_ID NOT IN(80,81,82,83,84,85)");
	 		brMainQuery.append(" AND  SSTNUM_REQTYPE_ID  IN(23)");
	    }	    					
		if (cmb != null) 
		{ 			
			//financial date on the basis of store id
			if (!cmb[0].equals("0")) 
			{
				strTemp  =  cmb[0].split("\\^"); 
				strFinancialStartYear = "01-Apr-2023";
				strFinancialEndYear   = "31-Mar-2024";
			}

			if (cmb[3].equals("0"))  // In-Process  "0^Pending#2^Partial#1^Processed
			{
			   brMainQuery.append(" AND ((HSTNUM_INDENT_STATUS >= 0 AND HSTNUM_INDENT_STATUS < 49) or HSTNUM_INDENT_STATUS = 99) AND HSTDT_REQ_DATE > TRUNC(SYSDATE) - 180 ");
			}
			if (cmb[3].equals("2"))  // Partial  "0^Pending#2^Partial#1^Processed
			{
			   brMainQuery.append(" AND (HSTNUM_INDENT_STATUS > 0 AND HSTNUM_INDENT_STATUS < 50) AND HSTDT_REQ_DATE > TRUNC(SYSDATE) - 60");
			}		
			else if(cmb[3].equals("1") || cmb[3].equals("111"))
			{
				
				brMainQuery.append(" AND HSTNUM_INDENT_STATUS in (50,53)");
			}
			//request type
			if (!cmb[2].equals("0")) 
			{
				strTemp1 =  cmb[2].split("\\^");
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = ");
				brMainQuery.append(strTemp1[1]);
			}
			
			//category
			if (!cmb[1].equals("0")) 
			{
				brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = ");
				brMainQuery.append(cmb[1]);
			}
            
			//store id
			/*
			if (!cmb[0].equals("0")) 
			{
				strTemp  =  cmb[0].split("\\^"); 
				brMainQuery.append(" AND HSTNUM_STORE_ID = ");
				brMainQuery.append(strTemp[0]);
			}
			*/
			if(cmb[3].equals("111"))
			{
				brMainQuery.append(" AND HSTNUM_REQ_NO NOT IN (SELECT HSTNUM_BS_REFNO FROM SSTT_INDENT_DTL WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND HSTNUM_BS_REFNO IS NOT NULL AND HSTNUM_BS_REFNO <> 0 ) AND EXISTS ( SELECT 'X' FROM HSTT_ACKNOWLEDGE_DTL WHERE GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO AND GNUM_ISVALID = 1 AND HSTNUM_REQUEST_NO in (SELECT HSTNUM_REQ_NO FROM HSTT_AGENDA_DTL WHERE GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO AND GNUM_ISVALID = 1 AND HSTNUM_AGENDA_NO in (SELECT DISTINCT HSTNUM_AGENDA_NO");
				brMainQuery.append(" FROM HSTT_AGENDA_INDENT_DTL WHERE GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO AND GNUM_ISVALID = 1 AND HSTNUM_REQ_NO = A.HSTNUM_REQ_NO) ))");
			}
		 }
		else
		{
			brMainQuery.append(" AND HSTNUM_INDENT_STATUS = 0 ");
		}	

		mcu = null;
		
		System.out.println("Demand desk Main Query-[ IndentDeskForPrintUTL ]->>>>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"1", "HSTNUM_REQ_NO"};
		
		
		if(cmbVal != null  && !cmbVal[2].equals("0") && cmbVal[2].replace("^","#").split("#")[1].equals("86") )
	    {
			search_field = new String[2];
			search_field[0] = "1";
			search_field[1] = "HRGNUM_PUK";
			//search_field[2] = "2";
			//search_field[3] = "HSTNUM_REQ_NO";
	    }
		if(cmbVal != null  && !cmbVal[2].equals("0") &&  (cmbVal[2].replace("^","#").split("#")[1].equals("13") || cmbVal[2].replace("^","#").split("#")[1].equals("18")))
		{
			search_field = new String[2];
			search_field[0] = "1";
			search_field[1] = "HRGNUM_PUK";
			//search_field[2] = "4";
			//search_field[3] = "HSTNUM_REQ_NO";
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
		//String[] strComboHeader = {"0^2","Drug Warehouse Name","0^0","Item Category","0^0","Request Type","1","Status"};
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[8];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "0^0";
			strComboHeader[5] = "Request Type";
			strComboHeader[6] = "1";
			strComboHeader[7] = "Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^0";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "0^0";
			strComboHeader[5] = "Request Type";
			strComboHeader[6] = "1";
			strComboHeader[7] = "Status";

		}
		
	    return strComboHeader;
	 
	}

	public String[] getColumnHeader() 
	{
		
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strColumnHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strColumnHeader[0] = "Indent No";
			strColumnHeader[1] = "Indent Date";
			strColumnHeader[2] = "Issuing Store";
			strColumnHeader[3] = "Status";
			
			if (cmbVal != null  && !cmbVal[2].equals("0") &&  cmbVal[2].replace("^","#").split("#")[1].equals("86"))
			{
				strColumnHeader = new String[5];
				strColumnHeader[0] =  "CR No.";
				strColumnHeader[1] =  "Indent No";
				strColumnHeader[2] =  "Indent Date";
				strColumnHeader[3] =  "Store";
				strColumnHeader[4] = "Status";
				
			}
			
		    
			
			if(cmbVal != null && !cmbVal[2].equals("0"))
			{			
				String[] tmp =  cmbVal[2].replace("^", "#").split("#");
				if(tmp[1].equals("13")  || tmp[1].equals("86"))
				{
					strColumnHeader = new String[6];
					
					strColumnHeader[0] =  "CR No.";
					strColumnHeader[1] =  "Patient Name";
				//	strColumnHeader[2] =  "Employee Name";
					strColumnHeader[2] =  "Indent No";
					strColumnHeader[3] =  "Indent Date";
					strColumnHeader[4] =  "Issuing Store";
					strColumnHeader[5] = "Status";
					
				}
				
				
				 if(cmbVal[3]!=null)
				 {	 
					if(tmp[1].equals("13")  || tmp[1].equals("86"))
					{
						strColumnHeader = new String[6];
						
						strColumnHeader[0] =  "CR No.";
						strColumnHeader[1] =  "Patient Name";
						//strColumnHeader[2] =  "Employee Name";
						strColumnHeader[2] =  "Indent No";
						strColumnHeader[3] =  "Indent Date";
						strColumnHeader[4] =  "Issuing Store";
						strColumnHeader[5] = "Status";
						
					}
				 }	
								
			}
			

		}
		else
		{
			strColumnHeader[0] = "Indent No";
			strColumnHeader[1] = "Indent Date";
			strColumnHeader[2] = "Issuing Store";
			strColumnHeader[3] = "Status";
			
			if(cmbVal != null && !cmbVal[2].equals("0"))
			{			
				String[] tmp =  cmbVal[2].replace("^", "#").split("#");
				if(tmp[1].equals("13")  || tmp[1].equals("86"))
				{
					strColumnHeader = new String[6];
					
					strColumnHeader[0] =  "CR No.";
					strColumnHeader[1] =  "Patient Name";
				//	strColumnHeader[2] =  "Employee Name";
					strColumnHeader[2] =  "Indent No";
					strColumnHeader[3] =  "Indent Date";
					strColumnHeader[4] =  "Issuing Store";
					strColumnHeader[5] = "Status";
					
					
				}
				 if(cmbVal[3]!=null)
				 {	 
					if(tmp[1].equals("13")  || tmp[1].equals("86"))
					{
						strColumnHeader = new String[6];
						
						strColumnHeader[0] =  "CR No.";
						strColumnHeader[1] =  "Patient Name";
					//	strColumnHeader[2] =  "Employee Name";
						strColumnHeader[2] =  "Indent No";
						strColumnHeader[3] =  "Indent Date";
						strColumnHeader[4] =  "Issuing Store";
						strColumnHeader[5] = "Status";
						
					}
				 }	
								
			}
		}
		
		
		return strColumnHeader;
		
		
	}      

	public String[] getComboQuery()
	{
		
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		
		String[] comboQuery = new String[5];
	    
	  		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID|| '^' ||HSTNUM_STORETYPE_ID,HSTSTR_STORE_NAME  "+
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

        System.out.println("Catg_combo---"+comboQuery[1]);
		
        
        comboQuery[2] = "SELECT SSTNUM_FILE_TYPE||'^'||SSTNUM_INDENTTYPE_ID,SSTSTR_INDENTTYPE_NAME from SSTT_INDENTTYPE_MST A where SSTNUM_REQ_FOR = 1 and " +
		                " GNUM_HOSPITAL_CODE = "+MmsConfigUtil.GLOBAL_HOSPITAL_CODE+"  AND GNUM_ISVALID = 1 and sstnum_indenttype_id != 88  and  EXISTS (SELECT 'X' FROM HSTT_STORE_REQTYPE_MST " +
		                " WHERE  GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = "+hosCode+" AND SSTNUM_INDENTTYPE_ID = A.SSTNUM_INDENTTYPE_ID AND SSTNUM_INDENTTYPE_ID = 23 " +
		                " AND SSTNUM_ITEM_CAT_NO =#2#  AND  HSTNUM_STORE_ID = SUBSTR ( NVL(decode('#1#','null','00000000'),'#1#') , 1, 8)) " +
		                "ORDER BY SSTSTR_INDENTTYPE_NAME" ;
		
		System.out.println("Req_Type _combo--- "+comboQuery[2]);					
	
		comboQuery[3] = "0^Pending";
				

		return comboQuery;
	}

	public String getViewQuery() {
		return ""; 
	}

	public String getButtons()
	{
		String strButtons = "";
		return strButtons;
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
		String files = "../../mms/js/IndentTrans.js";
		return files;

	}

	public String[] getRowStatus()
	{
		String[] status = {};
		return status;
		
	}

	public String getEventState() 
	{
	
		String strEvent = "chkUserDefinedFunc";
		return strEvent;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() 
	{
		
		         String[] strButtons = null; 			
		         strButtons = new String[1];				
			  	 strButtons[0] = "View@buttonLogicsOnClick2(4,'VIEW','View')@1@007bb6@glyphicon-fullscreen";
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
		return "";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "2", "HSTDT_REQ_DATE" };
		return orderBy;
	}
	@Override
	public String[] getButtonIcons() {
	//	String[] str={"GenerateOnDesk.png","CancelOnDesk.png","ReturnOnDesk.png","ViewOnDesk.png","PrintOnDesk.png","icon-default.png"};
		String[] str={"GenerateOnDesk.png","CancelOnDesk.png","ReturnOnDesk.png","ViewOnDesk.png","PrintOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
	

}
