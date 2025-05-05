package mms.transactions.bo;

import mms.transactions.dao.DupSupplierReturnFromTransDAO;
import mms.transactions.dao.GiftedItemDetailsTransDAO;
import mms.transactions.vo.DupSupplierReturnFromTransVO;
import mms.transactions.vo.GiftedItemDetailsTransVO;

/**
 * 
 * @author Tanvi Sappal
 *
 */
public class GiftedItemDetailsTransBO {
	
	/**
	 * To get values of Store Name and Item Category Name
	 * 
	 * @param vo
	 */
	public void initialGenAdd(GiftedItemDetailsTransVO vo)
	{
		
		GiftedItemDetailsTransDAO.storeName(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getCategoryList(GiftedItemDetailsTransVO vo)
	{
		
		GiftedItemDetailsTransDAO.itemCategory(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getGiftedItemList(GiftedItemDetailsTransVO vo)
	{
		
		GiftedItemDetailsTransDAO.getGiftedItemList(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getGiftedItemList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(GiftedItemDetailsTransVO vo) {
		
		GiftedItemDetailsTransDAO.initAddQuery(vo);
		GiftedItemDetailsTransDAO.getSuppliedByList(vo);
		GiftedItemDetailsTransDAO.getCurrencyList(vo);
		GiftedItemDetailsTransDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getSubGroupList(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.getSubGroupList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getSubGroupList() --> "
					+ strErr);
		}
		
	}
	
	/**
	 * for getting value of item combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void getItemName(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.getItemName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getItemName() --> "
					+ strErr);
		}
		
	}
	
		
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getItemBrandName(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.getItemBrandName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	/**
	 * for getting  Brand Item Details
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getBrandDetails(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.getBrandDetails(vo);
		vo.setStrMode("2");
		
		GiftedItemDetailsTransDAO.getStockStatusList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getBrandDetails() --> "+ strErr);
		}

	}
	
	/**
	 * for getting value of manufacture combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getmanufectuteName(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getmanufectuteName() --> "
					+ strErr);
		}

	}
	
		
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void insert(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.insert() --> " + strErr);
		}

	}
	
	
	/**
	 * for getting value of unit combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void unitNameCombo(GiftedItemDetailsTransVO vo) {
		GiftedItemDetailsTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	  public void getVoucherDtl(GiftedItemDetailsTransVO vo) {
	  GiftedItemDetailsTransDAO.getVoucherDtl(vo); if
	  (vo.getStrMsgType().equals("1")){
	  vo.setStrMsgString("GiftedItemDetailsTransBO.getVoucherDtl() --> "+
	  vo.getStrMsgString()); }
	  
	  
	  }
	 
	
	
}
