package mms.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class DmlHsttPatEmpIssueDtlDAO {
	
	private final String strFileName = "mms.dao.DmlHsttPatEmpIssueDtlDAO";

	  
	private String strSeatId = "";
	private String strHospitalCode = "";
	private String strOrderBy = "";
	private String strOrderDate = "";
	private String strDays = ""; 
	private String strStoreId = "";
	private String strIssueNo = "";
	private String strRequestNo = "";
	private String strRequestDate = "";
	private String strCrNo = "";
	private String strReqTypeId = "";
	private String strAdmNo = "";
	private String strEmpNo = "";
	private String strItemCatNo = "0";
	private String strFinalCost = "0";
	private String strFinStartDate = "";
	private String strFinEndDate = "";
	private String strDeptUnitCode = "";
	private String strVisitType = "";
	private String strDeptCode = "";
	private String strWardCode = "0";
	private String strReceiveBy = "";
	private String strRemarks = "";
	private String strReqDate = "";
	private String strVisitNo = "";
	private String strEpisoCode = "";
	private String strTransType ="";
	
	private String strDrugIssueDate="";
	private String strOutOfStockFlag="";
	
    private String strCost = "";
		
	private String strErr = "";
	
	private int nRowInserted = 0;
	private int nRowUpdated = 0;
	private int nRowDeleted = 0;
	private int nInsertedIndex = 0;
	private int nUpdatedIndex = 0;
	private int nDeletedIndex = 0;
	
	//Patient Details
	private String strPatientId;
	private String strPatientType;
	private String strPatientName;
	private String strPatientAge;
	private String strPatientAgeUnit;
    private String strPatientFatherName;
	private String strPatientGenderCode;
    private String strPatientAddress;
    
    private String strFirstName;//27
    private String strMiddelName; //28
    private String strLastName;	//29		
    private String strIcdCode;
    private String strEmpCode;
	
	public String getStrIcdCode() {
		return strIcdCode;
	}
	public void setStrIcdCode(String strIcdCode) {
		this.strIcdCode = strIcdCode;
	}
	public String getStrEmpCode() {
		return strEmpCode;
	}
	public void setStrEmpCode(String strEmpCode) {
		this.strEmpCode = strEmpCode;
	}
	public String getStrPatientId() {
		return strPatientId;
	}
	public void setStrPatientId(String strPatientId) {
		this.strPatientId = strPatientId;
	}
	public String getStrPatientType() {
		return strPatientType;
	}
	public void setStrPatientType(String strPatientType) {
		this.strPatientType = strPatientType;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getStrPatientAge() {
		return strPatientAge;
	}
	public void setStrPatientAge(String strPatientAge) {
		this.strPatientAge = strPatientAge;
	}
	public String getStrPatientAgeUnit() {
		return strPatientAgeUnit;
	}
	public void setStrPatientAgeUnit(String strPatientAgeUnit) {
		this.strPatientAgeUnit = strPatientAgeUnit;
	}
	public String getStrPatientFatherName() {
		return strPatientFatherName;
	}
	public void setStrPatientFatherName(String strPatientFatherName) {
		this.strPatientFatherName = strPatientFatherName;
	}
	public String getStrPatientGenderCode() {
		return strPatientGenderCode;
	}
	public void setStrPatientGenderCode(String strPatientGenderCode) {
		this.strPatientGenderCode = strPatientGenderCode;
	}
	public String getStrPatientAddress() {
		return strPatientAddress;
	}
	public void setStrPatientAddress(String strPatientAddress) {
		this.strPatientAddress = strPatientAddress;
	}
	public String getStrSeatId() {
		return strSeatId;
	}
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}
	public String getStrHospitalCode() {
		return strHospitalCode;
	}
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}
	public String getStrStoreId() {
		return strStoreId;
	}
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}
	public String getStrIssueNo() {
		return strIssueNo;
	}
	public void setStrIssueNo(String strIssueNo) {
		this.strIssueNo = strIssueNo;
	}
	public String getStrRequestNo() {
		return strRequestNo;
	}
	public void setStrRequestNo(String strRequestNo) {
		this.strRequestNo = strRequestNo;
	}
	public String getStrRequestDate() {
		return strRequestDate;
	}
	public void setStrRequestDate(String strRequestDate) {
		this.strRequestDate = strRequestDate;
	}
	public String getStrCrNo() {
		return strCrNo;
	}
	public void setStrCrNo(String strCrNo) {
		this.strCrNo = strCrNo;
	}
	public String getStrReqTypeId() {
		return strReqTypeId;
	}
	public void setStrReqTypeId(String strReqTypeId) {
		this.strReqTypeId = strReqTypeId;
	}
	public String getStrAdmNo() {
		return strAdmNo;
	}
	public void setStrAdmNo(String strAdmNo) {
		this.strAdmNo = strAdmNo;
	}
	public String getStrEmpNo() {
		return strEmpNo;
	}
	public void setStrEmpNo(String strEmpNo) {
		this.strEmpNo = strEmpNo;
	}
	public String getStrItemCatNo() {
		return strItemCatNo;
	}
	public void setStrItemCatNo(String strItemCatNo) {
		this.strItemCatNo = strItemCatNo;
	}
	public String getStrFinalCost() {
		return strFinalCost;
	}
	public void setStrFinalCost(String strFinalCost) {
		this.strFinalCost = strFinalCost;
	}
	public String getStrFinStartDate() {
		return strFinStartDate;
	}
	public void setStrFinStartDate(String strFinStartDate) {
		this.strFinStartDate = strFinStartDate;
	}
	public String getStrFinEndDate() {
		return strFinEndDate;
	}
	public void setStrFinEndDate(String strFinEndDate) {
		this.strFinEndDate = strFinEndDate;
	}
	public String getStrDeptUnitCode() {
		return strDeptUnitCode;
	}
	public void setStrDeptUnitCode(String strDeptUnitCode) {
		this.strDeptUnitCode = strDeptUnitCode;
	}
	public String getStrVisitType() {
		return strVisitType;
	}
	public void setStrVisitType(String strVisitType) {
		this.strVisitType = strVisitType;
	}
	public String getStrDeptCode() {
		return strDeptCode;
	}
	public void setStrDeptCode(String strDeptCode) {
		this.strDeptCode = strDeptCode;
	}
	public String getStrWardCode() {
		return strWardCode;
	}
	public void setStrWardCode(String strWardCode) {
		this.strWardCode = strWardCode;
	}
	public String getStrReceiveBy() {
		return strReceiveBy;
	}
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}
	public String getStrRemarks() {
		return strRemarks;
	}
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}
	public String getStrErr() {
		return strErr;
	}
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}
	public int getNRowInserted() {
		return nRowInserted;
	}
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}
	public int getNRowUpdated() {
		return nRowUpdated;
	}
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}
	public int getNRowDeleted() {
		return nRowDeleted;
	}
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}
	
	public void insert(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try 
		{
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) 
			{
				throw new Exception("strHospitalCode can not be blank");
			}
			if(strRequestNo.equalsIgnoreCase("")||strRequestNo.equalsIgnoreCase(null))
			{
				strRequestNo="0";
			}			
			if(strItemCatNo.equalsIgnoreCase("")||strItemCatNo.equalsIgnoreCase(null))
			{
				strItemCatNo="0";
			}
			
			System.out.println(" ------- Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls  --[ Mode- 1 ]------ ");
			
			strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?    ,?,?,?,?,?)}";//40
			nProcIndex = dao.setProcedure(strProcName);			
			

			dao.setProcInValue(nProcIndex, "modeval", "1",1);//1
			dao.setProcInValue(nProcIndex, "strStoreId", strStoreId,2);//2 
			dao.setProcInValue(nProcIndex, "req_No",strRequestNo,3);
			dao.setProcInValue(nProcIndex, "strIssueNo", strIssueNo.split("\\^")[0],4); //3
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,5);//4 
			dao.setProcInValue(nProcIndex, "strOrderBy", strOrderBy,6);//6 
			dao.setProcInValue(nProcIndex, "strOrderDate",strOrderDate,7);//7 
			dao.setProcInValue(nProcIndex, "days",strDays,8); //8
			dao.setProcInValue(nProcIndex, "strCrNo", strCrNo,9);//9
			dao.setProcInValue(nProcIndex, "strReqTypeId",strReqTypeId,10);//10
			dao.setProcInValue(nProcIndex, "stradmno", strAdmNo,11);//11
			dao.setProcInValue(nProcIndex, "strempno", strEmpNo,12);//12
			dao.setProcInValue(nProcIndex, "strItemCatNo", strItemCatNo,13);//13
			dao.setProcInValue(nProcIndex, "strFinalCost", strFinalCost,14); //14
			dao.setProcInValue(nProcIndex, "strFinStartDate", strFinStartDate,15);//15
			dao.setProcInValue(nProcIndex, "strFinEndDate",strFinEndDate,16);//16
			
			//("strSeatId>>>>"+strSeatId);
			
			
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId,17);//17
			dao.setProcInValue(nProcIndex, "strDeptUnitCode",strDeptUnitCode,18);//18
			dao.setProcInValue(nProcIndex, "strVisitType", strVisitType,19);//19
			dao.setProcInValue(nProcIndex, "strDeptCode", strDeptCode,20);//20
			dao.setProcInValue(nProcIndex, "strWardCode", strWardCode,21); //21
			dao.setProcInValue(nProcIndex, "strRecieveBy",strReceiveBy,22); //22
			dao.setProcInValue(nProcIndex, "strRemarks",strRemarks.trim(),23);//23
			dao.setProcInValue(nProcIndex, "strReqDate",strReqDate.trim(),24);//24
			dao.setProcInValue(nProcIndex, "strEpiCode",strEpisoCode.trim(),25);//25			
			dao.setProcInValue(nProcIndex, "strVisitNo",strVisitNo.trim(),26);//26		
			 //System.out.println("strFirstName****"+strFirstName);
			
			dao.setProcInValue(nProcIndex, "p_first_name",strReceiveBy,27);//27
			dao.setProcInValue(nProcIndex, "p_middle_name","",28); //28
			dao.setProcInValue(nProcIndex, "p_last_name","",29);	//29		
			//30
			//31
			dao.setProcInValue(nProcIndex, "p_hststr_father_name","",30);//32
			dao.setProcInValue(nProcIndex, "p_hstdt_age","",31);//33
			dao.setProcInValue(nProcIndex, "p_gnum_gender_code","",32);//34
			dao.setProcInValue(nProcIndex, "p_hststr_address","",33);//35
			dao.setProcInValue(nProcIndex, "p_hststr_patient_id","",34);
			dao.setProcInValue(nProcIndex, "p_hstnum_patient_type","",35);
			
			dao.setProcInValue(nProcIndex, "p_trans_type","",36);//36
			
			dao.setProcInValue(nProcIndex, "p_age_unit","",37);//37
			////System.out.println("strDrugIssueDate"+strDrugIssueDate);
			//System.out.println("strOutOfStockFlag"+strOutOfStockFlag);
			dao.setProcInValue(nProcIndex, "p_issue_date",strReqDate.trim(),38);//38
			dao.setProcInValue(nProcIndex, "p_out_stock",strOutOfStockFlag,39);//39
			
			dao.setProcOutValue(nProcIndex, "err", 1,40);//40
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
			
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			//this.reset(); // to reset the variables
		}
	}
	
	public void inserttemp(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try 
		{
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) 
			{
				throw new Exception("strHospitalCode can not be blank");
			}
			if(strRequestNo.equalsIgnoreCase("")||strRequestNo.equalsIgnoreCase(null))
			{
				strRequestNo="0";
			}			
			if(strItemCatNo.equalsIgnoreCase("")||strItemCatNo.equalsIgnoreCase(null))
			{
				strItemCatNo="0";
			}
			
			strProcName = "{call Pkg_Mms_Dml.Dml_Patemp_Issue_Dtls_temp(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?    ,?,?,?,?,? ,?,?)}";//40
			nProcIndex = dao.setProcedure(strProcName);			
			

			dao.setProcInValue(nProcIndex, "modeval", "1",1);//1
			dao.setProcInValue(nProcIndex, "strStoreId", strStoreId,2);//2 
			dao.setProcInValue(nProcIndex, "req_No",strRequestNo,3);
			dao.setProcInValue(nProcIndex, "strIssueNo", strIssueNo.split("\\^")[0],4); //3
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,5);//4 
			dao.setProcInValue(nProcIndex, "strOrderBy", strOrderBy,6);//6 
			dao.setProcInValue(nProcIndex, "strOrderDate",strOrderDate,7);//7 
			dao.setProcInValue(nProcIndex, "days",strDays,8); //8
			dao.setProcInValue(nProcIndex, "strCrNo", strCrNo,9);//9
			dao.setProcInValue(nProcIndex, "strReqTypeId",strReqTypeId,10);//10
			dao.setProcInValue(nProcIndex, "stradmno", strAdmNo,11);//11
			dao.setProcInValue(nProcIndex, "strempno", strEmpNo,12);//12
			dao.setProcInValue(nProcIndex, "strItemCatNo", strItemCatNo,13);//13
			dao.setProcInValue(nProcIndex, "strFinalCost", strFinalCost,14); //14
			dao.setProcInValue(nProcIndex, "strFinStartDate", strFinStartDate,15);//15
			dao.setProcInValue(nProcIndex, "strFinEndDate",strFinEndDate,16);//16
			
			//System.out.println("strSeatId>>>>"+strSeatId);
			
			
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId,17);//17
			dao.setProcInValue(nProcIndex, "strDeptUnitCode",strDeptUnitCode,18);//18
			dao.setProcInValue(nProcIndex, "strVisitType", strVisitType,19);//19
			dao.setProcInValue(nProcIndex, "strDeptCode", strDeptCode,20);//20
			dao.setProcInValue(nProcIndex, "strWardCode", strWardCode,21); //21
			dao.setProcInValue(nProcIndex, "strRecieveBy",strReceiveBy,22); //22
			dao.setProcInValue(nProcIndex, "strRemarks",strRemarks.trim(),23);//23
			dao.setProcInValue(nProcIndex, "strReqDate",strReqDate.trim(),24);//24
			dao.setProcInValue(nProcIndex, "strEpiCode",strEpisoCode.trim(),25);//25			
			dao.setProcInValue(nProcIndex, "strVisitNo",strVisitNo.trim(),26);//26		
			 //System.out.println("strFirstName****"+strFirstName);
			
			dao.setProcInValue(nProcIndex, "p_first_name",strReceiveBy,27);//27
			dao.setProcInValue(nProcIndex, "p_middle_name","",28); //28
			dao.setProcInValue(nProcIndex, "p_last_name","",29);	//29		
			//30
			//31
			dao.setProcInValue(nProcIndex, "p_hststr_father_name","",30);//32
			dao.setProcInValue(nProcIndex, "p_hstdt_age","",31);//33
			dao.setProcInValue(nProcIndex, "p_gnum_gender_code","",32);//34
			dao.setProcInValue(nProcIndex, "p_hststr_address","",33);//35
			dao.setProcInValue(nProcIndex, "p_hststr_patient_id","",34);
			dao.setProcInValue(nProcIndex, "p_hstnum_patient_type","",35);
			
			dao.setProcInValue(nProcIndex, "p_trans_type","",36);//36
			
			dao.setProcInValue(nProcIndex, "p_age_unit","",37);//37
			////System.out.println("strDrugIssueDate"+strDrugIssueDate);
			//System.out.println("strOutOfStockFlag"+strOutOfStockFlag);
			dao.setProcInValue(nProcIndex, "p_issue_date",strReqDate.trim(),38);//38
			dao.setProcInValue(nProcIndex, "p_out_stock",strOutOfStockFlag,39);//39
			dao.setProcInValue(nProcIndex, "p_icd_code",strIcdCode,40);//39
			dao.setProcInValue(nProcIndex, "p_emp_code",strEmpCode,41);//39
			
			dao.setProcOutValue(nProcIndex, "err", 1,42);//40
			
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
			
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			//this.reset(); // to reset the variables
		}
	}
	
	/**
	 * This method will be used to insert the records
	 * 
	 * @param dao :
	 *            HisDAO Object
	 * @throws Exception -
	 *             when strHospitalCode 
	 *             is blank
	 */
	public void update(HisDAO dao) throws Exception {

		strErr = "";
		String strProcName = "";
		int nProcIndex = 0;

		try {

			// check mandatory information
			if (strHospitalCode.equals("0") || strHospitalCode.equals("")) {
				throw new Exception("strHospitalCode can not be blank");
			}
			
			strProcName = "{call Pkg_Mms_Dml2.Dml_Patemp_Issue_Dtls(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?)}";//5
			nProcIndex = dao.setProcedure(strProcName);
			
		
			  
			dao.setProcInValue(nProcIndex, "modeval", "2");
			dao.setProcInValue(nProcIndex, "hosp_code", strHospitalCode);
			dao.setProcInValue(nProcIndex, "strStoreId", strStoreId); 
			dao.setProcInValue(nProcIndex, "strIssueNo",strIssueNo);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "req_No", "");
			dao.setProcInValue(nProcIndex, "strOrderBy", "");
			dao.setProcInValue(nProcIndex, "strOrderDate", "");
			dao.setProcInValue(nProcIndex, "days", "");
			dao.setProcInValue(nProcIndex, "strCrNo", "");
			dao.setProcInValue(nProcIndex, "strReqTypeId", "");
			dao.setProcInValue(nProcIndex, "strAdmNo", "");
			dao.setProcInValue(nProcIndex, "strEmpNo", "");
			dao.setProcInValue(nProcIndex, "strItemCatNo", "");
			dao.setProcInValue(nProcIndex, "strFinalCost", "");
			dao.setProcInValue(nProcIndex, "strFinStartDate", "");
			dao.setProcInValue(nProcIndex, "strFinEndDate", "");
			dao.setProcInValue(nProcIndex, "strSeatId", "");
			dao.setProcInValue(nProcIndex, "strDeptUnitCode", "");
			dao.setProcInValue(nProcIndex, "strVisitType", "");
			dao.setProcInValue(nProcIndex, "strDeptCode", "");
			dao.setProcInValue(nProcIndex, "strWardCode", "");
			dao.setProcInValue(nProcIndex, "strRecieveBy", "");
			dao.setProcInValue(nProcIndex, "strRemarks", "");
			dao.setProcInValue(nProcIndex, "strReqDate", "");
			dao.setProcInValue(nProcIndex, "strEpiCode", "");
			dao.setProcInValue(nProcIndex, "strVisitNo", "");
			/* Setting Default Value End */
		
			dao.setProcOutValue(nProcIndex, "err", 1);
			
			dao.execute(nProcIndex, 1);
			this.nRowUpdated++;
		} catch (Exception e) {
			e.printStackTrace();

			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".update() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}

	}

	public void reset() {
		strSeatId = "";
		strHospitalCode = "";
		
		strStoreId = "";
		strIssueNo = "";
		strRequestNo = "";
		strRequestDate = "";
		strCrNo = "";
		strReqTypeId = "";
		strAdmNo = "";
		strEmpNo = "";
		strItemCatNo = "0";
		strFinalCost = "0";
		strFinStartDate = "";
		strFinEndDate = "";
		strDeptUnitCode = "";
		strVisitType = "";
		strDeptCode = "";
		strWardCode = "0";
		strReceiveBy = "";
		strRemarks = "";
	}
	public String getStrOrderBy() {
		return strOrderBy;
	}
	public void setStrOrderBy(String strOrderBy) {
		this.strOrderBy = strOrderBy;
	}
	public String getStrOrderDate() {
		return strOrderDate;
	}
	public void setStrOrderDate(String strOrderDate) {
		this.strOrderDate = strOrderDate;
	}
	public String getStrDays() {
		return strDays;
	}
	public void setStrDays(String strDays) {
		this.strDays = strDays;
	}
	public String getStrCost() {
		return strCost;
	}
	public void setStrCost(String strCost) {
		this.strCost = strCost;
	}
	public String getStrReqDate() {
		return strReqDate;
	}
	public void setStrReqDate(String strReqDate) {
		this.strReqDate = strReqDate;
	}
	public String getStrVisitNo() {
		return strVisitNo;
	}
	public void setStrVisitNo(String strVisitNo) {
		this.strVisitNo = strVisitNo;
	}
	public String getStrEpisoCode() {
		return strEpisoCode;
	}
	public void setStrEpisoCode(String strEpisoCode) {
		this.strEpisoCode = strEpisoCode;
	}
	public String getStrFirstName() {
		return strFirstName;
	}
	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}
	public String getStrMiddelName() {
		return strMiddelName;
	}
	public void setStrMiddelName(String strMiddelName) {
		this.strMiddelName = strMiddelName;
	}
	public String getStrLastName() {
		return strLastName;
	}
	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}
	public String getStrTransType() {
		return strTransType;
	}
	public void setStrTransType(String strTransType) {
		this.strTransType = strTransType;
	}
	public String getStrDrugIssueDate() {
		return strDrugIssueDate;
	}
	public void setStrDrugIssueDate(String strDrugIssueDate) {
		this.strDrugIssueDate = strDrugIssueDate;
	}
	public String getStrOutOfStockFlag() {
		return strOutOfStockFlag;
	}
	public void setStrOutOfStockFlag(String strOutOfStockFlag) {
		this.strOutOfStockFlag = strOutOfStockFlag;
	}
}
