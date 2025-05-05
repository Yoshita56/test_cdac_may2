package billing;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;

/*Function Details
 1. getBillingServiceDtl()
 2. getChargeTypeDtl()
 3. getIPDChargeTypeDtl()
 4. getServiceDtl()
 5.

*/

/*Common Parameter
 	option --> true/false. If user wants option string then true. if user wants
 				webrowset (all the column defined in query will populate) then false
	selValue,defOption --> Described in HisUtil Class
	concatForm --> true/false. If user wants to concate all the columns given
					in the query then pass true. If user wants only ID,Name then pass false.
					This parameter will apply only in option string.
	orderBy --> true/false. If user wants sorting then pass true else false
*/

//Note --> The method will be kept into corrosponding DAO. This File having only those
//methods for which there is no DAO available. Function only returns WebRowSet. If user
//wants combo then he must have called GetOptionValue function
public class DAOBillingCombo {

	private String qryStr = "";
	private String moduleName = "";
	private String fileName = "";
	private int qryIndex = 0;

	//error message
	private String errMsg = "";

	//constructor
	public DAOBillingCombo(String moduleName,String fileName) {
		this.moduleName = moduleName;
		this.fileName = fileName;
	}

	/*
	 	This function is used for Billing Service details.
	 	It has the following parameters
	 		chargeType --> Charge Type Id [OPD/IPD etc]. If user does not want to check it then
	 						pass -1
	 	Columns in query >>
	 	SBLNUM_BSERVICE_ID, NVL(SBLSTR_FILENAME,''), SBLSTR_BSERVICE_NAME
	*/
	public WebRowSet getBillingServiceDtl(int chargeType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.bservice.0");
		if(chargeType != -1) {
			//Hospital service id condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.bservice.cond.0");
			this.qryStr += " WHERE " + tempStr;
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.bservice.cond.1");
			this.qryStr += " AND " + tempStr;
		}
		else {
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.bservice.cond.1");
			this.qryStr += " WHERE " + tempStr;
		}

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.bservice.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(chargeType != -1) daoObj.setQryValue(qryIndex,1,String.valueOf(chargeType));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getBillingServiceCombo() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getBillingServiceCombo() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
		This function is used for ChargeType details.
		e.g. OPD/IPD/Emergency
		Columns in query >>
		SBLNUM_CHARGETYPE_ID, SBLSTR_CHARGETYPE_NAME
*/


	/*
		This function is used for ChargeType details.
		e.g. General/Private
		Columns in query >>
		SBLNUM_IPD_CHARGETYPE_ID, SBLSTR_IPD_CHARGETYPE_NAME
    */
	public WebRowSet getIPDChargeTypeDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.ipdchargetype.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.ipdchargetype.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				//fire the query
				ws = daoObj.getQryResult(this.qryStr);
			}
			else {
				this.errMsg = "GBLmstBilling.getIPDChargeTypeDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getIPDChargeTypeDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*
	 	This function is used for Service details.
	 	e.g. Investigation/OT etc
	 	Columns in query >>
	 	SBLNUM_SERVICE_ID,SBLSTR_QRY_INDEX,DECODE(SBLNUM_CHARGE_DEFINED,1,SBLSTR_RATEQRY_INDEX,'0'),
				SBLNUM_SERVICE_TYPE, INITCAP(SBLSTR_SERVICE_NAME)
	*/
	public WebRowSet getServiceDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.service.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.service.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				//fire the query
				ws = daoObj.getQryResult(this.qryStr);
			}
			else {
				this.errMsg = "GBLmstBilling.getServiceDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getServiceDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*
 	This function is used for Group details.
 	It has the following parameters
 		chargeType --> Charge Type Id [OPD/IPD]. If user does not want to check it then
 						pass -1
 		packageType --> either Package wise group or not. If user does not want then
 						pass -1
 		allGroups --> If it is true then it means that function should returns all groups
 						based on the given conditions. If it is false then it means that
 						function should return only those groups which does not exist in
 						HBLT_HSERVICE_GROUP_MST
 	Columns in query >>
 	HBLNUM_GROUP_ID,HBLNUM_IS_PACKAGE, INITCAP(HBLSTR_GROUP_NAME)
	*/
	public WebRowSet getGroupDtl(int chargeType,int packageType,boolean allGroups,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";
		int flag = 0;

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.group.0");
		//CHARGE TYPE
		if(chargeType != -1) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.group.cond.2");
			if(allGroups)
				this.qryStr += " WHERE EXISTS (" + tempStr + ")";
			else
				this.qryStr += " WHERE NOT EXISTS (" + tempStr + ")";
			flag = 1;
		}
		//PACKAGE TYPE
		if(packageType != -1) {
			//Hospital service id condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.group.cond.0");
			if(flag == 0)	//charge type was blank
				this.qryStr += " WHERE " + tempStr;
			else
				this.qryStr += " AND " + tempStr;
			flag = 1;
		}

		//COMPULSORY
		tempStr = billing.qryHandler_billing.getQuery(1,"gbl.group.cond.1");
		if(flag == 0)
			this.qryStr += " WHERE " + tempStr;
		else
			this.qryStr += " AND " + tempStr;

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.group.cond.3");
			this.qryStr += " " + tempStr;
		}		
		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);				
				this.qryIndex = daoObj.setQuery(this.qryStr);
				if(chargeType != -1) {					
					daoObj.setQryValue(qryIndex,1,String.valueOf(chargeType));
					if(packageType != -1){
						daoObj.setQryValue(qryIndex,2,String.valueOf(packageType));						
					}
						
				}
				else {
					if(packageType != -1)
						daoObj.setQryValue(qryIndex,1,String.valueOf(packageType));
				}

				//fire the query
				ws = daoObj.executeQry(this.qryIndex);				
			}
			else {
				this.errMsg = "GBLmstBilling.getGroupDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getGroupDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Remarks details.
 	It has the following parameters
 		remarksType --> either pass the following value or pass -1 for all remarks
 			1  --> DISCOUNT
 			2  -->CANCELLATION
 			3  -->REFUND
 			4  -->MISCELLANEOUS
 	Columns in query >>
 	HBLNUM_REMARKS_ID, SBLNUM_REMARKS_TYPE, INITCAP(HBLSTR_REMARKS)
	*/
	public WebRowSet getRemarksDtl(int remarksType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.remarks.0");
		if(remarksType != -1) {
			//Remarks Type condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.remarks.cond.0");
			this.qryStr += " WHERE " + tempStr;
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.remarks.cond.1");
			this.qryStr += " AND " + tempStr;
		}
		else {
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.remarks.cond.1");
			this.qryStr += " WHERE " + tempStr;
		}

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.remarks.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(remarksType != -1) daoObj.setQryValue(qryIndex,1,String.valueOf(remarksType));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getRemarksDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getRemarksDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Unit details.
 	It has the following parameters
 		moduleId --> Compulsory
 		unitLevel --> Level of unit. it could be -1
 		allUnits --> If it is true then it means that function should returns all units
 						based on the given conditions. If it is false then it means that
 						function should return only those units which does not exist in
 						GBLT_UNITVALUE_MST FOR GNUM_TOUNIT_ID COLUMN
 	Columns in query >>
 	A.GNUM_UNIT_ID, NVL(A.GNUM_BASEUNIT_ID,0),A.GNUM_UNIT_LEVEL,INITCAP(A.GSTR_UNIT_NAME)
	*/
	public WebRowSet getUnitDtl(int moduleId,int unitLevel,boolean allUnits,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.unit.0");
		if(unitLevel != -1) {
			//Unit Level Condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.unit.cond.0");
			this.qryStr += " AND " + tempStr;
		}

		//ALL UNIT CONDITION
		if(!allUnits) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.unit.cond.1");
			this.qryStr += " AND NOT EXISTS (" + tempStr + ")";
		}

		//COMPULSORY CONDITION
		tempStr = billing.qryHandler_billing.getQuery(1,"gbl.unit.cond.2");
		this.qryStr += " AND " + tempStr;

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.unit.cond.3");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);

				daoObj.setQryValue(qryIndex,1,String.valueOf(moduleId));
				if(unitLevel != -1) daoObj.setQryValue(qryIndex,2,String.valueOf(unitLevel));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getUnitDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getUnitDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Tariff details.
 	It has the following parameters
 		groupId --> Group Id. It is compulsory field
 	Columns in query >>
 	A.HBLNUM_TARIFF_ID,NVL(GSTR_TARIFF_ID,-1),HBLNUM_DEFAULT_UNIT,INITCAP(A.HBLSTR_TARIFF_NAME)
	*/
	public WebRowSet getTariffDtl(int groupId,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		//compulsory condition
		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.tariff.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.tariff.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				daoObj.setQryValue(qryIndex,1,String.valueOf(groupId));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getTariffDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getTariffDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Package details.
 	It has the following parameters
 		allPackage --> If it is true then it means that function should returns all packages
 						based on the given conditions. If it is false then it means that
 						function should return only those packages which does not exist in
 						HBLT_PACKAGE_SERVICE_MST
 	Columns in query >>
 	A.HBLNUM_TARIFF_ID, A.HBLNUM_GROUP_ID, NVL(A.HBLNUM_DEFAULT_UNIT,-1),
 	A.HBLNUM_TOTAL_STAY, A.HBLNUM_IS_CONTRIBUTION,INITCAP(A.HBLSTR_TARIFF_NAME)
	*/
	public WebRowSet getPackageDtl(boolean allPackage,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.package.0");
		//allPackage CONDITION
		if(!allPackage) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.package.cond.0");
			this.qryStr += " AND NOT EXISTS (" + tempStr + ")";
		}

		//COMPULSORY
		tempStr = billing.qryHandler_billing.getQuery(1,"gbl.package.cond.1");
		this.qryStr += " AND " + tempStr;

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.package.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				//fire the query
				ws = daoObj.getQryResult(this.qryStr);
			}
			else {
				this.errMsg = "GBLmstBilling.getPackageDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getPackageDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Package Service details.
 	It has the following parameters
 		pkgId --> Package Id. It is compulsory field
 	Columns in query >>
 	A.HBLNUM_TARIFF_ID, A.HBLNUM_GROUP_ID, NVL(HBLNUM_QTY,0), NVL(GNUM_UNIT_ID,-1),TRF_NAME
	*/
	public WebRowSet getPackageServiceDtl(int pkgId,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		//compulsory condition
		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.package.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.package.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				daoObj.setQryValue(qryIndex,1,String.valueOf(pkgId));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getPackageServiceDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getPackageServiceDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Charge details.
 	It has the following parameters
 		chargeTypeId --> Mandatory. e.g. OPD/IPD/Emergency
 		catCode --> Mandatory. It is patient category code like Normal, Staff etc
 		ipdChargeType --> could be paassed -1 for non-mandatory. It is ward type like general, private
 		groupId --> could be passed -1 for non-mandatory. It is group id

 	Columns in query >>
 	A.HBLNUM_TARIFF_ID||'^'||A.HBLNUM_CHARGE_SLNO||'^'||NVL(A.HBLNUM_PROCEDURE_COST,0)
 	||'^'||NVL(A.HBLNUM_TARIFF_COST,0)||'^'||NVL(A.HBLNUM_COST,0)||'^'||
 	NVL(A.GNUM_UNIT_ID,'-1'),A.HBLNUM_IS_ADVANCE,A.HBLNUM_IS_REFUNDABLE,
 	BILL_MST.gettariffname(A.HBLNUM_TARIFF_ID) TRF_NAME
	*/
	public WebRowSet getChargeDetail(int chargeTypeId,int catCode,int ipdChargeType,
			int groupId,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.charge.0");
		//IPD-Charge Type condition
		if(ipdChargeType != -1) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.charge.cond.0");
			this.qryStr += " AND " + tempStr;
		}
		//GROUP ID CONDITION
		if(groupId != -1) {
			//IPD-Charge Type condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.charge.cond.1");
			this.qryStr += " AND " + tempStr;
		}

		//compulsory condition
		tempStr = billing.qryHandler_billing.getQuery(1,"gbl.charge.cond.2");
		this.qryStr += " AND " + tempStr;

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.charge.cond.3");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				daoObj.setQryValue(qryIndex,1,String.valueOf(chargeTypeId));
				daoObj.setQryValue(qryIndex,2,String.valueOf(catCode));

				if(ipdChargeType != -1) {
					daoObj.setQryValue(qryIndex,3,String.valueOf(ipdChargeType));
					if(groupId != -1)
						daoObj.setQryValue(qryIndex,4,String.valueOf(groupId));
				}
				else {
					if(groupId != -1) daoObj.setQryValue(qryIndex,3,String.valueOf(groupId));
				}
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getChargeDetail() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getChargeDetail() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Billing Parameter Details
 	It has the following parameters
 		paramType --> Parameter Type. -1 for non-mandatory. e.g. General, OPD,IPD parameter etc
 	Columns in query >>
 	HBLSTR_PARAM_NAME, HBLSTR_PARAM_VALUE
	*/
	public WebRowSet getBillParameterDtl(int paramType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.setup.0");
		//param type condition
		if(paramType != -1) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.setup.cond.0");
			this.qryStr += " WHERE " + tempStr;
		}
		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.setup.cond.1");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(paramType != -1)
					daoObj.setQryValue(qryIndex,1,String.valueOf(paramType));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getBillParameterDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getBillParameterDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
		This function is used for Module details.
		Columns in query >>
		A.GNUM_MODULE_ID, A.GSTR_MODULE_NAME
	*/
	public WebRowSet getModuleDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.module.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.module.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				//fire the query
				ws = daoObj.getQryResult(this.qryStr);
			}
			else {
				this.errMsg = "GBLmstBilling.getModuleDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getModuleDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*
	This function is used for Ward details.
	Columns in query >>
	A.HANUM_WARD_CODE, INITCAP(A.HASTR_WARD_NAME)
	*/
	public WebRowSet getWardDtl(boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.ward.0");

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.ward.cond.0");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				//fire the query
				ws = daoObj.getQryResult(this.qryStr);
			}
			else {
				this.errMsg = "GBLmstBilling.getWardDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getWardDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
		return ws;
	}

	/*
 	This function is used for Department details.
 	It has the following parameters
 		deptType --> either pass the following value or pass "" for all departments
 			e.g. Clinical, Non-Clinical, Administartive etc
 	Columns in query >>
 	A.GNUM_DEPT_CODE||'^'||A.GNUM_DEPT_SLNO, NVL(GSTR_DEPT_SHORT,''), INITCAP(A.GSTR_DEPT_NAME)
	*/
	public WebRowSet getDepartmentDtl(String deptType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.dept.0");
		if(deptType.equals("")) {
			//Department Type condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.dept.cond.0");
			this.qryStr += " WHERE " + tempStr;
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.dept.cond.1");
			this.qryStr += " AND " + tempStr;
		}
		else {
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.dept.cond.1");
			this.qryStr += " WHERE " + tempStr;
		}

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.dept.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(deptType.equals("")) daoObj.setQryValue(qryIndex,1,deptType);
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getDepartmentDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getDepartmentDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Billing Category details.
 	It has the following parameters
 		catType --> either pass the particular value or pass -1 for all category

 	Columns in query >>
 	GNUM_PATIENT_CAT_CODE||'^'||GNUM_CAT_SLNO, NVL(GSTR_PATIENT_CAT_SHORT,''),INITCAP(A.GSTR_PATIENT_CAT_NAME)
	*/
	public WebRowSet getCategoryDtl(int catType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.cat.0");
		if(catType != -1) {
			//Department Type condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.cat.cond.0");
			this.qryStr += " WHERE " + tempStr;
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.cat.cond.1");
			this.qryStr += " AND " + tempStr;
		}
		else {
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.cat.cond.1");
			this.qryStr += " WHERE " + tempStr;
		}

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.cat.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(catType != -1) daoObj.setQryValue(qryIndex,1,String.valueOf(catType));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getCategoryDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getCategoryDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

	/*
 	This function is used for Location details.
 	It has the following parameters
 		locType --> either pass the particular value or pass -1 for all location

 	Columns in query >>
 	A.GNUM_LOCATION_CODE, NVL(A.GSTR_ROOM_NO,'/'), NVL(A.GSTR_FLOOR,'/'),
 	NVL(A.GSTR_BUILDING,'/'),NVL(A.GSTR_LANDMARK,'/'),INITCAP(A.GSTR_DESCRIPTION)
	*/
	public WebRowSet getLocationDtl(int locType,boolean orderBy) throws Exception {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String tempStr = "";

		this.errMsg = "";

		this.qryStr = billing.qryHandler_billing.getQuery(1,"gbl.location.0");
		if(locType != -1) {
			//Department Type condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.location.cond.0");
			this.qryStr += " WHERE " + tempStr;
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.location.cond.1");
			this.qryStr += " AND " + tempStr;
		}
		else {
			//compulsory condition
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.location.cond.1");
			this.qryStr += " WHERE " + tempStr;
		}

		//CHECK ORDER BY
		if(orderBy) {
			tempStr = billing.qryHandler_billing.getQuery(1,"gbl.location.cond.2");
			this.qryStr += " " + tempStr;
		}

		try {
			if(!this.qryStr.equals("")) {
				daoObj = new HisDAO(this.moduleName,"GBLmstBilling." + this.fileName);
				qryIndex = daoObj.setQuery(this.qryStr);
				if(locType != -1) daoObj.setQryValue(qryIndex,1,String.valueOf(locType));
				//fire the query
				ws = daoObj.executeQry(qryIndex);
			}
			else {
				this.errMsg = "GBLmstBilling.getLocationDtl() -->Query is blank";
				throw new Exception(this.errMsg);
			}
		}
		catch(Exception e) {
			this.errMsg = "GBLmstBilling.getLocationDtl() -->" + e.getMessage();
			throw new Exception(this.errMsg);
		}
		finally {
			if(daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}

		return ws;
	}

}
