/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         PurchaseOrderDtlRptBO.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.bo;

import mms.reports.dao.PurchaseOrderDtlRptDAO_NEW;
import mms.reports.vo.PurchaseOrderDtlRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseOrderDtlRptBO.
 */
public class PurchaseOrderDtlRptBO_NEW {

	/**
	 * Gets the circle list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the circle list
	 */
	public void getCircleList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getCircleList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getCircleList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the district list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the district list
	 */
	public void getDistrictList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getDistrictList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getDistrictList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the store list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the store list
	 */
	public void getStoreList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getStoreList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getStoreList()-->"
					+ strErr);
		}

	}

	/**
	 * To get Drug Store Type Combo.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the initialized values
	 */
	public void getInitializedValues(PurchaseOrderDtlRptVO_NEW voObj) {

		
		PurchaseOrderDtlRptDAO_NEW.getFinancialYearCombo(voObj);
		

		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getDwhTypeCombo()-->"
					+ strErr);
		}
	}

	/**
	 * Gets the item cat list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the item cat list
	 */
	public void getItemCatList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getItemCatList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getItemCatList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the PO type list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the PO type list
	 */
	public void getPOTypeList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getPOTypeList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getPOTypeList()-->"
					+ strErr);
		}

	}

	/**
	 * Gets the supplier list.
	 * 
	 * @param voObj
	 *            the vo obj
	 * @return the supplier list
	 */
	public void getSupplierList(PurchaseOrderDtlRptVO_NEW voObj) {

		PurchaseOrderDtlRptDAO_NEW.getSupplierList(voObj);
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("PurchaseOrderDtlRptBO.getSupplierList()-->"
					+ strErr);
		}

	}
}
