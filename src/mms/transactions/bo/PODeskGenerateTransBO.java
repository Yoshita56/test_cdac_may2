/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.PODeskGenerateTransDAO;
import mms.transactions.dao.PODeskGenerateTransNewDAO;
import mms.transactions.vo.PODeskGenerateTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransBO {
	/**
	 * for getting the Indent Details
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getRequestDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getRequestDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	
	/**
	 * for getting the PO Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getPODetails(PODeskGenerateTransVO _poDeskViewTransVO) 
	{
		PODeskGenerateTransDAO.getPODetails(_poDeskViewTransVO);
		PODeskGenerateTransDAO.getPOItemList1(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getPODetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
	
	
	
		
	/**
	 * for getting the Component Details
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getComponentDetail(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getComponentDetail(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getComponentDetail() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for getting the Indent Item Details
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getRequestItemDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getRequestItemDetails(_poDeskGenerateTransVO);
		//PODeskGenerateTransDAO.getCRWiseItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	public void getRequestModifyItemDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getRequestModifyItemDetails(_poDeskGenerateTransVO);
		//PODeskGenerateTransDAO.getCRWiseItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	
	/**
	 * for getting the PO Item Details
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getPOItemDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getPOItemDetails(_poDeskGenerateTransVO);
		//PODeskGenerateTransDAO.getCRWiseItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for getting the Item Popup Data
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getItemPopupData(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getItemPopupData(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getItemPopupData() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for getting the Indent Popup Details
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void getIndentPopupDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getIndentPopupDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getIndentPopupDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for getting the item category Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setItemCatValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setItemCatValues(_poDeskGenerateTransVO);
		PODeskGenerateTransDAO.getcallingItemCat(_poDeskGenerateTransVO);
		PODeskGenerateTransDAO.getcallingPOType(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setItemCatValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the item category Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setItemCatValues1(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setItemCatValues(_poDeskGenerateTransVO);
		
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setItemCatValues1() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Purchase Source Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setPurchaseSourceValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setPurchaseSourceValues(_poDeskGenerateTransVO);
		PODeskGenerateTransDAO.getApprovedByCombo(_poDeskGenerateTransVO);
		
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setPurchaseSourceValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void getPOPrefixCmb(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getPOPrefixCmb1(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setItemCatValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Delivery Location Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setDeliveryLocationValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setDeliveryLocationValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setDeliveryLocationValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Agent Name Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setAgentNameValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setAgentNameValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setAgentNameValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Currency Name Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setCurrencyValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setCurrencyValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setCurrencyValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	
	
	/**
	 * for getting the PO Type Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setPOTypeValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setPOTypeValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setPOTypeValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Grant Type Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setSupplierValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setSupplierValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.setSupplierValues() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Supplier Values based on RC
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setSupplierValuesBasedOnRC(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setSupplierValuesBasedOnRC(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.setSupplierValues() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void setSupplierValuesBasedOnRCDraftPO(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setSupplierValuesBasedOnRCDraftPO(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.setSupplierValues() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for getting the Unit Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setUnitValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setUnitValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setUnitValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Manufacturer Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setManufacturerValues(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setManufacturerValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setManufacturerValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void insert(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.insert(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.insert() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void insertDraft(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.insertDraft(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.insert() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	public void INSERTMODIFYDRAFT(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.INSERTMODIFYDRAFT(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.insert() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void finalsave(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.finalsave(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.insert() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void approvedPO(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		PODeskGenerateTransDAO.approvedPO(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.approvedPO() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
		/**
	 * for getting the Grant Type Values
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setSupplierValues1(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setSupplierValues(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setSupplierValues() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void setDWHList(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getDWHList(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.setDWHList() --> "+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void getItemDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getCRWiseItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void getDeptItemDetails(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getDeptItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	/**
	 * for getting the Supplier Values based on RC
	 * 
	 * @param PODeskGenerateTransVO
	 */
	public void setSupplierDetailsBasedOnRC(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.setSupplierDetailsBasedOnRC(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.setSupplierValues() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void getSupplierWiseCompiledData(PODeskGenerateTransVO _poDeskGenerateTransVO) 
	{
		PODeskGenerateTransDAO.getSupplierWiseCompiledData(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.getSupplierWiseCompiledData() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void getOtherData(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.getOtherData(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.getSupplierWiseCompiledData() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void indentDetail(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.indentDetail(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO.setStrMsgString("PODeskGenerateTransBO.getSupplierWiseCompiledData() --> "	+ _poDeskGenerateTransVO.getStrMsgString());
	}
	
	public void finalizePO(PODeskGenerateTransVO _poDeskGenerateTransVO) {
		PODeskGenerateTransDAO.finalizePO(_poDeskGenerateTransVO);
		//PODeskGenerateTransDAO.getCRWiseItemDetails(_poDeskGenerateTransVO);
		if (_poDeskGenerateTransVO.getStrMsgType().equals("1"))
			_poDeskGenerateTransVO
					.setStrMsgString("PODeskGenerateTransBO.getRequestItemDetails() --> "
							+ _poDeskGenerateTransVO.getStrMsgString());
	}

}
