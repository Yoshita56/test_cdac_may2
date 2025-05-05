package mms.reports.bo;

import mms.reports.dao.MRNAckReportDAO;
import mms.reports.vo.MRNAckReportVO;

public class MRNAckReportBO {

	public void initialGenAdd(MRNAckReportVO vo){
		
		MRNAckReportDAO.storeName(vo);
		MRNAckReportDAO.getInstituteList(vo);
		MRNAckReportDAO.getSupplierCombo(vo);	
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
   public void supplierCombo(MRNAckReportVO vo)
   {				
		MRNAckReportDAO.getSupplierCombo(vo);	
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("LocalPurchaseMRN_BO.supplierCombo---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void lpitemName(MRNAckReportVO vo){	
		MRNAckReportDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(MRNAckReportVO _MRNAckReportVO){
		MRNAckReportDAO.getViewDtl(_MRNAckReportVO);
		if (_MRNAckReportVO.getStrMsgType().equals("1")){
			_MRNAckReportVO.setStrMsgString("LocalPurchaseMRN_BO.setViewPageDtl() --> "+ _MRNAckReportVO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(MRNAckReportVO vo){	
		MRNAckReportDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("LocalPurchaseMRN_BO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(MRNAckReportVO vo){
		MRNAckReportDAO.getImageHeader(vo);
 		if (vo.getStrMsgType().equals("1")){
 			vo.setStrMsgString("LocalPurchaseMRN_BO.getImgHeader() --> "+ vo.getStrMsgString());
 		  }
 	}

}
