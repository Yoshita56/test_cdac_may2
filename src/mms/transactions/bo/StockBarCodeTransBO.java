package mms.transactions.bo;

import mms.transactions.dao.StockBarCodeTransDAO;
import mms.transactions.vo.StockBarCodeTransVO;

public class StockBarCodeTransBO {

	public void initialGenAdd(StockBarCodeTransVO vo){
		
		StockBarCodeTransDAO.storeName(vo);
		StockBarCodeTransDAO.getInstituteList(vo);
		StockBarCodeTransDAO.getSupplierCombo(vo);
		
		if(vo.getStrMsgType().equals("1"))
		{
				vo.setStrMsgString("IndentWiseIssueRPTBO.initialGenAdd---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	
	public void getItemBatch(StockBarCodeTransVO vo){	
		StockBarCodeTransDAO.getItemBatch(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getItemBatch---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}
	public void lpitemName(StockBarCodeTransVO vo){	
		StockBarCodeTransDAO.lpitemName(vo);
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.lpitemName---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}

	public void setViewPageDtl(StockBarCodeTransVO _LocalPurchaseMRN_VO){
		StockBarCodeTransDAO.getViewDtl(_LocalPurchaseMRN_VO);
		if (_LocalPurchaseMRN_VO.getStrMsgType().equals("1")){
			_LocalPurchaseMRN_VO.setStrMsgString("IndentWiseIssueRPTBO.setViewPageDtl() --> "+ _LocalPurchaseMRN_VO.getStrMsgString());
		  }
		
	}
	
	public void getCategoryList(StockBarCodeTransVO vo){	
		StockBarCodeTransDAO.itemCategory(vo);		
		if(vo.getStrMsgType().equals("1")){
				vo.setStrMsgString("IndentWiseIssueRPTBO.getCategoryList---->"+vo.getStrMsgString());
				vo.setStrMsgType("1");
		}
	}	
	public void getImgHeader(StockBarCodeTransVO voObj){
		StockBarCodeTransDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("IndentWiseIssueRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	
	
	/**
	 * for Inserting the Data
	 * 
	 * @param ReplacementCondemnationOrderTransVO
	 */
	public void insert(StockBarCodeTransVO vo) {
		StockBarCodeTransDAO.insert(vo);
		if (vo.getStrMsgType().equals("1"))
			vo.setStrMsgString("StockBarCodeTransBO.insert() --> "+ vo.getStrMsgString());
	}
	

}
