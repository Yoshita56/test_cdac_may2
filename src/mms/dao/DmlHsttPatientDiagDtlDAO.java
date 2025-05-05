package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class DmlHsttPatientDiagDtlDAO 
{
	private final String strFileName = "mms.dao.DmlHsttPatientDiagDtlDAO";
	private final String strProcName = "PKG_MMS_DML.Dml_Hstt_Patient_Diagnosis_Dtl";
	private String strLpReqNo ="";
	private String strStoreId ="";
	private String strSlNo    ="";
	private String strHospCode="";
	private String strPukNo   ="";
	private String strDiagnosisCode="";
	private String strDiagnosisType="";
//	private String strEntryDate ="";
//	private String strIsValid="";
	
	private String strErr = "";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	public String getStrErr() {
		return strErr;
	}
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
	public void setStrLpReqNo(String strLpReqNo) {
		this.strLpReqNo = strLpReqNo;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}
	public void setStrPukNo(String strPukNo) {
		this.strPukNo = strPukNo;
	}
	public void setStrDiagnosisCode(String strDiagnosisCode) {
		this.strDiagnosisCode = strDiagnosisCode;
	}
	public void setStrDiagnosisType(String strDiagnosisType) {
		this.strDiagnosisType = strDiagnosisType;
	}
	 
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	
	public int insert(HisDAO dao) throws Exception 
	{
		strErr = "";
		try 
		{
			if(this.nRowInserted == 0) 
			{
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?)}");
			}
			System.out.println("<<------  DmlHsttPatientDiagDtlDAO       ------>>"+strProcName+" [ Mode  - 1 ]");
		
			//Input Value
			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);                           		//1
		   	dao.setProcInValue(nInsertedIndex,"strLpReqNo",strLpReqNo.trim(),2);              //2
	       	dao.setProcInValue(nInsertedIndex,"strStoreId",strStoreId.trim(),3);           	//3
			dao.setProcInValue(nInsertedIndex,"strSlNo ",strSlNo.trim(),4);          		    //4 
			dao.setProcInValue(nInsertedIndex,"strHospCode",strHospCode.trim(),5);        	//5
			dao.setProcInValue(nInsertedIndex,"strPukNo ",strPukNo.trim(),6);				    //6 
			dao.setProcInValue(nInsertedIndex,"strDiagnosisCode",strDiagnosisCode.trim(),7);	//7
			dao.setProcInValue(nInsertedIndex,"strDiagnosisType",strDiagnosisType.trim(),8);	//8
			dao.setProcInValue(nInsertedIndex,"strEntryDate","",9);
			dao.setProcInValue(nInsertedIndex,"strIsValid","",10);
						    	
			//output value                        
			dao.setProcOutValue(nInsertedIndex,"err",1,11);                               		//9
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e)
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
		return nInsertedIndex;
	}
	
	private void reset() {
		
		strLpReqNo ="";
		strStoreId ="";
		strSlNo    ="";
		strHospCode="";
		strPukNo   ="";
		strDiagnosisCode="";
		strDiagnosisType="";
	//	strEntryDate ="";
	//	strIsValid="";
	}
	
}
