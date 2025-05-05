package mms.transactions.bo;

import mms.transactions.dao.DrugInventoryTransDAO;
import mms.transactions.vo.DrugInventoryTransVO;


/**
 * @author 
 * 
 */

/**( MODIFY/UPDATE WAS NOT WORKING)
 * Developer : Anshul Jindal ( TO CONTINUE AND CORRECTIONS)
 * Version : 1.0 Date : 20/Apr/2009
 * 
 */

public class DrugInventoryTransBO {
	

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(DrugInventoryTransVO vo) {
		
		DrugInventoryTransDAO.initAddQuery(vo);
		DrugInventoryTransDAO.getItemName(vo);
		DrugInventoryTransDAO.getSuppliedByList(vo);
		DrugInventoryTransDAO.getCurrencyList(vo);
		DrugInventoryTransDAO.GetGroupNameCombo(vo);
		DrugInventoryTransDAO.getStockStatusList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAddDummy(DrugInventoryTransVO vo) {
		
		//DrugInventoryTransDAO.initAddQuery(vo);
		DrugInventoryTransDAO.getDummyItemName(vo);		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.initialAddDummy() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/*
	 * Get Sub Group & Generic Item Name on the Basis of Store Id and Group Id
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void subGrpAndItemCmb(DrugInventoryTransVO vo) 
	{		
		DrugInventoryTransDAO.initAddQuery(vo);	
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.subGrpAndItemCmb() --> "
					+ vo.getStrMsgString());
		}
	}
	

	/**
	 * for getting value of item combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void getItemName(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.getItemName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getItemName() --> "
					+ strErr);
		}
		
	}
	
		
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchList(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchInStock(DrugInventoryTransVO vo) 
	{
		DrugInventoryTransDAO.getExistingBatchInStock(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchInStock() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getGroupId(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.getGroupId(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}
	
	
	
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getItemBrandName(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.getItemBrandName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting  Brand Item Details
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getBrandDetails(DrugInventoryTransVO vo) 
	{
		DrugInventoryTransDAO.getBrandDetails(vo);
		DrugInventoryTransDAO.getItemQCType(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getBrandDetails() --> "
					+ strErr);
		}

	}
	
	/**
	 * for getting value of manufacture combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getmanufectuteName(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getmanufectuteName() --> "
					+ strErr);
		}

	}
	
		
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void insert(DrugInventoryTransVO vo) 
	{
		DrugInventoryTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.insert() --> " + strErr);
		}

	}
	
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void dummyinsert(DrugInventoryTransVO vo) 
	{
		DrugInventoryTransDAO.insertDummy(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.insert() --> " + strErr);
		}

	}
	
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void modifyRecord(DrugInventoryTransVO vo) {
		
		DrugInventoryTransDAO.getSuppliedByList(vo);
		DrugInventoryTransDAO.getCurrencyList(vo);
		DrugInventoryTransDAO.getStockStatusList(vo);
		DrugInventoryTransDAO.modifyRecord(vo);
		DrugInventoryTransDAO.unitRateNameCombo(vo);
		DrugInventoryTransDAO.unitInHandNameCombo(vo);
		DrugInventoryTransDAO.unitSaleNameCombo(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.modifyRecord() --> " + strErr);
		}

	}
	
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getExistingBatchDetails(DrugInventoryTransVO vo) 
	{
		
		
		DrugInventoryTransDAO.modifyRecord(vo);
				
		
		if (vo.getStrMsgType().equals("1"))
		{

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchDetails() --> " + strErr);
		}

	}
	

	/** 
	 *  to update the record
	 * 
	 * @param vo
	 */
	
	public void update(DrugInventoryTransVO vo) {

		DrugInventoryTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.update() --> " + strErr);
		}

	}
	
	
	/**
	 * for getting value of unit combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void unitNameCombo(DrugInventoryTransVO vo) {
		DrugInventoryTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}

	public void getModifyValue(DrugInventoryTransVO vo) {
		
		DrugInventoryTransDAO.getStockModifyValue(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
	
}
