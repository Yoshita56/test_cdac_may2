package mms.transactions.bo;

import mms.transactions.dao.IssueDeskPrintTransDAO;
import mms.transactions.dao.IssueDeskPrintTransDAO;
import mms.transactions.vo.IssueDeskPrintTransVO;
import mms.transactions.vo.IssueDeskPrintTransVO;

public class IssueDeskPrintTransBO 
{
	
	public void getListPageCombo(IssueDeskPrintTransVO vo)
	{
		IssueDeskPrintTransDAO.getStoreList(vo);	
		IssueDeskPrintTransDAO.getRequestTypeCombo(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDeskPrintTransBO.getListPageCombo() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	public void getRequestTypeCombo(IssueDeskPrintTransVO vo)
	{		
		IssueDeskPrintTransDAO.getRequestTypeCombo(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDeskPrintTransBO.getRequestTypeCombo() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	public void getListPageData(IssueDeskPrintTransVO vo)
	{		
		IssueDeskPrintTransDAO.getListPageData(vo);			
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDeskPrintTransBO.getListPageData() --> "
					+ vo.getStrMsgString());
		}
	}	
	
	

	public void getLPRequestDetail(IssueDeskPrintTransVO _IssueDeskPrintTransVO)
	{
		IssueDeskPrintTransDAO.getLPRequestDetail(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getIssueItemDtl(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getPatientAccountDetails(_IssueDeskPrintTransVO);
		if(_IssueDeskPrintTransVO.getStrRaisingReqTypeId().equals("14")){
			IssueDeskPrintTransDAO.getDeptName(_IssueDeskPrintTransVO);
		}

		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getLPRequestDetail() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
		
		IssueDeskPrintTransDAO.getItemDetails(_IssueDeskPrintTransVO);

	}
	
	public void getIndentRequestDetail(IssueDeskPrintTransVO _IssueDeskPrintTransVO)
	{
		IssueDeskPrintTransDAO.getIndentDetails(_IssueDeskPrintTransVO);	
		IssueDeskPrintTransDAO.getItemDetails(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getPatientAccountDetails(_IssueDeskPrintTransVO);		
		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) 
		{
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getIndentRequestDetail() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
	}	
	public void getLPRequestDetail_new(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {
		IssueDeskPrintTransDAO.getLPRequestDetail_new(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getIssueItemDtl_new(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getPatientAccountDetails(_IssueDeskPrintTransVO);
		if(_IssueDeskPrintTransVO.getStrRaisingReqTypeId().equals("14")){
			IssueDeskPrintTransDAO.getDeptName(_IssueDeskPrintTransVO);
		}

		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getLPRequestDetail() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}

	}
	public void getIssueItemDetail(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {
		
		
		IssueDeskPrintTransDAO.getIssuedItemDtl(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getApprovedByCombo(_IssueDeskPrintTransVO);
		if(_IssueDeskPrintTransVO.getStrRaisingReqTypeId().equals("14")){
			IssueDeskPrintTransDAO.getDeptName(_IssueDeskPrintTransVO);
		}
		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getIssueItemDetail() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
	}
	
	
public void getIssueItemDetailview(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {
		
		
		IssueDeskPrintTransDAO.getIssuedItemDtlview(_IssueDeskPrintTransVO);
		IssueDeskPrintTransDAO.getApprovedByCombo(_IssueDeskPrintTransVO);
		if(_IssueDeskPrintTransVO.getStrRaisingReqTypeId().equals("14")){
			IssueDeskPrintTransDAO.getDeptName(_IssueDeskPrintTransVO);
		}
		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getIssueItemDetail() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
	}
	
	public void getUnitCombo(IssueDeskPrintTransVO _IssueDeskPrintTransVO) {
		IssueDeskPrintTransDAO.getReturnUnitCombo(_IssueDeskPrintTransVO);
		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.getUnitCombo() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
	}
	public void insertData(IssueDeskPrintTransVO _IssueDeskPrintTransVO){
	
		IssueDeskPrintTransDAO.insertData(_IssueDeskPrintTransVO);
		if (_IssueDeskPrintTransVO.getStrMsgType().equals("1")) {
			_IssueDeskPrintTransVO.setStrMsgString("IssueDeskPrintTransBO.insertData() --> "
					+ _IssueDeskPrintTransVO.getStrMsgString());
		}
	}
	
	public void getPatientDiagDetails(IssueDeskPrintTransVO vo)
	{
		IssueDeskPrintTransDAO.getPatientDiagDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("IssueDeskPrintTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/* This method is used to GET POPUP VALUES.
	 * 
	 * @param vo
	 *            the vo
	 * @return the single batch item dtl
	 */
	public void getSingleBatchItemDtl(IssueDeskPrintTransVO vo) {

		IssueDeskPrintTransDAO.getSingleBatchItemDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/* This method is used to GET POPUP VALUES.
	 * 
	 * @param vo
	 *            the vo
	 * @return the branded/non branded item details
	 */
	public void getBrandDetails(IssueDeskPrintTransVO vo) {

		IssueDeskPrintTransDAO.getBrandDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * viewData Method is Used to get the Data  for view page
	 * @param vo
	 */
	public void viewData(IssueDeskPrintTransVO vo)
	{
		IssueDeskPrintTransDAO.getIndent_ItemDetails(vo);			
		IssueDeskPrintTransDAO.getIndentDetails_NEW(vo);
		IssueDeskPrintTransDAO.callingFunctionIndentName(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("IssueDeskPrintTransBO.viewData() --> "+ vo.getStrMsgString());
		}
		  
	}
}
