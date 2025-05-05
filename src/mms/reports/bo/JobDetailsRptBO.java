package mms.reports.bo;

import mms.reports.dao.JobDetailsRptDAO;
import mms.reports.vo.JobDetailsRptVO;

public class JobDetailsRptBO {

	public void setViewPageDtl(JobDetailsRptVO VO){
		JobDetailsRptDAO.getViewDtl(VO);
		if (VO.getStrMsgType().equals("1")){
			VO.setStrMsgString("JobDetailsRptBO.setViewPageDtl() --> "+ VO.getStrMsgString());
		  }
		
	}
	
	public void getImgHeader(JobDetailsRptVO voObj){
		JobDetailsRptDAO.getImageHeader(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("JobDetailsRptBO.getImgHeader() --> "+ voObj.getStrMsgString());
		  }
	}
	

}
