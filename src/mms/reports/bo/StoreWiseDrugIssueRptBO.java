package mms.reports.bo;

import mms.reports.dao.StoreWiseDrugIssueRptDAO;
import mms.reports.vo.StoreWiseDrugIssueRptVO;

public class StoreWiseDrugIssueRptBO 
{
	
		public void getInitDtl(StoreWiseDrugIssueRptVO _StoreWiseDrugIssueRptVO)
		{
				StoreWiseDrugIssueRptDAO.setStoreCombo(_StoreWiseDrugIssueRptVO);
				if (_StoreWiseDrugIssueRptVO.getStrMsgType().equals("1")) 
				{
					_StoreWiseDrugIssueRptVO.setStrMsgString("StoreWiseDrugIssueRptBO.getInitDtl() --> "+ _StoreWiseDrugIssueRptVO.getStrMsgString());
				}				
		}
		public void setStoreCombo(StoreWiseDrugIssueRptVO _StoreWiseDrugIssueRptVO)
		{
			StoreWiseDrugIssueRptDAO.setStoreCombo(_StoreWiseDrugIssueRptVO);
			if (_StoreWiseDrugIssueRptVO.getStrMsgType().equals("1")) 
			{
					_StoreWiseDrugIssueRptVO.setStrMsgString("StoreWiseDrugIssueRptBO.getInitDtl() --> "+ _StoreWiseDrugIssueRptVO.getStrMsgString());
			}				
		}
		
		/**
		 * 
		 * @param _StoreWiseDrugIssueRptVO
		 */
		public void getItemCateg(StoreWiseDrugIssueRptVO _StoreWiseDrugIssueRptVO){
				
				StoreWiseDrugIssueRptDAO.setItemCategCombo(_StoreWiseDrugIssueRptVO);
				
				if (_StoreWiseDrugIssueRptVO.getStrMsgType().equals("1")) {
					_StoreWiseDrugIssueRptVO.setStrMsgString("StoreWiseDrugIssueRptBO.getInitDtl() --> "
							+ _StoreWiseDrugIssueRptVO.getStrMsgString());
				}
				
			}
		
		
		public void getUserCombo(StoreWiseDrugIssueRptVO _StoreWiseDrugIssueRptVO){
			
			StoreWiseDrugIssueRptDAO.getUserCombo(_StoreWiseDrugIssueRptVO);
			
			if (_StoreWiseDrugIssueRptVO.getStrMsgType().equals("1")) {
				_StoreWiseDrugIssueRptVO.setStrMsgString("StoreWiseDrugIssueRptBO.getInitDtl() --> "
						+ _StoreWiseDrugIssueRptVO.getStrMsgString());
			}
			
		}


		public void getDrugNameCombo(StoreWiseDrugIssueRptVO _StoreWiseDrugIssueRptVO){
			
			StoreWiseDrugIssueRptDAO.getDrugNameCombo(_StoreWiseDrugIssueRptVO);
			
			if (_StoreWiseDrugIssueRptVO.getStrMsgType().equals("1")) 
			{
				_StoreWiseDrugIssueRptVO.setStrMsgString("StoreWiseDrugIssueRptBO.getInitDtl() --> "	+ _StoreWiseDrugIssueRptVO.getStrMsgString());
			}
			
		}
		
		/**
		 * for get Existing Batch List
		 * 
		 * @param vo
		 * @throws Exception
		 */

		public void getExistingBatchList(StoreWiseDrugIssueRptVO vo) {
			StoreWiseDrugIssueRptDAO.getExistingBatchList(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("StoreWiseDrugIssueRptBO.getExistingBatchList() --> "
						+ strErr);
			}

		}
		public void getHospitalName(StoreWiseDrugIssueRptVO voObj)
		{
			StoreWiseDrugIssueRptDAO.getHospitalName(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("StoreWiseDrugIssueRptBO.getHospitalName()-->"+strErr);
			}		
		}
		
		public void getReportData(StoreWiseDrugIssueRptVO voObj)
		{
			StoreWiseDrugIssueRptDAO.getReportData(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("StoreWiseDrugIssueRptBO.getReportData()-->"+strErr);
			}		
		}

}
