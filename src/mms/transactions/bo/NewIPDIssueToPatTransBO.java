package mms.transactions.bo;

import mms.transactions.controller.fb.NewIPDIssueToPatTransFB;
import mms.transactions.dao.NewIPDIssueToPatTransDAO;
import mms.transactions.vo.NewIPDIssueToPatTransVO;

public class NewIPDIssueToPatTransBO {
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(NewIPDIssueToPatTransVO vo)
	{		
		NewIPDIssueToPatTransDAO.getIssueDetailTwo(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
    public void getItemBrandList(NewIPDIssueToPatTransVO voObj){
		
		
    	NewIPDIssueToPatTransDAO.getItemBrandList(voObj);		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemBrandList()-->"+strErr);
				}
				
		}
	
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(NewIPDIssueToPatTransVO voObj){
		NewIPDIssueToPatTransDAO.GetData(voObj);
		NewIPDIssueToPatTransDAO.itemCategoryCombo1(voObj);
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
	public void getIssueDtlsInitDtls(NewIPDIssueToPatTransVO vo) {

		NewIPDIssueToPatTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("NewIPDIssueToPatTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getImgHeader(NewIPDIssueToPatTransVO voObj){
		NewIPDIssueToPatTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("NewIPDIssueToPatTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

	
	public void getStoreDtls(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(NewIPDIssueToPatTransVO voObj)
     {
		
		NewIPDIssueToPatTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(NewIPDIssueToPatTransVO voObj)
        {
        NewIPDIssueToPatTransDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("NewIPDIssueToPatTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(NewIPDIssueToPatTransVO voObj)
      {
		
		NewIPDIssueToPatTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(NewIPDIssueToPatTransVO voObj)
      {
		
		NewIPDIssueToPatTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(NewIPDIssueToPatTransFB formBean, NewIPDIssueToPatTransVO vo){
		
		NewIPDIssueToPatTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//NewIPDIssueToPatTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("NewIPDIssueToPatTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	 public void insert(NewIPDIssueToPatTransVO voObj)
	 {
		NewIPDIssueToPatTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
		}
				
	  }
	
      	
     public void insertipd(NewIPDIssueToPatTransVO voObj)
     {
	   NewIPDIssueToPatTransDAO.insertipd(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
	   }
			
	}
     
     public void REPEAT_ISSUE_INSERT(NewIPDIssueToPatTransVO voObj)
     {
	   NewIPDIssueToPatTransDAO.REPEAT_ISSUE_INSERT(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.REPEAT_ISSUE_INSERT()-->"+strErr);
	   }
			
	}
	
	
	public void getGenderCombo(NewIPDIssueToPatTransVO voObj){
	
	NewIPDIssueToPatTransDAO.getGenderCombo(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.getGenderCombo()-->"+strErr);
			}
			
	}
			
	public void getPatientAddmissionFlag(NewIPDIssueToPatTransVO voObj)
	{
		NewIPDIssueToPatTransDAO.getPatientAddmissionFlag(voObj);
		
	}
	
	public void getLFAccountDetail(NewIPDIssueToPatTransVO voObj)
	{
		NewIPDIssueToPatTransDAO.getLFAccountDetails(voObj);
	}

	public void getPatientDiagDetails(NewIPDIssueToPatTransVO vo)
	{
		NewIPDIssueToPatTransDAO.getPatientDiagDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void getIcdList(NewIPDIssueToPatTransVO vo)
	{
		NewIPDIssueToPatTransDAO.getIcdList(vo);
		NewIPDIssueToPatTransDAO.getEmpList(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	public void getBilledItemDtls(NewIPDIssueToPatTransVO vo)
	{		
		NewIPDIssueToPatTransDAO.getBilledItemDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void deleteIssueDtls(NewIPDIssueToPatTransVO vo)
	{		
		NewIPDIssueToPatTransDAO.deleteIssueDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getTariffDtls(NewIPDIssueToPatTransVO vo)
	{		
		NewIPDIssueToPatTransDAO.getTariffDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getAlreadyIssueDrug(NewIPDIssueToPatTransFB formBean, NewIPDIssueToPatTransVO vo)
	{		
		NewIPDIssueToPatTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	public void getStoreDtlsBS(NewIPDIssueToPatTransVO voObj){
		
		NewIPDIssueToPatTransDAO.getStoreListBS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
				}
				
		}

	public void getPayMode(NewIPDIssueToPatTransVO vo) {
		// TODO Auto-generated method stub
		NewIPDIssueToPatTransDAO.getPaymentMode(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
				
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
		}
		
	}

	public void getReqType(NewIPDIssueToPatTransVO vo) {
		// TODO Auto-generated method stub
			NewIPDIssueToPatTransDAO.getReqType(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
				
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getReqType()-->"+strErr);
		}
	}
	public void directIssue(NewIPDIssueToPatTransVO voObj){
		
		
		
		NewIPDIssueToPatTransDAO.directIssue(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
				}
				
		}
	
       public void getdeptname(NewIPDIssueToPatTransVO voObj){
		
		
		
		NewIPDIssueToPatTransDAO.getdeptname(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getdeptname()-->"+strErr);
				}
				
		}

	public void getEpisodeDetails(NewIPDIssueToPatTransVO voObj) {
		// TODO Auto-generated method stub
		
		NewIPDIssueToPatTransDAO.getEpisodeDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getEpisodeDtl()-->"+strErr);
				}
		
	}
	public void getPresFormDetails(NewIPDIssueToPatTransVO voObj) {
		// TODO Auto-generated method stub
		
		NewIPDIssueToPatTransDAO.getPresFormDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getEpisodeDtl()-->"+strErr);
				}
		
	}

	public void getAccDtl(NewIPDIssueToPatTransVO vo) {
		// TODO Auto-generated method stub
		NewIPDIssueToPatTransDAO.getAccountDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("NewIPDIssueToPatTransBO.getAccDtl()-->"+strErr);
				}
		
	}
	
	public void getLPRequestDetail(NewIPDIssueToPatTransVO vo) 
	{
		
		NewIPDIssueToPatTransDAO.getIssuedItemDtlview(vo);			
		NewIPDIssueToPatTransDAO.getPatientAccountDetails(vo);
		
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getLPRequestDetail() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void getCRViewDtl(NewIPDIssueToPatTransVO voObj)
	{
		
		NewIPDIssueToPatTransDAO.getCRIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("NewIPDIssueToPatTransBO.getCRIssueDetail() --> "+ voObj.getStrMsgString());
		  }
		
	}
	
	/**
	 * To get the Recommend By
	 * 
	 * @param vo
	 */
	public void getRecommendName(NewIPDIssueToPatTransVO vo)
	{
		NewIPDIssueToPatTransDAO.getRecommendName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("NewIPDIssueToPatTransBO.getRecommendName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get Issue Item Details
	 * @param vo
	 */
	public void getItem_ALL_LIST(NewIPDIssueToPatTransVO vo) {
		NewIPDIssueToPatTransDAO.getItem_ALL_LIST(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getItem_ALL_LIST() --> "
					+ vo.getStrMsgString());
		}

	}
		

}