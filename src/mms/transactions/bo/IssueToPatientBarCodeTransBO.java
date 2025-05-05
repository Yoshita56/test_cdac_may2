package mms.transactions.bo;

import mms.transactions.controller.fb.IssueToPatientBarCodeTransFB;
import mms.transactions.dao.IssueToPatOPDTransDAO;
import mms.transactions.dao.IssueToPatientBarCodeTransDAO;
import mms.transactions.vo.IssueToPatOPDTransVO;
import mms.transactions.vo.IssueToPatientBarCodeTransVO;

public class IssueToPatientBarCodeTransBO {
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
	{		
		IssueToPatientBarCodeTransDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
    public void getItemBrandList(IssueToPatientBarCodeTransVO voObj){
		
		
    	IssueToPatientBarCodeTransDAO.getItemBrandList(voObj);		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemBrandList()-->"+strErr);
				}
				
		}
	
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IssueToPatientBarCodeTransVO voObj){
		IssueToPatientBarCodeTransDAO.GetData(voObj);
		IssueToPatientBarCodeTransDAO.itemCategoryCombo1(voObj);
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
	public void getIssueDtlsInitDtls(IssueToPatientBarCodeTransVO vo) {

		IssueToPatientBarCodeTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueToPatientBarCodeTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getImgHeader(IssueToPatientBarCodeTransVO voObj){
		IssueToPatientBarCodeTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

	
	public void getStoreDtls(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(IssueToPatientBarCodeTransVO voObj)
     {
		
		IssueToPatientBarCodeTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(IssueToPatientBarCodeTransVO voObj)
        {
        IssueToPatientBarCodeTransDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(IssueToPatientBarCodeTransVO voObj)
      {
		
		IssueToPatientBarCodeTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}
      
      public void getBarCodeDetails(IssueToPatientBarCodeTransVO voObj)
      {
		
		IssueToPatientBarCodeTransDAO.getBarCodeDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getBarCodeDetails()-->"+strErr);
				}
				
		}


	public void getItemCatDtls1(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(IssueToPatientBarCodeTransVO voObj)
      {
		
		IssueToPatientBarCodeTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(IssueToPatientBarCodeTransFB formBean, IssueToPatientBarCodeTransVO vo){
		
		IssueToPatientBarCodeTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//IssueToPatientBarCodeTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("IssueToPatientBarCodeTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	 public void insert(IssueToPatientBarCodeTransVO voObj)
	 {
		IssueToPatientBarCodeTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.insert()-->"+strErr);
		}
				
	  }
	
      public void inserttemp(IssueToPatientBarCodeTransVO voObj)
      {
		
		IssueToPatientBarCodeTransDAO.inserttemp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.insert()-->"+strErr);
				}
				
		}
	
     public void insertipd(IssueToPatientBarCodeTransVO voObj)
     {
	   IssueToPatientBarCodeTransDAO.insertipd(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueToPatientBarCodeTransBO.insert()-->"+strErr);
	   }
			
	}
     
     public void REPEAT_ISSUE_INSERT(IssueToPatientBarCodeTransVO voObj)
     {
	   IssueToPatientBarCodeTransDAO.REPEAT_ISSUE_INSERT(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueToPatientBarCodeTransBO.REPEAT_ISSUE_INSERT()-->"+strErr);
	   }
			
	}
	
    public void insertWithoutCrNo(IssueToPatientBarCodeTransVO voObj)
	{
		
		IssueToPatientBarCodeTransDAO.insertWithoutCrNo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.insertWithoutCrNo()-->"+strErr);
				}
				
		}
	
		public void getGenderCombo(IssueToPatientBarCodeTransVO voObj){
		
		IssueToPatientBarCodeTransDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
				
		public void getPatientAddmissionFlag(IssueToPatientBarCodeTransVO voObj)
		{
			IssueToPatientBarCodeTransDAO.getPatientAddmissionFlag(voObj);
			
		}
		
		public void getLFAccountDetail(IssueToPatientBarCodeTransVO voObj)
		{
			IssueToPatientBarCodeTransDAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(IssueToPatientBarCodeTransVO vo)
		{
			IssueToPatientBarCodeTransDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(IssueToPatientBarCodeTransVO vo)
		{
			IssueToPatientBarCodeTransDAO.getIcdList(vo);
			IssueToPatientBarCodeTransDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatientBarCodeTransDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void save(IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatientBarCodeTransDAO.save(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void deleteIssueDtls(IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatientBarCodeTransDAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatientBarCodeTransDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getAlreadyIssueDrug(IssueToPatientBarCodeTransFB formBean, IssueToPatientBarCodeTransVO _OfflineIssueIndentTransVO)
		{		
			IssueToPatientBarCodeTransDAO.getAlreadyDrugIssue(formBean, _OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueToPatientBarCodeTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(IssueToPatientBarCodeTransVO voObj){
			
			IssueToPatientBarCodeTransDAO.getStoreListBS(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getStoreDtls()-->"+strErr);
					}
					
			}

		public void getPayMode(IssueToPatientBarCodeTransVO vo) {
			// TODO Auto-generated method stub
			IssueToPatientBarCodeTransDAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getStoreDtls()-->"+strErr);
			}
			
		}

		public void getReqType(IssueToPatientBarCodeTransVO vo) {
			// TODO Auto-generated method stub
				IssueToPatientBarCodeTransDAO.getReqType(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getReqType()-->"+strErr);
			}
		}
		public void directIssue(IssueToPatientBarCodeTransVO voObj){
			
			
			
			IssueToPatientBarCodeTransDAO.directIssue(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.insert()-->"+strErr);
					}
					
			}
		
           public void getdeptname(IssueToPatientBarCodeTransVO voObj){
			
			
			
			IssueToPatientBarCodeTransDAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getdeptname()-->"+strErr);
					}
					
			}

		public void getEpisodeDetails(IssueToPatientBarCodeTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueToPatientBarCodeTransDAO.getEpisodeDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}
		public void getPresFormDetails(IssueToPatientBarCodeTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueToPatientBarCodeTransDAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(IssueToPatientBarCodeTransVO vo) {
			// TODO Auto-generated method stub
			IssueToPatientBarCodeTransDAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("IssueToPatientBarCodeTransBO.getAccDtl()-->"+strErr);
					}
			
		}
		
		public void getLPRequestDetail(IssueToPatientBarCodeTransVO vo) 
		{
			
			IssueToPatientBarCodeTransDAO.getIssuedItemDtlview(vo);			
			IssueToPatientBarCodeTransDAO.getPatientAccountDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getLPRequestDetail() --> "
						+ vo.getStrMsgString());
			}

		}
		
		/**
		 * This method is used to GET Issue Details
		 * 
		 * @param vo
		 */
		
		public void getCRViewDtl(IssueToPatientBarCodeTransVO voObj)
		{
			
			IssueToPatientBarCodeTransDAO.getCRIssueDetail(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueToPatientBarCodeTransBO.getCRIssueDetail() --> "+ voObj.getStrMsgString());
			  }
			
		}
		
		/**
		 * To get the Recommend By
		 * 
		 * @param vo
		 */
		public void getRecommendName(IssueToPatientBarCodeTransVO vo)
		{
			IssueToPatientBarCodeTransDAO.getRecommendName(vo);
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("IssueToPatientBarCodeTransBO.getRecommendName---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
		}
		
		/**
		 * To get Issue Item Details
		 * @param vo
		 */
		public void getItem_ALL_LIST(IssueToPatientBarCodeTransVO vo) {
			IssueToPatientBarCodeTransDAO.getItem_ALL_LIST(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("IssueToPatientBarCodeTransBO.getItem_ALL_LIST() --> "
						+ vo.getStrMsgString());
			}

		}
		

}
