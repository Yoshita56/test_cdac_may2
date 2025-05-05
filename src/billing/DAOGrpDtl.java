package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOGrpDtl
{
	public static void getTariffDtl(BillingVO voHdrObj) 
	{
	//	HisDAO daoObj = null;
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String strGrpId  = voHdrObj.getStrValue1();
		String strAcctNo = voHdrObj.getStrValue2();
	 	String proc_name1 ="";
		proc_name1 ="{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		try
		{

		dao = new HisDAO("billing","transactions.DAObilling.getTariffDtl(BillingVO voHdrObj)");
       
		
        procIndex1 = dao.setProcedure(proc_name1);

 	    //set value
        dao.setProcInValue(procIndex1,"billno","",1);
        dao.setProcInValue(procIndex1,"accNo",strAcctNo,2);
        dao.setProcInValue(procIndex1,"to_be_refund_pkg","",3);
        dao.setProcInValue(procIndex1,"groupId",strGrpId,4);
        
		dao.setProcInValue(procIndex1,"modeval","3",5);  
		dao.setProcInValue(procIndex1,"hosp_code","",6);  
	    dao.setProcInValue(procIndex1,"recno","",7);
		dao.setProcInValue(procIndex1,"rectype","",8);
		dao.setProcOutValue(procIndex1,"err",1,9); //1 for string return value

		dao.setProcOutValue(procIndex1,"resultset",2,10); //2 for object
		
        //execute procedure
		
      	dao.executeProcedureByPosition(procIndex1);
            	
        //get value
      
      	ws1 = dao.getWebRowSet(procIndex1,"resultset");
       	voHdrObj.setGblWs2(ws1);
			
      	err = dao.getString(procIndex1,"err");
		
	if(err == null) err = ""; 
      	
      	if(!err.equals("")){
      		
      		throw new Exception(err);
      		
      	}
      	
        }
		catch(Exception e) 
		{
 
	    voHdrObj.setStrMsgString("BillHeaderDAO.getTariffDtl() --> " + e.getMessage());
		voHdrObj.setStrMsgType("1");

		}

		finally {

		if(dao != null) {

		dao.free();

		dao = null;

		}

		}
		
	}

}
