package in.cdac.invWebServices.general.dao;



import hisglobal.transactionmgnt.HisDAO;
import in.cdac.invWebServices.general.vo.District;
import in.cdac.invWebServices.general.vo.Gender;
import in.cdac.invWebServices.general.vo.Hospital;
import in.cdac.invWebServices.general.vo.InvestigationData;
import in.cdac.invWebServices.general.vo.ParaRawDetails;
import in.cdac.invWebServices.general.vo.ParamDetails;
import in.cdac.invWebServices.general.vo.RawData;
import in.cdac.invWebServices.general.vo.Report;
import in.cdac.invWebServices.general.vo.State;
import in.cdac.invWebServices.global.util.GlobalUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;



public class GeneralDao {

	private String propertiesFileName = "in.cdac.mhealth.query";
	
	public List<Gender> getGenderList(){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GENERAL.Gender_List.1";
		List<Gender> lst = new ArrayList<Gender>();
		lst.add(new Gender("-1", "Select Gender"));
		try {
			String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			rs =  stmt.executeQuery();
			while (rs.next()) {
				lst.add(new Gender(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
public List<Report> getReportList(String crNo,String hosCode){
		
	//	System.out.println("Calling..Service");
    	String err = "";
    	String status="";
        String proc_name1 = "{call pkg_webservices_inv.getreportdetails(?,?,?,?)}";
		
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
		/*Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GET_REPORT_DETAIL_INVESTIGATION";*/
		List<Report> lst = new ArrayList<Report>();
		//lst.add(new Gender("-1", "Select Gender"));
		try {
			/*String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setString(1, hosCode);
			stmt.setString(2, crNo);
			stmt.setString(3, hosCode);*/
			
			dao = new HisDAO("WebServices", "GeneralDao.getreportdetails()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "crno", crNo,1);
            dao.setProcInValue(procIndex1, "hosp_code", hosCode,2);
            dao.setProcOutValue(procIndex1, "err", 1,3);
            dao.setProcOutValue(procIndex1, "resultset",2, 4);
            //System.out.println("calling proced..");
            //dao.executeProcedure(procIndex1);
            //dao.executeProcedureByPosition
            
            dao.executeProcedureByPosition(procIndex1);

			//strErr = dao.getString(proc_name1, "err");

			//wsResult = dao.getWebRowSet(procIndex1, "resultset");
            err = dao.getString(procIndex1, "err");
			
            if (err == null) {
                err = "";
            }
            
            if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
            	 ws.beforeFirst();
                 while (ws.next()) {
                	 lst.add(new Report(ws.getString(1), ws.getString(2),ws.getString(3)));
                 }
            }
            
			/*rs =  stmt.executeQuery();
			while (rs.next()) {
				lst.add(new Report(rs.getString(1), rs.getString(2),rs.getString(3)));
			}*/
		} catch (Exception e) {
            e.printStackTrace();
           // return "error";
        } finally {
			try {
				if(ws != null){
	        		ws.close();
	        		ws = null;
	        	}if (dao != null) {
	                dao.free();
	                dao = null;
	            }   
				
				/*if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	
	public List<InvestigationData> getInvestigationList(String crNo,String hosCode){
		
	//	System.out.println("Calling..Service");
    	String err = "";
    	String status="";
        String proc_name1 = "{call pkg_webservices_inv.getreportrawdata(?,?,?,?)}";
		
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
		/*Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GET_INVESTIGATION_DATA";*/
		List<InvestigationData> lst = new ArrayList<InvestigationData>();
		//lst.add(new Gender("-1", "Select Gender"));
		String tempTestCode = null;
		String tempEntryDate = null;
		List<ParamDetails> param = null;
		
		try {
			/*String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setString(1, hosCode);
			stmt.setString(2, crNo);
			rs =  stmt.executeQuery();*/
			
			dao = new HisDAO("WebServices", "GeneralDao.getreportrawdata()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "crno", crNo,1);
            dao.setProcInValue(procIndex1, "hosp_code", hosCode,2);
            dao.setProcOutValue(procIndex1, "err", 1,3);
            dao.setProcOutValue(procIndex1, "resultset",2, 4);
			
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
			
            
            if (err == null) {
                err = "";
            }
            
            if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
           	 ws.beforeFirst();
                while (ws.next()) {

                	if(tempTestCode != null && tempTestCode.equals(ws.getString(1)) && tempEntryDate != null && tempEntryDate.equals(ws.getString(7))){
    					ParamDetails p = new ParamDetails(ws.getString(4),ws.getString(5) ,ws.getString(6),ws.getString(3));
    					param.add(p);
    				}else{
    					param = new ArrayList<ParamDetails>();
    					tempTestCode = ws.getString(1);
    					tempEntryDate = ws.getString(7);
    					ParamDetails p = new ParamDetails(ws.getString(4),ws.getString(5) ,ws.getString(6),ws.getString(3));
    					param.add(p);
    					lst.add(new InvestigationData(ws.getString(2), ws.getString(7),param));
    				}
                	
                }
           }
            
			/*while (rs.next()) {
				
				if(tempTestCode != null && tempTestCode.equals(rs.getString(1)) && tempEntryDate != null && tempEntryDate.equals(rs.getString(7))){
					ParamDetails p = new ParamDetails(rs.getString(4),rs.getString(5) ,rs.getString(6));
					param.add(p);
				}else{
					param = new ArrayList<ParamDetails>();
					tempTestCode = rs.getString(1);
					tempEntryDate = rs.getString(7);
					ParamDetails p = new ParamDetails(rs.getString(4),rs.getString(5) ,rs.getString(6));
					param.add(p);
					lst.add(new InvestigationData(rs.getString(2), rs.getString(7),param));
				}
				
			}*/
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				/*if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();*/
				if(ws != null){
	        		ws.close();
	        		ws = null;
	        	}if (dao != null) {
	                dao.free();
	                dao = null;
	            } 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public List<State> getStateNames(String countryCode) {
		List<State> lst = new ArrayList<State>();
		lst.add(new State(-1, "Select State"));
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GENERAL.State_List.1";
		try {
			String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setString(1, countryCode);
			rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new State(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public List<District> getDistrictNames(int stateId){
		List<District> lst = new ArrayList<District>();
		lst.add(new District(-1, "Select District"));
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GENERAL.District_List.1";
		try {
			String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setInt(1, stateId);
			rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new District(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public List<Hospital> getHospitalList() {
		List<Hospital> lst = new ArrayList<Hospital>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GLOBAL_SERVICE.Hospital_List.1";
		try {
			String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			rs =  stmt.executeQuery();
			while (rs.next()){
				lst.add(new Hospital(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*lst.add(new Hospital("NIMS-33101", "Nizam's Institute Of Medical Sciences"));
		lst.add(new Hospital("TEL-33105", "GANDHI  HOSPITAL"));
		lst.add(new Hospital("TEL-33106", "M. NAGARJUNA  AREA HOSPITAL"));
		lst.add(new Hospital("TEL-33107", "District Hospital King Koti"));*/
		return lst;
	}
	
	public String getFilename(String crNo,String reqDNo,String hosCode){
		
	//	System.out.println("Calling..Service");
    	String err = "";
    	String status="";
        String proc_name1 = "{call pkg_webservices_inv.getreportfilename(?,?,?,?)}";
		
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
		
		String Filename="";
		/*Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;*/
		try{
		/*String queryKey = "SELECT_FILENAME_FOR_REPORT_WEBSERVICE";

		String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
		con = GlobalUtils.getNimsConnection();		
		stmt = con.prepareStatement(query);
		stmt.setString(1, reqDNo);
		stmt.setString(2, hosCode);
		rs =  stmt.executeQuery();*/
			
			
		dao = new HisDAO("WebServices", "GeneralDao.getreportfilename()");
        procIndex1 = dao.setProcedure(proc_name1);
        dao.setProcInValue(procIndex1, "reqdno", reqDNo,1);
        dao.setProcInValue(procIndex1, "hosp_code", hosCode,2);
        dao.setProcOutValue(procIndex1, "err", 1,3);
        dao.setProcOutValue(procIndex1, "resultset",2, 4);
			
        dao.executeProcedureByPosition(procIndex1);
        err = dao.getString(procIndex1, "err");
			
        if (err == null) {
            err = "";
        }
            			
        if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
       	 ws.beforeFirst();
            while (ws.next()) {
            	Filename=ws.getString(1);
            }
       }
       /*while (rs.next()) {
			
			Filename=rs.getString(1);
       }*/
       
       
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				
				if(ws != null){
	        		ws.close();
	        		ws = null;
	        	}if (dao != null) {
	                dao.free();
	                dao = null;
	            } 
				
				/*if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();*/
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Filename;
	}
	
	public List<RawData> getParaRawData(String crNo,String hosCode,String paraCode){
		
	//	System.out.println("Calling..Service");
    	String err = "";
    	String status="";
        String proc_name1 = "{call pkg_webservices_inv.getpararawdata(?,?,?,?,?)}";
		
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
		
		/*Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		String queryKey = "GET_PARA_RAW_DATA";*/
        
        
		List<RawData> lst = new ArrayList<RawData>();
		//lst.add(new Gender("-1", "Select Gender"));
		String tempParameterCode = null;
		String tempParameterName = null;
		List<ParaRawDetails> raw = null;
		
		try {
			/*String query = GlobalUtils.getQueryFromPropertiesFile(propertiesFileName, queryKey);
			con = GlobalUtils.getNimsConnection();		
			stmt = con.prepareStatement(query);
			stmt.setString(1, hosCode);
			stmt.setString(2, crNo);
			rs =  stmt.executeQuery();*/
			
			dao = new HisDAO("WebServices", "GeneralDao.getpararawdata()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "crno", crNo,1);
            dao.setProcInValue(procIndex1, "hosp_code", hosCode,2);
            dao.setProcInValue(procIndex1, "para_code", paraCode,3);
            dao.setProcOutValue(procIndex1, "err", 1,4);
            dao.setProcOutValue(procIndex1, "resultset",2, 5);
			
            dao.executeProcedureByPosition(procIndex1);
            err = dao.getString(procIndex1, "err");
			
            
            if (err == null) {
                err = "";
            }
			
            if ((ws = dao.getWebRowSet(procIndex1, "resultset")) != null && ws.size() > 0) {
              	 ws.beforeFirst();
                   while (ws.next()) {

                	   if(tempParameterCode != null && tempParameterCode.equals(ws.getString(3)) && tempParameterName != null && tempParameterName.equals(ws.getString(4))){
       					ParaRawDetails p = new ParaRawDetails(ws.getString(7),ws.getString(2),ws.getString(5),ws.getString(6));
       					raw.add(p);
       				}else{
       					raw = new ArrayList<>();
       					tempParameterCode = ws.getString(3);
       					tempParameterName = ws.getString(4);
       					ParaRawDetails p = new ParaRawDetails(ws.getString(7),ws.getString(2) ,ws.getString(5),ws.getString(6));
       					raw.add(p);
       					lst.add(new RawData(ws.getString(4),raw));
       				}
                   	
                   }
              }
            
			/*while (rs.next()) {
				
				if(tempParameterCode != null && tempParameterCode.equals(rs.getString(3)) && tempParameterName != null && tempParameterName.equals(rs.getString(4))){
					ParaRawDetails p = new ParaRawDetails(rs.getString(7),rs.getString(2),rs.getString(5),rs.getString(6));
					raw.add(p);
				}else{
					raw = new ArrayList<>();
					tempParameterCode = rs.getString(3);
					tempParameterName = rs.getString(4);
					ParaRawDetails p = new ParaRawDetails(rs.getString(7),rs.getString(2) ,rs.getString(5),rs.getString(6));
					raw.add(p);
					lst.add(new RawData(rs.getString(4),raw));
				}	
			}*/
			
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				/*if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();				
				if (con != null) 
					con.close();*/
				
				if(ws != null){
	        		ws.close();
	        		ws = null;
	        	}if (dao != null) {
	                dao.free();
	                dao = null;
	            } 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	
}
