package mms.transactions.bo;


import mms.transactions.dao.CondemnRegisterTransDAO;
import mms.transactions.vo.CondemnationRegisterTransVO;

public class CondemnationRegisterTransBO {

	public void initAdd(CondemnationRegisterTransVO _CondemnationRegisterTransVO) 
	{
     
		CondemnRegisterTransDAO.getCondemnTypeDtl(_CondemnationRegisterTransVO);
		CondemnRegisterTransDAO.getItemDetails(_CondemnationRegisterTransVO);
		//CondemnRegisterTransDAO.getRequestDetails(_CondemnationRegisterTransVO);
		CondemnRegisterTransDAO.getCommitteTypeDtl(_CondemnationRegisterTransVO);
		CondemnRegisterTransDAO.getBuyerList(_CondemnationRegisterTransVO);
		if (_CondemnationRegisterTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _CondemnationRegisterTransVO.getStrMsgString();
			_CondemnationRegisterTransVO.setStrMsgString("CondemnationRegisterTransBO.initAdd() --> "
					+ strErr);
		}
	}
	public void insert(CondemnationRegisterTransVO _CondemnationRegisterTransVO)
	{
		CondemnRegisterTransDAO.insert(_CondemnationRegisterTransVO);
		if (_CondemnationRegisterTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _CondemnationRegisterTransVO.getStrMsgString();
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnationRegisterTransBO.insert() --> "
					+ strErr);
		}
	}
	public void getMemberDetails(CondemnationRegisterTransVO _CondemnationRegisterTransVO)
	{
		CondemnRegisterTransDAO.getMemberDtl(_CondemnationRegisterTransVO);
		if (_CondemnationRegisterTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _CondemnationRegisterTransVO.getStrMsgString();
			
			_CondemnationRegisterTransVO.setStrMsgString("CondemnationRegisterTransBO.getMemberDetails() --> "
					+ strErr);
		}
	}
	
}
