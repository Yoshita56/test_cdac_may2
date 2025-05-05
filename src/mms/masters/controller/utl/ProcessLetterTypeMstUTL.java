package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstUTL.
 */
public class ProcessLetterTypeMstUTL implements MasterInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {
		StringBuilder br = new StringBuilder();
		br.append("<br><a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) return callMe3(document.forms[0]);' 	onClick='return callMe3(document.forms[0]);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) return callMe4(document.forms[0]);' 	onClick='return callMe4(document.forms[0]);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 			onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 				onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  				onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");

		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Letter Type Name", "Effective From",
				"Record Status" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Process Name" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] comboQuery = new String[2];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.ProcessNameCombo.0").replace("?", "" + Config.SUPER_USER_HOSPITAL_CODE + "");
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] deleteQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.ProcessLetterTypeMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.ProcessLetterTypeMst.cond.0"));
		// deleteQuery[0] =
		// mms.qryHandler_mms.getQuery(1,"delete.ProcessLetterTypeMst.0");
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String jsFile = new String("../../mms/js/mms.js");
		return jsFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(mms.qryHandler_mms.getQuery(1,
				"select.ProcessLetterTypeMst.0")
				.replace("?", "" + hosCode + ""));
		/*
		 * .append(" AND "+
		 * mms.qryHandler_mms.getQuery(1,"select.ProcessLetterTypeMst.cond.0"
		 * ).replace("?","1"));
		 * 
		 * if (cmb != null) { if (!cmb[1].equals("0")) {
		 * brMainQuery.replace(brMainQuery.lastIndexOf("1"),
		 * brMainQuery.lastIndexOf("1")+1, cmb[1]); } }
		 */
		brMainQuery
				.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.ProcessLetterTypeMst.cond.1").replace(
								"?", "0"));
		if (cmb != null) {
			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);
				httpSession.setAttribute("strProcessId", cmb[0]);
			}
		}
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = "Process Letter Type Master";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = { "1", "C.LETTER_TYPE_NAME" };
		return orderBy;
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
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {
		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {
		String search_field[] = { "1", "C.LETTER_TYPE_NAME" };
		return search_field;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			viewHdr.add("Drug Warehouse Type Name");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store Type Name");
			viewHdr.add("D");
		}
		
		viewHdr.add("Letter Type Name");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {
		String viewQuery = mms.qryHandler_mms.getQuery(1,
				"select.ProcessLetterTypeMst.1");
		return viewQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#setHttpSession(javax.servlet.http
	 * .HttpSession)
	 */
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;

	}

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return true;
	}
	public String isGlobal() {
		return "0";
	}

}
