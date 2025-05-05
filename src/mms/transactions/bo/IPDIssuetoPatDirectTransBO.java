package mms.transactions.bo;

import mms.transactions.controller.fb.IPDIssuetoPatDirectTransFB;
import mms.transactions.dao.IPDIssuetoPatDirectTransDAO;
import mms.transactions.vo.IPDIssuetoPatDirectTransVO;

public class IPDIssuetoPatDirectTransBO {
	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(IPDIssuetoPatDirectTransVO vo)
	{		
		IPDIssuetoPatDirectTransDAO.getIssueDetailTwo(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
    public void getItemBrandList(IPDIssuetoPatDirectTransVO voObj){
		
		
    	IPDIssuetoPatDirectTransDAO.getItemBrandList(voObj);		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueToPatOPDTransBO.getItemBrandList()-->"+strErr);
				}
				
		}
	
	
	/**
	 * Method is Used to Generate View page data 
	 * @param vo
	 */	
	public void initForViewPage(IPDIssuetoPatDirectTransVO voObj){
		IPDIssuetoPatDirectTransDAO.GetData(voObj);
		IPDIssuetoPatDirectTransDAO.itemCategoryCombo1(voObj);
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
	public void getIssueDtlsInitDtls(IPDIssuetoPatDirectTransVO vo) {

		IPDIssuetoPatDirectTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("NewIPDIssueToPatTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getImgHeader(IPDIssuetoPatDirectTransVO voObj){
		IPDIssuetoPatDirectTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("NewIPDIssueToPatTransBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}

	
	public void getStoreDtls(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(IPDIssuetoPatDirectTransVO voObj)
     {
		
		IPDIssuetoPatDirectTransDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(IPDIssuetoPatDirectTransVO voObj)
        {
        IPDIssuetoPatDirectTransDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("NewIPDIssueToPatTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
      public void GET_PAT_ACC_STATUS(IPDIssuetoPatDirectTransVO voObj)
      {
		
		IPDIssuetoPatDirectTransDAO.GET_PAT_ACC_STATUS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.GET_PAT_ACC_STATUS()-->"+strErr);
				}
				
		}

	public void getItemCatDtls1(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(IPDIssuetoPatDirectTransVO voObj)
      {
		
		IPDIssuetoPatDirectTransDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getTreamentDtls(IPDIssuetoPatDirectTransFB formBean, IPDIssuetoPatDirectTransVO vo){
		
		IPDIssuetoPatDirectTransDAO.getOnlineTreatmentDtls(formBean,vo);
		//IPDIssuetoPatDirectTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("NewIPDIssueToPatTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void getRequestDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	 public void insert(IPDIssuetoPatDirectTransVO voObj)
	 {
		IPDIssuetoPatDirectTransDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) 
		{
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
		}
				
	  }
	
      	
     public void insertipd(IPDIssuetoPatDirectTransVO voObj)
     {
	   IPDIssuetoPatDirectTransDAO.insertipd(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
	   }
			
	}
     
     public void REPEAT_ISSUE_INSERT(IPDIssuetoPatDirectTransVO voObj)
     {
	   IPDIssuetoPatDirectTransDAO.REPEAT_ISSUE_INSERT(voObj);
	   if (voObj.getStrMsgType().equals("1")) 
	   {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.REPEAT_ISSUE_INSERT()-->"+strErr);
	   }
			
	}
	
	
	public void getGenderCombo(IPDIssuetoPatDirectTransVO voObj){
	
	IPDIssuetoPatDirectTransDAO.getGenderCombo(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("NewIPDIssueToPatTransBO.getGenderCombo()-->"+strErr);
			}
			
	}
			
	public void getPatientAddmissionFlag(IPDIssuetoPatDirectTransVO voObj)
	{
		IPDIssuetoPatDirectTransDAO.getPatientAddmissionFlag(voObj);
		
	}
	
	public void getLFAccountDetail(IPDIssuetoPatDirectTransVO voObj)
	{
		IPDIssuetoPatDirectTransDAO.getLFAccountDetails(voObj);
	}

	public void getPatientDiagDetails(IPDIssuetoPatDirectTransVO vo)
	{
		IPDIssuetoPatDirectTransDAO.getPatientDiagDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	public void getIcdList(IPDIssuetoPatDirectTransVO vo)
	{
		IPDIssuetoPatDirectTransDAO.getIcdList(vo);
		IPDIssuetoPatDirectTransDAO.getEmpList(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	
	public void getBilledItemDtls(IPDIssuetoPatDirectTransVO vo)
	{		
		IPDIssuetoPatDirectTransDAO.getBilledItemDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void deleteIssueDtls(IPDIssuetoPatDirectTransVO vo)
	{		
		IPDIssuetoPatDirectTransDAO.deleteIssueDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getTariffDtls(IPDIssuetoPatDirectTransVO vo)
	{		
		IPDIssuetoPatDirectTransDAO.getTariffDtls(vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getAlreadyIssueDrug(IPDIssuetoPatDirectTransFB formBean, IPDIssuetoPatDirectTransVO vo)
	{		
		IPDIssuetoPatDirectTransDAO.getAlreadyDrugIssue(formBean, vo);
		if (vo.getStrMsgType().equals("1"))
		{
			vo.setStrMsgString("NewIPDIssueToPatTransBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		}
		
	}
	public void getStoreDtlsBS(IPDIssuetoPatDirectTransVO voObj){
		
		IPDIssuetoPatDirectTransDAO.getStoreListBS(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
				}
				
		}

	public void getPayMode(IPDIssuetoPatDirectTransVO vo) {
		// TODO Auto-generated method stub
		IPDIssuetoPatDirectTransDAO.getPaymentMode(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
				
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getStoreDtls()-->"+strErr);
		}
		
	}

	public void getReqType(IPDIssuetoPatDirectTransVO vo) {
		// TODO Auto-generated method stub
			IPDIssuetoPatDirectTransDAO.getReqType(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			
			String strErr = vo.getStrMsgString();
				
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getReqType()-->"+strErr);
		}
	}
	public void directIssue(IPDIssuetoPatDirectTransVO voObj){
		
		
		
		IPDIssuetoPatDirectTransDAO.directIssue(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.insert()-->"+strErr);
				}
				
		}
	
       public void getdeptname(IPDIssuetoPatDirectTransVO voObj){
		
		
		
		IPDIssuetoPatDirectTransDAO.getdeptname(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getdeptname()-->"+strErr);
				}
				
		}

	public void getEpisodeDetails(IPDIssuetoPatDirectTransVO voObj) {
		// TODO Auto-generated method stub
		
		IPDIssuetoPatDirectTransDAO.getEpisodeDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getEpisodeDtl()-->"+strErr);
				}
		
	}
	public void getPresFormDetails(IPDIssuetoPatDirectTransVO voObj) {
		// TODO Auto-generated method stub
		
		IPDIssuetoPatDirectTransDAO.getPresFormDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("NewIPDIssueToPatTransBO.getEpisodeDtl()-->"+strErr);
				}
		
	}

	public void getAccDtl(IPDIssuetoPatDirectTransVO vo) {
		// TODO Auto-generated method stub
		IPDIssuetoPatDirectTransDAO.getAccountDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
					
					String strErr = vo.getStrMsgString();
						
					vo.setStrMsgString("NewIPDIssueToPatTransBO.getAccDtl()-->"+strErr);
				}
		
	}
	
	public void getLPRequestDetail(IPDIssuetoPatDirectTransVO vo) 
	{
		
		IPDIssuetoPatDirectTransDAO.getIssuedItemDtlview(vo);			
		IPDIssuetoPatDirectTransDAO.getPatientAccountDetails(vo);
		
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
	
	public void getCRViewDtl(IPDIssuetoPatDirectTransVO voObj)
	{
		
		IPDIssuetoPatDirectTransDAO.getCRIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("NewIPDIssueToPatTransBO.getCRIssueDetail() --> "+ voObj.getStrMsgString());
		  }
		
	}
	
	/**
	 * To get the Recommend By
	 * 
	 * @param vo
	 */
	public void getRecommendName(IPDIssuetoPatDirectTransVO vo)
	{
		IPDIssuetoPatDirectTransDAO.getRecommendName(vo);
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
	public void getItem_ALL_LIST(IPDIssuetoPatDirectTransVO vo) {
		IPDIssuetoPatDirectTransDAO.getItem_ALL_LIST(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewIPDIssueToPatTransBO.getItem_ALL_LIST() --> "
					+ vo.getStrMsgString());
		}

	}
		

}