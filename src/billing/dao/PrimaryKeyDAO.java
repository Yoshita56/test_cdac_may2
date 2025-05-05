package billing.dao;
import javax.sql.rowset.WebRowSet;
import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 22/Aug/2008
 * 
 * This class will be used to insert/update/delete the records
 * Table Name : SBLT_PRIMARYKEY_KEY_DTL
 * Procedure Name : PKG_BILL_VIEW.Sblt_Primarykey_Key_Dtl
*/

public final class PrimaryKeyDAO
{
	private String strKeyname  = "";
	private String strBlockkey = "";
	
		
	//It is mandatory parameter, do not reset the following variables
	private String strErr = "";
	
	private final String strProcName = "pkg_bill_view.Proc_Sblt_Primarykey_Dtl";
	private final String strFileName = "billing.dao.PrimaryKeyDAO";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	private String strPrimrayKeyValue   = null;
	private String strHospCode=null;
	private String strAppendHospcodeFlag = "1";
	
	
	

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

	public void setStrKeyname(String strKeyname) {
		this.strKeyname = strKeyname;
	}

	public void setStrBlockkey(String strBlockkey) {
		this.strBlockkey = strBlockkey;
	}
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank
	 */
	public void select(HisDAO dao) throws Exception
	{
		strErr = "";
		WebRowSet ws = null;
		try 
		{
			nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?)}");
	
			dao.setProcInValue(nInsertedIndex,"keyname",strKeyname,1);
			dao.setProcInValue(nInsertedIndex,"blockkey",strBlockkey,2);
			dao.setProcInValue(nInsertedIndex,"commitflag","0",3);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospCode,4);
			dao.setProcInValue(nInsertedIndex,"appendhospcodefalg",strAppendHospcodeFlag,5);
			dao.setProcOutValue(nInsertedIndex,"err",1,7);
			dao.setProcOutValue(nInsertedIndex,"resultset",2,6);
			
			dao.executeProcedureByPosition(nInsertedIndex);
			ws = dao.getWebRowSet(nInsertedIndex,"resultset");

			if(ws.next())
			{
				this.setStrPrimrayKeyValue(ws.getString(1));
				System.out.println("Primary Key"+ws.getString(1));
			}
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally
		{
		 	this.reset();	//to reset the variables
		}
	}
	
	/**
	 *  This method will be used to insert the records
	 * @param dao : HisDAO Object
	 * @throws Exception - when Patient Account No. is blank
	 */
	public void selectWithCommit(HisDAO dao) throws Exception
	{
		strErr = "";
		WebRowSet ws = null;
		try 
		{
			nInsertedIndex = dao.setProcedure("{call " + strProcName + "(?,?,?,?,?,?,?)}");
	
			dao.setProcInValue(nInsertedIndex,"keyname",strKeyname,1);
			dao.setProcInValue(nInsertedIndex,"blockkey",strBlockkey,2);
			dao.setProcInValue(nInsertedIndex,"commitflag","1",3);
			dao.setProcInValue(nInsertedIndex,"hosp_code",strHospCode,4);
			dao.setProcInValue(nInsertedIndex,"appendhospcodefalg",strAppendHospcodeFlag,5);
			dao.setProcOutValue(nInsertedIndex,"err",1,7);
			dao.setProcOutValue(nInsertedIndex,"resultset",2,6);
			
			dao.executeProcedureByPosition(nInsertedIndex);
			ws = dao.getWebRowSet(nInsertedIndex,"resultset");

			if(ws.next())
			{
				this.setStrPrimrayKeyValue(ws.getString(1));
				System.out.println("Primary Key"+ws.getString(1));
			}
		} 
		catch(Exception e) 
		{
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		}
		finally
		{
		 	this.reset();	//to reset the variables
		}
	}
	private void reset() 
	 {
		 strKeyname  = "";
		 strBlockkey = "";
	 }

	public String getStrPrimrayKeyValue() {
		return strPrimrayKeyValue;
	}

	public void setStrPrimrayKeyValue(String strPrimrayKeyValue) {
		this.strPrimrayKeyValue = strPrimrayKeyValue;
	}

	public void setStrAppendHospcodeFlag(String strAppendHospcodeFlag) {
		this.strAppendHospcodeFlag = strAppendHospcodeFlag;
	}

	
	

}
