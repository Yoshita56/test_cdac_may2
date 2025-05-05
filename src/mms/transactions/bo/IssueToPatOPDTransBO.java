package mms.transactions.bo;

import mms.transactions.controller.fb.IssueToPatOPDTransFB;
import mms.transactions.dao.IssueToPatOPDTransDAO;
import mms.transactions.vo.IssueToPatOPDTransVO;

public class IssueToPatOPDTransBO 
{
	public void getStoreDtls(IssueToPatOPDTransVO voObj)
	{
		
		IssueToPatOPDTransDAO.getIssueConfigFlag(voObj);
		IssueToPatOPDTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("IssueToPatOPDTransBO.getStoreDtls()-->"+strErr);
		}
				
	}
	
	public void getPatientCRStatus(IssueToPatOPDTransVO voObj)
	{
		IssueToPatOPDTransDAO.getPatientCRStatus(voObj);
	}
	public void setViewPageDtl(IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
	{		
		IssueToPatOPDTransDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(IssueToPatOPDTransVO vo) {

		IssueToPatOPDTransDAO.getIssueDtlsList(vo);		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueToPatOPDTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	/**
	 * Gets getDupDotMatrixVoucher.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getDupDotMatrixVoucher(IssueToPatOPDTransVO vo) {

		
		IssueToPatOPDTransDAO.getPrintIssueDtls(vo);	
		IssueToPatOPDTransDAO.getCRNO_PatientDtl(vo);		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueToPatOPDTransBO.getDupDotMatrixVoucher() --> "
							+ strErr);

		}

	}
	
     public void getStoreDtlsView(IssueToPatOPDTransVO voObj)
     {
		
		IssueToPatOPDTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(IssueToPatOPDTransVO voObj)
        {
        IssueToPatOPDTransDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getItemCatDtls(voObj);
		IssueToPatOPDTransDAO.getItemBrandList(voObj);		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(IssueToPatOPDTransVO voObj)
      {
		
    	  IssueToPatOPDTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}
		
      /* ==For View Page== */
	public void getItemCatDtls1(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(IssueToPatOPDTransVO voObj)
      {
		
		IssueToPatOPDTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(IssueToPatOPDTransFB formBean, IssueToPatOPDTransVO vo){
		
		IssueToPatOPDTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//IssueToPatOPDTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("IssueToPatOPDTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	public void insert(IssueToPatOPDTransVO voObj){
		
		
		
		IssueToPatOPDTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.insert()-->"+strErr);
				}
				
		}
	
	
		public void getGenderCombo(IssueToPatOPDTransVO voObj){
		
		IssueToPatOPDTransDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
				
		public void getPatientAddmissionFlag(IssueToPatOPDTransVO voObj)
		{
			IssueToPatOPDTransDAO.getPatientCRStatus(voObj);
		}
		
		public void getLFAccountDetail(IssueToPatOPDTransVO voObj)
		{
			IssueToPatOPDTransDAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(IssueToPatOPDTransVO vo)
		{
			IssueToPatOPDTransDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueToPatOPDTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(IssueToPatOPDTransVO vo)
		{
			IssueToPatOPDTransDAO.getIcdList(vo);
			IssueToPatOPDTransDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueToPatOPDTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatOPDTransDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void save(IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatOPDTransDAO.save(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void deleteIssueDtls(IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatOPDTransDAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatOPDTransDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getAlreadyIssueDrug(IssueToPatOPDTransFB formBean, IssueToPatOPDTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatOPDTransDAO.getAlreadyDrugIssue(formBean, _OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatOPDTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(IssueToPatOPDTransVO voObj)
		{
			
			IssueToPatOPDTransDAO.getStoreListBS(voObj);
			IssueToPatOPDTransDAO.getApprovedByCombo(voObj);
		
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getStoreDtls()-->"+strErr);
					}
					
		}

		public void getPayMode(IssueToPatOPDTransVO vo) {
			// TODO Auto-generated method stub
			IssueToPatOPDTransDAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueToPatOPDTransBO.getStoreDtls()-->"+strErr);
			}
			
		}

		public void getReqType(IssueToPatOPDTransVO vo) {
			// TODO Auto-generated method stub
				IssueToPatOPDTransDAO.getReqType(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueToPatOPDTransBO.getReqType()-->"+strErr);
			}
		}
		public void DIRECTISSUE_OFFLINE(IssueToPatOPDTransVO voObj){
			
			
			
			IssueToPatOPDTransDAO.DIRECTISSUE_OFFLINE(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.DIRECTISSUE_OFFLINE()-->"+strErr);
					}
					
			}
		
           public void insertDirectIssue(IssueToPatOPDTransVO voObj){
			
			
			
			IssueToPatOPDTransDAO.directIssue(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.insertDirectIssue()-->"+strErr);
					}
					
			}
		
		
		
           public void getOPDPatientDtls(IssueToPatOPDTransVO voObj)
           {
			
			IssueToPatOPDTransDAO.getOPDPatientDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getOPDPatientDtls()-->"+strErr);
					}
					
			}
           
           public void getdeptname(IssueToPatOPDTransVO voObj)
           {
			
			
			
			IssueToPatOPDTransDAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getdeptname()-->"+strErr);
					}
					
			}


		public void getEpisodeDetails(IssueToPatOPDTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueToPatOPDTransDAO.getEpisodeDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}
		public void getPresFormDetails(IssueToPatOPDTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueToPatOPDTransDAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatOPDTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(IssueToPatOPDTransVO vo) {
			// TODO Auto-generated method stub
			IssueToPatOPDTransDAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("IssueToPatOPDTransBO.getAccDtl()-->"+strErr);
					}
			
		}
		
		public void getImgHeader(IssueToPatOPDTransVO voObj){
			IssueToPatOPDTransDAO.getImageHeader(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueToPatOPDTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
			  }
		}
		
	
	/*
	 * public void logoHeader(IssueToPatOPDTransVO vo) { // TODO Auto-generated
	 * method stub IssueToPatOPDTransDAO.getlogoHeaderDtl(vo);
	 * 
	 * 
	 * if (vo.getStrMsgType().equals("1")) {
	 * 
	 * String strErr = vo.getStrMsgString();
	 * 
	 * vo.setStrMsgString("IssueToPatOPDTransBO.getAccDtl()-->"+strErr); }
	 * 
	 * }
	 */

}
