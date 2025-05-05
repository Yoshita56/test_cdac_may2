package mms.transactions.bo;

import mms.transactions.dao.ChallanProcessApprovalTransDAO;
import mms.transactions.dao.ChallanProcessTransDAO;
import mms.transactions.vo.ChallanProcessApprovalTransVO;
import mms.transactions.vo.ChallanProcessTransVO;

public class ChallanProcessApprovalTransBO {

	public void receiveInit(ChallanProcessApprovalTransVO vo) {
		
		ChallanProcessApprovalTransDAO.receiveInit(vo);
		ChallanProcessApprovalTransDAO.challanCount(vo);
		ChallanProcessApprovalTransDAO.setRecievedByCombo(vo);
		
		if(Integer.parseInt(vo.getStrChallanCount()) == 0)
		{
			
			ChallanProcessApprovalTransDAO.scheduleNoList(vo);
			ChallanProcessApprovalTransDAO.deliveryModeList(vo);
			ChallanProcessApprovalTransDAO.scheduleItemList(vo);
			
		}
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.reviewInit() --> "
					+ vo.getStrMsgString());
		}
	}

	
	public void getScheduleDtls(ChallanProcessApprovalTransVO vo) {

		ChallanProcessApprovalTransDAO.deliveryModeList(vo);
		ChallanProcessApprovalTransDAO.scheduleItemList(vo);	
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getCommitteeMemberDtls(ChallanProcessApprovalTransVO vo) {

		ChallanProcessApprovalTransDAO.getMemberDtl(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getBalanceQtyDtls(ChallanProcessApprovalTransVO vo) {

		ChallanProcessApprovalTransDAO.getBalanceQtyDetails(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.getBalanceQtyDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void insert(ChallanProcessApprovalTransVO vo) {
	
		ChallanProcessApprovalTransDAO.insert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessApprovalTransBO.insert() --> " + strErr);
		}

	}
	
	public void verifyInit(ChallanProcessApprovalTransVO vo) {

		ChallanProcessApprovalTransDAO.receiveInit(vo);
		ChallanProcessApprovalTransDAO.getChallanDetails(vo);
		ChallanProcessApprovalTransDAO.getChallanItemDetails(vo);
		ChallanProcessApprovalTransDAO.getSuppliedByList(vo);
		ChallanProcessApprovalTransDAO.getItemMandatoryDetails(vo);
		ChallanProcessApprovalTransDAO.unitNameCombo(vo);
		ChallanProcessApprovalTransDAO.rateUnitCombo(vo);
		ChallanProcessApprovalTransDAO.getCommitteeTypeDtl(vo);
			
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.verifyInit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void verifyInsert(ChallanProcessApprovalTransVO vo) {
		
		ChallanProcessApprovalTransDAO.verifyInsert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessApprovalTransBO.verifyInsert() --> " + strErr);
		}

	}
	
    public void cancelChallan(ChallanProcessApprovalTransVO vo) {
		
		ChallanProcessApprovalTransDAO.cancelChallan(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessApprovalTransBO.cancelChallan() --> " + strErr);
		}

	}
    
    
    public void cancelVerifiedChallan(ChallanProcessApprovalTransVO vo) {
		
		ChallanProcessApprovalTransDAO.cancelVerifiedChallan(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessApprovalTransBO.cancelChallan() --> " + strErr);
		}

	}
    
    /**
     * View challan.
     * @author santoshsinghchauhan
     * @param vo the vo
     */
    public void viewChallan(ChallanProcessApprovalTransVO vo) {
    	ChallanProcessApprovalTransDAO.getPODetails(vo);	
		ChallanProcessApprovalTransDAO.getChallanReceivedDetails(vo);		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.viewChallan() --> "
					+ vo.getStrMsgString());
		}
	}
    
    /**
     * Gets the received item details.
     * @author santoshsinghchauhan
     * @param vo the vo
     * 
     * @return the received item details
     */
    public void getReceivedItemDetails(ChallanProcessApprovalTransVO vo) {
		ChallanProcessApprovalTransDAO.getReceivedItemDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.getReceivedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}
    
    /**
     * Gets the verified item details.
     * @author santoshsinghchauhan
     * @param vo the vo
     * 
     * @return the verified item details
     */
    public void getVerifiedItemDetails(ChallanProcessApprovalTransVO vo) {
		ChallanProcessApprovalTransDAO.getVerifiedItemDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessApprovalTransBO.getVerifiedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	
    /**
	 * freezeChallanInit.
	 * @author vivek
	 * @param vo the vo
	 */
	public void freezeChallanInit(ChallanProcessApprovalTransVO vo) {
		ChallanProcessApprovalTransDAO.getChallanDetailFreeze(vo);
		ChallanProcessApprovalTransDAO.getVerifiedItemDetailsForFreeze(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("ChallanProcessApprovalTransBO.freezeChallanInit() --> "+ vo.getStrMsgString());
		}
	}
	
	
	public void insertFreezeChallan(ChallanProcessApprovalTransVO vo) {

		ChallanProcessApprovalTransDAO.insertFreezeChallan(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessApprovalTransBO.insert() --> " + strErr);
		}

	}
	
	public void getPrintDetails(ChallanProcessApprovalTransVO vo) {
		ChallanProcessApprovalTransDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.getVerifiedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}
}
