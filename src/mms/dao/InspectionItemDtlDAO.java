/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 13/April/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_INSPECTION_ITEM_DTL
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 16/April/2009 (ADD SOME FIELDS
 * AND INSERT1() METHOD) This class will be used to insert the records into the
 * Table : HSTT_INSPECTION_ITEM_DTL
 */
public class InspectionItemDtlDAO {
	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.InspectionItemDtlDAO";

	/** The str issued qty. */
	private String strIssuedQty = "";
	
	/** The str issued qty unit id. */
	private String strIssuedQtyUnitId = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str req no. */
	private String strReqNo = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";
	
	/** The str report. */
	private String strReport = "";
	
	/** The str status. */
	private String strStatus = "";
	
	/** The str return qty. */
	private String strReturnQty = "";
	
	/** The str return qty unit id. */
	private String strReturnQtyUnitId = "";

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
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the strBatchSlNo to set
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
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
	 * Sets the str req no.
	 * 
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the strItemId to set
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the strItemBrandId to set
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str report.
	 * 
	 * @param strReport the strReport to set
	 */
	public void setStrReport(String strReport) {
		this.strReport = strReport;
	}

	/**
	 * Sets the str status.
	 * 
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * Sets the str return qty.
	 * 
	 * @param strReturnQty the strReturnQty to set
	 */
	public void setStrReturnQty(String strReturnQty) {
		this.strReturnQty = strReturnQty;
	}

	/**
	 * Sets the str return qty unit id.
	 * 
	 * @param strReturnQtyUnitId the strReturnQtyUnitId to set
	 */
	public void setStrReturnQtyUnitId(String strReturnQtyUnitId) {
		this.strReturnQtyUnitId = strReturnQtyUnitId;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the strHospitalCode
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
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
	 * Gets the str issued qty.
	 * 
	 * @return the strIssuedQty
	 */
	public String getStrIssuedQty() {
		return strIssuedQty;
	}

	/**
	 * Sets the str issued qty.
	 * 
	 * @param strIssuedQty the strIssuedQty to set
	 */
	public void setStrIssuedQty(String strIssuedQty) {
		this.strIssuedQty = strIssuedQty;
	}

	/**
	 * Gets the str issued qty unit id.
	 * 
	 * @return the strIssuedQtyUnitId
	 */
	public String getStrIssuedQtyUnitId() {
		return strIssuedQtyUnitId;
	}

	/**
	 * Sets the str issued qty unit id.
	 * 
	 * @param strIssuedQtyUnitId the strIssuedQtyUnitId to set
	 */
	public void setStrIssuedQtyUnitId(String strIssuedQtyUnitId) {
		this.strIssuedQtyUnitId = strIssuedQtyUnitId;
	}

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
	 * Gets the str file name.
	 * 
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strGiftedNo is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			/*
			 * if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); } if
			 * (strRequestNo.equals("0") || strRequestNo.equals("")) { throw new
			 * Exception("strRequestNo can not be blank"); } if
			 * (strStoreId.equals("0") || strStoreId.equals("")) { throw new
			 * Exception("strStoreId can not be blank"); } if
			 * (strItemId.equals("0") || strItemId.equals("")) { throw new
			 * Exception("strItemId can not be blank"); } if
			 * (strItemBrandId.equals("0") || strItemBrandId.equals("")) { throw
			 * new Exception("strItemBrandId can not be blank"); } if
			 * (strBatchSlNo.equals("0") || strBatchSlNo.equals("")) { throw new
			 * Exception("strBatchSlNo can not be blank"); }
			 */

			strProcName = "{call dml_inspection_item_dtls(?,?,?,?,?,?,?,?,?,?)}"; //10
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "storeid", strStoreId.trim());
			dao.setProcInValue(nProcIndex, "hospcode", strReqNo.trim());
			dao.setProcInValue(nProcIndex, "req_no", strHospitalCode.trim());
			dao.setProcInValue(nProcIndex, "itemid", strItemId.trim());
			dao
					.setProcInValue(nProcIndex, "itembrandid", strItemBrandId
							.trim());
			dao.setProcInValue(nProcIndex, "batchslno", strBatchSlNo.trim());
			dao.setProcInValue(nProcIndex, "issue_qty", strIssuedQty.trim());
			dao.setProcInValue(nProcIndex, "issueqty_unitid",
					strIssuedQtyUnitId.trim());
			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to insert the REPORT DETAILS IN INSOECTION ITEM
	 * TABLE (BY ANSHUL).
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode or strGiftedNo is blank
	 */
	public void updateReport(HisDAO dao) throws Exception {

		strErr = "";
		int nProcIndex = 0;
	//	String strProcName = "DML_INSPECTION_REPORT_DTL";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}
			if (strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}

			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if (strItemBrandId.equals("0") || strItemBrandId.equals("")) {
				throw new Exception("strItemBrandId can not be blank");
			}

			if (strBatchSlNo.equals("0") || strBatchSlNo.equals("")) {
				throw new Exception("strBatchSlNo can not be blank");
			}

			nProcIndex = dao
					.setProcedure("{call DML_INSPECTION_REPORT_DTL(?,?,?,?,?,?,?,?,?,?,?,?)}");// 12

			/*
			 * //System.out.println("strHospitalCode"+strHospitalCode);
			 * //System.out.println( "store_id"+strStoreId); //System.out.println(
			 * "req_no"+strReqNo); //System.out.println( "item_id"+strItemId);
			 * //System.out.println( "item_brand_id"+strItemBrandId);
			 * //System.out.println( "batchSl_no"+strBatchSlNo);
			 * //System.out.println( "report"+strReport); //System.out.println(
			 * "status"+strStatus); //System.out.println(
			 * "return_qty"+strReturnQty); //System.out.println(
			 * "return_qty_unitid"+ strReturnQtyUnitId);
			 */
			dao.setProcInValue(nProcIndex, "modval", "1");
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);
			dao.setProcInValue(nProcIndex, "req_no", strReqNo);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "batchSl_no", strBatchSlNo);
			dao.setProcInValue(nProcIndex, "report", strReport);
			dao.setProcInValue(nProcIndex, "status", strStatus);
			dao.setProcInValue(nProcIndex, "return_qty", strReturnQty);
			dao.setProcInValue(nProcIndex, "return_qty_unitid",
					strReturnQtyUnitId);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);

			this.nRowUpdated++;
		} catch (Exception e) {

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

		strIssuedQty = "";
		strIssuedQtyUnitId = "";
		strStoreId = "";
		strReqNo = "";
		strItemId = "";
		strItemBrandId = "";
		strBatchSlNo = "";
		strReport = "";
		strStatus = "";
		strReturnQty = "";
		strReturnQtyUnitId = "";

	}

}
