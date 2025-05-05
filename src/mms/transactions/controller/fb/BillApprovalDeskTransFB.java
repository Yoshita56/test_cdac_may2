package mms.transactions.controller.fb;

import hisglobal.transactionutil.GenericFormBean;

public class BillApprovalDeskTransFB extends GenericFormBean {

	private static final long serialVersionUID = 02L;
	private String strSupplierBill = "";
	public String getStrSupplierBill() {
		return strSupplierBill;
	}
	public void setStrSupplierBill(String strSupplierBill) {
		this.strSupplierBill = strSupplierBill;
	}
}
