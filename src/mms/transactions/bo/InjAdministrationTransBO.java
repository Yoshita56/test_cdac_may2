package mms.transactions.bo;

import mms.transactions.controller.fb.InjAdministrationTransFB;
import mms.transactions.dao.InjAdministrationTransDAO;
import mms.transactions.vo.testVO;

public class InjAdministrationTransBO {
	
	
public void getStoreDtls(testVO voObj){
		
		InjAdministrationTransDAO.getStoreList(voObj);
		InjAdministrationTransDAO.getItemTypeCombo(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
	
	public void setViewPageDtl(testVO vo)
	{		
		InjAdministrationTransDAO.getIssueDetailTwo(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("InjAdministrationTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
		
	
	public void getPatientCRStatus(testVO voObj)
	{
		InjAdministrationTransDAO.getPatientCRStatus(voObj);
	}
		
	public void getPatientTreatmentDetailfrmIpd(testVO voObj) 
	{

		try {
			    InjAdministrationTransDAO.getPatientTreatmentDetailfrmIpd(voObj);
			    InjAdministrationTransDAO.getPatientTreatmentHLPForIssue(voObj);			    
				if(voObj.getStrHospitalCode().equals("23921"))
				{	
					InjAdministrationTransDAO.getPatientDepartmentDtls(voObj);
				}
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}
		} 
		catch (Exception e) 
		{

			voObj
					.setStrMsgString("RequestForLPPatientBO.getPatientTreatmentDetailfrmIpd() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		}

	}
	
	public void getImgHeader(testVO voObj){
		InjAdministrationTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IssueToPatOPDTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	
	/**
	 * Gets getDupDotMatrixVoucher.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getDupDotMatrixVoucher(testVO vo) {

		
		InjAdministrationTransDAO.getPrintIssueDtls(vo);	
		InjAdministrationTransDAO.getCRNO_PatientDtl(vo);		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueToPatOPDTransBO.getDupDotMatrixVoucher() --> "
							+ strErr);

		}

	}

	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(testVO vo) {

		InjAdministrationTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("InjAdministrationTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}	
	
	
     public void getStoreDtlsView(testVO voObj)
     {
		
		InjAdministrationTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
	public void getItemCatDtls(testVO voObj){
		
		InjAdministrationTransDAO.getItemCatDtls(voObj);
		InjAdministrationTransDAO.getItemBrandList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(testVO voObj)
      {
		
		InjAdministrationTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(testVO voObj){
		
		InjAdministrationTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(testVO voObj){
		
		InjAdministrationTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(testVO voObj)
      {
		
		InjAdministrationTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(testVO voObj){
		
		InjAdministrationTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(testVO voObj){
		
		InjAdministrationTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(testVO voObj){
		
		InjAdministrationTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(InjAdministrationTransFB formBean, testVO vo){
		
		InjAdministrationTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//InjAdministrationTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("InjAdministrationTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(testVO voObj){
		
		InjAdministrationTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	/*
	public void getDoseDetails(testVO voObj){
		
		InjAdministrationTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
		*/
	/*
	public void getFrequencyDetails(testVO voObj){
		
		InjAdministrationTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	*/
	public void getDeptDetails(testVO voObj){
		
		InjAdministrationTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(testVO voObj){
		
		InjAdministrationTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(testVO voObj){
		
		InjAdministrationTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(testVO voObj){
		
		InjAdministrationTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(testVO voObj){
		
		InjAdministrationTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	
	
	
        public void NEW_OPD_ISSUE_INSERT(testVO voObj)
        {		
			InjAdministrationTransDAO.NEW_OPD_ISSUE_INSERT(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{						
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("InjAdministrationTransBO.NEW_OPD_ISSUE_INSERT()-->"+strErr);
			}
				
		}
                      		
	
		public void getGenderCombo(testVO voObj){
		
		InjAdministrationTransDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("InjAdministrationTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
		
		/*
		public void getLFAccountDetail(testVO voObj)
		{
			InjAdministrationTransDAO.getLFAccountDetails(voObj);
		}
		*/
	
		public void getPatientDiagDetails(testVO vo)
		{
			InjAdministrationTransDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("InjAdministrationTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(testVO vo)
		{
			InjAdministrationTransDAO.getIcdList(vo);
			InjAdministrationTransDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("InjAdministrationTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getSingleBatchItemDtl(testVO vo) {

			InjAdministrationTransDAO.getSingleBatchItemDtl(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("InjAdministrationTransBO.getSingleBatchItemDtl() --> "
						+ vo.getStrMsgString());
			}
		}
		
		
		
		
		
		public void getAlreadyIssueDrug(InjAdministrationTransFB formBean, testVO vo)
		{		
			InjAdministrationTransDAO.getAlreadyDrugIssue(formBean, vo);
			if (vo.getStrMsgType().equals("1"))
			{
				vo.setStrMsgString("InjAdministrationTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(testVO voObj){
			
			InjAdministrationTransDAO.getStoreListBS(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("InjAdministrationTransBO.getStoreDtls()-->"+strErr);
					}
					
			}

		public void getPayMode(testVO vo) {
			// TODO Auto-generated method stub
			InjAdministrationTransDAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("InjAdministrationTransBO.getStoreDtls()-->"+strErr);
			}
			
		}

	
				
           public void getdeptname(testVO voObj){
			
			
			
			InjAdministrationTransDAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("InjAdministrationTransBO.getdeptname()-->"+strErr);
					}
					
			}

		
		public void getPresFormDetails(testVO voObj) {
			// TODO Auto-generated method stub
			
			InjAdministrationTransDAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("InjAdministrationTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(testVO vo) {
			// TODO Auto-generated method stub
			InjAdministrationTransDAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("InjAdministrationTransBO.getAccDtl()-->"+strErr);
					}
			
		}
		
				
		
				
		 public void getOPDPatientDtls(testVO voObj)
         {
			
			 InjAdministrationTransDAO.getOPDPatientDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("InjAdministrationTransDAO.getOPDPatientDtls()-->"+strErr);
					}
					
			}
		
	
		/*
		 * Method Used For Auto BATCH Selection
		 * 
		 * */				
		public void getPatientTreatmentHLPForIssue(testVO voObj)
		{
			InjAdministrationTransDAO.getPatientTreatmentHLPForIssue(voObj);
		}
		
		/*
		 * Method Used For Auto BATCH Selection
		 * 
		 * */				
		public void getPatientTreatmentHLP_AfterSave(testVO voObj)
		{
			InjAdministrationTransDAO.getPatientTreatmentHLP_AfterSave(voObj);
		}
		
		
		
		/*
		 * Method Used to save Injection Administrated Details
		 * 
		 * */				
		public void saveInjAdministratedDtl_Ajax(testVO voObj)
		{
			InjAdministrationTransDAO.saveInjAdministratedDtl_Ajax(voObj);
		}
		
		
		/*
		 * Method Used to get Injection Administrated Details
		 * 
		 * */				
		public void getInjAdministratedDtl_Ajax(testVO voObj)
		{
			InjAdministrationTransDAO.getInjAdministratedDtl_Ajax(voObj);
		}
		
		
		public void getAdministerModeCombo(testVO voObj)
	     {
			
			InjAdministrationTransDAO.getAdministerModeCombo(voObj);
		
			if (voObj.getStrMsgType().equals("1")) {
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("InjAdministrationTransBO.getAdministerModeCombo()-->"+strErr);
			}
					
		 }

}