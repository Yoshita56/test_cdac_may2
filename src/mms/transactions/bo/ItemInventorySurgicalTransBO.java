/**
 * 
 */
package mms.transactions.bo;


import mms.transactions.dao.ItemInventorySurgicalTransDAO;
import mms.transactions.vo.ItemInventorySurgicalTransVO;

/**
 * @author pankaj
 * 
 */

/**( NOT INSERTING CORRECT VALUES, MODIFY/UPDATE WAS NOT WORKING AND SUBGROUP SHOULD NOT BE MANDATORY ON ADD)
 * Developer : Anshul Jindal ( TO CONTINUE AND CORRECTIONS )
 * Version : 1.0 Date : 21/Apr/2009
 * 
 */
public class ItemInventorySurgicalTransBO {

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(ItemInventorySurgicalTransVO vo) {
		
		ItemInventorySurgicalTransDAO.initAddQuery(vo);
		ItemInventorySurgicalTransDAO.getItemName(vo);
		ItemInventorySurgicalTransDAO.getSuppliedByList(vo);
		ItemInventorySurgicalTransDAO.getCurrencyList(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemInventoryTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting value of item combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void getItemName(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.getItemName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getItemName() --> "
					+ strErr);
		}
		
	}
	
		
	/**
	 * for getting value of item brand combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getItemBrandName(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.getItemBrandName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	/**
	 * for getting value of manufacture combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getmanufectuteName(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getmanufectuteName() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * for getting  Brand Item Details
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void getBrandDetails(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.getBrandDetails(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getBrandDetails() --> "
					+ strErr);
		}

	}
	
	
	/**
	 * to insert the data
	 * 
	 * @param vo
	 */	

	public void insert(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.insert() --> " + strErr);
		}

	}
	
	/**
	 * to get data for modify page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void modifyRecord(ItemInventorySurgicalTransVO vo) {
		
		ItemInventorySurgicalTransDAO.getSuppliedByList(vo);
		ItemInventorySurgicalTransDAO.getWarrantyManufList(vo);
		ItemInventorySurgicalTransDAO.getCurrencyList(vo);
		ItemInventorySurgicalTransDAO.getStockStatusList(vo);
		ItemInventorySurgicalTransDAO.modifyRecord(vo);
		ItemInventorySurgicalTransDAO.unitRateNameCombo(vo);
		ItemInventorySurgicalTransDAO.unitInHandNameCombo(vo);
		ItemInventorySurgicalTransDAO.unitSaleNameCombo(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.modifyRecord() --> " + strErr);
		}

	}

	/** 
	 *  to update the record
	 * 
	 * @param vo
	 */
	
	public void update(ItemInventorySurgicalTransVO vo) {

		ItemInventorySurgicalTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.update() --> " + strErr);
		}

	}
	
	
	/**
	 * for getting value of unit combo 
	 * 
	 * @param vo
	 * @throws Exception
	 */
	
	public void unitNameCombo(ItemInventorySurgicalTransVO vo) {
		ItemInventorySurgicalTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}

	public void getModifyValue(ItemInventorySurgicalTransVO vo) {
		
		ItemInventorySurgicalTransDAO.getStockModifyValue(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
}
