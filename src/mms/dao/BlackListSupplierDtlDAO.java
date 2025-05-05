package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class BlackListSupplierDtlDAO.
 */
public class BlackListSupplierDtlDAO {

	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.BlackListSupplierDtlDAO";

	/** The str supplier id. */
	private String strSupplierId = "0";
	
	/** The str effective from. */
//	private String strEffectiveFrom = "";

	/** The str remarks. */
	private String strRemarks = "";

	/** The str seat id. */
	private String strSeatId = "";

	/** The str last modified seat id. */
	//private String strLastModifiedSeatId = "";

	/** The str is valid. */
	private String strIsValid = "1";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str issue type. */
	//private String strIssueType = "";

	/** The str store type id. */
	//private String strStoreTypeId = "0";
	
	/** The str supp slno. */
	//private String strSuppSlno = "";
	
	/** The str action date. */
	private String strActionDate = "";
	
	/** The str committee no. */
	private String strCommitteeNo = "";
	
	/** The str is black list flag. */
	private String strIsBlackListFlag = "";

	/** The str effective to. */
	//private String strEffectiveTO = "";
	
	/** The str last mod seat id. */
	//private String strLastModSeatId = "";
	
	private String    strCotactPersonForEsc=null;

    private String    strContactPersonDesgForEsc=null;

    private String   strCotactEmailIdForEsc=null;

    private String   strCotactNoForEsc=null;

    private String   strCotactFaxForEsc=null;
    
    private String strEscLevel;
	

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
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
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
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
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
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the new str supplier id
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	 
	/**
	 * Sets the str action date.
	 * 
	 * @param strActionDate the new str action date
	 */
	public void setStrActionDate(String strActionDate) {
		this.strActionDate = strActionDate;
	}

	/**
	 * Sets the str committee no.
	 * 
	 * @param strCommitteeNo the new str committee no
	 */
	public void setStrCommitteeNo(String strCommitteeNo) {
		this.strCommitteeNo = strCommitteeNo;
	}

	/**
	 * Sets the str is black list flag.
	 * 
	 * @param strIsBlackListFlag the new str is black list flag
	 */
	public void setStrIsBlackListFlag(String strIsBlackListFlag) {
		this.strIsBlackListFlag = strIsBlackListFlag;
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

	/**
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when if (strSeatId.equals("0") || strSeatId.equals("")) {
	 * throw new Exception("strSeatId can not be blank"); } or
	 * strHospitalCode or strSupplierId is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		String strQuery = "";
		int nQueryIndex = 0;
		strErr = "";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}

			strQuery = mms.qryHandler_mms.getQuery(1, "insert.supplier.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSupplierId);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSupplierId);
			dao.setQryValue(nQueryIndex, 5, strActionDate);
			dao.setQryValue(nQueryIndex, 6, strCommitteeNo);
			dao.setQryValue(nQueryIndex, 7, strIsBlackListFlag);
			dao.setQryValue(nQueryIndex, 8, strRemarks);
			dao.setQryValue(nQueryIndex, 9, strSeatId);
			dao.setQryValue(nQueryIndex, 10, strIsValid);
			dao.execute(nQueryIndex, 0);
			this.nRowUpdated++;
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
	 * when if (strSeatId.equals("0") || strSeatId.equals("")) {
	 * throw new Exception("strSeatId can not be blank"); } or
	 * strHospitalCode or strSupplierId is blank
	 */
	public void insertSupplierEsc(HisDAO dao) throws Exception {
		String strQuery = "";
		int nQueryIndex = 0;
		strErr = "";
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}
//(HSTNUM_SUPPLIER_ID,HSTNUM_ESCALANATION_LEVEL,GNUM_HOSPITAL_CODE,HSTNUM_SLNO,  \
//            HSTSTR_NAME,HSTSTR_DESIGNATION,HSTSTR_EMAIL_ID,HSTSTR_PHONE_NO,HSTSTR_FAX_NO,  \
//            GDT_ENTRY_DATE, GNUM_ISVALID)
			//get_esclation_slno(suppid NUMBER,hosp_code NUMBER)
			 
//			//System.out.println("strSupplierId::"+strSupplierId);
//			//System.out.println("strEscLeve::"+strEscLevel);
//			//System.out.println("strHospitalCode::"+strHospitalCode);
//			//System.out.println("strSupplierId::"+strSupplierId);
//			//System.out.println("strEscLeve::"+strEscLevel);
//			//System.out.println("strHospitalCode::"+strHospitalCode);
//			//System.out.println("strCotactPersonForEsc:::"+strCotactPersonForEsc);
//			//System.out.println("strContactPersonDesgForEsc:::"+strContactPersonDesgForEsc);
//			//System.out.println("strCotactEmailIdForEsc:::"+strCotactEmailIdForEsc);
//			//System.out.println("strCotactNoForEsc:::"+strCotactNoForEsc);
//			//System.out.println("strCotactFaxForEsc:::"+strCotactFaxForEsc);
			
			strQuery = mms.qryHandler_mms.getQuery(1, "insert.supplier.11");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSupplierId);
			
			dao.setQryValue(nQueryIndex, 2, strEscLevel);
			
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			
			dao.setQryValue(nQueryIndex, 4, strSupplierId);
									
			dao.setQryValue(nQueryIndex, 5, strHospitalCode);
			
			dao.setQryValue(nQueryIndex, 6, strCotactPersonForEsc);
			
			dao.setQryValue(nQueryIndex, 7, strContactPersonDesgForEsc);
			
			dao.setQryValue(nQueryIndex, 8, strCotactEmailIdForEsc);
			
			dao.setQryValue(nQueryIndex, 9, strCotactNoForEsc);
			
			dao.setQryValue(nQueryIndex, 10, strCotactFaxForEsc);
			
			dao.execute(nQueryIndex, 0);
			this.nRowUpdated++;
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
	 * when strSeatId or strHospitalCode OR strSupplierId is blank
	 */

	public void updateEsc(HisDAO dao) throws Exception {
		strErr = "";
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals(""))
			{
				throw new Exception("strSupplierId can not be blank");
			}

			strQuery = mms.qryHandler_mms.getQuery(1, "update..supplier.89");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			dao.setQryValue(nQueryIndex, 2, strSupplierId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			
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
	 * This method will be used to update the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strSeatId or strHospitalCode OR strSupplierId is blank
	 */

	public void update(HisDAO dao) throws Exception {
		strErr = "";
		String strQuery = "";
		int nQueryIndex = 0;
		try {
			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strSeatId.equals("0") || strSeatId.equals("")) {
				throw new Exception("strSeatId can not be blank");
			}
			if (strSupplierId.equals("0") || strSupplierId.equals("")) {
				throw new Exception("strSupplierId can not be blank");
			}

			strQuery = mms.qryHandler_mms.getQuery(1, "update.blacklist.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strSeatId);
			dao.setQryValue(nQueryIndex, 2, strSupplierId);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strSupplierId);
			dao.setQryValue(nQueryIndex, 5, strHospitalCode);

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

		strSupplierId = "0";

//		strEffectiveFrom = "";
		strRemarks = "";
		strSeatId = "";
	//	strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

	}

	public String getStrCotactPersonForEsc() {
		return strCotactPersonForEsc;
	}

	public void setStrCotactPersonForEsc(String strCotactPersonForEsc) {
		this.strCotactPersonForEsc = strCotactPersonForEsc;
	}

	public String getStrContactPersonDesgForEsc() {
		return strContactPersonDesgForEsc;
	}

	public void setStrContactPersonDesgForEsc(String strContactPersonDesgForEsc) {
		this.strContactPersonDesgForEsc = strContactPersonDesgForEsc;
	}

	public String getStrCotactEmailIdForEsc() {
		return strCotactEmailIdForEsc;
	}

	public void setStrCotactEmailIdForEsc(String strCotactEmailIdForEsc) {
		this.strCotactEmailIdForEsc = strCotactEmailIdForEsc;
	}

	public String getStrCotactNoForEsc() {
		return strCotactNoForEsc;
	}

	public void setStrCotactNoForEsc(String strCotactNoForEsc) {
		this.strCotactNoForEsc = strCotactNoForEsc;
	}

	public String getStrCotactFaxForEsc() {
		return strCotactFaxForEsc;
	}

	public void setStrCotactFaxForEsc(String strCotactFaxForEsc) {
		this.strCotactFaxForEsc = strCotactFaxForEsc;
	}

	public String getStrEscLevel() {
		return strEscLevel;
	}

	public void setStrEscLevel(String strEscLevel) {
		this.strEscLevel = strEscLevel;
	}

}
