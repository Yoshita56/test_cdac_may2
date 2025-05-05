package dossier.masters.dao;

import javax.sql.rowset.WebRowSet;

import dossier.masters.vo.DossierMstVO;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.dao.SupplierDAO;
import mms.dao.BlackListSupplierDtlDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierMstDAO.
 */
public class DossierMstDAO {

	/**
	 * This function is used to initialize the initial parameters.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void getInitParam(DossierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		try {
			dao = new HisDAO("dossier", "DossierMstDAO");
			if(vo.getStrServiceTypeID().equalsIgnoreCase("11")) // For OT
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.OTNameLeft.10");//LEFT LIST
				nQueryIndex = dao.setQuery(strQuery);
			} else if(vo.getStrServiceTypeID().equalsIgnoreCase("12")) //Fro RADIOLOGY
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.LabNameLeft.10");//LEFT LIST
				nQueryIndex = dao.setQuery(strQuery);
			}else if(vo.getStrServiceTypeID().equalsIgnoreCase("13")) // For aSERVICE AREA
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.serviceleft.10");//LEFT LIST
				nQueryIndex = dao.setQuery(strQuery);
			}
			
	        
	        dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());

	        web = dao.executeQry(nQueryIndex);
	        vo.setStrLeftRequestTypesListWs(web);
			
	        strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.DeptRightListAdd.10");//RIGHT LIST
	        nQueryIndex = dao.setQuery(strQuery);
	        dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
	        
	        web = dao.executeQry(nQueryIndex);
	        vo.setStrRightRequestTypeListWs(web);
	        
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrServiceTypeID());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) 
			{
				vo.setStrServiceTypeName(web.getString(1));
			}
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierDepartment.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDepartmentCode());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) 
			{
				vo.setStrDepartmentName(web.getString(1));
			}
			*/
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierServiceTypeName.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			web = dao.executeQry(nQueryIndex);

			if (web.next()) 
			{
				vo.setStrServiceTypeName(web.getString(1));
			}*/
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.department.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDepartmentCode());
			web = dao.executeQry(nQueryIndex);
			System.out.println("\n Size webrowset-->"+web.size());
			vo.setDepartmentNameWS(web);
			*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.getInitParam() --> "
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
	public static void insert(DossierMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		WebRowSet web = null;
		
		String strDossierId="", strServiceId="" , strSlNo="" , strSlNoDept="";
		try 
		{
			dao = new HisDAO("dossier", "DossierMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.id.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strDossierId = web.getString(1);
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.slno.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strSlNo = web.getString(1);
			}
			
			
			strServiceId=strDossierId+vo.getStrServiceTypeID();	

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossier.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strDossierId);
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 5, vo.getStrDossierDescription());
			dao.setQryValue(nQueryIndex, 6, vo.getStrDossierType());
			dao.setQryValue(nQueryIndex, 7, strServiceId);
			dao.setQryValue(nQueryIndex, 8, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 9, vo.getStrBillingMode());
			dao.setQryValue(nQueryIndex, 10, vo.getStrItemIssueMode());
			dao.setQryValue(nQueryIndex, 11, vo.getStrCurrentDate());
			dao.setQryValue(nQueryIndex, 12, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 13, vo.getStrIsValid());
			dao.setQryValue(nQueryIndex, 14, strSlNo);
			dao.setQryValue(nQueryIndex, 15, vo.getStrDossierShortName());
			
			dao.execute(nQueryIndex, 0);

			System.out.println(" \n Dossier Id "+ strDossierId);
			System.out.println(vo.getStrHospCode());
			System.out.println(vo.getStrServiceTypeID());
			System.out.println(vo.getStrDossierName());
			System.out.println(vo.getStrDossierDescription());
			System.out.println(vo.getStrDossierType());
			System.out.println(strServiceId);
			System.out.println(vo.getStrBillingMode());
			System.out.println(vo.getStrItemIssueMode());
			System.out.println(vo.getStrCurrentDate());
			System.out.println(vo.getStrSeatId());
			System.out.println(strSlNo);
			
			synchronized (dao) 
			{
				dao.fire();
			}
			
			if(vo.getStrRightRequestTypes()!=null){
				System.out.println("in if part dao..--->>");
				for (int i = 0; i < vo.getStrRightRequestTypes().length; i++) 
				{	
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.dept.mst.slno.0");
					nQueryIndex = dao.setQuery(strQuery);
					web = dao.executeQry(nQueryIndex);
					if (web.next()) 
					{
						strSlNoDept = web.getString(1);
					}
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossier.dept.mst.0");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, strDossierId);
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
					dao.setQryValue(nQueryIndex, 4, vo.getStrRightRequestTypes()[i].split("\\^")[0]);
					dao.setQryValue(nQueryIndex, 5, vo.getStrRightRequestTypes()[i].split("\\^")[1]);
					dao.setQryValue(nQueryIndex, 6, vo.getStrCurrentDate());
					dao.setQryValue(nQueryIndex, 7, vo.getStrSeatId());
					dao.setQryValue(nQueryIndex, 8, vo.getStrIsValid());
					dao.setQryValue(nQueryIndex, 9, strSlNoDept);
					
					
					dao.execute(nQueryIndex, 0);

					System.out.println("sl no -->> dept code -->> "+strSlNoDept+" **** "+vo.getStrRightRequestTypes()[i]);
				   
					synchronized (dao) 
					{
						dao.fire();
					}
				}
			
				
			}
				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            vo.setStrMsgString("DossierMstDAO.insert() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used set initial parameters for modify page.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void modify(DossierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		
		try {

			dao = new HisDAO("dossier", "DossierMstDAO");
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.department.11");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			
			web = dao.executeQry(nQueryIndex);
			System.out.println("\n Size webrowset-->"+web.size());
			vo.setDepartmentNameWS(web);*/
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierService.dossierServiceType.0");
			nQueryIndex = dao.setQuery(strQuery);
			web = dao.executeQry(nQueryIndex);
			System.out.println("\n Size webrowset-->"+web.size());
			vo.setServiceTypeNameWS(web);
			*/
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierServiceName.modify.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrServiceTypeID());
			web = dao.executeQry(nQueryIndex);
			
			if (web.next()) 
			{
				vo.setStrServiceTypeName(web.getString(1));
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.6");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			/*dao.setQryValue(nQueryIndex, 3, vo.getStrSeatId());*/
			dao.setQryValue(nQueryIndex, 3, vo.getStrIsValid());
			dao.setQryValue(nQueryIndex, 4, vo.getStrServiceTypeID());
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				
				vo.setStrDossierName(web.getString(1));
				vo.setStrDossierDescription(web.getString(2));
				vo.setStrDossierShortName(web.getString(3));
					
			}
			
			if( vo.getStrServiceTypeID().equals("11"))
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.opName_update.10");
				nQueryIndex = dao.setQuery(strQuery);
			}else if( vo.getStrServiceTypeID().equals("12")){
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.opName_update.10");
				nQueryIndex = dao.setQuery(strQuery);
			}else
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.opName_update.10");
				nQueryIndex = dao.setQuery(strQuery);
			}
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 5, vo.getStrIsValid());
			
			web = dao.executeQry(nQueryIndex);
			
			vo.setStrRightRequestTypeListWs(web);
			
			if( vo.getStrServiceTypeID().equals("11"))
			{
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.opName.leftSide");
				nQueryIndex = dao.setQuery(strQuery);
			} else if( vo.getStrServiceTypeID().equals("12")){
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.testName.leftside");
				nQueryIndex = dao.setQuery(strQuery);
			} else {
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.serviceName.leftSide");
				nQueryIndex = dao.setQuery(strQuery);
			}
				
			
			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrServiceTypeID());
			
			web = dao.executeQry(nQueryIndex);
			
			vo.setStrLeftRequestTypesListWs(web);
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.modify() --> " + e.getMessage());
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
	 * This function is used to update previously existing records during click of modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void update(DossierMstVO vo) {
		HisDAO dao = null;
		int j = 0;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		String strServiceTypeName="";
		int ncount = 0;
		try {
            
			  dao = new HisDAO("dossier", "DossierMstDAO");
	   		    
			    System.out.println(" DAO Dossier id: --->>> "+vo.getStrDossierID());
				System.out.println("seat id : "+vo.getStrSeatId());
				System.out.println("hosp code: "+vo.getStrHospCode());
				System.out.println("service type id: "+vo.getStrServiceTypeID());
				System.out.println("gnum is valid old: "+vo.getStrIsValidOld());
				
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.totalCost.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 2, vo.getStrIsValidOld());
			dao.setQryValue(nQueryIndex, 3,vo.getStrHospCode() );
			dao.setQryValue(nQueryIndex, 4, vo.getStrServiceTypeID());
				
			web = dao.executeQry(nQueryIndex);
			
			if(web.next()){
				vo.setStrDossierTotalCost(web.getString(1));				
			}
			    
			  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossier.10");
			  nQueryIndex = dao.setQuery(strQuery);
			  dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			  dao.setQryValue(nQueryIndex, 2, vo.getStrSeatId()); 
			  dao.setQryValue(nQueryIndex, 3, vo.getStrDossierID()); 
			  dao.setQryValue(nQueryIndex, 4, vo.getStrServiceTypeID()); 
			  
			  dao.execute(nQueryIndex, 0);
			  
			  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossier.dept.mst.10");
			  nQueryIndex = dao.setQuery(strQuery);
			  dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
			  dao.setQryValue(nQueryIndex, 2, vo.getStrServiceTypeID()); 
			  dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode()); 
			  dao.setQryValue(nQueryIndex, 4, vo.getStrSeatId()); 
			  
			  dao.execute(nQueryIndex, 0);
			 
			  if(vo.getStrIsValid().equals("2")){
				  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierItem.10");
				  nQueryIndex = dao.setQuery(strQuery);
				  dao.setQryValue(nQueryIndex, 1, vo.getStrIsValid());
				  dao.setQryValue(nQueryIndex, 2, vo.getStrSeatId());
				  dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode()); 
				  dao.setQryValue(nQueryIndex, 4, vo.getStrDossierID());
				  dao.setQryValue(nQueryIndex, 5, vo.getStrIsValidOld());
				  
				  dao.execute(nQueryIndex, 0);
				  
			  }
			  else{
				  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierItem.10");
				  nQueryIndex = dao.setQuery(strQuery);
				  dao.setQryValue(nQueryIndex, 1, vo.getStrIsValid());
				  dao.setQryValue(nQueryIndex, 2, vo.getStrSeatId());
				  dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode()); 
				  dao.setQryValue(nQueryIndex, 4, vo.getStrDossierID());
				  dao.setQryValue(nQueryIndex, 5, vo.getStrIsValidOld());
				  
				  dao.execute(nQueryIndex, 0);
			  }
			  
			synchronized (dao) {
				dao.fire();
			}
			
			System.out.println("updated dossier mst");
			insertUpdate1(vo);
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.update() --> " + e.getMessage());
			System.out.println(	vo.getStrMsgString());
			vo.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			
		}
	}
	
	/**
	 * Funtion to update previously existing records in Dossier Item Master corresponding to Dossier
	 * 
	 * @param vo
	 */
	public static void insertUpdate(DossierMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		WebRowSet web = null;
		
		String strDossierId="", strServiceId="";
		try 
		{
			dao = new HisDAO("dossier", "DossierMstDAO");
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.id.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strDossierId = web.getString(1);
			}
			
			if(strDossierId.equals("")){
				strDossierId="11";
			}	*/
			
			if(vo.getStrIsValid().equals("0")){
				  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierItem.10");
				  nQueryIndex = dao.setQuery(strQuery);
				  dao.setQryValue(nQueryIndex, 1, vo.getStrSeatId());
				  dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode()); 
				  dao.setQryValue(nQueryIndex, 3, vo.getStrDossierID()); 
				  
				  dao.execute(nQueryIndex, 0);
				  
				  synchronized (dao) 
					{
						dao.fire();
					}
			  }
			  /*else{
				  strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "update.dossierItem.11");
				  nQueryIndex = dao.setQuery(strQuery);
				  dao.setQryValue(nQueryIndex, 1, strDossierId);
				  dao.setQryValue(nQueryIndex, 2, vo.getStrSeatId());
				  dao.setQryValue(nQueryIndex, 3, vo.getStrHospCode()); 
				  dao.setQryValue(nQueryIndex, 4, vo.getStrDossierID()); 
				  
				  dao.execute(nQueryIndex, 0);
			  }*/
			
			/*System.out.println(" \n Dossier Id "+ strDossierId);
			System.out.println(vo.getStrHospCode());
			System.out.println(vo.getStrServiceTypeID());
			System.out.println(vo.getStrDossierName());
			System.out.println(vo.getStrDossierDescription());
			System.out.println(vo.getStrDossierType());
			System.out.println(strServiceId);
			System.out.println(vo.getStrDossierName());
			System.out.println(vo.getStrBillingMode());
			System.out.println(vo.getStrItemIssueMode());
			System.out.println(vo.getStrCurrentDate());
			System.out.println(vo.getStrSeatId());*/
			
			/*vo.setStrDossierID(strDossierId);
			*/
			
			/*strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossier.0");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strDossierId);
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeName());
			dao.setQryValue(nQueryIndex, 4, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 5, vo.getStrDossierDescription());
			dao.setQryValue(nQueryIndex, 6, vo.getStrDossierType());
			dao.setQryValue(nQueryIndex, 7, vo.getStrDepartmentName());
			dao.setQryValue(nQueryIndex, 8, vo.getStrServiceID());
			dao.setQryValue(nQueryIndex, 9, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 10, vo.getStrBillingMode());
			dao.setQryValue(nQueryIndex, 11, vo.getStrItemIssueMode());
			dao.setQryValue(nQueryIndex, 12, vo.getStrCurrentDate());
			dao.setQryValue(nQueryIndex, 13, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 14, vo.getStrIsValid());
			
		
			dao.execute(nQueryIndex, 0);

*/			
			
			insertUpdate1(vo);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            vo.setStrMsgString("DossierMstDAO.insertUpdate() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			web = null;
		}
	}

	/**
	 * This function is used to update the records in database.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void insertUpdate1(DossierMstVO vo) 
	{
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		int j=0;
		WebRowSet web = null;
		
		String strDossierId="", strServiceId="" , strSlNo="" , strSlNoDept="";
		try 
		{
			dao = new HisDAO("dossier", "DossierMstDAO");
			
			strServiceId=vo.getStrDossierID()+vo.getStrServiceTypeID();	

			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.slno.0");
			nQueryIndex = dao.setQuery(strQuery);
			
			System.out.println("dossier previous total cost -->> "+vo.getStrDossierTotalCost());
			web = dao.executeQry(nQueryIndex);
			if (web.next()) 
			{
				strSlNo = web.getString(1);
			}
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossier.1");
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 5, vo.getStrDossierDescription());
			dao.setQryValue(nQueryIndex, 6, vo.getStrDossierType());
			dao.setQryValue(nQueryIndex, 7, strServiceId);
			dao.setQryValue(nQueryIndex, 8, vo.getStrDossierName());
			dao.setQryValue(nQueryIndex, 9, vo.getStrBillingMode());
			dao.setQryValue(nQueryIndex, 10, vo.getStrItemIssueMode());
			dao.setQryValue(nQueryIndex, 11, vo.getStrCurrentDate());
			dao.setQryValue(nQueryIndex, 12, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 13, vo.getStrIsValid());
			dao.setQryValue(nQueryIndex, 14, vo.getStrDossierTotalCost());
			dao.setQryValue(nQueryIndex, 15, strSlNo);
			dao.setQryValue(nQueryIndex, 16, vo.getStrDossierShortName());
			
			dao.execute(nQueryIndex, 0);

			System.out.println(" \n Dossier Id "+ vo.getStrDossierID());
			System.out.println(vo.getStrHospCode());
			System.out.println(vo.getStrServiceTypeID());
			System.out.println(vo.getStrDossierName());
			System.out.println(vo.getStrDossierDescription());
			System.out.println(vo.getStrDossierType());
			System.out.println(strServiceId);
			System.out.println(vo.getStrBillingMode());
			System.out.println(vo.getStrItemIssueMode());
			System.out.println(vo.getStrCurrentDate());
			System.out.println(vo.getStrSeatId());
			System.out.println(strSlNo);
			
			synchronized (dao) 
			{
				dao.fire();
			}
			
			if(vo.getStrRightRequestTypes()!=null){
				System.out.println("in if part dao..--->>");
				for (int i = 0; i < vo.getStrRightRequestTypes().length; i++) 
				{	
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.dept.mst.slno.0");
					nQueryIndex = dao.setQuery(strQuery);
					web = dao.executeQry(nQueryIndex);
					if (web.next()) 
					{
						strSlNoDept = web.getString(1);
					}
					
					strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "insert.dossier.dept.mst.0");
					nQueryIndex = dao.setQuery(strQuery);
					dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
					dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
					dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
					dao.setQryValue(nQueryIndex, 4, vo.getStrRightRequestTypes()[i].split("\\^")[0]);
					dao.setQryValue(nQueryIndex, 5, vo.getStrRightRequestTypes()[i].split("\\^")[1]);
					dao.setQryValue(nQueryIndex, 6, vo.getStrCurrentDate());
					dao.setQryValue(nQueryIndex, 7, vo.getStrSeatId());
					dao.setQryValue(nQueryIndex, 8, vo.getStrIsValid());
					dao.setQryValue(nQueryIndex, 9, strSlNoDept);
					
					
					dao.execute(nQueryIndex, 0);

					System.out.println("sl no -->> dept code -->> "+strSlNoDept+" **** "+vo.getStrRightRequestTypes()[i]);
				   
					synchronized (dao) 
					{
						dao.fire();
					}
				}
			
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            vo.setStrMsgString("DossierMstDAO.insertUpdate1() --> " + e.getMessage());
			vo.setStrMsgType("1");
		} 
		finally 
		{
			if (dao != null) 
			{
				dao.free();
				dao = null;
			}
			web = null;
		}
	}


	/*
	 * This function check whether data of same name is already exist for same
	 * supplier type id
	 * 
	 */
	/**
	 * Check duplicate add.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void CheckDuplicayAdd(DossierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {
				dao = new HisDAO("dossier", "DossierMstDAO");
				strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.9");
				nQueryIndex = dao.setQuery(strQuery);
				dao.setQryValue(nQueryIndex, 1, vo.getStrDossierName());
				dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
				dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
				
				web = dao.executeQry(nQueryIndex);
				while (web.next()) {
					ncount = Integer.parseInt(web.getString(1));
				}
	
				if (ncount == 0) {
					vo.setIsFlag(true);
				} else {
					vo.setIsFlag(false);
				}

		} catch (Exception e) {

			vo.setStrMsgString("DossierMstDAO.CheckDuplicayAdd() --> "
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
	 * Check duplicate modify.
	 * 
	 * @param vo
	 *            the vo
	 */
	public static void CheckDuplicayModi(DossierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int ncount = 0;
		try {

			dao = new HisDAO("dossier", "DossierMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.10");
			nQueryIndex = dao.setQuery(strQuery);

			dao.setQryValue(nQueryIndex, 1, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 2, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				ncount = Integer.parseInt(web.getString(1));
			}

			if (ncount == 0) {
				vo.setIsFlag(false);
			} else {
				vo.setIsFlag(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.CheckDuplicayModi() --> "
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
	public static void view(DossierMstVO vo) {
		HisDAO dao = null;
		String strQuery = "";
		int nQueryIndex = 0;
		WebRowSet web = null;
		int j=0;
		String strDeptCode="",strBillingMode="",strBillingModeName="",strDeptName="";
		try {

			dao = new HisDAO("dossier", "DossierMstDAO");
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.view.0");

			String strIsValid=vo.getStrIsValid();
			
			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 5, vo.getStrHospCode());
			//dao.setQryValue(nQueryIndex, 6, vo.getStrSeatId());
			dao.setQryValue(nQueryIndex, 6, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 7, vo.getStrServiceTypeID());
			dao.setQryValue(nQueryIndex, 8, strIsValid);
			
			web = dao.executeQry(nQueryIndex);
			if (web.next()) {
				vo.setStrDossierName(web.getString(1));
				vo.setStrServiceTypeName(web.getString(2));
				vo.setStrDossierDescription(web.getString(3));
				strBillingModeName=web.getString(4);
				vo.setStrCurrentDate(web.getString(5));
				vo.setStrIsValid(web.getString(6));
				vo.setStrDossierTotalCost(web.getString(7));
			}	
			
			vo.setStrBillingMode(strBillingModeName);
			
			
			strQuery = dossier.masters.qryHandler_dossier.getQuery(1, "select.dossier.view.deptList.0");

			nQueryIndex = dao.setQuery(strQuery);
			dao.setQryValue(nQueryIndex, 1, strIsValid);
			dao.setQryValue(nQueryIndex, 2, vo.getStrHospCode());
			dao.setQryValue(nQueryIndex, 3, vo.getStrDossierID());
			dao.setQryValue(nQueryIndex, 4, vo.getStrServiceTypeID());

			web = dao.executeQry(nQueryIndex);
			vo.setDeptDetailWS(web);
			
			/*System.out.println("dept code: ---------->>>>>>>"+strDeptCode);
			System.out.println("bill mode: ---------->>>>>>>"+strBillingMode);
			System.out.println("bill mode name: ---------->>>>>>>"+vo.getStrBillingMode());
			System.out.println("dossier name: ----------->>>>>>"+vo.getStrDossierName());
			System.out.println("dossier desc: ----------->>>>>>"+vo.getStrDossierDescription());
			System.out.println("service type name: ----------->>>>>>"+vo.getStrServiceTypeName());
			System.out.println("curr date: ----------->>>>>>"+vo.getStrCurrentDate());
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("DossierMstDAO.view() --> " + e.getMessage());
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
