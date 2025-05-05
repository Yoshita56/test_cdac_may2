package dossier.transaction.bo;

import dossier.transaction.dao.LPIssueDeskTransDAO;
import dossier.transaction.vo.LPIssueDeskTransVO;


public class LPIssueDeskTransBO {

	public void getLPRequestDetail(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		LPIssueDeskTransDAO.getLPRequestDetail(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getIssueItemDtl(_LPIssueDeskTransVO);
		
		LPIssueDeskTransDAO.getPatientAccountDetails(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14"))
		{
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}

		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) 
		{
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
	
	public void getAfterSettelmentRequestDetail(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		LPIssueDeskTransDAO.getLPRequestDetail(_LPIssueDeskTransVO);		
		LPIssueDeskTransDAO.getIssueDtlsList(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getPatientAccountDetails(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14"))
		{
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}

		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) 
		{
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
	
	public void getLPRequestDetail_View(LPIssueDeskTransVO _LPIssueDeskTransVO) 
	{
		LPIssueDeskTransDAO.getLPRequestDetail(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getIssueItemDtl_view(_LPIssueDeskTransVO);			
		LPIssueDeskTransDAO.getPatientAccountDetails(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14"))
		{
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}

		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) 
		{
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
	
	public void getLPRequestDetail_new(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		LPIssueDeskTransDAO.getLPRequestDetail(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getLPRequestDetail_new(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getIssueItemDtl_new(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getPatientAccountDetails(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}

		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getLPRequestDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
	public void getIssueItemDetail(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		
		
		LPIssueDeskTransDAO.getIssuedItemDtl(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getApprovedByCombo(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	
public void getIssueItemDetailForReturn(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		
		
		LPIssueDeskTransDAO.getIssueItemDetailForReturn(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getApprovedByCombo(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	
	
public void getIssueItemDetailview(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		
		
		LPIssueDeskTransDAO.getIssuedItemDtlview(_LPIssueDeskTransVO);
		LPIssueDeskTransDAO.getApprovedByCombo(_LPIssueDeskTransVO);
		if(_LPIssueDeskTransVO.getStrRaisingReqTypeId().equals("14")){
			LPIssueDeskTransDAO.getDeptName(_LPIssueDeskTransVO);
		}
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueItemDetail() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	
	public void getUnitCombo(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		LPIssueDeskTransDAO.getReturnUnitCombo(_LPIssueDeskTransVO);
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getUnitCombo() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	public void insertData(LPIssueDeskTransVO _LPIssueDeskTransVO){
	
		LPIssueDeskTransDAO.insertData(_LPIssueDeskTransVO);
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.insertData() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	public void insertRet(LPIssueDeskTransVO _LPIssueDeskTransVO){
		
		LPIssueDeskTransDAO.insertRetData(_LPIssueDeskTransVO);
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.insertData() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}
	}
	

	/**
	 * This method is used to populate the value of Unit name combo
	 * 
	 * @param vo
	 */
	/*public void getUnitCombo(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getUnitCombo(vo);

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
	/*public void getPopUpInfo(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getPopUpInfoProc(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LPIssueDeskTransBO.getPopUpInfo() --> "
					+ vo.getStrMsgString());
		}
	}*/

	public void getPatientDiagDetails(LPIssueDeskTransVO vo)
	{
		LPIssueDeskTransDAO.getPatientDiagDetails(vo);
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
	public void getSingleBatchItemDtl(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getSingleBatchItemDtl(vo);

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
	public void getBrandDetails(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getBrandDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("IssueDeskTransBO.getSingleBatchItemDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	public void getIssueDtlsInitDtls(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getIssueDtlsListTwo(LPIssueDeskTransVO vo) 
	{

		LPIssueDeskTransDAO.getIssueDtlsListTwo(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getIssueDtlsListTwo() --> "
							+ strErr);

		}

	}
	
	
	public void getIssueDtlsInitDtlsExtraItems(LPIssueDeskTransVO vo) {

		LPIssueDeskTransDAO.getIssueDtlsListExtra(vo);
		LPIssueDeskTransDAO.getDossierDtls(vo);
		

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("IssueTransBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}
	
	public void getIssueNoDtls(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		LPIssueDeskTransDAO.getIssueNoDtls(_LPIssueDeskTransVO);
		
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueNo() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
	
	public void getReturnNoDtls(LPIssueDeskTransVO _LPIssueDeskTransVO) {
		LPIssueDeskTransDAO.getReturnNoDtls(_LPIssueDeskTransVO);
		
		if (_LPIssueDeskTransVO.getStrMsgType().equals("1")) {
			_LPIssueDeskTransVO.setStrMsgString("LPIssueDeskTransBO.getIssueNo() --> "
					+ _LPIssueDeskTransVO.getStrMsgString());
		}

	}
}
