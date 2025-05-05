package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_PATACCOUNT_PACKAGE_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_PATACCOUNT_PACKAGE_DTL
*/
public final class PatientAccountPackageDAO {
	
	private String strPatAccountNo = "0";
	private String strReqNo = "0";
	private String strPackageId = "0";
	private String strRateUnitId = "0";
	private String strPuk = "0";
	private String strGroupId = "0";
	private String strRemainedQty = "0";
	private String strBillQty = "0";
	private String strTariffActualRate = "0";
	private String strTariffRate = "0";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strIsRefundable = "1";
	private String strStatus = "1";
	private String strQtyUnitId = "0";
	private String strBillFlag = "0";
	private String strProcessedQty = "0";
	private String strReceiptNo = "1";
	private String strReqType = "1";
	private String strWardCode = "0";
	private String strReqDt = "";
	private String strTariffId = "0";
	private String strPackageQty = "1";
	private String strDiscountAmt = "0";
	private String strSerTaxAmt = "0";
	private String strPeneltyAmt = "0";
	private String strHospitalCode = "0";
	private String strRefReqNo = "0";
	private String strRefRecieptNo = "0";
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_Hblt_Pataccount_Package";
	private final String strFileName = "billing.dao.PatientAccountPackageDAO";
	
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
	 * @param strPatAccountNo the strPatAccountNo to set
	 */
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
	}

	/**
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	/**
	 * @param strPackageId the strPackageId to set
	 */
	public void setStrPackageId(String strPackageId) {
		this.strPackageId = strPackageId;
	}

	/**
	 * @param strRateUnitId the strRateUnitId to set
	 */
	public void setStrRateUnitId(String strRateUnitId) {
		this.strRateUnitId = strRateUnitId;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strRemainedQty the strRemainedQty to set
	 */
	public void setStrRemainedQty(String strRemainedQty) {
		this.strRemainedQty = strRemainedQty;
	}

	/**
	 * @param strBillQty the strBillQty to set
	 */
	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}

	/**
	 * @param strTariffActualRate the strTariffActualRate to set
	 */
	public void setStrTariffActualRate(String strTariffActualRate) {
		this.strTariffActualRate = strTariffActualRate;
	}

	/**
	 * @param strActualRate the strActualRate to set
	 */
	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	/**
	 * @param strEntryDate the strEntryDate to set
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * @param strSeatId the strSeatId to set
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * @param strIsRefundable the strIsRefundable to set
	 */
	public void setStrIsRefundable(String strIsRefundable) {
		this.strIsRefundable = strIsRefundable;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strQtyUnitId the strQtyUnitId to set
	 */
	public void setStrQtyUnitId(String strQtyUnitId) {
		this.strQtyUnitId = strQtyUnitId;
	}

	/**
	 * @param strBillFlag the strBillFlag to set
	 */
	public void setStrBillFlag(String strBillFlag) {
		this.strBillFlag = strBillFlag;
	}

	/**
	 * @param strProcessedQty the strProcessedQty to set
	 */
	public void setStrProcessedQty(String strProcessedQty) {
		this.strProcessedQty = strProcessedQty;
	}

	/**
	 * @param strReciptNo the strReciptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strReqType the strReqType to set
	 */
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}

	/**
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	/**
	 * @param strReqDt the strReqDt to set
	 */
	public void setStrReqDt(String strReqDt) {
		this.strReqDt = strReqDt;
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
	 * @param strDiscountAmt the strDiscountAmt to set
	 */
	public void setStrDiscountAmt(String strDiscountAmt) {
		this.strDiscountAmt = strDiscountAmt;
	}

	/**
	 * @param strSerTaxAmt the strSerTaxAmt to set
	 */
	public void setStrSerTaxAmt(String strSerTaxAmt) {
		this.strSerTaxAmt = strSerTaxAmt;
	}

	/**
	 * @param strPeneltyAmt the strPeneltyAmt to set
	 */
	public void setStrPeneltyAmt(String strPeneltyAmt) {
		this.strPeneltyAmt = strPeneltyAmt;
	}
	
	public String getStrEntryDate() {
		return strEntryDate;
	}

	public String getStrReqDt() {
		return strReqDt;
	}
	
	public void setStrRefReqNo(String strRefReqNo) {
		this.strRefReqNo = strRefReqNo;
	}

	public void setStrRefRecieptNo(String strRefRecieptNo) {
		this.strRefRecieptNo = strRefRecieptNo;
	}

	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank  or
	 * Requisition No. is blank or
	 * Package Id is blank or
	 * Tariff Id is blank or
	 * Receipt No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			if(strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
        	dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo,2);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo,3);
			dao.setProcInValue(nInsertedIndex,"hblnum_package_id",strPackageId.trim(),4);
			dao.setProcInValue(nInsertedIndex,"gnum_rate_unit_id",strRateUnitId.trim(),5);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk.trim(),6);
			dao.setProcInValue(nInsertedIndex,"hblnum_group_id",strGroupId.trim(),7);
			dao.setProcInValue(nInsertedIndex,"hblnum_remained_qty",strRemainedQty.trim(),8);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_qty",strBillQty.trim(),9);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_actual_rate",strTariffActualRate.trim(),10);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_rate",strTariffRate.trim(),11);
			
//          System.out.println("strPatAccountNo->"+strPatAccountNo);
//          System.out.println("strReqNo->"+strReqNo);
//          System.out.println("strPackageId->"+strPackageId);
//          System.out.println("strRateUnitId->"+strRateUnitId);
//          System.out.println("strPuk->"+strPuk);
//          System.out.println("strGroupId->"+strGroupId);
//          System.out.println("strRemainedQty->"+strRemainedQty);
//          System.out.println("strBillQty->"+strBillQty);
//          System.out.println("strTariffActualRate->"+strTariffActualRate);
//          System.out.println("strTariffRate->"+strTariffRate);
//			System.out.println("strSeatId->"+strSeatId);
//			System.out.println("strIsValid->"+strIsValid);
//			System.out.println("strIsRefundable->"+strIsRefundable);
//			System.out.println("strStatus->"+strStatus);
//			System.out.println("strQtyUnitId->"+strQtyUnitId);
//			System.out.println("strBillFlag->"+strBillFlag);
//			System.out.println("strProcessedQty->"+strProcessedQty);
//			System.out.println("strReceiptNo->"+strReceiptNo);
//			System.out.println("strReqType->"+strReqType);
//			System.out.println("strWardCode->"+strWardCode);
//			System.out.println("strTariffId->"+strTariffId);
//			System.out.println("strPackageQty->"+strPackageQty);
//			System.out.println("strDiscountAmt->"+strDiscountAmt);
//			System.out.println("strSerTaxAmt->"+strSerTaxAmt);
			
			
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate,12);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId.trim(),13);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid.trim(),14);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_refundable",strIsRefundable.trim(),15);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus.trim(),16);
			dao.setProcInValue(nInsertedIndex,"gnum_qty_unit_id",strQtyUnitId.trim(),17);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_flag",strBillFlag.trim(),18);
			dao.setProcInValue(nInsertedIndex,"hblnum_processed_qty",strProcessedQty.trim(),19);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo.trim(),20);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_type",strReqType.trim(),21);
			dao.setProcInValue(nInsertedIndex,"hipnum_ward_code",strWardCode.trim(),22);
			dao.setProcInValue(nInsertedIndex,"hbldt_req_date",strReqDt,23);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId.trim(),24);
			dao.setProcInValue(nInsertedIndex,"hblnum_package_qty",strPackageQty.trim(),25);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_amt",strDiscountAmt.trim(),26);
			dao.setProcInValue(nInsertedIndex,"hblnum_sertax_amt",strSerTaxAmt.trim(),27);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty_amt",strPeneltyAmt.trim(),28);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_req_no",strRefReqNo,29);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_reciept_no",strRefRecieptNo,30);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,31);  // New Value
			
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1,32);
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank  or
	 * Requisition No. is blank or
	 * Package Id is blank or
	 * Tariff Id is blank or
	 * Receipt No. is blank
	 */
	public void update(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			if(strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			
//            System.out.println("strPatAccountNo->"+strPatAccountNo);
//            System.out.println("strReqNo->"+strReqNo);
//            System.out.println("strPackageId->"+strPackageId);
//            System.out.println("strRateUnitId->"+strRateUnitId);
//            System.out.println("strPuk->"+strPuk);
//            System.out.println("strGroupId->"+strGroupId);
//            System.out.println("strRemainedQty->"+strRemainedQty);
//            System.out.println("strBillQty->"+strBillQty);
//            System.out.println("strTariffActualRate->"+strTariffActualRate);
//            System.out.println("strTariffRate->"+strTariffRate);
			dao.setProcInValue(nInsertedIndex,"modval","2");
	       	dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_remained_qty",strRemainedQty.trim());		
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_package_id",strPackageId.trim());
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value
			
			
			
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1);
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}

	
	public void update1(HisDAO dao) throws Exception 
	{
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Requisition No. can not be blank");
			}
			if(strPackageId.equals("0") || strPackageId.equals("")) {
				throw new Exception("Package Id can not be blank");
			}
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","2");
	       	dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_remained_qty",strRemainedQty.trim());		
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId.trim());
			dao.setProcInValue(nInsertedIndex,"hblnum_package_id",strPackageId.trim());
			dao.setProcInValue(nInsertedIndex,"gnum_qty_unit_id",strQtyUnitId.trim());
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value

			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1);
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	
	
	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {
		
		 strPatAccountNo = "0";
		 strReqNo = "0";
		 strPackageId = "0";
		 strRateUnitId = "0";
		 strPuk = "0";
		 strGroupId = "0";
		 strRemainedQty = "0";
		 strBillQty = "0";
		 strTariffActualRate = "0";
		 strTariffRate = "0";
		 strEntryDate = "";
		 strSeatId = "0";
		 strIsValid = "1";
		 strIsRefundable = "1";
		 strStatus = "1";
		 strQtyUnitId = "0";
		 strBillFlag = "0";
		 strProcessedQty = "0";
		 strReceiptNo = "1";
		 strReqType = "1";
		 strWardCode = "0";
		 strReqDt = "";
		 strTariffId = "0";
		 strPackageQty = "1";
		 strDiscountAmt = "0";
		 strSerTaxAmt = "0";
		 strPeneltyAmt = "0";
		 strHospitalCode ="0";
		 strRefReqNo = "0";
		 strRefRecieptNo = "0";
		
	}

	
}
		
	