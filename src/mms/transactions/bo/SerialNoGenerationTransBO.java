package mms.transactions.bo;

import mms.transactions.dao.SerialNoGenerationTransDAO;
import mms.transactions.vo.SerialNoGenerationTransVO;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : Business Object Class for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class SerialNoGenerationTransBO {

	public void initialData(SerialNoGenerationTransVO vo_p) {

		SerialNoGenerationTransDAO.getStoreName(vo_p);

		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("SerialNoGenerationTransBO.initialData---->"
					+ vo_p.getStrMsgString());
			vo_p.setStrMsgType("1");
		}
	}
	public void initialRePrintData(SerialNoGenerationTransVO vo_p) {

		SerialNoGenerationTransDAO.getStoreName(vo_p);

		if (vo_p.getStrMsgType().equals("1")) {
			vo_p.setStrMsgString("SerialNoGenerationTransBO.initialRePrintData---->"
					+ vo_p.getStrMsgString());
			vo_p.setStrMsgType("1");
		}
	}
	public void getCategoryList(SerialNoGenerationTransVO vo_p)
	{
		
		SerialNoGenerationTransDAO.getItemCategory(vo_p);
				
		if(vo_p.getStrMsgType().equals("1"))
		{
				vo_p.setStrMsgString("SerialNoGenerationTransDAO.getCategoryList---->"+vo_p.getStrMsgString());
				vo_p.setStrMsgType("1");
		}
	}
	
	public void getItemName(SerialNoGenerationTransVO vo_p)
	{
		
		SerialNoGenerationTransDAO.getItemName(vo_p);
				
		if(vo_p.getStrMsgType().equals("1"))
		{
				vo_p.setStrMsgString("SerialNoGenerationTransDAO.getItemName---->"+vo_p.getStrMsgString());
				vo_p.setStrMsgType("1");
		}
	}
	
	public void getReportNameList(SerialNoGenerationTransVO vo_p)
	{
		
		SerialNoGenerationTransDAO.getReportName(vo_p);
				
		if(vo_p.getStrMsgType().equals("1"))
		{
				vo_p.setStrMsgString("SerialNoGenerationTransDAO.getReportNameList---->"+vo_p.getStrMsgString());
				vo_p.setStrMsgType("1");
		}
	}
}
