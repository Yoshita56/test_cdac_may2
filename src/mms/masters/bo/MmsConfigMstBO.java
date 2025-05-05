package mms.masters.bo;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import javax.sql.rowset.WebRowSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import mms.MmsConfigUtil;
import mms.masters.dao.MmsConfigMstDAO;
import mms.masters.vo.MmsConfigMstVO;
import mms.setup.MmsConfigGeneral;
import mms.setup.MmsConfigType;
import mms.setup.MmsIssueProcessType;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstBO.
 */
public class MmsConfigMstBO {

	/**
	 * method used to retrieve values from the XML file and set them in formBean
	 * to display in the jsp page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void displayValues(MmsConfigMstVO vo) {

		JAXBElement<MmsConfigType> jaxB = null;

		MmsConfigType mmsConfig = null;
		MmsConfigGeneral mmsConfigGen=null;
		try 
		{
			jaxB = this.readXMLDataObject();
			mmsConfig = (MmsConfigType) jaxB.getValue();
			mmsConfigGen=(MmsConfigGeneral) mmsConfig.getMmsConfigGerneral();
			vo.setStrCommitteeFilePath(mmsConfigGen.getCommitteeFilePath());
			vo.setStrIndianDeliveryTime(mmsConfigGen.getIndianDeliveryTime());
			vo.setStrImportedDeliveryTime(mmsConfigGen.getImportedDeliveryTime());
			vo.setStrResidualCost(mmsConfigGen.getResidualCostAuction());
			vo.setStrExpAlertDays(mmsConfigGen.getExpAlertDays());
			vo.setStrCountryCode(mmsConfigGen.getStrCountryCode());
			vo.setStrStateCode(mmsConfigGen.getStrStateCode());
			vo.setStrBilingIntegration(mmsConfigGen.getStrBillingIntegration());
			
			vo.setStrIssueRateConfigFlg(mmsConfigGen.getStrIssueRateConfigFlg());
			
			vo.setStrConfigIssueRate(mmsConfigGen.getStrConfigIssueRate());
			
			vo.setStrBudgetFlg(mmsConfigGen.getStrBudgetFlg());
			
			MmsConfigMstDAO.getStoreDetails(vo);
			MmsConfigMstDAO.getCategoryCmb(vo);
			MmsConfigMstDAO.getCountryCmb(vo);

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstBO.displayValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

		}

	}

	/**
	 * saves the formBean data to the specified XML file.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void saveValues(MmsConfigMstVO vo) {

		
		
		JAXBElement<MmsConfigType> jaxB = null;
		
		try {
				jaxB = this.readXMLDataObject();
				
				MmsConfigType mmsConf = (MmsConfigType) jaxB.getValue();
	
				MmsConfigGeneral mmsConfGen = mmsConf.getMmsConfigGerneral();
				
				mmsConfGen.setCommitteeFilePath(vo.getStrCommitteeFilePath());
				mmsConfGen.setImportedDeliveryTime(vo.getStrImportedDeliveryTime());
				mmsConfGen.setIndianDeliveryTime(vo.getStrIndianDeliveryTime());
				mmsConfGen.setResidualCostAuction(vo.getStrResidualCost());
				mmsConfGen.setExpAlertDays(vo.getStrExpAlertDays());
				mmsConfGen.setStoreCategory(vo.getStrItemCatgId());
				mmsConfGen.setStrBillingIntegration(vo.getStrBilingIntegration());
				/******* All Varibale Added By Amit Kumar(DWH_ROAL_20_july_2011)********/
				mmsConfGen.setStrCountryCode(vo.getStrCountryCode());
				mmsConfGen.setStrStateCode(vo.getStrStateCode());
				mmsConfGen.setStrConfigIssueRate(vo.getStrConfigIssueRate());   
				mmsConfGen.setStrIssueRateConfigFlg(vo.getStrIssueRateConfigFlg());
				
				/*******Varibale Added By Amit Kumar(DWH_ROAL_05_Aug_2011)********/
				mmsConfGen.setStrBudgetFlg(vo.getStrBudgetFlg());
				/*******Varibale Added By Amit Kumar(DWH_ROAL_24_Nov_2011)********/
				mmsConfGen.setStrStampPaperAmt(vo.getStrStampPaperAmt());
				mmsConfGen.setStrContractValue(vo.getStrContractValue());
				mmsConfGen.setStrTinNo(vo.getStrTinNo());
				this.writeXMLDataObject(jaxB);
				MmsConfigMstDAO.updateStoreDtlsQuery(vo);
				/**********Method Added By Amit Kumar (DWH_ROAL_20_july_2011)************/
				MmsConfigMstDAO.updateDrugMaster(vo);


		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("MmsConfigMstBO.saveValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

		}

	}

	/**
	 * method used to retrieve values from the XML file and set them in formBean
	 * to display in the jsp page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void displayIssueValues(MmsConfigMstVO vo) 
	{

		JAXBElement<MmsConfigType> jaxB = null;

		MmsConfigType mmsConfig = null;
		MmsIssueProcessType mmsIssueConf = null;

		try 
		{

			jaxB = this.readXMLDataObject();

			mmsConfig = (MmsConfigType) jaxB.getValue();

			mmsIssueConf = mmsConfig.getMmsIssueProcess();

			
			vo.setStrIssueMode(mmsIssueConf.getIssueMode());
			vo.setStrLastIssuePatientStaffInDays(mmsIssueConf.getLastIssuePatientStaffInDays());
			vo.setStrLastIssueEmployeeInDays(mmsIssueConf.getLastIssueEmployeeInDays());
			vo.setStrOnlineIssueInDays(mmsIssueConf.getOnlineIssueDetailsInDays());
			vo.setStrAutoReturnRequest(mmsIssueConf.getAutoReturnRequest());
			vo.setStrStaffSalePrice(mmsIssueConf.getStaffSalePrice());
			vo.setStrStaffSalePriceType(mmsIssueConf.getStaffSalePriceType());
			vo.setStrNormalSalePrice(mmsIssueConf.getNormalSalePrice());
			vo.setStrNormalSalePriceType(mmsIssueConf.getNormalSalePriceType());
			
			vo.setStrWithOutCrNoFlg(mmsIssueConf.getStrWithOutCrNoFlg());
			vo.setStrDoseFrqFlg(mmsIssueConf.getStrDoseFrqFlg());
			vo.setStrCrNoDefault(mmsIssueConf.getStrCrNoDefault());
			vo.setStrReturnDrugValidity(mmsIssueConf.getStrReturnDrugValidity());
			
			MmsConfigMstDAO.getRetriveValue(vo);

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstBO.displayIssueValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {

			mmsIssueConf = null;
			mmsConfig = null;
			jaxB = null;
		}

	}

	/**
	 * saves the formBean data to the specified XML file.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void saveIssueValues(MmsConfigMstVO vo) {

		JAXBElement<MmsConfigType> jaxB = null;

		try {
			jaxB = this.readXMLDataObject();

			MmsConfigType mmsConf = (MmsConfigType) jaxB.getValue();

			MmsIssueProcessType mmsIssueConf = mmsConf.getMmsIssueProcess();

			mmsIssueConf.setIssueMode(vo.getStrIssueMode());
			mmsIssueConf.setLastIssueEmployeeInDays(vo.getStrLastIssueEmployeeInDays());
			mmsIssueConf.setLastIssuePatientStaffInDays(vo.getStrLastIssuePatientStaffInDays());

			mmsIssueConf.setOnlineIssueDetailsInDays(vo.getStrOnlineIssueInDays());
			mmsIssueConf.setAutoReturnRequest(vo.getStrAutoReturnRequest());
			mmsIssueConf.setStaffSalePrice(vo.getStrStaffSalePrice());
			mmsIssueConf.setStaffSalePriceType(vo.getStrStaffSalePriceType());
			mmsIssueConf.setNormalSalePrice(vo.getStrNormalSalePrice());
			mmsIssueConf.setNormalSalePriceType(vo.getStrNormalSalePriceType());
			mmsIssueConf.setStrDemandActiveFlg(vo.getStrDemandActiveFlg());
			mmsIssueConf.setStrDemandActivePrd(vo.getStrDemandActivePrd());
			
			mmsIssueConf.setStrWithOutCrNoFlg(vo.getStrWithOutCrNoFlg());
			mmsIssueConf.setStrDoseFrqFlg(vo.getStrDoseFrqFlg());
			mmsIssueConf.setStrCrNoDefault(vo.getStrCrNoDefault());
			mmsIssueConf.setStrReturnDrugValidity(vo.getStrReturnDrugValidity());
			
			
			
			
			this.writeXMLDataObject(jaxB);

			MmsConfigMstDAO.issueUpdateQuery(vo);
			MmsConfigMstDAO.issueUpdateQueryTwo(vo);

		} catch (Exception e) {

			vo.setStrMsgString("MmsConfigMstBO.saveIssueValues()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");

		} finally {
			jaxB = null;
		}

	}

	/**
	 * Display penalty values.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void displayPenaltyValues(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getPenaltyInitDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.displayPenaltyValues() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
//	/**
//	 * Display penalty values.
//	 * 
//	 * @param vo
//	 *            the vo
//	 */
//	public String displayPODemandValues(MmsConfigMstVO vo) 
//	{
//
//		MmsConfigMstDAO.getPODemandValidity(vo);
//
//		if (vo.getStrMsgType().equals("1")) {
//			vo.setStrMsgString("MmsConfigMstDAO.displayPODemandValues() --> "
//					+ vo.getStrMsgString());
//		}
//
//	}
//	
	
	
	public void displayPhysicalStockVerifyValues(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getPhyVerifyStoreDetails(vo);
		MmsConfigMstDAO.getCategoryCmb(vo);
		MmsConfigMstDAO.getPeriodListDetails(vo);
		MmsConfigMstDAO.getPhyVerifyOtherDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.displayPhysicalStockVerifyValues() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	public void displayReportParameterValues(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getReportParameterDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.displayReportParameterValues() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	
	public void getItemCateogryValues(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getPhyVerifyItemCategoryDetails(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.getItemCateogryValues() --> "
					+ vo.getStrMsgString());
		}

	}
	public void getStateList(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getStateCmb(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.getStateList() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
		
	public void getPeriodDetails(MmsConfigMstVO vo) {

		MmsConfigMstDAO.getIsPeriodAvailable(vo);
		
		
		if(vo.getStrIsPeriodAvailable().equals("0")){
			
			MmsConfigMstDAO.getPeriodListDetails(vo);
		}
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.getPeriodValues() --> "
					+ vo.getStrMsgString());
		}

	}
	

	/**
	 * Save penalty values.
	 * 
	 * @param vo
	 *            the vo
	 */
	public void savePenaltyValues(MmsConfigMstVO vo) {
		int count;
		MmsConfigMstDAO.deleteQuery(vo);
		MmsConfigMstDAO.insertQuery(vo);
		
		count=MmsConfigMstDAO.isDataExistConfigFile(vo);
		
		MmsConfigMstDAO.configFileDml(vo, count);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.savePenaltyValues() --> "
					+ vo.getStrMsgString());
		}

	}
	
	public void saveReportParameterValues(MmsConfigMstVO vo) {

		 
		MmsConfigMstDAO.reportParamABCUpdateQuery(vo);
		MmsConfigMstDAO.reportParamFNSUpdateQuery(vo);

		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.saveReportParameterValues() --> "
					+ vo.getStrMsgString());
		}

	}
	
	
	public void savePhysicalStockValues(MmsConfigMstVO vo) {

		MmsConfigMstDAO.phyVerificationUpdateQuery(vo);
		MmsConfigMstDAO.insertStoreHistDtlsQuery(vo);
		
		if(vo.getStrIsStockLedgerRequired().equals("1")){
			
			MmsConfigMstDAO.setOpenBalance(vo);
		}
		
		
		
		if (vo.getStrMsgType().equals("1")) {
			vo.setStrMsgString("MmsConfigMstDAO.savePhysicalStockValues() --> "
					+ vo.getStrMsgString());
		}

	}
	public void getPeneltyDtl(MmsConfigMstVO _MmsConfigMstVO){
		
		MmsConfigMstDAO.getPenaltyDetails(_MmsConfigMstVO);
		if (_MmsConfigMstVO.getStrMsgType().equals("1")) {
			_MmsConfigMstVO.setStrMsgString("MmsConfigMstDAO.savePhysicalStockValues() --> "
					+ _MmsConfigMstVO.getStrMsgString());
		}
		
	}

	/**
	 * common method for creating a XML Root Elements Data Object.
	 * 
	 * @return JAXBElement Object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	private JAXBElement<MmsConfigType> readXMLDataObject() throws Exception {

		JAXBElement<MmsConfigType> jaxB = null;

		JAXBContext jc;

		jc = JAXBContext.newInstance("mms.setup");

		Unmarshaller u = jc.createUnmarshaller();

		jaxB = (JAXBElement<MmsConfigType>) u.unmarshal(new FileInputStream(
				HisUtil.getParameterFromHisPathXML("MMS_CONFIG")));

		return jaxB;

	}

	/**
	 * retrieves JAXBElement Object and Updates the XML file.
	 * 
	 * @param jaxB -
	 *            JAXBElement Object
	 * 
	 * @throws Exception
	 *             the exception
	 */
	private void writeXMLDataObject(JAXBElement<MmsConfigType> jaxB)
			throws Exception {

		JAXBContext jc;

		jc = JAXBContext.newInstance("mms.setup");

		Marshaller m = jc.createMarshaller();

		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		m.marshal(jaxB, new FileWriter(new File(HisUtil.getParameterFromHisPathXML("MMS_CONFIG"))));

	}
	
	///////////////////////////////////////////////////////////////////////////
	/**
	 * @param MmsConfigMstVO_p
	 */
	public void setGenPropValues(MmsConfigMstVO mmsConfigMstVO_p) {

		
		
		
		//MmsConfigMstDAO.setGenPropValues(vo);
		
		
		
		WebRowSet wb=null,wb1=null;
		String tmp_ParamName="";
		String tmp_ParamValue="",scm_val="";
		String qry1 = mms.qryHandler_mms.getQuery(1, "select.SCMIntegration.1");
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.50");
		HisDAO hisDao = new HisDAO("MMS","MmsConfigMstBO.selectQuery()");
		
		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, "1");
			hisDao.setQryValue(qryIndex, 2, mmsConfigMstVO_p.getStrHospitalCode());
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("STORE_NAME"))
					mmsConfigMstVO_p.setStrStoreId(tmp_ParamValue);
				else if(tmp_ParamName.equals("EXPIRY_ALERT_DAYS"))
					mmsConfigMstVO_p.setStrExpAlertDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("RESIDUAL_COST_AUCTION"))
					mmsConfigMstVO_p.setStrResidualCost(tmp_ParamValue);
				else if(tmp_ParamName.equals("ITEM_CATEGORY")){
					mmsConfigMstVO_p.setStrItemCatgId(tmp_ParamValue);
				}
				else if(tmp_ParamName.equals("DEFAULT_COUNTRY"))
					mmsConfigMstVO_p.setStrCountryCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEFAULT_STATE"))
					mmsConfigMstVO_p.setStrStateCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("BILL_INTEGRATION"))
					mmsConfigMstVO_p.setStrBilingIntegration(tmp_ParamValue);
				
				else if(tmp_ParamName.equals("TAX_RATE"))
					mmsConfigMstVO_p.setStrTaxRate(tmp_ParamValue);
				else if(tmp_ParamName.equals("SINGLE_ITEM_MULTI_SUPPLIER"))
					mmsConfigMstVO_p.setStrWhetherSingleItemMultiSupplier(tmp_ParamValue);
				else if(tmp_ParamName.equals("INDIAN_DELIVERY_TIME"))
					mmsConfigMstVO_p.setStrIndianDeliveryTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("IMPORTED_DELIVERY_TIME"))
					mmsConfigMstVO_p.setStrImportedDeliveryTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("CONTRACT_VALUE"))
					mmsConfigMstVO_p.setStrContractValue(tmp_ParamValue);
				else if(tmp_ParamName.equals("STAMP_PAPER_AMOUNT"))
					mmsConfigMstVO_p.setStrStampPaperAmt(tmp_ParamValue);
				else if(tmp_ParamName.equals("PATH_COMMITTEE_RECOMENDATION"))
					mmsConfigMstVO_p.setStrCommitteeFilePath(tmp_ParamValue);	
				else if(tmp_ParamName.equals("PURCHASE_LEAD_TIME"))
					mmsConfigMstVO_p.setStrPurchaseLeadTime(tmp_ParamValue);
				else if(tmp_ParamName.equals("SELF_LIFE"))
					mmsConfigMstVO_p.setStrSelfLife(tmp_ParamValue);
				else if(tmp_ParamName.equals("TIN_NO"))
					mmsConfigMstVO_p.setStrTinNo(tmp_ParamValue);
				else if(tmp_ParamName.equals("FMS_INTEGRATION"))	
					mmsConfigMstVO_p.setStrFMSIntegration(tmp_ParamValue);
				else if(tmp_ParamName.equals("OSTF_INDENT_LIMIT_AMT"))	
					mmsConfigMstVO_p.setStrIndentLimitAmt(tmp_ParamValue);
			}
			
			MmsConfigMstDAO.getStoreDetails(mmsConfigMstVO_p);
			MmsConfigMstDAO.getCategoryCmb(mmsConfigMstVO_p);
			MmsConfigMstDAO.getCountryCmb(mmsConfigMstVO_p);
			
			qryIndex = hisDao.setQuery(qry1);
			wb1=hisDao.executeQry(qryIndex);
			if(wb1.size()>0)
			{
				wb1.next();
				scm_val = wb1.getString(1);
				mmsConfigMstVO_p.setStrSCMIntegration(scm_val);
			}
						
		}
		catch (Exception e) 
		{				
			mmsConfigMstVO_p.setStrMsgString("Error while retrieving Record");
			new HisException("MMS", "MmsConfigMstBO.setGenPropValues()", e.getMessage());
		}		
	}
	
	
	/**
	 * @param mmsConfigMstVO_p
	 */
	public void displayIssueDtls(MmsConfigMstVO mmsConfigMstVO_p) {

		
		
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.50");
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstBO.selectQuery()");
		
		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, "2");
			hisDao.setQryValue(qryIndex, 2, mmsConfigMstVO_p.getStrHospitalCode());
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("WHETHER_KEEP_DEMAND_ACTIVE_AT_PARTIAL_ISSUE"))
					mmsConfigMstVO_p.setStrDemandActiveFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("DEMAND_ACTIVE_PERIOD"))
					mmsConfigMstVO_p.setStrDemandActivePrd(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_WITHOUT_CRNO_OPTION_REQUIRED"))
					mmsConfigMstVO_p.setStrWithOutCrNoFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("CR_NO_REQ_WITH_OR_WITHOUR_CR_NO"))
					mmsConfigMstVO_p.setStrCrNoDefault(tmp_ParamValue);
				else if(tmp_ParamName.equals("WHETHER_DOSAGE_FREQ_DAYS_INFO_NEED_CAPTURE"))
					mmsConfigMstVO_p.setStrDoseFrqFlg(tmp_ParamValue);
				else if(tmp_ParamName.equals("RETURN_ITEM_VALIDITY"))
					mmsConfigMstVO_p.setStrReturnDrugValidity(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_MODE"))
					mmsConfigMstVO_p.setStrIssueMode(tmp_ParamValue);
				else if(tmp_ParamName.equals("ONLINE_ISSUE_IN_DAYS"))
					mmsConfigMstVO_p.setStrOnlineIssueInDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("INCASE_PATIENT_STAFF_ITEM_DAYS"))
					mmsConfigMstVO_p.setStrLastIssuePatientStaffInDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("INCASE_EMPLOYEE_NONCONSUMABLE_DAYS"))
					mmsConfigMstVO_p.setStrLastIssueEmployeeInDays(tmp_ParamValue);
				else if(tmp_ParamName.equals("AUTO_RETURN_REQUEST_INCASE_OF_LP"))
					mmsConfigMstVO_p.setStrAutoReturnRequest(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_STAFF"))
					mmsConfigMstVO_p.setStrStaffSalePrice(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_STAFF_PRICE_TYPE"))
					mmsConfigMstVO_p.setStrStaffSalePriceType(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_NORMAL"))
					mmsConfigMstVO_p.setStrNormalSalePrice(tmp_ParamValue);
				else if(tmp_ParamName.equals("ISSUE_RATE_NORMAL_PRICE_TYPE"))
					mmsConfigMstVO_p.setStrNormalSalePriceType(tmp_ParamValue);			
			}	
			//MmsConfigMstDAO.getRetriveValue(mmsConfigMstVO_p);
		}
		catch (Exception e) 
		{
			mmsConfigMstVO_p.setStrMsgString("Error while retrieving Record");
			new HisException("MmsConfigMstBO", "MmsConfigMstBO.displayIssueDtls()", e.getMessage());
		}		
	}
	
	/**
	 * @param mmsConfigMstVO_p
	 */
	public void displayPenaltyDtls(MmsConfigMstVO mmsConfigMstVO_p) {

		
		
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.50");
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstBO.selectQuery()");
		
		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, "3");
			hisDao.setQryValue(qryIndex, 2, mmsConfigMstVO_p.getStrHospitalCode());
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("PENALTY_INCASE_REJECTED_BREAKAGE"))
					mmsConfigMstVO_p.setStrPenRejBreak(tmp_ParamValue);
				else if(tmp_ParamName.equals("PURCHASE_TYPE"))
					mmsConfigMstVO_p.setStrPurchaseType(tmp_ParamValue);
				
			}	
			
			MmsConfigMstDAO.getPenaltyInitDetails(mmsConfigMstVO_p);

			if (mmsConfigMstVO_p.getStrMsgType().equals("1")) {
				mmsConfigMstVO_p.setStrMsgString("MmsConfigMstDAO.displayPenaltyValues() --> "
						+ mmsConfigMstVO_p.getStrMsgString());
			}
		}
		catch (Exception e) 
		{
			mmsConfigMstVO_p.setStrMsgString("Error while retrieving Record");
			new HisException("MmsConfigMstBO", "MmsConfigMstBO.displayPenaltyDtls()", e.getMessage());
		}		
	}
	
	
	/**
	 * @param mmsConfigMstVO_p
	 */
	public void displayPhysicalStockDtls(MmsConfigMstVO mmsConfigMstVO_p) {

		
		
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.50");
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstBO.selectQuery()");
		
		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, "4");
			hisDao.setQryValue(qryIndex, 2, mmsConfigMstVO_p.getStrHospitalCode());
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("PHY_STOCK_VERIFY_STORE"))
					mmsConfigMstVO_p.setStrStoreId(tmp_ParamValue);
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_ITEM_CAT"))
					mmsConfigMstVO_p.setStrItemCategoryCode(tmp_ParamValue);
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_PERIOD"))
					mmsConfigMstVO_p.setStrPeriodId(tmp_ParamValue);
				else if(tmp_ParamName.equals("PHY_STOCK_VERIFY_STOCK_LEDGER_REQD"))
					mmsConfigMstVO_p.setStrIsStockLedgerRequired(tmp_ParamValue);			
			}	
			
			MmsConfigMstDAO.getPhyVerifyStoreDetails(mmsConfigMstVO_p);

			if (mmsConfigMstVO_p.getStrMsgType().equals("1")) {
				mmsConfigMstVO_p.setStrMsgString("MmsConfigMstDAO.displayPhysicalStockVerifyValues() --> "
						+ mmsConfigMstVO_p.getStrMsgString());
			}
		}
		catch (Exception e) 
		{
			mmsConfigMstVO_p.setStrMsgString("Error while retrieving Record");
			new HisException("MmsConfigMstBO", "MmsConfigMstBO.displayPhysicalStockDtls()", e.getMessage());
		}		
	}
	
	/**
	 * @param mmsConfigMstVO_p
	 */
	public void displayReportDetailsValues(MmsConfigMstVO mmsConfigMstVO_p) {

		
		
		WebRowSet wb=null;
		String tmp_ParamName="";
		String tmp_ParamValue="";
		
		String qry = mms.qryHandler_mms.getQuery(1, "select.mmsconfig.50");
		HisDAO hisDao = new HisDAO("Mms Config Master","MmsConfigMstBO.selectQuery()");
		
		try {
			int qryIndex = hisDao.setQuery(qry);
			hisDao.setQryValue(qryIndex, 1, "5");
			hisDao.setQryValue(qryIndex, 2, mmsConfigMstVO_p.getStrHospitalCode());
			wb=hisDao.executeQry(qryIndex);
			
			
			while(wb.next())
			{
				tmp_ParamName=wb.getString(1);
				tmp_ParamValue=wb.getString(2);
				if(tmp_ParamName.equals("ABC_ANALYSIS_A"))
					mmsConfigMstVO_p.setStrCategoryA(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_B1"))
					mmsConfigMstVO_p.setStrCategoryB1(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_B2"))
					mmsConfigMstVO_p.setStrCategoryB2(tmp_ParamValue);
				else if(tmp_ParamName.equals("ABC_ANALYSIS_C"))
					mmsConfigMstVO_p.setStrCategoryC(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_F_X"))
					mmsConfigMstVO_p.setStrCategoryF(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_N_Y1"))
					mmsConfigMstVO_p.setStrCategoryN1(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_N_Y2"))
					mmsConfigMstVO_p.setStrCategoryN2(tmp_ParamValue);
				else if(tmp_ParamName.equals("FSN_XYZ_ANALYSIS_S_Z"))
					mmsConfigMstVO_p.setStrCategoryS(tmp_ParamValue);			
			}			
			//MmsConfigMstDAO.getReportParameterDetails(mmsConfigMstVO_p);
			
			if (mmsConfigMstVO_p.getStrMsgType().equals("1")) {
				mmsConfigMstVO_p.setStrMsgString("MmsConfigMstDAO.displayReportParameterValues() --> "
						+ mmsConfigMstVO_p.getStrMsgString());
			}
		}
		catch (Exception e) 
		{
			mmsConfigMstVO_p.setStrMsgString("Error while retrieving Record");
			new HisException("MmsConfigMstBO", "MmsConfigMstBO.displayReportDetailsValues()", e.getMessage());
		}		
	}
	
	public void saveGeneralDtlDataInDataBase(MmsConfigMstVO vo) {
		try {
			boolean retVal=MmsConfigMstDAO.generalUpdateQuery(vo);
			if(retVal)
			{
				MmsConfigUtil mcu=new MmsConfigUtil(vo.getStrHospitalCode());
				mcu.reloadcacheMmsVObj(vo.getStrHospitalCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			new HisException("MMS","MmsConfigMstBO.saveGeneralDtlDataInDataBase",e.getMessage());
		}
	}
	
	public void saveissueDtlDataInDataBase(MmsConfigMstVO vo) {
		try {
			boolean retVal=MmsConfigMstDAO.saveissueDtlDataInDataBase(vo);
			if(retVal)
			{
				MmsConfigUtil mcu=new MmsConfigUtil(vo.getStrHospitalCode());
				mcu.reloadcacheMmsVObj(vo.getStrHospitalCode());
			}
		} catch (Exception e) {
			new HisException("MMS","MmsConfigMstBO.saveissueDtlDataInDataBase",e.getMessage());
		}
	}
 
	public void savePenaltyDtlDataInDataBase(MmsConfigMstVO vo) {
		try {
			
			MmsConfigMstDAO.deleteQuery(vo);
			MmsConfigMstDAO.insertQuery(vo);
			
			/*count=MmsConfigMstDAO.isDataExistConfigFile(vo);
			MmsConfigMstDAO.configFileDml(vo, count);*/

			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("MmsConfigMstDAO.savePenaltyValues() --> "
						+ vo.getStrMsgString());
			}else{
				boolean retVal=MmsConfigMstDAO.savePenaltyDtlDataInDataBase(vo);
				if(retVal)
				{
					MmsConfigUtil mcu=new MmsConfigUtil(vo.getStrHospitalCode());
					mcu.reloadcacheMmsVObj(vo.getStrHospitalCode());
				}
			}
		} catch (Exception e) {
			new HisException("MMS","MmsConfigMstBO.savePenaltyDtlDataInDataBase",e.getMessage());
		}
	}
	public void savePhysicalStockDtlDataInDataBase(MmsConfigMstVO vo) {
		try {
			boolean retVal=MmsConfigMstDAO.savePhysicalStockDtlDataInDataBase(vo);
			if(retVal)
			{
				MmsConfigUtil mcu=new MmsConfigUtil(vo.getStrHospitalCode());
				mcu.reloadcacheMmsVObj(vo.getStrHospitalCode());
			}
		} catch (Exception e) {
			new HisException("MMS","MmsConfigMstBO.savePhysicalStockDtlDataInDataBase",e.getMessage());
		}
	}
	
	public void saveReportDtlinDataBase(MmsConfigMstVO vo) {
		try {
			boolean retVal=MmsConfigMstDAO.saveReportDtlinDataBase(vo);
			if(retVal)
			{
				MmsConfigUtil mcu=new MmsConfigUtil(vo.getStrHospitalCode());
				mcu.reloadcacheMmsVObj(vo.getStrHospitalCode());
			}
		} catch (Exception e) {
			new HisException("MMS","MmsConfigMstBO.saveReportDtlinDataBase",e.getMessage());
		}
	}
}