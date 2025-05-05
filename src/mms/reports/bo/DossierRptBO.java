/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.bo;

import mms.reports.dao.DossierRptDAO;
import mms.reports.vo.DossierRptVO;

public class DossierRptBO 
{
	
		public void getInitDtl(DossierRptVO _DossierRptVO)
		{
				DossierRptDAO.setStoreCombo(_DossierRptVO);
				if (_DossierRptVO.getStrMsgType().equals("1")) 
				{
					_DossierRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _DossierRptVO.getStrMsgString());
				}				
		}
		public void setStoreCombo(DossierRptVO _DossierRptVO)
		{
			DossierRptDAO.setStoreCombo(_DossierRptVO);
			if (_DossierRptVO.getStrMsgType().equals("1")) 
			{
					_DossierRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "+ _DossierRptVO.getStrMsgString());
			}				
		}
		
		/**
		 * 
		 * @param _DossierRptVO
		 */
		public void getItemCateg(DossierRptVO _DossierRptVO){
				
				DossierRptDAO.setItemCategCombo(_DossierRptVO);
				
				if (_DossierRptVO.getStrMsgType().equals("1")) {
					_DossierRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "
							+ _DossierRptVO.getStrMsgString());
				}
				
			}


		public void getDrugNameCombo(DossierRptVO _DossierRptVO){
			
			DossierRptDAO.getDrugNameCombo(_DossierRptVO);
			
			if (_DossierRptVO.getStrMsgType().equals("1")) 
			{
				_DossierRptVO.setStrMsgString("IssueDetailRptBO.getInitDtl() --> "	+ _DossierRptVO.getStrMsgString());
			}
			
		}
		
		/**
		 * for get Existing Batch List
		 * 
		 * @param vo
		 * @throws Exception
		 */

		public void getExistingBatchList(DossierRptVO vo) {
			DossierRptDAO.getExistingBatchList(vo);
			if (vo.getStrMsgType().equals("1")) {

				String strErr = vo.getStrMsgString();

				vo.setStrMsgString("IssueDetailRptBO.getExistingBatchList() --> "
						+ strErr);
			}

		}
		public void getHospitalName(DossierRptVO voObj)
		{
			DossierRptDAO.getHospitalName(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				String strErr = voObj.getStrMsgString();
				voObj.setStrMsgString("ItemWiseConsumptionRptBO.getHospitalName()-->"+strErr);
			}		
		}

}
