package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOPartPymentPendingRequest 
{
	public static void getPartPaymentPendingReq(BillingVO voHdrObj) 
	{
	//	HisDAO daoObj = null;
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String str1 = voHdrObj.getStrValue1();
		String strHospCode = voHdrObj.getStrValue2();
	//	System.out.println("Puk No-In Pending HLPDAO-->"+str1);
	 	String proc_name1 ="";
	 	
		proc_name1 ="{call PKG_BILL_VIEW.PROC_SBLT_INBOUND_DTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try
		{

		dao = new HisDAO("billing","transactions.DAObilling.getPartPaymentPendingReq(BillingVO voHdrObj)");
       
		
        procIndex1 = dao.setProcedure(proc_name1);

 	    //set value
	          
        dao.setProcInValue(procIndex1,"mode_type","3",1);
        dao.setProcInValue(procIndex1,"crno",str1,2);
        dao.setProcInValue(procIndex1,"chargeTypeId","2",3); 
		dao.setProcInValue(procIndex1,"patlisttype","",4); 
		dao.setProcInValue(procIndex1,"searchstr","",5); 
		dao.setProcInValue(procIndex1,"searchtype","",6); 
		dao.setProcInValue(procIndex1,"frmrows","",7); 
		dao.setProcInValue(procIndex1,"torows","",8); 
		dao.setProcInValue(procIndex1,"hosp_code",strHospCode,9); 
		dao.setProcInValue(procIndex1,"deptcode","",10); 
		dao.setProcInValue(procIndex1,"seatid","",11); 
		dao.setProcOutValue(procIndex1,"err",1,12); //1 for string return value
		dao.setProcOutValue(procIndex1,"RESULTSET",2,13); //2 for object
		
        //execute procedure
		
      	dao.executeProcedureByPosition(procIndex1);
      	    	
        //get value
              
      	ws1 = dao.getWebRowSet(procIndex1,"RESULTSET");
      	
        voHdrObj.setGblWs2(ws1);
      	err = dao.getString(procIndex1,"err");	

	if(err == null) err = ""; 
      	
      	if(!err.equals("")){
      		
      		throw new Exception(err);
      		
      	}
      	
		  	
        }
		catch(Exception e) 
		{
	 
	    voHdrObj.setStrMsgString("DAOPartPymentPendingRequest.getPartPaymentPendingReq() --> " + e.getMessage());
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
