package mms.transactions.bo;

import mms.transactions.controller.fb.OPDIssueToPatAutoTransFB;
import mms.transactions.dao.OPDIssueToPatAutoTransDAO;
import mms.transactions.vo.OPDIssueToPatAutoTransVO;

public class OPDIssueToPatAutoTransBO {
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(OPDIssueToPatAutoTransVO _OfflineIssueIndentTransVO)
	{		
		OPDIssueToPatAutoTransDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("OPDIssueToPatAutoTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	public void DIRECTISSUE_OFFLINE(OPDIssueToPatAutoTransVO voObj){
		
		
		
		OPDIssueToPatAutoTransDAO.DIRECTISSUE_OFFLINE(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.DIRECTISSUE_OFFLINE()-->"+strErr);
				}
				
		}
	
	
	public void getPatientCRStatus(OPDIssueToPatAutoTransVO voObj)
	{
		OPDIssueToPatAutoTransDAO.getPatientCRStatus(voObj);
	}
	
	public void getSingleBatchItemDtl(OPDIssueToPatAutoTransVO vo) {

		OPDIssueToPatAutoTransDAO.getSingleBatchItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("OPDIssueToPatAutoTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getPatientTreatmentDetailfrmIpd(OPDIssueToPatAutoTransVO voObj) 
	{

		try {
			    OPDIssueToPatAutoTransDAO.getPatientTreatmentDetailfrmIpd(voObj);
			    OPDIssueToPatAutoTransDAO.getPatientTreatmentHLPForIssue(voObj);			    
				if(voObj.getStrHospitalCode().equals("23921"))
				{	
					OPDIssueToPatAutoTransDAO.getPatientDepartmentDtls(voObj);
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
	
	public void getImgHeader(OPDIssueToPatAutoTransVO voObj){
		OPDIssueToPatAutoTransDAO.getImageHeader(voObj);
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
	public void getDupDotMatrixVoucher(OPDIssueToPatAutoTransVO vo) {

		
		OPDIssueToPatAutoTransDAO.getPrintIssueDtls(vo);	
		OPDIssueToPatAutoTransDAO.getCRNO_PatientDtl(vo);		
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
	public void getIssueDtlsInitDtls(OPDIssueToPatAutoTransVO vo) {

		OPDIssueToPatAutoTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("OPDIssueToPatAutoTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	
	public void getStoreDtls(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(OPDIssueToPatAutoTransVO voObj)
     {
		
		OPDIssueToPatAutoTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
	public void getItemCatDtls(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getItemCatDtls(voObj);
		OPDIssueToPatAutoTransDAO.getItemBrandList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(OPDIssueToPatAutoTransVO voObj)
      {
		
		OPDIssueToPatAutoTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(OPDIssueToPatAutoTransVO voObj)
      {
		
		OPDIssueToPatAutoTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(OPDIssueToPatAutoTransFB formBean, OPDIssueToPatAutoTransVO vo){
		
		OPDIssueToPatAutoTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//OPDIssueToPatAutoTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("OPDIssueToPatAutoTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	/*
	public void getDoseDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
		*/
	/*
	public void getFrequencyDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	*/
	public void getDeptDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	
	
        public void NEW_OPD_ISSUE_INSERT(OPDIssueToPatAutoTransVO voObj)
        {		
			OPDIssueToPatAutoTransDAO.NEW_OPD_ISSUE_INSERT(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{						
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("OPDIssueToPatAutoTransBO.NEW_OPD_ISSUE_INSERT()-->"+strErr);
			}
				
		}
                      		
	
		public void getGenderCombo(OPDIssueToPatAutoTransVO voObj){
		
		OPDIssueToPatAutoTransDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
		
		/*
		public void getLFAccountDetail(OPDIssueToPatAutoTransVO voObj)
		{
			OPDIssueToPatAutoTransDAO.getLFAccountDetails(voObj);
		}
		*/
	
		public void getPatientDiagDetails(OPDIssueToPatAutoTransVO vo)
		{
			OPDIssueToPatAutoTransDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("OPDIssueToPatAutoTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(OPDIssueToPatAutoTransVO vo)
		{
			OPDIssueToPatAutoTransDAO.getIcdList(vo);
			OPDIssueToPatAutoTransDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("OPDIssueToPatAutoTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(OPDIssueToPatAutoTransVO _OfflineIssueIndentTransVO)
		{		
			OPDIssueToPatAutoTransDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("OPDIssueToPatAutoTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void getTariffDtls(OPDIssueToPatAutoTransVO _OfflineIssueIndentTransVO)
		{		
			OPDIssueToPatAutoTransDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("OPDIssueToPatAutoTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getAlreadyIssueDrug(OPDIssueToPatAutoTransFB formBean, OPDIssueToPatAutoTransVO _OfflineIssueIndentTransVO)
		{		
			OPDIssueToPatAutoTransDAO.getAlreadyDrugIssue(formBean, _OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("OPDIssueToPatAutoTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(OPDIssueToPatAutoTransVO voObj){
			
			OPDIssueToPatAutoTransDAO.getStoreListBS(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getStoreDtls()-->"+strErr);
					}
					
			}

		public void getPayMode(OPDIssueToPatAutoTransVO vo) {
			// TODO Auto-generated method stub
			OPDIssueToPatAutoTransDAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("OPDIssueToPatAutoTransBO.getStoreDtls()-->"+strErr);
			}
			
		}

		public void getReqType(OPDIssueToPatAutoTransVO vo) {
			// TODO Auto-generated method stub
				OPDIssueToPatAutoTransDAO.getReqType(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("OPDIssueToPatAutoTransBO.getReqType()-->"+strErr);
			}
		}
				
           public void getdeptname(OPDIssueToPatAutoTransVO voObj){
			
			
			
			OPDIssueToPatAutoTransDAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getdeptname()-->"+strErr);
					}
					
			}

		public void getEpisodeDetails(OPDIssueToPatAutoTransVO voObj) {
			// TODO Auto-generated method stub
			
			OPDIssueToPatAutoTransDAO.getEpisodeDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}
		public void getPresFormDetails(OPDIssueToPatAutoTransVO voObj) {
			// TODO Auto-generated method stub
			
			OPDIssueToPatAutoTransDAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("OPDIssueToPatAutoTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(OPDIssueToPatAutoTransVO vo) {
			// TODO Auto-generated method stub
			OPDIssueToPatAutoTransDAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("OPDIssueToPatAutoTransBO.getAccDtl()-->"+strErr);
					}
			
		}
		
		/**
		 * Gets the stock item dtls init dtls.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls init dtls
		 */
		public void getStockItemDtlsInitDtls(OPDIssueToPatAutoTransVO vo) {

			OPDIssueToPatAutoTransDAO.getItemDtls(vo);
			OPDIssueToPatAutoTransDAO.getStockItemDtlsList(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo
						.setStrMsgString("OPDIssueToPatAutoTransBO.getStockItemDtlsInitDtls() --> "
								+ strErr);

			}

		}
		
		
				
		 public void getOPDPatientDtls(OPDIssueToPatAutoTransVO voObj)
         {
			
			 OPDIssueToPatAutoTransDAO.getOPDPatientDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("OPDIssueToPatAutoTransDAO.getOPDPatientDtls()-->"+strErr);
					}
					
			}
		
		/**
		 * Gets the stock item dtls init dtls.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls init dtls
		 */
		public void getNALIst(OPDIssueToPatAutoTransVO vo) {

			OPDIssueToPatAutoTransDAO.getNALIst(vo);		

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo
						.setStrMsgString("OPDIssueToPatAutoTransBO.getNALIst() --> "
								+ strErr);

			}

		}
		
		/*
		 * Method Used For Auto BATCH Selection
		 * 
		 * */				
		public void getPatientTreatmentHLPForIssue(OPDIssueToPatAutoTransVO voObj)
		{
			OPDIssueToPatAutoTransDAO.getPatientTreatmentHLPForIssue(voObj);
		}
		

}