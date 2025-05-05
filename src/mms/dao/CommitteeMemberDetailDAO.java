package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailDAO.
 */
public class CommitteeMemberDetailDAO {
	
	/** The str proc name. */
//	private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.CommitteeMemberDetailDAO";

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
	
	/** The st dummy eff frm. */
	private String stDummyEffFrm = "";

	/** ************Variable Start******************. */
	private String strHstCommettieNo = "";
	
	/** The str hst constute date. */
	private String strHstConstuteDate = "";
	
	/** The str commettie type id. */
	private String strCommettieTypeId = "";
	
	/** The str constitute by. */
	private String strConstituteBy = "";
	
	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str effective to. */
	private String strEffectiveTo = "";
	
	/** ************Variable Member Dtl******************. */
	private String strHstCommettieSlNo = "";
	
	/** The str hgstr emp code. */
	private String strHgstrEmpCode = "";
	
	/** The str hstr member name. */
	private String strHstrMemberName = "";
	
	/** The str hstn level. */
	private String strHstnLevel = "";
	
	/** The str hstr phone. */
	private String strHstrPhone = "";
	
	/** The str hstr add. */
	private String strHstrAdd = "";
	
	/** The str hstr email. */
	private String strHstrEmail = "";
	
	/** The str gnum user id. */
	private String strGnumUserId = "";
	
	/** ************Variable End******************. */
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
	
	private String strCategCode="10";
	
	private String strChairPersonFlg;

	/**
	 * Gets the str hst commettie sl no.
	 * 
	 * @return the str hst commettie sl no
	 */
	public String getStrHstCommettieSlNo() {
		return strHstCommettieSlNo;
	}

	/**
	 * Sets the str hst commettie sl no.
	 * 
	 * @param strHstCommettieSlNo the new str hst commettie sl no
	 */
	public void setStrHstCommettieSlNo(String strHstCommettieSlNo) {
		this.strHstCommettieSlNo = strHstCommettieSlNo;
	}

	/**
	 * Gets the str hgstr emp code.
	 * 
	 * @return the str hgstr emp code
	 */
	public String getStrHgstrEmpCode() {
		return strHgstrEmpCode;
	}

	/**
	 * Sets the str hgstr emp code.
	 * 
	 * @param strHgstrEmpCode the new str hgstr emp code
	 */
	public void setStrHgstrEmpCode(String strHgstrEmpCode) {
		this.strHgstrEmpCode = strHgstrEmpCode;
	}

	/**
	 * Gets the str hstr member name.
	 * 
	 * @return the str hstr member name
	 */
	public String getStrHstrMemberName() {
		return strHstrMemberName;
	}

	/**
	 * Sets the str hstr member name.
	 * 
	 * @param strHstrMemberName the new str hstr member name
	 */
	public void setStrHstrMemberName(String strHstrMemberName) {
		this.strHstrMemberName = strHstrMemberName;
	}

	/**
	 * Gets the str hstn level.
	 * 
	 * @return the str hstn level
	 */
	public String getStrHstnLevel() {
		return strHstnLevel;
	}

	/**
	 * Sets the str hstn level.
	 * 
	 * @param strHstnLevel the new str hstn level
	 */
	public void setStrHstnLevel(String strHstnLevel) {
		this.strHstnLevel = strHstnLevel;
	}

	/**
	 * Gets the str hstr phone.
	 * 
	 * @return the str hstr phone
	 */
	public String getStrHstrPhone() {
		return strHstrPhone;
	}

	/**
	 * Sets the str hstr phone.
	 * 
	 * @param strHstrPhone the new str hstr phone
	 */
	public void setStrHstrPhone(String strHstrPhone) {
		this.strHstrPhone = strHstrPhone;
	}

	/**
	 * Gets the str hstr add.
	 * 
	 * @return the str hstr add
	 */
	public String getStrHstrAdd() {
		return strHstrAdd;
	}

	/**
	 * Sets the str hstr add.
	 * 
	 * @param strHstrAdd the new str hstr add
	 */
	public void setStrHstrAdd(String strHstrAdd) {
		this.strHstrAdd = strHstrAdd;
	}

	/**
	 * Gets the str hstr email.
	 * 
	 * @return the str hstr email
	 */
	public String getStrHstrEmail() {
		return strHstrEmail;
	}

	/**
	 * Sets the str hstr email.
	 * 
	 * @param strHstrEmail the new str hstr email
	 */
	public void setStrHstrEmail(String strHstrEmail) {
		this.strHstrEmail = strHstrEmail;
	}

	/**
	 * Gets the str gnum user id.
	 * 
	 * @return the str gnum user id
	 */
	public String getStrGnumUserId() {
		return strGnumUserId;
	}

	/**
	 * Sets the str gnum user id.
	 * 
	 * @param strGnumUserId the new str gnum user id
	 */
	public void setStrGnumUserId(String strGnumUserId) {
		this.strGnumUserId = strGnumUserId;
	}

	/**
	 * Gets the str effective to.
	 * 
	 * @return the str effective to
	 */
	public String getStrEffectiveTo() {
		return strEffectiveTo;
	}

	/**
	 * Sets the str effective to.
	 * 
	 * @param strEffectiveTo the new str effective to
	 */
	public void setStrEffectiveTo(String strEffectiveTo) {
		this.strEffectiveTo = strEffectiveTo;
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
	 * Gets the str hst commettie no.
	 * 
	 * @return the str hst commettie no
	 */
	public String getStrHstCommettieNo() {
		return strHstCommettieNo;
	}

	/**
	 * Sets the str hst commettie no.
	 * 
	 * @param strHstCommettieNo the new str hst commettie no
	 */
	public void setStrHstCommettieNo(String strHstCommettieNo) {
		this.strHstCommettieNo = strHstCommettieNo;
	}

	/**
	 * Gets the str hst constute date.
	 * 
	 * @return the str hst constute date
	 */
	public String getStrHstConstuteDate() {
		return strHstConstuteDate;
	}

	/**
	 * Sets the str hst constute date.
	 * 
	 * @param strHstConstuteDate the new str hst constute date
	 */
	public void setStrHstConstuteDate(String strHstConstuteDate) {
		this.strHstConstuteDate = strHstConstuteDate;
	}

	/**
	 * Gets the str commettie type id.
	 * 
	 * @return the str commettie type id
	 */
	public String getStrCommettieTypeId() {
		return strCommettieTypeId;
	}

	/**
	 * Sets the str commettie type id.
	 * 
	 * @param strCommettieTypeId the new str commettie type id
	 */
	public void setStrCommettieTypeId(String strCommettieTypeId) {
		this.strCommettieTypeId = strCommettieTypeId;
	}

	/**
	 * Gets the str constitute by.
	 * 
	 * @return the str constitute by
	 */
	public String getStrConstituteBy() {
		return strConstituteBy;
	}

	/**
	 * Sets the str constitute by.
	 * 
	 * @param strConstituteBy the new str constitute by
	 */
	public void setStrConstituteBy(String strConstituteBy) {
		this.strConstituteBy = strConstituteBy;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void insert1(HisDAO dao) throws Exception 
	{
		strErr = "";

		try 
		{
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,"select.commetteMemberDtl.insert.1");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, strHstCommettieNo);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strHstCommettieSlNo);
			dao.setQryValue(nQueryIndex, 4, strHstrMemberName);
			dao.setQryValue(nQueryIndex, 5, strHstrPhone);
			dao.setQryValue(nQueryIndex, 6, strHstrEmail);
			dao.setQryValue(nQueryIndex, 7, strHgstrEmpCode);
			dao.setQryValue(nQueryIndex, 8, strIsValid);			
			dao.setQryValue(nQueryIndex, 9, strChairPersonFlg);
			dao.setQryValue(nQueryIndex, 10, strGnumUserId);
			
			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName	+ ".insert1(HSTT_COMMITTEE_MEMBER_DTL) --> " + this.strErr);
		} 
		finally 
		{
		}
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
	public void update2(HisDAO dao) throws Exception 
	{
		strErr = "";

		try 
		{
			int nQueryIndex = 0;
			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,"update.commetteMemberDtl.2");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strHstCommettieNo);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.execute(nQueryIndex, 0);
			
			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName+ ".update2(HSTT_COMMITTEE_MEMBER_DTL) --> " + this.strErr);
		} 
		finally 
		{
		}
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
	public void update1(HisDAO dao) throws Exception 
	{
		strErr = "";
		
		try 
		{
			int nQueryIndex = 0;
			String strQuery = null;
			strQuery = mms.qryHandler_mms.getQuery(1,"update.commetteMemberDtl.1");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strLastModifiedSeatId);
			dao.setQryValue(nQueryIndex, 2, strHstCommettieNo);
			dao.setQryValue(nQueryIndex, 3, strHospitalCode);
			dao.setQryValue(nQueryIndex, 4, strCategCode);

			dao.execute(nQueryIndex, 0);
			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName+ ".update1(HSTT_COMMITTEE_DTL) --> " + this.strErr);
		} 
		finally 
		{
		}
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
	public void update3(HisDAO dao) throws Exception {
		strErr = "";

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"delete.commetteMemberDtl.1");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHstCommettieNo);

			dao.setQryValue(nQueryIndex, 2, strHospitalCode);

			dao.setQryValue(nQueryIndex, 3, strHstCommettieSlNo);

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName+ ".update3(HSTT_COMMITTEE_DTL) --> " + this.strErr);

		} finally {

			// this.reset();

		}
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
	public void insert(HisDAO dao) throws Exception 
	{
		strErr = "";

		try 
		{
			int nQueryIndex = 0;
			String strQuery = null;
			
			strQuery = mms.qryHandler_mms.getQuery(1,"select.commetteDtl.insert.0");

			nQueryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nQueryIndex, 1, strHstCommettieNo);
			dao.setQryValue(nQueryIndex, 2, strHospitalCode);
			dao.setQryValue(nQueryIndex, 3, strCommettieTypeId);
			//dao.setQryValue(nQueryIndex, 4, strEntryDate);
			dao.setQryValue(nQueryIndex, 4, strSeatId);
			dao.setQryValue(nQueryIndex, 5, strIsValid);			
			dao.setQryValue(nQueryIndex, 6, strCategCode);			

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;
		} 
		catch (Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName	+ ".insert(HSTT_COMMITTEE_DTL) --> " + this.strErr);
		} 
		finally 
		{
		}
	}

	public void reset() 
	{

		strHstCommettieNo = "";
		strHstConstuteDate = "";
		strCommettieTypeId = "";
		strConstituteBy = "";
		strStoreTypeId = "";
		strRemarks = "";
		strEffectiveFrom = "";
		strEffectiveTo = "";
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
	 * Gets the st dummy eff frm.
	 * 
	 * @return the st dummy eff frm
	 */
	public String getStDummyEffFrm() {
		return stDummyEffFrm;
	}

	/**
	 * Sets the st dummy eff frm.
	 * 
	 * @param stDummyEffFrm the new st dummy eff frm
	 */
	public void setStDummyEffFrm(String stDummyEffFrm) {
		this.stDummyEffFrm = stDummyEffFrm;
	}

	/**
	 * @param strCategCode the strCategCode to set
	 */
	public void setStrCategCode(String strCategCode) {
		this.strCategCode = strCategCode;
	}

	public String getStrChairPersonFlg() {
		return strChairPersonFlg;
	}

	public void setStrChairPersonFlg(String strChairPersonFlg) {
		this.strChairPersonFlg = strChairPersonFlg;
	}

}
