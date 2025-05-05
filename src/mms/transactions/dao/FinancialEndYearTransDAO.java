package mms.transactions.dao;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.FinancialEndYearTransVO;
import hisglobal.transactionmgnt.HisDAO;

/**
 * Developer : Tanvi Sappal
 * Date : 22/Jan/2009 version : 1.0
 * Mod Date : 23/Jun/2008
 */

public class FinancialEndYearTransDAO {
	
	public static void storeName(FinancialEndYearTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_View.proc_hstt_store_mst(?,?,?,?,?,?,?)}";
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		
		try
		{
			daoObj=new HisDAO("Financial End Year","FinancialEndYearTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),3);
			
			/* Setting Default Value Start*/
			daoObj.setProcInValue(nProcIndex, "storeid", "0",4);
			daoObj.setProcInValue(nProcIndex, "storetype_id", "0",5);
			/* Setting Default Value End */
			
			daoObj.setProcOutValue(nProcIndex, "err",1,6); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				vo.setStrStoreNameComboWS(ws);
			} else {
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("FinancialEndYearTransDAO.storeName() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	
	
	
	public synchronized static void insert(FinancialEndYearTransVO vo)
	{
		String strProcName = "{call Pkg_Mms_Dml.DML_FINANCIAL_ENDYEAR_DTL(?,?,?,?,?,?,?,?,?)}";
		
		String err="";		
		String outMessage = "";
		int nProcIndex = 0;
		HisDAO daoObj=null;
		String strNewFinStartDate="";
		String strNewFinEndDate = "";
		
		try
		{
		
			daoObj=new HisDAO("Financial End Year","FinancialEndYearTransDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "1",1);
			daoObj.setProcInValue(nProcIndex, "strId", vo.getStrStoreId(),3);
			daoObj.setProcInValue(nProcIndex, "finEndDate", vo.getStrFinEndDate(),5);
			daoObj.setProcInValue(nProcIndex, "seatId", vo.getStrSeatId(),4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospitalCode(),2);
			
			daoObj.setProcOutValue(nProcIndex, "newFinStartDate",1,6);
			daoObj.setProcOutValue(nProcIndex, "newFinEndDate",1,7);
			
			
			daoObj.setProcOutValue(nProcIndex, "outMessage",1,8);
			daoObj.setProcOutValue(nProcIndex, "err",1,9); 
			
			daoObj.executeProcedureByPosition(nProcIndex);
			
			
			strNewFinStartDate=daoObj.getString(nProcIndex, "newFinStartDate");
			vo.setStrNewFinStartDate(strNewFinStartDate);
			
			strNewFinEndDate=daoObj.getString(nProcIndex, "newFinEndDate");
			vo.setStrNewFinEndDate(strNewFinEndDate);
		
			err = daoObj.getString(nProcIndex, "err");
			
			if(err == null) err = "";
			
			if( err.equals(""))
			{
				vo.setStrMsgType("0");
			}
			else
			{
				throw new Exception(err);
			}
			
			
			outMessage = daoObj.getString(nProcIndex, "outMessage");
			
			if(outMessage == null ) outMessage = "";
			
			
			if(!outMessage.equals("")){
				
				vo.setStrMsgString(outMessage);
				vo.setStrMsgType("2");
				
			}
			
			
		}
		catch(Exception e)
		{
			vo.setStrMsgString("FinancialEndYearTransDAO.insert() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
	

}
