/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.SupplierDeskInterfaceTransDAO;
import mms.transactions.vo.SupplierDeskInterfaceTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransBO.
 */
public class SupplierDeskInterfaceTransBO {

	

	
	/**
	 * for getting the PO Details.
	 * 	
	 * @return the PO details
	 */
	public void getPODetails(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.getPODetails(vo);
		SupplierDeskInterfaceTransDAO.getManufacturerList(vo);
	
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getPODetails() --> " + vo.getStrMsgString());
		}
	}
	
	/**
	 * for getting the Purchase Source Values.
	 * 
	 * @param vo the new purchase source values
	 */
	public void setPurchaseSourceValues(SupplierDeskInterfaceTransVO vo) 
	{
		vo.setStrMode("8");
		
		SupplierDeskInterfaceTransDAO.getCommonProcedure(vo);
		SupplierDeskInterfaceTransDAO.setPurchaseSourceValues(vo);
		SupplierDeskInterfaceTransDAO.getApprovedByCombo(vo);
		SupplierDeskInterfaceTransDAO.getPOPrefixCmb(vo);
		SupplierDeskInterfaceTransDAO.getFinancialYearComboFromDB(vo);
		SupplierDeskInterfaceTransDAO.setPOTypeValues(vo);
		SupplierDeskInterfaceTransDAO.getStoreDWH_TYPE_ID(vo);
		SupplierDeskInterfaceTransDAO.getScheduleTotalQty(vo);
		SupplierDeskInterfaceTransDAO.setUnitValues(vo);
		SupplierDeskInterfaceTransDAO.getScheduleDeliveryDate(vo);
	

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.setPurchaseSourceValues() --> " + vo.getStrMsgString());
		}
	}
	/**
	 * for getting the PO Details.
	 * 	
	 * @return the PO details
	 */
	public void getBatchCombo(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.getBatchCombo(vo);
		
	
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getCommonProcedure() --> " + vo.getStrMsgString());
		}
	}
	
	
	public void getCommonProcedure(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.getCommonProcedure(vo);
		SupplierDeskInterfaceTransDAO.getRejectedBatchDtl(vo);
		SupplierDeskInterfaceTransDAO.getprevInvoiceNo(vo);
		
		if(vo.getStrReplacementDirectBatchFlag().equals("1"))
		{
			SupplierDeskInterfaceTransDAO.getBatchNoList(vo);
		}
		else if(vo.getStrReplacementDirectBatchFlag().equals("2"))
		{
			SupplierDeskInterfaceTransDAO.getBatchNoList(vo);
		}
		
	
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getCommonProcedure() --> " + vo.getStrMsgString());
		}
	}
	/**
	 * for getting the PO Details.
	 * 	
	 * @return the PO details
	 */
	public void deliveryModeList(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.deliveryModeList(vo);
		
	
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.deliveryModeList() --> " + vo.getStrMsgString());
		}
	}
	
	/**
	 * for getting the PO Details.
	 * 	
	 * @return the PO details
	 */
	public void getDeliveryDetails(SupplierDeskInterfaceTransVO vo) 
	{
		//SupplierDeskInterfaceTransDAO.getDeliveryDrugNameList(vo);
	
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getDeliveryDetails() --> " + vo.getStrMsgString());
		}
	}

	

	/**
	 * Gets the schedule dtls.
	 * 
	 * @param vo
	 *            the vo
	 * @return the schedule dtls
	 */
	public void getScheduleDtls(SupplierDeskInterfaceTransVO vo) 
	{
		//SupplierDeskInterfaceTransDAO.GetVitalDrugDtlPrint(vo);
		//SupplierDeskInterfaceTransDAO.getStoreListForViewPrint(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getScheduleDtls() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * Gets the item hlp.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item hlp
	 */
	public void getItemHlp(SupplierDeskInterfaceTransVO vo) 
	{
	
		SupplierDeskInterfaceTransDAO.getCommonProcedure(vo);
		SupplierDeskInterfaceTransDAO.getUnitNameCombo(vo);	
		SupplierDeskInterfaceTransDAO.getRejectedBatchDtl(vo);
		SupplierDeskInterfaceTransDAO.getCartonSizeList(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierDeskInterfaceTransBO.getItemHlp() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * Insert freeze challan.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertAcceptance(SupplierDeskInterfaceTransVO vo) {

		SupplierDeskInterfaceTransDAO.insertAcceptance(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierDeskInterfaceTransBO.insertAcceptance() --> " + strErr);
		}

	}
	
	/**
	 * Insert freeze challan.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void insertDelivery(SupplierDeskInterfaceTransVO vo) {

		SupplierDeskInterfaceTransDAO.insertDelivery(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierDeskInterfaceTransBO.insertDelivery() --> " + strErr);
		}

	}
	
	/**
	 * Insert freeze challan.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void deleteRecords(SupplierDeskInterfaceTransVO vo) {

		SupplierDeskInterfaceTransDAO.deleteRecords(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierDeskInterfaceTransBO.deleteRecords() --> " + strErr);
		}

	}


	public void getSupplierInterfacedataList(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.getSupplierInterfacedataList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getDrugMstList---->"
					+ vo.getStrMsgString());
		}
	}
	
	public void getSupplierInterfaceRpt(SupplierDeskInterfaceTransVO vo) 
	{
		SupplierDeskInterfaceTransDAO.getSupplierInterfaceRpt(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getDrugMstList---->"
					+ vo.getStrMsgString());
		}
	}


}
