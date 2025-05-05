/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.SupplierReceiptDAO;
import mms.transactions.vo.SupplierReceiptVO;

/**
 * @author user
 *
 */
public class SupplierReceiptBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(SupplierReceiptVO vo)
	{
		SupplierReceiptDAO.getFinancialYear(vo);
		SupplierReceiptDAO.getSupplierList(vo);
		SupplierReceiptDAO.getItemList(vo);
		SupplierReceiptDAO.getInstituteList1(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseNewTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	public void save(SupplierReceiptVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			SupplierReceiptDAO.save(vo);
		//}else{
		//	SupplierReceiptDAO.stockDetails(vo);
		//	SupplierReceiptDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseNewTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getPrintDetails(SupplierReceiptVO vo) {
		SupplierReceiptDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ChallanProcessTransBO.getVerifiedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}

}
