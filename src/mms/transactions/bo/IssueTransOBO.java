package mms.transactions.bo;

import mms.transactions.controller.fb.IssueTransOFB;
import mms.transactions.dao.IssueTransODAO;
import mms.transactions.vo.IssueTransOVO;

public class IssueTransOBO 
{
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(IssueTransOVO _OfflineIssueIndentTransVO)
	{		
		IssueTransODAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueTransOVO voObj){
		IssueTransODAO.GetData(voObj);
		IssueTransODAO.itemCategoryCombo1(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReturnFromTransBO.initForViewPage() --> "+ voObj.getStrMsgString());
		}
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(IssueTransOVO vo) {

		IssueTransODAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransOBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getImgHeader(IssueTransOVO voObj){
		IssueTransODAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IssueTransOBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

	
	public void getStoreDtls(IssueTransOVO voObj){
		
		IssueTransODAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(IssueTransOVO voObj)
     {
		
		IssueTransODAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(IssueTransOVO voObj)
        {
        IssueTransODAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueTransOBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(IssueTransOVO voObj){
		
		IssueTransODAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(IssueTransOVO voObj)
      {
		
		IssueTransODAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(IssueTransOVO voObj){
		
		IssueTransODAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(IssueTransOVO voObj){
		
		IssueTransODAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(IssueTransOVO voObj)
      {
		
		IssueTransODAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(IssueTransOVO voObj){
		
		IssueTransODAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(IssueTransOVO voObj){
		
		IssueTransODAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(IssueTransOVO voObj){
		
		IssueTransODAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(IssueTransOFB formBean, IssueTransOVO vo){
		
		IssueTransODAO.getOnlineTreatmentDtls(formBean,vo);
		//IssueTransODAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("IssueTransOBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(IssueTransOVO voObj){
		
		IssueTransODAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(IssueTransOVO voObj){
		
		IssueTransODAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(IssueTransOVO voObj){
		
		IssueTransODAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(IssueTransOVO voObj){
		
		IssueTransODAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	 public void insert(IssueTransOVO voObj)
	 {
		IssueTransODAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.insert()-->"+strErr);
		}
				
	  }
	
      public void inserttemp(IssueTransOVO voObj)
      {
		
		IssueTransODAO.inserttemp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.insert()-->"+strErr);
				}
				
		}
	
     public void insertipd(IssueTransOVO voObj)
     {
	   IssueTransODAO.insertipd(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransOBO.insert()-->"+strErr);
	   }
			
	}
     
     public void REPEAT_ISSUE_INSERT(IssueTransOVO voObj)
     {
	   IssueTransODAO.REPEAT_ISSUE_INSERT(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransOBO.REPEAT_ISSUE_INSERT()-->"+strErr);
	   }
			
	}
	
    public void insertWithoutCrNo(IssueTransOVO voObj)
	{
		
		IssueTransODAO.insertWithoutCrNo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.insertWithoutCrNo()-->"+strErr);
				}
				
		}
	
		public void getGenderCombo(IssueTransOVO voObj){
		
		IssueTransODAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransOBO.getGenderCombo()-->"+strErr);
				}
				
		}
				
		public void getPatientAddmissionFlag(IssueTransOVO voObj)
		{
			IssueTransODAO.getPatientAddmissionFlag(voObj);
			
		}
		
		public void getLFAccountDetail(IssueTransOVO voObj)
		{
			IssueTransODAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(IssueTransOVO vo)
		{
			IssueTransODAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransOBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(IssueTransOVO vo)
		{
			IssueTransODAO.getIcdList(vo);
			IssueTransODAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransOBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(IssueTransOVO _OfflineIssueIndentTransVO)
		{		
			IssueTransODAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void save(IssueTransOVO _OfflineIssueIndentTransVO)
		{		
			IssueTransODAO.save(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void deleteIssueDtls(IssueTransOVO _OfflineIssueIndentTransVO)
		{		
			IssueTransODAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(IssueTransOVO _OfflineIssueIndentTransVO)
		{		
			IssueTransODAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getAlreadyIssueDrug(IssueTransOFB formBean, IssueTransOVO _OfflineIssueIndentTransVO)
		{		
			IssueTransODAO.getAlreadyDrugIssue(formBean, _OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransOBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(IssueTransOVO voObj){
			
			IssueTransODAO.getStoreListBS(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransOBO.getStoreDtls()-->"+strErr);
					}
					
			}

		public void getPayMode(IssueTransOVO vo) {
			// TODO Auto-generated method stub
			IssueTransODAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueTransOBO.getStoreDtls()-->"+strErr);
			}
			
		}

		public void getReqType(IssueTransOVO vo) {
			// TODO Auto-generated method stub
				IssueTransODAO.getReqType(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueTransOBO.getReqType()-->"+strErr);
			}
		}
		public void directIssue(IssueTransOVO voObj){
			
			
			
			IssueTransODAO.directIssue(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransOBO.insert()-->"+strErr);
					}
					
			}
		
           public void getdeptname(IssueTransOVO voObj){
			
			
			
			IssueTransODAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransOBO.getdeptname()-->"+strErr);
					}
					
			}

		public void getEpisodeDetails(IssueTransOVO voObj) {
			// TODO Auto-generated method stub
			
			IssueTransODAO.getEpisodeDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransOBO.getEpisodeDtl()-->"+strErr);
					}
			
		}
		public void getPresFormDetails(IssueTransOVO voObj) {
			// TODO Auto-generated method stub
			
			IssueTransODAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransOBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(IssueTransOVO vo) {
			// TODO Auto-generated method stub
			IssueTransODAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("IssueTransOBO.getAccDtl()-->"+strErr);
					}
			
		}
		
		public void getLPRequestDetail(IssueTransOVO vo) 
		{
			
			IssueTransODAO.getIssuedItemDtlview(vo);			
			IssueTransODAO.getPatientAccountDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				vo.setStrMsgString("IssueTransOBO.getLPRequestDetail() --> "
						+ vo.getStrMsgString());
			}

		}
		
		/**
		 * This method is used to GET Issue Details
		 * 
		 * @param vo
		 */
		
		public void getCRViewDtl(IssueTransOVO voObj)
		{
			
			IssueTransODAO.getCRIssueDetail(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueTransOBO.getCRIssueDetail() --> "+ voObj.getStrMsgString());
			  }
			
		}
		
		/**
		 * To get the Recommend By
		 * 
		 * @param vo
		 */
		public void getRecommendName(IssueTransOVO vo)
		{
			IssueTransODAO.getRecommendName(vo);
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("IssueTransOBO.getRecommendName---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
		}
		
		/**
		 * To get Issue Item Details
		 * @param vo
		 */
		public void getItem_ALL_LIST(IssueTransOVO vo) {
			IssueTransODAO.getItem_ALL_LIST(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("IssueTransOBO.getItem_ALL_LIST() --> "
						+ vo.getStrMsgString());
			}

		}
		

}
