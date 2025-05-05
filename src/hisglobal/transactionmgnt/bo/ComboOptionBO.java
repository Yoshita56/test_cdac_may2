/**
 * 
 */
package hisglobal.transactionmgnt.bo;

import hisglobal.transactionmgnt.dao.ComboOptionDAO;
import hisglobal.transactionmgnt.vo.ComboOptionVO;


/**
 * @author Pankaj Kumar
 *
 */
public class ComboOptionBO {
	public void getOptionValues(ComboOptionVO _ComboOptionVO) {
		ComboOptionDAO.getOptionValues(_ComboOptionVO);

		if (_ComboOptionVO.getStrMsgType().equals("1"))
			_ComboOptionVO
					.setStrMsgString(" ComboOptionBO.getOptionValues() --> "
							+ _ComboOptionVO.getStrMsgString());
	}
	public void getOptionQueryValues(ComboOptionVO _ComboOptionVO) {
		ComboOptionDAO.getOptionQueryValues(_ComboOptionVO);

		if (_ComboOptionVO.getStrMsgType().equals("1"))
			_ComboOptionVO
					.setStrMsgString(" ComboOptionBO.getOptionQueryValues() --> "
							+ _ComboOptionVO.getStrMsgString());
	}
}
