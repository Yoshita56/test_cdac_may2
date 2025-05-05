package mms.transactions.bo;

import java.util.ResourceBundle;

import mms.transactions.dao.PODeskGenerateTransNewDAO;
import mms.transactions.vo.PODeskGenerateTransNewVO;

public class PODeskGenerateTransNewBO {
	
	/**
	 * for getting the Indent Details
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getRequestDetails(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getRequestDetails(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getRequestDetails() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	
	/**
	 * for getting the PO Details
	 * 
	 * @param PODeskViewTransVO
	 */
	public void getPODetails(PODeskGenerateTransNewVO _poDeskViewTransVO) 
	{
		PODeskGenerateTransNewDAO.getPODetails(_poDeskViewTransVO);
		PODeskGenerateTransNewDAO.getPOItemList1(_poDeskViewTransVO);
		if (_poDeskViewTransVO.getStrMsgType().equals("1"))
			_poDeskViewTransVO
					.setStrMsgString("PODeskViewTransBO.getPODetails() --> "
							+ _poDeskViewTransVO.getStrMsgString());
	}
	
	
	
		
	/**
	 * for getting the Component Details
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getComponentDetail(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getComponentDetail(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getComponentDetail() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	
	/**
	 * for getting the Is Foreign Value
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getIsForeignFlag(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		PODeskGenerateTransNewDAO.getIsForeign(_PODeskGenerateTransNewVO);
		
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getIsForeignFlag() --> "+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	
	
	/**
	 * for getting the Indent Item Details
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getRequestItemDetails(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getRequestItemDetails(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getRequestItemDetails() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	/**
	 * for getting the Item Popup Data
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getItemPopupData(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getItemPopupData(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getItemPopupData() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	/**
	 * for getting the Indent Popup Details
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getIndentPopupDetails(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getIndentPopupDetails(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getIndentPopupDetails() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	/**
	 * for getting the item category Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getPOPrefixCmb(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getPOPrefixCmb1(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setItemCatValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	
	/**
	 * for getting the item category Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setItemCatValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setItemCatValues(_PODeskGenerateTransNewVO);
		PODeskGenerateTransNewDAO.getPOPrefixCmb(_PODeskGenerateTransNewVO);
		PODeskGenerateTransNewDAO.getcallingItemCat(_PODeskGenerateTransNewVO);
		PODeskGenerateTransNewDAO.getcallingPOType(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setItemCatValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the item category Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setItemCatValues1(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setItemCatValues(_PODeskGenerateTransNewVO);
		
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setItemCatValues1() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Purchase Source Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setPurchaseSourceValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setPurchaseSourceValues(_PODeskGenerateTransNewVO);
		PODeskGenerateTransNewDAO.getApprovedByCombo(_PODeskGenerateTransNewVO);
		
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setPurchaseSourceValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Delivery Location Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setDeliveryLocationValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setDeliveryLocationValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setDeliveryLocationValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Delivery Location Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void getPOItemList(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO)
	{
		PODeskGenerateTransNewDAO.getPOItemList(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getPOItemList() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	public void getPOItemListWithoutRC(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO)
	{
		PODeskGenerateTransNewDAO.getPOItemListWithoutRC(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.getPOItemList() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Agent Name Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setAgentNameValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setAgentNameValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setAgentNameValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Currency Name Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setCurrencyValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setCurrencyValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setCurrencyValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	
	
	
	/**
	 * for getting the PO Type Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setDWHList(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.getDWHList(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setDWHList() --> "+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the PO Type Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setPOTypeValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setPOTypeValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setPOTypeValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Grant Type Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setSupplierValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setSupplierValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setSupplierValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	
	/**
	 * for getting the Grant Type Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setSupplierValues1(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setSupplierValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setSupplierValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	/**
	 * for getting the Unit Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setUnitValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		if(res.getString("PO_GENRATION_TYPE").equals("2"))
		{
		    PODeskGenerateTransNewDAO.setUnitValues(_PODeskGenerateTransNewVO);
		}
		else
		{
			PODeskGenerateTransNewDAO.setUnitValues1(_PODeskGenerateTransNewVO);
		}
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setUnitValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for getting the Unit Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setModifyUnitValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		
		    PODeskGenerateTransNewDAO.setUnitValues(_PODeskGenerateTransNewVO);
		
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setModifyUnitValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	/**
	 * for getting the Manufacturer Values
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void setManufacturerValues(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.setManufacturerValues(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.setManufacturerValues() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void insert(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.insert(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.insert() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void insertNewPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.insertNewPO(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.insertNewPO() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	
	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void updateNewPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) {
		PODeskGenerateTransNewDAO.updateNewPO(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.insertNewPO() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}
	/**
	 * for Inserting the Data
	 * 
	 * @param PODeskGenerateTransNewVO
	 */
	public void approvedPO(PODeskGenerateTransNewVO _PODeskGenerateTransNewVO) 
	{
		PODeskGenerateTransNewDAO.approvedPO(_PODeskGenerateTransNewVO);
		if (_PODeskGenerateTransNewVO.getStrMsgType().equals("1"))
			_PODeskGenerateTransNewVO
					.setStrMsgString("PODeskGenerateTransNewBO.approvedPO() --> "
							+ _PODeskGenerateTransNewVO.getStrMsgString());
	}

}
