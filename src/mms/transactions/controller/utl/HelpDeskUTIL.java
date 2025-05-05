package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

/* @author 

* Developer : Brahmam Veluguri( TO CONTINUE AND CORRECTIONS)
* Version : 1.0 Date : 02/Jul/2012
* 
*/


public class HelpDeskUTIL extends TransInterface

{
	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;
	
	public void setHttpSession(HttpSession session) 
	{
		this.httpSession = session;
	}
	

	//new
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	
	}
	public String getMasterName()
	{
		String masterName = "Help Desk";
		return masterName;
	}
	

	public List<String> getViewHeader() 
	{
			
			List <String>viewHdr = new ArrayList<String>();
			
			
			return viewHdr;
	}
		
	public String getMainQuery(String cmb[]) 
	{
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		 StringBuffer brMainQuery = new StringBuffer(500);
		
		
	       
			
			String tempQry = mms.qryHandler_mms.getQuery(2, "select.helpdesktrans.main.0");
			
		   brMainQuery.append(tempQry.replace("?",httpSession.getAttribute("HOSPITAL_CODE").toString()));
		   
					
			if (cmb != null)
			{
					
			
	/*
			
				{				
					brMainQuery = new StringBuffer("");
				    brMainQuery.append("SELECT  c.HSTNUM_PROB_ID|| '@'|| HSTNUM_STORE_ID|| '@'");
					brMainQuery.append("||c.GNUM_MENU_ID|| '@' ||c.HSTNUM_STATUS_FLAG || '@'");
					brMainQuery.append("|| c.GNUM_HOSPITAL_CODE|| '^' || c.HSTNUM_PROB_ID|| '^'");
					brMainQuery.append("|| (SELECT GSTR_MENU_NAME FROM GBLT_MENU_MST WHERE GNUM_MENU_ID=c.GNUM_MENU_ID AND GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=999)|| '^' ");
					brMainQuery.append("|| c.GDT_ENTRY_DATE|| '^'|| (SELECT HSTSTR_STATUS_NAME FROM HSTT_PROBLEM_STATUS_DTL ");
					brMainQuery.append("WHERE HSTNUM_STATUS_ID= c.HSTNUM_STATUS_FLAG AND GNUM_ISVALID=1 AND GNUM_HOSPITAL_CODE=999)|| '^'||c.HSTSTR_PROB_SUB  DATA");
					brMainQuery.append(" FROM (SELECT HSTNUM_PROB_ID,HSTNUM_STORE_ID,GNUM_MENU_ID,HSTNUM_STATUS_FLAG,HSTSTR_PROB_SUB,GDT_ENTRY_DATE,HSTSTR_SUBMITTED_BY,HSTSTR_SOLUTION,GDT_SOLUTION_DATE,GNUM_HOSPITAL_CODE ");
					brMainQuery.append(" FROM HSTT_HELPDESK_DTL WHERE gnum_isvalid = 1) c");
					brMainQuery.append(" WHERE c.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					*/
					
				
				if (!cmb[0].equals("0"))
					
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.helpdesktrans.main.cond.0").replace("?", cmb[0]));
					    //brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.2").replace("?", "1"));
		
                if (!cmb[1].equals("0"))
					
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.helpdesktrans.main.cond.3").replace("?", cmb[1]));
					
					if (!cmb[2].equals("0")) 
						//brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[1]);
					
						
					brMainQuery.append(" AND "
								+ mms.qryHandler_mms.getQuery(2,
										"select.helpdesktrans.main.cond.1").replace("?", cmb[2]));
					
					
					if (!cmb[3].equals("0")) 
						//brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[1]);
					
						
					brMainQuery.append(" AND "
								+ mms.qryHandler_mms.getQuery(2,
										"select.helpdesktrans.main.cond.2").replace("?", cmb[3]));
					
					
					
					
					
			
					/*
					if( cmb[0] != null && !cmb[0].equals("0"))
					{
						
						brMainQuery.append(" AND c.hstnum_store_id = ").append(cmb[0] );	
						
					}
					
					if( cmb[1] != null && !cmb[1].equals("0"))
					{
						
						brMainQuery.append(" AND c.GNUM_MENU_ID = ").append(cmb[1] );	
						
					}
					
					if( cmb[2] != null && !cmb[2].equals("0"))
					{
						
						brMainQuery.append(" AND c.HSTNUM_STATUS_FLAG = ").append(cmb[2] );	
						
					}
					*/
					
				}
				
			
				
				
		
			else
			{
				
				brMainQuery.append(	" and "	+ mms.qryHandler_mms.getQuery(2,"select.helpdesktrans.main.cond.2").replace("?","9"));
				
			}
		
		// in get query method(2 means query from mms_qry_trans.properties file ,1 means mms_qry_mst.properties

		
		return brMainQuery.toString();
		

	}
	
	
	public String[] getSearchField() 
	{
		//String search_field[] = {"1", "C.ITEM_BRAND_NAME","2","C.HSTSTR_BATCH_NO"};
		String search_field[]={"1","c.HSTNUM_PROB_ID","6","HSTSTR_PROB_SUB"};
		return search_field;
	}
	
	
	
	/**
	 * A^B 
	 * A = 0 Means Combo From Query,
	 * A = 1 Means User Defined Combo
	 * B = 0 After ^ Means Select Value,
	 * B = 1 Means All,
	 * B = 2 Means Default Selected
	 * */
	public String[] getComboHeader() 
	{
		String[] strComboHeader = {"0^2","Drug Warehouse","0^1","Issue Regarding","0^1","Menu Name","0^1","Problem Status"};
	    return strComboHeader;
	}
		
	public String[] getColumnHeader() 
	{
		//in column header sequence of columns should be match in main query sequence and concatination operator should be ^ symbol @ for primary key column in query..
		String[] strColumnHeader = { "Issue_No", "Menu Name" , "Issue Raised Date","Status","Department","Subject"};
		return strColumnHeader;
	}      
		
	public String[] getComboQuery() 
	{
	String[] comboQuery = new String[4];
	String strSeatId=httpSession.getAttribute("SEATID").toString();
	
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1  AND  GNUM_HOSPITAL_CODE ="+
				httpSession.getAttribute("HOSPITAL_CODE").toString()+
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
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+strSeatId+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") AND EXISTS ( SELECT 'X'  FROM HSTT_STORE_REQTYPE_MST WHERE  GNUM_ISVALID = 1" +
				"  AND  SSTNUM_ITEM_CAT_NO = 10" +
				"  AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE" +
				"  AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID" +
				//"  AND SSTNUM_INDENTTYPE_ID = 58" +
				"  )" +
				" ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		
		
		comboQuery[1] = "select HSTSTR_DEPT_CODE,HSTSTR_DEPT_NAME from HSTT_HLPDESKDEPT_MST WHERE GNUM_HOSPITAL_CODE= "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND GNUM_ISVALID=1" ;
				
		
		
		
		comboQuery[2] = " SELECT * FROM ( SELECT a.gnum_menu_id as menuId,(SELECT INITCAP (gstr_menu_name) FROM gblt_menu_mst "+     
				         " WHERE ROWNUM = 1 AND gnum_hospital_code = a.gnum_hospital_code  AND gnum_menu_id = a.gnum_menu_id AND a.gnum_isvalid = 1 ) as menuName "+
			              "FROM gblt_role_menu_mst a  WHERE a.gnum_isvalid =1 AND a.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"  " +
			              		"AND a.gnum_role_id IN (SELECT GNUM_ROLE_ID FROM GBLT_SEAT_ROLE_MST WHERE GNUM_SEATID=Pkg_Usermgmt.fun_getseatid("+strSeatId+", A.GNUM_HOSPITAL_CODE)" +
			              				" AND GBL_ISVALID=1))WHERE menuName IS NOT NULL order by menuName";
			
			   


		comboQuery[3] = "SELECT HSTNUM_STATUS_ID,HSTSTR_STATUS_NAME FROM HSTT_PROBLEM_STATUS_DTL WHERE GNUM_HOSPITAL_CODE= "+httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND GNUM_ISVALID=1" ;
				
		//System.out.println("Combo Query::::"+comboQuery[2]);
		
		
		
		return comboQuery;
		
	}
		
	public String getViewQuery()
	{
		return "";
	}
	
	public String getButtons()
	{
	    
		return "";
	}
	
	public String[] getDeleteQuery() 
	{
		
		         String    deleteQuery[]={""};
		return deleteQuery;
	}
	
	public List<String[]> getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];
		
		List<String[]> deleteData = new ArrayList<String[]>();
		
		//a[0] >> key, a[1] >> extra info
		a = (chk.replace('|','#')).split("#");
		//split key
		b = (a[0].replace('@','#')).split("#");
		
		key[0] = b[0];
	
		deleteData.add(key);
		//deleteData.add(null);
		//deleteData.add(key);
		
		return deleteData;
	}
	
	public String  getJsFiles()
	{
		String files="../../mms/js/helpdesktrans.js";
					
		return files;
		
	}

/*	
	public String[] getRowStatus() 
	{
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil();   */
		/*
		 * "1"--->> Value Which we Want to Maaped        1         2    3   4   5    6       7
		 * "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->>
		 * "Exp Within"--->>Argument You Want to Show in Footer of Template
		 * 
		 */
	/*	ResourceBundle res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
      	String[] status = {"1", "7", "#A9A9A9", "Expired","11","9",res.getString("IN_ACTIVE_COLOR"),"In-Active","12","9",res.getString("BREAKAGE_COLOR"),"Breakage","0","8",res.getString("RE_ORDER_COLOR"),"Quantity < Re-Oreder Level","15","9",res.getString("QC_COLOR"),"Quarnatine"};
		//String[] status = {"1", "7", "LightSlateGrey", "('*'Reserved/Branded Item ) Expired within " + mmscofigutil.getStrExpAlertDays() + " Day (s)","0","8",res.getString("RE_ORDER_COLOR"),"Quantity < Re-Oreder Level"};
		
		return status;
	}
	*/


	public String getEventState() {
		String str = "chkUserDefinedFunc";
		return str;
	}

	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	public String[] getUserDefinedButtons() 
	{
		//syntax: buttonname@functionname in JS File(arguments)@1 for disable and 0 for enable
		//if(res.getString("DRUG_INVENTORY").equals("1"))
		{
	       
	       String[] strButtons = {"Raise Issue@validateissueraising(document.forms[0],'ADD')@0@3b5998@glyphicon-plus",
	    		   "View@viewAcknowledge()@1@007bb6@glyphicon-fullscreen"};
	       return strButtons;
		}
		/*
		else
		{
			String[] strButtons = {"Add@validateAddInventory(document.forms[0],'ADD')@0"};
		       return strButtons;
		}
		*/
		
		
	}

	public String[] getDbButtons() {
		// TODO Auto-generated method stub
		//String[] str={"1"};
		return null;
	}

	public int getMinPanelButton() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * Frames option will not work
	 *  (non-Javadoc)
	 * @see hisglobal.transactionutil.TransInterface#getMenuOption()
	 */
	
	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	@Override
	public String getComboEventState()
	{
		return "";
	}
	
	//new features
	public String[] getOrderBy() 
	{
		String orderBy[] = {"1","c.HSTNUM_PROB_ID","3","c.GDT_ENTRY_DATE","5","c.HSTSTR_DEPT_CODE"};
		//String orderBy[] = {"1","C.ITEM_BRAND_NAME","2","C.HSTSTR_BATCH_NO"};
		//String orderBy[] = {"1","C.GNUM_HOSPITAL_CODE"};
		return orderBy;
		
	} 
}
