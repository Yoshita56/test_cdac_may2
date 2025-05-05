/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;

import mms.reports.dao.DossierReqRptDAO;
import mms.reports.vo.DossierReqRptVO;

public class DossierReqRptBO 
{
	
		public void getInitDtl(DossierReqRptVO _DossierReqRptVO)
		{
				DossierReqRptDAO.setStoreCombo(_DossierReqRptVO);
				if (_DossierReqRptVO.getStrMsgType().equals("1")) 
				{
					_DossierReqRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _DossierReqRptVO.getStrMsgString());
				}				
		}
		public void setStoreCombo(DossierReqRptVO _DossierReqRptVO)
		{
			DossierReqRptDAO.setStoreCombo(_DossierReqRptVO);
			if (_DossierReqRptVO.getStrMsgType().equals("1")) 
			{
					_DossierReqRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _DossierReqRptVO.getStrMsgString());
			}				
		}
		
		/**
		 * 
		 * @param _DossierReqRptVO
		 */
		public void getItemCateg(DossierReqRptVO _DossierReqRptVO){
				
				DossierReqRptDAO.setItemCategCombo(_DossierReqRptVO);
				
				if (_DossierReqRptVO.getStrMsgType().equals("1")) {
					_DossierReqRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
							+ _DossierReqRptVO.getStrMsgString());
				}
				
			}


		public void getDrugNameCombo(DossierReqRptVO _DossierReqRptVO){
			
			DossierReqRptDAO.getDrugNameCombo(_DossierReqRptVO);
			
			if (_DossierReqRptVO.getStrMsgType().equals("1")) 
			{
				_DossierReqRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "	+ _DossierReqRptVO.getStrMsgString());
			}
			
		}
		
		/**
		 * for get Existing Batch List
		 * 
		 * @param vo
		 * @throws Exception
		 */

		public void getExistingBatchList(DossierReqRptVO vo) {
			DossierReqRptDAO.getExistingBatchList(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("IssueDetailRptBO.getExistingBatchList() --> "
						+ strErr);
			}

		}
		public void getHospitalName(DossierReqRptVO voObj)
		{
			DossierReqRptDAO.getHospitalName(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("ItemWiseConsumptionRptBO.getHospitalName()-->"+strErr);
			}		
		}

}
