package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceTypeDAO.
 */
public class InvoiceTypeDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.InvoiceTypeDAO";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str last modified date. */
//	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
//	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str err. */
	private String strErr = "";
	
	/** The str invoice type id. */
	private String strInvoiceTypeId = "";
	
	/** The str invoice type name. */
	private String strInvoiceTypeName = "";
	
	private String strInvoiceType="0";

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

	private String strSlNo;
	
	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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
	 * Sets the str invoice type id.
	 * 
	 * @param strInvoiceTypeId the strInvoiceTypeId to set
	 */
	public void setStrInvoiceTypeId(String strInvoiceTypeId) {
		this.strInvoiceTypeId = strInvoiceTypeId;
	}

	/**
	 * Sets the str invoice type name.
	 * 
	 * @param strInvoiceTypeName the strInvoiceTypeName to set
	 */
	public void setStrInvoiceTypeName(String strInvoiceTypeName) {
		this.strInvoiceTypeName = strInvoiceTypeName;
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
			if (strInvoiceTypeName.equals("0") || strInvoiceTypeName.equals("")) {
				throw new Exception("strInvoiceTypeName can not be blank");
			}
			int nQueryIndex = 0;

			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.invoiceTypeMst.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strInvoiceTypeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strInvoiceType);
			
			// dao.setQryValue(nQueryIndex, 8, "0");

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
	 * Reset.
	 */
	public void reset() {

		strInvoiceTypeId = "0";
		strInvoiceTypeName = "";
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
			if (strInvoiceTypeName.equals("0") || strInvoiceTypeName.equals("")) {
				throw new Exception("strInvoiceTypeName can not be blank");
			}
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms
					.getQuery(1, "update.invoiceTypeMst.1");
			nQueryIndex = dao.setQuery(strQuery);

			
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);			
			dao.setQryValue(nQueryIndex, 3, strInvoiceTypeId);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			

			dao.execute(nQueryIndex, 0);
			
			
			
			strQuery = mms.qryHandler_mms.getQuery(1, "update.invoiceTypeMst.new.record");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strInvoiceTypeId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strInvoiceTypeName);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strInvoiceType);
			dao.setQryValue(nQueryIndex, 9, strInvoiceTypeId);
			dao.setQryValue(nQueryIndex, 10, strHospitalCode);
			// dao.setQryValue(nQueryIndex, 8, "0");

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
			
			
			
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * @param strInvoiceType the strInvoiceType to set
	 */
	public void setStrInvoiceType(String strInvoiceType) {
		this.strInvoiceType = strInvoiceType;
	}
}
