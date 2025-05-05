package mms.reports.bo;

import mms.reports.dao.POWiseMaterialReceiptRptDAO;
import mms.reports.vo.POWiseMaterialReceiptRptVO;

public class POWiseMaterialReceiptRptBO {

	public void initialGenAdd(POWiseMaterialReceiptRptVO vo){
		
		POWiseMaterialReceiptRptDAO.storeName(vo);
		POWiseMaterialReceiptRptDAO.getInstituteList(vo);
		POWiseMaterialReceiptRptDAO.getSupplierCombo(vo);	
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("POWiseMaterialReceiptRptBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
   public void supplierCombo(POWiseMaterialReceiptRptVO vo)
   {				
		POWiseMaterialReceiptRptDAO.getSupplierCombo(vo);	
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("POWiseMaterialReceiptRptBO.supplierCombo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(POWiseMaterialReceiptRptVO vo){	
		POWiseMaterialReceiptRptDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("POWiseMaterialReceiptRptBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(POWiseMaterialReceiptRptVO _POWiseMaterialReceiptRptVO){
		POWiseMaterialReceiptRptDAO.getViewDtl(_POWiseMaterialReceiptRptVO);
		if (_POWiseMaterialReceiptRptVO.getStrMsgType().equals("1")){
			_POWiseMaterialReceiptRptVO.setStrMsgString("POWiseMaterialReceiptRptBO.setViewPageDtl() --> "+ _POWiseMaterialReceiptRptVO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(POWiseMaterialReceiptRptVO vo){	
		POWiseMaterialReceiptRptDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("POWiseMaterialReceiptRptBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(POWiseMaterialReceiptRptVO vo){
		POWiseMaterialReceiptRptDAO.getImageHeader(vo);
 		if (vo.getStrMsgType().equals("1")){
 			vo.setStrMsgString("POWiseMaterialReceiptRptBO.getImgHeader() --> "+ vo.getStrMsgString());
 		  }
 	}

}
