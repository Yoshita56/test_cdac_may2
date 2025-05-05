package mms;

import hisglobal.transactionmgnt.HisDAO;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOMms.
 */
public class DAOMms {

	/**
	 * Gets the store group list.
	 * 
	 * @param vo the vo
	 * 
	 * @return the store group list
	 */
	public static void getStoreGroupList(VOMms vo) {

		String err = "";
		String proc_name1 = "{call pkg_mms_view.proc_store_group_list(?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

		try {

			dao = new HisDAO("mms", "global.MmsDAO.getItemParameters(MmsVO vo)");

			procIndex1 = dao.setProcedure(proc_name1);

			// set value
			dao.setProcInValue(procIndex1, "store_type_id", vo
					.getStrStoreTypeId());

			dao
					.setProcInValue(procIndex1, "hosp_code", vo
							.getStrHospitalCode());

			dao.setProcOutValue(procIndex1, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex1);

			// get value
			err = dao.getString(procIndex1, "ERR");

			if (err == null)
				err = "";

			ws = dao.getWebRowSet(procIndex1, "RESULTSET");

			vo.setGroupWs(ws);

		} catch (Exception e) {

			vo.setStrMsgString("DAOMms.getStoreGroupList() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			if (dao != null) {
				dao.free();
				dao = null;
			}

		}

	}
}
