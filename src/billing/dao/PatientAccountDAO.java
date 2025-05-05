package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Kapil Khurana
 * Version : 1.0
 * Date : 20/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : HBLT_PATACCOUNT_DTL
 * Procedure Name : PKG_BILL_DML.DML_HBLT_PATACCOUNT_DTL
*/
public final class PatientAccountDAO {
	
	private String strPatAccNo= "0";
	private String strChargeTypeId = "0";
	private String strPatAccountOpDt = "";
	private String strDeptCode = "0";
	private String strPuk = "0";
	private String strClientPatientNo = "0";
	private String strAdmNo = "0";
	private String strEpisodeCode = "0";
	private String strCatCode = "0";
	private String strSancAmt = "0";
	private String strPatRecdAmt = "0";
	private String strClientAmt = "0";
	private String strPatRefundAmt = "0";
	private String strDiscountNetAmt = "0";
	private String strReconcileNetAmt = "0";
	private String strNetActualAmt = "0";
	private String strAppBy = "";
	private String strClientBalance = "0";
	private String strPatAccountClosingDt = "";
	private String strPatAccountStatus = "1";
	private String strAppDate = "";
	private String strEntryDate = "";
	private String strSeatId = "0";
	private String strIsValid = "1";
	private String strAppId = "0";
	private String strClientPatBoundDt = "";
	private String strSerTaxNetAmt = "0";
	private String strTariffNetAmt = "0";
	private String strPeneltyNetAmt = "0";
	private String strHospitalCode = "0";
	private String isBillFinal = "90";
	//Adavnce Security Flag added by garima for HIS_PGI_BILL_CR_1on 18 Aug 2011
	private String advSecFlag = "0";
	private String strMobileNo = "";
	private String strRoomLimit="0";
	private String stripadd="";
	private String strmacadd="";
	private String strAccType="1";
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "pkg_bill_dml.dml_hblt_pataccount_dtl";
	private final String strFileName = "billing.dao.PatientAccountDAO";
	
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
	public void setStrHospitalCode(String strHospitalCode) 
	{
		this.strHospitalCode = strHospitalCode;
	}
	
	/**
	 * @param strPatAccNo The strPatAccNo to set.
	 */

	public void setStrPatAccNo(String strPatAccNo) {
		this.strPatAccNo = strPatAccNo;
	}
	
	/**
	 * @param strChargeTypeId The strChargeTypeId to set.
	 */

	public void setStrChargeTypeId(String strChargeTypeId) {
		this.strChargeTypeId = strChargeTypeId;
	}
	
	/**
	 * @param strPatAccountOpDt The strPatAccountOpDt to set.
	 */

	public void setStrPatAccountOpDt(String strPatAccountOpDt) {
		this.strPatAccountOpDt = strPatAccountOpDt;
	}
	
	/**
	 * @param strDeptCode The strDeptCode to set.
	 */

	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}
	
	/**
	 * @param strPuk The strPuk to set.
	 */

	public void setStrPuk(String strPuk) {
		this.strPuk = strPuk;
	}
	
	/**
	 * @param strClientPatientNo The strClientPatientNo to set.
	 */

	public String getStrAccType() {
		return strAccType;
	}

	public void setStrAccType(String strAccType) {
		this.strAccType = strAccType;
	}

	
	public void setStrClientPatientNo(String strClientPatientNo) {
		this.strClientPatientNo = strClientPatientNo;
	}
	
	/**
	 * @param strAdmNo The strAdmNo to set.
	 */

	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}
	
	/**
	 * @param strEpisodeCode The strEpisodeCode to set.
	 */

	public void setStrEpisodeCode(String strEpisodeCode) {
		this.strEpisodeCode = strEpisodeCode;
	}
	
	/**
	 * @param strCatCode The strCatCode to set.
	 */

	public void setStrCatCode(String strCatCode) {
		this.strCatCode = strCatCode;
	}
	
	/**
	 * @param strSancAmt The strSancAmt to set.
	 */

	public void setStrSancAmt(String strSancAmt) {
		this.strSancAmt = strSancAmt;
	}
	
	/**
	 * @param strPatRecdAmt The strPatRecdAmt to set.
	 */

	public void setStrPatRecdAmt(String strPatRecdAmt) {
		this.strPatRecdAmt = strPatRecdAmt;
	}
	
	/**
	 * @param strClientAmt The strClientAmt to set.
	 */

	public void setStrClientAmt(String strClientAmt) {
		this.strClientAmt = strClientAmt;
	}
	
	/**
	 * @param strPatRefundAmt The strPatRefundAmt to set.
	 */

	public void setStrPatRefundAmt(String strPatRefundAmt) {
		this.strPatRefundAmt = strPatRefundAmt;
	}
	
	/**
	 * @param strDiscountNetAmt The strDiscountNetAmt to set.
	 */

	public void setStrDiscountNetAmt(String strDiscountNetAmt) {
		this.strDiscountNetAmt = strDiscountNetAmt;
	}
	
	/**
	 * @param strReconcileNetAmt The strReconcileNetAmt to set.
	 */

	public void setStrReconcileNetAmt(String strReconcileNetAmt) {
		this.strReconcileNetAmt = strReconcileNetAmt;
	}
	
	/**
	 * @param strNetActualAmt The strNetActualAmt to set.
	 */

	public void setStrNetActualAmt(String strNetActualAmt) {
		this.strNetActualAmt = strNetActualAmt;
	}
	
	/**
	 * @param strAppBy The strAppBy to set.
	 */

	public void setStrAppBy(String strAppBy) {
		this.strAppBy = strAppBy;
	}
	
	/**
	 * @param strClientBalance The strClientBalance to set.
	 */

	public void setStrClientBalance(String strClientBalance) {
		this.strClientBalance = strClientBalance;
	}
	
	/**
	 * @param strPatAccountClosingDt The strPatAccountClosingDt to set.
	 */

	public void setStrPatAccountClosingDt(String strPatAccountClosingDt) {
		this.strPatAccountClosingDt = strPatAccountClosingDt;
	}
	
	/**
	 * @param strPatAccountStatus The strPatAccountStatus to set.
	 */

	public void setStrPatAccountStatus(String strPatAccountStatus) {
		this.strPatAccountStatus = strPatAccountStatus;
	}
	
	/**
	 * @param strAppDate The strAppDate to set.
	 */

	public void setStrAppDate(String strAppDate) {
		this.strAppDate = strAppDate;
	}
	
	/**
	 * @param strEntryDate The strEntryDate to set.
	 */

	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}
	
	/**
	 * @param strSeatId The strSeatId to set.
	 */

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	
	/**
	 * @param strIsValid The strIsValid to set.
	 */

	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}
	
	/**
	 * @param strAppId The strAppId to set.
	 */

	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}
	
	/**
	 * @param strClientPatBoundDt The strClientPatBoundDt to set.
	 */

	public void setStrClientPatBoundDt(String strClientPatBoundDt) {
		this.strClientPatBoundDt = strClientPatBoundDt;
	}
	
	/**
	 * @param strSerTaxNetAmt The strSerTaxNetAmt to set.
	 */

	public void setStrSerTaxNetAmt(String strSerTaxNetAmt) {
		this.strSerTaxNetAmt = strSerTaxNetAmt;
	}
	
	/**
	 * @param strTariffNetAmt The strTariffNetAmt to set.
	 */

	public void setStrTariffNetAmt(String strTariffNetAmt) {
		this.strTariffNetAmt = strTariffNetAmt;
	}
	 
	 /**
	  * @param strPeneltyNetAmt The strPeneltyNetAmt to set.
	  */

	public void setStrPeneltyNetAmt(String strPeneltyNetAmt) {
		this.strPeneltyNetAmt = strPeneltyNetAmt;
	}
	
	

	public void setIsBillFinal(String isBillFinal) {
		this.isBillFinal = isBillFinal;
	}
	
	
	public void setStrMobileNo(String strMobileNo) {
		this.strMobileNo = strMobileNo;
	}

	
//	Methods starts from here
	
	public void setStrRoomLimit(String strRoomLimit) {
		this.strRoomLimit = strRoomLimit;
	}

	
	public void setStripadd(String stripadd) {
		this.stripadd = stripadd;
	}

	public void setStrmacadd(String strmacadd) {
		this.strmacadd = strmacadd;
	}

	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//set the value
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","1",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccNo,2);
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id",strChargeTypeId,3);
			dao.setProcInValue(nInsertedIndex,"hbldt_pataccount_opdate",strPatAccountOpDt,4);
			dao.setProcInValue(nInsertedIndex,"gnum_dept_code",strDeptCode,5);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,6);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_no",strClientPatientNo,7);
			dao.setProcInValue(nInsertedIndex,"hastr_adm_no",strAdmNo,8);
			dao.setProcInValue(nInsertedIndex,"hrgnum_episode_code",strEpisodeCode,9);
			dao.setProcInValue(nInsertedIndex,"gnum_patient_cat_code",strCatCode,10);
			dao.setProcInValue(nInsertedIndex,"hblnum_sanc_amt",strSancAmt,11);
			dao.setProcInValue(nInsertedIndex,"hblnum_patient_recd_amt",strPatRecdAmt,12);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_amt",strClientAmt,13);
			dao.setProcInValue(nInsertedIndex,"hblnum_patient_refund_amt",strPatRefundAmt,14);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_net_amt",strDiscountNetAmt,15);
			dao.setProcInValue(nInsertedIndex,"hblnum_reconcile_net_amt",strReconcileNetAmt,16);
			dao.setProcInValue(nInsertedIndex,"hblnum_net_actual_amt",strNetActualAmt,17);
			dao.setProcInValue(nInsertedIndex,"hblstr_approved_by",strAppBy,18);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_balance",strClientBalance,19);
			dao.setProcInValue(nInsertedIndex,"hbldt_pataccount_closing_date",strPatAccountClosingDt,20);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_status",strPatAccountStatus,21);
			dao.setProcInValue(nInsertedIndex,"hbldt_approved_date",strAppDate,22);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date",strEntryDate,23);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid",strSeatId,24);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid",strIsValid,25);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId,26);
			dao.setProcInValue(nInsertedIndex,"hblnum_clientpat_bound_date",strClientPatBoundDt,27);
			dao.setProcInValue(nInsertedIndex,"hblnum_sertax_net_amt",strSerTaxNetAmt,28);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_net_amt",strTariffNetAmt,29);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty_net_amt",strPeneltyNetAmt,30);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,31);  // New Value
			//output value
			dao.setProcInValue(nInsertedIndex,"is_bill_final_flag","",32);
			dao.setProcInValue(nInsertedIndex,"hblnum_againstsec_flag","",33);
			dao.setProcInValue(nInsertedIndex,"hblnum_mob_no",strMobileNo,34);
			dao.setProcInValue(nInsertedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,36);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,37);
			dao.setProcInValue(nInsertedIndex, "acctype",strAccType,38);
			dao.setProcOutValue(nInsertedIndex,"err",1,39);
			//System.out.println("hblnum_account_type ====>   "+strAccType);
			
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
	 * @throws Exception - when Patient Account No. is blank
	 */
	public void update(HisDAO dao) throws Exception {
		
		strErr = "";
		
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			
			
			//Input Value
			dao.setProcInValue(nInsertedIndex,"modval","5",1);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_no",strPatAccNo,2);
			dao.setProcInValue(nInsertedIndex,"hblnum_net_actual_amt",strNetActualAmt,17);
			dao.setProcInValue(nInsertedIndex,"hblstr_approved_by",strAppBy,18);
			dao.setProcInValue(nInsertedIndex,"hblnum_approval_id",strAppId,26);
			dao.setProcInValue(nInsertedIndex,"hblnum_sertax_net_amt",strSerTaxNetAmt,28);
			dao.setProcInValue(nInsertedIndex,"hblnum_tariff_net_amt",strTariffNetAmt,29);
			dao.setProcInValue(nInsertedIndex,"hblnum_penelty_net_amt",strPeneltyNetAmt,30);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode,31);  // New Value
			dao.setProcInValue(nInsertedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nInsertedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nInsertedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nInsertedIndex,"hrgnum_puk",strPuk,6);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_patient_no","",7);
			dao.setProcInValue(nInsertedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nInsertedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nInsertedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nInsertedIndex,"hblnum_sanc_amt","",11);
			dao.setProcInValue(nInsertedIndex,"hblnum_patient_recd_amt","",12);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_amt","",13);
			dao.setProcInValue(nInsertedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nInsertedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nInsertedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nInsertedIndex,"hblnum_client_balance","",19);
			dao.setProcInValue(nInsertedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nInsertedIndex,"hblnum_pataccount_status","",21);
			dao.setProcInValue(nInsertedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nInsertedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nInsertedIndex,"gnum_seatid","",24);
			dao.setProcInValue(nInsertedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nInsertedIndex,"hblnum_clientpat_bound_date","",27);
			dao.setProcInValue(nInsertedIndex,"is_bill_final_flag ","",32);
			dao.setProcInValue(nInsertedIndex,"hblnum_againstsec_flag ","",33);
			dao.setProcInValue(nInsertedIndex,"hblnum_mob_no","",34);
			dao.setProcInValue(nInsertedIndex,"hblnum_room_limit","",35);
			dao.setProcInValue(nInsertedIndex, "ip",stripadd,36);
			dao.setProcInValue(nInsertedIndex, "mac",strmacadd,37);
			dao.setProcInValue(nInsertedIndex, "acctype","",38);
			//output value
			dao.setProcOutValue(nInsertedIndex,"err",1,39);
			
			//keep in batch
			dao.execute(nInsertedIndex,1);
			this.nRowInserted++;
		} 
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update(modeVal=5) --> " + this.strErr);
		}
		finally {
			this.reset();	//to reset the variables
		}
	}
	
	

	/**
	 * Used to update the record
	 * @param dao :: HisDAO object
	 * @throws Exception : 
	 */
	public void update1(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowUpdated == 0) {
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			 
			//Input Value
			dao.setProcInValue(nUpdatedIndex,"modval","2",1);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no	",strPatAccNo,2);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_patient_no",strClientPatientNo,7);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_sanc_amt",strSancAmt,11);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_balance",strClientBalance,19);
		    dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,31);  // New Value
			dao.setProcInValue(nUpdatedIndex,"hblnum_net_actual_amt","",17);
			dao.setProcInValue(nUpdatedIndex,"hblstr_approved_by","",18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id","",26);
			dao.setProcInValue(nUpdatedIndex,"hblnum_sertax_net_amt","",28);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_net_amt","",29);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_net_amt","",30);
			dao.setProcInValue(nUpdatedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nUpdatedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk","",6);
			dao.setProcInValue(nUpdatedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nUpdatedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_recd_amt","",12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_amt","",13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nUpdatedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_status","",21);
			dao.setProcInValue(nUpdatedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nUpdatedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nUpdatedIndex,"gnum_seatid","",24);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nUpdatedIndex,"hblnum_clientpat_bound_date","",27);
			//output value
			dao.setProcInValue(nUpdatedIndex,"is_bill_final_flag ","",32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag","",33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_mob_no","",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nUpdatedIndex, "ip",stripadd,36);
			dao.setProcInValue(nUpdatedIndex, "mac",strmacadd,37);
			
			dao.setProcOutValue(nUpdatedIndex,"err",1,38);
			//keep in batch
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		}
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	/**
	 * Used to update the record
	 * @param dao :: HisDAO object
	 * @throws Exception : 
	 */
	public void update2(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowUpdated == 0) {
			    //Modified to accept parameter for Adavnce Security Flag by garima gotra for HIS_PGI_BILL_CR_1on 18 Aug 2011
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//Input Value
			dao.setProcInValue(nUpdatedIndex,"modval","3",1);
	    	dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no",strPatAccNo,2);
	    	dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_status",strPatAccountStatus,21);
	        dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,31); 
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_patient_no","",7);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_sanc_amt","",11);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_balance","",19); 
			dao.setProcInValue(nUpdatedIndex,"hblnum_net_actual_amt","",17);
			dao.setProcInValue(nUpdatedIndex,"hblstr_approved_by","",18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id","",26);
			dao.setProcInValue(nUpdatedIndex,"hblnum_sertax_net_amt","",28);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_net_amt","",29);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_net_amt","",30);
			dao.setProcInValue(nUpdatedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nUpdatedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk","",6);
			dao.setProcInValue(nUpdatedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nUpdatedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_recd_amt","",12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_amt","",13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nUpdatedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nUpdatedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nUpdatedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nUpdatedIndex,"gnum_seatid","",24);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nUpdatedIndex,"hblnum_clientpat_bound_date","",27);
			 //Modified to accept parameter for Adavnce Security Flag by garima gotra for HIS_PGI_BILL_CR_1on 18 Aug 2011
			//dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag",advSecFlag,33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag",advSecFlag,33);
			dao.setProcInValue(nUpdatedIndex,"is_bill_final_flag","",32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_mob_no","",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nUpdatedIndex, "ip",stripadd,36);
			dao.setProcInValue(nUpdatedIndex, "mac",strmacadd,37);
			//output value
			//dao.setProcOutValue(nUpdatedIndex,"err",1,34);
			dao.setProcInValue(nUpdatedIndex, "acctype","",38);
			dao.setProcOutValue(nUpdatedIndex,"err",1,39);
			
			//keep in batch
			dao.execute(nUpdatedIndex,1);
	
			this.nRowUpdated++;
		}
		catch(Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update2() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	/**
	 * Used to update the record
	 * @param dao :: HisDAO object
	 * @throws Exception : 
	 */
	public void update3(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			
		/*	//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}*/
			
			if(this.nRowUpdated == 0)
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//Input Value

			dao.setProcInValue(nUpdatedIndex,"modval","4",1);
			dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no",strPatAccNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_net_actual_amt",strNetActualAmt,17);
			dao.setProcInValue(nUpdatedIndex,"hblnum_sertax_net_amt",strSerTaxNetAmt,28);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_net_amt",strTariffNetAmt,29);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,31);  // New Value
			dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_status","",21);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_patient_no","",7);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_sanc_amt","",11);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_balance","",19); 
			dao.setProcInValue(nUpdatedIndex,"hblstr_approved_by","",18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id","",26);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_net_amt","",30);
			dao.setProcInValue(nUpdatedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nUpdatedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk",strPuk,6);
			dao.setProcInValue(nUpdatedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nUpdatedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_recd_amt","",12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_amt","",13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nUpdatedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nUpdatedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nUpdatedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nUpdatedIndex,"gnum_seatid",strSeatId,24);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nUpdatedIndex,"hblnum_clientpat_bound_date","",27);
			dao.setProcInValue(nUpdatedIndex,"is_bill_final_flag",isBillFinal,32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag","",33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_mob_no","",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nUpdatedIndex, "ip",stripadd,36);
			dao.setProcInValue(nUpdatedIndex, "mac",strmacadd,37);
			//output value
			//dao.setProcOutValue(nUpdatedIndex,"err",1,34);
			dao.setProcInValue(nUpdatedIndex, "acctype","",38);
			dao.setProcOutValue(nUpdatedIndex,"err",1,39);
			//keep in batch
			dao.execute(nUpdatedIndex,1);
			this.nRowUpdated++;
		}
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	/**
	 * used to update the Patient Received Amount based on Patient Account Number.
	 * @param dao HisDAO object
	 * @throws Exception
	 */
public void update4(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowUpdated == 0)
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//Input Value

			dao.setProcInValue(nUpdatedIndex,"modval","6",1);
			dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no",strPatAccNo,2);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_recd_amt",strPatRecdAmt,12);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,31);  // New Value
			dao.setProcInValue(nUpdatedIndex,"hblnum_net_actual_amt","",17);
			dao.setProcInValue(nUpdatedIndex,"hblnum_sertax_net_amt","",28);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_net_amt","",29);
	        dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_status","",21);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_patient_no",strClientPatientNo,7);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_sanc_amt",strSancAmt,11);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_balance",strClientBalance,19); 
			dao.setProcInValue(nUpdatedIndex,"hblstr_approved_by","",18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id","",26);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_net_amt","",30);
			dao.setProcInValue(nUpdatedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nUpdatedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk","",6);
			dao.setProcInValue(nUpdatedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nUpdatedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_amt",strClientAmt,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nUpdatedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nUpdatedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nUpdatedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nUpdatedIndex,"gnum_seatid","",24);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nUpdatedIndex,"hblnum_clientpat_bound_date","",27);
			dao.setProcInValue(nUpdatedIndex,"is_bill_final_flag","",32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag","",33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_mob_no",strMobileNo,34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nUpdatedIndex, "ip",stripadd,36);
			dao.setProcInValue(nUpdatedIndex, "mac",strmacadd,37);
			dao.setProcInValue(nUpdatedIndex, "acctype","",38);
			dao.setProcOutValue(nUpdatedIndex,"err",1,39);

			dao.execute(nUpdatedIndex,1);
			
			this.nRowUpdated++;
		}
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update4() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}
	
	
	/**
	 * This method will be used to clear all the variables
	 */
	private void reset() {
		
		strPatAccNo = "0";
		strChargeTypeId = "0";
		strPatAccountOpDt = "";
		strDeptCode = "0";
		strPuk = "0";
		strClientPatientNo = "0";
		strAdmNo = "0";
		strEpisodeCode = "0";
		strCatCode = "0";
		strSancAmt = "0";
		strPatRecdAmt = "0";
		strClientAmt = "0";
		strPatRefundAmt = "0";
		strDiscountNetAmt = "0";
		strReconcileNetAmt = "0";
		strNetActualAmt = "0";
		strAppBy = "";
		strClientBalance = "0";
		strPatAccountClosingDt = "";
		strPatAccountStatus = "1";
		strAppDate = "";
		strEntryDate = "";
		strSeatId = "0";
		strIsValid = "1";
		strAppId = "0";
		strClientPatBoundDt = "";
		strSerTaxNetAmt = "0";
		strTariffNetAmt = "0";
		strPeneltyNetAmt = "0";
		strHospitalCode = "0";
		stripadd="";
		strmacadd="";
		strAccType="";
		
	}
	
	/**
	 * used to update the FINAL BILL FLAG  based on Patient Account Number.
	 * @param dao HisDAO object
	 * @throws Exception
	 */
public void update5(HisDAO dao) throws Exception {
		
		this.strErr = "";
		try {
			//check mandatory information
			if(strPatAccNo.equals("0") || strPatAccNo.equals("")) {
				throw new Exception("Patient Account No. can not be blank");
			}
			
			if(this.nRowUpdated == 0)
			{
				nUpdatedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			
			//Input Value

			dao.setProcInValue(nUpdatedIndex,"modval","7",1);
			dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_no",strPatAccNo,2);
			dao.setProcInValue(nUpdatedIndex,"hosp_code",strHospitalCode,31);  
			dao.setProcInValue(nUpdatedIndex,"is_bill_final_flag",isBillFinal,32);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_recd_amt",strPatRecdAmt,12);
			dao.setProcInValue(nUpdatedIndex,"hblnum_net_actual_amt","",17);
			dao.setProcInValue(nUpdatedIndex,"hblnum_sertax_net_amt","",28);
			dao.setProcInValue(nUpdatedIndex,"hblnum_tariff_net_amt","",29);
	        dao.setProcInValue(nUpdatedIndex,"hblnum_pataccount_status","",21);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_patient_no",strClientPatientNo,7);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_sanc_amt",strSancAmt,11);
		    dao.setProcInValue(nUpdatedIndex,"hblnum_client_balance",strClientBalance,19); 
			dao.setProcInValue(nUpdatedIndex,"hblstr_approved_by","",18);
			dao.setProcInValue(nUpdatedIndex,"hblnum_approval_id","",26);
			dao.setProcInValue(nUpdatedIndex,"hblnum_penelty_net_amt","",30);
			dao.setProcInValue(nUpdatedIndex,"sblnum_chargetype_id","",3);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_opdate","",4);
			dao.setProcInValue(nUpdatedIndex,"gnum_dept_code","",5);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_puk","",6);
			dao.setProcInValue(nUpdatedIndex,"hastr_adm_no","",8);
			dao.setProcInValue(nUpdatedIndex,"hrgnum_episode_code","",9);
			dao.setProcInValue(nUpdatedIndex,"gnum_patient_cat_code","",10);
			dao.setProcInValue(nUpdatedIndex,"hblnum_client_amt",strClientAmt,13);
			dao.setProcInValue(nUpdatedIndex,"hblnum_patient_refund_amt","",14);
			dao.setProcInValue(nUpdatedIndex,"hblnum_discount_net_amt","",15);
			dao.setProcInValue(nUpdatedIndex,"hblnum_reconcile_net_amt","",16);
			dao.setProcInValue(nUpdatedIndex,"hbldt_pataccount_closing_date","",20);
			dao.setProcInValue(nUpdatedIndex,"hbldt_approved_date","",22);
			dao.setProcInValue(nUpdatedIndex,"gdt_entry_date","",23);
			dao.setProcInValue(nUpdatedIndex,"gnum_seatid","",24);
			dao.setProcInValue(nUpdatedIndex,"gnum_isvalid","",25);
			dao.setProcInValue(nUpdatedIndex,"hblnum_clientpat_bound_date","",27);
			dao.setProcInValue(nUpdatedIndex,"hblnum_againstsec_flag","",33);
			dao.setProcInValue(nUpdatedIndex,"hblnum_mob_no","",34);
			dao.setProcInValue(nUpdatedIndex,"hblnum_room_limit",strRoomLimit,35);
			dao.setProcInValue(nUpdatedIndex, "ip",stripadd,36);
			dao.setProcInValue(nUpdatedIndex, "mac",strmacadd,37);
			
			
						
			//output value
			dao.setProcOutValue(nUpdatedIndex,"err",1,38);
			
			//keep in batch
			dao.execute(nUpdatedIndex,1);
			
			this.nRowUpdated++;
		}
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update1() --> " + this.strErr);
		}
		finally {
			this.reset();
		}
	}

     //Added setter method for Adavnce Security Flag by garima gotra for HIS_PGI_BILL_CR_1on 18 Aug 2011
	public void setAdvSecFlag(String advSecFlag) {
		this.advSecFlag = advSecFlag;
	}

	
}

	
