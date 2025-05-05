package mms.reports.bo;

import mms.reports.dao.SampleIssueDetailRptDAO;
import mms.reports.vo.SampleIssueDetailRptVO;



public class SampleIssueDetailRptBO {


	/**
	 * GetData Method is Used to Populate the Data 
	 * for Lab Details DAO 
	 * @param vo
	 */
	public void initSampleIssueDetail(SampleIssueDetailRptVO sampleIssueDetailRptVO_p)
	{
		SampleIssueDetailRptDAO.getLabNameCmb(sampleIssueDetailRptVO_p);
		
		  if (sampleIssueDetailRptVO_p.getStrMsgType().equals("1")) 
		  {
			  sampleIssueDetailRptVO_p.setStrMsgString("SampleIssueDetailRptBO.initSampleIssueDetail() --> "+ sampleIssueDetailRptVO_p.getStrMsgString());
		  }
		  
	}
}
