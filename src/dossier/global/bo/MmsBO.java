package dossier.global.bo;

import dossier.global.dao.MmsDAO;
import dossier.global.vo.MmsVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsBO.
 */
public class MmsBO {

	/**
	 * Gets the parent paremeter.
	 * 
	 * @param vo the vo
	 * 
	 * @return the parent paremeter
	 */
	public void getParentParemeter(MmsVO vo) {

		MmsDAO.getItemParameters(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the parent paremeter dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the parent paremeter dtls
	 */
	public void getParentParemeterDtls(MmsVO vo) {

		MmsDAO.getItemParametersDtls(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the existing paremeter dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the existing paremeter dtls
	 */
	public void getExistingParemeterDtls(MmsVO vo) {

		MmsDAO.getItemExistingParametersDtls(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("MmsBO.getExistingParemeterDtls() --> "
							+ strErr);

		}

	}

	/**
	 * Gets the existing parent paremeter dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the existing parent paremeter dtls
	 */
	public void getExistingParentParemeterDtls(MmsVO vo) {

		MmsDAO.getExistingItemParametersDtls(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the display parent paremeter.
	 * 
	 * @param vo the vo
	 * 
	 * @return the display parent paremeter
	 */
	public void getDisplayParentParemeter(MmsVO vo) {

		MmsDAO.getDisplayItemParameters(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the display parent paremeter dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the display parent paremeter dtls
	 */
	public void getDisplayParentParemeterDtls(MmsVO vo) {

		MmsDAO.getDisplayItemParametersDtls(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}

	/**
	 * Insert.
	 * 
	 * @param vo the vo
	 */
	public void insert(MmsVO vo) {

		MmsDAO.insert(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.insert() --> " + strErr);

		}

	}

	/**
	 * Update.
	 * 
	 * @param vo the vo
	 */
	public void update(MmsVO vo) {

		MmsDAO.update(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.update() --> " + strErr);

		}

	}

	/**
	 * Gets the search item init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the search item init dtls
	 */
	public void getSearchItemInitDtls(MmsVO vo) {

		MmsDAO.getGroupList(vo);
	//	MmsDAO.getSubGroupList(vo);
	//	MmsDAO.getItemList(vo);
		MmsDAO.getNewItemFlag(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}
	
	
	/**
	 * Gets the search item init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the search item init dtls
	 */
	public void getSubGroupsAndGenericItems(MmsVO vo) {

		 
		MmsDAO.getSubGroupList(vo);
		MmsDAO.getItemList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}
	

	/**
	 * Gets the search item list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the search item list dtls
	 */
	public void getSearchItemListDtls(MmsVO vo) {

		MmsDAO.getItemList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getSearchItemListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the search item brand list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the search item brand list dtls
	 */
	public void getSearchItemBrandListDtls(MmsVO vo) {

		MmsDAO.getItemBrandList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getSearchItemBrandListDtls() --> "
					+ strErr);

		}

	}

	/**
	 * Gets the unit list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the unit list dtls
	 */
	public void getUnitListDtls(MmsVO vo) {

		MmsDAO.getUnitList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getUnitListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the item mandatory details.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item mandatory details
	 */
	public void getItemMandatoryDetails(MmsVO vo) {

		MmsDAO.getItemMandatoryDetails(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getItemMandatoryDetails() --> " + strErr);

		}

	}

	/**
	 * Gets the mms listing dtl.
	 * 
	 * @param vo the vo
	 * 
	 * @return the mms listing dtl
	 */
	public void getMmsListingDtl(MmsVO vo) {

		MmsDAO.setMmsListingDtl(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.setMmsListingDtl() --> " + strErr);

		}

	}

	/**
	 * Gets the stock item dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the stock item dtls init dtls
	 */
	public void getStockItemDtlsInitDtls(MmsVO vo) {

		MmsDAO.getItemDtls(vo);
		MmsDAO.getStockItemDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("MmsBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	/**
	 * Gets the issue dtls init dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the issue dtls init dtls
	 */
	public void getIssueDtlsInitDtls(MmsVO vo) {

		MmsDAO.getIssueDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("MmsBO.getStockItemDtlsInitDtls() --> "
							+ strErr);

		}

	}

	/**
	 * Gets the free item dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the free item dtls
	 */
	public void getFreeItemDtls(MmsVO vo) {

		MmsDAO.getFreeItemDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getFreeItemDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the part item dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the part item dtls
	 */
	public void getPartItemDtls(MmsVO vo) {

		MmsDAO.getPartItemDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getPartItemDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the item warranty dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item warranty dtls
	 */
	public void getItemWarrantyDtls(MmsVO vo) {

		MmsDAO.getItemWarrantyDtlsList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getItemWarrantyDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the inits the free item dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the inits the free item dtls
	 */
	public void getInitFreeItemDtls(MmsVO vo) {

		MmsDAO.getItemCategoryList(vo);
		MmsDAO.getComponentTypeList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getInitFreeItemDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the group list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the group list dtls
	 */
	public void getGroupListDtls(MmsVO vo) {

		MmsDAO.getGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getGroupListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the sub group list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the sub group list dtls
	 */
	public void getSubGroupListDtls(MmsVO vo) {

		MmsDAO.getSubGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getSubGroupListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the gen item list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the gen item list dtls
	 */
	public void getGenItemListDtls(MmsVO vo) {

		MmsDAO.getFreeOrPartGenericItemList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getGenItemListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the item list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item list dtls
	 */
	public void getItemListDtls(MmsVO vo) {

		MmsDAO.getFreeOrPartItemList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getItemListDtls() --> " + strErr);

		}

	}

	/**
	 * Gets the item other unit list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item other unit list dtls
	 */
	public void getItemOtherUnitListDtls(MmsVO vo) {

		MmsDAO.getUnitNameCombo(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo
					.setStrMsgString("MmsBO.getItemOtherUnitListDtls() --> "
							+ strErr);

		}

	}

	/**
	 * Gets the item other init modify view.
	 * 
	 * @param vo the vo
	 * 
	 * @return the item other init modify view
	 */
	public void getItemOtherInitModifyView(MmsVO vo) {

		MmsDAO.getItemOtherDtlsInitModifyView(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getItemOtherInitModifyView() --> "
					+ strErr);

		}

	}

	/**
	 * Gets the manufacturer list dtls.
	 * 
	 * @param vo the vo
	 * 
	 * @return the manufacturer list dtls
	 */
	public void getManufacturerListDtls(MmsVO vo) {

		MmsDAO.getManufacturerList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getManufacturerListDtls() --> " + strErr);

		}

	}
	



	/**
	 * Gets Add New Items Init Details 
	 * 
	 * @param vo the vo
	 * 
	 *  
	 */
	public void getAddNewItemsInitDtls(MmsVO vo) {

		MmsDAO.getUnitList(vo);
		MmsDAO.getManufacturerList(vo);
		MmsDAO.getItemTypeCombo(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}
	
	
	/**
	 * Gets Add New Items Init Details 
	 * 
	 * @param vo the vo
	 * 
	 *  
	 */
	public void insertAddNewItemsInitDtls(MmsVO vo) {
 
			MmsDAO.insertNewItemDtls(vo);
		
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.insertAddNewItemsInitDtls() --> " + strErr);

		}

	}
	
	public void getSearchItemInitDtls1(MmsVO vo) {

		MmsDAO.getGroupList1(vo);
	//	MmsDAO.getSubGroupList(vo);
	//	MmsDAO.getItemList(vo);
		//MmsDAO.getNewItemFlag(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("MmsBO.getParentParemeterDtls() --> " + strErr);

		}

	}
	

}
