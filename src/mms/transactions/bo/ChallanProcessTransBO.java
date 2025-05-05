package mms.transactions.bo;
import mms.transactions.dao.ChallanProcessTransDAO;
import mms.transactions.vo.ChallanProcessTransVO;

public class ChallanProcessTransBO {

	public void receiveInit(ChallanProcessTransVO vo) {
		
		ChallanProcessTransDAO.receiveInit(vo);
		ChallanProcessTransDAO.challanCount(vo);
		ChallanProcessTransDAO.setRecievedByCombo(vo);
		
		if(Integer.parseInt(vo.getStrChallanCount()) == 0)
		{
			//ChallanProcessTransDAO.scheduleNoList(vo);
			ChallanProcessTransDAO.deliveryModeList(vo);
			//ChallanProcessTransDAO.scheduleItemList(vo);			
		}
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.reviewInit() --> "
					+ vo.getStrMsgString());
		}
	}

	
	public void getScheduleDtls(ChallanProcessTransVO vo) 
	{
		ChallanProcessTransDAO.scheduleNoList(vo);  // New Mthod Add by Amit Kumar On Date 11 - July -2012
		ChallanProcessTransDAO.deliveryModeList(vo);
		ChallanProcessTransDAO.scheduleItemList(vo);	
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getCommitteeMemberDtls(ChallanProcessTransVO vo) {

		ChallanProcessTransDAO.getMemberDtl(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getBalanceQtyDtls(ChallanProcessTransVO vo) {

		ChallanProcessTransDAO.getBalanceQtyDetails(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.getBalanceQtyDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void insert(ChallanProcessTransVO vo) {
	
		ChallanProcessTransDAO.insert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessTransBO.insert() --> " + strErr);
		}

	}
	
	public void verifyInit(ChallanProcessTransVO vo)
	{
		ChallanProcessTransDAO.receiveInit(vo);
		ChallanProcessTransDAO.getChallanDetails(vo);
		ChallanProcessTransDAO.getChallanItemDetails(vo);
		ChallanProcessTransDAO.getSuppliedByList(vo);
		ChallanProcessTransDAO.getItemMandatoryDetails(vo);
		ChallanProcessTransDAO.unitNameCombo(vo);
		ChallanProcessTransDAO.rateUnitCombo(vo);
		ChallanProcessTransDAO.getCommitteeTypeDtl(vo);
		ChallanProcessTransDAO.getItemQCType(vo);
		ChallanProcessTransDAO.getSupplierPerformanceFlag(vo);
			
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.verifyInit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void verifyInsert(ChallanProcessTransVO vo) {
		
		ChallanProcessTransDAO.verifyInsert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessTransBO.verifyInsert() --> " + strErr);
		}

	}
	
public void cancelChallan(ChallanProcessTransVO vo) {
		
		ChallanProcessTransDAO.cancelChallan(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ChallanProcessTransBO.cancelChallan() --> " + strErr);
		}

	}
public void viewChallan(ChallanProcessTransVO vo) {
	ChallanProcessTransDAO.getPODetails(vo);	
	ChallanProcessTransDAO.getChallanReceivedDetails(vo);		
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("ChallanProcessTransBO.viewChallan() --> "
				+ vo.getStrMsgString());
	}
}
public void getReceivedItemDetails(ChallanProcessTransVO vo) {
	ChallanProcessTransDAO.getReceivedItemDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("ChallanProcessTransBO.getReceivedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}

public void getVerifiedItemDetails(ChallanProcessTransVO vo) {
	ChallanProcessTransDAO.getVerifiedItemDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("ChallanProcessTransBO.getVerifiedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}

public void getPrintDetails(ChallanProcessTransVO vo) {
	ChallanProcessTransDAO.getPrintDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("ChallanProcessTransBO.getVerifiedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}
public void getInitNewRecChl(ChallanProcessTransVO vo) {
	ChallanProcessTransDAO.NewreceiveInit(vo);	
	ChallanProcessTransDAO.getNewReceivedItemDetails(vo);	
	ChallanProcessTransDAO.setRecievedByCombo(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("ChallanProcessTransBO.viewChallan() --> "
				+ vo.getStrMsgString());
	}
}

}
