package mms.transactions.bo;

import mms.transactions.dao.MiscellaneousConsumptionTransDAO;
import mms.transactions.vo.MiscellaneousConsumptionTransVO;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 20/April/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * ModDate : 29/May/2009
 * Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

public class MiscellaneousConsumptionBO {
	
	
	/**This method is used to populate the value of Store Name combo. For this activity this method called the
	 * getInitialValues() method which is define in MiscellaneousConsumptionTransDAO java file.
	 * @param vo
	 */
	public void getInitialValues(MiscellaneousConsumptionTransVO vo) {

		MiscellaneousConsumptionTransDAO.getInitialValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("MiscellaneousConsumptionBO.getInitialValues() --> "
							+ vo.getStrMsgString());
		}
	}
	
	/**This method is used to populate the value of Item Category combo . For this activity this method called the 
	 * getItemCategoryCmb() method which is define in MiscellaneousConsumptionTransDAO java file.
	 * @param vo
	 */
	public void getItemCategoryCmb(MiscellaneousConsumptionTransVO vo) {

		MiscellaneousConsumptionTransDAO.getItemCategoryCmb(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("MiscellaneousConsumptionBO.getItemCategoryCmb() --> "
							+ vo.getStrMsgString());
		}
	}
	
	/** This method is used to populate the value of Group name combo box and for it it will call getGroupNameValues()method which is define in MiscellaneousConsumptionTransDAO java file
	 * @param vo
	 */
	public void getGroupNameValues(MiscellaneousConsumptionTransVO vo)
	{

		MiscellaneousConsumptionTransDAO.getGroupNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MiscellaneousConsumptionBO.getGroupNameValues() --> "
					+ vo.getStrMsgString());
		}
	}
	
	
	/**This method is used to insert the Miscellaneous Consumptions in database for this activity this method call
	 * the insertMiscConsumpRecord() method which is define in MiscellaneousConsumptionTransDAO java file.
	 * @param vo
	 */
	public void insertMiscConsumpRecord(MiscellaneousConsumptionTransVO vo) {

		MiscellaneousConsumptionTransDAO.insertMiscConsumpRecord(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("MiscellaneousConsumptionBO.insertMiscConsumpRecord() --> "
							+ vo.getStrMsgString());
		}
	}
}
