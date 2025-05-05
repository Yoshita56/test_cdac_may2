package billing;


/**
 * 
 * @author Amit Kumar
 *
 */
public class PrintBillBO 
{
	
	/**
	 * ADVANCE
	 * @author Amit Kumar
	 *
	 */
	public void ADVANCE(PrintBillVO voObj)
    {
 	    PrintBillDAO.ADVANCE(voObj);
   	}
	
	
	/**
	 * ADVANCE
	 * @author Amit Kumar
	 *
	 */
	public void ADVANCE_REFUND(PrintBillVO voObj)
    {
 	    PrintBillDAO.ADVANCE_REFUND(voObj);
   	}
	
	/**
	 * PART_PAYMENT_DUP
	 * @author Balasubramaniam M
	 *
	 */
    public void DUP_CONSOLIDATED_PRINT(PrintBillVO voObj)
    {
    	PrintBillDAO.DUP_CONSOLIDATED_PRINT(voObj); 
    }
    
    
    /**
	 * PART_PAYMENT_DUP
	 * @author Balasubramaniam M
	 *
	 */
    public void DUP_REPLICA_PRINT(PrintBillVO voObj)
    {
    	PrintBillDAO.DUP_REPLICA_PRINT(voObj); 
    }
    
    /**
	 * PART_PAYMENT
	 * @author Amit Kumar
	 *
	 */
    public void PART_PAYMENT(PrintBillVO voObj)
    {
    	PrintBillDAO.PART_PAYMENT(voObj); 
    }
    /**
	 * OPD_SERVICES_DUP
	 * @author Amit Kumar
	 *
	 */
    
    
    /**
	 * OPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_SERVICES(PrintBillVO voObj)
    {
		
    	PrintBillDAO.OPD_SERVICES(voObj);
    	PrintBillDAO.OPD_SERVICES1(voObj);
    }
    
    /**
	 * IPD_FINAL_SETTLE
	 * @author Amit Kumar
	 *
	 */
    
    public void IPD_FINAL_SETTLE(PrintBillVO voObj)
    {
		
    	PrintBillDAO.IPD_FINAL_SETTLE(voObj);
    	PrintBillDAO.IPD_FINAL_SETTLE1(voObj);
    }
    
    /**
	 * IPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    public void IPD_SERVICES(PrintBillVO voObj)
    {
		
    	PrintBillDAO.IPD_SERVICES(voObj);
    	PrintBillDAO.IPD_SERVICES1(voObj);
    }
    
    /**
	 * IPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    public void IPD_RECONCILIATION(PrintBillVO voObj)
    {
		
    	PrintBillDAO.IPD_RECONCILIATION(voObj);
    	PrintBillDAO.IPD_RECONCILIATION1(voObj);
    }
   
    
    /**
	 * OPD_REFUND
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_REFUND(PrintBillVO voObj)
    {
    	PrintBillDAO.OPD_REFUND(voObj);
    	PrintBillDAO.OPD_REFUND1(voObj);
	}
    /**
	 * OPD_RECONCILIATION
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_RECONCILIATION(PrintBillVO voObj)
    {
    	PrintBillDAO.OPD_RECONCILIATION(voObj);
    	PrintBillDAO.OPD_RECONCILIATION1(voObj);
	}
    /**
	 * IPD_REFUND
	 * @author Amit Kumar
	 *
	 */
    
    
    public void IPD_REFUND(PrintBillVO voObj)
    {
    	PrintBillDAO.IPD_REFUND(voObj);
    	PrintBillDAO.IPD_REFUND1(voObj);
	   }
    
    public void FINAL_ADJUSTMENT(PrintBillVO voObj)
    {
    	PrintBillDAO.FINAL_ADJUSTMENT(voObj);
   	}

    /**
	 * FINAL_ADJUSTMENT2 -->
	 *  a) FINALADJUSTMENT_CONSOLEDATED
	 *  b) FINALADJUSTMENT_DETAIL
	 * @author Amit Kumar
	 *
	 */
    
    public void FINAL_ADJUSTMENT2(PrintBillVO voObj)
    {
   		if(voObj.getStrReceiptType().equals("1")) 
   		{
   			PrintBillDAO.FINALADJUSTMENT_CONSOLEDATED(voObj);
   		}
   		else 
   		{
   			PrintBillDAO.FINALADJUSTMENT_DETAIL(voObj);
   		}
   	}
    
    /**
     * method used to update the print status
     * @param voObj
     */
	public void UPDATE_PRINT_STATUS(PrintBillVO voObj) {

		
		PrintBillDAO.UPDATE_PRINT_STATUS(voObj);
				
		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOfflineTreatmentCategoryDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}	
    
}
