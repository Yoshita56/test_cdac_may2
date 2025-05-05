package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class CondemnationDetailDAO.
 */
public class CondemnationDetailDAO {

	/** The str store id. */
	String strStoreId = "";
	
	/** The str condemn no. */
	String strCondemnNo = "";
	
	/** The str hospital code. */
	String strHospitalCode = "";
	
	/** The str condemn date. */
	String strCondemnDate = "";
	
	/** The str item cat no. */
	String strItemCatNo = "";
	
	/** The str agenda no. */
	String strAgendaNo = "";
	
	/** The str agenda date. */
	String strAgendaDate = "";
	
	/** The str condemn type. */
	String strCondemnType = "";
	
	/** The str committee type id. */
	String strCommitteeTypeId = "";
	
	/** The str committee no. */
	String strCommitteeNo = "";
	
	/** The str tender no. */
	String strTenderNo = "";
	
	/** The str tender date. */
	String strTenderDate = "";
	
	/** The str quotation no. */
	String strQuotationNo = "";
	
	/** The str quotation date. */
	String strQuotationDate = "";
	
	/** The str buyer id. */
	String strBuyerId = "";
	
	/** The str instrument type. */
	String strInstrumentType = "";
	
	/** The str instrument amt. */
	String strInstrumentAmt = "";
	
	/** The str instrument no. */
	String strInstrumentNo = "";
	
	/** The str instrument date. */
	String strInstrumentDate = "";
	
	/** The str bank name. */
	String strBankName = "";
	
	/** The str item netcost. */
	String strItemNetcost = "";
	
	/** The str financial start date. */
	String strFinancialStartDate = "";
	
	/** The str financial end date. */
	String strFinancialEndDate = "";
	
	/** The str remarks. */
	String strRemarks = "";
	
	/** The str entry date. */
	String strEntryDate = "";
	
	/** The str seat id. */
	String strSeatId = "";
	
	/** The str is valid. */
	String strIsValid = "";
	
	/** The str max member rmks slno. */
	String strMaxMemberRmksSlno = "";
	
	/** The str item id. */
	String strItemId = "";
	
	/** The str item brand id. */
	String strItemBrandId = "";
	
	/** The str sanction qty. */
	String strSanctionQty = "";
	
	/** The str sanction unit id. */
	String strSanctionUnitId = "";
	
	/** The str weight. */
	String strWeight = "";
	private String strFileNo="";
	private String strPageNo="";
	private String strFileName="";
	
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
	 * This function is used to insert data in condemnation dtl table.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insertItemParameterDtls(HisDAO dao) throws Exception {

		String strMode = "1";
		String proc_name1 = "{call pkg_mms_dml.dml_condemnation_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		try {

			if (strCondemnNo.equals("0") || strCondemnNo.equals("")) {
				throw new Exception("Condemn No can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("Hospital Code can not be blank");
			}
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", strMode); // 1
			dao.setProcInValue(procIndex1, "strId", strStoreId); // 2
			dao.setProcInValue(procIndex1, "strCondemnNo", strCondemnNo); // 3
			dao.setProcInValue(procIndex1, "hosp_code", strHospitalCode); // 4
			dao.setProcInValue(procIndex1, "strItemCatNo", strItemCatNo); // 5
			dao.setProcInValue(procIndex1, "strAgendaNo", strAgendaNo); // 6
			dao.setProcInValue(procIndex1, "strAgendaDate", strAgendaDate); // 7
			dao.setProcInValue(procIndex1, "strCondemnType", strCondemnType); // 8
			dao.setProcInValue(procIndex1, "strCommitteeTypeId",
					strCommitteeTypeId); // 9
			dao.setProcInValue(procIndex1, "strCommitteeNo", strCommitteeNo); // 10
			dao.setProcInValue(procIndex1, "strTenderNo", strTenderNo); // 11
			dao.setProcInValue(procIndex1, "strTenderDate", strTenderDate); // 12
			dao.setProcInValue(procIndex1, "strQuotationNo", strQuotationNo); // 13
			dao
					.setProcInValue(procIndex1, "strQuotationDate",
							strQuotationDate); // 14
			dao.setProcInValue(procIndex1, "strBuyerId", strBuyerId); // 15
			dao.setProcInValue(procIndex1, "strInstrumentType",
					strInstrumentType); // 16
			dao
					.setProcInValue(procIndex1, "strInstrumentAmt",
							strInstrumentAmt); // 17
			dao.setProcInValue(procIndex1, "strInstrumentNo", strInstrumentNo); // 18
			dao.setProcInValue(procIndex1, "strInstrumentDate",
					strInstrumentDate); // 19
			dao.setProcInValue(procIndex1, "strBankName", strBankName); // 20
			dao.setProcInValue(procIndex1, "strItemNetcost", strItemNetcost); // 21
			dao.setProcInValue(procIndex1, "fin_start_date",
					strFinancialStartDate); // 22
			dao.setProcInValue(procIndex1, "fin_end_date", strFinancialEndDate); // 23
			dao.setProcInValue(procIndex1, "strRemarks", strRemarks); // 24
			dao.setProcInValue(procIndex1, "maxRemarksSlNo",
					strMaxMemberRmksSlno); // 25
			dao.setProcInValue(procIndex1, "strSeatid", strSeatId); // 26
			dao.setProcInValue(procIndex1, "strSanctionQty", strSanctionQty); // 27
			dao.setProcInValue(procIndex1, "strSanctionQtyUnitId",
					strSanctionUnitId); // 28
			dao.setProcInValue(procIndex1, "itemId", strItemId); // 29
			dao.setProcInValue(procIndex1, "itemBrandId", strItemBrandId); // 30
			dao.setProcInValue(procIndex1, "strWeight", strWeight); // 31
			dao.setProcInValue(procIndex1, "strFileNo", strFileNo);
			dao.setProcInValue(procIndex1, "strPageNo", strPageNo);
			dao.setProcInValue(procIndex1, "strFileName", strFileName);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(procIndex1, "strCondemnDate", "");
			dao.setProcInValue(procIndex1, "entry_date", "");
			dao.setProcInValue(procIndex1, "strIsValid", "1");
			/* Setting Default Value End */
			
			dao.setProcOutValue(procIndex1, "err", 1); // 32
			dao.execute(procIndex1, 2);
			nRowInserted++;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			reset();
		}
	}
	public   void update(HisDAO dao) throws Exception {
		
		String proc_name1 = "{call pkg_mms_dml.DML_CONDEMNATION_ITEM_DTL(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int procIndex1 = 0;
		try {

			if (strCondemnNo.equals("0") || strCondemnNo.equals("")) {
				throw new Exception("Condemn No can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("Hospital Code can not be blank");
			}
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "1"); // 1
			dao.setProcInValue(procIndex1, "strId", strStoreId); // 2
			dao.setProcInValue(procIndex1, "strCondemnNo", strCondemnNo); // 3
			dao.setProcInValue(procIndex1, "hosp_code", strHospitalCode); // 4
			
			dao.setProcInValue(procIndex1, "strAgendaNo", strAgendaNo); // 6
			
			
			//dao.setProcInValue(procIndex1, "strCommitteeNo", strCommitteeNo); // 10
			
			dao.setProcInValue(procIndex1, "strItemCatNo", strItemCatNo); // 26
			
			dao.setProcInValue(procIndex1, "strSeatid", strSeatId); // 26
			dao.setProcInValue(procIndex1, "strSanctionQty", strSanctionQty); // 27
			dao.setProcInValue(procIndex1, "strSanctionQtyUnitId",
					strSanctionUnitId); // 28
			dao.setProcInValue(procIndex1, "itemId", strItemId); // 29
			dao.setProcInValue(procIndex1, "itemBrandId", strItemBrandId); // 30
		
			dao.setProcOutValue(procIndex1, "err", 1); // 32
			dao.execute(procIndex1, 2);
		}catch(Exception e){
			throw e;
		} finally {

			reset();
		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strStoreId = "";
		strCondemnNo = "";
		strHospitalCode = "";
		strCondemnDate = "";
		strItemCatNo = "";
		strAgendaNo = "";
		strAgendaDate = "";
		strCondemnType = "";
		strCommitteeTypeId = "";
		strCommitteeNo = "";
		strTenderNo = "";
		strTenderDate = "";
		strQuotationNo = "";
		strQuotationDate = "";
		strBuyerId = "";
		strInstrumentType = "";
		strInstrumentAmt = "";
		strInstrumentNo = "";
		strInstrumentDate = "";
		strBankName = "";
		strItemNetcost = "";
		strFinancialStartDate = "";
		strFinancialEndDate = "";
		strRemarks = "";
		strEntryDate = "";
		strSeatId = "";
		strIsValid = "";
		strMaxMemberRmksSlno = "";
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
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str condemn no.
	 * 
	 * @param strCondemnNo the new str condemn no
	 */
	public void setStrCondemnNo(String strCondemnNo) {
		this.strCondemnNo = strCondemnNo;
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
	 * Sets the str condemn date.
	 * 
	 * @param strCondemnDate the new str condemn date
	 */
	public void setStrCondemnDate(String strCondemnDate) {
		this.strCondemnDate = strCondemnDate;
	}

	/**
	 * Sets the str item cat no.
	 * 
	 * @param strItemCatNo the new str item cat no
	 */
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}

	/**
	 * Sets the str agenda no.
	 * 
	 * @param strAgendaNo the new str agenda no
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	/**
	 * Sets the str agenda date.
	 * 
	 * @param strAgendaDate the new str agenda date
	 */
	public void setStrAgendaDate(String strAgendaDate) {
		this.strAgendaDate = strAgendaDate;
	}

	/**
	 * Sets the str condemn type.
	 * 
	 * @param strCondemnType the new str condemn type
	 */
	public void setStrCondemnType(String strCondemnType) {
		this.strCondemnType = strCondemnType;
	}

	/**
	 * Sets the str committee type id.
	 * 
	 * @param strCommitteeTypeId the new str committee type id
	 */
	public void setStrCommitteeTypeId(String strCommitteeTypeId) {
		this.strCommitteeTypeId = strCommitteeTypeId;
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
	 * Sets the str tender no.
	 * 
	 * @param strTenderNo the new str tender no
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	/**
	 * Sets the str tender date.
	 * 
	 * @param strTenderDate the new str tender date
	 */
	public void setStrTenderDate(String strTenderDate) {
		this.strTenderDate = strTenderDate;
	}

	/**
	 * Sets the str quotation no.
	 * 
	 * @param strQuotationNo the new str quotation no
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

	/**
	 * Sets the str quotation date.
	 * 
	 * @param strQuotationDate the new str quotation date
	 */
	public void setStrQuotationDate(String strQuotationDate) {
		this.strQuotationDate = strQuotationDate;
	}

	/**
	 * Sets the str buyer id.
	 * 
	 * @param strBuyerId the new str buyer id
	 */
	public void setStrBuyerId(String strBuyerId) {
		this.strBuyerId = strBuyerId;
	}

	/**
	 * Sets the str instrument type.
	 * 
	 * @param strInstrumentType the new str instrument type
	 */
	public void setStrInstrumentType(String strInstrumentType) {
		this.strInstrumentType = strInstrumentType;
	}

	/**
	 * Sets the str instrument amt.
	 * 
	 * @param strInstrumentAmt the new str instrument amt
	 */
	public void setStrInstrumentAmt(String strInstrumentAmt) {
		this.strInstrumentAmt = strInstrumentAmt;
	}

	/**
	 * Sets the str instrument no.
	 * 
	 * @param strInstrumentNo the new str instrument no
	 */
	public void setStrInstrumentNo(String strInstrumentNo) {
		this.strInstrumentNo = strInstrumentNo;
	}

	/**
	 * Sets the str instrument date.
	 * 
	 * @param strInstrumentDate the new str instrument date
	 */
	public void setStrInstrumentDate(String strInstrumentDate) {
		this.strInstrumentDate = strInstrumentDate;
	}

	/**
	 * Sets the str bank name.
	 * 
	 * @param strBankName the new str bank name
	 */
	public void setStrBankName(String strBankName) {
		this.strBankName = strBankName;
	}

	/**
	 * Sets the str item netcost.
	 * 
	 * @param strItemNetcost the new str item netcost
	 */
	public void setStrItemNetcost(String strItemNetcost) {
		this.strItemNetcost = strItemNetcost;
	}

	/**
	 * Sets the str financial start date.
	 * 
	 * @param strFinancialStartDate the new str financial start date
	 */
	public void setStrFinancialStartDate(String strFinancialStartDate) {
		this.strFinancialStartDate = strFinancialStartDate;
	}

	/**
	 * Sets the str financial end date.
	 * 
	 * @param strFinancialEndDate the new str financial end date
	 */
	public void setStrFinancialEndDate(String strFinancialEndDate) {
		this.strFinancialEndDate = strFinancialEndDate;
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
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
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
	 * Sets the str max member rmks slno.
	 * 
	 * @param strMaxMemberRmksSlno the new str max member rmks slno
	 */
	public void setStrMaxMemberRmksSlno(String strMaxMemberRmksSlno) {
		this.strMaxMemberRmksSlno = strMaxMemberRmksSlno;
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
	 * Sets the str sanction qty.
	 * 
	 * @param strSanctionQty the new str sanction qty
	 */
	public void setStrSanctionQty(String strSanctionQty) {
		this.strSanctionQty = strSanctionQty;
	}

	/**
	 * Sets the str sanction unit id.
	 * 
	 * @param strSanctionUnitId the new str sanction unit id
	 */
	public void setStrSanctionUnitId(String strSanctionUnitId) {
		this.strSanctionUnitId = strSanctionUnitId;
	}

	/**
	 * Sets the str weight.
	 * 
	 * @param strWeight the new str weight
	 */
	public void setStrWeight(String strWeight) {
		this.strWeight = strWeight;
	}
	public void setStrFileNo(String strFileNo) {
		this.strFileNo = strFileNo;
	}
	public void setStrPageNo(String strPageNo) {
		this.strPageNo = strPageNo;
	}
	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

}
