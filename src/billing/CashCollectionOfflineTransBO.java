package billing;

import hisglobal.transactionmgnt.HisDAO;
import billing.BillConfigUtil;

public class CashCollectionOfflineTransBO
{

	/**
	 * method used to retrieve Counter Id 
	 * @param voObj
	 */
	public void checkCounterStatus(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);

		CashCollectionOfflineTransDAO.getCounterId(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.checkCounterStatus()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);

		}

	}

	public void preInitOffLineDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getHospitalServiceList(voObj);
		CashCollectionOfflineTransDAO.getBillingServiceList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.preInitOffLineDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * initialize required off-line details.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @throws Exception 
	 */
	public void initOffLineDetails(CashCollectionOfflineTransVO voObj) throws Exception
	{

		
		CashCollectionOfflineTransDAO dao=new CashCollectionOfflineTransDAO();
		CashCollectionOfflineTransDAO.getHospitalServiceList(voObj);
		CashCollectionOfflineTransDAO.getBillingServiceList(voObj);
		CashCollectionOfflineTransDAO.getQRCodeModeList(voObj);
		//CashCollectionOfflineTransDAO.getPaymentModeList(voObj);  // commented by manisha   for patient category and payment mode mapping
		
		CashCollectionOfflineTransDAO.getRaisingDepartmentList(voObj);
		CashCollectionOfflineTransDAO.getAdmEpisodeTreatmentCatDtl(voObj);//GETS ADMITTED DEPT,CAT,EPISODE,VISIT IF IPD OTHERWISE LAST VISITED DEPT,TREAT CAT IF PRESENT OTHERWISE PAT CAT, EPISODE,VISIT
		//Commented By Amit Kumar Ateria .This Logic implemented in method getAdmEpisodeTreatmentCatDtl.Admitted Department/Last Visited Department
		//CashCollectionOfflineTransDAO.getRaisingDepartment(voObj);
		//end
		CashCollectionOfflineTransDAO.getEpisodeListCombo(voObj);//MAY BE COMMENTED BECAUSE ONLY ONE EPSIODE IS COMING
		CashCollectionOfflineTransDAO.getTreatmentCategoryList(voObj);	
		CashCollectionOfflineTransDAO.getWardList(voObj);
		CashCollectionOfflineTransDAO.getSplWardList(voObj);
		
		CashCollectionOfflineTransDAO.getClientNameList(voObj);
		
		
		dao.getWaivedBy(voObj);//For Waiver Details

		if (voObj.getStrOffLineWard() != null && !voObj.getStrOffLineWard().trim().equals(""))
		{
			String[] strWardDtls = voObj.getStrOffLineWard().replace("^", "#").split("#");
			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineClientType(strWardDtls[1]);
		}

		CashCollectionOfflineTransDAO.getOffLineClientPatientNumber(voObj);

		if (!voObj.getStrOffLineClientPatientHidden().equals(""))
		{

			String temp[] = voObj.getStrOffLineClientPatientHidden().replace("^", "#").split("#");

			voObj.setStrOffLineClientPatientNo(temp[1]);
			voObj.setStrOffLineAccountNo(temp[2]);
			voObj.setStrOffLineWard(temp[4]);
			//voObj.setStrOffLineSpecialWard(temp[5]);  commented by ajay to get ward name after admission and before acceptance
			voObj.setStrOffLineTreatmentCategory(temp[6]);
			voObj.setStrOffLineRaisingDepartment(temp[7]);

			if (!voObj.getStrOffLineClientPatientNo().equals(""))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithClientPatNo(voObj);

			}

		}

		if (voObj.getStrOffLineClientPatientNo().equals(""))
		{
			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account

			if ((voObj.getStrOffLineHospitalService().equals("1") || voObj.getStrOffLineHospitalService().equals("3")) || (voObj
					.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineBillingService().equals("19")))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithCrNo(voObj);
			}

		}

		//IPD, Advance/Part Payment , Refund
		if (voObj.getStrOffLineHospitalService().equals("2") && (voObj.getStrOffLineBillingService().equals("19") || voObj.getStrOffLineBillingService().equals("20") ) && voObj.getStrOffLineRequestType().equals("2"))
		{
			CashCollectionOfflineTransDAO.getAdvanceDtls(voObj);
		}
		
		if (voObj.getStrOffLineRequestType().equals("2"))
		{
			CashCollectionOfflineTransDAO.getApprovedBy(voObj);
			CashCollectionOfflineTransDAO.getRemarksList(voObj);			
		}

		//CashCollectionOfflineTransDAO.getOffLineGroup(voObj);

		if (voObj.getStrClerkDiscount().equals("1"))
		{
			CashCollectionOfflineTransDAO.getOffLineDiscountApprovalList(voObj);
			CashCollectionOfflineTransDAO.getOffLineDiscountRemarksList(voObj);
		}
		/*if(voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#").length>=2 && (voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("3") || voObj.getStrOffLineTreatmentCategory().replace("^","#").split("#")[1].equals("4")))
			CashCollectionOfflineTransDAO.getCreditLettersList(voObj);*/
		CashCollectionOfflineTransDAO.getWalletDetails(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.initOffLineDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
		CashCollectionOfflineTransDAO.getPaymentModeListByPatCategory(voObj);   // added by manisha   for patient category and payment mode mapping

	}
	
	/**
	 * initialize required off-line details.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @throws Exception 
	 */
	public void initAdvanceOffLineDetails(CashCollectionOfflineTransVO voObj) throws Exception
	{

		
		CashCollectionOfflineTransDAO dao=new CashCollectionOfflineTransDAO();
		CashCollectionOfflineTransDAO.getHospitalServiceListBasedOnVisit(voObj);
		CashCollectionOfflineTransDAO.getBillingServiceListExcludingIpdAdvance(voObj);
		CashCollectionOfflineTransDAO.getQRCodeModeList(voObj);
		//CashCollectionOfflineTransDAO.getPaymentModeList(voObj);
		
		CashCollectionOfflineTransDAO.getSplWardList(voObj);
		CashCollectionOfflineTransDAO.getRaisingDepartmentList(voObj);
		CashCollectionOfflineTransDAO.getAdmEpisodeTreatmentCatDtl(voObj);//GETS ADMITTED DEPT,CAT,EPISODE,VISIT IF IPD OTHERWISE LAST VISITED DEPT,TREAT CAT IF PRESENT OTHERWISE PAT CAT, EPISODE,VISIT
		//Commented By Amit Kumar Ateria .This Logic implemented in method getAdmEpisodeTreatmentCatDtl.Admitted Department/Last Visited Department
		//CashCollectionOfflineTransDAO.getRaisingDepartment(voObj);
		//end
		CashCollectionOfflineTransDAO.getEpisodeListCombo(voObj);//MAY BE COMMENTED BECAUSE ONLY ONE EPSIODE IS COMING
		CashCollectionOfflineTransDAO.getTreatmentCategoryList(voObj);	
		CashCollectionOfflineTransDAO.getWardList(voObj);
		

		CashCollectionOfflineTransDAO.getClientNameList(voObj);
		
		
		dao.getWaivedBy(voObj);//For Waiver Details

		if (voObj.getStrOffLineWard() != null && !voObj.getStrOffLineWard().trim().equals(""))
		{
			String[] strWardDtls = voObj.getStrOffLineWard().replace("^", "#").split("#");
			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineClientType(strWardDtls[1]);
		}

		CashCollectionOfflineTransDAO.getOffLineClientPatientNumber(voObj);

		if (!voObj.getStrOffLineClientPatientHidden().equals(""))
		{

			String temp[] = voObj.getStrOffLineClientPatientHidden().replace("^", "#").split("#");

			voObj.setStrOffLineClientPatientNo(temp[1]);
			voObj.setStrOffLineAccountNo(temp[2]);
			voObj.setStrOffLineWard(temp[4]);
			voObj.setStrOffLineSpecialWard(temp[5]);
			voObj.setStrOffLineTreatmentCategory(temp[6]);
			voObj.setStrOffLineRaisingDepartment(temp[7]);

			if (!voObj.getStrOffLineClientPatientNo().equals(""))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithClientPatNo(voObj);

			}

		}

		if (voObj.getStrOffLineClientPatientNo().equals(""))
		{
			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account

			if ((voObj.getStrOffLineHospitalService().equals("1") || voObj.getStrOffLineHospitalService().equals("3")) || (voObj
					.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineBillingService().equals("19")))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithCrNo(voObj);
			}

		}

		if (voObj.getStrOffLineRequestType().equals("2"))
		{

			CashCollectionOfflineTransDAO.getApprovedBy(voObj);
			CashCollectionOfflineTransDAO.getRemarksList(voObj);

		}

		//CashCollectionOfflineTransDAO.getOffLineGroup(voObj);

		if (voObj.getStrClerkDiscount().equals("1"))
		{

			CashCollectionOfflineTransDAO.getOffLineDiscountApprovalList(voObj);
			CashCollectionOfflineTransDAO.getOffLineDiscountRemarksList(voObj);

		}
		//CashCollectionOfflineTransDAO.getCreditLettersList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.initOffLineDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
		
		CashCollectionOfflineTransDAO.getPaymentModeListByPatCategory(voObj);   // added by manisha   for patient category and payment mode mapping
		
	}
	

	/**
	 * retrieves required off-line details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getOffLineClientDetails(CashCollectionOfflineTransVO voObj)
	{

		/*
		 * CashCollectionOfflineTransDAO.getOffLineAccountNo(voObj);
		 * 
		 * 
		 * if (!voObj.getStrOffLineAccountNo().equals("")) {
		 * 
		 * System.out.println(" Acc No : "+voObj.getStrOffLineAccountNo());
		 */

		CashCollectionOfflineTransDAO.getOffLineClientPatientNumber(voObj);

		if (!voObj.getStrOffLineClientPatientHidden().equals(""))
		{

			String temp[] = voObj.getStrOffLineClientPatientHidden().replace("^", "#").split("#");

			voObj.setStrOffLineClientPatientNo(temp[1]);
			voObj.setStrOffLineAccountNo(temp[2]);
			voObj.setStrOffLineWard(temp[4]);
			voObj.setStrOffLineSpecialWard(temp[5]);
			voObj.setStrOffLineTreatmentCategory(temp[6]);
			voObj.setStrOffLineRaisingDepartment(temp[7]);

			if (!voObj.getStrOffLineClientPatientNo().equals(""))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithClientPatNo(voObj);

			}

		}
		// }

		if (voObj.getStrOffLineClientPatientNo().equals(""))
		{
			// 1 - OPD , 2- IPD , 3 - Emergency & 19 - Account
			if ((voObj.getStrOffLineHospitalService().equals("1") || voObj.getStrOffLineHospitalService().equals("3")) || (voObj
					.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineBillingService().equals("19")))
			{

				CashCollectionOfflineTransDAO.getOffLineClientPatientDetailsWithCrNo(voObj);
			}

		}

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOffLineClientDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Billing Service List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getBillServiceDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getBillingServiceList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getBillServiceDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}
	

	/**
	 * retrieves Episode List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getEpisodeDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getEpisodeList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getEpisodeDetails()-->" + voObj.getStrMsgString();

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
	public boolean isPartPaymentorAdvanceExist(CashCollectionOfflineTransVO voObj)
	{

		if (voObj.getStrOffLineHospitalService().equals("2") && voObj.getStrOffLineRequestType().equals("1") && (voObj
				.getStrOffLineBillingService().equals("19") || voObj.getStrOffLineBillingService().equals("20")))
		{

			if (voObj.getStrMsgType().equals("1"))
			{

				String err = "CashCollectionTransBO.isPartPaymentorAdvanceExist()-->" + voObj.getStrMsgString();

				voObj.setStrMsgString(err);
			}

			return true;
		} else
		{
			return false;
		}

	}

	/**
	 * retrieves Part Payment or Account Details.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getPartPaymentOrAdvanceDtls(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getApprovedBy(voObj);
		CashCollectionOfflineTransDAO.getRemarksList(voObj);
		CashCollectionOfflineTransDAO.getPartPaymentOrAdvanceAmount(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getPartPaymentOrAdvanceDtls()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * gets Admission Cancellation Details
	 * 
	 * @param voObj
	 */
	public void getAdmissionCancellationDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getOffLineRefundAdvancePatAccDtls(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getAdmissionCancellationDtl()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Billing Service List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getGroupDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getOffLineGroup(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getGroupDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Tariff List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getTariffDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getOffLineTariffList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.getTariffDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}
	
	
	public void getTariffCodeDetailsDrug(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getOffLineTariffListByCodeD(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.getTariffDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * retrieves Tariff List.
	 * 
	 * @param voObj -
	 *            Value Object
	 */
	public void getTariffCodeDetails(CashCollectionOfflineTransVO voObj)
	{
		CashCollectionOfflineTransDAO.getOffLineTariffListByCode(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.getTariffCodeDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * retrieves Tariff Unit List.
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineTariffUnitDetails(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getOffLineTariffUnitList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOffLineTariffUnitDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Bill Details
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineBillDetails(CashCollectionOfflineTransVO voObj)
	{

		BillConfigUtil bcu = new BillConfigUtil(voObj.getStrHospitalCode());

		if (voObj.getStrOffLineHospitalService().equals("1"))
		{
			voObj.setStrOffLineRefundPenalty(bcu.getOpdRefundPenalty());

		} else if (voObj.getStrOffLineHospitalService().equals("2"))
		{
			voObj.setStrOffLineRefundPenalty(bcu.getIpdRefundPenalty());
		} else
		{
			voObj.setStrOffLineRefundPenalty(bcu.getEmergencyRefundPenalty());
		}

		CashCollectionOfflineTransDAO.getBillDetails(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOffLineBillDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	public void getOffLinePartPayBillDetails(CashCollectionOfflineTransVO voObj)
	{

		BillConfigUtil bcu = new BillConfigUtil(voObj.getStrHospitalCode());

		if (voObj.getStrOffLineHospitalService().equals("1"))
		{
			voObj.setStrOffLineRefundPenalty(bcu.getOpdRefundPenalty());

		} else if (voObj.getStrOffLineHospitalService().equals("2"))
		{
			voObj.setStrOffLineRefundPenalty(bcu.getIpdRefundPenalty());
		} else
		{
			voObj.setStrOffLineRefundPenalty(bcu.getEmergencyRefundPenalty());
		}

		CashCollectionOfflineTransDAO.getPartPayBillDetails(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOffLineBillDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	/**
	 * retrieves Bill Tariff Details
	 * 
	 * @param voObj -
	 *            Value Object.
	 */
	public void getOffLineBillTariffDetails(CashCollectionOfflineTransVO voObj)
	{
		if (voObj.getStrOffLineHospitalService().equals("2"))//IPD
		{
			CashCollectionOfflineTransDAO.getTariffDetails_Acc(voObj);
		} 
		else
		{
			CashCollectionOfflineTransDAO.getTariffDetails_NoAcc(voObj);
		}
		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.getOffLineBillTariffDetails()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}
	}

	/**
	 * gets Bill Listing Details
	 * 
	 * @param voObj
	 */
	public void getBillListingDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getBillListingDtl_from_OutBound(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.initOffLineDetails()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	public void getOfflineRaisingDepartmentDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getRaisingDepartmentList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOfflineRaisingDepartmentDtl()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	public void getOfflineTreatmentCategoryDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getTreatmentCategoryList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOfflineTreatmentCategoryDtl()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	public void getOfflineWardDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getWardList(voObj);

		if (voObj.getStrOffLineWard() != null && !voObj.getStrOffLineWard().trim().equals(""))
		{
			String[] strWardDtls = voObj.getStrOffLineWard().replace("^", "#").split("#");
			voObj.setStrOffLineWard(strWardDtls[0]);
			voObj.setStrOffLineClientType(strWardDtls[1]);
		}
		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOfflineWardDtl()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}

	public void getOfflineSpecialWardDtl(CashCollectionOfflineTransVO voObj)
	{

		CashCollectionOfflineTransDAO.getSplWardList(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getOfflineWardDtl()-->" + voObj.getStrMsgString();

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
	public void insertOfflineReceiptPartPayment(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOfflinePartPayment(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOfflineReceiptPartPayment()-->" + voObj.getStrMsgString();

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
	public void insertOfflineReceiptAdvance(CashCollectionOfflineTransVO voObj)
	{
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);
		
		CashCollectionOfflineTransDAO.getpataccno(voObj);
		//System.out.println("voObj.setStrOffLineAccountNo"+voObj.getStrOffLineAccountNo());
		if (!voObj.getStrOffLineAccountNo().equals("0"))
		{
			voObj.setStrMsgType("1");
			voObj.setStrMsgString("Account Already Opened/Advance Collected. Multiple Accounts cannot be opened");
		}
		else
		{
			HisDAO dao = new HisDAO("BillING", "CashCollectionOfflineTransDAO.insertOfflineAdvance");
			CashCollectionOfflineTransDAO.insertOfflineAdvance(voObj,dao,true);
		}

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.insertOfflineReceiptAdvance()-->" + voObj.getStrMsgString();
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
	public void insertOfflineReceiptService(CashCollectionOfflineTransVO voObj)
	{
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		if (voObj.getStrIsAdvanceRequired().equals("0") && voObj.getStrOffLineHospitalService().equals("2") && 
			voObj.getStrOffLineBillingService().equals("10") && (voObj.getStrOffLineAccountNo() == null || voObj.getStrOffLineAccountNo().equals("0")))
		{
			voObj = CashCollectionOfflineTransDAO.openZeroBalanceAccount(voObj);
		}
		CashCollectionOfflineTransDAO.insertOfflineReceiptServices(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.insertOfflineReceiptService()-->" + voObj.getStrMsgString();
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
	public void insertOfflineRefundService(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOfflineRefundServices(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOfflineRefundService()-->" + voObj.getStrMsgString();

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
	public void insertOfflineRefundAdmissionCancellation(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOfflineRefundAdmissionCancellation(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOfflineRefundAdmissionCancellation()-->" + voObj.getStrMsgString();

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
	public void insertOfflineRefundPartPayment(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOfflineRefundPartPayment(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOfflineRefundAdmissionCancellation()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	
	 /* Inserts Off-line Estimation
	 * 
	 * Retrieves Module id, Group id and Unit id Details from Bill Configuration File
	 * 
	 * @param voObj
	 */
	public void insertOfflineEstimation(CashCollectionOfflineTransVO voObj)
	{
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		if (voObj.getStrIsAdvanceRequired().equals("0") && voObj.getStrOffLineHospitalService().equals("2") && 
			voObj.getStrOffLineBillingService().equals("10") && (voObj.getStrOffLineAccountNo() == null || voObj.getStrOffLineAccountNo().equals("0")))
		{
			voObj = CashCollectionOfflineTransDAO.openZeroBalanceAccount(voObj);
		}
		CashCollectionOfflineTransDAO.insertOfflineEstimation(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{
			String err = "CashCollectionTransBO.insertOfflineReceiptService()-->" + voObj.getStrMsgString();
			voObj.setStrMsgString(err);
		}

	}
	public void getBillingPackageNames(CashCollectionOfflineTransVO VO) {
		CashCollectionOfflineTransDAO.getBillingPackageNames(VO);
		if (VO.getStrMsgType().equals("1")) 
			VO.setStrMsgString(" CashCollectionTransBO.getBillingPackageNames() --> "
					+ VO.getStrMsgString());
	}
	public void insertOfflineReceiptPackage(CashCollectionOfflineTransVO voObj)
	{

		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOfflinePackage(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOfflineReceiptPartPayment()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}

	}
	public void getAdvanceDtls(CashCollectionOfflineTransVO vo) {
		// TODO Auto-generated method stub
		

		CashCollectionOfflineTransDAO.getAdvanceDtls(vo);
	}

	public void getAccountCategory(CashCollectionOfflineTransVO vo) {
		// TODO Auto-generated method stub
		CashCollectionOfflineTransDAO.getAccountCategory(vo);
	}

	public void insertOnlyCatChange(CashCollectionOfflineTransVO voObj) {
		// TODO Auto-generated method stub
		voObj.setStrModuleId(BillConfigUtil.BILL_MODULE_ID);
		voObj.setStrGroupId(BillConfigUtil.GROUP_ID_DEPOSIT);
		voObj.setStrQtyUnitId(BillConfigUtil.DEFAULT_UNIT_ID);

		CashCollectionOfflineTransDAO.insertOnlyCatChange(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.insertOnlyCatChange()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}

	
	
	
	public void getPaymentModeListByPatCategory(CashCollectionOfflineTransVO voObj) throws Exception
	{
		CashCollectionOfflineTransDAO.getPaymentModeListByPatCategory(voObj);

		if (voObj.getStrMsgType().equals("1"))
		{

			String err = "CashCollectionTransBO.getPaymentModeListByPatCategory()-->" + voObj.getStrMsgString();

			voObj.setStrMsgString(err);
		}
	}
}
