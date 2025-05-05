package mms.transactions.bo;

import mms.reports.dao.BreakageAndLostDrugDetailsRptDAO;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;
import mms.transactions.dao.ReturnAndCondemnationRegisterTransDAO;
import mms.transactions.vo.ReturnAndCondemnationRegisterTransVO;



public class ReturnAndCondemnationRegisterTransBO {
	
	public void initialPage(ReturnAndCondemnationRegisterTransVO vo)
	{
		ReturnAndCondemnationRegisterTransDAO.storeName(vo);
		//ReturnAndCondemnationRegisterTransDAO.getCondemnationTypeCombo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.initialPage---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	
	public void getReturnOrCondemnDrugListHlp(ReturnAndCondemnationRegisterTransVO vo)
	{
		ReturnAndCondemnationRegisterTransDAO.getReturnOrCondemnDrugListHlp(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	

	public void getcatcmb(ReturnAndCondemnationRegisterTransVO vo)
	{
		ReturnAndCondemnationRegisterTransDAO.setItemCategCombo(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	
	public void getsuppliername(ReturnAndCondemnationRegisterTransVO vo)
	{
		ReturnAndCondemnationRegisterTransDAO.getsuppliercmb(vo);
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.getNOSQDrugListHLP---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	/**
	 * for Inserting the Data
	 * 
	 * @param ReturnAndCondemnationRegisterTransVO
	 */
	public void insert(ReturnAndCondemnationRegisterTransVO vo) {
		ReturnAndCondemnationRegisterTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.insert() --> "+ vo.getStrMsgString());
	}

	public void getVoucherDtl(ReturnAndCondemnationRegisterTransVO vo) {
		ReturnAndCondemnationRegisterTransDAO.getVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("ReturnAndCondemnationRegisterTransBO.getTransferDtl() --> "+ vo.getStrMsgString());
		  }
	}
	
	public void getImgHeader(ReturnAndCondemnationRegisterTransVO vo){
		ReturnAndCondemnationRegisterTransDAO.getImageHeader(vo);
		if (vo.getStrMsgType().equals("1")){
			vo.setStrMsgString("BreakageAndLostDrugDetailsRptBO.setViewPageDtl() --> "+ vo.getStrMsgString());
		  }
	}
	
	
}
