/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.DrugProfileDAO;
import mms.transactions.vo.DrugProfileVO;

/**
 * @author pankaj Date-- 22-Jan-2009 Business Object Class for Drug Profile
 *         Transaction
 * 
 */
public class DrugProfileBO {
	public void setGroupComboValues(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.setGroupComboValues(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setGroupComboValues---->"
							+ _drugProfileVO.getStrMsgString());
	}
	
	public void setGenericDtl(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.setGenericDtl(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setGroupComboValues---->"
							+ _drugProfileVO.getStrMsgString());
	}
	
	public void setBrandComboValues(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.brandItemCombo(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setGroupComboValues---->"
							+ _drugProfileVO.getStrMsgString());
	}

	public void setSubGroupComboValues(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.setSubGroupComboValues(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setSubGroupComboValues---->"
							+ _drugProfileVO.getStrMsgString());
	}

	public void setDrugComboValues(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.setDrugComboValues(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setDrugComboValues---->"
							+ _drugProfileVO.getStrMsgString());
	}
	
	public void setBrandedItemData(DrugProfileVO _drugProfileVO) {
		DrugProfileDAO.setBrandedItemData(_drugProfileVO);
		if (_drugProfileVO.getStrMsgType().equals("1"))
			_drugProfileVO
					.setStrMsgString("DrugProfileBO.setBrandedItemData---->"
							+ _drugProfileVO.getStrMsgString());
	}

	public void setDosageAndIndicationData(DrugProfileVO _drugProfileVO) 
	{		
		try 
		{
			DrugProfileDAO.setDosageAndIndicationData(_drugProfileVO);

			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
		} 
		catch (Exception _Err) 
		{
			
			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileBO.setDosageAndIndicationData---->"+ _drugProfileVO.getStrMsgString());
		}
	}

	public void setSaftyAlertData(DrugProfileVO _drugProfileVO) 
	{		
		try 
		{
			DrugProfileDAO.setSaftyAlertData(_drugProfileVO);
			
			if (_drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(_drugProfileVO.getStrMsgString());
		} 
		catch (Exception _Err) 
		{
			_drugProfileVO.setStrMsgType("1");
			_drugProfileVO.setStrMsgString("DrugProfileBO.setSaftyAlertData---->"+ _drugProfileVO.getStrMsgString());
		}
	}
}
