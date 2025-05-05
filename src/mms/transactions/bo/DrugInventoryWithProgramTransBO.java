/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         DrugInventoryWithProgramTransBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.DrugInventoryWithProgramTransDAO;
import mms.transactions.dao.ReturnFromTransDAO;
import mms.transactions.vo.DrugInventoryWithProgramTransVO;
import mms.transactions.vo.ReturnFromTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugInventoryWithProgramTransBO.
 */
public class DrugInventoryWithProgramTransBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo
	 *            the vo
	 */

	public void initialAdd(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.initAddQuery(vo);
		DrugInventoryWithProgramTransDAO.getItemName(vo);
		DrugInventoryWithProgramTransDAO.getSuppliedByList(vo);
		DrugInventoryWithProgramTransDAO.getCurrencyList(vo);
		DrugInventoryWithProgramTransDAO.GetGroupNameCombo(vo);
		DrugInventoryWithProgramTransDAO.getStockStatusList(vo);

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

	public void initialAddDummy(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.GetGroupNameCombo(vo);
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
	public void getRateUnitCmb(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.getUnitList(vo);
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

	public void initialPhdADD(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.phdItemCombo(vo);
		DrugInventoryWithProgramTransDAO.getmanufectuteName(vo);
		//DrugInventoryWithProgramTransDAO.getProgrammeCombo(vo);
		DrugInventoryWithProgramTransDAO.getStoreType(vo);		
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
	public void subGrpAndItemCmb(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.initAddQuery(vo);
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

	public void getItemName(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getItemName(vo);
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

	public void getExistingBatchList(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getExistingBatchList(vo);
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

	public void getExistingBatchInStock(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getExistingBatchInStock(vo);
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

	public void getExistingSuppBatchInStock(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getExistingSuppBatchInStock(vo);
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

	public void getGroupId(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getGroupId(vo);
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

	public void getItemBrandName(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getDummyItemName(vo);
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

	public void getBrandDetails(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getBrandDetails(vo);
		DrugInventoryWithProgramTransDAO.getItemQCType(vo);
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

	public void getmanufectuteName(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.getmanufectuteName(vo);
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

	public void insert(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.insert(vo);
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

	public void dummyinsert(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.insertDummy(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DrugInventoryTransBO.dummyinsert() --> "
					+ strErr);
		}

	}
	
	public void updateRecord(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.updateRecord(vo);
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

	public void modifyRecord(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.getSuppliedByList(vo);
		DrugInventoryWithProgramTransDAO.getCurrencyList(vo);
		DrugInventoryWithProgramTransDAO.getStockStatusList(vo);
		DrugInventoryWithProgramTransDAO.modifyRecord(vo);
		DrugInventoryWithProgramTransDAO.unitRateNameCombo(vo);
		DrugInventoryWithProgramTransDAO.unitInHandNameCombo(vo);
		DrugInventoryWithProgramTransDAO.unitSaleNameCombo(vo);

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

	public void getExistingBatchDetails(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.modifyRecord(vo);
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

	public void update(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.update(vo);
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

	public void unitNameCombo(DrugInventoryWithProgramTransVO vo) {
		DrugInventoryWithProgramTransDAO.unitNameCombo(vo);
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
	public void getModifyValue(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.getStockModifyValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemInventoryTransBO.getModifyValue() --> "
					+ strErr);
		}

	}
	
	
	
	public void getItemDtls(DrugInventoryWithProgramTransVO vo) {

		DrugInventoryWithProgramTransDAO.getItemDtls(vo);


	}

	public void getImgHeader(DrugInventoryWithProgramTransVO voObj){
		DrugInventoryWithProgramTransDAO.getImageHeader(voObj);
	
	}

}
