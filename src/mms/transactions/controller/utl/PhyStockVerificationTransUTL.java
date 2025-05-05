package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class PhyStockVerificationTransUTL extends TransInterface {
	
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
		String masterName = "Physical Stock Verification";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		
		StringBuffer brMainQuery = new StringBuffer(500);
		String strFinancialStartYear = "";
        String strFinancialEndYear = "";
	    MmsConfigUtil mcu = null;
	    mcu = new MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
	   // String[] strTemp1 = null;
	    String[] strTemp = null;
	   
		brMainQuery.append(" SELECT    hstnum_store_id  ");
		brMainQuery.append("   || '@' || hstnum_phystock_no||'@'||TO_CHAR(hstdt_veri_date,'DD-Mon-YYYY')||'@'||MMS_MST.get_period_name(GNUM_HOSPITAL_CODE,SSTNUM_PERIOD_ID::character varying) ");
		brMainQuery.append("   || '@' || gnum_hospital_code ");
		brMainQuery.append("   || '^' || hstnum_phystock_no ");
		brMainQuery.append("   || '^' ||TO_CHAR(hstdt_veri_date,'DD-Mon-YYYY') ");
		brMainQuery.append("   || '^' || MMS_MST.get_period_name(GNUM_HOSPITAL_CODE,SSTNUM_PERIOD_ID::character varying) ");
		brMainQuery.append("   || '^' || MMS_MST.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) ");
		brMainQuery.append(" as DATA ");
		brMainQuery.append(" FROM SSTT_PHYSTOCK_DTL WHERE  GNUM_ISVALID = 1 ");
		brMainQuery.append(" AND 1=2");
		
		
		
		if (cmb != null) { 
					brMainQuery=null;
					brMainQuery= new StringBuffer(500);
					brMainQuery.append(" SELECT    hstnum_store_id  ");
					brMainQuery.append("   || '@' || hstnum_phystock_no||'@'||TO_CHAR(hstdt_veri_date,'DD-Mon-YYYY')||'@'||MMS_MST.get_period_name(GNUM_HOSPITAL_CODE,SSTNUM_PERIOD_ID::character varying) ");
					brMainQuery.append("   || '@' || gnum_hospital_code ");
					brMainQuery.append("   || '^' || hstnum_phystock_no ");
					brMainQuery.append("   || '^' ||TO_CHAR(hstdt_veri_date,'DD-Mon-YYYY') ");
					brMainQuery.append("   || '^' || MMS_MST.get_period_name(GNUM_HOSPITAL_CODE,SSTNUM_PERIOD_ID::character varying) ");
					brMainQuery.append("   || '^' || MMS_MST.get_itemcat_dtl(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) ");
					brMainQuery.append(" as DATA ");
					brMainQuery.append(" FROM SSTT_PHYSTOCK_DTL WHERE  GNUM_ISVALID = 1 ");
					brMainQuery.append(" AND GNUM_HOSPITAL_CODE = " +httpSession.getAttribute("HOSPITAL_CODE").toString());
				
					strTemp=cmb[0].replace('^', '#').split("#");
					strFinancialStartYear = mcu.getStrFinancialStartDate(strTemp[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
					
			        strFinancialEndYear = mcu.getStrFinancialEndDate(strTemp[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
		        
			//Active
			if (cmb[2].equals("0"))
			{
			    
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 0 ");
				brMainQuery.append(" AND TRUNC(HSTDT_REVIEW_DATE) IS NULL");
			}
			//Revieve
			else if (cmb[2].equals("1"))
			{
			    brMainQuery.append(" AND HSTDT_REVIEW_DATE IS NOT NULL");
			}
			//Partial Approved
			else if (cmb[2].equals("2"))
			{
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 49");               
			} 
			//Approved
			else if (cmb[2].equals("3"))
			{
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 40");
			}
			//Rejected
			else if(cmb[2].equals("4"))
			{
	
				strTemp  =  cmb[0].split("\\^"); 
				
					
				
				brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = TO_DATE('"+strFinancialStartYear+"','dd-Mon-YYYY')");
				
				brMainQuery.append(" AND HSTDT_FINANCIAL_END_DATE = TO_DATE('"+strFinancialEndYear+"','dd-Mon-YYYY')");
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 99");
			}
			//Processed
			
			else if(cmb[2].equals("5"))
			{
				//System.out.println("PreQuery"+brMainQuery);
				brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = TO_DATE('"+strFinancialStartYear+"','dd-Mon-YYYY')");
				
				brMainQuery.append(" AND HSTDT_FINANCIAL_END_DATE = TO_DATE('"+strFinancialEndYear+"','dd-Mon-YYYY')");
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 50");
			//	System.out.println("PreQuery"+brMainQuery);
			}
			/*else if (cmb[2].equals("5"))
			{
				
				strFinancialStartYear = mcu.getStrFinancialStartDate(strTemp[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
		        strFinancialEndYear = mcu.getStrFinancialEndDate(strTemp[0] , httpSession.getAttribute("HOSPITAL_CODE").toString());
			
				
	            brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = TO_DATE('"+strFinancialStartYear+"','dd-Mon-YYYY')");
				
				brMainQuery.append(" AND HSTDT_FINANCIAL_END_DATE = TO_DATE('"+strFinancialEndYear+"','dd-Mon-YYYY')");
				brMainQuery.append(" AND HSTNUM_PHYVERI_STATUS = 50");
			}*/
			//category
			if (!cmb[1].equals("0")) 
			{
				brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = ");
				brMainQuery.append(cmb[1]);
			}
	        
			//store id
			if (!cmb[0].equals("0")) 
			{
				strTemp  =  cmb[0].split("\\^"); 
				brMainQuery.append(" AND HSTNUM_STORE_ID = ");
				brMainQuery.append(strTemp[0]);
			}
			
		
		}
		return brMainQuery.toString();
	}

	public String[] getSearchField() 
	{
		String search_field[] = {"2", "hstnum_phystock_no"};
		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		//String[] strComboHeader = {"0^2","Drug Warehouse Name","0^2","Item Category","1","Status"};
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Drug WareHouse Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}

		
		
	    return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Verification No", "Verfication Date", "Period", "Category"};
		return strColumnHeader;
	}      

	public String[] getComboQuery()
	{
	  //String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
	    String[] comboQuery = new String[3];
	    String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
	   	   
		comboQuery[0] = "select HSTNUM_STORE_ID|| '^' ||HSTNUM_STORETYPE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE ="+
				        httpSession.getAttribute("HOSPITAL_CODE").toString()+
				       /* " AND EXISTS"+
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
						 ",A.GNUM_HOSPITAL_CODE))"+*/
						" ORDER BY INITCAP(HSTSTR_STORE_NAME)";

		//Added by priyesh
		comboQuery[1] = mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.0");
        comboQuery[1] = comboQuery[1].concat(mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.cond.0")).replace("?",hosCode);
	
        //Old
	/*	comboQuery[1] = "SELECT SSTNUM_ITEM_CAT_NO , "
				+ "Mms_Mst.get_itemcat_dtl(1 , GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO ) AS ITEM_CAT "
				+ "FROM HSTT_STORE_CATEGORY_MST A WHERE GNUM_ISVALID = 1 AND "
				+ "TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) "
				+ "AND GNUM_HOSPITAL_CODE = "
				+ httpSession.getAttribute("HOSPITAL_CODE").toString() 
				+ " AND HSTNUM_STORE_ID = SUBSTR ( NVL(decode('#1#','null','00000000'),'#1#') , 1, 7) "
				/*+ "AND EXISTS (SELECT 'X' FROM HSTT_STORE_REQTYPE_MST WHERE GNUM_ISVALID = 1 "
				+ "AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND "
				+ "NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE"
				+ " AND SSTNUM_INDENTTYPE_ID = 69 AND "
				+ "SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ) "*/
			//	+ "ORDER BY ITEM_CAT";
		
		//System.out.println(comboQuery[1]);
		
		
		comboQuery[2] = "0^Active#1^Revieved#2^Partial Approved#3^Approved#4^Rejected#5^Processed";
		
		return comboQuery;
	}

	public String getViewQuery() {
		return "";
	}

	public String[] getDeleteQuery() 
	{
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk)
	{
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/phyStockVerification_trans.js";
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
		//String[] strButtons = {"Inventory Count@callPage1(document.forms[0],'INVENTORY')@0","Issue@@1","View@@1"};	
		
		String[] strButtons = null; 
	     strButtons = new String[5];
	     
		 strButtons[0] = "Verify@buttonLogicsOnClickVerify(1,'VERIFY','Add')@0@00aced@glyphicon-check";
		 strButtons[1] = "Review@buttonLogicsOnClickReview()@1@9B25AF@glyphicon-zoom-in";
	  	 strButtons[2] = "Stock Update@updateStock()@1@FFBA77@glyphicon-oil";
	  	 strButtons[3] = "Cancel@validateCancel()@1@bb0000@glyphicon-remove";	
	  	 strButtons[4] = "View@buttonLogicsOnClickView()@1@007bb6@glyphicon-fullscreen";
		
       // return strButtons;
		
		
		return strButtons;
	}

	public String[] getDbButtons() {
		//String[] str = { "1" };
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
		String orderBy[] = { "1", "hstnum_phystock_no" };
		return orderBy;
	}

	@Override
	public String getButtons() {
		// TODO Auto-generated method stub
		return "";
	}
	
	

}
