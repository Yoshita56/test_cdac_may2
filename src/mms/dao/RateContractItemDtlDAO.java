/**
 * 
 */
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 06/JUNE/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_RATECONTRACT_ITEM_DTL
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 30/Jan/2009
 * 
 * This class will be used to insert/update/delete the records Table Name :
 * HSTT_RATECONTRACT_ITEM_DTL
 */
public class RateContractItemDtlDAO {
	
	
	/** The str proc name. */
	//private final String strProcName = "";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.RateContractItemDtlDAO";

	private String strSlNo = "";
	/** The str rate contract sl no. */
	private String strRateContractSLNo = "1";
	
	/** The str contract type id. */
	private String strContractTypeID = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str tender no. */
	private String strTenderNo = "";
	
	/** The str quotation no. */
	private String strQuotationNo = "";
	
	/** The str supplier id. */
	private String strSupplierId = "";
	
	/** The str contract date. */
	//private String strContractDate = "";
	
	/** The str contract from date. */
	private String strContractFromDate = "";
	
	private String strTenderDate = "";
	private String strQutationDate = "";
	private String strSecurityAmt="";
	private String strContractQty="";
	
	/** The str contract to date. */
	private String strContractToDate = "";
	
	/** The str rate contract status. */
	private String strRateContractStatus = "1";
	
	/** The str financial start yr. */
	private String strFinancialStartYr = "";
	
	/** The str financial end yr. */
	private String strFinancialEndYr = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str cancel remarks. */
	private String strCancelRemarks = "";
	
	/** The str item category no. */
	private String strItemCategoryNo = "1";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
//	private String strIsValid = "1";
	
	/** The str deivery lead time. */
	private String strDeiveryLeadTime = "0";
	
	/** The str deivery lead time unit. */
	private String strDeiveryLeadTimeUnit = "0";

	/** The str item id. */
	private String strItemID = "";
	
	/** The str item brand id. */
	private String strItemBrandID = "";
	
	private String strDeliveryDays = "";
	
	/** The str rate. */
	private String strRate = "0";
	
	/** The str rate unit id. */
	private String strRateUnitID = "";
	private String strTax ="";
	private String strTaxType ="";
	
	/** The str last rate. */
	//private String strLastRate = "";
	
	/** The str last rate unit id. */
//	private String strLastRateUnitID = "";
	
	/** The str group id. */
	//private String strGroupID = "";

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

	
	private String strImportedType="";
	private String strShelfLife="";
	private String strNtDate="";
	private String strLevel="";
	private String strRCChk=null;
	private String strTenderItemNo;
	
	 private String strPackSize;
	    
	    
	    public String getStrPackSize() {
			return strPackSize;
		}

		public void setStrPackSize(String strPackSize) {
			this.strPackSize = strPackSize;
		}
	
	public String getStrTenderItemNo() {
		return strTenderItemNo;
	}

	public void setStrTenderItemNo(String strTenderItemNo) {
		this.strTenderItemNo = strTenderItemNo;
	}

	public String getStrRCChk() {
		return strRCChk;
	}

	public void setStrRCChk(String strRCChk) {
		this.strRCChk = strRCChk;
	}

	public String getStrImportedType() {
		return strImportedType;
	}

	public void setStrImportedType(String strImportedType) {
		this.strImportedType = strImportedType;
	}

	public String getStrShelfLife() {
		return strShelfLife;
	}

	public void setStrShelfLife(String strShelfLife) {
		this.strShelfLife = strShelfLife;
	}

	public String getStrNtDate() {
		return strNtDate;
	}

	public void setStrNtDate(String strNtDate) {
		this.strNtDate = strNtDate;
	}

	public String getStrLevel() {
		return strLevel;
	}

	public void setStrLevel(String strLevel) {
		this.strLevel = strLevel;
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
	 * Sets the str rate contract sl no.
	 * 
	 * @param strRateContractSLNo the strRateContractSLNo to set
	 */
	public void setStrRateContractSLNo(String strRateContractSLNo) {
		this.strRateContractSLNo = strRateContractSLNo;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemID the strItemID to set
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandID the strItemBrandID to set
	 */
	public void setStrItemBrandID(String strItemBrandID) {
		this.strItemBrandID = strItemBrandID;
	}

	/**
	 * Sets the str rate.
	 * 
	 * @param strRate the strRate to set
	 */
	public void setStrRate(String strRate) {
		this.strRate = strRate;
	}

	/**
	 * Sets the str rate unit id.
	 * 
	 * @param strRateUnitID the strRateUnitID to set
	 */
	public void setStrRateUnitID(String strRateUnitID) {
		this.strRateUnitID = strRateUnitID;
	}

	 

	/**
	 * Sets the str supplier id.
	 * 
	 * @param strSupplierId the strSupplierId to set
	 */
	public void setStrSupplierId(String strSupplierId) {
		this.strSupplierId = strSupplierId;
	}

	 

	// Methods starts from here

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if ( strSlNo.equals("")) {
				strSlNo="0";
			}
			
			System.out.println(" ********* RateContractItemDtlDAO. insert *********  ");
			
			System.out.println(" ********* MMS_MST.generate_contract_slno_new *********  ");
		
			String strFuncName = "{? = call MMS_MST.generate_contract_slno_new(?)}"; //6
		    int nFuncIndex = dao.setFunction(strFuncName);		
		  
			dao.setFuncInValue(nFuncIndex, 2,this.strHospitalCode);			
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String  rateContractId = dao.getFuncString(nFuncIndex);
			
			System.out.println(" ********* Pkg_Mms_Dml.dml_rate_contract_item_dtls *****[ Mode - 3 ]****  ");

			strProcName = "{call Pkg_Mms_Dml.dml_rate_contract_item_dtls(?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?)}";// 36+3
			nProcIndex = dao.setProcedure(strProcName);
  
			dao.setProcInValue(nProcIndex, "modeval", "3",1);
			dao.setProcInValue(nProcIndex, "contract_type_id",strContractTypeID,2);
			dao.setProcInValue(nProcIndex, "contract_slNo", strSlNo,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "item_id", strItemID,5);
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCategoryNo,6);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandID,7);
			dao.setProcInValue(nProcIndex, "tender_no", strTenderNo,8);
			dao.setProcInValue(nProcIndex, "quotation_no", strQuotationNo,9);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId,10);
			dao.setProcInValue(nProcIndex, "rate", strRate,11);
			dao.setProcInValue(nProcIndex, "contract_date", "SYSDATE",12);
			dao.setProcInValue(nProcIndex, "contract_frmdate",strContractFromDate,13);
			dao.setProcInValue(nProcIndex, "rate_unit", strRateUnitID,14);
			dao.setProcInValue(nProcIndex, "contract_todate",strNtDate,15);
			dao.setProcInValue(nProcIndex, "rate_contract_status",strRateContractStatus,16);
			dao.setProcInValue(nProcIndex, "fin_start_yr", strFinancialStartYr,17);
			dao.setProcInValue(nProcIndex, "fin_end_yr", strFinancialEndYr,18);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,19);
			dao.setProcInValue(nProcIndex, "cancel_remarks", "0",20);
				
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,21);
			dao.setProcInValue(nProcIndex, "cancel_date", "SYSDATE",22);
			dao.setProcInValue(nProcIndex, "cancel_seatid", "0",23);
			dao.setProcInValue(nProcIndex, "delivery_leadtime",strDeiveryLeadTime,24);
			dao.setProcInValue(nProcIndex, "delivery_leadtime_unit",strDeiveryLeadTimeUnit,25);
			
			
			
					
			dao.setProcInValue(nProcIndex, "tax", this.strTax,26);
			dao.setProcInValue(nProcIndex, "taxType", this.strTaxType,27);		
			dao.setProcInValue(nProcIndex, "tenderDate", this.strTenderDate,28);
			dao.setProcInValue(nProcIndex, "qutDate", this.strQutationDate,29);
			dao.setProcInValue(nProcIndex, "securityAmt", this.strSecurityAmt,30);	
			dao.setProcInValue(nProcIndex, "contractQty", this.strContractQty,31);	
			dao.setProcInValue(nProcIndex, "delivery_days", this.strDeliveryDays,32);	
			
			dao.setProcInValue(nProcIndex, "imported_flag", strImportedType,33);
			dao.setProcInValue(nProcIndex, "rate_contract_level",strLevel,34);
			dao.setProcInValue(nProcIndex, "shelf_life",strShelfLife,35);
			dao.setProcInValue(nProcIndex, "rateContractId",rateContractId,36);
			dao.setProcInValue(nProcIndex, "rcChk",this.strRCChk,37);
			dao.setProcInValue(nProcIndex, "tenderitemno",(this.strTenderItemNo == null ||this.strTenderItemNo.equals(""))?"0":this.strTenderItemNo,38);
			dao.setProcInValue(nProcIndex, "pack",this.strPackSize,39);
			dao.setProcOutValue(nProcIndex, "err", 1,40);

			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	public void modify(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if ( strSlNo.equals("")) {
				strSlNo="0";
			}
		
			String strFuncName = "{? = call MMS_MST.generate_contract_slno_new(?)}"; //6
		    int nFuncIndex = dao.setFunction(strFuncName);		
		  
			dao.setFuncInValue(nFuncIndex, 2,this.strHospitalCode);			
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			String  rateContractId = dao.getFuncString(nFuncIndex);

			strProcName = "{call Pkg_Mms_Dml.dml_rate_contract_item_dtls(?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?)}";// 36+3
			nProcIndex = dao.setProcedure(strProcName);
  
			dao.setProcInValue(nProcIndex, "modeval", "4",1);
			dao.setProcInValue(nProcIndex, "contract_type_id",strContractTypeID,2);
			dao.setProcInValue(nProcIndex, "contract_slNo", strSlNo,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "item_id", strItemID,5);
			dao.setProcInValue(nProcIndex, "item_cat_no", strItemCategoryNo,6);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandID,7);
			dao.setProcInValue(nProcIndex, "tender_no", strTenderNo,8);
			dao.setProcInValue(nProcIndex, "quotation_no", strQuotationNo,9);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId,10);
			dao.setProcInValue(nProcIndex, "rate", strRate,11);
			dao.setProcInValue(nProcIndex, "contract_date", "SYSDATE",12);
			dao.setProcInValue(nProcIndex, "contract_frmdate",strContractFromDate,13);
			dao.setProcInValue(nProcIndex, "rate_unit", strRateUnitID,14);
			dao.setProcInValue(nProcIndex, "contract_todate",strNtDate,15);
			dao.setProcInValue(nProcIndex, "rate_contract_status",strRateContractStatus,16);
			dao.setProcInValue(nProcIndex, "fin_start_yr", strFinancialStartYr,17);
			dao.setProcInValue(nProcIndex, "fin_end_yr", strFinancialEndYr,18);
			dao.setProcInValue(nProcIndex, "remarks", strRemarks,19);
			dao.setProcInValue(nProcIndex, "cancel_remarks", "0",20);
				
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,21);
			dao.setProcInValue(nProcIndex, "cancel_date", "SYSDATE",22);
			dao.setProcInValue(nProcIndex, "cancel_seatid", "0",23);
			dao.setProcInValue(nProcIndex, "delivery_leadtime",strDeiveryLeadTime,24);
			dao.setProcInValue(nProcIndex, "delivery_leadtime_unit",strDeiveryLeadTimeUnit,25);
			
			
			
					
			dao.setProcInValue(nProcIndex, "tax", this.strTax,26);
			dao.setProcInValue(nProcIndex, "taxType", this.strTaxType,27);		
			dao.setProcInValue(nProcIndex, "tenderDate", this.strTenderDate,28);
			dao.setProcInValue(nProcIndex, "qutDate", this.strQutationDate,29);
			dao.setProcInValue(nProcIndex, "securityAmt",this.strSecurityAmt,30);	
			dao.setProcInValue(nProcIndex, "contractQty", this.strContractQty,31);	
			dao.setProcInValue(nProcIndex, "delivery_days", this.strDeliveryDays,32);	
			
			dao.setProcInValue(nProcIndex, "imported_flag", "1",33);
			dao.setProcInValue(nProcIndex, "rate_contract_level",strLevel,34);
			dao.setProcInValue(nProcIndex, "shelf_life",strShelfLife,35);
			dao.setProcInValue(nProcIndex, "rateContractId",rateContractId,36);
			dao.setProcInValue(nProcIndex, "rcChk","0",37);
			dao.setProcInValue(nProcIndex, "tenderitemno",this.strTenderItemNo,38);
			dao.setProcInValue(nProcIndex, "pack",this.strPackSize,39);
			dao.setProcOutValue(nProcIndex, "err", 1,40);

			dao.execute(nProcIndex, 1);
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
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when strHospitalCode is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}

			strProcName = "{call Pkg_Mms_Dml.dml_rate_contract_item_dtls (?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,  ?::varchar,?::varchar,?::varchar,?::varchar,?::varchar  ,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,  ?::varchar,?::varchar,?::varchar,?::varchar,?::varchar  ,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,  ?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,  ?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar,?::varchar)}";// 10
			nProcIndex = dao.setProcedure(strProcName);
			
			dao.setProcInValue(nProcIndex, "modeval", "2",1);
			dao.setProcInValue(nProcIndex, "contract_type_id",strContractTypeID,2);
			dao.setProcInValue(nProcIndex, "contract_slNo",	strRateContractSLNo,3);
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode,4);
			dao.setProcInValue(nProcIndex, "item_id", strItemID,5);
			dao.setProcInValue(nProcIndex, "item_cat_no", "",6);
			dao.setProcInValue(nProcIndex, "item_brand_id", strItemBrandID,7);
			dao.setProcInValue(nProcIndex, "tender_no", "",8);
			dao.setProcInValue(nProcIndex, "quotation_no", "",9);
			dao.setProcInValue(nProcIndex, "supplier_id", strSupplierId,10);
			dao.setProcInValue(nProcIndex, "rate", "",11);
			dao.setProcInValue(nProcIndex, "contract_date", "",12);
			dao.setProcInValue(nProcIndex, "contract_frmdate", "",13);
			dao.setProcInValue(nProcIndex, "rate_unit", "",14);
			dao.setProcInValue(nProcIndex, "contract_todate", "",15);
			dao.setProcInValue(nProcIndex, "rate_contract_status", "",16);
			dao.setProcInValue(nProcIndex, "fin_start_yr", "",17);
			dao.setProcInValue(nProcIndex, "fin_end_yr", "",18);
			dao.setProcInValue(nProcIndex, "remarks", "",19);
			dao.setProcInValue(nProcIndex, "cancel_remarks", strCancelRemarks,20);
			dao.setProcInValue(nProcIndex, "seat_id", strSeatId,21);
			dao.setProcInValue(nProcIndex, "cancel_date", "",22);
			dao.setProcInValue(nProcIndex, "cancel_seatid", "",23);
			dao.setProcInValue(nProcIndex, "delivery_leadtime", "",24);
			dao.setProcInValue(nProcIndex, "delivery_leadtime_unit", "",25);
			dao.setProcInValue(nProcIndex, "tax", "",26);
			dao.setProcInValue(nProcIndex, "taxtype", "",27);
			dao.setProcInValue(nProcIndex, "tenderdate", "",28);
			dao.setProcInValue(nProcIndex, "qutdate", "",29);
			dao.setProcInValue(nProcIndex, "securityamt", "",30);
			dao.setProcInValue(nProcIndex, "contractqty", "",31);
			dao.setProcInValue(nProcIndex, "delivery_days", "",32);
			dao.setProcInValue(nProcIndex, "imported_flag", "",33);
			dao.setProcInValue(nProcIndex, "rate_contract_level","",34);
			dao.setProcInValue(nProcIndex, "shelf_life","",35);
			dao.setProcInValue(nProcIndex, "ratecontractid","",36);
			dao.setProcInValue(nProcIndex, "rcchk","",37);
			dao.setProcInValue(nProcIndex, "tenderitemno","0",38);
			dao.setProcInValue(nProcIndex, "pack",strPackSize,39);
			dao.setProcOutValue(nProcIndex, "err", 1,40);

			dao.execute(nProcIndex, 1);
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
	 * Reset.
	 */
	public void reset() {

		strHospitalCode = "";
		strRateContractSLNo = "";
		strItemID = "";
		strItemBrandID = "0";

		strRate = "0";
		strRateUnitID = "";
	//	strGroupID = "";
		strSupplierId = "";
	//	strIsValid = "1";

	}

	/**
	 * Sets the str contract type id.
	 * 
	 * @param strContractTypeID the strContractTypeID to set
	 */
	public void setStrContractTypeID(String strContractTypeID) {
		this.strContractTypeID = strContractTypeID;
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
	 * Sets the str tender no.
	 * 
	 * @param strTenderNo the strTenderNo to set
	 */
	public void setStrTenderNo(String strTenderNo) {
		this.strTenderNo = strTenderNo;
	}

	/**
	 * Sets the str quotation no.
	 * 
	 * @param strQuotationNo the strQuotationNo to set
	 */
	public void setStrQuotationNo(String strQuotationNo) {
		this.strQuotationNo = strQuotationNo;
	}

 

	/**
	 * Sets the str contract from date.
	 * 
	 * @param strContractFromDate the strContractFromDate to set
	 */
	public void setStrContractFromDate(String strContractFromDate) {
		this.strContractFromDate = strContractFromDate;
	}

	/**
	 * Sets the str contract to date.
	 * 
	 * @param strContractToDate the strContractToDate to set
	 */
	public void setStrContractToDate(String strContractToDate) {
		this.strContractToDate = strContractToDate;
	}

	/**
	 * Sets the str rate contract status.
	 * 
	 * @param strRateContractStatus the strRateContractStatus to set
	 */
	public void setStrRateContractStatus(String strRateContractStatus) {
		this.strRateContractStatus = strRateContractStatus;
	}

	/**
	 * Sets the str financial start yr.
	 * 
	 * @param strFinancialStartYr the strFinancialStartYr to set
	 */
	public void setStrFinancialStartYr(String strFinancialStartYr) {
		this.strFinancialStartYr = strFinancialStartYr;
	}

	/**
	 * Sets the str financial end yr.
	 * 
	 * @param strFinancialEndYr the strFinancialEndYr to set
	 */
	public void setStrFinancialEndYr(String strFinancialEndYr) {
		this.strFinancialEndYr = strFinancialEndYr;
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
	 * Sets the str cancel remarks.
	 * 
	 * @param strCancelRemarks the strCancelRemarks to set
	 */
	public void setStrCancelRemarks(String strCancelRemarks) {
		this.strCancelRemarks = strCancelRemarks;
	}

	/**
	 * Sets the str item category no.
	 * 
	 * @param strItemCategoryNo the strItemCategoryNo to set
	 */
	public void setStrItemCategoryNo(String strItemCategoryNo) {
		this.strItemCategoryNo = strItemCategoryNo;
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
	 * Sets the str deivery lead time.
	 * 
	 * @param strDeiveryLeadTime the strDeiveryLeadTime to set
	 */
	public void setStrDeiveryLeadTime(String strDeiveryLeadTime) {
		this.strDeiveryLeadTime = strDeiveryLeadTime;
	}

	/**
	 * Sets the str deivery lead time unit.
	 * 
	 * @param strDeiveryLeadTimeUnit the strDeiveryLeadTimeUnit to set
	 */
	public void setStrDeiveryLeadTimeUnit(String strDeiveryLeadTimeUnit) {
		this.strDeiveryLeadTimeUnit = strDeiveryLeadTimeUnit;
	}

	  

	/**
	 * @param strSlNo the strSlNo to set
	 */
	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

	public String getStrTax() {
		return strTax;
	}

	public void setStrTax(String strTax) {
		this.strTax = strTax;
	}

	public String getStrTaxType() {
		return strTaxType;
	}

	public void setStrTaxType(String strTaxType) {
		this.strTaxType = strTaxType;
	}

	public String getStrTenderDate() {
		return strTenderDate;
	}

	public void setStrTenderDate(String strTenderDate) {
		this.strTenderDate = strTenderDate;
	}

	public String getStrQutationDate() {
		return strQutationDate;
	}

	public void setStrQutationDate(String strQutationDate) {
		this.strQutationDate = strQutationDate;
	}

	public String getStrSecurityAmt() {
		return strSecurityAmt;
	}

	public void setStrSecurityAmt(String strSecurityAmt) {
		this.strSecurityAmt = strSecurityAmt;
	}

	public void setStrContractQty(String strContractQty) {
		this.strContractQty = strContractQty;
	}

	public String getStrDeliveryDays() {
		return strDeliveryDays;
	}

	public void setStrDeliveryDays(String strDeliveryDays) {
		this.strDeliveryDays = strDeliveryDays;
	}

}
