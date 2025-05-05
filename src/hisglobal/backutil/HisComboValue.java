package hisglobal.backutil;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HisComboValue
{
	private String deptQuery = "SELECT GNUM_DEPT_CODE,INITCAP(GSTR_DEPT_NAME) "+
			 				   "FROM GBLT_DEPARTMENT_MST ";
	
	/*****************************************Empty Combo**************************************************/
	public ArrayList getEmptyCombo()
	{
		ArrayList comboList = new ArrayList();
		comboList.add(new HisCombo("-1","<-Select Value->"));
		return comboList;		
	}
	
	/*****************************************Getting Combo by Query***************************************/
	public ArrayList getComboList(String query)
	{
		ArrayList comboList = new ArrayList();
		HisResultSet rs = null;
		comboList.add(new HisCombo("-1","<-Select Value->"));
		
		try
		{
 			rs = Conn.getInstance().getRecord(query);
			
			while(rs.next())
			{	
				comboList.add(new HisCombo(rs.getString(1),rs.getString(2)));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception at getComboList "+e);
		}
		
		return comboList;
	}
	
	public String getComboListString(String query,String selectedValue)
	{
		String comboStr = "";
		if(selectedValue==null)
			selectedValue="-1";
			
		ArrayList comboList = this.getComboList(query);
		
		for(int i=0;i<comboList.size();i++)
		{
			HisCombo cboObject = (HisCombo)comboList.get(i);
			if(cboObject.getOptionValue().equals(selectedValue))
				comboStr += "<option value='"+cboObject.getOptionValue()+"' selected>"+cboObject.getOptionText()+"</option>";
			else
				comboStr += "<option value='"+cboObject.getOptionValue()+"'>"+cboObject.getOptionText()+"</option>";
		}
		
		return comboStr;
	}
	
	/**************************************Getting Dept Combo By query with roleId*************************/
	public ArrayList getDeptCombo(String query,String seatId)
	{
		ArrayList comboList = new ArrayList();
		HisResultSet rs = null;
		comboList.add(new HisCombo("-1","<-Select Value->"));
		
		try
		{
			
			String temp = query + this.getValidSeatIdDeptQuery(seatId);
 						 
 			rs = Conn.getInstance().getRecord(query + this.getValidSeatIdDeptQuery(seatId));
			
			
			while(rs.next())
			{
				comboList.add(new HisCombo(rs.getString(1),rs.getString(2)));
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception at getComboList "+e);
		}
		
		return comboList;
	}
	
	private String getValidSeatIdDeptQuery(String seatId)
	{
		return	" AND GNUM_DEPT_CODE IN "+
				"(SELECT GSTR_COLUMN_VALUE "+
				"FROM GBLT_ROLE_MST A,GBLT_ROLE_TABLE_DTL B,GBLT_SEAT_DTL C,GBLT_METATABLE_COLUMN_MST D "+
				"WHERE C.GNUM_ROLE_ID=B.GNUM_ROLE_ID "+
				"AND B.GNUM_ROLE_ID=A.GNUM_ROLE_ID "+
				"AND A.GNUM_MODULE_ID=B.GNUM_MODULE_ID "+
				"AND A.GNUM_ROLE_TYPE='A' "+
				"AND B.GNUM_METATABLE_ID=D.GNUM_METATABLE_ID "+
				"AND C.GNUM_SEATID="+seatId+" "+
				"AND D.GSTR_TABLE_NAME='GBLT_DEPARTMENT_MST' "+
				"AND A.GBL_ISVALID='1' "+
				"AND B.GBL_IS_VALID='1')"+
				"ORDER BY GSTR_DEPT_NAME";
				
				
				
	}
	
}
