/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.SamplesSummaryListRptDAO;
import mms.reports.vo.SamplesSummaryListRptVO;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptBO {
	
	/**
	 * This method is used to populate the value of category name combo box 
	 * 
	 * @param vo
	 */
	
	public void getCategoryValues(SamplesSummaryListRptVO vo) {

		SamplesSummaryListRptDAO.getCategoryValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SamplesSummaryListRptBO.getCategoryValues() --> "
							+ vo.getStrMsgString());
		}
	}
	
	/**
	 * This method is used to populate the value of Supplier Name combo box 
	 * 
	 * @param vo
	 */
	
	public void getSupplierNameValues(SamplesSummaryListRptVO vo) {

		SamplesSummaryListRptDAO.getSupplierNameValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SamplesSummaryListRptBO.getSupplierNameValues() --> "
							+ vo.getStrMsgString());
		}
		SamplesSummaryListRptDAO.getTenderNoValues(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo
					.setStrMsgString("SamplesSummaryListRptBO.getSupplierNameValues() --> "
							+ vo.getStrMsgString());
		}
	} 

}
