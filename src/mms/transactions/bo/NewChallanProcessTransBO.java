package mms.transactions.bo;
import mms.transactions.dao.NewChallanProcessTransDAO;
import mms.transactions.vo.NewChallanProcessTransVO;

public class NewChallanProcessTransBO {

	public void receiveInit(NewChallanProcessTransVO vo) {
		
		NewChallanProcessTransDAO.receiveInit(vo);
		NewChallanProcessTransDAO.challanCount(vo);
		NewChallanProcessTransDAO.setRecievedByCombo(vo);
		
		if(Integer.parseInt(vo.getStrChallanCount()) == 0)
		{
			//NewChallanProcessTransDAO.scheduleNoList(vo);
			NewChallanProcessTransDAO.deliveryModeList(vo);
			//NewChallanProcessTransDAO.scheduleItemList(vo);			
		}
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewChallanProcessTransBO.reviewInit() --> "
					+ vo.getStrMsgString());
		}
	}

	
	public void getScheduleDtls(NewChallanProcessTransVO vo) 
	{
		NewChallanProcessTransDAO.scheduleNoList(vo);  // New Mthod Add by Amit Kumar On Date 11 - July -2012
		NewChallanProcessTransDAO.deliveryModeList(vo);
		NewChallanProcessTransDAO.scheduleItemList(vo);	
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewChallanProcessTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getCommitteeMemberDtls(NewChallanProcessTransVO vo) {

		NewChallanProcessTransDAO.getMemberDtl(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewChallanProcessTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void getBalanceQtyDtls(NewChallanProcessTransVO vo) {

		NewChallanProcessTransDAO.getBalanceQtyDetails(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewChallanProcessTransBO.getBalanceQtyDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void insert(NewChallanProcessTransVO vo) {
	
		NewChallanProcessTransDAO.insert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("NewChallanProcessTransBO.insert() --> " + strErr);
		}

	}
	public void insertlp(NewChallanProcessTransVO vo) {
		
		NewChallanProcessTransDAO.insertlp(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("NewChallanProcessTransBO.insert() --> " + strErr);
		}

	}
	
	public void verifyInit(NewChallanProcessTransVO vo)
	{
		NewChallanProcessTransDAO.receiveInit(vo);
		NewChallanProcessTransDAO.getChallanDetails(vo);
		NewChallanProcessTransDAO.getChallanItemDetails(vo);
		NewChallanProcessTransDAO.getSuppliedByList(vo);
		NewChallanProcessTransDAO.getItemMandatoryDetails(vo);
		NewChallanProcessTransDAO.unitNameCombo(vo);
		NewChallanProcessTransDAO.rateUnitCombo(vo);
		NewChallanProcessTransDAO.getCommitteeTypeDtl(vo);
		NewChallanProcessTransDAO.getItemQCType(vo);
		NewChallanProcessTransDAO.getSupplierPerformanceFlag(vo);
			
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("NewChallanProcessTransBO.verifyInit() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	public void verifyInsert(NewChallanProcessTransVO vo) {
		
	/*	NewChallanProcessTransDAO.verifyInsert(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("NewChallanProcessTransBO.verifyInsert() --> " + strErr);
		}*/

	}
	
public void cancelChallan(NewChallanProcessTransVO vo) {
		
		NewChallanProcessTransDAO.cancelChallan(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("NewChallanProcessTransBO.cancelChallan() --> " + strErr);
		}

	}
public void viewChallan(NewChallanProcessTransVO vo) {
	NewChallanProcessTransDAO.getPODetails(vo);	
	NewChallanProcessTransDAO.getChallanReceivedDetails(vo);		
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("NewChallanProcessTransBO.viewChallan() --> "
				+ vo.getStrMsgString());
	}
}
public void getReceivedItemDetails(NewChallanProcessTransVO vo) {
	NewChallanProcessTransDAO.getReceivedItemDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("NewChallanProcessTransBO.getReceivedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}

public void getVerifiedItemDetails(NewChallanProcessTransVO vo) {
	NewChallanProcessTransDAO.getVerifiedItemDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("NewChallanProcessTransBO.getVerifiedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}

public void getPrintDetails(NewChallanProcessTransVO vo) {
	NewChallanProcessTransDAO.getPrintDetails(vo);
	if (vo.getStrMsgType().equals("1")) {
		vo.setStrMsgString("NewChallanProcessTransBO.getVerifiedItemDetails() --> "
				+ vo.getStrMsgString());
	}
}
}
