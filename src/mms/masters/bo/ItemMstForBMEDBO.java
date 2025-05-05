/**
 * 
 */
package mms.masters.bo;

import mms.masters.dao.ItemMstForBMEDDAO;
import mms.masters.vo.ItemMstForBMEDVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemMstBO.
 * 
 * @author user
 */
public class ItemMstForBMEDBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(ItemMstForBMEDVO vo) {
		ItemMstForBMEDDAO.initialAddQuery(vo);
		ItemMstForBMEDDAO.getItemCodeRequired(vo);
		ItemMstForBMEDDAO.setApprovedType(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("ItemMstBO.initialAdd() --> " + strErr);
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(ItemMstForBMEDVO vo) {

		ItemMstForBMEDDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			ItemMstForBMEDDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("ItemMstBO.insertQuery() --> " + strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(ItemMstForBMEDVO vo) {
		ItemMstForBMEDDAO.modifyQuery(vo);
		ItemMstForBMEDDAO.initialAddQuery(vo);
		ItemMstForBMEDDAO.getItemCodeRequired(vo);
		
		/*
		 * This Line of code is added on 07 Jan 2010.
		 * Added by Aritra.
		 *Reason: Generic Item code is required for building item code. 
		 */
		ItemMstForBMEDDAO.setGenericItemCode(vo);
		ItemMstForBMEDDAO.setApprovedType(vo);
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ItemMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord_ORG(ItemMstForBMEDVO vo) {

		ItemMstForBMEDDAO.chkUpdateDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemMstBO.updateRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == false) {
			ItemMstForBMEDDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ItemSetsMstBO.updateRecord() --> "
						+ vo.getStrMsgString());
			}
		}
	}
	
	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(ItemMstForBMEDVO vo) {

		
			ItemMstForBMEDDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ItemSetsMstBO.updateRecord() --> "
						+ vo.getStrMsgString());
			}
		
	}

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(ItemMstForBMEDVO vo) {
		ItemMstForBMEDDAO.view(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.view---->" + vo.getStrMsgString());
	}
	
	public void consumeCombo(ItemMstForBMEDVO vo)
	{
		ItemMstForBMEDDAO.consumeCombo(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.consumeCombo---->" + vo.getStrMsgString());
	}
}
