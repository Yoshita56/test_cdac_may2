package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AcknowledgeDAO.
 */
public class AcknowledgeDAO {

	/** The str file name. */
	private final String strFileName = "mms.dao.AcknowledgeDAO";
	
	/** The str err. */
	private String strErr = "";

	/** The str store id. */
	private String strStoreId = "";
	
	/** The str trans no. */
	private String strTransNo = "";
	
	/** The str trans no. */
	private String 	strReqTypeId = "";
	
	/** The str hospital code. */
	private String strHospitalCode = "";

	/** The str ack by. */
	private String strAckBy = "";
	
	/** The str remarks. */
	private String strRemarks = "";

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
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
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
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
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
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
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
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
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
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
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
	 * Gets the str store id.
	 * 
	 * @return the str store id
	 */
	public String getStrStoreId() {
		return strStoreId;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Gets the str trans no.
	 * 
	 * @return the str trans no
	 */
	public String getStrTransNo() {
		return strTransNo;
	}

	/**
	 * Sets the str trans no.
	 * 
	 * @param strTransNo the new str trans no
	 */
	public void setStrTransNo(String strTransNo) {
		this.strTransNo = strTransNo;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strTransNo.equals("0") || strTransNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			proc_name = "{call PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

				System.out.println("----------------PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl------------");
			//dao.setProcInValue(nprocIndex, "modval", "1",1);
		    System.out.println("--------reqTypeId--------"+ strReqTypeId);
			System.out.println("--------seatId--------"+ strAckBy);
		    System.out.println("--------hosp_code--------"+strHospitalCode);
			System.out.println("--------storeId--------"+ strStoreId);
			System.out.println("--------transNo--------"+ strTransNo);
			System.out.println("--------remarks--------"+ strRemarks);
	
			dao.setProcInValue(nprocIndex, "modval", "1",1);
			dao.setProcInValue(nprocIndex, "storeId", strStoreId,2);
			dao.setProcInValue(nprocIndex, "transNo", strTransNo,3);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode,4);
			dao.setProcInValue(nprocIndex, "seatId", strAckBy,5);
			dao.setProcInValue(nprocIndex, "reqTypeId", strReqTypeId,6);
			dao.setProcInValue(nprocIndex, "remarks", strRemarks,7);
			dao.setProcOutValue(nprocIndex, "err", 1,8);

			dao.execute(nprocIndex, 1);

			this.nInsertedIndex++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	/**
	 * Delete.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	/*
	public void delete(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strTransNo.equals("0") || strTransNo.equals("")) {
				throw new Exception("strTransNo can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			proc_name = "{call PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "storeId", strStoreId);
			dao.setProcInValue(nprocIndex, "transNo", strTransNo);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode);

			dao.setProcOutValue(nprocIndex, "err", 1);

			dao.execute(nprocIndex, 1);

			this.nDeletedIndex++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".delete() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}*/

	/**
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	/*
	public void update(HisDAO dao) throws Exception {
		strErr = "";
		int nprocIndex;
		String proc_name = "";

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			if (strTransNo.equals("0") || strTransNo.equals("")) {
				throw new Exception("strReqNo can not be blank");
			}
			if (strStoreId.equals("0") || strStoreId.equals("")) {
				throw new Exception("strStoreId can not be blank");
			}

			proc_name = "{call PKG_MMS_DML.Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?,?,?)}";
			nprocIndex = dao.setProcedure(proc_name);

			
			dao.setProcInValue(nprocIndex, "modval", "1");
			dao.setProcInValue(nprocIndex, "reqTypeId", strReqTypeId);
			dao.setProcInValue(nprocIndex, "seatId", strAckBy);
			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nprocIndex, "storeId", strStoreId);
			dao.setProcInValue(nprocIndex, "transNo", strTransNo);

			dao.setProcOutValue(nprocIndex, "err", 1);

			dao.execute(nprocIndex, 1);

			this.nUpdatedIndex++;

		} catch (Exception e) {

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}*/
//
//	/**
//	 * Update1.
//	 * 
//	 * @param dao the dao
//	 * 
//	 * @throws Exception the exception
//	 */
//	public void update1(HisDAO dao) throws Exception {
//		strErr = "";
//		int nprocIndex;
//		String proc_name = "";
//
//		try {
//
//			// check mandatory information
//			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
//				throw new Exception("strHospitalCode can not be blank");
//			}
//			if (strTransNo.equals("0") || strTransNo.equals("")) {
//				throw new Exception("strReqNo can not be blank");
//			}
//			if (strStoreId.equals("0") || strStoreId.equals("")) {
//				throw new Exception("strStoreId can not be blank");
//			}
//
//			proc_name = "{call Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?,?)}";
//			nprocIndex = dao.setProcedure(proc_name);
//
//			dao.setProcInValue(nprocIndex, "modval", "1");
//			dao.setProcInValue(nprocIndex, "reqTypeId", strReqTypeId);
//			dao.setProcInValue(nprocIndex, "seatId", strAckBy);
//			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode);
//			dao.setProcInValue(nprocIndex, "storeId", strStoreId);
//			dao.setProcInValue(nprocIndex, "transNo", strTransNo);
//
//			dao.setProcOutValue(nprocIndex, "err", 1);
//
//			dao.execute(nprocIndex, 1);
//
//			this.nUpdatedIndex++;
//
//		} catch (Exception e) {
//
//			this.strErr = e.getMessage();
//			throw new Exception(strFileName + ".update1() --> " + this.strErr);
//		} finally {
//			this.reset(); // to reset the variables
//		}
//
//	}
//
//	/**
//	 * Update2.
//	 * 
//	 * @param dao the dao
//	 * 
//	 * @throws Exception the exception
//	 */
//	public void update2(HisDAO dao) throws Exception {
//		strErr = "";
//		int nprocIndex;
//		String proc_name = "";
//
//		try {
//
//			// check mandatory information
//			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
//				throw new Exception("strHospitalCode can not be blank");
//			}
//			if (strTransNo.equals("0") || strTransNo.equals("")) {
//				throw new Exception("strIssueNo can not be blank");
//			}
//			if (strStoreId.equals("0") || strStoreId.equals("")) {
//				throw new Exception("strStoreId can not be blank");
//			}
//
//			proc_name = "{call Dml_Hstt_Acknowledge_Dtl (?,?,?,?,?,?)}";
//			nprocIndex = dao.setProcedure(proc_name);
//
//			dao.setProcInValue(nprocIndex, "modval", "1");
//			dao.setProcInValue(nprocIndex, "seatId", strAckBy);
//			dao.setProcInValue(nprocIndex, "hosp_code", strHospitalCode);
//			dao.setProcInValue(nprocIndex, "storeId", strStoreId);
//			dao.setProcInValue(nprocIndex, "transNo", strTransNo);
//
//			dao.setProcOutValue(nprocIndex, "err", 1);
//
//			dao.execute(nprocIndex, 1);
//
//			this.nUpdatedIndex++;
//
//		} catch (Exception e) {
//
//			this.strErr = e.getMessage();
//			throw new Exception(strFileName + ".update2() --> " + this.strErr);
//		} finally {
//			this.reset(); // to reset the variables
//		}
//
//	}

	/**
	 * This method is used to reset the variables.
	 */
	public void reset() {

		strStoreId = "";
		strTransNo = "";
		strHospitalCode = "";

	}

	/**
	 * Gets the str ack by.
	 * 
	 * @return the str ack by
	 */
	public String getStrAckBy() {
		return strAckBy;
	}

	/**
	 * Sets the str ack by.
	 * 
	 * @param strAckBy the new str ack by
	 */
	public void setStrAckBy(String strAckBy) {
		this.strAckBy = strAckBy;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	public String getStrReqTypeId() {
		return strReqTypeId;
	}

	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
}
