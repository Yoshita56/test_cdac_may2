package billing;

import billing.BillConfigUtil;

public class CashCollectionOnlineTransBO {

	/**
	 * method used to retrieve Counter Id 
	 * @param voObj
	 */
	public void checkCounterStatus(CashCollectionOnlineTransVO voObj){
		
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		
		CashCollectionOnlineTransDAO.getCounterId(voObj);
				
		if (voObj.getStrMsgType().equals("1")) {
			String err = "CashCollectionTransBO.checkCounterStatus()-->"
					+ voObj.getStrMsgString();
			voObj.setStrMsgString(err);

		}
		
	}
	
	
	/**
	 * retrieves required online details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getOnLineDetails(CashCollectionOnlineTransVO voObj) {

		//CashCollectionOnlineTransDAO.getClientNameList(voObj);
		CashCollectionOnlineTransDAO.getQRCodeModeList(voObj);
		CashCollectionOnlineTransDAO.getPaymentModeList(voObj);
		CashCollectionOnlineTransDAO.getOnlineDetails(voObj);
		CashCollectionOnlineTransDAO.getWalletDetails(voObj);
		//CashCollectionOnlineTransDAO.getRelations(voObj);

		if (voObj.getStrMsgType().equals("1")) 
		{
			String err = "CashCollectionTransBO.getOnLineDetails()-->"+ voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * The Client Details are retrieved using the following business logic.<br>
	 * If Account Number exists then get the Client Patient Number. If Client
	 * Patient Number exists get the Patient Details using Client Pat Number
	 * <br>
	 * 
	 * If Account Number Does not exists then check whether the Charge Type is
	 * OPD or Emergency then get the Patient Details using Cr Number.<br>
	 * 
	 * If the Charge Type is IPD then check whether its Billing Service is
	 * Account then get the Patient Details using Cr Number.
	 * 
	 * gets Tariff Details also
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getOnLineTariffDetails(CashCollectionOnlineTransVO voObj) 
	{
		if (voObj.getStrAccountNo() != null && !voObj.getStrAccountNo().equals("")) 
		{
			CashCollectionOnlineTransDAO.getClientPatientNumber(voObj);

			if (voObj.getStrClientPatientNo() != null && !voObj.getStrClientPatientNo().equals("")) 
			{
				CashCollectionOnlineTransDAO.getClientPatientDetailsWithClientPatNo(voObj);
			}
		}

		if (voObj.getStrClientPatientNo() != null && voObj.getStrClientPatientNo().equals("")) 
		{

			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account
			if ((voObj.getStrChargeTypeId().equals("1") || voObj.getStrChargeTypeId().equals("3"))|| 
				(voObj.getStrChargeTypeId().equals("2") && voObj.getStrBillingService().equals("19"))) 
			{
				CashCollectionOnlineTransDAO.getClientPatientDetailsWithCrNo(voObj);
			}

		}
		//in case of ipd get clientPatientNo from hblt_client_patient_dtl
		if (voObj.getStrClientPatientNo() != null && voObj.getStrClientPatientNo().length() == 0)
		{
			if (voObj.getStrChargeTypeId().equals("2"))//ipd
			{
				CashCollectionOnlineTransDAO.getClientPatientNumberCreditBillIpd(voObj);
			}					
		}
		
		CashCollectionOnlineTransDAO.getOnlineTariffDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) 
		{
			String err = "CashCollectionTransBO.getOnLineTariffDetails()-->"+ voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * Inserts Online Receipt Part Payment
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOnlineReceiptPartPayment(CashCollectionOnlineTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlinePartPayment(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineReceiptPartPayment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	public void insertOnlineReceiptAdvance(CashCollectionOnlineTransVO voObj) 
	{
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineAdvance(voObj);

		if (voObj.getStrMsgType().equals("1")) 
		{
			String err = "CashCollectionOnlineTransBO.insertOnlineReceiptAdvance()-->"+ voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}
	
	
	/**
	 * Inserts Online Receipt Services
	 * @param voObj
	 */
	public void insertOnlineReceiptServices(CashCollectionOnlineTransVO voObj) 
	{
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1")) 
		{
			String err = "CashCollectionTransBO.insertOnlineReceiptServices()-->"+ voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}
	
	/**
	 * Inserts Online Refund Services
	 * @param voObj
	 */
	public void insertOnlineRefundServices(CashCollectionOnlineTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineRefundServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineRefundServices()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * Inserts Online Refund Advance
	 * @param voObj
	 */
	public void insertOnlineRefundAdvance(CashCollectionOnlineTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineRefundAdvance(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineRefundAdvance()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
/**
 * Inserts Online Final Adjustment
 * @param voObj
 */
	public void insertOnlineFinalAdjustment(CashCollectionOnlineTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineFinalAdjustment(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineFinalAdjustment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * Inserts Online Reconciliation
	 * @param voObj
	 */
	public void insertOnlineReconciliation(CashCollectionOnlineTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOnlineTransDAO.insertOnlineReconcillation(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineFinalAdjustment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
}
