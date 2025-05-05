package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosegeIndicationDAO.
 */
public class DrugDosegeIndicationDAO {
	// private final String strProcName = "";
	/** The str file name. */
	private final String strFileName = "mms.dao.DrugDosegeIndicationDAO";

	/** ************Variable******************. */
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

	private String strEffectiveFrom = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str lst mod seat id. */
	private String strLstModSeatId = "";
	
	/** The str lst mod date. */
	private String strLstModDate = "";
	
	/** The str entry date. */
	private String strEntryDate = "";
	
	/** The str last modified date. */
	private String strLastModifiedDate = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str last modified seat id. */
	private String strLastModifiedSeatId = "";
	
	/** The str is valid. */
	private String strIsValid = "1";
	
	/** The str hospital code. */
	private String strHospitalCode = "";
	
	private String strSlNo;

	/** ************Variable******************. */

	private String strErr = "";
	
	/** The n row inserted. */
	private int nRowInserted = 0;
	
	/** The n row updated. */
	private int nRowUpdated = 0;
	
	/** The n row deleted. */
	private int nRowDeleted = 0;

	/** The n inserted index. */
	private int nInsertedIndex = 0;
	
	/** The n updated index. */
	private int nUpdatedIndex = 0;
	
	/** The n deleted index. */
	private int nDeletedIndex = 0;

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
	 * Gets the str lst mod seat id.
	 * 
	 * @return the str lst mod seat id
	 */
	public String getStrLstModSeatId() {
		return strLstModSeatId;
	}

	/**
	 * Sets the str lst mod seat id.
	 * 
	 * @param strLstModSeatId the new str lst mod seat id
	 */
	public void setStrLstModSeatId(String strLstModSeatId) {
		this.strLstModSeatId = strLstModSeatId;
	}

	/**
	 * Gets the str lst mod date.
	 * 
	 * @return the str lst mod date
	 */
	public String getStrLstModDate() {
		return strLstModDate;
	}

	/**
	 * Sets the str lst mod date.
	 * 
	 * @param strLstModDate the new str lst mod date
	 */
	public void setStrLstModDate(String strLstModDate) {
		this.strLstModDate = strLstModDate;
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
	 * Gets the str last modified date.
	 * 
	 * @return the str last modified date
	 */
	public String getStrLastModifiedDate() {
		return strLastModifiedDate;
	}

	/**
	 * Sets the str last modified date.
	 * 
	 * @param strLastModifiedDate the new str last modified date
	 */
	public void setStrLastModifiedDate(String strLastModifiedDate) {
		this.strLastModifiedDate = strLastModifiedDate;
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
	 * Gets the str last modified seat id.
	 * 
	 * @return the str last modified seat id
	 */
	public String getStrLastModifiedSeatId() {
		return strLastModifiedSeatId;
	}

	/**
	 * Sets the str last modified seat id.
	 * 
	 * @param strLastModifiedSeatId the new str last modified seat id
	 */
	public void setStrLastModifiedSeatId(String strLastModifiedSeatId) {
		this.strLastModifiedSeatId = strLastModifiedSeatId;
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
	 * Gets the str err.
	 * 
	 * @return the str err
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Sets the str err.
	 * 
	 * @param strErr the new str err
	 */
	public void setStrErr(String strErr) {
		this.strErr = strErr;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return the n row inserted
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return the n row updated
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Sets the n row updated.
	 * 
	 * @param rowUpdated the new n row updated
	 */
	public void setNRowUpdated(int rowUpdated) {
		nRowUpdated = rowUpdated;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return the n row deleted
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return the n inserted index
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Sets the n inserted index.
	 * 
	 * @param insertedIndex the new n inserted index
	 */
	public void setNInsertedIndex(int insertedIndex) {
		nInsertedIndex = insertedIndex;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return the n updated index
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return the n deleted index
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Sets the n deleted index.
	 * 
	 * @param deletedIndex the new n deleted index
	 */
	public void setNDeletedIndex(int deletedIndex) {
		nDeletedIndex = deletedIndex;
	}

	/**
	 * This method will be used to insert the records.
	 * 
	 * @param dao :
	 * HisDAO Object
	 * 
	 * @throws Exception -
	 * when BillNo. or Receipt No. or Serial No. is blank
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.insert.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHstnumItemId);

			dao.setQryValue(nQueryIndex, 2, strHospitalCode);

			dao.setQryValue(nQueryIndex, 3, strHstrOral);

			dao.setQryValue(nQueryIndex, 4, strHstrIntervanous);

			dao.setQryValue(nQueryIndex, 5, strHstrParentreal);

			dao.setQryValue(nQueryIndex, 6, strHstrOpthlamic);

			dao.setQryValue(nQueryIndex, 7, strHstrIntraActicular);

			dao.setQryValue(nQueryIndex, 8, strHstrTopical);

			dao.setQryValue(nQueryIndex, 9, strHstrAnyRoute);

			dao.setQryValue(nQueryIndex, 10, strHstrIntraMusclr);

			dao.setQryValue(nQueryIndex, 11, strHstrMiclanus);

			dao.setQryValue(nQueryIndex, 12, strHstrOtic);

			dao.setQryValue(nQueryIndex, 13, strHstrMouth);

			dao.setQryValue(nQueryIndex, 14, strHstrRectal);

			dao.setQryValue(nQueryIndex, 15, strHstrNasal);

			dao.setQryValue(nQueryIndex, 16, strHstrInhalton);

			dao.setQryValue(nQueryIndex, 17, strHstrVaginal);

			dao.setQryValue(nQueryIndex, 18, strHstrLingual);

			dao.setQryValue(nQueryIndex, 19, strHstrIntraThecal);

			dao.setQryValue(nQueryIndex, 20, strHstrIntraLesioNal);

			dao.setQryValue(nQueryIndex, 21, strHstrExtraAmniotic);

			dao.setQryValue(nQueryIndex, 22, strHstrEpidural);

			dao.setQryValue(nQueryIndex, 23, strHstrIntraSpinal);

			dao.setQryValue(nQueryIndex, 24, strHstrSubCuta);

			dao.setQryValue(nQueryIndex, 25, strHstrIntraVesical);

			dao.setQryValue(nQueryIndex, 26, strHstrIntraDermal);

			dao.setQryValue(nQueryIndex, 27, strHstrTrensDrml);

			dao.setQryValue(nQueryIndex, 28, strRemarks);

			dao.setQryValue(nQueryIndex, 29, strEffectiveFrom);

			// dao.setQryValue(nQueryIndex, 30, strLstModSeatId );

			// dao.setQryValue(nQueryIndex, 31, strLstModDate );

			dao.setQryValue(nQueryIndex, 30, strEntryDate);

			dao.setQryValue(nQueryIndex, 31, strSeatId);

			dao.setQryValue(nQueryIndex, 32, strIsValid);

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName + ".insert() --> " + this.strErr);

		} finally {

			this.reset();

		}
	}

	/**
	 * Update.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void update(HisDAO dao) throws Exception {
		strErr = "";

		try {
			int nQueryIndex = 0;

			String strQuery = null;

			strQuery = mms.qryHandler_mms.getQuery(1,
					"select.drugDosIndicationMst.update.0");

			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, strHstrOral);

			dao.setQryValue(nQueryIndex, 2, strHstrIntervanous);

			dao.setQryValue(nQueryIndex, 3, strHstrParentreal);

			dao.setQryValue(nQueryIndex, 4, strHstrOpthlamic);

			dao.setQryValue(nQueryIndex, 5, strHstrIntraActicular);

			dao.setQryValue(nQueryIndex, 6, strHstrTopical);

			dao.setQryValue(nQueryIndex, 7, strHstrAnyRoute);

			dao.setQryValue(nQueryIndex, 8, strHstrIntraMusclr);

			dao.setQryValue(nQueryIndex, 9, strHstrMiclanus);

			dao.setQryValue(nQueryIndex, 10, strHstrOtic);

			dao.setQryValue(nQueryIndex, 11, strHstrMouth);

			dao.setQryValue(nQueryIndex, 12, strHstrRectal);

			dao.setQryValue(nQueryIndex, 13, strHstrNasal);

			dao.setQryValue(nQueryIndex, 14, strHstrInhalton);

			dao.setQryValue(nQueryIndex, 15, strHstrVaginal);

			dao.setQryValue(nQueryIndex, 16, strHstrLingual);

			dao.setQryValue(nQueryIndex, 17, strHstrIntraThecal);

			dao.setQryValue(nQueryIndex, 18, strHstrIntraLesioNal);

			dao.setQryValue(nQueryIndex, 19, strHstrExtraAmniotic);

			dao.setQryValue(nQueryIndex, 20, strHstrEpidural);

			dao.setQryValue(nQueryIndex, 21, strHstrIntraSpinal);

			dao.setQryValue(nQueryIndex, 22, strHstrSubCuta);

			dao.setQryValue(nQueryIndex, 23, strHstrIntraVesical);

			dao.setQryValue(nQueryIndex, 24, strHstrIntraDermal);

			dao.setQryValue(nQueryIndex, 25, strHstrTrensDrml);

			dao.setQryValue(nQueryIndex, 26, strEffectiveFrom);

			// dao.setQryValue(nQueryIndex, 27, strLstModDate );
			// //System.out.println("strLstModDate:::"+strLstModDate);

			dao.setQryValue(nQueryIndex, 27, strLstModSeatId);

			dao.setQryValue(nQueryIndex, 28, strRemarks);

			dao.setQryValue(nQueryIndex, 29, strSeatId);

			dao.setQryValue(nQueryIndex, 30, strIsValid);

			dao.setQryValue(nQueryIndex, 31, strHstnumItemId);

			dao.setQryValue(nQueryIndex, 32, strHospitalCode);

			dao.execute(nQueryIndex, 0);

			this.nRowInserted++;

		} catch (Exception e) {

			this.strErr = e.getMessage();

			throw new Exception(strFileName + ".update() --> " + this.strErr);

		} finally {

			this.reset();

		}

	}

	/**
	 * Reset.
	 */
	public void reset() {

		strHstrOral = "";
		strHstrIntervanous = "";
		strHstrParentreal = "";
		strHstrOpthlamic = "";
		strHstrIntraActicular = "";
		strHstrTopical = "";
		strHstrAnyRoute = "";
		strHstrIntraMusclr = "";
		strHstrMiclanus = "";
		strHstrOtic = "";
		strHstrMouth = "";
		strHstrRectal = "";
		strHstrNasal = "";
		strHstrInhalton = "";
		strHstrVaginal = "";
		strHstrLingual = "";
		strHstrIntraThecal = "";
		strHstrIntraLesioNal = "";
		strHstrExtraAmniotic = "";
		strHstrEpidural = "";
		strHstrIntraSpinal = "";
		strHstrSubCuta = "";
		strHstrIntraVesical = "";
		strHstrIntraDermal = "";
		strHstrTrensDrml = "";
		strEffectiveFrom = "";
		strRemarks = "";
		strEntryDate = "";
		strLastModifiedDate = "";
		strSeatId = "";
		strLastModifiedSeatId = "";
		strIsValid = "";
		strHospitalCode = "";

	}

	public String getStrSlNo() {
		return strSlNo;
	}

	public void setStrSlNo(String strSlNo) {
		this.strSlNo = strSlNo;
	}

}
