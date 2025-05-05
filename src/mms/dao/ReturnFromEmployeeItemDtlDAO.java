/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/Jun/2009
 * This class will be used to insert the records Table Name :
 * HSTT_PATEMP_RETURN_ITEM_DTL
 */
public class ReturnFromEmployeeItemDtlDAO {
	
	//private final String strProcName = "";
	private final String strFileName = "mms.dao.ReturnFromEmployeeItemDtlDAO";
	
	private String strStoreId = "";
	private String strReturnNo = "";
	private String strItemId = "";
	private String strItemBrandId = "";
	private String strBatchSlNo = "";
	private String strHospitalCode = "";
	private String strReturnDate = "";
	private String strItemSlNo = "";
	private String strGroupId = "";
	private String strSubGroupId = "";
	private String strInhandQty = "";
	private String strInhandQtyUnitId = "";
	private String strBalanceQty = "";
	private String strBalanceQtyUnitId = "";
	private String strReturnQty = "";
	private String strReturnQtyUnitId = "";
	private String strRateQty = "";
	private String strRateQtyUnitId = "";
	private String strRemarks = "";
	private String strIsValid = "";
	private String strCost = "";
	private String strStockStatusCode = "";
	private String strIssueNo = "";
	
	
	private String strErr = "";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
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
	 * @return the strItemId
	 */
	public String getStrItemId() {
		return strItemId;
	}
	/**
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}
	/**
	 * @return the strItemBrandId
	 */
	public String getStrItemBrandId() {
		return strItemBrandId;
	}
	/**
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}
	/**
	 * @return the strBatchSlNo
	 */
	public String getStrBatchSlNo() {
		return strBatchSlNo;
	}
	/**
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
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
	 * @return the strReturnQty
	 */
	public String getStrReturnQty() {
		return strReturnQty;
	}
	/**
	 * @param strReturnQty the strReturnQty to set
	 */
	public void setStrReturnQty(String strReturnQty) {
		this.strReturnQty = strReturnQty;
	}
	/**
	 * @return the strReturnQtyUnitId
	 */
	public String getStrReturnQtyUnitId() {
		return strReturnQtyUnitId;
	}
	/**
	 * @param strReturnQtyUnitId the strReturnQtyUnitId to set
	 */
	public void setStrReturnQtyUnitId(String strReturnQtyUnitId) {
		this.strReturnQtyUnitId = strReturnQtyUnitId;
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
			
					
			strProcName = "{call Pkg_Mms_Dml.dml_patemp_return_item_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);
			
			/*//System.out.println("store_id-->"+ strStoreId);
			//System.out.println("return_no-->"+ strReturnNo);
			//System.out.println("item_id-->"+ strItemId);//1
			//System.out.println("itembrand_id-->"+ strItemBrandId);//2
			//System.out.println("batch_sl_no-->"+ strBatchSlNo);
			//System.out.println("hosp_code-->"+ strHospitalCode);
			//System.out.println("return_date-->"+ strReturnDate);
			//System.out.println("item_sl_no-->"+ strItemSlNo);
			//System.out.println("group_id-->"+ strGroupId);
			//System.out.println("subgroup_id-->"+ strSubGroupId);
			//System.out.println("inhand_qty-->"+ strInhandQty);
			//System.out.println("balance_qty-->"+ strBalanceQty);
			//System.out.println("inhand_qty_unitid-->"+ strInhandQtyUnitId);
			//System.out.println("balanceqty_unitid-->"+ strBalanceQtyUnitId);
			//System.out.println("return_qty-->"+ strReturnQty);
			//System.out.println("retqty_unitid-->"+ strReturnQtyUnitId);
			//System.out.println("rate-->"+ strRateQty);
			//System.out.println("rate_unitid-->"+ strRateQtyUnitId);
			//System.out.println("remarks-->"+ strRemarks);
			//System.out.println("cost-->"+ strCost);
			//System.out.println("stock_status_code-->"+ strStockStatusCode);
			//System.out.println("isvalid-->"+ strIsValid);*/
						
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "return_no", strReturnNo);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);//1
			dao.setProcInValue(nProcIndex, "itembrand_id", strItemBrandId);//2
			dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "return_date", strReturnDate);
			dao.setProcInValue(nProcIndex, "item_sl_no", strItemSlNo);
			dao.setProcInValue(nProcIndex, "group_id", strGroupId);
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubGroupId);
			dao.setProcInValue(nProcIndex, "inhand_qty", strInhandQty);
			dao.setProcInValue(nProcIndex, "balance_qty", strBalanceQty);
			dao.setProcInValue(nProcIndex, "inhand_qty_unitid", strInhandQtyUnitId);
			dao.setProcInValue(nProcIndex, "balanceqty_unitid", strBalanceQtyUnitId);
			dao.setProcInValue(nProcIndex, "return_qty", strReturnQty);
			dao.setProcInValue(nProcIndex, "retqty_unitid", strReturnQtyUnitId);
			dao.setProcInValue(nProcIndex, "rate", strRateQty);
			dao.setProcInValue(nProcIndex, "rate_unitid", strRateQtyUnitId);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks);
			dao.setProcInValue(nProcIndex, "cost", strCost);
			dao.setProcInValue(nProcIndex, "stock_status_code", strStockStatusCode);
			dao.setProcInValue(nProcIndex, "isvalid", strIsValid);
			dao.setProcInValue(nProcIndex, "issueNo", strIssueNo);
			
			dao.setProcInValue(nProcIndex, "strItemCategNo", "");
			dao.setProcInValue(nProcIndex, "strDescription", "");
			dao.setProcInValue(nProcIndex, "strSeatid", "");
			dao.setProcInValue(nProcIndex, "expiryDate", "");
			dao.setProcInValue(nProcIndex, "strManufactDate", "");
			dao.setProcInValue(nProcIndex, "strPoNo", "");
			
			dao.setProcOutValue(nProcIndex, "err", 1);
			
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
	 * @return the strBalanceQty
	 */
	public String getStrBalanceQty() {
		return strBalanceQty;
	}
	/**
	 * @param strBalanceQty the strBalanceQty to set
	 */
	public void setStrBalanceQty(String strBalanceQty) {
		this.strBalanceQty = strBalanceQty;
	}
	/**
	 * @return the strBalanceQtyUnitId
	 */
	public String getStrBalanceQtyUnitId() {
		return strBalanceQtyUnitId;
	}
	/**
	 * @param strBalanceQtyUnitId the strBalanceQtyUnitId to set
	 */
	public void setStrBalanceQtyUnitId(String strBalanceQtyUnitId) {
		this.strBalanceQtyUnitId = strBalanceQtyUnitId;
	}
	
	public void reset() {

		strStoreId = "";
		strReturnNo = "";
		strItemId = "";
		strItemBrandId = "";
		strBatchSlNo = "";
		strHospitalCode = "";
		strReturnDate = "";
		strItemSlNo = "";
		strGroupId = "";
		strSubGroupId = "";
		strInhandQty = "";
		strInhandQtyUnitId = "";
		strBalanceQty = "";
		strBalanceQtyUnitId = "";
		strReturnQty = "";
		strReturnQtyUnitId = "";
		strRateQty = "";
		strRateQtyUnitId = "";
		strRemarks = "";
		strIsValid = "";
		strCost = "";
		strStockStatusCode = "";

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
	 * @return the strItemSlNo
	 */
	public String getStrItemSlNo() {
		return strItemSlNo;
	}
	/**
	 * @param strItemSlNo the strItemSlNo to set
	 */
	public void setStrItemSlNo(String strItemSlNo) {
		this.strItemSlNo = strItemSlNo;
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
	 * @return the strGroupId
	 */
	public String getStrGroupId() {
		return strGroupId;
	}
	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}
	/**
	 * @return the strSubGroupId
	 */
	public String getStrSubGroupId() {
		return strSubGroupId;
	}
	/**
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}
	/**
	 * @return the strInhandQty
	 */
	public String getStrInhandQty() {
		return strInhandQty;
	}
	/**
	 * @param strInhandQty the strInhandQty to set
	 */
	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}
	/**
	 * @return the strInhandQtyUnitId
	 */
	public String getStrInhandQtyUnitId() {
		return strInhandQtyUnitId;
	}
	/**
	 * @param strInhandQtyUnitId the strInhandQtyUnitId to set
	 */
	public void setStrInhandQtyUnitId(String strInhandQtyUnitId) {
		this.strInhandQtyUnitId = strInhandQtyUnitId;
	}
	/**
	 * @return the strRateQty
	 */
	public String getStrRateQty() {
		return strRateQty;
	}
	/**
	 * @param strRateQty the strRateQty to set
	 */
	public void setStrRateQty(String strRateQty) {
		this.strRateQty = strRateQty;
	}
	/**
	 * @return the strRateQtyUnitId
	 */
	public String getStrRateQtyUnitId() {
		return strRateQtyUnitId;
	}
	/**
	 * @param strRateQtyUnitId the strRateQtyUnitId to set
	 */
	public void setStrRateQtyUnitId(String strRateQtyUnitId) {
		this.strRateQtyUnitId = strRateQtyUnitId;
	}
	/**
	 * @return the strCost
	 */
	public String getStrCost() {
		return strCost;
	}
	/**
	 * @param strCost the strCost to set
	 */
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	/**
	 * @return the strStockStatusCode
	 */
	public String getStrStockStatusCode() {
		return strStockStatusCode;
	}
	/**
	 * @param strStockStatusCode the strStockStatusCode to set
	 */
	public void setStrStockStatusCode(String strStockStatusCode) {
		this.strStockStatusCode = strStockStatusCode;
	}
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

}
