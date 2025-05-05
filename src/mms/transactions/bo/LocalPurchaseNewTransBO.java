/**
 * 
 */
package mms.transactions.bo;

import mms.masters.dao.ModelTypeMstDAO;
import mms.masters.vo.ModelTypeMstVO;
import mms.reports.dao.ItemReplacementRPTDAO;
import mms.reports.vo.ItemReplacementRPTVO;
import mms.transactions.dao.LocalPurchaseNewTransDAO;
import mms.transactions.vo.LocalPurchaseNewTransVO;

/**
 * @author user
 *
 */
public class LocalPurchaseNewTransBO {
	
	/**
	 * To get values of Item Category Name:
	 * 
	 * @param vo
	 */
	public void initialAdd(LocalPurchaseNewTransVO vo)
	{
		LocalPurchaseNewTransDAO.getModelCombo(vo);
		LocalPurchaseNewTransDAO.getFinancialYear(vo);
		LocalPurchaseNewTransDAO.getSupplierList(vo);
		LocalPurchaseNewTransDAO.getItemList(vo);
		LocalPurchaseNewTransDAO.getInstituteList1(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseNewTransBO.initialAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}	
	}
	
	public void save(LocalPurchaseNewTransVO vo)
	{
		//if(vo.getStrItemCategoryNo().equals("1")){
			LocalPurchaseNewTransDAO.save(vo);
		//}else{
		//	LocalPurchaseNewTransDAO.stockDetails(vo);
		//	LocalPurchaseNewTransDAO.empStockDetails(vo);
		//}
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseNewTransBO.searchStockDtl---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void getImgHeader(LocalPurchaseNewTransVO vo){
		LocalPurchaseNewTransDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("LocalPurchaseNewTransBO.getImgHeader() --> "+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	
	public void getPrintDetails(LocalPurchaseNewTransVO vo) {
		LocalPurchaseNewTransDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocalPurchaseNewTransBO.getPrintDetails() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void getModelItemList(LocalPurchaseNewTransVO vo) 
	{
		LocalPurchaseNewTransDAO.getModelItemList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("LocalPurchaseNewTransDAO.getItemNameCombo() --> "
					+ vo.getStrMsgString());
		}
	}

}
