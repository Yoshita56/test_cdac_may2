/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.UtilityGenerationTransDAO;
import mms.transactions.vo.UtilityGenerationTransVO;

/**
 * @author user
 *
 */
public class UtilityGenerationTransBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(UtilityGenerationTransVO vo)
	{
		UtilityGenerationTransDAO.getStoreList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	public void getPatDtl(UtilityGenerationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			UtilityGenerationTransDAO.getPatDtl(vo);
			UtilityGenerationTransDAO.getPatientAccountBalance(vo);
		//}else{
		//	UtilityGenerationTransDAO.stockDetails(vo);
		//	UtilityGenerationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getUtilityNo(UtilityGenerationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			UtilityGenerationTransDAO.getUtilityNo(vo);
		//}else{
		//	UtilityGenerationTransDAO.stockDetails(vo);
		//	UtilityGenerationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getIndentNo(UtilityGenerationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			UtilityGenerationTransDAO.getIndentNo(vo);
		//}else{
		//	UtilityGenerationTransDAO.stockDetails(vo);
		//	UtilityGenerationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void save(UtilityGenerationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			UtilityGenerationTransDAO.save(vo);
		//}else{
		//	UtilityGenerationTransDAO.stockDetails(vo);
		//	UtilityGenerationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.save---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	/**
	 * To get values of Item Category :
	 * 
	 * @param vo
	 */
	public void itemCategoryName(UtilityGenerationTransVO vo)
	{
			if(vo.getStrStoreId().equals("0"))
				UtilityGenerationTransDAO.itemCategoryName(vo);
			else
				UtilityGenerationTransDAO.getItemCatDtls(vo);
			
			
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("UtilityGenerationTransBO.itemCategoryName---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
			
	}
	
	
	/**
	 * To get values of Group Name associate with Item Category:
	 * 
	 * @param vo
	 */
	public void getGroupName(UtilityGenerationTransVO vo)
	{
		UtilityGenerationTransDAO.groupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.getGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of SubGroup Name associate with Group Name:
	 * 
	 * @param vo
	 */
	public void getSubGroupName(UtilityGenerationTransVO vo)
	{
		UtilityGenerationTransDAO.subGroupName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.getSubGroupName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Generic Item Name associate with Store, Item Category, Group Name, SubGrp:
	 * 
	 * @param vo
	 */
	public void getGenItemName(UtilityGenerationTransVO vo)
	{
		UtilityGenerationTransDAO.genItemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.getGenItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Item Name associate with Store, Item Category, Group Name, SubGrp & GenItem Name:
	 * 
	 * @param vo
	 */
	public void getItemName(UtilityGenerationTransVO vo)
	{
		UtilityGenerationTransDAO.itemName(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.getItemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Batch No associate with Item Name:
	 * 
	 * @param vo
	 */
	public void getBatchSerialNo(UtilityGenerationTransVO vo)
	{
		if(vo.getStrItemCategoryNo().equals("10")){
			
		     UtilityGenerationTransDAO.batchNo(vo);
		     
		}else{
			
			if(vo.getStrIsBatchNo().equals("1"))
			 UtilityGenerationTransDAO.batchNo(vo);
			
			if(vo.getStrIsSlNo().equals("1"))
			 UtilityGenerationTransDAO.serialNo(vo);
		}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.getBatchSerialNo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * To get values of Stock Details:
	 * 
	 * @param vo
	 */
	public void searchStockDtl(UtilityGenerationTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			UtilityGenerationTransDAO.stockDetails(vo);
		//}else{
		//	UtilityGenerationTransDAO.stockDetails(vo);
		//	UtilityGenerationTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("UtilityGenerationTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

}
