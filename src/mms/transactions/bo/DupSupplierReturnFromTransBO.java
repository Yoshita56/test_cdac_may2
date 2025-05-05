package mms.transactions.bo;

import mms.transactions.dao.DupSupplierReturnFromTransDAO;
import mms.transactions.vo.DupSupplierReturnFromTransVO;



public class DupSupplierReturnFromTransBO {
	
	public void initialPage(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.storeName(vo);
		//DupSupplierReturnFromTransDAO.getCondemnationTypeCombo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.initialPage---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	
	public void getReturnOrCondemnDrugListHlp(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.getReturnOrCondemnDrugListHlp(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	
	public void getSupplierDebitNumberListHlp(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.getSupplierDebitNumberListHlp(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.getSupplierDebitNumberListHlp---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

	
	public void getSupplierDebitNumberDetailHlp(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.getSupplierDebitNumberDetailHlp(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.getSupplierDebitNumberListHlp---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	
	public void getcatcmb(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.setItemCategCombo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	
	public void getsuppliername(DupSupplierReturnFromTransVO vo)
	{
		DupSupplierReturnFromTransDAO.getsuppliercmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("DupSupplierReturnFromTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	/**
	 * for Inserting the Data
	 * 
	 * @param DupSupplierReturnFromTransVO
	 */
	public void insert(DupSupplierReturnFromTransVO vo) {
		DupSupplierReturnFromTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("DupSupplierReturnFromTransBO.insert() --> "+ vo.getStrMsgString());
	}

	public void getVoucherDtl(DupSupplierReturnFromTransVO vo) {
		DupSupplierReturnFromTransDAO.getVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("DupSupplierReturnFromTransBO.getTransferDtl() --> "+ vo.getStrMsgString());
		  }
		
		
	}
	public void getDuplicateVoucherDtl(DupSupplierReturnFromTransVO vo) {
		DupSupplierReturnFromTransDAO.getDuplicateVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("DupSupplierReturnFromTransBO.getTransferDtl() --> "+ vo.getStrMsgString());
		  }
		
		
	}
	
	
}
