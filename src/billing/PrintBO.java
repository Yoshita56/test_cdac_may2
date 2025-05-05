package billing;


/**
 * 
 * @author Amit Kumar
 *
 */
public class PrintBO 
{
	
	/**
	 * ADVANCE_DUP
	 * @author Amit Kumar
	 *
	 */
	public void ADVANCE_DUP(PrintVO voObj)
    {
 	    PrintDAO.ADVANCE_DUP(voObj);
   	}
	
	/**
	 * ADVANCE
	 * @author Amit Kumar
	 *
	 */
	public void ADVANCE(PrintVO voObj)
    {
 	    PrintDAO.ADVANCE(voObj);
   	}
	public void LFADVANCE(PrintVO voObj)
    {
 	    PrintDAO.LFADVANCE(voObj);
   	}
	public void WALLETADVANCE(PrintVO voObj)
    {
 	    PrintDAO.WALLETADVANCE(voObj);
   	}
	
	
	/**
	 * ADVANCE
	 * @author Amit Kumar
	 *
	 */
	public void ADVANCE_REFUND(PrintVO voObj)
    {
 	    PrintDAO.ADVANCE_REFUND(voObj);
   	}
	
	
	/**
	 * ADVANCE
	 * @author Amit Kumar
	 *
	 */
	public void PARTPAY_REFUND(PrintVO voObj)
    {
 	    PrintDAO.PARTPAY_REFUND(voObj);
   	}
	/**
	 * PART_PAYMENT_DUP
	 * @author Amit Kumar
	 *
	 */
    public void PART_PAYMENT_DUP(PrintVO voObj)
    {
    	PrintDAO.PART_PAYMENT_DUP(voObj); 
    }
    
    
    /**
	 * PART_PAYMENT_DUP
	 * @author Balasubramaniam M
	 *
	 */
    public void DUP_CONSOLIDATED_PRINT(PrintVO voObj)
    {
    	PrintDAO.DUP_CONSOLIDATED_PRINT(voObj); 
    }
    
    
    /**
	 * PART_PAYMENT_DUP
	 * @author Balasubramaniam M
	 *
	 */
    public void DUP_REPLICA_PRINT(PrintVO voObj)
    {
    	PrintDAO.DUP_REPLICA_PRINT(voObj); 
    }
    
    /**
	 * PART_PAYMENT
	 * @author Amit Kumar
	 *
	 */
    public void PART_PAYMENT(PrintVO voObj)
    {
    	PrintDAO.PART_PAYMENT(voObj); 
    }
    public void LF_PART_PAYMENT(PrintVO voObj)
    {
    	PrintDAO.LF_PART_PAYMENT(voObj); 
    }
    /**
	 * OPD_SERVICES_DUP
	 * @author Amit Kumar
	 *
	 */
    
    
    /**
	 * OPD_SERVICES_DUP
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_SERVICES_DUP(PrintVO voObj)
    {
		
    	PrintDAO.OPD_SERVICES_DUP(voObj);
    	PrintDAO.OPD_SERVICES_DUP1(voObj);
    }
    /**
	 * OPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_SERVICES(PrintVO voObj)
    {
		
    	PrintDAO.OPD_SERVICES(voObj);
    	PrintDAO.OPD_SERVICES1(voObj);
    	//PrintDAO.OPD_SERVICES2(voObj);
    }
    
    public void OPD_ESTIMATION(PrintVO voObj)
    {
		
    	PrintDAO.OPD_ESTIMATION(voObj);
    	PrintDAO.OPD_ESTIMATION1(voObj);
    	//PrintDAO.OPD_SERVICES2(voObj);
    }
    /**
   	 * OPD_SERVICES
   	 * @author Amit Kumar
   	 *
   	 */
       
    public void OPD_SERVICES_REG(PrintVO voObj)
    {
   		
       	PrintDAO.OPD_SERVICES_REG(voObj);
       	PrintDAO.OPD_SERVICES1_REG(voObj);
       	//PrintDAO.OPD_SERVICES2(voObj);
    }
    
    public void OPD_SERVICES_REGSERV(PrintVO voObj)
    {
   		
       	PrintDAO.OPD_SERVICES_REGSERV(voObj);
       	PrintDAO.OPD_SERVICES1_REGSERV(voObj);
       	//PrintDAO.OPD_SERVICES2(voObj);
    }
    public void IPD_SERVICES_REGSERV(PrintVO voObj)
    {
   		
       	PrintDAO.OPD_SERVICES_REGSERV(voObj);
       	PrintDAO.IPD_SERVICES1_REGSERV(voObj);
    }
     
    public void OPD_SERVICES2(PrintVO voObj)
    {
		PrintDAO.OPD_SERVICES2(voObj);
    }
    
    /**
	 * OPD_SERVICES_DIRECT
	 * @author Balasubramaniam M
	 *
	 */
    
    public void OPD_SERVICES_DIRECT(PrintVO voObj)
    {
		
    	PrintDAO.OPD_SERVICES(voObj);
    	
    }
    
    public void OPD_ESTIMATION_DIRECT(PrintVO voObj)
    {
		
    	PrintDAO.OPD_ESTIMATION(voObj);
    	
    }
    
    
    /**
	 * IPD_FINAL_SETTLE
	 * @author Amit Kumar
	 *
	 */
    
    public void IPD_FINAL_SETTLE(PrintVO voObj)
    {
		
    	PrintDAO.IPD_FINAL_SETTLE(voObj);
    	PrintDAO.IPD_FINAL_SETTLE1(voObj);
    }
    
    /**
	 * IPD_SERVICES_DUP
	 * @author Amit Kumar
	 *
	 */
    public void IPD_SERVICES_DUP(PrintVO voObj)
    {
		
    	PrintDAO.IPD_SERVICES_DUP(voObj);
    	PrintDAO.IPD_SERVICES_DUP1(voObj);
    }
   
    /**
	 * IPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    public void IPD_SERVICES(PrintVO voObj)
    {
		
    	PrintDAO.IPD_SERVICES(voObj);
    	PrintDAO.IPD_SERVICES1(voObj);//Tariff Details
    }
    
    /**
	 * IPD_SERVICES_DIRECT
	 * @author Amit Kumar
	 *
	 */
    public void IPD_SERVICES_DIRECT(PrintVO voObj)
    {
		
    	PrintDAO.IPD_SERVICES(voObj);
    	//PrintDAO.IPD_PACKAGES(voObj);
    
    }
    
    public void IPD_ESTIMATION(PrintVO voObj)
    {
		
    	PrintDAO.IPD_ESTIMATION(voObj);
    	PrintDAO.IPD_ESTIMATION1(voObj);//Tariff Details
    }
    
    /**
	 * IPD_SERVICES_DIRECT
	 * @author Amit Kumar
	 *
	 */
    public void IPD_ESTIMATION_DIRECT(PrintVO voObj)
    {
		
    	PrintDAO.IPD_ESTIMATION(voObj);
    	//PrintDAO.IPD_PACKAGES(voObj);
    
    }
    
    public void IPD_PACKAGES(PrintVO voObj)
    {		
    	PrintDAO.IPD_PACKAGES(voObj);    
    }
    
    /**
	 * IPD_SERVICES
	 * @author Amit Kumar
	 *
	 */
    public void IPD_RECONCILIATION(PrintVO voObj)
    {
		
    	PrintDAO.IPD_RECONCILIATION(voObj);
    	PrintDAO.IPD_RECONCILIATION1(voObj);
    }
   
    
    /**
	 * OPD_REFUND
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_REFUND(PrintVO voObj)
    {
    	PrintDAO.OPD_REFUND(voObj);
    	PrintDAO.OPD_REFUND1(voObj);
    	
	}
    
    /**
	 * OPD_REFUND
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_REFUND_WITH_OLD_DTLS(PrintVO voObj)
    {
    	PrintDAO.OPD_REFUND(voObj);
    	PrintDAO.OPD_REFUND1(voObj);
    	PrintDAO.OPD_SERVICES_OLD_DTLS(voObj);
	}
    
    /**
	 * OPD_RECONCILIATION
	 * @author Amit Kumar
	 *
	 */
    
    public void OPD_RECONCILIATION(PrintVO voObj)
    {
    	PrintDAO.OPD_RECONCILIATION(voObj);
    	PrintDAO.OPD_RECONCILIATION1(voObj);
	}
    /**
	 * IPD_REFUND
	 * @author Amit Kumar
	 *
	 */
    
    
    public void IPD_REFUND(PrintVO voObj)
    {
    	PrintDAO.IPD_REFUND(voObj);
    	PrintDAO.IPD_REFUND1(voObj);
	   }
    
    /**
	 * ADDMISSION_CANCELLATION
	 * @author Amit Kumar
	 *
	 */
    
    public void ADDMISSION_CANCELLATION(PrintVO voObj)
    {
    	PrintDAO.ADDMISSION_CANCELLATION(voObj);
    }
    
    /**
	 * RECONCELATION
	 * @author Amit Kumar
	 *
	 */
    
    public void RECONCELATION(PrintVO voObj)
    {
    	PrintDAO.RECONCELATION(voObj);
    }
   
    public void FINAL_ADJUSTMENT_DUP(PrintVO voObj)
    {
    	PrintDAO.FINAL_ADJUSTMENT_DUP(voObj);
   	}
    
    public void FINAL_ADJUSTMENT(PrintVO voObj)
    {
    	PrintDAO.FINAL_ADJUSTMENT(voObj);
   	}

    /**
	 * FINAL_ADJUSTMENT_GROUPDATAANDDEPOSITDATADETAILCONS -->
	 *  a) FINALADJUSTMENT_CONSOLEDATED
	 *  b) FINALADJUSTMENT_DETAIL
	 * @author Amit Kumar
	 *
	 */
    
    public void FINAL_ADJUSTMENT_GROUPDATAANDDEPOSITDATADETAILCONS(PrintVO voObj)
    {
   		if(voObj.getStrReceiptType().equals("1")) 
   		{
   			//System.out.println("WSX");
   			PrintDAO.FINALADJUSTMENT_CONSOLEDATED(voObj);//GROUP DATA-MODE 30
   			PrintDAO.FINALADJUSTMENT_DEPOSITDATA(voObj);//DEPOSIT DATA-MODE 37
   		}
   		else 
   		{
   			//System.out.println("WSY");
   			PrintDAO.FINALADJUSTMENT_CONSOLEDATED_COPY(voObj);//GROUP DATA, DIFF WEBROWSET-MODE 30
   			PrintDAO.FINALADJUSTMENT_DETAIL(voObj);
   			PrintDAO.FINALADJUSTMENT_DEPOSITDATA(voObj);//DEPOSIT DATA-MODE 37
   		}
   	}
    public void TRANSPOTATION_CHARGE(PrintVO voObj)
    {
    	PrintDAO.TRANSPOTATION_CHARGES(voObj);
   	}
    public void TRANSPOTATION_CHARGE_CONSOLIDATED(PrintVO voObj)
    {
    	PrintDAO.TRANSPOTATION_CHARGE_CONSOLEDATED(voObj);
   	}
    /**
	 * FINAL_ADJUSTMENT2_DUP -->
	 *  a) FINALADJUSTMENT_CONSOLEDATED_DUP
	 *  b) FINALADJUSTMENT_DETAIL_DUP
	 * @author Amit Kumar
	 *
	 */
    
    public void FINAL_ADJUSTMENT2_DUP(PrintVO voObj)
    {
   		if(voObj.getStrReceiptType().equals("1")) 
   		{
   			PrintDAO.FINALADJUSTMENT_CONSOLEDATED_DUP(voObj);
   		}
   		else 
   		{
   			PrintDAO.FINALADJUSTMENT_DETAIL_DUP(voObj);
   		}
   	}
    public void NO_DUES(PrintVO voObj)
    {
    	PrintDAO.NO_DUES(voObj); 
    }
    
    public void OP_REF_REQ(PrintVO voObj)
    {
    	PrintDAO.OP_REF_REQ(voObj); 
    	PrintDAO.OP_REF_REQ1(voObj); 
    }
    
    /**
     * DAYEND_DTLS
     * @param voObj
     */
    public void DAYEND_DTLS(PrintVO voObj)
    {
    	PrintDAO.DAYEND_DTLS(voObj);
   		 
   	}
    
    
    /**
     * DAYEND_PAYMENT_DTLS
     * @param voObj
     */
    public void DAYEND_PAYMENT_DTLS(PrintVO voObj)
    {
    	PrintDAO.DAYEND_PAYMENT_DTLS(voObj);
   		 
   	}
    
    
    
    /**
     * method used to update the print status
     * @param voObj
     */
	public void UPDATE_PRINT_STATUS(PrintVO voObj) {

		
		PrintDAO.UPDATE_PRINT_STATUS(voObj);
				
		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOfflineTreatmentCategoryDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}	
    
	   /**
	 * get Counter & User Name 
	 * @author Amit Kumar
	 *
	 */
    
    public void getCounterAndUserName(PrintVO voObj)
    {
    	PrintDAO.getCounterAndUserName(voObj);     
	}
    
    public void CREDIT_NOTE(PrintVO voObj)
    {
		
    	PrintDAO.OPD_SERVICES(voObj);
    	if(voObj.getStrService().equals("1"))
    	{
    		PrintDAO.IPD_CREDIT_NOTE(voObj);
    	}else{
    		PrintDAO.CREDIT_NOTE(voObj);
    	}
    
    }
	
}
