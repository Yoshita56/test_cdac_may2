package mms.reports.bo;

import mms.reports.dao.ReturnAgainstIssuedRPTDAO;
import mms.reports.vo.ReturnAgainstIssuedRPTVO;

public class ReturnAgainstIssuedRPTBO {

	public void initialGenAdd(ReturnAgainstIssuedRPTVO vo){
		
		//ReturnAgainstIssuedRPTDAO.storeName(vo);
			if(vo.getStrMsgType().equals("1"))
			{
					vo.setStrMsgString("ReturnAgainstIssuedRPTBO.initialGenAdd---->"+vo.getStrMsgString());
					vo.setStrMsgType("1");
			}
	}
	
	public void getImgHeader(ReturnAgainstIssuedRPTVO voObj){
		
		ReturnAgainstIssuedRPTDAO.getImageHeader(voObj);
			if (voObj.getStrMsgType().equals("1"))
			{
				voObj.setStrMsgString("ReturnAgainstIssuedRPTBO.getImgHeader() --> "+ voObj.getStrMsgString());
			}
	}
	
	public void getReturnDtl(ReturnAgainstIssuedRPTVO voObj){
			
		ReturnAgainstIssuedRPTDAO.getReturnDetail(voObj);
			if (voObj.getStrMsgType().equals("1")){
				voObj.setStrMsgString("ReturnAgainstIssuedRPTBO.getReturnDtl() --> "+ voObj.getStrMsgString());
			  }
		}
	
	public void getIssuedDtl(ReturnAgainstIssuedRPTVO voObj){
		
		ReturnAgainstIssuedRPTDAO.getIssueDetail(voObj);
		if (voObj.getStrMsgType().equals("1")){
			voObj.setStrMsgString("ReturnAgainstIssuedRPTBO.getIssuedDtl() --> "+ voObj.getStrMsgString());
		  }
	}
	
	public void getReturnVoucherDtls(ReturnAgainstIssuedRPTVO vo){

		ReturnAgainstIssuedRPTDAO.getReturnVoucherDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ReturnAgainstIssuedRPTBO.getReturnVoucherDtls() --> "
							+ strErr);
		}
	}
	public void getIssueVoucherDtls(ReturnAgainstIssuedRPTVO vo) {

		ReturnAgainstIssuedRPTDAO.getIssueVoucherDtl(vo);

		if (vo.getStrMsgType().equals("1")) {
			String strErr = vo.getStrMsgString();
			vo.setStrMsgString("ReturnAgainstIssuedRPTBO.getIssueVoucherDtls() --> "
							+ strErr);
		}
	}

}
