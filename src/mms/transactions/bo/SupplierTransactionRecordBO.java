package mms.transactions.bo;

import mms.transactions.dao.SupplierTransactionRecordDAO;
import mms.transactions.vo.SupplierTransactionRecordVO;

public class SupplierTransactionRecordBO {
	
	public void getstoreNameList(SupplierTransactionRecordVO vo)
	{
		SupplierTransactionRecordDAO.getstoreNameList(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("SupplierTransactionRecordBO.getStoreName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getCategoryList(SupplierTransactionRecordVO vo)
	{
		
		SupplierTransactionRecordDAO.itemCategory(vo);
				
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("SupplierTransactionRecordBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getDataTable(SupplierTransactionRecordVO vo) {
		try 
		{
			SupplierTransactionRecordDAO.getDataTable(vo);						
			// Check Error
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		} 
		catch (Exception e) 
		{
			// Set Error Message
			vo.setStrMsgString("SupplierTransactionRecordBO.getDataTable()--> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		
	}
	
	public void initialDrugAdd(SupplierTransactionRecordVO vo) {
	
		SupplierTransactionRecordDAO.getSupplierList(vo); //suppl
		
		SupplierTransactionRecordDAO.getSuppliedByList(vo); //manufactur

		SupplierTransactionRecordDAO.getInstituteList(vo); //purchase through
		
		SupplierTransactionRecordDAO.getItemBrandName(vo); //Drug Finder List PKG_MMS_VIEW.proc_storeitem_list [ Mode - 2 ]
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierTransactionRecordBO.initialDrugAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getPrintDetails(SupplierTransactionRecordVO vo) {
		SupplierTransactionRecordDAO.getPrintDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("SupplierTransactionRecordBO.getVerifiedItemDetails() --> "
					+ vo.getStrMsgString());
		}
	}

	public void getItemBrandName(SupplierTransactionRecordVO vo) {
		SupplierTransactionRecordDAO.getItemBrandName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierTransactionRecordBO.getItemBrandName() --> "
					+ strErr);
		}

	}
	
	public void getmanufectuteName(SupplierTransactionRecordVO vo) {
		SupplierTransactionRecordDAO.getmanufectuteName(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierTransactionRecordBO.getmanufectuteName() --> "
					+ strErr);
		}

	}
	
	public void insert(SupplierTransactionRecordVO vo) {
		SupplierTransactionRecordDAO.insert(vo);
		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("SupplierTransactionRecordBO.insert() --> " + strErr);
		}

	}
	
	public void getIssueDtlsInitDtls(SupplierTransactionRecordVO vo) 
	{
		SupplierTransactionRecordDAO.getIssueDtlsList(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("SupplierTransactionRecordBO.getStockItemDtlsInitDtls() --> " + strErr);
		}
	}
	
}
