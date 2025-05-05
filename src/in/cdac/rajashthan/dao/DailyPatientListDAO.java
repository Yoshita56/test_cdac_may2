package in.cdac.rajashthan.dao;

import global.transactionmgnt.HisDAO;
import global.utility.HisUtil;
import in.cdac.rajashthan.bo.PatientDataSet;
import in.cdac.rajashthan.bo.PatientVisitData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.LinkedHashMap;

import javax.sql.rowset.WebRowSet;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.sql.rowset.WebRowSet;


public class DailyPatientListDAO {
	public static String getPatientVisitData(String strServiceID) {
       //public static PatientDataSet getPatientVisitData(String strServiceID,String fromTime,String toTime) {
       //Rajshthan- System.out.println("fromTime :"+fromTime);
       //Rajshthan - System.out.println("toTime :"+toTime);
		//System.out.println("Calling..Service");
    	String err = "";
        String proc_name1 = "{call PKG_WEBSERVICES.getTodayVisitedPatientData(?,?,?,?)}";
    	//String proc_name1 = "{call PKG_WEBSERVICES.getTodayVisitedPatientData(?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
        JSONObject mainObj1 = new JSONObject();
        JSONArray ja = new JSONArray();
        ArrayList<String> columnlist = new ArrayList<String>();
        ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
        int length=0;
        try {
            dao = new HisDAO("WebServices", "DailyPatientListDAO.getTodayVisitedPatientData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1");
            dao.setProcInValue(procIndex1, "hosp_code", "101");
          //  dao.setProcInValue(procIndex1, "fromTime", fromTime);  //added
          //  dao.setProcInValue(procIndex1, "toTime", toTime);   //added
            dao.setProcOutValue(procIndex1, "err", 1);
            dao.setProcOutValue(procIndex1, "resultset", 2);
            //System.out.println("calling proced..");
            dao.executeProcedure(procIndex1);
            err = dao.getString(procIndex1, "err");
            if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				//for(int i=1;i<=length;i++)
				//{
					columnlist.add("patientID");
					columnlist.add("ninID");
					columnlist.add("visitID");
					columnlist.add("patientName");
					columnlist.add("mobile");
					columnlist.add("landline");
					columnlist.add("visitDate");
					columnlist.add("departmentID");
					columnlist.add("patientTypeID");
					columnlist.add("gender");
					columnlist.add("age");
					columnlist.add("visitTime");
					
				//}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                JSONObject js=new JSONObject();
                LinkedHashMap ls=new LinkedHashMap<>();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		//String value=ws.getString(i);
                		//js.put(key, value);
                		//System.out.println("ws.getMetaData().getColumnType(i)"+ws.getMetaData().getColumnTypeName(i)+"key::   "+key);
                		if(ws.getMetaData().getColumnTypeName(i).equalsIgnoreCase("numeric")||ws.getMetaData().getColumnTypeName(i).equalsIgnoreCase("number"))
                		{
                			//System.out.println(ws.getLong(i));
                			//js.put(key, ws.getLong(i));	
                			ls.put(key, ws.getLong(i));
                		}else{
                			//js.put(key, ws.getString(i));
                			ls.put(key, ws.getString(i));
                		}
                	}
                	//System.out.println(ls.toString());
                	jsonolist.add(new JSONObject(ls)) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
         //System.out.println("jsonolist"+jsonolist.size());
          mainObj.put("source", "CDAC");
          if(jsonolist.size() > 0){
          mainObj.put("data", jsonolist);
          }
          else{
        	  mainObj.put("data", "No Record found");
          }
          mainObj1.put("patientVisitData", mainObj);
          //System.out.println(mainObj1);
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	} 
             /*----- Comment By Ashutosh Pandey To Convert Xml into JSON-------*/
           /*System.out.println("ws"+ws.size());
            
            if (ws != null && ws.size() > 0) {
                ArrayList<PatientVisitData> patientVisitData = new ArrayList<PatientVisitData>();
                ws.beforeFirst();
                while (ws.next()) {
                    patientVisitData.add(new PatientVisitData(ws.getString(1), ws.getString(2), ws.getString(3), ws.getString(4), ws.getString(5), ws.getString(6), ws.getString(7), ws.getString(8), ws.getString(9), ws.getString(10), ws.getString(11), ws.getString(12), ws.getString(13)));
                }
                PatientDataSet patientDataSet = new PatientDataSet(patientVisitData, "", DailyPatientListDAO.getCurrentTime());
                return patientDataSet;
            }
            PatientDataSet patientDataSet = new PatientDataSet("No Patient List", DailyPatientListDAO.getCurrentTime());
            
            if(ws != null){
        		ws.close();
        		ws = null;
        	}*/
            
            return mainObj1.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        finally {
        	
        	
        	
            if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }

    public static String getCurrentTime() {

		HisUtil util = null;

		try {
             util = new HisUtil("CreateUserLogDao", "getCurrentTime");
			 return util.getDSDate("YYYY-MM-DD HH24:mi:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			return util.getASDate("YYYY-MM-DD HH24:mi:ss");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                 return new SimpleDateFormat("YYYY-MM-DD HH24:mi:ss").format(new Date());

	}
}