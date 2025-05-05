package hisglobal;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;

public class CrNoVO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	public CrNoVO(String hospitalCode)  
	{
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
	//	String wardTypeVal="";
		String qry =billing.qryHandler_billing.getQuery(1,"select.crno.1");
		HisDAO hisDao = new HisDAO("CrNoVO","CrNoVO.selectQuery()");
		try 
		{
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, hospitalCode);
			wb=hisDao.executeQry(qryIndex);
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				System.out.println(tmp_ParamName);
				System.out.println(tmp_ParamValue);
				this.setStrdirectorateCode(tmp_ParamName);
				this.setHospitalCode(tmp_ParamValue);
			}
			wb.beforeFirst();
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				System.out.println(tmp_ParamName);
				System.out.println(tmp_ParamValue);
				this.setStrdirectorateCode(tmp_ParamName);
				this.setHospitalCode(tmp_ParamValue);
			}

			
		}
		catch (Exception e) 
		{
			e.printStackTrace();		
		}
		finally
		{
			try {
				if (wb != null) {
					wb.close();
					wb=null;
				}
				if (hisDao != null) {
					hisDao.free();
					hisDao = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private String strdirectorateCode="";
	private String hospitalCode="";

	
	public String getStrdirectorateCode() {
		return strdirectorateCode;
	}




	public void setStrdirectorateCode(String strdirectorateCode) {
		this.strdirectorateCode = strdirectorateCode;
	}
	
	public String getHospitalCode() {
		return hospitalCode;
	}




	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}


}
