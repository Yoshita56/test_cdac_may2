package mms.transactions.bo;
import mms.transactions.dao.LotsDetailTransDAO;
import mms.transactions.vo.LotsDetailTransVO;

public class LotsDetailTransBO {

	public void initAdd(LotsDetailTransVO _LotsDetailTransVO) 
	{
     
		LotsDetailTransDAO.getStoreGroupList(_LotsDetailTransVO);
		LotsDetailTransDAO.getCondemnationType(_LotsDetailTransVO);
		if (_LotsDetailTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _LotsDetailTransVO.getStrMsgString();
			_LotsDetailTransVO.setStrMsgString("LotsDetailTransBO.initAdd() --> "
					+ strErr);
		}
	}
	
	public void cancelLots(LotsDetailTransVO _LotsDetailTransVO) 
	{
     
		LotsDetailTransDAO.updateCancel(_LotsDetailTransVO);
	
		if (_LotsDetailTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _LotsDetailTransVO.getStrMsgString();
			_LotsDetailTransVO.setStrMsgString("LotsDetailTransBO.cancelLots() --> "
					+ strErr);
		}
	}
	public void insert(LotsDetailTransVO _LotsDetailTransVO)
	{
		LotsDetailTransDAO.insert(_LotsDetailTransVO);
		if (_LotsDetailTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _LotsDetailTransVO.getStrMsgString();
			
			_LotsDetailTransVO.setStrMsgString("LotsDetailTransBO.insert() --> "
					+ strErr);
		}
	}
	
}
