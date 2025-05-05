package dossier.masters.bo;

import dossier.masters.dao.DossierItemBrandMstDAO;
import dossier.masters.dao.DossierItemMstDAO;
import dossier.masters.vo.DossierItemBrandMstVO;
import dossier.masters.vo.DossierItemMstVO;

public class DossierItemBrandMstBO {

	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(DossierItemBrandMstVO vo) {
		DossierItemBrandMstDAO.initialAddQuery(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("DossierItemBrandMstBO.initialAdd() --> " + strErr);
		}

	}
	public void getItemCatDtls(DossierItemBrandMstVO voObj){
		
		DossierItemBrandMstDAO.getItemCatDtls(voObj);
		if (voObj.getStrMsgType().equals("1")) {
					
					String strErr = voObj.getStrMsgString();
						
					voObj.setStrMsgString("DossierItemBrandMstBO.getItemCatDtls()-->"+strErr);
				}
				
		}
	

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public void insertQuery(DossierItemBrandMstVO vo) {

		DossierItemBrandMstDAO.chkDuplicate(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DossierItemBrandMstBO.insertQuery() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			DossierItemBrandMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("DossierItemBrandMstBO.insertQuery() --> " + strErr);
			}
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */

	public void modifyRecord(DossierItemBrandMstVO vo) {
		
		DossierItemBrandMstDAO.modifyQuery(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("DossierItemBrandMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(DossierItemBrandMstVO vo) {

		//DossierItemBrandMstDAO.chkUpdateDuplicate(vo);
		//vo.setBExistStatus(false);
		vo.setBExistStatus(true);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("DossierItemBrandMstBO.updateRecord() --> " + strErr);
		}
		if (vo.getBExistStatus() == true) {
			DossierItemBrandMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemBrandMstBO.updateRecord() --> "
						+ vo.getStrMsgString());
			}
		}
	}

	/**
	 * View.
	 * 
	 * @param vo the vo
	 */
	public void view(DossierItemBrandMstVO vo) {
		DossierItemBrandMstDAO.view(vo);

		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DossierItemBrandMstBO.view---->" + vo.getStrMsgString());
	}
	
}
