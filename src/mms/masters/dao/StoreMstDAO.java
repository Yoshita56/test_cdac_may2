package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import mms.dao.StoreDAO;
import mms.masters.vo.StoreMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreMstDAO.
 */
public class StoreMstDAO {

	/**
	 * TO GET DEPARTMENT, INCHARGE & BUILDING combo on add page.
	 * 
	 * @param vo the vo
	 */
	public static void initAddQuery(StoreMstVO vo) 
	{
		HisDAO dao = null;
		int nqryIndex,nqryIndex1,nqryIndex2,nqryIndexdept;
		String strquery = "";
		String strdeptquery = "";
		String strquery1 = "";
		String strQuery2;
		WebRowSet wb = null, wb2 = null,wb3 = null,wb4 = null;

		try 
		{			
			dao = new HisDAO("mms", "StoreMstDAO");
			
			if((vo.getStrStoreId()==null||vo.getStrStoreId().equals("")))
			{
				vo.setStrStoreId("0");
				/*
				strquery = "SELECT A.GNUM_DEPT_CODE ,Initcap(A.GSTR_DEPT_NAME)"
						+ "FROM GBLT_DEPARTMENT_MST A "
						+ "where A.GNUM_HOSPITAL_CODE ="+vo.getStrHospitalCode()+" "
						+ "AND A.GNUM_ISVALID IN ('1','2')"
						+ "AND NOT EXISTS"
						+ "("
						+ "SELECT 'X' "
						+ "FROM hstt_store_dept_mst "
						+ "WHERE  GNUM_ISVALID = 1 "
						+ "AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE	"						
						+ "AND GNUM_DEPT_CODE = A.GNUM_DEPT_CODE"
						+ ")"
						+ "ORDER BY GSTR_DEPT_NAME";
						*/
				strquery = "SELECT A.GNUM_DEPT_CODE ,Initcap(A.GSTR_DEPT_NAME)"
						+ "FROM GBLT_DEPARTMENT_MST A "
						+ "where A.GNUM_HOSPITAL_CODE ="+vo.getStrHospitalCode()+" "
						+ "AND A.GNUM_ISVALID IN ('1','2')"
				        + "ORDER BY GSTR_DEPT_NAME";
				
			}
			else		
			{
			
			
				strquery = "SELECT A.GNUM_DEPT_CODE ,Initcap(A.GSTR_DEPT_NAME)"
						+ "FROM GBLT_DEPARTMENT_MST A "
						+ "where A.GNUM_HOSPITAL_CODE ="+vo.getStrHospitalCode()+" "
						+ "AND A.GNUM_ISVALID IN ('1','2')"
						+ "AND NOT EXISTS"
						+ "("
						+ "SELECT 'X' "
						+ "FROM hstt_store_dept_mst "
						+ "WHERE  GNUM_ISVALID = 1 "
						+ "AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE	"
						+ "AND HSTNUM_STORE_ID = "+vo.getStrStoreId()+"	"
						+ "AND GNUM_DEPT_CODE = A.GNUM_DEPT_CODE"
						+ ")"
						+ "ORDER BY GSTR_DEPT_NAME";
			}
			System.out.println("DEPT_MST--strquery---"+strquery);
			nqryIndex = dao.setQuery(strquery);			
			wb = dao.executeQry(nqryIndex);
			vo.setStrDepartmentComboWs(wb);
				
			
			if(vo.getStrMode().equals("1"))//If Modify
			{
				strquery1 = mms.qryHandler_mms.getQuery(1, "select.StoreIncharge.10");//LEFT LIST
		        nqryIndex1 = dao.setQuery(strquery1);
		        
		        dao.setQryValue(nqryIndex1, 1, vo.getStrHospitalCode());
		        dao.setQryValue(nqryIndex1, 2, vo.getStrStoreId());
		        wb = dao.executeQry(nqryIndex1);
		        vo.setStrInchargeCmbWs(wb);
				
				strquery = mms.qryHandler_mms.getQuery(1, "select.StoreIncharge.11");//RIGHT LIST
				nqryIndex = dao.setQuery(strquery);
		        dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
		        dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
		        wb = dao.executeQry(nqryIndex);
		        vo.setStrRigthCmbWs(wb);
		        
		        
		        
		        strdeptquery = mms.qryHandler_mms.getQuery(1, "select.StoreDept.11");//RIGHT LIST Dept
		        nqryIndexdept = dao.setQuery(strdeptquery);
		        dao.setQryValue(nqryIndexdept, 1, vo.getStrHospitalCode());
		        dao.setQryValue(nqryIndexdept, 2, vo.getStrStoreId());
		        wb = dao.executeQry(nqryIndexdept);
		        vo.setStrRigthDeptCmbWs(wb);
		        
		        
			}
			else
			{
				strquery = mms.qryHandler_mms.getQuery(1, "select.StoreIncharge.0").replace("?", vo.getStrHospitalCode());
		        nqryIndex = dao.setQuery(strquery);
				wb = dao.executeQry(nqryIndex);
				vo.setStrInchargeCmbWs(wb);
			}	
			
		
			// Change Request for Drug Warehouse Type Combo
			
			strQuery2 = mms.qryHandler_mms.getQuery(1, "select.DrugWarehouseType.cmb.storetype");
			nqryIndex2 = dao.setQuery(strQuery2);
			//dao.setQryValue(nqryIndex2, 1, Config.SUPER_USER_HOSPITAL_CODE); commented by shalini as  hospital code is not in use as discussed with priyesh sir
			wb2 = dao.executeQry(nqryIndex2);
			vo.setStrDrugWarehouseTypeCmb(wb2);
			
			
			
			
			strquery = "select gnum_type_id,UPPER(gststr_type_name) from global_hospital_type_mst where gnum_isvalid = 1  ORDER BY  UPPER(gststr_type_name)";
			
			//System.out.println("strquery---"+strquery);
			nqryIndex = dao.setQuery(strquery);			
			wb = dao.executeQry(nqryIndex);
			vo.setStrHospitalTypeCmbWs(wb);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("--> StoreMstDAO.initAddQuery()-->"+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}

		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param vo the vo
	 */
	public static void insertQuery(StoreMstVO vo) 
	{
		HisDAO dao = null;
		StoreDAO storeDAO = null;	
		int nProcIndex1 = 0;
		int funcIndex = 0;
		String strStoreId;

		try 
		{
			dao = new HisDAO("mms", "StoreMstDAO");
			
			//get_store_id (hosp_code NUMBER, strlevel NUMBER, strtypeid NUMBER)
			 funcIndex = dao.setFunction("{? = call MMS_MST.get_store_id(?::numeric,?::numeric,?::numeric)}");
			// Set Value
			 dao.setFuncInValue(funcIndex,2,vo.getStrHospitalCode());
			 dao.setFuncInValue(funcIndex,3,vo.getStrStoreLevel());
			 dao.setFuncInValue(funcIndex,4,vo.getStrStoreTypeId());
			 dao.setFuncOutValue(funcIndex,3);
			 dao.executeFuncForNumeric(funcIndex);
			
			 strStoreId = dao.getFuncNumeric(funcIndex).toString(); 
			 
			
			
			storeDAO = new StoreDAO();
			storeDAO.setStrStoreId(strStoreId);
          	storeDAO.setStrEffectiveFrom((vo.getStrEffectiveFrom()==null||vo.getStrEffectiveFrom().equals(""))?"01-Jan-2025":vo.getStrEffectiveFrom());
			storeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeDAO.setStrIsValid(vo.getStrIsValid());
			storeDAO.setStrRemarks(vo.getStrRemarks());
			storeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());
			storeDAO.setStrSeatId(vo.getStrSeatId());

			storeDAO.setStrBlockId("0");
			storeDAO.setStrBuildingCode("0");
			storeDAO.setStrContactNo(vo.getStrContactNo());
			//storeDAO.setStrDeptCode("0");
			//storeDAO.setStrWardCode("0");
			storeDAO.setStrDeptCode("0");
			storeDAO.setStrWardCode("1");
			storeDAO.setStrEmpCode("0");
			storeDAO.setStrFloorId("0");
			storeDAO.setStrOwner((vo.getStrOwner()==null||vo.getStrOwner().equals(""))?"-":vo.getStrOwner());
			storeDAO.setStrOwnerAddress((vo.getStrOwnerAddress()==null||vo.getStrOwnerAddress().equals(""))?"-":vo.getStrOwnerAddress());
			storeDAO.setStrOwnerName((vo.getStrOwnerName()==null||vo.getStrOwnerName().equals(""))?"-":vo.getStrOwnerName());
			storeDAO.setStrStoreName(vo.getStrStoreName());
			storeDAO.setStrStoreLevel(vo.getStrStoreLevel());
			storeDAO.setStrPhoneNo("0");
			storeDAO.setStrFinEndDate("31-Mar-2026");
			storeDAO.setStrFinStartDate("01-Apr-2024");
			storeDAO.setStrItemBounded(vo.getStrItemBounded());
			storeDAO.setStrIsNewItemFlag(vo.getStrIsNewItemFlag());
			storeDAO.setStrSection(vo.getStrSection());
			storeDAO.setStrTimeBoundFlag(vo.getStrTimeBoundFlag());
			storeDAO.setStrToTime(vo.getStrToTime());
			storeDAO.setStrFromTime(vo.getStrFromTime());
			storeDAO.setStrLocation(vo.getStrLocation());
			storeDAO.setStrDistrictId("0");
			storeDAO.setStrHeader1(vo.getStrHeader1()); // Address 1
			storeDAO.setStrHeader2(vo.getStrHeader2()); // Address 2
			storeDAO.setStrHeader3(vo.getStrHeader3());	// Address 3	
			storeDAO.setStrMapHospId(vo.getStrMapHospId());
			storeDAO.setStrCatgCode(vo.getStrConfigStoreCatg());  // instead of 10, vo.getStrConfigStoreCatg() is set, by Adil
			storeDAO.setStrEntryDate(vo.getStrEntryDate());
			//String strIsDWHId = vo.getStrDrugWarehouseTypeId().split("\\^")[1];
			
			storeDAO.setStrDrugWarehouseTypeId((vo.getStrDrugWarehouseTypeId().split("\\^")[0]==null||vo.getStrDrugWarehouseTypeId().split("\\^")[0].equals(""))?"-":vo.getStrDrugWarehouseTypeId().split("\\^")[0]);
			storeDAO.setStrCode((vo.getStrCode()==null||vo.getStrCode().equals(""))?"-":vo.getStrCode());
			storeDAO.setStrNoOfBeds("0");
			
			if(vo.getStrSection().equals("1")){
				storeDAO.setStrPurchasingMode("0");
			}else{
				storeDAO.setStrPurchasingMode(vo.getStrPurchasingMode());
			}
			
			//System.out.println("strStoreId--->>"+strStoreId);
			
			storeDAO.setStrParentDistricWarehouseId(strStoreId);
			/*if(strIsDWHId.equals("1"))
				storeDAO.setStrParentDistricWarehouseId(strStoreId);
			else				
				storeDAO.setStrParentDistricWarehouseId(strStoreId);*/	
			//storeDAO.setStrParentDistricWarehouseId(vo.getStrDistrictDrugWarehouseType());
			storeDAO.setStrDLNo((vo.getStrDLNo()==null||vo.getStrDLNo().equals(""))?"0":vo.getStrDLNo());
			storeDAO.setStrEmdType((vo.getStrEmdType()==null||vo.getStrEmdType().equals(""))?"0":vo.getStrEmdType());
			storeDAO.setStrMapHospId((vo.getStrHospitalTypeId()==null||vo.getStrHospitalTypeId().equals(""))?"0":vo.getStrHospitalTypeId());
			storeDAO.insert(dao);
			
			String strProcName2 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_EMP_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			//System.out.println("strProcName2--->>"+strProcName2);
			
			for (int i = 0; i < vo.getStrRightRequestTypes().length; i++) 
			{		      
//					System.out.println("----getStrRightRequestTypes---"+vo.getStrRightRequestTypes()[i]);
//					System.out.println("----getStrRightDeptReqTypes---"+vo.getStrRightDeptReqTypes()[i]);
					
				    nProcIndex1 = dao.setProcedure(strProcName2);
				    dao.setProcInValue(nProcIndex1, "p_mode", "1",1);                                    //1
			        dao.setProcInValue(nProcIndex1, "p_HSTNUM_STORE_ID", strStoreId,2);          //2
					dao.setProcInValue(nProcIndex1, "p_STR_EMP_NO", vo.getStrRightRequestTypes()[i],3);  //3
					dao.setProcInValue(nProcIndex1, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);  //4
					dao.setProcInValue(nProcIndex1, "p_HSTNUM_SLNO", "0",5); // Genrated by Function     //5
    				dao.setProcInValue(nProcIndex1, "p_GDT_EFFECTIVE_FRM",vo.getStrEffectiveFrom().equalsIgnoreCase("")||vo.getStrEffectiveFrom().equalsIgnoreCase(null)?"sysdate":vo.getStrEffectiveFrom(),6);   //6
					dao.setProcInValue(nProcIndex1, "p_GDT_EFFECTIVE_TO","",7);                //7
					dao.setProcInValue(nProcIndex1, "p_GDT_LSTMOD_DATE", "",8);                //8
					dao.setProcInValue(nProcIndex1, "p_GNUM_LSTMOD_SEATID", "0",9);             //9
					dao.setProcInValue(nProcIndex1, "p_GDT_ENTRY_DATE", "sysdate",10);                 //10
					dao.setProcInValue(nProcIndex1, "p_GNUM_SEATID", vo.getStrSeatId(),11);     //11
					dao.setProcInValue(nProcIndex1, "p_GNUM_ISVALID", "1",12);                  //12
					dao.setProcOutValue(nProcIndex1,"err",1,13);                                //13
					dao.execute(nProcIndex1, 1);
			      
			}
			
			
			 
			String strProcName3 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_DEPT_MST(?,?,?,?,?,?,?,?)}";
			
			//System.out.println("strProcName3--->>"+strProcName3);
			
			for (int i = 0; i < vo.getStrRightDeptReqTypes().length; i++) 
			{		      
					
					System.out.println("----getStrRightDeptReqTypes---"+vo.getStrRightDeptReqTypes()[i]);
					
					
					
				    nProcIndex1 = dao.setProcedure(strProcName3);
				    dao.setProcInValue(nProcIndex1, "p_mode", "1",1);                                      //1
			        dao.setProcInValue(nProcIndex1, "p_HSTNUM_STORE_ID", strStoreId,2);          		   //2
					dao.setProcInValue(nProcIndex1, "p_STR_DEPT_NO", vo.getStrRightDeptReqTypes()[i],3);   //3
					dao.setProcInValue(nProcIndex1, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);    //4
    				dao.setProcInValue(nProcIndex1, "p_GDT_ENTRY_DATE", "sysdate",5);                      //5
					dao.setProcInValue(nProcIndex1, "p_GNUM_SEATID", vo.getStrSeatId(),6);                 //6
					dao.setProcInValue(nProcIndex1, "p_GNUM_ISVALID", "1",7);                              //7
					dao.setProcOutValue(nProcIndex1,"err",1,8);                                            //8
					
					dao.execute(nProcIndex1, 1);
			      
			}
			
			
			/* if(vo.getStrConfigStoreCatg().equals("10"))
			{
			
				String strProcName1 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_CATEGORY_MST(?,?::numeric,?::numeric,?::numeric,?::numeric,?,?::timetsamp,?::timestamp,?::timestamp,?::numeric,?::timestamp,?::numeric,?::numeric,?::numeric,?::timestamp,?::timestamp,?::numeric,?::numeric,?::numeric,?)}";
				nProcIndex = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProcIndex, "p_mode", "1",1);                          //1
				dao.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", strStoreId,2);//2
				dao.setProcInValue(nProcIndex, "p_SSTNUM_ITEM_CAT_NO", "10",3);           //3
				dao.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);  //4
				dao.setProcInValue(nProcIndex, "p_HSTNUM_CAT_SLNO", "0",5); // Genrated by Function //5
				dao.setProcInValue(nProcIndex, "p_GSTR_REMARKS", vo.getStrRemarks(),6);   //6
				dao.setProcInValue(nProcIndex, "p_GDT_EFFECTIVE_FRM", "sysdate",7);              //7
				dao.setProcInValue(nProcIndex, "p_GDT_EFFECTIVE_TO","",8);                //8
				dao.setProcInValue(nProcIndex, "p_GDT_LSTMOD_DATE", "",9);                //9
				dao.setProcInValue(nProcIndex, "p_GNUM_LSTMOD_SEATID", "0",10);             //10
				dao.setProcInValue(nProcIndex, "p_GDT_ENTRY_DATE", "",11);                 //11
				dao.setProcInValue(nProcIndex, "p_GNUM_SEATID", vo.getStrSeatId(),12);     //12
				dao.setProcInValue(nProcIndex, "p_GNUM_ISVALID", "1",13);                  //13
				dao.setProcInValue(nProcIndex, "p_HSTNUM_PHYSICAL_PERIOD","0",14);         //14
				dao.setProcInValue(nProcIndex, "p_HSTNUM_LSTPHYSICAL_DATE", "",15);        //15
				dao.setProcInValue(nProcIndex, "p_HSTNUM_LST_LSTPHYSICAL_DATE", "",16);    //16				
				dao.setProcInValue(nProcIndex, "p_HSTNUM_IS_STOCK_LEDGER_REQ","1",17);     //17
				dao.setProcInValue(nProcIndex, "p_HSTNUM_IS_ITEMBOUND", "0",18);           //18
				dao.setProcInValue(nProcIndex, "p_HSTNUM_NEWITEM_FLAG", "0",19);           //19
				dao.setProcOutValue(nProcIndex,"err",1,20);                                //20
				dao.execute(nProcIndex, 1);
				
			} */		

			synchronized (dao) 
			{
				dao.fire();
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//System.out.println("Error::::   "+e.getMessage());
			vo.setStrMsgString("--> StoreMstDAO.insertQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			storeDAO = null;
		}

	}
	
	/**
	 * to update the record.
	 * 
	 * @param vo the vo
	 */
	public static void updateQuery(StoreMstVO vo) 
	{

		HisDAO dao = null;
		StoreDAO storeDAO = null;
		int nProcIndex11,nProcIndex1 = 0;
		String strStoreId;

		try 
		{

			dao = new HisDAO("MMS", "StoreMstDAO");
			storeDAO = new StoreDAO();
			strStoreId = vo.getStrStoreId();
			storeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeDAO.setStrHospitalCode(vo.getStrHospitalCode());
			storeDAO.setStrIsValid(vo.getStrIsValid());
			storeDAO.setStrRemarks(vo.getStrRemarks());
			storeDAO.setStrStoreTypeId(vo.getStrStoreTypeId());
			storeDAO.setStrSeatId(vo.getStrSeatId());

			storeDAO.setStrBlockId("0");
			storeDAO.setStrBuildingCode("0");
			storeDAO.setStrContactNo(vo.getStrContactNo());
			storeDAO.setStrDeptCode("0");
			storeDAO.setStrEmpCode("0");
			storeDAO.setStrFloorId("0");
			storeDAO.setStrOwner(vo.getStrOwner());
			storeDAO.setStrOwnerAddress(vo.getStrOwnerAddress());
			storeDAO.setStrOwnerName(vo.getStrOwnerName());
			storeDAO.setStrStoreName(vo.getStrStoreName());
			storeDAO.setStrStoreLevel(vo.getStrStoreLevel());
			storeDAO.setStrPhoneNo(vo.getStrPhoneNo());
//			storeDAO.setStrWardCode(vo.getStrWardCode());
			storeDAO.setStrWardCode("0");
			storeDAO.setStrLocation(vo.getStrLocation());
			storeDAO.setStrDistrictId(vo.getStrDistrictId());
			storeDAO.setStrHeader1(vo.getStrHeader1()); // Address 1
			storeDAO.setStrHeader2(vo.getStrHeader2()); // Address 2
			storeDAO.setStrHeader3(vo.getStrHeader3());	// Address 3			
			storeDAO.setStrMapHospId((vo.getStrHospitalTypeId()==null||vo.getStrHospitalTypeId().equals(""))?"0":vo.getStrHospitalTypeId()); // Mapped Hosp Code With Raol
			storeDAO.setStrStoreId(vo.getStrStoreId());
			storeDAO.setStrItemBounded(vo.getStrItemBounded());
			storeDAO.setStrIsNewItemFlag(vo.getStrIsNewItemFlag());
			storeDAO.setStrSection(vo.getStrSection());
			System.out.println("Mapped Hospital Type----"+vo.getStrHospitalTypeId());
			
			//String strIsDWHId = vo.getStrDrugWarehouseTypeId().split("\\^")[1];
			
			storeDAO.setStrDrugWarehouseTypeId(vo.getStrDrugWarehouseTypeId().split("\\^")[0]);
			
			storeDAO.setStrCode(vo.getStrCode());
			storeDAO.setStrNoOfBeds(vo.getStrNoOfBeds());
			
			storeDAO.setStrParentDistricWarehouseId(strStoreId);
			/*if(strIsDWHId.equals("1"))
				storeDAO.setStrParentDistricWarehouseId(strStoreId);
			else				
				storeDAO.setStrParentDistricWarehouseId(strStoreId);	*/
			//storeDAO.setStrParentDistricWarehouseId(vo.getStrDistrictDrugWarehouseType());			
			
			storeDAO.setStrDLNo(vo.getStrDLNo());
			if(vo.getStrSection().equals("1"))
			{
					storeDAO.setStrPurchasingMode("0");
			}
			else
			{
					storeDAO.setStrPurchasingMode(vo.getStrPurchasingMode());
			}
			
			storeDAO.setStrFinStartDate(vo.getStrFinStartDate());
			storeDAO.setStrFinEndDate(vo.getStrFinEndDate());
			
			storeDAO.setStrTimeBoundFlag(vo.getStrTimeBoundFlag());
			storeDAO.setStrToTime(vo.getStrToTime());
			storeDAO.setStrFromTime(vo.getStrFromTime());
			storeDAO.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			storeDAO.setStrEmdType(vo.getStrEmdType());
						
			storeDAO.update(dao);
			       
			
            String strProcName2 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_EMP_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			
			for (int i = 0; i < vo.getStrRightRequestTypes().length; i++) 
			{		      
				   
				    nProcIndex11 = dao.setProcedure(strProcName2);
				    dao.setProcInValue(nProcIndex11, "p_mode", "1",1);                                    //1
			        dao.setProcInValue(nProcIndex11, "p_HSTNUM_STORE_ID", strStoreId,2);          //2
					dao.setProcInValue(nProcIndex11, "p_STR_EMP_NO", vo.getStrRightRequestTypes()[i],3);  //3
					dao.setProcInValue(nProcIndex11, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);  //4
					dao.setProcInValue(nProcIndex11, "p_HSTNUM_SLNO", "0",5); // Genrated by Function     //5
    				dao.setProcInValue(nProcIndex11, "p_GDT_EFFECTIVE_FRM",vo.getStrEffectiveFrom(),6);   //6
					dao.setProcInValue(nProcIndex11, "p_GDT_EFFECTIVE_TO","",7);                //7
					dao.setProcInValue(nProcIndex11, "p_GDT_LSTMOD_DATE", "",8);                //8
					dao.setProcInValue(nProcIndex11, "p_GNUM_LSTMOD_SEATID", "",9);             //9
					dao.setProcInValue(nProcIndex11, "p_GDT_ENTRY_DATE", "",10);                 //10
					dao.setProcInValue(nProcIndex11, "p_GNUM_SEATID", vo.getStrSeatId(),11);     //11
					dao.setProcInValue(nProcIndex11, "p_GNUM_ISVALID", "1",12);                  //12
					dao.setProcOutValue(nProcIndex11,"err",1,13);                                //13
					dao.execute(nProcIndex11, 1);
			      
			}
			
			
			String strProcName3 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_DEPT_MST(?,?,?,?,?,?,?,?)}";
			
			for (int i = 0; i < vo.getStrRightDeptReqTypes().length; i++) // strRightDeptReqTypeList
			{		      
					
					System.out.println("----getStrRightDeptReqTypes---"+vo.getStrRightDeptReqTypes()[i]);
					
					
					
				    nProcIndex1 = dao.setProcedure(strProcName3);
				    dao.setProcInValue(nProcIndex1, "p_mode", "1",1);                                      //1
			        dao.setProcInValue(nProcIndex1, "p_HSTNUM_STORE_ID", strStoreId,2);          		   //2
					dao.setProcInValue(nProcIndex1, "p_STR_DEPT_NO", vo.getStrRightDeptReqTypes()[i],3);   //3
					dao.setProcInValue(nProcIndex1, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);    //4
    				dao.setProcInValue(nProcIndex1, "p_GDT_ENTRY_DATE", "sysdate",5);                      //5
					dao.setProcInValue(nProcIndex1, "p_GNUM_SEATID", vo.getStrSeatId(),6);                 //6
					dao.setProcInValue(nProcIndex1, "p_GNUM_ISVALID", "1",7);                              //7
					dao.setProcOutValue(nProcIndex1,"err",1,8);                                            //8
					
					dao.execute(nProcIndex1, 1);
			      
			}
			
			
			//Below lines are commented by Adil Wasi
			/*if(vo.getStrConfigStoreCatg().equals("10"))
			{
				String strProcName1 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_CATEGORY_MST(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				nProcIndex = dao.setProcedure(strProcName1);
				dao.setProcInValue(nProcIndex, "p_mode", "2");                          //1
				dao.setProcInValue(nProcIndex, "p_HSTNUM_STORE_ID", strStoreId);//2
				dao.setProcInValue(nProcIndex, "p_SSTNUM_ITEM_CAT_NO", "10");           //3
				dao.setProcInValue(nProcIndex, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode());  //4
				dao.setProcInValue(nProcIndex, "p_HSTNUM_CAT_SLNO", "0"); // Genrated by Function //5
				dao.setProcInValue(nProcIndex, "p_GSTR_REMARKS", vo.getStrRemarks());   //6
				dao.setProcInValue(nProcIndex, "p_GDT_EFFECTIVE_FRM", "");              //7
				dao.setProcInValue(nProcIndex, "p_GDT_EFFECTIVE_TO","");                //8
				dao.setProcInValue(nProcIndex, "p_GDT_LSTMOD_DATE", "");                //9
				dao.setProcInValue(nProcIndex, "p_GNUM_LSTMOD_SEATID", "");             //10
				dao.setProcInValue(nProcIndex, "p_GDT_ENTRY_DATE", "");                 //11
				dao.setProcInValue(nProcIndex, "p_GNUM_SEATID", vo.getStrSeatId());     //12
				dao.setProcInValue(nProcIndex, "p_GNUM_ISVALID", vo.getStrIsValid());                  //13
				dao.setProcInValue(nProcIndex, "p_HSTNUM_PHYSICAL_PERIOD","0");         //14
				dao.setProcInValue(nProcIndex, "p_HSTNUM_LSTPHYSICAL_DATE", "");        //15
				dao.setProcInValue(nProcIndex, "p_HSTNUM_LST_LSTPHYSICAL_DATE", "");    //16				
				dao.setProcInValue(nProcIndex, "p_HSTNUM_IS_STOCK_LEDGER_REQ","1");     //17
				dao.setProcInValue(nProcIndex, "p_HSTNUM_IS_ITEMBOUND", "0");           //18
				dao.setProcInValue(nProcIndex, "p_HSTNUM_NEWITEM_FLAG", "0");           //19
				dao.setProcOutValue(nProcIndex,"err",1);                                //20
				dao.execute(nProcIndex, 1);
				
			}	*/	

			

			synchronized (dao) {
				dao.fire();
			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("--> StoreMstDAO.updateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}
	
	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static boolean updateEmpList(StoreMstVO vo) 
	{
		HisDAO dao = null;
		boolean retVal = false;
		String strProcName3 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_EMP_MST(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
		try 
		{
			
			dao = new HisDAO("MMS","transactions.StoreMstDAO.updateEmpList()");
			
		
			
				nProcIndex1 = dao.setProcedure(strProcName3);
			    dao.setProcInValue(nProcIndex1, "p_mode", "2",1);                                    //1
		        dao.setProcInValue(nProcIndex1, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);          //2
				dao.setProcInValue(nProcIndex1, "p_STR_EMP_NO", "0",3);  //3
				dao.setProcInValue(nProcIndex1, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);  //4
				dao.setProcInValue(nProcIndex1, "p_HSTNUM_SLNO", "0",5); // Genrated by Function     //5
				dao.setProcInValue(nProcIndex1, "p_GDT_EFFECTIVE_FRM",vo.getStrEffectiveFrom(),6);   //6
				dao.setProcInValue(nProcIndex1, "p_GDT_EFFECTIVE_TO","",7);                //7
				dao.setProcInValue(nProcIndex1, "p_GDT_LSTMOD_DATE", "",8);                //8
				dao.setProcInValue(nProcIndex1, "p_GNUM_LSTMOD_SEATID", vo.getStrSeatId(),9);             //9
				dao.setProcInValue(nProcIndex1, "p_GDT_ENTRY_DATE", "",10);                 //10
				dao.setProcInValue(nProcIndex1, "p_GNUM_SEATID", vo.getStrSeatId(),11);     //11
				dao.setProcInValue(nProcIndex1, "p_GNUM_ISVALID", "1",12);                  //12
				dao.setProcOutValue(nProcIndex1,"err",1,13);                                //13
				dao.execute(nProcIndex1, 1);
					  
			
			synchronized (dao) 
			{
				dao.fire();
				retVal = true;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("--> StoreMstDAO.updateEmpList()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
		}
		return retVal;

	}

	public static void updateDeptList(StoreMstVO vo) 
	{
		HisDAO dao = null;
//		boolean retVal = false;
		String strProcName3 = "{call Pkg_Mms_Dml.proc_HSTT_STORE_DEPT_MST(?,?,?,?,?,?,?,?)}";
		int nProcIndex1 = 0;
				
		try 
		{
			
			    dao = new HisDAO("MMS","transactions.StoreMstDAO.updateEmpList()");

				nProcIndex1 = dao.setProcedure(strProcName3);
			    dao.setProcInValue(nProcIndex1, "p_mode", "2",1);                                    //1
		        dao.setProcInValue(nProcIndex1, "p_HSTNUM_STORE_ID", vo.getStrStoreId(),2);          //2
				dao.setProcInValue(nProcIndex1, "p_STR_DEPT_NO", "0",3);  //3
				dao.setProcInValue(nProcIndex1, "p_GNUM_HOSPITAL_CODE", vo.getStrHospitalCode(),4);  //4
				dao.setProcInValue(nProcIndex1, "p_GDT_ENTRY_DATE", "",5);                 //10
				dao.setProcInValue(nProcIndex1, "p_GNUM_SEATID", vo.getStrSeatId(),6);     //11
				dao.setProcInValue(nProcIndex1, "p_GNUM_ISVALID", "1",7);                  //12
				dao.setProcOutValue(nProcIndex1,"err",1,8);                                //13
				dao.execute(nProcIndex1, 1);

			synchronized (dao) 
			{
				dao.fire();
//				retVal = true;
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("--> StoreMstDAO.updateEmpList()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null)
				dao.free();
			dao = null;
		}
//		return retVal;

	}

	/**
	 * to check duplicate before insert record.
	 * 
	 * @param vo the vo
	 */
	public static void chkDuplicate(StoreMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.Store.2");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrStoreName());
			//dao.setQryValue(nqryIndex, 2, vo.getStrStoreTypeId());
			
			//dao.setQryValue(nqryIndex, 2, vo.getStrCode());
			//dao.setQryValue(nqryIndex, 3, vo.getStrStateShortCode()+"-0");
			
			dao.setQryValue(nqryIndex, 2, vo.getStrHospitalCode());
			
			
			//System.out.println(vo.getStrStoreName()+" "+vo.getStrCode()+" "+vo.getStrStateShortCode()+"-0" +" "+vo.getStrHospitalCode() );
			wb = dao.executeQry(nqryIndex);
			//System.out.println(" (wb.size()" + wb.size());

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}
		} catch (Exception e) {
			vo.setStrMsgString("--> StoreMstDAO.chkDuplicate()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * to get data for modify page.
	 * 
	 * @param vo the vo
	 */
	public static void modifyQuery(StoreMstVO vo) {
		HisDAO dao = null;
		int nqryIndex;
		String strquery = "";

		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.Store.3");

			nqryIndex = dao.setQuery(strquery);
			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrStoreId());
			
			WebRowSet web = dao.executeQry(nqryIndex);

			while (web.next()) 
			{
				vo.setStrStoreTypeId(web.getString(1));
				vo.setStrIsValid(web.getString(2));
				vo.setStrStoreName(web.getString(3));
				vo.setStrStoreLevel(web.getString(4));
				vo.setStrBuildingCode(web.getString(5));
				vo.setStrEmpCode(web.getString(6));
				vo.setStrBlockId(web.getString(7));
				vo.setStrFloorId(web.getString(8));
				vo.setStrOwnerName(web.getString(9));
				vo.setStrPhoneNo(web.getString(10));
				vo.setStrOwnerAddress(web.getString(11));
				vo.setStrDeptCode(web.getString(12));
				vo.setStrContactNo(web.getString(13));
				vo.setStrRemarks(web.getString(14));
				vo.setStrOwner(web.getString(15));
				vo.setStrEffectiveFrom(web.getString(16));
				vo.setStrWardCode(web.getString(17));
				vo.setStrFinStartDate(web.getString(18));
				vo.setStrFinEndDate(web.getString(19));
				vo.setStrItemBounded(web.getString(20));
				vo.setStrIsNewItemFlag(web.getString(21));
				vo.setStrSection(web.getString(22));
				vo.setStrPurchasingMode(web.getString(23));
				vo.setStrStartDateMonth(web.getString(24));
				vo.setStrStartDateYear(web.getString(25));
				vo.setStrEndDateMonth(web.getString(26));
				vo.setStrEndDateYear(web.getString(27));
				vo.setStrTimeBoundFlag(web.getString(28));
				vo.setStrFromTime(web.getString(29));
				vo.setStrToTime(web.getString(30));
				vo.setStrLocation(web.getString(31));
				vo.setStrDistrictId(web.getString(32));
				vo.setStrDrugWarehouseTypeId(web.getString(33)); // DWH Type Id
				vo.setStrCode(web.getString(34));
				vo.setStrNoOfBeds(web.getString(35));
				vo.setStrDistrictDrugWarehouseTypeId(web.getString(36));// Parent Store Id
				vo.setStrHeader1(web.getString(37));
				vo.setStrHeader2(web.getString(38));
				vo.setStrHeader3(web.getString(39));
				vo.setStrMapHospId(web.getString(40));
				vo.setStrDLNo(web.getString(41));
				vo.setStrEmdType(web.getString(42));
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreMstDAO.modifyQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * to check duplicate before update.
	 * 
	 * @param vo the vo
	 */
	public static void initialUpdateQuery(StoreMstVO vo) {

		HisDAO hisdao = null;
		int nqryIndex;
		int ncount = 0;
		WebRowSet wb = null;

		try {
			hisdao = new HisDAO("mms", "StoreMstDAO");
			String strquery = mms.qryHandler_mms.getQuery(1, "select.Store.4");

			nqryIndex = hisdao.setQuery(strquery);

			//hisdao.setQryValue(nqryIndex, 1, vo.getStrStoreName());
			
			hisdao.setQryValue(nqryIndex, 1, vo.getStrCode());
			hisdao.setQryValue(nqryIndex,2, vo.getStrStateShortCode()+"-0");
			hisdao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			hisdao.setQryValue(nqryIndex, 4, vo.getStrStoreId());
			
			
			//hisdao.setQryValue(nqryIndex, 4, vo.getStrStoreTypeId());

			wb = hisdao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));

			}
			if (ncount < 1) {
				vo.setBExistStatus(true);
			} else {
				vo.setBExistStatus(false);
			}

		} catch (Exception e) {
			vo.setStrMsgString("--> StoreMstDAO.initialUpdateQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (hisdao != null) {
				hisdao.free();
				hisdao = null;
			}
		}

	}

	

	/**
	 * To get option value of Block combo.
	 * 
	 * @param vo the vo
	 */
	public static void getBlockQuery(StoreMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.BlockName.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrBuildingCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrBlockCmbWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString(" --> StoreMstDAO.getBlockQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	/**
	 * To get option value of Floor combo.
	 * 
	 * @param vo the vo
	 */
	public static void getFloorQuery(StoreMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.FloorName.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrBuildingCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrBlockId());

			wb = dao.executeQry(nqryIndex);
			vo.setStrFloorCmbWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString(" --> StoreMstDAO.getFloorQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/**
	 * To get option value of Ward combo.
	 * 
	 * @param vo the vo
	 */
	public static void getWardQuery(StoreMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.WardName.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 2, vo.getStrDeptCode());
			dao.setQryValue(nqryIndex, 3, vo.getStrHospitalCode());
			dao.setQryValue(nqryIndex, 4, vo.getStrDeptCode());

			wb = dao.executeQry(nqryIndex);
			vo.setStrWardComboWs(wb);

		} catch (Exception e) {
			vo.setStrMsgString(" --> StoreMstDAO.getWardQuery()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	/**
	 * To get option value of Ward combo.
	 * 
	 * @param vo the vo
	 */
	public static void getDistrictDWHCmb(StoreMstVO vo) {

		HisDAO dao = null;
		int nqryIndex;
		WebRowSet wb = null;
		String strquery = "";
		try {
			dao = new HisDAO("mms", "StoreMstDAO");
			strquery = mms.qryHandler_mms.getQuery(1, "select.district.dwh.0");
			nqryIndex = dao.setQuery(strquery);

			dao.setQryValue(nqryIndex, 1, vo.getStrHospitalCode());
			

			wb = dao.executeQry(nqryIndex);
			
			vo.setStrDistrictDWHTypeCmb(wb);

		} catch (Exception e) {
			vo.setStrMsgString(" --> StoreMstDAO.getDistructDWHCmb()-->"
					+ e.getMessage());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}
	
	
	
	/**
	 * To get option value of Ward combo.
	 * 
	 * @param vo the vo
	 */
	public static void getMappedHospitalCmb(StoreMstVO voObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String strProcName = "{call Pkg_Mms_View.proc_raol_hospital_list(?,?,?,?,?)}";
		int nProcIndex = 0;
	
		String strErr = "";

		try {

			daoObj = new HisDAO("DWH","BudgetDetailRptDAO");

			nProcIndex = daoObj.setProcedure(strProcName);

			
			daoObj.setProcInValue(nProcIndex, "modeval", "1");
			daoObj.setProcInValue(nProcIndex, "seatid", voObj.getStrSeatId());
			daoObj.setProcInValue(nProcIndex, "hosp_code", voObj.getStrHospitalCode());
			daoObj.setProcOutValue(nProcIndex, "err", 1);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2);

			daoObj.executeProcedure(nProcIndex);
	
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
				voObj.setStrMappedHospCmbWS(ws);
							
			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {

			voObj
					.setStrMsgString("BudgetDetailRptDAO.getStoreList() --> "
							+ e.getMessage());
			voObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
}