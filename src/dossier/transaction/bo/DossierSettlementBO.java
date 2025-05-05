package dossier.transaction.bo;

import dossier.transaction.dao.DossierSettlementDAO;
import dossier.transaction.vo.DossierSettlementVO;

public class DossierSettlementBO {
	

	
	/**
	 * This method is used to GET Issue Details
	 * 
	 * @param vo
	 */
	
	public void setViewPageDtl(DossierSettlementVO _OfflineIssueIndentTransVO)
	{		
		DossierSettlementDAO.getIssueDetailTwo(_OfflineIssueIndentTransVO);
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
	public void getIssueDtlsInitDtls(DossierSettlementVO vo) {

		DossierSettlementDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	
	public void getStoreDtls(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtls()-->"+strErr);
				}
				
		}
	
     public void getStoreDtlsView(DossierSettlementVO voObj)
     {
		
		DossierSettlementDAO.getViewStoreList(voObj);
	
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreDtlsView()-->"+strErr);
				}
				
		}
	
	
	
        public void getPatinetTypeCmb(DossierSettlementVO voObj)
        {
        DossierSettlementDAO.getPatinetTypeCmb(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
						String strErr = voObj.getStrMsgString();							
						voObj.setStrMsgString("IssueTransBO.getPatinetTypeCmb()-->"+strErr);
			}
				
		}
	
	public void getItemCatDtls(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
public void getDossierDtls(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getDossierDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}

public void getDeptDtls(DossierSettlementVO voObj){
	
	DossierSettlementDAO.getDossierDtls(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
			}
			
	}
	public void getItemCatDtls1(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getItemCatDtls1(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	public void issueTopatientCount(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getissuetopatient(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	
	
      public void getCancelIssueDtls(DossierSettlementVO voObj)
      {
		
		DossierSettlementDAO.getCancelIssueDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getCancelIssueDtls()-->"+strErr);
				}
				
		}
	
	public void getIssueDetail(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDetail()-->"+strErr);
				}
				
		}
	
	public void getIssueDtlPopUp(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getIssueDtlPopUp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getIssueDtlPopUp()-->"+strErr);
				}
				
		}
	
	public void getRequestDtls(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getRequestDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDtls()-->"+strErr);
				}
				
		}
	
	public void getRequestDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getRequestDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getRequestDetails()-->"+strErr);
				}
				
		}
	
	public void getDoseDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getDoseDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
public void getStoreNameDetails(DossierSettlementVO voObj){
		
	DossierSettlementDAO.getStoreNameDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDoseDetails()-->"+strErr);
				}
				
		}
	
	public void getFrequencyDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getFrequencyDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getFrequencyDetails()-->"+strErr);
				}
				
		}
	
	public void getDeptDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getDeptDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getDeptDetails()-->"+strErr);
				}
				
		}
	public void getUnitDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getUnitDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitDetails()-->"+strErr);
				}
				
		}
	public void getPrescribedBy(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getPrescribedBy(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getPrescribedBy()-->"+strErr);
				}
				
		}
	
	public void getItemDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getItemDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getItemDetails()-->"+strErr);
				}
				
		}
	
	public void getUnitCombo(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getUnitCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getUnitCombo()-->"+strErr);
				}
				
		}
	public void getStoreGroupDtls(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getStoreGroupList(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getStoreGroupDtls()-->"+strErr);
				}
				
		}
	
	public void insert(DossierSettlementVO voObj){
		
		
		
		DossierSettlementDAO.insert(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
				}
				
		}
	
public void inserttemp(DossierSettlementVO voObj){
		
		
		
		DossierSettlementDAO.inserttemp(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
				}
				
		}
	
public void insertipd(DossierSettlementVO voObj){
	
	
	
	DossierSettlementDAO.insertipd(voObj);
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.insert()-->"+strErr);
			}
			
	}
		public void insertWithoutCrNo(DossierSettlementVO voObj)
	{
		
		DossierSettlementDAO.insertWithoutCrNo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.insertWithoutCrNo()-->"+strErr);
				}
				
		}
	
		public void getGenderCombo(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getGenderCombo(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getGenderCombo()-->"+strErr);
				}
				
		}
		
		public void getLFAccountDetail(DossierSettlementVO voObj)
		{
			DossierSettlementDAO.getLFAccountDetails(voObj);
		}
	
		public void getPatientDiagDetails(DossierSettlementVO vo)
		{
			DossierSettlementDAO.getPatientDiagDetails(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		public void getIcdList(DossierSettlementVO vo)
		{
			DossierSettlementDAO.getIcdList(vo);
			DossierSettlementDAO.getEmpList(vo);
			  if (vo.getStrMsgType().equals("1")) 
			  {
				vo.setStrMsgString("IssueTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
			  }
			  
		}
		
		
		public void getBilledItemDtls(DossierSettlementVO _OfflineIssueIndentTransVO)
		{		
			DossierSettlementDAO.getBilledItemDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		
		
		public void save(DossierSettlementVO _OfflineIssueIndentTransVO)
		{		
			DossierSettlementDAO.save(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		public void deleteIssueDtls(DossierSettlementVO _OfflineIssueIndentTransVO)
		{		
			DossierSettlementDAO.deleteIssueDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTariffDtls(DossierSettlementVO _OfflineIssueIndentTransVO)
		{		
			DossierSettlementDAO.getTariffDtls(_OfflineIssueIndentTransVO);
			if (_OfflineIssueIndentTransVO.getStrMsgType().equals("1"))
			{
				_OfflineIssueIndentTransVO.setStrMsgString("IssueTransBO.setViewPageDtl() --> "+ _OfflineIssueIndentTransVO.getStrMsgString());
			}
			
		}
		
		public void getTreamentDtls(DossierSettlementVO voObj){
			
			DossierSettlementDAO.getOnlineTreatmentDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}

	public void getDossierItemDetails(DossierSettlementVO voObj){
			
			DossierSettlementDAO.getDossierItemDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
					}
					
			}
	public void getServiceDetails(DossierSettlementVO voObj){
		
		DossierSettlementDAO.getServiceDetails(voObj);
		DossierSettlementDAO.getStoreNameDetails(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}
	public void INSERT(DossierSettlementVO voObj){
		
	
			DossierSettlementDAO.insertDossierSettelment(voObj);	
	
		
		
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DossierSettlementBO.insertDossierSettelment()-->"+strErr);
				}
				
		}
	
	public void INSERTOT(DossierSettlementVO voObj){
		
		
		DossierSettlementDAO.insertDossierOT(voObj);	

	
	
	if (voObj.getStrMsgType().equals("1")) {
				
				String strErr = voObj.getStrMsgString();
					
				voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
			}
			
	}
	
	
public void INSERTOPD(DossierSettlementVO voObj){
		
			DossierSettlementDAO.insertOPDDossier(voObj);	
		
			if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("IssueTransBO.getTreamentDtls()-->"+strErr);
				}
				
		}

	
}
