package mms.transactions.bo;

import mms.transactions.dao.SampleRegisterPurTransDAO;
import mms.transactions.vo.SampleRegisterPurTransVO;


public class SampleRegisterPurTransBO {
	/**
	 * This mode is used to set initial parameters for recieve mode 
	 * @param vo
	 */
	
	public void getProposalList(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		
		SampleRegisterPurTransDAO.getProposalList(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getProposalList() --> "
					+ _SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	
	public void getSupplierCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
			
			
			SampleRegisterPurTransDAO.getSupplierCombo(_SampleRegisterPurTransVO);
			if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
				_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getSupplierCombo() --> "
						+ _SampleRegisterPurTransVO.getStrMsgString());
			}
		}
	
	public void getItemCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		
		SampleRegisterPurTransDAO.getItemCombo(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getItemCombo() --> "
					+ _SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	
	public void getUnitCombo(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
			
			
			SampleRegisterPurTransDAO.getUnitCombo(_SampleRegisterPurTransVO);
			if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
				_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getUnitCombo() --> "
						+ _SampleRegisterPurTransVO.getStrMsgString());
			}
		}
	
	public void insert(SampleRegisterPurTransVO _SampleRegisterPurTransVO)
	{
		SampleRegisterPurTransDAO.insert(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			String strErr = _SampleRegisterPurTransVO.getStrMsgString();
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.insert() --> "
					+ strErr);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This mode is used to set initial parameters for return mode 
	 * @param vo
	 */
	public void initialReturnAdd(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		SampleRegisterPurTransDAO.initReturnAdd(_SampleRegisterPurTransVO);
		/*SampleRegisterPurTransDAO.getUnitCombo(vo);
		SampleRegisterPurTransDAO.getIssueBy(vo);*/
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.initialReturnAdd() --> "
					+ _SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	/**
	 * This mode is used to set initial parameters for verify mode 
	 * @param vo
	 */
	public void initialVerifyAdd(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		SampleRegisterPurTransDAO.initReturnAdd(_SampleRegisterPurTransVO);
		SampleRegisterPurTransDAO.setCommitteeTypeDtl(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.initialVerifyAdd() --> "
					+ _SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	public void initialCondemnAdd(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		SampleRegisterPurTransDAO.initReturnAdd(_SampleRegisterPurTransVO);
		//SampleRegisterPurTransDAO.setCommitteeTypeDtl(vo);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.initialCondemnAdd() --> "+ 
			_SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	public void verifyUpdate(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		SampleRegisterPurTransDAO.updateVerify(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.verifyUpdate() --> "+ 
			_SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	public void condemnSample(SampleRegisterPurTransVO _SampleRegisterPurTransVO) {
		
		SampleRegisterPurTransDAO.condemnUpdate(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.condemnSample() --> "+
			_SampleRegisterPurTransVO.getStrMsgString());
		}
	}
	
	
	
	public void updateReturn(SampleRegisterPurTransVO _SampleRegisterPurTransVO)
	{
		SampleRegisterPurTransDAO.insertReturn(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _SampleRegisterPurTransVO.getStrMsgString();
			
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.updateReturn() --> "
					+ strErr);
		}
	}
	
	/**
	 * This mode is used to set initial parameters for Supplier Combo 
	 * @param vo
	 */
	
	public void getSupplierDetails(SampleRegisterPurTransVO _SampleRegisterPurTransVO)
	{
		//SampleRegisterPurTransDAO.getSupplierDtl(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			
			String strErr = _SampleRegisterPurTransVO.getStrMsgString();
			
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getSupplierDetails() --> "
					+ strErr);
		}
	}
	/**
	 * This mode is used to set initial parameters for Member Details 
	 * @param vo
	 */
	public void getMemberDetails(SampleRegisterPurTransVO _SampleRegisterPurTransVO)
	{
		SampleRegisterPurTransDAO.getMemberDtl(_SampleRegisterPurTransVO);
		if (_SampleRegisterPurTransVO.getStrMsgType().equals("1")) {
			String strErr = _SampleRegisterPurTransVO.getStrMsgString();
			_SampleRegisterPurTransVO.setStrMsgString("SampleRegisterPurTransBO.getMemberDetails() --> "
					+ strErr);
			}
	}
}
