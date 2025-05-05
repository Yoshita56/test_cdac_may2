package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DeliveryModeDAO.
 */
public class DeliveryModeDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.DeliveryModeDAO";

	/** The str delivery mode id. */
	private String strDeliveryModeId = "";
	
	/** The str delivery mode name. */
	private String strDeliveryModeName = "";
	
	/** The str is details. */
//	private String strIsDetails = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	private String strSerialNo="";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str last modified date. */
	//private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	//private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
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
	 * Sets the str delivery mode id.
	 * 
	 * @param strDeliveryModeId the strDeliveryModeId to set
	 */
	public void setStrDeliveryModeId(String strDeliveryModeId) {
		this.strDeliveryModeId = strDeliveryModeId;
	}

	/**
	 * Sets the str delivery mode name.
	 * 
	 * @param strDeliveryModeName the strDeliveryModeName to set
	 */
	public void setStrDeliveryModeName(String strDeliveryModeName) {
		this.strDeliveryModeName = strDeliveryModeName;
	}

	 

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Sets the str err.
	 * 
	 * @param strErr the strErr to set
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strDeliveryModeName.equals("0")
					|| strDeliveryModeName.equals("")) {
				throw new Exception("strDeliveryModeName can not be blank");
			}
			int nQueryIndex = 0;

			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,
					"insert.deliveryModeMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strDeliveryModeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}
	
	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert1(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strDeliveryModeName.equals("0")
					|| strDeliveryModeName.equals("")) {
				throw new Exception("strDeliveryModeName can not be blank");
			}
			int nQueryIndex = 0;

			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,"insert.deliveryModeMst.1a");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strDeliveryModeId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strDeliveryModeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			dao.setQryValue(nQueryIndex, 9, strDeliveryModeId);
			

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert1() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}


	/**
	 * Reset.
	 */
	public void reset() {

		strDeliveryModeId = "0";
		strDeliveryModeName = "";
		strEffectiveFrom = "";
		strRemarks = "";
	//	strEntryDate = "";
	//	strLastModifiedDate = "";
		strSeatId = "";
	//	strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

	}

	/**
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strDeliveryModeName.equals("0")
					|| strDeliveryModeName.equals("")) {
				throw new Exception("strDeliveryModeName can not be blank");
			}
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.deliveryMst.1");
			nQueryIndex = dao.setQuery(strQuery);			
			
			dao.setQryValue(nQueryIndex, 1, strSeatId);						
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strDeliveryModeId);
			dao.setQryValue(nQueryIndex, 4, strSerialNo);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}
}
