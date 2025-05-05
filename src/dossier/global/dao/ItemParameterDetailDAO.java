package dossier.global.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterDetailDAO.
 */
public class ItemParameterDetailDAO {

	/** The str parent param id. */
	private String strParentParamId = "0";
	
	/** The str param id. */
	private String strParamId = "0";
	
	/** The str item id. */
	private String strItemId = "0";
	
	/** The str param sl no. */
	private String strParamSlNo = "0";
	
	/** The str hospital code. */
	private String strHospitalCode = "0";
	
	/** The str param value. */
	private String strParamValue = "0";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";

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
	 * Insert item parameter dtls.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insertItemParameterDtls(HisDAO dao) throws Exception 
	{
		String strMode = "1";
		String proc_name1 = "{call pkg_mms_dml.proc_hstt_item_param_mst_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //10+8=18

		int procIndex1 = 0;

		try 
		{
			if (strItemId.equals("0") || strItemId.equals("")) 
			{
				throw new Exception("Item Id can not be blank");
			}
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) 
			{
				throw new Exception("Hospital Code can not be blank");
			}
			if (strParentParamId.equals("0") || strParentParamId.equals("")) 
			{
				throw new Exception("Parent Param Id can not be null or empty");
			}			
			if (strParamId.equals("0") || strParamId.equals("")) 
			{
				throw new Exception("Param Id can not be null or empty");
			}

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", strMode,1);
			dao.setProcInValue(procIndex1, "hipnum_item_param_id", strParamId,2);
			dao.setProcInValue(procIndex1, "hipnum_item_id", strItemId,3);
			dao.setProcInValue(procIndex1, "hipnum_param_slno", "0",4);
			dao.setProcInValue(procIndex1, "gnum_hospital_code",strHospitalCode,5);
			dao.setProcInValue(procIndex1, "hipnum_item_parent_param_id",strParentParamId,6);
			dao.setProcInValue(procIndex1, "hrgnum_item_param_value",strParamValue,7);
			dao.setProcInValue(procIndex1, "hrgstr_remarks", strRemarks,8);
			dao.setProcInValue(procIndex1, "hrgstr_effective_from", "0",9);
			dao.setProcInValue(procIndex1, "hrgstr_effective_to", "0",10);
			dao.setProcInValue(procIndex1, "gdt_entry_date", "0",11);
			dao.setProcInValue(procIndex1, "gdt_lastmodified_date", "0",12);
			dao.setProcInValue(procIndex1, "gnum_isvalid", "1",13);			
			dao.setProcInValue(procIndex1, "gnum_seat_id", strSeatId,14);
			dao.setProcInValue(procIndex1, "gnum_lastmodified_seat_id", "0",15);
			dao.setProcInValue(procIndex1, "strId", "0",16);  
			dao.setProcInValue(procIndex1, "transNo", "0",17);
		    dao.setProcOutValue(procIndex1, "err", 1,18);

			dao.execute(procIndex1, 2);

			nRowInserted++;
		} 
		catch (Exception e) 
		{
			throw e;
		} 
		finally 
		{
			reset();
		}
	}

	/**
	 * Update item parameter dtls.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void updateItemParameterDtls(HisDAO dao) throws Exception {

		String strMode = "2";
		// String err = "";
		String proc_name1 = "{call pkg_mms_dml.proc_hstt_item_param_mst_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //8+10=18

		int procIndex1 = 0;

		try {

			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("Item Id can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("Hospital Code can not be blank");
			}

			/*
			 * if (strParentParamId.equals("0") || strParentParamId.equals("")) {
			 * throw new Exception("Parent Param Id can not be null or empty"); }
			 */

			if (strParamValue.equals("0") || strParamValue.equals("")) {
				throw new Exception("Param Value can not be null or empty");
			}

			if (strParamId.equals("0") || strParamId.equals("")) {
				throw new Exception("Param Id can not be null or empty");
			}

			// dao = new HisDAO("mms",
			// "global.MmsDAO.insertItemParameterDtls()");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", strMode,1);
			dao.setProcInValue(procIndex1, "hipnum_item_param_id", strParamId,2);
			dao.setProcInValue(procIndex1, "hipnum_item_id", strItemId,3);
			dao.setProcInValue(procIndex1, "hipnum_param_slno", strParamSlNo,4);
			dao.setProcInValue(procIndex1, "gnum_hospital_code",strHospitalCode,5);
			dao.setProcInValue(procIndex1, "hrgnum_item_param_value",strParamValue,6);
			dao.setProcInValue(procIndex1, "gnum_lastmodified_seat_id",strSeatId,7);
			dao.setProcOutValue(procIndex1, "err", 1,18);

			dao.setProcInValue(procIndex1, "hipnum_item_parent_param_id", "0",8); 
			dao.setProcInValue(procIndex1, "hrgstr_remarks", "0",9); 
			dao.setProcInValue(procIndex1, "hrgstr_effective_from", "0",10);
			dao.setProcInValue(procIndex1, "hrgstr_effective_to", "0",11);
			dao.setProcInValue(procIndex1, "gdt_entry_date", "0",12);
			dao.setProcInValue(procIndex1, "gdt_lastmodified_date", "0",13);
			dao.setProcInValue(procIndex1, "gnum_isvalid", "0",14);
			dao.setProcInValue(procIndex1, "gnum_seat_id", "0",15);
			dao.setProcInValue(procIndex1, "strId", "0",16);  
			dao.setProcInValue(procIndex1, "transNo", "0",17);
			
			dao.execute(procIndex1, 2);

			nRowUpdated++;

		} catch (Exception e) {
			throw e;
		} finally {

			reset();
		}
	}

	/**
	 * Delete item parameter dtls.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void deleteItemParameterDtls(HisDAO dao) throws Exception {

		String strMode = "3";
		// String err = "";
		String proc_name1 = "{call pkg_mms_dml.proc_hstt_item_param_mst_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //7+11=18

		int procIndex1 = 0;

		try {

			if (strItemId.equals("0") || strItemId.equals("")) {
				throw new Exception("Item Id can not be blank");
			}

			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("Hospital Code can not be blank");
			}

			/*
			 * if (strParentParamId.equals("0") || strParentParamId.equals("")) {
			 * throw new Exception("Parent Param Id can not be null or empty"); }
			 */

			/*
			 * if (strParamValue.equals("0") || strParamValue.equals("")) {
			 * throw new Exception("Param Value can not be null or empty"); }
			 */

			if (strParamId.equals("0") || strParamId.equals("")) {
				throw new Exception("Param Id can not be null or empty");
			}

			// dao = new HisDAO("mms",
			// "global.MmsDAO.insertItemParameterDtls()");

			procIndex1 = dao.setProcedure(proc_name1);

			dao.setProcInValue(procIndex1, "modval", strMode,1);
			dao.setProcInValue(procIndex1, "hipnum_item_param_id", strParamId,2);
			dao.setProcInValue(procIndex1, "hipnum_item_id", strItemId,3);
			dao.setProcInValue(procIndex1, "hipnum_param_slno", strParamSlNo,4);
			dao.setProcInValue(procIndex1, "gnum_hospital_code",strHospitalCode,5);
			dao.setProcInValue(procIndex1, "gnum_lastmodified_seat_id",	strSeatId,6);
			dao.setProcOutValue(procIndex1, "err", 1,18);
			
			dao.setProcInValue(procIndex1, "hrgnum_item_param_value","0",7);
			dao.setProcInValue(procIndex1, "hipnum_item_parent_param_id", "0",8); 
			dao.setProcInValue(procIndex1, "hrgstr_remarks", "0",9); 
			dao.setProcInValue(procIndex1, "hrgstr_effective_from", "0",10);
			dao.setProcInValue(procIndex1, "hrgstr_effective_to", "0",11);
			dao.setProcInValue(procIndex1, "gdt_entry_date", "0",12);
			dao.setProcInValue(procIndex1, "gdt_lastmodified_date", "0",13);
			dao.setProcInValue(procIndex1, "gnum_isvalid", "0",14);
			dao.setProcInValue(procIndex1, "gnum_seat_id", "0",15);
			dao.setProcInValue(procIndex1, "strId", "0",16);  
			dao.setProcInValue(procIndex1, "transNo", "0",17);

			dao.execute(procIndex1, 2);

			nRowDeleted++;

		} catch (Exception e) {
			throw e;
		} finally {

			reset();
		}
	}

	/**
	 * Reset.
	 */
	private void reset() {

		strParentParamId = "0";
		strParamId = "0";
		strItemId = "0";
		strHospitalCode = "0";
		strParamValue = "0";
		strRemarks = "";
		strSeatId = "";

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
	 * Sets the str parent param id.
	 * 
	 * @param strParentParamId the new str parent param id
	 */
	public void setStrParentParamId(String strParentParamId) {
		this.strParentParamId = strParentParamId;
	}

	/**
	 * Sets the str param id.
	 * 
	 * @param strParamId the new str param id
	 */
	public void setStrParamId(String strParamId) {
		this.strParamId = strParamId;
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
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Sets the str param value.
	 * 
	 * @param strParamValue the new str param value
	 */
	public void setStrParamValue(String strParamValue) {
		this.strParamValue = strParamValue;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Sets the str param sl no.
	 * 
	 * @param strParamSlNo the new str param sl no
	 */
	public void setStrParamSlNo(String strParamSlNo) {
		this.strParamSlNo = strParamSlNo;
	}

}
