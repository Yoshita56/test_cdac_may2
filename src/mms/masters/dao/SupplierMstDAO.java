package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.BlackListSupplierDtlDAO;
import mms.dao.SupplierDAO;
import mms.masters.vo.SupplierMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstDAO.
 */
public class SupplierMstDAO {

	/**
	 * This function is used to initialize the initial parameters.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getInitParam(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.2");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) 
			{
				vo.setStrItemCategoryName(web.getString(1));
			}

			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.3");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			vo.setSupplierGradeWS(web);

			// // //System.out.println("store type id--"+vo.getStrStoreTypeId());

			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.4");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			// dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setCommiteeNameWS(web);
//System.out.println("hosp code::: "+vo.getStrHospCode());
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplierType.1");
			nQueryIndex = dao.setQuery(strQuery);
		//	dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setWsSupplierType(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.getInitParam() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used to initialize the initial parameters.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getCountry(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.11");
			nQueryIndex = dao.setQuery(strQuery);
		//	dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setCountryNameWS(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.getInitParam() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used to initialize the initial parameters.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getState(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.12");
			nQueryIndex = dao.setQuery(strQuery);
		//	dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 1, vo.getStrCountryCode());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setStateNameWS(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.getInitParam() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used to insert the data into database.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insert(SupplierMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		
		int j=0;
		WebRowSet web = null;
		SupplierDAO supplierDAO = null;
		BlackListSupplierDtlDAO blackListSupp = null;
		String strSupplierId = "";
		System.out.println("vo.getStrExpiryDate()---------->"+vo.getStrExpiryDate());
		try 
		{
			supplierDAO = new SupplierDAO();
			blackListSupp = new BlackListSupplierDtlDAO();
			
			System.out.println("HSTNUM_SUPPLIER_ID--->" + vo.getStrSupplierId()==null || vo.getStrSupplierId().equals("")?"0":vo.getStrSupplierId());										
			System.out.println("GNUM_HOSPITAL_CODE--->"+ vo.getStrHospCode()==null || vo.getStrHospCode().equals("")?"0":vo.getStrHospCode());												
			System.out.println("SSTNUM_ITEM_CAT_NO--->"+vo.getStrItemCatNo()==null || vo.getStrItemCatNo().equals("")?"0":vo.getStrItemCatNo());
			System.out.println("HSTNUM_SUPPLIER_GRADE_ID--->"+vo.getStrSupplierGrade()==null || vo.getStrSupplierGrade().equals("")?"0":vo.getStrSupplierGrade());			
			System.out.println("HSTSTR_SUPPLIER_NAME--->"+vo.getStrSupplierName()==null || vo.getStrSupplierName().equals("")?"0":vo.getStrSupplierName());
			System.out.println("HSTSTR_CONTACT_PERSON--->"+vo.getStrContactPerson()==null || vo.getStrContactPerson().equals("")?"0":vo.getStrContactPerson());
			System.out.println("HSTSTR_ADDRESS--->"+vo.getStrAddress()==null || vo.getStrAddress().equals("")?"0":vo.getStrAddress());
			System.out.println("HSTSTR_CITY_NAME--->"+vo.getStrCity()==null || vo.getStrCity().equals("")?"0":vo.getStrCity());
			System.out.println("HSTSTR_PINCODE--->"+vo.getStrPincode()==null || vo.getStrPincode().equals("")?"0":vo.getStrPincode());	
			System.out.println("HSTSTR_PHONE1--->"+vo.getStrPhoneNo1()==null || vo.getStrPhoneNo1().equals("")?"0":vo.getStrPhoneNo1());
			System.out.println("HSTSTR_PHONE2--->"+vo.getStrPhoneNo2()==null || vo.getStrPhoneNo2().equals("")?"0":vo.getStrPhoneNo2());
			System.out.println("HSTSTR_EMAIL1--->"+vo.getStrEmailId1()==null || vo.getStrEmailId1().equals("")?"0":vo.getStrEmailId1());
			System.out.println("HSTSTR_EMAIL1--->"+vo.getStrEmailId2()==null || vo.getStrEmailId2().equals("")?"0":vo.getStrEmailId2());
			System.out.println("HSTSTR_FAXNO1--->"+vo.getStrFaxNo1()==null || vo.getStrFaxNo1().equals("")?"0":vo.getStrFaxNo1());
			System.out.println("HSTSTR_FAXNO2--->"+vo.getStrFaxNo2()==null || vo.getStrFaxNo2().equals("")?"0":vo.getStrFaxNo2());
			System.out.println("HSTSTR_WEBSITE --->"+vo.getStrWebsite()==null || vo.getStrWebsite().equals("")?"0":vo.getStrWebsite());
			System.out.println("HSTNUM_SUPPLIER_STATUS  --->"+vo.getStrSupplierStatus()==null || vo.getStrSupplierStatus().equals("")?"0":vo.getStrSupplierStatus());	
			System.out.println("GSTR_REMARKS--->"+vo.getStrRemarks()==null || vo.getStrRemarks().equals("")?"0":vo.getStrRemarks());
			System.out.println("GDT_EFFECTIVE_FRM--->"+vo.getStrEffectiveFrom()==null || vo.getStrEffectiveFrom().equals("")?"0":vo.getStrEffectiveFrom());					
			System.out.println("GNUM_SEATID --->"+vo.getStrSeatId()==null || vo.getStrSeatId().equals("")?"0":vo.getStrSeatId());						
			System.out.println("HSTSTR_LST_NO--->"+vo.getStrLstNo()==null || vo.getStrLstNo().equals("")?"0":vo.getStrLstNo());
			System.out.println("HSTSTR_CST_NO--->"+vo.getStrCstNo()==null || vo.getStrCstNo().equals("")?"0":vo.getStrCstNo());
			System.out.println("HSTSTR_PAN_NO--->"+vo.getStrPANNo()==null || vo.getStrPANNo().equals("")?"0":vo.getStrPANNo());
			System.out.println("HSTNUM_IS_SUPPLIER--->"+vo.getStrIsSupplier()==null || vo.getStrIsSupplier().equals("")?"0":vo.getStrIsSupplier());
			System.out.println("HSTNUM_IS_MANUFACTURER--->"+vo.getStrIsManufacturer()==null || vo.getStrIsManufacturer().equals("")?"0":vo.getStrIsManufacturer());			
			System.out.println("HSTNUM_IS_AGENT--->"+vo.getStrIsAgent()==null || vo.getStrIsAgent().equals("")?"0":vo.getStrIsAgent());
			System.out.println("HSTNUM_IS_BUYER--->"+vo.getStrIsBuyer()==null || vo.getStrIsBuyer().equals("")?"0":vo.getStrIsBuyer());
			System.out.println("HSTNUM_IS_FOREIGN--->"+vo.getStrForeignerSuppFlag()==null || vo.getStrForeignerSuppFlag().equals("")?"0":vo.getStrForeignerSuppFlag());
			System.out.println("HSTNUM_SUPPLIERTYPE_ID--->"+vo.getStrSupplierType()==null || vo.getStrSupplierType().equals("")?"0":vo.getStrSupplierType());
			System.out.println("GNUM_COUNTRYCODE--->"+vo.getStrCountryCode()==null || vo.getStrCountryCode().equals("")?"0":vo.getStrCountryCode());
			System.out.println("GNUM_STATECODE--->"+vo.getStrStateCode()==null || vo.getStrStateCode().equals("")?"0":vo.getStrStateCode());
			System.out.println("HSTSTR_CONTRACT_NO--->"+vo.getStrContractNo()==null || vo.getStrContractNo().equals("")?"0":vo.getStrContractNo());
			System.out.println("HSTDT_CONTRACT_DATE--->"+vo.getStrContractDate()==null || vo.getStrContractDate().equals("")?"0":vo.getStrContractDate());
			System.out.println("ExpiryDate--->"+vo.getStrExpiryDate()==null || vo.getStrExpiryDate().equals("")?"0":vo.getStrExpiryDate());
			System.out.println("HSTNUM_TURNOVER--->"+vo.getStrSuppTurnOver()==null || vo.getStrSuppTurnOver().equals("")?"0":vo.getStrSuppTurnOver());
			System.out.println("HSTNUM_TURNOVER_UNIT--->"+vo.getStrSuppTurnOverUnit()==null || vo.getStrSuppTurnOverUnit().equals("")?"0":vo.getStrSuppTurnOverUnit());
			System.out.println("HSTNUM_MAINTANANCE_FLAG--->"+vo.getStrSupplierProvMaintenance()==null || vo.getStrSupplierProvMaintenance().equals("")?"0":vo.getStrSupplierProvMaintenance());
			System.out.println("HSTNUM_ESCALANATION_FLAG--->"+vo.getStrEsclationMtxAvl()==null || vo.getStrEsclationMtxAvl().equals("")?"0":vo.getStrEsclationMtxAvl());
			System.out.println("hstnum_supplier_interface_required--->"+vo.getStrWhetherSupplierInterfacerequired()==null || vo.getStrWhetherSupplierInterfacerequired().equals("")?"0":vo.getStrWhetherSupplierInterfacerequired());

			dao = new HisDAO("MMS", "SupplierMstDAO");
			
			
			
			    String strProcName = "{call PKG_MMS_DML.dml_supplier_mst(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";// 41 Varibale's
			    
			    
				
		        int nProcIndex = dao.setProcedure(strProcName);		
		        

				dao.setProcInValue(nProcIndex, "modval", "1",1);                         																							 		                                  //1
				dao.setProcInValue(nProcIndex, "strsupplierid","0",2);          	     																							 		                                  //2
				dao.setProcInValue(nProcIndex, "strhospitalcode",(vo.getStrHospCode()==null || vo.getStrHospCode().equals(""))?"0":vo.getStrHospCode(),3);  	     				 		                                  //3
				dao.setProcInValue(nProcIndex, "strcatgcode",(vo.getStrItemCatNo()==null || vo.getStrItemCatNo().equals(""))?"0":vo.getStrItemCatNo(),4 );           				 		                                  //4
				dao.setProcInValue(nProcIndex, "strsuppliergradeid",(vo.getStrSupplierGrade()==null || vo.getStrSupplierGrade().equals(""))?"0":vo.getStrSupplierGrade(),5);         		                                  //5
				dao.setProcInValue(nProcIndex, "strsuppliername",(vo.getStrSupplierName()==null || vo.getStrSupplierName().equals(""))?"0":vo.getStrSupplierName(),6);        	     		                                  //6
				dao.setProcInValue(nProcIndex, "strcontactperson",(vo.getStrContactPerson()==null || vo.getStrContactPerson().equals(""))?"0":vo.getStrContactPerson(),7); 			 		                                  //7
				dao.setProcInValue(nProcIndex, "straddress",(vo.getStrAddress()==null || vo.getStrAddress().equals(""))?"0":vo.getStrAddress(),8);   //Drug Inventory  		         		                                  //8
				dao.setProcInValue(nProcIndex, "strcityname",(vo.getStrCity()==null || vo.getStrCity().equals(""))?"0":vo.getStrCity(),9);      	 	                             		                                  //9
				dao.setProcInValue(nProcIndex, "strpincode",	(vo.getStrPincode()==null || vo.getStrPincode().equals(""))?"0":vo.getStrPincode(),10);         		             		                                  //10
				dao.setProcInValue(nProcIndex, "strphone1",(vo.getStrPhoneNo1()==null || vo.getStrPhoneNo1().equals(""))?"0":vo.getStrPhoneNo1(),11);    	  	                     		                                  //11
				dao.setProcInValue(nProcIndex, "strphone2",(vo.getStrPhoneNo2()==null || vo.getStrPhoneNo2().equals(""))?"0":vo.getStrPhoneNo2(),12);         		                 		                                  //12
				dao.setProcInValue(nProcIndex, "stremail1", (vo.getStrEmailId1()==null || vo.getStrEmailId1().equals(""))?"0":vo.getStrEmailId1(),13);  	 		                 		                                  //13
				dao.setProcInValue(nProcIndex, "stremail2",(vo.getStrEmailId2()==null || vo.getStrEmailId2().equals(""))?"0":vo.getStrEmailId2(),14);      	                         		                                  //14
				dao.setProcInValue(nProcIndex, "strfaxno1",(vo.getStrFaxNo1()==null || vo.getStrFaxNo1().equals(""))?"0":vo.getStrFaxNo1(),15); 	 							     		                                  //15
				dao.setProcInValue(nProcIndex, "strfaxno2",(vo.getStrFaxNo2()==null || vo.getStrFaxNo2().equals(""))?"0":vo.getStrFaxNo2(),16);       				   			     										  //16
				dao.setProcInValue(nProcIndex, "strwebsite",(vo.getStrWebsite()==null ||vo.getStrWebsite().equals(""))?"0":vo.getStrWebsite(),17);    				 				 										  //17
				dao.setProcInValue(nProcIndex, "strsupplierstatus", (vo.getStrSupplierStatus()==null ||vo.getStrSupplierStatus().equals(""))?"0":vo.getStrSupplierStatus(),18);      										  //18
				dao.setProcInValue(nProcIndex, "strremarks",(vo.getStrRemarks()==null ||vo.getStrRemarks().equals(""))?"0":vo.getStrRemarks(),19);   								 										  //19
				dao.setProcInValue(nProcIndex, "streffectivefrom",(vo.getStrEffectiveFrom()==null ||vo.getStrEffectiveFrom().equals(""))?"0":vo.getStrEffectiveFrom(),20); 			 										  //20
				dao.setProcInValue(nProcIndex,"strseatid","0",21);			 							 										  																			  //21
				dao.setProcInValue(nProcIndex, "strlstno",(vo.getStrLstNo()==null ||vo.getStrLstNo().equals(""))?"0":vo.getStrLstNo(),22); 											 										  //22				
				dao.setProcInValue(nProcIndex,"strcstno",(vo.getStrCstNo()==null || vo.getStrCstNo().equals(""))?"0":vo.getStrCstNo(),23);											 										  //23
				dao.setProcInValue(nProcIndex,"strpanno",(vo.getStrPANNo()==null || vo.getStrPANNo().equals(""))?"0":vo.getStrPANNo(),24);											 										  //24
				dao.setProcInValue(nProcIndex,"strissupplier",(vo.getStrIsSupplier()==null ||vo.getStrIsSupplier().equals(""))?"0":vo.getStrIsSupplier(),25);						 										  //25
				dao.setProcInValue(nProcIndex,"strismanufacturer",vo.getStrIsManufacturer(),26);																					 										  //26
				dao.setProcInValue(nProcIndex,"strisagent",(vo.getStrIsAgent()==null ||vo.getStrIsAgent().equals(""))?"0":vo.getStrIsAgent(),27);									 										  //27
				dao.setProcInValue(nProcIndex,"strisbuyer",(vo.getStrIsBuyer()==null ||vo.getStrIsBuyer().equals(""))?"0":vo.getStrIsBuyer(),28);									 										  //28
				dao.setProcInValue(nProcIndex,"strforeignersuppflag",(vo.getStrForeignerSuppFlag()==null ||vo.getStrForeignerSuppFlag().equals(""))?"0":vo.getStrForeignerSuppFlag(),29);									  //29
				dao.setProcInValue(nProcIndex,"strsuppliertype",(vo.getStrSupplierType()==null ||vo.getStrSupplierType().equals(""))?"0":vo.getStrSupplierType(),30);					 									  //30
				dao.setProcInValue(nProcIndex,"strcountrycode",(vo.getStrCountryCode()==null ||vo.getStrCountryCode().equals(""))?"0":vo.getStrCountryCode(),31);						 									  //31
				dao.setProcInValue(nProcIndex,"strstatecode",(vo.getStrStateCode()==null || vo.getStrStateCode().equals(""))?"0":vo.getStrStateCode(),32);								 								      //32
				dao.setProcInValue(nProcIndex,"strcontractno",(vo.getStrContractNo()==null || vo.getStrContractNo().equals(""))?"0":vo.getStrContractNo(),33);							 							          //33	
				dao.setProcInValue(nProcIndex," strcontractdate",(vo.getStrContractDate()==null || vo.getStrContractDate().equals(""))?"0":vo.getStrContractDate(),34);													      //34
				dao.setProcInValue(nProcIndex,"strexpirydate",(vo.getStrExpiryDate()==null || vo.getStrExpiryDate().equals(""))?"0":vo.getStrExpiryDate(),35);																  //35
				dao.setProcInValue(nProcIndex,"strsuppturnover",(vo.getStrSuppTurnOver()==null ||vo.getStrSuppTurnOver().equals(""))?"0":vo.getStrSuppTurnOver(),36);														  //36
				dao.setProcInValue(nProcIndex,"strsuppturnoverunit",(vo.getStrSuppTurnOverUnit()==null ||vo.getStrSuppTurnOverUnit().equals(""))?"0":vo.getStrSuppTurnOverUnit(),37);										  //37
				dao.setProcInValue(nProcIndex,"strsupplierprovmaintenance",(vo.getStrSupplierProvMaintenance()==null ||vo.getStrSupplierProvMaintenance().equals(""))?"0":vo.getStrSupplierProvMaintenance(),38); 			  //38
				dao.setProcInValue(nProcIndex,"stresclationmtxavl",(vo.getStrEsclationMtxAvl()==null ||vo.getStrEsclationMtxAvl().equals(""))?"0":vo.getStrEsclationMtxAvl(),39);								  			  //39
				dao.setProcInValue(nProcIndex,"strwhethersupplierinterfacerequired",(vo.getsupplier_interface_required()==null ||vo.getsupplier_interface_required().equals(""))?"0":vo.getsupplier_interface_required(),40); //40
				dao.setProcOutValue(nProcIndex, "err", 1,41);                         																																		  //41
				
				
				dao.execute(nProcIndex, 1);
				
			
			/*
			
			supplierDAO.setStrAddress(vo.getStrAddress());
			supplierDAO.setStrCityName(vo.getStrCity());
			supplierDAO.setStrContactPerson(vo.getStrContactPerson());
			supplierDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			supplierDAO.setStrEmail1(vo.getStrEmailId1());
			supplierDAO.setStrEmail2(vo.getStrEmailId2());
			supplierDAO.setStrFaxNo1(vo.getStrFaxNo1());
			supplierDAO.setStrFaxNo2(vo.getStrFaxNo2());
			supplierDAO.setStrHospitalCode(vo.getStrHospCode());
			supplierDAO.setStrIsValid("1");
			supplierDAO.setStrPhone1(vo.getStrPhoneNo1());
			supplierDAO.setStrPhone2(vo.getStrPhoneNo2());
			supplierDAO.setStrPinCode(vo.getStrPincode());
			supplierDAO.setStrRemarks(vo.getStrRemarks());
			supplierDAO.setStrSeatId(vo.getStrSeatId());
			supplierDAO.setStrStoreTypeId(vo.getStrItemCatNo());
			supplierDAO.setStrSupplierGradeId(vo.getStrSupplierGrade());
			supplierDAO.setStrSupplierName(vo.getStrSupplierName());
			supplierDAO.setStrSupplierStatus(vo.getStrSupplierStatus());
			supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			supplierDAO.setStrWebSite(vo.getStrWebsite());
			supplierDAO.setStrSupplierId(strSupplierId);
			supplierDAO.setStrForeignerSuppFlag(vo.getStrForeignerSuppFlag());
			supplierDAO.setStrIsSupplier(vo.getStrIsSupplier());
			supplierDAO.setStrIsManufacturer(vo.getStrIsManufacturer());
			supplierDAO.setStrIsAgent(vo.getStrIsAgent());
			supplierDAO.setStrIsBuyer(vo.getStrIsBuyer());
			supplierDAO.setStrLstNo(vo.getStrLstNo());
			supplierDAO.setStrCstNo(vo.getStrCstNo());
			supplierDAO.setStrPANNo(vo.getStrPANNo());
			supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			supplierDAO.setStrCountryCode(vo.getStrCountryCode());
			supplierDAO.setStrStateCode(vo.getStrStateCode());

			supplierDAO.setStrContractNo(vo.getStrContractNo());
			supplierDAO.setStrContractDate(vo.getStrContractDate());
			supplierDAO.setStrExpiryDate(vo.getStrExpiryDate());
			supplierDAO.setStrSuppTurnOver(vo.getStrSuppTurnOver());
			supplierDAO.setStrSuppTurnOverUnit(vo.getStrSuppTurnOverUnit());
			supplierDAO.setStrSupplierProvMaintenance(vo.getStrSupplierProvMaintenance());
			supplierDAO.setStrEsclationMtxAvl(vo.getStrEsclationMtxAvl());
			supplierDAO.setStrWhetherSupplierInterfacerequired(vo.getStrWhetherSupplierInterfacerequired());
            supplierDAO.insert(dao);
            */
      
            if(vo.getStrLevelOneEsc().equals("1") && vo.getStrLevelTwoEsc().equals("1"))
			{
				for(int i=0;i<2;i++)
				{
				    j++;	
					blackListSupp.setStrSupplierId(strSupplierId);
					blackListSupp.setStrEscLevel(String.valueOf(j));
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrSupplierId(strSupplierId);
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
					blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
					blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
					blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
					blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
										
					blackListSupp.insertSupplierEsc(dao);					
				}				
			}
			else
			{
				if(vo.getStrLevelOneEsc().equals("1"))
				{
					for(int i=0;i<1;i++)
					{						
						blackListSupp.setStrSupplierId(strSupplierId);
						blackListSupp.setStrEscLevel(String.valueOf(j));
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrSupplierId(strSupplierId);
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
						blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
						blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
						blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
						blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
										
						blackListSupp.insertSupplierEsc(dao);
					}										
				}				
			}
            
			if (vo.getStrSupplierStatus().equals("2")) 
			{
				blackListSupp.setStrActionDate(vo.getStrActionDate());
				blackListSupp.setStrCommitteeNo(vo.getStrCommitee());
				blackListSupp.setStrHospitalCode(vo.getStrHospCode());
				blackListSupp.setStrIsBlackListFlag("1");
				blackListSupp.setStrRemarks(vo.getStrBlackListedRemarks());
				blackListSupp.setStrSeatId(vo.getStrSeatId());
				blackListSupp.setStrIsValid("1");
				blackListSupp.setStrSupplierId(strSupplierId);
				
				blackListSupp.insert(dao);
			}			
			synchronized (dao) 
			{
				dao.fire();
			}
		} 
		catch (Exception e) 
		{
			//System.out.println("Error:::  "+e.getMessage());
            vo.setStrMsgString("SupplierMstDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
			e.printStackTrace();
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			supplierDAO = null;
			blackListSupp = null;
			web = null;
		}
	}
	
	/**
	 * This function is used to insert the data into database.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insert_org(SupplierMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		WebRowSet web = null;
		SupplierDAO supplierDAO = null;
		BlackListSupplierDtlDAO blackListSupp = null;
		String strSupplierId = "";
		
		try 
		{
			supplierDAO = new SupplierDAO();
			blackListSupp = new BlackListSupplierDtlDAO();
			
			dao = new HisDAO("MMS", "SupplierMstDAO");
			//System.out.println("Dao File 1");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.5");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());

			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strSupplierId = web.getString(1);

			}
			System.out.println("strSupplierId--->>"+strSupplierId);	
			System.out.println(" vo.getStrHospCode()--->>"+vo.getStrHospCode());			
			System.out.println(" vo.getStrItemCatNo()--->>"+vo.getStrItemCatNo());
			supplierDAO.setStrAddress(vo.getStrAddress());
			supplierDAO.setStrCityName(vo.getStrCity());
			supplierDAO.setStrContactPerson(vo.getStrContactPerson());
			supplierDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			supplierDAO.setStrEmail1(vo.getStrEmailId1());
			supplierDAO.setStrEmail2(vo.getStrEmailId2());
			supplierDAO.setStrFaxNo1(vo.getStrFaxNo1());
			supplierDAO.setStrFaxNo2(vo.getStrFaxNo2());
			supplierDAO.setStrHospitalCode(vo.getStrHospCode());
			supplierDAO.setStrIsValid("1");
			supplierDAO.setStrPhone1(vo.getStrPhoneNo1());
			supplierDAO.setStrPhone2(vo.getStrPhoneNo2());
			supplierDAO.setStrPinCode(vo.getStrPincode());
			supplierDAO.setStrRemarks(vo.getStrRemarks());
			supplierDAO.setStrSeatId(vo.getStrSeatId());
			supplierDAO.setStrStoreTypeId(vo.getStrItemCatNo());
			supplierDAO.setStrSupplierGradeId(vo.getStrSupplierGrade());
			supplierDAO.setStrSupplierName(vo.getStrSupplierName());
			supplierDAO.setStrSupplierStatus(vo.getStrSupplierStatus());
			supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			supplierDAO.setStrWebSite(vo.getStrWebsite());
			supplierDAO.setStrSupplierId(strSupplierId);
			supplierDAO.setStrForeignerSuppFlag(vo.getStrForeignerSuppFlag());
			supplierDAO.setStrIsSupplier(vo.getStrIsSupplier());
			supplierDAO.setStrIsManufacturer(vo.getStrIsManufacturer());
			supplierDAO.setStrIsAgent(vo.getStrIsAgent());
			supplierDAO.setStrIsBuyer(vo.getStrIsBuyer());
			supplierDAO.setStrLstNo(vo.getStrLstNo());
			supplierDAO.setStrCstNo(vo.getStrCstNo());
			supplierDAO.setStrPANNo(vo.getStrPANNo());
			supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			supplierDAO.setStrCountryCode(vo.getStrCountryCode());
			supplierDAO.setStrStateCode(vo.getStrStateCode());

			supplierDAO.setStrContractNo(vo.getStrContractNo());
			supplierDAO.setStrContractDate(vo.getStrContractDate());
			supplierDAO.setStrExpiryDate(vo.getStrExpiryDate());
			supplierDAO.setStrSuppTurnOver(vo.getStrSuppTurnOver());
			supplierDAO.setStrSuppTurnOverUnit(vo.getStrSuppTurnOverUnit());
			supplierDAO.setStrSupplierProvMaintenance(vo.getStrSupplierProvMaintenance());
			supplierDAO.setStrEsclationMtxAvl(vo.getStrEsclationMtxAvl());
			supplierDAO.setStrWhetherSupplierInterfacerequired(vo.getStrWhetherSupplierInterfacerequired());
            supplierDAO.insert(dao);
      
            if(vo.getStrLevelOneEsc().equals("1") && vo.getStrLevelTwoEsc().equals("1"))
			{
				for(int i=0;i<2;i++)
				{
				    j++;	
					blackListSupp.setStrSupplierId(strSupplierId);
					blackListSupp.setStrEscLevel(String.valueOf(j));
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrSupplierId(strSupplierId);
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
					blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
					blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
					blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
					blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
										
					blackListSupp.insertSupplierEsc(dao);					
				}				
			}
			else
			{
				if(vo.getStrLevelOneEsc().equals("1"))
				{
					for(int i=0;i<1;i++)
					{						
						blackListSupp.setStrSupplierId(strSupplierId);
						blackListSupp.setStrEscLevel(String.valueOf(j));
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrSupplierId(strSupplierId);
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
						blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
						blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
						blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
						blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
										
						blackListSupp.insertSupplierEsc(dao);
					}										
				}				
			}
            
			if (vo.getStrSupplierStatus().equals("2")) 
			{
				blackListSupp.setStrActionDate(vo.getStrActionDate());
				blackListSupp.setStrCommitteeNo(vo.getStrCommitee());
				blackListSupp.setStrHospitalCode(vo.getStrHospCode());
				blackListSupp.setStrIsBlackListFlag("1");
				blackListSupp.setStrRemarks(vo.getStrBlackListedRemarks());
				blackListSupp.setStrSeatId(vo.getStrSeatId());
				blackListSupp.setStrIsValid("1");
				blackListSupp.setStrSupplierId(strSupplierId);
				
				blackListSupp.insert(dao);
			}			
			synchronized (dao) 
			{
				dao.fire();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            vo.setStrMsgString("SupplierMstDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			supplierDAO = null;
			blackListSupp = null;
			web = null;
		}
	}

	/**
	 * This function is used set initial parameters for modify page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void modify(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		String strQuery1 = "";
		int nQueryIndex = 0;
		int nQueryIndex1 = 0;
		WebRowSet web = null;
		WebRowSet web1 = null;
		int j=0;
		
		try {

			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.6");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSupplierId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSlNo());
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{

				vo.setStrSupplierName(web.getString(1));
				vo.setStrItemCatNo(web.getString(2));
				vo.setStrContactPerson(web.getString(3));
				vo.setStrAddress(web.getString(4));
				vo.setStrCity(web.getString(5));
				vo.setStrPincode(web.getString(6));
				vo.setStrPhoneNo1(web.getString(7));
				vo.setStrPhoneNo2(web.getString(8));
				vo.setStrEmailId1(web.getString(9));
				vo.setStrEmailId2(web.getString(10));
				vo.setStrFaxNo1(web.getString(11));
				vo.setStrFaxNo2(web.getString(12));
				vo.setStrWebsite(web.getString(13));
				vo.setStrSupplierStatus(web.getString(14));

				vo.setStrRemarks(web.getString(15));
				vo.setStrEffectiveFrom(web.getString(16));
				vo.setStrIsValid(web.getString(17));
				vo.setStrSupplierGradeCode(web.getString(18));
				vo.setStrItemCatNo(web.getString(19));
				// vo.setStrLocalPurchaseSuppFlag(web.getString(25));
				if(web.getString(20).equalsIgnoreCase("0"))
				{
					vo.setStrLstNo("");
				}
				else
				{
				vo.setStrLstNo(web.getString(20));
				}
				if(web.getString(21).equalsIgnoreCase("0"))
				{
					vo.setStrCstNo("");
				}
				else
				{
				vo.setStrCstNo(web.getString(21));
				}
				if(web.getString(22).equalsIgnoreCase("0"))
				{
					vo.setStrPANNo("");
				}
				else
				{
				vo.setStrPANNo(web.getString(22));
				}
				//vo.setStrCstNo(web.getString(21).equalsIgnoreCase("0")?null:web.getString(21));
				//vo.setStrPANNo(web.getString(22).equalsIgnoreCase("0")?null:web.getString(22));
				vo.setStrIsSupplier(web.getString(23));
				vo.setStrIsManufacturer(web.getString(24));
				vo.setStrIsAgent(web.getString(25));
				vo.setStrIsBuyer(web.getString(26));
				vo.setStrForeignerSuppFlag(web.getString(27));
				vo.setStrSupplierTypeCode(web.getString(28));
				vo.setStrCountryCode(web.getString(29));
				vo.setStrStateCode(web.getString(30));
				vo.setStrSuppTurnOver(web.getString("HSTNUM_TURNOVER"));
				////System.out.println("Turn Over Unit::::::"+web.getString(37));
				vo.setStrSuppTurnOverUnit(web.getString(37));
	            vo.setStrSupplierProvMaintenance(web.getString("HSTNUM_MAINTANANCE_FLAG"));
	            vo.setStrEsclationMtxAvl(web.getString("HSTNUM_ESCALANATION_FLAG"));
	           	/* Aritra */
				vo.setStrContractNo(web.getString("HSTSTR_CONTRACT_NO"));
				vo.setStrContractDate(web.getString("HSTDT_CONTRACT_DATE"));
				vo.setStrExpiryDate(web.getString("HSTDT_CONTRACT_EXPIRY_DATE"));
				vo.setStrCountryCode(web.getString("GNUM_COUNTRYCODE"));//GNUM_STATECODE
				vo.setStrStateCode(web.getString("GNUM_STATECODE"));
				vo.setStrWhetherSupplierInterfacerequired(web.getString("suppin"));
				// // //System.out.println("modify
				// getStrLocalPurchaseSuppFlag"+vo.getStrLocalPurchaseSuppFlag());
				if (vo.getStrSupplierStatus().equals("2")) 
				{
					strQuery = mms.qryHandler_mms.getQuery(1,"select.supplier.7");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrSupplierId());
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex, 3, vo.getStrSupplierId());
					dao.setQryValue(nQueryIndex, 4, vo.getStrHospCode());
					web = dao.executeQry(nQueryIndex);
					if (web.next()) {
						vo.setStrActionDate(web.getString(1));
						vo.setStrBlackListedRemarks(web.getString(2));
						vo.setStrCommitteCode(web.getString(3));
					}

					vo.setStrIsBlackListMod("1");
				} else {
					vo.setStrIsBlackListMod("0");
				}
			}
			
			strQuery1 = mms.qryHandler_mms.getQuery(1,"select.supplier.88");
			nQueryIndex1 = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex1, 1, vo.getStrSupplierId());
			dao.setQryValue(nQueryIndex1, 2, vo.getStrHospCode());
		    
					if (vo.getStrEsclationMtxAvl().equals("1")) 
					{				
						web1 = dao.executeQry(nQueryIndex1);
						
						String arr1[] = new String[web1.size()];
						String arr2[] = new String[web1.size()];
						String arr3[] = new String[web1.size()];
						String arr4[] = new String[web1.size()];
						String arr5[] = new String[web1.size()];
						String arr6[] = new String[web1.size()];
						
		                for(int k =0;web1.next();k++) 
						{		                	
							arr1[k] = web1.getString(1);
							arr2[k] = web1.getString(2);
							arr3[k] = web1.getString(3);
							arr4[k] = web1.getString(4);
							arr5[k] = web1.getString(5);
							arr6[k] = web1.getString(6);
							j++;
							
						}
		                vo.setStrCotactPersonForEsc(arr2);
		
						vo.setStrContactPersonDesgForEsc(arr3);
		
						vo.setStrCotactEmailIdForEsc(arr4);
		
						vo.setStrCotactNoForEsc(arr5);
		
						vo.setStrCotactFaxForEsc(arr6);
				    }
				
					if(j>1)
					{
						vo.setStrLevelOneEsc("1");
						vo.setStrLevelTwoEsc("1");
					}
					else
					{
						vo.setStrLevelOneEsc("1");
						vo.setStrLevelTwoEsc("0");
						
					}	
				
               
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplierType.1");
			nQueryIndex = dao.setQuery(strQuery);
		//	dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setWsSupplierType(web);

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.modify() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			web = null;
		}
	}

	/**
	 * This function is used to update record during click of modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void update(SupplierMstVO vo) {
		HisDAO dao = null;
		// String strQuery = "";
		 int j = 0;
		// WebRowSet web = null;
		SupplierDAO supplierDAO = null;
		BlackListSupplierDtlDAO blackListSupp = null;
		// String strslno = "";
		try {
            ////System.out.println("Inside DAO");
			supplierDAO = new SupplierDAO();
			blackListSupp = new BlackListSupplierDtlDAO();
			dao = new HisDAO("mms", "SupplierMstDAO");
			/*
			 * strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.8");
			 * nQueryIndex = dao.setQuery(strQuery);
			 * dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			 * dao.setQryValue(nQueryIndex, 2, vo.getStrSupplierId()); web =
			 * dao.executeQry(nQueryIndex); if (web.next()) { strslno =
			 * web.getString(1);
			 *  }
			 */
			// //System.out.println("vo.getStrAddress();;;"+vo.getStrAddress());
			// // //System.out.println("---------->"+vo.getStrEffectiveFrom());
			supplierDAO.setStrAddress(vo.getStrAddress());

			supplierDAO.setStrCityName(vo.getStrCity());
			supplierDAO.setStrContactPerson(vo.getStrContactPerson());
			supplierDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			supplierDAO.setStrEmail1(vo.getStrEmailId1());
			supplierDAO.setStrEmail2(vo.getStrEmailId2());
			// supplierDAO.setStrEntryDate("sysdate");
			supplierDAO.setStrFaxNo1(vo.getStrFaxNo1());
			supplierDAO.setStrFaxNo2(vo.getStrFaxNo2());
			supplierDAO.setStrHospitalCode(vo.getStrHospCode());
			supplierDAO.setStrIsValid(vo.getStrIsValid());

			supplierDAO.setStrPhone1(vo.getStrPhoneNo1());
			supplierDAO.setStrPhone2(vo.getStrPhoneNo2());
			supplierDAO.setStrPinCode(vo.getStrPincode());

			supplierDAO.setStrRemarks(vo.getStrRemarks());
			supplierDAO.setStrSeatId(vo.getStrSeatId());
			supplierDAO.setStrStoreTypeId(vo.getStrItemCatNo());
			supplierDAO.setStrSupplierGradeId(vo.getStrSupplierGrade());
			supplierDAO.setStrSupplierName(vo.getStrSupplierName());
			supplierDAO.setStrSupplierStatus(vo.getStrSupplierStatus());
			// supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			supplierDAO.setStrWebSite(vo.getStrWebsite());
			supplierDAO.setStrSupplierId(vo.getStrSupplierId());
			supplierDAO.setStrIsSupplier(vo.getStrIsSupplier());
			supplierDAO.setStrIsManufacturer(vo.getStrIsManufacturer());
			supplierDAO.setStrIsAgent(vo.getStrIsAgent());
			supplierDAO.setStrIsBuyer(vo.getStrIsBuyer());
			supplierDAO.setStrLstNo(vo.getStrLstNo());
			supplierDAO.setStrCstNo(vo.getStrCstNo());
			supplierDAO.setStrPANNo(vo.getStrPANNo());
			supplierDAO.setStrSupplierType(vo.getStrSupplierType());
			// // //System.out.println("update
			// getStrLocalPurchaseSuppFlag"+vo.getStrLocalPurchaseSuppFlag());

			// supplierDAO.setStrLocalPurchaseSuppFlag(vo.getStrLocalPurchaseSuppFlag());
			supplierDAO.setStrForeignerSuppFlag(vo.getStrForeignerSuppFlag());

			/* Aritra */
			supplierDAO.setStrContractNo(vo.getStrContractNo());
			supplierDAO.setStrContractDate(vo.getStrContractDate());
			supplierDAO.setStrExpiryDate(vo.getStrExpiryDate());
			
			supplierDAO.setStrCountryCode(vo.getStrCountryCode());
			supplierDAO.setStrStateCode(vo.getStrStateCode());
			supplierDAO.setStrSuppTurnOver(vo.getStrSuppTurnOver());
			supplierDAO.setStrSuppTurnOverUnit(vo.getStrSuppTurnOverUnit());
			supplierDAO.setStrSupplierProvMaintenance(vo.getStrSupplierProvMaintenance());
			supplierDAO.setStrEsclationMtxAvl(vo.getStrEsclationMtxAvl());
			
			supplierDAO.setStrSlNo(vo.getStrSlNo());
			supplierDAO.setStrWhetherSupplierInterfacerequired(vo.getStrWhetherSupplierInterfacerequired());
			
			supplierDAO.update(dao);

            ////System.out.println("Level One:::"+vo.getStrLevelOneEsc()+"::Level Two::"+vo.getStrLevelTwoEsc());
            
            blackListSupp.setStrSeatId(vo.getStrSeatId());
			blackListSupp.setStrSupplierId(vo.getStrSupplierId());
			blackListSupp.setStrHospitalCode(vo.getStrHospCode());
			blackListSupp.updateEsc(dao);
            
            if(vo.getStrLevelOneEsc().equals("1") && vo.getStrLevelTwoEsc().equals("1"))
			{
				for(int i=0;i<2;i++)
				{
				    ////System.out.println("When Both Level Selected in Updated ::"+i);
                    j++;
                    
                   
                    
					blackListSupp.setStrSupplierId(vo.getStrSupplierId());
					blackListSupp.setStrEscLevel(String.valueOf(j));
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrSupplierId(vo.getStrSupplierId());
					blackListSupp.setStrEscLevel(String.valueOf(j));
					blackListSupp.setStrHospitalCode(vo.getStrHospCode());
					blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
					blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
					blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
					blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
					blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
					blackListSupp.insertSupplierEsc(dao);
					
				}	
				
				
			}
			else
			{
				
				if(vo.getStrLevelOneEsc().equals("1"))
				{
					for(int i=0;i<1;i++)
					{
						j++;
						//System.out.println("When Single Level Selected in Updated");
												
						blackListSupp.setStrSupplierId(vo.getStrSupplierId());
						blackListSupp.setStrEscLevel(String.valueOf(j));
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrSupplierId(vo.getStrSupplierId());
						blackListSupp.setStrEscLevel(String.valueOf(j));
						blackListSupp.setStrHospitalCode(vo.getStrHospCode());
						blackListSupp.setStrCotactPersonForEsc(vo.getStrCotactPersonForEsc()[i]);
						blackListSupp.setStrContactPersonDesgForEsc(vo.getStrContactPersonDesgForEsc()[i]);
						blackListSupp.setStrCotactEmailIdForEsc(vo.getStrCotactEmailIdForEsc()[i]);
						blackListSupp.setStrCotactNoForEsc(vo.getStrCotactNoForEsc()[i]);
						blackListSupp.setStrCotactFaxForEsc(vo.getStrCotactFaxForEsc()[i]);
						
						
						blackListSupp.insertSupplierEsc(dao);
					}	
										
				}
				
			}
			
			if (vo.getStrSupplierStatus().equals("2")
					|| vo.getStrIsBlackListMod().equals("1")) {

				blackListSupp.setStrActionDate(vo.getStrActionDate());
				blackListSupp.setStrCommitteeNo(vo.getStrCommitee());
				blackListSupp.setStrHospitalCode(vo.getStrHospCode());
				if (vo.getStrSupplierStatus().equals("2")) {
					blackListSupp.setStrIsBlackListFlag("1");
				} else {
					blackListSupp.setStrIsBlackListFlag("0");
				}
				blackListSupp.setStrRemarks(vo.getStrBlackListedRemarks());
				blackListSupp.setStrSeatId(vo.getStrSeatId());
				blackListSupp.setStrIsValid(vo.getStrIsValid());
				// blackListSupp.setStrSuppSlno(strslno);
				// blackListSupp.setStrStoreTypeId(vo.getStrItemCatNo());
				blackListSupp.setStrSupplierId(vo.getStrSupplierId());
				blackListSupp.update(dao);

				blackListSupp.setStrActionDate(vo.getStrActionDate());
				blackListSupp.setStrCommitteeNo(vo.getStrCommitee());
				blackListSupp.setStrHospitalCode(vo.getStrHospCode());
				blackListSupp.setStrRemarks(vo.getStrBlackListedRemarks());
				blackListSupp.setStrSeatId(vo.getStrSeatId());
				blackListSupp.setStrIsValid(vo.getStrIsValid());
				// blackListSupp.setStrSuppSlno(strslno);
				// blackListSupp.setStrStoreTypeId(vo.getStrItemCatNo());
				blackListSupp.setStrSupplierId(vo.getStrSupplierId());

				blackListSupp.insert(dao);
			}
			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.update() --> " + e.getMessage());
			//System.out.println(	vo.getStrMsgString());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			supplierDAO = null;
			blackListSupp = null;
			// web = null;
		}
	}

	/*
	 * This function check whether data of same name is already exist for same
	 * supplier type id
	 * 
	 */
	/**
	 * Check duplicay add.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void CheckDuplicayAdd(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.9");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSupplierName());
			web = dao.executeQry(nQueryIndex);
			while (web.next()) {
				ncount = Integer.parseInt(web.getString(1));
			}

			// // //System.out.println("ncount="+ncount);
			if (ncount == 0) {
				vo.setIsFlag(true);
			} else {
				vo.setIsFlag(false);
			}

		} catch (Exception e) {

			vo.setStrMsgString("SupplierMstDAO.CheckDuplicayAdd() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}

	}

	/*
	 * This function check whether data of same name is already exist other same
	 * supplier type id
	 * 
	 */
	/**
	 * Check duplicay modi.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void CheckDuplicayModi(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.10");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrSupplierId());
			dao.setQryValue(nQueryIndex, 3, vo.getStrSupplierName());
			dao.setQryValue(nQueryIndex, 4, vo.getStrItemCatNo());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				ncount = Integer.parseInt(web.getString(1));
			}

			// // //System.out.println("ncount="+ncount);
			if (ncount == 0) {
				vo.setIsFlag(true);
			} else {
				vo.setIsFlag(false);
			}

		} catch (Exception e) {

			vo.setStrMsgString("SupplierMstDAO.CheckDuplicayModi() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}

	}

	/**
	 * This function is used to bring details in supplier Grade Combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getSupplierGrade(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.3");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			vo.setSupplierGradeWS(web);
		} catch (Exception e) {
			vo.setStrMsgString("SupplierMstDAO.getSupplierGrade() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used to bring details in Committe Combo.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getCommiteeDtl(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.4");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			// dao.setQryValue(nQueryIndex, 2, vo.getStrItemCatNo());
			web = null;
			web = dao.executeQry(nQueryIndex);
			vo.setCommiteeNameWS(web);
		} catch (Exception e) {
			// e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.getCommiteeDtl() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used set initial parameters for view page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void view(SupplierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		WebRowSet web1 = null;
		int j=0;
		String strQuery1 = "";
		int nQueryIndex1 = 0;
		try {

			dao = new HisDAO("mms", "SupplierMstDAO");
			strQuery = mms.qryHandler_mms.getQuery(1, "select.supplier.view.0");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrSupplierId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {

				vo.setStrSupplierName(web.getString(1));
				vo.setStrItemCategoryName(web.getString(2));
				vo.setStrContactPerson(web.getString(3));
				vo.setStrAddress(web.getString(4));
				vo.setStrCity(web.getString(5));
				vo.setStrPincode(web.getString(6));
				vo.setStrPhoneNo1(web.getString(7));
				vo.setStrPhoneNo2(web.getString(8));
				String mail=web.getString(9).replaceAll("\\.", " \\ [dot]");
				String mail1=mail.replace("@", " [at]");
				
				vo.setStrEmailId1(mail1);
				String mail2=web.getString(10).replaceAll("\\.", " \\ [dot]");
				String mail3=mail2.replace("@", " [at]");
				
				vo.setStrEmailId2(mail3);
				vo.setStrFaxNo1(web.getString(11));
				vo.setStrFaxNo2(web.getString(12));
				vo.setStrWebsite(web.getString(13));
				vo.setStrSupplierStatus(web.getString(14));
				vo.setStrSupplierStatusCode(web.getString(14));
				vo.setStrRemarks(web.getString(15));
				vo.setStrEffectiveFrom(web.getString(16));
				vo.setStrIsValid(web.getString(17));
				vo.setStrSupplierGradeCode(web.getString(18));

				vo.setStrItemCatNo(web.getString(19));
				// vo.setStrLocalPurchaseSuppFlag(web.getString(20));
				vo.setStrLstNo(web.getString(20));
				vo.setStrCstNo(web.getString(21));
				vo.setStrPANNo(web.getString(22));
				vo.setStrIsSupplier(web.getString(23));
				vo.setStrIsManufacturer(web.getString(24));
				vo.setStrIsAgent(web.getString(25));
				vo.setStrIsBuyer(web.getString(26));
				vo.setStrSupplierGrade(web.getString(27));
				vo.setStrForeignerSuppFlag(web.getString(28));
				vo.setStrCountryCode(web.getString(29));
				vo.setStrStateCode(web.getString(30));

				/* Aritra */
				vo.setStrContractNo(web.getString(31));
				vo.setStrContractDate(web.getString(32));
				vo.setStrExpiryDate(web.getString(33));
				vo.setStrSupplierType(web.getString(34));
				vo.setStrSuppTurnOver(web.getString(35));
				vo.setStrSuppTurnOverUnit(web.getString(36));
				
				vo.setStrSupplierProvMaintenance(web.getString(37));
				vo.setStrEsclationMtxAvl(web.getString(38));
				vo.setStrWhetherSupplierInterfacerequired(web.getString(39));
				// // //System.out.println("modify
				// getStrLocalPurchaseSuppFlag"+vo.getStrLocalPurchaseSuppFlag());
				if (vo.getStrSupplierStatus().equals("2")) {
					strQuery = mms.qryHandler_mms.getQuery(1,
							"select.supplier.view.1");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrSupplierId());
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex, 3, vo.getStrSupplierId());
					dao.setQryValue(nQueryIndex, 4, vo.getStrHospCode());
					web = dao.executeQry(nQueryIndex);
					if (web.next()) {
						vo.setStrActionDate(web.getString(1));
						vo.setStrBlackListedRemarks(web.getString(2));
						vo.setStrCommitteCode(web.getString(3));
						vo.setStrCommitee(web.getString(4));
					}

					vo.setStrIsBlackListMod("1");
				} else {
					vo.setStrIsBlackListMod("0");
				}

				/* Aritra */
				if (!"0".equals(vo.getStrSupplierType())) {
					strQuery = mms.qryHandler_mms.getQuery(1,
							"select.supplier.view.2");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex, 2, vo.getStrSupplierType());
					web = dao.executeQry(nQueryIndex);
					if (web.next()) {
						vo.setStrSupplierType(web.getString(1));
					}
				}

			}
			
			strQuery1 = mms.qryHandler_mms.getQuery(1,"select.supplier.88");
			nQueryIndex1 = dao.setQuery(strQuery1);
			dao.setQryValue(nQueryIndex1, 1, vo.getStrSupplierId());
			dao.setQryValue(nQueryIndex1, 2, vo.getStrHospCode());
		
			if (vo.getStrEsclationMtxAvl().equals("1")) 
			{				
				web1 = dao.executeQry(nQueryIndex1);
				
				String arr1[] = new String[web1.size()];
				String arr2[] = new String[web1.size()];
				String arr3[] = new String[web1.size()];
				String arr4[] = new String[web1.size()];
				String arr5[] = new String[web1.size()];
				String arr6[] = new String[web1.size()];
				
                for(int k =0;web1.next();k++) 
				{
                	
					arr1[k] = web1.getString(1);
					arr2[k] = web1.getString(2);
					arr3[k] = web1.getString(3);
					arr4[k] = web1.getString(4);
					arr5[k] = web1.getString(5);
					arr6[k] = web1.getString(6);
					j++;
					
				}
                vo.setStrCotactPersonForEsc(arr2);

				vo.setStrContactPersonDesgForEsc(arr3);

				vo.setStrCotactEmailIdForEsc(arr4);

				vo.setStrCotactNoForEsc(arr5);

				vo.setStrCotactFaxForEsc(arr6);
			}
			
				if(j>1)
				{
					vo.setStrLevelOneEsc("1");
					vo.setStrLevelTwoEsc("1");
				}
				else
				{
					vo.setStrLevelOneEsc("1");
					vo.setStrLevelTwoEsc("0");
					
				}	
				

		} catch (Exception e) {
			 e.printStackTrace();
			vo.setStrMsgString("SupplierMstDAO.view() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}

			web = null;
		}
	}

}
