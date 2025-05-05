package mms;

// TODO: Auto-generated Javadoc
/**
 * The Class BOMms.
 */
public class BOMms {

	/**
	 * Gets the store group list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the store group list
	 */
	public void getStoreGroupList(VOMms vo) {

		DAOMms.getStoreGroupList(vo);

		if (vo.getStrMsgType().equals("1")) {

			String strErr = vo.getStrMsgString();

			vo.setStrMsgString("BOMms.getStoreGroupList()-->" + strErr);

		}

	}

}
