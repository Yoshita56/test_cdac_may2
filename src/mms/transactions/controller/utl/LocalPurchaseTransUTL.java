package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class LocalPurchaseTransUTL extends TransInterface
{
	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;
	
	public void setHttpSession(HttpSession session) 
	{
		this.httpSession = session;
	}
	/*public void setCombo(String[] arg0) {
		// TODO Auto-generated method stub
		
	}*/

	//new
	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	
	}
	public String getMasterName()
	{
		String masterName = "Local Purchase";
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
		
			String tempQry = mms.qryHandler_mms.getQuery(2, "select.main.0").replace("#", mmscofigutil.getStrExpAlertDays());
			
			brMainQuery.append(tempQry.replace("?",httpSession.getAttribute("HOSPITAL_CODE").toString()));
					
			if (cmb != null)
			{
					
				if (!cmb[0].equals("0"))
					
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.1").replace("?", cmb[0]));
				    //brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.2").replace("?", "1"));
	
			
				if (cmb[0].equals("0"))
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.1").replace("?", "0"));
				
				
				if (!cmb[1].equals("0")) 
					//brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[1]);
				
					
				brMainQuery.append(" AND "
							+ mms.qryHandler_mms.getQuery(2,
									"select.main.cond.2").replace("?", cmb[1]));
	
				if (cmb[2].equals("16")) 
				{				
					brMainQuery = new StringBuffer("");
					brMainQuery.append(" SELECT    c.hstnum_store_id|| '@'|| c.hstnum_item_id|| '@'|| c.hstnum_itembrand_id|| '@'|| c.hststr_batch_no");
					brMainQuery.append(" || '@'|| c.gnum_hospital_code|| '@'|| hstnum_stock_status_code|| '^'|| c.item_brand_name|| '^'|| c.hststr_batch_no");
					brMainQuery.append(" || '^'|| c.item_inhand_dtl|| '^'|| c.item_reorder_level|| '^'|| c.expiry_date");
					brMainQuery.append("|| '^'|| 1 ");
					brMainQuery.append("|| '^'|| mms_mst.get_reorder_flag (c.gnum_hospital_code,c.hstnum_itembrand_id,c.hstnum_item_id,c.hstnum_store_id,c.hstnum_inhand_qty,c.hststr_batch_no,1)");
					brMainQuery.append("|| '^'|| c.hstnum_stock_status_code DATA FROM (SELECT hstnum_store_id, hstnum_item_id, hstnum_itembrand_id,hststr_batch_no, gnum_hospital_code, hstnum_group_id,");
					brMainQuery.append("mms_mst.get_item_dtl (1,gnum_hospital_code,hstnum_itembrand_id)item_brand_name,sstnum_item_cat_no, hstnum_stock_status_code,hstnum_inhand_qty|| ' '|| mms_mst.getunitname (gnum_hospital_code," +
							"hstnum_inhand_qty_unitid) item_inhand_dtl,");
					brMainQuery.append("gnum_isvalid,mms_mst.get_reorder(gnum_hospital_code,hstnum_itembrand_id,hstnum_item_id,hstnum_store_id,1)");
					brMainQuery.append("|| ' '|| mms_mst.getunitname (gnum_hospital_code,hstnum_inhand_qty_unitid)item_reorder_level,");
					brMainQuery.append("TO_CHAR (hstdt_expiry_date, 'DD-Mon-yyyy') AS expiry_date,hstnum_inhand_qty FROM hstt_drug_currstock_dtl");
					brMainQuery.append(" WHERE gnum_isvalid = 1 AND hstnum_inhand_qty > 0 AND hstdt_expiry_date < TRUNC(SYSDATE) ) c");
					brMainQuery.append(" WHERE c.gnum_hospital_code = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
					
					if( cmb[0] != null && !cmb[0].equals("0"))
					{
						
						brMainQuery.append(" AND c.hstnum_store_id = ").append(cmb[0] );	
						
					}
					
				}
				else
				{
					if(!cmb[2].equals("0"))
					{
						if(cmb[2].equals("10"))
						{
						    brMainQuery.append(" and "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.0").replace("?",cmb[2]));
						    brMainQuery.append(" and  c.expiry_date > TRUNC(SYSDATE)");
						}
						else
						{
							brMainQuery.append(" and "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.0").replace("?",cmb[2]));	
						}	
					}
					else
					{
				  	  brMainQuery.append(	" and "	+ mms.qryHandler_mms.getQuery(2,"select.main.cond.0").replace("?","10,11,12,15"));
					}  
				}	
				
				
			} 
			else
			{
				
				brMainQuery.append(	" and "	+ mms.qryHandler_mms.getQuery(2,"select.main.cond.0").replace("?","9"));
				
			}
		
		return brMainQuery.toString();
		

	}
	
	public String[] getSearchField() 
	{
		String search_field[] = {"1", "C.ITEM_BRAND_NAME","2","C.HSTSTR_BATCH_NO"};
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
		String[] strComboHeader = {"0^2","Drug Warehouse", "0^1","Group Name","0^1","Stock Status"};
	    return strComboHeader;
	}
		
	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Drug Name", "Batch No" , "Qty InHand","Re-Order Level","Exp Date"};
		return strColumnHeader;
	}      
		
	public String[] getComboQuery() 
	{
	String[] comboQuery = new String[3];
	String strSeatId=httpSession.getAttribute("SEATID").toString();
	
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME from HSTT_STORE_MST A where  GNUM_ISVALID = 1  AND  GNUM_HOSPITAL_CODE ="+
				httpSession.getAttribute("HOSPITAL_CODE").toString()+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				    //" AND P.gnum_hospital_code = q.gnum_hospital_code"+
				    " AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
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
				
		comboQuery[1] = "SELECT HSTNUM_GROUP_ID,HSTSTR_GROUP_NAME " +
				"FROM HSTT_GROUP_MST WHERE GNUM_HOSPITAL_CODE = " +httpSession.getAttribute("HOSPITAL_CODE").toString() +
				" AND GNUM_ISVALID = 1 AND SSTNUM_ITEM_CAT_NO = 10"+" ORDER BY HSTSTR_GROUP_NAME";

		comboQuery[2] = "SELECT HSTNUM_STOCK_STATUS_CODE, HSTSTR_STOCK_STATUS_DESC FROM SSTT_STOCK_STATUS_MST" +
		" WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString() +" AND SSTNUM_ITEM_CAT_NO = 10 "
		+" ORDER BY HSTNUM_STOCK_STATUS_CODE";
		
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
		String files="../../mms/js/mms_trans.js";
					
		return files;
		
	}

	public String[] getRowStatus() 
	{
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		/*
		 * "1"--->> Value Which we Want to Maaped        1         2    3   4   5    6       7
		 * "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^1
		 * "blue"--->>
		 * "Exp Within"--->>Argument You Want to Show in Footer of Template
		 * 
		 */
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

      	String[] status = {"1", "7", "#A9A9A9", "Expired","11","9",res.getString("IN_ACTIVE_COLOR"),"In-Active","12","9",res.getString("BREAKAGE_COLOR"),"Breakage","0","8",res.getString("RE_ORDER_COLOR"),"Quantity < Re-Oreder Level","15","9",res.getString("QC_COLOR"),"Quarnatine"};
		//String[] status = {"1", "7", "LightSlateGrey", "('*'Reserved/Branded Item ) Expired within " + mmscofigutil.getStrExpAlertDays() + " Day (s)","0","8",res.getString("RE_ORDER_COLOR"),"Quantity < Re-Oreder Level"};
		
		return status;
	}


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
		
		  
	       String[] strButtons = {"Add@validateAddInventory(document.forms[0],'ADD')@0@3b5998@glyphicon-plus",
	    		   "Modify@validateAddInventory(document.forms[0],'MODIFY')@1@ff5057@glyphicon-edit"};
	       return strButtons;
			
		
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
		String orderBy[] = {"1", "C.ITEM_BRAND_NAME", "2","C.HSTSTR_BATCH_NO"};
		//String orderBy[] = {};
		return orderBy;
	} 
	
	
		
}
