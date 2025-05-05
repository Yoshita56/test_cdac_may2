package billing;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

public class DAOParticularDtl 
{
	public static void getParticularDtl(BillingVO voHdrObj) 
	{
		//HisDAO daoObj = null;
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String str1 = voHdrObj.getStrValue1();
		
		String strHospCode = voHdrObj.getStrValue2();
		
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
		dao.setProcInValue(procIndex1,"hosp_code",strHospCode,6);  
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


	public static void getRateDtl(BillingVO voHdrObj) 
	{
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws2 = null;
		String strHospCode = voHdrObj.getStrValue2();
		String strReqNo = voHdrObj.getStrValue3();
		String strChargeTypeId = voHdrObj.getStrValue4();
		String proc_name1 = "{call PKG_BILL_VIEW.Proc_Hblt_Billreq_Tariff_Dtl(?,?,?,?,?,?,?)}";
		
		try 
		{
			dao = new HisDAO("billing","transactions.DAObilling.getRateDtl(BillingVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "reqno", strReqNo,1);
			dao.setProcInValue(procIndex1, "modeval", "1",2);
			dao.setProcInValue(procIndex1, "hosp_code", strHospCode,3);
			dao.setProcInValue(procIndex1, "chargeTypeId", strChargeTypeId,4);
			dao.setProcInValue(procIndex1, "deptcode", voHdrObj.getStrValue1(),5);//Account No Being Passed Here in Place of deptCode
			dao.setProcOutValue(procIndex1, "err", 1,6); 
			dao.setProcOutValue(procIndex1, "resultset", 2,7); 
			dao.executeProcedureByPosition(procIndex1);
			
			ws2 = dao.getWebRowSet(procIndex1, "resultset");
			voHdrObj.setGblWs1(ws2);
			err = dao.getString(procIndex1, "err");

			if (err == null)
				err = "";

			if (!err.equals("")) 
			{
				throw new Exception(err);
			}
		} 
		catch (Exception e) 
		{
			voHdrObj.setStrMsgString("DAOPartPymentPendingRequest.getRateDtl() --> "+ e.getMessage());
			voHdrObj.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void getClientChargeTrfDtl(BillingVO voHdrObj) 
	{
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws1 = null;
		String str1 = voHdrObj.getStrValue1();
		
		String strHospCode = voHdrObj.getStrValue2();		
	 	String proc_name1 ="";
	 	
		proc_name1 ="{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		try
		{
			dao = new HisDAO("billing","transactions.DAObilling.getClientChargeTrfDtl(BillingVO voHdrObj)");		
			procIndex1 = dao.setProcedure(proc_name1);
	          
			dao.setProcInValue(procIndex1,"billno","",1);   
	        dao.setProcInValue(procIndex1,"accNo",str1,2);
	        dao.setProcInValue(procIndex1,"to_be_refund_pkg","",3);  
	        dao.setProcInValue(procIndex1,"groupid","",4);  
			dao.setProcInValue(procIndex1,"modeval","7",5);		
			dao.setProcInValue(procIndex1,"hosp_code",strHospCode,6);  
			dao.setProcInValue(procIndex1,"recno","",7);
			dao.setProcInValue(procIndex1,"rectype","",8);		
			dao.setProcOutValue(procIndex1,"err",1,9);
			dao.setProcOutValue(procIndex1,"resultset",2,10);
			
			dao.executeProcedureByPosition(procIndex1);
      	    	
			ws1 = dao.getWebRowSet(procIndex1,"resultset");
			voHdrObj.setGblWs2(ws1);
			err = dao.getString(procIndex1,"err");	

			if(err == null) err = ""; 
      	
			if(!err.equals(""))
			{      		
				throw new Exception(err);      		
			}		  	
        }
		catch(Exception e) 
		{
			voHdrObj.setStrMsgString("DAOPartPymentPendingRequest.getParticularDtl() --> " + e.getMessage());
			voHdrObj.setStrMsgType("1");
		}
		finally 
		{
			if(dao != null) 
			{
				dao.free();
				dao = null;
			}
		}		
	}
	
	//USED TO CHECK ELEBILLITY AS PER ROOM TYPE FOR CGHS PATIENTS. DIFF AMOUNT PAID BY PATIENT
	public static void getRoomTrfDtl(BillingVO voHdrObj) 
	{
		HisDAO dao = null;
		int  procIndex1 = 0;
		String err = "";
		WebRowSet ws4 = null;
		String str1 = voHdrObj.getStrValue1();
		
		String strHospCode = voHdrObj.getStrValue2();		
	 	String proc_name1 ="";
	 	
		proc_name1 ="{call PKG_BILL_VIEW.proc_HBLT_PATACCOUNT_SERVICE(?,?,?,?,?,?,?,?,?,?)}";
		try
		{
			dao = new HisDAO("billing","transactions.DAObilling.getRoomTrfDtl(BillingVO voHdrObj)");		
			procIndex1 = dao.setProcedure(proc_name1);
	          
			dao.setProcInValue(procIndex1,"billno","",1);   
	        dao.setProcInValue(procIndex1,"accNo",str1,2);
	        dao.setProcInValue(procIndex1,"to_be_refund_pkg","",3);  
	        dao.setProcInValue(procIndex1,"groupid","",4);  
			dao.setProcInValue(procIndex1,"modeval","8",5);		
			dao.setProcInValue(procIndex1,"hosp_code",strHospCode,6);  
			dao.setProcInValue(procIndex1,"recno","",7);
			dao.setProcInValue(procIndex1,"rectype","",8);		
			dao.setProcOutValue(procIndex1,"err",1,9);
			dao.setProcOutValue(procIndex1,"resultset",2,10);
			
			dao.executeProcedureByPosition(procIndex1);
      	    	
			ws4 = dao.getWebRowSet(procIndex1,"resultset");
			voHdrObj.setGblWs4(ws4);
			err = dao.getString(procIndex1,"err");	

			if(err == null) err = ""; 
      	
			if(!err.equals(""))
			{      		
				throw new Exception(err);      		
			}		  	
        }
		catch(Exception e) 
		{
			voHdrObj.setStrMsgString("DAObilling.getRoomTrfDtl() --> " + e.getMessage());
			voHdrObj.setStrMsgType("1");
		}
		finally 
		{
			if(dao != null) 
			{
				dao.free();
				dao = null;
			}
		}		
	}
}
