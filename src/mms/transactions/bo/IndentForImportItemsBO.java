/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.IndentForImportItemsDAO;
import mms.transactions.vo.IndentForImportItemsVO;

/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 27/Apr/2009
 * 
 */
public class IndentForImportItemsBO {
	
	public void getInitialValues(IndentForImportItemsVO vo) {
		
		IndentForImportItemsDAO.getStoreName(vo);
		IndentForImportItemsDAO.ToStoreCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
							+ vo.getStrMsgString());
		}
		IndentForImportItemsDAO.getCategoryName(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
							+ vo.getStrMsgString());
		}

			IndentForImportItemsDAO.getGrantList(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
								+ vo.getStrMsgString());
			}
			

			IndentForImportItemsDAO.getGroupList(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
								+ vo.getStrMsgString());
			}
			

			IndentForImportItemsDAO.getCurrencyList(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
								+ vo.getStrMsgString());
			}
			

			IndentForImportItemsDAO.getSupplierList(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
								+ vo.getStrMsgString());
			}
			
			IndentForImportItemsDAO.getPurposeList(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("IndentForImportItemsBO.getInitialValues() --> "
								+ vo.getStrMsgString());
			}
			
			
		}
	
	public void getSubGroupCombo(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.getSubGroupCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getSubGroupCombo() --> "
							+ vo.getStrMsgString());
		}
	}
	public void getItemCombo(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.getItemCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getItemCombo() --> "
							+ vo.getStrMsgString());
		}
	}
	public void getBrandCombo(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.getBrandCombo(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getBrandCombo() --> "
							+ vo.getStrMsgString());
		}
	}
	public void getSupplierAddress(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.getSupplierAddress(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getSupplierAddress() --> "
							+ vo.getStrMsgString());
		}
	}
	
	public void insert(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.insert(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.insert() --> "
							+ vo.getStrMsgString());
		}
	}
	

	public void getStockDtls(IndentForImportItemsVO vo) {

		IndentForImportItemsDAO.getStockDtls(vo);
		IndentForImportItemsDAO.getRemainingStockDtls(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getStockDtls() --> "
							+ vo.getStrMsgString());
		}
		
	}
	
	public void getUnitCmb(IndentForImportItemsVO vo) {

		
		IndentForImportItemsDAO.getUnitCmb(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("IndentForImportItemsBO.getUnitCmb() --> "
							+ vo.getStrMsgString());
		}
	}


}
