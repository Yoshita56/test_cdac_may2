package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class CommitteRemarksDtlDAO {
	private final String strProcName = "pkg_mms_dml.dml_hstt_committee_remarks_dtl";
	private final String strFileName = "mms.dao.CommitteRemarksDtlDAO";
	private String strErr = "";


	private String  strCommitteNo="";
	private String  strEmpCode="";
	private String strMemberName="";
	private String strCommRemarksSlNo="";
	private String strHospCode="";
	private String strCommitteTypeId="";
	private String remarks="";
	private String strChairPersonFlag="0";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	
	
	
	
	
	public int getNRowInserted() {
		return nRowInserted;
	}
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

//	Methods starts from here
	
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex = 0;
		
		try {
			
					nProcIndex=dao.setProcedure("{call "+strProcName+"(?,?,?,?,?,?,?,?,?)}");
			
			 		dao.setProcInValue(nProcIndex, "committeNo", strCommitteNo.trim(),2);
					dao.setProcInValue(nProcIndex, "empCode", strEmpCode.trim(),3);
					dao.setProcInValue(nProcIndex, "memberName", strMemberName.trim(),4);
					dao.setProcInValue(nProcIndex, "commRemarksSlNo", strCommRemarksSlNo.trim(),5);
					dao.setProcInValue(nProcIndex, "hosp_code", strHospCode.trim(),6);
					dao.setProcInValue(nProcIndex, "committeTypeId", strCommitteTypeId.trim(),7);
					dao.setProcInValue(nProcIndex, "remarks", remarks.trim(),8);
					//dao.setProcInValue(nProcIndex, "chairperson_flag", strChairPersonFlag.trim());
					
					dao.setProcInValue(nProcIndex, "modval", "1",1); // Default Value.

					
					dao.setProcOutValue(nProcIndex, "err", 1,9);
					dao.execute(nProcIndex, 1);
				    this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		

	}

	
	public void reset() {

		  strCommitteNo="";
		  strEmpCode="";
		  strMemberName="";
		  strCommRemarksSlNo="";
		  strHospCode="";
		  strCommitteTypeId="";
		  remarks="";


	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public void setStrCommitteNo(String strCommitteNo) {
		this.strCommitteNo = strCommitteNo;
	}
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}
	public void setStrMemberName(String strMemberName) {
		this.strMemberName = strMemberName;
	}
	public void setStrCommRemarksSlNo(String strCommRemarksSlNo) {
		this.strCommRemarksSlNo = strCommRemarksSlNo;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public void setStrCommitteTypeId(String strCommitteTypeId) {
		this.strCommitteTypeId = strCommitteTypeId;
	}
	
	public void setStrChairPersonFlag(String strChairPersonFlag) {
		this.strChairPersonFlag = strChairPersonFlag;
	}
	

}
