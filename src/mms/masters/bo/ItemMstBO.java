/**
 * 
 */
package mms.masters.bo;

import mms.masters.dao.ItemMstDAO;
import mms.masters.vo.ItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemMstBO.
 * 
 * @author user
 */
public class ItemMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(ItemMstVO vo) {
		ItemMstDAO.initialAddQuery(vo);
		ItemMstDAO.getItemCodeRequired(vo);
		ItemMstDAO.setApprovedType(vo);
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
	public void insertQuery(ItemMstVO vo) {

		ItemMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			ItemMstDAO.insertQuery(vo);

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

	public void modifyRecord(ItemMstVO vo) {
		ItemMstDAO.modifyQuery(vo);
		ItemMstDAO.initialAddQuery(vo);
		ItemMstDAO.getItemCodeRequired(vo);
		
		/*
		 * This Line of code is added on 07 Jan 2010.
		 * Added by Aritra.
		 *Reason: Generic Item code is required for building item code. 
		 */
		ItemMstDAO.setGenericItemCode(vo);
		ItemMstDAO.setApprovedType(vo);
		
		
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
	public void updateRecord_ORG(ItemMstVO vo) {

		ItemMstDAO.chkUpdateDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemMstBO.updateRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == false) {
			ItemMstDAO.updateQuery(vo);
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
	public void updateRecord(ItemMstVO vo) {

		
			ItemMstDAO.updateQuery(vo);
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
	public void view(ItemMstVO vo) {
		ItemMstDAO.view(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.view---->" + vo.getStrMsgString());
	}
	
	public void consumeCombo(ItemMstVO vo)
	{
		ItemMstDAO.consumeCombo(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DrugMstBO.consumeCombo---->" + vo.getStrMsgString());
	}

	public void chkDuplicateItem(ItemMstVO vo) {

		ItemMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ItemMstBO.chkDuplicateItem() --> " + strErr);
		}
	/*	if (vo.getBExistStatus() == true) {
			//ItemMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("ItemMstBO.insertQuery() --> " + strErr);
			}
		} */
	}

}
