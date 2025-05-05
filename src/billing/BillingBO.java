package billing;

import javax.sql.rowset.WebRowSet;

/**
 * 
 * @author Balasubramaniam M
 * 
 */

public class BillingBO {
	WebRowSet ws = null;

	@SuppressWarnings("static-access")
	public void getHeaderDetailsWS(BillingVO voObj) 
	{
		DAObilling dao = new DAObilling();
		{
			dao.getClientDtlProc(voObj);
		}
	}

	public void getClientDetails(BillingVO voObj)
	{
		DAObilling.getClientDtlProc(voObj);
	}

	public void getPatientDetails(BillingVO voObj) 
	{
		DAObilling.setPatientDtl(voObj);
	}
	
	public void getOnlineClientDetails(BillingVO voObj)
	{
		DAObilling.setOnlineClientDtl(voObj);
	}

	public void getOnLineReqDiscount(BillingVO voObj)
	{

		DAObilling.getOnLineReqDiscount(voObj);
	}

	public void getAccountDtlAcctNo(BillingVO voObj) 
	{
		DAOAccountDtl.getAccountDtlWithAcctNo(voObj);
	}

	public void getAllAmtForViewBill(BillingVO voObj)
	{
		DAOAccountDtl.getAllAmtForViewBill(voObj);
	}

	public void getRateDetails(BillingVO voObj) 
	{
		DAOParticularDtl.getRateDtl(voObj);
	}

	public void getTariffDtl(BillingVO voObj)
	{
		DAOTariffDtl.getTariffDtl(voObj);
	}
	public void getReceiptDetailsListing(BillingVO voObj) 
	{
		DAObilling.getReceiptDetailsListing(voObj);
    }
	public void getProcessUnProcessDtl(BillingVO voObj)
	{
		DAOUnProcessServiceDtl.getUnProcessServiceDtl(voObj);
	}

	public void getProcessServiceDtl(BillingVO voObj)
	{
		DAOProcessServiceDtl.getProcessServiceDtl(voObj);
	}

	public void getTariffUnitList(BillingVO voObj)
	{
		DAOProUnProUnitList.getTariffUnitList(voObj);
	}

	public void getAccountDtlPukNo(BillingVO voObj) 
	{
		DAOAccountDtl.getAccountDtlWithPukNo(voObj);
	}

	public void getOnLineRequestDtl(BillingVO voObj) 
	{
		// DAOOnLineReqDiscountDtl.getAccountDtlWithPukNo(voObj);
	}

	public void getApprovalDetails_Puk(BillingVO voObj) 
	{
		DAOClientApprovalDtl.setApprovalDtl_Puk(voObj);
	}

	public void getApprovalDetails_CltAppNo(BillingVO voObj)
	{
		DAOClientApprovalDtl.setApprovalDtl_AppNo(voObj);
	}

	public void getPartPaymentPendingReq(BillingVO voObj) 
	{
		DAOPartPymentPendingRequest.getPartPaymentPendingReq(voObj);
	}

	public void getParticularDtl(BillingVO voObj)
	{
		DAOParticularDtl.getParticularDtl(voObj);
	}

	public void getParticularDtlForBillApproval(BillingVO voObj)
    {
		DAOParticularDtlBillApproval.getParticularDtlForBillApprovals(voObj);
	}

	public void getChargeTariffDetails(BillingVO voObj) 
	{
		DAObilling.setTariffChargeDtl(voObj);
	}
	public void getChargeTariffDetails1(BillingVO voObj) 
	{
		DAObilling.setTariffChargeDtl1(voObj);
	}
	public void getChargeTariffDetails2(BillingVO voObj) 
	{
		DAObilling.setTariffChargeDtl2(voObj);
	}
	public void getStrTariffNameCombo(BillingVO voObj) 
	{
		DAObilling.getStrTariffNameCombo(voObj);
	}

	public void getOnLineReqDiscount(BillingVO voObj, String mode) 
	{
		DAObilling.getOnLineReqDiscount(voObj, mode);
	}

	//get online requests for credit billing approval
	public void getOnLineReqCreditBillApproval(BillingVO voObj, String mode) 
	{
		
		DAObilling.getOnLineReqCreditBillApproval(voObj, mode);
	}
	
	public void getPatientListingDtl(BillingVO voObj)
	{

		if (voObj.getStrValue1().equals("1")|| voObj.getStrValue1().equals("2")|| voObj.getStrValue1().equals("5")|| voObj.getStrValue1().equals("10")|| voObj.getStrValue1().equals("11")) 
		{
			DAObilling.setPatientListingDtl_from_InBound(voObj);
		} 
		else
		{
			DAObilling.setPatientListingDtl_from_OutBound(voObj);
		}
	}

	public void getCashCollectionDetail(BillingVO voObj) 
	{
		DAObilling.setcashCollectionDetail_from_OutBound(voObj);
	}
	public void getClientChargeTrfDtl(BillingVO voObj)
	{
		DAOParticularDtl.getClientChargeTrfDtl(voObj);
	}
	public void getRoomTrfDtl(BillingVO voObj)
	{
		DAOParticularDtl.getRoomTrfDtl(voObj);
	}
	public void getPackageDetails(BillingVO voObj) 
	{
		DAObilling.getPackageDetails(voObj);
	}
}
