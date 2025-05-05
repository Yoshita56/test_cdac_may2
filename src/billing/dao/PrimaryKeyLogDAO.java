package billing.dao;

import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 22/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : SBLT_PRIMARYKEY_LOG_DTL
 * Procedure Name : PKG_BILL_DML.dml_Sblt_Primarykey_Log_Dtl
*/
public final class PrimaryKeyLogDAO 
{
	private String strKeyname  = "";
	private String strStartkey = "";
	private String strBlockkey = "";
	private String strError    = "";
	private String strSeatid   ="";
	
	
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_dml.dml_Sblt_Primarykey_Log_Dtl";
	private final String strFileName = "billing.dao.PrimaryKeyLogDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	private String strHospCode = null;
	
	
	
	
	/**
	 * @return the strHospCode
	 */
	public String getStrHospCode() {
		return strHospCode;
	}



	/**
	 * @param strHospCode the strHospCode to set
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}



	public void setStrKeyname(String strKeyname) {
		this.strKeyname = strKeyname;
	}

	

	public void setStrStartkey(String strStartkey) {
		this.strStartkey = strStartkey;
	}

	

	public void setStrBlockkey(String strBlockkey) {
		this.strBlockkey = strBlockkey;
	}

	

	public void setStrError(String strError) {
		this.strError = strError;
	}

	
	public void setStrSeatid(String strSeatid) {
		this.strSeatid = strSeatid;
	}

	
	public String getStrErr() {
		return strErr;
	}
	
	public int getNRowInserted() {
		return nRowInserted;
	}
	
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	
	public String getStrProcName() {
		return strProcName;
	}
	public String getStrFileName() {
		return strFileName;
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank
	 */
	public void insert(HisDAO dao) throws Exception
	{
		strErr = "";
		try
		{
			nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?,?)}");
			
			dao.setProcInValue(nInsertedIndex,"keyname",strKeyname,1);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospCode,7);
			dao.setProcInValue(nInsertedIndex,"startkey",strStartkey,2);
			dao.setProcInValue(nInsertedIndex,"blockkey",strBlockkey,3);
			dao.setProcInValue(nInsertedIndex,"error",strError,4);
			dao.setProcInValue(nInsertedIndex,"seatid",strSeatid,5);
			dao.setProcInValue(nInsertedIndex,"procedurename","",6);
			dao.setProcOutValue(nInsertedIndex,"err",1,8);
			dao.executeProcedureByPosition(nInsertedIndex);
			strErr = dao.getString(nInsertedIndex, "err");
						
			if (strErr != null && strErr.trim().length() > 0)
			{
				throw new Exception(strErr);
			}			
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally 
		{
			dao.free();
			dao = null;
			this.reset();
		}
	}
	 private void reset() 
	 {
		 strKeyname  = "";
		 strStartkey = "";
		 strBlockkey = "";
		 strError    = "";
		 strSeatid   ="";
			
	 }	
}
