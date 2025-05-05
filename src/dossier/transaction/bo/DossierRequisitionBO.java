package dossier.transaction.bo;

import dossier.transaction.dao.DossierRequisitionDAO;
import dossier.transaction.vo.DossierRequisitionVO;

public class DossierRequisitionBO {
	

	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(DossierRequisitionVO _OfflineIssueIndentTransVO)
	{		
		DossierRequisitionDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
		if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
		{
			_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
		}
		
	}
	
	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(DossierRequisitionVO vo) {

		DossierRequisitionDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	
	public void getStoreDtls(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(DossierRequisitionVO voObj)
     {
		
		DossierRequisitionDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(DossierRequisitionVO voObj)
        {
        DossierRequisitionDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
public void getDossierDtls(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getDossierDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}

public void getDeptDtls(DossierRequisitionVO voObj){
	
	DossierRequisitionDAO.getDossierDtls(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
			}
			
	}
	public void getItemCatDtls1(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(DossierRequisitionVO voObj)
      {
		
		DossierRequisitionDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getRequestDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
public void getStoreNameDetails(DossierRequisitionVO voObj){
		
	DossierRequisitionDAO.getStoreNameDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	public void insert(DossierRequisitionVO voObj){
		
		
		
		DossierRequisitionDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
				}
				
		}
	
public void inserttemp(DossierRequisitionVO voObj){
		
		
		
		DossierRequisitionDAO.inserttemp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
				}
				
		}
	
public void insertipd(DossierRequisitionVO voObj){
	
	
	
	DossierRequisitionDAO.insertipd(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
			}
			
	}
		public void insertWithoutCrNo(DossierRequisitionVO voObj)
	{
		
		DossierRequisitionDAO.insertWithoutCrNo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insertWithoutCrNo()-->"+strErr);
				}
				
		}
	
		public void getGenderCombo(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
		
		public void getLFAccountDetail(DossierRequisitionVO voObj)
		{
			DossierRequisitionDAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(DossierRequisitionVO vo)
		{
			DossierRequisitionDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(DossierRequisitionVO vo)
		{
			DossierRequisitionDAO.getIcdList(vo);
			DossierRequisitionDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(DossierRequisitionVO _OfflineIssueIndentTransVO)
		{		
			DossierRequisitionDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void save(DossierRequisitionVO _OfflineIssueIndentTransVO)
		{		
			DossierRequisitionDAO.save(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void deleteIssueDtls(DossierRequisitionVO _OfflineIssueIndentTransVO)
		{		
			DossierRequisitionDAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(DossierRequisitionVO _OfflineIssueIndentTransVO)
		{		
			DossierRequisitionDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTreamentDtls(DossierRequisitionVO voObj){
			
			DossierRequisitionDAO.getOnlineTreatmentDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}

	public void getDossierItemDetails(DossierRequisitionVO voObj){
			
			DossierRequisitionDAO.getDossierItemDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
	public void getServiceDetails(DossierRequisitionVO voObj){
		
		DossierRequisitionDAO.getServiceDetails(voObj);
		DossierRequisitionDAO.getStoreNameDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void INSERT(DossierRequisitionVO voObj){
		
	
			DossierRequisitionDAO.insertDossier(voObj);	
	
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	
	public void INSERTOT(DossierRequisitionVO voObj){
		
		
		DossierRequisitionDAO.insertDossierOT(voObj);	
		//DossierRequisitionDAO.insertOTDossier(voObj);	
		
		

	
	
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
			}
			
	}
	
	
public void INSERTOPD(DossierRequisitionVO voObj){
		
			DossierRequisitionDAO.insertOPDDossier(voObj);	
		
			if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}

	
}
