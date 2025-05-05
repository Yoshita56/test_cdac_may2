package mms.transactions.bo;
import mms.transactions.dao.SampleRegisterTransDAO;

import mms.transactions.vo.SampleRegisterTransVO;



public class SampleRegisterTransBO {
	
	/**
	 * This mode is used to set initial parameters for recieve mode 
	 * @param vo
	 */
	public void initialAdd(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		
		SampleRegisterTransDAO.getItemCategoryCombo(_SampleRegisterTransVO);
		SampleRegisterTransDAO.getStoreGroupList(_SampleRegisterTransVO);
		SampleRegisterTransDAO.getSupplierDtl(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.initialAdd() --> "
					+ _SampleRegisterTransVO.getStrMsgString());
		}
	}
	/**
	 * This mode is used to set initial parameters for return mode 
	 * @param vo
	 */
	public void initialReturnAdd(SampleRegisterTransVO _SampleRegisterTransVO) {
		SampleRegisterTransDAO.initReturnAdd(_SampleRegisterTransVO);
		/*SampleRegisterTransDAO.getUnitCombo(vo);
		SampleRegisterTransDAO.getIssueBy(vo);*/
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.initialReturnAdd() --> "
					+ _SampleRegisterTransVO.getStrMsgString());
		}
	}
	/**
	 * This mode is used to set initial parameters for verify mode 
	 * @param vo
	 */
	public void initialVerifyAdd(SampleRegisterTransVO _SampleRegisterTransVO) {
		SampleRegisterTransDAO.initReturnAdd(_SampleRegisterTransVO);
		SampleRegisterTransDAO.setCommitteeTypeDtl(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.initialVerifyAdd() --> "
					+ _SampleRegisterTransVO.getStrMsgString());
		}
	}
	public void initialCondemnAdd(SampleRegisterTransVO _SampleRegisterTransVO) {
		SampleRegisterTransDAO.initReturnAdd(_SampleRegisterTransVO);
		//SampleRegisterTransDAO.setCommitteeTypeDtl(vo);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.initialCondemnAdd() --> "+ 
			_SampleRegisterTransVO.getStrMsgString());
		}
	}
	public void verifyUpdate(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		SampleRegisterTransDAO.updateVerify(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.verifyUpdate() --> "+ 
			_SampleRegisterTransVO.getStrMsgString());
		}
	}
	public void condemnSample(SampleRegisterTransVO _SampleRegisterTransVO) {
		
		SampleRegisterTransDAO.condemnUpdate(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.condemnSample() --> "+
			_SampleRegisterTransVO.getStrMsgString());
		}
	}
	
	public void insert(SampleRegisterTransVO _SampleRegisterTransVO)
	{
		SampleRegisterTransDAO.insert(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			String strErr = _SampleRegisterTransVO.getStrMsgString();
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.insert() --> "
					+ strErr);
		}
	}
	
	public void updateReturn(SampleRegisterTransVO _SampleRegisterTransVO)
	{
		SampleRegisterTransDAO.insertReturn(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _SampleRegisterTransVO.getStrMsgString();
			
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.updateReturn() --> "
					+ strErr);
		}
	}
	
	/**
	 * This mode is used to set initial parameters for Supplier Combo 
	 * @param vo
	 */
	
	public void getSupplierDetails(SampleRegisterTransVO _SampleRegisterTransVO)
	{
		SampleRegisterTransDAO.getSupplierDtl(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _SampleRegisterTransVO.getStrMsgString();
			
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.getSupplierDetails() --> "
					+ strErr);
		}
	}
	/**
	 * This mode is used to set initial parameters for Member Details 
	 * @param vo
	 */
	public void getMemberDetails(SampleRegisterTransVO _SampleRegisterTransVO)
	{
		SampleRegisterTransDAO.getMemberDtl(_SampleRegisterTransVO);
		if (_SampleRegisterTransVO.getStrMsgType().equals("1")) {
			String strErr = _SampleRegisterTransVO.getStrMsgString();
			_SampleRegisterTransVO.setStrMsgString("SampleRegisterTransBO.getMemberDetails() --> "
					+ strErr);
			}
	}
		
}
