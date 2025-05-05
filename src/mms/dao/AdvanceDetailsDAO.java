package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

public class AdvanceDetailsDAO {
	private final String strFileName = "mms.dao.AdvanceDetailsDAO";
	private String strErr = "";
	
	private String strReqNo="";
	private String strDispatchNo="";
	private String strHospitalCode="";
	/*private String strPoNo="";
	private String strStoreId="";
	private String strReqDate="";
	private String strSupplierId="";
	private String strPoDate="";
	private String strPoAmount="";
	private String strItemCatNo="";
	private String strAdvanceAmt="";
	private String strCurrencyid="";
	private String strAdvanceStatus="";
	private String strReqPre="";
	private String strRemarks="";
	private String strSeatId="";*/
	
	
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
	/**This method is used to update the data in HSTT_ADVANCE_DTL
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
			if (strReqNo.equals("0") || strReqNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			
			
			proc_name = "{call Pkg_Mms_Dml.Dml_Advance_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			
			dao.setProcInValue(nprocIndex, "modval", "2");
			dao.setProcInValue(nprocIndex, "dispatchNo",strDispatchNo);
			dao.setProcInValue(nprocIndex, "hosp_code",strHospitalCode);
			dao.setProcInValue(nprocIndex, "reqNo",strReqNo);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nprocIndex, "storeid", "");
			dao.setProcInValue(nprocIndex, "suppid", "");
			dao.setProcInValue(nprocIndex, "po_no", "");
			dao.setProcInValue(nprocIndex, "po_date", "");
			dao.setProcInValue(nprocIndex, "po_amt", "");
			dao.setProcInValue(nprocIndex, "itemcat_no", "");
			dao.setProcInValue(nprocIndex, "adv_amt", "");
			dao.setProcInValue(nprocIndex, "currencyid", "");
			dao.setProcInValue(nprocIndex, "adv_status", "");
			dao.setProcInValue(nprocIndex, "remarks", "");
			dao.setProcInValue(nprocIndex, "seatid", "");
			dao.setProcInValue(nprocIndex, "isvalid", "");
			dao.setProcInValue(nprocIndex, "reqprefix", "");
			dao.setProcInValue(nprocIndex, "finstartdate", "");
			dao.setProcInValue(nprocIndex, "finenddate", "");
			dao.setProcInValue(nprocIndex, "poStoreId", "");
			dao.setProcInValue(nprocIndex, "bankAccName", "");
			dao.setProcInValue(nprocIndex, "bankAccNo", "");
			/* Setting Default Value End */
          		
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
	/**This method is used to reset  the variables
	 *
	 */
	public void reset() {

	
		/*strStoreId="";
		strReqDate="";
		strSupplierId="";
		strPoDate="";
		strPoAmount="";
		strItemCatNo="";
		strAdvanceAmt="";
		strCurrencyid="";
		strAdvanceStatus="";
		strReqPre="";
		strRemarks="";
		strSeatId="";*/
		strReqNo="";
		strDispatchNo = "";
		strHospitalCode = "";
		

	}
	/**
	 * @param strReqNo the strReqNo to set
	 */
	public void setStrReqNo(String strReqNo) {
		this.strReqNo = strReqNo;
	}
	 
}
