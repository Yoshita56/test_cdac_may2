package mms.transactions.bo;

import mms.transactions.dao.ReceiveFromThirdPartyTransTestDAO;
import mms.transactions.vo.ReceiveFromThirdPartyTransTestVO;

public class ReceiveFromThirdPartyTransTestBO {
	
	/**
	 * To get values of Store Name and Item Category Name
	 * 
	 * @param vo
	 */
	public void initialGenAdd(ReceiveFromThirdPartyTransTestVO vo)
	{
		
		ReceiveFromThirdPartyTransTestDAO.storeName(vo);
		ReceiveFromThirdPartyTransTestDAO.getInstituteList(vo);		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getCategoryList(ReceiveFromThirdPartyTransTestVO vo)
	{
		
		ReceiveFromThirdPartyTransTestDAO.itemCategory(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getImgHeader(ReceiveFromThirdPartyTransTestVO vo){
		ReceiveFromThirdPartyTransTestDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReceiveFromThirdPartyTransTestVO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemList(ReceiveFromThirdPartyTransTestVO vo)
	{
		
		ReceiveFromThirdPartyTransTestDAO.getReceivedItemList(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemListIndividual(ReceiveFromThirdPartyTransTestVO vo) {

		ReceiveFromThirdPartyTransTestDAO.getReceivedItemListIndividual(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemList---->" + vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	
	public void getReceivedItemListTwo(ReceiveFromThirdPartyTransTestVO vo)
	{
		
		ReceiveFromThirdPartyTransTestDAO.getReceivedItemListTwo(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("GiftedItemDetailsTransBO.getReceivedItemListTwo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getReceivedItemListThree(ReceiveFromThirdPartyTransTestVO vo)
	{
		
		ReceiveFromThirdPartyTransTestDAO.getReceivedItemListThree(vo);
				
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

	public void initialAdd(ReceiveFromThirdPartyTransTestVO vo) {
		
		ReceiveFromThirdPartyTransTestDAO.initAddQuery(vo);
		ReceiveFromThirdPartyTransTestDAO.getSuppliedByList(vo);
		ReceiveFromThirdPartyTransTestDAO.getCurrencyList(vo);
		ReceiveFromThirdPartyTransTestDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GiftedItemDetailsTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getSubGroupList(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.getSubGroupList(vo);
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
	
	public void getItemName(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.getItemName(vo);
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

	public void getItemBrandName(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.getItemBrandName(vo);
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

	public void getBrandDetails(ReceiveFromThirdPartyTransTestVO vo) 
	{

		ReceiveFromThirdPartyTransTestDAO.getBrandDetails(vo);
		
		vo.setStrMode("2");
		
		ReceiveFromThirdPartyTransTestDAO.getStockStatusList(vo);
		
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

	public void getmanufectuteName(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.getmanufectuteName(vo);
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

	public void insert(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.insert(vo);
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
	
	public void unitNameCombo(ReceiveFromThirdPartyTransTestVO vo) {
		ReceiveFromThirdPartyTransTestDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("GiftedItemDetailsTransBO.getItemBrandName() --> "
					+ strErr);
		}
	}
	
	public void getVoucherDtl(ReceiveFromThirdPartyTransTestVO vo){
		ReceiveFromThirdPartyTransTestDAO.getVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReceiveFromThirdPartyTransBO.getVoucherDtl() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

}
