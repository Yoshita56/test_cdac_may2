package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.hisconfig.Config;
import hisglobal.transactionutil.TransInterface;

public class IndentSuperApprovalTransUTL extends TransInterface 
{

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
		masterName = "Super Approval Desk";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) 
	{
		String reqTypeId = "0";
		StringBuffer brMainQuery = new StringBuffer(500);
		
		brMainQuery.append("  SELECT c.level_type ||'@'||c.hstnum_store_id||'@'||c.hstnum_tostore_id||'@'|| c.sstnum_item_cat_no|| '@'|| c.req_no|| '@'|| c.sstnum_reqtype_id " );
		brMainQuery.append(" ||'^'||C.from_store||'^'||C.to_store||'^'||C.hstnum_req_no||'^'|| C.req_date||'^'|| C.indent_type_name||'^'|| C.item_cat||'^'|| C.pat_name ");
		brMainQuery.append(" ||'^'|| C.puk||'^'|| C.uregent_flag "); 
		brMainQuery.append(" AS DATA ");
		brMainQuery.append(" FROM   (SELECT '1' AS LEVEL_TYPE,hstnum_store_id, hstnum_tostore_id, sstnum_item_cat_no,sstnum_reqtype_id, hstnum_req_no AS REQ_NO, ");
		brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_store_id)  AS  FROM_STORE,Decode(sstnum_reqtype_id, 65, ");
		brMainQuery.append(" mms_mst.Get_institute_dtls(gnum_hospital_code, gnum_institute_code, gnum_institute_slno), 47, ");
		brMainQuery.append(" mms_mst.Get_supp_dtl(1, gnum_hospital_code, hstnum_supplier_id), ");
		brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_tostore_id)) AS TO_STORE, ");
		brMainQuery.append(" hstnum_req_no, ");
		brMainQuery.append(" To_char(hstdt_req_date, 'DD-Mon-YYYY hh24:mi') AS REQ_DATE, ");
		brMainQuery.append(" mms_mst.Get_indenttype_name(1, gnum_hospital_code, sstnum_reqtype_id) AS INDENT_TYPE_NAME, ");
		brMainQuery.append(" mms_mst.Get_itemcat_dtl(1, gnum_hospital_code, sstnum_item_cat_no)    AS ITEM_CAT, ");
		brMainQuery.append(" Decode(hstnum_urgent_flag, 1, 'Urgent',  'Normal')  AS  UREGENT_FLAG, ");
		brMainQuery.append(" hstdt_req_date,ahis_util.Puk_name(A.hrgnum_puk) AS PAT_NAME, ");
		brMainQuery.append(" A.hrgnum_puk  AS PUK ");
		brMainQuery.append(" FROM   sstt_approvalreq_dtl A ");
		brMainQuery.append(" WHERE  gnum_isvalid = 1 ");
		brMainQuery.append(" AND A.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" ");
		brMainQuery.append(" AND  A.hstnum_store_id IN ");
		brMainQuery.append(" (  ");           
		brMainQuery.append(" SELECT HSTNUM_STORE_ID ");
		brMainQuery.append(" FROM HSTT_APPROVING_AUTH_MST A "); 
		brMainQuery.append(" WHERE   HSTNUM_APP_TYPE=1 "); 
		brMainQuery.append(" AND GNUM_USERID = "+httpSession.getAttribute("SEATID").toString()+" ");
		brMainQuery.append(" )  ") ;     
		brMainQuery.append(" AND (( hstnum_req_status >= 0  AND hstnum_req_status < 40 )) ");
		brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");
		brMainQuery.append(" ) C  WHERE  1 = 1 "); 
		/*
	    brMainQuery.append(" SELECT c.level_type ||'@'||c.HSTNUM_STORE_ID||'@'||c.HSTNUM_TOSTORE_ID||'@'|| c.SSTNUM_ITEM_CAT_NO || '@'|| c.req_no || '@'|| c.SSTNUM_REQTYPE_ID ||'^'||C.FROM_STORE ||'^'||C.TO_STORE ||'^'||C.HSTNUM_REQ_NO ||'^'||");
		brMainQuery.append(" C.REQ_DATE ||'^'|| C.INDENT_TYPE_NAME ||'^'|| C.ITEM_CAT ||'^'|| C.PAT_NAME ||'^'|| C.PUK ||'^'|| C.UREGENT_FLAG");
		brMainQuery.append(" AS DATA "); 
		brMainQuery.append(" FROM (SELECT '1' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
		brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
		brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
		brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
		brMainQuery.append(" AS TO_STORE, ");
		brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
		brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME,");
		brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
		brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
		brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE =");
		brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
		//brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
		//brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
		//brMainQuery.append( httpSession.getAttribute("SEATID").toString());
		//brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
		
		brMainQuery.append(" AND 1 =CASE WHEN (SELECT MMS_MST.config_dtl(1,104,'SPECIAL_APPROVAL') FROM DUAL)::NUMERIC = 0 THEN "); 
		brMainQuery.append("(SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
		brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
		brMainQuery.append( httpSession.getAttribute("SEATID").toString());
		brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
		brMainQuery.append(" ::NUMERIC ");
		brMainQuery.append("   ELSE");
		brMainQuery.append("   1");
		brMainQuery.append("   END");
		
		
		brMainQuery.append(" AND ((HSTNUM_REQ_STATUS >= 0 AND HSTNUM_REQ_STATUS < 40)) ");		
		brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");// DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+")");
		brMainQuery.append(" UNION ALL ");
		brMainQuery.append(" SELECT '2' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
		brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
		brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
		brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
		brMainQuery.append(" AS TO_STORE, ");
		brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
		brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME ,");
		brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
		brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
		brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A ");
		brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
		brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
		brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
		brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 2,");
		brMainQuery.append("  A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_TOSTORE_ID,");
		brMainQuery.append( httpSession.getAttribute("SEATID").toString());
		brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL)");
		brMainQuery.append(" AND ((HSTNUM_REQ_STATUS >= 0 AND HSTNUM_REQ_STATUS < 40)) ");		
		brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");// DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+")");
		brMainQuery.append(" ) C ");
		*/

		if (cmb != null) 
		{
			if (!cmb[0].equals("0"))  
			{
				    brMainQuery = new StringBuffer(500);
				    reqTypeId = cmb[0];
				    
				    
				    brMainQuery.append("  SELECT c.level_type ||'@'||c.hstnum_store_id||'@'||c.hstnum_tostore_id||'@'|| c.sstnum_item_cat_no|| '@'|| c.req_no|| '@'|| c.sstnum_reqtype_id " );
					brMainQuery.append(" ||'^'||C.from_store||'^'||C.to_store||'^'||C.hstnum_req_no||'^'|| C.req_date||'^'|| C.indent_type_name||'^'|| C.item_cat||'^'|| C.pat_name ");
					brMainQuery.append(" ||'^'|| C.puk||'^'|| C.uregent_flag "); 
					brMainQuery.append(" AS DATA ");
					brMainQuery.append(" FROM   (SELECT '1' AS LEVEL_TYPE,hstnum_store_id, hstnum_tostore_id, sstnum_item_cat_no,sstnum_reqtype_id, hstnum_req_no AS REQ_NO, ");
					brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_store_id)  AS  FROM_STORE,Decode(sstnum_reqtype_id, 65, ");
					brMainQuery.append(" mms_mst.Get_institute_dtls(gnum_hospital_code, gnum_institute_code, gnum_institute_slno), 47, ");
					brMainQuery.append(" mms_mst.Get_supp_dtl(1, gnum_hospital_code, hstnum_supplier_id), ");
					brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_tostore_id)) AS TO_STORE, ");
					brMainQuery.append(" hstnum_req_no, ");
					brMainQuery.append(" To_char(hstdt_req_date, 'DD-Mon-YYYY hh24:mi') AS REQ_DATE, ");
					brMainQuery.append(" mms_mst.Get_indenttype_name(1, gnum_hospital_code, sstnum_reqtype_id) AS INDENT_TYPE_NAME, ");
					brMainQuery.append(" mms_mst.Get_itemcat_dtl(1, gnum_hospital_code, sstnum_item_cat_no)    AS ITEM_CAT, ");
					brMainQuery.append(" Decode(hstnum_urgent_flag, 1, 'Urgent',  'Normal')  AS  UREGENT_FLAG, ");
					brMainQuery.append(" hstdt_req_date,ahis_util.Puk_name(A.hrgnum_puk) AS PAT_NAME, ");
					brMainQuery.append(" A.hrgnum_puk  AS PUK ");
					brMainQuery.append(" FROM   sstt_approvalreq_dtl A ");
					brMainQuery.append(" WHERE  gnum_isvalid = 1 ");
					brMainQuery.append(" AND A.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" ");
					brMainQuery.append(" AND  A.hstnum_store_id IN ");
					brMainQuery.append(" (  ");           
					brMainQuery.append(" SELECT HSTNUM_STORE_ID ");
					brMainQuery.append(" FROM HSTT_APPROVING_AUTH_MST A "); 
					brMainQuery.append(" WHERE   HSTNUM_APP_TYPE=1 "); 
					brMainQuery.append(" AND GNUM_USERID = "+httpSession.getAttribute("SEATID").toString()+" ");
					brMainQuery.append(" )  ") ;     
					brMainQuery.append(" AND (( hstnum_req_status >= 0  AND hstnum_req_status < 40 )) ");
					brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");
					brMainQuery.append(" ) C  WHERE  1 = 1 "); 
					/*
				    brMainQuery.append(" SELECT c.level_type ||'@'||c.HSTNUM_STORE_ID||'@'||c.HSTNUM_TOSTORE_ID||'@'|| c.SSTNUM_ITEM_CAT_NO || '@'|| c.req_no || '@'|| c.SSTNUM_REQTYPE_ID ||'^'||C.FROM_STORE ||'^'||C.TO_STORE ||'^'||C.HSTNUM_REQ_NO ||'^'||");
					brMainQuery.append(" C.REQ_DATE ||'^'|| C.INDENT_TYPE_NAME ||'^'|| C.ITEM_CAT ||'^'|| C.PAT_NAME ||'^'|| C.PUK  ||'^'|| C.UREGENT_FLAG");
					brMainQuery.append(" AS DATA "); 
					brMainQuery.append(" FROM (SELECT '1' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
					brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
					//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE, ");
					brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
					brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
					brMainQuery.append(" AS TO_STORE, ");
					brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
					brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME,");
					brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
					brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG, HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
					brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE =");
					brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
					//brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
					//brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
					//brMainQuery.append( httpSession.getAttribute("SEATID").toString());
					//brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
					
					brMainQuery.append(" AND 1 =CASE WHEN (SELECT MMS_MST.config_dtl(1,104,'SPECIAL_APPROVAL') FROM DUAL)::NUMERIC = 0 THEN "); 
					brMainQuery.append("(SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
					brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
					brMainQuery.append( httpSession.getAttribute("SEATID").toString());
					brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
					brMainQuery.append(" ::NUMERIC ");
					brMainQuery.append("   ELSE");
					brMainQuery.append("   1");
					brMainQuery.append("   END");
					//brMainQuery.append("   AND HSTNUM_REQ_STATUS != 40");
					brMainQuery.append("   AND ((HSTNUM_REQ_STATUS >= 0 AND HSTNUM_REQ_STATUS < 49)) ");		
					
					brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") "); 
					brMainQuery.append(" UNION ALL ");
					brMainQuery.append(" SELECT '2' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
					brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
					//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE,");
					brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
					brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
					brMainQuery.append(" AS TO_STORE, ");
					brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
					brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME ,");
					brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
					brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
					brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A ");
					brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
					brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
					brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
					brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 2,");
					brMainQuery.append("  A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_TOSTORE_ID,");
					brMainQuery.append( httpSession.getAttribute("SEATID").toString());
					brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL)");
					brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") ");
					brMainQuery.append(" ) C WHERE 1 = 1 ");
					*/
			}			
			if (cmb[1].equals("0"))  // Approval Pending
			{
				brMainQuery = new StringBuffer(500);
				reqTypeId = cmb[0];
				
				brMainQuery.append("  SELECT c.level_type ||'@'||c.hstnum_store_id||'@'||c.hstnum_tostore_id||'@'|| c.sstnum_item_cat_no|| '@'|| c.req_no|| '@'|| c.sstnum_reqtype_id " );
				brMainQuery.append(" ||'^'||C.from_store||'^'||C.to_store||'^'||C.hstnum_req_no||'^'|| C.req_date||'^'|| C.indent_type_name||'^'|| C.item_cat||'^'|| C.pat_name ");
				brMainQuery.append(" ||'^'|| C.puk||'^'|| C.uregent_flag "); 
				brMainQuery.append(" AS DATA ");
				brMainQuery.append(" FROM   (SELECT '1' AS LEVEL_TYPE,hstnum_store_id, hstnum_tostore_id, sstnum_item_cat_no,sstnum_reqtype_id, hstnum_req_no AS REQ_NO, ");
				brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_store_id)  AS  FROM_STORE,Decode(sstnum_reqtype_id, 65, ");
				brMainQuery.append(" mms_mst.Get_institute_dtls(gnum_hospital_code, gnum_institute_code, gnum_institute_slno), 47, ");
				brMainQuery.append(" mms_mst.Get_supp_dtl(1, gnum_hospital_code, hstnum_supplier_id), ");
				brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_tostore_id)) AS TO_STORE, ");
				brMainQuery.append(" hstnum_req_no, ");
				brMainQuery.append(" To_char(hstdt_req_date, 'DD-Mon-YYYY hh24:mi') AS REQ_DATE, ");
				brMainQuery.append(" mms_mst.Get_indenttype_name(1, gnum_hospital_code, sstnum_reqtype_id) AS INDENT_TYPE_NAME, ");
				brMainQuery.append(" mms_mst.Get_itemcat_dtl(1, gnum_hospital_code, sstnum_item_cat_no)    AS ITEM_CAT, ");
				brMainQuery.append(" Decode(hstnum_urgent_flag, 1, 'Urgent',  'Normal')  AS  UREGENT_FLAG, ");
				brMainQuery.append(" hstdt_req_date,ahis_util.Puk_name(A.hrgnum_puk) AS PAT_NAME, ");
				brMainQuery.append(" A.hrgnum_puk  AS PUK ");
				brMainQuery.append(" FROM   sstt_approvalreq_dtl A ");
				brMainQuery.append(" WHERE  gnum_isvalid = 1 ");
				brMainQuery.append(" AND A.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" ");
				brMainQuery.append(" AND  A.hstnum_store_id IN ");
				brMainQuery.append(" (  ");           
				brMainQuery.append(" SELECT HSTNUM_STORE_ID ");
				brMainQuery.append(" FROM HSTT_APPROVING_AUTH_MST A "); 
				brMainQuery.append(" WHERE   HSTNUM_APP_TYPE=1 "); 
				brMainQuery.append(" AND GNUM_USERID = "+httpSession.getAttribute("SEATID").toString()+" ");
				brMainQuery.append(" )  ") ;     
				brMainQuery.append(" AND (( hstnum_req_status >= 0  AND hstnum_req_status < 40 )) ");
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");
				brMainQuery.append(" ) C  WHERE  1 = 1 "); 
				
				/*
				brMainQuery.append(" SELECT c.level_type ||'@'||c.HSTNUM_STORE_ID||'@'||c.HSTNUM_TOSTORE_ID||'@'|| c.SSTNUM_ITEM_CAT_NO || '@'|| c.req_no || '@'|| c.SSTNUM_REQTYPE_ID||'^'||C.FROM_STORE ||'^'||C.TO_STORE ||'^'||C.HSTNUM_REQ_NO ||'^'||");
				brMainQuery.append(" C.REQ_DATE ||'^'|| C.INDENT_TYPE_NAME ||'^'|| C.ITEM_CAT ||'^'|| C.PAT_NAME ||'^'|| C.PUK  ||'^'|| C.UREGENT_FLAG");
				brMainQuery.append(" AS DATA "); 
				brMainQuery.append(" FROM (SELECT '1' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
				brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
				//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE, ");
				brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
				brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
				brMainQuery.append(" AS TO_STORE, ");
				brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
				brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME,");
				brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
				brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
				brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE =");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				//brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
				//brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
				//brMainQuery.append( httpSession.getAttribute("SEATID").toString());
				//brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
				
				brMainQuery.append(" AND 1 =CASE WHEN (SELECT MMS_MST.config_dtl(1,104,'SPECIAL_APPROVAL') FROM DUAL)::NUMERIC = 0 THEN "); 
				brMainQuery.append("(SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 1,");
				brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
				brMainQuery.append( httpSession.getAttribute("SEATID").toString());
				brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL) ");
				brMainQuery.append(" ::NUMERIC ");
				brMainQuery.append("   ELSE");
				brMainQuery.append("   1");
				brMainQuery.append("   END");				
				brMainQuery.append("   AND ((HSTNUM_REQ_STATUS >= 0 AND HSTNUM_REQ_STATUS < 40)) ");		
			    brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") "); 
				brMainQuery.append(" UNION ALL ");
				brMainQuery.append(" SELECT '2' AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
				brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
				//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE,");
				brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
				brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
				brMainQuery.append(" AS TO_STORE, ");
				brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY') AS REQ_DATE, "); 
				brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME ,");
				brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
				brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK ");
				brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A ");
				brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
				//brMainQuery.append("   AND HSTNUM_REQ_STATUS != 40  ");
				brMainQuery.append("   AND ((HSTNUM_REQ_STATUS >= 0 AND HSTNUM_REQ_STATUS < 40)) ");
				brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (1, A.GNUM_HOSPITAL_CODE , 2,");
				brMainQuery.append("  A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_TOSTORE_ID,");
				brMainQuery.append( httpSession.getAttribute("SEATID").toString());
				brMainQuery.append(",0,0,0,A.HSTNUM_REQ_STATUS) FROM DUAL)");
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") ");
				brMainQuery.append(" ) C WHERE 1 = 1 ");
				*/
			}	
			if (cmb[1].equals("1"))  // Approved Record
			{
				
			    reqTypeId = cmb[0];
			    brMainQuery = new StringBuffer(500);
			    brMainQuery.append(" SELECT    c.level_type ||'@'||c.HSTNUM_STORE_ID||'@'||c.HSTNUM_TOSTORE_ID||'@'|| c.SSTNUM_ITEM_CAT_NO || '@'|| c.req_no || '@'|| c.SSTNUM_REQTYPE_ID  || '^' || c.from_store  || '^' || c.to_store ");
			    brMainQuery.append(" || '^'|| c.hstnum_req_no || '^'|| c.req_date || '^' || c.indent_type_name ");
			    brMainQuery.append(" || '^'|| c.item_cat ||'^'|| C.PAT_NAME ||'^'|| C.PUK  || '^' || c.uregent_flag AS DATA ");
			    brMainQuery.append(" FROM (SELECT DECODE(SIGN(NVL(HSTSTR_LST_APPROVAL_LEVEL,0) - 20),-1,1,2) AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,");
			    brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
			    //brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE, ");
			    brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
				brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
				brMainQuery.append(" AS TO_STORE, ");
			    brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi')AS req_date, "); 
			    brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS indent_type_name, ");
			    brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO)AS item_cat, ");
			    brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS  uregent_flag,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK");
			    brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A WHERE GNUM_ISVALID = 1 ");
			    brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
			    brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
			    brMainQuery.append(" AND HSTSTR_LST_APPROVAL_LEVEL > 0 ");
			    brMainQuery.append(" AND HSTNUM_REQ_STATUS <= 45 AND HSTSTR_LST_APPROVE_SETAID =");
			    brMainQuery.append( httpSession.getAttribute("SEATID").toString());
			    brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") ");
				brMainQuery.append(" ) C WHERE 1 = 1 ");	
				
				
			}
			if (cmb[1].equals("2"))  // Rejected 
			{
				brMainQuery = new StringBuffer(500);
				reqTypeId = cmb[0];
				

				brMainQuery.append("  SELECT c.level_type ||'@'||c.hstnum_store_id||'@'||c.hstnum_tostore_id||'@'|| c.sstnum_item_cat_no|| '@'|| c.req_no|| '@'|| c.sstnum_reqtype_id " );
				brMainQuery.append(" ||'^'||C.from_store||'^'||C.to_store||'^'||C.hstnum_req_no||'^'|| C.req_date||'^'|| C.indent_type_name||'^'|| C.item_cat||'^'|| C.pat_name ");
				brMainQuery.append(" ||'^'|| C.puk||'^'|| C.uregent_flag "); 
				brMainQuery.append(" AS DATA ");
				brMainQuery.append(" FROM   (SELECT '1' AS LEVEL_TYPE,hstnum_store_id, hstnum_tostore_id, sstnum_item_cat_no,sstnum_reqtype_id, hstnum_req_no AS REQ_NO, ");
				brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_store_id)  AS  FROM_STORE,Decode(sstnum_reqtype_id, 65, ");
				brMainQuery.append(" mms_mst.Get_institute_dtls(gnum_hospital_code, gnum_institute_code, gnum_institute_slno), 47, ");
				brMainQuery.append(" mms_mst.Get_supp_dtl(1, gnum_hospital_code, hstnum_supplier_id), ");
				brMainQuery.append(" mms_mst.Get_store_dtl(1, gnum_hospital_code, hstnum_tostore_id)) AS TO_STORE, ");
				brMainQuery.append(" hstnum_req_no, ");
				brMainQuery.append(" To_char(hstdt_req_date, 'DD-Mon-YYYY hh24:mi') AS REQ_DATE, ");
				brMainQuery.append(" mms_mst.Get_indenttype_name(1, gnum_hospital_code, sstnum_reqtype_id) AS INDENT_TYPE_NAME, ");
				brMainQuery.append(" mms_mst.Get_itemcat_dtl(1, gnum_hospital_code, sstnum_item_cat_no)    AS ITEM_CAT, ");
				brMainQuery.append(" Decode(hstnum_urgent_flag, 1, 'Urgent',  'Normal')  AS  UREGENT_FLAG, ");
				brMainQuery.append(" hstdt_req_date,ahis_util.Puk_name(A.hrgnum_puk) AS PAT_NAME, ");
				brMainQuery.append(" A.hrgnum_puk  AS PUK ");
				brMainQuery.append(" FROM   sstt_approvalreq_dtl A ");
				brMainQuery.append(" WHERE  gnum_isvalid = 1 ");
				brMainQuery.append(" AND A.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" ");
				brMainQuery.append(" AND  A.hstnum_store_id IN ");
				brMainQuery.append(" (  ");           
				brMainQuery.append(" SELECT HSTNUM_STORE_ID ");
				brMainQuery.append(" FROM HSTT_APPROVING_AUTH_MST A "); 
				brMainQuery.append(" WHERE   HSTNUM_APP_TYPE=1 "); 
				brMainQuery.append(" AND GNUM_USERID = "+httpSession.getAttribute("SEATID").toString()+" ");
				brMainQuery.append(" )  ") ;     
				brMainQuery.append(" AND HSTNUM_REQ_STATUS = 99 ");
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = "+reqTypeId+" ");
				brMainQuery.append(" ) C  WHERE  1 = 1 "); 
				
				/*
			    brMainQuery.append(" SELECT c.level_type ||'@'||c.HSTNUM_STORE_ID||'@'||c.HSTNUM_TOSTORE_ID||'@'|| c.SSTNUM_ITEM_CAT_NO || '@'|| c.req_no || '@'|| c.SSTNUM_REQTYPE_ID||'^'||C.FROM_STORE ||'^'||C.TO_STORE ||'^'||C.HSTNUM_REQ_NO ||'^'||");
				brMainQuery.append(" C.REQ_DATE ||'^'|| C.INDENT_TYPE_NAME ||'^'|| C.ITEM_CAT ||'^'|| C.PAT_NAME ||'^'|| C.PUK ||'^'|| C.UREGENT_FLAG");
				brMainQuery.append(" AS DATA "); 
				brMainQuery.append(" FROM (SELECT '1'  AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
				brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
				//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE, ");
				brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
				brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
				brMainQuery.append(" AS TO_STORE, ");
				brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
				brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME,");
				brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
				brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK");
				brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE =");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				brMainQuery.append(" AND HSTSTR_LST_APPROVAL_LEVEL > 0 ");
				brMainQuery.append(" AND HSTNUM_REQ_STATUS = 99 ");
				//brMainQuery.append(" AND 1 = (SELECT MMS_MST.get_approval_status (3, A.GNUM_HOSPITAL_CODE , 1,");
				//brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
				//brMainQuery.append( httpSession.getAttribute("SEATID").toString());
				//brMainQuery.append(",0,0,0,A.HSTSTR_LST_APPROVAL_LEVEL) FROM DUAL) ");
				
				brMainQuery.append(" AND 1 =CASE WHEN (SELECT MMS_MST.config_dtl(1,104,'SPECIAL_APPROVAL') FROM DUAL)::NUMERIC = 0 THEN "); 
				brMainQuery.append("(SELECT MMS_MST.get_approval_status (3, A.GNUM_HOSPITAL_CODE , 1,");
				brMainQuery.append(" A.SSTNUM_REQTYPE_ID, A.SSTNUM_ITEM_CAT_NO, A.HSTNUM_STORE_ID,");
				brMainQuery.append( httpSession.getAttribute("SEATID").toString());
				brMainQuery.append(",0,0,0,A.HSTSTR_LST_APPROVAL_LEVEL) FROM DUAL) ");
				brMainQuery.append(" ::NUMERIC ");
				brMainQuery.append("   ELSE");
				brMainQuery.append("   1");
				brMainQuery.append("   END");				
				
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") "); 
				brMainQuery.append(" UNION ALL ");
				brMainQuery.append(" SELECT '2'  AS LEVEL_TYPE,HSTNUM_STORE_ID,HSTNUM_TOSTORE_ID,SSTNUM_ITEM_CAT_NO,SSTNUM_REQTYPE_ID,HSTNUM_REQ_NO AS REQ_NO,"); 
				brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_STORE_ID) AS FROM_STORE, ");
				//brMainQuery.append(" MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID) AS TO_STORE,");
				brMainQuery.append(" DECODE (SSTNUM_REQTYPE_ID,65,MMS_MST.GET_INSTITUTE_DTLS(GNUM_HOSPITAL_CODE,GNUM_INSTITUTE_CODE,GNUM_INSTITUTE_SLNO), ");
				brMainQuery.append(" 47,MMS_MST.GET_SUPP_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID),MMS_MST.GET_STORE_DTL(1,GNUM_HOSPITAL_CODE,HSTNUM_TOSTORE_ID)) ");
				brMainQuery.append(" AS TO_STORE, ");
				brMainQuery.append(" HSTNUM_REQ_NO,TO_CHAR(HSTDT_REQ_DATE,'DD-Mon-YYYY hh24:mi') AS REQ_DATE, "); 
				brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1,GNUM_HOSPITAL_CODE,SSTNUM_REQTYPE_ID) AS INDENT_TYPE_NAME ,");
				brMainQuery.append(" MMS_MST.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) AS ITEM_CAT, ");
				brMainQuery.append(" DECODE(HSTNUM_URGENT_FLAG,1,'Urgent','Normal') AS UREGENT_FLAG,HSTDT_REQ_DATE ,AHIS_UTIL.PUK_NAME(A.HRGNUM_PUK) AS PAT_NAME,A.HRGNUM_PUK AS PUK");
				brMainQuery.append(" FROM SSTT_APPROVALREQ_DTL A ");
	     		brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
				brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
				brMainQuery.append( httpSession.getAttribute("HOSPITAL_CODE").toString());
				brMainQuery.append(" AND HSTSTR_LST_APPROVAL_LEVEL > 0 AND HSTNUM_REQ_STATUS = 99 ");
			
				brMainQuery.append(" AND SSTNUM_REQTYPE_ID = DECODE("+reqTypeId+",0,SSTNUM_REQTYPE_ID,"+reqTypeId+") ");
				brMainQuery.append(" ) C WHERE 1 = 1 ");
				*/
				
			}
		}
		System.out.println("Super Approval Desk Main Query-[ IndentSuperApprovalTransUTL ]->>>>"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String[] search_field = {"1", "C.FROM_STORE","2", "C.TO_STORE"};
		if(cmbVal != null && cmbVal[0].equals("13"))
		{
			 search_field = new String[4];
			 search_field[0] = "8";
			 search_field[1] = "C.PUK";
			 search_field[2] = "7";
			 search_field[3] = "C.PAT_NAME";
			
		}
		return search_field;
	}

	public String[] getComboHeader() 
	{
		String[] strComboHeader = {"0","Request Type","1","Status"};
	    return strComboHeader;
	 
	}

	public String[] getColumnHeader() 
	{	
		String[] strColumnHeader = new String[6];
		
			strColumnHeader[0] = "Raising Store";
			strColumnHeader[1] = "Issuing Store";
			strColumnHeader[2] = "Indent No";
			strColumnHeader[3] = "Indent Date";
			strColumnHeader[4] = "Indent Type";
			strColumnHeader[5] = "Category";
		
		if(cmbVal != null && cmbVal[0].equals("13"))
		{
			
			 strColumnHeader = new String[8];
		
			strColumnHeader[0] = "Raising Store";
			strColumnHeader[1] = "Issuing Store";
			strColumnHeader[2] = "Indent No";
			strColumnHeader[3] = "Indent Date";
			strColumnHeader[4] = "Indent Type";
			strColumnHeader[5] = "Category";
			strColumnHeader[6] = "Patient Name";
			strColumnHeader[7] = "CR No.";
		}
		
		
		return strColumnHeader;
		
	}      

	public String[] getComboQuery()
	{
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String[] comboQuery = new String[5];
		String strAuthId="";
		if(httpSession.getAttribute("USERVALUE")!=null && httpSession.getAttribute("USERVALUE").toString().equals("5"))
		{
			strAuthId = httpSession.getAttribute("USERVALUE").toString();
		}
		else
		{
			strAuthId = "1";
		}
	    
		comboQuery[0] = "select SSTNUM_INDENTTYPE_ID,INITCAP(SSTSTR_INDENTTYPE_NAME) from SSTT_INDENTTYPE_MST where  GNUM_ISVALID = 1 and SSTNUM_INDENTTYPE_ID not in (11,86) and GNUM_HOSPITAL_CODE = "+Config.SUPER_USER_HOSPITAL_CODE+" AND SSTNUM_AUTHTYPE_ID = '"+strAuthId+"'";
					             	
		comboQuery[1] = "0^To Be Approved#1^Approved#2^Rejected";
		
		//System.out.println("comboQuery[0]-->>>>"+comboQuery[0]);
			
		return comboQuery;
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
		String files = "../../mms/js/IndentApproval.js";
		return files;

	}

	public String[] getRowStatus()
	{
		// Working 
		String[] status = {"Urgent", "8", "#7D786C", "Urgent"};
		return status;
//		String[] strRowStatus = new String[0];
//		return strRowStatus;
		
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
			     strButtons = new String[2];
				 strButtons[0] = "Approval@buttonLogicsOnClick1(1,'APPROVAL','Approval')@1@3C8730@glyphicon-ok";
				 strButtons[1] = "View@buttonLogicsOnClick1(2,'VIEW','View')@1@007bb6@glyphicon-fullscreen";  // Name@jsFunction()@Button Enable/Disable checkFlg@colorCode@icon
				// strButtons[2] = "Certificate@certificateOpen()@1";	
				// System.out.println("cmbVal[0]"+cmbVal[0]);
				 
				
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
		return "buttonLogicsOnChangeCombos";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "4","HSTDT_REQ_DATE"};
		return orderBy;
	}

	@Override
	public String getButtons() {
		// TODO Auto-generated method stub
		return "";
	} 
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"ApprovalOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}

}
