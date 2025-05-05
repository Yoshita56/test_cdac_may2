package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreMstUTL.
 */
public class StoreMstUTL implements MasterInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#setHttpSession(javax.servlet.http
	 * .HttpSession)
	 */
	public void setHttpSession(HttpSession session) {

		httpSession = session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	/*
	 * Maste Name#Data Index^Compare Value^Title^Color
	 * "33101@10101125^Dept Store 1AAA^Inventory^General Medicine^----^PURCAHSE"
	 * 1(WHOLE PK)^2^3^4^5^6(PURCAHSE)
	 */
	public String getMasterName() 
	{
		String masterName = null;		
		masterName = "Store Master#6^PURCHASE^Purchase Section^E7D7E2";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[0] = "Store Name";
			columnHdr[1] = "Location";
			columnHdr[2] = "Department";
			columnHdr[3] = "Ward";
		}
		else
		{
			columnHdr[0] = "Store Name";
			columnHdr[1] = "Location";
			columnHdr[2] = "Department";
			columnHdr[3] = "Ward";
		}		
		return columnHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "HSTSTR_STORE_NAME"};
		return search_field;

		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getPage_per_block()
	 */
	public int getPage_per_block() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {

		/*
		 * Inactivated by Aritra. 20 Dec 2010 Reason: Change Request=> Store
		 * Type Field Not Required.(From Ajay Gupta, 16/12/2010) String[]
		 * comboHdr = { "0", "Store Type Name ", "1", " Record Status" };
		 */

		/*
		 * Added by Aritra. 20 Dec 2010 Reason: Change Request=> Store Type
		 * Field Not Required.(From Ajay Gupta, 16/12/2010)
		 */
		//String[] comboHdr = { "1", " Record Status" };
		String[] comboHdr = { "0", "Store Type Name ", "1", " Record Status" };
		return comboHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		 String[] comboQuery = new String[2];
		//String[] comboQuery = new String[1];
		 String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();   //  commented by Shefali on 04/12/2014
		// String hosCode=Config.SUPER_USER_HOSPITAL_CODE;							//commented  by Shefali on 04/12/2014
		/*
		 * Changed by Aritra. 20 Dec 2010 Reason: Change Request=> Store Type
		 * Field Not Required.(From Ajay Gupta, 16/12/2010)
		 */

		 
		  comboQuery[0] = mms.qryHandler_mms.getQuery(1, "select.DrugWarehouseType.cmb.storetype"); //changed by shalini on 07/01/2015
		 // comboQuery[0] = comboQuery[0].replace("?", hosCode); 
		  comboQuery[1] = "1^Active#2^In Active";
		 

		//comboQuery[0] = "1^Active#2^In Active";

		// httpSession.setAttribute("isvalidcmb","1");

		return comboQuery;

		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {

		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		StringBuffer brMainQuery = new StringBuffer();

		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.Store.0").replace("?",hosCode)).append(
				" AND "	+ mms.qryHandler_mms.getQuery(1, "select.Store.cond.1").replace("?", "1"));

		/*
		 * Changed by Aritra. 20 Dec 2010 Reason: Change Request=> Store Type
		 * Field Not Required.(From Ajay Gupta, 16/12/2010)
		 */
		
		  if (cmb != null) 
		  {
		  
			  if (!cmb[1].equals("0"))
			  {
				  brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[1]); 
				  httpSession.setAttribute("isvalidcmb", cmb[1]); 
			  } 
		  }
		   
		  
		  
		  if (cmb != null)
		  {
		  
			  if (!cmb[0].equals("0")) 
			  {
				  brMainQuery.append(" AND " + mms.qryHandler_mms.getQuery(1, "select.Store.cond.2") .replace("?", "0"));
				  brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery.lastIndexOf("0") + 1, cmb[0]);
				  httpSession.setAttribute("strStoreTypeId", cmb[0]); 
			  }
		  
		  }
		 

//		if (cmb != null) {
//
//			if (!cmb[0].equals("0")) {
//				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
//						brMainQuery.lastIndexOf("1") + 1, cmb[0]);
//				// httpSession.setAttribute("isvalidcmb", cmb[1]);
//			}
//		}
         //System.out.println("Main Qry::::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "select.Store.1");
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		
		
		viewHdr.add("Section Mode");
		viewHdr.add("D");
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			viewHdr.add("Drug Warehouse Name");
			viewHdr.add("D");
			
		}
		else
		{
			viewHdr.add("Store Name");
			viewHdr.add("D");
			
		}
		
	
		viewHdr.add("Store Is Time Bound");
		viewHdr.add("D");
		viewHdr.add("From Time");
		viewHdr.add("D");
		viewHdr.add("To Time");
		viewHdr.add("D");

		
		viewHdr.add("Effective From ");
		viewHdr.add("D");
		viewHdr.add("Remarks ");
		viewHdr.add("D");
		viewHdr.add("Record Status ");
		viewHdr.add("D");

		return viewHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = {  "1","HSTSTR_STORE_CODE", "2", "HSTSTR_STORE_NAME", "3", "mms_mst.get_district_name(GNUM_HOSPITAL_CODE,NUM_DIST_ID)"};
		return orderBy;
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();

		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.Store.0").replace(
				"?", seatId);
		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.Store.cond.0"));

		return delQuery;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();

		/*br.append("<img src='../../hisglobal/images/btn-add.png' 	style='cursor: pointer;' tabindex='0' title='Add'		onKeyPress='if(event.keyCode==13) add(\"ADD\");' 				onClick='add(\"ADD\");'>");
		br.append("<img src='../../hisglobal/images/btn-mo.png'		style='cursor: pointer;' tabindex='0' title='Modify' 	onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' 			onClick='edit(\"MODIFY\");' />");
		br.append("<img src='../../hisglobal/images/btn-del.png' 	style='cursor: pointer;' tabindex='0' title='Delete' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png' 	style='cursor: pointer;' tabindex='0' title='View' 		onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");'          onClick='view(\"VIEWDATA\");'  />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' 	style='cursor: pointer;' tabindex='0' title='Report' 	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  		onClick='report(\"REPORT\");' />");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) add(\"ADD\");' onClick='add(\"ADD\");'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = new String("../../mms/js/mms.js");
		return jsFile;
		// return null;

	}

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return false;
	}
	public String isGlobal() {
		return "0";
	}
}
