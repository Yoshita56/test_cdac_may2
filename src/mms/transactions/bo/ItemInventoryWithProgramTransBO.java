/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.ItemInventoryWithProgramTransDAO;
import mms.transactions.vo.ItemInventoryWithProgramTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransBO.
 */
public class ItemInventoryWithProgramTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void initialAdd(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.initAddQuery(vo);
		ItemInventoryWithProgramTransDAO.getItemName(vo);
		ItemInventoryWithProgramTransDAO.getSuppliedByList(vo);
		ItemInventoryWithProgramTransDAO.getCurrencyList(vo);
		ItemInventoryWithProgramTransDAO.GetGroupNameCombo(vo);
		ItemInventoryWithProgramTransDAO.getStockStatusList(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void initialAddDummy(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.GetGroupNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.initialAddDummy() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * Gets the rate unit cmb.
	 * 
	 * @param vo
	 *            the vo
	 * @return the rate unit cmb
	 */
	public void getRateUnitCmb(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.getUnitList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.getRateUnitCmb() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void initialPhdADD(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.phdItemCombo(vo);
		ItemInventoryWithProgramTransDAO.getmanufectuteName(vo);
		//ItemInventoryWithProgramTransDAO.getProgrammeCombo(vo);
		ItemInventoryWithProgramTransDAO.getStoreType(vo);		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.initialPhdADD() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * Get Sub Group & Generic Item Name on the Basis of Store Id and Group Id.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void subGrpAndItemCmb(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.initAddQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DrugInventoryTransBO.subGrpAndItemCmb() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * for getting value of item combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item name
	 */

	public void getItemName(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getItemName(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getItemName() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of item brand combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch list
	 */

	public void getExistingBatchList(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getExistingBatchList(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of item brand combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch in stock
	 */

	public void getExistingBatchInStock(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getExistingBatchInStock(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchInStock() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of duplicate batch for Supplier.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing supp batch in stock
	 */

	public void getExistingSuppBatchInStock(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getExistingSuppBatchInStock(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchInStock() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of item brand combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the group id
	 */

	public void getGroupId(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getGroupId(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchList() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of item brand combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item brand name
	 */

	public void getItemBrandName(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getDummyItemName(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getItemBrandName() --> "
					+ strErr);
		}

	}

	/**
	 * for getting Brand Item Details.
	 * 
	 * @param vo
	 *            the vo
	 * @return the brand details
	 */

	public void getBrandDetails(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getBrandDetails(vo);
		ItemInventoryWithProgramTransDAO.getItemQCType(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getBrandDetails() --> "
					+ strErr);
		}

	}

	/**
	 * for getting value of manufacture combo.
	 * 
	 * @param vo
	 *            the vo
	 * @return the manufectute name
	 */

	public void getmanufectuteName(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getmanufectuteName() --> "
					+ strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void insert(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.insert() --> " + strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void dummyinsert(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.insertDummy(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.dummyinsert() --> "
					+ strErr);
		}

	}
	
	public void updateRecord(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.updateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.updateRecord() --> "
					+ strErr);
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void modifyRecord(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.getSuppliedByList(vo);
		ItemInventoryWithProgramTransDAO.getCurrencyList(vo);
		ItemInventoryWithProgramTransDAO.getStockStatusList(vo);
		ItemInventoryWithProgramTransDAO.modifyRecord(vo);
		ItemInventoryWithProgramTransDAO.unitRateNameCombo(vo);
		ItemInventoryWithProgramTransDAO.unitInHandNameCombo(vo);
		ItemInventoryWithProgramTransDAO.unitSaleNameCombo(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DrugInventoryTransBO.modifyRecord() --> "
					+ strErr);
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing batch details
	 */

	public void getExistingBatchDetails(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.modifyRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.getExistingBatchDetails() --> "
					+ strErr);
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void update(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.update(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.update() --> " + strErr);
		}

	}

	/**
	 * for getting value of unit combo.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void unitNameCombo(ItemInventoryWithProgramTransVO vo) {
		ItemInventoryWithProgramTransDAO.unitNameCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.unitNameCombo() --> "
					+ strErr);
		}

	}

	/**
	 * Gets the modify value.
	 * 
	 * @param vo
	 *            the vo
	 * @return the modify value
	 */
	public void getModifyValue(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.getStockModifyValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
	
	public void getItemDtls(ItemInventoryWithProgramTransVO vo) {

		ItemInventoryWithProgramTransDAO.getItemDtls(vo);


	}

}
