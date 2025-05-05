package hisglobal.vo;



/**
 * DonorDtlVO is the class that specifies getters and setters for all the identifiers
 * which are used for retrieving and inserting data in the DonorDtl table. 
 * @author AHIS
 */

public class DonorDtlVO extends ValueObject
{
	private DonorAddDtlVO donorAddDtlVO=new DonorAddDtlVO();
	private String donorRegistrationNo;
	private String donorPreviousRegistrationNo;
	private String registrationDate;
	private String donorFirstName;
	private String donorMiddleName;
	private String donorLastName;
	private String donorGenderCode;
	private String donorDob;
	private String donorGender;
	private String donorAge;
	private String donorAgeUnit;
	private String donorMaritalStatusCode;
	private String isActualDob;
	private String bloodGroupCode;
	private String donorIdMark1;
	private String donorFatherName;
	private String donorIdMark2;
	private String donorSpouseName;
	private String donorOccupationCode;
	private String donorNationality;
	private String donorMobileNo;
	private String donorEmailId; 
	private String isImageUploded;
	private String donorCasteId;
	private String isValid;
	private String seatId;
	private String entryDate;
	private String lastModifiedDate;
	private String lastModifiedSeatId;
	private String donorStatus;
	private String voluntary;
	private String emergencyCall;
	private String hospitalCode;
	private String officeCollege;
	private String employeeStudentCode;
	private String designationClass;
	private String yearlyFrquency;
	private String specificDay;
	private String isCamp;

	private String donorTypeCode;
	private String donorTypeDesc;
	private String donorVisitDate;
	private String donorVisitNo;
	private String donorOccupationName;
	private String lastDonationDate;
	private String donationStatus;

	private String donorReligionCode;
	private String donorMonthlyIncome;

	private String physicalRoomQueueNo;
	private String donorMaritalStatus;
	private String patientName;
	private String wardName;
	private String bedNo;
	private String bloodBagNo;
	private String isCardPrint;
	private String isCardPrintCode;
	private String donationTypeCode;
	private String donationTypeDesc;
	
	//For Schedule letter printing process
	
	private String scheduleMsg;
	private String printStatus;
	private String scheduleDate;
	private String bloodGroup;
	private String isSchedulePrint;
	private String isSchedulePrintCode;
	private String SortType;
	private String month;
	private String registrationNo[];
	private String slNo;

	private String guardianLabel;
	private String guardianName;
	private String templateId;
	

	

	// for investigation report
	private String investigationStatus;
	
	public String getSlNo()
	{
		return slNo;
	}
	public void setSlNo(String slNo)
	{
		this.slNo = slNo;
	}
	public String getMonth()
	{
		return month;
	}
	public void setMonth(String month)
	{
		this.month = month;
	}
	public String getSortType()
	{
		return SortType;
	}
	public void setSortType(String sortType)
	{
		SortType = sortType;
	}
	public String getIsSchedulePrint()
	{
		return isSchedulePrint;
	}
	public void setIsSchedulePrint(String isSchedulePrint)
	{
		this.isSchedulePrint = isSchedulePrint;
	}
	public String getIsSchedulePrintCode()
	{
		return isSchedulePrintCode;
	}
	public void setIsSchedulePrintCode(String isSchedulePrintCode)
	{
		this.isSchedulePrintCode = isSchedulePrintCode;
	}
	public String getScheduleDate()
	{
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate)
	{
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleMsg()
	{
		return scheduleMsg;
	}
	public void setScheduleMsg(String scheduleMsg)
	{
		this.scheduleMsg = scheduleMsg;
	}
	public String getPrintStatus()
	{
		return printStatus;
	}
	public void setPrintStatus(String printStatus)
	{
		this.printStatus = printStatus;
	}
	public String getDonorReligionCode()
	{
		return donorReligionCode;
	}
	public void setDonorReligionCode(String donorReligionCode)
	{
		this.donorReligionCode = donorReligionCode;
	}

	public String getDonorMonthlyIncome()
	{
		return donorMonthlyIncome;
	}
	public void setDonorMonthlyIncome(String donorMonthlyIncome)
	{
		this.donorMonthlyIncome = donorMonthlyIncome;
	}

	public String getPhysicalRoomQueueNo()
	{
		return physicalRoomQueueNo;
	}
	public void setPhysicalRoomQueueNo(String physicalRoomQueueNo)
	{
		this.physicalRoomQueueNo = physicalRoomQueueNo;
	}

	public String getLastDonationDate()
	{
		return lastDonationDate;
	}
	public void setLastDonationDate(String lastDonationDate)
	{
		this.lastDonationDate = lastDonationDate;
	}
	public String getDonorOccupationName()
	{
		return donorOccupationName;
	}
	public void setDonorOccupationName(String donorOccupationName)
	{
		this.donorOccupationName = donorOccupationName;
	}
	public String getDonorVisitNo()
	{
		return donorVisitNo;
	}
	public void setDonorVisitNo(String donorVisitNo)
	{
		this.donorVisitNo = donorVisitNo;
	}
	public String getDonorGender()
	{
		return donorGender;
	}
	public void setDonorGender(String donorGender)
	{
		this.donorGender = donorGender;
	}
	public String getDonorAge()
	{
		return donorAge;
	}
	public void setDonorAge(String donorAge)
	{
		this.donorAge = donorAge;
	}
	public String getDonorTypeCode()
	{
		return donorTypeCode;
	}
	public void setDonorTypeCode(String donorTypeCode)
	{
		this.donorTypeCode = donorTypeCode;
	}
	public String getDonorTypeDesc()
	{
		return donorTypeDesc;
	}
	public void setDonorTypeDesc(String donorTypeDesc)
	{
		this.donorTypeDesc = donorTypeDesc;
	}
	public String getDonorVisitDate()
	{
		return donorVisitDate;
	}
	public void setDonorVisitDate(String donorVisitDate)
	{
		this.donorVisitDate = donorVisitDate;
	}

	public String getDonorRegistrationNo()
	{
		return donorRegistrationNo;
	}
	public void setDonorRegistrationNo(String donorRegistrationNo)
	{
		this.donorRegistrationNo = donorRegistrationNo;
	}
	public String getDonorPreviousRegistrationNo()
	{
		return donorPreviousRegistrationNo;
	}
	public void setDonorPreviousRegistrationNo(String donorPreviousRegistrationNo)
	{
		this.donorPreviousRegistrationNo = donorPreviousRegistrationNo;
	}
	public String getRegistrationDate()
	{
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate)
	{
		this.registrationDate = registrationDate;
	}
	public String getDonorFirstName()
	{
		return donorFirstName;
	}
	public void setDonorFirstName(String donorFirstName)
	{
		this.donorFirstName = donorFirstName;
	}
	public String getDonorMiddleName()
	{
		return donorMiddleName;
	}
	public void setDonorMiddleName(String donorMiddleName)
	{
		this.donorMiddleName = donorMiddleName;
	}
	public String getDonorLastName()
	{
		return donorLastName;
	}
	public void setDonorLastName(String donorLastName)
	{
		this.donorLastName = donorLastName;
	}
	public String getDonorGenderCode()
	{
		return donorGenderCode;
	}
	public void setDonorGenderCode(String donorGenderCode)
	{
		this.donorGenderCode = donorGenderCode;
	}
	public String getDonorMaritalStatusCode()
	{
		return donorMaritalStatusCode;
	}
	public void setDonorMaritalStatusCode(String donorMaritalStatusCode)
	{
		this.donorMaritalStatusCode = donorMaritalStatusCode;
	}
	public String getBloodGroupCode()
	{
		return bloodGroupCode;
	}
	public void setBloodGroupCode(String bloodGroupCode)
	{
		this.bloodGroupCode = bloodGroupCode;
	}
	public String getDonorIdMark1()
	{
		return donorIdMark1;
	}
	public void setDonorIdMark1(String donorIdMark1)
	{
		this.donorIdMark1 = donorIdMark1;
	}
	public String getDonorFatherName()
	{
		return donorFatherName;
	}
	public void setDonorFatherName(String donorFatherName)
	{
		this.donorFatherName = donorFatherName;
	}
	public String getDonorIdMark2()
	{
		return donorIdMark2;
	}
	public void setDonorIdMark2(String donorIdMark2)
	{
		this.donorIdMark2 = donorIdMark2;
	}
	public String getDonorSpouseName()
	{
		return donorSpouseName;
	}
	public void setDonorSpouseName(String donorSpouseName)
	{
		this.donorSpouseName = donorSpouseName;
	}
	public String getDonorOccupationCode()
	{
		return donorOccupationCode;
	}
	public void setDonorOccupationCode(String donorOccupationCode)
	{
		this.donorOccupationCode = donorOccupationCode;
	}
	public String getDonorNationality()
	{
		return donorNationality;
	}
	public void setDonorNationality(String donorNationality)
	{
		this.donorNationality = donorNationality;
	}
	public String getDonorMobileNo()
	{
		return donorMobileNo;
	}
	public void setDonorMobileNo(String donorMobileNo)
	{
		this.donorMobileNo = donorMobileNo;
	}
	public String getDonorEmailId()
	{
		return donorEmailId;
	}
	public void setDonorEmailId(String donorEmailId)
	{
		this.donorEmailId = donorEmailId;
	}
	public String getIsImageUploded()
	{
		return isImageUploded;
	}
	public void setIsImageUploded(String isImageUploded)
	{
		this.isImageUploded = isImageUploded;
	}
	public String getDonorCasteId()
	{
		return donorCasteId;
	}
	public void setDonorCasteId(String donorCasteId)
	{
		this.donorCasteId = donorCasteId;
	}
	public String getIsValid()
	{
		return isValid;
	}
	public void setIsValid(String isValid)
	{
		this.isValid = isValid;
	}
	public String getSeatId()
	{
		return seatId;
	}
	public void setSeatId(String seatId)
	{
		this.seatId = seatId;
	}
	public String getEntryDate()
	{
		return entryDate;
	}
	public void setEntryDate(String entryDate)
	{
		this.entryDate = entryDate;
	}
	public String getLastModifiedDate()
	{
		return lastModifiedDate;
	}
	public void setLastModifiedDate(String lastModifiedDate)
	{
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getLastModifiedSeatId()
	{
		return lastModifiedSeatId;
	}
	public void setLastModifiedSeatId(String lastModifiedSeatId)
	{
		this.lastModifiedSeatId = lastModifiedSeatId;
	}
	public String getDonorStatus()
	{
		return donorStatus;
	}
	public void setDonorStatus(String donorStatus)
	{
		this.donorStatus = donorStatus;
	}
	public String getVoluntary()
	{
		return voluntary;
	}
	public void setVoluntary(String voluntary)
	{
		this.voluntary = voluntary;
	}
	public String getEmergencyCall()
	{
		return emergencyCall;
	}
	public void setEmergencyCall(String emergencyCall)
	{
		this.emergencyCall = emergencyCall;
	}
	public String getHospitalCode()
	{
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode)
	{
		this.hospitalCode = hospitalCode;
	}
	public String getOfficeCollege()
	{
		return officeCollege;
	}
	public void setOfficeCollege(String officeCollege)
	{
		this.officeCollege = officeCollege;
	}
	public String getEmployeeStudentCode()
	{
		return employeeStudentCode;
	}
	public void setEmployeeStudentCode(String employeeStudentCode)
	{
		this.employeeStudentCode = employeeStudentCode;
	}
	public String getDesignationClass()
	{
		return designationClass;
	}
	public void setDesignationClass(String designationClass)
	{
		this.designationClass = designationClass;
	}
	public String getYearlyFrquency()
	{
		return yearlyFrquency;
	}
	public void setYearlyFrquency(String yearlyFrquency)
	{
		this.yearlyFrquency = yearlyFrquency;
	}
	public String getSpecificDay()
	{
		return specificDay;
	}
	public void setSpecificDay(String specificDay)
	{
		this.specificDay = specificDay;
	}
	public String getIsCamp()
	{
		return isCamp;
	}
	public void setIsCamp(String isCamp)
	{
		this.isCamp = isCamp;
	}
	public String getDonorDob()
	{
		return donorDob;
	}
	public void setDonorDob(String donorDob)
	{
		this.donorDob = donorDob;
	}
	public String getIsActualDob()
	{
		return isActualDob;
	}
	public void setIsActualDob(String isActualDob)
	{
		this.isActualDob = isActualDob;
	}
	public DonorAddDtlVO getDonorAddDtlVO()
	{
		return donorAddDtlVO;
	}
	public void setDonorAddDtlVO(DonorAddDtlVO donorAddDtlVO)
	{
		this.donorAddDtlVO = donorAddDtlVO;
	}
	
	
	
	public String getDonorAddCountryCode()
	{
		return getDonorAddDtlVO().getDonorAddCountryCode();
	}
	public void setDonorAddCountryCode(String donorCountryCode)
	{
		getDonorAddDtlVO().setDonorAddCountryCode(donorCountryCode);
	}
	public String getDonorAddTypeCode()
	{
		return getDonorAddDtlVO().getDonorAddTypeCode();
	}
	public void setDonorAddTypeCode(String donorAddTypeCode)
	{
		this.getDonorAddDtlVO().setDonorAddTypeCode(donorAddTypeCode);
	}
	
	public String getDonorAddress1()
	{
		return getDonorAddDtlVO().getDonorAddress1();
	}
	public void setDonorAddress1(String donorAddress1)
	{
		this.getDonorAddDtlVO().setDonorAddress1(donorAddress1);
	}
	public String getDonorAddress2()
	{
		return getDonorAddDtlVO().getDonorAddress2();
	}
	public void setDonorAddress2(String donorAddress2)
	{
		this.getDonorAddDtlVO().setDonorAddress2(donorAddress2);
	}
	public String getDonorAddStateCode()
	{
		return getDonorAddDtlVO().getDonorAddStateCode();
	}
	public void setDonorAddStateCode(String donorStateCode)
	{
		this.getDonorAddDtlVO().setDonorAddStateCode(donorStateCode);
	}
	public String getDonorPhoneNo()
	{
		return getDonorAddDtlVO().getDonorPhoneNo();
	}
	public void setDonorPhoneNo(String donorPhoneNo)
	{
		this.getDonorAddDtlVO().setDonorPhoneNo(donorPhoneNo);
	}
	public String getDonorAddCountry()
	{
		return getDonorAddDtlVO().getDonorAddCountry();
	}
	public void setDonorAddCountry(String donorCountry)
	{
		this.getDonorAddDtlVO().setDonorAddCountry(donorCountry);
	}
	public String getDonorAddState()
	{
		return getDonorAddDtlVO().getDonorAddState();
	}
	public void setDonorAddState(String donorState)
	{
		this.getDonorAddDtlVO().setDonorAddState(donorState);
	}
	
	public String getDonorAddPinNo()
	{
		return getDonorAddDtlVO().getDonorAddPinNo();
	}
	public void setDonorAddPinNo(String donorAddPinNo)
	{
		this.getDonorAddDtlVO().setDonorAddPinNo(donorAddPinNo);
	}
	public String getDonorAgeUnit()
	{
		return donorAgeUnit;
	}
	public void setDonorAgeUnit(String donorAgeUnit)
	{
		this.donorAgeUnit = donorAgeUnit;
	}
	public String getDonationStatus()
	{
		return donationStatus;
	}
	public void setDonationStatus(String donationStatus)
	{
		this.donationStatus = donationStatus;
	}
	public String getDonorMaritalStatus()
	{
		return donorMaritalStatus;
	}
	public void setDonorMaritalStatus(String donorMaritalStatus)
	{
		this.donorMaritalStatus = donorMaritalStatus;
	}
	public String getPatientName()
	{
		return patientName;
	}
	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}
	public String getWardName()
	{
		return wardName;
	}
	public void setWardName(String wardName)
	{
		this.wardName = wardName;
	}
	public String getBedNo()
	{
		return bedNo;
	}
	public void setBedNo(String bedNo)
	{
		this.bedNo = bedNo;
	}
	public String getBloodBagNo()
	{
		return bloodBagNo;
	}
	public void setBloodBagNo(String bloodBagNo)
	{
		this.bloodBagNo = bloodBagNo;
	}
	public String getIsCardPrint()
	{
		return isCardPrint;
	}
	public void setIsCardPrint(String isCardPrint)
	{
		this.isCardPrint = isCardPrint;
	}
	public String getIsCardPrintCode()
	{
		return isCardPrintCode;
	}
	public void setIsCardPrintCode(String isCardPrintCode)
	{
		this.isCardPrintCode = isCardPrintCode;
	}
	public String getDonationTypeCode()
	{
		return donationTypeCode;
	}
	public void setDonationTypeCode(String donationTypeCode)
	{
		this.donationTypeCode = donationTypeCode;
	}
	public String getDonationTypeDesc()
	{
		return donationTypeDesc;
	}
	public void setDonationTypeDesc(String donationTypeDesc)
	{
		this.donationTypeDesc = donationTypeDesc;
	}
	public String getBloodGroup()
	{
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup)
	{
		this.bloodGroup = bloodGroup;
	}
	
	
	//sorting in schedule printing process
	
	public int compareByName(DonorDtlVO donorDtlVO)
	{
		int flag = 0;
		String name1 = this.getDonorFirstName() + this.getDonorMiddleName() + this.getDonorLastName();
		String name2 = donorDtlVO.getDonorFirstName() + donorDtlVO.getDonorMiddleName() + donorDtlVO.getDonorLastName();
	 
			flag = name1.compareTo(name2);
	
		return flag;

	}
	public String[] getRegistrationNo()
	{
		return registrationNo;
	}
	public void setRegistrationNo(String[] registrationNo)
	{
		this.registrationNo = registrationNo;
	}
	public String getInvestigationStatus()
	{
		return investigationStatus;
	}
	public void setInvestigationStatus(String investigationStatus)
	{
		this.investigationStatus = investigationStatus;
	}

	public String getGuardianLabel()
	{
		return guardianLabel;
	}
	public void setGuardianLabel(String guardianLabel)
	{
		this.guardianLabel = guardianLabel;
	}
	public String getGuardianName()
	{
		return guardianName;
	}
	public void setGuardianName(String guardianName)
	{
		this.guardianName = guardianName;
	}
	public String getTemplateId()
	{
		return templateId;
	}
	public void setTemplateId(String templateId)
	{
		this.templateId = templateId;
	}

}
