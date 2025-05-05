/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransUTL.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.transactionutil.TransInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransUTL.
 */
public class SupplierDeskInterfaceTransUTL extends TransInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/** The cmb val. */
	String[] cmbVal = null;

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#setHttpSession(javax.servlet .http.HttpSession)
	 */
	@Override
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#setCombo(java.lang.String[])
	 */
	@Override
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getMasterName()
	 */
	@Override
	public String getMasterName() {
		String masterName = "Supplier Interface Desk";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getRecord_per_page()
	 */
	@Override
	public int getRecord_per_page() {
		return 12;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getViewHeader()
	 */
	@Override
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getMainQuery(java.lang.String[])
	 */
	@Override
	public String getMainQuery(String cmb[]) 
	{
		StringBuffer brMainQuery = new StringBuffer(1500);
		try 
		{
			String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
			if (cmb != null) 
			{
				       
						if (cmb[1].equals("0")) // All
						{
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@' || C.HSTNUM_STORE_ID || '@' || C.PO_DATE || '@' || C.HSTNUM_SUPP_ACCEPTANCE_FLAG|| '@' || C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID || '@'||HSTNUM_PREDELIVERY_FLAG|| '@'||HSTNUM_PREDELIVERY_FLAG");      
							brMainQuery.append("  || '^'|| C.SSTSTR_PO_PREFIX || ' ('  || C.HSTNUM_PO_NO   || ')^' || C.PO_DATE ");
							brMainQuery.append("  || '^'|| C.ORDER_QTY || '^'   || C.BALANCE_QTY    || '^'  || C.STS || '^'  || C.tot_item ||'^'|| C.HSTNUM_SUPP_ACCEPTANCE_FLAG||'^'||C.PO_PREFIX ||'^'|| HSTNUM_PREDELIVERY_FLAG AS DATA ");
							brMainQuery.append("  FROM (   "); 
							brMainQuery.append("  SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  SUM(HSTNUM_ORDER_QTY) AS ORDER_QTY, "); 
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX, "); 
							brMainQuery.append("  SUM((HSTNUM_ORDER_QTY - HSTNUM_STOP_QTY) - (HSTNUM_ACCEPTED_QTY + HSTNUM_REJQTY_AFT_VERIFY + "); 
							brMainQuery.append("  HSTNUM_SUPP_RETURN_QTY - HSTNUM_REPLACEMENT_ORDER_QTY)) AS BALANCE_QTY, ");
							brMainQuery.append("  DECODE(A.HSTNUM_SUPP_ACCEPTANCE_FLAG,0,'Acceptance Pending','Delivery Pending') AS STS, ");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG, A.HSTDT_PO_DATE,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID,(SELECT   string_agg(DISTINCT (mms_mst.get_item_dtl(1, gnum_hospital_code,hstnum_itembrand_id)),");
							brMainQuery.append("   ' / ' ) FROM hstt_po_item_dtl  WHERE gnum_isvalid = 1   AND gnum_hospital_code = 998    AND hstnum_po_no = a.hstnum_po_no  AND hstnum_store_id = a.hstnum_store_id ");
							brMainQuery.append("  GROUP BY hstnum_po_no) AS tot_item, HSTNUM_PREDELIVERY_FLAG");
							brMainQuery.append("  FROM SSTT_PO_DTL A, HSTT_PO_ITEM_DTL B ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND B.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_CANCEL_FLAG = 0 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTDT_APPROVAL_DATE IS NOT NULL ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");							
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
							brMainQuery.append("  AND A.HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ");
							brMainQuery.append("  AND A.HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
							brMainQuery.append("  AND (A.HSTNUM_PO_STATUS = 1 OR A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 0) ");
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");               
							brMainQuery.append("  GROUP BY A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, A.HSTDT_PO_DATE, A.SSTSTR_PO_PREFIX,");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.GNUM_HOSPITAL_CODE,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID ) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");		
						} 
					    if (cmb[1].equals("1")) // Acceptance Pending
						{
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@' || C.HSTNUM_STORE_ID || '@' || C.PO_DATE || '@' || C.HSTNUM_SUPP_ACCEPTANCE_FLAG|| '@' || C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID ");      
							brMainQuery.append("  || '^'|| C.SSTSTR_PO_PREFIX || ' ('  || C.HSTNUM_PO_NO   || ')^' || C.PO_DATE ");
							brMainQuery.append("  || '^'|| C.ORDER_QTY || '^'   || C.BALANCE_QTY    || '^'  || C.STS || '^'  || C.tot_item ||'^'|| C.HSTNUM_SUPP_ACCEPTANCE_FLAG ||'^'||C.PO_PREFIX AS DATA ");
							brMainQuery.append("  FROM (   "); 
							brMainQuery.append("  SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  SUM(HSTNUM_ORDER_QTY) AS ORDER_QTY, "); 
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX, "); 
							brMainQuery.append("  SUM((HSTNUM_ORDER_QTY - HSTNUM_STOP_QTY) - (HSTNUM_ACCEPTED_QTY + HSTNUM_REJQTY_AFT_VERIFY + "); 
							brMainQuery.append("  HSTNUM_SUPP_RETURN_QTY - HSTNUM_REPLACEMENT_ORDER_QTY)) AS BALANCE_QTY, ");
							brMainQuery.append("  DECODE(A.HSTNUM_SUPP_ACCEPTANCE_FLAG,0,'Acceptance Pending','Delivery Pending') AS STS, ");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG, A.HSTDT_PO_DATE,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID,(SELECT   string_agg(DISTINCT (mms_mst.get_item_dtl(1, gnum_hospital_code,hstnum_itembrand_id)),");
							brMainQuery.append("   ' / ' ) FROM hstt_po_item_dtl  WHERE gnum_isvalid = 1   AND gnum_hospital_code = 998    AND hstnum_po_no = a.hstnum_po_no  AND hstnum_store_id = a.hstnum_store_id ");
							brMainQuery.append("  GROUP BY hstnum_po_no) AS tot_item ");
							brMainQuery.append("  FROM SSTT_PO_DTL A, HSTT_PO_ITEM_DTL B ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND B.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_CANCEL_FLAG = 0 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTDT_APPROVAL_DATE IS NOT NULL ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
							brMainQuery.append("  AND A.HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ");
							brMainQuery.append("  AND A.HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 0 ");
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");               
							brMainQuery.append("  GROUP BY A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, A.HSTDT_PO_DATE, A.SSTSTR_PO_PREFIX,");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.GNUM_HOSPITAL_CODE,A.SSTNUM_POTYPE_ID,A.HSTNUM_SUPPLIER_ID  ) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							
						}
					
						if (cmb[1].equals("2")) // Delivery Pending
						{
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@' || C.HSTNUM_STORE_ID || '@' || C.PO_DATE || '@' || C.HSTNUM_SUPP_ACCEPTANCE_FLAG|| '@' || C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID ");      
							brMainQuery.append("  || '^'|| C.SSTSTR_PO_PREFIX || ' ('  || C.HSTNUM_PO_NO   || ')^' || C.PO_DATE ");
							brMainQuery.append("  || '^'|| C.ORDER_QTY || '^'   || C.BALANCE_QTY    || '^'  || C.STS || '^'  || C.tot_item ||'^'|| C.HSTNUM_SUPP_ACCEPTANCE_FLAG ||'^'||C.PO_PREFIX AS DATA ");
							brMainQuery.append("  FROM (   "); 
							brMainQuery.append("  SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  SUM(HSTNUM_ORDER_QTY) AS ORDER_QTY, "); 
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX, "); 
							brMainQuery.append("  SUM((HSTNUM_ORDER_QTY - HSTNUM_STOP_QTY) - (HSTNUM_ACCEPTED_QTY + HSTNUM_REJQTY_AFT_VERIFY + "); 
							brMainQuery.append("  HSTNUM_SUPP_RETURN_QTY - HSTNUM_REPLACEMENT_ORDER_QTY)) AS BALANCE_QTY, ");
							brMainQuery.append("  DECODE(A.HSTNUM_SUPP_ACCEPTANCE_FLAG,0,'Acceptance Pending','Delivery Pending') AS STS, ");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG, A.HSTDT_PO_DATE,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID,(SELECT   string_agg(DISTINCT (mms_mst.get_item_dtl(1, gnum_hospital_code,hstnum_itembrand_id)),");
							brMainQuery.append("   ' / ' ) FROM hstt_po_item_dtl  WHERE gnum_isvalid = 1   AND gnum_hospital_code = 998    AND hstnum_po_no = a.hstnum_po_no  AND hstnum_store_id = a.hstnum_store_id ");
							brMainQuery.append("  GROUP BY hstnum_po_no) AS tot_item ");
							brMainQuery.append("  FROM SSTT_PO_DTL A, HSTT_PO_ITEM_DTL B ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND B.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_CANCEL_FLAG = 0 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTDT_APPROVAL_DATE IS NOT NULL ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
							brMainQuery.append("  AND A.HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ");
							brMainQuery.append("  AND A.HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 1 ");
							brMainQuery.append("  AND A.HSTNUM_PO_STATUS NOT IN( 2  ) ");	
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");               
							brMainQuery.append("  GROUP BY A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, A.HSTDT_PO_DATE, A.SSTSTR_PO_PREFIX,");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");						
						}
						
						if (cmb[1].equals("3")) // Payment Pending
						{
							brMainQuery = new StringBuffer(1500);
							
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@'  || C.HSTNUM_STORE_ID   || '@'   || C.PO_DATE");
							brMainQuery.append("  || '@'  || C.HSTNUM_SUPP_ACCEPTANCE_FLAG ||'@'|| C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID || '^' || C.SSTSTR_PO_PREFIX   || ' ('  ||   C.HSTNUM_PO_NO   || ')^'  || C.PO_DATE");
							brMainQuery.append("  || '^'   || C.HSTNUM_PO_NET_AMOUNT || '^' || C.HSTNUM_PENELTY_AMT || '^'  || C.HSTNUM_RECOVERY_AMT ");
							brMainQuery.append("  || '^'   || C.HSTNUM_PAID_AMT ||'^0' ||'^'||C.PO_PREFIX AS DATA "); 
							brMainQuery.append("  FROM (     SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  HSTNUM_PO_NET_AMOUNT, HSTNUM_PENELTY_AMT, HSTNUM_RECOVERY_AMT, HSTNUM_PAID_AMT,A.HSTDT_PO_DATE, ");
							brMainQuery.append("  A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID,A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.HSTNUM_SUPPLIER_ID,");
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX "); 
							brMainQuery.append("  FROM HSTT_PO_DTL A ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 1 ");
							brMainQuery.append("  AND A.HSTNUM_PAYMENT_FLAG = 0 ");
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");     
							brMainQuery.append("  ) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");			

						}
						
						if (cmb[1].equals("4")) // Rejected
						{
							brMainQuery = new StringBuffer(1500);
							
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@' || C.HSTNUM_STORE_ID || '@' || C.PO_DATE || '@' || C.HSTNUM_SUPP_ACCEPTANCE_FLAG|| '@' || C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID ");      
							brMainQuery.append("  || '^'|| C.SSTSTR_PO_PREFIX || ' ('  || C.HSTNUM_PO_NO   || ')^' || C.PO_DATE ");
							brMainQuery.append("  || '^'|| C.ORDER_QTY || '^'   || C.BALANCE_QTY    || '^'  || C.REJECT_DATE || '^'  || C.ITEM_NAME ||'^'|| C.HSTNUM_SUPP_ACCEPTANCE_FLAG  ||'^'||C.PO_PREFIX AS DATA ");
							brMainQuery.append("  FROM (   "); 
							brMainQuery.append("  SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  SUM(HSTNUM_ORDER_QTY) AS ORDER_QTY, "); 
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX, "); 
							brMainQuery.append("  SUM((HSTNUM_ORDER_QTY - HSTNUM_STOP_QTY) - (HSTNUM_ACCEPTED_QTY + HSTNUM_REJQTY_AFT_VERIFY + "); 
							brMainQuery.append("  HSTNUM_SUPP_RETURN_QTY - HSTNUM_REPLACEMENT_ORDER_QTY)) AS BALANCE_QTY, ");
							brMainQuery.append("  TO_CHAR(A.HSTDT_SUPP_ACCEPTANACE_DATE,'DD-Mon-YYYY') AS REJECT_DATE, ");
							brMainQuery.append("  MMS_MST.GET_ITEM_DTL(1, A.GNUM_HOSPITAL_CODE,A.HSTNUM_ITEMBRAND_ID) AS ITEM_NAME, "); 
							brMainQuery.append("  DECODE(A.HSTNUM_SUPP_ACCEPTANCE_FLAG,0,'Acceptance Pending','Delivery Pending') AS STS, ");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG, A.HSTDT_PO_DATE,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID,(SELECT   string_agg(DISTINCT (mms_mst.get_item_dtl(1, gnum_hospital_code,hstnum_itembrand_id)),");
							brMainQuery.append("   ' / ' ) FROM hstt_po_item_dtl  WHERE gnum_isvalid = 1   AND gnum_hospital_code = 998    AND hstnum_po_no = a.hstnum_po_no  AND hstnum_store_id = a.hstnum_store_id ");
							brMainQuery.append("  GROUP BY hstnum_po_no) AS tot_item ");
							brMainQuery.append("  FROM SSTT_PO_DTL A, HSTT_PO_ITEM_DTL B ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 0 ");
							brMainQuery.append("  AND B.GNUM_ISVALID = 0 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_CANCEL_FLAG = 0 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTDT_APPROVAL_DATE IS NOT NULL ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
							brMainQuery.append("  AND A.HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ");
							brMainQuery.append("  AND A.HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 2 ");
							brMainQuery.append("  AND A.HSTNUM_REJECT_FLAG = 1 ");
							brMainQuery.append("  AND A.HSTDT_PO_DATE >= SYSDATE - 365 ");
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");               
							brMainQuery.append("  GROUP BY A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, A.HSTDT_PO_DATE, A.SSTSTR_PO_PREFIX,");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID,A.HSTNUM_SUPPLIER_ID ) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");			
							
							
						}
						if (cmb[1].equals("5")) // Closed
						{
							brMainQuery = new StringBuffer(1500);
							
							
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@'  || C.HSTNUM_STORE_ID   || '@'   || C.PO_DATE");
							brMainQuery.append("  || '@1@'|| C.SSTNUM_POTYPE_ID ||'@'|| C.HSTNUM_SUPPLIER_ID|| '^' || C.SSTSTR_PO_PREFIX   || ' ('  ||   C.HSTNUM_PO_NO   || ')^'  || C.PO_DATE");
							brMainQuery.append("  || '^'   || C.HSTNUM_PO_NET_AMOUNT || '^' || C.HSTNUM_PENELTY_AMT || '^'  || C.HSTNUM_RECOVERY_AMT ");
							brMainQuery.append("  || '^'   || C.HSTNUM_PAID_AMT  || '^0' ||'^'||C.PO_PREFIX AS DATA "); 
							brMainQuery.append("  FROM (     SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  HSTNUM_PO_NET_AMOUNT, HSTNUM_PENELTY_AMT, HSTNUM_RECOVERY_AMT, HSTNUM_PAID_AMT,A.HSTDT_PO_DATE, ");
							brMainQuery.append("  A.GNUM_HOSPITAL_CODE,A.SSTNUM_POTYPE_ID,A.HSTNUM_SUPPLIER_ID, ");
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX "); 
							brMainQuery.append("  FROM HSTT_PO_DTL A ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.HSTNUM_PAYMENT_FLAG = 1 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTNUM_PO_STATUS = 2 ");
							brMainQuery.append("  AND A.HSTDT_PO_DATE >= SYSDATE - 365 ");
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");     
							brMainQuery.append("  ) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");		
							
						}
						
						if (cmb[1].equals("6")) // Delivery Done
						{
							brMainQuery = new StringBuffer(1500);
							brMainQuery.append("  SELECT C.HSTNUM_PO_NO  || '@' || C.HSTNUM_STORE_ID || '@' || C.PO_DATE || '@' || C.HSTNUM_SUPP_ACCEPTANCE_FLAG|| '@' || C.SSTNUM_POTYPE_ID || '@'|| C.HSTNUM_SUPPLIER_ID ");      
							brMainQuery.append("  || '^'|| C.SSTSTR_PO_PREFIX || ' ('  || C.HSTNUM_PO_NO   || ')^' || C.PO_DATE ");
							brMainQuery.append("  || '^'|| C.ORDER_QTY || '^'   || C.BALANCE_QTY    || '^'  || C.STS || '^'  || C.tot_item ||'^'|| C.HSTNUM_SUPP_ACCEPTANCE_FLAG ||'^'||C.PO_PREFIX AS DATA ");
							brMainQuery.append("  FROM (   "); 
							brMainQuery.append("  SELECT A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, TO_CHAR(A.HSTDT_PO_DATE,'DD-Mon-YYYY') AS PO_DATE, A.SSTSTR_PO_PREFIX, ");
							brMainQuery.append("  SUM(HSTNUM_ORDER_QTY) AS ORDER_QTY, "); 
							brMainQuery.append("  A.SSTSTR_PO_PREFIX || ' ('  || A.HSTNUM_PO_NO ||')'  AS PO_PREFIX, "); 
							brMainQuery.append("  SUM((HSTNUM_ORDER_QTY - HSTNUM_STOP_QTY) - (HSTNUM_ACCEPTED_QTY + HSTNUM_REJQTY_AFT_VERIFY + "); 
							brMainQuery.append("  HSTNUM_SUPP_RETURN_QTY - HSTNUM_REPLACEMENT_ORDER_QTY)) AS BALANCE_QTY, ");
							brMainQuery.append("  DECODE(A.HSTNUM_SUPP_ACCEPTANCE_FLAG,0,'Acceptance Pending','Delivery Done') AS STS, ");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG, A.HSTDT_PO_DATE,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID,(SELECT   string_agg(DISTINCT (mms_mst.get_item_dtl(1, gnum_hospital_code,hstnum_itembrand_id)),");
							brMainQuery.append("   ' / ' ) FROM hstt_po_item_dtl  WHERE gnum_isvalid = 1   AND gnum_hospital_code = 998    AND hstnum_po_no = a.hstnum_po_no  AND hstnum_store_id = a.hstnum_store_id ");
							brMainQuery.append("  GROUP BY hstnum_po_no) AS tot_item ");
							brMainQuery.append("  FROM SSTT_PO_DTL A, HSTT_PO_ITEM_DTL B ");
							brMainQuery.append("  WHERE A.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND B.GNUM_ISVALID = 1 ");
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = " + strHospCode+" ");
							brMainQuery.append("  AND A.HSTNUM_CANCEL_FLAG = 0 ");
							brMainQuery.append("  AND A.SSTNUM_POTYPE_ID != 21 "); 
							brMainQuery.append("  AND A.HSTDT_APPROVAL_DATE IS NOT NULL ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_INTERFACE_FLAG =1");		
							brMainQuery.append("  AND A.GNUM_HOSPITAL_CODE = B.GNUM_HOSPITAL_CODE ");
							brMainQuery.append("  AND A.HSTNUM_STORE_ID = B.HSTNUM_STORE_ID ");
							brMainQuery.append("  AND A.HSTNUM_PO_NO = B.HSTNUM_PO_NO ");
							brMainQuery.append("  AND A.HSTNUM_SUPP_ACCEPTANCE_FLAG = 1 ");
							brMainQuery.append("  AND A.HSTNUM_PO_STATUS =2 ");	
							brMainQuery.append("  AND A.HSTNUM_SUPPLIER_ID = " + cmb[0]+" ");               
							brMainQuery.append("  GROUP BY A.HSTNUM_PO_NO, A.HSTNUM_STORE_ID, A.HSTDT_PO_DATE, A.SSTSTR_PO_PREFIX,");
							brMainQuery.append("  A.HSTNUM_SUPP_ACCEPTANCE_FLAG,A.GNUM_HOSPITAL_CODE ,A.SSTNUM_POTYPE_ID ,A.HSTNUM_SUPPLIER_ID) C ");
							brMainQuery.append("  WHERE   C.GNUM_HOSPITAL_CODE = " + strHospCode+" ");						
						}
			}
							
						
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		// System.out.println("Supplier Interface Desk Main Query:::==>"+brMainQuery.toString());

		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getComboQuery()
	 */
	@Override
	public String[] getComboQuery() {
		String[] strComboQry = new String[2];
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");

		strComboQry[0] ="SELECT HSTNUM_SUPPLIER_ID, HSTSTR_SUPPLIER_NAME AS STORE_NAME "
			+ "FROM HSTT_SUPPLIER_MST A  "
			+ "WHERE GNUM_ISVALID = 1  "
			+ "AND GNUM_HOSPITAL_CODE = '" + strHospCode + "' "
			+ "AND HSTNUM_INTERFACE_REQ_FLAG = 1 "
			+ "AND GDT_EFFECTIVE_FRM <= TRUNC(SYSDATE) "
			+ "AND HSTNUM_SUPPLIER_ID IN  "
			+ "( "
			+ "SELECT gnum_column_value "
			+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q "
			+ "WHERE P.GBL_ISVALID = 1 "
			+ "AND Q.GBL_ISVALID = 1 "
			+ "AND P.gnum_hospital_code = '" + strHospCode + "' "
			+ "AND P.gnum_hospital_code = q.gnum_hospital_code "
			+ "AND P.gnum_metatable_id = q.gnum_metatable_id "
			+ "AND UPPER(gstr_table_name) = UPPER('HSTT_SUPPLIER_MST') "
			+ "AND UPPER(gstr_column_name) = UPPER('HSTNUM_SUPPLIER_ID') "
			+ "AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid('"+httpSession.getAttribute("SEATID").toString()+"','"+strHospCode+"') " 
			+ ") "
			+ "ORDER BY HSTSTR_SUPPLIER_NAME";
		//h
				
		//strComboQry[1] = "0^"+HisLanguageProperties.getValue(httpSession, "label.common.All")+"#1^"+HisLanguageProperties.getValue(httpSession, "label.common.Acceptance_Pending")+"#2^"+HisLanguageProperties.getValue(httpSession, "label.common.Delivery_Pending")+"#3^"+HisLanguageProperties.getValue(httpSession, "label.common.Payment_Pending")+"#4^"+HisLanguageProperties.getValue(httpSession, "label.common.Rejected")+"#5^"+HisLanguageProperties.getValue(httpSession, "label.common.Closed");
		strComboQry[1] = "0^"+HisLanguageProperties.getValue(httpSession, "label.common.Active")+"#1^"+HisLanguageProperties.getValue(httpSession, "label.common.Acceptance_Pending")+"#2^"+HisLanguageProperties.getValue(httpSession, "label.common.Delivery_Pending")
		//+"#3^"+HisLanguageProperties.getValue(httpSession, "label.common.Payment_Pending")
		+"#4^"+HisLanguageProperties.getValue(httpSession, "label.common.Rejected")+"#5^"+HisLanguageProperties.getValue(httpSession, "label.common.Closed")+"#6^"+HisLanguageProperties.getValue(httpSession, "label.common.Delivery_Done");
 	//System.out.println("Combo--->"+strComboQry[0].toString());

		return strComboQry;
	}
		
	public String[] getSearchField()
	{
		String search_field[] = { "1", "C.PO_PREFIX", "2", "C.PO_DATE" };
		if (cmbVal != null && (cmbVal[0].equals("0")||cmbVal[0].equals("1")||cmbVal[0].equals("2")||cmbVal[0].equals("4")||cmbVal[0].equals("6"))) 
		{		
			search_field = new String[6];			
			search_field[0] = "1";
			search_field[1] = "C.PO_PREFIX";
	
			search_field[2] = "2";
			search_field[3] = "C.PO_DATE";	
			
		}
		if (cmbVal != null && (cmbVal[0].equals("3")||cmbVal[0].equals("5"))) 
		{		
			search_field = new String[6];			
			search_field[0] = "1";
			search_field[1] = "C.PO_PREFIX";
	
			search_field[2] = "2";
			search_field[3] = "C.PO_DATE";
			
			search_field[2] = "3";
			search_field[3] = "C.HSTNUM_PO_NET_AMOUNT";
		
		}

		return search_field;
	}

	
	
	

	/**
	 * 0^0 0 Means Combo From Query, 1 Means User Defined Combo,0 After ^ Means Select Value, 1 Means All,2 Means Default Selected.
	 * 
	 * @return the column header
	 */	
	public String[] getColumnHeader() 
	{

		String[] strColumnHeader = new String[6];		
		strColumnHeader[0] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Prefix(PO_No)");
		strColumnHeader[1] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Date");		
		strColumnHeader[2] = HisLanguageProperties.getValue(httpSession, "label.common.Ordered_qty");
		strColumnHeader[3] = HisLanguageProperties.getValue(httpSession, "label.common.Balance_qty");
		strColumnHeader[4] = HisLanguageProperties.getValue(httpSession, "label.common.Status");
		strColumnHeader[5] = HisLanguageProperties.getValue(httpSession, "label.common.Item_Name");
		if (cmbVal != null) 
		{
			if (cmbVal[1].equals("0")||cmbVal[1].equals("1")||cmbVal[1].equals("2")||cmbVal[1].equals("4")||cmbVal[1].equals("6")) 
			{   
				
					strColumnHeader = new String[6];
					strColumnHeader[0] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Prefix(PO_No)");
					strColumnHeader[1] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Date");
					strColumnHeader[2] = HisLanguageProperties.getValue(httpSession, "label.common.Ordered_qty");
					strColumnHeader[3] = HisLanguageProperties.getValue(httpSession, "label.common.Balance_qty"); 
					if(cmbVal[1].equals("4")) 
					{	
					    strColumnHeader[4] = HisLanguageProperties.getValue(httpSession, "label.common.Rejected_Date");
					}
					else
					{
						strColumnHeader[4] = HisLanguageProperties.getValue(httpSession, "label.common.Status");
					}
					strColumnHeader[5] = HisLanguageProperties.getValue(httpSession, "label.common.Item_Name");
					
					

			} 
			else 
			{
				   
					strColumnHeader = new String[6];
					strColumnHeader[0] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Prefix(PO_No)");
					strColumnHeader[1] = HisLanguageProperties.getValue(httpSession, "label.common.PO_Date");
					strColumnHeader[2] = HisLanguageProperties.getValue(httpSession, "label.common.Po_Value");
					strColumnHeader[3] = HisLanguageProperties.getValue(httpSession, "label.common.Penalty_Amt");
					strColumnHeader[4] = HisLanguageProperties.getValue(httpSession, "label.common.Rece_Amt");
					strColumnHeader[5] = HisLanguageProperties.getValue(httpSession, "label.common.Paid_Amt");
				
				
				
			}
		}

		return strColumnHeader;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getViewQuery()
	 */
	@Override
	public String getViewQuery() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getDeleteQuery()
	 */
	@Override
	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getDeleteData(java.lang.String)
	 */
	@Override
	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getJsFiles()
	 */
	@Override
	public String getJsFiles() {
		String files = "../../mms/js/SupplierInterfaceDesk.js";
		return files;

	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getEventState()
	 */
	@Override
	public String getEventState() {
		String str = "chkUserDefinedFunc";
		return str;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getButtonConfiguration()
	 */
	@Override
	public String getButtonConfiguration() {
		return "left";
	}

	/*
	 * 1. Disabled 0. Enable
	 */
	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getUserDefinedButtons()
	 */
	public String[] getUserDefinedButtons() {
		String[] str =
				{ 
				HisLanguageProperties.getValue(httpSession, "label.common.Acceptance")+"@buttonClick('ACCEPTANCE')@1@Acceptance",
				HisLanguageProperties.getValue(httpSession, "label.common.Delivery")+  "@buttonClick('DELIVERYDETAIL')@1@Delivery",
			//	HisLanguageProperties.getValue(httpSession, "label.common.Payment")+   "@buttonClick('PAYMENT')@1@Payment", 
				HisLanguageProperties.getValue(httpSession, "label.common.View")+      "@buttonClick('VIEW')@1@View",
				HisLanguageProperties.getValue(httpSession, "label.common.Print")+     "@getReportPage(document.forms[0],'PRINT')@1@Print" };
		return str;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getDbButtons()
	 */
	@Override
	public String[] getDbButtons() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getMinPanelButton()
	 */
	@Override
	public int getMinPanelButton() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getMenuOption()
	 */
	@Override
	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getComboEventState()
	 */
	@Override
	public String getComboEventState() {
		return "userDefinedOnLoadFunc";
	}

	/*
	 * (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getOrderBy()
	 */
	@Override
	public String[] getOrderBy() 
	{
		String orderBy[] = { "1", "HSTNUM_PO_NO", "2", "AHIS_FUNCTION.FUN_STR_DATE(C.PO_DATE)" };
		return orderBy;
	}

	/**
	 * this method optional
	 * 
	 * if this method is override and a list of column numbers passed (no. of values should be equal to no. of columns) if any one of the value is
	 * null or empty string then the template will take the default column width (100 / no. of columns)
	 * 
	 * @return the column width
	 */	
	public String[] getColumnWidth() 
	{
		String[] colWidth = null;
		if (cmbVal != null && (cmbVal[1].equals("0")||cmbVal[1].equals("1")||cmbVal[1].equals("2")||cmbVal[1].equals("4"))) 
		{
			
					colWidth = new String[6];
					colWidth[0] = "20"; // PO No        
					colWidth[1] = "10"; // PO Date      
					colWidth[2] = "10"; // Order Qty    
					colWidth[3] = "10"; // Balance Qty  
					colWidth[4] = "10"; // Status
					colWidth[5] = "40"; // Item Name
			
		}
		if (cmbVal != null && (cmbVal[1].equals("3")||cmbVal[1].equals("5"))) 
		{
			colWidth = new String[6];
			colWidth[0] = "40"; //   PO No
			colWidth[1] = "12"; //   PO Date
			colWidth[2] = "12"; //   PO Value
			colWidth[3] = "12"; //   Penalty Amount
			colWidth[4] = "12"; //   Rece Amount
			colWidth[5] = "12"; //   Paid Amount
		}
		return colWidth;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getRowStatus()
	 */
	public String[] getRowStatus() 
	{		
		/*
		 * "1"--->> Value Which we Want to Maaped 1 2 3 4 5 6 7 "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->> "Exp Within"--->>Argument You Want to Show in Footer of Template
		 */
		String[] status = null;
		if (cmbVal != null && (!cmbVal[1].equals("1"))) // 1- Acceptance Pending  
		{
			status = new String[4];
			status[0] = "0";
			status[1] = "8";
			status[2] = "YELLOW";
			status[3] = "Acceptance Pending";
		}		
		else
		{
			status = null;
		}
		return status;

	}
	/**
	 * 0^0 0 Means Combo From Query, 1 Means User Defined Combo,0 After ^ Means Select Value, 1 Means All,2 Means Default Selected.
	 * 
	 * @return the combo header
	 */
	@Override
	public String[] getComboHeader() 
	{
		// String[] strComboHeader = { "0^2", "Drug Warehouse Name",
		// "1","&nbsp; PO Status" };

		String[] strComboHeader = new String[4];

		strComboHeader[0] = "0^2";
		strComboHeader[1] = HisLanguageProperties.getValue(httpSession, "label.common.Supplier_Name");
		strComboHeader[2] = "1";
		strComboHeader[3] = HisLanguageProperties.getValue(httpSession, "label.common.Po_status");
		

		return strComboHeader;
	}
	
}
