package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 8/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_SUPPLIERITEM_MST
 */
public class SupplierItemDAO {

	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SupplierItemDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str supplier item sl no. */
	private String strSupplierItemSlNo = "";
	
	/** The str item rate. */
	//private String strItemRate = "0";
	
	/** The str rate unit id. */
//	private String strRateUnitId = "";

	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
//	private String strEffectiveTo = "";
	
	/** The str last mode seat id. */
//	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
//	private String strLastModeDate = "";
	
	/** The str entry date. */
//	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";

	/** The str delivery lead time. */
//	private String strDeliveryLeadTime = "";
	
	/** The str delivery lead time unit. */
//	private String strDeliveryLeadTimeUnit = "";

	/** The str group id. */
	private String strGroupId = "0";
	
	/** The str sub group id. */
	private String strSubGroupId = "0";
	
	/** The str item category no. */
	private String strItemCategoryNo = "10";

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

	private String strSlNo;
	
	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
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
	 * Sets the str supplier item sl no.
	 * 
	 * @param strSupplierItemSlNo the strSupplierItemSlNo to set
	 */
	public void setStrSupplierItemSlNo(String strSupplierItemSlNo) {
		this.strSupplierItemSlNo = strSupplierItemSlNo;
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
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the strEffectiveFrom to set
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
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

	 

	 

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemId or strHospitalCode or strSupplierId is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// //System.out.println("dao dao insert");
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.SupplierItem.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strItemBrandId);
			dao.setQryValue(nQueryIndex, 4, strSupplierId);
			dao.setQryValue(nQueryIndex, 5, strHospitalCode);
			dao.setQryValue(nQueryIndex, 6, strItemBrandId);
			dao.setQryValue(nQueryIndex, 7, strItemId);
			dao.setQryValue(nQueryIndex, 8, strSupplierId);
			dao.setQryValue(nQueryIndex, 9, strRemarks);
			dao.setQryValue(nQueryIndex, 10, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 11, strSeatId);
			dao.setQryValue(nQueryIndex, 12, strIsValid);
			dao.setQryValue(nQueryIndex, 13, strGroupId);
			dao.setQryValue(nQueryIndex, 14, strSubGroupId);
			dao.setQryValue(nQueryIndex, 15, strItemCategoryNo);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemId or strHospitalCode OR strSupplierId or
	 * strSupplierItemSlNo is blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("strItemId can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}

			if (strSupplierItemSlNo.equals("0")
					|| strSupplierItemSlNo.equals("")) {
				throw new Exception("strSupplierItemSlNo can not be blank");
			}

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.SupplierItem.1");
			nQueryIndex = dao.setQuery(strQuery);

			/*
			 * dao.setQryValue(nQueryIndex, 1, strItemRate);
			 * dao.setQryValue(nQueryIndex, 2, strRateUnitId);
			 * dao.setQryValue(nQueryIndex, 3, strDeliveryLeadTime);
			 * dao.setQryValue(nQueryIndex, 4, strDeliveryLeadTimeUnit);
			 */
			
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strSupplierId);
			dao.setQryValue(nQueryIndex, 4, strItemId);
			dao.setQryValue(nQueryIndex, 5, strItemBrandId);
			dao.setQryValue(nQueryIndex, 6, strSupplierItemSlNo);
			dao.setQryValue(nQueryIndex, 7, strSlNo);

			dao.execute(nQueryIndex, 0);
			
			
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.SupplierItem.new.record");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemId);
			dao.setQryValue(nQueryIndex, 3, strItemBrandId);
			dao.setQryValue(nQueryIndex, 4, strSupplierId);
			dao.setQryValue(nQueryIndex, 5, strHospitalCode);
			dao.setQryValue(nQueryIndex, 6, strItemBrandId);
			dao.setQryValue(nQueryIndex, 7, strItemId);
			dao.setQryValue(nQueryIndex, 8, strSupplierId);
			dao.setQryValue(nQueryIndex, 9, strRemarks);
			dao.setQryValue(nQueryIndex, 10, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 11, strSeatId);
			dao.setQryValue(nQueryIndex, 12, strIsValid);
			dao.setQryValue(nQueryIndex, 13, strGroupId);
			dao.setQryValue(nQueryIndex, 14, strSubGroupId);
			dao.setQryValue(nQueryIndex, 15, strItemCategoryNo);
			
			
			dao.setQryValue(nQueryIndex, 16, strHospitalCode);
			dao.setQryValue(nQueryIndex, 17, strSupplierId);
			dao.setQryValue(nQueryIndex, 18, strItemId);
			dao.setQryValue(nQueryIndex, 19, strItemBrandId);
			dao.setQryValue(nQueryIndex, 20, strSupplierItemSlNo);
			

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

		strHospitalCode = "";
		strSupplierId = "";
		strItemId = "";
		strItemBrandId = "";
		strSupplierItemSlNo = "";
	//	strItemRate = "0";
	//	strRateUnitId = "";
		strRemarks = "";
		strEffectiveFrom = "";
	//	strEffectiveTo = "";
	//	strLastModeSeatId = "";
	//	strLastModeDate = "";
		//strEntryDate = "";
		strSeatId = "";
		strIsValid = "1";
		strGroupId = "0";
		strSubGroupId = "0";
		strItemCategoryNo = "1";
		// strDelieveryLeadTime = "";
		// strDelieveryLeadTimeUnit = "";

	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the strSubGroupId to set
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
	}

}
