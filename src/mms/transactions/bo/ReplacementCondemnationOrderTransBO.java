
package mms.transactions.bo;

import mms.transactions.dao.ReplacementCondemnationOrderTransDAO;
import mms.transactions.vo.ReplacementCondemnationOrderTransVO;



public class ReplacementCondemnationOrderTransBO {
	
	public void initialPage(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.storeName(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.initialPage---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void approvedByCmb(ReplacementCondemnationOrderTransVO vo)	{
		
		ReplacementCondemnationOrderTransDAO.getApprovedByCombo(vo);
		ReplacementCondemnationOrderTransDAO.getCommitteTypeCombo(vo);
		ReplacementCondemnationOrderTransDAO.getItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.approvedByCmb---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getPendingOrderDtl(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getPendingOrderDtl(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getPendingOrderDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getNOSQDrugListHLP(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getNOSQDrugList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getExpiryRejectedDrugList(ReplacementCondemnationOrderTransVO vo)
	{
		
		ReplacementCondemnationOrderTransDAO.getExpiryDrugList(vo);
		ReplacementCondemnationOrderTransDAO.getSuggestedDrugList(vo);
		ReplacementCondemnationOrderTransDAO.getRejectedDrugList(vo);
		ReplacementCondemnationOrderTransDAO.getItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getExpiryRejectedDrugList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getregularindentdruglist(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getregularindentdruglist(vo);
	//	ReplacementCondemnationOrderTransDAO.getRejectedDrugList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getExpiryRejectedDrugList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getAvailableStockDtls(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getAvailableStockDtls(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getAvailableStockDtls---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getOrderScheduleDtl(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getOrderScheduleDtl(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getOrderScheduleDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getcatcmb(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.setItemCategCombo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getOrderScheduleDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getsuppliercmb(ReplacementCondemnationOrderTransVO vo)
	{
		ReplacementCondemnationOrderTransDAO.getsuppliercmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getOrderScheduleDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getScheduleQtyDtl(String strid,String poNo, String itemId, String itemBrandId, String batchNo, int scheduleNo, ReplacementCondemnationOrderTransVO vo)
	{
		vo.setStrStoreId(strid);
		vo.setStrPoNo(poNo);
		vo.setStrItemId(itemId);
		vo.setStrItemBrandId(itemBrandId);
		vo.setStrBatchNo(batchNo);
		vo.setStrSchduleNo(Integer.toString(scheduleNo));
		
		ReplacementCondemnationOrderTransDAO.getScheduleQtyDtl(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReplacementCondemnationOrderTransBO.getScheduleQtyDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	

	/**
	 * for Inserting the Data
	 * 
	 * @param ReplacementCondemnationOrderTransVO
	 */
	public void insert(ReplacementCondemnationOrderTransVO vo) {
		ReplacementCondemnationOrderTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ReplacementCondemnationOrderTransBO.insert() --> "+ vo.getStrMsgString());
	}
	public void CANCELORDER(ReplacementCondemnationOrderTransVO vo) {
		ReplacementCondemnationOrderTransDAO.CANCELORDER(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ReplacementCondemnationOrderTransBO.insert() --> "+ vo.getStrMsgString());
	}
	
	
}
