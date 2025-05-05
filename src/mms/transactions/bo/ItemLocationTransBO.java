/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.ItemLocationTransDAO;
import mms.transactions.vo.ItemLocationTransVO;

/**
 * @author user
 *
 */
public class ItemLocationTransBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(ItemLocationTransVO vo)
	{
		ItemLocationTransDAO.getStoreList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	
	/**
	 * To get values of Item Category :
	 * 
	 * @param vo
	 */
	public void itemCategoryName(ItemLocationTransVO vo)
	{
			if(vo.getStrStoreId().equals("0"))
				ItemLocationTransDAO.itemCategoryName(vo);
			else
				ItemLocationTransDAO.getItemCatDtls(vo);
			
			
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("ItemLocationTransBO.itemCategoryName---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
			
	}
	
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupName(ItemLocationTransVO vo)
	{
		ItemLocationTransDAO.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of SubGroup Name associate with Group Name:
	 * 
	 * @param vo
	 */
	public void getSubGroupName(ItemLocationTransVO vo)
	{
		ItemLocationTransDAO.subGroupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.getSubGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getGenItemName(ItemLocationTransVO vo)
	{
		ItemLocationTransDAO.genItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.getGenItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Name associate with Store, Item Category, Group Name, SubGrp & GenItem Name:
	 * 
	 * @param vo
	 */
	public void getItemName(ItemLocationTransVO vo)
	{
		ItemLocationTransDAO.itemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.getItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Batch No associate with Item Name:
	 * 
	 * @param vo
	 */
	public void getBatchSerialNo(ItemLocationTransVO vo)
	{
		if(vo.getStrItemCategoryNo().equals("10")){
			
		     ItemLocationTransDAO.batchNo(vo);
		     
		}else{
			
			if(vo.getStrIsBatchNo().equals("1"))
			 ItemLocationTransDAO.batchNo(vo);
			
			if(vo.getStrIsSlNo().equals("1"))
			 ItemLocationTransDAO.serialNo(vo);
		}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.getBatchSerialNo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Stock Details:
	 * 
	 * @param vo
	 */
	public void searchStockDtl(ItemLocationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			ItemLocationTransDAO.stockDetails(vo);
		//}else{
		//	ItemLocationTransDAO.stockDetails(vo);
		//	ItemLocationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemLocationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
