package dossier.masters.bo;

import mms.masters.dao.StoreHierarchyMstDAO;
import dossier.masters.dao.DossierItemMstDAO;
import dossier.masters.dao.DossierMstDAO;
import dossier.masters.vo.DossierItemMstVO;
import dossier.masters.vo.DossierMstVO;
import dossier.transaction.dao.DossierRequisitionDAO;
import dossier.transaction.vo.DossierRequisitionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierItemMstBO.
 * 
 */
public class DossierItemMstBO {

		public void initAdd(DossierItemMstVO vo) {

			DossierItemMstDAO.initAddQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemMstBO.initAdd() --> "
						+ vo.getStrMsgString());
			}
		}

		
		public void getItemCatDtls(DossierItemMstVO voObj){
			
			DossierItemMstDAO.getItemCatDtls(voObj);
			if (voObj.getStrMsgType().equals("1")) {
						
						String strErr = voObj.getStrMsgString();
							
						voObj.setStrMsgString("DossierItemMstBO.getItemCatDtls()-->"+strErr);
					}
					
			}
		/**
		 * to insert the data and check duplicate before insert record.
		 * 
		 * @param vo the vo
		 */
		public void insertRecord(DossierItemMstVO vo) {
			
			DossierItemMstDAO.InsertQueryLogic(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemMstBO.insertRecord() --> "
						+ vo.getStrMsgString());
			}

		}

		/**
		 * to get data for modify page.
		 * 
		 * @param vo the vo
		 * 
		 * @throws Exception 	 */
		public void modifyRecord(DossierItemMstVO vo) {

			DossierItemMstDAO.modifyQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemMstBO.modifyRecord() --> "
						+ vo.getStrMsgString());
			}
		}

		/**
		 * to check duplicate before update and update the record.
		 * 
		 * @param vo the vo
		 */
		public void updateRecord(DossierItemMstVO vo) {

			DossierItemMstDAO.updateQuery(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemMstBO.updateRecord() --> "
						+ vo.getStrMsgString());
			}

		}
		
		/**
		 * To get data on view page.
		 * 
		 * @param vo the vo
		 */
		public void getView(DossierItemMstVO vo) {

			DossierItemMstDAO.view(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("DossierItemMstBO.view() --> "
						+ vo.getStrMsgString());
			}

		}
		
	}

///////////////////////////////////////////////////////////////////////////////////////////////