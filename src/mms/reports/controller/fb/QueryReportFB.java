package mms.reports.controller.fb;

import org.apache.struts.action.ActionForm;

public class QueryReportFB extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String strNormalMsg = "";

	/** The str warning msg. */
	private String strWarningMsg = "";
 
	/** The str err msg. */
	private String strErrMsg = "";

	
	private String qName;
	
	private String fRows;
	
	private String nRows;
	
	private String lastQuery;
	
		
	
	public String getLastQuery() {
		return lastQuery;
	}

	public void setLastQuery(String lastQuery) {
		this.lastQuery = lastQuery;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getfRows() {
		return fRows;
	}

	public void setfRows(String fRows) {
		this.fRows = fRows;
	}

	public String getnRows() {
		return nRows;
	}

	public void setnRows(String nRows) {
		this.nRows = nRows;
	}

	public String getStrNormalMsg() {
		return strNormalMsg;
	}

	public void setStrNormalMsg(String strNormalMsg) {
		this.strNormalMsg = strNormalMsg;
	}
 

	public String getStrWarningMsg() {
		return strWarningMsg;
	}

	public void setStrWarningMsg(String strWarningMsg) {
		this.strWarningMsg = strWarningMsg;
	}
 

	public String getStrErrMsg() {
		return strErrMsg;
	}

	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	
	
	
	
	
}
