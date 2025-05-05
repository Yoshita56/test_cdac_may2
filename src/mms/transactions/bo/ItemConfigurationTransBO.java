package mms.transactions.bo;

import mms.transactions.dao.ItemConfigurationTransDAO;
import mms.transactions.dao.MiscellaneousConsumptionTransDAO;
import mms.transactions.vo.ItemConfigurationTransVO;
import mms.transactions.vo.MiscellaneousConsumptionTransVO;

public class ItemConfigurationTransBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(ItemConfigurationTransVO vo)
	{
		ItemConfigurationTransDAO.getStoreList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemConfigurationTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	
		
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getGenItemName(ItemConfigurationTransVO vo)
	{
		ItemConfigurationTransDAO.genItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemConfigurationTransBO.getGenItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Name associate with Store, Item Category, Group Name, SubGrp & GenItem Name:
	 * 
	 * @param vo
	 */
	public void getItemName(ItemConfigurationTransVO vo)
	{
		ItemConfigurationTransDAO.itemName_NEW(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemConfigurationTransBO.itemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
		
	/**
	 * To get values of Stock Details:
	 * 
	 * @param vo
	 */
	public void searchStockDtl(ItemConfigurationTransVO vo)
	{		
		ItemConfigurationTransDAO.stockDetails(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ItemConfigurationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	/**This method is used to insert the SAVE
	 * @param vo
	 */
	public void SAVE(ItemConfigurationTransVO vo) {

		ItemConfigurationTransDAO.SAVE(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("ItemConfigurationTransBO.SAVE() --> "
							+ vo.getStrMsgString());
		}
	}

}
