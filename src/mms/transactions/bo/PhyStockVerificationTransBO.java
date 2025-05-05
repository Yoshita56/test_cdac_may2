package mms.transactions.bo;

import mms.transactions.dao.PhyStockVerificationTransDAO;
import mms.transactions.vo.PhyStockVerificationTransVO;

public class PhyStockVerificationTransBO {
	
	/**
	 * This method is used for GROUP LIST
	 * @param voObj
	 */
	public void getGroupCmb(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getGroupCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getGroupCmb()-->"+strErr);
		}
		
	}
	
	/**
	 * This method is used for UNIT LIST
	 * @param voObj
	 */
	public void getUnitCmb(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getUnitCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getUnitCmb()-->"+strErr);
		}
		
	}
	
	/**
	 * This method is used for BRAND LIST
	 * @param voObj
	 */
	public void getBrandCmb(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getBrandCmb(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getBrandCmb()-->"+strErr);
		}
		
	}
	
	
	public void getItemDtl(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getItemDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getItemDtl()-->"+strErr);
		}
		
	}
	
	public void getNewItemDtl(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getNewItemDtl(voObj);
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getNewItemDtl()-->"+strErr);
		}
		
	}

	public void getPhysicalStockVerified(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getPhysicalStockVerifiedCount(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getPhysicalStockVerified()-->"+strErr);
		}
		
	}
	
	public void getPhysicalVerifyInit(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getPhysicalStockDateDtls(voObj);
		PhyStockVerificationTransDAO.getGroupCmb(voObj);
		PhyStockVerificationTransDAO.getItemSearchGroupCmb(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getPhysicalVerifyInit()-->"+strErr);
		}
		
	}
	
	public void getCountedItemsList(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.getPhysicalStockCountedItemsDtls(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getCountedItemsList()-->"+strErr);
		}
		
	}
	public void insert(PhyStockVerificationTransVO voObj){

		PhyStockVerificationTransDAO.insert(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {
			
			String strErr = voObj.getStrMsgString();
				
			voObj.setStrMsgString("PhyStockVerificationTransBO.getCountedItemsList()-->"+strErr);
		}
		
	}
public void getReviewDtl(PhyStockVerificationTransVO _PhyStockVerificationTransVO){
		
		PhyStockVerificationTransDAO.setCommitteeTypeDtl(_PhyStockVerificationTransVO);
		if (_PhyStockVerificationTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _PhyStockVerificationTransVO.getStrMsgString();
				
			_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransBO.getViewDtl()-->"+strErr);
		}
	}
public void getMemberDetails(PhyStockVerificationTransVO _PhyStockVerificationTransVO ){
	PhyStockVerificationTransDAO.getMemberDtl(_PhyStockVerificationTransVO);
	if (_PhyStockVerificationTransVO.getStrMsgType().equals("1")) {
		
		String strErr = _PhyStockVerificationTransVO.getStrMsgString();
			
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransBO.getMemberDetails()-->"+strErr);
	}
}

public void updateReview(PhyStockVerificationTransVO _PhyStockVerificationTransVO ){
	PhyStockVerificationTransDAO.updateReview(_PhyStockVerificationTransVO);
	if (_PhyStockVerificationTransVO.getStrMsgType().equals("1")) {
		
		String strErr = _PhyStockVerificationTransVO.getStrMsgString();
			
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransBO.updateReview()-->"+strErr);
	}
}
public void cancelRecord(PhyStockVerificationTransVO _PhyStockVerificationTransVO ){
	PhyStockVerificationTransDAO.cancelStock(_PhyStockVerificationTransVO);
	if (_PhyStockVerificationTransVO.getStrMsgType().equals("1")) {
		
		String strErr = _PhyStockVerificationTransVO.getStrMsgString();
			
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransBO.cancelRecord()-->"+strErr);
	}
}
public void updateStock(PhyStockVerificationTransVO _PhyStockVerificationTransVO ){
	PhyStockVerificationTransDAO.updateStock(_PhyStockVerificationTransVO);
	if (_PhyStockVerificationTransVO.getStrMsgType().equals("1")) {
		
		String strErr = _PhyStockVerificationTransVO.getStrMsgString();
			
		_PhyStockVerificationTransVO.setStrMsgString("PhyStockVerificationTransBO.updateStock()-->"+strErr);
	}
}
}
