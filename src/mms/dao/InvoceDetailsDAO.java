package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class InvoceDetailsDAO {
	private final String strFileName = "mms.dao.InvoceDetailsDAO";
	private String strErr = "";
	
	private String strBillNo="";
	private String strDispatchNo="";
	private String strHospitalCode="";
	/*private String strPoNo="";
	private String strStoreId="";
	private String strBillTypeId="";
	private String strBillDate="";
	private String strSupplierId="";
	private String strSupplierBillNo="";
	private String strSupplierBillDate="";
	private String strPoDate="";
	private String strPuk="";
	private String strEmpNo="";
	private String strCurrencyCode="";
	private String strSupplierBillAmt="";
	private String strSupplierBillMissAmt="";
	private String strAdvanceAmt="";
	private String strLatePenaltyAmt="";
	private String strPenaltyWaiveAmt="";
	private String strSancAmt="";
	private String strSancMissAmt="";
	private String strBillStatus="";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private String strRemarks="";
	private String strSeatId="";
	private String strIsValid="";
	private String strCancelSeatId="";
	private String strCancelSeatDate="";
	private String strCancelRemarks="";
	private String strItemCatNo="";*/
	
	
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;

	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	/**
	 * @return the strFileName
	 */
	public String getStrFileName() {
		return strFileName;
	}
	/**
	 * @return the strErr
	 */
	public String getStrErr() {
		return strErr;
	}
	/**
	 * @return the nRowInserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}
	/**
	 * @return the nRowUpdated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	/**
	 * @return the nRowDeleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	/**
	 * @return the nInsertedIndex
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	/**
	 * @return the nUpdatedIndex
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	/**
	 * @return the nDeletedIndex
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	/**
	 * @param strBillNo the strBillNo to set
	 */
	public void setStrBillNo(String strBillNo) {
		this.strBillNo = strBillNo;
	}
	/**
	 * @param strDispatchNo the strDispatchNo to set
	 */
	public void setStrDispatchNo(String strDispatchNo) {
		this.strDispatchNo = strDispatchNo;
	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**This Method is used to update hstt_invoice_dtl table
	 * @param dao
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";
	
		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strBillNo.equals("0") || strBillNo.equals("")) {
				throw new Exception("strBillNo can not be blank");
			}
			
			
			proc_name = "{call Pkg_Mms_Dml.Dml_invoice_dtl(?,?,?,?,?)}"; //5
			nprocIndex = dao.setProcedure(proc_name);

			
			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "dispatchNo",strDispatchNo);
			dao.setProcInValue(nprocIndex, "hosp_code",strHospitalCode);
			dao.setProcInValue(nprocIndex, "billNo",strBillNo);
			
            
          		
			dao.setProcOutValue(nprocIndex, "err", 1);
			
			dao.execute(nprocIndex,1);
			
		
			this.nInsertedIndex ++ ;
			
		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}
	/**This Method is used to reset all the data
	 *
	 */
	public void reset() {

	
	
		strBillNo="";
		strDispatchNo = "";
		strHospitalCode = "";
		/*strPoNo="";
		strStoreId="";
		strBillTypeId="";
		strBillDate="";
		strSupplierId="";
		strSupplierBillNo="";
		strSupplierBillDate="";
		strPoDate="";
		strPuk="";
		strEmpNo="";
		strCurrencyCode="";
		strSupplierBillAmt="";
		strSupplierBillMissAmt="";
		strAdvanceAmt="";
		strLatePenaltyAmt="";
		strPenaltyWaiveAmt="";
		strSancAmt="";
		strSancMissAmt="";
		strBillStatus="";
		strFinStartDate="";
		strFinEndDate="";
		strRemarks="";
		strSeatId="";
		strIsValid="";
		strCancelSeatId="";
		strCancelSeatDate="";
		strCancelRemarks="";
		strItemCatNo="";*/
		

	}
 
}
