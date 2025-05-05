package mms.reports.bo;

import mms.reports.dao.PendingSampleDetailRptDAO;
import mms.reports.vo.PendingSampleDetailRptVO;



public class PendingSampleDetailRptBO {


	/**
	 * GetData Method is Used to Populate the Data 
	 * for Lab Details DAO 
	 * @param vo
	 */
	public void initSampleIssueDetail(PendingSampleDetailRptVO sampleIssueDetailRptVO_p)
	{
		PendingSampleDetailRptDAO.getLabNameCmb(sampleIssueDetailRptVO_p);
		
		  if (sampleIssueDetailRptVO_p.getStrMsgType().equals("1")) 
		  {
			  sampleIssueDetailRptVO_p.setStrMsgString("PendingSampleDetailRptBO.initSampleIssueDetail() --> "+ sampleIssueDetailRptVO_p.getStrMsgString());
		  }
		  
	}
}
