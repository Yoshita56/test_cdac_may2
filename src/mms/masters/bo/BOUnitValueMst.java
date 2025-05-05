package mms.masters.bo;

import mms.masters.dao.DAOUnitValueMst;
import mms.masters.vo.VOUnitValueMst;
import hisglobal.exceptions.HisException;

public class BOUnitValueMst {

	// This Method //
	public void modifyRecord(String chk1, VOUnitValueMst vo) throws Exception {

		try {

			DAOUnitValueMst.modifyQuery(chk1, vo);
		} catch (Exception e) {
			throw new Exception("BOUnitValueMst.modifyRecord() -->"
					+ e.getMessage());
		}

	}

	// This Method //
	public String updateRecord(String chk1, VOUnitValueMst vo) {
		String target = "";
		String strmsgText = null;
		boolean retvalue;

		try {
			////  System.out.println("bo update calling");

			retvalue = DAOUnitValueMst.updateQuery(chk1, vo);
			if (!retvalue) {
				String strErrorMsg = "Record not modified successfully!";
				vo.setStrErrorMsg(strErrorMsg);
				target = "modify";
			} else {

				target = "list";

			}

		} catch (Exception e) {

			strmsgText = "mms.masters.BOUnitValueMst.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"UnitValueMaster->updateRecord()", strmsgText);
			vo.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}

		return target;

	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////

	public String InsertRecord(VOUnitValueMst vo) {
		String target = "add";
		boolean retvalue = true;
		String strErrorMsg = "";
		String strmsgText = "";
		String strMsg = "";
		// String strWarning = "";

		try {

			retvalue = this.initialAdd(vo); // check for duplicate record
			if (!retvalue) {
				strErrorMsg = "Record already exist!";
				vo.setStrWarning(strErrorMsg);
				target = "add";
			} else

			{
				retvalue = DAOUnitValueMst.insertQuery(vo);
				if (!retvalue) {
					strErrorMsg = "Record not saved successfully!";
					vo.setStrErrorMsg(strErrorMsg);
					target = "add";
				} else {
					strMsg = "Record Saved Successfully!";
					vo.setStrMsg(strMsg);
					target = "add";
				}
			}
		} catch (Exception e) {
			retvalue = false;
			strmsgText = "mms.masters.BOUnitValueMst.InsertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"UnitValueMaster->InsertRecord()", strmsgText);
			vo.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}
		return target;
	}

	public boolean initialAdd(VOUnitValueMst vo) // check for duplicate
													// record
	{
		boolean retvalue = true;
		String strmsgText = null;
		try {
			retvalue = DAOUnitValueMst.initialAddQuery(vo);

		} catch (Exception e) {
			strmsgText = "mms.masters.BOUnitValueMst.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"UnitValueMaster->initialAdd()", strmsgText);
			vo.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		}
		return retvalue;

	}
	
	/*public void modName(VOUnitValueMst vo) throws Exception
	// for getting option value of combo on add page
	{
		// WebRowSet wb=null;
		String modName = "";

		try {

			modName = DAOUnitValueMst.modNameQuery(vo);

			
			 * HisUtil hisutil = new HisUtil("store","BOStoreGroupMst"); String
			 * cmb = hisutil.getOptionValue(wb, "0^Select Value" ,"Select Value"
			 * ,true );
			 

			vo.setStrModuleName(modName);

		} catch (Exception e) {
			throw new Exception("BOUnitMst.modName() -->" + e.getMessage());
		}

	}*/

}
