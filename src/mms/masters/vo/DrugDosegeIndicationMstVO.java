package mms.masters.vo;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosegeIndicationMstVO.
 */
public class DrugDosegeIndicationMstVO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The B exist status. */
	private Boolean BExistStatus = false;
	
	/** The str msg string. */
	private String strMsgString = "";
	
	/** The str msg type. */
	private String strMsgType = "";

	/** The str ct date. */
	private String strCtDate = "";

	/** The str data ws. */
	private WebRowSet strDataWs = null;
	
	/** The str added data ws. */
	private WebRowSet strAddedDataWs = null;

	/** The str added data. */
	private String[] strAddedData = { "0" };

	/** The str msg. */
	private String strMsg = "";
	
	/** The str warning. */
	private String strWarning = "";
	
	/** The str error msg. */
	private String strErrorMsg = "";

	/** The str hospital code. */
	private String strHospitalCode = "";
	
	/** The str group id. */
	private String strGroupId = "";

	/** The str sub grp id. */
	private String strSubGrpId = "";

	/** The str grp id. */
	private String strGrpId = "";
	// private String strItemId = "";

	/** The str item id. */
	private String strItemID = "";

	/** The str store type id. */
	private String strStoreTypeId = "";
	
	/** The str remarks. */
	private String strRemarks = "";

	/** The str last mode seat id. */
	private String strLastModeSeatId = "";
	
	/** The str last mode date. */
	private String strLastModeDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "";
	
	/** The str chk1. */
	private String strChk1 = "";

	/** The str drug name. */
	private String strDrugName = "";
	
	/** The str drug name combo. */
	private String strDrugNameCombo = "";
	
	/** The str effective from. */
	private String strEffectiveFrom = "";
	
	/** The str group name combo. */
	private String strGroupNameCombo = "";
	
	/** The str group name. */
	private String strGroupName = "";
	
	/** The str sub group name. */
	private String strSubGroupName = "";
	
	/** The str sub group name combo. */
	private String strSubGroupNameCombo = "";

	/** The str hstnum item id. */
	private String strHstnumItemId = "";
	
	/** *******25*******. */
	private String strHstrOral = "";
	
	/** The str hstr intervanous. */
	private String strHstrIntervanous = "";
	
	/** The str hstr parentreal. */
	private String strHstrParentreal = "";
	
	/** The str hstr opthlamic. */
	private String strHstrOpthlamic = "";
	
	/** The str hstr intra acticular. */
	private String strHstrIntraActicular = "";
	
	/** The str hstr topical. */
	private String strHstrTopical = "";
	
	/** The str hstr any route. */
	private String strHstrAnyRoute = "";
	
	/** The str hstr intra musclr. */
	private String strHstrIntraMusclr = "";
	
	/** The str hstr miclanus. */
	private String strHstrMiclanus = "";
	
	/** The str hstr otic. */
	private String strHstrOtic = "";
	
	/** The str hstr mouth. */
	private String strHstrMouth = "";
	
	/** The str hstr rectal. */
	private String strHstrRectal = "";
	
	/** The str hstr nasal. */
	private String strHstrNasal = "";
	
	/** The str hstr inhalton. */
	private String strHstrInhalton = "";
	
	/** The str hstr vaginal. */
	private String strHstrVaginal = "";
	
	/** The str hstr lingual. */
	private String strHstrLingual = "";
	
	/** The str hstr intra thecal. */
	private String strHstrIntraThecal = "";
	
	/** The str hstr intra lesio nal. */
	private String strHstrIntraLesioNal = "";
	
	/** The str hstr extra amniotic. */
	private String strHstrExtraAmniotic = "";
	
	/** The str hstr epidural. */
	private String strHstrEpidural = "";
	
	/** The str hstr intra spinal. */
	private String strHstrIntraSpinal = "";
	
	/** The str hstr sub cuta. */
	private String strHstrSubCuta = "";
	
	/** The str hstr intra vesical. */
	private String strHstrIntraVesical = "";
	
	/** The str hstr intra dermal. */
	private String strHstrIntraDermal = "";
	
	/** The str hstr trens drml. */
	private String strHstrTrensDrml = "";
	
	/** *******25*******. */

	private WebRowSet strGroupNameComboValuesWS = null;
	
	/** The str sub group name combo values ws. */
	private WebRowSet strSubGroupNameComboValuesWS = null;
	
	/** The str drug name combo values ws. */
	private WebRowSet strDrugNameComboValuesWS = null;

	/**
	 * Gets the str group name combo values ws.
	 * 
	 * @return the strGroupNameComboValuesWS
	 */
	public WebRowSet getStrGroupNameComboValuesWS() {
		return strGroupNameComboValuesWS;
	}

	/**
	 * Sets the str group name combo values ws.
	 * 
	 * @param strGroupNameComboValuesWS the strGroupNameComboValuesWS to set
	 */
	public void setStrGroupNameComboValuesWS(WebRowSet strGroupNameComboValuesWS) {
		this.strGroupNameComboValuesWS = strGroupNameComboValuesWS;
	}

	/**
	 * Gets the str sub group name combo values ws.
	 * 
	 * @return the strSubGroupNameComboValuesWS
	 */
	public WebRowSet getStrSubGroupNameComboValuesWS() {
		return strSubGroupNameComboValuesWS;
	}

	/**
	 * Sets the str sub group name combo values ws.
	 * 
	 * @param strSubGroupNameComboValuesWS the strSubGroupNameComboValuesWS to set
	 */
	public void setStrSubGroupNameComboValuesWS(
			WebRowSet strSubGroupNameComboValuesWS) {
		this.strSubGroupNameComboValuesWS = strSubGroupNameComboValuesWS;
	}

	/**
	 * Gets the str group name combo.
	 * 
	 * @return the str group name combo
	 */
	public String getStrGroupNameCombo() {
		return strGroupNameCombo;
	}

	/**
	 * Sets the str group name combo.
	 * 
	 * @param strGroupNameCombo the new str group name combo
	 */
	public void setStrGroupNameCombo(String strGroupNameCombo) {
		this.strGroupNameCombo = strGroupNameCombo;
	}

	/**
	 * Gets the str ct date.
	 * 
	 * @return the strCtDate
	 */
	public String getStrCtDate() {
		return strCtDate;
	}

	/**
	 * Sets the str ct date.
	 * 
	 * @param strCtDate the strCtDate to set
	 */
	public void setStrCtDate(String strCtDate) {
		this.strCtDate = strCtDate;
	}

	/**
	 * Gets the b exist status.
	 * 
	 * @return the b exist status
	 */
	public Boolean getBExistStatus() {
		return BExistStatus;
	}

	/**
	 * Sets the b exist status.
	 * 
	 * @param existStatus the new b exist status
	 */
	public void setBExistStatus(Boolean existStatus) {
		BExistStatus = existStatus;
	}

	/**
	 * Gets the str msg string.
	 * 
	 * @return the str msg string
	 */
	public String getStrMsgString() {
		return strMsgString;
	}

	/**
	 * Sets the str msg string.
	 * 
	 * @param strMsgString the new str msg string
	 */
	public void setStrMsgString(String strMsgString) {
		this.strMsgString = strMsgString;
	}

	/**
	 * Gets the str msg type.
	 * 
	 * @return the str msg type
	 */
	public String getStrMsgType() {
		return strMsgType;
	}

	/**
	 * Sets the str msg type.
	 * 
	 * @param strMsgType the new str msg type
	 */
	public void setStrMsgType(String strMsgType) {
		this.strMsgType = strMsgType;
	}

	/**
	 * Gets the str hospital code.
	 * 
	 * @return the str hospital code
	 */
	public String getStrHospitalCode() {
		return strHospitalCode;
	}

	/**
	 * Sets the str hospital code.
	 * 
	 * @param strHospitalCode the new str hospital code
	 */
	public void setStrHospitalCode(String strHospitalCode) {
		this.strHospitalCode = strHospitalCode;
	}

	/**
	 * Gets the str group id.
	 * 
	 * @return the str group id
	 */
	public String getStrGroupId() {
		return strGroupId;
	}

	/**
	 * Sets the str group id.
	 * 
	 * @param strGroupId the new str group id
	 */
	public void setStrGroupId(String strGroupId) {
		this.strGroupId = strGroupId;
	}

	/**
	 * Gets the str group name.
	 * 
	 * @return the str group name
	 */
	public String getStrGroupName() {
		return strGroupName;
	}

	/**
	 * Sets the str group name.
	 * 
	 * @param strGroupName the new str group name
	 */
	public void setStrGroupName(String strGroupName) {
		this.strGroupName = strGroupName;
	}

	/**
	 * Gets the str store type id.
	 * 
	 * @return the str store type id
	 */
	public String getStrStoreTypeId() {
		return strStoreTypeId;
	}

	/**
	 * Sets the str store type id.
	 * 
	 * @param strStoreTypeId the new str store type id
	 */
	public void setStrStoreTypeId(String strStoreTypeId) {
		this.strStoreTypeId = strStoreTypeId;
	}

	/**
	 * Gets the str remarks.
	 * 
	 * @return the str remarks
	 */
	public String getStrRemarks() {
		return strRemarks;
	}

	/**
	 * Sets the str remarks.
	 * 
	 * @param strRemarks the new str remarks
	 */
	public void setStrRemarks(String strRemarks) {
		this.strRemarks = strRemarks;
	}

	/**
	 * Gets the str effective from.
	 * 
	 * @return the str effective from
	 */
	public String getStrEffectiveFrom() {
		return strEffectiveFrom;
	}

	/**
	 * Sets the str effective from.
	 * 
	 * @param strEffectiveFrom the new str effective from
	 */
	public void setStrEffectiveFrom(String strEffectiveFrom) {
		this.strEffectiveFrom = strEffectiveFrom;
	}

	/**
	 * Gets the str last mode seat id.
	 * 
	 * @return the str last mode seat id
	 */
	public String getStrLastModeSeatId() {
		return strLastModeSeatId;
	}

	/**
	 * Sets the str last mode seat id.
	 * 
	 * @param strLastModeSeatId the new str last mode seat id
	 */
	public void setStrLastModeSeatId(String strLastModeSeatId) {
		this.strLastModeSeatId = strLastModeSeatId;
	}

	/**
	 * Gets the str last mode date.
	 * 
	 * @return the str last mode date
	 */
	public String getStrLastModeDate() {
		return strLastModeDate;
	}

	/**
	 * Sets the str last mode date.
	 * 
	 * @param strLastModeDate the new str last mode date
	 */
	public void setStrLastModeDate(String strLastModeDate) {
		this.strLastModeDate = strLastModeDate;
	}

	/**
	 * Gets the str entry date.
	 * 
	 * @return the str entry date
	 */
	public String getStrEntryDate() {
		return strEntryDate;
	}

	/**
	 * Sets the str entry date.
	 * 
	 * @param strEntryDate the new str entry date
	 */
	public void setStrEntryDate(String strEntryDate) {
		this.strEntryDate = strEntryDate;
	}

	/**
	 * Gets the str seat id.
	 * 
	 * @return the str seat id
	 */
	public String getStrSeatId() {
		return strSeatId;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * Gets the str is valid.
	 * 
	 * @return the str is valid
	 */
	public String getStrIsValid() {
		return strIsValid;
	}

	/**
	 * Sets the str is valid.
	 * 
	 * @param strIsValid the new str is valid
	 */
	public void setStrIsValid(String strIsValid) {
		this.strIsValid = strIsValid;
	}

	/**
	 * Gets the str chk1.
	 * 
	 * @return the str chk1
	 */
	public String getStrChk1() {
		return strChk1;
	}

	/**
	 * Sets the str chk1.
	 * 
	 * @param strChk1 the new str chk1
	 */
	public void setStrChk1(String strChk1) {
		this.strChk1 = strChk1;
	}

	/**
	 * Gets the str msg.
	 * 
	 * @return the str msg
	 */
	public String getStrMsg() {
		return strMsg;
	}

	/**
	 * Sets the str msg.
	 * 
	 * @param strMsg the new str msg
	 */
	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	/**
	 * Gets the str warning.
	 * 
	 * @return the str warning
	 */
	public String getStrWarning() {
		return strWarning;
	}

	/**
	 * Sets the str warning.
	 * 
	 * @param strWarning the new str warning
	 */
	public void setStrWarning(String strWarning) {
		this.strWarning = strWarning;
	}

	/**
	 * Gets the str error msg.
	 * 
	 * @return the str error msg
	 */
	public String getStrErrorMsg() {
		return strErrorMsg;
	}

	/**
	 * Sets the str error msg.
	 * 
	 * @param strErrorMsg the new str error msg
	 */
	public void setStrErrorMsg(String strErrorMsg) {
		this.strErrorMsg = strErrorMsg;
	}

	/**
	 * Gets the str drug name.
	 * 
	 * @return the str drug name
	 */
	public String getStrDrugName() {
		return strDrugName;
	}

	/**
	 * Sets the str drug name.
	 * 
	 * @param strDrugName the new str drug name
	 */
	public void setStrDrugName(String strDrugName) {
		this.strDrugName = strDrugName;
	}

	/**
	 * Gets the str drug name combo.
	 * 
	 * @return the str drug name combo
	 */
	public String getStrDrugNameCombo() {
		return strDrugNameCombo;
	}

	/**
	 * Sets the str drug name combo.
	 * 
	 * @param strDrugNameCombo the new str drug name combo
	 */
	public void setStrDrugNameCombo(String strDrugNameCombo) {
		this.strDrugNameCombo = strDrugNameCombo;
	}

	/**
	 * Gets the str sub group name.
	 * 
	 * @return the str sub group name
	 */
	public String getStrSubGroupName() {
		return strSubGroupName;
	}

	/**
	 * Sets the str sub group name.
	 * 
	 * @param strSubGroupName the new str sub group name
	 */
	public void setStrSubGroupName(String strSubGroupName) {
		this.strSubGroupName = strSubGroupName;
	}

	/**
	 * Gets the str sub group name combo.
	 * 
	 * @return the str sub group name combo
	 */
	public String getStrSubGroupNameCombo() {
		return strSubGroupNameCombo;
	}

	/**
	 * Sets the str sub group name combo.
	 * 
	 * @param strSubGroupNameCombo the new str sub group name combo
	 */
	public void setStrSubGroupNameCombo(String strSubGroupNameCombo) {
		this.strSubGroupNameCombo = strSubGroupNameCombo;
	}

	/**
	 * Gets the str hstnum item id.
	 * 
	 * @return the str hstnum item id
	 */
	public String getStrHstnumItemId() {
		return strHstnumItemId;
	}

	/**
	 * Sets the str hstnum item id.
	 * 
	 * @param strHstnumItemId the new str hstnum item id
	 */
	public void setStrHstnumItemId(String strHstnumItemId) {
		this.strHstnumItemId = strHstnumItemId;
	}

	/**
	 * Gets the str hstr oral.
	 * 
	 * @return the str hstr oral
	 */
	public String getStrHstrOral() {
		return strHstrOral;
	}

	/**
	 * Sets the str hstr oral.
	 * 
	 * @param strHstrOral the new str hstr oral
	 */
	public void setStrHstrOral(String strHstrOral) {
		this.strHstrOral = strHstrOral;
	}

	/**
	 * Gets the str hstr intervanous.
	 * 
	 * @return the str hstr intervanous
	 */
	public String getStrHstrIntervanous() {
		return strHstrIntervanous;
	}

	/**
	 * Sets the str hstr intervanous.
	 * 
	 * @param strHstrIntervanous the new str hstr intervanous
	 */
	public void setStrHstrIntervanous(String strHstrIntervanous) {
		this.strHstrIntervanous = strHstrIntervanous;
	}

	/**
	 * Gets the str hstr parentreal.
	 * 
	 * @return the str hstr parentreal
	 */
	public String getStrHstrParentreal() {
		return strHstrParentreal;
	}

	/**
	 * Sets the str hstr parentreal.
	 * 
	 * @param strHstrParentreal the new str hstr parentreal
	 */
	public void setStrHstrParentreal(String strHstrParentreal) {
		this.strHstrParentreal = strHstrParentreal;
	}

	/**
	 * Gets the str hstr opthlamic.
	 * 
	 * @return the str hstr opthlamic
	 */
	public String getStrHstrOpthlamic() {
		return strHstrOpthlamic;
	}

	/**
	 * Sets the str hstr opthlamic.
	 * 
	 * @param strHstrOpthlamic the new str hstr opthlamic
	 */
	public void setStrHstrOpthlamic(String strHstrOpthlamic) {
		this.strHstrOpthlamic = strHstrOpthlamic;
	}

	/**
	 * Gets the str hstr intra acticular.
	 * 
	 * @return the str hstr intra acticular
	 */
	public String getStrHstrIntraActicular() {
		return strHstrIntraActicular;
	}

	/**
	 * Sets the str hstr intra acticular.
	 * 
	 * @param strHstrIntraActicular the new str hstr intra acticular
	 */
	public void setStrHstrIntraActicular(String strHstrIntraActicular) {
		this.strHstrIntraActicular = strHstrIntraActicular;
	}

	/**
	 * Gets the str hstr topical.
	 * 
	 * @return the str hstr topical
	 */
	public String getStrHstrTopical() {
		return strHstrTopical;
	}

	/**
	 * Sets the str hstr topical.
	 * 
	 * @param strHstrTopical the new str hstr topical
	 */
	public void setStrHstrTopical(String strHstrTopical) {
		this.strHstrTopical = strHstrTopical;
	}

	/**
	 * Gets the str hstr any route.
	 * 
	 * @return the str hstr any route
	 */
	public String getStrHstrAnyRoute() {
		return strHstrAnyRoute;
	}

	/**
	 * Sets the str hstr any route.
	 * 
	 * @param strHstrAnyRoute the new str hstr any route
	 */
	public void setStrHstrAnyRoute(String strHstrAnyRoute) {
		this.strHstrAnyRoute = strHstrAnyRoute;
	}

	/**
	 * Gets the str hstr intra musclr.
	 * 
	 * @return the str hstr intra musclr
	 */
	public String getStrHstrIntraMusclr() {
		return strHstrIntraMusclr;
	}

	/**
	 * Sets the str hstr intra musclr.
	 * 
	 * @param strHstrIntraMusclr the new str hstr intra musclr
	 */
	public void setStrHstrIntraMusclr(String strHstrIntraMusclr) {
		this.strHstrIntraMusclr = strHstrIntraMusclr;
	}

	/**
	 * Gets the str hstr miclanus.
	 * 
	 * @return the str hstr miclanus
	 */
	public String getStrHstrMiclanus() {
		return strHstrMiclanus;
	}

	/**
	 * Sets the str hstr miclanus.
	 * 
	 * @param strHstrMiclanus the new str hstr miclanus
	 */
	public void setStrHstrMiclanus(String strHstrMiclanus) {
		this.strHstrMiclanus = strHstrMiclanus;
	}

	/**
	 * Gets the str hstr otic.
	 * 
	 * @return the str hstr otic
	 */
	public String getStrHstrOtic() {
		return strHstrOtic;
	}

	/**
	 * Sets the str hstr otic.
	 * 
	 * @param strHstrOtic the new str hstr otic
	 */
	public void setStrHstrOtic(String strHstrOtic) {
		this.strHstrOtic = strHstrOtic;
	}

	/**
	 * Gets the str hstr mouth.
	 * 
	 * @return the str hstr mouth
	 */
	public String getStrHstrMouth() {
		return strHstrMouth;
	}

	/**
	 * Sets the str hstr mouth.
	 * 
	 * @param strHstrMouth the new str hstr mouth
	 */
	public void setStrHstrMouth(String strHstrMouth) {
		this.strHstrMouth = strHstrMouth;
	}

	/**
	 * Gets the str hstr rectal.
	 * 
	 * @return the str hstr rectal
	 */
	public String getStrHstrRectal() {
		return strHstrRectal;
	}

	/**
	 * Sets the str hstr rectal.
	 * 
	 * @param strHstrRectal the new str hstr rectal
	 */
	public void setStrHstrRectal(String strHstrRectal) {
		this.strHstrRectal = strHstrRectal;
	}

	/**
	 * Gets the str hstr nasal.
	 * 
	 * @return the str hstr nasal
	 */
	public String getStrHstrNasal() {
		return strHstrNasal;
	}

	/**
	 * Sets the str hstr nasal.
	 * 
	 * @param strHstrNasal the new str hstr nasal
	 */
	public void setStrHstrNasal(String strHstrNasal) {
		this.strHstrNasal = strHstrNasal;
	}

	/**
	 * Gets the str hstr inhalton.
	 * 
	 * @return the str hstr inhalton
	 */
	public String getStrHstrInhalton() {
		return strHstrInhalton;
	}

	/**
	 * Sets the str hstr inhalton.
	 * 
	 * @param strHstrInhalton the new str hstr inhalton
	 */
	public void setStrHstrInhalton(String strHstrInhalton) {
		this.strHstrInhalton = strHstrInhalton;
	}

	/**
	 * Gets the str hstr vaginal.
	 * 
	 * @return the str hstr vaginal
	 */
	public String getStrHstrVaginal() {
		return strHstrVaginal;
	}

	/**
	 * Sets the str hstr vaginal.
	 * 
	 * @param strHstrVaginal the new str hstr vaginal
	 */
	public void setStrHstrVaginal(String strHstrVaginal) {
		this.strHstrVaginal = strHstrVaginal;
	}

	/**
	 * Gets the str hstr lingual.
	 * 
	 * @return the str hstr lingual
	 */
	public String getStrHstrLingual() {
		return strHstrLingual;
	}

	/**
	 * Sets the str hstr lingual.
	 * 
	 * @param strHstrLingual the new str hstr lingual
	 */
	public void setStrHstrLingual(String strHstrLingual) {
		this.strHstrLingual = strHstrLingual;
	}

	/**
	 * Gets the str hstr intra thecal.
	 * 
	 * @return the str hstr intra thecal
	 */
	public String getStrHstrIntraThecal() {
		return strHstrIntraThecal;
	}

	/**
	 * Sets the str hstr intra thecal.
	 * 
	 * @param strHstrIntraThecal the new str hstr intra thecal
	 */
	public void setStrHstrIntraThecal(String strHstrIntraThecal) {
		this.strHstrIntraThecal = strHstrIntraThecal;
	}

	/**
	 * Gets the str hstr intra lesio nal.
	 * 
	 * @return the str hstr intra lesio nal
	 */
	public String getStrHstrIntraLesioNal() {
		return strHstrIntraLesioNal;
	}

	/**
	 * Sets the str hstr intra lesio nal.
	 * 
	 * @param strHstrIntraLesioNal the new str hstr intra lesio nal
	 */
	public void setStrHstrIntraLesioNal(String strHstrIntraLesioNal) {
		this.strHstrIntraLesioNal = strHstrIntraLesioNal;
	}

	/**
	 * Gets the str hstr extra amniotic.
	 * 
	 * @return the str hstr extra amniotic
	 */
	public String getStrHstrExtraAmniotic() {
		return strHstrExtraAmniotic;
	}

	/**
	 * Sets the str hstr extra amniotic.
	 * 
	 * @param strHstrExtraAmniotic the new str hstr extra amniotic
	 */
	public void setStrHstrExtraAmniotic(String strHstrExtraAmniotic) {
		this.strHstrExtraAmniotic = strHstrExtraAmniotic;
	}

	/**
	 * Gets the str hstr epidural.
	 * 
	 * @return the str hstr epidural
	 */
	public String getStrHstrEpidural() {
		return strHstrEpidural;
	}

	/**
	 * Sets the str hstr epidural.
	 * 
	 * @param strHstrEpidural the new str hstr epidural
	 */
	public void setStrHstrEpidural(String strHstrEpidural) {
		this.strHstrEpidural = strHstrEpidural;
	}

	/**
	 * Gets the str hstr intra spinal.
	 * 
	 * @return the str hstr intra spinal
	 */
	public String getStrHstrIntraSpinal() {
		return strHstrIntraSpinal;
	}

	/**
	 * Sets the str hstr intra spinal.
	 * 
	 * @param strHstrIntraSpinal the new str hstr intra spinal
	 */
	public void setStrHstrIntraSpinal(String strHstrIntraSpinal) {
		this.strHstrIntraSpinal = strHstrIntraSpinal;
	}

	/**
	 * Gets the str hstr sub cuta.
	 * 
	 * @return the str hstr sub cuta
	 */
	public String getStrHstrSubCuta() {
		return strHstrSubCuta;
	}

	/**
	 * Sets the str hstr sub cuta.
	 * 
	 * @param strHstrSubCuta the new str hstr sub cuta
	 */
	public void setStrHstrSubCuta(String strHstrSubCuta) {
		this.strHstrSubCuta = strHstrSubCuta;
	}

	/**
	 * Gets the str hstr intra vesical.
	 * 
	 * @return the str hstr intra vesical
	 */
	public String getStrHstrIntraVesical() {
		return strHstrIntraVesical;
	}

	/**
	 * Sets the str hstr intra vesical.
	 * 
	 * @param strHstrIntraVesical the new str hstr intra vesical
	 */
	public void setStrHstrIntraVesical(String strHstrIntraVesical) {
		this.strHstrIntraVesical = strHstrIntraVesical;
	}

	/**
	 * Gets the str hstr intra dermal.
	 * 
	 * @return the str hstr intra dermal
	 */
	public String getStrHstrIntraDermal() {
		return strHstrIntraDermal;
	}

	/**
	 * Sets the str hstr intra dermal.
	 * 
	 * @param strHstrIntraDermal the new str hstr intra dermal
	 */
	public void setStrHstrIntraDermal(String strHstrIntraDermal) {
		this.strHstrIntraDermal = strHstrIntraDermal;
	}

	/**
	 * Gets the str hstr trens drml.
	 * 
	 * @return the str hstr trens drml
	 */
	public String getStrHstrTrensDrml() {
		return strHstrTrensDrml;
	}

	/**
	 * Sets the str hstr trens drml.
	 * 
	 * @param strHstrTrensDrml the new str hstr trens drml
	 */
	public void setStrHstrTrensDrml(String strHstrTrensDrml) {
		this.strHstrTrensDrml = strHstrTrensDrml;
	}

	/**
	 * Gets the str added data.
	 * 
	 * @return the str added data
	 */
	public String[] getStrAddedData() {
		return strAddedData;
	}

	/**
	 * Sets the str added data.
	 * 
	 * @param strAddedData the new str added data
	 */
	public void setStrAddedData(String[] strAddedData) {
		this.strAddedData = strAddedData;
	}

	/**
	 * Gets the str data ws.
	 * 
	 * @return the str data ws
	 */
	public WebRowSet getStrDataWs() {
		return strDataWs;
	}

	/**
	 * Sets the str data ws.
	 * 
	 * @param strDataWs the new str data ws
	 */
	public void setStrDataWs(WebRowSet strDataWs) {
		this.strDataWs = strDataWs;
	}

	/**
	 * Gets the str added data ws.
	 * 
	 * @return the str added data ws
	 */
	public WebRowSet getStrAddedDataWs() {
		return strAddedDataWs;
	}

	/**
	 * Sets the str added data ws.
	 * 
	 * @param strAddedDataWs the new str added data ws
	 */
	public void setStrAddedDataWs(WebRowSet strAddedDataWs) {
		this.strAddedDataWs = strAddedDataWs;
	}

	/**
	 * Gets the str sub grp id.
	 * 
	 * @return the str sub grp id
	 */
	public String getStrSubGrpId() {
		return strSubGrpId;
	}

	/**
	 * Sets the str sub grp id.
	 * 
	 * @param strSubGrpId the new str sub grp id
	 */
	public void setStrSubGrpId(String strSubGrpId) {
		this.strSubGrpId = strSubGrpId;
	}

	/**
	 * Gets the str grp id.
	 * 
	 * @return the str grp id
	 */
	public String getStrGrpId() {
		return strGrpId;
	}

	/**
	 * Sets the str grp id.
	 * 
	 * @param strGrpId the new str grp id
	 */
	public void setStrGrpId(String strGrpId) {
		this.strGrpId = strGrpId;
	}

	/**
	 * Gets the str drug name combo values ws.
	 * 
	 * @return the strDrugNameComboValuesWS
	 */
	public WebRowSet getStrDrugNameComboValuesWS() {
		return strDrugNameComboValuesWS;
	}

	/**
	 * Sets the str drug name combo values ws.
	 * 
	 * @param strDrugNameComboValuesWS the strDrugNameComboValuesWS to set
	 */
	public void setStrDrugNameComboValuesWS(WebRowSet strDrugNameComboValuesWS) {
		this.strDrugNameComboValuesWS = strDrugNameComboValuesWS;
	}

	/**
	 * Gets the str item id.
	 * 
	 * @return the str item id
	 */
	public String getStrItemID() {
		return strItemID;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemID the new str item id
	 */
	public void setStrItemID(String strItemID) {
		this.strItemID = strItemID;
	}

}
