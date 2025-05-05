package mms.reports.bo;

import mms.reports.dao.QcStatusforDDWDAO;
import mms.reports.vo.QcStatusforDDWVO;

public class QcStatusforDDWBO {
	

	/**
	 * getDDWList Method is Used to Populate the Data 
	 * for DDW Details DAO 
	 * @param vo
	 */
	public void getDDWList(QcStatusforDDWVO QcStatusforDDWRp_p)
	{
		QcStatusforDDWDAO.getDDWList(QcStatusforDDWRp_p);
		  if (QcStatusforDDWRp_p.getStrMsgType().equals("1")) 
		  {
			  QcStatusforDDWRp_p.setStrMsgString("QcStatusforDDWBO.getDDWList() --> "+ QcStatusforDDWRp_p.getStrMsgString());
		  }
		  
	}

}
