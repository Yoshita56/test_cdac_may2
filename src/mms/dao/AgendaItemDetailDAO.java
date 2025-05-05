package mms.dao;

import hisglobal.transactionmgnt.HisDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaItemDetailDAO.
 */
public class AgendaItemDetailDAO {

	/** The str proc name. */
	private final String strProcName = "pkg_mms_dml.dml_hstt_agenda_item_dtl";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.AgendaItemDetailDAO";
	
	/** The str hosp code. */
	private String strHospCode = "";
	
	/** The str store id. */
	private String strStoreId = "";
	
	/** The str agenda no. */
	private String strAgendaNo = "";
	
	/** The str item id. */
	private String strItemId = "";
	
	/** The str item brand id. */
	private String strItemBrandId = "";
	
	/** The str group id. */
	private String strGroupId = "";
	
	/** The str sub group id. */
	private String strSubGroupId = "";
	
	/** The str qty. */
	private String strQty = "";
	
	/** The str unit id. */
	private String strUnitId = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str lst po no. */
	private String strLstPoNo = "";
	
	/** The str lst supplier. */
	private String strLstSupplier = "";
	
	/** The str lst rate. */
	private String strLstRate = "";
	
	/** The str lst rate unit id. */
	private String strLstRateUnitId = "";
	
	/** The str categ no. */
	private String strCategNo = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str err. */
	private String strErr = "";
	
	/** The n row inserted. */
	private int nRowInserted = 0;
	
	private  String strInhandQty="";
	private  String strInhandUnitId="";
	private  String strPoDate="";
	private String strLastRecQty="";
	private String strLastRecQtyUnitId="";
	
	/** The n row updated. */
	private int nRowUpdated = 0;

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Sets the str store id.
	 * 
	 * @param strStoreId the new str store id
	 */
	public void setStrStoreId(String strStoreId) {
		this.strStoreId = strStoreId;
	}

	/**
	 * Sets the str item id.
	 * 
	 * @param strItemId the new str item id
	 */
	public void setStrItemId(String strItemId) {
		this.strItemId = strItemId;
	}

	/**
	 * Sets the str item brand id.
	 * 
	 * @param strItemBrandId the new str item brand id
	 */
	public void setStrItemBrandId(String strItemBrandId) {
		this.strItemBrandId = strItemBrandId;
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
	 * Sets the str sub group id.
	 * 
	 * @param strSubGroupId the new str sub group id
	 */
	public void setStrSubGroupId(String strSubGroupId) {
		this.strSubGroupId = strSubGroupId;
	}

	/**
	 * Sets the str qty.
	 * 
	 * @param strQty the new str qty
	 */
	public void setStrQty(String strQty) {
		this.strQty = strQty;
	}

	/**
	 * Sets the str unit id.
	 * 
	 * @param strUnitId the new str unit id
	 */
	public void setStrUnitId(String strUnitId) {
		this.strUnitId = strUnitId;
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
	 * Sets the str lst po no.
	 * 
	 * @param strLstPoNo the new str lst po no
	 */
	public void setStrLstPoNo(String strLstPoNo) {
		this.strLstPoNo = strLstPoNo;
	}

	/**
	 * Sets the str lst supplier.
	 * 
	 * @param strLstSupplier the new str lst supplier
	 */
	public void setStrLstSupplier(String strLstSupplier) {
		this.strLstSupplier = strLstSupplier;
	}

	/**
	 * Sets the str lst rate.
	 * 
	 * @param strLstRate the new str lst rate
	 */
	public void setStrLstRate(String strLstRate) {
		this.strLstRate = strLstRate;
	}

	/**
	 * Sets the str lst rate unit id.
	 * 
	 * @param strLstRateUnitId the new str lst rate unit id
	 */
	public void setStrLstRateUnitId(String strLstRateUnitId) {
		this.strLstRateUnitId = strLstRateUnitId;
	}

	/**
	 * Reset.
	 */
	public void reset() {
		strHospCode = "";
		strStoreId = "";
		strAgendaNo = "";
		strItemId = "";
		strItemBrandId = "";
		strGroupId = "";
		strSubGroupId = "";
		strQty = "";
		strUnitId = "";
		strRemarks = "";
		strLstPoNo = "";
		strLstSupplier = "";
		strLstRate = "";
		strLstRateUnitId = "";
	}

	/**
	 * Insert.
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {
		strErr = "";
		int nProcIndex = 0;

		try {

			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			dao.setProcInValue(nProcIndex, "modval", "1",1);       //1
			dao.setProcInValue(nProcIndex, "hosp_code", strHospCode.trim(),2); //2
			dao.setProcInValue(nProcIndex, "strId", strStoreId.trim(),3);      //3
			dao.setProcInValue(nProcIndex, "agendaNo", strAgendaNo.trim(),4);  //4
			dao.setProcInValue(nProcIndex, "itemId", strItemId.trim(),6);      //5
			dao.setProcInValue(nProcIndex, "itemBrandId", strItemBrandId.trim(),7);  //6
			dao.setProcInValue(nProcIndex, "strGroupId", strGroupId.trim(),8);       //7
			dao.setProcInValue(nProcIndex, "strSubGroupId", strSubGroupId.trim(),9); //8
			dao.setProcInValue(nProcIndex, "strQty", strQty.trim(),10);               //9 
			dao.setProcInValue(nProcIndex, "strUnitId", strUnitId.trim(),11);         //10
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim(),14);       //11
			dao.setProcInValue(nProcIndex, "strLstPoNo", strLstPoNo.trim(),19);       //12
			dao.setProcInValue(nProcIndex, "strLstSupplier", strLstSupplier.trim(),20); //13
			dao.setProcInValue(nProcIndex, "strLstRate", strLstRate.trim(),21);         //14
			dao.setProcInValue(nProcIndex, "strLstRateUnitId", strLstRateUnitId.trim(),28);//15
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo.trim(),29);     //16
			dao.setProcInValue(nProcIndex, "strInhandQty", strInhandQty.trim(),32); //17
			dao.setProcInValue(nProcIndex, "strInhandUnitId", strInhandUnitId.trim(),33); //18
			dao.setProcInValue(nProcIndex, "strPoDate", strPoDate.trim(),31); //19
			dao.setProcInValue(nProcIndex, "strLastRecQty", strLastRecQty.trim(),34);  //20
			dao.setProcInValue(nProcIndex, "strLastRecQtyUnitId", strLastRecQtyUnitId.trim(),35); //21			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "reqNo", "",5);   //22
			dao.setProcInValue(nProcIndex, "strCompiledQty", "",12);  //23
			dao.setProcInValue(nProcIndex, "strCompiledQtyUnit", "",13); //24
			dao.setProcInValue(nProcIndex, "strLstPurRate", "",15);  //25
			dao.setProcInValue(nProcIndex, "strLstPurRateUnit", "",16); //26
			dao.setProcInValue(nProcIndex, "strSancQty", "",17);  //27
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", "",18); //28
			dao.setProcInValue(nProcIndex, "strLstPoDate", "",22);   //29
			dao.setProcInValue(nProcIndex, "strLstRecQtyUnit", "",24); //30
			dao.setProcInValue(nProcIndex, "strApproxRate", "",25);  //31
			dao.setProcInValue(nProcIndex, "strLstRecDate", "",26);  //32
			dao.setProcInValue(nProcIndex, "strApproxRateUnit", "",27);//33
			dao.setProcInValue(nProcIndex, "strSeatId", "",30);  //34
			dao.setProcInValue(nProcIndex, "strLstRecQty", "",23); //35
			dao.setProcInValue(nProcIndex, "indent_no", "",36);  //36
			dao.setProcInValue(nProcIndex, "raising_store", "",37); //37
			dao.setProcInValue(nProcIndex, "indent_date", "",38); //38
			dao.setProcInValue(nProcIndex, "indent_period", "",39); //39
			dao.setProcInValue(nProcIndex, "reqFlag", "0",40); //40
			dao.setProcInValue(nProcIndex, "itemFlag", "0",41); //41
			dao.setProcInValue(nProcIndex, "lstItemFlag", "0",42);//42
			/* Setting Default Value End */			
			dao.setProcOutValue(nProcIndex, "err", 1,43); //43
			dao.execute(nProcIndex, 1);
			this.nRowInserted++;
		} catch (Exception e) {
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
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
		int nProcIndex = 0;

		try {
			nProcIndex = dao.setProcedure("{call " + strProcName
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			dao.setProcInValue(nProcIndex, "modval", "2",1);
			dao.setProcInValue(nProcIndex, "hosp_code",strHospCode.trim(),2);
			dao.setProcInValue(nProcIndex, "strId", strStoreId.trim(),3);
			dao.setProcInValue(nProcIndex, "agendaNo", strAgendaNo.trim(),4);
			dao.setProcInValue(nProcIndex, "itemId", strItemId.trim(),6);
			dao	.setProcInValue(nProcIndex, "itemBrandId", strItemBrandId
							.trim(),7);
			dao.setProcInValue(nProcIndex, "strRemarks", strRemarks.trim(),14);
			dao.setProcInValue(nProcIndex, "strCategNo", strCategNo.trim(),29);
			dao.setProcInValue(nProcIndex, "strSeatId", strSeatId.trim(),30);
			
			/* Setting Default Value Start*/
			dao.setProcInValue(nProcIndex, "reqNo", "",5);
			dao.setProcInValue(nProcIndex, "strGroupId", "",8);
			dao.setProcInValue(nProcIndex, "strSubGroupId", "",9);
			dao.setProcInValue(nProcIndex, "strQty", "",10);
			dao.setProcInValue(nProcIndex, "strUnitId", "",11);
			dao.setProcInValue(nProcIndex, "strCompiledQty", "",12);
			dao.setProcInValue(nProcIndex, "strCompiledQtyUnit", "",13);
			dao.setProcInValue(nProcIndex, "strLstPurRate", "",15);
			dao.setProcInValue(nProcIndex, "strLstPurRateUnit", "",16);
			dao.setProcInValue(nProcIndex, "strSancQty", "",17);
			dao.setProcInValue(nProcIndex, "strSancQtyUnit", "",18);
			dao.setProcInValue(nProcIndex, "strLstPoNo", "",19);
			dao.setProcInValue(nProcIndex, "strLstSupplier", "",20);
			dao.setProcInValue(nProcIndex, "strLstRate", "",21);
			dao.setProcInValue(nProcIndex, "strLstPoDate", "",22);
			dao.setProcInValue(nProcIndex, "strLstRecQty", "",23);
			dao.setProcInValue(nProcIndex, "strLstRecQtyUnit", "",24);
			dao.setProcInValue(nProcIndex, "strApproxRate", "",25);
			dao.setProcInValue(nProcIndex, "strLstRecDate", "",26);
			dao.setProcInValue(nProcIndex, "strApproxRateUnit", "",27);
			dao.setProcInValue(nProcIndex, "strLstRateUnitId", "",28);
			dao.setProcInValue(nProcIndex, "strPoDate", "",31);
			dao.setProcInValue(nProcIndex, "strInhandQty", "",32);
			dao.setProcInValue(nProcIndex, "strInhandUnitId", "",33);
			dao.setProcInValue(nProcIndex, "strLastRecQty", "",34);
			dao.setProcInValue(nProcIndex, "strLastRecQtyUnitId", "",35);
			dao.setProcInValue(nProcIndex, "indent_no", "",36);
			dao.setProcInValue(nProcIndex, "raising_store", "",37);
			dao.setProcInValue(nProcIndex, "indent_date", "",38);
			dao.setProcInValue(nProcIndex, "indent_period", "",39);
			dao.setProcInValue(nProcIndex, "reqFlag", "0",40);
			dao.setProcInValue(nProcIndex, "itemFlag", "0",41);
			dao.setProcInValue(nProcIndex, "lstItemFlag", "0",42);

		 
			/* Setting Default Value End */
			
			dao.setProcOutValue(nProcIndex, "err", 1,43);
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

	/**
	 * Sets the str agenda no.
	 * 
	 * @param strAgendaNo the new str agenda no
	 */
	public void setStrAgendaNo(String strAgendaNo) {
		this.strAgendaNo = strAgendaNo;
	}

	/**
	 * Sets the str categ no.
	 * 
	 * @param strCategNo the new str categ no
	 */
	public void setStrCategNo(String strCategNo) {
		this.strCategNo = strCategNo;
	}

	/**
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	public void setStrInhandQty(String strInhandQty) {
		this.strInhandQty = strInhandQty;
	}

	public void setStrInhandUnitId(String strInhandUnitId) {
		this.strInhandUnitId = strInhandUnitId;
	}

	public void setStrPoDate(String strPoDate) {
		this.strPoDate = strPoDate;
	}

	public void setStrLastRecQty(String strLastRecQty) {
		this.strLastRecQty = strLastRecQty;
	}

	public void setStrLastRecQtyUnitId(String strLastRecQtyUnitId) {
		this.strLastRecQtyUnitId = strLastRecQtyUnitId;
	}

	
}
