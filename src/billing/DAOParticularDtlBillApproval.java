package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOParticularDtlBillApproval 
{
	
	public static void getParticularDtlForBillApprovals(BillingVO voHdrObj) 
	{
	//	HisDAO daoObj = null;
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String str1 = voHdrObj.getStrValue1();
	//	System.out.println("Puk No-In Pending HLPDAO-->"+str1);
	 	String proc_name1 ="";
	 	
		proc_name1 ="{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		try
		{

		dao = new HisDAO("billing","transactions.DAObilling.getParticularDtl(BillingVO voHdrObj)");
       
		
        procIndex1 = dao.setProcedure(proc_name1);

 	    //set value
	          
        dao.setProcInValue(procIndex1,"billno","",1);  
        dao.setProcInValue(procIndex1,"accNo",str1,2);
        dao.setProcInValue(procIndex1,"to_be_refund_pkg","",3);
        dao.setProcInValue(procIndex1,"groupid","",4);
		dao.setProcInValue(procIndex1,"modeval","2",5);  
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
 
	    voHdrObj.setStrMsgString("DAOPartPymentPendingRequest.getParticularDtl() --> " + e.getMessage());
		voHdrObj.setStrMsgType("1");

		}

		finally {

		if(dao != null) {

		dao.free();

		dao = null;

		}

		}
		
	}
	//////////////////////////////////////////////////////////////////


}
