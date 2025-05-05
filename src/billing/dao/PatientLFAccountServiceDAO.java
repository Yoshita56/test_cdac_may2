package billing.dao;

import hisglobal.transactionmgnt.HisDAO;


/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 21/Aug/2008
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_PATACCOUNT_SERVICE_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_PATACCOUNT_SERVICE_DTL
*/
public final class PatientLFAccountServiceDAO {
	
	private String strPatAccountNo = "0";
	private String strReqNo = "0";
	private String strChargeTypeId = "0";
	
	private String strTariffId = "0";
	private String strReqDate = "";
	private String strDeptCode = "0";
	
	private String strReqType = "1";
	private String strGroupId = "0";
	private String strRateUnitCode = "0";
	
	private String strBServiceId = "0";
	 private String strIpdChargeTypeId = "0";
	private String strTariffRate = "0";
	
	private String strCatCode = "0";
	private String strBillQty = "1";
	private String strServiceTax = "0";
	
	private String strProcessedQty = "0";
	private String strRemainedQty = "1";
	private String strPuk = "0";
	
	private String strSerTaxAmt = "0";
	private String strRemarks = "";
	private String strServiceId = "0";
	
	private String strTariffActualRate = "0";
	private String strEntryDate = "";
	private String strSeatId = "0";
	
	private String strIsValid = "1";
	private String strDiscountUnit = "0";
	private String strDiscountAmt = "0";
	
	private String strDiscountType = "0";
	private String strGblTariffId = "";
	private String strIsRefundable = "1";
	
	private String strGblReqNo = "";
	private String strQtyUnitId = "0";
	private String strBillFlag = "0";
	
	private String strReceiptNo = "1";
	private String strWardCode = "0";
	private String strStatus = "1";
	private String strAppId = "0";
	private String strIsPackage = "0";
	private String strNetAmt = "0";
	private String strPenelty = "0";
	private String strPeneltyAmt = "0";
	private String strRefReqNo = "0";
	private String strRefRecieptNo = "0";
	private String strHospitalCode = "0";
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	private final String strProcName = "pkg_bill_dml.dml_hblt_pat_lf_account_service";// "pkg_bill_dml.dml_hblt_pataccount_service";
	private final String strFileName = "billing.dao.PatientLFAccountServiceDAO";
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	//credit values..
	private String strCreditBillFlag="0";
	private String strClNo="0";
	private String strClDate="";
	private String strClPath="";
	private String strClientNo="0";
	private String strCreditBillStatus="0";
	private String strClCardNoId="0";
	private String strClCardHolderName="";
	private String strCreditRelationWithStaff="";
	private String strClValidity="";
	public String getStrCreditBillFlag() {
		return strCreditBillFlag;
	}

	public void setStrCreditBillFlag(String strCreditBillFlag) {
		this.strCreditBillFlag = strCreditBillFlag;
	}

	public String getStrClNo() {
		return strClNo;
	}

	public void setStrClNo(String strClNo) {
		this.strClNo = strClNo;
	}

	public String getStrClDate() {
		return strClDate;
	}

	public void setStrClDate(String strClDate) {
		this.strClDate = strClDate;
	}

	public String getStrClPath() {
		return strClPath;
	}

	public void setStrClPath(String strClPath) {
		this.strClPath = strClPath;
	}

	public String getStrClientNo() {
		return strClientNo;
	}

	public void setStrClientNo(String strClientNo) {
		this.strClientNo = strClientNo;
	}

	public String getStrCreditBillStatus() {
		return strCreditBillStatus;
	}

	public void setStrCreditBillStatus(String strCreditBillStatus) {
		this.strCreditBillStatus = strCreditBillStatus;
	}

	public String getStrClCardNoId() {
		return strClCardNoId;
	}

	public void setStrClCardNoId(String strClCardNoId) {
		this.strClCardNoId = strClCardNoId;
	}

	public String getStrClCardHolderName() {
		return strClCardHolderName;
	}

	public void setStrClCardHolderName(String strClCardHolderName) {
		this.strClCardHolderName = strClCardHolderName;
	}

	public String getStrCreditRelationWithStaff() {
		return strCreditRelationWithStaff;
	}

	public void setStrCreditRelationWithStaff(String strCreditRelationWithStaff) {
		this.strCreditRelationWithStaff = strCreditRelationWithStaff;
	}

	public String getStrClValidity() {
		return strClValidity;
	}

	public void setStrClValidity(String strClValidity) {
		this.strClValidity = strClValidity;
	}

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
	 * @param strPatAccountNo the strPatAccountNo to set
	 */
	public void setStrRefReqNo(String strRefReqNo) {
		this.strRefReqNo = strRefReqNo;
	}
	
	/**
	 * @param strPatAccountNo the strPatAccountNo to set
	 */
	public void setStrPatAccountNo(String strPatAccountNo) {
		this.strPatAccountNo = strPatAccountNo;
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
	public void setStrRefRecieptNo(String strRefRecieptNo) {
		this.strRefRecieptNo = strRefRecieptNo;
	}
	

	/**
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}

	/**
	 * @param strChargeTypeId the strChargeTypeId to set
	 */
	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}

	/**
	 * @param strTariffId the strTariffId to set
	 */
	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	/**
	 * @param strReqDate the strReqDate to set
	 */
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}

	/**
	 * @param strDeptCode the strDeptCode to set
	 */
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}

	/**
	 * @param strReqType the strReqType to set
	 */
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strRateUnitCode the strRateUnitCode to set
	 */
	public void setStrRateUnitCode(String strRateUnitCode) {
		this.strRateUnitCode = strRateUnitCode;
	}

	/**
	 * @param strBServiceId the strBServiceId to set
	 */
	public void setStrBServiceId(String strBServiceId) {
		this.strBServiceId = strBServiceId;
	}

	/**
	 * @param strIpdChargeTypeId the strIpdChargeTypeId to set
	 */
	public void setStrIpdChargeTypeId(String strIpdChargeTypeId) {
		this.strIpdChargeTypeId = strIpdChargeTypeId;
	}

	/**
	 * @param strTariffRate the strTariffRate to set
	 */
	public void setStrTariffRate(String strTariffRate) {
		this.strTariffRate = strTariffRate;
	}

	/**
	 * @param strCatCode the strCatCode to set
	 */
	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}

	/**
	 * @param strBillQty the strBillQty to set
	 */
	public void setStrBillQty(String strBillQty) {
		this.strBillQty = strBillQty;
	}

	/**
	 * @param strServiceTax the strServiceTax to set
	 */
	public void setStrServiceTax(String strServiceTax) {
		this.strServiceTax = strServiceTax;
	}

	/**
	 * @param strProcessedQty the strProcessedQty to set
	 */
	public void setStrProcessedQty(String strProcessedQty) {
		this.strProcessedQty = strProcessedQty;
	}

	/**
	 * @param strRemainedQty the strRemainedQty to set
	 */
	public void setStrRemainedQty(String strRemainedQty) {
		this.strRemainedQty = strRemainedQty;
	}

	/**
	 * @param strPuk the strPuk to set
	 */
	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}

	/**
	 * @param strSerTaxAmt the strSerTaxAmt to set
	 */
	public void setStrSerTaxAmt(String strSerTaxAmt) {
		this.strSerTaxAmt = strSerTaxAmt;
	}

	/**
	 * @param strRemarks the strRemarks to set
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * @param strServiceId the strServiceId to set
	 */
	public void setStrServiceId(String strServiceId) {
		this.strServiceId = strServiceId;
	}

	/**
	 * @param strTariffActualRate the strTariffActualRate to set
	 */
	public void setStrTariffActualRate(String strTariffActualRate) {
		this.strTariffActualRate = strTariffActualRate;
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
	 * @param strDiscountUnit the strDiscountUnit to set
	 */
	public void setStrDiscountUnit(String strDiscountUnit) {
		this.strDiscountUnit = strDiscountUnit;
	}

	/**
	 * @param strDiscountAmt the strDiscountAmt to set
	 */
	public void setStrDiscountAmt(String strDiscountAmt) {
		this.strDiscountAmt = strDiscountAmt;
	}

	/**
	 * @param strDiscountType the strDiscountType to set
	 */
	public void setStrDiscountType(String strDiscountType) {
		this.strDiscountType = strDiscountType;
	}

	/**
	 * @param strGblTariffId the strGblTariffId to set
	 */
	public void setStrGblTariffId(String strGblTariffId) {
		this.strGblTariffId = strGblTariffId;
	}

	/**
	 * @param strIsRefundable the strIsRefundable to set
	 */
	public void setStrIsRefundable(String strIsRefundable) {
		this.strIsRefundable = strIsRefundable;
	}

	/**
	 * @param strGblReqNo the strGblReqNo to set
	 */
	public void setStrGblReqNo(String strGblReqNo) {
		this.strGblReqNo = strGblReqNo;
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
	 * @param strReceiptNo the strReceiptNo to set
	 */
	public void setStrReceiptNo(String strReceiptNo) {
		this.strReceiptNo = strReceiptNo;
	}

	/**
	 * @param strWardCode the strWardCode to set
	 */
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}

	/**
	 * @param strStatus the strStatus to set
	 */
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	/**
	 * @param strAppId the strAppId to set
	 */
	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}

	/**
	 * @param strIsPackage the strIsPackage to set
	 */
	public void setStrIsPackage(String strIsPackage) {
		this.strIsPackage = strIsPackage;
	}

	/**
	 * @param strNetAmt the strNetAmt to set
	 */
	public void setStrNetAmt(String strNetAmt) {
		this.strNetAmt = strNetAmt;
	}

	/**
	 * @param strPenelty the strPenelty to set
	 */
	public void setStrPenelty(String strPenelty) {
		this.strPenelty = strPenelty;
	}

	/**
	 * @param strPeneltyAmt the strPeneltyAmt to set
	 */
	public void setStrPeneltyAmt(String strPeneltyAmt) {
		this.strPeneltyAmt = strPeneltyAmt;
	}
	
//	Methods starts from here
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank or
	 * Requisition No. is blank or
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
				throw new Exception("Request No. can not be blank");
			}
			
		/*	
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			*/
			
			
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			//Total 45 Field's
			//set the value
			//Input Value
			
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo,2);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo,3);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId,4);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId,5);
			/*---------------------All Value is Here(45)---------------------------*/
//			System.out.println("strPatAccountNo-->"+strPatAccountNo);
//			System.out.println("strReqNo-->"+strReqNo);
//			System.out.println("strChargeTypeId-->"+strChargeTypeId);
//			System.out.println("strTariffId-->"+strTariffId);
//			System.out.println("strDeptCode->"+strDeptCode);
//			System.out.println("strReqType->"+strReqType);
//			System.out.println("strGroupId->"+strGroupId);
//			System.out.println("strRateUnitCode->"+strRateUnitCode);
//			System.out.println("strBServiceId->"+strBServiceId);
//			System.out.println("strIpdChargeTypeId->"+strIpdChargeTypeId);
//			System.out.println("strTariffRate->"+strTariffRate);
//			System.out.println("strCatCode->"+strCatCode);
//			System.out.println("strBillQtystrBillQty->"+strBillQty);
//			System.out.println("strServiceTax->"+strServiceTax);
//			System.out.println("strProcessedQty->"+strProcessedQty);
//			System.out.println("strRemainedQty->"+strRemainedQty);
			System.out.println("strPuk->>>>>>"+strPuk);
//			System.out.println("strSerTaxAmt->"+strSerTaxAmt);
//			System.out.println("strRemarks->"+strRemarks);
//			System.out.println("strDiscountUnit->"+strDiscountUnit);
//			System.out.println("strDiscountAmt->"+strDiscountAmt);
//			System.out.println("strDiscountType->"+strDiscountType);
//			System.out.println("strIsRefundable->"+strIsRefundable);
//			System.out.println("strQtyUnitId->"+strQtyUnitId);
//			System.out.println("strBillFlag->"+strBillFlag);
//			System.out.println("strReceiptNo->"+strReceiptNo);
//			System.out.println("strWardCode->"+strWardCode);
//			System.out.println("strStatus->"+strStatus);
//			System.out.println("strIsPackage->"+strIsPackage);
//			System.out.println("strNetAmt->"+strNetAmt);
//			System.out.println("strRefReqNo->"+strRefReqNo);
//			System.out.println("strRefRecieptNo->"+strRefRecieptNo);
			/*---------------------------------------------------*/
			dao.setProcInValue(nInsertedIndex,"hbldt_req_date",strReqDate,6);
			dao.setProcInValue(nInsertedIndex,"gnum_dept_code",strDeptCode,7);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_type",strReqType,8);
			dao.setProcInValue(nInsertedIndex,"hblnum_group_id",strGroupId,9);
			dao.setProcInValue(nInsertedIndex,"gnum_rate_unit_code ",strRateUnitCode,10);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId,11);
			dao.setProcInValue(nInsertedIndex,"sblnum_ipd_chargetype_id",strIpdChargeTypeId,12);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_rate",strTariffRate,13);
			dao.setProcInValue(nInsertedIndex,"gnum_patient_cat_code",strCatCode,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_qty",strBillQty,15);
			dao.setProcInValue(nInsertedIndex,"hblnum_service_tax",strServiceTax,16);
			dao.setProcInValue(nInsertedIndex,"hblnum_processed_qty",strProcessedQty,17);
			dao.setProcInValue(nInsertedIndex,"hblnum_remained_qty",strRemainedQty,18);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,19);
			dao.setProcInValue(nInsertedIndex,"hblnum_sertax_amt",strSerTaxAmt,20);
			dao.setProcInValue(nInsertedIndex,"hblstr_remarks",strRemarks,21);
			dao.setProcInValue(nInsertedIndex,"sblnum_service_id",strServiceId,22);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_actual_rate",strTariffActualRate,23);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate,24);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,25);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,26);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_unit",strDiscountUnit,27);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_amt",strDiscountAmt,28);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_type",strDiscountType,29);
			dao.setProcInValue(nInsertedIndex,"gstr_tariff_id",strGblTariffId,30);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_refundable",strIsRefundable,31);
			dao.setProcInValue(nInsertedIndex,"gstr_req_no",strGblReqNo,32);
			dao.setProcInValue(nInsertedIndex,"gnum_qty_unit_id",strQtyUnitId,33);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_flag",strBillFlag,34);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo,35);
			dao.setProcInValue(nInsertedIndex,"hipnum_ward_code",strWardCode,36);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus,37);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId,38);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_package",strIsPackage,39);
			dao.setProcInValue(nInsertedIndex,"hblnum_net_amount",strNetAmt,40);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty",strPenelty,41);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty_amt",strPeneltyAmt,42);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_req_no",strRefReqNo,43);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_reciept_no",strRefRecieptNo,44);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,45);  // New Value
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1,46);
			//credit values..
			dao.setProcInValue(nInsertedIndex,"creditBillFlag",strCreditBillFlag,47); //it is credit billing
			dao.setProcInValue(nInsertedIndex,"clNo",strClNo,48); 
			dao.setProcInValue(nInsertedIndex,"clDate",strClDate,49); 
			dao.setProcInValue(nInsertedIndex,"clPath",strClPath,50); 
			dao.setProcInValue(nInsertedIndex,"clientNo",strClientNo,51); 
			dao.setProcInValue(nInsertedIndex,"creditBillStatus",strCreditBillStatus,52); //credit billing approved
			dao.setProcInValue(nInsertedIndex,"staffCardNoId",strClCardNoId,53); 
			dao.setProcInValue(nInsertedIndex,"staffCardHolderName",strClCardHolderName,54); 
			dao.setProcInValue(nInsertedIndex,"relationWithStaffId",strCreditRelationWithStaff,55); 
			dao.setProcInValue(nInsertedIndex,"cardValidity",strClValidity,56); 
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) 
		{
			//System.out.println("In side PatAct Service-->"+e.getMessage());			 
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert(Mode Val 1) --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	/**
	 *  This method will be used to insert the records for mode value=2
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank or
	 * Requisition No. is blank or
	 * Tariff Id is blank or
	 * Receipt No. is blank
	 */
	public void insert1(HisDAO dao) throws Exception {
		
		strErr = "";
		
		
		try {
				
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Request No. can not be blank");
			}
			
			
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			
			
			
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			
			dao.setProcInValue(nInsertedIndex,"modval","2");
			
	       	dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccountNo);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_no",strReqNo);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_id",strTariffId);
			/*---------------------All Value is Here---------------------------*/
//			System.out.println("strPatAccountNo-->"+strPatAccountNo);
//			System.out.println("strReqNo-->"+strReqNo);
//			System.out.println("strChargeTypeId-->"+strChargeTypeId);
//			System.out.println("strTariffId-->"+strTariffId);
//			System.out.println("strDeptCode->"+strDeptCode);
//			System.out.println("strReqType->"+strReqType);
//			System.out.println("strGroupId->"+strGroupId);
//			System.out.println("strRateUnitCode->"+strRateUnitCode);
//			System.out.println("strBServiceId->"+strBServiceId);
//			System.out.println("strIpdChargeTypeId->"+strIpdChargeTypeId);
//			System.out.println("strTariffRate->"+strTariffRate);
//			System.out.println("strCatCode->"+strCatCode);
//			System.out.println("strBillQtystrBillQty->"+strBillQty);
//			System.out.println("strServiceTax->"+strServiceTax);
//			System.out.println("strProcessedQty->"+strProcessedQty);
//			System.out.println("strRemainedQty->"+strRemainedQty);
//			System.out.println("strPuk->"+strPuk);
//			System.out.println("strSerTaxAmt->"+strSerTaxAmt);
//			System.out.println("strRemarks->"+strRemarks);
//			System.out.println("strDiscountUnit->"+strDiscountUnit);
//			System.out.println("strDiscountAmt->"+strDiscountAmt);
//			System.out.println("strDiscountType->"+strDiscountType);
//			System.out.println("strIsRefundable->"+strIsRefundable);
//			System.out.println("strQtyUnitId->"+strQtyUnitId);
//			System.out.println("strBillFlag->"+strBillFlag);
//			System.out.println("strReceiptNo->"+strReceiptNo);
//			System.out.println("strWardCode->"+strWardCode);
//			System.out.println("strStatus->"+strStatus);
//			System.out.println("strIsPackage->"+strIsPackage);
//			System.out.println("strNetAmt->"+strNetAmt);
//			System.out.println("strRefReqNo->"+strRefReqNo);
//			System.out.println("strRefRecieptNo->"+strRefRecieptNo);
			/*---------------------------------------------------*/
			dao.setProcInValue(nInsertedIndex,"hbldt_req_date",strReqDate);
			dao.setProcInValue(nInsertedIndex,"gnum_dept_code",strDeptCode);
			dao.setProcInValue(nInsertedIndex,"hblnum_req_type",strReqType);
			dao.setProcInValue(nInsertedIndex,"hblnum_group_id",strGroupId);
			dao.setProcInValue(nInsertedIndex,"gnum_rate_unit_code ",strRateUnitCode);
			dao.setProcInValue(nInsertedIndex,"sblnum_bservice_id",strBServiceId);
			dao.setProcInValue(nInsertedIndex,"sblnum_ipd_chargetype_id",strIpdChargeTypeId);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_rate",strTariffRate);
			dao.setProcInValue(nInsertedIndex,"gnum_patient_cat_code",strCatCode);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_qty",strBillQty);
			dao.setProcInValue(nInsertedIndex,"hblnum_service_tax",strServiceTax);
			dao.setProcInValue(nInsertedIndex,"hblnum_processed_qty",strProcessedQty);
			dao.setProcInValue(nInsertedIndex,"hblnum_remained_qty",strRemainedQty);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk);
			dao.setProcInValue(nInsertedIndex,"hblnum_sertax_amt",strSerTaxAmt);
			dao.setProcInValue(nInsertedIndex,"hblstr_remarks",strRemarks);
			dao.setProcInValue(nInsertedIndex,"sblnum_service_id",strServiceId);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_actual_rate",strTariffActualRate);
			
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid);
			
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_unit",strDiscountUnit);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_amt",strDiscountAmt);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_type",strDiscountType);
			dao.setProcInValue(nInsertedIndex,"gstr_tariff_id",strGblTariffId);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_refundable",strIsRefundable);
			dao.setProcInValue(nInsertedIndex,"gstr_req_no",strGblReqNo);
			dao.setProcInValue(nInsertedIndex,"gnum_qty_unit_id",strQtyUnitId);
			dao.setProcInValue(nInsertedIndex,"hblnum_bill_flag",strBillFlag);
			dao.setProcInValue(nInsertedIndex,"hblnum_reciept_no",strReceiptNo);
			dao.setProcInValue(nInsertedIndex,"hipnum_ward_code",strWardCode);
			dao.setProcInValue(nInsertedIndex,"hblnum_status",strStatus);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId);
			dao.setProcInValue(nInsertedIndex,"hblnum_is_package",strIsPackage);
			dao.setProcInValue(nInsertedIndex,"hblnum_net_amount",strNetAmt);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty",strPenelty);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty_amt",strPeneltyAmt);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_req_no",strRefReqNo);
			dao.setProcInValue(nInsertedIndex,"hblnum_ref_reciept_no",strRefRecieptNo);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value
			
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1);
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) 
		{
		//	System.out.println("In side PatAct Service-->"+e.getMessage());			 
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert(Mode Val 1) --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	
	 
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank or
	 * Requisition No. is blank or
	 * Tariff Id is blank or
	 * Receipt No. is blank
	 */
	
	public void update(HisDAO dao) throws Exception 
	{
		strErr = "";
	   try {
				
			//check mandatory information
			if(strPatAccountNo.equals("0") || strPatAccountNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("Request No. can not be blank");
			}
			
			
			if(strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
			
			
			
			if(strReceiptNo.equals("0") || strReceiptNo.equals("")) {
				throw new Exception("Receipt No. can not be blank");
			}
			
			
			if(this.nRowUpdated == 0)
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nUpdatedIndex,"modval","2");
		
	       	dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no",strPatAccountNo);
	    
	       	dao.setProcInValue(nUpdatedIndex,"hblnum_req_no",strReqNo);
	    
			dao.setProcInValue(nUpdatedIndex,"hblnum_reciept_no",strReceiptNo);
		
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_id",strTariffId);
		
			dao.setProcInValue(nUpdatedIndex,"hblnum_remained_qty",strRemainedQty);
			
			dao.setProcInValue(nUpdatedIndex,"gnum_qty_unit_id",strQtyUnitId);
		
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode);  // New Value
			
			//output value
			dao.setProcOutValue(nUpdatedIndex,"err",1);
				
			//keep in batch
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		} 
		catch(Exception e) 
		{
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
		 strChargeTypeId = "0";
		 strTariffId = "0";
		 strReqDate = "";
		 strDeptCode = "0";
		 strReqType = "1";
		 strGroupId = "0";
		 strRateUnitCode = "0";
		 strBServiceId = "0";
		 strIpdChargeTypeId = "0";
		 strTariffRate = "0";
		 strCatCode = "0";
		 strBillQty = "1";
		 strServiceTax = "0";
		 strProcessedQty = "0";
		 strRemainedQty = "0";
		 strPuk = "0";
		 strSerTaxAmt = "0";
		 strRemarks = "";
		 strServiceId = "0";
		 strTariffActualRate = "0";
		 strEntryDate = "";
		 strSeatId = "0";
		 strIsValid = "1";
		 strDiscountUnit = "0";
		 strDiscountAmt = "0";
		 strDiscountType = "0";
		 strGblTariffId = "";
		 strIsRefundable = "1";
		 strGblReqNo = "";
		 strQtyUnitId = "0";
		 strBillFlag = "0";
		 strReceiptNo = "1";
		 strWardCode = "0";
		 strStatus = "1";
		 strAppId = "0";
		 strIsPackage = "0";
		 strNetAmt = "0";
		 strPenelty = "0";
		 strPeneltyAmt = "0";
		 strRefReqNo = "0";
		 strRefRecieptNo = "0";

	}
}	
	
	
	