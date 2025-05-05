package mms.transactions.bo;

import mms.transactions.controller.fb.IssueTransFB;
import mms.transactions.dao.IssueDeskTransDAO;
import mms.transactions.dao.IssueTransDAO;
import mms.transactions.dao.NewIPDIssueToPatTransDAO;
import mms.transactions.dao.IssueTransDAO;
import mms.transactions.vo.IssueDeskTransVO;
import mms.transactions.vo.IssueTransVO;
import mms.transactions.vo.NewIPDIssueToPatTransVO;
import mms.transactions.vo.IssueTransVO;

public class IssueTransBO 
{
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(IssueTransVO _OfflineIssueIndentTransVO)
	{		
		IssueTransDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	public void getSingleBatchItemDtl(IssueTransVO vo) {

		IssueTransDAO.getSingleBatchItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getPatientTreatmentDetailfrmIpd(IssueTransVO voObj) 
	{

		try {
			    IssueTransDAO.getPatientTreatmentDetailfrmIpd(voObj);
			    IssueTransDAO.getPatientTreatmentHLPForIssue(voObj);			    
				if(voObj.getStrHospitalCode().equals("23921"))
				{	
					IssueTransDAO.getPatientDepartmentDtls(voObj);
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
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(IssueTransVO vo) {

		IssueTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	
	public void getStoreDtls(IssueTransVO voObj){
		
		IssueTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(IssueTransVO voObj)
     {
		
		IssueTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(IssueTransVO voObj)
        {
        IssueTransDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
      
        
	public void getItemCatDtls(IssueTransVO voObj){
		
		IssueTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(IssueTransVO voObj)
      {
		
		IssueTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(IssueTransVO voObj){
		
		IssueTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(IssueTransVO voObj){
		
		IssueTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(IssueTransVO voObj)
      {
		
		IssueTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(IssueTransVO voObj){
		
		IssueTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(IssueTransVO voObj){
		
		IssueTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(IssueTransVO voObj){
		
		IssueTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
       public void getFrontPageOnlineRequestDtls(IssueTransVO voObj)
       {
		
		IssueTransDAO.getFrontPageOnlineRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getFrontPageOnlineRequestDtls()-->"+strErr);
				}
				
		}
	
	
	
	
	public void getTreamentDtls(IssueTransFB formBean, IssueTransVO vo){
		
		IssueTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//IssueTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(IssueTransVO voObj){
		
		IssueTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(IssueTransVO voObj){
		
		IssueTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(IssueTransVO voObj){
		
		IssueTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(IssueTransVO voObj){
		
		IssueTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(IssueTransVO voObj){
		
		IssueTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(IssueTransVO voObj){
		
		IssueTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(IssueTransVO voObj){
		
		IssueTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(IssueTransVO voObj){
		
		IssueTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(IssueTransVO voObj){
		
		IssueTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	

		
        public void new_ipd_issue(IssueTransVO voObj)
        {		
			IssueTransDAO.new_ipd_issue(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{						
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.new_ipd_issue()-->"+strErr);
			}
				
		}
        
        public void insertipd(IssueTransVO voObj)
        {
	
		
		
			IssueTransDAO.insertipd(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
					}
				
		}
        
	
		public void getGenderCombo(IssueTransVO voObj){
		
		IssueTransDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
				
		public void getPatientAddmissionFlag(IssueTransVO voObj)
		{
			IssueTransDAO.getPatientAddmissionFlag(voObj);
			
		}
		
		public void getLFAccountDetail(IssueTransVO voObj)
		{
			IssueTransDAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(IssueTransVO vo)
		{
			IssueTransDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(IssueTransVO vo)
		{
			IssueTransDAO.getIcdList(vo);
			IssueTransDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(IssueTransVO _OfflineIssueIndentTransVO)
		{		
			IssueTransDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void deleteIssueDtls(IssueTransVO _OfflineIssueIndentTransVO)
		{		
			IssueTransDAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(IssueTransVO _OfflineIssueIndentTransVO)
		{		
			IssueTransDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getAlreadyIssueDrug(IssueTransFB formBean, IssueTransVO _OfflineIssueIndentTransVO)
		{		
			IssueTransDAO.getAlreadyDrugIssue(formBean, _OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void getStoreDtlsBS(IssueTransVO voObj){
			
			IssueTransDAO.getStoreListBS(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getStoreDtls()-->"+strErr);
					}
					
			}

		public void getPayMode(IssueTransVO vo) {
			// TODO Auto-generated method stub
			IssueTransDAO.getPaymentMode(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueTransBO.getStoreDtls()-->"+strErr);
			}
			
		}

		public void getReqType(IssueTransVO vo) {
			// TODO Auto-generated method stub
				IssueTransDAO.getReqType(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				
				String strErr = vo.getStrMsgString();
					
				vo.setStrMsgString("IssueTransBO.getReqType()-->"+strErr);
			}
		}
		
           public void getdeptname(IssueTransVO voObj){
			
			
			
			IssueTransDAO.getdeptname(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getdeptname()-->"+strErr);
					}
					
			}

		public void getEpisodeDetails(IssueTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueTransDAO.getEpisodeDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}
		public void getPresFormDetails(IssueTransVO voObj) {
			// TODO Auto-generated method stub
			
			IssueTransDAO.getPresFormDtl(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getEpisodeDtl()-->"+strErr);
					}
			
		}

		public void getAccDtl(IssueTransVO vo) {
			// TODO Auto-generated method stub
			IssueTransDAO.getAccountDtl(vo);
			if (vo.getStrMsgType().equals("1")) {
						
						String strErr = vo.getStrMsgString();
							
						vo.setStrMsgString("IssueTransBO.getAccDtl()-->"+strErr);
					}
			
		}
		
		/**
		 * Gets the stock item dtls init dtls.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls init dtls
		 */
		public void getStockItemDtlsInitDtls(IssueTransVO vo) {

			IssueTransDAO.getItemDtls(vo);
			IssueTransDAO.getStockItemDtlsList(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo
						.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
								+ strErr);

			}

		}
		
		/**
		 * Gets the stock item dtls init dtls.
		 * 
		 * @param vo the vo
		 * 
		 * @return the stock item dtls init dtls
		 */
		public void getNALIst(IssueTransVO vo) {

			IssueTransDAO.getNALIst(vo);		

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo
						.setStrMsgString("IssueTransBO.getNALIst() --> "
								+ strErr);

			}

		}
		
		
		/**
		 * Method is Used to Generate View page data 
		 * @param vo
		 */	
		public void initForViewPage(IssueTransVO voObj){
			IssueTransDAO.GetData(voObj);
			IssueTransDAO.itemCategoryCombo1(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueTransBO.initForViewPage() --> "+ voObj.getStrMsgString());
			}
		}
		
		
		/**
		 * This method is used to GET Issue Details
		 * 
		 * @param vo
		 */
		
		public void getCRViewDtl(IssueTransVO voObj)
		{
			
			IssueTransDAO.getCRIssueDetail(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueTransBO.getCRViewDtl() --> "+ voObj.getStrMsgString());
			  }
			
		}
		
		public void getImgHeader(IssueTransVO voObj){
			IssueTransDAO.getImageHeader(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("IssueTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
			  }
		}

}
