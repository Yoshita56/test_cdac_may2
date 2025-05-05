/**
 * 
 */
package mms.transactions.bo;

import mms.transactions.dao.RateContractDtlTransDAO;
import mms.transactions.vo.RateContractDtlTransVO;

/**
 * @author Administrator
 *
 */
public class RateContractDtlTransBO {
	

	
	
	/**
	 * To get option value of Group combo on ADD page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void getGroupCombo(RateContractDtlTransVO vo){

		RateContractDtlTransDAO.getGroupCombo(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.getGroupCombo() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRecord(RateContractDtlTransVO vo){
		
		RateContractDtlTransDAO.chkDuplicate(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if(vo.getBExistStatus())
		{
			//RateContractDtlTransDAO.chkLevel(vo);
		RateContractDtlTransDAO.insertRecord(vo);
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	/**
	 * To view record
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void viewDetails(RateContractDtlTransVO vo){

		RateContractDtlTransDAO.viewDetails(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.viewDetails() --> "
					+ vo.getStrMsgString());
		}

	}
	
	/**
	 * To insert record when review
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void insertRenewData(RateContractDtlTransVO vo){
		
	/*//	RateContractDtlTransDAO.chkDuplicateAtRenew(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.insertRenewData() --> "
					+ vo.getStrMsgString());
		}
		if(vo.getBExistStatus())
		{*/
		RateContractDtlTransDAO.insertRenewData(vo);
		//}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.insertRenewData() --> "
					+ vo.getStrMsgString());
		}
		
	}
	
	public void modifyRecord(RateContractDtlTransVO vo){
		
		/*//	RateContractDtlTransDAO.chkDuplicateAtRenew(vo);
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("RateContractDtlTransBO.insertRenewData() --> "
						+ vo.getStrMsgString());
			}
			if(vo.getBExistStatus())
			{*/
			RateContractDtlTransDAO.modifyRecord(vo);
			//}
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("RateContractDtlTransBO.insertRenewData() --> "
						+ vo.getStrMsgString());
			}
			
		}
	
	/**
	 * To update record in case of terminate
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public void updateRecord(RateContractDtlTransVO vo){

		RateContractDtlTransDAO.updateRecord(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	public void insertRateContractExtension(RateContractDtlTransVO vo) {		
		RateContractDtlTransDAO.insertRateContractExtension(vo);		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("RateContractDtlTransBO.insertRenewData() --> "
					+ vo.getStrMsgString());
		}
		
	}


}
