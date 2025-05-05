package hisglobal.vo;

public class MedicalBoardRequisitionVO extends ValueObject
{
     private String certificateTypeID; 
     private String certificateTypeName; 
	 private String patCrNo;
	 private String patPrimaryCat;
	 private String patPrimaryCatCode;
	 private String patFirstName;
	 private String patMiddleName;
	 private String patLastName;
	 private String patName;
	 private String patGender;
     private String patGenderCode;
	 private String patAge;
	 private String patAgeGender;
	 private String patDOB;
	 private String isActualDob;
     
	 private String reqID;
	 private String slNo;
	 private String requestFrom;
	 private String designation;
	 private String orgID;
	 private String orgType;
	 private String orgTypeID;
	 private String orgName;
	 private String orgAddress;
	 private String reqStatus;
	 private String examDate;
	 private String examDay;
	 private String minReq;
	 private String maxReq;
	 private String registeredReq;
	 private String approvedDate;
	 private String approvedBy;
	// private String boardID;
	 private String boardTypeID;
	 private String hospitalCode;
	 private String isValid;
	 private String departmentUnitCode;
	 private String visitNo;
	 private String episodeVisitNo;
	 private String episodeCode;
	 private String boardNo;
	 private String boardName;
	 private String entryDate;
	 private String isReferred;
	 private String isInvestigationRaised;
	 private String referStatus;
	 private String invStatus;
	 private String visitDate;
	 private String partialReason;
	 private String result;
	 private String opinion;
	 private String isVerified;
	 private String isApproved;
	 
	 private String requestFromName;
	 private String reqStatusDesc;
	 private String certIssueType;
	 private String certReqBy;
	 
	 private String finalRemark;
	 private String opinionCode;
	 private String certificateResult;
	 private String chkPreviousDate;
	 private String strPreviousDate;
	 private String certificateNo ;
	 private String templateID;
	 private String cIDNo ;
	 private String  extReferStatus;
	 private String isImageUploaded; 
	public String getFinalRemark() {
		return finalRemark;
	}
	public void setFinalRemark(String finalRemark) {
		this.finalRemark = finalRemark;
	}
	public String getOpinionCode() {
		return opinionCode;
	}
	public void setOpinionCode(String opinionCode) {
		this.opinionCode = opinionCode;
	}
	public String getCertificateResult() {
		return certificateResult;
	}
	public void setCertificateResult(String certificateResult) {
		this.certificateResult = certificateResult;
	}
	public String getCertIssueType() {
		return certIssueType;
	}
	public void setCertIssueType(String isImageUploaded) {
		this.isImageUploaded = isImageUploaded;
	}
	public String getCertReqBy() {
		return certReqBy;
	}
	public void setCertReqBy(String certReqBy) {
		this.certReqBy = certReqBy;
	}
	public String getRequestFromName() {
		return requestFromName;
	}
	public void setRequestFromName(String requestFromName) {
		this.requestFromName = requestFromName;
	}
	public String getPartialReason() {
		return partialReason;
	}
	public void setPartialReason(String partialReason) {
		this.partialReason = partialReason;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}
	public String getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	public String getPatAgeGender() {
		return patAgeGender;
	}
	public void setPatAgeGender(String patAgeGender) {
		this.patAgeGender = patAgeGender;
	}
	public String getVisitNo() {
		return visitNo;
	}
	public void setVisitNo(String visitNo) {
		this.visitNo = visitNo;
	}
	public String getCertificateTypeID() {
		return certificateTypeID;
	}
	public void setCertificateTypeID(String certificateTypeID) {
		this.certificateTypeID = certificateTypeID;
	}
	public String getPatCrNo() {
		return patCrNo;
	}
	public void setPatCrNo(String patCrNo) {
		this.patCrNo = patCrNo;
	}
	public String getPatPrimaryCat() {
		return patPrimaryCat;
	}
	public void setPatPrimaryCat(String patPrimaryCat) {
		this.patPrimaryCat = patPrimaryCat;
	}
	public String getPatPrimaryCatCode() {
		return patPrimaryCatCode;
	}
	public void setPatPrimaryCatCode(String patPrimaryCatCode) {
		this.patPrimaryCatCode = patPrimaryCatCode;
	}
	public String getPatFirstName() {
		return patFirstName;
	}
	public void setPatFirstName(String patFirstName) {
		this.patFirstName = patFirstName;
	}
	public String getPatMiddleName() {
		return patMiddleName;
	}
	public void setPatMiddleName(String patMiddleName) {
		this.patMiddleName = patMiddleName;
	}
	public String getPatLastName() {
		return patLastName;
	}
	public void setPatLastName(String patLastName) {
		this.patLastName = patLastName;
	}
	public String getPatGender() {
		return patGender;
	}
	public void setPatGender(String patGender) {
		this.patGender = patGender;
	}
	public String getPatGenderCode() {
		return patGenderCode;
	}
	public void setPatGenderCode(String patGenderCode) {
		this.patGenderCode = patGenderCode;
	}
	public String getPatAge() {
		return patAge;
	}
	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}
	public String getPatDOB() {
		return patDOB;
	}
	public void setPatDOB(String patDOB) {
		this.patDOB = patDOB;
	}
	public String getIsActualDob() {
		return isActualDob;
	}
	public void setIsActualDob(String isActualDob) {
		this.isActualDob = isActualDob;
	}
	public String getReqID() {
		return reqID;
	}
	public void setReqID(String reqID) {
		this.reqID = reqID;
	}
	public String getRequestFrom() {
		return requestFrom;
	}
	public void setRequestFrom(String requestFrom) {
		this.requestFrom = requestFrom;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getOrgID() {
		return orgID;
	}
	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgTypeID() {
		return orgTypeID;
	}
	public void setOrgTypeID(String orgTypeID) {
		this.orgTypeID = orgTypeID;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgAddress() {
		return orgAddress;
	}
	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public String getBoardTypeID() {
		return boardTypeID;
	}
	public void setBoardTypeID(String boardTypeID) {
		this.boardTypeID = boardTypeID;
	}
	public String getMinReq() {
		return minReq;
	}
	public void setMinReq(String minReq) {
		this.minReq = minReq;
	}
	public String getMaxReq() {
		return maxReq;
	}
	public void setMaxReq(String maxReq) {
		this.maxReq = maxReq;
	}
	public String getRegisteredReq() {
		return registeredReq;
	}
	public void setRegisteredReq(String registeredReq) {
		this.registeredReq = registeredReq;
	}
	public String getCertificateTypeName() {
		return certificateTypeName;
	}
	public void setCertificateTypeName(String certificateTypeName) {
		this.certificateTypeName = certificateTypeName;
	}
	public String getDepartmentUnitCode() {
		return departmentUnitCode;
	}
	public void setDepartmentUnitCode(String departmentUnitCode) {
		this.departmentUnitCode = departmentUnitCode;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getEpisodeCode() {
		return episodeCode;
	}
	public void setEpisodeCode(String episodeCode) {
		this.episodeCode = episodeCode;
	}
	public String getEpisodeVisitNo() {
		return episodeVisitNo;
	}
	public void setEpisodeVisitNo(String episodeVisitNo) {
		this.episodeVisitNo = episodeVisitNo;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getIsReferred() {
		return isReferred;
	}
	public void setIsReferred(String isReferred) {
		this.isReferred = isReferred;
	}
	public String getIsInvestigationRaised() {
		return isInvestigationRaised;
	}
	public void setIsInvestigationRaised(String isInvestigationRaised) {
		this.isInvestigationRaised = isInvestigationRaised;
	}
	public String getReferStatus() {
		return referStatus;
	}
	public void setReferStatus(String referStatus) {
		this.referStatus = referStatus;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getInvStatus() {
		return invStatus;
	}
	public void setInvStatus(String invStatus) {
		this.invStatus = invStatus;
	}
	public String getReqStatusDesc() {
		return reqStatusDesc;
	}
	public void setReqStatusDesc(String reqStatusDesc) {
		this.reqStatusDesc = reqStatusDesc;
	}
	public String getExamDay() {
		return examDay;
	}
	public void setExamDay(String examDay) {
		this.examDay = examDay;
	}
	public String getChkPreviousDate() {
		return chkPreviousDate;
	}
	public void setChkPreviousDate(String chkPreviousDate) {
		this.chkPreviousDate = chkPreviousDate;
	}
	public String getStrPreviousDate() {
		return strPreviousDate;
	}
	public void setStrPreviousDate(String strPreviousDate) {
		this.strPreviousDate = strPreviousDate;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getTemplateID() {
		return templateID;
	}
	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}
	public String getCIDNo() {
		return cIDNo;
	}
	public void setCIDNo(String cIDNo) {
		this.cIDNo = cIDNo;
	}
	public String getExtReferStatus() {
		return extReferStatus;
	}
	public void setExtReferStatus(String extReferStatus) {
		this.extReferStatus = extReferStatus;
	}
	public String getIsImageUploaded() {
		return isImageUploaded;
	}
	public void setIsImageUploaded(String extReferStatus) {
		this.extReferStatus = extReferStatus;
	}
	
}
