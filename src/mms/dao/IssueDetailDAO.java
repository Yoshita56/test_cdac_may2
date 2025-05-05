/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 12/June/2009
 * 
 * This class will be used to insert the records Tables : SSTT_ISSUE_DTL
 * [Insert] HSTT_ISSUE_DTL [Insert] SSTT_ACKNOWLEDGE_DTL [insert]
 * SSTT_INDENT_DTL [update] HSTT_INDENT_DTL [update]
 */

public class IssueDetailDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.IssueDetailDAO";

	/** The str seat id. */
	private String strSeatId = "";
	
	private String strAvalaibleBudget="";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str issue no. */
	private String strIssueNO = "";
	
	/** The str item category no. */
	private String strItemCategoryNo = "";
	
	/** The str issue date. */
	//private String strIssueDate = "";
	
	/** The str indent no. */
	private String strIndentNO = "";
	
	private String strStatus ="";
	
	/** The str req type id. */
	private String strReqTypeId = "";
	
	/** The str indent date. */
	private String strIndentDate = "";
	
	/** The str req store id. */
	private String strReqStoreId = "";
	
	/** The str received by. */
	private String strReceivedBy = "";
	
	/** The str net cost. */
	private String strNetCost = "0";
	
	/** The str financial start yr. */
	private String strFinancialStartYr = "";
	
	/** The str financial end yr. */
	private String strFinancialEndYr = "";
	
	/** The str acknowledge by. */
//	private String strAcknowledgeBy = "";
	
	/** The str acknowledge no. */
	//private String strAcknowledgeNo = "";
	
	/** The str acknowledge date. */
	//private String strAcknowledgeDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	
	private String strTotalCost="0";

	/** The str err. */
	private String strErr = "";

	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;

	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;

	/**
	 * Gets the str err.
	 * 
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str issue no.
	 * 
	 * @param strIssueNO the strIssueNO to set
	 */
	public void setStrIssueNO(String strIssueNO) {
		this.strIssueNO = strIssueNO;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

	 

	/**
	 * Sets the str indent no.
	 * 
	 * @param strIndentNO the strIndentNO to set
	 */
	public void setStrIndentNO(String strIndentNO) {
		this.strIndentNO = strIndentNO;
	}

	/**
	 * Sets the str req type id.
	 * 
	 * @param strReqTypeId the strReqTypeId to set
	 */
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}

	/**
	 * Sets the str indent date.
	 * 
	 * @param strIndentDate the strIndentDate to set
	 */
	public void setStrIndentDate(String strIndentDate) {
		this.strIndentDate = strIndentDate;
	}

	/**
	 * Sets the str req store id.
	 * 
	 * @param strReqStoreId the strReqStoreId to set
	 */
	public void setStrReqStoreId(String strReqStoreId) {
		this.strReqStoreId = strReqStoreId;
	}

	/**
	 * Sets the str received by.
	 * 
	 * @param strReceivedBy the strReceivedBy to set
	 */
	public void setStrReceivedBy(String strReceivedBy) {
		this.strReceivedBy = strReceivedBy;
	}

	/**
	 * Sets the str net cost.
	 * 
	 * @param strNetCost the strNetCost to set
	 */
	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
	}

	/**
	 * Sets the str financial start yr.
	 * 
	 * @param strFinancialStartYr the strFinancialStartYr to set
	 */
	public void setStrFinancialStartYr(String strFinancialStartYr) {
		this.strFinancialStartYr = strFinancialStartYr;
	}

	/**
	 * Sets the str financial end yr.
	 * 
	 * @param strFinancialEndYr the strFinancialEndYr to set
	 */
	public void setStrFinancialEndYr(String strFinancialEndYr) {
		this.strFinancialEndYr = strFinancialEndYr;
	}

	 

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.dml_issue_dtls(?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?,?,?,? ,?,?)}";// 22
			nProcIndex = dao.setProcedure(strProcName);

//			 System.out.println("::::::::::::::::Insde insert:::dml_issue_dtls::::::::::::::");
//			 System.out.println("modeval"+ "1");
//			 System.out.println("hospital_code"+ strHospitalCode);
//			 System.out.println("category_No"+ strItemCategoryNo);
//			 System.out.println("fin_start_date"+ strFinancialStartYr);
//			 System.out.println("fin_end_date"+ strFinancialEndYr);
//			 System.out.println("remarks"+strRemarks );
//			 System.out.println("seatId"+ strSeatId);
//			 System.out.println("issuing_store_id"+ strStoreId);
//			 System.out.println("indent_No"+ strIndentNO);
//			 System.out.println("reqType_id"+ strReqTypeId);
//			 System.out.println("indent_Date"+ strIndentDate);
//			 System.out.println("raising_store_id"+ strReqStoreId);
//			 System.out.println("receivedBy"+ strReceivedBy);
//			 System.out.println("net_cost"+strNetCost);
//			 System.out.println("issueNo"+strIssueNO);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNO,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "category_No", strItemCategoryNo,5);
			dao.setProcInValue(nProcIndex, "indent_No", strIndentNO,6);
			dao.setProcInValue(nProcIndex, "reqType_id", strReqTypeId,7);
			dao.setProcInValue(nProcIndex, "indent_Date", strIndentDate.split(" ")[0],8);
			dao.setProcInValue(nProcIndex, "raising_store_id", strReqStoreId,9);
			dao.setProcInValue(nProcIndex, "receivedBy", strReceivedBy,10);
			dao.setProcInValue(nProcIndex, "net_cost", strNetCost,11);			
			dao.setProcInValue(nProcIndex, "fin_start_date",strFinancialStartYr,12);
			dao.setProcInValue(nProcIndex, "fin_end_date", strFinancialEndYr,13);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,14);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId,15);
			dao.setProcInValue(nProcIndex, "strCrNo", "",16);
			dao.setProcInValue(nProcIndex, "strAmNo", "",17);
			dao.setProcInValue(nProcIndex, "strEmpNo", "",18);
			dao.setProcInValue(nProcIndex, "strPoNo", "",19);
			dao.setProcInValue(nProcIndex, "strPoStoreId", "",20);		
			
			dao.setProcInValue(nProcIndex, "strBsReqNo", "0",21);		
			dao.setProcOutValue(nProcIndex, "err", 1,22);

							
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.dml_issue_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 5+16=21
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",3);
			dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNO,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "category_No", "",5);
			dao.setProcInValue(nProcIndex, "indent_No", "",6);
			dao.setProcInValue(nProcIndex, "reqType_id", "",7);
			dao.setProcInValue(nProcIndex, "indent_Date", "",8);
			dao.setProcInValue(nProcIndex, "raising_store_id", "",9);
			dao.setProcInValue(nProcIndex, "receivedBy", "",10);
			dao.setProcInValue(nProcIndex, "net_cost", "",11);			
			dao.setProcInValue(nProcIndex, "fin_start_date","",12);
			dao.setProcInValue(nProcIndex, "fin_end_date", "",13);
			dao.setProcInValue(nProcIndex, "remarks", "",14);
			dao.setProcInValue(nProcIndex, "seatId", "",15);
			dao.setProcInValue(nProcIndex, "strCrNo", "",16);
			dao.setProcInValue(nProcIndex, "strAmNo", "",17);
			dao.setProcInValue(nProcIndex, "strEmpNo", "",18);
			dao.setProcInValue(nProcIndex, "strPoNo", "",19);
			dao.setProcInValue(nProcIndex, "strPoStoreId", "",20);			
			dao.setProcOutValue(nProcIndex, "err", 1,21);
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	
	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update2(HisDAO dao) throws Exception 
	{

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.dml_update_issue_dtls(?,?,?,?,?,?)}";// 6
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "issuing_store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNO,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "strAvalaibleBudget", strAvalaibleBudget,5);
			dao.setProcInValue(nProcIndex, "total_cost", strAvalaibleBudget,6);
			dao.setProcOutValue(nProcIndex, "err", 1,7);
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	
	
	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update3(HisDAO dao) throws Exception 
	{

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			strProcName = "{call Pkg_Mms_Dml.dml_update_indent_dtls(?,?,?,?,?,?)}";//6
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "1",1);
			dao.setProcInValue(nProcIndex, "raising_store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "indentNo", strIndentNO,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "status", strStatus,5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			// e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	

	/**
	 * Reset.
	 */
	public void reset() {

		strSeatId = "";
		strHospitalCode = "";
		strStoreId = "";
		strIssueNO = "";

		strItemCategoryNo = "";
		//strIssueDate = "";
		strIndentNO = "";
		strReqTypeId = "";
		strIndentDate = "";
		strReqStoreId = "";
		strReceivedBy = "";
		strNetCost = "0";
		strFinancialStartYr = "";
		strFinancialEndYr = "";
		//strAcknowledgeBy = "";
		//strAcknowledgeNo = "";
		//strAcknowledgeDate = "";
		strRemarks = "";

	}

	public String getStrAvalaibleBudget() {
		return strAvalaibleBudget;
	}

	public void setStrAvalaibleBudget(String strAvalaibleBudget) {
		this.strAvalaibleBudget = strAvalaibleBudget;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getStrTotalCost() {
		return strTotalCost;
	}

	public void setStrTotalCost(String strTotalCost) {
		this.strTotalCost = strTotalCost;
	}

}
