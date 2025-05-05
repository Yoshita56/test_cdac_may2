/**
 * 
 */
package mms.reports.bo;

import mms.reports.dao.ListItemWiseSupplierRptDAO_NEW;
import mms.reports.vo.ListItemWiseSupplierRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptBO.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptBO_NEW {

	/**
	 * To get values of Item Category Name:.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void initialAdd(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.itemCategoryName(vo);
		ListItemWiseSupplierRptDAO_NEW.getSuppliedByList(vo);
		ListItemWiseSupplierRptDAO_NEW.getContractTypeList(vo);
		

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.initialAdd---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}
	public void initialAdd1(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.getSuppliedByList(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.initialAdd---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * To get values of Group Name associate with Item Category:.
	 * 
	 * @param vo
	 *            the vo
	 * @return the group name
	 */
	public void getGroupName(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.groupName(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.getGroupName---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * To get values of SubGroup Name associate with Group Name:.
	 * 
	 * @param vo
	 *            the vo
	 * @return the sub group name
	 */
	public void getSubGroupName(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.subGroupName(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.getSubGroupName---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * To get values of Generic Item Name associate with Store, Item Category,
	 * Group Name, SubGrp:.
	 * 
	 * @param vo
	 *            the vo
	 * @return the drug code
	 */
	public void getDrugCode(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.getDrugCodeCmb(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.getDrugCode---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

	/**
	 * To get values of Generic Item Name associate with Store, Item Category,
	 * Group Name, SubGrp:.
	 * 
	 * @param vo
	 *            the vo
	 * @return the item name
	 */
	public void getItemName(ListItemWiseSupplierRptVO_NEW vo) {
		ListItemWiseSupplierRptDAO_NEW.ItemName(vo);
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("ListItemWiseSupplierRptBO.getGenItemName---->"
					+ vo.getStrMsgString());
			vo.setStrMsgType("1");
		}
	}

}
