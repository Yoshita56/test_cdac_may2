package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 21/Aug/2008
 * 
 * This class will be used to insert/update/delete the records 
 * Table Name : Hblt_Client_Pat_Trf_Dtl 
 * Procedure Name : PKG_BILL_DML.dml_Hblt_Client_Pat_Trf_Dtl
 */
public class ClientPatTariffDAO {

	private String strClientPatNo = "0";
	private String strGroupId = "0";
	private String strTariffId = "0";
	private String strSancLimit = "0";
	private String strIsValid = "1";
	private String strHospitalCode = "0";
	
	
	// It is mandatory parameter, do not reset the following variables
	private String strErr = "";

	private final String strProcName = "PKG_BILL_DML.dml_Hblt_Client_Pat_Trf_Dtl";
	private final String strFileName = "billing.dao.ClientPatTariffDAO";

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
	 * @param strClientPatNo the strClientPatNo to set
	 */
	public void setStrClientPatNo(String strClientPatNo) {
		this.strClientPatNo = strClientPatNo;
	}

	/**
	 * @param strGroupId the strGroupId to set
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * @param strTariffId the strTariffId to set
	 */
	public void setStrTariffId(String strTariffId) {
		this.strTariffId = strTariffId;
	}

	/**
	 * @param strSancLimit the strSancLimit to set
	 */
	public void setStrSancLimit(String strSancLimit) {
		this.strSancLimit = strSancLimit;
	}

	/**
	 * @param strIsValid the strIsValid to set
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	// Methods starts from here

	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when ClientPatNo or Group Id or Tariff Id is blank
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information
			if (strClientPatNo.equals("0") || strClientPatNo.equals("")) {
				throw new Exception("Client Patient No can not be blank");
			}
			// check mandatory information
			if (strGroupId.equals("0") || strGroupId.equals("")) {
				throw new Exception("Group Id can not be blank");
			}
			// check mandatory information
			if (strTariffId.equals("0") || strTariffId.equals("")) {
				throw new Exception("Tariff Id can not be blank");
			}
		
			if (this.nRowInserted == 0) {
				nInsertedIndex = dao
						.setProcedure("{call "
								+ strProcName
								+ "(?,?,?,?,?,?,?,?)}");
			}

			// set the value
			// Input Value
			dao.setProcInValue(nInsertedIndex, "modval", "1");
			
			dao.setProcInValue(nInsertedIndex, "hblnum_client_patient_no",strClientPatNo );
			dao.setProcInValue(nInsertedIndex, "hblnum_group_id", strGroupId);
			dao.setProcInValue(nInsertedIndex, "hblnum_tariff_id", strTariffId);
			dao.setProcInValue(nInsertedIndex, "hblnum_sanc_limit", strSancLimit);
			dao.setProcInValue(nInsertedIndex, "gnum_isvalid", strIsValid);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospitalCode);  // New Value
							
			
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
	 * This method will be used to clear all the variables
	 */
	private void reset() {

		 strClientPatNo = "0";
		 strGroupId = "0";
		 strTariffId = "0";
		 strSancLimit = "0";
		 strIsValid = "1";
		 strHospitalCode = "0";
	}
}
