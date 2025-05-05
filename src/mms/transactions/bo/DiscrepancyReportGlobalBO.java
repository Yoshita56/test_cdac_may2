package mms.transactions.bo;
import mms.transactions.dao.DiscrepancyReportGlobalDAO;
import mms.transactions.vo.DiscrepancyReportGlobalVO;

public class DiscrepancyReportGlobalBO {
	
	public void getBatchWiseDtl(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO ){
		
		DiscrepancyReportGlobalDAO.getBatchWise(_DiscrepancyReportGlobalVO);
		if (_DiscrepancyReportGlobalVO.getStrMsgType().equals("1")) {
			
			String strErr = _DiscrepancyReportGlobalVO.getStrMsgString();
				
			_DiscrepancyReportGlobalVO.setStrMsgString("PhyStockVerificationTransBO.getBatchWiseDtl()-->"+strErr);
		}
	}
	
	public void getGroupCombo(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO ){
		DiscrepancyReportGlobalDAO.getGroupCmbViewOrReview(_DiscrepancyReportGlobalVO);
		if (_DiscrepancyReportGlobalVO.getStrMsgType().equals("1")) {
			
			String strErr = _DiscrepancyReportGlobalVO.getStrMsgString();
				
			_DiscrepancyReportGlobalVO.setStrMsgString("PhyStockVerificationTransBO.getGroupCombo()-->"+strErr);
		}
	}
	
public void getNonDiscrepancyReport(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO ){
		
	DiscrepancyReportGlobalDAO.getDscrepNonReport(_DiscrepancyReportGlobalVO);
		
		
		if (_DiscrepancyReportGlobalVO.getStrMsgType().equals("1")) {
			
			String strErr = _DiscrepancyReportGlobalVO.getStrMsgString();
				
			_DiscrepancyReportGlobalVO.setStrMsgString("PhyStockVerificationTransBO.getDiscrepancyReport()-->"+strErr);
		}
	}

public void getDiscrepancyReport(DiscrepancyReportGlobalVO _DiscrepancyReportGlobalVO ){
	
	DiscrepancyReportGlobalDAO.getDscrepReport(_DiscrepancyReportGlobalVO);
	if (_DiscrepancyReportGlobalVO.getStrMsgType().equals("1")) {
		
		String strErr = _DiscrepancyReportGlobalVO.getStrMsgString();
			
		_DiscrepancyReportGlobalVO.setStrMsgString("PhyStockVerificationTransBO.getDiscrepancyReport()-->"+strErr);
	}
}

}
