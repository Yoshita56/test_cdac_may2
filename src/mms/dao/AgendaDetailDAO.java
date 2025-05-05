package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaDetailDAO.
 */
public class AgendaDetailDAO {

	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.dml_hstt_agenda_dtl";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.AgendaDetailDAO";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str agenda no. */
	private String strAgendaNo = "";
	
	/** The str item categ no. */
	private String strItemCategNo = "";
	
	/** The str req type. */
	private String strReqType = "";
	
	/** The fin_start_date. */
	private String fin_start_date = "";
	
	/** The fin_end_date. */
	private String fin_end_date = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str condemnation type. */
	private String strCondemnationType = "";
	
	/** The str err. */
	private String strErr = "";

	/** The n row inserted. */
	private int nRowInserted = 0;

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
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
	 * Sets the str agenda no.
	 * 
	 * @param strAgendaNo the new str agenda no
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	/**
	 * Sets the str item categ no.
	 * 
	 * @param strItemCategNo the new str item categ no
	 */
	public void setStrItemCategNo(String strItemCategNo) {
		this.strItemCategNo = strItemCategNo;
	}

	/**
	 * Sets the str req type.
	 * 
	 * @param strReqType the new str req type
	 */
	public void setStrReqType(String strReqType) {
		this.strReqType = strReqType;
	}

	/**
	 * Sets the fin_start_date.
	 * 
	 * @param fin_start_date the new fin_start_date
	 */
	public void setFin_start_date(String fin_start_date) {
		this.fin_start_date = fin_start_date;
	}

	/**
	 * Sets the fin_end_date.
	 * 
	 * @param fin_end_date the new fin_end_date
	 */
	public void setFin_end_date(String fin_end_date) {
		this.fin_end_date = fin_end_date;
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
	 * Reset.
	 */
	public void reset() {
		strHospCode = "";
		strStoreId = "";
		strAgendaNo = "";
		strItemCategNo = "";
		strReqType = "";
		fin_start_date = "";
		fin_end_date = "";
		strRemarks = "";
		strSeatId = "";
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
		int nProcIndex = 0;

		try {

			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			dao.setProcInValue(nProcIndex, "hosp_code", strHospCode.trim(),2);
			dao.setProcInValue(nProcIndex, "strId", strStoreId.trim(),3);
			dao.setProcInValue(nProcIndex, "agendaNo", strAgendaNo.trim(),4);
			dao.setProcInValue(nProcIndex, "itemCategNo", strItemCategNo,5);
			dao.setProcInValue(nProcIndex, "reqType", strReqType,6);
			dao.setProcInValue(nProcIndex, "fin_start_date", fin_start_date,7);
			dao.setProcInValue(nProcIndex, "fin_end_date", fin_end_date,8);
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim(),9);
			dao.setProcInValue(nProcIndex, "seatId", strSeatId.trim(),10);
			dao.setProcInValue(nProcIndex, "strCondemnationType",
					strCondemnationType.trim(),14);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "modval", "1",1);
			dao.setProcInValue(nProcIndex, "agenda_date", "",11);
			dao.setProcInValue(nProcIndex, "agenda_status", "",12);
			dao.setProcInValue(nProcIndex, "isvalid", "1",13);
			dao.setProcInValue(nProcIndex, "toStrId", "1",15);
			dao.setProcInValue(nProcIndex, "agenda_period", "",16);
			dao.setProcInValue(nProcIndex, "grant_type_id", "",17);
			dao.setProcInValue(nProcIndex, "agenda_period_value", "",18);
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "agenda_approval_status", 1,19);
			dao.setProcOutValue(nProcIndex, "err", 1,20);
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	/**
	 * Sets the str condemnation type.
	 * 
	 * @param strCondemnationType the new str condemnation type
	 */
	public void setStrCondemnationType(String strCondemnationType) {
		this.strCondemnationType = strCondemnationType;
	}

}