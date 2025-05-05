package hisglobal.utility.generictemplate;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import hisglobal.hisconfig.Config;
import hisglobal.utility.Entry;
import hisglobal.vo.ConsentRequestVO;
import hisglobal.vo.DonorDtlVO;
import hisglobal.vo.MedicalBoardRequisitionVO;
import hisglobal.vo.PatientDetailVO;
import hisglobal.vo.ValueObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

//import bloodbank.BloodBankConfig;

public class InformationControlBean extends ActionForm
{
	private String patientName;
	private String patientFirstName;
	private String patientMiddleName;
	private String patientLastName;
	private String patientNickName;
	private String spouseName;
	private String fatherName;
	private String motherName;
	private String guardianName;
	private String patientDOB;
	private String patientGender;
	private String patientAge;
	private String spouseAge;
	private String fatherAge;
	private String motherAge;
	private String patientOccupation;
	private String spouseOccupation;
	private String fatherOccupation;
	private String motherOccupation;
	private String patientEducation;
	private String spouseEducation;
	private String fatherEducation;
	private String motherEducation;
	private String patientIncome;
	private String spouseIncome;
	private String fatherIncome;
	private String motherIncome;
	private String patientAddress;
	private String telephone;
	private String patientMaritalStatus;
	private String patientReligion;
	private String patientGenderAge;
	private String patientIsUrban;
	private String patientNationality;
	private String patientIdentityMark;

	private String patientBloodGroup;

	private String patientCRNo;
	private String dateOfRegistration;
	private String diagnosisCode;
	private String diagnosisName;
	private String admissionDate;
	private String departmentName;
	private String unitName;
	private String patientUnitRoom;
	private String patientPreviousCRNo;
	private String patientStatus;
	private String patientPrimaryCategory;
	private String patientRegistrationCategory;
	private String patientMotherCRNo;
	private String patientRegistrationType;
	private String patientSecondaryCategory;
	private String patientEpisodeVisitNo;
	private String patientReferHospitalName;
	private String patientReferDoctor;
	private String patientReferCRNo;
	private String patientReferDepartmentName;
	private String patientReferUnitName;
	private String patientMLCNo;
	private String admissionAdviceDate;
	private String dischargeDate;
	private String admissionComplaints;
	private String dischargeAdvice;
	private String wardName;
	private String bedName;
	private String patientIsDead;
	private String consultantName;
	
	private String sufferingFrom;
	private String fromDate;
	private String toDate;
	private String noOfDays;
	
	private String entryDate;
	private String consultantDesignation;
	private String procedure;
	private String procedureName;
	private String relativeName;
	private String relationship;
	private String relativeIdentityMark;
	private String relativeAddress;	
	private String relativeContactNo;
	
	private String patientGuardianRelation;
	private String patientGuardianName;

	// Voluntary Blood Donation Certificate
	private String donorName;
	private String donationDate;
	private String donationType;
	private String bloodBagNo;
	private String donorBloodGroup;
	private String donorGuardian;
	private String donorGuardianRelation;

	// Medical Board Certificate
	private String certificateDate;
	private String certificateNo;
	private String certificateRemarks;
	private String patientOrganisation;
	private String certificateStatus;
	private String ageGender;
	private String certificateOpinion;
	
	// Medical/Fitness Certificate
	private String patientDesignation;



	public InformationControlBean()
	{
		this.patientName="";
		this.patientFirstName="";
		this.patientMiddleName="";
		this.patientLastName="";
		this.patientNickName="";
		this.spouseName="";
		this.fatherName="";
		this.motherName="";
		this.guardianName="";
		this.patientDOB="";
		this.patientGender="";
		this.patientAge="";
		this.spouseAge="";
		this.fatherAge="";
		this.motherAge="";
		this.patientOccupation="";
		this.spouseOccupation="";
		this.fatherOccupation="";
		this.motherOccupation="";
		this.patientEducation="";
		this.spouseEducation="";
		this.fatherEducation="";
		this.motherEducation="";
		this.patientIncome="";
		this.spouseIncome="";
		this.fatherIncome="";
		this.motherIncome="";
		this.patientAddress="";
		this.telephone="";
		this.patientMaritalStatus="";
		this.patientReligion="";
		this.patientGenderAge="";
		this.patientIsUrban="";
		this.patientNationality="";
		this.patientIdentityMark="";

		this.patientBloodGroup="";

		this.patientCRNo="";
		this.dateOfRegistration="";
		this.diagnosisCode="";
		this.diagnosisName="";
		this.admissionDate="";
		this.departmentName="";
		this.unitName="";
		this.patientUnitRoom="";
		this.patientPreviousCRNo="";
		this.patientStatus="";
		this.patientPrimaryCategory="";
		this.patientRegistrationCategory="";
		this.patientMotherCRNo="";
		this.patientRegistrationType="";
		this.patientSecondaryCategory="";
		this.patientEpisodeVisitNo="";
		this.patientReferHospitalName="";
		this.patientReferDoctor="";
		this.patientReferCRNo="";
		this.patientReferDepartmentName="";
		this.patientReferUnitName="";
		this.patientMLCNo="";
		this.admissionAdviceDate="";
		this.dischargeDate="";
		this.admissionComplaints="";
		this.dischargeAdvice="";
		this.wardName="";
		this.bedName="";
		this.patientIsDead="";
		this.consultantName="";
		
		this.sufferingFrom="";
		this.fromDate="";
		this.toDate="";
		this.noOfDays="";

		this.entryDate="";
		this.consultantDesignation="";
		this.procedure="";
		this.procedureName="";
		
		this.relativeName="";
		this.relationship="";
		this.relativeIdentityMark="";
		this.relativeAddress="";
		this.relativeContactNo="";

		this.patientGuardianRelation="";
		this.patientGuardianName=" S/o  W/o  D/o :";

		// Voluntary Blood Donation Certificate
		this.donorName="";
		this.donationDate="";
		this.donationType="";
		this.bloodBagNo="";
		this.donorBloodGroup="";
		this.donorGuardian="";
		this.donorGuardianRelation=" S/o  W/o  D/o";

		// Medical Board Certificate
		this.certificateDate = "";
		this.certificateNo="";
		this.certificateRemarks="";
		this.certificateStatus="";
		this.patientOrganisation="";
		this.ageGender ="";
		this.certificateOpinion ="";
	
		// Medical/Fitness Certificate
		patientDesignation="";

	}

	private static Map<String, String> mpInfoDesc;
	static
	{
		mpInfoDesc = new HashMap<String, String>();
		mpInfoDesc.put("patientName", "Patient Name");
		mpInfoDesc.put("patientFirstName", "Patient First Name");
		mpInfoDesc.put("patientMiddleName", "Patient Middle Name");
		mpInfoDesc.put("patientLastName", "Patient Last Name");
		mpInfoDesc.put("patientNickName", "Patient Nick Name");
		mpInfoDesc.put("spouseName", "Spouse Name");
		mpInfoDesc.put("fatherName", "Father Name");
		mpInfoDesc.put("motherName", "Mother Name");
		mpInfoDesc.put("guardianName", "Guardian Name");
		mpInfoDesc.put("patientDOB", "Patient Date of Birth");
		mpInfoDesc.put("patientGender", "Patient Gender");
		mpInfoDesc.put("patientAge", "Patient Age");
		mpInfoDesc.put("spouseAge", "Spouse Age");
		mpInfoDesc.put("fatherAge", "Father Age");
		mpInfoDesc.put("motherAge", "Mother Age");
		mpInfoDesc.put("patientOccupation", "Patient Occupation");
		mpInfoDesc.put("spouseOccupation", "Spouse Occupation");
		mpInfoDesc.put("fatherOccupation", "Father Occupation");
		mpInfoDesc.put("motherOccupation", "Mother Occupation");
		mpInfoDesc.put("patientEduacation", "Patient Eduacation");
		mpInfoDesc.put("spouseEducation", "Spouse Eduacation");
		mpInfoDesc.put("fatherEducation", "Father Education");
		mpInfoDesc.put("motherEducation", "Mother Education");
		mpInfoDesc.put("patientIncome", "Patient Income");
		mpInfoDesc.put("spouseIncome", "Spouse Income");
		mpInfoDesc.put("fatherIncome", "Father Income");
		mpInfoDesc.put("motherIncome", "Mother Income");
		mpInfoDesc.put("patientAddress", "Patient Address");
		mpInfoDesc.put("telephone", "Telephone");
		mpInfoDesc.put("patientMaritalStatus", "Patient Marital Status");
		mpInfoDesc.put("patientReligion", "Patient Religion");
		mpInfoDesc.put("patientGenderAge", "Patient Gender Age");
		mpInfoDesc.put("patientIsUrban", "Patient Is Urban");
		mpInfoDesc.put("patientNationality", "Patient Nationality");
		mpInfoDesc.put("patientIdentityMark", "Patient Identity Mark");

		mpInfoDesc.put("patientBloodGroup", "Patient Blood Group");

		mpInfoDesc.put("patientCRNo", "Patient CR No.");
		mpInfoDesc.put("dateOfRegistration", "Date of Registration");
		mpInfoDesc.put("diagnosisCode", "Diagnosis Code");
		mpInfoDesc.put("diagnosisName", "Diagnosis Name");
		mpInfoDesc.put("admissionDate", "Admission Date");
		mpInfoDesc.put("departmentName", "Department Name");
		mpInfoDesc.put("unitName", "Unit Name");
		mpInfoDesc.put("patientUnitRoom", "Patient Unit Room");
		mpInfoDesc.put("patientPreviousCRNo", "Patient Previous CRNo");
		mpInfoDesc.put("patientStatus", "Patient Status");
		mpInfoDesc.put("patientPrimaryCategory", "Patient Primary Category");
		mpInfoDesc.put("patientRegistrationCategory", "Patient Registration Category");
		mpInfoDesc.put("patientMotherCRNo", "Patient Mother CRNo");
		mpInfoDesc.put("patientRegistrationType", "Patient Registration Type");
		mpInfoDesc.put("patientSecondaryCategory", "Patient Secondary Category");
		mpInfoDesc.put("patientEpisodeVisitNo", "Patient Visit No");
		mpInfoDesc.put("patientReferHospitalName", "Referred Hospital Name");
		mpInfoDesc.put("patientReferDoctor", "Referred Doctor");
		mpInfoDesc.put("patientReferCRNo", "Referred CRNo");
		mpInfoDesc.put("patientReferDepartmentName", "Referred Department Name");
		mpInfoDesc.put("patientReferUnitName", "Referred Unit Name");
		mpInfoDesc.put("patientMLCNo", "Patient MLC No");
		mpInfoDesc.put("admissionAdviceDate", "Admission Advice Date");
		mpInfoDesc.put("dischargeDate", "Discharge Date");
		mpInfoDesc.put("admissionComplaints", "Admission Complaints");
		mpInfoDesc.put("dischargeAdvice", "Discharge Advice");
		mpInfoDesc.put("wardName", "Ward Name");
		mpInfoDesc.put("bedName", "Bed Name");
		mpInfoDesc.put("patientIsDead", "Patient Is Dead");
		mpInfoDesc.put("consultantName", "Consultant Name");

		mpInfoDesc.put("sufferingFrom", "Suffering From");
		mpInfoDesc.put("fromDate", "From Date");
		mpInfoDesc.put("toDate", "To Date");
		mpInfoDesc.put("noOfDays", "No of Days");

		mpInfoDesc.put("entryDate", "Entry Date");
		mpInfoDesc.put("consultantDesignation", "Consultant Designation");
		mpInfoDesc.put("procedure", "Procedure");
		mpInfoDesc.put("procedureName", "Procedue Name");

		mpInfoDesc.put("relativeName", "Relative Name");
		mpInfoDesc.put("relationship", "Relationship");
		mpInfoDesc.put("relativeIdentityMark", "Relative Identity Mark");
		mpInfoDesc.put("relativeAddress", "Relative Address");
		mpInfoDesc.put("relativeContactNo", "Relative Contact No");

		mpInfoDesc.put("patientGuardianRelation", "Patient Guardian Relation");
		mpInfoDesc.put("patientGuardianName", "Patient Guardian Name");

		// Voluntary Blood Donation Certificate
		mpInfoDesc.put("donorName", "Donor Name");
		mpInfoDesc.put("donationDate", "Donation Date");
		mpInfoDesc.put("donationType", "Donation Type");
		mpInfoDesc.put("bloodBagNo", "Blood Bag No");
		mpInfoDesc.put("donorBloodGroup", "Donor Blood Group");
		mpInfoDesc.put("donorGuardian", "Donor Guardian");
		mpInfoDesc.put("donorGuardianRelation", "Donor Guardian Relation");

		// Medical Board Certificate
		mpInfoDesc.put("certificateDate", "Certificate Date");
		mpInfoDesc.put("certificateNo", "Certificate No.");
		mpInfoDesc.put("certificateRemarks", "Certificate Remarks");
		mpInfoDesc.put("certificateStatus", "Certificate Status");
		mpInfoDesc.put("patientOrganisation","Patient Organisation");
		mpInfoDesc.put("certificateOpinion","Certificate Opinion");

		// Medical/Fitness Certificate
		mpInfoDesc.put("patientDesignation","Patient Designation");
	}
	
	public void putDataInInfoBean(ValueObject _vo)
	{
		if(_vo instanceof PatientDetailVO)
			putPatientDetailValues((PatientDetailVO)_vo);
		else if(_vo instanceof ConsentRequestVO)
			putConsentRequestValues((ConsentRequestVO)_vo);
		else if(_vo instanceof DonorDtlVO)
			putDonorDetailValues((DonorDtlVO)_vo);
		else if(_vo instanceof MedicalBoardRequisitionVO)
			putMBCertificateDetailValues((MedicalBoardRequisitionVO)_vo);
	}
	
	public void putPatientDetailValues(PatientDetailVO _vo)
	{
			// Cr No.
		if(_vo.getPatCrNo()!=null) this.setPatientCRNo(_vo.getPatCrNo());
			// Patient Name	
		if(_vo.getPatName()==null)	_vo.setPatientName();
		if(_vo.getPatName()!=null) this.setPatientName(_vo.getPatName());
			// First Name
		if(_vo.getPatFirstName()!=null) this.setPatientFirstName(_vo.getPatFirstName());
			// Middle Name
		if(_vo.getPatMiddleName()!=null) this.setPatientMiddleName(_vo.getPatMiddleName());
			// Last Name
		if(_vo.getPatLastName()!=null) this.setPatientLastName(_vo.getPatLastName());
			// Patient Age
		if(_vo.getPatAge()!=null) this.setPatientAge(_vo.getPatAge());
			// Gender
		if(_vo.getPatGender()!=null) this.setPatientGender(_vo.getPatGender());
			// Gender/Age
		if(_vo.getPatGenderAge()!=null)
			this.setPatientGenderAge(_vo.getPatGenderAge());
		else if(_vo.getPatGender()!=null && _vo.getPatAge()!=null)
			this.setPatientGenderAge(_vo.getPatGender()+"/"+_vo.getPatAge());
			// Guardian Relationship & Guardian Name
		this.setPatientGuardianRelation(" S/o  W/o  D/o :");
		this.setPatientGuardianName("");
		if(_vo.getPatHusbandName()!=null && !_vo.getPatHusbandName().trim().equals(""))
		{
			this.setPatientGuardianRelation(" W/o :");
			this.setPatientGuardianName(_vo.getPatHusbandName());
		}
		else if(_vo.getPatSpouceName()!=null && !_vo.getPatSpouceName().trim().equals(""))
		{
			this.setPatientGuardianRelation(" W/o :");
			this.setPatientGuardianName(_vo.getPatSpouceName());
		}
		else if(_vo.getPatGuardianName()!=null && !_vo.getPatGuardianName().trim().equals(""))
		{
			this.setPatientGuardianRelation(" D/o S/o :");
			this.setPatientGuardianName(_vo.getPatGuardianName());
		}
		else if(_vo.getPatGenderType()!=null)
		{
			if(_vo.getPatGenderType().equals(Config.GENDER_TYPE_FEMALE) && _vo.getPatGuardianName()!=null && !_vo.getPatGuardianName().trim().equals(""))
			{
				this.setPatientGuardianRelation(" D/o :");
				this.setPatientGuardianName(_vo.getPatGuardianName());
			}
			else if(_vo.getPatGenderType().equals(Config.GENDER_TYPE_MALE) && _vo.getPatGuardianName()!=null && !_vo.getPatGuardianName().trim().equals(""))
			{
				this.setPatientGuardianRelation(" S/o :");
				this.setPatientGuardianName(_vo.getPatGuardianName());
			}
		}
			// Patient Address
		if(_vo.getPatAddress()!=null)
		{
			_vo.setPatientCompleteAddress();
			if(_vo.getPatCompleteAddress()!=null) this.setPatientAddress(_vo.getPatCompleteAddress());
		}
			// Deprtment Name
		if(_vo.getDepartment()!=null) this.setDepartmentName(_vo.getDepartment());
			// Department Unit Name
		if(_vo.getDepartmentUnitName()!=null) this.setUnitName(_vo.getDepartmentUnitName());
	}

	public void putConsentRequestValues(ConsentRequestVO _vo)
	{
		if(_vo.getPatCrNo()!=null) this.setPatientCRNo(_vo.getPatCrNo());
		if(_vo.getRelationshipName()!=null)	this.setRelationship(_vo.getRelationshipName());
		if(_vo.getRelativeAddr()!=null)	this.setRelativeAddress(_vo.getRelativeAddr());
		if(_vo.getRelativeContactNo()!=null)	this.setRelativeContactNo(_vo.getRelativeContactNo());
		if(_vo.getRelativeIdRemark()!=null)	this.setRelativeIdentityMark(_vo.getRelativeIdRemark());
		if(_vo.getRelativeName()!=null)	this.setRelativeName(_vo.getRelativeName());
		
		if(_vo.getServiceTypeDesc()!=null && this.getProcedure()==null)	this.setProcedure(_vo.getServiceTypeDesc());
		if(_vo.getServiceDesc()!=null && this.getProcedureName()==null)	this.setProcedureName(_vo.getServiceDesc());
	}

	public void putDonorDetailValues(DonorDtlVO _vo)
	{
		if(_vo.getEntryDate()!=null) this.setEntryDate(_vo.getEntryDate());
		String name="";
		if(_vo.getDonorFirstName()!=null)	name+=_vo.getDonorFirstName()+" "; 
		if(_vo.getDonorMiddleName()!=null)	name+=_vo.getDonorMiddleName()+" "; 
		if(_vo.getDonorLastName()!=null)	name+=_vo.getDonorLastName(); 
		this.setDonorName(name);
		if(_vo.getDonorVisitDate()!=null) this.setDonationDate(_vo.getDonorVisitDate());
		if(_vo.getDonationTypeDesc()!=null) this.setDonationType(_vo.getDonationTypeDesc());
		if(_vo.getBloodBagNo()!=null)	this.setBloodBagNo(_vo.getBloodBagNo());
		if(_vo.getBloodGroup()!=null)	this.setDonorBloodGroup(_vo.getBloodGroup());
		if(_vo.getDonorGenderCode().equals(Config.GENDER_TYPE_FEMALE) && _vo.getDonorSpouseName()!=null)
		{
			this.setDonorGuardianRelation(" W/o");
			this.setDonorGuardian(_vo.getDonorSpouseName());
		}
		else if(_vo.getDonorGenderCode().equals(Config.GENDER_TYPE_FEMALE) && _vo.getDonorFatherName()!=null)
		{
			this.setDonorGuardianRelation(" D/o");
			this.setDonorGuardian(_vo.getDonorFatherName());
		}
		else if(_vo.getDonorGenderCode().equals(Config.GENDER_TYPE_MALE) && _vo.getDonorFatherName()!=null)
		{
			this.setDonorGuardianRelation(" S/o");
			this.setDonorGuardian(_vo.getDonorFatherName());
		}
	}
	
	public void putMBCertificateDetailValues(MedicalBoardRequisitionVO _vo)
	{
		if(_vo.getEntryDate()!=null) this.setCertificateDate(_vo.getEntryDate());
		this.setCertificateNo("");
		if(_vo.getFinalRemark()!=null) this.setCertificateRemarks(_vo.getFinalRemark());
		if(_vo.getCertificateResult()!=null)	this.setCertificateStatus(_vo.getCertificateResult());
		if(_vo.getOrgName()!=null)	this.setPatientOrganisation(_vo.getOrgName());
		if(_vo.getOpinion()!=null)	this.setCertificateOpinion(_vo.getOpinion());

	}

	public static List<Entry> fetchInformationList()
	{
		List<Entry> lst = new ArrayList<Entry>();
		/*Class clsInfoBean = InformationControlBean.class;

		Method[] methodsInfoBean = clsInfoBean.getMethods();

		for (int i = 0; i < methodsInfoBean.length; i++)
		{
			if (methodsInfoBean[i].getName().indexOf("get") == 0)
			{
				String str = methodsInfoBean[i].getName().substring(3,4).toLowerCase();
				if(methodsInfoBean[i].getName().length()>4) str= str.concat(methodsInfoBean[i].getName().substring(4));
				Entry e = new Entry(mpInfoDesc.get(str), str);
				lst.add(e);
			}
		}*/
		String[] arrKeys = new String[mpInfoDesc.keySet().size()];
		arrKeys = mpInfoDesc.keySet().toArray(arrKeys);
		Arrays.sort(arrKeys);
		for(String key : arrKeys)	lst.add(new Entry(mpInfoDesc.get(key), key));
		return lst;
	}

	public String fetchInformation(String infoName)
	{
		String value="";
		Class clsInfoBean = InformationControlBean.class;
		try
		{
			Method[] methodsInfoBean = clsInfoBean.getMethods();
			for (int i = 0; i < methodsInfoBean.length; i++)
			{
				if (methodsInfoBean[i].getName().indexOf("get") == 0)
				{
					String str = methodsInfoBean[i].getName().substring(3,4).toLowerCase();
					if(methodsInfoBean[i].getName().length()>4) str= str.concat(methodsInfoBean[i].getName().substring(4));
					if(str.equals(infoName))
					{
						value = (String) methodsInfoBean[i].invoke(this);
						break;
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			value="";
		}
		return value;
	}

	public String getPatientName()
	{
		return patientName;
	}

	public void setPatientName(String patientName)
	{
		this.patientName = patientName;
	}

	public String getPatientFirstName()
	{
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName)
	{
		this.patientFirstName = patientFirstName;
	}

	public String getPatientMiddleName()
	{
		return patientMiddleName;
	}

	public void setPatientMiddleName(String patientMiddleName)
	{
		this.patientMiddleName = patientMiddleName;
	}

	public String getPatientLastName()
	{
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName)
	{
		this.patientLastName = patientLastName;
	}

	public String getPatientNickName()
	{
		return patientNickName;
	}

	public void setPatientNickName(String patientNickName)
	{
		this.patientNickName = patientNickName;
	}

	public String getSpouseName()
	{
		return spouseName;
	}

	public void setSpouseName(String spouseName)
	{
		this.spouseName = spouseName;
	}

	public String getFatherName()
	{
		return fatherName;
	}

	public void setFatherName(String fatherName)
	{
		this.fatherName = fatherName;
	}

	public String getMotherName()
	{
		return motherName;
	}

	public void setMotherName(String motherName)
	{
		this.motherName = motherName;
	}

	public String getGuardianName()
	{
		return guardianName;
	}

	public void setGuardianName(String guardianName)
	{
		this.guardianName = guardianName;
	}

	public String getPatientDOB()
	{
		return patientDOB;
	}

	public void setPatientDOB(String patientDOB)
	{
		this.patientDOB = patientDOB;
	}

	public String getPatientGender()
	{
		return patientGender;
	}

	public void setPatientGender(String patientGender)
	{
		this.patientGender = patientGender;
	}

	public String getPatientAge()
	{
		return patientAge;
	}

	public void setPatientAge(String patientAge)
	{
		this.patientAge = patientAge;
	}

	public String getSpouseAge()
	{
		return spouseAge;
	}

	public void setSpouseAge(String spouseAge)
	{
		this.spouseAge = spouseAge;
	}

	public String getFatherAge()
	{
		return fatherAge;
	}

	public void setFatherAge(String fatherAge)
	{
		this.fatherAge = fatherAge;
	}

	public String getMotherAge()
	{
		return motherAge;
	}

	public void setMotherAge(String motherAge)
	{
		this.motherAge = motherAge;
	}

	public String getPatientOccupation()
	{
		return patientOccupation;
	}

	public void setPatientOccupation(String patientOccupation)
	{
		this.patientOccupation = patientOccupation;
	}

	public String getSpouseOccupation()
	{
		return spouseOccupation;
	}

	public void setSpouseOccupation(String spouseOccupation)
	{
		this.spouseOccupation = spouseOccupation;
	}

	public String getFatherOccupation()
	{
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation)
	{
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherOccupation()
	{
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation)
	{
		this.motherOccupation = motherOccupation;
	}

	public String getPatientEducation()
	{
		return patientEducation;
	}

	public void setPatientEducation(String patientEducation)
	{
		this.patientEducation = patientEducation;
	}

	public String getSpouseEducation()
	{
		return spouseEducation;
	}

	public void setSpouseEducation(String spouseEducation)
	{
		this.spouseEducation = spouseEducation;
	}

	public String getFatherEducation()
	{
		return fatherEducation;
	}

	public void setFatherEducation(String fatherEducation)
	{
		this.fatherEducation = fatherEducation;
	}

	public String getMotherEducation()
	{
		return motherEducation;
	}

	public void setMotherEducation(String motherEducation)
	{
		this.motherEducation = motherEducation;
	}

	public String getPatientIncome()
	{
		return patientIncome;
	}

	public void setPatientIncome(String patientIncome)
	{
		this.patientIncome = patientIncome;
	}

	public String getSpouseIncome()
	{
		return spouseIncome;
	}

	public void setSpouseIncome(String spouseIncome)
	{
		this.spouseIncome = spouseIncome;
	}

	public String getFatherIncome()
	{
		return fatherIncome;
	}

	public void setFatherIncome(String fatherIncome)
	{
		this.fatherIncome = fatherIncome;
	}

	public String getMotherIncome()
	{
		return motherIncome;
	}

	public void setMotherIncome(String motherIncome)
	{
		this.motherIncome = motherIncome;
	}

	public String getPatientAddress()
	{
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress)
	{
		this.patientAddress = patientAddress;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getPatientMaritalStatus()
	{
		return patientMaritalStatus;
	}

	public void setPatientMaritalStatus(String patientMaritalStatus)
	{
		this.patientMaritalStatus = patientMaritalStatus;
	}

	public String getPatientReligion()
	{
		return patientReligion;
	}

	public void setPatientReligion(String patientReligion)
	{
		this.patientReligion = patientReligion;
	}

	public String getPatientGenderAge()
	{
		return patientGenderAge;
	}

	public void setPatientGenderAge(String patientGenderAge)
	{
		this.patientGenderAge = patientGenderAge;
	}

	public String getPatientIsUrban()
	{
		return patientIsUrban;
	}

	public void setPatientIsUrban(String patientIsUrban)
	{
		this.patientIsUrban = patientIsUrban;
	}

	public String getPatientNationality()
	{
		return patientNationality;
	}

	public void setPatientNationality(String patientNationality)
	{
		this.patientNationality = patientNationality;
	}

	public String getPatientIdentityMark()
	{
		return patientIdentityMark;
	}

	public void setPatientIdentityMark(String patientIdentityMark)
	{
		this.patientIdentityMark = patientIdentityMark;
	}

	public String getPatientBloodGroup()
	{
		return patientBloodGroup;
	}

	public void setPatientBloodGroup(String patientBloodGroup)
	{
		this.patientBloodGroup = patientBloodGroup;
	}

	public String getPatientCRNo()
	{
		return patientCRNo;
	}

	public void setPatientCRNo(String patientCRNo)
	{
		this.patientCRNo = patientCRNo;
	}

	public String getDateOfRegistration()
	{
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration)
	{
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getDiagnosisCode()
	{
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode)
	{
		this.diagnosisCode = diagnosisCode;
	}

	public String getDiagnosisName()
	{
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName)
	{
		this.diagnosisName = diagnosisName;
	}

	public String getAdmissionDate()
	{
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate)
	{
		this.admissionDate = admissionDate;
	}

	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public void setUnitName(String unitName)
	{
		this.unitName = unitName;
	}

	public String getPatientUnitRoom()
	{
		return patientUnitRoom;
	}

	public void setPatientUnitRoom(String patientUnitRoom)
	{
		this.patientUnitRoom = patientUnitRoom;
	}

	public String getPatientPreviousCRNo()
	{
		return patientPreviousCRNo;
	}

	public void setPatientPreviousCRNo(String patientPreviousCRNo)
	{
		this.patientPreviousCRNo = patientPreviousCRNo;
	}

	public String getPatientStatus()
	{
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus)
	{
		this.patientStatus = patientStatus;
	}

	public String getPatientPrimaryCategory()
	{
		return patientPrimaryCategory;
	}

	public void setPatientPrimaryCategory(String patientPrimaryCategory)
	{
		this.patientPrimaryCategory = patientPrimaryCategory;
	}

	public String getPatientRegistrationCategory()
	{
		return patientRegistrationCategory;
	}

	public void setPatientRegistrationCategory(String patientRegistrationCategory)
	{
		this.patientRegistrationCategory = patientRegistrationCategory;
	}

	public String getPatientMotherCRNo()
	{
		return patientMotherCRNo;
	}

	public void setPatientMotherCRNo(String patientMotherCRNo)
	{
		this.patientMotherCRNo = patientMotherCRNo;
	}

	public String getPatientRegistrationType()
	{
		return patientRegistrationType;
	}

	public void setPatientRegistrationType(String patientRegistrationType)
	{
		this.patientRegistrationType = patientRegistrationType;
	}

	public String getPatientSecondaryCategory()
	{
		return patientSecondaryCategory;
	}

	public void setPatientSecondaryCategory(String patientSecondaryCategory)
	{
		this.patientSecondaryCategory = patientSecondaryCategory;
	}

	public String getPatientEpisodeVisitNo()
	{
		return patientEpisodeVisitNo;
	}

	public void setPatientEpisodeVisitNo(String patientEpisodeVisitNo)
	{
		this.patientEpisodeVisitNo = patientEpisodeVisitNo;
	}

	public String getPatientReferHospitalName()
	{
		return patientReferHospitalName;
	}

	public void setPatientReferHospitalName(String patientReferHospitalName)
	{
		this.patientReferHospitalName = patientReferHospitalName;
	}

	public String getPatientReferDoctor()
	{
		return patientReferDoctor;
	}

	public void setPatientReferDoctor(String patientReferDoctor)
	{
		this.patientReferDoctor = patientReferDoctor;
	}

	public String getPatientReferCRNo()
	{
		return patientReferCRNo;
	}

	public void setPatientReferCRNo(String patientReferCRNo)
	{
		this.patientReferCRNo = patientReferCRNo;
	}

	public String getPatientReferDepartmentName()
	{
		return patientReferDepartmentName;
	}

	public void setPatientReferDepartmentName(String patientReferDepartmentName)
	{
		this.patientReferDepartmentName = patientReferDepartmentName;
	}

	public String getPatientReferUnitName()
	{
		return patientReferUnitName;
	}

	public void setPatientReferUnitName(String patientReferUnitName)
	{
		this.patientReferUnitName = patientReferUnitName;
	}

	public String getPatientMLCNo()
	{
		return patientMLCNo;
	}

	public void setPatientMLCNo(String patientMLCNo)
	{
		this.patientMLCNo = patientMLCNo;
	}

	public String getAdmissionAdviceDate()
	{
		return admissionAdviceDate;
	}

	public void setAdmissionAdviceDate(String admissionAdviceDate)
	{
		this.admissionAdviceDate = admissionAdviceDate;
	}

	public String getDischargeDate()
	{
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate)
	{
		this.dischargeDate = dischargeDate;
	}

	public String getAdmissionComplaints()
	{
		return admissionComplaints;
	}

	public void setAdmissionComplaints(String admissionComplaints)
	{
		this.admissionComplaints = admissionComplaints;
	}

	public String getDischargeAdvice()
	{
		return dischargeAdvice;
	}

	public void setDischargeAdvice(String dischargeAdvice)
	{
		this.dischargeAdvice = dischargeAdvice;
	}

	public String getWardName()
	{
		return wardName;
	}

	public void setWardName(String wardName)
	{
		this.wardName = wardName;
	}

	public String getBedName()
	{
		return bedName;
	}

	public void setBedName(String bedName)
	{
		this.bedName = bedName;
	}

	public String getPatientIsDead()
	{
		return patientIsDead;
	}

	public void setPatientIsDead(String patientIsDead)
	{
		this.patientIsDead = patientIsDead;
	}

	public String getConsultantName()
	{
		return consultantName;
	}

	public void setConsultantName(String consultantName)
	{
		this.consultantName = consultantName;
	}

	public String getSufferingFrom()
	{
		return sufferingFrom;
	}

	public void setSufferingFrom(String sufferingFrom)
	{
		this.sufferingFrom = sufferingFrom;
	}

	public String getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(String fromDate)
	{
		this.fromDate = fromDate;
	}

	public String getToDate()
	{
		return toDate;
	}

	public void setToDate(String toDate)
	{
		this.toDate = toDate;
	}

	public String getNoOfDays()
	{
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays)
	{
		this.noOfDays = noOfDays;
	}

	public String getEntryDate()
	{
		return entryDate;
	}

	public void setEntryDate(String entryDate)
	{
		this.entryDate = entryDate;
	}

	public String getConsultantDesignation()
	{
		return consultantDesignation;
	}

	public void setConsultantDesignation(String consultantDesignation)
	{
		this.consultantDesignation = consultantDesignation;
	}

	public String getProcedure()
	{
		return procedure;
	}

	public void setProcedure(String procedure)
	{
		this.procedure = procedure;
	}

	public String getProcedureName()
	{
		return procedureName;
	}

	public void setProcedureName(String procedueName)
	{
		this.procedureName = procedueName;
	}

	public String getRelativeName()
	{
		return relativeName;
	}

	public void setRelativeName(String relativeName)
	{
		this.relativeName = relativeName;
	}

	public String getRelationship()
	{
		return relationship;
	}

	public void setRelationship(String relationship)
	{
		this.relationship = relationship;
	}

	public String getRelativeIdentityMark()
	{
		return relativeIdentityMark;
	}

	public void setRelativeIdentityMark(String relativeIdentityMark)
	{
		this.relativeIdentityMark = relativeIdentityMark;
	}

	public String getRelativeAddress()
	{
		return relativeAddress;
	}

	public void setRelativeAddress(String relativeAddress)
	{
		this.relativeAddress = relativeAddress;
	}

	public String getRelativeContactNo()
	{
		return relativeContactNo;
	}

	public void setRelativeContactNo(String relativeContactNo)
	{
		this.relativeContactNo = relativeContactNo;
	}

	public String getDonorName()
	{
		return donorName;
	}

	public void setDonorName(String donorName)
	{
		this.donorName = donorName;
	}

	public String getDonationDate()
	{
		return donationDate;
	}

	public void setDonationDate(String donationDate)
	{
		this.donationDate = donationDate;
	}

	public String getDonationType()
	{
		return donationType;
	}

	public void setDonationType(String donationType)
	{
		this.donationType = donationType;
	}

	public String getDonorGuardian()
	{
		return donorGuardian;
	}

	public void setDonorGuardian(String donorGuardian)
	{
		this.donorGuardian = donorGuardian;
	}

	public String getDonorGuardianRelation()
	{
		return donorGuardianRelation;
	}

	public void setDonorGuardianRelation(String donorGuardianRelation)
	{
		this.donorGuardianRelation = donorGuardianRelation;
	}

	public String getBloodBagNo()
	{
		return bloodBagNo;
	}

	public void setBloodBagNo(String bloodBagNo)
	{
		this.bloodBagNo = bloodBagNo;
	}

	public String getDonorBloodGroup()
	{
		return donorBloodGroup;
	}

	public void setDonorBloodGroup(String donorBloodGroup)
	{
		this.donorBloodGroup = donorBloodGroup;
	}

	public String getPatientGuardianName()
	{
		return patientGuardianName;
	}

	public void setPatientGuardianName(String patientGuardianName)
	{
		this.patientGuardianName = patientGuardianName;
	}

	public String getPatientGuardianRelation()
	{
		return patientGuardianRelation;
	}

	public void setPatientGuardianRelation(String patientGuardianRelation)
	{
		this.patientGuardianRelation = patientGuardianRelation;
	}

	public String getCertificateDate() {
		return certificateDate;
	}

	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getCertificateRemarks() {
		return certificateRemarks;
	}

	public void setCertificateRemarks(String certificateRemarks) {
		this.certificateRemarks = certificateRemarks;
	}

	public String getPatientOrganisation() {
		return patientOrganisation;
	}

	public void setPatientOrganisation(String patientOrganisation) {
		this.patientOrganisation = patientOrganisation;
	}

	public String getCertificateStatus() {
		return certificateStatus;
	}

	public void setCertificateStatus(String certificateStatus) {
		this.certificateStatus = certificateStatus;
	}

	public String getAgeGender() {
		return ageGender;
	}

	public void setAgeGender(String ageGender) {
		this.ageGender = ageGender;
	}

	public String getCertificateOpinion() {
		return certificateOpinion;
	}

	public void setCertificateOpinion(String certificateOpinion) {
		this.certificateOpinion = certificateOpinion;
	}

	public String getPatientDesignation() {
		return patientDesignation;
	}

	public void setPatientDesignation(String patientDesignation) {
		this.patientDesignation = patientDesignation;
	}

}
