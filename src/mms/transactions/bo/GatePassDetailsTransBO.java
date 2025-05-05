package mms.transactions.bo;


import mms.transactions.dao.GatePassDetailsTransDAO;
import mms.transactions.vo.GatePassDetailsTransVO;
/**
 * @author baisakhi
 * 
 */
public class GatePassDetailsTransBO {
	/**
	 * for getting option value of current date and store name,gate pass type,issued by combos 
	 * 
	 * @param vo
	 * 
	 */

	public void getInitialValues(GatePassDetailsTransVO vo) {

		GatePassDetailsTransDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GatePassDetailsTransBO.getInitialValues() --> "
					+ vo.getStrMsgString());
		}
	}
	/**
	 * to insert the data 
	 *  
	 * @param vo
	 */
	public void insertRecords(GatePassDetailsTransVO vo) {

		
		GatePassDetailsTransDAO.insertProcedure(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("GatePassDetailsTransBO.insertRecords() --> "
					+ vo.getStrMsgString());
		}
		

	}
}
