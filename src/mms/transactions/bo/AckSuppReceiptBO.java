/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.AckSuppReceiptDAO;
import mms.transactions.vo.AckSuppReceiptVO;

/**
 * @author user
 *
 */
public class AckSuppReceiptBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(AckSuppReceiptVO vo)
	{
		AckSuppReceiptDAO.getPrintDetails(vo);
		AckSuppReceiptDAO.getSupplierList(vo);
		AckSuppReceiptDAO.getItemList(vo);
		AckSuppReceiptDAO.getInstituteList1(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("AckSuppReceiptBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	public void save(AckSuppReceiptVO vo)
	{
		System.out.println("---------AckSuppReceiptBO.SAVE-------------");		
		AckSuppReceiptDAO.save(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("AckSuppReceiptBO.SAVE---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void REJECT(AckSuppReceiptVO vo)
	{
		System.out.println("---------AckSuppReceiptBO.BO-------------");		
		AckSuppReceiptDAO.REJECT(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("AckSuppReceiptBO.REJECT---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getPrintDetails(AckSuppReceiptVO vo) {
		AckSuppReceiptDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AckSuppReceiptBO.getVerifiedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getPrintDetailsAfterModify(AckSuppReceiptVO vo) {
		AckSuppReceiptDAO.getPrintDetailsAfterModify(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("AckSuppReceiptBO.getPrintDetailsAfterModify() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getModifyDetails(AckSuppReceiptVO vo) 
	{
		AckSuppReceiptDAO.getPrintDetails(vo);
		AckSuppReceiptDAO.getSupplierList(vo);
		AckSuppReceiptDAO.getInstituteList1(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("AckSuppReceiptBO.getVerifiedItemDetails() --> "+ vo.getStrMsgString());
		}
	}
	
	public void modifySave(AckSuppReceiptVO vo)
	{
		System.out.println("---------AckSuppReceiptBO.BO-------------");		
		AckSuppReceiptDAO.modifySave(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("AckSuppReceiptBO.modifySave---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
