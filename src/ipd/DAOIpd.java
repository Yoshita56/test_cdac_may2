package ipd;

import java.util.ArrayList;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;


public class DAOIpd 
{

	private String strQry = "";
	private String strModuleName = "";
	private String strFileName = "";
	private int nQryIndex = 0;

	// error message
	private String strErrMsg = "";

	// constructor
	public DAOIpd(String moduleName, String fileName) 
	{
		this.strModuleName = moduleName;
		this.strFileName = fileName;
	}

	/*
	 * This function is used for Country details. It has the following
	 * parameters chargeType --> Charge Type Id [OPD/IPD etc]. If user does not
	 * want to check it then pass -1 Columns in query >> SBLNUM_BSERVICE_ID,
	 * NVL(SBLSTR_FILENAME,''), SBLSTR_BSERVICE_NAME
	 */
	public WebRowSet getCountryDtl(boolean orderBy) throws Exception 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";
		this.strErrMsg = "";
		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.country.0");
		// CHECK ORDER BY
		if (orderBy) 
		{
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.country.cond.0");
			this.strQry += " ORDER BY " + tempStr;
		}

		try 
		{
			if (!this.strQry.equals("")) 
			{
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} 
			else 
			{
				this.strErrMsg = "DAOIpd.getCountryDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} 
		catch (Exception e) 
		{
			this.strErrMsg = "DAOIpd.getCountryDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	public WebRowSet getStateDtl(int cond, String val, boolean orderBy) throws Exception 
	{

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.state.0");

		// Check Condition
		if (cond == 1) 
		{
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.state.cond.0").replace("?", val);
			this.strQry += " WHERE " + tempStr;
		}

		// CHECK ORDER BY
		if (orderBy) 
		{
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.state.cond.1");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) 
			{
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getStateDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getStateDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
	 * This function is used for Ward details. Columns in query >>
	 * A.HANUM_WARD_CODE, INITCAP(A.HASTR_WARD_NAME)
	 */
	public WebRowSet getWardDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.ward.0");

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.ward.cond.0");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				// fire the query
				ws = daoObj.getQryResult(this.strQry);
			} else {
				this.strErrMsg = "DAOIpd.getWardDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getWardDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*
	 * This function is used for Department details. It has the following
	 * parameters deptType --> either pass the following value or pass "" for
	 * all departments e.g. Clinical, Non-Clinical, Administartive etc Columns
	 * in query >> A.GNUM_DEPT_CODE||'^'||A.GNUM_DEPT_SLNO,
	 * NVL(GSTR_DEPT_SHORT,''), INITCAP(A.GSTR_DEPT_NAME)
	 */
	public WebRowSet getDepartmentDtl(String deptType, boolean orderBy,String hospCode)
			throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.0");
		if (!deptType.equals("")) {
			// Department Type condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.cond.0");
			this.strQry += " WHERE " + tempStr;
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.cond.1");
			this.strQry += " AND " + tempStr;
		} else {
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.cond.1");
			this.strQry += " WHERE " + tempStr;
		}
		if (!hospCode.equals("")) {
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.cond.3");
		this.strQry += " AND " + tempStr;
		}
		
		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.dept.cond.2");
			this.strQry += " ORDER BY " + tempStr;
		}
		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				if (!deptType.equals(""))
					daoObj.setQryValue(nQryIndex, 1, deptType);
				if (!hospCode.equals("")) 
					daoObj.setQryValue(nQryIndex, 2, hospCode);
				
				// fire the query
				ws = daoObj.executeQry(nQryIndex);

			} else {
				this.strErrMsg = "DAOIpd.getDepartmentDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getDepartmentDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/**
	 * returns the Unit Details for Ipd Master.
	 * 
	 * @param deptType -
	 *            department Code will return the Unit Values Related to Give
	 *            Department. <br> "" returns all the Units
	 * @param notExists -
	 *            true returns Unit Values which not existed in the
	 *            HIPT_DEPTUNITWARD_MST Table. <br>
	 *            False returns Unit Values including Existing Values.
	 * @param orderBy -
	 *            true returns the Unit in Ascending Order based on Name. <br>
	 *            false returns in Normal Format.
	 * @return - Unit Values (HGSTR_UNITNAME) from the Table HGBT_UNIT_MST
	 * @throws Exception
	 */
	public WebRowSet getIpdUnitDtl(String[] deptType, boolean notExists,
			boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.0");

		if (!deptType.equals("")) {
			// Department Type condition

			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.cond.0");
			this.strQry += " WHERE " + tempStr;
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.cond.1");
			this.strQry += " AND " + tempStr;

		} else {
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.cond.1");
			this.strQry += " WHERE " + tempStr;
		}

		if (notExists) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.cond.2");
			this.strQry += " AND " + tempStr;
		}

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.unitMst.cond.3");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				if (!deptType[0].equals(""))
					for (int i = 0; i < deptType.length; i++) {
						daoObj.setQryValue(nQryIndex, i + 1, deptType[i]);
					}
				// fire the query

				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getIpdUnitDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getIpdUnitDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/**
	 * returns the Unit Details for Ipd Master.
	 * 
	 * @param deptType -
	 *            department Code will return the Unit Values Related to Give
	 *            Department. <br> "" returns all the Units
	 * @param notExists -
	 *            true returns Unit Values which not existed in the
	 *            HIPT_DEPTUNITWARDDISEASE_MST Table. <br>
	 *            False returns Unit Values including Existing Values.
	 * @param orderBy -
	 *            true returns the Unit in Ascending Order based on Name. <br>
	 *            false returns in Normal Format.
	 * @return - Unit Values (HGSTR_UNITNAME) from the Table HGBT_UNIT_MST
	 * @throws Exception
	 */
	public WebRowSet getIpdWardDeptDiseaseUnitDtl(String[] deptType,
			boolean notExists, boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd
				.getQuery(1, "gbl.deptWardDisunitMst.0");

		if (!deptType.equals("")) {
			// Department Type condition

			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.deptWardDisunitMst.cond.0");
			this.strQry += " WHERE " + tempStr;
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.deptWardDisunitMst.cond.1");
			this.strQry += " AND " + tempStr;

		} else {
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.deptWardDisunitMst.cond.1");
			this.strQry += " WHERE " + tempStr;
		}

		if (notExists) {
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.deptWardDisunitMst.cond.2");
			this.strQry += " AND " + tempStr;
		}

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.deptWardDisunitMst.cond.3");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				if (!deptType[0].equals(""))
					for (int i = 0; i < deptType.length; i++) {
						daoObj.setQryValue(nQryIndex, i + 1, deptType[i]);
					}

				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getIpdWardDeptDiseaseUnitDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getIpdWardDeptDiseaseUnitDtl() -->"
					+ e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/**
	 * returns Hospital Disease Details of Ipd Master
	 * 
	 * @param notAll
	 *            true - returns Only the Primary Key and Name of the Disease.
	 *            <br>
	 *            false - returns All the Fields Concatenated with
	 * @param type
	 *            ""- returns all the Disease Values. <br>
	 *            type - returns the Diseases of particular Type based on the
	 *            value passed.
	 * @param orderBy
	 *            true- returns Value in Order By form. <br>
	 *            false - returns Value in the normal Order.
	 * @return
	 * @throws Exception -
	 *             Exception if any condition fails
	 */
	public WebRowSet getIpdHospitalDiseaseDtl(boolean notAll, String type,
			boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		if (notAll) {
			this.strQry = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.0");
		} else {
			this.strQry = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.1");
		}

		if (!type.equals("")) {
			// Department Type condition

			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.cond.1");
			this.strQry += " WHERE " + tempStr;
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.cond.0");
			this.strQry += " AND " + tempStr;

		} else {
			// compulsory condition
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.cond.0");
			this.strQry += " WHERE " + tempStr;
		}

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1,
					"gbl.hospitalDiseaseMst.cond.2");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				if (!type.equals(""))

					daoObj.setQryValue(nQryIndex, 1, type);

				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getIpdHospitalDiseaseDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getIpdHospitalDiseaseDtl() -->"
					+ e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/**
	 * returns the Global Disease Details from the Table
	 * 'GBLT_DISEASE_MST'.
	 * 
	 * @param indexes - ""
	 *            represents no condition. <br>
	 *            "0" represents 'GSTR_PARENT_DISEASE_CODE IS NULL' <br>
	 *            "1" represents 'GSTR_PARENT_DISEASE_CODE = ?' <br>
	 *            "2" represents GNUM_DISEASE_TYPE = ? and <br>
	 *            "3" represents ' GNUM_ISVALID = ?'. <br>
	 *            combination of conditions can be given by appending the
	 *            respective numbers for eg. "0^1" represents combination of
	 *            condition 0 and 1.
	 * @param values -
	 *            for the conditions 1,2 and 3. parameters can be passed.<br>
	 *            If no Parameter is there then pass 'null'<br>
	 *            For more than one condition values can be passed as follow
	 *            "12^3492^1" etc.
	 * @param orderBy -
	 *            true- returns Value in Order By form of 'GSTR_DISEASE_DESC'.
	 *            <br>
	 *            false - returns Value in the normal Order.
	 * @return
	 * @throws Exception
	 */
	public WebRowSet getGblDiseaseDtl(String indexes, String values,
			boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		String indexArr[] = indexes.replace("^", "#").split("#");
		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.0");

		if (!indexArr[0].equals("")) {

			for (int ni = 0; ni < indexArr.length; ni++) {
				tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.cond."
						+ indexArr[ni]);
				if (ni == 0) {
					this.strQry += " WHERE " + tempStr;
				} else {
					this.strQry += " AND " + tempStr;
				}
			}
		}

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.cond.4");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			daoObj = new HisDAO(this.strModuleName, "DAOIpd."
					+ this.strFileName);
			nQryIndex = daoObj.setQuery(this.strQry);

			if (!this.strQry.equals("")) {

				if (values != null) {
					String valArr[] = values.replace("^", "#").split("#");
					for (int ni = 0; ni < valArr.length; ni++) {
						daoObj.setQryValue(nQryIndex, ni + 1, valArr[ni]);

					}
				}
				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getGblDiseaseDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getGblDiseaseDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}
/*
	public WebRowSet getEmployeeDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.employeeMst.0");

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.employeeMst.cond.0");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			daoObj = new HisDAO(this.strModuleName, "DAOIpd."
					+ this.strFileName);
			nQryIndex = daoObj.setQuery(this.strQry);

			if (this.strQry.equals("")) {

				this.strErrMsg = "DAOIpd.getEmployeeDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
			// fire the query
			ws = daoObj.executeQry(nQryIndex);

		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getEmployeeDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}
*/
	public WebRowSet getPatCategoryDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.cat.0");

		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.cat.cond.0");

		this.strQry += " WHERE " + tempStr;

		//tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.cat.cond.1");

		//this.strQry += " AND " + tempStr;
		//this.strQry += " AND ";

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.cat.cond.2");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			daoObj = new HisDAO(this.strModuleName, "DAOIpd."
					+ this.strFileName);
			nQryIndex = daoObj.setQuery(this.strQry);

			if (this.strQry.equals("")) {

				this.strErrMsg = "DAOIpd.getPatCategoryDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
			// fire the query
			ws = daoObj.executeQry(nQryIndex);

		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getPatCategoryDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	// Bala Files End

	// Monika Mam's Files

	/*
	 * Function Details 1. getBuildingDtl() 2. getBlockDtl() 3. getRoomDtl()
	 */

	/*
	 * Common Parameter option --> true/false. If user wants option string then
	 * true. if user wants webrowset (all the column defined in query will
	 * populate) then false selValue,defOption --> Described in HisUtil Class
	 * concatForm --> true/false. If user wants to concate all the columns given
	 * in the query then pass true. If user wants only ID,Name then pass false.
	 * This parameter will apply only in option string. orderBy --> true/false.
	 * If user wants sorting then pass true else false
	 */

	// Note --> The method will be kept into corrosponding DAO. This File having
	// only those
	// methods for which there is no DAO available. Function only returns
	// WebRowSet. If user
	// wants combo then he must have called GetOptionValue function
	/*
	 * This function is used for Ipd Service details.
	 * 
	 */
	public WebRowSet getBuildingDtl(boolean orderBy, String strHcode)
			throws Exception {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.building.0");
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.building.cond.2")
				.replace("?", "" + strHcode + ""); // CHANGED ON 19-MAY-08 for
		// hospital_code condition
		this.strQry += " WHERE " + tempStr+" AND GNUM_ISVALID=1";

		//tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.building.cond.0");
		//this.strQry += " AND " + tempStr;
		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.building.cond.1");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getBuildingDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getBuildingDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
	 * /* this function gives detail of blocks based on buildings public
	 * WebRowSet getBlockDtl(int buildingId, boolean orderBy,String strHcode)
	 * throws Exception { System.out.println("getBlockDtl ===");
	 * System.out.println("getBlockDtl-->strHcode ==="+strHcode);
	 * 
	 * //System.out.print("inside block id" + buildingId); HisDAO daoObj = null;
	 * WebRowSet ws = null; String tempStr = "";
	 * 
	 * this.strErrMsg = "";
	 * 
	 * this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.block.0"); tempStr =
	 * ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.3").replace("?",
	 * ""+strHcode+"");//hospital code condition
	 * 
	 * System.out.println("tempStr1=="+tempStr);
	 * 
	 * this.strQry += " WHERE " + tempStr; if (buildingId != -1) { // Building
	 * id condition tempStr = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.block.cond.0").replace("?", ""+buildingId+""); this.strQry += " AND " +
	 * tempStr; } tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.1");
	 * this.strQry += " AND " + tempStr; // CHECK ORDER BY if (orderBy) {
	 * tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.2"); this.strQry += "
	 * ORDER BY " + tempStr; }
	 * 
	 * try { if (!this.strQry.equals("")) { daoObj = new
	 * HisDAO(this.strModuleName, "ipd_qry_mst.properties." + this.strFileName);
	 * nQryIndex = daoObj.setQuery(this.strQry); if (buildingId != -1) daoObj
	 * .setQryValue(nQryIndex, 1, String .valueOf(buildingId)); // fire the
	 * query //System.out.print("query" + this.strQry);
	 * 
	 * System.out.println("block query in modification =="+this.strQry); ws =
	 * daoObj.executeQry(nQryIndex); } else { this.strErrMsg =
	 * "DAOIpd.getBlockDtl() -->Query is blank"; throw new
	 * Exception(this.strErrMsg); } } catch (Exception e) { this.strErrMsg =
	 * "DAOIpd.getBlockDtl() -->" + e.getMessage(); throw new
	 * Exception(this.strErrMsg); } finally { if (daoObj != null) {
	 * daoObj.free(); daoObj = null; } }
	 * 
	 * return ws; }
	 */

	public WebRowSet getBlockDtl(int buildingId, boolean orderBy,
			String strHcode) throws Exception {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.block.0");
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.3").replace(
				"?", "" + strHcode + "");// hospital code condition

		this.strQry += " WHERE " + tempStr;
		if (buildingId != -1) {
			// Building id condition
			// tempStr = ipd.qryHandler_ipd.getQuery(1,
			// "gbl.block.cond.0").replace("?", ""+buildingId+"");

			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.0");
			this.strQry += " AND " + tempStr;

		}
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.1");
		this.strQry += " AND " + tempStr;
		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.block.cond.2");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);
				if (buildingId != -1)
					daoObj
							.setQryValue(nQryIndex, 1, String
									.valueOf(buildingId));
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getBlockDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getBlockDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
	 * this function will give room detail concatenated with floor.rooms are
	 * dependent on building and block
	 */
	public WebRowSet getRoomDtl(String mode, int buildingId, int blockid,
			int floor, boolean orderBy, boolean appendFloor, String hcode)
			throws Exception {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";
		this.strErrMsg = "";

		if (appendFloor) {
			this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.room.0");
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.7")
					.replace("?", "" + hcode + "");

			this.strQry += " WHERE " + tempStr;
		} else {
			this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.room.1");
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.7")
					.replace("?", hcode);
			this.strQry += " WHERE " + tempStr;
		}

		if (floor != -1) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.6");
			this.strQry += " AND " + tempStr;
		}

		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.2");// sl_no max
		// condition
		this.strQry += " AND " + tempStr;

		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.3");
		this.strQry += " AND " + tempStr;
		if (buildingId != 0 && blockid != 0) {
			this.strQry = this.strQry + " and NUM_BUILDING_CODE = "
					+ buildingId + " and NUM_BLOCK_ID = " + blockid;
		}
		if (mode.equals("ADD")) {
			strQry += " "
					+ ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.notin");
		} else {
			strQry += " "
					+ ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.notin.2")
							.replace("?", mode);
		}

		if (orderBy) {
			if (appendFloor)
				tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.4");
			else
				tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.room.cond.5");

			this.strQry += " ORDER BY " + tempStr;
		}
		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);

				if (floor != -1) {
					this.strQry = this.strQry.replace("?", floor + "");
				}
				nQryIndex = daoObj.setQuery(this.strQry);
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getRoomDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getRoomDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
	 * this function will give room detail concatenated with floor.rooms are
	 * dependent on building and block public WebRowSet getRoomDtl(int
	 * buildingId,int blockid ,int floor,boolean orderBy,boolean
	 * appendFloor,String hcode) throws Exception { //System.out.print("inside
	 * getRoomDtl"+buildingId); //System.out.print("inside getRoomDtl"+blockid);
	 * HisDAO daoObj = null; WebRowSet ws = null; String tempStr = "";
	 * this.strErrMsg = "";
	 * 
	 * if(appendFloor){ this.strQry =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.0"); tempStr =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.7").replace("?",
	 * ""+hcode+"");
	 * 
	 * this.strQry += " WHERE " + tempStr; } else{
	 * 
	 * System.out.println("else fllor cond");
	 * 
	 * this.strQry = ipd.qryHandler_ipd.getQuery(1,"gbl.room.1"); tempStr =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.7").replace("?", "108");
	 * this.strQry += " WHERE " + tempStr; }
	 * 
	 * if(floor!= -1) { System.out.println("ALL THREE CONDITION "); // building
	 * id condition tempStr =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.0").replace("?",
	 * ""+buildingId+""); this.strQry += " AND " + tempStr; //block condition
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.1").replace("?",
	 * ""+blockid+""); this.strQry += " AND " + tempStr;
	 * 
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.6").replace("?",
	 * ""+floor+""); this.strQry += " AND " + tempStr; }
	 * 
	 * 
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.2");//sl_no max
	 * condition this.strQry += " AND " + tempStr;
	 * 
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.3"); this.strQry += "
	 * AND " + tempStr;
	 * 
	 * //CHECK ORDER BY--to be if(orderBy) { if(appendFloor) tempStr =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.4"); else tempStr =
	 * ipd.qryHandler_ipd.getQuery(1,"gbl.room.cond.5"); this.strQry += " ORDER
	 * BY " + tempStr; } //System.out.print("inside daoipd ROOM
	 * QUERY------->"+this.strQry); System.out.println("this.strQry-room modi
	 * query=="+this.strQry);
	 * 
	 * 
	 * try { if(!this.strQry.equals("")) { daoObj = new
	 * HisDAO(this.strModuleName,"ipd_qry_mst.properties." + this.strFileName);
	 * nQryIndex = daoObj.setQuery(this.strQry); if(blockid != -1) {
	 * daoObj.setQryValue(nQryIndex,1,String.valueOf(buildingId));
	 * daoObj.setQryValue(nQryIndex,2,String.valueOf(blockid)); }
	 * 
	 * 
	 * 
	 * 
	 * ws = daoObj.executeQry(nQryIndex); } else { this.strErrMsg =
	 * "DAOIpd.getRoomDtl() -->Query is blank"; throw new
	 * Exception(this.strErrMsg); } } catch(Exception e) { this.strErrMsg =
	 * "DAOIpd.getRoomDtl() -->" + e.getMessage(); throw new
	 * Exception(this.strErrMsg); } finally { if(daoObj != null) {
	 * daoObj.free(); daoObj = null; } }
	 * 
	 * return ws; }
	 * 
	 * 
	 */

	// this function will give gender details
	public WebRowSet getGenderDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.gender.0");
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.gender.cond.0");
		this.strQry += " WHERE " + tempStr;
		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.gender.cond.1");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);

				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getGenderDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getGenderDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	// Monika Mam Files End
	/*-----------------------------------------------------------------------------------*/
	/*
	 * This function will give Floor detail from EST_FLOOR_MST Table are
	 * dependent on BuildingID and BlockID
	 */
	/*-------------------------Written By Amit Kumar------------------------------------*/
	/*
	 * public WebRowSet getFloorDtl2(int buildingId, int blockId, boolean
	 * orderBy,String strHcode) throws Exception {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null; String tempStr = "";
	 * this.strErrMsg = ""; this.strQry = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.1"); //gbl.floor2.cond.4
	 * 
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.cond.4").replace("?", ""+strHcode+"");//hospital_code
	 * this.strQry += " WHERE " + tempStr;
	 * 
	 * if (buildingId != -1 && blockId != -1) { // building id condition tempStr =
	 * ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.0").replace("?",
	 * ""+buildingId+""); this.strQry += " AND " + tempStr; // block condition
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.cond.1").replace("?", ""+blockId+""); this.strQry += " AND " +
	 * tempStr; } tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.2");
	 * this.strQry += " AND " + tempStr; // CHECK ORDER BY--to be if (orderBy) {
	 * tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.3");
	 * this.strQry += " ORDER BY " + tempStr; } //System.out.print("inside
	 * getFloorDtl Query------->" + this.strQry); try { if
	 * (!this.strQry.equals("")) { daoObj = new HisDAO(this.strModuleName,
	 * "ipd_qry_mst.properties." + this.strFileName); nQryIndex =
	 * daoObj.setQuery(this.strQry); if (buildingId != -1 && blockId != -1) {
	 * daoObj .setQryValue(nQryIndex, 1, String .valueOf(buildingId));
	 * daoObj.setQryValue(nQryIndex, 2, String.valueOf(blockId)); } // fire the
	 * query System.out.print("room query(DAOIpd) =>" + strQry); ws =
	 * daoObj.executeQry(nQryIndex); } else { this.strErrMsg =
	 * "DAOIpd.getFloorDtl() -->Query is blank"; throw new
	 * Exception(this.strErrMsg); } } catch (Exception e) { this.strErrMsg =
	 * "DAOIpd.getFloorDtl() -->" + e.getMessage(); throw new
	 * Exception(this.strErrMsg); } finally { if (daoObj != null) {
	 * daoObj.free(); daoObj = null; } }
	 * 
	 * return ws; }// public WebRowSet getFloorDtl2(int buildingId, int blockId,
	 * boolean orderBy,String strHcode) throws Exception {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null; String tempStr = "";
	 * this.strErrMsg = ""; this.strQry = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.1"); //gbl.floor2.cond.4
	 * 
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.cond.4").replace("?", ""+strHcode+"");//hospital_code
	 * this.strQry += " WHERE " + tempStr;
	 * 
	 * if (buildingId != -1 && blockId != -1) { // building id condition tempStr =
	 * ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.0").replace("?",
	 * ""+buildingId+""); this.strQry += " AND " + tempStr; // block condition
	 * tempStr = ipd.qryHandler_ipd.getQuery(1,
	 * "gbl.floor2.cond.1").replace("?", ""+blockId+""); this.strQry += " AND " +
	 * tempStr; } tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.2");
	 * this.strQry += " AND " + tempStr; // CHECK ORDER BY--to be if (orderBy) {
	 * tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.3");
	 * this.strQry += " ORDER BY " + tempStr; } //System.out.print("inside
	 * getFloorDtl Query------->" + this.strQry); try { if
	 * (!this.strQry.equals("")) { daoObj = new HisDAO(this.strModuleName,
	 * "ipd_qry_mst.properties." + this.strFileName); nQryIndex =
	 * daoObj.setQuery(this.strQry); if (buildingId != -1 && blockId != -1) {
	 * daoObj .setQryValue(nQryIndex, 1, String .valueOf(buildingId));
	 * daoObj.setQryValue(nQryIndex, 2, String.valueOf(blockId)); } // fire the
	 * query System.out.print("floor query(DAOIpd) =>" + strQry); ws =
	 * daoObj.executeQry(nQryIndex); } else { this.strErrMsg =
	 * "DAOIpd.getFloorDtl() -->Query is blank"; throw new
	 * Exception(this.strErrMsg); } } catch (Exception e) { this.strErrMsg =
	 * "DAOIpd.getFloorDtl() -->" + e.getMessage(); throw new
	 * Exception(this.strErrMsg); } finally { if (daoObj != null) {
	 * daoObj.free(); daoObj = null; } }
	 * 
	 * return ws; }
	 */

	public WebRowSet getFloorDtl2(int buildingId, int blockId, boolean orderBy,
			String strHcode) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";
		this.strErrMsg = "";
		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.1");
		// gbl.floor2.cond.4

		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.4").replace(
				"?", "" + strHcode + "");// hospital_code
		this.strQry += " WHERE " + tempStr;

		if (blockId != -1) {
			// block condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.1");
			this.strQry += " AND " + tempStr;
		}
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.2");
		this.strQry += " AND " + tempStr;

		// CHECK ORDER BY--to be
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.floor2.cond.3");
			this.strQry += " ORDER BY " + tempStr;
		}
		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);
				if (buildingId != -1 && blockId != -1) {
					// daoObj
					// .setQryValue(nQryIndex, 1, String
					// .valueOf(buildingId));
					daoObj.setQryValue(nQryIndex, 1, String.valueOf(blockId));
				}
				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getFloorDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getFloorDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*-----------------------------------------------------------------------------------*/
	/*
	 * This function will give Room detail from EST_ROOM_MST Table are dependent
	 * on BuildingID and BlockID
	 */
	/*-------------------------Written By Amit Kumar------------------------------------*/
	public WebRowSet getRoomNo(int buildingId, int blockId, boolean orderBy)
			throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";
		this.strErrMsg = "";
		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.roomNo.1");
		if (buildingId != -1 && blockId != -1) {
			// building id condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.roomNo.cond.0");
			this.strQry += " WHERE " + tempStr;
			// block condition
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.roomNo.cond.1");
			this.strQry += " AND " + tempStr;
		}
		tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.roomNo.cond.2");
		this.strQry += " AND " + tempStr;

		// CHECK ORDER BY--to be
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.roomNo.cond.3");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName,
						"ipd_qry_mst.properties." + this.strFileName);
				nQryIndex = daoObj.setQuery(this.strQry);
				if (buildingId != -1 && blockId != -1) {
					daoObj
							.setQryValue(nQryIndex, 1, String
									.valueOf(buildingId));
					daoObj.setQryValue(nQryIndex, 2, String.valueOf(blockId));
				}
				// fire the query
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getFloorDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getFloorDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*------------------------------------------------------------------------------------*/
	public WebRowSet getBedDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.bedDtl.0");

		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.bedDtl.0");
			this.strQry += " ORDER BY " + tempStr;
		}

		try {
			if (!this.strQry.equals("")) {
				daoObj = new HisDAO(this.strModuleName, "DAOIpd."
						+ this.strFileName);
				// fire the query
				ws = daoObj.getQryResult(this.strQry);
			} else {
				this.strErrMsg = "DAOIpd.getWardDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getWardDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*------------------------------------------------------------------------------------*/

	/*
	 * Methods to execute Global Procedures Starts -- by Balasubramaniam.
	 */

	/**
	 * sets Relation List in IpdVO objects relationWs attribute.
	 * 
	 * @param voObj -
	 *            IpdVO Value Object
	 */
	public static void setRelationList(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_ipd_view.proc_gblt_relation_list(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("Ipd Module", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),1);
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,3);

			daoObj.executeProcedureByPosition(nProcIndex);

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				voObj.setGblWs2(ws);

			} else {

				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOIpd.getRelationList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * sets Designation List in IpdVO objects designationWs attribute.
	 * 
	 * @param voObj -
	 *            IpdVO Value Object
	 */
	public static void setDesignationList(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_simple_view.proc_gblt_DESIGNATION_list(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("Ipd Module", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospCode(),1);
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,3);

			daoObj.executeProcedureByPosition(nProcIndex);

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				voObj.setGblWs3(ws);

			} else {

				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOIpd.getDesignationList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * sets State List in IpdVO objects stateWs attribute.
	 * 
	 * @param voObj -
	 *            IpdVO Value Object
	 */
	public static void setStateList(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_simple_view.proc_gblt_STATE_list(?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("Ipd Module", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hospCode", IpdConfigUtil.SUPER_HOSPITAL_CODE.toString(),1);
			daoObj.setProcOutValue(nProcIndex, "err", 1,2);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,3);

			daoObj.executeProcedureByPosition(nProcIndex);

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				voObj.setGblWs4(ws);

			} else {

				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAOIpd.getStateList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * sets Organization List in IpdVO objects orgTypeWs attribute.
	 * 
	 * @param voObj -
	 *            IpdVO Value Object
	 */
	public static void setOrganizationTypeList(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_ipd_view.proc_gblt_org_type_list(?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			daoObj = new HisDAO("Ipd Module", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcOutValue(nProcIndex, "err", 1,1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,2);

			daoObj.executeProcedureByPosition(nProcIndex);

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				voObj.setGblWs5(ws);

			} else {

				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOIpd.getOrganisationTypeList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}
	//Data Saved Successfully
	/**
	 * sets Occupation Details in IpdVO objects occupationWs attribute.
	 * 
	 * @param voObj -
	 *            IpdVO Value Object
	 */
	public static void setOccupationDtls(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_ipd_view.proc_occupation_dtls(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strCrNo = voObj.getStrValue1();
		String strCatCode = voObj.getStrValue2();
		String strConfCatCode = voObj.getStrValue3();

		String strErr = "";

		System.out.println(strCatCode+" "+strConfCatCode);
		try {
			daoObj = new HisDAO("Ipd Module", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNo != null && strCatCode != null && strConfCatCode != null) {
				daoObj.setProcInValue(nProcIndex, "mode_type", "V",1);
				daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),2);
				daoObj.setProcInValue(nProcIndex, "PUKNO", strCrNo,3);
				if(strCatCode.equals(""))
					daoObj.setProcInValue(nProcIndex, "CATCODE", "0",4);
				else	
				    daoObj.setProcInValue(nProcIndex, "CATCODE", strCatCode,4);
				daoObj.setProcInValue(nProcIndex, "CONFCATCODE",strConfCatCode,5);
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr == null)
					strErr = "";

				if (strErr.equals("")) {

					voObj.setGblWs1(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			 e.printStackTrace();
			voObj.setStrMsgString("DAOIpd.getOrganisationTypeList() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void setPatientDtl(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ot_view.proc_pat_demo_address_dtl(?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		String strCrNum = voObj.getStrValue1();

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			if (strCrNum != null && !strCrNum.equals("")) {
				daoObj.setProcInValue(nProcIndex, "puk", strCrNum,1);
				daoObj.setProcInValue(nProcIndex, "addresstype", "1",2);

				daoObj.setProcOutValue(nProcIndex, "err", 1,3);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				//System.out.println("WS_SIZE----"+ws.size());

				if (strErr.equals("")) {

					voObj.setGblWs1(ws);

				} else {
					throw new Exception(strErr);
				}
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOIpd.setPatientDtl() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	/**
	 * returns the Global Disease Details from the Table
	 * 'GBLT_DISEASE_MST'.
	 * 
	 * @param indexes - ""
	 *            represents no condition. <br>
	 *            "0" represents 'GSTR_PARENT_DISEASE_CODE IS NULL' <br>
	 *            "1" represents 'GSTR_PARENT_DISEASE_CODE = ?' <br>
	 *            "2" represents GNUM_DISEASE_TYPE = ? and <br>
	 *            "3" represents ' GNUM_ISVALID = ?'. <br>
	 *            combination of conditions can be given by appending the
	 *            respective numbers for eg. "0^1" represents combination of
	 *            condition 0 and 1.
	 * @param values -
	 *            for the conditions 1,2 and 3. parameters can be passed.<br>
	 *            If no Parameter is there then pass 'null'<br>
	 *            For more than one condition values can be passed as follow
	 *            "12^3492^1" etc.
	 * @param orderBy -
	 *            true- returns Value in Order By form of 'GSTR_DISEASE_DESC'.
	 *            <br>
	 *            false - returns Value in the normal Order.
	 * @return
	 * @throws Exception
	 */
	public WebRowSet getGblDiseaseDtl(String indexes, String values,
			String hsptlCde, boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.strErrMsg = "";

		String indexArr[] = indexes.replace("^", "#").split("#");
		this.strQry = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.0");

		/*
		 * tempStr = ipd.qryHandler_ipd.getQuery(1,
		 * "gbl.diseaseMst.cond.1").replace("?", ""+this.getGblDiseaseDtl("1",
		 * "2", "108", true)+""); { this.strQry += " WHERE " + tempStr; }
		 * tempStr = ipd.qryHandler_ipd.getQuery(1,
		 * "gbl.diseaseMst.cond.5").replace("?", ""+Hsptlcde+""); { this.strQry += "
		 * AND " + tempStr; }
		 */

		if (!indexArr[0].equals("")) {

			for (int ni = 0; ni < indexArr.length; ni++) {
				tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.cond."
						+ indexArr[ni]);
				if (ni == 0) {
					this.strQry += " AND " + tempStr;
				} else {
					this.strQry += " AND " + tempStr;
				}

			}
		}
		// CHECK ORDER BY
		if (orderBy) {
			tempStr = ipd.qryHandler_ipd.getQuery(1, "gbl.diseaseMst.cond.4");
			{
				this.strQry += " ORDER BY " + tempStr;
			}
		}

		try {
			daoObj = new HisDAO(this.strModuleName, "DAOIpd."
					+ this.strFileName);
			nQryIndex = daoObj.setQuery(this.strQry);

			if (!this.strQry.equals("")) {

				// HOSPITAL CODE
				daoObj.setQryValue(nQryIndex, 1, hsptlCde);

				if (values != null) {
					String valArr[] = values.replace("^", "#").split("#");
					for (int ni = 0; ni < valArr.length; ni++) {
						// System.out.println("valArr[ni] = " + valArr[ni]);
						daoObj.setQryValue(nQryIndex, ni + 2, valArr[ni]);

					}
				}
				ws = daoObj.executeQry(nQryIndex);
			} else {
				this.strErrMsg = "DAOIpd.getGblDiseaseDtl() -->Query is blank";
				throw new Exception(this.strErrMsg);
			}
		} catch (Exception e) {
			this.strErrMsg = "DAOIpd.getGblDiseaseDtl() -->" + e.getMessage();
			throw new Exception(this.strErrMsg);
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
	 * Methods to execute Global Procedures Ends -- by Balasubramaniam.
	 */
	/** ***TLD By Deepak************** */

	public static void setAdmissionDtl(IpdVO voObj) {

		String strProcName = "{call pkg_ipd_view.proc_visitadmission_advice_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strCrNo = voObj.getStrValue1();
		String strAdmNo = voObj.getStrValue2();

		try {
			daoObj = new HisDAO("setAdmissionDtl", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);

			if (strAdmNo != null && !strAdmNo.equals("")
					&& !strAdmNo.equals("0") && !strAdmNo.equals("null")) {
				daoObj.setProcInValue(nProcIndex, "modval", "2",1);
				daoObj.setProcInValue(nProcIndex, "puk", "",2);
				daoObj.setProcInValue(nProcIndex, "admNo", strAdmNo,3);
			} else {
				daoObj.setProcInValue(nProcIndex, "modval", "1",1);
				daoObj.setProcInValue(nProcIndex, "puk", strCrNo,2);
				daoObj.setProcInValue(nProcIndex, "admNo", "",3);
			}

			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospCode(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {
				voObj.setGblWs1(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj.setStrMsgString("DAOIpd.setAdmissionDtl() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {

			if (daoObj != null) {

				daoObj.free();

				daoObj = null;

			}

		}

	}

	/** ******search field functions******* */
	/**
	 * called from JSP page to find the group
	 * 
	 * @return arraylist containing 'group id' and 'group name'
	 */
	public WebRowSet getRows() {
		String qry = "select GROUP_ID, GROUP_NAME from test_group";
		WebRowSet wb = null;
		HisDAO obj = null;
		try {
			obj = new HisDAO("Ipd", "DAOIpd");
			int index1 = obj.setQuery(qry);
			wb = obj.executeQry(index1);
		} catch (Exception e) {
			new HisException("ipd", "DAOIpd.getRows()", e.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return wb;
	}

	public ArrayList<String> getComboList(String grp_ID) {
		String comboQry = "select TARIFF_ID, TARIFF_NAME from test_tariff where GROUP_ID = ?";
		ArrayList<String> Al_List = new ArrayList<String>();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Ipd", "DAOIpd");
			int index1 = obj.setQuery(comboQry);
			obj.setQryValue(index1, 1, grp_ID);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("ipd", "DAOIpd.getComboList()", e.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}

	public ArrayList<String> groupComboData() {
		String comboQry = "select GROUP_ID, GROUP_NAME from test_group ";
		ArrayList<String> Al_List = new ArrayList<String>();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Ipd", "DAOIpd");
			int index1 = obj.setQuery(comboQry);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("ipd", "DAOIpd.groupComboData()", e.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}

	public ArrayList<String> tariffComboData(String grp_ID) {
		String comboQry = "select TARIFF_ID, TARIFF_NAME from test_tariff where GROUP_ID = ?";
		ArrayList<String> Al_List = new ArrayList<String>();
		HisDAO obj = null;
		try {
			obj = new HisDAO("Ipd", "DAOIpd");
			int index1 = obj.setQuery(comboQry);
			obj.setQryValue(index1, 1, grp_ID);
			Al_List = obj.executeQry(index1, 2);
		} catch (Exception e) {
			new HisException("ipd", "DAOIpd.groupComboData()", e.getMessage());
		} finally {
			obj.free();
			obj = null;
		}
		return Al_List;
	}

	// //////////////////////Ipd Header Method////////////////////////////////
	public String PaymentType(IpdVO voHdrObj) {
		HisDAO daoObj = null;
		String payType = null;
		WebRowSet web5 = null;
		String str = voHdrObj.getStrValue1();
		String strTemp[] = str.replace('@', '#').split("#");
		int i = Integer.parseInt(strTemp[0]); // Customer ID
		// ///////////////////////////////////////////////////
		int nqryIndex5;

		String strQuery5 = new String();
		try {
			daoObj = new HisDAO("Client Verification Transaction",
					"ClientVerificationDAO");

			strQuery5 = "SELECT HBLNUM_PAYMENT_TYPE FROM HBLT_CLIENT_MST WHERE HBLNUM_CLIENT_NO = "
					+ i + "  AND GNUM_ISVALID = 1";

			nqryIndex5 = daoObj.setQuery(strQuery5);

			web5 = daoObj.executeQry(nqryIndex5);
			while (web5.next()) {
				payType = web5.getString(1);
			}

		} catch (Exception e) {
			// System.out.println("Inside biiHeaderDAO"+e.getMessage());
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return payType;
	}

	public static void getClientDtlProc(IpdVO voHdrObj) {
		String str = voHdrObj.getStrValue1();
		// HisUtil hisutil = new HisUtil("transaction",
		// "ClientVerificTransDAO");
		String strTemp[] = str.replace('@', '#').split("#");

		String proc_name = "";

		proc_name = "{call ClientDetail(?,?,?)}";

		HisDAO dao = null;

		int procIndex = 0;

		String err = "";

		WebRowSet ws = null;

		try {

			dao = new HisDAO("ipd", "transactions.DAOIpd.getClientDtlProc()");

			procIndex = dao.setProcedure(proc_name);

			// set value

			dao.setProcInValue(procIndex, "CLIENTNO", strTemp[0]);

			dao.setProcOutValue(procIndex, "ERR", 1); // 1 for string return
			// value

			dao.setProcOutValue(procIndex, "RESULTSET", 2); // 2 for object

			// execute procedure

			dao.executeProcedure(procIndex);

			// get value

			err = dao.getString(procIndex, "ERR");

			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex, "RESULTSET");
				voHdrObj.setGblWs1(ws);

			}

		} catch (Exception e) {
			voHdrObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voHdrObj.setStrMsgType("1");

		}

		finally {

			if (dao != null) {

				dao.free();

				dao = null;

			}

		}
	}

	/*
	 * public static void setPatientDtl(IpdVO voObj) {
	 * 
	 * HisDAO daoObj = null; WebRowSet ws = null;
	 * 
	 * String strProcName = "{call
	 * pkg_ipd_view.proc_pat_demo_address_dtl(?,?,?)}"; int nProcIndex = 0;
	 * String strErr = "";
	 * 
	 * String strCrNum = voObj.getStrValue1();
	 * 
	 * try { daoObj = new HisDAO("Patient Details Ws","DAOIpd"); nProcIndex =
	 * daoObj.setProcedure(strProcName);
	 * 
	 * if (strCrNum != null && !strCrNum.equals("")) {
	 * 
	 * daoObj.setProcInValue(nProcIndex, "puk", strCrNum);
	 * 
	 * daoObj.setProcOutValue(nProcIndex, "err", 1);
	 * daoObj.setProcOutValue(nProcIndex, "resultset", 2);
	 * 
	 * daoObj.executeProcedure(nProcIndex);
	 * 
	 * strErr = daoObj.getString(nProcIndex, "err");
	 * 
	 * if (strErr == null) strErr = "";
	 * 
	 * ws = daoObj.getWebRowSet(nProcIndex,"resultset"); System.out.println("Ist
	 * is-->"+ws.size());
	 * 
	 * if (strErr.equals("")) {
	 * 
	 * voObj.setGblWs1(ws); } else { throw new Exception(strErr); } } } catch
	 * (Exception e) {
	 * 
	 * voObj.setStrMsgString("DAOIpd.setPatientDtl() --> " + e.getMessage());
	 * voObj.setStrMsgType("1"); } finally { if (daoObj != null) {
	 * daoObj.free(); daoObj = null; } } }
	 */

	// //////////////////////////////////////////////////////////////////////////////
	public static void getOnLineReqDiscount(IpdVO voObj) {
		String str = voObj.getStrValue1();
		String str1 = voObj.getStrValue2();
		String proc_name1 = "";
		proc_name1 = "{call PROC_ONLINE_REQUEST(?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("ipd",
					"transactions.DAOIpd.getOnLineReqDiscount(IpdVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "Mode_Type", str1);
			dao.setProcInValue(procIndex1, "CRNO", str);
			dao.setProcOutValue(procIndex1, "ERRMSG", 1); // 1 for string
			// return value
			dao.setProcOutValue(procIndex1, "RESULTSET", 2); // 2 for object
			// execute procedure
			dao.executeProcedure(procIndex1);
			// get value
			err = dao.getString(procIndex1, "ERRMSG");
			if (err == null)
				err = "";
			{
				ws = dao.getWebRowSet(procIndex1, "RESULTSET");
				voObj.setGblWs2(ws);
			}
		} catch (Exception e) {
			voObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////

	public static void setTariffChargeDtl(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "";
		int nProcIndex = 0;
		String strErr = "";

		String chargeTypeId = voObj.getStrValue1();
		String categoryCode = voObj.getStrValue2();
		String wardCode = voObj.getStrValue3();
		String groupId = voObj.getStrValue4();
		String searchText = voObj.getStrValue5();
		String hospitalCode = voObj.getStrValue6();
		String pkgFlag = voObj.getStrValue7();

		if (searchText == null)
			searchText = "";

		if (groupId.equals(""))
			groupId = null;
		if (wardCode.equals(""))
			wardCode = null;

		if (pkgFlag == null || pkgFlag.equals(""))
			pkgFlag = "0";

		String mode = "2";

		if (chargeTypeId != null && categoryCode != null) {
			if ((wardCode == null || wardCode.equals(""))
					&& (groupId == null || groupId.equals(""))) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?)}";
			} else if (wardCode != null && groupId == null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?)}";
			} else if (wardCode == null && groupId != null) {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?)}";
			} else {
				strProcName = "{call PKG_BILL_VIEW.PROC_HBLT_CHARGE_MST(?,?,?,?,?,?,?,?,?,?)}";
			}
		}
		try {
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
			if (chargeTypeId != null && categoryCode != null) {

				daoObj.setProcInValue(nProcIndex, "chargeTypeId", chargeTypeId);
				daoObj.setProcInValue(nProcIndex, "catCode", categoryCode);
				daoObj.setProcInValue(nProcIndex, "searchTrfName", searchText);
				daoObj.setProcInValue(nProcIndex, "hosp_code", hospitalCode);
				daoObj.setProcInValue(nProcIndex, "pkg_flag", pkgFlag);
				if (wardCode != null) {
					daoObj.setProcInValue(nProcIndex, "wardCode", wardCode);
				}
				if (groupId != null) {
					daoObj.setProcInValue(nProcIndex, "groupId", groupId);
				}
				daoObj.setProcInValue(nProcIndex, "modeVal", mode);
				daoObj.setProcOutValue(nProcIndex, "err", 1);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2);
				daoObj.executeProcedure(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					voObj.setGblWs1(ws);
				} else {
					throw new Exception(strErr);
				}
			} else {
				voObj.setGblWs1(null);
			}

		} catch (Exception e) {

			voObj.setStrMsgString("DAOIpd.setTariffChargeDtl() --> "
					+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void setPatientListingDtl_from_Leave(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strPatListType = voObj.getStrValue1();
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8();

		String strModeType = "2";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.Proc_HIPT_PAT_LEAVE_DTL(?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeVal", strModeType,1);
			daoObj.setProcInValue(nProcIndex, "puk", "",2);
			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType,3);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,4);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,5);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,6);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,7);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,8);
			daoObj.setProcOutValue(nProcIndex, "err", 1,9);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,10);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		if (strErr.equals("")) {

				voObj.setGblWs1(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAOIpd.setPatientListingDtl_from_Leave() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void setPatientListingDtl_from_Advice(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strPatListType = "1";
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8();
		String strAdmissionValidFrom = voObj.getStrValue9();
		String strAdmissionValidTo = voObj.getStrValue10();

		String strModeType = "2";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.proc_admission_advice_dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", strModeType,1);
			daoObj.setProcInValue(nProcIndex, "pukno", "",2);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,3);
			daoObj.setProcInValue(nProcIndex, "adv_frm_validity",strAdmissionValidFrom,4);
			daoObj.setProcInValue(nProcIndex, "adv_to_validity",strAdmissionValidTo,5);
			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType,6);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,7);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,8);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,9);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,10);
			daoObj.setProcOutValue(nProcIndex, "err", 1,11);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,12);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				voObj.setGblWs1(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			voObj
					.setStrMsgString("DAOIpd.setPatientListingDtl_from_Advice() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void setPatientListingDtl_from_PatAdmission_MMS(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8();		

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.Proc_Hipt_Patadmission_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		
		try 
		{
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "4",1);			
			daoObj.setProcInValue(nProcIndex, "puk", "",2);
			daoObj.setProcInValue(nProcIndex, "seatid", "",3);
			daoObj.setProcInValue(nProcIndex, "modifytime", "0",4);			
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,5);
			daoObj.setProcInValue(nProcIndex, "patListType", "3",6);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,7);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,8);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,9);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,10);
			daoObj.setProcInValue(nProcIndex, "onlinedis", "0",11);			
			daoObj.setProcInValue(nProcIndex, "deptUnitCode", voObj.getStrDeptUnitCode(),12);
			daoObj.setProcInValue(nProcIndex, "wardCode", voObj.getStrWardCode(),13);
			daoObj.setProcOutValue(nProcIndex, "err", 1,14);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.setPatientListingDtl_from_PatAdmission() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void setPatientListingDtl_from_PatAdmission(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String strPatListType = "2";
		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8();

		String strModeType = "4";
		IpdConfigUtil config = new IpdConfigUtil(voObj.getHospitalCode());

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.Proc_Hipt_Patadmission_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		
		try {
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", strModeType,1);
			
			daoObj.setProcInValue(nProcIndex, "puk", "",2);
			daoObj.setProcInValue(nProcIndex, "seatid", "",3);
			daoObj.setProcInValue(nProcIndex, "modifytime", "0",4);
			
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,5);
			daoObj.setProcInValue(nProcIndex, "patListType", strPatListType,6);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,7);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,8);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,9);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,10);

			if (config.getStrDischargeProcessType().equals("1")) {
				daoObj.setProcInValue(nProcIndex, "onlinedis", "1",11);
			}
			else
				daoObj.setProcInValue(nProcIndex, "onlinedis", "2",11);
			
			
			daoObj.setProcInValue(nProcIndex, "deptUnitCode", voObj.getStrDeptUnitCode(),12);
			daoObj.setProcInValue(nProcIndex, "wardCode", voObj.getStrWardCode(),13);

			daoObj.setProcOutValue(nProcIndex, "err", 1,14);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGblWs1(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAOIpd.setPatientListingDtl_from_PatAdmission() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// ////////////////////////////////Admission cancellation & Admission Modification//////////////////////////////////////////////
	public static void setPatientListingDtl_for_AdmissionCancel(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";

		String strSearchString 	= voObj.getStrValue2();
		String strSearchType 	= voObj.getStrValue3();
		String strFromRows 		= voObj.getStrValue4();
		String strToRows 		= voObj.getStrValue5();
		String strHospitalCode 	= voObj.getStrValue8();

		
		IpdConfigUtil config = new IpdConfigUtil(voObj.getHospitalCode());

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.Proc_Hipt_Patadmission_Dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", "8",1);
			daoObj.setProcInValue(nProcIndex, "puk", "",2);
			daoObj.setProcInValue(nProcIndex, "seatid", "",3);
			daoObj.setProcInValue(nProcIndex, "modifyTime", config.getStrModificationTimeValidity(),4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,5);
			daoObj.setProcInValue(nProcIndex, "patListType", "",6);
			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString,7);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType,8);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows,9);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows,10);
			daoObj.setProcInValue(nProcIndex, "onlinedis", "",11);
			daoObj.setProcInValue(nProcIndex, "deptUnitCode", "0",12);
			daoObj.setProcInValue(nProcIndex, "wardCode", "0",13);
			daoObj.setProcOutValue(nProcIndex, "err", 1,14);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,15);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.setPatientListingDtl_for_AdmissionCancel() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// /////////////////////////////////////////////////////////////////////////////

	public static void setMotherPatientListingDtl_from_PatAdmission(IpdVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strErr = "";

		String strSearchString = voObj.getStrValue2();
		String strSearchType = voObj.getStrValue3();
		String strFromRows = voObj.getStrValue4();
		String strToRows = voObj.getStrValue5();
		String strHospitalCode = voObj.getStrValue8();

		String strModeType = "6";

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		String strProcName = "{call Pkg_Ipd_View.Proc_Hipt_Patadmission_Dtl(?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		try {
			daoObj = new HisDAO("Mother Patient Details Ws", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modeVal", strModeType);

			daoObj.setProcInValue(nProcIndex, "searchStr", strSearchString);
			daoObj.setProcInValue(nProcIndex, "searchType", strSearchType);
			daoObj.setProcInValue(nProcIndex, "frmRows", strFromRows);
			daoObj.setProcInValue(nProcIndex, "toRows", strToRows);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);

			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) {

				voObj.setGblWs1(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("DAOIpd.setMotherPatientListingDtl_from_PatAdmission() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

	}

	// ///////////////////////////////////////////////////////////////////////////
	public static void getOnLineReqDiscount(IpdVO voHdrObj, String mode) {
		String str = voHdrObj.getStrValue1();
		String str2 = mode;
		String proc_name1 = "";
		proc_name1 = "{call pkg_bill_view.PROC_SBLT_INBOUND_DTL(?,?,?,?)}";
		HisDAO dao = null;
		int procIndex1 = 0;
		String err = "";
		WebRowSet ws = null;
		try {
			dao = new HisDAO("ipd",
					"transactions.DAOIpd.getOnLineReqDiscount(IpdVO voHdrObj)");
			procIndex1 = dao.setProcedure(proc_name1);
			// set value
			dao.setProcInValue(procIndex1, "Mode_Type", str2);
			dao.setProcInValue(procIndex1, "CRNO", str);
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
			voHdrObj.setGblWs2(ws);
		} catch (Exception e) {
			voHdrObj.setStrMsgString("BillHeaderDAO.getClientDtlProc() --> "
					+ e.getMessage());
			voHdrObj.setStrMsgType("1");
		}
		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	// ////////////////////////////////////////////////////////////////

	/** *****bed status popUp dao********* */
	/**
	 * This function is used to bring the bed details on bed details pop up
	 * window on the basis of ward code,room number,bed type code
	 * 
	 * @param voObj
	 */
	public static void getBedValues(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_ipd_view.proc_bed_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("ipd Transactions", "IpdDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "4",1);
			daoObj.setProcInValue(nProcIndex, "wardcode", voObj.getStrWardCode(),2);
			daoObj.setProcInValue(nProcIndex, "roomno", voObj.getStrRoomCode(),3);
			daoObj.setProcInValue(nProcIndex, "bedtypcode", voObj.getStrBedTypeCode(),4);
			daoObj.setProcInValue(nProcIndex, "bedstatcode", "",5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),6);
			daoObj.setProcInValue(nProcIndex, "deptunit", voObj.getStrDeptUnitCode(),7);
			daoObj.setProcInValue(nProcIndex, "bedcode", "",8);
			daoObj.setProcInValue(nProcIndex, "shr_chk", "",9);
			daoObj.setProcOutValue(nProcIndex, "err", 1,10);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,11);
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				voObj.setBedDetailWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj
					.setStrMsgString("DAOIpd.getBedValues() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/** *****bed status popUp dao********* */
	/**
	 * This function is used to bring the bed details for patient Admission on bed details pop up
	 * window on the basis of ward code,room number,bed type code
	 * 
	 * @param voObj
	 */
	public static void beddetailPatAdmission(IpdVO voObj) {
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_ipd_view.proc_bed_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("ipd Transactions", "IpdDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "10",1);
			daoObj.setProcInValue(nProcIndex, "wardcode", voObj
					.getStrWardCode(),2);
			daoObj.setProcInValue(nProcIndex, "roomno", voObj.getStrRoomCode(),3);
			daoObj.setProcInValue(nProcIndex, "bedtypcode", voObj
					.getStrBedTypeCode(),4);
			daoObj.setProcInValue(nProcIndex, "bedstatcode", "",5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj
					.getStrHospCode(),6);
			daoObj.setProcInValue(nProcIndex, "deptunit", voObj
					.getStrDeptUnitCode(),7);
			daoObj.setProcInValue(nProcIndex, "bedcode", "",8);
			daoObj.setProcInValue(nProcIndex, "shr_chk", "",9);
			daoObj.setProcOutValue(nProcIndex, "err", 1,10);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,11);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				voObj.setBedDetailWS(ws);
			} else {
				throw new Exception(strErr);
			}
		} catch (Exception e) {
			voObj
					.setStrMsgString("DAOIpd.getBedValues() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void countBed_in_ward(IpdVO vo) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.proc_bed_dtl(?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			// System.out.println("Hello"+IpdTransConfig.getBedStatusVacantCode());
			daoObj = new HisDAO("ipd Transactions", "IpdDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "2",1);
			daoObj.setProcInValue(nProcIndex, "wardcode", vo.getStrWardCode(),2);
			daoObj.setProcInValue(nProcIndex, "roomno", vo.getStrRoomCode(),3);
			daoObj.setProcInValue(nProcIndex, "bedtypcode", vo.getStrBedTypeCode(),4);
			daoObj.setProcInValue(nProcIndex, "bedstatcode", IpdTransConfig.getBedStatusVacantCode(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospCode(),6);
			daoObj.setProcInValue(nProcIndex, "deptunit", vo.getStrDeptUnitCode(),7);
			daoObj.setProcInValue(nProcIndex, "bedcode", "",8);
			daoObj.setProcInValue(nProcIndex, "shr_chk", "",9);
			daoObj.setProcOutValue(nProcIndex, "err", 1,10);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,11);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				if (ws.next()) {
					vo.setStrVacantBed(ws.getString(1));
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("DAOIpd.getBedValues().countBed_in_ward() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	//
	public static void countBed_in_wardPatAdmission(IpdVO vo) {
		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.proc_bed_dtl(?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;

		String strErr = "";

		try {
			// System.out.println("Hello"+IpdTransConfig.getBedStatusVacantCode());
			daoObj = new HisDAO("ipd Transactions", "IpdDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modval", "11",1);
			daoObj.setProcInValue(nProcIndex, "wardcode", vo.getStrWardCode(),2);
			daoObj.setProcInValue(nProcIndex, "roomno", vo.getStrRoomCode(),3);
			daoObj.setProcInValue(nProcIndex, "bedtypcode", vo
					.getStrBedTypeCode(),4);
			daoObj.setProcInValue(nProcIndex, "bedstatcode", IpdTransConfig
					.getBedStatusVacantCode(),5);
			daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getStrHospCode(),6);
			daoObj.setProcInValue(nProcIndex, "deptunit", vo
					.getStrDeptUnitCode(),7);
			daoObj.setProcInValue(nProcIndex, "bedcode", "",8);
			daoObj.setProcInValue(nProcIndex, "shr_chk", "",9);
			daoObj.setProcOutValue(nProcIndex, "err", 1,10);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,11);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {
				if (ws.next()) {
					vo.setStrVacantBed(ws.getString(1));
				}

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			vo.setStrMsgString("DAOIpd.getBedValues().countBed_in_ward() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

	/** ***ends***** */
	
	public static void getBedPropertiesValues(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call PKG_IPD_VIEW.PROC_HIPT_BED_PROPERTIES(?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("ADT", "IpdDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "mode_val", "1",1);
			daoObj.setProcInValue(nProcIndex, "ward_code", voObj.getStrWardCode(),2);
			daoObj.setProcInValue(nProcIndex, "room_code", voObj.getStrRoomCode(),3);
			daoObj.setProcInValue(nProcIndex, "bed_code", "",4);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),5);
			daoObj.setProcOutValue(nProcIndex, "err", 1,6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setBedPropertiesWS(ws);
			}
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			// e.printStackTrace();
			voObj.setStrMsgString("DAOIpd.getBedPropertiesValues() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void wardStatistics(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		String strFuncName = "{? = call IPD_MST.getWardStatistics(?,?,?,?,?,?)}";
		int nfuncIndex = 0;
		String wardStatistics="";
		try 
		{
			daoObj = new HisDAO("ADT", "IpdDAO");
			nfuncIndex = daoObj.setFunction(strFuncName);
			daoObj.setFuncInValue(nfuncIndex, 2, "1");
			daoObj.setFuncInValue(nfuncIndex, 3, voObj.getStrDeptCode());
			daoObj.setFuncInValue(nfuncIndex, 4, voObj.getStrDeptUnitCode());
			daoObj.setFuncInValue(nfuncIndex, 5, voObj.getStrWardCode());
			daoObj.setFuncInValue(nfuncIndex, 6, voObj.getStrRoomCode());
			daoObj.setFuncInValue(nfuncIndex, 7, voObj.getStrHospCode());
			daoObj.setFuncOutValue(nfuncIndex, 1);

			daoObj.executeFunction(nfuncIndex);

			wardStatistics = daoObj.getFuncString(nfuncIndex);
			voObj.setWardStatistics(wardStatistics);
		} 
		catch (Exception e) 
		{
			// e.printStackTrace();
			voObj.setStrMsgString("DAOIpd.wardStatistics() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static WebRowSet getPrivateWardType(String strHospCode)
			throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call pkg_ipd_view.PROC_HIPT_WARDTYPE_MST(?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		// WebRowSet web=null;

		try {
			daoObj = new HisDAO("Admission Advice Trans",
					"AdmissionAdviceTransDAO");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", strHospCode,2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) {

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	
	public static void setAdmissionDtlSlip(IpdVO voObj) {

		String strProcName = "{call pkg_ipd_view.proc_visitadmission_advice_dtl(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strCrNo = voObj.getStrValue1();
		String strAdmNo = voObj.getStrValue2();

		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			nProcIndex = daoObj.setProcedure(strProcName);


			daoObj.setProcInValue(nProcIndex, "modval", "3",1);
			daoObj.setProcInValue(nProcIndex, "puk", strCrNo,2);
			daoObj.setProcInValue(nProcIndex, "admno", strAdmNo,3);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("DAOIpd.setAdmissionDtlSlip() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getWardValues(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{ call pkg_ipd_view.proc_HIPT_WARD_MST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			daoObj = new HisDAO("ipd Transactions", "DAoIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
						
			daoObj.setProcInValue(nProcIndex, "modeVal", "18", 1);
			daoObj.setProcInValue(nProcIndex, "wardtypcode", "0", 2);
			daoObj.setProcInValue(nProcIndex, "deptcode","0", 3);
			daoObj.setProcInValue(nProcIndex, "deptunitcode","0", 4);
			daoObj.setProcInValue(nProcIndex, "unitcode", "0", 5);
			daoObj.setProcInValue(nProcIndex, "age", "0", 6);
			daoObj.setProcInValue(nProcIndex, "gender", "0", 7);
			daoObj.setProcInValue(nProcIndex, "treatment_cat", "0",8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(), 9);
			//daoObj.setProcInValue(nProcIndex, "hosp_code","21101", 9);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 10);
			daoObj.setProcInValue(nProcIndex, "effect_to", "", 11);
			daoObj.setProcInValue(nProcIndex, "diseasetypcode","0", 12);
			daoObj.setProcInValue(nProcIndex, "wardcode", "", 13);
			daoObj.setProcInValue(nProcIndex, "puk_no", "", 14);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", "", 15);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 16);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 17);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setBedstatusDashWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.getWardValues() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getRoomValues(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{ call pkg_ipd_view.proc_HIPT_WARD_MST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			daoObj = new HisDAO("ipd Transactions", "DAoIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
						
			daoObj.setProcInValue(nProcIndex, "modeVal", "20", 1);
			daoObj.setProcInValue(nProcIndex, "wardtypcode", "0", 2);
			daoObj.setProcInValue(nProcIndex, "deptcode","0", 3);
			daoObj.setProcInValue(nProcIndex, "deptunitcode","0", 4);
			daoObj.setProcInValue(nProcIndex, "unitcode", "0", 5);
			daoObj.setProcInValue(nProcIndex, "age", "0", 6);
			daoObj.setProcInValue(nProcIndex, "gender", "0", 7);
			daoObj.setProcInValue(nProcIndex, "treatment_cat", "0",8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(), 9);
			//daoObj.setProcInValue(nProcIndex, "hosp_code","21101", 9);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 10);
			daoObj.setProcInValue(nProcIndex, "effect_to", "", 11);
			daoObj.setProcInValue(nProcIndex, "diseasetypcode","0", 12);
			daoObj.setProcInValue(nProcIndex, "wardcode", "", 13);
			daoObj.setProcInValue(nProcIndex, "puk_no", "", 14);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", "", 15);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 16);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 17);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setRoomWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.getRoomValues() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getWardBedValues(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{ call pkg_ipd_view.proc_HIPT_WARD_MST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			daoObj = new HisDAO("ipd Transactions", "DAoIpd");
			nProcIndex = daoObj.setProcedure(strProcName);
						
			daoObj.setProcInValue(nProcIndex, "modeVal", "21", 1);
			daoObj.setProcInValue(nProcIndex, "wardtypcode", "0", 2);
			daoObj.setProcInValue(nProcIndex, "deptcode","0", 3);
			daoObj.setProcInValue(nProcIndex, "deptunitcode","0", 4);
			daoObj.setProcInValue(nProcIndex, "unitcode", "0", 5);
			daoObj.setProcInValue(nProcIndex, "age", "0", 6);
			daoObj.setProcInValue(nProcIndex, "gender", "0", 7);
			daoObj.setProcInValue(nProcIndex, "treatment_cat", "0",8);
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospCode(), 9);
			//daoObj.setProcInValue(nProcIndex, "hosp_code","21101", 9);
			daoObj.setProcInValue(nProcIndex, "effect_from", "", 10);
			daoObj.setProcInValue(nProcIndex, "effect_to", "", 11);
			daoObj.setProcInValue(nProcIndex, "diseasetypcode","0", 12);
			daoObj.setProcInValue(nProcIndex, "wardcode", "", 13);
			daoObj.setProcInValue(nProcIndex, "puk_no", "", 14);
			daoObj.setProcInValue(nProcIndex, "charge_type_id", "", 15);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 16);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 17);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
				voObj.setBedValuesDashWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.getWardBedValues() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}

	public static void getBedProperties(IpdVO vo) {
		// TODO Auto-generated method stub
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{ call pkg_ipd_view.proc_bed_properties(?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr = "";
		
		
		try{
			
			
			
			daoObj=new HisDAO("ipd Transactions", "DAoIpd");
			 
			
			nProcIndex = daoObj.setProcedure(strProcName);
			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", "37913", 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 4);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
					if(ws.size()>0)
					vo.setBedPropertiesWS(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		 
		
	}

	public static void getbedPropMapping(IpdVO vo) {
		// TODO Auto-generated method stub
		
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{ call pkg_ipd_view.proc_bed_properties(?,?,?,?)}";	
		
		int nProcIndex = 0;
		String strErr = "";
		
		try
		{		
			daoObj=new HisDAO("ipd Transactions", "DAoIpd");			
			nProcIndex = daoObj.setProcedure(strProcName);			
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", "37913", 2);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 4);		
			
			daoObj.executeProcedureByPosition(nProcIndex);
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			if (strErr.equals("")) 
			{
					vo.setBedPropsMapping(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void setPatientListingDtl_admittedSingleWindow(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String strProcName = "{call Pkg_Ipd_View.single_window_admitted(?,?,?,?)}";
		int nProcIndex = 0;
		
		try 
		{
			daoObj = new HisDAO("Patient Details Ws", "DAOIpd");

			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "modeVal", "1",1);			
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrValue8(),2);
			daoObj.setProcOutValue(nProcIndex, "err", 1,3);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,4);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			ws = daoObj.getWebRowSet(nProcIndex, "resultset");

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("DAOIpd.setPatientListingDtl_admittedSingleWindow() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void jobtracking(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";	
		
		try 
		{
			daoObj = new HisDAO("Enquiry", "DAOIpd");					

			//ws=daoObj.getQryResult_EDB("select jobname,decode(jslstatus,'r','Successful','s','Successful','Failed') status,to_char(jslstart,'DD-Mon-YYYY, HH24:MI:SS') as start_date,to_char(jslstart+jslduration,'DD-Mon-YYYY, HH24:MI:SS') as end_date ,jslduration  duration,jsloutput as error from pgagent.pga_jobstep a ,pgagent.pga_jobsteplog b,pgagent.pga_job  c where a.jstjobid=c.jobid and a.jstid=b.jsljstid AND trunc(jslstart)>=trunc(SYSDATE-30) order by jslstart desc ,1 asc");
			ws=daoObj.getQryResult("SELECT DISTINCT  (JOBNAME) JOBNAME,DECODE(STATUS,'S','Successful','Failed') STATUS,TO_CHAR(STARTDT,'DD-Mon-YYYY, HH24:MI') AS START_DATE,TO_CHAR(ENDDT,'DD-Mon-YYYY, HH24:MI') AS END_DATE,ERROR AS ERROR,TRUNC(STARTDT) FROM GBLT_DBMS_JOBS_TRACKING_DTL C WHERE TRUNC(STARTDT)>=TRUNC(SYSDATE-30) AND GNUM_HOSPITAL_CODE="+IpdConfigUtil.CURRENT_HOSPITAL_CODE+" ORDER BY TRUNC(STARTDT) DESC ,2,1 ASC");
			//executeProcedureByPosition_EDB(nProcIndex);

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.jobtracking() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static String jobdata_populate() 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		
		String jobname, status, startdt, enddt, error;
		int index1,index2;//, index2, index3;
		int jobsruning=0;
		int jobsfailed=0;
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			   
			index2 = daoObj.setQuery("DELETE FROM GBLT_DBMS_JOBS_TRACKING_DTL WHERE TRUNC(STARTDT)=TRUNC(SYSDATE) AND GNUM_HOSPITAL_CODE=? ");
			daoObj.setQryValue(index2, 1,IpdConfigUtil.CURRENT_HOSPITAL_CODE);
			daoObj.execute(index2, 0);
			
			ws=daoObj.getQryResult_EDB("select jobname,decode(jslstatus,'r','S','s','S','F') status,to_char(jslstart,'DD-Mon-YYYY, HH24:MI:SS') as start_date,to_char(jslstart+jslduration,'DD-Mon-YYYY, HH24:MI:SS') as end_date ,jslduration  duration,jsloutput as error from pgagent.pga_jobstep a ,pgagent.pga_jobsteplog b,pgagent.pga_job  c where a.jstjobid=c.jobid and a.jstid=b.jsljstid AND trunc(jslstart)=trunc(SYSDATE) order by jslstart desc ,1 asc");
			
			if (ws != null) 
			{
				if (ws.size() != 0) 
				{
					jobsruning=ws.size();
					index1 = daoObj.setQuery("INSERT INTO GBLT_DBMS_JOBS_TRACKING_DTL(JOBNAME, STATUS, STARTDT, ENDDT, ERROR, ENTRYDT, GNUM_HOSPITAL_CODE, NOTIFY_STATUS) VALUES(?,?,?::timestamp,?::timestamp,?,SYSDATE,"+IpdConfigUtil.CURRENT_HOSPITAL_CODE+",1)");
					
					while(ws.next())
					{
						
						jobname=ws.getString(1);
						status=ws.getString(2);
						startdt=ws.getString(3);
						enddt=ws.getString(4);
						error=ws.getString(6);
						
						daoObj.setQryValue(index1, 1,jobname);
						daoObj.setQryValue(index1, 2, status);
						daoObj.setQryValue(index1, 3, startdt);
						daoObj.setQryValue(index1, 4, enddt);
						daoObj.setQryValue(index1, 5, error);
						
						
						daoObj.execute(index1, 0);
						
						if(status.equals("F"))//Failed
							jobsfailed++;
						
						//daoObj.""+jobname+", "+status+", "+startdt+", "+enddt+", "+error+",sysdate,37913,0)";
					}
				}
				
				synchronized (daoObj) 
				{
					daoObj.fire();
					
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
		return jobsruning+"#"+jobsfailed;
	}
	
	public static void processtracking(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("Enquiry", "DAOIpd");
			

			//ws=daoObj.getQryResult_EDB("select jobname,decode(jslstatus,'r','Successful','s','Successful','Failed') status,to_char(jslstart,'DD-Mon-YYYY, HH24:MI:SS') as start_date,to_char(jslstart+jslduration,'DD-Mon-YYYY, HH24:MI:SS') as end_date ,jslduration  duration,jsloutput as error from pgagent.pga_jobstep a ,pgagent.pga_jobsteplog b,pgagent.pga_job  c where a.jstjobid=c.jobid and a.jstid=b.jsljstid AND trunc(jslstart)>=trunc(SYSDATE-30) order by jslstart desc ,1 asc");
			//ws=daoObj.getQryResult("select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2),decode(trans_type,1,'Loading Time',2,'Submission Time',3,'Save Time',4,'Total Trans Time','Loading Time') as error from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL order by starttime desc,1 asc,2 asc");
			
			/*ws=daoObj.getQryResult("SELECT GSTR_MENU_NAME," + 
					"ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60,0,EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME)),EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60))::NUMERIC,2) AS LOADINGTIME," + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60,0,EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME)),EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE PROCESSID=GNUM_MENU_ID AND ENDTIME IS NOT NULL),0) AS SAVERESPONSETIME," + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE PROCESSID=GNUM_MENU_ID AND ENDTIME IS NOT NULL),0) AS TOTALTRANSTIME" + 
					"FROM  GBLT_MENU_CLICK_LOG D WHERE GDT_ENDTIME IS NOT NULL AND GSTR_MENU_NAME !='Process Log Dashboard' " + 
					"GROUP BY GNUM_MENU_ID,GSTR_MENU_NAME" + 
					"ORDER BY 3 DESC" + 
					"" );*/
			
			/*ws=daoObj.getQryResult("SELECT GSTR_MENU_NAME," + 
					"ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60,0,EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME)),EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60))::NUMERIC,2) AS LOADINGTIME," + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60,0,EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME)),EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE PROCESSNAME=GSTR_MENU_NAME AND ENDTIME IS NOT NULL AND  SAVEENDTIME>SAVESTARTTIME),0) AS SAVERESPONSETIME," + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE PROCESSNAME=GSTR_MENU_NAME AND ENDTIME IS NOT NULL AND  ENDTIME>STARTTIME),0) AS TOTALTRANSTIME" + 
					"FROM  GBLT_MENU_CLICK_LOG D WHERE GDT_ENDTIME IS NOT NULL AND GSTR_MENU_NAME !='Process Log Dashboard' " + 
					"GROUP BY GSTR_MENU_NAME" + 
					"ORDER BY 3 DESC" + 
					"" );*/
			
			String query ="SELECT GSTR_MENU_NAME, " + 
					"ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60,0,EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME)),EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60))::NUMERIC,2) AS LOADINGTIME, " + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60,0,EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME)),EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND PROCESSID=GNUM_MENU_ID AND ENDTIME IS NOT NULL),0) AS SAVERESPONSETIME, " + 
					"NVL((SELECT ROUND(AVG(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60))::NUMERIC,2) " + 
					"FROM GBLT_TRANS_LOG WHERE TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND PROCESSID=GNUM_MENU_ID AND ENDTIME IS NOT NULL),0) AS TOTALTRANSTIME " + 
					"FROM  GBLT_MENU_CLICK_LOG D WHERE  TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GDT_ENDTIME IS NOT NULL AND GSTR_MENU_NAME !='Process Log Dashboard' " + 
					"GROUP BY GNUM_MENU_ID,GSTR_MENU_NAME " + 
					"ORDER BY 3 DESC " + 
					"" ;
			
			//System.out.println(query);
			ws=daoObj.getQryResult(query);

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processtracking() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void processgauge(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";

		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			
			//ws=daoObj.getQryResult_EDB("select jobname,decode(jslstatus,'r','Successful','s','Successful','Failed') status,to_char(jslstart,'DD-Mon-YYYY, HH24:MI:SS') as start_date,to_char(jslstart+jslduration,'DD-Mon-YYYY, HH24:MI:SS') as end_date ,jslduration  duration,jsloutput as error from pgagent.pga_jobstep a ,pgagent.pga_jobsteplog b,pgagent.pga_job  c where a.jstjobid=c.jobid and a.jstid=b.jsljstid AND trunc(jslstart)>=trunc(SYSDATE-30) order by jslstart desc ,1 asc");
			//ws=daoObj.getQryResult("SELECT  PNAME,AVG(PTIME),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(PROCESSID,2,2)) FROM (SELECT PROCESSID,PROCESSNAME AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_TRANS_LOG C WHERE ENDTIME IS NOT NULL  ) GROUP BY PNAME,PROCESSID ORDER BY 3");
			ws=daoObj.getQryResult("SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(PROCESSID,2,2)),1,SUBSTR(PROCESSID,2,2) FROM (SELECT PROCESSID,PROCESSNAME AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_TRANS_LOG C WHERE ENDTIME IS NOT NULL  and SAVEENDTIME>SAVESTARTTIME  AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))) GROUP BY PNAME,PROCESSID "+
			" UNION "+
			" SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(GNUM_MENU_ID,2,2)),2,SUBSTR(GNUM_MENU_ID,2,2) FROM (SELECT gnum_menu_id,gstr_menu_name AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60,0,EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME)),EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_MENU_CLICK_LOG C WHERE GSTR_MENU_NAME !='Process Log Dashboard' AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))) GROUP BY PNAME,gnum_menu_id  "+
			" UNION "+
			" SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(PROCESSID,2,2)),3,SUBSTR(PROCESSID,2,2) FROM (SELECT PROCESSID,PROCESSNAME AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60,0,EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME)),EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_TRANS_LOG C WHERE ENDTIME IS NOT NULL and SAVEENDTIME>SAVESTARTTIME AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) ) GROUP BY PNAME,PROCESSID ORDER BY 3");
			//executeProcedureByPosition_EDB(nProcIndex);
			/*
String temp = "SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(PROCESSID,2,2)),1,SUBSTR(PROCESSID,2,2) FROM (SELECT PROCESSID,PROCESSNAME AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_TRANS_LOG C WHERE ENDTIME IS NOT NULL  AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))) GROUP BY PNAME,PROCESSID "+
" UNION "+
" SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(GNUM_MENU_ID,2,2)),2,SUBSTR(GNUM_MENU_ID,2,2) FROM (SELECT gnum_menu_id,gstr_menu_name AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60,0,EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME)),EXTRACT(MINUTE FROM (GDT_ENDTIME-GDT_STARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_MENU_CLICK_LOG C WHERE GSTR_MENU_NAME !='Process Log Dashboard' AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))) GROUP BY PNAME,gnum_menu_id  "+
" UNION "+
" SELECT  PNAME,ROUND(AVG(PTIME),2),(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(PROCESSID,2,2)),3,SUBSTR(PROCESSID,2,2) FROM (SELECT PROCESSID,PROCESSNAME AS PNAME,ROUND(DECODE(EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60,0,EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME)),EXTRACT(MINUTE FROM (SAVEENDTIME-SAVESTARTTIME))*60)::NUMERIC,2) AS PTIME FROM GBLT_TRANS_LOG C WHERE ENDTIME IS NOT NULL  AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))) GROUP BY PNAME,PROCESSID ORDER BY 3";
*/
			//ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			//System.out.println(temp);
			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processtracking() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void processgraph(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String temp = "SELECT DISTINCT PROCESSNAME,NVL(IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'00:00:00','01:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'01:00:00','02:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'02:00:00','03:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'03:00:00','04:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'04:00:00','05:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'05:00:00','016:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'016:00:00','07:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'07:00:00','08:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'08:00:00','09:00:00','"+voObj.getStrToDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'09:00:00','10:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'10:00:00','11:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'11:00:00','12:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'12:00:00','16:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'16:00:00','14:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'14:00:00','15:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'15:00:00','16:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'16:00:00','17:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'17:00:00','18:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'18:00:00','19:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'19:00:00','20:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'20:00:00','21:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'21:00:00','22:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'22:00:00','23:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) ,IPD_MST.GET_AUDIT_AVG_TIME(1,STARTTIME,ENDTIME,'23:00:00','24:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ) FROM GBLT_TRANS_LOG A WHERE ENDTIME IS NOT NULL AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))";
		
		//if(voObj.getStrValue1().equals("1"))// Trans Time
			//temp= "SELECT DISTINCT PROCESSNAME,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'00:00:00','01:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'01:00:00','02:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'02:00:00','03:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'03:00:00','04:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'04:00:00','05:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'05:00:00','016:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'016:00:00','07:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'07:00:00','08:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'08:00:00','09:00:00','"+voObj.getStrToDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'09:00:00','10:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'10:00:00','11:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'11:00:00','12:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'12:00:00','16:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'16:00:00','14:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'14:00:00','15:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'15:00:00','16:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'16:00:00','17:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'17:00:00','18:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0) ,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'18:00:00','19:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'19:00:00','20:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0) ,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'20:00:00','21:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0) ,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'21:00:00','22:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0) ,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'22:00:00','23:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0) ,NVL(IPD_MST.GET_AUDIT_AVG_TIME("+voObj.getStrValue1()+",STARTTIME,ENDTIME,'23:00:00','24:00:00','"+voObj.getStrFromDate()+"','"+voObj.getStrToDate()+"',PROCESSNAME ),0),GSTR_MODULE_NAME FROM GBLT_TRANS_LOG A WHERE ENDTIME IS NOT NULL AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY'))";
			
			temp= "SELECT  PROCESSNAME::text,  NVL(h00,0) ::numeric, NVL(h01,0) ::numeric, NVL(h02,0) ::numeric, NVL(h03,0) ::numeric, NVL(h04,0) ::numeric, NVL(h05,0) ::numeric,  "+
					" NVL(h06,0) ::numeric, NVL(h07,0) ::numeric, NVL(h08,0) ::numeric, NVL(h09,0) ::numeric, NVL(h10,0) ::numeric, NVL(h11,0) ::numeric,  NVL(h12,0) ::numeric, "+
					" NVL(h13,0) ::numeric, NVL(h14,0) ::numeric, NVL(h15,0) ::numeric, NVL(h16,0) ::numeric, NVL(h17,0) ::numeric,  NVL(h18,0) ::numeric, NVL(h19,0) ::numeric, "+
					" NVL(h20,0) ::numeric, NVL(h21,0) ::numeric, NVL(h22,0) ::numeric, NVL(h23,0) ::numeric,GSTR_MODULE_NAME::text"+
					" FROM crosstab('"+
					" SELECT PROCESSNAME,GSTR_MODULE_NAME ,EXTRACT(HOUR from GDT_ENTRY_DATE) AS h, nvl(round(avg(round(EXTRACT(SECOND FROM (SAVEENDTIME-SAVESTARTTIME))::numeric,2)),2),0) AS ct"+
					" FROM   GBLT_TRANS_LOG WHERE ENDTIME IS NOT NULL AND SAVEENDTIME>SAVESTARTTIME AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE(''"+voObj.getStrFromDate()+"'',''DD-MON-YYYY'')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE(''"+voObj.getStrToDate()+"'',''DD-MON-YYYY'')) "+
					" GROUP  BY 1, 2,3 ORDER  BY 1, 2,3' "+
					",'SELECT g::float8 FROM generate_series(0,23) g' "+
					" ) AS ct (PROCESSNAME text,GSTR_MODULE_NAME text" + 
					", h00 numeric, h01 numeric, h02 numeric, h03 numeric, h04 numeric, h05 numeric" + 
					", h06 numeric, h07 numeric, h08 numeric, h09 numeric, h10 numeric, h11 numeric" + 
					", h12 numeric, h13 numeric, h14 numeric, h15 numeric, h16 numeric, h17 numeric" + 
					", h18 numeric, h19 numeric, h20 numeric, h21 numeric, h22 numeric, h23 numeric) ";
			
			if(voObj.getStrValue1().equals("2"))// Loading Time
				temp= "SELECT  PROCESSNAME::text,  NVL(h00,0) ::numeric, NVL(h01,0) ::numeric, NVL(h02,0) ::numeric, NVL(h03,0) ::numeric, NVL(h04,0) ::numeric, NVL(h05,0) ::numeric,  "+
						" NVL(h06,0) ::numeric, NVL(h07,0) ::numeric, NVL(h08,0) ::numeric, NVL(h09,0) ::numeric, NVL(h10,0) ::numeric, NVL(h11,0) ::numeric,  NVL(h12,0) ::numeric, "+
						" NVL(h13,0) ::numeric, NVL(h14,0) ::numeric, NVL(h15,0) ::numeric, NVL(h16,0) ::numeric, NVL(h17,0) ::numeric,  NVL(h18,0) ::numeric, NVL(h19,0) ::numeric, "+
						" NVL(h20,0) ::numeric, NVL(h21,0) ::numeric, NVL(h22,0) ::numeric, NVL(h23,0) ::numeric,GSTR_MODULE_NAME::text"+
						" FROM crosstab('"+
						" SELECT GSTR_MENU_NAME,(SELECT GSTR_MODULE_NAME  FROM GBLT_METATABLE_TYPE_MST WHERE GBL_ISVALID=1 AND GNUM_MODULE_ID=SUBSTR(GNUM_MENU_ID,2,2))," + 
						" EXTRACT(HOUR FROM GDT_ENTRY_DATE) AS H, NVL(ROUND(AVG(ROUND(EXTRACT(SECOND FROM (GDT_ENDTIME-GDT_STARTTIME))::NUMERIC,2)),2),0) AS CT " + 
						" FROM   GBLT_MENU_CLICK_LOG WHERE GDT_ENDTIME IS NOT NULL AND GDT_ENDTIME>GDT_STARTTIME AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE(''"+voObj.getStrFromDate()+"'',''DD-MON-YYYY'')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE(''"+voObj.getStrToDate()+"'',''DD-MON-YYYY'')) "+
						" GROUP  BY 1, 2,3 ORDER  BY 1, 2,3' "+
						",'SELECT g::float8 FROM generate_series(0,23) g' "+
						" ) AS ct (PROCESSNAME text,GSTR_MODULE_NAME text" + 
						", h00 numeric, h01 numeric, h02 numeric, h03 numeric, h04 numeric, h05 numeric" + 
						", h06 numeric, h07 numeric, h08 numeric, h09 numeric, h10 numeric, h11 numeric" + 
						", h12 numeric, h13 numeric, h14 numeric, h15 numeric, h16 numeric, h17 numeric" + 
						", h18 numeric, h19 numeric, h20 numeric, h21 numeric, h22 numeric, h23 numeric) ";
			
			if(voObj.getStrValue1().equals("1"))// Trans Time
			temp= "SELECT  PROCESSNAME::text,  NVL(h00,0) ::numeric, NVL(h01,0) ::numeric, NVL(h02,0) ::numeric, NVL(h03,0) ::numeric, NVL(h04,0) ::numeric, NVL(h05,0) ::numeric,  "+
					" NVL(h06,0) ::numeric, NVL(h07,0) ::numeric, NVL(h08,0) ::numeric, NVL(h09,0) ::numeric, NVL(h10,0) ::numeric, NVL(h11,0) ::numeric,  NVL(h12,0) ::numeric, "+
					" NVL(h13,0) ::numeric, NVL(h14,0) ::numeric, NVL(h15,0) ::numeric, NVL(h16,0) ::numeric, NVL(h17,0) ::numeric,  NVL(h18,0) ::numeric, NVL(h19,0) ::numeric, "+
					" NVL(h20,0) ::numeric, NVL(h21,0) ::numeric, NVL(h22,0) ::numeric, NVL(h23,0) ::numeric,GSTR_MODULE_NAME::text"+
					" FROM crosstab('"+
					" SELECT PROCESSNAME,GSTR_MODULE_NAME ,EXTRACT(HOUR from GDT_ENTRY_DATE) AS h, nvl(round(avg(round(EXTRACT(SECOND FROM (ENDTIME-STARTTIME))::numeric,2)),2),0) AS ct"+
					" FROM   GBLT_TRANS_LOG WHERE ENDTIME IS NOT NULL AND ENDTIME>STARTTIME AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE(''"+voObj.getStrFromDate()+"'',''DD-MON-YYYY'')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE(''"+voObj.getStrToDate()+"'',''DD-MON-YYYY'')) "+
					" GROUP  BY 1, 2,3 ORDER  BY 1, 2,3' "+
					",'SELECT g::float8 FROM generate_series(0,23) g' "+
					" ) AS ct (PROCESSNAME text,GSTR_MODULE_NAME text" + 
					", h00 numeric, h01 numeric, h02 numeric, h03 numeric, h04 numeric, h05 numeric" + 
					", h06 numeric, h07 numeric, h08 numeric, h09 numeric, h10 numeric, h11 numeric" + 
					", h12 numeric, h13 numeric, h14 numeric, h15 numeric, h16 numeric, h17 numeric" + 
					", h18 numeric, h19 numeric, h20 numeric, h21 numeric, h22 numeric, h23 numeric) ";
				
			//System.out.println(temp);
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			
			ws=daoObj.getQryResult(temp);
		
			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void userWiseFreqClickMenu(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String hosp_code=voObj.getHospitalCode();
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			//ws=daoObj.getQryResult("select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2),decode(trans_type,1,'Loading Time',2,'Submission Time',3,'Save Time',4,'Total Trans Time','Loading Time') as error from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL order by starttime desc,1 asc,2 asc");
			
			//ws=daoObj.getQryResult("select ipd_mst.user_name(gnum_userid,gnum_hospital_code),gstr_menu_name,count(gstr_menu_name) from gblt_menu_click_log c where GSTR_MENU_NAME !='Process Log Dashboard' group by gnum_userid,gnum_hospital_code,gstr_menu_name order by 3 desc, 1 asc,2 asc");
			
			String query="select ipd_mst.user_name(gnum_userid,gnum_hospital_code),gstr_menu_name,count(gstr_menu_name),gnum_menu_id,gnum_userid from gblt_menu_click_log c where GDT_ENDTIME IS NOT NULL AND TRUNC(GDT_ENTRY_DATE) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(GDT_ENTRY_DATE) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" AND  GSTR_MENU_NAME !='Process Log Dashboard' group by gnum_menu_id, gnum_userid,gnum_hospital_code,gstr_menu_name order by 3 desc, 1 asc,2 asc";
			//ws=daoObj.getQryResult("select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2),decode(trans_type,1,'Loading Time',2,'Submission Time',3,'Save Time',4,'Total Trans Time','Loading Time') as error from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL order by starttime desc,1 asc,2 asc"0);
			
			ws=daoObj.getQryResult(query);

			//System.out.println(query);

			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.userWiseFreqClickMenu() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void crTrackingDetails(IpdVO vo) 
	{
		String strCrNo = null;
		WebRowSet wb = null;
		String PROC_NAME = "";
		PROC_NAME = "{call pkg_bill_view.proc_sblt_cr_tracking_dtl(?,?,?,?,?)}";
		HisDAO dao = null;
		int procIndex = 0;
		String strErr = "";

		try 
		{
			strCrNo = vo.getStrCRNo();
			dao = new HisDAO("ipd", "DAOIpd.crTrackingDetails");
			procIndex = dao.setProcedure(PROC_NAME);

			dao.setProcInValue(procIndex, "mode_type", "1", 1);
			dao.setProcInValue(procIndex, "crno", strCrNo, 2);	
			dao.setProcInValue(procIndex, "hosp_code", vo.getStrHospCode(),3); // New Value
			dao.setProcOutValue(procIndex, "err", 1, 4);
			dao.setProcOutValue(procIndex, "resultset", 2, 5);
			
			dao.executeProcedureByPosition(procIndex);
			strErr = dao.getString(procIndex, "err");
			
			if (strErr == null)
				strErr = "";
			wb = dao.getWebRowSet(procIndex, "resultset");

			if (strErr.equals("")) 
			{
				vo.setGblWs1(wb);
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			vo.setStrMsgString("DAOIpd.crTrackingDetails() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		finally 
		{

			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
		}
	}
	
	public static void processtrackinglisting(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";

		String strSearchString 	= voObj.getStrValue2();
		String strSearchType 	= voObj.getStrValue3();
		

		
		

		if (strSearchType == null || strSearchType.equals(""))
			strSearchType = "0";
		if (strSearchString == null || strSearchString.equals(""))
			strSearchString = "";

		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");


			//ws=daoObj.getQryResult_EDB("select jobname,decode(jslstatus,'r','Successful','s','Successful','Failed') status,to_char(jslstart,'DD-Mon-YYYY, HH24:MI:SS') as start_date,to_char(jslstart+jslduration,'DD-Mon-YYYY, HH24:MI:SS') as end_date ,jslduration  duration,jsloutput as error from pgagent.pga_jobstep a ,pgagent.pga_jobsteplog b,pgagent.pga_job  c where a.jstjobid=c.jobid and a.jstid=b.jsljstid AND trunc(jslstart)>=trunc(SYSDATE-30) order by jslstart desc ,1 asc");
			//ws=daoObj.getQryResult("select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2),decode(trans_type,1,'Loading Time',2,'Submission Time',3,'Save Time',4,'Total Trans Time','Loading Time') as error from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL order by starttime desc,1 asc,2 asc");
			
			ws=daoObj.getQryResult("select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60,0,EXTRACT(SECOND FROM (ENDTIME-STARTTIME)),EXTRACT(MINUTE FROM (ENDTIME-STARTTIME))*60)::NUMERIC,2),decode(trans_type,1,'Process Loading Time',2,'Loading Time Log',3,'Save Time Log',4,'Process Trans Time','Process Trans Time') as error,decode(gnum_device_type,'1','Desktop','2','Mobile/Tablet','3','Kiosk','Desktop'),hrgnum_ip_address,to_char(gdt_entry_date,'DD-Mon-YYYY'),gdt_entry_date,trans_type as trans_type,to_char(gdt_entry_date,'YYYYMMDD') from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL "
			+" union all "
			+" select gstr_menu_name,ipd_mst.user_name(gnum_userid,gnum_hospital_code),to_char(gdt_starttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(gdt_endtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (gdt_ENDTIME-gdt_STARTTIME))*60,0,EXTRACT(SECOND FROM (gdt_ENDTIME-gdt_STARTTIME)),EXTRACT(MINUTE FROM (gdt_ENDTIME-gdt_STARTTIME))*60)::NUMERIC,2),'Process Loading Time',decode(gnum_device_type,'1','Desktop','2','Mobile/Tablet','3','Kiosk','Desktop'),hrgnum_ip_address,to_char(gdt_entry_date,'DD-Mon-YYYY'),gdt_entry_date,1 as trans_type,to_char(gdt_entry_date,'YYYYMMDD') from gblt_menu_click_log c WHERE gdt_endtime IS NOT NULL and gnum_menu_id not in (118033000000)" 
			+" union all"
			+" select processname,ipd_mst.user_name(gnum_seatid,gnum_hospital_code),to_char(savestarttime,'DD-Mon-YYYY, HH24:MI:SS.ff') as start_date,to_char(saveendtime,'DD-Mon-YYYY, HH24:MI:SS.ff') as end_date,ROUND(DECODE(EXTRACT(MINUTE FROM (saveENDTIME-saveSTARTTIME))*60,0,EXTRACT(SECOND FROM (saveENDTIME-saveSTARTTIME)),EXTRACT(MINUTE FROM (saveENDTIME-saveSTARTTIME))*60)::NUMERIC,2),'Save Response Time' as error,decode(gnum_device_type,'1','Desktop','2','Mobile/Tablet','3','Kiosk','Desktop'),hrgnum_ip_address,to_char(gdt_entry_date,'DD-Mon-YYYY'),gdt_entry_date,3 as trans_type,to_char(gdt_entry_date,'YYYYMMDD') from GBLT_TRANS_LOG c WHERE endtime IS NOT NULL " 
			+" order by gdt_entry_date desc,1 asc,2 asc" );


			if (strErr.equals("")) 
			{
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processtracking() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}

	public static void activitylog(IpdVO voObj) 
	{
		//System.out.println("GET ACTIVITY LOG-TRANS");
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String hosp_code = voObj.getHospitalCode();
		//String temp = "select (select ipd_mst.user_name(gnum_userid,gnum_hospital_code) from  gblt_menu_click_log LIMIT 1),gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gnum_menu_id from  gblt_menu_click_log where gdt_entry_date between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2)";
		String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),ipd_mst.user_name(gnum_seatid,gnum_hospital_code),nvl(gstr_patient_name,'-'),nvl(hrgnum_puk,0),hrgnum_ip_address,gstr_app_host from gblt_trans_log where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" ORDER BY GSTR_USER_NAME, GDT_ENTRY_DATE DESC"; 
		String temp1 = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),ipd_mst.user_name(gnum_seatid,gnum_hospital_code),nvl(gstr_patient_name,'-'),nvl(hrgnum_puk,0),hrgnum_ip_address,gstr_app_host from gblt_trans_log where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" AND GNUM_SEATID ='"+voObj.getStrUsrId()+"' ORDER BY GSTR_USER_NAME, GDT_ENTRY_DATE DESC";
				
				
		
	//System.err.println(temp);
	
	//System.out.println(temp1);
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (voObj.getStrUsrId().equals("") || voObj.getStrUsrId().equals("0")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				ws=daoObj.getQryResult(temp1);
				voObj.setGblWs1(ws);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void userwisenooftransperformed(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String hosp_code=voObj.getHospitalCode();
		//String temp = "select (select ipd_mst.user_name(gnum_userid,gnum_hospital_code) from  gblt_menu_click_log LIMIT 1),gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gnum_menu_id from  gblt_menu_click_log where gdt_entry_date between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2)";
		String temp = "SELECT IPD_MST.USER_NAME(GNUM_SEATID,GNUM_HOSPITAL_CODE)  ,to_char(to_date(GDT_ENTRY_DATE, 'YYYY-MM-DD'), 'DD-MON-YYYY') ,COUNT(*) FROM   GBLT_TRANS_LOG WHERE TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GDT_ENTRY_DATE IS NOT NULL   AND GNUM_HOSPITAL_CODE="+hosp_code+" GROUP BY GNUM_SEATID,GNUM_HOSPITAL_CODE,to_char(to_date(GDT_ENTRY_DATE, 'YYYY-MM-DD'), 'DD-MON-YYYY')";
		String temp1 = "SELECT IPD_MST.USER_NAME(GNUM_SEATID,GNUM_HOSPITAL_CODE)  ,to_char(to_date(GDT_ENTRY_DATE, 'YYYY-MM-DD'), 'DD-MON-YYYY') ,COUNT(*) FROM   GBLT_TRANS_LOG WHERE TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_SEATID='"+voObj.getStrUsrId()+"'AND GDT_ENTRY_DATE IS NOT NULL AND GNUM_HOSPITAL_CODE="+hosp_code+"  GROUP BY GNUM_SEATID,GNUM_HOSPITAL_CODE,to_char(to_date(GDT_ENTRY_DATE, 'YYYY-MM-DD'), 'DD-MON-YYYY')";
		
	//System.out.println(temp);
	//System.out.println(temp1);
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
			if (voObj.getStrUsrId().equals("") || voObj.getStrUsrId().equals("0")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				ws=daoObj.getQryResult(temp1);
				voObj.setGblWs1(ws);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void getactivitylog(IpdVO voObj) 
	{
		//System.out.println("USERWISE FREQMENU-MENULOG");
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String hosp_code=voObj.getHospitalCode();
		String temp = "select ipd_mst.user_name(gnum_userid,gnum_hospital_code) ,gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM') from  gblt_menu_click_log  where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" AND GNUM_USERID="+voObj.getStrProcessName()+" AND GNUM_MENU_ID="+voObj.getStrMenuName()+" ORDER BY GDT_ENTRY_DATE DESC";
		//String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where processname='"+voObj.getStrProcessName()+"'";
		//String temp1 = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where endtime between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2) and gnum_seatid ='"+voObj.getStrUsrId()+"'";
	     //System.out.println(temp);
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (strErr.equals("")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
			
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}	
	public static void getactivityTranslog(IpdVO voObj) 
	{
		//System.out.println("USERWISE FREQMENU-TRANSLOG");
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String hosp_code=voObj.getHospitalCode();
		String temp = "select ipd_mst.user_name(gnum_seatid,gnum_hospital_code), processname,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM') ,nvl(gstr_patient_name,'-'),nvl(hrgnum_puk,0) from  gblt_trans_log where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) and gnum_seatid="+voObj.getStrMenuName()+" AND GNUM_HOSPITAL_CODE="+hosp_code+" AND PROCESSID="+voObj.getStrProcessName()+" ORDER BY 1,GDT_ENTRY_DATE DESC";
		//String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where processname='"+voObj.getStrProcessName()+"'";
		//String temp1 = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where endtime between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2) and gnum_seatid ='"+voObj.getStrUsrId()+"'";
				
				
		
		
		//System.out.println(temp);
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (strErr.equals("")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
			
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getactivityMenulog(IpdVO voObj) 
	{
		//System.out.println("USERWISE FREQMENU-MENULOG");
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String hosp_code=voObj.getHospitalCode();
		String temp = "select ipd_mst.user_name(gnum_userid,gnum_hospital_code) ,gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM')from  gblt_menu_click_log  where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" and gnum_userid="+voObj.getStrMenuName()+" and gnum_menu_id="+voObj.getStrProcessName()+" ORDER BY 1,, GDT_ENTRY_DATE DESC ";
		//String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where processname='"+voObj.getStrProcessName()+"'";
		//String temp1 = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where endtime between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2) and gnum_seatid ='"+voObj.getStrUsrId()+"'";
				
				
	//System.out.println(temp);
		
		
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (strErr.equals("")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
			
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	
	public static void getMenuwisedata(IpdVO voObj) 
	{
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strErr = "";
		String temp = "select gstr_menu_name from gblt_menu_controller_mapping_mst where gnum_module_id ='"+voObj.getStrMenuName()+"'";
		//String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where processname='"+voObj.getStrProcessName()+"'";
		//String temp1 = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where endtime between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2) and gnum_seatid ='"+voObj.getStrUsrId()+"'";
				
				
	//System.out.println(temp);
		
		
		
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (strErr.equals("")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				throw new Exception(strErr);
			}
			
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}
	public static void activitytranslog(IpdVO voObj) 
	{
		//System.out.println("GET ACTIVITY LOG-MENU LOG");
		HisDAO daoObj = null;
		WebRowSet ws = null;
		String hosp_code = voObj.getHospitalCode();
		String temp = "select gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'), ipd_mst.user_name(gnum_userid,gnum_hospital_code),gnum_menu_id ,hrgnum_ip_address from  gblt_menu_click_log where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" ORDER BY USER_NAME,GDT_ENTRY_DATE DESC" ;
		//String temp = "select processname, to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'),gstr_user_name,gstr_patient_name,hrgnum_puk from gblt_trans_log where endtime between '"+voObj.getStrFromDate()+"' and ('"+voObj.getStrToDate()+"',2)";
		String temp1 = "select gstr_menu_name,to_char(gdt_entry_date , 'Mon DD YYYY HH24:MI AM'), ipd_mst.user_name(gnum_userid,gnum_hospital_code),gnum_menu_id ,hrgnum_ip_address from  gblt_menu_click_log where TRUNC(gdt_entry_date) >=TRUNC(TO_DATE('"+voObj.getStrFromDate()+"','DD-MON-YYYY')) AND TRUNC(gdt_entry_date) <=TRUNC(TO_DATE('"+voObj.getStrToDate()+"','DD-MON-YYYY')) AND GNUM_HOSPITAL_CODE="+hosp_code+" AND GNUM_USERID ='"+voObj.getStrUsrId()+"' ORDER BY USER_NAME,GDT_ENTRY_DATE DESC";
				
				
		
		 //System.out.println(temp);
		  
		 // System.out.println("f----------------"+voObj.getStrFromDate());
		 // System.out.println("t----------------"+voObj.getStrToDate());
		 // System.out.println("username----------------"+voObj.getStrUsrId());
		 
		//System.out.println(temp1);
		try 
		{
			daoObj = new HisDAO("ADT", "DAOIpd");
	
			if (voObj.getStrUsrId().equals("") || voObj.getStrUsrId().equals("0")) 
			{
				ws=daoObj.getQryResult(temp);
				voObj.setGblWs1(ws);
				//System.out.println("ws size"+ws.size());
			} 
			else 
			{
				ws=daoObj.getQryResult(temp1);
				voObj.setGblWs1(ws);
			}
		} 
		catch (Exception e) 
		{
			voObj.setStrMsgString("DAOIpd.processgraph() --> "+ e.getMessage());
			voObj.setStrMsgType("1");
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}

	}	
}