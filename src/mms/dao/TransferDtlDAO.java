/******************************************************************************************
 *                                Process Name : Item Transfer                            *
 ******************************************************************************************
 * File Name       : TransferDtlDAO.java                                                  *
 * Module Name     : MMS                                                                  *
 * Developer       : Deepak Tiwari                                                        * 
 * Version         : 1.0                                                                  * 
 * Assigned Date   : 1-May-2009                                                           *                                               
 * Completion Date : 3-May-2009                                                           *
 * Assigned By     : Ajay Kr. Gupta                                                       *
 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
 * Hand over date  : 30-May-2009                                                          *
 ******************************************************************************************
 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
 ******************************************************************************************/
package mms.dao;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferDtlDAO.
 */
public class TransferDtlDAO {

	/** The str hosp code. */
	private String strHospCode = "0";
	
	/** The str hst num transfer no. */
	private String strHstNumTransferNo = "0";
	
	/** The str hst num store id. */
	private String strHstNumStoreId = "0";
	
	/** The str sst num item cat no. */
	private String strSstNumItemCatNo = "0";
	
	/** The str hst num f start year. */
	private String strHstNumFStartYear = "";
	
	/** The str hst num f end year. */
	private String strHstNumFEndYear = "";
	
	/** The str remarks. */
	private String strRemarks = "";
	
	/** The str seat id. */
	private String strSeatId = "";
	
	/** The str entry date. */
	//private String strEntryDate = "";
	
	/** The str to store id. */
	private String strToStoreId = "";
	
	/** The str transfer date. */
	private String strTransferDate = "";
	
	/** The str receive by. */
	private String strReceiveBy = "";
	
	/** The str net cost. */
	private String strNetCost = "";

	// It is mandatory parameter, do not reset the following variables
	/** The str err. */
	private String strErr = "";

	/** The str proc name. */
	private final String strProcName = "Pkg_Mms_Dml.DML_HSTT_TRANSFER_DTL";
	
	/** The str file name. */
	private final String strFileName = "mms.dao.TransferDtlDAO";
	
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
	 * Gets the str err.
	 * 
	 * @return Returns the strErr.
	 */
	public String getStrErr() {
		return strErr;
	}

	/**
	 * Gets the n deleted index.
	 * 
	 * @return Returns the nDeletedIndex.
	 */
	public int getNDeletedIndex() {
		return nDeletedIndex;
	}

	/**
	 * Gets the n inserted index.
	 * 
	 * @return Returns the nInsertedIndex.
	 */
	public int getNInsertedIndex() {
		return nInsertedIndex;
	}

	/**
	 * Gets the n row deleted.
	 * 
	 * @return Returns the nRowDeleted.
	 */
	public int getNRowDeleted() {
		return nRowDeleted;
	}

	/**
	 * Gets the n row inserted.
	 * 
	 * @return Returns the nRowInserted.
	 */
	public int getNRowInserted() {
		return nRowInserted;
	}

	/**
	 * Gets the n row updated.
	 * 
	 * @return Returns the nRowUpdated.
	 */
	public int getNRowUpdated() {
		return nRowUpdated;
	}

	/**
	 * Gets the n updated index.
	 * 
	 * @return Returns the nUpdatedIndex.
	 */
	public int getNUpdatedIndex() {
		return nUpdatedIndex;
	}

	/**
	 * Gets the str file name.
	 * 
	 * @return Returns the strFileName.
	 */
	public String getStrFileName() {
		return strFileName;
	}

	/**
	 * Gets the str proc name.
	 * 
	 * @return Returns the strProcName.
	 */
	public String getStrProcName() {
		return strProcName;
	}

	/*
	 * public void setStrHstnumBkgNo(String strHstnumBkgNo) {
	 * this.strHstnumBkgNo = strHstnumBkgNo; }
	 */

	/**
	 * Sets the str hosp code.
	 * 
	 * @param strHospCode the new str hosp code
	 */
	public void setStrHospCode(String strHospCode) {
		this.strHospCode = strHospCode;
	}

	/**
	 * Sets the str hst num store id.
	 * 
	 * @param strHstNumStoreId the new str hst num store id
	 */
	public void setStrHstNumStoreId(String strHstNumStoreId) {
		this.strHstNumStoreId = strHstNumStoreId;
	}

	/**
	 * Sets the str sst num item cat no.
	 * 
	 * @param strSstNumItemCatNo the new str sst num item cat no
	 */
	public void setStrSstNumItemCatNo(String strSstNumItemCatNo) {
		this.strSstNumItemCatNo = strSstNumItemCatNo;
	}

	/**
	 * Sets the str hst num f start year.
	 * 
	 * @param strHstNumFStartYear the new str hst num f start year
	 */
	public void setStrHstNumFStartYear(String strHstNumFStartYear) {
		this.strHstNumFStartYear = strHstNumFStartYear;
	}

	/**
	 * Sets the str hst num f end year.
	 * 
	 * @param strHstNumFEndYear the new str hst num f end year
	 */
	public void setStrHstNumFEndYear(String strHstNumFEndYear) {
		this.strHstNumFEndYear = strHstNumFEndYear;
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
	 * Sets the str seat id.
	 * 
	 * @param strSeatId the new str seat id
	 */
	public void setStrSeatId(String strSeatId) {
		this.strSeatId = strSeatId;
	}

	/**
	 * <p>
	 * Method::insert is Used to insert values into Table::HSTT_TRANSFER_DTL.
	 * <p>
	 * Invoked At the time of saving the record
	 * 
	 * @param dao the dao
	 * 
	 * @throws Exception the exception
	 */
	public void insert(HisDAO dao) throws Exception {

		strErr = "";

		try {
			// check mandatory information

			if (strHstNumStoreId.equals("0") || strHstNumStoreId.equals("")) {
				throw new Exception("Store Type can not be blank");
			}
			if (this.nRowInserted == 0) {
				nInsertedIndex = dao.setProcedure("{call " + strProcName
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			// set the value
			// Input Value
			/*
			 * //System.out.println("hospital_code-"+strHospCode);
			 * //System.out.println("TransferNo-"+strHstNumTransferNo);
			 * //System.out.println("store_id-"+strHstNumStoreId);
			 * //System.out.println("tostore_id-"+strToStoreId);
			 * //System.out.println("transfer_date-"+strTransferDate);
			 * //System.out.println("receive_by-"+strReceiveBy);
			 * //System.out.println("net_cost-"+strNetCost);
			 * //System.out.println("item_cat_no-"+strSstNumItemCatNo);
			 * //System.out.println("financial_start_year-"+strHstNumFStartYear);
			 * //System.out.println("financial_end_year-"+strHstNumFEndYear);
			 * //System.out.println("remarks-"+strRemarks);
			 * //System.out.println("seatid-"+strSeatId);
			 */
			
			dao.setProcInValue(nInsertedIndex, "modval", "1",1);
			dao.setProcInValue(nInsertedIndex, "transferNo",
					strHstNumTransferNo.trim(),2);
			dao.setProcInValue(nInsertedIndex, "hospital_code", strHospCode
					.trim(),8); // 1
			dao.setProcInValue(nInsertedIndex, "store_id",
					this.strHstNumStoreId.trim(),3); // 2
			dao.setProcInValue(nInsertedIndex, "tostore_id", this.strToStoreId
					.trim(),4); // 3
			dao.setProcInValue(nInsertedIndex, "transfer_date",
					this.strTransferDate.trim(),5); // 4
			dao.setProcInValue(nInsertedIndex, "receive_by", this.strReceiveBy
					.trim(),6); // 5
			dao.setProcInValue(nInsertedIndex, "net_cost", this.strNetCost
					.trim(),7);// 6
			dao.setProcInValue(nInsertedIndex, "item_cat_no ",
					this.strSstNumItemCatNo.trim(),9); // 7
			dao.setProcInValue(nInsertedIndex, "financial_start_year",
					strHstNumFStartYear.trim(),10); // 8
			dao.setProcInValue(nInsertedIndex, "financial_end_year",
					strHstNumFEndYear.trim(),11); // 9
		
			dao.setProcInValue(nInsertedIndex, "remarks", strRemarks.trim(),13); // 10
			dao.setProcInValue(nInsertedIndex, "seatid", strSeatId.trim(),14); // 11
			
			/*
			 * Setting Current date.
			 */
			HisUtil hisutil = new HisUtil("MMS", "TransferDtlDAO");				
			String  strCurrentDate	= hisutil.getASDate("dd-MMM-yyyy");
			
			dao.setProcInValue(nInsertedIndex, "entry_date", strCurrentDate,12); 
			// output value
			dao.setProcOutValue(nInsertedIndex, "err", 1,15); // 12

			dao.execute(nInsertedIndex, 1);// keep in batch
			// dao.executeProcedure(nInsertedIndex);//without batch
			this.nRowInserted++;
		} catch (Exception e) {
			e.printStackTrace();
			this.strErr = e.getMessage();
			throw new Exception(strFileName + ".insert() --> " + this.strErr);
		} finally {
			this.reset(); // to reset the variables
		}
	}

	/**
	 * This method will be used to clear all the variables.
	 */
	private void reset() {

		strHospCode = "0";
		strHstNumStoreId = "0";
		strSstNumItemCatNo = "0";
		strHstNumFStartYear = "";
		strHstNumFEndYear = "";
		strRemarks = "";
		strSeatId = "";
	//	strEntryDate = "";
		strToStoreId = "0";
		strTransferDate = "";
		strReceiveBy = "";
		strNetCost = "0";
		strHstNumTransferNo = "0";

	}

	 

	/**
	 * Sets the str to store id.
	 * 
	 * @param strToStoreId the new str to store id
	 */
	public void setStrToStoreId(String strToStoreId) {
		this.strToStoreId = strToStoreId;
	}

	/**
	 * Sets the str transfer date.
	 * 
	 * @param strTransferDate the new str transfer date
	 */
	public void setStrTransferDate(String strTransferDate) {
		this.strTransferDate = strTransferDate;
	}

	/**
	 * Sets the str receive by.
	 * 
	 * @param strReceiveBy the new str receive by
	 */
	public void setStrReceiveBy(String strReceiveBy) {
		this.strReceiveBy = strReceiveBy;
	}

	/**
	 * Sets the str net cost.
	 * 
	 * @param strNetCost the new str net cost
	 */
	public void setStrNetCost(String strNetCost) {
		this.strNetCost = strNetCost;
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
	 * Sets the n row inserted.
	 * 
	 * @param rowInserted the new n row inserted
	 */
	public void setNRowInserted(int rowInserted) {
		nRowInserted = rowInserted;
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
	 * Sets the n row deleted.
	 * 
	 * @param rowDeleted the new n row deleted
	 */
	public void setNRowDeleted(int rowDeleted) {
		nRowDeleted = rowDeleted;
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
	 * Sets the n updated index.
	 * 
	 * @param updatedIndex the new n updated index
	 */
	public void setNUpdatedIndex(int updatedIndex) {
		nUpdatedIndex = updatedIndex;
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
	 * Sets the str hst num transfer no.
	 * 
	 * @param strHstNumTransferNo the new str hst num transfer no
	 */
	public void setStrHstNumTransferNo(String strHstNumTransferNo) {
		this.strHstNumTransferNo = strHstNumTransferNo;
	}

}
