package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Billreq_Pkg_Dtl 
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Billreq_Pkg_Dtl
 */

public class BillReqPackageDAO {
	
	private String strRequestNo = "0";
	private String strPackageId = "0";
	private String strGroupId = "0";
	private String strPuk = "0";
	private String strRateUnitId = "0";
	private String strTariffRate = "0";
	private String strRequestQty = "0";
	private String strBillQty = "0";
	private String strStatus = "1";
	private String strSeatId = "0";
	private String strEntryDate = "";
	private String strIsValid = "1";
	private String strQtyUnitId = "0";
	private String strTariffId = "0";
	private String strPackageQty = "1";
	private String strPenaltyAmt = "0";
	private String strCancelQty = "0";
	private String strQtyType = "1";
	private String strHospitalCode = "0";
	
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Billreq_Pkg_Dtl";
	private final String strFileName = "billing.dao.BillReqPackageDAO";

	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;

	/**
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * @return Returns the strProcName.
	 */
	public String getStrProcName() {
		return strProcName;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * @param strRequestNo the strRequestNo to set
	 */
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}

	/**
	 * @param strPackageId the strPackageId to set
	 */
	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * @param strTariffRate the strTariffRate to set
	 */
	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	/**
	 * @param strRequestQty the strRequestQty to set
	 */
	public void setStrRequestQty(String strRequestQty) {
		this.strRequestQty = strRequestQty;
	}

	/**
	 * @param strBillQty the strBillQty to set
	 */
	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strQtyUnitId the strQtyUnitId to set
	 */
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	/**
	 * @param strTariffId the strTariffId to set
	 */
	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	/**
	 * @param strPackageQty the strPackageQty to set
	 */
	public void setStrPackageQty(String strPackageQty) {
		this.strPackageQty = strPackageQty;
	}

	/**
	 * @param strPenaltyAmt the strPenaltyAmt to set
	 */
	public void setStrPenaltyAmt(String strPenaltyAmt) {
		this.strPenaltyAmt = strPenaltyAmt;
	}

	/**
	 * @param strCancelQty the strCancelQty to set
	 */
	public void setStrCancelQty(String strCancelQty) {
		this.strCancelQty = strCancelQty;
	}

	/**
	 * @param strQtyType the strQtyType to set
	 */
	public void setStrQtyType(String strQtyType) {
		this.strQtyType = strQtyType;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when Request No. or Package Id  or Tariff Id is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strRequestNo.equals("0") || strRequestNo.equals("")) {
				throw new Exception("Request No. can not be blank");
			}
			if (strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}

			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1");

			dao.setProcInValue(nInsertedIndex, "hblnum_req_no", strRequestNo);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_package_id",	strPackageId);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_group_id",   strGroupId);
			
			dao.setProcInValue(nInsertedIndex, "hrgnum_puk",strPuk);
			
			dao.setProcInValue(nInsertedIndex, "gnum_rate_unit_id",	strRateUnitId);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_rate", strTariffRate);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_req_qty",strRequestQty);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_bill_qty", strBillQty);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_status",	strStatus);
			
			dao.setProcInValue(nInsertedIndex, "gnum_seatid",strSeatId);
			
			dao.setProcInValue(nInsertedIndex, "gdt_entry_date", strEntryDate);
			
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid);
			
			dao.setProcInValue(nInsertedIndex, "gnum_qty_unit_id",strQtyUnitId);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_id",strTariffId);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_package_qty",strPackageQty);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_penelty_amt",strPenaltyAmt);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_cancel_qty",strCancelQty);
			
			dao.setProcInValue(nInsertedIndex, "hblnum_qty_type",strQtyType);			
			
			dao.setProcInValue(nInsertedIndex, "hosp_code",strHospitalCode);  // New Value
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1);
			// keep in batch
			dao.execute(nInsertedIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Requisition No. is blank or
	 *  when Tariff Id is blank
	 */
	public void update(HisDAO dao) throws Exception 
	{		
		strErr = "";
	
		try 
		{
			if(strRequestNo.equals("0") || strRequestNo.equals(""))
			{
				throw new Exception("Requisition No. can not be blank");
			}
			if(strPackageId.equals("") || strPackageId.equals("0"))
			{
				throw new Exception("Package Id can not be blank");
			}
			
			if(this.nRowUpdated == 0) 
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			
			dao.setProcInValue(nUpdatedIndex,"modval","2",1);			
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strRequestNo,2);
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_id",	strPackageId,3);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_group_id",strGroupId,4);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,5);
			dao.setProcInValue(nUpdatedIndex, "gnum_rate_unit_id",	strRateUnitId,6);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_rate",strTariffRate,7);
			dao.setProcInValue(nUpdatedIndex,"hblnum_req_qty",strRequestQty,8);
			dao.setProcInValue(nUpdatedIndex,"hblnum_bill_qty",strBillQty,9);
			dao.setProcInValue(nUpdatedIndex,"hblnum_status",strStatus,10);
			dao.setProcInValue(nUpdatedIndex, "gnum_seatid",strSeatId,11);//
			dao.setProcInValue(nUpdatedIndex, "gdt_entry_date", strEntryDate,12);//
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid",strIsValid,13);
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQtyUnitId,14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId,15);
			dao.setProcInValue(nUpdatedIndex, "hblnum_package_qty",strPackageQty,16);	//		
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_amt",strPenaltyAmt,17);
			dao.setProcInValue(nUpdatedIndex, "hblnum_cancel_qty",strCancelQty,18);//
			dao.setProcInValue(nUpdatedIndex,"hblnum_qty_type",strQtyType,19);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,20);			
			dao.setProcOutValue(nUpdatedIndex,"err",1,21);
			
			
			
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
			
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update2() --> " + this.strErr);
		}
		finally 
		{
			this.reset();
		}
	}

	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {

		strRequestNo = "0";
		strPackageId = "0";
		strGroupId = "0";
		strPuk = "0";
		strRateUnitId = "0";
		strTariffRate = "0";
		strRequestQty = "0";
		strBillQty = "0";
		strStatus = "1";
		strSeatId = "0";
		strEntryDate = "";
		strIsValid = "1";
		strQtyUnitId = "0";
		strTariffId = "0";
		strPackageQty = "1";
		strPenaltyAmt = "0";
		strQtyType = "1l";
	 strHospitalCode = "0";

	}

	
	
	
}
