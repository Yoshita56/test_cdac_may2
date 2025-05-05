package mms.transactions.bo;

import mms.transactions.dao.ReceiveFromThirdPartyTransDAO;
import mms.transactions.vo.ReceiveFromThirdPartyTransVO;


/**
 * 
 * @author Tanvi Sappal
 *
 */
public class ReceiveFromThirdPartyTransBO {
	
	/**
	 * To get values of Store Name and Item Category Name
	 * 
	 * @param vo
	 */
	public void initialGenAdd(ReceiveFromThirdPartyTransVO vo)
	{
		
		ReceiveFromThirdPartyTransDAO.storeName(vo);
		ReceiveFromThirdPartyTransDAO.getInstituteList(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getCategoryList(ReceiveFromThirdPartyTransVO vo)
	{
		
		ReceiveFromThirdPartyTransDAO.itemCategory(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getImgHeader(ReceiveFromThirdPartyTransVO vo){
		ReceiveFromThirdPartyTransDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReceiveFromThirdPartyTransVO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemList(ReceiveFromThirdPartyTransVO vo)
	{
		
		ReceiveFromThirdPartyTransDAO.getReceivedItemList(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemListIndividual(ReceiveFromThirdPartyTransVO vo) {

		ReceiveFromThirdPartyTransDAO.getReceivedItemListIndividual(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemList---->" + vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	
	public void getReceivedItemListTwo(ReceiveFromThirdPartyTransVO vo)
	{
		
		ReceiveFromThirdPartyTransDAO.getReceivedItemListTwo(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemListTwo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemListThree(ReceiveFromThirdPartyTransVO vo)
	{
		
		ReceiveFromThirdPartyTransDAO.getReceivedItemListThree(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemListTwo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(ReceiveFromThirdPartyTransVO vo) {
		
		ReceiveFromThirdPartyTransDAO.initAddQuery(vo);
		ReceiveFromThirdPartyTransDAO.getSuppliedByList(vo);
		ReceiveFromThirdPartyTransDAO.getCurrencyList(vo);
		ReceiveFromThirdPartyTransDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getSubGroupList(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.getSubGroupList(vo);
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
	
	public void getItemName(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.getItemName(vo);
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

	public void getItemBrandName(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.getItemBrandName(vo);
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

	public void getBrandDetails(ReceiveFromThirdPartyTransVO vo) 
	{

		ReceiveFromThirdPartyTransDAO.getBrandDetails(vo);
		
		vo.setStrMode("2");
		
		ReceiveFromThirdPartyTransDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ReceiveFromThirdPartyTransBO.getBrandDetails() --> "
					+ strErr);
		}

	}
	
	/**
	 * for getting value of manufacture combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getmanufectuteName(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.getmanufectuteName(vo);
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

	public void insert(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.insert(vo);
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
	
	public void unitNameCombo(ReceiveFromThirdPartyTransVO vo) {
		ReceiveFromThirdPartyTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getItemBrandName() --> "
					+ strErr);
		}
	}
	
	public void getVoucherDtl(ReceiveFromThirdPartyTransVO vo){
		ReceiveFromThirdPartyTransDAO.getVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReceiveFromThirdPartyTransBO.getVoucherDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

}
