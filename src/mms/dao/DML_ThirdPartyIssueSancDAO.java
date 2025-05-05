package mms.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class DML_ThirdPartyIssueSancDAO {
	
	private final String strProcName = "Pkg_Mms_Dml.Dml_Third_Party_Issue";
	private final String strFileName = "mms.dao.DML_ThirdPartyIssueSancDAO";
	
	private String strHospitalCode = "";
	private String strReqDate = "";
	private String strItemCatNo = "";
	private String strIssueDate = "";
	private String strStoreId = "";
	private String strInstituteCode = "";
	private String strReqStatus = "1";
	private String strFinancialStartYear = "";
	private String strFinancialEndYear = "";
	private String strRemarks = "";
	private String strEntryDate = "";
	private String strReceiveBy = "";
	private String strSeatId = "";
	private String strGnumIsValid = "";
	private String strTReqNo = "";
	private String strErr = "";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrIssueDate() {
		return strIssueDate;
	}
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrInstituteCode() {
		return strInstituteCode;
	}
	public void setStrInstituteCode(String strInstituteCode) {
		this.strInstituteCode = strInstituteCode;
	}
	public String getStrReqStatus() {
		return strReqStatus;
	}
	public void setStrReqStatus(String strReqStatus) {
		this.strReqStatus = strReqStatus;
	}
	public String getStrFinancialStartYear() {
		return strFinancialStartYear;
	}
	public void setStrFinancialStartYear(String strFinancialStartYear) {
		this.strFinancialStartYear = strFinancialStartYear;
	}
	public String getStrFinancialEndYear() {
		return strFinancialEndYear;
	}
	public void setStrFinancialEndYear(String strFinancialEndYear) {
		this.strFinancialEndYear = strFinancialEndYear;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrEntryDate() {
		return strEntryDate;
	}
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrTReqNo() {
		return strTReqNo;
	}
	public void setStrTReqNo(String strTReqNo) {
		this.strTReqNo = strTReqNo;
	}
	public String getStrProcName() {
		return strProcName;
	}
	public String getStrFileName() {
		return strFileName;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public int getNRowInserted() {
		return nRowInserted;
	}
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		int nProcIndex = 0;
			
		try {
			
			if(strTReqNo.equals("0") || strTReqNo.equals("")) {
				throw new Exception("strTReqNo can not be blank");
			}
			if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			////System.out.println("strProcName"+strProcName);
			////System.out.println("strTReqNo   "+strTReqNo);
			////System.out.println("store_id   "+strStoreId);
			////System.out.println("itemcat_no   "+strItemCatNo);
			////System.out.println("hosp_code   "+strHospitalCode);
			////System.out.println("issue_date   "+strIssueDate);
			////System.out.println("req_status   "+strReqStatus);
			////System.out.println("recieve_by   "+strReceiveBy);
			////System.out.println("remarks   "+strRemarks);
			
			
			////System.out.println("seat_id   "+strSeatId);
			
			HisUtil hisutil = new HisUtil("MMS", "PODeskCancelTransDAO");				
			String  strCurrentDate	= hisutil.getASDate("dd-MMM-yyyy");
			 
			
			//check mandatory information
		
			nProcIndex = dao.setProcedure("{call Pkg_Mms_Dml.Dml_Third_Party_Issue(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}");
			
			dao.setProcInValue(nProcIndex, "modval", "2",1);
			dao.setProcInValue(nProcIndex, "req_no", strTReqNo,2);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,3);
			dao.setProcInValue(nProcIndex, "req_date", strCurrentDate,4);
			dao.setProcInValue(nProcIndex, "itemcat_no", strItemCatNo,5);
			dao.setProcInValue(nProcIndex, "issue_date", strIssueDate,6);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,7);
			dao.setProcInValue(nProcIndex, "institute_code", "",8);
			dao.setProcInValue(nProcIndex, "institute_slno", "0",9);
			dao.setProcInValue(nProcIndex, "req_status ", this.strReqStatus,10); 
			dao.setProcInValue(nProcIndex, "financial_start_date", "",11);
			dao.setProcInValue(nProcIndex, "financial_end_date", "",12);
			dao.setProcInValue(nProcIndex, "recieve_by", this.strReceiveBy,13);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,14);
			dao.setProcInValue(nProcIndex, "entry_date", strCurrentDate,15);
			////System.out.println("Step 1");
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,16);
			dao.setProcInValue(nProcIndex, "isvalid", "1",17);       
			dao.setProcInValue(nProcIndex, "issuedate", "",18);   
			dao.setProcInValue(nProcIndex, "approvalflag", "1",19);   
			
			////System.out.println("Step 2");
			dao.setProcOutValue(nProcIndex, "retSerialNo", 1,20);
			dao.setProcOutValue(nProcIndex, "err", 1,21);     
			dao.setProcOutValue(nProcIndex, "dml_count", 1,22);
			dao.setProcOutValue(nProcIndex, "approval_level", 1,23);
			
		    dao.executeProcedureByPosition(nProcIndex);
		    
		    
		    String err=dao.getString(nProcIndex, "err");
		    
		    if (!err.equals("")) {

				throw new Exception(err);
			}
		    
		    ////System.out.println("Step 3");
		    //this.nRowInserted++;
		} 
		catch(Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		

	}
		public void reset() {
			strHospitalCode = "";
			strReqDate = "";
			strItemCatNo = "";
			strInstituteCode = "";
			strReqStatus = "1";
			strFinancialStartYear = "";
			strFinancialEndYear = "";
			strRemarks = "";
			strSeatId = "";
			strStoreId = "";
			strIssueDate = "";
			strEntryDate = "";
			strSeatId = "";
			strTReqNo = "";
			}
		public String getStrGnumIsValid() {
			return strGnumIsValid;
		}
		public void setStrGnumIsValid(String strGnumIsValid) {
			this.strGnumIsValid = strGnumIsValid;
		}
		public String getStrReceiveBy() {
			return strReceiveBy;
		}
		public void setStrReceiveBy(String strReceiveBy) {
			this.strReceiveBy = strReceiveBy;
		}
		}
