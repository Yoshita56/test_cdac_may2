/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.ItemInventoryWithProgramSurgicalTransDAO;
import mms.transactions.vo.ItemInventoryWithProgramSurgicalTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransBO.
 */
public class ItemInventoryWithProgramSurgicalTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void initialAdd(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.initAddQuery(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getItemName(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getSuppliedByList(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getCurrencyList(vo);
		ItemInventoryWithProgramSurgicalTransDAO.GetGroupNameCombo(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getStockStatusList(vo);

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

	public void initialAddDummy(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.GetGroupNameCombo(vo);
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
	public void getRateUnitCmb(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.getUnitList(vo);
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

	public void initialPhdADD(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.phdItemCombo(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getmanufectuteName(vo);
		//ItemInventoryWithProgramSurgicalTransDAO.getProgrammeCombo(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getStoreType(vo);		
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
	public void subGrpAndItemCmb(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.initAddQuery(vo);
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

	public void getItemName(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getItemName(vo);
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

	public void getExistingBatchList(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getExistingBatchList(vo);
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

	public void getExistingBatchInStock(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getExistingBatchInStock(vo);
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

	public void getExistingSuppBatchInStock(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getExistingSuppBatchInStock(vo);
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

	public void getGroupId(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getGroupId(vo);
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

	public void getItemBrandName(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getDummyItemName(vo);
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

	public void getBrandDetails(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getBrandDetails(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getItemQCType(vo);
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

	public void getmanufectuteName(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.getmanufectuteName(vo);
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

	public void insert(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.insert(vo);
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

	public void dummyinsert(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.insertDummy(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.dummyinsert() --> "
					+ strErr);
		}

	}
	
	public void updateRecord(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.updateRecord(vo);
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

	public void modifyRecord(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.getSuppliedByList(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getCurrencyList(vo);
		ItemInventoryWithProgramSurgicalTransDAO.getStockStatusList(vo);
		ItemInventoryWithProgramSurgicalTransDAO.modifyRecord(vo);
		ItemInventoryWithProgramSurgicalTransDAO.unitRateNameCombo(vo);
		ItemInventoryWithProgramSurgicalTransDAO.unitInHandNameCombo(vo);
		ItemInventoryWithProgramSurgicalTransDAO.unitSaleNameCombo(vo);

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

	public void getExistingBatchDetails(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.modifyRecord(vo);
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

	public void update(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.update(vo);
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

	public void unitNameCombo(ItemInventoryWithProgramSurgicalTransVO vo) {
		ItemInventoryWithProgramSurgicalTransDAO.unitNameCombo(vo);
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
	public void getModifyValue(ItemInventoryWithProgramSurgicalTransVO vo) {

		ItemInventoryWithProgramSurgicalTransDAO.getStockModifyValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}

}
