package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Balasubramaniam M Version : 1.0 Date : 15/Jun/2009
 * 
 * This class will be used to insert the records into the Table :
 * HSTT_PO_ITEM_DTL
 */

public class PoItemDtlDAO {
	
	/** The str file name. */
	private final String strFileName = "mms.dao.PoItemDtlDAO";

	/** The str po no. */
	private String strPoNo = "0";
	
	/** The str store id. */
	private String strStoreId = "0";
	
	/** The str item id. */
	private String strItemId = "0";
	
	/** The str item brand id. */
	private String strItemBrandId = "0";
	
	/** The str schedule no. */
	private String strScheduleNo = "0";
	
	/** The str recieve qty. */
	private String strRecieveQty = "0";
	
	/** The str recieve qty unit id. */
	private String strRecieveQtyUnitId = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "0";

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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	// Methods starts from here

	/**
	 * This method will be used to update the records.
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

			strProcName = "{call dml_hstt_po_item_dtl(?,?,?,?,?,?,?,?,?,?)}";
			nProcIndex = dao.setProcedure(strProcName);

			dao.setProcInValue(nProcIndex, "modeval", "3");
			dao.setProcInValue(nProcIndex, "pono", strPoNo);
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "item_id", strItemId);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandId);
			dao.setProcInValue(nProcIndex, "schedule_no", strScheduleNo);
			dao.setProcInValue(nProcIndex, "accepted_qty", strRecieveQty);
			dao
					.setProcInValue(nProcIndex, "accepted_qty_unit",
							strRecieveQtyUnitId);
			dao.setProcInValue(nProcIndex, "store_id", strStoreId);

			dao.setProcOutValue(nProcIndex, "err", 1);

			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			// this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strPoNo = "";
		strStoreId = "";
		strItemId = "";
		strItemBrandId = "";
		strScheduleNo = "";
		strRecieveQty = "";
		strRecieveQtyUnitId = "";
		strHospitalCode = "";

		strErr = "";

	}

	/**
	 * Sets the str po no.
	 * 
	 * @param strPoNo the new str po no
	 */
	public void setStrPoNo(String strPoNo) {
		this.strPoNo = strPoNo;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
	}

	/**
	 * Sets the str schedule no.
	 * 
	 * @param strScheduleNo the new str schedule no
	 */
	public void setStrScheduleNo(String strScheduleNo) {
		this.strScheduleNo = strScheduleNo;
	}

	/**
	 * Sets the str recieve qty.
	 * 
	 * @param strRecieveQty the new str recieve qty
	 */
	public void setStrRecieveQty(String strRecieveQty) {
		this.strRecieveQty = strRecieveQty;
	}

	/**
	 * Sets the str recieve qty unit id.
	 * 
	 * @param strRecieveQtyUnitId the new str recieve qty unit id
	 */
	public void setStrRecieveQtyUnitId(String strRecieveQtyUnitId) {
		this.strRecieveQtyUnitId = strRecieveQtyUnitId;
	}
}
