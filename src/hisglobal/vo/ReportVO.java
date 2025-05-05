package hisglobal.vo;

public class ReportVO extends ValueObject {
	

	private String fromHour;
	private String toHour;
	private String fromMin;
	private String toMin;
	private String choice;
	private String fromDate;
	private String toDate;
	private String reportType;// rtf/pdf
	private String reportMode;// report or chart
	private String mode;// report or chart
	private String jrxmlName; 
	private String hospitalName="-";
	private String hospitalAdd="-";
	private String hospitalContact="-";
	private String hospitalId = "-";
	private String departmentCode;	
	private String patGenderCode;	
	private String patPrimaryCatCode;	
	private String patSecondaryCatCode;	
	private String deptCode;
	private String option;

	private String patGender;
	private String patRegCatCode;
	private String roomCode;
	private String patListing;
	private String chartType;
	private String emergencyType;
	private String unit;
	private String jrxmlPath;
	private String userCode;
	private String episodeStatus;
	private String fromDepartment;
	private String toDepartment;
	private String doctorCode;
	private String hospitalCode;
	private String poorFree;
	private String patCrNo;
	private String mlcNo;
	private String icdCode;
	private String startTime;
	private String endTime;
	private String cmoCode;
	private String locationCode;
	private String diseaseType;
	
	/*Investigation modules fields
	 * */
	private String specimenName;
	private String specimenCode;
	private String testCode;
	private String sampleCode;
	private String staffList;
	private String slideValue;
	
	
	
	//For SMS Jaipur presentation
	private String strQueueNo;
	private String strDeptName;
	private String strUnitName;
	private String strRoomName;
	
	//For Doctor Call Log Report
	private String wardCode;
	private String crNo;
	private String admnNo;
	private String empNo;
	
	private String status;
	private String unitCode;
	private String type;
	private String title;
	
	private String entryMode;
	private String entryModeLabel;
	private String deathManner;
	private String labId;
	private String labTestId;
	private String orderBy;
	private String labCode;
	
	private String weekDay;
	private String speciality;
	private String patCat;
	private String gender;
	private String label;
	private String maleCode;
	private String femaleCode;
	private String othersCode;
	private String operationType;
	private String operationTypeMajor;
	private String operationTypeMinor;
	
	private String religionCode;
	private String genderCode;
	private String fromAge;
	private String toAge;

	//For HosPatStat Report
	private String selectField;
	private String groupField;
	private String epiDate;	
	private String newMaleAdult;
	private String newFemaleAdult;
	private String newOtherAdult;
	private String newMaleChild;
	private String newFemaleChild;
	private String newOtherChild;
	private String oldMaleAdult;
	private String oldFemaleAdult;
	private String oldOtherAdult;
	private String oldMaleChild;
	private String oldFemaleChild;
	private String oldOtherChild;
	
		
	private Integer  n_m_a;
	private Integer  n_f_a;
	private Integer  n_o_a;
	private Integer  n_m_c;
	private Integer  n_f_c;
	private Integer  n_o_c;
	private Integer  o_m_a;
	private Integer  o_f_a;
	private Integer  o_o_a;
	private Integer  o_m_c;
	private Integer  o_f_c;
	private Integer  o_o_c;
	
	private String rownum;
	private String dateLabel;
	
	private String episodeDate;
	private String ageRange;
	private String deptName;
	private String male;
	private String female;
	
	//For HosPatStat State Wise Report
	private String femaleChandigarh;
	private String maleChandigarh;
	private String otherChandigarh;
	private String femalePunjab;
	private String malePunjab;
	private String otherPunjab;
	private String femaleHaryana;
	private String maleHaryana;
	private String otherHaryana;
	private String femaleUp;
	private String maleUp;
	private String otherUp;
	private String femaleHp;
	private String maleHp;
	private String otherHp;
	private String femaleUttrakhand;
	private String maleUttrakhand;
	private String otherUttrakhand;
	private String femaleJk;
	private String maleJk;
	private String otherJk;
	private String femaleOthers;
	private String maleOthers;
	private String otherOthers;
	
	private Integer  f_chandigarh;
	private Integer  m_chandigarh;
	private Integer  o_chandigarh;
	private Integer  f_punjab;
	private Integer  m_punjab;
	private Integer  o_punjab;
	private Integer  f_haryana;
	private Integer  m_haryana;
	private Integer  o_haryana;
	private Integer  m_up;
	private Integer  f_up;
	private Integer  o_up;
	private Integer  m_hp;
	private Integer  f_hp;
	private Integer  o_hp;
	private Integer  m_uttrakhand;
	private Integer  f_uttrakhand;
	private Integer  o_uttrakhand;
	private Integer  m_jk;
	private Integer  f_jk;
	private Integer  o_jk;
	private Integer  f_others;
	private Integer  m_others;
	private Integer  o_others;
	
	//For age wise Reg Report
	
	private Integer female0_13;
	private Integer male0_13;
	private Integer other0_13;
	private Integer female14_25;
	private Integer male14_25;
	private Integer other14_25;
	private Integer female26_35;
	private Integer male26_35;
	private Integer other26_35;
	private Integer female36_45;
	private Integer male36_45;
	private Integer other36_45;
	private Integer female46_55;
	private Integer male46_55;
	private Integer other46_55;
	private Integer female56_65;
	private Integer male56_65;
	private Integer other56_65;
	private Integer male_66;
	private Integer female_66;
	private Integer other_66;
	
	private String  f_0_13;
	private String  m_0_13;
	private String  o_0_13;
	private String  f_14_25;
	private String  m_14_25;
	private String  o_14_25;
	private String  f_26_35;
	private String  m_26_35;
	private String  o_26_35;
	private String  m_36_45;
	private String  f_36_45;
	private String  o_36_45;
	private String  m_46_55;
	private String  f_46_55;
	private String  o_46_55;
	private String  m_56_65;
	private String  f_56_65;
	private String  o_56_65;
	private String  m_66;
	private String  f_66;
	private String  o_66;
	private String patientType;
	
	// disaster wise patient listing report
	private String dynamicQuery;
	private String allHospitalCode;
	//For communicable disease
	
	private String disType;
	private String monyear;
	private String monYear;
	
	private String imageURL;
	private String deptcode;
	
	private String serviceAreaCode="";
	private String strStatus="";
	
	private String fromMonth;
	private String toMonth;
	private String fromYear;
	private String toYear;
	private String strSeatId;
	private String deptWs;

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getMonyear() {
		return monyear;
	}

	public void setMonyear(String monyear) {
		this.monyear = monyear;
	}

	public String getMonYear() {
		return monYear;
	}

	public void setMonYear(String monYear) {
		this.monYear = monYear;
	}

	public String getAllHospitalCode() {
		return allHospitalCode;
	}

	public void setAllHospitalCode(String allHospitalCode) {
		this.allHospitalCode = allHospitalCode;
	}

	public String getReligionCode() {
		return religionCode;
	}

	public void setReligionCode(String religionCode) {
		this.religionCode = religionCode;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getFromAge() {
		return fromAge;
	}

	public void setFromAge(String fromAge) {
		this.fromAge = fromAge;
	}

	public String getToAge() {
		return toAge;
	}

	public void setToAge(String toAge) {
		this.toAge = toAge;
	}

	
	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}


	private String disasterId;
	
	//disaster Patient Static year wise
	
	private String year;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDisasterId() {
		return disasterId;
	}

	public void setDisasterId(String disasterId) {
		this.disasterId = disasterId;
	}


	public Integer getFemale0_13() {
		return female0_13;
	}

	public void setFemale0_13(Integer female0_13) {
		this.female0_13 = female0_13;
	}

	public Integer getMale0_13() {
		return male0_13;
	}

	public void setMale0_13(Integer male0_13) {
		this.male0_13 = male0_13;
	}

	public Integer getFemale14_25() {
		return female14_25;
	}

	public void setFemale14_25(Integer female14_25) {
		this.female14_25 = female14_25;
	}

	public Integer getMale14_25() {
		return male14_25;
	}

	public void setMale14_25(Integer male14_25) {
		this.male14_25 = male14_25;
	}

	public Integer getFemale26_35() {
		return female26_35;
	}

	public void setFemale26_35(Integer female26_35) {
		this.female26_35 = female26_35;
	}

	public Integer getMale26_35() {
		return male26_35;
	}

	public void setMale26_35(Integer male26_35) {
		this.male26_35 = male26_35;
	}

	public Integer getFemale36_45() {
		return female36_45;
	}

	public void setFemale36_45(Integer female36_45) {
		this.female36_45 = female36_45;
	}

	public Integer getMale36_45() {
		return male36_45;
	}

	public void setMale36_45(Integer male36_45) {
		this.male36_45 = male36_45;
	}

	public Integer getFemale46_55() {
		return female46_55;
	}

	public void setFemale46_55(Integer female46_55) {
		this.female46_55 = female46_55;
	}

	public Integer getMale46_55() {
		return male46_55;
	}

	public void setMale46_55(Integer male46_55) {
		this.male46_55 = male46_55;
	}

	public Integer getFemale56_65() {
		return female56_65;
	}

	public void setFemale56_65(Integer female56_65) {
		this.female56_65 = female56_65;
	}

	public Integer getMale56_65() {
		return male56_65;
	}

	public void setMale56_65(Integer male56_65) {
		this.male56_65 = male56_65;
	}

	public String getF_0_13() {
		return f_0_13;
	}

	public void setF_0_13(String f_0_13) {
		this.f_0_13 = f_0_13;
	}


	public String getM_0_13() {
		return m_0_13;
	}

	public void setM_0_13(String m_0_13) {
		this.m_0_13 = m_0_13;
	}

	public String getF_14_25() {
		return f_14_25;
	}

	public void setF_14_25(String f_14_25) {
		this.f_14_25 = f_14_25;
	}

	public String getM_14_25() {
		return m_14_25;
	}

	public void setM_14_25(String m_14_25) {
		this.m_14_25 = m_14_25;
	}

	public String getF_26_35() {
		return f_26_35;
	}

	public void setF_26_35(String f_26_35) {
		this.f_26_35 = f_26_35;
	}

	public String getM_26_35() {
		return m_26_35;
	}

	public void setM_26_35(String m_26_35) {
		this.m_26_35 = m_26_35;
	}

	public String getM_36_45() {
		return m_36_45;
	}

	public void setM_36_45(String m_36_45) {
		this.m_36_45 = m_36_45;
	}

	public String getF_36_45() {
		return f_36_45;
	}

	public void setF_36_45(String f_36_45) {
		this.f_36_45 = f_36_45;
	}

	public String getM_46_55() {
		return m_46_55;
	}

	public void setM_46_55(String m_46_55) {
		this.m_46_55 = m_46_55;
	}

	public String getF_46_55() {
		return f_46_55;
	}

	public void setF_46_55(String f_46_55) {
		this.f_46_55 = f_46_55;
	}

	public String getM_56_65() {
		return m_56_65;
	}

	public void setM_56_65(String m_56_65) {
		this.m_56_65 = m_56_65;
	}

	public String getF_56_65() {
		return f_56_65;
	}

	public void setF_56_65(String f_56_65) {
		this.f_56_65 = f_56_65;
	}

	public String getM_66() {
		return m_66;
	}

	public void setM_66(String m_66) {
		this.m_66 = m_66;
	}

	public String getF_66() {
		return f_66;
	}

	public void setF_66(String f_66) {
		this.f_66 = f_66;
	}

	public String getDateLabel() {
		return dateLabel;
	}

	public void setDateLabel(String dateLabel) {
		this.dateLabel = dateLabel;
	}

	public String getRownum() {
		return rownum;
	}

	public void setRownum(String rownum) {
		this.rownum = rownum;
	}

	public String getSelectField() {
		return selectField;
	}

	public void setSelectField(String selectField) {
		this.selectField = selectField;
	}

	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}

	
	public String getEpiDate() {
		return epiDate;
	}

	public void setEpiDate(String epiDate) {
		this.epiDate = epiDate;
	}

	
	public String getNewMaleChild() {
		return newMaleChild;
	}

	public void setNewMaleChild(String newMaleChild) {
		this.newMaleChild = newMaleChild;
	}

	public String getOldMaleChild() {
		return oldMaleChild;
	}

	public void setOldMaleChild(String oldMaleChild) {
		this.oldMaleChild = oldMaleChild;
	}

	public String getNewMaleAdult() {
		return newMaleAdult;
	}

	public void setNewMaleAdult(String newMaleAdult) {
		this.newMaleAdult = newMaleAdult;
	}

	public String getOldMaleAdult() {
		return oldMaleAdult;
	}

	public void setOldMaleAdult(String oldMaleAdult) {
		this.oldMaleAdult = oldMaleAdult;
	}

	public String getNewFemaleChild() {
		return newFemaleChild;
	}

	public void setNewFemaleChild(String newFemaleChild) {
		this.newFemaleChild = newFemaleChild;
	}

	public String getOldFemaleChild() {
		return oldFemaleChild;
	}

	public void setOldFemaleChild(String oldFemaleChild) {
		this.oldFemaleChild = oldFemaleChild;
	}

	public String getNewFemaleAdult() {
		return newFemaleAdult;
	}

	public void setNewFemaleAdult(String newFemaleAdult) {
		this.newFemaleAdult = newFemaleAdult;
	}

	public String getOldFemaleAdult() {
		return oldFemaleAdult;
	}

	public void setOldFemaleAdult(String oldFemaleAdult) {
		this.oldFemaleAdult = oldFemaleAdult;
	}

	public Integer getN_m_c() {
		return n_m_c;
	}

	public void setN_m_c(Integer n_m_c) {
		this.n_m_c = n_m_c;
	}

	public Integer getO_m_c() {
		return o_m_c;
	}

	public void setO_m_c(Integer o_m_c) {
		this.o_m_c = o_m_c;
	}

	public Integer getN_m_a() {
		return n_m_a;
	}

	public void setN_m_a(Integer n_m_a) {
		this.n_m_a = n_m_a;
	}

	public Integer getO_m_a() {
		return o_m_a;
	}

	public void setO_m_a(Integer o_m_a) {
		this.o_m_a = o_m_a;
	}

	public Integer getN_f_c() {
		return n_f_c;
	}

	public void setN_f_c(Integer n_f_c) {
		this.n_f_c = n_f_c;
	}

	public Integer getO_f_c() {
		return o_f_c;
	}

	public void setO_f_c(Integer o_f_c) {
		this.o_f_c = o_f_c;
	}

	public Integer getN_f_a() {
		return n_f_a;
	}

	public void setN_f_a(Integer n_f_a) {
		this.n_f_a = n_f_a;
	}

	public Integer getO_f_a() {
		return o_f_a;
	}

	public void setO_f_a(Integer o_f_a) {
		this.o_f_a = o_f_a;
	}

	public String getMaleCode() {
		return maleCode;
	}

	public void setMaleCode(String maleCode) {
		this.maleCode = maleCode;
	}

	public String getFemaleCode() {
		return femaleCode;
	}

	public void setFemaleCode(String femaleCode) {
		this.femaleCode = femaleCode;
	}

	public String getOthersCode() {
		return othersCode;
	}

	public void setOthersCode(String othersCode) {
		this.othersCode = othersCode;
	}

	public String getPatCat() {
		return patCat;
	}

	public void setPatCat(String patCat) {
		this.patCat = patCat;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getLabId() {
		return labId;
	}

	public void setLabId(String labId) {
		this.labId = labId;
	}

	public String getLabTestId() {
		return labTestId;
	}

	public void setLabTestId(String labTestId) {
		this.labTestId = labTestId;
	}

	public String getDeathManner() {
		return deathManner;
	}

	public void setDeathManner(String deathManner) {
		this.deathManner = deathManner;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStrQueueNo() {
		return strQueueNo;
	}

	public void setStrQueueNo(String strQueueNo) {
		this.strQueueNo = strQueueNo;
	}

	public String getStrDeptName() {
		return strDeptName;
	}

	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}

	public String getStrUnitName() {
		return strUnitName;
	}

	public void setStrUnitName(String strUnitName) {
		this.strUnitName = strUnitName;
	}

	public String getStrRoomName() {
		return strRoomName;
	}

	public void setStrRoomName(String strRoomName) {
		this.strRoomName = strRoomName;
	}

	public String getWardCode() {
		return wardCode;
	}

	public void setWardCode(String wardCode) {
		this.wardCode = wardCode;
	}

	public String getCrNo() {
		return crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public String getAdmnNo() {
		return admnNo;
	}

	public void setAdmnNo(String admnNo) {
		this.admnNo = admnNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getMlcNo()
	{
		return mlcNo;
	}

	public void setMlcNo(String mlcNo)
	{
		this.mlcNo = mlcNo;
	}

	public String getPatCrNo()
	{
		return patCrNo;
	}

	public void setPatCrNo(String patCrNo)
	{
		this.patCrNo = patCrNo;
	}

	public String getPoorFree()
	{
		return poorFree;
	}

	public void setPoorFree(String poorFree)
	{
		this.poorFree = poorFree;
	}

	public String getHospitalCode()
	{
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode)
	{
		this.hospitalCode = hospitalCode;
	}

	public String getDoctorCode()
	{
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode)
	{
		this.doctorCode = doctorCode;
	}

	public String getEpisodeStatus()
	{
		return episodeStatus;
	}

	public void setEpisodeStatus(String episodeStatus)
	{
		this.episodeStatus = episodeStatus;
	}

	public String getUserCode()
	{
		return userCode;
	}

	public void setUserCode(String userCode)
	{
		this.userCode = userCode;
	}

	public String getJrxmlPath()
	{
		return jrxmlPath;
	}

	public void setJrxmlPath(String jrxmlPath)
	{
		this.jrxmlPath = jrxmlPath;
	}

	public String getPatListing()
	{
		return patListing;
	}

	public void setPatListing(String patListing)
	{
		this.patListing = patListing;
	}

	public String getRoomCode()
	{
		return roomCode;
	}

	public void setRoomCode(String roomCode)
	{
		this.roomCode = roomCode;
	}

	public String getPatRegCatCode()
	{
		return patRegCatCode;
	}

	public void setPatRegCatCode(String patRegCatCode)
	{
		this.patRegCatCode = patRegCatCode;
	}

	public String getDepartmentCode()
	{
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode)
	{
		this.departmentCode = departmentCode;
	}

	public String getPatGenderCode()
	{
		return patGenderCode;
	}

	public void setPatGenderCode(String patGenderCode)
	{
		this.patGenderCode = patGenderCode;
	}

	public String getPatPrimaryCatCode()
	{
		return patPrimaryCatCode;
	}

	public void setPatPrimaryCatCode(String patPrimaryCatCode)
	{
		this.patPrimaryCatCode = patPrimaryCatCode;
	}

	public String getPatSecondaryCatCode()
	{
		return patSecondaryCatCode;
	}

	public void setPatSecondaryCatCode(String patSecondaryCatCode)
	{
		this.patSecondaryCatCode = patSecondaryCatCode;
	}

	public String getChoice()
	{
		return choice;
	}

	public String getMode()
	{
		return mode;
	}

	public void setMode(String mode)
	{
		this.mode = mode;
	}

	public String getReportMode()
	{
		return reportMode;
	}

	public void setReportMode(String reportMode)
	{
		this.reportMode = reportMode;
	}

	public String getReportType()
	{
		return reportType;
	}

	public void setReportType(String reportType)
	{
		this.reportType = reportType;
	}

	public void setChoice(String choice)
	{
		this.choice = choice;
	}

	public String getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	public String getFromHour()
	{
		return fromHour;
	}

	public void setFromHour(String fromHour)
	{
		this.fromHour = fromHour;
	}

	public String getFromMin()
	{
		return fromMin;
	}

	public void setFromMin(String fromMin)
	{
		this.fromMin = fromMin;
	}

	public String getToDate()
	{
		return toDate;
	}

	public void setToDate(String toDate)
	{
		this.toDate = toDate;
	}

	public String getToHour()
	{
		return toHour;
	}

	public void setToHour(String toHour)
	{
		this.toHour = toHour;
	}

	public String getToMin()
	{
		return toMin;
	}

	public void setToMin(String toMin)
	{
		this.toMin = toMin;
	}

	public String getJrxmlName()
	{
		return jrxmlName;
	}

	public void setJrxmlName(String jrxmlName)
	{
		this.jrxmlName = jrxmlName;
	}

	public String getChartType()
	{
		return chartType;
	}

	public void setChartType(String chartType)
	{
		this.chartType = chartType;
	}

	public String getHospitalAdd()
	{
		return hospitalAdd;
	}

	public void setHospitalAdd(String hospitalAdd)
	{
		this.hospitalAdd = hospitalAdd;
	}

	public String getHospitalContact()
	{
		return hospitalContact;
	}

	public void setHospitalContact(String hospitalContact)
	{
		this.hospitalContact = hospitalContact;
	}

	public String getHospitalId()
	{
		return hospitalId;
	}

	public void setHospitalId(String hospitalId)
	{
		this.hospitalId = hospitalId;
	}

	public String getHospitalName()
	{
		return hospitalName;
	}

	public void setHospitalName(String hospitalName)
	{
		this.hospitalName = hospitalName;
	}

	public String getPatGender()
	{
		return patGender;
	}

	public void setPatGender(String patGender)
	{
		this.patGender = "1";
	}

	public String getEmergencyType()
	{
		return emergencyType;
	}

	public void setEmergencyType(String emergencyType)
	{
		this.emergencyType = emergencyType;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public String getFromDepartment()
	{
		return fromDepartment;
	}

	public void setFromDepartment(String fromDepartment)
	{
		this.fromDepartment = fromDepartment;
	}

	public String getToDepartment()
	{
		return toDepartment;
	}

	public void setToDepartment(String toDepartment)
	{
		this.toDepartment = toDepartment;
	}


	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCmoCode() {
		return cmoCode;
	}

	public void setCmoCode(String cmoCode) {
		this.cmoCode = cmoCode;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}


	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEntryModeLabel() {
		return entryModeLabel;
	}

	public void setEntryModeLabel(String entryModeLabel) {
		this.entryModeLabel = entryModeLabel;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationTypeMajor() {
		return operationTypeMajor;
	}

	public void setOperationTypeMajor(String operationTypeMajor) {
		this.operationTypeMajor = operationTypeMajor;
	}

	public String getOperationTypeMinor() {
		return operationTypeMinor;
	}

	public void setOperationTypeMinor(String operationTypeMinor) {
		this.operationTypeMinor = operationTypeMinor;
	}


	public String getFemaleChandigarh() {
		return femaleChandigarh;
	}

	public void setFemaleChandigarh(String femaleChandigarh) {
		this.femaleChandigarh = femaleChandigarh;
	}

	public String getMaleChandigarh() {
		return maleChandigarh;
	}

	public void setMaleChandigarh(String maleChandigarh) {
		this.maleChandigarh = maleChandigarh;
	}

	public String getFemalePunjab() {
		return femalePunjab;
	}

	public void setFemalePunjab(String femalePunjab) {
		this.femalePunjab = femalePunjab;
	}

	public String getMalePunjab() {
		return malePunjab;
	}

	public void setMalePunjab(String malePunjab) {
		this.malePunjab = malePunjab;
	}

	public String getFemaleHaryana() {
		return femaleHaryana;
	}

	public void setFemaleHaryana(String femaleHaryana) {
		this.femaleHaryana = femaleHaryana;
	}

	public String getMaleHaryana() {
		return maleHaryana;
	}

	public void setMaleHaryana(String maleHaryana) {
		this.maleHaryana = maleHaryana;
	}

	public String getFemaleUp() {
		return femaleUp;
	}

	public void setFemaleUp(String femaleUp) {
		this.femaleUp = femaleUp;
	}

	public String getMaleUp() {
		return maleUp;
	}

	public void setMaleUp(String maleUp) {
		this.maleUp = maleUp;
	}

	public String getFemaleHp() {
		return femaleHp;
	}

	public void setFemaleHp(String femaleHp) {
		this.femaleHp = femaleHp;
	}

	public String getMaleHp() {
		return maleHp;
	}

	public void setMaleHp(String maleHp) {
		this.maleHp = maleHp;
	}

	public String getFemaleUttrakhand() {
		return femaleUttrakhand;
	}

	public void setFemaleUttrakhand(String femaleUttrakhand) {
		this.femaleUttrakhand = femaleUttrakhand;
	}

	public String getMaleUttrakhand() {
		return maleUttrakhand;
	}

	public void setMaleUttrakhand(String maleUttrakhand) {
		this.maleUttrakhand = maleUttrakhand;
	}

	public String getFemaleJk() {
		return femaleJk;
	}

	public void setFemaleJk(String femaleJk) {
		this.femaleJk = femaleJk;
	}

	public String getFemaleOthers() {
		return femaleOthers;
	}

	public void setFemaleOthers(String femaleOthers) {
		this.femaleOthers = femaleOthers;
	}

	public String getMaleOthers() {
		return maleOthers;
	}

	public void setMaleOthers(String maleOthers) {
		this.maleOthers = maleOthers;
	}

	public Integer getF_chandigarh() {
		return f_chandigarh;
	}

	public void setF_chandigarh(Integer f_chandigarh) {
		this.f_chandigarh = f_chandigarh;
	}

	public Integer getM_chandigarh() {
		return m_chandigarh;
	}

	public void setM_chandigarh(Integer m_chandigarh) {
		this.m_chandigarh = m_chandigarh;
	}

	public Integer getF_punjab() {
		return f_punjab;
	}

	public void setF_punjab(Integer f_punjab) {
		this.f_punjab = f_punjab;
	}

	public Integer getM_punjab() {
		return m_punjab;
	}

	public void setM_punjab(Integer m_punjab) {
		this.m_punjab = m_punjab;
	}

	public Integer getF_haryana() {
		return f_haryana;
	}

	public void setF_haryana(Integer f_haryana) {
		this.f_haryana = f_haryana;
	}

	public Integer getM_haryana() {
		return m_haryana;
	}

	public void setM_haryana(Integer m_haryana) {
		this.m_haryana = m_haryana;
	}

	public Integer getM_up() {
		return m_up;
	}

	public void setM_up(Integer m_up) {
		this.m_up = m_up;
	}

	public Integer getF_up() {
		return f_up;
	}

	public void setF_up(Integer f_up) {
		this.f_up = f_up;
	}

	public Integer getM_hp() {
		return m_hp;
	}

	public void setM_hp(Integer m_hp) {
		this.m_hp = m_hp;
	}

	public Integer getF_hp() {
		return f_hp;
	}

	public void setF_hp(Integer f_hp) {
		this.f_hp = f_hp;
	}

	public Integer getM_uttrakhand() {
		return m_uttrakhand;
	}

	public void setM_uttrakhand(Integer m_uttrakhand) {
		this.m_uttrakhand = m_uttrakhand;
	}

	public Integer getF_uttrakhand() {
		return f_uttrakhand;
	}

	public void setF_uttrakhand(Integer f_uttrakhand) {
		this.f_uttrakhand = f_uttrakhand;
	}

	public Integer getM_jk() {
		return m_jk;
	}

	public void setM_jk(Integer m_jk) {
		this.m_jk = m_jk;
	}

	public Integer getF_jk() {
		return f_jk;
	}

	public void setF_jk(Integer f_jk) {
		this.f_jk = f_jk;
	}

	public Integer getF_others() {
		return f_others;
	}

	public void setF_others(Integer f_others) {
		this.f_others = f_others;
	}

	public Integer getM_others() {
		return m_others;
	}

	public void setM_others(Integer m_others) {
		this.m_others = m_others;
	}


	public String getEpisodeDate() {
		return episodeDate;
	}

	public void setEpisodeDate(String episodeDate) {
		this.episodeDate = episodeDate;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public Integer getMale_66() {
		return male_66;
	}

	public void setMale_66(Integer male_66) {
		this.male_66 = male_66;
	}

	public Integer getFemale_66() {
		return female_66;
	}

	public void setFemale_66(Integer female_66) {
		this.female_66 = female_66;
	}

	public String getMaleJk() {
		return maleJk;
	}

	public void setMaleJk(String maleJk) {
		this.maleJk = maleJk;
	}


	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}


	public String getOtherChandigarh() {
		return otherChandigarh;
	}

	public void setOtherChandigarh(String otherChandigarh) {
		this.otherChandigarh = otherChandigarh;
	}

	public String getOtherPunjab() {
		return otherPunjab;
	}

	public void setOtherPunjab(String otherPunjab) {
		this.otherPunjab = otherPunjab;
	}

	public String getOtherHaryana() {
		return otherHaryana;
	}

	public void setOtherHaryana(String otherHaryana) {
		this.otherHaryana = otherHaryana;
	}

	public String getOtherUp() {
		return otherUp;
	}

	public void setOtherUp(String otherUp) {
		this.otherUp = otherUp;
	}

	public String getOtherHp() {
		return otherHp;
	}

	public void setOtherHp(String otherHp) {
		this.otherHp = otherHp;
	}

	public String getOtherUttrakhand() {
		return otherUttrakhand;
	}

	public void setOtherUttrakhand(String otherUttrakhand) {
		this.otherUttrakhand = otherUttrakhand;
	}

	public String getOtherJk() {
		return otherJk;
	}

	public void setOtherJk(String otherJk) {
		this.otherJk = otherJk;
	}

	public String getOtherOthers() {
		return otherOthers;
	}

	public void setOtherOthers(String otherOthers) {
		this.otherOthers = otherOthers;
	}

	public Integer getO_chandigarh() {
		return o_chandigarh;
	}

	public void setO_chandigarh(Integer o_chandigarh) {
		this.o_chandigarh = o_chandigarh;
	}

	public Integer getO_punjab() {
		return o_punjab;
	}

	public void setO_punjab(Integer o_punjab) {
		this.o_punjab = o_punjab;
	}

	public Integer getO_haryana() {
		return o_haryana;
	}

	public void setO_haryana(Integer o_haryana) {
		this.o_haryana = o_haryana;
	}

	public Integer getO_up() {
		return o_up;
	}

	public void setO_up(Integer o_up) {
		this.o_up = o_up;
	}

	public Integer getO_hp() {
		return o_hp;
	}

	public void setO_hp(Integer o_hp) {
		this.o_hp = o_hp;
	}

	public Integer getO_uttrakhand() {
		return o_uttrakhand;
	}

	public void setO_uttrakhand(Integer o_uttrakhand) {
		this.o_uttrakhand = o_uttrakhand;
	}

	public Integer getO_jk() {
		return o_jk;
	}

	public void setO_jk(Integer o_jk) {
		this.o_jk = o_jk;
	}

	public Integer getO_others() {
		return o_others;
	}

	public void setO_others(Integer o_others) {
		this.o_others = o_others;
	}

	public Integer getOther0_13() {
		return other0_13;
	}

	public void setOther0_13(Integer other0_13) {
		this.other0_13 = other0_13;
	}

	public Integer getOther14_25() {
		return other14_25;
	}

	public void setOther14_25(Integer other14_25) {
		this.other14_25 = other14_25;
	}

	public Integer getOther26_35() {
		return other26_35;
	}

	public void setOther26_35(Integer other26_35) {
		this.other26_35 = other26_35;
	}

	public Integer getOther36_45() {
		return other36_45;
	}

	public void setOther36_45(Integer other36_45) {
		this.other36_45 = other36_45;
	}

	public Integer getOther46_55() {
		return other46_55;
	}

	public void setOther46_55(Integer other46_55) {
		this.other46_55 = other46_55;
	}

	public Integer getOther56_65() {
		return other56_65;
	}

	public void setOther56_65(Integer other56_65) {
		this.other56_65 = other56_65;
	}

	public Integer getOther_66() {
		return other_66;
	}

	public void setOther_66(Integer other_66) {
		this.other_66 = other_66;
	}

	public String getO_0_13() {
		return o_0_13;
	}

	public void setO_0_13(String o_0_13) {
		this.o_0_13 = o_0_13;
	}

	public String getO_14_25() {
		return o_14_25;
	}

	public void setO_14_25(String o_14_25) {
		this.o_14_25 = o_14_25;
	}

	public String getO_26_35() {
		return o_26_35;
	}

	public void setO_26_35(String o_26_35) {
		this.o_26_35 = o_26_35;
	}

	public String getO_36_45() {
		return o_36_45;
	}

	public void setO_36_45(String o_36_45) {
		this.o_36_45 = o_36_45;
	}

	public String getO_46_55() {
		return o_46_55;
	}

	public void setO_46_55(String o_46_55) {
		this.o_46_55 = o_46_55;
	}

	public String getO_56_65() {
		return o_56_65;
	}

	public void setO_56_65(String o_56_65) {
		this.o_56_65 = o_56_65;
	}

	public String getO_66() {
		return o_66;
	}

	public void setO_66(String o_66) {
		this.o_66 = o_66;
	}

	public String getNewOtherAdult() {
		return newOtherAdult;
	}

	public void setNewOtherAdult(String newOtherAdult) {
		this.newOtherAdult = newOtherAdult;
	}

	public String getNewOtherChild() {
		return newOtherChild;
	}

	public void setNewOtherChild(String newOtherChild) {
		this.newOtherChild = newOtherChild;
	}

	public String getOldOtherAdult() {
		return oldOtherAdult;
	}

	public void setOldOtherAdult(String oldOtherAdult) {
		this.oldOtherAdult = oldOtherAdult;
	}

	public String getOldOtherChild() {
		return oldOtherChild;
	}

	public void setOldOtherChild(String oldOtherChild) {
		this.oldOtherChild = oldOtherChild;
	}

	public Integer getN_o_a() {
		return n_o_a;
	}

	public void setN_o_a(Integer n_o_a) {
		this.n_o_a = n_o_a;
	}

	public Integer getN_o_c() {
		return n_o_c;
	}

	public void setN_o_c(Integer n_o_c) {
		this.n_o_c = n_o_c;
	}

	public Integer getO_o_a() {
		return o_o_a;
	}

	public void setO_o_a(Integer o_o_a) {
		this.o_o_a = o_o_a;
	}

	public Integer getO_o_c() {
		return o_o_c;
	}

	public void setO_o_c(Integer o_o_c) {
		this.o_o_c = o_o_c;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getDynamicQuery() {
		return dynamicQuery;
	}

	public void setDynamicQuery(String dynamicQuery) {
		this.dynamicQuery = dynamicQuery;
	}

	public String getSpecimenName() {
		return specimenName;
	}

	public void setSpecimenName(String specimenName) {
		this.specimenName = specimenName;
	}

	public String getSpecimenCode() {
		return specimenCode;
	}

	public void setSpecimenCode(String specimenCode) {
		this.specimenCode = specimenCode;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getStaffList() {
		return staffList;
	}

	public void setStaffList(String staffList) {
		this.staffList = staffList;
	}

	public String getSlideValue() {
		return slideValue;
	}

	public void setSlideValue(String slideValue) {
		this.slideValue = slideValue;
	}

	public String getServiceAreaCode() {
		return serviceAreaCode;
	}

	public void setServiceAreaCode(String serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public String getFromMonth() {
		return fromMonth;
	}

	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	public String getToMonth() {
		return toMonth;
	}

	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	public String getStrSeatId() {
		return strSeatId;
	}

	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public String getDeptWs() {
		return deptWs;
	}

	public void setDeptWs(String deptWs) {
		this.deptWs = deptWs;
	}



   
}
