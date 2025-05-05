package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class HsttPoDetailsDAO {
	private final String strFileName = "mms.dao.HsttPoDetailsDAO";

	private String strPONO="";
	private String strInsAmount="";
	private String strModevalue="";
	private String strHospitalCode="";
/*	private String strItemCatNo="";
	private String strPoTypeId="";
	private String strPoDate="";
	private String strCurrencyId="";
	private String strStoreId="";
	private String strSupplierId="";
	private String strSupplierType="";
	private String strAgendaNo="";
	private String strIndentNo="";
	private String strPuk="";
	private String strEmpNo="";
	private String strDeliveryDate="";
	private String strDeliveryLocation="";
	private String strTenderNo="";
	private String strTenderDate="";
	private String strQuotationNo="";
	private String strQuotationDate="";
	private String strItemNetCost="";
	private String strAdvance="";
	private String strPoStatus="";
	private String strPaymentMode="";
	private String strCancelDate="";
	private String strCancelRemarks="";
	private String strCancelSeatId="";
	private String strFinStartDate="";
	private String strFinEndDate="";
	private String strPoPrefix="";
	private String strPoRemarks="";
	private String strIsPartDelivery="";
	private String strReturnFlag="";
	private String strSeatId="";
	private String strIsValid="";
	
	private String strTax="";
	private String strPoNetAmt="";
	private String strPaidBillAmt="";*/
	
	
	
	private String strErr = "";

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
	 * @param strPONO the strPONO to set
	 */
	public void setStrPONO(String strPONO) {
		this.strPONO = strPONO;
	}
	/**This Method is used to Update hstt_PO_dtl table
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
			if (strPONO.equals("0") || strPONO.equals("")) {
				throw new Exception("strPONO can not be blank");
			}
			
			
			proc_name = "{call Pkg_Mms_Dml.Dml_Hstt_Po_Dtl(?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			
			dao.setProcInValue(nprocIndex, "modval", strModevalue);
			dao.setProcInValue(nprocIndex, "hosp_code",strHospitalCode);
			dao.setProcInValue(nprocIndex, "poNo",strPONO);
			dao.setProcInValue(nprocIndex, "insAmt",strInsAmount);
			
            
          		
			dao.setProcOutValue(nprocIndex, "err", 1);
			
			dao.execute(nprocIndex,1);
			
		
			this.nUpdatedIndex ++ ;
			
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

			strModevalue = "";
		
			strPONO="";
			strInsAmount = "";
			strHospitalCode = "";
		/*	strItemCatNo="";
			strPoTypeId="";
			strPoDate="";
			strCurrencyId="";
			strStoreId="";
			strSupplierId="";
			strSupplierType="";
			strAgendaNo="";
			strIndentNo="";
			strPuk="";
			strEmpNo="";
			strDeliveryDate="";
			strDeliveryLocation="";
			strTenderNo="";
			strTenderDate="";
			strQuotationNo="";
			strQuotationDate="";
			strItemNetCost="";
			strAdvance="";
			strPoStatus="";
			strPaymentMode="";
			strCancelDate="";
			strCancelRemarks="";
			strCancelSeatId="";
			strFinStartDate="";
			strFinEndDate="";
			strPoPrefix="";
			strPoRemarks="";
			strIsPartDelivery="";
			strReturnFlag="";
			strSeatId="";
			strIsValid="";
			
			strTax="";
			strPoNetAmt="";
			strPaidBillAmt="";*/
		 

	}
	/**
	 * @param strHospitalCode the strHospitalCode to set
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	/**
	 * @param strInsAmount the strInsAmount to set
	 */
	public void setStrInsAmount(String strInsAmount) {
		this.strInsAmount = strInsAmount;
	}
	
	
	/**
	 * @param strModevalue the strModevalue to set
	 */
	public void setStrModevalue(String strModevalue) {
		this.strModevalue = strModevalue;
	}

	
	
}
