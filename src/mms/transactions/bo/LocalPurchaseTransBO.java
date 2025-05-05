package mms.transactions.bo;

import mms.transactions.dao.LocalPurchaseTransDAO;
import mms.transactions.vo.LocalPurchaseTransVO;

public class LocalPurchaseTransBO {
	

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(LocalPurchaseTransVO vo) {
		
		LocalPurchaseTransDAO.initAddQuery(vo);
		LocalPurchaseTransDAO.getItemName(vo);
		LocalPurchaseTransDAO.getSuppliedByList(vo);
		LocalPurchaseTransDAO.getCurrencyList(vo);
		LocalPurchaseTransDAO.GetGroupNameCombo(vo);
		LocalPurchaseTransDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocalPurchaseTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAddDummy(LocalPurchaseTransVO vo) {
		
		//LocalPurchaseTransDAO.initAddQuery(vo);
		LocalPurchaseTransDAO.getDummyItemName(vo);		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocalPurchaseTransBO.initialAddDummy() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/*
	 * Get Sub Group & Generic Item Name on the Basis of Store Id and Group Id
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void subGrpAndItemCmb(LocalPurchaseTransVO vo) 
	{		
		LocalPurchaseTransDAO.initAddQuery(vo);	
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocalPurchaseTransBO.subGrpAndItemCmb() --> "
					+ vo.getStrMsgString());
		}
	}
	

	/**
	 * for getting value of item combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void getItemName(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.getItemName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getItemName() --> "
					+ strErr);
		}
		
	}
	
		
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchList(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchInStock(LocalPurchaseTransVO vo) 
	{
		LocalPurchaseTransDAO.getExistingBatchInStock(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getExistingBatchInStock() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getGroupId(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.getGroupId(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}
	
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getItemBrandName(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.getItemBrandName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting  Brand Item Details
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getBrandDetails(LocalPurchaseTransVO vo) 
	{
		LocalPurchaseTransDAO.getBrandDetails(vo);
		LocalPurchaseTransDAO.getItemQCType(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getBrandDetails() --> "
					+ strErr);
		}

	}
	
	/**
	 * for getting value of manufacture combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getmanufectuteName(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getmanufectuteName() --> "
					+ strErr);
		}

	}
	
		
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void insert(LocalPurchaseTransVO vo) 
	{
		LocalPurchaseTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.insert() --> " + strErr);
		}

	}
	
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void dummyinsert(LocalPurchaseTransVO vo) 
	{
		LocalPurchaseTransDAO.insertDummy(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.insert() --> " + strErr);
		}

	}
	
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void modifyRecord(LocalPurchaseTransVO vo) {
		
		LocalPurchaseTransDAO.getSuppliedByList(vo);
		LocalPurchaseTransDAO.getCurrencyList(vo);
		LocalPurchaseTransDAO.getStockStatusList(vo);
		LocalPurchaseTransDAO.modifyRecord(vo);
		LocalPurchaseTransDAO.unitRateNameCombo(vo);
		LocalPurchaseTransDAO.unitInHandNameCombo(vo);
		LocalPurchaseTransDAO.unitSaleNameCombo(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.modifyRecord() --> " + strErr);
		}

	}
	
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchDetails(LocalPurchaseTransVO vo) 
	{
		
		
		LocalPurchaseTransDAO.modifyRecord(vo);
				
		
		if (vo.getStrMsgType().equals("1"))
		{

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.getExistingBatchDetails() --> " + strErr);
		}

	}
	

	/** 
	 *  to update the record
	 * 
	 * @param vo
	 */
	
	public void update(LocalPurchaseTransVO vo) {

		LocalPurchaseTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.update() --> " + strErr);
		}

	}
	
	
	/**
	 * for getting value of unit combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void unitNameCombo(LocalPurchaseTransVO vo) {
		LocalPurchaseTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("LocalPurchaseTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}

	public void getModifyValue(LocalPurchaseTransVO vo) {
		
		LocalPurchaseTransDAO.getStockModifyValue(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
	
}
