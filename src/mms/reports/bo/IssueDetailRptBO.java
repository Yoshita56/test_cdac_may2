/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/

package mms.reports.bo;

import mms.reports.dao.IssueDetailRptDAO;
import mms.reports.vo.IssueDetailRptVO;

public class IssueDetailRptBO 
{
	
		public void getInitDtl(IssueDetailRptVO _IssueDetailRptVO)
		{
				IssueDetailRptDAO.setStoreCombo(_IssueDetailRptVO);
				if (_IssueDetailRptVO.getStrMsgType().equals("1")) 
				{
					_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _IssueDetailRptVO.getStrMsgString());
				}				
		}
		public void setStoreCombo(IssueDetailRptVO _IssueDetailRptVO)
		{
			IssueDetailRptDAO.setStoreCombo(_IssueDetailRptVO);
			if (_IssueDetailRptVO.getStrMsgType().equals("1")) 
			{
					_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _IssueDetailRptVO.getStrMsgString());
			}				
		}
		
		/**
		 * 
		 * @param _IssueDetailRptVO
		 */
		public void getItemCateg(IssueDetailRptVO _IssueDetailRptVO){
				
				IssueDetailRptDAO.setItemCategCombo(_IssueDetailRptVO);
				
				if (_IssueDetailRptVO.getStrMsgType().equals("1")) {
					_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
							+ _IssueDetailRptVO.getStrMsgString());
				}
				
			}
		
		
		public void getUserCombo(IssueDetailRptVO _IssueDetailRptVO){
			
			IssueDetailRptDAO.getUserCombo(_IssueDetailRptVO);
			
			if (_IssueDetailRptVO.getStrMsgType().equals("1")) {
				_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
						+ _IssueDetailRptVO.getStrMsgString());
			}
			
		}


		public void getDrugNameCombo(IssueDetailRptVO _IssueDetailRptVO){
			
			IssueDetailRptDAO.getDrugNameCombo(_IssueDetailRptVO);
			
			if (_IssueDetailRptVO.getStrMsgType().equals("1")) 
			{
				_IssueDetailRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "	+ _IssueDetailRptVO.getStrMsgString());
			}
			
		}
		
		/**
		 * for get Existing Batch List
		 * 
		 * @param vo
		 * @throws Exception
		 */

		public void getExistingBatchList(IssueDetailRptVO vo) {
			IssueDetailRptDAO.getExistingBatchList(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("IssueDetailRptBO.getExistingBatchList() --> "
						+ strErr);
			}

		}
		public void getHospitalName(IssueDetailRptVO voObj)
		{
			IssueDetailRptDAO.getHospitalName(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("ItemWiseConsumptionRptBO.getHospitalName()-->"+strErr);
			}		
		}
		
		public void getReportData(IssueDetailRptVO voObj)
		{
			IssueDetailRptDAO.getReportData(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("ItemWiseConsumptionRptBO.getReportData()-->"+strErr);
			}		
		}

}
