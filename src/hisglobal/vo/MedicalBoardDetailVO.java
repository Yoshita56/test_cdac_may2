package hisglobal.vo;

public class MedicalBoardDetailVO extends ValueObject{

	private String boardNo;
	private String slNo;
	private String boardStartTime;
	private String actualDateTime;
	private String certificateTypeID;
	private String location; 
	private String boardStatus;
	private String closeDateTime;
	private String approvedDate;
	private String approvedBy;
	private String boardID;
	
	
	
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}
	public String getBoardStartTime() {
		return boardStartTime;
	}
	public void setBoardStartTime(String boardStartTime) {
		this.boardStartTime = boardStartTime;
	}
	public String getActualDateTime() {
		return actualDateTime;
	}
	public void setActualDateTime(String actualDateTime) {
		this.actualDateTime = actualDateTime;
	}
	public String getCertificateTypeID() {
		return certificateTypeID;
	}
	public void setCertificateTypeID(String certificateTypeID) {
		this.certificateTypeID = certificateTypeID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}
	public String getCloseDateTime() {
		return closeDateTime;
	}
	public void setCloseDateTime(String closeDateTime) {
		this.closeDateTime = closeDateTime;
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
	public String getBoardID() {
		return boardID;
	}
	public void setBoardID(String boardID) {
		this.boardID = boardID;
	}

}
