package billing;

import billing.BillConfigUtil;

public class CashCollectionTransBO {

	/**
	 * method used to retrieve Counter Id 
	 * @param voObj
	 */
	public void checkCounterStatus(CashCollectionTransVO voObj){
		
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		
		CashCollectionTransDAO.getCounterId(voObj);
				
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
	public void getOnLineDetails(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getClientNameList(voObj);
		CashCollectionTransDAO.getPaymentModeList(voObj);
		CashCollectionTransDAO.getOnlineDetails(voObj);

				
		if (voObj.getStrMsgType().equals("1")) {
			String err = "CashCollectionTransBO.getOnLineDetails()-->"
					+ voObj.getStrMsgString();
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
	public void getOnLineTariffDetails(CashCollectionTransVO voObj) {

		if (voObj.getStrAccountNo() != null && !voObj.getStrAccountNo().equals("")) {

			CashCollectionTransDAO.getClientPatientNumber(voObj);

			if (voObj.getStrClientPatientNo() != null && !voObj.getStrClientPatientNo().equals("")) {

				CashCollectionTransDAO
						.getClientPatientDetailsWithClientPatNo(voObj);

			}

		}

		if (voObj.getStrClientPatientNo() != null && voObj.getStrClientPatientNo().equals("")) {

			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account
			if ((voObj.getStrChargeTypeId().equals("1") || voObj
					.getStrChargeTypeId().equals("3"))
					|| (voObj.getStrChargeTypeId().equals("2") && voObj
							.getStrBillingService().equals("19"))) {

				CashCollectionTransDAO.getClientPatientDetailsWithCrNo(voObj);
			}

		}
		// System.out.println("inside bo");
		CashCollectionTransDAO.getOnlineTariffDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOnLineTariffDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * initialize required off-line details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void initOffLineDetails(CashCollectionTransVO voObj) {

		
		CashCollectionTransDAO.getHospitalServiceList(voObj);
		CashCollectionTransDAO.getBillingServiceList(voObj);
		CashCollectionTransDAO.getRaisingDepartmentList(voObj);
		CashCollectionTransDAO.getEpisodeList(voObj);
		CashCollectionTransDAO.getTreatmentCategoryList(voObj);
		CashCollectionTransDAO.getWardList(voObj);
		CashCollectionTransDAO.getClientNameList(voObj);
		CashCollectionTransDAO.getPaymentModeList(voObj);

		
		/*
		 * CashCollectionTransDAO.getOffLineAccountNo(voObj);
		 * 
		 * if (!voObj.getStrOffLineAccountNo().equals("")) {
		 */

		if(voObj.getStrOffLineWard() != null && !voObj.getStrOffLineWard().trim().equals("")){
			String[] strWardDtls = voObj.getStrOffLineWard().replace("^", "#").split("#");
			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineClientType(strWardDtls[1]);
		}
		
		CashCollectionTransDAO.getOffLineClientPatientNumber(voObj);

		if (!voObj.getStrOffLineClientPatientHidden().equals("")) {

			String temp[] = voObj.getStrOffLineClientPatientHidden().replace(
					"^", "#").split("#");

			voObj.setStrOffLineClientPatientNo(temp[1]);
			voObj.setStrOffLineAccountNo(temp[2]);

			if (!voObj.getStrOffLineClientPatientNo().equals("")) {

				CashCollectionTransDAO
						.getOffLineClientPatientDetailsWithClientPatNo(voObj);

			}

		}

		if (voObj.getStrOffLineClientPatientNo().equals("")) {
			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account
			if ((voObj.getStrOffLineHospitalService().equals("1") || voObj
					.getStrOffLineHospitalService().equals("3"))
					|| (voObj.getStrOffLineHospitalService().equals("2") && voObj
							.getStrOffLineBillingService().equals("19"))) {

				CashCollectionTransDAO
						.getOffLineClientPatientDetailsWithCrNo(voObj);
			}

		}
		CashCollectionTransDAO.getApprovedBy(voObj);
		CashCollectionTransDAO.getRemarksList(voObj);
		CashCollectionTransDAO.getPartPaymentOrAdvanceAmount(voObj);

		CashCollectionTransDAO.getOffLineGroup(voObj);

		voObj.setStrOffLineIsPackageGroup("1");

		CashCollectionTransDAO.getOffLineGroup(voObj);
		CashCollectionTransDAO.getOffLineTariffList(voObj);

		CashCollectionTransDAO.getOffLineDiscountApprovalList(voObj);
		CashCollectionTransDAO.getOffLineDiscountRemarksList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.initOffLineDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves required off-line details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getOffLineClientDetails(CashCollectionTransVO voObj) {

		/*
		 * CashCollectionTransDAO.getOffLineAccountNo(voObj);
		 * 
		 * 
		 * if (!voObj.getStrOffLineAccountNo().equals("")) {
		 * 
		 * System.out.println(" Acc No : "+voObj.getStrOffLineAccountNo());
		 */

		CashCollectionTransDAO.getOffLineClientPatientNumber(voObj);

		if (!voObj.getStrOffLineClientPatientHidden().equals("")) {

			String temp[] = voObj.getStrOffLineClientPatientHidden().replace(
					"^", "#").split("#");

			voObj.setStrOffLineClientPatientNo(temp[1]);
			voObj.setStrOffLineAccountNo(temp[2]);

			if (!voObj.getStrOffLineClientPatientNo().equals("")) {

				CashCollectionTransDAO
						.getOffLineClientPatientDetailsWithClientPatNo(voObj);

			}

		}
		// }

		if (voObj.getStrOffLineClientPatientNo().equals("")) {
			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account
			if ((voObj.getStrOffLineHospitalService().equals("1") || voObj
					.getStrOffLineHospitalService().equals("3"))
					|| (voObj.getStrOffLineHospitalService().equals("2") && voObj
							.getStrOffLineBillingService().equals("19"))) {

				CashCollectionTransDAO
						.getOffLineClientPatientDetailsWithCrNo(voObj);
			}

		}

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOffLineClientDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Billing Service List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getBillServiceDetails(CashCollectionTransVO voObj) {
		CashCollectionTransDAO.getBillingServiceList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getBillServiceDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}

	/**
	 * retrieves Episode List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getEpisodeDetails(CashCollectionTransVO voObj) {
		CashCollectionTransDAO.getEpisodeList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getEpisodeDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}

	/**
	 * checks Whether PartPayment or Advance Part Exist. If Hospital Service is
	 * 2 (IPD) and Request Type is 1 (Receipt) and (Billing Service is 19 -
	 * Advance or 20 - Part Payment) then Part Payment or Advance Exist.
	 * 
	 * @param voObj -
	 *            Cash Collection Transaction Value Object
	 * @return true - if Part Payment or Advance Exist.<br>
	 *         false - if Part Payment or Advance Does Not Exist.
	 */
	public boolean isPartPaymentorAdvanceExist(CashCollectionTransVO voObj) {

		if (voObj.getStrOffLineHospitalService().equals("2")
				&& voObj.getStrOffLineRequestType().equals("1")
				&& (voObj.getStrOffLineBillingService().equals("19") || voObj
						.getStrOffLineBillingService().equals("20"))) {

			if (voObj.getStrMsgType().equals("1")) {

				String err = "CashCollectionTransBO.isPartPaymentorAdvanceExist()-->"
						+ voObj.getStrMsgString();

				voObj.setStrMsgString(err);
			}

			return true;
		} else {
			return false;
		}

	}

	/**
	 * retrieves Part Payment or Account Details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getPartPaymentOrAdvanceDtls(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getApprovedBy(voObj);
		CashCollectionTransDAO.getRemarksList(voObj);
		CashCollectionTransDAO.getPartPaymentOrAdvanceAmount(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getPartPaymentOrAdvanceDtls()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Billing Service List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getGroupDetails(CashCollectionTransVO voObj) {
		CashCollectionTransDAO.getOffLineGroup(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getGroupDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Tariff List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getTariffDetails(CashCollectionTransVO voObj) {
		CashCollectionTransDAO.getOffLineTariffList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getTariffDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}
	
	

	/**
	 * retrieves Tariff List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getTariffCodeDetails(CashCollectionTransVO voObj) {
		CashCollectionTransDAO.getOffLineTariffListByCode(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getTariffCodeDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}

	/**
	 * retrieves Tariff Unit List.
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineTariffUnitDetails(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOffLineTariffUnitDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Bill Details
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineBillDetails(CashCollectionTransVO voObj) {

		BillConfigUtil bcu = new BillConfigUtil(voObj.getStrHospitalCode());

		if (voObj.getStrOffLineHospitalService().equals("1")) {
			voObj.setStrOffLineRefundPenalty(bcu.getOpdRefundPenalty());

		} else if (voObj.getStrOffLineHospitalService().equals("2")) {
			voObj.setStrOffLineRefundPenalty(bcu.getIpdRefundPenalty());
		} else {
			voObj.setStrOffLineRefundPenalty(bcu.getEmergencyRefundPenalty());
		}

		CashCollectionTransDAO.getBillDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOffLineBillDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Bill Tariff Details
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineBillTariffDetails(CashCollectionTransVO voObj) {

		if (voObj.getStrOffLineHospitalService().equals("2")) {
			// System.out.println("Inside
			// getOffLineBillTariffDetails()BO-->getTariffDetails_Acc");
			CashCollectionTransDAO.getTariffDetails_Acc(voObj);
		} else {
			// System.out.println("Inside
			// getOffLineBillTariffDetails()BO-->getTariffDetails_NoAcc");
			CashCollectionTransDAO.getTariffDetails_NoAcc(voObj);
		}

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOffLineBillTariffDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Initialize Without Cr. No. Details
	 * 
	 * @param voObj
	 */
	public void initwithoutCrNoDetails(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getBillingServiceList(voObj);
		CashCollectionTransDAO.getRaisingDepartmentList(voObj);
		CashCollectionTransDAO.getOffLineGroup(voObj);
		CashCollectionTransDAO.getOffLineTariffList(voObj);
		CashCollectionTransDAO.getApprovedBy(voObj);
		CashCollectionTransDAO.getRemarksList(voObj);
		CashCollectionTransDAO.getRequestNoList(voObj);
		CashCollectionTransDAO.getClientNameList(voObj);
		CashCollectionTransDAO.getPaymentModeList(voObj);
		CashCollectionTransDAO.getGenderList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.initOffLineDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Initialize Without Cr. No. Bill Details
	 * 
	 * @param voObj
	 */
	public void initWithoutCrNoBillDetails(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getWithoutCrNoBillTariffDetails(voObj);
		CashCollectionTransDAO.getGenderList(voObj);
		CashCollectionTransDAO.getGuarantorDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.initWithoutCrNoBillDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}

	/**
	 * gets previous Cr No. Details
	 * 
	 * @param voObj
	 */
	public void getPreviousCrNoDtls(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getPreviousCrNoDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getPreviousCrNoDtls()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * gets Bill Listing Details
	 * 
	 * @param voObj
	 */
	public void getBillListingDtl(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getBillListingDtl_from_OutBound(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.initOffLineDetails()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * gets Admission Cancellation Details
	 * 
	 * @param voObj
	 */
	public void getAdmissionCancellationDtl(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getOffLineRefundAdvancePatAccDtls(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getAdmissionCancellationDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	
	public void getOfflineRaisingDepartmentDtl(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getRaisingDepartmentList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOfflineRaisingDepartmentDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	public void getOfflineTreatmentCategoryDtl(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getTreatmentCategoryList(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOfflineTreatmentCategoryDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	public void getOfflineWardDtl(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getWardList(voObj);

		if(voObj.getStrOffLineWard() != null && !voObj.getStrOffLineWard().trim().equals("")){
			String[] strWardDtls = voObj.getStrOffLineWard().replace("^", "#").split("#");
			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineClientType(strWardDtls[1]);
		}
		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getOfflineWardDtl()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	public void getWithoutCrNoOnlineReqTariffDtls(CashCollectionTransVO voObj) {

		CashCollectionTransDAO.getOnlineTariffDetails(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.getWithoutCrNoOnlineReqTariffDtls()-->"
					+ voObj.getStrMsgString();

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
	public void insertOnlineReceiptPartPayment(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlinePartPayment(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineReceiptPartPayment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	public void insertOnlineReceiptAdvance(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineAdvance(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineReceiptPartPayment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
	/**
	 * Inserts Online Receipt Services
	 * @param voObj
	 */
	public void insertOnlineReceiptServices(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineReceiptServices()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * Inserts Online Refund Services
	 * @param voObj
	 */
	public void insertOnlineRefundServices(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineRefundServices(voObj);

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
	public void insertOnlineRefundAdvance(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineRefundAdvance(voObj);

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
	public void insertOnlineFinalAdjustment(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineFinalAdjustment(voObj);

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
	public void insertOnlineReconciliation(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineReconcillation(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineFinalAdjustment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	

	/**
	 * Inserts Off-line Receipt Part Payment
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineReceiptPartPayment(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOfflinePartPayment(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOfflineReceiptPartPayment()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Inserts Off-line Receipt Advance
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineReceiptAdvance(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOfflineAdvance(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOfflineReceiptAdvance()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Inserts Off-line Receipt Service
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineReceiptService(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOfflineReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOfflineReceiptService()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Inserts Off-line Refund Services
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineRefundService(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOfflineRefundServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOfflineRefundService()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * Inserts Off-line Refund Admission Cancellation
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineRefundAdmissionCancellation(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOfflineRefundAdmissionCancellation(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOfflineRefundAdmissionCancellation()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * Insert's Without Cr. No. Receipt Services.
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertWithoutCrNoReceiptServices(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertWithoutCrNoReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertWithoutCrNoReceiptServices()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	/**
	 * Insert's Without Cr. No. Refund Services.
	 * Retrieves Module id, Group id, Unit id, Category Code and Hospital Service Details from Bill Configuration File
	 * @param voObj
	 */
	public void insertWithoutCrNoRefundServices(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);
		voObj.setStrOffLineTreatmentCategory(BillConfigUtil.NORMAL_CATEGORY);
		voObj.setStrOffLineHospitalService(BillConfigUtil.DEFAULT_HOSPITAL_SERVICE);
			
		voObj.setStrPreviousCrNo(voObj.getStrGuarantorHiddenVal().replace("^", "#").split("#")[7] );
		
		CashCollectionTransDAO.insertWithoutCrNoRefundServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertWithoutCrNoReceiptServices()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	public void insertOnlineWithoutCrNoReceiptServices(CashCollectionTransVO voObj) {

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionTransDAO.insertOnlineWithoutCrNoReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1")) {

			String err = "CashCollectionTransBO.insertOnlineWithoutCrNoReceiptServices()-->"
					+ voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	
}
