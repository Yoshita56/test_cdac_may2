package mms.transactions.controller.utl;
import hisglobal.hisconfig.Config;
import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class DrugInventoryTransUTL extends TransInterface
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
		String masterName = "Drug Inventory";
		return masterName;
	}
	

	public List<String> getViewHeader() 
	{
			
			List <String>viewHdr = new ArrayList<String>();
			
			
			return viewHdr;
	}
		
	public String getMainQuery_OLD(String cmb[]) 
	{
		
		    MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		    StringBuffer brMainQuery = new StringBuffer(5000);
		
		   
		 
	        String tempQry = mms.qryHandler_mms.getQuery(2, "select.main.0").replace("#", mmscofigutil.getStrExpAlertDays());
			
			brMainQuery.append(tempQry.replace("?",httpSession.getAttribute("HOSPITAL_CODE").toString()));
			if (cmb != null)
			{
				
				
				 
				if (!cmb[0].equals("0"))
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.1").replace("?", cmb[0]));
				else
					brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.1").replace("?", "0"));
				
				 System.out.println("Query_A-->>>"+brMainQuery.toString());
			}
			else
			brMainQuery.append(" and "+mms.qryHandler_mms.getQuery(2, "select.main.cond.1").replace("?", "0"));
					
			if (cmb != null)
			{
				
				
					
				if (!cmb[1].equals("0")) 
					
	
				if (cmb[2].equals("16")) 
				{				
					brMainQuery = new StringBuffer("");
					brMainQuery.append(" SELECT    c.hstnum_store_id|| '@'|| c.hstnum_item_id|| '@'|| c.hstnum_itembrand_id|| '@'|| c.hststr_batch_no");
					brMainQuery.append(" || '@'|| c.gnum_hospital_code|| '@'|| hstnum_stock_status_code|| '^'|| c.item_brand_name|| '^'||  c.expiry_date");
					brMainQuery.append(" || '^'|| c.item_inhand_dtl|| '^'|| c.hststr_batch_no || '^'|| sl");
					brMainQuery.append("|| '^'|| 1 ");
					brMainQuery.append("|| '^'|| mms_mst.get_reorder_flag (c.gnum_hospital_code,c.hstnum_itembrand_id,c.hstnum_item_id,c.hstnum_store_id,c.hstnum_inhand_qty,c.hststr_batch_no,1)");
					brMainQuery.append("|| '^'|| c.hstnum_stock_status_code as DATA FROM (SELECT hstnum_store_id, hstnum_item_id, hstnum_itembrand_id,hststr_batch_no, gnum_hospital_code, hstnum_group_id,");
					brMainQuery.append("mms_mst.get_item_dtl (1,gnum_hospital_code,hstnum_itembrand_id)item_brand_name,sstnum_item_cat_no, hstnum_stock_status_code,hstnum_inhand_qty|| ' '|| mms_mst.getunitname (gnum_hospital_code," +
							"hstnum_inhand_qty_unitid) item_inhand_dtl,hstnum_saleprice sl,");
					brMainQuery.append("gnum_isvalid,round(mms_mst.get_reorder(gnum_hospital_code,hstnum_itembrand_id,hstnum_item_id,hstnum_store_id,1))");
					brMainQuery.append("");
					brMainQuery.append("TO_CHAR (hstdt_expiry_date, 'DD-Mon-yyyy') AS expiry_date,hstnum_inhand_qty,hstdt_expiry_date FROM hstt_drug_currstock_dtl");
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
						    brMainQuery.append(" and  c.hstdt_expiry_date > TRUNC(SYSDATE)");
						}
						else
						{
							brMainQuery.append(" and "+ mms.qryHandler_mms.getQuery(2,"select.main.cond.0").replace("?",cmb[2]));	
						}	
					}
					
				}	
				
			
			} 
			
			System.out.println("DrugInventoryTransUTL-->>>"+brMainQuery.toString());
			
			//brMainQuery.append(" ORDER BY C.EXPIRY_DATE ASC ");
			

		
	
		mmscofigutil= null;
		
		System.out.println("Drug Inventory Query==>"+brMainQuery.toString());
		return brMainQuery.toString();
		

	}
	public String getMainQuery(String cmb[]) 
	{
		
		
		StringBuffer brMainQuery = new StringBuffer(5000);
		
		if (cmb != null)
		{			
			

			System.out.println("Store Name-A-->>>"+cmb[0]);
			System.out.println("Group Name--->>>"+cmb[1]);
			System.out.println("Stock Status->>>"+cmb[2]);
			
			brMainQuery.append(" SELECT A.HSTNUM_STORE_ID || '@' || A.HSTNUM_ITEM_ID || '@' || A.HSTNUM_ITEMBRAND_ID || '@' || A.HSTSTR_BATCH_NO || '@' || A.GNUM_HOSPITAL_CODE || '@' || HSTNUM_STOCK_STATUS_CODE   || '^' || MMS_MST.get_item_dtl(1 , 100 , A.HSTNUM_ITEMBRAND_ID ) ||' ( '||(select DECODE(D.hstnum_edl_category,1,'EDL','Non-EDL')"); 
			brMainQuery.append(" from hstt_drugbrand_mst D  where D.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND D.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND D.GNUM_ISVALID  = 1 LIMIT 1) || ')^' ||  TO_CHAR(HSTDT_EXPIRY_DATE , 'DD-Mon-yyyy') || '^' || round(HSTNUM_INHAND_QTY) ||' '|| MMS_MST.getUnitName(100 , HSTNUM_INHAND_QTY_UNITID) || '^'|| A.HSTSTR_BATCH_NO || '^'|| hstnum_saleprice || '^' || DECODE(SIGN(DATE_PART('DAYS',(NVL(TO_DATE(TO_CHAR(HSTDT_EXPIRY_DATE , 'DD-Mon-yyyy')),TRUNC(SYSDATE)+90)::date - 90) - TRUNC(SYSDATE))),-1,1,0) ||'^' ||mms_mst.get_reorder_flag( A.gnum_hospital_code,A.hstnum_itembrand_id,A.hstnum_item_id,A.hstnum_store_id,A.hstnum_inhand_qty,A.HSTSTR_BATCH_NO,1)||'^'||A.HSTNUM_STOCK_STATUS_CODE||'^'||(select DECODE(D.hstnum_edl_category,1,'EDL','Non-EDL')");
			brMainQuery.append(" from hstt_drugbrand_mst D  where D.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND D.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND D.GNUM_ISVALID  = 1 LIMIT 1)");
			brMainQuery.append(" FROM HSTT_DRUG_CURRSTOCK_DTL A"); 
			brMainQuery.append(" WHERE GNUM_ISVALID = 1"); 
			brMainQuery.append(" and  TRUNC(A.hstdt_expiry_date) > TRUNC(SYSDATE)");
			brMainQuery.append(" AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
			
			if( cmb[0] != null && !cmb[0].equals("0"))
			{
				
				brMainQuery.append(" AND A.hstnum_store_id = ").append(cmb[0] );	
				
				
			}
			if( cmb[1] != null && !cmb[1].equals("0"))
			{				
				brMainQuery.append(" AND A.hstnum_group_id = ").append(cmb[1] );	
			}
			if( cmb[2] != null && !cmb[2].equals("0"))
			{
				
			    brMainQuery.append(" and  A.HSTNUM_STOCK_STATUS_CODE = "+cmb[2]+"");
				   
				
			}
			
			System.out.println("Query_A-->>>"+brMainQuery.toString());
		}
		else
		{

			
			
			brMainQuery.append(" SELECT A.HSTNUM_STORE_ID || '@' || A.HSTNUM_ITEM_ID || '@' || A.HSTNUM_ITEMBRAND_ID || '@' || A.HSTSTR_BATCH_NO || '@' || A.GNUM_HOSPITAL_CODE || '@' || HSTNUM_STOCK_STATUS_CODE   || '^' || MMS_MST.get_item_dtl(1 , 100 , A.HSTNUM_ITEMBRAND_ID ) ||' ( '||(select DECODE(D.hstnum_edl_category,1,'EDL','Non-EDL')"); 
			brMainQuery.append(" from hstt_drugbrand_mst D  where D.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND D.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND D.GNUM_ISVALID  = 1 LIMIT 1) || ')^' ||  TO_CHAR(HSTDT_EXPIRY_DATE , 'DD-Mon-yyyy') || '^' || round(HSTNUM_INHAND_QTY) ||' '|| MMS_MST.getUnitName(100 , HSTNUM_INHAND_QTY_UNITID) || '^'|| A.HSTSTR_BATCH_NO || '^'|| hstnum_saleprice || '^' || DECODE(SIGN(DATE_PART('DAYS',(NVL(TO_DATE(TO_CHAR(HSTDT_EXPIRY_DATE , 'DD-Mon-yyyy')),TRUNC(SYSDATE)+90)::date - 90) - TRUNC(SYSDATE))),-1,1,0) ||'^' ||mms_mst.get_reorder_flag( A.gnum_hospital_code,A.hstnum_itembrand_id,A.hstnum_item_id,A.hstnum_store_id,A.hstnum_inhand_qty,A.HSTSTR_BATCH_NO,1)||'^'||A.HSTNUM_STOCK_STATUS_CODE||'^'||(select DECODE(D.hstnum_edl_category,1,'EDL','Non-EDL')");
			brMainQuery.append(" from hstt_drugbrand_mst D  where D.HSTNUM_ITEMBRAND_ID = A.HSTNUM_ITEMBRAND_ID  AND D.HSTNUM_ITEM_ID = A.HSTNUM_ITEM_ID AND D.GNUM_ISVALID  = 1 LIMIT 1)");
			brMainQuery.append(" FROM HSTT_DRUG_CURRSTOCK_DTL A"); 
			brMainQuery.append(" WHERE GNUM_ISVALID = 1"); 			
			
			brMainQuery.append(" and  A.HSTNUM_STOCK_STATUS_CODE != 15 ");
			brMainQuery.append(" and  TRUNC(A.hstdt_expiry_date) > TRUNC(SYSDATE)");
			brMainQuery.append(" AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+"");
			brMainQuery.append(" AND A.HSTNUM_STORE_ID IN ");
			brMainQuery.append(" ( SELECT HSTNUM_STORE_ID ");
			brMainQuery.append("  FROM HSTT_STORE_MST A  ");
			brMainQuery.append(" WHERE GNUM_ISVALID = 1 ");
			brMainQuery.append(" AND GNUM_HOSPITAL_CODE = "+httpSession.getAttribute("HOSPITAL_CODE").toString()+""); 			  
			brMainQuery.append(" AND HSTNUM_STORE_ID IN ( SELECT GNUM_COLUMN_VALUE FROM GBLT_ROLE_SEAT_TABLE_DTL P ");     
			brMainQuery.append(" WHERE P.gnum_metatable_id = 117 "); 	    
			brMainQuery.append(" AND P.gnum_hospital_code = A.gnum_hospital_code ");     
			brMainQuery.append(" AND P.gnum_seatid =(select Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+", "+httpSession.getAttribute("HOSPITAL_CODE").toString()+") from dual ) "); 
			brMainQuery.append(" ) ) ");
			
			
			System.out.println("Query_B-->>>"+brMainQuery.toString());
				
			
		}
		
		
		System.out.println("Drug Inventory Query=[ DrugInventoryTransUTL ]=>"+brMainQuery.toString());
		return brMainQuery.toString();
		

	}
	
	//new features
	public String[] getOrderBy() 
	{
		String orderBy[] = {"1", "A.hstdt_expiry_date"};		
		return orderBy;
	} 
	
	public String[] getSearchField() 
	{
		String search_field[] = {"1", "MMS_MST.get_item_dtl(1 , 100 , A.HSTNUM_ITEMBRAND_ID )"};
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
		String[] strComboHeader = {"0^2","Store Name", "0^1","Group Name","0^2","Stock Status"};
	    return strComboHeader;
	}
		
	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Drug Name", "Exp Date" , "Qty InHand", "Batch No"};
		return strColumnHeader;
	}      
		
	public String[] getComboQuery() 
	{
	String[] comboQuery = new String[3];
	//String strSeatId=httpSession.getAttribute("SEATID").toString();
	
		
		comboQuery[0] = "SELECT HSTNUM_STORE_ID, HSTSTR_STORE_NAME  "+
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
				
		comboQuery[1] = "SELECT HSTNUM_GROUP_ID,HSTSTR_GROUP_NAME " +
				"FROM HSTT_GROUP_MST WHERE GNUM_HOSPITAL_CODE = " +Config.SUPER_USER_HOSPITAL_CODE +
				" AND GNUM_ISVALID = 1 AND SSTNUM_ITEM_CAT_NO = 10"+" ORDER BY HSTSTR_GROUP_NAME";

		comboQuery[2] = "SELECT HSTNUM_STOCK_STATUS_CODE, HSTSTR_STOCK_STATUS_DESC FROM SSTT_STOCK_STATUS_MST" +
		" WHERE GNUM_ISVALID = 1 AND HSTNUM_STOCK_STATUS_CODE IN( 10,15) AND GNUM_HOSPITAL_CODE = "+Config.SUPER_USER_HOSPITAL_CODE +" AND SSTNUM_ITEM_CAT_NO = 10 "
		+" ORDER BY HSTNUM_STOCK_STATUS_CODE";
		
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
	
	public List<String[]> getDeleteData(String chk)
	{
		
		return null;
	}
	
	public String  getJsFiles()
	{
		String files="../../mms/js/mms_trans.js";
					
		return files;
		
	}

	public String[] getRowStatus() 
	{
		/* <----------------- 1 --------------------><----------------2 -----------> <--3--> <--4---> <----5------><-- 6 --><-7-> <--8--> <--9--><-10->                      
		 * 10201101@10001375@10102749@MCZ566@10911@10^FUNGAL DIASTASE + PEPSIN 200ML^MCZ566 ^ 105 No.^31-Dec-2019^42.700000^ 1  ^ 33.00 ^   10  ^ EDL"
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

      	//String[] status = {"1", "7", "#7D786C", "Expired"};
		//String[] status = {"EDL", "10", "#90EE90", "EDL Drug(s)","1", "7", "#C0C0C0", "Drug(s) Expired"};
		String[] status = {"EDL", "10", "#90EE90", "EDL Drug(s)","1", "7", "PINK", "Expired in 90 Days"};
		
      	res = null;
      	
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
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		String retVal = res.getString("DRUG_INVENTORY");
		res = null;
		//System.out.println("DRUG_INVENTORY===>>>>>>"+retVal);
		if(retVal.equals("1"))
		{
	       
			//Add@validateAddInventory(document.forms[0],'ADD')@0--Buton Name@CallingJSFunction@OnloadButtonEnable-0/ButtonDisable-1
			String[] strButtons = {//"Add@validateAddInventory(document.forms[0],'ADD')@0",   
					             	//"Modify@validateAddInventory(document.forms[0],'MODIFY')@1",
					             	"Add@getnewaddmode()@0@3b5998@glyphicon-plus"
					//,"Modify@getnewmodifymode()@1"
					             	};
	       return strButtons;
		}
		else
		{
			String[] strButtons = {"Add@validateAddInventory(document.forms[0],'ADD')@0@3b5998@glyphicon-plus"};
		       return strButtons;
		}
		
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
	
	
	
	@Override
	public String[] getButtonIcons() {
		String[] str={//"AddOnDesk.png","UpdateOnDesk.png",
						"AddOnDesk.png","UpdateOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
		
}
