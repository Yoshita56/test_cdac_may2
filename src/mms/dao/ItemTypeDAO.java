/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTypeDAO.
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 05/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_ITEMTYPE_MST
 */
public class ItemTypeDAO {

	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.ItemTypeDAO";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	private String strSlNo;
	
	/** The str item type id. */
	private String strItemTypeId = "";
	
	/** The str item type name. */
	private String strItemTypeName = "";
	
	/** The str short name. */
	private String strShortName = "";
	
	/** The str item cat no. */
	private String strItemCatNo = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str item type id.
	 * 
	 * @param strItemTypeId the strItemTypeId to set
	 */
	public void setStrItemTypeId(String strItemTypeId) {
		this.strItemTypeId = strItemTypeId;
	}

	/**
	 * Sets the str item type name.
	 * 
	 * @param strItemTypeName the strItemTypeName to set
	 */
	public void setStrItemTypeName(String strItemTypeName) {
		this.strItemTypeName = strItemTypeName;
	}

	/**
	 * Sets the str short name.
	 * 
	 * @param strShortName the strShortName to set
	 */
	public void setStrShortName(String strShortName) {
		this.strShortName = strShortName;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
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
	 * when strItemTypeName or strHospitalCode or strStoreTypeId is
	 * blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {

			/*// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemTypeName.equals("0") || strItemTypeName.equals("")) {
				throw new Exception("strItemTypeName can not be blank");
			}
			if (strItemCatNo.equals("0") || strItemCatNo.equals("")) {
				throw new Exception("strStoreTypeId can not be blank");
			}*/

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.itemtype.0");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strItemCatNo);
			dao.setQryValue(nQueryIndex, 4, strItemTypeName);
			dao.setQryValue(nQueryIndex, 5, strItemCatNo);
			dao.setQryValue(nQueryIndex, 6, strShortName);
			dao.setQryValue(nQueryIndex, 7, strRemarks);
			dao.setQryValue(nQueryIndex, 8, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 9, strSeatId);
			dao.setQryValue(nQueryIndex, 10, strIsValid);

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
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strItemTypeName or strHospitalCode OR strItemTypeId is
	 * blank
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {

			/*// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strItemTypeName.equals("0") || strItemTypeName.equals("")) {
				throw new Exception("strItemTypeName can not be blank");
			}
			if (strItemTypeId.equals("0") || strItemTypeId.equals("")) {
				throw new Exception("strItemTypeId can not be blank");
			}*/

			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1, "update.ItemType.1");
			nQueryIndex = dao.setQuery(strQuery);

			//dao.setQryValue(nQueryIndex, 1, strItemTypeName);
			//dao.setQryValue(nQueryIndex, 2, strShortName);
			//dao.setQryValue(nQueryIndex, 3, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			//dao.setQryValue(nQueryIndex, 5, strRemarks);
			//dao.setQryValue(nQueryIndex, 6, strIsValid);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strItemTypeId);
			dao.setQryValue(nQueryIndex, 4, strSlNo);
			
			dao.execute(nQueryIndex, 0);

			strQuery = mms.qryHandler_mms.getQuery(1, "update.ItemType.2");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHospitalCode);
			dao.setQryValue(nQueryIndex, 2, strItemTypeId);
			dao.setQryValue(nQueryIndex, 3, strItemTypeName);
			dao.setQryValue(nQueryIndex, 4, strItemCatNo);
			dao.setQryValue(nQueryIndex, 5, strShortName);
			dao.setQryValue(nQueryIndex, 6, strRemarks);
			dao.setQryValue(nQueryIndex, 7, strEffectiveFrom);
			dao.setQryValue(nQueryIndex, 8, strSeatId);
			dao.setQryValue(nQueryIndex, 9, strIsValid);
			dao.setQryValue(nQueryIndex, 10, strHospitalCode);
			dao.setQryValue(nQueryIndex, 11, strItemTypeId);

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
	 * Reset.
	 */
	public void reset() {

		strHospitalCode = "";
		strItemTypeId = "";
		strItemTypeName = "";
		strShortName = "";
		strItemCatNo = "";
		strRemarks = "";
		strEffectiveFrom = "";
		/*strLastModeSeatId = "";
		strLastModeDate = "";
		strEntryDate = "";*/
		strSeatId = "";
		strIsValid = "1";

	}

}
