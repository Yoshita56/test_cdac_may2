package dossier.transaction.bo;

import dossier.transaction.dao.DossierDeskTransDAO;
import dossier.transaction.vo.DossierDeskTransVO;


public class DossierDeskTransBO {

	public void getLPRequestDetail(DossierDeskTransVO _DossierDeskTransVO) {
		DossierDeskTransDAO.getLPRequestDetail(_DossierDeskTransVO);
		DossierDeskTransDAO.getIssueItemDtl(_DossierDeskTransVO);
		//DossierDeskTransDAO.getIssueItemDtl_new(_DossierDeskTransVO);
		DossierDeskTransDAO.getPatientAccountDetails(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}

		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}

	}
	
	public void getLPRequestDetail_new(DossierDeskTransVO _DossierDeskTransVO) {
		DossierDeskTransDAO.getLPRequestDetail(_DossierDeskTransVO);
		DossierDeskTransDAO.getLPRequestDetail_new(_DossierDeskTransVO);
		DossierDeskTransDAO.getIssueItemDtl_new(_DossierDeskTransVO);
		DossierDeskTransDAO.getPatientAccountDetails(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}

		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}

	}
	public void getIssueItemDetail(DossierDeskTransVO _DossierDeskTransVO) {
		
		
		DossierDeskTransDAO.getIssuedItemDtl(_DossierDeskTransVO);
		DossierDeskTransDAO.getApprovedByCombo(_DossierDeskTransVO);
		DossierDeskTransDAO.getItemCatDtls(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetail() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	
	
public void getIssueItemDetailview(DossierDeskTransVO _DossierDeskTransVO) {
		
		
		DossierDeskTransDAO.getIssuedItemDtlview(_DossierDeskTransVO);
		DossierDeskTransDAO.getApprovedByCombo(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetail() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	
	public void getUnitCombo(DossierDeskTransVO _DossierDeskTransVO) {
		DossierDeskTransDAO.getReturnUnitCombo(_DossierDeskTransVO);
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getUnitCombo() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	public void insertData(DossierDeskTransVO _DossierDeskTransVO){
	
		DossierDeskTransDAO.insertData(_DossierDeskTransVO);
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.insertData() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	public void insertRet(DossierDeskTransVO _DossierDeskTransVO){
		
		DossierDeskTransDAO.insertRetData(_DossierDeskTransVO);
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.insertData() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	

	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	/*public void getUnitCombo(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getUnitCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LPIssueDeskTransBO.getUnitCombo() --> "
					+ vo.getStrMsgString());
		}
	}
	*/
	/**
	 * This method is used to GET POPUP VALUES
	 * 
	 * @param vo
	 */
	/*public void getPopUpInfo(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getPopUpInfoProc(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LPIssueDeskTransBO.getPopUpInfo() --> "
					+ vo.getStrMsgString());
		}
	}*/

	public void getPatientDiagDetails(DossierDeskTransVO vo)
	{
		DossierDeskTransDAO.getPatientDiagDetails(vo);
		  if (vo.getStrMsgType().equals("1")) 
		  {
			vo.setStrMsgString("LPIssueDeskTransBO.getPatientDiagDetails() --> "+ vo.getStrMsgString());
		  }
		  
	}
	
	/* This method is used to GET POPUP VALUES.
	 * 
	 * @param vo
	 *            the vo
	 * @return the single batch item dtl
	 */
	public void getSingleBatchItemDtl(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getSingleBatchItemDtl(vo);

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
	public void getBrandDetails(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getBrandDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	public void getIssueDtlsInitDtls(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	public void cancelDossier(DossierDeskTransVO vo) {

		DossierDeskTransDAO.cancelDossier(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

		
		
	}
	
	
	public void getIssueItemDetailForIssueView(DossierDeskTransVO _DossierDeskTransVO) {
		
		
		DossierDeskTransDAO.getIssuedItemDtlForIssueView(_DossierDeskTransVO);
		DossierDeskTransDAO.getApprovedByCombo(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetailForIssueView() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
	
	
	public void getRequestTypeDtlsForView(DossierDeskTransVO vo) {

		DossierDeskTransDAO.getRequestTypeDtlsForView(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getRequestTypeDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getIssueItemDetailForReturnView(DossierDeskTransVO _DossierDeskTransVO) {
		
		
		DossierDeskTransDAO.getIssueItemDetailForReturnView(_DossierDeskTransVO);
		DossierDeskTransDAO.getApprovedByCombo(_DossierDeskTransVO);
		if(_DossierDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			DossierDeskTransDAO.getDeptName(_DossierDeskTransVO);
		}
		if (_DossierDeskTransVO.getStrMsgType().equals("1")) {
			_DossierDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetailForReturnView() --> "
					+ _DossierDeskTransVO.getStrMsgString());
		}
	}
}
