package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierGradeDAO.
 * 
 * @author Tanvi Sappal
 * 
 * The Class StoreTypeDAO.
 */
public class SupplierGradeDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SupplierGradeDAO";

	/** The str supplier grade id. */
	private String strSupplierGradeId = "0";
	
	/** The str grade name. */
	private String strGradeName = "";
	
	/** The str grade criteria. */
	private String strGradeCriteria = "";

	/** The str effective from. */
	private String strEffectiveFrom = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str entry date. */
	private String strEntryDate = "";

	/** The str last modified date. */
	private String strLastModifiedDate = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";

	/** The str is valid. */
	private String strIsValid = "1";

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

	public String strSlNo;
	
	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str last modified date.
	 * 
	 * @return the str last modified date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the new str last modified date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str last modified seat id.
	 * 
	 * @return the str last modified seat id
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the new str last modified seat id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	// Methods starts from here

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
			if (strGradeName.equals("0") || strGradeName.equals("")) {
				throw new Exception("strGradeName can not be blank");
			}
			if (strGradeCriteria.equals("0") || strGradeCriteria.equals("")) {
				throw new Exception("strGradeCriteria can not be blank");
			}
			if (strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
				throw new Exception("strEffectiveFrom can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			// check mandatory information
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,"insert.SupplierGradeMst.0");
			
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strGradeName);
			dao.setQryValue(nQueryIndex, 3, strGradeCriteria);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
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
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {
			/*
			 * if(strGradeName.equals("0") || strGradeName.equals("")) { throw
			 * new Exception("strGradeName can not be blank"); }
			 * if(strGradeCriteria.equals("0") || strGradeCriteria.equals("")) {
			 * throw new Exception("strGradeCriteria can not be blank"); }
			 * if(strSupplierGradeId.equals("0") ||
			 * strSupplierGradeId.equals("")) { throw new
			 * Exception("strSupplierGradeId can not be blank"); }
			 * if(strEffectiveFrom.equals("0") || strEffectiveFrom.equals("")) {
			 * throw new Exception("strEffectiveFrom can not be blank"); }
			 * if(strSeatId.equals("0") || strSeatId.equals("")) { throw new
			 * Exception("strSeatId can not be blank"); }
			 * if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"update.SupplierGradeMst.1");
			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);			
			dao.setQryValue(nQueryIndex, 2, strSupplierGradeId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);			
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			
			dao.execute(nQueryIndex, 0);
			
			
			strQuery = mms.qryHandler_mms.getQuery(1,"insert.SupplierGradeMst.new.record");
			
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strSupplierGradeId);
			dao.setQryValue(nQueryIndex, 2, strGradeName);
			dao.setQryValue(nQueryIndex, 3, strGradeCriteria);
			dao.setQryValue(nQueryIndex, 4, strRemarks);
			dao.setQryValue(nQueryIndex, 5, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 6, strSeatId);
			dao.setQryValue(nQueryIndex, 7, strIsValid);
			dao.setQryValue(nQueryIndex, 8, strHospitalCode);
			
			dao.setQryValue(nQueryIndex, 9, strHospitalCode);
			dao.setQryValue(nQueryIndex, 10, strSupplierGradeId);
			
			dao.execute(nQueryIndex, 0);
			
			this.nRowUpdated++;

		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strSupplierGradeId = "0";
		strGradeName = "";
		strGradeCriteria = "";
		strEffectiveFrom = "";
		strRemarks = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

	}

	/**
	 * Gets the str supplier grade id.
	 * 
	 * @return the str supplier grade id
	 */
	public String getStrSupplierGradeId() {
		return strSupplierGradeId;
	}

	/**
	 * Sets the str supplier grade id.
	 * 
	 * @param strSupplierGradeId the new str supplier grade id
	 */
	public void setStrSupplierGradeId(String strSupplierGradeId) {
		this.strSupplierGradeId = strSupplierGradeId;
	}

	/**
	 * Gets the str grade name.
	 * 
	 * @return the str grade name
	 */
	public String getStrGradeName() {
		return strGradeName;
	}

	/**
	 * Sets the str grade name.
	 * 
	 * @param strGradeName the new str grade name
	 */
	public void setStrGradeName(String strGradeName) {
		this.strGradeName = strGradeName;
	}

	/**
	 * Gets the str grade criteria.
	 * 
	 * @return the str grade criteria
	 */
	public String getStrGradeCriteria() {
		return strGradeCriteria;
	}

	/**
	 * Sets the str grade criteria.
	 * 
	 * @param strGradeCriteria the new str grade criteria
	 */
	public void setStrGradeCriteria(String strGradeCriteria) {
		this.strGradeCriteria = strGradeCriteria;
	}

}
