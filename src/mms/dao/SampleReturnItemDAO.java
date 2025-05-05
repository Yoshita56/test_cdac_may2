package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleReturnItemDAO.
 */
public class SampleReturnItemDAO {
	
	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.dml_set_sample_ret_dtls";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.SampleReturnItemDAO";

	/** The str sample recno. */
	private String strSampleRecno = "";
	
	/** The str sample retno. */
	private String strSampleRetno = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str itembrand id. */
	private String strItembrandId = "";
	
	/** The str batch sl no. */
	private String strBatchSlNo = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str subgroup id. */
	private String strSubgroupId = "";
	
	/** The str qty. */
	private String strQty = "";
	
	/** The str qty unit id. */
	//private String strQtyUnitId = "";
	
	/** The str avl qty. */
//	private String strAvlQty = "";
	
	/** The str avl qty unit id. */
//	private String strAvlQtyUnitId = "";
	
	/** The str expiry date. */
//	private String strExpiryDate = "";
	
	/** The str remarks. */
	private String strRemarks = "";

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

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
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
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
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
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
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
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * This function is used to insert into Sample Return Item Table.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */

	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex = 0;

		try {

			/*
			 * if(strSampleRecno.equals("0") || strSampleRecno.equals("")) {
			 * throw new Exception("Sample Recieve Number can not be blank"); }
			 * if(strGroupId.equals("0") || strGroupId.equals("")) { throw new
			 * Exception("Group Id can not be blank"); }
			 * if(strItemId.equals("0") || strItemId.equals("")) { throw new
			 * Exception("Item Id can not be blank"); }
			 * if(strSubgroupId.equals("0") || strSubgroupId.equals("")) { throw
			 * new Exception("Sub Group Id can not be blank"); }
			 * if(strHospitalCode.equals("0") || strHospitalCode.equals("")) {
			 * throw new Exception("strHospitalCode can not be blank"); }
			 */

			// check mandatory information
			/*
			 * //System.out.println("df123---->strSampleRecno"+strSampleRecno);
			 * //System.out.println("strSampleRetno"+strSampleRetno);
			 * //System.out.println("strItemId"+strItemId);
			 * //System.out.println("strItembrandId"+strItembrandId);
			 * //System.out.println("batch_sl_no"+strBatchSlNo);
			 * //System.out.println("strHospitalCode"+strHospitalCode);
			 * //System.out.println("strGroupId"+strGroupId);
			 * //System.out.println("strSubgroupId"+strSubgroupId);
			 * //System.out.println("strQty"+strQty);
			 * //System.out.println("strQtyUnitId"+strQtyUnitId);
			 * //System.out.println("strAvlQty"+strAvlQty);
			 * //System.out.println("strAvlQtyUnitId"+strAvlQtyUnitId);
			 * //System.out.println("strExpiryDate"+strExpiryDate);
			 * //System.out.println("strRemarks"+strRemarks);
			 */
			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			dao.setProcInValue(nProcIndex, "sample_recno", strSampleRecno
					.trim()); // 1
			dao.setProcInValue(nProcIndex, "sample_retno", strSampleRetno
					.trim()); // 2
			dao.setProcInValue(nProcIndex, "item_id", strItemId.trim()); // 3
			dao.setProcInValue(nProcIndex, "itembrand_id", strItembrandId
					.trim()); // 4
			dao.setProcInValue(nProcIndex, "batch_sl_no", strBatchSlNo.trim()); // 5
			dao.setProcInValue(nProcIndex, "hospital_code", strHospitalCode
					.trim()); // 6
			dao.setProcInValue(nProcIndex, "group_id", strGroupId.trim()); // 7
			dao.setProcInValue(nProcIndex, "subgroup_id", strSubgroupId.trim()); // 8
			dao.setProcInValue(nProcIndex, "qty", strQty.trim()); // 9
			dao.setProcInValue(nProcIndex, "qty_unitid", "1101"); // 10
			dao.setProcInValue(nProcIndex, "avl_qty", "12"); // 11
			dao.setProcInValue(nProcIndex, "avlqty_unitid", "1101"); // 12
			dao.setProcInValue(nProcIndex, "expiry_date", "1-Jan-2010"); // 13
			dao.setProcInValue(nProcIndex, "remarks", strRemarks.trim()); // 14
			dao.setProcOutValue(nProcIndex, "err", 1); // 15
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
	 * This function is used to reset the all values.
	 */
	public void reset() {

		strSampleRecno = "";
		strSampleRetno = "";
		strItemId = "";
		strItembrandId = "";
		strBatchSlNo = "";
		strHospitalCode = "";
		strGroupId = "";
		strSubgroupId = "";
		strQty = "";
	/*	strQtyUnitId = "";
		strAvlQty = "";
		strAvlQtyUnitId = "";
		strExpiryDate = "";*/
		strRemarks = "";

	}

	/**
	 * Gets the str sample recno.
	 * 
	 * @return the str sample recno
	 */
	public String getStrSampleRecno() {
		return strSampleRecno;
	}

	/**
	 * Sets the str sample recno.
	 * 
	 * @param strSampleRecno the new str sample recno
	 */
	public void setStrSampleRecno(String strSampleRecno) {
		this.strSampleRecno = strSampleRecno;
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
	 * Sets the str batch sl no.
	 * 
	 * @param strBatchSlNo the new str batch sl no
	 */
	public void setStrBatchSlNo(String strBatchSlNo) {
		this.strBatchSlNo = strBatchSlNo;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

 

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemId() {
		return strItemId;
	}

	/**
	 * Sets the str sample retno.
	 * 
	 * @param strSampleRetno the new str sample retno
	 */
	public void setStrSampleRetno(String strSampleRetno) {
		this.strSampleRetno = strSampleRetno;
	}

	/**
	 * Sets the str itembrand id.
	 * 
	 * @param strItembrandId the new str itembrand id
	 */
	public void setStrItembrandId(String strItembrandId) {
		this.strItembrandId = strItembrandId;
	}

	/**
	 * Sets the str subgroup id.
	 * 
	 * @param strSubgroupId the new str subgroup id
	 */
	public void setStrSubgroupId(String strSubgroupId) {
		this.strSubgroupId = strSubgroupId;
	}

	/**
	 * Sets the str qty.
	 * 
	 * @param strQty the new str qty
	 */
	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}

	 

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

}
