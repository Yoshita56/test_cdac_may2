/**
 * 
 */
package mms.transactions.bo;


import mms.transactions.dao.ItemInventoryTransDAO;
import mms.transactions.vo.ItemInventoryTransVO;

/**
 * @author pankaj
 * 
 */

/**( NOT INSERTING CORRECT VALUES, MODIFY/UPDATE WAS NOT WORKING AND SUBGROUP SHOULD NOT BE MANDATORY ON ADD)
 * Developer : Anshul Jindal ( TO CONTINUE AND CORRECTIONS )
 * Version : 1.0 Date : 21/Apr/2009
 * 
 */
public class ItemInventoryTransBO {

	/**
	 * for getting option value of combo on add page
	 * 
	 * @param vo
	 * @throws Exception
	 */

	public void initialAdd(ItemInventoryTransVO vo) {
		
		ItemInventoryTransDAO.initAddQuery(vo);
		ItemInventoryTransDAO.getItemName(vo);
		ItemInventoryTransDAO.getSuppliedByList(vo);
		ItemInventoryTransDAO.getCurrencyList(vo);
		
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
	
	public void getItemName(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.getItemName(vo);
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

	public void getItemBrandName(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.getItemBrandName(vo);
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

	public void getmanufectuteName(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.getmanufectuteName(vo);
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

	public void getBrandDetails(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.getBrandDetails(vo);
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

	public void insert(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.insert(vo);
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

	public void modifyRecord(ItemInventoryTransVO vo) {
		
		ItemInventoryTransDAO.getSuppliedByList(vo);
		ItemInventoryTransDAO.getWarrantyManufList(vo);
		ItemInventoryTransDAO.getCurrencyList(vo);
		ItemInventoryTransDAO.getStockStatusList(vo);
		ItemInventoryTransDAO.modifyRecord(vo);
		ItemInventoryTransDAO.unitRateNameCombo(vo);
		ItemInventoryTransDAO.unitInHandNameCombo(vo);
		ItemInventoryTransDAO.unitSaleNameCombo(vo);
		
		
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
	
	public void update(ItemInventoryTransVO vo) {

		ItemInventoryTransDAO.update(vo);
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
	
	public void unitNameCombo(ItemInventoryTransVO vo) {
		ItemInventoryTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}

	public void getModifyValue(ItemInventoryTransVO vo) {
		
		ItemInventoryTransDAO.getStockModifyValue(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
}
