package mms.masters.bo;

import mms.masters.dao.StoreMstDAO;
import mms.masters.vo.StoreMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreMstBO.
 */
public class StoreMstBO {
	
	/**
	 * for getting option value of combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void initialAdd(StoreMstVO vo) {
		StoreMstDAO.initAddQuery(vo);
		//StoreMstDAO.getMappedHospitalCmb(vo);
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.initialAdd() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to insert the data and check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public void insertRecord(StoreMstVO vo) {

		StoreMstDAO.chkDuplicate(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.insertRecord() --> "
					+ vo.getStrMsgString());
		}
		if (vo.getBExistStatus() == true) {
			StoreMstDAO.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("StoreMstBO.insertRecord() --> "
						+ vo.getStrMsgString());
			}
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void modifyRecord(StoreMstVO vo) {

		StoreMstDAO.modifyQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.modifyRecord() --> "
					+ vo.getStrMsgString());
		}
	}

	/**
	 * to check duplicate before update and update the record.
	 * 
	 * @param vo the vo
	 */
	public void updateRecord(StoreMstVO vo) 
	{
        boolean  retVal = false;  
        boolean  retVal1 = false; 
		StoreMstDAO.initialUpdateQuery(vo);
		if (vo.getStrMsgType().equals("1")) 
		{
			vo.setStrMsgString("StoreMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}
		StoreMstDAO.updateDeptList(vo);
		if (vo.getBExistStatus() == true)
		{
			retVal  =  StoreMstDAO.updateEmpList(vo); 
			
			
            if(retVal)
            {
			 StoreMstDAO.updateQuery(vo);
            }
            else
            {
            	vo.setStrMsgType("1");
            	vo.setStrMsgString("StoreMstBO.updateRecord() -->Associated Employee Not Updated Successfully");
            }
		}
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.updateRecord() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of block combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getBlockCombo(StoreMstVO vo) {

		StoreMstDAO.getBlockQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getBlockCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of floor combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getFloorCombo(StoreMstVO vo) {

		StoreMstDAO.getFloorQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getFloorCombo() --> "
					+ vo.getStrMsgString());
		}

	}

	/**
	 * To get option value of ward combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getWardCombo(StoreMstVO vo) {

		StoreMstDAO.getWardQuery(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getWardCombo() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	/**
	 * To get option value of ward combo on add page.
	 * 
	 * @param vo the vo
	 * 
	 * @throws Exception 	 */
	public void getDistrictDWHCmb(StoreMstVO vo) {

		StoreMstDAO.getDistrictDWHCmb(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("StoreMstBO.getDistructDWHCmb() --> "
					+ vo.getStrMsgString());
		}

	}


}
