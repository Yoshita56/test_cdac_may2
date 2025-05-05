package mms.reports.bo;

import mms.reports.dao.SampleIssueReceiveToQualityDeptRptDAO;
import mms.reports.vo.SampleIssueReceiveToQualityDeptRptVO;

public class SampleIssueReceiveToQualityDeptRptBO {


	/**
	 * getDDWList Method is Used to Populate the Data 
	 * for DDW Details DAO 
	 * @param vo
	 */
	public void getDDWList(SampleIssueReceiveToQualityDeptRptVO sampleIssueReceiveToQualityDeptRp_p)
	{
		  SampleIssueReceiveToQualityDeptRptDAO.getDDWList(sampleIssueReceiveToQualityDeptRp_p);
		  if (sampleIssueReceiveToQualityDeptRp_p.getStrMsgType().equals("1")) 
		  {
			  sampleIssueReceiveToQualityDeptRp_p.setStrMsgString("SampleIssueReceiveToQualityDeptRptBO.getDDWList() --> "+ sampleIssueReceiveToQualityDeptRp_p.getStrMsgString());
		  }
		  
	}
}
