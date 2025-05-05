/**********************************************************
 Project:	   DWH_BIHAR	
 File:         FileUploadTransBO.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.bo;

import mms.transactions.dao.FileUploadTransDAO;
import mms.transactions.vo.FileUploadTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class FileUploadTransBO.
 */
public class FileUploadTransBO {

	/**
	 * GetData Method is Used to Populate the Data for.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void GetData(FileUploadTransVO vo) {
		FileUploadTransDAO.financialYearCombo(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.GetData() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * Gets the existing req dtl.
	 * 
	 * @param vo
	 *            the vo
	 * @return the existing req dtl
	 */
	public void getExistingReqDtl(FileUploadTransVO vo) {
		FileUploadTransDAO.getNotificationDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.getExistingReqDtl() --> "
					+ vo.getStrMsgString());
		}
	}
	
	/**
	 * Gets the drug classification value.
	 * 
	 * @param vo the vo
	 */
	public void getDrugClassificationValue(FileUploadTransVO vo) {
		FileUploadTransDAO.getDrugClassificationValue(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.getDrugClassificationValue---->" + vo.getStrMsgString());
		}
	}

	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getDrugList(FileUploadTransVO voObj) {

		FileUploadTransDAO.getDrugList(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("FileUploadTransBO.getDrugList()-->" + strErr);
		}
	}
	
	/**
	 * Gets the drug list.
	 * 
	 * @param voObj the vo obj
	 */
	public void getProgList(FileUploadTransVO voObj) {

		FileUploadTransDAO.getProgrammeDetails(voObj);
		
		if (voObj.getStrMsgType().equals("1")) {

			String strErr = voObj.getStrMsgString();

			voObj.setStrMsgString("FileUploadTransBO.getDrugList()-->" + strErr);
		}
	}

	public void getDemandType(FileUploadTransVO vo) {
		FileUploadTransDAO.getNotificationDtl(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.getExistingReqDtl() --> "
					+ vo.getStrMsgString());
		}
	}

	public void save(FileUploadTransVO vo) {

		FileUploadTransDAO.save(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.save() --> "+ vo.getStrMsgString());
		}
		
	}

	public void saveDelete(FileUploadTransVO vo) {
		FileUploadTransDAO.saveDelete(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.saveDelete() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void saveExtend(FileUploadTransVO vo) {
		FileUploadTransDAO.saveExtend(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.saveExtend() --> "+ vo.getStrMsgString());
		}
		
	}
	
	public void getNames(FileUploadTransVO vo,String ids) {
		FileUploadTransDAO.getNames(vo,ids);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.getNames() --> "
					+ vo.getStrMsgString());
		}
	}
	
	public void saveBudgetIntoDB(FileUploadTransVO vo) {
		FileUploadTransDAO.saveBudgetIntoDB(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("FileUploadTransBO.getNames() --> "
					+ vo.getStrMsgString());
		}
	}
	 public void getBudgetDetails(FileUploadTransVO vo)
	  {
		 FileUploadTransDAO.getBudgetDetails(vo);
	    if (vo.getStrMsgType().equals("1"))
	    {
	      vo.setStrMsgString("FileUploadTransBO.getBudgetDetails() --> " + vo.getStrMsgString());
	    }
	  }
}