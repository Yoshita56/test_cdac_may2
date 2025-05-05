/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Mod Date : 16/Jun/2009
 * This class will be used to insert/update the records Table Name :
 * HSTT_PATEMP_RETURN_DTL
 * 
 */
public class ReturnFromDtlDAO {

	//private final String strProcName = "";
	private final String strFileName = "mms.dao.ReturnFromDtlDAO";
	
	private String strIssueNo = "";
	private String strReturnNo = "";
	private String strHospitalCode = "";
	private String strStoreId = "";
	private String strReturnDate = "";
	private String strReqtypeId = "";
	private String strCrNo = "";
	private String strAdmnNo = "";
	private String strIssueDate = "";
	private String strEmpNo = "";
	private String strItemCatNo = "";
	private String strReturnNetCost = "";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strRecommendedBy = "";
	private String strRemarks = "";
	private String strRecommendDate = "";
	private String strSeatId = "";
	private String strIsValid = "";
	
	private String strErr = "";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	/**
	 * @return the strIssueNo
	 */
	public String getStrIssueNo() {
		return strIssueNo;
	}
	/**
	 * @param strIssueNo the strIssueNo to set
	 */
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	/**
	 * @return the strReturnNo
	 */
	public String getStrReturnNo() {
		return strReturnNo;
	}
	/**
	 * @param strReturnNo the strReturnNo to set
	 */
	public void setStrReturnNo(String strReturnNo) {
		this.strReturnNo = strReturnNo;
	}
	/**
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @return the strStoreId
	 */
	public String getStrStoreId() {
		return strStoreId;
	}
	/**
	 * @param strStoreId the strStoreId to set
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	/**
	 * @return the strReturnDate
	 */
	public String getStrReturnDate() {
		return strReturnDate;
	}
	/**
	 * @param strReturnDate the strReturnDate to set
	 */
	public void setStrReturnDate(String strReturnDate) {
		this.strReturnDate = strReturnDate;
	}
	/**
	 * @return the strReqtypeId
	 */
	public String getStrReqtypeId() {
		return strReqtypeId;
	}
	/**
	 * @param strReqtypeId the strReqtypeId to set
	 */
	public void setStrReqtypeId(String strReqtypeId) {
		this.strReqtypeId = strReqtypeId;
	}
	/**
	 * @return the strCrNo
	 */
	public String getStrCrNo() {
		return strCrNo;
	}
	/**
	 * @param strCrNo the strCrNo to set
	 */
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	/**
	 * @return the strAdmnNo
	 */
	public String getStrAdmnNo() {
		return strAdmnNo;
	}
	/**
	 * @param strAdmnNo the strAdmnNo to set
	 */
	public void setStrAdmnNo(String strAdmnNo) {
		this.strAdmnNo = strAdmnNo;
	}
	/**
	 * @return the strIssueDate
	 */
	public String getStrIssueDate() {
		return strIssueDate;
	}
	/**
	 * @param strIssueDate the strIssueDate to set
	 */
	public void setStrIssueDate(String strIssueDate) {
		this.strIssueDate = strIssueDate;
	}
	/**
	 * @return the strEmpNo
	 */
	public String getStrEmpNo() {
		return strEmpNo;
	}
	/**
	 * @param strEmpNo the strEmpNo to set
	 */
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	/**
	 * @return the strItemCatNo
	 */
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	/**
	 * @param strItemCatNo the strItemCatNo to set
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	/**
	 * @return the strReturnNetCost
	 */
	public String getStrReturnNetCost() {
		return strReturnNetCost;
	}
	/**
	 * @param strReturnNetCost the strReturnNetCost to set
	 */
	public void setStrReturnNetCost(String strReturnNetCost) {
		this.strReturnNetCost = strReturnNetCost;
	}
	/**
	 * @return the strFinStartDate
	 */
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	/**
	 * @param strFinStartDate the strFinStartDate to set
	 */
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	/**
	 * @return the strFinEndDate
	 */
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	/**
	 * @param strFinEndDate the strFinEndDate to set
	 */
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	/**
	 * @return the strRecommendedBy
	 */
	public String getStrRecommendedBy() {
		return strRecommendedBy;
	}
	/**
	 * @param strRecommendedBy the strRecommendedBy to set
	 */
	public void setStrRecommendedBy(String strRecommendedBy) {
		this.strRecommendedBy = strRecommendedBy;
	}
	/**
	 * @return the strRemarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}
	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	/**
	 * @return the strRecommendDate
	 */
	public String getStrRecommendDate() {
		return strRecommendDate;
	}
	/**
	 * @param strRecommendDate the strRecommendDate to set
	 */
	public void setStrRecommendDate(String strRecommendDate) {
		this.strRecommendDate = strRecommendDate;
	}
	/**
	 * @return the strSeatId
	 */
	public String getStrSeatId() {
		return strSeatId;
	}
	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	/**
	 * @return the strIsValid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}
	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	/**
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}
	/**
	 * @param rowInserted the nRowInserted to set
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	/**
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	/**
	 * @param rowUpdated the nRowUpdated to set
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	/**
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	/**
	 * @param rowDeleted the nRowDeleted to set
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	/**
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	/**
	 * @param insertedIndex the nInsertedIndex to set
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	/**
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	/**
	 * @param updatedIndex the nUpdatedIndex to set
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	/**
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	/**
	 * @param deletedIndex the nDeletedIndex to set
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}
	/**
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}
	
	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when strHospitalCode or strGiftedNo 
	 *             is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;
		
		try {
			
					
			strProcName = "{call Pkg_Mms_Dml.dml_patemp_return_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			
			/*//System.out.println("store_id-->"+ strStoreId);
			//System.out.println("return_no-->"+ strReturnNo);
			//System.out.println("hosp_code-->"+ strHospitalCode);//1
			//System.out.println("issue_no-->"+ strIssueNo);//2
			//System.out.println("return_date-->"+ strReturnDate);
			//System.out.println("reqtype_id-->"+ strReqtypeId);
			//System.out.println("pukno-->"+ strCrNo);
			//System.out.println("adm_no-->"+ strAdmnNo);
			//System.out.println("issue_date-->"+ strIssueDate);
			//System.out.println("emp_no-->"+ strEmpNo);
			//System.out.println("item_cat_no-->"+ strItemCatNo);
			//System.out.println("return_netcost-->"+ strReturnNetCost);
			//System.out.println("financial_start_date-->"+ strFinStartDate);
			//System.out.println("financial_end_date-->"+ strFinEndDate);
			//System.out.println("recommended_by-->"+ strRecommendedBy);
			//System.out.println("recommended_date-->"+ strRecommendDate);
			//System.out.println("remarks-->"+ strRemarks);
			//System.out.println("seatid-->"+ strSeatId);
			//System.out.println("isvalid-->"+ strIsValid);*/
			//System.out.println("issue_no-->"+ strIssueNo.replace("^","#").split("#")[0]);//2
			
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId,2);
			dao.setProcInValue(nProcIndex, "return_no", strReturnNo,3);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,4);//1
			dao.setProcInValue(nProcIndex, "issue_no", strIssueNo.replace("^","#").split("#")[0],5);//2
			dao.setProcInValue(nProcIndex, "return_date", strReturnDate,6);
			dao.setProcInValue(nProcIndex, "reqtype_id", strReqtypeId,7);
			dao.setProcInValue(nProcIndex, "pukno", strCrNo,8);
			dao.setProcInValue(nProcIndex, "adm_no", strAdmnNo,9);
			dao.setProcInValue(nProcIndex, "issue_date", strIssueDate,10);
			dao.setProcInValue(nProcIndex, "emp_no", strEmpNo,11);
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCatNo,12);
			dao.setProcInValue(nProcIndex, "return_netcost", strReturnNetCost,13);
			dao.setProcInValue(nProcIndex, "financial_start_date", strFinStartDate,14);
			dao.setProcInValue(nProcIndex, "financial_end_date", strFinEndDate,15);
			dao.setProcInValue(nProcIndex, "recommended_by", strRecommendedBy,16);
			dao.setProcInValue(nProcIndex, "recommended_date", strRecommendDate,17);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,18);
			dao.setProcInValue(nProcIndex, "seatid", strSeatId,20);
			dao.setProcInValue(nProcIndex, "isvalid", strIsValid,21);
			dao.setProcInValue(nProcIndex, "entry_date", "",19);
			dao.setProcOutValue(nProcIndex, "err", 1,22);
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
		//	this.reset(); // to reset the variables
		}

	}
	
	/**
	 * This method will be used to update the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when strHospitalCode or strGiftedNo 
	 *             is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;
		
		try {
			
			strProcName = "{call dml_returnfrom_item_dtls(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "return_no", strReturnNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);//1
			dao.setProcInValue(nProcIndex, "issue_no", strIssueNo);//2
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
		//	this.reset(); // to reset the variables
		}
	}
	
	public void reset() {

		strIssueNo = "";
		strReturnNo = "";
		strHospitalCode = "";
		strStoreId = "";
		strReturnDate = "";
		strReqtypeId = "";
		strCrNo = "";
		strAdmnNo = "";
		strIssueDate = "";
		strEmpNo = "";
		strItemCatNo = "";
		strReturnNetCost = "";
		strFinStartDate = "";
		strFinEndDate = "";
		strRecommendedBy = "";
		strRemarks = "";
		strRecommendDate = "";
		strSeatId = "";
		strIsValid = "";

	}
	
}
