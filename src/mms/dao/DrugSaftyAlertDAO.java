package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSaftyAlertDAO.
 */
public class DrugSaftyAlertDAO {
	
	/** The str proc name. */
	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.DrugSaftyAlertDAO";

	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";

	/** The str hstnum item id. */
	private String strHstnumItemId = "";
	
	/** The str hstr cl. */
	private String strHstrCl = "";
	
	/** The str hstr sp. */
	private String strHstrSp = "";
	
	/** The str hstr int. */
	private String strHstrInt = "";
	
	/** The str hstr adr. */
	private String strHstrAdr = "";
	
	/** The str hstr int pot haz. */
	private String strHstrIntPotHaz = "";
	
	/** The str hstr adr pot lt. */
	private String strHstrAdrPotLt = "";
	
	/** The str hstr lab int. */
	private String strHstrLabInt = "";
	
	/** The str hstrint food. */
	private String strHstrintFood = "";

	/** The str lst mod seat id. */
	private String strLstModSeatId = "";
	
	/** The str lst mod date. */
	private String strLstModDate = "";
	
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
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
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
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
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
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
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
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
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
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
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
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return the str proc name
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return the str file name
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.insert.0");

			nQueryIndex = dao.setQuery(strQuery);

			// //System.out.println("strHstnumItemId:::"+strHstnumItemId);
			dao.setQryValue(nQueryIndex, 1, strHstnumItemId);

			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			// //System.out.println("Hosp Code:::"+strHospitalCode);

			dao.setQryValue(nQueryIndex, 3, strHstrCl);
			// //System.out.println("strHstrCl::"+strHstrCl);

			dao.setQryValue(nQueryIndex, 4, strHstrSp);
			// //System.out.println("strHstrSp::"+strHstrSp);

			dao.setQryValue(nQueryIndex, 5, strHstrInt);
			// //System.out.println("strHstrInt::"+strHstrInt);

			dao.setQryValue(nQueryIndex, 6, strHstrAdr);
			// //System.out.println("strHstrAdr::"+strHstrAdr);

			dao.setQryValue(nQueryIndex, 7, strHstrIntPotHaz);
			// //System.out.println("strHstrIntPotHaz::"+strHstrIntPotHaz);

			dao.setQryValue(nQueryIndex, 8, strHstrAdrPotLt);
			// //System.out.println("strHstrAdrPotLt::"+strHstrAdrPotLt);

			dao.setQryValue(nQueryIndex, 9, strHstrLabInt);
			// //System.out.println("strHstrLabInt:::"+strHstrLabInt);

			dao.setQryValue(nQueryIndex, 10, strHstrintFood);
			// //System.out.println("strHstrintFood:::"+strHstrintFood);

			dao.setQryValue(nQueryIndex, 11, strRemarks);
			// //System.out.println("strRemarks::"+strRemarks);
			dao.setQryValue(nQueryIndex, 12, strEffectiveFrom);
			// //System.out.println("strEffectiveFrom:::"+strEffectiveFrom);

		/*	dao.setQryValue(nQueryIndex, 13, strLstModSeatId);
			// //System.out.println("strLstModSeatId::"+strLstModSeatId);

			dao.setQryValue(nQueryIndex, 14, strLstModDate);
			// //System.out.println("strLstModDate:::"+strLstModDate);
*/
			dao.setQryValue(nQueryIndex, 13, strEntryDate);
			// //System.out.println("strEntryDate:::"+strEntryDate);

			dao.setQryValue(nQueryIndex, 14, strSeatId);
			// //System.out.println("strSeatId:::"+strSeatId);

			dao.setQryValue(nQueryIndex, 15, strIsValid);
			// //System.out.println("strIsValid:::"+strIsValid);

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName + ".insert() --> " + this.strErr);

		} finally {

			this.reset();

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
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugSafteyAlertMst.update.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHstrCl);
			// //System.out.println("strHstrCl:(UPDATE):"+strHstrCl);

			dao.setQryValue(nQueryIndex, 2, strHstrSp);
			// //System.out.println("strHstrSp::"+strHstrSp);

			dao.setQryValue(nQueryIndex, 3, strHstrInt);
			// //System.out.println("strHstrInt::"+strHstrInt);

			dao.setQryValue(nQueryIndex, 4, strHstrAdr);
			// //System.out.println("strHstrAdr::"+strHstrAdr);

			dao.setQryValue(nQueryIndex, 5, strHstrIntPotHaz);
			// //System.out.println("strHstrIntPotHaz::"+strHstrIntPotHaz);

			dao.setQryValue(nQueryIndex, 6, strHstrAdrPotLt);
			// // //System.out.println("strHstrAdrPotLt::"+strHstrAdrPotLt);

			dao.setQryValue(nQueryIndex, 7, strHstrLabInt);
			// //System.out.println("strHstrLabInt:::"+strHstrLabInt);

			dao.setQryValue(nQueryIndex, 8, strHstrintFood);
			// //System.out.println("strHstrintFood:::"+strHstrintFood);

			dao.setQryValue(nQueryIndex, 9, strEffectiveFrom);
			// //System.out.println("strEffectiveFrom:::"+strEffectiveFrom);

			// dao.setQryValue(nQueryIndex, 10, strLstModDate );
			// //System.out.println("strLstModDate:::"+strLstModDate);

			dao.setQryValue(nQueryIndex, 10, strLstModSeatId);
			// //System.out.println("strLstModSeatId::"+strLstModSeatId);

			dao.setQryValue(nQueryIndex, 11, strRemarks);
			// //System.out.println("strRemarks::"+strRemarks);

			dao.setQryValue(nQueryIndex, 12, strSeatId);
			// //System.out.println("strSeatId:::"+strSeatId);

			dao.setQryValue(nQueryIndex, 13, strIsValid);
			// //System.out.println("strIsValid:::"+strIsValid);

			// //System.out.println("strHstnumItemId:::"+strHstnumItemId);
			dao.setQryValue(nQueryIndex, 14, strHstnumItemId);

			dao.setQryValue(nQueryIndex, 15, strHospitalCode);
			// //System.out.println("Hosp Code:(UPDATE)::"+strHospitalCode);

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName + ".update() --> " + this.strErr);

		} finally {

			this.reset();

		}

	}

	/**
	 * Reset.
	 */
	public void reset() {
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
	 * Gets the str hstnum item id.
	 * 
	 * @return the str hstnum item id
	 */
	public String getStrHstnumItemId() {
		return strHstnumItemId;
	}

	/**
	 * Sets the str hstnum item id.
	 * 
	 * @param strHstnumItemId the new str hstnum item id
	 */
	public void setStrHstnumItemId(String strHstnumItemId) {
		this.strHstnumItemId = strHstnumItemId;
	}

	/**
	 * Gets the str hstr cl.
	 * 
	 * @return the str hstr cl
	 */
	public String getStrHstrCl() {
		return strHstrCl;
	}

	/**
	 * Sets the str hstr cl.
	 * 
	 * @param strHstrCl the new str hstr cl
	 */
	public void setStrHstrCl(String strHstrCl) {
		this.strHstrCl = strHstrCl;
	}

	/**
	 * Gets the str hstr sp.
	 * 
	 * @return the str hstr sp
	 */
	public String getStrHstrSp() {
		return strHstrSp;
	}

	/**
	 * Sets the str hstr sp.
	 * 
	 * @param strHstrSp the new str hstr sp
	 */
	public void setStrHstrSp(String strHstrSp) {
		this.strHstrSp = strHstrSp;
	}

	/**
	 * Gets the str hstr int.
	 * 
	 * @return the str hstr int
	 */
	public String getStrHstrInt() {
		return strHstrInt;
	}

	/**
	 * Sets the str hstr int.
	 * 
	 * @param strHstrInt the new str hstr int
	 */
	public void setStrHstrInt(String strHstrInt) {
		this.strHstrInt = strHstrInt;
	}

	/**
	 * Gets the str hstr adr.
	 * 
	 * @return the str hstr adr
	 */
	public String getStrHstrAdr() {
		return strHstrAdr;
	}

	/**
	 * Sets the str hstr adr.
	 * 
	 * @param strHstrAdr the new str hstr adr
	 */
	public void setStrHstrAdr(String strHstrAdr) {
		this.strHstrAdr = strHstrAdr;
	}

	/**
	 * Gets the str hstr int pot haz.
	 * 
	 * @return the str hstr int pot haz
	 */
	public String getStrHstrIntPotHaz() {
		return strHstrIntPotHaz;
	}

	/**
	 * Sets the str hstr int pot haz.
	 * 
	 * @param strHstrIntPotHaz the new str hstr int pot haz
	 */
	public void setStrHstrIntPotHaz(String strHstrIntPotHaz) {
		this.strHstrIntPotHaz = strHstrIntPotHaz;
	}

	/**
	 * Gets the str hstr adr pot lt.
	 * 
	 * @return the str hstr adr pot lt
	 */
	public String getStrHstrAdrPotLt() {
		return strHstrAdrPotLt;
	}

	/**
	 * Sets the str hstr adr pot lt.
	 * 
	 * @param strHstrAdrPotLt the new str hstr adr pot lt
	 */
	public void setStrHstrAdrPotLt(String strHstrAdrPotLt) {
		this.strHstrAdrPotLt = strHstrAdrPotLt;
	}

	/**
	 * Gets the str hstr lab int.
	 * 
	 * @return the str hstr lab int
	 */
	public String getStrHstrLabInt() {
		return strHstrLabInt;
	}

	/**
	 * Sets the str hstr lab int.
	 * 
	 * @param strHstrLabInt the new str hstr lab int
	 */
	public void setStrHstrLabInt(String strHstrLabInt) {
		this.strHstrLabInt = strHstrLabInt;
	}

	/**
	 * Gets the str hstrint food.
	 * 
	 * @return the str hstrint food
	 */
	public String getStrHstrintFood() {
		return strHstrintFood;
	}

	/**
	 * Sets the str hstrint food.
	 * 
	 * @param strHstrintFood the new str hstrint food
	 */
	public void setStrHstrintFood(String strHstrintFood) {
		this.strHstrintFood = strHstrintFood;
	}

	/**
	 * Gets the str lst mod seat id.
	 * 
	 * @return the str lst mod seat id
	 */
	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}

	/**
	 * Sets the str lst mod seat id.
	 * 
	 * @param strLstModSeatId the new str lst mod seat id
	 */
	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}

	/**
	 * Gets the str lst mod date.
	 * 
	 * @return the str lst mod date
	 */
	public String getStrLstModDate() {
		return strLstModDate;
	}

	/**
	 * Sets the str lst mod date.
	 * 
	 * @param strLstModDate the new str lst mod date
	 */
	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
	}

}
